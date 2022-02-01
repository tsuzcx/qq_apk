package com.tencent.mobileqq.app;

import AccostSvc.Msg;
import AccostSvc.RespClientMsg;
import NS_MOBILE_MAIN_PAGE.mobile_sub_get_cover_rsp;
import QQService.CARDSETTYPE;
import QQService.PushVoteIncreaseInfo;
import QQService.RespDelFace;
import QQService.RespDeleteVisitorRecord;
import QQService.RespFavorite;
import QQService.RespGetCardSwitch;
import QQService.RespGetFavoriteList;
import QQService.RespGetVoterList;
import QQService.RespHead;
import QQService.RespSetCard;
import QQService.RespSetCardSwitch;
import QQService.UserCntlData;
import QQService.UserProfile;
import QQService.Visitor;
import SummaryCard.TMedalWallInfo;
import SummaryCardTaf.SSummaryCardLableRsp;
import SummaryCardTaf.SSummaryCardRsp;
import SummaryCardTaf.SUserLabel;
import SummaryCardTaf.cardDiyComplicatedInfo;
import SummaryCardTaf.cardDiyTextInfo;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.util.SparseArray;
import com.tencent.biz.now.NowLiveManager;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.chat.MessageNotificationSettingManager;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.CardProfile;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.LikeRankingInfo;
import com.tencent.mobileqq.data.MedalInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QZoneCover;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.managers.TempMsgManager;
import com.tencent.mobileqq.medalwall.MedalID;
import com.tencent.mobileqq.medalwall.MedalWallMng;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.INearByGeneralManager;
import com.tencent.mobileqq.nearby.NearbyManagerHelper;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusManagerService;
import com.tencent.mobileqq.onlinestatus.manager.IAutoReplyManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.profile.SchoolInfo;
import com.tencent.mobileqq.profile.upload.VipUploadUtils;
import com.tencent.mobileqq.profilecard.api.IProfileProtocolService;
import com.tencent.mobileqq.profilecard.entity.ProfileLabelInfo;
import com.tencent.mobileqq.profilecard.observer.ICardObserver;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessagePBElemDecoder;
import com.tencent.mobileqq.service.message.MessageProtoCodec;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.util.VoteUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadConfig;
import com.tencent.upload.uinterface.IUploadService;
import com.tencent.upload.uinterface.UploadServiceBuilder;
import com.tencent.upload.uinterface.data.PhotoWallUploadTask;
import cooperation.qzone.UploadEnv;
import java.io.File;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.Vector;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.medal.common.MedalInfo;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.ReqBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.RspBody;
import tencent.im.oidb.cmd0x5eb.oidb_0x5eb.UdcUinData;
import tencent.im.oidb.cmd0x66b.Oidb_0x66b.ReqBody;
import tencent.im.oidb.cmd0x66b.Oidb_0x66b.RspBody;
import tencent.im.oidb.cmd0x66b.Oidb_0x66b.RspPansocialInfo;
import tencent.im.oidb.cmd0x7a8.ReqBody;
import tencent.im.oidb.cmd0x7a8.RspBody;
import tencent.im.oidb.cmd0x7ba.oidb_0x7ba.PraiseInfo;
import tencent.im.oidb.cmd0x7ba.oidb_0x7ba.ReqBody;
import tencent.im.oidb.cmd0x7ba.oidb_0x7ba.RspBody;
import tencent.im.oidb.cmd0x922.cmd0x922.ReqBody;
import tencent.im.oidb.cmd0xa28.oidb_0xa28.ReqBody;
import tencent.im.oidb.cmd0xac6.MedalReport;
import tencent.im.oidb.cmd0xac6.ReqBody;
import tencent.im.oidb.cmd0xac6.RspBody;
import tencent.im.oidb.cmd0xac6.operate_result;
import tencent.im.oidb.cmd0xcd5.oidb_cmd0xcd5.GetDataReq;
import tencent.im.oidb.cmd0xcd5.oidb_cmd0xcd5.GetDataRsp;
import tencent.im.oidb.cmd0xcd5.oidb_cmd0xcd5.ReqBody;
import tencent.im.oidb.cmd0xcd5.oidb_cmd0xcd5.RspBody;
import tencent.im.oidb.cmd0xcd5.oidb_cmd0xcd5.SetDataReq;
import tencent.im.oidb.cmd0xcd5.oidb_cmd0xcd5.SetDataRsp;
import tencent.im.oidb.cmd0xd2d.oidb_cmd0xd2d.EduHis;
import tencent.im.oidb.cmd0xd2d.oidb_cmd0xd2d.ReqBody;
import tencent.im.oidb.cmd0xd2d.oidb_cmd0xd2d.RspBody;
import tencent.im.oidb.cmd0xd2d.oidb_cmd0xd2d.SchoolInfo;
import tencent.im.oidb.cmd0xd8a.ClientInfo;
import tencent.im.oidb.cmd0xd8a.ReqBody;
import tencent.im.oidb.cmd0xe26.oidb_0xe26.ReqBody;
import tencent.im.oidb.oidb_0xc33.ReqBody;
import tencent.im.oidb.oidb_0xc33.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.storage.wording_storage.WordingCfg;

public class CardHandler
  extends BusinessHandler
{
  public static final String a;
  public static final Vector<Integer> a;
  public static final Vector<Integer> b;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private ITransFileController jdField_a_of_type_ComTencentMobileqqTransfileApiITransFileController = null;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  short jdField_a_of_type_Short = 9;
  protected String b;
  short b;
  private String c;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(AppConstants.SDCARD_PATH);
    localStringBuilder.append("portrait/");
    jdField_a_of_type_JavaLangString = VFSAssistantUtils.getSDKPrivatePath(localStringBuilder.toString());
    jdField_a_of_type_JavaUtilVector = new Vector();
    jdField_b_of_type_JavaUtilVector = new Vector();
  }
  
  public CardHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_b_of_type_Short = -23461;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramQQAppInterface;
    int i = jdField_a_of_type_JavaUtilVector.size();
    paramQQAppInterface = Integer.valueOf(640);
    Integer localInteger1 = Integer.valueOf(160);
    Integer localInteger2 = Integer.valueOf(100);
    Integer localInteger3 = Integer.valueOf(60);
    Integer localInteger4 = Integer.valueOf(0);
    if (i == 0)
    {
      jdField_a_of_type_JavaUtilVector.add(localInteger4);
      jdField_a_of_type_JavaUtilVector.add(localInteger3);
      jdField_a_of_type_JavaUtilVector.add(localInteger2);
      jdField_a_of_type_JavaUtilVector.add(localInteger1);
      jdField_a_of_type_JavaUtilVector.add(paramQQAppInterface);
    }
    if (jdField_b_of_type_JavaUtilVector.size() == 0)
    {
      jdField_b_of_type_JavaUtilVector.add(localInteger4);
      jdField_a_of_type_JavaUtilVector.add(localInteger3);
      jdField_a_of_type_JavaUtilVector.add(localInteger2);
      jdField_a_of_type_JavaUtilVector.add(localInteger1);
      jdField_a_of_type_JavaUtilVector.add(paramQQAppInterface);
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(960));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(120));
    }
  }
  
  /* Error */
  private void A(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 101	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: ifeq +13 -> 17
    //   7: aload_3
    //   8: ifnull +9 -> 17
    //   11: iconst_1
    //   12: istore 7
    //   14: goto +6 -> 20
    //   17: iconst_0
    //   18: istore 7
    //   20: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   23: ifeq +35 -> 58
    //   26: new 20	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   33: astore_2
    //   34: aload_2
    //   35: ldc 108
    //   37: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: pop
    //   41: aload_2
    //   42: iload 7
    //   44: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: ldc 113
    //   50: iconst_2
    //   51: aload_2
    //   52: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   58: iload 7
    //   60: istore 5
    //   62: iload 7
    //   64: ifeq +512 -> 576
    //   67: iload 7
    //   69: istore 8
    //   71: iload 7
    //   73: istore 6
    //   75: new 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   78: dup
    //   79: invokespecial 120	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   82: aload_3
    //   83: checkcast 122	[B
    //   86: checkcast 122	[B
    //   89: invokevirtual 126	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   92: checkcast 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   95: astore_2
    //   96: aload_2
    //   97: ifnull +510 -> 607
    //   100: iload 7
    //   102: istore 8
    //   104: iload 7
    //   106: istore 6
    //   108: aload_2
    //   109: getfield 130	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   112: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   115: ifne +492 -> 607
    //   118: iconst_1
    //   119: istore 7
    //   121: goto +3 -> 124
    //   124: iload 7
    //   126: istore 8
    //   128: iload 7
    //   130: istore 6
    //   132: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   135: ifeq +67 -> 202
    //   138: iload 7
    //   140: istore 8
    //   142: iload 7
    //   144: istore 6
    //   146: new 20	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   153: astore_3
    //   154: iload 7
    //   156: istore 8
    //   158: iload 7
    //   160: istore 6
    //   162: aload_3
    //   163: ldc 137
    //   165: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: pop
    //   169: iload 7
    //   171: istore 8
    //   173: iload 7
    //   175: istore 6
    //   177: aload_3
    //   178: iload 7
    //   180: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: iload 7
    //   186: istore 8
    //   188: iload 7
    //   190: istore 6
    //   192: ldc 113
    //   194: iconst_2
    //   195: aload_3
    //   196: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   202: iload 7
    //   204: istore 5
    //   206: iload 7
    //   208: ifeq +368 -> 576
    //   211: iload 7
    //   213: istore 8
    //   215: iload 7
    //   217: istore 6
    //   219: iload 7
    //   221: istore 5
    //   223: aload_2
    //   224: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   227: invokevirtual 146	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   230: ifeq +346 -> 576
    //   233: iload 7
    //   235: istore 8
    //   237: iload 7
    //   239: istore 6
    //   241: iload 7
    //   243: istore 5
    //   245: aload_2
    //   246: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   249: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   252: ifnull +324 -> 576
    //   255: iload 7
    //   257: istore 8
    //   259: iload 7
    //   261: istore 6
    //   263: aload_2
    //   264: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   267: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   270: invokevirtual 155	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   273: invokestatic 161	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   276: invokevirtual 164	java/nio/ByteBuffer:getInt	()I
    //   279: istore 4
    //   281: iload 4
    //   283: ifge +330 -> 613
    //   286: iload 4
    //   288: i2l
    //   289: ldc2_w 165
    //   292: ladd
    //   293: lstore 9
    //   295: goto +3 -> 298
    //   298: iload 7
    //   300: istore 8
    //   302: iload 7
    //   304: istore 6
    //   306: aload_0
    //   307: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   310: invokevirtual 171	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   313: lload 9
    //   315: invokestatic 176	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   318: invokevirtual 179	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   321: ifeq +86 -> 407
    //   324: iload 7
    //   326: istore 8
    //   328: iload 7
    //   330: istore 6
    //   332: aload_0
    //   333: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   336: getstatic 185	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   339: invokevirtual 189	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   342: checkcast 191	com/tencent/mobileqq/app/FriendsManager
    //   345: astore_2
    //   346: iload 7
    //   348: istore 8
    //   350: iload 7
    //   352: istore 6
    //   354: aload_2
    //   355: aload_0
    //   356: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   359: invokevirtual 171	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   362: invokevirtual 194	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   365: astore_3
    //   366: iload 7
    //   368: istore 8
    //   370: iload 7
    //   372: istore 6
    //   374: aload_3
    //   375: aload_1
    //   376: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   379: ldc 202
    //   381: invokevirtual 208	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   384: putfield 214	com/tencent/mobileqq/data/Card:allowPeopleSee	Z
    //   387: iload 7
    //   389: istore 8
    //   391: iload 7
    //   393: istore 6
    //   395: aload_2
    //   396: aload_3
    //   397: invokevirtual 217	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   400: pop
    //   401: iconst_1
    //   402: istore 5
    //   404: goto +172 -> 576
    //   407: iconst_0
    //   408: istore 5
    //   410: goto +166 -> 576
    //   413: astore_2
    //   414: goto +101 -> 515
    //   417: astore_2
    //   418: iload 6
    //   420: istore 8
    //   422: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   425: ifeq +16 -> 441
    //   428: iload 6
    //   430: istore 8
    //   432: ldc 113
    //   434: iconst_2
    //   435: ldc 219
    //   437: aload_2
    //   438: invokestatic 222	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   441: iload 6
    //   443: istore 7
    //   445: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   448: ifeq +149 -> 597
    //   451: new 20	java/lang/StringBuilder
    //   454: dup
    //   455: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   458: astore_2
    //   459: iload 6
    //   461: istore 5
    //   463: aload_2
    //   464: ldc 137
    //   466: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: pop
    //   470: aload_2
    //   471: iload 5
    //   473: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   476: pop
    //   477: aload_2
    //   478: ldc 224
    //   480: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: pop
    //   484: aload_2
    //   485: aload_1
    //   486: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   489: ldc 202
    //   491: invokevirtual 208	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   494: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   497: pop
    //   498: ldc 113
    //   500: iconst_2
    //   501: aload_2
    //   502: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   505: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   508: iload 5
    //   510: istore 7
    //   512: goto +85 -> 597
    //   515: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   518: ifeq +56 -> 574
    //   521: new 20	java/lang/StringBuilder
    //   524: dup
    //   525: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   528: astore_3
    //   529: aload_3
    //   530: ldc 137
    //   532: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   535: pop
    //   536: aload_3
    //   537: iload 8
    //   539: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   542: pop
    //   543: aload_3
    //   544: ldc 224
    //   546: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   549: pop
    //   550: aload_3
    //   551: aload_1
    //   552: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   555: ldc 202
    //   557: invokevirtual 208	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   560: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   563: pop
    //   564: ldc 113
    //   566: iconst_2
    //   567: aload_3
    //   568: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   571: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   574: aload_2
    //   575: athrow
    //   576: iload 5
    //   578: istore 7
    //   580: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   583: ifeq +14 -> 597
    //   586: new 20	java/lang/StringBuilder
    //   589: dup
    //   590: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   593: astore_2
    //   594: goto -131 -> 463
    //   597: aload_0
    //   598: bipush 45
    //   600: iload 7
    //   602: aconst_null
    //   603: invokevirtual 228	com/tencent/mobileqq/app/CardHandler:notifyUI	(IZLjava/lang/Object;)V
    //   606: return
    //   607: iconst_0
    //   608: istore 7
    //   610: goto -486 -> 124
    //   613: iload 4
    //   615: i2l
    //   616: lstore 9
    //   618: goto -320 -> 298
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	621	0	this	CardHandler
    //   0	621	1	paramToServiceMsg	ToServiceMsg
    //   0	621	2	paramFromServiceMsg	FromServiceMsg
    //   0	621	3	paramObject	Object
    //   279	335	4	i	int
    //   60	517	5	bool1	boolean
    //   73	387	6	bool2	boolean
    //   12	597	7	bool3	boolean
    //   69	469	8	bool4	boolean
    //   293	324	9	l	long
    // Exception table:
    //   from	to	target	type
    //   75	96	413	finally
    //   108	118	413	finally
    //   132	138	413	finally
    //   146	154	413	finally
    //   162	169	413	finally
    //   177	184	413	finally
    //   192	202	413	finally
    //   223	233	413	finally
    //   245	255	413	finally
    //   263	281	413	finally
    //   306	324	413	finally
    //   332	346	413	finally
    //   354	366	413	finally
    //   374	387	413	finally
    //   395	401	413	finally
    //   422	428	413	finally
    //   432	441	413	finally
    //   75	96	417	java/lang/Exception
    //   108	118	417	java/lang/Exception
    //   132	138	417	java/lang/Exception
    //   146	154	417	java/lang/Exception
    //   162	169	417	java/lang/Exception
    //   177	184	417	java/lang/Exception
    //   192	202	417	java/lang/Exception
    //   223	233	417	java/lang/Exception
    //   245	255	417	java/lang/Exception
    //   263	281	417	java/lang/Exception
    //   306	324	417	java/lang/Exception
    //   332	346	417	java/lang/Exception
    //   354	366	417	java/lang/Exception
    //   374	387	417	java/lang/Exception
    //   395	401	417	java/lang/Exception
  }
  
  /* Error */
  private void B(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 101	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: istore 5
    //   6: iconst_1
    //   7: istore 10
    //   9: iconst_1
    //   10: istore 9
    //   12: iload 5
    //   14: ifeq +13 -> 27
    //   17: aload_3
    //   18: ifnull +9 -> 27
    //   21: iconst_1
    //   22: istore 5
    //   24: goto +6 -> 30
    //   27: iconst_0
    //   28: istore 5
    //   30: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   33: ifeq +35 -> 68
    //   36: new 20	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   43: astore_2
    //   44: aload_2
    //   45: ldc 231
    //   47: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload_2
    //   52: iload 5
    //   54: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   57: pop
    //   58: ldc 113
    //   60: iconst_2
    //   61: aload_2
    //   62: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   68: iload 5
    //   70: istore 8
    //   72: iload 5
    //   74: ifeq +631 -> 705
    //   77: iload 5
    //   79: istore 6
    //   81: iload 5
    //   83: istore 7
    //   85: new 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   88: dup
    //   89: invokespecial 120	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   92: aload_3
    //   93: checkcast 122	[B
    //   96: checkcast 122	[B
    //   99: invokevirtual 126	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   102: checkcast 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   105: astore_2
    //   106: aload_2
    //   107: ifnull +712 -> 819
    //   110: iload 5
    //   112: istore 6
    //   114: iload 5
    //   116: istore 7
    //   118: aload_2
    //   119: getfield 130	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   122: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   125: ifne +694 -> 819
    //   128: iconst_1
    //   129: istore 5
    //   131: goto +3 -> 134
    //   134: iload 5
    //   136: istore 6
    //   138: iload 5
    //   140: istore 7
    //   142: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   145: ifeq +67 -> 212
    //   148: iload 5
    //   150: istore 6
    //   152: iload 5
    //   154: istore 7
    //   156: new 20	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   163: astore_3
    //   164: iload 5
    //   166: istore 6
    //   168: iload 5
    //   170: istore 7
    //   172: aload_3
    //   173: ldc 233
    //   175: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: pop
    //   179: iload 5
    //   181: istore 6
    //   183: iload 5
    //   185: istore 7
    //   187: aload_3
    //   188: iload 5
    //   190: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   193: pop
    //   194: iload 5
    //   196: istore 6
    //   198: iload 5
    //   200: istore 7
    //   202: ldc 113
    //   204: iconst_2
    //   205: aload_3
    //   206: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   209: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   212: iload 5
    //   214: istore 8
    //   216: iload 5
    //   218: ifeq +487 -> 705
    //   221: iload 5
    //   223: istore 6
    //   225: iload 5
    //   227: istore 7
    //   229: iload 5
    //   231: istore 8
    //   233: aload_2
    //   234: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   237: invokevirtual 146	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   240: ifeq +465 -> 705
    //   243: iload 5
    //   245: istore 6
    //   247: iload 5
    //   249: istore 7
    //   251: iload 5
    //   253: istore 8
    //   255: aload_2
    //   256: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   259: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   262: ifnull +443 -> 705
    //   265: iload 5
    //   267: istore 6
    //   269: iload 5
    //   271: istore 7
    //   273: aload_2
    //   274: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   277: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   280: invokevirtual 155	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   283: invokestatic 161	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   286: invokevirtual 164	java/nio/ByteBuffer:getInt	()I
    //   289: istore 4
    //   291: iload 4
    //   293: ifge +532 -> 825
    //   296: iload 4
    //   298: i2l
    //   299: ldc2_w 165
    //   302: ladd
    //   303: lstore 11
    //   305: goto +3 -> 308
    //   308: iload 5
    //   310: istore 6
    //   312: iload 5
    //   314: istore 7
    //   316: aload_0
    //   317: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   320: invokevirtual 171	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   323: lload 11
    //   325: invokestatic 176	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   328: invokevirtual 179	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   331: ifeq +207 -> 538
    //   334: iload 5
    //   336: istore 6
    //   338: iload 5
    //   340: istore 7
    //   342: aload_0
    //   343: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   346: getstatic 185	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   349: invokevirtual 189	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   352: checkcast 191	com/tencent/mobileqq/app/FriendsManager
    //   355: astore_2
    //   356: iload 5
    //   358: istore 6
    //   360: iload 5
    //   362: istore 7
    //   364: aload_2
    //   365: aload_0
    //   366: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   369: invokevirtual 171	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   372: invokevirtual 194	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   375: astore_3
    //   376: iload 5
    //   378: istore 6
    //   380: iload 5
    //   382: istore 7
    //   384: aload_3
    //   385: aload_1
    //   386: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   389: ldc 202
    //   391: invokevirtual 208	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   394: putfield 236	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   397: iload 5
    //   399: istore 6
    //   401: iload 5
    //   403: istore 7
    //   405: aload_2
    //   406: aload_3
    //   407: invokevirtual 217	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   410: pop
    //   411: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   414: ifeq +41 -> 455
    //   417: new 20	java/lang/StringBuilder
    //   420: dup
    //   421: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   424: astore 13
    //   426: aload 13
    //   428: ldc 238
    //   430: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: pop
    //   434: aload 13
    //   436: aload_3
    //   437: getfield 236	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   440: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   443: pop
    //   444: ldc 240
    //   446: iconst_2
    //   447: aload 13
    //   449: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   452: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   455: aload_3
    //   456: getfield 236	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   459: ifeq +11 -> 470
    //   462: aload_2
    //   463: iconst_1
    //   464: putfield 243	com/tencent/mobileqq/app/FriendsManager:q	I
    //   467: goto +8 -> 475
    //   470: aload_2
    //   471: iconst_0
    //   472: putfield 243	com/tencent/mobileqq/app/FriendsManager:q	I
    //   475: aload_0
    //   476: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   479: invokevirtual 247	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   482: aload_0
    //   483: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   486: invokevirtual 171	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   489: iconst_0
    //   490: invokevirtual 253	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   493: invokeinterface 259 1 0
    //   498: ldc_w 261
    //   501: aload_2
    //   502: getfield 243	com/tencent/mobileqq/app/FriendsManager:q	I
    //   505: invokeinterface 267 3 0
    //   510: invokeinterface 270 1 0
    //   515: pop
    //   516: iload 10
    //   518: istore 5
    //   520: goto +189 -> 709
    //   523: astore_2
    //   524: iconst_1
    //   525: istore 6
    //   527: goto +117 -> 644
    //   530: astore_2
    //   531: iload 9
    //   533: istore 5
    //   535: goto +18 -> 553
    //   538: iconst_0
    //   539: istore 5
    //   541: goto +168 -> 709
    //   544: astore_2
    //   545: goto +99 -> 644
    //   548: astore_2
    //   549: iload 7
    //   551: istore 5
    //   553: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   556: ifeq +13 -> 569
    //   559: ldc 113
    //   561: iconst_2
    //   562: ldc_w 272
    //   565: aload_2
    //   566: invokestatic 222	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   569: iload 5
    //   571: istore 6
    //   573: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   576: ifeq +154 -> 730
    //   579: new 20	java/lang/StringBuilder
    //   582: dup
    //   583: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   586: astore_2
    //   587: aload_2
    //   588: ldc 233
    //   590: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: pop
    //   594: aload_2
    //   595: iload 5
    //   597: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   600: pop
    //   601: aload_2
    //   602: ldc 224
    //   604: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   607: pop
    //   608: aload_2
    //   609: aload_1
    //   610: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   613: ldc 202
    //   615: invokevirtual 208	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   618: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   621: pop
    //   622: ldc 113
    //   624: iconst_2
    //   625: aload_2
    //   626: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   629: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   632: iload 5
    //   634: istore 6
    //   636: goto +94 -> 730
    //   639: astore_2
    //   640: iload 5
    //   642: istore 6
    //   644: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   647: ifeq +56 -> 703
    //   650: new 20	java/lang/StringBuilder
    //   653: dup
    //   654: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   657: astore_3
    //   658: aload_3
    //   659: ldc 233
    //   661: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   664: pop
    //   665: aload_3
    //   666: iload 6
    //   668: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   671: pop
    //   672: aload_3
    //   673: ldc 224
    //   675: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: pop
    //   679: aload_3
    //   680: aload_1
    //   681: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   684: ldc 202
    //   686: invokevirtual 208	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   689: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   692: pop
    //   693: ldc 113
    //   695: iconst_2
    //   696: aload_3
    //   697: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   700: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   703: aload_2
    //   704: athrow
    //   705: iload 8
    //   707: istore 5
    //   709: iload 5
    //   711: istore 6
    //   713: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   716: ifeq +14 -> 730
    //   719: new 20	java/lang/StringBuilder
    //   722: dup
    //   723: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   726: astore_2
    //   727: goto -140 -> 587
    //   730: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   733: ifeq +76 -> 809
    //   736: aload_0
    //   737: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   740: getstatic 185	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   743: invokevirtual 189	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   746: checkcast 191	com/tencent/mobileqq/app/FriendsManager
    //   749: aload_0
    //   750: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   753: invokevirtual 171	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   756: invokevirtual 194	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   759: astore_1
    //   760: new 20	java/lang/StringBuilder
    //   763: dup
    //   764: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   767: astore_2
    //   768: aload_2
    //   769: ldc 238
    //   771: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   774: pop
    //   775: aload_2
    //   776: aload_1
    //   777: getfield 236	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   780: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   783: pop
    //   784: aload_2
    //   785: ldc_w 274
    //   788: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   791: pop
    //   792: aload_2
    //   793: iload 6
    //   795: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   798: pop
    //   799: ldc 240
    //   801: iconst_2
    //   802: aload_2
    //   803: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   806: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   809: aload_0
    //   810: bipush 71
    //   812: iload 6
    //   814: aconst_null
    //   815: invokevirtual 228	com/tencent/mobileqq/app/CardHandler:notifyUI	(IZLjava/lang/Object;)V
    //   818: return
    //   819: iconst_0
    //   820: istore 5
    //   822: goto -688 -> 134
    //   825: iload 4
    //   827: i2l
    //   828: lstore 11
    //   830: goto -522 -> 308
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	833	0	this	CardHandler
    //   0	833	1	paramToServiceMsg	ToServiceMsg
    //   0	833	2	paramFromServiceMsg	FromServiceMsg
    //   0	833	3	paramObject	Object
    //   289	537	4	i	int
    //   4	817	5	bool1	boolean
    //   79	734	6	bool2	boolean
    //   83	467	7	bool3	boolean
    //   70	636	8	bool4	boolean
    //   10	522	9	bool5	boolean
    //   7	510	10	bool6	boolean
    //   303	526	11	l	long
    //   424	24	13	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   411	455	523	finally
    //   455	467	523	finally
    //   470	475	523	finally
    //   475	516	523	finally
    //   411	455	530	java/lang/Exception
    //   455	467	530	java/lang/Exception
    //   470	475	530	java/lang/Exception
    //   475	516	530	java/lang/Exception
    //   85	106	544	finally
    //   118	128	544	finally
    //   142	148	544	finally
    //   156	164	544	finally
    //   172	179	544	finally
    //   187	194	544	finally
    //   202	212	544	finally
    //   233	243	544	finally
    //   255	265	544	finally
    //   273	291	544	finally
    //   316	334	544	finally
    //   342	356	544	finally
    //   364	376	544	finally
    //   384	397	544	finally
    //   405	411	544	finally
    //   85	106	548	java/lang/Exception
    //   118	128	548	java/lang/Exception
    //   142	148	548	java/lang/Exception
    //   156	164	548	java/lang/Exception
    //   172	179	548	java/lang/Exception
    //   187	194	548	java/lang/Exception
    //   202	212	548	java/lang/Exception
    //   233	243	548	java/lang/Exception
    //   255	265	548	java/lang/Exception
    //   273	291	548	java/lang/Exception
    //   316	334	548	java/lang/Exception
    //   342	356	548	java/lang/Exception
    //   364	376	548	java/lang/Exception
    //   384	397	548	java/lang/Exception
    //   405	411	548	java/lang/Exception
    //   553	569	639	finally
  }
  
  /* Error */
  private void C(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 101	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: istore 5
    //   6: iconst_1
    //   7: istore 10
    //   9: iconst_1
    //   10: istore 9
    //   12: iload 5
    //   14: ifeq +13 -> 27
    //   17: aload_3
    //   18: ifnull +9 -> 27
    //   21: iconst_1
    //   22: istore 5
    //   24: goto +6 -> 30
    //   27: iconst_0
    //   28: istore 5
    //   30: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   33: ifeq +36 -> 69
    //   36: new 20	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   43: astore_2
    //   44: aload_2
    //   45: ldc_w 277
    //   48: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: aload_2
    //   53: iload 5
    //   55: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: ldc 113
    //   61: iconst_2
    //   62: aload_2
    //   63: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   69: iload 5
    //   71: istore 8
    //   73: iload 5
    //   75: ifeq +786 -> 861
    //   78: iload 5
    //   80: istore 6
    //   82: iload 5
    //   84: istore 7
    //   86: new 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   89: dup
    //   90: invokespecial 120	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   93: aload_3
    //   94: checkcast 122	[B
    //   97: checkcast 122	[B
    //   100: invokevirtual 126	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   103: checkcast 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   106: astore_2
    //   107: iload 5
    //   109: istore 6
    //   111: iload 5
    //   113: istore 7
    //   115: aload_2
    //   116: getfield 130	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   119: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   122: ifne +854 -> 976
    //   125: iconst_1
    //   126: istore 5
    //   128: goto +3 -> 131
    //   131: iload 5
    //   133: istore 6
    //   135: iload 5
    //   137: istore 7
    //   139: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   142: ifeq +68 -> 210
    //   145: iload 5
    //   147: istore 6
    //   149: iload 5
    //   151: istore 7
    //   153: new 20	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   160: astore_3
    //   161: iload 5
    //   163: istore 6
    //   165: iload 5
    //   167: istore 7
    //   169: aload_3
    //   170: ldc_w 279
    //   173: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: iload 5
    //   179: istore 6
    //   181: iload 5
    //   183: istore 7
    //   185: aload_3
    //   186: iload 5
    //   188: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   191: pop
    //   192: iload 5
    //   194: istore 6
    //   196: iload 5
    //   198: istore 7
    //   200: ldc 113
    //   202: iconst_2
    //   203: aload_3
    //   204: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   207: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   210: iload 5
    //   212: istore 8
    //   214: iload 5
    //   216: ifeq +645 -> 861
    //   219: iload 5
    //   221: istore 6
    //   223: iload 5
    //   225: istore 7
    //   227: iload 5
    //   229: istore 8
    //   231: aload_2
    //   232: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   235: invokevirtual 146	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   238: ifeq +623 -> 861
    //   241: iload 5
    //   243: istore 6
    //   245: iload 5
    //   247: istore 7
    //   249: iload 5
    //   251: istore 8
    //   253: aload_2
    //   254: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   257: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   260: ifnull +601 -> 861
    //   263: iload 5
    //   265: istore 6
    //   267: iload 5
    //   269: istore 7
    //   271: aload_2
    //   272: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   275: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   278: invokevirtual 155	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   281: invokestatic 161	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   284: invokevirtual 164	java/nio/ByteBuffer:getInt	()I
    //   287: istore 4
    //   289: iload 4
    //   291: ifge +691 -> 982
    //   294: iload 4
    //   296: i2l
    //   297: ldc2_w 165
    //   300: ladd
    //   301: lstore 12
    //   303: goto +3 -> 306
    //   306: iload 5
    //   308: istore 6
    //   310: iload 5
    //   312: istore 7
    //   314: aload_0
    //   315: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   318: invokevirtual 171	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   321: lload 12
    //   323: invokestatic 176	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   326: invokevirtual 179	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   329: ifeq +361 -> 690
    //   332: iload 5
    //   334: istore 6
    //   336: iload 5
    //   338: istore 7
    //   340: ldc_w 281
    //   343: invokestatic 287	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   346: checkcast 281	com/tencent/mobileqq/nearby/redtouch/IUtil
    //   349: aload_0
    //   350: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   353: invokeinterface 290 2 0
    //   358: istore 8
    //   360: iload 5
    //   362: istore 6
    //   364: iload 5
    //   366: istore 7
    //   368: aload_0
    //   369: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   372: getstatic 185	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   375: invokevirtual 189	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   378: checkcast 191	com/tencent/mobileqq/app/FriendsManager
    //   381: astore_3
    //   382: iload 5
    //   384: istore 6
    //   386: iload 5
    //   388: istore 7
    //   390: aload_3
    //   391: aload_0
    //   392: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   395: invokevirtual 171	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   398: invokevirtual 194	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   401: astore_2
    //   402: iload 5
    //   404: istore 6
    //   406: iload 5
    //   408: istore 7
    //   410: aload_2
    //   411: aload_1
    //   412: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   415: ldc 202
    //   417: invokevirtual 208	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   420: putfield 293	com/tencent/mobileqq/data/Card:medalSwitchDisable	Z
    //   423: iload 5
    //   425: istore 6
    //   427: iload 5
    //   429: istore 7
    //   431: aload_3
    //   432: aload_2
    //   433: invokevirtual 217	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   436: pop
    //   437: iload 5
    //   439: istore 6
    //   441: iload 5
    //   443: istore 7
    //   445: invokestatic 299	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   448: astore_3
    //   449: iload 5
    //   451: istore 6
    //   453: iload 5
    //   455: istore 7
    //   457: new 20	java/lang/StringBuilder
    //   460: dup
    //   461: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   464: astore 14
    //   466: iload 5
    //   468: istore 6
    //   470: iload 5
    //   472: istore 7
    //   474: aload 14
    //   476: ldc_w 301
    //   479: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   482: pop
    //   483: iload 5
    //   485: istore 6
    //   487: iload 5
    //   489: istore 7
    //   491: aload 14
    //   493: lload 12
    //   495: invokevirtual 304	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   498: pop
    //   499: iload 5
    //   501: istore 6
    //   503: iload 5
    //   505: istore 7
    //   507: aload_3
    //   508: aload 14
    //   510: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   513: iconst_4
    //   514: invokevirtual 305	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   517: invokeinterface 259 1 0
    //   522: astore_3
    //   523: iload 5
    //   525: istore 6
    //   527: iload 5
    //   529: istore 7
    //   531: aload_3
    //   532: ldc_w 307
    //   535: aload_2
    //   536: getfield 293	com/tencent/mobileqq/data/Card:medalSwitchDisable	Z
    //   539: invokeinterface 311 3 0
    //   544: pop
    //   545: iload 5
    //   547: istore 6
    //   549: iload 5
    //   551: istore 7
    //   553: aload_3
    //   554: invokeinterface 270 1 0
    //   559: pop
    //   560: iload 5
    //   562: istore 6
    //   564: iload 5
    //   566: istore 7
    //   568: ldc_w 281
    //   571: invokestatic 287	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   574: checkcast 281	com/tencent/mobileqq/nearby/redtouch/IUtil
    //   577: aload_0
    //   578: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   581: invokeinterface 290 2 0
    //   586: istore 11
    //   588: iload 8
    //   590: iload 11
    //   592: if_icmpeq +31 -> 623
    //   595: iload 5
    //   597: istore 6
    //   599: iload 5
    //   601: istore 7
    //   603: ldc_w 281
    //   606: invokestatic 287	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   609: checkcast 281	com/tencent/mobileqq/nearby/redtouch/IUtil
    //   612: aload_0
    //   613: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   616: iload 11
    //   618: invokeinterface 315 3 0
    //   623: iload 10
    //   625: istore 5
    //   627: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   630: ifeq +235 -> 865
    //   633: new 20	java/lang/StringBuilder
    //   636: dup
    //   637: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   640: astore_3
    //   641: aload_3
    //   642: ldc_w 317
    //   645: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   648: pop
    //   649: aload_3
    //   650: aload_2
    //   651: getfield 293	com/tencent/mobileqq/data/Card:medalSwitchDisable	Z
    //   654: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   657: pop
    //   658: ldc 113
    //   660: iconst_2
    //   661: aload_3
    //   662: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   665: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   668: iload 10
    //   670: istore 5
    //   672: goto +193 -> 865
    //   675: astore_2
    //   676: iconst_1
    //   677: istore 6
    //   679: goto +119 -> 798
    //   682: astore_2
    //   683: iload 9
    //   685: istore 5
    //   687: goto +18 -> 705
    //   690: iconst_0
    //   691: istore 5
    //   693: goto +172 -> 865
    //   696: astore_2
    //   697: goto +101 -> 798
    //   700: astore_2
    //   701: iload 7
    //   703: istore 5
    //   705: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   708: ifeq +13 -> 721
    //   711: ldc 113
    //   713: iconst_2
    //   714: ldc_w 319
    //   717: aload_2
    //   718: invokestatic 222	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   721: iload 5
    //   723: istore 6
    //   725: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   728: ifeq +158 -> 886
    //   731: new 20	java/lang/StringBuilder
    //   734: dup
    //   735: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   738: astore_2
    //   739: aload_2
    //   740: ldc_w 279
    //   743: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   746: pop
    //   747: aload_2
    //   748: iload 5
    //   750: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   753: pop
    //   754: aload_2
    //   755: ldc_w 321
    //   758: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   761: pop
    //   762: aload_2
    //   763: aload_1
    //   764: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   767: ldc 202
    //   769: invokevirtual 208	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   772: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   775: pop
    //   776: ldc 113
    //   778: iconst_2
    //   779: aload_2
    //   780: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   783: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   786: iload 5
    //   788: istore 6
    //   790: goto +96 -> 886
    //   793: astore_2
    //   794: iload 5
    //   796: istore 6
    //   798: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   801: ifeq +58 -> 859
    //   804: new 20	java/lang/StringBuilder
    //   807: dup
    //   808: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   811: astore_3
    //   812: aload_3
    //   813: ldc_w 279
    //   816: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   819: pop
    //   820: aload_3
    //   821: iload 6
    //   823: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   826: pop
    //   827: aload_3
    //   828: ldc_w 321
    //   831: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   834: pop
    //   835: aload_3
    //   836: aload_1
    //   837: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   840: ldc 202
    //   842: invokevirtual 208	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   845: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   848: pop
    //   849: ldc 113
    //   851: iconst_2
    //   852: aload_3
    //   853: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   856: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   859: aload_2
    //   860: athrow
    //   861: iload 8
    //   863: istore 5
    //   865: iload 5
    //   867: istore 6
    //   869: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   872: ifeq +14 -> 886
    //   875: new 20	java/lang/StringBuilder
    //   878: dup
    //   879: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   882: astore_2
    //   883: goto -144 -> 739
    //   886: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   889: ifeq +77 -> 966
    //   892: aload_0
    //   893: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   896: getstatic 185	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   899: invokevirtual 189	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   902: checkcast 191	com/tencent/mobileqq/app/FriendsManager
    //   905: aload_0
    //   906: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   909: invokevirtual 171	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   912: invokevirtual 194	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   915: astore_1
    //   916: new 20	java/lang/StringBuilder
    //   919: dup
    //   920: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   923: astore_2
    //   924: aload_2
    //   925: ldc_w 323
    //   928: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   931: pop
    //   932: aload_2
    //   933: aload_1
    //   934: getfield 293	com/tencent/mobileqq/data/Card:medalSwitchDisable	Z
    //   937: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   940: pop
    //   941: aload_2
    //   942: ldc_w 274
    //   945: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   948: pop
    //   949: aload_2
    //   950: iload 6
    //   952: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   955: pop
    //   956: ldc 113
    //   958: iconst_2
    //   959: aload_2
    //   960: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   963: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   966: aload_0
    //   967: bipush 74
    //   969: iload 6
    //   971: aconst_null
    //   972: invokevirtual 228	com/tencent/mobileqq/app/CardHandler:notifyUI	(IZLjava/lang/Object;)V
    //   975: return
    //   976: iconst_0
    //   977: istore 5
    //   979: goto -848 -> 131
    //   982: iload 4
    //   984: i2l
    //   985: lstore 12
    //   987: goto -681 -> 306
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	990	0	this	CardHandler
    //   0	990	1	paramToServiceMsg	ToServiceMsg
    //   0	990	2	paramFromServiceMsg	FromServiceMsg
    //   0	990	3	paramObject	Object
    //   287	696	4	i	int
    //   4	974	5	bool1	boolean
    //   80	890	6	bool2	boolean
    //   84	618	7	bool3	boolean
    //   71	791	8	bool4	boolean
    //   10	674	9	bool5	boolean
    //   7	662	10	bool6	boolean
    //   586	31	11	bool7	boolean
    //   301	685	12	l	long
    //   464	45	14	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   627	668	675	finally
    //   627	668	682	java/lang/Exception
    //   86	107	696	finally
    //   115	125	696	finally
    //   139	145	696	finally
    //   153	161	696	finally
    //   169	177	696	finally
    //   185	192	696	finally
    //   200	210	696	finally
    //   231	241	696	finally
    //   253	263	696	finally
    //   271	289	696	finally
    //   314	332	696	finally
    //   340	360	696	finally
    //   368	382	696	finally
    //   390	402	696	finally
    //   410	423	696	finally
    //   431	437	696	finally
    //   445	449	696	finally
    //   457	466	696	finally
    //   474	483	696	finally
    //   491	499	696	finally
    //   507	523	696	finally
    //   531	545	696	finally
    //   553	560	696	finally
    //   568	588	696	finally
    //   603	623	696	finally
    //   86	107	700	java/lang/Exception
    //   115	125	700	java/lang/Exception
    //   139	145	700	java/lang/Exception
    //   153	161	700	java/lang/Exception
    //   169	177	700	java/lang/Exception
    //   185	192	700	java/lang/Exception
    //   200	210	700	java/lang/Exception
    //   231	241	700	java/lang/Exception
    //   253	263	700	java/lang/Exception
    //   271	289	700	java/lang/Exception
    //   314	332	700	java/lang/Exception
    //   340	360	700	java/lang/Exception
    //   368	382	700	java/lang/Exception
    //   390	402	700	java/lang/Exception
    //   410	423	700	java/lang/Exception
    //   431	437	700	java/lang/Exception
    //   445	449	700	java/lang/Exception
    //   457	466	700	java/lang/Exception
    //   474	483	700	java/lang/Exception
    //   491	499	700	java/lang/Exception
    //   507	523	700	java/lang/Exception
    //   531	545	700	java/lang/Exception
    //   553	560	700	java/lang/Exception
    //   568	588	700	java/lang/Exception
    //   603	623	700	java/lang/Exception
    //   705	721	793	finally
  }
  
  /* Error */
  private void D(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 101	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: istore 4
    //   6: iconst_1
    //   7: istore 8
    //   9: iload 4
    //   11: ifeq +13 -> 24
    //   14: aload_3
    //   15: ifnull +9 -> 24
    //   18: iconst_1
    //   19: istore 5
    //   21: goto +6 -> 27
    //   24: iconst_0
    //   25: istore 5
    //   27: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   30: ifeq +36 -> 66
    //   33: new 20	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   40: astore_1
    //   41: aload_1
    //   42: ldc_w 326
    //   45: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload_1
    //   50: iload 5
    //   52: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: ldc 113
    //   58: iconst_2
    //   59: aload_1
    //   60: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   66: aload_0
    //   67: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   70: invokevirtual 329	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   73: astore_1
    //   74: aload_0
    //   75: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   78: getstatic 185	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   81: invokevirtual 189	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   84: checkcast 191	com/tencent/mobileqq/app/FriendsManager
    //   87: astore 10
    //   89: aload 10
    //   91: aload_1
    //   92: invokevirtual 194	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   95: astore_2
    //   96: iload 5
    //   98: istore 6
    //   100: iload 5
    //   102: ifeq +732 -> 834
    //   105: iload 5
    //   107: istore 7
    //   109: iload 5
    //   111: istore 4
    //   113: new 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   116: dup
    //   117: invokespecial 120	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   120: aload_3
    //   121: checkcast 122	[B
    //   124: checkcast 122	[B
    //   127: invokevirtual 126	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   130: checkcast 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   133: astore_3
    //   134: iload 5
    //   136: istore 7
    //   138: iload 5
    //   140: istore 4
    //   142: aload_3
    //   143: getfield 130	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   146: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   149: ifne +782 -> 931
    //   152: iconst_1
    //   153: istore 5
    //   155: goto +3 -> 158
    //   158: iload 5
    //   160: istore 7
    //   162: iload 5
    //   164: istore 4
    //   166: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   169: ifeq +72 -> 241
    //   172: iload 5
    //   174: istore 7
    //   176: iload 5
    //   178: istore 4
    //   180: new 20	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   187: astore 11
    //   189: iload 5
    //   191: istore 7
    //   193: iload 5
    //   195: istore 4
    //   197: aload 11
    //   199: ldc_w 331
    //   202: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: iload 5
    //   208: istore 7
    //   210: iload 5
    //   212: istore 4
    //   214: aload 11
    //   216: iload 5
    //   218: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   221: pop
    //   222: iload 5
    //   224: istore 7
    //   226: iload 5
    //   228: istore 4
    //   230: ldc 113
    //   232: iconst_2
    //   233: aload 11
    //   235: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   238: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   241: iload 5
    //   243: istore 6
    //   245: iload 5
    //   247: ifeq +587 -> 834
    //   250: iload 5
    //   252: istore 7
    //   254: iload 5
    //   256: istore 4
    //   258: iload 5
    //   260: istore 6
    //   262: aload_3
    //   263: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   266: invokevirtual 146	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   269: ifeq +565 -> 834
    //   272: iload 5
    //   274: istore 7
    //   276: iload 5
    //   278: istore 4
    //   280: iload 5
    //   282: istore 6
    //   284: aload_3
    //   285: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   288: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   291: ifnull +543 -> 834
    //   294: iload 5
    //   296: istore 7
    //   298: iload 5
    //   300: istore 4
    //   302: new 333	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody
    //   305: dup
    //   306: invokespecial 334	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:<init>	()V
    //   309: astore 11
    //   311: iload 5
    //   313: istore 7
    //   315: iload 5
    //   317: istore 4
    //   319: aload 11
    //   321: aload_3
    //   322: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   325: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   328: invokevirtual 155	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   331: invokevirtual 335	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   334: pop
    //   335: iload 5
    //   337: istore 7
    //   339: iload 5
    //   341: istore 4
    //   343: iload 5
    //   345: istore 6
    //   347: aload 11
    //   349: getfield 339	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   352: invokevirtual 342	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   355: ifeq +479 -> 834
    //   358: iload 5
    //   360: istore 7
    //   362: iload 5
    //   364: istore 4
    //   366: iload 5
    //   368: istore 6
    //   370: aload 11
    //   372: getfield 339	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   375: invokevirtual 345	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   378: invokeinterface 348 1 0
    //   383: ifle +451 -> 834
    //   386: iload 5
    //   388: istore 7
    //   390: iload 5
    //   392: istore 4
    //   394: ldc_w 281
    //   397: invokestatic 287	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   400: checkcast 281	com/tencent/mobileqq/nearby/redtouch/IUtil
    //   403: aload_0
    //   404: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   407: invokeinterface 290 2 0
    //   412: istore 9
    //   414: iload 5
    //   416: istore 7
    //   418: iload 5
    //   420: istore 4
    //   422: aload 11
    //   424: getfield 339	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   427: invokevirtual 345	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   430: iconst_0
    //   431: invokeinterface 351 2 0
    //   436: checkcast 353	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData
    //   439: getfield 356	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_req_medalwall_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   442: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   445: ifeq +492 -> 937
    //   448: iload 8
    //   450: istore 6
    //   452: goto +3 -> 455
    //   455: iload 5
    //   457: istore 7
    //   459: iload 5
    //   461: istore 4
    //   463: aload_2
    //   464: iload 6
    //   466: putfield 293	com/tencent/mobileqq/data/Card:medalSwitchDisable	Z
    //   469: iload 5
    //   471: istore 7
    //   473: iload 5
    //   475: istore 4
    //   477: aload 10
    //   479: aload_2
    //   480: invokevirtual 217	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   483: pop
    //   484: iload 5
    //   486: istore 7
    //   488: iload 5
    //   490: istore 4
    //   492: invokestatic 299	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   495: astore_3
    //   496: iload 5
    //   498: istore 7
    //   500: iload 5
    //   502: istore 4
    //   504: new 20	java/lang/StringBuilder
    //   507: dup
    //   508: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   511: astore 10
    //   513: iload 5
    //   515: istore 7
    //   517: iload 5
    //   519: istore 4
    //   521: aload 10
    //   523: ldc_w 301
    //   526: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: pop
    //   530: iload 5
    //   532: istore 7
    //   534: iload 5
    //   536: istore 4
    //   538: aload 10
    //   540: aload_1
    //   541: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: pop
    //   545: iload 5
    //   547: istore 7
    //   549: iload 5
    //   551: istore 4
    //   553: aload_3
    //   554: aload 10
    //   556: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   559: iconst_4
    //   560: invokevirtual 305	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   563: invokeinterface 259 1 0
    //   568: astore_1
    //   569: iload 5
    //   571: istore 7
    //   573: iload 5
    //   575: istore 4
    //   577: aload_1
    //   578: ldc_w 307
    //   581: aload_2
    //   582: getfield 293	com/tencent/mobileqq/data/Card:medalSwitchDisable	Z
    //   585: invokeinterface 311 3 0
    //   590: pop
    //   591: iload 5
    //   593: istore 7
    //   595: iload 5
    //   597: istore 4
    //   599: aload_1
    //   600: invokeinterface 270 1 0
    //   605: pop
    //   606: iload 5
    //   608: istore 7
    //   610: iload 5
    //   612: istore 4
    //   614: ldc_w 281
    //   617: invokestatic 287	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   620: checkcast 281	com/tencent/mobileqq/nearby/redtouch/IUtil
    //   623: aload_0
    //   624: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   627: invokeinterface 290 2 0
    //   632: istore 8
    //   634: iload 5
    //   636: istore 6
    //   638: iload 9
    //   640: iload 8
    //   642: if_icmpeq +192 -> 834
    //   645: iload 5
    //   647: istore 7
    //   649: iload 5
    //   651: istore 4
    //   653: ldc_w 281
    //   656: invokestatic 287	com/tencent/mobileqq/qroute/QRoute:api	(Ljava/lang/Class;)Lcom/tencent/mobileqq/qroute/QRouteApi;
    //   659: checkcast 281	com/tencent/mobileqq/nearby/redtouch/IUtil
    //   662: aload_0
    //   663: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   666: iload 8
    //   668: invokeinterface 315 3 0
    //   673: iload 5
    //   675: istore 6
    //   677: goto +157 -> 834
    //   680: astore_1
    //   681: goto +95 -> 776
    //   684: astore_1
    //   685: iload 4
    //   687: istore 7
    //   689: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   692: ifeq +17 -> 709
    //   695: iload 4
    //   697: istore 7
    //   699: ldc 113
    //   701: iconst_2
    //   702: ldc_w 358
    //   705: aload_1
    //   706: invokestatic 222	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   709: iload 4
    //   711: istore 5
    //   713: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   716: ifeq +143 -> 859
    //   719: new 20	java/lang/StringBuilder
    //   722: dup
    //   723: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   726: astore_1
    //   727: aload_1
    //   728: ldc_w 331
    //   731: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   734: pop
    //   735: aload_1
    //   736: iload 4
    //   738: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   741: pop
    //   742: aload_1
    //   743: ldc_w 360
    //   746: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   749: pop
    //   750: aload_1
    //   751: aload_2
    //   752: getfield 293	com/tencent/mobileqq/data/Card:medalSwitchDisable	Z
    //   755: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   758: pop
    //   759: ldc 113
    //   761: iconst_2
    //   762: aload_1
    //   763: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   766: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   769: iload 4
    //   771: istore 5
    //   773: goto +86 -> 859
    //   776: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   779: ifeq +53 -> 832
    //   782: new 20	java/lang/StringBuilder
    //   785: dup
    //   786: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   789: astore_3
    //   790: aload_3
    //   791: ldc_w 331
    //   794: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   797: pop
    //   798: aload_3
    //   799: iload 7
    //   801: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   804: pop
    //   805: aload_3
    //   806: ldc_w 360
    //   809: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   812: pop
    //   813: aload_3
    //   814: aload_2
    //   815: getfield 293	com/tencent/mobileqq/data/Card:medalSwitchDisable	Z
    //   818: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   821: pop
    //   822: ldc 113
    //   824: iconst_2
    //   825: aload_3
    //   826: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   829: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   832: aload_1
    //   833: athrow
    //   834: iload 6
    //   836: istore 5
    //   838: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   841: ifeq +18 -> 859
    //   844: new 20	java/lang/StringBuilder
    //   847: dup
    //   848: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   851: astore_1
    //   852: iload 6
    //   854: istore 4
    //   856: goto -129 -> 727
    //   859: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   862: ifeq +53 -> 915
    //   865: new 20	java/lang/StringBuilder
    //   868: dup
    //   869: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   872: astore_1
    //   873: aload_1
    //   874: ldc_w 331
    //   877: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   880: pop
    //   881: aload_1
    //   882: iload 5
    //   884: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   887: pop
    //   888: aload_1
    //   889: ldc_w 360
    //   892: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   895: pop
    //   896: aload_1
    //   897: aload_2
    //   898: getfield 293	com/tencent/mobileqq/data/Card:medalSwitchDisable	Z
    //   901: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   904: pop
    //   905: ldc 113
    //   907: iconst_2
    //   908: aload_1
    //   909: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   912: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   915: aload_0
    //   916: bipush 75
    //   918: iload 5
    //   920: aload_2
    //   921: getfield 293	com/tencent/mobileqq/data/Card:medalSwitchDisable	Z
    //   924: invokestatic 365	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   927: invokevirtual 228	com/tencent/mobileqq/app/CardHandler:notifyUI	(IZLjava/lang/Object;)V
    //   930: return
    //   931: iconst_0
    //   932: istore 5
    //   934: goto -776 -> 158
    //   937: iconst_0
    //   938: istore 6
    //   940: goto -485 -> 455
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	943	0	this	CardHandler
    //   0	943	1	paramToServiceMsg	ToServiceMsg
    //   0	943	2	paramFromServiceMsg	FromServiceMsg
    //   0	943	3	paramObject	Object
    //   4	851	4	bool1	boolean
    //   19	914	5	bool2	boolean
    //   98	841	6	bool3	boolean
    //   107	693	7	bool4	boolean
    //   7	660	8	bool5	boolean
    //   412	231	9	bool6	boolean
    //   87	468	10	localObject1	Object
    //   187	236	11	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   113	134	680	finally
    //   142	152	680	finally
    //   166	172	680	finally
    //   180	189	680	finally
    //   197	206	680	finally
    //   214	222	680	finally
    //   230	241	680	finally
    //   262	272	680	finally
    //   284	294	680	finally
    //   302	311	680	finally
    //   319	335	680	finally
    //   347	358	680	finally
    //   370	386	680	finally
    //   394	414	680	finally
    //   422	448	680	finally
    //   463	469	680	finally
    //   477	484	680	finally
    //   492	496	680	finally
    //   504	513	680	finally
    //   521	530	680	finally
    //   538	545	680	finally
    //   553	569	680	finally
    //   577	591	680	finally
    //   599	606	680	finally
    //   614	634	680	finally
    //   653	673	680	finally
    //   689	695	680	finally
    //   699	709	680	finally
    //   113	134	684	java/lang/Exception
    //   142	152	684	java/lang/Exception
    //   166	172	684	java/lang/Exception
    //   180	189	684	java/lang/Exception
    //   197	206	684	java/lang/Exception
    //   214	222	684	java/lang/Exception
    //   230	241	684	java/lang/Exception
    //   262	272	684	java/lang/Exception
    //   284	294	684	java/lang/Exception
    //   302	311	684	java/lang/Exception
    //   319	335	684	java/lang/Exception
    //   347	358	684	java/lang/Exception
    //   370	386	684	java/lang/Exception
    //   394	414	684	java/lang/Exception
    //   422	448	684	java/lang/Exception
    //   463	469	684	java/lang/Exception
    //   477	484	684	java/lang/Exception
    //   492	496	684	java/lang/Exception
    //   504	513	684	java/lang/Exception
    //   521	530	684	java/lang/Exception
    //   538	545	684	java/lang/Exception
    //   553	569	684	java/lang/Exception
    //   577	591	684	java/lang/Exception
    //   599	606	684	java/lang/Exception
    //   614	634	684	java/lang/Exception
    //   653	673	684	java/lang/Exception
  }
  
  private void E(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "handleGetConnectionsSwitch ");
    }
    paramToServiceMsg = new oidb_0x5eb.RspBody();
    int k = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
    int j = -1;
    if (k == 0)
    {
      int i = j;
      if (paramToServiceMsg.rpt_msg_uin_data.has())
      {
        paramToServiceMsg = paramToServiceMsg.rpt_msg_uin_data.get();
        i = j;
        if (paramToServiceMsg != null)
        {
          i = j;
          if (paramToServiceMsg.size() > 0)
          {
            j = ((oidb_0x5eb.UdcUinData)paramToServiceMsg.get(0)).uint32_rsp_connections_switch_id.get();
            ((CTEntryMng)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.CTENTRY_MNG)).b(j);
            i = j;
            if (QLog.isColorLevel())
            {
              paramToServiceMsg = new StringBuilder();
              paramToServiceMsg.append("handleGetConnectionsSwitch ");
              paramToServiceMsg.append(j);
              QLog.d("CardHandler", 2, paramToServiceMsg.toString());
              i = j;
            }
          }
        }
      }
      notifyUI(108, true, new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
      return;
    }
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleGetConnectionsSwitch failed result:");
      paramToServiceMsg.append(k);
      QLog.i("CardHandler", 2, paramToServiceMsg.toString());
    }
    notifyUI(108, false, new Object[] { Integer.valueOf(k), Integer.valueOf(-1) });
  }
  
  /* Error */
  private void F(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 101	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: istore 4
    //   6: iconst_1
    //   7: istore 5
    //   9: iload 4
    //   11: ifeq +13 -> 24
    //   14: aload_3
    //   15: ifnull +9 -> 24
    //   18: iconst_1
    //   19: istore 4
    //   21: goto +6 -> 27
    //   24: iconst_0
    //   25: istore 4
    //   27: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   30: ifeq +36 -> 66
    //   33: new 20	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   40: astore_1
    //   41: aload_1
    //   42: ldc_w 401
    //   45: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload_1
    //   50: iload 4
    //   52: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: ldc 113
    //   58: iconst_2
    //   59: aload_1
    //   60: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   66: iload 4
    //   68: ifeq +134 -> 202
    //   71: new 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   74: dup
    //   75: invokespecial 120	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   78: aload_3
    //   79: checkcast 122	[B
    //   82: checkcast 122	[B
    //   85: invokevirtual 126	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   88: checkcast 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   91: astore_1
    //   92: aload_1
    //   93: getfield 130	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   96: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   99: ifne +104 -> 203
    //   102: iload 5
    //   104: istore 4
    //   106: goto +3 -> 109
    //   109: aload_1
    //   110: getfield 405	tencent/im/oidb/oidb_sso$OIDBSSOPkg:str_error_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   113: invokevirtual 409	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   116: astore_2
    //   117: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   120: ifeq +50 -> 170
    //   123: new 20	java/lang/StringBuilder
    //   126: dup
    //   127: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   130: astore_3
    //   131: aload_3
    //   132: ldc_w 411
    //   135: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: aload_3
    //   140: iload 4
    //   142: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   145: pop
    //   146: aload_3
    //   147: ldc_w 413
    //   150: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: pop
    //   154: aload_3
    //   155: aload_2
    //   156: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: pop
    //   160: ldc 113
    //   162: iconst_2
    //   163: aload_3
    //   164: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   170: aload_0
    //   171: iload 4
    //   173: aload_1
    //   174: invokespecial 416	com/tencent/mobileqq/app/CardHandler:a	(ZLtencent/im/oidb/oidb_sso$OIDBSSOPkg;)V
    //   177: return
    //   178: astore_1
    //   179: goto +21 -> 200
    //   182: astore_1
    //   183: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   186: ifeq +16 -> 202
    //   189: ldc 113
    //   191: iconst_2
    //   192: ldc_w 418
    //   195: aload_1
    //   196: invokestatic 222	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   199: return
    //   200: aload_1
    //   201: athrow
    //   202: return
    //   203: iconst_0
    //   204: istore 4
    //   206: goto -97 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	209	0	this	CardHandler
    //   0	209	1	paramToServiceMsg	ToServiceMsg
    //   0	209	2	paramFromServiceMsg	FromServiceMsg
    //   0	209	3	paramObject	Object
    //   4	201	4	bool1	boolean
    //   7	96	5	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   71	102	178	finally
    //   109	170	178	finally
    //   170	177	178	finally
    //   183	199	178	finally
    //   71	102	182	java/lang/Exception
    //   109	170	182	java/lang/Exception
    //   170	177	182	java/lang/Exception
  }
  
  /* Error */
  private void G(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 101	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: istore 6
    //   6: iconst_1
    //   7: istore 10
    //   9: iload 6
    //   11: ifeq +13 -> 24
    //   14: aload_3
    //   15: ifnull +9 -> 24
    //   18: iconst_1
    //   19: istore 6
    //   21: goto +6 -> 27
    //   24: iconst_0
    //   25: istore 6
    //   27: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   30: ifeq +36 -> 66
    //   33: new 20	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   40: astore_1
    //   41: aload_1
    //   42: ldc_w 421
    //   45: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload_1
    //   50: iload 6
    //   52: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: ldc 113
    //   58: iconst_2
    //   59: aload_1
    //   60: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   66: iload 6
    //   68: istore 9
    //   70: iload 6
    //   72: ifeq +730 -> 802
    //   75: iload 6
    //   77: istore 8
    //   79: iload 6
    //   81: istore 7
    //   83: new 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   86: dup
    //   87: invokespecial 120	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   90: aload_3
    //   91: checkcast 122	[B
    //   94: checkcast 122	[B
    //   97: invokevirtual 126	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   100: checkcast 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   103: astore_1
    //   104: iload 6
    //   106: istore 8
    //   108: iload 6
    //   110: istore 7
    //   112: aload_1
    //   113: getfield 130	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   116: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   119: ifne +693 -> 812
    //   122: iconst_1
    //   123: istore 6
    //   125: goto +3 -> 128
    //   128: iload 6
    //   130: istore 8
    //   132: iload 6
    //   134: istore 7
    //   136: aload_1
    //   137: getfield 405	tencent/im/oidb/oidb_sso$OIDBSSOPkg:str_error_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   140: invokevirtual 409	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   143: astore_2
    //   144: iload 6
    //   146: istore 8
    //   148: iload 6
    //   150: istore 7
    //   152: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   155: ifeq +98 -> 253
    //   158: iload 6
    //   160: istore 8
    //   162: iload 6
    //   164: istore 7
    //   166: new 20	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   173: astore_3
    //   174: iload 6
    //   176: istore 8
    //   178: iload 6
    //   180: istore 7
    //   182: aload_3
    //   183: ldc_w 423
    //   186: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: pop
    //   190: iload 6
    //   192: istore 8
    //   194: iload 6
    //   196: istore 7
    //   198: aload_3
    //   199: iload 6
    //   201: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: iload 6
    //   207: istore 8
    //   209: iload 6
    //   211: istore 7
    //   213: aload_3
    //   214: ldc_w 413
    //   217: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: pop
    //   221: iload 6
    //   223: istore 8
    //   225: iload 6
    //   227: istore 7
    //   229: aload_3
    //   230: aload_2
    //   231: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: pop
    //   235: iload 6
    //   237: istore 8
    //   239: iload 6
    //   241: istore 7
    //   243: ldc 113
    //   245: iconst_2
    //   246: aload_3
    //   247: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   253: iload 6
    //   255: istore 9
    //   257: iload 6
    //   259: ifeq +543 -> 802
    //   262: iload 6
    //   264: istore 8
    //   266: iload 6
    //   268: istore 7
    //   270: iload 6
    //   272: istore 9
    //   274: aload_1
    //   275: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   278: invokevirtual 146	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   281: ifeq +521 -> 802
    //   284: iload 6
    //   286: istore 8
    //   288: iload 6
    //   290: istore 7
    //   292: iload 6
    //   294: istore 9
    //   296: aload_1
    //   297: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   300: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   303: ifnull +499 -> 802
    //   306: iload 6
    //   308: istore 8
    //   310: iload 6
    //   312: istore 7
    //   314: new 333	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody
    //   317: dup
    //   318: invokespecial 334	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:<init>	()V
    //   321: astore_2
    //   322: iload 6
    //   324: istore 8
    //   326: iload 6
    //   328: istore 7
    //   330: aload_2
    //   331: aload_1
    //   332: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   335: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   338: invokevirtual 155	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   341: invokevirtual 335	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   344: pop
    //   345: iload 6
    //   347: istore 8
    //   349: iload 6
    //   351: istore 7
    //   353: iload 6
    //   355: istore 9
    //   357: aload_2
    //   358: getfield 339	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   361: invokevirtual 342	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   364: ifeq +438 -> 802
    //   367: iload 6
    //   369: istore 8
    //   371: iload 6
    //   373: istore 7
    //   375: iload 6
    //   377: istore 9
    //   379: aload_2
    //   380: getfield 339	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   383: invokevirtual 345	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   386: invokeinterface 348 1 0
    //   391: ifle +411 -> 802
    //   394: iload 6
    //   396: istore 8
    //   398: iload 6
    //   400: istore 7
    //   402: iload 6
    //   404: istore 9
    //   406: aload_2
    //   407: getfield 339	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   410: invokevirtual 345	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   413: iconst_0
    //   414: invokeinterface 351 2 0
    //   419: checkcast 353	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData
    //   422: getfield 426	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_hidden_session_switch	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   425: invokevirtual 427	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   428: ifeq +374 -> 802
    //   431: iload 6
    //   433: istore 8
    //   435: iload 6
    //   437: istore 7
    //   439: aload_2
    //   440: getfield 339	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   443: invokevirtual 345	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   446: iconst_0
    //   447: invokeinterface 351 2 0
    //   452: checkcast 353	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData
    //   455: getfield 426	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_hidden_session_switch	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   458: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   461: istore 4
    //   463: iload 6
    //   465: istore 8
    //   467: iload 6
    //   469: istore 7
    //   471: aload_2
    //   472: getfield 339	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   475: invokevirtual 345	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   478: iconst_0
    //   479: invokeinterface 351 2 0
    //   484: checkcast 353	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData
    //   487: getfield 430	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_hidden_session_video_switch	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   490: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   493: istore 5
    //   495: iload 6
    //   497: istore 8
    //   499: iload 6
    //   501: istore 7
    //   503: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   506: ifeq +99 -> 605
    //   509: iload 6
    //   511: istore 8
    //   513: iload 6
    //   515: istore 7
    //   517: new 20	java/lang/StringBuilder
    //   520: dup
    //   521: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   524: astore_1
    //   525: iload 6
    //   527: istore 8
    //   529: iload 6
    //   531: istore 7
    //   533: aload_1
    //   534: ldc_w 432
    //   537: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: pop
    //   541: iload 6
    //   543: istore 8
    //   545: iload 6
    //   547: istore 7
    //   549: aload_1
    //   550: iload 4
    //   552: invokevirtual 391	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   555: pop
    //   556: iload 6
    //   558: istore 8
    //   560: iload 6
    //   562: istore 7
    //   564: aload_1
    //   565: ldc_w 434
    //   568: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: pop
    //   572: iload 6
    //   574: istore 8
    //   576: iload 6
    //   578: istore 7
    //   580: aload_1
    //   581: iload 5
    //   583: invokevirtual 391	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   586: pop
    //   587: iload 6
    //   589: istore 8
    //   591: iload 6
    //   593: istore 7
    //   595: ldc 113
    //   597: iconst_2
    //   598: aload_1
    //   599: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   602: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   605: iload 4
    //   607: iflt +65 -> 672
    //   610: iload 6
    //   612: istore 8
    //   614: iload 6
    //   616: istore 7
    //   618: aload_0
    //   619: getfield 77	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   622: invokevirtual 435	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   625: astore_1
    //   626: iload 6
    //   628: istore 8
    //   630: iload 6
    //   632: istore 7
    //   634: aload_0
    //   635: getfield 77	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   638: invokevirtual 438	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   641: invokevirtual 444	mqq/app/MobileQQ:getApplicationContext	()Landroid/content/Context;
    //   644: astore_2
    //   645: iload 4
    //   647: iconst_1
    //   648: if_icmpeq +170 -> 818
    //   651: iconst_1
    //   652: istore 9
    //   654: goto +3 -> 657
    //   657: iload 6
    //   659: istore 8
    //   661: iload 6
    //   663: istore 7
    //   665: aload_1
    //   666: aload_2
    //   667: iload 9
    //   669: invokestatic 449	com/tencent/mobileqq/app/hiddenchat/HiddenChatUtil:a	(Ljava/lang/String;Landroid/content/Context;Z)V
    //   672: iload 6
    //   674: istore 9
    //   676: iload 5
    //   678: iflt +124 -> 802
    //   681: iload 6
    //   683: istore 8
    //   685: iload 6
    //   687: istore 7
    //   689: aload_0
    //   690: getfield 77	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   693: invokevirtual 435	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   696: astore_1
    //   697: iload 6
    //   699: istore 8
    //   701: iload 6
    //   703: istore 7
    //   705: aload_0
    //   706: getfield 77	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   709: invokevirtual 438	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   712: invokevirtual 444	mqq/app/MobileQQ:getApplicationContext	()Landroid/content/Context;
    //   715: astore_2
    //   716: iload 5
    //   718: iconst_1
    //   719: if_icmpeq +105 -> 824
    //   722: iload 10
    //   724: istore 9
    //   726: goto +3 -> 729
    //   729: iload 6
    //   731: istore 8
    //   733: iload 6
    //   735: istore 7
    //   737: aload_1
    //   738: aload_2
    //   739: iload 9
    //   741: invokestatic 451	com/tencent/mobileqq/app/hiddenchat/HiddenChatUtil:b	(Ljava/lang/String;Landroid/content/Context;Z)V
    //   744: iload 6
    //   746: istore 9
    //   748: goto +54 -> 802
    //   751: astore_1
    //   752: goto +39 -> 791
    //   755: astore_1
    //   756: iload 7
    //   758: istore 8
    //   760: iload 7
    //   762: istore 9
    //   764: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   767: ifeq +35 -> 802
    //   770: iload 7
    //   772: istore 8
    //   774: ldc 113
    //   776: iconst_2
    //   777: ldc_w 453
    //   780: aload_1
    //   781: invokestatic 222	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   784: iload 7
    //   786: istore 9
    //   788: goto +14 -> 802
    //   791: aload_0
    //   792: bipush 104
    //   794: iload 8
    //   796: aconst_null
    //   797: invokevirtual 228	com/tencent/mobileqq/app/CardHandler:notifyUI	(IZLjava/lang/Object;)V
    //   800: aload_1
    //   801: athrow
    //   802: aload_0
    //   803: bipush 104
    //   805: iload 9
    //   807: aconst_null
    //   808: invokevirtual 228	com/tencent/mobileqq/app/CardHandler:notifyUI	(IZLjava/lang/Object;)V
    //   811: return
    //   812: iconst_0
    //   813: istore 6
    //   815: goto -687 -> 128
    //   818: iconst_0
    //   819: istore 9
    //   821: goto -164 -> 657
    //   824: iconst_0
    //   825: istore 9
    //   827: goto -98 -> 729
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	830	0	this	CardHandler
    //   0	830	1	paramToServiceMsg	ToServiceMsg
    //   0	830	2	paramFromServiceMsg	FromServiceMsg
    //   0	830	3	paramObject	Object
    //   461	188	4	i	int
    //   493	227	5	j	int
    //   4	810	6	bool1	boolean
    //   81	704	7	bool2	boolean
    //   77	718	8	bool3	boolean
    //   68	758	9	bool4	boolean
    //   7	716	10	bool5	boolean
    // Exception table:
    //   from	to	target	type
    //   83	104	751	finally
    //   112	122	751	finally
    //   136	144	751	finally
    //   152	158	751	finally
    //   166	174	751	finally
    //   182	190	751	finally
    //   198	205	751	finally
    //   213	221	751	finally
    //   229	235	751	finally
    //   243	253	751	finally
    //   274	284	751	finally
    //   296	306	751	finally
    //   314	322	751	finally
    //   330	345	751	finally
    //   357	367	751	finally
    //   379	394	751	finally
    //   406	431	751	finally
    //   439	463	751	finally
    //   471	495	751	finally
    //   503	509	751	finally
    //   517	525	751	finally
    //   533	541	751	finally
    //   549	556	751	finally
    //   564	572	751	finally
    //   580	587	751	finally
    //   595	605	751	finally
    //   618	626	751	finally
    //   634	645	751	finally
    //   665	672	751	finally
    //   689	697	751	finally
    //   705	716	751	finally
    //   737	744	751	finally
    //   764	770	751	finally
    //   774	784	751	finally
    //   83	104	755	java/lang/Exception
    //   112	122	755	java/lang/Exception
    //   136	144	755	java/lang/Exception
    //   152	158	755	java/lang/Exception
    //   166	174	755	java/lang/Exception
    //   182	190	755	java/lang/Exception
    //   198	205	755	java/lang/Exception
    //   213	221	755	java/lang/Exception
    //   229	235	755	java/lang/Exception
    //   243	253	755	java/lang/Exception
    //   274	284	755	java/lang/Exception
    //   296	306	755	java/lang/Exception
    //   314	322	755	java/lang/Exception
    //   330	345	755	java/lang/Exception
    //   357	367	755	java/lang/Exception
    //   379	394	755	java/lang/Exception
    //   406	431	755	java/lang/Exception
    //   439	463	755	java/lang/Exception
    //   471	495	755	java/lang/Exception
    //   503	509	755	java/lang/Exception
    //   517	525	755	java/lang/Exception
    //   533	541	755	java/lang/Exception
    //   549	556	755	java/lang/Exception
    //   564	572	755	java/lang/Exception
    //   580	587	755	java/lang/Exception
    //   595	605	755	java/lang/Exception
    //   618	626	755	java/lang/Exception
    //   634	645	755	java/lang/Exception
    //   665	672	755	java/lang/Exception
    //   689	697	755	java/lang/Exception
    //   705	716	755	java/lang/Exception
    //   737	744	755	java/lang/Exception
  }
  
  /* Error */
  private void H(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 101	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: ifeq +13 -> 17
    //   7: aload_3
    //   8: ifnull +9 -> 17
    //   11: iconst_1
    //   12: istore 5
    //   14: goto +6 -> 20
    //   17: iconst_0
    //   18: istore 5
    //   20: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   23: ifeq +36 -> 59
    //   26: new 20	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   33: astore_2
    //   34: aload_2
    //   35: ldc_w 456
    //   38: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload_2
    //   43: iload 5
    //   45: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: ldc 113
    //   51: iconst_2
    //   52: aload_2
    //   53: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: aload_1
    //   60: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   63: ldc_w 458
    //   66: ldc_w 460
    //   69: invokevirtual 464	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   72: astore_1
    //   73: iload 5
    //   75: istore 8
    //   77: iload 5
    //   79: ifeq +546 -> 625
    //   82: iload 5
    //   84: istore 6
    //   86: iload 5
    //   88: istore 7
    //   90: new 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   93: dup
    //   94: invokespecial 120	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   97: aload_3
    //   98: checkcast 122	[B
    //   101: checkcast 122	[B
    //   104: invokevirtual 126	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   107: checkcast 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   110: astore_2
    //   111: iload 5
    //   113: istore 6
    //   115: iload 5
    //   117: istore 7
    //   119: aload_2
    //   120: getfield 130	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   123: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   126: ifne +522 -> 648
    //   129: iconst_1
    //   130: istore 5
    //   132: goto +3 -> 135
    //   135: iload 5
    //   137: istore 6
    //   139: iload 5
    //   141: istore 7
    //   143: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   146: ifeq +68 -> 214
    //   149: iload 5
    //   151: istore 6
    //   153: iload 5
    //   155: istore 7
    //   157: new 20	java/lang/StringBuilder
    //   160: dup
    //   161: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   164: astore_3
    //   165: iload 5
    //   167: istore 6
    //   169: iload 5
    //   171: istore 7
    //   173: aload_3
    //   174: ldc_w 466
    //   177: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: iload 5
    //   183: istore 6
    //   185: iload 5
    //   187: istore 7
    //   189: aload_3
    //   190: iload 5
    //   192: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: iload 5
    //   198: istore 6
    //   200: iload 5
    //   202: istore 7
    //   204: ldc 113
    //   206: iconst_2
    //   207: aload_3
    //   208: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   214: iload 5
    //   216: istore 8
    //   218: iload 5
    //   220: ifeq +405 -> 625
    //   223: iload 5
    //   225: istore 6
    //   227: iload 5
    //   229: istore 7
    //   231: iload 5
    //   233: istore 8
    //   235: aload_2
    //   236: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   239: invokevirtual 146	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   242: ifeq +383 -> 625
    //   245: iload 5
    //   247: istore 6
    //   249: iload 5
    //   251: istore 7
    //   253: iload 5
    //   255: istore 8
    //   257: aload_2
    //   258: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   261: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   264: ifnull +361 -> 625
    //   267: iload 5
    //   269: istore 6
    //   271: iload 5
    //   273: istore 7
    //   275: new 333	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody
    //   278: dup
    //   279: invokespecial 334	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:<init>	()V
    //   282: astore_3
    //   283: iload 5
    //   285: istore 6
    //   287: iload 5
    //   289: istore 7
    //   291: aload_3
    //   292: aload_2
    //   293: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   296: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   299: invokevirtual 155	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   302: invokevirtual 335	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   305: pop
    //   306: iload 5
    //   308: istore 6
    //   310: iload 5
    //   312: istore 7
    //   314: iload 5
    //   316: istore 8
    //   318: aload_3
    //   319: getfield 339	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   322: invokevirtual 342	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   325: ifeq +300 -> 625
    //   328: iload 5
    //   330: istore 6
    //   332: iload 5
    //   334: istore 7
    //   336: iload 5
    //   338: istore 8
    //   340: aload_3
    //   341: getfield 339	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   344: invokevirtual 345	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   347: invokeinterface 348 1 0
    //   352: ifle +273 -> 625
    //   355: iload 5
    //   357: istore 6
    //   359: iload 5
    //   361: istore 7
    //   363: iload 5
    //   365: istore 8
    //   367: aload_3
    //   368: getfield 339	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   371: invokevirtual 345	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   374: iconst_0
    //   375: invokeinterface 351 2 0
    //   380: checkcast 353	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData
    //   383: getfield 469	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_do_not_disturb_mode_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   386: invokevirtual 427	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   389: ifeq +236 -> 625
    //   392: iload 5
    //   394: istore 6
    //   396: iload 5
    //   398: istore 7
    //   400: aload_3
    //   401: getfield 339	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   404: invokevirtual 345	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   407: iconst_0
    //   408: invokeinterface 351 2 0
    //   413: checkcast 353	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData
    //   416: getfield 469	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_do_not_disturb_mode_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   419: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   422: istore 4
    //   424: iload 5
    //   426: istore 6
    //   428: iload 5
    //   430: istore 7
    //   432: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   435: ifeq +68 -> 503
    //   438: iload 5
    //   440: istore 6
    //   442: iload 5
    //   444: istore 7
    //   446: new 20	java/lang/StringBuilder
    //   449: dup
    //   450: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   453: astore_2
    //   454: iload 5
    //   456: istore 6
    //   458: iload 5
    //   460: istore 7
    //   462: aload_2
    //   463: ldc_w 471
    //   466: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: pop
    //   470: iload 5
    //   472: istore 6
    //   474: iload 5
    //   476: istore 7
    //   478: aload_2
    //   479: iload 4
    //   481: invokevirtual 391	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   484: pop
    //   485: iload 5
    //   487: istore 6
    //   489: iload 5
    //   491: istore 7
    //   493: ldc 113
    //   495: iconst_2
    //   496: aload_2
    //   497: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   500: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   503: iload 5
    //   505: istore 8
    //   507: iload 4
    //   509: iflt +116 -> 625
    //   512: iload 5
    //   514: istore 6
    //   516: iload 5
    //   518: istore 7
    //   520: aload_0
    //   521: getfield 77	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   524: invokevirtual 438	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   527: invokevirtual 444	mqq/app/MobileQQ:getApplicationContext	()Landroid/content/Context;
    //   530: aconst_null
    //   531: ldc_w 473
    //   534: ldc_w 475
    //   537: iload 4
    //   539: invokestatic 481	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:writeValueForInt	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   542: iload 5
    //   544: istore 8
    //   546: goto +79 -> 625
    //   549: astore_2
    //   550: goto +51 -> 601
    //   553: astore_2
    //   554: iload 7
    //   556: istore 6
    //   558: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   561: ifeq +17 -> 578
    //   564: iload 7
    //   566: istore 6
    //   568: ldc 113
    //   570: iconst_2
    //   571: ldc_w 483
    //   574: aload_2
    //   575: invokestatic 222	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   578: aload_0
    //   579: bipush 96
    //   581: iload 7
    //   583: iconst_2
    //   584: anewarray 173	java/lang/String
    //   587: dup
    //   588: iconst_0
    //   589: ldc_w 460
    //   592: aastore
    //   593: dup
    //   594: iconst_1
    //   595: aload_1
    //   596: aastore
    //   597: invokevirtual 228	com/tencent/mobileqq/app/CardHandler:notifyUI	(IZLjava/lang/Object;)V
    //   600: return
    //   601: aload_0
    //   602: bipush 96
    //   604: iload 6
    //   606: iconst_2
    //   607: anewarray 173	java/lang/String
    //   610: dup
    //   611: iconst_0
    //   612: ldc_w 460
    //   615: aastore
    //   616: dup
    //   617: iconst_1
    //   618: aload_1
    //   619: aastore
    //   620: invokevirtual 228	com/tencent/mobileqq/app/CardHandler:notifyUI	(IZLjava/lang/Object;)V
    //   623: aload_2
    //   624: athrow
    //   625: aload_0
    //   626: bipush 96
    //   628: iload 8
    //   630: iconst_2
    //   631: anewarray 173	java/lang/String
    //   634: dup
    //   635: iconst_0
    //   636: ldc_w 460
    //   639: aastore
    //   640: dup
    //   641: iconst_1
    //   642: aload_1
    //   643: aastore
    //   644: invokevirtual 228	com/tencent/mobileqq/app/CardHandler:notifyUI	(IZLjava/lang/Object;)V
    //   647: return
    //   648: iconst_0
    //   649: istore 5
    //   651: goto -516 -> 135
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	654	0	this	CardHandler
    //   0	654	1	paramToServiceMsg	ToServiceMsg
    //   0	654	2	paramFromServiceMsg	FromServiceMsg
    //   0	654	3	paramObject	Object
    //   422	116	4	i	int
    //   12	638	5	bool1	boolean
    //   84	521	6	bool2	boolean
    //   88	494	7	bool3	boolean
    //   75	554	8	bool4	boolean
    // Exception table:
    //   from	to	target	type
    //   90	111	549	finally
    //   119	129	549	finally
    //   143	149	549	finally
    //   157	165	549	finally
    //   173	181	549	finally
    //   189	196	549	finally
    //   204	214	549	finally
    //   235	245	549	finally
    //   257	267	549	finally
    //   275	283	549	finally
    //   291	306	549	finally
    //   318	328	549	finally
    //   340	355	549	finally
    //   367	392	549	finally
    //   400	424	549	finally
    //   432	438	549	finally
    //   446	454	549	finally
    //   462	470	549	finally
    //   478	485	549	finally
    //   493	503	549	finally
    //   520	542	549	finally
    //   558	564	549	finally
    //   568	578	549	finally
    //   90	111	553	java/lang/Exception
    //   119	129	553	java/lang/Exception
    //   143	149	553	java/lang/Exception
    //   157	165	553	java/lang/Exception
    //   173	181	553	java/lang/Exception
    //   189	196	553	java/lang/Exception
    //   204	214	553	java/lang/Exception
    //   235	245	553	java/lang/Exception
    //   257	267	553	java/lang/Exception
    //   275	283	553	java/lang/Exception
    //   291	306	553	java/lang/Exception
    //   318	328	553	java/lang/Exception
    //   340	355	553	java/lang/Exception
    //   367	392	553	java/lang/Exception
    //   400	424	553	java/lang/Exception
    //   432	438	553	java/lang/Exception
    //   446	454	553	java/lang/Exception
    //   462	470	553	java/lang/Exception
    //   478	485	553	java/lang/Exception
    //   493	503	553	java/lang/Exception
    //   520	542	553	java/lang/Exception
  }
  
  /* Error */
  private void I(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 101	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: istore 4
    //   6: iconst_0
    //   7: istore 13
    //   9: iconst_0
    //   10: istore 12
    //   12: iconst_0
    //   13: istore 11
    //   15: iload 4
    //   17: ifeq +13 -> 30
    //   20: aload_3
    //   21: ifnull +9 -> 30
    //   24: iconst_1
    //   25: istore 4
    //   27: goto +6 -> 33
    //   30: iconst_0
    //   31: istore 4
    //   33: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   36: ifeq +36 -> 72
    //   39: new 20	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   46: astore_2
    //   47: aload_2
    //   48: ldc_w 485
    //   51: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload_2
    //   56: iload 4
    //   58: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: ldc 113
    //   64: iconst_2
    //   65: aload_2
    //   66: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   69: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   72: aload_0
    //   73: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   76: getstatic 488	com/tencent/mobileqq/app/QQManagerFactory:MGR_ACTVATE_FRIENDS	I
    //   79: invokevirtual 189	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   82: checkcast 490	com/tencent/mobileqq/app/activateFriends/ActivateFriendsManager
    //   85: astore_2
    //   86: aload_2
    //   87: iconst_0
    //   88: invokevirtual 493	com/tencent/mobileqq/app/activateFriends/ActivateFriendsManager:a	(Z)Z
    //   91: istore 10
    //   93: iload 4
    //   95: istore 7
    //   97: iload 4
    //   99: ifeq +679 -> 778
    //   102: iload 4
    //   104: istore 8
    //   106: iload 10
    //   108: istore 6
    //   110: iload 4
    //   112: istore 9
    //   114: new 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   117: dup
    //   118: invokespecial 120	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   121: aload_3
    //   122: checkcast 122	[B
    //   125: checkcast 122	[B
    //   128: invokevirtual 126	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   131: checkcast 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   134: astore_3
    //   135: aload_3
    //   136: ifnull +693 -> 829
    //   139: iload 4
    //   141: istore 8
    //   143: iload 10
    //   145: istore 6
    //   147: iload 4
    //   149: istore 9
    //   151: aload_3
    //   152: getfield 130	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   155: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   158: ifne +671 -> 829
    //   161: iconst_1
    //   162: istore 5
    //   164: goto +3 -> 167
    //   167: iload 5
    //   169: istore 8
    //   171: iload 10
    //   173: istore 6
    //   175: iload 5
    //   177: istore 9
    //   179: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   182: ifeq +88 -> 270
    //   185: iload 5
    //   187: istore 8
    //   189: iload 10
    //   191: istore 6
    //   193: iload 5
    //   195: istore 9
    //   197: new 20	java/lang/StringBuilder
    //   200: dup
    //   201: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   204: astore 16
    //   206: iload 5
    //   208: istore 8
    //   210: iload 10
    //   212: istore 6
    //   214: iload 5
    //   216: istore 9
    //   218: aload 16
    //   220: ldc_w 495
    //   223: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   226: pop
    //   227: iload 5
    //   229: istore 8
    //   231: iload 10
    //   233: istore 6
    //   235: iload 5
    //   237: istore 9
    //   239: aload 16
    //   241: iload 5
    //   243: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   246: pop
    //   247: iload 5
    //   249: istore 8
    //   251: iload 10
    //   253: istore 6
    //   255: iload 5
    //   257: istore 9
    //   259: ldc 113
    //   261: iconst_2
    //   262: aload 16
    //   264: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   270: iload 5
    //   272: istore 7
    //   274: iload 5
    //   276: ifeq +502 -> 778
    //   279: iload 5
    //   281: istore 8
    //   283: iload 10
    //   285: istore 6
    //   287: iload 5
    //   289: istore 9
    //   291: iload 5
    //   293: istore 7
    //   295: aload_3
    //   296: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   299: invokevirtual 146	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   302: ifeq +476 -> 778
    //   305: iload 5
    //   307: istore 8
    //   309: iload 10
    //   311: istore 6
    //   313: iload 5
    //   315: istore 9
    //   317: iload 5
    //   319: istore 7
    //   321: aload_3
    //   322: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   325: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   328: ifnull +450 -> 778
    //   331: iload 5
    //   333: istore 8
    //   335: iload 10
    //   337: istore 6
    //   339: iload 5
    //   341: istore 9
    //   343: aload_3
    //   344: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   347: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   350: invokevirtual 155	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   353: invokestatic 161	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   356: invokevirtual 164	java/nio/ByteBuffer:getInt	()I
    //   359: invokestatic 500	com/tencent/mobileqq/util/Utils:a	(I)J
    //   362: lstore 14
    //   364: iload 5
    //   366: istore 8
    //   368: iload 10
    //   370: istore 6
    //   372: iload 5
    //   374: istore 9
    //   376: aload_0
    //   377: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   380: invokevirtual 171	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   383: lload 14
    //   385: invokestatic 176	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   388: invokevirtual 179	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   391: ifeq +51 -> 442
    //   394: iload 5
    //   396: istore 8
    //   398: iload 10
    //   400: istore 6
    //   402: iload 5
    //   404: istore 9
    //   406: aload_1
    //   407: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   410: ldc 202
    //   412: invokevirtual 208	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   415: istore 7
    //   417: iload 5
    //   419: istore 8
    //   421: iload 7
    //   423: istore 6
    //   425: iload 5
    //   427: istore 9
    //   429: aload_2
    //   430: iload 7
    //   432: iconst_0
    //   433: invokevirtual 503	com/tencent/mobileqq/app/activateFriends/ActivateFriendsManager:a	(ZZ)V
    //   436: iconst_1
    //   437: istore 4
    //   439: goto +347 -> 786
    //   442: iload 5
    //   444: istore 8
    //   446: iload 10
    //   448: istore 6
    //   450: iload 5
    //   452: istore 9
    //   454: iload 13
    //   456: istore 4
    //   458: iload 10
    //   460: istore 7
    //   462: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   465: ifeq +321 -> 786
    //   468: iload 5
    //   470: istore 8
    //   472: iload 10
    //   474: istore 6
    //   476: iload 5
    //   478: istore 9
    //   480: new 20	java/lang/StringBuilder
    //   483: dup
    //   484: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   487: astore_2
    //   488: iload 5
    //   490: istore 8
    //   492: iload 10
    //   494: istore 6
    //   496: iload 5
    //   498: istore 9
    //   500: aload_2
    //   501: ldc_w 505
    //   504: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: pop
    //   508: iload 5
    //   510: istore 8
    //   512: iload 10
    //   514: istore 6
    //   516: iload 5
    //   518: istore 9
    //   520: aload_2
    //   521: aload_0
    //   522: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   525: invokevirtual 171	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   528: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: pop
    //   532: iload 5
    //   534: istore 8
    //   536: iload 10
    //   538: istore 6
    //   540: iload 5
    //   542: istore 9
    //   544: aload_2
    //   545: ldc_w 507
    //   548: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   551: pop
    //   552: iload 5
    //   554: istore 8
    //   556: iload 10
    //   558: istore 6
    //   560: iload 5
    //   562: istore 9
    //   564: aload_2
    //   565: lload 14
    //   567: invokevirtual 304	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   570: pop
    //   571: iload 5
    //   573: istore 8
    //   575: iload 10
    //   577: istore 6
    //   579: iload 5
    //   581: istore 9
    //   583: ldc 113
    //   585: iconst_2
    //   586: aload_2
    //   587: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   590: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   593: iload 13
    //   595: istore 4
    //   597: iload 10
    //   599: istore 7
    //   601: goto +185 -> 786
    //   604: astore_2
    //   605: goto +111 -> 716
    //   608: astore_2
    //   609: iload 9
    //   611: istore 8
    //   613: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   616: ifeq +17 -> 633
    //   619: iload 9
    //   621: istore 8
    //   623: ldc 113
    //   625: iconst_2
    //   626: ldc_w 509
    //   629: aload_2
    //   630: invokestatic 222	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   633: iload 12
    //   635: istore 5
    //   637: iload 6
    //   639: istore 8
    //   641: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   644: ifeq +171 -> 815
    //   647: new 20	java/lang/StringBuilder
    //   650: dup
    //   651: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   654: astore_2
    //   655: iload 11
    //   657: istore 4
    //   659: aload_2
    //   660: ldc_w 495
    //   663: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: pop
    //   667: aload_2
    //   668: iload 4
    //   670: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   673: pop
    //   674: aload_2
    //   675: ldc 224
    //   677: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   680: pop
    //   681: aload_2
    //   682: aload_1
    //   683: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   686: ldc 202
    //   688: invokevirtual 208	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   691: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   694: pop
    //   695: ldc 113
    //   697: iconst_2
    //   698: aload_2
    //   699: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   702: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   705: iload 4
    //   707: istore 5
    //   709: iload 6
    //   711: istore 8
    //   713: goto +102 -> 815
    //   716: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   719: ifeq +57 -> 776
    //   722: new 20	java/lang/StringBuilder
    //   725: dup
    //   726: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   729: astore_3
    //   730: aload_3
    //   731: ldc_w 495
    //   734: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   737: pop
    //   738: aload_3
    //   739: iload 8
    //   741: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   744: pop
    //   745: aload_3
    //   746: ldc 224
    //   748: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   751: pop
    //   752: aload_3
    //   753: aload_1
    //   754: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   757: ldc 202
    //   759: invokevirtual 208	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   762: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   765: pop
    //   766: ldc 113
    //   768: iconst_2
    //   769: aload_3
    //   770: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   773: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   776: aload_2
    //   777: athrow
    //   778: iload 7
    //   780: istore 4
    //   782: iload 10
    //   784: istore 7
    //   786: iload 4
    //   788: istore 5
    //   790: iload 7
    //   792: istore 8
    //   794: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   797: ifeq +18 -> 815
    //   800: new 20	java/lang/StringBuilder
    //   803: dup
    //   804: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   807: astore_2
    //   808: iload 7
    //   810: istore 6
    //   812: goto -153 -> 659
    //   815: aload_0
    //   816: bipush 57
    //   818: iload 5
    //   820: iload 8
    //   822: invokestatic 365	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   825: invokevirtual 228	com/tencent/mobileqq/app/CardHandler:notifyUI	(IZLjava/lang/Object;)V
    //   828: return
    //   829: iconst_0
    //   830: istore 5
    //   832: goto -665 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	835	0	this	CardHandler
    //   0	835	1	paramToServiceMsg	ToServiceMsg
    //   0	835	2	paramFromServiceMsg	FromServiceMsg
    //   0	835	3	paramObject	Object
    //   4	783	4	bool1	boolean
    //   162	669	5	bool2	boolean
    //   108	703	6	bool3	boolean
    //   95	714	7	bool4	boolean
    //   104	717	8	bool5	boolean
    //   112	508	9	bool6	boolean
    //   91	692	10	bool7	boolean
    //   13	643	11	bool8	boolean
    //   10	624	12	bool9	boolean
    //   7	587	13	bool10	boolean
    //   362	204	14	l	long
    //   204	59	16	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   114	135	604	finally
    //   151	161	604	finally
    //   179	185	604	finally
    //   197	206	604	finally
    //   218	227	604	finally
    //   239	247	604	finally
    //   259	270	604	finally
    //   295	305	604	finally
    //   321	331	604	finally
    //   343	364	604	finally
    //   376	394	604	finally
    //   406	417	604	finally
    //   429	436	604	finally
    //   462	468	604	finally
    //   480	488	604	finally
    //   500	508	604	finally
    //   520	532	604	finally
    //   544	552	604	finally
    //   564	571	604	finally
    //   583	593	604	finally
    //   613	619	604	finally
    //   623	633	604	finally
    //   114	135	608	java/lang/Exception
    //   151	161	608	java/lang/Exception
    //   179	185	608	java/lang/Exception
    //   197	206	608	java/lang/Exception
    //   218	227	608	java/lang/Exception
    //   239	247	608	java/lang/Exception
    //   259	270	608	java/lang/Exception
    //   295	305	608	java/lang/Exception
    //   321	331	608	java/lang/Exception
    //   343	364	608	java/lang/Exception
    //   376	394	608	java/lang/Exception
    //   406	417	608	java/lang/Exception
    //   429	436	608	java/lang/Exception
    //   462	468	608	java/lang/Exception
    //   480	488	608	java/lang/Exception
    //   500	508	608	java/lang/Exception
    //   520	532	608	java/lang/Exception
    //   544	552	608	java/lang/Exception
    //   564	571	608	java/lang/Exception
    //   583	593	608	java/lang/Exception
  }
  
  /* Error */
  private void J(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 101	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: ifeq +13 -> 17
    //   7: aload_3
    //   8: ifnull +9 -> 17
    //   11: iconst_1
    //   12: istore 7
    //   14: goto +6 -> 20
    //   17: iconst_0
    //   18: istore 7
    //   20: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   23: ifeq +36 -> 59
    //   26: new 20	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   33: astore_2
    //   34: aload_2
    //   35: ldc_w 512
    //   38: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload_2
    //   43: iload 7
    //   45: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: ldc 113
    //   51: iconst_2
    //   52: aload_2
    //   53: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: iload 7
    //   61: istore 5
    //   63: iload 7
    //   65: ifeq +512 -> 577
    //   68: iload 7
    //   70: istore 8
    //   72: iload 7
    //   74: istore 6
    //   76: new 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   79: dup
    //   80: invokespecial 120	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   83: aload_3
    //   84: checkcast 122	[B
    //   87: checkcast 122	[B
    //   90: invokevirtual 126	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   93: checkcast 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   96: astore_2
    //   97: aload_2
    //   98: ifnull +521 -> 619
    //   101: iload 7
    //   103: istore 8
    //   105: iload 7
    //   107: istore 6
    //   109: aload_2
    //   110: getfield 130	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   113: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   116: ifne +503 -> 619
    //   119: iconst_1
    //   120: istore 7
    //   122: goto +3 -> 125
    //   125: iload 7
    //   127: istore 8
    //   129: iload 7
    //   131: istore 6
    //   133: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   136: ifeq +68 -> 204
    //   139: iload 7
    //   141: istore 8
    //   143: iload 7
    //   145: istore 6
    //   147: new 20	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   154: astore_3
    //   155: iload 7
    //   157: istore 8
    //   159: iload 7
    //   161: istore 6
    //   163: aload_3
    //   164: ldc_w 514
    //   167: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: pop
    //   171: iload 7
    //   173: istore 8
    //   175: iload 7
    //   177: istore 6
    //   179: aload_3
    //   180: iload 7
    //   182: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   185: pop
    //   186: iload 7
    //   188: istore 8
    //   190: iload 7
    //   192: istore 6
    //   194: ldc 113
    //   196: iconst_2
    //   197: aload_3
    //   198: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   201: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   204: iload 7
    //   206: istore 5
    //   208: iload 7
    //   210: ifeq +367 -> 577
    //   213: iload 7
    //   215: istore 8
    //   217: iload 7
    //   219: istore 6
    //   221: iload 7
    //   223: istore 5
    //   225: aload_2
    //   226: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   229: invokevirtual 146	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   232: ifeq +345 -> 577
    //   235: iload 7
    //   237: istore 8
    //   239: iload 7
    //   241: istore 6
    //   243: iload 7
    //   245: istore 5
    //   247: aload_2
    //   248: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   251: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   254: ifnull +323 -> 577
    //   257: iload 7
    //   259: istore 8
    //   261: iload 7
    //   263: istore 6
    //   265: aload_2
    //   266: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   269: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   272: invokevirtual 155	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   275: invokestatic 161	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   278: invokevirtual 164	java/nio/ByteBuffer:getInt	()I
    //   281: istore 4
    //   283: iload 4
    //   285: ifge +340 -> 625
    //   288: iload 4
    //   290: i2l
    //   291: ldc2_w 165
    //   294: ladd
    //   295: lstore 9
    //   297: goto +3 -> 300
    //   300: iload 7
    //   302: istore 8
    //   304: iload 7
    //   306: istore 6
    //   308: aload_0
    //   309: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   312: invokevirtual 171	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   315: lload 9
    //   317: invokestatic 176	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   320: invokevirtual 179	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   323: ifeq +82 -> 405
    //   326: iload 7
    //   328: istore 8
    //   330: iload 7
    //   332: istore 6
    //   334: aload_0
    //   335: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   338: getstatic 185	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   341: invokevirtual 189	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   344: checkcast 191	com/tencent/mobileqq/app/FriendsManager
    //   347: astore_2
    //   348: iload 7
    //   350: istore 8
    //   352: iload 7
    //   354: istore 6
    //   356: aload_2
    //   357: getstatic 517	com/tencent/mobileqq/app/AppConstants:BABY_Q_UIN	Ljava/lang/String;
    //   360: invokevirtual 194	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   363: astore_3
    //   364: iload 7
    //   366: istore 8
    //   368: iload 7
    //   370: istore 6
    //   372: aload_3
    //   373: aload_1
    //   374: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   377: ldc 202
    //   379: invokevirtual 208	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   382: putfield 520	com/tencent/mobileqq/data/Card:babyQSwitch	Z
    //   385: iload 7
    //   387: istore 8
    //   389: iload 7
    //   391: istore 6
    //   393: aload_2
    //   394: aload_3
    //   395: invokevirtual 217	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   398: pop
    //   399: iconst_1
    //   400: istore 5
    //   402: goto +175 -> 577
    //   405: iconst_0
    //   406: istore 5
    //   408: goto +169 -> 577
    //   411: astore_2
    //   412: goto +103 -> 515
    //   415: astore_2
    //   416: iload 6
    //   418: istore 8
    //   420: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   423: ifeq +17 -> 440
    //   426: iload 6
    //   428: istore 8
    //   430: ldc 113
    //   432: iconst_2
    //   433: ldc_w 522
    //   436: aload_2
    //   437: invokestatic 222	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   440: iload 6
    //   442: istore 7
    //   444: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   447: ifeq +151 -> 598
    //   450: new 20	java/lang/StringBuilder
    //   453: dup
    //   454: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   457: astore_2
    //   458: iload 6
    //   460: istore 5
    //   462: aload_2
    //   463: ldc_w 514
    //   466: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   469: pop
    //   470: aload_2
    //   471: iload 5
    //   473: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   476: pop
    //   477: aload_2
    //   478: ldc 224
    //   480: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: pop
    //   484: aload_2
    //   485: aload_1
    //   486: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   489: ldc 202
    //   491: invokevirtual 208	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   494: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   497: pop
    //   498: ldc 113
    //   500: iconst_2
    //   501: aload_2
    //   502: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   505: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   508: iload 5
    //   510: istore 7
    //   512: goto +86 -> 598
    //   515: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   518: ifeq +57 -> 575
    //   521: new 20	java/lang/StringBuilder
    //   524: dup
    //   525: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   528: astore_3
    //   529: aload_3
    //   530: ldc_w 514
    //   533: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: pop
    //   537: aload_3
    //   538: iload 8
    //   540: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   543: pop
    //   544: aload_3
    //   545: ldc 224
    //   547: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: pop
    //   551: aload_3
    //   552: aload_1
    //   553: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   556: ldc 202
    //   558: invokevirtual 208	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   561: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   564: pop
    //   565: ldc 113
    //   567: iconst_2
    //   568: aload_3
    //   569: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   572: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   575: aload_2
    //   576: athrow
    //   577: iload 5
    //   579: istore 7
    //   581: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   584: ifeq +14 -> 598
    //   587: new 20	java/lang/StringBuilder
    //   590: dup
    //   591: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   594: astore_2
    //   595: goto -133 -> 462
    //   598: aload_0
    //   599: bipush 72
    //   601: iload 7
    //   603: aload_1
    //   604: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   607: ldc 202
    //   609: invokevirtual 208	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   612: invokestatic 365	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   615: invokevirtual 228	com/tencent/mobileqq/app/CardHandler:notifyUI	(IZLjava/lang/Object;)V
    //   618: return
    //   619: iconst_0
    //   620: istore 7
    //   622: goto -497 -> 125
    //   625: iload 4
    //   627: i2l
    //   628: lstore 9
    //   630: goto -330 -> 300
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	633	0	this	CardHandler
    //   0	633	1	paramToServiceMsg	ToServiceMsg
    //   0	633	2	paramFromServiceMsg	FromServiceMsg
    //   0	633	3	paramObject	Object
    //   281	345	4	i	int
    //   61	517	5	bool1	boolean
    //   74	385	6	bool2	boolean
    //   12	609	7	bool3	boolean
    //   70	469	8	bool4	boolean
    //   295	334	9	l	long
    // Exception table:
    //   from	to	target	type
    //   76	97	411	finally
    //   109	119	411	finally
    //   133	139	411	finally
    //   147	155	411	finally
    //   163	171	411	finally
    //   179	186	411	finally
    //   194	204	411	finally
    //   225	235	411	finally
    //   247	257	411	finally
    //   265	283	411	finally
    //   308	326	411	finally
    //   334	348	411	finally
    //   356	364	411	finally
    //   372	385	411	finally
    //   393	399	411	finally
    //   420	426	411	finally
    //   430	440	411	finally
    //   76	97	415	java/lang/Exception
    //   109	119	415	java/lang/Exception
    //   133	139	415	java/lang/Exception
    //   147	155	415	java/lang/Exception
    //   163	171	415	java/lang/Exception
    //   179	186	415	java/lang/Exception
    //   194	204	415	java/lang/Exception
    //   225	235	415	java/lang/Exception
    //   247	257	415	java/lang/Exception
    //   265	283	415	java/lang/Exception
    //   308	326	415	java/lang/Exception
    //   334	348	415	java/lang/Exception
    //   356	364	415	java/lang/Exception
    //   372	385	415	java/lang/Exception
    //   393	399	415	java/lang/Exception
  }
  
  /* Error */
  private void K(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 101	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: istore 5
    //   6: iconst_1
    //   7: istore 9
    //   9: iload 5
    //   11: ifeq +13 -> 24
    //   14: aload_3
    //   15: ifnull +9 -> 24
    //   18: iconst_1
    //   19: istore 5
    //   21: goto +6 -> 27
    //   24: iconst_0
    //   25: istore 5
    //   27: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   30: ifeq +36 -> 66
    //   33: new 20	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   40: astore_2
    //   41: aload_2
    //   42: ldc_w 525
    //   45: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload_2
    //   50: iload 5
    //   52: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: ldc 113
    //   58: iconst_2
    //   59: aload_2
    //   60: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   66: aload_0
    //   67: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   70: invokevirtual 526	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   73: ldc_w 527
    //   76: invokevirtual 530	mqq/app/MobileQQ:getString	(I)Ljava/lang/String;
    //   79: pop
    //   80: aload_0
    //   81: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   84: invokevirtual 171	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   87: pop
    //   88: iload 5
    //   90: istore 6
    //   92: iload 5
    //   94: ifeq +553 -> 647
    //   97: iload 5
    //   99: istore 7
    //   101: iload 5
    //   103: istore 8
    //   105: new 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   108: dup
    //   109: invokespecial 120	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   112: aload_3
    //   113: checkcast 122	[B
    //   116: checkcast 122	[B
    //   119: invokevirtual 126	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   122: checkcast 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   125: astore_2
    //   126: aload_2
    //   127: ifnull +584 -> 711
    //   130: iload 5
    //   132: istore 7
    //   134: iload 5
    //   136: istore 8
    //   138: aload_2
    //   139: getfield 130	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   142: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   145: ifne +566 -> 711
    //   148: iconst_1
    //   149: istore 5
    //   151: goto +3 -> 154
    //   154: iload 5
    //   156: istore 7
    //   158: iload 5
    //   160: istore 8
    //   162: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   165: ifeq +68 -> 233
    //   168: iload 5
    //   170: istore 7
    //   172: iload 5
    //   174: istore 8
    //   176: new 20	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   183: astore_3
    //   184: iload 5
    //   186: istore 7
    //   188: iload 5
    //   190: istore 8
    //   192: aload_3
    //   193: ldc_w 532
    //   196: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: iload 5
    //   202: istore 7
    //   204: iload 5
    //   206: istore 8
    //   208: aload_3
    //   209: iload 5
    //   211: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: iload 5
    //   217: istore 7
    //   219: iload 5
    //   221: istore 8
    //   223: ldc 113
    //   225: iconst_2
    //   226: aload_3
    //   227: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   233: iload 5
    //   235: istore 6
    //   237: iload 5
    //   239: ifeq +408 -> 647
    //   242: iload 5
    //   244: istore 7
    //   246: iload 5
    //   248: istore 8
    //   250: iload 5
    //   252: istore 6
    //   254: aload_2
    //   255: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   258: invokevirtual 146	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   261: ifeq +386 -> 647
    //   264: iload 5
    //   266: istore 7
    //   268: iload 5
    //   270: istore 8
    //   272: iload 5
    //   274: istore 6
    //   276: aload_2
    //   277: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   280: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   283: ifnull +364 -> 647
    //   286: iload 5
    //   288: istore 7
    //   290: iload 5
    //   292: istore 8
    //   294: aload_2
    //   295: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   298: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   301: invokevirtual 155	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   304: invokestatic 161	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   307: invokevirtual 164	java/nio/ByteBuffer:getInt	()I
    //   310: istore 4
    //   312: iload 4
    //   314: i2l
    //   315: lstore 10
    //   317: iload 4
    //   319: ifge +16 -> 335
    //   322: iload 4
    //   324: ldc_w 533
    //   327: iand
    //   328: i2l
    //   329: ldc2_w 534
    //   332: lor
    //   333: lstore 10
    //   335: iload 5
    //   337: istore 7
    //   339: iload 5
    //   341: istore 8
    //   343: aload_0
    //   344: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   347: invokevirtual 171	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   350: lload 10
    //   352: invokestatic 176	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   355: invokevirtual 179	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   358: istore 5
    //   360: iload 5
    //   362: ifeq +54 -> 416
    //   365: aload_1
    //   366: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   369: ldc_w 537
    //   372: invokevirtual 541	android/os/Bundle:getShort	(Ljava/lang/String;)S
    //   375: istore 4
    //   377: aload_0
    //   378: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   381: getstatic 546	com/tencent/mobileqq/app/BusinessHandlerFactory:DEVICEPROXYMGR_HANDLER	Ljava/lang/String;
    //   384: invokevirtual 550	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   387: checkcast 552	com/tencent/device/devicemgr/SmartDeviceProxyMgr
    //   390: iload 4
    //   392: invokevirtual 553	com/tencent/device/devicemgr/SmartDeviceProxyMgr:b	(I)V
    //   395: iconst_1
    //   396: istore 6
    //   398: goto +249 -> 647
    //   401: astore_2
    //   402: iconst_1
    //   403: istore 5
    //   405: goto +179 -> 584
    //   408: astore_2
    //   409: iload 9
    //   411: istore 5
    //   413: goto +95 -> 508
    //   416: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   419: ifeq +56 -> 475
    //   422: new 20	java/lang/StringBuilder
    //   425: dup
    //   426: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   429: astore_2
    //   430: aload_2
    //   431: ldc_w 555
    //   434: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: pop
    //   438: aload_2
    //   439: lload 10
    //   441: invokevirtual 304	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   444: pop
    //   445: aload_2
    //   446: ldc_w 557
    //   449: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: pop
    //   453: aload_2
    //   454: aload_0
    //   455: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   458: invokevirtual 171	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   461: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: pop
    //   465: ldc 113
    //   467: iconst_2
    //   468: aload_2
    //   469: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   472: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   475: iconst_0
    //   476: istore 6
    //   478: goto +169 -> 647
    //   481: astore_2
    //   482: iconst_0
    //   483: istore 5
    //   485: goto +99 -> 584
    //   488: astore_2
    //   489: iconst_0
    //   490: istore 5
    //   492: goto +16 -> 508
    //   495: astore_2
    //   496: iload 7
    //   498: istore 5
    //   500: goto +84 -> 584
    //   503: astore_2
    //   504: iload 8
    //   506: istore 5
    //   508: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   511: ifeq +13 -> 524
    //   514: ldc 113
    //   516: iconst_2
    //   517: ldc_w 559
    //   520: aload_2
    //   521: invokestatic 222	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   524: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   527: ifeq +183 -> 710
    //   530: new 20	java/lang/StringBuilder
    //   533: dup
    //   534: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   537: astore_2
    //   538: aload_2
    //   539: ldc_w 532
    //   542: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   545: pop
    //   546: aload_2
    //   547: iload 5
    //   549: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   552: pop
    //   553: aload_2
    //   554: ldc 224
    //   556: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   559: pop
    //   560: aload_2
    //   561: aload_1
    //   562: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   565: ldc_w 537
    //   568: invokevirtual 541	android/os/Bundle:getShort	(Ljava/lang/String;)S
    //   571: invokevirtual 391	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   574: pop
    //   575: aload_2
    //   576: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   579: astore_1
    //   580: goto +123 -> 703
    //   583: astore_2
    //   584: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   587: ifeq +58 -> 645
    //   590: new 20	java/lang/StringBuilder
    //   593: dup
    //   594: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   597: astore_3
    //   598: aload_3
    //   599: ldc_w 532
    //   602: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: pop
    //   606: aload_3
    //   607: iload 5
    //   609: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   612: pop
    //   613: aload_3
    //   614: ldc 224
    //   616: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: pop
    //   620: aload_3
    //   621: aload_1
    //   622: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   625: ldc_w 537
    //   628: invokevirtual 541	android/os/Bundle:getShort	(Ljava/lang/String;)S
    //   631: invokevirtual 391	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   634: pop
    //   635: ldc 113
    //   637: iconst_2
    //   638: aload_3
    //   639: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   642: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   645: aload_2
    //   646: athrow
    //   647: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   650: ifeq +60 -> 710
    //   653: new 20	java/lang/StringBuilder
    //   656: dup
    //   657: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   660: astore_2
    //   661: aload_2
    //   662: ldc_w 532
    //   665: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: pop
    //   669: aload_2
    //   670: iload 6
    //   672: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   675: pop
    //   676: aload_2
    //   677: ldc 224
    //   679: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   682: pop
    //   683: aload_2
    //   684: aload_1
    //   685: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   688: ldc_w 537
    //   691: invokevirtual 541	android/os/Bundle:getShort	(Ljava/lang/String;)S
    //   694: invokevirtual 391	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   697: pop
    //   698: aload_2
    //   699: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   702: astore_1
    //   703: ldc 113
    //   705: iconst_2
    //   706: aload_1
    //   707: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   710: return
    //   711: iconst_0
    //   712: istore 5
    //   714: goto -560 -> 154
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	717	0	this	CardHandler
    //   0	717	1	paramToServiceMsg	ToServiceMsg
    //   0	717	2	paramFromServiceMsg	FromServiceMsg
    //   0	717	3	paramObject	Object
    //   310	81	4	i	int
    //   4	709	5	bool1	boolean
    //   90	581	6	bool2	boolean
    //   99	398	7	bool3	boolean
    //   103	402	8	bool4	boolean
    //   7	403	9	bool5	boolean
    //   315	125	10	l	long
    // Exception table:
    //   from	to	target	type
    //   365	395	401	finally
    //   365	395	408	java/lang/Exception
    //   416	475	481	finally
    //   416	475	488	java/lang/Exception
    //   105	126	495	finally
    //   138	148	495	finally
    //   162	168	495	finally
    //   176	184	495	finally
    //   192	200	495	finally
    //   208	215	495	finally
    //   223	233	495	finally
    //   254	264	495	finally
    //   276	286	495	finally
    //   294	312	495	finally
    //   343	360	495	finally
    //   105	126	503	java/lang/Exception
    //   138	148	503	java/lang/Exception
    //   162	168	503	java/lang/Exception
    //   176	184	503	java/lang/Exception
    //   192	200	503	java/lang/Exception
    //   208	215	503	java/lang/Exception
    //   223	233	503	java/lang/Exception
    //   254	264	503	java/lang/Exception
    //   276	286	503	java/lang/Exception
    //   294	312	503	java/lang/Exception
    //   343	360	503	java/lang/Exception
    //   508	524	583	finally
  }
  
  /* Error */
  private void L(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 101	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: istore 5
    //   6: iconst_0
    //   7: istore 9
    //   9: iload 5
    //   11: ifeq +13 -> 24
    //   14: aload_3
    //   15: ifnull +9 -> 24
    //   18: iconst_1
    //   19: istore 5
    //   21: goto +6 -> 27
    //   24: iconst_0
    //   25: istore 5
    //   27: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   30: ifeq +36 -> 66
    //   33: new 20	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   40: astore_2
    //   41: aload_2
    //   42: ldc_w 562
    //   45: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload_2
    //   50: iload 5
    //   52: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: ldc 113
    //   58: iconst_2
    //   59: aload_2
    //   60: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   66: aload_0
    //   67: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   70: invokevirtual 526	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   73: ldc_w 527
    //   76: invokevirtual 530	mqq/app/MobileQQ:getString	(I)Ljava/lang/String;
    //   79: pop
    //   80: aload_0
    //   81: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   84: invokevirtual 171	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   87: pop
    //   88: iload 5
    //   90: istore 6
    //   92: iload 5
    //   94: ifeq +525 -> 619
    //   97: iload 5
    //   99: istore 7
    //   101: iload 5
    //   103: istore 8
    //   105: new 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   108: dup
    //   109: invokespecial 120	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   112: aload_3
    //   113: checkcast 122	[B
    //   116: checkcast 122	[B
    //   119: invokevirtual 126	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   122: checkcast 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   125: astore_2
    //   126: aload_2
    //   127: ifnull +555 -> 682
    //   130: iload 5
    //   132: istore 7
    //   134: iload 5
    //   136: istore 8
    //   138: aload_2
    //   139: getfield 130	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   142: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   145: ifne +537 -> 682
    //   148: iconst_1
    //   149: istore 5
    //   151: goto +3 -> 154
    //   154: iload 5
    //   156: istore 7
    //   158: iload 5
    //   160: istore 8
    //   162: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   165: ifeq +68 -> 233
    //   168: iload 5
    //   170: istore 7
    //   172: iload 5
    //   174: istore 8
    //   176: new 20	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   183: astore_3
    //   184: iload 5
    //   186: istore 7
    //   188: iload 5
    //   190: istore 8
    //   192: aload_3
    //   193: ldc_w 564
    //   196: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: iload 5
    //   202: istore 7
    //   204: iload 5
    //   206: istore 8
    //   208: aload_3
    //   209: iload 5
    //   211: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   214: pop
    //   215: iload 5
    //   217: istore 7
    //   219: iload 5
    //   221: istore 8
    //   223: ldc 113
    //   225: iconst_2
    //   226: aload_3
    //   227: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   233: iload 5
    //   235: istore 6
    //   237: iload 5
    //   239: ifeq +380 -> 619
    //   242: iload 5
    //   244: istore 7
    //   246: iload 5
    //   248: istore 8
    //   250: iload 5
    //   252: istore 6
    //   254: aload_2
    //   255: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   258: invokevirtual 146	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   261: ifeq +358 -> 619
    //   264: iload 5
    //   266: istore 7
    //   268: iload 5
    //   270: istore 8
    //   272: iload 5
    //   274: istore 6
    //   276: aload_2
    //   277: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   280: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   283: ifnull +336 -> 619
    //   286: iload 5
    //   288: istore 7
    //   290: iload 5
    //   292: istore 8
    //   294: aload_2
    //   295: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   298: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   301: invokevirtual 155	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   304: invokestatic 161	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   307: invokevirtual 164	java/nio/ByteBuffer:getInt	()I
    //   310: istore 4
    //   312: iload 4
    //   314: i2l
    //   315: lstore 10
    //   317: iload 4
    //   319: ifge +16 -> 335
    //   322: iload 4
    //   324: ldc_w 533
    //   327: iand
    //   328: i2l
    //   329: ldc2_w 534
    //   332: lor
    //   333: lstore 10
    //   335: iload 5
    //   337: istore 7
    //   339: iload 5
    //   341: istore 8
    //   343: aload_1
    //   344: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   347: ldc 202
    //   349: invokevirtual 208	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   352: pop
    //   353: iload 5
    //   355: istore 7
    //   357: iload 5
    //   359: istore 8
    //   361: aload_0
    //   362: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   365: invokevirtual 171	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   368: lload 10
    //   370: invokestatic 176	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   373: invokevirtual 179	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   376: istore 5
    //   378: iload 5
    //   380: ifeq +9 -> 389
    //   383: iconst_1
    //   384: istore 6
    //   386: goto +233 -> 619
    //   389: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   392: ifeq +56 -> 448
    //   395: new 20	java/lang/StringBuilder
    //   398: dup
    //   399: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   402: astore_2
    //   403: aload_2
    //   404: ldc_w 566
    //   407: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: pop
    //   411: aload_2
    //   412: lload 10
    //   414: invokevirtual 304	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   417: pop
    //   418: aload_2
    //   419: ldc_w 557
    //   422: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   425: pop
    //   426: aload_2
    //   427: aload_0
    //   428: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   431: invokevirtual 171	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   434: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: pop
    //   438: ldc 113
    //   440: iconst_2
    //   441: aload_2
    //   442: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   445: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   448: iconst_0
    //   449: istore 6
    //   451: goto +168 -> 619
    //   454: astore_2
    //   455: iconst_0
    //   456: istore 7
    //   458: goto +99 -> 557
    //   461: astore_2
    //   462: iload 9
    //   464: istore 5
    //   466: goto +12 -> 478
    //   469: astore_2
    //   470: goto +87 -> 557
    //   473: astore_2
    //   474: iload 8
    //   476: istore 5
    //   478: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   481: ifeq +13 -> 494
    //   484: ldc 113
    //   486: iconst_2
    //   487: ldc_w 568
    //   490: aload_2
    //   491: invokestatic 222	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   494: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   497: ifeq +184 -> 681
    //   500: new 20	java/lang/StringBuilder
    //   503: dup
    //   504: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   507: astore_2
    //   508: aload_2
    //   509: ldc_w 564
    //   512: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   515: pop
    //   516: aload_2
    //   517: iload 5
    //   519: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   522: pop
    //   523: aload_2
    //   524: ldc 224
    //   526: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: pop
    //   530: aload_2
    //   531: aload_1
    //   532: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   535: ldc 202
    //   537: invokevirtual 208	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   540: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   543: pop
    //   544: aload_2
    //   545: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   548: astore_1
    //   549: goto +125 -> 674
    //   552: astore_2
    //   553: iload 5
    //   555: istore 7
    //   557: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   560: ifeq +57 -> 617
    //   563: new 20	java/lang/StringBuilder
    //   566: dup
    //   567: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   570: astore_3
    //   571: aload_3
    //   572: ldc_w 564
    //   575: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: pop
    //   579: aload_3
    //   580: iload 7
    //   582: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   585: pop
    //   586: aload_3
    //   587: ldc 224
    //   589: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: pop
    //   593: aload_3
    //   594: aload_1
    //   595: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   598: ldc 202
    //   600: invokevirtual 208	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   603: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   606: pop
    //   607: ldc 113
    //   609: iconst_2
    //   610: aload_3
    //   611: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   614: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   617: aload_2
    //   618: athrow
    //   619: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   622: ifeq +59 -> 681
    //   625: new 20	java/lang/StringBuilder
    //   628: dup
    //   629: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   632: astore_2
    //   633: aload_2
    //   634: ldc_w 564
    //   637: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   640: pop
    //   641: aload_2
    //   642: iload 6
    //   644: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   647: pop
    //   648: aload_2
    //   649: ldc 224
    //   651: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   654: pop
    //   655: aload_2
    //   656: aload_1
    //   657: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   660: ldc 202
    //   662: invokevirtual 208	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   665: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   668: pop
    //   669: aload_2
    //   670: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   673: astore_1
    //   674: ldc 113
    //   676: iconst_2
    //   677: aload_1
    //   678: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   681: return
    //   682: iconst_0
    //   683: istore 5
    //   685: goto -531 -> 154
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	688	0	this	CardHandler
    //   0	688	1	paramToServiceMsg	ToServiceMsg
    //   0	688	2	paramFromServiceMsg	FromServiceMsg
    //   0	688	3	paramObject	Object
    //   310	18	4	i	int
    //   4	680	5	bool1	boolean
    //   90	553	6	bool2	boolean
    //   99	482	7	bool3	boolean
    //   103	372	8	bool4	boolean
    //   7	456	9	bool5	boolean
    //   315	98	10	l	long
    // Exception table:
    //   from	to	target	type
    //   389	448	454	finally
    //   389	448	461	java/lang/Exception
    //   105	126	469	finally
    //   138	148	469	finally
    //   162	168	469	finally
    //   176	184	469	finally
    //   192	200	469	finally
    //   208	215	469	finally
    //   223	233	469	finally
    //   254	264	469	finally
    //   276	286	469	finally
    //   294	312	469	finally
    //   343	353	469	finally
    //   361	378	469	finally
    //   105	126	473	java/lang/Exception
    //   138	148	473	java/lang/Exception
    //   162	168	473	java/lang/Exception
    //   176	184	473	java/lang/Exception
    //   192	200	473	java/lang/Exception
    //   208	215	473	java/lang/Exception
    //   223	233	473	java/lang/Exception
    //   254	264	473	java/lang/Exception
    //   276	286	473	java/lang/Exception
    //   294	312	473	java/lang/Exception
    //   343	353	473	java/lang/Exception
    //   361	378	473	java/lang/Exception
    //   478	494	552	finally
  }
  
  private void M(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = paramToServiceMsg.extraData.getString("from");
    if (QLog.isDevelopLevel()) {
      QLog.i("MedalWallMng", 4, String.format(Locale.getDefault(), "handleGetMedalWallInfo from: %s", new Object[] { paramToServiceMsg }));
    }
    if ("getSelfNewObtainedMedalWall".equals(paramToServiceMsg)) {
      a(paramFromServiceMsg, paramObject);
    }
  }
  
  private void N(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder(300);
      paramToServiceMsg = paramToServiceMsg.extraData.getParcelableArrayList("medal_wall_list");
      ((StringBuilder)localObject).append("report list: [");
      if ((paramToServiceMsg != null) && (paramToServiceMsg.size() > 0))
      {
        paramToServiceMsg = paramToServiceMsg.iterator();
        while (paramToServiceMsg.hasNext())
        {
          MedalID localMedalID = (MedalID)paramToServiceMsg.next();
          if (localMedalID != null)
          {
            ((StringBuilder)localObject).append("(");
            ((StringBuilder)localObject).append(localMedalID.jdField_a_of_type_Int);
            ((StringBuilder)localObject).append(",");
            ((StringBuilder)localObject).append(localMedalID.jdField_b_of_type_Int);
            ((StringBuilder)localObject).append("), ");
          }
        }
      }
      ((StringBuilder)localObject).append("]");
      paramToServiceMsg = (ToServiceMsg)localObject;
    }
    else
    {
      paramToServiceMsg = null;
    }
    Object localObject = new cmd0xac6.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    if (i == 0)
    {
      if ((QLog.isDevelopLevel()) && (paramToServiceMsg != null))
      {
        paramFromServiceMsg = ((cmd0xac6.RspBody)localObject).rpt_results.get();
        paramToServiceMsg.append(", result list [");
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.size() > 0))
        {
          paramFromServiceMsg = paramFromServiceMsg.iterator();
          while (paramFromServiceMsg.hasNext())
          {
            paramObject = (cmd0xac6.operate_result)paramFromServiceMsg.next();
            if (paramObject != null)
            {
              paramToServiceMsg.append("(");
              paramToServiceMsg.append(paramObject.uint32_id.get());
              paramToServiceMsg.append(",");
              paramToServiceMsg.append(paramObject.int32_result.get());
              paramToServiceMsg.append(",");
              paramToServiceMsg.append(paramObject.str_errmsg.get());
              paramToServiceMsg.append("), ");
            }
          }
        }
        paramToServiceMsg.append("]");
      }
      paramFromServiceMsg = new TMedalWallInfo(-2147483648, ((cmd0xac6.RspBody)localObject).uint32_metal_count.get(), ((cmd0xac6.RspBody)localObject).int32_new_count.get(), ((cmd0xac6.RspBody)localObject).int32_upgrade_count.get(), ((cmd0xac6.RspBody)localObject).str_prompt_params.get());
    }
    else
    {
      paramFromServiceMsg = null;
    }
    boolean bool2 = QLog.isDevelopLevel();
    boolean bool1 = true;
    if (bool2)
    {
      paramObject = Locale.getDefault();
      if (paramToServiceMsg == null) {
        paramToServiceMsg = "null";
      } else {
        paramToServiceMsg = paramToServiceMsg.toString();
      }
      QLog.i("MedalWallMng", 4, String.format(paramObject, "handleReportMedalWall result: %s  msg: %s", new Object[] { Integer.valueOf(i), paramToServiceMsg }));
    }
    paramToServiceMsg = ((MedalWallMng)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MEDAL_WALL_MNG)).a(paramFromServiceMsg, false);
    if (i != 0) {
      bool1 = false;
    }
    notifyUI(51, bool1, paramToServiceMsg);
  }
  
  private void O(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_0xc33.RspBody localRspBody = new oidb_0xc33.RspBody();
    int k = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    int i = 300;
    boolean bool1 = false;
    boolean bool2 = false;
    if (k == 0)
    {
      if (localRspBody.uint32_result.get() == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      int j = localRspBody.uint32_next_gap.get();
      if (localRspBody.uint32_new_user.get() > 0) {
        bool2 = true;
      }
      if (j > 0) {
        i = j;
      }
      if ((paramToServiceMsg != null) && (TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), paramToServiceMsg.getUin()))) {
        ((CTEntryMng)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CTENTRY_MNG)).a(bool1, i, bool2);
      }
    }
    else
    {
      bool2 = false;
    }
    if (QLog.isDevelopLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleGetBindPhoneSwitchInfo needShow:");
      paramToServiceMsg.append(bool1);
      paramToServiceMsg.append(" net_gap:");
      paramToServiceMsg.append(i);
      paramToServiceMsg.append(" isNewUser:");
      paramToServiceMsg.append(bool2);
      paramToServiceMsg.append(" uin:");
      paramToServiceMsg.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      paramToServiceMsg.append("  result:");
      paramToServiceMsg.append(k);
      QLog.i("CardHandler", 4, paramToServiceMsg.toString());
    }
  }
  
  private void P(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new oidb_cmd0xcd5.RspBody();
    int k = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
    paramFromServiceMsg = new ArrayList();
    int i;
    int j;
    boolean bool1;
    boolean bool2;
    if (k == 0)
    {
      try
      {
        paramToServiceMsg = (oidb_cmd0xcd5.GetDataRsp)paramToServiceMsg.getdata_rsp.get();
        if ((paramToServiceMsg != null) && (paramToServiceMsg.pb_data.has()))
        {
          paramToServiceMsg = paramToServiceMsg.pb_data.get().toByteArray();
          paramObject = new wording_storage.WordingCfg();
          paramObject.mergeFrom(paramToServiceMsg);
          if (paramObject.select_id.has()) {
            i = paramObject.select_id.get();
          } else {
            i = 0;
          }
          try
          {
            j = paramObject.auto_reply_flag.get();
            if (j == 0) {
              bool1 = false;
            } else {
              bool1 = true;
            }
            try
            {
              paramToServiceMsg = paramObject.wording_list.get();
              if (paramToServiceMsg != null)
              {
                paramToServiceMsg = paramToServiceMsg.iterator();
                j = 0;
                while (paramToServiceMsg.hasNext())
                {
                  paramObject = ((im_msg_body.RichText)paramToServiceMsg.next()).elems.get();
                  if ((paramObject != null) && (paramObject.size() > 0))
                  {
                    paramObject = new MessagePBElemDecoder().a(paramObject);
                    if (!TextUtils.isEmpty(paramObject))
                    {
                      if (QLog.isColorLevel())
                      {
                        StringBuilder localStringBuilder = new StringBuilder();
                        localStringBuilder.append("handleGetAutoReplyList, parse richText: ");
                        localStringBuilder.append(paramObject);
                        localStringBuilder.append(", id: ");
                        localStringBuilder.append(j);
                        QLog.d("CardHandler", 2, localStringBuilder.toString());
                      }
                      paramFromServiceMsg.add(new AutoReplyText(paramObject, j));
                      j += 1;
                    }
                  }
                }
              }
              bool2 = true;
            }
            catch (Exception paramToServiceMsg)
            {
              break label325;
            }
            bool2 = false;
          }
          catch (Exception paramToServiceMsg) {}
        }
        else
        {
          i = 0;
          bool1 = true;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        i = 0;
        bool1 = true;
        label325:
        paramToServiceMsg.printStackTrace();
        paramObject = new StringBuilder();
        paramObject.append("handleGetAutoReplyList exception: ");
        paramObject.append(paramToServiceMsg.getMessage());
        QLog.e("CardHandler", 1, paramObject.toString());
        bool2 = false;
      }
    }
    else
    {
      i = 0;
      bool2 = false;
      bool1 = true;
    }
    paramFromServiceMsg.add(new AutoReplyText(HardCodeUtil.a(2131701664), 2147483647));
    int m = paramFromServiceMsg.size();
    if ((bool1) && (m > 1))
    {
      if (i >= 0)
      {
        j = i;
        if (i < m) {}
      }
      else
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("handleGetAutoReplyList, error select id: ");
        paramToServiceMsg.append(i);
        QLog.d("CardHandler", 1, paramToServiceMsg.toString());
        j = 0;
      }
    }
    else {
      j = 2147483647;
    }
    if (bool2)
    {
      paramToServiceMsg = (IAutoReplyManager)((IOnlineStatusManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IAutoReplyManager.class);
      if (paramToServiceMsg != null) {
        paramToServiceMsg.a(paramFromServiceMsg, j);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, String.format("handleGetAutoReplyList result: %s, isSuccess: %s, enableAutoReply: %s, replyList size: %s, selectId: %s", new Object[] { Integer.valueOf(k), Boolean.valueOf(bool2), Boolean.valueOf(bool1), Integer.valueOf(m), Integer.valueOf(j) }));
    }
    notifyUI(95, bool2, new Object[] { paramFromServiceMsg, Integer.valueOf(j) });
  }
  
  private void Q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0xcd5.RspBody localRspBody = new oidb_cmd0xcd5.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    boolean bool3 = paramToServiceMsg.extraData.getBoolean("needNotify");
    boolean bool1;
    if ((i == 0) && (localRspBody.setdata_rsp.has()))
    {
      boolean bool2 = true;
      paramFromServiceMsg = paramToServiceMsg.extraData.getParcelableArrayList("replyMsgList");
      int j = paramToServiceMsg.extraData.getInt("selectId");
      paramToServiceMsg = (IAutoReplyManager)((IOnlineStatusManagerService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IOnlineStatusManagerService.class, "")).getManager(IAutoReplyManager.class);
      bool1 = bool2;
      if (paramToServiceMsg != null)
      {
        paramToServiceMsg.a(paramFromServiceMsg, j);
        bool1 = bool2;
      }
    }
    else
    {
      bool1 = false;
    }
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleSetAutoReplyList, result = ");
      paramToServiceMsg.append(i);
      QLog.d("CardHandler", 2, paramToServiceMsg.toString());
    }
    if (bool3) {
      notifyUI(97, bool1, null);
    }
  }
  
  private void R(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1 = paramFromServiceMsg.isSuccess();
    boolean bool2 = true;
    if ((bool1) && (paramObject != null)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleSetStrangerInviteToGroupSwitch success=");
      paramFromServiceMsg.append(bool1);
      QLog.d("Q.profilecard.", 2, paramFromServiceMsg.toString());
    }
    if (bool1) {}
    for (;;)
    {
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg.uint32_result.get() != 0) {
          break label190;
        }
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          paramObject = new StringBuilder();
          paramObject.append("handleSetStrangerInviteToGroupSwitch result=");
          paramObject.append(bool1);
          QLog.d("Q.profilecard.", 2, paramObject.toString());
        }
        bool1 = a(paramToServiceMsg, bool1, paramFromServiceMsg);
        if (bool1) {
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.", 2, "handleSetStrangerInviteToGroupSwitch ex", paramToServiceMsg);
        }
      }
      notifyUI(93, false, null);
      return;
      label190:
      bool1 = false;
    }
  }
  
  /* Error */
  private void S(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 101	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: ifeq +13 -> 17
    //   7: aload_3
    //   8: ifnull +9 -> 17
    //   11: iconst_1
    //   12: istore 7
    //   14: goto +6 -> 20
    //   17: iconst_0
    //   18: istore 7
    //   20: new 20	java/lang/StringBuilder
    //   23: dup
    //   24: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   27: astore 8
    //   29: aload 8
    //   31: ldc_w 842
    //   34: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload 8
    //   40: iload 7
    //   42: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: ldc_w 844
    //   49: iconst_2
    //   50: aload 8
    //   52: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   58: iconst_m1
    //   59: istore 4
    //   61: iload 7
    //   63: ifne +78 -> 141
    //   66: iload 4
    //   68: istore 6
    //   70: new 20	java/lang/StringBuilder
    //   73: dup
    //   74: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   77: astore_3
    //   78: iload 4
    //   80: istore 6
    //   82: aload_3
    //   83: ldc_w 846
    //   86: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: iload 4
    //   92: istore 6
    //   94: aload_3
    //   95: aload_2
    //   96: invokevirtual 849	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   99: invokevirtual 391	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: iload 4
    //   105: istore 6
    //   107: ldc_w 844
    //   110: iconst_2
    //   111: aload_3
    //   112: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   115: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   118: aload_0
    //   119: bipush 103
    //   121: iconst_0
    //   122: aload_1
    //   123: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   126: ldc_w 851
    //   129: invokevirtual 208	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   132: iconst_1
    //   133: ixor
    //   134: invokestatic 365	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   137: invokevirtual 228	com/tencent/mobileqq/app/CardHandler:notifyUI	(IZLjava/lang/Object;)V
    //   140: return
    //   141: iload 4
    //   143: istore 6
    //   145: new 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   148: dup
    //   149: invokespecial 120	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   152: aload_3
    //   153: checkcast 122	[B
    //   156: checkcast 122	[B
    //   159: invokevirtual 126	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   162: checkcast 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   165: astore_2
    //   166: iload 4
    //   168: istore 5
    //   170: iload 4
    //   172: istore 6
    //   174: aload_2
    //   175: getfield 130	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   178: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   181: ifne +534 -> 715
    //   184: iconst_1
    //   185: istore 5
    //   187: goto +3 -> 190
    //   190: iload 5
    //   192: ifne +115 -> 307
    //   195: iload 4
    //   197: istore 5
    //   199: iload 4
    //   201: istore 6
    //   203: aload_2
    //   204: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   207: invokevirtual 146	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   210: ifeq +97 -> 307
    //   213: iload 4
    //   215: istore 5
    //   217: iload 4
    //   219: istore 6
    //   221: new 20	java/lang/StringBuilder
    //   224: dup
    //   225: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   228: astore_3
    //   229: iload 4
    //   231: istore 5
    //   233: iload 4
    //   235: istore 6
    //   237: aload_3
    //   238: ldc_w 853
    //   241: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: pop
    //   245: iload 4
    //   247: istore 5
    //   249: iload 4
    //   251: istore 6
    //   253: aload_3
    //   254: aload_2
    //   255: getfield 130	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   258: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   261: invokevirtual 391	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   264: pop
    //   265: iload 4
    //   267: istore 5
    //   269: iload 4
    //   271: istore 6
    //   273: ldc_w 844
    //   276: iconst_2
    //   277: aload_3
    //   278: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: invokestatic 783	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   284: aload_0
    //   285: bipush 103
    //   287: iconst_0
    //   288: aload_1
    //   289: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   292: ldc_w 851
    //   295: invokevirtual 208	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   298: iconst_1
    //   299: ixor
    //   300: invokestatic 365	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   303: invokevirtual 228	com/tencent/mobileqq/app/CardHandler:notifyUI	(IZLjava/lang/Object;)V
    //   306: return
    //   307: iload 4
    //   309: istore 5
    //   311: iload 4
    //   313: istore 6
    //   315: new 855	tencent/im/oidb/cmd0xd8a$RspBody
    //   318: dup
    //   319: invokespecial 856	tencent/im/oidb/cmd0xd8a$RspBody:<init>	()V
    //   322: astore_3
    //   323: iload 4
    //   325: istore 5
    //   327: iload 4
    //   329: istore 6
    //   331: aload_3
    //   332: aload_2
    //   333: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   336: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   339: invokevirtual 155	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   342: invokevirtual 857	tencent/im/oidb/cmd0xd8a$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   345: pop
    //   346: iload 4
    //   348: istore 5
    //   350: iload 4
    //   352: istore 6
    //   354: aload_3
    //   355: getfield 860	tencent/im/oidb/cmd0xd8a$RspBody:uint32_retcode	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   358: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   361: istore 4
    //   363: iload 4
    //   365: istore 5
    //   367: iload 4
    //   369: istore 6
    //   371: aload_3
    //   372: getfield 863	tencent/im/oidb/cmd0xd8a$RspBody:str_res	Lcom/tencent/mobileqq/pb/PBStringField;
    //   375: invokevirtual 409	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   378: astore_2
    //   379: iload 4
    //   381: istore 5
    //   383: iload 4
    //   385: istore 6
    //   387: new 20	java/lang/StringBuilder
    //   390: dup
    //   391: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   394: astore_3
    //   395: iload 4
    //   397: istore 5
    //   399: iload 4
    //   401: istore 6
    //   403: aload_3
    //   404: ldc_w 865
    //   407: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: pop
    //   411: iload 4
    //   413: istore 5
    //   415: iload 4
    //   417: istore 6
    //   419: aload_3
    //   420: iload 4
    //   422: invokevirtual 391	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   425: pop
    //   426: iload 4
    //   428: istore 5
    //   430: iload 4
    //   432: istore 6
    //   434: aload_3
    //   435: ldc_w 867
    //   438: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: pop
    //   442: iload 4
    //   444: istore 5
    //   446: iload 4
    //   448: istore 6
    //   450: aload_3
    //   451: aload_2
    //   452: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: pop
    //   456: iload 4
    //   458: istore 5
    //   460: iload 4
    //   462: istore 6
    //   464: ldc_w 844
    //   467: iconst_1
    //   468: aload_3
    //   469: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   472: invokestatic 783	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   475: aload_1
    //   476: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   479: ldc_w 851
    //   482: invokevirtual 208	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   485: istore 7
    //   487: iload 4
    //   489: ifne +12 -> 501
    //   492: aload_0
    //   493: bipush 103
    //   495: iconst_1
    //   496: aconst_null
    //   497: invokevirtual 228	com/tencent/mobileqq/app/CardHandler:notifyUI	(IZLjava/lang/Object;)V
    //   500: return
    //   501: aload_0
    //   502: bipush 103
    //   504: iconst_0
    //   505: iload 7
    //   507: iconst_1
    //   508: ixor
    //   509: invokestatic 365	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   512: invokevirtual 228	com/tencent/mobileqq/app/CardHandler:notifyUI	(IZLjava/lang/Object;)V
    //   515: return
    //   516: astore_2
    //   517: iconst_1
    //   518: istore 6
    //   520: iload 5
    //   522: istore 4
    //   524: iload 6
    //   526: istore 5
    //   528: goto +11 -> 539
    //   531: astore_2
    //   532: goto +133 -> 665
    //   535: astore_2
    //   536: iconst_0
    //   537: istore 5
    //   539: iload 5
    //   541: ifeq +55 -> 596
    //   544: iload 4
    //   546: istore 6
    //   548: new 20	java/lang/StringBuilder
    //   551: dup
    //   552: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   555: astore_3
    //   556: iload 4
    //   558: istore 6
    //   560: aload_3
    //   561: ldc_w 869
    //   564: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: pop
    //   568: iload 4
    //   570: istore 6
    //   572: aload_3
    //   573: aload_2
    //   574: invokevirtual 872	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   577: pop
    //   578: iload 4
    //   580: istore 6
    //   582: ldc_w 844
    //   585: iconst_1
    //   586: aload_3
    //   587: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   590: invokestatic 783	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   593: goto +52 -> 645
    //   596: iload 4
    //   598: istore 6
    //   600: new 20	java/lang/StringBuilder
    //   603: dup
    //   604: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   607: astore_3
    //   608: iload 4
    //   610: istore 6
    //   612: aload_3
    //   613: ldc_w 874
    //   616: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: pop
    //   620: iload 4
    //   622: istore 6
    //   624: aload_3
    //   625: aload_2
    //   626: invokevirtual 872	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   629: pop
    //   630: iload 4
    //   632: istore 6
    //   634: ldc_w 844
    //   637: iconst_1
    //   638: aload_3
    //   639: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   642: invokestatic 783	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   645: aload_1
    //   646: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   649: ldc_w 851
    //   652: invokevirtual 208	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   655: istore 7
    //   657: iload 4
    //   659: ifne -158 -> 501
    //   662: goto -170 -> 492
    //   665: aload_1
    //   666: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   669: ldc_w 851
    //   672: invokevirtual 208	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   675: istore 7
    //   677: iload 6
    //   679: ifeq +20 -> 699
    //   682: aload_0
    //   683: bipush 103
    //   685: iconst_0
    //   686: iload 7
    //   688: iconst_1
    //   689: ixor
    //   690: invokestatic 365	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   693: invokevirtual 228	com/tencent/mobileqq/app/CardHandler:notifyUI	(IZLjava/lang/Object;)V
    //   696: goto +11 -> 707
    //   699: aload_0
    //   700: bipush 103
    //   702: iconst_1
    //   703: aconst_null
    //   704: invokevirtual 228	com/tencent/mobileqq/app/CardHandler:notifyUI	(IZLjava/lang/Object;)V
    //   707: goto +5 -> 712
    //   710: aload_2
    //   711: athrow
    //   712: goto -2 -> 710
    //   715: iconst_0
    //   716: istore 5
    //   718: goto -528 -> 190
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	721	0	this	CardHandler
    //   0	721	1	paramToServiceMsg	ToServiceMsg
    //   0	721	2	paramFromServiceMsg	FromServiceMsg
    //   0	721	3	paramObject	Object
    //   59	599	4	i	int
    //   168	549	5	j	int
    //   68	610	6	k	int
    //   12	678	7	bool	boolean
    //   27	24	8	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   174	184	516	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   203	213	516	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   221	229	516	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   237	245	516	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   253	265	516	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   273	284	516	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   315	323	516	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   331	346	516	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   354	363	516	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   371	379	516	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   387	395	516	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   403	411	516	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   419	426	516	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   434	442	516	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   450	456	516	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   464	475	516	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   70	78	531	finally
    //   82	90	531	finally
    //   94	103	531	finally
    //   107	118	531	finally
    //   145	166	531	finally
    //   174	184	531	finally
    //   203	213	531	finally
    //   221	229	531	finally
    //   237	245	531	finally
    //   253	265	531	finally
    //   273	284	531	finally
    //   315	323	531	finally
    //   331	346	531	finally
    //   354	363	531	finally
    //   371	379	531	finally
    //   387	395	531	finally
    //   403	411	531	finally
    //   419	426	531	finally
    //   434	442	531	finally
    //   450	456	531	finally
    //   464	475	531	finally
    //   548	556	531	finally
    //   560	568	531	finally
    //   572	578	531	finally
    //   582	593	531	finally
    //   600	608	531	finally
    //   612	620	531	finally
    //   624	630	531	finally
    //   634	645	531	finally
    //   70	78	535	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   82	90	535	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   94	103	535	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   107	118	535	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   145	166	535	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  /* Error */
  private void T(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 101	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: istore 4
    //   6: iconst_0
    //   7: istore 10
    //   9: iconst_0
    //   10: istore 9
    //   12: iload 4
    //   14: ifeq +13 -> 27
    //   17: aload_3
    //   18: ifnull +9 -> 27
    //   21: iconst_1
    //   22: istore 4
    //   24: goto +6 -> 30
    //   27: iconst_0
    //   28: istore 4
    //   30: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   33: ifeq +37 -> 70
    //   36: new 20	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   43: astore_2
    //   44: aload_2
    //   45: ldc_w 877
    //   48: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: aload_2
    //   53: iload 4
    //   55: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: ldc_w 368
    //   62: iconst_2
    //   63: aload_2
    //   64: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   67: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   70: iload 10
    //   72: istore 7
    //   74: iload 4
    //   76: istore 8
    //   78: iload 4
    //   80: ifeq +626 -> 706
    //   83: iload 4
    //   85: istore 5
    //   87: iload 4
    //   89: istore 6
    //   91: new 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   94: dup
    //   95: invokespecial 120	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   98: aload_3
    //   99: checkcast 122	[B
    //   102: checkcast 122	[B
    //   105: invokevirtual 126	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   108: checkcast 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   111: astore_2
    //   112: iload 4
    //   114: istore 5
    //   116: iload 4
    //   118: istore 6
    //   120: aload_2
    //   121: getfield 130	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   124: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   127: ifne +651 -> 778
    //   130: iconst_1
    //   131: istore 4
    //   133: goto +3 -> 136
    //   136: iload 4
    //   138: istore 5
    //   140: iload 4
    //   142: istore 6
    //   144: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   147: ifeq +69 -> 216
    //   150: iload 4
    //   152: istore 5
    //   154: iload 4
    //   156: istore 6
    //   158: new 20	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   165: astore_3
    //   166: iload 4
    //   168: istore 5
    //   170: iload 4
    //   172: istore 6
    //   174: aload_3
    //   175: ldc_w 879
    //   178: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: iload 4
    //   184: istore 5
    //   186: iload 4
    //   188: istore 6
    //   190: aload_3
    //   191: iload 4
    //   193: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   196: pop
    //   197: iload 4
    //   199: istore 5
    //   201: iload 4
    //   203: istore 6
    //   205: ldc_w 368
    //   208: iconst_2
    //   209: aload_3
    //   210: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   216: iload 10
    //   218: istore 7
    //   220: iload 4
    //   222: istore 8
    //   224: iload 4
    //   226: ifeq +480 -> 706
    //   229: iload 4
    //   231: istore 5
    //   233: iload 4
    //   235: istore 6
    //   237: iload 10
    //   239: istore 7
    //   241: iload 4
    //   243: istore 8
    //   245: aload_2
    //   246: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   249: invokevirtual 146	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   252: ifeq +454 -> 706
    //   255: iload 4
    //   257: istore 5
    //   259: iload 4
    //   261: istore 6
    //   263: iload 10
    //   265: istore 7
    //   267: iload 4
    //   269: istore 8
    //   271: aload_2
    //   272: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   275: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   278: ifnull +428 -> 706
    //   281: iload 4
    //   283: istore 5
    //   285: iload 4
    //   287: istore 6
    //   289: aload_2
    //   290: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   293: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   296: invokevirtual 155	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   299: invokestatic 161	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   302: invokevirtual 164	java/nio/ByteBuffer:getInt	()I
    //   305: invokestatic 500	com/tencent/mobileqq/util/Utils:a	(I)J
    //   308: lstore 11
    //   310: iload 4
    //   312: istore 5
    //   314: iload 4
    //   316: istore 6
    //   318: aload_0
    //   319: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   322: invokevirtual 171	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   325: lload 11
    //   327: invokestatic 176	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   330: invokevirtual 179	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   333: ifeq +70 -> 403
    //   336: iload 4
    //   338: istore 5
    //   340: iload 4
    //   342: istore 6
    //   344: aload_1
    //   345: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   348: ldc_w 881
    //   351: invokevirtual 208	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   354: istore 7
    //   356: aload_0
    //   357: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   360: ldc_w 883
    //   363: invokevirtual 886	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;)Lmqq/app/api/IRuntimeService;
    //   366: checkcast 883	com/tencent/mobileqq/activity/aio/stickerrecommended/IStickerRecManager
    //   369: iload 7
    //   371: invokeinterface 890 2 0
    //   376: iload 4
    //   378: istore 8
    //   380: goto +326 -> 706
    //   383: astore_1
    //   384: iload 7
    //   386: istore 6
    //   388: goto +261 -> 649
    //   391: astore_1
    //   392: iload 4
    //   394: istore 5
    //   396: iload 7
    //   398: istore 4
    //   400: goto +158 -> 558
    //   403: iload 4
    //   405: istore 5
    //   407: iload 4
    //   409: istore 6
    //   411: iload 10
    //   413: istore 7
    //   415: iload 4
    //   417: istore 8
    //   419: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   422: ifeq +284 -> 706
    //   425: iload 4
    //   427: istore 5
    //   429: iload 4
    //   431: istore 6
    //   433: new 20	java/lang/StringBuilder
    //   436: dup
    //   437: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   440: astore_1
    //   441: iload 4
    //   443: istore 5
    //   445: iload 4
    //   447: istore 6
    //   449: aload_1
    //   450: ldc_w 892
    //   453: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   456: pop
    //   457: iload 4
    //   459: istore 5
    //   461: iload 4
    //   463: istore 6
    //   465: aload_1
    //   466: aload_0
    //   467: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   470: invokevirtual 171	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   473: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: pop
    //   477: iload 4
    //   479: istore 5
    //   481: iload 4
    //   483: istore 6
    //   485: aload_1
    //   486: ldc_w 507
    //   489: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: pop
    //   493: iload 4
    //   495: istore 5
    //   497: iload 4
    //   499: istore 6
    //   501: aload_1
    //   502: lload 11
    //   504: invokevirtual 304	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   507: pop
    //   508: iload 4
    //   510: istore 5
    //   512: iload 4
    //   514: istore 6
    //   516: ldc_w 368
    //   519: iconst_2
    //   520: aload_1
    //   521: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   524: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   527: iload 10
    //   529: istore 7
    //   531: iload 4
    //   533: istore 8
    //   535: goto +171 -> 706
    //   538: astore_1
    //   539: iload 9
    //   541: istore 6
    //   543: iload 5
    //   545: istore 4
    //   547: goto +102 -> 649
    //   550: astore_1
    //   551: iload 6
    //   553: istore 5
    //   555: iconst_0
    //   556: istore 4
    //   558: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   561: ifeq +14 -> 575
    //   564: ldc_w 368
    //   567: iconst_1
    //   568: ldc_w 894
    //   571: aload_1
    //   572: invokestatic 896	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   575: iload 4
    //   577: istore 5
    //   579: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   582: ifeq +183 -> 765
    //   585: new 20	java/lang/StringBuilder
    //   588: dup
    //   589: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   592: astore_1
    //   593: aload_1
    //   594: ldc_w 879
    //   597: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   600: pop
    //   601: aload_1
    //   602: iconst_0
    //   603: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   606: pop
    //   607: aload_1
    //   608: ldc_w 898
    //   611: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   614: pop
    //   615: aload_1
    //   616: iload 4
    //   618: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   621: pop
    //   622: ldc_w 368
    //   625: iconst_2
    //   626: aload_1
    //   627: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   630: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   633: iload 4
    //   635: istore 5
    //   637: goto +128 -> 765
    //   640: astore_1
    //   641: iload 4
    //   643: istore 6
    //   645: iload 5
    //   647: istore 4
    //   649: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   652: ifeq +52 -> 704
    //   655: new 20	java/lang/StringBuilder
    //   658: dup
    //   659: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   662: astore_2
    //   663: aload_2
    //   664: ldc_w 879
    //   667: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: pop
    //   671: aload_2
    //   672: iload 4
    //   674: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   677: pop
    //   678: aload_2
    //   679: ldc_w 898
    //   682: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   685: pop
    //   686: aload_2
    //   687: iload 6
    //   689: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   692: pop
    //   693: ldc_w 368
    //   696: iconst_2
    //   697: aload_2
    //   698: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   701: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   704: aload_1
    //   705: athrow
    //   706: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   709: ifeq +52 -> 761
    //   712: new 20	java/lang/StringBuilder
    //   715: dup
    //   716: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   719: astore_1
    //   720: aload_1
    //   721: ldc_w 879
    //   724: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   727: pop
    //   728: aload_1
    //   729: iload 8
    //   731: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   734: pop
    //   735: aload_1
    //   736: ldc_w 898
    //   739: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   742: pop
    //   743: aload_1
    //   744: iload 7
    //   746: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   749: pop
    //   750: ldc_w 368
    //   753: iconst_2
    //   754: aload_1
    //   755: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   758: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   761: iload 7
    //   763: istore 5
    //   765: aload_0
    //   766: bipush 102
    //   768: iconst_1
    //   769: iload 5
    //   771: invokestatic 365	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   774: invokevirtual 228	com/tencent/mobileqq/app/CardHandler:notifyUI	(IZLjava/lang/Object;)V
    //   777: return
    //   778: iconst_0
    //   779: istore 4
    //   781: goto -645 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	784	0	this	CardHandler
    //   0	784	1	paramToServiceMsg	ToServiceMsg
    //   0	784	2	paramFromServiceMsg	FromServiceMsg
    //   0	784	3	paramObject	Object
    //   4	776	4	bool1	boolean
    //   85	685	5	bool2	boolean
    //   89	599	6	bool3	boolean
    //   72	690	7	bool4	boolean
    //   76	654	8	bool5	boolean
    //   10	530	9	bool6	boolean
    //   7	521	10	bool7	boolean
    //   308	195	11	l	long
    // Exception table:
    //   from	to	target	type
    //   356	376	383	finally
    //   356	376	391	java/lang/Exception
    //   91	112	538	finally
    //   120	130	538	finally
    //   144	150	538	finally
    //   158	166	538	finally
    //   174	182	538	finally
    //   190	197	538	finally
    //   205	216	538	finally
    //   245	255	538	finally
    //   271	281	538	finally
    //   289	310	538	finally
    //   318	336	538	finally
    //   344	356	538	finally
    //   419	425	538	finally
    //   433	441	538	finally
    //   449	457	538	finally
    //   465	477	538	finally
    //   485	493	538	finally
    //   501	508	538	finally
    //   516	527	538	finally
    //   91	112	550	java/lang/Exception
    //   120	130	550	java/lang/Exception
    //   144	150	550	java/lang/Exception
    //   158	166	550	java/lang/Exception
    //   174	182	550	java/lang/Exception
    //   190	197	550	java/lang/Exception
    //   205	216	550	java/lang/Exception
    //   245	255	550	java/lang/Exception
    //   271	281	550	java/lang/Exception
    //   289	310	550	java/lang/Exception
    //   318	336	550	java/lang/Exception
    //   344	356	550	java/lang/Exception
    //   419	425	550	java/lang/Exception
    //   433	441	550	java/lang/Exception
    //   449	457	550	java/lang/Exception
    //   465	477	550	java/lang/Exception
    //   485	493	550	java/lang/Exception
    //   501	508	550	java/lang/Exception
    //   516	527	550	java/lang/Exception
    //   558	575	640	finally
  }
  
  private void U(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = ((Long)paramToServiceMsg.getAttribute("uin", Long.valueOf(0L))).longValue();
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleGetEducationList ");
      paramToServiceMsg.append(l);
      QLog.d("CardHandler", 2, paramToServiceMsg.toString());
    }
    Object localObject = new oidb_cmd0xd2d.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    if (i == 0)
    {
      paramToServiceMsg = new ArrayList(5);
      if (((oidb_cmd0xd2d.RspBody)localObject).msg_edu_his.has())
      {
        paramFromServiceMsg = (oidb_cmd0xd2d.EduHis)((oidb_cmd0xd2d.RspBody)localObject).msg_edu_his.get();
        if (paramFromServiceMsg.rpt_msg_school.has())
        {
          paramFromServiceMsg = paramFromServiceMsg.rpt_msg_school.get().iterator();
          while (paramFromServiceMsg.hasNext())
          {
            paramObject = (oidb_cmd0xd2d.SchoolInfo)paramFromServiceMsg.next();
            localObject = new SchoolInfo();
            ((SchoolInfo)localObject).jdField_a_of_type_Int = paramObject.uint32_idx.get();
            ((SchoolInfo)localObject).jdField_c_of_type_JavaLangString = paramObject.str_department_id.get();
            ((SchoolInfo)localObject).jdField_d_of_type_JavaLangString = paramObject.str_department_name.get();
            ((SchoolInfo)localObject).jdField_a_of_type_JavaLangString = paramObject.str_school_id.get();
            ((SchoolInfo)localObject).jdField_b_of_type_JavaLangString = paramObject.str_school_name.get();
            ((SchoolInfo)localObject).jdField_b_of_type_Int = paramObject.uint32_category.get();
            ((SchoolInfo)localObject).jdField_c_of_type_Int = paramObject.uint32_degree.get();
            ((SchoolInfo)localObject).jdField_d_of_type_Int = paramObject.uint32_enrollment_year.get();
            ((SchoolInfo)localObject).e = paramObject.uint32_graduation_year.get();
            ((SchoolInfo)localObject).f = paramObject.uint32_allow_recommend.get();
            boolean bool;
            if (paramObject.uint32_hidden_flag.get() == 1) {
              bool = true;
            } else {
              bool = false;
            }
            ((SchoolInfo)localObject).jdField_a_of_type_Boolean = bool;
            if (paramObject.uint32_verify_status.get() == 2) {
              bool = true;
            } else {
              bool = false;
            }
            ((SchoolInfo)localObject).jdField_b_of_type_Boolean = bool;
            paramToServiceMsg.add(localObject);
          }
        }
      }
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("handleGetEducationList ");
        paramFromServiceMsg.append(paramToServiceMsg.toString());
        QLog.d("CardHandler", 2, paramFromServiceMsg.toString());
      }
      ((BusinessCardManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.BUSINESS_CARD_MANAGER)).a(paramToServiceMsg);
      notifyUI(99, true, new Object[] { Long.valueOf(l), paramToServiceMsg });
      return;
    }
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleGetEducationList failed result:");
      paramToServiceMsg.append(i);
      QLog.i("CardHandler", 2, paramToServiceMsg.toString());
    }
    notifyUI(99, false, new Object[] { Long.valueOf(l), null });
  }
  
  protected static int a(Context paramContext)
  {
    paramContext = paramContext.getResources().getDisplayMetrics();
    int j = paramContext.widthPixels;
    int k = paramContext.heightPixels;
    int i = k;
    if (j > k) {
      i = j;
    }
    return i;
  }
  
  public static String a(String paramString, int paramInt)
  {
    if ((paramString != null) && (!"".equals(paramString)))
    {
      if (!jdField_a_of_type_JavaUtilVector.contains(Integer.valueOf(paramInt))) {
        return "";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(jdField_a_of_type_JavaLangString);
      localStringBuilder.append(paramInt);
      localStringBuilder.append("/");
      localStringBuilder.append(paramString);
      localStringBuilder.append(".jpg");
      return localStringBuilder.toString();
    }
    return "";
  }
  
  private short a(short paramShort, boolean paramBoolean)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, Bundle paramBundle)
  {
    boolean bool;
    if (paramFromServiceMsg.getResultCode() == 1000) {
      bool = true;
    } else {
      bool = false;
    }
    notifyUI(29, bool, paramBundle);
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject = new cmd0x7a8.RspBody();
    int i2 = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject);
    MedalWallMng localMedalWallMng = (MedalWallMng)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MEDAL_WALL_MNG);
    boolean bool2 = true;
    if (i2 == 0)
    {
      TMedalWallInfo localTMedalWallInfo = new TMedalWallInfo();
      localTMedalWallInfo.iOpenFlag = -2147483648;
      localTMedalWallInfo.iMedalCount = ((cmd0x7a8.RspBody)localObject).uint32_metal_count.get();
      localTMedalWallInfo.iNewCount = ((cmd0x7a8.RspBody)localObject).int32_new_count.get();
      localTMedalWallInfo.iUpgradeCount = ((cmd0x7a8.RspBody)localObject).int32_upgrade_count.get();
      localTMedalWallInfo.strPromptParams = ((cmd0x7a8.RspBody)localObject).str_prompt_params.get();
      paramObject = ((cmd0x7a8.RspBody)localObject).rpt_msg_medal.get();
      ArrayList localArrayList = new ArrayList();
      if ((paramObject != null) && (paramObject.size() > 0))
      {
        paramFromServiceMsg = new SparseArray(paramObject.size());
        paramObject = paramObject.iterator();
        while (paramObject.hasNext())
        {
          localObject = (common.MedalInfo)paramObject.next();
          if (localObject != null)
          {
            int i3 = ((common.MedalInfo)localObject).uint32_level.get();
            if (i3 == 0)
            {
              if (QLog.isColorLevel()) {
                QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "handleGetSelfNewObtainedMedal medal[%d] get level[%d]", new Object[] { Integer.valueOf(((common.MedalInfo)localObject).uint32_id.get()), Integer.valueOf(i3) }));
              }
            }
            else
            {
              MedalInfo localMedalInfo = localMedalWallMng.a(((common.MedalInfo)localObject).uint32_id.get());
              localMedalInfo.strName = ((common.MedalInfo)localObject).str_name.get();
              localMedalInfo.iType = ((common.MedalInfo)localObject).uint32_type.get();
              localMedalInfo.iNoProgress = ((common.MedalInfo)localObject).uint32_no_progress.get();
              localMedalInfo.strResJson = ((common.MedalInfo)localObject).str_resource.get();
              localMedalInfo.iLevelCount = ((common.MedalInfo)localObject).uint32_level_count.get();
              localMedalInfo.lSeqLevel1 = ((common.MedalInfo)localObject).uint32_seq.get();
              localMedalInfo.lObtainTimeLevel1 = ((common.MedalInfo)localObject).uint64_time.get();
              localMedalInfo.strDescLevel1 = ((common.MedalInfo)localObject).str_desc.get();
              localMedalInfo.iPointLevel1 = ((common.MedalInfo)localObject).uint32_point.get();
              localMedalInfo.strDetailUrlLevel1 = ((common.MedalInfo)localObject).str_detail_url.get();
              localMedalInfo.strTaskDescLevel1 = ((common.MedalInfo)localObject).str_task_desc.get();
              localMedalInfo.lSeqLevel2 = ((common.MedalInfo)localObject).uint32_seq_level2.get();
              localMedalInfo.lObtainTimeLevel2 = ((common.MedalInfo)localObject).uint64_time_level2.get();
              localMedalInfo.strDescLevel2 = ((common.MedalInfo)localObject).str_desc_level2.get();
              localMedalInfo.iPointLevel2 = ((common.MedalInfo)localObject).uint32_point_level2.get();
              localMedalInfo.strDetailUrlLevel2 = ((common.MedalInfo)localObject).str_detail_url_2.get();
              localMedalInfo.strTaskDescLevel2 = ((common.MedalInfo)localObject).str_task_desc_2.get();
              localMedalInfo.lSeqLevel3 = ((common.MedalInfo)localObject).uint32_seq_level3.get();
              localMedalInfo.lObtainTimeLevel3 = ((common.MedalInfo)localObject).uint64_time_level3.get();
              localMedalInfo.strDescLevel3 = ((common.MedalInfo)localObject).str_desc_level3.get();
              localMedalInfo.iPointLevel3 = ((common.MedalInfo)localObject).uint32_point_level3.get();
              localMedalInfo.strDetailUrlLevel3 = ((common.MedalInfo)localObject).str_detail_url_3.get();
              localMedalInfo.strTaskDescLevel3 = ((common.MedalInfo)localObject).str_task_desc_3.get();
              int j = ((common.MedalInfo)localObject).uint32_unread.get();
              int k = ((common.MedalInfo)localObject).uint32_unread_2.get();
              int i1 = ((common.MedalInfo)localObject).uint32_unread_3.get();
              if (i3 == 255)
              {
                if ((localMedalInfo.iLevel == i3) && (localMedalInfo.iUnreadLevel1 == 2) && (j == 1))
                {
                  localArrayList.add(new MedalID(localMedalInfo.iId, 255));
                  j = 2;
                  n = i1;
                  break label889;
                }
              }
              else if (localMedalInfo.iLevelCount > 1)
              {
                int i = j;
                if (localMedalInfo.iLevel >= 1)
                {
                  i = j;
                  if (localMedalInfo.iUnreadLevel1 == 2)
                  {
                    i = j;
                    if (j == 1)
                    {
                      localArrayList.add(new MedalID(localMedalInfo.iId, 1));
                      i = localMedalInfo.iUnreadLevel1;
                    }
                  }
                }
                int m = i;
                i = k;
                if (localMedalInfo.iLevel >= 2)
                {
                  i = k;
                  if (localMedalInfo.iUnreadLevel2 == 2)
                  {
                    i = k;
                    if (k == 1)
                    {
                      localArrayList.add(new MedalID(localMedalInfo.iId, 2));
                      i = localMedalInfo.iUnreadLevel2;
                    }
                  }
                }
                k = i;
                j = m;
                n = i1;
                if (localMedalInfo.iLevel < 3) {
                  break label889;
                }
                k = i;
                j = m;
                n = i1;
                if (localMedalInfo.iUnreadLevel3 != 2) {
                  break label889;
                }
                k = i;
                j = m;
                n = i1;
                if (i1 != 1) {
                  break label889;
                }
                localArrayList.add(new MedalID(localMedalInfo.iId, 3));
                n = localMedalInfo.iUnreadLevel3;
                k = i;
                j = m;
                break label889;
              }
              int n = i1;
              label889:
              localMedalInfo.iLevel = i3;
              localMedalInfo.iUnreadLevel1 = j;
              localMedalInfo.iUnreadLevel2 = k;
              localMedalInfo.iUnreadLevel3 = n;
              paramFromServiceMsg.put(localMedalInfo.iId, localMedalInfo);
            }
          }
        }
      }
      else
      {
        paramFromServiceMsg = null;
      }
      localObject = paramFromServiceMsg;
      paramObject = localTMedalWallInfo;
      if (localArrayList.size() > 0)
      {
        b(localArrayList);
        localObject = paramFromServiceMsg;
        paramObject = localTMedalWallInfo;
      }
    }
    else
    {
      localObject = null;
      paramObject = null;
    }
    if (QLog.isColorLevel()) {
      QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "handleGetSelfNewObtainedMedal result: %d", new Object[] { Integer.valueOf(i2) }));
    }
    boolean bool1;
    if (i2 == 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localMedalWallMng.a(bool1, paramObject, (SparseArray)localObject);
    if (i2 == 0) {
      paramFromServiceMsg = ((FriendsManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), true);
    } else {
      paramFromServiceMsg = null;
    }
    if (i2 == 0) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    notifyUI(51, bool1, paramFromServiceMsg);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, Bundle paramBundle, Card paramCard, RespGetVoterList paramRespGetVoterList, StringBuilder paramStringBuilder, int paramInt)
  {
    Iterator localIterator = paramRespGetVoterList.vVoterInfos.iterator();
    ArrayList localArrayList = new ArrayList(0);
    while (localIterator.hasNext())
    {
      UserProfile localUserProfile = (UserProfile)localIterator.next();
      CardProfile localCardProfile = new CardProfile();
      localCardProfile.readFrom(localUserProfile);
      localCardProfile.type = 2;
      localArrayList.add(localCardProfile);
      if ((QLog.isColorLevel()) && (paramStringBuilder != null))
      {
        paramStringBuilder.append("\n");
        paramStringBuilder.append("i=");
        paramStringBuilder.append(paramInt);
        paramStringBuilder.append(",");
        paramStringBuilder.append(localCardProfile.getSimpleZanInfo());
        paramInt += 1;
      }
    }
    paramBundle.putLong("respTime", paramRespGetVoterList.RespTime);
    paramBundle.putLong("startMid", paramToServiceMsg.extraData.getLong("nextMid"));
    paramBundle.putLong("nextMid", paramRespGetVoterList.stUserData.lNextMid);
    paramBundle.putByteArray("strCookie", paramRespGetVoterList.stUserData.strCookie);
    long l = paramToServiceMsg.extraData.getLong("nextMid", -1L);
    if (l == 0L) {
      a(2);
    }
    b(paramToServiceMsg.getUin(), localArrayList);
    paramToServiceMsg = new ArrayList(0);
    if (l == 0L)
    {
      if (paramRespGetVoterList.vTodayFavoriteInfos != null)
      {
        paramStringBuilder = paramRespGetVoterList.vTodayFavoriteInfos.iterator();
        while (paramStringBuilder.hasNext()) {
          paramToServiceMsg.add(Long.valueOf(((UserProfile)paramStringBuilder.next()).lEctID));
        }
      }
      b(paramToServiceMsg);
    }
    notifyUI(6, true, new Object[] { paramCard, paramBundle, localArrayList, paramToServiceMsg, Integer.valueOf(paramRespGetVoterList.iMaxFriendFavoriteCount), Integer.valueOf(paramRespGetVoterList.iMaxStrangerFavoriteCount), Integer.valueOf(paramRespGetVoterList.iTodayVoteCount), Integer.valueOf(paramRespGetVoterList.iTodayVoteRank), Integer.valueOf(paramRespGetVoterList.iTotalVoteCount) });
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Bundle paramBundle)
  {
    paramBundle.putString("uin", String.valueOf(paramToServiceMsg.extraData.getLong("lToUIN")));
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      notifyUI(23, true, paramBundle);
      return;
    }
    notifyUI(23, false, paramBundle);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if ("MCardSvc.ReqSetCard".equals(str))
    {
      k(paramToServiceMsg, paramFromServiceMsg, paramObject, paramBundle);
      return;
    }
    if ("SummaryCard.SetLabel".equals(str))
    {
      l(paramToServiceMsg, paramFromServiceMsg, paramObject, paramBundle);
      return;
    }
    if ("SummaryCard.LikeIt".equals(str))
    {
      m(paramToServiceMsg, paramFromServiceMsg, paramObject, paramBundle);
      return;
    }
    if ("MCardSvc.ReqGetCardSwitch".equals(str))
    {
      i(paramToServiceMsg, paramFromServiceMsg, paramObject, paramBundle);
      return;
    }
    if ("MCardSvc.ReqSetCardSwitch".equals(str))
    {
      j(paramToServiceMsg, paramFromServiceMsg, paramObject, paramBundle);
      return;
    }
    if ("VisitorSvc.ReqFavorite".equals(str))
    {
      d(paramToServiceMsg, paramFromServiceMsg, paramObject, paramBundle);
      return;
    }
    if ("VisitorSvc.ReqGetVoterList".equals(str))
    {
      f(paramToServiceMsg, paramFromServiceMsg, paramObject, paramBundle);
      return;
    }
    if ("VisitorSvc.ReqGetFavoriteList".equals(str))
    {
      e(paramToServiceMsg, paramFromServiceMsg, paramObject, paramBundle);
      return;
    }
    if ("VisitorSvc.ReqDeleteVisitorRecord".equals(str)) {
      g(paramToServiceMsg, paramFromServiceMsg, paramObject, paramBundle);
    }
  }
  
  /* Error */
  private void a(ToServiceMsg paramToServiceMsg, byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: iload_3
    //   1: istore 5
    //   3: iload_3
    //   4: ifeq +305 -> 309
    //   7: iload_3
    //   8: istore 6
    //   10: iload_3
    //   11: istore 5
    //   13: new 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   16: dup
    //   17: invokespecial 120	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   20: aload_2
    //   21: invokevirtual 126	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   24: checkcast 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   27: astore_2
    //   28: aload_2
    //   29: ifnull +331 -> 360
    //   32: iload_3
    //   33: istore 6
    //   35: iload_3
    //   36: istore 5
    //   38: aload_2
    //   39: getfield 130	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   42: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   45: ifne +315 -> 360
    //   48: iconst_1
    //   49: istore_3
    //   50: goto +3 -> 53
    //   53: iload_3
    //   54: istore 6
    //   56: iload_3
    //   57: istore 5
    //   59: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   62: ifeq +63 -> 125
    //   65: iload_3
    //   66: istore 6
    //   68: iload_3
    //   69: istore 5
    //   71: new 20	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   78: astore 7
    //   80: iload_3
    //   81: istore 6
    //   83: iload_3
    //   84: istore 5
    //   86: aload 7
    //   88: ldc_w 1424
    //   91: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: iload_3
    //   96: istore 6
    //   98: iload_3
    //   99: istore 5
    //   101: aload 7
    //   103: iload_3
    //   104: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: iload_3
    //   109: istore 6
    //   111: iload_3
    //   112: istore 5
    //   114: ldc 113
    //   116: iconst_2
    //   117: aload 7
    //   119: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   125: iload_3
    //   126: istore 6
    //   128: iload_3
    //   129: istore 5
    //   131: aload_0
    //   132: iload_3
    //   133: aload_2
    //   134: invokespecial 1427	com/tencent/mobileqq/app/CardHandler:b	(ZLtencent/im/oidb/oidb_sso$OIDBSSOPkg;)Z
    //   137: istore_3
    //   138: iload_3
    //   139: istore 5
    //   141: goto +168 -> 309
    //   144: astore_2
    //   145: goto +96 -> 241
    //   148: astore_2
    //   149: iload 5
    //   151: istore 6
    //   153: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   156: ifeq +17 -> 173
    //   159: iload 5
    //   161: istore 6
    //   163: ldc 113
    //   165: iconst_2
    //   166: ldc_w 1429
    //   169: aload_2
    //   170: invokestatic 222	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   173: iload 5
    //   175: istore_3
    //   176: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   179: ifeq +153 -> 332
    //   182: new 20	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   189: astore_2
    //   190: iload 5
    //   192: istore_3
    //   193: aload_2
    //   194: ldc_w 1424
    //   197: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: pop
    //   201: aload_2
    //   202: iload_3
    //   203: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   206: pop
    //   207: aload_2
    //   208: ldc 224
    //   210: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: aload_2
    //   215: aload_1
    //   216: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   219: ldc 202
    //   221: invokevirtual 208	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   224: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   227: pop
    //   228: ldc 113
    //   230: iconst_2
    //   231: aload_2
    //   232: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   235: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   238: goto +94 -> 332
    //   241: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   244: ifeq +63 -> 307
    //   247: new 20	java/lang/StringBuilder
    //   250: dup
    //   251: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   254: astore 7
    //   256: aload 7
    //   258: ldc_w 1424
    //   261: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   264: pop
    //   265: aload 7
    //   267: iload 6
    //   269: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   272: pop
    //   273: aload 7
    //   275: ldc 224
    //   277: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: pop
    //   281: aload 7
    //   283: aload_1
    //   284: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   287: ldc 202
    //   289: invokevirtual 208	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   292: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   295: pop
    //   296: ldc 113
    //   298: iconst_2
    //   299: aload 7
    //   301: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   304: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   307: aload_2
    //   308: athrow
    //   309: iload 5
    //   311: istore_3
    //   312: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   315: ifeq +17 -> 332
    //   318: new 20	java/lang/StringBuilder
    //   321: dup
    //   322: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   325: astore_2
    //   326: iload 5
    //   328: istore_3
    //   329: goto -136 -> 193
    //   332: iload_3
    //   333: ifeq +14 -> 347
    //   336: aload_1
    //   337: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   340: ldc 202
    //   342: invokevirtual 208	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   345: istore 4
    //   347: aload_0
    //   348: bipush 78
    //   350: iload_3
    //   351: iload 4
    //   353: invokestatic 365	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   356: invokevirtual 228	com/tencent/mobileqq/app/CardHandler:notifyUI	(IZLjava/lang/Object;)V
    //   359: return
    //   360: iconst_0
    //   361: istore_3
    //   362: goto -309 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	365	0	this	CardHandler
    //   0	365	1	paramToServiceMsg	ToServiceMsg
    //   0	365	2	paramArrayOfByte	byte[]
    //   0	365	3	paramBoolean1	boolean
    //   0	365	4	paramBoolean2	boolean
    //   1	326	5	bool1	boolean
    //   8	260	6	bool2	boolean
    //   78	222	7	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   13	28	144	finally
    //   38	48	144	finally
    //   59	65	144	finally
    //   71	80	144	finally
    //   86	95	144	finally
    //   101	108	144	finally
    //   114	125	144	finally
    //   131	138	144	finally
    //   153	159	144	finally
    //   163	173	144	finally
    //   13	28	148	java/lang/Exception
    //   38	48	148	java/lang/Exception
    //   59	65	148	java/lang/Exception
    //   71	80	148	java/lang/Exception
    //   86	95	148	java/lang/Exception
    //   101	108	148	java/lang/Exception
    //   114	125	148	java/lang/Exception
    //   131	138	148	java/lang/Exception
  }
  
  private void a(List<im_msg_body.RichText> paramList, AutoReplyText paramAutoReplyText)
  {
    if (paramAutoReplyText.getTextId() == 2147483647)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "setAutoReplyList, filter TEXT_NONE");
      }
      return;
    }
    paramAutoReplyText = MessageProtoCodec.a(paramAutoReplyText.getRawText(), null);
    if (paramAutoReplyText != null) {
      paramList.add(paramAutoReplyText);
    }
  }
  
  private void a(boolean paramBoolean, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    if ((paramBoolean) && (paramOIDBSSOPkg.bytes_bodybuffer.has()) && (paramOIDBSSOPkg.bytes_bodybuffer.get() != null))
    {
      oidb_0x5eb.RspBody localRspBody = new oidb_0x5eb.RspBody();
      localRspBody.mergeFrom(paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray());
      if ((localRspBody.rpt_msg_uin_data.has()) && (localRspBody.rpt_msg_uin_data.get().size() > 0) && (((oidb_0x5eb.UdcUinData)localRspBody.rpt_msg_uin_data.get().get(0)).uint32_req_global_ring_id.has()))
      {
        int i = ((oidb_0x5eb.UdcUinData)localRspBody.rpt_msg_uin_data.get().get(0)).uint32_req_global_ring_id.get();
        if (QLog.isColorLevel()) {
          QLog.d("CardHandler", 2, new Object[] { "handleSendGlobalRingIdRequestResp: invoked. ", " ringId: ", Integer.valueOf(i) });
        }
        if (i > 0) {
          MessageNotificationSettingManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(i);
        }
      }
    }
  }
  
  /* Error */
  private void a(byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 9
    //   3: iload_2
    //   4: istore 5
    //   6: iload_3
    //   7: istore 7
    //   9: iload_2
    //   10: ifeq +410 -> 420
    //   13: iload_2
    //   14: istore 8
    //   16: iload_2
    //   17: istore 6
    //   19: new 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   22: dup
    //   23: invokespecial 120	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   26: aload_1
    //   27: invokevirtual 126	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   30: checkcast 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   33: astore_1
    //   34: iload_2
    //   35: istore 8
    //   37: iload_2
    //   38: istore 6
    //   40: aload_1
    //   41: getfield 130	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   44: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   47: ifne +416 -> 463
    //   50: iconst_1
    //   51: istore_2
    //   52: goto +3 -> 55
    //   55: iload_2
    //   56: istore 8
    //   58: iload_2
    //   59: istore 6
    //   61: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   64: ifeq +64 -> 128
    //   67: iload_2
    //   68: istore 8
    //   70: iload_2
    //   71: istore 6
    //   73: new 20	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   80: astore 10
    //   82: iload_2
    //   83: istore 8
    //   85: iload_2
    //   86: istore 6
    //   88: aload 10
    //   90: ldc_w 1464
    //   93: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: iload_2
    //   98: istore 8
    //   100: iload_2
    //   101: istore 6
    //   103: aload 10
    //   105: iload_2
    //   106: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: iload_2
    //   111: istore 8
    //   113: iload_2
    //   114: istore 6
    //   116: ldc_w 368
    //   119: iconst_2
    //   120: aload 10
    //   122: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   128: iload_2
    //   129: istore 5
    //   131: iload_3
    //   132: istore 7
    //   134: iload_2
    //   135: ifeq +285 -> 420
    //   138: iload_2
    //   139: istore 8
    //   141: iload_2
    //   142: istore 6
    //   144: iload_2
    //   145: istore 5
    //   147: iload_3
    //   148: istore 7
    //   150: aload_1
    //   151: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   154: invokevirtual 146	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   157: ifeq +263 -> 420
    //   160: iload_2
    //   161: istore 8
    //   163: iload_2
    //   164: istore 6
    //   166: iload_2
    //   167: istore 5
    //   169: iload_3
    //   170: istore 7
    //   172: aload_1
    //   173: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   176: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   179: ifnull +241 -> 420
    //   182: iload_2
    //   183: istore 8
    //   185: iload_2
    //   186: istore 6
    //   188: new 333	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody
    //   191: dup
    //   192: invokespecial 334	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:<init>	()V
    //   195: astore 10
    //   197: iload_2
    //   198: istore 8
    //   200: iload_2
    //   201: istore 6
    //   203: aload 10
    //   205: aload_1
    //   206: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   209: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   212: invokevirtual 155	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   215: invokevirtual 335	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   218: pop
    //   219: iload_2
    //   220: istore 8
    //   222: iload_2
    //   223: istore 6
    //   225: aload 10
    //   227: getfield 339	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   230: invokevirtual 1465	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   233: ifle +48 -> 281
    //   236: iload_2
    //   237: istore 8
    //   239: iload_2
    //   240: istore 6
    //   242: aload 10
    //   244: getfield 339	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   247: iconst_0
    //   248: invokevirtual 1468	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   251: checkcast 353	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData
    //   254: getfield 1471	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_notify_partake_like_ranking_list_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   257: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   260: istore 4
    //   262: iload 9
    //   264: istore_2
    //   265: iload 4
    //   267: ifne +5 -> 272
    //   270: iconst_1
    //   271: istore_2
    //   272: iconst_1
    //   273: istore 5
    //   275: iload_2
    //   276: istore 7
    //   278: goto +142 -> 420
    //   281: iconst_0
    //   282: istore 5
    //   284: iload_3
    //   285: istore 7
    //   287: goto +133 -> 420
    //   290: astore_1
    //   291: goto +83 -> 374
    //   294: astore_1
    //   295: iload 6
    //   297: istore 8
    //   299: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   302: ifeq +18 -> 320
    //   305: iload 6
    //   307: istore 8
    //   309: ldc_w 368
    //   312: iconst_2
    //   313: ldc_w 1473
    //   316: aload_1
    //   317: invokestatic 222	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   320: iload 6
    //   322: istore_2
    //   323: iload_3
    //   324: istore 8
    //   326: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   329: ifeq +121 -> 450
    //   332: new 20	java/lang/StringBuilder
    //   335: dup
    //   336: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   339: astore_1
    //   340: iload 6
    //   342: istore_2
    //   343: aload_1
    //   344: ldc_w 1464
    //   347: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: pop
    //   351: aload_1
    //   352: iload_2
    //   353: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   356: pop
    //   357: ldc_w 368
    //   360: iconst_2
    //   361: aload_1
    //   362: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   365: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   368: iload_3
    //   369: istore 8
    //   371: goto +79 -> 450
    //   374: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   377: ifeq +41 -> 418
    //   380: new 20	java/lang/StringBuilder
    //   383: dup
    //   384: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   387: astore 10
    //   389: aload 10
    //   391: ldc_w 1464
    //   394: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: pop
    //   398: aload 10
    //   400: iload 8
    //   402: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   405: pop
    //   406: ldc_w 368
    //   409: iconst_2
    //   410: aload 10
    //   412: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   415: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   418: aload_1
    //   419: athrow
    //   420: iload 5
    //   422: istore_2
    //   423: iload 7
    //   425: istore 8
    //   427: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   430: ifeq +20 -> 450
    //   433: new 20	java/lang/StringBuilder
    //   436: dup
    //   437: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   440: astore_1
    //   441: iload 5
    //   443: istore_2
    //   444: iload 7
    //   446: istore_3
    //   447: goto -104 -> 343
    //   450: aload_0
    //   451: bipush 81
    //   453: iload_2
    //   454: iload 8
    //   456: invokestatic 365	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   459: invokevirtual 228	com/tencent/mobileqq/app/CardHandler:notifyUI	(IZLjava/lang/Object;)V
    //   462: return
    //   463: iconst_0
    //   464: istore_2
    //   465: goto -410 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	468	0	this	CardHandler
    //   0	468	1	paramArrayOfByte	byte[]
    //   0	468	2	paramBoolean1	boolean
    //   0	468	3	paramBoolean2	boolean
    //   260	6	4	i	int
    //   4	438	5	bool1	boolean
    //   17	324	6	bool2	boolean
    //   7	438	7	bool3	boolean
    //   14	441	8	bool4	boolean
    //   1	262	9	bool5	boolean
    //   80	331	10	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   19	34	290	finally
    //   40	50	290	finally
    //   61	67	290	finally
    //   73	82	290	finally
    //   88	97	290	finally
    //   103	110	290	finally
    //   116	128	290	finally
    //   150	160	290	finally
    //   172	182	290	finally
    //   188	197	290	finally
    //   203	219	290	finally
    //   225	236	290	finally
    //   242	262	290	finally
    //   299	305	290	finally
    //   309	320	290	finally
    //   19	34	294	java/lang/Exception
    //   40	50	294	java/lang/Exception
    //   61	67	294	java/lang/Exception
    //   73	82	294	java/lang/Exception
    //   88	97	294	java/lang/Exception
    //   103	110	294	java/lang/Exception
    //   116	128	294	java/lang/Exception
    //   150	160	294	java/lang/Exception
    //   172	182	294	java/lang/Exception
    //   188	197	294	java/lang/Exception
    //   203	219	294	java/lang/Exception
    //   225	236	294	java/lang/Exception
    //   242	262	294	java/lang/Exception
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg, boolean paramBoolean, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    if ((paramBoolean) && (paramOIDBSSOPkg.bytes_bodybuffer.has()) && (paramOIDBSSOPkg.bytes_bodybuffer.get() != null))
    {
      int i = ByteBuffer.wrap(paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray()).getInt();
      long l;
      if (i < 0) {
        l = i + 4294967296L;
      } else {
        l = i;
      }
      if (QLog.isColorLevel())
      {
        paramOIDBSSOPkg = new StringBuilder();
        paramOIDBSSOPkg.append("handleSetStrangerInviteToGroupSwitch uin=");
        paramOIDBSSOPkg.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        paramOIDBSSOPkg.append("  lUin:");
        paramOIDBSSOPkg.append(String.valueOf(l));
        QLog.d("Q.profilecard.", 2, paramOIDBSSOPkg.toString());
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(String.valueOf(l)))
      {
        paramOIDBSSOPkg = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        Card localCard = paramOIDBSSOPkg.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        paramBoolean = localCard.strangerInviteMeGroupOpen;
        localCard.strangerInviteMeGroupOpen = paramToServiceMsg.extraData.getBoolean("switch");
        paramOIDBSSOPkg.a(localCard);
        boolean bool = localCard.strangerInviteMeGroupOpen;
        if (paramBoolean != bool) {
          notifyUI(93, true, new Object[] { Boolean.valueOf(bool), Boolean.valueOf(paramBoolean) });
        }
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("handleSetStrangerInviteToGroupSwitch newConfigOn=");
          paramToServiceMsg.append(bool);
          paramToServiceMsg.append("  oldConfigOn:");
          paramToServiceMsg.append(paramBoolean);
          QLog.d("Q.profilecard.", 2, paramToServiceMsg.toString());
        }
        return true;
      }
    }
    return false;
  }
  
  /* Error */
  private boolean a(ToServiceMsg paramToServiceMsg, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    // Byte code:
    //   0: iload_3
    //   1: istore 4
    //   3: iload_3
    //   4: ifeq +303 -> 307
    //   7: iload_3
    //   8: istore 5
    //   10: iload_3
    //   11: istore 4
    //   13: new 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   16: dup
    //   17: invokespecial 120	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   20: aload_2
    //   21: invokevirtual 126	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   24: checkcast 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   27: astore_2
    //   28: aload_2
    //   29: ifnull +300 -> 329
    //   32: iload_3
    //   33: istore 5
    //   35: iload_3
    //   36: istore 4
    //   38: aload_2
    //   39: getfield 130	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   42: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   45: ifne +284 -> 329
    //   48: iconst_1
    //   49: istore_3
    //   50: goto +3 -> 53
    //   53: iload_3
    //   54: istore 5
    //   56: iload_3
    //   57: istore 4
    //   59: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   62: ifeq +63 -> 125
    //   65: iload_3
    //   66: istore 5
    //   68: iload_3
    //   69: istore 4
    //   71: new 20	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   78: astore 6
    //   80: iload_3
    //   81: istore 5
    //   83: iload_3
    //   84: istore 4
    //   86: aload 6
    //   88: ldc_w 1487
    //   91: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: iload_3
    //   96: istore 5
    //   98: iload_3
    //   99: istore 4
    //   101: aload 6
    //   103: iload_3
    //   104: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: iload_3
    //   109: istore 5
    //   111: iload_3
    //   112: istore 4
    //   114: ldc 113
    //   116: iconst_2
    //   117: aload 6
    //   119: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   125: iload_3
    //   126: istore 5
    //   128: iload_3
    //   129: istore 4
    //   131: aload_0
    //   132: iload_3
    //   133: aload_2
    //   134: invokespecial 1489	com/tencent/mobileqq/app/CardHandler:a	(ZLtencent/im/oidb/oidb_sso$OIDBSSOPkg;)Z
    //   137: istore_3
    //   138: iload_3
    //   139: istore 4
    //   141: goto +166 -> 307
    //   144: astore_2
    //   145: goto +94 -> 239
    //   148: astore_2
    //   149: iload 4
    //   151: istore 5
    //   153: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   156: ifeq +17 -> 173
    //   159: iload 4
    //   161: istore 5
    //   163: ldc 113
    //   165: iconst_2
    //   166: ldc_w 1491
    //   169: aload_2
    //   170: invokestatic 222	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   173: iload 4
    //   175: istore_3
    //   176: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   179: ifeq +148 -> 327
    //   182: new 20	java/lang/StringBuilder
    //   185: dup
    //   186: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   189: astore_2
    //   190: aload_2
    //   191: ldc_w 1487
    //   194: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload_2
    //   199: iload 4
    //   201: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload_2
    //   206: ldc 224
    //   208: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: aload_2
    //   213: aload_1
    //   214: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   217: ldc 202
    //   219: invokevirtual 208	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   222: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: ldc 113
    //   228: iconst_2
    //   229: aload_2
    //   230: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   236: iload 4
    //   238: ireturn
    //   239: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   242: ifeq +63 -> 305
    //   245: new 20	java/lang/StringBuilder
    //   248: dup
    //   249: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   252: astore 6
    //   254: aload 6
    //   256: ldc_w 1487
    //   259: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: pop
    //   263: aload 6
    //   265: iload 5
    //   267: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: aload 6
    //   273: ldc 224
    //   275: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: pop
    //   279: aload 6
    //   281: aload_1
    //   282: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   285: ldc 202
    //   287: invokevirtual 208	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   290: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   293: pop
    //   294: ldc 113
    //   296: iconst_2
    //   297: aload 6
    //   299: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   302: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   305: aload_2
    //   306: athrow
    //   307: iload 4
    //   309: istore_3
    //   310: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   313: ifeq +14 -> 327
    //   316: new 20	java/lang/StringBuilder
    //   319: dup
    //   320: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   323: astore_2
    //   324: goto -134 -> 190
    //   327: iload_3
    //   328: ireturn
    //   329: iconst_0
    //   330: istore_3
    //   331: goto -278 -> 53
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	334	0	this	CardHandler
    //   0	334	1	paramToServiceMsg	ToServiceMsg
    //   0	334	2	paramArrayOfByte	byte[]
    //   0	334	3	paramBoolean	boolean
    //   1	307	4	bool1	boolean
    //   8	258	5	bool2	boolean
    //   78	220	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   13	28	144	finally
    //   38	48	144	finally
    //   59	65	144	finally
    //   71	80	144	finally
    //   86	95	144	finally
    //   101	108	144	finally
    //   114	125	144	finally
    //   131	138	144	finally
    //   153	159	144	finally
    //   163	173	144	finally
    //   13	28	148	java/lang/Exception
    //   38	48	148	java/lang/Exception
    //   59	65	148	java/lang/Exception
    //   71	80	148	java/lang/Exception
    //   86	95	148	java/lang/Exception
    //   101	108	148	java/lang/Exception
    //   114	125	148	java/lang/Exception
    //   131	138	148	java/lang/Exception
  }
  
  private boolean a(boolean paramBoolean, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    boolean bool = paramBoolean;
    if (paramBoolean)
    {
      bool = paramBoolean;
      if (paramOIDBSSOPkg.bytes_bodybuffer.has())
      {
        bool = paramBoolean;
        if (paramOIDBSSOPkg.bytes_bodybuffer.get() != null)
        {
          int i = ByteBuffer.wrap(paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray()).getInt();
          long l = i;
          if (i < 0) {
            l = 0x80000000 | i & 0x7FFFFFFF;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(String.valueOf(l))) {
            return true;
          }
          bool = false;
        }
      }
    }
    return bool;
  }
  
  public static int b(Context paramContext)
  {
    return 640;
  }
  
  private void b(FromServiceMsg paramFromServiceMsg, Bundle paramBundle)
  {
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      paramFromServiceMsg = (RespClientMsg)paramFromServiceMsg.getAttribute("result");
      if ((paramFromServiceMsg != null) && (1 == paramFromServiceMsg.stMsg.eAccostType)) {
        notifyUI(22, true, paramBundle);
      }
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Bundle paramBundle)
  {
    Card localCard = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramToServiceMsg.getUin());
    RespGetVoterList localRespGetVoterList = (RespGetVoterList)paramFromServiceMsg.getAttribute("result");
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("[handleReqVoterList] replyCode = ");
      paramFromServiceMsg.append(localRespGetVoterList.stHeader.iReplyCode);
      QLog.d("CardHandler", 2, paramFromServiceMsg.toString());
    }
    paramFromServiceMsg = null;
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder(1024);
      paramFromServiceMsg.append("handleReqVoterList log [ ");
    }
    if (localRespGetVoterList.stHeader.iReplyCode != 0)
    {
      paramToServiceMsg = a(2, 7);
      paramBundle.putLong("respTime", localRespGetVoterList.RespTime);
      paramBundle.putLong("nextMid", localRespGetVoterList.stUserData.lNextMid);
      paramBundle.putByteArray("strCookie", localRespGetVoterList.stUserData.strCookie);
      paramBundle.putLong("startMid", -1L);
      notifyUI(6, false, new Object[] { localCard, paramBundle, paramToServiceMsg });
    }
    else
    {
      a(paramToServiceMsg, paramBundle, localCard, localRespGetVoterList, paramFromServiceMsg, 0);
    }
    if ((QLog.isColorLevel()) && (paramFromServiceMsg != null))
    {
      paramFromServiceMsg.append(" ]");
      QLog.i("CardHandler", 2, paramFromServiceMsg.toString());
    }
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if ("MCardSvc.ReqDelFace".equals(str))
    {
      n(paramToServiceMsg, paramFromServiceMsg, paramObject, paramBundle);
      return;
    }
    if ("AccostSvc.ClientMsg".equals(str))
    {
      b(paramFromServiceMsg, paramBundle);
      return;
    }
    if ("AccostSvc.SvrMsg".equals(str))
    {
      a(paramFromServiceMsg, paramBundle);
      return;
    }
    if ("MCardSvc.ReqPicSafetyCheck".equals(str))
    {
      a(paramToServiceMsg, paramFromServiceMsg, paramBundle);
      return;
    }
    if ("OidbSvc.0x490_100".equals(str))
    {
      m(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0x491_100".equals(str))
    {
      n(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("SQQzoneSvc.getCover".equals(str))
    {
      o(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0x4ff_9".equals(str))
    {
      k(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0x66b".equals(str)) {
      a(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  private void b(String paramString, List<CardProfile> paramList)
  {
    a(paramString, paramList);
  }
  
  /* Error */
  private void b(byte[] paramArrayOfByte, boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 9
    //   3: iload_2
    //   4: istore 5
    //   6: iload_3
    //   7: istore 7
    //   9: iload_2
    //   10: ifeq +410 -> 420
    //   13: iload_2
    //   14: istore 8
    //   16: iload_2
    //   17: istore 6
    //   19: new 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   22: dup
    //   23: invokespecial 120	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   26: aload_1
    //   27: invokevirtual 126	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   30: checkcast 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   33: astore_1
    //   34: iload_2
    //   35: istore 8
    //   37: iload_2
    //   38: istore 6
    //   40: aload_1
    //   41: getfield 130	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   44: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   47: ifne +416 -> 463
    //   50: iconst_1
    //   51: istore_2
    //   52: goto +3 -> 55
    //   55: iload_2
    //   56: istore 8
    //   58: iload_2
    //   59: istore 6
    //   61: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   64: ifeq +64 -> 128
    //   67: iload_2
    //   68: istore 8
    //   70: iload_2
    //   71: istore 6
    //   73: new 20	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   80: astore 10
    //   82: iload_2
    //   83: istore 8
    //   85: iload_2
    //   86: istore 6
    //   88: aload 10
    //   90: ldc_w 1569
    //   93: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: iload_2
    //   98: istore 8
    //   100: iload_2
    //   101: istore 6
    //   103: aload 10
    //   105: iload_2
    //   106: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: iload_2
    //   111: istore 8
    //   113: iload_2
    //   114: istore 6
    //   116: ldc_w 368
    //   119: iconst_2
    //   120: aload 10
    //   122: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   125: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   128: iload_2
    //   129: istore 5
    //   131: iload_3
    //   132: istore 7
    //   134: iload_2
    //   135: ifeq +285 -> 420
    //   138: iload_2
    //   139: istore 8
    //   141: iload_2
    //   142: istore 6
    //   144: iload_2
    //   145: istore 5
    //   147: iload_3
    //   148: istore 7
    //   150: aload_1
    //   151: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   154: invokevirtual 146	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   157: ifeq +263 -> 420
    //   160: iload_2
    //   161: istore 8
    //   163: iload_2
    //   164: istore 6
    //   166: iload_2
    //   167: istore 5
    //   169: iload_3
    //   170: istore 7
    //   172: aload_1
    //   173: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   176: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   179: ifnull +241 -> 420
    //   182: iload_2
    //   183: istore 8
    //   185: iload_2
    //   186: istore 6
    //   188: new 333	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody
    //   191: dup
    //   192: invokespecial 334	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:<init>	()V
    //   195: astore 10
    //   197: iload_2
    //   198: istore 8
    //   200: iload_2
    //   201: istore 6
    //   203: aload 10
    //   205: aload_1
    //   206: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   209: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   212: invokevirtual 155	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   215: invokevirtual 335	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   218: pop
    //   219: iload_2
    //   220: istore 8
    //   222: iload_2
    //   223: istore 6
    //   225: aload 10
    //   227: getfield 339	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   230: invokevirtual 1465	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   233: ifle +48 -> 281
    //   236: iload_2
    //   237: istore 8
    //   239: iload_2
    //   240: istore 6
    //   242: aload 10
    //   244: getfield 339	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   247: iconst_0
    //   248: invokevirtual 1468	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   251: checkcast 353	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData
    //   254: getfield 1572	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_notify_on_like_ranking_list_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   257: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   260: istore 4
    //   262: iload 9
    //   264: istore_2
    //   265: iload 4
    //   267: ifne +5 -> 272
    //   270: iconst_1
    //   271: istore_2
    //   272: iconst_1
    //   273: istore 5
    //   275: iload_2
    //   276: istore 7
    //   278: goto +142 -> 420
    //   281: iconst_0
    //   282: istore 5
    //   284: iload_3
    //   285: istore 7
    //   287: goto +133 -> 420
    //   290: astore_1
    //   291: goto +83 -> 374
    //   294: astore_1
    //   295: iload 6
    //   297: istore 8
    //   299: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   302: ifeq +18 -> 320
    //   305: iload 6
    //   307: istore 8
    //   309: ldc_w 368
    //   312: iconst_2
    //   313: ldc_w 1574
    //   316: aload_1
    //   317: invokestatic 222	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   320: iload 6
    //   322: istore_2
    //   323: iload_3
    //   324: istore 8
    //   326: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   329: ifeq +121 -> 450
    //   332: new 20	java/lang/StringBuilder
    //   335: dup
    //   336: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   339: astore_1
    //   340: iload 6
    //   342: istore_2
    //   343: aload_1
    //   344: ldc_w 1569
    //   347: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: pop
    //   351: aload_1
    //   352: iload_2
    //   353: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   356: pop
    //   357: ldc_w 368
    //   360: iconst_2
    //   361: aload_1
    //   362: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   365: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   368: iload_3
    //   369: istore 8
    //   371: goto +79 -> 450
    //   374: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   377: ifeq +41 -> 418
    //   380: new 20	java/lang/StringBuilder
    //   383: dup
    //   384: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   387: astore 10
    //   389: aload 10
    //   391: ldc_w 1569
    //   394: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: pop
    //   398: aload 10
    //   400: iload 8
    //   402: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   405: pop
    //   406: ldc_w 368
    //   409: iconst_2
    //   410: aload 10
    //   412: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   415: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   418: aload_1
    //   419: athrow
    //   420: iload 5
    //   422: istore_2
    //   423: iload 7
    //   425: istore 8
    //   427: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   430: ifeq +20 -> 450
    //   433: new 20	java/lang/StringBuilder
    //   436: dup
    //   437: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   440: astore_1
    //   441: iload 5
    //   443: istore_2
    //   444: iload 7
    //   446: istore_3
    //   447: goto -104 -> 343
    //   450: aload_0
    //   451: bipush 77
    //   453: iload_2
    //   454: iload 8
    //   456: invokestatic 365	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   459: invokevirtual 228	com/tencent/mobileqq/app/CardHandler:notifyUI	(IZLjava/lang/Object;)V
    //   462: return
    //   463: iconst_0
    //   464: istore_2
    //   465: goto -410 -> 55
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	468	0	this	CardHandler
    //   0	468	1	paramArrayOfByte	byte[]
    //   0	468	2	paramBoolean1	boolean
    //   0	468	3	paramBoolean2	boolean
    //   260	6	4	i	int
    //   4	438	5	bool1	boolean
    //   17	324	6	bool2	boolean
    //   7	438	7	bool3	boolean
    //   14	441	8	bool4	boolean
    //   1	262	9	bool5	boolean
    //   80	331	10	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   19	34	290	finally
    //   40	50	290	finally
    //   61	67	290	finally
    //   73	82	290	finally
    //   88	97	290	finally
    //   103	110	290	finally
    //   116	128	290	finally
    //   150	160	290	finally
    //   172	182	290	finally
    //   188	197	290	finally
    //   203	219	290	finally
    //   225	236	290	finally
    //   242	262	290	finally
    //   299	305	290	finally
    //   309	320	290	finally
    //   19	34	294	java/lang/Exception
    //   40	50	294	java/lang/Exception
    //   61	67	294	java/lang/Exception
    //   73	82	294	java/lang/Exception
    //   88	97	294	java/lang/Exception
    //   103	110	294	java/lang/Exception
    //   116	128	294	java/lang/Exception
    //   150	160	294	java/lang/Exception
    //   172	182	294	java/lang/Exception
    //   188	197	294	java/lang/Exception
    //   203	219	294	java/lang/Exception
    //   225	236	294	java/lang/Exception
    //   242	262	294	java/lang/Exception
  }
  
  private boolean b(boolean paramBoolean, oidb_sso.OIDBSSOPkg paramOIDBSSOPkg)
  {
    boolean bool = paramBoolean;
    if (paramBoolean)
    {
      bool = paramBoolean;
      if (paramOIDBSSOPkg.bytes_bodybuffer.has())
      {
        bool = paramBoolean;
        if (paramOIDBSSOPkg.bytes_bodybuffer.get() != null)
        {
          int i = ByteBuffer.wrap(paramOIDBSSOPkg.bytes_bodybuffer.get().toByteArray()).getInt();
          long l = i;
          if (i < 0) {
            l = 0x80000000 | i & 0x7FFFFFFF;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(String.valueOf(l))) {
            return true;
          }
          bool = false;
        }
      }
    }
    return bool;
  }
  
  public static int c(Context paramContext)
  {
    int i = a(paramContext);
    if (i <= 240) {
      return 60;
    }
    if (i <= 320) {
      return 100;
    }
    return 160;
  }
  
  public static void c()
  {
    Object localObject1 = new File(jdField_a_of_type_JavaLangString);
    if (!((File)localObject1).exists()) {}
    try
    {
      bool = ((File)localObject1).mkdirs();
    }
    catch (SecurityException localSecurityException1)
    {
      try
      {
        for (;;)
        {
          boolean bool;
          int k;
          int i;
          int j;
          Object localObject2;
          ((File)localObject2).mkdir();
          j += 1;
        }
        return;
        localSecurityException1 = localSecurityException1;
      }
      catch (SecurityException localSecurityException2)
      {
        break label195;
      }
    }
    bool = true;
    if (bool)
    {
      localObject1 = new ArrayList();
      ((ArrayList)localObject1).add("background");
      ((ArrayList)localObject1).add("temp");
      ((ArrayList)localObject1).add("HDAvatar");
      k = 0;
      i = 0;
      for (;;)
      {
        j = k;
        if (i >= jdField_a_of_type_JavaUtilVector.size()) {
          break;
        }
        ((ArrayList)localObject1).add(String.valueOf(((Integer)jdField_a_of_type_JavaUtilVector.get(i)).intValue()));
        i += 1;
      }
      if (j < ((ArrayList)localObject1).size())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(jdField_a_of_type_JavaLangString);
        ((StringBuilder)localObject2).append("/");
        ((StringBuilder)localObject2).append((String)((ArrayList)localObject1).get(j));
        localObject2 = new File(((StringBuilder)localObject2).toString());
        if (((File)localObject2).exists()) {}
      }
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if ("OidbSvc.0x5eb_22".equals(str))
    {
      j(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0x5eb_15".equals(str))
    {
      i(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0x7ba".equals(str))
    {
      h(paramToServiceMsg, paramFromServiceMsg, paramObject, paramBundle);
      return;
    }
    if ("OidbSvc.0x5eb_42092".equals(str))
    {
      z(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0x5eb_42326".equals(str))
    {
      t(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0x5eb_40350".equals(str))
    {
      u(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0x922".equals(str))
    {
      x(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0xe26".equals(str))
    {
      w(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0xa28".equals(str))
    {
      v(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0x7a8".equals(str))
    {
      M(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0xac6".equals(str))
    {
      N(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0xc33_42220".equals(str))
    {
      O(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0xcd5".equals(str))
    {
      h(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0xd8a".equals(str))
    {
      S(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0xd2d".equals(str))
    {
      U(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0x4ff_42315".equals(str))
    {
      T(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0x5eb_15(2)".equals(str)) {
      E(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  private boolean c()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    localStringBuilder.append("sign_in_operation_time_stamp");
    long l3 = ((SharedPreferences)localObject).getLong(localStringBuilder.toString(), 0L);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    localStringBuilder.append("sign_in_operation_time_refresh");
    long l1 = ((SharedPreferences)localObject).getLong(localStringBuilder.toString(), 0L) * 1000L;
    long l2 = NetConnInfoCenter.getServerTimeMillis();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("shouldResuestSignOperate, last=");
      localStringBuilder.append(l3);
      localStringBuilder.append(", interval=");
      localStringBuilder.append(l1);
      localStringBuilder.append(", now=");
      localStringBuilder.append(l2);
      QLog.d("CardHandler", 2, localStringBuilder.toString());
    }
    l3 = l2 - l3;
    if (Math.abs(l3) <= 600000L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "shouldResuestSignOperate, <10min");
      }
      return false;
    }
    if (l3 >= l1)
    {
      localObject = ((SharedPreferences)localObject).edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      localStringBuilder.append("sign_in_operation_time_stamp");
      ((SharedPreferences.Editor)localObject).putLong(localStringBuilder.toString(), l2).commit();
      return true;
    }
    return false;
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    paramObject = paramFromServiceMsg.getAttribute("result");
    paramFromServiceMsg = new HashMap();
    long l1 = paramToServiceMsg.extraData.getLong("targetUin");
    long l2 = paramToServiceMsg.extraData.getLong("selfUin");
    int j = paramToServiceMsg.extraData.getInt("favoriteSource");
    int i = paramToServiceMsg.extraData.getInt("iCount");
    int k = paramToServiceMsg.extraData.getInt("from");
    paramBundle.putString("targetUin", Long.toString(l1));
    paramBundle.putString("selfUin", Long.toString(l2));
    paramBundle.putInt("favoriteSource", j);
    paramBundle.putInt("iCount", i);
    paramBundle.putInt("from", k);
    boolean bool;
    if ((paramObject != null) && ((paramObject instanceof RespFavorite)))
    {
      paramToServiceMsg = (RespFavorite)paramObject;
      if (paramToServiceMsg.stHeader.iReplyCode == 0) {
        paramFromServiceMsg.put("param_FailCode", "0");
      }
      for (bool = true;; bool = false)
      {
        break;
        if (QLog.isColorLevel())
        {
          paramObject = new StringBuilder();
          paramObject.append("back reqFavorite| result = ");
          paramObject.append(false);
          paramObject.append(",");
          paramObject.append(l1);
          paramObject.append(",replyCode=");
          paramObject.append(paramToServiceMsg.stHeader.iReplyCode);
          QLog.i("Q.profilecard.", 2, paramObject.toString());
        }
        paramFromServiceMsg.put("param_FailCode", String.valueOf(paramToServiceMsg.stHeader.iReplyCode));
      }
      paramToServiceMsg = StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
      paramToServiceMsg.collectPerformance(String.valueOf(l2), "profileCardSendFavorite", bool, 0L, 0L, paramFromServiceMsg, "", false);
      paramToServiceMsg = "Q.profilecard.";
    }
    else
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("back reqFavorite| result = ");
        localStringBuilder.append(false);
        localStringBuilder.append(",");
        localStringBuilder.append(l1);
        localStringBuilder.append(",obj is");
        if (paramObject != null) {
          paramToServiceMsg = "not RespFavorite";
        } else {
          paramToServiceMsg = "null";
        }
        localStringBuilder.append(paramToServiceMsg);
        QLog.i("Q.profilecard.", 2, localStringBuilder.toString());
      }
      if (paramObject != null) {
        paramToServiceMsg = "-201";
      } else {
        paramToServiceMsg = "-202";
      }
      paramFromServiceMsg.put("param_FailCode", paramToServiceMsg);
      paramObject = StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
      paramToServiceMsg = "Q.profilecard.";
      paramObject.collectPerformance(String.valueOf(l2), "profileCardSendFavorite", false, 0L, 0L, paramFromServiceMsg, "", false);
      bool = false;
    }
    paramFromServiceMsg = this;
    if (QLog.isColorLevel()) {
      QLog.i(paramToServiceMsg, 2, String.format("handleFavorite result=%s targetUin=%s iCount=%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(l1), Integer.valueOf(i) }));
    }
    if ((bool) && (l1 > 0L))
    {
      paramObject = (Card)paramFromServiceMsg.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager().find(Card.class, l1);
      if (paramObject != null)
      {
        if (QLog.isColorLevel()) {
          QLog.i(paramToServiceMsg, 2, String.format("handleFavorite card in db: lVoteCount=%s bVoted=%s bAvailVoteCnt=%s", new Object[] { Long.valueOf(paramObject.lVoteCount), Byte.valueOf(paramObject.bVoted), Short.valueOf(paramObject.bAvailVoteCnt) }));
        }
        l2 = paramObject.lVoteCount;
        j = i;
        paramObject.lVoteCount = (l2 + j);
        paramObject.bVoted = 1;
        paramObject.bAvailVoteCnt = ((short)(paramObject.bAvailVoteCnt - j));
        if (paramObject.bAvailVoteCnt < 0) {
          paramObject.bAvailVoteCnt = 0;
        }
        ((FriendsManager)paramFromServiceMsg.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(paramObject);
      }
      VoteUtil.a(paramFromServiceMsg.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l1, i);
    }
    paramFromServiceMsg.notifyUI(32, bool, paramBundle);
  }
  
  private boolean d()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    localStringBuilder.append("sign_in_last_get_time");
    long l1 = ((SharedPreferences)localObject).getLong(localStringBuilder.toString(), 0L);
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    localStringBuilder.append("sign_in_next_get_time");
    long l2 = ((SharedPreferences)localObject).getLong(localStringBuilder.toString(), 0L);
    long l3 = NetConnInfoCenter.getServerTimeMillis();
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("shouldGetSignInInfo, last=");
      localStringBuilder.append(l1);
      localStringBuilder.append(", next=");
      localStringBuilder.append(l2);
      localStringBuilder.append(", now=");
      localStringBuilder.append(l3);
      QLog.d("CardHandler", 2, localStringBuilder.toString());
    }
    if (Math.abs(l3 - l1) <= 600000L)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "shouldGetSignInInfo, <10min");
      }
      return false;
    }
    if (l3 >= l2)
    {
      localObject = ((SharedPreferences)localObject).edit();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      localStringBuilder.append("sign_in_last_get_time");
      ((SharedPreferences.Editor)localObject).putLong(localStringBuilder.toString(), l3).commit();
      return true;
    }
    return false;
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      paramObject = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramToServiceMsg.getUin());
      RespGetFavoriteList localRespGetFavoriteList = (RespGetFavoriteList)paramFromServiceMsg.getAttribute("result");
      paramFromServiceMsg = null;
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder(1024);
        paramFromServiceMsg.append("handleReqFavoriteList log [ ");
      }
      if (localRespGetFavoriteList.stHeader.iReplyCode != 0)
      {
        paramToServiceMsg = a(3, 7);
        paramBundle.putLong("respTime", localRespGetFavoriteList.RespTime);
        paramBundle.putLong("nextMid", localRespGetFavoriteList.stUserData.lNextMid);
        paramBundle.putByteArray("strCookie", localRespGetFavoriteList.stUserData.strCookie);
        paramBundle.putLong("startMid", -1L);
        notifyUI(42, false, new Object[] { paramObject, paramBundle, paramToServiceMsg });
      }
      else
      {
        Iterator localIterator = localRespGetFavoriteList.vFavoriteInfos.iterator();
        ArrayList localArrayList = new ArrayList(0);
        int j;
        for (int i = 0; localIterator.hasNext(); i = j)
        {
          UserProfile localUserProfile = (UserProfile)localIterator.next();
          CardProfile localCardProfile = new CardProfile();
          localCardProfile.readFrom(localUserProfile);
          localCardProfile.type = 3;
          localArrayList.add(localCardProfile);
          j = i;
          if (QLog.isColorLevel())
          {
            j = i;
            if (paramFromServiceMsg != null)
            {
              paramFromServiceMsg.append("\n");
              paramFromServiceMsg.append("i=");
              paramFromServiceMsg.append(i);
              paramFromServiceMsg.append(",");
              paramFromServiceMsg.append(localCardProfile.getSimpleZanInfo());
              j = i + 1;
            }
          }
        }
        paramBundle.putLong("respTime", localRespGetFavoriteList.RespTime);
        paramBundle.putLong("startMid", paramToServiceMsg.extraData.getLong("nextMid"));
        paramBundle.putLong("nextMid", localRespGetFavoriteList.stUserData.lNextMid);
        paramBundle.putByteArray("strCookie", localRespGetFavoriteList.stUserData.strCookie);
        if (paramToServiceMsg.extraData.getLong("nextMid", -1L) == 0L) {
          a(3);
        }
        a(paramToServiceMsg.getUin(), localArrayList);
        notifyUI(42, true, new Object[] { paramObject, paramBundle, localArrayList });
      }
      if ((QLog.isColorLevel()) && (paramFromServiceMsg != null))
      {
        paramFromServiceMsg.append(" ]");
        QLog.i("CardHandler", 2, paramFromServiceMsg.toString());
      }
    }
    else
    {
      paramToServiceMsg = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramToServiceMsg.getUin());
      paramBundle.putLong("startMid", -1L);
      notifyUI(42, false, new Object[] { paramToServiceMsg, paramBundle, a(3, 7) });
    }
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramObject = new StringBuilder();
      paramObject.append("[handleReqVoterList] resultCode = ");
      paramObject.append(paramFromServiceMsg.getResultCode());
      QLog.d("CardHandler", 2, paramObject.toString());
    }
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      b(paramToServiceMsg, paramFromServiceMsg, paramBundle);
      return;
    }
    paramToServiceMsg = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramToServiceMsg.getUin());
    paramBundle.putLong("startMid", -1L);
    notifyUI(6, false, new Object[] { paramToServiceMsg, paramBundle, a(2, 7) });
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    long l1 = paramToServiceMsg.extraData.getLong("selfUin", 0L);
    long l2 = paramToServiceMsg.extraData.getLong("targetUin");
    int i = paramToServiceMsg.extraData.getInt("type");
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("[handleReqDelVoteRecord] resultCode = ");
      paramToServiceMsg.append(paramFromServiceMsg.getResultCode());
      paramToServiceMsg.append("targetUin:");
      paramToServiceMsg.append(l2);
      paramToServiceMsg.append(" type:");
      paramToServiceMsg.append(i);
      QLog.d("CardHandler", 2, paramToServiceMsg.toString());
    }
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      paramToServiceMsg = (RespDeleteVisitorRecord)paramFromServiceMsg.getAttribute("result");
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("[handleReqDelVoteRecord] replyCode = ");
        paramFromServiceMsg.append(paramToServiceMsg.stHeader.iReplyCode);
        QLog.d("CardHandler", 2, paramFromServiceMsg.toString());
      }
      if (paramToServiceMsg.stHeader.iReplyCode != 0)
      {
        notifyUI(91, false, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i) });
        return;
      }
      notifyUI(91, true, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i) });
      return;
    }
    notifyUI(91, false, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i) });
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg.extraData.getBoolean("isGetList", false))
    {
      P(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    Q(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    paramToServiceMsg = new oidb_0x7ba.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("[handleReqLikeRankingList] result=");
      paramFromServiceMsg.append(i);
      QLog.d("CardHandler", 2, paramFromServiceMsg.toString());
    }
    boolean bool = false;
    if (i == 0)
    {
      paramFromServiceMsg = paramToServiceMsg.rpt_info;
      paramObject = new ArrayList();
      i = 0;
      while (i < paramFromServiceMsg.size())
      {
        LikeRankingInfo localLikeRankingInfo = new LikeRankingInfo();
        oidb_0x7ba.PraiseInfo localPraiseInfo = (oidb_0x7ba.PraiseInfo)paramFromServiceMsg.get(i);
        localLikeRankingInfo.uin = localPraiseInfo.uint64_ddwuin.get();
        localLikeRankingInfo.likeCountOfToday = localPraiseInfo.uint32_praise_today_count.get();
        localLikeRankingInfo.totalLikeCount = localPraiseInfo.uint32_praise_total_count.get();
        localLikeRankingInfo.rankingNum = localPraiseInfo.uint32_rank_number.get();
        paramObject.add(localLikeRankingInfo);
        i += 1;
      }
      i = paramToServiceMsg.uint32_next_index.get();
      if (paramToServiceMsg.uint32_complete.get() == 1) {
        bool = true;
      }
      notifyUI(76, true, new Object[] { paramObject, Integer.valueOf(i), Boolean.valueOf(bool), paramBundle.getString("uin") });
      return;
    }
    notifyUI(76, false, paramBundle.getString("uin"));
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg.extraData.getBoolean("sendGlobalRingIdRequest", false))
    {
      F(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    G(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    boolean bool1;
    if (paramFromServiceMsg.isSuccess())
    {
      paramObject = (RespGetCardSwitch)paramObject;
      long l1 = paramObject.uCloseNeighborVote;
      long l2 = paramObject.uCloseTimeGateVote;
      if (l1 == 0L) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramObject = (INearByGeneralManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEARBY_GENERAL_MANAGER);
      boolean bool2;
      if (l1 == 0L) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      paramObject.b(bool2);
      paramObject = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).edit();
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131694973));
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localObject = ((StringBuilder)localObject).toString();
      if (l2 == 0L) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      paramObject.putBoolean((String)localObject, bool2).commit();
      paramBundle.putLong("uCloseNeighborVote", l1);
      paramBundle.putLong("uColseTimeEntityManager", l2);
      paramBundle.putString("uin", paramToServiceMsg.getUin());
      notifyUI(33, true, paramBundle);
    }
    else
    {
      paramBundle.putString("uin", paramToServiceMsg.getUin());
      notifyUI(33, false, paramBundle);
      bool1 = false;
    }
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleGetCardSwitches succuss ");
      paramToServiceMsg.append(paramFromServiceMsg.isSuccess());
      paramToServiceMsg.append(" curSwitch:");
      paramToServiceMsg.append(bool1);
      QLog.d("CardHandler", 2, paramToServiceMsg.toString());
    }
  }
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg.extraData.getBoolean("uint32_req_medalwall_flag", false))
    {
      D(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramToServiceMsg.extraData.getBoolean("uint32_do_not_disturb_mode_time", false)) {
      H(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
  }
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    Object localObject = paramToServiceMsg.extraData;
    boolean bool2 = true;
    boolean bool5 = ((Bundle)localObject).getBoolean("modify_switch_for_near_people", true);
    localObject = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
    boolean bool6 = paramFromServiceMsg.isSuccess();
    boolean bool4 = false;
    boolean bool1 = false;
    boolean bool3 = false;
    if (bool6)
    {
      paramObject = (RespSetCardSwitch)paramObject;
      if (bool5)
      {
        bool1 = bool3;
        if (paramObject.uCloseNeighborVote == 0L) {
          bool1 = true;
        }
        ((INearByGeneralManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEARBY_GENERAL_MANAGER)).b(bool1);
      }
      else
      {
        bool1 = bool4;
        if (paramObject.uCloseTimeGateVote == 0L) {
          bool1 = true;
        }
        paramObject = ((SharedPreferences)localObject).edit();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131694973));
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        paramObject.putBoolean(((StringBuilder)localObject).toString(), bool1).commit();
      }
      paramBundle.putBoolean("modify_switch_for_near_people", bool5);
      paramBundle.putBoolean("target_switch", bool1);
      paramBundle.putString("uin", paramToServiceMsg.getUin());
      notifyUI(34, true, paramBundle);
    }
    else
    {
      long l = paramToServiceMsg.extraData.getLong("target_value");
      paramObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (l != 0L) {
        bool2 = false;
      }
      if (!paramObject.trySetCardSwitch(bool5, bool2))
      {
        if (bool5)
        {
          bool1 = NearbyManagerHelper.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b();
        }
        else
        {
          paramObject = new StringBuilder();
          paramObject.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131694973));
          paramObject.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          bool1 = ((SharedPreferences)localObject).getBoolean(paramObject.toString(), false);
        }
        paramBundle.putString("uin", paramToServiceMsg.getUin());
        paramBundle.putBoolean("current_switch", bool1);
        notifyUI(34, false, paramBundle);
      }
    }
    if (bool5) {
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "CMD_REQ_SETCARDSWITCH", paramFromServiceMsg.isSuccess(), 0L, 0L, null, "response");
    }
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleSetCardSwitch succuss ");
      paramToServiceMsg.append(paramFromServiceMsg.isSuccess());
      paramToServiceMsg.append(" forNearPeople:");
      paramToServiceMsg.append(bool5);
      paramToServiceMsg.append(" curSwitch:");
      paramToServiceMsg.append(bool1);
      QLog.d("CardHandler", 2, paramToServiceMsg.toString());
    }
  }
  
  private void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg.extraData.getBoolean("reqFromCardHandler", false))
    {
      if (paramToServiceMsg.extraData.getBoolean("isSetLoginDays", false))
      {
        A(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramToServiceMsg.extraData.getBoolean("pcActiveState", false))
      {
        p(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramToServiceMsg.extraData.getBoolean("helloLiveMessage", false))
      {
        r(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramToServiceMsg.extraData.getBoolean("isSetActivateFriend", false))
      {
        I(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramToServiceMsg.extraData.getBoolean("from_send_no_disturb", false))
      {
        f(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramToServiceMsg.extraData.getBoolean("from_send_hidden_session", false))
      {
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramToServiceMsg.extraData.getBoolean("calltabstate", false))
      {
        L(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramToServiceMsg.extraData.getBoolean("isGetAntiLost"))
      {
        K(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramToServiceMsg.extraData.getBoolean("isSetCalReactiveDays", false))
      {
        B(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramToServiceMsg.extraData.getBoolean("isSetBabyQSwitch"))
      {
        J(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramToServiceMsg.extraData.getBoolean("uint32_req_medalwall_flag", false))
      {
        C(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramToServiceMsg.extraData.getBoolean("StrangerInviteToGroup", false))
      {
        R(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramToServiceMsg.extraData.getBoolean("isSetNotifyOnLikeRankingList", false))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramToServiceMsg.extraData.getBoolean("isSetDisplayThirdQQSwitch", false))
      {
        g(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramToServiceMsg.extraData.getBoolean("isSetPartakeLikeRankingList", false))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramToServiceMsg.extraData.getBoolean("isSetCommonSwitchFromDetailInfo", false))
      {
        y(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramToServiceMsg.extraData.getBoolean("uint32_req_push_notice_flag", false))
      {
        s(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramToServiceMsg.extraData.getBoolean("tempConversationBlocState", false))
      {
        q(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramToServiceMsg.extraData.getBoolean("tempConversationNewBlockState", false))
      {
        l(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramToServiceMsg.extraData.getBoolean("setPrettyTroopOwnerFlag", false)) {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
    }
  }
  
  private void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    int i = paramToServiceMsg.extraData.getInt("eSubCmd");
    if (i != CARDSETTYPE.TYPE_SET_TEMPLATE.value())
    {
      QLog.w("CardHandler", 1, String.format("handleSetCard not support cmd, subCmd=%s", new Object[] { Integer.valueOf(i) }));
      return;
    }
    paramBundle.putInt("eSubCmd", i);
    paramBundle.putByte("bIsSingle", paramToServiceMsg.extraData.getByte("bIsSingle"));
    paramBundle.putByteArray("vBackground", paramToServiceMsg.extraData.getByteArray("vBackground"));
    paramBundle.putByteArray("vReqSetTemplate", paramToServiceMsg.extraData.getByteArray("vReqSetTemplate"));
    paramBundle = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (paramFromServiceMsg.isSuccess())
    {
      boolean bool = paramObject instanceof RespSetCard;
      paramFromServiceMsg = null;
      if (bool)
      {
        paramToServiceMsg = (RespSetCard)paramObject;
        if ((paramToServiceMsg.stHeader != null) && (paramToServiceMsg.stHeader.iReplyCode == 0) && (paramToServiceMsg.vRespSetTemplate != null))
        {
          paramObject = (SSummaryCardRsp)decodePacket(paramToServiceMsg.vRespSetTemplate, "rsp", new SSummaryCardRsp());
          if (paramObject != null)
          {
            if (paramObject.res == 0)
            {
              paramFromServiceMsg = paramBundle.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
              if (paramFromServiceMsg != null)
              {
                paramFromServiceMsg.lCurrentStyleId = paramObject.styleid;
                paramFromServiceMsg.backgroundUrl = paramObject.bgurl;
                paramFromServiceMsg.lCurrentBgId = paramObject.bgid;
                paramFromServiceMsg.backgroundColor = paramObject.color;
                paramFromServiceMsg.dynamicCardFlag = paramObject.dynamicCardFlag;
                paramFromServiceMsg.strZipUrl = paramObject.strZipUrl;
                paramFromServiceMsg.strActiveUrl = paramObject.strActiveCardUrl;
                paramFromServiceMsg.strDrawerCardUrl = paramObject.strDrawerCard;
                paramFromServiceMsg.strWzryHeroUrl = paramObject.strWzryHeroUrl;
                paramFromServiceMsg.strExtInfo = paramObject.extInfo;
                paramFromServiceMsg.cardType = paramObject.cardType;
                paramFromServiceMsg.diyDefaultText = paramObject.strDiyDefaultText;
                if (paramObject.stDiyComplicated == null) {
                  paramToServiceMsg = "";
                } else {
                  paramToServiceMsg = paramObject.stDiyComplicated.detail;
                }
                paramFromServiceMsg.diyComplicatedInfo = paramToServiceMsg;
                paramFromServiceMsg.cardId = paramObject.cardid;
                paramToServiceMsg = paramObject.bgtype;
                if (paramToServiceMsg != null) {
                  paramFromServiceMsg.setBgType(paramToServiceMsg);
                }
                if ((paramObject.wzryInfo != null) && (!paramObject.wzryInfo.isEmpty())) {
                  paramFromServiceMsg.setWzryHonorInfo(paramObject.wzryInfo);
                }
                paramFromServiceMsg.templateRet = 0;
                if (paramObject.stDiyText != null)
                {
                  paramFromServiceMsg.diyTextFontId = paramObject.stDiyText.iFontId;
                  paramFromServiceMsg.diyText = paramObject.stDiyText.strText;
                  paramFromServiceMsg.diyTextScale = paramObject.stDiyText.fScaling;
                  paramFromServiceMsg.diyTextDegree = paramObject.stDiyText.fRotationAngle;
                  paramFromServiceMsg.diyTextTransparency = paramObject.stDiyText.fTransparency;
                  if (!TextUtils.isEmpty(paramObject.stDiyText.strPoint))
                  {
                    paramToServiceMsg = paramObject.stDiyText.strPoint.split("_");
                    if (paramToServiceMsg.length == 2) {
                      try
                      {
                        paramFromServiceMsg.diyTextLocX = Float.parseFloat(paramToServiceMsg[0]);
                        paramFromServiceMsg.diyTextLocY = Float.parseFloat(paramToServiceMsg[1]);
                      }
                      catch (Exception paramToServiceMsg)
                      {
                        QLog.e("CardHandler", 1, "set card with diy text response", paramToServiceMsg);
                      }
                    }
                  }
                }
                paramBundle.a(paramFromServiceMsg);
                paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
                if (paramToServiceMsg != null)
                {
                  paramToServiceMsg = paramToServiceMsg.edit();
                  if (paramToServiceMsg != null) {
                    paramToServiceMsg.putBoolean("svip_profile_use_guide_shown_flag", false).commit();
                  }
                }
              }
              paramToServiceMsg = null;
              break label606;
            }
            paramToServiceMsg = new Pair(Integer.valueOf(paramObject.res), paramObject);
            break label606;
          }
        }
      }
      paramToServiceMsg = null;
      label606:
      if (paramFromServiceMsg != null) {
        paramToServiceMsg = paramFromServiceMsg;
      }
      notifyUI(41, true, paramToServiceMsg);
      return;
    }
    notifyUI(41, false, paramBundle.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    ReportCenter.a().a(paramFromServiceMsg.getServiceCmd(), 100, paramFromServiceMsg.getBusinessFailCode(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 1000277, HardCodeUtil.a(2131701663), true);
  }
  
  private void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleSetTempConversationInBoxState success=");
      paramFromServiceMsg.append(bool1);
      QLog.d("Q.profilecard.", 2, paramFromServiceMsg.toString());
    }
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("blockSwitch");
    boolean bool3 = paramToServiceMsg.extraData.getBoolean("inBoxSwitch");
    paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131694712);
    short s = paramToServiceMsg.extraData.getShort("type");
    boolean bool1 = a(paramToServiceMsg, (byte[])paramObject, bool1);
    ((TempMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER)).a(s, bool1, paramFromServiceMsg, bool2, bool3);
  }
  
  private void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    boolean bool;
    if ((paramFromServiceMsg.getResultCode() == 1000) && ((paramObject instanceof SSummaryCardLableRsp))) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("CardHandler->handleSetProfileLabel success : ");
      paramToServiceMsg.append(bool);
      paramToServiceMsg.append(", data : ");
      paramToServiceMsg.append(paramObject);
      QLog.d("ProfileCard.setcard", 2, paramToServiceMsg.toString());
    }
    if ((bool) && (paramObject != null))
    {
      paramToServiceMsg = (SSummaryCardLableRsp)paramObject;
      if (paramToServiceMsg.ret == 0)
      {
        if (paramToServiceMsg.likes != null)
        {
          paramFromServiceMsg = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
          paramBundle = paramFromServiceMsg.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          paramBundle.setLabelList(paramToServiceMsg.likes.label);
          paramFromServiceMsg.a(paramBundle);
        }
        notifyUI(52, true, paramObject);
        return;
      }
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("CardHandler->handleSetProfileLabel retCode : ");
        paramFromServiceMsg.append(paramToServiceMsg.ret);
        paramFromServiceMsg.append(", msg : ");
        paramFromServiceMsg.append(paramToServiceMsg.msg);
        QLog.d("ProfileCard.setcard", 2, paramFromServiceMsg.toString());
      }
      notifyUI(52, false, paramObject);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("CardHandler->handleSetProfileLabel fail from msf retCode : ");
      paramToServiceMsg.append(paramFromServiceMsg.getResultCode());
      QLog.d("ProfileCard.setcard", 2, paramToServiceMsg.toString());
    }
    notifyUI(52, false, paramObject);
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("-->report MM:cmd=");
      paramToServiceMsg.append(paramFromServiceMsg.getServiceCmd());
      paramToServiceMsg.append(",error code=");
      paramToServiceMsg.append(paramFromServiceMsg.getBusinessFailCode());
      paramToServiceMsg.append(",uin=");
      paramToServiceMsg.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      QLog.e("CardHandler", 2, paramToServiceMsg.toString());
    }
    ReportCenter.a().a(paramFromServiceMsg.getServiceCmd(), 100, paramFromServiceMsg.getBusinessFailCode(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 1000277, HardCodeUtil.a(2131701666), true);
  }
  
  private void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = paramFromServiceMsg.isSuccess();
    boolean bool6 = true;
    boolean bool5 = true;
    boolean bool1 = true;
    boolean bool4 = true;
    boolean bool3;
    if ((bool2) && (paramObject != null)) {
      bool3 = true;
    } else {
      bool3 = false;
    }
    bool2 = bool3;
    if (bool3) {
      bool3 = bool5;
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        bool3 = bool5;
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        bool3 = bool5;
        if (paramToServiceMsg.uint32_result.get() != 0) {
          break label218;
        }
        bool2 = true;
        bool1 = bool6;
        if (bool2)
        {
          bool3 = bool5;
          paramToServiceMsg = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          bool3 = bool5;
          paramToServiceMsg.getInt();
          bool3 = bool5;
          if (paramToServiceMsg.get() != 0) {
            break label224;
          }
          bool1 = bool4;
          bool3 = bool1;
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setPhoneNumSearchable(bool1, false);
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.d("GetPhoneNumSearchable", 2, paramToServiceMsg.getMessage());
        }
        bool2 = false;
        bool1 = bool3;
      }
      if (!bool2) {
        bool1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isPhoneNumSearchable(false);
      }
      notifyUI(38, bool2, Boolean.valueOf(bool1));
      return;
      label218:
      bool2 = false;
      continue;
      label224:
      bool1 = false;
    }
  }
  
  private void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    boolean bool;
    if ((paramFromServiceMsg.getResultCode() == 1000) && ((paramObject instanceof SSummaryCardLableRsp))) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("CardHandler->handleSetLabelLike success : ");
      paramBundle.append(bool);
      paramBundle.append(", data : ");
      paramBundle.append(paramObject);
      QLog.d("ProfileCard.setcard", 2, paramBundle.toString());
    }
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
    paramBundle = localFriendsManager.b(String.valueOf(paramToServiceMsg.extraData.getLong("destUin")));
    long l = paramToServiceMsg.extraData.getLong("labelId");
    if ((bool) && (paramObject != null))
    {
      paramToServiceMsg = (SSummaryCardLableRsp)paramObject;
      if (paramToServiceMsg.ret == 0)
      {
        if (paramToServiceMsg.likes != null)
        {
          paramBundle.setLabelList(paramToServiceMsg.likes.label);
          localFriendsManager.a(paramBundle);
        }
        notifyUI(53, true, new Object[] { paramBundle, Long.valueOf(Long.valueOf(l).longValue()) });
        return;
      }
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("CardHandler->handleSetLabelLike retCode : ");
        paramFromServiceMsg.append(paramToServiceMsg.ret);
        paramFromServiceMsg.append(", msg : ");
        paramFromServiceMsg.append(paramToServiceMsg.msg);
        QLog.d("ProfileCard.setcard", 2, paramFromServiceMsg.toString());
      }
      notifyUI(53, false, paramBundle);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("CardHandler->handleSetLabelLike fail from msf retCode : ");
      paramToServiceMsg.append(paramFromServiceMsg.getResultCode());
      QLog.d("ProfileCard.setcard", 2, paramToServiceMsg.toString());
    }
    notifyUI(53, false, paramBundle);
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("-->report MM:cmd=");
      paramToServiceMsg.append(paramFromServiceMsg.getServiceCmd());
      paramToServiceMsg.append(",error code=");
      paramToServiceMsg.append(paramFromServiceMsg.getBusinessFailCode());
      paramToServiceMsg.append(",uin=");
      paramToServiceMsg.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      QLog.e("CardHandler", 2, paramToServiceMsg.toString());
    }
    ReportCenter.a().a(paramFromServiceMsg.getServiceCmd(), 100, paramFromServiceMsg.getBusinessFailCode(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 1000277, HardCodeUtil.a(2131701665), true);
  }
  
  private void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1 = paramFromServiceMsg.isSuccess();
    boolean bool4 = true;
    boolean bool2;
    if ((bool1) && (paramObject != null)) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    boolean bool3 = paramToServiceMsg.extraData.getBoolean("key_searchable", true);
    bool1 = bool2;
    if (bool2) {}
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.uint32_result.get() != 0) {
          break label158;
        }
        bool1 = bool4;
        if (bool1) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setPhoneNumSearchable(bool3, false);
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SetPhoneNumSearchable", 2, paramToServiceMsg.getMessage());
        }
        bool1 = false;
      }
      bool2 = bool3;
      if (!bool1) {
        bool2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isPhoneNumSearchable(false);
      }
      notifyUI(39, bool1, Boolean.valueOf(bool2));
      return;
      label158:
      bool1 = false;
    }
  }
  
  private void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    paramBundle.putByteArray("fileKey", paramToServiceMsg.extraData.getByteArray("filekey"));
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      RespDelFace localRespDelFace = (RespDelFace)paramObject;
      FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      paramObject = localFriendsManager.a(paramToServiceMsg.getUin());
      paramFromServiceMsg = paramObject;
      if (paramObject == null)
      {
        paramFromServiceMsg = new Card();
        paramFromServiceMsg.uin = paramToServiceMsg.getUin();
      }
      paramBundle.putInt("result", localRespDelFace.stHeader.iReplyCode);
      int i = localRespDelFace.stHeader.iReplyCode;
      if (i != 0)
      {
        if ((i == 1) || (i == 2)) {
          notifyUI(12, false, new Object[] { paramBundle, paramFromServiceMsg });
        }
      }
      else
      {
        if (localRespDelFace.uFaceTimeStamp > paramFromServiceMsg.uFaceTimeStamp) {
          paramFromServiceMsg.uFaceTimeStamp = localRespDelFace.uFaceTimeStamp;
        }
        notifyUI(12, true, new Object[] { paramBundle, paramFromServiceMsg });
      }
      localFriendsManager.a(paramFromServiceMsg);
      return;
    }
    paramBundle.putInt("result", -1);
    notifyUI(12, false, new Object[] { paramBundle, ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramToServiceMsg.getUin()) });
  }
  
  private void o()
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
      {
        notifyUI(69, false, new Object[] { "" });
        return;
      }
      Object localObject1 = (String)this.jdField_a_of_type_JavaUtilArrayList.remove(0);
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        notifyUI(69, false, new Object[] { "" });
        return;
      }
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("uploadPhotoWall filePath:");
        ((StringBuilder)???).append((String)localObject1);
        QLog.d("Q.qzonephotowall", 2, ((StringBuilder)???).toString());
      }
      ??? = new PhotoWallUploadTask((String)localObject1);
      ((PhotoWallUploadTask)???).flowId = ((int)System.currentTimeMillis() / 1000);
      ((PhotoWallUploadTask)???).sRefer = "mqq";
      ((PhotoWallUploadTask)???).iUin = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      ((PhotoWallUploadTask)???).vLoginData = VipUploadUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      ((PhotoWallUploadTask)???).op = 1;
      ((PhotoWallUploadTask)???).source = 1;
      ((PhotoWallUploadTask)???).uploadTaskCallback = new CardHandler.4(this);
      ((PhotoWallUploadTask)???).uploadFilePath = ((String)localObject1);
      ((PhotoWallUploadTask)???).md5 = VipUploadUtils.a((String)localObject1);
      ((PhotoWallUploadTask)???).autoRotate = true;
      localObject1 = new CardHandler.5(this, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
      UploadEnv localUploadEnv = new UploadEnv();
      if (!UploadServiceBuilder.getInstance().isInitialized()) {
        UploadServiceBuilder.getInstance().init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), (IUploadConfig)localObject1, null, null, localUploadEnv, localUploadEnv);
      }
      UploadServiceBuilder.getInstance().upload((AbstractUploadTask)???);
      return;
    }
  }
  
  private void o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = (String)paramToServiceMsg.getAttribute("uin");
    boolean bool;
    if ((paramFromServiceMsg.isSuccess()) && ((paramObject instanceof mobile_sub_get_cover_rsp)))
    {
      paramFromServiceMsg = (mobile_sub_get_cover_rsp)paramObject;
      EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      paramObject = (QZoneCover)localEntityManager.find(QZoneCover.class, str);
      paramToServiceMsg = paramObject;
      if (paramObject == null)
      {
        paramToServiceMsg = new QZoneCover();
        paramToServiceMsg.uin = str;
      }
      paramToServiceMsg.updateQzoneCover(paramFromServiceMsg);
      if (paramToServiceMsg.getStatus() == 1000) {
        localEntityManager.persist(paramToServiceMsg);
      } else {
        localEntityManager.update(paramToServiceMsg);
      }
      localEntityManager.close();
      bool = true;
      paramToServiceMsg = paramFromServiceMsg;
    }
    else
    {
      paramToServiceMsg = null;
      bool = false;
    }
    notifyUI(40, bool, new Object[] { str, paramToServiceMsg });
  }
  
  /* Error */
  private void p(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 101	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: ifeq +13 -> 17
    //   7: aload_3
    //   8: ifnull +9 -> 17
    //   11: iconst_1
    //   12: istore 5
    //   14: goto +6 -> 20
    //   17: iconst_0
    //   18: istore 5
    //   20: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   23: ifeq +36 -> 59
    //   26: new 20	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   33: astore_2
    //   34: aload_2
    //   35: ldc_w 2507
    //   38: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload_2
    //   43: iload 5
    //   45: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: ldc 113
    //   51: iconst_2
    //   52: aload_2
    //   53: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: aload_0
    //   60: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   63: invokevirtual 526	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   66: ldc_w 527
    //   69: invokevirtual 530	mqq/app/MobileQQ:getString	(I)Ljava/lang/String;
    //   72: astore_2
    //   73: aload_0
    //   74: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   77: invokevirtual 171	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   80: astore 11
    //   82: iload 5
    //   84: istore 8
    //   86: iload 5
    //   88: ifeq +466 -> 554
    //   91: iload 5
    //   93: istore 7
    //   95: iload 5
    //   97: istore 6
    //   99: new 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   102: dup
    //   103: invokespecial 120	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   106: aload_3
    //   107: checkcast 122	[B
    //   110: checkcast 122	[B
    //   113: invokevirtual 126	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   116: checkcast 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   119: astore_3
    //   120: aload_3
    //   121: ifnull +546 -> 667
    //   124: iload 5
    //   126: istore 7
    //   128: iload 5
    //   130: istore 6
    //   132: aload_3
    //   133: getfield 130	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   136: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   139: ifne +528 -> 667
    //   142: iconst_1
    //   143: istore 5
    //   145: goto +3 -> 148
    //   148: iload 5
    //   150: istore 7
    //   152: iload 5
    //   154: istore 6
    //   156: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   159: ifeq +72 -> 231
    //   162: iload 5
    //   164: istore 7
    //   166: iload 5
    //   168: istore 6
    //   170: new 20	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   177: astore 12
    //   179: iload 5
    //   181: istore 7
    //   183: iload 5
    //   185: istore 6
    //   187: aload 12
    //   189: ldc_w 2509
    //   192: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   195: pop
    //   196: iload 5
    //   198: istore 7
    //   200: iload 5
    //   202: istore 6
    //   204: aload 12
    //   206: iload 5
    //   208: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: iload 5
    //   214: istore 7
    //   216: iload 5
    //   218: istore 6
    //   220: ldc 113
    //   222: iconst_2
    //   223: aload 12
    //   225: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   228: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   231: iload 5
    //   233: istore 8
    //   235: iload 5
    //   237: ifeq +317 -> 554
    //   240: iload 5
    //   242: istore 7
    //   244: iload 5
    //   246: istore 6
    //   248: iload 5
    //   250: istore 8
    //   252: aload_3
    //   253: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   256: invokevirtual 146	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   259: ifeq +295 -> 554
    //   262: iload 5
    //   264: istore 7
    //   266: iload 5
    //   268: istore 6
    //   270: iload 5
    //   272: istore 8
    //   274: aload_3
    //   275: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   278: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   281: ifnull +273 -> 554
    //   284: iload 5
    //   286: istore 7
    //   288: iload 5
    //   290: istore 6
    //   292: aload_3
    //   293: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   296: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   299: invokevirtual 155	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   302: invokestatic 161	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   305: invokevirtual 164	java/nio/ByteBuffer:getInt	()I
    //   308: istore 4
    //   310: iload 4
    //   312: i2l
    //   313: lstore 9
    //   315: iload 4
    //   317: ifge +16 -> 333
    //   320: iload 4
    //   322: ldc_w 533
    //   325: iand
    //   326: i2l
    //   327: ldc2_w 534
    //   330: lor
    //   331: lstore 9
    //   333: iload 5
    //   335: istore 7
    //   337: iload 5
    //   339: istore 6
    //   341: aload_0
    //   342: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   345: invokevirtual 171	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   348: lload 9
    //   350: invokestatic 176	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   353: invokevirtual 179	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   356: ifeq +28 -> 384
    //   359: iload 5
    //   361: istore 7
    //   363: iload 5
    //   365: istore 6
    //   367: aload_1
    //   368: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   371: ldc 202
    //   373: invokevirtual 208	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   376: istore 5
    //   378: iconst_1
    //   379: istore 6
    //   381: goto +180 -> 561
    //   384: iconst_0
    //   385: istore 5
    //   387: iconst_0
    //   388: istore 6
    //   390: goto +171 -> 561
    //   393: astore_2
    //   394: goto +98 -> 492
    //   397: astore_3
    //   398: iload 6
    //   400: istore 7
    //   402: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   405: ifeq +17 -> 422
    //   408: iload 6
    //   410: istore 7
    //   412: ldc 113
    //   414: iconst_2
    //   415: ldc_w 2511
    //   418: aload_3
    //   419: invokestatic 222	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   422: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   425: ifeq +57 -> 482
    //   428: new 20	java/lang/StringBuilder
    //   431: dup
    //   432: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   435: astore_3
    //   436: aload_3
    //   437: ldc_w 2509
    //   440: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: pop
    //   444: aload_3
    //   445: iload 6
    //   447: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   450: pop
    //   451: aload_3
    //   452: ldc 224
    //   454: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: pop
    //   458: aload_3
    //   459: aload_1
    //   460: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   463: ldc 202
    //   465: invokevirtual 208	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   468: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   471: pop
    //   472: ldc 113
    //   474: iconst_2
    //   475: aload_3
    //   476: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   479: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   482: iconst_0
    //   483: istore 7
    //   485: iload 6
    //   487: istore 8
    //   489: goto +148 -> 637
    //   492: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   495: ifeq +57 -> 552
    //   498: new 20	java/lang/StringBuilder
    //   501: dup
    //   502: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   505: astore_3
    //   506: aload_3
    //   507: ldc_w 2509
    //   510: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: pop
    //   514: aload_3
    //   515: iload 7
    //   517: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   520: pop
    //   521: aload_3
    //   522: ldc 224
    //   524: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   527: pop
    //   528: aload_3
    //   529: aload_1
    //   530: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   533: ldc 202
    //   535: invokevirtual 208	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   538: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   541: pop
    //   542: ldc 113
    //   544: iconst_2
    //   545: aload_3
    //   546: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   549: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   552: aload_2
    //   553: athrow
    //   554: iconst_0
    //   555: istore 5
    //   557: iload 8
    //   559: istore 6
    //   561: iload 5
    //   563: istore 7
    //   565: iload 6
    //   567: istore 8
    //   569: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   572: ifeq +65 -> 637
    //   575: new 20	java/lang/StringBuilder
    //   578: dup
    //   579: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   582: astore_3
    //   583: aload_3
    //   584: ldc_w 2509
    //   587: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: pop
    //   591: aload_3
    //   592: iload 6
    //   594: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   597: pop
    //   598: aload_3
    //   599: ldc 224
    //   601: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: pop
    //   605: aload_3
    //   606: aload_1
    //   607: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   610: ldc 202
    //   612: invokevirtual 208	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   615: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   618: pop
    //   619: ldc 113
    //   621: iconst_2
    //   622: aload_3
    //   623: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   626: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   629: iload 6
    //   631: istore 8
    //   633: iload 5
    //   635: istore 7
    //   637: aload_0
    //   638: bipush 55
    //   640: iload 8
    //   642: iconst_3
    //   643: anewarray 393	java/lang/Object
    //   646: dup
    //   647: iconst_0
    //   648: iload 7
    //   650: invokestatic 365	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   653: aastore
    //   654: dup
    //   655: iconst_1
    //   656: aload_2
    //   657: aastore
    //   658: dup
    //   659: iconst_2
    //   660: aload 11
    //   662: aastore
    //   663: invokevirtual 228	com/tencent/mobileqq/app/CardHandler:notifyUI	(IZLjava/lang/Object;)V
    //   666: return
    //   667: iconst_0
    //   668: istore 5
    //   670: goto -522 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	673	0	this	CardHandler
    //   0	673	1	paramToServiceMsg	ToServiceMsg
    //   0	673	2	paramFromServiceMsg	FromServiceMsg
    //   0	673	3	paramObject	Object
    //   308	18	4	i	int
    //   12	657	5	bool1	boolean
    //   97	533	6	bool2	boolean
    //   93	556	7	bool3	boolean
    //   84	557	8	bool4	boolean
    //   313	36	9	l	long
    //   80	581	11	str	String
    //   177	47	12	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   99	120	393	finally
    //   132	142	393	finally
    //   156	162	393	finally
    //   170	179	393	finally
    //   187	196	393	finally
    //   204	212	393	finally
    //   220	231	393	finally
    //   252	262	393	finally
    //   274	284	393	finally
    //   292	310	393	finally
    //   341	359	393	finally
    //   367	378	393	finally
    //   402	408	393	finally
    //   412	422	393	finally
    //   99	120	397	java/lang/Exception
    //   132	142	397	java/lang/Exception
    //   156	162	397	java/lang/Exception
    //   170	179	397	java/lang/Exception
    //   187	196	397	java/lang/Exception
    //   204	212	397	java/lang/Exception
    //   220	231	397	java/lang/Exception
    //   252	262	397	java/lang/Exception
    //   274	284	397	java/lang/Exception
    //   292	310	397	java/lang/Exception
    //   341	359	397	java/lang/Exception
    //   367	378	397	java/lang/Exception
  }
  
  private void q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleSetTempConversationBlocState success=");
      paramFromServiceMsg.append(bool1);
      QLog.d("Q.profilecard.", 2, paramFromServiceMsg.toString());
    }
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("switch");
    paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131694712);
    short s = paramToServiceMsg.extraData.getShort("type");
    boolean bool1 = a(paramToServiceMsg, (byte[])paramObject, bool1);
    ((TempMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER)).a(s, bool1, paramFromServiceMsg, bool2);
  }
  
  /* Error */
  private void r(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 101	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: ifeq +13 -> 17
    //   7: aload_3
    //   8: ifnull +9 -> 17
    //   11: iconst_1
    //   12: istore 5
    //   14: goto +6 -> 20
    //   17: iconst_0
    //   18: istore 5
    //   20: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   23: ifeq +36 -> 59
    //   26: new 20	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   33: astore_2
    //   34: aload_2
    //   35: ldc_w 2518
    //   38: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload_2
    //   43: iload 5
    //   45: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: ldc 113
    //   51: iconst_2
    //   52: aload_2
    //   53: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: aload_0
    //   60: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   63: invokevirtual 526	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   66: ldc_w 527
    //   69: invokevirtual 530	mqq/app/MobileQQ:getString	(I)Ljava/lang/String;
    //   72: astore 7
    //   74: aload_0
    //   75: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   78: invokevirtual 171	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   81: astore 8
    //   83: iload 5
    //   85: istore 4
    //   87: iload 5
    //   89: ifeq +325 -> 414
    //   92: iload 5
    //   94: istore 6
    //   96: iload 5
    //   98: istore 4
    //   100: new 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   103: dup
    //   104: invokespecial 120	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   107: aload_3
    //   108: checkcast 122	[B
    //   111: checkcast 122	[B
    //   114: invokevirtual 126	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   117: checkcast 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   120: astore_2
    //   121: aload_2
    //   122: ifnull +366 -> 488
    //   125: iload 5
    //   127: istore 6
    //   129: iload 5
    //   131: istore 4
    //   133: aload_2
    //   134: getfield 130	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   137: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   140: ifne +348 -> 488
    //   143: iconst_1
    //   144: istore 5
    //   146: goto +3 -> 149
    //   149: iload 5
    //   151: istore 6
    //   153: iload 5
    //   155: istore 4
    //   157: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   160: ifeq +68 -> 228
    //   163: iload 5
    //   165: istore 6
    //   167: iload 5
    //   169: istore 4
    //   171: new 20	java/lang/StringBuilder
    //   174: dup
    //   175: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   178: astore_3
    //   179: iload 5
    //   181: istore 6
    //   183: iload 5
    //   185: istore 4
    //   187: aload_3
    //   188: ldc_w 2520
    //   191: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   194: pop
    //   195: iload 5
    //   197: istore 6
    //   199: iload 5
    //   201: istore 4
    //   203: aload_3
    //   204: iload 5
    //   206: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   209: pop
    //   210: iload 5
    //   212: istore 6
    //   214: iload 5
    //   216: istore 4
    //   218: ldc 113
    //   220: iconst_2
    //   221: aload_3
    //   222: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   225: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   228: iload 5
    //   230: istore 6
    //   232: iload 5
    //   234: istore 4
    //   236: aload_0
    //   237: iload 5
    //   239: aload_2
    //   240: invokespecial 1489	com/tencent/mobileqq/app/CardHandler:a	(ZLtencent/im/oidb/oidb_sso$OIDBSSOPkg;)Z
    //   243: istore 5
    //   245: iload 5
    //   247: istore 4
    //   249: goto +165 -> 414
    //   252: astore_2
    //   253: goto +99 -> 352
    //   256: astore_2
    //   257: iload 4
    //   259: istore 6
    //   261: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   264: ifeq +17 -> 281
    //   267: iload 4
    //   269: istore 6
    //   271: ldc 113
    //   273: iconst_2
    //   274: ldc_w 2511
    //   277: aload_2
    //   278: invokestatic 222	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   281: iload 4
    //   283: istore 5
    //   285: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   288: ifeq +147 -> 435
    //   291: new 20	java/lang/StringBuilder
    //   294: dup
    //   295: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   298: astore_2
    //   299: aload_2
    //   300: ldc_w 2509
    //   303: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   306: pop
    //   307: aload_2
    //   308: iload 4
    //   310: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   313: pop
    //   314: aload_2
    //   315: ldc 224
    //   317: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   320: pop
    //   321: aload_2
    //   322: aload_1
    //   323: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   326: ldc 202
    //   328: invokevirtual 208	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   331: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   334: pop
    //   335: ldc 113
    //   337: iconst_2
    //   338: aload_2
    //   339: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   342: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   345: iload 4
    //   347: istore 5
    //   349: goto +86 -> 435
    //   352: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   355: ifeq +57 -> 412
    //   358: new 20	java/lang/StringBuilder
    //   361: dup
    //   362: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   365: astore_3
    //   366: aload_3
    //   367: ldc_w 2509
    //   370: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: pop
    //   374: aload_3
    //   375: iload 6
    //   377: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   380: pop
    //   381: aload_3
    //   382: ldc 224
    //   384: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: pop
    //   388: aload_3
    //   389: aload_1
    //   390: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   393: ldc 202
    //   395: invokevirtual 208	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   398: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   401: pop
    //   402: ldc 113
    //   404: iconst_2
    //   405: aload_3
    //   406: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   409: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   412: aload_2
    //   413: athrow
    //   414: iload 4
    //   416: istore 5
    //   418: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   421: ifeq +14 -> 435
    //   424: new 20	java/lang/StringBuilder
    //   427: dup
    //   428: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   431: astore_2
    //   432: goto -133 -> 299
    //   435: iload 5
    //   437: ifeq +17 -> 454
    //   440: aload_1
    //   441: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   444: ldc 202
    //   446: invokevirtual 208	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   449: istore 4
    //   451: goto +6 -> 457
    //   454: iconst_0
    //   455: istore 4
    //   457: aload_0
    //   458: bipush 85
    //   460: iload 5
    //   462: iconst_3
    //   463: anewarray 393	java/lang/Object
    //   466: dup
    //   467: iconst_0
    //   468: iload 4
    //   470: invokestatic 365	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   473: aastore
    //   474: dup
    //   475: iconst_1
    //   476: aload 7
    //   478: aastore
    //   479: dup
    //   480: iconst_2
    //   481: aload 8
    //   483: aastore
    //   484: invokevirtual 228	com/tencent/mobileqq/app/CardHandler:notifyUI	(IZLjava/lang/Object;)V
    //   487: return
    //   488: iconst_0
    //   489: istore 5
    //   491: goto -342 -> 149
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	494	0	this	CardHandler
    //   0	494	1	paramToServiceMsg	ToServiceMsg
    //   0	494	2	paramFromServiceMsg	FromServiceMsg
    //   0	494	3	paramObject	Object
    //   85	384	4	bool1	boolean
    //   12	478	5	bool2	boolean
    //   94	282	6	bool3	boolean
    //   72	405	7	str1	String
    //   81	401	8	str2	String
    // Exception table:
    //   from	to	target	type
    //   100	121	252	finally
    //   133	143	252	finally
    //   157	163	252	finally
    //   171	179	252	finally
    //   187	195	252	finally
    //   203	210	252	finally
    //   218	228	252	finally
    //   236	245	252	finally
    //   261	267	252	finally
    //   271	281	252	finally
    //   100	121	256	java/lang/Exception
    //   133	143	256	java/lang/Exception
    //   157	163	256	java/lang/Exception
    //   171	179	256	java/lang/Exception
    //   187	195	256	java/lang/Exception
    //   203	210	256	java/lang/Exception
    //   218	228	256	java/lang/Exception
    //   236	245	256	java/lang/Exception
  }
  
  private void s(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1 = paramFromServiceMsg.isSuccess();
    boolean bool6 = true;
    boolean bool5 = true;
    boolean bool2;
    if ((bool1) && (paramObject != null)) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleSetShowPushNotice success=");
      paramFromServiceMsg.append(bool2);
      QLog.d("Q.profilecard.", 2, paramFromServiceMsg.toString());
    }
    boolean bool3 = bool6;
    bool1 = bool2;
    boolean bool4;
    if (bool2) {
      bool4 = bool2;
    }
    for (;;)
    {
      int i;
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        bool4 = bool2;
        if (paramFromServiceMsg.uint32_result.get() != 0) {
          break label519;
        }
        bool2 = true;
        bool4 = bool2;
        if (QLog.isColorLevel())
        {
          bool4 = bool2;
          paramObject = new StringBuilder();
          bool4 = bool2;
          paramObject.append("handleSetShowPushNotice result=");
          bool4 = bool2;
          paramObject.append(bool2);
          bool4 = bool2;
          QLog.d("Q.profilecard.", 2, paramObject.toString());
        }
        bool3 = bool6;
        bool1 = bool2;
        if (bool2)
        {
          bool4 = bool2;
          bool3 = bool6;
          bool1 = bool2;
          if (paramFromServiceMsg.bytes_bodybuffer.has())
          {
            bool4 = bool2;
            bool3 = bool6;
            bool1 = bool2;
            if (paramFromServiceMsg.bytes_bodybuffer.get() != null)
            {
              bool4 = bool2;
              i = ByteBuffer.wrap(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray()).getInt();
              if (i >= 0) {
                break label525;
              }
              l = i + 4294967296L;
              bool4 = bool2;
              if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(String.valueOf(l)))
              {
                bool4 = bool2;
                bool1 = paramToServiceMsg.extraData.getBoolean("switch");
                try
                {
                  if (QLog.isColorLevel())
                  {
                    paramToServiceMsg = new StringBuilder();
                    paramToServiceMsg.append("handleSetShowPushNotice show=");
                    paramToServiceMsg.append(bool1);
                    QLog.d("Q.profilecard.", 2, paramToServiceMsg.toString());
                  }
                  paramToServiceMsg = new StringBuilder();
                  paramToServiceMsg.append("handleSetShowPushNotice show=");
                  paramToServiceMsg.append(bool1);
                  QLog.d("PushNotise", 2, paramToServiceMsg.toString());
                  bool2 = true;
                  bool3 = bool1;
                  bool1 = bool2;
                }
                catch (Exception paramToServiceMsg)
                {
                  bool2 = true;
                  bool3 = bool1;
                  bool1 = bool2;
                  continue;
                }
              }
              else
              {
                bool1 = false;
                bool3 = bool6;
              }
            }
          }
        }
      }
      catch (Exception paramToServiceMsg)
      {
        bool1 = bool4;
        bool3 = bool5;
        QLog.e("Q.profilecard.", 2, paramToServiceMsg, new Object[0]);
      }
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("handleSetShowPushNotice show=");
        paramToServiceMsg.append(bool3);
        paramToServiceMsg.append("isSuccess=");
        paramToServiceMsg.append(bool1);
        QLog.d("Q.profilecard.", 2, paramToServiceMsg.toString());
      }
      notifyUI(90, bool1, Boolean.valueOf(bool3));
      return;
      label519:
      bool2 = false;
      continue;
      label525:
      long l = i;
    }
  }
  
  /* Error */
  private void t(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 101	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: istore 5
    //   6: iconst_0
    //   7: istore 9
    //   9: iload 5
    //   11: ifeq +13 -> 24
    //   14: aload_3
    //   15: ifnull +9 -> 24
    //   18: iconst_1
    //   19: istore 5
    //   21: goto +6 -> 27
    //   24: iconst_0
    //   25: istore 5
    //   27: new 20	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   34: astore_1
    //   35: aload_1
    //   36: ldc_w 2533
    //   39: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload_1
    //   44: aload_2
    //   45: invokevirtual 849	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   48: invokevirtual 391	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   51: pop
    //   52: ldc_w 2535
    //   55: iconst_1
    //   56: aload_1
    //   57: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   60: invokestatic 783	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   63: iload 5
    //   65: istore 7
    //   67: iload 5
    //   69: ifeq +379 -> 448
    //   72: iload 5
    //   74: istore 8
    //   76: iload 5
    //   78: istore 6
    //   80: new 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   83: dup
    //   84: invokespecial 120	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   87: aload_3
    //   88: checkcast 122	[B
    //   91: checkcast 122	[B
    //   94: invokevirtual 126	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   97: checkcast 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   100: astore_1
    //   101: iload 5
    //   103: istore 8
    //   105: iload 5
    //   107: istore 6
    //   109: aload_1
    //   110: getfield 130	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   113: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   116: ifne +387 -> 503
    //   119: iconst_1
    //   120: istore 5
    //   122: goto +3 -> 125
    //   125: iload 5
    //   127: istore 8
    //   129: iload 5
    //   131: istore 6
    //   133: new 20	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   140: astore_2
    //   141: iload 5
    //   143: istore 8
    //   145: iload 5
    //   147: istore 6
    //   149: aload_2
    //   150: ldc_w 2537
    //   153: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   156: pop
    //   157: iload 5
    //   159: istore 8
    //   161: iload 5
    //   163: istore 6
    //   165: aload_2
    //   166: iload 5
    //   168: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   171: pop
    //   172: iload 5
    //   174: istore 8
    //   176: iload 5
    //   178: istore 6
    //   180: ldc_w 2535
    //   183: iconst_1
    //   184: aload_2
    //   185: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 783	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   191: iload 5
    //   193: istore 7
    //   195: iload 5
    //   197: ifeq +251 -> 448
    //   200: iload 5
    //   202: istore 8
    //   204: iload 5
    //   206: istore 6
    //   208: iload 5
    //   210: istore 7
    //   212: aload_1
    //   213: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   216: invokevirtual 146	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   219: ifeq +229 -> 448
    //   222: iload 5
    //   224: istore 8
    //   226: iload 5
    //   228: istore 6
    //   230: iload 5
    //   232: istore 7
    //   234: aload_1
    //   235: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   238: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   241: ifnull +207 -> 448
    //   244: iload 5
    //   246: istore 8
    //   248: iload 5
    //   250: istore 6
    //   252: new 333	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody
    //   255: dup
    //   256: invokespecial 334	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:<init>	()V
    //   259: astore_2
    //   260: iload 5
    //   262: istore 8
    //   264: iload 5
    //   266: istore 6
    //   268: aload_2
    //   269: aload_1
    //   270: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   273: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   276: invokevirtual 155	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   279: invokevirtual 335	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   282: pop
    //   283: iload 5
    //   285: istore 8
    //   287: iload 5
    //   289: istore 6
    //   291: aload_2
    //   292: getfield 339	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   295: invokevirtual 1465	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   298: ifle +48 -> 346
    //   301: iload 5
    //   303: istore 8
    //   305: iload 5
    //   307: istore 6
    //   309: aload_2
    //   310: getfield 339	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   313: iconst_0
    //   314: invokevirtual 1468	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   317: checkcast 353	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData
    //   320: getfield 2540	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_flag_hide_pretty_group_owner_identity	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   323: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   326: istore 4
    //   328: iload 9
    //   330: istore 5
    //   332: iload 4
    //   334: ifne +6 -> 340
    //   337: iconst_1
    //   338: istore 5
    //   340: iconst_1
    //   341: istore 7
    //   343: goto +108 -> 451
    //   346: iconst_0
    //   347: istore 7
    //   349: goto +99 -> 448
    //   352: astore_1
    //   353: goto +59 -> 412
    //   356: astore_1
    //   357: iload 6
    //   359: istore 8
    //   361: ldc_w 2535
    //   364: iconst_1
    //   365: ldc_w 2542
    //   368: aload_1
    //   369: invokestatic 896	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   372: new 20	java/lang/StringBuilder
    //   375: dup
    //   376: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   379: astore_1
    //   380: aload_1
    //   381: ldc_w 2537
    //   384: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: pop
    //   388: aload_1
    //   389: iload 6
    //   391: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   394: pop
    //   395: ldc_w 2535
    //   398: iconst_1
    //   399: aload_1
    //   400: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   403: invokestatic 783	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   406: iconst_1
    //   407: istore 5
    //   409: goto +80 -> 489
    //   412: new 20	java/lang/StringBuilder
    //   415: dup
    //   416: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   419: astore_2
    //   420: aload_2
    //   421: ldc_w 2537
    //   424: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: pop
    //   428: aload_2
    //   429: iload 8
    //   431: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   434: pop
    //   435: ldc_w 2535
    //   438: iconst_1
    //   439: aload_2
    //   440: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   443: invokestatic 783	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   446: aload_1
    //   447: athrow
    //   448: iconst_1
    //   449: istore 5
    //   451: new 20	java/lang/StringBuilder
    //   454: dup
    //   455: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   458: astore_1
    //   459: aload_1
    //   460: ldc_w 2537
    //   463: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   466: pop
    //   467: aload_1
    //   468: iload 7
    //   470: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   473: pop
    //   474: ldc_w 2535
    //   477: iconst_1
    //   478: aload_1
    //   479: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   482: invokestatic 783	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   485: iload 7
    //   487: istore 6
    //   489: aload_0
    //   490: bipush 107
    //   492: iload 6
    //   494: iload 5
    //   496: invokestatic 365	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   499: invokevirtual 228	com/tencent/mobileqq/app/CardHandler:notifyUI	(IZLjava/lang/Object;)V
    //   502: return
    //   503: iconst_0
    //   504: istore 5
    //   506: goto -381 -> 125
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	509	0	this	CardHandler
    //   0	509	1	paramToServiceMsg	ToServiceMsg
    //   0	509	2	paramFromServiceMsg	FromServiceMsg
    //   0	509	3	paramObject	Object
    //   326	7	4	i	int
    //   4	501	5	bool1	boolean
    //   78	415	6	bool2	boolean
    //   65	421	7	bool3	boolean
    //   74	356	8	bool4	boolean
    //   7	322	9	bool5	boolean
    // Exception table:
    //   from	to	target	type
    //   80	101	352	finally
    //   109	119	352	finally
    //   133	141	352	finally
    //   149	157	352	finally
    //   165	172	352	finally
    //   180	191	352	finally
    //   212	222	352	finally
    //   234	244	352	finally
    //   252	260	352	finally
    //   268	283	352	finally
    //   291	301	352	finally
    //   309	328	352	finally
    //   361	372	352	finally
    //   80	101	356	java/lang/Exception
    //   109	119	356	java/lang/Exception
    //   133	141	356	java/lang/Exception
    //   149	157	356	java/lang/Exception
    //   165	172	356	java/lang/Exception
    //   180	191	356	java/lang/Exception
    //   212	222	356	java/lang/Exception
    //   234	244	356	java/lang/Exception
    //   252	260	356	java/lang/Exception
    //   268	283	356	java/lang/Exception
    //   291	301	356	java/lang/Exception
    //   309	328	356	java/lang/Exception
  }
  
  private void u(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handlePartekeLikeRankingList success=");
      paramToServiceMsg.append(bool);
      QLog.d("CardHandler", 2, paramToServiceMsg.toString());
    }
    a((byte[])paramObject, bool, true);
  }
  
  /* Error */
  private void v(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 101	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: ifeq +13 -> 17
    //   7: aload_3
    //   8: ifnull +9 -> 17
    //   11: iconst_1
    //   12: istore 4
    //   14: goto +6 -> 20
    //   17: iconst_0
    //   18: istore 4
    //   20: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   23: ifeq +37 -> 60
    //   26: new 20	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   33: astore_1
    //   34: aload_1
    //   35: ldc_w 2548
    //   38: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload_1
    //   43: iload 4
    //   45: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: ldc_w 368
    //   52: iconst_2
    //   53: aload_1
    //   54: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   60: iload 4
    //   62: istore 7
    //   64: iload 4
    //   66: ifeq +468 -> 534
    //   69: iload 4
    //   71: istore 6
    //   73: iload 4
    //   75: istore 5
    //   77: new 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   80: dup
    //   81: invokespecial 120	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   84: aload_3
    //   85: checkcast 122	[B
    //   88: checkcast 122	[B
    //   91: invokevirtual 126	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   94: checkcast 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   97: astore_1
    //   98: iload 4
    //   100: istore 6
    //   102: iload 4
    //   104: istore 5
    //   106: aload_1
    //   107: getfield 130	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   110: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   113: ifne +466 -> 579
    //   116: iconst_1
    //   117: istore 4
    //   119: goto +3 -> 122
    //   122: iload 4
    //   124: istore 6
    //   126: iload 4
    //   128: istore 5
    //   130: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   133: ifeq +69 -> 202
    //   136: iload 4
    //   138: istore 6
    //   140: iload 4
    //   142: istore 5
    //   144: new 20	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   151: astore_2
    //   152: iload 4
    //   154: istore 6
    //   156: iload 4
    //   158: istore 5
    //   160: aload_2
    //   161: ldc_w 2550
    //   164: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: iload 4
    //   170: istore 6
    //   172: iload 4
    //   174: istore 5
    //   176: aload_2
    //   177: iload 4
    //   179: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: iload 4
    //   185: istore 6
    //   187: iload 4
    //   189: istore 5
    //   191: ldc_w 368
    //   194: iconst_2
    //   195: aload_2
    //   196: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   199: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   202: iload 4
    //   204: ifeq +145 -> 349
    //   207: iload 4
    //   209: istore 6
    //   211: iload 4
    //   213: istore 5
    //   215: aload_1
    //   216: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   219: invokevirtual 146	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   222: ifeq +127 -> 349
    //   225: iload 4
    //   227: istore 6
    //   229: iload 4
    //   231: istore 5
    //   233: aload_1
    //   234: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   237: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   240: ifnull +109 -> 349
    //   243: iload 4
    //   245: istore 6
    //   247: iload 4
    //   249: istore 5
    //   251: new 2552	tencent/im/oidb/cmd0xa28/oidb_0xa28$RspBody
    //   254: dup
    //   255: invokespecial 2553	tencent/im/oidb/cmd0xa28/oidb_0xa28$RspBody:<init>	()V
    //   258: astore_2
    //   259: iload 4
    //   261: istore 6
    //   263: iload 4
    //   265: istore 5
    //   267: aload_2
    //   268: aload_1
    //   269: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   272: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   275: invokevirtual 155	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   278: invokevirtual 2554	tencent/im/oidb/cmd0xa28/oidb_0xa28$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   281: pop
    //   282: iload 4
    //   284: istore 6
    //   286: iload 4
    //   288: istore 5
    //   290: aload_2
    //   291: aload_0
    //   292: getfield 71	com/tencent/mobileqq/app/CardHandler:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   295: invokestatic 2560	com/tencent/mobileqq/data/KplCard:parseProto	(Ltencent/im/oidb/cmd0xa28/oidb_0xa28$RspBody;Ljava/lang/String;)Lcom/tencent/mobileqq/data/KplCard;
    //   298: astore_1
    //   299: iload 4
    //   301: istore 6
    //   303: iload 4
    //   305: istore 5
    //   307: aload_0
    //   308: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   311: getstatic 185	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   314: invokevirtual 189	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   317: checkcast 191	com/tencent/mobileqq/app/FriendsManager
    //   320: aload_1
    //   321: invokevirtual 2562	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   324: pop
    //   325: iload 4
    //   327: istore 6
    //   329: iload 4
    //   331: istore 5
    //   333: aload_0
    //   334: bipush 88
    //   336: iload 4
    //   338: aload_1
    //   339: invokevirtual 228	com/tencent/mobileqq/app/CardHandler:notifyUI	(IZLjava/lang/Object;)V
    //   342: iload 4
    //   344: istore 7
    //   346: goto +188 -> 534
    //   349: iload 4
    //   351: istore 6
    //   353: iload 4
    //   355: istore 5
    //   357: iload 4
    //   359: istore 7
    //   361: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   364: ifeq +170 -> 534
    //   367: iload 4
    //   369: istore 6
    //   371: iload 4
    //   373: istore 5
    //   375: new 20	java/lang/StringBuilder
    //   378: dup
    //   379: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   382: astore_2
    //   383: iload 4
    //   385: istore 6
    //   387: iload 4
    //   389: istore 5
    //   391: aload_2
    //   392: ldc_w 2564
    //   395: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: pop
    //   399: iload 4
    //   401: istore 6
    //   403: iload 4
    //   405: istore 5
    //   407: aload_2
    //   408: aload_1
    //   409: getfield 130	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   412: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   415: invokevirtual 391	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   418: pop
    //   419: iload 4
    //   421: istore 6
    //   423: iload 4
    //   425: istore 5
    //   427: ldc_w 368
    //   430: iconst_2
    //   431: aload_2
    //   432: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   435: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   438: iload 4
    //   440: istore 7
    //   442: goto +92 -> 534
    //   445: astore_1
    //   446: goto +46 -> 492
    //   449: astore_1
    //   450: iload 5
    //   452: istore 6
    //   454: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   457: ifeq +18 -> 475
    //   460: iload 5
    //   462: istore 6
    //   464: ldc_w 368
    //   467: iconst_2
    //   468: ldc_w 2566
    //   471: aload_1
    //   472: invokestatic 222	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   475: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   478: ifeq +100 -> 578
    //   481: new 20	java/lang/StringBuilder
    //   484: dup
    //   485: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   488: astore_1
    //   489: goto +63 -> 552
    //   492: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   495: ifeq +37 -> 532
    //   498: new 20	java/lang/StringBuilder
    //   501: dup
    //   502: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   505: astore_2
    //   506: aload_2
    //   507: ldc_w 2550
    //   510: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   513: pop
    //   514: aload_2
    //   515: iload 6
    //   517: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   520: pop
    //   521: ldc_w 368
    //   524: iconst_2
    //   525: aload_2
    //   526: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   529: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   532: aload_1
    //   533: athrow
    //   534: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   537: ifeq +41 -> 578
    //   540: new 20	java/lang/StringBuilder
    //   543: dup
    //   544: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   547: astore_1
    //   548: iload 7
    //   550: istore 5
    //   552: aload_1
    //   553: ldc_w 2550
    //   556: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   559: pop
    //   560: aload_1
    //   561: iload 5
    //   563: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   566: pop
    //   567: ldc_w 368
    //   570: iconst_2
    //   571: aload_1
    //   572: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   575: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   578: return
    //   579: iconst_0
    //   580: istore 4
    //   582: goto -460 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	585	0	this	CardHandler
    //   0	585	1	paramToServiceMsg	ToServiceMsg
    //   0	585	2	paramFromServiceMsg	FromServiceMsg
    //   0	585	3	paramObject	Object
    //   12	569	4	bool1	boolean
    //   75	487	5	bool2	boolean
    //   71	445	6	bool3	boolean
    //   62	487	7	bool4	boolean
    // Exception table:
    //   from	to	target	type
    //   77	98	445	finally
    //   106	116	445	finally
    //   130	136	445	finally
    //   144	152	445	finally
    //   160	168	445	finally
    //   176	183	445	finally
    //   191	202	445	finally
    //   215	225	445	finally
    //   233	243	445	finally
    //   251	259	445	finally
    //   267	282	445	finally
    //   290	299	445	finally
    //   307	325	445	finally
    //   333	342	445	finally
    //   361	367	445	finally
    //   375	383	445	finally
    //   391	399	445	finally
    //   407	419	445	finally
    //   427	438	445	finally
    //   454	460	445	finally
    //   464	475	445	finally
    //   77	98	449	java/lang/Exception
    //   106	116	449	java/lang/Exception
    //   130	136	449	java/lang/Exception
    //   144	152	449	java/lang/Exception
    //   160	168	449	java/lang/Exception
    //   176	183	449	java/lang/Exception
    //   191	202	449	java/lang/Exception
    //   215	225	449	java/lang/Exception
    //   233	243	449	java/lang/Exception
    //   251	259	449	java/lang/Exception
    //   267	282	449	java/lang/Exception
    //   290	299	449	java/lang/Exception
    //   307	325	449	java/lang/Exception
    //   333	342	449	java/lang/Exception
    //   361	367	449	java/lang/Exception
    //   375	383	449	java/lang/Exception
    //   391	399	449	java/lang/Exception
    //   407	419	449	java/lang/Exception
    //   427	438	449	java/lang/Exception
  }
  
  /* Error */
  private void w(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 101	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: istore 5
    //   6: iconst_0
    //   7: istore 4
    //   9: iload 5
    //   11: ifeq +13 -> 24
    //   14: aload_3
    //   15: ifnull +9 -> 24
    //   18: iconst_1
    //   19: istore 5
    //   21: goto +6 -> 27
    //   24: iconst_0
    //   25: istore 5
    //   27: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   30: ifeq +37 -> 67
    //   33: new 20	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   40: astore_1
    //   41: aload_1
    //   42: ldc_w 2568
    //   45: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload_1
    //   50: iload 5
    //   52: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: ldc_w 368
    //   59: iconst_2
    //   60: aload_1
    //   61: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   67: iload 5
    //   69: istore 8
    //   71: iload 5
    //   73: ifeq +1039 -> 1112
    //   76: iload 5
    //   78: istore 7
    //   80: iload 5
    //   82: istore 6
    //   84: aload_0
    //   85: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   88: invokevirtual 1682	com/tencent/mobileqq/app/QQAppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   91: astore_1
    //   92: iload 5
    //   94: istore 7
    //   96: iload 5
    //   98: istore 6
    //   100: new 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   103: dup
    //   104: invokespecial 120	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   107: aload_3
    //   108: checkcast 122	[B
    //   111: checkcast 122	[B
    //   114: invokevirtual 126	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   117: checkcast 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   120: astore_3
    //   121: iload 5
    //   123: istore 7
    //   125: iload 5
    //   127: istore 6
    //   129: aload_3
    //   130: getfield 130	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   133: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   136: ifne +1021 -> 1157
    //   139: iconst_1
    //   140: istore 5
    //   142: goto +3 -> 145
    //   145: iload 5
    //   147: istore 7
    //   149: iload 5
    //   151: istore 6
    //   153: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   156: ifeq +69 -> 225
    //   159: iload 5
    //   161: istore 7
    //   163: iload 5
    //   165: istore 6
    //   167: new 20	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   174: astore_2
    //   175: iload 5
    //   177: istore 7
    //   179: iload 5
    //   181: istore 6
    //   183: aload_2
    //   184: ldc_w 2570
    //   187: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: iload 5
    //   193: istore 7
    //   195: iload 5
    //   197: istore 6
    //   199: aload_2
    //   200: iload 5
    //   202: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   205: pop
    //   206: iload 5
    //   208: istore 7
    //   210: iload 5
    //   212: istore 6
    //   214: ldc_w 368
    //   217: iconst_2
    //   218: aload_2
    //   219: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   225: iload 5
    //   227: istore 8
    //   229: iload 5
    //   231: ifeq +881 -> 1112
    //   234: iload 5
    //   236: istore 7
    //   238: iload 5
    //   240: istore 6
    //   242: iload 5
    //   244: istore 8
    //   246: aload_3
    //   247: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   250: invokevirtual 146	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   253: ifeq +859 -> 1112
    //   256: iload 5
    //   258: istore 7
    //   260: iload 5
    //   262: istore 6
    //   264: iload 5
    //   266: istore 8
    //   268: aload_3
    //   269: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   272: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   275: ifnull +837 -> 1112
    //   278: iload 5
    //   280: istore 7
    //   282: iload 5
    //   284: istore 6
    //   286: new 2572	tencent/im/oidb/cmd0xe26/oidb_0xe26$RspBody
    //   289: dup
    //   290: invokespecial 2573	tencent/im/oidb/cmd0xe26/oidb_0xe26$RspBody:<init>	()V
    //   293: astore_2
    //   294: iload 5
    //   296: istore 7
    //   298: iload 5
    //   300: istore 6
    //   302: aload_2
    //   303: aload_3
    //   304: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   307: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   310: invokevirtual 155	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   313: invokevirtual 2574	tencent/im/oidb/cmd0xe26/oidb_0xe26$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   316: pop
    //   317: iload 5
    //   319: istore 7
    //   321: iload 5
    //   323: istore 6
    //   325: aload_2
    //   326: getfield 2577	tencent/im/oidb/cmd0xe26/oidb_0xe26$RspBody:err_code	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   329: invokevirtual 653	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   332: ifne +585 -> 917
    //   335: iload 5
    //   337: istore 7
    //   339: iload 5
    //   341: istore 6
    //   343: aload_2
    //   344: getfield 2580	tencent/im/oidb/cmd0xe26/oidb_0xe26$RspBody:template_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   347: invokevirtual 345	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   350: invokeinterface 348 1 0
    //   355: ifle +562 -> 917
    //   358: iload 5
    //   360: istore 7
    //   362: iload 5
    //   364: istore 6
    //   366: iload 4
    //   368: aload_2
    //   369: getfield 2580	tencent/im/oidb/cmd0xe26/oidb_0xe26$RspBody:template_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   372: invokevirtual 345	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   375: invokeinterface 348 1 0
    //   380: if_icmpge +537 -> 917
    //   383: iload 5
    //   385: istore 7
    //   387: iload 5
    //   389: istore 6
    //   391: aload_2
    //   392: getfield 2580	tencent/im/oidb/cmd0xe26/oidb_0xe26$RspBody:template_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   395: invokevirtual 345	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   398: iload 4
    //   400: invokeinterface 351 2 0
    //   405: checkcast 2582	tencent/im/oidb/cmd0xe26/oidb_0xe26$EntranceTemplate
    //   408: astore_3
    //   409: iload 5
    //   411: istore 7
    //   413: iload 5
    //   415: istore 6
    //   417: new 2584	org/json/JSONObject
    //   420: dup
    //   421: invokespecial 2585	org/json/JSONObject:<init>	()V
    //   424: astore 9
    //   426: iload 5
    //   428: istore 7
    //   430: iload 5
    //   432: istore 6
    //   434: aload 9
    //   436: ldc_w 2587
    //   439: aload_3
    //   440: getfield 2589	tencent/im/oidb/cmd0xe26/oidb_0xe26$EntranceTemplate:id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   443: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   446: invokevirtual 2592	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   449: pop
    //   450: iload 5
    //   452: istore 7
    //   454: iload 5
    //   456: istore 6
    //   458: aload 9
    //   460: ldc_w 2594
    //   463: new 173	java/lang/String
    //   466: dup
    //   467: aload_3
    //   468: getfield 2596	tencent/im/oidb/cmd0xe26/oidb_0xe26$EntranceTemplate:name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   471: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   474: invokevirtual 155	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   477: invokespecial 2599	java/lang/String:<init>	([B)V
    //   480: invokevirtual 2602	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   483: pop
    //   484: iload 5
    //   486: istore 7
    //   488: iload 5
    //   490: istore 6
    //   492: aload 9
    //   494: ldc_w 2604
    //   497: aload_3
    //   498: getfield 2606	tencent/im/oidb/cmd0xe26/oidb_0xe26$EntranceTemplate:state	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   501: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   504: invokevirtual 2592	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   507: pop
    //   508: iload 5
    //   510: istore 7
    //   512: iload 5
    //   514: istore 6
    //   516: aload 9
    //   518: ldc_w 2608
    //   521: new 173	java/lang/String
    //   524: dup
    //   525: aload_3
    //   526: getfield 2610	tencent/im/oidb/cmd0xe26/oidb_0xe26$EntranceTemplate:template_text	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   529: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   532: invokevirtual 155	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   535: invokespecial 2599	java/lang/String:<init>	([B)V
    //   538: invokevirtual 2602	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   541: pop
    //   542: iload 5
    //   544: istore 7
    //   546: iload 5
    //   548: istore 6
    //   550: aload 9
    //   552: ldc_w 2612
    //   555: aload_3
    //   556: getfield 2614	tencent/im/oidb/cmd0xe26/oidb_0xe26$EntranceTemplate:start_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   559: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   562: invokevirtual 2592	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   565: pop
    //   566: iload 5
    //   568: istore 7
    //   570: iload 5
    //   572: istore 6
    //   574: aload 9
    //   576: ldc_w 2616
    //   579: aload_3
    //   580: getfield 2618	tencent/im/oidb/cmd0xe26/oidb_0xe26$EntranceTemplate:end_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   583: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   586: invokevirtual 2592	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   589: pop
    //   590: iload 5
    //   592: istore 7
    //   594: iload 5
    //   596: istore 6
    //   598: aload 9
    //   600: ldc_w 1831
    //   603: aload_3
    //   604: getfield 2620	tencent/im/oidb/cmd0xe26/oidb_0xe26$EntranceTemplate:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   607: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   610: invokevirtual 2592	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   613: pop
    //   614: iload 5
    //   616: istore 7
    //   618: iload 5
    //   620: istore 6
    //   622: aload 9
    //   624: ldc_w 2622
    //   627: new 173	java/lang/String
    //   630: dup
    //   631: aload_3
    //   632: getfield 2624	tencent/im/oidb/cmd0xe26/oidb_0xe26$EntranceTemplate:bytes_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   635: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   638: invokevirtual 155	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   641: invokespecial 2599	java/lang/String:<init>	([B)V
    //   644: invokevirtual 2602	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   647: pop
    //   648: iload 5
    //   650: istore 7
    //   652: iload 5
    //   654: istore 6
    //   656: aload 9
    //   658: ldc_w 2626
    //   661: new 173	java/lang/String
    //   664: dup
    //   665: aload_3
    //   666: getfield 2628	tencent/im/oidb/cmd0xe26/oidb_0xe26$EntranceTemplate:bytes_icon_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   669: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   672: invokevirtual 155	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   675: invokespecial 2599	java/lang/String:<init>	([B)V
    //   678: invokevirtual 2602	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   681: pop
    //   682: iload 5
    //   684: istore 7
    //   686: iload 5
    //   688: istore 6
    //   690: aload 9
    //   692: ldc_w 2630
    //   695: new 173	java/lang/String
    //   698: dup
    //   699: aload_3
    //   700: getfield 2632	tencent/im/oidb/cmd0xe26/oidb_0xe26$EntranceTemplate:bytes_icon_custom_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   703: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   706: invokevirtual 155	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   709: invokespecial 2599	java/lang/String:<init>	([B)V
    //   712: invokevirtual 2602	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   715: pop
    //   716: iload 5
    //   718: istore 7
    //   720: iload 5
    //   722: istore 6
    //   724: aload 9
    //   726: ldc_w 2634
    //   729: aload_3
    //   730: getfield 2636	tencent/im/oidb/cmd0xe26/oidb_0xe26$EntranceTemplate:trace_info	Lcom/tencent/mobileqq/pb/PBStringField;
    //   733: invokevirtual 409	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   736: invokevirtual 2602	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   739: pop
    //   740: iload 5
    //   742: istore 7
    //   744: iload 5
    //   746: istore 6
    //   748: aload 9
    //   750: invokevirtual 2637	org/json/JSONObject:toString	()Ljava/lang/String;
    //   753: astore 9
    //   755: iload 5
    //   757: istore 7
    //   759: iload 5
    //   761: istore 6
    //   763: aload_1
    //   764: invokeinterface 259 1 0
    //   769: astore 10
    //   771: iload 5
    //   773: istore 7
    //   775: iload 5
    //   777: istore 6
    //   779: new 20	java/lang/StringBuilder
    //   782: dup
    //   783: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   786: astore 11
    //   788: iload 5
    //   790: istore 7
    //   792: iload 5
    //   794: istore 6
    //   796: aload 11
    //   798: aload_0
    //   799: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   802: invokevirtual 329	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   805: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   808: pop
    //   809: iload 5
    //   811: istore 7
    //   813: iload 5
    //   815: istore 6
    //   817: aload 11
    //   819: ldc_w 2639
    //   822: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   825: pop
    //   826: iload 5
    //   828: istore 7
    //   830: iload 5
    //   832: istore 6
    //   834: aload 11
    //   836: aload_3
    //   837: getfield 2606	tencent/im/oidb/cmd0xe26/oidb_0xe26$EntranceTemplate:state	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   840: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   843: invokevirtual 391	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   846: pop
    //   847: iload 5
    //   849: istore 7
    //   851: iload 5
    //   853: istore 6
    //   855: aload 11
    //   857: ldc_w 460
    //   860: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   863: pop
    //   864: iload 5
    //   866: istore 7
    //   868: iload 5
    //   870: istore 6
    //   872: aload 11
    //   874: aload_3
    //   875: getfield 2620	tencent/im/oidb/cmd0xe26/oidb_0xe26$EntranceTemplate:type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   878: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   881: invokevirtual 391	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   884: pop
    //   885: iload 5
    //   887: istore 7
    //   889: iload 5
    //   891: istore 6
    //   893: aload 10
    //   895: aload 11
    //   897: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   900: aload 9
    //   902: invokeinterface 2642 3 0
    //   907: pop
    //   908: iload 4
    //   910: iconst_1
    //   911: iadd
    //   912: istore 4
    //   914: goto -556 -> 358
    //   917: iload 5
    //   919: istore 7
    //   921: iload 5
    //   923: istore 6
    //   925: aload_1
    //   926: invokeinterface 259 1 0
    //   931: astore_1
    //   932: iload 5
    //   934: istore 7
    //   936: iload 5
    //   938: istore 6
    //   940: new 20	java/lang/StringBuilder
    //   943: dup
    //   944: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   947: astore_3
    //   948: iload 5
    //   950: istore 7
    //   952: iload 5
    //   954: istore 6
    //   956: aload_3
    //   957: aload_0
    //   958: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   961: invokevirtual 329	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   964: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   967: pop
    //   968: iload 5
    //   970: istore 7
    //   972: iload 5
    //   974: istore 6
    //   976: aload_3
    //   977: ldc_w 1687
    //   980: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   983: pop
    //   984: iload 5
    //   986: istore 7
    //   988: iload 5
    //   990: istore 6
    //   992: aload_1
    //   993: aload_3
    //   994: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   997: aload_2
    //   998: getfield 2645	tencent/im/oidb/cmd0xe26/oidb_0xe26$RspBody:refresh_second	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1001: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1004: i2l
    //   1005: invokeinterface 1713 4 0
    //   1010: invokeinterface 270 1 0
    //   1015: pop
    //   1016: iload 5
    //   1018: istore 8
    //   1020: goto +92 -> 1112
    //   1023: astore_1
    //   1024: goto +46 -> 1070
    //   1027: astore_1
    //   1028: iload 6
    //   1030: istore 7
    //   1032: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1035: ifeq +18 -> 1053
    //   1038: iload 6
    //   1040: istore 7
    //   1042: ldc_w 368
    //   1045: iconst_2
    //   1046: ldc_w 2647
    //   1049: aload_1
    //   1050: invokestatic 222	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1053: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1056: ifeq +100 -> 1156
    //   1059: new 20	java/lang/StringBuilder
    //   1062: dup
    //   1063: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   1066: astore_1
    //   1067: goto +63 -> 1130
    //   1070: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1073: ifeq +37 -> 1110
    //   1076: new 20	java/lang/StringBuilder
    //   1079: dup
    //   1080: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   1083: astore_2
    //   1084: aload_2
    //   1085: ldc_w 2649
    //   1088: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1091: pop
    //   1092: aload_2
    //   1093: iload 7
    //   1095: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1098: pop
    //   1099: ldc_w 368
    //   1102: iconst_2
    //   1103: aload_2
    //   1104: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1107: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1110: aload_1
    //   1111: athrow
    //   1112: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1115: ifeq +41 -> 1156
    //   1118: new 20	java/lang/StringBuilder
    //   1121: dup
    //   1122: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   1125: astore_1
    //   1126: iload 8
    //   1128: istore 6
    //   1130: aload_1
    //   1131: ldc_w 2649
    //   1134: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1137: pop
    //   1138: aload_1
    //   1139: iload 6
    //   1141: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1144: pop
    //   1145: ldc_w 368
    //   1148: iconst_2
    //   1149: aload_1
    //   1150: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1153: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1156: return
    //   1157: iconst_0
    //   1158: istore 5
    //   1160: goto -1015 -> 145
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1163	0	this	CardHandler
    //   0	1163	1	paramToServiceMsg	ToServiceMsg
    //   0	1163	2	paramFromServiceMsg	FromServiceMsg
    //   0	1163	3	paramObject	Object
    //   7	906	4	i	int
    //   4	1155	5	bool1	boolean
    //   82	1058	6	bool2	boolean
    //   78	1016	7	bool3	boolean
    //   69	1058	8	bool4	boolean
    //   424	477	9	localObject	Object
    //   769	125	10	localEditor	SharedPreferences.Editor
    //   786	110	11	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   84	92	1023	finally
    //   100	121	1023	finally
    //   129	139	1023	finally
    //   153	159	1023	finally
    //   167	175	1023	finally
    //   183	191	1023	finally
    //   199	206	1023	finally
    //   214	225	1023	finally
    //   246	256	1023	finally
    //   268	278	1023	finally
    //   286	294	1023	finally
    //   302	317	1023	finally
    //   325	335	1023	finally
    //   343	358	1023	finally
    //   366	383	1023	finally
    //   391	409	1023	finally
    //   417	426	1023	finally
    //   434	450	1023	finally
    //   458	484	1023	finally
    //   492	508	1023	finally
    //   516	542	1023	finally
    //   550	566	1023	finally
    //   574	590	1023	finally
    //   598	614	1023	finally
    //   622	648	1023	finally
    //   656	682	1023	finally
    //   690	716	1023	finally
    //   724	740	1023	finally
    //   748	755	1023	finally
    //   763	771	1023	finally
    //   779	788	1023	finally
    //   796	809	1023	finally
    //   817	826	1023	finally
    //   834	847	1023	finally
    //   855	864	1023	finally
    //   872	885	1023	finally
    //   893	908	1023	finally
    //   925	932	1023	finally
    //   940	948	1023	finally
    //   956	968	1023	finally
    //   976	984	1023	finally
    //   992	1016	1023	finally
    //   1032	1038	1023	finally
    //   1042	1053	1023	finally
    //   84	92	1027	java/lang/Exception
    //   100	121	1027	java/lang/Exception
    //   129	139	1027	java/lang/Exception
    //   153	159	1027	java/lang/Exception
    //   167	175	1027	java/lang/Exception
    //   183	191	1027	java/lang/Exception
    //   199	206	1027	java/lang/Exception
    //   214	225	1027	java/lang/Exception
    //   246	256	1027	java/lang/Exception
    //   268	278	1027	java/lang/Exception
    //   286	294	1027	java/lang/Exception
    //   302	317	1027	java/lang/Exception
    //   325	335	1027	java/lang/Exception
    //   343	358	1027	java/lang/Exception
    //   366	383	1027	java/lang/Exception
    //   391	409	1027	java/lang/Exception
    //   417	426	1027	java/lang/Exception
    //   434	450	1027	java/lang/Exception
    //   458	484	1027	java/lang/Exception
    //   492	508	1027	java/lang/Exception
    //   516	542	1027	java/lang/Exception
    //   550	566	1027	java/lang/Exception
    //   574	590	1027	java/lang/Exception
    //   598	614	1027	java/lang/Exception
    //   622	648	1027	java/lang/Exception
    //   656	682	1027	java/lang/Exception
    //   690	716	1027	java/lang/Exception
    //   724	740	1027	java/lang/Exception
    //   748	755	1027	java/lang/Exception
    //   763	771	1027	java/lang/Exception
    //   779	788	1027	java/lang/Exception
    //   796	809	1027	java/lang/Exception
    //   817	826	1027	java/lang/Exception
    //   834	847	1027	java/lang/Exception
    //   855	864	1027	java/lang/Exception
    //   872	885	1027	java/lang/Exception
    //   893	908	1027	java/lang/Exception
    //   925	932	1027	java/lang/Exception
    //   940	948	1027	java/lang/Exception
    //   956	968	1027	java/lang/Exception
    //   976	984	1027	java/lang/Exception
    //   992	1016	1027	java/lang/Exception
  }
  
  /* Error */
  private void x(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 101	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: ifeq +13 -> 17
    //   7: aload_3
    //   8: ifnull +9 -> 17
    //   11: iconst_1
    //   12: istore 9
    //   14: goto +6 -> 20
    //   17: iconst_0
    //   18: istore 9
    //   20: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   23: ifeq +37 -> 60
    //   26: new 20	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   33: astore_1
    //   34: aload_1
    //   35: ldc_w 2651
    //   38: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload_1
    //   43: iload 9
    //   45: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: ldc_w 368
    //   52: iconst_2
    //   53: aload_1
    //   54: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   60: iload 9
    //   62: ifeq +1331 -> 1393
    //   65: iload 9
    //   67: istore 10
    //   69: iload 9
    //   71: istore 11
    //   73: new 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   76: dup
    //   77: invokespecial 120	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   80: aload_3
    //   81: checkcast 122	[B
    //   84: checkcast 122	[B
    //   87: invokevirtual 126	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   90: checkcast 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   93: astore_1
    //   94: iload 9
    //   96: istore 10
    //   98: iload 9
    //   100: istore 11
    //   102: aload_1
    //   103: getfield 130	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   106: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   109: istore 4
    //   111: iload 4
    //   113: ifne +9 -> 122
    //   116: iconst_1
    //   117: istore 9
    //   119: goto +6 -> 125
    //   122: iconst_0
    //   123: istore 9
    //   125: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   128: istore 10
    //   130: iload 10
    //   132: ifeq +69 -> 201
    //   135: iload 9
    //   137: istore 10
    //   139: iload 9
    //   141: istore 11
    //   143: new 20	java/lang/StringBuilder
    //   146: dup
    //   147: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   150: astore_2
    //   151: iload 9
    //   153: istore 10
    //   155: iload 9
    //   157: istore 11
    //   159: aload_2
    //   160: ldc_w 2649
    //   163: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: pop
    //   167: iload 9
    //   169: istore 10
    //   171: iload 9
    //   173: istore 11
    //   175: aload_2
    //   176: iload 9
    //   178: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   181: pop
    //   182: iload 9
    //   184: istore 10
    //   186: iload 9
    //   188: istore 11
    //   190: ldc_w 368
    //   193: iconst_2
    //   194: aload_2
    //   195: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   198: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   201: iload 9
    //   203: ifeq +924 -> 1127
    //   206: aload_1
    //   207: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   210: invokevirtual 146	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   213: ifeq +914 -> 1127
    //   216: aload_1
    //   217: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   220: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   223: ifnull +904 -> 1127
    //   226: new 2653	tencent/im/oidb/cmd0x922/cmd0x922$RspBody
    //   229: dup
    //   230: invokespecial 2654	tencent/im/oidb/cmd0x922/cmd0x922$RspBody:<init>	()V
    //   233: astore 18
    //   235: aload 18
    //   237: aload_1
    //   238: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   241: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   244: invokevirtual 155	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   247: invokevirtual 2655	tencent/im/oidb/cmd0x922/cmd0x922$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   250: pop
    //   251: aload 18
    //   253: getfield 2658	tencent/im/oidb/cmd0x922/cmd0x922$RspBody:uint32_need_update_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   256: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   259: istore 4
    //   261: aload 18
    //   263: getfield 2661	tencent/im/oidb/cmd0x922/cmd0x922$RspBody:uint64_timestamp	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   266: invokevirtual 1130	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   269: lstore 13
    //   271: aload 18
    //   273: getfield 2664	tencent/im/oidb/cmd0x922/cmd0x922$RspBody:uint32_next_req_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   276: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   279: i2l
    //   280: lstore 15
    //   282: aload_0
    //   283: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   286: invokevirtual 1682	com/tencent/mobileqq/app/QQAppInterface:getPreferences	()Landroid/content/SharedPreferences;
    //   289: astore_2
    //   290: aload_2
    //   291: invokeinterface 259 1 0
    //   296: astore_1
    //   297: new 20	java/lang/StringBuilder
    //   300: dup
    //   301: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   304: astore_3
    //   305: aload_3
    //   306: aload_0
    //   307: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   310: invokevirtual 329	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   313: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   316: pop
    //   317: aload_3
    //   318: ldc_w 1810
    //   321: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: pop
    //   325: aload_1
    //   326: aload_3
    //   327: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   330: lload 15
    //   332: ldc2_w 1688
    //   335: lmul
    //   336: invokeinterface 1713 4 0
    //   341: invokeinterface 270 1 0
    //   346: pop
    //   347: aload 18
    //   349: getfield 2668	tencent/im/oidb/cmd0x922/cmd0x922$RspBody:msg_push_info	Ltencent/im/oidb/cmd0x922/cmd0x922$PushInfo;
    //   352: getfield 2671	tencent/im/oidb/cmd0x922/cmd0x922$PushInfo:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   355: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   358: istore 5
    //   360: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   363: istore 10
    //   365: iload 10
    //   367: ifeq +100 -> 467
    //   370: iload 9
    //   372: istore 10
    //   374: iload 9
    //   376: istore 11
    //   378: new 20	java/lang/StringBuilder
    //   381: dup
    //   382: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   385: astore_1
    //   386: iload 9
    //   388: istore 10
    //   390: iload 9
    //   392: istore 11
    //   394: aload_1
    //   395: ldc_w 2673
    //   398: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: pop
    //   402: iload 9
    //   404: istore 10
    //   406: iload 9
    //   408: istore 11
    //   410: aload_1
    //   411: iload 5
    //   413: invokevirtual 391	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   416: pop
    //   417: iload 9
    //   419: istore 10
    //   421: iload 9
    //   423: istore 11
    //   425: aload_1
    //   426: ldc_w 2675
    //   429: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: pop
    //   433: iload 9
    //   435: istore 10
    //   437: iload 9
    //   439: istore 11
    //   441: aload_1
    //   442: iload 4
    //   444: invokevirtual 391	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   447: pop
    //   448: iload 9
    //   450: istore 10
    //   452: iload 9
    //   454: istore 11
    //   456: ldc_w 368
    //   459: iconst_2
    //   460: aload_1
    //   461: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   464: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   467: iload 4
    //   469: iconst_1
    //   470: if_icmpne +450 -> 920
    //   473: aload 18
    //   475: getfield 2668	tencent/im/oidb/cmd0x922/cmd0x922$RspBody:msg_push_info	Ltencent/im/oidb/cmd0x922/cmd0x922$PushInfo;
    //   478: getfield 2671	tencent/im/oidb/cmd0x922/cmd0x922$PushInfo:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   481: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   484: istore 4
    //   486: aload 18
    //   488: getfield 2668	tencent/im/oidb/cmd0x922/cmd0x922$RspBody:msg_push_info	Ltencent/im/oidb/cmd0x922/cmd0x922$PushInfo;
    //   491: getfield 2678	tencent/im/oidb/cmd0x922/cmd0x922$PushInfo:uint32_red_point	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   494: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   497: istore 5
    //   499: aload 18
    //   501: getfield 2668	tencent/im/oidb/cmd0x922/cmd0x922$RspBody:msg_push_info	Ltencent/im/oidb/cmd0x922/cmd0x922$PushInfo;
    //   504: getfield 2681	tencent/im/oidb/cmd0x922/cmd0x922$PushInfo:uint32_day	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   507: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   510: istore 6
    //   512: new 173	java/lang/String
    //   515: dup
    //   516: aload 18
    //   518: getfield 2668	tencent/im/oidb/cmd0x922/cmd0x922$RspBody:msg_push_info	Ltencent/im/oidb/cmd0x922/cmd0x922$PushInfo;
    //   521: getfield 2684	tencent/im/oidb/cmd0x922/cmd0x922$PushInfo:bytes_prompt	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   524: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   527: invokevirtual 155	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   530: invokespecial 2599	java/lang/String:<init>	([B)V
    //   533: astore_1
    //   534: new 173	java/lang/String
    //   537: dup
    //   538: aload 18
    //   540: getfield 2668	tencent/im/oidb/cmd0x922/cmd0x922$RspBody:msg_push_info	Ltencent/im/oidb/cmd0x922/cmd0x922$PushInfo;
    //   543: getfield 2685	tencent/im/oidb/cmd0x922/cmd0x922$PushInfo:bytes_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   546: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   549: invokevirtual 155	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   552: invokespecial 2599	java/lang/String:<init>	([B)V
    //   555: astore_3
    //   556: new 173	java/lang/String
    //   559: dup
    //   560: aload 18
    //   562: getfield 2668	tencent/im/oidb/cmd0x922/cmd0x922$RspBody:msg_push_info	Ltencent/im/oidb/cmd0x922/cmd0x922$PushInfo;
    //   565: getfield 2686	tencent/im/oidb/cmd0x922/cmd0x922$PushInfo:bytes_icon_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   568: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   571: invokevirtual 155	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   574: invokespecial 2599	java/lang/String:<init>	([B)V
    //   577: astore 17
    //   579: aload 18
    //   581: getfield 2668	tencent/im/oidb/cmd0x922/cmd0x922$RspBody:msg_push_info	Ltencent/im/oidb/cmd0x922/cmd0x922$PushInfo;
    //   584: getfield 2689	tencent/im/oidb/cmd0x922/cmd0x922$PushInfo:uint32_lst_checkin_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   587: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   590: istore 7
    //   592: aload 18
    //   594: getfield 2668	tencent/im/oidb/cmd0x922/cmd0x922$RspBody:msg_push_info	Ltencent/im/oidb/cmd0x922/cmd0x922$PushInfo;
    //   597: getfield 2692	tencent/im/oidb/cmd0x922/cmd0x922$PushInfo:uint32_open_func	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   600: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   603: istore 8
    //   605: new 2584	org/json/JSONObject
    //   608: dup
    //   609: invokespecial 2585	org/json/JSONObject:<init>	()V
    //   612: astore 18
    //   614: aload 18
    //   616: ldc_w 1831
    //   619: iload 4
    //   621: invokevirtual 2592	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   624: pop
    //   625: aload 18
    //   627: ldc_w 2694
    //   630: iload 5
    //   632: invokevirtual 2592	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   635: pop
    //   636: aload 18
    //   638: ldc_w 2696
    //   641: iload 6
    //   643: invokevirtual 2592	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   646: pop
    //   647: aload 18
    //   649: ldc_w 2698
    //   652: aload_1
    //   653: invokevirtual 2602	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   656: pop
    //   657: aload 18
    //   659: ldc_w 2700
    //   662: aload_3
    //   663: invokevirtual 2602	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   666: pop
    //   667: aload 18
    //   669: ldc_w 2702
    //   672: aload 17
    //   674: invokevirtual 2602	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   677: pop
    //   678: aload 18
    //   680: ldc_w 2704
    //   683: iload 7
    //   685: invokevirtual 2592	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   688: pop
    //   689: aload 18
    //   691: ldc_w 2706
    //   694: iload 8
    //   696: invokevirtual 2592	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   699: pop
    //   700: aload 18
    //   702: invokevirtual 2637	org/json/JSONObject:toString	()Ljava/lang/String;
    //   705: astore 18
    //   707: aload_2
    //   708: invokeinterface 259 1 0
    //   713: astore_2
    //   714: new 20	java/lang/StringBuilder
    //   717: dup
    //   718: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   721: astore 19
    //   723: aload 19
    //   725: aload_0
    //   726: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   729: invokevirtual 329	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   732: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: pop
    //   736: aload 19
    //   738: ldc_w 2708
    //   741: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   744: pop
    //   745: aload_2
    //   746: aload 19
    //   748: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   751: aload 18
    //   753: invokeinterface 2642 3 0
    //   758: ldc_w 2710
    //   761: lload 13
    //   763: invokeinterface 1713 4 0
    //   768: invokeinterface 270 1 0
    //   773: pop
    //   774: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   777: ifeq +326 -> 1103
    //   780: new 20	java/lang/StringBuilder
    //   783: dup
    //   784: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   787: astore_2
    //   788: aload_2
    //   789: ldc_w 2712
    //   792: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   795: pop
    //   796: aload_2
    //   797: iload 4
    //   799: invokevirtual 391	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   802: pop
    //   803: aload_2
    //   804: ldc_w 2714
    //   807: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   810: pop
    //   811: aload_2
    //   812: iload 5
    //   814: invokevirtual 391	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   817: pop
    //   818: aload_2
    //   819: ldc_w 2716
    //   822: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   825: pop
    //   826: aload_2
    //   827: iload 6
    //   829: invokevirtual 391	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   832: pop
    //   833: aload_2
    //   834: ldc_w 2718
    //   837: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   840: pop
    //   841: aload_2
    //   842: aload_1
    //   843: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   846: pop
    //   847: aload_2
    //   848: ldc_w 2720
    //   851: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   854: pop
    //   855: aload_2
    //   856: aload_3
    //   857: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   860: pop
    //   861: aload_2
    //   862: ldc_w 2722
    //   865: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   868: pop
    //   869: aload_2
    //   870: aload 17
    //   872: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   875: pop
    //   876: aload_2
    //   877: ldc_w 2724
    //   880: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   883: pop
    //   884: aload_2
    //   885: iload 7
    //   887: invokevirtual 391	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   890: pop
    //   891: aload_2
    //   892: ldc_w 2726
    //   895: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   898: pop
    //   899: aload_2
    //   900: iload 8
    //   902: invokevirtual 391	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   905: pop
    //   906: ldc_w 2728
    //   909: iconst_2
    //   910: aload_2
    //   911: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   914: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   917: goto +186 -> 1103
    //   920: iload 4
    //   922: iconst_2
    //   923: if_icmpne +180 -> 1103
    //   926: new 20	java/lang/StringBuilder
    //   929: dup
    //   930: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   933: astore_1
    //   934: aload_1
    //   935: aload_0
    //   936: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   939: invokevirtual 329	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   942: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   945: pop
    //   946: aload_1
    //   947: ldc_w 2708
    //   950: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   953: pop
    //   954: aload_2
    //   955: aload_1
    //   956: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   959: ldc_w 460
    //   962: invokeinterface 2729 3 0
    //   967: astore_1
    //   968: aload_1
    //   969: invokestatic 762	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   972: ifeq +14 -> 986
    //   975: new 2584	org/json/JSONObject
    //   978: dup
    //   979: invokespecial 2585	org/json/JSONObject:<init>	()V
    //   982: astore_1
    //   983: goto +12 -> 995
    //   986: new 2584	org/json/JSONObject
    //   989: dup
    //   990: aload_1
    //   991: invokespecial 2730	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   994: astore_1
    //   995: aload_1
    //   996: ldc_w 2694
    //   999: iconst_0
    //   1000: invokevirtual 2592	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1003: pop
    //   1004: aload_1
    //   1005: ldc_w 2706
    //   1008: iconst_0
    //   1009: invokevirtual 2592	org/json/JSONObject:put	(Ljava/lang/String;I)Lorg/json/JSONObject;
    //   1012: pop
    //   1013: aload_1
    //   1014: invokevirtual 2637	org/json/JSONObject:toString	()Ljava/lang/String;
    //   1017: astore_1
    //   1018: aload_2
    //   1019: invokeinterface 259 1 0
    //   1024: astore_2
    //   1025: new 20	java/lang/StringBuilder
    //   1028: dup
    //   1029: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   1032: astore_3
    //   1033: aload_3
    //   1034: aload_0
    //   1035: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1038: invokevirtual 329	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   1041: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1044: pop
    //   1045: aload_3
    //   1046: aload_0
    //   1047: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1050: invokevirtual 329	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   1053: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1056: pop
    //   1057: aload_3
    //   1058: ldc_w 2708
    //   1061: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1064: pop
    //   1065: aload_2
    //   1066: aload_3
    //   1067: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1070: aload_1
    //   1071: invokeinterface 2642 3 0
    //   1076: ldc_w 2710
    //   1079: lload 13
    //   1081: invokeinterface 1713 4 0
    //   1086: invokeinterface 270 1 0
    //   1091: pop
    //   1092: goto +11 -> 1103
    //   1095: astore_1
    //   1096: goto +247 -> 1343
    //   1099: astore_1
    //   1100: goto +180 -> 1280
    //   1103: iload 9
    //   1105: istore 10
    //   1107: iload 9
    //   1109: istore 11
    //   1111: aload_0
    //   1112: bipush 82
    //   1114: iload 9
    //   1116: aconst_null
    //   1117: invokevirtual 228	com/tencent/mobileqq/app/CardHandler:notifyUI	(IZLjava/lang/Object;)V
    //   1120: iload 9
    //   1122: istore 12
    //   1124: goto +96 -> 1220
    //   1127: iload 9
    //   1129: istore 12
    //   1131: iload 9
    //   1133: istore 10
    //   1135: iload 9
    //   1137: istore 11
    //   1139: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1142: ifeq +78 -> 1220
    //   1145: iload 9
    //   1147: istore 10
    //   1149: iload 9
    //   1151: istore 11
    //   1153: new 20	java/lang/StringBuilder
    //   1156: dup
    //   1157: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   1160: astore_2
    //   1161: iload 9
    //   1163: istore 10
    //   1165: iload 9
    //   1167: istore 11
    //   1169: aload_2
    //   1170: ldc_w 2732
    //   1173: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1176: pop
    //   1177: iload 9
    //   1179: istore 10
    //   1181: iload 9
    //   1183: istore 11
    //   1185: aload_2
    //   1186: aload_1
    //   1187: getfield 130	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   1190: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   1193: invokevirtual 391	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1196: pop
    //   1197: iload 9
    //   1199: istore 10
    //   1201: iload 9
    //   1203: istore 11
    //   1205: ldc_w 2728
    //   1208: iconst_2
    //   1209: aload_2
    //   1210: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1213: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1216: iload 9
    //   1218: istore 12
    //   1220: iload 12
    //   1222: istore 9
    //   1224: ldc_w 2649
    //   1227: astore_1
    //   1228: ldc_w 368
    //   1231: astore_2
    //   1232: goto +169 -> 1401
    //   1235: astore_1
    //   1236: iload 10
    //   1238: istore 9
    //   1240: goto +103 -> 1343
    //   1243: astore_1
    //   1244: iload 11
    //   1246: istore 9
    //   1248: goto +32 -> 1280
    //   1251: astore_1
    //   1252: goto +12 -> 1264
    //   1255: astore_1
    //   1256: goto +24 -> 1280
    //   1259: astore_1
    //   1260: iload 10
    //   1262: istore 9
    //   1264: ldc_w 368
    //   1267: astore_3
    //   1268: ldc_w 2649
    //   1271: astore_2
    //   1272: goto +79 -> 1351
    //   1275: astore_1
    //   1276: iload 11
    //   1278: istore 9
    //   1280: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1283: istore 10
    //   1285: iload 10
    //   1287: ifeq +30 -> 1317
    //   1290: ldc_w 368
    //   1293: astore_3
    //   1294: aload_3
    //   1295: iconst_2
    //   1296: ldc_w 2647
    //   1299: aload_1
    //   1300: invokestatic 222	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   1303: goto +14 -> 1317
    //   1306: astore_1
    //   1307: goto +3 -> 1310
    //   1310: ldc_w 2649
    //   1313: astore_2
    //   1314: goto +37 -> 1351
    //   1317: ldc_w 368
    //   1320: astore_3
    //   1321: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1324: ifeq +121 -> 1445
    //   1327: new 20	java/lang/StringBuilder
    //   1330: dup
    //   1331: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   1334: astore_1
    //   1335: ldc_w 2649
    //   1338: astore_2
    //   1339: goto +84 -> 1423
    //   1342: astore_1
    //   1343: ldc_w 2649
    //   1346: astore_2
    //   1347: ldc_w 368
    //   1350: astore_3
    //   1351: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1354: ifeq +37 -> 1391
    //   1357: new 20	java/lang/StringBuilder
    //   1360: dup
    //   1361: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   1364: astore 17
    //   1366: aload 17
    //   1368: aload_2
    //   1369: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1372: pop
    //   1373: aload 17
    //   1375: iload 9
    //   1377: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1380: pop
    //   1381: aload_3
    //   1382: iconst_2
    //   1383: aload 17
    //   1385: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1388: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1391: aload_1
    //   1392: athrow
    //   1393: ldc_w 368
    //   1396: astore_2
    //   1397: ldc_w 2649
    //   1400: astore_1
    //   1401: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1404: ifeq +41 -> 1445
    //   1407: new 20	java/lang/StringBuilder
    //   1410: dup
    //   1411: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   1414: astore 17
    //   1416: aload_2
    //   1417: astore_3
    //   1418: aload_1
    //   1419: astore_2
    //   1420: aload 17
    //   1422: astore_1
    //   1423: aload_1
    //   1424: aload_2
    //   1425: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1428: pop
    //   1429: aload_1
    //   1430: iload 9
    //   1432: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1435: pop
    //   1436: aload_3
    //   1437: iconst_2
    //   1438: aload_1
    //   1439: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1442: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1445: return
    //   1446: astore_1
    //   1447: goto -104 -> 1343
    //   1450: astore_1
    //   1451: goto -171 -> 1280
    //   1454: astore_1
    //   1455: ldc_w 368
    //   1458: astore_1
    //   1459: goto -149 -> 1310
    //   1462: astore_1
    //   1463: goto -183 -> 1280
    //   1466: astore_1
    //   1467: goto -203 -> 1264
    //   1470: astore_1
    //   1471: goto -191 -> 1280
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1474	0	this	CardHandler
    //   0	1474	1	paramToServiceMsg	ToServiceMsg
    //   0	1474	2	paramFromServiceMsg	FromServiceMsg
    //   0	1474	3	paramObject	Object
    //   109	815	4	i	int
    //   358	455	5	j	int
    //   510	318	6	k	int
    //   590	296	7	m	int
    //   603	298	8	n	int
    //   12	1419	9	bool1	boolean
    //   67	1219	10	bool2	boolean
    //   71	1206	11	bool3	boolean
    //   1122	99	12	bool4	boolean
    //   269	811	13	l1	long
    //   280	51	15	l2	long
    //   577	844	17	localObject1	Object
    //   233	519	18	localObject2	Object
    //   721	26	19	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   534	917	1095	finally
    //   926	983	1095	finally
    //   986	995	1095	finally
    //   995	1092	1095	finally
    //   534	917	1099	java/lang/Exception
    //   926	983	1099	java/lang/Exception
    //   986	995	1099	java/lang/Exception
    //   995	1092	1099	java/lang/Exception
    //   1111	1120	1235	finally
    //   1139	1145	1235	finally
    //   1153	1161	1235	finally
    //   1169	1177	1235	finally
    //   1185	1197	1235	finally
    //   1205	1216	1235	finally
    //   1111	1120	1243	java/lang/Exception
    //   1139	1145	1243	java/lang/Exception
    //   1153	1161	1243	java/lang/Exception
    //   1169	1177	1243	java/lang/Exception
    //   1185	1197	1243	java/lang/Exception
    //   1205	1216	1243	java/lang/Exception
    //   125	130	1251	finally
    //   206	365	1251	finally
    //   125	130	1255	java/lang/Exception
    //   206	365	1255	java/lang/Exception
    //   73	94	1259	finally
    //   102	111	1259	finally
    //   143	151	1259	finally
    //   159	167	1259	finally
    //   175	182	1259	finally
    //   190	201	1259	finally
    //   378	386	1259	finally
    //   394	402	1259	finally
    //   410	417	1259	finally
    //   425	433	1259	finally
    //   441	448	1259	finally
    //   456	467	1259	finally
    //   73	94	1275	java/lang/Exception
    //   102	111	1275	java/lang/Exception
    //   143	151	1275	java/lang/Exception
    //   159	167	1275	java/lang/Exception
    //   175	182	1275	java/lang/Exception
    //   190	201	1275	java/lang/Exception
    //   378	386	1275	java/lang/Exception
    //   394	402	1275	java/lang/Exception
    //   410	417	1275	java/lang/Exception
    //   425	433	1275	java/lang/Exception
    //   441	448	1275	java/lang/Exception
    //   456	467	1275	java/lang/Exception
    //   1294	1303	1306	finally
    //   1280	1285	1342	finally
    //   512	534	1446	finally
    //   512	534	1450	java/lang/Exception
    //   473	512	1466	finally
    //   473	512	1470	java/lang/Exception
  }
  
  /* Error */
  private void y(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   4: ldc_w 2734
    //   7: invokevirtual 541	android/os/Bundle:getShort	(Ljava/lang/String;)S
    //   10: istore 4
    //   12: aload_1
    //   13: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   16: ldc_w 2736
    //   19: invokevirtual 541	android/os/Bundle:getShort	(Ljava/lang/String;)S
    //   22: istore 5
    //   24: iconst_m1
    //   25: istore 7
    //   27: iload 7
    //   29: istore 8
    //   31: iload 7
    //   33: istore 9
    //   35: iload 7
    //   37: istore 6
    //   39: aload_2
    //   40: invokevirtual 101	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   43: ifeq +261 -> 304
    //   46: iload 7
    //   48: istore 8
    //   50: aload_3
    //   51: ifnull +253 -> 304
    //   54: iload 7
    //   56: istore 9
    //   58: iload 7
    //   60: istore 6
    //   62: new 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   65: dup
    //   66: invokespecial 120	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   69: aload_3
    //   70: checkcast 122	[B
    //   73: checkcast 122	[B
    //   76: invokevirtual 126	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   79: checkcast 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   82: astore_1
    //   83: iload 7
    //   85: istore 9
    //   87: iload 7
    //   89: istore 6
    //   91: aload_1
    //   92: getfield 130	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   95: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   98: istore 7
    //   100: iload 7
    //   102: istore 8
    //   104: iload 7
    //   106: ifne +198 -> 304
    //   109: iload 7
    //   111: istore 8
    //   113: iload 7
    //   115: istore 9
    //   117: iload 7
    //   119: istore 6
    //   121: aload_1
    //   122: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   125: invokevirtual 146	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   128: ifeq +176 -> 304
    //   131: iload 7
    //   133: istore 8
    //   135: iload 7
    //   137: istore 9
    //   139: iload 7
    //   141: istore 6
    //   143: aload_1
    //   144: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   147: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   150: ifnull +154 -> 304
    //   153: iload 7
    //   155: istore 9
    //   157: iload 7
    //   159: istore 6
    //   161: aload_1
    //   162: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   165: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   168: invokevirtual 155	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   171: invokestatic 161	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   174: invokevirtual 164	java/nio/ByteBuffer:getInt	()I
    //   177: istore 10
    //   179: iload 10
    //   181: ifge +456 -> 637
    //   184: iload 10
    //   186: i2l
    //   187: ldc2_w 165
    //   190: ladd
    //   191: lstore 11
    //   193: goto +3 -> 196
    //   196: iload 7
    //   198: istore 9
    //   200: iload 7
    //   202: istore 6
    //   204: lload 11
    //   206: invokestatic 176	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   209: aload_0
    //   210: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   213: invokevirtual 171	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   216: invokevirtual 179	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   219: ifeq +9 -> 228
    //   222: iconst_1
    //   223: istore 13
    //   225: goto +86 -> 311
    //   228: iload 7
    //   230: istore 8
    //   232: iload 7
    //   234: istore 9
    //   236: iload 7
    //   238: istore 6
    //   240: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   243: ifeq +61 -> 304
    //   246: iload 7
    //   248: istore 9
    //   250: iload 7
    //   252: istore 6
    //   254: ldc_w 2738
    //   257: iconst_2
    //   258: invokestatic 584	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   261: ldc_w 2740
    //   264: iconst_3
    //   265: anewarray 393	java/lang/Object
    //   268: dup
    //   269: iconst_0
    //   270: iload 10
    //   272: invokestatic 87	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   275: aastore
    //   276: dup
    //   277: iconst_1
    //   278: lload 11
    //   280: invokestatic 906	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   283: aastore
    //   284: dup
    //   285: iconst_2
    //   286: aload_0
    //   287: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   290: invokevirtual 171	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   293: aastore
    //   294: invokestatic 590	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   297: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   300: iload 7
    //   302: istore 8
    //   304: iconst_0
    //   305: istore 13
    //   307: iload 8
    //   309: istore 7
    //   311: iload 13
    //   313: istore 14
    //   315: iload 7
    //   317: istore 6
    //   319: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   322: ifeq +156 -> 478
    //   325: ldc_w 2738
    //   328: iconst_2
    //   329: invokestatic 584	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   332: ldc_w 2742
    //   335: iconst_4
    //   336: anewarray 393	java/lang/Object
    //   339: dup
    //   340: iconst_0
    //   341: iload 13
    //   343: invokestatic 365	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   346: aastore
    //   347: dup
    //   348: iconst_1
    //   349: iload 7
    //   351: invokestatic 87	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   354: aastore
    //   355: dup
    //   356: iconst_2
    //   357: iload 4
    //   359: invokestatic 1801	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   362: aastore
    //   363: dup
    //   364: iconst_3
    //   365: iload 5
    //   367: invokestatic 1801	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   370: aastore
    //   371: invokestatic 590	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   374: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   377: iload 13
    //   379: istore 14
    //   381: iload 7
    //   383: istore 6
    //   385: goto +93 -> 478
    //   388: astore_1
    //   389: goto +189 -> 578
    //   392: astore_1
    //   393: iload 6
    //   395: istore 9
    //   397: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   400: ifeq +18 -> 418
    //   403: iload 6
    //   405: istore 9
    //   407: ldc_w 2738
    //   410: iconst_2
    //   411: ldc_w 2744
    //   414: aload_1
    //   415: invokestatic 222	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   418: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   421: ifeq +54 -> 475
    //   424: ldc_w 2738
    //   427: iconst_2
    //   428: invokestatic 584	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   431: ldc_w 2742
    //   434: iconst_4
    //   435: anewarray 393	java/lang/Object
    //   438: dup
    //   439: iconst_0
    //   440: iconst_0
    //   441: invokestatic 365	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   444: aastore
    //   445: dup
    //   446: iconst_1
    //   447: iload 6
    //   449: invokestatic 87	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   452: aastore
    //   453: dup
    //   454: iconst_2
    //   455: iload 4
    //   457: invokestatic 1801	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   460: aastore
    //   461: dup
    //   462: iconst_3
    //   463: iload 5
    //   465: invokestatic 1801	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   468: aastore
    //   469: invokestatic 590	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   472: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   475: iconst_0
    //   476: istore 14
    //   478: iload 4
    //   480: sipush -23204
    //   483: if_icmpne +66 -> 549
    //   486: aload_0
    //   487: getfield 77	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   490: getstatic 380	com/tencent/mobileqq/app/QQManagerFactory:CTENTRY_MNG	I
    //   493: invokevirtual 383	com/tencent/common/app/AppInterface:getManager	(I)Lmqq/manager/Manager;
    //   496: checkcast 385	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng
    //   499: iload 5
    //   501: invokevirtual 388	com/tencent/mobileqq/activity/contacts/topentry/CTEntryMng:b	(I)V
    //   504: aload_0
    //   505: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   508: getstatic 2747	com/tencent/mobileqq/app/QQManagerFactory:MAYKNOW_RECOMMEND_MANAGER	I
    //   511: invokevirtual 189	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   514: checkcast 2749	com/tencent/mobileqq/app/MayknowRecommendManager
    //   517: invokevirtual 2751	com/tencent/mobileqq/app/MayknowRecommendManager:b	()V
    //   520: aload_0
    //   521: bipush 109
    //   523: iload 14
    //   525: iconst_2
    //   526: anewarray 393	java/lang/Object
    //   529: dup
    //   530: iconst_0
    //   531: iload 6
    //   533: invokestatic 87	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   536: aastore
    //   537: dup
    //   538: iconst_1
    //   539: iload 5
    //   541: invokestatic 87	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   544: aastore
    //   545: invokevirtual 228	com/tencent/mobileqq/app/CardHandler:notifyUI	(IZLjava/lang/Object;)V
    //   548: return
    //   549: aload_0
    //   550: bipush 84
    //   552: iload 14
    //   554: iconst_2
    //   555: anewarray 393	java/lang/Object
    //   558: dup
    //   559: iconst_0
    //   560: iload 4
    //   562: invokestatic 1801	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   565: aastore
    //   566: dup
    //   567: iconst_1
    //   568: iload 5
    //   570: invokestatic 1801	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   573: aastore
    //   574: invokevirtual 228	com/tencent/mobileqq/app/CardHandler:notifyUI	(IZLjava/lang/Object;)V
    //   577: return
    //   578: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   581: ifeq +54 -> 635
    //   584: ldc_w 2738
    //   587: iconst_2
    //   588: invokestatic 584	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   591: ldc_w 2742
    //   594: iconst_4
    //   595: anewarray 393	java/lang/Object
    //   598: dup
    //   599: iconst_0
    //   600: iconst_0
    //   601: invokestatic 365	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   604: aastore
    //   605: dup
    //   606: iconst_1
    //   607: iload 9
    //   609: invokestatic 87	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   612: aastore
    //   613: dup
    //   614: iconst_2
    //   615: iload 4
    //   617: invokestatic 1801	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   620: aastore
    //   621: dup
    //   622: iconst_3
    //   623: iload 5
    //   625: invokestatic 1801	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   628: aastore
    //   629: invokestatic 590	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   632: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   635: aload_1
    //   636: athrow
    //   637: iload 10
    //   639: i2l
    //   640: lstore 11
    //   642: goto -446 -> 196
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	645	0	this	CardHandler
    //   0	645	1	paramToServiceMsg	ToServiceMsg
    //   0	645	2	paramFromServiceMsg	FromServiceMsg
    //   0	645	3	paramObject	Object
    //   10	606	4	s1	short
    //   22	602	5	s2	short
    //   37	495	6	i	int
    //   25	357	7	j	int
    //   29	279	8	k	int
    //   33	575	9	m	int
    //   177	461	10	n	int
    //   191	450	11	l	long
    //   223	155	13	bool1	boolean
    //   313	240	14	bool2	boolean
    // Exception table:
    //   from	to	target	type
    //   39	46	388	finally
    //   62	83	388	finally
    //   91	100	388	finally
    //   121	131	388	finally
    //   143	153	388	finally
    //   161	179	388	finally
    //   204	222	388	finally
    //   240	246	388	finally
    //   254	300	388	finally
    //   397	403	388	finally
    //   407	418	388	finally
    //   39	46	392	java/lang/Exception
    //   62	83	392	java/lang/Exception
    //   91	100	392	java/lang/Exception
    //   121	131	392	java/lang/Exception
    //   143	153	392	java/lang/Exception
    //   161	179	392	java/lang/Exception
    //   204	222	392	java/lang/Exception
    //   240	246	392	java/lang/Exception
    //   254	300	392	java/lang/Exception
  }
  
  private void z(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("handleGetNotifyOnLikeRankingList success=");
      paramToServiceMsg.append(bool);
      QLog.d("CardHandler", 2, paramToServiceMsg.toString());
    }
    b((byte[])paramObject, bool, true);
  }
  
  public CardHandler.CardTransProcessorHandler a(QQAppInterface paramQQAppInterface, CardHandler.CoverTransCallback paramCoverTransCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, String.format("addCoverTransCallback app=%s callBack=%s", new Object[] { paramQQAppInterface, paramCoverTransCallback }));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileApiITransFileController == null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileApiITransFileController = ((ITransFileController)paramQQAppInterface.getRuntimeService(ITransFileController.class));
    }
    paramQQAppInterface = new CardHandler.CardTransProcessorHandler(paramCoverTransCallback);
    paramQQAppInterface.addFilter(new Class[] { NearbyPeoplePhotoUploadProcessor.class });
    this.jdField_a_of_type_ComTencentMobileqqTransfileApiITransFileController.addHandle(paramQQAppInterface);
    return paramQQAppInterface;
  }
  
  /* Error */
  public ArrayList<CardProfile> a(int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 1768	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   7: invokevirtual 1774	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   10: astore 4
    //   12: iconst_0
    //   13: istore_3
    //   14: aload 4
    //   16: ldc_w 1286
    //   19: iconst_1
    //   20: ldc_w 2779
    //   23: iconst_1
    //   24: anewarray 173	java/lang/String
    //   27: dup
    //   28: iconst_0
    //   29: iload_1
    //   30: invokestatic 1599	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   33: aastore
    //   34: aconst_null
    //   35: aconst_null
    //   36: ldc_w 2781
    //   39: iload_2
    //   40: invokestatic 1599	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   43: invokevirtual 2785	com/tencent/mobileqq/persistence/EntityManager:query	(Ljava/lang/Class;ZLjava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   46: checkcast 60	java/util/ArrayList
    //   49: astore 5
    //   51: aload 4
    //   53: invokevirtual 2505	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   56: iload_3
    //   57: istore_1
    //   58: aload 5
    //   60: astore 4
    //   62: aload 5
    //   64: ifnonnull +47 -> 111
    //   67: new 60	java/util/ArrayList
    //   70: dup
    //   71: iconst_0
    //   72: invokespecial 920	java/util/ArrayList:<init>	(I)V
    //   75: astore 4
    //   77: iload_3
    //   78: istore_1
    //   79: goto +32 -> 111
    //   82: astore 5
    //   84: goto +68 -> 152
    //   87: astore 5
    //   89: aload 5
    //   91: invokevirtual 775	java/lang/Exception:printStackTrace	()V
    //   94: aload 4
    //   96: invokevirtual 2505	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   99: new 60	java/util/ArrayList
    //   102: dup
    //   103: iconst_0
    //   104: invokespecial 920	java/util/ArrayList:<init>	(I)V
    //   107: astore 4
    //   109: iload_3
    //   110: istore_1
    //   111: iload_1
    //   112: aload 4
    //   114: invokevirtual 607	java/util/ArrayList:size	()I
    //   117: if_icmpge +32 -> 149
    //   120: aload 4
    //   122: iload_1
    //   123: invokevirtual 1600	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   126: checkcast 1286	com/tencent/mobileqq/data/CardProfile
    //   129: astore 5
    //   131: aload 5
    //   133: aload 5
    //   135: getfield 2788	com/tencent/mobileqq/data/CardProfile:lTime	I
    //   138: i2l
    //   139: invokevirtual 2792	com/tencent/mobileqq/data/CardProfile:updateTime	(J)V
    //   142: iload_1
    //   143: iconst_1
    //   144: iadd
    //   145: istore_1
    //   146: goto -35 -> 111
    //   149: aload 4
    //   151: areturn
    //   152: aload 4
    //   154: invokevirtual 2505	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   157: new 60	java/util/ArrayList
    //   160: dup
    //   161: iconst_0
    //   162: invokespecial 920	java/util/ArrayList:<init>	(I)V
    //   165: pop
    //   166: goto +6 -> 172
    //   169: aload 5
    //   171: athrow
    //   172: goto -3 -> 169
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	175	0	this	CardHandler
    //   0	175	1	paramInt1	int
    //   0	175	2	paramInt2	int
    //   13	97	3	i	int
    //   10	143	4	localObject1	Object
    //   49	14	5	localArrayList	ArrayList
    //   82	1	5	localObject2	Object
    //   87	3	5	localException	Exception
    //   129	41	5	localCardProfile	CardProfile
    // Exception table:
    //   from	to	target	type
    //   14	51	82	finally
    //   89	94	82	finally
    //   14	51	87	java/lang/Exception
  }
  
  public void a()
  {
    send(createToServiceMsg("MCardSvc.ReqGetCardSwitch"));
  }
  
  /* Error */
  public void a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: invokevirtual 1768	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   7: invokevirtual 1774	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   10: astore_2
    //   11: aload_2
    //   12: invokevirtual 2805	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   15: invokevirtual 2810	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   18: new 20	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   25: astore_3
    //   26: aload_3
    //   27: ldc_w 2812
    //   30: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   33: pop
    //   34: aload_3
    //   35: ldc_w 1286
    //   38: invokevirtual 2815	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   41: checkcast 1286	com/tencent/mobileqq/data/CardProfile
    //   44: invokevirtual 2818	com/tencent/mobileqq/data/CardProfile:getTableName	()Ljava/lang/String;
    //   47: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload_3
    //   52: ldc_w 2820
    //   55: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload_3
    //   60: ldc_w 2822
    //   63: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload_3
    //   68: iload_1
    //   69: invokevirtual 391	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload_3
    //   74: ldc_w 2824
    //   77: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   80: pop
    //   81: aload_2
    //   82: aload_3
    //   83: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   86: invokevirtual 2827	com/tencent/mobileqq/persistence/EntityManager:execSQL	(Ljava/lang/String;)Z
    //   89: pop
    //   90: aload_2
    //   91: invokevirtual 2805	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   94: invokevirtual 2829	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   97: goto +26 -> 123
    //   100: astore_3
    //   101: goto +34 -> 135
    //   104: astore_3
    //   105: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   108: ifeq +15 -> 123
    //   111: ldc_w 368
    //   114: iconst_2
    //   115: aload_3
    //   116: invokevirtual 780	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   119: aload_3
    //   120: invokestatic 2831	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   123: aload_2
    //   124: invokevirtual 2805	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   127: invokevirtual 2834	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   130: aload_2
    //   131: invokevirtual 2505	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   134: return
    //   135: aload_2
    //   136: invokevirtual 2805	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   139: invokevirtual 2834	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   142: aload_2
    //   143: invokevirtual 2505	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   146: aload_3
    //   147: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	148	0	this	CardHandler
    //   0	148	1	paramInt	int
    //   10	133	2	localEntityManager	EntityManager
    //   25	58	3	localStringBuilder	StringBuilder
    //   100	1	3	localObject	Object
    //   104	43	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   18	97	100	finally
    //   105	123	100	finally
    //   18	97	104	java/lang/Exception
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("sendNotDisturbTime time=");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(" lastTime=");
      ((StringBuilder)localObject1).append(paramString1);
      ((StringBuilder)localObject1).append(" source_from");
      ((StringBuilder)localObject1).append(paramString2);
      QLog.d("Q.profilecard.", 2, ((StringBuilder)localObject1).toString());
    }
    try
    {
      localObject1 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1279);
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(9);
      Object localObject2 = ByteBuffer.allocate(15);
      ((ByteBuffer)localObject2).putInt(Utils.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))).put((byte)0).putShort((short)1).putShort((short)27240).putShort((short)4).putInt(paramInt);
      ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject2).array()));
      localObject2 = createToServiceMsg("OidbSvc.0x4ff_9");
      ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
      ((ToServiceMsg)localObject2).setTimeout(30000L);
      ((ToServiceMsg)localObject2).extraData.putInt("no_disturb_time", paramInt);
      ((ToServiceMsg)localObject2).extraData.putString("no_disturb_last_time", paramString1);
      ((ToServiceMsg)localObject2).extraData.putString("source_from", paramString2);
      ((ToServiceMsg)localObject2).extraData.putBoolean("from_send_no_disturb", true);
      ((ToServiceMsg)localObject2).extraData.putBoolean("reqFromCardHandler", true);
      sendPbReq((ToServiceMsg)localObject2);
      return;
    }
    catch (Exception paramString1)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "sendNotDisturbTime ex", paramString1);
      }
    }
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getEducationList ");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("CardHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new oidb_cmd0xd2d.ReqBody();
    ((oidb_cmd0xd2d.ReqBody)localObject).uint64_req_uin.set(paramLong);
    ((oidb_cmd0xd2d.ReqBody)localObject).uint32_req_category.set(0);
    localObject = makeOIDBPkg("OidbSvc.0xd2d", 3373, 1, ((oidb_cmd0xd2d.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).addAttribute("uin", Long.valueOf(paramLong));
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", String.valueOf(paramLong1), "MCardSvc.ReqPicSafetyCheck");
    localToServiceMsg.extraData.putLong("selfUin", paramLong1);
    localToServiceMsg.extraData.putLong("lToUIN", paramLong2);
    localToServiceMsg.extraData.putLong("friendUin", paramLong2);
    localToServiceMsg.extraData.putInt("iScene", paramInt);
    send(localToServiceMsg);
  }
  
  public void a(long paramLong1, long paramLong2, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.profilecard.", 4, String.format("reqFavorite|%d|%d|likeSource=%d", new Object[] { Long.valueOf(paramLong2), Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) }));
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", String.valueOf(paramLong1), "VisitorSvc.ReqFavorite");
    localToServiceMsg.extraData.putLong("selfUin", paramLong1);
    localToServiceMsg.extraData.putLong("targetUin", paramLong2);
    localToServiceMsg.extraData.putByteArray("vCookies", paramArrayOfByte);
    localToServiceMsg.extraData.putInt("favoriteSource", paramInt1);
    localToServiceMsg.extraData.putInt("iCount", paramInt2);
    localToServiceMsg.extraData.putInt("from", paramInt3);
    send(localToServiceMsg);
  }
  
  public void a(PushVoteIncreaseInfo paramPushVoteIncreaseInfo, String paramString1, String paramString2)
  {
    Visitor localVisitor = (Visitor)paramPushVoteIncreaseInfo.vVoterList.get(0);
    MessageRecord localMessageRecord = MessageRecordFactory.a(-1000);
    localMessageRecord.frienduin = AppConstants.VOTE_MSG_UIN;
    localMessageRecord.istroop = 0;
    localMessageRecord.senderuin = String.valueOf(localVisitor.lUIN);
    localMessageRecord.extraflag = paramPushVoteIncreaseInfo.iIncrement;
    localMessageRecord.time = (System.currentTimeMillis() / 1000L);
    int i = paramPushVoteIncreaseInfo.iIncrement;
    Object localObject1 = paramPushVoteIncreaseInfo.vVoterList;
    ThreadManager.post(new CardHandler.1(this, i), 8, null, false);
    try
    {
      localObject1 = new String(localVisitor.vecNick, "UTF8");
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      label118:
      Object localObject2;
      break label118;
    }
    if (QLog.isColorLevel()) {
      QLog.w("accost", 2, "last voter's name. unsupported encoding.");
    }
    localObject1 = "";
    localObject2 = localObject1;
    if (((String)localObject1).trim().length() == 0) {
      localObject2 = String.valueOf(localVisitor.lUIN);
    }
    if (1 == paramPushVoteIncreaseInfo.iIncrement) {
      localMessageRecord.msg = String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getString(2131692622), new Object[] { localObject2 });
    } else {
      localMessageRecord.msg = String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getString(2131692621), new Object[] { localObject2, Integer.valueOf(paramPushVoteIncreaseInfo.iIncrement) });
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(localMessageRecord, paramString1);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.handleReceivedMessage(1, true, true);
    localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("newVoteCount", paramPushVoteIncreaseInfo.iIncrement);
    ((Bundle)localObject1).putString("sender", paramString2);
    ((Bundle)localObject1).putString("voteeUin", paramString1);
    ((Bundle)localObject1).putString("uin", paramString1);
    notifyUI(28, true, new Object[] { ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), localObject1 });
  }
  
  public void a(Bundle paramBundle)
  {
    IProfileProtocolService localIProfileProtocolService = (IProfileProtocolService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IProfileProtocolService.class, "all");
    if (localIProfileProtocolService != null) {
      localIProfileProtocolService.setProfileDetail(paramBundle);
    }
  }
  
  public void a(CardHandler.CardTransProcessorHandler paramCardTransProcessorHandler)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, String.format("removeCoverTransCallback transHandler=%s", new Object[] { paramCardTransProcessorHandler }));
    }
    ITransFileController localITransFileController = this.jdField_a_of_type_ComTencentMobileqqTransfileApiITransFileController;
    if (localITransFileController != null) {
      localITransFileController.removeHandle(paramCardTransProcessorHandler);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new Oidb_0x66b.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleGetSimpleNearbyMyTab, result=");
      paramFromServiceMsg.append(i);
      QLog.d("NewNearbyMyTab", 2, paramFromServiceMsg.toString());
    }
    if (i == 0)
    {
      if (paramToServiceMsg.stPansocialInfo.has())
      {
        i = ((Oidb_0x66b.RspPansocialInfo)paramToServiceMsg.stPansocialInfo.get()).uint32_charmlevel.get();
        ((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).a(i);
      }
    }
    else {
      notifyUI(65, false, null);
    }
  }
  
  public void a(String paramString)
  {
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mLocalPath = paramString;
    localTransferRequest.mIsUp = true;
    localTransferRequest.mPeerUin = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
    localTransferRequest.mUniseq = 0L;
    localTransferRequest.mFileType = 35;
    localTransferRequest.mRichTag = "actProfileCoverPicUpload";
    paramString = this.jdField_a_of_type_ComTencentMobileqqTransfileApiITransFileController;
    if (paramString != null) {
      paramString.transferAsync(localTransferRequest);
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qzonecover.", 2, "getQzoneCover");
    }
    ToServiceMsg localToServiceMsg = createToServiceMsg("SQQzoneSvc.getCover");
    localToServiceMsg.addAttribute("uin", paramString);
    localToServiceMsg.addAttribute("flag", Integer.valueOf(paramInt));
    send(localToServiceMsg);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    oidb_0x7ba.ReqBody localReqBody = new oidb_0x7ba.ReqBody();
    localReqBody.uint64_uin.set(Long.parseLong(paramString));
    localReqBody.uint32_start_index.set(paramInt1);
    localReqBody.uint32_want_num.set(paramInt2);
    sendPbReq(makeOIDBPkg("OidbSvc.0x7ba", 1978, 0, localReqBody.toByteArray()));
  }
  
  public void a(String paramString, int paramInt, byte[] paramArrayOfByte)
  {
    paramString = createToServiceMsg("MCardSvc.ReqSetCard");
    paramString.extraData.putInt("eSubCmd", paramInt);
    paramString.extraData.putByteArray("vReqSetTemplate", paramArrayOfByte);
    send(paramString);
  }
  
  public void a(String paramString, long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CardHandler", 2, String.format("reqDelVoteRecord selfUin:%s targetUin:%d type:%d", new Object[] { paramString, Long.valueOf(paramLong), Integer.valueOf(paramInt) }));
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", String.valueOf(paramString), "VisitorSvc.ReqDeleteVisitorRecord");
    localToServiceMsg.extraData.putLong("selfUin", Long.parseLong(paramString));
    localToServiceMsg.extraData.putLong("targetUin", paramLong);
    localToServiceMsg.extraData.putInt("type", paramInt);
    send(localToServiceMsg);
  }
  
  public void a(String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("deleteLbsPortrait() uin = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("Q.profilecard.SummaryCard", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "MCardSvc.ReqDelFace");
    ((ToServiceMsg)localObject).extraData.putLong("selfuin", Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    ((ToServiceMsg)localObject).extraData.putByteArray("filekey", paramArrayOfByte);
    ((ToServiceMsg)localObject).extraData.putLong("timestamp", paramLong);
    ((ToServiceMsg)localObject).extraData.putString("touin", paramString);
    send((ToServiceMsg)localObject);
  }
  
  @Deprecated
  public void a(String paramString1, String paramString2, byte paramByte, int paramInt)
  {
    QLog.e("CardHandler", 1, String.format("getHYMakeFriendsCard uin=%s friendUin=%s reqType=%s faceTimeStamp=%s", new Object[] { paramString1, paramString2, Byte.valueOf(paramByte), Integer.valueOf(paramInt) }), new Throwable());
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, long paramLong1, byte paramByte1, long paramLong2, long paramLong3, byte[] paramArrayOfByte1, String paramString3, long paramLong4, int paramInt2, byte[] paramArrayOfByte2, byte paramByte2)
  {
    IProfileProtocolService localIProfileProtocolService = (IProfileProtocolService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IProfileProtocolService.class, "all");
    if (localIProfileProtocolService != null) {
      localIProfileProtocolService.requestProfileCard(paramString1, paramString2, paramInt1, paramLong1, paramByte1, paramLong2, paramLong3, paramArrayOfByte1, paramString3, paramLong4, paramInt2, paramArrayOfByte2, paramByte2);
    }
  }
  
  public void a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", String.valueOf(paramString1), "VisitorSvc.ReqGetFavoriteList");
    localToServiceMsg.extraData.putLong("selfUin", Long.parseLong(paramString1));
    localToServiceMsg.extraData.putLong("targetUin", Long.parseLong(paramString2));
    localToServiceMsg.extraData.putLong("nextMid", paramLong);
    localToServiceMsg.extraData.putInt("pageSize", paramInt);
    send(localToServiceMsg);
  }
  
  public void a(String paramString1, String paramString2, Long paramLong)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("SummaryCard.LikeIt");
    localToServiceMsg.extraData.putLong("selfUin", Long.parseLong(paramString1));
    localToServiceMsg.extraData.putLong("destUin", Long.parseLong(paramString2));
    localToServiceMsg.extraData.putLong("labelId", paramLong.longValue());
    send(localToServiceMsg);
  }
  
  /* Error */
  protected void a(String paramString, List<CardProfile> paramList)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +110 -> 111
    //   4: aload_2
    //   5: invokeinterface 348 1 0
    //   10: ifle +101 -> 111
    //   13: aload_0
    //   14: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   17: invokevirtual 1768	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   20: invokevirtual 1774	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   23: astore_1
    //   24: aload_1
    //   25: ifnull +86 -> 111
    //   28: aload_1
    //   29: invokevirtual 2805	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   32: invokevirtual 2810	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   35: aload_2
    //   36: invokeinterface 641 1 0
    //   41: astore_2
    //   42: aload_2
    //   43: invokeinterface 616 1 0
    //   48: ifeq +19 -> 67
    //   51: aload_1
    //   52: aload_2
    //   53: invokeinterface 620 1 0
    //   58: checkcast 1286	com/tencent/mobileqq/data/CardProfile
    //   61: invokevirtual 3144	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   64: goto -22 -> 42
    //   67: aload_1
    //   68: invokevirtual 2805	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   71: invokevirtual 2829	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   74: goto +12 -> 86
    //   77: astore_2
    //   78: goto +20 -> 98
    //   81: astore_2
    //   82: aload_2
    //   83: invokevirtual 775	java/lang/Exception:printStackTrace	()V
    //   86: aload_1
    //   87: invokevirtual 2805	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   90: invokevirtual 2834	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   93: aload_1
    //   94: invokevirtual 2505	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   97: return
    //   98: aload_1
    //   99: invokevirtual 2805	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   102: invokevirtual 2834	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   105: aload_1
    //   106: invokevirtual 2505	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   109: aload_2
    //   110: athrow
    //   111: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	CardHandler
    //   0	112	1	paramString	String
    //   0	112	2	paramList	List<CardProfile>
    // Exception table:
    //   from	to	target	type
    //   28	42	77	finally
    //   42	64	77	finally
    //   67	74	77	finally
    //   82	86	77	finally
    //   28	42	81	java/lang/Exception
    //   42	64	81	java/lang/Exception
    //   67	74	81	java/lang/Exception
  }
  
  public void a(ArrayList<String> paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        this.jdField_a_of_type_JavaUtilArrayList.add(str);
      }
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("uploadPhotoWall size:");
        ((StringBuilder)???).append(paramArrayList.size());
        QLog.d("Q.qzonephotowall", 2, ((StringBuilder)???).toString());
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.execute(new CardHandler.2(this));
      return;
    }
    for (;;)
    {
      throw paramArrayList;
    }
  }
  
  public void a(ArrayList<AutoReplyText> paramArrayList, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramArrayList != null) && (((paramInt1 >= 0) && (paramInt1 < paramArrayList.size())) || (paramInt1 == 2147483647)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, String.format("setAutoReplyList, selectIndex: %s, replyMsgList: %s, lastSelectId: %s, needNotify: %s", new Object[] { Integer.valueOf(paramInt1), paramArrayList, Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean) }));
      }
      Object localObject1 = new ArrayList();
      Object localObject2 = paramArrayList.iterator();
      while (((Iterator)localObject2).hasNext()) {
        a((List)localObject1, (AutoReplyText)((Iterator)localObject2).next());
      }
      localObject2 = new wording_storage.WordingCfg();
      if (paramInt1 == 2147483647)
      {
        ((wording_storage.WordingCfg)localObject2).auto_reply_flag.set(0);
        ((wording_storage.WordingCfg)localObject2).select_id.set(paramInt2);
      }
      else
      {
        ((wording_storage.WordingCfg)localObject2).auto_reply_flag.set(1);
        ((wording_storage.WordingCfg)localObject2).select_id.set(paramInt1);
      }
      ((wording_storage.WordingCfg)localObject2).wording_list.set((List)localObject1);
      localObject1 = new oidb_cmd0xcd5.SetDataReq();
      ((oidb_cmd0xcd5.SetDataReq)localObject1).pb_data.set(ByteStringMicro.copyFrom(((wording_storage.WordingCfg)localObject2).toByteArray()));
      localObject2 = new oidb_cmd0xcd5.ReqBody();
      ((oidb_cmd0xcd5.ReqBody)localObject2).service_type.set(2);
      ((oidb_cmd0xcd5.ReqBody)localObject2).setdata_req.set((MessageMicro)localObject1);
      localObject1 = makeOIDBPkg("OidbSvc.0xcd5", 3285, 0, ((oidb_cmd0xcd5.ReqBody)localObject2).toByteArray());
      ((ToServiceMsg)localObject1).extraData.putParcelableArrayList("replyMsgList", paramArrayList);
      ((ToServiceMsg)localObject1).extraData.putInt("selectId", paramInt1);
      ((ToServiceMsg)localObject1).extraData.putBoolean("needNotify", paramBoolean);
      sendPbReq((ToServiceMsg)localObject1);
      return;
    }
    QLog.d("CardHandler", 1, String.format("setAutoReplyList param error, replyList: %s, lastSelectId: %s", new Object[] { paramArrayList, Integer.valueOf(paramInt1) }));
    notifyUI(97, false, null);
  }
  
  public void a(List<ProfileLabelInfo> paramList)
  {
    if (paramList != null)
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(((ProfileLabelInfo)paramList.next()).labelId);
      }
      paramList = createToServiceMsg("SummaryCard.SetLabel");
      paramList.extraData.putSerializable("labels", (Serializable)localArrayList);
      send(paramList);
    }
  }
  
  public void a(Oidb_0x66b.ReqBody paramReqBody)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewNearbyMyTab", 2, "getSimpleNearbyMyTabCard");
    }
    paramReqBody = makeOIDBPkg("OidbSvc.0x66b", 1643, 0, paramReqBody.toByteArray());
    paramReqBody.extraData.putBoolean("req_pb_protocol_flag", true);
    paramReqBody.extraData.putBoolean("simpleMytabCard", true);
    send(paramReqBody);
  }
  
  public void a(short paramShort1, short paramShort2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CommonSwitchTag", 2, String.format(Locale.getDefault(), "setCommonSwitchFromDetailInfo [%d, %d]", new Object[] { Short.valueOf(paramShort1), Short.valueOf(paramShort2) }));
    }
    try
    {
      oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
      localOIDBSSOPkg.uint32_command.set(1279);
      localOIDBSSOPkg.uint32_service_type.set(9);
      Object localObject = ByteBuffer.allocate(13);
      ((ByteBuffer)localObject).putInt(Utils.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))).put((byte)0).putShort((short)1).putShort(paramShort1).putShort((short)2).putShort(paramShort2);
      localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
      localObject = createToServiceMsg("OidbSvc.0x4ff_9");
      ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
      ((ToServiceMsg)localObject).setTimeout(30000L);
      ((ToServiceMsg)localObject).extraData.putShort("switch_id", paramShort1);
      ((ToServiceMsg)localObject).extraData.putShort("switch_value", paramShort2);
      ((ToServiceMsg)localObject).extraData.putBoolean("isSetCommonSwitchFromDetailInfo", true);
      ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CommonSwitchTag", 2, "setCommonSwitchFromDetailInfo ex", localException);
      }
    }
  }
  
  public void a(short paramShort1, short paramShort2, short paramShort3, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setTempConversationNewBlockState() called with: type = [");
      ((StringBuilder)localObject1).append(paramShort1);
      ((StringBuilder)localObject1).append("], inBoxType = [");
      ((StringBuilder)localObject1).append(paramShort2);
      ((StringBuilder)localObject1).append("], state = [");
      ((StringBuilder)localObject1).append(paramShort3);
      ((StringBuilder)localObject1).append("], isAllowedToReceiveMessageBefore = [");
      ((StringBuilder)localObject1).append(paramBoolean1);
      ((StringBuilder)localObject1).append("], isInBox = [");
      ((StringBuilder)localObject1).append(paramBoolean2);
      ((StringBuilder)localObject1).append("]");
      QLog.d("Q.profilecard.", 2, ((StringBuilder)localObject1).toString());
    }
    try
    {
      localObject1 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1279);
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(9);
      Object localObject2 = ByteBuffer.allocate(19);
      long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      short s2 = (short)(paramShort3 & 0x1);
      short s3 = (short)(paramShort3 >> 1);
      short s1 = s2;
      if (s2 == 0)
      {
        s1 = s2;
        if (paramShort1 == -20457) {
          s1 = 2;
        }
      }
      ((ByteBuffer)localObject2).putInt(Utils.a(l)).put((byte)0).putShort((short)2).putShort(paramShort1).putShort((short)2).putShort(s1).putShort(paramShort2).putShort((short)2).putShort(s3);
      ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject2).array()));
      localObject2 = createToServiceMsg("OidbSvc.0x4ff_9");
      ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
      ((ToServiceMsg)localObject2).setTimeout(30000L);
      ((ToServiceMsg)localObject2).extraData.putBoolean("blockSwitch", paramBoolean1);
      ((ToServiceMsg)localObject2).extraData.putBoolean("inBoxSwitch", paramBoolean2);
      ((ToServiceMsg)localObject2).extraData.putShort("type", paramShort1);
      ((ToServiceMsg)localObject2).extraData.putBoolean("tempConversationNewBlockState", true);
      ((ToServiceMsg)localObject2).extraData.putBoolean("reqFromCardHandler", true);
      sendPbReq((ToServiceMsg)localObject2);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("Q.profilecard.", 1, "setTempConversationNewBlockState ex", localException);
    }
  }
  
  public void a(short paramShort, boolean paramBoolean)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setTempConversationBlocState type=");
      ((StringBuilder)localObject1).append(paramShort);
      ((StringBuilder)localObject1).append(" Block=");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.d("Q.profilecard.", 2, ((StringBuilder)localObject1).toString());
    }
    try
    {
      localObject1 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1279);
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(9);
      Object localObject2 = ByteBuffer.allocate(13);
      long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      short s = a(paramShort, paramBoolean);
      ((ByteBuffer)localObject2).putInt(Utils.a(l)).put((byte)0).putShort((short)1).putShort(paramShort).putShort((short)2).putShort(s);
      ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject2).array()));
      localObject2 = createToServiceMsg("OidbSvc.0x4ff_9");
      ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
      ((ToServiceMsg)localObject2).setTimeout(30000L);
      ((ToServiceMsg)localObject2).extraData.putBoolean("switch", paramBoolean);
      ((ToServiceMsg)localObject2).extraData.putShort("type", paramShort);
      ((ToServiceMsg)localObject2).extraData.putBoolean("tempConversationBlocState", true);
      ((ToServiceMsg)localObject2).extraData.putBoolean("reqFromCardHandler", true);
      sendPbReq((ToServiceMsg)localObject2);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("Q.profilecard.", 1, "setTempConversationBlocState ex", localException);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1169);
    localOIDBSSOPkg.uint32_service_type.set(100);
    Object localObject = ByteBuffer.allocate(1);
    ((ByteBuffer)localObject).put((byte)(paramBoolean ^ true));
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = createToServiceMsg("OidbSvc.0x491_100");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    ((ToServiceMsg)localObject).extraData.putBoolean("key_searchable", paramBoolean);
    ((ToServiceMsg)localObject).setTimeout(10000L);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("sendHiddenSessionRequest open=");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.d("Q.profilecard.", 2, ((StringBuilder)localObject1).toString());
    }
    for (;;)
    {
      try
      {
        localObject1 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1279);
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(9);
        Object localObject2 = ByteBuffer.allocate(13);
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (paramBoolean)
        {
          s = 0;
          ((ByteBuffer)localObject2).putInt(Utils.a(l)).put((byte)0).putShort((short)1).putShort((short)paramInt).putShort((short)2).putShort(s);
          ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject2).array()));
          localObject2 = createToServiceMsg("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
          ((ToServiceMsg)localObject2).setTimeout(30000L);
          ((ToServiceMsg)localObject2).extraData.putInt("type", paramInt);
          ((ToServiceMsg)localObject2).extraData.putInt("hidden_session_switch", s);
          ((ToServiceMsg)localObject2).extraData.putBoolean("from_send_hidden_session", true);
          ((ToServiceMsg)localObject2).extraData.putBoolean("reqFromCardHandler", true);
          sendPbReq((ToServiceMsg)localObject2);
          return;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.", 2, "sendHiddenSessionRequest ex", localException);
        }
        return;
      }
      short s = 1;
    }
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("uploadAvatarResult|isSuc = ");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.i("Q.profilecard.Avatar", 2, ((StringBuilder)localObject1).toString());
    }
    String str = FaceUtil.b();
    FaceUtil.a(null);
    if (paramBoolean)
    {
      Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      localObject1 = (Setting)((EntityManager)localObject2).find(Setting.class, paramString);
      if (localObject1 == null)
      {
        localObject1 = new Setting();
        ((Setting)localObject1).uin = paramString;
        ((Setting)localObject1).bHeadType = 1;
        ((Setting)localObject1).bUsrType = 1;
        ((Setting)localObject1).updateTimestamp = System.currentTimeMillis();
        ((Setting)localObject1).headImgTimestamp = (((Setting)localObject1).updateTimestamp / 1000L);
        ((EntityManager)localObject2).persist((Entity)localObject1);
      }
      else
      {
        ((Setting)localObject1).bHeadType = 1;
        ((Setting)localObject1).updateTimestamp = System.currentTimeMillis();
        ((Setting)localObject1).headImgTimestamp = (((Setting)localObject1).updateTimestamp / 1000L);
        ((EntityManager)localObject2).update((Entity)localObject1);
      }
      ((EntityManager)localObject2).close();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.updateSettingTableCache((Setting)localObject1);
      localObject1 = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      localObject2 = ((VasExtensionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).a;
      Object localObject3 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getExtensionInfo(paramString, true);
      ((ExtensionInfo)localObject3).faceId = 0;
      ((ExtensionInfo)localObject3).faceIdUpdateTime = NetConnInfoCenter.getServerTime();
      ((ExtensionInfo)localObject3).setStatus(1000);
      ((FriendsManager)localObject1).a((ExtensionInfo)localObject3);
      ((VasFaceManager)localObject2).a((ExtensionInfo)localObject3);
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      localObject1 = ((QQAppInterface)localObject1).getCustomFaceFilePath(false, ((QQAppInterface)localObject1).getCurrentAccountUin());
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        FileUtils.deleteFile((String)localObject1);
      }
      localObject2 = FaceUtil.a(paramString);
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        FileUtils.deleteFile((String)localObject2);
      }
      localObject3 = FaceUtil.b(paramString);
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        FileUtils.deleteFile((String)localObject3);
      }
      FaceUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeFaceIconCache(1, paramString, 0);
      if (!TextUtils.isEmpty(str))
      {
        ImageUtil.a(null, str, (String)localObject1, 140, 140);
        FileUtils.copyFile(str, (String)localObject2);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.sendSelfQQHeadBroadcast(1, paramString, 0, (String)localObject1);
      }
    }
    if (!TextUtils.isEmpty(str)) {
      FileUtils.deleteFile(str);
    }
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putString("uin", paramString);
    ((Bundle)localObject1).putInt("result", paramInt);
    notifyUI(8, paramBoolean, localObject1);
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("MCardSvc.ReqSetCardSwitch");
    localToServiceMsg.extraData.putBoolean("modify_switch_for_near_people", paramBoolean1);
    Bundle localBundle = localToServiceMsg.extraData;
    long l;
    if (paramBoolean2) {
      l = 0L;
    } else {
      l = 1L;
    }
    localBundle.putLong("target_value", l);
    send(localToServiceMsg);
  }
  
  public boolean a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    long l1 = ((SharedPreferences)localObject).getLong("sign_in_time_stamp", 0L);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    localStringBuilder.append("sign_in_info");
    localObject = ((SharedPreferences)localObject).getString(localStringBuilder.toString(), "");
    try
    {
      localObject = new JSONObject((String)localObject);
      int i = ((JSONObject)localObject).optInt("type");
      int j = ((JSONObject)localObject).optInt("redpoint");
      if (((JSONObject)localObject).optInt("openfunc") != 0)
      {
        long l2 = MessageCache.a();
        if ((l2 - l1 <= 86400L) && (i != 4) && (j == 1)) {
          return true;
        }
      }
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return false;
  }
  
  public void b()
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1168);
    localOIDBSSOPkg.uint32_service_type.set(100);
    Object localObject = ByteBuffer.allocate(4);
    ((ByteBuffer)localObject).putInt((int)Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = createToServiceMsg("OidbSvc.0x490_100");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CardHandler", 2, "getSigninRedTouchShell");
    }
    if (d())
    {
      c(paramInt);
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.i("DailySignIn", 2, "getSignRedTouchShell time kill");
      }
      notifyUI(82, true, null);
    }
    if (c())
    {
      f();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("DailySignIn", 2, "shouldResuestSignOperate false");
    }
  }
  
  /* Error */
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 101	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: istore 4
    //   6: iconst_0
    //   7: istore 7
    //   9: iload 4
    //   11: ifeq +13 -> 24
    //   14: aload_3
    //   15: ifnull +9 -> 24
    //   18: iconst_1
    //   19: istore 5
    //   21: goto +6 -> 27
    //   24: iconst_0
    //   25: istore 5
    //   27: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   30: ifeq +37 -> 67
    //   33: new 20	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   40: astore_2
    //   41: aload_2
    //   42: ldc_w 3373
    //   45: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload_2
    //   50: iload 5
    //   52: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   55: pop
    //   56: ldc_w 368
    //   59: iconst_2
    //   60: aload_2
    //   61: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   67: aload_0
    //   68: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   71: invokevirtual 171	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   74: pop
    //   75: iload 5
    //   77: istore 4
    //   79: iload 5
    //   81: ifeq +357 -> 438
    //   84: iload 5
    //   86: istore 6
    //   88: iload 5
    //   90: istore 4
    //   92: new 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   95: dup
    //   96: invokespecial 120	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   99: aload_3
    //   100: checkcast 122	[B
    //   103: checkcast 122	[B
    //   106: invokevirtual 126	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   109: checkcast 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   112: astore_2
    //   113: iload 5
    //   115: istore 6
    //   117: iload 5
    //   119: istore 4
    //   121: aload_2
    //   122: getfield 130	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   125: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   128: ifne +365 -> 493
    //   131: iconst_1
    //   132: istore 5
    //   134: goto +3 -> 137
    //   137: iload 5
    //   139: istore 6
    //   141: iload 5
    //   143: istore 4
    //   145: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   148: ifeq +104 -> 252
    //   151: iload 5
    //   153: istore 6
    //   155: iload 5
    //   157: istore 4
    //   159: new 20	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   166: astore_3
    //   167: iload 5
    //   169: istore 6
    //   171: iload 5
    //   173: istore 4
    //   175: aload_3
    //   176: ldc_w 3375
    //   179: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: iload 5
    //   185: istore 6
    //   187: iload 5
    //   189: istore 4
    //   191: aload_3
    //   192: iload 5
    //   194: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: iload 5
    //   200: istore 6
    //   202: iload 5
    //   204: istore 4
    //   206: aload_3
    //   207: ldc_w 3377
    //   210: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: pop
    //   214: iload 5
    //   216: istore 6
    //   218: iload 5
    //   220: istore 4
    //   222: aload_3
    //   223: aload_2
    //   224: getfield 130	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   227: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   230: invokevirtual 391	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   233: pop
    //   234: iload 5
    //   236: istore 6
    //   238: iload 5
    //   240: istore 4
    //   242: ldc 113
    //   244: iconst_2
    //   245: aload_3
    //   246: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   249: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   252: iload 5
    //   254: istore 6
    //   256: iload 5
    //   258: istore 4
    //   260: aload_0
    //   261: iload 5
    //   263: aload_2
    //   264: invokespecial 1489	com/tencent/mobileqq/app/CardHandler:a	(ZLtencent/im/oidb/oidb_sso$OIDBSSOPkg;)Z
    //   267: istore 5
    //   269: iload 5
    //   271: istore 4
    //   273: goto +165 -> 438
    //   276: astore_2
    //   277: goto +99 -> 376
    //   280: astore_2
    //   281: iload 4
    //   283: istore 6
    //   285: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   288: ifeq +17 -> 305
    //   291: iload 4
    //   293: istore 6
    //   295: ldc 113
    //   297: iconst_2
    //   298: ldc_w 3379
    //   301: aload_2
    //   302: invokestatic 222	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   305: iload 4
    //   307: istore 5
    //   309: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   312: ifeq +147 -> 459
    //   315: new 20	java/lang/StringBuilder
    //   318: dup
    //   319: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   322: astore_2
    //   323: aload_2
    //   324: ldc_w 3375
    //   327: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: pop
    //   331: aload_2
    //   332: iload 4
    //   334: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   337: pop
    //   338: aload_2
    //   339: ldc 224
    //   341: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: pop
    //   345: aload_2
    //   346: aload_1
    //   347: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   350: ldc 202
    //   352: invokevirtual 208	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   355: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   358: pop
    //   359: ldc 113
    //   361: iconst_2
    //   362: aload_2
    //   363: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   366: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   369: iload 4
    //   371: istore 5
    //   373: goto +86 -> 459
    //   376: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   379: ifeq +57 -> 436
    //   382: new 20	java/lang/StringBuilder
    //   385: dup
    //   386: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   389: astore_3
    //   390: aload_3
    //   391: ldc_w 3375
    //   394: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: pop
    //   398: aload_3
    //   399: iload 6
    //   401: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   404: pop
    //   405: aload_3
    //   406: ldc 224
    //   408: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   411: pop
    //   412: aload_3
    //   413: aload_1
    //   414: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   417: ldc 202
    //   419: invokevirtual 208	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   422: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   425: pop
    //   426: ldc 113
    //   428: iconst_2
    //   429: aload_3
    //   430: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   433: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   436: aload_2
    //   437: athrow
    //   438: iload 4
    //   440: istore 5
    //   442: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   445: ifeq +14 -> 459
    //   448: new 20	java/lang/StringBuilder
    //   451: dup
    //   452: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   455: astore_2
    //   456: goto -133 -> 323
    //   459: iload 7
    //   461: istore 4
    //   463: iload 5
    //   465: ifeq +14 -> 479
    //   468: aload_1
    //   469: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   472: ldc 202
    //   474: invokevirtual 208	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   477: istore 4
    //   479: aload_0
    //   480: bipush 80
    //   482: iload 5
    //   484: iload 4
    //   486: invokestatic 365	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   489: invokevirtual 228	com/tencent/mobileqq/app/CardHandler:notifyUI	(IZLjava/lang/Object;)V
    //   492: return
    //   493: iconst_0
    //   494: istore 5
    //   496: goto -359 -> 137
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	499	0	this	CardHandler
    //   0	499	1	paramToServiceMsg	ToServiceMsg
    //   0	499	2	paramFromServiceMsg	FromServiceMsg
    //   0	499	3	paramObject	Object
    //   4	481	4	bool1	boolean
    //   19	476	5	bool2	boolean
    //   86	314	6	bool3	boolean
    //   7	453	7	bool4	boolean
    // Exception table:
    //   from	to	target	type
    //   92	113	276	finally
    //   121	131	276	finally
    //   145	151	276	finally
    //   159	167	276	finally
    //   175	183	276	finally
    //   191	198	276	finally
    //   206	214	276	finally
    //   222	234	276	finally
    //   242	252	276	finally
    //   260	269	276	finally
    //   285	291	276	finally
    //   295	305	276	finally
    //   92	113	280	java/lang/Exception
    //   121	131	280	java/lang/Exception
    //   145	151	280	java/lang/Exception
    //   159	167	280	java/lang/Exception
    //   175	183	280	java/lang/Exception
    //   191	198	280	java/lang/Exception
    //   206	214	280	java/lang/Exception
    //   222	234	280	java/lang/Exception
    //   242	252	280	java/lang/Exception
    //   260	269	280	java/lang/Exception
  }
  
  public void b(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
    oidb_0xa28.ReqBody localReqBody = new oidb_0xa28.ReqBody();
    localReqBody.uint64_request_uin.set(Long.valueOf(paramString).longValue());
    localReqBody.uint32_sourceID.set(0);
    localReqBody.uint32_sourceSubID.set(0);
    sendPbReq(makeOIDBPkg("OidbSvc.0xa28", 2600, 0, localReqBody.toByteArray()));
  }
  
  public void b(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", String.valueOf(paramString1), "VisitorSvc.ReqGetVoterList");
    localToServiceMsg.extraData.putLong("selfUin", Long.parseLong(paramString1));
    localToServiceMsg.extraData.putLong("targetUin", Long.parseLong(paramString2));
    localToServiceMsg.extraData.putLong("nextMid", paramLong);
    localToServiceMsg.extraData.putInt("pageSize", paramInt);
    send(localToServiceMsg);
  }
  
  public void b(ArrayList<MedalID> paramArrayList)
  {
    Object localObject;
    Iterator localIterator;
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder(100);
      ((StringBuilder)localObject).append("reportMedalWallRead, ");
      if (paramArrayList != null)
      {
        localIterator = paramArrayList.iterator();
        while (localIterator.hasNext()) {
          MedalWallMng.a((MedalID)localIterator.next(), (StringBuilder)localObject);
        }
      }
      QLog.i("MedalWallMng", 4, ((StringBuilder)localObject).toString());
    }
    if (paramArrayList != null)
    {
      if (paramArrayList.isEmpty()) {
        return;
      }
      localObject = new cmd0xac6.ReqBody();
      localIterator = paramArrayList.iterator();
      while (localIterator.hasNext())
      {
        MedalID localMedalID = (MedalID)localIterator.next();
        if (localMedalID != null)
        {
          cmd0xac6.MedalReport localMedalReport = new cmd0xac6.MedalReport();
          localMedalReport.uint32_id.set(localMedalID.jdField_a_of_type_Int);
          localMedalReport.uint32_level.set(localMedalID.jdField_b_of_type_Int);
          ((cmd0xac6.ReqBody)localObject).rpt_medals.add(localMedalReport);
        }
      }
      if (((cmd0xac6.ReqBody)localObject).rpt_medals.isEmpty()) {
        return;
      }
      localObject = makeOIDBPkg("OidbSvc.0xac6", 2758, 2, ((cmd0xac6.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putParcelableArrayList("medal_wall_list", paramArrayList);
      sendPbReq((ToServiceMsg)localObject);
    }
  }
  
  public void b(List<Long> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    localStringBuilder.append("_todayVoters");
    FileUtils.writeObject(localStringBuilder.toString(), paramList);
  }
  
  public void b(boolean paramBoolean)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setPCActiveState OPEN=");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.d("Q.profilecard.", 2, ((StringBuilder)localObject1).toString());
    }
    for (;;)
    {
      try
      {
        localObject1 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1279);
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(9);
        Object localObject2 = ByteBuffer.allocate(13);
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (paramBoolean == true)
        {
          s = 1;
          ((ByteBuffer)localObject2).putInt(Utils.a(l)).put((byte)0).putShort((short)1).putShort((short)-25042).putShort((short)2).putShort(s);
          ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject2).array()));
          localObject2 = createToServiceMsg("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
          ((ToServiceMsg)localObject2).setTimeout(30000L);
          ((ToServiceMsg)localObject2).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject2).extraData.putBoolean("isGetLoginDays", false);
          ((ToServiceMsg)localObject2).extraData.putBoolean("pcActiveState", true);
          ((ToServiceMsg)localObject2).extraData.putBoolean("reqFromCardHandler", true);
          sendPbReq((ToServiceMsg)localObject2);
          return;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.", 2, "setPCActiveState ex", localException);
        }
        return;
      }
      short s = 0;
    }
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setCallTabState open=");
      ((StringBuilder)localObject1).append(paramBoolean1);
      QLog.d("Q.profilecard.", 2, ((StringBuilder)localObject1).toString());
    }
    for (;;)
    {
      try
      {
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNowLiveManager().a();
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(((String)localObject1).charAt(2));
        int j = Integer.valueOf(((StringBuilder)localObject2).toString()).intValue();
        localObject1 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1279);
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(9);
        localObject2 = ByteBuffer.allocate(19);
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        i = 0;
        if (paramBoolean1 == true)
        {
          s = 0;
          ByteBuffer localByteBuffer = ((ByteBuffer)localObject2).putInt(Utils.a(l)).put((byte)0).putShort((short)2).putShort((short)-25217).putShort((short)2).putShort(s).putShort((short)-23476).putShort((short)2);
          if (j >= 2) {
            break label331;
          }
          localByteBuffer.putShort((short)i);
          ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject2).array()));
          localObject2 = createToServiceMsg("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
          ((ToServiceMsg)localObject2).setTimeout(30000L);
          ((ToServiceMsg)localObject2).extraData.putBoolean("switch", paramBoolean1);
          ((ToServiceMsg)localObject2).extraData.putBoolean("calltabstate", true);
          ((ToServiceMsg)localObject2).extraData.putBoolean("reqFromCardHandler", true);
          sendPbReq((ToServiceMsg)localObject2);
          return;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.", 2, "setCallTabState ex", localException);
        }
        return;
      }
      short s = 1;
      continue;
      label331:
      int i = 1;
    }
  }
  
  public boolean b()
  {
    BaseApplication localBaseApplication = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("task_entry_config");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    return localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).getBoolean("open", false);
  }
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getSigninRedTouch svrType=");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("DailySignIn", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new cmd0x922.ReqBody();
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    ((cmd0x922.ReqBody)localObject).uint64_timestamp.set(localSharedPreferences.getLong("sign_in_time_stamp", 0L));
    sendPbReq(makeOIDBPkg("OidbSvc.0x922", 2338, paramInt, ((cmd0x922.ReqBody)localObject).toByteArray()));
  }
  
  /* Error */
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 101	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: istore 5
    //   6: iconst_0
    //   7: istore 11
    //   9: iconst_0
    //   10: istore 12
    //   12: iconst_0
    //   13: istore 10
    //   15: iload 5
    //   17: ifeq +13 -> 30
    //   20: aload_3
    //   21: ifnull +9 -> 30
    //   24: iconst_1
    //   25: istore 7
    //   27: goto +6 -> 33
    //   30: iconst_0
    //   31: istore 7
    //   33: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   36: ifeq +37 -> 73
    //   39: new 20	java/lang/StringBuilder
    //   42: dup
    //   43: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   46: astore_2
    //   47: aload_2
    //   48: ldc_w 3462
    //   51: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload_2
    //   56: iload 7
    //   58: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: ldc_w 2535
    //   65: iconst_1
    //   66: aload_2
    //   67: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   73: aload_0
    //   74: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   77: invokevirtual 171	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   80: pop
    //   81: iload 11
    //   83: istore 8
    //   85: iload 7
    //   87: istore 5
    //   89: iload 7
    //   91: ifeq +524 -> 615
    //   94: iload 7
    //   96: istore 9
    //   98: iload 7
    //   100: istore 6
    //   102: new 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   105: dup
    //   106: invokespecial 120	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   109: aload_3
    //   110: checkcast 122	[B
    //   113: checkcast 122	[B
    //   116: invokevirtual 126	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   119: checkcast 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   122: astore_2
    //   123: iload 7
    //   125: istore 9
    //   127: iload 7
    //   129: istore 6
    //   131: aload_2
    //   132: getfield 130	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   135: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   138: ifne +520 -> 658
    //   141: iconst_1
    //   142: istore 7
    //   144: goto +3 -> 147
    //   147: iload 7
    //   149: istore 9
    //   151: iload 7
    //   153: istore 6
    //   155: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   158: ifeq +105 -> 263
    //   161: iload 7
    //   163: istore 9
    //   165: iload 7
    //   167: istore 6
    //   169: new 20	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   176: astore_3
    //   177: iload 7
    //   179: istore 9
    //   181: iload 7
    //   183: istore 6
    //   185: aload_3
    //   186: ldc_w 3464
    //   189: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: pop
    //   193: iload 7
    //   195: istore 9
    //   197: iload 7
    //   199: istore 6
    //   201: aload_3
    //   202: iload 7
    //   204: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: iload 7
    //   210: istore 9
    //   212: iload 7
    //   214: istore 6
    //   216: aload_3
    //   217: ldc_w 3377
    //   220: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: iload 7
    //   226: istore 9
    //   228: iload 7
    //   230: istore 6
    //   232: aload_3
    //   233: aload_2
    //   234: getfield 130	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   237: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   240: invokevirtual 391	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   243: pop
    //   244: iload 7
    //   246: istore 9
    //   248: iload 7
    //   250: istore 6
    //   252: ldc_w 2535
    //   255: iconst_1
    //   256: aload_3
    //   257: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   263: iload 11
    //   265: istore 8
    //   267: iload 7
    //   269: istore 5
    //   271: iload 7
    //   273: ifeq +342 -> 615
    //   276: iload 7
    //   278: istore 9
    //   280: iload 7
    //   282: istore 6
    //   284: iload 11
    //   286: istore 8
    //   288: iload 7
    //   290: istore 5
    //   292: aload_2
    //   293: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   296: invokevirtual 146	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   299: ifeq +316 -> 615
    //   302: iload 7
    //   304: istore 9
    //   306: iload 7
    //   308: istore 6
    //   310: iload 11
    //   312: istore 8
    //   314: iload 7
    //   316: istore 5
    //   318: aload_2
    //   319: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   322: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   325: ifnull +290 -> 615
    //   328: iload 7
    //   330: istore 9
    //   332: iload 7
    //   334: istore 6
    //   336: aload_2
    //   337: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   340: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   343: invokevirtual 155	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   346: invokestatic 161	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   349: invokevirtual 164	java/nio/ByteBuffer:getInt	()I
    //   352: istore 4
    //   354: iload 4
    //   356: i2l
    //   357: lstore 13
    //   359: iload 4
    //   361: ifge +16 -> 377
    //   364: iload 4
    //   366: ldc_w 533
    //   369: iand
    //   370: i2l
    //   371: ldc2_w 534
    //   374: lor
    //   375: lstore 13
    //   377: iload 7
    //   379: istore 9
    //   381: iload 7
    //   383: istore 6
    //   385: aload_0
    //   386: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   389: invokevirtual 171	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   392: lload 13
    //   394: invokestatic 176	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   397: invokevirtual 179	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   400: ifeq +28 -> 428
    //   403: iload 7
    //   405: istore 9
    //   407: iload 7
    //   409: istore 6
    //   411: aload_1
    //   412: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   415: ldc 202
    //   417: invokevirtual 208	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   420: istore 8
    //   422: iconst_1
    //   423: istore 5
    //   425: goto +190 -> 615
    //   428: iconst_0
    //   429: istore 5
    //   431: iload 11
    //   433: istore 8
    //   435: goto +180 -> 615
    //   438: astore_2
    //   439: goto +113 -> 552
    //   442: astore_2
    //   443: iload 6
    //   445: istore 9
    //   447: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   450: ifeq +18 -> 468
    //   453: iload 6
    //   455: istore 9
    //   457: ldc_w 2535
    //   460: iconst_1
    //   461: ldc_w 3466
    //   464: aload_2
    //   465: invokestatic 222	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   468: iload 12
    //   470: istore 7
    //   472: iload 6
    //   474: istore 9
    //   476: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   479: ifeq +165 -> 644
    //   482: new 20	java/lang/StringBuilder
    //   485: dup
    //   486: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   489: astore_2
    //   490: iload 6
    //   492: istore 5
    //   494: iload 10
    //   496: istore 7
    //   498: aload_2
    //   499: ldc_w 3464
    //   502: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   505: pop
    //   506: aload_2
    //   507: iload 5
    //   509: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   512: pop
    //   513: aload_2
    //   514: ldc 224
    //   516: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: pop
    //   520: aload_2
    //   521: aload_1
    //   522: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   525: ldc 202
    //   527: invokevirtual 208	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   530: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   533: pop
    //   534: ldc_w 2535
    //   537: iconst_1
    //   538: aload_2
    //   539: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   542: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   545: iload 5
    //   547: istore 9
    //   549: goto +95 -> 644
    //   552: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   555: ifeq +58 -> 613
    //   558: new 20	java/lang/StringBuilder
    //   561: dup
    //   562: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   565: astore_3
    //   566: aload_3
    //   567: ldc_w 3464
    //   570: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: pop
    //   574: aload_3
    //   575: iload 9
    //   577: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   580: pop
    //   581: aload_3
    //   582: ldc 224
    //   584: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   587: pop
    //   588: aload_3
    //   589: aload_1
    //   590: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   593: ldc 202
    //   595: invokevirtual 208	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   598: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   601: pop
    //   602: ldc_w 2535
    //   605: iconst_1
    //   606: aload_3
    //   607: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   610: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   613: aload_2
    //   614: athrow
    //   615: iload 8
    //   617: istore 7
    //   619: iload 5
    //   621: istore 9
    //   623: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   626: ifeq +18 -> 644
    //   629: new 20	java/lang/StringBuilder
    //   632: dup
    //   633: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   636: astore_2
    //   637: iload 8
    //   639: istore 7
    //   641: goto -143 -> 498
    //   644: aload_0
    //   645: bipush 106
    //   647: iload 9
    //   649: iload 7
    //   651: invokestatic 365	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   654: invokevirtual 228	com/tencent/mobileqq/app/CardHandler:notifyUI	(IZLjava/lang/Object;)V
    //   657: return
    //   658: iconst_0
    //   659: istore 7
    //   661: goto -514 -> 147
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	664	0	this	CardHandler
    //   0	664	1	paramToServiceMsg	ToServiceMsg
    //   0	664	2	paramFromServiceMsg	FromServiceMsg
    //   0	664	3	paramObject	Object
    //   352	18	4	i	int
    //   4	616	5	bool1	boolean
    //   100	391	6	bool2	boolean
    //   25	635	7	bool3	boolean
    //   83	555	8	bool4	boolean
    //   96	552	9	bool5	boolean
    //   13	482	10	bool6	boolean
    //   7	425	11	bool7	boolean
    //   10	459	12	bool8	boolean
    //   357	36	13	l	long
    // Exception table:
    //   from	to	target	type
    //   102	123	438	finally
    //   131	141	438	finally
    //   155	161	438	finally
    //   169	177	438	finally
    //   185	193	438	finally
    //   201	208	438	finally
    //   216	224	438	finally
    //   232	244	438	finally
    //   252	263	438	finally
    //   292	302	438	finally
    //   318	328	438	finally
    //   336	354	438	finally
    //   385	403	438	finally
    //   411	422	438	finally
    //   447	453	438	finally
    //   457	468	438	finally
    //   102	123	442	java/lang/Exception
    //   131	141	442	java/lang/Exception
    //   155	161	442	java/lang/Exception
    //   169	177	442	java/lang/Exception
    //   185	193	442	java/lang/Exception
    //   201	208	442	java/lang/Exception
    //   216	224	442	java/lang/Exception
    //   232	244	442	java/lang/Exception
    //   252	263	442	java/lang/Exception
    //   292	302	442	java/lang/Exception
    //   318	328	442	java/lang/Exception
    //   336	354	442	java/lang/Exception
    //   385	403	442	java/lang/Exception
    //   411	422	442	java/lang/Exception
  }
  
  public void c(List<Long> paramList)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    ((StringBuilder)localObject).append("_todayVoters");
    localObject = FileUtils.readObject(((StringBuilder)localObject).toString());
    if ((localObject != null) && ((localObject instanceof ArrayList)))
    {
      localObject = (List)localObject;
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        paramList.addAll((Collection)localObject);
      }
    }
  }
  
  public void c(boolean paramBoolean)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setCareBarEnable: invoked.  enable: ");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.i("CardHandler", 2, ((StringBuilder)localObject1).toString());
    }
    notifyUI(100, true, Boolean.valueOf(paramBoolean));
    for (;;)
    {
      try
      {
        localObject1 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1279);
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(9);
        Object localObject2 = ByteBuffer.allocate(13);
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (paramBoolean == true)
        {
          s = 0;
          ((ByteBuffer)localObject2).putInt(Utils.a(l)).put((byte)0).putShort((short)1).putShort((short)-23234).putShort((short)2).putShort(s);
          ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject2).array()));
          localObject2 = createToServiceMsg("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
          ((ToServiceMsg)localObject2).setTimeout(30000L);
          ((ToServiceMsg)localObject2).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject2).extraData.putBoolean("reqFromCardHandler", true);
          sendPbReq((ToServiceMsg)localObject2);
          return;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("CardHandler", 2, "setCareBarEnable: failed. ", localException);
        }
        return;
      }
      short s = 1;
    }
  }
  
  public void d()
  {
    oidb_0x5eb.ReqBody localReqBody = new oidb_0x5eb.ReqBody();
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.add(Long.valueOf(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())));
      localReqBody.rpt_uint64_uins.set(localArrayList);
      localReqBody.uint32_flag_hide_pretty_group_owner_identity.set(1);
      sendPbReq(makeOIDBPkg("OidbSvc.0x5eb_42326", 1515, 22, localReqBody.toByteArray()));
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.w("CardHandler", 2, "send_oidb_0x5eb_40350 error", localException);
      }
    }
  }
  
  public void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleSetNotifyOnLikeRankingList success=");
      paramFromServiceMsg.append(bool);
      QLog.d("CardHandler", 2, paramFromServiceMsg.toString());
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    a(paramToServiceMsg, (byte[])paramObject, bool, false);
  }
  
  public void d(boolean paramBoolean)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setHelloLiveMessageState OPEN=");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.d("Q.profilecard.", 2, ((StringBuilder)localObject1).toString());
    }
    for (;;)
    {
      try
      {
        localObject1 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1279);
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(9);
        Object localObject2 = ByteBuffer.allocate(13);
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (paramBoolean == true)
        {
          s = 0;
          ((ByteBuffer)localObject2).putInt(Utils.a(l)).put((byte)0).putShort((short)1).putShort((short)-25181).putShort((short)2).putShort(s);
          ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject2).array()));
          localObject2 = createToServiceMsg("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
          ((ToServiceMsg)localObject2).setTimeout(30000L);
          ((ToServiceMsg)localObject2).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject2).extraData.putBoolean("helloLiveMessage", true);
          ((ToServiceMsg)localObject2).extraData.putBoolean("reqFromCardHandler", true);
          sendPbReq((ToServiceMsg)localObject2);
          return;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.", 2, "setHelloLiveMessageState ex", localException);
        }
        return;
      }
      short s = 1;
    }
  }
  
  public void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "getPartekeLikeRankingList");
    }
    oidb_0x5eb.ReqBody localReqBody = new oidb_0x5eb.ReqBody();
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.add(Long.valueOf(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())));
      localReqBody.rpt_uint64_uins.set(localArrayList);
      localReqBody.uint32_notify_partake_like_ranking_list_flag.set(1);
      sendPbReq(makeOIDBPkg("OidbSvc.0x5eb_40350", 1515, 22, localReqBody.toByteArray()));
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.w("CardHandler", 2, "send_oidb_0x5eb_40350 error", localException);
      }
    }
  }
  
  /* Error */
  public void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 101	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: istore 6
    //   6: iconst_1
    //   7: istore 11
    //   9: iconst_1
    //   10: istore 10
    //   12: iload 6
    //   14: ifeq +13 -> 27
    //   17: aload_3
    //   18: ifnull +9 -> 27
    //   21: iconst_1
    //   22: istore 6
    //   24: goto +6 -> 30
    //   27: iconst_0
    //   28: istore 6
    //   30: aload_1
    //   31: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   34: ldc_w 3248
    //   37: iconst_0
    //   38: invokevirtual 3510	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   41: istore 4
    //   43: aload_1
    //   44: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   47: ldc_w 1831
    //   50: iconst_0
    //   51: invokevirtual 3510	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   54: istore 5
    //   56: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   59: ifeq +66 -> 125
    //   62: new 20	java/lang/StringBuilder
    //   65: dup
    //   66: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   69: astore_1
    //   70: aload_1
    //   71: ldc_w 3512
    //   74: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload_1
    //   79: iload 6
    //   81: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload_1
    //   86: ldc_w 3514
    //   89: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload_1
    //   94: iload 5
    //   96: invokevirtual 391	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload_1
    //   101: ldc_w 898
    //   104: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload_1
    //   109: iload 4
    //   111: invokevirtual 391	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: ldc 113
    //   117: iconst_2
    //   118: aload_1
    //   119: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   125: iload 6
    //   127: istore 9
    //   129: iload 6
    //   131: ifeq +731 -> 862
    //   134: iload 6
    //   136: istore 7
    //   138: iload 6
    //   140: istore 8
    //   142: new 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   145: dup
    //   146: invokespecial 120	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   149: aload_3
    //   150: checkcast 122	[B
    //   153: checkcast 122	[B
    //   156: invokevirtual 126	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   159: checkcast 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   162: astore_1
    //   163: aload_1
    //   164: ifnull +781 -> 945
    //   167: iload 6
    //   169: istore 7
    //   171: iload 6
    //   173: istore 8
    //   175: aload_1
    //   176: getfield 130	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   179: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   182: ifne +763 -> 945
    //   185: iconst_1
    //   186: istore 6
    //   188: goto +3 -> 191
    //   191: iload 6
    //   193: istore 7
    //   195: iload 6
    //   197: istore 8
    //   199: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   202: ifeq +68 -> 270
    //   205: iload 6
    //   207: istore 7
    //   209: iload 6
    //   211: istore 8
    //   213: new 20	java/lang/StringBuilder
    //   216: dup
    //   217: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   220: astore_2
    //   221: iload 6
    //   223: istore 7
    //   225: iload 6
    //   227: istore 8
    //   229: aload_2
    //   230: ldc_w 3516
    //   233: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: pop
    //   237: iload 6
    //   239: istore 7
    //   241: iload 6
    //   243: istore 8
    //   245: aload_2
    //   246: iload 6
    //   248: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   251: pop
    //   252: iload 6
    //   254: istore 7
    //   256: iload 6
    //   258: istore 8
    //   260: ldc 113
    //   262: iconst_2
    //   263: aload_2
    //   264: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   267: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   270: iload 6
    //   272: istore 9
    //   274: iload 6
    //   276: ifeq +586 -> 862
    //   279: iload 6
    //   281: istore 7
    //   283: iload 6
    //   285: istore 8
    //   287: iload 6
    //   289: istore 9
    //   291: aload_1
    //   292: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   295: invokevirtual 146	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   298: ifeq +564 -> 862
    //   301: iload 6
    //   303: istore 7
    //   305: iload 6
    //   307: istore 8
    //   309: iload 6
    //   311: istore 9
    //   313: aload_1
    //   314: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   317: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   320: ifnull +542 -> 862
    //   323: iload 6
    //   325: istore 7
    //   327: iload 6
    //   329: istore 8
    //   331: aload_1
    //   332: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   335: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   338: invokevirtual 155	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   341: invokestatic 161	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   344: invokevirtual 164	java/nio/ByteBuffer:getInt	()I
    //   347: invokestatic 500	com/tencent/mobileqq/util/Utils:a	(I)J
    //   350: lstore 12
    //   352: iload 6
    //   354: istore 7
    //   356: iload 6
    //   358: istore 8
    //   360: aload_0
    //   361: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   364: invokevirtual 171	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   367: lload 12
    //   369: invokestatic 176	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   372: invokevirtual 179	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   375: ifeq +172 -> 547
    //   378: iload 6
    //   380: istore 9
    //   382: iload 4
    //   384: iflt +478 -> 862
    //   387: iload 5
    //   389: ldc_w 3517
    //   392: if_icmpne +73 -> 465
    //   395: iload 6
    //   397: istore 7
    //   399: iload 6
    //   401: istore 8
    //   403: aload_0
    //   404: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   407: invokevirtual 329	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   410: astore_1
    //   411: iload 6
    //   413: istore 7
    //   415: iload 6
    //   417: istore 8
    //   419: aload_0
    //   420: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   423: invokevirtual 247	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   426: invokevirtual 2469	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   429: astore_2
    //   430: iload 4
    //   432: iconst_1
    //   433: if_icmpeq +518 -> 951
    //   436: iload 10
    //   438: istore 9
    //   440: goto +3 -> 443
    //   443: iload 6
    //   445: istore 7
    //   447: iload 6
    //   449: istore 8
    //   451: aload_1
    //   452: aload_2
    //   453: iload 9
    //   455: invokestatic 449	com/tencent/mobileqq/app/hiddenchat/HiddenChatUtil:a	(Ljava/lang/String;Landroid/content/Context;Z)V
    //   458: iload 6
    //   460: istore 9
    //   462: goto +400 -> 862
    //   465: iload 6
    //   467: istore 9
    //   469: iload 5
    //   471: ldc_w 3518
    //   474: if_icmpne +388 -> 862
    //   477: iload 6
    //   479: istore 7
    //   481: iload 6
    //   483: istore 8
    //   485: aload_0
    //   486: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   489: invokevirtual 329	com/tencent/mobileqq/app/QQAppInterface:getCurrentUin	()Ljava/lang/String;
    //   492: astore_1
    //   493: iload 6
    //   495: istore 7
    //   497: iload 6
    //   499: istore 8
    //   501: aload_0
    //   502: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   505: invokevirtual 247	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   508: invokevirtual 2469	com/tencent/qphone/base/util/BaseApplication:getApplicationContext	()Landroid/content/Context;
    //   511: astore_2
    //   512: iload 4
    //   514: iconst_1
    //   515: if_icmpeq +442 -> 957
    //   518: iload 11
    //   520: istore 9
    //   522: goto +3 -> 525
    //   525: iload 6
    //   527: istore 7
    //   529: iload 6
    //   531: istore 8
    //   533: aload_1
    //   534: aload_2
    //   535: iload 9
    //   537: invokestatic 451	com/tencent/mobileqq/app/hiddenchat/HiddenChatUtil:b	(Ljava/lang/String;Landroid/content/Context;Z)V
    //   540: iload 6
    //   542: istore 9
    //   544: goto +318 -> 862
    //   547: iload 6
    //   549: istore 7
    //   551: iload 6
    //   553: istore 8
    //   555: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   558: ifeq +104 -> 662
    //   561: iload 6
    //   563: istore 7
    //   565: iload 6
    //   567: istore 8
    //   569: new 20	java/lang/StringBuilder
    //   572: dup
    //   573: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   576: astore_1
    //   577: iload 6
    //   579: istore 7
    //   581: iload 6
    //   583: istore 8
    //   585: aload_1
    //   586: ldc_w 3520
    //   589: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: pop
    //   593: iload 6
    //   595: istore 7
    //   597: iload 6
    //   599: istore 8
    //   601: aload_1
    //   602: aload_0
    //   603: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   606: invokevirtual 171	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   609: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: pop
    //   613: iload 6
    //   615: istore 7
    //   617: iload 6
    //   619: istore 8
    //   621: aload_1
    //   622: ldc_w 507
    //   625: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   628: pop
    //   629: iload 6
    //   631: istore 7
    //   633: iload 6
    //   635: istore 8
    //   637: aload_1
    //   638: lload 12
    //   640: invokevirtual 304	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   643: pop
    //   644: iload 6
    //   646: istore 7
    //   648: iload 6
    //   650: istore 8
    //   652: ldc 113
    //   654: iconst_2
    //   655: aload_1
    //   656: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   659: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   662: iconst_0
    //   663: istore 9
    //   665: goto +197 -> 862
    //   668: astore_1
    //   669: goto +109 -> 778
    //   672: astore_1
    //   673: iload 8
    //   675: istore 7
    //   677: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   680: ifeq +17 -> 697
    //   683: iload 8
    //   685: istore 7
    //   687: ldc 113
    //   689: iconst_2
    //   690: ldc_w 3522
    //   693: aload_1
    //   694: invokestatic 222	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   697: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   700: ifeq +65 -> 765
    //   703: new 20	java/lang/StringBuilder
    //   706: dup
    //   707: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   710: astore_1
    //   711: aload_1
    //   712: ldc_w 3516
    //   715: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   718: pop
    //   719: aload_1
    //   720: iconst_0
    //   721: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   724: pop
    //   725: aload_1
    //   726: ldc_w 3524
    //   729: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   732: pop
    //   733: aload_1
    //   734: iload 4
    //   736: invokevirtual 391	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   739: pop
    //   740: aload_1
    //   741: ldc_w 3514
    //   744: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   747: pop
    //   748: aload_1
    //   749: iload 5
    //   751: invokevirtual 391	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   754: pop
    //   755: ldc 113
    //   757: iconst_2
    //   758: aload_1
    //   759: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   762: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   765: aload_0
    //   766: bipush 105
    //   768: iconst_0
    //   769: iload 5
    //   771: invokestatic 87	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   774: invokevirtual 228	com/tencent/mobileqq/app/CardHandler:notifyUI	(IZLjava/lang/Object;)V
    //   777: return
    //   778: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   781: ifeq +66 -> 847
    //   784: new 20	java/lang/StringBuilder
    //   787: dup
    //   788: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   791: astore_2
    //   792: aload_2
    //   793: ldc_w 3516
    //   796: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   799: pop
    //   800: aload_2
    //   801: iload 7
    //   803: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   806: pop
    //   807: aload_2
    //   808: ldc_w 3524
    //   811: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   814: pop
    //   815: aload_2
    //   816: iload 4
    //   818: invokevirtual 391	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   821: pop
    //   822: aload_2
    //   823: ldc_w 3514
    //   826: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   829: pop
    //   830: aload_2
    //   831: iload 5
    //   833: invokevirtual 391	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   836: pop
    //   837: ldc 113
    //   839: iconst_2
    //   840: aload_2
    //   841: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   844: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   847: aload_0
    //   848: bipush 105
    //   850: iload 7
    //   852: iload 5
    //   854: invokestatic 87	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   857: invokevirtual 228	com/tencent/mobileqq/app/CardHandler:notifyUI	(IZLjava/lang/Object;)V
    //   860: aload_1
    //   861: athrow
    //   862: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   865: ifeq +66 -> 931
    //   868: new 20	java/lang/StringBuilder
    //   871: dup
    //   872: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   875: astore_1
    //   876: aload_1
    //   877: ldc_w 3516
    //   880: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   883: pop
    //   884: aload_1
    //   885: iload 9
    //   887: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   890: pop
    //   891: aload_1
    //   892: ldc_w 3524
    //   895: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   898: pop
    //   899: aload_1
    //   900: iload 4
    //   902: invokevirtual 391	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   905: pop
    //   906: aload_1
    //   907: ldc_w 3514
    //   910: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   913: pop
    //   914: aload_1
    //   915: iload 5
    //   917: invokevirtual 391	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   920: pop
    //   921: ldc 113
    //   923: iconst_2
    //   924: aload_1
    //   925: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   928: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   931: aload_0
    //   932: bipush 105
    //   934: iload 9
    //   936: iload 5
    //   938: invokestatic 87	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   941: invokevirtual 228	com/tencent/mobileqq/app/CardHandler:notifyUI	(IZLjava/lang/Object;)V
    //   944: return
    //   945: iconst_0
    //   946: istore 6
    //   948: goto -757 -> 191
    //   951: iconst_0
    //   952: istore 9
    //   954: goto -511 -> 443
    //   957: iconst_0
    //   958: istore 9
    //   960: goto -435 -> 525
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	963	0	this	CardHandler
    //   0	963	1	paramToServiceMsg	ToServiceMsg
    //   0	963	2	paramFromServiceMsg	FromServiceMsg
    //   0	963	3	paramObject	Object
    //   41	860	4	i	int
    //   54	883	5	j	int
    //   4	943	6	bool1	boolean
    //   136	715	7	bool2	boolean
    //   140	544	8	bool3	boolean
    //   127	832	9	bool4	boolean
    //   10	427	10	bool5	boolean
    //   7	512	11	bool6	boolean
    //   350	289	12	l	long
    // Exception table:
    //   from	to	target	type
    //   142	163	668	finally
    //   175	185	668	finally
    //   199	205	668	finally
    //   213	221	668	finally
    //   229	237	668	finally
    //   245	252	668	finally
    //   260	270	668	finally
    //   291	301	668	finally
    //   313	323	668	finally
    //   331	352	668	finally
    //   360	378	668	finally
    //   403	411	668	finally
    //   419	430	668	finally
    //   451	458	668	finally
    //   485	493	668	finally
    //   501	512	668	finally
    //   533	540	668	finally
    //   555	561	668	finally
    //   569	577	668	finally
    //   585	593	668	finally
    //   601	613	668	finally
    //   621	629	668	finally
    //   637	644	668	finally
    //   652	662	668	finally
    //   677	683	668	finally
    //   687	697	668	finally
    //   142	163	672	java/lang/Exception
    //   175	185	672	java/lang/Exception
    //   199	205	672	java/lang/Exception
    //   213	221	672	java/lang/Exception
    //   229	237	672	java/lang/Exception
    //   245	252	672	java/lang/Exception
    //   260	270	672	java/lang/Exception
    //   291	301	672	java/lang/Exception
    //   313	323	672	java/lang/Exception
    //   331	352	672	java/lang/Exception
    //   360	378	672	java/lang/Exception
    //   403	411	672	java/lang/Exception
    //   419	430	672	java/lang/Exception
    //   451	458	672	java/lang/Exception
    //   485	493	672	java/lang/Exception
    //   501	512	672	java/lang/Exception
    //   533	540	672	java/lang/Exception
    //   555	561	672	java/lang/Exception
    //   569	577	672	java/lang/Exception
    //   585	593	672	java/lang/Exception
    //   601	613	672	java/lang/Exception
    //   621	629	672	java/lang/Exception
    //   637	644	672	java/lang/Exception
    //   652	662	672	java/lang/Exception
  }
  
  public void e(boolean paramBoolean)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setShowPushNotice open=");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.d("Q.profilecard.", 2, ((StringBuilder)localObject1).toString());
    }
    for (;;)
    {
      try
      {
        localObject1 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1279);
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(this.jdField_a_of_type_Short);
        Object localObject2 = ByteBuffer.allocate(13);
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (paramBoolean)
        {
          s = 0;
          ((ByteBuffer)localObject2).putInt(Utils.a(l)).put((byte)0).putShort((short)1).putShort((short)-23332).putShort((short)2).putShort(s);
          ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject2).array()));
          localObject2 = createToServiceMsg("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
          ((ToServiceMsg)localObject2).setTimeout(30000L);
          ((ToServiceMsg)localObject2).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject2).extraData.putBoolean("uint32_req_push_notice_flag", true);
          ((ToServiceMsg)localObject2).extraData.putBoolean("reqFromCardHandler", true);
          if (QLog.isColorLevel())
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("type -23332open :");
            ((StringBuilder)localObject1).append(s);
            QLog.d("PushNotise", 2, ((StringBuilder)localObject1).toString());
          }
          sendPbReq((ToServiceMsg)localObject2);
          return;
        }
      }
      catch (Exception localException)
      {
        QLog.d("Q.profilecard.", 2, localException, new Object[0]);
        return;
      }
      short s = 1;
    }
  }
  
  public void f()
  {
    if (QLog.isColorLevel()) {
      QLog.i("DailySignIn", 2, "getSigniOperat ");
    }
    sendPbReq(makeOIDBPkg("OidbSvc.0xe26", 3622, 0, new oidb_0xe26.ReqBody().toByteArray()));
  }
  
  /* Error */
  public void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 101	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: ifeq +13 -> 17
    //   7: aload_3
    //   8: ifnull +9 -> 17
    //   11: iconst_1
    //   12: istore 5
    //   14: goto +6 -> 20
    //   17: iconst_0
    //   18: istore 5
    //   20: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   23: ifeq +36 -> 59
    //   26: new 20	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   33: astore_2
    //   34: aload_2
    //   35: ldc_w 3538
    //   38: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload_2
    //   43: iload 5
    //   45: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: ldc 113
    //   51: iconst_2
    //   52: aload_2
    //   53: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: aload_1
    //   60: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   63: ldc_w 2887
    //   66: ldc_w 460
    //   69: invokevirtual 464	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   72: astore_2
    //   73: aload_1
    //   74: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   77: ldc_w 458
    //   80: ldc_w 460
    //   83: invokevirtual 464	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   86: astore 11
    //   88: iload 5
    //   90: istore 8
    //   92: iload 5
    //   94: ifeq +639 -> 733
    //   97: iload 5
    //   99: istore 6
    //   101: iload 5
    //   103: istore 7
    //   105: new 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   108: dup
    //   109: invokespecial 120	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   112: aload_3
    //   113: checkcast 122	[B
    //   116: checkcast 122	[B
    //   119: invokevirtual 126	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   122: checkcast 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   125: astore_3
    //   126: aload_3
    //   127: ifnull +688 -> 815
    //   130: iload 5
    //   132: istore 6
    //   134: iload 5
    //   136: istore 7
    //   138: aload_3
    //   139: getfield 130	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   142: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   145: ifne +670 -> 815
    //   148: iconst_1
    //   149: istore 5
    //   151: goto +3 -> 154
    //   154: iload 5
    //   156: istore 6
    //   158: iload 5
    //   160: istore 7
    //   162: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   165: ifeq +72 -> 237
    //   168: iload 5
    //   170: istore 6
    //   172: iload 5
    //   174: istore 7
    //   176: new 20	java/lang/StringBuilder
    //   179: dup
    //   180: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   183: astore 12
    //   185: iload 5
    //   187: istore 6
    //   189: iload 5
    //   191: istore 7
    //   193: aload 12
    //   195: ldc_w 3540
    //   198: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: pop
    //   202: iload 5
    //   204: istore 6
    //   206: iload 5
    //   208: istore 7
    //   210: aload 12
    //   212: iload 5
    //   214: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   217: pop
    //   218: iload 5
    //   220: istore 6
    //   222: iload 5
    //   224: istore 7
    //   226: ldc 113
    //   228: iconst_2
    //   229: aload 12
    //   231: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   237: iload 5
    //   239: istore 8
    //   241: iload 5
    //   243: ifeq +490 -> 733
    //   246: iload 5
    //   248: istore 6
    //   250: iload 5
    //   252: istore 7
    //   254: iload 5
    //   256: istore 8
    //   258: aload_3
    //   259: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   262: invokevirtual 146	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   265: ifeq +468 -> 733
    //   268: iload 5
    //   270: istore 6
    //   272: iload 5
    //   274: istore 7
    //   276: iload 5
    //   278: istore 8
    //   280: aload_3
    //   281: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   284: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   287: ifnull +446 -> 733
    //   290: iload 5
    //   292: istore 6
    //   294: iload 5
    //   296: istore 7
    //   298: aload_3
    //   299: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   302: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   305: invokevirtual 155	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   308: invokestatic 161	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   311: invokevirtual 164	java/nio/ByteBuffer:getInt	()I
    //   314: invokestatic 500	com/tencent/mobileqq/util/Utils:a	(I)J
    //   317: lstore 9
    //   319: iload 5
    //   321: istore 6
    //   323: iload 5
    //   325: istore 7
    //   327: aload_0
    //   328: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   331: invokevirtual 171	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   334: lload 9
    //   336: invokestatic 176	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   339: invokevirtual 179	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   342: ifeq +72 -> 414
    //   345: iload 5
    //   347: istore 6
    //   349: iload 5
    //   351: istore 7
    //   353: aload_1
    //   354: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   357: ldc_w 2885
    //   360: ldc_w 533
    //   363: invokevirtual 3510	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   366: istore 4
    //   368: iload 5
    //   370: istore 8
    //   372: iload 4
    //   374: iflt +359 -> 733
    //   377: iload 5
    //   379: istore 6
    //   381: iload 5
    //   383: istore 7
    //   385: aload_0
    //   386: getfield 77	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   389: invokevirtual 438	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   392: invokevirtual 444	mqq/app/MobileQQ:getApplicationContext	()Landroid/content/Context;
    //   395: aconst_null
    //   396: ldc_w 473
    //   399: ldc_w 475
    //   402: iload 4
    //   404: invokestatic 481	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:writeValueForInt	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   407: iload 5
    //   409: istore 8
    //   411: goto +322 -> 733
    //   414: iload 5
    //   416: istore 6
    //   418: iload 5
    //   420: istore 7
    //   422: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   425: ifeq +104 -> 529
    //   428: iload 5
    //   430: istore 6
    //   432: iload 5
    //   434: istore 7
    //   436: new 20	java/lang/StringBuilder
    //   439: dup
    //   440: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   443: astore_3
    //   444: iload 5
    //   446: istore 6
    //   448: iload 5
    //   450: istore 7
    //   452: aload_3
    //   453: ldc_w 3542
    //   456: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: pop
    //   460: iload 5
    //   462: istore 6
    //   464: iload 5
    //   466: istore 7
    //   468: aload_3
    //   469: aload_0
    //   470: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   473: invokevirtual 171	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   476: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: pop
    //   480: iload 5
    //   482: istore 6
    //   484: iload 5
    //   486: istore 7
    //   488: aload_3
    //   489: ldc_w 507
    //   492: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: pop
    //   496: iload 5
    //   498: istore 6
    //   500: iload 5
    //   502: istore 7
    //   504: aload_3
    //   505: lload 9
    //   507: invokevirtual 304	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   510: pop
    //   511: iload 5
    //   513: istore 6
    //   515: iload 5
    //   517: istore 7
    //   519: ldc 113
    //   521: iconst_2
    //   522: aload_3
    //   523: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   526: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   529: iconst_0
    //   530: istore 8
    //   532: goto +201 -> 733
    //   535: astore_3
    //   536: goto +108 -> 644
    //   539: astore_3
    //   540: iload 7
    //   542: istore 6
    //   544: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   547: ifeq +17 -> 564
    //   550: iload 7
    //   552: istore 6
    //   554: ldc 113
    //   556: iconst_2
    //   557: ldc_w 3544
    //   560: aload_3
    //   561: invokestatic 222	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   564: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   567: ifeq +56 -> 623
    //   570: new 20	java/lang/StringBuilder
    //   573: dup
    //   574: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   577: astore_3
    //   578: aload_3
    //   579: ldc_w 3540
    //   582: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: pop
    //   586: aload_3
    //   587: iconst_0
    //   588: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   591: pop
    //   592: aload_3
    //   593: ldc 224
    //   595: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: pop
    //   599: aload_3
    //   600: aload_1
    //   601: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   604: ldc 202
    //   606: invokevirtual 208	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   609: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   612: pop
    //   613: ldc 113
    //   615: iconst_2
    //   616: aload_3
    //   617: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   620: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   623: aload_0
    //   624: bipush 94
    //   626: iconst_0
    //   627: iconst_2
    //   628: anewarray 173	java/lang/String
    //   631: dup
    //   632: iconst_0
    //   633: aload_2
    //   634: aastore
    //   635: dup
    //   636: iconst_1
    //   637: aload 11
    //   639: aastore
    //   640: invokevirtual 228	com/tencent/mobileqq/app/CardHandler:notifyUI	(IZLjava/lang/Object;)V
    //   643: return
    //   644: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   647: ifeq +63 -> 710
    //   650: new 20	java/lang/StringBuilder
    //   653: dup
    //   654: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   657: astore 12
    //   659: aload 12
    //   661: ldc_w 3540
    //   664: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   667: pop
    //   668: aload 12
    //   670: iload 6
    //   672: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   675: pop
    //   676: aload 12
    //   678: ldc 224
    //   680: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   683: pop
    //   684: aload 12
    //   686: aload_1
    //   687: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   690: ldc 202
    //   692: invokevirtual 208	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   695: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   698: pop
    //   699: ldc 113
    //   701: iconst_2
    //   702: aload 12
    //   704: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   707: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   710: aload_0
    //   711: bipush 94
    //   713: iload 6
    //   715: iconst_2
    //   716: anewarray 173	java/lang/String
    //   719: dup
    //   720: iconst_0
    //   721: aload_2
    //   722: aastore
    //   723: dup
    //   724: iconst_1
    //   725: aload 11
    //   727: aastore
    //   728: invokevirtual 228	com/tencent/mobileqq/app/CardHandler:notifyUI	(IZLjava/lang/Object;)V
    //   731: aload_3
    //   732: athrow
    //   733: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   736: ifeq +57 -> 793
    //   739: new 20	java/lang/StringBuilder
    //   742: dup
    //   743: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   746: astore_3
    //   747: aload_3
    //   748: ldc_w 3540
    //   751: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   754: pop
    //   755: aload_3
    //   756: iload 8
    //   758: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   761: pop
    //   762: aload_3
    //   763: ldc 224
    //   765: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   768: pop
    //   769: aload_3
    //   770: aload_1
    //   771: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   774: ldc 202
    //   776: invokevirtual 208	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   779: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   782: pop
    //   783: ldc 113
    //   785: iconst_2
    //   786: aload_3
    //   787: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   790: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   793: aload_0
    //   794: bipush 94
    //   796: iload 8
    //   798: iconst_2
    //   799: anewarray 173	java/lang/String
    //   802: dup
    //   803: iconst_0
    //   804: aload_2
    //   805: aastore
    //   806: dup
    //   807: iconst_1
    //   808: aload 11
    //   810: aastore
    //   811: invokevirtual 228	com/tencent/mobileqq/app/CardHandler:notifyUI	(IZLjava/lang/Object;)V
    //   814: return
    //   815: iconst_0
    //   816: istore 5
    //   818: goto -664 -> 154
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	821	0	this	CardHandler
    //   0	821	1	paramToServiceMsg	ToServiceMsg
    //   0	821	2	paramFromServiceMsg	FromServiceMsg
    //   0	821	3	paramObject	Object
    //   366	37	4	i	int
    //   12	805	5	bool1	boolean
    //   99	615	6	bool2	boolean
    //   103	448	7	bool3	boolean
    //   90	707	8	bool4	boolean
    //   317	189	9	l	long
    //   86	723	11	str	String
    //   183	520	12	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   105	126	535	finally
    //   138	148	535	finally
    //   162	168	535	finally
    //   176	185	535	finally
    //   193	202	535	finally
    //   210	218	535	finally
    //   226	237	535	finally
    //   258	268	535	finally
    //   280	290	535	finally
    //   298	319	535	finally
    //   327	345	535	finally
    //   353	368	535	finally
    //   385	407	535	finally
    //   422	428	535	finally
    //   436	444	535	finally
    //   452	460	535	finally
    //   468	480	535	finally
    //   488	496	535	finally
    //   504	511	535	finally
    //   519	529	535	finally
    //   544	550	535	finally
    //   554	564	535	finally
    //   105	126	539	java/lang/Exception
    //   138	148	539	java/lang/Exception
    //   162	168	539	java/lang/Exception
    //   176	185	539	java/lang/Exception
    //   193	202	539	java/lang/Exception
    //   210	218	539	java/lang/Exception
    //   226	237	539	java/lang/Exception
    //   258	268	539	java/lang/Exception
    //   280	290	539	java/lang/Exception
    //   298	319	539	java/lang/Exception
    //   327	345	539	java/lang/Exception
    //   353	368	539	java/lang/Exception
    //   385	407	539	java/lang/Exception
    //   422	428	539	java/lang/Exception
    //   436	444	539	java/lang/Exception
    //   452	460	539	java/lang/Exception
    //   468	480	539	java/lang/Exception
    //   488	496	539	java/lang/Exception
    //   504	511	539	java/lang/Exception
    //   519	529	539	java/lang/Exception
  }
  
  public void f(boolean paramBoolean)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setPartakeLikeRankingList OPEN=");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.d("CardHandler", 2, ((StringBuilder)localObject1).toString());
    }
    for (;;)
    {
      try
      {
        localObject1 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1279);
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(this.jdField_a_of_type_Short);
        Object localObject2 = ByteBuffer.allocate(13);
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (paramBoolean)
        {
          s = 0;
          ((ByteBuffer)localObject2).putInt(Utils.a(l)).put((byte)0).putShort((short)1).putShort((short)-25186).putShort((short)2).putShort(s);
          ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject2).array()));
          localObject2 = createToServiceMsg("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
          ((ToServiceMsg)localObject2).setTimeout(30000L);
          ((ToServiceMsg)localObject2).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject2).extraData.putBoolean("isSetPartakeLikeRankingList", true);
          ((ToServiceMsg)localObject2).extraData.putBoolean("reqFromCardHandler", true);
          sendPbReq((ToServiceMsg)localObject2);
          return;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.", 2, "setPartakeLikeRankingList ex", localException);
        }
        return;
      }
      short s = 1;
    }
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "getNotifyOnLikeRankingList");
    }
    oidb_0x5eb.ReqBody localReqBody = new oidb_0x5eb.ReqBody();
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.add(Long.valueOf(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())));
      localReqBody.rpt_uint64_uins.set(localArrayList);
      localReqBody.uint32_notify_on_like_ranking_list_flag.set(1);
      sendPbReq(makeOIDBPkg("OidbSvc.0x5eb_42092", 1515, 22, localReqBody.toByteArray()));
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.w("CardHandler", 2, "send_oidb_0x5eb_42092 error", localException);
      }
    }
  }
  
  /* Error */
  public void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 101	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: ifeq +13 -> 17
    //   7: aload_3
    //   8: ifnull +9 -> 17
    //   11: iconst_1
    //   12: istore 5
    //   14: goto +6 -> 20
    //   17: iconst_0
    //   18: istore 5
    //   20: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   23: ifeq +37 -> 60
    //   26: new 20	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   33: astore_2
    //   34: aload_2
    //   35: ldc_w 3555
    //   38: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload_2
    //   43: iload 5
    //   45: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: ldc_w 368
    //   52: iconst_2
    //   53: aload_2
    //   54: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   60: iload 5
    //   62: istore 4
    //   64: iload 5
    //   66: ifeq +357 -> 423
    //   69: iload 5
    //   71: istore 6
    //   73: iload 5
    //   75: istore 4
    //   77: new 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   80: dup
    //   81: invokespecial 120	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   84: aload_3
    //   85: checkcast 122	[B
    //   88: checkcast 122	[B
    //   91: invokevirtual 126	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   94: checkcast 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   97: astore_2
    //   98: iload 5
    //   100: istore 6
    //   102: iload 5
    //   104: istore 4
    //   106: aload_2
    //   107: getfield 130	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   110: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   113: ifne +341 -> 454
    //   116: iconst_1
    //   117: istore 5
    //   119: goto +3 -> 122
    //   122: iload 5
    //   124: istore 6
    //   126: iload 5
    //   128: istore 4
    //   130: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   133: ifeq +104 -> 237
    //   136: iload 5
    //   138: istore 6
    //   140: iload 5
    //   142: istore 4
    //   144: new 20	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   151: astore_3
    //   152: iload 5
    //   154: istore 6
    //   156: iload 5
    //   158: istore 4
    //   160: aload_3
    //   161: ldc_w 3557
    //   164: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   167: pop
    //   168: iload 5
    //   170: istore 6
    //   172: iload 5
    //   174: istore 4
    //   176: aload_3
    //   177: iload 5
    //   179: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: iload 5
    //   185: istore 6
    //   187: iload 5
    //   189: istore 4
    //   191: aload_3
    //   192: ldc_w 3559
    //   195: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: pop
    //   199: iload 5
    //   201: istore 6
    //   203: iload 5
    //   205: istore 4
    //   207: aload_3
    //   208: aload_2
    //   209: getfield 130	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   212: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   215: invokevirtual 391	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: iload 5
    //   221: istore 6
    //   223: iload 5
    //   225: istore 4
    //   227: ldc 113
    //   229: iconst_2
    //   230: aload_3
    //   231: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   237: iload 5
    //   239: istore 6
    //   241: iload 5
    //   243: istore 4
    //   245: aload_0
    //   246: iload 5
    //   248: aload_2
    //   249: invokespecial 1489	com/tencent/mobileqq/app/CardHandler:a	(ZLtencent/im/oidb/oidb_sso$OIDBSSOPkg;)Z
    //   252: istore 5
    //   254: iload 5
    //   256: istore 4
    //   258: goto +165 -> 423
    //   261: astore_2
    //   262: goto +99 -> 361
    //   265: astore_2
    //   266: iload 4
    //   268: istore 6
    //   270: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   273: ifeq +17 -> 290
    //   276: iload 4
    //   278: istore 6
    //   280: ldc 113
    //   282: iconst_2
    //   283: ldc_w 3561
    //   286: aload_2
    //   287: invokestatic 222	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   290: iload 4
    //   292: istore 5
    //   294: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   297: ifeq +147 -> 444
    //   300: new 20	java/lang/StringBuilder
    //   303: dup
    //   304: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   307: astore_2
    //   308: aload_2
    //   309: ldc_w 3557
    //   312: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   315: pop
    //   316: aload_2
    //   317: iload 4
    //   319: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   322: pop
    //   323: aload_2
    //   324: ldc 224
    //   326: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: pop
    //   330: aload_2
    //   331: aload_1
    //   332: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   335: ldc 202
    //   337: invokevirtual 208	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   340: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   343: pop
    //   344: ldc 113
    //   346: iconst_2
    //   347: aload_2
    //   348: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   351: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   354: iload 4
    //   356: istore 5
    //   358: goto +86 -> 444
    //   361: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   364: ifeq +57 -> 421
    //   367: new 20	java/lang/StringBuilder
    //   370: dup
    //   371: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   374: astore_3
    //   375: aload_3
    //   376: ldc_w 3557
    //   379: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: pop
    //   383: aload_3
    //   384: iload 6
    //   386: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   389: pop
    //   390: aload_3
    //   391: ldc 224
    //   393: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: pop
    //   397: aload_3
    //   398: aload_1
    //   399: getfield 200	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   402: ldc 202
    //   404: invokevirtual 208	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   407: invokevirtual 111	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   410: pop
    //   411: ldc 113
    //   413: iconst_2
    //   414: aload_3
    //   415: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   418: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   421: aload_2
    //   422: athrow
    //   423: iload 4
    //   425: istore 5
    //   427: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   430: ifeq +14 -> 444
    //   433: new 20	java/lang/StringBuilder
    //   436: dup
    //   437: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   440: astore_2
    //   441: goto -133 -> 308
    //   444: aload_0
    //   445: bipush 79
    //   447: iload 5
    //   449: aconst_null
    //   450: invokevirtual 228	com/tencent/mobileqq/app/CardHandler:notifyUI	(IZLjava/lang/Object;)V
    //   453: return
    //   454: iconst_0
    //   455: istore 5
    //   457: goto -335 -> 122
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	460	0	this	CardHandler
    //   0	460	1	paramToServiceMsg	ToServiceMsg
    //   0	460	2	paramFromServiceMsg	FromServiceMsg
    //   0	460	3	paramObject	Object
    //   62	362	4	bool1	boolean
    //   12	444	5	bool2	boolean
    //   71	314	6	bool3	boolean
    // Exception table:
    //   from	to	target	type
    //   77	98	261	finally
    //   106	116	261	finally
    //   130	136	261	finally
    //   144	152	261	finally
    //   160	168	261	finally
    //   176	183	261	finally
    //   191	199	261	finally
    //   207	219	261	finally
    //   227	237	261	finally
    //   245	254	261	finally
    //   270	276	261	finally
    //   280	290	261	finally
    //   77	98	265	java/lang/Exception
    //   106	116	265	java/lang/Exception
    //   130	136	265	java/lang/Exception
    //   144	152	265	java/lang/Exception
    //   160	168	265	java/lang/Exception
    //   176	183	265	java/lang/Exception
    //   191	199	265	java/lang/Exception
    //   207	219	265	java/lang/Exception
    //   227	237	265	java/lang/Exception
    //   245	254	265	java/lang/Exception
  }
  
  public void g(boolean paramBoolean)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("setPrettyTroopOwnerFlag OPEN=");
    ((StringBuilder)localObject1).append(paramBoolean);
    QLog.e("vip_pretty.CardHandler", 1, ((StringBuilder)localObject1).toString());
    for (;;)
    {
      try
      {
        localObject1 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1279);
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(this.jdField_a_of_type_Short);
        ((oidb_sso.OIDBSSOPkg)localObject1).str_client_version.set(AppSetting.f());
        Object localObject2 = ByteBuffer.allocate(13);
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (paramBoolean)
        {
          s = 0;
          ((ByteBuffer)localObject2).putInt(Utils.a(l)).put((byte)0).putShort((short)1).putShort((short)-23211).putShort((short)2).putShort(s);
          ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject2).array()));
          localObject2 = createToServiceMsg("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
          ((ToServiceMsg)localObject2).setTimeout(30000L);
          ((ToServiceMsg)localObject2).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject2).extraData.putBoolean("setPrettyTroopOwnerFlag", true);
          ((ToServiceMsg)localObject2).extraData.putBoolean("reqFromCardHandler", true);
          sendPbReq((ToServiceMsg)localObject2);
          return;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.", 2, "setPrettyTroopOwnerFlag ex", localException);
        }
        return;
      }
      short s = 1;
    }
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("MCardSvc.ReqSetCard");
      this.allowCmdSet.add("SummaryCard.SetLabel");
      this.allowCmdSet.add("SummaryCard.LikeIt");
      this.allowCmdSet.add("MCardSvc.ReqGetCardSwitch");
      this.allowCmdSet.add("MCardSvc.ReqSetCardSwitch");
      this.allowCmdSet.add("VisitorSvc.ReqDeleteVisitorRecord");
      this.allowCmdSet.add("VisitorSvc.ReqFavorite");
      this.allowCmdSet.add("VisitorSvc.ReqGetVoterList");
      this.allowCmdSet.add("VisitorSvc.ReqGetFavoriteList");
      this.allowCmdSet.add("MCardSvc.ReqDelFace");
      this.allowCmdSet.add("AccostSvc.ClientMsg");
      this.allowCmdSet.add("AccostSvc.SvrMsg");
      this.allowCmdSet.add("MCardSvc.ReqPicSafetyCheck");
      this.allowCmdSet.add("OidbSvc.0x490_100");
      this.allowCmdSet.add("OidbSvc.0x491_100");
      this.allowCmdSet.add("SQQzoneSvc.getCover");
      this.allowCmdSet.add("OidbSvc.0x4ff_9");
      this.allowCmdSet.add("OidbSvc.0x5ea_2");
      this.allowCmdSet.add("OidbSvc.0x5ea_3");
      this.allowCmdSet.add("OidbSvc.0x5ea_4");
      this.allowCmdSet.add("OidbSvc.0x66b");
      this.allowCmdSet.add("OidbSvc.0x5eb_22");
      this.allowCmdSet.add("OidbSvc.0x5eb_15");
      this.allowCmdSet.add("OidbSvc.0x7ba");
      this.allowCmdSet.add("OidbSvc.0x5eb_42092");
      this.allowCmdSet.add("OidbSvc.0x5eb_40350");
      this.allowCmdSet.add("OidbSvc.0x922");
      this.allowCmdSet.add("OidbSvc.0xe26");
      this.allowCmdSet.add("OidbSvc.0xa28");
      this.allowCmdSet.add("OidbSvc.0xac6");
      this.allowCmdSet.add("OidbSvc.0x7a8");
      this.allowCmdSet.add("OidbSvc.0xc33_42220");
      this.allowCmdSet.add("OidbSvc.0xcd5");
      this.allowCmdSet.add("OidbSvc.0xd8a");
      this.allowCmdSet.add("OidbSvc.0xd2d");
      this.allowCmdSet.add("OidbSvc.0x4ff_42315");
      this.allowCmdSet.add("OidbSvc.0x5eb_42326");
      this.allowCmdSet.add("OidbSvc.0x5eb_15(2)");
    }
    return this.allowCmdSet;
  }
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "getConnectionsSwitch");
    }
    try
    {
      oidb_0x5eb.ReqBody localReqBody = new oidb_0x5eb.ReqBody();
      localReqBody.rpt_uint64_uins.add(Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin()));
      localReqBody.uint32_req_connections_switch_id.set(1);
      sendPbReq(makeOIDBPkg("OidbSvc.0x5eb_15(2)", 1515, 15, localReqBody.toByteArray()));
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "getConnectionsSwitch ex", localException);
      }
    }
  }
  
  public void h(boolean paramBoolean)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setNotifyOnLikeRankingList OPEN=");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.d("CardHandler", 2, ((StringBuilder)localObject1).toString());
    }
    for (;;)
    {
      try
      {
        localObject1 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1279);
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(this.jdField_a_of_type_Short);
        Object localObject2 = ByteBuffer.allocate(13);
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (paramBoolean)
        {
          s = 0;
          ((ByteBuffer)localObject2).putInt(Utils.a(l)).put((byte)0).putShort((short)1).putShort((short)-23444).putShort((short)2).putShort(s);
          ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject2).array()));
          localObject2 = createToServiceMsg("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
          ((ToServiceMsg)localObject2).setTimeout(30000L);
          ((ToServiceMsg)localObject2).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject2).extraData.putBoolean("isSetNotifyOnLikeRankingList", true);
          ((ToServiceMsg)localObject2).extraData.putBoolean("reqFromCardHandler", true);
          sendPbReq((ToServiceMsg)localObject2);
          return;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.", 2, "setNotifyOnLikeRankingList ex", localException);
        }
        return;
      }
      short s = 1;
    }
  }
  
  public void i()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "getHiddenSwitch");
    }
    try
    {
      oidb_0x5eb.ReqBody localReqBody = new oidb_0x5eb.ReqBody();
      long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localReqBody.rpt_uint64_uins.add(Long.valueOf(l));
      localReqBody.uint32_req_hidden_session_switch.set(1);
      localReqBody.uint32_req_hidden_session_video_switch.set(1);
      sendPbReq(makeOIDBPkg("OidbSvc.0x5eb_15", 1515, 15, localReqBody.toByteArray()));
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "getHiddenSwitch ex", localException);
      }
    }
  }
  
  public void i(boolean paramBoolean)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setLoginDaysSwitch OPEN=");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.d("Q.profilecard.", 2, ((StringBuilder)localObject1).toString());
    }
    for (;;)
    {
      try
      {
        localObject1 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1279);
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(this.jdField_a_of_type_Short);
        Object localObject2 = ByteBuffer.allocate(13);
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (paramBoolean == true)
        {
          s = 1;
          ((ByteBuffer)localObject2).putInt(Utils.a(l)).put((byte)0).putShort((short)1).putShort((short)-25044).putShort((short)2).putShort(s);
          ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject2).array()));
          localObject2 = createToServiceMsg("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
          ((ToServiceMsg)localObject2).setTimeout(30000L);
          ((ToServiceMsg)localObject2).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject2).extraData.putBoolean("isSetLoginDays", true);
          ((ToServiceMsg)localObject2).extraData.putBoolean("reqFromCardHandler", true);
          sendPbReq((ToServiceMsg)localObject2);
          return;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.", 2, "getLoginDaysSwitch ex", localException);
        }
        return;
      }
      short s = 0;
    }
  }
  
  public void j()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "AfterSyncMsg doAfterLogin&doOnReconnect::sendGlobalRingIdRequest");
    }
    try
    {
      Object localObject = new oidb_0x5eb.ReqBody();
      long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      ((oidb_0x5eb.ReqBody)localObject).rpt_uint64_uins.add(Long.valueOf(l));
      ((oidb_0x5eb.ReqBody)localObject).uint32_req_global_ring_id.set(1);
      localObject = makeOIDBPkg("OidbSvc.0x5eb_15", 1515, 15, ((oidb_0x5eb.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putBoolean("sendGlobalRingIdRequest", true);
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "sendGlobalRingIdRequest ex ", localException);
      }
    }
  }
  
  public void j(boolean paramBoolean)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("setCalReactiveSwitch OPEN=");
    ((StringBuilder)localObject1).append(paramBoolean);
    QLog.d("Q.profilecard.", 1, ((StringBuilder)localObject1).toString());
    for (;;)
    {
      try
      {
        localObject1 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1279);
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(this.jdField_a_of_type_Short);
        Object localObject2 = ByteBuffer.allocate(13);
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (paramBoolean == true)
        {
          s = 1;
          ((ByteBuffer)localObject2).putInt(Utils.a(l)).put((byte)0).putShort((short)1).putShort((short)-25007).putShort((short)2).putShort(s);
          ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject2).array()));
          localObject2 = createToServiceMsg("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
          ((ToServiceMsg)localObject2).setTimeout(30000L);
          ((ToServiceMsg)localObject2).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject2).extraData.putBoolean("isSetCalReactiveDays", true);
          ((ToServiceMsg)localObject2).extraData.putBoolean("reqFromCardHandler", true);
          sendPbReq((ToServiceMsg)localObject2);
          return;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.", 2, "setCalReactiveSwitch ex", localException);
        }
        return;
      }
      short s = 0;
    }
  }
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "getNotDisturb");
    }
    try
    {
      Object localObject = new oidb_0x5eb.ReqBody();
      long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      ((oidb_0x5eb.ReqBody)localObject).rpt_uint64_uins.add(Long.valueOf(l));
      ((oidb_0x5eb.ReqBody)localObject).uint32_do_not_disturb_mode_time.set(1);
      localObject = makeOIDBPkg("OidbSvc.0x5eb_22", 1515, 22, ((oidb_0x5eb.ReqBody)localObject).toByteArray());
      sendPbReq((ToServiceMsg)localObject);
      Bundle localBundle = new Bundle();
      localBundle.putString("source_from", "not_disturb_from_cardhandler");
      localBundle.putBoolean("uint32_do_not_disturb_mode_time", true);
      ((ToServiceMsg)localObject).extraData.putAll(localBundle);
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "getNotDisturb ex", localException);
      }
    }
  }
  
  public void k(boolean paramBoolean)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setMedalSwitch OPEN=");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.d("Q.profilecard.", 2, ((StringBuilder)localObject1).toString());
    }
    for (;;)
    {
      try
      {
        localObject1 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1279);
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(this.jdField_a_of_type_Short);
        Object localObject2 = ByteBuffer.allocate(13);
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (paramBoolean)
        {
          s = 1;
          ((ByteBuffer)localObject2).putInt(Utils.a(l)).put((byte)0).putShort((short)1).putShort(this.jdField_b_of_type_Short).putShort((short)2).putShort(s);
          ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject2).array()));
          localObject2 = createToServiceMsg("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
          ((ToServiceMsg)localObject2).setTimeout(30000L);
          ((ToServiceMsg)localObject2).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject2).extraData.putBoolean("uint32_req_medalwall_flag", true);
          ((ToServiceMsg)localObject2).extraData.putBoolean("reqFromCardHandler", true);
          sendPbReq((ToServiceMsg)localObject2);
          return;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.", 2, "setMedalSwitch ex", localException);
        }
        return;
      }
      short s = 0;
    }
  }
  
  public void l()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("MedalWallMng", 4, "getSelfNewObtainedMedalWall");
    }
    long l;
    try
    {
      l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      l = 0L;
    }
    if (l == 0L) {
      return;
    }
    Object localObject = new cmd0x7a8.ReqBody();
    ((cmd0x7a8.ReqBody)localObject).uint64_req_uin.set(l);
    ((cmd0x7a8.ReqBody)localObject).uint32_sort_type.set(1);
    ((cmd0x7a8.ReqBody)localObject).uint32_only_obtained.set(1);
    ((cmd0x7a8.ReqBody)localObject).uint32_only_new.set(1);
    localObject = makeOIDBPkg("OidbSvc.0x7a8", 1960, 5, ((cmd0x7a8.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putString("from", "getSelfNewObtainedMedalWall");
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void l(boolean paramBoolean)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setActivateFriendSwitch OPEN=");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.d("Q.profilecard.", 2, ((StringBuilder)localObject1).toString());
    }
    for (;;)
    {
      try
      {
        localObject1 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1279);
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(this.jdField_a_of_type_Short);
        Object localObject2 = ByteBuffer.allocate(13);
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (paramBoolean == true)
        {
          s = 0;
          ((ByteBuffer)localObject2).putInt(Utils.a(l)).put((byte)0).putShort((short)1).putShort((short)-25031).putShort((short)2).putShort(s);
          ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject2).array()));
          localObject2 = createToServiceMsg("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
          ((ToServiceMsg)localObject2).setTimeout(30000L);
          ((ToServiceMsg)localObject2).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject2).extraData.putBoolean("isSetActivateFriend", true);
          ((ToServiceMsg)localObject2).extraData.putBoolean("reqFromCardHandler", true);
          sendPbReq((ToServiceMsg)localObject2);
          return;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.", 2, "setActivateFriendSwitch ex", localException);
        }
        return;
      }
      short s = 1;
    }
  }
  
  public void m()
  {
    if (QLog.isColorLevel())
    {
      Locale localLocale = Locale.getDefault();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getBindPhoneCardExtInfo uin:");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
      QLog.d("CardHandler", 2, String.format(localLocale, localStringBuilder.toString(), new Object[0]));
    }
    sendPbReq(makeOIDBPkg("OidbSvc.0xc33_42220", 3123, 0, new oidb_0xc33.ReqBody().toByteArray()));
  }
  
  public void m(boolean paramBoolean)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setBabyQSwitch OPEN=");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.d("Q.profilecard.", 2, ((StringBuilder)localObject1).toString());
    }
    for (;;)
    {
      try
      {
        localObject1 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1279);
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(this.jdField_a_of_type_Short);
        Object localObject2 = ByteBuffer.allocate(13);
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (paramBoolean != true) {
          break label281;
        }
        s = 0;
        ((ByteBuffer)localObject2).putInt(Utils.a(l)).put((byte)0).putShort((short)1).putShort((short)-25008).putShort((short)2).putShort(s);
        ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject2).array()));
        localObject2 = createToServiceMsg("OidbSvc.0x4ff_9");
        ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
        ((ToServiceMsg)localObject2).setTimeout(30000L);
        ((ToServiceMsg)localObject2).extraData.putBoolean("switch", paramBoolean);
        ((ToServiceMsg)localObject2).extraData.putBoolean("isSetBabyQSwitch", true);
        ((ToServiceMsg)localObject2).extraData.putBoolean("reqFromCardHandler", true);
        sendPbReq((ToServiceMsg)localObject2);
        if (paramBoolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).edit().putInt("babyQ_drag_count", 0).commit();
          return;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.", 2, "setBabyQSwitch ex", localException);
        }
      }
      return;
      label281:
      short s = 1;
    }
  }
  
  public void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "getAutoReplyList");
    }
    Object localObject = new oidb_cmd0xcd5.ReqBody();
    oidb_cmd0xcd5.GetDataReq localGetDataReq = new oidb_cmd0xcd5.GetDataReq();
    localGetDataReq.query_type.set(1);
    ((oidb_cmd0xcd5.ReqBody)localObject).getdata_req.set(localGetDataReq);
    ((oidb_cmd0xcd5.ReqBody)localObject).service_type.set(1);
    localObject = makeOIDBPkg("OidbSvc.0xcd5", 3285, 0, ((oidb_cmd0xcd5.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putBoolean("isGetList", true);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void n(boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setDisplayThirdQQSwitch OPEN=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("Q.profilecard.", 2, ((StringBuilder)localObject).toString());
    }
    for (;;)
    {
      try
      {
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (paramBoolean == true)
        {
          s = 0;
          localObject = new byte[13];
          PkgTools.dWord2Byte((byte[])localObject, 0, l);
          localObject[4] = 0;
          PkgTools.word2Byte((byte[])localObject, 5, (short)1);
          PkgTools.dWordTo2Bytes((byte[])localObject, 7, 40348);
          PkgTools.word2Byte((byte[])localObject, 9, (short)2);
          PkgTools.word2Byte((byte[])localObject, 11, s);
          localObject = makeOIDBPkg("OidbSvc.0x4ff_9", 1279, 9, (byte[])localObject);
          ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject).extraData.putBoolean("isSetDisplayThirdQQSwitch", true);
          ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
          sendPbReq((ToServiceMsg)localObject);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        notifyUI(79, false, null);
        return;
      }
      short s = 1;
    }
  }
  
  public void o(boolean paramBoolean)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setAllowStrangerInviteToGroupSwitch OPEN=");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.d("Q.profilecard.", 2, ((StringBuilder)localObject1).toString());
    }
    for (;;)
    {
      try
      {
        localObject1 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1279);
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(this.jdField_a_of_type_Short);
        Object localObject2 = ByteBuffer.allocate(13);
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (paramBoolean)
        {
          s = 0;
          ((ByteBuffer)localObject2).putInt(Utils.a(l)).put((byte)0).putShort((short)1).putShort((short)-23282).putShort((short)2).putShort(s);
          ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject2).array()));
          localObject2 = createToServiceMsg("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
          ((ToServiceMsg)localObject2).setTimeout(30000L);
          ((ToServiceMsg)localObject2).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject2).extraData.putBoolean("StrangerInviteToGroup", true);
          ((ToServiceMsg)localObject2).extraData.putBoolean("reqFromCardHandler", true);
          sendPbReq((ToServiceMsg)localObject2);
          return;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.", 2, "setAllowStrangerInviteToGroupSwitch ex", localException);
        }
        return;
      }
      short s = 1;
    }
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return ICardObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (msgCmdFilter(paramFromServiceMsg.getServiceCmd())) {
      return;
    }
    Object localObject2 = paramToServiceMsg.extraData.getString("friendUin");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = paramFromServiceMsg.getUin();
    }
    localObject2 = new Bundle();
    ((Bundle)localObject2).putString("uin", (String)localObject1);
    a(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
    b(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
    c(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
  }
  
  public void p(boolean paramBoolean)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("setPttAuToTextOffLineSwitch:");
      ((StringBuilder)localObject1).append(UIUtils.a(30));
      QLog.d("vip_ptt.CardHandler", 2, ((StringBuilder)localObject1).toString());
    }
    for (;;)
    {
      try
      {
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        localObject1 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(3466);
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(21);
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_result.set(0);
        Object localObject2 = new cmd0xd8a.ReqBody();
        ((cmd0xd8a.ReqBody)localObject2).uint64_uin.set(l);
        Object localObject3 = ((cmd0xd8a.ReqBody)localObject2).uint32_cmd;
        if (paramBoolean)
        {
          i = 101;
          ((PBUInt32Field)localObject3).set(i);
          localObject3 = new cmd0xd8a.ClientInfo();
          ((cmd0xd8a.ClientInfo)localObject3).uint32_implat.set(109);
          ((cmd0xd8a.ClientInfo)localObject3).string_clientver.set(AppSetting.f());
          ((cmd0xd8a.ReqBody)localObject2).client_info.set((MessageMicro)localObject3);
          ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0xd8a.ReqBody)localObject2).toByteArray()));
          localObject2 = createToServiceMsg("OidbSvc.0xd8a");
          ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
          ((ToServiceMsg)localObject2).setTimeout(30000L);
          ((ToServiceMsg)localObject2).extraData.putBoolean("uint32_auto_to_text_flag", paramBoolean);
          sendPbReq((ToServiceMsg)localObject2);
          return;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("vip_ptt.CardHandler", 1, "setMedalSwitch ex", localException);
        }
        return;
      }
      int i = 102;
    }
  }
  
  public void q(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "setEmotionRecommendSwitch!");
    }
    for (;;)
    {
      try
      {
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.uint32_command.set(1279);
        localOIDBSSOPkg.uint32_service_type.set(9);
        Object localObject = ByteBuffer.allocate(13);
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (paramBoolean)
        {
          s = 0;
          ((ByteBuffer)localObject).putInt(Utils.a(l)).put((byte)0).putShort((short)1).putShort((short)-23221).putShort((short)2).putShort(s);
          localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
          localObject = createToServiceMsg("OidbSvc.0x4ff_42315");
          ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
          ((ToServiceMsg)localObject).setTimeout(30000L);
          ((ToServiceMsg)localObject).extraData.putBoolean("uint32_emotion_recommend_flag", paramBoolean);
          sendPbReq((ToServiceMsg)localObject);
          return;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("CardHandler", 1, "setEmotionRecommendSwitch ex", localException);
        }
        return;
      }
      short s = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.CardHandler
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.app;

import AccostSvc.Msg;
import AccostSvc.RespClientMsg;
import KQQ.SetUserInfoResp;
import NS_MOBILE_MAIN_PAGE.mobile_sub_get_cover_rsp;
import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
import QQService.FaceInfo;
import QQService.Intro;
import QQService.MakeFriendsCard;
import QQService.PushVoteIncreaseInfo;
import QQService.RespAddFace;
import QQService.RespDelFace;
import QQService.RespFaceInfo;
import QQService.RespFavorite;
import QQService.RespGetCardSwitch;
import QQService.RespGetFace;
import QQService.RespGetFavoriteList;
import QQService.RespGetVoterList;
import QQService.RespHYMakeFriendsCard;
import QQService.RespSetCard;
import QQService.RespSetCardSwitch;
import QQService.RespUpdateIntro;
import QQService.RespVote;
import QQService.UserCntlData;
import QQService.UserProfile;
import QQService.Visitor;
import SummaryCard.RespSummaryCard;
import SummaryCard.RespVoiceManage;
import SummaryCard.TMedalWallInfo;
import SummaryCard.UserLocaleInfo;
import SummaryCardTaf.SSummaryCardLableRsp;
import SummaryCardTaf.SSummaryCardRsp;
import SummaryCardTaf.SUserLabel;
import SummaryCardTaf.cardDiyTextInfo;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.SystemClock;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.now.NowLiveManager;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.mobileqq.activity.contacts.base.CardConfigManager;
import com.tencent.mobileqq.activity.contacts.base.CardConfigManager.CardConfigs;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoCell;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoWifi;
import com.tencent.mobileqq.app.utils.ClassicHeadActivityManager;
import com.tencent.mobileqq.avatar.dynamicavatar.VasFaceManager;
import com.tencent.mobileqq.campuscircle.CampusLebaEntryChecker;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.CardProfile;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.KplCard;
import com.tencent.mobileqq.data.LikeRankingInfo;
import com.tencent.mobileqq.data.MedalInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QZoneCover;
import com.tencent.mobileqq.data.QZonePhotoWall;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.dating.DatingUtil;
import com.tencent.mobileqq.lovelanguage.LoveLanguageManager;
import com.tencent.mobileqq.medalwall.MedalID;
import com.tencent.mobileqq.medalwall.MedalWallMng;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoRequest;
import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountDetailInfoResponse;
import com.tencent.mobileqq.mp.mobileqq_mp.RetInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.music.SongInfo;
import com.tencent.mobileqq.musicpendant.Base64;
import com.tencent.mobileqq.nearby.NearByGeneralManager;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.nearby.NearbyProxy;
import com.tencent.mobileqq.nearby.NearbySPUtil;
import com.tencent.mobileqq.nearby.redtouch.LocalRedTouchManager;
import com.tencent.mobileqq.nearby.redtouch.Util;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
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
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.profile.ProfileLabelInfo;
import com.tencent.mobileqq.profile.ProfileShoppingPhotoInfo;
import com.tencent.mobileqq.profile.upload.VipUploadUtils;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.profile.ProfileUtil;
import com.tencent.mobileqq.shortvideo.dancegame.DanceGameVideoManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.util.VoteUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.mobileqq.wholepeople.WholePeopleLebaEntryChecker;
import com.tencent.open.agent.report.ReportCenter;
import com.tencent.qidian.QidianManager;
import com.tencent.qidian.data.BmqqAccountType;
import com.tencent.qidian.data.QidianExternalInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadService;
import com.tencent.upload.uinterface.IUploadService.UploadServiceCreator;
import com.tencent.upload.uinterface.data.PhotoWallUploadTask;
import cooperation.qzone.UploadEnv;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.Vector;
import mqq.app.Constants.PropertiesKey;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.ilive.photo.NowLiveGallary.ReqBody;
import tencent.im.medal.common.MedalInfo;
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
import tencent.im.oidb.cmd0x922.cmd0x922.PushInfo;
import tencent.im.oidb.cmd0x922.cmd0x922.ReqBody;
import tencent.im.oidb.cmd0x922.cmd0x922.RspBody;
import tencent.im.oidb.cmd0x93b.oidb_0x93b.ReqBody;
import tencent.im.oidb.cmd0x93b.oidb_0x93b.RspBody;
import tencent.im.oidb.cmd0xa28.oidb_0xa28.ReqBody;
import tencent.im.oidb.cmd0xa28.oidb_0xa28.RspBody;
import tencent.im.oidb.cmd0xa6d.oidb_0xa6d.Cell;
import tencent.im.oidb.cmd0xa6d.oidb_0xa6d.GPS;
import tencent.im.oidb.cmd0xa6d.oidb_0xa6d.LBSInfo;
import tencent.im.oidb.cmd0xa6d.oidb_0xa6d.ReqBody;
import tencent.im.oidb.cmd0xa6d.oidb_0xa6d.RspBody;
import tencent.im.oidb.cmd0xa6d.oidb_0xa6d.Wifi;
import tencent.im.oidb.cmd0xac6.MedalReport;
import tencent.im.oidb.cmd0xac6.ReqBody;
import tencent.im.oidb.cmd0xac6.RspBody;
import tencent.im.oidb.cmd0xac6.operate_result;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.oidb.qqshop.qqshop.SQQSHPAccoutRelation;
import tencent.im.oidb.qqshop.qqshop.SQQSHPClientReq;
import tencent.im.oidb.qqshop.qqshop.SQQSHPClientRsp;
import zay;
import zaz;
import zba;
import zbb;
import zbc;
import zbd;

public class CardHandler
  extends BusinessHandler
{
  public static final String a;
  public static final Vector a;
  public static final Vector b;
  private TransFileController jdField_a_of_type_ComTencentMobileqqTransfileTransFileController;
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  short jdField_a_of_type_Short = 9;
  public String b;
  short b;
  private String jdField_c_of_type_JavaLangString;
  short jdField_c_of_type_Short = -25007;
  short d = -23461;
  short e = -25008;
  
  static
  {
    jdField_a_of_type_JavaLangString = AppConstants.aJ + "portrait/";
    jdField_a_of_type_JavaUtilVector = new Vector();
    jdField_b_of_type_JavaUtilVector = new Vector();
  }
  
  public CardHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_b_of_type_Short = -25044;
    if (jdField_a_of_type_JavaUtilVector.size() == 0)
    {
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(0));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(60));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(100));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(160));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(640));
    }
    if (jdField_b_of_type_JavaUtilVector.size() == 0)
    {
      jdField_b_of_type_JavaUtilVector.add(Integer.valueOf(0));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(60));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(100));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(160));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(640));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(960));
      jdField_a_of_type_JavaUtilVector.add(Integer.valueOf(120));
    }
  }
  
  /* Error */
  private void A(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 10
    //   3: aload_2
    //   4: invokevirtual 88	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   7: ifeq +412 -> 419
    //   10: aload_3
    //   11: ifnull +408 -> 419
    //   14: iconst_1
    //   15: istore 6
    //   17: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +29 -> 49
    //   23: ldc 95
    //   25: iconst_2
    //   26: new 18	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   33: ldc 97
    //   35: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: iload 6
    //   40: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   43: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   49: aload_0
    //   50: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   53: bipush 50
    //   55: invokevirtual 112	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   58: checkcast 114	com/tencent/mobileqq/app/FriendsManager
    //   61: astore_1
    //   62: aload_1
    //   63: aload_0
    //   64: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   67: invokevirtual 117	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   70: invokevirtual 120	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   73: astore_2
    //   74: iload 6
    //   76: istore 9
    //   78: iload 6
    //   80: ifeq +623 -> 703
    //   83: iload 6
    //   85: istore 7
    //   87: iload 6
    //   89: istore 8
    //   91: new 122	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   94: dup
    //   95: invokespecial 123	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   98: aload_3
    //   99: checkcast 125	[B
    //   102: checkcast 125	[B
    //   105: invokevirtual 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   108: checkcast 122	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   111: astore_3
    //   112: aload_3
    //   113: ifnull +312 -> 425
    //   116: iload 6
    //   118: istore 7
    //   120: iload 6
    //   122: istore 8
    //   124: aload_3
    //   125: getfield 133	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   128: invokevirtual 138	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   131: ifne +294 -> 425
    //   134: iconst_1
    //   135: istore 6
    //   137: iload 6
    //   139: istore 7
    //   141: iload 6
    //   143: istore 8
    //   145: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   148: ifeq +37 -> 185
    //   151: iload 6
    //   153: istore 7
    //   155: iload 6
    //   157: istore 8
    //   159: ldc 95
    //   161: iconst_2
    //   162: new 18	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   169: ldc 140
    //   171: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: iload 6
    //   176: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   179: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   185: iload 6
    //   187: istore 9
    //   189: iload 6
    //   191: ifeq +512 -> 703
    //   194: iload 6
    //   196: istore 7
    //   198: iload 6
    //   200: istore 8
    //   202: iload 6
    //   204: istore 9
    //   206: aload_3
    //   207: getfield 144	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   210: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   213: ifeq +490 -> 703
    //   216: iload 6
    //   218: istore 7
    //   220: iload 6
    //   222: istore 8
    //   224: iload 6
    //   226: istore 9
    //   228: aload_3
    //   229: getfield 144	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   232: invokevirtual 152	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   235: ifnull +468 -> 703
    //   238: iload 6
    //   240: istore 7
    //   242: iload 6
    //   244: istore 8
    //   246: aload_3
    //   247: getfield 144	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   250: invokevirtual 152	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   253: invokevirtual 158	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   256: invokestatic 164	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   259: astore_3
    //   260: iload 6
    //   262: istore 7
    //   264: iload 6
    //   266: istore 8
    //   268: aload_3
    //   269: invokevirtual 167	java/nio/ByteBuffer:getInt	()I
    //   272: pop
    //   273: iload 6
    //   275: istore 7
    //   277: iload 6
    //   279: istore 8
    //   281: aload_3
    //   282: invokevirtual 170	java/nio/ByteBuffer:get	()B
    //   285: pop
    //   286: iload 6
    //   288: istore 7
    //   290: iload 6
    //   292: istore 8
    //   294: iload 6
    //   296: istore 9
    //   298: aload_3
    //   299: invokevirtual 174	java/nio/ByteBuffer:getShort	()S
    //   302: invokestatic 179	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   305: invokevirtual 182	java/lang/Short:shortValue	()S
    //   308: iconst_1
    //   309: if_icmpne +394 -> 703
    //   312: iload 6
    //   314: istore 7
    //   316: iload 6
    //   318: istore 8
    //   320: aload_3
    //   321: invokevirtual 174	java/nio/ByteBuffer:getShort	()S
    //   324: istore 4
    //   326: iload 6
    //   328: istore 7
    //   330: iload 6
    //   332: istore 8
    //   334: aload_0
    //   335: getfield 58	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_Short	S
    //   338: istore 5
    //   340: iload 4
    //   342: iload 5
    //   344: if_icmpeq +87 -> 431
    //   347: iload 10
    //   349: istore 7
    //   351: iload 7
    //   353: istore 8
    //   355: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   358: ifeq +45 -> 403
    //   361: ldc 95
    //   363: iconst_2
    //   364: new 18	java/lang/StringBuilder
    //   367: dup
    //   368: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   371: ldc 140
    //   373: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: iload 7
    //   378: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   381: ldc 184
    //   383: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: aload_2
    //   387: getfield 190	com/tencent/mobileqq/data/Card:allowPeopleSee	Z
    //   390: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   393: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   396: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   399: iload 7
    //   401: istore 8
    //   403: aload_0
    //   404: bipush 44
    //   406: iload 8
    //   408: aload_2
    //   409: getfield 190	com/tencent/mobileqq/data/Card:allowPeopleSee	Z
    //   412: invokestatic 195	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   415: invokevirtual 198	com/tencent/mobileqq/app/CardHandler:a	(IZLjava/lang/Object;)V
    //   418: return
    //   419: iconst_0
    //   420: istore 6
    //   422: goto -405 -> 17
    //   425: iconst_0
    //   426: istore 6
    //   428: goto -291 -> 137
    //   431: iload 6
    //   433: istore 7
    //   435: iload 6
    //   437: istore 8
    //   439: aload_3
    //   440: invokevirtual 174	java/nio/ByteBuffer:getShort	()S
    //   443: istore 4
    //   445: iload 10
    //   447: istore 7
    //   449: iload 4
    //   451: iconst_2
    //   452: if_icmpne -101 -> 351
    //   455: iload 6
    //   457: istore 7
    //   459: iload 6
    //   461: istore 8
    //   463: iload 4
    //   465: newarray byte
    //   467: astore 11
    //   469: iload 6
    //   471: istore 7
    //   473: iload 6
    //   475: istore 8
    //   477: aload_3
    //   478: aload 11
    //   480: invokevirtual 200	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   483: pop
    //   484: iload 6
    //   486: istore 7
    //   488: iload 6
    //   490: istore 8
    //   492: aload 11
    //   494: iconst_0
    //   495: invokestatic 205	com/tencent/mobileqq/util/Utils:a	([BI)S
    //   498: ifne +55 -> 553
    //   501: iconst_0
    //   502: istore 9
    //   504: iload 6
    //   506: istore 7
    //   508: iload 6
    //   510: istore 8
    //   512: aload_2
    //   513: iload 9
    //   515: putfield 190	com/tencent/mobileqq/data/Card:allowPeopleSee	Z
    //   518: iload 6
    //   520: istore 7
    //   522: iload 6
    //   524: istore 8
    //   526: aload_3
    //   527: invokevirtual 174	java/nio/ByteBuffer:getShort	()S
    //   530: istore 4
    //   532: iload 10
    //   534: istore 7
    //   536: iload 4
    //   538: ifne -187 -> 351
    //   541: aload_1
    //   542: aload_2
    //   543: invokevirtual 208	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   546: pop
    //   547: iconst_1
    //   548: istore 7
    //   550: goto -199 -> 351
    //   553: iconst_1
    //   554: istore 9
    //   556: goto -52 -> 504
    //   559: astore_1
    //   560: iload 7
    //   562: istore 6
    //   564: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   567: ifeq +12 -> 579
    //   570: ldc 95
    //   572: iconst_2
    //   573: ldc 210
    //   575: aload_1
    //   576: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   579: iload 6
    //   581: istore 8
    //   583: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   586: ifeq -183 -> 403
    //   589: ldc 95
    //   591: iconst_2
    //   592: new 18	java/lang/StringBuilder
    //   595: dup
    //   596: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   599: ldc 140
    //   601: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   604: iload 6
    //   606: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   609: ldc 184
    //   611: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   614: aload_2
    //   615: getfield 190	com/tencent/mobileqq/data/Card:allowPeopleSee	Z
    //   618: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   621: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   624: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   627: iload 6
    //   629: istore 8
    //   631: goto -228 -> 403
    //   634: astore_1
    //   635: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   638: ifeq +41 -> 679
    //   641: ldc 95
    //   643: iconst_2
    //   644: new 18	java/lang/StringBuilder
    //   647: dup
    //   648: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   651: ldc 140
    //   653: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   656: iload 8
    //   658: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   661: ldc 184
    //   663: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: aload_2
    //   667: getfield 190	com/tencent/mobileqq/data/Card:allowPeopleSee	Z
    //   670: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   673: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   676: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   679: aload_1
    //   680: athrow
    //   681: astore_1
    //   682: iconst_1
    //   683: istore 8
    //   685: goto -50 -> 635
    //   688: astore_1
    //   689: iload 6
    //   691: istore 8
    //   693: goto -58 -> 635
    //   696: astore_1
    //   697: iconst_1
    //   698: istore 6
    //   700: goto -136 -> 564
    //   703: iload 9
    //   705: istore 7
    //   707: goto -356 -> 351
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	710	0	this	CardHandler
    //   0	710	1	paramToServiceMsg	ToServiceMsg
    //   0	710	2	paramFromServiceMsg	FromServiceMsg
    //   0	710	3	paramObject	Object
    //   324	213	4	i	int
    //   338	7	5	j	int
    //   15	684	6	bool1	boolean
    //   85	621	7	bool2	boolean
    //   89	603	8	bool3	boolean
    //   76	628	9	bool4	boolean
    //   1	532	10	bool5	boolean
    //   467	26	11	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   91	112	559	java/lang/Exception
    //   124	134	559	java/lang/Exception
    //   145	151	559	java/lang/Exception
    //   159	185	559	java/lang/Exception
    //   206	216	559	java/lang/Exception
    //   228	238	559	java/lang/Exception
    //   246	260	559	java/lang/Exception
    //   268	273	559	java/lang/Exception
    //   281	286	559	java/lang/Exception
    //   298	312	559	java/lang/Exception
    //   320	326	559	java/lang/Exception
    //   334	340	559	java/lang/Exception
    //   439	445	559	java/lang/Exception
    //   463	469	559	java/lang/Exception
    //   477	484	559	java/lang/Exception
    //   492	501	559	java/lang/Exception
    //   512	518	559	java/lang/Exception
    //   526	532	559	java/lang/Exception
    //   91	112	634	finally
    //   124	134	634	finally
    //   145	151	634	finally
    //   159	185	634	finally
    //   206	216	634	finally
    //   228	238	634	finally
    //   246	260	634	finally
    //   268	273	634	finally
    //   281	286	634	finally
    //   298	312	634	finally
    //   320	326	634	finally
    //   334	340	634	finally
    //   439	445	634	finally
    //   463	469	634	finally
    //   477	484	634	finally
    //   492	501	634	finally
    //   512	518	634	finally
    //   526	532	634	finally
    //   541	547	681	finally
    //   564	579	688	finally
    //   541	547	696	java/lang/Exception
  }
  
  /* Error */
  private void B(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 88	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: ifeq +514 -> 518
    //   7: aload_3
    //   8: ifnull +510 -> 518
    //   11: iconst_1
    //   12: istore 6
    //   14: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   17: ifeq +29 -> 46
    //   20: ldc 95
    //   22: iconst_2
    //   23: new 18	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   30: ldc 216
    //   32: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: iload 6
    //   37: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   40: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   46: aload_0
    //   47: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   50: invokevirtual 117	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   53: astore_1
    //   54: aload_0
    //   55: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   58: bipush 50
    //   60: invokevirtual 112	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   63: checkcast 114	com/tencent/mobileqq/app/FriendsManager
    //   66: astore 10
    //   68: aload 10
    //   70: aload_1
    //   71: invokevirtual 120	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   74: astore_2
    //   75: iload 6
    //   77: istore 9
    //   79: iload 6
    //   81: ifeq +784 -> 865
    //   84: iload 6
    //   86: istore 7
    //   88: iload 6
    //   90: istore 8
    //   92: new 122	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   95: dup
    //   96: invokespecial 123	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   99: aload_3
    //   100: checkcast 125	[B
    //   103: checkcast 125	[B
    //   106: invokevirtual 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   109: checkcast 122	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   112: astore_1
    //   113: aload_1
    //   114: ifnull +410 -> 524
    //   117: iload 6
    //   119: istore 7
    //   121: iload 6
    //   123: istore 8
    //   125: aload_1
    //   126: getfield 133	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   129: invokevirtual 138	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   132: ifne +392 -> 524
    //   135: iconst_1
    //   136: istore 6
    //   138: iload 6
    //   140: istore 7
    //   142: iload 6
    //   144: istore 8
    //   146: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   149: ifeq +37 -> 186
    //   152: iload 6
    //   154: istore 7
    //   156: iload 6
    //   158: istore 8
    //   160: ldc 95
    //   162: iconst_2
    //   163: new 18	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   170: ldc 218
    //   172: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: iload 6
    //   177: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   180: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   186: iload 6
    //   188: istore 9
    //   190: iload 6
    //   192: ifeq +673 -> 865
    //   195: iload 6
    //   197: istore 7
    //   199: iload 6
    //   201: istore 8
    //   203: iload 6
    //   205: istore 9
    //   207: aload_1
    //   208: getfield 144	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   211: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   214: ifeq +651 -> 865
    //   217: iload 6
    //   219: istore 7
    //   221: iload 6
    //   223: istore 8
    //   225: iload 6
    //   227: istore 9
    //   229: aload_1
    //   230: getfield 144	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   233: invokevirtual 152	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   236: ifnull +629 -> 865
    //   239: iload 6
    //   241: istore 7
    //   243: iload 6
    //   245: istore 8
    //   247: aload_1
    //   248: getfield 144	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   251: invokevirtual 152	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   254: invokevirtual 158	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   257: invokestatic 164	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   260: astore_1
    //   261: iload 6
    //   263: istore 7
    //   265: iload 6
    //   267: istore 8
    //   269: aload_1
    //   270: invokevirtual 167	java/nio/ByteBuffer:getInt	()I
    //   273: pop
    //   274: iload 6
    //   276: istore 7
    //   278: iload 6
    //   280: istore 8
    //   282: aload_1
    //   283: invokevirtual 170	java/nio/ByteBuffer:get	()B
    //   286: pop
    //   287: iload 6
    //   289: istore 7
    //   291: iload 6
    //   293: istore 8
    //   295: iload 6
    //   297: istore 9
    //   299: aload_1
    //   300: invokevirtual 174	java/nio/ByteBuffer:getShort	()S
    //   303: invokestatic 179	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   306: invokevirtual 182	java/lang/Short:shortValue	()S
    //   309: iconst_1
    //   310: if_icmpne +555 -> 865
    //   313: iload 6
    //   315: istore 7
    //   317: iload 6
    //   319: istore 8
    //   321: aload_1
    //   322: invokevirtual 174	java/nio/ByteBuffer:getShort	()S
    //   325: istore 4
    //   327: iload 6
    //   329: istore 7
    //   331: iload 6
    //   333: istore 8
    //   335: aload_0
    //   336: getfield 60	com/tencent/mobileqq/app/CardHandler:jdField_c_of_type_Short	S
    //   339: istore 5
    //   341: iload 4
    //   343: iload 5
    //   345: if_icmpeq +185 -> 530
    //   348: iconst_0
    //   349: istore 6
    //   351: iload 6
    //   353: istore 7
    //   355: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   358: ifeq +45 -> 403
    //   361: ldc 95
    //   363: iconst_2
    //   364: new 18	java/lang/StringBuilder
    //   367: dup
    //   368: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   371: ldc 218
    //   373: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: iload 6
    //   378: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   381: ldc 184
    //   383: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: aload_2
    //   387: getfield 221	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   390: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   393: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   396: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   399: iload 6
    //   401: istore 7
    //   403: aload_2
    //   404: getfield 221	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   407: ifeq +427 -> 834
    //   410: aload 10
    //   412: iconst_1
    //   413: putfield 225	com/tencent/mobileqq/app/FriendsManager:j	I
    //   416: aload_0
    //   417: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   420: invokevirtual 229	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   423: aload_0
    //   424: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   427: invokevirtual 117	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   430: iconst_0
    //   431: invokevirtual 235	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   434: invokeinterface 241 1 0
    //   439: ldc 243
    //   441: aload 10
    //   443: getfield 225	com/tencent/mobileqq/app/FriendsManager:j	I
    //   446: invokeinterface 249 3 0
    //   451: invokeinterface 252 1 0
    //   456: pop
    //   457: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   460: ifeq +42 -> 502
    //   463: ldc 254
    //   465: iconst_2
    //   466: new 18	java/lang/StringBuilder
    //   469: dup
    //   470: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   473: ldc 218
    //   475: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: iload 7
    //   480: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   483: ldc_w 256
    //   486: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: aload_2
    //   490: getfield 221	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   493: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   496: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   499: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   502: aload_0
    //   503: bipush 72
    //   505: iload 7
    //   507: aload_2
    //   508: getfield 221	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   511: invokestatic 195	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   514: invokevirtual 198	com/tencent/mobileqq/app/CardHandler:a	(IZLjava/lang/Object;)V
    //   517: return
    //   518: iconst_0
    //   519: istore 6
    //   521: goto -507 -> 14
    //   524: iconst_0
    //   525: istore 6
    //   527: goto -389 -> 138
    //   530: iload 6
    //   532: istore 7
    //   534: iload 6
    //   536: istore 8
    //   538: aload_1
    //   539: invokevirtual 174	java/nio/ByteBuffer:getShort	()S
    //   542: istore 4
    //   544: iload 4
    //   546: iconst_2
    //   547: if_icmpne +158 -> 705
    //   550: iload 6
    //   552: istore 7
    //   554: iload 6
    //   556: istore 8
    //   558: iload 4
    //   560: newarray byte
    //   562: astore_3
    //   563: iload 6
    //   565: istore 7
    //   567: iload 6
    //   569: istore 8
    //   571: aload_1
    //   572: aload_3
    //   573: invokevirtual 200	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   576: pop
    //   577: iload 6
    //   579: istore 7
    //   581: iload 6
    //   583: istore 8
    //   585: aload_3
    //   586: iconst_0
    //   587: invokestatic 205	com/tencent/mobileqq/util/Utils:a	([BI)S
    //   590: ifne +96 -> 686
    //   593: iconst_0
    //   594: istore 9
    //   596: iload 6
    //   598: istore 7
    //   600: iload 6
    //   602: istore 8
    //   604: aload_2
    //   605: iload 9
    //   607: putfield 221	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   610: iload 6
    //   612: istore 7
    //   614: iload 6
    //   616: istore 8
    //   618: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   621: ifeq +40 -> 661
    //   624: iload 6
    //   626: istore 7
    //   628: iload 6
    //   630: istore 8
    //   632: ldc 254
    //   634: iconst_2
    //   635: new 18	java/lang/StringBuilder
    //   638: dup
    //   639: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   642: ldc_w 258
    //   645: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   648: aload_2
    //   649: getfield 221	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   652: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   655: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   658: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   661: iload 6
    //   663: istore 7
    //   665: iload 6
    //   667: istore 8
    //   669: aload_1
    //   670: invokevirtual 174	java/nio/ByteBuffer:getShort	()S
    //   673: istore 4
    //   675: iload 4
    //   677: ifeq +15 -> 692
    //   680: iconst_0
    //   681: istore 6
    //   683: goto -332 -> 351
    //   686: iconst_1
    //   687: istore 9
    //   689: goto -93 -> 596
    //   692: aload 10
    //   694: aload_2
    //   695: invokevirtual 208	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   698: pop
    //   699: iconst_1
    //   700: istore 6
    //   702: goto -351 -> 351
    //   705: iconst_0
    //   706: istore 6
    //   708: goto -357 -> 351
    //   711: astore_1
    //   712: iload 7
    //   714: istore 6
    //   716: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   719: ifeq +13 -> 732
    //   722: ldc 95
    //   724: iconst_2
    //   725: ldc_w 260
    //   728: aload_1
    //   729: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   732: iload 6
    //   734: istore 7
    //   736: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   739: ifeq -336 -> 403
    //   742: ldc 95
    //   744: iconst_2
    //   745: new 18	java/lang/StringBuilder
    //   748: dup
    //   749: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   752: ldc 218
    //   754: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   757: iload 6
    //   759: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   762: ldc 184
    //   764: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   767: aload_2
    //   768: getfield 221	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   771: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   774: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   777: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   780: iload 6
    //   782: istore 7
    //   784: goto -381 -> 403
    //   787: astore_1
    //   788: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   791: ifeq +41 -> 832
    //   794: ldc 95
    //   796: iconst_2
    //   797: new 18	java/lang/StringBuilder
    //   800: dup
    //   801: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   804: ldc 218
    //   806: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   809: iload 8
    //   811: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   814: ldc 184
    //   816: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   819: aload_2
    //   820: getfield 221	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   823: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   826: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   829: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   832: aload_1
    //   833: athrow
    //   834: aload 10
    //   836: iconst_0
    //   837: putfield 225	com/tencent/mobileqq/app/FriendsManager:j	I
    //   840: goto -424 -> 416
    //   843: astore_1
    //   844: iconst_1
    //   845: istore 8
    //   847: goto -59 -> 788
    //   850: astore_1
    //   851: iload 6
    //   853: istore 8
    //   855: goto -67 -> 788
    //   858: astore_1
    //   859: iconst_1
    //   860: istore 6
    //   862: goto -146 -> 716
    //   865: iload 9
    //   867: istore 6
    //   869: goto -518 -> 351
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	872	0	this	CardHandler
    //   0	872	1	paramToServiceMsg	ToServiceMsg
    //   0	872	2	paramFromServiceMsg	FromServiceMsg
    //   0	872	3	paramObject	Object
    //   325	351	4	i	int
    //   339	7	5	j	int
    //   12	856	6	bool1	boolean
    //   86	697	7	bool2	boolean
    //   90	764	8	bool3	boolean
    //   77	789	9	bool4	boolean
    //   66	769	10	localFriendsManager	FriendsManager
    // Exception table:
    //   from	to	target	type
    //   92	113	711	java/lang/Exception
    //   125	135	711	java/lang/Exception
    //   146	152	711	java/lang/Exception
    //   160	186	711	java/lang/Exception
    //   207	217	711	java/lang/Exception
    //   229	239	711	java/lang/Exception
    //   247	261	711	java/lang/Exception
    //   269	274	711	java/lang/Exception
    //   282	287	711	java/lang/Exception
    //   299	313	711	java/lang/Exception
    //   321	327	711	java/lang/Exception
    //   335	341	711	java/lang/Exception
    //   538	544	711	java/lang/Exception
    //   558	563	711	java/lang/Exception
    //   571	577	711	java/lang/Exception
    //   585	593	711	java/lang/Exception
    //   604	610	711	java/lang/Exception
    //   618	624	711	java/lang/Exception
    //   632	661	711	java/lang/Exception
    //   669	675	711	java/lang/Exception
    //   92	113	787	finally
    //   125	135	787	finally
    //   146	152	787	finally
    //   160	186	787	finally
    //   207	217	787	finally
    //   229	239	787	finally
    //   247	261	787	finally
    //   269	274	787	finally
    //   282	287	787	finally
    //   299	313	787	finally
    //   321	327	787	finally
    //   335	341	787	finally
    //   538	544	787	finally
    //   558	563	787	finally
    //   571	577	787	finally
    //   585	593	787	finally
    //   604	610	787	finally
    //   618	624	787	finally
    //   632	661	787	finally
    //   669	675	787	finally
    //   692	699	843	finally
    //   716	732	850	finally
    //   692	699	858	java/lang/Exception
  }
  
  private void C(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool5 = true;
    boolean bool1;
    boolean bool4;
    boolean bool2;
    boolean bool3;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "handleSetLoginDaysSwitch success=" + bool1);
      }
      bool4 = bool1;
      if (!bool1) {
        break label598;
      }
      bool2 = bool1;
      bool3 = bool1;
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg == null) {
          continue;
        }
        bool2 = bool1;
        bool3 = bool1;
        if (paramFromServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool1 = true;
        bool2 = bool1;
        bool3 = bool1;
        if (QLog.isColorLevel())
        {
          bool2 = bool1;
          bool3 = bool1;
          QLog.d("Q.profilecard.", 2, "handleSetLoginDaysSwitch result=" + bool1);
        }
        bool4 = bool1;
        if (!bool1) {
          break label598;
        }
        bool2 = bool1;
        bool3 = bool1;
        bool4 = bool1;
        if (!paramFromServiceMsg.bytes_bodybuffer.has()) {
          break label598;
        }
        bool2 = bool1;
        bool3 = bool1;
        bool4 = bool1;
        if (paramFromServiceMsg.bytes_bodybuffer.get() == null) {
          break label598;
        }
        bool2 = bool1;
        bool3 = bool1;
        i = ByteBuffer.wrap(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray()).getInt();
        if (i >= 0) {
          continue;
        }
        l = i + 4294967296L;
        bool2 = bool1;
        bool3 = bool1;
        if (!this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(String.valueOf(l))) {
          continue;
        }
        bool2 = bool1;
        bool3 = bool1;
        paramFromServiceMsg = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
        bool2 = bool1;
        bool3 = bool1;
        paramObject = paramFromServiceMsg.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        bool2 = bool1;
        bool3 = bool1;
        paramObject.allowPeopleSee = paramToServiceMsg.extraData.getBoolean("switch");
        bool2 = bool1;
        bool3 = bool1;
        paramFromServiceMsg.a(paramObject);
        bool1 = bool5;
        bool3 = bool1;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.profilecard.", 2, "handleSetLoginDaysSwitch result=" + bool1 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
          bool3 = bool1;
        }
      }
      catch (Exception paramFromServiceMsg) {}finally
      {
        try
        {
          int i;
          long l;
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.", 2, "handleSetLoginDaysSwitch ex", paramFromServiceMsg);
          }
          bool3 = bool2;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.profilecard.", 2, "handleSetLoginDaysSwitch result=" + bool2 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
          bool3 = bool2;
          continue;
        }
        finally
        {
          bool3 = bool2;
        }
        paramFromServiceMsg = finally;
      }
      a(45, bool3, null);
      return;
      bool1 = false;
      break;
      bool1 = false;
      continue;
      l = i;
      continue;
      bool1 = false;
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "handleSetLoginDaysSwitch result=" + bool3 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
      }
      throw paramFromServiceMsg;
      label598:
      bool1 = bool4;
    }
  }
  
  /* Error */
  private void D(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 10
    //   3: iconst_1
    //   4: istore 11
    //   6: iconst_1
    //   7: istore 9
    //   9: aload_2
    //   10: invokevirtual 88	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   13: ifeq +600 -> 613
    //   16: aload_3
    //   17: ifnull +596 -> 613
    //   20: iconst_1
    //   21: istore 5
    //   23: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +30 -> 56
    //   29: ldc 95
    //   31: iconst_2
    //   32: new 18	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   39: ldc_w 294
    //   42: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: iload 5
    //   47: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   50: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: iload 5
    //   58: istore 8
    //   60: iload 5
    //   62: ifeq +746 -> 808
    //   65: iload 5
    //   67: istore 6
    //   69: iload 5
    //   71: istore 7
    //   73: new 122	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   76: dup
    //   77: invokespecial 123	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   80: aload_3
    //   81: checkcast 125	[B
    //   84: checkcast 125	[B
    //   87: invokevirtual 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   90: checkcast 122	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   93: astore_2
    //   94: aload_2
    //   95: ifnull +524 -> 619
    //   98: iload 5
    //   100: istore 6
    //   102: iload 5
    //   104: istore 7
    //   106: aload_2
    //   107: getfield 133	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   110: invokevirtual 138	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   113: ifne +506 -> 619
    //   116: iconst_1
    //   117: istore 5
    //   119: iload 5
    //   121: istore 6
    //   123: iload 5
    //   125: istore 7
    //   127: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   130: ifeq +38 -> 168
    //   133: iload 5
    //   135: istore 6
    //   137: iload 5
    //   139: istore 7
    //   141: ldc 95
    //   143: iconst_2
    //   144: new 18	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   151: ldc_w 296
    //   154: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: iload 5
    //   159: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   162: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   168: iload 5
    //   170: istore 8
    //   172: iload 5
    //   174: ifeq +634 -> 808
    //   177: iload 5
    //   179: istore 6
    //   181: iload 5
    //   183: istore 7
    //   185: iload 5
    //   187: istore 8
    //   189: aload_2
    //   190: getfield 144	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   193: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   196: ifeq +612 -> 808
    //   199: iload 5
    //   201: istore 6
    //   203: iload 5
    //   205: istore 7
    //   207: iload 5
    //   209: istore 8
    //   211: aload_2
    //   212: getfield 144	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   215: invokevirtual 152	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   218: ifnull +590 -> 808
    //   221: iload 5
    //   223: istore 6
    //   225: iload 5
    //   227: istore 7
    //   229: aload_2
    //   230: getfield 144	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   233: invokevirtual 152	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   236: invokevirtual 158	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   239: invokestatic 164	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   242: invokevirtual 167	java/nio/ByteBuffer:getInt	()I
    //   245: istore 4
    //   247: iload 4
    //   249: ifge +376 -> 625
    //   252: iload 4
    //   254: i2l
    //   255: ldc2_w 266
    //   258: ladd
    //   259: lstore 12
    //   261: iload 5
    //   263: istore 6
    //   265: iload 5
    //   267: istore 7
    //   269: aload_0
    //   270: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   273: invokevirtual 117	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   276: lload 12
    //   278: invokestatic 272	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   281: invokevirtual 275	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   284: ifeq +452 -> 736
    //   287: iload 5
    //   289: istore 6
    //   291: iload 5
    //   293: istore 7
    //   295: aload_0
    //   296: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   299: bipush 50
    //   301: invokevirtual 112	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   304: checkcast 114	com/tencent/mobileqq/app/FriendsManager
    //   307: astore_2
    //   308: iload 5
    //   310: istore 6
    //   312: iload 5
    //   314: istore 7
    //   316: aload_2
    //   317: aload_0
    //   318: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   321: invokevirtual 117	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   324: invokevirtual 120	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   327: astore_3
    //   328: iload 5
    //   330: istore 6
    //   332: iload 5
    //   334: istore 7
    //   336: aload_3
    //   337: aload_1
    //   338: getfield 281	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   341: ldc_w 283
    //   344: invokevirtual 289	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   347: putfield 221	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   350: iload 5
    //   352: istore 6
    //   354: iload 5
    //   356: istore 7
    //   358: aload_2
    //   359: aload_3
    //   360: invokevirtual 208	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   363: pop
    //   364: iload 11
    //   366: istore 6
    //   368: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   371: ifeq +36 -> 407
    //   374: iload 11
    //   376: istore 6
    //   378: ldc 254
    //   380: iconst_2
    //   381: new 18	java/lang/StringBuilder
    //   384: dup
    //   385: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   388: ldc_w 298
    //   391: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: aload_3
    //   395: getfield 221	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   398: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   401: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   404: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   407: iload 11
    //   409: istore 6
    //   411: aload_3
    //   412: getfield 221	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   415: ifeq +218 -> 633
    //   418: iload 11
    //   420: istore 6
    //   422: aload_2
    //   423: iconst_1
    //   424: putfield 225	com/tencent/mobileqq/app/FriendsManager:j	I
    //   427: iload 11
    //   429: istore 6
    //   431: aload_0
    //   432: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   435: invokevirtual 229	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   438: aload_0
    //   439: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   442: invokevirtual 117	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   445: iconst_0
    //   446: invokevirtual 235	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   449: invokeinterface 241 1 0
    //   454: ldc 243
    //   456: aload_2
    //   457: getfield 225	com/tencent/mobileqq/app/FriendsManager:j	I
    //   460: invokeinterface 249 3 0
    //   465: invokeinterface 252 1 0
    //   470: pop
    //   471: iload 9
    //   473: istore 5
    //   475: iload 5
    //   477: istore 6
    //   479: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   482: ifeq +52 -> 534
    //   485: ldc 95
    //   487: iconst_2
    //   488: new 18	java/lang/StringBuilder
    //   491: dup
    //   492: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   495: ldc_w 296
    //   498: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: iload 5
    //   503: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   506: ldc 184
    //   508: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   511: aload_1
    //   512: getfield 281	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   515: ldc_w 283
    //   518: invokevirtual 289	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   521: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   524: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   527: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   530: iload 5
    //   532: istore 6
    //   534: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   537: ifeq +66 -> 603
    //   540: aload_0
    //   541: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   544: bipush 50
    //   546: invokevirtual 112	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   549: checkcast 114	com/tencent/mobileqq/app/FriendsManager
    //   552: aload_0
    //   553: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   556: invokevirtual 117	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   559: invokevirtual 120	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   562: astore_1
    //   563: ldc 254
    //   565: iconst_2
    //   566: new 18	java/lang/StringBuilder
    //   569: dup
    //   570: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   573: ldc_w 298
    //   576: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   579: aload_1
    //   580: getfield 221	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   583: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   586: ldc_w 300
    //   589: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   592: iload 6
    //   594: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   597: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   600: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   603: aload_0
    //   604: bipush 73
    //   606: iload 6
    //   608: aconst_null
    //   609: invokevirtual 198	com/tencent/mobileqq/app/CardHandler:a	(IZLjava/lang/Object;)V
    //   612: return
    //   613: iconst_0
    //   614: istore 5
    //   616: goto -593 -> 23
    //   619: iconst_0
    //   620: istore 5
    //   622: goto -503 -> 119
    //   625: iload 4
    //   627: i2l
    //   628: lstore 12
    //   630: goto -369 -> 261
    //   633: iload 11
    //   635: istore 6
    //   637: aload_2
    //   638: iconst_0
    //   639: putfield 225	com/tencent/mobileqq/app/FriendsManager:j	I
    //   642: goto -215 -> 427
    //   645: astore_2
    //   646: iload 10
    //   648: istore 5
    //   650: iload 5
    //   652: istore 6
    //   654: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   657: ifeq +17 -> 674
    //   660: iload 5
    //   662: istore 6
    //   664: ldc 95
    //   666: iconst_2
    //   667: ldc_w 302
    //   670: aload_2
    //   671: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   674: iload 5
    //   676: istore 6
    //   678: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   681: ifeq -147 -> 534
    //   684: ldc 95
    //   686: iconst_2
    //   687: new 18	java/lang/StringBuilder
    //   690: dup
    //   691: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   694: ldc_w 296
    //   697: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   700: iload 5
    //   702: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   705: ldc 184
    //   707: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   710: aload_1
    //   711: getfield 281	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   714: ldc_w 283
    //   717: invokevirtual 289	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   720: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   723: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   726: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   729: iload 5
    //   731: istore 6
    //   733: goto -199 -> 534
    //   736: iconst_0
    //   737: istore 5
    //   739: goto -264 -> 475
    //   742: astore_2
    //   743: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   746: ifeq +48 -> 794
    //   749: ldc 95
    //   751: iconst_2
    //   752: new 18	java/lang/StringBuilder
    //   755: dup
    //   756: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   759: ldc_w 296
    //   762: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   765: iload 6
    //   767: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   770: ldc 184
    //   772: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   775: aload_1
    //   776: getfield 281	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   779: ldc_w 283
    //   782: invokevirtual 289	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   785: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   788: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   791: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   794: aload_2
    //   795: athrow
    //   796: astore_2
    //   797: goto -54 -> 743
    //   800: astore_2
    //   801: iload 7
    //   803: istore 5
    //   805: goto -155 -> 650
    //   808: iload 8
    //   810: istore 5
    //   812: goto -337 -> 475
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	815	0	this	CardHandler
    //   0	815	1	paramToServiceMsg	ToServiceMsg
    //   0	815	2	paramFromServiceMsg	FromServiceMsg
    //   0	815	3	paramObject	Object
    //   245	381	4	i	int
    //   21	790	5	bool1	boolean
    //   67	699	6	bool2	boolean
    //   71	731	7	bool3	boolean
    //   58	751	8	bool4	boolean
    //   7	465	9	bool5	boolean
    //   1	646	10	bool6	boolean
    //   4	630	11	bool7	boolean
    //   259	370	12	l	long
    // Exception table:
    //   from	to	target	type
    //   368	374	645	java/lang/Exception
    //   378	407	645	java/lang/Exception
    //   411	418	645	java/lang/Exception
    //   422	427	645	java/lang/Exception
    //   431	471	645	java/lang/Exception
    //   637	642	645	java/lang/Exception
    //   73	94	742	finally
    //   106	116	742	finally
    //   127	133	742	finally
    //   141	168	742	finally
    //   189	199	742	finally
    //   211	221	742	finally
    //   229	247	742	finally
    //   269	287	742	finally
    //   295	308	742	finally
    //   316	328	742	finally
    //   336	350	742	finally
    //   358	364	742	finally
    //   368	374	796	finally
    //   378	407	796	finally
    //   411	418	796	finally
    //   422	427	796	finally
    //   431	471	796	finally
    //   637	642	796	finally
    //   654	660	796	finally
    //   664	674	796	finally
    //   73	94	800	java/lang/Exception
    //   106	116	800	java/lang/Exception
    //   127	133	800	java/lang/Exception
    //   141	168	800	java/lang/Exception
    //   189	199	800	java/lang/Exception
    //   211	221	800	java/lang/Exception
    //   229	247	800	java/lang/Exception
    //   269	287	800	java/lang/Exception
    //   295	308	800	java/lang/Exception
    //   316	328	800	java/lang/Exception
    //   336	350	800	java/lang/Exception
    //   358	364	800	java/lang/Exception
  }
  
  /* Error */
  private void E(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 10
    //   3: iconst_1
    //   4: istore 11
    //   6: iconst_1
    //   7: istore 9
    //   9: aload_2
    //   10: invokevirtual 88	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   13: ifeq +674 -> 687
    //   16: aload_3
    //   17: ifnull +670 -> 687
    //   20: iconst_1
    //   21: istore 5
    //   23: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +30 -> 56
    //   29: ldc 95
    //   31: iconst_2
    //   32: new 18	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   39: ldc_w 305
    //   42: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: iload 5
    //   47: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   50: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: iload 5
    //   58: istore 8
    //   60: iload 5
    //   62: ifeq +814 -> 876
    //   65: iload 5
    //   67: istore 6
    //   69: iload 5
    //   71: istore 7
    //   73: new 122	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   76: dup
    //   77: invokespecial 123	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   80: aload_3
    //   81: checkcast 125	[B
    //   84: checkcast 125	[B
    //   87: invokevirtual 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   90: checkcast 122	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   93: astore_2
    //   94: iload 5
    //   96: istore 6
    //   98: iload 5
    //   100: istore 7
    //   102: aload_2
    //   103: getfield 133	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   106: invokevirtual 138	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   109: ifne +584 -> 693
    //   112: iconst_1
    //   113: istore 5
    //   115: iload 5
    //   117: istore 6
    //   119: iload 5
    //   121: istore 7
    //   123: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   126: ifeq +38 -> 164
    //   129: iload 5
    //   131: istore 6
    //   133: iload 5
    //   135: istore 7
    //   137: ldc 95
    //   139: iconst_2
    //   140: new 18	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   147: ldc_w 307
    //   150: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: iload 5
    //   155: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   158: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   164: iload 5
    //   166: istore 8
    //   168: iload 5
    //   170: ifeq +706 -> 876
    //   173: iload 5
    //   175: istore 6
    //   177: iload 5
    //   179: istore 7
    //   181: iload 5
    //   183: istore 8
    //   185: aload_2
    //   186: getfield 144	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   189: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   192: ifeq +684 -> 876
    //   195: iload 5
    //   197: istore 6
    //   199: iload 5
    //   201: istore 7
    //   203: iload 5
    //   205: istore 8
    //   207: aload_2
    //   208: getfield 144	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   211: invokevirtual 152	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   214: ifnull +662 -> 876
    //   217: iload 5
    //   219: istore 6
    //   221: iload 5
    //   223: istore 7
    //   225: aload_2
    //   226: getfield 144	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   229: invokevirtual 152	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   232: invokevirtual 158	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   235: invokestatic 164	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   238: invokevirtual 167	java/nio/ByteBuffer:getInt	()I
    //   241: istore 4
    //   243: iload 4
    //   245: ifge +454 -> 699
    //   248: iload 4
    //   250: i2l
    //   251: ldc2_w 266
    //   254: ladd
    //   255: lstore 13
    //   257: iload 5
    //   259: istore 6
    //   261: iload 5
    //   263: istore 7
    //   265: aload_0
    //   266: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   269: invokevirtual 117	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   272: lload 13
    //   274: invokestatic 272	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   277: invokevirtual 275	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   280: ifeq +427 -> 707
    //   283: iload 5
    //   285: istore 6
    //   287: iload 5
    //   289: istore 7
    //   291: aload_0
    //   292: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   295: invokestatic 312	com/tencent/mobileqq/nearby/redtouch/Util:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   298: istore 8
    //   300: iload 5
    //   302: istore 6
    //   304: iload 5
    //   306: istore 7
    //   308: aload_0
    //   309: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   312: bipush 50
    //   314: invokevirtual 112	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   317: checkcast 114	com/tencent/mobileqq/app/FriendsManager
    //   320: astore_3
    //   321: iload 5
    //   323: istore 6
    //   325: iload 5
    //   327: istore 7
    //   329: aload_3
    //   330: aload_0
    //   331: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   334: invokevirtual 117	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   337: invokevirtual 120	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   340: astore_2
    //   341: iload 5
    //   343: istore 6
    //   345: iload 5
    //   347: istore 7
    //   349: aload_2
    //   350: aload_1
    //   351: getfield 281	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   354: ldc_w 283
    //   357: invokevirtual 289	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   360: putfield 315	com/tencent/mobileqq/data/Card:medalSwitchDisable	Z
    //   363: iload 5
    //   365: istore 6
    //   367: iload 5
    //   369: istore 7
    //   371: aload_3
    //   372: aload_2
    //   373: invokevirtual 208	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   376: pop
    //   377: iload 5
    //   379: istore 6
    //   381: iload 5
    //   383: istore 7
    //   385: invokestatic 321	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   388: new 18	java/lang/StringBuilder
    //   391: dup
    //   392: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   395: ldc_w 323
    //   398: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: lload 13
    //   403: invokevirtual 326	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   406: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   409: iconst_4
    //   410: invokevirtual 327	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   413: invokeinterface 241 1 0
    //   418: astore_3
    //   419: iload 5
    //   421: istore 6
    //   423: iload 5
    //   425: istore 7
    //   427: aload_3
    //   428: ldc_w 329
    //   431: aload_2
    //   432: getfield 315	com/tencent/mobileqq/data/Card:medalSwitchDisable	Z
    //   435: invokeinterface 333 3 0
    //   440: pop
    //   441: iload 5
    //   443: istore 6
    //   445: iload 5
    //   447: istore 7
    //   449: aload_3
    //   450: invokeinterface 252 1 0
    //   455: pop
    //   456: iload 5
    //   458: istore 6
    //   460: iload 5
    //   462: istore 7
    //   464: aload_0
    //   465: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   468: invokestatic 312	com/tencent/mobileqq/nearby/redtouch/Util:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   471: istore 12
    //   473: iload 8
    //   475: iload 12
    //   477: if_icmpeq +20 -> 497
    //   480: iload 5
    //   482: istore 6
    //   484: iload 5
    //   486: istore 7
    //   488: aload_0
    //   489: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   492: iload 12
    //   494: invokestatic 336	com/tencent/mobileqq/nearby/redtouch/Util:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Z)V
    //   497: iload 9
    //   499: istore 5
    //   501: iload 11
    //   503: istore 6
    //   505: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   508: ifeq +40 -> 548
    //   511: iload 11
    //   513: istore 6
    //   515: ldc 95
    //   517: iconst_2
    //   518: new 18	java/lang/StringBuilder
    //   521: dup
    //   522: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   525: ldc_w 338
    //   528: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: aload_2
    //   532: getfield 315	com/tencent/mobileqq/data/Card:medalSwitchDisable	Z
    //   535: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   538: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   541: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   544: iload 9
    //   546: istore 5
    //   548: iload 5
    //   550: istore 6
    //   552: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   555: ifeq +53 -> 608
    //   558: ldc 95
    //   560: iconst_2
    //   561: new 18	java/lang/StringBuilder
    //   564: dup
    //   565: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   568: ldc_w 307
    //   571: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: iload 5
    //   576: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   579: ldc_w 340
    //   582: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: aload_1
    //   586: getfield 281	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   589: ldc_w 283
    //   592: invokevirtual 289	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   595: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   598: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   601: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   604: iload 5
    //   606: istore 6
    //   608: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   611: ifeq +66 -> 677
    //   614: aload_0
    //   615: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   618: bipush 50
    //   620: invokevirtual 112	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   623: checkcast 114	com/tencent/mobileqq/app/FriendsManager
    //   626: aload_0
    //   627: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   630: invokevirtual 117	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   633: invokevirtual 120	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   636: astore_1
    //   637: ldc 95
    //   639: iconst_2
    //   640: new 18	java/lang/StringBuilder
    //   643: dup
    //   644: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   647: ldc_w 342
    //   650: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   653: aload_1
    //   654: getfield 315	com/tencent/mobileqq/data/Card:medalSwitchDisable	Z
    //   657: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   660: ldc_w 300
    //   663: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: iload 6
    //   668: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   671: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   674: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   677: aload_0
    //   678: bipush 76
    //   680: iload 6
    //   682: aconst_null
    //   683: invokevirtual 198	com/tencent/mobileqq/app/CardHandler:a	(IZLjava/lang/Object;)V
    //   686: return
    //   687: iconst_0
    //   688: istore 5
    //   690: goto -667 -> 23
    //   693: iconst_0
    //   694: istore 5
    //   696: goto -581 -> 115
    //   699: iload 4
    //   701: i2l
    //   702: lstore 13
    //   704: goto -447 -> 257
    //   707: iconst_0
    //   708: istore 5
    //   710: goto -162 -> 548
    //   713: astore_2
    //   714: iload 6
    //   716: istore 5
    //   718: iload 5
    //   720: istore 6
    //   722: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   725: ifeq +17 -> 742
    //   728: iload 5
    //   730: istore 6
    //   732: ldc 95
    //   734: iconst_2
    //   735: ldc_w 344
    //   738: aload_2
    //   739: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   742: iload 5
    //   744: istore 6
    //   746: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   749: ifeq -141 -> 608
    //   752: ldc 95
    //   754: iconst_2
    //   755: new 18	java/lang/StringBuilder
    //   758: dup
    //   759: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   762: ldc_w 307
    //   765: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   768: iload 5
    //   770: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   773: ldc_w 340
    //   776: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   779: aload_1
    //   780: getfield 281	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   783: ldc_w 283
    //   786: invokevirtual 289	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   789: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   792: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   795: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   798: iload 5
    //   800: istore 6
    //   802: goto -194 -> 608
    //   805: astore_2
    //   806: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   809: ifeq +49 -> 858
    //   812: ldc 95
    //   814: iconst_2
    //   815: new 18	java/lang/StringBuilder
    //   818: dup
    //   819: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   822: ldc_w 307
    //   825: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   828: iload 7
    //   830: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   833: ldc_w 340
    //   836: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   839: aload_1
    //   840: getfield 281	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   843: ldc_w 283
    //   846: invokevirtual 289	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   849: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   852: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   855: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   858: aload_2
    //   859: athrow
    //   860: astore_2
    //   861: iload 6
    //   863: istore 7
    //   865: goto -59 -> 806
    //   868: astore_2
    //   869: iload 10
    //   871: istore 5
    //   873: goto -155 -> 718
    //   876: iload 8
    //   878: istore 5
    //   880: goto -332 -> 548
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	883	0	this	CardHandler
    //   0	883	1	paramToServiceMsg	ToServiceMsg
    //   0	883	2	paramFromServiceMsg	FromServiceMsg
    //   0	883	3	paramObject	Object
    //   241	459	4	i	int
    //   21	858	5	bool1	boolean
    //   67	795	6	bool2	boolean
    //   71	793	7	bool3	boolean
    //   58	819	8	bool4	boolean
    //   7	538	9	bool5	boolean
    //   1	869	10	bool6	boolean
    //   4	508	11	bool7	boolean
    //   471	22	12	bool8	boolean
    //   255	448	13	l	long
    // Exception table:
    //   from	to	target	type
    //   73	94	713	java/lang/Exception
    //   102	112	713	java/lang/Exception
    //   123	129	713	java/lang/Exception
    //   137	164	713	java/lang/Exception
    //   185	195	713	java/lang/Exception
    //   207	217	713	java/lang/Exception
    //   225	243	713	java/lang/Exception
    //   265	283	713	java/lang/Exception
    //   291	300	713	java/lang/Exception
    //   308	321	713	java/lang/Exception
    //   329	341	713	java/lang/Exception
    //   349	363	713	java/lang/Exception
    //   371	377	713	java/lang/Exception
    //   385	419	713	java/lang/Exception
    //   427	441	713	java/lang/Exception
    //   449	456	713	java/lang/Exception
    //   464	473	713	java/lang/Exception
    //   488	497	713	java/lang/Exception
    //   73	94	805	finally
    //   102	112	805	finally
    //   123	129	805	finally
    //   137	164	805	finally
    //   185	195	805	finally
    //   207	217	805	finally
    //   225	243	805	finally
    //   265	283	805	finally
    //   291	300	805	finally
    //   308	321	805	finally
    //   329	341	805	finally
    //   349	363	805	finally
    //   371	377	805	finally
    //   385	419	805	finally
    //   427	441	805	finally
    //   449	456	805	finally
    //   464	473	805	finally
    //   488	497	805	finally
    //   505	511	860	finally
    //   515	544	860	finally
    //   722	728	860	finally
    //   732	742	860	finally
    //   505	511	868	java/lang/Exception
    //   515	544	868	java/lang/Exception
  }
  
  private void F(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = false;
    paramToServiceMsg = null;
    oidb_0x93b.RspBody localRspBody = new oidb_0x93b.RspBody();
    int i = a(paramFromServiceMsg, paramObject, localRspBody);
    if (i == 0)
    {
      paramFromServiceMsg = String.valueOf(localRspBody.uint64_uin.get());
      paramObject = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      paramToServiceMsg = paramObject.b(paramFromServiceMsg);
      if (localRspBody.str_name.has())
      {
        paramToServiceMsg.strCampusName = localRspBody.str_name.get();
        if (!TextUtils.isEmpty(paramToServiceMsg.strCampusName)) {
          paramObject.c(paramFromServiceMsg, paramToServiceMsg.strCampusName);
        }
      }
      if (localRspBody.str_school_info.has()) {
        paramToServiceMsg.strCampusAcademy = localRspBody.str_school_info.get();
      }
      if (localRspBody.bytes_skey.has()) {
        paramToServiceMsg.tempChatSig = localRspBody.bytes_skey.get().toByteArray();
      }
      if (localRspBody.uint32_flag.has()) {
        paramToServiceMsg.nCampusStatus = localRspBody.uint32_flag.get();
      }
      if (localRspBody.str_school.has()) {
        paramToServiceMsg.strCampusSchool = localRspBody.str_school.get();
      }
      if (localRspBody.str_college.has()) {
        paramToServiceMsg.strCampusCollege = localRspBody.str_college.get();
      }
      if (localRspBody.str_class.has()) {
        paramToServiceMsg.strCampusClass = localRspBody.str_class.get();
      }
      if (localRspBody.uint32_admission_year.has()) {
        paramToServiceMsg.nCampusEnrolYear = localRspBody.uint32_admission_year.get();
      }
      if (localRspBody.uint32_school_id.has())
      {
        paramToServiceMsg.lCampusSchoolID = localRspBody.uint32_school_id.get();
        if (paramToServiceMsg.lCampusSchoolID == 0L) {
          break label469;
        }
        paramToServiceMsg.nCampusSchoolFlag = 1;
      }
      if (localRspBody.uint32_school_type.has()) {
        if (localRspBody.uint32_school_type.get() == 0) {
          break label477;
        }
      }
    }
    label469:
    label477:
    for (paramToServiceMsg.nCampusSchoolFlag = 1;; paramToServiceMsg.nCampusSchoolFlag = 0)
    {
      paramObject.a(paramToServiceMsg);
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, String.format(Locale.getDefault(), "handleGetCampusInfo [status:%d, uin: %s , name: %s school: %s  college: %s enrolYear: %d class: %s academy: %s ]", new Object[] { Integer.valueOf(paramToServiceMsg.nCampusStatus), paramFromServiceMsg, paramToServiceMsg.strCampusName, paramToServiceMsg.strCampusSchool, paramToServiceMsg.strCampusCollege, Integer.valueOf(paramToServiceMsg.nCampusEnrolYear), paramToServiceMsg.strCampusClass, paramToServiceMsg.strCampusAcademy }));
      }
      bool = true;
      a(85, bool, paramToServiceMsg);
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, String.format(Locale.getDefault(), "handleGetCampusInfo result: %d ", new Object[] { Integer.valueOf(i) }));
      }
      return;
      paramToServiceMsg.nCampusSchoolFlag = 0;
      break;
    }
  }
  
  private void G(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool5 = true;
    FriendsManager localFriendsManager;
    boolean bool3;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "handleGetMedalSwitch success=" + bool1);
      }
      paramFromServiceMsg = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c();
      localFriendsManager = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      paramToServiceMsg = localFriendsManager.b(paramFromServiceMsg);
      bool3 = bool1;
      if (bool1)
      {
        bool2 = bool1;
        bool4 = bool1;
      }
    }
    for (;;)
    {
      try
      {
        paramObject = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        bool2 = bool1;
        bool4 = bool1;
        if (paramObject.uint32_result.get() != 0) {
          continue;
        }
        bool1 = true;
        bool2 = bool1;
        bool4 = bool1;
        if (QLog.isColorLevel())
        {
          bool2 = bool1;
          bool4 = bool1;
          QLog.d("Q.profilecard.", 2, "handleGetMedalSwitch result=" + bool1);
        }
        bool3 = bool1;
        if (bool1)
        {
          bool3 = bool1;
          bool2 = bool1;
          bool4 = bool1;
          if (paramObject.bytes_bodybuffer.has())
          {
            bool3 = bool1;
            bool2 = bool1;
            bool4 = bool1;
            if (paramObject.bytes_bodybuffer.get() != null)
            {
              bool2 = bool1;
              bool4 = bool1;
              oidb_0x5eb.RspBody localRspBody = new oidb_0x5eb.RspBody();
              bool2 = bool1;
              bool4 = bool1;
              localRspBody.mergeFrom(paramObject.bytes_bodybuffer.get().toByteArray());
              bool3 = bool1;
              bool2 = bool1;
              bool4 = bool1;
              if (localRspBody.rpt_msg_uin_data.has())
              {
                bool3 = bool1;
                bool2 = bool1;
                bool4 = bool1;
                if (localRspBody.rpt_msg_uin_data.get().size() > 0)
                {
                  bool2 = bool1;
                  bool4 = bool1;
                  boolean bool6 = Util.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
                  bool2 = bool1;
                  bool4 = bool1;
                  if (((oidb_0x5eb.UdcUinData)localRspBody.rpt_msg_uin_data.get().get(0)).uint32_req_medalwall_flag.get() == 0) {
                    continue;
                  }
                  bool3 = bool5;
                  bool2 = bool1;
                  bool4 = bool1;
                  paramToServiceMsg.medalSwitchDisable = bool3;
                  bool2 = bool1;
                  bool4 = bool1;
                  localFriendsManager.a(paramToServiceMsg);
                  bool2 = bool1;
                  bool4 = bool1;
                  paramFromServiceMsg = BaseApplicationImpl.getApplication().getSharedPreferences("medal_wall_" + paramFromServiceMsg, 4).edit();
                  bool2 = bool1;
                  bool4 = bool1;
                  paramFromServiceMsg.putBoolean("medal_switch_disable", paramToServiceMsg.medalSwitchDisable);
                  bool2 = bool1;
                  bool4 = bool1;
                  paramFromServiceMsg.commit();
                  bool2 = bool1;
                  bool4 = bool1;
                  bool5 = Util.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
                  bool3 = bool1;
                  if (bool6 != bool5)
                  {
                    bool2 = bool1;
                    bool4 = bool1;
                    Util.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, bool5);
                    bool3 = bool1;
                  }
                }
              }
            }
          }
        }
        bool1 = bool3;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.profilecard.", 2, "handleGetMedalSwitch result=" + bool3 + ";medal=" + paramToServiceMsg.medalSwitchDisable);
          bool1 = bool3;
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        bool4 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        bool4 = bool2;
        QLog.d("Q.profilecard.", 2, "handleGetMedalSwitch ex", paramFromServiceMsg);
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.", 2, "handleGetMedalSwitch result=" + bool2 + ";medal=" + paramToServiceMsg.medalSwitchDisable);
        bool1 = bool2;
        continue;
      }
      finally
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.", 2, "handleGetMedalSwitch result=" + bool4 + ";medal=" + paramToServiceMsg.medalSwitchDisable);
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "handleGetMedalSwitch result=" + bool1 + ";medal=" + paramToServiceMsg.medalSwitchDisable);
      }
      a(77, bool1, Boolean.valueOf(paramToServiceMsg.medalSwitchDisable));
      return;
      bool1 = false;
      break;
      bool1 = false;
      continue;
      bool3 = false;
    }
  }
  
  /* Error */
  private void H(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 10
    //   3: iconst_0
    //   4: istore 12
    //   6: iconst_0
    //   7: istore 11
    //   9: aload_2
    //   10: invokevirtual 88	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   13: ifeq +405 -> 418
    //   16: aload_3
    //   17: ifnull +401 -> 418
    //   20: iconst_1
    //   21: istore 5
    //   23: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +30 -> 56
    //   29: ldc 95
    //   31: iconst_2
    //   32: new 18	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   39: ldc_w 492
    //   42: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: iload 5
    //   47: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   50: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: aload_0
    //   57: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   60: bipush 84
    //   62: invokevirtual 112	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   65: checkcast 494	com/tencent/mobileqq/app/activateFriends/ActivateFriendsManager
    //   68: astore_1
    //   69: aload_1
    //   70: iconst_0
    //   71: invokevirtual 497	com/tencent/mobileqq/app/activateFriends/ActivateFriendsManager:a	(Z)Z
    //   74: istore 6
    //   76: iload 5
    //   78: istore 9
    //   80: iload 5
    //   82: ifeq +600 -> 682
    //   85: iload 5
    //   87: istore 7
    //   89: iload 5
    //   91: istore 8
    //   93: new 122	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   96: dup
    //   97: invokespecial 123	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   100: aload_3
    //   101: checkcast 125	[B
    //   104: checkcast 125	[B
    //   107: invokevirtual 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   110: checkcast 122	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   113: astore_2
    //   114: aload_2
    //   115: ifnull +309 -> 424
    //   118: iload 5
    //   120: istore 7
    //   122: iload 5
    //   124: istore 8
    //   126: aload_2
    //   127: getfield 133	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   130: invokevirtual 138	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   133: ifne +291 -> 424
    //   136: iconst_1
    //   137: istore 5
    //   139: iload 5
    //   141: istore 7
    //   143: iload 5
    //   145: istore 8
    //   147: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   150: ifeq +38 -> 188
    //   153: iload 5
    //   155: istore 7
    //   157: iload 5
    //   159: istore 8
    //   161: ldc 95
    //   163: iconst_2
    //   164: new 18	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   171: ldc_w 499
    //   174: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: iload 5
    //   179: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   182: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   188: iload 5
    //   190: istore 9
    //   192: iload 5
    //   194: ifeq +488 -> 682
    //   197: iload 5
    //   199: istore 7
    //   201: iload 5
    //   203: istore 8
    //   205: iload 5
    //   207: istore 9
    //   209: aload_2
    //   210: getfield 144	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   213: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   216: ifeq +466 -> 682
    //   219: iload 5
    //   221: istore 7
    //   223: iload 5
    //   225: istore 8
    //   227: iload 5
    //   229: istore 9
    //   231: aload_2
    //   232: getfield 144	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   235: invokevirtual 152	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   238: ifnull +444 -> 682
    //   241: iload 5
    //   243: istore 7
    //   245: iload 5
    //   247: istore 8
    //   249: aload_2
    //   250: getfield 144	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   253: invokevirtual 152	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   256: invokevirtual 158	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   259: invokestatic 164	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   262: astore_2
    //   263: iload 5
    //   265: istore 7
    //   267: iload 5
    //   269: istore 8
    //   271: aload_2
    //   272: invokevirtual 167	java/nio/ByteBuffer:getInt	()I
    //   275: pop
    //   276: iload 5
    //   278: istore 7
    //   280: iload 5
    //   282: istore 8
    //   284: aload_2
    //   285: invokevirtual 170	java/nio/ByteBuffer:get	()B
    //   288: pop
    //   289: iload 5
    //   291: istore 7
    //   293: iload 5
    //   295: istore 8
    //   297: iload 5
    //   299: istore 9
    //   301: aload_2
    //   302: invokevirtual 174	java/nio/ByteBuffer:getShort	()S
    //   305: invokestatic 179	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   308: invokevirtual 182	java/lang/Short:shortValue	()S
    //   311: iconst_1
    //   312: if_icmpne +370 -> 682
    //   315: iload 5
    //   317: istore 7
    //   319: iload 5
    //   321: istore 8
    //   323: aload_2
    //   324: invokevirtual 174	java/nio/ByteBuffer:getShort	()S
    //   327: istore 4
    //   329: iload 4
    //   331: sipush -25031
    //   334: if_icmpeq +96 -> 430
    //   337: iload 6
    //   339: istore 5
    //   341: iload 11
    //   343: istore 6
    //   345: iload 5
    //   347: istore 7
    //   349: iload 6
    //   351: istore 8
    //   353: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   356: ifeq +48 -> 404
    //   359: ldc 95
    //   361: iconst_2
    //   362: new 18	java/lang/StringBuilder
    //   365: dup
    //   366: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   369: ldc_w 499
    //   372: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: iload 6
    //   377: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   380: ldc 184
    //   382: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: iload 5
    //   387: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   390: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   393: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   396: iload 6
    //   398: istore 8
    //   400: iload 5
    //   402: istore 7
    //   404: aload_0
    //   405: bipush 58
    //   407: iload 8
    //   409: iload 7
    //   411: invokestatic 195	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   414: invokevirtual 198	com/tencent/mobileqq/app/CardHandler:a	(IZLjava/lang/Object;)V
    //   417: return
    //   418: iconst_0
    //   419: istore 5
    //   421: goto -398 -> 23
    //   424: iconst_0
    //   425: istore 5
    //   427: goto -288 -> 139
    //   430: iload 5
    //   432: istore 7
    //   434: iload 5
    //   436: istore 8
    //   438: aload_2
    //   439: invokevirtual 174	java/nio/ByteBuffer:getShort	()S
    //   442: istore 4
    //   444: iload 4
    //   446: iconst_2
    //   447: if_icmpne +80 -> 527
    //   450: iload 5
    //   452: istore 7
    //   454: iload 5
    //   456: istore 8
    //   458: iload 4
    //   460: newarray byte
    //   462: astore_3
    //   463: iload 5
    //   465: istore 7
    //   467: iload 5
    //   469: istore 8
    //   471: aload_2
    //   472: aload_3
    //   473: invokevirtual 200	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   476: pop
    //   477: iload 5
    //   479: istore 7
    //   481: iload 5
    //   483: istore 8
    //   485: aload_3
    //   486: iconst_0
    //   487: invokestatic 205	com/tencent/mobileqq/util/Utils:a	([BI)S
    //   490: istore 4
    //   492: iload 4
    //   494: ifne +210 -> 704
    //   497: iconst_1
    //   498: istore 6
    //   500: aload_2
    //   501: invokevirtual 174	java/nio/ByteBuffer:getShort	()S
    //   504: ifeq +10 -> 514
    //   507: iload 12
    //   509: istore 7
    //   511: goto +182 -> 693
    //   514: aload_1
    //   515: iload 6
    //   517: iconst_0
    //   518: invokevirtual 502	com/tencent/mobileqq/app/activateFriends/ActivateFriendsManager:a	(ZZ)V
    //   521: iconst_1
    //   522: istore 7
    //   524: goto +169 -> 693
    //   527: iload 6
    //   529: istore 5
    //   531: iload 11
    //   533: istore 6
    //   535: goto -190 -> 345
    //   538: astore_1
    //   539: iload 7
    //   541: istore 5
    //   543: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   546: ifeq +13 -> 559
    //   549: ldc 95
    //   551: iconst_2
    //   552: ldc_w 504
    //   555: aload_1
    //   556: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   559: iload 6
    //   561: istore 7
    //   563: iload 10
    //   565: istore 8
    //   567: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   570: ifeq -166 -> 404
    //   573: ldc 95
    //   575: iconst_2
    //   576: new 18	java/lang/StringBuilder
    //   579: dup
    //   580: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   583: ldc_w 499
    //   586: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: iconst_0
    //   590: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   593: ldc 184
    //   595: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   598: iload 6
    //   600: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   603: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   606: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   609: iload 6
    //   611: istore 7
    //   613: iload 10
    //   615: istore 8
    //   617: goto -213 -> 404
    //   620: astore_1
    //   621: iload 8
    //   623: istore 5
    //   625: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   628: ifeq +40 -> 668
    //   631: ldc 95
    //   633: iconst_2
    //   634: new 18	java/lang/StringBuilder
    //   637: dup
    //   638: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   641: ldc_w 499
    //   644: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   647: iload 5
    //   649: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   652: ldc 184
    //   654: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   657: iload 6
    //   659: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   662: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   665: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   668: aload_1
    //   669: athrow
    //   670: astore_1
    //   671: goto -46 -> 625
    //   674: astore_1
    //   675: goto -50 -> 625
    //   678: astore_1
    //   679: goto -136 -> 543
    //   682: iload 6
    //   684: istore 5
    //   686: iload 9
    //   688: istore 6
    //   690: goto -345 -> 345
    //   693: iload 6
    //   695: istore 5
    //   697: iload 7
    //   699: istore 6
    //   701: goto -356 -> 345
    //   704: iconst_0
    //   705: istore 6
    //   707: goto -207 -> 500
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	710	0	this	CardHandler
    //   0	710	1	paramToServiceMsg	ToServiceMsg
    //   0	710	2	paramFromServiceMsg	FromServiceMsg
    //   0	710	3	paramObject	Object
    //   327	166	4	i	int
    //   21	675	5	bool1	boolean
    //   74	632	6	bool2	boolean
    //   87	611	7	bool3	boolean
    //   91	531	8	bool4	boolean
    //   78	609	9	bool5	boolean
    //   1	613	10	bool6	boolean
    //   7	525	11	bool7	boolean
    //   4	504	12	bool8	boolean
    // Exception table:
    //   from	to	target	type
    //   93	114	538	java/lang/Exception
    //   126	136	538	java/lang/Exception
    //   147	153	538	java/lang/Exception
    //   161	188	538	java/lang/Exception
    //   209	219	538	java/lang/Exception
    //   231	241	538	java/lang/Exception
    //   249	263	538	java/lang/Exception
    //   271	276	538	java/lang/Exception
    //   284	289	538	java/lang/Exception
    //   301	315	538	java/lang/Exception
    //   323	329	538	java/lang/Exception
    //   438	444	538	java/lang/Exception
    //   458	463	538	java/lang/Exception
    //   471	477	538	java/lang/Exception
    //   485	492	538	java/lang/Exception
    //   93	114	620	finally
    //   126	136	620	finally
    //   147	153	620	finally
    //   161	188	620	finally
    //   209	219	620	finally
    //   231	241	620	finally
    //   249	263	620	finally
    //   271	276	620	finally
    //   284	289	620	finally
    //   301	315	620	finally
    //   323	329	620	finally
    //   438	444	620	finally
    //   458	463	620	finally
    //   471	477	620	finally
    //   485	492	620	finally
    //   500	507	670	finally
    //   514	521	670	finally
    //   543	559	674	finally
    //   500	507	678	java/lang/Exception
    //   514	521	678	java/lang/Exception
  }
  
  private void I(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool7 = true;
    boolean bool6 = false;
    boolean bool1;
    boolean bool2;
    boolean bool5;
    boolean bool4;
    boolean bool3;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "handleSetActivateFriendSwitch success=" + bool1);
      }
      paramFromServiceMsg = (ActivateFriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(84);
      bool2 = paramFromServiceMsg.a(false);
      bool5 = bool1;
      if (!bool1) {
        break label651;
      }
      bool4 = bool1;
      bool3 = bool1;
    }
    for (;;)
    {
      try
      {
        paramObject = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if (paramObject != null)
        {
          bool4 = bool1;
          bool3 = bool1;
          if (paramObject.uint32_result.get() == 0)
          {
            bool1 = true;
            bool4 = bool1;
            bool3 = bool1;
            if (QLog.isColorLevel())
            {
              bool4 = bool1;
              bool3 = bool1;
              QLog.d("Q.profilecard.", 2, "handleSetActivateFriendSwitch result=" + bool1);
            }
            bool5 = bool1;
            if (!bool1) {
              break label651;
            }
            bool4 = bool1;
            bool3 = bool1;
            bool5 = bool1;
            if (!paramObject.bytes_bodybuffer.has()) {
              break label651;
            }
            bool4 = bool1;
            bool3 = bool1;
            bool5 = bool1;
            if (paramObject.bytes_bodybuffer.get() == null) {
              break label651;
            }
            bool4 = bool1;
            bool3 = bool1;
            l = Utils.a(ByteBuffer.wrap(paramObject.bytes_bodybuffer.get().toByteArray()).getInt());
            bool4 = bool1;
            bool3 = bool1;
            if (!this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(String.valueOf(l))) {
              continue;
            }
            bool4 = bool1;
            bool3 = bool1;
            bool5 = paramToServiceMsg.extraData.getBoolean("switch");
            bool3 = bool1;
          }
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        long l;
        bool1 = bool4;
        bool3 = bool1;
        if (QLog.isColorLevel())
        {
          bool3 = bool1;
          QLog.d("Q.profilecard.", 2, "handleSetActivateFriendSwitch ex", paramFromServiceMsg);
        }
        bool3 = bool2;
        bool1 = bool6;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.", 2, "handleSetActivateFriendSwitch result=" + false + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
        bool3 = bool2;
        bool1 = bool6;
        continue;
      }
      finally
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.", 2, "handleSetActivateFriendSwitch result=" + bool3 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
        }
      }
      try
      {
        paramFromServiceMsg.a(bool5, false);
        bool2 = bool5;
        bool1 = bool7;
        if (!QLog.isColorLevel()) {
          break label644;
        }
        QLog.d("Q.profilecard.", 2, "handleSetActivateFriendSwitch result=" + bool1 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
        bool3 = bool2;
      }
      catch (Exception paramFromServiceMsg)
      {
        bool2 = bool5;
        continue;
        bool3 = bool2;
        continue;
      }
      a(57, bool1, Boolean.valueOf(bool3));
      return;
      bool1 = false;
      break;
      bool1 = false;
      continue;
      bool4 = bool1;
      bool3 = bool1;
      if (QLog.isColorLevel())
      {
        bool4 = bool1;
        bool3 = bool1;
        QLog.d("Q.profilecard.", 2, "handleSetActivateFriendSwitch cur:" + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + " dwUin:" + l);
      }
      bool1 = false;
      continue;
      label644:
      label651:
      bool1 = bool5;
    }
  }
  
  /* Error */
  private void J(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 10
    //   3: aload_2
    //   4: invokevirtual 88	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   7: ifeq +412 -> 419
    //   10: aload_3
    //   11: ifnull +408 -> 419
    //   14: iconst_1
    //   15: istore 6
    //   17: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +30 -> 50
    //   23: ldc 95
    //   25: iconst_2
    //   26: new 18	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   33: ldc_w 519
    //   36: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: iload 6
    //   41: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   44: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: aload_0
    //   51: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   54: bipush 50
    //   56: invokevirtual 112	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   59: checkcast 114	com/tencent/mobileqq/app/FriendsManager
    //   62: astore_1
    //   63: aload_1
    //   64: getstatic 522	com/tencent/mobileqq/app/AppConstants:au	Ljava/lang/String;
    //   67: invokevirtual 120	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   70: astore_2
    //   71: iload 6
    //   73: istore 9
    //   75: iload 6
    //   77: ifeq +631 -> 708
    //   80: iload 6
    //   82: istore 7
    //   84: iload 6
    //   86: istore 8
    //   88: new 122	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   91: dup
    //   92: invokespecial 123	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   95: aload_3
    //   96: checkcast 125	[B
    //   99: checkcast 125	[B
    //   102: invokevirtual 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   105: checkcast 122	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   108: astore_3
    //   109: aload_3
    //   110: ifnull +315 -> 425
    //   113: iload 6
    //   115: istore 7
    //   117: iload 6
    //   119: istore 8
    //   121: aload_3
    //   122: getfield 133	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   125: invokevirtual 138	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   128: ifne +297 -> 425
    //   131: iconst_1
    //   132: istore 6
    //   134: iload 6
    //   136: istore 7
    //   138: iload 6
    //   140: istore 8
    //   142: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   145: ifeq +38 -> 183
    //   148: iload 6
    //   150: istore 7
    //   152: iload 6
    //   154: istore 8
    //   156: ldc 95
    //   158: iconst_2
    //   159: new 18	java/lang/StringBuilder
    //   162: dup
    //   163: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   166: ldc_w 524
    //   169: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: iload 6
    //   174: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   177: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   180: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   183: iload 6
    //   185: istore 9
    //   187: iload 6
    //   189: ifeq +519 -> 708
    //   192: iload 6
    //   194: istore 7
    //   196: iload 6
    //   198: istore 8
    //   200: iload 6
    //   202: istore 9
    //   204: aload_3
    //   205: getfield 144	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   208: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   211: ifeq +497 -> 708
    //   214: iload 6
    //   216: istore 7
    //   218: iload 6
    //   220: istore 8
    //   222: iload 6
    //   224: istore 9
    //   226: aload_3
    //   227: getfield 144	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   230: invokevirtual 152	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   233: ifnull +475 -> 708
    //   236: iload 6
    //   238: istore 7
    //   240: iload 6
    //   242: istore 8
    //   244: aload_3
    //   245: getfield 144	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   248: invokevirtual 152	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   251: invokevirtual 158	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   254: invokestatic 164	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   257: astore_3
    //   258: iload 6
    //   260: istore 7
    //   262: iload 6
    //   264: istore 8
    //   266: aload_3
    //   267: invokevirtual 167	java/nio/ByteBuffer:getInt	()I
    //   270: pop
    //   271: iload 6
    //   273: istore 7
    //   275: iload 6
    //   277: istore 8
    //   279: aload_3
    //   280: invokevirtual 170	java/nio/ByteBuffer:get	()B
    //   283: pop
    //   284: iload 6
    //   286: istore 7
    //   288: iload 6
    //   290: istore 8
    //   292: iload 6
    //   294: istore 9
    //   296: aload_3
    //   297: invokevirtual 174	java/nio/ByteBuffer:getShort	()S
    //   300: invokestatic 179	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   303: invokevirtual 182	java/lang/Short:shortValue	()S
    //   306: iconst_1
    //   307: if_icmpne +401 -> 708
    //   310: iload 6
    //   312: istore 7
    //   314: iload 6
    //   316: istore 8
    //   318: aload_3
    //   319: invokevirtual 174	java/nio/ByteBuffer:getShort	()S
    //   322: istore 4
    //   324: iload 6
    //   326: istore 7
    //   328: iload 6
    //   330: istore 8
    //   332: aload_0
    //   333: getfield 64	com/tencent/mobileqq/app/CardHandler:e	S
    //   336: istore 5
    //   338: iload 4
    //   340: iload 5
    //   342: if_icmpeq +89 -> 431
    //   345: iload 10
    //   347: istore 7
    //   349: iload 7
    //   351: istore 8
    //   353: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   356: ifeq +47 -> 403
    //   359: ldc 95
    //   361: iconst_2
    //   362: new 18	java/lang/StringBuilder
    //   365: dup
    //   366: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   369: ldc_w 524
    //   372: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: iload 7
    //   377: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   380: ldc_w 526
    //   383: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: aload_2
    //   387: getfield 529	com/tencent/mobileqq/data/Card:babyQSwitch	Z
    //   390: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   393: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   396: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   399: iload 7
    //   401: istore 8
    //   403: aload_0
    //   404: bipush 75
    //   406: iload 8
    //   408: aload_2
    //   409: getfield 529	com/tencent/mobileqq/data/Card:babyQSwitch	Z
    //   412: invokestatic 195	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   415: invokevirtual 198	com/tencent/mobileqq/app/CardHandler:a	(IZLjava/lang/Object;)V
    //   418: return
    //   419: iconst_0
    //   420: istore 6
    //   422: goto -405 -> 17
    //   425: iconst_0
    //   426: istore 6
    //   428: goto -294 -> 134
    //   431: iload 6
    //   433: istore 7
    //   435: iload 6
    //   437: istore 8
    //   439: aload_3
    //   440: invokevirtual 174	java/nio/ByteBuffer:getShort	()S
    //   443: istore 4
    //   445: iload 10
    //   447: istore 7
    //   449: iload 4
    //   451: iconst_2
    //   452: if_icmpne -103 -> 349
    //   455: iload 6
    //   457: istore 7
    //   459: iload 6
    //   461: istore 8
    //   463: iload 4
    //   465: newarray byte
    //   467: astore 11
    //   469: iload 6
    //   471: istore 7
    //   473: iload 6
    //   475: istore 8
    //   477: aload_3
    //   478: aload 11
    //   480: invokevirtual 200	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   483: pop
    //   484: iload 6
    //   486: istore 7
    //   488: iload 6
    //   490: istore 8
    //   492: aload 11
    //   494: iconst_0
    //   495: invokestatic 205	com/tencent/mobileqq/util/Utils:a	([BI)S
    //   498: ifne +55 -> 553
    //   501: iconst_1
    //   502: istore 9
    //   504: iload 6
    //   506: istore 7
    //   508: iload 6
    //   510: istore 8
    //   512: aload_2
    //   513: iload 9
    //   515: putfield 529	com/tencent/mobileqq/data/Card:babyQSwitch	Z
    //   518: iload 6
    //   520: istore 7
    //   522: iload 6
    //   524: istore 8
    //   526: aload_3
    //   527: invokevirtual 174	java/nio/ByteBuffer:getShort	()S
    //   530: istore 4
    //   532: iload 10
    //   534: istore 7
    //   536: iload 4
    //   538: ifne -189 -> 349
    //   541: aload_1
    //   542: aload_2
    //   543: invokevirtual 208	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   546: pop
    //   547: iconst_1
    //   548: istore 7
    //   550: goto -201 -> 349
    //   553: iconst_0
    //   554: istore 9
    //   556: goto -52 -> 504
    //   559: astore_1
    //   560: iload 7
    //   562: istore 6
    //   564: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   567: ifeq +13 -> 580
    //   570: ldc 95
    //   572: iconst_2
    //   573: ldc_w 531
    //   576: aload_1
    //   577: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   580: iload 6
    //   582: istore 8
    //   584: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   587: ifeq -184 -> 403
    //   590: ldc 95
    //   592: iconst_2
    //   593: new 18	java/lang/StringBuilder
    //   596: dup
    //   597: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   600: ldc_w 524
    //   603: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: iload 6
    //   608: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   611: ldc_w 526
    //   614: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   617: aload_2
    //   618: getfield 529	com/tencent/mobileqq/data/Card:babyQSwitch	Z
    //   621: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   624: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   627: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   630: iload 6
    //   632: istore 8
    //   634: goto -231 -> 403
    //   637: astore_1
    //   638: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   641: ifeq +43 -> 684
    //   644: ldc 95
    //   646: iconst_2
    //   647: new 18	java/lang/StringBuilder
    //   650: dup
    //   651: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   654: ldc_w 524
    //   657: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: iload 8
    //   662: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   665: ldc_w 526
    //   668: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   671: aload_2
    //   672: getfield 529	com/tencent/mobileqq/data/Card:babyQSwitch	Z
    //   675: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   678: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   681: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   684: aload_1
    //   685: athrow
    //   686: astore_1
    //   687: iconst_1
    //   688: istore 8
    //   690: goto -52 -> 638
    //   693: astore_1
    //   694: iload 6
    //   696: istore 8
    //   698: goto -60 -> 638
    //   701: astore_1
    //   702: iconst_1
    //   703: istore 6
    //   705: goto -141 -> 564
    //   708: iload 9
    //   710: istore 7
    //   712: goto -363 -> 349
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	715	0	this	CardHandler
    //   0	715	1	paramToServiceMsg	ToServiceMsg
    //   0	715	2	paramFromServiceMsg	FromServiceMsg
    //   0	715	3	paramObject	Object
    //   322	215	4	i	int
    //   336	7	5	j	int
    //   15	689	6	bool1	boolean
    //   82	629	7	bool2	boolean
    //   86	611	8	bool3	boolean
    //   73	636	9	bool4	boolean
    //   1	532	10	bool5	boolean
    //   467	26	11	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   88	109	559	java/lang/Exception
    //   121	131	559	java/lang/Exception
    //   142	148	559	java/lang/Exception
    //   156	183	559	java/lang/Exception
    //   204	214	559	java/lang/Exception
    //   226	236	559	java/lang/Exception
    //   244	258	559	java/lang/Exception
    //   266	271	559	java/lang/Exception
    //   279	284	559	java/lang/Exception
    //   296	310	559	java/lang/Exception
    //   318	324	559	java/lang/Exception
    //   332	338	559	java/lang/Exception
    //   439	445	559	java/lang/Exception
    //   463	469	559	java/lang/Exception
    //   477	484	559	java/lang/Exception
    //   492	501	559	java/lang/Exception
    //   512	518	559	java/lang/Exception
    //   526	532	559	java/lang/Exception
    //   88	109	637	finally
    //   121	131	637	finally
    //   142	148	637	finally
    //   156	183	637	finally
    //   204	214	637	finally
    //   226	236	637	finally
    //   244	258	637	finally
    //   266	271	637	finally
    //   279	284	637	finally
    //   296	310	637	finally
    //   318	324	637	finally
    //   332	338	637	finally
    //   439	445	637	finally
    //   463	469	637	finally
    //   477	484	637	finally
    //   492	501	637	finally
    //   512	518	637	finally
    //   526	532	637	finally
    //   541	547	686	finally
    //   564	580	693	finally
    //   541	547	701	java/lang/Exception
  }
  
  private void K(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool5 = true;
    boolean bool1;
    boolean bool4;
    boolean bool2;
    boolean bool3;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "handleSetBabyQSwitch success=" + bool1);
      }
      bool4 = bool1;
      if (!bool1) {
        break label606;
      }
      bool2 = bool1;
      bool3 = bool1;
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg == null) {
          continue;
        }
        bool2 = bool1;
        bool3 = bool1;
        if (paramFromServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool1 = true;
        bool2 = bool1;
        bool3 = bool1;
        if (QLog.isColorLevel())
        {
          bool2 = bool1;
          bool3 = bool1;
          QLog.d("Q.profilecard.", 2, "handleSetBabyQSwitch result=" + bool1);
        }
        bool4 = bool1;
        if (!bool1) {
          break label606;
        }
        bool2 = bool1;
        bool3 = bool1;
        bool4 = bool1;
        if (!paramFromServiceMsg.bytes_bodybuffer.has()) {
          break label606;
        }
        bool2 = bool1;
        bool3 = bool1;
        bool4 = bool1;
        if (paramFromServiceMsg.bytes_bodybuffer.get() == null) {
          break label606;
        }
        bool2 = bool1;
        bool3 = bool1;
        i = ByteBuffer.wrap(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray()).getInt();
        if (i >= 0) {
          continue;
        }
        l = i + 4294967296L;
        bool2 = bool1;
        bool3 = bool1;
        if (!this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(String.valueOf(l))) {
          continue;
        }
        bool2 = bool1;
        bool3 = bool1;
        paramFromServiceMsg = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
        bool2 = bool1;
        bool3 = bool1;
        paramObject = paramFromServiceMsg.b(AppConstants.au);
        bool2 = bool1;
        bool3 = bool1;
        paramObject.babyQSwitch = paramToServiceMsg.extraData.getBoolean("switch");
        bool2 = bool1;
        bool3 = bool1;
        paramFromServiceMsg.a(paramObject);
        bool1 = bool5;
        bool3 = bool1;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.profilecard.", 2, "handleSetBabyQSwitch result=" + bool1 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
          bool3 = bool1;
        }
      }
      catch (Exception paramFromServiceMsg) {}finally
      {
        try
        {
          int i;
          long l;
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.", 2, "handleSetBabyQSwitch ex", paramFromServiceMsg);
          }
          bool3 = bool2;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.profilecard.", 2, "handleSetBabyQSwitch result=" + bool2 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
          bool3 = bool2;
          continue;
        }
        finally
        {
          bool3 = bool2;
        }
        paramFromServiceMsg = finally;
      }
      a(74, bool3, Boolean.valueOf(paramToServiceMsg.extraData.getBoolean("switch")));
      return;
      bool1 = false;
      break;
      bool1 = false;
      continue;
      l = i;
      continue;
      bool1 = false;
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "handleSetBabyQSwitch result=" + bool3 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
      }
      throw paramFromServiceMsg;
      label606:
      bool1 = bool4;
    }
  }
  
  /* Error */
  private void L(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 9
    //   3: aload_2
    //   4: invokevirtual 88	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   7: ifeq +393 -> 400
    //   10: aload_3
    //   11: ifnull +389 -> 400
    //   14: iconst_1
    //   15: istore 5
    //   17: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +30 -> 50
    //   23: ldc 95
    //   25: iconst_2
    //   26: new 18	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   33: ldc_w 541
    //   36: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: iload 5
    //   41: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   44: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: aload_0
    //   51: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   54: invokevirtual 544	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   57: ldc_w 545
    //   60: invokevirtual 551	mqq/app/MobileQQ:getString	(I)Ljava/lang/String;
    //   63: pop
    //   64: aload_0
    //   65: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   68: invokevirtual 117	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   71: pop
    //   72: iload 5
    //   74: istore 8
    //   76: iload 5
    //   78: ifeq +557 -> 635
    //   81: iload 5
    //   83: istore 6
    //   85: iload 5
    //   87: istore 7
    //   89: new 122	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   92: dup
    //   93: invokespecial 123	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   96: aload_3
    //   97: checkcast 125	[B
    //   100: checkcast 125	[B
    //   103: invokevirtual 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   106: checkcast 122	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   109: astore_2
    //   110: aload_2
    //   111: ifnull +295 -> 406
    //   114: iload 5
    //   116: istore 6
    //   118: iload 5
    //   120: istore 7
    //   122: aload_2
    //   123: getfield 133	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   126: invokevirtual 138	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   129: ifne +277 -> 406
    //   132: iconst_1
    //   133: istore 5
    //   135: iload 5
    //   137: istore 6
    //   139: iload 5
    //   141: istore 7
    //   143: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   146: ifeq +38 -> 184
    //   149: iload 5
    //   151: istore 6
    //   153: iload 5
    //   155: istore 7
    //   157: ldc 95
    //   159: iconst_2
    //   160: new 18	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   167: ldc_w 553
    //   170: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: iload 5
    //   175: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   178: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   184: iload 5
    //   186: istore 8
    //   188: iload 5
    //   190: ifeq +445 -> 635
    //   193: iload 5
    //   195: istore 6
    //   197: iload 5
    //   199: istore 7
    //   201: iload 5
    //   203: istore 8
    //   205: aload_2
    //   206: getfield 144	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   209: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   212: ifeq +423 -> 635
    //   215: iload 5
    //   217: istore 6
    //   219: iload 5
    //   221: istore 7
    //   223: iload 5
    //   225: istore 8
    //   227: aload_2
    //   228: getfield 144	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   231: invokevirtual 152	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   234: ifnull +401 -> 635
    //   237: iload 5
    //   239: istore 6
    //   241: iload 5
    //   243: istore 7
    //   245: aload_2
    //   246: getfield 144	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   249: invokevirtual 152	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   252: invokevirtual 158	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   255: invokestatic 164	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   258: invokevirtual 167	java/nio/ByteBuffer:getInt	()I
    //   261: istore 4
    //   263: iload 4
    //   265: i2l
    //   266: lstore 10
    //   268: iload 4
    //   270: ifge +16 -> 286
    //   273: iload 4
    //   275: ldc_w 554
    //   278: iand
    //   279: i2l
    //   280: ldc2_w 555
    //   283: lor
    //   284: lstore 10
    //   286: iload 5
    //   288: istore 6
    //   290: iload 5
    //   292: istore 7
    //   294: aload_0
    //   295: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   298: invokevirtual 117	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   301: lload 10
    //   303: invokestatic 272	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   306: invokevirtual 275	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   309: istore 5
    //   311: iload 5
    //   313: ifeq +99 -> 412
    //   316: aload_1
    //   317: getfield 281	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   320: ldc_w 558
    //   323: invokevirtual 561	android/os/Bundle:getShort	(Ljava/lang/String;)S
    //   326: istore 4
    //   328: aload_0
    //   329: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   332: bipush 51
    //   334: invokevirtual 564	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   337: checkcast 566	com/tencent/device/devicemgr/SmartDeviceProxyMgr
    //   340: iload 4
    //   342: invokevirtual 569	com/tencent/device/devicemgr/SmartDeviceProxyMgr:b	(I)V
    //   345: iconst_1
    //   346: istore 5
    //   348: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   351: ifeq +48 -> 399
    //   354: ldc 95
    //   356: iconst_2
    //   357: new 18	java/lang/StringBuilder
    //   360: dup
    //   361: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   364: ldc_w 553
    //   367: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: iload 5
    //   372: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   375: ldc 184
    //   377: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   380: aload_1
    //   381: getfield 281	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   384: ldc_w 558
    //   387: invokevirtual 561	android/os/Bundle:getShort	(Ljava/lang/String;)S
    //   390: invokevirtual 572	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   393: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   396: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   399: return
    //   400: iconst_0
    //   401: istore 5
    //   403: goto -386 -> 17
    //   406: iconst_0
    //   407: istore 5
    //   409: goto -274 -> 135
    //   412: iload 9
    //   414: istore 5
    //   416: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   419: ifeq -71 -> 348
    //   422: ldc 95
    //   424: iconst_2
    //   425: new 18	java/lang/StringBuilder
    //   428: dup
    //   429: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   432: ldc_w 574
    //   435: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: lload 10
    //   440: invokevirtual 326	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   443: ldc_w 576
    //   446: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   449: aload_0
    //   450: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   453: invokevirtual 117	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   456: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   459: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   462: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   465: iload 9
    //   467: istore 5
    //   469: goto -121 -> 348
    //   472: astore_2
    //   473: iconst_0
    //   474: istore 5
    //   476: iload 5
    //   478: istore 6
    //   480: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   483: ifeq +17 -> 500
    //   486: iload 5
    //   488: istore 6
    //   490: ldc 95
    //   492: iconst_2
    //   493: ldc_w 578
    //   496: aload_2
    //   497: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   500: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   503: ifeq -104 -> 399
    //   506: ldc 95
    //   508: iconst_2
    //   509: new 18	java/lang/StringBuilder
    //   512: dup
    //   513: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   516: ldc_w 553
    //   519: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   522: iload 5
    //   524: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   527: ldc 184
    //   529: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: aload_1
    //   533: getfield 281	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   536: ldc_w 558
    //   539: invokevirtual 561	android/os/Bundle:getShort	(Ljava/lang/String;)S
    //   542: invokevirtual 572	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   545: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   548: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   551: return
    //   552: astore_2
    //   553: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   556: ifeq +48 -> 604
    //   559: ldc 95
    //   561: iconst_2
    //   562: new 18	java/lang/StringBuilder
    //   565: dup
    //   566: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   569: ldc_w 553
    //   572: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   575: iload 6
    //   577: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   580: ldc 184
    //   582: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: aload_1
    //   586: getfield 281	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   589: ldc_w 558
    //   592: invokevirtual 561	android/os/Bundle:getShort	(Ljava/lang/String;)S
    //   595: invokevirtual 572	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   598: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   601: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   604: aload_2
    //   605: athrow
    //   606: astore_2
    //   607: iconst_1
    //   608: istore 6
    //   610: goto -57 -> 553
    //   613: astore_2
    //   614: iconst_0
    //   615: istore 6
    //   617: goto -64 -> 553
    //   620: astore_2
    //   621: iload 7
    //   623: istore 5
    //   625: goto -149 -> 476
    //   628: astore_2
    //   629: iconst_1
    //   630: istore 5
    //   632: goto -156 -> 476
    //   635: iload 8
    //   637: istore 5
    //   639: goto -291 -> 348
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	642	0	this	CardHandler
    //   0	642	1	paramToServiceMsg	ToServiceMsg
    //   0	642	2	paramFromServiceMsg	FromServiceMsg
    //   0	642	3	paramObject	Object
    //   261	80	4	i	int
    //   15	623	5	bool1	boolean
    //   83	533	6	bool2	boolean
    //   87	535	7	bool3	boolean
    //   74	562	8	bool4	boolean
    //   1	465	9	bool5	boolean
    //   266	173	10	l	long
    // Exception table:
    //   from	to	target	type
    //   416	465	472	java/lang/Exception
    //   89	110	552	finally
    //   122	132	552	finally
    //   143	149	552	finally
    //   157	184	552	finally
    //   205	215	552	finally
    //   227	237	552	finally
    //   245	263	552	finally
    //   294	311	552	finally
    //   480	486	552	finally
    //   490	500	552	finally
    //   316	345	606	finally
    //   416	465	613	finally
    //   89	110	620	java/lang/Exception
    //   122	132	620	java/lang/Exception
    //   143	149	620	java/lang/Exception
    //   157	184	620	java/lang/Exception
    //   205	215	620	java/lang/Exception
    //   227	237	620	java/lang/Exception
    //   245	263	620	java/lang/Exception
    //   294	311	620	java/lang/Exception
    //   316	345	628	java/lang/Exception
  }
  
  /* Error */
  private void M(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 8
    //   3: aload_2
    //   4: invokevirtual 88	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   7: ifeq +368 -> 375
    //   10: aload_3
    //   11: ifnull +364 -> 375
    //   14: iconst_1
    //   15: istore 5
    //   17: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +30 -> 50
    //   23: ldc 95
    //   25: iconst_2
    //   26: new 18	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   33: ldc_w 581
    //   36: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: iload 5
    //   41: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   44: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: aload_0
    //   51: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   54: invokevirtual 544	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   57: ldc_w 545
    //   60: invokevirtual 551	mqq/app/MobileQQ:getString	(I)Ljava/lang/String;
    //   63: pop
    //   64: aload_0
    //   65: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   68: invokevirtual 117	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   71: pop
    //   72: iload 5
    //   74: ifeq +458 -> 532
    //   77: iload 5
    //   79: istore 6
    //   81: iload 5
    //   83: istore 7
    //   85: new 122	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   88: dup
    //   89: invokespecial 123	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   92: aload_3
    //   93: checkcast 125	[B
    //   96: checkcast 125	[B
    //   99: invokevirtual 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   102: checkcast 122	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   105: astore_2
    //   106: aload_2
    //   107: ifnull +274 -> 381
    //   110: iload 5
    //   112: istore 6
    //   114: iload 5
    //   116: istore 7
    //   118: aload_2
    //   119: getfield 133	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   122: invokevirtual 138	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   125: ifne +256 -> 381
    //   128: iconst_1
    //   129: istore 5
    //   131: iload 5
    //   133: istore 6
    //   135: iload 5
    //   137: istore 7
    //   139: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   142: ifeq +38 -> 180
    //   145: iload 5
    //   147: istore 6
    //   149: iload 5
    //   151: istore 7
    //   153: ldc 95
    //   155: iconst_2
    //   156: new 18	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   163: ldc_w 583
    //   166: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: iload 5
    //   171: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   174: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   180: iload 5
    //   182: ifeq +418 -> 600
    //   185: iload 5
    //   187: istore 6
    //   189: iload 5
    //   191: istore 7
    //   193: aload_2
    //   194: getfield 144	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   197: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   200: ifeq +400 -> 600
    //   203: iload 5
    //   205: istore 6
    //   207: iload 5
    //   209: istore 7
    //   211: aload_2
    //   212: getfield 144	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   215: invokevirtual 152	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   218: ifnull +382 -> 600
    //   221: iload 5
    //   223: istore 6
    //   225: iload 5
    //   227: istore 7
    //   229: aload_2
    //   230: getfield 144	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   233: invokevirtual 152	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   236: invokevirtual 158	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   239: invokestatic 164	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   242: invokevirtual 167	java/nio/ByteBuffer:getInt	()I
    //   245: istore 4
    //   247: iload 4
    //   249: i2l
    //   250: lstore 10
    //   252: iload 4
    //   254: ifge +16 -> 270
    //   257: iload 4
    //   259: ldc_w 554
    //   262: iand
    //   263: i2l
    //   264: ldc2_w 555
    //   267: lor
    //   268: lstore 10
    //   270: iload 5
    //   272: istore 6
    //   274: iload 5
    //   276: istore 7
    //   278: aload_1
    //   279: getfield 281	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   282: ldc_w 283
    //   285: invokevirtual 289	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   288: istore 9
    //   290: iload 5
    //   292: istore 6
    //   294: iload 5
    //   296: istore 7
    //   298: aload_0
    //   299: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   302: invokevirtual 117	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   305: lload 10
    //   307: invokestatic 272	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   310: invokevirtual 275	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   313: istore 5
    //   315: iload 5
    //   317: ifeq +70 -> 387
    //   320: iconst_1
    //   321: istore 5
    //   323: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   326: ifeq +48 -> 374
    //   329: ldc 95
    //   331: iconst_2
    //   332: new 18	java/lang/StringBuilder
    //   335: dup
    //   336: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   339: ldc_w 583
    //   342: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: iload 5
    //   347: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   350: ldc 184
    //   352: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: aload_1
    //   356: getfield 281	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   359: ldc_w 283
    //   362: invokevirtual 289	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   365: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   368: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   371: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   374: return
    //   375: iconst_0
    //   376: istore 5
    //   378: goto -361 -> 17
    //   381: iconst_0
    //   382: istore 5
    //   384: goto -253 -> 131
    //   387: iload 9
    //   389: ifne +3 -> 392
    //   392: iload 8
    //   394: istore 5
    //   396: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   399: ifeq -76 -> 323
    //   402: ldc 95
    //   404: iconst_2
    //   405: new 18	java/lang/StringBuilder
    //   408: dup
    //   409: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   412: ldc_w 585
    //   415: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: lload 10
    //   420: invokevirtual 326	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   423: ldc_w 576
    //   426: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: aload_0
    //   430: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   433: invokevirtual 117	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   436: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   439: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   442: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   445: iload 8
    //   447: istore 5
    //   449: goto -126 -> 323
    //   452: astore_2
    //   453: iconst_0
    //   454: istore 7
    //   456: iload 7
    //   458: istore 6
    //   460: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   463: ifeq +17 -> 480
    //   466: iload 7
    //   468: istore 6
    //   470: ldc 95
    //   472: iconst_2
    //   473: ldc_w 587
    //   476: aload_2
    //   477: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   480: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   483: ifeq -109 -> 374
    //   486: ldc 95
    //   488: iconst_2
    //   489: new 18	java/lang/StringBuilder
    //   492: dup
    //   493: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   496: ldc_w 583
    //   499: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   502: iload 7
    //   504: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   507: ldc 184
    //   509: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: aload_1
    //   513: getfield 281	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   516: ldc_w 283
    //   519: invokevirtual 289	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   522: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   525: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   528: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   531: return
    //   532: goto -209 -> 323
    //   535: astore_2
    //   536: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   539: ifeq +48 -> 587
    //   542: ldc 95
    //   544: iconst_2
    //   545: new 18	java/lang/StringBuilder
    //   548: dup
    //   549: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   552: ldc_w 583
    //   555: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   558: iload 6
    //   560: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   563: ldc 184
    //   565: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: aload_1
    //   569: getfield 281	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   572: ldc_w 283
    //   575: invokevirtual 289	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   578: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   581: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   584: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   587: aload_2
    //   588: athrow
    //   589: astore_2
    //   590: iconst_0
    //   591: istore 6
    //   593: goto -57 -> 536
    //   596: astore_2
    //   597: goto -141 -> 456
    //   600: goto -277 -> 323
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	603	0	this	CardHandler
    //   0	603	1	paramToServiceMsg	ToServiceMsg
    //   0	603	2	paramFromServiceMsg	FromServiceMsg
    //   0	603	3	paramObject	Object
    //   245	18	4	i	int
    //   15	433	5	bool1	boolean
    //   79	513	6	bool2	boolean
    //   83	420	7	bool3	boolean
    //   1	445	8	bool4	boolean
    //   288	100	9	bool5	boolean
    //   250	169	10	l	long
    // Exception table:
    //   from	to	target	type
    //   396	445	452	java/lang/Exception
    //   85	106	535	finally
    //   118	128	535	finally
    //   139	145	535	finally
    //   153	180	535	finally
    //   193	203	535	finally
    //   211	221	535	finally
    //   229	247	535	finally
    //   278	290	535	finally
    //   298	315	535	finally
    //   460	466	535	finally
    //   470	480	535	finally
    //   396	445	589	finally
    //   85	106	596	java/lang/Exception
    //   118	128	596	java/lang/Exception
    //   139	145	596	java/lang/Exception
    //   153	180	596	java/lang/Exception
    //   193	203	596	java/lang/Exception
    //   211	221	596	java/lang/Exception
    //   229	247	596	java/lang/Exception
    //   278	290	596	java/lang/Exception
    //   298	315	596	java/lang/Exception
  }
  
  private void N(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = 0;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1;
    Object localObject2;
    Object localObject3;
    Object localObject1;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "handleGetIsQidianExt success=" + bool1);
      }
      localObject2 = null;
      localObject3 = null;
      localObject1 = null;
      paramFromServiceMsg = null;
      if (!bool1) {
        break label493;
      }
    }
    int j;
    for (;;)
    {
      for (;;)
      {
        try
        {
          paramObject = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
          if (paramObject != null)
          {
            j = paramObject.uint32_result.get();
            if (j == 0) {
              bool1 = true;
            }
          }
        }
        catch (Exception paramFromServiceMsg)
        {
          long l;
          label298:
          paramObject = localObject1;
          continue;
          bool2 = bool1;
          continue;
        }
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.", 2, "handleGetIsQidianExt result=" + bool1);
          }
          if ((!bool1) || (!paramObject.bytes_bodybuffer.has()) || (paramObject.bytes_bodybuffer.get() == null)) {
            continue;
          }
          paramObject = ByteBuffer.wrap(paramObject.bytes_bodybuffer.get().toByteArray());
          l = Utils.a(paramObject.getInt());
          paramObject.get();
          if (Short.valueOf(paramObject.getShort()).shortValue() != 1) {
            continue;
          }
          j = paramObject.getShort();
          if (j != -25126)
          {
            paramToServiceMsg = paramFromServiceMsg;
            a(68, bool2, paramToServiceMsg);
            return;
            bool1 = false;
            break;
            bool1 = false;
            continue;
          }
          j = paramObject.getShort();
          if (j == 2)
          {
            paramFromServiceMsg = new byte[j];
            paramObject.get(paramFromServiceMsg);
            j = Utils.a(paramFromServiceMsg, 0);
            if (paramObject.getShort() == 0) {
              break label562;
            }
            paramToServiceMsg = null;
            bool2 = bool3;
          }
        }
        catch (Exception paramFromServiceMsg)
        {
          paramObject = localObject1;
        }
      }
      bool2 = paramToServiceMsg.extraData.getBoolean("isQidianSimple", false);
      paramToServiceMsg = new BmqqAccountType(String.valueOf(Long.valueOf(l)), i);
      try
      {
        paramFromServiceMsg = (QidianManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(164);
        paramFromServiceMsg.a(paramToServiceMsg);
        if ((i == 1) && (bool2)) {
          paramFromServiceMsg.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getBaseContext(), paramToServiceMsg);
        } else {
          paramFromServiceMsg.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApp().getBaseContext(), paramToServiceMsg);
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        paramObject = paramToServiceMsg;
      }
      paramFromServiceMsg.printStackTrace();
      bool2 = bool1;
      paramToServiceMsg = paramObject;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.profilecard.", 2, "handleGetIsQidianExt exception: " + paramFromServiceMsg.getMessage());
        bool2 = bool1;
        paramToServiceMsg = paramObject;
        continue;
        paramToServiceMsg = localObject2;
        bool2 = bool1;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.profilecard.", 2, "handleGetIsQidianExt uint32_result false");
          paramToServiceMsg = localObject2;
          bool2 = bool1;
          continue;
          label493:
          bool2 = bool1;
          paramToServiceMsg = localObject3;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.profilecard.", 2, "handleGetIsQidianExt isSuccess: " + bool1);
            bool2 = bool1;
            paramToServiceMsg = localObject3;
          }
        }
      }
    }
    for (;;)
    {
      paramFromServiceMsg = paramToServiceMsg;
      break;
      label562:
      if (j == 0) {
        break label298;
      }
      i = 1;
      break label298;
      bool2 = true;
    }
  }
  
  private void O(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "handleGetIsQidianMaster success=" + bool);
      }
      if (!bool) {}
    }
    label544:
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
      if ((paramToServiceMsg == null) || (paramToServiceMsg.uint32_result.get() != 0)) {
        break label641;
      }
      bool = true;
      label90:
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "handleGetIsQidianMaster result=" + bool);
      }
      if ((!bool) || (!paramToServiceMsg.bytes_bodybuffer.has()) || (paramToServiceMsg.bytes_bodybuffer.get() == null)) {
        break label579;
      }
      paramToServiceMsg = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
      paramFromServiceMsg = Long.valueOf(Utils.a(paramToServiceMsg.getInt()));
      paramToServiceMsg.get();
      paramObject = Short.valueOf(paramToServiceMsg.getShort());
      if (paramObject.shortValue() != 1) {
        break label544;
      }
      if (paramToServiceMsg.getShort() != -25176) {
        break label509;
      }
      i = paramToServiceMsg.getShort();
      if (i != 2) {
        break label473;
      }
      paramObject = new byte[i];
      paramToServiceMsg.get(paramObject);
      int j = Utils.a(paramObject, 0);
      i = paramToServiceMsg.getShort();
      if (i != 0) {
        break label437;
      }
      i = 4;
      if (j != 0) {
        i = 6;
      }
      paramToServiceMsg = new BmqqAccountType(String.valueOf(paramFromServiceMsg), i);
      try
      {
        paramObject = (QidianManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(164);
        paramObject.a(paramToServiceMsg);
        if (j != 0)
        {
          QidianExternalInfo localQidianExternalInfo = paramObject.a(String.valueOf(paramFromServiceMsg));
          paramFromServiceMsg = paramObject.a(String.valueOf(paramFromServiceMsg));
          if ((localQidianExternalInfo == null) || (paramFromServiceMsg == null)) {
            paramObject.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getBaseContext(), paramToServiceMsg);
          }
        }
        for (;;)
        {
          a(90, true, paramToServiceMsg);
          return;
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.", 2, "handleGetIsQidianMaster sFieldValue: " + j);
          }
        }
        paramObject.printStackTrace();
      }
      catch (Exception paramObject) {}
    }
    catch (Exception paramObject)
    {
      label437:
      label579:
      for (;;)
      {
        int i;
        label473:
        label509:
        paramToServiceMsg = null;
      }
    }
    paramFromServiceMsg = paramToServiceMsg;
    if (QLog.isColorLevel())
    {
      QLog.d("Q.profilecard.", 2, "handleGetIsQidianMaster exception: " + paramObject.getMessage());
      paramFromServiceMsg = paramToServiceMsg;
    }
    for (;;)
    {
      a(90, false, paramFromServiceMsg);
      return;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.profilecard.", 2, "handleGetIsQidianMaster wFieldLeft: " + i);
        break label647;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.profilecard.", 2, "handleGetIsQidianMaster wFieldLen: " + i);
          break label647;
          if (QLog.isColorLevel())
          {
            QLog.d("Q.profilecard.", 2, "handleGetIsQidianMaster wTlvCount: " + paramObject);
            break label647;
            if (QLog.isColorLevel())
            {
              QLog.d("Q.profilecard.", 2, "handleGetIsQidianMaster wTlvCount: " + paramObject);
              break label647;
              if (QLog.isColorLevel())
              {
                QLog.d("Q.profilecard.", 2, "handleGetIsQidianMaster uint32_result false");
                break label647;
                if (QLog.isColorLevel()) {
                  QLog.d("Q.profilecard.", 2, "handleGetIsQidianMaster isSuccess: " + bool);
                }
                paramFromServiceMsg = null;
                continue;
                bool = false;
                break;
                label641:
                bool = false;
                break label90;
              }
            }
          }
        }
      }
      label647:
      paramFromServiceMsg = null;
    }
  }
  
  private void P(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool3 = false;
    Object localObject2 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_ComTencentMobileqqCampuscircleCampusLebaEntryChecker;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("CardHandler", 2, "handleGetCampusLebaEntrySwitch checker is null");
      }
      localObject1 = new CampusLebaEntryChecker(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    localObject2 = new oidb_0xa6d.RspBody();
    int i = a(paramFromServiceMsg, paramObject, (MessageMicro)localObject2);
    boolean bool2;
    boolean bool4;
    if (i == 0) {
      if (((oidb_0xa6d.RspBody)localObject2).uint32_if_hava_entrance.get() == 1)
      {
        bool1 = true;
        bool2 = ((CampusLebaEntryChecker)localObject1).jdField_a_of_type_Boolean;
        ((CampusLebaEntryChecker)localObject1).a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, bool1, true);
        if (bool1) {
          ReportController.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X8008876", "0X8008876", 0, 0, "", "", "", "");
        }
        bool4 = true;
        bool3 = bool1;
      }
    }
    for (boolean bool1 = bool4;; bool1 = false)
    {
      a(92, bool1, new Object[] { Boolean.valueOf(bool3), Boolean.valueOf(bool2) });
      long l1 = SystemClock.elapsedRealtime();
      long l2 = paramToServiceMsg.extraData.getLong("lbs_cost", 0L);
      long l3 = paramToServiceMsg.extraData.getLong("start_time", l1);
      if (QLog.isColorLevel()) {
        QLog.i("CardHandler", 2, String.format(Locale.getDefault(), "handleGetCampusLebaEntrySwitch result: %d switch: %b lbs_cost: %d cost : %d", new Object[] { Integer.valueOf(i), Boolean.valueOf(bool3), Long.valueOf(l2), Long.valueOf(l1 - l3) }));
      }
      return;
      bool1 = false;
      break;
      bool2 = false;
    }
  }
  
  private void Q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = paramToServiceMsg.extraData.getString("from");
    if (QLog.isDevelopLevel()) {
      QLog.i("MedalWallMng", 4, String.format(Locale.getDefault(), "handleGetMedalWallInfo from: %s", new Object[] { paramToServiceMsg }));
    }
    if ("getSelfNewObtainedMedalWall".equals(paramToServiceMsg)) {
      a(paramFromServiceMsg, paramObject);
    }
  }
  
  private void R(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject1 = null;
    Object localObject2;
    if (QLog.isDevelopLevel())
    {
      localObject2 = new StringBuilder(300);
      paramToServiceMsg = paramToServiceMsg.extraData.getParcelableArrayList("medal_wall_list");
      ((StringBuilder)localObject2).append("report list: [");
      if ((paramToServiceMsg != null) && (paramToServiceMsg.size() > 0))
      {
        paramToServiceMsg = paramToServiceMsg.iterator();
        while (paramToServiceMsg.hasNext())
        {
          MedalID localMedalID = (MedalID)paramToServiceMsg.next();
          if (localMedalID != null) {
            ((StringBuilder)localObject2).append("(").append(localMedalID.jdField_a_of_type_Int).append(",").append(localMedalID.jdField_b_of_type_Int).append("), ");
          }
        }
      }
      ((StringBuilder)localObject2).append("]");
    }
    for (paramToServiceMsg = (ToServiceMsg)localObject2;; paramToServiceMsg = null)
    {
      localObject2 = new cmd0xac6.RspBody();
      int i = a(paramFromServiceMsg, paramObject, (MessageMicro)localObject2);
      paramFromServiceMsg = localObject1;
      if (i == 0)
      {
        if ((QLog.isDevelopLevel()) && (paramToServiceMsg != null))
        {
          paramFromServiceMsg = ((cmd0xac6.RspBody)localObject2).rpt_results.get();
          paramToServiceMsg.append(", result list [");
          if ((paramFromServiceMsg != null) && (paramFromServiceMsg.size() > 0))
          {
            paramFromServiceMsg = paramFromServiceMsg.iterator();
            while (paramFromServiceMsg.hasNext())
            {
              paramObject = (cmd0xac6.operate_result)paramFromServiceMsg.next();
              if (paramObject != null) {
                paramToServiceMsg.append("(").append(paramObject.uint32_id.get()).append(",").append(paramObject.int32_result.get()).append(",").append(paramObject.str_errmsg.get()).append("), ");
              }
            }
          }
          paramToServiceMsg.append("]");
        }
        paramFromServiceMsg = new TMedalWallInfo(-2147483648, ((cmd0xac6.RspBody)localObject2).uint32_metal_count.get(), ((cmd0xac6.RspBody)localObject2).int32_new_count.get(), ((cmd0xac6.RspBody)localObject2).int32_upgrade_count.get(), ((cmd0xac6.RspBody)localObject2).str_prompt_params.get());
      }
      if (QLog.isDevelopLevel())
      {
        paramObject = Locale.getDefault();
        if (paramToServiceMsg == null)
        {
          paramToServiceMsg = "null";
          QLog.i("MedalWallMng", 4, String.format(paramObject, "handleReportMedalWall result: %s  msg: %s", new Object[] { Integer.valueOf(i), paramToServiceMsg }));
        }
      }
      else
      {
        paramToServiceMsg = ((MedalWallMng)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(249)).a(paramFromServiceMsg, false);
        if (i != 0) {
          break label433;
        }
      }
      label433:
      for (boolean bool = true;; bool = false)
      {
        a(51, bool, paramToServiceMsg);
        return;
        paramToServiceMsg = paramToServiceMsg.toString();
        break;
      }
    }
  }
  
  protected static int a(Context paramContext)
  {
    paramContext = paramContext.getResources().getDisplayMetrics();
    int i = paramContext.widthPixels;
    int j = paramContext.heightPixels;
    if (i > j) {
      return i;
    }
    return j;
  }
  
  private static final SongInfo a(JSONObject paramJSONObject)
  {
    long l2 = 0L;
    SongInfo localSongInfo = new SongInfo();
    if (paramJSONObject != null) {}
    for (;;)
    {
      try
      {
        if (!paramJSONObject.has("ringurl")) {
          break label284;
        }
        str = paramJSONObject.getString("ringurl");
        if (TextUtils.isEmpty(str))
        {
          if (!paramJSONObject.has("url")) {
            break label292;
          }
          str = paramJSONObject.getString("url");
          localSongInfo.jdField_a_of_type_JavaLangString = str;
          if (paramJSONObject.has("songid"))
          {
            l1 = paramJSONObject.getLong("songid");
            localSongInfo.jdField_a_of_type_Long = l1;
            if (!paramJSONObject.has("songname")) {
              break label266;
            }
            str = paramJSONObject.getString("songname");
            localSongInfo.jdField_b_of_type_JavaLangString = str;
            localSongInfo.jdField_b_of_type_JavaLangString = a(localSongInfo.jdField_b_of_type_JavaLangString);
            if (!paramJSONObject.has("singername")) {
              break label300;
            }
            str = paramJSONObject.getString("singername");
            localSongInfo.g = str;
            localSongInfo.g = a(localSongInfo.g);
            l1 = l2;
            if (paramJSONObject.has("singeruin")) {
              l1 = paramJSONObject.getLong("singeruin");
            }
            localSongInfo.jdField_b_of_type_Long = l1;
            if (!paramJSONObject.has("albumname")) {
              break label274;
            }
            paramJSONObject = paramJSONObject.getString("albumname");
            localSongInfo.f = paramJSONObject;
            localSongInfo.f = a(localSongInfo.f);
            return localSongInfo;
          }
        }
        else
        {
          localSongInfo.jdField_a_of_type_JavaLangString = str;
          continue;
        }
        long l1 = 0L;
      }
      catch (Exception paramJSONObject)
      {
        QLog.e("CardHandler", 1, "MusicGeneWebViewPlugin.convertJSonObject2MusicGeneSongInfo exception", paramJSONObject);
        return localSongInfo;
      }
      continue;
      label266:
      String str = "";
      continue;
      label274:
      paramJSONObject = "";
      continue;
      return localSongInfo;
      label284:
      str = "";
      continue;
      label292:
      str = "";
      continue;
      label300:
      str = "";
    }
  }
  
  public static String a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new String(Base64.a(paramString), "UTF-8");
        return paramString;
      }
      catch (Exception paramString) {}
    }
    return "";
  }
  
  public static String a(String paramString, int paramInt)
  {
    if ((paramString == null) || ("".equals(paramString)) || (!jdField_a_of_type_JavaUtilVector.contains(Integer.valueOf(paramInt)))) {
      return "";
    }
    return jdField_a_of_type_JavaLangString + paramInt + "/" + paramString + ".jpg";
  }
  
  public static String a(List paramList)
  {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.clear();
    if (paramList.size() > 0)
    {
      int i = 0;
      while (i < paramList.size())
      {
        localLinkedList.add(HexUtil.a(((FaceInfo)paramList.get(i)).vFaceID));
        i += 1;
      }
      return b(localLinkedList);
    }
    return ";";
  }
  
  public static LinkedList a(String paramString)
  {
    LinkedList localLinkedList = new LinkedList();
    if (paramString != null)
    {
      paramString = paramString.split(";");
      int i = 0;
      while (i < paramString.length)
      {
        if ((paramString[i] != null) && (!"".equals(paramString[i]))) {
          localLinkedList.add(paramString[i]);
        }
        i += 1;
      }
    }
    return localLinkedList;
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    a(paramContext, paramString1, "_TEMP_COVER_FILEKEY", paramString2);
  }
  
  private static void a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramContext = paramContext.getSharedPreferences(paramString1, 0).edit();
    if ((paramString3 == null) || ("".equals(paramString3))) {
      paramContext.remove(paramString1 + paramString2);
    }
    for (;;)
    {
      paramContext.commit();
      return;
      paramContext.putString(paramString1 + paramString2, paramString3);
    }
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject1 = new cmd0x7a8.RspBody();
    int n = a(paramFromServiceMsg, paramObject, (MessageMicro)localObject1);
    paramObject = null;
    paramFromServiceMsg = null;
    Iterator localIterator = null;
    MedalWallMng localMedalWallMng = (MedalWallMng)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(249);
    int i1;
    MedalInfo localMedalInfo;
    int j;
    int m;
    int k;
    int i;
    if (n == 0)
    {
      paramObject = new TMedalWallInfo();
      paramObject.iOpenFlag = -2147483648;
      paramObject.iMedalCount = ((cmd0x7a8.RspBody)localObject1).uint32_metal_count.get();
      paramObject.iNewCount = ((cmd0x7a8.RspBody)localObject1).int32_new_count.get();
      paramObject.iUpgradeCount = ((cmd0x7a8.RspBody)localObject1).int32_upgrade_count.get();
      paramObject.strPromptParams = ((cmd0x7a8.RspBody)localObject1).str_prompt_params.get();
      Object localObject2 = ((cmd0x7a8.RspBody)localObject1).rpt_msg_medal.get();
      localObject1 = new ArrayList();
      paramFromServiceMsg = localIterator;
      if (localObject2 != null)
      {
        paramFromServiceMsg = localIterator;
        if (((List)localObject2).size() > 0)
        {
          paramFromServiceMsg = new SparseArray(((List)localObject2).size());
          localIterator = ((List)localObject2).iterator();
          for (;;)
          {
            if (localIterator.hasNext())
            {
              localObject2 = (common.MedalInfo)localIterator.next();
              if (localObject2 != null)
              {
                i1 = ((common.MedalInfo)localObject2).uint32_level.get();
                if (i1 == 0)
                {
                  if (QLog.isColorLevel()) {
                    QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "handleGetSelfNewObtainedMedal medal[%d] get level[%d]", new Object[] { Integer.valueOf(((common.MedalInfo)localObject2).uint32_id.get()), Integer.valueOf(i1) }));
                  }
                }
                else
                {
                  localMedalInfo = localMedalWallMng.a(((common.MedalInfo)localObject2).uint32_id.get());
                  localMedalInfo.strName = ((common.MedalInfo)localObject2).str_name.get();
                  localMedalInfo.iType = ((common.MedalInfo)localObject2).uint32_type.get();
                  localMedalInfo.iNoProgress = ((common.MedalInfo)localObject2).uint32_no_progress.get();
                  localMedalInfo.strResJson = ((common.MedalInfo)localObject2).str_resource.get();
                  localMedalInfo.iLevelCount = ((common.MedalInfo)localObject2).uint32_level_count.get();
                  localMedalInfo.lSeqLevel1 = ((common.MedalInfo)localObject2).uint32_seq.get();
                  localMedalInfo.lObtainTimeLevel1 = ((common.MedalInfo)localObject2).uint64_time.get();
                  localMedalInfo.strDescLevel1 = ((common.MedalInfo)localObject2).str_desc.get();
                  localMedalInfo.iPointLevel1 = ((common.MedalInfo)localObject2).uint32_point.get();
                  localMedalInfo.strDetailUrlLevel1 = ((common.MedalInfo)localObject2).str_detail_url.get();
                  localMedalInfo.strTaskDescLevel1 = ((common.MedalInfo)localObject2).str_task_desc.get();
                  localMedalInfo.lSeqLevel2 = ((common.MedalInfo)localObject2).uint32_seq_level2.get();
                  localMedalInfo.lObtainTimeLevel2 = ((common.MedalInfo)localObject2).uint64_time_level2.get();
                  localMedalInfo.strDescLevel2 = ((common.MedalInfo)localObject2).str_desc_level2.get();
                  localMedalInfo.iPointLevel2 = ((common.MedalInfo)localObject2).uint32_point_level2.get();
                  localMedalInfo.strDetailUrlLevel2 = ((common.MedalInfo)localObject2).str_detail_url_2.get();
                  localMedalInfo.strTaskDescLevel2 = ((common.MedalInfo)localObject2).str_task_desc_2.get();
                  localMedalInfo.lSeqLevel3 = ((common.MedalInfo)localObject2).uint32_seq_level3.get();
                  localMedalInfo.lObtainTimeLevel3 = ((common.MedalInfo)localObject2).uint64_time_level3.get();
                  localMedalInfo.strDescLevel3 = ((common.MedalInfo)localObject2).str_desc_level3.get();
                  localMedalInfo.iPointLevel3 = ((common.MedalInfo)localObject2).uint32_point_level3.get();
                  localMedalInfo.strDetailUrlLevel3 = ((common.MedalInfo)localObject2).str_detail_url_3.get();
                  localMedalInfo.strTaskDescLevel3 = ((common.MedalInfo)localObject2).str_task_desc_3.get();
                  j = ((common.MedalInfo)localObject2).uint32_unread.get();
                  m = ((common.MedalInfo)localObject2).uint32_unread_2.get();
                  k = ((common.MedalInfo)localObject2).uint32_unread_3.get();
                  if (i1 == 255)
                  {
                    if ((localMedalInfo.iLevel != i1) || (localMedalInfo.iUnreadLevel1 != 2) || (j != 1)) {
                      break label1044;
                    }
                    ((ArrayList)localObject1).add(new MedalID(localMedalInfo.iId, 255));
                    j = 2;
                    i = k;
                    k = m;
                  }
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      localMedalInfo.iLevel = i1;
      localMedalInfo.iUnreadLevel1 = j;
      localMedalInfo.iUnreadLevel2 = k;
      localMedalInfo.iUnreadLevel3 = i;
      paramFromServiceMsg.put(localMedalInfo.iId, localMedalInfo);
      break;
      if (localMedalInfo.iLevelCount > 1)
      {
        if ((localMedalInfo.iLevel >= 1) && (localMedalInfo.iUnreadLevel1 == 2) && (j == 1)) {
          ((ArrayList)localObject1).add(new MedalID(localMedalInfo.iId, 1));
        }
        for (i = localMedalInfo.iUnreadLevel1;; i = j)
        {
          if ((localMedalInfo.iLevel >= 2) && (localMedalInfo.iUnreadLevel2 == 2) && (m == 1)) {
            ((ArrayList)localObject1).add(new MedalID(localMedalInfo.iId, 2));
          }
          for (j = localMedalInfo.iUnreadLevel2;; j = m)
          {
            if ((localMedalInfo.iLevel >= 3) && (localMedalInfo.iUnreadLevel3 == 2) && (k == 1))
            {
              ((ArrayList)localObject1).add(new MedalID(localMedalInfo.iId, 3));
              m = localMedalInfo.iUnreadLevel3;
              k = j;
              j = i;
              i = m;
              break;
              if (((ArrayList)localObject1).size() > 0) {
                b((ArrayList)localObject1);
              }
              if (QLog.isColorLevel()) {
                QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "handleGetSelfNewObtainedMedal result: %d", new Object[] { Integer.valueOf(n) }));
              }
              boolean bool;
              if (n == 0)
              {
                bool = true;
                localMedalWallMng.a(bool, paramObject, paramFromServiceMsg);
                if (n != 0) {
                  break label1009;
                }
              }
              label1009:
              for (paramFromServiceMsg = ((FriendsManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(50)).a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), true);; paramFromServiceMsg = null)
              {
                if (n == 0) {}
                for (bool = true;; bool = false)
                {
                  a(51, bool, paramFromServiceMsg);
                  return;
                  bool = false;
                  break;
                }
              }
            }
            m = j;
            j = i;
            i = k;
            k = m;
            break;
          }
        }
      }
      label1044:
      i = k;
      k = m;
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    paramObject = (RespVote)paramFromServiceMsg.getAttribute("result");
    paramFromServiceMsg = paramToServiceMsg.extraData.getString("targetUin");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("selfUin");
    paramBundle.putString("targetUin", paramFromServiceMsg);
    paramBundle.putString("selfUin", paramToServiceMsg);
    if ((paramObject != null) && (((RespVote)paramObject).stHeader.iReplyCode == 0)) {}
    for (boolean bool = true;; bool = false)
    {
      if ((!bool) && (!TextUtils.isEmpty(paramFromServiceMsg)))
      {
        paramToServiceMsg = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
        paramFromServiceMsg = paramToServiceMsg.a(paramFromServiceMsg);
        if (paramFromServiceMsg != null)
        {
          paramFromServiceMsg.lVoteCount -= 1L;
          paramFromServiceMsg.bVoted = 0;
          paramToServiceMsg.a(paramFromServiceMsg);
        }
      }
      a(5, bool, paramBundle);
      return;
    }
  }
  
  private void a(String paramString1, String paramString2, int paramInt1, long paramLong1, byte paramByte1, long paramLong2, long paramLong3, byte[] paramArrayOfByte1, String paramString3, long paramLong4, int paramInt2, byte[] paramArrayOfByte2, long paramLong5, boolean paramBoolean, byte paramByte2)
  {
    try
    {
      long l1 = Long.parseLong(paramString1);
      long l2 = Long.parseLong(paramString2);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getSummaryCard()").append(",selfUin = ").append(paramString1).append(",comeFromType = ").append(paramInt1).append(",destUin = ").append(paramString2).append(",qzoneFeedTimeStamp = ").append(paramLong1).append(",isFriend = ").append(paramByte1).append(",troopCode = ").append(paramLong2).append(",troopUin = ").append(paramLong3).append(",vseed = ").append(paramArrayOfByte1).append(",strSearchName = ").append(paramString3).append(",lGetControl = ").append(paramLong4).append(",nAddFriendSource = ").append(paramInt2).append(", vSecureSig = ").append(paramArrayOfByte2).append(", tinyId = ").append(paramLong5).append(", isNearbyPeopleCard = ").append(paramBoolean);
        QLog.i("Q.profilecard.SummaryCard", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = new ToServiceMsg("mobileqq.service", String.valueOf(paramString1), "SummaryCard.ReqSummaryCard");
      ((ToServiceMsg)localObject).extraData.putLong("selfUin", l1);
      ((ToServiceMsg)localObject).extraData.putLong("targetUin", l2);
      ((ToServiceMsg)localObject).extraData.putInt("comeFromType", paramInt1);
      ((ToServiceMsg)localObject).extraData.putLong("qzoneFeedTimeStamp", paramLong1);
      ((ToServiceMsg)localObject).extraData.putByte("isFriend", paramByte1);
      ((ToServiceMsg)localObject).extraData.putLong("troopCode", paramLong2);
      ((ToServiceMsg)localObject).extraData.putLong("troopUin", paramLong3);
      ((ToServiceMsg)localObject).extraData.putByteArray("vSeed", paramArrayOfByte1);
      ((ToServiceMsg)localObject).extraData.putString("strSearchName", paramString3);
      ((ToServiceMsg)localObject).extraData.putLong("lGetControl", paramLong4);
      ((ToServiceMsg)localObject).extraData.putInt("EAddFriendSource", paramInt2);
      ((ToServiceMsg)localObject).extraData.putByteArray("vSecureSig", paramArrayOfByte2);
      ((ToServiceMsg)localObject).extraData.putLong("tinyId", paramLong5);
      ((ToServiceMsg)localObject).extraData.putBoolean("isNearbyPeopleCard", paramBoolean);
      ((ToServiceMsg)localObject).extraData.putByte("bReqMedalWallInfo", paramByte2);
      ((ToServiceMsg)localObject).extraData.putByte("bReqExtendCard", (byte)1);
      paramArrayOfByte1 = SosoInterface.a();
      if (paramArrayOfByte1 != null)
      {
        paramString1 = paramArrayOfByte1;
        if (paramArrayOfByte1.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation != null) {}
      }
      else
      {
        paramString1 = SosoInterface.a();
      }
      if ((paramString1 != null) && (paramString1.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation != null))
      {
        paramArrayOfByte1 = new UserLocaleInfo();
        paramArrayOfByte1.lLatitude = ((int)(paramString1.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.a * 1000000.0D));
        paramArrayOfByte1.lLongitude = ((int)(paramString1.jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.b * 1000000.0D));
        ((ToServiceMsg)localObject).extraData.putSerializable("stLocaleInfo", paramArrayOfByte1);
      }
      paramString1 = new ArrayList();
      if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramString2)) {
        paramString1.add(Integer.valueOf(42104));
      }
      paramString1.add(Integer.valueOf(27225));
      paramString1.add(Integer.valueOf(27224));
      paramString1.add(Integer.valueOf(42122));
      paramString1.add(Integer.valueOf(42121));
      paramString1.add(Integer.valueOf(27236));
      paramString1.add(Integer.valueOf(27238));
      paramString1.add(Integer.valueOf(42167));
      paramString1.add(Integer.valueOf(42172));
      ((ToServiceMsg)localObject).extraData.putIntegerArrayList("req0x5ebFieldIdList", paramString1);
      a((ToServiceMsg)localObject);
      return;
    }
    catch (NumberFormatException paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.profilecard.SummaryCard", 2, "getSummayCard", paramString1);
    }
  }
  
  public static void a(String paramString, List paramList) {}
  
  private void a(List paramList, Bundle paramBundle)
  {
    a(paramList, paramBundle, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
  }
  
  private void a(List paramList, Bundle paramBundle, String paramString)
  {
    a(paramList, paramBundle, paramString, 9);
  }
  
  private void a(List paramList, Bundle paramBundle, String paramString, int paramInt)
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1152);
    localOIDBSSOPkg.uint32_result.set(0);
    localOIDBSSOPkg.uint32_service_type.set(paramInt);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramList.size() * 2 + 7);
    localByteBuffer.putInt((int)Long.parseLong(paramString));
    localByteBuffer.put((byte)0);
    localByteBuffer.putShort((short)paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localByteBuffer.putShort(((Short)paramList.next()).shortValue());
    }
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localByteBuffer.array()));
    paramList = a("OidbSvc.0x480_9");
    paramList.putWupBuffer(localOIDBSSOPkg.toByteArray());
    if (paramBundle != null) {
      paramList.extraData.putAll(paramBundle);
    }
    paramList.extraData.putBoolean("reqFromCardHandler", true);
    b(paramList);
  }
  
  public static int b(Context paramContext)
  {
    return 640;
  }
  
  public static String b(List paramList)
  {
    if ((paramList == null) || (paramList.size() == 0)) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    int j = paramList.size();
    int i = 0;
    while (i < j)
    {
      localStringBuffer.append((String)paramList.get(i));
      if (i < j - 1) {
        localStringBuffer.append(";");
      }
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if (paramToServiceMsg.extraData.getBoolean("nearby_people")) {
      return;
    }
    paramObject = paramFromServiceMsg.getAttribute("result");
    paramFromServiceMsg = new HashMap();
    boolean bool2 = false;
    boolean bool1 = false;
    long l1 = paramToServiceMsg.extraData.getLong("targetUin");
    long l2 = paramToServiceMsg.extraData.getLong("selfUin");
    int i = paramToServiceMsg.extraData.getInt("favoriteSource");
    int j = paramToServiceMsg.extraData.getInt("iCount");
    int k = paramToServiceMsg.extraData.getInt("from");
    paramBundle.putString("targetUin", Long.toString(l1));
    paramBundle.putString("selfUin", Long.toString(l2));
    paramBundle.putInt("favoriteSource", i);
    paramBundle.putInt("iCount", j);
    paramBundle.putInt("from", k);
    if ((paramObject != null) && ((paramObject instanceof RespFavorite)))
    {
      paramToServiceMsg = (RespFavorite)paramObject;
      if (paramToServiceMsg.stHeader.iReplyCode == 0)
      {
        bool1 = true;
        paramFromServiceMsg.put("param_FailCode", "0");
      }
      for (;;)
      {
        StatisticCollector.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).a(String.valueOf(l2), "profileCardSendFavorite", bool1, 0L, 0L, paramFromServiceMsg, "", false);
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.", 2, String.format("handleFavorite result=%s targetUin=%s iCount=%s", new Object[] { Boolean.valueOf(bool1), Long.valueOf(l1), Integer.valueOf(j) }));
        }
        if ((bool1) && (l1 > 0L))
        {
          paramToServiceMsg = (Card)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager().a(Card.class, l1);
          if (paramToServiceMsg != null)
          {
            if (QLog.isColorLevel()) {
              QLog.i("Q.profilecard.", 2, String.format("handleFavorite card in db: lVoteCount=%s bVoted=%s bAvailVoteCnt=%s", new Object[] { Long.valueOf(paramToServiceMsg.lVoteCount), Byte.valueOf(paramToServiceMsg.bVoted), Short.valueOf(paramToServiceMsg.bAvailVoteCnt) }));
            }
            paramToServiceMsg.lVoteCount += j;
            paramToServiceMsg.bVoted = 1;
            paramToServiceMsg.bAvailVoteCnt = ((short)(paramToServiceMsg.bAvailVoteCnt - j));
            if (paramToServiceMsg.bAvailVoteCnt < 0) {
              paramToServiceMsg.bAvailVoteCnt = 0;
            }
            ((FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(paramToServiceMsg);
          }
          VoteUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, l1, j);
        }
        a(32, bool1, paramBundle);
        return;
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.", 2, "back reqFavorite| result = " + false + "," + l1 + ",replyCode=" + paramToServiceMsg.stHeader.iReplyCode);
        }
        paramFromServiceMsg.put("param_FailCode", String.valueOf(paramToServiceMsg.stHeader.iReplyCode));
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder().append("back reqFavorite| result = ").append(false).append(",").append(l1).append(",obj is");
      if (paramObject != null)
      {
        paramToServiceMsg = "not RespFavorite";
        label567:
        QLog.i("Q.profilecard.", 2, paramToServiceMsg);
      }
    }
    else
    {
      if (paramObject == null) {
        break label642;
      }
    }
    label642:
    for (paramToServiceMsg = "-201";; paramToServiceMsg = "-202")
    {
      paramFromServiceMsg.put("param_FailCode", paramToServiceMsg);
      StatisticCollector.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).a(String.valueOf(l2), "profileCardSendFavorite", false, 0L, 0L, paramFromServiceMsg, "", false);
      bool1 = bool2;
      break;
      paramToServiceMsg = "null";
      break label567;
    }
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
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      paramObject = ((FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).b(paramToServiceMsg.getUin());
      paramFromServiceMsg = (RespGetFavoriteList)paramFromServiceMsg.getAttribute("result");
      switch (paramFromServiceMsg.stHeader.iReplyCode)
      {
      default: 
        paramToServiceMsg = a(3, 7);
        paramBundle.putLong("respTime", paramFromServiceMsg.RespTime);
        paramBundle.putLong("nextMid", paramFromServiceMsg.stUserData.lNextMid);
        paramBundle.putByteArray("strCookie", paramFromServiceMsg.stUserData.strCookie);
        paramBundle.putLong("startMid", -1L);
        a(42, false, new Object[] { paramObject, paramBundle, paramToServiceMsg });
        return;
      }
      Iterator localIterator = paramFromServiceMsg.vFavoriteInfos.iterator();
      ArrayList localArrayList = new ArrayList(0);
      while (localIterator.hasNext())
      {
        UserProfile localUserProfile = (UserProfile)localIterator.next();
        if (QLog.isDevelopLevel()) {
          QLog.d("favolist", 4, "bConstellation=" + localUserProfile.bConstellation + " vipInfo=" + localUserProfile.stVipInfo + " richSign=" + localUserProfile.vRichSign);
        }
        CardProfile localCardProfile = new CardProfile();
        localCardProfile.readFrom(localUserProfile);
        localCardProfile.type = 3;
        if (QLog.isColorLevel()) {
          QLog.i("CardHandler", 2, "handleReqFavoriteList," + localCardProfile.toString());
        }
        localArrayList.add(localCardProfile);
      }
      paramBundle.putLong("respTime", paramFromServiceMsg.RespTime);
      paramBundle.putLong("startMid", paramToServiceMsg.extraData.getLong("nextMid"));
      paramBundle.putLong("nextMid", paramFromServiceMsg.stUserData.lNextMid);
      paramBundle.putByteArray("strCookie", paramFromServiceMsg.stUserData.strCookie);
      if (paramToServiceMsg.extraData.getLong("nextMid", -1L) == 0L) {
        a(3);
      }
      b(paramToServiceMsg.getUin(), localArrayList);
      new StringBuilder().append(paramToServiceMsg.extraData.getLong("targetUin")).append("").toString();
      a(42, true, new Object[] { paramObject, paramBundle, localArrayList });
      DatingUtil.a("handleReqFavoriteList", new Object[] { localArrayList });
      return;
    }
    paramToServiceMsg = ((FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).b(paramToServiceMsg.getUin());
    paramBundle.putLong("startMid", -1L);
    a(42, false, new Object[] { paramToServiceMsg, paramBundle, a(3, 7) });
  }
  
  private void c(String paramString, List paramList)
  {
    b(paramString, paramList);
  }
  
  private boolean c()
  {
    SharedPreferences localSharedPreferences = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    long l1 = localSharedPreferences.getLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c() + "sign_in_last_get_time", 0L);
    long l2 = localSharedPreferences.getLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c() + "sign_in_next_get_time", 0L);
    long l3 = NetConnInfoCenter.getServerTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "shouldGetSignInInfo, last=" + l1 + ", next=" + l2 + ", now=" + l3);
    }
    if (Math.abs(l3 - l1) <= 600000L) {
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "shouldGetSignInInfo, <10min");
      }
    }
    while (l3 < l2) {
      return false;
    }
    localSharedPreferences.edit().putLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c() + "sign_in_last_get_time", l3).commit();
    return true;
  }
  
  public static void d()
  {
    int k = 0;
    Object localObject = new File(jdField_a_of_type_JavaLangString);
    boolean bool2 = true;
    boolean bool1 = bool2;
    if (!((File)localObject).exists()) {}
    try
    {
      bool1 = ((File)localObject).mkdirs();
      if (bool1)
      {
        localObject = new ArrayList();
        ((ArrayList)localObject).add("background");
        ((ArrayList)localObject).add("temp");
        ((ArrayList)localObject).add("HDAvatar");
        int i = 0;
        for (;;)
        {
          j = k;
          if (i >= jdField_a_of_type_JavaUtilVector.size()) {
            break;
          }
          ((ArrayList)localObject).add(String.valueOf(((Integer)jdField_a_of_type_JavaUtilVector.get(i)).intValue()));
          i += 1;
        }
        if (j < ((ArrayList)localObject).size())
        {
          localFile = new File(jdField_a_of_type_JavaLangString + "/" + (String)((ArrayList)localObject).get(j));
          if (localFile.exists()) {}
        }
      }
    }
    catch (SecurityException localSecurityException1)
    {
      try
      {
        for (;;)
        {
          int j;
          File localFile;
          localFile.mkdir();
          label183:
          j += 1;
        }
        localSecurityException1 = localSecurityException1;
        bool1 = bool2;
      }
      catch (SecurityException localSecurityException2)
      {
        break label183;
      }
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "[handleReqVoterList] resultCode = " + paramFromServiceMsg.getResultCode());
    }
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      paramObject = ((FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).b(paramToServiceMsg.getUin());
      paramFromServiceMsg = (RespGetVoterList)paramFromServiceMsg.getAttribute("result");
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "[handleReqVoterList] replyCode = " + paramFromServiceMsg.stHeader.iReplyCode);
      }
      switch (paramFromServiceMsg.stHeader.iReplyCode)
      {
      default: 
        paramToServiceMsg = a(2, 7);
        paramBundle.putLong("respTime", paramFromServiceMsg.RespTime);
        paramBundle.putLong("nextMid", paramFromServiceMsg.stUserData.lNextMid);
        paramBundle.putByteArray("strCookie", paramFromServiceMsg.stUserData.strCookie);
        paramBundle.putLong("startMid", -1L);
        a(6, false, new Object[] { paramObject, paramBundle, paramToServiceMsg });
        return;
      }
      Object localObject1 = paramFromServiceMsg.vVoterInfos.iterator();
      ArrayList localArrayList = new ArrayList(0);
      Object localObject2;
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (UserProfile)((Iterator)localObject1).next();
        CardProfile localCardProfile = new CardProfile();
        localCardProfile.readFrom((UserProfile)localObject2);
        localCardProfile.type = 2;
        if (QLog.isColorLevel()) {
          QLog.i("CardHandler", 2, "handleReqVoterList," + localCardProfile.toString());
        }
        localArrayList.add(localCardProfile);
      }
      paramBundle.putLong("respTime", paramFromServiceMsg.RespTime);
      paramBundle.putLong("startMid", paramToServiceMsg.extraData.getLong("nextMid"));
      paramBundle.putLong("nextMid", paramFromServiceMsg.stUserData.lNextMid);
      paramBundle.putByteArray("strCookie", paramFromServiceMsg.stUserData.strCookie);
      long l = paramToServiceMsg.extraData.getLong("nextMid", -1L);
      if (l == 0L) {
        a(2);
      }
      c(paramToServiceMsg.getUin(), localArrayList);
      localObject1 = new ArrayList(0);
      if (l == 0L)
      {
        if (paramFromServiceMsg.vTodayFavoriteInfos != null)
        {
          localObject2 = paramFromServiceMsg.vTodayFavoriteInfos.iterator();
          while (((Iterator)localObject2).hasNext()) {
            ((ArrayList)localObject1).add(Long.valueOf(((UserProfile)((Iterator)localObject2).next()).lEctID));
          }
        }
        b((List)localObject1);
      }
      int i = paramFromServiceMsg.iMaxFriendFavoriteCount;
      int j = paramFromServiceMsg.iMaxStrangerFavoriteCount;
      int k = paramFromServiceMsg.iTodayVoteCount;
      int m = paramFromServiceMsg.iTodayVoteRank;
      int n = paramFromServiceMsg.iTotalVoteCount;
      new StringBuilder().append(paramToServiceMsg.extraData.getLong("targetUin")).append("").toString();
      a(6, true, new Object[] { paramObject, paramBundle, localArrayList, localObject1, Integer.valueOf(i), Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n) });
      DatingUtil.a("handleReqVoterList", new Object[] { localArrayList });
      return;
    }
    paramToServiceMsg = ((FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).b(paramToServiceMsg.getUin());
    paramBundle.putLong("startMid", -1L);
    a(6, false, new Object[] { paramToServiceMsg, paramBundle, a(2, 7) });
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    paramToServiceMsg = new oidb_0x7ba.RspBody();
    int i = a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "[handleReqLikeRankingList] result=" + i);
    }
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
      if (paramToServiceMsg.uint32_complete.get() == 1) {}
      for (boolean bool = true;; bool = false)
      {
        a(78, true, new Object[] { paramObject, Integer.valueOf(i), Boolean.valueOf(bool), paramBundle.getString("uin") });
        return;
      }
    }
    a(78, false, paramBundle.getString("uin"));
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      paramFromServiceMsg = (RespAddFace)paramObject;
      if (paramFromServiceMsg.stHeader.iReplyCode == 0)
      {
        paramObject = paramToServiceMsg.extraData.getByteArray("filekey");
        FriendsManager localFriendsManager = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
        Card localCard = localFriendsManager.b(paramToServiceMsg.getUin());
        localCard.uin = paramToServiceMsg.getUin();
        if (paramFromServiceMsg.uFaceTimeStamp > localCard.uFaceTimeStamp)
        {
          localCard.uFaceTimeStamp = paramFromServiceMsg.uFaceTimeStamp;
          localCard.addHeadPortrait(paramObject);
        }
        localCard.iFaceNum += 1;
        localFriendsManager.a(localCard);
        ProfileCardUtil.a(paramObject);
        a(11, true, new Object[] { localCard, paramBundle });
        return;
      }
      paramBundle.putInt("retCode", paramFromServiceMsg.stHeader.iReplyCode);
      a(11, false, paramBundle);
      return;
    }
    a(11, false, paramBundle);
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    long l = paramToServiceMsg.extraData.getLong("uin");
    int i = paramToServiceMsg.extraData.getInt("timestamp");
    paramToServiceMsg = ((FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).b(String.valueOf(Long.valueOf(l)));
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramFromServiceMsg = (RespFaceInfo)paramObject;
      if (paramFromServiceMsg.stHeader.iReplyCode == 0)
      {
        if ((i != 0) && (paramFromServiceMsg.uFaceTimeStamp == paramToServiceMsg.uFaceTimeStamp)) {
          break label177;
        }
        paramToServiceMsg.iFaceNum = paramFromServiceMsg.iFaceNum;
        paramToServiceMsg.uFaceTimeStamp = paramFromServiceMsg.uFaceTimeStamp;
        paramToServiceMsg.setStrJoinHexAlbumFileKey(a(paramFromServiceMsg.vFaceInfo));
      }
    }
    label177:
    for (boolean bool = true;; bool = false)
    {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager().a(paramToServiceMsg);
      a(10, true, new Object[] { paramToServiceMsg, Boolean.valueOf(bool) });
      return;
      a(10, false, paramToServiceMsg);
      return;
      a(10, false, paramToServiceMsg);
      return;
    }
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if (paramFromServiceMsg.isSuccess())
    {
      paramFromServiceMsg = (RespGetCardSwitch)paramObject;
      long l1 = paramFromServiceMsg.uCloseNeighborVote;
      long l2 = paramFromServiceMsg.uCloseTimeGateVote;
      paramFromServiceMsg = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      paramObject = paramFromServiceMsg.b(paramToServiceMsg.getUin());
      if (l1 == 0L)
      {
        bool = true;
        paramObject.setZanShowFlag(bool);
        paramFromServiceMsg.a(paramObject);
        paramFromServiceMsg = (NearByGeneralManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(160);
        if (l1 != 0L) {
          break label224;
        }
        bool = true;
        label92:
        paramFromServiceMsg.b(bool);
        paramFromServiceMsg = PreferenceManager.getDefaultSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).edit();
        paramObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131433587) + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        if (l2 != 0L) {
          break label230;
        }
      }
      label224:
      label230:
      for (boolean bool = true;; bool = false)
      {
        paramFromServiceMsg.putBoolean(paramObject, bool).commit();
        paramBundle.putLong("uCloseNeighborVote", l1);
        paramBundle.putLong("uColseTimeEntityManager", l2);
        paramBundle.putString("uin", paramToServiceMsg.getUin());
        a(33, true, paramBundle);
        return;
        bool = false;
        break;
        bool = false;
        break label92;
      }
    }
    paramBundle.putString("uin", paramToServiceMsg.getUin());
    a(33, false, paramBundle);
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("modify_switch_for_near_people", true);
    Object localObject = PreferenceManager.getDefaultSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
    if (paramFromServiceMsg.isSuccess())
    {
      paramObject = (RespSetCardSwitch)paramObject;
      if (bool2)
      {
        l = paramObject.uCloseNeighborVote;
        paramObject = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
        localObject = paramObject.b(paramToServiceMsg.getUin());
        if (l == 0L)
        {
          bool1 = true;
          ((Card)localObject).setZanShowFlag(bool1);
          paramObject.a((Card)localObject);
          if (l != 0L) {
            break label205;
          }
        }
        label205:
        for (bool1 = true;; bool1 = false)
        {
          ((NearByGeneralManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(160)).b(bool1);
          paramBundle.putBoolean("modify_switch_for_near_people", bool2);
          paramBundle.putBoolean("target_switch", bool1);
          paramBundle.putString("uin", paramToServiceMsg.getUin());
          a(34, true, paramBundle);
          if (bool2) {
            StatisticCollector.a(BaseApplicationImpl.getContext()).a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "CMD_REQ_SETCARDSWITCH", paramFromServiceMsg.isSuccess(), 0L, 0L, null, "response");
          }
          return;
          bool1 = false;
          break;
        }
      }
      if (paramObject.uCloseTimeGateVote == 0L) {}
      for (bool1 = true;; bool1 = false)
      {
        ((SharedPreferences)localObject).edit().putBoolean(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131433587) + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), bool1).commit();
        break;
      }
    }
    long l = paramToServiceMsg.extraData.getLong("target_value");
    paramObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface;
    if (l == 0L)
    {
      bool1 = true;
      label315:
      if (paramObject.a(bool2, bool1)) {
        break label387;
      }
      if (!bool2) {
        break label389;
      }
    }
    label387:
    label389:
    for (boolean bool1 = ((NearByGeneralManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(160)).b();; bool1 = ((SharedPreferences)localObject).getBoolean(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131433587) + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false))
    {
      paramBundle.putString("uin", paramToServiceMsg.getUin());
      paramBundle.putBoolean("current_switch", bool1);
      a(34, false, paramBundle);
      break;
      bool1 = false;
      break label315;
      break;
    }
  }
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool5 = true;
    boolean bool6 = true;
    boolean bool4 = true;
    boolean bool3;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool3 = true;
      bool1 = bool5;
      bool2 = bool3;
      if (bool3) {
        bool2 = bool6;
      }
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        bool2 = bool6;
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        bool2 = bool6;
        if (paramToServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool3 = true;
        bool1 = bool5;
        bool2 = bool3;
        if (bool3)
        {
          bool2 = bool6;
          paramToServiceMsg = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          bool2 = bool6;
          long l = paramToServiceMsg.getInt();
          bool2 = bool6;
          if (paramToServiceMsg.get() != 0) {
            continue;
          }
          bool1 = bool4;
          bool2 = bool1;
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(bool1, false);
          bool2 = bool3;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("GetPhoneNumSearchable", 2, paramToServiceMsg.getMessage());
        bool1 = bool2;
        bool2 = false;
        continue;
      }
      if (!bool2) {
        bool1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.b(false);
      }
      a(38, bool2, Boolean.valueOf(bool1));
      return;
      bool3 = false;
      break;
      bool3 = false;
      continue;
      bool1 = false;
    }
  }
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    int i = paramToServiceMsg.extraData.getInt("eSubCmd");
    paramBundle.putInt("eSubCmd", i);
    paramBundle.putByte("bIsSingle", paramToServiceMsg.extraData.getByte("bIsSingle"));
    paramBundle.putByteArray("vBackground", paramToServiceMsg.extraData.getByteArray("vBackground"));
    paramBundle.putByteArray("vReqSetTemplate", paramToServiceMsg.extraData.getByteArray("vReqSetTemplate"));
    switch (i)
    {
    default: 
      i = 3;
      if (26 == i) {
        a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), null);
      }
      paramBundle = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      if (paramFromServiceMsg.isSuccess()) {
        if (26 == i)
        {
          paramObject = paramBundle.a(paramToServiceMsg.getUin());
          paramFromServiceMsg = paramObject;
          if (paramObject != null)
          {
            paramObject.vBackground = paramToServiceMsg.extraData.getByteArray("vBackground");
            paramBundle.a(paramObject);
            paramFromServiceMsg = paramObject;
          }
        }
      }
      break;
    }
    for (;;)
    {
      if (i != 41) {
        a(i, true, paramFromServiceMsg);
      }
      return;
      i = 24;
      break;
      i = 25;
      break;
      i = 26;
      break;
      i = 41;
      break;
      if (i == 24)
      {
        paramFromServiceMsg = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
        paramFromServiceMsg.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramToServiceMsg.extraData.getByte("bIsSingle"));
        paramFromServiceMsg = paramFromServiceMsg.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      }
      else
      {
        if (i == 41)
        {
          boolean bool;
          if ((paramFromServiceMsg.getResultCode() == 1000) && ((paramObject instanceof RespSetCard)))
          {
            bool = true;
            if (QLog.isColorLevel()) {
              QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetCard success : " + bool + ", data : " + paramObject);
            }
            if ((paramObject == null) || (!bool)) {
              break label1069;
            }
            paramToServiceMsg = (RespSetCard)paramObject;
            if (QLog.isColorLevel()) {
              QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetCard RespSetCard : " + paramToServiceMsg.toString());
            }
            if ((paramToServiceMsg.stHeader == null) || (paramToServiceMsg.stHeader.iReplyCode != 0) || (paramToServiceMsg.vRespSetTemplate == null)) {
              break label1069;
            }
            paramFromServiceMsg = (SSummaryCardRsp)a(paramToServiceMsg.vRespSetTemplate, "rsp", new SSummaryCardRsp());
            if (paramFromServiceMsg == null) {
              break label1069;
            }
            if (QLog.isColorLevel()) {
              QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetCard cardRsp res : " + paramFromServiceMsg.res);
            }
            if (paramFromServiceMsg.res != 0) {
              break label909;
            }
            paramToServiceMsg = paramBundle.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            if (paramToServiceMsg == null) {
              break label1064;
            }
            paramToServiceMsg.lCurrentStyleId = paramFromServiceMsg.styleid;
            paramToServiceMsg.backgroundUrl = paramFromServiceMsg.bgurl;
            paramToServiceMsg.lCurrentBgId = paramFromServiceMsg.bgid;
            paramToServiceMsg.backgroundColor = paramFromServiceMsg.color;
            paramToServiceMsg.dynamicCardFlag = paramFromServiceMsg.dynamicCardFlag;
            paramToServiceMsg.strZipUrl = paramFromServiceMsg.strZipUrl;
            paramToServiceMsg.strActiveUrl = paramFromServiceMsg.strActiveCardUrl;
            paramToServiceMsg.strDrawerCardUrl = paramFromServiceMsg.strDrawerCard;
            paramToServiceMsg.strWzryHeroUrl = paramFromServiceMsg.strWzryHeroUrl;
            paramToServiceMsg.strExtInfo = paramFromServiceMsg.extInfo;
            paramToServiceMsg.cardType = paramFromServiceMsg.cardType;
            paramToServiceMsg.diyDefaultText = paramFromServiceMsg.strDiyDefaultText;
            if (QLog.isColorLevel()) {
              QLog.d("ProfileCard.setcard", 2, "handleSetCard activeUrl = " + paramToServiceMsg.strActiveUrl);
            }
            paramObject = paramFromServiceMsg.bgtype;
            if (paramObject != null) {
              paramToServiceMsg.setBgType(paramObject);
            }
            if ((paramFromServiceMsg.wzryInfo != null) && (!paramFromServiceMsg.wzryInfo.isEmpty())) {
              paramToServiceMsg.setWzryHonorInfo(paramFromServiceMsg.wzryInfo);
            }
            paramToServiceMsg.templateRet = 0;
            if (paramFromServiceMsg.stDiyText != null)
            {
              paramToServiceMsg.diyTextFontId = paramFromServiceMsg.stDiyText.iFontId;
              paramToServiceMsg.diyText = paramFromServiceMsg.stDiyText.strText;
              paramToServiceMsg.diyTextScale = paramFromServiceMsg.stDiyText.fScaling;
              paramToServiceMsg.diyTextDegree = paramFromServiceMsg.stDiyText.fRotationAngle;
              paramToServiceMsg.diyTextTransparency = paramFromServiceMsg.stDiyText.fTransparency;
              if (!TextUtils.isEmpty(paramFromServiceMsg.stDiyText.strPoint))
              {
                paramFromServiceMsg = paramFromServiceMsg.stDiyText.strPoint.split("_");
                if (paramFromServiceMsg.length != 2) {}
              }
            }
          }
          for (;;)
          {
            try
            {
              paramToServiceMsg.diyTextLocX = Float.parseFloat(paramFromServiceMsg[0]);
              paramToServiceMsg.diyTextLocY = Float.parseFloat(paramFromServiceMsg[1]);
              paramBundle.a(paramToServiceMsg);
              paramFromServiceMsg = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
              if (paramFromServiceMsg != null) {
                paramFromServiceMsg.edit().putBoolean("svip_profile_use_guide_shown_flag", false).commit();
              }
              paramFromServiceMsg = null;
              if (paramToServiceMsg != null) {
                paramFromServiceMsg = paramToServiceMsg;
              }
              a(i, true, paramFromServiceMsg);
              paramFromServiceMsg = paramToServiceMsg;
              break;
              bool = false;
            }
            catch (Exception paramFromServiceMsg)
            {
              QLog.e("CardHandler", 1, "set card with diy text response:", paramFromServiceMsg);
              continue;
            }
            label909:
            paramToServiceMsg = "";
            if (!TextUtils.isEmpty(paramFromServiceMsg.emsg)) {
              paramToServiceMsg = paramFromServiceMsg.emsg;
            }
            paramFromServiceMsg = new android.util.Pair(Integer.valueOf(paramFromServiceMsg.res), paramToServiceMsg);
            paramToServiceMsg = null;
            continue;
            a(i, false, paramBundle.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
            if (QLog.isColorLevel()) {
              QLog.e("CardHandler", 2, "-->report MM:cmd=" + paramFromServiceMsg.getServiceCmd() + ",error code=" + paramFromServiceMsg.getBusinessFailCode() + ",uin=" + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            }
            ReportCenter.a().a(paramFromServiceMsg.getServiceCmd(), 100, paramFromServiceMsg.getBusinessFailCode(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 1000277, "[资料卡]设置个性名片失败", true);
            return;
            label1064:
            paramFromServiceMsg = null;
            continue;
            label1069:
            paramFromServiceMsg = null;
            paramToServiceMsg = null;
          }
        }
        paramFromServiceMsg = null;
      }
    }
  }
  
  private void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    boolean bool2;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      bool2 = paramToServiceMsg.extraData.getBoolean("key_searchable", true);
      if (!bool1) {
        break label148;
      }
    }
    label148:
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool1 = true;
        if (bool1) {
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(bool2, false);
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("SetPhoneNumSearchable", 2, paramToServiceMsg.getMessage());
        bool1 = false;
        continue;
        continue;
      }
      if (!bool1)
      {
        bool2 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.b(false);
        a(39, bool1, Boolean.valueOf(bool2));
        return;
        bool1 = false;
        break;
        bool1 = false;
        continue;
      }
    }
  }
  
  private void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if ((paramFromServiceMsg.getResultCode() == 1000) && ((paramObject instanceof SSummaryCardLableRsp))) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetProfileLabel success : " + bool + ", data : " + paramObject);
      }
      if ((!bool) || (paramObject == null)) {
        break label210;
      }
      paramToServiceMsg = (SSummaryCardLableRsp)paramObject;
      if (paramToServiceMsg.ret != 0) {
        break;
      }
      if (paramToServiceMsg.likes != null)
      {
        paramFromServiceMsg = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
        paramBundle = paramFromServiceMsg.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        paramBundle.setLabelList(paramToServiceMsg.likes.label);
        paramFromServiceMsg.a(paramBundle);
      }
      a(52, true, paramObject);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetProfileLabel retCode : " + paramToServiceMsg.ret + ", msg : " + paramToServiceMsg.msg);
    }
    a(52, false, paramObject);
    return;
    label210:
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetProfileLabel fail from msf retCode : " + paramFromServiceMsg.getResultCode());
    }
    a(52, false, paramObject);
    if (QLog.isColorLevel()) {
      QLog.e("CardHandler", 2, "-->report MM:cmd=" + paramFromServiceMsg.getServiceCmd() + ",error code=" + paramFromServiceMsg.getBusinessFailCode() + ",uin=" + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
    ReportCenter.a().a(paramFromServiceMsg.getServiceCmd(), 100, paramFromServiceMsg.getBusinessFailCode(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 1000277, "[资料卡]设置标签失败", true);
  }
  
  private void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    int i;
    Object localObject;
    boolean bool3;
    int j;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      bool1 = true;
      i = -1000;
      localObject = null;
      bool3 = paramToServiceMsg.extraData.getBoolean("key_is_nearby_people_card", false);
      if (bool1) {
        j = i;
      }
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg == null) {
          break label1286;
        }
        j = i;
        if (!paramFromServiceMsg.uint32_result.has()) {
          break label1286;
        }
        j = i;
        i = paramFromServiceMsg.uint32_result.get();
        if (i != 0) {
          break label1280;
        }
        bool1 = true;
        StringBuilder localStringBuilder;
        boolean bool2;
        String[] arrayOfString;
        bool1 = false;
      }
      catch (Exception paramFromServiceMsg)
      {
        try
        {
          if (QLog.isColorLevel())
          {
            QLog.d("CardHandler", 2, "handleSetDetailInfo, ret = " + i + ", isNearbyPeopleCard = " + bool3);
            if ((i == 0) && (!bool3))
            {
              j = i;
              paramObject = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
              j = i;
              paramFromServiceMsg = paramObject.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
              try
              {
                if (paramToServiceMsg.extraData.containsKey("nick"))
                {
                  paramFromServiceMsg.strNick = paramToServiceMsg.extraData.getString("nick");
                  paramObject.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramFromServiceMsg.strNick);
                  if ((this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() != null) && (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(paramToServiceMsg.getUin())))
                  {
                    localObject = Constants.PropertiesKey.nickName.toString() + paramToServiceMsg.getUin();
                    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().setProperty((String)localObject, paramFromServiceMsg.strNick);
                    if (QLog.isColorLevel())
                    {
                      localStringBuilder = new StringBuilder("handleSetDetailInfo set properties");
                      localStringBuilder.append("uin = ").append((String)localObject);
                      localStringBuilder.append("nickname = ").append(paramFromServiceMsg.strNick);
                      localStringBuilder.append("\n");
                      QLog.d("CardHandler", 2, localStringBuilder.toString());
                    }
                  }
                  this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(1).a(3, true, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
                }
                if (paramToServiceMsg.extraData.containsKey("sex"))
                {
                  paramFromServiceMsg.shGender = ((short)paramToServiceMsg.extraData.getByte("sex"));
                  localObject = (NearbyCardManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(105);
                  if (localObject != null) {
                    ((NearbyCardManager)localObject).b(paramFromServiceMsg.shGender);
                  }
                }
                if (paramToServiceMsg.extraData.containsKey("birthday"))
                {
                  paramFromServiceMsg.lBirthday = paramToServiceMsg.extraData.getInt("birthday");
                  paramFromServiceMsg.age = ((byte)paramToServiceMsg.extraData.getInt("age"));
                  paramFromServiceMsg.constellation = paramToServiceMsg.extraData.getInt("key_constellation");
                  localObject = (NearbyCardManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(105);
                  if (localObject != null) {
                    ((NearbyCardManager)localObject).a(paramFromServiceMsg.age);
                  }
                }
                if (paramToServiceMsg.extraData.containsKey("profession")) {
                  paramFromServiceMsg.iProfession = paramToServiceMsg.extraData.getInt("profession");
                }
                if (paramToServiceMsg.extraData.containsKey("company")) {
                  paramFromServiceMsg.strCompany = paramToServiceMsg.extraData.getString("company");
                }
                if (paramToServiceMsg.extraData.containsKey("college")) {
                  paramFromServiceMsg.strSchool = paramToServiceMsg.extraData.getString("college");
                }
                try
                {
                  NearbySPUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "self_school_name", paramFromServiceMsg.strSchool);
                  if (!paramToServiceMsg.extraData.containsKey("location")) {
                    continue;
                  }
                  localObject = paramToServiceMsg.extraData.getStringArray("location");
                  localStringBuilder = new StringBuilder();
                  localStringBuilder.append(localObject[0]).append("-").append(localObject[1]).append("-").append(localObject[2]).append("-").append(localObject[3]);
                  paramFromServiceMsg.strLocationCodes = localStringBuilder.toString();
                  paramFromServiceMsg.strLocationDesc = paramToServiceMsg.extraData.getString("locationo_desc");
                  localObject = paramToServiceMsg.extraData.getStringArray("location_name");
                  if ((localObject == null) || (localObject.length != 4)) {
                    continue;
                  }
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  localStringBuilder = new StringBuilder("nameArray: ");
                  j = 0;
                  if (j >= 4) {
                    continue;
                  }
                  localStringBuilder.append(localObject[j]).append(" ");
                  j += 1;
                  continue;
                }
                catch (Exception localException)
                {
                  localException.printStackTrace();
                  continue;
                }
                if (!QLog.isColorLevel()) {
                  continue;
                }
              }
              catch (Exception paramObject)
              {
                paramToServiceMsg = paramFromServiceMsg;
                paramFromServiceMsg = paramObject;
              }
              QLog.d("CardHandler", 2, "handleGetDetailInfo", paramFromServiceMsg);
              bool2 = false;
              j = i;
              if (!bool3) {
                a(31, bool2, new Object[] { Integer.valueOf(j), paramToServiceMsg });
              }
              return;
              QLog.d("CardHandler", 2, localStringBuilder.toString());
              paramFromServiceMsg.strCountry = localException[0];
              paramFromServiceMsg.strProvince = localException[1];
              paramFromServiceMsg.strCity = localException[2];
              if (paramToServiceMsg.extraData.containsKey("hometown"))
              {
                arrayOfString = paramToServiceMsg.extraData.getStringArray("hometown");
                localStringBuilder = new StringBuilder();
                localStringBuilder.append(arrayOfString[0]).append("-").append(arrayOfString[1]).append("-").append(arrayOfString[2]).append("-").append(arrayOfString[3]);
                paramFromServiceMsg.strHometownCodes = localStringBuilder.toString();
                paramFromServiceMsg.strHometownDesc = paramToServiceMsg.extraData.getString("hometown_desc");
              }
              if (paramToServiceMsg.extraData.containsKey("email")) {
                paramFromServiceMsg.strEmail = paramToServiceMsg.extraData.getString("email");
              }
              if (paramToServiceMsg.extraData.containsKey("personalNote")) {
                paramFromServiceMsg.strPersonalNote = paramToServiceMsg.extraData.getString("personalNote");
              }
              if (paramToServiceMsg.extraData.containsKey("key_personality_label_switch")) {
                paramFromServiceMsg.switch_disable_personality_label = paramToServiceMsg.extraData.getShort("key_personality_label_switch");
              }
              if (paramToServiceMsg.extraData.containsKey("key_extend_friend_switch"))
              {
                if (paramToServiceMsg.extraData.getShort("key_extend_friend_switch") == 0)
                {
                  bool2 = true;
                  paramFromServiceMsg.isShowCard = bool2;
                }
              }
              else
              {
                paramObject.a(paramFromServiceMsg);
                paramToServiceMsg = paramFromServiceMsg;
                bool2 = bool1;
                j = i;
                continue;
              }
              bool2 = false;
              continue;
              bool2 = bool1;
              paramToServiceMsg = arrayOfString;
              j = i;
              if (!QLog.isColorLevel()) {
                continue;
              }
              paramToServiceMsg = new StringBuilder().append("setDetailInfo fail : ");
              if (paramFromServiceMsg != null)
              {
                j = paramFromServiceMsg.getResultCode();
                QLog.w("CardHandler", 2, j);
                bool2 = bool1;
                paramToServiceMsg = arrayOfString;
                j = i;
                continue;
              }
              j = -1;
              continue;
              paramFromServiceMsg = paramFromServiceMsg;
              paramToServiceMsg = null;
              i = j;
              continue;
            }
          }
        }
        catch (Exception paramFromServiceMsg)
        {
          paramToServiceMsg = null;
          continue;
          paramToServiceMsg = null;
          continue;
          continue;
        }
      }
      break;
      label1280:
      bool1 = false;
      continue;
      label1286:
      bool1 = false;
    }
  }
  
  private void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if ((paramFromServiceMsg.getResultCode() == 1000) && ((paramObject instanceof SSummaryCardLableRsp))) {}
    Card localCard;
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetLabelLike success : " + bool + ", data : " + paramObject);
      }
      paramBundle = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      localCard = paramBundle.b(String.valueOf(paramToServiceMsg.extraData.getLong("destUin")));
      long l = paramToServiceMsg.extraData.getLong("labelId");
      if ((!bool) || (paramObject == null)) {
        break label254;
      }
      paramToServiceMsg = (SSummaryCardLableRsp)paramObject;
      if (paramToServiceMsg.ret != 0) {
        break;
      }
      if (paramToServiceMsg.likes != null)
      {
        localCard.setLabelList(paramToServiceMsg.likes.label);
        paramBundle.a(localCard);
      }
      a(53, true, new Object[] { localCard, Long.valueOf(Long.valueOf(l).longValue()) });
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetLabelLike retCode : " + paramToServiceMsg.ret + ", msg : " + paramToServiceMsg.msg);
    }
    a(53, false, localCard);
    return;
    label254:
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetLabelLike fail from msf retCode : " + paramFromServiceMsg.getResultCode());
    }
    a(53, false, localCard);
    if (QLog.isColorLevel()) {
      QLog.e("CardHandler", 2, "-->report MM:cmd=" + paramFromServiceMsg.getServiceCmd() + ",error code=" + paramFromServiceMsg.getBusinessFailCode() + ",uin=" + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
    ReportCenter.a().a(paramFromServiceMsg.getServiceCmd(), 100, paramFromServiceMsg.getBusinessFailCode(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 1000277, "[资料卡]设置标签失败", true);
  }
  
  private void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    int i3;
    Object localObject1;
    Object localObject4;
    Object localObject3;
    Object localObject5;
    Object localObject2;
    Object localObject6;
    int k;
    int m;
    int i2;
    int n;
    int i1;
    int i5;
    label265:
    short s;
    int i6;
    label362:
    int i4;
    Object localObject12;
    label727:
    Object localObject13;
    Object localObject11;
    label3093:
    label3237:
    label3379:
    label3693:
    int i8;
    label4055:
    label4346:
    Object localObject9;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      bool1 = true;
      if (bool1)
      {
        try
        {
          paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
          localByteBuffer = ByteBuffer.wrap(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
          if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.uint32_result.has()) || (paramFromServiceMsg.uint32_result.get() != 0)) {
            break label10800;
          }
          localLong = Long.valueOf(Utils.a(localByteBuffer.getInt()));
          localByteBuffer.get();
          int i7 = localByteBuffer.getShort();
          if (QLog.isColorLevel()) {
            QLog.i("CardHandler", 2, "handleGetDetailInfo request success. TLVCount=" + i7);
          }
          i3 = 0;
          localFriendsManager = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
          localCard = localFriendsManager.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          paramFromServiceMsg = "0";
          localObject1 = "0";
          paramObject = "0";
          localObject4 = "0";
          localObject3 = "0";
          localObject5 = "0";
          localObject2 = "0";
          localObject6 = "0";
          k = 0;
          m = 0;
          try
          {
            localApolloManager = (ApolloManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
            localApolloBaseInfo = localApolloManager.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            j = 0;
            i2 = -1;
            n = -1;
            i1 = 0;
            i5 = localByteBuffer.position();
            if ((!localByteBuffer.hasRemaining()) || (i3 >= i7)) {
              break label10420;
            }
            localByteBuffer.position(i5);
            s = localByteBuffer.getShort();
            i = localByteBuffer.getShort();
            i6 = localByteBuffer.position() + i;
            if (!QLog.isColorLevel()) {
              break label11107;
            }
            QLog.d("CardHandler", 2, String.format("handleGetDetailInfo K=%s, L=%s, nextTLVPosition=%s", new Object[] { Short.valueOf(s), Short.valueOf(i), Integer.valueOf(i6) }));
          }
          catch (Exception paramObject)
          {
            paramFromServiceMsg = localCard;
          }
          if (QLog.isColorLevel()) {
            QLog.d("CardHandler", 2, "invalid type: " + s);
          }
          localByteBuffer.position(localByteBuffer.position() + i);
        }
        catch (Exception paramObject)
        {
          label6794:
          label6924:
          label9752:
          for (;;)
          {
            ByteBuffer localByteBuffer;
            Long localLong;
            FriendsManager localFriendsManager;
            Card localCard;
            ApolloManager localApolloManager;
            ApolloBaseInfo localApolloBaseInfo;
            int i;
            Object localObject7;
            Object localObject10;
            label4176:
            label7414:
            paramFromServiceMsg = null;
            label6689:
            label7237:
            label8018:
            label9571:
            continue;
            label7715:
            label7845:
            label8366:
            int j = -1111;
          }
        }
        localObject7 = new byte[i];
        localByteBuffer.get((byte[])localObject7);
        localCard.strNick = new String((byte[])localObject7);
        if (!QLog.isColorLevel()) {
          break label11691;
        }
        QLog.d("CardHandler", 2, "strNick = " + localCard.strNick);
        i5 = n;
        localObject7 = localObject6;
        i4 = k;
        localObject6 = localObject1;
        localObject12 = paramObject;
        localObject10 = paramFromServiceMsg;
        n = i1;
        i1 = i5;
        k = m;
        m = i4;
        paramFromServiceMsg = (FromServiceMsg)localObject7;
        paramObject = localObject2;
        localObject1 = localObject5;
        localObject2 = localObject3;
        localObject3 = localObject4;
        localObject4 = localObject12;
        localObject5 = localObject6;
        localObject6 = localObject10;
        break label11763;
        i4 = localByteBuffer.get();
        if (i4 == 1) {
          localCard.shGender = 0;
        }
        while (QLog.isColorLevel())
        {
          QLog.d("CardHandler", 2, "shGender = " + localCard.shGender);
          i5 = n;
          localObject7 = localObject6;
          i4 = k;
          localObject6 = localObject1;
          localObject12 = paramObject;
          localObject10 = paramFromServiceMsg;
          n = i1;
          i1 = i5;
          k = m;
          m = i4;
          paramFromServiceMsg = (FromServiceMsg)localObject7;
          paramObject = localObject2;
          localObject1 = localObject5;
          localObject2 = localObject3;
          localObject3 = localObject4;
          localObject4 = localObject12;
          localObject5 = localObject6;
          localObject6 = localObject10;
          break label11763;
          if (i4 == 2)
          {
            localCard.shGender = 1;
            continue;
            bool2 = false;
            paramToServiceMsg = paramFromServiceMsg;
            bool1 = bool2;
            if (QLog.isColorLevel())
            {
              QLog.d("CardHandler", 2, "handleGetDetailInfo", paramObject);
              bool1 = bool2;
              paramToServiceMsg = paramFromServiceMsg;
            }
            a(20, bool1, paramToServiceMsg);
          }
          else
          {
            localCard.shGender = -1;
            continue;
            i4 = localByteBuffer.getInt();
            if (QLog.isColorLevel()) {
              QLog.d("CardHandler", 2, "profession = " + i4);
            }
            if (NearbyProfileUtil.a(i4))
            {
              localCard.iProfession = i4;
              i5 = n;
              localObject7 = localObject6;
              i4 = k;
              localObject6 = localObject1;
              localObject12 = paramObject;
              localObject10 = paramFromServiceMsg;
              n = i1;
              i1 = i5;
              k = m;
              m = i4;
              paramFromServiceMsg = (FromServiceMsg)localObject7;
              paramObject = localObject2;
              localObject1 = localObject5;
              localObject2 = localObject3;
              localObject3 = localObject4;
              localObject4 = localObject12;
              localObject5 = localObject6;
              localObject6 = localObject10;
              break label11763;
            }
            localCard.iProfession = -1;
            i5 = n;
            localObject7 = localObject6;
            i4 = k;
            localObject6 = localObject1;
            localObject12 = paramObject;
            localObject10 = paramFromServiceMsg;
            n = i1;
            i1 = i5;
            k = m;
            m = i4;
            paramFromServiceMsg = (FromServiceMsg)localObject7;
            paramObject = localObject2;
            localObject1 = localObject5;
            localObject2 = localObject3;
            localObject3 = localObject4;
            localObject4 = localObject12;
            localObject5 = localObject6;
            localObject6 = localObject10;
            break label11763;
            localCard.lBirthday = localByteBuffer.getInt();
            if (localCard.lBirthday == 0L) {
              localCard.constellation = 0;
            }
            for (;;)
            {
              if (QLog.isColorLevel())
              {
                QLog.d("CardHandler", 2, "birth = " + localCard.lBirthday + ", constellation = " + localCard.constellation);
                i5 = n;
                localObject7 = localObject6;
                i4 = k;
                localObject6 = localObject1;
                localObject12 = paramObject;
                localObject10 = paramFromServiceMsg;
                n = i1;
                i1 = i5;
                k = m;
                m = i4;
                paramFromServiceMsg = (FromServiceMsg)localObject7;
                paramObject = localObject2;
                localObject1 = localObject5;
                localObject2 = localObject3;
                localObject3 = localObject4;
                localObject4 = localObject12;
                localObject5 = localObject6;
                localObject6 = localObject10;
                break label11763;
                localCard.constellation = Utils.a((int)((localCard.lBirthday & 0xFF00) >> 8), (int)(localCard.lBirthday & 0xFF));
                continue;
                localObject7 = new byte[i];
                localByteBuffer.get((byte[])localObject7);
                localObject7 = new String((byte[])localObject7);
                localCard.strCompany = ((String)localObject7);
                if (QLog.isColorLevel())
                {
                  QLog.d("CardHandler", 2, "company = " + (String)localObject7);
                  i5 = n;
                  localObject7 = localObject6;
                  i4 = k;
                  localObject6 = localObject1;
                  localObject12 = paramObject;
                  localObject10 = paramFromServiceMsg;
                  n = i1;
                  i1 = i5;
                  k = m;
                  m = i4;
                  paramFromServiceMsg = (FromServiceMsg)localObject7;
                  paramObject = localObject2;
                  localObject1 = localObject5;
                  localObject2 = localObject3;
                  localObject3 = localObject4;
                  localObject4 = localObject12;
                  localObject5 = localObject6;
                  localObject6 = localObject10;
                  break label11763;
                  m = localByteBuffer.getInt();
                  i4 = localByteBuffer.getInt();
                  i5 = localByteBuffer.getInt();
                  if (QLog.isColorLevel()) {
                    QLog.d("CardHandler", 2, "hometown, countryId " + m + ", provinceId " + i4 + ", cityId " + i5);
                  }
                  localObject7 = ConditionSearchManager.a(m);
                  paramFromServiceMsg = ConditionSearchManager.a(i4);
                  localObject10 = ConditionSearchManager.a(i5);
                  localObject1 = localObject5;
                  localObject5 = paramFromServiceMsg;
                  i4 = 1;
                  m = k;
                  paramFromServiceMsg = (FromServiceMsg)localObject6;
                  paramObject = localObject2;
                  localObject6 = localObject10;
                  k = n;
                  n = i1;
                  i1 = k;
                  k = i4;
                  localObject2 = localObject3;
                  localObject3 = localObject4;
                  localObject4 = localObject6;
                  localObject6 = localObject7;
                  break label11763;
                  m = localByteBuffer.getInt();
                  if (QLog.isColorLevel()) {
                    QLog.d("CardHandler", 2, "hometown, districtId " + m);
                  }
                  localObject4 = ConditionSearchManager.a(m);
                  i4 = 1;
                  localObject10 = localObject6;
                  localObject6 = localObject5;
                  localObject5 = localObject1;
                  m = k;
                  k = n;
                  localObject7 = paramFromServiceMsg;
                  localObject12 = paramObject;
                  n = i1;
                  i1 = k;
                  k = i4;
                  paramFromServiceMsg = (FromServiceMsg)localObject10;
                  paramObject = localObject2;
                  localObject1 = localObject6;
                  localObject2 = localObject3;
                  localObject3 = localObject4;
                  localObject4 = localObject12;
                  localObject6 = localObject7;
                  break label11763;
                  k = localByteBuffer.getInt();
                  i4 = localByteBuffer.getInt();
                  i5 = localByteBuffer.getInt();
                  if (QLog.isColorLevel()) {
                    QLog.d("CardHandler", 2, "location, countryId " + k + ", provinceId " + i4 + ", cityId " + i5);
                  }
                  localObject2 = ConditionSearchManager.a(k);
                  localObject12 = ConditionSearchManager.a(i4);
                  localObject13 = ConditionSearchManager.a(i5);
                  localObject5 = paramObject;
                  localObject7 = localObject1;
                  localObject10 = paramFromServiceMsg;
                  paramFromServiceMsg = (FromServiceMsg)localObject6;
                  localObject3 = localObject4;
                  k = n;
                  paramObject = localObject13;
                  n = i1;
                  i4 = 1;
                  localObject1 = localObject12;
                  i1 = k;
                  k = m;
                  m = i4;
                  localObject4 = localObject5;
                  localObject5 = localObject7;
                  localObject6 = localObject10;
                  break label11763;
                  k = localByteBuffer.getInt();
                  if (QLog.isColorLevel()) {
                    QLog.d("CardHandler", 2, "location, districtId " + k);
                  }
                  localObject7 = ConditionSearchManager.a(k);
                  k = m;
                  m = n;
                  localObject10 = localObject5;
                  localObject6 = paramFromServiceMsg;
                  localObject5 = localObject1;
                  localObject12 = paramObject;
                  n = i1;
                  i4 = 1;
                  i1 = m;
                  m = i4;
                  paramFromServiceMsg = (FromServiceMsg)localObject7;
                  paramObject = localObject2;
                  localObject1 = localObject10;
                  localObject2 = localObject3;
                  localObject3 = localObject4;
                  localObject4 = localObject12;
                  break label11763;
                  localObject7 = new byte[i];
                  localByteBuffer.get((byte[])localObject7);
                  localObject7 = new String((byte[])localObject7);
                  localCard.strEmail = ((String)localObject7);
                  if (QLog.isColorLevel())
                  {
                    QLog.d("CardHandler", 2, "email = " + (String)localObject7);
                    i5 = n;
                    localObject7 = localObject6;
                    i4 = k;
                    localObject6 = localObject1;
                    localObject12 = paramObject;
                    localObject10 = paramFromServiceMsg;
                    n = i1;
                    i1 = i5;
                    k = m;
                    m = i4;
                    paramFromServiceMsg = (FromServiceMsg)localObject7;
                    paramObject = localObject2;
                    localObject1 = localObject5;
                    localObject2 = localObject3;
                    localObject3 = localObject4;
                    localObject4 = localObject12;
                    localObject5 = localObject6;
                    localObject6 = localObject10;
                    break label11763;
                    localObject7 = new byte[i];
                    localByteBuffer.get((byte[])localObject7);
                    localObject7 = new String((byte[])localObject7);
                    localCard.strPersonalNote = ((String)localObject7);
                    if (QLog.isColorLevel())
                    {
                      QLog.d("CardHandler", 2, "personal note = " + (String)localObject7);
                      i5 = n;
                      localObject7 = localObject6;
                      i4 = k;
                      localObject6 = localObject1;
                      localObject12 = paramObject;
                      localObject10 = paramFromServiceMsg;
                      n = i1;
                      i1 = i5;
                      k = m;
                      m = i4;
                      paramFromServiceMsg = (FromServiceMsg)localObject7;
                      paramObject = localObject2;
                      localObject1 = localObject5;
                      localObject2 = localObject3;
                      localObject3 = localObject4;
                      localObject4 = localObject12;
                      localObject5 = localObject6;
                      localObject6 = localObject10;
                      break label11763;
                      localObject7 = new byte[i];
                      localByteBuffer.get((byte[])localObject7);
                      localObject7 = new String((byte[])localObject7);
                      localCard.strSchool = ((String)localObject7);
                      try
                      {
                        NearbySPUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "self_school_name", localObject7);
                        if (!QLog.isColorLevel()) {
                          break label11691;
                        }
                        QLog.d("CardHandler", 2, "school = " + (String)localObject7);
                        i5 = n;
                        localObject7 = localObject6;
                        i4 = k;
                        localObject6 = localObject1;
                        localObject12 = paramObject;
                        localObject10 = paramFromServiceMsg;
                        n = i1;
                        i1 = i5;
                        k = m;
                        m = i4;
                        paramFromServiceMsg = (FromServiceMsg)localObject7;
                        paramObject = localObject2;
                        localObject1 = localObject5;
                        localObject2 = localObject3;
                        localObject3 = localObject4;
                        localObject4 = localObject12;
                        localObject5 = localObject6;
                        localObject6 = localObject10;
                      }
                      catch (Exception localException2)
                      {
                        for (;;)
                        {
                          localException2.printStackTrace();
                        }
                      }
                      localCard.age = localByteBuffer.get();
                      localCard.shAge = ((short)localCard.age);
                      if (QLog.isColorLevel())
                      {
                        QLog.d("CardHandler", 2, "age = " + localCard.age);
                        i5 = n;
                        localObject7 = localObject6;
                        i4 = k;
                        localObject6 = localObject1;
                        localObject12 = paramObject;
                        localObject11 = paramFromServiceMsg;
                        n = i1;
                        i1 = i5;
                        k = m;
                        m = i4;
                        paramFromServiceMsg = (FromServiceMsg)localObject7;
                        paramObject = localObject2;
                        localObject1 = localObject5;
                        localObject2 = localObject3;
                        localObject3 = localObject4;
                        localObject4 = localObject12;
                        localObject5 = localObject6;
                        localObject6 = localObject11;
                        break label11763;
                        localCard.constellation = localByteBuffer.get();
                        if (QLog.isColorLevel())
                        {
                          QLog.d("CardHandler", 2, "constellation = " + localCard.constellation);
                          i5 = n;
                          localObject7 = localObject6;
                          i4 = k;
                          localObject6 = localObject1;
                          localObject12 = paramObject;
                          localObject11 = paramFromServiceMsg;
                          n = i1;
                          i1 = i5;
                          k = m;
                          m = i4;
                          paramFromServiceMsg = (FromServiceMsg)localObject7;
                          paramObject = localObject2;
                          localObject1 = localObject5;
                          localObject2 = localObject3;
                          localObject3 = localObject4;
                          localObject4 = localObject12;
                          localObject5 = localObject6;
                          localObject6 = localObject11;
                          break label11763;
                          i4 = localByteBuffer.getShort();
                          i5 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getInt("nearby_people_profile_ok_new", -1);
                          if (QLog.isColorLevel()) {
                            QLog.i("CardHandler", 2, "handleGetDetalInfo nearbyprofile local is :" + i5 + " server is: " + i4);
                          }
                          if ((i5 != i4) && (i5 != 1))
                          {
                            this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putInt("nearby_people_profile_ok_new", i4).commit();
                            i5 = n;
                            localObject7 = localObject6;
                            i4 = k;
                            localObject6 = localObject1;
                            localObject12 = paramObject;
                            localObject11 = paramFromServiceMsg;
                            n = i1;
                            i1 = i5;
                            k = m;
                            m = i4;
                            paramFromServiceMsg = (FromServiceMsg)localObject7;
                            paramObject = localObject2;
                            localObject1 = localObject5;
                            localObject2 = localObject3;
                            localObject3 = localObject4;
                            localObject4 = localObject12;
                            localObject5 = localObject6;
                            localObject6 = localObject11;
                            break label11763;
                            i4 = localByteBuffer.getShort();
                            i5 = ((Integer)NearbySPUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "nearby_people_avatar_upload_ok", Integer.valueOf(-1))).intValue();
                            if (QLog.isColorLevel()) {
                              QLog.i("CardHandler", 2, "handleGetDetalInfo hasNearbyAvatarFlag local is :" + i5 + " server is: " + i4);
                            }
                            if ((i5 != i4) && (i5 != 1))
                            {
                              NearbySPUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "nearby_people_avatar_upload_ok", Integer.valueOf(i4));
                              i5 = n;
                              localObject7 = localObject6;
                              i4 = k;
                              localObject6 = localObject1;
                              localObject12 = paramObject;
                              localObject11 = paramFromServiceMsg;
                              n = i1;
                              i1 = i5;
                              k = m;
                              m = i4;
                              paramFromServiceMsg = (FromServiceMsg)localObject7;
                              paramObject = localObject2;
                              localObject1 = localObject5;
                              localObject2 = localObject3;
                              localObject3 = localObject4;
                              localObject4 = localObject12;
                              localObject5 = localObject6;
                              localObject6 = localObject11;
                              break label11763;
                              i5 = localByteBuffer.getShort();
                              n = ((Integer)NearbySPUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "qq_avatar_type", Integer.valueOf(-1))).intValue();
                              if (QLog.isColorLevel()) {
                                QLog.i("CardHandler", 2, "handleGetDetailInfo qq avatar type local is: " + n + " server is: " + i5);
                              }
                              if (n != i5)
                              {
                                NearbySPUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "qq_avatar_type", Integer.valueOf(i5));
                                n = i1;
                                i4 = k;
                                localObject7 = paramObject;
                                localObject11 = localObject1;
                                localObject12 = paramFromServiceMsg;
                                i1 = i5;
                                k = m;
                                m = i4;
                                paramFromServiceMsg = (FromServiceMsg)localObject6;
                                paramObject = localObject2;
                                localObject1 = localObject5;
                                localObject2 = localObject3;
                                localObject3 = localObject4;
                                localObject4 = localObject7;
                                localObject5 = localObject11;
                                localObject6 = localObject12;
                                break label11763;
                                i4 = localByteBuffer.getShort();
                                if (QLog.isColorLevel()) {
                                  QLog.i("CardHandler", 2, "handleGetDetialInfo is showNearbyGuide: " + i4);
                                }
                                localObject7 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
                                if (i4 != 1) {
                                  break label11850;
                                }
                                bool2 = true;
                                NearbySPUtil.a((String)localObject7, "nearby_need_show_guide", Boolean.valueOf(bool2));
                                i5 = n;
                                localObject7 = localObject6;
                                i4 = k;
                                localObject6 = localObject1;
                                localObject12 = paramObject;
                                localObject11 = paramFromServiceMsg;
                                n = i1;
                                i1 = i5;
                                k = m;
                                m = i4;
                                paramFromServiceMsg = (FromServiceMsg)localObject7;
                                paramObject = localObject2;
                                localObject1 = localObject5;
                                localObject2 = localObject3;
                                localObject3 = localObject4;
                                localObject4 = localObject12;
                                localObject5 = localObject6;
                                localObject6 = localObject11;
                                break label11763;
                                i4 = localByteBuffer.getShort();
                                if (QLog.isColorLevel()) {
                                  QLog.i("CardHandler", 2, "handleGetDetialInfo isNovice: " + i4);
                                }
                                localObject7 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
                                if (i4 != 1) {
                                  break label11856;
                                }
                                bool2 = true;
                                NearbySPUtil.a((String)localObject7, "is_nearby_novice", Boolean.valueOf(bool2));
                                i5 = n;
                                localObject7 = localObject6;
                                i4 = k;
                                localObject6 = localObject1;
                                localObject12 = paramObject;
                                localObject11 = paramFromServiceMsg;
                                n = i1;
                                i1 = i5;
                                k = m;
                                m = i4;
                                paramFromServiceMsg = (FromServiceMsg)localObject7;
                                paramObject = localObject2;
                                localObject1 = localObject5;
                                localObject2 = localObject3;
                                localObject3 = localObject4;
                                localObject4 = localObject12;
                                localObject5 = localObject6;
                                localObject6 = localObject11;
                                break label11763;
                                boolean bool3 = false;
                                boolean bool4;
                                if (2 == i)
                                {
                                  bool4 = SettingCloneUtil.readValue(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), localLong.toString(), null, "qqsetting_pcactive_key", false);
                                  localObject7 = new byte[i];
                                  localByteBuffer.get((byte[])localObject7);
                                  if (Utils.a((byte[])localObject7, 0) != 0) {
                                    break label11862;
                                  }
                                  bool2 = false;
                                  bool3 = bool2;
                                  if (bool4 != bool2)
                                  {
                                    SettingCloneUtil.writeValue(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), localLong.toString(), null, "qqsetting_pcactive_key", bool2);
                                    localObject7 = new Intent("com.tencent.mobileqq.activity.NotifyPushSettingActivity.PCActive");
                                    ((Intent)localObject7).putExtra("pcActive", bool2);
                                    ((Intent)localObject7).putExtra("uin", localLong.toString());
                                    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast((Intent)localObject7);
                                    bool3 = bool2;
                                  }
                                }
                                if (!QLog.isColorLevel()) {
                                  break label11691;
                                }
                                QLog.d("PCActiveState", 2, "Get PCActiveState=" + bool3);
                                i5 = n;
                                localObject7 = localObject6;
                                i4 = k;
                                localObject6 = localObject1;
                                localObject12 = paramObject;
                                localObject11 = paramFromServiceMsg;
                                n = i1;
                                i1 = i5;
                                k = m;
                                m = i4;
                                paramFromServiceMsg = (FromServiceMsg)localObject7;
                                paramObject = localObject2;
                                localObject1 = localObject5;
                                localObject2 = localObject3;
                                localObject3 = localObject4;
                                localObject4 = localObject12;
                                localObject5 = localObject6;
                                localObject6 = localObject11;
                                break label11763;
                                bool3 = false;
                                if (QLog.isColorLevel()) {
                                  QLog.i("CardHandler", 2, "isHelloLiveMessageEnable length=" + i);
                                }
                                if (2 == i)
                                {
                                  bool4 = SettingCloneUtil.readValue(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), localLong.toString(), null, "qqsetting_hello_live_message", false);
                                  localObject7 = new byte[i];
                                  localByteBuffer.get((byte[])localObject7);
                                  i4 = Utils.a((byte[])localObject7, 0);
                                  if (!QLog.isColorLevel()) {
                                    break label11868;
                                  }
                                  QLog.i("CardHandler", 2, "isHelloLiveMessageEnable sFieldValue=" + i4);
                                  break label11868;
                                  bool3 = bool2;
                                  if (bool4 != bool2)
                                  {
                                    SettingCloneUtil.writeValue(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication(), localLong.toString(), null, "qqsetting_hello_live_message", bool2);
                                    localObject7 = new Intent("com.tencent.mobileqq.activity.NotifyPushSettingActivity.HelloLiveMessage");
                                    ((Intent)localObject7).putExtra("isHelloLiveMessageEnable", bool2);
                                    ((Intent)localObject7).putExtra("uin", localLong.toString());
                                    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast((Intent)localObject7);
                                    bool3 = bool2;
                                  }
                                }
                                if (!QLog.isColorLevel()) {
                                  break label11691;
                                }
                                QLog.i("CardHandler", 2, "Get HELLO_LIVE_MESSAGE=" + bool3);
                                i5 = n;
                                localObject7 = localObject6;
                                i4 = k;
                                localObject6 = localObject1;
                                localObject12 = paramObject;
                                localObject11 = paramFromServiceMsg;
                                n = i1;
                                i1 = i5;
                                k = m;
                                m = i4;
                                paramFromServiceMsg = (FromServiceMsg)localObject7;
                                paramObject = localObject2;
                                localObject1 = localObject5;
                                localObject2 = localObject3;
                                localObject3 = localObject4;
                                localObject4 = localObject12;
                                localObject5 = localObject6;
                                localObject6 = localObject11;
                                break label11763;
                                i4 = localByteBuffer.getShort();
                                if (QLog.isColorLevel()) {
                                  QLog.i("CardHandler", 2, "handleGetDetalInfo server dating symbol is :" + i4);
                                }
                                if (i4 != 1) {
                                  break label11691;
                                }
                                this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().b();
                                i5 = n;
                                localObject7 = localObject6;
                                i4 = k;
                                localObject6 = localObject1;
                                localObject12 = paramObject;
                                localObject11 = paramFromServiceMsg;
                                n = i1;
                                i1 = i5;
                                k = m;
                                m = i4;
                                paramFromServiceMsg = (FromServiceMsg)localObject7;
                                paramObject = localObject2;
                                localObject1 = localObject5;
                                localObject2 = localObject3;
                                localObject3 = localObject4;
                                localObject4 = localObject12;
                                localObject5 = localObject6;
                                localObject6 = localObject11;
                                break label11763;
                                i4 = localByteBuffer.getShort();
                                if (!QLog.isColorLevel()) {
                                  break label11885;
                                }
                                QLog.i("CardHandler", 2, "handleGetDetalInfo server calltab visible is :" + i4);
                                break label11885;
                                i5 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(4);
                                i8 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(0);
                                if (i8 != 0) {
                                  break label11902;
                                }
                                localObject7 = new Integer[7];
                                localObject7[3] = Integer.valueOf(i4);
                                this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a((Integer[])localObject7);
                                i5 = n;
                                localObject7 = localObject6;
                                i4 = k;
                                localObject6 = localObject1;
                                localObject12 = paramObject;
                                localObject11 = paramFromServiceMsg;
                                n = i1;
                                i1 = i5;
                                k = m;
                                m = i4;
                                paramFromServiceMsg = (FromServiceMsg)localObject7;
                                paramObject = localObject2;
                                localObject1 = localObject5;
                                localObject2 = localObject3;
                                localObject3 = localObject4;
                                localObject4 = localObject12;
                                localObject5 = localObject6;
                                localObject6 = localObject11;
                                break label11763;
                                b(bool2, false);
                                i5 = n;
                                localObject7 = localObject6;
                                i4 = k;
                                localObject6 = localObject1;
                                localObject12 = paramObject;
                                localObject11 = paramFromServiceMsg;
                                n = i1;
                                i1 = i5;
                                k = m;
                                m = i4;
                                paramFromServiceMsg = (FromServiceMsg)localObject7;
                                paramObject = localObject2;
                                localObject1 = localObject5;
                                localObject2 = localObject3;
                                localObject3 = localObject4;
                                localObject4 = localObject12;
                                localObject5 = localObject6;
                                localObject6 = localObject11;
                                break label11763;
                                localCard.switch_disable_personality_label = localByteBuffer.getShort();
                                i5 = n;
                                localObject7 = localObject6;
                                i4 = k;
                                localObject6 = localObject1;
                                localObject12 = paramObject;
                                localObject11 = paramFromServiceMsg;
                                n = i1;
                                i1 = i5;
                                k = m;
                                m = i4;
                                paramFromServiceMsg = (FromServiceMsg)localObject7;
                                paramObject = localObject2;
                                localObject1 = localObject5;
                                localObject2 = localObject3;
                                localObject3 = localObject4;
                                localObject4 = localObject12;
                                localObject5 = localObject6;
                                localObject6 = localObject11;
                                break label11763;
                                if (localByteBuffer.getShort() != 0) {
                                  break label11932;
                                }
                                bool2 = true;
                                localCard.isShowCard = bool2;
                                i5 = n;
                                localObject7 = localObject6;
                                i4 = k;
                                localObject6 = localObject1;
                                localObject12 = paramObject;
                                localObject11 = paramFromServiceMsg;
                                n = i1;
                                i1 = i5;
                                k = m;
                                m = i4;
                                paramFromServiceMsg = (FromServiceMsg)localObject7;
                                paramObject = localObject2;
                                localObject1 = localObject5;
                                localObject2 = localObject3;
                                localObject3 = localObject4;
                                localObject4 = localObject12;
                                localObject5 = localObject6;
                                localObject6 = localObject11;
                                break label11763;
                                localCard.switch_interest = localByteBuffer.getShort();
                                i5 = n;
                                localObject7 = localObject6;
                                i4 = k;
                                localObject6 = localObject1;
                                localObject12 = paramObject;
                                localObject11 = paramFromServiceMsg;
                                n = i1;
                                i1 = i5;
                                k = m;
                                m = i4;
                                paramFromServiceMsg = (FromServiceMsg)localObject7;
                                paramObject = localObject2;
                                localObject1 = localObject5;
                                localObject2 = localObject3;
                                localObject3 = localObject4;
                                localObject4 = localObject12;
                                localObject5 = localObject6;
                                localObject6 = localObject11;
                                break label11763;
                                localCard.switch_music = localByteBuffer.getShort();
                                i5 = n;
                                localObject7 = localObject6;
                                i4 = k;
                                localObject6 = localObject1;
                                localObject12 = paramObject;
                                localObject11 = paramFromServiceMsg;
                                n = i1;
                                i1 = i5;
                                k = m;
                                m = i4;
                                paramFromServiceMsg = (FromServiceMsg)localObject7;
                                paramObject = localObject2;
                                localObject1 = localObject5;
                                localObject2 = localObject3;
                                localObject3 = localObject4;
                                localObject4 = localObject12;
                                localObject5 = localObject6;
                                localObject6 = localObject11;
                                break label11763;
                                localCard.switch_recent_activity = localByteBuffer.getShort();
                                i5 = n;
                                localObject7 = localObject6;
                                i4 = k;
                                localObject6 = localObject1;
                                localObject12 = paramObject;
                                localObject11 = paramFromServiceMsg;
                                n = i1;
                                i1 = i5;
                                k = m;
                                m = i4;
                                paramFromServiceMsg = (FromServiceMsg)localObject7;
                                paramObject = localObject2;
                                localObject1 = localObject5;
                                localObject2 = localObject3;
                                localObject3 = localObject4;
                                localObject4 = localObject12;
                                localObject5 = localObject6;
                                localObject6 = localObject11;
                                break label11763;
                                localCard.switch_star = localByteBuffer.getShort();
                                i5 = n;
                                localObject7 = localObject6;
                                i4 = k;
                                localObject6 = localObject1;
                                localObject12 = paramObject;
                                localObject11 = paramFromServiceMsg;
                                n = i1;
                                i1 = i5;
                                k = m;
                                m = i4;
                                paramFromServiceMsg = (FromServiceMsg)localObject7;
                                paramObject = localObject2;
                                localObject1 = localObject5;
                                localObject2 = localObject3;
                                localObject3 = localObject4;
                                localObject4 = localObject12;
                                localObject5 = localObject6;
                                localObject6 = localObject11;
                                break label11763;
                                localCard.switch_joined_troop = localByteBuffer.getShort();
                                i5 = n;
                                localObject7 = localObject6;
                                i4 = k;
                                localObject6 = localObject1;
                                localObject12 = paramObject;
                                localObject11 = paramFromServiceMsg;
                                n = i1;
                                i1 = i5;
                                k = m;
                                m = i4;
                                paramFromServiceMsg = (FromServiceMsg)localObject7;
                                paramObject = localObject2;
                                localObject1 = localObject5;
                                localObject2 = localObject3;
                                localObject3 = localObject4;
                                localObject4 = localObject12;
                                localObject5 = localObject6;
                                localObject6 = localObject11;
                                break label11763;
                                localCard.switch_now = localByteBuffer.getShort();
                                i5 = n;
                                localObject7 = localObject6;
                                i4 = k;
                                localObject6 = localObject1;
                                localObject12 = paramObject;
                                localObject11 = paramFromServiceMsg;
                                n = i1;
                                i1 = i5;
                                k = m;
                                m = i4;
                                paramFromServiceMsg = (FromServiceMsg)localObject7;
                                paramObject = localObject2;
                                localObject1 = localObject5;
                                localObject2 = localObject3;
                                localObject3 = localObject4;
                                localObject4 = localObject12;
                                localObject5 = localObject6;
                                localObject6 = localObject11;
                                break label11763;
                                localCard.switch_ktv = localByteBuffer.getShort();
                                i5 = n;
                                localObject7 = localObject6;
                                i4 = k;
                                localObject6 = localObject1;
                                localObject12 = paramObject;
                                localObject11 = paramFromServiceMsg;
                                n = i1;
                                i1 = i5;
                                k = m;
                                m = i4;
                                paramFromServiceMsg = (FromServiceMsg)localObject7;
                                paramObject = localObject2;
                                localObject1 = localObject5;
                                localObject2 = localObject3;
                                localObject3 = localObject4;
                                localObject4 = localObject12;
                                localObject5 = localObject6;
                                localObject6 = localObject11;
                                break label11763;
                                localCard.switch_eat = localByteBuffer.getShort();
                                i5 = n;
                                localObject7 = localObject6;
                                i4 = k;
                                localObject6 = localObject1;
                                localObject12 = paramObject;
                                localObject11 = paramFromServiceMsg;
                                n = i1;
                                i1 = i5;
                                k = m;
                                m = i4;
                                paramFromServiceMsg = (FromServiceMsg)localObject7;
                                paramObject = localObject2;
                                localObject1 = localObject5;
                                localObject2 = localObject3;
                                localObject3 = localObject4;
                                localObject4 = localObject12;
                                localObject5 = localObject6;
                                localObject6 = localObject11;
                                break label11763;
                                localCard.switch_reader = localByteBuffer.getShort();
                                i5 = n;
                                localObject7 = localObject6;
                                i4 = k;
                                localObject6 = localObject1;
                                localObject12 = paramObject;
                                localObject11 = paramFromServiceMsg;
                                n = i1;
                                i1 = i5;
                                k = m;
                                m = i4;
                                paramFromServiceMsg = (FromServiceMsg)localObject7;
                                paramObject = localObject2;
                                localObject1 = localObject5;
                                localObject2 = localObject3;
                                localObject3 = localObject4;
                                localObject4 = localObject12;
                                localObject5 = localObject6;
                                localObject6 = localObject11;
                                break label11763;
                                localCard.switch_radio = localByteBuffer.getShort();
                                i5 = n;
                                localObject7 = localObject6;
                                i4 = k;
                                localObject6 = localObject1;
                                localObject12 = paramObject;
                                localObject11 = paramFromServiceMsg;
                                n = i1;
                                i1 = i5;
                                k = m;
                                m = i4;
                                paramFromServiceMsg = (FromServiceMsg)localObject7;
                                paramObject = localObject2;
                                localObject1 = localObject5;
                                localObject2 = localObject3;
                                localObject3 = localObject4;
                                localObject4 = localObject12;
                                localObject5 = localObject6;
                                localObject6 = localObject11;
                                break label11763;
                                localCard.switch_comic = localByteBuffer.getShort();
                                i5 = n;
                                localObject7 = localObject6;
                                i4 = k;
                                localObject6 = localObject1;
                                localObject12 = paramObject;
                                localObject11 = paramFromServiceMsg;
                                n = i1;
                                i1 = i5;
                                k = m;
                                m = i4;
                                paramFromServiceMsg = (FromServiceMsg)localObject7;
                                paramObject = localObject2;
                                localObject1 = localObject5;
                                localObject2 = localObject3;
                                localObject3 = localObject4;
                                localObject4 = localObject12;
                                localObject5 = localObject6;
                                localObject6 = localObject11;
                                break label11763;
                                localCard.switch_education = localByteBuffer.getShort();
                                if (!QLog.isColorLevel()) {
                                  break label11691;
                                }
                                QLog.i("CardHandler", 4, String.format("FIELD_EDUCATION_SWITCH %s", new Object[] { Short.valueOf(localCard.switch_education) }));
                                i5 = n;
                                localObject7 = localObject6;
                                i4 = k;
                                localObject6 = localObject1;
                                localObject12 = paramObject;
                                localObject11 = paramFromServiceMsg;
                                n = i1;
                                i1 = i5;
                                k = m;
                                m = i4;
                                paramFromServiceMsg = (FromServiceMsg)localObject7;
                                paramObject = localObject2;
                                localObject1 = localObject5;
                                localObject2 = localObject3;
                                localObject3 = localObject4;
                                localObject4 = localObject12;
                                localObject5 = localObject6;
                                localObject6 = localObject11;
                                break label11763;
                                localCard.switch_using_tim = localByteBuffer.getShort();
                                if (!QLog.isColorLevel()) {
                                  break label11691;
                                }
                                QLog.i("CardHandler", 4, String.format("FIELD_USING_TIM_SWITCH %s", new Object[] { Short.valueOf(localCard.switch_using_tim) }));
                                i5 = n;
                                localObject7 = localObject6;
                                i4 = k;
                                localObject6 = localObject1;
                                localObject12 = paramObject;
                                localObject11 = paramFromServiceMsg;
                                n = i1;
                                i1 = i5;
                                k = m;
                                m = i4;
                                paramFromServiceMsg = (FromServiceMsg)localObject7;
                                paramObject = localObject2;
                                localObject1 = localObject5;
                                localObject2 = localObject3;
                                localObject3 = localObject4;
                                localObject4 = localObject12;
                                localObject5 = localObject6;
                                localObject6 = localObject11;
                                break label11763;
                                localCard.switch_weishi = localByteBuffer.getShort();
                                if (!QLog.isColorLevel()) {
                                  break label11691;
                                }
                                QLog.i("CardHandler", 2, String.format("FIELD_WEISHI_SWITCH %s", new Object[] { Short.valueOf(localCard.switch_weishi) }));
                                i5 = n;
                                localObject7 = localObject6;
                                i4 = k;
                                localObject6 = localObject1;
                                localObject12 = paramObject;
                                localObject11 = paramFromServiceMsg;
                                n = i1;
                                i1 = i5;
                                k = m;
                                m = i4;
                                paramFromServiceMsg = (FromServiceMsg)localObject7;
                                paramObject = localObject2;
                                localObject1 = localObject5;
                                localObject2 = localObject3;
                                localObject3 = localObject4;
                                localObject4 = localObject12;
                                localObject5 = localObject6;
                                localObject6 = localObject11;
                                break label11763;
                                i4 = localByteBuffer.getShort();
                                QLog.i("smartdevice", 1, "got device bind flag:" + i4);
                                try
                                {
                                  ((SmartDeviceProxyMgr)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).a(i4);
                                  i5 = n;
                                  localObject7 = localObject6;
                                  i4 = k;
                                  localObject6 = localObject1;
                                  localObject12 = paramObject;
                                  localObject11 = paramFromServiceMsg;
                                  n = i1;
                                  i1 = i5;
                                  k = m;
                                  m = i4;
                                  paramFromServiceMsg = (FromServiceMsg)localObject7;
                                  paramObject = localObject2;
                                  localObject1 = localObject5;
                                  localObject2 = localObject3;
                                  localObject3 = localObject4;
                                  localObject4 = localObject12;
                                  localObject5 = localObject6;
                                  localObject6 = localObject11;
                                }
                                catch (Error localError)
                                {
                                  i5 = n;
                                  Object localObject8 = localObject6;
                                  i4 = k;
                                  localObject6 = localObject1;
                                  localObject12 = paramObject;
                                  localObject11 = paramFromServiceMsg;
                                  n = i1;
                                  i1 = i5;
                                  k = m;
                                  m = i4;
                                  paramFromServiceMsg = localObject8;
                                  paramObject = localObject2;
                                  localObject1 = localObject5;
                                  localObject2 = localObject3;
                                  localObject3 = localObject4;
                                  localObject4 = localObject12;
                                  localObject5 = localObject6;
                                  localObject6 = localObject11;
                                }
                                catch (Exception localException1)
                                {
                                  i5 = n;
                                  localObject9 = localObject6;
                                  i4 = k;
                                  localObject6 = localObject1;
                                  localObject12 = paramObject;
                                  localObject11 = paramFromServiceMsg;
                                  n = i1;
                                  i1 = i5;
                                  k = m;
                                  m = i4;
                                  paramFromServiceMsg = (FromServiceMsg)localObject9;
                                  paramObject = localObject2;
                                  localObject1 = localObject5;
                                  localObject2 = localObject3;
                                  localObject3 = localObject4;
                                  localObject4 = localObject12;
                                  localObject5 = localObject6;
                                  localObject6 = localObject11;
                                }
                                i4 = localByteBuffer.getShort();
                                if (QLog.isColorLevel()) {
                                  QLog.i("CardHandler", 2, "handleGetDetalInfo server has antilost bind symbol is :" + i4);
                                }
                                ((SmartDeviceProxyMgr)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(51)).b(i4);
                                i5 = n;
                                localObject9 = localObject6;
                                i4 = k;
                                localObject6 = localObject1;
                                localObject12 = paramObject;
                                localObject11 = paramFromServiceMsg;
                                n = i1;
                                i1 = i5;
                                k = m;
                                m = i4;
                                paramFromServiceMsg = (FromServiceMsg)localObject9;
                                paramObject = localObject2;
                                localObject1 = localObject5;
                                localObject2 = localObject3;
                                localObject3 = localObject4;
                                localObject4 = localObject12;
                                localObject5 = localObject6;
                                localObject6 = localObject11;
                                break label11763;
                                i4 = localByteBuffer.getShort();
                                localObject9 = (MessageRoamManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(91);
                                if (localObject9 != null) {
                                  ((MessageRoamManager)localObject9).c(i4);
                                }
                                if (!QLog.isColorLevel()) {
                                  break label11691;
                                }
                                QLog.i("CardHandler", 2, "handleGetDetalInfo authMode is :" + i4);
                                i5 = n;
                                localObject9 = localObject6;
                                i4 = k;
                                localObject6 = localObject1;
                                localObject12 = paramObject;
                                localObject11 = paramFromServiceMsg;
                                n = i1;
                                i1 = i5;
                                k = m;
                                m = i4;
                                paramFromServiceMsg = (FromServiceMsg)localObject9;
                                paramObject = localObject2;
                                localObject1 = localObject5;
                                localObject2 = localObject3;
                                localObject3 = localObject4;
                                localObject4 = localObject12;
                                localObject5 = localObject6;
                                localObject6 = localObject11;
                                break label11763;
                                s = localByteBuffer.getShort();
                                if (QLog.isColorLevel()) {
                                  QLog.i("LocalRedTouchManager", 2, "handleGetDetalInfo unreadFlag is :" + s);
                                }
                                localObject9 = (LocalRedTouchManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(159);
                                if (localObject9 == null) {
                                  break label11691;
                                }
                                ((LocalRedTouchManager)localObject9).a(s);
                                i5 = n;
                                localObject9 = localObject6;
                                i4 = k;
                                localObject6 = localObject1;
                                localObject12 = paramObject;
                                localObject11 = paramFromServiceMsg;
                                n = i1;
                                i1 = i5;
                                k = m;
                                m = i4;
                                paramFromServiceMsg = (FromServiceMsg)localObject9;
                                paramObject = localObject2;
                                localObject1 = localObject5;
                                localObject2 = localObject3;
                                localObject3 = localObject4;
                                localObject4 = localObject12;
                                localObject5 = localObject6;
                                localObject6 = localObject11;
                                break label11763;
                                i4 = localByteBuffer.getInt();
                                if (!String.valueOf(localLong).equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
                                  break label11691;
                                }
                                ((SVIPHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(i4, false);
                                i5 = n;
                                localObject9 = localObject6;
                                i4 = k;
                                localObject6 = localObject1;
                                localObject12 = paramObject;
                                localObject11 = paramFromServiceMsg;
                                n = i1;
                                i1 = i5;
                                k = m;
                                m = i4;
                                paramFromServiceMsg = (FromServiceMsg)localObject9;
                                paramObject = localObject2;
                                localObject1 = localObject5;
                                localObject2 = localObject3;
                                localObject3 = localObject4;
                                localObject4 = localObject12;
                                localObject5 = localObject6;
                                localObject6 = localObject11;
                                break label11763;
                                localObject9 = new byte[i];
                                localByteBuffer.get((byte[])localObject9);
                                localObject9 = new String((byte[])localObject9);
                                if ((TextUtils.isEmpty((CharSequence)localObject9)) || (!String.valueOf(localLong).equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
                                  break label11691;
                                }
                                localFriendsManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (String)localObject9, (byte)-1);
                                if (!QLog.isColorLevel()) {
                                  break label11691;
                                }
                                QLog.d("CardHandler", 2, "handleGetDetalInfo saveDateNickByUin: " + (String)localObject9);
                                i5 = n;
                                localObject9 = localObject6;
                                i4 = k;
                                localObject6 = localObject1;
                                localObject12 = paramObject;
                                localObject11 = paramFromServiceMsg;
                                n = i1;
                                i1 = i5;
                                k = m;
                                m = i4;
                                paramFromServiceMsg = (FromServiceMsg)localObject9;
                                paramObject = localObject2;
                                localObject1 = localObject5;
                                localObject2 = localObject3;
                                localObject3 = localObject4;
                                localObject4 = localObject12;
                                localObject5 = localObject6;
                                localObject6 = localObject11;
                                break label11763;
                                i4 = localByteBuffer.getShort();
                                if (QLog.isColorLevel()) {
                                  QLog.i("CardHandler", 2, "handleGetDetalInfo nearbyAuthFlag:" + i4);
                                }
                                localObject9 = (HotChatManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59);
                                localObject9 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface;
                                if (i4 <= 0) {
                                  break label11938;
                                }
                                bool2 = true;
                                HotChatManager.a((AppInterface)localObject9, bool2);
                                i5 = n;
                                localObject9 = localObject6;
                                i4 = k;
                                localObject6 = localObject1;
                                localObject12 = paramObject;
                                localObject11 = paramFromServiceMsg;
                                n = i1;
                                i1 = i5;
                                k = m;
                                m = i4;
                                paramFromServiceMsg = (FromServiceMsg)localObject9;
                                paramObject = localObject2;
                                localObject1 = localObject5;
                                localObject2 = localObject3;
                                localObject3 = localObject4;
                                localObject4 = localObject12;
                                localObject5 = localObject6;
                                localObject6 = localObject11;
                                break label11763;
                                i4 = localByteBuffer.getShort();
                                if (i4 != localApolloBaseInfo.apolloVipFlag)
                                {
                                  localApolloBaseInfo.apolloVipFlag = i4;
                                  j = 1;
                                  QLog.i("ApolloManager", 1, "handleGetDetalInfo apollo vip flag: " + i4);
                                  i4 = n;
                                  localObject9 = localObject6;
                                  localObject11 = localObject5;
                                  localObject5 = paramObject;
                                  n = i1;
                                  localObject6 = localObject1;
                                  i5 = k;
                                  localObject12 = paramFromServiceMsg;
                                  i1 = i4;
                                  k = m;
                                  m = i5;
                                  paramFromServiceMsg = (FromServiceMsg)localObject9;
                                  paramObject = localObject2;
                                  localObject1 = localObject11;
                                  localObject2 = localObject3;
                                  localObject3 = localObject4;
                                  localObject4 = localObject5;
                                  localObject5 = localObject6;
                                  localObject6 = localObject12;
                                  break label11763;
                                  i4 = localByteBuffer.getShort();
                                  if (i4 != localApolloBaseInfo.apolloVipLevel)
                                  {
                                    localApolloBaseInfo.apolloVipLevel = i4;
                                    j = 1;
                                    QLog.i("ApolloManager", 1, "handleGetDetalInfo apollo vip level: " + i4);
                                    i4 = n;
                                    localObject9 = localObject6;
                                    localObject11 = localObject5;
                                    localObject5 = paramObject;
                                    n = i1;
                                    localObject6 = localObject1;
                                    i5 = k;
                                    localObject12 = paramFromServiceMsg;
                                    i1 = i4;
                                    k = m;
                                    m = i5;
                                    paramFromServiceMsg = (FromServiceMsg)localObject9;
                                    paramObject = localObject2;
                                    localObject1 = localObject11;
                                    localObject2 = localObject3;
                                    localObject3 = localObject4;
                                    localObject4 = localObject5;
                                    localObject5 = localObject6;
                                    localObject6 = localObject12;
                                    break label11763;
                                    i5 = localByteBuffer.getShort();
                                    if (i5 != localApolloBaseInfo.apolloStatus)
                                    {
                                      localApolloBaseInfo.apolloStatus = i5;
                                      i4 = 1;
                                      localObject9 = (VasExtensionHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(71);
                                      j = i4;
                                      if (localObject9 != null)
                                      {
                                        ((VasExtensionHandler)localObject9).a(3, true, new com.tencent.util.Pair(localApolloBaseInfo.uin, Integer.valueOf(i5)));
                                        j = i4;
                                      }
                                    }
                                    QLog.i("ApolloManager", 1, "handleGetDetalInfo apollo status flag: " + i5);
                                    i4 = n;
                                    localObject9 = localObject6;
                                    localObject11 = localObject5;
                                    localObject5 = paramObject;
                                    n = i1;
                                    localObject6 = localObject1;
                                    i5 = k;
                                    localObject12 = paramFromServiceMsg;
                                    i1 = i4;
                                    k = m;
                                    m = i5;
                                    paramFromServiceMsg = (FromServiceMsg)localObject9;
                                    paramObject = localObject2;
                                    localObject1 = localObject11;
                                    localObject2 = localObject3;
                                    localObject3 = localObject4;
                                    localObject4 = localObject5;
                                    localObject5 = localObject6;
                                    localObject6 = localObject12;
                                    break label11763;
                                    long l1 = localByteBuffer.getInt();
                                    if (l1 != localApolloBaseInfo.apolloServerTS)
                                    {
                                      localApolloBaseInfo.apolloServerTS = l1;
                                      j = 1;
                                      QLog.i("ApolloManager", 1, "handleGetDetalInfo apollo svr TS: " + l1 + ",local TS: " + localApolloBaseInfo.apolloServerTS);
                                      i4 = n;
                                      localObject9 = localObject6;
                                      localObject11 = localObject5;
                                      localObject5 = paramObject;
                                      n = i1;
                                      localObject6 = localObject1;
                                      i5 = k;
                                      localObject12 = paramFromServiceMsg;
                                      i1 = i4;
                                      k = m;
                                      m = i5;
                                      paramFromServiceMsg = (FromServiceMsg)localObject9;
                                      paramObject = localObject2;
                                      localObject1 = localObject11;
                                      localObject2 = localObject3;
                                      localObject3 = localObject4;
                                      localObject4 = localObject5;
                                      localObject5 = localObject6;
                                      localObject6 = localObject12;
                                      break label11763;
                                      l1 = localByteBuffer.getInt();
                                      long l2 = NetConnInfoCenter.getServerTime();
                                      if ((l1 < l2) && (localApolloBaseInfo.apolloSignValidTS != l1))
                                      {
                                        localApolloBaseInfo.apolloLocalSignTs = localApolloBaseInfo.apolloSignValidTS;
                                        localApolloBaseInfo.apolloSignValidTS = l1;
                                        localApolloBaseInfo.apolloSignStr = "";
                                        j = 1;
                                        QLog.i("ApolloManager", 1, "handleGetDetalInfo apollo Sign TS: " + l1 + ", currTS: " + l2);
                                        i4 = n;
                                        localObject9 = localObject6;
                                        localObject11 = localObject5;
                                        localObject5 = paramObject;
                                        n = i1;
                                        localObject6 = localObject1;
                                        i5 = k;
                                        localObject12 = paramFromServiceMsg;
                                        i1 = i4;
                                        k = m;
                                        m = i5;
                                        paramFromServiceMsg = (FromServiceMsg)localObject9;
                                        paramObject = localObject2;
                                        localObject1 = localObject11;
                                        localObject2 = localObject3;
                                        localObject3 = localObject4;
                                        localObject4 = localObject5;
                                        localObject5 = localObject6;
                                        localObject6 = localObject12;
                                        break label11763;
                                        i4 = localByteBuffer.getShort();
                                        if (i4 != ApolloManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface)) {
                                          localApolloManager.b(i4);
                                        }
                                        QLog.i("ApolloManager", 1, "handleGetDetalInfo apollo white list: " + i4);
                                        i5 = n;
                                        localObject9 = localObject6;
                                        i4 = k;
                                        localObject6 = localObject1;
                                        localObject12 = paramObject;
                                        localObject11 = paramFromServiceMsg;
                                        n = i1;
                                        i1 = i5;
                                        k = m;
                                        m = i4;
                                        paramFromServiceMsg = (FromServiceMsg)localObject9;
                                        paramObject = localObject2;
                                        localObject1 = localObject5;
                                        localObject2 = localObject3;
                                        localObject3 = localObject4;
                                        localObject4 = localObject12;
                                        localObject5 = localObject6;
                                        localObject6 = localObject11;
                                        break label11763;
                                        i4 = localByteBuffer.getInt();
                                        if ((this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface != null) && (String.valueOf(localLong).equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c()))) {
                                          ApolloManager.c(i4);
                                        }
                                        if ((localApolloManager != null) && (localApolloBaseInfo.apolloAISwitch != i4))
                                        {
                                          localApolloBaseInfo.apolloAISwitch = i4;
                                          j = 1;
                                          localApolloManager.d(i4);
                                          QLog.i("ApolloManager", 1, "handleGetDetalInfo apollo AIFlag: " + i4);
                                          i4 = n;
                                          localObject9 = localObject6;
                                          localObject11 = localObject5;
                                          localObject5 = paramObject;
                                          n = i1;
                                          localObject6 = localObject1;
                                          i5 = k;
                                          localObject12 = paramFromServiceMsg;
                                          i1 = i4;
                                          k = m;
                                          m = i5;
                                          paramFromServiceMsg = (FromServiceMsg)localObject9;
                                          paramObject = localObject2;
                                          localObject1 = localObject11;
                                          localObject2 = localObject3;
                                          localObject3 = localObject4;
                                          localObject4 = localObject5;
                                          localObject5 = localObject6;
                                          localObject6 = localObject12;
                                          break label11763;
                                          bool3 = Util.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
                                          if (localByteBuffer.getShort() == 0) {
                                            break label11944;
                                          }
                                          bool2 = true;
                                          localCard.medalSwitchDisable = bool2;
                                          localObject9 = BaseApplicationImpl.getApplication().getSharedPreferences("medal_wall_" + localLong, 4).edit();
                                          ((SharedPreferences.Editor)localObject9).putBoolean("medal_switch_disable", localCard.medalSwitchDisable);
                                          ((SharedPreferences.Editor)localObject9).commit();
                                          bool2 = Util.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
                                          if (bool3 == bool2) {
                                            break label11691;
                                          }
                                          Util.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, bool2);
                                          i5 = n;
                                          localObject9 = localObject6;
                                          i4 = k;
                                          localObject6 = localObject1;
                                          localObject12 = paramObject;
                                          localObject11 = paramFromServiceMsg;
                                          n = i1;
                                          i1 = i5;
                                          k = m;
                                          m = i4;
                                          paramFromServiceMsg = (FromServiceMsg)localObject9;
                                          paramObject = localObject2;
                                          localObject1 = localObject5;
                                          localObject2 = localObject3;
                                          localObject3 = localObject4;
                                          localObject4 = localObject12;
                                          localObject5 = localObject6;
                                          localObject6 = localObject11;
                                          break label11763;
                                          if (localByteBuffer.getShort() != 0) {
                                            break label11950;
                                          }
                                          bool2 = true;
                                          SubAccountControll.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, bool2);
                                          i5 = n;
                                          localObject9 = localObject6;
                                          i4 = k;
                                          localObject6 = localObject1;
                                          localObject12 = paramObject;
                                          localObject11 = paramFromServiceMsg;
                                          n = i1;
                                          i1 = i5;
                                          k = m;
                                          m = i4;
                                          paramFromServiceMsg = (FromServiceMsg)localObject9;
                                          paramObject = localObject2;
                                          localObject1 = localObject5;
                                          localObject2 = localObject3;
                                          localObject3 = localObject4;
                                          localObject4 = localObject12;
                                          localObject5 = localObject6;
                                          localObject6 = localObject11;
                                          break label11763;
                                          i5 = localByteBuffer.getShort();
                                          if (QLog.isColorLevel())
                                          {
                                            QLog.i("CardHandler", 2, "handleGetDetalInfo qq18Switch = " + i5);
                                            i1 = n;
                                            i4 = k;
                                            localObject11 = localObject6;
                                            localObject6 = localObject1;
                                            localObject9 = paramFromServiceMsg;
                                            localObject12 = paramObject;
                                            n = i5;
                                            k = m;
                                            m = i4;
                                            paramFromServiceMsg = (FromServiceMsg)localObject11;
                                            paramObject = localObject2;
                                            localObject1 = localObject5;
                                            localObject2 = localObject3;
                                            localObject3 = localObject4;
                                            localObject4 = localObject12;
                                            localObject5 = localObject6;
                                            localObject6 = localObject9;
                                            break label11763;
                                            i4 = localByteBuffer.getShort();
                                            if (QLog.isColorLevel())
                                            {
                                              QLog.d("CardHandler", 2, "handleGetDetalInfo systemId = " + i4);
                                              i2 = n;
                                              localObject9 = localObject6;
                                              n = i1;
                                              localObject6 = localObject5;
                                              i5 = k;
                                              localObject5 = localObject1;
                                              localObject11 = paramObject;
                                              localObject12 = paramFromServiceMsg;
                                              i1 = i2;
                                              i2 = i4;
                                              k = m;
                                              m = i5;
                                              paramFromServiceMsg = (FromServiceMsg)localObject9;
                                              paramObject = localObject2;
                                              localObject1 = localObject6;
                                              localObject2 = localObject3;
                                              localObject3 = localObject4;
                                              localObject4 = localObject11;
                                              localObject6 = localObject12;
                                              break label11763;
                                              i4 = localByteBuffer.getShort();
                                              if (!QLog.isColorLevel()) {
                                                break label11956;
                                              }
                                              QLog.d("CardHandler", 2, "handleGetDetalInfo GET_CAMPUS_INFO isUpdate=" + i4);
                                              break label11956;
                                              localObject11 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_ComTencentMobileqqCampuscircleCampusLebaEntryChecker;
                                              localObject9 = localObject11;
                                              if (localObject11 == null)
                                              {
                                                if (QLog.isColorLevel()) {
                                                  QLog.i("CardHandler", 2, "handleGetDetalInfo GET_CAMPUS_INFO checker is null");
                                                }
                                                localObject9 = new CampusLebaEntryChecker(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
                                              }
                                              bool3 = ((CampusLebaEntryChecker)localObject9).jdField_a_of_type_Boolean;
                                              ((CampusLebaEntryChecker)localObject9).a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, bool2, false);
                                              a(92, true, new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
                                              i5 = n;
                                              localObject9 = localObject6;
                                              i4 = k;
                                              localObject6 = localObject1;
                                              localObject12 = paramObject;
                                              localObject11 = paramFromServiceMsg;
                                              n = i1;
                                              i1 = i5;
                                              k = m;
                                              m = i4;
                                              paramFromServiceMsg = (FromServiceMsg)localObject9;
                                              paramObject = localObject2;
                                              localObject1 = localObject5;
                                              localObject2 = localObject3;
                                              localObject3 = localObject4;
                                              localObject4 = localObject12;
                                              localObject5 = localObject6;
                                              localObject6 = localObject11;
                                              break label11763;
                                              if (i > 0)
                                              {
                                                localObject9 = new byte[i];
                                                localByteBuffer.get((byte[])localObject9);
                                                localCard.strCampusSchool = new String((byte[])localObject9);
                                              }
                                              while (QLog.isDevelopLevel())
                                              {
                                                QLog.d("CampusCircle", 4, String.format(Locale.getDefault(), "handleGetDetalInfo length: %d, strCampusSchool: %s", new Object[] { Short.valueOf(i), localCard.strCampusSchool }));
                                                i5 = n;
                                                localObject9 = localObject6;
                                                i4 = k;
                                                localObject6 = localObject1;
                                                localObject12 = paramObject;
                                                localObject11 = paramFromServiceMsg;
                                                n = i1;
                                                i1 = i5;
                                                k = m;
                                                m = i4;
                                                paramFromServiceMsg = (FromServiceMsg)localObject9;
                                                paramObject = localObject2;
                                                localObject1 = localObject5;
                                                localObject2 = localObject3;
                                                localObject3 = localObject4;
                                                localObject4 = localObject12;
                                                localObject5 = localObject6;
                                                localObject6 = localObject11;
                                                break label11763;
                                                localCard.strCampusSchool = "";
                                                continue;
                                                localCard.lCampusSchoolID = localByteBuffer.getInt();
                                                if (QLog.isDevelopLevel())
                                                {
                                                  QLog.d("CampusCircle", 4, String.format(Locale.getDefault(), "handleGetDetalInfo length:%d, lCampusSchoolID: %d", new Object[] { Short.valueOf(i), Long.valueOf(localCard.lCampusSchoolID) }));
                                                  i5 = n;
                                                  localObject9 = localObject6;
                                                  i4 = k;
                                                  localObject6 = localObject1;
                                                  localObject12 = paramObject;
                                                  localObject11 = paramFromServiceMsg;
                                                  n = i1;
                                                  i1 = i5;
                                                  k = m;
                                                  m = i4;
                                                  paramFromServiceMsg = (FromServiceMsg)localObject9;
                                                  paramObject = localObject2;
                                                  localObject1 = localObject5;
                                                  localObject2 = localObject3;
                                                  localObject3 = localObject4;
                                                  localObject4 = localObject12;
                                                  localObject5 = localObject6;
                                                  localObject6 = localObject11;
                                                  break label11763;
                                                  if (i > 0)
                                                  {
                                                    localObject9 = new byte[i];
                                                    localByteBuffer.get((byte[])localObject9);
                                                    localCard.strCampusName = new String((byte[])localObject9);
                                                  }
                                                  while (QLog.isDevelopLevel())
                                                  {
                                                    QLog.d("CampusCircle", 4, String.format(Locale.getDefault(), "handleGetDetalInfo length:%d, strCampusName: %s", new Object[] { Short.valueOf(i), localCard.strCampusName }));
                                                    i5 = n;
                                                    localObject9 = localObject6;
                                                    i4 = k;
                                                    localObject6 = localObject1;
                                                    localObject12 = paramObject;
                                                    localObject11 = paramFromServiceMsg;
                                                    n = i1;
                                                    i1 = i5;
                                                    k = m;
                                                    m = i4;
                                                    paramFromServiceMsg = (FromServiceMsg)localObject9;
                                                    paramObject = localObject2;
                                                    localObject1 = localObject5;
                                                    localObject2 = localObject3;
                                                    localObject3 = localObject4;
                                                    localObject4 = localObject12;
                                                    localObject5 = localObject6;
                                                    localObject6 = localObject11;
                                                    break label11763;
                                                    localCard.strCampusName = "";
                                                    continue;
                                                    localCard.lCampusLastModifySchoolTime = localByteBuffer.getInt();
                                                    if (QLog.isDevelopLevel())
                                                    {
                                                      QLog.d("CampusCircle", 4, String.format(Locale.getDefault(), "handleGetDetalInfo length:%d, lCampusLastModifySchoolTime: %d", new Object[] { Short.valueOf(i), Long.valueOf(localCard.lCampusLastModifySchoolTime) }));
                                                      i5 = n;
                                                      localObject9 = localObject6;
                                                      i4 = k;
                                                      localObject6 = localObject1;
                                                      localObject12 = paramObject;
                                                      localObject11 = paramFromServiceMsg;
                                                      n = i1;
                                                      i1 = i5;
                                                      k = m;
                                                      m = i4;
                                                      paramFromServiceMsg = (FromServiceMsg)localObject9;
                                                      paramObject = localObject2;
                                                      localObject1 = localObject5;
                                                      localObject2 = localObject3;
                                                      localObject3 = localObject4;
                                                      localObject4 = localObject12;
                                                      localObject5 = localObject6;
                                                      localObject6 = localObject11;
                                                      break label11763;
                                                      localCard.nCampusEnrolYear = localByteBuffer.getShort();
                                                      if (QLog.isDevelopLevel())
                                                      {
                                                        QLog.d("CampusCircle", 4, String.format(Locale.getDefault(), "handleGetDetalInfo length:%d, nCampusEnrolYear: %d", new Object[] { Short.valueOf(i), Integer.valueOf(localCard.nCampusEnrolYear) }));
                                                        i5 = n;
                                                        localObject9 = localObject6;
                                                        i4 = k;
                                                        localObject6 = localObject1;
                                                        localObject12 = paramObject;
                                                        localObject11 = paramFromServiceMsg;
                                                        n = i1;
                                                        i1 = i5;
                                                        k = m;
                                                        m = i4;
                                                        paramFromServiceMsg = (FromServiceMsg)localObject9;
                                                        paramObject = localObject2;
                                                        localObject1 = localObject5;
                                                        localObject2 = localObject3;
                                                        localObject3 = localObject4;
                                                        localObject4 = localObject12;
                                                        localObject5 = localObject6;
                                                        localObject6 = localObject11;
                                                        break label11763;
                                                        if (i > 0)
                                                        {
                                                          localObject9 = new byte[i];
                                                          localByteBuffer.get((byte[])localObject9);
                                                          localCard.strCampusCollege = new String((byte[])localObject9);
                                                        }
                                                        while (QLog.isDevelopLevel())
                                                        {
                                                          QLog.d("CampusCircle", 4, String.format(Locale.getDefault(), "handleGetDetalInfo length:%d, strCampusCollege: %s", new Object[] { Short.valueOf(i), localCard.strCampusCollege }));
                                                          i5 = n;
                                                          localObject9 = localObject6;
                                                          i4 = k;
                                                          localObject6 = localObject1;
                                                          localObject12 = paramObject;
                                                          localObject11 = paramFromServiceMsg;
                                                          n = i1;
                                                          i1 = i5;
                                                          k = m;
                                                          m = i4;
                                                          paramFromServiceMsg = (FromServiceMsg)localObject9;
                                                          paramObject = localObject2;
                                                          localObject1 = localObject5;
                                                          localObject2 = localObject3;
                                                          localObject3 = localObject4;
                                                          localObject4 = localObject12;
                                                          localObject5 = localObject6;
                                                          localObject6 = localObject11;
                                                          break label11763;
                                                          localCard.strCampusCollege = "";
                                                          continue;
                                                          if (i > 0)
                                                          {
                                                            localObject9 = new byte[i];
                                                            localByteBuffer.get((byte[])localObject9);
                                                            localCard.strCampusClass = new String((byte[])localObject9);
                                                          }
                                                          while (QLog.isDevelopLevel())
                                                          {
                                                            QLog.d("CampusCircle", 4, String.format(Locale.getDefault(), "handleGetDetalInfo length:%d, strCampusClass: %s", new Object[] { Short.valueOf(i), localCard.strCampusClass }));
                                                            i5 = n;
                                                            localObject9 = localObject6;
                                                            i4 = k;
                                                            localObject6 = localObject1;
                                                            localObject12 = paramObject;
                                                            localObject11 = paramFromServiceMsg;
                                                            n = i1;
                                                            i1 = i5;
                                                            k = m;
                                                            m = i4;
                                                            paramFromServiceMsg = (FromServiceMsg)localObject9;
                                                            paramObject = localObject2;
                                                            localObject1 = localObject5;
                                                            localObject2 = localObject3;
                                                            localObject3 = localObject4;
                                                            localObject4 = localObject12;
                                                            localObject5 = localObject6;
                                                            localObject6 = localObject11;
                                                            break label11763;
                                                            localCard.strCampusClass = "";
                                                            continue;
                                                            s = -1;
                                                            if (i == 2)
                                                            {
                                                              s = localByteBuffer.getShort();
                                                              localObject9 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface;
                                                              if (s != 0) {
                                                                break label11974;
                                                              }
                                                              bool2 = true;
                                                              ((QQAppInterface)localObject9).d(bool2);
                                                            }
                                                            for (;;)
                                                            {
                                                              if (QLog.isColorLevel())
                                                              {
                                                                QLog.d("CommonSwitchTag", 2, String.format(Locale.getDefault(), "MAY_KNOW_IN_CONTACT_SWITCH_ID switch: %d", new Object[] { Short.valueOf(s) }));
                                                                i5 = n;
                                                                localObject9 = localObject6;
                                                                i4 = k;
                                                                localObject6 = localObject1;
                                                                localObject12 = paramObject;
                                                                localObject11 = paramFromServiceMsg;
                                                                n = i1;
                                                                i1 = i5;
                                                                k = m;
                                                                m = i4;
                                                                paramFromServiceMsg = (FromServiceMsg)localObject9;
                                                                paramObject = localObject2;
                                                                localObject1 = localObject5;
                                                                localObject2 = localObject3;
                                                                localObject3 = localObject4;
                                                                localObject4 = localObject12;
                                                                localObject5 = localObject6;
                                                                localObject6 = localObject11;
                                                                break label11763;
                                                                localByteBuffer.get(new byte[i]);
                                                                continue;
                                                                i4 = localByteBuffer.getShort();
                                                                localObject9 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().jdField_a_of_type_ComTencentMobileqqWholepeopleWholePeopleLebaEntryChecker;
                                                                if (localObject9 == null)
                                                                {
                                                                  if (QLog.isColorLevel()) {
                                                                    QLog.i("WholePeopleLebaEntryChecker", 2, "handleGetDetalInfo GET_WHOLE_PEOPLE_VOTE cheker is null");
                                                                  }
                                                                  localObject9 = new WholePeopleLebaEntryChecker(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
                                                                  break;
                                                                  bool3 = ((WholePeopleLebaEntryChecker)localObject9).jdField_a_of_type_Boolean;
                                                                  if (bool2 == bool3) {
                                                                    break label11691;
                                                                  }
                                                                  ((WholePeopleLebaEntryChecker)localObject9).a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, bool2);
                                                                  a(93, true, new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool3) });
                                                                  i5 = n;
                                                                  localObject9 = localObject6;
                                                                  i4 = k;
                                                                  localObject6 = localObject1;
                                                                  localObject12 = paramObject;
                                                                  localObject11 = paramFromServiceMsg;
                                                                  n = i1;
                                                                  i1 = i5;
                                                                  k = m;
                                                                  m = i4;
                                                                  paramFromServiceMsg = (FromServiceMsg)localObject9;
                                                                  paramObject = localObject2;
                                                                  localObject1 = localObject5;
                                                                  localObject2 = localObject3;
                                                                  localObject3 = localObject4;
                                                                  localObject4 = localObject12;
                                                                  localObject5 = localObject6;
                                                                  localObject6 = localObject11;
                                                                  break label11763;
                                                                  i4 = localByteBuffer.getShort();
                                                                  if (i4 <= 0) {
                                                                    break label11691;
                                                                  }
                                                                  DanceGameVideoManager.a().a(i4, String.valueOf(localLong));
                                                                  i5 = n;
                                                                  localObject9 = localObject6;
                                                                  i4 = k;
                                                                  localObject6 = localObject1;
                                                                  localObject12 = paramObject;
                                                                  localObject11 = paramFromServiceMsg;
                                                                  n = i1;
                                                                  i1 = i5;
                                                                  k = m;
                                                                  m = i4;
                                                                  paramFromServiceMsg = (FromServiceMsg)localObject9;
                                                                  paramObject = localObject2;
                                                                  localObject1 = localObject5;
                                                                  localObject2 = localObject3;
                                                                  localObject3 = localObject4;
                                                                  localObject4 = localObject12;
                                                                  localObject5 = localObject6;
                                                                  localObject6 = localObject11;
                                                                  break label11763;
                                                                  s = localByteBuffer.getShort();
                                                                  if (QLog.isColorLevel()) {
                                                                    QLog.d("CardHandler", 2, new Object[] { "love language get server mark =", Short.valueOf(s) });
                                                                  }
                                                                  localObject9 = (LoveLanguageManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(273);
                                                                  if (localObject9 == null) {
                                                                    break label11691;
                                                                  }
                                                                  if (s != 1) {
                                                                    break label11998;
                                                                  }
                                                                }
                                                              }
                                                            }
                                                          }
                                                        }
                                                      }
                                                    }
                                                  }
                                                }
                                              }
                                            }
                                          }
                                        }
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    label10420:
    label11850:
    label11856:
    label11862:
    label11868:
    label11998:
    for (boolean bool2 = true;; bool2 = false)
    {
      ((LoveLanguageManager)localObject9).a(bool2);
      i5 = n;
      localObject9 = localObject6;
      i4 = k;
      localObject6 = localObject1;
      localObject12 = paramObject;
      localObject11 = paramFromServiceMsg;
      n = i1;
      i1 = i5;
      k = m;
      m = i4;
      paramFromServiceMsg = (FromServiceMsg)localObject9;
      paramObject = localObject2;
      localObject1 = localObject5;
      localObject2 = localObject3;
      localObject3 = localObject4;
      localObject4 = localObject12;
      localObject5 = localObject6;
      localObject6 = localObject11;
      break label11763;
      s = localByteBuffer.getShort();
      if (QLog.isColorLevel()) {
        QLog.i("CardHandler", 2, "handleGetDetalInfo FIELD_EXTEND_FRIEND_ADD_FRIEND=" + s);
      }
      localCard.extendFriendEntryAddFriend = s;
      SharedPreUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "extend_friend_config").edit().putInt("sp_extend_friend_entry_add_friend", s).apply();
      i5 = n;
      localObject9 = localObject6;
      i4 = k;
      localObject6 = localObject1;
      localObject12 = paramObject;
      localObject11 = paramFromServiceMsg;
      n = i1;
      i1 = i5;
      k = m;
      m = i4;
      paramFromServiceMsg = (FromServiceMsg)localObject9;
      paramObject = localObject2;
      localObject1 = localObject5;
      localObject2 = localObject3;
      localObject3 = localObject4;
      localObject4 = localObject12;
      localObject5 = localObject6;
      localObject6 = localObject11;
      break label11763;
      s = localByteBuffer.getShort();
      if (QLog.isColorLevel()) {
        QLog.i("CardHandler", 2, "handleGetDetalInfo FIELD_EXTEND_FRIEND_CONTACT_CARD=" + s);
      }
      localCard.extendFriendEntryContact = s;
      SharedPreUtils.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), "extend_friend_config").edit().putInt("sp_extend_friend_entry_contact", s).apply();
      i5 = n;
      localObject9 = localObject6;
      i4 = k;
      localObject6 = localObject1;
      localObject12 = paramObject;
      localObject11 = paramFromServiceMsg;
      n = i1;
      i1 = i5;
      k = m;
      m = i4;
      paramFromServiceMsg = (FromServiceMsg)localObject9;
      paramObject = localObject2;
      localObject1 = localObject5;
      localObject2 = localObject3;
      localObject3 = localObject4;
      localObject4 = localObject12;
      localObject5 = localObject6;
      localObject6 = localObject11;
      break label11763;
      localObject9 = (ClassicHeadActivityManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(198);
      if ((localObject9 != null) && (((ClassicHeadActivityManager)localObject9).a())) {
        ((ClassicHeadActivityManager)localObject9).a(i2, n, i1);
      }
      if (j != 0) {
        localApolloManager.a(localApolloBaseInfo);
      }
      if ((ApolloManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp())) && (1 == localApolloBaseInfo.apolloStatus) && (localApolloBaseInfo.apolloLocalTS != localApolloBaseInfo.apolloServerTS))
      {
        localObject9 = new ArrayList(1);
        ((ArrayList)localObject9).add(Long.valueOf(localApolloBaseInfo.uin));
        localObject11 = (VasExtensionHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(71);
        if (localObject11 != null)
        {
          ((VasExtensionHandler)localObject11).a((ArrayList)localObject9, "card");
          if (QLog.isColorLevel()) {
            QLog.d("CardHandler", 2, "handleGetDetailInfo update apollo user apolloDress uin: " + localApolloBaseInfo.uin);
          }
        }
      }
      if (k != 0)
      {
        localObject9 = new StringBuilder();
        ((StringBuilder)localObject9).append((String)localObject3).append("-");
        ((StringBuilder)localObject9).append((String)localObject5).append("-");
        ((StringBuilder)localObject9).append((String)localObject2).append("-");
        ((StringBuilder)localObject9).append((String)localObject6);
        localCard.strLocationCodes = ((StringBuilder)localObject9).toString();
      }
      if (m != 0)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramFromServiceMsg).append("-");
        ((StringBuilder)localObject2).append((String)localObject1).append("-");
        ((StringBuilder)localObject2).append(paramObject).append("-");
        ((StringBuilder)localObject2).append((String)localObject4);
        localCard.strHometownCodes = ((StringBuilder)localObject2).toString();
      }
      localFriendsManager.a(localCard);
      if (((k != 0) || (m != 0)) && (paramToServiceMsg.extraData.getBoolean("reqFromDetailActivity"))) {
        ((ConditionSearchManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(58)).a(localCard);
      }
      paramToServiceMsg = localCard;
      break label727;
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_result.has()))
      {
        j = paramFromServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.d("CardHandler", 2, "request error, ret " + j);
        }
        paramToServiceMsg = null;
        bool1 = false;
        break label727;
      }
      break label11980;
      i2 = n;
      localObject9 = localObject6;
      n = i1;
      localObject6 = localObject5;
      i5 = k;
      localObject5 = localObject1;
      localObject11 = paramObject;
      localObject12 = paramFromServiceMsg;
      i1 = i2;
      i2 = i4;
      k = m;
      m = i5;
      paramFromServiceMsg = (FromServiceMsg)localObject9;
      paramObject = localObject2;
      localObject1 = localObject6;
      localObject2 = localObject3;
      localObject3 = localObject4;
      localObject4 = localObject11;
      localObject6 = localObject12;
      break label11763;
      i1 = n;
      i4 = k;
      localObject11 = localObject6;
      localObject6 = localObject1;
      localObject9 = paramFromServiceMsg;
      localObject12 = paramObject;
      n = i5;
      k = m;
      m = i4;
      paramFromServiceMsg = (FromServiceMsg)localObject11;
      paramObject = localObject2;
      localObject1 = localObject5;
      localObject2 = localObject3;
      localObject3 = localObject4;
      localObject4 = localObject12;
      localObject5 = localObject6;
      localObject6 = localObject9;
      break label11763;
      break label7715;
      break label7414;
      break label7237;
      break label6924;
      break label6794;
      n = i1;
      i4 = k;
      localObject9 = paramObject;
      localObject11 = localObject1;
      localObject12 = paramFromServiceMsg;
      i1 = i5;
      k = m;
      m = i4;
      paramFromServiceMsg = (FromServiceMsg)localObject6;
      paramObject = localObject2;
      localObject1 = localObject5;
      localObject2 = localObject3;
      localObject3 = localObject4;
      localObject4 = localObject9;
      localObject5 = localObject11;
      localObject6 = localObject12;
      break label11763;
      paramToServiceMsg = null;
      break label727;
      label11107:
      switch (s)
      {
      }
      break label362;
      label11763:
      label11902:
      do
      {
        i4 = i1;
        i1 = m;
        localObject9 = localObject6;
        localObject11 = localObject5;
        localObject13 = localObject4;
        Object localObject14 = localObject3;
        localObject12 = localObject2;
        localObject6 = paramFromServiceMsg;
        localObject5 = localObject1;
        localObject4 = paramObject;
        localObject3 = localObject13;
        localObject2 = localObject14;
        localObject1 = localObject11;
        paramObject = localObject12;
        paramFromServiceMsg = (FromServiceMsg)localObject9;
        m = k;
        k = i1;
        i1 = n;
        n = i4;
        localObject9 = localObject3;
        localObject11 = localObject4;
        localObject12 = localObject5;
        localObject13 = localObject6;
        localObject3 = localObject2;
        i4 = m;
        m = n;
        n = i1;
        i5 = i6;
        i3 += 1;
        i1 = m;
        m = k;
        k = i4;
        localObject6 = paramFromServiceMsg;
        localObject2 = paramObject;
        localObject5 = localObject1;
        localObject4 = localObject9;
        paramObject = localObject11;
        localObject1 = localObject12;
        paramFromServiceMsg = (FromServiceMsg)localObject13;
        break label265;
        bool1 = false;
        break;
        bool2 = false;
        break label3093;
        bool2 = false;
        break label3237;
        bool2 = true;
        break label3379;
        if (i4 == 0)
        {
          bool2 = false;
          break label3693;
        }
        bool2 = true;
        break label3693;
        if (i4 == 0)
        {
          i4 = 1;
          break label4055;
        }
        i4 = 0;
        break label4055;
      } while ((i8 != 1) || (i4 == i5));
      label11885:
      if (i5 == 0)
      {
        bool2 = false;
        break label4176;
      }
      bool2 = true;
      break label4176;
      bool2 = false;
      break label4346;
      bool2 = false;
      break label6689;
      bool2 = false;
      break label7845;
      bool2 = false;
      break label8018;
      if (i4 == 1)
      {
        bool2 = true;
        break label8366;
      }
      bool2 = false;
      break label8366;
      bool2 = false;
      break label9571;
      if (i4 == 1)
      {
        bool2 = true;
        break label9752;
      }
      bool2 = false;
      break label9752;
    }
  }
  
  private void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramFromServiceMsg = (RespHYMakeFriendsCard)paramObject;
      paramObject = paramToServiceMsg.extraData.getString("friendUin");
      int i = paramToServiceMsg.extraData.getInt("uFaceTimeStamp");
      if (paramFromServiceMsg.stHeader.iReplyCode == 0)
      {
        paramToServiceMsg = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
        paramBundle = paramToServiceMsg.b(paramObject);
        paramBundle.uin = paramObject;
        paramBundle.strNick = paramFromServiceMsg.stMakeFriendsCard.strNick;
        paramBundle.shGender = paramFromServiceMsg.stMakeFriendsCard.shGender;
        paramBundle.shAge = paramFromServiceMsg.stMakeFriendsCard.shAge;
        paramBundle.nFaceID = paramFromServiceMsg.stMakeFriendsCard.nFaceID;
        paramBundle.strCertificationInfo = paramFromServiceMsg.stMakeFriendsCard.strCertificationInfo;
        paramBundle.shType = paramFromServiceMsg.stMakeFriendsCard.stIntro.shType;
        paramBundle.vContent = paramFromServiceMsg.stMakeFriendsCard.stIntro.vContent;
        paramBundle.vQQFaceID = paramFromServiceMsg.stMakeFriendsCard.vQQFaceID;
        paramBundle.bWeiboInfo = paramFromServiceMsg.bWeiboInfo;
        paramBundle.bQzoneInfo = paramFromServiceMsg.bQzoneInfo;
        paramBundle.nSameFriendsNum = paramFromServiceMsg.nSameFriendsNum;
        paramBundle.strCompanySame = paramFromServiceMsg.strCompany;
        paramBundle.strSchoolSame = paramFromServiceMsg.strSchool;
        paramBundle.bSingle = paramFromServiceMsg.stMakeFriendsCard.bSingle;
        paramBundle.lVisitCount = paramFromServiceMsg.stMakeFriendsCard.lVisitCount;
        if ((i == 0) || (paramFromServiceMsg.stMakeFriendsCard.uFaceTimeStamp > paramBundle.uFaceTimeStamp))
        {
          paramBundle.uFaceTimeStamp = paramFromServiceMsg.stMakeFriendsCard.uFaceTimeStamp;
          paramBundle.setStrJoinHexAlbumFileKey(a(paramFromServiceMsg.vFaceInfo));
        }
        if (paramFromServiceMsg.stMakeFriendsCard.lVoteCount > paramBundle.lVoteCount) {
          paramBundle.lVoteCount = paramFromServiceMsg.stMakeFriendsCard.lVoteCount;
        }
        paramBundle.eUserIdentityType = ((byte)paramFromServiceMsg.stMakeFriendsCard.eUserIdentityType);
        paramBundle.vBackground = paramFromServiceMsg.stMakeFriendsCard.vBackground;
        paramBundle.bVoted = paramFromServiceMsg.bVoted;
        paramBundle.iFaceNum = paramFromServiceMsg.stMakeFriendsCard.iFaceNum;
        paramBundle.cSqqLevel = paramFromServiceMsg.cSqqLevel;
        paramBundle.iQQLevel = paramFromServiceMsg.stMakeFriendsCard.iQQLevel;
        paramToServiceMsg.a(paramBundle);
        paramToServiceMsg.b(paramBundle.uin, paramBundle.strNick);
        a(1, true, paramBundle);
        return;
      }
      if ((3 == paramFromServiceMsg.stHeader.iReplyCode) || (56 == paramFromServiceMsg.stHeader.iReplyCode))
      {
        a(2, true, paramBundle);
        return;
      }
      a(1, false, paramBundle);
      return;
    }
    a(1, false, paramBundle);
  }
  
  private void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = (String)paramToServiceMsg.getAttribute("uin");
    EntityManager localEntityManager;
    boolean bool;
    if ((paramFromServiceMsg.isSuccess()) && ((paramObject instanceof mobile_sub_get_cover_rsp)))
    {
      paramFromServiceMsg = (mobile_sub_get_cover_rsp)paramObject;
      localEntityManager = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      paramObject = (QZoneCover)localEntityManager.a(QZoneCover.class, str);
      paramToServiceMsg = paramObject;
      if (paramObject == null)
      {
        paramToServiceMsg = new QZoneCover();
        paramToServiceMsg.uin = str;
      }
      paramToServiceMsg.updateQzoneCover(paramFromServiceMsg);
      if (paramToServiceMsg.getStatus() == 1000)
      {
        localEntityManager.a(paramToServiceMsg);
        localEntityManager.a();
        bool = true;
        paramToServiceMsg = paramFromServiceMsg;
      }
    }
    for (;;)
    {
      a(40, bool, new Object[] { str, paramToServiceMsg });
      return;
      localEntityManager.a(paramToServiceMsg);
      break;
      paramToServiceMsg = null;
      bool = false;
    }
  }
  
  private void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.SummaryCard", 2, "handleVoiceManager() , resp.getResultCode() = " + paramFromServiceMsg.getResultCode());
    }
    long l = paramToServiceMsg.extraData.getLong("pttcenter_targetuin");
    int j = paramToServiceMsg.extraData.getInt("pttcenter_voice_optype");
    int i = 9006;
    StringBuilder localStringBuilder1 = new StringBuilder(100);
    boolean bool1;
    if ((paramFromServiceMsg.getResultCode() == 1000) && ((paramObject instanceof RespVoiceManage)))
    {
      bool1 = true;
      if (!bool1) {}
    }
    else
    {
      try
      {
        localRespHead = (SummaryCard.RespHead)a(paramFromServiceMsg.getWupBuffer(), "RespHead", new SummaryCard.RespHead());
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder2 = new StringBuilder().append("handleVoiceManager() respHead.iResult = ");
          if (localRespHead == null) {
            break label501;
          }
          paramBundle = Integer.valueOf(localRespHead.iResult);
          label160:
          QLog.d("Q.profilecard.SummaryCard", 2, paramBundle);
        }
        if (localRespHead != null) {
          break label507;
        }
        bool1 = false;
        i = 9045;
        localStringBuilder1.append("|wupbuf: ").append(HexUtil.a(paramFromServiceMsg.getWupBuffer()));
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          SummaryCard.RespHead localRespHead;
          label209:
          short s;
          label377:
          boolean bool2;
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.SummaryCard", 2, paramBundle.toString());
          }
          bool1 = false;
          i = 9045;
          localStringBuilder1.append("|exception: ").append(paramBundle.toString()).append("|wufbuf: ").append(HexUtil.a(paramFromServiceMsg.getWupBuffer()));
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.SummaryCard", 2, "handleVoiceManager() lUin = " + l + ", eOptype = " + j + ", success = " + bool1);
      }
      if (!bool1) {
        break label741;
      }
      paramBundle = (RespVoiceManage)paramObject;
      if (l > 0L)
      {
        paramFromServiceMsg = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
        paramObject = paramFromServiceMsg.b(String.valueOf(l));
        if (paramBundle.eOpType != 1) {
          break label650;
        }
        paramBundle = paramToServiceMsg.extraData.getString("pttcenter_filekey");
        s = paramToServiceMsg.extraData.getShort("pttcenter_shDuration");
        paramObject.strVoiceFilekey = paramBundle;
        paramObject.shDuration = s;
        paramObject.bRead = 0;
        paramObject.strUrl = null;
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.SummaryCard", 2, "上传成功");
        }
        bool2 = paramFromServiceMsg.a(paramObject);
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.SummaryCard", 2, "更新结果  bRet = " + bool2);
        }
        a(35, true, new Object[] { String.valueOf(l), Integer.valueOf(j), paramObject });
      }
    }
    for (;;)
    {
      if (j == 1) {
        ProfileCardUtil.a(String.valueOf(l), 0, bool1, paramToServiceMsg.extraData.getString("pttcenter_filekey"), "0", ProfileCardUtil.a(), 0, i, 0L, localStringBuilder1.toString(), "");
      }
      return;
      bool1 = false;
      break;
      label501:
      paramBundle = null;
      break label160;
      label507:
      if (localRespHead.iResult != 0)
      {
        localStringBuilder1.append("|iResult: ").append(localRespHead.iResult);
        bool1 = false;
        i = 9007;
        break label209;
      }
      bool1 = true;
      break label209;
      i = 9311;
      localStringBuilder1.append("|resultcode: ").append(paramFromServiceMsg.getResultCode()).append("|reason: ").append(MessageHandler.a(paramFromServiceMsg));
      break label209;
      label650:
      if (paramBundle.eOpType == 2)
      {
        paramObject.strVoiceFilekey = "";
        paramObject.shDuration = 0;
        paramObject.bRead = 0;
        paramObject.strUrl = null;
        if (!QLog.isColorLevel()) {
          break label377;
        }
        QLog.d("Q.profilecard.SummaryCard", 2, "删除成功");
        break label377;
      }
      if (paramBundle.eOpType != 3) {
        break label377;
      }
      if (paramObject.bRead != 1) {
        paramObject.bRead = 1;
      }
      if (!QLog.isColorLevel()) {
        break label377;
      }
      QLog.d("Q.profilecard.SummaryCard", 2, "已读标识设置成功");
      break label377;
      label741:
      a(35, false, new Object[] { String.valueOf(l), Integer.valueOf(j), null });
    }
  }
  
  private void o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str1 = (String)paramToServiceMsg.getAttribute("uin");
    String str2 = (String)paramToServiceMsg.getAttribute("attachInfo");
    EntityManager localEntityManager;
    boolean bool;
    if ((paramFromServiceMsg.isSuccess()) && ((paramObject instanceof mobile_sub_get_photo_wall_rsp)))
    {
      paramFromServiceMsg = (mobile_sub_get_photo_wall_rsp)paramObject;
      localEntityManager = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      paramObject = (QZonePhotoWall)localEntityManager.a(QZonePhotoWall.class, str1);
      paramToServiceMsg = paramObject;
      if (paramObject == null)
      {
        paramToServiceMsg = new QZonePhotoWall();
        paramToServiceMsg.uin = str1;
      }
      paramToServiceMsg.updateQzonePhotoWall(str2, paramFromServiceMsg);
      if (paramToServiceMsg.getStatus() == 1000)
      {
        localEntityManager.a(paramToServiceMsg);
        localEntityManager.a();
        bool = true;
        paramToServiceMsg = paramFromServiceMsg;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qzonephotowall", 2, "handleGetPhotoWall isSuc:" + bool);
      }
      a(69, bool, new Object[] { str2, paramToServiceMsg, str1 });
      return;
      localEntityManager.a(paramToServiceMsg);
      break;
      paramToServiceMsg = null;
      bool = false;
    }
  }
  
  /* Error */
  private void o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    // Byte code:
    //   0: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +33 -> 36
    //   6: ldc_w 1256
    //   9: iconst_2
    //   10: new 18	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 2926
    //   20: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: aload_2
    //   24: invokevirtual 1513	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   27: invokevirtual 572	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   30: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   36: invokestatic 736	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   39: ifeq +7969 -> 8008
    //   42: invokestatic 2931	java/lang/System:currentTimeMillis	()J
    //   45: lstore 15
    //   47: aconst_null
    //   48: astore 22
    //   50: aload_2
    //   51: invokevirtual 88	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   54: ifeq +372 -> 426
    //   57: aload_3
    //   58: instanceof 2933
    //   61: ifeq +365 -> 426
    //   64: iconst_1
    //   65: istore 6
    //   67: iload 6
    //   69: ifeq +7933 -> 8002
    //   72: aload_0
    //   73: aload_2
    //   74: invokevirtual 2838	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   77: ldc_w 2840
    //   80: new 2842	SummaryCard/RespHead
    //   83: dup
    //   84: invokespecial 2843	SummaryCard/RespHead:<init>	()V
    //   87: invokevirtual 1890	com/tencent/mobileqq/app/CardHandler:a	([BLjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   90: checkcast 2842	SummaryCard/RespHead
    //   93: astore 4
    //   95: aload 4
    //   97: ifnull +335 -> 432
    //   100: aload 4
    //   102: getfield 2848	SummaryCard/RespHead:iResult	I
    //   105: ifne +327 -> 432
    //   108: iconst_1
    //   109: istore 6
    //   111: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   114: ifeq +45 -> 159
    //   117: new 18	java/lang/StringBuilder
    //   120: dup
    //   121: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   124: ldc_w 2935
    //   127: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: astore 23
    //   132: aload 4
    //   134: ifnonnull +304 -> 438
    //   137: ldc_w 2937
    //   140: astore 22
    //   142: ldc_w 1256
    //   145: iconst_2
    //   146: aload 23
    //   148: aload 22
    //   150: invokevirtual 667	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   153: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   159: aload_1
    //   160: getfield 281	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   163: ldc_w 1197
    //   166: invokevirtual 1430	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   169: lstore 17
    //   171: aload_1
    //   172: getfield 281	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   175: ldc_w 1291
    //   178: invokevirtual 733	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   181: astore 22
    //   183: aload_1
    //   184: getfield 281	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   187: ldc_w 1269
    //   190: invokevirtual 1435	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   193: istore 14
    //   195: iload 6
    //   197: ifeq +7652 -> 7849
    //   200: aload_0
    //   201: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   204: bipush 50
    //   206: invokevirtual 112	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   209: checkcast 114	com/tencent/mobileqq/app/FriendsManager
    //   212: astore 23
    //   214: aload_0
    //   215: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   218: bipush 51
    //   220: invokevirtual 112	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   223: checkcast 2939	com/tencent/mobileqq/app/TroopManager
    //   226: astore 25
    //   228: aload_3
    //   229: checkcast 2933	SummaryCard/RespSummaryCard
    //   232: astore 24
    //   234: lload 17
    //   236: lconst_0
    //   237: lcmp
    //   238: ifgt +267 -> 505
    //   241: iload 14
    //   243: bipush 41
    //   245: if_icmpeq +260 -> 505
    //   248: iload 14
    //   250: bipush 6
    //   252: if_icmpeq +253 -> 505
    //   255: iload 14
    //   257: bipush 45
    //   259: if_icmpeq +246 -> 505
    //   262: aload 23
    //   264: aload 22
    //   266: invokevirtual 2942	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/ContactCard;
    //   269: astore_1
    //   270: aload_1
    //   271: aload 24
    //   273: getfield 2945	SummaryCard/RespSummaryCard:bAge	B
    //   276: putfield 2948	com/tencent/mobileqq/data/ContactCard:bAge	B
    //   279: aload_1
    //   280: aload 24
    //   282: getfield 2951	SummaryCard/RespSummaryCard:bSex	B
    //   285: putfield 2952	com/tencent/mobileqq/data/ContactCard:bSex	B
    //   288: aload_1
    //   289: aload 24
    //   291: getfield 2953	SummaryCard/RespSummaryCard:strNick	Ljava/lang/String;
    //   294: putfield 2955	com/tencent/mobileqq/data/ContactCard:nickName	Ljava/lang/String;
    //   297: aload_1
    //   298: aload 24
    //   300: getfield 2956	SummaryCard/RespSummaryCard:strProvince	Ljava/lang/String;
    //   303: putfield 2957	com/tencent/mobileqq/data/ContactCard:strProvince	Ljava/lang/String;
    //   306: aload_1
    //   307: aload 24
    //   309: getfield 2958	SummaryCard/RespSummaryCard:strCountry	Ljava/lang/String;
    //   312: putfield 2959	com/tencent/mobileqq/data/ContactCard:strCountry	Ljava/lang/String;
    //   315: aload_1
    //   316: aload 24
    //   318: getfield 2960	SummaryCard/RespSummaryCard:strCity	Ljava/lang/String;
    //   321: putfield 2961	com/tencent/mobileqq/data/ContactCard:strCity	Ljava/lang/String;
    //   324: aload_1
    //   325: aload 24
    //   327: getfield 2964	SummaryCard/RespSummaryCard:strContactName	Ljava/lang/String;
    //   330: putfield 2965	com/tencent/mobileqq/data/ContactCard:strContactName	Ljava/lang/String;
    //   333: aload 24
    //   335: getfield 2968	SummaryCard/RespSummaryCard:iContactNotBindQQ	I
    //   338: iconst_1
    //   339: if_icmpeq +150 -> 489
    //   342: iconst_1
    //   343: istore 21
    //   345: aload_1
    //   346: iload 21
    //   348: putfield 2971	com/tencent/mobileqq/data/ContactCard:bindQQ	Z
    //   351: aload 24
    //   353: getfield 2974	SummaryCard/RespSummaryCard:lUIN	J
    //   356: lconst_0
    //   357: lcmp
    //   358: ifle +137 -> 495
    //   361: aload_1
    //   362: aload 24
    //   364: getfield 2974	SummaryCard/RespSummaryCard:lUIN	J
    //   367: invokestatic 272	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   370: putfield 2975	com/tencent/mobileqq/data/ContactCard:uin	Ljava/lang/String;
    //   373: aload 23
    //   375: aload_1
    //   376: invokevirtual 2978	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/ContactCard;)Z
    //   379: pop
    //   380: aload_0
    //   381: iconst_1
    //   382: iconst_1
    //   383: aload_1
    //   384: invokevirtual 198	com/tencent/mobileqq/app/CardHandler:a	(IZLjava/lang/Object;)V
    //   387: invokestatic 736	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   390: ifeq +35 -> 425
    //   393: ldc_w 1256
    //   396: iconst_4
    //   397: new 18	java/lang/StringBuilder
    //   400: dup
    //   401: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   404: ldc_w 2980
    //   407: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: invokestatic 2931	java/lang/System:currentTimeMillis	()J
    //   413: lload 15
    //   415: lsub
    //   416: invokevirtual 326	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   419: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   422: invokestatic 687	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   425: return
    //   426: iconst_0
    //   427: istore 6
    //   429: goto -362 -> 67
    //   432: iconst_0
    //   433: istore 6
    //   435: goto -324 -> 111
    //   438: aload 4
    //   440: getfield 2848	SummaryCard/RespHead:iResult	I
    //   443: istore 7
    //   445: iload 7
    //   447: invokestatic 74	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   450: astore 22
    //   452: goto -310 -> 142
    //   455: astore 23
    //   457: aload 22
    //   459: astore 4
    //   461: aload 23
    //   463: astore 22
    //   465: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   468: ifeq +15 -> 483
    //   471: ldc_w 1256
    //   474: iconst_2
    //   475: aload 22
    //   477: invokevirtual 2887	java/lang/Exception:toString	()Ljava/lang/String;
    //   480: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   483: iconst_0
    //   484: istore 6
    //   486: goto -327 -> 159
    //   489: iconst_0
    //   490: istore 21
    //   492: goto -147 -> 345
    //   495: aload_1
    //   496: ldc_w 705
    //   499: putfield 2975	com/tencent/mobileqq/data/ContactCard:uin	Ljava/lang/String;
    //   502: goto -129 -> 373
    //   505: aload_1
    //   506: getfield 281	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   509: ldc_w 1301
    //   512: invokevirtual 289	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   515: iconst_1
    //   516: if_icmpeq -91 -> 425
    //   519: lload 17
    //   521: invokestatic 272	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   524: astore 26
    //   526: aload 23
    //   528: aload 26
    //   530: invokevirtual 120	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   533: astore 22
    //   535: aload 22
    //   537: aload 24
    //   539: getfield 2981	SummaryCard/RespSummaryCard:iLevel	I
    //   542: putfield 2802	com/tencent/mobileqq/data/Card:iQQLevel	I
    //   545: aload 22
    //   547: aload 24
    //   549: getfield 2953	SummaryCard/RespSummaryCard:strNick	Ljava/lang/String;
    //   552: putfield 2119	com/tencent/mobileqq/data/Card:strNick	Ljava/lang/String;
    //   555: aload 22
    //   557: aload 24
    //   559: getfield 2951	SummaryCard/RespSummaryCard:bSex	B
    //   562: i2s
    //   563: putfield 2147	com/tencent/mobileqq/data/Card:shGender	S
    //   566: aload 22
    //   568: aload 24
    //   570: getfield 2945	SummaryCard/RespSummaryCard:bAge	B
    //   573: i2s
    //   574: putfield 2344	com/tencent/mobileqq/data/Card:shAge	S
    //   577: aload 22
    //   579: aload 24
    //   581: getfield 2945	SummaryCard/RespSummaryCard:bAge	B
    //   584: putfield 2159	com/tencent/mobileqq/data/Card:age	B
    //   587: aload 22
    //   589: aload 24
    //   591: getfield 2984	SummaryCard/RespSummaryCard:iFace	I
    //   594: putfield 2733	com/tencent/mobileqq/data/Card:nFaceID	I
    //   597: aload 22
    //   599: aload 24
    //   601: getfield 2987	SummaryCard/RespSummaryCard:strSign	Ljava/lang/String;
    //   604: putfield 2988	com/tencent/mobileqq/data/Card:strSign	Ljava/lang/String;
    //   607: aload 22
    //   609: aload 24
    //   611: getfield 2960	SummaryCard/RespSummaryCard:strCity	Ljava/lang/String;
    //   614: putfield 2222	com/tencent/mobileqq/data/Card:strCity	Ljava/lang/String;
    //   617: aload 22
    //   619: aload 24
    //   621: getfield 2956	SummaryCard/RespSummaryCard:strProvince	Ljava/lang/String;
    //   624: putfield 2219	com/tencent/mobileqq/data/Card:strProvince	Ljava/lang/String;
    //   627: aload 22
    //   629: aload 24
    //   631: getfield 2958	SummaryCard/RespSummaryCard:strCountry	Ljava/lang/String;
    //   634: putfield 2216	com/tencent/mobileqq/data/Card:strCountry	Ljava/lang/String;
    //   637: aload 22
    //   639: aload 24
    //   641: getfield 2991	SummaryCard/RespSummaryCard:strRemark	Ljava/lang/String;
    //   644: putfield 2994	com/tencent/mobileqq/data/Card:strReMark	Ljava/lang/String;
    //   647: aload 22
    //   649: aload 24
    //   651: getfield 2997	SummaryCard/RespSummaryCard:iPhotoCount	I
    //   654: putfield 1765	com/tencent/mobileqq/data/Card:iFaceNum	I
    //   657: aload 22
    //   659: aload 24
    //   661: getfield 3000	SummaryCard/RespSummaryCard:strGroupName	Ljava/lang/String;
    //   664: putfield 3003	com/tencent/mobileqq/data/Card:strTroopName	Ljava/lang/String;
    //   667: aload 22
    //   669: aload 24
    //   671: getfield 3006	SummaryCard/RespSummaryCard:strGroupNick	Ljava/lang/String;
    //   674: putfield 3009	com/tencent/mobileqq/data/Card:strTroopNick	Ljava/lang/String;
    //   677: aload 22
    //   679: aload 24
    //   681: getfield 3012	SummaryCard/RespSummaryCard:strMobile	Ljava/lang/String;
    //   684: putfield 3013	com/tencent/mobileqq/data/Card:strMobile	Ljava/lang/String;
    //   687: aload 22
    //   689: aload 24
    //   691: getfield 2964	SummaryCard/RespSummaryCard:strContactName	Ljava/lang/String;
    //   694: putfield 3014	com/tencent/mobileqq/data/Card:strContactName	Ljava/lang/String;
    //   697: aload 22
    //   699: aload 24
    //   701: getfield 3017	SummaryCard/RespSummaryCard:strStatus	Ljava/lang/String;
    //   704: putfield 3018	com/tencent/mobileqq/data/Card:strStatus	Ljava/lang/String;
    //   707: aload 22
    //   709: aload 24
    //   711: getfield 3021	SummaryCard/RespSummaryCard:strAutoRemark	Ljava/lang/String;
    //   714: putfield 3022	com/tencent/mobileqq/data/Card:strAutoRemark	Ljava/lang/String;
    //   717: aload 22
    //   719: aload 24
    //   721: getfield 3024	SummaryCard/RespSummaryCard:vSeed	[B
    //   724: putfield 3025	com/tencent/mobileqq/data/Card:vSeed	[B
    //   727: aload 22
    //   729: aload 24
    //   731: getfield 3028	SummaryCard/RespSummaryCard:iVoteCount	I
    //   734: i2l
    //   735: putfield 2783	com/tencent/mobileqq/data/Card:lVisitCount	J
    //   738: aload 22
    //   740: aload 24
    //   742: getfield 3031	SummaryCard/RespSummaryCard:uQQMasterLoginDays	J
    //   745: putfield 3034	com/tencent/mobileqq/data/Card:lQQMasterLogindays	J
    //   748: aload 22
    //   750: iload 14
    //   752: putfield 3036	com/tencent/mobileqq/data/Card:favoriteSource	I
    //   755: aload 22
    //   757: aload 24
    //   759: getfield 3039	SummaryCard/RespSummaryCard:strVoteLimitedNotice	Ljava/lang/String;
    //   762: putfield 3040	com/tencent/mobileqq/data/Card:strVoteLimitedNotice	Ljava/lang/String;
    //   765: aload 22
    //   767: aload 24
    //   769: getfield 3043	SummaryCard/RespSummaryCard:bHaveVotedCnt	S
    //   772: putfield 3044	com/tencent/mobileqq/data/Card:bHaveVotedCnt	S
    //   775: aload 22
    //   777: aload 24
    //   779: getfield 3045	SummaryCard/RespSummaryCard:bAvailVoteCnt	S
    //   782: putfield 1489	com/tencent/mobileqq/data/Card:bAvailVoteCnt	S
    //   785: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   788: ifeq +62 -> 850
    //   791: ldc_w 682
    //   794: iconst_2
    //   795: new 18	java/lang/StringBuilder
    //   798: dup
    //   799: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   802: ldc_w 3047
    //   805: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   808: aload 24
    //   810: getfield 3039	SummaryCard/RespSummaryCard:strVoteLimitedNotice	Ljava/lang/String;
    //   813: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   816: ldc_w 3049
    //   819: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   822: aload 24
    //   824: getfield 3043	SummaryCard/RespSummaryCard:bHaveVotedCnt	S
    //   827: invokevirtual 572	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   830: ldc_w 3051
    //   833: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   836: aload 24
    //   838: getfield 3045	SummaryCard/RespSummaryCard:bAvailVoteCnt	S
    //   841: invokevirtual 572	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   844: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   847: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   850: aload 24
    //   852: getfield 3055	SummaryCard/RespSummaryCard:stQCallInfo	LSummaryCard/QCallInfo;
    //   855: astore_2
    //   856: aload_2
    //   857: ifnull +1739 -> 2596
    //   860: aload_2
    //   861: getfield 3060	SummaryCard/QCallInfo:bStatus	I
    //   864: iconst_1
    //   865: if_icmpne +1710 -> 2575
    //   868: aload 22
    //   870: iconst_1
    //   871: putfield 3063	com/tencent/mobileqq/data/Card:showLightalk	Z
    //   874: aload 22
    //   876: aload_2
    //   877: getfield 3064	SummaryCard/QCallInfo:strNick	Ljava/lang/String;
    //   880: putfield 3067	com/tencent/mobileqq/data/Card:lightalkNick	Ljava/lang/String;
    //   883: aload 22
    //   885: aload_2
    //   886: getfield 3070	SummaryCard/QCallInfo:uQCallId	J
    //   889: invokestatic 3073	com/tencent/mobileqq/utils/StringUtil:a	(J)Ljava/lang/String;
    //   892: putfield 3076	com/tencent/mobileqq/data/Card:lightalkId	Ljava/lang/String;
    //   895: invokestatic 736	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   898: ifeq +75 -> 973
    //   901: ldc_w 3078
    //   904: iconst_4
    //   905: new 18	java/lang/StringBuilder
    //   908: dup
    //   909: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   912: ldc_w 3080
    //   915: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   918: aload 22
    //   920: getfield 3063	com/tencent/mobileqq/data/Card:showLightalk	Z
    //   923: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   926: ldc_w 3082
    //   929: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   932: aload 22
    //   934: getfield 3067	com/tencent/mobileqq/data/Card:lightalkNick	Ljava/lang/String;
    //   937: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   940: ldc_w 3084
    //   943: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   946: aload_2
    //   947: getfield 3060	SummaryCard/QCallInfo:bStatus	I
    //   950: invokevirtual 572	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   953: ldc_w 3086
    //   956: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   959: aload 22
    //   961: getfield 3076	com/tencent/mobileqq/data/Card:lightalkId	Ljava/lang/String;
    //   964: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   967: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   970: invokestatic 687	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   973: aload 26
    //   975: aload_0
    //   976: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   979: invokevirtual 117	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   982: invokevirtual 275	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   985: ifeq +38 -> 1023
    //   988: aload_0
    //   989: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   992: bipush 105
    //   994: invokevirtual 112	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   997: checkcast 2149	com/tencent/mobileqq/nearby/NearbyCardManager
    //   1000: astore_2
    //   1001: aload_2
    //   1002: ifnull +21 -> 1023
    //   1005: aload_2
    //   1006: aload 24
    //   1008: getfield 2951	SummaryCard/RespSummaryCard:bSex	B
    //   1011: invokevirtual 2150	com/tencent/mobileqq/nearby/NearbyCardManager:b	(I)V
    //   1014: aload_2
    //   1015: aload 24
    //   1017: getfield 2945	SummaryCard/RespSummaryCard:bAge	B
    //   1020: invokevirtual 2165	com/tencent/mobileqq/nearby/NearbyCardManager:a	(I)V
    //   1023: aload_1
    //   1024: getfield 281	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   1027: ldc_w 1269
    //   1030: invokevirtual 1435	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   1033: bipush 37
    //   1035: if_icmpne +18 -> 1053
    //   1038: aload 22
    //   1040: aload_1
    //   1041: getfield 281	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   1044: ldc_w 1291
    //   1047: invokevirtual 733	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   1050: putfield 3089	com/tencent/mobileqq/data/Card:encId	Ljava/lang/String;
    //   1053: aload 4
    //   1055: ifnull +13 -> 1068
    //   1058: aload 22
    //   1060: aload 4
    //   1062: getfield 3092	SummaryCard/RespHead:vCookies	[B
    //   1065: putfield 3093	com/tencent/mobileqq/data/Card:vCookies	[B
    //   1068: aload 24
    //   1070: getfield 3096	SummaryCard/RespSummaryCard:bValid4Vote	B
    //   1073: ifne +1542 -> 2615
    //   1076: aload 22
    //   1078: iconst_1
    //   1079: putfield 1218	com/tencent/mobileqq/data/Card:bVoted	B
    //   1082: aload 22
    //   1084: aload 24
    //   1086: getfield 3099	SummaryCard/RespSummaryCard:ulShowControl	J
    //   1089: l2i
    //   1090: putfield 3101	com/tencent/mobileqq/data/Card:ulShowControl	I
    //   1093: aload 26
    //   1095: aload_0
    //   1096: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1099: invokevirtual 117	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   1102: invokevirtual 275	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1105: ifeq +1549 -> 2654
    //   1108: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1111: ifeq +48 -> 1159
    //   1114: ldc_w 1256
    //   1117: iconst_2
    //   1118: new 18	java/lang/StringBuilder
    //   1121: dup
    //   1122: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   1125: ldc_w 3103
    //   1128: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1131: aload 24
    //   1133: getfield 3028	SummaryCard/RespSummaryCard:iVoteCount	I
    //   1136: invokevirtual 572	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1139: ldc_w 3105
    //   1142: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1145: aload 24
    //   1147: getfield 3108	SummaryCard/RespSummaryCard:iLastestVoteCount	I
    //   1150: invokevirtual 572	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1153: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1156: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1159: aload 22
    //   1161: aload 24
    //   1163: getfield 3028	SummaryCard/RespSummaryCard:iVoteCount	I
    //   1166: i2l
    //   1167: putfield 1215	com/tencent/mobileqq/data/Card:lVoteCount	J
    //   1170: aload 22
    //   1172: aload 24
    //   1174: getfield 3108	SummaryCard/RespSummaryCard:iLastestVoteCount	I
    //   1177: putfield 3111	com/tencent/mobileqq/data/Card:iVoteIncrement	I
    //   1180: aload 22
    //   1182: aload 24
    //   1184: getfield 3114	SummaryCard/RespSummaryCard:vPraiseList	Ljava/util/ArrayList;
    //   1187: invokevirtual 3117	com/tencent/mobileqq/data/Card:setLastPraiseInfoList	(Ljava/util/ArrayList;)V
    //   1190: aload_0
    //   1191: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1194: invokevirtual 2183	com/tencent/mobileqq/app/QQAppInterface:getAccount	()Ljava/lang/String;
    //   1197: aload 22
    //   1199: getfield 1215	com/tencent/mobileqq/data/Card:lVoteCount	J
    //   1202: aload 22
    //   1204: getfield 3111	com/tencent/mobileqq/data/Card:iVoteIncrement	I
    //   1207: invokestatic 3120	com/tencent/mobileqq/nearby/NearbySPUtil:a	(Ljava/lang/String;JI)Z
    //   1210: pop
    //   1211: aload_0
    //   1212: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1215: invokevirtual 1468	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   1218: invokevirtual 1474	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   1221: astore 4
    //   1223: aload 4
    //   1225: ldc_w 3122
    //   1228: ldc_w 3124
    //   1231: iconst_1
    //   1232: anewarray 269	java/lang/String
    //   1235: dup
    //   1236: iconst_0
    //   1237: aload 26
    //   1239: aastore
    //   1240: invokevirtual 3127	com/tencent/mobileqq/persistence/EntityManager:a	(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/mobileqq/persistence/Entity;
    //   1243: checkcast 3122	com/tencent/mobileqq/data/NearbyPeopleCard
    //   1246: astore_3
    //   1247: aload_3
    //   1248: astore_2
    //   1249: aload_3
    //   1250: ifnonnull +11 -> 1261
    //   1253: new 3122	com/tencent/mobileqq/data/NearbyPeopleCard
    //   1256: dup
    //   1257: invokespecial 3128	com/tencent/mobileqq/data/NearbyPeopleCard:<init>	()V
    //   1260: astore_2
    //   1261: aload_2
    //   1262: aload 22
    //   1264: getfield 1215	com/tencent/mobileqq/data/Card:lVoteCount	J
    //   1267: l2i
    //   1268: putfield 3131	com/tencent/mobileqq/data/NearbyPeopleCard:likeCount	I
    //   1271: aload_2
    //   1272: aload 22
    //   1274: getfield 3111	com/tencent/mobileqq/data/Card:iVoteIncrement	I
    //   1277: putfield 3134	com/tencent/mobileqq/data/NearbyPeopleCard:likeCountInc	I
    //   1280: aload_2
    //   1281: aload 24
    //   1283: getfield 3114	SummaryCard/RespSummaryCard:vPraiseList	Ljava/util/ArrayList;
    //   1286: putfield 3138	com/tencent/mobileqq/data/NearbyPeopleCard:praiseList	Ljava/util/List;
    //   1289: aload_2
    //   1290: invokevirtual 3139	com/tencent/mobileqq/data/NearbyPeopleCard:getStatus	()I
    //   1293: sipush 1000
    //   1296: if_icmpne +1328 -> 2624
    //   1299: aload 4
    //   1301: aload_2
    //   1302: invokevirtual 3141	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   1305: aload 4
    //   1307: invokevirtual 2827	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   1310: aload 24
    //   1312: getfield 3099	SummaryCard/RespSummaryCard:ulShowControl	J
    //   1315: ldc2_w 3142
    //   1318: land
    //   1319: lconst_0
    //   1320: lcmp
    //   1321: ifne +1357 -> 2678
    //   1324: iconst_0
    //   1325: istore 21
    //   1327: aload 22
    //   1329: iload 21
    //   1331: invokevirtual 1802	com/tencent/mobileqq/data/Card:setZanShowFlag	(Z)V
    //   1334: aload_0
    //   1335: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1338: sipush 160
    //   1341: invokevirtual 112	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   1344: checkcast 1804	com/tencent/mobileqq/nearby/NearByGeneralManager
    //   1347: iload 21
    //   1349: invokevirtual 1806	com/tencent/mobileqq/nearby/NearByGeneralManager:b	(Z)V
    //   1352: aload 24
    //   1354: getfield 3099	SummaryCard/RespSummaryCard:ulShowControl	J
    //   1357: lconst_1
    //   1358: land
    //   1359: lconst_0
    //   1360: lcmp
    //   1361: ifne +1323 -> 2684
    //   1364: iconst_0
    //   1365: istore 21
    //   1367: aload 22
    //   1369: iload 21
    //   1371: invokevirtual 3146	com/tencent/mobileqq/data/Card:setFeedsShowFlag	(Z)V
    //   1374: aload 24
    //   1376: getfield 3099	SummaryCard/RespSummaryCard:ulShowControl	J
    //   1379: ldc2_w 3147
    //   1382: land
    //   1383: lconst_0
    //   1384: lcmp
    //   1385: ifne +1305 -> 2690
    //   1388: iconst_0
    //   1389: istore 21
    //   1391: aload 22
    //   1393: iload 21
    //   1395: invokevirtual 3151	com/tencent/mobileqq/data/Card:setPhotoShowFlag	(Z)V
    //   1398: aload 24
    //   1400: getfield 3154	SummaryCard/RespSummaryCard:lCacheControl	J
    //   1403: lconst_0
    //   1404: lcmp
    //   1405: ifne +1291 -> 2696
    //   1408: iconst_0
    //   1409: istore 21
    //   1411: aload 22
    //   1413: iload 21
    //   1415: invokevirtual 3157	com/tencent/mobileqq/data/Card:setPhotoUseCacheFlag	(Z)V
    //   1418: aload 24
    //   1420: getfield 3099	SummaryCard/RespSummaryCard:ulShowControl	J
    //   1423: ldc2_w 3158
    //   1426: land
    //   1427: lconst_0
    //   1428: lcmp
    //   1429: ifne +1273 -> 2702
    //   1432: iconst_0
    //   1433: istore 21
    //   1435: aload 22
    //   1437: iload 21
    //   1439: invokevirtual 3162	com/tencent/mobileqq/data/Card:setXManFlag	(Z)V
    //   1442: aload 22
    //   1444: aload 24
    //   1446: getfield 3165	SummaryCard/RespSummaryCard:strQzoneFeedsDesc	Ljava/lang/String;
    //   1449: putfield 3166	com/tencent/mobileqq/data/Card:strQzoneFeedsDesc	Ljava/lang/String;
    //   1452: aload 22
    //   1454: aload 24
    //   1456: getfield 3169	SummaryCard/RespSummaryCard:strSpaceName	Ljava/lang/String;
    //   1459: putfield 3170	com/tencent/mobileqq/data/Card:strSpaceName	Ljava/lang/String;
    //   1462: aload 22
    //   1464: aload 24
    //   1466: getfield 3173	SummaryCard/RespSummaryCard:strQzoneHeader	Ljava/lang/String;
    //   1469: putfield 3174	com/tencent/mobileqq/data/Card:strQzoneHeader	Ljava/lang/String;
    //   1472: aload 24
    //   1474: getfield 3177	SummaryCard/RespSummaryCard:mapQzoneEx	Ljava/util/Map;
    //   1477: ifnull +136 -> 1613
    //   1480: aload 24
    //   1482: getfield 3177	SummaryCard/RespSummaryCard:mapQzoneEx	Ljava/util/Map;
    //   1485: ldc_w 3179
    //   1488: invokeinterface 3184 2 0
    //   1493: checkcast 3186	java/lang/CharSequence
    //   1496: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1499: ifne +114 -> 1613
    //   1502: aload 24
    //   1504: getfield 3177	SummaryCard/RespSummaryCard:mapQzoneEx	Ljava/util/Map;
    //   1507: ldc_w 3179
    //   1510: invokeinterface 3184 2 0
    //   1515: checkcast 269	java/lang/String
    //   1518: astore_3
    //   1519: aload_3
    //   1520: astore_2
    //   1521: aload 22
    //   1523: getfield 3174	com/tencent/mobileqq/data/Card:strQzoneHeader	Ljava/lang/String;
    //   1526: ifnull +60 -> 1586
    //   1529: aload_3
    //   1530: astore_2
    //   1531: aload 22
    //   1533: getfield 3174	com/tencent/mobileqq/data/Card:strQzoneHeader	Ljava/lang/String;
    //   1536: invokevirtual 3189	java/lang/String:length	()I
    //   1539: bipush 10
    //   1541: if_icmple +45 -> 1586
    //   1544: aload_3
    //   1545: astore_2
    //   1546: aload_3
    //   1547: ifnull +39 -> 1586
    //   1550: aload_3
    //   1551: astore_2
    //   1552: aload_3
    //   1553: invokevirtual 3189	java/lang/String:length	()I
    //   1556: iconst_5
    //   1557: if_icmple +29 -> 1586
    //   1560: new 18	java/lang/StringBuilder
    //   1563: dup
    //   1564: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   1567: aload_3
    //   1568: iconst_0
    //   1569: iconst_5
    //   1570: invokevirtual 3193	java/lang/String:substring	(II)Ljava/lang/String;
    //   1573: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1576: ldc_w 3195
    //   1579: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1582: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1585: astore_2
    //   1586: aload 22
    //   1588: new 18	java/lang/StringBuilder
    //   1591: dup
    //   1592: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   1595: aload_2
    //   1596: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1599: aload 22
    //   1601: getfield 3174	com/tencent/mobileqq/data/Card:strQzoneHeader	Ljava/lang/String;
    //   1604: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1607: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1610: putfield 3174	com/tencent/mobileqq/data/Card:strQzoneHeader	Ljava/lang/String;
    //   1613: aload 22
    //   1615: aload 24
    //   1617: getfield 3198	SummaryCard/RespSummaryCard:vQzoneCoverInfo	[B
    //   1620: putfield 3199	com/tencent/mobileqq/data/Card:vQzoneCoverInfo	[B
    //   1623: aload 22
    //   1625: invokevirtual 3202	com/tencent/mobileqq/data/Card:isPhotoUseCache	()Z
    //   1628: ifne +34 -> 1662
    //   1631: aload 22
    //   1633: getfield 3205	com/tencent/mobileqq/data/Card:qzonePhotoList	Ljava/util/ArrayList;
    //   1636: invokevirtual 3206	java/util/ArrayList:clear	()V
    //   1639: aload 24
    //   1641: getfield 3210	SummaryCard/RespSummaryCard:oLatestPhotos	LSummaryCard/AlbumInfo;
    //   1644: astore_2
    //   1645: aload_2
    //   1646: ifnull +16 -> 1662
    //   1649: aload_2
    //   1650: getfield 3215	SummaryCard/AlbumInfo:vPhotos	Ljava/util/ArrayList;
    //   1653: ifnull +9 -> 1662
    //   1656: aload 22
    //   1658: aload_2
    //   1659: invokevirtual 3219	com/tencent/mobileqq/data/Card:addQzonePhotoList	(LSummaryCard/AlbumInfo;)V
    //   1662: aload 22
    //   1664: aload 24
    //   1666: getfield 3220	SummaryCard/RespSummaryCard:stVipInfo	LQQService/VipBaseInfo;
    //   1669: invokevirtual 3224	com/tencent/mobileqq/data/Card:setVipInfo	(LQQService/VipBaseInfo;)V
    //   1672: aload_1
    //   1673: getfield 281	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   1676: ldc_w 1293
    //   1679: invokevirtual 1430	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   1682: lstore 17
    //   1684: lconst_1
    //   1685: lload 17
    //   1687: land
    //   1688: lconst_0
    //   1689: lcmp
    //   1690: ifeq +71 -> 1761
    //   1693: aload 22
    //   1695: aload 24
    //   1697: getfield 3227	SummaryCard/RespSummaryCard:strShowName	Ljava/lang/String;
    //   1700: putfield 3228	com/tencent/mobileqq/data/Card:strShowName	Ljava/lang/String;
    //   1703: aload 22
    //   1705: getfield 3228	com/tencent/mobileqq/data/Card:strShowName	Ljava/lang/String;
    //   1708: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1711: ifeq +10 -> 1721
    //   1714: aload 22
    //   1716: aload 26
    //   1718: putfield 3228	com/tencent/mobileqq/data/Card:strShowName	Ljava/lang/String;
    //   1721: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1724: ifeq +37 -> 1761
    //   1727: ldc_w 1256
    //   1730: iconst_2
    //   1731: new 18	java/lang/StringBuilder
    //   1734: dup
    //   1735: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   1738: ldc_w 3230
    //   1741: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1744: aload 24
    //   1746: getfield 3227	SummaryCard/RespSummaryCard:strShowName	Ljava/lang/String;
    //   1749: invokestatic 3232	com/tencent/mobileqq/util/Utils:b	(Ljava/lang/String;)Ljava/lang/String;
    //   1752: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1755: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1758: invokestatic 687	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1761: ldc2_w 3233
    //   1764: lload 17
    //   1766: land
    //   1767: lconst_0
    //   1768: lcmp
    //   1769: ifeq +13 -> 1782
    //   1772: aload 22
    //   1774: aload 24
    //   1776: getfield 3237	SummaryCard/RespSummaryCard:uAccelerateMultiple	J
    //   1779: putfield 3238	com/tencent/mobileqq/data/Card:uAccelerateMultiple	J
    //   1782: ldc2_w 3142
    //   1785: lload 17
    //   1787: land
    //   1788: lconst_0
    //   1789: lcmp
    //   1790: ifeq +23 -> 1813
    //   1793: aload 22
    //   1795: aload 24
    //   1797: getfield 3239	SummaryCard/RespSummaryCard:vRichSign	[B
    //   1800: putfield 3240	com/tencent/mobileqq/data/Card:vRichSign	[B
    //   1803: aload 22
    //   1805: aload 24
    //   1807: getfield 3243	SummaryCard/RespSummaryCard:uSignModifyTime	J
    //   1810: putfield 3246	com/tencent/mobileqq/data/Card:lSignModifyTime	J
    //   1813: aload 24
    //   1815: getfield 3249	SummaryCard/RespSummaryCard:vRespLastGameInfo	[B
    //   1818: ifnull +30 -> 1848
    //   1821: aload 22
    //   1823: aload_0
    //   1824: aload 24
    //   1826: getfield 3249	SummaryCard/RespSummaryCard:vRespLastGameInfo	[B
    //   1829: ldc_w 3251
    //   1832: new 3253	GameCenter/RespLastGameInfo
    //   1835: dup
    //   1836: invokespecial 3254	GameCenter/RespLastGameInfo:<init>	()V
    //   1839: invokevirtual 1890	com/tencent/mobileqq/app/CardHandler:a	([BLjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1842: checkcast 3253	GameCenter/RespLastGameInfo
    //   1845: invokevirtual 3258	com/tencent/mobileqq/data/Card:updateLastGameInfo	(LGameCenter/RespLastGameInfo;)V
    //   1848: ldc2_w 3259
    //   1851: lload 17
    //   1853: land
    //   1854: lconst_0
    //   1855: lcmp
    //   1856: ifeq +153 -> 2009
    //   1859: new 1428	java/util/HashMap
    //   1862: dup
    //   1863: invokespecial 1429	java/util/HashMap:<init>	()V
    //   1866: astore_2
    //   1867: aload 24
    //   1869: getfield 3263	SummaryCard/RespSummaryCard:vRespTemplateInfo	[B
    //   1872: ifnull +836 -> 2708
    //   1875: aload_0
    //   1876: aload 24
    //   1878: getfield 3263	SummaryCard/RespSummaryCard:vRespTemplateInfo	[B
    //   1881: ldc_w 1884
    //   1884: new 1886	SummaryCardTaf/SSummaryCardRsp
    //   1887: dup
    //   1888: invokespecial 1887	SummaryCardTaf/SSummaryCardRsp:<init>	()V
    //   1891: invokevirtual 1890	com/tencent/mobileqq/app/CardHandler:a	([BLjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   1894: checkcast 1886	SummaryCardTaf/SSummaryCardRsp
    //   1897: astore_3
    //   1898: aload 22
    //   1900: aload_0
    //   1901: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1904: aload 26
    //   1906: aload_3
    //   1907: invokevirtual 3267	com/tencent/mobileqq/data/Card:updateCardTemplate	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;LSummaryCardTaf/SSummaryCardRsp;)V
    //   1910: aload_3
    //   1911: ifnull +98 -> 2009
    //   1914: aload_3
    //   1915: getfield 3271	SummaryCardTaf/SSummaryCardRsp:stRecom	LSummaryCardTaf/STRecommendInfo;
    //   1918: ifnull +91 -> 2009
    //   1921: aload_3
    //   1922: getfield 3271	SummaryCardTaf/SSummaryCardRsp:stRecom	LSummaryCardTaf/STRecommendInfo;
    //   1925: getfield 3276	SummaryCardTaf/STRecommendInfo:iRecomCard	J
    //   1928: lstore 19
    //   1930: aload_3
    //   1931: getfield 3271	SummaryCardTaf/SSummaryCardRsp:stRecom	LSummaryCardTaf/STRecommendInfo;
    //   1934: getfield 3279	SummaryCardTaf/STRecommendInfo:strRecomUrl	Ljava/lang/String;
    //   1937: astore_2
    //   1938: aload_3
    //   1939: getfield 3271	SummaryCardTaf/SSummaryCardRsp:stRecom	LSummaryCardTaf/STRecommendInfo;
    //   1942: getfield 3282	SummaryCardTaf/STRecommendInfo:strDesc	Ljava/lang/String;
    //   1945: astore_3
    //   1946: aload_2
    //   1947: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1950: ifne +59 -> 2009
    //   1953: aload_3
    //   1954: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1957: ifne +52 -> 2009
    //   1960: invokestatic 321	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   1963: ldc_w 3284
    //   1966: iconst_0
    //   1967: invokevirtual 327	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   1970: invokeinterface 241 1 0
    //   1975: ldc_w 3286
    //   1978: lload 19
    //   1980: invokeinterface 1627 4 0
    //   1985: ldc_w 3288
    //   1988: aload_2
    //   1989: invokeinterface 960 3 0
    //   1994: ldc_w 3290
    //   1997: aload_3
    //   1998: invokeinterface 960 3 0
    //   2003: invokeinterface 252 1 0
    //   2008: pop
    //   2009: ldc2_w 3291
    //   2012: lload 17
    //   2014: land
    //   2015: lconst_0
    //   2016: lcmp
    //   2017: ifeq +50 -> 2067
    //   2020: aload 22
    //   2022: aload 24
    //   2024: getfield 3295	SummaryCard/RespSummaryCard:lUserFlag	J
    //   2027: putfield 3296	com/tencent/mobileqq/data/Card:lUserFlag	J
    //   2030: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2033: ifeq +34 -> 2067
    //   2036: ldc_w 1256
    //   2039: iconst_2
    //   2040: new 18	java/lang/StringBuilder
    //   2043: dup
    //   2044: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   2047: ldc_w 3298
    //   2050: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2053: aload 22
    //   2055: getfield 3296	com/tencent/mobileqq/data/Card:lUserFlag	J
    //   2058: invokevirtual 326	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2061: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2064: invokestatic 687	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2067: ldc2_w 3158
    //   2070: lload 17
    //   2072: land
    //   2073: lconst_0
    //   2074: lcmp
    //   2075: ifeq +74 -> 2149
    //   2078: aload 22
    //   2080: aload 24
    //   2082: getfield 3301	SummaryCard/RespSummaryCard:uLoginDays	J
    //   2085: putfield 3304	com/tencent/mobileqq/data/Card:lLoginDays	J
    //   2088: aload 22
    //   2090: aload 24
    //   2092: getfield 3307	SummaryCard/RespSummaryCard:strLoginDesc	Ljava/lang/String;
    //   2095: putfield 3310	com/tencent/mobileqq/data/Card:strLoginDaysDesc	Ljava/lang/String;
    //   2098: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   2101: ifeq +48 -> 2149
    //   2104: ldc_w 1256
    //   2107: iconst_2
    //   2108: new 18	java/lang/StringBuilder
    //   2111: dup
    //   2112: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   2115: ldc_w 3312
    //   2118: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2121: aload 22
    //   2123: getfield 3304	com/tencent/mobileqq/data/Card:lLoginDays	J
    //   2126: invokevirtual 326	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   2129: ldc_w 3314
    //   2132: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2135: aload 22
    //   2137: getfield 3310	com/tencent/mobileqq/data/Card:strLoginDaysDesc	Ljava/lang/String;
    //   2140: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2143: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2146: invokestatic 687	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2149: aload 24
    //   2151: getfield 3318	SummaryCard/RespSummaryCard:stNowBroadcastInfo	LSummaryCard/TNowBroadcastInfo;
    //   2154: ifnull +89 -> 2243
    //   2157: aload 22
    //   2159: aload 24
    //   2161: getfield 3318	SummaryCard/RespSummaryCard:stNowBroadcastInfo	LSummaryCard/TNowBroadcastInfo;
    //   2164: getfield 3323	SummaryCard/TNowBroadcastInfo:iFlag	I
    //   2167: putfield 3326	com/tencent/mobileqq/data/Card:mNowShowFlag	I
    //   2170: aload 22
    //   2172: aload 24
    //   2174: getfield 3318	SummaryCard/RespSummaryCard:stNowBroadcastInfo	LSummaryCard/TNowBroadcastInfo;
    //   2177: getfield 3329	SummaryCard/TNowBroadcastInfo:strIconURL	Ljava/lang/String;
    //   2180: putfield 3332	com/tencent/mobileqq/data/Card:mNowShowIconUrl	Ljava/lang/String;
    //   2183: aload 22
    //   2185: aload 24
    //   2187: getfield 3318	SummaryCard/RespSummaryCard:stNowBroadcastInfo	LSummaryCard/TNowBroadcastInfo;
    //   2190: getfield 3335	SummaryCard/TNowBroadcastInfo:strHrefURL	Ljava/lang/String;
    //   2193: putfield 3338	com/tencent/mobileqq/data/Card:mNowShowJumpUrl	Ljava/lang/String;
    //   2196: aload 22
    //   2198: getfield 3326	com/tencent/mobileqq/data/Card:mNowShowFlag	I
    //   2201: iconst_1
    //   2202: if_icmpne +41 -> 2243
    //   2205: aload_0
    //   2206: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2209: ldc_w 3340
    //   2212: ldc_w 3342
    //   2215: ldc_w 705
    //   2218: ldc_w 3344
    //   2221: ldc_w 3346
    //   2224: iconst_0
    //   2225: iconst_0
    //   2226: aload 22
    //   2228: getfield 1755	com/tencent/mobileqq/data/Card:uin	Ljava/lang/String;
    //   2231: ldc_w 705
    //   2234: ldc_w 705
    //   2237: ldc_w 705
    //   2240: invokestatic 712	com/tencent/mobileqq/statistics/ReportController:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   2243: aload 24
    //   2245: getfield 3350	SummaryCard/RespSummaryCard:stCoverInfo	LSummaryCard/TCoverInfo;
    //   2248: ifnull +16 -> 2264
    //   2251: aload 22
    //   2253: aload 24
    //   2255: getfield 3350	SummaryCard/RespSummaryCard:stCoverInfo	LSummaryCard/TCoverInfo;
    //   2258: getfield 3355	SummaryCard/TCoverInfo:vTagInfo	[B
    //   2261: putfield 3358	com/tencent/mobileqq/data/Card:vCoverInfo	[B
    //   2264: aload 24
    //   2266: getfield 3361	SummaryCard/RespSummaryCard:stDiamonds	LQQService/VipBaseInfo;
    //   2269: ifnull +172 -> 2441
    //   2272: aload 24
    //   2274: getfield 3361	SummaryCard/RespSummaryCard:stDiamonds	LQQService/VipBaseInfo;
    //   2277: invokevirtual 3367	QQService/VipBaseInfo:getMOpenInfo	()Ljava/util/Map;
    //   2280: astore_2
    //   2281: aload_2
    //   2282: ifnull +159 -> 2441
    //   2285: aload_2
    //   2286: bipush 101
    //   2288: invokestatic 74	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2291: invokeinterface 3184 2 0
    //   2296: checkcast 3369	QQService/VipOpenInfo
    //   2299: astore_3
    //   2300: aload_3
    //   2301: getfield 3372	QQService/VipOpenInfo:bOpen	Z
    //   2304: ifeq +24 -> 2328
    //   2307: aload 22
    //   2309: iconst_1
    //   2310: putfield 3375	com/tencent/mobileqq/data/Card:isRedDiamond	Z
    //   2313: aload_3
    //   2314: getfield 3378	QQService/VipOpenInfo:iVipFlag	I
    //   2317: iconst_1
    //   2318: iand
    //   2319: ifle +9 -> 2328
    //   2322: aload 22
    //   2324: iconst_1
    //   2325: putfield 3381	com/tencent/mobileqq/data/Card:isSuperRedDiamond	Z
    //   2328: aload 22
    //   2330: aload_3
    //   2331: getfield 3384	QQService/VipOpenInfo:iVipLevel	I
    //   2334: putfield 3387	com/tencent/mobileqq/data/Card:redLevel	I
    //   2337: aload_2
    //   2338: bipush 102
    //   2340: invokestatic 74	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2343: invokeinterface 3184 2 0
    //   2348: checkcast 3369	QQService/VipOpenInfo
    //   2351: astore_3
    //   2352: aload_3
    //   2353: getfield 3372	QQService/VipOpenInfo:bOpen	Z
    //   2356: ifeq +24 -> 2380
    //   2359: aload 22
    //   2361: iconst_1
    //   2362: putfield 3390	com/tencent/mobileqq/data/Card:isYellowDiamond	Z
    //   2365: aload_3
    //   2366: getfield 3378	QQService/VipOpenInfo:iVipFlag	I
    //   2369: iconst_1
    //   2370: iand
    //   2371: ifle +9 -> 2380
    //   2374: aload 22
    //   2376: iconst_1
    //   2377: putfield 3393	com/tencent/mobileqq/data/Card:isSuperYellowDiamond	Z
    //   2380: aload 22
    //   2382: aload_3
    //   2383: getfield 3384	QQService/VipOpenInfo:iVipLevel	I
    //   2386: putfield 3396	com/tencent/mobileqq/data/Card:yellowLevel	I
    //   2389: aload_2
    //   2390: bipush 103
    //   2392: invokestatic 74	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   2395: invokeinterface 3184 2 0
    //   2400: checkcast 3369	QQService/VipOpenInfo
    //   2403: astore_2
    //   2404: aload_2
    //   2405: getfield 3372	QQService/VipOpenInfo:bOpen	Z
    //   2408: ifeq +24 -> 2432
    //   2411: aload 22
    //   2413: iconst_1
    //   2414: putfield 3399	com/tencent/mobileqq/data/Card:isGreenDiamond	Z
    //   2417: aload_2
    //   2418: getfield 3378	QQService/VipOpenInfo:iVipFlag	I
    //   2421: iconst_1
    //   2422: iand
    //   2423: ifle +9 -> 2432
    //   2426: aload 22
    //   2428: iconst_1
    //   2429: putfield 3402	com/tencent/mobileqq/data/Card:isSuperGreenDiamond	Z
    //   2432: aload 22
    //   2434: aload_2
    //   2435: getfield 3384	QQService/VipOpenInfo:iVipLevel	I
    //   2438: putfield 3405	com/tencent/mobileqq/data/Card:greenLevel	I
    //   2441: aload 24
    //   2443: getfield 3409	SummaryCard/RespSummaryCard:stPrivInfo	LQQService/PrivilegeBaseInfo;
    //   2446: ifnull +49 -> 2495
    //   2449: aload 24
    //   2451: getfield 3409	SummaryCard/RespSummaryCard:stPrivInfo	LQQService/PrivilegeBaseInfo;
    //   2454: astore_2
    //   2455: aload_2
    //   2456: ifnull +39 -> 2495
    //   2459: aload 22
    //   2461: aload_2
    //   2462: getfield 3414	QQService/PrivilegeBaseInfo:strMsg	Ljava/lang/String;
    //   2465: putfield 3417	com/tencent/mobileqq/data/Card:privilegePromptStr	Ljava/lang/String;
    //   2468: aload 22
    //   2470: aload_2
    //   2471: getfield 3420	QQService/PrivilegeBaseInfo:strJumpUrl	Ljava/lang/String;
    //   2474: putfield 3423	com/tencent/mobileqq/data/Card:privilegeJumpUrl	Ljava/lang/String;
    //   2477: aload 22
    //   2479: aload_2
    //   2480: getfield 3426	QQService/PrivilegeBaseInfo:vOpenPriv	Ljava/util/ArrayList;
    //   2483: invokevirtual 3429	com/tencent/mobileqq/data/Card:savePrivilegeOpenedInfo	(Ljava/util/List;)V
    //   2486: aload 22
    //   2488: aload_2
    //   2489: getfield 3432	QQService/PrivilegeBaseInfo:vClosePriv	Ljava/util/ArrayList;
    //   2492: invokevirtual 3435	com/tencent/mobileqq/data/Card:savePrivilegeClosedInfo	(Ljava/util/List;)V
    //   2495: new 51	java/util/ArrayList
    //   2498: dup
    //   2499: invokespecial 52	java/util/ArrayList:<init>	()V
    //   2502: astore_2
    //   2503: aload 24
    //   2505: getfield 3438	SummaryCard/RespSummaryCard:vvRespServicesBigOrder	Ljava/util/ArrayList;
    //   2508: ifnull +936 -> 3444
    //   2511: aload 24
    //   2513: getfield 3438	SummaryCard/RespSummaryCard:vvRespServicesBigOrder	Ljava/util/ArrayList;
    //   2516: invokevirtual 757	java/util/ArrayList:size	()I
    //   2519: ifle +925 -> 3444
    //   2522: iconst_0
    //   2523: istore 6
    //   2525: iload 6
    //   2527: aload 24
    //   2529: getfield 3438	SummaryCard/RespSummaryCard:vvRespServicesBigOrder	Ljava/util/ArrayList;
    //   2532: invokevirtual 757	java/util/ArrayList:size	()I
    //   2535: if_icmpge +909 -> 3444
    //   2538: aload 24
    //   2540: getfield 3438	SummaryCard/RespSummaryCard:vvRespServicesBigOrder	Ljava/util/ArrayList;
    //   2543: iload 6
    //   2545: invokevirtual 1651	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   2548: checkcast 125	[B
    //   2551: astore_3
    //   2552: aload_3
    //   2553: ifnonnull +195 -> 2748
    //   2556: iconst_0
    //   2557: istore 7
    //   2559: iload 7
    //   2561: bipush 10
    //   2563: if_icmpgt +192 -> 2755
    //   2566: iload 6
    //   2568: iconst_1
    //   2569: iadd
    //   2570: istore 6
    //   2572: goto -47 -> 2525
    //   2575: aload 22
    //   2577: iconst_0
    //   2578: putfield 3063	com/tencent/mobileqq/data/Card:showLightalk	Z
    //   2581: aload 22
    //   2583: aconst_null
    //   2584: putfield 3067	com/tencent/mobileqq/data/Card:lightalkNick	Ljava/lang/String;
    //   2587: aload 22
    //   2589: aconst_null
    //   2590: putfield 3076	com/tencent/mobileqq/data/Card:lightalkId	Ljava/lang/String;
    //   2593: goto -1698 -> 895
    //   2596: invokestatic 736	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   2599: ifeq -1626 -> 973
    //   2602: ldc_w 3078
    //   2605: iconst_4
    //   2606: ldc_w 3440
    //   2609: invokestatic 687	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   2612: goto -1639 -> 973
    //   2615: aload 22
    //   2617: iconst_0
    //   2618: putfield 1218	com/tencent/mobileqq/data/Card:bVoted	B
    //   2621: goto -1539 -> 1082
    //   2624: aload_2
    //   2625: invokevirtual 3139	com/tencent/mobileqq/data/NearbyPeopleCard:getStatus	()I
    //   2628: sipush 1001
    //   2631: if_icmpeq +13 -> 2644
    //   2634: aload_2
    //   2635: invokevirtual 3139	com/tencent/mobileqq/data/NearbyPeopleCard:getStatus	()I
    //   2638: sipush 1002
    //   2641: if_icmpne -1336 -> 1305
    //   2644: aload 4
    //   2646: aload_2
    //   2647: invokevirtual 1789	com/tencent/mobileqq/persistence/EntityManager:a	(Lcom/tencent/mobileqq/persistence/Entity;)Z
    //   2650: pop
    //   2651: goto -1346 -> 1305
    //   2654: aload 22
    //   2656: aload 24
    //   2658: getfield 3028	SummaryCard/RespSummaryCard:iVoteCount	I
    //   2661: i2l
    //   2662: putfield 1215	com/tencent/mobileqq/data/Card:lVoteCount	J
    //   2665: aload 22
    //   2667: aload 24
    //   2669: getfield 3108	SummaryCard/RespSummaryCard:iLastestVoteCount	I
    //   2672: putfield 3111	com/tencent/mobileqq/data/Card:iVoteIncrement	I
    //   2675: goto -1365 -> 1310
    //   2678: iconst_1
    //   2679: istore 21
    //   2681: goto -1354 -> 1327
    //   2684: iconst_1
    //   2685: istore 21
    //   2687: goto -1320 -> 1367
    //   2690: iconst_1
    //   2691: istore 21
    //   2693: goto -1302 -> 1391
    //   2696: iconst_1
    //   2697: istore 21
    //   2699: goto -1288 -> 1411
    //   2702: iconst_1
    //   2703: istore 21
    //   2705: goto -1270 -> 1435
    //   2708: aload_2
    //   2709: ldc_w 1444
    //   2712: ldc_w 3442
    //   2715: invokevirtual 1449	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   2718: pop
    //   2719: aload_0
    //   2720: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   2723: invokevirtual 229	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   2726: invokestatic 1454	com/tencent/mobileqq/statistics/StatisticCollector:a	(Landroid/content/Context;)Lcom/tencent/mobileqq/statistics/StatisticCollector;
    //   2729: aload 26
    //   2731: ldc_w 3444
    //   2734: iconst_0
    //   2735: lconst_0
    //   2736: lconst_0
    //   2737: aconst_null
    //   2738: ldc_w 705
    //   2741: iconst_0
    //   2742: invokevirtual 1459	com/tencent/mobileqq/statistics/StatisticCollector:a	(Ljava/lang/String;Ljava/lang/String;ZJJLjava/util/HashMap;Ljava/lang/String;Z)V
    //   2745: goto -736 -> 2009
    //   2748: aload_3
    //   2749: arraylength
    //   2750: istore 7
    //   2752: goto -193 -> 2559
    //   2755: aload_3
    //   2756: iconst_1
    //   2757: invokestatic 3449	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI)J
    //   2760: l2i
    //   2761: istore 8
    //   2763: aload_3
    //   2764: iconst_5
    //   2765: invokestatic 3449	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI)J
    //   2768: l2i
    //   2769: istore 9
    //   2771: iload 8
    //   2773: ifle -207 -> 2566
    //   2776: iload 8
    //   2778: bipush 9
    //   2780: iadd
    //   2781: iload 7
    //   2783: if_icmpge -217 -> 2566
    //   2786: iload 8
    //   2788: newarray byte
    //   2790: astore 4
    //   2792: aload 4
    //   2794: iconst_0
    //   2795: aload_3
    //   2796: bipush 9
    //   2798: iload 8
    //   2800: invokestatic 3452	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI[BII)V
    //   2803: new 3454	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm
    //   2806: dup
    //   2807: invokespecial 3455	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:<init>	()V
    //   2810: astore_3
    //   2811: aload_3
    //   2812: aload 4
    //   2814: invokevirtual 3456	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2817: pop
    //   2818: aload_3
    //   2819: getfield 3458	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   2822: invokevirtual 803	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   2825: istore 9
    //   2827: new 3460	com/tencent/mobileqq/profile/ProfileSummaryHobbiesEntry
    //   2830: dup
    //   2831: invokespecial 3461	com/tencent/mobileqq/profile/ProfileSummaryHobbiesEntry:<init>	()V
    //   2834: astore 4
    //   2836: iload 9
    //   2838: ifne +531 -> 3369
    //   2841: aload 4
    //   2843: aload_3
    //   2844: getfield 3465	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:msg_rich_display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui;
    //   2847: getfield 3469	com/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui:strName	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2850: invokevirtual 369	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2853: putfield 3470	com/tencent/mobileqq/profile/ProfileSummaryHobbiesEntry:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2856: aload 4
    //   2858: aload_3
    //   2859: getfield 3465	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:msg_rich_display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui;
    //   2862: getfield 3473	com/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui:strServiceUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2865: invokevirtual 369	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2868: putfield 3474	com/tencent/mobileqq/profile/ProfileSummaryHobbiesEntry:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2871: aload 4
    //   2873: aload_3
    //   2874: getfield 3477	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:service	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   2877: invokevirtual 138	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   2880: putfield 3478	com/tencent/mobileqq/profile/ProfileSummaryHobbiesEntry:jdField_a_of_type_Int	I
    //   2883: new 51	java/util/ArrayList
    //   2886: dup
    //   2887: invokespecial 52	java/util/ArrayList:<init>	()V
    //   2890: astore 27
    //   2892: iconst_0
    //   2893: istore 7
    //   2895: iload 7
    //   2897: aload_3
    //   2898: getfield 3465	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:msg_rich_display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui;
    //   2901: getfield 3481	com/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui:rptUiList	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2904: invokevirtual 1705	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   2907: if_icmpge +455 -> 3362
    //   2910: aload_3
    //   2911: getfield 3465	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:msg_rich_display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui;
    //   2914: getfield 3481	com/tencent/pb/profilecard/SummaryCardBusiEntry$rich_ui:rptUiList	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   2917: iload 7
    //   2919: invokevirtual 1711	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   2922: checkcast 3483	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info
    //   2925: astore 28
    //   2927: new 3485	com/tencent/mobileqq/profile/ProfileSummaryHobbiesItem
    //   2930: dup
    //   2931: invokespecial 3486	com/tencent/mobileqq/profile/ProfileSummaryHobbiesItem:<init>	()V
    //   2934: astore 29
    //   2936: aload 29
    //   2938: aload 28
    //   2940: getfield 3489	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strTitle	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2943: invokevirtual 369	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2946: putfield 3490	com/tencent/mobileqq/profile/ProfileSummaryHobbiesItem:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   2949: aload 29
    //   2951: aload 28
    //   2953: getfield 3493	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strCoverUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2956: invokevirtual 369	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2959: putfield 3494	com/tencent/mobileqq/profile/ProfileSummaryHobbiesItem:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   2962: aload 29
    //   2964: aload 28
    //   2966: getfield 3497	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strJmpUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2969: invokevirtual 369	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2972: putfield 3499	com/tencent/mobileqq/profile/ProfileSummaryHobbiesItem:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   2975: aload 29
    //   2977: aload 28
    //   2979: getfield 3502	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strSubInfo	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2982: invokevirtual 369	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2985: putfield 3504	com/tencent/mobileqq/profile/ProfileSummaryHobbiesItem:d	Ljava/lang/String;
    //   2988: aload 29
    //   2990: aload 28
    //   2992: getfield 3506	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strDesc	Lcom/tencent/mobileqq/pb/PBStringField;
    //   2995: invokevirtual 369	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   2998: putfield 3508	com/tencent/mobileqq/profile/ProfileSummaryHobbiesItem:e	Ljava/lang/String;
    //   3001: aload 29
    //   3003: aload 28
    //   3005: getfield 3511	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:strTitleIconUrl	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3008: invokevirtual 369	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3011: putfield 3512	com/tencent/mobileqq/profile/ProfileSummaryHobbiesItem:f	Ljava/lang/String;
    //   3014: aload 29
    //   3016: aload 28
    //   3018: getfield 3515	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   3021: invokevirtual 360	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   3024: putfield 3516	com/tencent/mobileqq/profile/ProfileSummaryHobbiesItem:jdField_a_of_type_Long	J
    //   3027: aload 29
    //   3029: aload 4
    //   3031: getfield 3478	com/tencent/mobileqq/profile/ProfileSummaryHobbiesEntry:jdField_a_of_type_Int	I
    //   3034: putfield 3517	com/tencent/mobileqq/profile/ProfileSummaryHobbiesItem:jdField_a_of_type_Int	I
    //   3037: iload 6
    //   3039: ifne +14 -> 3053
    //   3042: iload 7
    //   3044: ifne +264 -> 3308
    //   3047: aload 29
    //   3049: iconst_0
    //   3050: putfield 3518	com/tencent/mobileqq/profile/ProfileSummaryHobbiesItem:jdField_b_of_type_Int	I
    //   3053: aload 28
    //   3055: getfield 3521	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:rptGroupTagList	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   3058: invokevirtual 1705	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   3061: ifle +284 -> 3345
    //   3064: new 51	java/util/ArrayList
    //   3067: dup
    //   3068: invokespecial 52	java/util/ArrayList:<init>	()V
    //   3071: astore 30
    //   3073: iconst_0
    //   3074: istore 8
    //   3076: iload 8
    //   3078: aload 28
    //   3080: getfield 3521	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:rptGroupTagList	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   3083: invokevirtual 1705	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   3086: if_icmpge +252 -> 3338
    //   3089: aload 28
    //   3091: getfield 3521	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui_info:rptGroupTagList	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   3094: iload 8
    //   3096: invokevirtual 1711	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3099: checkcast 3523	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label
    //   3102: astore 31
    //   3104: new 3525	com/tencent/mobileqq/profile/ProfileGroupLabel
    //   3107: dup
    //   3108: invokespecial 3526	com/tencent/mobileqq/profile/ProfileGroupLabel:<init>	()V
    //   3111: astore 32
    //   3113: aload 32
    //   3115: aload 31
    //   3117: getfield 3529	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:bytes_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   3120: invokevirtual 152	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   3123: invokevirtual 3532	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   3126: putfield 3533	com/tencent/mobileqq/profile/ProfileGroupLabel:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3129: aload 32
    //   3131: aload 31
    //   3133: getfield 3536	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:uint32_label_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3136: invokevirtual 138	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3139: i2l
    //   3140: putfield 3537	com/tencent/mobileqq/profile/ProfileGroupLabel:jdField_a_of_type_Long	J
    //   3143: aload 32
    //   3145: aload 31
    //   3147: getfield 3540	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:uint32_label_attr	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3150: invokevirtual 138	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3153: i2l
    //   3154: putfield 3541	com/tencent/mobileqq/profile/ProfileGroupLabel:jdField_b_of_type_Long	J
    //   3157: new 3543	com/tencent/mobileqq/profile/ProfileColor
    //   3160: dup
    //   3161: invokespecial 3544	com/tencent/mobileqq/profile/ProfileColor:<init>	()V
    //   3164: astore 33
    //   3166: aload 33
    //   3168: aload 31
    //   3170: getfield 3548	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:edging_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   3173: getfield 3553	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_r	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3176: invokevirtual 138	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3179: i2l
    //   3180: putfield 3554	com/tencent/mobileqq/profile/ProfileColor:jdField_a_of_type_Long	J
    //   3183: aload 33
    //   3185: aload 31
    //   3187: getfield 3548	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:edging_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   3190: getfield 3557	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_g	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3193: invokevirtual 138	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3196: i2l
    //   3197: putfield 3558	com/tencent/mobileqq/profile/ProfileColor:jdField_b_of_type_Long	J
    //   3200: aload 33
    //   3202: aload 31
    //   3204: getfield 3548	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:edging_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   3207: getfield 3561	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_b	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3210: invokevirtual 138	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3213: i2l
    //   3214: putfield 3563	com/tencent/mobileqq/profile/ProfileColor:c	J
    //   3217: aload 32
    //   3219: aload 33
    //   3221: putfield 3566	com/tencent/mobileqq/profile/ProfileGroupLabel:jdField_b_of_type_ComTencentMobileqqProfileProfileColor	Lcom/tencent/mobileqq/profile/ProfileColor;
    //   3224: new 3543	com/tencent/mobileqq/profile/ProfileColor
    //   3227: dup
    //   3228: invokespecial 3544	com/tencent/mobileqq/profile/ProfileColor:<init>	()V
    //   3231: astore 33
    //   3233: aload 33
    //   3235: aload 31
    //   3237: getfield 3569	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:text_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   3240: getfield 3553	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_r	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3243: invokevirtual 138	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3246: i2l
    //   3247: putfield 3554	com/tencent/mobileqq/profile/ProfileColor:jdField_a_of_type_Long	J
    //   3250: aload 33
    //   3252: aload 31
    //   3254: getfield 3569	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:text_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   3257: getfield 3557	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_g	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3260: invokevirtual 138	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3263: i2l
    //   3264: putfield 3558	com/tencent/mobileqq/profile/ProfileColor:jdField_b_of_type_Long	J
    //   3267: aload 33
    //   3269: aload 31
    //   3271: getfield 3569	com/tencent/pb/profilecard/SummaryCardBusiEntry$Label:text_color	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$Color;
    //   3274: getfield 3561	com/tencent/pb/profilecard/SummaryCardBusiEntry$Color:uint32_b	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3277: invokevirtual 138	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3280: i2l
    //   3281: putfield 3563	com/tencent/mobileqq/profile/ProfileColor:c	J
    //   3284: aload 32
    //   3286: aload 33
    //   3288: putfield 3571	com/tencent/mobileqq/profile/ProfileGroupLabel:jdField_a_of_type_ComTencentMobileqqProfileProfileColor	Lcom/tencent/mobileqq/profile/ProfileColor;
    //   3291: aload 30
    //   3293: aload 32
    //   3295: invokevirtual 1164	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3298: pop
    //   3299: iload 8
    //   3301: iconst_1
    //   3302: iadd
    //   3303: istore 8
    //   3305: goto -229 -> 3076
    //   3308: aload 29
    //   3310: iconst_1
    //   3311: putfield 3518	com/tencent/mobileqq/profile/ProfileSummaryHobbiesItem:jdField_b_of_type_Int	I
    //   3314: goto -261 -> 3053
    //   3317: astore_3
    //   3318: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3321: ifeq -755 -> 2566
    //   3324: ldc_w 1256
    //   3327: iconst_2
    //   3328: aload_3
    //   3329: invokevirtual 2887	java/lang/Exception:toString	()Ljava/lang/String;
    //   3332: invokestatic 687	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3335: goto -769 -> 2566
    //   3338: aload 29
    //   3340: aload 30
    //   3342: putfield 3572	com/tencent/mobileqq/profile/ProfileSummaryHobbiesItem:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   3345: aload 27
    //   3347: aload 29
    //   3349: invokevirtual 1164	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   3352: pop
    //   3353: iload 7
    //   3355: iconst_1
    //   3356: iadd
    //   3357: istore 7
    //   3359: goto -464 -> 2895
    //   3362: aload 4
    //   3364: aload 27
    //   3366: putfield 3573	com/tencent/mobileqq/profile/ProfileSummaryHobbiesEntry:jdField_a_of_type_JavaUtilArrayList	Ljava/util/ArrayList;
    //   3369: aload_2
    //   3370: aload 4
    //   3372: invokeinterface 1738 2 0
    //   3377: pop
    //   3378: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3381: ifeq -815 -> 2566
    //   3384: ldc_w 1256
    //   3387: iconst_2
    //   3388: new 18	java/lang/StringBuilder
    //   3391: dup
    //   3392: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   3395: ldc_w 3575
    //   3398: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3401: aload_3
    //   3402: getfield 3477	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:service	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3405: invokevirtual 138	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3408: invokevirtual 572	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3411: ldc_w 3577
    //   3414: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3417: iload 9
    //   3419: invokevirtual 572	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3422: ldc_w 3579
    //   3425: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3428: aload_3
    //   3429: getfield 3582	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:err_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3432: invokevirtual 667	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   3435: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3438: invokestatic 687	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3441: goto -875 -> 2566
    //   3444: aload 22
    //   3446: aload_2
    //   3447: invokevirtual 3585	com/tencent/mobileqq/data/Card:saveBigOrderEntrys	(Ljava/util/List;)V
    //   3450: new 51	java/util/ArrayList
    //   3453: dup
    //   3454: invokespecial 52	java/util/ArrayList:<init>	()V
    //   3457: astore_2
    //   3458: aload 24
    //   3460: getfield 3588	SummaryCard/RespSummaryCard:vvRespServices	Ljava/util/ArrayList;
    //   3463: ifnull +377 -> 3840
    //   3466: aload 24
    //   3468: getfield 3588	SummaryCard/RespSummaryCard:vvRespServices	Ljava/util/ArrayList;
    //   3471: invokevirtual 757	java/util/ArrayList:size	()I
    //   3474: ifle +366 -> 3840
    //   3477: iconst_0
    //   3478: istore 6
    //   3480: iload 6
    //   3482: aload 24
    //   3484: getfield 3588	SummaryCard/RespSummaryCard:vvRespServices	Ljava/util/ArrayList;
    //   3487: invokevirtual 757	java/util/ArrayList:size	()I
    //   3490: if_icmpge +350 -> 3840
    //   3493: aload 24
    //   3495: getfield 3588	SummaryCard/RespSummaryCard:vvRespServices	Ljava/util/ArrayList;
    //   3498: iload 6
    //   3500: invokevirtual 1651	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   3503: checkcast 125	[B
    //   3506: astore 4
    //   3508: aload 4
    //   3510: ifnonnull +22 -> 3532
    //   3513: iconst_0
    //   3514: istore 7
    //   3516: iload 7
    //   3518: bipush 10
    //   3520: if_icmpgt +20 -> 3540
    //   3523: iload 6
    //   3525: iconst_1
    //   3526: iadd
    //   3527: istore 6
    //   3529: goto -49 -> 3480
    //   3532: aload 4
    //   3534: arraylength
    //   3535: istore 7
    //   3537: goto -21 -> 3516
    //   3540: aload 4
    //   3542: iconst_1
    //   3543: invokestatic 3449	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI)J
    //   3546: l2i
    //   3547: istore 8
    //   3549: aload 4
    //   3551: iconst_5
    //   3552: invokestatic 3449	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI)J
    //   3555: l2i
    //   3556: istore 9
    //   3558: iload 8
    //   3560: ifle -37 -> 3523
    //   3563: iload 8
    //   3565: bipush 9
    //   3567: iadd
    //   3568: iload 7
    //   3570: if_icmpge -47 -> 3523
    //   3573: iload 8
    //   3575: newarray byte
    //   3577: astore_3
    //   3578: aload_3
    //   3579: iconst_0
    //   3580: aload 4
    //   3582: bipush 9
    //   3584: iload 8
    //   3586: invokestatic 3452	com/tencent/mobileqq/utils/httputils/PkgTools:a	([BI[BII)V
    //   3589: new 3454	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm
    //   3592: dup
    //   3593: invokespecial 3455	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:<init>	()V
    //   3596: astore 4
    //   3598: aload 4
    //   3600: aload_3
    //   3601: invokevirtual 3456	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3604: pop
    //   3605: aload 4
    //   3607: getfield 3458	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:result	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   3610: invokevirtual 803	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   3613: istore 7
    //   3615: iload 7
    //   3617: ifne +106 -> 3723
    //   3620: new 3590	com/tencent/mobileqq/profile/ProfileBusiEntry
    //   3623: dup
    //   3624: invokespecial 3591	com/tencent/mobileqq/profile/ProfileBusiEntry:<init>	()V
    //   3627: astore_3
    //   3628: aload_3
    //   3629: aload 4
    //   3631: getfield 3477	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:service	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3634: invokevirtual 138	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3637: putfield 3592	com/tencent/mobileqq/profile/ProfileBusiEntry:jdField_a_of_type_Int	I
    //   3640: aload 4
    //   3642: getfield 3596	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   3645: ifnull +164 -> 3809
    //   3648: aload_3
    //   3649: aload 4
    //   3651: getfield 3596	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   3654: getfield 3600	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui:url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3657: invokevirtual 369	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3660: putfield 3601	com/tencent/mobileqq/profile/ProfileBusiEntry:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3663: aload_3
    //   3664: aload 4
    //   3666: getfield 3596	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   3669: getfield 3604	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui:title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3672: invokevirtual 369	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3675: putfield 3605	com/tencent/mobileqq/profile/ProfileBusiEntry:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3678: aload_3
    //   3679: aload 4
    //   3681: getfield 3596	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   3684: getfield 3608	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui:content	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3687: invokevirtual 369	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3690: putfield 3609	com/tencent/mobileqq/profile/ProfileBusiEntry:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   3693: aload_3
    //   3694: aload 4
    //   3696: getfield 3596	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   3699: getfield 3612	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui:jump_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3702: invokevirtual 369	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3705: putfield 3613	com/tencent/mobileqq/profile/ProfileBusiEntry:d	Ljava/lang/String;
    //   3708: aload_3
    //   3709: invokevirtual 3614	com/tencent/mobileqq/profile/ProfileBusiEntry:a	()Z
    //   3712: ifne +11 -> 3723
    //   3715: aload_2
    //   3716: aload_3
    //   3717: invokeinterface 1738 2 0
    //   3722: pop
    //   3723: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3726: ifeq -203 -> 3523
    //   3729: ldc_w 1256
    //   3732: iconst_2
    //   3733: invokestatic 443	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   3736: ldc_w 3616
    //   3739: iconst_3
    //   3740: anewarray 447	java/lang/Object
    //   3743: dup
    //   3744: iconst_0
    //   3745: iload 7
    //   3747: invokestatic 74	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3750: aastore
    //   3751: dup
    //   3752: iconst_1
    //   3753: aload 4
    //   3755: getfield 3477	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:service	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3758: invokevirtual 138	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3761: invokestatic 74	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   3764: aastore
    //   3765: dup
    //   3766: iconst_2
    //   3767: aload 4
    //   3769: getfield 3596	com/tencent/pb/profilecard/SummaryCardBusiEntry$comm:display	Lcom/tencent/pb/profilecard/SummaryCardBusiEntry$ui;
    //   3772: getfield 3604	com/tencent/pb/profilecard/SummaryCardBusiEntry$ui:title	Lcom/tencent/mobileqq/pb/PBStringField;
    //   3775: invokevirtual 369	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   3778: aastore
    //   3779: invokestatic 451	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   3782: invokestatic 687	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3785: goto -262 -> 3523
    //   3788: astore_3
    //   3789: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3792: ifeq -269 -> 3523
    //   3795: ldc_w 1256
    //   3798: iconst_2
    //   3799: aload_3
    //   3800: invokevirtual 2887	java/lang/Exception:toString	()Ljava/lang/String;
    //   3803: invokestatic 687	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3806: goto -283 -> 3523
    //   3809: aload_3
    //   3810: ldc_w 705
    //   3813: putfield 3601	com/tencent/mobileqq/profile/ProfileBusiEntry:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   3816: aload_3
    //   3817: ldc_w 705
    //   3820: putfield 3605	com/tencent/mobileqq/profile/ProfileBusiEntry:jdField_b_of_type_JavaLangString	Ljava/lang/String;
    //   3823: aload_3
    //   3824: ldc_w 705
    //   3827: putfield 3609	com/tencent/mobileqq/profile/ProfileBusiEntry:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   3830: aload_3
    //   3831: ldc_w 705
    //   3834: putfield 3613	com/tencent/mobileqq/profile/ProfileBusiEntry:d	Ljava/lang/String;
    //   3837: goto -129 -> 3708
    //   3840: new 482	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData
    //   3843: dup
    //   3844: invokespecial 3617	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:<init>	()V
    //   3847: astore_3
    //   3848: aload 24
    //   3850: getfield 3620	SummaryCard/RespSummaryCard:vResp0x5ebInfo	[B
    //   3853: ifnull +783 -> 4636
    //   3856: aload_3
    //   3857: aload 24
    //   3859: getfield 3620	SummaryCard/RespSummaryCard:vResp0x5ebInfo	[B
    //   3862: invokevirtual 3621	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   3865: pop
    //   3866: aload 26
    //   3868: aload_0
    //   3869: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   3872: invokevirtual 117	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   3875: invokevirtual 275	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   3878: ifeq +72 -> 3950
    //   3881: aload_3
    //   3882: getfield 3624	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:int32_history_num_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3885: invokevirtual 397	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   3888: ifeq +62 -> 3950
    //   3891: aload_3
    //   3892: getfield 3624	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:int32_history_num_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   3895: invokevirtual 138	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   3898: istore 6
    //   3900: aload_0
    //   3901: getfield 613	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   3904: invokevirtual 3625	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   3907: aload_0
    //   3908: invokevirtual 3626	com/tencent/mobileqq/app/CardHandler:c	()Ljava/lang/String;
    //   3911: iload 6
    //   3913: invokestatic 3629	com/tencent/mobileqq/utils/SharedPreUtils:P	(Landroid/content/Context;Ljava/lang/String;I)V
    //   3916: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3919: ifeq +31 -> 3950
    //   3922: ldc_w 1256
    //   3925: iconst_2
    //   3926: new 18	java/lang/StringBuilder
    //   3929: dup
    //   3930: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   3933: ldc_w 3631
    //   3936: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   3939: iload 6
    //   3941: invokevirtual 572	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   3944: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   3947: invokestatic 687	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   3950: aload 23
    //   3952: aload 26
    //   3954: invokevirtual 3634	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   3957: astore 4
    //   3959: aload_3
    //   3960: getfield 3637	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint64_game_appid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   3963: invokevirtual 3638	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   3966: ifeq +60 -> 4026
    //   3969: aload_3
    //   3970: getfield 3637	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint64_game_appid	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   3973: invokevirtual 360	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   3976: lstore 19
    //   3978: aload 22
    //   3980: lload 19
    //   3982: putfield 3641	com/tencent/mobileqq/data/Card:namePlateOfKingGameId	J
    //   3985: aload 4
    //   3987: lload 19
    //   3989: putfield 3644	com/tencent/mobileqq/data/Friends:namePlateOfKingGameId	J
    //   3992: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3995: ifeq +31 -> 4026
    //   3998: ldc_w 1256
    //   4001: iconst_2
    //   4002: new 18	java/lang/StringBuilder
    //   4005: dup
    //   4006: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   4009: ldc_w 3646
    //   4012: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4015: lload 19
    //   4017: invokevirtual 326	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4020: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4023: invokestatic 687	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4026: aload_3
    //   4027: getfield 3649	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint64_game_last_login_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   4030: invokevirtual 3638	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   4033: ifeq +60 -> 4093
    //   4036: aload_3
    //   4037: getfield 3649	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint64_game_last_login_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   4040: invokevirtual 360	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   4043: lstore 19
    //   4045: aload 22
    //   4047: lload 19
    //   4049: putfield 3652	com/tencent/mobileqq/data/Card:namePlateOfKingLoginTime	J
    //   4052: aload 4
    //   4054: lload 19
    //   4056: putfield 3653	com/tencent/mobileqq/data/Friends:namePlateOfKingLoginTime	J
    //   4059: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4062: ifeq +31 -> 4093
    //   4065: ldc_w 1256
    //   4068: iconst_2
    //   4069: new 18	java/lang/StringBuilder
    //   4072: dup
    //   4073: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   4076: ldc_w 3655
    //   4079: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4082: lload 19
    //   4084: invokevirtual 326	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   4087: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4090: invokestatic 687	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4093: aload_3
    //   4094: getfield 3658	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_plate_of_king_dan	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4097: invokevirtual 397	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4100: ifeq +60 -> 4160
    //   4103: aload_3
    //   4104: getfield 3658	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_plate_of_king_dan	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4107: invokevirtual 138	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4110: istore 6
    //   4112: aload 22
    //   4114: iload 6
    //   4116: putfield 3661	com/tencent/mobileqq/data/Card:namePlateOfKingDan	I
    //   4119: aload 4
    //   4121: iload 6
    //   4123: putfield 3662	com/tencent/mobileqq/data/Friends:namePlateOfKingDan	I
    //   4126: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4129: ifeq +31 -> 4160
    //   4132: ldc_w 1256
    //   4135: iconst_2
    //   4136: new 18	java/lang/StringBuilder
    //   4139: dup
    //   4140: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   4143: ldc_w 3664
    //   4146: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4149: iload 6
    //   4151: invokevirtual 572	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4154: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4157: invokestatic 687	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4160: aload_3
    //   4161: getfield 3667	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_plate_of_king_dan_display_switch	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4164: invokevirtual 397	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4167: ifeq +161 -> 4328
    //   4170: aload_3
    //   4171: getfield 3667	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_plate_of_king_dan_display_switch	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4174: invokevirtual 138	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4177: istore 6
    //   4179: iload 6
    //   4181: iconst_1
    //   4182: if_icmpne +1310 -> 5492
    //   4185: iconst_1
    //   4186: istore 21
    //   4188: aload 22
    //   4190: iload 21
    //   4192: putfield 3670	com/tencent/mobileqq/data/Card:namePlateOfKingDanDisplatSwitch	Z
    //   4195: iload 6
    //   4197: iconst_1
    //   4198: if_icmpne +1300 -> 5498
    //   4201: iconst_1
    //   4202: istore 21
    //   4204: aload 4
    //   4206: iload 21
    //   4208: putfield 3671	com/tencent/mobileqq/data/Friends:namePlateOfKingDanDisplatSwitch	Z
    //   4211: aload 26
    //   4213: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   4216: ifne +78 -> 4294
    //   4219: aload_0
    //   4220: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4223: invokevirtual 458	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   4226: aload 26
    //   4228: invokevirtual 275	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4231: ifeq +63 -> 4294
    //   4234: aload_0
    //   4235: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4238: invokevirtual 229	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   4241: ldc_w 3673
    //   4244: iconst_0
    //   4245: invokevirtual 235	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   4248: invokeinterface 241 1 0
    //   4253: new 18	java/lang/StringBuilder
    //   4256: dup
    //   4257: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   4260: ldc_w 3675
    //   4263: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4266: aload_0
    //   4267: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4270: invokevirtual 458	com/tencent/mobileqq/app/QQAppInterface:c	()Ljava/lang/String;
    //   4273: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4276: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4279: aload 4
    //   4281: getfield 3671	com/tencent/mobileqq/data/Friends:namePlateOfKingDanDisplatSwitch	Z
    //   4284: invokeinterface 333 3 0
    //   4289: invokeinterface 2674 1 0
    //   4294: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4297: ifeq +31 -> 4328
    //   4300: ldc_w 1256
    //   4303: iconst_2
    //   4304: new 18	java/lang/StringBuilder
    //   4307: dup
    //   4308: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   4311: ldc_w 3677
    //   4314: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4317: iload 6
    //   4319: invokevirtual 572	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4322: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4325: invokestatic 687	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4328: aload_3
    //   4329: getfield 3680	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_suspend_effect_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4332: invokevirtual 397	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4335: ifeq +81 -> 4416
    //   4338: aload_3
    //   4339: getfield 3680	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_suspend_effect_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4342: invokevirtual 138	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4345: istore 6
    //   4347: iload 6
    //   4349: iflt +22 -> 4371
    //   4352: aload_0
    //   4353: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4356: bipush 13
    //   4358: invokevirtual 564	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   4361: checkcast 2514	com/tencent/mobileqq/app/SVIPHandler
    //   4364: aload 26
    //   4366: iload 6
    //   4368: invokevirtual 3682	com/tencent/mobileqq/app/SVIPHandler:a	(Ljava/lang/String;I)V
    //   4371: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4374: ifeq +42 -> 4416
    //   4377: ldc_w 1256
    //   4380: iconst_2
    //   4381: new 18	java/lang/StringBuilder
    //   4384: dup
    //   4385: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   4388: ldc_w 3684
    //   4391: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4394: aload 26
    //   4396: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4399: ldc_w 3686
    //   4402: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4405: iload 6
    //   4407: invokevirtual 572	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4410: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4413: invokestatic 687	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4416: aload_3
    //   4417: getfield 3689	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_vas_face_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4420: invokevirtual 397	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4423: ifeq +35 -> 4458
    //   4426: aload_3
    //   4427: getfield 3689	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_vas_face_id	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4430: invokevirtual 138	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4433: istore 6
    //   4435: aload_0
    //   4436: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4439: sipush 234
    //   4442: invokevirtual 112	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   4445: checkcast 3691	com/tencent/mobileqq/vas/VasExtensionManager
    //   4448: getfield 3694	com/tencent/mobileqq/vas/VasExtensionManager:a	Lcom/tencent/mobileqq/avatar/dynamicavatar/VasFaceManager;
    //   4451: aload 26
    //   4453: iload 6
    //   4455: invokevirtual 3698	com/tencent/mobileqq/avatar/dynamicavatar/VasFaceManager:b	(Ljava/lang/String;I)V
    //   4458: aload_3
    //   4459: getfield 3701	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_extend_friend_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4462: invokevirtual 397	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4465: ifeq +97 -> 4562
    //   4468: aload_3
    //   4469: getfield 3701	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_extend_friend_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4472: invokevirtual 138	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4475: istore 6
    //   4477: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4480: ifeq +42 -> 4522
    //   4483: ldc_w 1256
    //   4486: iconst_2
    //   4487: new 18	java/lang/StringBuilder
    //   4490: dup
    //   4491: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   4494: ldc_w 3684
    //   4497: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4500: aload 26
    //   4502: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4505: ldc_w 3703
    //   4508: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4511: iload 6
    //   4513: invokevirtual 572	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4516: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4519: invokestatic 687	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4522: aload 22
    //   4524: iload 6
    //   4526: putfield 3706	com/tencent/mobileqq/data/Card:extendFriendFlag	I
    //   4529: aload_0
    //   4530: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4533: invokevirtual 117	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   4536: ldc_w 2664
    //   4539: invokestatic 2669	com/tencent/mobileqq/utils/SharedPreUtils:a	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences;
    //   4542: invokeinterface 241 1 0
    //   4547: ldc_w 3708
    //   4550: iload 6
    //   4552: invokeinterface 249 3 0
    //   4557: invokeinterface 2674 1 0
    //   4562: aload_3
    //   4563: getfield 3711	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_extend_friend_card_shown	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4566: invokevirtual 397	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   4569: ifeq +67 -> 4636
    //   4572: aload_3
    //   4573: getfield 3711	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_extend_friend_card_shown	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4576: invokevirtual 138	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4579: istore 6
    //   4581: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4584: ifeq +3430 -> 8014
    //   4587: ldc_w 1256
    //   4590: iconst_2
    //   4591: new 18	java/lang/StringBuilder
    //   4594: dup
    //   4595: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   4598: ldc_w 3684
    //   4601: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4604: aload 26
    //   4606: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4609: ldc_w 3713
    //   4612: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   4615: iload 6
    //   4617: invokevirtual 572	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   4620: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   4623: invokestatic 687	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4626: goto +3388 -> 8014
    //   4629: aload 22
    //   4631: iload 21
    //   4633: putfield 2252	com/tencent/mobileqq/data/Card:isShowCard	Z
    //   4636: aload 22
    //   4638: aload_2
    //   4639: invokevirtual 3716	com/tencent/mobileqq/data/Card:saveBusiEntrys	(Ljava/util/List;)V
    //   4642: aload 22
    //   4644: getfield 3296	com/tencent/mobileqq/data/Card:lUserFlag	J
    //   4647: ldc2_w 3291
    //   4650: land
    //   4651: lconst_0
    //   4652: lcmp
    //   4653: ifeq +878 -> 5531
    //   4656: aload 22
    //   4658: iconst_1
    //   4659: putfield 3719	com/tencent/mobileqq/data/Card:allowClick	Z
    //   4662: aload 26
    //   4664: aload_0
    //   4665: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4668: invokevirtual 117	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   4671: invokevirtual 275	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   4674: ifne +23 -> 4697
    //   4677: aload 22
    //   4679: getfield 3296	com/tencent/mobileqq/data/Card:lUserFlag	J
    //   4682: ldc2_w 3158
    //   4685: land
    //   4686: lconst_0
    //   4687: lcmp
    //   4688: ifeq +852 -> 5540
    //   4691: aload 22
    //   4693: iconst_1
    //   4694: putfield 190	com/tencent/mobileqq/data/Card:allowPeopleSee	Z
    //   4697: aload 24
    //   4699: getfield 3723	SummaryCard/RespSummaryCard:stVideoHeadInfo	LSummaryCard/TVideoHeadInfo;
    //   4702: ifnull +230 -> 4932
    //   4705: aload 24
    //   4707: getfield 3723	SummaryCard/RespSummaryCard:stVideoHeadInfo	LSummaryCard/TVideoHeadInfo;
    //   4710: getfield 3728	SummaryCard/TVideoHeadInfo:iBasicFlag	I
    //   4713: iconst_1
    //   4714: if_icmpne +835 -> 5549
    //   4717: iconst_1
    //   4718: istore 21
    //   4720: aload 22
    //   4722: iload 21
    //   4724: putfield 3731	com/tencent/mobileqq/data/Card:videoHeadFlag	Z
    //   4727: new 3733	tencent/im/oidb/cmd0x74b/oidb_0x74b$RspBody
    //   4730: dup
    //   4731: invokespecial 3734	tencent/im/oidb/cmd0x74b/oidb_0x74b$RspBody:<init>	()V
    //   4734: astore_2
    //   4735: aload 22
    //   4737: getfield 3731	com/tencent/mobileqq/data/Card:videoHeadFlag	Z
    //   4740: ifeq +27 -> 4767
    //   4743: aload 24
    //   4745: getfield 3723	SummaryCard/RespSummaryCard:stVideoHeadInfo	LSummaryCard/TVideoHeadInfo;
    //   4748: getfield 3737	SummaryCard/TVideoHeadInfo:vMsg	[B
    //   4751: ifnull +16 -> 4767
    //   4754: aload_2
    //   4755: aload 24
    //   4757: getfield 3723	SummaryCard/RespSummaryCard:stVideoHeadInfo	LSummaryCard/TVideoHeadInfo;
    //   4760: getfield 3737	SummaryCard/TVideoHeadInfo:vMsg	[B
    //   4763: invokevirtual 3738	tencent/im/oidb/cmd0x74b/oidb_0x74b$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   4766: pop
    //   4767: aload_2
    //   4768: getfield 3741	tencent/im/oidb/cmd0x74b/oidb_0x74b$RspBody:rpt_msg_uin_head_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4771: invokevirtual 471	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   4774: ifeq +158 -> 4932
    //   4777: aload_2
    //   4778: getfield 3741	tencent/im/oidb/cmd0x74b/oidb_0x74b$RspBody:rpt_msg_uin_head_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4781: invokevirtual 474	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   4784: astore_2
    //   4785: aload_2
    //   4786: ifnull +146 -> 4932
    //   4789: aload_2
    //   4790: invokeinterface 477 1 0
    //   4795: ifle +137 -> 4932
    //   4798: aload_2
    //   4799: iconst_0
    //   4800: invokeinterface 480 2 0
    //   4805: checkcast 3743	tencent/im/oidb/cmd0x74b/oidb_0x74b$OneUinHeadInfo
    //   4808: astore_2
    //   4809: aload_2
    //   4810: getfield 3746	tencent/im/oidb/cmd0x74b/oidb_0x74b$OneUinHeadInfo:rpt_msg_head_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4813: invokevirtual 471	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   4816: ifeq +116 -> 4932
    //   4819: aload_2
    //   4820: getfield 3746	tencent/im/oidb/cmd0x74b/oidb_0x74b$OneUinHeadInfo:rpt_msg_head_list	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4823: invokevirtual 474	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   4826: astore_2
    //   4827: aload_2
    //   4828: ifnull +104 -> 4932
    //   4831: aload_2
    //   4832: invokeinterface 791 1 0
    //   4837: astore_2
    //   4838: aload_2
    //   4839: invokeinterface 766 1 0
    //   4844: ifeq +88 -> 4932
    //   4847: aload_2
    //   4848: invokeinterface 770 1 0
    //   4853: checkcast 3748	tencent/im/oidb/cmd0x74b/oidb_0x74b$HeadInfo
    //   4856: astore_3
    //   4857: aload_3
    //   4858: getfield 3749	tencent/im/oidb/cmd0x74b/oidb_0x74b$HeadInfo:uint32_type	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4861: invokevirtual 138	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4864: bipush 17
    //   4866: if_icmpne -28 -> 4838
    //   4869: aload_3
    //   4870: getfield 3752	tencent/im/oidb/cmd0x74b/oidb_0x74b$HeadInfo:rpt_videoheadlist	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   4873: invokevirtual 474	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   4876: astore_2
    //   4877: aload_2
    //   4878: ifnull +54 -> 4932
    //   4881: aload_2
    //   4882: invokeinterface 791 1 0
    //   4887: astore_2
    //   4888: aload_2
    //   4889: invokeinterface 766 1 0
    //   4894: ifeq +38 -> 4932
    //   4897: aload_2
    //   4898: invokeinterface 770 1 0
    //   4903: checkcast 3754	tencent/im/oidb/cmd0x74b/oidb_0x74b$VideoHeadInfo
    //   4906: astore_3
    //   4907: aload_3
    //   4908: getfield 3757	tencent/im/oidb/cmd0x74b/oidb_0x74b$VideoHeadInfo:uint32_video_size	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   4911: invokevirtual 138	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   4914: sipush 640
    //   4917: if_icmpne -29 -> 4888
    //   4920: aload 22
    //   4922: aload_3
    //   4923: getfield 3760	tencent/im/oidb/cmd0x74b/oidb_0x74b$VideoHeadInfo:str_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   4926: invokevirtual 369	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   4929: putfield 3763	com/tencent/mobileqq/data/Card:videoHeadUrl	Ljava/lang/String;
    //   4932: aload 24
    //   4934: getfield 3767	SummaryCard/RespSummaryCard:stOlympicInfo	LSummaryCard/OlympicInfo;
    //   4937: ifnull +626 -> 5563
    //   4940: aload 24
    //   4942: getfield 3767	SummaryCard/RespSummaryCard:stOlympicInfo	LSummaryCard/OlympicInfo;
    //   4945: getfield 3772	SummaryCard/OlympicInfo:iTorch	I
    //   4948: ifle +615 -> 5563
    //   4951: aload 22
    //   4953: iconst_1
    //   4954: putfield 3775	com/tencent/mobileqq/data/Card:olympicTorch	B
    //   4957: aload_0
    //   4958: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4961: sipush 166
    //   4964: invokevirtual 112	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   4967: checkcast 3777	com/tencent/mobileqq/olympic/OlympicManager
    //   4970: astore_2
    //   4971: aload 24
    //   4973: getfield 3780	SummaryCard/RespSummaryCard:vRespQQStoryInfo	[B
    //   4976: ifnull +167 -> 5143
    //   4979: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   4982: ifeq +13 -> 4995
    //   4985: ldc_w 682
    //   4988: iconst_2
    //   4989: ldc_w 3782
    //   4992: invokestatic 687	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   4995: new 3784	tencent/im/group/group_member_info$RspGroupCardGetStory
    //   4998: dup
    //   4999: invokespecial 3785	tencent/im/group/group_member_info$RspGroupCardGetStory:<init>	()V
    //   5002: astore_2
    //   5003: aload_2
    //   5004: aload 24
    //   5006: getfield 3780	SummaryCard/RespSummaryCard:vRespQQStoryInfo	[B
    //   5009: invokevirtual 3786	tencent/im/group/group_member_info$RspGroupCardGetStory:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   5012: pop
    //   5013: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5016: ifeq +84 -> 5100
    //   5019: ldc_w 682
    //   5022: iconst_2
    //   5023: new 18	java/lang/StringBuilder
    //   5026: dup
    //   5027: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   5030: ldc_w 3788
    //   5033: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5036: aload_2
    //   5037: getfield 3791	tencent/im/group/group_member_info$RspGroupCardGetStory:flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5040: invokevirtual 138	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5043: invokevirtual 572	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5046: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5049: invokestatic 687	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5052: aload_2
    //   5053: getfield 3794	tencent/im/group/group_member_info$RspGroupCardGetStory:video_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   5056: invokevirtual 471	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   5059: ifeq +41 -> 5100
    //   5062: ldc_w 682
    //   5065: iconst_2
    //   5066: new 18	java/lang/StringBuilder
    //   5069: dup
    //   5070: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   5073: ldc_w 3796
    //   5076: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5079: aload_2
    //   5080: getfield 3794	tencent/im/group/group_member_info$RspGroupCardGetStory:video_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   5083: invokevirtual 474	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   5086: invokeinterface 477 1 0
    //   5091: invokevirtual 572	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5094: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5097: invokestatic 687	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5100: aload_2
    //   5101: getfield 3791	tencent/im/group/group_member_info$RspGroupCardGetStory:flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   5104: invokevirtual 138	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   5107: iconst_1
    //   5108: if_icmpne +464 -> 5572
    //   5111: iconst_1
    //   5112: istore 21
    //   5114: aload 22
    //   5116: iload 21
    //   5118: putfield 3799	com/tencent/mobileqq/data/Card:mHasStory	Z
    //   5121: aload_2
    //   5122: getfield 3794	tencent/im/group/group_member_info$RspGroupCardGetStory:video_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   5125: invokevirtual 471	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   5128: ifeq +15 -> 5143
    //   5131: aload 22
    //   5133: aload_2
    //   5134: getfield 3794	tencent/im/group/group_member_info$RspGroupCardGetStory:video_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   5137: invokevirtual 474	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   5140: invokevirtual 3802	com/tencent/mobileqq/data/Card:addQQStoryList	(Ljava/util/List;)V
    //   5143: aload 24
    //   5145: getfield 3805	SummaryCard/RespSummaryCard:vRespCustomLabelInfo	[B
    //   5148: ifnull +45 -> 5193
    //   5151: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5154: ifeq +13 -> 5167
    //   5157: ldc_w 682
    //   5160: iconst_2
    //   5161: ldc_w 3807
    //   5164: invokestatic 687	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5167: aload 24
    //   5169: getfield 3805	SummaryCard/RespSummaryCard:vRespCustomLabelInfo	[B
    //   5172: invokestatic 3813	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabel:convertFromPbBytes	([B)Lcom/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabel;
    //   5175: astore_2
    //   5176: aload_2
    //   5177: invokestatic 3817	com/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabel:convertToBytes	(Lcom/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabel;)[B
    //   5180: astore_3
    //   5181: aload 22
    //   5183: aload_2
    //   5184: putfield 3821	com/tencent/mobileqq/data/Card:personalityLabel	Lcom/tencent/mobileqq/profile/PersonalityLabel/PersonalityLabel;
    //   5187: aload 22
    //   5189: aload_3
    //   5190: putfield 3824	com/tencent/mobileqq/data/Card:vPersonalityLabelV2	[B
    //   5193: aload 24
    //   5195: getfield 3828	SummaryCard/RespSummaryCard:stMedalWallInfo	LSummaryCard/TMedalWallInfo;
    //   5198: ifnull +555 -> 5753
    //   5201: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5204: ifeq +45 -> 5249
    //   5207: new 18	java/lang/StringBuilder
    //   5210: dup
    //   5211: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   5214: astore_2
    //   5215: aload 24
    //   5217: getfield 3828	SummaryCard/RespSummaryCard:stMedalWallInfo	LSummaryCard/TMedalWallInfo;
    //   5220: aload_2
    //   5221: iconst_0
    //   5222: invokevirtual 3831	SummaryCard/TMedalWallInfo:display	(Ljava/lang/StringBuilder;I)V
    //   5225: ldc_w 738
    //   5228: iconst_2
    //   5229: iconst_2
    //   5230: anewarray 447	java/lang/Object
    //   5233: dup
    //   5234: iconst_0
    //   5235: ldc_w 3833
    //   5238: aastore
    //   5239: dup
    //   5240: iconst_1
    //   5241: aload_2
    //   5242: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5245: aastore
    //   5246: invokestatic 2653	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   5249: aload 22
    //   5251: aload 24
    //   5253: getfield 3828	SummaryCard/RespSummaryCard:stMedalWallInfo	LSummaryCard/TMedalWallInfo;
    //   5256: getfield 975	SummaryCard/TMedalWallInfo:iMedalCount	I
    //   5259: putfield 3834	com/tencent/mobileqq/data/Card:iMedalCount	I
    //   5262: aload 24
    //   5264: getfield 3828	SummaryCard/RespSummaryCard:stMedalWallInfo	LSummaryCard/TMedalWallInfo;
    //   5267: getfield 971	SummaryCard/TMedalWallInfo:iOpenFlag	I
    //   5270: iconst_1
    //   5271: if_icmpne +347 -> 5618
    //   5274: iconst_1
    //   5275: istore 21
    //   5277: aload 22
    //   5279: iload 21
    //   5281: putfield 315	com/tencent/mobileqq/data/Card:medalSwitchDisable	Z
    //   5284: aload 24
    //   5286: getfield 3828	SummaryCard/RespSummaryCard:stMedalWallInfo	LSummaryCard/TMedalWallInfo;
    //   5289: getfield 979	SummaryCard/TMedalWallInfo:iNewCount	I
    //   5292: istore 10
    //   5294: aload 24
    //   5296: getfield 3828	SummaryCard/RespSummaryCard:stMedalWallInfo	LSummaryCard/TMedalWallInfo;
    //   5299: getfield 983	SummaryCard/TMedalWallInfo:iUpgradeCount	I
    //   5302: istore 11
    //   5304: aload 24
    //   5306: getfield 3828	SummaryCard/RespSummaryCard:stMedalWallInfo	LSummaryCard/TMedalWallInfo;
    //   5309: getfield 987	SummaryCard/TMedalWallInfo:strPromptParams	Ljava/lang/String;
    //   5312: astore_2
    //   5313: iload 10
    //   5315: ifgt +8 -> 5323
    //   5318: iload 11
    //   5320: ifle +2671 -> 7991
    //   5323: aload_2
    //   5324: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   5327: ifne +2664 -> 7991
    //   5330: aload 22
    //   5332: getfield 1755	com/tencent/mobileqq/data/Card:uin	Ljava/lang/String;
    //   5335: aload_0
    //   5336: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5339: invokevirtual 117	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   5342: invokestatic 3837	com/tencent/mobileqq/util/Utils:a	(Ljava/lang/Object;Ljava/lang/Object;)Z
    //   5345: ifeq +2646 -> 7991
    //   5348: iconst_0
    //   5349: istore 12
    //   5351: iconst_0
    //   5352: istore 6
    //   5354: iconst_0
    //   5355: istore 13
    //   5357: iconst_0
    //   5358: istore 7
    //   5360: aload_0
    //   5361: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5364: sipush 249
    //   5367: invokevirtual 112	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   5370: checkcast 830	com/tencent/mobileqq/medalwall/MedalWallMng
    //   5373: aload_2
    //   5374: invokevirtual 3839	com/tencent/mobileqq/medalwall/MedalWallMng:a	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   5377: astore_3
    //   5378: iload 13
    //   5380: istore 8
    //   5382: iload 12
    //   5384: istore 9
    //   5386: aload_3
    //   5387: ifnull +272 -> 5659
    //   5390: iload 13
    //   5392: istore 8
    //   5394: iload 12
    //   5396: istore 9
    //   5398: aload_3
    //   5399: invokevirtual 757	java/util/ArrayList:size	()I
    //   5402: ifle +257 -> 5659
    //   5405: aload_3
    //   5406: invokevirtual 761	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   5409: astore_3
    //   5410: iload 7
    //   5412: istore 8
    //   5414: iload 6
    //   5416: istore 9
    //   5418: aload_3
    //   5419: invokeinterface 766 1 0
    //   5424: ifeq +235 -> 5659
    //   5427: aload_3
    //   5428: invokeinterface 770 1 0
    //   5433: checkcast 772	com/tencent/mobileqq/medalwall/MedalID
    //   5436: astore 4
    //   5438: aload 4
    //   5440: ifnull -30 -> 5410
    //   5443: aload 4
    //   5445: getfield 778	com/tencent/mobileqq/medalwall/MedalID:jdField_b_of_type_Int	I
    //   5448: iconst_1
    //   5449: if_icmpeq +14 -> 5463
    //   5452: aload 4
    //   5454: getfield 778	com/tencent/mobileqq/medalwall/MedalID:jdField_b_of_type_Int	I
    //   5457: sipush 255
    //   5460: if_icmpne +164 -> 5624
    //   5463: iload 7
    //   5465: istore 8
    //   5467: iload 6
    //   5469: iconst_1
    //   5470: iadd
    //   5471: istore 7
    //   5473: iload 8
    //   5475: istore 6
    //   5477: iload 7
    //   5479: istore 8
    //   5481: iload 6
    //   5483: istore 7
    //   5485: iload 8
    //   5487: istore 6
    //   5489: goto -79 -> 5410
    //   5492: iconst_0
    //   5493: istore 21
    //   5495: goto -1307 -> 4188
    //   5498: iconst_0
    //   5499: istore 21
    //   5501: goto -1297 -> 4204
    //   5504: iconst_0
    //   5505: istore 21
    //   5507: goto -878 -> 4629
    //   5510: astore_3
    //   5511: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5514: ifeq -878 -> 4636
    //   5517: ldc_w 1256
    //   5520: iconst_2
    //   5521: aload_3
    //   5522: invokevirtual 2887	java/lang/Exception:toString	()Ljava/lang/String;
    //   5525: invokestatic 687	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5528: goto -892 -> 4636
    //   5531: aload 22
    //   5533: iconst_0
    //   5534: putfield 3719	com/tencent/mobileqq/data/Card:allowClick	Z
    //   5537: goto -875 -> 4662
    //   5540: aload 22
    //   5542: iconst_0
    //   5543: putfield 190	com/tencent/mobileqq/data/Card:allowPeopleSee	Z
    //   5546: goto -849 -> 4697
    //   5549: iconst_0
    //   5550: istore 21
    //   5552: goto -832 -> 4720
    //   5555: astore_3
    //   5556: aload_3
    //   5557: invokevirtual 3840	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   5560: goto -793 -> 4767
    //   5563: aload 22
    //   5565: iconst_0
    //   5566: putfield 3775	com/tencent/mobileqq/data/Card:olympicTorch	B
    //   5569: goto -612 -> 4957
    //   5572: iconst_0
    //   5573: istore 21
    //   5575: goto -461 -> 5114
    //   5578: astore_2
    //   5579: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5582: ifeq -439 -> 5143
    //   5585: ldc_w 682
    //   5588: iconst_2
    //   5589: new 18	java/lang/StringBuilder
    //   5592: dup
    //   5593: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   5596: ldc_w 3842
    //   5599: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5602: aload_2
    //   5603: invokevirtual 3843	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   5606: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5609: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5612: invokestatic 2058	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   5615: goto -472 -> 5143
    //   5618: iconst_0
    //   5619: istore 21
    //   5621: goto -344 -> 5277
    //   5624: aload 4
    //   5626: getfield 778	com/tencent/mobileqq/medalwall/MedalID:jdField_b_of_type_Int	I
    //   5629: iconst_2
    //   5630: if_icmpeq +12 -> 5642
    //   5633: aload 4
    //   5635: getfield 778	com/tencent/mobileqq/medalwall/MedalID:jdField_b_of_type_Int	I
    //   5638: iconst_3
    //   5639: if_icmpne +2337 -> 7976
    //   5642: iload 7
    //   5644: iconst_1
    //   5645: iadd
    //   5646: istore 8
    //   5648: iload 6
    //   5650: istore 7
    //   5652: iload 8
    //   5654: istore 6
    //   5656: goto -179 -> 5477
    //   5659: iload 8
    //   5661: istore 6
    //   5663: iload 9
    //   5665: istore 7
    //   5667: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5670: ifeq +63 -> 5733
    //   5673: ldc_w 738
    //   5676: iconst_2
    //   5677: invokestatic 443	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   5680: ldc_w 3845
    //   5683: iconst_4
    //   5684: anewarray 447	java/lang/Object
    //   5687: dup
    //   5688: iconst_0
    //   5689: iload 10
    //   5691: invokestatic 74	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   5694: aastore
    //   5695: dup
    //   5696: iconst_1
    //   5697: iload 11
    //   5699: invokestatic 74	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   5702: aastore
    //   5703: dup
    //   5704: iconst_2
    //   5705: iload 9
    //   5707: invokestatic 74	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   5710: aastore
    //   5711: dup
    //   5712: iconst_3
    //   5713: iload 8
    //   5715: invokestatic 74	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   5718: aastore
    //   5719: invokestatic 451	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   5722: invokestatic 687	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5725: iload 9
    //   5727: istore 7
    //   5729: iload 8
    //   5731: istore 6
    //   5733: aload 22
    //   5735: iload 7
    //   5737: putfield 3846	com/tencent/mobileqq/data/Card:iNewCount	I
    //   5740: aload 22
    //   5742: iload 6
    //   5744: putfield 3847	com/tencent/mobileqq/data/Card:iUpgradeCount	I
    //   5747: aload 22
    //   5749: aload_2
    //   5750: putfield 3848	com/tencent/mobileqq/data/Card:strPromptParams	Ljava/lang/String;
    //   5753: aload 23
    //   5755: aload 22
    //   5757: invokevirtual 208	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   5760: pop
    //   5761: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5764: ifeq +94 -> 5858
    //   5767: new 18	java/lang/StringBuilder
    //   5770: dup
    //   5771: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   5774: astore_2
    //   5775: aload_2
    //   5776: ldc_w 3312
    //   5779: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5782: aload 22
    //   5784: getfield 3304	com/tencent/mobileqq/data/Card:lLoginDays	J
    //   5787: invokevirtual 326	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   5790: ldc_w 3850
    //   5793: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5796: aload 22
    //   5798: getfield 3310	com/tencent/mobileqq/data/Card:strLoginDaysDesc	Ljava/lang/String;
    //   5801: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5804: ldc_w 3852
    //   5807: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5810: aload 22
    //   5812: getfield 3719	com/tencent/mobileqq/data/Card:allowClick	Z
    //   5815: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5818: ldc_w 3854
    //   5821: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5824: aload 22
    //   5826: getfield 190	com/tencent/mobileqq/data/Card:allowPeopleSee	Z
    //   5829: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   5832: ldc_w 3856
    //   5835: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   5838: aload 22
    //   5840: getfield 3101	com/tencent/mobileqq/data/Card:ulShowControl	I
    //   5843: invokevirtual 572	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   5846: pop
    //   5847: ldc_w 1256
    //   5850: iconst_2
    //   5851: aload_2
    //   5852: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   5855: invokestatic 687	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   5858: aload 23
    //   5860: aload 26
    //   5862: invokevirtual 3859	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/ExtensionInfo;
    //   5865: astore_2
    //   5866: aload_2
    //   5867: ifnonnull +2106 -> 7973
    //   5870: new 3861	com/tencent/mobileqq/data/ExtensionInfo
    //   5873: dup
    //   5874: invokespecial 3862	com/tencent/mobileqq/data/ExtensionInfo:<init>	()V
    //   5877: astore_2
    //   5878: aload_2
    //   5879: aload 26
    //   5881: putfield 3863	com/tencent/mobileqq/data/ExtensionInfo:uin	Ljava/lang/String;
    //   5884: aload_2
    //   5885: aload 24
    //   5887: getfield 3866	SummaryCard/RespSummaryCard:ulFaceAddonId	J
    //   5890: putfield 3869	com/tencent/mobileqq/data/ExtensionInfo:pendantId	J
    //   5893: aload_2
    //   5894: invokestatic 2931	java/lang/System:currentTimeMillis	()J
    //   5897: putfield 3871	com/tencent/mobileqq/data/ExtensionInfo:timestamp	J
    //   5900: aload_0
    //   5901: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   5904: sipush 152
    //   5907: invokevirtual 112	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   5910: checkcast 2277	com/tencent/mobileqq/apollo/ApolloManager
    //   5913: astore_3
    //   5914: aload 24
    //   5916: getfield 3875	SummaryCard/RespSummaryCard:stApollo	LSummaryCard/QQApolloInfo;
    //   5919: ifnull +1641 -> 7560
    //   5922: aload_3
    //   5923: aload 26
    //   5925: invokevirtual 2280	com/tencent/mobileqq/apollo/ApolloManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/ApolloBaseInfo;
    //   5928: astore 4
    //   5930: aload 4
    //   5932: aload 24
    //   5934: getfield 3875	SummaryCard/RespSummaryCard:stApollo	LSummaryCard/QQApolloInfo;
    //   5937: getfield 3880	SummaryCard/QQApolloInfo:uVipFlag	J
    //   5940: l2i
    //   5941: putfield 2534	com/tencent/mobileqq/data/ApolloBaseInfo:apolloVipFlag	I
    //   5944: aload 4
    //   5946: aload 24
    //   5948: getfield 3875	SummaryCard/RespSummaryCard:stApollo	LSummaryCard/QQApolloInfo;
    //   5951: getfield 3883	SummaryCard/QQApolloInfo:uVipLevel	J
    //   5954: l2i
    //   5955: putfield 2541	com/tencent/mobileqq/data/ApolloBaseInfo:apolloVipLevel	I
    //   5958: aload 4
    //   5960: aload 24
    //   5962: getfield 3875	SummaryCard/RespSummaryCard:stApollo	LSummaryCard/QQApolloInfo;
    //   5965: getfield 3886	SummaryCard/QQApolloInfo:uUserFlag	J
    //   5968: l2i
    //   5969: putfield 2546	com/tencent/mobileqq/data/ApolloBaseInfo:apolloStatus	I
    //   5972: aload 4
    //   5974: aload 24
    //   5976: getfield 3875	SummaryCard/RespSummaryCard:stApollo	LSummaryCard/QQApolloInfo;
    //   5979: getfield 3889	SummaryCard/QQApolloInfo:uTimestamp	J
    //   5982: putfield 2558	com/tencent/mobileqq/data/ApolloBaseInfo:apolloServerTS	J
    //   5985: aload_3
    //   5986: aload 4
    //   5988: invokevirtual 2691	com/tencent/mobileqq/apollo/ApolloManager:a	(Lcom/tencent/mobileqq/data/ApolloBaseInfo;)V
    //   5991: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5994: ifeq +101 -> 6095
    //   5997: ldc_w 682
    //   6000: iconst_2
    //   6001: new 18	java/lang/StringBuilder
    //   6004: dup
    //   6005: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   6008: ldc_w 3891
    //   6011: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6014: aload 26
    //   6016: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6019: ldc_w 3893
    //   6022: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6025: aload 4
    //   6027: getfield 2534	com/tencent/mobileqq/data/ApolloBaseInfo:apolloVipFlag	I
    //   6030: invokevirtual 572	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6033: ldc_w 3895
    //   6036: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6039: aload 4
    //   6041: getfield 2541	com/tencent/mobileqq/data/ApolloBaseInfo:apolloVipLevel	I
    //   6044: invokevirtual 572	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6047: ldc_w 3897
    //   6050: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6053: aload 4
    //   6055: getfield 2546	com/tencent/mobileqq/data/ApolloBaseInfo:apolloStatus	I
    //   6058: invokevirtual 572	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   6061: ldc_w 3899
    //   6064: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6067: aload 4
    //   6069: getfield 2558	com/tencent/mobileqq/data/ApolloBaseInfo:apolloServerTS	J
    //   6072: invokevirtual 326	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6075: ldc_w 3901
    //   6078: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6081: aload 4
    //   6083: getfield 2697	com/tencent/mobileqq/data/ApolloBaseInfo:apolloLocalTS	J
    //   6086: invokevirtual 326	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6089: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6092: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6095: aload 4
    //   6097: getfield 2558	com/tencent/mobileqq/data/ApolloBaseInfo:apolloServerTS	J
    //   6100: aload 4
    //   6102: getfield 2697	com/tencent/mobileqq/data/ApolloBaseInfo:apolloLocalTS	J
    //   6105: lcmp
    //   6106: ifeq +92 -> 6198
    //   6109: aload_0
    //   6110: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6113: bipush 71
    //   6115: invokevirtual 564	com/tencent/mobileqq/app/QQAppInterface:a	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   6118: checkcast 2548	com/tencent/mobileqq/vas/VasExtensionHandler
    //   6121: astore_3
    //   6122: aload_3
    //   6123: ifnull +75 -> 6198
    //   6126: new 51	java/util/ArrayList
    //   6129: dup
    //   6130: iconst_1
    //   6131: invokespecial 1550	java/util/ArrayList:<init>	(I)V
    //   6134: astore 4
    //   6136: aload 4
    //   6138: aload 26
    //   6140: invokestatic 1224	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   6143: invokestatic 604	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   6146: invokevirtual 1164	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   6149: pop
    //   6150: aload_3
    //   6151: aload 4
    //   6153: ldc_w 3903
    //   6156: invokevirtual 2705	com/tencent/mobileqq/vas/VasExtensionHandler:a	(Ljava/util/ArrayList;Ljava/lang/String;)V
    //   6159: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6162: ifeq +36 -> 6198
    //   6165: ldc_w 682
    //   6168: iconst_2
    //   6169: new 18	java/lang/StringBuilder
    //   6172: dup
    //   6173: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   6176: ldc_w 3905
    //   6179: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6182: aload 26
    //   6184: iconst_0
    //   6185: iconst_4
    //   6186: invokevirtual 3193	java/lang/String:substring	(II)Ljava/lang/String;
    //   6189: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6192: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6195: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6198: aload 23
    //   6200: aload 26
    //   6202: invokevirtual 3634	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Friends;
    //   6205: astore 4
    //   6207: aload 4
    //   6209: aload 22
    //   6211: getfield 2119	com/tencent/mobileqq/data/Card:strNick	Ljava/lang/String;
    //   6214: putfield 3908	com/tencent/mobileqq/data/Friends:name	Ljava/lang/String;
    //   6217: aload 4
    //   6219: aload 22
    //   6221: getfield 2994	com/tencent/mobileqq/data/Card:strReMark	Ljava/lang/String;
    //   6224: putfield 3911	com/tencent/mobileqq/data/Friends:remark	Ljava/lang/String;
    //   6227: lconst_1
    //   6228: lload 17
    //   6230: land
    //   6231: lconst_0
    //   6232: lcmp
    //   6233: ifeq +1346 -> 7579
    //   6236: aload 22
    //   6238: getfield 3228	com/tencent/mobileqq/data/Card:strShowName	Ljava/lang/String;
    //   6241: astore_3
    //   6242: aload 4
    //   6244: aload_3
    //   6245: putfield 3914	com/tencent/mobileqq/data/Friends:alias	Ljava/lang/String;
    //   6248: aload 22
    //   6250: getfield 2147	com/tencent/mobileqq/data/Card:shGender	S
    //   6253: ifne +1335 -> 7588
    //   6256: iconst_1
    //   6257: istore 5
    //   6259: aload 4
    //   6261: iload 5
    //   6263: putfield 3917	com/tencent/mobileqq/data/Friends:gender	B
    //   6266: aload 4
    //   6268: aload 22
    //   6270: getfield 2159	com/tencent/mobileqq/data/Card:age	B
    //   6273: putfield 3919	com/tencent/mobileqq/data/Friends:age	I
    //   6276: ldc2_w 3142
    //   6279: lload 17
    //   6281: land
    //   6282: lconst_0
    //   6283: lcmp
    //   6284: ifeq +94 -> 6378
    //   6287: aload_2
    //   6288: getfield 3922	com/tencent/mobileqq/data/ExtensionInfo:richTime	J
    //   6291: aload 24
    //   6293: getfield 3243	SummaryCard/RespSummaryCard:uSignModifyTime	J
    //   6296: lcmp
    //   6297: ifeq +81 -> 6378
    //   6300: aload_2
    //   6301: aload 24
    //   6303: getfield 3239	SummaryCard/RespSummaryCard:vRichSign	[B
    //   6306: aload 24
    //   6308: getfield 3243	SummaryCard/RespSummaryCard:uSignModifyTime	J
    //   6311: invokevirtual 3926	com/tencent/mobileqq/data/ExtensionInfo:setRichBuffer	([BJ)V
    //   6314: aload_2
    //   6315: aload_0
    //   6316: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6319: aload 26
    //   6321: aload_2
    //   6322: invokevirtual 3930	com/tencent/mobileqq/data/ExtensionInfo:getRichStatus	()Lcom/tencent/mobileqq/richstatus/RichStatus;
    //   6325: invokestatic 3935	com/tencent/mobileqq/app/SignatureManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Lcom/tencent/mobileqq/richstatus/RichStatus;)Z
    //   6328: putfield 3938	com/tencent/mobileqq/data/ExtensionInfo:isAdded2C2C	Z
    //   6331: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6334: ifeq +44 -> 6378
    //   6337: ldc_w 682
    //   6340: iconst_2
    //   6341: new 18	java/lang/StringBuilder
    //   6344: dup
    //   6345: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   6348: ldc_w 3940
    //   6351: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6354: aload 26
    //   6356: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6359: ldc_w 3942
    //   6362: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6365: aload_2
    //   6366: getfield 3938	com/tencent/mobileqq/data/ExtensionInfo:isAdded2C2C	Z
    //   6369: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   6372: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6375: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6378: aload 23
    //   6380: aload_2
    //   6381: invokevirtual 3945	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/ExtensionInfo;)V
    //   6384: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6387: ifeq +44 -> 6431
    //   6390: ldc_w 682
    //   6393: iconst_2
    //   6394: new 18	java/lang/StringBuilder
    //   6397: dup
    //   6398: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   6401: ldc_w 3947
    //   6404: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6407: aload 26
    //   6409: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6412: ldc_w 3949
    //   6415: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6418: aload_2
    //   6419: getfield 3869	com/tencent/mobileqq/data/ExtensionInfo:pendantId	J
    //   6422: invokevirtual 326	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6425: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6428: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6431: aload 24
    //   6433: getfield 3220	SummaryCard/RespSummaryCard:stVipInfo	LQQService/VipBaseInfo;
    //   6436: ifnull +99 -> 6535
    //   6439: aload 4
    //   6441: aload 24
    //   6443: getfield 3220	SummaryCard/RespSummaryCard:stVipInfo	LQQService/VipBaseInfo;
    //   6446: getstatic 3955	QQService/EVIPSPEC:E_SP_QQVIP	LQQService/EVIPSPEC;
    //   6449: invokevirtual 3958	QQService/EVIPSPEC:value	()I
    //   6452: aload 4
    //   6454: getfield 3961	com/tencent/mobileqq/data/Friends:qqVipInfo	I
    //   6457: invokestatic 3966	com/tencent/mobileqq/app/FriendListHandler:a	(LQQService/VipBaseInfo;II)I
    //   6460: putfield 3961	com/tencent/mobileqq/data/Friends:qqVipInfo	I
    //   6463: aload 4
    //   6465: aload 24
    //   6467: getfield 3220	SummaryCard/RespSummaryCard:stVipInfo	LQQService/VipBaseInfo;
    //   6470: getstatic 3969	QQService/EVIPSPEC:E_SP_SUPERQQ	LQQService/EVIPSPEC;
    //   6473: invokevirtual 3958	QQService/EVIPSPEC:value	()I
    //   6476: aload 4
    //   6478: getfield 3972	com/tencent/mobileqq/data/Friends:superQqInfo	I
    //   6481: invokestatic 3966	com/tencent/mobileqq/app/FriendListHandler:a	(LQQService/VipBaseInfo;II)I
    //   6484: putfield 3972	com/tencent/mobileqq/data/Friends:superQqInfo	I
    //   6487: aload 4
    //   6489: aload 24
    //   6491: getfield 3220	SummaryCard/RespSummaryCard:stVipInfo	LQQService/VipBaseInfo;
    //   6494: getstatic 3975	QQService/EVIPSPEC:E_SP_SUPERVIP	LQQService/EVIPSPEC;
    //   6497: invokevirtual 3958	QQService/EVIPSPEC:value	()I
    //   6500: aload 4
    //   6502: getfield 3978	com/tencent/mobileqq/data/Friends:superVipInfo	I
    //   6505: invokestatic 3966	com/tencent/mobileqq/app/FriendListHandler:a	(LQQService/VipBaseInfo;II)I
    //   6508: putfield 3978	com/tencent/mobileqq/data/Friends:superVipInfo	I
    //   6511: aload 4
    //   6513: aload 24
    //   6515: getfield 3220	SummaryCard/RespSummaryCard:stVipInfo	LQQService/VipBaseInfo;
    //   6518: getstatic 3981	QQService/EVIPSPEC:E_SP_QQVIDEO_HOLLYWOOD	LQQService/EVIPSPEC;
    //   6521: invokevirtual 3958	QQService/EVIPSPEC:value	()I
    //   6524: aload 4
    //   6526: getfield 3984	com/tencent/mobileqq/data/Friends:hollywoodVipInfo	I
    //   6529: invokestatic 3966	com/tencent/mobileqq/app/FriendListHandler:a	(LQQService/VipBaseInfo;II)I
    //   6532: putfield 3984	com/tencent/mobileqq/data/Friends:hollywoodVipInfo	I
    //   6535: ldc2_w 3291
    //   6538: lload 17
    //   6540: land
    //   6541: lconst_0
    //   6542: lcmp
    //   6543: ifeq +28 -> 6571
    //   6546: aload 22
    //   6548: getfield 3296	com/tencent/mobileqq/data/Card:lUserFlag	J
    //   6551: lconst_1
    //   6552: land
    //   6553: lconst_0
    //   6554: lcmp
    //   6555: ifeq +1054 -> 7609
    //   6558: aload 4
    //   6560: aload 4
    //   6562: getfield 3987	com/tencent/mobileqq/data/Friends:cSpecialFlag	B
    //   6565: iconst_1
    //   6566: ior
    //   6567: i2b
    //   6568: putfield 3987	com/tencent/mobileqq/data/Friends:cSpecialFlag	B
    //   6571: aload 23
    //   6573: aload 4
    //   6575: invokevirtual 3990	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/Friends;)V
    //   6578: aload_0
    //   6579: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6582: bipush 10
    //   6584: invokevirtual 112	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   6587: checkcast 3992	com/tencent/mobileqq/model/PhoneContactManager
    //   6590: astore_2
    //   6591: aload_2
    //   6592: ifnull +23 -> 6615
    //   6595: aload_2
    //   6596: aload 4
    //   6598: getfield 3993	com/tencent/mobileqq/data/Friends:uin	Ljava/lang/String;
    //   6601: invokeinterface 3996 2 0
    //   6606: ifnull +9 -> 6615
    //   6609: aload_2
    //   6610: invokeinterface 3998 1 0
    //   6615: aload_1
    //   6616: getfield 281	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   6619: ldc_w 1281
    //   6622: lconst_0
    //   6623: invokevirtual 723	android/os/Bundle:getLong	(Ljava/lang/String;J)J
    //   6626: lstore 19
    //   6628: lload 19
    //   6630: lconst_0
    //   6631: lcmp
    //   6632: ifle +128 -> 6760
    //   6635: iload 14
    //   6637: iconst_2
    //   6638: if_icmpeq +16 -> 6654
    //   6641: iload 14
    //   6643: iconst_5
    //   6644: if_icmpeq +10 -> 6654
    //   6647: iload 14
    //   6649: bipush 7
    //   6651: if_icmpne +1001 -> 7652
    //   6654: aload 25
    //   6656: lload 19
    //   6658: invokestatic 272	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   6661: invokevirtual 4001	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/TroopInfo;
    //   6664: astore_1
    //   6665: aload_1
    //   6666: ifnull +94 -> 6760
    //   6669: aload_1
    //   6670: getfield 4006	com/tencent/mobileqq/data/TroopInfo:troopname	Ljava/lang/String;
    //   6673: ifnull +953 -> 7626
    //   6676: aload_1
    //   6677: getfield 4006	com/tencent/mobileqq/data/TroopInfo:troopname	Ljava/lang/String;
    //   6680: aload 24
    //   6682: getfield 3000	SummaryCard/RespSummaryCard:strGroupName	Ljava/lang/String;
    //   6685: invokevirtual 275	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   6688: ifne +18 -> 6706
    //   6691: aload_1
    //   6692: aload 24
    //   6694: getfield 3000	SummaryCard/RespSummaryCard:strGroupName	Ljava/lang/String;
    //   6697: putfield 4006	com/tencent/mobileqq/data/TroopInfo:troopname	Ljava/lang/String;
    //   6700: aload 25
    //   6702: aload_1
    //   6703: invokevirtual 4009	com/tencent/mobileqq/app/TroopManager:b	(Lcom/tencent/mobileqq/data/TroopInfo;)V
    //   6706: aload_0
    //   6707: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   6710: bipush 51
    //   6712: invokevirtual 112	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   6715: checkcast 2939	com/tencent/mobileqq/app/TroopManager
    //   6718: lload 19
    //   6720: invokestatic 272	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   6723: aload 24
    //   6725: getfield 2974	SummaryCard/RespSummaryCard:lUIN	J
    //   6728: invokestatic 272	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   6731: aload 24
    //   6733: getfield 3006	SummaryCard/RespSummaryCard:strGroupNick	Ljava/lang/String;
    //   6736: bipush 156
    //   6738: aload 24
    //   6740: getfield 2953	SummaryCard/RespSummaryCard:strNick	Ljava/lang/String;
    //   6743: aconst_null
    //   6744: bipush 156
    //   6746: bipush 156
    //   6748: bipush 156
    //   6750: ldc2_w 4010
    //   6753: ldc2_w 4010
    //   6756: invokevirtual 4014	com/tencent/mobileqq/app/TroopManager:a	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;IIIJJ)Z
    //   6759: pop
    //   6760: aload 24
    //   6762: getfield 4018	SummaryCard/RespSummaryCard:stAddFrdSrcInfo	LSummaryCard/AddFrdSrcInfo;
    //   6765: ifnull +42 -> 6807
    //   6768: aload 22
    //   6770: aload 24
    //   6772: getfield 4018	SummaryCard/RespSummaryCard:stAddFrdSrcInfo	LSummaryCard/AddFrdSrcInfo;
    //   6775: getfield 4023	SummaryCard/AddFrdSrcInfo:strSrcName	Ljava/lang/String;
    //   6778: putfield 4026	com/tencent/mobileqq/data/Card:addSrcName	Ljava/lang/String;
    //   6781: aload 22
    //   6783: aload 24
    //   6785: getfield 4018	SummaryCard/RespSummaryCard:stAddFrdSrcInfo	LSummaryCard/AddFrdSrcInfo;
    //   6788: getfield 4029	SummaryCard/AddFrdSrcInfo:uSrcId	J
    //   6791: putfield 4032	com/tencent/mobileqq/data/Card:addSrcId	J
    //   6794: aload 22
    //   6796: aload 24
    //   6798: getfield 4018	SummaryCard/RespSummaryCard:stAddFrdSrcInfo	LSummaryCard/AddFrdSrcInfo;
    //   6801: getfield 4035	SummaryCard/AddFrdSrcInfo:uSubSrcId	J
    //   6804: putfield 4038	com/tencent/mobileqq/data/Card:addSubSrcId	J
    //   6807: aload 24
    //   6809: getfield 4042	SummaryCard/RespSummaryCard:stBindPhoneInfo	LSummaryCard/BindPhoneInfo;
    //   6812: ifnull +16 -> 6828
    //   6815: aload 22
    //   6817: aload 24
    //   6819: getfield 4042	SummaryCard/RespSummaryCard:stBindPhoneInfo	LSummaryCard/BindPhoneInfo;
    //   6822: getfield 4045	SummaryCard/BindPhoneInfo:strName	Ljava/lang/String;
    //   6825: putfield 4048	com/tencent/mobileqq/data/Card:bindPhoneInfo	Ljava/lang/String;
    //   6828: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6831: ifeq +76 -> 6907
    //   6834: ldc_w 4050
    //   6837: iconst_2
    //   6838: new 18	java/lang/StringBuilder
    //   6841: dup
    //   6842: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   6845: ldc_w 4052
    //   6848: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6851: aload 22
    //   6853: getfield 4026	com/tencent/mobileqq/data/Card:addSrcName	Ljava/lang/String;
    //   6856: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6859: ldc_w 4054
    //   6862: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6865: aload 22
    //   6867: getfield 4032	com/tencent/mobileqq/data/Card:addSrcId	J
    //   6870: invokevirtual 326	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6873: ldc_w 4056
    //   6876: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6879: aload 22
    //   6881: getfield 4038	com/tencent/mobileqq/data/Card:addSubSrcId	J
    //   6884: invokevirtual 326	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   6887: ldc_w 4058
    //   6890: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6893: aload 22
    //   6895: getfield 4048	com/tencent/mobileqq/data/Card:bindPhoneInfo	Ljava/lang/String;
    //   6898: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6901: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6904: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   6907: aload 24
    //   6909: getfield 4061	SummaryCard/RespSummaryCard:vVisitingCardInfo	[B
    //   6912: ifnull +88 -> 7000
    //   6915: aload 22
    //   6917: aload 24
    //   6919: getfield 4061	SummaryCard/RespSummaryCard:vVisitingCardInfo	[B
    //   6922: putfield 4064	com/tencent/mobileqq/data/Card:bCardInfo	[B
    //   6925: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   6928: ifeq +72 -> 7000
    //   6931: new 4066	tencent/im/oidb/cmd0x43c/Oidb_0x43c$CardInfo
    //   6934: dup
    //   6935: invokespecial 4067	tencent/im/oidb/cmd0x43c/Oidb_0x43c$CardInfo:<init>	()V
    //   6938: astore_2
    //   6939: new 4069	com/tencent/mobileqq/businessCard/data/BusinessCard
    //   6942: dup
    //   6943: invokespecial 4070	com/tencent/mobileqq/businessCard/data/BusinessCard:<init>	()V
    //   6946: astore_1
    //   6947: aload 22
    //   6949: getfield 4064	com/tencent/mobileqq/data/Card:bCardInfo	[B
    //   6952: ifnull +828 -> 7780
    //   6955: aload_2
    //   6956: aload 22
    //   6958: getfield 4064	com/tencent/mobileqq/data/Card:bCardInfo	[B
    //   6961: invokevirtual 4071	tencent/im/oidb/cmd0x43c/Oidb_0x43c$CardInfo:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   6964: pop
    //   6965: aload_1
    //   6966: aload_2
    //   6967: invokestatic 4076	com/tencent/mobileqq/businessCard/BusinessCardServlet:a	(Lcom/tencent/mobileqq/businessCard/data/BusinessCard;Ltencent/im/oidb/cmd0x43c/Oidb_0x43c$CardInfo;)V
    //   6970: ldc_w 4050
    //   6973: iconst_2
    //   6974: new 18	java/lang/StringBuilder
    //   6977: dup
    //   6978: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   6981: ldc_w 4078
    //   6984: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6987: aload_1
    //   6988: invokevirtual 4079	com/tencent/mobileqq/businessCard/data/BusinessCard:toString	()Ljava/lang/String;
    //   6991: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   6994: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   6997: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7000: aload 24
    //   7002: getfield 4083	SummaryCard/RespSummaryCard:stDateCard	LSummaryCard/DateCard;
    //   7005: ifnull +199 -> 7204
    //   7008: aload 22
    //   7010: aload 24
    //   7012: getfield 4083	SummaryCard/RespSummaryCard:stDateCard	LSummaryCard/DateCard;
    //   7015: getfield 4086	SummaryCard/DateCard:bConstellation	B
    //   7018: putfield 2164	com/tencent/mobileqq/data/Card:constellation	I
    //   7021: aload 22
    //   7023: aload 24
    //   7025: getfield 4083	SummaryCard/RespSummaryCard:stDateCard	LSummaryCard/DateCard;
    //   7028: getfield 4087	SummaryCard/DateCard:strCompany	Ljava/lang/String;
    //   7031: putfield 2175	com/tencent/mobileqq/data/Card:strCompany	Ljava/lang/String;
    //   7034: aload 22
    //   7036: aload 24
    //   7038: getfield 4083	SummaryCard/RespSummaryCard:stDateCard	LSummaryCard/DateCard;
    //   7041: getfield 4090	SummaryCard/DateCard:uProfession	J
    //   7044: l2i
    //   7045: putfield 2170	com/tencent/mobileqq/data/Card:iProfession	I
    //   7048: aload 22
    //   7050: aload 24
    //   7052: getfield 4083	SummaryCard/RespSummaryCard:stDateCard	LSummaryCard/DateCard;
    //   7055: getfield 4091	SummaryCard/DateCard:strSchool	Ljava/lang/String;
    //   7058: putfield 2180	com/tencent/mobileqq/data/Card:strSchool	Ljava/lang/String;
    //   7061: aload 24
    //   7063: getfield 4083	SummaryCard/RespSummaryCard:stDateCard	LSummaryCard/DateCard;
    //   7066: getfield 4094	SummaryCard/DateCard:uHomeCountry	J
    //   7069: invokestatic 2329	com/tencent/mobileqq/app/ConditionSearchManager:a	(J)Ljava/lang/String;
    //   7072: astore_1
    //   7073: aload 24
    //   7075: getfield 4083	SummaryCard/RespSummaryCard:stDateCard	LSummaryCard/DateCard;
    //   7078: getfield 4097	SummaryCard/DateCard:uHomeProvince	J
    //   7081: invokestatic 2329	com/tencent/mobileqq/app/ConditionSearchManager:a	(J)Ljava/lang/String;
    //   7084: astore_2
    //   7085: aload 24
    //   7087: getfield 4083	SummaryCard/RespSummaryCard:stDateCard	LSummaryCard/DateCard;
    //   7090: getfield 4100	SummaryCard/DateCard:uHomeCity	J
    //   7093: invokestatic 2329	com/tencent/mobileqq/app/ConditionSearchManager:a	(J)Ljava/lang/String;
    //   7096: astore_3
    //   7097: aload 24
    //   7099: getfield 4083	SummaryCard/RespSummaryCard:stDateCard	LSummaryCard/DateCard;
    //   7102: getfield 4103	SummaryCard/DateCard:uHomeZone	J
    //   7105: invokestatic 2329	com/tencent/mobileqq/app/ConditionSearchManager:a	(J)Ljava/lang/String;
    //   7108: astore 4
    //   7110: new 18	java/lang/StringBuilder
    //   7113: dup
    //   7114: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   7117: astore 25
    //   7119: aload 25
    //   7121: aload_1
    //   7122: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7125: ldc_w 2197
    //   7128: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7131: pop
    //   7132: aload 25
    //   7134: aload_2
    //   7135: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7138: ldc_w 2197
    //   7141: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7144: pop
    //   7145: aload 25
    //   7147: aload_3
    //   7148: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7151: ldc_w 2197
    //   7154: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7157: pop
    //   7158: aload 25
    //   7160: aload 4
    //   7162: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7165: pop
    //   7166: aload 22
    //   7168: aload 25
    //   7170: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7173: putfield 2227	com/tencent/mobileqq/data/Card:strHometownCodes	Ljava/lang/String;
    //   7176: aload 22
    //   7178: getfield 2227	com/tencent/mobileqq/data/Card:strHometownCodes	Ljava/lang/String;
    //   7181: invokestatic 378	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   7184: ifne +20 -> 7204
    //   7187: aload_0
    //   7188: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7191: bipush 58
    //   7193: invokevirtual 112	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   7196: checkcast 2327	com/tencent/mobileqq/app/ConditionSearchManager
    //   7199: aload 22
    //   7201: invokevirtual 2712	com/tencent/mobileqq/app/ConditionSearchManager:a	(Lcom/tencent/mobileqq/data/Card;)V
    //   7204: iload 14
    //   7206: bipush 52
    //   7208: if_icmpne +13 -> 7221
    //   7211: aload 22
    //   7213: aload 24
    //   7215: getfield 4106	SummaryCard/RespSummaryCard:vTempChatSig	[B
    //   7218: putfield 393	com/tencent/mobileqq/data/Card:tempChatSig	[B
    //   7221: ldc2_w 4107
    //   7224: lload 17
    //   7226: land
    //   7227: lconst_0
    //   7228: lcmp
    //   7229: ifeq +18 -> 7247
    //   7232: aload 24
    //   7234: getfield 4112	SummaryCard/RespSummaryCard:stCampusCircleInfo	LSummaryCard/TCampusCircleInfo;
    //   7237: ifnull +556 -> 7793
    //   7240: aload 22
    //   7242: aload 24
    //   7244: invokestatic 4117	com/tencent/mobileqq/campuscircle/CampusCircleHelper:a	(Lcom/tencent/mobileqq/data/Card;LSummaryCard/RespSummaryCard;)V
    //   7247: aload 24
    //   7249: getfield 4120	SummaryCard/RespSummaryCard:vExtendCard	[B
    //   7252: ifnull +249 -> 7501
    //   7255: new 4122	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody
    //   7258: dup
    //   7259: invokespecial 4123	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:<init>	()V
    //   7262: astore_3
    //   7263: aload_3
    //   7264: aload 24
    //   7266: getfield 4120	SummaryCard/RespSummaryCard:vExtendCard	[B
    //   7269: invokevirtual 4124	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   7272: pop
    //   7273: aload_3
    //   7274: getfield 4125	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   7277: invokevirtual 3638	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   7280: ifeq +528 -> 7808
    //   7283: aload_3
    //   7284: getfield 4125	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:uint64_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   7287: invokevirtual 360	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   7290: invokestatic 604	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   7293: astore_1
    //   7294: aload_1
    //   7295: invokestatic 607	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   7298: pop
    //   7299: aload_3
    //   7300: getfield 4128	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:bytes_declaration	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   7303: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   7306: ifeq +507 -> 7813
    //   7309: aload_3
    //   7310: getfield 4128	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:bytes_declaration	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   7313: invokevirtual 152	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   7316: invokevirtual 3532	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   7319: astore_1
    //   7320: aload_3
    //   7321: getfield 4131	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:bytes_voice_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   7324: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   7327: ifeq +491 -> 7818
    //   7330: aload_3
    //   7331: getfield 4131	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:bytes_voice_url	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   7334: invokevirtual 152	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   7337: invokevirtual 3532	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   7340: astore_2
    //   7341: aload_3
    //   7342: getfield 4134	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:uint32_popularity	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   7345: invokevirtual 397	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   7348: ifeq +475 -> 7823
    //   7351: aload_3
    //   7352: getfield 4134	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:uint32_popularity	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   7355: invokevirtual 138	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   7358: istore 6
    //   7360: aload_3
    //   7361: getfield 4137	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:uint64_update_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   7364: invokevirtual 3638	com/tencent/mobileqq/pb/PBUInt64Field:has	()Z
    //   7367: ifeq +462 -> 7829
    //   7370: aload_3
    //   7371: getfield 4137	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:uint64_update_time	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   7374: invokevirtual 360	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   7377: lstore 17
    //   7379: aload_3
    //   7380: getfield 4140	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:uint32_voice_duration	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   7383: invokevirtual 397	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   7386: ifeq +449 -> 7835
    //   7389: aload_3
    //   7390: getfield 4140	com/tencent/pb/extendfriend/GetExtendFriendInfo$RspBody:uint32_voice_duration	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   7393: invokevirtual 138	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   7396: istore 7
    //   7398: aload 22
    //   7400: aload_1
    //   7401: putfield 4143	com/tencent/mobileqq/data/Card:declaration	Ljava/lang/String;
    //   7404: aload 22
    //   7406: iload 6
    //   7408: putfield 4146	com/tencent/mobileqq/data/Card:popularity	I
    //   7411: aload 22
    //   7413: aload_2
    //   7414: putfield 4149	com/tencent/mobileqq/data/Card:voiceUrl	Ljava/lang/String;
    //   7417: aload 22
    //   7419: lload 17
    //   7421: putfield 4152	com/tencent/mobileqq/data/Card:updateTime	J
    //   7424: aload 22
    //   7426: iload 7
    //   7428: putfield 4155	com/tencent/mobileqq/data/Card:extendFriendVoiceDuration	I
    //   7431: ldc_w 4050
    //   7434: iconst_1
    //   7435: new 18	java/lang/StringBuilder
    //   7438: dup
    //   7439: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   7442: ldc_w 4157
    //   7445: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7448: iload 6
    //   7450: invokevirtual 572	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7453: ldc_w 4159
    //   7456: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7459: aload_1
    //   7460: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7463: ldc_w 4161
    //   7466: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7469: aload_2
    //   7470: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7473: ldc_w 4163
    //   7476: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7479: lload 17
    //   7481: invokevirtual 326	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   7484: ldc_w 4165
    //   7487: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7490: iload 7
    //   7492: invokevirtual 572	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7495: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7498: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7501: aload 23
    //   7503: aload 22
    //   7505: invokevirtual 208	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   7508: pop
    //   7509: aload_0
    //   7510: iconst_1
    //   7511: iconst_1
    //   7512: aload 22
    //   7514: invokevirtual 198	com/tencent/mobileqq/app/CardHandler:a	(IZLjava/lang/Object;)V
    //   7517: goto -7130 -> 387
    //   7520: astore_3
    //   7521: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7524: ifeq -1326 -> 6198
    //   7527: ldc_w 682
    //   7530: iconst_2
    //   7531: new 18	java/lang/StringBuilder
    //   7534: dup
    //   7535: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   7538: ldc_w 3905
    //   7541: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7544: aload_3
    //   7545: invokevirtual 639	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   7548: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7551: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7554: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7557: goto -1359 -> 6198
    //   7560: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7563: ifeq -1365 -> 6198
    //   7566: ldc_w 682
    //   7569: iconst_2
    //   7570: ldc_w 4167
    //   7573: invokestatic 2058	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   7576: goto -1378 -> 6198
    //   7579: aload 4
    //   7581: getfield 3914	com/tencent/mobileqq/data/Friends:alias	Ljava/lang/String;
    //   7584: astore_3
    //   7585: goto -1343 -> 6242
    //   7588: aload 22
    //   7590: getfield 2147	com/tencent/mobileqq/data/Card:shGender	S
    //   7593: iconst_1
    //   7594: if_icmpne +9 -> 7603
    //   7597: iconst_2
    //   7598: istore 5
    //   7600: goto -1341 -> 6259
    //   7603: iconst_0
    //   7604: istore 5
    //   7606: goto -1347 -> 6259
    //   7609: aload 4
    //   7611: aload 4
    //   7613: getfield 3987	com/tencent/mobileqq/data/Friends:cSpecialFlag	B
    //   7616: bipush 254
    //   7618: iand
    //   7619: i2b
    //   7620: putfield 3987	com/tencent/mobileqq/data/Friends:cSpecialFlag	B
    //   7623: goto -1052 -> 6571
    //   7626: aload 24
    //   7628: getfield 3000	SummaryCard/RespSummaryCard:strGroupName	Ljava/lang/String;
    //   7631: ifnull -925 -> 6706
    //   7634: aload_1
    //   7635: aload 24
    //   7637: getfield 3000	SummaryCard/RespSummaryCard:strGroupName	Ljava/lang/String;
    //   7640: putfield 4006	com/tencent/mobileqq/data/TroopInfo:troopname	Ljava/lang/String;
    //   7643: aload 25
    //   7645: aload_1
    //   7646: invokevirtual 4009	com/tencent/mobileqq/app/TroopManager:b	(Lcom/tencent/mobileqq/data/TroopInfo;)V
    //   7649: goto -943 -> 6706
    //   7652: iload 14
    //   7654: iconst_4
    //   7655: if_icmpne -895 -> 6760
    //   7658: aload_0
    //   7659: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7662: bipush 52
    //   7664: invokevirtual 112	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   7667: checkcast 4169	com/tencent/mobileqq/app/DiscussionManager
    //   7670: astore_1
    //   7671: aload_1
    //   7672: lload 19
    //   7674: invokestatic 272	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   7677: aload 26
    //   7679: invokevirtual 4172	com/tencent/mobileqq/app/DiscussionManager:a	(Ljava/lang/String;Ljava/lang/String;)Lcom/tencent/mobileqq/data/DiscussionMemberInfo;
    //   7682: astore_2
    //   7683: aload_2
    //   7684: ifnull -924 -> 6760
    //   7687: aload_2
    //   7688: aload 24
    //   7690: getfield 2953	SummaryCard/RespSummaryCard:strNick	Ljava/lang/String;
    //   7693: putfield 4177	com/tencent/mobileqq/data/DiscussionMemberInfo:memberName	Ljava/lang/String;
    //   7696: aload 24
    //   7698: getfield 3021	SummaryCard/RespSummaryCard:strAutoRemark	Ljava/lang/String;
    //   7701: ifnull +61 -> 7762
    //   7704: aload 24
    //   7706: getfield 3021	SummaryCard/RespSummaryCard:strAutoRemark	Ljava/lang/String;
    //   7709: invokevirtual 3189	java/lang/String:length	()I
    //   7712: ifle +50 -> 7762
    //   7715: aload 24
    //   7717: getfield 3021	SummaryCard/RespSummaryCard:strAutoRemark	Ljava/lang/String;
    //   7720: aload_2
    //   7721: getfield 4180	com/tencent/mobileqq/data/DiscussionMemberInfo:inteRemark	Ljava/lang/String;
    //   7724: invokevirtual 275	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7727: ifne +35 -> 7762
    //   7730: aload_2
    //   7731: aload 24
    //   7733: getfield 3021	SummaryCard/RespSummaryCard:strAutoRemark	Ljava/lang/String;
    //   7736: putfield 4180	com/tencent/mobileqq/data/DiscussionMemberInfo:inteRemark	Ljava/lang/String;
    //   7739: aload 24
    //   7741: getfield 3021	SummaryCard/RespSummaryCard:strAutoRemark	Ljava/lang/String;
    //   7744: aload 24
    //   7746: getfield 2953	SummaryCard/RespSummaryCard:strNick	Ljava/lang/String;
    //   7749: invokevirtual 275	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   7752: ifeq +18 -> 7770
    //   7755: aload_2
    //   7756: ldc2_w 4181
    //   7759: putfield 4185	com/tencent/mobileqq/data/DiscussionMemberInfo:inteRemarkSource	J
    //   7762: aload_1
    //   7763: aload_2
    //   7764: invokevirtual 4188	com/tencent/mobileqq/app/DiscussionManager:a	(Lcom/tencent/mobileqq/data/DiscussionMemberInfo;)V
    //   7767: goto -1007 -> 6760
    //   7770: aload_2
    //   7771: ldc2_w 4189
    //   7774: putfield 4185	com/tencent/mobileqq/data/DiscussionMemberInfo:inteRemarkSource	J
    //   7777: goto -15 -> 7762
    //   7780: ldc_w 4050
    //   7783: iconst_2
    //   7784: ldc_w 4192
    //   7787: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   7790: goto -790 -> 7000
    //   7793: aload 22
    //   7795: iconst_0
    //   7796: putfield 400	com/tencent/mobileqq/data/Card:nCampusStatus	I
    //   7799: aload 22
    //   7801: iconst_0
    //   7802: putfield 4195	com/tencent/mobileqq/data/Card:iCampusIsSigned	I
    //   7805: goto -558 -> 7247
    //   7808: aconst_null
    //   7809: astore_1
    //   7810: goto -516 -> 7294
    //   7813: aconst_null
    //   7814: astore_1
    //   7815: goto -495 -> 7320
    //   7818: aconst_null
    //   7819: astore_2
    //   7820: goto -479 -> 7341
    //   7823: iconst_0
    //   7824: istore 6
    //   7826: goto -466 -> 7360
    //   7829: lconst_0
    //   7830: lstore 17
    //   7832: goto -453 -> 7379
    //   7835: iconst_0
    //   7836: istore 7
    //   7838: goto -440 -> 7398
    //   7841: astore_1
    //   7842: aload_1
    //   7843: invokevirtual 3840	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:printStackTrace	()V
    //   7846: goto -345 -> 7501
    //   7849: aload_0
    //   7850: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   7853: ldc_w 4197
    //   7856: ldc_w 4199
    //   7859: new 18	java/lang/StringBuilder
    //   7862: dup
    //   7863: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   7866: ldc_w 4201
    //   7869: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7872: aload_2
    //   7873: invokevirtual 1513	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   7876: invokevirtual 572	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   7879: ldc_w 4203
    //   7882: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7885: aload_2
    //   7886: invokevirtual 4206	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailMsg	()Ljava/lang/String;
    //   7889: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   7892: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   7895: aconst_null
    //   7896: fconst_0
    //   7897: invokestatic 4211	com/tencent/mobileqq/vas/VasMonitorHandler:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;F)V
    //   7900: aload_1
    //   7901: getfield 281	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   7904: ldc_w 1301
    //   7907: invokevirtual 289	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   7910: iconst_1
    //   7911: if_icmpne +24 -> 7935
    //   7914: aload_0
    //   7915: bipush 51
    //   7917: iconst_0
    //   7918: aconst_null
    //   7919: aload_1
    //   7920: getfield 281	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   7923: ldc_w 4213
    //   7926: invokevirtual 289	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   7929: invokevirtual 4216	com/tencent/mobileqq/app/CardHandler:a	(IZLjava/lang/Object;Z)V
    //   7932: goto -7545 -> 387
    //   7935: lload 17
    //   7937: lconst_0
    //   7938: lcmp
    //   7939: ifgt +16 -> 7955
    //   7942: aload 22
    //   7944: astore_1
    //   7945: aload_0
    //   7946: iconst_1
    //   7947: iconst_0
    //   7948: aload_1
    //   7949: invokevirtual 198	com/tencent/mobileqq/app/CardHandler:a	(IZLjava/lang/Object;)V
    //   7952: goto -7565 -> 387
    //   7955: lload 17
    //   7957: invokestatic 272	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   7960: astore_1
    //   7961: goto -16 -> 7945
    //   7964: astore_2
    //   7965: goto -995 -> 6970
    //   7968: astore 22
    //   7970: goto -7505 -> 465
    //   7973: goto -2089 -> 5884
    //   7976: iload 6
    //   7978: istore 8
    //   7980: iload 7
    //   7982: istore 6
    //   7984: iload 8
    //   7986: istore 7
    //   7988: goto -2511 -> 5477
    //   7991: iload 11
    //   7993: istore 6
    //   7995: iload 10
    //   7997: istore 7
    //   7999: goto -2266 -> 5733
    //   8002: aconst_null
    //   8003: astore 4
    //   8005: goto -7846 -> 159
    //   8008: lconst_0
    //   8009: lstore 15
    //   8011: goto -7964 -> 47
    //   8014: iload 6
    //   8016: ifne -2512 -> 5504
    //   8019: iconst_1
    //   8020: istore 21
    //   8022: goto -3393 -> 4629
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	8025	0	this	CardHandler
    //   0	8025	1	paramToServiceMsg	ToServiceMsg
    //   0	8025	2	paramFromServiceMsg	FromServiceMsg
    //   0	8025	3	paramObject	Object
    //   0	8025	4	paramBundle	Bundle
    //   6257	1348	5	b1	byte
    //   65	7950	6	i	int
    //   443	7555	7	j	int
    //   2761	5224	8	k	int
    //   2769	2957	9	m	int
    //   5292	2704	10	n	int
    //   5302	2690	11	i1	int
    //   5349	46	12	i2	int
    //   5355	36	13	i3	int
    //   193	7463	14	i4	int
    //   45	7965	15	l1	long
    //   169	7787	17	l2	long
    //   1928	5745	19	l3	long
    //   343	7678	21	bool	boolean
    //   48	7895	22	localObject1	Object
    //   7968	1	22	localException1	Exception
    //   130	244	23	localObject2	Object
    //   455	7047	23	localException2	Exception
    //   232	7513	24	localRespSummaryCard	RespSummaryCard
    //   226	7418	25	localObject3	Object
    //   524	7154	26	str	String
    //   2890	475	27	localArrayList1	ArrayList
    //   2925	165	28	localui_info	com.tencent.pb.profilecard.SummaryCardBusiEntry.ui_info
    //   2934	414	29	localProfileSummaryHobbiesItem	com.tencent.mobileqq.profile.ProfileSummaryHobbiesItem
    //   3071	270	30	localArrayList2	ArrayList
    //   3102	168	31	localLabel	com.tencent.pb.profilecard.SummaryCardBusiEntry.Label
    //   3111	183	32	localProfileGroupLabel	com.tencent.mobileqq.profile.ProfileGroupLabel
    //   3164	123	33	localProfileColor	com.tencent.mobileqq.profile.ProfileColor
    // Exception table:
    //   from	to	target	type
    //   72	95	455	java/lang/Exception
    //   2811	2836	3317	java/lang/Exception
    //   2841	2892	3317	java/lang/Exception
    //   2895	3037	3317	java/lang/Exception
    //   3047	3053	3317	java/lang/Exception
    //   3053	3073	3317	java/lang/Exception
    //   3076	3299	3317	java/lang/Exception
    //   3308	3314	3317	java/lang/Exception
    //   3338	3345	3317	java/lang/Exception
    //   3345	3353	3317	java/lang/Exception
    //   3362	3369	3317	java/lang/Exception
    //   3369	3441	3317	java/lang/Exception
    //   3598	3615	3788	java/lang/Exception
    //   3620	3708	3788	java/lang/Exception
    //   3708	3723	3788	java/lang/Exception
    //   3723	3785	3788	java/lang/Exception
    //   3809	3837	3788	java/lang/Exception
    //   3856	3950	5510	java/lang/Exception
    //   3950	4026	5510	java/lang/Exception
    //   4026	4093	5510	java/lang/Exception
    //   4093	4160	5510	java/lang/Exception
    //   4160	4179	5510	java/lang/Exception
    //   4188	4195	5510	java/lang/Exception
    //   4204	4294	5510	java/lang/Exception
    //   4294	4328	5510	java/lang/Exception
    //   4328	4347	5510	java/lang/Exception
    //   4352	4371	5510	java/lang/Exception
    //   4371	4416	5510	java/lang/Exception
    //   4416	4458	5510	java/lang/Exception
    //   4458	4522	5510	java/lang/Exception
    //   4522	4562	5510	java/lang/Exception
    //   4562	4626	5510	java/lang/Exception
    //   4629	4636	5510	java/lang/Exception
    //   4754	4767	5555	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4979	4995	5578	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   4995	5100	5578	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   5100	5111	5578	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   5114	5143	5578	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   6126	6198	7520	java/lang/Exception
    //   7263	7294	7841	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   7294	7320	7841	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   7320	7341	7841	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   7341	7360	7841	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   7360	7379	7841	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   7379	7398	7841	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   7398	7501	7841	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   6955	6970	7964	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   100	108	7968	java/lang/Exception
    //   111	132	7968	java/lang/Exception
    //   142	159	7968	java/lang/Exception
    //   438	445	7968	java/lang/Exception
  }
  
  private void p(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = paramFromServiceMsg.isSuccess();
    paramFromServiceMsg = (String)paramToServiceMsg.getAttribute("uin");
    paramToServiceMsg = (String)paramToServiceMsg.getAttribute("photo_id");
    if (QLog.isColorLevel()) {
      QLog.d("Q.qzonephotowall", 2, "handleDelPhotoWall isSuc:" + bool + " photoid:" + paramToServiceMsg);
    }
    a(70, bool, new Object[] { paramFromServiceMsg });
  }
  
  private void p(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    int k = 1;
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.SummaryCard", 2, "handleGetSimpleSummaryCard() , resp.getResultCode() = " + paramFromServiceMsg.getResultCode());
    }
    int i;
    if ((paramFromServiceMsg.isSuccess()) && ((paramObject instanceof RespSummaryCard))) {
      i = 1;
    }
    for (;;)
    {
      int j = i;
      if (i != 0) {}
      try
      {
        paramFromServiceMsg = (SummaryCard.RespHead)a(paramFromServiceMsg.getWupBuffer(), "RespHead", new SummaryCard.RespHead());
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.iResult == 0))
        {
          i = k;
          if (QLog.isColorLevel())
          {
            paramBundle = new StringBuilder().append("handleGetSummaryCard() , SummaryCard.RespHead.iResult = ");
            if (paramFromServiceMsg != null) {
              break label297;
            }
            paramFromServiceMsg = "respHead is null ";
            QLog.d("Q.profilecard.SummaryCard", 2, paramFromServiceMsg);
          }
          j = i;
          l = paramToServiceMsg.extraData.getLong("targetUin");
          if (j != 0)
          {
            paramToServiceMsg = (RespSummaryCard)paramObject;
            paramFromServiceMsg = new oidb_0x5eb.UdcUinData();
            if (paramToServiceMsg.vResp0x5ebInfo == null) {}
          }
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        try
        {
          for (;;)
          {
            long l;
            paramFromServiceMsg.mergeFrom(paramToServiceMsg.vResp0x5ebInfo);
            if ((String.valueOf(l).equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) && (paramFromServiceMsg.int32_history_num_flag.has()))
            {
              i = paramFromServiceMsg.int32_history_num_flag.get();
              SharedPreUtils.P(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplication(), c(), i);
              if (QLog.isColorLevel()) {
                QLog.i("Q.profilecard.SummaryCard", 2, "handleGetSimpleSummaryCard, history_num_flag= " + i);
              }
            }
            return;
            i = 0;
            break;
            i = 0;
            continue;
            label297:
            j = paramFromServiceMsg.iResult;
            paramFromServiceMsg = Integer.valueOf(j);
          }
          paramFromServiceMsg = paramFromServiceMsg;
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.SummaryCard", 2, paramFromServiceMsg.toString());
          }
          j = 0;
        }
        catch (Exception paramToServiceMsg)
        {
          while (!QLog.isColorLevel()) {}
          QLog.i("Q.profilecard.SummaryCard", 2, paramToServiceMsg.toString());
        }
      }
    }
  }
  
  /* Error */
  private void q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 11
    //   3: iconst_0
    //   4: istore 13
    //   6: iconst_0
    //   7: istore 14
    //   9: iconst_0
    //   10: istore 12
    //   12: aload_2
    //   13: invokevirtual 88	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   16: ifeq +468 -> 484
    //   19: aload_3
    //   20: ifnull +464 -> 484
    //   23: iconst_1
    //   24: istore 5
    //   26: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   29: ifeq +30 -> 59
    //   32: ldc 95
    //   34: iconst_2
    //   35: new 18	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   42: ldc_w 4230
    //   45: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: iload 5
    //   50: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   53: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: iload 5
    //   61: istore 6
    //   63: iload 12
    //   65: istore 8
    //   67: iload 5
    //   69: ifeq +342 -> 411
    //   72: iload 5
    //   74: istore 10
    //   76: iload 5
    //   78: istore 7
    //   80: iload 14
    //   82: istore 9
    //   84: new 122	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   87: dup
    //   88: invokespecial 123	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   91: aload_3
    //   92: checkcast 125	[B
    //   95: checkcast 125	[B
    //   98: invokevirtual 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   101: checkcast 122	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   104: astore_2
    //   105: aload_2
    //   106: ifnull +384 -> 490
    //   109: iload 5
    //   111: istore 10
    //   113: iload 5
    //   115: istore 7
    //   117: iload 14
    //   119: istore 9
    //   121: aload_2
    //   122: getfield 133	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   125: invokevirtual 138	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   128: ifne +362 -> 490
    //   131: iconst_1
    //   132: istore 5
    //   134: iload 5
    //   136: istore 10
    //   138: iload 5
    //   140: istore 7
    //   142: iload 14
    //   144: istore 9
    //   146: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   149: ifeq +42 -> 191
    //   152: iload 5
    //   154: istore 10
    //   156: iload 5
    //   158: istore 7
    //   160: iload 14
    //   162: istore 9
    //   164: ldc 95
    //   166: iconst_2
    //   167: new 18	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   174: ldc_w 4232
    //   177: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: iload 5
    //   182: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   185: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   191: iload 5
    //   193: istore 6
    //   195: iload 12
    //   197: istore 8
    //   199: iload 5
    //   201: ifeq +210 -> 411
    //   204: iload 5
    //   206: istore 6
    //   208: iload 12
    //   210: istore 8
    //   212: iload 5
    //   214: istore 10
    //   216: iload 5
    //   218: istore 7
    //   220: iload 14
    //   222: istore 9
    //   224: aload_2
    //   225: getfield 144	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   228: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   231: ifeq +180 -> 411
    //   234: iload 5
    //   236: istore 6
    //   238: iload 12
    //   240: istore 8
    //   242: iload 5
    //   244: istore 10
    //   246: iload 5
    //   248: istore 7
    //   250: iload 14
    //   252: istore 9
    //   254: aload_2
    //   255: getfield 144	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   258: invokevirtual 152	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   261: ifnull +150 -> 411
    //   264: iload 5
    //   266: istore 10
    //   268: iload 5
    //   270: istore 7
    //   272: iload 14
    //   274: istore 9
    //   276: aload_2
    //   277: getfield 144	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   280: invokevirtual 152	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   283: invokevirtual 158	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   286: invokestatic 164	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   289: astore_2
    //   290: iload 5
    //   292: istore 10
    //   294: iload 5
    //   296: istore 7
    //   298: iload 14
    //   300: istore 9
    //   302: aload_2
    //   303: invokevirtual 167	java/nio/ByteBuffer:getInt	()I
    //   306: istore 4
    //   308: iload 4
    //   310: i2l
    //   311: lstore 15
    //   313: iload 4
    //   315: ifge +12 -> 327
    //   318: iload 4
    //   320: ldc_w 554
    //   323: iand
    //   324: i2l
    //   325: lstore 15
    //   327: iload 5
    //   329: istore 10
    //   331: iload 5
    //   333: istore 7
    //   335: iload 14
    //   337: istore 9
    //   339: aload_2
    //   340: invokevirtual 170	java/nio/ByteBuffer:get	()B
    //   343: pop
    //   344: iload 5
    //   346: istore 6
    //   348: iload 12
    //   350: istore 8
    //   352: iload 5
    //   354: istore 10
    //   356: iload 5
    //   358: istore 7
    //   360: iload 14
    //   362: istore 9
    //   364: aload_2
    //   365: invokevirtual 174	java/nio/ByteBuffer:getShort	()S
    //   368: invokestatic 179	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   371: invokevirtual 182	java/lang/Short:shortValue	()S
    //   374: iconst_1
    //   375: if_icmpne +36 -> 411
    //   378: iload 5
    //   380: istore 10
    //   382: iload 5
    //   384: istore 7
    //   386: iload 14
    //   388: istore 9
    //   390: aload_2
    //   391: invokevirtual 174	java/nio/ByteBuffer:getShort	()S
    //   394: istore 4
    //   396: iload 4
    //   398: sipush -25042
    //   401: if_icmpeq +95 -> 496
    //   404: iconst_0
    //   405: istore 6
    //   407: iload 12
    //   409: istore 8
    //   411: iload 6
    //   413: istore 7
    //   415: iload 8
    //   417: istore 9
    //   419: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   422: ifeq +48 -> 470
    //   425: ldc 95
    //   427: iconst_2
    //   428: new 18	java/lang/StringBuilder
    //   431: dup
    //   432: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   435: ldc_w 4232
    //   438: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   441: iload 6
    //   443: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   446: ldc 184
    //   448: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: iload 8
    //   453: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   456: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   459: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   462: iload 8
    //   464: istore 9
    //   466: iload 6
    //   468: istore 7
    //   470: aload_0
    //   471: bipush 54
    //   473: iload 7
    //   475: iload 9
    //   477: invokestatic 195	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   480: invokevirtual 198	com/tencent/mobileqq/app/CardHandler:a	(IZLjava/lang/Object;)V
    //   483: return
    //   484: iconst_0
    //   485: istore 5
    //   487: goto -461 -> 26
    //   490: iconst_0
    //   491: istore 5
    //   493: goto -359 -> 134
    //   496: iload 5
    //   498: istore 10
    //   500: iload 5
    //   502: istore 7
    //   504: iload 14
    //   506: istore 9
    //   508: aload_2
    //   509: invokevirtual 174	java/nio/ByteBuffer:getShort	()S
    //   512: istore 4
    //   514: iload 4
    //   516: iconst_2
    //   517: if_icmpne +123 -> 640
    //   520: iload 5
    //   522: istore 10
    //   524: iload 5
    //   526: istore 7
    //   528: iload 14
    //   530: istore 9
    //   532: iload 4
    //   534: newarray byte
    //   536: astore_3
    //   537: iload 5
    //   539: istore 10
    //   541: iload 5
    //   543: istore 7
    //   545: iload 14
    //   547: istore 9
    //   549: aload_2
    //   550: aload_3
    //   551: invokevirtual 200	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   554: pop
    //   555: iload 5
    //   557: istore 10
    //   559: iload 5
    //   561: istore 7
    //   563: iload 14
    //   565: istore 9
    //   567: aload_3
    //   568: iconst_0
    //   569: invokestatic 205	com/tencent/mobileqq/util/Utils:a	([BI)S
    //   572: istore 4
    //   574: iload 4
    //   576: ifne +32 -> 608
    //   579: iconst_0
    //   580: istore 6
    //   582: aload_2
    //   583: invokevirtual 174	java/nio/ByteBuffer:getShort	()S
    //   586: istore 4
    //   588: iload 4
    //   590: ifeq +24 -> 614
    //   593: iload 11
    //   595: istore 5
    //   597: iload 6
    //   599: istore 8
    //   601: iload 5
    //   603: istore 6
    //   605: goto -194 -> 411
    //   608: iconst_1
    //   609: istore 6
    //   611: goto -29 -> 582
    //   614: aload_0
    //   615: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   618: invokevirtual 544	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   621: aload_1
    //   622: invokevirtual 1516	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   625: aconst_null
    //   626: ldc_w 2379
    //   629: iload 6
    //   631: invokestatic 2389	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:writeValue	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   634: iconst_1
    //   635: istore 5
    //   637: goto -40 -> 597
    //   640: iconst_0
    //   641: istore 6
    //   643: iload 12
    //   645: istore 8
    //   647: goto -236 -> 411
    //   650: astore_1
    //   651: iload 13
    //   653: istore 6
    //   655: iload 10
    //   657: istore 5
    //   659: iload 5
    //   661: istore 7
    //   663: iload 6
    //   665: istore 9
    //   667: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   670: ifeq +21 -> 691
    //   673: iload 5
    //   675: istore 7
    //   677: iload 6
    //   679: istore 9
    //   681: ldc 95
    //   683: iconst_2
    //   684: ldc_w 4234
    //   687: aload_1
    //   688: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   691: iload 5
    //   693: istore 7
    //   695: iload 6
    //   697: istore 9
    //   699: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   702: ifeq -232 -> 470
    //   705: ldc 95
    //   707: iconst_2
    //   708: new 18	java/lang/StringBuilder
    //   711: dup
    //   712: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   715: ldc_w 4232
    //   718: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   721: iload 5
    //   723: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   726: ldc 184
    //   728: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   731: iload 6
    //   733: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   736: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   739: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   742: iload 5
    //   744: istore 7
    //   746: iload 6
    //   748: istore 9
    //   750: goto -280 -> 470
    //   753: astore_1
    //   754: iload 7
    //   756: istore 5
    //   758: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   761: ifeq +40 -> 801
    //   764: ldc 95
    //   766: iconst_2
    //   767: new 18	java/lang/StringBuilder
    //   770: dup
    //   771: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   774: ldc_w 4232
    //   777: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   780: iload 5
    //   782: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   785: ldc 184
    //   787: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   790: iload 9
    //   792: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   795: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   798: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   801: aload_1
    //   802: athrow
    //   803: astore_1
    //   804: iload 6
    //   806: istore 9
    //   808: goto -50 -> 758
    //   811: astore_1
    //   812: iconst_1
    //   813: istore 5
    //   815: iload 6
    //   817: istore 9
    //   819: goto -61 -> 758
    //   822: astore_1
    //   823: goto -164 -> 659
    //   826: astore_1
    //   827: iconst_1
    //   828: istore 5
    //   830: goto -171 -> 659
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	833	0	this	CardHandler
    //   0	833	1	paramToServiceMsg	ToServiceMsg
    //   0	833	2	paramFromServiceMsg	FromServiceMsg
    //   0	833	3	paramObject	Object
    //   306	283	4	i	int
    //   24	805	5	bool1	boolean
    //   61	755	6	bool2	boolean
    //   78	677	7	bool3	boolean
    //   65	581	8	bool4	boolean
    //   82	736	9	bool5	boolean
    //   74	582	10	bool6	boolean
    //   1	593	11	bool7	boolean
    //   10	634	12	bool8	boolean
    //   4	648	13	bool9	boolean
    //   7	557	14	bool10	boolean
    //   311	15	15	l	long
    // Exception table:
    //   from	to	target	type
    //   84	105	650	java/lang/Exception
    //   121	131	650	java/lang/Exception
    //   146	152	650	java/lang/Exception
    //   164	191	650	java/lang/Exception
    //   224	234	650	java/lang/Exception
    //   254	264	650	java/lang/Exception
    //   276	290	650	java/lang/Exception
    //   302	308	650	java/lang/Exception
    //   339	344	650	java/lang/Exception
    //   364	378	650	java/lang/Exception
    //   390	396	650	java/lang/Exception
    //   508	514	650	java/lang/Exception
    //   532	537	650	java/lang/Exception
    //   549	555	650	java/lang/Exception
    //   567	574	650	java/lang/Exception
    //   84	105	753	finally
    //   121	131	753	finally
    //   146	152	753	finally
    //   164	191	753	finally
    //   224	234	753	finally
    //   254	264	753	finally
    //   276	290	753	finally
    //   302	308	753	finally
    //   339	344	753	finally
    //   364	378	753	finally
    //   390	396	753	finally
    //   508	514	753	finally
    //   532	537	753	finally
    //   549	555	753	finally
    //   567	574	753	finally
    //   667	673	753	finally
    //   681	691	753	finally
    //   582	588	803	finally
    //   614	634	811	finally
    //   582	588	822	java/lang/Exception
    //   614	634	826	java/lang/Exception
  }
  
  private void q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    byte[] arrayOfByte = paramToServiceMsg.extraData.getByteArray("filekey");
    paramBundle.putByteArray("fileKey", arrayOfByte);
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      RespDelFace localRespDelFace = (RespDelFace)paramObject;
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory(paramToServiceMsg.getUin());
      FriendsManager localFriendsManager = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      paramObject = localFriendsManager.a(paramToServiceMsg.getUin());
      paramFromServiceMsg = paramObject;
      if (paramObject == null)
      {
        paramFromServiceMsg = new Card();
        paramFromServiceMsg.uin = paramToServiceMsg.getUin();
      }
      paramBundle.putInt("result", localRespDelFace.stHeader.iReplyCode);
      switch (localRespDelFace.stHeader.iReplyCode)
      {
      }
      for (;;)
      {
        localFriendsManager.a(paramFromServiceMsg);
        return;
        if (localRespDelFace.uFaceTimeStamp > paramFromServiceMsg.uFaceTimeStamp) {
          paramFromServiceMsg.uFaceTimeStamp = localRespDelFace.uFaceTimeStamp;
        }
        paramFromServiceMsg.removePortrait(arrayOfByte);
        a(12, true, new Object[] { paramBundle, paramFromServiceMsg });
        continue;
        a(12, false, new Object[] { paramBundle, paramFromServiceMsg });
        continue;
        a(12, false, new Object[] { paramBundle, paramFromServiceMsg });
      }
    }
    paramBundle.putInt("result", -1);
    a(12, false, new Object[] { paramBundle, ((FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).b(paramToServiceMsg.getUin()) });
  }
  
  private void r(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    String str;
    boolean bool3;
    boolean bool2;
    boolean bool4;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "handleSetPCActiveState success=" + bool1);
      }
      paramFromServiceMsg = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131437531);
      str = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      bool3 = bool1;
      if (!bool1) {
        break label601;
      }
      bool2 = bool1;
      bool4 = bool1;
    }
    for (;;)
    {
      try
      {
        paramObject = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if (paramObject == null) {
          continue;
        }
        bool2 = bool1;
        bool4 = bool1;
        if (paramObject.uint32_result.get() != 0) {
          continue;
        }
        bool1 = true;
        bool2 = bool1;
        bool4 = bool1;
        if (QLog.isColorLevel())
        {
          bool2 = bool1;
          bool4 = bool1;
          QLog.d("Q.profilecard.", 2, "handleSetPCActiveState result=" + bool1);
        }
        bool3 = bool1;
        if (!bool1) {
          break label601;
        }
        bool2 = bool1;
        bool4 = bool1;
        bool3 = bool1;
        if (!paramObject.bytes_bodybuffer.has()) {
          break label601;
        }
        bool2 = bool1;
        bool4 = bool1;
        bool3 = bool1;
        if (paramObject.bytes_bodybuffer.get() == null) {
          break label601;
        }
        bool2 = bool1;
        bool4 = bool1;
        int i = ByteBuffer.wrap(paramObject.bytes_bodybuffer.get().toByteArray()).getInt();
        long l = i;
        if (i < 0) {
          l = i & 0x7FFFFFFF | 0x80000000;
        }
        bool2 = bool1;
        bool4 = bool1;
        if (!this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(String.valueOf(l))) {
          continue;
        }
        bool2 = bool1;
        bool4 = bool1;
        bool1 = paramToServiceMsg.extraData.getBoolean("switch");
        bool2 = true;
        bool3 = bool1;
        bool4 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.profilecard.", 2, "handleSetPCActiveState result=" + bool2 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
          bool4 = bool2;
          bool3 = bool1;
        }
      }
      catch (Exception paramObject)
      {
        bool4 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        bool4 = bool2;
        QLog.d("Q.profilecard.", 2, "handleSetPCActiveState ex", paramObject);
        if (!QLog.isColorLevel()) {
          break label591;
        }
        QLog.d("Q.profilecard.", 2, "handleSetPCActiveState result=" + bool2 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
        bool3 = false;
        bool4 = bool2;
        continue;
      }
      finally
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.", 2, "handleSetPCActiveState result=" + bool4 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
      }
      a(55, bool4, new Object[] { Boolean.valueOf(bool3), paramFromServiceMsg, str });
      return;
      bool1 = false;
      break;
      bool1 = false;
      continue;
      bool1 = false;
      bool2 = false;
      continue;
      label591:
      bool3 = false;
      bool4 = bool2;
      continue;
      label601:
      bool1 = false;
      bool2 = bool3;
    }
  }
  
  private void r(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    int j = 0;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramFromServiceMsg = (RespGetFace)paramObject;
      if (paramFromServiceMsg.stHeader.iReplyCode == 0)
      {
        long l = paramToServiceMsg.extraData.getLong("lNextMid");
        paramToServiceMsg = paramToServiceMsg.extraData.getString("lUin");
        paramBundle.putString("lUin", paramToServiceMsg);
        paramBundle.putLong("nextMid", l);
        paramBundle.putByteArray("strCookie", paramFromServiceMsg.stUserData.strCookie);
        paramObject = paramFromServiceMsg.vFaceInfo;
        paramFromServiceMsg = new ArrayList();
        int i = 0;
        while (i < paramObject.size())
        {
          paramFromServiceMsg.add(HexUtil.a(((FaceInfo)paramObject.get(i)).vFaceID));
          i += 1;
        }
        paramBundle.putStringArrayList("hexFaceInfo", paramFromServiceMsg);
        paramObject = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
        paramToServiceMsg = paramObject.a(paramToServiceMsg);
        if (paramToServiceMsg == null) {}
        for (i = j;; i = paramToServiceMsg.getLocalPicKeysCount())
        {
          if ((paramToServiceMsg != null) && (l == i) && (i < paramToServiceMsg.getPicCountInAlbum()))
          {
            paramToServiceMsg.appendPortrait(paramFromServiceMsg);
            paramObject.a(paramToServiceMsg);
          }
          a(27, true, paramBundle);
          return;
        }
      }
      paramBundle.putString("lUin", paramToServiceMsg.extraData.getString("lUin"));
      paramBundle.putLong("nextMid", paramToServiceMsg.extraData.getLong("lNextMid"));
      paramBundle.putInt("pageSize", paramToServiceMsg.extraData.getInt("iPageSize"));
      paramBundle.putByteArray("strCookie", paramToServiceMsg.extraData.getByteArray("strCookie"));
      a(27, false, paramBundle);
      return;
    }
    paramBundle.putString("lUin", paramToServiceMsg.extraData.getString("lUin"));
    paramBundle.putLong("nextMid", paramToServiceMsg.extraData.getLong("lNextMid"));
    paramBundle.putInt("pageSize", paramToServiceMsg.extraData.getInt("iPageSize"));
    paramBundle.putByteArray("strCookie", paramToServiceMsg.extraData.getByteArray("strCookie"));
    a(27, false, paramBundle);
  }
  
  private void s(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    String str;
    boolean bool3;
    boolean bool2;
    boolean bool4;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "handleSetHelloLiveMessageState success=" + bool1);
      }
      paramFromServiceMsg = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131437531);
      str = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      bool3 = bool1;
      if (!bool1) {
        break label601;
      }
      bool2 = bool1;
      bool4 = bool1;
    }
    for (;;)
    {
      try
      {
        paramObject = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if (paramObject == null) {
          continue;
        }
        bool2 = bool1;
        bool4 = bool1;
        if (paramObject.uint32_result.get() != 0) {
          continue;
        }
        bool1 = true;
        bool2 = bool1;
        bool4 = bool1;
        if (QLog.isColorLevel())
        {
          bool2 = bool1;
          bool4 = bool1;
          QLog.d("Q.profilecard.", 2, "handleSetHelloLiveMessageState result=" + bool1);
        }
        bool3 = bool1;
        if (!bool1) {
          break label601;
        }
        bool2 = bool1;
        bool4 = bool1;
        bool3 = bool1;
        if (!paramObject.bytes_bodybuffer.has()) {
          break label601;
        }
        bool2 = bool1;
        bool4 = bool1;
        bool3 = bool1;
        if (paramObject.bytes_bodybuffer.get() == null) {
          break label601;
        }
        bool2 = bool1;
        bool4 = bool1;
        int i = ByteBuffer.wrap(paramObject.bytes_bodybuffer.get().toByteArray()).getInt();
        long l = i;
        if (i < 0) {
          l = i & 0x7FFFFFFF | 0x80000000;
        }
        bool2 = bool1;
        bool4 = bool1;
        if (!this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(String.valueOf(l))) {
          continue;
        }
        bool2 = bool1;
        bool4 = bool1;
        bool1 = paramToServiceMsg.extraData.getBoolean("switch");
        bool2 = true;
        bool3 = bool1;
        bool4 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.profilecard.", 2, "handleSetPCActiveState result=" + bool2 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
          bool4 = bool2;
          bool3 = bool1;
        }
      }
      catch (Exception paramObject)
      {
        bool4 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        bool4 = bool2;
        QLog.d("Q.profilecard.", 2, "handleSetPCActiveState ex", paramObject);
        if (!QLog.isColorLevel()) {
          break label591;
        }
        QLog.d("Q.profilecard.", 2, "handleSetPCActiveState result=" + bool2 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
        bool3 = false;
        bool4 = bool2;
        continue;
      }
      finally
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.", 2, "handleSetPCActiveState result=" + bool4 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
      }
      a(88, bool4, new Object[] { Boolean.valueOf(bool3), paramFromServiceMsg, str });
      return;
      bool1 = false;
      break;
      bool1 = false;
      continue;
      bool1 = false;
      bool2 = false;
      continue;
      label591:
      bool3 = false;
      bool4 = bool2;
      continue;
      label601:
      bool1 = false;
      bool2 = bool3;
    }
  }
  
  private void s(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    Object localObject = (String)paramToServiceMsg.getAttribute("nickname");
    paramBundle = (Byte)paramToServiceMsg.getAttribute("gender");
    Integer localInteger = (Integer)paramToServiceMsg.getAttribute("birthday");
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.Detail", 2, "onRecievSetUserInfo|resp.getResultCode = " + paramFromServiceMsg.getResultCode());
    }
    if ((paramFromServiceMsg.isSuccess()) && ((paramObject instanceof SetUserInfoResp)))
    {
      paramObject = (SetUserInfoResp)paramObject;
      paramFromServiceMsg = paramObject;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.Detail", 2, "onRecievSetUserInfo|setUserInfoResp.result = " + paramObject.result);
      }
    }
    for (paramFromServiceMsg = paramObject;; paramFromServiceMsg = null)
    {
      paramObject = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.result == 0))
      {
        String str = paramToServiceMsg.getUin();
        paramFromServiceMsg = paramObject.a(paramToServiceMsg.getUin());
        Friends localFriends = paramObject.c(str);
        if (localObject != null)
        {
          if (paramFromServiceMsg != null) {
            paramFromServiceMsg.strNick = ((String)localObject);
          }
          if (localFriends != null)
          {
            localFriends.name = ((String)localObject);
            paramObject.a(localFriends);
          }
          if (Utils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), str)) {
            this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().setProperty(Constants.PropertiesKey.nickName.toString() + str, (String)localObject);
          }
        }
        if (paramBundle != null)
        {
          if (paramFromServiceMsg != null) {
            paramFromServiceMsg.shGender = ((short)paramBundle.byteValue());
          }
          if (Utils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), str))
          {
            localObject = (NearbyCardManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(105);
            if (localObject != null) {
              ((NearbyCardManager)localObject).b(paramBundle.byteValue());
            }
          }
        }
        if ((localInteger != null) && (paramFromServiceMsg != null))
        {
          paramFromServiceMsg.lBirthday = localInteger.intValue();
          paramFromServiceMsg.shAge = ((short)ProfileUtil.a(localInteger.intValue()));
          paramFromServiceMsg.age = ((byte)paramFromServiceMsg.shAge);
          if (Utils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), str))
          {
            paramBundle = (NearbyCardManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(105);
            if (paramBundle != null) {
              paramBundle.a(paramFromServiceMsg.age);
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.Detail", 2, "onRecievSetUserInfo()  age = " + paramFromServiceMsg.age);
          }
        }
        if (paramFromServiceMsg != null) {
          paramObject.a(paramFromServiceMsg);
        }
        a(paramToServiceMsg, 31, true, paramFromServiceMsg);
        return;
      }
      a(paramToServiceMsg, 31, false, paramObject.b(paramToServiceMsg.getUin()));
      return;
    }
  }
  
  /* Error */
  private void t(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 10
    //   3: iconst_0
    //   4: istore 11
    //   6: iconst_0
    //   7: istore 12
    //   9: iconst_0
    //   10: istore 9
    //   12: aload_2
    //   13: invokevirtual 88	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   16: ifeq +400 -> 416
    //   19: aload_3
    //   20: ifnull +396 -> 416
    //   23: iconst_1
    //   24: istore 5
    //   26: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   29: ifeq +30 -> 59
    //   32: ldc 95
    //   34: iconst_2
    //   35: new 18	java/lang/StringBuilder
    //   38: dup
    //   39: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   42: ldc_w 4314
    //   45: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: iload 5
    //   50: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   53: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   56: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   59: iload 5
    //   61: istore 8
    //   63: iload 5
    //   65: ifeq +698 -> 763
    //   68: iload 5
    //   70: istore 7
    //   72: iload 5
    //   74: istore 6
    //   76: new 122	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   79: dup
    //   80: invokespecial 123	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   83: aload_3
    //   84: checkcast 125	[B
    //   87: checkcast 125	[B
    //   90: invokevirtual 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   93: checkcast 122	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   96: astore_2
    //   97: aload_2
    //   98: ifnull +324 -> 422
    //   101: iload 5
    //   103: istore 7
    //   105: iload 5
    //   107: istore 6
    //   109: aload_2
    //   110: getfield 133	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   113: invokevirtual 138	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   116: ifne +306 -> 422
    //   119: iconst_1
    //   120: istore 5
    //   122: iload 5
    //   124: istore 7
    //   126: iload 5
    //   128: istore 6
    //   130: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   133: ifeq +38 -> 171
    //   136: iload 5
    //   138: istore 7
    //   140: iload 5
    //   142: istore 6
    //   144: ldc 95
    //   146: iconst_2
    //   147: new 18	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   154: ldc_w 4316
    //   157: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: iload 5
    //   162: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   165: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   171: iload 5
    //   173: istore 8
    //   175: iload 5
    //   177: ifeq +586 -> 763
    //   180: iload 5
    //   182: istore 7
    //   184: iload 5
    //   186: istore 6
    //   188: iload 5
    //   190: istore 8
    //   192: aload_2
    //   193: getfield 144	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   196: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   199: ifeq +564 -> 763
    //   202: iload 5
    //   204: istore 7
    //   206: iload 5
    //   208: istore 6
    //   210: iload 5
    //   212: istore 8
    //   214: aload_2
    //   215: getfield 144	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   218: invokevirtual 152	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   221: ifnull +542 -> 763
    //   224: iload 5
    //   226: istore 7
    //   228: iload 5
    //   230: istore 6
    //   232: aload_2
    //   233: getfield 144	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   236: invokevirtual 152	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   239: invokevirtual 158	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   242: invokestatic 164	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   245: astore_2
    //   246: iload 5
    //   248: istore 7
    //   250: iload 5
    //   252: istore 6
    //   254: aload_2
    //   255: invokevirtual 167	java/nio/ByteBuffer:getInt	()I
    //   258: istore 4
    //   260: iload 4
    //   262: i2l
    //   263: lstore 13
    //   265: iload 4
    //   267: ifge +12 -> 279
    //   270: iload 4
    //   272: ldc_w 554
    //   275: iand
    //   276: i2l
    //   277: lstore 13
    //   279: iload 5
    //   281: istore 7
    //   283: iload 5
    //   285: istore 6
    //   287: aload_2
    //   288: invokevirtual 170	java/nio/ByteBuffer:get	()B
    //   291: pop
    //   292: iload 5
    //   294: istore 7
    //   296: iload 5
    //   298: istore 6
    //   300: aload_2
    //   301: invokevirtual 174	java/nio/ByteBuffer:getShort	()S
    //   304: invokestatic 179	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   307: invokevirtual 182	java/lang/Short:shortValue	()S
    //   310: iconst_1
    //   311: if_icmpne +247 -> 558
    //   314: iload 5
    //   316: istore 7
    //   318: iload 5
    //   320: istore 6
    //   322: aload_2
    //   323: invokevirtual 174	java/nio/ByteBuffer:getShort	()S
    //   326: istore 4
    //   328: iload 4
    //   330: sipush -25181
    //   333: if_icmpeq +95 -> 428
    //   336: iconst_0
    //   337: istore 5
    //   339: iload 9
    //   341: istore 6
    //   343: iload 5
    //   345: istore 7
    //   347: iload 6
    //   349: istore 8
    //   351: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   354: ifeq +48 -> 402
    //   357: ldc 95
    //   359: iconst_2
    //   360: new 18	java/lang/StringBuilder
    //   363: dup
    //   364: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   367: ldc_w 4316
    //   370: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: iload 5
    //   375: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   378: ldc 184
    //   380: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: iload 6
    //   385: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   388: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   391: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   394: iload 6
    //   396: istore 8
    //   398: iload 5
    //   400: istore 7
    //   402: aload_0
    //   403: bipush 89
    //   405: iload 7
    //   407: iload 8
    //   409: invokestatic 195	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   412: invokevirtual 198	com/tencent/mobileqq/app/CardHandler:a	(IZLjava/lang/Object;)V
    //   415: return
    //   416: iconst_0
    //   417: istore 5
    //   419: goto -393 -> 26
    //   422: iconst_0
    //   423: istore 5
    //   425: goto -303 -> 122
    //   428: iload 5
    //   430: istore 7
    //   432: iload 5
    //   434: istore 6
    //   436: aload_2
    //   437: invokevirtual 174	java/nio/ByteBuffer:getShort	()S
    //   440: istore 4
    //   442: iload 4
    //   444: iconst_2
    //   445: if_icmpne +103 -> 548
    //   448: iload 5
    //   450: istore 7
    //   452: iload 5
    //   454: istore 6
    //   456: iload 4
    //   458: newarray byte
    //   460: astore_3
    //   461: iload 5
    //   463: istore 7
    //   465: iload 5
    //   467: istore 6
    //   469: aload_2
    //   470: aload_3
    //   471: invokevirtual 200	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   474: pop
    //   475: iload 5
    //   477: istore 7
    //   479: iload 5
    //   481: istore 6
    //   483: aload_3
    //   484: iconst_0
    //   485: invokestatic 205	com/tencent/mobileqq/util/Utils:a	([BI)S
    //   488: istore 4
    //   490: iload 4
    //   492: ifne +24 -> 516
    //   495: iconst_1
    //   496: istore 6
    //   498: aload_2
    //   499: invokevirtual 174	java/nio/ByteBuffer:getShort	()S
    //   502: istore 4
    //   504: iload 4
    //   506: ifeq +16 -> 522
    //   509: iload 10
    //   511: istore 5
    //   513: goto -170 -> 343
    //   516: iconst_0
    //   517: istore 6
    //   519: goto -21 -> 498
    //   522: aload_0
    //   523: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   526: invokevirtual 544	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   529: aload_1
    //   530: invokevirtual 1516	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   533: aconst_null
    //   534: ldc_w 2415
    //   537: iload 6
    //   539: invokestatic 2389	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:writeValue	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   542: iconst_1
    //   543: istore 5
    //   545: goto -32 -> 513
    //   548: iconst_0
    //   549: istore 5
    //   551: iload 9
    //   553: istore 6
    //   555: goto -212 -> 343
    //   558: iconst_0
    //   559: istore 5
    //   561: iload 9
    //   563: istore 6
    //   565: goto -222 -> 343
    //   568: astore_1
    //   569: iload 7
    //   571: istore 6
    //   573: iload 11
    //   575: istore 5
    //   577: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   580: ifeq +13 -> 593
    //   583: ldc 95
    //   585: iconst_2
    //   586: ldc_w 4318
    //   589: aload_1
    //   590: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   593: iload 6
    //   595: istore 7
    //   597: iload 5
    //   599: istore 8
    //   601: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   604: ifeq -202 -> 402
    //   607: ldc 95
    //   609: iconst_2
    //   610: new 18	java/lang/StringBuilder
    //   613: dup
    //   614: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   617: ldc_w 4316
    //   620: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   623: iload 6
    //   625: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   628: ldc 184
    //   630: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   633: iload 5
    //   635: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   638: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   641: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   644: iload 6
    //   646: istore 7
    //   648: iload 5
    //   650: istore 8
    //   652: goto -250 -> 402
    //   655: astore_1
    //   656: iload 12
    //   658: istore 5
    //   660: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   663: ifeq +40 -> 703
    //   666: ldc 95
    //   668: iconst_2
    //   669: new 18	java/lang/StringBuilder
    //   672: dup
    //   673: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   676: ldc_w 4316
    //   679: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   682: iload 6
    //   684: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   687: ldc 184
    //   689: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: iload 5
    //   694: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   697: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   700: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   703: aload_1
    //   704: athrow
    //   705: astore_1
    //   706: iload 6
    //   708: istore 7
    //   710: iload 5
    //   712: istore 6
    //   714: iload 7
    //   716: istore 5
    //   718: goto -58 -> 660
    //   721: astore_1
    //   722: iload 6
    //   724: istore 5
    //   726: iconst_1
    //   727: istore 6
    //   729: goto -69 -> 660
    //   732: astore_1
    //   733: goto -73 -> 660
    //   736: astore_1
    //   737: iload 6
    //   739: istore 7
    //   741: iload 5
    //   743: istore 6
    //   745: iload 7
    //   747: istore 5
    //   749: goto -172 -> 577
    //   752: astore_1
    //   753: iload 6
    //   755: istore 5
    //   757: iconst_1
    //   758: istore 6
    //   760: goto -183 -> 577
    //   763: iload 8
    //   765: istore 5
    //   767: iload 9
    //   769: istore 6
    //   771: goto -428 -> 343
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	774	0	this	CardHandler
    //   0	774	1	paramToServiceMsg	ToServiceMsg
    //   0	774	2	paramFromServiceMsg	FromServiceMsg
    //   0	774	3	paramObject	Object
    //   258	247	4	i	int
    //   24	742	5	bool1	boolean
    //   74	696	6	bool2	boolean
    //   70	676	7	bool3	boolean
    //   61	703	8	bool4	boolean
    //   10	758	9	bool5	boolean
    //   1	509	10	bool6	boolean
    //   4	570	11	bool7	boolean
    //   7	650	12	bool8	boolean
    //   263	15	13	l	long
    // Exception table:
    //   from	to	target	type
    //   76	97	568	java/lang/Exception
    //   109	119	568	java/lang/Exception
    //   130	136	568	java/lang/Exception
    //   144	171	568	java/lang/Exception
    //   192	202	568	java/lang/Exception
    //   214	224	568	java/lang/Exception
    //   232	246	568	java/lang/Exception
    //   254	260	568	java/lang/Exception
    //   287	292	568	java/lang/Exception
    //   300	314	568	java/lang/Exception
    //   322	328	568	java/lang/Exception
    //   436	442	568	java/lang/Exception
    //   456	461	568	java/lang/Exception
    //   469	475	568	java/lang/Exception
    //   483	490	568	java/lang/Exception
    //   76	97	655	finally
    //   109	119	655	finally
    //   130	136	655	finally
    //   144	171	655	finally
    //   192	202	655	finally
    //   214	224	655	finally
    //   232	246	655	finally
    //   254	260	655	finally
    //   287	292	655	finally
    //   300	314	655	finally
    //   322	328	655	finally
    //   436	442	655	finally
    //   456	461	655	finally
    //   469	475	655	finally
    //   483	490	655	finally
    //   498	504	705	finally
    //   522	542	721	finally
    //   577	593	732	finally
    //   498	504	736	java/lang/Exception
    //   522	542	752	java/lang/Exception
  }
  
  private void t(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    Object localObject2 = null;
    localObject3 = null;
    localObject4 = null;
    bool4 = false;
    localObject1 = localObject2;
    bool1 = bool4;
    if (paramObject != null)
    {
      localObject1 = localObject2;
      bool1 = bool4;
      if (paramFromServiceMsg != null)
      {
        localObject1 = localObject2;
        bool1 = bool4;
        if (paramFromServiceMsg.isSuccess()) {
          localObject1 = localObject3;
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = paramToServiceMsg.extraData;
        if (localObject2 == null) {
          continue;
        }
        localObject1 = localObject3;
        paramToServiceMsg = ((Bundle)localObject2).getString("targetUin");
        if (localObject2 == null) {
          continue;
        }
        localObject1 = localObject3;
        localObject2 = ((Bundle)localObject2).getString("selfUin");
        localObject1 = localObject3;
        paramBundle.putString("targetUin", paramToServiceMsg);
        localObject1 = localObject3;
        paramBundle.putString("selfUin", (String)localObject2);
        localObject1 = localObject3;
        paramBundle = new oidb_sso.OIDBSSOPkg();
        localObject1 = localObject3;
        paramObject = (byte[])paramObject;
        localObject1 = localObject3;
        QLog.d("Q.profilecard.", 1, "handle_oidb_0x5eb_17 " + paramFromServiceMsg.isSuccess() + ", " + paramObject.length);
        localObject1 = localObject3;
        paramBundle.mergeFrom(paramObject);
        localObject1 = localObject3;
        if (!paramBundle.uint32_result.has()) {
          continue;
        }
        localObject1 = localObject3;
        if (paramBundle.uint32_result.get() != 0) {
          continue;
        }
        localObject1 = localObject3;
        paramFromServiceMsg = new oidb_0x5eb.RspBody();
        localObject1 = localObject3;
        paramFromServiceMsg.mergeFrom(paramBundle.bytes_bodybuffer.get().toByteArray());
        localObject1 = localObject3;
        if (paramFromServiceMsg.rpt_msg_uin_data.size() <= 0) {
          continue;
        }
        localObject1 = localObject3;
        paramFromServiceMsg = (oidb_0x5eb.UdcUinData)paramFromServiceMsg.rpt_msg_uin_data.get(0);
        localObject1 = localObject3;
        if (paramFromServiceMsg.uint32_music_ring_visible.get() != 1) {
          continue;
        }
        bool1 = true;
        localObject1 = localObject3;
        if (paramFromServiceMsg.uint32_music_ring_autoplay.get() != 1) {
          continue;
        }
        bool2 = true;
        localObject1 = localObject3;
        if (paramFromServiceMsg.uint32_music_ring_redpoint.get() != 1) {
          continue;
        }
        bool3 = true;
        localObject1 = localObject3;
        if (TextUtils.isEmpty(paramToServiceMsg)) {
          continue;
        }
        localObject1 = localObject3;
        paramFromServiceMsg = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
        localObject1 = localObject3;
        paramToServiceMsg = paramFromServiceMsg.b(paramToServiceMsg);
        if (paramToServiceMsg == null) {
          continue;
        }
        localObject1 = paramToServiceMsg;
        paramToServiceMsg.visibleMusicPendant = bool1;
        localObject1 = paramToServiceMsg;
        paramToServiceMsg.autoPlayMusicPendant = bool2;
        localObject1 = paramToServiceMsg;
        paramToServiceMsg.showRedPointMusicPendant = bool3;
        localObject1 = paramToServiceMsg;
        paramFromServiceMsg.a(paramToServiceMsg);
      }
      catch (Throwable paramToServiceMsg)
      {
        boolean bool2;
        boolean bool3;
        QLog.e("Q.profilecard.", 1, "handleUpdateMusicPendant exception", paramToServiceMsg);
        bool1 = bool4;
        continue;
        localObject1 = localObject3;
        QLog.e("CardHandler", 1, "handleUpdateMusicPendant() targetUin is empty");
        paramToServiceMsg = null;
        continue;
        bool1 = false;
        localObject1 = localObject4;
        continue;
      }
      bool1 = true;
      localObject1 = paramToServiceMsg;
      a(63, bool1, localObject1);
      return;
      paramToServiceMsg = null;
      continue;
      localObject2 = null;
      continue;
      bool1 = false;
      continue;
      bool2 = false;
      continue;
      bool3 = false;
      continue;
      localObject1 = paramToServiceMsg;
      QLog.e("CardHandler", 1, "handleUpdateMusicPendant() card is null!");
    }
  }
  
  private void u(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool6 = true;
    boolean bool3 = true;
    boolean bool8 = false;
    boolean bool7 = false;
    boolean bool1;
    boolean bool2;
    boolean bool4;
    boolean bool5;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "handlePartekeLikeRankingList success=" + bool1);
      }
      bool2 = bool1;
      if (!bool1) {
        break label521;
      }
      bool4 = bool1;
      bool5 = bool1;
    }
    label521:
    for (;;)
    {
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        bool4 = bool1;
        bool5 = bool1;
        if (paramToServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool1 = true;
        bool4 = bool1;
        bool5 = bool1;
        if (QLog.isColorLevel())
        {
          bool4 = bool1;
          bool5 = bool1;
          QLog.d("CardHandler", 2, "handlePartekeLikeRankingList result=" + bool1);
        }
        bool2 = bool1;
        if (!bool1) {
          break label521;
        }
        bool4 = bool1;
        bool5 = bool1;
        bool2 = bool1;
        if (!paramToServiceMsg.bytes_bodybuffer.has()) {
          break label521;
        }
        bool4 = bool1;
        bool5 = bool1;
        bool2 = bool1;
        if (paramToServiceMsg.bytes_bodybuffer.get() == null) {
          break label521;
        }
        bool4 = bool1;
        bool5 = bool1;
        paramFromServiceMsg = new oidb_0x5eb.RspBody();
        bool4 = bool1;
        bool5 = bool1;
        paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        bool2 = bool8;
        bool4 = bool1;
        bool5 = bool1;
        if (paramFromServiceMsg.rpt_msg_uin_data.size() > 0)
        {
          bool4 = bool1;
          bool5 = bool1;
          int i = ((oidb_0x5eb.UdcUinData)paramFromServiceMsg.rpt_msg_uin_data.get(0)).uint32_notify_partake_like_ranking_list_flag.get();
          bool1 = bool7;
          if (i == 0) {
            bool1 = true;
          }
          bool2 = true;
          bool3 = bool1;
        }
        bool1 = bool3;
        bool5 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("CardHandler", 2, "handlePartekeLikeRankingList result=" + bool2);
          bool5 = bool2;
          bool1 = bool3;
        }
      }
      catch (Exception paramToServiceMsg) {}finally
      {
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("CardHandler", 2, "handlePartekeLikeRankingList ex", paramToServiceMsg);
          }
          bool1 = bool6;
          bool5 = bool4;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("CardHandler", 2, "handlePartekeLikeRankingList result=" + bool4);
          bool1 = bool6;
          bool5 = bool4;
          continue;
        }
        finally
        {
          bool5 = bool4;
        }
        paramToServiceMsg = finally;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("CardHandler", 2, "handlePartekeLikeRankingList result=" + bool5);
      }
      a(83, bool5, Boolean.valueOf(bool1));
      return;
      bool1 = false;
      break;
      bool1 = false;
    }
  }
  
  private void u(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    paramObject = null;
    int j = 0;
    label286:
    label296:
    label299:
    for (;;)
    {
      int i;
      try
      {
        Object localObject = paramToServiceMsg.extraData.getString("targetUin");
        paramToServiceMsg = paramToServiceMsg.extraData.getString("selfUin");
        paramBundle.putString("targetUin", (String)localObject);
        paramBundle.putString("selfUin", paramToServiceMsg);
        if (paramFromServiceMsg.getResultCode() == 1000)
        {
          localObject = paramFromServiceMsg.getWupBuffer();
          paramToServiceMsg = "";
          if (localObject != null) {
            paramToServiceMsg = new String(paramFromServiceMsg.getWupBuffer()).toString();
          }
          paramToServiceMsg = new JSONObject(paramToServiceMsg);
          if ((paramToServiceMsg.has("code")) && (paramToServiceMsg.getInt("code") == 0))
          {
            if (!paramToServiceMsg.has("ringlist")) {
              break label296;
            }
            paramFromServiceMsg = paramToServiceMsg.getJSONArray("ringlist");
            break label286;
            QLog.e("Q.profilecard.", 1, "handleMusicPendantSongList Get Song count:" + i);
            paramObject = new SongInfo[i];
            paramToServiceMsg = paramObject;
            if (j < i)
            {
              paramObject[j] = a(paramFromServiceMsg.getJSONObject(j));
              j += 1;
              continue;
              i = paramFromServiceMsg.length();
              continue;
            }
          }
          else
          {
            QLog.e("Q.profilecard.", 1, "handleMusicPendantSongList responseString:" + paramToServiceMsg.getString("msg"));
            paramToServiceMsg = paramObject;
          }
          paramBundle.putSerializable("songList", paramToServiceMsg);
          a(64, true, paramBundle);
        }
        else
        {
          a(64, false, paramBundle);
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.e("CardHandler", 1, "MusicGeneWebViewPlugin.convertJSonObject2MusicGeneSongInfo exception", paramToServiceMsg);
        return;
      }
      for (;;)
      {
        if (paramFromServiceMsg != null) {
          break label299;
        }
        i = 0;
        break;
        paramFromServiceMsg = null;
      }
    }
  }
  
  private void v()
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
      {
        a(71, false, new Object[] { "" });
        return;
      }
      String str1 = (String)this.jdField_a_of_type_JavaUtilArrayList.remove(0);
      if (TextUtils.isEmpty(str1))
      {
        a(71, false, new Object[] { "" });
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qzonephotowall", 2, "uploadPhotoWall filePath:" + str2);
    }
    ??? = new PhotoWallUploadTask(str2);
    ((PhotoWallUploadTask)???).flowId = ((int)System.currentTimeMillis() / 1000);
    ((PhotoWallUploadTask)???).sRefer = "mqq";
    ((PhotoWallUploadTask)???).iUin = Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    ((PhotoWallUploadTask)???).vLoginData = VipUploadUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    ((PhotoWallUploadTask)???).op = 1;
    ((PhotoWallUploadTask)???).source = 1;
    ((PhotoWallUploadTask)???).uploadTaskCallback = new zbc(this);
    ((PhotoWallUploadTask)???).uploadFilePath = str2;
    ((PhotoWallUploadTask)???).md5 = VipUploadUtils.a(str2);
    ((PhotoWallUploadTask)???).autoRotate = true;
    if (!IUploadService.UploadServiceCreator.getInstance().isInitialized()) {
      IUploadService.UploadServiceCreator.getInstance().init(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), new zbd(this, Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())), null, null, new UploadEnv());
    }
    IUploadService.UploadServiceCreator.getInstance().upload((AbstractUploadTask)???);
  }
  
  private void v(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    boolean bool4;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "handleGetKPLInfo success=" + bool1);
      }
      bool4 = bool1;
      if (bool1)
      {
        bool2 = bool1;
        bool3 = bool1;
      }
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        bool2 = bool1;
        bool3 = bool1;
        if (paramToServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool1 = true;
        bool2 = bool1;
        bool3 = bool1;
        if (QLog.isColorLevel())
        {
          bool2 = bool1;
          bool3 = bool1;
          QLog.d("CardHandler", 2, "handleGetKPLInfo result=" + bool1);
        }
        if (!bool1) {
          continue;
        }
        bool2 = bool1;
        bool3 = bool1;
        if (!paramToServiceMsg.bytes_bodybuffer.has()) {
          continue;
        }
        bool2 = bool1;
        bool3 = bool1;
        if (paramToServiceMsg.bytes_bodybuffer.get() == null) {
          continue;
        }
        bool2 = bool1;
        bool3 = bool1;
        paramFromServiceMsg = new oidb_0xa28.RspBody();
        bool2 = bool1;
        bool3 = bool1;
        paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        bool2 = bool1;
        bool3 = bool1;
        paramToServiceMsg = KplCard.parseProto(paramFromServiceMsg, this.jdField_c_of_type_JavaLangString);
        bool2 = bool1;
        bool3 = bool1;
        ((FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(paramToServiceMsg);
        bool2 = bool1;
        bool3 = bool1;
        a(91, bool1, paramToServiceMsg);
        bool4 = bool1;
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        bool3 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        bool3 = bool2;
        QLog.d("CardHandler", 2, "handleGetKPLInfo ex", paramToServiceMsg);
        return;
      }
      finally
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("CardHandler", 2, "handleGetKPLInfo result=" + bool3);
      }
      bool1 = false;
      break;
      bool1 = false;
      continue;
      bool4 = bool1;
      bool2 = bool1;
      bool3 = bool1;
      if (QLog.isColorLevel())
      {
        bool2 = bool1;
        bool3 = bool1;
        QLog.d("CardHandler", 2, "handleGetKPLInfo failed:" + paramToServiceMsg.uint32_result.get());
        bool4 = bool1;
      }
    }
  }
  
  private void w(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    boolean bool4;
    boolean bool2;
    boolean bool3;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "handleGetSigninRedTouch success=" + bool1);
      }
      bool4 = bool1;
      if (bool1)
      {
        bool2 = bool1;
        bool3 = bool1;
      }
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        bool2 = bool1;
        bool3 = bool1;
        if (paramToServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool1 = true;
        bool2 = bool1;
        bool3 = bool1;
        if (QLog.isColorLevel())
        {
          bool2 = bool1;
          bool3 = bool1;
          QLog.d("CardHandler", 2, "handleGetSigninRedTouch result=" + bool1);
        }
        if (!bool1) {
          break label1328;
        }
        bool2 = bool1;
        bool3 = bool1;
        if (!paramToServiceMsg.bytes_bodybuffer.has()) {
          break label1328;
        }
        bool2 = bool1;
        bool3 = bool1;
        if (paramToServiceMsg.bytes_bodybuffer.get() == null) {
          break label1328;
        }
        bool2 = bool1;
        bool3 = bool1;
        Object localObject = new cmd0x922.RspBody();
        bool2 = bool1;
        bool3 = bool1;
        ((cmd0x922.RspBody)localObject).mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        bool2 = bool1;
        bool3 = bool1;
        i = ((cmd0x922.RspBody)localObject).uint32_need_update_flag.get();
        bool2 = bool1;
        bool3 = bool1;
        l1 = ((cmd0x922.RspBody)localObject).uint64_timestamp.get();
        bool2 = bool1;
        bool3 = bool1;
        long l2 = ((cmd0x922.RspBody)localObject).uint32_next_req_time.get();
        bool2 = bool1;
        bool3 = bool1;
        paramFromServiceMsg = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
        bool2 = bool1;
        bool3 = bool1;
        paramFromServiceMsg.edit().putLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c() + "sign_in_next_get_time", l2 * 1000L).commit();
        if (i != 1) {
          continue;
        }
        bool2 = bool1;
        bool3 = bool1;
        i = ((cmd0x922.RspBody)localObject).msg_push_info.uint32_type.get();
        bool2 = bool1;
        bool3 = bool1;
        int j = ((cmd0x922.RspBody)localObject).msg_push_info.uint32_red_point.get();
        bool2 = bool1;
        bool3 = bool1;
        int k = ((cmd0x922.RspBody)localObject).msg_push_info.uint32_day.get();
        bool2 = bool1;
        bool3 = bool1;
        paramToServiceMsg = new String(((cmd0x922.RspBody)localObject).msg_push_info.bytes_prompt.get().toByteArray());
        bool2 = bool1;
        bool3 = bool1;
        paramObject = new String(((cmd0x922.RspBody)localObject).msg_push_info.bytes_url.get().toByteArray());
        bool2 = bool1;
        bool3 = bool1;
        String str = new String(((cmd0x922.RspBody)localObject).msg_push_info.bytes_icon_url.get().toByteArray());
        bool2 = bool1;
        bool3 = bool1;
        int m = ((cmd0x922.RspBody)localObject).msg_push_info.uint32_lst_checkin_time.get();
        bool2 = bool1;
        bool3 = bool1;
        int n = ((cmd0x922.RspBody)localObject).msg_push_info.uint32_open_func.get();
        bool2 = bool1;
        bool3 = bool1;
        localObject = new JSONObject();
        bool2 = bool1;
        bool3 = bool1;
        ((JSONObject)localObject).put("type", i);
        bool2 = bool1;
        bool3 = bool1;
        ((JSONObject)localObject).put("redpoint", j);
        bool2 = bool1;
        bool3 = bool1;
        ((JSONObject)localObject).put("day", k);
        bool2 = bool1;
        bool3 = bool1;
        ((JSONObject)localObject).put("wording", paramToServiceMsg);
        bool2 = bool1;
        bool3 = bool1;
        ((JSONObject)localObject).put("url", paramObject);
        bool2 = bool1;
        bool3 = bool1;
        ((JSONObject)localObject).put("iconUrl", str);
        bool2 = bool1;
        bool3 = bool1;
        ((JSONObject)localObject).put("lastTime", m);
        bool2 = bool1;
        bool3 = bool1;
        ((JSONObject)localObject).put("openfunc", n);
        bool2 = bool1;
        bool3 = bool1;
        localObject = ((JSONObject)localObject).toString();
        bool2 = bool1;
        bool3 = bool1;
        paramFromServiceMsg.edit().putString(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c() + "sign_in_info", (String)localObject).putLong("sign_in_time_stamp", l1).commit();
        bool2 = bool1;
        bool3 = bool1;
        if (QLog.isColorLevel())
        {
          bool2 = bool1;
          bool3 = bool1;
          QLog.d("DailySignIn", 2, "type=" + i + " redpoint=" + j + " day=" + k + " wording=" + paramToServiceMsg + " url=" + paramObject + " iconUrl=" + str + " lastTime=" + m + " openfunc=" + n);
        }
        bool2 = bool1;
        bool3 = bool1;
        a(84, bool1, null);
        bool4 = bool1;
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        int i;
        long l1;
        bool3 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        bool3 = bool2;
        QLog.d("CardHandler", 2, "handleGetSigninRedTouch ex", paramToServiceMsg);
        return;
        bool2 = bool1;
        bool3 = bool1;
        paramToServiceMsg = new JSONObject(paramToServiceMsg);
        continue;
      }
      finally
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("CardHandler", 2, "handleGetSigninRedTouch result=" + bool3);
      }
      bool1 = false;
      break;
      bool1 = false;
      continue;
      if (i == 2)
      {
        bool2 = bool1;
        bool3 = bool1;
        paramToServiceMsg = paramFromServiceMsg.getString(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c() + "sign_in_info", "");
        bool2 = bool1;
        bool3 = bool1;
        if (TextUtils.isEmpty(paramToServiceMsg))
        {
          bool2 = bool1;
          bool3 = bool1;
          paramToServiceMsg = new JSONObject();
          bool2 = bool1;
          bool3 = bool1;
          paramToServiceMsg.put("redpoint", 0);
          bool2 = bool1;
          bool3 = bool1;
          paramToServiceMsg.put("openfunc", 0);
          bool2 = bool1;
          bool3 = bool1;
          paramToServiceMsg = paramToServiceMsg.toString();
          bool2 = bool1;
          bool3 = bool1;
          paramFromServiceMsg.edit().putString(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c() + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c() + "sign_in_info", paramToServiceMsg).putLong("sign_in_time_stamp", l1).commit();
        }
        else
        {
          label1328:
          bool4 = bool1;
          bool2 = bool1;
          bool3 = bool1;
          if (QLog.isColorLevel())
          {
            bool2 = bool1;
            bool3 = bool1;
            QLog.d("DailySignIn", 2, "handleGetSigninRedTouch failed:" + paramToServiceMsg.uint32_result.get());
            bool4 = bool1;
          }
        }
      }
    }
  }
  
  /* Error */
  private void x(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 281	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   4: ldc_w 4585
    //   7: invokevirtual 4589	android/os/Bundle:getShortArray	(Ljava/lang/String;)[S
    //   10: astore 18
    //   12: iconst_m1
    //   13: istore 10
    //   15: aconst_null
    //   16: astore 16
    //   18: aconst_null
    //   19: astore 15
    //   21: aconst_null
    //   22: astore 17
    //   24: aload 17
    //   26: astore_1
    //   27: iload 10
    //   29: istore 7
    //   31: aload 16
    //   33: astore 14
    //   35: iload 10
    //   37: istore 8
    //   39: iload 10
    //   41: istore 9
    //   43: aload_2
    //   44: invokevirtual 88	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   47: ifeq +68 -> 115
    //   50: aload 17
    //   52: astore_1
    //   53: iload 10
    //   55: istore 7
    //   57: aload_3
    //   58: ifnull +57 -> 115
    //   61: aload 16
    //   63: astore 14
    //   65: iload 10
    //   67: istore 8
    //   69: iload 10
    //   71: istore 9
    //   73: new 122	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   76: dup
    //   77: invokespecial 123	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   80: aload_3
    //   81: checkcast 125	[B
    //   84: checkcast 125	[B
    //   87: invokevirtual 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   90: checkcast 122	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   93: astore_1
    //   94: aload 16
    //   96: astore 14
    //   98: iload 10
    //   100: istore 8
    //   102: iload 10
    //   104: istore 9
    //   106: aload_1
    //   107: getfield 133	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   110: invokevirtual 138	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   113: istore 7
    //   115: iload 7
    //   117: ifne +923 -> 1040
    //   120: aload 18
    //   122: ifnull +918 -> 1040
    //   125: aload 16
    //   127: astore 14
    //   129: iload 7
    //   131: istore 8
    //   133: iload 7
    //   135: istore 9
    //   137: aload_1
    //   138: getfield 144	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   141: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   144: ifeq +896 -> 1040
    //   147: aload 16
    //   149: astore 14
    //   151: iload 7
    //   153: istore 8
    //   155: iload 7
    //   157: istore 9
    //   159: aload_1
    //   160: getfield 144	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   163: invokevirtual 152	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   166: ifnull +874 -> 1040
    //   169: aload 16
    //   171: astore 14
    //   173: iload 7
    //   175: istore 8
    //   177: iload 7
    //   179: istore 9
    //   181: aload_1
    //   182: getfield 144	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   185: invokevirtual 152	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   188: invokevirtual 158	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   191: invokestatic 164	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   194: astore 17
    //   196: aload 16
    //   198: astore 14
    //   200: iload 7
    //   202: istore 8
    //   204: iload 7
    //   206: istore 9
    //   208: aload 17
    //   210: invokevirtual 167	java/nio/ByteBuffer:getInt	()I
    //   213: pop
    //   214: aload 16
    //   216: astore 14
    //   218: iload 7
    //   220: istore 8
    //   222: iload 7
    //   224: istore 9
    //   226: aload 17
    //   228: invokevirtual 170	java/nio/ByteBuffer:get	()B
    //   231: pop
    //   232: aload 16
    //   234: astore 14
    //   236: iload 7
    //   238: istore 8
    //   240: iload 7
    //   242: istore 9
    //   244: aload 17
    //   246: invokevirtual 174	java/nio/ByteBuffer:getShort	()S
    //   249: istore 4
    //   251: iconst_0
    //   252: istore 9
    //   254: aload 15
    //   256: astore_1
    //   257: aload_1
    //   258: astore 14
    //   260: iload 7
    //   262: istore 8
    //   264: aload_1
    //   265: astore_3
    //   266: aload 17
    //   268: invokevirtual 2286	java/nio/ByteBuffer:hasRemaining	()Z
    //   271: ifeq +262 -> 533
    //   274: iload 9
    //   276: iconst_1
    //   277: iadd
    //   278: istore 10
    //   280: iload 9
    //   282: iload 4
    //   284: if_icmpge +249 -> 533
    //   287: aload_1
    //   288: astore 14
    //   290: iload 7
    //   292: istore 8
    //   294: aload_1
    //   295: astore_3
    //   296: aload 17
    //   298: invokevirtual 174	java/nio/ByteBuffer:getShort	()S
    //   301: istore 5
    //   303: aload_1
    //   304: astore 14
    //   306: iload 7
    //   308: istore 8
    //   310: aload_1
    //   311: astore_3
    //   312: aload 17
    //   314: invokevirtual 174	java/nio/ByteBuffer:getShort	()S
    //   317: istore 6
    //   319: iconst_0
    //   320: istore 11
    //   322: iconst_0
    //   323: istore 9
    //   325: aload_1
    //   326: astore 14
    //   328: iload 7
    //   330: istore 8
    //   332: aload_1
    //   333: astore_3
    //   334: iload 9
    //   336: aload 18
    //   338: arraylength
    //   339: if_icmpge +19 -> 358
    //   342: iload 5
    //   344: aload 18
    //   346: iload 9
    //   348: saload
    //   349: if_icmpne +699 -> 1048
    //   352: iconst_1
    //   353: istore 11
    //   355: goto +693 -> 1048
    //   358: iload 11
    //   360: ifeq +83 -> 443
    //   363: iload 6
    //   365: iconst_2
    //   366: if_icmpne +77 -> 443
    //   369: aload_1
    //   370: astore 14
    //   372: iload 7
    //   374: istore 8
    //   376: aload_1
    //   377: astore_3
    //   378: aload 17
    //   380: invokevirtual 174	java/nio/ByteBuffer:getShort	()S
    //   383: istore 6
    //   385: aload_1
    //   386: astore_2
    //   387: aload_1
    //   388: ifnonnull +20 -> 408
    //   391: aload_1
    //   392: astore 14
    //   394: iload 7
    //   396: istore 8
    //   398: aload_1
    //   399: astore_3
    //   400: new 1428	java/util/HashMap
    //   403: dup
    //   404: invokespecial 1429	java/util/HashMap:<init>	()V
    //   407: astore_2
    //   408: aload_2
    //   409: astore 14
    //   411: iload 7
    //   413: istore 8
    //   415: aload_2
    //   416: astore_3
    //   417: aload_2
    //   418: iload 5
    //   420: invokestatic 179	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   423: iload 6
    //   425: invokestatic 179	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   428: invokeinterface 4590 3 0
    //   433: pop
    //   434: iload 10
    //   436: istore 9
    //   438: aload_2
    //   439: astore_1
    //   440: goto -183 -> 257
    //   443: aload_1
    //   444: astore 14
    //   446: iload 7
    //   448: istore 8
    //   450: aload_1
    //   451: astore_3
    //   452: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   455: ifeq +48 -> 503
    //   458: aload_1
    //   459: astore 14
    //   461: iload 7
    //   463: istore 8
    //   465: aload_1
    //   466: astore_3
    //   467: ldc_w 2626
    //   470: iconst_2
    //   471: invokestatic 443	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   474: ldc_w 4592
    //   477: iconst_2
    //   478: anewarray 447	java/lang/Object
    //   481: dup
    //   482: iconst_0
    //   483: iload 5
    //   485: invokestatic 179	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   488: aastore
    //   489: dup
    //   490: iconst_1
    //   491: iload 6
    //   493: invokestatic 179	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   496: aastore
    //   497: invokestatic 451	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   500: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   503: aload_1
    //   504: astore 14
    //   506: iload 7
    //   508: istore 8
    //   510: aload_1
    //   511: astore_3
    //   512: aload 17
    //   514: aload 17
    //   516: invokevirtual 2283	java/nio/ByteBuffer:position	()I
    //   519: iload 6
    //   521: iadd
    //   522: invokevirtual 2289	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   525: pop
    //   526: iload 10
    //   528: istore 9
    //   530: goto -273 -> 257
    //   533: aload_1
    //   534: astore_3
    //   535: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   538: ifeq +33 -> 571
    //   541: aload_1
    //   542: astore_3
    //   543: ldc_w 2626
    //   546: iconst_2
    //   547: invokestatic 443	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   550: ldc_w 4594
    //   553: iconst_1
    //   554: anewarray 447	java/lang/Object
    //   557: dup
    //   558: iconst_0
    //   559: iload 4
    //   561: invokestatic 179	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   564: aastore
    //   565: invokestatic 451	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   568: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   571: iconst_1
    //   572: istore 12
    //   574: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   577: ifeq +460 -> 1037
    //   580: invokestatic 443	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   583: astore_2
    //   584: aload 18
    //   586: ifnull +175 -> 761
    //   589: aload 18
    //   591: arraylength
    //   592: istore 8
    //   594: aload_1
    //   595: ifnull +172 -> 767
    //   598: aload_1
    //   599: invokeinterface 4595 1 0
    //   604: istore 9
    //   606: ldc_w 2626
    //   609: iconst_2
    //   610: aload_2
    //   611: ldc_w 4597
    //   614: iconst_3
    //   615: anewarray 447	java/lang/Object
    //   618: dup
    //   619: iconst_0
    //   620: iload 7
    //   622: invokestatic 74	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   625: aastore
    //   626: dup
    //   627: iconst_1
    //   628: iload 8
    //   630: invokestatic 74	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   633: aastore
    //   634: dup
    //   635: iconst_2
    //   636: iload 9
    //   638: invokestatic 74	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   641: aastore
    //   642: invokestatic 451	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   645: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   648: aload_1
    //   649: ifnull +342 -> 991
    //   652: aload_1
    //   653: invokeinterface 4595 1 0
    //   658: ifle +333 -> 991
    //   661: aload_1
    //   662: invokeinterface 4601 1 0
    //   667: invokeinterface 4604 1 0
    //   672: astore_2
    //   673: aload_2
    //   674: invokeinterface 766 1 0
    //   679: ifeq +312 -> 991
    //   682: aload_2
    //   683: invokeinterface 770 1 0
    //   688: checkcast 4606	java/util/Map$Entry
    //   691: astore_3
    //   692: aload_3
    //   693: invokeinterface 4609 1 0
    //   698: checkcast 176	java/lang/Short
    //   701: invokevirtual 182	java/lang/Short:shortValue	()S
    //   704: tableswitch	default:+20 -> 724, -23447:+23->727
    //   725: impdep2
    //   726: <illegal opcode>
    //   727: aload_0
    //   728: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   731: astore 14
    //   733: aload_3
    //   734: invokeinterface 4612 1 0
    //   739: checkcast 176	java/lang/Short
    //   742: invokevirtual 182	java/lang/Short:shortValue	()S
    //   745: ifne +240 -> 985
    //   748: iconst_1
    //   749: istore 13
    //   751: aload 14
    //   753: iload 13
    //   755: invokevirtual 2624	com/tencent/mobileqq/app/QQAppInterface:d	(Z)V
    //   758: goto -85 -> 673
    //   761: iconst_0
    //   762: istore 8
    //   764: goto -170 -> 594
    //   767: iconst_0
    //   768: istore 9
    //   770: goto -164 -> 606
    //   773: astore_2
    //   774: iconst_0
    //   775: istore 12
    //   777: iload 8
    //   779: istore 7
    //   781: aload 14
    //   783: astore_1
    //   784: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   787: ifeq +14 -> 801
    //   790: ldc_w 2626
    //   793: iconst_2
    //   794: ldc_w 4614
    //   797: aload_2
    //   798: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   801: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   804: ifeq +230 -> 1034
    //   807: invokestatic 443	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   810: astore_2
    //   811: aload 18
    //   813: ifnull +65 -> 878
    //   816: aload 18
    //   818: arraylength
    //   819: istore 8
    //   821: aload_1
    //   822: ifnull +62 -> 884
    //   825: aload_1
    //   826: invokeinterface 4595 1 0
    //   831: istore 9
    //   833: ldc_w 2626
    //   836: iconst_2
    //   837: aload_2
    //   838: ldc_w 4597
    //   841: iconst_3
    //   842: anewarray 447	java/lang/Object
    //   845: dup
    //   846: iconst_0
    //   847: iload 7
    //   849: invokestatic 74	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   852: aastore
    //   853: dup
    //   854: iconst_1
    //   855: iload 8
    //   857: invokestatic 74	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   860: aastore
    //   861: dup
    //   862: iconst_2
    //   863: iload 9
    //   865: invokestatic 74	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   868: aastore
    //   869: invokestatic 451	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   872: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   875: goto -227 -> 648
    //   878: iconst_0
    //   879: istore 8
    //   881: goto -60 -> 821
    //   884: iconst_0
    //   885: istore 9
    //   887: goto -54 -> 833
    //   890: astore_1
    //   891: aconst_null
    //   892: astore_2
    //   893: iload 9
    //   895: istore 7
    //   897: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   900: ifeq +71 -> 971
    //   903: invokestatic 443	java/util/Locale:getDefault	()Ljava/util/Locale;
    //   906: astore_3
    //   907: aload 18
    //   909: ifnull +64 -> 973
    //   912: aload 18
    //   914: arraylength
    //   915: istore 8
    //   917: aload_2
    //   918: ifnull +61 -> 979
    //   921: aload_2
    //   922: invokeinterface 4595 1 0
    //   927: istore 9
    //   929: ldc_w 2626
    //   932: iconst_2
    //   933: aload_3
    //   934: ldc_w 4597
    //   937: iconst_3
    //   938: anewarray 447	java/lang/Object
    //   941: dup
    //   942: iconst_0
    //   943: iload 7
    //   945: invokestatic 74	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   948: aastore
    //   949: dup
    //   950: iconst_1
    //   951: iload 8
    //   953: invokestatic 74	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   956: aastore
    //   957: dup
    //   958: iconst_2
    //   959: iload 9
    //   961: invokestatic 74	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   964: aastore
    //   965: invokestatic 451	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   968: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   971: aload_1
    //   972: athrow
    //   973: iconst_0
    //   974: istore 8
    //   976: goto -59 -> 917
    //   979: iconst_0
    //   980: istore 9
    //   982: goto -53 -> 929
    //   985: iconst_0
    //   986: istore 13
    //   988: goto -237 -> 751
    //   991: aload_0
    //   992: bipush 86
    //   994: iload 12
    //   996: iconst_2
    //   997: anewarray 447	java/lang/Object
    //   1000: dup
    //   1001: iconst_0
    //   1002: aload 18
    //   1004: aastore
    //   1005: dup
    //   1006: iconst_1
    //   1007: aload_1
    //   1008: aastore
    //   1009: invokevirtual 198	com/tencent/mobileqq/app/CardHandler:a	(IZLjava/lang/Object;)V
    //   1012: return
    //   1013: astore_1
    //   1014: aload_3
    //   1015: astore_2
    //   1016: goto -119 -> 897
    //   1019: astore_3
    //   1020: aload_1
    //   1021: astore_2
    //   1022: aload_3
    //   1023: astore_1
    //   1024: goto -127 -> 897
    //   1027: astore_2
    //   1028: iconst_1
    //   1029: istore 12
    //   1031: goto -247 -> 784
    //   1034: goto -386 -> 648
    //   1037: goto -389 -> 648
    //   1040: aconst_null
    //   1041: astore_1
    //   1042: iconst_0
    //   1043: istore 12
    //   1045: goto -471 -> 574
    //   1048: iload 9
    //   1050: iconst_1
    //   1051: iadd
    //   1052: istore 9
    //   1054: goto -729 -> 325
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1057	0	this	CardHandler
    //   0	1057	1	paramToServiceMsg	ToServiceMsg
    //   0	1057	2	paramFromServiceMsg	FromServiceMsg
    //   0	1057	3	paramObject	Object
    //   249	311	4	i	int
    //   301	183	5	s	short
    //   317	205	6	j	int
    //   29	915	7	k	int
    //   37	938	8	m	int
    //   41	1012	9	n	int
    //   13	514	10	i1	int
    //   320	39	11	i2	int
    //   572	472	12	bool1	boolean
    //   749	238	13	bool2	boolean
    //   33	749	14	localObject1	Object
    //   19	236	15	localObject2	Object
    //   16	217	16	localObject3	Object
    //   22	493	17	localByteBuffer	ByteBuffer
    //   10	993	18	arrayOfShort	short[]
    // Exception table:
    //   from	to	target	type
    //   43	50	773	java/lang/Exception
    //   73	94	773	java/lang/Exception
    //   106	115	773	java/lang/Exception
    //   137	147	773	java/lang/Exception
    //   159	169	773	java/lang/Exception
    //   181	196	773	java/lang/Exception
    //   208	214	773	java/lang/Exception
    //   226	232	773	java/lang/Exception
    //   244	251	773	java/lang/Exception
    //   266	274	773	java/lang/Exception
    //   296	303	773	java/lang/Exception
    //   312	319	773	java/lang/Exception
    //   334	342	773	java/lang/Exception
    //   378	385	773	java/lang/Exception
    //   400	408	773	java/lang/Exception
    //   417	434	773	java/lang/Exception
    //   452	458	773	java/lang/Exception
    //   467	503	773	java/lang/Exception
    //   512	526	773	java/lang/Exception
    //   43	50	890	finally
    //   73	94	890	finally
    //   106	115	890	finally
    //   137	147	890	finally
    //   159	169	890	finally
    //   181	196	890	finally
    //   208	214	890	finally
    //   226	232	890	finally
    //   244	251	890	finally
    //   266	274	1013	finally
    //   296	303	1013	finally
    //   312	319	1013	finally
    //   334	342	1013	finally
    //   378	385	1013	finally
    //   400	408	1013	finally
    //   417	434	1013	finally
    //   452	458	1013	finally
    //   467	503	1013	finally
    //   512	526	1013	finally
    //   535	541	1013	finally
    //   543	571	1013	finally
    //   784	801	1019	finally
    //   535	541	1027	java/lang/Exception
    //   543	571	1027	java/lang/Exception
  }
  
  private void y(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    short s1 = paramToServiceMsg.extraData.getShort("switch_id");
    short s2 = paramToServiceMsg.extraData.getShort("switch_value");
    int i = -1;
    int j = i;
    int k = i;
    int m = i;
    for (;;)
    {
      boolean bool1;
      boolean bool2;
      try
      {
        if (!paramFromServiceMsg.isSuccess()) {
          continue;
        }
        j = i;
        if (paramObject == null) {
          continue;
        }
        k = i;
        m = i;
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        k = i;
        m = i;
        i = paramToServiceMsg.uint32_result.get();
        j = i;
        if (i != 0) {
          continue;
        }
        j = i;
        k = i;
        m = i;
        if (!paramToServiceMsg.bytes_bodybuffer.has()) {
          continue;
        }
        j = i;
        k = i;
        m = i;
        if (paramToServiceMsg.bytes_bodybuffer.get() == null) {
          continue;
        }
        k = i;
        m = i;
        n = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray()).getInt();
        if (n >= 0) {
          continue;
        }
        l = n + 4294967296L;
        k = i;
        m = i;
        bool1 = String.valueOf(l).equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (!bool1) {
          continue;
        }
        bool2 = true;
        bool1 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("CommonSwitchTag", 2, String.format(Locale.getDefault(), "handleSetCommonSwitchFromDetailInfo suc: %b  result: %d  id: %d value: %d", new Object[] { Boolean.valueOf(bool2), Integer.valueOf(i), Short.valueOf(s1), Short.valueOf(s2) }));
          bool1 = bool2;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        int n;
        long l;
        m = k;
        if (!QLog.isColorLevel()) {
          continue;
        }
        m = k;
        QLog.d("CommonSwitchTag", 2, "handleSetCommonSwitchFromDetailInfo ex", paramToServiceMsg);
        if (!QLog.isColorLevel()) {
          break label616;
        }
        QLog.d("CommonSwitchTag", 2, String.format(Locale.getDefault(), "handleSetCommonSwitchFromDetailInfo suc: %b  result: %d  id: %d value: %d", new Object[] { Boolean.valueOf(false), Integer.valueOf(k), Short.valueOf(s1), Short.valueOf(s2) }));
        bool1 = false;
        continue;
      }
      finally
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("CommonSwitchTag", 2, String.format(Locale.getDefault(), "handleSetCommonSwitchFromDetailInfo suc: %b  result: %d  id: %d value: %d", new Object[] { Boolean.valueOf(false), Integer.valueOf(m), Short.valueOf(s1), Short.valueOf(s2) }));
      }
      if (bool1) {}
      switch (s1)
      {
      default: 
        a(87, bool1, new Object[] { Short.valueOf(s1), Short.valueOf(s2) });
        return;
        l = n;
        continue;
        j = i;
        k = i;
        m = i;
        if (QLog.isColorLevel())
        {
          k = i;
          m = i;
          QLog.d("CommonSwitchTag", 2, String.format(Locale.getDefault(), "handleSetCommonSwitchFromDetailInfo invalidate account info [dwUin: %d, lUin: %d, account: %s]", new Object[] { Integer.valueOf(n), Long.valueOf(l), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() }));
          j = i;
        }
        i = j;
        bool2 = false;
        break;
      case -23447: 
        paramToServiceMsg = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface;
        if (s2 == 0) {}
        for (bool2 = true;; bool2 = false)
        {
          paramToServiceMsg.d(bool2);
          break;
        }
        label616:
        bool1 = false;
      }
    }
  }
  
  private void z(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool6 = true;
    boolean bool3 = true;
    boolean bool8 = false;
    boolean bool7 = false;
    boolean bool1;
    boolean bool2;
    boolean bool4;
    boolean bool5;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "handleGetNotifyOnLikeRankingList success=" + bool1);
      }
      bool2 = bool1;
      if (!bool1) {
        break label521;
      }
      bool4 = bool1;
      bool5 = bool1;
    }
    label521:
    for (;;)
    {
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        bool4 = bool1;
        bool5 = bool1;
        if (paramToServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool1 = true;
        bool4 = bool1;
        bool5 = bool1;
        if (QLog.isColorLevel())
        {
          bool4 = bool1;
          bool5 = bool1;
          QLog.d("CardHandler", 2, "handleGetNotifyOnLikeRankingList result=" + bool1);
        }
        bool2 = bool1;
        if (!bool1) {
          break label521;
        }
        bool4 = bool1;
        bool5 = bool1;
        bool2 = bool1;
        if (!paramToServiceMsg.bytes_bodybuffer.has()) {
          break label521;
        }
        bool4 = bool1;
        bool5 = bool1;
        bool2 = bool1;
        if (paramToServiceMsg.bytes_bodybuffer.get() == null) {
          break label521;
        }
        bool4 = bool1;
        bool5 = bool1;
        paramFromServiceMsg = new oidb_0x5eb.RspBody();
        bool4 = bool1;
        bool5 = bool1;
        paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        bool2 = bool8;
        bool4 = bool1;
        bool5 = bool1;
        if (paramFromServiceMsg.rpt_msg_uin_data.size() > 0)
        {
          bool4 = bool1;
          bool5 = bool1;
          int i = ((oidb_0x5eb.UdcUinData)paramFromServiceMsg.rpt_msg_uin_data.get(0)).uint32_notify_on_like_ranking_list_flag.get();
          bool1 = bool7;
          if (i == 0) {
            bool1 = true;
          }
          bool2 = true;
          bool3 = bool1;
        }
        bool1 = bool3;
        bool5 = bool2;
        if (QLog.isColorLevel())
        {
          QLog.d("CardHandler", 2, "handleGetNotifyOnLikeRankingList result=" + bool2);
          bool5 = bool2;
          bool1 = bool3;
        }
      }
      catch (Exception paramToServiceMsg) {}finally
      {
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("CardHandler", 2, "handleGetNotifyOnLikeRankingList ex", paramToServiceMsg);
          }
          bool1 = bool6;
          bool5 = bool4;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("CardHandler", 2, "handleGetNotifyOnLikeRankingList result=" + bool4);
          bool1 = bool6;
          bool5 = bool4;
          continue;
        }
        finally
        {
          bool5 = bool4;
        }
        paramToServiceMsg = finally;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("CardHandler", 2, "handleGetNotifyOnLikeRankingList result=" + bool5);
      }
      a(79, bool5, Boolean.valueOf(bool1));
      return;
      bool1 = false;
      break;
      bool1 = false;
    }
  }
  
  public CardHandler.CardTransProcessorHandler a(QQAppInterface paramQQAppInterface, CardHandler.CoverTransCallback paramCoverTransCallback)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, String.format("addCoverTransCallback app=%s callBack=%s", new Object[] { paramQQAppInterface, paramCoverTransCallback }));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController == null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController = paramQQAppInterface.a();
    }
    paramQQAppInterface = new CardHandler.CardTransProcessorHandler(paramCoverTransCallback);
    paramQQAppInterface.a(new Class[] { NearbyPeoplePhotoUploadProcessor.class });
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.a(paramQQAppInterface);
    return paramQQAppInterface;
  }
  
  protected Class a()
  {
    return CardObserver.class;
  }
  
  public ArrayList a(int paramInt1, int paramInt2)
  {
    for (Object localObject1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();; localObject1 = null)
    {
      label152:
      try
      {
        localObject2 = (ArrayList)((EntityManager)localObject1).a(CardProfile.class, true, "type=?", new String[] { String.valueOf(paramInt1) }, null, null, "lTime desc", String.valueOf(paramInt2));
        ((EntityManager)localObject1).a();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new ArrayList(0);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject2;
          localException.printStackTrace();
          ((EntityManager)localObject1).a();
          if (0 != 0) {
            break;
          }
          localObject1 = new ArrayList(0);
        }
      }
      finally
      {
        ((EntityManager)localObject1).a();
        if (0 != 0) {
          break label152;
        }
        new ArrayList(0);
      }
      paramInt1 = 0;
      for (;;)
      {
        if (paramInt1 < ((ArrayList)localObject1).size())
        {
          localObject2 = (CardProfile)((ArrayList)localObject1).get(paramInt1);
          ((CardProfile)localObject2).updateTime(((CardProfile)localObject2).lTime);
          paramInt1 += 1;
        }
        else
        {
          return localObject1;
        }
      }
    }
  }
  
  public void a(int paramInt)
  {
    EntityManager localEntityManager = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    localEntityManager.a().a();
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("delete from ");
      localStringBuilder.append(((CardProfile)CardProfile.class.newInstance()).getTableName());
      localStringBuilder.append(" where ");
      localStringBuilder.append("type=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(";");
      localEntityManager.b(localStringBuilder.toString());
      localEntityManager.a().c();
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.i("CardHandler", 2, localException.getMessage(), localException);
      }
      return;
    }
    finally
    {
      localEntityManager.a().b();
      localEntityManager.a();
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "func getShoppingCardInfo begins, seqNo:" + paramInt + ",shoppingUin:" + paramString1 + ",uin:" + paramString2);
    }
    mobileqq_mp.GetPublicAccountDetailInfoRequest localGetPublicAccountDetailInfoRequest = new mobileqq_mp.GetPublicAccountDetailInfoRequest();
    localGetPublicAccountDetailInfoRequest.versionInfo.set("7.6.3,3,3565");
    localGetPublicAccountDetailInfoRequest.version.set(1);
    localGetPublicAccountDetailInfoRequest.seqno.set(paramInt);
    try
    {
      localGetPublicAccountDetailInfoRequest.luin.set(Long.parseLong(paramString1));
      label103:
      paramString1 = a("PubAccountSvc.get_detail_info");
      paramString1.putWupBuffer(localGetPublicAccountDetailInfoRequest.toByteArray());
      paramString1.addAttribute("uin", paramString2);
      b(paramString1);
      return;
    }
    catch (NumberFormatException paramString1)
    {
      break label103;
    }
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", String.valueOf(paramLong1), "MCardSvc.ReqPicSafetyCheck");
    localToServiceMsg.extraData.putLong("selfUin", paramLong1);
    localToServiceMsg.extraData.putLong("lToUIN", paramLong2);
    localToServiceMsg.extraData.putLong("friendUin", paramLong2);
    localToServiceMsg.extraData.putInt("iScene", paramInt);
    a(localToServiceMsg);
  }
  
  public void a(long paramLong1, long paramLong2, byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("Q.profilecard.", 4, "reqFavorite|" + paramLong2 + ",voteNum|" + paramInt2);
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", String.valueOf(paramLong1), "VisitorSvc.ReqFavorite");
    localToServiceMsg.extraData.putLong("selfUin", paramLong1);
    localToServiceMsg.extraData.putLong("targetUin", paramLong2);
    localToServiceMsg.extraData.putByteArray("vCookies", paramArrayOfByte);
    localToServiceMsg.extraData.putInt("favoriteSource", paramInt1);
    localToServiceMsg.extraData.putInt("iCount", paramInt2);
    localToServiceMsg.extraData.putInt("from", paramInt3);
    a(localToServiceMsg);
  }
  
  public void a(long paramLong, CardHandler.NowOnliveGallayCallback paramNowOnliveGallayCallback)
  {
    NowLiveGallary.ReqBody localReqBody = new NowLiveGallary.ReqBody();
    localReqBody.req_uin.set(paramLong);
    ProtoUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramNowOnliveGallayCallback, localReqBody.toByteArray(), "ilive.photo_wall");
  }
  
  public void a(PushVoteIncreaseInfo paramPushVoteIncreaseInfo, String paramString1, String paramString2)
  {
    Visitor localVisitor = (Visitor)paramPushVoteIncreaseInfo.vVoterList.get(0);
    MessageRecord localMessageRecord = MessageRecordFactory.a(-1000);
    localMessageRecord.frienduin = AppConstants.D;
    localMessageRecord.istroop = 0;
    localMessageRecord.senderuin = String.valueOf(localVisitor.lUIN);
    localMessageRecord.extraflag = paramPushVoteIncreaseInfo.iIncrement;
    localMessageRecord.time = (System.currentTimeMillis() / 1000L);
    ThreadManager.post(new zay(this, paramPushVoteIncreaseInfo.iIncrement, paramPushVoteIncreaseInfo.vVoterList), 8, null, false);
    try
    {
      Object localObject1 = new String(localVisitor.vecNick, "UTF8");
      localObject2 = localObject1;
      if (((String)localObject1).trim().length() == 0) {
        localObject2 = String.valueOf(localVisitor.lUIN);
      }
      if (1 == paramPushVoteIncreaseInfo.iIncrement)
      {
        localMessageRecord.msg = String.format(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getString(2131435024), new Object[] { localObject2 });
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localMessageRecord, paramString1);
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(1, true, true);
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("newVoteCount", paramPushVoteIncreaseInfo.iIncrement);
        ((Bundle)localObject1).putString("sender", paramString2);
        ((Bundle)localObject1).putString("voteeUin", paramString1);
        ((Bundle)localObject1).putString("uin", paramString1);
        a(28, true, new Object[] { ((FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), localObject1 });
        return;
      }
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        Object localObject2;
        if (QLog.isColorLevel()) {
          QLog.w("accost", 2, "last voter's name. unsupported encoding.");
        }
        String str = "";
        continue;
        localMessageRecord.msg = String.format(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getString(2131435025), new Object[] { localObject2, Integer.valueOf(paramPushVoteIncreaseInfo.iIncrement) });
      }
    }
  }
  
  public void a(Bundle paramBundle)
  {
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(new zaz(this, paramBundle));
  }
  
  public void a(CardHandler.CardTransProcessorHandler paramCardTransProcessorHandler)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, String.format("removeCoverTransCallback transHandler=%s", new Object[] { paramCardTransProcessorHandler }));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController != null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.b(paramCardTransProcessorHandler);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject2 = paramToServiceMsg.extraData.getString("friendUin");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = paramFromServiceMsg.getUin();
    }
    if (a(paramFromServiceMsg.getServiceCmd())) {}
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          return;
                          localObject2 = new Bundle();
                          ((Bundle)localObject2).putString("uin", (String)localObject1);
                          if ("SummaryCard.ReqSummaryCard".equals(paramFromServiceMsg.getServiceCmd()))
                          {
                            if (paramToServiceMsg.extraData.getBoolean("simpleinfo_pull", false))
                            {
                              p(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                              return;
                            }
                            o(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                            return;
                          }
                          if ("SummaryCard.ReqVoiceManage".equals(paramFromServiceMsg.getServiceCmd()))
                          {
                            n(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                            return;
                          }
                          if ("MCardSvc.ReqHYMakeFriendsCard".equals(paramFromServiceMsg.getServiceCmd()))
                          {
                            m(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                            return;
                          }
                          if ("MCardSvc.ReqSetCard".equals(paramFromServiceMsg.getServiceCmd()))
                          {
                            j(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                            return;
                          }
                          if ("SummaryCard.SetLabel".equals(paramFromServiceMsg.getServiceCmd()))
                          {
                            k(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                            return;
                          }
                          if ("SummaryCard.LikeIt".equals(paramFromServiceMsg.getServiceCmd()))
                          {
                            l(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                            return;
                          }
                          if ("MCardSvc.ReqGetCardSwitch".equals(paramFromServiceMsg.getServiceCmd()))
                          {
                            h(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                            return;
                          }
                          if ("MCardSvc.ReqSetCardSwitch".equals(paramFromServiceMsg.getServiceCmd()))
                          {
                            i(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                            return;
                          }
                          if ("VisitorSvc.ReqVote".equals(paramFromServiceMsg.getServiceCmd()))
                          {
                            a(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                            return;
                          }
                          if ("VisitorSvc.ReqFavorite".equals(paramFromServiceMsg.getServiceCmd()))
                          {
                            b(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                            return;
                          }
                          if ("VisitorSvc.ReqGetVoterList".equals(paramFromServiceMsg.getServiceCmd()))
                          {
                            d(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                            return;
                          }
                          if ("VisitorSvc.ReqGetFavoriteList".equals(paramFromServiceMsg.getServiceCmd()))
                          {
                            c(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                            return;
                          }
                          if ("MCardSvc.ReqFaceInfo".equals(paramFromServiceMsg.getServiceCmd()))
                          {
                            g(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                            return;
                          }
                          if ("MCardSvc.ReqAddFace".equals(paramFromServiceMsg.getServiceCmd()))
                          {
                            f(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                            return;
                          }
                          if ("MCardSvc.ReqUpdateIntro".equals(paramFromServiceMsg.getServiceCmd()))
                          {
                            if ((paramFromServiceMsg.getResultCode() == 1000) && (paramObject != null))
                            {
                              if (((RespUpdateIntro)paramObject).stHeader.iReplyCode == 0)
                              {
                                a(9, true, ((FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).b(paramToServiceMsg.getUin()));
                                return;
                              }
                              a(9, false, localObject2);
                              return;
                            }
                            a(9, false, localObject2);
                            return;
                          }
                          if ("MCardSvc.ReqDelFace".equals(paramFromServiceMsg.getServiceCmd()))
                          {
                            q(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                            return;
                          }
                          if ("ProfileService.getGroupInfoReq".equals(paramFromServiceMsg.getServiceCmd()))
                          {
                            if (paramFromServiceMsg.getResultCode() == 1000)
                            {
                              a(17, true, ((FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).b(paramToServiceMsg.getUin()));
                              return;
                            }
                            a(17, false, localObject2);
                            return;
                          }
                          if ("ProfileService.SetUserInfoReq".equals(paramFromServiceMsg.getServiceCmd()))
                          {
                            s(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                            return;
                          }
                          if (!"AccostSvc.ClientMsg".equals(paramFromServiceMsg.getServiceCmd())) {
                            break;
                          }
                        } while (paramFromServiceMsg.getResultCode() != 1000);
                        paramToServiceMsg = (RespClientMsg)paramFromServiceMsg.getAttribute("result");
                      } while ((paramToServiceMsg == null) || (1 != paramToServiceMsg.stMsg.eAccostType));
                      a(22, true, localObject2);
                      return;
                      if ("AccostSvc.SvrMsg".equals(paramFromServiceMsg.getServiceCmd()))
                      {
                        if (paramFromServiceMsg.getResultCode() == 1000) {}
                        for (boolean bool = true;; bool = false)
                        {
                          a(29, bool, localObject2);
                          return;
                        }
                      }
                      if ("MobileQQ.SendPortraitDownloadVerifyCode".equals(paramFromServiceMsg.getServiceCmd()))
                      {
                        paramToServiceMsg = paramFromServiceMsg.extraData.getString("filekey");
                        ((Bundle)localObject2).putString("filekey", paramToServiceMsg);
                        if ((paramToServiceMsg != null) && (!"".equals(paramToServiceMsg)))
                        {
                          a(21, true, localObject2);
                          return;
                        }
                        a(21, false, localObject2);
                        return;
                      }
                      if ("MCardSvc.ReqPicSafetyCheck".equals(paramFromServiceMsg.getServiceCmd()))
                      {
                        ((Bundle)localObject2).putString("uin", String.valueOf(paramToServiceMsg.extraData.getLong("lToUIN")));
                        if (paramFromServiceMsg.getResultCode() == 1000)
                        {
                          a(23, true, localObject2);
                          return;
                        }
                        a(23, false, localObject2);
                        return;
                      }
                      if ("MCardSvc.ReqGetFace".equals(paramFromServiceMsg.getServiceCmd()))
                      {
                        r(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                        return;
                      }
                    } while ("PttCenterSvr.ReqBody".equals(paramFromServiceMsg.getServiceCmd()));
                    if ("OidbSvc.0x490_100".equals(paramFromServiceMsg.getServiceCmd()))
                    {
                      j(paramToServiceMsg, paramFromServiceMsg, paramObject);
                      return;
                    }
                    if ("OidbSvc.0x491_100".equals(paramFromServiceMsg.getServiceCmd()))
                    {
                      k(paramToServiceMsg, paramFromServiceMsg, paramObject);
                      return;
                    }
                    if ("SQQzoneSvc.getCover".equals(paramFromServiceMsg.getServiceCmd()))
                    {
                      n(paramToServiceMsg, paramFromServiceMsg, paramObject);
                      return;
                    }
                    if ("SQQzoneSvc.getPhotoWall".equals(paramFromServiceMsg.getServiceCmd()))
                    {
                      o(paramToServiceMsg, paramFromServiceMsg, paramObject);
                      return;
                    }
                    if ("SQQzoneSvc.delPhotoWall".equals(paramFromServiceMsg.getServiceCmd()))
                    {
                      p(paramToServiceMsg, paramFromServiceMsg, paramObject);
                      return;
                    }
                    if (!"OidbSvc.0x480_9".equals(paramFromServiceMsg.getServiceCmd())) {
                      break;
                    }
                  } while (!paramToServiceMsg.extraData.getBoolean("reqFromCardHandler", false));
                  if (paramToServiceMsg.extraData.getBoolean("isGetLoginDays", false))
                  {
                    A(paramToServiceMsg, paramFromServiceMsg, paramObject);
                    return;
                  }
                  if (paramToServiceMsg.extraData.getBoolean("pcActiveState", false))
                  {
                    q(paramToServiceMsg, paramFromServiceMsg, paramObject);
                    return;
                  }
                  if (paramToServiceMsg.extraData.getBoolean("helloLiveMessage", false))
                  {
                    t(paramToServiceMsg, paramFromServiceMsg, paramObject);
                    return;
                  }
                  if (paramToServiceMsg.extraData.getBoolean("isGetActivateFriend", false))
                  {
                    H(paramToServiceMsg, paramFromServiceMsg, paramObject);
                    return;
                  }
                  if (paramToServiceMsg.extraData.getBoolean("isQidianExt", false))
                  {
                    N(paramToServiceMsg, paramFromServiceMsg, paramObject);
                    return;
                  }
                  if (paramToServiceMsg.extraData.getBoolean("isGetCalReactive", false))
                  {
                    B(paramToServiceMsg, paramFromServiceMsg, paramObject);
                    return;
                  }
                  if (paramToServiceMsg.extraData.getBoolean("isGetBabyQSwitch", false))
                  {
                    J(paramToServiceMsg, paramFromServiceMsg, paramObject);
                    return;
                  }
                  if (paramToServiceMsg.extraData.getBoolean("isQidianMaster", false))
                  {
                    O(paramToServiceMsg, paramFromServiceMsg, paramObject);
                    return;
                  }
                  if (paramToServiceMsg.extraData.getBoolean("isGetCommonSwitchFromDetailInfo", false))
                  {
                    x(paramToServiceMsg, paramFromServiceMsg, paramObject);
                    return;
                  }
                  if (paramToServiceMsg.extraData.getBoolean("isOfficeUserFlag", false))
                  {
                    h(paramToServiceMsg, paramFromServiceMsg, paramObject);
                    return;
                  }
                  m(paramToServiceMsg, paramFromServiceMsg, paramObject);
                  return;
                  if (!"OidbSvc.0x4ff_9".equals(paramFromServiceMsg.getServiceCmd())) {
                    break;
                  }
                } while (!paramToServiceMsg.extraData.getBoolean("reqFromCardHandler", false));
                if (paramToServiceMsg.extraData.getBoolean("isSetLoginDays", false))
                {
                  C(paramToServiceMsg, paramFromServiceMsg, paramObject);
                  return;
                }
                if (paramToServiceMsg.extraData.getBoolean("pcActiveState", false))
                {
                  r(paramToServiceMsg, paramFromServiceMsg, paramObject);
                  return;
                }
                if (paramToServiceMsg.extraData.getBoolean("helloLiveMessage", false))
                {
                  s(paramToServiceMsg, paramFromServiceMsg, paramObject);
                  return;
                }
                if (paramToServiceMsg.extraData.getBoolean("isSetActivateFriend", false))
                {
                  I(paramToServiceMsg, paramFromServiceMsg, paramObject);
                  return;
                }
                if (paramToServiceMsg.extraData.getBoolean("calltabstate", false))
                {
                  M(paramToServiceMsg, paramFromServiceMsg, paramObject);
                  return;
                }
                if (paramToServiceMsg.extraData.getBoolean("isGetAntiLost"))
                {
                  L(paramToServiceMsg, paramFromServiceMsg, paramObject);
                  return;
                }
                if (paramToServiceMsg.extraData.getBoolean("isSetCalReactiveDays", false))
                {
                  D(paramToServiceMsg, paramFromServiceMsg, paramObject);
                  return;
                }
                if (paramToServiceMsg.extraData.getBoolean("isSetBabyQSwitch"))
                {
                  K(paramToServiceMsg, paramFromServiceMsg, paramObject);
                  return;
                }
                if (paramToServiceMsg.extraData.getBoolean("uint32_req_medalwall_flag", false))
                {
                  E(paramToServiceMsg, paramFromServiceMsg, paramObject);
                  return;
                }
                if (paramToServiceMsg.extraData.getBoolean("isSetNotifyOnLikeRankingList", false))
                {
                  f(paramToServiceMsg, paramFromServiceMsg, paramObject);
                  return;
                }
                if (paramToServiceMsg.extraData.getBoolean("isSetDisplayThirdQQSwitch", false))
                {
                  g(paramToServiceMsg, paramFromServiceMsg, paramObject);
                  return;
                }
                if (paramToServiceMsg.extraData.getBoolean("isSetPartakeLikeRankingList", false))
                {
                  e(paramToServiceMsg, paramFromServiceMsg, paramObject);
                  return;
                }
                if (paramToServiceMsg.extraData.getBoolean("isSetCommonSwitchFromDetailInfo", false))
                {
                  y(paramToServiceMsg, paramFromServiceMsg, paramObject);
                  return;
                }
                l(paramToServiceMsg, paramFromServiceMsg, paramObject);
                return;
              } while ("OidbSvc.0x5ea_2".equals(paramFromServiceMsg.getServiceCmd()));
              if ("OidbSvc.0x5eb_17".equals(paramFromServiceMsg.getServiceCmd()))
              {
                t(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                return;
              }
              if ("QQMusicVipRingSvr.getringlist".equals(paramFromServiceMsg.getServiceCmd()))
              {
                u(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
                return;
              }
            } while ("OidbSvc.0x4ff_58".equals(paramFromServiceMsg.getServiceCmd()));
            if ("OidbSvc.0x66b".equals(paramFromServiceMsg.getServiceCmd()))
            {
              d(paramToServiceMsg, paramFromServiceMsg, paramObject);
              return;
            }
            if ("PubAccountSvc.get_detail_info".equals(paramFromServiceMsg.getServiceCmd()))
            {
              c(paramToServiceMsg, paramFromServiceMsg, paramObject);
              return;
            }
            if ("SQQShopFolderSvc.GetAcctBindPuin".equals(paramFromServiceMsg.getServiceCmd()))
            {
              b(paramToServiceMsg, paramFromServiceMsg, paramObject);
              return;
            }
            if (!"OidbSvc.0x5eb_22".equals(paramFromServiceMsg.getServiceCmd())) {
              break;
            }
          } while (!paramToServiceMsg.extraData.getBoolean("uint32_req_medalwall_flag", false));
          G(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
          if ("OidbSvc.0x93b".equals(paramFromServiceMsg.getServiceCmd()))
          {
            F(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          if ("OidbSvc.0x7ba".equals(paramFromServiceMsg.getServiceCmd()))
          {
            e(paramToServiceMsg, paramFromServiceMsg, paramObject, (Bundle)localObject2);
            return;
          }
          if ("OidbSvc.0x5eb_42092".equals(paramFromServiceMsg.getServiceCmd()))
          {
            z(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          if ("OidbSvc.0x5eb_40350".equals(paramFromServiceMsg.getServiceCmd()))
          {
            u(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          if ("OidbSvc.0x922".equals(paramFromServiceMsg.getServiceCmd()))
          {
            w(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
        } while ("OidbSvc.0x923".equals(paramFromServiceMsg.getServiceCmd()));
        if ("OidbSvc.0xa28".equals(paramFromServiceMsg.getServiceCmd()))
        {
          v(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("OidbSvc.0xa6d".equals(paramFromServiceMsg.getServiceCmd()))
        {
          P(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if (!"OidbSvc.0x7a8".equals(paramFromServiceMsg.getServiceCmd())) {
          break;
        }
        localObject1 = paramToServiceMsg.extraData.getString("from", "");
        if (((String)localObject1).equalsIgnoreCase("getSelfNewObtainedMedalWall"))
        {
          Q(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
      } while (!((String)localObject1).equalsIgnoreCase("getFriendMedalNews"));
      i(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    } while (!"OidbSvc.0xac6".equals(paramFromServiceMsg.getServiceCmd()));
    R(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "func getShoppingIsBind begins, curUin:" + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
    qqshop.SQQSHPClientReq localSQQSHPClientReq = new qqshop.SQQSHPClientReq();
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.add(Long.valueOf(Long.parseLong(paramString)));
      localSQQSHPClientReq.cuinlist.set(localArrayList);
      paramString = a("SQQShopFolderSvc.GetAcctBindPuin");
      paramString.putWupBuffer(localSQQSHPClientReq.toByteArray());
      b(paramString);
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "func getShoppingIsBind ends");
      }
      return;
    }
    catch (NumberFormatException paramString)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.w("CardHandler", 2, "func getShoppingIsBind ends,errInfo:" + paramString.getMessage());
        }
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qzonecover.", 2, "getQzoneCover");
    }
    ToServiceMsg localToServiceMsg = a("SQQzoneSvc.getCover");
    localToServiceMsg.addAttribute("uin", paramString);
    localToServiceMsg.addAttribute("flag", Integer.valueOf(paramInt));
    a(localToServiceMsg);
  }
  
  public void a(String paramString, int paramInt, byte paramByte, ArrayList paramArrayList1, byte[] paramArrayOfByte1, ArrayList paramArrayList2, ArrayList paramArrayList3, byte[] paramArrayOfByte2)
  {
    paramString = a("MCardSvc.ReqSetCard");
    paramString.extraData.putInt("eSubCmd", paramInt);
    paramString.extraData.putByte("bIsSingle", paramByte);
    paramString.extraData.putByteArray("vBackground", paramArrayOfByte1);
    paramString.extraData.putByteArray("vReqSetTemplate", paramArrayOfByte2);
    try
    {
      paramArrayOfByte1 = new ByteArrayOutputStream();
      paramArrayOfByte2 = new ObjectOutputStream(paramArrayOfByte1);
      paramArrayOfByte2.writeObject(paramArrayList1);
      paramArrayOfByte2.flush();
      paramString.extraData.putByteArray("vTagsID", paramArrayOfByte1.toByteArray());
      paramArrayList1 = new ByteArrayOutputStream();
      paramArrayOfByte1 = new ObjectOutputStream(paramArrayList1);
      paramArrayOfByte1.writeObject(paramArrayList2);
      paramArrayOfByte1.flush();
      paramString.extraData.putByteArray("vDelTags", paramArrayList1.toByteArray());
      paramArrayList1 = new ByteArrayOutputStream();
      paramArrayOfByte1 = new ObjectOutputStream(paramArrayList1);
      paramArrayOfByte1.writeObject(paramArrayList3);
      paramArrayOfByte1.flush();
      paramString.extraData.putByteArray("vAddTags", paramArrayList1.toByteArray());
      a(paramString);
      return;
    }
    catch (IOException paramArrayList1)
    {
      for (;;)
      {
        paramArrayList1.printStackTrace();
      }
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    oidb_0x7ba.ReqBody localReqBody = new oidb_0x7ba.ReqBody();
    localReqBody.uint64_uin.set(Long.parseLong(paramString));
    localReqBody.uint32_start_index.set(paramInt1);
    localReqBody.uint32_want_num.set(paramInt2);
    b(a("OidbSvc.0x7ba", 1978, 0, localReqBody.toByteArray()));
  }
  
  public void a(String paramString, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("MedalWallMng", 2, "getFriendMedalNews " + paramString + " " + paramLong);
    }
    long l1;
    if (paramLong <= 0L) {
      l1 = 1L;
    }
    try
    {
      for (;;)
      {
        l2 = Long.parseLong(paramString);
        if (l2 != 0L) {
          break;
        }
        return;
        l1 = paramLong;
      }
    }
    catch (Exception localException)
    {
      long l2;
      for (;;)
      {
        localException.printStackTrace();
        l2 = 0L;
      }
      Object localObject = new cmd0x7a8.ReqBody();
      ((cmd0x7a8.ReqBody)localObject).uint64_req_uin.set(l2);
      ((cmd0x7a8.ReqBody)localObject).uint32_only_obtained.set(1);
      ((cmd0x7a8.ReqBody)localObject).uint32_sort_type.set(1);
      ((cmd0x7a8.ReqBody)localObject).uint32_start_timestamp.set((int)l1);
      localObject = a("OidbSvc.0x7a8", 1960, 5, ((cmd0x7a8.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("from", "getFriendMedalNews");
      ((ToServiceMsg)localObject).extraData.putString("uin", paramString);
      ((ToServiceMsg)localObject).extraData.putLong("ts", paramLong);
      b((ToServiceMsg)localObject);
    }
  }
  
  public void a(String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.SummaryCard", 2, "deleteLbsPortrait() uin = " + paramString);
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "MCardSvc.ReqDelFace");
    localToServiceMsg.extraData.putLong("selfuin", Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    localToServiceMsg.extraData.putByteArray("filekey", paramArrayOfByte);
    localToServiceMsg.extraData.putLong("timestamp", paramLong);
    localToServiceMsg.extraData.putString("touin", paramString);
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.sendToService(localToServiceMsg);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qzonephotowall", 2, "getQzonePhotoWall uin:" + paramString1);
    }
    ToServiceMsg localToServiceMsg = a("SQQzoneSvc.getPhotoWall");
    localToServiceMsg.addAttribute("uin", paramString1);
    localToServiceMsg.addAttribute("attachInfo", paramString2);
    a(localToServiceMsg);
  }
  
  public void a(String paramString1, String paramString2, byte paramByte, int paramInt)
  {
    paramString1 = new ToServiceMsg("mobileqq.service", paramString1, "MCardSvc.ReqHYMakeFriendsCard");
    paramString1.extraData.putString("friendUin", paramString2);
    paramString1.extraData.putByte("bReqType", paramByte);
    paramString1.extraData.putInt("uFaceTimeStamp", paramInt);
    a(paramString1);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, long paramLong1, byte paramByte1, long paramLong2, long paramLong3, byte[] paramArrayOfByte1, String paramString3, long paramLong4, int paramInt2, byte[] paramArrayOfByte2, byte paramByte2)
  {
    a(paramString1, paramString2, paramInt1, paramLong1, paramByte1, paramLong2, paramLong3, paramArrayOfByte1, paramString3, paramLong4, paramInt2, paramArrayOfByte2, 0L, false, paramByte2);
  }
  
  public void a(String paramString1, String paramString2, int paramInt, ArrayList paramArrayList)
  {
    try
    {
      long l1 = Long.parseLong(paramString1);
      long l2 = Long.parseLong(paramString2);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getSimpleSummayCard()").append(",selfUin = ").append(paramString1).append(",destUin = ").append(paramString2).append(",comeFromType = ").append(paramInt);
        QLog.i("Q.profilecard.SummaryCard", 2, localStringBuilder.toString());
      }
      paramString1 = new ToServiceMsg("mobileqq.service", String.valueOf(paramString1), "SummaryCard.ReqSummaryCard");
      paramString1.extraData.putLong("selfUin", l1);
      paramString1.extraData.putLong("targetUin", l2);
      paramString1.extraData.putInt("comeFromType", paramInt);
      paramString1.extraData.putBoolean("simpleinfo_pull", true);
      paramString1.extraData.putIntegerArrayList("req0x5ebFieldIdList", paramArrayList);
      a(paramString1);
      return;
    }
    catch (NumberFormatException paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.profilecard.SummaryCard", 2, "getSimpleSummayCard", paramString1);
    }
  }
  
  public void a(String paramString1, String paramString2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qzonephotowall", 2, "delQzonePhotoWall");
    }
    ToServiceMsg localToServiceMsg = a("SQQzoneSvc.delPhotoWall");
    localToServiceMsg.addAttribute("uin", paramString1);
    localToServiceMsg.addAttribute("photo_id", paramString2);
    localToServiceMsg.addAttribute("photo_time", Long.valueOf(paramLong));
    a(localToServiceMsg);
  }
  
  public void a(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", String.valueOf(paramString1), "VisitorSvc.ReqGetVoterList");
    localToServiceMsg.extraData.putLong("selfUin", Long.parseLong(paramString1));
    localToServiceMsg.extraData.putLong("targetUin", Long.parseLong(paramString2));
    localToServiceMsg.extraData.putLong("nextMid", paramLong);
    localToServiceMsg.extraData.putInt("pageSize", paramInt);
    a(localToServiceMsg);
  }
  
  public void a(String paramString1, String paramString2, Long paramLong)
  {
    ToServiceMsg localToServiceMsg = a("SummaryCard.LikeIt");
    localToServiceMsg.extraData.putLong("selfUin", Long.parseLong(paramString1));
    localToServiceMsg.extraData.putLong("destUin", Long.parseLong(paramString2));
    localToServiceMsg.extraData.putLong("labelId", paramLong.longValue());
    a(localToServiceMsg);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "isQidianExt");
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Short.valueOf((short)-25126));
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("isQidianExt", true);
      localBundle.putBoolean("isQidianSimple", paramBoolean);
      a(localArrayList, localBundle, paramString);
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.profilecard.", 2, "isQidianExt ex", paramString);
    }
  }
  
  public void a(ArrayList paramArrayList)
  {
    if (paramArrayList == null) {
      return;
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      Iterator localIterator = paramArrayList.iterator();
      if (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        this.jdField_a_of_type_JavaUtilArrayList.add(str);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qzonephotowall", 2, "uploadPhotoWall size:" + paramArrayList.size());
    }
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(new zba(this));
  }
  
  public void a(List paramList)
  {
    if (paramList != null)
    {
      ArrayList localArrayList = new ArrayList();
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        localArrayList.add(((ProfileLabelInfo)paramList.next()).labelId);
      }
      paramList = a("SummaryCard.SetLabel");
      paramList.extraData.putSerializable("labels", (Serializable)localArrayList);
      a(paramList);
    }
  }
  
  public void a(Oidb_0x66b.ReqBody paramReqBody)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewNearbyMyTab", 2, "getSimpleNearbyMyTabCard");
    }
    paramReqBody = a("OidbSvc.0x66b", 1643, 0, paramReqBody.toByteArray());
    paramReqBody.extraData.putBoolean("req_pb_protocol_flag", true);
    paramReqBody.extraData.putBoolean("simpleMytabCard", true);
    a(paramReqBody);
  }
  
  public void a(short paramShort)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "setAntilostState open=" + paramShort);
    }
    try
    {
      oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
      localOIDBSSOPkg.uint32_command.set(1279);
      localOIDBSSOPkg.uint32_service_type.set(9);
      Object localObject = ByteBuffer.allocate(13);
      ((ByteBuffer)localObject).putInt(Utils.a(Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))).put((byte)0).putShort((short)1).putShort((short)-25200).putShort((short)2).putShort(paramShort);
      localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
      localObject = a("OidbSvc.0x4ff_9");
      ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
      ((ToServiceMsg)localObject).setTimeout(30000L);
      ((ToServiceMsg)localObject).extraData.putShort("open", paramShort);
      ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
      ((ToServiceMsg)localObject).extraData.putBoolean("isGetAntiLost", true);
      b((ToServiceMsg)localObject);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.profilecard.", 2, "setAntilostState ex", localException);
    }
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
      ((ByteBuffer)localObject).putInt(Utils.a(Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))).put((byte)0).putShort((short)1).putShort(paramShort1).putShort((short)2).putShort(paramShort2);
      localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
      localObject = a("OidbSvc.0x4ff_9");
      ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
      ((ToServiceMsg)localObject).setTimeout(30000L);
      ((ToServiceMsg)localObject).extraData.putShort("switch_id", paramShort1);
      ((ToServiceMsg)localObject).extraData.putShort("switch_value", paramShort2);
      ((ToServiceMsg)localObject).extraData.putBoolean("isSetCommonSwitchFromDetailInfo", true);
      ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
      b((ToServiceMsg)localObject);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("CommonSwitchTag", 2, "setCommonSwitchFromDetailInfo ex", localException);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    int i = 1;
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1169);
    localOIDBSSOPkg.uint32_service_type.set(100);
    Object localObject = ByteBuffer.allocate(1);
    if (paramBoolean) {
      i = 0;
    }
    ((ByteBuffer)localObject).put((byte)i);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = a("OidbSvc.0x491_100");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    ((ToServiceMsg)localObject).extraData.putBoolean("key_searchable", paramBoolean);
    ((ToServiceMsg)localObject).setTimeout(10000L);
    b((ToServiceMsg)localObject);
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.Avatar", 2, "uploadAvatarResult|isSuc = " + paramBoolean);
    }
    String str = ProfileCardUtil.b();
    ProfileCardUtil.a(null);
    Object localObject2;
    Object localObject1;
    if (paramBoolean)
    {
      localObject2 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      localObject1 = (Setting)((EntityManager)localObject2).a(Setting.class, paramString);
      if (localObject1 != null) {
        break label366;
      }
      localObject1 = new Setting();
      ((Setting)localObject1).uin = paramString;
      ((Setting)localObject1).bHeadType = 1;
      ((Setting)localObject1).bUsrType = 1;
      ((Setting)localObject1).updateTimestamp = System.currentTimeMillis();
      ((Setting)localObject1).headImgTimestamp = (((Setting)localObject1).updateTimestamp / 1000L);
      ((EntityManager)localObject2).a((Entity)localObject1);
    }
    for (;;)
    {
      ((EntityManager)localObject2).a();
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a((Setting)localObject1);
      localObject1 = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      localObject2 = ((VasExtensionManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(234)).a;
      ExtensionInfo localExtensionInfo = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(paramString, true);
      localExtensionInfo.faceId = 0;
      localExtensionInfo.faceIdUpdateTime = NetConnInfoCenter.getServerTime();
      localExtensionInfo.setStatus(1000);
      ((FriendsManager)localObject1).a(localExtensionInfo);
      ((VasFaceManager)localObject2).a(localExtensionInfo);
      localObject1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(false, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), true);
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        FileUtils.d((String)localObject1);
      }
      localObject2 = ProfileCardUtil.a(paramString);
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        FileUtils.d((String)localObject2);
      }
      ProfileCardUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(1, paramString, 0);
      if (!TextUtils.isEmpty(str))
      {
        ImageUtil.a(null, str, (String)localObject1, 100, 100);
        FileUtils.d(str, (String)localObject2);
      }
      if (!TextUtils.isEmpty(str)) {
        FileUtils.d(str);
      }
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("uin", paramString);
      a(8, paramBoolean, localObject1);
      return;
      label366:
      ((Setting)localObject1).bHeadType = 1;
      ((Setting)localObject1).updateTimestamp = System.currentTimeMillis();
      ((Setting)localObject1).headImgTimestamp = (((Setting)localObject1).updateTimestamp / 1000L);
      ((EntityManager)localObject2).a((Entity)localObject1);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    ToServiceMsg localToServiceMsg = a("MCardSvc.ReqSetCardSwitch");
    localToServiceMsg.extraData.putBoolean("modify_switch_for_near_people", paramBoolean1);
    Bundle localBundle = localToServiceMsg.extraData;
    if (paramBoolean2) {}
    for (long l = 0L;; l = 1L)
    {
      localBundle.putLong("target_value", l);
      a(localToServiceMsg);
      return;
    }
  }
  
  public void a(short[] paramArrayOfShort)
  {
    int j = 0;
    if ((paramArrayOfShort == null) || (paramArrayOfShort.length == 0)) {}
    do
    {
      return;
      Object localObject;
      int k;
      int i;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder(200);
        ((StringBuilder)localObject).append("getCommonSwitchFromDetailInfo size: ").append(paramArrayOfShort.length);
        ((StringBuilder)localObject).append("[");
        k = paramArrayOfShort.length;
        i = 0;
        while (i < k)
        {
          ((StringBuilder)localObject).append(paramArrayOfShort[i]).append(",");
          i += 1;
        }
        ((StringBuilder)localObject).append("]");
        QLog.d("CommonSwitchTag", 2, ((StringBuilder)localObject).toString());
      }
      try
      {
        localObject = new ArrayList();
        k = paramArrayOfShort.length;
        i = j;
        while (i < k)
        {
          ((List)localObject).add(Short.valueOf(paramArrayOfShort[i]));
          i += 1;
        }
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("isGetCommonSwitchFromDetailInfo", true);
        localBundle.putShortArray("switch_id_array", paramArrayOfShort);
        a((List)localObject, localBundle);
        return;
      }
      catch (Exception paramArrayOfShort) {}
    } while (!QLog.isColorLevel());
    QLog.d("CommonSwitchTag", 2, "getCommonSwitchFromDetailInfo ex", paramArrayOfShort);
  }
  
  public boolean a()
  {
    Object localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    long l1 = ((SharedPreferences)localObject).getLong("sign_in_time_stamp", 0L);
    localObject = ((SharedPreferences)localObject).getString(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c() + "sign_in_info", "");
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
  
  protected boolean a(String paramString)
  {
    if (this.jdField_b_of_type_JavaUtilSet == null)
    {
      this.jdField_b_of_type_JavaUtilSet = new HashSet();
      this.jdField_b_of_type_JavaUtilSet.add("SummaryCard.ReqSummaryCard");
      this.jdField_b_of_type_JavaUtilSet.add("SummaryCard.ReqVoiceManage");
      this.jdField_b_of_type_JavaUtilSet.add("MCardSvc.ReqHYMakeFriendsCard");
      this.jdField_b_of_type_JavaUtilSet.add("MCardSvc.ReqSetCard");
      this.jdField_b_of_type_JavaUtilSet.add("SummaryCard.SetLabel");
      this.jdField_b_of_type_JavaUtilSet.add("SummaryCard.LikeIt");
      this.jdField_b_of_type_JavaUtilSet.add("MCardSvc.ReqGetCardSwitch");
      this.jdField_b_of_type_JavaUtilSet.add("MCardSvc.ReqSetCardSwitch");
      this.jdField_b_of_type_JavaUtilSet.add("VisitorSvc.ReqVote");
      this.jdField_b_of_type_JavaUtilSet.add("VisitorSvc.ReqFavorite");
      this.jdField_b_of_type_JavaUtilSet.add("VisitorSvc.ReqGetVoterList");
      this.jdField_b_of_type_JavaUtilSet.add("VisitorSvc.ReqGetFavoriteList");
      this.jdField_b_of_type_JavaUtilSet.add("MCardSvc.ReqFaceInfo");
      this.jdField_b_of_type_JavaUtilSet.add("MCardSvc.ReqAddFace");
      this.jdField_b_of_type_JavaUtilSet.add("MCardSvc.ReqUpdateIntro");
      this.jdField_b_of_type_JavaUtilSet.add("MCardSvc.ReqDelFace");
      this.jdField_b_of_type_JavaUtilSet.add("ProfileService.getGroupInfoReq");
      this.jdField_b_of_type_JavaUtilSet.add("ProfileService.GetSglUsrFullInfo");
      this.jdField_b_of_type_JavaUtilSet.add("ProfileService.SetUserInfoReq");
      this.jdField_b_of_type_JavaUtilSet.add("AccostSvc.ClientMsg");
      this.jdField_b_of_type_JavaUtilSet.add("AccostSvc.SvrMsg");
      this.jdField_b_of_type_JavaUtilSet.add("MobileQQ.SendPortraitDownloadVerifyCode");
      this.jdField_b_of_type_JavaUtilSet.add("MCardSvc.ReqPicSafetyCheck");
      this.jdField_b_of_type_JavaUtilSet.add("MCardSvc.ReqGetFace");
      this.jdField_b_of_type_JavaUtilSet.add("PttCenterSvr.ReqBody");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x490_100");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x491_100");
      this.jdField_b_of_type_JavaUtilSet.add("SQQzoneSvc.getCover");
      this.jdField_b_of_type_JavaUtilSet.add("SQQzoneSvc.getPhotoWall");
      this.jdField_b_of_type_JavaUtilSet.add("SQQzoneSvc.delPhotoWall");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x480_9");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x4ff_9");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x5ea_2");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x5ea_3");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x5ea_4");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x5eb_17");
      this.jdField_b_of_type_JavaUtilSet.add("QQMusicVipRingSvr.getringlist");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x4ff_58");
      this.jdField_b_of_type_JavaUtilSet.add("PubAccountSvc.get_detail_info");
      this.jdField_b_of_type_JavaUtilSet.add("SQQShopFolderSvc.GetAcctBindPuin");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0xa6d");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x66b");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x5eb_22");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x93b");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x7ba");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x5eb_42092");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x5eb_40350");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x922");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x923");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0xa28");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0xac6");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x7a8");
    }
    return !this.jdField_b_of_type_JavaUtilSet.contains(paramString);
  }
  
  public void b()
  {
    a(a("MCardSvc.ReqGetCardSwitch"));
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CardHandler", 2, "getSigninRedTouchShell");
    }
    if (c())
    {
      c(paramInt);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("DailySignIn", 2, "getSignRedTouchShell time kill");
    }
    a(84, true, null);
  }
  
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "func handleShoppingBindInfo begins, data:" + paramObject + ",res:" + paramFromServiceMsg);
    }
    if ((paramFromServiceMsg == null) || (paramObject == null)) {
      return;
    }
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {}
    for (;;)
    {
      if (i != 0) {
        break label94;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("CardHandler", 2, "func handleShoppingBindInfo, NOT success.");
      return;
      i = 0;
    }
    label94:
    paramToServiceMsg = new qqshop.SQQSHPClientRsp();
    for (;;)
    {
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        i = paramToServiceMsg.retcode.get();
        if (i != 0) {
          break label371;
        }
        paramToServiceMsg = paramToServiceMsg.bindlist.get();
        if ((paramToServiceMsg == null) || (paramToServiceMsg.size() <= 0)) {
          break label406;
        }
        l1 = ((qqshop.SQQSHPAccoutRelation)paramToServiceMsg.get(0)).puin.get();
        l2 = ((qqshop.SQQSHPAccoutRelation)paramToServiceMsg.get(0)).binduin.get();
        paramFromServiceMsg = ProfileShoppingPhotoInfo.getPhotoInfo(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, Long.toString(l2));
        paramToServiceMsg = paramFromServiceMsg;
        if (paramFromServiceMsg == null)
        {
          paramToServiceMsg = new ProfileShoppingPhotoInfo();
          paramToServiceMsg.seqNo = 0;
          paramToServiceMsg.uin = Long.toString(l2);
          paramToServiceMsg.setStatus(1000);
        }
        paramToServiceMsg.bindShoppingNo = Long.toString(l1);
        ProfileShoppingPhotoInfo.savePhotoInfo2DB(paramToServiceMsg, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
        a(67, true, new Object[] { Integer.valueOf(paramToServiceMsg.seqNo), Long.valueOf(l1), Long.valueOf(l2) });
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("CardHandler", 2, "func handleShoppingBindInfo ends, pUin:" + l1 + ",bindUin:" + l2);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("CardHandler", 2, "func handleShoppingBindInfo ends, errInfo:" + paramToServiceMsg.getMessage());
      return;
      label371:
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("CardHandler", 2, "func handleShoppingBindInfo ends, retCode:" + i);
      return;
      label406:
      long l2 = 0L;
      long l1 = 0L;
    }
  }
  
  public void b(String paramString)
  {
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.i = paramString;
    localTransferRequest.jdField_a_of_type_Boolean = true;
    localTransferRequest.jdField_c_of_type_JavaLangString = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin();
    localTransferRequest.jdField_a_of_type_Long = 0L;
    localTransferRequest.jdField_b_of_type_Int = 35;
    localTransferRequest.jdField_a_of_type_JavaLangString = "actProfileCoverPicUpload";
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController != null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.a(localTransferRequest);
    }
  }
  
  public void b(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, String.format(Locale.getDefault(), "getCampusInfo uin: %s flag: %d", new Object[] { paramString, Integer.valueOf(paramInt) }));
    }
    int i = paramInt;
    if (paramInt == 0) {
      i = 3;
    }
    try
    {
      long l = Long.parseLong(paramString);
      paramString = new oidb_0x93b.ReqBody();
      paramString.uint64_uin.set(l);
      if ((i & 0x1) == 1) {
        paramString.uint32_req_name.set(1);
      }
      if ((i & 0x2) == 2) {
        paramString.uint32_req_school_info.set(1);
      }
      if ((i & 0x8) == 8) {
        paramString.uint32_req_skey.set(1);
      }
      if ((i & 0x4) == 4) {
        paramString.uint32_req_flag.set(1);
      }
      paramString = a("OidbSvc.0x93b", 2363, 0, paramString.toByteArray());
      paramString.extraData.putInt("campus_info_flag", i);
      b(paramString);
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      paramString.printStackTrace();
      QLog.d("CardHandler", 2, String.format(Locale.getDefault(), "getCampusInfo exception: %s", new Object[] { paramString.toString() }));
    }
  }
  
  public void b(String paramString, int paramInt1, int paramInt2)
  {
    QLog.d("Q.profilecard.", 1, "modifyMusicPendantSettings " + paramInt1 + ":" + paramInt2);
    try
    {
      oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
      localOIDBSSOPkg.uint32_command.set(1279);
      localOIDBSSOPkg.uint32_service_type.set(58);
      ByteBuffer localByteBuffer = ByteBuffer.allocate(13);
      localByteBuffer.putInt(Utils.a(Long.parseLong(paramString))).put((byte)0).putShort((short)1).putShort((short)paramInt1).putShort((short)2).putShort((short)paramInt2);
      localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localByteBuffer.array()));
      paramString = a("OidbSvc.0x4ff_58");
      paramString.putWupBuffer(localOIDBSSOPkg.toByteArray());
      paramString.setTimeout(30000L);
      b(paramString);
      return;
    }
    catch (Exception paramString)
    {
      QLog.d("Q.profilecard.", 1, "modifyMusicPendantSettings ex", paramString);
    }
  }
  
  public void b(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, String.format("sendRequestUpdateMusicPendant selfUin=%s targetUin=%s", new Object[] { paramString1, paramString2 }));
    }
    Object localObject = new oidb_0x5eb.ReqBody();
    long l = 0L;
    if (!TextUtils.isEmpty(paramString2)) {}
    for (;;)
    {
      try
      {
        l = Long.parseLong(paramString2);
        ((oidb_0x5eb.ReqBody)localObject).rpt_uint64_uins.add(Long.valueOf(l));
        ((oidb_0x5eb.ReqBody)localObject).uint32_req_music_ring_visible.set(1);
        ((oidb_0x5eb.ReqBody)localObject).uint32_req_music_ring_autoplay.set(1);
        ((oidb_0x5eb.ReqBody)localObject).uint32_req_music_ring_redpoint.set(1);
        localObject = a("OidbSvc.0x5eb_17", 1515, 17, ((oidb_0x5eb.ReqBody)localObject).toByteArray());
        ((ToServiceMsg)localObject).extraData.putString("targetUin", paramString2);
        ((ToServiceMsg)localObject).extraData.putString("selfUin", paramString1);
        b((ToServiceMsg)localObject);
        return;
      }
      catch (Exception paramString1)
      {
        QLog.e("Q.profilecard.", 1, "sendRequestUpdateMusicPendant() error", paramString1);
        return;
      }
      QLog.w("Q.profilecard.", 1, "sendRequestUpdateMusicPendant() targetUin is empty!");
    }
  }
  
  public void b(String paramString1, String paramString2, long paramLong, int paramInt)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", String.valueOf(paramString1), "VisitorSvc.ReqGetFavoriteList");
    localToServiceMsg.extraData.putLong("selfUin", Long.parseLong(paramString1));
    localToServiceMsg.extraData.putLong("targetUin", Long.parseLong(paramString2));
    localToServiceMsg.extraData.putLong("nextMid", paramLong);
    localToServiceMsg.extraData.putInt("pageSize", paramInt);
    a(localToServiceMsg);
  }
  
  /* Error */
  protected void b(String paramString, List paramList)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +82 -> 83
    //   4: aload_2
    //   5: invokeinterface 477 1 0
    //   10: ifle +73 -> 83
    //   13: aload_0
    //   14: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   17: invokevirtual 1468	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/EntityManagerFactory;
    //   20: invokevirtual 1474	com/tencent/mobileqq/persistence/EntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   23: astore_1
    //   24: aload_1
    //   25: ifnull +58 -> 83
    //   28: aload_1
    //   29: invokevirtual 4679	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   32: invokevirtual 4682	com/tencent/mobileqq/persistence/EntityTransaction:a	()V
    //   35: aload_2
    //   36: invokeinterface 791 1 0
    //   41: astore_2
    //   42: aload_2
    //   43: invokeinterface 766 1 0
    //   48: ifeq +36 -> 84
    //   51: aload_1
    //   52: aload_2
    //   53: invokeinterface 770 1 0
    //   58: checkcast 1572	com/tencent/mobileqq/data/CardProfile
    //   61: invokevirtual 3141	com/tencent/mobileqq/persistence/EntityManager:b	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   64: goto -22 -> 42
    //   67: astore_2
    //   68: aload_2
    //   69: invokevirtual 634	java/lang/Exception:printStackTrace	()V
    //   72: aload_1
    //   73: invokevirtual 4679	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   76: invokevirtual 4697	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   79: aload_1
    //   80: invokevirtual 2827	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   83: return
    //   84: aload_1
    //   85: invokevirtual 4679	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   88: invokevirtual 4696	com/tencent/mobileqq/persistence/EntityTransaction:c	()V
    //   91: aload_1
    //   92: invokevirtual 4679	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   95: invokevirtual 4697	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   98: aload_1
    //   99: invokevirtual 2827	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   102: return
    //   103: astore_2
    //   104: aload_1
    //   105: invokevirtual 4679	com/tencent/mobileqq/persistence/EntityManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   108: invokevirtual 4697	com/tencent/mobileqq/persistence/EntityTransaction:b	()V
    //   111: aload_1
    //   112: invokevirtual 2827	com/tencent/mobileqq/persistence/EntityManager:a	()V
    //   115: aload_2
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	CardHandler
    //   0	117	1	paramString	String
    //   0	117	2	paramList	List
    // Exception table:
    //   from	to	target	type
    //   28	42	67	java/lang/Exception
    //   42	64	67	java/lang/Exception
    //   84	91	67	java/lang/Exception
    //   28	42	103	finally
    //   42	64	103	finally
    //   68	72	103	finally
    //   84	91	103	finally
  }
  
  public void b(ArrayList paramArrayList)
  {
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
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {}
    do
    {
      return;
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
    } while (((cmd0xac6.ReqBody)localObject).rpt_medals.isEmpty());
    Object localObject = a("OidbSvc.0xac6", 2758, 2, ((cmd0xac6.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putParcelableArrayList("medal_wall_list", paramArrayList);
    b((ToServiceMsg)localObject);
  }
  
  public void b(List paramList)
  {
    FileUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c() + "_todayVoters", paramList);
  }
  
  public void b(boolean paramBoolean)
  {
    short s = 1;
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "setPCActiveState OPEN=" + paramBoolean);
    }
    for (;;)
    {
      try
      {
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.uint32_command.set(1279);
        localOIDBSSOPkg.uint32_service_type.set(9);
        Object localObject = ByteBuffer.allocate(13);
        long l = Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (paramBoolean == true)
        {
          ((ByteBuffer)localObject).putInt(Utils.a(l)).put((byte)0).putShort((short)1).putShort((short)-25042).putShort((short)2).putShort(s);
          localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
          localObject = a("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
          ((ToServiceMsg)localObject).setTimeout(30000L);
          ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject).extraData.putBoolean("isGetLoginDays", false);
          ((ToServiceMsg)localObject).extraData.putBoolean("pcActiveState", true);
          ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
          b((ToServiceMsg)localObject);
          return;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.", 2, "setPCActiveState ex", localException);
      }
      s = 0;
    }
  }
  
  public void b(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "setCallTabState open=" + paramBoolean1);
    }
    for (;;)
    {
      try
      {
        Object localObject1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        int j = Integer.valueOf("" + ((String)localObject1).charAt(2)).intValue();
        localObject1 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1279);
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(9);
        Object localObject2 = ByteBuffer.allocate(19);
        long l = Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (paramBoolean1 == true)
        {
          s = 0;
          ByteBuffer localByteBuffer = ((ByteBuffer)localObject2).putInt(Utils.a(l)).put((byte)0).putShort((short)2).putShort((short)-25217).putShort((short)2).putShort(s).putShort((short)-23476).putShort((short)2);
          if (j >= 2) {
            continue;
          }
          localByteBuffer.putShort((short)i);
          ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject2).array()));
          localObject2 = a("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
          ((ToServiceMsg)localObject2).setTimeout(30000L);
          ((ToServiceMsg)localObject2).extraData.putBoolean("switch", paramBoolean1);
          ((ToServiceMsg)localObject2).extraData.putBoolean("calltabstate", true);
          ((ToServiceMsg)localObject2).extraData.putBoolean("reqFromCardHandler", true);
          b((ToServiceMsg)localObject2);
          return;
        }
      }
      catch (Exception localException)
      {
        short s;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.", 2, "setCallTabState ex", localException);
      }
      s = 1;
      continue;
      i = 1;
    }
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("task_entry_config" + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).getBoolean("open", false);
  }
  
  public void c()
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1168);
    localOIDBSSOPkg.uint32_service_type.set(100);
    Object localObject = ByteBuffer.allocate(4);
    ((ByteBuffer)localObject).putInt((int)Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = a("OidbSvc.0x490_100");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    b((ToServiceMsg)localObject);
  }
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DailySignIn", 2, "getSigninRedTouch svrType=" + paramInt);
    }
    cmd0x922.ReqBody localReqBody = new cmd0x922.ReqBody();
    SharedPreferences localSharedPreferences = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    localReqBody.uint64_timestamp.set(localSharedPreferences.getLong("sign_in_time_stamp", 0L));
    b(a("OidbSvc.0x922", 2338, paramInt, localReqBody.toByteArray()));
  }
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "func handleShoppingCardInfo begins, data:" + paramObject + ",res:" + paramFromServiceMsg);
    }
    if ((paramFromServiceMsg == null) || (paramObject == null)) {}
    label94:
    String str2;
    do
    {
      for (;;)
      {
        return;
        if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {}
        for (i = 1;; i = 0)
        {
          if (i != 0) {
            break label94;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("CardHandler", 2, "func handleShoppingCardInfo, NOT success.");
          return;
        }
        paramFromServiceMsg = new mobileqq_mp.GetPublicAccountDetailInfoResponse();
        try
        {
          paramFromServiceMsg.mergeFrom((byte[])paramObject);
          i = ((mobileqq_mp.RetInfo)paramFromServiceMsg.ret_info.get()).ret_code.get();
          if ((i != 0) || (!paramFromServiceMsg.name.has()) || (!paramFromServiceMsg.unified_account_descrpition.has())) {
            break label541;
          }
          paramObject = paramFromServiceMsg.name.get();
          str2 = paramFromServiceMsg.unified_account_descrpition.get();
          if ((!TextUtils.isEmpty(paramObject)) && (!TextUtils.isEmpty(str2))) {
            break label260;
          }
          if (QLog.isColorLevel())
          {
            QLog.d("CardHandler", 2, "func handleShoppingCardInfo ends, data is nullll.");
            return;
          }
        }
        catch (InvalidProtocolBufferMicroException paramToServiceMsg) {}
      }
    } while (!QLog.isColorLevel());
    QLog.d("CardHandler", 2, "func handleShoppingCardInfo ends, errInfo:" + paramToServiceMsg.getMessage() + ",response.unified_account_descrpition.has():" + paramFromServiceMsg.unified_account_descrpition.has());
    return;
    label260:
    int i = paramFromServiceMsg.certified_grade.get();
    int j = paramFromServiceMsg.account_flag.get();
    int k = paramFromServiceMsg.follow_type.get();
    List localList = ProfileShoppingPhotoInfo.parseShoppingPhotoJson(str2);
    String str1 = (String)paramToServiceMsg.getAttribute("uin");
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "func handleShoppingCardInfo, ready to notify UI. shopName:" + paramObject + ",certifiedGrade:" + i + ",uin:" + str1 + ",accountFlag:" + j + "followType:" + k + ",picJson:" + str2 + ",picList.size:" + localList.size());
    }
    a(66, true, new Object[] { paramObject, localList, Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(i) });
    paramToServiceMsg = ProfileShoppingPhotoInfo.getPhotoInfo(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, str1);
    if (paramToServiceMsg == null)
    {
      paramToServiceMsg = new ProfileShoppingPhotoInfo();
      paramToServiceMsg.uin = str1;
      paramToServiceMsg.setStatus(1000);
    }
    for (;;)
    {
      paramToServiceMsg.certifiedGrade = i;
      paramToServiceMsg.accountFlag = j;
      paramToServiceMsg.followType = k;
      paramToServiceMsg.seqNo = paramFromServiceMsg.seqno.get();
      paramToServiceMsg.shopName = paramObject;
      paramToServiceMsg.picByteData = ProfileShoppingPhotoInfo.converPhoto2RawData(localList);
      ProfileShoppingPhotoInfo.savePhotoInfo2DB(paramToServiceMsg, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
      label541:
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("CardHandler", 2, "func handleShoppingCardInfo ends, errCode:" + i + ",no data is obtained.");
      return;
    }
  }
  
  public void c(String arg1)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qzonephotowall", 2, "retry upload size:" + this.jdField_a_of_type_JavaUtilArrayList.size() + " path:" + this.jdField_b_of_type_JavaLangString);
    }
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(0, this.jdField_b_of_type_JavaLangString);
      }
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(new zbb(this));
      return;
    }
  }
  
  public void c(String paramString1, String paramString2)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", String.valueOf(paramString1), "QQMusicVipRingSvr.getringlist");
    localToServiceMsg.extraData.putString("targetUin", paramString2);
    localToServiceMsg.extraData.putString("selfUin", paramString1);
    paramString1 = "pn=0" + "&idx=0";
    paramString1 = paramString1 + "&len=1000";
    localToServiceMsg.putWupBuffer((paramString1 + "&uin=" + paramString2).getBytes());
    b(localToServiceMsg);
  }
  
  public void c(List paramList)
  {
    Object localObject = FileUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c() + "_todayVoters");
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
    short s = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "setHelloLiveMessageState OPEN=" + paramBoolean);
    }
    for (;;)
    {
      try
      {
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.uint32_command.set(1279);
        localOIDBSSOPkg.uint32_service_type.set(9);
        Object localObject = ByteBuffer.allocate(13);
        long l = Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (paramBoolean == true)
        {
          ((ByteBuffer)localObject).putInt(Utils.a(l)).put((byte)0).putShort((short)1).putShort((short)-25181).putShort((short)2).putShort(s);
          localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
          localObject = a("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
          ((ToServiceMsg)localObject).setTimeout(30000L);
          ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject).extraData.putBoolean("helloLiveMessage", true);
          ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
          b((ToServiceMsg)localObject);
          return;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.", 2, "setHelloLiveMessageState ex", localException);
      }
      s = 1;
    }
  }
  
  public void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new Oidb_0x66b.RspBody();
    int i = a(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.d("NewNearbyMyTab", 2, "handleGetSimpleNearbyMyTab, result=" + i);
    }
    if (i == 0)
    {
      if (paramToServiceMsg.stPansocialInfo.has())
      {
        i = ((Oidb_0x66b.RspPansocialInfo)paramToServiceMsg.stPansocialInfo.get()).uint32_charmlevel.get();
        ((HotChatManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(59)).a(i);
      }
      return;
    }
    a(65, false, null);
  }
  
  public void d(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
    oidb_0xa28.ReqBody localReqBody = new oidb_0xa28.ReqBody();
    localReqBody.uint64_request_uin.set(Long.valueOf(paramString).longValue());
    localReqBody.uint32_sourceID.set(0);
    localReqBody.uint32_sourceSubID.set(0);
    b(a("OidbSvc.0xa28", 2600, 0, localReqBody.toByteArray()));
  }
  
  public void d(boolean paramBoolean)
  {
    short s = 0;
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "setPartakeLikeRankingList OPEN=" + paramBoolean);
    }
    for (;;)
    {
      try
      {
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.uint32_command.set(1279);
        localOIDBSSOPkg.uint32_service_type.set(this.jdField_a_of_type_Short);
        Object localObject = ByteBuffer.allocate(13);
        long l = Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (paramBoolean)
        {
          ((ByteBuffer)localObject).putInt(Utils.a(l)).put((byte)0).putShort((short)1).putShort((short)-25186).putShort((short)2).putShort(s);
          localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
          localObject = a("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
          ((ToServiceMsg)localObject).setTimeout(30000L);
          ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject).extraData.putBoolean("isSetPartakeLikeRankingList", true);
          ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
          b((ToServiceMsg)localObject);
          return;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.", 2, "setPartakeLikeRankingList ex", localException);
      }
      s = 1;
    }
  }
  
  public void e()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Short.valueOf((short)20031));
    localArrayList.add(Short.valueOf((short)20037));
    localArrayList.add(Short.valueOf((short)20009));
    localArrayList.add(Short.valueOf((short)20032));
    localArrayList.add(Short.valueOf((short)20041));
    localArrayList.add(Short.valueOf((short)-25217));
    localArrayList.add(Short.valueOf((short)-23754));
    localArrayList.add(Short.valueOf((short)-24980));
    localArrayList.add(Short.valueOf((short)-23723));
    localArrayList.add(Short.valueOf((short)27055));
    localArrayList.add(Short.valueOf((short)-23776));
    localArrayList.add(Short.valueOf((short)-23488));
    localArrayList.add(Short.valueOf((short)27034));
    localArrayList.add(Short.valueOf((short)-23753));
    localArrayList.add(Short.valueOf((short)-25200));
    localArrayList.add(Short.valueOf((short)-23533));
    localArrayList.add(Short.valueOf((short)-23537));
    localArrayList.add(Short.valueOf((short)-22556));
    localArrayList.add(Short.valueOf((short)27059));
    localArrayList.add(Short.valueOf((short)-25019));
    localArrayList.add(Short.valueOf((short)27206));
    localArrayList.add(Short.valueOf((short)27210));
    localArrayList.add(Short.valueOf((short)-23543));
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getInt("nearby_people_profile_ok_new", -1) != 1) {
      localArrayList.add(Short.valueOf((short)-25040));
    }
    if (((Integer)NearbySPUtil.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), "nearby_people_avatar_upload_ok", Integer.valueOf(-1))).intValue() != 1) {
      localArrayList.add(Short.valueOf((short)-23549));
    }
    localArrayList.add(Short.valueOf((short)-23538));
    localArrayList.add(Short.valueOf((short)-25042));
    localArrayList.add(Short.valueOf((short)-25181));
    localArrayList.add(Short.valueOf((short)-23502));
    localArrayList.add(Short.valueOf((short)-23461));
    localArrayList.add(Short.valueOf((short)-25188));
    localArrayList.add(Short.valueOf((short)-25002));
    localArrayList.add(Short.valueOf((short)-23456));
    localArrayList.add(Short.valueOf((short)-23366));
    localArrayList.add(Short.valueOf((short)-23365));
    localArrayList.add(Short.valueOf((short)-23364));
    try
    {
      localObject = new CardConfigManager(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface).a();
      if ((localObject != null) && (((CardConfigManager.CardConfigs)localObject).jdField_a_of_type_Boolean)) {
        localArrayList.add(Short.valueOf((short)-23447));
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        Object localObject;
        localThrowable.printStackTrace();
      }
    }
    localObject = (ClassicHeadActivityManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(198);
    if ((localObject != null) && (((ClassicHeadActivityManager)localObject).a()))
    {
      localArrayList.add(Short.valueOf((short)-23437));
      localArrayList.add(Short.valueOf((short)20015));
    }
    localArrayList.add(Short.valueOf((short)27245));
    localArrayList.add(Short.valueOf((short)-25084));
    a(localArrayList, null);
  }
  
  /* Error */
  public void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 10
    //   3: iconst_0
    //   4: istore 9
    //   6: iconst_0
    //   7: istore 11
    //   9: aload_2
    //   10: invokevirtual 88	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   13: ifeq +417 -> 430
    //   16: aload_3
    //   17: ifnull +413 -> 430
    //   20: iconst_1
    //   21: istore 5
    //   23: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +31 -> 57
    //   29: ldc_w 682
    //   32: iconst_2
    //   33: new 18	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   40: ldc_w 5755
    //   43: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: iload 5
    //   48: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   51: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: aload_0
    //   58: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   61: invokevirtual 117	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   64: pop
    //   65: iload 5
    //   67: istore 8
    //   69: iload 5
    //   71: ifeq +530 -> 601
    //   74: iload 5
    //   76: istore 6
    //   78: iload 5
    //   80: istore 7
    //   82: new 122	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   85: dup
    //   86: invokespecial 123	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   89: aload_3
    //   90: checkcast 125	[B
    //   93: checkcast 125	[B
    //   96: invokevirtual 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   99: checkcast 122	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   102: astore_2
    //   103: aload_2
    //   104: ifnull +332 -> 436
    //   107: iload 5
    //   109: istore 6
    //   111: iload 5
    //   113: istore 7
    //   115: aload_2
    //   116: getfield 133	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   119: invokevirtual 138	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   122: ifne +314 -> 436
    //   125: iconst_1
    //   126: istore 5
    //   128: iload 5
    //   130: istore 6
    //   132: iload 5
    //   134: istore 7
    //   136: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   139: ifeq +54 -> 193
    //   142: iload 5
    //   144: istore 6
    //   146: iload 5
    //   148: istore 7
    //   150: ldc 95
    //   152: iconst_2
    //   153: new 18	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   160: ldc_w 5757
    //   163: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: iload 5
    //   168: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   171: ldc_w 5759
    //   174: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: aload_2
    //   178: getfield 133	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   181: invokevirtual 138	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   184: invokevirtual 572	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   187: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   193: iload 5
    //   195: istore 8
    //   197: iload 5
    //   199: ifeq +402 -> 601
    //   202: iload 5
    //   204: istore 6
    //   206: iload 5
    //   208: istore 7
    //   210: iload 5
    //   212: istore 8
    //   214: aload_2
    //   215: getfield 144	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   218: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   221: ifeq +380 -> 601
    //   224: iload 5
    //   226: istore 6
    //   228: iload 5
    //   230: istore 7
    //   232: iload 5
    //   234: istore 8
    //   236: aload_2
    //   237: getfield 144	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   240: invokevirtual 152	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   243: ifnull +358 -> 601
    //   246: iload 5
    //   248: istore 6
    //   250: iload 5
    //   252: istore 7
    //   254: aload_2
    //   255: getfield 144	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   258: invokevirtual 152	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   261: invokevirtual 158	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   264: invokestatic 164	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   267: invokevirtual 167	java/nio/ByteBuffer:getInt	()I
    //   270: istore 4
    //   272: iload 4
    //   274: i2l
    //   275: lstore 12
    //   277: iload 4
    //   279: ifge +16 -> 295
    //   282: iload 4
    //   284: ldc_w 554
    //   287: iand
    //   288: i2l
    //   289: ldc2_w 555
    //   292: lor
    //   293: lstore 12
    //   295: iload 5
    //   297: istore 6
    //   299: iload 5
    //   301: istore 7
    //   303: aload_0
    //   304: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   307: invokevirtual 117	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   310: lload 12
    //   312: invokestatic 272	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   315: invokevirtual 275	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   318: ifeq +124 -> 442
    //   321: iload 5
    //   323: istore 6
    //   325: iload 5
    //   327: istore 7
    //   329: aload_1
    //   330: getfield 281	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   333: ldc_w 283
    //   336: invokevirtual 289	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   339: istore 5
    //   341: iload 5
    //   343: istore 6
    //   345: iload 10
    //   347: istore 5
    //   349: iload 5
    //   351: istore 7
    //   353: iload 6
    //   355: istore 8
    //   357: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   360: ifeq +56 -> 416
    //   363: ldc 95
    //   365: iconst_2
    //   366: new 18	java/lang/StringBuilder
    //   369: dup
    //   370: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   373: ldc_w 5757
    //   376: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: iload 5
    //   381: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   384: ldc 184
    //   386: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: aload_1
    //   390: getfield 281	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   393: ldc_w 283
    //   396: invokevirtual 289	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   399: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   402: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   408: iload 6
    //   410: istore 8
    //   412: iload 5
    //   414: istore 7
    //   416: aload_0
    //   417: bipush 82
    //   419: iload 7
    //   421: iload 8
    //   423: invokestatic 195	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   426: invokevirtual 198	com/tencent/mobileqq/app/CardHandler:a	(IZLjava/lang/Object;)V
    //   429: return
    //   430: iconst_0
    //   431: istore 5
    //   433: goto -410 -> 23
    //   436: iconst_0
    //   437: istore 5
    //   439: goto -311 -> 128
    //   442: iconst_0
    //   443: istore 5
    //   445: iload 11
    //   447: istore 6
    //   449: goto -100 -> 349
    //   452: astore_2
    //   453: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   456: ifeq +13 -> 469
    //   459: ldc 95
    //   461: iconst_2
    //   462: ldc_w 5761
    //   465: aload_2
    //   466: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   469: iload 6
    //   471: istore 7
    //   473: iload 9
    //   475: istore 8
    //   477: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   480: ifeq -64 -> 416
    //   483: ldc 95
    //   485: iconst_2
    //   486: new 18	java/lang/StringBuilder
    //   489: dup
    //   490: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   493: ldc_w 5757
    //   496: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: iload 6
    //   501: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   504: ldc 184
    //   506: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: aload_1
    //   510: getfield 281	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   513: ldc_w 283
    //   516: invokevirtual 289	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   519: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   522: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   525: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   528: iload 6
    //   530: istore 7
    //   532: iload 9
    //   534: istore 8
    //   536: goto -120 -> 416
    //   539: astore_2
    //   540: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   543: ifeq +48 -> 591
    //   546: ldc 95
    //   548: iconst_2
    //   549: new 18	java/lang/StringBuilder
    //   552: dup
    //   553: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   556: ldc_w 5757
    //   559: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: iload 7
    //   564: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   567: ldc 184
    //   569: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: aload_1
    //   573: getfield 281	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   576: ldc_w 283
    //   579: invokevirtual 289	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   582: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   585: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   588: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   591: aload_2
    //   592: athrow
    //   593: astore_2
    //   594: iload 6
    //   596: istore 7
    //   598: goto -58 -> 540
    //   601: iload 8
    //   603: istore 5
    //   605: iload 11
    //   607: istore 6
    //   609: goto -260 -> 349
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	612	0	this	CardHandler
    //   0	612	1	paramToServiceMsg	ToServiceMsg
    //   0	612	2	paramFromServiceMsg	FromServiceMsg
    //   0	612	3	paramObject	Object
    //   270	18	4	i	int
    //   21	583	5	bool1	boolean
    //   76	532	6	bool2	boolean
    //   80	517	7	bool3	boolean
    //   67	535	8	bool4	boolean
    //   4	529	9	bool5	boolean
    //   1	345	10	bool6	boolean
    //   7	599	11	bool7	boolean
    //   275	36	12	l	long
    // Exception table:
    //   from	to	target	type
    //   82	103	452	java/lang/Exception
    //   115	125	452	java/lang/Exception
    //   136	142	452	java/lang/Exception
    //   150	193	452	java/lang/Exception
    //   214	224	452	java/lang/Exception
    //   236	246	452	java/lang/Exception
    //   254	272	452	java/lang/Exception
    //   303	321	452	java/lang/Exception
    //   329	341	452	java/lang/Exception
    //   82	103	539	finally
    //   115	125	539	finally
    //   136	142	539	finally
    //   150	193	539	finally
    //   214	224	539	finally
    //   236	246	539	finally
    //   254	272	539	finally
    //   303	321	539	finally
    //   329	341	539	finally
    //   453	469	593	finally
  }
  
  public void e(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "isQidianMaster");
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Short.valueOf((short)-25176));
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("isQidianMaster", true);
      a(localArrayList, localBundle, paramString, 160);
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.profilecard.", 2, "isQidianMaster ex", paramString);
    }
  }
  
  public void e(boolean paramBoolean)
  {
    short s = 0;
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "setNotifyOnLikeRankingList OPEN=" + paramBoolean);
    }
    for (;;)
    {
      try
      {
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.uint32_command.set(1279);
        localOIDBSSOPkg.uint32_service_type.set(this.jdField_a_of_type_Short);
        Object localObject = ByteBuffer.allocate(13);
        long l = Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (paramBoolean)
        {
          ((ByteBuffer)localObject).putInt(Utils.a(l)).put((byte)0).putShort((short)1).putShort((short)-23444).putShort((short)2).putShort(s);
          localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
          localObject = a("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
          ((ToServiceMsg)localObject).setTimeout(30000L);
          ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject).extraData.putBoolean("isSetNotifyOnLikeRankingList", true);
          ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
          b((ToServiceMsg)localObject);
          return;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.", 2, "setNotifyOnLikeRankingList ex", localException);
      }
      s = 1;
    }
  }
  
  public void f()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Short.valueOf((short)-24980));
    localArrayList.add(Short.valueOf((short)-23437));
    localArrayList.add(Short.valueOf((short)20015));
    a(localArrayList, null);
  }
  
  /* Error */
  public void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 10
    //   3: iconst_0
    //   4: istore 9
    //   6: iconst_0
    //   7: istore 11
    //   9: aload_2
    //   10: invokevirtual 88	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   13: ifeq +401 -> 414
    //   16: aload_3
    //   17: ifnull +397 -> 414
    //   20: iconst_1
    //   21: istore 5
    //   23: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +31 -> 57
    //   29: ldc_w 682
    //   32: iconst_2
    //   33: new 18	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   40: ldc_w 5769
    //   43: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: iload 5
    //   48: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   51: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: aload_0
    //   58: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   61: invokevirtual 117	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   64: pop
    //   65: iload 5
    //   67: istore 8
    //   69: iload 5
    //   71: ifeq +514 -> 585
    //   74: iload 5
    //   76: istore 6
    //   78: iload 5
    //   80: istore 7
    //   82: new 122	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   85: dup
    //   86: invokespecial 123	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   89: aload_3
    //   90: checkcast 125	[B
    //   93: checkcast 125	[B
    //   96: invokevirtual 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   99: checkcast 122	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   102: astore_2
    //   103: aload_2
    //   104: ifnull +316 -> 420
    //   107: iload 5
    //   109: istore 6
    //   111: iload 5
    //   113: istore 7
    //   115: aload_2
    //   116: getfield 133	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   119: invokevirtual 138	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   122: ifne +298 -> 420
    //   125: iconst_1
    //   126: istore 5
    //   128: iload 5
    //   130: istore 6
    //   132: iload 5
    //   134: istore 7
    //   136: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   139: ifeq +38 -> 177
    //   142: iload 5
    //   144: istore 6
    //   146: iload 5
    //   148: istore 7
    //   150: ldc 95
    //   152: iconst_2
    //   153: new 18	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   160: ldc_w 5771
    //   163: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: iload 5
    //   168: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   171: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   177: iload 5
    //   179: istore 8
    //   181: iload 5
    //   183: ifeq +402 -> 585
    //   186: iload 5
    //   188: istore 6
    //   190: iload 5
    //   192: istore 7
    //   194: iload 5
    //   196: istore 8
    //   198: aload_2
    //   199: getfield 144	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   202: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   205: ifeq +380 -> 585
    //   208: iload 5
    //   210: istore 6
    //   212: iload 5
    //   214: istore 7
    //   216: iload 5
    //   218: istore 8
    //   220: aload_2
    //   221: getfield 144	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   224: invokevirtual 152	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   227: ifnull +358 -> 585
    //   230: iload 5
    //   232: istore 6
    //   234: iload 5
    //   236: istore 7
    //   238: aload_2
    //   239: getfield 144	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   242: invokevirtual 152	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   245: invokevirtual 158	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   248: invokestatic 164	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   251: invokevirtual 167	java/nio/ByteBuffer:getInt	()I
    //   254: istore 4
    //   256: iload 4
    //   258: i2l
    //   259: lstore 12
    //   261: iload 4
    //   263: ifge +16 -> 279
    //   266: iload 4
    //   268: ldc_w 554
    //   271: iand
    //   272: i2l
    //   273: ldc2_w 555
    //   276: lor
    //   277: lstore 12
    //   279: iload 5
    //   281: istore 6
    //   283: iload 5
    //   285: istore 7
    //   287: aload_0
    //   288: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   291: invokevirtual 117	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   294: lload 12
    //   296: invokestatic 272	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   299: invokevirtual 275	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   302: ifeq +124 -> 426
    //   305: iload 5
    //   307: istore 6
    //   309: iload 5
    //   311: istore 7
    //   313: aload_1
    //   314: getfield 281	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   317: ldc_w 283
    //   320: invokevirtual 289	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   323: istore 5
    //   325: iload 5
    //   327: istore 6
    //   329: iload 10
    //   331: istore 5
    //   333: iload 5
    //   335: istore 7
    //   337: iload 6
    //   339: istore 8
    //   341: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   344: ifeq +56 -> 400
    //   347: ldc 95
    //   349: iconst_2
    //   350: new 18	java/lang/StringBuilder
    //   353: dup
    //   354: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   357: ldc_w 5771
    //   360: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: iload 5
    //   365: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   368: ldc 184
    //   370: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: aload_1
    //   374: getfield 281	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   377: ldc_w 283
    //   380: invokevirtual 289	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   383: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   386: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   389: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   392: iload 6
    //   394: istore 8
    //   396: iload 5
    //   398: istore 7
    //   400: aload_0
    //   401: bipush 80
    //   403: iload 7
    //   405: iload 8
    //   407: invokestatic 195	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   410: invokevirtual 198	com/tencent/mobileqq/app/CardHandler:a	(IZLjava/lang/Object;)V
    //   413: return
    //   414: iconst_0
    //   415: istore 5
    //   417: goto -394 -> 23
    //   420: iconst_0
    //   421: istore 5
    //   423: goto -295 -> 128
    //   426: iconst_0
    //   427: istore 5
    //   429: iload 11
    //   431: istore 6
    //   433: goto -100 -> 333
    //   436: astore_2
    //   437: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   440: ifeq +13 -> 453
    //   443: ldc 95
    //   445: iconst_2
    //   446: ldc_w 5773
    //   449: aload_2
    //   450: invokestatic 213	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   453: iload 6
    //   455: istore 7
    //   457: iload 9
    //   459: istore 8
    //   461: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   464: ifeq -64 -> 400
    //   467: ldc 95
    //   469: iconst_2
    //   470: new 18	java/lang/StringBuilder
    //   473: dup
    //   474: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   477: ldc_w 5771
    //   480: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   483: iload 6
    //   485: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   488: ldc 184
    //   490: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: aload_1
    //   494: getfield 281	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   497: ldc_w 283
    //   500: invokevirtual 289	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   503: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   506: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   509: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   512: iload 6
    //   514: istore 7
    //   516: iload 9
    //   518: istore 8
    //   520: goto -120 -> 400
    //   523: astore_2
    //   524: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   527: ifeq +48 -> 575
    //   530: ldc 95
    //   532: iconst_2
    //   533: new 18	java/lang/StringBuilder
    //   536: dup
    //   537: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   540: ldc_w 5771
    //   543: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: iload 7
    //   548: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   551: ldc 184
    //   553: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: aload_1
    //   557: getfield 281	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   560: ldc_w 283
    //   563: invokevirtual 289	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   566: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   569: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   572: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   575: aload_2
    //   576: athrow
    //   577: astore_2
    //   578: iload 6
    //   580: istore 7
    //   582: goto -58 -> 524
    //   585: iload 8
    //   587: istore 5
    //   589: iload 11
    //   591: istore 6
    //   593: goto -260 -> 333
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	596	0	this	CardHandler
    //   0	596	1	paramToServiceMsg	ToServiceMsg
    //   0	596	2	paramFromServiceMsg	FromServiceMsg
    //   0	596	3	paramObject	Object
    //   254	18	4	i	int
    //   21	567	5	bool1	boolean
    //   76	516	6	bool2	boolean
    //   80	501	7	bool3	boolean
    //   67	519	8	bool4	boolean
    //   4	513	9	bool5	boolean
    //   1	329	10	bool6	boolean
    //   7	583	11	bool7	boolean
    //   259	36	12	l	long
    // Exception table:
    //   from	to	target	type
    //   82	103	436	java/lang/Exception
    //   115	125	436	java/lang/Exception
    //   136	142	436	java/lang/Exception
    //   150	177	436	java/lang/Exception
    //   198	208	436	java/lang/Exception
    //   220	230	436	java/lang/Exception
    //   238	256	436	java/lang/Exception
    //   287	305	436	java/lang/Exception
    //   313	325	436	java/lang/Exception
    //   82	103	523	finally
    //   115	125	523	finally
    //   136	142	523	finally
    //   150	177	523	finally
    //   198	208	523	finally
    //   220	230	523	finally
    //   238	256	523	finally
    //   287	305	523	finally
    //   313	325	523	finally
    //   437	453	577	finally
  }
  
  public void f(boolean paramBoolean)
  {
    short s = 1;
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "setLoginDaysSwitch OPEN=" + paramBoolean);
    }
    for (;;)
    {
      try
      {
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.uint32_command.set(1279);
        localOIDBSSOPkg.uint32_service_type.set(this.jdField_a_of_type_Short);
        Object localObject = ByteBuffer.allocate(13);
        long l = Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (paramBoolean == true)
        {
          ((ByteBuffer)localObject).putInt(Utils.a(l)).put((byte)0).putShort((short)1).putShort(this.jdField_b_of_type_Short).putShort((short)2).putShort(s);
          localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
          localObject = a("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
          ((ToServiceMsg)localObject).setTimeout(30000L);
          ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject).extraData.putBoolean("isSetLoginDays", true);
          ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
          b((ToServiceMsg)localObject);
          return;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.", 2, "getLoginDaysSwitch ex", localException);
      }
      s = 0;
    }
  }
  
  public void g()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Short.valueOf((short)-25084));
    a(localArrayList, null);
  }
  
  public void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool5 = true;
    boolean bool1;
    boolean bool4;
    boolean bool2;
    boolean bool3;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "handleSetDisplayThirdQQSwitch success=" + bool1);
      }
      bool4 = bool1;
      if (!bool1) {
        break label543;
      }
      bool2 = bool1;
      bool3 = bool1;
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg == null) {
          continue;
        }
        bool2 = bool1;
        bool3 = bool1;
        if (paramFromServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool1 = true;
        bool2 = bool1;
        bool3 = bool1;
        if (QLog.isColorLevel())
        {
          bool2 = bool1;
          bool3 = bool1;
          QLog.d("Q.profilecard.", 2, "handleSetDisplayThirdQQSwitch result=" + bool1 + ",pkg.uint32_result.get() = " + paramFromServiceMsg.uint32_result.get());
        }
        bool4 = bool1;
        if (!bool1) {
          break label543;
        }
        bool2 = bool1;
        bool3 = bool1;
        bool4 = bool1;
        if (!paramFromServiceMsg.bytes_bodybuffer.has()) {
          break label543;
        }
        bool2 = bool1;
        bool3 = bool1;
        bool4 = bool1;
        if (paramFromServiceMsg.bytes_bodybuffer.get() == null) {
          break label543;
        }
        bool2 = bool1;
        bool3 = bool1;
        int i = ByteBuffer.wrap(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray()).getInt();
        long l = i;
        if (i < 0) {
          l = i & 0x7FFFFFFF | 0x80000000;
        }
        bool2 = bool1;
        bool3 = bool1;
        bool1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(String.valueOf(l));
        if (!bool1) {
          continue;
        }
        bool1 = bool5;
        bool3 = bool1;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.profilecard.", 2, "handleSetDisplayThirdQQSwitch result=" + bool1 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
          bool3 = bool1;
        }
      }
      catch (Exception paramFromServiceMsg) {}finally
      {
        try
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.", 2, "handleSetDisplayThirdQQSwitch ex", paramFromServiceMsg);
          }
          bool3 = bool2;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("Q.profilecard.", 2, "handleSetDisplayThirdQQSwitch result=" + bool2 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
          bool3 = bool2;
          continue;
        }
        finally
        {
          bool3 = bool2;
        }
        paramFromServiceMsg = finally;
      }
      a(81, bool3, null);
      return;
      bool1 = false;
      break;
      bool1 = false;
      continue;
      bool1 = false;
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "handleSetDisplayThirdQQSwitch result=" + bool3 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
      }
      throw paramFromServiceMsg;
      label543:
      bool1 = bool4;
    }
  }
  
  public void g(boolean paramBoolean)
  {
    short s = 1;
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "setCalReactiveSwitch OPEN=" + paramBoolean);
    }
    for (;;)
    {
      try
      {
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.uint32_command.set(1279);
        localOIDBSSOPkg.uint32_service_type.set(this.jdField_a_of_type_Short);
        Object localObject = ByteBuffer.allocate(13);
        long l = Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (paramBoolean == true)
        {
          ((ByteBuffer)localObject).putInt(Utils.a(l)).put((byte)0).putShort((short)1).putShort(this.jdField_c_of_type_Short).putShort((short)2).putShort(s);
          localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
          localObject = a("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
          ((ToServiceMsg)localObject).setTimeout(30000L);
          ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject).extraData.putBoolean("isSetCalReactiveDays", true);
          ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
          b((ToServiceMsg)localObject);
          return;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.", 2, "setCalReactiveSwitch ex", localException);
      }
      s = 0;
    }
  }
  
  public void h()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Short.valueOf((short)20009));
    localArrayList.add(Short.valueOf((short)27037));
    localArrayList.add(Short.valueOf((short)20031));
    localArrayList.add(Short.valueOf((short)24008));
    localArrayList.add(Short.valueOf((short)24002));
    localArrayList.add(Short.valueOf((short)20043));
    localArrayList.add(Short.valueOf((short)20032));
    localArrayList.add(Short.valueOf((short)20041));
    localArrayList.add(Short.valueOf((short)20011));
    localArrayList.add(Short.valueOf((short)20019));
    localArrayList.add(Short.valueOf((short)20021));
    localArrayList.add(Short.valueOf((short)20037));
    localArrayList.add(Short.valueOf((short)27220));
    localArrayList.add(Short.valueOf((short)27221));
    localArrayList.add(Short.valueOf((short)27233));
    localArrayList.add(Short.valueOf((short)27232));
    localArrayList.add(Short.valueOf((short)27219));
    localArrayList.add(Short.valueOf((short)27222));
    localArrayList.add(Short.valueOf((short)27227));
    localArrayList.add(Short.valueOf((short)-23408));
    localArrayList.add(Short.valueOf((short)-23364));
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("reqFromDetailActivity", true);
    a(localArrayList, localBundle);
  }
  
  /* Error */
  public void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 10
    //   3: aload_2
    //   4: ifnull +416 -> 420
    //   7: aload_2
    //   8: invokevirtual 1513	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   11: sipush 1000
    //   14: if_icmpne +406 -> 420
    //   17: iconst_1
    //   18: istore 7
    //   20: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   23: ifeq +28 -> 51
    //   26: ldc_w 682
    //   29: iconst_2
    //   30: iconst_2
    //   31: anewarray 447	java/lang/Object
    //   34: dup
    //   35: iconst_0
    //   36: ldc_w 5791
    //   39: aastore
    //   40: dup
    //   41: iconst_1
    //   42: iload 7
    //   44: invokestatic 195	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   47: aastore
    //   48: invokestatic 2653	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   51: iconst_m1
    //   52: istore 4
    //   54: iload 7
    //   56: istore 8
    //   58: iload 7
    //   60: ifeq +529 -> 589
    //   63: iload 7
    //   65: istore 9
    //   67: iload 7
    //   69: istore 8
    //   71: iload 4
    //   73: istore 5
    //   75: new 122	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   78: dup
    //   79: invokespecial 123	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   82: aload_3
    //   83: checkcast 125	[B
    //   86: checkcast 125	[B
    //   89: invokevirtual 129	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   92: checkcast 122	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   95: astore_1
    //   96: aload_1
    //   97: ifnull +329 -> 426
    //   100: iload 7
    //   102: istore 9
    //   104: iload 7
    //   106: istore 8
    //   108: iload 4
    //   110: istore 5
    //   112: aload_1
    //   113: getfield 133	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   116: invokevirtual 138	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   119: ifne +307 -> 426
    //   122: iconst_1
    //   123: istore 7
    //   125: iload 7
    //   127: istore 9
    //   129: iload 7
    //   131: istore 8
    //   133: iload 4
    //   135: istore 5
    //   137: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   140: ifeq +40 -> 180
    //   143: iload 7
    //   145: istore 9
    //   147: iload 7
    //   149: istore 8
    //   151: iload 4
    //   153: istore 5
    //   155: ldc_w 682
    //   158: iconst_2
    //   159: iconst_2
    //   160: anewarray 447	java/lang/Object
    //   163: dup
    //   164: iconst_0
    //   165: ldc_w 5793
    //   168: aastore
    //   169: dup
    //   170: iconst_1
    //   171: iload 7
    //   173: invokestatic 195	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   176: aastore
    //   177: invokestatic 2653	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   180: iload 7
    //   182: ifeq +381 -> 563
    //   185: iload 7
    //   187: istore 9
    //   189: iload 7
    //   191: istore 8
    //   193: iload 4
    //   195: istore 5
    //   197: aload_1
    //   198: getfield 144	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   201: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   204: ifeq +359 -> 563
    //   207: iload 7
    //   209: istore 9
    //   211: iload 7
    //   213: istore 8
    //   215: iload 4
    //   217: istore 5
    //   219: aload_1
    //   220: getfield 144	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   223: invokevirtual 152	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   226: ifnull +337 -> 563
    //   229: iload 7
    //   231: istore 9
    //   233: iload 7
    //   235: istore 8
    //   237: iload 4
    //   239: istore 5
    //   241: aload_1
    //   242: getfield 144	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   245: invokevirtual 152	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   248: invokevirtual 158	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   251: invokestatic 164	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   254: astore_1
    //   255: iload 7
    //   257: istore 9
    //   259: iload 7
    //   261: istore 8
    //   263: iload 4
    //   265: istore 5
    //   267: aload_1
    //   268: invokevirtual 167	java/nio/ByteBuffer:getInt	()I
    //   271: pop
    //   272: iload 7
    //   274: istore 9
    //   276: iload 7
    //   278: istore 8
    //   280: iload 4
    //   282: istore 5
    //   284: aload_1
    //   285: invokevirtual 170	java/nio/ByteBuffer:get	()B
    //   288: pop
    //   289: iload 7
    //   291: istore 9
    //   293: iload 7
    //   295: istore 8
    //   297: iload 4
    //   299: istore 5
    //   301: aload_1
    //   302: invokevirtual 174	java/nio/ByteBuffer:getShort	()S
    //   305: invokestatic 179	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   308: invokevirtual 182	java/lang/Short:shortValue	()S
    //   311: iconst_1
    //   312: if_icmpne +241 -> 553
    //   315: iload 7
    //   317: istore 9
    //   319: iload 7
    //   321: istore 8
    //   323: iload 4
    //   325: istore 5
    //   327: aload_1
    //   328: invokevirtual 174	java/nio/ByteBuffer:getShort	()S
    //   331: istore 6
    //   333: iload 6
    //   335: sipush -23449
    //   338: if_icmpeq +94 -> 432
    //   341: iconst_m1
    //   342: istore 4
    //   344: iload 10
    //   346: istore 7
    //   348: iload 4
    //   350: istore 5
    //   352: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   355: ifeq +46 -> 401
    //   358: ldc_w 682
    //   361: iconst_2
    //   362: new 18	java/lang/StringBuilder
    //   365: dup
    //   366: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   369: ldc_w 5793
    //   372: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: iload 7
    //   377: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   380: ldc_w 5795
    //   383: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: iload 4
    //   388: invokevirtual 572	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   391: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   394: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   397: iload 4
    //   399: istore 5
    //   401: aload_0
    //   402: getfield 106	com/tencent/mobileqq/app/CardHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   405: sipush 217
    //   408: invokevirtual 112	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   411: checkcast 5797	com/tencent/mobileqq/activity/aio/AppGuideTipsManager
    //   414: iload 5
    //   416: invokevirtual 5798	com/tencent/mobileqq/activity/aio/AppGuideTipsManager:a	(I)V
    //   419: return
    //   420: iconst_0
    //   421: istore 7
    //   423: goto -403 -> 20
    //   426: iconst_0
    //   427: istore 7
    //   429: goto -304 -> 125
    //   432: iload 7
    //   434: istore 9
    //   436: iload 7
    //   438: istore 8
    //   440: iload 4
    //   442: istore 5
    //   444: aload_1
    //   445: invokevirtual 174	java/nio/ByteBuffer:getShort	()S
    //   448: istore 6
    //   450: iload 6
    //   452: iconst_2
    //   453: if_icmpne +90 -> 543
    //   456: iload 7
    //   458: istore 9
    //   460: iload 7
    //   462: istore 8
    //   464: iload 4
    //   466: istore 5
    //   468: iload 6
    //   470: newarray byte
    //   472: astore_2
    //   473: iload 7
    //   475: istore 9
    //   477: iload 7
    //   479: istore 8
    //   481: iload 4
    //   483: istore 5
    //   485: aload_1
    //   486: aload_2
    //   487: invokevirtual 200	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   490: pop
    //   491: iload 7
    //   493: istore 9
    //   495: iload 7
    //   497: istore 8
    //   499: iload 4
    //   501: istore 5
    //   503: aload_2
    //   504: iconst_0
    //   505: invokestatic 205	com/tencent/mobileqq/util/Utils:a	([BI)S
    //   508: istore 6
    //   510: iload 6
    //   512: istore 5
    //   514: aload_1
    //   515: invokevirtual 174	java/nio/ByteBuffer:getShort	()S
    //   518: istore 6
    //   520: iload 5
    //   522: istore 4
    //   524: iload 10
    //   526: istore 7
    //   528: iload 6
    //   530: ifne -182 -> 348
    //   533: iconst_1
    //   534: istore 7
    //   536: iload 5
    //   538: istore 4
    //   540: goto -192 -> 348
    //   543: iconst_m1
    //   544: istore 4
    //   546: iload 10
    //   548: istore 7
    //   550: goto -202 -> 348
    //   553: iconst_m1
    //   554: istore 4
    //   556: iload 10
    //   558: istore 7
    //   560: goto -212 -> 348
    //   563: iload 7
    //   565: istore 9
    //   567: iload 7
    //   569: istore 8
    //   571: iload 4
    //   573: istore 5
    //   575: ldc_w 682
    //   578: iconst_1
    //   579: ldc_w 5800
    //   582: invokestatic 2058	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   585: iload 7
    //   587: istore 8
    //   589: iload 8
    //   591: istore 7
    //   593: goto -245 -> 348
    //   596: astore_1
    //   597: iload 9
    //   599: istore 7
    //   601: iload 7
    //   603: istore 8
    //   605: iload 4
    //   607: istore 5
    //   609: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   612: ifeq +35 -> 647
    //   615: iload 7
    //   617: istore 8
    //   619: iload 4
    //   621: istore 5
    //   623: ldc_w 682
    //   626: iconst_2
    //   627: iconst_2
    //   628: anewarray 447	java/lang/Object
    //   631: dup
    //   632: iconst_0
    //   633: ldc_w 5802
    //   636: aastore
    //   637: dup
    //   638: iconst_1
    //   639: aload_1
    //   640: invokevirtual 639	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   643: aastore
    //   644: invokestatic 2653	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   647: iload 4
    //   649: istore 5
    //   651: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   654: ifeq -253 -> 401
    //   657: ldc_w 682
    //   660: iconst_2
    //   661: new 18	java/lang/StringBuilder
    //   664: dup
    //   665: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   668: ldc_w 5793
    //   671: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   674: iload 7
    //   676: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   679: ldc_w 5795
    //   682: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   685: iload 4
    //   687: invokevirtual 572	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   690: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   693: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   696: iload 4
    //   698: istore 5
    //   700: goto -299 -> 401
    //   703: astore_1
    //   704: iload 8
    //   706: istore 7
    //   708: invokestatic 93	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   711: ifeq +42 -> 753
    //   714: ldc_w 682
    //   717: iconst_2
    //   718: new 18	java/lang/StringBuilder
    //   721: dup
    //   722: invokespecial 21	java/lang/StringBuilder:<init>	()V
    //   725: ldc_w 5793
    //   728: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   731: iload 7
    //   733: invokevirtual 100	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   736: ldc_w 5795
    //   739: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   742: iload 5
    //   744: invokevirtual 572	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   747: invokevirtual 36	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   750: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   753: aload_1
    //   754: athrow
    //   755: astore_1
    //   756: goto -48 -> 708
    //   759: astore_1
    //   760: iload 5
    //   762: istore 4
    //   764: goto -163 -> 601
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	767	0	this	CardHandler
    //   0	767	1	paramToServiceMsg	ToServiceMsg
    //   0	767	2	paramFromServiceMsg	FromServiceMsg
    //   0	767	3	paramObject	Object
    //   52	711	4	i	int
    //   73	688	5	j	int
    //   331	198	6	k	int
    //   18	714	7	bool1	boolean
    //   56	649	8	bool2	boolean
    //   65	533	9	bool3	boolean
    //   1	556	10	bool4	boolean
    // Exception table:
    //   from	to	target	type
    //   75	96	596	java/lang/Exception
    //   112	122	596	java/lang/Exception
    //   137	143	596	java/lang/Exception
    //   155	180	596	java/lang/Exception
    //   197	207	596	java/lang/Exception
    //   219	229	596	java/lang/Exception
    //   241	255	596	java/lang/Exception
    //   267	272	596	java/lang/Exception
    //   284	289	596	java/lang/Exception
    //   301	315	596	java/lang/Exception
    //   327	333	596	java/lang/Exception
    //   444	450	596	java/lang/Exception
    //   468	473	596	java/lang/Exception
    //   485	491	596	java/lang/Exception
    //   503	510	596	java/lang/Exception
    //   575	585	596	java/lang/Exception
    //   75	96	703	finally
    //   112	122	703	finally
    //   137	143	703	finally
    //   155	180	703	finally
    //   197	207	703	finally
    //   219	229	703	finally
    //   241	255	703	finally
    //   267	272	703	finally
    //   284	289	703	finally
    //   301	315	703	finally
    //   327	333	703	finally
    //   444	450	703	finally
    //   468	473	703	finally
    //   485	491	703	finally
    //   503	510	703	finally
    //   575	585	703	finally
    //   609	615	703	finally
    //   623	647	703	finally
    //   514	520	755	finally
    //   514	520	759	java/lang/Exception
  }
  
  public void h(boolean paramBoolean)
  {
    short s = 1;
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "setMedalSwitch OPEN=" + paramBoolean);
    }
    for (;;)
    {
      try
      {
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.uint32_command.set(1279);
        localOIDBSSOPkg.uint32_service_type.set(this.jdField_a_of_type_Short);
        Object localObject = ByteBuffer.allocate(13);
        long l = Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (paramBoolean)
        {
          ((ByteBuffer)localObject).putInt(Utils.a(l)).put((byte)0).putShort((short)1).putShort(this.d).putShort((short)2).putShort(s);
          localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
          localObject = a("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
          ((ToServiceMsg)localObject).setTimeout(30000L);
          ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject).extraData.putBoolean("uint32_req_medalwall_flag", true);
          ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
          b((ToServiceMsg)localObject);
          return;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.", 2, "setMedalSwitch ex", localException);
      }
      s = 0;
    }
  }
  
  public void i()
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1152);
    localOIDBSSOPkg.uint32_result.set(0);
    localOIDBSSOPkg.uint32_service_type.set(9);
    Object localObject = ByteBuffer.allocate(35);
    ((ByteBuffer)localObject).putInt((int)Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    ((ByteBuffer)localObject).put((byte)0);
    ((ByteBuffer)localObject).putShort((short)14);
    ((ByteBuffer)localObject).putShort((short)-25223);
    ((ByteBuffer)localObject).putShort((short)-25222);
    ((ByteBuffer)localObject).putShort((short)-25221);
    ((ByteBuffer)localObject).putShort((short)-25220);
    ((ByteBuffer)localObject).putShort((short)-25219);
    ((ByteBuffer)localObject).putShort((short)-25218);
    ((ByteBuffer)localObject).putShort((short)-25216);
    ((ByteBuffer)localObject).putShort((short)-23555);
    ((ByteBuffer)localObject).putShort((short)-25201);
    ((ByteBuffer)localObject).putShort((short)-25009);
    ((ByteBuffer)localObject).putShort((short)-25010);
    ((ByteBuffer)localObject).putShort((short)-25183);
    ((ByteBuffer)localObject).putShort((short)-25178);
    ((ByteBuffer)localObject).putShort((short)-23363);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = a("OidbSvc.0x480_9");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
    b((ToServiceMsg)localObject);
  }
  
  public void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l1 = 0L;
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {}
    String str;
    long l3;
    MedalWallMng localMedalWallMng;
    long l2;
    label245:
    do
    {
      do
      {
        return;
        str = paramToServiceMsg.extraData.getString("uin", "");
        l3 = paramToServiceMsg.extraData.getLong("ts", 0L);
        paramToServiceMsg = new cmd0x7a8.RspBody();
        i = a(paramFromServiceMsg, paramObject, paramToServiceMsg);
        if (QLog.isColorLevel()) {
          QLog.i("MedalWallMng", 2, "handleGetFriendMedalNews " + i + "|" + str + "|" + l3);
        }
        localMedalWallMng = (MedalWallMng)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(249);
      } while (i != 0);
      if (paramToServiceMsg.uint32_now.has()) {
        l1 = paramToServiceMsg.uint32_now.get();
      }
      if (!paramToServiceMsg.rpt_msg_medal.has()) {
        break;
      }
      paramToServiceMsg = paramToServiceMsg.rpt_msg_medal.get();
      localObject = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      paramObject = ((FriendsManager)localObject).a(str);
      paramFromServiceMsg = paramObject;
      if (paramObject == null)
      {
        paramFromServiceMsg = new ExtensionInfo();
        paramFromServiceMsg.uin = str;
      }
      if ((l1 > l3) && (paramToServiceMsg != null) && (paramToServiceMsg.size() != 0)) {
        break label346;
      }
      if (l1 <= l3) {
        break label328;
      }
      l2 = l1;
      paramFromServiceMsg.medalUpdateTimestamp = l2;
      ((FriendsManager)localObject).a(paramFromServiceMsg);
    } while (!QLog.isColorLevel());
    paramFromServiceMsg = new StringBuilder().append("handleGetFriendMedalNews no update lastTs:").append(l3).append(" nowTs:").append(l1).append(" size:");
    if (paramToServiceMsg == null) {}
    for (int i = 0;; i = paramToServiceMsg.size())
    {
      QLog.i("MedalWallMng", 2, i);
      return;
      paramToServiceMsg = null;
      break;
      label328:
      l2 = l3;
      break label245;
    }
    label346:
    paramFromServiceMsg.lastMedalTimestamp = l1;
    paramFromServiceMsg.medalUpdateTimestamp = l1;
    ((FriendsManager)localObject).a(paramFromServiceMsg);
    paramObject = (common.MedalInfo)paramToServiceMsg.get(paramToServiceMsg.size() - 1);
    i = paramObject.uint32_fromuin_level.get();
    if (QLog.isColorLevel()) {
      QLog.i("CardHandler", 2, "handleGetFriendMedalNews my level " + i);
    }
    Object localObject = new JSONObject();
    int j;
    for (;;)
    {
      try
      {
        j = paramObject.uint32_level.get();
        if (j <= 0)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("CardHandler", 2, "handleGetFriendMedalNews level not right" + j);
          return;
        }
      }
      catch (JSONException paramToServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("CardHandler", 2, "handleGetFriendMedalNews", paramToServiceMsg);
        return;
        ((JSONObject)localObject).put("name", paramObject.str_name.get());
        ((JSONObject)localObject).put("level", j);
        ((JSONObject)localObject).put("myLevel", i);
        paramToServiceMsg = new JSONArray(paramObject.str_resource.get());
        if (j <= 3) {
          break label626;
        }
        i = 1;
        paramFromServiceMsg = ((JSONObject)paramToServiceMsg.get(i)).optString("owned3d", "");
        if (!TextUtils.isEmpty(paramFromServiceMsg)) {
          break label633;
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("CardHandler", 2, "handleGetFriendMedalNews iconUrl is null");
        return;
      }
      catch (Exception paramToServiceMsg) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("CardHandler", 2, "handleGetFriendMedalNews", paramToServiceMsg);
      return;
      label626:
      i = j;
    }
    label633:
    paramToServiceMsg = paramFromServiceMsg;
    if (!paramFromServiceMsg.startsWith("http:")) {
      paramToServiceMsg = "http://" + paramFromServiceMsg;
    }
    ((JSONObject)localObject).put("icon", paramToServiceMsg);
    switch (j)
    {
    }
    for (;;)
    {
      paramToServiceMsg = paramObject.str_desc.get();
      l2 = paramObject.uint64_time.get();
      l1 = paramObject.uint32_seq.get();
      for (;;)
      {
        ((JSONObject)localObject).put("ts", l2);
        ((JSONObject)localObject).put("desc", paramToServiceMsg);
        ((JSONObject)localObject).put("seq", l1);
        ((JSONObject)localObject).put("id", paramObject.uint32_id.get());
        if (QLog.isColorLevel()) {
          QLog.i("CardHandler", 2, "handleGetFriendMedalNews insert gray msg");
        }
        localMedalWallMng.a(((JSONObject)localObject).toString(), str, l2);
        return;
        paramToServiceMsg = paramObject.str_desc.get();
        l2 = paramObject.uint64_time.get();
        l1 = paramObject.uint32_seq.get();
        continue;
        paramToServiceMsg = paramObject.str_desc_level2.get();
        l2 = paramObject.uint64_time_level2.get();
        l1 = paramObject.uint32_seq_level2.get();
        continue;
        paramToServiceMsg = paramObject.str_desc_level3.get();
        l2 = paramObject.uint64_time_level3.get();
        l1 = paramObject.uint32_seq_level3.get();
      }
    }
  }
  
  public void i(boolean paramBoolean)
  {
    short s = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "setActivateFriendSwitch OPEN=" + paramBoolean);
    }
    for (;;)
    {
      try
      {
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.uint32_command.set(1279);
        localOIDBSSOPkg.uint32_service_type.set(this.jdField_a_of_type_Short);
        Object localObject = ByteBuffer.allocate(13);
        long l = Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (paramBoolean == true)
        {
          ((ByteBuffer)localObject).putInt(Utils.a(l)).put((byte)0).putShort((short)1).putShort((short)-25031).putShort((short)2).putShort(s);
          localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
          localObject = a("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
          ((ToServiceMsg)localObject).setTimeout(30000L);
          ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject).extraData.putBoolean("isSetActivateFriend", true);
          ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
          b((ToServiceMsg)localObject);
          return;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.", 2, "setActivateFriendSwitch ex", localException);
      }
      s = 1;
    }
  }
  
  public void j()
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      return;
    }
  }
  
  public void j(boolean paramBoolean)
  {
    short s = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "setBabyQSwitch OPEN=" + paramBoolean);
    }
    for (;;)
    {
      try
      {
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.uint32_command.set(1279);
        localOIDBSSOPkg.uint32_service_type.set(this.jdField_a_of_type_Short);
        Object localObject = ByteBuffer.allocate(13);
        long l = Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (paramBoolean == true)
        {
          ((ByteBuffer)localObject).putInt(Utils.a(l)).put((byte)0).putShort((short)1).putShort(this.e).putShort((short)2).putShort(s);
          localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
          localObject = a("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
          ((ToServiceMsg)localObject).setTimeout(30000L);
          ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject).extraData.putBoolean("isSetBabyQSwitch", true);
          ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
          b((ToServiceMsg)localObject);
          if (paramBoolean) {
            this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).edit().putInt("babyQ_drag_count", 0).commit();
          }
          return;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.", 2, "setBabyQSwitch ex", localException);
      }
      s = 1;
    }
  }
  
  public void k()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "getPCActiveState");
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Short.valueOf((short)-25042));
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("pcActiveState", true);
      a(localArrayList, localBundle);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.profilecard.", 2, "getPCActiveState ex", localException);
    }
  }
  
  public void k(boolean paramBoolean)
  {
    short s = 1;
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "setDisplayThirdQQSwitch OPEN=" + paramBoolean);
    }
    try
    {
      long l = Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if (paramBoolean == true) {
        s = 0;
      }
      Object localObject = new byte[13];
      PkgTools.a((byte[])localObject, 0, l);
      localObject[4] = 0;
      PkgTools.a((byte[])localObject, 5, (short)1);
      PkgTools.a((byte[])localObject, 7, 40348);
      PkgTools.a((byte[])localObject, 9, (short)2);
      PkgTools.a((byte[])localObject, 11, s);
      localObject = a("OidbSvc.0x4ff_9", 1279, 9, (byte[])localObject);
      ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
      ((ToServiceMsg)localObject).extraData.putBoolean("isSetDisplayThirdQQSwitch", true);
      ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
      b((ToServiceMsg)localObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      a(81, false, null);
    }
  }
  
  public void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "getHelloLiveMessageState");
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Short.valueOf((short)-25181));
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("helloLiveMessage", true);
      a(localArrayList, localBundle);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.profilecard.", 2, "getHelloLiveMessageState ex", localException);
    }
  }
  
  public void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "getPartekeLikeRankingList");
    }
    oidb_0x5eb.ReqBody localReqBody = new oidb_0x5eb.ReqBody();
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.add(Long.valueOf(Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())));
      localReqBody.rpt_uint64_uins.set(localArrayList);
      localReqBody.uint32_notify_partake_like_ranking_list_flag.set(1);
      b(a("OidbSvc.0x5eb_40350", 1515, 22, localReqBody.toByteArray()));
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("CardHandler", 2, "send_oidb_0x5eb_40350 error", localException);
    }
  }
  
  public void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "getNotifyOnLikeRankingList");
    }
    oidb_0x5eb.ReqBody localReqBody = new oidb_0x5eb.ReqBody();
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.add(Long.valueOf(Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())));
      localReqBody.rpt_uint64_uins.set(localArrayList);
      localReqBody.uint32_notify_on_like_ranking_list_flag.set(1);
      b(a("OidbSvc.0x5eb_42092", 1515, 22, localReqBody.toByteArray()));
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.w("CardHandler", 2, "send_oidb_0x5eb_42092 error", localException);
    }
  }
  
  public void o()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "getLoginDaysSwitch");
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Short.valueOf(this.jdField_b_of_type_Short));
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("isGetLoginDays", true);
      a(localArrayList, localBundle);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.profilecard.", 2, "getLoginDaysSwitch ex", localException);
    }
  }
  
  public void p()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "getCalReactiveSwitch");
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Short.valueOf(this.jdField_c_of_type_Short));
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("isGetCalReactive", true);
      a(localArrayList, localBundle);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.profilecard.", 2, "getCalReactiveSwitch ex", localException);
    }
  }
  
  public void q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "getActivateFriendSwitch");
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Short.valueOf((short)-25031));
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("isGetActivateFriend", true);
      a(localArrayList, localBundle);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.profilecard.", 2, "getActivateFriendSwitch ex", localException);
    }
  }
  
  public void r()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "getBabyQSwitch");
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Short.valueOf(this.e));
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("isGetBabyQSwitch", true);
      a(localArrayList, localBundle);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.profilecard.", 2, "getBabyQSwitch ex", localException);
    }
  }
  
  public void s()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CardHandler", 2, "getCampusLebaEntrySwitch");
    }
    long l1 = SystemClock.elapsedRealtime();
    SosoInterface.a(60000L, "Leba.CampusEntry");
    Object localObject2 = SosoInterface.a();
    long l2 = Math.abs(SystemClock.elapsedRealtime() - l1);
    Object localObject1 = new oidb_0xa6d.LBSInfo();
    if (localObject2 != null)
    {
      Object localObject3 = new oidb_0xa6d.GPS();
      ((oidb_0xa6d.GPS)localObject3).int32_lat.set((int)(((SosoInterface.SosoLbsInfo)localObject2).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.a * 1000000.0D));
      ((oidb_0xa6d.GPS)localObject3).int32_lon.set((int)(((SosoInterface.SosoLbsInfo)localObject2).jdField_a_of_type_ComTencentMobileqqAppSosoSosoInterface$SosoLocation.b * 1000000.0D));
      ((oidb_0xa6d.GPS)localObject3).int32_alt.set(-1);
      ((oidb_0xa6d.GPS)localObject3).int32_type.set(1);
      ((oidb_0xa6d.LBSInfo)localObject1).msg_gps.set((MessageMicro)localObject3);
      Object localObject4;
      if (((SosoInterface.SosoLbsInfo)localObject2).jdField_a_of_type_JavaUtilArrayList != null)
      {
        localObject3 = ((SosoInterface.SosoLbsInfo)localObject2).jdField_a_of_type_JavaUtilArrayList.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          localObject4 = (SosoInterface.SosoCell)((Iterator)localObject3).next();
          oidb_0xa6d.Cell localCell = new oidb_0xa6d.Cell();
          localCell.int32_mcc.set(((SosoInterface.SosoCell)localObject4).jdField_a_of_type_Int);
          localCell.int32_mnc.set(((SosoInterface.SosoCell)localObject4).jdField_b_of_type_Int);
          localCell.int32_lac.set(((SosoInterface.SosoCell)localObject4).c);
          localCell.int32_cellid.set(((SosoInterface.SosoCell)localObject4).d);
          localCell.int32_rssi.set(((SosoInterface.SosoCell)localObject4).e);
          ((oidb_0xa6d.LBSInfo)localObject1).rpt_msg_cells.add(localCell);
        }
      }
      if (((SosoInterface.SosoLbsInfo)localObject2).b != null)
      {
        localObject2 = ((SosoInterface.SosoLbsInfo)localObject2).b.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (SosoInterface.SosoWifi)((Iterator)localObject2).next();
          localObject4 = new oidb_0xa6d.Wifi();
          ((oidb_0xa6d.Wifi)localObject4).uint64_mac.set(((SosoInterface.SosoWifi)localObject3).jdField_a_of_type_Long);
          ((oidb_0xa6d.Wifi)localObject4).int32_rssi.set(((SosoInterface.SosoWifi)localObject3).jdField_a_of_type_Int);
          ((oidb_0xa6d.LBSInfo)localObject1).rpt_msg_wifis.add((MessageMicro)localObject4);
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.i("CardHandler", 2, "getCampusLebaEntrySwitch sosoLbsInfo is null");
    }
    localObject2 = new oidb_0xa6d.ReqBody();
    ((oidb_0xa6d.ReqBody)localObject2).msg_lbs_info.set((MessageMicro)localObject1);
    localObject1 = a("OidbSvc.0xa6d", 2669, 0, ((oidb_0xa6d.ReqBody)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).extraData.putLong("lbs_cost", l2);
    ((ToServiceMsg)localObject1).extraData.putLong("start_time", l1);
    b((ToServiceMsg)localObject1);
  }
  
  public void t()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "getOfficeUserFlag");
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Short.valueOf((short)-23449));
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("isOfficeUserFlag", true);
      a(localArrayList, localBundle);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.profilecard.", 2, "isQimOldUserFlag ex", localException);
    }
  }
  
  public void u()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("MedalWallMng", 4, "getSelfNewObtainedMedalWall");
    }
    try
    {
      l = Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if (l == 0L) {
        return;
      }
    }
    catch (Exception localException)
    {
      long l;
      for (;;)
      {
        localException.printStackTrace();
        l = 0L;
      }
      Object localObject = new cmd0x7a8.ReqBody();
      ((cmd0x7a8.ReqBody)localObject).uint64_req_uin.set(l);
      ((cmd0x7a8.ReqBody)localObject).uint32_sort_type.set(1);
      ((cmd0x7a8.ReqBody)localObject).uint32_only_obtained.set(1);
      ((cmd0x7a8.ReqBody)localObject).uint32_only_new.set(1);
      localObject = a("OidbSvc.0x7a8", 1960, 5, ((cmd0x7a8.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("from", "getSelfNewObtainedMedalWall");
      b((ToServiceMsg)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.CardHandler
 * JD-Core Version:    0.7.0.1
 */
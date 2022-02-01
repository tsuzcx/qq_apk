package com.tencent.mobileqq.app;

import AccostSvc.Msg;
import AccostSvc.RespClientMsg;
import NS_MOBILE_MAIN_PAGE.mobile_sub_get_cover_rsp;
import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
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
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.now.NowLiveManager;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.face.util.FaceUtil;
import com.tencent.mobileqq.app.hiddenchat.HiddenChatUtil;
import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.chat.MessageNotificationSettingManager;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.CardProfile;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.KplCard;
import com.tencent.mobileqq.data.LikeRankingInfo;
import com.tencent.mobileqq.data.MedalInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QZoneCover;
import com.tencent.mobileqq.data.QZonePhotoWall;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.managers.TempMsgManager;
import com.tencent.mobileqq.medalwall.MedalID;
import com.tencent.mobileqq.medalwall.MedalWallMng;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.NearByGeneralManager;
import com.tencent.mobileqq.nearby.redtouch.Util;
import com.tencent.mobileqq.onlinestatus.AutoReplyManager;
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
import com.tencent.mobileqq.persistence.EntityTransaction;
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
import tencent.im.ilive.photo.NowLiveGallary.ReqBody;
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
import tencent.im.oidb.cmd0x922.cmd0x922.PushInfo;
import tencent.im.oidb.cmd0x922.cmd0x922.ReqBody;
import tencent.im.oidb.cmd0x922.cmd0x922.RspBody;
import tencent.im.oidb.cmd0xa28.oidb_0xa28.ReqBody;
import tencent.im.oidb.cmd0xa28.oidb_0xa28.RspBody;
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
import tencent.im.oidb.cmd0xe26.oidb_0xe26.EntranceTemplate;
import tencent.im.oidb.cmd0xe26.oidb_0xe26.ReqBody;
import tencent.im.oidb.cmd0xe26.oidb_0xe26.RspBody;
import tencent.im.oidb.cmd0xe5f.oidb_0xe5f.ReqBody;
import tencent.im.oidb.cmd0xe5f.oidb_0xe5f.RspBody;
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
    jdField_a_of_type_JavaLangString = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "portrait/");
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
  
  private void A(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
        break label509;
      }
      bool4 = bool1;
      bool5 = bool1;
    }
    label509:
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
          break label509;
        }
        bool4 = bool1;
        bool5 = bool1;
        bool2 = bool1;
        if (!paramToServiceMsg.bytes_bodybuffer.has()) {
          break label509;
        }
        bool4 = bool1;
        bool5 = bool1;
        bool2 = bool1;
        if (paramToServiceMsg.bytes_bodybuffer.get() == null) {
          break label509;
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
      notifyUI(79, bool5, Boolean.valueOf(bool1));
      return;
      bool1 = false;
      break;
      bool1 = false;
    }
  }
  
  private void B(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
        break label593;
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
          break label593;
        }
        bool2 = bool1;
        bool3 = bool1;
        bool4 = bool1;
        if (!paramFromServiceMsg.bytes_bodybuffer.has()) {
          break label593;
        }
        bool2 = bool1;
        bool3 = bool1;
        bool4 = bool1;
        if (paramFromServiceMsg.bytes_bodybuffer.get() == null) {
          break label593;
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
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(String.valueOf(l))) {
          continue;
        }
        bool2 = bool1;
        bool3 = bool1;
        paramFromServiceMsg = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        bool2 = bool1;
        bool3 = bool1;
        paramObject = paramFromServiceMsg.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
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
      notifyUI(45, bool3, null);
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
      label593:
      bool1 = bool4;
    }
  }
  
  /* Error */
  private void C(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 10
    //   3: iconst_1
    //   4: istore 11
    //   6: iconst_1
    //   7: istore 9
    //   9: aload_2
    //   10: invokevirtual 101	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   13: ifeq +604 -> 617
    //   16: aload_3
    //   17: ifnull +600 -> 617
    //   20: iconst_1
    //   21: istore 5
    //   23: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +30 -> 56
    //   29: ldc 191
    //   31: iconst_2
    //   32: new 20	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   39: ldc_w 264
    //   42: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: iload 5
    //   47: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   50: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: iload 5
    //   58: istore 8
    //   60: iload 5
    //   62: ifeq +750 -> 812
    //   65: iload 5
    //   67: istore 6
    //   69: iload 5
    //   71: istore 7
    //   73: new 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   76: dup
    //   77: invokespecial 120	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   80: aload_3
    //   81: checkcast 122	[B
    //   84: checkcast 122	[B
    //   87: invokevirtual 126	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   90: checkcast 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   93: astore_2
    //   94: aload_2
    //   95: ifnull +528 -> 623
    //   98: iload 5
    //   100: istore 6
    //   102: iload 5
    //   104: istore 7
    //   106: aload_2
    //   107: getfield 130	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   110: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   113: ifne +510 -> 623
    //   116: iconst_1
    //   117: istore 5
    //   119: iload 5
    //   121: istore 6
    //   123: iload 5
    //   125: istore 7
    //   127: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   130: ifeq +38 -> 168
    //   133: iload 5
    //   135: istore 6
    //   137: iload 5
    //   139: istore 7
    //   141: ldc 191
    //   143: iconst_2
    //   144: new 20	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   151: ldc_w 266
    //   154: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: iload 5
    //   159: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   162: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   168: iload 5
    //   170: istore 8
    //   172: iload 5
    //   174: ifeq +638 -> 812
    //   177: iload 5
    //   179: istore 6
    //   181: iload 5
    //   183: istore 7
    //   185: iload 5
    //   187: istore 8
    //   189: aload_2
    //   190: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   193: invokevirtual 146	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   196: ifeq +616 -> 812
    //   199: iload 5
    //   201: istore 6
    //   203: iload 5
    //   205: istore 7
    //   207: iload 5
    //   209: istore 8
    //   211: aload_2
    //   212: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   215: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   218: ifnull +594 -> 812
    //   221: iload 5
    //   223: istore 6
    //   225: iload 5
    //   227: istore 7
    //   229: aload_2
    //   230: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   233: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   236: invokevirtual 158	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   239: invokestatic 201	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   242: invokevirtual 204	java/nio/ByteBuffer:getInt	()I
    //   245: istore 4
    //   247: iload 4
    //   249: ifge +380 -> 629
    //   252: iload 4
    //   254: i2l
    //   255: ldc2_w 205
    //   258: ladd
    //   259: lstore 12
    //   261: iload 5
    //   263: istore 6
    //   265: iload 5
    //   267: istore 7
    //   269: aload_0
    //   270: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   273: invokevirtual 211	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   276: lload 12
    //   278: invokestatic 216	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   281: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   284: ifeq +456 -> 740
    //   287: iload 5
    //   289: istore 6
    //   291: iload 5
    //   293: istore 7
    //   295: aload_0
    //   296: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   299: getstatic 225	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   302: invokevirtual 229	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   305: checkcast 231	com/tencent/mobileqq/app/FriendsManager
    //   308: astore_2
    //   309: iload 5
    //   311: istore 6
    //   313: iload 5
    //   315: istore 7
    //   317: aload_2
    //   318: aload_0
    //   319: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   322: invokevirtual 211	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   325: invokevirtual 234	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   328: astore_3
    //   329: iload 5
    //   331: istore 6
    //   333: iload 5
    //   335: istore 7
    //   337: aload_3
    //   338: aload_1
    //   339: getfield 240	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   342: ldc 242
    //   344: invokevirtual 248	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   347: putfield 269	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   350: iload 5
    //   352: istore 6
    //   354: iload 5
    //   356: istore 7
    //   358: aload_2
    //   359: aload_3
    //   360: invokevirtual 257	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   363: pop
    //   364: iload 11
    //   366: istore 6
    //   368: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   371: ifeq +37 -> 408
    //   374: iload 11
    //   376: istore 6
    //   378: ldc_w 271
    //   381: iconst_2
    //   382: new 20	java/lang/StringBuilder
    //   385: dup
    //   386: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   389: ldc_w 273
    //   392: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: aload_3
    //   396: getfield 269	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   399: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   402: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   408: iload 11
    //   410: istore 6
    //   412: aload_3
    //   413: getfield 269	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   416: ifeq +221 -> 637
    //   419: iload 11
    //   421: istore 6
    //   423: aload_2
    //   424: iconst_1
    //   425: putfield 276	com/tencent/mobileqq/app/FriendsManager:q	I
    //   428: iload 11
    //   430: istore 6
    //   432: aload_0
    //   433: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   436: invokevirtual 280	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   439: aload_0
    //   440: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   443: invokevirtual 211	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   446: iconst_0
    //   447: invokevirtual 286	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   450: invokeinterface 292 1 0
    //   455: ldc_w 294
    //   458: aload_2
    //   459: getfield 276	com/tencent/mobileqq/app/FriendsManager:q	I
    //   462: invokeinterface 300 3 0
    //   467: invokeinterface 303 1 0
    //   472: pop
    //   473: iload 9
    //   475: istore 5
    //   477: iload 5
    //   479: istore 6
    //   481: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   484: ifeq +52 -> 536
    //   487: ldc 191
    //   489: iconst_2
    //   490: new 20	java/lang/StringBuilder
    //   493: dup
    //   494: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   497: ldc_w 266
    //   500: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   503: iload 5
    //   505: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   508: ldc_w 259
    //   511: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: aload_1
    //   515: getfield 240	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   518: ldc 242
    //   520: invokevirtual 248	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   523: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   526: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   529: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   532: iload 5
    //   534: istore 6
    //   536: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   539: ifeq +68 -> 607
    //   542: aload_0
    //   543: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   546: getstatic 225	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   549: invokevirtual 229	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   552: checkcast 231	com/tencent/mobileqq/app/FriendsManager
    //   555: aload_0
    //   556: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   559: invokevirtual 211	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   562: invokevirtual 234	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   565: astore_1
    //   566: ldc_w 271
    //   569: iconst_2
    //   570: new 20	java/lang/StringBuilder
    //   573: dup
    //   574: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   577: ldc_w 273
    //   580: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   583: aload_1
    //   584: getfield 269	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   587: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   590: ldc_w 305
    //   593: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: iload 6
    //   598: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   601: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   604: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   607: aload_0
    //   608: bipush 73
    //   610: iload 6
    //   612: aconst_null
    //   613: invokevirtual 183	com/tencent/mobileqq/app/CardHandler:notifyUI	(IZLjava/lang/Object;)V
    //   616: return
    //   617: iconst_0
    //   618: istore 5
    //   620: goto -597 -> 23
    //   623: iconst_0
    //   624: istore 5
    //   626: goto -507 -> 119
    //   629: iload 4
    //   631: i2l
    //   632: lstore 12
    //   634: goto -373 -> 261
    //   637: iload 11
    //   639: istore 6
    //   641: aload_2
    //   642: iconst_0
    //   643: putfield 276	com/tencent/mobileqq/app/FriendsManager:q	I
    //   646: goto -218 -> 428
    //   649: astore_2
    //   650: iload 10
    //   652: istore 5
    //   654: iload 5
    //   656: istore 6
    //   658: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   661: ifeq +17 -> 678
    //   664: iload 5
    //   666: istore 6
    //   668: ldc 191
    //   670: iconst_2
    //   671: ldc_w 307
    //   674: aload_2
    //   675: invokestatic 188	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   678: iload 5
    //   680: istore 6
    //   682: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   685: ifeq -149 -> 536
    //   688: ldc 191
    //   690: iconst_2
    //   691: new 20	java/lang/StringBuilder
    //   694: dup
    //   695: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   698: ldc_w 266
    //   701: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   704: iload 5
    //   706: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   709: ldc_w 259
    //   712: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   715: aload_1
    //   716: getfield 240	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   719: ldc 242
    //   721: invokevirtual 248	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   724: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   727: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   730: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   733: iload 5
    //   735: istore 6
    //   737: goto -201 -> 536
    //   740: iconst_0
    //   741: istore 5
    //   743: goto -266 -> 477
    //   746: astore_2
    //   747: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   750: ifeq +48 -> 798
    //   753: ldc 191
    //   755: iconst_2
    //   756: new 20	java/lang/StringBuilder
    //   759: dup
    //   760: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   763: ldc_w 266
    //   766: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   769: iload 6
    //   771: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   774: ldc_w 259
    //   777: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   780: aload_1
    //   781: getfield 240	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   784: ldc 242
    //   786: invokevirtual 248	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   789: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   792: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   795: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   798: aload_2
    //   799: athrow
    //   800: astore_2
    //   801: goto -54 -> 747
    //   804: astore_2
    //   805: iload 7
    //   807: istore 5
    //   809: goto -155 -> 654
    //   812: iload 8
    //   814: istore 5
    //   816: goto -339 -> 477
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	819	0	this	CardHandler
    //   0	819	1	paramToServiceMsg	ToServiceMsg
    //   0	819	2	paramFromServiceMsg	FromServiceMsg
    //   0	819	3	paramObject	Object
    //   245	385	4	i	int
    //   21	794	5	bool1	boolean
    //   67	703	6	bool2	boolean
    //   71	735	7	bool3	boolean
    //   58	755	8	bool4	boolean
    //   7	467	9	bool5	boolean
    //   1	650	10	bool6	boolean
    //   4	634	11	bool7	boolean
    //   259	374	12	l	long
    // Exception table:
    //   from	to	target	type
    //   368	374	649	java/lang/Exception
    //   378	408	649	java/lang/Exception
    //   412	419	649	java/lang/Exception
    //   423	428	649	java/lang/Exception
    //   432	473	649	java/lang/Exception
    //   641	646	649	java/lang/Exception
    //   73	94	746	finally
    //   106	116	746	finally
    //   127	133	746	finally
    //   141	168	746	finally
    //   189	199	746	finally
    //   211	221	746	finally
    //   229	247	746	finally
    //   269	287	746	finally
    //   295	309	746	finally
    //   317	329	746	finally
    //   337	350	746	finally
    //   358	364	746	finally
    //   368	374	800	finally
    //   378	408	800	finally
    //   412	419	800	finally
    //   423	428	800	finally
    //   432	473	800	finally
    //   641	646	800	finally
    //   658	664	800	finally
    //   668	678	800	finally
    //   73	94	804	java/lang/Exception
    //   106	116	804	java/lang/Exception
    //   127	133	804	java/lang/Exception
    //   141	168	804	java/lang/Exception
    //   189	199	804	java/lang/Exception
    //   211	221	804	java/lang/Exception
    //   229	247	804	java/lang/Exception
    //   269	287	804	java/lang/Exception
    //   295	309	804	java/lang/Exception
    //   317	329	804	java/lang/Exception
    //   337	350	804	java/lang/Exception
    //   358	364	804	java/lang/Exception
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
    //   10: invokevirtual 101	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   13: ifeq +674 -> 687
    //   16: aload_3
    //   17: ifnull +670 -> 687
    //   20: iconst_1
    //   21: istore 5
    //   23: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +30 -> 56
    //   29: ldc 191
    //   31: iconst_2
    //   32: new 20	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   39: ldc_w 310
    //   42: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: iload 5
    //   47: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   50: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: iload 5
    //   58: istore 8
    //   60: iload 5
    //   62: ifeq +812 -> 874
    //   65: iload 5
    //   67: istore 6
    //   69: iload 5
    //   71: istore 7
    //   73: new 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   76: dup
    //   77: invokespecial 120	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   80: aload_3
    //   81: checkcast 122	[B
    //   84: checkcast 122	[B
    //   87: invokevirtual 126	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   90: checkcast 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   93: astore_2
    //   94: iload 5
    //   96: istore 6
    //   98: iload 5
    //   100: istore 7
    //   102: aload_2
    //   103: getfield 130	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   106: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   109: ifne +584 -> 693
    //   112: iconst_1
    //   113: istore 5
    //   115: iload 5
    //   117: istore 6
    //   119: iload 5
    //   121: istore 7
    //   123: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   126: ifeq +38 -> 164
    //   129: iload 5
    //   131: istore 6
    //   133: iload 5
    //   135: istore 7
    //   137: ldc 191
    //   139: iconst_2
    //   140: new 20	java/lang/StringBuilder
    //   143: dup
    //   144: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   147: ldc_w 312
    //   150: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: iload 5
    //   155: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   158: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   161: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   164: iload 5
    //   166: istore 8
    //   168: iload 5
    //   170: ifeq +704 -> 874
    //   173: iload 5
    //   175: istore 6
    //   177: iload 5
    //   179: istore 7
    //   181: iload 5
    //   183: istore 8
    //   185: aload_2
    //   186: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   189: invokevirtual 146	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   192: ifeq +682 -> 874
    //   195: iload 5
    //   197: istore 6
    //   199: iload 5
    //   201: istore 7
    //   203: iload 5
    //   205: istore 8
    //   207: aload_2
    //   208: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   211: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   214: ifnull +660 -> 874
    //   217: iload 5
    //   219: istore 6
    //   221: iload 5
    //   223: istore 7
    //   225: aload_2
    //   226: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   229: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   232: invokevirtual 158	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   235: invokestatic 201	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   238: invokevirtual 204	java/nio/ByteBuffer:getInt	()I
    //   241: istore 4
    //   243: iload 4
    //   245: ifge +454 -> 699
    //   248: iload 4
    //   250: i2l
    //   251: ldc2_w 205
    //   254: ladd
    //   255: lstore 13
    //   257: iload 5
    //   259: istore 6
    //   261: iload 5
    //   263: istore 7
    //   265: aload_0
    //   266: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   269: invokevirtual 211	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   272: lload 13
    //   274: invokestatic 216	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   277: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   280: ifeq +427 -> 707
    //   283: iload 5
    //   285: istore 6
    //   287: iload 5
    //   289: istore 7
    //   291: aload_0
    //   292: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   295: invokestatic 317	com/tencent/mobileqq/nearby/redtouch/Util:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   298: istore 8
    //   300: iload 5
    //   302: istore 6
    //   304: iload 5
    //   306: istore 7
    //   308: aload_0
    //   309: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   312: getstatic 225	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   315: invokevirtual 229	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   318: checkcast 231	com/tencent/mobileqq/app/FriendsManager
    //   321: astore_3
    //   322: iload 5
    //   324: istore 6
    //   326: iload 5
    //   328: istore 7
    //   330: aload_3
    //   331: aload_0
    //   332: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   335: invokevirtual 211	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   338: invokevirtual 234	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   341: astore_2
    //   342: iload 5
    //   344: istore 6
    //   346: iload 5
    //   348: istore 7
    //   350: aload_2
    //   351: aload_1
    //   352: getfield 240	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   355: ldc 242
    //   357: invokevirtual 248	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   360: putfield 320	com/tencent/mobileqq/data/Card:medalSwitchDisable	Z
    //   363: iload 5
    //   365: istore 6
    //   367: iload 5
    //   369: istore 7
    //   371: aload_3
    //   372: aload_2
    //   373: invokevirtual 257	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   376: pop
    //   377: iload 5
    //   379: istore 6
    //   381: iload 5
    //   383: istore 7
    //   385: invokestatic 326	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   388: new 20	java/lang/StringBuilder
    //   391: dup
    //   392: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   395: ldc_w 328
    //   398: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: lload 13
    //   403: invokevirtual 331	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   406: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   409: iconst_4
    //   410: invokevirtual 332	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   413: invokeinterface 292 1 0
    //   418: astore_3
    //   419: iload 5
    //   421: istore 6
    //   423: iload 5
    //   425: istore 7
    //   427: aload_3
    //   428: ldc_w 334
    //   431: aload_2
    //   432: getfield 320	com/tencent/mobileqq/data/Card:medalSwitchDisable	Z
    //   435: invokeinterface 338 3 0
    //   440: pop
    //   441: iload 5
    //   443: istore 6
    //   445: iload 5
    //   447: istore 7
    //   449: aload_3
    //   450: invokeinterface 303 1 0
    //   455: pop
    //   456: iload 5
    //   458: istore 6
    //   460: iload 5
    //   462: istore 7
    //   464: aload_0
    //   465: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   468: invokestatic 317	com/tencent/mobileqq/nearby/redtouch/Util:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   471: istore 12
    //   473: iload 8
    //   475: iload 12
    //   477: if_icmpeq +20 -> 497
    //   480: iload 5
    //   482: istore 6
    //   484: iload 5
    //   486: istore 7
    //   488: aload_0
    //   489: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   492: iload 12
    //   494: invokestatic 341	com/tencent/mobileqq/nearby/redtouch/Util:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Z)V
    //   497: iload 9
    //   499: istore 5
    //   501: iload 11
    //   503: istore 6
    //   505: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   508: ifeq +40 -> 548
    //   511: iload 11
    //   513: istore 6
    //   515: ldc 191
    //   517: iconst_2
    //   518: new 20	java/lang/StringBuilder
    //   521: dup
    //   522: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   525: ldc_w 343
    //   528: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   531: aload_2
    //   532: getfield 320	com/tencent/mobileqq/data/Card:medalSwitchDisable	Z
    //   535: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   538: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   541: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   544: iload 9
    //   546: istore 5
    //   548: iload 5
    //   550: istore 6
    //   552: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   555: ifeq +52 -> 607
    //   558: ldc 191
    //   560: iconst_2
    //   561: new 20	java/lang/StringBuilder
    //   564: dup
    //   565: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   568: ldc_w 312
    //   571: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   574: iload 5
    //   576: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   579: ldc_w 345
    //   582: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: aload_1
    //   586: getfield 240	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   589: ldc 242
    //   591: invokevirtual 248	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   594: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   597: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   600: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   603: iload 5
    //   605: istore 6
    //   607: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   610: ifeq +67 -> 677
    //   613: aload_0
    //   614: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   617: getstatic 225	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   620: invokevirtual 229	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   623: checkcast 231	com/tencent/mobileqq/app/FriendsManager
    //   626: aload_0
    //   627: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   630: invokevirtual 211	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   633: invokevirtual 234	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   636: astore_1
    //   637: ldc 191
    //   639: iconst_2
    //   640: new 20	java/lang/StringBuilder
    //   643: dup
    //   644: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   647: ldc_w 347
    //   650: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   653: aload_1
    //   654: getfield 320	com/tencent/mobileqq/data/Card:medalSwitchDisable	Z
    //   657: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   660: ldc_w 305
    //   663: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: iload 6
    //   668: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   671: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   674: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   677: aload_0
    //   678: bipush 76
    //   680: iload 6
    //   682: aconst_null
    //   683: invokevirtual 183	com/tencent/mobileqq/app/CardHandler:notifyUI	(IZLjava/lang/Object;)V
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
    //   722: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   725: ifeq +17 -> 742
    //   728: iload 5
    //   730: istore 6
    //   732: ldc 191
    //   734: iconst_2
    //   735: ldc_w 349
    //   738: aload_2
    //   739: invokestatic 188	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   742: iload 5
    //   744: istore 6
    //   746: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   749: ifeq -142 -> 607
    //   752: ldc 191
    //   754: iconst_2
    //   755: new 20	java/lang/StringBuilder
    //   758: dup
    //   759: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   762: ldc_w 312
    //   765: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   768: iload 5
    //   770: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   773: ldc_w 345
    //   776: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   779: aload_1
    //   780: getfield 240	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   783: ldc 242
    //   785: invokevirtual 248	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   788: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   791: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   794: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   797: iload 5
    //   799: istore 6
    //   801: goto -194 -> 607
    //   804: astore_2
    //   805: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   808: ifeq +48 -> 856
    //   811: ldc 191
    //   813: iconst_2
    //   814: new 20	java/lang/StringBuilder
    //   817: dup
    //   818: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   821: ldc_w 312
    //   824: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   827: iload 7
    //   829: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   832: ldc_w 345
    //   835: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   838: aload_1
    //   839: getfield 240	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   842: ldc 242
    //   844: invokevirtual 248	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   847: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   850: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   853: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   856: aload_2
    //   857: athrow
    //   858: astore_2
    //   859: iload 6
    //   861: istore 7
    //   863: goto -58 -> 805
    //   866: astore_2
    //   867: iload 10
    //   869: istore 5
    //   871: goto -153 -> 718
    //   874: iload 8
    //   876: istore 5
    //   878: goto -330 -> 548
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	881	0	this	CardHandler
    //   0	881	1	paramToServiceMsg	ToServiceMsg
    //   0	881	2	paramFromServiceMsg	FromServiceMsg
    //   0	881	3	paramObject	Object
    //   241	459	4	i	int
    //   21	856	5	bool1	boolean
    //   67	793	6	bool2	boolean
    //   71	791	7	bool3	boolean
    //   58	817	8	bool4	boolean
    //   7	538	9	bool5	boolean
    //   1	867	10	bool6	boolean
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
    //   308	322	713	java/lang/Exception
    //   330	342	713	java/lang/Exception
    //   350	363	713	java/lang/Exception
    //   371	377	713	java/lang/Exception
    //   385	419	713	java/lang/Exception
    //   427	441	713	java/lang/Exception
    //   449	456	713	java/lang/Exception
    //   464	473	713	java/lang/Exception
    //   488	497	713	java/lang/Exception
    //   73	94	804	finally
    //   102	112	804	finally
    //   123	129	804	finally
    //   137	164	804	finally
    //   185	195	804	finally
    //   207	217	804	finally
    //   225	243	804	finally
    //   265	283	804	finally
    //   291	300	804	finally
    //   308	322	804	finally
    //   330	342	804	finally
    //   350	363	804	finally
    //   371	377	804	finally
    //   385	419	804	finally
    //   427	441	804	finally
    //   449	456	804	finally
    //   464	473	804	finally
    //   488	497	804	finally
    //   505	511	858	finally
    //   515	544	858	finally
    //   722	728	858	finally
    //   732	742	858	finally
    //   505	511	866	java/lang/Exception
    //   515	544	866	java/lang/Exception
  }
  
  private void E(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
      paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
      localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
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
                  boolean bool6 = Util.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
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
                  bool5 = Util.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                  bool3 = bool1;
                  if (bool6 != bool5)
                  {
                    bool2 = bool1;
                    bool4 = bool1;
                    Util.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, bool5);
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
      notifyUI(77, bool1, Boolean.valueOf(paramToServiceMsg.medalSwitchDisable));
      return;
      bool1 = false;
      break;
      bool1 = false;
      continue;
      bool3 = false;
    }
  }
  
  private void F(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
            i = ((oidb_0x5eb.UdcUinData)paramToServiceMsg.get(0)).uint32_rsp_connections_switch_id.get();
            ((CTEntryMng)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.CTENTRY_MNG)).b(i);
            if (QLog.isColorLevel()) {
              QLog.d("CardHandler", 2, "handleGetConnectionsSwitch " + i);
            }
          }
        }
      }
      notifyUI(111, true, new Object[] { Integer.valueOf(k), Integer.valueOf(i) });
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("CardHandler", 2, "handleGetConnectionsSwitch failed result:" + k);
    }
    notifyUI(111, false, new Object[] { Integer.valueOf(k), Integer.valueOf(-1) });
  }
  
  private void G(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "AfterSyncMsg doAfterLogin&doOnReconnect::handleSendGlobalRingIdRequestResp success=" + bool1);
      }
      if (!bool1) {}
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool1 = bool2;
        paramFromServiceMsg = paramToServiceMsg.str_error_msg.get();
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.", 2, "handleSendGlobalRingIdRequestResp result=" + bool1 + " error=" + paramFromServiceMsg);
        }
        if ((bool1) && (paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null))
        {
          paramFromServiceMsg = new oidb_0x5eb.RspBody();
          paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          if ((paramFromServiceMsg.rpt_msg_uin_data.has()) && (paramFromServiceMsg.rpt_msg_uin_data.get().size() > 0) && (((oidb_0x5eb.UdcUinData)paramFromServiceMsg.rpt_msg_uin_data.get().get(0)).uint32_req_global_ring_id.has()))
          {
            int i = ((oidb_0x5eb.UdcUinData)paramFromServiceMsg.rpt_msg_uin_data.get().get(0)).uint32_req_global_ring_id.get();
            if (QLog.isColorLevel()) {
              QLog.d("CardHandler", 2, new Object[] { "handleSendGlobalRingIdRequestResp: invoked. ", " ringId: ", Integer.valueOf(i) });
            }
            if (i > 0) {
              MessageNotificationSettingManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b(i);
            }
          }
        }
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        paramToServiceMsg = paramToServiceMsg;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.", 2, "handleSendGlobalRingIdRequestResp ex", paramToServiceMsg);
        return;
      }
      finally {}
      bool1 = false;
      break;
      bool1 = false;
    }
  }
  
  /* Error */
  private void H(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 10
    //   3: aload_2
    //   4: invokevirtual 101	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   7: ifeq +626 -> 633
    //   10: aload_3
    //   11: ifnull +622 -> 633
    //   14: iconst_1
    //   15: istore 6
    //   17: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +30 -> 50
    //   23: ldc 191
    //   25: iconst_2
    //   26: new 20	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   33: ldc_w 442
    //   36: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: iload 6
    //   41: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   44: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: iload 6
    //   52: istore 9
    //   54: iload 6
    //   56: ifeq +567 -> 623
    //   59: iload 6
    //   61: istore 7
    //   63: iload 6
    //   65: istore 8
    //   67: new 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   70: dup
    //   71: invokespecial 120	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   74: aload_3
    //   75: checkcast 122	[B
    //   78: checkcast 122	[B
    //   81: invokevirtual 126	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   84: checkcast 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   87: astore_1
    //   88: iload 6
    //   90: istore 7
    //   92: iload 6
    //   94: istore 8
    //   96: aload_1
    //   97: getfield 130	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   100: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   103: ifne +536 -> 639
    //   106: iconst_1
    //   107: istore 6
    //   109: iload 6
    //   111: istore 7
    //   113: iload 6
    //   115: istore 8
    //   117: aload_1
    //   118: getfield 412	tencent/im/oidb/oidb_sso$OIDBSSOPkg:str_error_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   121: invokevirtual 416	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   124: astore_2
    //   125: iload 6
    //   127: istore 7
    //   129: iload 6
    //   131: istore 8
    //   133: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   136: ifeq +48 -> 184
    //   139: iload 6
    //   141: istore 7
    //   143: iload 6
    //   145: istore 8
    //   147: ldc 191
    //   149: iconst_2
    //   150: new 20	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   157: ldc_w 444
    //   160: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: iload 6
    //   165: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   168: ldc_w 420
    //   171: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: aload_2
    //   175: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   178: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   184: iload 6
    //   186: istore 9
    //   188: iload 6
    //   190: ifeq +433 -> 623
    //   193: iload 6
    //   195: istore 9
    //   197: iload 6
    //   199: istore 7
    //   201: iload 6
    //   203: istore 8
    //   205: aload_1
    //   206: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   209: invokevirtual 146	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   212: ifeq +411 -> 623
    //   215: iload 6
    //   217: istore 9
    //   219: iload 6
    //   221: istore 7
    //   223: iload 6
    //   225: istore 8
    //   227: aload_1
    //   228: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   231: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   234: ifnull +389 -> 623
    //   237: iload 6
    //   239: istore 7
    //   241: iload 6
    //   243: istore 8
    //   245: new 151	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody
    //   248: dup
    //   249: invokespecial 152	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:<init>	()V
    //   252: astore_2
    //   253: iload 6
    //   255: istore 7
    //   257: iload 6
    //   259: istore 8
    //   261: aload_2
    //   262: aload_1
    //   263: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   266: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   269: invokevirtual 158	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   272: invokevirtual 159	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   275: pop
    //   276: iload 6
    //   278: istore 9
    //   280: iload 6
    //   282: istore 7
    //   284: iload 6
    //   286: istore 8
    //   288: aload_2
    //   289: getfield 163	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   292: invokevirtual 358	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   295: ifeq +328 -> 623
    //   298: iload 6
    //   300: istore 9
    //   302: iload 6
    //   304: istore 7
    //   306: iload 6
    //   308: istore 8
    //   310: aload_2
    //   311: getfield 163	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   314: invokevirtual 361	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   317: invokeinterface 364 1 0
    //   322: ifle +301 -> 623
    //   325: iload 6
    //   327: istore 9
    //   329: iload 6
    //   331: istore 7
    //   333: iload 6
    //   335: istore 8
    //   337: aload_2
    //   338: getfield 163	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   341: invokevirtual 361	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   344: iconst_0
    //   345: invokeinterface 367 2 0
    //   350: checkcast 171	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData
    //   353: getfield 447	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_hidden_session_switch	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   356: invokevirtual 424	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   359: ifeq +264 -> 623
    //   362: iload 6
    //   364: istore 7
    //   366: iload 6
    //   368: istore 8
    //   370: aload_2
    //   371: getfield 163	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   374: invokevirtual 361	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   377: iconst_0
    //   378: invokeinterface 367 2 0
    //   383: checkcast 171	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData
    //   386: getfield 447	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_hidden_session_switch	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   389: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   392: istore 4
    //   394: iload 6
    //   396: istore 7
    //   398: iload 6
    //   400: istore 8
    //   402: aload_2
    //   403: getfield 163	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   406: invokevirtual 361	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   409: iconst_0
    //   410: invokeinterface 367 2 0
    //   415: checkcast 171	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData
    //   418: getfield 450	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_hidden_session_video_switch	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   421: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   424: istore 5
    //   426: iload 6
    //   428: istore 7
    //   430: iload 6
    //   432: istore 8
    //   434: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   437: ifeq +49 -> 486
    //   440: iload 6
    //   442: istore 7
    //   444: iload 6
    //   446: istore 8
    //   448: ldc 191
    //   450: iconst_2
    //   451: new 20	java/lang/StringBuilder
    //   454: dup
    //   455: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   458: ldc_w 452
    //   461: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: iload 4
    //   466: invokevirtual 398	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   469: ldc_w 454
    //   472: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   475: iload 5
    //   477: invokevirtual 398	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   480: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   483: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   486: iload 4
    //   488: iflt +62 -> 550
    //   491: iload 6
    //   493: istore 7
    //   495: iload 6
    //   497: istore 8
    //   499: aload_0
    //   500: getfield 77	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   503: invokevirtual 455	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   506: astore_1
    //   507: iload 6
    //   509: istore 7
    //   511: iload 6
    //   513: istore 8
    //   515: aload_0
    //   516: getfield 77	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   519: invokevirtual 458	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   522: invokevirtual 464	mqq/app/MobileQQ:getApplicationContext	()Landroid/content/Context;
    //   525: astore_2
    //   526: iload 4
    //   528: iconst_1
    //   529: if_icmpeq +116 -> 645
    //   532: iconst_1
    //   533: istore 9
    //   535: iload 6
    //   537: istore 7
    //   539: iload 6
    //   541: istore 8
    //   543: aload_1
    //   544: aload_2
    //   545: iload 9
    //   547: invokestatic 469	com/tencent/mobileqq/app/hiddenchat/HiddenChatUtil:a	(Ljava/lang/String;Landroid/content/Context;Z)V
    //   550: iload 6
    //   552: istore 9
    //   554: iload 5
    //   556: iflt +67 -> 623
    //   559: iload 6
    //   561: istore 7
    //   563: iload 6
    //   565: istore 8
    //   567: aload_0
    //   568: getfield 77	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   571: invokevirtual 455	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   574: astore_1
    //   575: iload 6
    //   577: istore 7
    //   579: iload 6
    //   581: istore 8
    //   583: aload_0
    //   584: getfield 77	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   587: invokevirtual 458	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   590: invokevirtual 464	mqq/app/MobileQQ:getApplicationContext	()Landroid/content/Context;
    //   593: astore_2
    //   594: iload 5
    //   596: iconst_1
    //   597: if_icmpeq +54 -> 651
    //   600: iload 10
    //   602: istore 9
    //   604: iload 6
    //   606: istore 7
    //   608: iload 6
    //   610: istore 8
    //   612: aload_1
    //   613: aload_2
    //   614: iload 9
    //   616: invokestatic 471	com/tencent/mobileqq/app/hiddenchat/HiddenChatUtil:b	(Ljava/lang/String;Landroid/content/Context;Z)V
    //   619: iload 6
    //   621: istore 9
    //   623: aload_0
    //   624: bipush 107
    //   626: iload 9
    //   628: aconst_null
    //   629: invokevirtual 183	com/tencent/mobileqq/app/CardHandler:notifyUI	(IZLjava/lang/Object;)V
    //   632: return
    //   633: iconst_0
    //   634: istore 6
    //   636: goto -619 -> 17
    //   639: iconst_0
    //   640: istore 6
    //   642: goto -533 -> 109
    //   645: iconst_0
    //   646: istore 9
    //   648: goto -113 -> 535
    //   651: iconst_0
    //   652: istore 9
    //   654: goto -50 -> 604
    //   657: astore_1
    //   658: iload 7
    //   660: istore 8
    //   662: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   665: ifeq +17 -> 682
    //   668: iload 7
    //   670: istore 8
    //   672: ldc 191
    //   674: iconst_2
    //   675: ldc_w 473
    //   678: aload_1
    //   679: invokestatic 188	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   682: aload_0
    //   683: bipush 107
    //   685: iload 7
    //   687: aconst_null
    //   688: invokevirtual 183	com/tencent/mobileqq/app/CardHandler:notifyUI	(IZLjava/lang/Object;)V
    //   691: return
    //   692: astore_1
    //   693: aload_0
    //   694: bipush 107
    //   696: iload 8
    //   698: aconst_null
    //   699: invokevirtual 183	com/tencent/mobileqq/app/CardHandler:notifyUI	(IZLjava/lang/Object;)V
    //   702: aload_1
    //   703: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	704	0	this	CardHandler
    //   0	704	1	paramToServiceMsg	ToServiceMsg
    //   0	704	2	paramFromServiceMsg	FromServiceMsg
    //   0	704	3	paramObject	Object
    //   392	138	4	i	int
    //   424	174	5	j	int
    //   15	626	6	bool1	boolean
    //   61	625	7	bool2	boolean
    //   65	632	8	bool3	boolean
    //   52	601	9	bool4	boolean
    //   1	600	10	bool5	boolean
    // Exception table:
    //   from	to	target	type
    //   67	88	657	java/lang/Exception
    //   96	106	657	java/lang/Exception
    //   117	125	657	java/lang/Exception
    //   133	139	657	java/lang/Exception
    //   147	184	657	java/lang/Exception
    //   205	215	657	java/lang/Exception
    //   227	237	657	java/lang/Exception
    //   245	253	657	java/lang/Exception
    //   261	276	657	java/lang/Exception
    //   288	298	657	java/lang/Exception
    //   310	325	657	java/lang/Exception
    //   337	362	657	java/lang/Exception
    //   370	394	657	java/lang/Exception
    //   402	426	657	java/lang/Exception
    //   434	440	657	java/lang/Exception
    //   448	486	657	java/lang/Exception
    //   499	507	657	java/lang/Exception
    //   515	526	657	java/lang/Exception
    //   543	550	657	java/lang/Exception
    //   567	575	657	java/lang/Exception
    //   583	594	657	java/lang/Exception
    //   612	619	657	java/lang/Exception
    //   67	88	692	finally
    //   96	106	692	finally
    //   117	125	692	finally
    //   133	139	692	finally
    //   147	184	692	finally
    //   205	215	692	finally
    //   227	237	692	finally
    //   245	253	692	finally
    //   261	276	692	finally
    //   288	298	692	finally
    //   310	325	692	finally
    //   337	362	692	finally
    //   370	394	692	finally
    //   402	426	692	finally
    //   434	440	692	finally
    //   448	486	692	finally
    //   499	507	692	finally
    //   515	526	692	finally
    //   543	550	692	finally
    //   567	575	692	finally
    //   583	594	692	finally
    //   612	619	692	finally
    //   662	668	692	finally
    //   672	682	692	finally
  }
  
  /* Error */
  private void I(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 101	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: ifeq +490 -> 494
    //   7: aload_3
    //   8: ifnull +486 -> 494
    //   11: iconst_1
    //   12: istore 5
    //   14: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   17: ifeq +30 -> 47
    //   20: ldc 191
    //   22: iconst_2
    //   23: new 20	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   30: ldc_w 475
    //   33: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: iload 5
    //   38: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   41: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   47: aload_1
    //   48: getfield 240	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   51: ldc_w 477
    //   54: ldc_w 479
    //   57: invokevirtual 483	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   60: astore_1
    //   61: iload 5
    //   63: istore 8
    //   65: iload 5
    //   67: ifeq +404 -> 471
    //   70: iload 5
    //   72: istore 6
    //   74: iload 5
    //   76: istore 7
    //   78: new 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   81: dup
    //   82: invokespecial 120	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   85: aload_3
    //   86: checkcast 122	[B
    //   89: checkcast 122	[B
    //   92: invokevirtual 126	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   95: checkcast 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   98: astore_2
    //   99: iload 5
    //   101: istore 6
    //   103: iload 5
    //   105: istore 7
    //   107: aload_2
    //   108: getfield 130	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   111: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   114: ifne +386 -> 500
    //   117: iconst_1
    //   118: istore 5
    //   120: iload 5
    //   122: istore 6
    //   124: iload 5
    //   126: istore 7
    //   128: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   131: ifeq +38 -> 169
    //   134: iload 5
    //   136: istore 6
    //   138: iload 5
    //   140: istore 7
    //   142: ldc 191
    //   144: iconst_2
    //   145: new 20	java/lang/StringBuilder
    //   148: dup
    //   149: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   152: ldc_w 485
    //   155: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: iload 5
    //   160: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   163: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   166: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   169: iload 5
    //   171: istore 8
    //   173: iload 5
    //   175: ifeq +296 -> 471
    //   178: iload 5
    //   180: istore 8
    //   182: iload 5
    //   184: istore 6
    //   186: iload 5
    //   188: istore 7
    //   190: aload_2
    //   191: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   194: invokevirtual 146	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   197: ifeq +274 -> 471
    //   200: iload 5
    //   202: istore 8
    //   204: iload 5
    //   206: istore 6
    //   208: iload 5
    //   210: istore 7
    //   212: aload_2
    //   213: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   216: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   219: ifnull +252 -> 471
    //   222: iload 5
    //   224: istore 6
    //   226: iload 5
    //   228: istore 7
    //   230: new 151	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody
    //   233: dup
    //   234: invokespecial 152	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:<init>	()V
    //   237: astore_3
    //   238: iload 5
    //   240: istore 6
    //   242: iload 5
    //   244: istore 7
    //   246: aload_3
    //   247: aload_2
    //   248: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   251: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   254: invokevirtual 158	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   257: invokevirtual 159	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   260: pop
    //   261: iload 5
    //   263: istore 8
    //   265: iload 5
    //   267: istore 6
    //   269: iload 5
    //   271: istore 7
    //   273: aload_3
    //   274: getfield 163	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   277: invokevirtual 358	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   280: ifeq +191 -> 471
    //   283: iload 5
    //   285: istore 8
    //   287: iload 5
    //   289: istore 6
    //   291: iload 5
    //   293: istore 7
    //   295: aload_3
    //   296: getfield 163	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   299: invokevirtual 361	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   302: invokeinterface 364 1 0
    //   307: ifle +164 -> 471
    //   310: iload 5
    //   312: istore 8
    //   314: iload 5
    //   316: istore 6
    //   318: iload 5
    //   320: istore 7
    //   322: aload_3
    //   323: getfield 163	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   326: invokevirtual 361	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   329: iconst_0
    //   330: invokeinterface 367 2 0
    //   335: checkcast 171	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData
    //   338: getfield 488	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_do_not_disturb_mode_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   341: invokevirtual 424	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   344: ifeq +127 -> 471
    //   347: iload 5
    //   349: istore 6
    //   351: iload 5
    //   353: istore 7
    //   355: aload_3
    //   356: getfield 163	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   359: invokevirtual 361	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   362: iconst_0
    //   363: invokeinterface 367 2 0
    //   368: checkcast 171	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData
    //   371: getfield 488	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_do_not_disturb_mode_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   374: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   377: istore 4
    //   379: iload 5
    //   381: istore 6
    //   383: iload 5
    //   385: istore 7
    //   387: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   390: ifeq +38 -> 428
    //   393: iload 5
    //   395: istore 6
    //   397: iload 5
    //   399: istore 7
    //   401: ldc 191
    //   403: iconst_2
    //   404: new 20	java/lang/StringBuilder
    //   407: dup
    //   408: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   411: ldc_w 490
    //   414: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: iload 4
    //   419: invokevirtual 398	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   422: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   425: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   428: iload 5
    //   430: istore 8
    //   432: iload 4
    //   434: iflt +37 -> 471
    //   437: iload 5
    //   439: istore 6
    //   441: iload 5
    //   443: istore 7
    //   445: aload_0
    //   446: getfield 77	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   449: invokevirtual 458	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   452: invokevirtual 464	mqq/app/MobileQQ:getApplicationContext	()Landroid/content/Context;
    //   455: aconst_null
    //   456: ldc_w 492
    //   459: ldc_w 494
    //   462: iload 4
    //   464: invokestatic 500	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:writeValueForInt	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   467: iload 5
    //   469: istore 8
    //   471: aload_0
    //   472: bipush 98
    //   474: iload 8
    //   476: iconst_2
    //   477: anewarray 213	java/lang/String
    //   480: dup
    //   481: iconst_0
    //   482: ldc_w 479
    //   485: aastore
    //   486: dup
    //   487: iconst_1
    //   488: aload_1
    //   489: aastore
    //   490: invokevirtual 183	com/tencent/mobileqq/app/CardHandler:notifyUI	(IZLjava/lang/Object;)V
    //   493: return
    //   494: iconst_0
    //   495: istore 5
    //   497: goto -483 -> 14
    //   500: iconst_0
    //   501: istore 5
    //   503: goto -383 -> 120
    //   506: astore_2
    //   507: iload 6
    //   509: istore 7
    //   511: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   514: ifeq +17 -> 531
    //   517: iload 6
    //   519: istore 7
    //   521: ldc 191
    //   523: iconst_2
    //   524: ldc_w 502
    //   527: aload_2
    //   528: invokestatic 188	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   531: aload_0
    //   532: bipush 98
    //   534: iload 6
    //   536: iconst_2
    //   537: anewarray 213	java/lang/String
    //   540: dup
    //   541: iconst_0
    //   542: ldc_w 479
    //   545: aastore
    //   546: dup
    //   547: iconst_1
    //   548: aload_1
    //   549: aastore
    //   550: invokevirtual 183	com/tencent/mobileqq/app/CardHandler:notifyUI	(IZLjava/lang/Object;)V
    //   553: return
    //   554: astore_2
    //   555: aload_0
    //   556: bipush 98
    //   558: iload 7
    //   560: iconst_2
    //   561: anewarray 213	java/lang/String
    //   564: dup
    //   565: iconst_0
    //   566: ldc_w 479
    //   569: aastore
    //   570: dup
    //   571: iconst_1
    //   572: aload_1
    //   573: aastore
    //   574: invokevirtual 183	com/tencent/mobileqq/app/CardHandler:notifyUI	(IZLjava/lang/Object;)V
    //   577: aload_2
    //   578: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	579	0	this	CardHandler
    //   0	579	1	paramToServiceMsg	ToServiceMsg
    //   0	579	2	paramFromServiceMsg	FromServiceMsg
    //   0	579	3	paramObject	Object
    //   377	86	4	i	int
    //   12	490	5	bool1	boolean
    //   72	463	6	bool2	boolean
    //   76	483	7	bool3	boolean
    //   63	412	8	bool4	boolean
    // Exception table:
    //   from	to	target	type
    //   78	99	506	java/lang/Exception
    //   107	117	506	java/lang/Exception
    //   128	134	506	java/lang/Exception
    //   142	169	506	java/lang/Exception
    //   190	200	506	java/lang/Exception
    //   212	222	506	java/lang/Exception
    //   230	238	506	java/lang/Exception
    //   246	261	506	java/lang/Exception
    //   273	283	506	java/lang/Exception
    //   295	310	506	java/lang/Exception
    //   322	347	506	java/lang/Exception
    //   355	379	506	java/lang/Exception
    //   387	393	506	java/lang/Exception
    //   401	428	506	java/lang/Exception
    //   445	467	506	java/lang/Exception
    //   78	99	554	finally
    //   107	117	554	finally
    //   128	134	554	finally
    //   142	169	554	finally
    //   190	200	554	finally
    //   212	222	554	finally
    //   230	238	554	finally
    //   246	261	554	finally
    //   273	283	554	finally
    //   295	310	554	finally
    //   322	347	554	finally
    //   355	379	554	finally
    //   387	393	554	finally
    //   401	428	554	finally
    //   445	467	554	finally
    //   511	517	554	finally
    //   521	531	554	finally
  }
  
  private void J(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      paramToServiceMsg = paramToServiceMsg.extraData.getString("reqUin", "");
      paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "handleGetSelfAddFriendSetting success=" + bool1 + " reqUin:" + paramToServiceMsg + "  uin:" + paramFromServiceMsg);
      }
      if (!bool1) {}
    }
    for (;;)
    {
      try
      {
        if (TextUtils.equals(paramFromServiceMsg, paramToServiceMsg))
        {
          paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
          if (paramToServiceMsg.uint32_result.get() != 0) {
            break label408;
          }
          bool1 = bool2;
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.", 2, "handleGetSelfAddFriendSetting result=" + bool1);
          }
          if ((bool1) && (paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null))
          {
            paramFromServiceMsg = new oidb_0x5eb.RspBody();
            paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
            if ((paramFromServiceMsg.rpt_msg_uin_data.has()) && (paramFromServiceMsg.rpt_msg_uin_data.get().size() > 0) && (((oidb_0x5eb.UdcUinData)paramFromServiceMsg.rpt_msg_uin_data.get().get(0)).uint32_allow.has()))
            {
              int i = ((oidb_0x5eb.UdcUinData)paramFromServiceMsg.rpt_msg_uin_data.get().get(0)).uint32_allow.get();
              notifyUI(106, bool1, Integer.valueOf(i));
              if (QLog.isColorLevel()) {
                QLog.d("Q.profilecard.", 2, "handleGetSelfAddFriendSetting settingValue=" + i);
              }
              if (i != 101) {
                d(i);
              }
            }
          }
          else
          {
            notifyUI(106, false, Integer.valueOf(a()));
            return;
          }
        }
      }
      catch (Exception paramToServiceMsg)
      {
        notifyUI(106, false, Integer.valueOf(a()));
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.", 2, "handleGetSelfAddFriendSetting ex", paramToServiceMsg);
        }
      }
      return;
      bool1 = false;
      break;
      label408:
      bool1 = false;
    }
  }
  
  private void K(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
      paramFromServiceMsg = (ActivateFriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS);
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
            if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(String.valueOf(l))) {
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
      notifyUI(57, bool1, Boolean.valueOf(bool3));
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
        QLog.d("Q.profilecard.", 2, "handleSetActivateFriendSwitch cur:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + " dwUin:" + l);
      }
      bool1 = false;
      continue;
      label644:
      label651:
      bool1 = bool5;
    }
  }
  
  private void L(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
        break label605;
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
          break label605;
        }
        bool2 = bool1;
        bool3 = bool1;
        bool4 = bool1;
        if (!paramFromServiceMsg.bytes_bodybuffer.has()) {
          break label605;
        }
        bool2 = bool1;
        bool3 = bool1;
        bool4 = bool1;
        if (paramFromServiceMsg.bytes_bodybuffer.get() == null) {
          break label605;
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
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(String.valueOf(l))) {
          continue;
        }
        bool2 = bool1;
        bool3 = bool1;
        paramFromServiceMsg = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        bool2 = bool1;
        bool3 = bool1;
        paramObject = paramFromServiceMsg.b(AppConstants.BABY_Q_UIN);
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
      notifyUI(74, bool3, Boolean.valueOf(paramToServiceMsg.extraData.getBoolean("switch")));
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
      label605:
      bool1 = bool4;
    }
  }
  
  /* Error */
  private void M(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 9
    //   3: aload_2
    //   4: invokevirtual 101	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   7: ifeq +395 -> 402
    //   10: aload_3
    //   11: ifnull +391 -> 402
    //   14: iconst_1
    //   15: istore 5
    //   17: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +30 -> 50
    //   23: ldc 191
    //   25: iconst_2
    //   26: new 20	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   33: ldc_w 570
    //   36: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: iload 5
    //   41: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   44: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: aload_0
    //   51: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   54: invokevirtual 571	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   57: ldc_w 572
    //   60: invokevirtual 575	mqq/app/MobileQQ:getString	(I)Ljava/lang/String;
    //   63: pop
    //   64: aload_0
    //   65: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   68: invokevirtual 211	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   71: pop
    //   72: iload 5
    //   74: istore 8
    //   76: iload 5
    //   78: ifeq +561 -> 639
    //   81: iload 5
    //   83: istore 6
    //   85: iload 5
    //   87: istore 7
    //   89: new 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   92: dup
    //   93: invokespecial 120	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   96: aload_3
    //   97: checkcast 122	[B
    //   100: checkcast 122	[B
    //   103: invokevirtual 126	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   106: checkcast 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   109: astore_2
    //   110: aload_2
    //   111: ifnull +297 -> 408
    //   114: iload 5
    //   116: istore 6
    //   118: iload 5
    //   120: istore 7
    //   122: aload_2
    //   123: getfield 130	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   126: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   129: ifne +279 -> 408
    //   132: iconst_1
    //   133: istore 5
    //   135: iload 5
    //   137: istore 6
    //   139: iload 5
    //   141: istore 7
    //   143: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   146: ifeq +38 -> 184
    //   149: iload 5
    //   151: istore 6
    //   153: iload 5
    //   155: istore 7
    //   157: ldc 191
    //   159: iconst_2
    //   160: new 20	java/lang/StringBuilder
    //   163: dup
    //   164: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   167: ldc_w 577
    //   170: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: iload 5
    //   175: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   178: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   181: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   184: iload 5
    //   186: istore 8
    //   188: iload 5
    //   190: ifeq +449 -> 639
    //   193: iload 5
    //   195: istore 6
    //   197: iload 5
    //   199: istore 7
    //   201: iload 5
    //   203: istore 8
    //   205: aload_2
    //   206: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   209: invokevirtual 146	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   212: ifeq +427 -> 639
    //   215: iload 5
    //   217: istore 6
    //   219: iload 5
    //   221: istore 7
    //   223: iload 5
    //   225: istore 8
    //   227: aload_2
    //   228: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   231: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   234: ifnull +405 -> 639
    //   237: iload 5
    //   239: istore 6
    //   241: iload 5
    //   243: istore 7
    //   245: aload_2
    //   246: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   249: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   252: invokevirtual 158	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   255: invokestatic 201	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   258: invokevirtual 204	java/nio/ByteBuffer:getInt	()I
    //   261: istore 4
    //   263: iload 4
    //   265: i2l
    //   266: lstore 10
    //   268: iload 4
    //   270: ifge +16 -> 286
    //   273: iload 4
    //   275: ldc_w 578
    //   278: iand
    //   279: i2l
    //   280: ldc2_w 579
    //   283: lor
    //   284: lstore 10
    //   286: iload 5
    //   288: istore 6
    //   290: iload 5
    //   292: istore 7
    //   294: aload_0
    //   295: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   298: invokevirtual 211	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   301: lload 10
    //   303: invokestatic 216	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   306: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   309: istore 5
    //   311: iload 5
    //   313: ifeq +101 -> 414
    //   316: aload_1
    //   317: getfield 240	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   320: ldc_w 582
    //   323: invokevirtual 586	android/os/Bundle:getShort	(Ljava/lang/String;)S
    //   326: istore 4
    //   328: aload_0
    //   329: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   332: getstatic 591	com/tencent/mobileqq/app/BusinessHandlerFactory:DEVICEPROXYMGR_HANDLER	Ljava/lang/String;
    //   335: invokevirtual 595	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(Ljava/lang/String;)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   338: checkcast 597	com/tencent/device/devicemgr/SmartDeviceProxyMgr
    //   341: iload 4
    //   343: invokevirtual 598	com/tencent/device/devicemgr/SmartDeviceProxyMgr:b	(I)V
    //   346: iconst_1
    //   347: istore 5
    //   349: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   352: ifeq +49 -> 401
    //   355: ldc 191
    //   357: iconst_2
    //   358: new 20	java/lang/StringBuilder
    //   361: dup
    //   362: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   365: ldc_w 577
    //   368: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   371: iload 5
    //   373: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   376: ldc_w 259
    //   379: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: aload_1
    //   383: getfield 240	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   386: ldc_w 582
    //   389: invokevirtual 586	android/os/Bundle:getShort	(Ljava/lang/String;)S
    //   392: invokevirtual 398	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   395: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   398: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   401: return
    //   402: iconst_0
    //   403: istore 5
    //   405: goto -388 -> 17
    //   408: iconst_0
    //   409: istore 5
    //   411: goto -276 -> 135
    //   414: iload 9
    //   416: istore 5
    //   418: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   421: ifeq -72 -> 349
    //   424: ldc 191
    //   426: iconst_2
    //   427: new 20	java/lang/StringBuilder
    //   430: dup
    //   431: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   434: ldc_w 600
    //   437: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: lload 10
    //   442: invokevirtual 331	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   445: ldc_w 602
    //   448: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: aload_0
    //   452: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   455: invokevirtual 211	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   458: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   461: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   464: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   467: iload 9
    //   469: istore 5
    //   471: goto -122 -> 349
    //   474: astore_2
    //   475: iconst_0
    //   476: istore 5
    //   478: iload 5
    //   480: istore 6
    //   482: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   485: ifeq +17 -> 502
    //   488: iload 5
    //   490: istore 6
    //   492: ldc 191
    //   494: iconst_2
    //   495: ldc_w 604
    //   498: aload_2
    //   499: invokestatic 188	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   502: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   505: ifeq -104 -> 401
    //   508: ldc 191
    //   510: iconst_2
    //   511: new 20	java/lang/StringBuilder
    //   514: dup
    //   515: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   518: ldc_w 577
    //   521: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   524: iload 5
    //   526: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   529: ldc_w 259
    //   532: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   535: aload_1
    //   536: getfield 240	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   539: ldc_w 582
    //   542: invokevirtual 586	android/os/Bundle:getShort	(Ljava/lang/String;)S
    //   545: invokevirtual 398	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   548: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   551: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   554: return
    //   555: astore_2
    //   556: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   559: ifeq +49 -> 608
    //   562: ldc 191
    //   564: iconst_2
    //   565: new 20	java/lang/StringBuilder
    //   568: dup
    //   569: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   572: ldc_w 577
    //   575: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: iload 6
    //   580: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   583: ldc_w 259
    //   586: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: aload_1
    //   590: getfield 240	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   593: ldc_w 582
    //   596: invokevirtual 586	android/os/Bundle:getShort	(Ljava/lang/String;)S
    //   599: invokevirtual 398	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   602: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   605: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   608: aload_2
    //   609: athrow
    //   610: astore_2
    //   611: iconst_1
    //   612: istore 6
    //   614: goto -58 -> 556
    //   617: astore_2
    //   618: iconst_0
    //   619: istore 6
    //   621: goto -65 -> 556
    //   624: astore_2
    //   625: iload 7
    //   627: istore 5
    //   629: goto -151 -> 478
    //   632: astore_2
    //   633: iconst_1
    //   634: istore 5
    //   636: goto -158 -> 478
    //   639: iload 8
    //   641: istore 5
    //   643: goto -294 -> 349
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	646	0	this	CardHandler
    //   0	646	1	paramToServiceMsg	ToServiceMsg
    //   0	646	2	paramFromServiceMsg	FromServiceMsg
    //   0	646	3	paramObject	Object
    //   261	81	4	i	int
    //   15	627	5	bool1	boolean
    //   83	537	6	bool2	boolean
    //   87	539	7	bool3	boolean
    //   74	566	8	bool4	boolean
    //   1	467	9	bool5	boolean
    //   266	175	10	l	long
    // Exception table:
    //   from	to	target	type
    //   418	467	474	java/lang/Exception
    //   89	110	555	finally
    //   122	132	555	finally
    //   143	149	555	finally
    //   157	184	555	finally
    //   205	215	555	finally
    //   227	237	555	finally
    //   245	263	555	finally
    //   294	311	555	finally
    //   482	488	555	finally
    //   492	502	555	finally
    //   316	346	610	finally
    //   418	467	617	finally
    //   89	110	624	java/lang/Exception
    //   122	132	624	java/lang/Exception
    //   143	149	624	java/lang/Exception
    //   157	184	624	java/lang/Exception
    //   205	215	624	java/lang/Exception
    //   227	237	624	java/lang/Exception
    //   245	263	624	java/lang/Exception
    //   294	311	624	java/lang/Exception
    //   316	346	632	java/lang/Exception
  }
  
  /* Error */
  private void N(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 8
    //   3: aload_2
    //   4: invokevirtual 101	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   7: ifeq +367 -> 374
    //   10: aload_3
    //   11: ifnull +363 -> 374
    //   14: iconst_1
    //   15: istore 5
    //   17: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +30 -> 50
    //   23: ldc 191
    //   25: iconst_2
    //   26: new 20	java/lang/StringBuilder
    //   29: dup
    //   30: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   33: ldc_w 607
    //   36: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: iload 5
    //   41: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   44: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   50: aload_0
    //   51: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   54: invokevirtual 571	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   57: ldc_w 572
    //   60: invokevirtual 575	mqq/app/MobileQQ:getString	(I)Ljava/lang/String;
    //   63: pop
    //   64: aload_0
    //   65: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   68: invokevirtual 211	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   71: pop
    //   72: iload 5
    //   74: ifeq +457 -> 531
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
    //   107: ifnull +273 -> 380
    //   110: iload 5
    //   112: istore 6
    //   114: iload 5
    //   116: istore 7
    //   118: aload_2
    //   119: getfield 130	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   122: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   125: ifne +255 -> 380
    //   128: iconst_1
    //   129: istore 5
    //   131: iload 5
    //   133: istore 6
    //   135: iload 5
    //   137: istore 7
    //   139: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   142: ifeq +38 -> 180
    //   145: iload 5
    //   147: istore 6
    //   149: iload 5
    //   151: istore 7
    //   153: ldc 191
    //   155: iconst_2
    //   156: new 20	java/lang/StringBuilder
    //   159: dup
    //   160: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   163: ldc_w 609
    //   166: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: iload 5
    //   171: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   174: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   180: iload 5
    //   182: ifeq +417 -> 599
    //   185: iload 5
    //   187: istore 6
    //   189: iload 5
    //   191: istore 7
    //   193: aload_2
    //   194: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   197: invokevirtual 146	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   200: ifeq +399 -> 599
    //   203: iload 5
    //   205: istore 6
    //   207: iload 5
    //   209: istore 7
    //   211: aload_2
    //   212: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   215: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   218: ifnull +381 -> 599
    //   221: iload 5
    //   223: istore 6
    //   225: iload 5
    //   227: istore 7
    //   229: aload_2
    //   230: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   233: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   236: invokevirtual 158	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   239: invokestatic 201	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   242: invokevirtual 204	java/nio/ByteBuffer:getInt	()I
    //   245: istore 4
    //   247: iload 4
    //   249: i2l
    //   250: lstore 10
    //   252: iload 4
    //   254: ifge +16 -> 270
    //   257: iload 4
    //   259: ldc_w 578
    //   262: iand
    //   263: i2l
    //   264: ldc2_w 579
    //   267: lor
    //   268: lstore 10
    //   270: iload 5
    //   272: istore 6
    //   274: iload 5
    //   276: istore 7
    //   278: aload_1
    //   279: getfield 240	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   282: ldc 242
    //   284: invokevirtual 248	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   287: istore 9
    //   289: iload 5
    //   291: istore 6
    //   293: iload 5
    //   295: istore 7
    //   297: aload_0
    //   298: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   301: invokevirtual 211	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   304: lload 10
    //   306: invokestatic 216	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   309: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   312: istore 5
    //   314: iload 5
    //   316: ifeq +70 -> 386
    //   319: iconst_1
    //   320: istore 5
    //   322: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   325: ifeq +48 -> 373
    //   328: ldc 191
    //   330: iconst_2
    //   331: new 20	java/lang/StringBuilder
    //   334: dup
    //   335: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   338: ldc_w 609
    //   341: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   344: iload 5
    //   346: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   349: ldc_w 259
    //   352: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: aload_1
    //   356: getfield 240	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   359: ldc 242
    //   361: invokevirtual 248	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   364: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   367: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   370: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   373: return
    //   374: iconst_0
    //   375: istore 5
    //   377: goto -360 -> 17
    //   380: iconst_0
    //   381: istore 5
    //   383: goto -252 -> 131
    //   386: iload 9
    //   388: ifne +3 -> 391
    //   391: iload 8
    //   393: istore 5
    //   395: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   398: ifeq -76 -> 322
    //   401: ldc 191
    //   403: iconst_2
    //   404: new 20	java/lang/StringBuilder
    //   407: dup
    //   408: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   411: ldc_w 611
    //   414: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: lload 10
    //   419: invokevirtual 331	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   422: ldc_w 602
    //   425: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: aload_0
    //   429: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   432: invokevirtual 211	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   435: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   441: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   444: iload 8
    //   446: istore 5
    //   448: goto -126 -> 322
    //   451: astore_2
    //   452: iconst_0
    //   453: istore 7
    //   455: iload 7
    //   457: istore 6
    //   459: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   462: ifeq +17 -> 479
    //   465: iload 7
    //   467: istore 6
    //   469: ldc 191
    //   471: iconst_2
    //   472: ldc_w 613
    //   475: aload_2
    //   476: invokestatic 188	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   479: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   482: ifeq -109 -> 373
    //   485: ldc 191
    //   487: iconst_2
    //   488: new 20	java/lang/StringBuilder
    //   491: dup
    //   492: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   495: ldc_w 609
    //   498: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: iload 7
    //   503: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   506: ldc_w 259
    //   509: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   512: aload_1
    //   513: getfield 240	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   516: ldc 242
    //   518: invokevirtual 248	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   521: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   524: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   527: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   530: return
    //   531: goto -209 -> 322
    //   534: astore_2
    //   535: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   538: ifeq +48 -> 586
    //   541: ldc 191
    //   543: iconst_2
    //   544: new 20	java/lang/StringBuilder
    //   547: dup
    //   548: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   551: ldc_w 609
    //   554: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: iload 6
    //   559: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   562: ldc_w 259
    //   565: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   568: aload_1
    //   569: getfield 240	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   572: ldc 242
    //   574: invokevirtual 248	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   577: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   580: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   583: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   586: aload_2
    //   587: athrow
    //   588: astore_2
    //   589: iconst_0
    //   590: istore 6
    //   592: goto -57 -> 535
    //   595: astore_2
    //   596: goto -141 -> 455
    //   599: goto -277 -> 322
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	602	0	this	CardHandler
    //   0	602	1	paramToServiceMsg	ToServiceMsg
    //   0	602	2	paramFromServiceMsg	FromServiceMsg
    //   0	602	3	paramObject	Object
    //   245	18	4	i	int
    //   15	432	5	bool1	boolean
    //   79	512	6	bool2	boolean
    //   83	419	7	bool3	boolean
    //   1	444	8	bool4	boolean
    //   287	100	9	bool5	boolean
    //   250	168	10	l	long
    // Exception table:
    //   from	to	target	type
    //   395	444	451	java/lang/Exception
    //   85	106	534	finally
    //   118	128	534	finally
    //   139	145	534	finally
    //   153	180	534	finally
    //   193	203	534	finally
    //   211	221	534	finally
    //   229	247	534	finally
    //   278	289	534	finally
    //   297	314	534	finally
    //   459	465	534	finally
    //   469	479	534	finally
    //   395	444	588	finally
    //   85	106	595	java/lang/Exception
    //   118	128	595	java/lang/Exception
    //   139	145	595	java/lang/Exception
    //   153	180	595	java/lang/Exception
    //   193	203	595	java/lang/Exception
    //   211	221	595	java/lang/Exception
    //   229	247	595	java/lang/Exception
    //   278	289	595	java/lang/Exception
    //   297	314	595	java/lang/Exception
  }
  
  private void O(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = paramToServiceMsg.extraData.getString("from");
    if (QLog.isDevelopLevel()) {
      QLog.i("MedalWallMng", 4, String.format(Locale.getDefault(), "handleGetMedalWallInfo from: %s", new Object[] { paramToServiceMsg }));
    }
    if ("getSelfNewObtainedMedalWall".equals(paramToServiceMsg)) {
      a(paramFromServiceMsg, paramObject);
    }
  }
  
  private void P(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
      int i = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject2);
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
        paramToServiceMsg = ((MedalWallMng)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MEDAL_WALL_MNG)).a(paramFromServiceMsg, false);
        if (i != 0) {
          break label433;
        }
      }
      label433:
      for (boolean bool = true;; bool = false)
      {
        notifyUI(51, bool, paramToServiceMsg);
        return;
        paramToServiceMsg = paramToServiceMsg.toString();
        break;
      }
    }
  }
  
  private void Q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = 300;
    boolean bool3 = false;
    boolean bool2 = false;
    oidb_0xc33.RspBody localRspBody = new oidb_0xc33.RspBody();
    int k = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    boolean bool1;
    int j;
    if (k == 0) {
      if (localRspBody.uint32_result.get() == 1)
      {
        bool1 = true;
        j = localRspBody.uint32_next_gap.get();
        if (localRspBody.uint32_new_user.get() > 0) {
          bool2 = true;
        }
        if (j > 0) {
          break label210;
        }
        label78:
        if ((paramToServiceMsg != null) && (TextUtils.equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), paramToServiceMsg.getUin()))) {
          ((CTEntryMng)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CTENTRY_MNG)).a(bool1, i, bool2);
        }
      }
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("CardHandler", 4, "handleGetBindPhoneSwitchInfo needShow:" + bool1 + " net_gap:" + i + " isNewUser:" + bool2 + " uin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin() + "  result:" + k);
      }
      return;
      bool1 = false;
      break;
      label210:
      i = j;
      break label78;
      i = 300;
      bool1 = false;
      bool2 = bool3;
    }
  }
  
  private void R(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new oidb_cmd0xcd5.RspBody();
    int m = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
    paramFromServiceMsg = new ArrayList();
    bool2 = false;
    i = 0;
    bool1 = true;
    if (m == 0)
    {
      for (;;)
      {
        try
        {
          paramToServiceMsg = (oidb_cmd0xcd5.GetDataRsp)paramToServiceMsg.getdata_rsp.get();
          if ((paramToServiceMsg == null) || (!paramToServiceMsg.pb_data.has())) {
            continue;
          }
          paramToServiceMsg = paramToServiceMsg.pb_data.get().toByteArray();
          paramObject = new wording_storage.WordingCfg();
          paramObject.mergeFrom(paramToServiceMsg);
          if (paramObject.select_id.has()) {
            i = paramObject.select_id.get();
          }
        }
        catch (Exception paramToServiceMsg)
        {
          int k;
          bool1 = true;
          i = 0;
          paramToServiceMsg.printStackTrace();
          QLog.e("CardHandler", 1, "handleGetAutoReplyList exception: " + paramToServiceMsg.getMessage());
          bool2 = false;
          continue;
          int j = 2147483647;
          continue;
          bool1 = true;
          i = 0;
          bool2 = false;
          continue;
        }
        try
        {
          j = paramObject.auto_reply_flag.get();
          if (j == 0) {
            bool1 = false;
          }
        }
        catch (Exception paramToServiceMsg)
        {
          bool1 = true;
          continue;
        }
        try
        {
          paramToServiceMsg = paramObject.wording_list.get();
          j = 0;
          if (paramToServiceMsg == null) {
            continue;
          }
          paramToServiceMsg = paramToServiceMsg.iterator();
          if (!paramToServiceMsg.hasNext()) {
            continue;
          }
          paramObject = ((im_msg_body.RichText)paramToServiceMsg.next()).elems.get();
          if ((paramObject == null) || (paramObject.size() <= 0)) {
            continue;
          }
          paramObject = new MessagePBElemDecoder().a(paramObject);
          if (TextUtils.isEmpty(paramObject)) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("CardHandler", 2, "handleGetAutoReplyList, parse richText: " + paramObject + ", id: " + j);
          }
          k = j + 1;
          paramFromServiceMsg.add(new AutoReplyText(paramObject, j));
          j = k;
          continue;
        }
        catch (Exception paramToServiceMsg)
        {
          continue;
          continue;
        }
        i = 0;
        continue;
        bool1 = true;
      }
      bool2 = true;
    }
    paramFromServiceMsg.add(new AutoReplyText(HardCodeUtil.a(2131701524), 2147483647));
    k = paramFromServiceMsg.size();
    if ((bool1) && (k > 1))
    {
      if (i >= 0)
      {
        j = i;
        if (i < k) {}
      }
      else
      {
        QLog.d("CardHandler", 1, "handleGetAutoReplyList, error select id: " + i);
        j = 0;
      }
      if (bool2) {
        ((AutoReplyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.AUTO_REPLY_MANAGER)).a(paramFromServiceMsg, j);
      }
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, String.format("handleGetAutoReplyList result: %s, isSuccess: %s, enableAutoReply: %s, replyList size: %s, selectId: %s", new Object[] { Integer.valueOf(m), Boolean.valueOf(bool2), Boolean.valueOf(bool1), Integer.valueOf(k), Integer.valueOf(j) }));
      }
      notifyUI(97, bool2, new Object[] { paramFromServiceMsg, Integer.valueOf(j) });
      return;
    }
  }
  
  private void S(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    oidb_cmd0xcd5.RspBody localRspBody = new oidb_cmd0xcd5.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, localRspBody);
    boolean bool2 = false;
    boolean bool3 = paramToServiceMsg.extraData.getBoolean("needNotify");
    boolean bool1 = bool2;
    if (i == 0)
    {
      bool1 = bool2;
      if (localRspBody.setdata_rsp.has())
      {
        paramFromServiceMsg = paramToServiceMsg.extraData.getParcelableArrayList("replyMsgList");
        int j = paramToServiceMsg.extraData.getInt("selectId");
        ((AutoReplyManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.AUTO_REPLY_MANAGER)).a(paramFromServiceMsg, j);
        bool1 = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "handleSetAutoReplyList, result = " + i);
    }
    if (bool3) {
      notifyUI(99, bool1, null);
    }
  }
  
  private void T(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      bool1 = true;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "handleSetStrangerInviteToGroupSwitch success=" + bool1);
      }
      if (bool1) {
        try
        {
          paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
          label90:
          int i;
          if (paramFromServiceMsg.uint32_result.get() == 0)
          {
            bool1 = bool2;
            if (QLog.isColorLevel()) {
              QLog.d("Q.profilecard.", 2, "handleSetStrangerInviteToGroupSwitch result=" + bool1);
            }
            if ((!bool1) || (!paramFromServiceMsg.bytes_bodybuffer.has()) || (paramFromServiceMsg.bytes_bodybuffer.get() == null)) {
              break label423;
            }
            i = ByteBuffer.wrap(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray()).getInt();
            if (i >= 0) {
              break label398;
            }
          }
          label398:
          for (long l = i + 4294967296L;; l = i)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.profilecard.", 2, "handleSetStrangerInviteToGroupSwitch uin=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + "  lUin:" + String.valueOf(l));
            }
            if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(String.valueOf(l))) {
              break label423;
            }
            paramFromServiceMsg = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
            paramObject = paramFromServiceMsg.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
            bool1 = paramObject.strangerInviteMeGroupOpen;
            paramObject.strangerInviteMeGroupOpen = paramToServiceMsg.extraData.getBoolean("switch");
            paramFromServiceMsg.a(paramObject);
            bool2 = paramObject.strangerInviteMeGroupOpen;
            if (bool1 != bool2) {
              notifyUI(95, true, new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1) });
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.profilecard.", 2, "handleSetStrangerInviteToGroupSwitch newConfigOn=" + bool2 + "  oldConfigOn:" + bool1);
            }
            return;
            bool1 = false;
            break;
            bool1 = false;
            break label90;
          }
          notifyUI(95, false, null);
        }
        catch (Exception paramToServiceMsg)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.", 2, "handleSetStrangerInviteToGroupSwitch ex", paramToServiceMsg);
          }
        }
      }
    }
    label423:
  }
  
  /* Error */
  private void U(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 12
    //   3: iconst_1
    //   4: istore 8
    //   6: iconst_1
    //   7: istore 9
    //   9: iconst_1
    //   10: istore 10
    //   12: iconst_1
    //   13: istore 11
    //   15: aload_2
    //   16: invokevirtual 101	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   19: ifeq +110 -> 129
    //   22: aload_3
    //   23: ifnull +106 -> 129
    //   26: iconst_1
    //   27: istore 7
    //   29: ldc_w 884
    //   32: iconst_2
    //   33: new 20	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   40: ldc_w 886
    //   43: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: iload 7
    //   48: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   51: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: iconst_m1
    //   58: istore 4
    //   60: iload 7
    //   62: ifne +79 -> 141
    //   65: iload 4
    //   67: istore 5
    //   69: ldc_w 884
    //   72: iconst_2
    //   73: new 20	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   80: ldc_w 888
    //   83: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: aload_2
    //   87: invokevirtual 891	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   90: invokevirtual 398	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   93: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   99: aload_1
    //   100: getfield 240	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   103: ldc_w 893
    //   106: invokevirtual 248	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   109: ifne +26 -> 135
    //   112: iload 11
    //   114: istore 7
    //   116: aload_0
    //   117: bipush 105
    //   119: iconst_0
    //   120: iload 7
    //   122: invokestatic 179	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   125: invokevirtual 183	com/tencent/mobileqq/app/CardHandler:notifyUI	(IZLjava/lang/Object;)V
    //   128: return
    //   129: iconst_0
    //   130: istore 7
    //   132: goto -103 -> 29
    //   135: iconst_0
    //   136: istore 7
    //   138: goto -22 -> 116
    //   141: iload 4
    //   143: istore 5
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
    //   181: ifne +100 -> 281
    //   184: iconst_1
    //   185: istore 5
    //   187: iload 5
    //   189: ifne +104 -> 293
    //   192: iload 4
    //   194: istore 5
    //   196: iload 4
    //   198: istore 6
    //   200: aload_2
    //   201: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   204: invokevirtual 146	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   207: ifeq +86 -> 293
    //   210: iload 4
    //   212: istore 5
    //   214: iload 4
    //   216: istore 6
    //   218: ldc_w 884
    //   221: iconst_2
    //   222: new 20	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   229: ldc_w 895
    //   232: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: aload_2
    //   236: getfield 130	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   239: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   242: invokevirtual 398	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   245: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: invokestatic 843	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   251: aload_1
    //   252: getfield 240	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   255: ldc_w 893
    //   258: invokevirtual 248	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   261: ifne +26 -> 287
    //   264: iload 12
    //   266: istore 7
    //   268: aload_0
    //   269: bipush 105
    //   271: iconst_0
    //   272: iload 7
    //   274: invokestatic 179	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   277: invokevirtual 183	com/tencent/mobileqq/app/CardHandler:notifyUI	(IZLjava/lang/Object;)V
    //   280: return
    //   281: iconst_0
    //   282: istore 5
    //   284: goto -97 -> 187
    //   287: iconst_0
    //   288: istore 7
    //   290: goto -22 -> 268
    //   293: iload 4
    //   295: istore 5
    //   297: iload 4
    //   299: istore 6
    //   301: new 897	tencent/im/oidb/cmd0xd8a$RspBody
    //   304: dup
    //   305: invokespecial 898	tencent/im/oidb/cmd0xd8a$RspBody:<init>	()V
    //   308: astore_3
    //   309: iload 4
    //   311: istore 5
    //   313: iload 4
    //   315: istore 6
    //   317: aload_3
    //   318: aload_2
    //   319: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   322: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   325: invokevirtual 158	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   328: invokevirtual 899	tencent/im/oidb/cmd0xd8a$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   331: pop
    //   332: iload 4
    //   334: istore 5
    //   336: iload 4
    //   338: istore 6
    //   340: aload_3
    //   341: getfield 902	tencent/im/oidb/cmd0xd8a$RspBody:uint32_retcode	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   344: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   347: istore 4
    //   349: iload 4
    //   351: istore 5
    //   353: iload 4
    //   355: istore 6
    //   357: aload_3
    //   358: getfield 905	tencent/im/oidb/cmd0xd8a$RspBody:str_res	Lcom/tencent/mobileqq/pb/PBStringField;
    //   361: invokevirtual 416	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   364: astore_2
    //   365: iload 4
    //   367: istore 5
    //   369: iload 4
    //   371: istore 6
    //   373: ldc_w 884
    //   376: iconst_1
    //   377: new 20	java/lang/StringBuilder
    //   380: dup
    //   381: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   384: ldc_w 907
    //   387: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: iload 4
    //   392: invokevirtual 398	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   395: ldc_w 909
    //   398: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: aload_2
    //   402: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   408: invokestatic 843	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   411: aload_1
    //   412: getfield 240	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   415: ldc_w 893
    //   418: invokevirtual 248	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   421: istore 7
    //   423: iload 4
    //   425: ifne +12 -> 437
    //   428: aload_0
    //   429: bipush 105
    //   431: iconst_1
    //   432: aconst_null
    //   433: invokevirtual 183	com/tencent/mobileqq/app/CardHandler:notifyUI	(IZLjava/lang/Object;)V
    //   436: return
    //   437: iload 7
    //   439: ifne +20 -> 459
    //   442: iload 8
    //   444: istore 7
    //   446: aload_0
    //   447: bipush 105
    //   449: iconst_0
    //   450: iload 7
    //   452: invokestatic 179	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   455: invokevirtual 183	com/tencent/mobileqq/app/CardHandler:notifyUI	(IZLjava/lang/Object;)V
    //   458: return
    //   459: iconst_0
    //   460: istore 7
    //   462: goto -16 -> 446
    //   465: astore_2
    //   466: iconst_0
    //   467: istore 5
    //   469: iload 5
    //   471: ifeq +60 -> 531
    //   474: iload 4
    //   476: istore 5
    //   478: ldc_w 884
    //   481: iconst_1
    //   482: new 20	java/lang/StringBuilder
    //   485: dup
    //   486: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   489: ldc_w 911
    //   492: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: aload_2
    //   496: invokevirtual 914	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   499: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   502: invokestatic 843	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   505: aload_1
    //   506: getfield 240	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   509: ldc_w 893
    //   512: invokevirtual 248	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   515: istore 7
    //   517: iload 4
    //   519: ifne +74 -> 593
    //   522: aload_0
    //   523: bipush 105
    //   525: iconst_1
    //   526: aconst_null
    //   527: invokevirtual 183	com/tencent/mobileqq/app/CardHandler:notifyUI	(IZLjava/lang/Object;)V
    //   530: return
    //   531: iload 4
    //   533: istore 5
    //   535: ldc_w 884
    //   538: iconst_1
    //   539: new 20	java/lang/StringBuilder
    //   542: dup
    //   543: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   546: ldc_w 916
    //   549: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: aload_2
    //   553: invokevirtual 914	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   556: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   559: invokestatic 843	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   562: goto -57 -> 505
    //   565: astore_2
    //   566: aload_1
    //   567: getfield 240	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   570: ldc_w 893
    //   573: invokevirtual 248	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   576: istore 7
    //   578: iload 5
    //   580: ifne +41 -> 621
    //   583: aload_0
    //   584: bipush 105
    //   586: iconst_1
    //   587: aconst_null
    //   588: invokevirtual 183	com/tencent/mobileqq/app/CardHandler:notifyUI	(IZLjava/lang/Object;)V
    //   591: aload_2
    //   592: athrow
    //   593: iload 7
    //   595: ifne +20 -> 615
    //   598: iload 9
    //   600: istore 7
    //   602: aload_0
    //   603: bipush 105
    //   605: iconst_0
    //   606: iload 7
    //   608: invokestatic 179	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   611: invokevirtual 183	com/tencent/mobileqq/app/CardHandler:notifyUI	(IZLjava/lang/Object;)V
    //   614: return
    //   615: iconst_0
    //   616: istore 7
    //   618: goto -16 -> 602
    //   621: iload 7
    //   623: ifne +22 -> 645
    //   626: iload 10
    //   628: istore 7
    //   630: aload_0
    //   631: bipush 105
    //   633: iconst_0
    //   634: iload 7
    //   636: invokestatic 179	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   639: invokevirtual 183	com/tencent/mobileqq/app/CardHandler:notifyUI	(IZLjava/lang/Object;)V
    //   642: goto -51 -> 591
    //   645: iconst_0
    //   646: istore 7
    //   648: goto -18 -> 630
    //   651: astore_2
    //   652: iconst_1
    //   653: istore 5
    //   655: iload 6
    //   657: istore 4
    //   659: goto -190 -> 469
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	662	0	this	CardHandler
    //   0	662	1	paramToServiceMsg	ToServiceMsg
    //   0	662	2	paramFromServiceMsg	FromServiceMsg
    //   0	662	3	paramObject	Object
    //   58	600	4	i	int
    //   67	587	5	j	int
    //   172	484	6	k	int
    //   27	620	7	bool1	boolean
    //   4	439	8	bool2	boolean
    //   7	592	9	bool3	boolean
    //   10	617	10	bool4	boolean
    //   13	100	11	bool5	boolean
    //   1	264	12	bool6	boolean
    // Exception table:
    //   from	to	target	type
    //   69	99	465	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   145	166	465	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   69	99	565	finally
    //   145	166	565	finally
    //   174	184	565	finally
    //   200	210	565	finally
    //   218	251	565	finally
    //   301	309	565	finally
    //   317	332	565	finally
    //   340	349	565	finally
    //   357	365	565	finally
    //   373	411	565	finally
    //   478	505	565	finally
    //   535	562	565	finally
    //   174	184	651	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   200	210	651	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   218	251	651	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   301	309	651	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   317	332	651	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   340	349	651	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   357	365	651	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   373	411	651	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  /* Error */
  private void V(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 9
    //   3: iconst_0
    //   4: istore 10
    //   6: aload_2
    //   7: invokevirtual 101	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   10: ifeq +384 -> 394
    //   13: aload_3
    //   14: ifnull +380 -> 394
    //   17: iconst_1
    //   18: istore 4
    //   20: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   23: ifeq +30 -> 53
    //   26: ldc 108
    //   28: iconst_2
    //   29: new 20	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   36: ldc_w 919
    //   39: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: iload 4
    //   44: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   47: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   53: iload 4
    //   55: istore 8
    //   57: iload 10
    //   59: istore 6
    //   61: iload 4
    //   63: ifeq +266 -> 329
    //   66: iload 4
    //   68: istore 7
    //   70: iload 4
    //   72: istore 5
    //   74: new 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   77: dup
    //   78: invokespecial 120	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   81: aload_3
    //   82: checkcast 122	[B
    //   85: checkcast 122	[B
    //   88: invokevirtual 126	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   91: checkcast 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   94: astore_2
    //   95: iload 4
    //   97: istore 7
    //   99: iload 4
    //   101: istore 5
    //   103: aload_2
    //   104: getfield 130	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   107: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   110: ifne +290 -> 400
    //   113: iconst_1
    //   114: istore 4
    //   116: iload 4
    //   118: istore 7
    //   120: iload 4
    //   122: istore 5
    //   124: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   127: ifeq +38 -> 165
    //   130: iload 4
    //   132: istore 7
    //   134: iload 4
    //   136: istore 5
    //   138: ldc 108
    //   140: iconst_2
    //   141: new 20	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   148: ldc_w 921
    //   151: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: iload 4
    //   156: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   159: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   165: iload 4
    //   167: istore 8
    //   169: iload 10
    //   171: istore 6
    //   173: iload 4
    //   175: ifeq +154 -> 329
    //   178: iload 4
    //   180: istore 8
    //   182: iload 10
    //   184: istore 6
    //   186: iload 4
    //   188: istore 7
    //   190: iload 4
    //   192: istore 5
    //   194: aload_2
    //   195: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   198: invokevirtual 146	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   201: ifeq +128 -> 329
    //   204: iload 4
    //   206: istore 8
    //   208: iload 10
    //   210: istore 6
    //   212: iload 4
    //   214: istore 7
    //   216: iload 4
    //   218: istore 5
    //   220: aload_2
    //   221: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   224: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   227: ifnull +102 -> 329
    //   230: iload 4
    //   232: istore 7
    //   234: iload 4
    //   236: istore 5
    //   238: aload_2
    //   239: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   242: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   245: invokevirtual 158	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   248: invokestatic 201	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   251: invokevirtual 204	java/nio/ByteBuffer:getInt	()I
    //   254: invokestatic 545	com/tencent/mobileqq/util/Utils:a	(I)J
    //   257: lstore 11
    //   259: iload 4
    //   261: istore 7
    //   263: iload 4
    //   265: istore 5
    //   267: aload_0
    //   268: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   271: invokevirtual 211	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   274: lload 11
    //   276: invokestatic 216	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   279: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   282: ifeq +124 -> 406
    //   285: iload 4
    //   287: istore 7
    //   289: iload 4
    //   291: istore 5
    //   293: aload_1
    //   294: getfield 240	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   297: ldc_w 923
    //   300: invokevirtual 248	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   303: istore 6
    //   305: iload 6
    //   307: istore 5
    //   309: aload_0
    //   310: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   313: invokestatic 928	com/tencent/mobileqq/activity/aio/stickerrecommended/StickerRecManager:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lcom/tencent/mobileqq/activity/aio/stickerrecommended/StickerRecManager;
    //   316: iload 5
    //   318: invokevirtual 931	com/tencent/mobileqq/activity/aio/stickerrecommended/StickerRecManager:a	(Z)V
    //   321: iload 5
    //   323: istore 6
    //   325: iload 4
    //   327: istore 8
    //   329: iload 6
    //   331: istore 4
    //   333: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   336: ifeq +45 -> 381
    //   339: ldc 108
    //   341: iconst_2
    //   342: new 20	java/lang/StringBuilder
    //   345: dup
    //   346: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   349: ldc_w 921
    //   352: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: iload 8
    //   357: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   360: ldc_w 933
    //   363: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: iload 6
    //   368: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   371: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   374: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   377: iload 6
    //   379: istore 4
    //   381: aload_0
    //   382: bipush 104
    //   384: iconst_1
    //   385: iload 4
    //   387: invokestatic 179	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   390: invokevirtual 183	com/tencent/mobileqq/app/CardHandler:notifyUI	(IZLjava/lang/Object;)V
    //   393: return
    //   394: iconst_0
    //   395: istore 4
    //   397: goto -377 -> 20
    //   400: iconst_0
    //   401: istore 4
    //   403: goto -287 -> 116
    //   406: iload 4
    //   408: istore 8
    //   410: iload 10
    //   412: istore 6
    //   414: iload 4
    //   416: istore 7
    //   418: iload 4
    //   420: istore 5
    //   422: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   425: ifeq -96 -> 329
    //   428: iload 4
    //   430: istore 7
    //   432: iload 4
    //   434: istore 5
    //   436: ldc 108
    //   438: iconst_2
    //   439: new 20	java/lang/StringBuilder
    //   442: dup
    //   443: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   446: ldc_w 935
    //   449: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: aload_0
    //   453: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   456: invokevirtual 211	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   459: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: ldc_w 552
    //   465: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: lload 11
    //   470: invokevirtual 331	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   473: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   476: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   479: iload 4
    //   481: istore 8
    //   483: iload 10
    //   485: istore 6
    //   487: goto -158 -> 329
    //   490: astore_1
    //   491: iload 7
    //   493: istore 5
    //   495: iconst_0
    //   496: istore 4
    //   498: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   501: ifeq +13 -> 514
    //   504: ldc 108
    //   506: iconst_1
    //   507: ldc_w 937
    //   510: aload_1
    //   511: invokestatic 939	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   514: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   517: ifeq +134 -> 651
    //   520: ldc 108
    //   522: iconst_2
    //   523: new 20	java/lang/StringBuilder
    //   526: dup
    //   527: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   530: ldc_w 921
    //   533: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: iconst_0
    //   537: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   540: ldc_w 933
    //   543: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: iload 4
    //   548: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   551: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   554: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   557: goto -176 -> 381
    //   560: astore_1
    //   561: iload 9
    //   563: istore 6
    //   565: iload 5
    //   567: istore 4
    //   569: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   572: ifeq +41 -> 613
    //   575: ldc 108
    //   577: iconst_2
    //   578: new 20	java/lang/StringBuilder
    //   581: dup
    //   582: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   585: ldc_w 921
    //   588: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: iload 4
    //   593: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   596: ldc_w 933
    //   599: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: iload 6
    //   604: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   607: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   610: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   613: aload_1
    //   614: athrow
    //   615: astore_1
    //   616: iload 5
    //   618: istore 6
    //   620: goto -51 -> 569
    //   623: astore_1
    //   624: iload 4
    //   626: istore 6
    //   628: iload 5
    //   630: istore 4
    //   632: goto -63 -> 569
    //   635: astore_1
    //   636: iload 4
    //   638: istore 6
    //   640: iload 5
    //   642: istore 4
    //   644: iload 6
    //   646: istore 5
    //   648: goto -150 -> 498
    //   651: goto -270 -> 381
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	654	0	this	CardHandler
    //   0	654	1	paramToServiceMsg	ToServiceMsg
    //   0	654	2	paramFromServiceMsg	FromServiceMsg
    //   0	654	3	paramObject	Object
    //   18	625	4	bool1	boolean
    //   72	575	5	bool2	boolean
    //   59	586	6	bool3	boolean
    //   68	424	7	bool4	boolean
    //   55	427	8	bool5	boolean
    //   1	561	9	bool6	boolean
    //   4	480	10	bool7	boolean
    //   257	212	11	l	long
    // Exception table:
    //   from	to	target	type
    //   74	95	490	java/lang/Exception
    //   103	113	490	java/lang/Exception
    //   124	130	490	java/lang/Exception
    //   138	165	490	java/lang/Exception
    //   194	204	490	java/lang/Exception
    //   220	230	490	java/lang/Exception
    //   238	259	490	java/lang/Exception
    //   267	285	490	java/lang/Exception
    //   293	305	490	java/lang/Exception
    //   422	428	490	java/lang/Exception
    //   436	479	490	java/lang/Exception
    //   74	95	560	finally
    //   103	113	560	finally
    //   124	130	560	finally
    //   138	165	560	finally
    //   194	204	560	finally
    //   220	230	560	finally
    //   238	259	560	finally
    //   267	285	560	finally
    //   293	305	560	finally
    //   422	428	560	finally
    //   436	479	560	finally
    //   309	321	615	finally
    //   498	514	623	finally
    //   309	321	635	java/lang/Exception
  }
  
  private void W(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = ((Long)paramToServiceMsg.getAttribute("uin", Long.valueOf(0L))).longValue();
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "handleGetEducationList " + l);
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
          if (paramFromServiceMsg.hasNext())
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
            if (paramObject.uint32_hidden_flag.get() == 1)
            {
              bool = true;
              label292:
              ((SchoolInfo)localObject).jdField_a_of_type_Boolean = bool;
              if (paramObject.uint32_verify_status.get() != 2) {
                break label336;
              }
            }
            label336:
            for (boolean bool = true;; bool = false)
            {
              ((SchoolInfo)localObject).jdField_b_of_type_Boolean = bool;
              paramToServiceMsg.add(localObject);
              break;
              bool = false;
              break label292;
            }
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "handleGetEducationList " + paramToServiceMsg.toString());
      }
      ((BusinessCardManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.BUSINESS_CARD_MANAGER)).a(paramToServiceMsg);
      notifyUI(101, true, new Object[] { Long.valueOf(l), paramToServiceMsg });
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("CardHandler", 2, "handleGetEducationList failed result:" + i);
    }
    notifyUI(101, false, new Object[] { Long.valueOf(l), null });
  }
  
  private void X(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, new oidb_0xe5f.RspBody());
    if (i == 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramFromServiceMsg = new Bundle();
      if (paramToServiceMsg != null) {
        paramFromServiceMsg = paramToServiceMsg.extraData;
      }
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "handlePraiseLifeAchievement and isSuccess is " + bool + " result is " + i);
      }
      notifyUI(114, bool, paramFromServiceMsg);
      return;
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
  
  public static String a(String paramString, int paramInt)
  {
    if ((paramString == null) || ("".equals(paramString)) || (!jdField_a_of_type_JavaUtilVector.contains(Integer.valueOf(paramInt)))) {
      return "";
    }
    return jdField_a_of_type_JavaLangString + paramInt + "/" + paramString + ".jpg";
  }
  
  private short a(short paramShort, boolean paramBoolean)
  {
    short s = 1;
    if (((TempMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER)).b(paramShort))
    {
      if (paramBoolean) {
        return 1;
      }
      return 2;
    }
    if (paramBoolean) {}
    for (paramShort = s;; paramShort = 0) {
      return paramShort;
    }
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, Bundle paramBundle)
  {
    if (paramFromServiceMsg.getResultCode() == 1000) {}
    for (boolean bool = true;; bool = false)
    {
      notifyUI(29, bool, paramBundle);
      return;
    }
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject1 = new cmd0x7a8.RspBody();
    int n = parseOIDBPkg(paramFromServiceMsg, paramObject, (MessageMicro)localObject1);
    paramObject = null;
    paramFromServiceMsg = null;
    Iterator localIterator = null;
    MedalWallMng localMedalWallMng = (MedalWallMng)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MEDAL_WALL_MNG);
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
                      break label1045;
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
                  break label1010;
                }
              }
              label1010:
              for (paramFromServiceMsg = ((FriendsManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), true);; paramFromServiceMsg = null)
              {
                if (n == 0) {}
                for (bool = true;; bool = false)
                {
                  notifyUI(51, bool, paramFromServiceMsg);
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
      label1045:
      i = k;
      k = m;
    }
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
    if ("MCardSvc.ReqSetCard".equals(str)) {
      k(paramToServiceMsg, paramFromServiceMsg, paramObject, paramBundle);
    }
    do
    {
      return;
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
    } while (!"VisitorSvc.ReqDeleteVisitorRecord".equals(str));
    g(paramToServiceMsg, paramFromServiceMsg, paramObject, paramBundle);
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
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if ("MCardSvc.ReqDelFace".equals(str)) {
      n(paramToServiceMsg, paramFromServiceMsg, paramObject, paramBundle);
    }
    do
    {
      return;
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
        l(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x491_100".equals(str))
      {
        m(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("SQQzoneSvc.getCover".equals(str))
      {
        n(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("SQQzoneSvc.getPhotoWall".equals(str))
      {
        o(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("SQQzoneSvc.delPhotoWall".equals(str))
      {
        p(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x4ff_9".equals(str))
      {
        k(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0x66b".equals(str));
    a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  private void b(String paramString, List<CardProfile> paramList)
  {
    a(paramString, paramList);
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
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if ("OidbSvc.0x5eb_22".equals(str)) {
      j(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      return;
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
        A(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5eb_42326".equals(str))
      {
        u(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5eb_40350".equals(str))
      {
        v(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x922".equals(str))
      {
        y(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xe26".equals(str))
      {
        x(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xa28".equals(str))
      {
        w(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x7a8".equals(str))
      {
        O(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xac6".equals(str))
      {
        P(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xc33_42220".equals(str))
      {
        Q(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xcd5".equals(str))
      {
        h(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xd8a".equals(str))
      {
        U(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xd2d".equals(str))
      {
        W(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x4ff_42315".equals(str))
      {
        V(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5eb_15(2)".equals(str))
      {
        F(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0xe5f_2".equals(str));
    X(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  private boolean c()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    long l1 = localSharedPreferences.getLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin() + "sign_in_operation_time_stamp", 0L);
    long l2 = localSharedPreferences.getLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin() + "sign_in_operation_time_refresh", 0L) * 1000L;
    long l3 = NetConnInfoCenter.getServerTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "shouldResuestSignOperate, last=" + l1 + ", interval=" + l2 + ", now=" + l3);
    }
    if (Math.abs(l3 - l1) <= 600000L) {
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "shouldResuestSignOperate, <10min");
      }
    }
    while (l3 - l1 < l2) {
      return false;
    }
    localSharedPreferences.edit().putLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin() + "sign_in_operation_time_stamp", l3).commit();
    return true;
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
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
        StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).collectPerformance(String.valueOf(l2), "profileCardSendFavorite", bool1, 0L, 0L, paramFromServiceMsg, "", false);
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.", 2, String.format("handleFavorite result=%s targetUin=%s iCount=%s", new Object[] { Boolean.valueOf(bool1), Long.valueOf(l1), Integer.valueOf(j) }));
        }
        if ((bool1) && (l1 > 0L))
        {
          paramToServiceMsg = (Card)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager().find(Card.class, l1);
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
            ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(paramToServiceMsg);
          }
          VoteUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, l1, j);
        }
        notifyUI(32, bool1, paramBundle);
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
        label554:
        QLog.i("Q.profilecard.", 2, paramToServiceMsg);
      }
    }
    else
    {
      if (paramObject == null) {
        break label629;
      }
    }
    label629:
    for (paramToServiceMsg = "-201";; paramToServiceMsg = "-202")
    {
      paramFromServiceMsg.put("param_FailCode", paramToServiceMsg);
      StatisticCollector.getInstance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).collectPerformance(String.valueOf(l2), "profileCardSendFavorite", false, 0L, 0L, paramFromServiceMsg, "", false);
      bool1 = bool2;
      break;
      paramToServiceMsg = "null";
      break label554;
    }
  }
  
  private boolean d()
  {
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    long l1 = localSharedPreferences.getLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin() + "sign_in_last_get_time", 0L);
    long l2 = localSharedPreferences.getLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin() + "sign_in_next_get_time", 0L);
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
    localSharedPreferences.edit().putLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin() + "sign_in_last_get_time", l3).commit();
    return true;
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    RespGetFavoriteList localRespGetFavoriteList;
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      paramObject = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramToServiceMsg.getUin());
      localRespGetFavoriteList = (RespGetFavoriteList)paramFromServiceMsg.getAttribute("result");
      if (!QLog.isColorLevel()) {
        break label534;
      }
      paramFromServiceMsg = new StringBuilder(1024);
      paramFromServiceMsg.append("handleReqFavoriteList log [ ");
    }
    for (;;)
    {
      switch (localRespGetFavoriteList.stHeader.iReplyCode)
      {
      default: 
        paramToServiceMsg = a(3, 7);
        paramBundle.putLong("respTime", localRespGetFavoriteList.RespTime);
        paramBundle.putLong("nextMid", localRespGetFavoriteList.stUserData.lNextMid);
        paramBundle.putByteArray("strCookie", localRespGetFavoriteList.stUserData.strCookie);
        paramBundle.putLong("startMid", -1L);
        notifyUI(42, false, new Object[] { paramObject, paramBundle, paramToServiceMsg });
        if ((QLog.isColorLevel()) && (paramFromServiceMsg != null))
        {
          paramFromServiceMsg.append(" ]");
          QLog.i("CardHandler", 2, paramFromServiceMsg.toString());
        }
        return;
      }
      Iterator localIterator = localRespGetFavoriteList.vFavoriteInfos.iterator();
      ArrayList localArrayList = new ArrayList(0);
      int i = 0;
      label236:
      if (localIterator.hasNext())
      {
        UserProfile localUserProfile = (UserProfile)localIterator.next();
        CardProfile localCardProfile = new CardProfile();
        localCardProfile.readFrom(localUserProfile);
        localCardProfile.type = 3;
        localArrayList.add(localCardProfile);
        if ((!QLog.isColorLevel()) || (paramFromServiceMsg == null)) {
          break label531;
        }
        paramFromServiceMsg.append("\n");
        paramFromServiceMsg.append("i=").append(i).append(",");
        paramFromServiceMsg.append(localCardProfile.getSimpleZanInfo());
        i += 1;
      }
      label531:
      for (;;)
      {
        break label236;
        paramBundle.putLong("respTime", localRespGetFavoriteList.RespTime);
        paramBundle.putLong("startMid", paramToServiceMsg.extraData.getLong("nextMid"));
        paramBundle.putLong("nextMid", localRespGetFavoriteList.stUserData.lNextMid);
        paramBundle.putByteArray("strCookie", localRespGetFavoriteList.stUserData.strCookie);
        if (paramToServiceMsg.extraData.getLong("nextMid", -1L) == 0L) {
          a(3);
        }
        a(paramToServiceMsg.getUin(), localArrayList);
        notifyUI(42, true, new Object[] { paramObject, paramBundle, localArrayList });
        break;
        paramToServiceMsg = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramToServiceMsg.getUin());
        paramBundle.putLong("startMid", -1L);
        notifyUI(42, false, new Object[] { paramToServiceMsg, paramBundle, a(3, 7) });
        return;
      }
      label534:
      paramFromServiceMsg = null;
    }
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "[handleReqVoterList] resultCode = " + paramFromServiceMsg.getResultCode());
    }
    RespGetVoterList localRespGetVoterList;
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      paramObject = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramToServiceMsg.getUin());
      localRespGetVoterList = (RespGetVoterList)paramFromServiceMsg.getAttribute("result");
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "[handleReqVoterList] replyCode = " + localRespGetVoterList.stHeader.iReplyCode);
      }
      if (!QLog.isColorLevel()) {
        break label746;
      }
      paramFromServiceMsg = new StringBuilder(1024);
      paramFromServiceMsg.append("handleReqVoterList log [ ");
    }
    for (;;)
    {
      switch (localRespGetVoterList.stHeader.iReplyCode)
      {
      default: 
        paramToServiceMsg = a(2, 7);
        paramBundle.putLong("respTime", localRespGetVoterList.RespTime);
        paramBundle.putLong("nextMid", localRespGetVoterList.stUserData.lNextMid);
        paramBundle.putByteArray("strCookie", localRespGetVoterList.stUserData.strCookie);
        paramBundle.putLong("startMid", -1L);
        notifyUI(6, false, new Object[] { paramObject, paramBundle, paramToServiceMsg });
        if ((QLog.isColorLevel()) && (paramFromServiceMsg != null))
        {
          paramFromServiceMsg.append(" ]");
          QLog.i("CardHandler", 2, paramFromServiceMsg.toString());
        }
        return;
      }
      Iterator localIterator = localRespGetVoterList.vVoterInfos.iterator();
      ArrayList localArrayList = new ArrayList(0);
      int i = 0;
      label308:
      if (localIterator.hasNext())
      {
        UserProfile localUserProfile = (UserProfile)localIterator.next();
        CardProfile localCardProfile = new CardProfile();
        localCardProfile.readFrom(localUserProfile);
        localCardProfile.type = 2;
        localArrayList.add(localCardProfile);
        if ((!QLog.isColorLevel()) || (paramFromServiceMsg == null)) {
          break label743;
        }
        paramFromServiceMsg.append("\n");
        paramFromServiceMsg.append("i=").append(i).append(",");
        paramFromServiceMsg.append(localCardProfile.getSimpleZanInfo());
        i += 1;
      }
      label743:
      for (;;)
      {
        break label308;
        paramBundle.putLong("respTime", localRespGetVoterList.RespTime);
        paramBundle.putLong("startMid", paramToServiceMsg.extraData.getLong("nextMid"));
        paramBundle.putLong("nextMid", localRespGetVoterList.stUserData.lNextMid);
        paramBundle.putByteArray("strCookie", localRespGetVoterList.stUserData.strCookie);
        long l = paramToServiceMsg.extraData.getLong("nextMid", -1L);
        if (l == 0L) {
          a(2);
        }
        b(paramToServiceMsg.getUin(), localArrayList);
        paramToServiceMsg = new ArrayList(0);
        if (l == 0L)
        {
          if (localRespGetVoterList.vTodayFavoriteInfos != null)
          {
            localIterator = localRespGetVoterList.vTodayFavoriteInfos.iterator();
            while (localIterator.hasNext()) {
              paramToServiceMsg.add(Long.valueOf(((UserProfile)localIterator.next()).lEctID));
            }
          }
          b(paramToServiceMsg);
        }
        notifyUI(6, true, new Object[] { paramObject, paramBundle, localArrayList, paramToServiceMsg, Integer.valueOf(localRespGetVoterList.iMaxFriendFavoriteCount), Integer.valueOf(localRespGetVoterList.iMaxStrangerFavoriteCount), Integer.valueOf(localRespGetVoterList.iTodayVoteCount), Integer.valueOf(localRespGetVoterList.iTodayVoteRank), Integer.valueOf(localRespGetVoterList.iTotalVoteCount) });
        break;
        paramToServiceMsg = ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramToServiceMsg.getUin());
        paramBundle.putLong("startMid", -1L);
        notifyUI(6, false, new Object[] { paramToServiceMsg, paramBundle, a(2, 7) });
        return;
      }
      label746:
      paramFromServiceMsg = null;
    }
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    long l1 = paramToServiceMsg.extraData.getLong("selfUin", 0L);
    long l2 = paramToServiceMsg.extraData.getLong("targetUin");
    int i = paramToServiceMsg.extraData.getInt("type");
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "[handleReqDelVoteRecord] resultCode = " + paramFromServiceMsg.getResultCode() + "targetUin:" + l2 + " type:" + i);
    }
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      paramToServiceMsg = (RespDeleteVisitorRecord)paramFromServiceMsg.getAttribute("result");
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "[handleReqDelVoteRecord] replyCode = " + paramToServiceMsg.stHeader.iReplyCode);
      }
      switch (paramToServiceMsg.stHeader.iReplyCode)
      {
      default: 
        notifyUI(93, false, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i) });
        return;
      }
      notifyUI(93, true, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i) });
      return;
    }
    notifyUI(93, false, new Object[] { Long.valueOf(l1), Long.valueOf(l2), Integer.valueOf(i) });
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg.extraData.getBoolean("isGetList", false))
    {
      R(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    S(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    paramToServiceMsg = new oidb_0x7ba.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
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
        notifyUI(78, true, new Object[] { paramObject, Integer.valueOf(i), Boolean.valueOf(bool), paramBundle.getString("uin") });
        return;
      }
    }
    notifyUI(78, false, paramBundle.getString("uin"));
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg.extraData.getBoolean("sendGlobalRingIdRequest", false))
    {
      G(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    H(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    boolean bool1 = false;
    boolean bool2;
    if (paramFromServiceMsg.isSuccess())
    {
      paramObject = (RespGetCardSwitch)paramObject;
      long l1 = paramObject.uCloseNeighborVote;
      long l2 = paramObject.uCloseTimeGateVote;
      if (l1 == 0L)
      {
        bool1 = true;
        paramObject = (NearByGeneralManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEARBY_GENERAL_MANAGER);
        if (l1 != 0L) {
          break label241;
        }
        bool2 = true;
        label61:
        paramObject.b(bool2);
        paramObject = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()).edit();
        String str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131694983) + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        if (l2 != 0L) {
          break label247;
        }
        bool2 = true;
        label131:
        paramObject.putBoolean(str, bool2).commit();
        paramBundle.putLong("uCloseNeighborVote", l1);
        paramBundle.putLong("uColseTimeEntityManager", l2);
        paramBundle.putString("uin", paramToServiceMsg.getUin());
        notifyUI(33, true, paramBundle);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "handleGetCardSwitches succuss " + paramFromServiceMsg.isSuccess() + " curSwitch:" + bool1);
      }
      return;
      bool1 = false;
      break;
      label241:
      bool2 = false;
      break label61;
      label247:
      bool2 = false;
      break label131;
      paramBundle.putString("uin", paramToServiceMsg.getUin());
      notifyUI(33, false, paramBundle);
    }
  }
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg.extraData.getBoolean("uint32_req_medalwall_flag", false)) {
      E(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      return;
      if (paramToServiceMsg.extraData.getBoolean("uint32_req_allow", false))
      {
        J(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!paramToServiceMsg.extraData.getBoolean("uint32_do_not_disturb_mode_time", false));
    I(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("modify_switch_for_near_people", true);
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp());
    boolean bool1;
    if (paramFromServiceMsg.isSuccess())
    {
      paramObject = (RespSetCardSwitch)paramObject;
      if (bool2) {
        if (paramObject.uCloseNeighborVote == 0L)
        {
          bool1 = true;
          ((NearByGeneralManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEARBY_GENERAL_MANAGER)).b(bool1);
          paramBundle.putBoolean("modify_switch_for_near_people", bool2);
          paramBundle.putBoolean("target_switch", bool1);
          paramBundle.putString("uin", paramToServiceMsg.getUin());
          notifyUI(34, true, paramBundle);
        }
      }
    }
    for (;;)
    {
      if (bool2) {
        StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "CMD_REQ_SETCARDSWITCH", paramFromServiceMsg.isSuccess(), 0L, 0L, null, "response");
      }
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "handleSetCardSwitch succuss " + paramFromServiceMsg.isSuccess() + " forNearPeople:" + bool2 + " curSwitch:" + bool1);
      }
      return;
      bool1 = false;
      break;
      if (paramObject.uCloseTimeGateVote == 0L) {}
      for (bool1 = true;; bool1 = false)
      {
        localSharedPreferences.edit().putBoolean(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131694983) + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), bool1).commit();
        break;
      }
      long l = paramToServiceMsg.extraData.getLong("target_value");
      paramObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
      if (l == 0L)
      {
        bool1 = true;
        label315:
        if (paramObject.trySetCardSwitch(bool2, bool1)) {
          break label438;
        }
        if (!bool2) {
          break label389;
        }
      }
      label389:
      for (bool1 = ((NearByGeneralManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEARBY_GENERAL_MANAGER)).b();; bool1 = localSharedPreferences.getBoolean(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131694983) + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), false))
      {
        paramBundle.putString("uin", paramToServiceMsg.getUin());
        paramBundle.putBoolean("current_switch", bool1);
        notifyUI(34, false, paramBundle);
        break;
        bool1 = false;
        break label315;
      }
      label438:
      bool1 = false;
    }
  }
  
  private void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg.extraData.getBoolean("reqFromCardHandler", false))
    {
      if (!paramToServiceMsg.extraData.getBoolean("isSetLoginDays", false)) {
        break label36;
      }
      B(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    label36:
    do
    {
      return;
      if (paramToServiceMsg.extraData.getBoolean("pcActiveState", false))
      {
        q(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramToServiceMsg.extraData.getBoolean("helloLiveMessage", false))
      {
        s(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramToServiceMsg.extraData.getBoolean("isSetActivateFriend", false))
      {
        K(paramToServiceMsg, paramFromServiceMsg, paramObject);
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
        N(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramToServiceMsg.extraData.getBoolean("isGetAntiLost"))
      {
        M(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramToServiceMsg.extraData.getBoolean("isSetCalReactiveDays", false))
      {
        C(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramToServiceMsg.extraData.getBoolean("isSetBabyQSwitch"))
      {
        L(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramToServiceMsg.extraData.getBoolean("uint32_req_medalwall_flag", false))
      {
        D(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramToServiceMsg.extraData.getBoolean("StrangerInviteToGroup", false))
      {
        T(paramToServiceMsg, paramFromServiceMsg, paramObject);
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
        z(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramToServiceMsg.extraData.getBoolean("uint32_req_push_notice_flag", false))
      {
        t(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramToServiceMsg.extraData.getBoolean("tempConversationBlocState", false))
      {
        r(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!paramToServiceMsg.extraData.getBoolean("setPrettyTroopOwnerFlag", false));
    c(paramToServiceMsg, paramFromServiceMsg, paramObject);
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
      if (!(paramObject instanceof RespSetCard)) {
        break label671;
      }
      paramToServiceMsg = (RespSetCard)paramObject;
      if ((paramToServiceMsg.stHeader == null) || (paramToServiceMsg.stHeader.iReplyCode != 0) || (paramToServiceMsg.vRespSetTemplate == null)) {
        break label671;
      }
      paramObject = (SSummaryCardRsp)decodePacket(paramToServiceMsg.vRespSetTemplate, "rsp", new SSummaryCardRsp());
      if (paramObject == null) {
        break label671;
      }
      if (paramObject.res == 0)
      {
        paramToServiceMsg = paramBundle.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (paramToServiceMsg == null) {
          break label666;
        }
        paramToServiceMsg.lCurrentStyleId = paramObject.styleid;
        paramToServiceMsg.backgroundUrl = paramObject.bgurl;
        paramToServiceMsg.lCurrentBgId = paramObject.bgid;
        paramToServiceMsg.backgroundColor = paramObject.color;
        paramToServiceMsg.dynamicCardFlag = paramObject.dynamicCardFlag;
        paramToServiceMsg.strZipUrl = paramObject.strZipUrl;
        paramToServiceMsg.strActiveUrl = paramObject.strActiveCardUrl;
        paramToServiceMsg.strDrawerCardUrl = paramObject.strDrawerCard;
        paramToServiceMsg.strWzryHeroUrl = paramObject.strWzryHeroUrl;
        paramToServiceMsg.strExtInfo = paramObject.extInfo;
        paramToServiceMsg.cardType = paramObject.cardType;
        paramToServiceMsg.diyDefaultText = paramObject.strDiyDefaultText;
        if (paramObject.stDiyComplicated == null)
        {
          paramFromServiceMsg = "";
          paramToServiceMsg.diyComplicatedInfo = paramFromServiceMsg;
          paramToServiceMsg.cardId = paramObject.cardid;
          paramFromServiceMsg = paramObject.bgtype;
          if (paramFromServiceMsg != null) {
            paramToServiceMsg.setBgType(paramFromServiceMsg);
          }
          if ((paramObject.wzryInfo != null) && (!paramObject.wzryInfo.isEmpty())) {
            paramToServiceMsg.setWzryHonorInfo(paramObject.wzryInfo);
          }
          paramToServiceMsg.templateRet = 0;
          if (paramObject.stDiyText != null)
          {
            paramToServiceMsg.diyTextFontId = paramObject.stDiyText.iFontId;
            paramToServiceMsg.diyText = paramObject.stDiyText.strText;
            paramToServiceMsg.diyTextScale = paramObject.stDiyText.fScaling;
            paramToServiceMsg.diyTextDegree = paramObject.stDiyText.fRotationAngle;
            paramToServiceMsg.diyTextTransparency = paramObject.stDiyText.fTransparency;
            if (!TextUtils.isEmpty(paramObject.stDiyText.strPoint))
            {
              paramFromServiceMsg = paramObject.stDiyText.strPoint.split("_");
              if (paramFromServiceMsg.length != 2) {}
            }
          }
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
        paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
        if (paramFromServiceMsg != null)
        {
          paramFromServiceMsg = paramFromServiceMsg.edit();
          if (paramFromServiceMsg != null) {
            paramFromServiceMsg.putBoolean("svip_profile_use_guide_shown_flag", false).commit();
          }
        }
        paramFromServiceMsg = null;
        if (paramToServiceMsg == null) {
          break label608;
        }
        notifyUI(41, true, paramToServiceMsg);
        return;
        paramFromServiceMsg = paramObject.stDiyComplicated.detail;
      }
      catch (Exception paramFromServiceMsg)
      {
        QLog.e("CardHandler", 1, "set card with diy text response", paramFromServiceMsg);
        continue;
      }
      paramFromServiceMsg = new Pair(Integer.valueOf(paramObject.res), paramObject);
      paramToServiceMsg = null;
      continue;
      label608:
      paramToServiceMsg = paramFromServiceMsg;
      continue;
      notifyUI(41, false, paramBundle.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
      ReportCenter.a().a(paramFromServiceMsg.getServiceCmd(), 100, paramFromServiceMsg.getBusinessFailCode(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 1000277, HardCodeUtil.a(2131701523), true);
      return;
      label666:
      paramFromServiceMsg = null;
      continue;
      label671:
      paramFromServiceMsg = null;
      paramToServiceMsg = null;
    }
  }
  
  private void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setPhoneNumSearchable(bool1, false);
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
        bool1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isPhoneNumSearchable(false);
      }
      notifyUI(38, bool2, Boolean.valueOf(bool1));
      return;
      bool3 = false;
      break;
      bool3 = false;
      continue;
      bool1 = false;
    }
  }
  
  private void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if ((paramFromServiceMsg.getResultCode() == 1000) && ((paramObject instanceof SSummaryCardLableRsp))) {}
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetProfileLabel success : " + bool + ", data : " + paramObject);
      }
      if ((!bool) || (paramObject == null)) {
        break label211;
      }
      paramToServiceMsg = (SSummaryCardLableRsp)paramObject;
      if (paramToServiceMsg.ret != 0) {
        break;
      }
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
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetProfileLabel retCode : " + paramToServiceMsg.ret + ", msg : " + paramToServiceMsg.msg);
    }
    notifyUI(52, false, paramObject);
    return;
    label211:
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetProfileLabel fail from msf retCode : " + paramFromServiceMsg.getResultCode());
    }
    notifyUI(52, false, paramObject);
    if (QLog.isColorLevel()) {
      QLog.e("CardHandler", 2, "-->report MM:cmd=" + paramFromServiceMsg.getServiceCmd() + ",error code=" + paramFromServiceMsg.getBusinessFailCode() + ",uin=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
    ReportCenter.a().a(paramFromServiceMsg.getServiceCmd(), 100, paramFromServiceMsg.getBusinessFailCode(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 1000277, HardCodeUtil.a(2131701526), true);
  }
  
  private void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.setPhoneNumSearchable(bool2, false);
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
        bool2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isPhoneNumSearchable(false);
        notifyUI(39, bool1, Boolean.valueOf(bool2));
        return;
        bool1 = false;
        break;
        bool1 = false;
        continue;
      }
    }
  }
  
  private void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if ((paramFromServiceMsg.getResultCode() == 1000) && ((paramObject instanceof SSummaryCardLableRsp))) {}
    Card localCard;
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetLabelLike success : " + bool + ", data : " + paramObject);
      }
      paramBundle = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      localCard = paramBundle.b(String.valueOf(paramToServiceMsg.extraData.getLong("destUin")));
      long l = paramToServiceMsg.extraData.getLong("labelId");
      if ((!bool) || (paramObject == null)) {
        break label255;
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
      notifyUI(53, true, new Object[] { localCard, Long.valueOf(Long.valueOf(l).longValue()) });
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetLabelLike retCode : " + paramToServiceMsg.ret + ", msg : " + paramToServiceMsg.msg);
    }
    notifyUI(53, false, localCard);
    return;
    label255:
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetLabelLike fail from msf retCode : " + paramFromServiceMsg.getResultCode());
    }
    notifyUI(53, false, localCard);
    if (QLog.isColorLevel()) {
      QLog.e("CardHandler", 2, "-->report MM:cmd=" + paramFromServiceMsg.getServiceCmd() + ",error code=" + paramFromServiceMsg.getBusinessFailCode() + ",uin=" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    }
    ReportCenter.a().a(paramFromServiceMsg.getServiceCmd(), 100, paramFromServiceMsg.getBusinessFailCode(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 1000277, HardCodeUtil.a(2131701525), true);
  }
  
  private void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = (String)paramToServiceMsg.getAttribute("uin");
    EntityManager localEntityManager;
    boolean bool;
    if ((paramFromServiceMsg.isSuccess()) && ((paramObject instanceof mobile_sub_get_cover_rsp)))
    {
      paramFromServiceMsg = (mobile_sub_get_cover_rsp)paramObject;
      localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      paramObject = (QZoneCover)localEntityManager.find(QZoneCover.class, str);
      paramToServiceMsg = paramObject;
      if (paramObject == null)
      {
        paramToServiceMsg = new QZoneCover();
        paramToServiceMsg.uin = str;
      }
      paramToServiceMsg.updateQzoneCover(paramFromServiceMsg);
      if (paramToServiceMsg.getStatus() == 1000)
      {
        localEntityManager.persist(paramToServiceMsg);
        localEntityManager.close();
        bool = true;
        paramToServiceMsg = paramFromServiceMsg;
      }
    }
    for (;;)
    {
      notifyUI(40, bool, new Object[] { str, paramToServiceMsg });
      return;
      localEntityManager.update(paramToServiceMsg);
      break;
      paramToServiceMsg = null;
      bool = false;
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
        notifyUI(12, true, new Object[] { paramBundle, paramFromServiceMsg });
        continue;
        notifyUI(12, false, new Object[] { paramBundle, paramFromServiceMsg });
      }
    }
    paramBundle.putInt("result", -1);
    notifyUI(12, false, new Object[] { paramBundle, ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramToServiceMsg.getUin()) });
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
      localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      paramObject = (QZonePhotoWall)localEntityManager.find(QZonePhotoWall.class, str1);
      paramToServiceMsg = paramObject;
      if (paramObject == null)
      {
        paramToServiceMsg = new QZonePhotoWall();
        paramToServiceMsg.uin = str1;
      }
      paramToServiceMsg.updateQzonePhotoWall(str2, paramFromServiceMsg);
      if (paramToServiceMsg.getStatus() == 1000)
      {
        localEntityManager.persist(paramToServiceMsg);
        localEntityManager.close();
        bool = true;
        paramToServiceMsg = paramFromServiceMsg;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qzonephotowall", 2, "handleGetPhotoWall isSuc:" + bool);
      }
      notifyUI(69, bool, new Object[] { str2, paramToServiceMsg, str1 });
      return;
      localEntityManager.update(paramToServiceMsg);
      break;
      paramToServiceMsg = null;
      bool = false;
    }
  }
  
  private void p()
  {
    synchronized (this.jdField_a_of_type_JavaUtilArrayList)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList.size() == 0)
      {
        notifyUI(71, false, new Object[] { "" });
        return;
      }
      String str1 = (String)this.jdField_a_of_type_JavaUtilArrayList.remove(0);
      if (TextUtils.isEmpty(str1))
      {
        notifyUI(71, false, new Object[] { "" });
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.qzonephotowall", 2, "uploadPhotoWall filePath:" + str2);
    }
    ??? = new PhotoWallUploadTask(str2);
    ((PhotoWallUploadTask)???).flowId = ((int)System.currentTimeMillis() / 1000);
    ((PhotoWallUploadTask)???).sRefer = "mqq";
    ((PhotoWallUploadTask)???).iUin = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    ((PhotoWallUploadTask)???).vLoginData = VipUploadUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    ((PhotoWallUploadTask)???).op = 1;
    ((PhotoWallUploadTask)???).source = 1;
    ((PhotoWallUploadTask)???).uploadTaskCallback = new CardHandler.4(this);
    ((PhotoWallUploadTask)???).uploadFilePath = str2;
    ((PhotoWallUploadTask)???).md5 = VipUploadUtils.a(str2);
    ((PhotoWallUploadTask)???).autoRotate = true;
    CardHandler.5 local5 = new CardHandler.5(this, Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    UploadEnv localUploadEnv = new UploadEnv();
    if (!UploadServiceBuilder.getInstance().isInitialized()) {
      UploadServiceBuilder.getInstance().init(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), local5, null, null, localUploadEnv, localUploadEnv);
    }
    UploadServiceBuilder.getInstance().upload((AbstractUploadTask)???);
  }
  
  private void p(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = paramFromServiceMsg.isSuccess();
    paramFromServiceMsg = (String)paramToServiceMsg.getAttribute("uin");
    paramToServiceMsg = (String)paramToServiceMsg.getAttribute("photo_id");
    if (QLog.isColorLevel()) {
      QLog.d("Q.qzonephotowall", 2, "handleDelPhotoWall isSuc:" + bool + " photoid:" + paramToServiceMsg);
    }
    notifyUI(70, bool, new Object[] { paramFromServiceMsg });
  }
  
  private void q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
      paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131694733);
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      bool3 = bool1;
      if (!bool1) {
        break label600;
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
          break label600;
        }
        bool2 = bool1;
        bool4 = bool1;
        bool3 = bool1;
        if (!paramObject.bytes_bodybuffer.has()) {
          break label600;
        }
        bool2 = bool1;
        bool4 = bool1;
        bool3 = bool1;
        if (paramObject.bytes_bodybuffer.get() == null) {
          break label600;
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
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(String.valueOf(l))) {
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
          break label590;
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
      notifyUI(55, bool4, new Object[] { Boolean.valueOf(bool3), paramFromServiceMsg, str });
      return;
      bool1 = false;
      break;
      bool1 = false;
      continue;
      bool1 = false;
      bool2 = false;
      continue;
      label590:
      bool3 = false;
      bool4 = bool2;
      continue;
      label600:
      bool1 = false;
      bool2 = bool3;
    }
  }
  
  private void r(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool5;
    short s;
    boolean bool1;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool2 = true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "handleSetTempConversationBlocState success=" + bool2);
      }
      bool5 = paramToServiceMsg.extraData.getBoolean("switch");
      paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131694733);
      s = paramToServiceMsg.extraData.getShort("type");
      bool1 = bool2;
      if (bool2)
      {
        bool3 = bool2;
        bool4 = bool2;
      }
    }
    for (;;)
    {
      try
      {
        paramObject = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if (paramObject == null) {
          continue;
        }
        bool3 = bool2;
        bool4 = bool2;
        if (paramObject.uint32_result.get() != 0) {
          continue;
        }
        bool2 = true;
        bool3 = bool2;
        bool4 = bool2;
        if (QLog.isColorLevel())
        {
          bool3 = bool2;
          bool4 = bool2;
          QLog.d("Q.profilecard.", 2, "handleSetTempConversationBlocState result=" + bool2);
        }
        bool1 = bool2;
        if (bool2)
        {
          bool1 = bool2;
          bool3 = bool2;
          bool4 = bool2;
          if (paramObject.bytes_bodybuffer.has())
          {
            bool1 = bool2;
            bool3 = bool2;
            bool4 = bool2;
            if (paramObject.bytes_bodybuffer.get() != null)
            {
              bool3 = bool2;
              bool4 = bool2;
              int i = ByteBuffer.wrap(paramObject.bytes_bodybuffer.get().toByteArray()).getInt();
              long l = i;
              if (i < 0) {
                l = i & 0x7FFFFFFF | 0x80000000;
              }
              bool3 = bool2;
              bool4 = bool2;
              bool1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(String.valueOf(l));
              if (!bool1) {
                continue;
              }
              bool1 = true;
            }
          }
        }
        bool2 = bool1;
        if (QLog.isColorLevel())
        {
          QLog.d("Q.profilecard.", 2, "handleSetTempConversationBlocState result=" + bool1 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
          bool2 = bool1;
        }
      }
      catch (Exception paramObject)
      {
        bool4 = bool3;
        if (!QLog.isColorLevel()) {
          continue;
        }
        bool4 = bool3;
        QLog.d("Q.profilecard.", 2, "handleSetTempConversationBlocState ex", paramObject);
        bool2 = bool3;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.", 2, "handleSetTempConversationBlocState result=" + bool3 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
        bool2 = bool3;
        continue;
      }
      finally
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.", 2, "handleSetTempConversationBlocState result=" + bool4 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
      }
      ((TempMsgManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER)).a(s, bool2, paramFromServiceMsg, bool5);
      return;
      bool2 = false;
      break;
      bool2 = false;
      continue;
      bool1 = false;
    }
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
      paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getString(2131694733);
      str = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      bool3 = bool1;
      if (!bool1) {
        break label600;
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
          break label600;
        }
        bool2 = bool1;
        bool4 = bool1;
        bool3 = bool1;
        if (!paramObject.bytes_bodybuffer.has()) {
          break label600;
        }
        bool2 = bool1;
        bool4 = bool1;
        bool3 = bool1;
        if (paramObject.bytes_bodybuffer.get() == null) {
          break label600;
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
        if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(String.valueOf(l))) {
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
          break label590;
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
      notifyUI(87, bool4, new Object[] { Boolean.valueOf(bool3), paramFromServiceMsg, str });
      return;
      bool1 = false;
      break;
      bool1 = false;
      continue;
      bool1 = false;
      bool2 = false;
      continue;
      label590:
      bool3 = false;
      bool4 = bool2;
      continue;
      label600:
      bool1 = false;
      bool2 = bool3;
    }
  }
  
  private void t(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool5 = true;
    boolean bool4 = true;
    boolean bool6 = false;
    boolean bool1;
    boolean bool2;
    boolean bool3;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "handleSetShowPushNotice success=" + bool1);
      }
      bool2 = bool1;
      if (!bool1) {
        break label458;
      }
      bool3 = bool1;
    }
    label458:
    for (;;)
    {
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        bool3 = bool1;
        if (paramFromServiceMsg.uint32_result.get() == 0)
        {
          bool1 = true;
          bool3 = bool1;
          if (QLog.isColorLevel())
          {
            bool3 = bool1;
            QLog.d("Q.profilecard.", 2, "handleSetShowPushNotice result=" + bool1);
          }
          bool2 = bool1;
          if (!bool1) {
            break label458;
          }
          bool3 = bool1;
          bool2 = bool1;
          if (!paramFromServiceMsg.bytes_bodybuffer.has()) {
            break label458;
          }
          bool3 = bool1;
          bool2 = bool1;
          if (paramFromServiceMsg.bytes_bodybuffer.get() == null) {
            break label458;
          }
          bool3 = bool1;
          i = ByteBuffer.wrap(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray()).getInt();
          if (i >= 0) {
            continue;
          }
          l = i + 4294967296L;
          bool2 = bool6;
          bool3 = bool1;
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(String.valueOf(l)))
          {
            bool3 = bool1;
            bool1 = paramToServiceMsg.extraData.getBoolean("switch");
          }
        }
      }
      catch (Exception paramToServiceMsg)
      {
        int i;
        long l;
        bool1 = bool3;
        bool4 = bool5;
        QLog.e("Q.profilecard.", 2, paramToServiceMsg, new Object[0]);
        bool2 = bool1;
        continue;
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.", 2, "handleSetShowPushNotice show=" + bool1);
        }
        QLog.d("PushNotise", 2, "handleSetShowPushNotice show=" + bool1);
        bool2 = true;
        bool4 = bool1;
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.", 2, "handleSetShowPushNotice show=" + bool4 + "isSuccess=" + bool2);
        }
        notifyUI(92, bool2, Boolean.valueOf(bool4));
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        bool2 = true;
        bool4 = bool1;
        bool1 = bool2;
        continue;
      }
      bool1 = false;
      break;
      bool1 = false;
      continue;
      l = i;
    }
  }
  
  private void u(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool6 = false;
    boolean bool5 = true;
    boolean bool1;
    boolean bool3;
    boolean bool2;
    boolean bool4;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      QLog.e("vip_pretty.CardHandler", 1, "handleGetPrettyTroopOwnerFlag success=" + paramFromServiceMsg.getResultCode());
      bool3 = bool1;
      if (!bool1) {
        break label446;
      }
      bool2 = bool1;
      bool4 = bool1;
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        bool2 = bool1;
        bool4 = bool1;
        if (paramToServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool1 = true;
        bool2 = bool1;
        bool4 = bool1;
        QLog.e("vip_pretty.CardHandler", 1, "handleGetPrettyTroopOwnerFlag result=" + bool1);
        bool3 = bool1;
        if (!bool1) {
          break label446;
        }
        bool2 = bool1;
        bool4 = bool1;
        bool3 = bool1;
        if (!paramToServiceMsg.bytes_bodybuffer.has()) {
          break label446;
        }
        bool2 = bool1;
        bool4 = bool1;
        bool3 = bool1;
        if (paramToServiceMsg.bytes_bodybuffer.get() == null) {
          break label446;
        }
        bool2 = bool1;
        bool4 = bool1;
        paramFromServiceMsg = new oidb_0x5eb.RspBody();
        bool2 = bool1;
        bool4 = bool1;
        paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        bool2 = bool1;
        bool4 = bool1;
        if (paramFromServiceMsg.rpt_msg_uin_data.size() <= 0) {
          continue;
        }
        bool2 = bool1;
        bool4 = bool1;
        int i = ((oidb_0x5eb.UdcUinData)paramFromServiceMsg.rpt_msg_uin_data.get(0)).uint32_flag_hide_pretty_group_owner_identity.get();
        bool2 = bool6;
        if (i == 0) {
          bool2 = true;
        }
        bool1 = true;
      }
      catch (Exception paramToServiceMsg)
      {
        bool4 = bool2;
        QLog.e("vip_pretty.CardHandler", 1, "handleGetPrettyTroopOwnerFlag ex", paramToServiceMsg);
        QLog.e("vip_pretty.CardHandler", 1, "handleGetPrettyTroopOwnerFlag result=" + bool2);
        bool1 = bool2;
        bool2 = bool5;
        continue;
      }
      finally
      {
        QLog.e("vip_pretty.CardHandler", 1, "handleGetPrettyTroopOwnerFlag result=" + bool4);
      }
      notifyUI(110, bool1, Boolean.valueOf(bool2));
      return;
      bool1 = false;
      break;
      bool1 = false;
      continue;
      bool1 = false;
      bool2 = true;
      continue;
      label446:
      bool2 = true;
      bool1 = bool3;
    }
  }
  
  private void v(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
        break label515;
      }
      bool4 = bool1;
      bool5 = bool1;
    }
    label515:
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
          break label515;
        }
        bool4 = bool1;
        bool5 = bool1;
        bool2 = bool1;
        if (!paramToServiceMsg.bytes_bodybuffer.has()) {
          break label515;
        }
        bool4 = bool1;
        bool5 = bool1;
        bool2 = bool1;
        if (paramToServiceMsg.bytes_bodybuffer.get() == null) {
          break label515;
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
      notifyUI(83, bool5, Boolean.valueOf(bool1));
      return;
      bool1 = false;
      break;
      bool1 = false;
    }
  }
  
  private void w(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
        ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(paramToServiceMsg);
        bool2 = bool1;
        bool3 = bool1;
        notifyUI(90, bool1, paramToServiceMsg);
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
  
  private void x(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = 0;
    boolean bool1;
    boolean bool4;
    boolean bool2;
    boolean bool3;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "handleGetSigninOperate success=" + bool1);
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
        paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
        bool2 = bool1;
        bool3 = bool1;
        paramObject = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        bool2 = bool1;
        bool3 = bool1;
        if (paramObject.uint32_result.get() != 0) {
          break label985;
        }
        bool1 = true;
        bool2 = bool1;
        bool3 = bool1;
        if (QLog.isColorLevel())
        {
          bool2 = bool1;
          bool3 = bool1;
          QLog.d("CardHandler", 2, "handleGetSigninOperate result=" + bool1);
        }
        bool4 = bool1;
        if (bool1)
        {
          bool4 = bool1;
          bool2 = bool1;
          bool3 = bool1;
          if (paramObject.bytes_bodybuffer.has())
          {
            bool4 = bool1;
            bool2 = bool1;
            bool3 = bool1;
            if (paramObject.bytes_bodybuffer.get() != null)
            {
              bool2 = bool1;
              bool3 = bool1;
              paramFromServiceMsg = new oidb_0xe26.RspBody();
              bool2 = bool1;
              bool3 = bool1;
              paramFromServiceMsg.mergeFrom(paramObject.bytes_bodybuffer.get().toByteArray());
              bool2 = bool1;
              bool3 = bool1;
              if (paramFromServiceMsg.err_code.get() == 0)
              {
                bool2 = bool1;
                bool3 = bool1;
                if (paramFromServiceMsg.template_list.get().size() > 0)
                {
                  bool2 = bool1;
                  bool3 = bool1;
                  if (i < paramFromServiceMsg.template_list.get().size())
                  {
                    bool2 = bool1;
                    bool3 = bool1;
                    paramObject = (oidb_0xe26.EntranceTemplate)paramFromServiceMsg.template_list.get().get(i);
                    bool2 = bool1;
                    bool3 = bool1;
                    Object localObject = new JSONObject();
                    bool2 = bool1;
                    bool3 = bool1;
                    ((JSONObject)localObject).put("id", paramObject.id.get());
                    bool2 = bool1;
                    bool3 = bool1;
                    ((JSONObject)localObject).put("name", new String(paramObject.name.get().toByteArray()));
                    bool2 = bool1;
                    bool3 = bool1;
                    ((JSONObject)localObject).put("state", paramObject.state.get());
                    bool2 = bool1;
                    bool3 = bool1;
                    ((JSONObject)localObject).put("template_text", new String(paramObject.template_text.get().toByteArray()));
                    bool2 = bool1;
                    bool3 = bool1;
                    ((JSONObject)localObject).put("start_time", paramObject.start_time.get());
                    bool2 = bool1;
                    bool3 = bool1;
                    ((JSONObject)localObject).put("end_time", paramObject.end_time.get());
                    bool2 = bool1;
                    bool3 = bool1;
                    ((JSONObject)localObject).put("type", paramObject.type.get());
                    bool2 = bool1;
                    bool3 = bool1;
                    ((JSONObject)localObject).put("bytes_url", new String(paramObject.bytes_url.get().toByteArray()));
                    bool2 = bool1;
                    bool3 = bool1;
                    ((JSONObject)localObject).put("bytes_icon_url", new String(paramObject.bytes_icon_url.get().toByteArray()));
                    bool2 = bool1;
                    bool3 = bool1;
                    ((JSONObject)localObject).put("bytes_icon_custom_url", new String(paramObject.bytes_icon_custom_url.get().toByteArray()));
                    bool2 = bool1;
                    bool3 = bool1;
                    ((JSONObject)localObject).put("trace_info", paramObject.trace_info.get());
                    bool2 = bool1;
                    bool3 = bool1;
                    localObject = ((JSONObject)localObject).toString();
                    bool2 = bool1;
                    bool3 = bool1;
                    paramToServiceMsg.edit().putString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin() + "sign_in_operation" + paramObject.state.get() + "" + paramObject.type.get(), (String)localObject);
                    i += 1;
                    continue;
                  }
                }
              }
              bool2 = bool1;
              bool3 = bool1;
              paramToServiceMsg.edit().putLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin() + "sign_in_operation_time_refresh", paramFromServiceMsg.refresh_second.get()).commit();
              bool4 = bool1;
            }
          }
        }
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        bool3 = bool2;
        if (QLog.isColorLevel())
        {
          bool3 = bool2;
          QLog.d("CardHandler", 2, "handleGetSigninRedTouch ex", paramToServiceMsg);
        }
        return;
      }
      finally
      {
        if (QLog.isColorLevel()) {
          QLog.d("CardHandler", 2, "handleGetSigninRedTouch result=" + bool3);
        }
      }
      bool1 = false;
      break;
      label985:
      bool1 = false;
    }
  }
  
  private void y(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
          break label1403;
        }
        bool2 = bool1;
        bool3 = bool1;
        if (!paramToServiceMsg.bytes_bodybuffer.has()) {
          break label1403;
        }
        bool2 = bool1;
        bool3 = bool1;
        if (paramToServiceMsg.bytes_bodybuffer.get() == null) {
          break label1403;
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
        paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
        bool2 = bool1;
        bool3 = bool1;
        paramFromServiceMsg.edit().putLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin() + "sign_in_next_get_time", l2 * 1000L).commit();
        bool2 = bool1;
        bool3 = bool1;
        int j = ((cmd0x922.RspBody)localObject).msg_push_info.uint32_type.get();
        bool2 = bool1;
        bool3 = bool1;
        if (QLog.isColorLevel())
        {
          bool2 = bool1;
          bool3 = bool1;
          QLog.d("CardHandler", 2, "handleGetSigninRedTouch testtype=" + j + ",needUpdate = " + i);
        }
        if (i != 1) {
          continue;
        }
        bool2 = bool1;
        bool3 = bool1;
        i = ((cmd0x922.RspBody)localObject).msg_push_info.uint32_type.get();
        bool2 = bool1;
        bool3 = bool1;
        j = ((cmd0x922.RspBody)localObject).msg_push_info.uint32_red_point.get();
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
        paramFromServiceMsg.edit().putString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin() + "sign_in_info", (String)localObject).putLong("sign_in_time_stamp", l1).commit();
        bool2 = bool1;
        bool3 = bool1;
        if (QLog.isColorLevel())
        {
          bool2 = bool1;
          bool3 = bool1;
          QLog.d("DailySignIn", 2, "handleGetSigninRedTouch type=" + i + " redpoint=" + j + " day=" + k + " wording=" + paramToServiceMsg + " url=" + paramObject + " iconUrl=" + str + " lastTime=" + m + " openfunc=" + n);
        }
        bool2 = bool1;
        bool3 = bool1;
        notifyUI(84, bool1, null);
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
        paramToServiceMsg = paramFromServiceMsg.getString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin() + "sign_in_info", "");
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
          paramFromServiceMsg.edit().putString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin() + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin() + "sign_in_info", paramToServiceMsg).putLong("sign_in_time_stamp", l1).commit();
        }
        else
        {
          label1403:
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
  
  private void z(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    short s1 = paramToServiceMsg.extraData.getShort("switch_id");
    short s2 = paramToServiceMsg.extraData.getShort("switch_value");
    boolean bool2 = false;
    int j = -1;
    int k = j;
    int i = j;
    int m = j;
    for (;;)
    {
      boolean bool1;
      try
      {
        if (!paramFromServiceMsg.isSuccess()) {
          continue;
        }
        k = j;
        if (paramObject == null) {
          continue;
        }
        i = j;
        m = j;
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        i = j;
        m = j;
        j = paramToServiceMsg.uint32_result.get();
        k = j;
        if (j != 0) {
          continue;
        }
        k = j;
        i = j;
        m = j;
        if (!paramToServiceMsg.bytes_bodybuffer.has()) {
          continue;
        }
        k = j;
        i = j;
        m = j;
        if (paramToServiceMsg.bytes_bodybuffer.get() == null) {
          continue;
        }
        i = j;
        m = j;
        n = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray()).getInt();
        if (n >= 0) {
          continue;
        }
        l = n + 4294967296L;
        i = j;
        m = j;
        bool1 = String.valueOf(l).equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (!bool1) {
          continue;
        }
        bool1 = true;
        i = j;
        if (!QLog.isColorLevel()) {
          break label651;
        }
        QLog.d("CommonSwitchTag", 2, String.format(Locale.getDefault(), "handleSetCommonSwitchFromDetailInfo suc: %b  result: %d  id: %d value: %d", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(i), Short.valueOf(s1), Short.valueOf(s2) }));
        j = i;
      }
      catch (Exception paramToServiceMsg)
      {
        int n;
        long l;
        m = i;
        if (!QLog.isColorLevel()) {
          continue;
        }
        m = i;
        QLog.d("CommonSwitchTag", 2, "handleSetCommonSwitchFromDetailInfo ex", paramToServiceMsg);
        j = i;
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("CommonSwitchTag", 2, String.format(Locale.getDefault(), "handleSetCommonSwitchFromDetailInfo suc: %b  result: %d  id: %d value: %d", new Object[] { Boolean.valueOf(false), Integer.valueOf(i), Short.valueOf(s1), Short.valueOf(s2) }));
        j = i;
        bool1 = bool2;
        continue;
      }
      finally
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("CommonSwitchTag", 2, String.format(Locale.getDefault(), "handleSetCommonSwitchFromDetailInfo suc: %b  result: %d  id: %d value: %d", new Object[] { Boolean.valueOf(false), Integer.valueOf(m), Short.valueOf(s1), Short.valueOf(s2) }));
      }
      if (s1 == -23204)
      {
        ((CTEntryMng)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.CTENTRY_MNG)).b(s2);
        ((MayknowRecommendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).b();
        notifyUI(112, bool1, new Object[] { Integer.valueOf(j), Integer.valueOf(s2) });
        return;
        l = n;
        continue;
        k = j;
        i = j;
        m = j;
        if (QLog.isColorLevel())
        {
          i = j;
          m = j;
          QLog.d("CommonSwitchTag", 2, String.format(Locale.getDefault(), "handleSetCommonSwitchFromDetailInfo invalidate account info [dwUin: %d, lUin: %d, account: %s]", new Object[] { Integer.valueOf(n), Long.valueOf(l), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() }));
          k = j;
        }
        i = k;
        bool1 = false;
      }
      else
      {
        notifyUI(86, bool1, new Object[] { Short.valueOf(s1), Short.valueOf(s2) });
        return;
        label651:
        j = i;
      }
    }
  }
  
  public int a()
  {
    int i = BaseApplicationImpl.getApplication().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).getInt("e_add_friend_setting", 101);
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "getSelfAddFriendSettingValue  settingValue:" + i);
    }
    return i;
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
  
  public ArrayList<CardProfile> a(int paramInt1, int paramInt2)
  {
    for (Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();; localObject1 = null)
    {
      label152:
      try
      {
        localObject2 = (ArrayList)((EntityManager)localObject1).query(CardProfile.class, true, "type=?", new String[] { String.valueOf(paramInt1) }, null, null, "lTime desc", String.valueOf(paramInt2));
        ((EntityManager)localObject1).close();
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
          ((EntityManager)localObject1).close();
          if (0 != 0) {
            break;
          }
          localObject1 = new ArrayList(0);
        }
      }
      finally
      {
        ((EntityManager)localObject1).close();
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
  
  public void a()
  {
    send(createToServiceMsg("MCardSvc.ReqGetCardSwitch"));
  }
  
  public void a(int paramInt)
  {
    EntityManager localEntityManager = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    localEntityManager.getTransaction().begin();
    try
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("delete from ");
      localStringBuilder.append(((CardProfile)CardProfile.class.newInstance()).getTableName());
      localStringBuilder.append(" where ");
      localStringBuilder.append("type=");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(";");
      localEntityManager.execSQL(localStringBuilder.toString());
      localEntityManager.getTransaction().commit();
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
      localEntityManager.getTransaction().end();
      localEntityManager.close();
    }
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "sendNotDisturbTime time=" + paramInt + " lastTime=" + paramString1 + " source_from" + paramString2);
    }
    try
    {
      oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
      localOIDBSSOPkg.uint32_command.set(1279);
      localOIDBSSOPkg.uint32_service_type.set(9);
      Object localObject = ByteBuffer.allocate(15);
      ((ByteBuffer)localObject).putInt(Utils.a(Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))).put((byte)0).putShort((short)1).putShort((short)27240).putShort((short)4).putInt(paramInt);
      localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
      localObject = createToServiceMsg("OidbSvc.0x4ff_9");
      ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
      ((ToServiceMsg)localObject).setTimeout(30000L);
      ((ToServiceMsg)localObject).extraData.putInt("no_disturb_time", paramInt);
      ((ToServiceMsg)localObject).extraData.putString("no_disturb_last_time", paramString1);
      ((ToServiceMsg)localObject).extraData.putString("source_from", paramString2);
      ((ToServiceMsg)localObject).extraData.putBoolean("from_send_no_disturb", true);
      ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (Exception paramString1)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.profilecard.", 2, "sendNotDisturbTime ex", paramString1);
    }
  }
  
  public void a(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "getEducationList " + paramLong);
    }
    Object localObject = new oidb_cmd0xd2d.ReqBody();
    ((oidb_cmd0xd2d.ReqBody)localObject).uint64_req_uin.set(paramLong);
    ((oidb_cmd0xd2d.ReqBody)localObject).uint32_req_category.set(0);
    localObject = makeOIDBPkg("OidbSvc.0xd2d", 3373, 1, ((oidb_cmd0xd2d.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).addAttribute("uin", Long.valueOf(paramLong));
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, String.format(Locale.getDefault(), "praiseLifeAchievement uin=%d achievementId=%d actionType=%d", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    Object localObject = new oidb_0xe5f.ReqBody();
    ((oidb_0xe5f.ReqBody)localObject).uint64_praiseuin.set(paramLong);
    ((oidb_0xe5f.ReqBody)localObject).uint32_achievement_id.set(paramInt1);
    ((oidb_0xe5f.ReqBody)localObject).uint32_actiontype.set(paramInt2);
    localObject = makeOIDBPkg("OidbSvc.0xe5f_2", 3679, 2, ((oidb_0xe5f.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putInt("life_achievement_praise_id_key", paramInt1);
    ((ToServiceMsg)localObject).extraData.putInt("life_achievement_praise_action_type_key", paramInt2);
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
  
  public void a(long paramLong, CardHandler.NowOnliveGallayCallback paramNowOnliveGallayCallback)
  {
    NowLiveGallary.ReqBody localReqBody = new NowLiveGallary.ReqBody();
    localReqBody.req_uin.set(paramLong);
    ProtoUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramNowOnliveGallayCallback, localReqBody.toByteArray(), "ilive.photo_wall");
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
      localObject2 = localObject1;
      if (((String)localObject1).trim().length() == 0) {
        localObject2 = String.valueOf(localVisitor.lUIN);
      }
      if (1 == paramPushVoteIncreaseInfo.iIncrement)
      {
        localMessageRecord.msg = String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getString(2131692665), new Object[] { localObject2 });
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(localMessageRecord, paramString1);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.handleReceivedMessage(1, true, true);
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("newVoteCount", paramPushVoteIncreaseInfo.iIncrement);
        ((Bundle)localObject1).putString("sender", paramString2);
        ((Bundle)localObject1).putString("voteeUin", paramString1);
        ((Bundle)localObject1).putString("uin", paramString1);
        notifyUI(28, true, new Object[] { ((FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()), localObject1 });
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
        localMessageRecord.msg = String.format(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext().getString(2131692664), new Object[] { localObject2, Integer.valueOf(paramPushVoteIncreaseInfo.iIncrement) });
      }
    }
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
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileApiITransFileController != null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileApiITransFileController.removeHandle(paramCardTransProcessorHandler);
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = new Oidb_0x66b.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (QLog.isColorLevel()) {
      QLog.d("NewNearbyMyTab", 2, "handleGetSimpleNearbyMyTab, result=" + i);
    }
    if (i == 0)
    {
      if (paramToServiceMsg.stPansocialInfo.has())
      {
        i = ((Oidb_0x66b.RspPansocialInfo)paramToServiceMsg.stPansocialInfo.get()).uint32_charmlevel.get();
        ((HotChatManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).a(i);
      }
      return;
    }
    notifyUI(65, false, null);
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
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileApiITransFileController != null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileApiITransFileController.transferAsync(localTransferRequest);
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
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.SummaryCard", 2, "deleteLbsPortrait() uin = " + paramString);
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "MCardSvc.ReqDelFace");
    localToServiceMsg.extraData.putLong("selfuin", Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    localToServiceMsg.extraData.putByteArray("filekey", paramArrayOfByte);
    localToServiceMsg.extraData.putLong("timestamp", paramLong);
    localToServiceMsg.extraData.putString("touin", paramString);
    send(localToServiceMsg);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qzonephotowall", 2, "getQzonePhotoWall uin:" + paramString1);
    }
    ToServiceMsg localToServiceMsg = createToServiceMsg("SQQzoneSvc.getPhotoWall");
    localToServiceMsg.addAttribute("uin", paramString1);
    localToServiceMsg.addAttribute("attachInfo", paramString2);
    send(localToServiceMsg);
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
  
  public void a(String paramString1, String paramString2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qzonephotowall", 2, "delQzonePhotoWall");
    }
    ToServiceMsg localToServiceMsg = createToServiceMsg("SQQzoneSvc.delPhotoWall");
    localToServiceMsg.addAttribute("uin", paramString1);
    localToServiceMsg.addAttribute("photo_id", paramString2);
    localToServiceMsg.addAttribute("photo_time", Long.valueOf(paramLong));
    send(localToServiceMsg);
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
    //   1: ifnull +82 -> 83
    //   4: aload_2
    //   5: invokeinterface 364 1 0
    //   10: ifle +73 -> 83
    //   13: aload_0
    //   14: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   17: invokevirtual 1646	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy;
    //   20: invokevirtual 1652	com/tencent/mobileqq/persistence/QQEntityManagerFactoryProxy:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   23: astore_1
    //   24: aload_1
    //   25: ifnull +58 -> 83
    //   28: aload_1
    //   29: invokevirtual 2803	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   32: invokevirtual 2808	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   35: aload_2
    //   36: invokeinterface 686 1 0
    //   41: astore_2
    //   42: aload_2
    //   43: invokeinterface 661 1 0
    //   48: ifeq +36 -> 84
    //   51: aload_1
    //   52: aload_2
    //   53: invokeinterface 665 1 0
    //   58: checkcast 1754	com/tencent/mobileqq/data/CardProfile
    //   61: invokevirtual 3186	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   64: goto -22 -> 42
    //   67: astore_2
    //   68: aload_2
    //   69: invokevirtual 835	java/lang/Exception:printStackTrace	()V
    //   72: aload_1
    //   73: invokevirtual 2803	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   76: invokevirtual 2830	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   79: aload_1
    //   80: invokevirtual 2360	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   83: return
    //   84: aload_1
    //   85: invokevirtual 2803	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   88: invokevirtual 2827	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   91: aload_1
    //   92: invokevirtual 2803	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   95: invokevirtual 2830	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   98: aload_1
    //   99: invokevirtual 2360	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   102: return
    //   103: astore_2
    //   104: aload_1
    //   105: invokevirtual 2803	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   108: invokevirtual 2830	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   111: aload_1
    //   112: invokevirtual 2360	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   115: aload_2
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	CardHandler
    //   0	117	1	paramString	String
    //   0	117	2	paramList	List<CardProfile>
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
  
  public void a(ArrayList<String> paramArrayList)
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
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.execute(new CardHandler.2(this));
  }
  
  public void a(ArrayList<AutoReplyText> paramArrayList, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if ((paramArrayList == null) || (((paramInt1 < 0) || (paramInt1 >= paramArrayList.size())) && (paramInt1 != 2147483647)))
    {
      QLog.d("CardHandler", 1, String.format("setAutoReplyList param error, replyList: %s, lastSelectId: %s", new Object[] { paramArrayList, Integer.valueOf(paramInt1) }));
      notifyUI(99, false, null);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, String.format("setAutoReplyList, selectIndex: %s, replyMsgList: %s, lastSelectId: %s, needNotify: %s", new Object[] { Integer.valueOf(paramInt1), paramArrayList, Integer.valueOf(paramInt2), Boolean.valueOf(paramBoolean) }));
    }
    Object localObject1 = new ArrayList();
    Object localObject2 = paramArrayList.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = (AutoReplyText)((Iterator)localObject2).next();
      if (((AutoReplyText)localObject3).getTextId() == 2147483647)
      {
        if (QLog.isColorLevel()) {
          QLog.d("CardHandler", 2, "setAutoReplyList, filter TEXT_NONE");
        }
      }
      else
      {
        localObject3 = MessageProtoCodec.a(((AutoReplyText)localObject3).getRawText(), null);
        if (localObject3 != null) {
          ((List)localObject1).add(localObject3);
        }
      }
    }
    localObject2 = new wording_storage.WordingCfg();
    if (paramInt1 == 2147483647)
    {
      ((wording_storage.WordingCfg)localObject2).auto_reply_flag.set(0);
      ((wording_storage.WordingCfg)localObject2).select_id.set(paramInt2);
    }
    for (;;)
    {
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
      ((wording_storage.WordingCfg)localObject2).auto_reply_flag.set(1);
      ((wording_storage.WordingCfg)localObject2).select_id.set(paramInt1);
    }
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
      while (!QLog.isColorLevel()) {}
      QLog.d("CommonSwitchTag", 2, "setCommonSwitchFromDetailInfo ex", localException);
    }
  }
  
  public void a(short paramShort, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "setTempConversationBlocState type=" + paramShort + " Block=" + paramBoolean);
    }
    try
    {
      oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
      localOIDBSSOPkg.uint32_command.set(1279);
      localOIDBSSOPkg.uint32_service_type.set(9);
      Object localObject = ByteBuffer.allocate(13);
      long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      short s = a(paramShort, paramBoolean);
      ((ByteBuffer)localObject).putInt(Utils.a(l)).put((byte)0).putShort((short)1).putShort(paramShort).putShort((short)2).putShort(s);
      localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
      localObject = createToServiceMsg("OidbSvc.0x4ff_9");
      ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
      ((ToServiceMsg)localObject).setTimeout(30000L);
      ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
      ((ToServiceMsg)localObject).extraData.putShort("type", paramShort);
      ((ToServiceMsg)localObject).extraData.putBoolean("tempConversationBlocState", true);
      ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("Q.profilecard.", 2, "setTempConversationBlocState ex", localException);
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
    localObject = createToServiceMsg("OidbSvc.0x491_100");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    ((ToServiceMsg)localObject).extraData.putBoolean("key_searchable", paramBoolean);
    ((ToServiceMsg)localObject).setTimeout(10000L);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    short s = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "sendHiddenSessionRequest open=" + paramBoolean);
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
          ((ByteBuffer)localObject).putInt(Utils.a(l)).put((byte)0).putShort((short)1).putShort((short)paramInt).putShort((short)2).putShort(s);
          localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
          localObject = createToServiceMsg("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
          ((ToServiceMsg)localObject).setTimeout(30000L);
          ((ToServiceMsg)localObject).extraData.putInt("type", paramInt);
          ((ToServiceMsg)localObject).extraData.putInt("hidden_session_switch", s);
          ((ToServiceMsg)localObject).extraData.putBoolean("from_send_hidden_session", true);
          ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
          sendPbReq((ToServiceMsg)localObject);
          return;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.", 2, "sendHiddenSessionRequest ex", localException);
      }
      s = 1;
    }
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.Avatar", 2, "uploadAvatarResult|isSuc = " + paramBoolean);
    }
    String str = FaceUtil.b();
    FaceUtil.a(null);
    Object localObject2;
    Object localObject1;
    if (paramBoolean)
    {
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      localObject1 = (Setting)((EntityManager)localObject2).find(Setting.class, paramString);
      if (localObject1 != null) {
        break label409;
      }
      localObject1 = new Setting();
      ((Setting)localObject1).uin = paramString;
      ((Setting)localObject1).bHeadType = 1;
      ((Setting)localObject1).bUsrType = 1;
      ((Setting)localObject1).updateTimestamp = System.currentTimeMillis();
      ((Setting)localObject1).headImgTimestamp = (((Setting)localObject1).updateTimestamp / 1000L);
      ((EntityManager)localObject2).persist((Entity)localObject1);
    }
    for (;;)
    {
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
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCustomFaceFilePath(false, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        FileUtils.e((String)localObject1);
      }
      localObject2 = FaceUtil.a(paramString);
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        FileUtils.e((String)localObject2);
      }
      localObject3 = FaceUtil.b(paramString);
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        FileUtils.e((String)localObject3);
      }
      FaceUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeFaceIconCache(1, paramString, 0);
      if (!TextUtils.isEmpty(str))
      {
        ImageUtil.a(null, str, (String)localObject1, 140, 140);
        FileUtils.d(str, (String)localObject2);
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.sendSelfQQHeadBroadcast(1, paramString, 0, (String)localObject1);
      }
      if (!TextUtils.isEmpty(str)) {
        FileUtils.e(str);
      }
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("uin", paramString);
      ((Bundle)localObject1).putInt("result", paramInt);
      notifyUI(8, paramBoolean, localObject1);
      return;
      label409:
      ((Setting)localObject1).bHeadType = 1;
      ((Setting)localObject1).updateTimestamp = System.currentTimeMillis();
      ((Setting)localObject1).headImgTimestamp = (((Setting)localObject1).updateTimestamp / 1000L);
      ((EntityManager)localObject2).update((Entity)localObject1);
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("MCardSvc.ReqSetCardSwitch");
    localToServiceMsg.extraData.putBoolean("modify_switch_for_near_people", paramBoolean1);
    Bundle localBundle = localToServiceMsg.extraData;
    if (paramBoolean2) {}
    for (long l = 0L;; l = 1L)
    {
      localBundle.putLong("target_value", l);
      send(localToServiceMsg);
      return;
    }
  }
  
  public boolean a()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    long l1 = ((SharedPreferences)localObject).getLong("sign_in_time_stamp", 0L);
    localObject = ((SharedPreferences)localObject).getString(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin() + "sign_in_info", "");
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
      if (!c()) {
        break label66;
      }
      f();
    }
    label66:
    while (!QLog.isColorLevel())
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("DailySignIn", 2, "getSignRedTouchShell time kill");
      }
      notifyUI(84, true, null);
      break;
    }
    QLog.i("DailySignIn", 2, "shouldResuestSignOperate false");
  }
  
  /* Error */
  public void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 10
    //   3: iconst_0
    //   4: istore 9
    //   6: iconst_0
    //   7: istore 11
    //   9: aload_2
    //   10: invokevirtual 101	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   13: ifeq +411 -> 424
    //   16: aload_3
    //   17: ifnull +407 -> 424
    //   20: iconst_1
    //   21: istore 5
    //   23: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +30 -> 56
    //   29: ldc 108
    //   31: iconst_2
    //   32: new 20	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   39: ldc_w 3411
    //   42: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: iload 5
    //   47: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   50: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: aload_0
    //   57: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   60: invokevirtual 211	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   63: pop
    //   64: iload 5
    //   66: istore 8
    //   68: iload 5
    //   70: ifeq +525 -> 595
    //   73: iload 5
    //   75: istore 6
    //   77: iload 5
    //   79: istore 7
    //   81: new 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   84: dup
    //   85: invokespecial 120	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   88: aload_3
    //   89: checkcast 122	[B
    //   92: checkcast 122	[B
    //   95: invokevirtual 126	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   98: checkcast 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   101: astore_2
    //   102: iload 5
    //   104: istore 6
    //   106: iload 5
    //   108: istore 7
    //   110: aload_2
    //   111: getfield 130	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   114: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   117: ifne +313 -> 430
    //   120: iconst_1
    //   121: istore 5
    //   123: iload 5
    //   125: istore 6
    //   127: iload 5
    //   129: istore 7
    //   131: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   134: ifeq +54 -> 188
    //   137: iload 5
    //   139: istore 6
    //   141: iload 5
    //   143: istore 7
    //   145: ldc 191
    //   147: iconst_2
    //   148: new 20	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   155: ldc_w 3413
    //   158: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: iload 5
    //   163: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   166: ldc_w 3415
    //   169: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: aload_2
    //   173: getfield 130	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   176: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   179: invokevirtual 398	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   182: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   188: iload 5
    //   190: istore 8
    //   192: iload 5
    //   194: ifeq +401 -> 595
    //   197: iload 5
    //   199: istore 6
    //   201: iload 5
    //   203: istore 7
    //   205: iload 5
    //   207: istore 8
    //   209: aload_2
    //   210: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   213: invokevirtual 146	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   216: ifeq +379 -> 595
    //   219: iload 5
    //   221: istore 6
    //   223: iload 5
    //   225: istore 7
    //   227: iload 5
    //   229: istore 8
    //   231: aload_2
    //   232: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   235: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   238: ifnull +357 -> 595
    //   241: iload 5
    //   243: istore 6
    //   245: iload 5
    //   247: istore 7
    //   249: aload_2
    //   250: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   253: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   256: invokevirtual 158	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   259: invokestatic 201	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   262: invokevirtual 204	java/nio/ByteBuffer:getInt	()I
    //   265: istore 4
    //   267: iload 4
    //   269: i2l
    //   270: lstore 12
    //   272: iload 4
    //   274: ifge +16 -> 290
    //   277: iload 4
    //   279: ldc_w 578
    //   282: iand
    //   283: i2l
    //   284: ldc2_w 579
    //   287: lor
    //   288: lstore 12
    //   290: iload 5
    //   292: istore 6
    //   294: iload 5
    //   296: istore 7
    //   298: aload_0
    //   299: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   302: invokevirtual 211	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   305: lload 12
    //   307: invokestatic 216	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   310: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   313: ifeq +123 -> 436
    //   316: iload 5
    //   318: istore 6
    //   320: iload 5
    //   322: istore 7
    //   324: aload_1
    //   325: getfield 240	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   328: ldc 242
    //   330: invokevirtual 248	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   333: istore 5
    //   335: iload 5
    //   337: istore 6
    //   339: iload 10
    //   341: istore 5
    //   343: iload 5
    //   345: istore 7
    //   347: iload 6
    //   349: istore 8
    //   351: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   354: ifeq +56 -> 410
    //   357: ldc 191
    //   359: iconst_2
    //   360: new 20	java/lang/StringBuilder
    //   363: dup
    //   364: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   367: ldc_w 3413
    //   370: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: iload 5
    //   375: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   378: ldc_w 259
    //   381: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: aload_1
    //   385: getfield 240	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   388: ldc 242
    //   390: invokevirtual 248	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   393: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   396: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   399: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   402: iload 6
    //   404: istore 8
    //   406: iload 5
    //   408: istore 7
    //   410: aload_0
    //   411: bipush 82
    //   413: iload 7
    //   415: iload 8
    //   417: invokestatic 179	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   420: invokevirtual 183	com/tencent/mobileqq/app/CardHandler:notifyUI	(IZLjava/lang/Object;)V
    //   423: return
    //   424: iconst_0
    //   425: istore 5
    //   427: goto -404 -> 23
    //   430: iconst_0
    //   431: istore 5
    //   433: goto -310 -> 123
    //   436: iconst_0
    //   437: istore 5
    //   439: iload 11
    //   441: istore 6
    //   443: goto -100 -> 343
    //   446: astore_2
    //   447: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   450: ifeq +13 -> 463
    //   453: ldc 191
    //   455: iconst_2
    //   456: ldc_w 3417
    //   459: aload_2
    //   460: invokestatic 188	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   463: iload 6
    //   465: istore 7
    //   467: iload 9
    //   469: istore 8
    //   471: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   474: ifeq -64 -> 410
    //   477: ldc 191
    //   479: iconst_2
    //   480: new 20	java/lang/StringBuilder
    //   483: dup
    //   484: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   487: ldc_w 3413
    //   490: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: iload 6
    //   495: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   498: ldc_w 259
    //   501: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: aload_1
    //   505: getfield 240	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   508: ldc 242
    //   510: invokevirtual 248	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   513: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   516: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   519: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   522: iload 6
    //   524: istore 7
    //   526: iload 9
    //   528: istore 8
    //   530: goto -120 -> 410
    //   533: astore_2
    //   534: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   537: ifeq +48 -> 585
    //   540: ldc 191
    //   542: iconst_2
    //   543: new 20	java/lang/StringBuilder
    //   546: dup
    //   547: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   550: ldc_w 3413
    //   553: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: iload 7
    //   558: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   561: ldc_w 259
    //   564: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: aload_1
    //   568: getfield 240	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   571: ldc 242
    //   573: invokevirtual 248	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   576: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   579: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   582: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   585: aload_2
    //   586: athrow
    //   587: astore_2
    //   588: iload 6
    //   590: istore 7
    //   592: goto -58 -> 534
    //   595: iload 8
    //   597: istore 5
    //   599: iload 11
    //   601: istore 6
    //   603: goto -260 -> 343
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	606	0	this	CardHandler
    //   0	606	1	paramToServiceMsg	ToServiceMsg
    //   0	606	2	paramFromServiceMsg	FromServiceMsg
    //   0	606	3	paramObject	Object
    //   265	18	4	i	int
    //   21	577	5	bool1	boolean
    //   75	527	6	bool2	boolean
    //   79	512	7	bool3	boolean
    //   66	530	8	bool4	boolean
    //   4	523	9	bool5	boolean
    //   1	339	10	bool6	boolean
    //   7	593	11	bool7	boolean
    //   270	36	12	l	long
    // Exception table:
    //   from	to	target	type
    //   81	102	446	java/lang/Exception
    //   110	120	446	java/lang/Exception
    //   131	137	446	java/lang/Exception
    //   145	188	446	java/lang/Exception
    //   209	219	446	java/lang/Exception
    //   231	241	446	java/lang/Exception
    //   249	267	446	java/lang/Exception
    //   298	316	446	java/lang/Exception
    //   324	335	446	java/lang/Exception
    //   81	102	533	finally
    //   110	120	533	finally
    //   131	137	533	finally
    //   145	188	533	finally
    //   209	219	533	finally
    //   231	241	533	finally
    //   249	267	533	finally
    //   298	316	533	finally
    //   324	335	533	finally
    //   447	463	587	finally
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
    Object localObject = makeOIDBPkg("OidbSvc.0xac6", 2758, 2, ((cmd0xac6.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putParcelableArrayList("medal_wall_list", paramArrayList);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void b(List<Long> paramList)
  {
    FileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin() + "_todayVoters", paramList);
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
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (paramBoolean == true)
        {
          ((ByteBuffer)localObject).putInt(Utils.a(l)).put((byte)0).putShort((short)1).putShort((short)-25042).putShort((short)2).putShort(s);
          localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
          localObject = createToServiceMsg("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
          ((ToServiceMsg)localObject).setTimeout(30000L);
          ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject).extraData.putBoolean("isGetLoginDays", false);
          ((ToServiceMsg)localObject).extraData.putBoolean("pcActiveState", true);
          ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
          sendPbReq((ToServiceMsg)localObject);
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
        Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNowLiveManager().a();
        int j = Integer.valueOf("" + ((String)localObject1).charAt(2)).intValue();
        localObject1 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1279);
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(9);
        Object localObject2 = ByteBuffer.allocate(19);
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (paramBoolean1 == true)
        {
          s = 0;
          ByteBuffer localByteBuffer = ((ByteBuffer)localObject2).putInt(Utils.a(l)).put((byte)0).putShort((short)2).putShort((short)-25217).putShort((short)2).putShort(s).putShort((short)-23476).putShort((short)2);
          if (j >= 2) {
            continue;
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
    return this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("task_entry_config" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).getBoolean("open", false);
  }
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DailySignIn", 2, "getSigninRedTouch svrType=" + paramInt);
    }
    cmd0x922.ReqBody localReqBody = new cmd0x922.ReqBody();
    SharedPreferences localSharedPreferences = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    localReqBody.uint64_timestamp.set(localSharedPreferences.getLong("sign_in_time_stamp", 0L));
    sendPbReq(makeOIDBPkg("OidbSvc.0x922", 2338, paramInt, localReqBody.toByteArray()));
  }
  
  public void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    bool6 = false;
    boolean bool7 = false;
    boolean bool1;
    boolean bool4;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool2 = true;
      if (QLog.isColorLevel()) {
        QLog.d("vip_pretty.CardHandler", 1, "handleSetPrettyTroopOwnerFlag success=" + bool2);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      bool1 = bool2;
      bool4 = bool7;
      if (bool2)
      {
        bool3 = bool2;
        bool5 = bool2;
      }
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        bool3 = bool2;
        bool5 = bool2;
        if (paramFromServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool2 = true;
        bool3 = bool2;
        bool5 = bool2;
        if (QLog.isColorLevel())
        {
          bool3 = bool2;
          bool5 = bool2;
          QLog.d("vip_pretty.CardHandler", 1, "handleSetPrettyTroopOwnerFlag result=" + bool2 + "resultCode=" + paramFromServiceMsg.uint32_result.get());
        }
        bool1 = bool2;
        bool4 = bool7;
        if (bool2)
        {
          bool1 = bool2;
          bool4 = bool7;
          bool3 = bool2;
          bool5 = bool2;
          if (paramFromServiceMsg.bytes_bodybuffer.has())
          {
            bool1 = bool2;
            bool4 = bool7;
            bool3 = bool2;
            bool5 = bool2;
            if (paramFromServiceMsg.bytes_bodybuffer.get() != null)
            {
              bool3 = bool2;
              bool5 = bool2;
              int i = ByteBuffer.wrap(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray()).getInt();
              long l = i;
              if (i < 0) {
                l = i & 0x7FFFFFFF | 0x80000000;
              }
              bool3 = bool2;
              bool5 = bool2;
              if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(String.valueOf(l))) {
                continue;
              }
              bool3 = bool2;
              bool5 = bool2;
              bool4 = paramToServiceMsg.extraData.getBoolean("switch");
              bool1 = true;
            }
          }
        }
        bool2 = bool1;
        bool5 = bool4;
        if (QLog.isColorLevel())
        {
          QLog.d("vip_pretty.CardHandler", 1, "handleSetPrettyTroopOwnerFlag result=" + bool1 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
          bool5 = bool4;
          bool2 = bool1;
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        bool5 = bool3;
        if (!QLog.isColorLevel()) {
          continue;
        }
        bool5 = bool3;
        QLog.d("vip_pretty.CardHandler", 1, "handleSetPrettyTroopOwnerFlag ex", paramFromServiceMsg);
        bool2 = bool3;
        bool5 = bool6;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("vip_pretty.CardHandler", 1, "handleSetPrettyTroopOwnerFlag result=" + bool3 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
        bool2 = bool3;
        bool5 = bool6;
        continue;
      }
      finally
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("vip_pretty.CardHandler", 1, "handleSetPrettyTroopOwnerFlag result=" + bool5 + ";allow=" + paramToServiceMsg.extraData.getBoolean("switch"));
      }
      notifyUI(109, bool2, Boolean.valueOf(bool5));
      return;
      bool2 = false;
      break;
      bool2 = false;
      continue;
      bool1 = false;
      bool4 = bool7;
    }
  }
  
  public void c(List<Long> paramList)
  {
    Object localObject = FileUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin() + "_todayVoters");
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
      QLog.i("CardHandler", 2, "setCareBarEnable: invoked.  enable: " + paramBoolean);
    }
    notifyUI(102, true, Boolean.valueOf(paramBoolean));
    for (;;)
    {
      try
      {
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.uint32_command.set(1279);
        localOIDBSSOPkg.uint32_service_type.set(9);
        Object localObject = ByteBuffer.allocate(13);
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (paramBoolean == true)
        {
          ((ByteBuffer)localObject).putInt(Utils.a(l)).put((byte)0).putShort((short)1).putShort((short)-23234).putShort((short)2).putShort(s);
          localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
          localObject = createToServiceMsg("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
          ((ToServiceMsg)localObject).setTimeout(30000L);
          ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
          sendPbReq((ToServiceMsg)localObject);
          return;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("CardHandler", 2, "setCareBarEnable: failed. ", localException);
      }
      s = 1;
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
      while (!QLog.isColorLevel()) {}
      QLog.w("CardHandler", 2, "send_oidb_0x5eb_40350 error", localException);
    }
  }
  
  public void d(int paramInt)
  {
    Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
    int i = ((SharedPreferences)localObject).getInt("e_add_friend_setting", 101);
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "handleGetSelfAddFriendSetting settingValue=" + paramInt + "  oldValue:" + i);
    }
    if (i != paramInt)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putInt("e_add_friend_setting", paramInt);
      ((SharedPreferences.Editor)localObject).commit();
    }
  }
  
  /* Error */
  public void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 10
    //   3: iconst_0
    //   4: istore 9
    //   6: iconst_0
    //   7: istore 11
    //   9: aload_2
    //   10: invokevirtual 101	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   13: ifeq +399 -> 412
    //   16: aload_3
    //   17: ifnull +395 -> 412
    //   20: iconst_1
    //   21: istore 5
    //   23: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +30 -> 56
    //   29: ldc 108
    //   31: iconst_2
    //   32: new 20	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   39: ldc_w 3536
    //   42: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: iload 5
    //   47: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   50: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: aload_0
    //   57: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   60: invokevirtual 211	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   63: pop
    //   64: iload 5
    //   66: istore 8
    //   68: iload 5
    //   70: ifeq +513 -> 583
    //   73: iload 5
    //   75: istore 6
    //   77: iload 5
    //   79: istore 7
    //   81: new 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   84: dup
    //   85: invokespecial 120	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   88: aload_3
    //   89: checkcast 122	[B
    //   92: checkcast 122	[B
    //   95: invokevirtual 126	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   98: checkcast 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   101: astore_2
    //   102: aload_2
    //   103: ifnull +315 -> 418
    //   106: iload 5
    //   108: istore 6
    //   110: iload 5
    //   112: istore 7
    //   114: aload_2
    //   115: getfield 130	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   118: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   121: ifne +297 -> 418
    //   124: iconst_1
    //   125: istore 5
    //   127: iload 5
    //   129: istore 6
    //   131: iload 5
    //   133: istore 7
    //   135: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   138: ifeq +38 -> 176
    //   141: iload 5
    //   143: istore 6
    //   145: iload 5
    //   147: istore 7
    //   149: ldc 191
    //   151: iconst_2
    //   152: new 20	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   159: ldc_w 3538
    //   162: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: iload 5
    //   167: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   170: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   176: iload 5
    //   178: istore 8
    //   180: iload 5
    //   182: ifeq +401 -> 583
    //   185: iload 5
    //   187: istore 6
    //   189: iload 5
    //   191: istore 7
    //   193: iload 5
    //   195: istore 8
    //   197: aload_2
    //   198: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   201: invokevirtual 146	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   204: ifeq +379 -> 583
    //   207: iload 5
    //   209: istore 6
    //   211: iload 5
    //   213: istore 7
    //   215: iload 5
    //   217: istore 8
    //   219: aload_2
    //   220: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   223: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   226: ifnull +357 -> 583
    //   229: iload 5
    //   231: istore 6
    //   233: iload 5
    //   235: istore 7
    //   237: aload_2
    //   238: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   241: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   244: invokevirtual 158	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   247: invokestatic 201	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   250: invokevirtual 204	java/nio/ByteBuffer:getInt	()I
    //   253: istore 4
    //   255: iload 4
    //   257: i2l
    //   258: lstore 12
    //   260: iload 4
    //   262: ifge +16 -> 278
    //   265: iload 4
    //   267: ldc_w 578
    //   270: iand
    //   271: i2l
    //   272: ldc2_w 579
    //   275: lor
    //   276: lstore 12
    //   278: iload 5
    //   280: istore 6
    //   282: iload 5
    //   284: istore 7
    //   286: aload_0
    //   287: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   290: invokevirtual 211	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   293: lload 12
    //   295: invokestatic 216	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   298: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   301: ifeq +123 -> 424
    //   304: iload 5
    //   306: istore 6
    //   308: iload 5
    //   310: istore 7
    //   312: aload_1
    //   313: getfield 240	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   316: ldc 242
    //   318: invokevirtual 248	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   321: istore 5
    //   323: iload 5
    //   325: istore 6
    //   327: iload 10
    //   329: istore 5
    //   331: iload 5
    //   333: istore 7
    //   335: iload 6
    //   337: istore 8
    //   339: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   342: ifeq +56 -> 398
    //   345: ldc 191
    //   347: iconst_2
    //   348: new 20	java/lang/StringBuilder
    //   351: dup
    //   352: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   355: ldc_w 3538
    //   358: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   361: iload 5
    //   363: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   366: ldc_w 259
    //   369: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: aload_1
    //   373: getfield 240	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   376: ldc 242
    //   378: invokevirtual 248	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   381: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   384: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   387: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   390: iload 6
    //   392: istore 8
    //   394: iload 5
    //   396: istore 7
    //   398: aload_0
    //   399: bipush 80
    //   401: iload 7
    //   403: iload 8
    //   405: invokestatic 179	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   408: invokevirtual 183	com/tencent/mobileqq/app/CardHandler:notifyUI	(IZLjava/lang/Object;)V
    //   411: return
    //   412: iconst_0
    //   413: istore 5
    //   415: goto -392 -> 23
    //   418: iconst_0
    //   419: istore 5
    //   421: goto -294 -> 127
    //   424: iconst_0
    //   425: istore 5
    //   427: iload 11
    //   429: istore 6
    //   431: goto -100 -> 331
    //   434: astore_2
    //   435: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   438: ifeq +13 -> 451
    //   441: ldc 191
    //   443: iconst_2
    //   444: ldc_w 3540
    //   447: aload_2
    //   448: invokestatic 188	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   451: iload 6
    //   453: istore 7
    //   455: iload 9
    //   457: istore 8
    //   459: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   462: ifeq -64 -> 398
    //   465: ldc 191
    //   467: iconst_2
    //   468: new 20	java/lang/StringBuilder
    //   471: dup
    //   472: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   475: ldc_w 3538
    //   478: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: iload 6
    //   483: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   486: ldc_w 259
    //   489: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: aload_1
    //   493: getfield 240	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   496: ldc 242
    //   498: invokevirtual 248	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   501: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   504: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   507: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   510: iload 6
    //   512: istore 7
    //   514: iload 9
    //   516: istore 8
    //   518: goto -120 -> 398
    //   521: astore_2
    //   522: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   525: ifeq +48 -> 573
    //   528: ldc 191
    //   530: iconst_2
    //   531: new 20	java/lang/StringBuilder
    //   534: dup
    //   535: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   538: ldc_w 3538
    //   541: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: iload 7
    //   546: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   549: ldc_w 259
    //   552: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   555: aload_1
    //   556: getfield 240	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   559: ldc 242
    //   561: invokevirtual 248	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   564: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   567: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   570: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   573: aload_2
    //   574: athrow
    //   575: astore_2
    //   576: iload 6
    //   578: istore 7
    //   580: goto -58 -> 522
    //   583: iload 8
    //   585: istore 5
    //   587: iload 11
    //   589: istore 6
    //   591: goto -260 -> 331
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	594	0	this	CardHandler
    //   0	594	1	paramToServiceMsg	ToServiceMsg
    //   0	594	2	paramFromServiceMsg	FromServiceMsg
    //   0	594	3	paramObject	Object
    //   253	18	4	i	int
    //   21	565	5	bool1	boolean
    //   75	515	6	bool2	boolean
    //   79	500	7	bool3	boolean
    //   66	518	8	bool4	boolean
    //   4	511	9	bool5	boolean
    //   1	327	10	bool6	boolean
    //   7	581	11	bool7	boolean
    //   258	36	12	l	long
    // Exception table:
    //   from	to	target	type
    //   81	102	434	java/lang/Exception
    //   114	124	434	java/lang/Exception
    //   135	141	434	java/lang/Exception
    //   149	176	434	java/lang/Exception
    //   197	207	434	java/lang/Exception
    //   219	229	434	java/lang/Exception
    //   237	255	434	java/lang/Exception
    //   286	304	434	java/lang/Exception
    //   312	323	434	java/lang/Exception
    //   81	102	521	finally
    //   114	124	521	finally
    //   135	141	521	finally
    //   149	176	521	finally
    //   197	207	521	finally
    //   219	229	521	finally
    //   237	255	521	finally
    //   286	304	521	finally
    //   312	323	521	finally
    //   435	451	575	finally
  }
  
  public void d(boolean paramBoolean)
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
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (paramBoolean == true)
        {
          ((ByteBuffer)localObject).putInt(Utils.a(l)).put((byte)0).putShort((short)1).putShort((short)-25181).putShort((short)2).putShort(s);
          localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
          localObject = createToServiceMsg("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
          ((ToServiceMsg)localObject).setTimeout(30000L);
          ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject).extraData.putBoolean("helloLiveMessage", true);
          ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
          sendPbReq((ToServiceMsg)localObject);
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
      while (!QLog.isColorLevel()) {}
      QLog.w("CardHandler", 2, "send_oidb_0x5eb_40350 error", localException);
    }
  }
  
  public void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool7 = true;
    boolean bool6 = true;
    boolean bool5 = false;
    boolean bool1;
    int i;
    int j;
    boolean bool2;
    boolean bool3;
    boolean bool4;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      i = paramToServiceMsg.extraData.getInt("hidden_session_switch", 0);
      j = paramToServiceMsg.extraData.getInt("type", 0);
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "handleHiddenSessionRes success=" + bool1 + " type=" + j + " open=" + i);
      }
      bool2 = bool1;
      if (!bool1) {
        break label810;
      }
      bool3 = bool1;
      bool4 = bool1;
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        long l;
        if (paramToServiceMsg != null)
        {
          bool3 = bool1;
          bool4 = bool1;
          if (paramToServiceMsg.uint32_result.get() == 0)
          {
            bool1 = true;
            bool3 = bool1;
            bool4 = bool1;
            if (QLog.isColorLevel())
            {
              bool3 = bool1;
              bool4 = bool1;
              QLog.d("Q.profilecard.", 2, "handleHiddenSessionRes result=" + bool1);
            }
            bool2 = bool1;
            if (!bool1) {
              break label810;
            }
            bool3 = bool1;
            bool4 = bool1;
            bool2 = bool1;
            if (!paramToServiceMsg.bytes_bodybuffer.has()) {
              break label810;
            }
            bool3 = bool1;
            bool4 = bool1;
            bool2 = bool1;
            if (paramToServiceMsg.bytes_bodybuffer.get() == null) {
              break label810;
            }
            bool3 = bool1;
            bool4 = bool1;
            l = Utils.a(ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray()).getInt());
            bool3 = bool1;
            bool4 = bool1;
            if (!this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(String.valueOf(l))) {
              continue;
            }
            bool2 = bool1;
            if (i < 0) {
              break label810;
            }
            if (j != 42318) {
              continue;
            }
            bool3 = bool1;
            bool4 = bool1;
            paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
            bool3 = bool1;
            bool4 = bool1;
            paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext();
            if (i == 1) {
              continue;
            }
            bool2 = bool6;
            bool3 = bool1;
            bool4 = bool1;
            HiddenChatUtil.a(paramToServiceMsg, paramFromServiceMsg, bool2);
            bool2 = bool1;
            return;
            bool1 = false;
            break;
          }
        }
        bool1 = false;
        continue;
        bool2 = false;
        continue;
        bool2 = bool1;
        if (j == 42319)
        {
          bool3 = bool1;
          bool4 = bool1;
          paramToServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin();
          bool3 = bool1;
          bool4 = bool1;
          paramFromServiceMsg = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext();
          if (i != 1)
          {
            bool2 = bool7;
            bool3 = bool1;
            bool4 = bool1;
            HiddenChatUtil.b(paramToServiceMsg, paramFromServiceMsg, bool2);
            bool2 = bool1;
            continue;
            bool2 = bool5;
            bool3 = bool1;
            bool4 = bool1;
            if (!QLog.isColorLevel()) {
              continue;
            }
            bool3 = bool1;
            bool4 = bool1;
            QLog.d("Q.profilecard.", 2, "handleHiddenSessionRes cur:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() + " dwUin:" + l);
            bool2 = bool5;
          }
        }
        else
        {
          continue;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        bool4 = bool3;
        if (QLog.isColorLevel())
        {
          bool4 = bool3;
          QLog.d("Q.profilecard.", 2, "handleHiddenSessionRes ex", paramToServiceMsg);
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.", 2, "handleHiddenSessionRes result=" + false + ";open=" + i + " type=" + j);
        }
        notifyUI(108, false, Integer.valueOf(j));
        return;
      }
      finally
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.", 2, "handleHiddenSessionRes result=" + bool4 + ";open=" + i + " type=" + j);
        }
        notifyUI(108, bool4, Integer.valueOf(j));
      }
      label810:
      bool2 = false;
    }
  }
  
  public void e(boolean paramBoolean)
  {
    short s = 1;
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "setShowPushNotice open=" + paramBoolean);
    }
    try
    {
      oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
      localOIDBSSOPkg.uint32_command.set(1279);
      localOIDBSSOPkg.uint32_service_type.set(this.jdField_a_of_type_Short);
      Object localObject = ByteBuffer.allocate(13);
      long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if (paramBoolean) {
        s = 0;
      }
      ((ByteBuffer)localObject).putInt(Utils.a(l)).put((byte)0).putShort((short)1).putShort((short)-23332).putShort((short)2).putShort(s);
      localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
      localObject = createToServiceMsg("OidbSvc.0x4ff_9");
      ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
      ((ToServiceMsg)localObject).setTimeout(30000L);
      ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
      ((ToServiceMsg)localObject).extraData.putBoolean("uint32_req_push_notice_flag", true);
      ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
      if (QLog.isColorLevel()) {
        QLog.d("PushNotise", 2, "type -23332open :" + s);
      }
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (Exception localException)
    {
      QLog.d("Q.profilecard.", 2, localException, new Object[0]);
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
    //   4: ifeq +431 -> 435
    //   7: aload_3
    //   8: ifnull +427 -> 435
    //   11: iconst_1
    //   12: istore 5
    //   14: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   17: ifeq +30 -> 47
    //   20: ldc 191
    //   22: iconst_2
    //   23: new 20	java/lang/StringBuilder
    //   26: dup
    //   27: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   30: ldc_w 3576
    //   33: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: iload 5
    //   38: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   41: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   44: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   47: aload_1
    //   48: getfield 240	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   51: ldc_w 2885
    //   54: ldc_w 479
    //   57: invokevirtual 483	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   60: astore_2
    //   61: aload_1
    //   62: getfield 240	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   65: ldc_w 477
    //   68: ldc_w 479
    //   71: invokevirtual 483	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   74: astore 11
    //   76: iload 5
    //   78: istore 6
    //   80: iload 5
    //   82: ifeq +280 -> 362
    //   85: iload 5
    //   87: istore 7
    //   89: iload 5
    //   91: istore 8
    //   93: new 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   96: dup
    //   97: invokespecial 120	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   100: aload_3
    //   101: checkcast 122	[B
    //   104: checkcast 122	[B
    //   107: invokevirtual 126	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   110: checkcast 119	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   113: astore_3
    //   114: aload_3
    //   115: ifnull +326 -> 441
    //   118: iload 5
    //   120: istore 7
    //   122: iload 5
    //   124: istore 8
    //   126: aload_3
    //   127: getfield 130	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   130: invokevirtual 135	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   133: ifne +308 -> 441
    //   136: iconst_1
    //   137: istore 5
    //   139: iload 5
    //   141: istore 7
    //   143: iload 5
    //   145: istore 8
    //   147: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   150: ifeq +38 -> 188
    //   153: iload 5
    //   155: istore 7
    //   157: iload 5
    //   159: istore 8
    //   161: ldc 191
    //   163: iconst_2
    //   164: new 20	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   171: ldc_w 3578
    //   174: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: iload 5
    //   179: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   182: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   188: iload 5
    //   190: istore 6
    //   192: iload 5
    //   194: ifeq +168 -> 362
    //   197: iload 5
    //   199: istore 6
    //   201: iload 5
    //   203: istore 7
    //   205: iload 5
    //   207: istore 8
    //   209: aload_3
    //   210: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   213: invokevirtual 146	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   216: ifeq +146 -> 362
    //   219: iload 5
    //   221: istore 6
    //   223: iload 5
    //   225: istore 7
    //   227: iload 5
    //   229: istore 8
    //   231: aload_3
    //   232: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   235: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   238: ifnull +124 -> 362
    //   241: iload 5
    //   243: istore 7
    //   245: iload 5
    //   247: istore 8
    //   249: aload_3
    //   250: getfield 141	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   253: invokevirtual 149	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   256: invokevirtual 158	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   259: invokestatic 201	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   262: invokevirtual 204	java/nio/ByteBuffer:getInt	()I
    //   265: invokestatic 545	com/tencent/mobileqq/util/Utils:a	(I)J
    //   268: lstore 9
    //   270: iload 5
    //   272: istore 7
    //   274: iload 5
    //   276: istore 8
    //   278: aload_0
    //   279: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   282: invokevirtual 211	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   285: lload 9
    //   287: invokestatic 216	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   290: invokevirtual 219	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   293: ifeq +154 -> 447
    //   296: iload 5
    //   298: istore 7
    //   300: iload 5
    //   302: istore 8
    //   304: aload_1
    //   305: getfield 240	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   308: ldc_w 2883
    //   311: ldc_w 578
    //   314: invokevirtual 3548	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   317: istore 4
    //   319: iload 5
    //   321: istore 6
    //   323: iload 4
    //   325: iflt +37 -> 362
    //   328: iload 5
    //   330: istore 7
    //   332: iload 5
    //   334: istore 8
    //   336: aload_0
    //   337: getfield 77	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentCommonAppAppInterface	Lcom/tencent/common/app/AppInterface;
    //   340: invokevirtual 458	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   343: invokevirtual 464	mqq/app/MobileQQ:getApplicationContext	()Landroid/content/Context;
    //   346: aconst_null
    //   347: ldc_w 492
    //   350: ldc_w 494
    //   353: iload 4
    //   355: invokestatic 500	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:writeValueForInt	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   358: iload 5
    //   360: istore 6
    //   362: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   365: ifeq +48 -> 413
    //   368: ldc 191
    //   370: iconst_2
    //   371: new 20	java/lang/StringBuilder
    //   374: dup
    //   375: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   378: ldc_w 3578
    //   381: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: iload 6
    //   386: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   389: ldc_w 259
    //   392: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: aload_1
    //   396: getfield 240	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   399: ldc 242
    //   401: invokevirtual 248	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   404: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   407: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   410: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   413: aload_0
    //   414: bipush 96
    //   416: iload 6
    //   418: iconst_2
    //   419: anewarray 213	java/lang/String
    //   422: dup
    //   423: iconst_0
    //   424: aload_2
    //   425: aastore
    //   426: dup
    //   427: iconst_1
    //   428: aload 11
    //   430: aastore
    //   431: invokevirtual 183	com/tencent/mobileqq/app/CardHandler:notifyUI	(IZLjava/lang/Object;)V
    //   434: return
    //   435: iconst_0
    //   436: istore 5
    //   438: goto -424 -> 14
    //   441: iconst_0
    //   442: istore 5
    //   444: goto -305 -> 139
    //   447: iload 5
    //   449: istore 7
    //   451: iload 5
    //   453: istore 8
    //   455: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   458: ifeq +54 -> 512
    //   461: iload 5
    //   463: istore 7
    //   465: iload 5
    //   467: istore 8
    //   469: ldc 191
    //   471: iconst_2
    //   472: new 20	java/lang/StringBuilder
    //   475: dup
    //   476: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   479: ldc_w 3580
    //   482: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: aload_0
    //   486: getfield 75	com/tencent/mobileqq/app/CardHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   489: invokevirtual 211	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   492: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: ldc_w 552
    //   498: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   501: lload 9
    //   503: invokevirtual 331	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   506: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   509: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   512: iconst_0
    //   513: istore 6
    //   515: goto -153 -> 362
    //   518: astore_3
    //   519: iload 7
    //   521: istore 8
    //   523: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   526: ifeq +17 -> 543
    //   529: iload 7
    //   531: istore 8
    //   533: ldc 191
    //   535: iconst_2
    //   536: ldc_w 3582
    //   539: aload_3
    //   540: invokestatic 188	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   543: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   546: ifeq +47 -> 593
    //   549: ldc 191
    //   551: iconst_2
    //   552: new 20	java/lang/StringBuilder
    //   555: dup
    //   556: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   559: ldc_w 3578
    //   562: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   565: iconst_0
    //   566: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   569: ldc_w 259
    //   572: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   575: aload_1
    //   576: getfield 240	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   579: ldc 242
    //   581: invokevirtual 248	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   584: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   587: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   590: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   593: aload_0
    //   594: bipush 96
    //   596: iconst_0
    //   597: iconst_2
    //   598: anewarray 213	java/lang/String
    //   601: dup
    //   602: iconst_0
    //   603: aload_2
    //   604: aastore
    //   605: dup
    //   606: iconst_1
    //   607: aload 11
    //   609: aastore
    //   610: invokevirtual 183	com/tencent/mobileqq/app/CardHandler:notifyUI	(IZLjava/lang/Object;)V
    //   613: return
    //   614: astore_3
    //   615: invokestatic 106	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   618: ifeq +48 -> 666
    //   621: ldc 191
    //   623: iconst_2
    //   624: new 20	java/lang/StringBuilder
    //   627: dup
    //   628: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   631: ldc_w 3578
    //   634: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   637: iload 8
    //   639: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   642: ldc_w 259
    //   645: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   648: aload_1
    //   649: getfield 240	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   652: ldc 242
    //   654: invokevirtual 248	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   657: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   660: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   663: invokestatic 117	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   666: aload_0
    //   667: bipush 96
    //   669: iload 8
    //   671: iconst_2
    //   672: anewarray 213	java/lang/String
    //   675: dup
    //   676: iconst_0
    //   677: aload_2
    //   678: aastore
    //   679: dup
    //   680: iconst_1
    //   681: aload 11
    //   683: aastore
    //   684: invokevirtual 183	com/tencent/mobileqq/app/CardHandler:notifyUI	(IZLjava/lang/Object;)V
    //   687: aload_3
    //   688: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	689	0	this	CardHandler
    //   0	689	1	paramToServiceMsg	ToServiceMsg
    //   0	689	2	paramFromServiceMsg	FromServiceMsg
    //   0	689	3	paramObject	Object
    //   317	37	4	i	int
    //   12	454	5	bool1	boolean
    //   78	436	6	bool2	boolean
    //   87	443	7	bool3	boolean
    //   91	579	8	bool4	boolean
    //   268	234	9	l	long
    //   74	608	11	str	String
    // Exception table:
    //   from	to	target	type
    //   93	114	518	java/lang/Exception
    //   126	136	518	java/lang/Exception
    //   147	153	518	java/lang/Exception
    //   161	188	518	java/lang/Exception
    //   209	219	518	java/lang/Exception
    //   231	241	518	java/lang/Exception
    //   249	270	518	java/lang/Exception
    //   278	296	518	java/lang/Exception
    //   304	319	518	java/lang/Exception
    //   336	358	518	java/lang/Exception
    //   455	461	518	java/lang/Exception
    //   469	512	518	java/lang/Exception
    //   93	114	614	finally
    //   126	136	614	finally
    //   147	153	614	finally
    //   161	188	614	finally
    //   209	219	614	finally
    //   231	241	614	finally
    //   249	270	614	finally
    //   278	296	614	finally
    //   304	319	614	finally
    //   336	358	614	finally
    //   455	461	614	finally
    //   469	512	614	finally
    //   523	529	614	finally
    //   533	543	614	finally
  }
  
  public void f(boolean paramBoolean)
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
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (paramBoolean)
        {
          ((ByteBuffer)localObject).putInt(Utils.a(l)).put((byte)0).putShort((short)1).putShort((short)-25186).putShort((short)2).putShort(s);
          localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
          localObject = createToServiceMsg("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
          ((ToServiceMsg)localObject).setTimeout(30000L);
          ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject).extraData.putBoolean("isSetPartakeLikeRankingList", true);
          ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
          sendPbReq((ToServiceMsg)localObject);
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
      while (!QLog.isColorLevel()) {}
      QLog.w("CardHandler", 2, "send_oidb_0x5eb_42092 error", localException);
    }
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
        break label538;
      }
      bool2 = bool1;
      bool3 = bool1;
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
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
          break label538;
        }
        bool2 = bool1;
        bool3 = bool1;
        bool4 = bool1;
        if (!paramFromServiceMsg.bytes_bodybuffer.has()) {
          break label538;
        }
        bool2 = bool1;
        bool3 = bool1;
        bool4 = bool1;
        if (paramFromServiceMsg.bytes_bodybuffer.get() == null) {
          break label538;
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
        bool1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin().equals(String.valueOf(l));
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
      notifyUI(81, bool3, null);
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
      label538:
      bool1 = bool4;
    }
  }
  
  public void g(boolean paramBoolean)
  {
    short s = 0;
    QLog.e("vip_pretty.CardHandler", 1, "setPrettyTroopOwnerFlag OPEN=" + paramBoolean);
    for (;;)
    {
      try
      {
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.uint32_command.set(1279);
        localOIDBSSOPkg.uint32_service_type.set(this.jdField_a_of_type_Short);
        localOIDBSSOPkg.str_client_version.set(AppSetting.f());
        Object localObject = ByteBuffer.allocate(13);
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (paramBoolean)
        {
          ((ByteBuffer)localObject).putInt(Utils.a(l)).put((byte)0).putShort((short)1).putShort((short)-23211).putShort((short)2).putShort(s);
          localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
          localObject = createToServiceMsg("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
          ((ToServiceMsg)localObject).setTimeout(30000L);
          ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject).extraData.putBoolean("setPrettyTroopOwnerFlag", true);
          ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
          sendPbReq((ToServiceMsg)localObject);
          return;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.", 2, "setPrettyTroopOwnerFlag ex", localException);
      }
      s = 1;
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
      this.allowCmdSet.add("SQQzoneSvc.getPhotoWall");
      this.allowCmdSet.add("SQQzoneSvc.delPhotoWall");
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
      this.allowCmdSet.add("OidbSvc.0xe5f_2");
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
      while (!QLog.isColorLevel()) {}
      QLog.d("CardHandler", 2, "getConnectionsSwitch ex", localException);
    }
  }
  
  public void h(boolean paramBoolean)
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
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (paramBoolean)
        {
          ((ByteBuffer)localObject).putInt(Utils.a(l)).put((byte)0).putShort((short)1).putShort((short)-23444).putShort((short)2).putShort(s);
          localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
          localObject = createToServiceMsg("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
          ((ToServiceMsg)localObject).setTimeout(30000L);
          ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject).extraData.putBoolean("isSetNotifyOnLikeRankingList", true);
          ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
          sendPbReq((ToServiceMsg)localObject);
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
      while (!QLog.isColorLevel()) {}
      QLog.d("CardHandler", 2, "getHiddenSwitch ex", localException);
    }
  }
  
  public void i(boolean paramBoolean)
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
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (paramBoolean == true)
        {
          ((ByteBuffer)localObject).putInt(Utils.a(l)).put((byte)0).putShort((short)1).putShort((short)-25044).putShort((short)2).putShort(s);
          localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
          localObject = createToServiceMsg("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
          ((ToServiceMsg)localObject).setTimeout(30000L);
          ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject).extraData.putBoolean("isSetLoginDays", true);
          ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
          sendPbReq((ToServiceMsg)localObject);
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
      while (!QLog.isColorLevel()) {}
      QLog.d("CardHandler", 2, "sendGlobalRingIdRequest ex ", localException);
    }
  }
  
  public void j(boolean paramBoolean)
  {
    short s = 1;
    QLog.d("Q.profilecard.", 1, "setCalReactiveSwitch OPEN=" + paramBoolean);
    for (;;)
    {
      try
      {
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.uint32_command.set(1279);
        localOIDBSSOPkg.uint32_service_type.set(this.jdField_a_of_type_Short);
        Object localObject = ByteBuffer.allocate(13);
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (paramBoolean == true)
        {
          ((ByteBuffer)localObject).putInt(Utils.a(l)).put((byte)0).putShort((short)1).putShort((short)-25007).putShort((short)2).putShort(s);
          localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
          localObject = createToServiceMsg("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
          ((ToServiceMsg)localObject).setTimeout(30000L);
          ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject).extraData.putBoolean("isSetCalReactiveDays", true);
          ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
          sendPbReq((ToServiceMsg)localObject);
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
      while (!QLog.isColorLevel()) {}
      QLog.d("CardHandler", 2, "getNotDisturb ex", localException);
    }
  }
  
  public void k(boolean paramBoolean)
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
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (paramBoolean)
        {
          ((ByteBuffer)localObject).putInt(Utils.a(l)).put((byte)0).putShort((short)1).putShort(this.jdField_b_of_type_Short).putShort((short)2).putShort(s);
          localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
          localObject = createToServiceMsg("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
          ((ToServiceMsg)localObject).setTimeout(30000L);
          ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject).extraData.putBoolean("uint32_req_medalwall_flag", true);
          ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
          sendPbReq((ToServiceMsg)localObject);
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
  
  public void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "getSelfAddFriendSetting");
    }
    try
    {
      Object localObject = new oidb_0x5eb.ReqBody();
      long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      ((oidb_0x5eb.ReqBody)localObject).rpt_uint64_uins.add(Long.valueOf(l));
      ((oidb_0x5eb.ReqBody)localObject).uint32_req_allow.set(1);
      localObject = makeOIDBPkg("OidbSvc.0x5eb_22", 1515, 22, ((oidb_0x5eb.ReqBody)localObject).toByteArray());
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("uint32_req_allow", true);
      localBundle.putString("reqUin", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      ((ToServiceMsg)localObject).extraData.putAll(localBundle);
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("CardHandler", 2, "getSelfAddFriendSetting ex", localException);
    }
  }
  
  public void l(boolean paramBoolean)
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
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (paramBoolean == true)
        {
          ((ByteBuffer)localObject).putInt(Utils.a(l)).put((byte)0).putShort((short)1).putShort((short)-25031).putShort((short)2).putShort(s);
          localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
          localObject = createToServiceMsg("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
          ((ToServiceMsg)localObject).setTimeout(30000L);
          ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject).extraData.putBoolean("isSetActivateFriend", true);
          ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
          sendPbReq((ToServiceMsg)localObject);
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
  
  public void m()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("MedalWallMng", 4, "getSelfNewObtainedMedalWall");
    }
    try
    {
      l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
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
      localObject = makeOIDBPkg("OidbSvc.0x7a8", 1960, 5, ((cmd0x7a8.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("from", "getSelfNewObtainedMedalWall");
      sendPbReq((ToServiceMsg)localObject);
    }
  }
  
  public void m(boolean paramBoolean)
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
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (paramBoolean == true)
        {
          ((ByteBuffer)localObject).putInt(Utils.a(l)).put((byte)0).putShort((short)1).putShort((short)-25008).putShort((short)2).putShort(s);
          localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
          localObject = createToServiceMsg("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
          ((ToServiceMsg)localObject).setTimeout(30000L);
          ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject).extraData.putBoolean("isSetBabyQSwitch", true);
          ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
          sendPbReq((ToServiceMsg)localObject);
          if (paramBoolean) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0).edit().putInt("babyQ_drag_count", 0).commit();
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
  
  public void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, String.format(Locale.getDefault(), "getBindPhoneCardExtInfo uin:" + this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin(), new Object[0]));
    }
    sendPbReq(makeOIDBPkg("OidbSvc.0xc33_42220", 3123, 0, new oidb_0xc33.ReqBody().toByteArray()));
  }
  
  public void n(boolean paramBoolean)
  {
    short s = 1;
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "setDisplayThirdQQSwitch OPEN=" + paramBoolean);
    }
    try
    {
      long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if (paramBoolean == true) {
        s = 0;
      }
      Object localObject = new byte[13];
      PkgTools.DWord2Byte((byte[])localObject, 0, l);
      localObject[4] = 0;
      PkgTools.Word2Byte((byte[])localObject, 5, (short)1);
      PkgTools.DWordTo2Bytes((byte[])localObject, 7, 40348);
      PkgTools.Word2Byte((byte[])localObject, 9, (short)2);
      PkgTools.Word2Byte((byte[])localObject, 11, s);
      localObject = makeOIDBPkg("OidbSvc.0x4ff_9", 1279, 9, (byte[])localObject);
      ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
      ((ToServiceMsg)localObject).extraData.putBoolean("isSetDisplayThirdQQSwitch", true);
      ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      notifyUI(81, false, null);
    }
  }
  
  public void o()
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
  
  public void o(boolean paramBoolean)
  {
    short s = 0;
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "setAllowStrangerInviteToGroupSwitch OPEN=" + paramBoolean);
    }
    for (;;)
    {
      try
      {
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.uint32_command.set(1279);
        localOIDBSSOPkg.uint32_service_type.set(this.jdField_a_of_type_Short);
        Object localObject = ByteBuffer.allocate(13);
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        if (paramBoolean)
        {
          ((ByteBuffer)localObject).putInt(Utils.a(l)).put((byte)0).putShort((short)1).putShort((short)-23282).putShort((short)2).putShort(s);
          localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
          localObject = createToServiceMsg("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
          ((ToServiceMsg)localObject).setTimeout(30000L);
          ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject).extraData.putBoolean("StrangerInviteToGroup", true);
          ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
          sendPbReq((ToServiceMsg)localObject);
          return;
        }
      }
      catch (Exception localException)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.", 2, "setAllowStrangerInviteToGroupSwitch ex", localException);
      }
      s = 1;
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
    if (QLog.isColorLevel()) {
      QLog.d("vip_ptt.CardHandler", 2, "setPttAuToTextOffLineSwitch:" + UIUtils.a(30));
    }
    for (;;)
    {
      try
      {
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.uint32_command.set(3466);
        localOIDBSSOPkg.uint32_service_type.set(21);
        localOIDBSSOPkg.uint32_result.set(0);
        Object localObject1 = new cmd0xd8a.ReqBody();
        ((cmd0xd8a.ReqBody)localObject1).uint64_uin.set(l);
        Object localObject2 = ((cmd0xd8a.ReqBody)localObject1).uint32_cmd;
        if (paramBoolean)
        {
          i = 101;
          ((PBUInt32Field)localObject2).set(i);
          localObject2 = new cmd0xd8a.ClientInfo();
          ((cmd0xd8a.ClientInfo)localObject2).uint32_implat.set(109);
          ((cmd0xd8a.ClientInfo)localObject2).string_clientver.set(AppSetting.f());
          ((cmd0xd8a.ReqBody)localObject1).client_info.set((MessageMicro)localObject2);
          localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0xd8a.ReqBody)localObject1).toByteArray()));
          localObject1 = createToServiceMsg("OidbSvc.0xd8a");
          ((ToServiceMsg)localObject1).putWupBuffer(localOIDBSSOPkg.toByteArray());
          ((ToServiceMsg)localObject1).setTimeout(30000L);
          ((ToServiceMsg)localObject1).extraData.putBoolean("uint32_auto_to_text_flag", paramBoolean);
          sendPbReq((ToServiceMsg)localObject1);
          return;
        }
      }
      catch (Exception localException)
      {
        int i;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("vip_ptt.CardHandler", 1, "setMedalSwitch ex", localException);
      }
      i = 102;
    }
  }
  
  public void q(boolean paramBoolean)
  {
    short s = 0;
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
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("CardHandler", 1, "setEmotionRecommendSwitch ex", localException);
      }
      s = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.CardHandler
 * JD-Core Version:    0.7.0.1
 */
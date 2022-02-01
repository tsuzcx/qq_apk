import AccostSvc.Msg;
import AccostSvc.RespClientMsg;
import NS_COMM.COMM.Entry;
import NS_COMM.COMM.StCommonExt;
import NS_MINI_APP_MISC.MISC.StGetFriendPlayListV2Rsp;
import NS_MINI_INTERFACE.INTERFACE.StGetUserAppListRsp;
import NS_MINI_INTERFACE.INTERFACE.StUserAppInfo;
import NS_MOBILE_MAIN_PAGE.mobile_sub_get_cover_rsp;
import NS_MOBILE_MAIN_PAGE.mobile_sub_get_photo_wall_rsp;
import QQService.CARDSETTYPE;
import QQService.EVIPSPEC;
import QQService.FaceInfo;
import QQService.Intro;
import QQService.MakeFriendsCard;
import QQService.PrivilegeBaseInfo;
import QQService.PrivilegeInfo;
import QQService.PushVoteIncreaseInfo;
import QQService.RespDelFace;
import QQService.RespDeleteVisitorRecord;
import QQService.RespFavorite;
import QQService.RespGetCardSwitch;
import QQService.RespGetFavoriteList;
import QQService.RespGetVoterList;
import QQService.RespHYMakeFriendsCard;
import QQService.RespSetCard;
import QQService.RespSetCardSwitch;
import QQService.UserCntlData;
import QQService.UserProfile;
import QQService.VipBaseInfo;
import QQService.VipOpenInfo;
import QQService.Visitor;
import SummaryCard.AddFrdSrcInfo;
import SummaryCard.AlbumInfo;
import SummaryCard.BindPhoneInfo;
import SummaryCard.DateCard;
import SummaryCard.QQApolloInfo;
import SummaryCard.RespSummaryCard;
import SummaryCard.TCoverInfo;
import SummaryCard.TMedalWallInfo;
import SummaryCard.TNowBroadcastInfo;
import SummaryCardTaf.SSummaryCardLableRsp;
import SummaryCardTaf.SSummaryCardRsp;
import SummaryCardTaf.STRecommendInfo;
import SummaryCardTaf.SUserLabel;
import SummaryCardTaf.cardDiyComplicatedInfo;
import SummaryCardTaf.cardDiyTextInfo;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.CardHandler.1;
import com.tencent.mobileqq.app.CardHandler.2;
import com.tencent.mobileqq.app.CardHandler.4;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.AutoReplyText;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.CardProfile;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.KplCard;
import com.tencent.mobileqq.data.LikeRankingInfo;
import com.tencent.mobileqq.data.MedalInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.QZoneCover;
import com.tencent.mobileqq.data.QZonePhotoWall;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.medalwall.MedalID;
import com.tencent.mobileqq.medalwall.MedalWallMng;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
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
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabel;
import com.tencent.mobileqq.profile.ProfileLabelInfo;
import com.tencent.mobileqq.service.lbs.BusinessBuff;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.vas.VasExtensionHandler;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.pb.extendfriend.GetExtendFriendInfo.RspBody;
import com.tencent.pb.extendfriend.GetExtendFriendInfo.schoolInfo;
import com.tencent.pb.personal.PersonalInfo.ReqBody;
import com.tencent.pb.profilecard.SummaryCardBusiEntry.Color;
import com.tencent.pb.profilecard.SummaryCardBusiEntry.CommonReq;
import com.tencent.pb.profilecard.SummaryCardBusiEntry.Label;
import com.tencent.pb.profilecard.SummaryCardBusiEntry.VisitorCountReq;
import com.tencent.pb.profilecard.SummaryCardBusiEntry.VisitorCountRsp;
import com.tencent.pb.profilecard.SummaryCardBusiEntry.comm;
import com.tencent.pb.profilecard.SummaryCardBusiEntry.rich_ui;
import com.tencent.pb.profilecard.SummaryCardBusiEntry.ui_info;
import com.tencent.pb.profilecard.VaProfileGate.CommTaskInfo;
import com.tencent.pb.profilecard.VaProfileGate.GetGiftListReq;
import com.tencent.pb.profilecard.VaProfileGate.GetVipCareReq;
import com.tencent.pb.profilecard.VaProfileGate.OidbFlagInfo;
import com.tencent.pb.profilecard.VaProfileGate.PrivilegeBaseInfoReq;
import com.tencent.pb.profilecard.VaProfileGate.PrivilegeBaseInfoRsp;
import com.tencent.pb.profilecard.VaProfileGate.PrivilegeInfo;
import com.tencent.pb.profilecard.VaProfileGate.QidInfoItem;
import com.tencent.pb.profilecard.VaProfileGate.VaProfileGateReq;
import com.tencent.pb.profilecard.VaProfileGate.VaProfileGateRsp;
import com.tencent.pb.profilecard.VipMusicBox.GetProfileMusicBoxInfoReq;
import com.tencent.qidian.data.BmqqAccountType;
import com.tencent.qidian.data.QidianExternalInfo;
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
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import mqq.app.Constants.PropertiesKey;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import org.jetbrains.annotations.NotNull;
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
import tencent.im.oidb.cmd0xe5b.oidb_0xe5b.LifeAchievementItem;
import tencent.im.oidb.cmd0xe5b.oidb_0xe5b.ReqBody;
import tencent.im.oidb.cmd0xe5b.oidb_0xe5b.RspBody;
import tencent.im.oidb.cmd0xe5f.oidb_0xe5f.ReqBody;
import tencent.im.oidb.cmd0xe5f.oidb_0xe5f.RspBody;
import tencent.im.oidb.cmd0xec4.oidb_0xec4.Quest;
import tencent.im.oidb.cmd0xec4.oidb_0xec4.ReqBody;
import tencent.im.oidb.cmd0xec4.oidb_0xec4.RspBody;
import tencent.im.oidb.oidb_0xc33.ReqBody;
import tencent.im.oidb.oidb_0xc33.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.storage.wording_storage.WordingCfg;

public class anri
  extends BusinessHandler
{
  public static final String a;
  public static final Vector<Integer> a;
  public static final Vector<Integer> b;
  private TransFileController jdField_a_of_type_ComTencentMobileqqTransfileTransFileController;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  short jdField_a_of_type_Short = 9;
  protected String b;
  short b;
  public final String c;
  short c;
  private String jdField_d_of_type_JavaLangString;
  short jdField_d_of_type_Short = -23461;
  short e = -25008;
  
  static
  {
    jdField_a_of_type_JavaLangString = VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH + "portrait/");
    jdField_a_of_type_JavaUtilVector = new Vector();
    jdField_b_of_type_JavaUtilVector = new Vector();
  }
  
  public anri(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_b_of_type_Short = -25044;
    this.jdField_c_of_type_JavaLangString = "switchUin";
    this.jdField_c_of_type_Short = -25007;
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
        break label434;
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
          break label434;
        }
        bool2 = bool1;
        bool4 = bool1;
        bool3 = bool1;
        if (!paramToServiceMsg.bytes_bodybuffer.has()) {
          break label434;
        }
        bool2 = bool1;
        bool4 = bool1;
        bool3 = bool1;
        if (paramToServiceMsg.bytes_bodybuffer.get() == null) {
          break label434;
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
      label434:
      bool2 = true;
      bool1 = bool3;
    }
  }
  
  private void B(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
          QLog.d("CardHandler", 2, "handlePartekeLikeRankingList result=" + bool1);
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
  
  private void C(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
        paramToServiceMsg = KplCard.parseProto(paramFromServiceMsg, this.jdField_d_of_type_JavaLangString);
        bool2 = bool1;
        bool3 = bool1;
        ((anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(paramToServiceMsg);
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
  
  private void D()
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
    ((PhotoWallUploadTask)???).iUin = Long.parseLong(this.app.getCurrentAccountUin());
    ((PhotoWallUploadTask)???).vLoginData = azux.a(this.app);
    ((PhotoWallUploadTask)???).op = 1;
    ((PhotoWallUploadTask)???).source = 1;
    ((PhotoWallUploadTask)???).uploadTaskCallback = new anrj(this);
    ((PhotoWallUploadTask)???).uploadFilePath = str2;
    ((PhotoWallUploadTask)???).md5 = azux.a(str2);
    ((PhotoWallUploadTask)???).autoRotate = true;
    anrk localanrk = new anrk(this, Long.parseLong(this.app.getCurrentAccountUin()));
    UploadEnv localUploadEnv = new UploadEnv();
    if (!UploadServiceBuilder.getInstance().isInitialized()) {
      UploadServiceBuilder.getInstance().init(this.app.getApp().getApplicationContext(), localanrk, null, null, localUploadEnv, localUploadEnv);
    }
    UploadServiceBuilder.getInstance().upload((AbstractUploadTask)???);
  }
  
  private void D(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
        paramToServiceMsg = this.app.getPreferences();
        bool2 = bool1;
        bool3 = bool1;
        paramObject = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        bool2 = bool1;
        bool3 = bool1;
        if (paramObject.uint32_result.get() != 0) {
          break label961;
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
                    localObject = ((JSONObject)localObject).toString();
                    bool2 = bool1;
                    bool3 = bool1;
                    paramToServiceMsg.edit().putString(this.app.getCurrentUin() + "sign_in_operation" + paramObject.state.get() + "" + paramObject.type.get(), (String)localObject);
                    i += 1;
                    continue;
                  }
                }
              }
              bool2 = bool1;
              bool3 = bool1;
              paramToServiceMsg.edit().putLong(this.app.getCurrentUin() + "sign_in_operation_time_refresh", paramFromServiceMsg.refresh_second.get()).commit();
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
      label961:
      bool1 = false;
    }
  }
  
  private void E(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
        paramFromServiceMsg = this.app.getPreferences();
        bool2 = bool1;
        bool3 = bool1;
        paramFromServiceMsg.edit().putLong(this.app.getCurrentUin() + "sign_in_next_get_time", l2 * 1000L).commit();
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
        paramFromServiceMsg.edit().putString(this.app.getCurrentUin() + "sign_in_info", (String)localObject).putLong("sign_in_time_stamp", l1).commit();
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
        paramToServiceMsg = paramFromServiceMsg.getString(this.app.getCurrentUin() + "sign_in_info", "");
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
          paramFromServiceMsg.edit().putString(this.app.getCurrentUin() + this.app.getCurrentUin() + "sign_in_info", paramToServiceMsg).putLong("sign_in_time_stamp", l1).commit();
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
  
  private void F(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    short[] arrayOfShort = paramToServiceMsg.extraData.getShortArray("switch_id_array");
    boolean bool1 = false;
    int i1 = -1;
    Object localObject3 = null;
    Object localObject2 = null;
    ByteBuffer localByteBuffer = null;
    paramToServiceMsg = localByteBuffer;
    int k = i1;
    Object localObject1 = localObject3;
    int m = i1;
    int n = i1;
    for (;;)
    {
      boolean bool2;
      try
      {
        if (paramFromServiceMsg.isSuccess())
        {
          paramToServiceMsg = localByteBuffer;
          k = i1;
          if (paramObject != null)
          {
            localObject1 = localObject3;
            m = i1;
            n = i1;
            paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
            localObject1 = localObject3;
            m = i1;
            n = i1;
            k = paramToServiceMsg.uint32_result.get();
          }
        }
        if ((k != 0) || (arrayOfShort == null)) {
          break label988;
        }
        localObject1 = localObject3;
        m = k;
        n = k;
        if (!paramToServiceMsg.bytes_bodybuffer.has()) {
          break label988;
        }
        localObject1 = localObject3;
        m = k;
        n = k;
        if (paramToServiceMsg.bytes_bodybuffer.get() == null) {
          break label988;
        }
        localObject1 = localObject3;
        m = k;
        n = k;
        localByteBuffer = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        localObject1 = localObject3;
        m = k;
        n = k;
        localByteBuffer.getInt();
        localObject1 = localObject3;
        m = k;
        n = k;
        localByteBuffer.get();
        localObject1 = localObject3;
        m = k;
        n = k;
        i = localByteBuffer.getShort();
        i1 = 0;
        paramToServiceMsg = localObject2;
        localObject1 = paramToServiceMsg;
        m = k;
        paramFromServiceMsg = paramToServiceMsg;
        n = k;
      }
      catch (Exception paramObject)
      {
        int i;
        k = m;
        paramToServiceMsg = (ToServiceMsg)localObject1;
        paramFromServiceMsg = paramToServiceMsg;
        n = k;
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = paramToServiceMsg;
          n = k;
          QLog.d("CommonSwitchTag", 2, "handleGetCommonSwitchFromDetailInfo ex", paramObject);
        }
        if (!QLog.isColorLevel()) {
          break label979;
        }
        paramFromServiceMsg = Locale.getDefault();
        if (arrayOfShort != null)
        {
          m = arrayOfShort.length;
          if (paramToServiceMsg != null)
          {
            n = paramToServiceMsg.size();
            QLog.d("CommonSwitchTag", 2, String.format(paramFromServiceMsg, "handleGetCommonSwitchFromDetailInfo result: %d switch_id_array: %d map: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n) }));
            paramFromServiceMsg = paramToServiceMsg;
            bool2 = bool1;
          }
        }
        else
        {
          m = 0;
          continue;
        }
        n = 0;
        continue;
      }
      finally
      {
        paramFromServiceMsg = null;
        if (QLog.isColorLevel())
        {
          paramObject = Locale.getDefault();
          if (arrayOfShort == null) {
            break label956;
          }
          k = arrayOfShort.length;
          if (paramFromServiceMsg == null) {
            break label962;
          }
          m = paramFromServiceMsg.size();
          QLog.d("CommonSwitchTag", 2, String.format(paramObject, "handleGetCommonSwitchFromDetailInfo result: %d switch_id_array: %d map: %d", new Object[] { Integer.valueOf(n), Integer.valueOf(k), Integer.valueOf(m) }));
        }
      }
      try
      {
        if (localByteBuffer.hasRemaining())
        {
          int i2 = i1 + 1;
          if (i1 < i)
          {
            localObject1 = paramToServiceMsg;
            m = k;
            paramFromServiceMsg = paramToServiceMsg;
            n = k;
            short s = localByteBuffer.getShort();
            localObject1 = paramToServiceMsg;
            m = k;
            paramFromServiceMsg = paramToServiceMsg;
            n = k;
            int j = localByteBuffer.getShort();
            int i3 = 0;
            i1 = 0;
            localObject1 = paramToServiceMsg;
            m = k;
            paramFromServiceMsg = paramToServiceMsg;
            n = k;
            if (i1 < arrayOfShort.length)
            {
              if (s != arrayOfShort[i1]) {
                break label996;
              }
              i3 = 1;
              break label996;
            }
            if ((i3 != 0) && (j == 2))
            {
              localObject1 = paramToServiceMsg;
              m = k;
              paramFromServiceMsg = paramToServiceMsg;
              n = k;
              j = localByteBuffer.getShort();
              paramObject = paramToServiceMsg;
              if (paramToServiceMsg == null)
              {
                localObject1 = paramToServiceMsg;
                m = k;
                paramFromServiceMsg = paramToServiceMsg;
                n = k;
                paramObject = new HashMap();
              }
              localObject1 = paramObject;
              m = k;
              paramFromServiceMsg = paramObject;
              n = k;
              paramObject.put(Short.valueOf(s), Short.valueOf(j));
              i1 = i2;
              paramToServiceMsg = paramObject;
              continue;
            }
            localObject1 = paramToServiceMsg;
            m = k;
            paramFromServiceMsg = paramToServiceMsg;
            n = k;
            if (QLog.isColorLevel())
            {
              localObject1 = paramToServiceMsg;
              m = k;
              paramFromServiceMsg = paramToServiceMsg;
              n = k;
              QLog.d("CommonSwitchTag", 2, String.format(Locale.getDefault(), "handleGetCommonSwitchFromDetailInfo unexpected [%d, %d]", new Object[] { Short.valueOf(s), Short.valueOf(j) }));
            }
            localObject1 = paramToServiceMsg;
            m = k;
            paramFromServiceMsg = paramToServiceMsg;
            n = k;
            localByteBuffer.position(localByteBuffer.position() + j);
            i1 = i2;
            continue;
          }
        }
        paramFromServiceMsg = paramToServiceMsg;
        n = k;
      }
      finally
      {
        continue;
      }
      try
      {
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = paramToServiceMsg;
          n = k;
          QLog.d("CommonSwitchTag", 2, String.format(Locale.getDefault(), "handleGetCommonSwitchFromDetailInfo tlvCount: %d", new Object[] { Short.valueOf(i) }));
        }
        bool1 = true;
        paramFromServiceMsg = paramToServiceMsg;
        bool2 = bool1;
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = Locale.getDefault();
          if (arrayOfShort == null) {
            continue;
          }
          m = arrayOfShort.length;
          if (paramToServiceMsg == null) {
            continue;
          }
          n = paramToServiceMsg.size();
          QLog.d("CommonSwitchTag", 2, String.format(paramFromServiceMsg, "handleGetCommonSwitchFromDetailInfo result: %d switch_id_array: %d map: %d", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(n) }));
          bool2 = bool1;
          paramFromServiceMsg = paramToServiceMsg;
        }
      }
      catch (Exception paramObject)
      {
        bool1 = true;
        continue;
        paramFromServiceMsg = paramToServiceMsg;
        bool2 = bool1;
        continue;
      }
      notifyUI(85, bool2, new Object[] { arrayOfShort, paramFromServiceMsg });
      return;
      m = 0;
      continue;
      n = 0;
      continue;
      label956:
      k = 0;
      continue;
      label962:
      m = 0;
      continue;
      label979:
      label988:
      paramToServiceMsg = null;
      bool1 = false;
      continue;
      label996:
      i1 += 1;
    }
  }
  
  private void G(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
        bool1 = String.valueOf(l).equals(this.app.getCurrentAccountUin());
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
        ((ajmy)this.mApp.getManager(QQManagerFactory.CTENTRY_MNG)).b(s2);
        ((anyb)this.app.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).b();
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
          QLog.d("CommonSwitchTag", 2, String.format(Locale.getDefault(), "handleSetCommonSwitchFromDetailInfo invalidate account info [dwUin: %d, lUin: %d, account: %s]", new Object[] { Integer.valueOf(n), Long.valueOf(l), this.app.getCurrentAccountUin() }));
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
  
  private void H(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
          QLog.d("CardHandler", 2, "handleGetNotifyOnLikeRankingList result=" + bool1);
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
  
  /* Error */
  private void I(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 100	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: ifeq +72 -> 76
    //   7: aload_3
    //   8: ifnull +68 -> 76
    //   11: iconst_1
    //   12: istore 6
    //   14: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   17: ifeq +31 -> 48
    //   20: ldc_w 726
    //   23: iconst_2
    //   24: new 20	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   31: ldc_w 728
    //   34: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: iload 6
    //   39: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   42: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: aload_1
    //   49: getfield 600	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   52: ldc 68
    //   54: invokevirtual 730	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   57: astore_2
    //   58: aload_2
    //   59: invokestatic 268	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   62: ifeq +20 -> 82
    //   65: ldc_w 726
    //   68: iconst_2
    //   69: ldc_w 732
    //   72: invokestatic 115	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   75: return
    //   76: iconst_0
    //   77: istore 6
    //   79: goto -65 -> 14
    //   82: aload_0
    //   83: getfield 229	anri:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   86: getstatic 235	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   89: invokevirtual 241	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   92: checkcast 243	anvk
    //   95: astore_1
    //   96: aload_1
    //   97: aload_2
    //   98: invokevirtual 735	anvk:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   101: astore 10
    //   103: iload 6
    //   105: istore 9
    //   107: iload 6
    //   109: ifeq +684 -> 793
    //   112: iload 6
    //   114: istore 7
    //   116: iload 6
    //   118: istore 8
    //   120: new 117	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   123: dup
    //   124: invokespecial 118	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   127: aload_3
    //   128: checkcast 120	[B
    //   131: checkcast 120	[B
    //   134: invokevirtual 124	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   137: checkcast 117	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   140: astore_3
    //   141: aload_3
    //   142: ifnull +337 -> 479
    //   145: iload 6
    //   147: istore 7
    //   149: iload 6
    //   151: istore 8
    //   153: aload_3
    //   154: getfield 128	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   157: invokevirtual 133	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   160: ifne +319 -> 479
    //   163: iconst_1
    //   164: istore 6
    //   166: iload 6
    //   168: istore 7
    //   170: iload 6
    //   172: istore 8
    //   174: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   177: ifeq +39 -> 216
    //   180: iload 6
    //   182: istore 7
    //   184: iload 6
    //   186: istore 8
    //   188: ldc_w 726
    //   191: iconst_2
    //   192: new 20	java/lang/StringBuilder
    //   195: dup
    //   196: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   199: ldc_w 737
    //   202: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: iload 6
    //   207: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   210: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   213: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   216: iload 6
    //   218: istore 9
    //   220: iload 6
    //   222: ifeq +571 -> 793
    //   225: iload 6
    //   227: istore 7
    //   229: iload 6
    //   231: istore 8
    //   233: iload 6
    //   235: istore 9
    //   237: aload_3
    //   238: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   241: invokevirtual 147	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   244: ifeq +549 -> 793
    //   247: iload 6
    //   249: istore 7
    //   251: iload 6
    //   253: istore 8
    //   255: iload 6
    //   257: istore 9
    //   259: aload_3
    //   260: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   263: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   266: ifnull +527 -> 793
    //   269: iload 6
    //   271: istore 7
    //   273: iload 6
    //   275: istore 8
    //   277: aload_3
    //   278: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   281: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   284: invokevirtual 159	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   287: invokestatic 614	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   290: astore_3
    //   291: iload 6
    //   293: istore 7
    //   295: iload 6
    //   297: istore 8
    //   299: aload_3
    //   300: invokevirtual 617	java/nio/ByteBuffer:getInt	()I
    //   303: pop
    //   304: iload 6
    //   306: istore 7
    //   308: iload 6
    //   310: istore 8
    //   312: aload_3
    //   313: invokevirtual 620	java/nio/ByteBuffer:get	()B
    //   316: pop
    //   317: iload 6
    //   319: istore 7
    //   321: iload 6
    //   323: istore 8
    //   325: iload 6
    //   327: istore 9
    //   329: aload_3
    //   330: invokevirtual 624	java/nio/ByteBuffer:getShort	()S
    //   333: invokestatic 635	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   336: invokevirtual 740	java/lang/Short:shortValue	()S
    //   339: iconst_1
    //   340: if_icmpne +453 -> 793
    //   343: iload 6
    //   345: istore 7
    //   347: iload 6
    //   349: istore 8
    //   351: aload_3
    //   352: invokevirtual 624	java/nio/ByteBuffer:getShort	()S
    //   355: istore 4
    //   357: iload 6
    //   359: istore 7
    //   361: iload 6
    //   363: istore 8
    //   365: aload_0
    //   366: getfield 66	anri:jdField_b_of_type_Short	S
    //   369: istore 5
    //   371: iload 4
    //   373: iload 5
    //   375: if_icmpeq +110 -> 485
    //   378: iconst_0
    //   379: istore 6
    //   381: iload 6
    //   383: istore 7
    //   385: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   388: ifeq +59 -> 447
    //   391: ldc_w 726
    //   394: iconst_2
    //   395: new 20	java/lang/StringBuilder
    //   398: dup
    //   399: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   402: ldc_w 737
    //   405: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: iload 6
    //   410: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   413: ldc_w 742
    //   416: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: aload 10
    //   421: getfield 747	com/tencent/mobileqq/data/Card:allowPeopleSee	Z
    //   424: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   427: ldc_w 749
    //   430: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: aload_2
    //   434: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   440: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   443: iload 6
    //   445: istore 7
    //   447: aload_0
    //   448: bipush 44
    //   450: iload 7
    //   452: iconst_2
    //   453: anewarray 254	java/lang/Object
    //   456: dup
    //   457: iconst_0
    //   458: aload 10
    //   460: getfield 747	com/tencent/mobileqq/data/Card:allowPeopleSee	Z
    //   463: invokestatic 180	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   466: aastore
    //   467: dup
    //   468: iconst_1
    //   469: aload 10
    //   471: getfield 752	com/tencent/mobileqq/data/Card:uin	Ljava/lang/String;
    //   474: aastore
    //   475: invokevirtual 184	anri:notifyUI	(IZLjava/lang/Object;)V
    //   478: return
    //   479: iconst_0
    //   480: istore 6
    //   482: goto -316 -> 166
    //   485: iload 6
    //   487: istore 7
    //   489: iload 6
    //   491: istore 8
    //   493: aload_3
    //   494: invokevirtual 624	java/nio/ByteBuffer:getShort	()S
    //   497: istore 4
    //   499: iload 4
    //   501: iconst_2
    //   502: if_icmpne +111 -> 613
    //   505: iload 6
    //   507: istore 7
    //   509: iload 6
    //   511: istore 8
    //   513: iload 4
    //   515: newarray byte
    //   517: astore 11
    //   519: iload 6
    //   521: istore 7
    //   523: iload 6
    //   525: istore 8
    //   527: aload_3
    //   528: aload 11
    //   530: invokevirtual 754	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   533: pop
    //   534: iload 6
    //   536: istore 7
    //   538: iload 6
    //   540: istore 8
    //   542: aload 11
    //   544: iconst_0
    //   545: invokestatic 759	bhbx:a	([BI)S
    //   548: ifne +46 -> 594
    //   551: iconst_0
    //   552: istore 9
    //   554: iload 6
    //   556: istore 7
    //   558: iload 6
    //   560: istore 8
    //   562: aload 10
    //   564: iload 9
    //   566: putfield 747	com/tencent/mobileqq/data/Card:allowPeopleSee	Z
    //   569: iload 6
    //   571: istore 7
    //   573: iload 6
    //   575: istore 8
    //   577: aload_3
    //   578: invokevirtual 624	java/nio/ByteBuffer:getShort	()S
    //   581: istore 4
    //   583: iload 4
    //   585: ifeq +15 -> 600
    //   588: iconst_0
    //   589: istore 6
    //   591: goto -210 -> 381
    //   594: iconst_1
    //   595: istore 9
    //   597: goto -43 -> 554
    //   600: aload_1
    //   601: aload 10
    //   603: invokevirtual 762	anvk:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   606: pop
    //   607: iconst_1
    //   608: istore 6
    //   610: goto -229 -> 381
    //   613: iconst_0
    //   614: istore 6
    //   616: goto -235 -> 381
    //   619: astore_1
    //   620: iload 7
    //   622: istore 6
    //   624: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   627: ifeq +14 -> 641
    //   630: ldc_w 726
    //   633: iconst_2
    //   634: ldc_w 764
    //   637: aload_1
    //   638: invokestatic 208	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   641: iload 6
    //   643: istore 7
    //   645: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   648: ifeq -201 -> 447
    //   651: ldc_w 726
    //   654: iconst_2
    //   655: new 20	java/lang/StringBuilder
    //   658: dup
    //   659: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   662: ldc_w 737
    //   665: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: iload 6
    //   670: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   673: ldc_w 742
    //   676: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: aload 10
    //   681: getfield 747	com/tencent/mobileqq/data/Card:allowPeopleSee	Z
    //   684: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   687: ldc_w 749
    //   690: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   693: aload_2
    //   694: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   697: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   700: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   703: iload 6
    //   705: istore 7
    //   707: goto -260 -> 447
    //   710: astore_1
    //   711: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   714: ifeq +55 -> 769
    //   717: ldc_w 726
    //   720: iconst_2
    //   721: new 20	java/lang/StringBuilder
    //   724: dup
    //   725: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   728: ldc_w 737
    //   731: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   734: iload 8
    //   736: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   739: ldc_w 742
    //   742: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   745: aload 10
    //   747: getfield 747	com/tencent/mobileqq/data/Card:allowPeopleSee	Z
    //   750: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   753: ldc_w 749
    //   756: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   759: aload_2
    //   760: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   763: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   766: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   769: aload_1
    //   770: athrow
    //   771: astore_1
    //   772: iconst_1
    //   773: istore 8
    //   775: goto -64 -> 711
    //   778: astore_1
    //   779: iload 6
    //   781: istore 8
    //   783: goto -72 -> 711
    //   786: astore_1
    //   787: iconst_1
    //   788: istore 6
    //   790: goto -166 -> 624
    //   793: iload 9
    //   795: istore 6
    //   797: goto -416 -> 381
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	800	0	this	anri
    //   0	800	1	paramToServiceMsg	ToServiceMsg
    //   0	800	2	paramFromServiceMsg	FromServiceMsg
    //   0	800	3	paramObject	Object
    //   355	229	4	i	int
    //   369	7	5	j	int
    //   12	784	6	bool1	boolean
    //   114	592	7	bool2	boolean
    //   118	664	8	bool3	boolean
    //   105	689	9	bool4	boolean
    //   101	645	10	localCard	Card
    //   517	26	11	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   120	141	619	java/lang/Exception
    //   153	163	619	java/lang/Exception
    //   174	180	619	java/lang/Exception
    //   188	216	619	java/lang/Exception
    //   237	247	619	java/lang/Exception
    //   259	269	619	java/lang/Exception
    //   277	291	619	java/lang/Exception
    //   299	304	619	java/lang/Exception
    //   312	317	619	java/lang/Exception
    //   329	343	619	java/lang/Exception
    //   351	357	619	java/lang/Exception
    //   365	371	619	java/lang/Exception
    //   493	499	619	java/lang/Exception
    //   513	519	619	java/lang/Exception
    //   527	534	619	java/lang/Exception
    //   542	551	619	java/lang/Exception
    //   562	569	619	java/lang/Exception
    //   577	583	619	java/lang/Exception
    //   120	141	710	finally
    //   153	163	710	finally
    //   174	180	710	finally
    //   188	216	710	finally
    //   237	247	710	finally
    //   259	269	710	finally
    //   277	291	710	finally
    //   299	304	710	finally
    //   312	317	710	finally
    //   329	343	710	finally
    //   351	357	710	finally
    //   365	371	710	finally
    //   493	499	710	finally
    //   513	519	710	finally
    //   527	534	710	finally
    //   542	551	710	finally
    //   562	569	710	finally
    //   577	583	710	finally
    //   600	607	771	finally
    //   624	641	778	finally
    //   600	607	786	java/lang/Exception
  }
  
  /* Error */
  private void J(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 100	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: ifeq +525 -> 529
    //   7: aload_3
    //   8: ifnull +521 -> 529
    //   11: iconst_1
    //   12: istore 6
    //   14: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   17: ifeq +31 -> 48
    //   20: ldc_w 726
    //   23: iconst_2
    //   24: new 20	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   31: ldc_w 766
    //   34: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: iload 6
    //   39: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   42: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: aload_0
    //   49: getfield 229	anri:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   52: invokevirtual 294	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   55: astore_1
    //   56: aload_0
    //   57: getfield 229	anri:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   60: getstatic 235	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   63: invokevirtual 241	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   66: checkcast 243	anvk
    //   69: astore 10
    //   71: aload 10
    //   73: aload_1
    //   74: invokevirtual 735	anvk:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   77: astore_2
    //   78: iload 6
    //   80: istore 9
    //   82: iload 6
    //   84: ifeq +800 -> 884
    //   87: iload 6
    //   89: istore 7
    //   91: iload 6
    //   93: istore 8
    //   95: new 117	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   98: dup
    //   99: invokespecial 118	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   102: aload_3
    //   103: checkcast 120	[B
    //   106: checkcast 120	[B
    //   109: invokevirtual 124	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   112: checkcast 117	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   115: astore_1
    //   116: aload_1
    //   117: ifnull +418 -> 535
    //   120: iload 6
    //   122: istore 7
    //   124: iload 6
    //   126: istore 8
    //   128: aload_1
    //   129: getfield 128	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   132: invokevirtual 133	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   135: ifne +400 -> 535
    //   138: iconst_1
    //   139: istore 6
    //   141: iload 6
    //   143: istore 7
    //   145: iload 6
    //   147: istore 8
    //   149: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   152: ifeq +39 -> 191
    //   155: iload 6
    //   157: istore 7
    //   159: iload 6
    //   161: istore 8
    //   163: ldc_w 726
    //   166: iconst_2
    //   167: new 20	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   174: ldc_w 768
    //   177: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: iload 6
    //   182: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   185: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   191: iload 6
    //   193: istore 9
    //   195: iload 6
    //   197: ifeq +687 -> 884
    //   200: iload 6
    //   202: istore 7
    //   204: iload 6
    //   206: istore 8
    //   208: iload 6
    //   210: istore 9
    //   212: aload_1
    //   213: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   216: invokevirtual 147	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   219: ifeq +665 -> 884
    //   222: iload 6
    //   224: istore 7
    //   226: iload 6
    //   228: istore 8
    //   230: iload 6
    //   232: istore 9
    //   234: aload_1
    //   235: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   238: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   241: ifnull +643 -> 884
    //   244: iload 6
    //   246: istore 7
    //   248: iload 6
    //   250: istore 8
    //   252: aload_1
    //   253: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   256: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   259: invokevirtual 159	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   262: invokestatic 614	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   265: astore_1
    //   266: iload 6
    //   268: istore 7
    //   270: iload 6
    //   272: istore 8
    //   274: aload_1
    //   275: invokevirtual 617	java/nio/ByteBuffer:getInt	()I
    //   278: pop
    //   279: iload 6
    //   281: istore 7
    //   283: iload 6
    //   285: istore 8
    //   287: aload_1
    //   288: invokevirtual 620	java/nio/ByteBuffer:get	()B
    //   291: pop
    //   292: iload 6
    //   294: istore 7
    //   296: iload 6
    //   298: istore 8
    //   300: iload 6
    //   302: istore 9
    //   304: aload_1
    //   305: invokevirtual 624	java/nio/ByteBuffer:getShort	()S
    //   308: invokestatic 635	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   311: invokevirtual 740	java/lang/Short:shortValue	()S
    //   314: iconst_1
    //   315: if_icmpne +569 -> 884
    //   318: iload 6
    //   320: istore 7
    //   322: iload 6
    //   324: istore 8
    //   326: aload_1
    //   327: invokevirtual 624	java/nio/ByteBuffer:getShort	()S
    //   330: istore 4
    //   332: iload 6
    //   334: istore 7
    //   336: iload 6
    //   338: istore 8
    //   340: aload_0
    //   341: getfield 72	anri:jdField_c_of_type_Short	S
    //   344: istore 5
    //   346: iload 4
    //   348: iload 5
    //   350: if_icmpeq +191 -> 541
    //   353: iconst_0
    //   354: istore 6
    //   356: iload 6
    //   358: istore 7
    //   360: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   363: ifeq +48 -> 411
    //   366: ldc_w 726
    //   369: iconst_2
    //   370: new 20	java/lang/StringBuilder
    //   373: dup
    //   374: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   377: ldc_w 768
    //   380: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: iload 6
    //   385: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   388: ldc_w 742
    //   391: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: aload_2
    //   395: getfield 771	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   398: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   401: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   404: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   407: iload 6
    //   409: istore 7
    //   411: aload_2
    //   412: getfield 771	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   415: ifeq +438 -> 853
    //   418: aload 10
    //   420: iconst_1
    //   421: putfield 774	anvk:q	I
    //   424: aload_0
    //   425: getfield 229	anri:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   428: invokevirtual 362	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   431: aload_0
    //   432: getfield 229	anri:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   435: invokevirtual 294	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   438: iconst_0
    //   439: invokevirtual 778	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   442: invokeinterface 468 1 0
    //   447: ldc_w 780
    //   450: aload 10
    //   452: getfield 774	anvk:q	I
    //   455: invokeinterface 784 3 0
    //   460: invokeinterface 491 1 0
    //   465: pop
    //   466: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   469: ifeq +44 -> 513
    //   472: ldc_w 786
    //   475: iconst_2
    //   476: new 20	java/lang/StringBuilder
    //   479: dup
    //   480: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   483: ldc_w 768
    //   486: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   489: iload 7
    //   491: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   494: ldc_w 788
    //   497: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: aload_2
    //   501: getfield 771	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   504: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   507: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   510: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   513: aload_0
    //   514: bipush 72
    //   516: iload 7
    //   518: aload_2
    //   519: getfield 771	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   522: invokestatic 180	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   525: invokevirtual 184	anri:notifyUI	(IZLjava/lang/Object;)V
    //   528: return
    //   529: iconst_0
    //   530: istore 6
    //   532: goto -518 -> 14
    //   535: iconst_0
    //   536: istore 6
    //   538: goto -397 -> 141
    //   541: iload 6
    //   543: istore 7
    //   545: iload 6
    //   547: istore 8
    //   549: aload_1
    //   550: invokevirtual 624	java/nio/ByteBuffer:getShort	()S
    //   553: istore 4
    //   555: iload 4
    //   557: iconst_2
    //   558: if_icmpne +159 -> 717
    //   561: iload 6
    //   563: istore 7
    //   565: iload 6
    //   567: istore 8
    //   569: iload 4
    //   571: newarray byte
    //   573: astore_3
    //   574: iload 6
    //   576: istore 7
    //   578: iload 6
    //   580: istore 8
    //   582: aload_1
    //   583: aload_3
    //   584: invokevirtual 754	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   587: pop
    //   588: iload 6
    //   590: istore 7
    //   592: iload 6
    //   594: istore 8
    //   596: aload_3
    //   597: iconst_0
    //   598: invokestatic 759	bhbx:a	([BI)S
    //   601: ifne +97 -> 698
    //   604: iconst_0
    //   605: istore 9
    //   607: iload 6
    //   609: istore 7
    //   611: iload 6
    //   613: istore 8
    //   615: aload_2
    //   616: iload 9
    //   618: putfield 771	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   621: iload 6
    //   623: istore 7
    //   625: iload 6
    //   627: istore 8
    //   629: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   632: ifeq +41 -> 673
    //   635: iload 6
    //   637: istore 7
    //   639: iload 6
    //   641: istore 8
    //   643: ldc_w 786
    //   646: iconst_2
    //   647: new 20	java/lang/StringBuilder
    //   650: dup
    //   651: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   654: ldc_w 790
    //   657: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: aload_2
    //   661: getfield 771	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   664: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   667: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   670: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   673: iload 6
    //   675: istore 7
    //   677: iload 6
    //   679: istore 8
    //   681: aload_1
    //   682: invokevirtual 624	java/nio/ByteBuffer:getShort	()S
    //   685: istore 4
    //   687: iload 4
    //   689: ifeq +15 -> 704
    //   692: iconst_0
    //   693: istore 6
    //   695: goto -339 -> 356
    //   698: iconst_1
    //   699: istore 9
    //   701: goto -94 -> 607
    //   704: aload 10
    //   706: aload_2
    //   707: invokevirtual 762	anvk:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   710: pop
    //   711: iconst_1
    //   712: istore 6
    //   714: goto -358 -> 356
    //   717: iconst_0
    //   718: istore 6
    //   720: goto -364 -> 356
    //   723: astore_1
    //   724: iload 7
    //   726: istore 6
    //   728: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   731: ifeq +14 -> 745
    //   734: ldc_w 726
    //   737: iconst_2
    //   738: ldc_w 792
    //   741: aload_1
    //   742: invokestatic 208	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   745: iload 6
    //   747: istore 7
    //   749: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   752: ifeq -341 -> 411
    //   755: ldc_w 726
    //   758: iconst_2
    //   759: new 20	java/lang/StringBuilder
    //   762: dup
    //   763: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   766: ldc_w 768
    //   769: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   772: iload 6
    //   774: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   777: ldc_w 742
    //   780: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   783: aload_2
    //   784: getfield 771	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   787: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   790: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   793: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   796: iload 6
    //   798: istore 7
    //   800: goto -389 -> 411
    //   803: astore_1
    //   804: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   807: ifeq +44 -> 851
    //   810: ldc_w 726
    //   813: iconst_2
    //   814: new 20	java/lang/StringBuilder
    //   817: dup
    //   818: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   821: ldc_w 768
    //   824: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   827: iload 8
    //   829: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   832: ldc_w 742
    //   835: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   838: aload_2
    //   839: getfield 771	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   842: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   845: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   848: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   851: aload_1
    //   852: athrow
    //   853: aload 10
    //   855: iconst_0
    //   856: putfield 774	anvk:q	I
    //   859: goto -435 -> 424
    //   862: astore_1
    //   863: iconst_1
    //   864: istore 8
    //   866: goto -62 -> 804
    //   869: astore_1
    //   870: iload 6
    //   872: istore 8
    //   874: goto -70 -> 804
    //   877: astore_1
    //   878: iconst_1
    //   879: istore 6
    //   881: goto -153 -> 728
    //   884: iload 9
    //   886: istore 6
    //   888: goto -532 -> 356
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	891	0	this	anri
    //   0	891	1	paramToServiceMsg	ToServiceMsg
    //   0	891	2	paramFromServiceMsg	FromServiceMsg
    //   0	891	3	paramObject	Object
    //   330	358	4	i	int
    //   344	7	5	j	int
    //   12	875	6	bool1	boolean
    //   89	710	7	bool2	boolean
    //   93	780	8	bool3	boolean
    //   80	805	9	bool4	boolean
    //   69	785	10	localanvk	anvk
    // Exception table:
    //   from	to	target	type
    //   95	116	723	java/lang/Exception
    //   128	138	723	java/lang/Exception
    //   149	155	723	java/lang/Exception
    //   163	191	723	java/lang/Exception
    //   212	222	723	java/lang/Exception
    //   234	244	723	java/lang/Exception
    //   252	266	723	java/lang/Exception
    //   274	279	723	java/lang/Exception
    //   287	292	723	java/lang/Exception
    //   304	318	723	java/lang/Exception
    //   326	332	723	java/lang/Exception
    //   340	346	723	java/lang/Exception
    //   549	555	723	java/lang/Exception
    //   569	574	723	java/lang/Exception
    //   582	588	723	java/lang/Exception
    //   596	604	723	java/lang/Exception
    //   615	621	723	java/lang/Exception
    //   629	635	723	java/lang/Exception
    //   643	673	723	java/lang/Exception
    //   681	687	723	java/lang/Exception
    //   95	116	803	finally
    //   128	138	803	finally
    //   149	155	803	finally
    //   163	191	803	finally
    //   212	222	803	finally
    //   234	244	803	finally
    //   252	266	803	finally
    //   274	279	803	finally
    //   287	292	803	finally
    //   304	318	803	finally
    //   326	332	803	finally
    //   340	346	803	finally
    //   549	555	803	finally
    //   569	574	803	finally
    //   582	588	803	finally
    //   596	604	803	finally
    //   615	621	803	finally
    //   629	635	803	finally
    //   643	673	803	finally
    //   681	687	803	finally
    //   704	711	862	finally
    //   728	745	869	finally
    //   704	711	877	java/lang/Exception
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
        QLog.d("Q.profilecard.", 2, "handleSetLoginDaysSwitch success=" + bool1);
      }
      bool4 = bool1;
      if (!bool1) {
        break label608;
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
          break label608;
        }
        bool2 = bool1;
        bool3 = bool1;
        bool4 = bool1;
        if (!paramFromServiceMsg.bytes_bodybuffer.has()) {
          break label608;
        }
        bool2 = bool1;
        bool3 = bool1;
        bool4 = bool1;
        if (paramFromServiceMsg.bytes_bodybuffer.get() == null) {
          break label608;
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
        if (!this.app.getCurrentAccountUin().equals(String.valueOf(l))) {
          continue;
        }
        bool2 = bool1;
        bool3 = bool1;
        paramFromServiceMsg = (anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
        bool2 = bool1;
        bool3 = bool1;
        paramObject = paramFromServiceMsg.c(this.app.getCurrentAccountUin());
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
      label608:
      bool1 = bool4;
    }
  }
  
  /* Error */
  private void L(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 10
    //   3: iconst_1
    //   4: istore 11
    //   6: iconst_1
    //   7: istore 9
    //   9: aload_2
    //   10: invokevirtual 100	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   13: ifeq +609 -> 622
    //   16: aload_3
    //   17: ifnull +605 -> 622
    //   20: iconst_1
    //   21: istore 5
    //   23: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +31 -> 57
    //   29: ldc_w 726
    //   32: iconst_2
    //   33: new 20	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   40: ldc_w 808
    //   43: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: iload 5
    //   48: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   51: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: iload 5
    //   59: istore 8
    //   61: iload 5
    //   63: ifeq +759 -> 822
    //   66: iload 5
    //   68: istore 6
    //   70: iload 5
    //   72: istore 7
    //   74: new 117	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   77: dup
    //   78: invokespecial 118	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   81: aload_3
    //   82: checkcast 120	[B
    //   85: checkcast 120	[B
    //   88: invokevirtual 124	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   91: checkcast 117	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   94: astore_2
    //   95: aload_2
    //   96: ifnull +532 -> 628
    //   99: iload 5
    //   101: istore 6
    //   103: iload 5
    //   105: istore 7
    //   107: aload_2
    //   108: getfield 128	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   111: invokevirtual 133	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   114: ifne +514 -> 628
    //   117: iconst_1
    //   118: istore 5
    //   120: iload 5
    //   122: istore 6
    //   124: iload 5
    //   126: istore 7
    //   128: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   131: ifeq +39 -> 170
    //   134: iload 5
    //   136: istore 6
    //   138: iload 5
    //   140: istore 7
    //   142: ldc_w 726
    //   145: iconst_2
    //   146: new 20	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   153: ldc_w 810
    //   156: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: iload 5
    //   161: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   164: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   170: iload 5
    //   172: istore 8
    //   174: iload 5
    //   176: ifeq +646 -> 822
    //   179: iload 5
    //   181: istore 6
    //   183: iload 5
    //   185: istore 7
    //   187: iload 5
    //   189: istore 8
    //   191: aload_2
    //   192: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   195: invokevirtual 147	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   198: ifeq +624 -> 822
    //   201: iload 5
    //   203: istore 6
    //   205: iload 5
    //   207: istore 7
    //   209: iload 5
    //   211: istore 8
    //   213: aload_2
    //   214: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   217: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   220: ifnull +602 -> 822
    //   223: iload 5
    //   225: istore 6
    //   227: iload 5
    //   229: istore 7
    //   231: aload_2
    //   232: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   235: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   238: invokevirtual 159	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   241: invokestatic 614	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   244: invokevirtual 617	java/nio/ByteBuffer:getInt	()I
    //   247: istore 4
    //   249: iload 4
    //   251: ifge +383 -> 634
    //   254: iload 4
    //   256: i2l
    //   257: ldc2_w 676
    //   260: ladd
    //   261: lstore 12
    //   263: iload 5
    //   265: istore 6
    //   267: iload 5
    //   269: istore 7
    //   271: aload_0
    //   272: getfield 229	anri:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   275: invokevirtual 294	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   278: lload 12
    //   280: invokestatic 680	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   283: invokevirtual 683	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   286: ifeq +462 -> 748
    //   289: iload 5
    //   291: istore 6
    //   293: iload 5
    //   295: istore 7
    //   297: aload_0
    //   298: getfield 229	anri:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   301: getstatic 235	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   304: invokevirtual 241	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   307: checkcast 243	anvk
    //   310: astore_2
    //   311: iload 5
    //   313: istore 6
    //   315: iload 5
    //   317: istore 7
    //   319: aload_2
    //   320: aload_0
    //   321: getfield 229	anri:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   324: invokevirtual 294	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   327: invokevirtual 735	anvk:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   330: astore_3
    //   331: iload 5
    //   333: istore 6
    //   335: iload 5
    //   337: istore 7
    //   339: aload_3
    //   340: aload_1
    //   341: getfield 600	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   344: ldc_w 799
    //   347: invokevirtual 803	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   350: putfield 771	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   353: iload 5
    //   355: istore 6
    //   357: iload 5
    //   359: istore 7
    //   361: aload_2
    //   362: aload_3
    //   363: invokevirtual 762	anvk:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   366: pop
    //   367: iload 11
    //   369: istore 6
    //   371: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   374: ifeq +37 -> 411
    //   377: iload 11
    //   379: istore 6
    //   381: ldc_w 786
    //   384: iconst_2
    //   385: new 20	java/lang/StringBuilder
    //   388: dup
    //   389: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   392: ldc_w 812
    //   395: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: aload_3
    //   399: getfield 771	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   402: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   405: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   408: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   411: iload 11
    //   413: istore 6
    //   415: aload_3
    //   416: getfield 771	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   419: ifeq +223 -> 642
    //   422: iload 11
    //   424: istore 6
    //   426: aload_2
    //   427: iconst_1
    //   428: putfield 774	anvk:q	I
    //   431: iload 11
    //   433: istore 6
    //   435: aload_0
    //   436: getfield 229	anri:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   439: invokevirtual 362	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   442: aload_0
    //   443: getfield 229	anri:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   446: invokevirtual 294	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   449: iconst_0
    //   450: invokevirtual 778	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   453: invokeinterface 468 1 0
    //   458: ldc_w 780
    //   461: aload_2
    //   462: getfield 774	anvk:q	I
    //   465: invokeinterface 784 3 0
    //   470: invokeinterface 491 1 0
    //   475: pop
    //   476: iload 9
    //   478: istore 5
    //   480: iload 5
    //   482: istore 6
    //   484: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   487: ifeq +54 -> 541
    //   490: ldc_w 726
    //   493: iconst_2
    //   494: new 20	java/lang/StringBuilder
    //   497: dup
    //   498: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   501: ldc_w 810
    //   504: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   507: iload 5
    //   509: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   512: ldc_w 742
    //   515: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   518: aload_1
    //   519: getfield 600	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   522: ldc_w 799
    //   525: invokevirtual 803	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   528: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   531: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   534: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   537: iload 5
    //   539: istore 6
    //   541: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   544: ifeq +68 -> 612
    //   547: aload_0
    //   548: getfield 229	anri:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   551: getstatic 235	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   554: invokevirtual 241	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   557: checkcast 243	anvk
    //   560: aload_0
    //   561: getfield 229	anri:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   564: invokevirtual 294	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   567: invokevirtual 735	anvk:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   570: astore_1
    //   571: ldc_w 786
    //   574: iconst_2
    //   575: new 20	java/lang/StringBuilder
    //   578: dup
    //   579: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   582: ldc_w 812
    //   585: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: aload_1
    //   589: getfield 771	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   592: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   595: ldc_w 814
    //   598: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: iload 6
    //   603: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   606: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   609: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   612: aload_0
    //   613: bipush 73
    //   615: iload 6
    //   617: aconst_null
    //   618: invokevirtual 184	anri:notifyUI	(IZLjava/lang/Object;)V
    //   621: return
    //   622: iconst_0
    //   623: istore 5
    //   625: goto -602 -> 23
    //   628: iconst_0
    //   629: istore 5
    //   631: goto -511 -> 120
    //   634: iload 4
    //   636: i2l
    //   637: lstore 12
    //   639: goto -376 -> 263
    //   642: iload 11
    //   644: istore 6
    //   646: aload_2
    //   647: iconst_0
    //   648: putfield 774	anvk:q	I
    //   651: goto -220 -> 431
    //   654: astore_2
    //   655: iload 10
    //   657: istore 5
    //   659: iload 5
    //   661: istore 6
    //   663: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   666: ifeq +18 -> 684
    //   669: iload 5
    //   671: istore 6
    //   673: ldc_w 726
    //   676: iconst_2
    //   677: ldc_w 816
    //   680: aload_2
    //   681: invokestatic 208	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   684: iload 5
    //   686: istore 6
    //   688: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   691: ifeq -150 -> 541
    //   694: ldc_w 726
    //   697: iconst_2
    //   698: new 20	java/lang/StringBuilder
    //   701: dup
    //   702: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   705: ldc_w 810
    //   708: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   711: iload 5
    //   713: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   716: ldc_w 742
    //   719: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   722: aload_1
    //   723: getfield 600	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   726: ldc_w 799
    //   729: invokevirtual 803	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   732: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   735: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   738: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   741: iload 5
    //   743: istore 6
    //   745: goto -204 -> 541
    //   748: iconst_0
    //   749: istore 5
    //   751: goto -271 -> 480
    //   754: astore_2
    //   755: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   758: ifeq +50 -> 808
    //   761: ldc_w 726
    //   764: iconst_2
    //   765: new 20	java/lang/StringBuilder
    //   768: dup
    //   769: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   772: ldc_w 810
    //   775: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   778: iload 6
    //   780: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   783: ldc_w 742
    //   786: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   789: aload_1
    //   790: getfield 600	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   793: ldc_w 799
    //   796: invokevirtual 803	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   799: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   802: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   805: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   808: aload_2
    //   809: athrow
    //   810: astore_2
    //   811: goto -56 -> 755
    //   814: astore_2
    //   815: iload 7
    //   817: istore 5
    //   819: goto -160 -> 659
    //   822: iload 8
    //   824: istore 5
    //   826: goto -346 -> 480
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	829	0	this	anri
    //   0	829	1	paramToServiceMsg	ToServiceMsg
    //   0	829	2	paramFromServiceMsg	FromServiceMsg
    //   0	829	3	paramObject	Object
    //   247	388	4	i	int
    //   21	804	5	bool1	boolean
    //   68	711	6	bool2	boolean
    //   72	744	7	bool3	boolean
    //   59	764	8	bool4	boolean
    //   7	470	9	bool5	boolean
    //   1	655	10	bool6	boolean
    //   4	639	11	bool7	boolean
    //   261	377	12	l	long
    // Exception table:
    //   from	to	target	type
    //   371	377	654	java/lang/Exception
    //   381	411	654	java/lang/Exception
    //   415	422	654	java/lang/Exception
    //   426	431	654	java/lang/Exception
    //   435	476	654	java/lang/Exception
    //   646	651	654	java/lang/Exception
    //   74	95	754	finally
    //   107	117	754	finally
    //   128	134	754	finally
    //   142	170	754	finally
    //   191	201	754	finally
    //   213	223	754	finally
    //   231	249	754	finally
    //   271	289	754	finally
    //   297	311	754	finally
    //   319	331	754	finally
    //   339	353	754	finally
    //   361	367	754	finally
    //   371	377	810	finally
    //   381	411	810	finally
    //   415	422	810	finally
    //   426	431	810	finally
    //   435	476	810	finally
    //   646	651	810	finally
    //   663	669	810	finally
    //   673	684	810	finally
    //   74	95	814	java/lang/Exception
    //   107	117	814	java/lang/Exception
    //   128	134	814	java/lang/Exception
    //   142	170	814	java/lang/Exception
    //   191	201	814	java/lang/Exception
    //   213	223	814	java/lang/Exception
    //   231	249	814	java/lang/Exception
    //   271	289	814	java/lang/Exception
    //   297	311	814	java/lang/Exception
    //   319	331	814	java/lang/Exception
    //   339	353	814	java/lang/Exception
    //   361	367	814	java/lang/Exception
  }
  
  /* Error */
  private void M(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 10
    //   3: iconst_1
    //   4: istore 11
    //   6: iconst_1
    //   7: istore 9
    //   9: aload_2
    //   10: invokevirtual 100	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   13: ifeq +681 -> 694
    //   16: aload_3
    //   17: ifnull +677 -> 694
    //   20: iconst_1
    //   21: istore 5
    //   23: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +31 -> 57
    //   29: ldc_w 726
    //   32: iconst_2
    //   33: new 20	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   40: ldc_w 819
    //   43: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: iload 5
    //   48: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   51: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: iload 5
    //   59: istore 8
    //   61: iload 5
    //   63: ifeq +823 -> 886
    //   66: iload 5
    //   68: istore 6
    //   70: iload 5
    //   72: istore 7
    //   74: new 117	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   77: dup
    //   78: invokespecial 118	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   81: aload_3
    //   82: checkcast 120	[B
    //   85: checkcast 120	[B
    //   88: invokevirtual 124	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   91: checkcast 117	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   94: astore_2
    //   95: iload 5
    //   97: istore 6
    //   99: iload 5
    //   101: istore 7
    //   103: aload_2
    //   104: getfield 128	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   107: invokevirtual 133	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   110: ifne +590 -> 700
    //   113: iconst_1
    //   114: istore 5
    //   116: iload 5
    //   118: istore 6
    //   120: iload 5
    //   122: istore 7
    //   124: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   127: ifeq +39 -> 166
    //   130: iload 5
    //   132: istore 6
    //   134: iload 5
    //   136: istore 7
    //   138: ldc_w 726
    //   141: iconst_2
    //   142: new 20	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   149: ldc_w 821
    //   152: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: iload 5
    //   157: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   160: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   166: iload 5
    //   168: istore 8
    //   170: iload 5
    //   172: ifeq +714 -> 886
    //   175: iload 5
    //   177: istore 6
    //   179: iload 5
    //   181: istore 7
    //   183: iload 5
    //   185: istore 8
    //   187: aload_2
    //   188: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   191: invokevirtual 147	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   194: ifeq +692 -> 886
    //   197: iload 5
    //   199: istore 6
    //   201: iload 5
    //   203: istore 7
    //   205: iload 5
    //   207: istore 8
    //   209: aload_2
    //   210: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   213: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   216: ifnull +670 -> 886
    //   219: iload 5
    //   221: istore 6
    //   223: iload 5
    //   225: istore 7
    //   227: aload_2
    //   228: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   231: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   234: invokevirtual 159	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   237: invokestatic 614	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   240: invokevirtual 617	java/nio/ByteBuffer:getInt	()I
    //   243: istore 4
    //   245: iload 4
    //   247: ifge +459 -> 706
    //   250: iload 4
    //   252: i2l
    //   253: ldc2_w 676
    //   256: ladd
    //   257: lstore 13
    //   259: iload 5
    //   261: istore 6
    //   263: iload 5
    //   265: istore 7
    //   267: aload_0
    //   268: getfield 229	anri:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   271: invokevirtual 294	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   274: lload 13
    //   276: invokestatic 680	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   279: invokevirtual 683	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   282: ifeq +432 -> 714
    //   285: iload 5
    //   287: istore 6
    //   289: iload 5
    //   291: istore 7
    //   293: aload_0
    //   294: getfield 229	anri:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   297: invokestatic 826	aymo:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   300: istore 8
    //   302: iload 5
    //   304: istore 6
    //   306: iload 5
    //   308: istore 7
    //   310: aload_0
    //   311: getfield 229	anri:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   314: getstatic 235	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   317: invokevirtual 241	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   320: checkcast 243	anvk
    //   323: astore_3
    //   324: iload 5
    //   326: istore 6
    //   328: iload 5
    //   330: istore 7
    //   332: aload_3
    //   333: aload_0
    //   334: getfield 229	anri:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   337: invokevirtual 294	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   340: invokevirtual 735	anvk:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   343: astore_2
    //   344: iload 5
    //   346: istore 6
    //   348: iload 5
    //   350: istore 7
    //   352: aload_2
    //   353: aload_1
    //   354: getfield 600	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   357: ldc_w 799
    //   360: invokevirtual 803	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   363: putfield 829	com/tencent/mobileqq/data/Card:medalSwitchDisable	Z
    //   366: iload 5
    //   368: istore 6
    //   370: iload 5
    //   372: istore 7
    //   374: aload_3
    //   375: aload_2
    //   376: invokevirtual 762	anvk:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   379: pop
    //   380: iload 5
    //   382: istore 6
    //   384: iload 5
    //   386: istore 7
    //   388: invokestatic 835	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   391: new 20	java/lang/StringBuilder
    //   394: dup
    //   395: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   398: ldc_w 837
    //   401: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: lload 13
    //   406: invokevirtual 840	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   409: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   412: iconst_4
    //   413: invokevirtual 841	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   416: invokeinterface 468 1 0
    //   421: astore_3
    //   422: iload 5
    //   424: istore 6
    //   426: iload 5
    //   428: istore 7
    //   430: aload_3
    //   431: ldc_w 843
    //   434: aload_2
    //   435: getfield 829	com/tencent/mobileqq/data/Card:medalSwitchDisable	Z
    //   438: invokeinterface 847 3 0
    //   443: pop
    //   444: iload 5
    //   446: istore 6
    //   448: iload 5
    //   450: istore 7
    //   452: aload_3
    //   453: invokeinterface 491 1 0
    //   458: pop
    //   459: iload 5
    //   461: istore 6
    //   463: iload 5
    //   465: istore 7
    //   467: aload_0
    //   468: getfield 229	anri:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   471: invokestatic 826	aymo:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   474: istore 12
    //   476: iload 8
    //   478: iload 12
    //   480: if_icmpeq +20 -> 500
    //   483: iload 5
    //   485: istore 6
    //   487: iload 5
    //   489: istore 7
    //   491: aload_0
    //   492: getfield 229	anri:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   495: iload 12
    //   497: invokestatic 850	aymo:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Z)V
    //   500: iload 9
    //   502: istore 5
    //   504: iload 11
    //   506: istore 6
    //   508: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   511: ifeq +41 -> 552
    //   514: iload 11
    //   516: istore 6
    //   518: ldc_w 726
    //   521: iconst_2
    //   522: new 20	java/lang/StringBuilder
    //   525: dup
    //   526: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   529: ldc_w 852
    //   532: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   535: aload_2
    //   536: getfield 829	com/tencent/mobileqq/data/Card:medalSwitchDisable	Z
    //   539: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   542: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   545: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   548: iload 9
    //   550: istore 5
    //   552: iload 5
    //   554: istore 6
    //   556: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   559: ifeq +54 -> 613
    //   562: ldc_w 726
    //   565: iconst_2
    //   566: new 20	java/lang/StringBuilder
    //   569: dup
    //   570: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   573: ldc_w 821
    //   576: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   579: iload 5
    //   581: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   584: ldc_w 854
    //   587: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   590: aload_1
    //   591: getfield 600	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   594: ldc_w 799
    //   597: invokevirtual 803	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   600: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   603: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   606: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   609: iload 5
    //   611: istore 6
    //   613: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   616: ifeq +68 -> 684
    //   619: aload_0
    //   620: getfield 229	anri:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   623: getstatic 235	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   626: invokevirtual 241	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   629: checkcast 243	anvk
    //   632: aload_0
    //   633: getfield 229	anri:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   636: invokevirtual 294	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   639: invokevirtual 735	anvk:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   642: astore_1
    //   643: ldc_w 726
    //   646: iconst_2
    //   647: new 20	java/lang/StringBuilder
    //   650: dup
    //   651: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   654: ldc_w 856
    //   657: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   660: aload_1
    //   661: getfield 829	com/tencent/mobileqq/data/Card:medalSwitchDisable	Z
    //   664: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   667: ldc_w 814
    //   670: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   673: iload 6
    //   675: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   678: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   681: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   684: aload_0
    //   685: bipush 76
    //   687: iload 6
    //   689: aconst_null
    //   690: invokevirtual 184	anri:notifyUI	(IZLjava/lang/Object;)V
    //   693: return
    //   694: iconst_0
    //   695: istore 5
    //   697: goto -674 -> 23
    //   700: iconst_0
    //   701: istore 5
    //   703: goto -587 -> 116
    //   706: iload 4
    //   708: i2l
    //   709: lstore 13
    //   711: goto -452 -> 259
    //   714: iconst_0
    //   715: istore 5
    //   717: goto -165 -> 552
    //   720: astore_2
    //   721: iload 6
    //   723: istore 5
    //   725: iload 5
    //   727: istore 6
    //   729: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   732: ifeq +18 -> 750
    //   735: iload 5
    //   737: istore 6
    //   739: ldc_w 726
    //   742: iconst_2
    //   743: ldc_w 858
    //   746: aload_2
    //   747: invokestatic 208	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   750: iload 5
    //   752: istore 6
    //   754: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   757: ifeq -144 -> 613
    //   760: ldc_w 726
    //   763: iconst_2
    //   764: new 20	java/lang/StringBuilder
    //   767: dup
    //   768: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   771: ldc_w 821
    //   774: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   777: iload 5
    //   779: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   782: ldc_w 854
    //   785: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   788: aload_1
    //   789: getfield 600	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   792: ldc_w 799
    //   795: invokevirtual 803	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   798: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   801: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   804: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   807: iload 5
    //   809: istore 6
    //   811: goto -198 -> 613
    //   814: astore_2
    //   815: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   818: ifeq +50 -> 868
    //   821: ldc_w 726
    //   824: iconst_2
    //   825: new 20	java/lang/StringBuilder
    //   828: dup
    //   829: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   832: ldc_w 821
    //   835: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   838: iload 7
    //   840: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   843: ldc_w 854
    //   846: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   849: aload_1
    //   850: getfield 600	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   853: ldc_w 799
    //   856: invokevirtual 803	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   859: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   862: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   865: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   868: aload_2
    //   869: athrow
    //   870: astore_2
    //   871: iload 6
    //   873: istore 7
    //   875: goto -60 -> 815
    //   878: astore_2
    //   879: iload 10
    //   881: istore 5
    //   883: goto -158 -> 725
    //   886: iload 8
    //   888: istore 5
    //   890: goto -338 -> 552
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	893	0	this	anri
    //   0	893	1	paramToServiceMsg	ToServiceMsg
    //   0	893	2	paramFromServiceMsg	FromServiceMsg
    //   0	893	3	paramObject	Object
    //   243	464	4	i	int
    //   21	868	5	bool1	boolean
    //   68	804	6	bool2	boolean
    //   72	802	7	bool3	boolean
    //   59	828	8	bool4	boolean
    //   7	542	9	bool5	boolean
    //   1	879	10	bool6	boolean
    //   4	511	11	bool7	boolean
    //   474	22	12	bool8	boolean
    //   257	453	13	l	long
    // Exception table:
    //   from	to	target	type
    //   74	95	720	java/lang/Exception
    //   103	113	720	java/lang/Exception
    //   124	130	720	java/lang/Exception
    //   138	166	720	java/lang/Exception
    //   187	197	720	java/lang/Exception
    //   209	219	720	java/lang/Exception
    //   227	245	720	java/lang/Exception
    //   267	285	720	java/lang/Exception
    //   293	302	720	java/lang/Exception
    //   310	324	720	java/lang/Exception
    //   332	344	720	java/lang/Exception
    //   352	366	720	java/lang/Exception
    //   374	380	720	java/lang/Exception
    //   388	422	720	java/lang/Exception
    //   430	444	720	java/lang/Exception
    //   452	459	720	java/lang/Exception
    //   467	476	720	java/lang/Exception
    //   491	500	720	java/lang/Exception
    //   74	95	814	finally
    //   103	113	814	finally
    //   124	130	814	finally
    //   138	166	814	finally
    //   187	197	814	finally
    //   209	219	814	finally
    //   227	245	814	finally
    //   267	285	814	finally
    //   293	302	814	finally
    //   310	324	814	finally
    //   332	344	814	finally
    //   352	366	814	finally
    //   374	380	814	finally
    //   388	422	814	finally
    //   430	444	814	finally
    //   452	459	814	finally
    //   467	476	814	finally
    //   491	500	814	finally
    //   508	514	870	finally
    //   518	548	870	finally
    //   729	735	870	finally
    //   739	750	870	finally
    //   508	514	878	java/lang/Exception
    //   518	548	878	java/lang/Exception
  }
  
  private void N(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool5 = true;
    anvk localanvk;
    boolean bool3;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "handleGetMedalSwitch success=" + bool1);
      }
      paramFromServiceMsg = this.app.getCurrentUin();
      localanvk = (anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      paramToServiceMsg = localanvk.c(paramFromServiceMsg);
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
                  boolean bool6 = aymo.a(this.app);
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
                  localanvk.a(paramToServiceMsg);
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
                  bool5 = aymo.a(this.app);
                  bool3 = bool1;
                  if (bool6 != bool5)
                  {
                    bool2 = bool1;
                    bool4 = bool1;
                    aymo.a(this.app, bool5);
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
  
  private void O(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
            ((ajmy)this.mApp.getManager(QQManagerFactory.CTENTRY_MNG)).b(i);
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
  
  private void P(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
              aqne.a(this.app).b(i);
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
  private void Q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 10
    //   3: aload_2
    //   4: invokevirtual 100	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   7: ifeq +629 -> 636
    //   10: aload_3
    //   11: ifnull +625 -> 636
    //   14: iconst_1
    //   15: istore 6
    //   17: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +31 -> 51
    //   23: ldc_w 726
    //   26: iconst_2
    //   27: new 20	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   34: ldc_w 923
    //   37: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: iload 6
    //   42: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   45: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   51: iload 6
    //   53: istore 9
    //   55: iload 6
    //   57: ifeq +569 -> 626
    //   60: iload 6
    //   62: istore 7
    //   64: iload 6
    //   66: istore 8
    //   68: new 117	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   71: dup
    //   72: invokespecial 118	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   75: aload_3
    //   76: checkcast 120	[B
    //   79: checkcast 120	[B
    //   82: invokevirtual 124	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   85: checkcast 117	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   88: astore_1
    //   89: iload 6
    //   91: istore 7
    //   93: iload 6
    //   95: istore 8
    //   97: aload_1
    //   98: getfield 128	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   101: invokevirtual 133	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   104: ifne +538 -> 642
    //   107: iconst_1
    //   108: istore 6
    //   110: iload 6
    //   112: istore 7
    //   114: iload 6
    //   116: istore 8
    //   118: aload_1
    //   119: getfield 893	tencent/im/oidb/oidb_sso$OIDBSSOPkg:str_error_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   122: invokevirtual 897	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   125: astore_2
    //   126: iload 6
    //   128: istore 7
    //   130: iload 6
    //   132: istore 8
    //   134: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   137: ifeq +49 -> 186
    //   140: iload 6
    //   142: istore 7
    //   144: iload 6
    //   146: istore 8
    //   148: ldc_w 726
    //   151: iconst_2
    //   152: new 20	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   159: ldc_w 925
    //   162: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: iload 6
    //   167: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   170: ldc_w 901
    //   173: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: aload_2
    //   177: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   186: iload 6
    //   188: istore 9
    //   190: iload 6
    //   192: ifeq +434 -> 626
    //   195: iload 6
    //   197: istore 9
    //   199: iload 6
    //   201: istore 7
    //   203: iload 6
    //   205: istore 8
    //   207: aload_1
    //   208: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   211: invokevirtual 147	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   214: ifeq +412 -> 626
    //   217: iload 6
    //   219: istore 9
    //   221: iload 6
    //   223: istore 7
    //   225: iload 6
    //   227: istore 8
    //   229: aload_1
    //   230: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   233: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   236: ifnull +390 -> 626
    //   239: iload 6
    //   241: istore 7
    //   243: iload 6
    //   245: istore 8
    //   247: new 152	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody
    //   250: dup
    //   251: invokespecial 153	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:<init>	()V
    //   254: astore_2
    //   255: iload 6
    //   257: istore 7
    //   259: iload 6
    //   261: istore 8
    //   263: aload_2
    //   264: aload_1
    //   265: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   268: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   271: invokevirtual 159	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   274: invokevirtual 160	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   277: pop
    //   278: iload 6
    //   280: istore 9
    //   282: iload 6
    //   284: istore 7
    //   286: iload 6
    //   288: istore 8
    //   290: aload_2
    //   291: getfield 164	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   294: invokevirtual 864	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   297: ifeq +329 -> 626
    //   300: iload 6
    //   302: istore 9
    //   304: iload 6
    //   306: istore 7
    //   308: iload 6
    //   310: istore 8
    //   312: aload_2
    //   313: getfield 164	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   316: invokevirtual 401	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   319: invokeinterface 404 1 0
    //   324: ifle +302 -> 626
    //   327: iload 6
    //   329: istore 9
    //   331: iload 6
    //   333: istore 7
    //   335: iload 6
    //   337: istore 8
    //   339: aload_2
    //   340: getfield 164	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   343: invokevirtual 401	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   346: iconst_0
    //   347: invokeinterface 406 2 0
    //   352: checkcast 172	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData
    //   355: getfield 928	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_hidden_session_switch	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   358: invokevirtual 905	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   361: ifeq +265 -> 626
    //   364: iload 6
    //   366: istore 7
    //   368: iload 6
    //   370: istore 8
    //   372: aload_2
    //   373: getfield 164	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   376: invokevirtual 401	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   379: iconst_0
    //   380: invokeinterface 406 2 0
    //   385: checkcast 172	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData
    //   388: getfield 928	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_hidden_session_switch	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   391: invokevirtual 133	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   394: istore 4
    //   396: iload 6
    //   398: istore 7
    //   400: iload 6
    //   402: istore 8
    //   404: aload_2
    //   405: getfield 164	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   408: invokevirtual 401	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   411: iconst_0
    //   412: invokeinterface 406 2 0
    //   417: checkcast 172	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData
    //   420: getfield 931	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_hidden_session_video_switch	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   423: invokevirtual 133	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   426: istore 5
    //   428: iload 6
    //   430: istore 7
    //   432: iload 6
    //   434: istore 8
    //   436: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   439: ifeq +50 -> 489
    //   442: iload 6
    //   444: istore 7
    //   446: iload 6
    //   448: istore 8
    //   450: ldc_w 726
    //   453: iconst_2
    //   454: new 20	java/lang/StringBuilder
    //   457: dup
    //   458: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   461: ldc_w 933
    //   464: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: iload 4
    //   469: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   472: ldc_w 935
    //   475: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   478: iload 5
    //   480: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   483: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   486: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   489: iload 4
    //   491: iflt +62 -> 553
    //   494: iload 6
    //   496: istore 7
    //   498: iload 6
    //   500: istore 8
    //   502: aload_0
    //   503: getfield 689	anri:mApp	Lcom/tencent/common/app/AppInterface;
    //   506: invokevirtual 936	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   509: astore_1
    //   510: iload 6
    //   512: istore 7
    //   514: iload 6
    //   516: istore 8
    //   518: aload_0
    //   519: getfield 689	anri:mApp	Lcom/tencent/common/app/AppInterface;
    //   522: invokevirtual 939	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   525: invokevirtual 942	mqq/app/MobileQQ:getApplicationContext	()Landroid/content/Context;
    //   528: astore_2
    //   529: iload 4
    //   531: iconst_1
    //   532: if_icmpeq +116 -> 648
    //   535: iconst_1
    //   536: istore 9
    //   538: iload 6
    //   540: istore 7
    //   542: iload 6
    //   544: istore 8
    //   546: aload_1
    //   547: aload_2
    //   548: iload 9
    //   550: invokestatic 947	aomh:a	(Ljava/lang/String;Landroid/content/Context;Z)V
    //   553: iload 6
    //   555: istore 9
    //   557: iload 5
    //   559: iflt +67 -> 626
    //   562: iload 6
    //   564: istore 7
    //   566: iload 6
    //   568: istore 8
    //   570: aload_0
    //   571: getfield 689	anri:mApp	Lcom/tencent/common/app/AppInterface;
    //   574: invokevirtual 936	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   577: astore_1
    //   578: iload 6
    //   580: istore 7
    //   582: iload 6
    //   584: istore 8
    //   586: aload_0
    //   587: getfield 689	anri:mApp	Lcom/tencent/common/app/AppInterface;
    //   590: invokevirtual 939	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   593: invokevirtual 942	mqq/app/MobileQQ:getApplicationContext	()Landroid/content/Context;
    //   596: astore_2
    //   597: iload 5
    //   599: iconst_1
    //   600: if_icmpeq +54 -> 654
    //   603: iload 10
    //   605: istore 9
    //   607: iload 6
    //   609: istore 7
    //   611: iload 6
    //   613: istore 8
    //   615: aload_1
    //   616: aload_2
    //   617: iload 9
    //   619: invokestatic 949	aomh:b	(Ljava/lang/String;Landroid/content/Context;Z)V
    //   622: iload 6
    //   624: istore 9
    //   626: aload_0
    //   627: bipush 107
    //   629: iload 9
    //   631: aconst_null
    //   632: invokevirtual 184	anri:notifyUI	(IZLjava/lang/Object;)V
    //   635: return
    //   636: iconst_0
    //   637: istore 6
    //   639: goto -622 -> 17
    //   642: iconst_0
    //   643: istore 6
    //   645: goto -535 -> 110
    //   648: iconst_0
    //   649: istore 9
    //   651: goto -113 -> 538
    //   654: iconst_0
    //   655: istore 9
    //   657: goto -50 -> 607
    //   660: astore_1
    //   661: iload 7
    //   663: istore 8
    //   665: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   668: ifeq +18 -> 686
    //   671: iload 7
    //   673: istore 8
    //   675: ldc_w 726
    //   678: iconst_2
    //   679: ldc_w 951
    //   682: aload_1
    //   683: invokestatic 208	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   686: aload_0
    //   687: bipush 107
    //   689: iload 7
    //   691: aconst_null
    //   692: invokevirtual 184	anri:notifyUI	(IZLjava/lang/Object;)V
    //   695: return
    //   696: astore_1
    //   697: aload_0
    //   698: bipush 107
    //   700: iload 8
    //   702: aconst_null
    //   703: invokevirtual 184	anri:notifyUI	(IZLjava/lang/Object;)V
    //   706: aload_1
    //   707: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	708	0	this	anri
    //   0	708	1	paramToServiceMsg	ToServiceMsg
    //   0	708	2	paramFromServiceMsg	FromServiceMsg
    //   0	708	3	paramObject	Object
    //   394	139	4	i	int
    //   426	175	5	j	int
    //   15	629	6	bool1	boolean
    //   62	628	7	bool2	boolean
    //   66	635	8	bool3	boolean
    //   53	603	9	bool4	boolean
    //   1	603	10	bool5	boolean
    // Exception table:
    //   from	to	target	type
    //   68	89	660	java/lang/Exception
    //   97	107	660	java/lang/Exception
    //   118	126	660	java/lang/Exception
    //   134	140	660	java/lang/Exception
    //   148	186	660	java/lang/Exception
    //   207	217	660	java/lang/Exception
    //   229	239	660	java/lang/Exception
    //   247	255	660	java/lang/Exception
    //   263	278	660	java/lang/Exception
    //   290	300	660	java/lang/Exception
    //   312	327	660	java/lang/Exception
    //   339	364	660	java/lang/Exception
    //   372	396	660	java/lang/Exception
    //   404	428	660	java/lang/Exception
    //   436	442	660	java/lang/Exception
    //   450	489	660	java/lang/Exception
    //   502	510	660	java/lang/Exception
    //   518	529	660	java/lang/Exception
    //   546	553	660	java/lang/Exception
    //   570	578	660	java/lang/Exception
    //   586	597	660	java/lang/Exception
    //   615	622	660	java/lang/Exception
    //   68	89	696	finally
    //   97	107	696	finally
    //   118	126	696	finally
    //   134	140	696	finally
    //   148	186	696	finally
    //   207	217	696	finally
    //   229	239	696	finally
    //   247	255	696	finally
    //   263	278	696	finally
    //   290	300	696	finally
    //   312	327	696	finally
    //   339	364	696	finally
    //   372	396	696	finally
    //   404	428	696	finally
    //   436	442	696	finally
    //   450	489	696	finally
    //   502	510	696	finally
    //   518	529	696	finally
    //   546	553	696	finally
    //   570	578	696	finally
    //   586	597	696	finally
    //   615	622	696	finally
    //   665	671	696	finally
    //   675	686	696	finally
  }
  
  /* Error */
  private void R(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 100	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: ifeq +493 -> 497
    //   7: aload_3
    //   8: ifnull +489 -> 497
    //   11: iconst_1
    //   12: istore 5
    //   14: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   17: ifeq +31 -> 48
    //   20: ldc_w 726
    //   23: iconst_2
    //   24: new 20	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   31: ldc_w 954
    //   34: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: iload 5
    //   39: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   42: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: aload_1
    //   49: getfield 600	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   52: ldc_w 956
    //   55: ldc_w 256
    //   58: invokevirtual 957	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   61: astore_1
    //   62: iload 5
    //   64: istore 8
    //   66: iload 5
    //   68: ifeq +406 -> 474
    //   71: iload 5
    //   73: istore 6
    //   75: iload 5
    //   77: istore 7
    //   79: new 117	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   82: dup
    //   83: invokespecial 118	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   86: aload_3
    //   87: checkcast 120	[B
    //   90: checkcast 120	[B
    //   93: invokevirtual 124	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   96: checkcast 117	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   99: astore_2
    //   100: iload 5
    //   102: istore 6
    //   104: iload 5
    //   106: istore 7
    //   108: aload_2
    //   109: getfield 128	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   112: invokevirtual 133	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   115: ifne +388 -> 503
    //   118: iconst_1
    //   119: istore 5
    //   121: iload 5
    //   123: istore 6
    //   125: iload 5
    //   127: istore 7
    //   129: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   132: ifeq +39 -> 171
    //   135: iload 5
    //   137: istore 6
    //   139: iload 5
    //   141: istore 7
    //   143: ldc_w 726
    //   146: iconst_2
    //   147: new 20	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   154: ldc_w 959
    //   157: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: iload 5
    //   162: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   165: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   168: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   171: iload 5
    //   173: istore 8
    //   175: iload 5
    //   177: ifeq +297 -> 474
    //   180: iload 5
    //   182: istore 8
    //   184: iload 5
    //   186: istore 6
    //   188: iload 5
    //   190: istore 7
    //   192: aload_2
    //   193: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   196: invokevirtual 147	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   199: ifeq +275 -> 474
    //   202: iload 5
    //   204: istore 8
    //   206: iload 5
    //   208: istore 6
    //   210: iload 5
    //   212: istore 7
    //   214: aload_2
    //   215: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   218: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   221: ifnull +253 -> 474
    //   224: iload 5
    //   226: istore 6
    //   228: iload 5
    //   230: istore 7
    //   232: new 152	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody
    //   235: dup
    //   236: invokespecial 153	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:<init>	()V
    //   239: astore_3
    //   240: iload 5
    //   242: istore 6
    //   244: iload 5
    //   246: istore 7
    //   248: aload_3
    //   249: aload_2
    //   250: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   253: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   256: invokevirtual 159	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   259: invokevirtual 160	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   262: pop
    //   263: iload 5
    //   265: istore 8
    //   267: iload 5
    //   269: istore 6
    //   271: iload 5
    //   273: istore 7
    //   275: aload_3
    //   276: getfield 164	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   279: invokevirtual 864	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   282: ifeq +192 -> 474
    //   285: iload 5
    //   287: istore 8
    //   289: iload 5
    //   291: istore 6
    //   293: iload 5
    //   295: istore 7
    //   297: aload_3
    //   298: getfield 164	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   301: invokevirtual 401	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   304: invokeinterface 404 1 0
    //   309: ifle +165 -> 474
    //   312: iload 5
    //   314: istore 8
    //   316: iload 5
    //   318: istore 6
    //   320: iload 5
    //   322: istore 7
    //   324: aload_3
    //   325: getfield 164	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   328: invokevirtual 401	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   331: iconst_0
    //   332: invokeinterface 406 2 0
    //   337: checkcast 172	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData
    //   340: getfield 962	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_do_not_disturb_mode_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   343: invokevirtual 905	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   346: ifeq +128 -> 474
    //   349: iload 5
    //   351: istore 6
    //   353: iload 5
    //   355: istore 7
    //   357: aload_3
    //   358: getfield 164	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   361: invokevirtual 401	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   364: iconst_0
    //   365: invokeinterface 406 2 0
    //   370: checkcast 172	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData
    //   373: getfield 962	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_do_not_disturb_mode_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   376: invokevirtual 133	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   379: istore 4
    //   381: iload 5
    //   383: istore 6
    //   385: iload 5
    //   387: istore 7
    //   389: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   392: ifeq +39 -> 431
    //   395: iload 5
    //   397: istore 6
    //   399: iload 5
    //   401: istore 7
    //   403: ldc_w 726
    //   406: iconst_2
    //   407: new 20	java/lang/StringBuilder
    //   410: dup
    //   411: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   414: ldc_w 964
    //   417: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   420: iload 4
    //   422: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   425: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   428: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   431: iload 5
    //   433: istore 8
    //   435: iload 4
    //   437: iflt +37 -> 474
    //   440: iload 5
    //   442: istore 6
    //   444: iload 5
    //   446: istore 7
    //   448: aload_0
    //   449: getfield 689	anri:mApp	Lcom/tencent/common/app/AppInterface;
    //   452: invokevirtual 939	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   455: invokevirtual 942	mqq/app/MobileQQ:getApplicationContext	()Landroid/content/Context;
    //   458: aconst_null
    //   459: ldc_w 966
    //   462: ldc_w 968
    //   465: iload 4
    //   467: invokestatic 974	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:writeValueForInt	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   470: iload 5
    //   472: istore 8
    //   474: aload_0
    //   475: bipush 98
    //   477: iload 8
    //   479: iconst_2
    //   480: anewarray 262	java/lang/String
    //   483: dup
    //   484: iconst_0
    //   485: ldc_w 256
    //   488: aastore
    //   489: dup
    //   490: iconst_1
    //   491: aload_1
    //   492: aastore
    //   493: invokevirtual 184	anri:notifyUI	(IZLjava/lang/Object;)V
    //   496: return
    //   497: iconst_0
    //   498: istore 5
    //   500: goto -486 -> 14
    //   503: iconst_0
    //   504: istore 5
    //   506: goto -385 -> 121
    //   509: astore_2
    //   510: iload 6
    //   512: istore 7
    //   514: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   517: ifeq +18 -> 535
    //   520: iload 6
    //   522: istore 7
    //   524: ldc_w 726
    //   527: iconst_2
    //   528: ldc_w 976
    //   531: aload_2
    //   532: invokestatic 208	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   535: aload_0
    //   536: bipush 98
    //   538: iload 6
    //   540: iconst_2
    //   541: anewarray 262	java/lang/String
    //   544: dup
    //   545: iconst_0
    //   546: ldc_w 256
    //   549: aastore
    //   550: dup
    //   551: iconst_1
    //   552: aload_1
    //   553: aastore
    //   554: invokevirtual 184	anri:notifyUI	(IZLjava/lang/Object;)V
    //   557: return
    //   558: astore_2
    //   559: aload_0
    //   560: bipush 98
    //   562: iload 7
    //   564: iconst_2
    //   565: anewarray 262	java/lang/String
    //   568: dup
    //   569: iconst_0
    //   570: ldc_w 256
    //   573: aastore
    //   574: dup
    //   575: iconst_1
    //   576: aload_1
    //   577: aastore
    //   578: invokevirtual 184	anri:notifyUI	(IZLjava/lang/Object;)V
    //   581: aload_2
    //   582: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	583	0	this	anri
    //   0	583	1	paramToServiceMsg	ToServiceMsg
    //   0	583	2	paramFromServiceMsg	FromServiceMsg
    //   0	583	3	paramObject	Object
    //   379	87	4	i	int
    //   12	493	5	bool1	boolean
    //   73	466	6	bool2	boolean
    //   77	486	7	bool3	boolean
    //   64	414	8	bool4	boolean
    // Exception table:
    //   from	to	target	type
    //   79	100	509	java/lang/Exception
    //   108	118	509	java/lang/Exception
    //   129	135	509	java/lang/Exception
    //   143	171	509	java/lang/Exception
    //   192	202	509	java/lang/Exception
    //   214	224	509	java/lang/Exception
    //   232	240	509	java/lang/Exception
    //   248	263	509	java/lang/Exception
    //   275	285	509	java/lang/Exception
    //   297	312	509	java/lang/Exception
    //   324	349	509	java/lang/Exception
    //   357	381	509	java/lang/Exception
    //   389	395	509	java/lang/Exception
    //   403	431	509	java/lang/Exception
    //   448	470	509	java/lang/Exception
    //   79	100	558	finally
    //   108	118	558	finally
    //   129	135	558	finally
    //   143	171	558	finally
    //   192	202	558	finally
    //   214	224	558	finally
    //   232	240	558	finally
    //   248	263	558	finally
    //   275	285	558	finally
    //   297	312	558	finally
    //   324	349	558	finally
    //   357	381	558	finally
    //   389	395	558	finally
    //   403	431	558	finally
    //   448	470	558	finally
    //   514	520	558	finally
    //   524	535	558	finally
  }
  
  private void S(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      paramToServiceMsg = paramToServiceMsg.extraData.getString("reqUin", "");
      paramFromServiceMsg = this.app.getCurrentUin();
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
            break label412;
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
      label412:
      bool1 = false;
    }
  }
  
  /* Error */
  private void T(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 10
    //   3: iconst_0
    //   4: istore 12
    //   6: iconst_0
    //   7: istore 11
    //   9: aload_2
    //   10: invokevirtual 100	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   13: ifeq +410 -> 423
    //   16: aload_3
    //   17: ifnull +406 -> 423
    //   20: iconst_1
    //   21: istore 5
    //   23: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +31 -> 57
    //   29: ldc_w 726
    //   32: iconst_2
    //   33: new 20	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   40: ldc_w 1001
    //   43: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: iload 5
    //   48: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   51: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: aload_0
    //   58: getfield 229	anri:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   61: getstatic 1004	com/tencent/mobileqq/app/QQManagerFactory:MGR_ACTVATE_FRIENDS	I
    //   64: invokevirtual 241	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   67: checkcast 1006	aohe
    //   70: astore_1
    //   71: aload_1
    //   72: iconst_0
    //   73: invokevirtual 1009	aohe:a	(Z)Z
    //   76: istore 6
    //   78: iload 5
    //   80: istore 9
    //   82: iload 5
    //   84: ifeq +608 -> 692
    //   87: iload 5
    //   89: istore 7
    //   91: iload 5
    //   93: istore 8
    //   95: new 117	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   98: dup
    //   99: invokespecial 118	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   102: aload_3
    //   103: checkcast 120	[B
    //   106: checkcast 120	[B
    //   109: invokevirtual 124	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   112: checkcast 117	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   115: astore_2
    //   116: aload_2
    //   117: ifnull +312 -> 429
    //   120: iload 5
    //   122: istore 7
    //   124: iload 5
    //   126: istore 8
    //   128: aload_2
    //   129: getfield 128	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   132: invokevirtual 133	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   135: ifne +294 -> 429
    //   138: iconst_1
    //   139: istore 5
    //   141: iload 5
    //   143: istore 7
    //   145: iload 5
    //   147: istore 8
    //   149: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   152: ifeq +39 -> 191
    //   155: iload 5
    //   157: istore 7
    //   159: iload 5
    //   161: istore 8
    //   163: ldc_w 726
    //   166: iconst_2
    //   167: new 20	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   174: ldc_w 1011
    //   177: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: iload 5
    //   182: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   185: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   188: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   191: iload 5
    //   193: istore 9
    //   195: iload 5
    //   197: ifeq +495 -> 692
    //   200: iload 5
    //   202: istore 7
    //   204: iload 5
    //   206: istore 8
    //   208: iload 5
    //   210: istore 9
    //   212: aload_2
    //   213: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   216: invokevirtual 147	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   219: ifeq +473 -> 692
    //   222: iload 5
    //   224: istore 7
    //   226: iload 5
    //   228: istore 8
    //   230: iload 5
    //   232: istore 9
    //   234: aload_2
    //   235: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   238: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   241: ifnull +451 -> 692
    //   244: iload 5
    //   246: istore 7
    //   248: iload 5
    //   250: istore 8
    //   252: aload_2
    //   253: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   256: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   259: invokevirtual 159	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   262: invokestatic 614	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   265: astore_2
    //   266: iload 5
    //   268: istore 7
    //   270: iload 5
    //   272: istore 8
    //   274: aload_2
    //   275: invokevirtual 617	java/nio/ByteBuffer:getInt	()I
    //   278: pop
    //   279: iload 5
    //   281: istore 7
    //   283: iload 5
    //   285: istore 8
    //   287: aload_2
    //   288: invokevirtual 620	java/nio/ByteBuffer:get	()B
    //   291: pop
    //   292: iload 5
    //   294: istore 7
    //   296: iload 5
    //   298: istore 8
    //   300: iload 5
    //   302: istore 9
    //   304: aload_2
    //   305: invokevirtual 624	java/nio/ByteBuffer:getShort	()S
    //   308: invokestatic 635	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   311: invokevirtual 740	java/lang/Short:shortValue	()S
    //   314: iconst_1
    //   315: if_icmpne +377 -> 692
    //   318: iload 5
    //   320: istore 7
    //   322: iload 5
    //   324: istore 8
    //   326: aload_2
    //   327: invokevirtual 624	java/nio/ByteBuffer:getShort	()S
    //   330: istore 4
    //   332: iload 4
    //   334: sipush -25031
    //   337: if_icmpeq +98 -> 435
    //   340: iload 6
    //   342: istore 5
    //   344: iload 11
    //   346: istore 6
    //   348: iload 5
    //   350: istore 7
    //   352: iload 6
    //   354: istore 8
    //   356: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   359: ifeq +50 -> 409
    //   362: ldc_w 726
    //   365: iconst_2
    //   366: new 20	java/lang/StringBuilder
    //   369: dup
    //   370: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   373: ldc_w 1011
    //   376: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: iload 6
    //   381: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   384: ldc_w 742
    //   387: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: iload 5
    //   392: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   395: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   398: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   401: iload 6
    //   403: istore 8
    //   405: iload 5
    //   407: istore 7
    //   409: aload_0
    //   410: bipush 58
    //   412: iload 8
    //   414: iload 7
    //   416: invokestatic 180	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   419: invokevirtual 184	anri:notifyUI	(IZLjava/lang/Object;)V
    //   422: return
    //   423: iconst_0
    //   424: istore 5
    //   426: goto -403 -> 23
    //   429: iconst_0
    //   430: istore 5
    //   432: goto -291 -> 141
    //   435: iload 5
    //   437: istore 7
    //   439: iload 5
    //   441: istore 8
    //   443: aload_2
    //   444: invokevirtual 624	java/nio/ByteBuffer:getShort	()S
    //   447: istore 4
    //   449: iload 4
    //   451: iconst_2
    //   452: if_icmpne +80 -> 532
    //   455: iload 5
    //   457: istore 7
    //   459: iload 5
    //   461: istore 8
    //   463: iload 4
    //   465: newarray byte
    //   467: astore_3
    //   468: iload 5
    //   470: istore 7
    //   472: iload 5
    //   474: istore 8
    //   476: aload_2
    //   477: aload_3
    //   478: invokevirtual 754	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   481: pop
    //   482: iload 5
    //   484: istore 7
    //   486: iload 5
    //   488: istore 8
    //   490: aload_3
    //   491: iconst_0
    //   492: invokestatic 759	bhbx:a	([BI)S
    //   495: istore 4
    //   497: iload 4
    //   499: ifne +215 -> 714
    //   502: iconst_1
    //   503: istore 6
    //   505: aload_2
    //   506: invokevirtual 624	java/nio/ByteBuffer:getShort	()S
    //   509: ifeq +10 -> 519
    //   512: iload 12
    //   514: istore 7
    //   516: goto +187 -> 703
    //   519: aload_1
    //   520: iload 6
    //   522: iconst_0
    //   523: invokevirtual 1014	aohe:a	(ZZ)V
    //   526: iconst_1
    //   527: istore 7
    //   529: goto +174 -> 703
    //   532: iload 6
    //   534: istore 5
    //   536: iload 11
    //   538: istore 6
    //   540: goto -192 -> 348
    //   543: astore_1
    //   544: iload 7
    //   546: istore 5
    //   548: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   551: ifeq +14 -> 565
    //   554: ldc_w 726
    //   557: iconst_2
    //   558: ldc_w 1016
    //   561: aload_1
    //   562: invokestatic 208	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   565: iload 6
    //   567: istore 7
    //   569: iload 10
    //   571: istore 8
    //   573: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   576: ifeq -167 -> 409
    //   579: ldc_w 726
    //   582: iconst_2
    //   583: new 20	java/lang/StringBuilder
    //   586: dup
    //   587: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   590: ldc_w 1011
    //   593: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: iconst_0
    //   597: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   600: ldc_w 742
    //   603: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   606: iload 6
    //   608: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   611: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   614: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   617: iload 6
    //   619: istore 7
    //   621: iload 10
    //   623: istore 8
    //   625: goto -216 -> 409
    //   628: astore_1
    //   629: iload 8
    //   631: istore 5
    //   633: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   636: ifeq +42 -> 678
    //   639: ldc_w 726
    //   642: iconst_2
    //   643: new 20	java/lang/StringBuilder
    //   646: dup
    //   647: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   650: ldc_w 1011
    //   653: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   656: iload 5
    //   658: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   661: ldc_w 742
    //   664: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   667: iload 6
    //   669: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   672: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   675: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   678: aload_1
    //   679: athrow
    //   680: astore_1
    //   681: goto -48 -> 633
    //   684: astore_1
    //   685: goto -52 -> 633
    //   688: astore_1
    //   689: goto -141 -> 548
    //   692: iload 6
    //   694: istore 5
    //   696: iload 9
    //   698: istore 6
    //   700: goto -352 -> 348
    //   703: iload 6
    //   705: istore 5
    //   707: iload 7
    //   709: istore 6
    //   711: goto -363 -> 348
    //   714: iconst_0
    //   715: istore 6
    //   717: goto -212 -> 505
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	720	0	this	anri
    //   0	720	1	paramToServiceMsg	ToServiceMsg
    //   0	720	2	paramFromServiceMsg	FromServiceMsg
    //   0	720	3	paramObject	Object
    //   330	168	4	i	int
    //   21	685	5	bool1	boolean
    //   76	640	6	bool2	boolean
    //   89	619	7	bool3	boolean
    //   93	537	8	bool4	boolean
    //   80	617	9	bool5	boolean
    //   1	621	10	bool6	boolean
    //   7	530	11	bool7	boolean
    //   4	509	12	bool8	boolean
    // Exception table:
    //   from	to	target	type
    //   95	116	543	java/lang/Exception
    //   128	138	543	java/lang/Exception
    //   149	155	543	java/lang/Exception
    //   163	191	543	java/lang/Exception
    //   212	222	543	java/lang/Exception
    //   234	244	543	java/lang/Exception
    //   252	266	543	java/lang/Exception
    //   274	279	543	java/lang/Exception
    //   287	292	543	java/lang/Exception
    //   304	318	543	java/lang/Exception
    //   326	332	543	java/lang/Exception
    //   443	449	543	java/lang/Exception
    //   463	468	543	java/lang/Exception
    //   476	482	543	java/lang/Exception
    //   490	497	543	java/lang/Exception
    //   95	116	628	finally
    //   128	138	628	finally
    //   149	155	628	finally
    //   163	191	628	finally
    //   212	222	628	finally
    //   234	244	628	finally
    //   252	266	628	finally
    //   274	279	628	finally
    //   287	292	628	finally
    //   304	318	628	finally
    //   326	332	628	finally
    //   443	449	628	finally
    //   463	468	628	finally
    //   476	482	628	finally
    //   490	497	628	finally
    //   505	512	680	finally
    //   519	526	680	finally
    //   548	565	684	finally
    //   505	512	688	java/lang/Exception
    //   519	526	688	java/lang/Exception
  }
  
  private void U(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
      paramFromServiceMsg = (aohe)this.app.getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS);
      bool2 = paramFromServiceMsg.a(false);
      bool5 = bool1;
      if (!bool1) {
        break label662;
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
              break label662;
            }
            bool4 = bool1;
            bool3 = bool1;
            bool5 = bool1;
            if (!paramObject.bytes_bodybuffer.has()) {
              break label662;
            }
            bool4 = bool1;
            bool3 = bool1;
            bool5 = bool1;
            if (paramObject.bytes_bodybuffer.get() == null) {
              break label662;
            }
            bool4 = bool1;
            bool3 = bool1;
            l = bhbx.a(ByteBuffer.wrap(paramObject.bytes_bodybuffer.get().toByteArray()).getInt());
            bool4 = bool1;
            bool3 = bool1;
            if (!this.app.getCurrentAccountUin().equals(String.valueOf(l))) {
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
          break label655;
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
        QLog.d("Q.profilecard.", 2, "handleSetActivateFriendSwitch cur:" + this.app.getCurrentAccountUin() + " dwUin:" + l);
      }
      bool1 = false;
      continue;
      label655:
      label662:
      bool1 = bool5;
    }
  }
  
  /* Error */
  private void V(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 10
    //   3: aload_2
    //   4: invokevirtual 100	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   7: ifeq +416 -> 423
    //   10: aload_3
    //   11: ifnull +412 -> 423
    //   14: iconst_1
    //   15: istore 6
    //   17: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +31 -> 51
    //   23: ldc_w 726
    //   26: iconst_2
    //   27: new 20	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   34: ldc_w 1033
    //   37: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: iload 6
    //   42: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   45: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   51: aload_0
    //   52: getfield 229	anri:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   55: getstatic 235	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   58: invokevirtual 241	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   61: checkcast 243	anvk
    //   64: astore_1
    //   65: aload_1
    //   66: getstatic 1036	com/tencent/mobileqq/app/AppConstants:BABY_Q_UIN	Ljava/lang/String;
    //   69: invokevirtual 735	anvk:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   72: astore_2
    //   73: iload 6
    //   75: istore 9
    //   77: iload 6
    //   79: ifeq +636 -> 715
    //   82: iload 6
    //   84: istore 7
    //   86: iload 6
    //   88: istore 8
    //   90: new 117	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   93: dup
    //   94: invokespecial 118	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   97: aload_3
    //   98: checkcast 120	[B
    //   101: checkcast 120	[B
    //   104: invokevirtual 124	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   107: checkcast 117	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   110: astore_3
    //   111: aload_3
    //   112: ifnull +317 -> 429
    //   115: iload 6
    //   117: istore 7
    //   119: iload 6
    //   121: istore 8
    //   123: aload_3
    //   124: getfield 128	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   127: invokevirtual 133	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   130: ifne +299 -> 429
    //   133: iconst_1
    //   134: istore 6
    //   136: iload 6
    //   138: istore 7
    //   140: iload 6
    //   142: istore 8
    //   144: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   147: ifeq +39 -> 186
    //   150: iload 6
    //   152: istore 7
    //   154: iload 6
    //   156: istore 8
    //   158: ldc_w 726
    //   161: iconst_2
    //   162: new 20	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   169: ldc_w 1038
    //   172: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: iload 6
    //   177: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   180: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   186: iload 6
    //   188: istore 9
    //   190: iload 6
    //   192: ifeq +523 -> 715
    //   195: iload 6
    //   197: istore 7
    //   199: iload 6
    //   201: istore 8
    //   203: iload 6
    //   205: istore 9
    //   207: aload_3
    //   208: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   211: invokevirtual 147	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   214: ifeq +501 -> 715
    //   217: iload 6
    //   219: istore 7
    //   221: iload 6
    //   223: istore 8
    //   225: iload 6
    //   227: istore 9
    //   229: aload_3
    //   230: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   233: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   236: ifnull +479 -> 715
    //   239: iload 6
    //   241: istore 7
    //   243: iload 6
    //   245: istore 8
    //   247: aload_3
    //   248: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   251: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   254: invokevirtual 159	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   257: invokestatic 614	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   260: astore_3
    //   261: iload 6
    //   263: istore 7
    //   265: iload 6
    //   267: istore 8
    //   269: aload_3
    //   270: invokevirtual 617	java/nio/ByteBuffer:getInt	()I
    //   273: pop
    //   274: iload 6
    //   276: istore 7
    //   278: iload 6
    //   280: istore 8
    //   282: aload_3
    //   283: invokevirtual 620	java/nio/ByteBuffer:get	()B
    //   286: pop
    //   287: iload 6
    //   289: istore 7
    //   291: iload 6
    //   293: istore 8
    //   295: iload 6
    //   297: istore 9
    //   299: aload_3
    //   300: invokevirtual 624	java/nio/ByteBuffer:getShort	()S
    //   303: invokestatic 635	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   306: invokevirtual 740	java/lang/Short:shortValue	()S
    //   309: iconst_1
    //   310: if_icmpne +405 -> 715
    //   313: iload 6
    //   315: istore 7
    //   317: iload 6
    //   319: istore 8
    //   321: aload_3
    //   322: invokevirtual 624	java/nio/ByteBuffer:getShort	()S
    //   325: istore 4
    //   327: iload 6
    //   329: istore 7
    //   331: iload 6
    //   333: istore 8
    //   335: aload_0
    //   336: getfield 76	anri:e	S
    //   339: istore 5
    //   341: iload 4
    //   343: iload 5
    //   345: if_icmpeq +90 -> 435
    //   348: iload 10
    //   350: istore 7
    //   352: iload 7
    //   354: istore 8
    //   356: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   359: ifeq +48 -> 407
    //   362: ldc_w 726
    //   365: iconst_2
    //   366: new 20	java/lang/StringBuilder
    //   369: dup
    //   370: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   373: ldc_w 1038
    //   376: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: iload 7
    //   381: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   384: ldc_w 1040
    //   387: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: aload_2
    //   391: getfield 1043	com/tencent/mobileqq/data/Card:babyQSwitch	Z
    //   394: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   397: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   403: iload 7
    //   405: istore 8
    //   407: aload_0
    //   408: bipush 75
    //   410: iload 8
    //   412: aload_2
    //   413: getfield 1043	com/tencent/mobileqq/data/Card:babyQSwitch	Z
    //   416: invokestatic 180	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   419: invokevirtual 184	anri:notifyUI	(IZLjava/lang/Object;)V
    //   422: return
    //   423: iconst_0
    //   424: istore 6
    //   426: goto -409 -> 17
    //   429: iconst_0
    //   430: istore 6
    //   432: goto -296 -> 136
    //   435: iload 6
    //   437: istore 7
    //   439: iload 6
    //   441: istore 8
    //   443: aload_3
    //   444: invokevirtual 624	java/nio/ByteBuffer:getShort	()S
    //   447: istore 4
    //   449: iload 10
    //   451: istore 7
    //   453: iload 4
    //   455: iconst_2
    //   456: if_icmpne -104 -> 352
    //   459: iload 6
    //   461: istore 7
    //   463: iload 6
    //   465: istore 8
    //   467: iload 4
    //   469: newarray byte
    //   471: astore 11
    //   473: iload 6
    //   475: istore 7
    //   477: iload 6
    //   479: istore 8
    //   481: aload_3
    //   482: aload 11
    //   484: invokevirtual 754	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   487: pop
    //   488: iload 6
    //   490: istore 7
    //   492: iload 6
    //   494: istore 8
    //   496: aload 11
    //   498: iconst_0
    //   499: invokestatic 759	bhbx:a	([BI)S
    //   502: ifne +55 -> 557
    //   505: iconst_1
    //   506: istore 9
    //   508: iload 6
    //   510: istore 7
    //   512: iload 6
    //   514: istore 8
    //   516: aload_2
    //   517: iload 9
    //   519: putfield 1043	com/tencent/mobileqq/data/Card:babyQSwitch	Z
    //   522: iload 6
    //   524: istore 7
    //   526: iload 6
    //   528: istore 8
    //   530: aload_3
    //   531: invokevirtual 624	java/nio/ByteBuffer:getShort	()S
    //   534: istore 4
    //   536: iload 10
    //   538: istore 7
    //   540: iload 4
    //   542: ifne -190 -> 352
    //   545: aload_1
    //   546: aload_2
    //   547: invokevirtual 762	anvk:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   550: pop
    //   551: iconst_1
    //   552: istore 7
    //   554: goto -202 -> 352
    //   557: iconst_0
    //   558: istore 9
    //   560: goto -52 -> 508
    //   563: astore_1
    //   564: iload 7
    //   566: istore 6
    //   568: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   571: ifeq +14 -> 585
    //   574: ldc_w 726
    //   577: iconst_2
    //   578: ldc_w 1045
    //   581: aload_1
    //   582: invokestatic 208	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   585: iload 6
    //   587: istore 8
    //   589: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   592: ifeq -185 -> 407
    //   595: ldc_w 726
    //   598: iconst_2
    //   599: new 20	java/lang/StringBuilder
    //   602: dup
    //   603: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   606: ldc_w 1038
    //   609: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   612: iload 6
    //   614: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   617: ldc_w 1040
    //   620: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   623: aload_2
    //   624: getfield 1043	com/tencent/mobileqq/data/Card:babyQSwitch	Z
    //   627: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   630: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   633: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   636: iload 6
    //   638: istore 8
    //   640: goto -233 -> 407
    //   643: astore_1
    //   644: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   647: ifeq +44 -> 691
    //   650: ldc_w 726
    //   653: iconst_2
    //   654: new 20	java/lang/StringBuilder
    //   657: dup
    //   658: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   661: ldc_w 1038
    //   664: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   667: iload 8
    //   669: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   672: ldc_w 1040
    //   675: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: aload_2
    //   679: getfield 1043	com/tencent/mobileqq/data/Card:babyQSwitch	Z
    //   682: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   685: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   688: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   691: aload_1
    //   692: athrow
    //   693: astore_1
    //   694: iconst_1
    //   695: istore 8
    //   697: goto -53 -> 644
    //   700: astore_1
    //   701: iload 6
    //   703: istore 8
    //   705: goto -61 -> 644
    //   708: astore_1
    //   709: iconst_1
    //   710: istore 6
    //   712: goto -144 -> 568
    //   715: iload 9
    //   717: istore 7
    //   719: goto -367 -> 352
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	722	0	this	anri
    //   0	722	1	paramToServiceMsg	ToServiceMsg
    //   0	722	2	paramFromServiceMsg	FromServiceMsg
    //   0	722	3	paramObject	Object
    //   325	216	4	i	int
    //   339	7	5	j	int
    //   15	696	6	bool1	boolean
    //   84	634	7	bool2	boolean
    //   88	616	8	bool3	boolean
    //   75	641	9	bool4	boolean
    //   1	536	10	bool5	boolean
    //   471	26	11	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   90	111	563	java/lang/Exception
    //   123	133	563	java/lang/Exception
    //   144	150	563	java/lang/Exception
    //   158	186	563	java/lang/Exception
    //   207	217	563	java/lang/Exception
    //   229	239	563	java/lang/Exception
    //   247	261	563	java/lang/Exception
    //   269	274	563	java/lang/Exception
    //   282	287	563	java/lang/Exception
    //   299	313	563	java/lang/Exception
    //   321	327	563	java/lang/Exception
    //   335	341	563	java/lang/Exception
    //   443	449	563	java/lang/Exception
    //   467	473	563	java/lang/Exception
    //   481	488	563	java/lang/Exception
    //   496	505	563	java/lang/Exception
    //   516	522	563	java/lang/Exception
    //   530	536	563	java/lang/Exception
    //   90	111	643	finally
    //   123	133	643	finally
    //   144	150	643	finally
    //   158	186	643	finally
    //   207	217	643	finally
    //   229	239	643	finally
    //   247	261	643	finally
    //   269	274	643	finally
    //   282	287	643	finally
    //   299	313	643	finally
    //   321	327	643	finally
    //   335	341	643	finally
    //   443	449	643	finally
    //   467	473	643	finally
    //   481	488	643	finally
    //   496	505	643	finally
    //   516	522	643	finally
    //   530	536	643	finally
    //   545	551	693	finally
    //   568	585	700	finally
    //   545	551	708	java/lang/Exception
  }
  
  private void W(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
        break label616;
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
          break label616;
        }
        bool2 = bool1;
        bool3 = bool1;
        bool4 = bool1;
        if (!paramFromServiceMsg.bytes_bodybuffer.has()) {
          break label616;
        }
        bool2 = bool1;
        bool3 = bool1;
        bool4 = bool1;
        if (paramFromServiceMsg.bytes_bodybuffer.get() == null) {
          break label616;
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
        if (!this.app.getCurrentAccountUin().equals(String.valueOf(l))) {
          continue;
        }
        bool2 = bool1;
        bool3 = bool1;
        paramFromServiceMsg = (anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
        bool2 = bool1;
        bool3 = bool1;
        paramObject = paramFromServiceMsg.c(AppConstants.BABY_Q_UIN);
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
      label616:
      bool1 = bool4;
    }
  }
  
  /* Error */
  private void X(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 9
    //   3: aload_2
    //   4: invokevirtual 100	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   7: ifeq +398 -> 405
    //   10: aload_3
    //   11: ifnull +394 -> 405
    //   14: iconst_1
    //   15: istore 5
    //   17: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +31 -> 51
    //   23: ldc_w 726
    //   26: iconst_2
    //   27: new 20	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   34: ldc_w 1055
    //   37: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: iload 5
    //   42: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   45: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   51: aload_0
    //   52: getfield 229	anri:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   55: invokevirtual 1056	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   58: ldc_w 1057
    //   61: invokevirtual 1060	mqq/app/MobileQQ:getString	(I)Ljava/lang/String;
    //   64: pop
    //   65: aload_0
    //   66: getfield 229	anri:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   69: invokevirtual 294	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   72: pop
    //   73: iload 5
    //   75: istore 8
    //   77: iload 5
    //   79: ifeq +567 -> 646
    //   82: iload 5
    //   84: istore 6
    //   86: iload 5
    //   88: istore 7
    //   90: new 117	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   93: dup
    //   94: invokespecial 118	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   97: aload_3
    //   98: checkcast 120	[B
    //   101: checkcast 120	[B
    //   104: invokevirtual 124	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   107: checkcast 117	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   110: astore_2
    //   111: aload_2
    //   112: ifnull +299 -> 411
    //   115: iload 5
    //   117: istore 6
    //   119: iload 5
    //   121: istore 7
    //   123: aload_2
    //   124: getfield 128	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   127: invokevirtual 133	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   130: ifne +281 -> 411
    //   133: iconst_1
    //   134: istore 5
    //   136: iload 5
    //   138: istore 6
    //   140: iload 5
    //   142: istore 7
    //   144: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   147: ifeq +39 -> 186
    //   150: iload 5
    //   152: istore 6
    //   154: iload 5
    //   156: istore 7
    //   158: ldc_w 726
    //   161: iconst_2
    //   162: new 20	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   169: ldc_w 1062
    //   172: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: iload 5
    //   177: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   180: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   186: iload 5
    //   188: istore 8
    //   190: iload 5
    //   192: ifeq +454 -> 646
    //   195: iload 5
    //   197: istore 6
    //   199: iload 5
    //   201: istore 7
    //   203: iload 5
    //   205: istore 8
    //   207: aload_2
    //   208: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   211: invokevirtual 147	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   214: ifeq +432 -> 646
    //   217: iload 5
    //   219: istore 6
    //   221: iload 5
    //   223: istore 7
    //   225: iload 5
    //   227: istore 8
    //   229: aload_2
    //   230: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   233: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   236: ifnull +410 -> 646
    //   239: iload 5
    //   241: istore 6
    //   243: iload 5
    //   245: istore 7
    //   247: aload_2
    //   248: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   251: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   254: invokevirtual 159	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   257: invokestatic 614	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   260: invokevirtual 617	java/nio/ByteBuffer:getInt	()I
    //   263: istore 4
    //   265: iload 4
    //   267: i2l
    //   268: lstore 10
    //   270: iload 4
    //   272: ifge +16 -> 288
    //   275: iload 4
    //   277: ldc_w 1063
    //   280: iand
    //   281: i2l
    //   282: ldc2_w 1064
    //   285: lor
    //   286: lstore 10
    //   288: iload 5
    //   290: istore 6
    //   292: iload 5
    //   294: istore 7
    //   296: aload_0
    //   297: getfield 229	anri:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   300: invokevirtual 294	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   303: lload 10
    //   305: invokestatic 680	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   308: invokevirtual 683	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   311: istore 5
    //   313: iload 5
    //   315: ifeq +102 -> 417
    //   318: aload_1
    //   319: getfield 600	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   322: ldc_w 1067
    //   325: invokevirtual 673	android/os/Bundle:getShort	(Ljava/lang/String;)S
    //   328: istore 4
    //   330: aload_0
    //   331: getfield 229	anri:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   334: getstatic 1072	com/tencent/mobileqq/app/BusinessHandlerFactory:DEVICEPROXYMGR_HANDLER	I
    //   337: invokevirtual 1076	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   340: checkcast 1078	abgm
    //   343: iload 4
    //   345: invokevirtual 1079	abgm:b	(I)V
    //   348: iconst_1
    //   349: istore 5
    //   351: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   354: ifeq +50 -> 404
    //   357: ldc_w 726
    //   360: iconst_2
    //   361: new 20	java/lang/StringBuilder
    //   364: dup
    //   365: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   368: ldc_w 1062
    //   371: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: iload 5
    //   376: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   379: ldc_w 742
    //   382: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: aload_1
    //   386: getfield 600	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   389: ldc_w 1067
    //   392: invokevirtual 673	android/os/Bundle:getShort	(Ljava/lang/String;)S
    //   395: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   398: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   401: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   404: return
    //   405: iconst_0
    //   406: istore 5
    //   408: goto -391 -> 17
    //   411: iconst_0
    //   412: istore 5
    //   414: goto -278 -> 136
    //   417: iload 9
    //   419: istore 5
    //   421: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   424: ifeq -73 -> 351
    //   427: ldc_w 726
    //   430: iconst_2
    //   431: new 20	java/lang/StringBuilder
    //   434: dup
    //   435: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   438: ldc_w 1081
    //   441: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: lload 10
    //   446: invokevirtual 840	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   449: ldc_w 1083
    //   452: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: aload_0
    //   456: getfield 229	anri:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   459: invokevirtual 294	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   462: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   468: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   471: iload 9
    //   473: istore 5
    //   475: goto -124 -> 351
    //   478: astore_2
    //   479: iconst_0
    //   480: istore 5
    //   482: iload 5
    //   484: istore 6
    //   486: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   489: ifeq +18 -> 507
    //   492: iload 5
    //   494: istore 6
    //   496: ldc_w 726
    //   499: iconst_2
    //   500: ldc_w 1085
    //   503: aload_2
    //   504: invokestatic 208	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   507: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   510: ifeq -106 -> 404
    //   513: ldc_w 726
    //   516: iconst_2
    //   517: new 20	java/lang/StringBuilder
    //   520: dup
    //   521: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   524: ldc_w 1062
    //   527: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   530: iload 5
    //   532: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   535: ldc_w 742
    //   538: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   541: aload_1
    //   542: getfield 600	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   545: ldc_w 1067
    //   548: invokevirtual 673	android/os/Bundle:getShort	(Ljava/lang/String;)S
    //   551: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   554: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   557: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   560: return
    //   561: astore_2
    //   562: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   565: ifeq +50 -> 615
    //   568: ldc_w 726
    //   571: iconst_2
    //   572: new 20	java/lang/StringBuilder
    //   575: dup
    //   576: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   579: ldc_w 1062
    //   582: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: iload 6
    //   587: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   590: ldc_w 742
    //   593: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: aload_1
    //   597: getfield 600	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   600: ldc_w 1067
    //   603: invokevirtual 673	android/os/Bundle:getShort	(Ljava/lang/String;)S
    //   606: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   609: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   612: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   615: aload_2
    //   616: athrow
    //   617: astore_2
    //   618: iconst_1
    //   619: istore 6
    //   621: goto -59 -> 562
    //   624: astore_2
    //   625: iconst_0
    //   626: istore 6
    //   628: goto -66 -> 562
    //   631: astore_2
    //   632: iload 7
    //   634: istore 5
    //   636: goto -154 -> 482
    //   639: astore_2
    //   640: iconst_1
    //   641: istore 5
    //   643: goto -161 -> 482
    //   646: iload 8
    //   648: istore 5
    //   650: goto -299 -> 351
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	653	0	this	anri
    //   0	653	1	paramToServiceMsg	ToServiceMsg
    //   0	653	2	paramFromServiceMsg	FromServiceMsg
    //   0	653	3	paramObject	Object
    //   263	81	4	i	int
    //   15	634	5	bool1	boolean
    //   84	543	6	bool2	boolean
    //   88	545	7	bool3	boolean
    //   75	572	8	bool4	boolean
    //   1	471	9	bool5	boolean
    //   268	177	10	l	long
    // Exception table:
    //   from	to	target	type
    //   421	471	478	java/lang/Exception
    //   90	111	561	finally
    //   123	133	561	finally
    //   144	150	561	finally
    //   158	186	561	finally
    //   207	217	561	finally
    //   229	239	561	finally
    //   247	265	561	finally
    //   296	313	561	finally
    //   486	492	561	finally
    //   496	507	561	finally
    //   318	348	617	finally
    //   421	471	624	finally
    //   90	111	631	java/lang/Exception
    //   123	133	631	java/lang/Exception
    //   144	150	631	java/lang/Exception
    //   158	186	631	java/lang/Exception
    //   207	217	631	java/lang/Exception
    //   229	239	631	java/lang/Exception
    //   247	265	631	java/lang/Exception
    //   296	313	631	java/lang/Exception
    //   318	348	639	java/lang/Exception
  }
  
  /* Error */
  private void Y(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 8
    //   3: aload_2
    //   4: invokevirtual 100	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   7: ifeq +372 -> 379
    //   10: aload_3
    //   11: ifnull +368 -> 379
    //   14: iconst_1
    //   15: istore 5
    //   17: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +31 -> 51
    //   23: ldc_w 726
    //   26: iconst_2
    //   27: new 20	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   34: ldc_w 1088
    //   37: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: iload 5
    //   42: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   45: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   51: aload_0
    //   52: getfield 229	anri:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   55: invokevirtual 1056	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   58: ldc_w 1057
    //   61: invokevirtual 1060	mqq/app/MobileQQ:getString	(I)Ljava/lang/String;
    //   64: pop
    //   65: aload_0
    //   66: getfield 229	anri:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   69: invokevirtual 294	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   72: pop
    //   73: iload 5
    //   75: ifeq +465 -> 540
    //   78: iload 5
    //   80: istore 6
    //   82: iload 5
    //   84: istore 7
    //   86: new 117	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   89: dup
    //   90: invokespecial 118	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   93: aload_3
    //   94: checkcast 120	[B
    //   97: checkcast 120	[B
    //   100: invokevirtual 124	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   103: checkcast 117	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   106: astore_2
    //   107: aload_2
    //   108: ifnull +277 -> 385
    //   111: iload 5
    //   113: istore 6
    //   115: iload 5
    //   117: istore 7
    //   119: aload_2
    //   120: getfield 128	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   123: invokevirtual 133	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   126: ifne +259 -> 385
    //   129: iconst_1
    //   130: istore 5
    //   132: iload 5
    //   134: istore 6
    //   136: iload 5
    //   138: istore 7
    //   140: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   143: ifeq +39 -> 182
    //   146: iload 5
    //   148: istore 6
    //   150: iload 5
    //   152: istore 7
    //   154: ldc_w 726
    //   157: iconst_2
    //   158: new 20	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   165: ldc_w 1090
    //   168: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   171: iload 5
    //   173: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   176: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   179: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   182: iload 5
    //   184: ifeq +426 -> 610
    //   187: iload 5
    //   189: istore 6
    //   191: iload 5
    //   193: istore 7
    //   195: aload_2
    //   196: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   199: invokevirtual 147	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   202: ifeq +408 -> 610
    //   205: iload 5
    //   207: istore 6
    //   209: iload 5
    //   211: istore 7
    //   213: aload_2
    //   214: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   217: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   220: ifnull +390 -> 610
    //   223: iload 5
    //   225: istore 6
    //   227: iload 5
    //   229: istore 7
    //   231: aload_2
    //   232: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   235: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   238: invokevirtual 159	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   241: invokestatic 614	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   244: invokevirtual 617	java/nio/ByteBuffer:getInt	()I
    //   247: istore 4
    //   249: iload 4
    //   251: i2l
    //   252: lstore 10
    //   254: iload 4
    //   256: ifge +16 -> 272
    //   259: iload 4
    //   261: ldc_w 1063
    //   264: iand
    //   265: i2l
    //   266: ldc2_w 1064
    //   269: lor
    //   270: lstore 10
    //   272: iload 5
    //   274: istore 6
    //   276: iload 5
    //   278: istore 7
    //   280: aload_1
    //   281: getfield 600	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   284: ldc_w 799
    //   287: invokevirtual 803	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   290: istore 9
    //   292: iload 5
    //   294: istore 6
    //   296: iload 5
    //   298: istore 7
    //   300: aload_0
    //   301: getfield 229	anri:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   304: invokevirtual 294	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   307: lload 10
    //   309: invokestatic 680	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   312: invokevirtual 683	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   315: istore 5
    //   317: iload 5
    //   319: ifeq +72 -> 391
    //   322: iconst_1
    //   323: istore 5
    //   325: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   328: ifeq +50 -> 378
    //   331: ldc_w 726
    //   334: iconst_2
    //   335: new 20	java/lang/StringBuilder
    //   338: dup
    //   339: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   342: ldc_w 1090
    //   345: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: iload 5
    //   350: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   353: ldc_w 742
    //   356: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: aload_1
    //   360: getfield 600	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   363: ldc_w 799
    //   366: invokevirtual 803	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   369: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   372: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   375: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   378: return
    //   379: iconst_0
    //   380: istore 5
    //   382: goto -365 -> 17
    //   385: iconst_0
    //   386: istore 5
    //   388: goto -256 -> 132
    //   391: iload 9
    //   393: ifne +3 -> 396
    //   396: iload 8
    //   398: istore 5
    //   400: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   403: ifeq -78 -> 325
    //   406: ldc_w 726
    //   409: iconst_2
    //   410: new 20	java/lang/StringBuilder
    //   413: dup
    //   414: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   417: ldc_w 1092
    //   420: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: lload 10
    //   425: invokevirtual 840	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   428: ldc_w 1083
    //   431: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: aload_0
    //   435: getfield 229	anri:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   438: invokevirtual 294	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   441: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   447: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   450: iload 8
    //   452: istore 5
    //   454: goto -129 -> 325
    //   457: astore_2
    //   458: iconst_0
    //   459: istore 7
    //   461: iload 7
    //   463: istore 6
    //   465: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   468: ifeq +18 -> 486
    //   471: iload 7
    //   473: istore 6
    //   475: ldc_w 726
    //   478: iconst_2
    //   479: ldc_w 1094
    //   482: aload_2
    //   483: invokestatic 208	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   486: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   489: ifeq -111 -> 378
    //   492: ldc_w 726
    //   495: iconst_2
    //   496: new 20	java/lang/StringBuilder
    //   499: dup
    //   500: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   503: ldc_w 1090
    //   506: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: iload 7
    //   511: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   514: ldc_w 742
    //   517: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: aload_1
    //   521: getfield 600	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   524: ldc_w 799
    //   527: invokevirtual 803	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   530: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   533: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   536: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   539: return
    //   540: goto -215 -> 325
    //   543: astore_2
    //   544: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   547: ifeq +50 -> 597
    //   550: ldc_w 726
    //   553: iconst_2
    //   554: new 20	java/lang/StringBuilder
    //   557: dup
    //   558: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   561: ldc_w 1090
    //   564: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: iload 6
    //   569: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   572: ldc_w 742
    //   575: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: aload_1
    //   579: getfield 600	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   582: ldc_w 799
    //   585: invokevirtual 803	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   588: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   591: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   594: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   597: aload_2
    //   598: athrow
    //   599: astore_2
    //   600: iconst_0
    //   601: istore 6
    //   603: goto -59 -> 544
    //   606: astore_2
    //   607: goto -146 -> 461
    //   610: goto -285 -> 325
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	613	0	this	anri
    //   0	613	1	paramToServiceMsg	ToServiceMsg
    //   0	613	2	paramFromServiceMsg	FromServiceMsg
    //   0	613	3	paramObject	Object
    //   247	18	4	i	int
    //   15	438	5	bool1	boolean
    //   80	522	6	bool2	boolean
    //   84	426	7	bool3	boolean
    //   1	450	8	bool4	boolean
    //   290	102	9	bool5	boolean
    //   252	172	10	l	long
    // Exception table:
    //   from	to	target	type
    //   400	450	457	java/lang/Exception
    //   86	107	543	finally
    //   119	129	543	finally
    //   140	146	543	finally
    //   154	182	543	finally
    //   195	205	543	finally
    //   213	223	543	finally
    //   231	249	543	finally
    //   280	292	543	finally
    //   300	317	543	finally
    //   465	471	543	finally
    //   475	486	543	finally
    //   400	450	599	finally
    //   86	107	606	java/lang/Exception
    //   119	129	606	java/lang/Exception
    //   140	146	606	java/lang/Exception
    //   154	182	606	java/lang/Exception
    //   195	205	606	java/lang/Exception
    //   213	223	606	java/lang/Exception
    //   231	249	606	java/lang/Exception
    //   280	292	606	java/lang/Exception
    //   300	317	606	java/lang/Exception
  }
  
  private void Z(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
        break label497;
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
          label300:
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
          l = bhbx.a(paramObject.getInt());
          paramObject.get();
          if (Short.valueOf(paramObject.getShort()).shortValue() != 1) {
            continue;
          }
          j = paramObject.getShort();
          if (j != -25126)
          {
            paramToServiceMsg = paramFromServiceMsg;
            notifyUI(68, bool2, paramToServiceMsg);
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
            j = bhbx.a(paramFromServiceMsg, 0);
            if (paramObject.getShort() == 0) {
              break label567;
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
        paramFromServiceMsg = (bjxa)this.mApp.getManager(QQManagerFactory.QIDIAN_MANAGER);
        paramFromServiceMsg.a(paramToServiceMsg);
        if ((i == 1) && (bool2)) {
          paramFromServiceMsg.a(this.mApp.getApp().getBaseContext(), paramToServiceMsg);
        } else {
          paramFromServiceMsg.b(this.mApp.getApp().getBaseContext(), paramToServiceMsg);
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
          label497:
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
      label567:
      if (j == 0) {
        break label300;
      }
      i = 1;
      break label300;
      bool2 = true;
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
  
  @NotNull
  private ExtensionInfo a(anvk paramanvk, String paramString)
  {
    ExtensionInfo localExtensionInfo = paramanvk.a(paramString);
    paramanvk = localExtensionInfo;
    if (localExtensionInfo == null)
    {
      paramanvk = new ExtensionInfo();
      paramanvk.uin = paramString;
    }
    return paramanvk;
  }
  
  public static String a(String paramString, int paramInt)
  {
    if ((paramString == null) || ("".equals(paramString)) || (!jdField_a_of_type_JavaUtilVector.contains(Integer.valueOf(paramInt)))) {
      return "";
    }
    return jdField_a_of_type_JavaLangString + paramInt + "/" + paramString + ".jpg";
  }
  
  public static String a(List<FaceInfo> paramList)
  {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.clear();
    if (paramList.size() > 0)
    {
      int i = 0;
      while (i < paramList.size())
      {
        localLinkedList.add(HexUtil.bytes2HexStr(((FaceInfo)paramList.get(i)).vFaceID));
        i += 1;
      }
      return b(localLinkedList);
    }
    return ";";
  }
  
  public static LinkedList<String> a(String paramString)
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
  
  private short a(short paramShort, boolean paramBoolean)
  {
    short s = 1;
    if (((awtq)this.app.getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER)).b(paramShort))
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
  
  private void a(long paramLong, int paramInt, RespSummaryCard paramRespSummaryCard, String paramString)
  {
    TroopManager localTroopManager;
    if (paramLong > 0L)
    {
      localTroopManager = (TroopManager)this.app.getManager(QQManagerFactory.TROOP_MANAGER);
      if ((paramInt != 2) && (paramInt != 5) && (paramInt != 7)) {
        break label192;
      }
      paramString = localTroopManager.b(String.valueOf(paramLong));
      if (paramString != null)
      {
        if (paramString.troopname == null) {
          break label164;
        }
        if (!paramString.troopname.equals(paramRespSummaryCard.strGroupName))
        {
          paramString.troopname = paramRespSummaryCard.strGroupName;
          localTroopManager.b(paramString);
        }
      }
    }
    Object localObject;
    label164:
    label192:
    do
    {
      do
      {
        for (;;)
        {
          localObject = bhmb.a(paramRespSummaryCard.strGroupNick.getBytes());
          paramString = (String)localObject;
          if (localObject == null) {
            paramString = paramRespSummaryCard.strGroupNick;
          }
          localTroopManager.a(String.valueOf(paramLong), String.valueOf(paramRespSummaryCard.lUIN), paramString, -100, paramRespSummaryCard.strNick, null, -100, -100, -100, -100L, -100L);
          return;
          if (paramRespSummaryCard.strGroupName != null)
          {
            paramString.troopname = paramRespSummaryCard.strGroupName;
            localTroopManager.b(paramString);
          }
        }
      } while (paramInt != 4);
      localObject = (antp)this.app.getManager(QQManagerFactory.DISCUSSION_MANAGER);
      paramString = ((antp)localObject).a(String.valueOf(paramLong), paramString);
    } while (paramString == null);
    paramString.memberName = paramRespSummaryCard.strNick;
    if ((paramRespSummaryCard.strAutoRemark != null) && (paramRespSummaryCard.strAutoRemark.length() > 0) && (!paramRespSummaryCard.strAutoRemark.equals(paramString.inteRemark)))
    {
      paramString.inteRemark = paramRespSummaryCard.strAutoRemark;
      if (!paramRespSummaryCard.strAutoRemark.equals(paramRespSummaryCard.strNick)) {
        break label317;
      }
    }
    label317:
    for (paramString.inteRemarkSource = 129L;; paramString.inteRemarkSource = 128L)
    {
      ((antp)localObject).a(paramString);
      return;
    }
  }
  
  private void a(SummaryCard.RespHead paramRespHead, RespSummaryCard paramRespSummaryCard, SparseArray<bcra> paramSparseArray, String paramString, Card paramCard)
  {
    if (paramRespHead != null) {
      paramCard.vCookies = paramRespHead.vCookies;
    }
    if (paramRespSummaryCard.i0x6d4Success != 0) {
      QLog.e("CardHandler", 1, String.format("handleGetSummaryCard 0x6d4 fail, resultCode=%d", new Object[] { Integer.valueOf(paramRespSummaryCard.i0x6d4Success) }));
    }
    label174:
    EntityManager localEntityManager;
    if (!a(paramCard, paramSparseArray))
    {
      if (paramRespSummaryCard.i0x6d4Success == 0)
      {
        paramCard.lVoteCount = paramRespSummaryCard.iVoteCount;
        paramCard.iVoteIncrement = paramRespSummaryCard.iLastestVoteCount;
      }
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, String.format("handleGetSummaryCard lVoteCount=%d iVoteIncrement=%d", new Object[] { Long.valueOf(paramCard.lVoteCount), Integer.valueOf(paramCard.iVoteIncrement) }));
      }
      if (paramRespSummaryCard.i0x6d4Success == 0)
      {
        paramCard.strVoteLimitedNotice = paramRespSummaryCard.strVoteLimitedNotice;
        paramCard.bHaveVotedCnt = paramRespSummaryCard.bHaveVotedCnt;
        paramCard.bAvailVoteCnt = paramRespSummaryCard.bAvailVoteCnt;
        if (paramCard.bHaveVotedCnt <= 0) {
          break label336;
        }
        paramCard.bVoted = 1;
        if (paramString.equals(this.app.getCurrentAccountUin()))
        {
          paramCard.setLastPraiseInfoList(paramRespSummaryCard.vPraiseList);
          axqc.a(this.app.getAccount(), paramCard.lVoteCount, paramCard.iVoteIncrement);
          localEntityManager = this.app.getEntityManagerFactory().createEntityManager();
          paramSparseArray = (NearbyPeopleCard)localEntityManager.find(NearbyPeopleCard.class, "uin=?", new String[] { paramString });
          paramRespHead = paramSparseArray;
          if (paramSparseArray == null) {
            paramRespHead = new NearbyPeopleCard();
          }
          paramRespHead.likeCount = ((int)paramCard.lVoteCount);
          paramRespHead.likeCountInc = paramCard.iVoteIncrement;
          paramRespHead.praiseList = paramRespSummaryCard.vPraiseList;
          if (paramRespHead.getStatus() != 1000) {
            break label345;
          }
          localEntityManager.persistOrReplace(paramRespHead);
        }
      }
    }
    for (;;)
    {
      localEntityManager.close();
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("CardHandler", 2, "handleGetSummaryCard hot value cover vote.");
      break;
      label336:
      paramCard.bVoted = 0;
      break label174;
      label345:
      if ((paramRespHead.getStatus() == 1001) || (paramRespHead.getStatus() == 1002)) {
        localEntityManager.update(paramRespHead);
      }
    }
  }
  
  private void a(RespSummaryCard paramRespSummaryCard, SparseArray<bcra> paramSparseArray, Card paramCard)
  {
    if ((!b(paramCard, paramSparseArray)) && (paramRespSummaryCard.stPrivInfo != null))
    {
      paramRespSummaryCard = paramRespSummaryCard.stPrivInfo;
      paramCard.privilegePromptStr = paramRespSummaryCard.strMsg;
      paramCard.privilegeJumpUrl = paramRespSummaryCard.strJumpUrl;
      paramCard.savePrivilegeOpenedInfo(paramRespSummaryCard.vOpenPriv);
      paramCard.savePrivilegeClosedInfo(paramRespSummaryCard.vClosePriv);
    }
  }
  
  private void a(RespSummaryCard paramRespSummaryCard, Card paramCard)
  {
    if (paramRespSummaryCard.stDateCard != null)
    {
      paramCard.constellation = paramRespSummaryCard.stDateCard.bConstellation;
      paramCard.strCompany = paramRespSummaryCard.stDateCard.strCompany;
      paramCard.iProfession = ((int)paramRespSummaryCard.stDateCard.uProfession);
      paramCard.strSchool = paramRespSummaryCard.stDateCard.strSchool;
      String str1 = anrz.a(paramRespSummaryCard.stDateCard.uHomeCountry);
      String str2 = anrz.a(paramRespSummaryCard.stDateCard.uHomeProvince);
      String str3 = anrz.a(paramRespSummaryCard.stDateCard.uHomeCity);
      paramRespSummaryCard = anrz.a(paramRespSummaryCard.stDateCard.uHomeZone);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str1).append("-");
      localStringBuilder.append(str2).append("-");
      localStringBuilder.append(str3).append("-");
      localStringBuilder.append(paramRespSummaryCard);
      paramCard.strHometownCodes = localStringBuilder.toString();
      if (!TextUtils.isEmpty(paramCard.strHometownCodes)) {
        ((anrz)this.app.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER)).a(paramCard);
      }
    }
  }
  
  private void a(RespSummaryCard paramRespSummaryCard, Card paramCard, long paramLong)
  {
    if ((0x10 & paramLong) != 0L)
    {
      paramCard.lLoginDays = paramRespSummaryCard.uLoginDays;
      paramCard.strLoginDaysDesc = paramRespSummaryCard.strLoginDesc;
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.SummaryCard", 2, "card.lLoginDays = " + paramCard.lLoginDays + "card.strLoginDaysDesc = " + paramCard.strLoginDaysDesc);
      }
    }
  }
  
  private void a(RespSummaryCard paramRespSummaryCard, Card paramCard, Friends paramFriends)
  {
    if (paramRespSummaryCard.stVipInfo != null)
    {
      paramFriends.qqVipInfo = aolb.a(paramRespSummaryCard.stVipInfo, EVIPSPEC.E_SP_QQVIP.value(), paramFriends.qqVipInfo);
      paramFriends.superQqInfo = aolb.a(paramRespSummaryCard.stVipInfo, EVIPSPEC.E_SP_SUPERQQ.value(), paramFriends.superQqInfo);
      paramFriends.superVipInfo = aolb.a(paramRespSummaryCard.stVipInfo, EVIPSPEC.E_SP_SUPERVIP.value(), paramFriends.superVipInfo);
      paramFriends.bigClubInfo = aolb.a(paramRespSummaryCard.stVipInfo, EVIPSPEC.E_SP_BIGCLUB.value(), paramFriends.bigClubInfo);
      Object localObject;
      if ((paramCard != null) && (paramFriends.bigClubInfo == 0))
      {
        localObject = paramCard.getPrivilegeOpenInfo();
        if (localObject != null)
        {
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            PrivilegeInfo localPrivilegeInfo = (PrivilegeInfo)((Iterator)localObject).next();
            if (localPrivilegeInfo.iType == 113)
            {
              int i = localPrivilegeInfo.iIsBig;
              int j = localPrivilegeInfo.iLevel;
              if ((i > 0) && (j > 0)) {
                paramFriends.bigClubInfo = ((short)j | (i << 8 | 0x1) << 16);
              }
            }
          }
        }
      }
      paramFriends.hollywoodVipInfo = aolb.a(paramRespSummaryCard.stVipInfo, EVIPSPEC.E_SP_QQVIDEO_HOLLYWOOD.value(), paramFriends.hollywoodVipInfo);
      if ((paramRespSummaryCard.stVipInfo != null) && (paramRespSummaryCard.stVipInfo.mOpenInfo != null))
      {
        localObject = (VipOpenInfo)paramRespSummaryCard.stVipInfo.mOpenInfo.get(Integer.valueOf(EVIPSPEC.E_SP_SUPERVIP.value()));
        if (localObject != null)
        {
          paramFriends.superVipTemplateId = ((int)((VipOpenInfo)localObject).lNameplateId);
          paramFriends.bigClubTemplateId = ((int)((VipOpenInfo)localObject).lNameplateId);
        }
        paramRespSummaryCard = (VipOpenInfo)paramRespSummaryCard.stVipInfo.mOpenInfo.get(Integer.valueOf(EVIPSPEC.E_SP_BIGCLUB.value()));
        if (paramRespSummaryCard != null)
        {
          paramFriends.superVipTemplateId = ((int)paramRespSummaryCard.lNameplateId);
          paramFriends.bigClubTemplateId = ((int)paramRespSummaryCard.lNameplateId);
        }
        if (paramCard != null)
        {
          paramFriends.nameplateVipType = paramCard.nameplateVipType;
          paramFriends.grayNameplateFlag = paramCard.grayNameplateFlag;
        }
      }
    }
  }
  
  private void a(RespSummaryCard paramRespSummaryCard, String paramString)
  {
    Object localObject = (amme)this.app.getManager(QQManagerFactory.APOLLO_MANAGER);
    if (paramRespSummaryCard.stApollo != null)
    {
      localApolloBaseInfo = ((amme)localObject).b(paramString);
      localApolloBaseInfo.apolloVipFlag = ((int)paramRespSummaryCard.stApollo.uVipFlag);
      localApolloBaseInfo.apolloVipLevel = ((int)paramRespSummaryCard.stApollo.uVipLevel);
      localApolloBaseInfo.apolloStatus = ((int)paramRespSummaryCard.stApollo.uUserFlag);
      localApolloBaseInfo.apolloServerTS = paramRespSummaryCard.stApollo.uTimestamp;
      ((amme)localObject).a(localApolloBaseInfo);
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "summaryCard upadte apolloBaseInfo uin: " + paramString + ", apollo vipFlag: " + localApolloBaseInfo.apolloVipFlag + ", apollo vipLevel: " + localApolloBaseInfo.apolloVipLevel + ", apollo status: " + localApolloBaseInfo.apolloStatus + ", apollo svr TS: " + localApolloBaseInfo.apolloServerTS + ", apollo local TS: " + localApolloBaseInfo.apolloLocalTS);
      }
      if (localApolloBaseInfo.apolloServerTS != localApolloBaseInfo.apolloLocalTS)
      {
        paramRespSummaryCard = (VasExtensionHandler)this.app.getBusinessHandler(BusinessHandlerFactory.VAS_EXTENSION_HANDLER);
        if (paramRespSummaryCard == null) {}
      }
    }
    while (!QLog.isColorLevel()) {
      try
      {
        ApolloBaseInfo localApolloBaseInfo;
        localObject = new ArrayList(1);
        ((ArrayList)localObject).add(Long.valueOf(Long.parseLong(paramString)));
        paramRespSummaryCard.a((ArrayList)localObject, "summaryCard");
        if (QLog.isColorLevel()) {
          QLog.d("CardHandler", 2, "summaryCard update user apollo dress uin: " + paramString.substring(0, 4));
        }
        return;
      }
      catch (Exception paramRespSummaryCard)
      {
        while (!QLog.isColorLevel()) {}
        QLog.d("CardHandler", 2, "summaryCard update user apollo dress uin: " + paramRespSummaryCard.getMessage());
        return;
      }
    }
    QLog.e("CardHandler", 2, "CardHandle apollo field is null");
  }
  
  private void a(RespSummaryCard paramRespSummaryCard, String paramString, long paramLong, ExtensionInfo paramExtensionInfo)
  {
    if (((0x4 & paramLong) != 0L) && (paramExtensionInfo.richTime != paramRespSummaryCard.uSignModifyTime))
    {
      paramExtensionInfo.setRichBuffer(paramRespSummaryCard.vRichSign, paramRespSummaryCard.uSignModifyTime);
      ((FriendListHandler)this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getRichStatus(new String[] { paramString });
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "insertSignMsgIfNeeded from cardHandler uin = " + paramString + " result = " + paramExtensionInfo.isAdded2C2C);
      }
    }
  }
  
  private void a(RespSummaryCard paramRespSummaryCard, String paramString, Card paramCard, long paramLong)
  {
    HashMap localHashMap;
    if ((0x20 & paramLong) != 0L)
    {
      localHashMap = new HashMap();
      if (paramRespSummaryCard.vRespTemplateInfo == null) {
        break label247;
      }
      paramRespSummaryCard = (SSummaryCardRsp)decodePacket(paramRespSummaryCard.vRespTemplateInfo, "rsp", new SSummaryCardRsp());
      paramCard.updateCardTemplate(this.app, paramString, paramRespSummaryCard);
      if ((paramRespSummaryCard != null) && (!TextUtils.isEmpty(paramRespSummaryCard.urlprefix)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("CardHandler", 2, "handleGetSummaryCard: defaultCardUrlPrefix=" + paramRespSummaryCard.urlprefix + " defId=" + paramRespSummaryCard.profileid);
        }
        azrc.jdField_a_of_type_JavaLangString = paramRespSummaryCard.urlprefix;
      }
      if ((paramRespSummaryCard != null) && (paramRespSummaryCard.stRecom != null))
      {
        paramLong = paramRespSummaryCard.stRecom.iRecomCard;
        paramString = azrc.jdField_a_of_type_JavaLangString + paramRespSummaryCard.stRecom.strRecomUrl;
        paramRespSummaryCard = paramRespSummaryCard.stRecom.strDesc;
        if ((!TextUtils.isEmpty(paramString)) && (!TextUtils.isEmpty(paramRespSummaryCard))) {
          BaseApplicationImpl.getApplication().getSharedPreferences("profile_sp", 0).edit().putLong("recommend_id", paramLong).putString("recommend_url", paramString).putString("recommend_desc", paramRespSummaryCard).commit();
        }
      }
    }
    return;
    label247:
    localHashMap.put("param_FailCode", "-100");
    StatisticCollector.getInstance(this.app.getApp()).collectPerformance(paramString, "profileCardGet", false, 0L, 0L, null, "", false);
  }
  
  private void a(anrn paramanrn, Bundle paramBundle)
  {
    int i;
    if (paramBundle.containsKey("nick"))
    {
      paramanrn.jdField_a_of_type_Long |= 1L;
      paramanrn.jdField_a_of_type_Int += 1;
      i = paramBundle.getString("nick").getBytes().length;
      paramanrn.jdField_b_of_type_Int += i + 4;
      paramanrn.jdField_a_of_type_JavaNioByteBuffer.putShort((short)20002);
      paramanrn.jdField_a_of_type_JavaNioByteBuffer.putShort((short)paramBundle.getString("nick").getBytes().length);
      paramanrn.jdField_a_of_type_JavaNioByteBuffer.put(paramBundle.getString("nick").getBytes());
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "set nick | length = " + i + " | nick = " + paramBundle.getString("nick"));
      }
    }
    if (paramBundle.containsKey("sex"))
    {
      paramanrn.jdField_a_of_type_Long |= 0x2;
      paramanrn.jdField_a_of_type_Int += 1;
      paramanrn.jdField_b_of_type_Int += 5;
      paramanrn.jdField_a_of_type_JavaNioByteBuffer.putShort((short)20009);
      paramanrn.jdField_a_of_type_JavaNioByteBuffer.putShort((short)1);
      paramanrn.jdField_a_of_type_JavaNioByteBuffer.put((byte)(paramBundle.getByte("sex") + 1));
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "set sex | sex = " + paramBundle.getByte("sex"));
      }
    }
    if (paramBundle.containsKey("birthday"))
    {
      paramanrn.jdField_a_of_type_Long |= 0x4;
      paramanrn.jdField_a_of_type_Int += 1;
      paramanrn.jdField_b_of_type_Int += 8;
      paramanrn.jdField_a_of_type_JavaNioByteBuffer.putShort((short)26003);
      paramanrn.jdField_a_of_type_JavaNioByteBuffer.putShort((short)4);
      paramanrn.jdField_a_of_type_JavaNioByteBuffer.putInt(paramBundle.getInt("birthday"));
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "set birthday | birthday = " + paramBundle.getInt("birthday") + " | age = " + paramBundle.getInt("age"));
      }
    }
    if (paramBundle.containsKey("profession"))
    {
      paramanrn.jdField_a_of_type_Long |= 0x20;
      i = paramBundle.getInt("profession");
      if (bgzv.a(i))
      {
        paramanrn.jdField_a_of_type_Int += 1;
        paramanrn.jdField_b_of_type_Int += 8;
        paramanrn.jdField_a_of_type_JavaNioByteBuffer.putShort((short)27037);
        paramanrn.jdField_a_of_type_JavaNioByteBuffer.putShort((short)4);
        paramanrn.jdField_a_of_type_JavaNioByteBuffer.putInt(i);
      }
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "set profession | profession = " + paramBundle.getInt("profession"));
      }
    }
  }
  
  private void a(anvk paramanvk, RespSummaryCard paramRespSummaryCard, String paramString, Card paramCard)
  {
    oidb_0x5eb.UdcUinData localUdcUinData = new oidb_0x5eb.UdcUinData();
    if (paramRespSummaryCard.vResp0x5ebInfo != null) {}
    try
    {
      localUdcUinData.mergeFrom(paramRespSummaryCard.vResp0x5ebInfo);
      a(paramanvk, paramString, paramCard, localUdcUinData);
      a(paramString, paramCard, localUdcUinData);
      a(localUdcUinData, paramCard, this.app);
      a(this.app, paramCard, localUdcUinData);
      return;
    }
    catch (Exception paramanvk)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.profilecard.SummaryCard", 2, paramanvk.toString());
    }
  }
  
  private void a(anvk paramanvk, RespSummaryCard paramRespSummaryCard, String paramString, Card paramCard, long paramLong)
  {
    Friends localFriends = paramanvk.d(paramString);
    localFriends.name = paramCard.strNick;
    localFriends.remark = paramCard.strReMark;
    byte b1;
    if ((1L & paramLong) != 0L)
    {
      paramString = paramCard.strShowName;
      localFriends.alias = paramString;
      if (paramCard.shGender != 0) {
        break label117;
      }
      b1 = 1;
    }
    for (;;)
    {
      localFriends.gender = b1;
      localFriends.age = paramCard.age;
      a(paramRespSummaryCard, paramCard, localFriends);
      a(paramCard, paramLong, localFriends);
      paramanvk.a(localFriends);
      a(localFriends);
      return;
      paramString = localFriends.alias;
      break;
      label117:
      if (paramCard.shGender == 1) {
        b1 = 2;
      } else {
        b1 = 0;
      }
    }
  }
  
  private void a(anvk paramanvk, String paramString, Card paramCard, oidb_0x5eb.UdcUinData paramUdcUinData)
  {
    boolean bool2 = true;
    paramanvk = paramanvk.d(paramString);
    int i;
    if ((paramString.equals(this.app.getCurrentAccountUin())) && (paramUdcUinData.int32_history_num_flag.has()))
    {
      i = paramUdcUinData.int32_history_num_flag.get();
      bhhr.F(this.mApp.getApplication(), getCurrentAccountUin(), i);
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.SummaryCard", 2, "history_num_flag= " + i);
      }
    }
    long l;
    if (paramUdcUinData.uint64_game_appid.has())
    {
      l = paramUdcUinData.uint64_game_appid.get();
      paramCard.namePlateOfKingGameId = l;
      paramanvk.namePlateOfKingGameId = l;
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.SummaryCard", 2, "namePlateOfKingGameId= " + l);
      }
    }
    if (paramUdcUinData.uint64_game_last_login_time.has())
    {
      l = paramUdcUinData.uint64_game_last_login_time.get();
      paramCard.namePlateOfKingLoginTime = l;
      paramanvk.namePlateOfKingLoginTime = l;
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.SummaryCard", 2, "namePlateOfKingLoginTime= " + l);
      }
    }
    if (paramUdcUinData.uint32_plate_of_king_dan.has())
    {
      i = paramUdcUinData.uint32_plate_of_king_dan.get();
      paramCard.namePlateOfKingDan = i;
      paramanvk.namePlateOfKingDan = i;
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.SummaryCard", 2, "namePlateOfKingDan= " + i);
      }
    }
    if (paramUdcUinData.uint32_plate_of_king_dan_display_switch.has())
    {
      i = paramUdcUinData.uint32_plate_of_king_dan_display_switch.get();
      if (i != 1) {
        break label594;
      }
      bool1 = true;
      paramCard.namePlateOfKingDanDisplatSwitch = bool1;
      if (i != 1) {
        break label600;
      }
    }
    label594:
    label600:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramanvk.namePlateOfKingDanDisplatSwitch = bool1;
      if ((!TextUtils.isEmpty(paramString)) && (this.app.getCurrentUin().equals(paramString))) {
        this.app.getApp().getSharedPreferences("sp_plate_of_king", 0).edit().putBoolean("plate_of_king_display_switch_" + this.app.getCurrentUin(), paramanvk.namePlateOfKingDanDisplatSwitch).apply();
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.SummaryCard", 2, "namePlateOfKingDanDisplatSwitch= " + i);
      }
      if (paramUdcUinData.uint32_suspend_effect_id.has())
      {
        i = paramUdcUinData.uint32_suspend_effect_id.get();
        if (i >= 0) {
          ((aocy)this.app.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(paramString, i);
        }
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.SummaryCard", 2, "uin " + paramString + " colorScreenid= " + i);
        }
      }
      if (paramUdcUinData.uint32_vas_face_id.has())
      {
        i = paramUdcUinData.uint32_vas_face_id.get();
        ((bhou)this.app.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).a.b(paramString, i);
      }
      return;
      bool1 = false;
      break;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, Card paramCard, oidb_0x5eb.UdcUinData paramUdcUinData)
  {
    if (paramUdcUinData.uint32_profile_anonymous_answer_switch.has()) {
      bagq.a.a(42425, paramUdcUinData.uint32_profile_anonymous_answer_switch.get(), paramCard, paramQQAppInterface);
    }
    if (paramUdcUinData.uint32_profile_show_idol_switch.has()) {
      bagq.a.a(42488, paramUdcUinData.uint32_profile_show_idol_switch.get(), paramCard, paramQQAppInterface);
    }
    if (paramUdcUinData.uint32_profile_wz_game_card_switch.has()) {
      bagq.a.a(42505, paramUdcUinData.uint32_profile_wz_game_card_switch.get(), paramCard, paramQQAppInterface);
    }
  }
  
  private void a(Card paramCard)
  {
    if ((paramCard.lUserFlag & 0x8) != 0L)
    {
      paramCard.allowClick = true;
      return;
    }
    paramCard.allowClick = false;
  }
  
  private void a(Card paramCard, long paramLong, Friends paramFriends)
  {
    if ((0x8 & paramLong) != 0L) {
      if ((paramCard.lUserFlag & 1L) == 0L) {
        break label85;
      }
    }
    label85:
    for (paramFriends.cSpecialFlag = ((byte)(paramFriends.cSpecialFlag | 0x1));; paramFriends.cSpecialFlag = ((byte)(paramFriends.cSpecialFlag & 0xFFFFFFFE)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("CardHandler", 2, "cardhandler uin=" + paramFriends.uin + ", cSpecialFlag=" + paramFriends.cSpecialFlag);
      }
      return;
    }
  }
  
  private void a(Card paramCard, SparseArray<bcra> paramSparseArray)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.SummaryCard", 2, "handleGetLifeAchievementInfo vvRespList=" + paramSparseArray);
    }
    Object localObject = (bcra)paramSparseArray.get(18);
    if ((localObject != null) && (((bcra)localObject).a != null))
    {
      paramSparseArray = new oidb_0xe5b.RspBody();
      try
      {
        paramSparseArray.mergeFrom(((bcra)localObject).a);
        paramCard.lifeAchievementTotalCount = paramSparseArray.uint32_achievement_totalcount.get();
        paramCard.lifeAchievementOpenId = paramSparseArray.str_achievement_openid.get();
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.SummaryCard", 2, String.format(Locale.getDefault(), "handleGetLifeAchievementInfo totalCount=%s openId=%s", new Object[] { Integer.valueOf(paramCard.lifeAchievementTotalCount), paramCard.lifeAchievementOpenId }));
        }
        paramCard.lifeAchivementList = new ArrayList();
        if (paramSparseArray.rpt_life_ach_item != null) {
          while (i < paramSparseArray.rpt_life_ach_item.size())
          {
            localObject = new azsx();
            ((azsx)localObject).jdField_b_of_type_Int = ((oidb_0xe5b.LifeAchievementItem)paramSparseArray.rpt_life_ach_item.get(i)).uint32_achievement_id.get();
            ((azsx)localObject).jdField_a_of_type_JavaLangString = ((oidb_0xe5b.LifeAchievementItem)paramSparseArray.rpt_life_ach_item.get(i)).str_achievement_title.get();
            ((azsx)localObject).jdField_b_of_type_JavaLangString = ((oidb_0xe5b.LifeAchievementItem)paramSparseArray.rpt_life_ach_item.get(i)).str_achievement_icon.get();
            ((azsx)localObject).jdField_a_of_type_Boolean = ((oidb_0xe5b.LifeAchievementItem)paramSparseArray.rpt_life_ach_item.get(i)).bool_has_praised.get();
            ((azsx)localObject).jdField_c_of_type_Int = ((oidb_0xe5b.LifeAchievementItem)paramSparseArray.rpt_life_ach_item.get(i)).uint32_praise_num.get();
            if (QLog.isColorLevel()) {
              QLog.i("Q.profilecard.SummaryCard", 2, String.format(Locale.getDefault(), "handleGetLifeAchievementInfo id=%s title=%s iconUrl=%s hasPraised=%s praiseNum=%s", new Object[] { Integer.valueOf(((azsx)localObject).jdField_b_of_type_Int), ((azsx)localObject).jdField_a_of_type_JavaLangString, ((azsx)localObject).jdField_b_of_type_JavaLangString, Boolean.valueOf(((azsx)localObject).jdField_a_of_type_Boolean), Integer.valueOf(((azsx)localObject).jdField_c_of_type_Int) }));
            }
            paramCard.lifeAchivementList.add(localObject);
            i += 1;
          }
        }
        return;
      }
      catch (Exception paramCard)
      {
        if (QLog.isColorLevel()) {
          QLog.d("CardHandler", 2, "handleGetLifeAchievementInfo onResponse fail." + paramCard);
        }
      }
    }
  }
  
  private void a(Card paramCard, VaProfileGate.VaProfileGateRsp paramVaProfileGateRsp)
  {
    if (paramVaProfileGateRsp.qid_info.has())
    {
      paramVaProfileGateRsp = (VaProfileGate.QidInfoItem)paramVaProfileGateRsp.qid_info.get();
      if (paramVaProfileGateRsp.qid.has()) {
        paramCard.qid = paramVaProfileGateRsp.qid.get();
      }
      if (paramVaProfileGateRsp.color.has()) {
        paramCard.qidColor = paramVaProfileGateRsp.color.get();
      }
      if (paramVaProfileGateRsp.logo_url.has()) {
        paramCard.qidLogoUrl = paramVaProfileGateRsp.logo_url.get();
      }
      if (paramVaProfileGateRsp.url.has()) {
        paramCard.qidBgUrl = paramVaProfileGateRsp.url.get();
      }
    }
  }
  
  private void a(Card paramCard, VaProfileGate.VaProfileGateRsp paramVaProfileGateRsp, VaProfileGate.PrivilegeBaseInfoRsp paramPrivilegeBaseInfoRsp)
  {
    if ((paramVaProfileGateRsp.stPrivilegeRsp.has()) && (paramPrivilegeBaseInfoRsp.uIsGrayUsr.get() != 0))
    {
      paramCard.privilegePromptStr = paramPrivilegeBaseInfoRsp.strMsg.get().toStringUtf8();
      paramCard.privilegeJumpUrl = paramPrivilegeBaseInfoRsp.strJumpUrl.get().toStringUtf8();
      paramVaProfileGateRsp = new ArrayList();
      int i = 0;
      while (i < paramPrivilegeBaseInfoRsp.vOpenPriv.size())
      {
        localObject = (VaProfileGate.PrivilegeInfo)paramPrivilegeBaseInfoRsp.vOpenPriv.get(i);
        paramVaProfileGateRsp.add(new PrivilegeInfo(((VaProfileGate.PrivilegeInfo)localObject).iType.get(), ((VaProfileGate.PrivilegeInfo)localObject).iSort.get(), ((VaProfileGate.PrivilegeInfo)localObject).iFeeType.get(), ((VaProfileGate.PrivilegeInfo)localObject).iLevel.get(), ((VaProfileGate.PrivilegeInfo)localObject).iFlag.get(), ((VaProfileGate.PrivilegeInfo)localObject).strIconUrl.get().toStringUtf8(), ((VaProfileGate.PrivilegeInfo)localObject).strDeluxeIconUrl.get().toStringUtf8(), ((VaProfileGate.PrivilegeInfo)localObject).strJumpUrl.get().toStringUtf8(), ((VaProfileGate.PrivilegeInfo)localObject).iIsBig.get(), ((VaProfileGate.PrivilegeInfo)localObject).iIsRemind.get(), ((VaProfileGate.PrivilegeInfo)localObject).iRemindTime.get(), ((VaProfileGate.PrivilegeInfo)localObject).strTipsIconUrl.get(), ((VaProfileGate.PrivilegeInfo)localObject).iTipsTimes.get()));
        i += 1;
      }
      Object localObject = new ArrayList();
      i = 0;
      while (i < paramPrivilegeBaseInfoRsp.vClosePriv.size())
      {
        VaProfileGate.PrivilegeInfo localPrivilegeInfo = (VaProfileGate.PrivilegeInfo)paramPrivilegeBaseInfoRsp.vClosePriv.get(i);
        ((ArrayList)localObject).add(new PrivilegeInfo(localPrivilegeInfo.iType.get(), localPrivilegeInfo.iSort.get(), localPrivilegeInfo.iFeeType.get(), localPrivilegeInfo.iLevel.get(), localPrivilegeInfo.iFlag.get(), localPrivilegeInfo.strIconUrl.get().toStringUtf8(), localPrivilegeInfo.strDeluxeIconUrl.get().toStringUtf8(), localPrivilegeInfo.strJumpUrl.get().toStringUtf8(), localPrivilegeInfo.iIsBig.get(), localPrivilegeInfo.iIsRemind.get(), localPrivilegeInfo.iRemindTime.get(), localPrivilegeInfo.strTipsIconUrl.get(), localPrivilegeInfo.iTipsTimes.get()));
        i += 1;
      }
      if (QLog.isColorLevel()) {
        QLog.d("DIYProfileTemplate.CardHandler", 1, "save privilege open list=" + paramVaProfileGateRsp.size() + " close list=" + ((ArrayList)localObject).size());
      }
      paramCard.savePrivilegeOpenedInfo(paramVaProfileGateRsp);
      paramCard.savePrivilegeClosedInfo((List)localObject);
    }
  }
  
  private void a(Friends paramFriends)
  {
    awyz localawyz = (awyz)this.app.getManager(QQManagerFactory.CONTACT_MANAGER);
    if ((localawyz != null) && (localawyz.a(paramFriends.uin) != null)) {
      localawyz.f();
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
    MedalWallMng localMedalWallMng = (MedalWallMng)this.app.getManager(QQManagerFactory.MEDAL_WALL_MNG);
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
              for (paramFromServiceMsg = ((anvk)this.mApp.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.mApp.getCurrentAccountUin(), true);; paramFromServiceMsg = null)
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
  
  private void a(ToServiceMsg paramToServiceMsg, QQAppInterface paramQQAppInterface, String paramString)
  {
    if ((paramToServiceMsg != null) && (paramQQAppInterface != null))
    {
      boolean bool = TextUtils.equals(paramQQAppInterface.getCurrentUin(), paramString);
      paramQQAppInterface = new ArrayList();
      if (bool)
      {
        paramQQAppInterface.add(Integer.valueOf(42104));
        paramQQAppInterface.add(Integer.valueOf(41611));
        paramQQAppInterface.add(Integer.valueOf(41610));
        paramQQAppInterface.add(Integer.valueOf(41607));
        paramQQAppInterface.add(Integer.valueOf(41609));
        paramQQAppInterface.add(Integer.valueOf(41618));
        paramQQAppInterface.add(Integer.valueOf(41619));
        paramQQAppInterface.add(Integer.valueOf(41614));
        paramQQAppInterface.add(Integer.valueOf(41613));
        paramQQAppInterface.add(Integer.valueOf(41622));
        paramQQAppInterface.add(Integer.valueOf(41623));
        paramQQAppInterface.add(Integer.valueOf(40272));
      }
      paramQQAppInterface.add(Integer.valueOf(27225));
      paramQQAppInterface.add(Integer.valueOf(27224));
      paramQQAppInterface.add(Integer.valueOf(42122));
      paramQQAppInterface.add(Integer.valueOf(42121));
      paramQQAppInterface.add(Integer.valueOf(27236));
      paramQQAppInterface.add(Integer.valueOf(27238));
      paramQQAppInterface.add(Integer.valueOf(42167));
      paramQQAppInterface.add(Integer.valueOf(42172));
      paramQQAppInterface.add(Integer.valueOf(40324));
      paramQQAppInterface.add(Integer.valueOf(42284));
      paramQQAppInterface.add(Integer.valueOf(42326));
      paramQQAppInterface.add(Integer.valueOf(42325));
      paramQQAppInterface.add(Integer.valueOf(42356));
      paramQQAppInterface.add(Integer.valueOf(42363));
      paramQQAppInterface.add(Integer.valueOf(42361));
      paramQQAppInterface.add(Integer.valueOf(42367));
      paramQQAppInterface.add(Integer.valueOf(42377));
      paramQQAppInterface.add(Integer.valueOf(42425));
      paramQQAppInterface.add(Integer.valueOf(42505));
      paramQQAppInterface.add(Integer.valueOf(42488));
      paramToServiceMsg.extraData.putIntegerArrayList("req0x5ebFieldIdList", paramQQAppInterface);
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, Card paramCard)
  {
    if (paramToServiceMsg.extraData.getInt("comeFromType") == 37) {
      paramCard.encId = paramToServiceMsg.extraData.getString("strSearchName");
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, Card paramCard, anvk paramanvk)
  {
    StringBuilder localStringBuilder;
    if (paramToServiceMsg.extraData.containsKey("nick"))
    {
      paramCard.strNick = paramToServiceMsg.extraData.getString("nick");
      paramanvk.a(this.app.getCurrentAccountUin(), paramCard.strNick);
      if ((this.app.getCurrentAccountUin() != null) && (this.app.getCurrentAccountUin().equals(paramToServiceMsg.getUin())))
      {
        paramanvk = Constants.PropertiesKey.nickName.toString() + paramToServiceMsg.getUin();
        this.app.getApplication().setProperty(paramanvk, paramCard.strNick);
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder("handleSetDetailInfo set properties");
          localStringBuilder.append("uin = ").append(paramanvk);
          localStringBuilder.append("nickname = ").append(paramCard.strNick);
          localStringBuilder.append("\n");
          QLog.d("CardHandler", 2, localStringBuilder.toString());
        }
      }
      this.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER).notifyUI(3, true, this.app.getCurrentAccountUin());
    }
    if (paramToServiceMsg.extraData.containsKey("sex"))
    {
      paramCard.shGender = ((short)paramToServiceMsg.extraData.getByte("sex"));
      paramanvk = (axny)this.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
      if (paramanvk != null) {
        paramanvk.b(paramCard.shGender);
      }
    }
    if (paramToServiceMsg.extraData.containsKey("birthday"))
    {
      paramCard.lBirthday = paramToServiceMsg.extraData.getInt("birthday");
      paramCard.age = ((byte)paramToServiceMsg.extraData.getInt("age"));
      paramCard.constellation = paramToServiceMsg.extraData.getInt("key_constellation");
      paramanvk = (axny)this.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
      if (paramanvk != null) {
        paramanvk.a(paramCard.age);
      }
    }
    if (paramToServiceMsg.extraData.containsKey("profession")) {
      paramCard.iProfession = paramToServiceMsg.extraData.getInt("profession");
    }
    if (paramToServiceMsg.extraData.containsKey("company")) {
      paramCard.strCompany = paramToServiceMsg.extraData.getString("company");
    }
    if (paramToServiceMsg.extraData.containsKey("college")) {
      paramCard.strSchool = paramToServiceMsg.extraData.getString("college");
    }
    try
    {
      axqc.a(this.app.getAccount(), "self_school_name", paramCard.strSchool);
      if (paramToServiceMsg.extraData.containsKey("location"))
      {
        paramanvk = paramToServiceMsg.extraData.getStringArray("location");
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramanvk[0]).append("-").append(paramanvk[1]).append("-").append(paramanvk[2]).append("-").append(paramanvk[3]);
        paramCard.strLocationCodes = localStringBuilder.toString();
        paramCard.strLocationDesc = paramToServiceMsg.extraData.getString("locationo_desc");
        paramanvk = paramToServiceMsg.extraData.getStringArray("location_name");
        if ((paramanvk != null) && (paramanvk.length == 4)) {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder("nameArray: ");
            int i = 0;
            while (i < 4)
            {
              localStringBuilder.append(paramanvk[i]).append(" ");
              i += 1;
            }
          }
        }
      }
    }
    catch (Exception paramanvk)
    {
      for (;;)
      {
        paramanvk.printStackTrace();
      }
      QLog.d("CardHandler", 2, localStringBuilder.toString());
      paramCard.strCountry = paramanvk[0];
      paramCard.strProvince = paramanvk[1];
      paramCard.strCity = paramanvk[2];
      if (paramToServiceMsg.extraData.containsKey("hometown"))
      {
        paramanvk = paramToServiceMsg.extraData.getStringArray("hometown");
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramanvk[0]).append("-").append(paramanvk[1]).append("-").append(paramanvk[2]).append("-").append(paramanvk[3]);
        paramCard.strHometownCodes = localStringBuilder.toString();
        paramCard.strHometownDesc = paramToServiceMsg.extraData.getString("hometown_desc");
      }
      if (paramToServiceMsg.extraData.containsKey("email")) {
        paramCard.strEmail = paramToServiceMsg.extraData.getString("email");
      }
      if (paramToServiceMsg.extraData.containsKey("personalNote")) {
        paramCard.strPersonalNote = paramToServiceMsg.extraData.getString("personalNote");
      }
      if (!paramToServiceMsg.extraData.containsKey("key_extend_friend_switch")) {
        break label841;
      }
    }
    if (paramToServiceMsg.extraData.getShort("key_extend_friend_switch") == 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramCard.isShowCard = bool;
      label841:
      return;
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
    if ("SummaryCard.ReqSummaryCard".equals(str)) {
      d(paramToServiceMsg, paramFromServiceMsg, paramObject, paramBundle);
    }
    do
    {
      return;
      if ("MCardSvc.ReqHYMakeFriendsCard".equals(str))
      {
        o(paramToServiceMsg, paramFromServiceMsg, paramObject, paramBundle);
        return;
      }
      if ("MCardSvc.ReqSetCard".equals(str))
      {
        l(paramToServiceMsg, paramFromServiceMsg, paramObject, paramBundle);
        return;
      }
      if ("SummaryCard.SetLabel".equals(str))
      {
        m(paramToServiceMsg, paramFromServiceMsg, paramObject, paramBundle);
        return;
      }
      if ("SummaryCard.LikeIt".equals(str))
      {
        n(paramToServiceMsg, paramFromServiceMsg, paramObject, paramBundle);
        return;
      }
      if ("MCardSvc.ReqGetCardSwitch".equals(str))
      {
        j(paramToServiceMsg, paramFromServiceMsg, paramObject, paramBundle);
        return;
      }
      if ("MCardSvc.ReqSetCardSwitch".equals(str))
      {
        k(paramToServiceMsg, paramFromServiceMsg, paramObject, paramBundle);
        return;
      }
      if ("VisitorSvc.ReqFavorite".equals(str))
      {
        e(paramToServiceMsg, paramFromServiceMsg, paramObject, paramBundle);
        return;
      }
      if ("VisitorSvc.ReqGetVoterList".equals(str))
      {
        g(paramToServiceMsg, paramFromServiceMsg, paramObject, paramBundle);
        return;
      }
      if ("VisitorSvc.ReqGetFavoriteList".equals(str))
      {
        f(paramToServiceMsg, paramFromServiceMsg, paramObject, paramBundle);
        return;
      }
    } while (!"VisitorSvc.ReqDeleteVisitorRecord".equals(str));
    h(paramToServiceMsg, paramFromServiceMsg, paramObject, paramBundle);
  }
  
  private void a(String paramString, Card paramCard)
  {
    if (!paramString.equals(this.app.getCurrentAccountUin()))
    {
      if ((paramCard.lUserFlag & 0x10) != 0L) {
        paramCard.allowPeopleSee = true;
      }
    }
    else {
      return;
    }
    paramCard.allowPeopleSee = false;
  }
  
  private void a(String paramString, Card paramCard, oidb_0x5eb.UdcUinData paramUdcUinData)
  {
    int i;
    if (paramUdcUinData.uint32_extend_friend_flag.has())
    {
      i = paramUdcUinData.uint32_extend_friend_flag.get();
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.SummaryCard", 2, "uin " + paramString + " extendFriendFlag=" + i);
      }
      paramCard.extendFriendFlag = i;
      bhhr.a(this.app.getCurrentAccountUin(), "extend_friend_config_785").edit().putInt("sp_extend_friend_flag", i).apply();
    }
    if (paramUdcUinData.uint32_extend_friend_card_shown.has())
    {
      i = paramUdcUinData.uint32_extend_friend_card_shown.get();
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.SummaryCard", 2, "uin " + paramString + " extendFriendCardShown=" + i);
      }
      if (i == 0)
      {
        bool = true;
        paramCard.isShowCard = bool;
      }
    }
    else
    {
      if (paramUdcUinData.uint32_stranger_vote_switch.has())
      {
        i = paramUdcUinData.uint32_stranger_vote_switch.get();
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.SummaryCard", 2, "uin " + paramString + " stranger_vote_switch close=" + i);
        }
        if (i != 0) {
          break label812;
        }
        bool = true;
        label250:
        paramCard.strangerVoteOpen = bool;
        if (paramString.equals(this.app.getCurrentAccountUin())) {
          ((axnt)this.app.getManager(QQManagerFactory.NEARBY_GENERAL_MANAGER)).b(paramCard.strangerVoteOpen);
        }
      }
      if (paramUdcUinData.uint32_school_status_flag.has())
      {
        i = paramUdcUinData.uint32_school_status_flag.get();
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.SummaryCard", 2, "uin " + paramString + " uint32_school_status_flag=" + i);
        }
        paramCard.newSchoolStatusFlagForGuide = i;
      }
      if (paramUdcUinData.uint32_flag_is_pretty_group_owner.has())
      {
        if (paramUdcUinData.uint32_flag_is_pretty_group_owner.get() != 1) {
          break label818;
        }
        bool = true;
        label383:
        paramCard.isPrettyGroupOwner = bool;
        QLog.e("vip_pretty.", 1, "uin " + paramString + " is pretty troop owner:" + paramCard.isPrettyGroupOwner);
      }
      if (paramUdcUinData.uint32_flag_hide_pretty_group_owner_identity.has())
      {
        if (paramUdcUinData.uint32_flag_hide_pretty_group_owner_identity.get() != 1) {
          break label824;
        }
        bool = true;
        label453:
        paramCard.isHidePrettyGroutIdentity = bool;
        QLog.e("vip_pretty.", 1, "uin " + paramString + " is pretty hide troop owner identity:" + paramCard.isHidePrettyGroutIdentity);
      }
      if (paramUdcUinData.uint32_profile_sticky_note_switch.has())
      {
        i = paramUdcUinData.uint32_profile_sticky_note_switch.get();
        paramCard.switch_sticky_note = ((short)i);
        if (QLog.isColorLevel()) {
          QLog.d("CardHandler", 2, String.format("handleGetSummaryCard uin=%s sticky_note_switch=%s", new Object[] { paramString, Integer.valueOf(i) }));
        }
      }
      if (paramUdcUinData.uint32_flag_school_verified.has()) {
        if (paramUdcUinData.uint32_flag_school_verified.get() != 1) {
          break label830;
        }
      }
    }
    label812:
    label818:
    label824:
    label830:
    for (boolean bool = true;; bool = false)
    {
      paramCard.schoolVerifiedFlag = bool;
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, String.format("handleGetSummaryCard uin=%s schoolVerifiedFlag=%s", new Object[] { paramString, Boolean.valueOf(paramCard.schoolVerifiedFlag) }));
      }
      if (paramUdcUinData.uint32_profile_qqcircle_switch.has())
      {
        i = paramUdcUinData.uint32_profile_qqcircle_switch.get();
        paramCard.switch_qqcircle = ((short)i);
        if (QLog.isColorLevel()) {
          QLog.d("CardHandler", 2, String.format("handleGetSummaryCard uin=%s qqcircle_switch=%s", new Object[] { paramString, Integer.valueOf(i) }));
        }
      }
      if (paramUdcUinData.uint32_profile_life_achievement_switch.has())
      {
        i = paramUdcUinData.uint32_profile_life_achievement_switch.get();
        paramCard.switch_life_achievement = ((short)i);
        if (QLog.isColorLevel()) {
          QLog.d("CardHandler", 2, String.format("handleGetSummaryCard uin=%s switch_life_achievement=%s", new Object[] { paramString, Integer.valueOf(i) }));
        }
      }
      if (paramUdcUinData.uint32_profile_weishi_switch.has())
      {
        i = paramUdcUinData.uint32_profile_weishi_switch.get();
        paramCard.switchWeishi = ((short)i);
        if (QLog.isColorLevel()) {
          QLog.d("CardHandler", 2, String.format("handleGetSummaryCard uin=%s switchWeishi=%s", new Object[] { paramString, Integer.valueOf(i) }));
        }
      }
      return;
      bool = false;
      break;
      bool = false;
      break label250;
      bool = false;
      break label383;
      bool = false;
      break label453;
    }
  }
  
  public static void a(String paramString, List<Visitor> paramList) {}
  
  private void a(ByteBuffer paramByteBuffer, short paramShort1, short paramShort2, Long paramLong, Card paramCard)
  {
    switch (paramShort1)
    {
    default: 
      return;
    case -23196: 
      paramCard.switch_musicbox = paramByteBuffer.getShort();
      return;
    case -23364: 
      if (paramByteBuffer.getShort() == 0) {}
      for (boolean bool = true;; bool = false)
      {
        paramCard.isShowCard = bool;
        return;
      }
    case -23180: 
      paramCard.switch_sticky_note = paramByteBuffer.getShort();
      return;
    case -23175: 
      paramCard.switch_qqcircle = paramByteBuffer.getShort();
      return;
    case -23169: 
      paramCard.switch_life_achievement = paramByteBuffer.getShort();
      return;
    }
    paramCard.switchWeishi = paramByteBuffer.getShort();
  }
  
  private void a(ByteBuffer paramByteBuffer, short paramShort1, short paramShort2, Long paramLong, Card paramCard, anrp paramanrp)
  {
    long l1;
    switch (paramShort1)
    {
    default: 
      return;
    case -23533: 
      paramShort1 = paramByteBuffer.getShort();
      if (paramShort1 != paramanrp.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo.apolloVipFlag)
      {
        paramanrp.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo.apolloVipFlag = paramShort1;
        paramanrp.jdField_a_of_type_Boolean = true;
      }
      QLog.i("ApolloManager", 1, "handleGetDetalInfo apollo vip flag: " + paramShort1);
      return;
    case -23537: 
      paramShort1 = paramByteBuffer.getShort();
      if (paramShort1 != paramanrp.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo.apolloVipLevel)
      {
        paramanrp.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo.apolloVipLevel = paramShort1;
        paramanrp.jdField_a_of_type_Boolean = true;
      }
      QLog.i("ApolloManager", 1, "handleGetDetalInfo apollo vip level: " + paramShort1);
      return;
    case -22556: 
      paramShort1 = paramByteBuffer.getShort();
      if (paramShort1 != paramanrp.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo.apolloStatus)
      {
        paramanrp.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo.apolloStatus = paramShort1;
        paramanrp.jdField_a_of_type_Boolean = true;
        paramByteBuffer = (VasExtensionHandler)this.app.getBusinessHandler(BusinessHandlerFactory.VAS_EXTENSION_HANDLER);
        if (paramByteBuffer != null) {
          paramByteBuffer.notifyUI(3, true, new com.tencent.util.Pair(paramanrp.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo.uin, Integer.valueOf(paramShort1)));
        }
      }
      QLog.i("ApolloManager", 1, "handleGetDetalInfo apollo status flag: " + paramShort1);
      return;
    case 27059: 
      l1 = paramByteBuffer.getInt();
      if (l1 != paramanrp.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo.apolloServerTS)
      {
        paramanrp.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo.apolloServerTS = l1;
        paramanrp.jdField_a_of_type_Boolean = true;
      }
      QLog.i("ApolloManager", 1, "handleGetDetalInfo apollo svr TS: " + l1 + ",local TS: " + paramanrp.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo.apolloServerTS);
      return;
    case -23306: 
      int i = paramByteBuffer.getShort();
      if (i != paramanrp.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo.cmshow3dFlag)
      {
        paramanrp.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo.cmshow3dFlag = i;
        paramanrp.jdField_a_of_type_Boolean = true;
      }
      QLog.d("ApolloManager", 1, new Object[] { "handleGetDetalInfo apollo svr cmshow3dFlag: ", Short.valueOf(i), ", local cmshow3dFlag: ", Integer.valueOf(paramanrp.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo.cmshow3dFlag) });
      return;
    case 27206: 
      l1 = paramByteBuffer.getInt();
      long l2 = NetConnInfoCenter.getServerTime();
      if ((l1 < l2) && (paramanrp.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo.apolloSignValidTS != l1))
      {
        paramanrp.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo.apolloLocalSignTs = paramanrp.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo.apolloSignValidTS;
        paramanrp.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo.apolloSignValidTS = l1;
        paramanrp.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo.apolloSignStr = "";
        paramanrp.jdField_a_of_type_Boolean = true;
      }
      QLog.i("ApolloManager", 1, "handleGetDetalInfo apollo Sign TS: " + l1 + ", currTS: " + l2);
      return;
    case -25019: 
      paramShort1 = paramByteBuffer.getShort();
      if (paramShort1 != amme.a(this.app)) {
        paramanrp.jdField_a_of_type_Amme.b(paramShort1);
      }
      QLog.i("ApolloManager", 1, "handleGetDetalInfo apollo white list: " + paramShort1);
      return;
    }
    paramShort1 = paramByteBuffer.getInt();
    if ((this.app != null) && (String.valueOf(paramLong).equals(this.app.getCurrentUin()))) {
      paramanrp.jdField_a_of_type_Amme.a(paramShort1, 1);
    }
    if ((paramanrp.jdField_a_of_type_Amme != null) && (paramanrp.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo.apolloAISwitch != paramShort1))
    {
      paramanrp.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo.apolloAISwitch = paramShort1;
      paramanrp.jdField_a_of_type_Boolean = true;
    }
    if (paramanrp.jdField_a_of_type_Amme != null) {
      paramanrp.jdField_a_of_type_Amme.n = true;
    }
    QLog.i("ApolloManager", 1, "handleGetDetalInfo apollo AIFlag: " + paramShort1);
  }
  
  private void a(ByteBuffer paramByteBuffer, short paramShort1, short paramShort2, Long paramLong, Card paramCard, anrq paramanrq)
  {
    boolean bool1 = true;
    switch (paramShort1)
    {
    default: 
      return;
    case -23456: 
      paramShort1 = paramByteBuffer.getShort();
      paramByteBuffer = this.app.getLebaHelper().a;
      if (paramByteBuffer == null) {
        paramByteBuffer = new bilm(this.app);
      }
      break;
    }
    for (;;)
    {
      if (paramShort1 == 1) {}
      for (bool1 = true;; bool1 = false)
      {
        boolean bool2 = paramByteBuffer.jdField_a_of_type_Boolean;
        if (bool1 == bool2) {
          break;
        }
        paramByteBuffer.a(this.app, bool1);
        notifyUI(91, true, new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        return;
      }
      paramShort1 = paramByteBuffer.getShort();
      if (paramShort1 <= 0) {
        break;
      }
      bczv.a().a(paramShort1, String.valueOf(paramLong));
      return;
      short s = paramByteBuffer.getShort();
      paramCard.extendFriendEntryAddFriend = s;
      bhhr.a(this.mApp.getCurrentAccountUin(), "extend_friend_config_785").edit().putInt("sp_extend_friend_entry_add_friend", s).apply();
      return;
      s = paramByteBuffer.getShort();
      paramCard.extendFriendQuestion = s;
      paramByteBuffer = this.app.getCurrentAccountUin();
      if (s == 1) {}
      for (;;)
      {
        aslo.a(paramByteBuffer, bool1);
        return;
        bool1 = false;
      }
      paramanrq.jdField_b_of_type_Short = paramByteBuffer.getShort();
      if (((Integer)axqc.a(this.app.getAccount(), "qq_avatar_type", Integer.valueOf(-1))).intValue() == paramanrq.jdField_b_of_type_Short) {
        break;
      }
      axqc.a(this.app.getAccount(), "qq_avatar_type", Integer.valueOf(paramanrq.jdField_b_of_type_Short));
      return;
      paramanrq.jdField_c_of_type_Short = paramByteBuffer.getShort();
      return;
      paramanrq.jdField_a_of_type_Short = paramByteBuffer.getShort();
      return;
    }
  }
  
  private void a(ByteBuffer paramByteBuffer, short paramShort1, short paramShort2, Long paramLong, Card paramCard, anrr paramanrr)
  {
    int i;
    switch (paramShort1)
    {
    default: 
      return;
    case 20002: 
      paramLong = new byte[paramShort2];
      paramByteBuffer.get(paramLong);
      paramCard.strNick = new String(paramLong);
      return;
    case 20009: 
      paramShort1 = paramByteBuffer.get();
      if (paramShort1 == 1)
      {
        paramCard.shGender = 0;
        return;
      }
      if (paramShort1 == 2)
      {
        paramCard.shGender = 1;
        return;
      }
      paramCard.shGender = -1;
      return;
    case 27037: 
      paramShort1 = paramByteBuffer.getInt();
      if (bgzv.a(paramShort1))
      {
        paramCard.iProfession = paramShort1;
        return;
      }
      paramCard.iProfession = -1;
      return;
    case 20031: 
      paramCard.lBirthday = paramByteBuffer.getInt();
      if (paramCard.lBirthday == 0L)
      {
        paramCard.constellation = 0;
        return;
      }
      paramCard.constellation = bhbx.a((int)((paramCard.lBirthday & 0xFF00) >> 8), (int)(paramCard.lBirthday & 0xFF));
      return;
    case 24008: 
      paramLong = new byte[paramShort2];
      paramByteBuffer.get(paramLong);
      paramCard.strCompany = new String(paramLong);
      return;
    case 24002: 
      paramShort1 = paramByteBuffer.getInt();
      paramShort2 = paramByteBuffer.getInt();
      i = paramByteBuffer.getInt();
      paramanrr.jdField_b_of_type_Boolean = true;
      paramanrr.e = anrz.a(paramShort1);
      paramanrr.f = anrz.a(paramShort2);
      paramanrr.g = anrz.a(i);
      return;
    case 20043: 
      paramShort1 = paramByteBuffer.getInt();
      paramanrr.jdField_b_of_type_Boolean = true;
      paramanrr.h = anrz.a(paramShort1);
      return;
    case 20032: 
      paramShort1 = paramByteBuffer.getInt();
      paramShort2 = paramByteBuffer.getInt();
      i = paramByteBuffer.getInt();
      paramanrr.jdField_a_of_type_Boolean = true;
      paramanrr.jdField_a_of_type_JavaLangString = anrz.a(paramShort1);
      paramanrr.jdField_b_of_type_JavaLangString = anrz.a(paramShort2);
      paramanrr.jdField_c_of_type_JavaLangString = anrz.a(i);
      return;
    case 20041: 
      paramShort1 = paramByteBuffer.getInt();
      paramanrr.jdField_a_of_type_Boolean = true;
      paramanrr.jdField_d_of_type_JavaLangString = anrz.a(paramShort1);
      return;
    case 20011: 
      paramLong = new byte[paramShort2];
      paramByteBuffer.get(paramLong);
      paramCard.strEmail = new String(paramLong);
      return;
    case 20019: 
      paramLong = new byte[paramShort2];
      paramByteBuffer.get(paramLong);
      paramCard.strPersonalNote = new String(paramLong);
      return;
    case 20021: 
      paramLong = new byte[paramShort2];
      paramByteBuffer.get(paramLong);
      paramCard.strSchool = new String(paramLong);
      axqc.a(this.app.getAccount(), "self_school_name", paramCard.strSchool);
      return;
    case 20037: 
      paramCard.age = paramByteBuffer.get();
      paramCard.shAge = ((short)paramCard.age);
      return;
    }
    paramCard.constellation = paramByteBuffer.get();
  }
  
  private void a(ByteBuffer paramByteBuffer, short paramShort1, short paramShort2, Long paramLong, Card paramCard, bdvo parambdvo)
  {
    boolean bool1 = false;
    boolean bool3 = true;
    boolean bool4 = true;
    boolean bool5 = true;
    boolean bool6 = true;
    boolean bool7 = true;
    boolean bool8 = true;
    boolean bool2 = true;
    switch (paramShort1)
    {
    default: 
    case -23221: 
      do
      {
        return;
        if (paramByteBuffer.getShort() == 0) {
          bool1 = true;
        }
        aiin.a(this.app).a(bool1);
        notifyUI(104, true, Boolean.valueOf(bool1));
      } while (!QLog.isColorLevel());
      QLog.i("CardHandler", 2, "handleGetDetailInfo emotionRec onLine:" + bool1);
      return;
    case -23172: 
      if (paramByteBuffer.getShort() == 1) {}
      for (bool1 = bool2;; bool1 = false)
      {
        bdvn.b(bool1);
        ((bdve)this.app.getManager(QQManagerFactory.STUDY_MODE_SWITCHER_MANAGER)).c(bool1);
        return;
      }
    case -23251: 
      paramShort1 = paramByteBuffer.getShort();
      parambdvo.jdField_a_of_type_Boolean = true;
      if (paramShort1 == 1) {}
      for (bool1 = bool3;; bool1 = false)
      {
        parambdvo.d = bool1;
        return;
      }
    case -23174: 
      paramShort1 = paramByteBuffer.getShort();
      parambdvo.jdField_a_of_type_Boolean = true;
      if (paramShort1 == 1) {}
      for (bool1 = bool4;; bool1 = false)
      {
        parambdvo.c = bool1;
        return;
      }
    case -23104: 
      paramShort1 = paramByteBuffer.getShort();
      parambdvo.jdField_a_of_type_Boolean = true;
      if (paramShort1 == 1) {}
      for (bool1 = bool5;; bool1 = false)
      {
        parambdvo.jdField_b_of_type_Boolean = bool1;
        return;
      }
    case -23046: 
      bdvn.a(paramByteBuffer.getShort());
      return;
    case -23143: 
      paramShort1 = paramByteBuffer.getShort();
      ((avhp)this.app.getManager(QQManagerFactory.CUSTOMIZE_GRAY_TIPS)).a(paramShort1);
      return;
    case -23103: 
      ((afza)this.app.getManager(QQManagerFactory.PAI_YI_PAI_MANAGER)).a(paramByteBuffer.getShort());
      return;
    case -23102: 
      ((afza)this.app.getManager(QQManagerFactory.PAI_YI_PAI_MANAGER)).b(paramByteBuffer.getShort());
      return;
    case 27390: 
      ((afza)this.app.getManager(QQManagerFactory.PAI_YI_PAI_MANAGER)).c(paramByteBuffer.getShort());
      return;
    case -23108: 
      if (paramByteBuffer.getShort() == 0) {}
      for (bool1 = bool6;; bool1 = false)
      {
        bdvn.a(16, bool1);
        return;
      }
    case -23107: 
      if (paramByteBuffer.getShort() == 0) {}
      for (bool1 = bool7;; bool1 = false)
      {
        bdvn.a(32, bool1);
        return;
      }
    }
    if (paramByteBuffer.getShort() == 0) {}
    for (bool1 = bool8;; bool1 = false)
    {
      bdvn.a(8, bool1);
      return;
    }
  }
  
  private void a(List<Short> paramList, Bundle paramBundle, String paramString)
  {
    a(paramList, paramBundle, paramString, 9);
  }
  
  private void a(List<Short> paramList, Bundle paramBundle, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CardHandler", 2, "getDetailCardInfo");
    }
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
    paramList = createToServiceMsg("OidbSvc.0x480_9");
    paramList.putWupBuffer(localOIDBSSOPkg.toByteArray());
    if (paramBundle != null) {
      paramList.extraData.putAll(paramBundle);
    }
    paramList.extraData.putBoolean("reqFromCardHandler", true);
    sendPbReq(paramList);
  }
  
  private void a(oidb_0x5eb.UdcUinData paramUdcUinData, Card paramCard, QQAppInterface paramQQAppInterface)
  {
    if (paramUdcUinData.uint32_profile_sex_visible.has()) {
      bagq.a.a(41611, paramUdcUinData.uint32_profile_sex_visible.get(), paramCard, paramQQAppInterface);
    }
    if (paramUdcUinData.uint32_profile_age_visible.has()) {
      bagq.a.a(41610, paramUdcUinData.uint32_profile_age_visible.get(), paramCard, paramQQAppInterface);
    }
    if (paramUdcUinData.uint32_profile_birthday_visible.has()) {
      bagq.a.a(41607, paramUdcUinData.uint32_profile_birthday_visible.get(), paramCard, paramQQAppInterface);
    }
    if (paramUdcUinData.uint32_profile_constellation_visible.has()) {
      bagq.a.a(41609, paramUdcUinData.uint32_profile_constellation_visible.get(), paramCard, paramQQAppInterface);
    }
    if (paramUdcUinData.uint32_profile_profession_visible.has()) {
      bagq.a.a(41618, paramUdcUinData.uint32_profile_profession_visible.get(), paramCard, paramQQAppInterface);
    }
    if (paramUdcUinData.uint32_profile_college_visible.has()) {
      bagq.a.a(41619, paramUdcUinData.uint32_profile_college_visible.get(), paramCard, paramQQAppInterface);
    }
    if (paramUdcUinData.uint32_profile_location_visible.has()) {
      bagq.a.a(41614, paramUdcUinData.uint32_profile_location_visible.get(), paramCard, paramQQAppInterface);
    }
    if (paramUdcUinData.uint32_profile_hometown_visible.has()) {
      bagq.a.a(41613, paramUdcUinData.uint32_profile_hometown_visible.get(), paramCard, paramQQAppInterface);
    }
    if (paramUdcUinData.uint32_profile_email_visible.has()) {
      bagq.a.a(41622, paramUdcUinData.uint32_profile_email_visible.get(), paramCard, paramQQAppInterface);
    }
    if (paramUdcUinData.uint32_profile_personal_note_visible.has()) {
      bagq.a.a(41623, paramUdcUinData.uint32_profile_personal_note_visible.get(), paramCard, paramQQAppInterface);
    }
    if (paramUdcUinData.uint32_profile_company_visible.has()) {
      bagq.a.a(40272, paramUdcUinData.uint32_profile_company_visible.get(), paramCard, paramQQAppInterface);
    }
  }
  
  private boolean a(Card paramCard, SparseArray<bcra> paramSparseArray, long paramLong1, long paramLong2)
  {
    int i = 0;
    Object localObject1 = (bcra)paramSparseArray.get(17);
    if ((localObject1 != null) && (((bcra)localObject1).a != null))
    {
      if (paramLong1 == paramLong2)
      {
        paramSparseArray = new INTERFACE.StGetUserAppListRsp();
        try
        {
          paramSparseArray.mergeFrom(((bcra)localObject1).a);
          if (paramSparseArray != null)
          {
            Object localObject2 = paramSparseArray.userAppList.get();
            if ((localObject2 == null) || (((List)localObject2).size() < 1))
            {
              paramCard.isShowMiniPlaying = false;
              return true;
            }
            localObject1 = new ArrayList();
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext()) {
              ((ArrayList)localObject1).add(MiniAppInfo.from((INTERFACE.StUserAppInfo)((Iterator)localObject2).next()));
            }
          }
          paramCard.isShowMiniPlaying = true;
        }
        catch (Exception paramSparseArray)
        {
          if (QLog.isColorLevel()) {
            QLog.d("CardHandler", 2, "onResponse fail." + paramSparseArray);
          }
        }
      }
      for (;;)
      {
        return true;
        paramCard.miniAppInfoArrayList = ((ArrayList)localObject1);
        if ((paramSparseArray.extInfo != null) && (paramSparseArray.extInfo.mapInfo != null))
        {
          while (i < paramSparseArray.extInfo.mapInfo.size())
          {
            localObject1 = (COMM.Entry)paramSparseArray.extInfo.mapInfo.get(i);
            if ("jumpUrl".equals(((COMM.Entry)localObject1).key.get())) {
              paramCard.tabJumpUrl = ((COMM.Entry)localObject1).value.get();
            }
            i += 1;
          }
          continue;
          paramSparseArray = new MISC.StGetFriendPlayListV2Rsp();
          try
          {
            paramSparseArray.mergeFrom(((bcra)localObject1).a);
            if (paramSparseArray == null) {
              continue;
            }
            paramCard.appPlayingInfos = paramSparseArray.appPlayingInfos.get();
            if ((paramCard.appPlayingInfos != null) && (paramCard.appPlayingInfos.size() >= 1)) {
              break label339;
            }
            paramCard.isShowMiniPlaying = false;
            return true;
          }
          catch (InvalidProtocolBufferMicroException paramSparseArray)
          {
            paramSparseArray.printStackTrace();
          }
          continue;
          label339:
          paramCard.guestJumpUrl = paramSparseArray.moreJumpLink.get();
          paramCard.guestAppTotal = paramSparseArray.total.get();
        }
      }
    }
    paramCard.isShowMiniPlaying = false;
    return true;
  }
  
  private void aa(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
    for (;;)
    {
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if ((paramToServiceMsg == null) || (paramToServiceMsg.uint32_result.get() != 0)) {
          break label637;
        }
        bool = true;
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.", 2, "handleGetIsQidianMaster result=" + bool);
        }
        if ((!bool) || (!paramToServiceMsg.bytes_bodybuffer.has()) || (paramToServiceMsg.bytes_bodybuffer.get() == null)) {
          continue;
        }
        paramToServiceMsg = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        paramFromServiceMsg = Long.valueOf(bhbx.a(paramToServiceMsg.getInt()));
        paramToServiceMsg.get();
        paramObject = Short.valueOf(paramToServiceMsg.getShort());
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.", 2, "handleGetIsQidianMaster wTlvCount: " + paramObject);
        }
        if ((paramObject.shortValue() != 1) || (paramToServiceMsg.getShort() != -25176)) {
          continue;
        }
        i = paramToServiceMsg.getShort();
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.", 2, "handleGetIsQidianMaster wFieldLen: " + i);
        }
        if (i != 2) {
          continue;
        }
        paramObject = new byte[i];
        paramToServiceMsg.get(paramObject);
        j = bhbx.a(paramObject, 0);
        i = paramToServiceMsg.getShort();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.", 2, "handleGetIsQidianMaster wFieldLeft: " + i);
      }
      catch (Exception paramObject)
      {
        int j;
        paramToServiceMsg = null;
        continue;
        if (i != 0) {
          continue;
        }
        int i = 4;
        if (j == 0) {
          continue;
        }
        i = 6;
        continue;
      }
      paramToServiceMsg = new BmqqAccountType(String.valueOf(paramFromServiceMsg), i);
      try
      {
        paramObject = (bjxa)this.mApp.getManager(QQManagerFactory.QIDIAN_MANAGER);
        paramObject.a(paramToServiceMsg);
        if (j != 0)
        {
          QLog.i("Q.profilecard.", 1, MsfSdkUtils.getShortUin(String.valueOf(paramFromServiceMsg)) + " handleGetIsQidianMaster is qidianmaster");
          QidianExternalInfo localQidianExternalInfo = paramObject.a(String.valueOf(paramFromServiceMsg));
          paramFromServiceMsg = paramObject.a(String.valueOf(paramFromServiceMsg));
          if ((localQidianExternalInfo == null) || (paramFromServiceMsg == null)) {
            paramObject.b(this.app.getApp().getBaseContext(), paramToServiceMsg);
          }
          notifyUI(89, true, paramToServiceMsg);
          return;
        }
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.profilecard.", 2, "handleGetIsQidianMaster sFieldValue: " + j);
        continue;
        paramObject.printStackTrace();
      }
      catch (Exception paramObject) {}
      paramFromServiceMsg = paramToServiceMsg;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.profilecard.", 2, "handleGetIsQidianMaster exception: " + paramObject.getMessage());
        paramFromServiceMsg = paramToServiceMsg;
      }
      notifyUI(89, false, paramFromServiceMsg);
      return;
      paramFromServiceMsg = null;
      continue;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "handleGetIsQidianMaster isSuccess: " + bool);
      }
      paramFromServiceMsg = null;
      continue;
      bool = false;
      break;
      label637:
      bool = false;
    }
  }
  
  private void ab(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = paramToServiceMsg.extraData.getString("from");
    if (QLog.isDevelopLevel()) {
      QLog.i("MedalWallMng", 4, String.format(Locale.getDefault(), "handleGetMedalWallInfo from: %s", new Object[] { paramToServiceMsg }));
    }
    if ("getSelfNewObtainedMedalWall".equals(paramToServiceMsg)) {
      a(paramFromServiceMsg, paramObject);
    }
  }
  
  private void ac(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
        paramToServiceMsg = ((MedalWallMng)this.app.getManager(QQManagerFactory.MEDAL_WALL_MNG)).a(paramFromServiceMsg, false);
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
  
  private void ad(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
        if ((paramToServiceMsg != null) && (TextUtils.equals(this.app.getCurrentUin(), paramToServiceMsg.getUin()))) {
          ((ajmy)this.app.getManager(QQManagerFactory.CTENTRY_MNG)).a(bool1, i, bool2);
        }
      }
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("CardHandler", 4, "handleGetBindPhoneSwitchInfo needShow:" + bool1 + " net_gap:" + i + " isNewUser:" + bool2 + " uin:" + this.app.getCurrentUin() + "  result:" + k);
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
  
  private void ae(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
          paramObject = new bcrt().a(paramObject);
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
    paramFromServiceMsg.add(new AutoReplyText(anvx.a(2131700949), 2147483647));
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
        ((azaz)this.app.getManager(QQManagerFactory.AUTO_REPLY_MANAGER)).a(paramFromServiceMsg, j);
      }
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, String.format("handleGetAutoReplyList result: %s, isSuccess: %s, enableAutoReply: %s, replyList size: %s, selectId: %s", new Object[] { Integer.valueOf(m), Boolean.valueOf(bool2), Boolean.valueOf(bool1), Integer.valueOf(k), Integer.valueOf(j) }));
      }
      notifyUI(97, bool2, new Object[] { paramFromServiceMsg, Integer.valueOf(j) });
      return;
    }
  }
  
  private void af(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
        ((azaz)this.app.getManager(QQManagerFactory.AUTO_REPLY_MANAGER)).a(paramFromServiceMsg, j);
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
  
  private void ag(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
          label91:
          int i;
          if (paramFromServiceMsg.uint32_result.get() == 0)
          {
            bool1 = bool2;
            if (QLog.isColorLevel()) {
              QLog.d("Q.profilecard.", 2, "handleSetStrangerInviteToGroupSwitch result=" + bool1);
            }
            if ((!bool1) || (!paramFromServiceMsg.bytes_bodybuffer.has()) || (paramFromServiceMsg.bytes_bodybuffer.get() == null)) {
              break label429;
            }
            i = ByteBuffer.wrap(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray()).getInt();
            if (i >= 0) {
              break label403;
            }
          }
          label403:
          for (long l = i + 4294967296L;; l = i)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.profilecard.", 2, "handleSetStrangerInviteToGroupSwitch uin=" + this.app.getCurrentAccountUin() + "  lUin:" + String.valueOf(l));
            }
            if (!this.app.getCurrentAccountUin().equals(String.valueOf(l))) {
              break label429;
            }
            paramFromServiceMsg = (anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
            paramObject = paramFromServiceMsg.c(this.app.getCurrentAccountUin());
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
            break label91;
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
    label429:
  }
  
  /* Error */
  private void ah(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
    //   16: invokevirtual 100	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   19: ifeq +110 -> 129
    //   22: aload_3
    //   23: ifnull +106 -> 129
    //   26: iconst_1
    //   27: istore 7
    //   29: ldc_w 3350
    //   32: iconst_2
    //   33: new 20	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   40: ldc_w 3352
    //   43: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: iload 7
    //   48: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   51: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: iconst_m1
    //   58: istore 4
    //   60: iload 7
    //   62: ifne +79 -> 141
    //   65: iload 4
    //   67: istore 5
    //   69: ldc_w 3350
    //   72: iconst_2
    //   73: new 20	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   80: ldc_w 3354
    //   83: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: aload_2
    //   87: invokevirtual 107	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   90: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   93: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   99: aload_1
    //   100: getfield 600	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   103: ldc_w 3356
    //   106: invokevirtual 803	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   109: ifne +26 -> 135
    //   112: iload 11
    //   114: istore 7
    //   116: aload_0
    //   117: bipush 105
    //   119: iconst_0
    //   120: iload 7
    //   122: invokestatic 180	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   125: invokevirtual 184	anri:notifyUI	(IZLjava/lang/Object;)V
    //   128: return
    //   129: iconst_0
    //   130: istore 7
    //   132: goto -103 -> 29
    //   135: iconst_0
    //   136: istore 7
    //   138: goto -22 -> 116
    //   141: iload 4
    //   143: istore 5
    //   145: new 117	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   148: dup
    //   149: invokespecial 118	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   152: aload_3
    //   153: checkcast 120	[B
    //   156: checkcast 120	[B
    //   159: invokevirtual 124	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   162: checkcast 117	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   165: astore_2
    //   166: iload 4
    //   168: istore 5
    //   170: iload 4
    //   172: istore 6
    //   174: aload_2
    //   175: getfield 128	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   178: invokevirtual 133	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
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
    //   201: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   204: invokevirtual 147	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   207: ifeq +86 -> 293
    //   210: iload 4
    //   212: istore 5
    //   214: iload 4
    //   216: istore 6
    //   218: ldc_w 3350
    //   221: iconst_2
    //   222: new 20	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   229: ldc_w 3358
    //   232: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: aload_2
    //   236: getfield 128	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   239: invokevirtual 133	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   242: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   245: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: invokestatic 115	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   251: aload_1
    //   252: getfield 600	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   255: ldc_w 3356
    //   258: invokevirtual 803	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   261: ifne +26 -> 287
    //   264: iload 12
    //   266: istore 7
    //   268: aload_0
    //   269: bipush 105
    //   271: iconst_0
    //   272: iload 7
    //   274: invokestatic 180	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   277: invokevirtual 184	anri:notifyUI	(IZLjava/lang/Object;)V
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
    //   301: new 3360	tencent/im/oidb/cmd0xd8a$RspBody
    //   304: dup
    //   305: invokespecial 3361	tencent/im/oidb/cmd0xd8a$RspBody:<init>	()V
    //   308: astore_3
    //   309: iload 4
    //   311: istore 5
    //   313: iload 4
    //   315: istore 6
    //   317: aload_3
    //   318: aload_2
    //   319: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   322: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   325: invokevirtual 159	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   328: invokevirtual 3362	tencent/im/oidb/cmd0xd8a$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   331: pop
    //   332: iload 4
    //   334: istore 5
    //   336: iload 4
    //   338: istore 6
    //   340: aload_3
    //   341: getfield 3365	tencent/im/oidb/cmd0xd8a$RspBody:uint32_retcode	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   344: invokevirtual 133	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   347: istore 4
    //   349: iload 4
    //   351: istore 5
    //   353: iload 4
    //   355: istore 6
    //   357: aload_3
    //   358: getfield 3368	tencent/im/oidb/cmd0xd8a$RspBody:str_res	Lcom/tencent/mobileqq/pb/PBStringField;
    //   361: invokevirtual 897	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   364: astore_2
    //   365: iload 4
    //   367: istore 5
    //   369: iload 4
    //   371: istore 6
    //   373: ldc_w 3350
    //   376: iconst_1
    //   377: new 20	java/lang/StringBuilder
    //   380: dup
    //   381: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   384: ldc_w 3370
    //   387: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: iload 4
    //   392: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   395: ldc_w 3372
    //   398: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: aload_2
    //   402: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   408: invokestatic 115	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   411: aload_1
    //   412: getfield 600	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   415: ldc_w 3356
    //   418: invokevirtual 803	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   421: istore 7
    //   423: iload 4
    //   425: ifne +12 -> 437
    //   428: aload_0
    //   429: bipush 105
    //   431: iconst_1
    //   432: aconst_null
    //   433: invokevirtual 184	anri:notifyUI	(IZLjava/lang/Object;)V
    //   436: return
    //   437: iload 7
    //   439: ifne +20 -> 459
    //   442: iload 8
    //   444: istore 7
    //   446: aload_0
    //   447: bipush 105
    //   449: iconst_0
    //   450: iload 7
    //   452: invokestatic 180	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   455: invokevirtual 184	anri:notifyUI	(IZLjava/lang/Object;)V
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
    //   478: ldc_w 3350
    //   481: iconst_1
    //   482: new 20	java/lang/StringBuilder
    //   485: dup
    //   486: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   489: ldc_w 3374
    //   492: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: aload_2
    //   496: invokevirtual 2053	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   499: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   502: invokestatic 115	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   505: aload_1
    //   506: getfield 600	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   509: ldc_w 3356
    //   512: invokevirtual 803	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   515: istore 7
    //   517: iload 4
    //   519: ifne +74 -> 593
    //   522: aload_0
    //   523: bipush 105
    //   525: iconst_1
    //   526: aconst_null
    //   527: invokevirtual 184	anri:notifyUI	(IZLjava/lang/Object;)V
    //   530: return
    //   531: iload 4
    //   533: istore 5
    //   535: ldc_w 3350
    //   538: iconst_1
    //   539: new 20	java/lang/StringBuilder
    //   542: dup
    //   543: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   546: ldc_w 3376
    //   549: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: aload_2
    //   553: invokevirtual 2053	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   556: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   559: invokestatic 115	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   562: goto -57 -> 505
    //   565: astore_2
    //   566: aload_1
    //   567: getfield 600	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   570: ldc_w 3356
    //   573: invokevirtual 803	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   576: istore 7
    //   578: iload 5
    //   580: ifne +41 -> 621
    //   583: aload_0
    //   584: bipush 105
    //   586: iconst_1
    //   587: aconst_null
    //   588: invokevirtual 184	anri:notifyUI	(IZLjava/lang/Object;)V
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
    //   608: invokestatic 180	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   611: invokevirtual 184	anri:notifyUI	(IZLjava/lang/Object;)V
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
    //   636: invokestatic 180	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   639: invokevirtual 184	anri:notifyUI	(IZLjava/lang/Object;)V
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
    //   0	662	0	this	anri
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
  private void ai(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 9
    //   3: iconst_0
    //   4: istore 10
    //   6: aload_2
    //   7: invokevirtual 100	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   10: ifeq +384 -> 394
    //   13: aload_3
    //   14: ifnull +380 -> 394
    //   17: iconst_1
    //   18: istore 4
    //   20: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   23: ifeq +30 -> 53
    //   26: ldc 195
    //   28: iconst_2
    //   29: new 20	java/lang/StringBuilder
    //   32: dup
    //   33: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   36: ldc_w 3379
    //   39: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: iload 4
    //   44: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   47: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   74: new 117	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   77: dup
    //   78: invokespecial 118	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   81: aload_3
    //   82: checkcast 120	[B
    //   85: checkcast 120	[B
    //   88: invokevirtual 124	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   91: checkcast 117	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   94: astore_2
    //   95: iload 4
    //   97: istore 7
    //   99: iload 4
    //   101: istore 5
    //   103: aload_2
    //   104: getfield 128	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   107: invokevirtual 133	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   110: ifne +290 -> 400
    //   113: iconst_1
    //   114: istore 4
    //   116: iload 4
    //   118: istore 7
    //   120: iload 4
    //   122: istore 5
    //   124: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   127: ifeq +38 -> 165
    //   130: iload 4
    //   132: istore 7
    //   134: iload 4
    //   136: istore 5
    //   138: ldc 195
    //   140: iconst_2
    //   141: new 20	java/lang/StringBuilder
    //   144: dup
    //   145: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   148: ldc_w 3381
    //   151: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: iload 4
    //   156: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   159: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   162: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   195: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   198: invokevirtual 147	com/tencent/mobileqq/pb/PBBytesField:has	()Z
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
    //   221: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   224: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   227: ifnull +102 -> 329
    //   230: iload 4
    //   232: istore 7
    //   234: iload 4
    //   236: istore 5
    //   238: aload_2
    //   239: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   242: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   245: invokevirtual 159	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   248: invokestatic 614	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   251: invokevirtual 617	java/nio/ByteBuffer:getInt	()I
    //   254: invokestatic 1024	bhbx:a	(I)J
    //   257: lstore 11
    //   259: iload 4
    //   261: istore 7
    //   263: iload 4
    //   265: istore 5
    //   267: aload_0
    //   268: getfield 229	anri:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   271: invokevirtual 294	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   274: lload 11
    //   276: invokestatic 680	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   279: invokevirtual 683	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   282: ifeq +124 -> 406
    //   285: iload 4
    //   287: istore 7
    //   289: iload 4
    //   291: istore 5
    //   293: aload_1
    //   294: getfield 600	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   297: ldc_w 3383
    //   300: invokevirtual 803	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   303: istore 6
    //   305: iload 6
    //   307: istore 5
    //   309: aload_0
    //   310: getfield 229	anri:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   313: invokestatic 2935	aiin:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Laiin;
    //   316: iload 5
    //   318: invokevirtual 2937	aiin:a	(Z)V
    //   321: iload 5
    //   323: istore 6
    //   325: iload 4
    //   327: istore 8
    //   329: iload 6
    //   331: istore 4
    //   333: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   336: ifeq +45 -> 381
    //   339: ldc 195
    //   341: iconst_2
    //   342: new 20	java/lang/StringBuilder
    //   345: dup
    //   346: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   349: ldc_w 3381
    //   352: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: iload 8
    //   357: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   360: ldc_w 3385
    //   363: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   366: iload 6
    //   368: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   371: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   374: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   377: iload 6
    //   379: istore 4
    //   381: aload_0
    //   382: bipush 104
    //   384: iconst_1
    //   385: iload 4
    //   387: invokestatic 180	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   390: invokevirtual 184	anri:notifyUI	(IZLjava/lang/Object;)V
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
    //   422: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   425: ifeq -96 -> 329
    //   428: iload 4
    //   430: istore 7
    //   432: iload 4
    //   434: istore 5
    //   436: ldc 195
    //   438: iconst_2
    //   439: new 20	java/lang/StringBuilder
    //   442: dup
    //   443: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   446: ldc_w 3387
    //   449: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: aload_0
    //   453: getfield 229	anri:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   456: invokevirtual 294	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   459: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: ldc_w 1028
    //   465: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: lload 11
    //   470: invokevirtual 840	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   473: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   476: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   498: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   501: ifeq +13 -> 514
    //   504: ldc 195
    //   506: iconst_1
    //   507: ldc_w 3389
    //   510: aload_1
    //   511: invokestatic 189	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   514: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   517: ifeq +134 -> 651
    //   520: ldc 195
    //   522: iconst_2
    //   523: new 20	java/lang/StringBuilder
    //   526: dup
    //   527: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   530: ldc_w 3381
    //   533: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: iconst_0
    //   537: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   540: ldc_w 3385
    //   543: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   546: iload 4
    //   548: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   551: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   554: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   557: goto -176 -> 381
    //   560: astore_1
    //   561: iload 9
    //   563: istore 6
    //   565: iload 5
    //   567: istore 4
    //   569: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   572: ifeq +41 -> 613
    //   575: ldc 195
    //   577: iconst_2
    //   578: new 20	java/lang/StringBuilder
    //   581: dup
    //   582: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   585: ldc_w 3381
    //   588: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: iload 4
    //   593: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   596: ldc_w 3385
    //   599: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   602: iload 6
    //   604: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   607: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   610: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   0	654	0	this	anri
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
  
  /* Error */
  private void aj(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
    //   13: invokevirtual 100	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   16: ifeq +414 -> 430
    //   19: aload_3
    //   20: ifnull +410 -> 430
    //   23: iconst_1
    //   24: istore 5
    //   26: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   29: ifeq +31 -> 60
    //   32: ldc_w 726
    //   35: iconst_2
    //   36: new 20	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   43: ldc_w 3392
    //   46: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: iload 5
    //   51: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   54: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   60: iload 5
    //   62: istore 6
    //   64: iload 12
    //   66: istore 8
    //   68: iload 5
    //   70: ifeq +285 -> 355
    //   73: iload 5
    //   75: istore 10
    //   77: iload 5
    //   79: istore 7
    //   81: iload 14
    //   83: istore 9
    //   85: new 117	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   88: dup
    //   89: invokespecial 118	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   92: aload_3
    //   93: checkcast 120	[B
    //   96: checkcast 120	[B
    //   99: invokevirtual 124	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   102: checkcast 117	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   105: astore_2
    //   106: aload_2
    //   107: ifnull +329 -> 436
    //   110: iload 5
    //   112: istore 10
    //   114: iload 5
    //   116: istore 7
    //   118: iload 14
    //   120: istore 9
    //   122: aload_2
    //   123: getfield 128	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   126: invokevirtual 133	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   129: ifne +307 -> 436
    //   132: iconst_1
    //   133: istore 5
    //   135: iload 5
    //   137: istore 6
    //   139: iload 12
    //   141: istore 8
    //   143: iload 5
    //   145: ifeq +210 -> 355
    //   148: iload 5
    //   150: istore 6
    //   152: iload 12
    //   154: istore 8
    //   156: iload 5
    //   158: istore 10
    //   160: iload 5
    //   162: istore 7
    //   164: iload 14
    //   166: istore 9
    //   168: aload_2
    //   169: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   172: invokevirtual 147	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   175: ifeq +180 -> 355
    //   178: iload 5
    //   180: istore 6
    //   182: iload 12
    //   184: istore 8
    //   186: iload 5
    //   188: istore 10
    //   190: iload 5
    //   192: istore 7
    //   194: iload 14
    //   196: istore 9
    //   198: aload_2
    //   199: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   202: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   205: ifnull +150 -> 355
    //   208: iload 5
    //   210: istore 10
    //   212: iload 5
    //   214: istore 7
    //   216: iload 14
    //   218: istore 9
    //   220: aload_2
    //   221: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   224: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   227: invokevirtual 159	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   230: invokestatic 614	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   233: astore_2
    //   234: iload 5
    //   236: istore 10
    //   238: iload 5
    //   240: istore 7
    //   242: iload 14
    //   244: istore 9
    //   246: aload_2
    //   247: invokevirtual 617	java/nio/ByteBuffer:getInt	()I
    //   250: istore 4
    //   252: iload 4
    //   254: i2l
    //   255: lstore 15
    //   257: iload 4
    //   259: ifge +12 -> 271
    //   262: iload 4
    //   264: ldc_w 1063
    //   267: iand
    //   268: i2l
    //   269: lstore 15
    //   271: iload 5
    //   273: istore 10
    //   275: iload 5
    //   277: istore 7
    //   279: iload 14
    //   281: istore 9
    //   283: aload_2
    //   284: invokevirtual 620	java/nio/ByteBuffer:get	()B
    //   287: pop
    //   288: iload 5
    //   290: istore 6
    //   292: iload 12
    //   294: istore 8
    //   296: iload 5
    //   298: istore 10
    //   300: iload 5
    //   302: istore 7
    //   304: iload 14
    //   306: istore 9
    //   308: aload_2
    //   309: invokevirtual 624	java/nio/ByteBuffer:getShort	()S
    //   312: invokestatic 635	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   315: invokevirtual 740	java/lang/Short:shortValue	()S
    //   318: iconst_1
    //   319: if_icmpne +36 -> 355
    //   322: iload 5
    //   324: istore 10
    //   326: iload 5
    //   328: istore 7
    //   330: iload 14
    //   332: istore 9
    //   334: aload_2
    //   335: invokevirtual 624	java/nio/ByteBuffer:getShort	()S
    //   338: istore 4
    //   340: iload 4
    //   342: sipush -23234
    //   345: if_icmpeq +97 -> 442
    //   348: iconst_0
    //   349: istore 6
    //   351: iload 12
    //   353: istore 8
    //   355: iload 6
    //   357: istore 7
    //   359: iload 8
    //   361: istore 9
    //   363: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   366: ifeq +50 -> 416
    //   369: ldc_w 726
    //   372: iconst_2
    //   373: new 20	java/lang/StringBuilder
    //   376: dup
    //   377: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   380: ldc_w 3394
    //   383: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: iload 6
    //   388: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   391: ldc_w 3396
    //   394: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: iload 8
    //   399: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   402: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   405: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   408: iload 8
    //   410: istore 9
    //   412: iload 6
    //   414: istore 7
    //   416: aload_0
    //   417: bipush 103
    //   419: iload 7
    //   421: iload 9
    //   423: invokestatic 180	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   426: invokevirtual 184	anri:notifyUI	(IZLjava/lang/Object;)V
    //   429: return
    //   430: iconst_0
    //   431: istore 5
    //   433: goto -407 -> 26
    //   436: iconst_0
    //   437: istore 5
    //   439: goto -304 -> 135
    //   442: iload 5
    //   444: istore 10
    //   446: iload 5
    //   448: istore 7
    //   450: iload 14
    //   452: istore 9
    //   454: aload_2
    //   455: invokevirtual 624	java/nio/ByteBuffer:getShort	()S
    //   458: istore 4
    //   460: iload 4
    //   462: iconst_2
    //   463: if_icmpne +180 -> 643
    //   466: iload 5
    //   468: istore 10
    //   470: iload 5
    //   472: istore 7
    //   474: iload 14
    //   476: istore 9
    //   478: iload 4
    //   480: newarray byte
    //   482: astore_3
    //   483: iload 5
    //   485: istore 10
    //   487: iload 5
    //   489: istore 7
    //   491: iload 14
    //   493: istore 9
    //   495: aload_2
    //   496: aload_3
    //   497: invokevirtual 754	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   500: pop
    //   501: iload 5
    //   503: istore 10
    //   505: iload 5
    //   507: istore 7
    //   509: iload 14
    //   511: istore 9
    //   513: aload_3
    //   514: iconst_0
    //   515: invokestatic 759	bhbx:a	([BI)S
    //   518: istore 4
    //   520: iload 4
    //   522: ifne +32 -> 554
    //   525: iconst_1
    //   526: istore 6
    //   528: aload_2
    //   529: invokevirtual 624	java/nio/ByteBuffer:getShort	()S
    //   532: istore 4
    //   534: iload 4
    //   536: ifeq +24 -> 560
    //   539: iload 11
    //   541: istore 5
    //   543: iload 6
    //   545: istore 8
    //   547: iload 5
    //   549: istore 6
    //   551: goto -196 -> 355
    //   554: iconst_0
    //   555: istore 6
    //   557: goto -29 -> 528
    //   560: getstatic 3400	com/tencent/common/app/BaseApplicationImpl:context	Lcom/tencent/qphone/base/util/BaseApplication;
    //   563: aload_0
    //   564: getfield 229	anri:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   567: invokevirtual 294	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   570: aconst_null
    //   571: ldc_w 3402
    //   574: invokestatic 3406	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:isContainValue	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   577: istore 5
    //   579: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   582: ifeq +30 -> 612
    //   585: ldc 195
    //   587: iconst_2
    //   588: new 20	java/lang/StringBuilder
    //   591: dup
    //   592: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   595: ldc_w 3408
    //   598: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: iload 5
    //   603: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   606: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   609: invokestatic 886	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   612: aload_0
    //   613: getfield 229	anri:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   616: invokevirtual 1056	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   619: aload_1
    //   620: invokevirtual 2519	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   623: aconst_null
    //   624: ldc_w 3402
    //   627: iload 6
    //   629: invokestatic 3412	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:writeValue	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   632: iload 6
    //   634: invokestatic 3415	bkyy:a	(Z)V
    //   637: iconst_1
    //   638: istore 5
    //   640: goto -97 -> 543
    //   643: iconst_0
    //   644: istore 6
    //   646: iload 12
    //   648: istore 8
    //   650: goto -295 -> 355
    //   653: astore_1
    //   654: iload 13
    //   656: istore 6
    //   658: iload 10
    //   660: istore 5
    //   662: iload 5
    //   664: istore 7
    //   666: iload 6
    //   668: istore 9
    //   670: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   673: ifeq +22 -> 695
    //   676: iload 5
    //   678: istore 7
    //   680: iload 6
    //   682: istore 9
    //   684: ldc_w 726
    //   687: iconst_2
    //   688: ldc_w 3417
    //   691: aload_1
    //   692: invokestatic 208	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   695: iload 5
    //   697: istore 7
    //   699: iload 6
    //   701: istore 9
    //   703: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   706: ifeq -290 -> 416
    //   709: ldc_w 726
    //   712: iconst_2
    //   713: new 20	java/lang/StringBuilder
    //   716: dup
    //   717: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   720: ldc_w 3394
    //   723: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   726: iload 5
    //   728: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   731: ldc_w 3396
    //   734: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   737: iload 6
    //   739: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   742: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   745: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   748: iload 5
    //   750: istore 7
    //   752: iload 6
    //   754: istore 9
    //   756: goto -340 -> 416
    //   759: astore_1
    //   760: iload 7
    //   762: istore 5
    //   764: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   767: ifeq +42 -> 809
    //   770: ldc_w 726
    //   773: iconst_2
    //   774: new 20	java/lang/StringBuilder
    //   777: dup
    //   778: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   781: ldc_w 3394
    //   784: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   787: iload 5
    //   789: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   792: ldc_w 3396
    //   795: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   798: iload 9
    //   800: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   803: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   806: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   809: aload_1
    //   810: athrow
    //   811: astore_1
    //   812: iload 6
    //   814: istore 9
    //   816: goto -52 -> 764
    //   819: astore_1
    //   820: iconst_1
    //   821: istore 5
    //   823: iload 6
    //   825: istore 9
    //   827: goto -63 -> 764
    //   830: astore_1
    //   831: goto -169 -> 662
    //   834: astore_1
    //   835: iconst_1
    //   836: istore 5
    //   838: goto -176 -> 662
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	841	0	this	anri
    //   0	841	1	paramToServiceMsg	ToServiceMsg
    //   0	841	2	paramFromServiceMsg	FromServiceMsg
    //   0	841	3	paramObject	Object
    //   250	285	4	i	int
    //   24	813	5	bool1	boolean
    //   62	762	6	bool2	boolean
    //   79	682	7	bool3	boolean
    //   66	583	8	bool4	boolean
    //   83	743	9	bool5	boolean
    //   75	584	10	bool6	boolean
    //   1	539	11	bool7	boolean
    //   10	637	12	bool8	boolean
    //   4	651	13	bool9	boolean
    //   7	503	14	bool10	boolean
    //   255	15	15	l	long
    // Exception table:
    //   from	to	target	type
    //   85	106	653	java/lang/Exception
    //   122	132	653	java/lang/Exception
    //   168	178	653	java/lang/Exception
    //   198	208	653	java/lang/Exception
    //   220	234	653	java/lang/Exception
    //   246	252	653	java/lang/Exception
    //   283	288	653	java/lang/Exception
    //   308	322	653	java/lang/Exception
    //   334	340	653	java/lang/Exception
    //   454	460	653	java/lang/Exception
    //   478	483	653	java/lang/Exception
    //   495	501	653	java/lang/Exception
    //   513	520	653	java/lang/Exception
    //   85	106	759	finally
    //   122	132	759	finally
    //   168	178	759	finally
    //   198	208	759	finally
    //   220	234	759	finally
    //   246	252	759	finally
    //   283	288	759	finally
    //   308	322	759	finally
    //   334	340	759	finally
    //   454	460	759	finally
    //   478	483	759	finally
    //   495	501	759	finally
    //   513	520	759	finally
    //   670	676	759	finally
    //   684	695	759	finally
    //   528	534	811	finally
    //   560	612	819	finally
    //   612	637	819	finally
    //   528	534	830	java/lang/Exception
    //   560	612	834	java/lang/Exception
    //   612	637	834	java/lang/Exception
  }
  
  private void ak(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
            localObject = new azrs();
            ((azrs)localObject).jdField_a_of_type_Int = paramObject.uint32_idx.get();
            ((azrs)localObject).jdField_c_of_type_JavaLangString = paramObject.str_department_id.get();
            ((azrs)localObject).jdField_d_of_type_JavaLangString = paramObject.str_department_name.get();
            ((azrs)localObject).jdField_a_of_type_JavaLangString = paramObject.str_school_id.get();
            ((azrs)localObject).jdField_b_of_type_JavaLangString = paramObject.str_school_name.get();
            ((azrs)localObject).jdField_b_of_type_Int = paramObject.uint32_category.get();
            ((azrs)localObject).jdField_c_of_type_Int = paramObject.uint32_degree.get();
            ((azrs)localObject).jdField_d_of_type_Int = paramObject.uint32_enrollment_year.get();
            ((azrs)localObject).e = paramObject.uint32_graduation_year.get();
            ((azrs)localObject).f = paramObject.uint32_allow_recommend.get();
            if (paramObject.uint32_hidden_flag.get() == 1)
            {
              bool = true;
              label292:
              ((azrs)localObject).jdField_a_of_type_Boolean = bool;
              if (paramObject.uint32_verify_status.get() != 2) {
                break label336;
              }
            }
            label336:
            for (boolean bool = true;; bool = false)
            {
              ((azrs)localObject).jdField_b_of_type_Boolean = bool;
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
      ((aqjm)this.app.getManager(QQManagerFactory.BUSINESS_CARD_MANAGER)).a(paramToServiceMsg);
      notifyUI(101, true, new Object[] { Long.valueOf(l), paramToServiceMsg });
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("CardHandler", 2, "handleGetEducationList failed result:" + i);
    }
    notifyUI(101, false, new Object[] { Long.valueOf(l), null });
  }
  
  private void al(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool3 = true;
    boolean bool1;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      paramFromServiceMsg = paramToServiceMsg.extraData.getString("reqUin", "");
      paramToServiceMsg = this.app.getCurrentUin();
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "handleGetSelfTroopHonorSetting success=" + bool1 + " reqUin:" + paramFromServiceMsg + "  uin:" + paramToServiceMsg);
      }
      if (!bool1) {}
    }
    for (;;)
    {
      try
      {
        if (TextUtils.equals(paramToServiceMsg, paramFromServiceMsg))
        {
          paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
          if (paramFromServiceMsg.uint32_result.get() != 0) {
            break label458;
          }
          bool1 = true;
          if (QLog.isColorLevel()) {
            QLog.d("Q.profilecard.", 2, "handleGetSelfTroopHonorSetting result=" + bool1);
          }
          if ((bool1) && (paramFromServiceMsg.bytes_bodybuffer.has()) && (paramFromServiceMsg.bytes_bodybuffer.get() != null))
          {
            paramObject = new oidb_0x5eb.RspBody();
            paramObject.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
            if ((paramObject.rpt_msg_uin_data.has()) && (paramObject.rpt_msg_uin_data.get().size() > 0))
            {
              bool2 = bool3;
              if (((oidb_0x5eb.UdcUinData)paramObject.rpt_msg_uin_data.get().get(0)).uint32_troophonor_switch.has())
              {
                if (((oidb_0x5eb.UdcUinData)paramObject.rpt_msg_uin_data.get().get(0)).uint32_troophonor_switch.get() != 0) {
                  break label464;
                }
                bool2 = bool3;
              }
              paramFromServiceMsg = (anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
              paramToServiceMsg = paramFromServiceMsg.c(paramToServiceMsg);
              if (paramToServiceMsg.troopHonorSwitch != bool2)
              {
                paramToServiceMsg.troopHonorSwitch = bool2;
                paramFromServiceMsg.a(paramToServiceMsg);
                notifyUI(113, bool1, Boolean.valueOf(paramToServiceMsg.troopHonorSwitch));
                ((aoep)this.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).notifyUI(80, true, null);
              }
              if (QLog.isColorLevel()) {
                QLog.d("Q.profilecard.", 2, "handleGetSelfTroopHonorSetting settingValue=" + bool2);
              }
            }
          }
          else
          {
            notifyUI(113, false, null);
            return;
          }
        }
      }
      catch (Exception paramToServiceMsg)
      {
        notifyUI(113, false, null);
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.", 2, "handleGetSelfTroopHonorSetting ex", paramToServiceMsg);
        }
      }
      return;
      bool1 = false;
      break;
      label458:
      bool1 = false;
      continue;
      label464:
      boolean bool2 = false;
    }
  }
  
  private void am(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
  
  public static int b(Context paramContext)
  {
    return 640;
  }
  
  public static String b(List<String> paramList)
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
  
  private void b(RespSummaryCard paramRespSummaryCard, Card paramCard)
  {
    Object localObject;
    if (paramRespSummaryCard.vExtendCard != null) {
      localObject = new GetExtendFriendInfo.RspBody();
    }
    for (;;)
    {
      try
      {
        ((GetExtendFriendInfo.RspBody)localObject).mergeFrom(paramRespSummaryCard.vExtendCard);
        if (((GetExtendFriendInfo.RspBody)localObject).uint64_uin.has())
        {
          paramRespSummaryCard = Long.valueOf(((GetExtendFriendInfo.RspBody)localObject).uint64_uin.get());
          String.valueOf(paramRespSummaryCard);
          if (!((GetExtendFriendInfo.RspBody)localObject).bytes_declaration.has()) {
            break label584;
          }
          paramRespSummaryCard = ((GetExtendFriendInfo.RspBody)localObject).bytes_declaration.get().toStringUtf8();
          if (!((GetExtendFriendInfo.RspBody)localObject).bytes_voice_url.has()) {
            break label589;
          }
          str = ((GetExtendFriendInfo.RspBody)localObject).bytes_voice_url.get().toStringUtf8();
          if (!((GetExtendFriendInfo.RspBody)localObject).uint32_popularity.has()) {
            break label595;
          }
          i = ((GetExtendFriendInfo.RspBody)localObject).uint32_popularity.get();
          if (!((GetExtendFriendInfo.RspBody)localObject).uint64_update_time.has()) {
            break label600;
          }
          l = ((GetExtendFriendInfo.RspBody)localObject).uint64_update_time.get();
          if (!((GetExtendFriendInfo.RspBody)localObject).uint32_voice_duration.has()) {
            break label606;
          }
          j = ((GetExtendFriendInfo.RspBody)localObject).uint32_voice_duration.get();
          PersonalInfo.ReqBody localReqBody = new PersonalInfo.ReqBody();
          localReqBody.mergeFrom(((GetExtendFriendInfo.RspBody)localObject).bytes_personalization.get().toByteArray());
          int k = localReqBody.fontid.get();
          int m = localReqBody.fonttype.get();
          int n = localReqBody.itemid.get();
          paramCard.fontId = k;
          paramCard.fontType = m;
          paramCard.clothesId = n;
          paramCard.declaration = paramRespSummaryCard;
          paramCard.popularity = i;
          paramCard.voiceUrl = str;
          paramCard.updateTime = l;
          paramCard.extendFriendVoiceDuration = j;
          if ((((GetExtendFriendInfo.RspBody)localObject).rpt_school_info.has()) && (((GetExtendFriendInfo.schoolInfo)((GetExtendFriendInfo.RspBody)localObject).rpt_school_info.get().get(0)).has()))
          {
            localObject = (GetExtendFriendInfo.schoolInfo)((GetExtendFriendInfo.RspBody)localObject).rpt_school_info.get().get(0);
            paramCard.schoolId = ((GetExtendFriendInfo.schoolInfo)localObject).str_school_id.get();
            paramCard.schoolName = ((GetExtendFriendInfo.schoolInfo)localObject).str_school_name.get();
            paramCard.authState = ((GetExtendFriendInfo.schoolInfo)localObject).uint64_state.get();
            paramCard.idx = ((GetExtendFriendInfo.schoolInfo)localObject).uint32_idx.get();
            paramCard.category = ((GetExtendFriendInfo.schoolInfo)localObject).uint32_category.get();
            if (QLog.isColorLevel()) {
              QLog.d("CardHandler", 2, "handleGetSummaryCard extendFriendInfo schoolName = " + paramCard.schoolName + " schoolId = " + paramCard.schoolId + " authState " + paramCard.authState);
            }
            QLog.d("BusinessCard_CardHandler", 1, "handleGetSummaryCard--vExtendCard popularity=" + i + " declaration=" + paramRespSummaryCard + " voiceUrl=" + str + " updateTime=" + l + " duration=" + j + "fontId = " + k + "fontType = " + m + "clothesId= " + n);
            return;
          }
          paramCard.schoolId = null;
          paramCard.schoolName = null;
          paramCard.authState = -1L;
          paramCard.idx = -1;
          paramCard.category = -1;
          continue;
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramRespSummaryCard)
      {
        paramRespSummaryCard.printStackTrace();
      }
      paramRespSummaryCard = null;
      continue;
      label584:
      paramRespSummaryCard = null;
      continue;
      label589:
      String str = null;
      continue;
      label595:
      int i = 0;
      continue;
      label600:
      long l = 0L;
      continue;
      label606:
      int j = 0;
    }
  }
  
  private void b(RespSummaryCard paramRespSummaryCard, Card paramCard, long paramLong)
  {
    if ((0x8 & paramLong) != 0L)
    {
      paramCard.lUserFlag = paramRespSummaryCard.lUserFlag;
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.SummaryCard", 2, "card.lUserFlag = " + paramCard.lUserFlag);
      }
    }
  }
  
  private void b(RespSummaryCard paramRespSummaryCard, String paramString)
  {
    if (paramString.equals(this.app.getCurrentAccountUin()))
    {
      paramString = (axny)this.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
      if (paramString != null)
      {
        paramString.b(paramRespSummaryCard.bSex);
        paramString.a(paramRespSummaryCard.bAge);
      }
    }
  }
  
  private void b(RespSummaryCard paramRespSummaryCard, String paramString, Card paramCard, long paramLong)
  {
    if ((1L & paramLong) != 0L)
    {
      paramCard.strShowName = paramRespSummaryCard.strShowName;
      if (TextUtils.isEmpty(paramCard.strShowName)) {
        paramCard.strShowName = paramString;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.SummaryCard", 2, "strShowName = " + bhbx.b(paramRespSummaryCard.strShowName));
      }
    }
  }
  
  private void b(anrn paramanrn, Bundle paramBundle)
  {
    int i;
    if (paramBundle.containsKey("company"))
    {
      paramanrn.jdField_a_of_type_Long |= 0x40;
      paramanrn.jdField_a_of_type_Int += 1;
      i = paramBundle.getString("company").getBytes().length;
      paramanrn.jdField_b_of_type_Int += i + 4;
      paramanrn.jdField_a_of_type_JavaNioByteBuffer.putShort((short)24008);
      paramanrn.jdField_a_of_type_JavaNioByteBuffer.putShort((short)i);
      paramanrn.jdField_a_of_type_JavaNioByteBuffer.put(paramBundle.getString("company").getBytes());
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "set company | length = " + i + " | company = " + paramBundle.getString("company"));
      }
    }
    if (paramBundle.containsKey("college"))
    {
      paramanrn.jdField_a_of_type_Long |= 0x80;
      paramanrn.jdField_a_of_type_Int += 1;
      i = paramBundle.getString("college").getBytes().length;
      paramanrn.jdField_b_of_type_Int += i + 4;
      paramanrn.jdField_a_of_type_JavaNioByteBuffer.putShort((short)20021);
      paramanrn.jdField_a_of_type_JavaNioByteBuffer.putShort((short)i);
      paramanrn.jdField_a_of_type_JavaNioByteBuffer.put(paramBundle.getString("college").getBytes());
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "set college | length = " + i + " | college = " + paramBundle.getString("college"));
      }
    }
    String[] arrayOfString;
    if (paramBundle.containsKey("location"))
    {
      paramanrn.jdField_a_of_type_Long |= 0x100;
      paramanrn.jdField_a_of_type_Int += 2;
      paramanrn.jdField_b_of_type_Int += 24;
      arrayOfString = paramBundle.getStringArray("location");
      paramanrn.jdField_a_of_type_JavaNioByteBuffer.putShort((short)20032).putShort((short)12).putInt(anrz.a(arrayOfString[0])).putInt(anrz.a(arrayOfString[1])).putInt(anrz.a(arrayOfString[2]));
      paramanrn.jdField_a_of_type_JavaNioByteBuffer.putShort((short)20041).putShort((short)4).putInt(anrz.a(arrayOfString[3]));
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "set location | location = " + arrayOfString.toString() + ", code one = " + arrayOfString[0]);
      }
    }
    if (paramBundle.containsKey("hometown"))
    {
      paramanrn.jdField_a_of_type_Long |= 0x800;
      paramanrn.jdField_a_of_type_Int += 2;
      paramanrn.jdField_b_of_type_Int += 24;
      arrayOfString = paramBundle.getStringArray("hometown");
      paramanrn.jdField_a_of_type_JavaNioByteBuffer.putShort((short)24002).putShort((short)12).putInt(anrz.a(arrayOfString[0])).putInt(anrz.a(arrayOfString[1])).putInt(anrz.a(arrayOfString[2]));
      paramanrn.jdField_a_of_type_JavaNioByteBuffer.putShort((short)20043).putShort((short)4).putInt(anrz.a(arrayOfString[3]));
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "set hometown | hometown = " + arrayOfString.toString());
      }
    }
    if (paramBundle.containsKey("email"))
    {
      paramanrn.jdField_a_of_type_Long |= 0x2000;
      paramanrn.jdField_a_of_type_Int += 1;
      i = paramBundle.getString("email").getBytes().length;
      paramanrn.jdField_b_of_type_Int += i + 4;
      paramanrn.jdField_a_of_type_JavaNioByteBuffer.putShort((short)20011).putShort((short)i).put(paramBundle.getString("email").getBytes());
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "set email | length = " + i + " | email = " + paramBundle.getString("email"));
      }
    }
    if (paramBundle.containsKey("personalNote"))
    {
      paramanrn.jdField_a_of_type_Long |= 0x4000;
      paramanrn.jdField_a_of_type_Int += 1;
      i = paramBundle.getString("personalNote").getBytes().length;
      paramanrn.jdField_b_of_type_Int += i + 4;
      paramanrn.jdField_a_of_type_JavaNioByteBuffer.putShort((short)20019).putShort((short)i).put(paramBundle.getString("personalNote").getBytes());
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "set note | length = " + i + " | note = " + paramBundle.getString("personalNote"));
      }
    }
  }
  
  private void b(Card paramCard, SparseArray<bcra> paramSparseArray)
  {
    boolean bool = false;
    paramSparseArray = (bcra)paramSparseArray.get(19);
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "handleGetAnonymousInfo start vvResp = " + paramSparseArray);
    }
    if ((paramSparseArray != null) && (paramSparseArray.a != null)) {}
    for (;;)
    {
      int i;
      try
      {
        localObject = new oidb_0xec4.RspBody();
        ((oidb_0xec4.RspBody)localObject).mergeFrom(paramSparseArray.a);
        paramSparseArray = new azzk();
        paramSparseArray.jdField_a_of_type_Int = ((oidb_0xec4.RspBody)localObject).uint32_total_quest_num.get();
        paramSparseArray.jdField_a_of_type_Boolean = ((oidb_0xec4.RspBody)localObject).bool_is_fetch_over.get();
        if (!((oidb_0xec4.RspBody)localObject).uint32_ret.has()) {
          break label271;
        }
        i = ((oidb_0xec4.RspBody)localObject).uint32_ret.get();
      }
      catch (Exception paramCard)
      {
        Object localObject;
        long l;
        azzl localazzl;
        QLog.e("CardHandler", 1, "handleGetAnonymousInfo fail.", paramCard);
      }
      paramSparseArray.jdField_b_of_type_Boolean = bool;
      paramSparseArray.jdField_b_of_type_Int = ((oidb_0xec4.RspBody)localObject).uint32_answered_quest_num.get();
      if (((oidb_0xec4.RspBody)localObject).msg_quest.has())
      {
        l = Long.parseLong(paramCard.uin);
        ArrayList localArrayList = new ArrayList();
        localObject = ((oidb_0xec4.RspBody)localObject).msg_quest.get().iterator();
        if (((Iterator)localObject).hasNext())
        {
          localazzl = azzl.a((oidb_0xec4.Quest)((Iterator)localObject).next(), l);
          if ((localazzl == null) || (TextUtils.isEmpty(localazzl.jdField_b_of_type_JavaLangString)) || (TextUtils.isEmpty(localazzl.jdField_c_of_type_JavaLangString))) {
            continue;
          }
          localArrayList.add(localazzl);
          continue;
          return;
          label271:
          i = -1;
        }
        else
        {
          paramSparseArray.jdField_a_of_type_JavaUtilList.addAll(localArrayList);
        }
      }
      else
      {
        if (QLog.isColorLevel())
        {
          int j = paramSparseArray.jdField_a_of_type_Int;
          int k = paramSparseArray.jdField_b_of_type_Int;
          QLog.d("CardHandler", 2, String.format("handleGetAnonymousInfo total=%s fetchOver=%s questionSize=%s retCode=%s needForbidEntry=%b answeredCount=%s", new Object[] { Integer.valueOf(j), Boolean.valueOf(paramSparseArray.jdField_a_of_type_Boolean), Integer.valueOf(paramSparseArray.jdField_a_of_type_JavaUtilList.size()), Integer.valueOf(i), Boolean.valueOf(bool), Integer.valueOf(k) }));
        }
        paramCard.mAnonymousAnswer = paramSparseArray;
        return;
      }
      if (i == 10001) {
        bool = true;
      }
    }
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
      r(paramToServiceMsg, paramFromServiceMsg, paramObject, paramBundle);
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
        n(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x491_100".equals(str))
      {
        o(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("SQQzoneSvc.getCover".equals(str))
      {
        r(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("SQQzoneSvc.getPhotoWall".equals(str))
      {
        s(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("SQQzoneSvc.delPhotoWall".equals(str))
      {
        t(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x480_9".equals(str))
      {
        m(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x4ff_9".equals(str))
      {
        l(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0x66b".equals(str));
    a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  private void b(ByteBuffer paramByteBuffer, short paramShort1, short paramShort2, Long paramLong, Card paramCard)
  {
    boolean bool1 = false;
    boolean bool3 = true;
    boolean bool2 = true;
    switch (paramShort1)
    {
    }
    short s;
    do
    {
      do
      {
        int i;
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                paramShort1 = paramByteBuffer.getShort();
                paramShort2 = this.app.getPreferences().getInt("nearby_people_profile_ok_new", -1);
              } while ((paramShort2 == paramShort1) || (paramShort2 == 1));
              this.app.getPreferences().edit().putInt("nearby_people_profile_ok_new", paramShort1).commit();
              return;
              paramShort1 = paramByteBuffer.getShort();
              paramShort2 = ((Integer)axqc.a(this.app.getAccount(), "nearby_people_avatar_upload_ok", Integer.valueOf(-1))).intValue();
            } while ((paramShort2 == paramShort1) || (paramShort2 == 1));
            axqc.a(this.app.getAccount(), "nearby_people_avatar_upload_ok", Integer.valueOf(paramShort1));
            return;
            paramShort1 = paramByteBuffer.getShort();
            paramByteBuffer = this.app.getAccount();
            if (paramShort1 == 1) {
              bool1 = true;
            }
            axqc.a(paramByteBuffer, "nearby_need_show_guide", Boolean.valueOf(bool1));
            return;
            paramShort1 = paramByteBuffer.getShort();
            paramByteBuffer = this.app.getAccount();
            if (paramShort1 == 1) {}
            for (bool1 = bool2;; bool1 = false)
            {
              axqc.a(paramByteBuffer, "is_nearby_novice", Boolean.valueOf(bool1));
              return;
            }
          } while (paramByteBuffer.getShort() != 1);
          this.app.getNearbyProxy().b();
          return;
          if (paramByteBuffer.getShort() == 0) {}
          for (paramShort1 = 1;; paramShort1 = 0)
          {
            paramShort2 = this.app.readCallTabStateVal(4);
            i = this.app.readCallTabStateVal(0);
            if (i != 0) {
              break;
            }
            paramByteBuffer = new Integer[7];
            paramByteBuffer[3] = Integer.valueOf(paramShort1);
            this.app.writeCallTabStateVal(paramByteBuffer);
            return;
          }
        } while ((i != 1) || (paramShort1 == paramShort2));
        bool1 = bool3;
        if (paramShort2 == 0) {
          bool1 = false;
        }
        b(bool1, false);
        return;
        paramShort1 = paramByteBuffer.getShort();
        ((abgm)this.app.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).a(paramShort1);
        return;
        paramShort1 = paramByteBuffer.getShort();
        ((abgm)this.app.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER)).b(paramShort1);
        return;
        paramShort1 = paramByteBuffer.getShort();
        paramByteBuffer = (anzc)this.app.getManager(QQManagerFactory.MESSAGE_ROAM_MANAGER);
      } while (paramByteBuffer == null);
      paramByteBuffer.d(paramShort1);
      return;
      s = paramByteBuffer.getShort();
      paramByteBuffer = (aymd)this.app.getManager(QQManagerFactory.LOCAL_REDTOUCH_MANAGER);
    } while (paramByteBuffer == null);
    paramByteBuffer.a(s);
  }
  
  /* Error */
  private boolean b(Card paramCard, SparseArray<bcra> paramSparseArray)
  {
    // Byte code:
    //   0: aload_2
    //   1: bipush 16
    //   3: invokevirtual 2056	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   6: checkcast 2058	bcra
    //   9: astore 5
    //   11: aload 5
    //   13: ifnull +859 -> 872
    //   16: aload 5
    //   18: getfield 2060	bcra:a	[B
    //   21: ifnull +851 -> 872
    //   24: new 2125	com/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp
    //   27: dup
    //   28: invokespecial 3875	com/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp:<init>	()V
    //   31: astore_2
    //   32: aload_2
    //   33: aload 5
    //   35: getfield 2060	bcra:a	[B
    //   38: invokevirtual 3876	com/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   41: pop
    //   42: aload_2
    //   43: getfield 3879	com/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp:iRetCode	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   46: invokevirtual 395	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   49: ifne +767 -> 816
    //   52: aload_2
    //   53: getfield 3882	com/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp:lhLogoLv	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   56: invokevirtual 3883	com/tencent/mobileqq/pb/PBInt32Field:has	()Z
    //   59: ifeq +14 -> 73
    //   62: aload_1
    //   63: aload_2
    //   64: getfield 3882	com/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp:lhLogoLv	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   67: invokevirtual 395	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   70: putfield 3886	com/tencent/mobileqq/data/Card:lhLevel	I
    //   73: aload_0
    //   74: aload_1
    //   75: aload_2
    //   76: invokespecial 3888	anri:a	(Lcom/tencent/mobileqq/data/Card;Lcom/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp;)V
    //   79: aload_2
    //   80: getfield 2163	com/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp:stPrivilegeRsp	Lcom/tencent/pb/profilecard/VaProfileGate$PrivilegeBaseInfoRsp;
    //   83: astore 5
    //   85: aload_2
    //   86: getfield 3892	com/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp:stGiftRsp	Lcom/tencent/pb/profilecard/VaProfileGate$GetGiftListRsp;
    //   89: astore 6
    //   91: iconst_0
    //   92: istore_3
    //   93: iload_3
    //   94: aload_2
    //   95: getfield 3895	com/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp:rpt_task_item	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   98: invokevirtual 167	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   101: if_icmpge +37 -> 138
    //   104: aload_2
    //   105: getfield 3895	com/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp:rpt_task_item	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   108: iload_3
    //   109: invokevirtual 170	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   112: checkcast 3897	com/tencent/pb/profilecard/VaProfileGate$CommTaskInfo
    //   115: astore 7
    //   117: iconst_4
    //   118: aload 7
    //   120: getfield 3900	com/tencent/pb/profilecard/VaProfileGate$CommTaskInfo:uint32_appid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   123: invokevirtual 133	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   126: if_icmpne +758 -> 884
    //   129: aload 7
    //   131: aload_1
    //   132: invokestatic 3905	aztm:a	(Lcom/tencent/pb/profilecard/VaProfileGate$CommTaskInfo;Lcom/tencent/mobileqq/data/Card;)V
    //   135: goto +749 -> 884
    //   138: aload_1
    //   139: aload 6
    //   141: getfield 3910	com/tencent/pb/profilecard/VaProfileGate$GetGiftListRsp:desc	Lcom/tencent/mobileqq/pb/PBStringField;
    //   144: invokevirtual 897	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   147: putfield 3913	com/tencent/mobileqq/data/Card:presentDesc	Ljava/lang/String;
    //   150: aload_1
    //   151: aload 6
    //   153: getfield 3916	com/tencent/pb/profilecard/VaProfileGate$GetGiftListRsp:custom_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   156: invokevirtual 897	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   159: putfield 3919	com/tencent/mobileqq/data/Card:presentCustourl	Ljava/lang/String;
    //   162: aload_1
    //   163: aload 6
    //   165: getfield 3922	com/tencent/pb/profilecard/VaProfileGate$GetGiftListRsp:is_on	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   168: invokevirtual 2110	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   171: putfield 3925	com/tencent/mobileqq/data/Card:presentSwitch	Z
    //   174: aload_1
    //   175: aload 6
    //   177: getfield 3929	com/tencent/pb/profilecard/VaProfileGate$GetGiftListRsp:gift_url	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   180: invokevirtual 3932	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   183: putfield 3935	com/tencent/mobileqq/data/Card:presentUrl	Ljava/util/List;
    //   186: aload 6
    //   188: getfield 3922	com/tencent/pb/profilecard/VaProfileGate$GetGiftListRsp:is_on	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   191: invokevirtual 2110	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   194: ifeq +152 -> 346
    //   197: aload_0
    //   198: getfield 229	anri:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   201: ldc_w 256
    //   204: ldc_w 256
    //   207: ldc_w 256
    //   210: ldc_w 3937
    //   213: ldc_w 3937
    //   216: iconst_0
    //   217: iconst_0
    //   218: ldc_w 256
    //   221: ldc_w 256
    //   224: ldc_w 256
    //   227: ldc_w 256
    //   230: invokestatic 3942	bdla:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   233: aload_1
    //   234: getfield 3935	com/tencent/mobileqq/data/Card:presentUrl	Ljava/util/List;
    //   237: invokeinterface 404 1 0
    //   242: ifle +173 -> 415
    //   245: aload_1
    //   246: iconst_1
    //   247: putfield 3945	com/tencent/mobileqq/data/Card:showPresent	Z
    //   250: aload_0
    //   251: aload_1
    //   252: aload_2
    //   253: aload 5
    //   255: invokespecial 3947	anri:a	(Lcom/tencent/mobileqq/data/Card;Lcom/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp;Lcom/tencent/pb/profilecard/VaProfileGate$PrivilegeBaseInfoRsp;)V
    //   258: aload_2
    //   259: getfield 3950	com/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp:rpt_oidb_flag	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   262: invokevirtual 864	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   265: ifeq +407 -> 672
    //   268: aload_2
    //   269: getfield 3950	com/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp:rpt_oidb_flag	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   272: invokevirtual 401	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   275: astore 6
    //   277: iconst_0
    //   278: istore_3
    //   279: iload_3
    //   280: aload 6
    //   282: invokeinterface 404 1 0
    //   287: if_icmpge +385 -> 672
    //   290: aload 6
    //   292: iload_3
    //   293: invokeinterface 406 2 0
    //   298: checkcast 3952	com/tencent/pb/profilecard/VaProfileGate$OidbFlagInfo
    //   301: astore 7
    //   303: aload 7
    //   305: getfield 3955	com/tencent/pb/profilecard/VaProfileGate$OidbFlagInfo:uint32_fieled	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   308: invokevirtual 133	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   311: ldc_w 3956
    //   314: if_icmpne +142 -> 456
    //   317: aload 7
    //   319: getfield 3959	com/tencent/pb/profilecard/VaProfileGate$OidbFlagInfo:byets_value	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   322: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   325: invokevirtual 2174	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   328: astore 7
    //   330: aload_1
    //   331: aload 7
    //   333: invokestatic 3962	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   336: putfield 3965	com/tencent/mobileqq/data/Card:mQQLevelType	I
    //   339: iload_3
    //   340: iconst_1
    //   341: iadd
    //   342: istore_3
    //   343: goto -64 -> 279
    //   346: aload_0
    //   347: getfield 229	anri:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   350: ldc_w 256
    //   353: ldc_w 256
    //   356: ldc_w 256
    //   359: ldc_w 3967
    //   362: ldc_w 3967
    //   365: iconst_0
    //   366: iconst_0
    //   367: ldc_w 256
    //   370: ldc_w 256
    //   373: ldc_w 256
    //   376: ldc_w 256
    //   379: invokestatic 3942	bdla:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   382: goto -149 -> 233
    //   385: astore_1
    //   386: ldc_w 2221
    //   389: iconst_1
    //   390: new 20	java/lang/StringBuilder
    //   393: dup
    //   394: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   397: ldc_w 3969
    //   400: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: aload_1
    //   404: invokevirtual 2053	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   407: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   410: invokestatic 115	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   413: iconst_0
    //   414: ireturn
    //   415: aload_1
    //   416: iconst_0
    //   417: putfield 3945	com/tencent/mobileqq/data/Card:showPresent	Z
    //   420: goto -170 -> 250
    //   423: astore 8
    //   425: ldc_w 2221
    //   428: iconst_2
    //   429: new 20	java/lang/StringBuilder
    //   432: dup
    //   433: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   436: ldc_w 3971
    //   439: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: aload 7
    //   444: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   450: invokestatic 115	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   453: goto -114 -> 339
    //   456: aload 7
    //   458: getfield 3955	com/tencent/pb/profilecard/VaProfileGate$OidbFlagInfo:uint32_fieled	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   461: invokevirtual 133	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   464: ldc_w 3972
    //   467: if_icmpne +61 -> 528
    //   470: aload 7
    //   472: getfield 3959	com/tencent/pb/profilecard/VaProfileGate$OidbFlagInfo:byets_value	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   475: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   478: invokevirtual 2174	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   481: astore 7
    //   483: aload_1
    //   484: aload 7
    //   486: invokestatic 3975	java/lang/Short:parseShort	(Ljava/lang/String;)S
    //   489: putfield 2783	com/tencent/mobileqq/data/Card:switch_musicbox	S
    //   492: goto -153 -> 339
    //   495: astore 8
    //   497: ldc_w 2221
    //   500: iconst_2
    //   501: new 20	java/lang/StringBuilder
    //   504: dup
    //   505: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   508: ldc_w 3977
    //   511: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   514: aload 7
    //   516: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   519: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   522: invokestatic 115	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   525: goto -186 -> 339
    //   528: aload 7
    //   530: getfield 3955	com/tencent/pb/profilecard/VaProfileGate$OidbFlagInfo:uint32_fieled	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   533: invokevirtual 133	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   536: ldc_w 3978
    //   539: if_icmpne +61 -> 600
    //   542: aload 7
    //   544: getfield 3959	com/tencent/pb/profilecard/VaProfileGate$OidbFlagInfo:byets_value	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   547: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   550: invokevirtual 2174	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   553: astore 7
    //   555: aload_1
    //   556: aload 7
    //   558: invokestatic 3975	java/lang/Short:parseShort	(Ljava/lang/String;)S
    //   561: putfield 1612	com/tencent/mobileqq/data/Card:nameplateVipType	I
    //   564: goto -225 -> 339
    //   567: astore 8
    //   569: ldc_w 2221
    //   572: iconst_2
    //   573: new 20	java/lang/StringBuilder
    //   576: dup
    //   577: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   580: ldc_w 3980
    //   583: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: aload 7
    //   588: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   594: invokestatic 115	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   597: goto -258 -> 339
    //   600: aload 7
    //   602: getfield 3955	com/tencent/pb/profilecard/VaProfileGate$OidbFlagInfo:uint32_fieled	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   605: invokevirtual 133	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   608: ldc_w 3981
    //   611: if_icmpne -272 -> 339
    //   614: aload 7
    //   616: getfield 3959	com/tencent/pb/profilecard/VaProfileGate$OidbFlagInfo:byets_value	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   619: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   622: invokevirtual 2174	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   625: astore 7
    //   627: aload_1
    //   628: aload 7
    //   630: invokestatic 3975	java/lang/Short:parseShort	(Ljava/lang/String;)S
    //   633: putfield 1616	com/tencent/mobileqq/data/Card:grayNameplateFlag	I
    //   636: goto -297 -> 339
    //   639: astore 8
    //   641: ldc_w 2221
    //   644: iconst_2
    //   645: new 20	java/lang/StringBuilder
    //   648: dup
    //   649: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   652: ldc_w 3983
    //   655: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   658: aload 7
    //   660: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   663: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   666: invokestatic 115	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   669: goto -330 -> 339
    //   672: aload_2
    //   673: getfield 3987	com/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp:st_vip_care	Lcom/tencent/pb/profilecard/VaProfileGate$GetVipCareRsp;
    //   676: invokevirtual 3990	com/tencent/pb/profilecard/VaProfileGate$GetVipCareRsp:has	()Z
    //   679: ifeq +65 -> 744
    //   682: aload_2
    //   683: getfield 3987	com/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp:st_vip_care	Lcom/tencent/pb/profilecard/VaProfileGate$GetVipCareRsp;
    //   686: invokevirtual 3991	com/tencent/pb/profilecard/VaProfileGate$GetVipCareRsp:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   689: checkcast 3989	com/tencent/pb/profilecard/VaProfileGate$GetVipCareRsp
    //   692: astore 6
    //   694: aload 6
    //   696: getfield 3994	com/tencent/pb/profilecard/VaProfileGate$GetVipCareRsp:uint32_buss	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   699: invokevirtual 133	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   702: istore_3
    //   703: aload 6
    //   705: getfield 3997	com/tencent/pb/profilecard/VaProfileGate$GetVipCareRsp:uint32_notice	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   708: invokevirtual 133	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   711: istore 4
    //   713: iload_3
    //   714: ifeq +30 -> 744
    //   717: iload 4
    //   719: ifeq +25 -> 744
    //   722: aload_0
    //   723: getfield 229	anri:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   726: getstatic 2000	com/tencent/mobileqq/app/QQManagerFactory:VAS_EXTENSION_MANAGER	I
    //   729: invokevirtual 241	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   732: checkcast 2002	bhou
    //   735: iload_3
    //   736: iconst_4
    //   737: ishl
    //   738: iload 4
    //   740: ior
    //   741: invokevirtual 3998	bhou:a	(I)V
    //   744: aload_2
    //   745: getfield 4002	com/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp:qq_value	Lcom/tencent/pb/profilecard/VaProfileGate$QQValueInfoItem;
    //   748: invokevirtual 4005	com/tencent/pb/profilecard/VaProfileGate$QQValueInfoItem:has	()Z
    //   751: ifeq +20 -> 771
    //   754: aload_1
    //   755: getfield 752	com/tencent/mobileqq/data/Card:uin	Ljava/lang/String;
    //   758: aload_2
    //   759: getfield 4002	com/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp:qq_value	Lcom/tencent/pb/profilecard/VaProfileGate$QQValueInfoItem;
    //   762: invokevirtual 4006	com/tencent/pb/profilecard/VaProfileGate$QQValueInfoItem:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   765: checkcast 4004	com/tencent/pb/profilecard/VaProfileGate$QQValueInfoItem
    //   768: invokestatic 4011	bibb:a	(Ljava/lang/String;Lcom/tencent/pb/profilecard/VaProfileGate$QQValueInfoItem;)V
    //   771: aload_2
    //   772: getfield 2163	com/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp:stPrivilegeRsp	Lcom/tencent/pb/profilecard/VaProfileGate$PrivilegeBaseInfoRsp;
    //   775: invokevirtual 2166	com/tencent/pb/profilecard/VaProfileGate$PrivilegeBaseInfoRsp:has	()Z
    //   778: ifne +15 -> 793
    //   781: ldc_w 2221
    //   784: iconst_1
    //   785: ldc_w 4013
    //   788: invokestatic 115	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   791: iconst_0
    //   792: ireturn
    //   793: aload 5
    //   795: getfield 2169	com/tencent/pb/profilecard/VaProfileGate$PrivilegeBaseInfoRsp:uIsGrayUsr	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   798: invokevirtual 133	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   801: ifne +69 -> 870
    //   804: ldc_w 2221
    //   807: iconst_1
    //   808: ldc_w 4015
    //   811: invokestatic 115	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   814: iconst_0
    //   815: ireturn
    //   816: ldc_w 2221
    //   819: iconst_1
    //   820: new 20	java/lang/StringBuilder
    //   823: dup
    //   824: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   827: ldc_w 4017
    //   830: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   833: aload_2
    //   834: getfield 3879	com/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp:iRetCode	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   837: invokevirtual 395	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   840: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   843: ldc_w 4019
    //   846: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   849: aload_2
    //   850: getfield 4022	com/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp:sRetMsg	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   853: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   856: invokevirtual 2174	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   859: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   862: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   865: invokestatic 115	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   868: iconst_0
    //   869: ireturn
    //   870: iconst_1
    //   871: ireturn
    //   872: ldc_w 2221
    //   875: iconst_1
    //   876: ldc_w 4024
    //   879: invokestatic 115	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   882: iconst_0
    //   883: ireturn
    //   884: iload_3
    //   885: iconst_1
    //   886: iadd
    //   887: istore_3
    //   888: goto -795 -> 93
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	891	0	this	anri
    //   0	891	1	paramCard	Card
    //   0	891	2	paramSparseArray	SparseArray<bcra>
    //   92	796	3	i	int
    //   711	30	4	j	int
    //   9	785	5	localObject1	Object
    //   89	615	6	localObject2	Object
    //   115	544	7	localObject3	Object
    //   423	1	8	localNumberFormatException1	NumberFormatException
    //   495	1	8	localNumberFormatException2	NumberFormatException
    //   567	1	8	localNumberFormatException3	NumberFormatException
    //   639	1	8	localNumberFormatException4	NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   32	73	385	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   73	91	385	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   93	135	385	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   138	233	385	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   233	250	385	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   250	277	385	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   279	330	385	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   330	339	385	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   346	382	385	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   415	420	385	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   425	453	385	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   456	483	385	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   483	492	385	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   497	525	385	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   528	555	385	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   555	564	385	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   569	597	385	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   600	627	385	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   627	636	385	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   641	669	385	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   672	713	385	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   722	744	385	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   744	771	385	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   771	791	385	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   793	814	385	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   816	868	385	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   330	339	423	java/lang/NumberFormatException
    //   483	492	495	java/lang/NumberFormatException
    //   555	564	567	java/lang/NumberFormatException
    //   627	636	639	java/lang/NumberFormatException
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
  
  private void c(RespSummaryCard paramRespSummaryCard, Card paramCard)
  {
    if (paramRespSummaryCard.stAddFrdSrcInfo != null)
    {
      paramCard.addSrcName = paramRespSummaryCard.stAddFrdSrcInfo.strSrcName;
      paramCard.addSrcId = paramRespSummaryCard.stAddFrdSrcInfo.uSrcId;
      paramCard.addSubSrcId = paramRespSummaryCard.stAddFrdSrcInfo.uSubSrcId;
    }
    if (paramRespSummaryCard.stBindPhoneInfo != null) {
      paramCard.bindPhoneInfo = paramRespSummaryCard.stBindPhoneInfo.strName;
    }
    if (QLog.isColorLevel()) {
      QLog.d("BusinessCard_CardHandler", 2, "handleGetSummaryCard addSrcName=" + paramCard.addSrcName + " addSrcId=" + paramCard.addSrcId + " addSubSrcId=" + paramCard.addSubSrcId + " bindPhoneInfo=" + paramCard.bindPhoneInfo);
    }
    if (paramRespSummaryCard.vVisitingCardInfo != null) {
      paramCard.bCardInfo = paramRespSummaryCard.vVisitingCardInfo;
    }
  }
  
  private void c(RespSummaryCard paramRespSummaryCard, Card paramCard, long paramLong)
  {
    if ((0x10000 & paramLong) != 0L) {
      paramCard.vLongNickTopicInfo = paramRespSummaryCard.vLongNickTopicInfo;
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if ("OidbSvc.0x5eb_22".equals(str)) {
      k(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      return;
      if ("OidbSvc.0x5eb_15".equals(str))
      {
        j(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x7ba".equals(str))
      {
        i(paramToServiceMsg, paramFromServiceMsg, paramObject, paramBundle);
        return;
      }
      if ("OidbSvc.0x5eb_42092".equals(str))
      {
        H(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5eb_42326".equals(str))
      {
        A(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5eb_40350".equals(str))
      {
        B(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x922".equals(str))
      {
        E(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xe26".equals(str))
      {
        D(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xa28".equals(str))
      {
        C(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x7a8".equals(str))
      {
        ab(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xac6".equals(str))
      {
        ac(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xc33_42220".equals(str))
      {
        ad(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xcd5".equals(str))
      {
        i(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xd8a".equals(str))
      {
        ah(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0xd2d".equals(str))
      {
        ak(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x4ff_42315".equals(str))
      {
        ai(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5eb_15(2)".equals(str))
      {
        O(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0xe5f_2".equals(str));
    am(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  private void c(String paramString, List<CardProfile> paramList)
  {
    b(paramString, paramList);
  }
  
  private void c(ByteBuffer paramByteBuffer, short paramShort1, short paramShort2, Long paramLong, Card paramCard)
  {
    boolean bool4 = true;
    boolean bool5 = true;
    boolean bool1 = true;
    boolean bool2 = true;
    boolean bool6 = true;
    boolean bool3 = true;
    switch (paramShort1)
    {
    default: 
    case 27055: 
    case -25042: 
    case -25181: 
    case 27034: 
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
                  paramShort1 = paramByteBuffer.getInt();
                } while (!String.valueOf(paramLong).equals(this.app.getCurrentAccountUin()));
                ((aocy)this.app.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a(paramShort1, false);
                return;
              } while (2 != paramShort2);
              paramCard = new byte[paramShort2];
              paramByteBuffer.get(paramCard);
              bool1 = bool3;
              if (bhbx.a(paramCard, 0) == 0) {
                bool1 = false;
              }
            } while (SettingCloneUtil.readValue(this.app.getApplication(), paramLong.toString(), null, "qqsetting_pcactive_key", false) == bool1);
            SettingCloneUtil.writeValue(this.app.getApplication(), paramLong.toString(), null, "qqsetting_pcactive_key", bool1);
            paramByteBuffer = new Intent("com.tencent.mobileqq.activity.NotifyPushSettingActivity.PCActive");
            paramByteBuffer.putExtra("pcActive", bool1);
            paramByteBuffer.putExtra("uin", paramLong.toString());
            this.app.getApp().sendBroadcast(paramByteBuffer);
            return;
          } while (paramShort2 != 2);
          paramCard = new byte[paramShort2];
          paramByteBuffer.get(paramCard);
          bool1 = bool4;
          if (bhbx.a(paramCard, 0) == 0) {
            bool1 = false;
          }
        } while (SettingCloneUtil.readValue(this.app.getApplication(), paramLong.toString(), null, "qqsetting_hello_live_message", false) == bool1);
        SettingCloneUtil.writeValue(this.app.getApplication(), paramLong.toString(), null, "qqsetting_hello_live_message", bool1);
        paramByteBuffer = new Intent("com.tencent.mobileqq.activity.NotifyPushSettingActivity.HelloLiveMessage");
        paramByteBuffer.putExtra("isHelloLiveMessageEnable", bool1);
        paramByteBuffer.putExtra("uin", paramLong.toString());
        this.app.getApp().sendBroadcast(paramByteBuffer);
        return;
        paramCard = new byte[paramShort2];
        paramByteBuffer.get(paramCard);
        paramByteBuffer = new String(paramCard);
      } while ((TextUtils.isEmpty(paramByteBuffer)) || (!String.valueOf(paramLong).equals(this.app.getCurrentAccountUin())));
      ((anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.app.getCurrentAccountUin(), paramByteBuffer, (byte)-1);
      return;
    case -23753: 
      paramShort1 = paramByteBuffer.getShort();
      paramByteBuffer = this.app;
      if (paramShort1 > 0) {}
      for (bool1 = bool5;; bool1 = false)
      {
        HotChatManager.a(paramByteBuffer, bool1);
        return;
      }
    case -23461: 
      bool2 = aymo.a(this.app);
      if (paramByteBuffer.getShort() != 0) {}
      for (;;)
      {
        paramCard.medalSwitchDisable = bool1;
        paramByteBuffer = BaseApplicationImpl.getApplication().getSharedPreferences("medal_wall_" + paramLong, 4).edit();
        paramByteBuffer.putBoolean("medal_switch_disable", paramCard.medalSwitchDisable);
        paramByteBuffer.commit();
        bool1 = aymo.a(this.app);
        if (bool2 == bool1) {
          break;
        }
        aymo.a(this.app, bool1);
        return;
        bool1 = false;
      }
    case -23282: 
      bool2 = paramCard.strangerInviteMeGroupOpen;
      if (paramByteBuffer.getShort() == 0) {}
      for (bool1 = true;; bool1 = false)
      {
        paramCard.strangerInviteMeGroupOpen = bool1;
        bool1 = paramCard.strangerInviteMeGroupOpen;
        if (bool2 == bool1) {
          break;
        }
        notifyUI(95, true, new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
        return;
      }
    case -25155: 
      if (this.app == null) {
        break;
      }
    }
    for (bool1 = axmv.a(this.app.getCurrentUin());; bool1 = false)
    {
      if (paramByteBuffer.getShort() == 1) {}
      while ((bool1 != bool2) && (this.app != null))
      {
        axmv.a(this.app.getCurrentUin(), bool2);
        return;
        bool2 = false;
      }
      if (paramByteBuffer.getShort() == 0) {}
      for (bool1 = bool6;; bool1 = false)
      {
        bdxj.a(this.app, bool1);
        return;
      }
    }
  }
  
  private boolean c()
  {
    SharedPreferences localSharedPreferences = this.app.getPreferences();
    long l1 = localSharedPreferences.getLong(this.app.getCurrentUin() + "sign_in_operation_time_stamp", 0L);
    long l2 = localSharedPreferences.getLong(this.app.getCurrentUin() + "sign_in_operation_time_refresh", 0L) * 1000L;
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
    localSharedPreferences.edit().putLong(this.app.getCurrentUin() + "sign_in_operation_time_stamp", l3).commit();
    return true;
  }
  
  private void d(RespSummaryCard paramRespSummaryCard, Card paramCard)
  {
    int n;
    int i1;
    int j;
    int i;
    label192:
    int k;
    if (paramRespSummaryCard.stMedalWallInfo != null)
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        paramRespSummaryCard.stMedalWallInfo.display((StringBuilder)localObject, 0);
        QLog.d("MedalWallMng", 2, new Object[] { "from summary card medal wall info: ", ((StringBuilder)localObject).toString() });
      }
      paramCard.iMedalCount = paramRespSummaryCard.stMedalWallInfo.iMedalCount;
      boolean bool;
      MedalID localMedalID;
      if (paramRespSummaryCard.stMedalWallInfo.iOpenFlag == 1)
      {
        bool = true;
        paramCard.medalSwitchDisable = bool;
        n = paramRespSummaryCard.stMedalWallInfo.iNewCount;
        i1 = paramRespSummaryCard.stMedalWallInfo.iUpgradeCount;
        paramRespSummaryCard = paramRespSummaryCard.stMedalWallInfo.strPromptParams;
        if (((n <= 0) && (i1 <= 0)) || (TextUtils.isEmpty(paramRespSummaryCard)) || (!bhbx.a(paramCard.uin, this.app.getCurrentAccountUin()))) {
          break label418;
        }
        localObject = ((MedalWallMng)this.app.getManager(QQManagerFactory.MEDAL_WALL_MNG)).a(paramRespSummaryCard);
        if ((localObject == null) || (((ArrayList)localObject).size() <= 0)) {
          break label310;
        }
        localObject = ((ArrayList)localObject).iterator();
        j = 0;
        i = 0;
        do
        {
          m = j;
          k = i;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localMedalID = (MedalID)((Iterator)localObject).next();
        } while (localMedalID == null);
        if ((localMedalID.jdField_b_of_type_Int != 1) && (localMedalID.jdField_b_of_type_Int != 255)) {
          break label277;
        }
        k = j;
        j = i + 1;
      }
      for (i = k;; i = k)
      {
        k = j;
        j = i;
        i = k;
        break label192;
        bool = false;
        break;
        label277:
        if ((localMedalID.jdField_b_of_type_Int != 2) && (localMedalID.jdField_b_of_type_Int != 3)) {
          break label405;
        }
        k = j + 1;
        j = i;
      }
      label310:
      int m = 0;
      k = 0;
      i = m;
      j = k;
      if (QLog.isColorLevel())
      {
        QLog.i("MedalWallMng", 2, String.format(Locale.getDefault(), "summary card server[%d, %d] compute[%d, %d]", new Object[] { Integer.valueOf(n), Integer.valueOf(i1), Integer.valueOf(k), Integer.valueOf(m) }));
        j = k;
        i = m;
      }
    }
    for (;;)
    {
      paramCard.iNewCount = j;
      paramCard.iUpgradeCount = i;
      paramCard.strPromptParams = paramRespSummaryCard;
      return;
      label405:
      k = i;
      i = j;
      j = k;
      break;
      label418:
      i = i1;
      j = n;
    }
  }
  
  private void d(RespSummaryCard paramRespSummaryCard, Card paramCard, long paramLong)
  {
    if ((0x4 & paramLong) != 0L)
    {
      paramCard.vRichSign = paramRespSummaryCard.vRichSign;
      paramCard.lSignModifyTime = paramRespSummaryCard.uSignModifyTime;
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if (paramToServiceMsg.extraData.getBoolean("simpleinfo_pull", false))
    {
      q(paramToServiceMsg, paramFromServiceMsg, paramObject, paramBundle);
      return;
    }
    p(paramToServiceMsg, paramFromServiceMsg, paramObject, paramBundle);
  }
  
  private void d(ByteBuffer paramByteBuffer, short paramShort1, short paramShort2, Long paramLong, Card paramCard)
  {
    boolean bool1;
    switch (paramShort1)
    {
    default: 
      return;
    case -23326: 
      paramShort2 = paramByteBuffer.getShort();
      BaseApplicationImpl.getContext().getSharedPreferences(this.mApp.getCurrentAccountUin(), 0).edit().putInt("invitation_friend_entry", paramShort2).apply();
      return;
    case -23325: 
      paramShort2 = paramByteBuffer.getShort();
      BaseApplicationImpl.getContext().getSharedPreferences(this.mApp.getCurrentAccountUin(), 0).edit().putInt("contacts_invite_friend_entry", paramShort2).apply();
      return;
    case -23366: 
      paramShort1 = paramByteBuffer.getShort();
      paramCard.extendFriendEntryContact = paramShort1;
      bhhr.a(this.mApp.getCurrentAccountUin(), "extend_friend_config_785").edit().putInt("sp_extend_friend_entry_contact", paramShort1).apply();
      return;
    case -23332: 
      if (paramByteBuffer.getShort() == 0) {}
      for (bool1 = true;; bool1 = false)
      {
        paramByteBuffer = this.app.getCurrentUin();
        SettingCloneUtil.writeValue(this.app.getApp(), paramByteBuffer, null, "qqsetting_show_push_message", bool1);
        return;
      }
    case -23370: 
      paramShort2 = paramByteBuffer.getShort();
      paramByteBuffer = this.app.getApp();
      paramLong = paramLong.toString();
      if (paramShort2 != 0) {}
      for (bool1 = true;; bool1 = false)
      {
        arzl.b(paramByteBuffer, paramLong, bool1);
        return;
      }
    case -23312: 
    case -23310: 
    case -23309: 
    case -23308: 
    case -23168: 
    case -23166: 
    case -23158: 
      if (paramByteBuffer.getShort() == 1)
      {
        paramShort2 = 1;
        paramByteBuffer = (awtq)this.app.getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER);
        if (paramShort2 != 0) {
          break label376;
        }
      }
      for (bool1 = true;; bool1 = false)
      {
        paramByteBuffer.a(paramShort1, bool1, false);
        return;
        paramShort2 = 0;
        break;
      }
    case -23161: 
      label376:
      if (paramByteBuffer.getShort() == 2) {}
      for (bool1 = true;; bool1 = false)
      {
        ((awtq)this.app.getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER)).a(paramShort1, bool1, false);
        return;
      }
    }
    boolean bool2;
    if (paramByteBuffer.getShort() == 1)
    {
      bool1 = true;
      bhfx.a(this.app);
      paramByteBuffer = arjw.c();
      bool2 = VipUtils.b(this.app);
      if ((paramByteBuffer.jdField_a_of_type_Int <= 1) || (!bool1) || (bool2)) {
        break label813;
      }
      QLog.e("vip_ptt.CardHandler", 1, "get ptt auto to txt online switch is ture but user is not svip!!");
      bool1 = false;
    }
    label813:
    for (;;)
    {
      if (bool1)
      {
        paramLong = (ardl)aqxe.a().a(442);
        if ((paramLong != null) && (!paramLong.a()))
        {
          QLog.e("vip_ptt.CardHandler", 1, "get ptt auto to txt online switch is ture but config is close!!");
          bool1 = false;
        }
      }
      for (;;)
      {
        long l1 = NetConnInfoCenter.getServerTime();
        paramLong = "businessinfo_ptt_auto_change_text_" + this.app.getCurrentAccountUin();
        paramCard = "businessinfo_ptt_auto_change_time_" + this.app.getCurrentAccountUin();
        String str = "businessinfo_ptt_auto_change_guide_has_show_" + this.app.getCurrentAccountUin();
        SharedPreferences.Editor localEditor = this.app.getApp().getSharedPreferences("check_update_sp_key", 0).edit();
        bool2 = ahdg.d;
        long l2 = ahdg.jdField_a_of_type_Long;
        if (bool1)
        {
          if (!bool2)
          {
            localEditor.putLong(paramCard, l1);
            ahdg.jdField_a_of_type_Long = l1;
          }
          localEditor.putBoolean(str, true);
          ahdg.e = true;
        }
        for (;;)
        {
          localEditor.putBoolean(paramLong, bool1);
          localEditor.apply();
          ahdg.d = bool1;
          QLog.e("vip_ptt.CardHandler", 2, "handleGetDetailInfo autoToText onLine:" + bool1 + ", oldSwitch: " + bool2 + ", time:" + l1 + ", oldTime:" + l2 + " conf.stage:" + paramByteBuffer.jdField_a_of_type_Int);
          return;
          bool1 = false;
          break;
          localEditor.putLong(paramCard, 9223372036854775807L);
        }
      }
    }
  }
  
  private boolean d()
  {
    SharedPreferences localSharedPreferences = this.app.getPreferences();
    long l1 = localSharedPreferences.getLong(this.app.getCurrentUin() + "sign_in_last_get_time", 0L);
    long l2 = localSharedPreferences.getLong(this.app.getCurrentUin() + "sign_in_next_get_time", 0L);
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
    localSharedPreferences.edit().putLong(this.app.getCurrentUin() + "sign_in_last_get_time", l3).commit();
    return true;
  }
  
  private void e(RespSummaryCard paramRespSummaryCard, Card paramCard)
  {
    if (paramRespSummaryCard.vRespCustomLabelInfo != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("CardHandler", 2, "handleGetSummaryCard PersonalityLabel");
      }
      paramRespSummaryCard = PersonalityLabel.convertFromPbBytes(paramRespSummaryCard.vRespCustomLabelInfo);
      byte[] arrayOfByte = PersonalityLabel.convertToBytes(paramRespSummaryCard);
      paramCard.personalityLabel = paramRespSummaryCard;
      paramCard.vPersonalityLabelV2 = arrayOfByte;
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
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
        StatisticCollector.getInstance(this.app.getApp()).collectPerformance(String.valueOf(l2), "profileCardSendFavorite", bool1, 0L, 0L, paramFromServiceMsg, "", false);
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.", 2, String.format("handleFavorite result=%s targetUin=%s iCount=%s", new Object[] { Boolean.valueOf(bool1), Long.valueOf(l1), Integer.valueOf(j) }));
        }
        if ((bool1) && (l1 > 0L))
        {
          paramToServiceMsg = (Card)this.app.getEntityManagerFactory().createEntityManager().find(Card.class, l1);
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
            ((anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(paramToServiceMsg);
          }
          bhby.a(this.app, l1, j);
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
        label558:
        QLog.i("Q.profilecard.", 2, paramToServiceMsg);
      }
    }
    else
    {
      if (paramObject == null) {
        break label634;
      }
    }
    label634:
    for (paramToServiceMsg = "-201";; paramToServiceMsg = "-202")
    {
      paramFromServiceMsg.put("param_FailCode", paramToServiceMsg);
      StatisticCollector.getInstance(this.app.getApp()).collectPerformance(String.valueOf(l2), "profileCardSendFavorite", false, 0L, 0L, paramFromServiceMsg, "", false);
      bool1 = bool2;
      break;
      paramToServiceMsg = "null";
      break label558;
    }
  }
  
  private void f(RespSummaryCard paramRespSummaryCard, Card paramCard)
  {
    ArrayList localArrayList1 = new ArrayList();
    int i;
    Object localObject1;
    int j;
    label60:
    label82:
    int k;
    Object localObject2;
    if ((paramRespSummaryCard.vvRespServicesBigOrder != null) && (paramRespSummaryCard.vvRespServicesBigOrder.size() > 0))
    {
      i = 0;
      if (i < paramRespSummaryCard.vvRespServicesBigOrder.size())
      {
        localObject1 = (byte[])paramRespSummaryCard.vvRespServicesBigOrder.get(i);
        if (localObject1 == null)
        {
          j = 0;
          if (j > 10) {
            break label82;
          }
        }
        do
        {
          i += 1;
          break;
          j = localObject1.length;
          break label60;
          k = (int)PkgTools.getLongData((byte[])localObject1, 1);
          int m = (int)PkgTools.getLongData((byte[])localObject1, 5);
        } while ((k <= 0) || (k + 9 >= j));
        localObject2 = new byte[k];
        PkgTools.copyData((byte[])localObject2, 0, (byte[])localObject1, 9, k);
        localObject1 = new SummaryCardBusiEntry.comm();
      }
    }
    for (;;)
    {
      ArrayList localArrayList2;
      azrq localazrq;
      ArrayList localArrayList3;
      try
      {
        ((SummaryCardBusiEntry.comm)localObject1).mergeFrom((byte[])localObject2);
        j = ((SummaryCardBusiEntry.comm)localObject1).result.get();
        localObject2 = new azrp();
        if (j != 0) {
          break label752;
        }
        ((azrp)localObject2).jdField_a_of_type_JavaLangString = ((SummaryCardBusiEntry.comm)localObject1).msg_rich_display.strName.get();
        ((azrp)localObject2).jdField_b_of_type_JavaLangString = ((SummaryCardBusiEntry.comm)localObject1).msg_rich_display.strServiceUrl.get();
        ((azrp)localObject2).jdField_a_of_type_Int = ((SummaryCardBusiEntry.comm)localObject1).service.get();
        localArrayList2 = new ArrayList();
        j = 0;
        if (j >= ((SummaryCardBusiEntry.comm)localObject1).msg_rich_display.rptUiList.size()) {
          break label745;
        }
        SummaryCardBusiEntry.ui_info localui_info = (SummaryCardBusiEntry.ui_info)((SummaryCardBusiEntry.comm)localObject1).msg_rich_display.rptUiList.get(j);
        localazrq = new azrq();
        localazrq.jdField_a_of_type_JavaLangString = localui_info.strTitle.get();
        localazrq.jdField_b_of_type_JavaLangString = localui_info.strCoverUrl.get();
        localazrq.jdField_c_of_type_JavaLangString = localui_info.strJmpUrl.get();
        localazrq.jdField_d_of_type_JavaLangString = localui_info.strSubInfo.get();
        localazrq.e = localui_info.strDesc.get();
        localazrq.f = localui_info.strTitleIconUrl.get();
        localazrq.jdField_a_of_type_Long = localui_info.uint64_group_code.get();
        localazrq.jdField_a_of_type_Int = ((azrp)localObject2).jdField_a_of_type_Int;
        if (i == 0)
        {
          if (j == 0) {
            localazrq.jdField_b_of_type_Int = 0;
          }
        }
        else
        {
          if (localui_info.rptGroupTagList.size() <= 0) {
            break label684;
          }
          localArrayList3 = new ArrayList();
          k = 0;
          if (k >= localui_info.rptGroupTagList.size()) {
            break label677;
          }
          SummaryCardBusiEntry.Label localLabel = (SummaryCardBusiEntry.Label)localui_info.rptGroupTagList.get(k);
          azro localazro = new azro();
          localazro.jdField_a_of_type_JavaLangString = localLabel.bytes_name.get().toStringUtf8();
          localazro.jdField_a_of_type_Long = localLabel.uint32_label_type.get();
          localazro.jdField_b_of_type_Long = localLabel.uint32_label_attr.get();
          azrn localazrn = new azrn();
          localazrn.jdField_a_of_type_Long = localLabel.edging_color.uint32_r.get();
          localazrn.jdField_b_of_type_Long = localLabel.edging_color.uint32_g.get();
          localazrn.c = localLabel.edging_color.uint32_b.get();
          localazro.jdField_b_of_type_Azrn = localazrn;
          localazrn = new azrn();
          localazrn.jdField_a_of_type_Long = localLabel.text_color.uint32_r.get();
          localazrn.jdField_b_of_type_Long = localLabel.text_color.uint32_g.get();
          localazrn.c = localLabel.text_color.uint32_b.get();
          localazro.jdField_a_of_type_Azrn = localazrn;
          localArrayList3.add(localazro);
          k += 1;
          continue;
        }
        localazrq.jdField_b_of_type_Int = 1;
        continue;
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      catch (Exception localException) {}
      QLog.i("Q.profilecard.SummaryCard", 2, localException.toString());
      break;
      label677:
      localazrq.jdField_a_of_type_JavaUtilArrayList = localArrayList3;
      label684:
      localArrayList2.add(localazrq);
      if (QLog.isColorLevel())
      {
        QLog.d("Q.profilecard.SummaryCard", 2, String.format("HobbiesEntry Item strTitle=%s serviceType=%s strJmpUrl=%s", new Object[] { localazrq.jdField_a_of_type_JavaLangString, Integer.valueOf(localazrq.jdField_a_of_type_Int), localazrq.jdField_c_of_type_JavaLangString }));
        break label819;
        label745:
        ((azrp)localObject2).jdField_a_of_type_JavaUtilArrayList = localArrayList2;
        label752:
        localArrayList1.add(localObject2);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.profilecard.SummaryCard", 2, String.format("HobbiesEntry strName=%s strServiceType=%s strServiceUrl=%s", new Object[] { ((azrp)localObject2).jdField_a_of_type_JavaLangString, ((azrp)localObject2).jdField_c_of_type_JavaLangString, ((azrp)localObject2).jdField_b_of_type_JavaLangString }));
        break;
        paramCard.saveBigOrderEntrys(localArrayList1);
        return;
      }
      label819:
      j += 1;
    }
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    RespGetFavoriteList localRespGetFavoriteList;
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      paramObject = ((anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).c(paramToServiceMsg.getUin());
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
        b(paramToServiceMsg.getUin(), localArrayList);
        notifyUI(42, true, new Object[] { paramObject, paramBundle, localArrayList });
        break;
        paramToServiceMsg = ((anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).c(paramToServiceMsg.getUin());
        paramBundle.putLong("startMid", -1L);
        notifyUI(42, false, new Object[] { paramToServiceMsg, paramBundle, a(3, 7) });
        return;
      }
      label534:
      paramFromServiceMsg = null;
    }
  }
  
  private void g(RespSummaryCard paramRespSummaryCard, Card paramCard)
  {
    if (paramRespSummaryCard.stDiamonds != null)
    {
      paramRespSummaryCard = paramRespSummaryCard.stDiamonds.getMOpenInfo();
      if (paramRespSummaryCard != null)
      {
        VipOpenInfo localVipOpenInfo = (VipOpenInfo)paramRespSummaryCard.get(Integer.valueOf(101));
        if (localVipOpenInfo.bOpen)
        {
          paramCard.isRedDiamond = true;
          if ((localVipOpenInfo.iVipFlag & 0x1) > 0) {
            paramCard.isSuperRedDiamond = true;
          }
        }
        paramCard.redLevel = localVipOpenInfo.iVipLevel;
        localVipOpenInfo = (VipOpenInfo)paramRespSummaryCard.get(Integer.valueOf(102));
        if (localVipOpenInfo.bOpen)
        {
          paramCard.isYellowDiamond = true;
          if ((localVipOpenInfo.iVipFlag & 0x1) > 0) {
            paramCard.isSuperYellowDiamond = true;
          }
        }
        paramCard.yellowLevel = localVipOpenInfo.iVipLevel;
        paramRespSummaryCard = (VipOpenInfo)paramRespSummaryCard.get(Integer.valueOf(103));
        if (paramRespSummaryCard.bOpen)
        {
          paramCard.isGreenDiamond = true;
          if ((paramRespSummaryCard.iVipFlag & 0x1) > 0) {
            paramCard.isSuperGreenDiamond = true;
          }
        }
        paramCard.greenLevel = paramRespSummaryCard.iVipLevel;
      }
    }
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "[handleReqVoterList] resultCode = " + paramFromServiceMsg.getResultCode());
    }
    RespGetVoterList localRespGetVoterList;
    if (paramFromServiceMsg.getResultCode() == 1000)
    {
      paramObject = ((anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).c(paramToServiceMsg.getUin());
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
        c(paramToServiceMsg.getUin(), localArrayList);
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
        paramToServiceMsg = ((anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).c(paramToServiceMsg.getUin());
        paramBundle.putLong("startMid", -1L);
        notifyUI(6, false, new Object[] { paramToServiceMsg, paramBundle, a(2, 7) });
        return;
      }
      label746:
      paramFromServiceMsg = null;
    }
  }
  
  private void h(RespSummaryCard paramRespSummaryCard, Card paramCard)
  {
    if (paramRespSummaryCard.stCoverInfo != null)
    {
      paramCard.updateCoverData(paramRespSummaryCard.stCoverInfo.vTagInfo);
      if (QLog.isColorLevel())
      {
        QLog.d("CardHandler", 2, "handleGetSummaryCard: coverinfo.size=" + paramCard.vCoverInfo.length);
        paramRespSummaryCard = paramCard.getCoverData(0);
        QLog.d("CardHandler", 2, "handleGetSummaryCard: coverinfo.url=" + paramRespSummaryCard[0]);
      }
    }
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
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
  
  private void i(RespSummaryCard paramRespSummaryCard, Card paramCard)
  {
    if (paramRespSummaryCard.stNowBroadcastInfo != null)
    {
      paramCard.mNowShowFlag = paramRespSummaryCard.stNowBroadcastInfo.iFlag;
      paramCard.mNowShowIconUrl = paramRespSummaryCard.stNowBroadcastInfo.strIconURL;
      paramCard.mNowShowJumpUrl = paramRespSummaryCard.stNowBroadcastInfo.strHrefURL;
      if (paramCard.mNowShowFlag == 1) {
        bdla.b(this.app, "dc00899", "NOW", "", "qq_zlk", "logo_exp", 0, 0, paramCard.uin, "", "", "");
      }
    }
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg.extraData.getBoolean("isGetList", false))
    {
      ae(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    af(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
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
  
  private void j(RespSummaryCard paramRespSummaryCard, Card paramCard)
  {
    paramCard.strQzoneFeedsDesc = paramRespSummaryCard.strQzoneFeedsDesc;
    paramCard.strSpaceName = paramRespSummaryCard.strSpaceName;
    paramCard.strQzoneHeader = paramRespSummaryCard.strQzoneHeader;
    String str1;
    if (paramRespSummaryCard.mapQzoneEx != null)
    {
      str1 = paramRespSummaryCard.strRemark;
      if (TextUtils.isEmpty(paramRespSummaryCard.strRemark)) {
        str1 = (String)paramRespSummaryCard.mapQzoneEx.get("real_name");
      }
      if (!TextUtils.isEmpty(str1))
      {
        String str2 = str1;
        if (paramCard.strQzoneHeader != null)
        {
          str2 = str1;
          if (paramCard.strQzoneHeader.length() > 10)
          {
            str2 = str1;
            if (str1 != null)
            {
              str2 = str1;
              if (str1.length() > 5) {
                str2 = str1.substring(0, 5) + "...";
              }
            }
          }
        }
        paramCard.strQzoneHeader = (str2 + paramCard.strQzoneHeader);
      }
      str1 = (String)paramRespSummaryCard.mapQzoneEx.get("enlarge_qzone");
      if (TextUtils.isEmpty(str1)) {
        break label312;
      }
    }
    for (;;)
    {
      try
      {
        paramCard.enlargeQzonePic = Integer.parseInt(str1);
        str1 = (String)paramRespSummaryCard.mapQzoneEx.get("show_publish_button");
        if (TextUtils.isEmpty(str1)) {
          break label346;
        }
        try
        {
          if (Integer.parseInt(str1) != 1) {
            break label320;
          }
          bool = true;
          paramCard.showPublishButton = bool;
        }
        catch (NumberFormatException localNumberFormatException2)
        {
          boolean bool;
          QLog.w("CardHandler", 1, "show_publish_button is not a integer:", localNumberFormatException2);
          paramCard.showPublishButton = false;
          continue;
        }
        paramCard.vQzoneCoverInfo = paramRespSummaryCard.vQzoneCoverInfo;
        if (!paramCard.isPhotoUseCache())
        {
          paramCard.qzonePhotoList.clear();
          paramRespSummaryCard = paramRespSummaryCard.oLatestPhotos;
          if ((paramRespSummaryCard != null) && (paramRespSummaryCard.vPhotos != null)) {
            paramCard.addQzonePhotoList(paramRespSummaryCard);
          }
        }
        return;
      }
      catch (NumberFormatException localNumberFormatException1)
      {
        QLog.w("CardHandler", 1, "strEnlargQzone is not a integer:", localNumberFormatException1);
        continue;
      }
      label312:
      paramCard.enlargeQzonePic = 0;
      continue;
      label320:
      bool = false;
      continue;
      label346:
      paramCard.showPublishButton = false;
    }
  }
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg.extraData.getBoolean("sendGlobalRingIdRequest", false))
    {
      P(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    Q(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
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
        paramObject = (axnt)this.app.getManager(QQManagerFactory.NEARBY_GENERAL_MANAGER);
        if (l1 != 0L) {
          break label241;
        }
        bool2 = true;
        label61:
        paramObject.b(bool2);
        paramObject = PreferenceManager.getDefaultSharedPreferences(this.app.getApp()).edit();
        String str = this.app.getApplication().getString(2131694745) + this.app.getCurrentAccountUin();
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
  
  private void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg.extraData.getBoolean("uint32_req_medalwall_flag", false)) {
      N(paramToServiceMsg, paramFromServiceMsg, paramObject);
    }
    do
    {
      return;
      if (paramToServiceMsg.extraData.getBoolean("uint32_req_allow", false))
      {
        S(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (paramToServiceMsg.extraData.getBoolean("uint32_do_not_disturb_mode_time", false))
      {
        R(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!paramToServiceMsg.extraData.getBoolean("uint32_troophonor_switch", false));
    al(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  private void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("modify_switch_for_near_people", true);
    SharedPreferences localSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.app.getApp());
    boolean bool1;
    if (paramFromServiceMsg.isSuccess())
    {
      paramObject = (RespSetCardSwitch)paramObject;
      if (bool2) {
        if (paramObject.uCloseNeighborVote == 0L)
        {
          bool1 = true;
          ((axnt)this.app.getManager(QQManagerFactory.NEARBY_GENERAL_MANAGER)).b(bool1);
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
        StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "CMD_REQ_SETCARDSWITCH", paramFromServiceMsg.isSuccess(), 0L, 0L, null, "response");
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
        localSharedPreferences.edit().putBoolean(this.app.getApplication().getString(2131694745) + this.app.getCurrentAccountUin(), bool1).commit();
        break;
      }
      long l = paramToServiceMsg.extraData.getLong("target_value");
      paramObject = this.app;
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
      for (bool1 = ((axnt)this.app.getManager(QQManagerFactory.NEARBY_GENERAL_MANAGER)).b();; bool1 = localSharedPreferences.getBoolean(this.app.getApplication().getString(2131694745) + this.app.getCurrentAccountUin(), false))
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
  
  private void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg.extraData.getBoolean("reqFromCardHandler", false))
    {
      if (paramToServiceMsg.extraData.getBoolean("isSetLoginDays", false)) {
        K(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
    }
    else {
      return;
    }
    if (paramToServiceMsg.extraData.getBoolean("pcActiveState", false))
    {
      v(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramToServiceMsg.extraData.getBoolean("helloLiveMessage", false))
    {
      x(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramToServiceMsg.extraData.getBoolean("isSetActivateFriend", false))
    {
      U(paramToServiceMsg, paramFromServiceMsg, paramObject);
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
      Y(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramToServiceMsg.extraData.getBoolean("isGetAntiLost"))
    {
      X(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramToServiceMsg.extraData.getBoolean("isSetCalReactiveDays", false))
    {
      L(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramToServiceMsg.extraData.getBoolean("isSetBabyQSwitch"))
    {
      W(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramToServiceMsg.extraData.getBoolean("uint32_req_medalwall_flag", false))
    {
      M(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramToServiceMsg.extraData.getBoolean("StrangerInviteToGroup", false))
    {
      ag(paramToServiceMsg, paramFromServiceMsg, paramObject);
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
      G(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramToServiceMsg.extraData.getBoolean("uint32_req_push_notice_flag", false))
    {
      z(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramToServiceMsg.extraData.getBoolean("tempConversationBlocState", false))
    {
      w(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramToServiceMsg.extraData.getBoolean("setPrettyTroopOwnerFlag", false))
    {
      c(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    p(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  private void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
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
    paramBundle = (anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
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
        paramToServiceMsg = paramBundle.b(this.app.getCurrentAccountUin());
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
        paramFromServiceMsg = this.app.getPreferences();
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
      paramFromServiceMsg = new android.util.Pair(Integer.valueOf(paramObject.res), paramObject);
      paramToServiceMsg = null;
      continue;
      label608:
      paramToServiceMsg = paramFromServiceMsg;
      continue;
      notifyUI(41, false, paramBundle.c(this.app.getCurrentAccountUin()));
      bjgx.a().a(paramFromServiceMsg.getServiceCmd(), 100, paramFromServiceMsg.getBusinessFailCode(), this.app.getCurrentAccountUin(), 1000277, anvx.a(2131700948), true);
      return;
      label666:
      paramFromServiceMsg = null;
      continue;
      label671:
      paramFromServiceMsg = null;
      paramToServiceMsg = null;
    }
  }
  
  private void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramToServiceMsg.extraData.getBoolean("reqFromCardHandler", false))
    {
      if (paramToServiceMsg.extraData.getBoolean("isGetLoginDays", false)) {
        I(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
    }
    else {
      return;
    }
    if (paramToServiceMsg.extraData.getBoolean("pcActiveState", false))
    {
      u(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramToServiceMsg.extraData.getBoolean("helloLiveMessage", false))
    {
      y(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramToServiceMsg.extraData.getBoolean("isGetActivateFriend", false))
    {
      T(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramToServiceMsg.extraData.getBoolean("isQidianExt", false))
    {
      Z(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramToServiceMsg.extraData.getBoolean("isGetCalReactive", false))
    {
      J(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramToServiceMsg.extraData.getBoolean("isGetBabyQSwitch", false))
    {
      V(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramToServiceMsg.extraData.getBoolean("isQidianMaster", false))
    {
      aa(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramToServiceMsg.extraData.getBoolean("isGetCommonSwitchFromDetailInfo", false))
    {
      F(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramToServiceMsg.extraData.getBoolean("isOfficeUserFlag", false))
    {
      h(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if (paramToServiceMsg.extraData.getBoolean("setCareBarEnable", false))
    {
      aj(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    q(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  private void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
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
        paramFromServiceMsg = (anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
        paramBundle = paramFromServiceMsg.c(this.app.getCurrentAccountUin());
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
      QLog.e("CardHandler", 2, "-->report MM:cmd=" + paramFromServiceMsg.getServiceCmd() + ",error code=" + paramFromServiceMsg.getBusinessFailCode() + ",uin=" + this.app.getCurrentAccountUin());
    }
    bjgx.a().a(paramFromServiceMsg.getServiceCmd(), 100, paramFromServiceMsg.getBusinessFailCode(), this.app.getCurrentAccountUin(), 1000277, anvx.a(2131700951), true);
  }
  
  private void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
          this.app.setPhoneNumSearchable(bool1, false);
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
        bool1 = this.app.isPhoneNumSearchable(false);
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
  
  private void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if ((paramFromServiceMsg.getResultCode() == 1000) && ((paramObject instanceof SSummaryCardLableRsp))) {}
    Card localCard;
    for (boolean bool = true;; bool = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetLabelLike success : " + bool + ", data : " + paramObject);
      }
      paramBundle = (anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      localCard = paramBundle.c(String.valueOf(paramToServiceMsg.extraData.getLong("destUin")));
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
      QLog.e("CardHandler", 2, "-->report MM:cmd=" + paramFromServiceMsg.getServiceCmd() + ",error code=" + paramFromServiceMsg.getBusinessFailCode() + ",uin=" + this.app.getCurrentAccountUin());
    }
    bjgx.a().a(paramFromServiceMsg.getServiceCmd(), 100, paramFromServiceMsg.getBusinessFailCode(), this.app.getCurrentAccountUin(), 1000277, anvx.a(2131700950), true);
  }
  
  private void o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
          this.app.setPhoneNumSearchable(bool2, false);
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
        bool2 = this.app.isPhoneNumSearchable(false);
        notifyUI(39, bool1, Boolean.valueOf(bool2));
        return;
        bool1 = false;
        break;
        bool1 = false;
        continue;
      }
    }
  }
  
  private void o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramFromServiceMsg = (RespHYMakeFriendsCard)paramObject;
      paramObject = paramToServiceMsg.extraData.getString("friendUin");
      int i = paramToServiceMsg.extraData.getInt("uFaceTimeStamp");
      if (paramFromServiceMsg.stHeader.iReplyCode == 0)
      {
        paramToServiceMsg = (anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
        paramBundle = paramToServiceMsg.c(paramObject);
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
        notifyUI(1, true, paramBundle);
        return;
      }
      if ((3 == paramFromServiceMsg.stHeader.iReplyCode) || (56 == paramFromServiceMsg.stHeader.iReplyCode))
      {
        notifyUI(2, true, paramBundle);
        return;
      }
      notifyUI(1, false, paramBundle);
      return;
    }
    notifyUI(1, false, paramBundle);
  }
  
  private void p(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    anvk localanvk;
    Object localObject1;
    Object localObject2;
    boolean bool3;
    long l;
    label109:
    int i;
    boolean bool2;
    int k;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      bool1 = true;
      localanvk = null;
      localObject1 = null;
      localObject2 = null;
      bool3 = paramToServiceMsg.extraData.getBoolean("key_is_nearby_people_card", false);
      l = paramToServiceMsg.extraData.getLong("fieldFlag", 0L);
      if (!bool1) {}
    }
    else
    {
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_result.has()))
        {
          j = paramFromServiceMsg.uint32_result.get();
          if (j == 0)
          {
            bool1 = true;
            i = j;
            bool2 = bool1;
            paramFromServiceMsg = localObject1;
            k = j;
          }
        }
      }
      catch (Exception paramObject)
      {
        int j;
        label183:
        k = -1000;
        label264:
        paramFromServiceMsg = localanvk;
      }
    }
    try
    {
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = localObject1;
        k = j;
        QLog.d("CardHandler", 2, "handleSetDetailInfo, ret = " + j + ", isNearbyPeopleCard = " + bool3);
        bool2 = bool1;
        i = j;
      }
      if ((i != 0) || (bool3)) {
        break label531;
      }
      paramFromServiceMsg = localObject1;
      k = i;
      localanvk = (anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      paramFromServiceMsg = localObject1;
      k = i;
      paramObject = localanvk.c(this.app.getCurrentAccountUin());
      paramFromServiceMsg = paramObject;
      k = i;
      a(paramToServiceMsg, paramObject, localanvk);
      paramFromServiceMsg = paramObject;
      k = i;
      localanvk.a(paramObject);
      paramToServiceMsg = paramObject;
    }
    catch (Exception paramObject)
    {
      label412:
      break label412;
      label514:
      label520:
      paramToServiceMsg = null;
      break label264;
    }
    if (!bool3) {
      notifyUI(31, bool2, new Object[] { Integer.valueOf(i), paramToServiceMsg });
    }
    if ((!bool2) || (i != 0))
    {
      paramFromServiceMsg = new HashMap();
      paramFromServiceMsg.put("retCode", String.valueOf(i));
      paramFromServiceMsg.put("fieldFlag", String.valueOf(l));
      if (!bool3) {
        break label520;
      }
    }
    for (paramToServiceMsg = "1";; paramToServiceMsg = "0")
    {
      paramFromServiceMsg.put("isNearbyPeopleCard", paramToServiceMsg);
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance("", "profile_set_user_info_result", bool2, 0L, 0L, paramFromServiceMsg, "", false);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label109;
      i = -1000;
      bool2 = false;
      break label183;
      bool1 = false;
      paramToServiceMsg = paramFromServiceMsg;
      i = k;
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break label264;
      }
      QLog.d("CardHandler", 2, "handleGetDetailInfo", paramObject);
      paramToServiceMsg = paramFromServiceMsg;
      i = k;
      bool2 = bool1;
      break label264;
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder().append("setDetailInfo fail : ");
        if (paramFromServiceMsg == null) {
          break label514;
        }
      }
      for (i = paramFromServiceMsg.getResultCode();; i = -1)
      {
        QLog.w("CardHandler", 2, i);
        i = -1000;
        paramToServiceMsg = localObject2;
        bool2 = bool1;
        break;
      }
    }
  }
  
  /* Error */
  private void p(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 100	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: ifeq +339 -> 343
    //   7: aload_3
    //   8: instanceof 1236
    //   11: ifeq +332 -> 343
    //   14: iconst_1
    //   15: istore 6
    //   17: iload 6
    //   19: ifeq +1427 -> 1446
    //   22: aload_0
    //   23: aload_2
    //   24: invokevirtual 5499	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   27: ldc_w 5501
    //   30: new 1298	SummaryCard/RespHead
    //   33: dup
    //   34: invokespecial 5502	SummaryCard/RespHead:<init>	()V
    //   37: invokevirtual 1744	anri:decodePacket	([BLjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   40: checkcast 1298	SummaryCard/RespHead
    //   43: astore 4
    //   45: aload 4
    //   47: ifnull +302 -> 349
    //   50: aload 4
    //   52: getfield 5505	SummaryCard/RespHead:iResult	I
    //   55: istore 5
    //   57: iload 5
    //   59: ifne +290 -> 349
    //   62: iconst_1
    //   63: istore 6
    //   65: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   68: ifeq +37 -> 105
    //   71: ldc 195
    //   73: iconst_2
    //   74: ldc_w 5507
    //   77: iconst_2
    //   78: anewarray 254	java/lang/Object
    //   81: dup
    //   82: iconst_0
    //   83: iload 6
    //   85: invokestatic 180	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   88: aastore
    //   89: dup
    //   90: iconst_1
    //   91: aload_2
    //   92: invokevirtual 107	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   95: invokestatic 86	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   98: aastore
    //   99: invokestatic 1310	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   102: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   105: aload_1
    //   106: getfield 600	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   109: ldc_w 4395
    //   112: invokevirtual 2619	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   115: lstore 7
    //   117: aload_1
    //   118: getfield 600	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   121: ldc_w 2509
    //   124: invokevirtual 730	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   127: astore 13
    //   129: aload_1
    //   130: getfield 600	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   133: ldc_w 2507
    //   136: invokevirtual 1850	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   139: istore 5
    //   141: aload_1
    //   142: getfield 600	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   145: ldc_w 4397
    //   148: invokevirtual 2619	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   151: lstore 9
    //   153: iload 6
    //   155: ifeq +1179 -> 1334
    //   158: aload_0
    //   159: getfield 229	anri:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   162: getstatic 235	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   165: invokevirtual 241	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   168: checkcast 243	anvk
    //   171: astore_2
    //   172: aload_0
    //   173: getfield 229	anri:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   176: getstatic 1224	com/tencent/mobileqq/app/QQManagerFactory:TROOP_MANAGER	I
    //   179: invokevirtual 241	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   182: checkcast 1226	com/tencent/mobileqq/app/TroopManager
    //   185: astore 14
    //   187: aload_3
    //   188: checkcast 1236	SummaryCard/RespSummaryCard
    //   191: astore_3
    //   192: aload_3
    //   193: getfield 5510	SummaryCard/RespSummaryCard:vvRespServices	Ljava/util/ArrayList;
    //   196: invokestatic 5515	com/tencent/mobileqq/service/lbs/BusinessBuff:a	(Ljava/util/ArrayList;)Landroid/util/SparseArray;
    //   199: astore 15
    //   201: lload 7
    //   203: lconst_0
    //   204: lcmp
    //   205: ifgt +188 -> 393
    //   208: iload 5
    //   210: bipush 41
    //   212: if_icmpeq +181 -> 393
    //   215: iload 5
    //   217: bipush 6
    //   219: if_icmpeq +174 -> 393
    //   222: iload 5
    //   224: bipush 45
    //   226: if_icmpeq +167 -> 393
    //   229: aload_2
    //   230: aload 13
    //   232: invokevirtual 5518	anvk:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/ContactCard;
    //   235: astore_1
    //   236: aload_1
    //   237: aload_3
    //   238: getfield 3673	SummaryCard/RespSummaryCard:bAge	B
    //   241: putfield 5521	com/tencent/mobileqq/data/ContactCard:bAge	B
    //   244: aload_1
    //   245: aload_3
    //   246: getfield 3670	SummaryCard/RespSummaryCard:bSex	B
    //   249: putfield 5522	com/tencent/mobileqq/data/ContactCard:bSex	B
    //   252: aload_1
    //   253: aload_3
    //   254: getfield 1258	SummaryCard/RespSummaryCard:strNick	Ljava/lang/String;
    //   257: putfield 5524	com/tencent/mobileqq/data/ContactCard:nickName	Ljava/lang/String;
    //   260: aload_1
    //   261: aload_3
    //   262: getfield 5525	SummaryCard/RespSummaryCard:strProvince	Ljava/lang/String;
    //   265: putfield 5526	com/tencent/mobileqq/data/ContactCard:strProvince	Ljava/lang/String;
    //   268: aload_1
    //   269: aload_3
    //   270: getfield 5527	SummaryCard/RespSummaryCard:strCountry	Ljava/lang/String;
    //   273: putfield 5528	com/tencent/mobileqq/data/ContactCard:strCountry	Ljava/lang/String;
    //   276: aload_1
    //   277: aload_3
    //   278: getfield 5529	SummaryCard/RespSummaryCard:strCity	Ljava/lang/String;
    //   281: putfield 5530	com/tencent/mobileqq/data/ContactCard:strCity	Ljava/lang/String;
    //   284: aload_1
    //   285: aload_3
    //   286: getfield 5533	SummaryCard/RespSummaryCard:strContactName	Ljava/lang/String;
    //   289: putfield 5534	com/tencent/mobileqq/data/ContactCard:strContactName	Ljava/lang/String;
    //   292: aload_3
    //   293: getfield 5537	SummaryCard/RespSummaryCard:iContactNotBindQQ	I
    //   296: iconst_1
    //   297: if_icmpeq +80 -> 377
    //   300: iconst_1
    //   301: istore 6
    //   303: aload_1
    //   304: iload 6
    //   306: putfield 5540	com/tencent/mobileqq/data/ContactCard:bindQQ	Z
    //   309: aload_3
    //   310: getfield 1255	SummaryCard/RespSummaryCard:lUIN	J
    //   313: lconst_0
    //   314: lcmp
    //   315: ifle +68 -> 383
    //   318: aload_1
    //   319: aload_3
    //   320: getfield 1255	SummaryCard/RespSummaryCard:lUIN	J
    //   323: invokestatic 680	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   326: putfield 5541	com/tencent/mobileqq/data/ContactCard:uin	Ljava/lang/String;
    //   329: aload_2
    //   330: aload_1
    //   331: invokevirtual 5544	anvk:a	(Lcom/tencent/mobileqq/data/ContactCard;)Z
    //   334: pop
    //   335: aload_0
    //   336: iconst_1
    //   337: iconst_1
    //   338: aload_1
    //   339: invokevirtual 184	anri:notifyUI	(IZLjava/lang/Object;)V
    //   342: return
    //   343: iconst_0
    //   344: istore 6
    //   346: goto -329 -> 17
    //   349: iconst_0
    //   350: istore 6
    //   352: goto -287 -> 65
    //   355: astore 13
    //   357: aconst_null
    //   358: astore 4
    //   360: ldc 195
    //   362: iconst_1
    //   363: ldc_w 5546
    //   366: aload 13
    //   368: invokestatic 189	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   371: iconst_0
    //   372: istore 6
    //   374: goto -309 -> 65
    //   377: iconst_0
    //   378: istore 6
    //   380: goto -77 -> 303
    //   383: aload_1
    //   384: ldc_w 256
    //   387: putfield 5541	com/tencent/mobileqq/data/ContactCard:uin	Ljava/lang/String;
    //   390: goto -61 -> 329
    //   393: lload 7
    //   395: invokestatic 680	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   398: astore 13
    //   400: aload_2
    //   401: aload 13
    //   403: invokevirtual 735	anvk:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   406: astore 14
    //   408: aload 14
    //   410: aload_3
    //   411: getfield 5547	SummaryCard/RespSummaryCard:iLevel	I
    //   414: putfield 5472	com/tencent/mobileqq/data/Card:iQQLevel	I
    //   417: aload 14
    //   419: aload_3
    //   420: getfield 1258	SummaryCard/RespSummaryCard:strNick	Ljava/lang/String;
    //   423: putfield 1892	com/tencent/mobileqq/data/Card:strNick	Ljava/lang/String;
    //   426: aload 14
    //   428: aload_3
    //   429: getfield 3670	SummaryCard/RespSummaryCard:bSex	B
    //   432: i2s
    //   433: putfield 1909	com/tencent/mobileqq/data/Card:shGender	S
    //   436: aload 14
    //   438: aload_3
    //   439: getfield 5550	SummaryCard/RespSummaryCard:uCurMulType	J
    //   442: putfield 5551	com/tencent/mobileqq/data/Card:uCurMulType	J
    //   445: aload 14
    //   447: aload_3
    //   448: getfield 3673	SummaryCard/RespSummaryCard:bAge	B
    //   451: i2s
    //   452: putfield 2929	com/tencent/mobileqq/data/Card:shAge	S
    //   455: aload 14
    //   457: aload_3
    //   458: getfield 3673	SummaryCard/RespSummaryCard:bAge	B
    //   461: putfield 1914	com/tencent/mobileqq/data/Card:age	B
    //   464: aload 14
    //   466: aload_3
    //   467: getfield 5554	SummaryCard/RespSummaryCard:iBirthday	I
    //   470: i2l
    //   471: putfield 2549	com/tencent/mobileqq/data/Card:lBirthday	J
    //   474: aload 14
    //   476: aload_3
    //   477: getfield 5555	SummaryCard/RespSummaryCard:strEmail	Ljava/lang/String;
    //   480: putfield 2602	com/tencent/mobileqq/data/Card:strEmail	Ljava/lang/String;
    //   483: aload 14
    //   485: aload_3
    //   486: getfield 5558	SummaryCard/RespSummaryCard:iFace	I
    //   489: putfield 5390	com/tencent/mobileqq/data/Card:nFaceID	I
    //   492: aload 14
    //   494: aload_3
    //   495: getfield 5561	SummaryCard/RespSummaryCard:strSign	Ljava/lang/String;
    //   498: putfield 5562	com/tencent/mobileqq/data/Card:strSign	Ljava/lang/String;
    //   501: aload 14
    //   503: aload_3
    //   504: getfield 5529	SummaryCard/RespSummaryCard:strCity	Ljava/lang/String;
    //   507: putfield 2590	com/tencent/mobileqq/data/Card:strCity	Ljava/lang/String;
    //   510: aload 14
    //   512: aload_3
    //   513: getfield 5525	SummaryCard/RespSummaryCard:strProvince	Ljava/lang/String;
    //   516: putfield 2587	com/tencent/mobileqq/data/Card:strProvince	Ljava/lang/String;
    //   519: aload 14
    //   521: aload_3
    //   522: getfield 5527	SummaryCard/RespSummaryCard:strCountry	Ljava/lang/String;
    //   525: putfield 2584	com/tencent/mobileqq/data/Card:strCountry	Ljava/lang/String;
    //   528: aload 14
    //   530: aload_3
    //   531: getfield 4859	SummaryCard/RespSummaryCard:strRemark	Ljava/lang/String;
    //   534: putfield 1897	com/tencent/mobileqq/data/Card:strReMark	Ljava/lang/String;
    //   537: aload 14
    //   539: aload_3
    //   540: getfield 5565	SummaryCard/RespSummaryCard:iPhotoCount	I
    //   543: putfield 5464	com/tencent/mobileqq/data/Card:iFaceNum	I
    //   546: aload 14
    //   548: aload_3
    //   549: getfield 1239	SummaryCard/RespSummaryCard:strGroupName	Ljava/lang/String;
    //   552: putfield 5568	com/tencent/mobileqq/data/Card:strTroopName	Ljava/lang/String;
    //   555: aload 14
    //   557: aload_3
    //   558: getfield 1245	SummaryCard/RespSummaryCard:strGroupNick	Ljava/lang/String;
    //   561: putfield 5571	com/tencent/mobileqq/data/Card:strTroopNick	Ljava/lang/String;
    //   564: aload 14
    //   566: aload_3
    //   567: getfield 5574	SummaryCard/RespSummaryCard:strMobile	Ljava/lang/String;
    //   570: putfield 5575	com/tencent/mobileqq/data/Card:strMobile	Ljava/lang/String;
    //   573: aload 14
    //   575: aload_3
    //   576: getfield 5533	SummaryCard/RespSummaryCard:strContactName	Ljava/lang/String;
    //   579: putfield 5576	com/tencent/mobileqq/data/Card:strContactName	Ljava/lang/String;
    //   582: aload 14
    //   584: aload_3
    //   585: getfield 5579	SummaryCard/RespSummaryCard:strStatus	Ljava/lang/String;
    //   588: putfield 5580	com/tencent/mobileqq/data/Card:strStatus	Ljava/lang/String;
    //   591: aload 14
    //   593: aload_3
    //   594: getfield 1279	SummaryCard/RespSummaryCard:strAutoRemark	Ljava/lang/String;
    //   597: putfield 5581	com/tencent/mobileqq/data/Card:strAutoRemark	Ljava/lang/String;
    //   600: aload 14
    //   602: aload_3
    //   603: getfield 5584	SummaryCard/RespSummaryCard:vSeed	[B
    //   606: putfield 5585	com/tencent/mobileqq/data/Card:vSeed	[B
    //   609: aload 14
    //   611: aload_3
    //   612: getfield 1316	SummaryCard/RespSummaryCard:iVoteCount	I
    //   615: i2l
    //   616: putfield 5440	com/tencent/mobileqq/data/Card:lVisitCount	J
    //   619: aload 14
    //   621: aload_3
    //   622: getfield 5588	SummaryCard/RespSummaryCard:uQQMasterLoginDays	J
    //   625: putfield 5591	com/tencent/mobileqq/data/Card:lQQMasterLogindays	J
    //   628: aload 14
    //   630: iload 5
    //   632: putfield 5593	com/tencent/mobileqq/data/Card:favoriteSource	I
    //   635: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   638: ifeq +58 -> 696
    //   641: ldc 195
    //   643: iconst_2
    //   644: new 20	java/lang/StringBuilder
    //   647: dup
    //   648: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   651: ldc_w 5595
    //   654: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   657: aload_3
    //   658: getfield 1330	SummaryCard/RespSummaryCard:strVoteLimitedNotice	Ljava/lang/String;
    //   661: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   664: ldc_w 5597
    //   667: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   670: aload_3
    //   671: getfield 1334	SummaryCard/RespSummaryCard:bHaveVotedCnt	S
    //   674: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   677: ldc_w 5599
    //   680: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   683: aload_3
    //   684: getfield 1338	SummaryCard/RespSummaryCard:bAvailVoteCnt	S
    //   687: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   690: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   693: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   696: aload_0
    //   697: aload_3
    //   698: aload 13
    //   700: invokespecial 5601	anri:b	(LSummaryCard/RespSummaryCard;Ljava/lang/String;)V
    //   703: aload_0
    //   704: aload_1
    //   705: aload 14
    //   707: invokespecial 5603	anri:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/mobileqq/data/Card;)V
    //   710: aload_0
    //   711: aload 4
    //   713: aload_3
    //   714: aload 15
    //   716: aload 13
    //   718: aload 14
    //   720: invokespecial 5605	anri:a	(LSummaryCard/RespHead;LSummaryCard/RespSummaryCard;Landroid/util/SparseArray;Ljava/lang/String;Lcom/tencent/mobileqq/data/Card;)V
    //   723: aload 14
    //   725: aload_3
    //   726: getfield 5608	SummaryCard/RespSummaryCard:ulShowControl	J
    //   729: l2i
    //   730: putfield 5610	com/tencent/mobileqq/data/Card:ulShowControl	I
    //   733: aload_3
    //   734: getfield 5608	SummaryCard/RespSummaryCard:ulShowControl	J
    //   737: lconst_1
    //   738: land
    //   739: lconst_0
    //   740: lcmp
    //   741: ifne +569 -> 1310
    //   744: iconst_0
    //   745: istore 6
    //   747: aload 14
    //   749: iload 6
    //   751: invokevirtual 5613	com/tencent/mobileqq/data/Card:setFeedsShowFlag	(Z)V
    //   754: aload_3
    //   755: getfield 5608	SummaryCard/RespSummaryCard:ulShowControl	J
    //   758: ldc2_w 1835
    //   761: land
    //   762: lconst_0
    //   763: lcmp
    //   764: ifne +552 -> 1316
    //   767: iconst_0
    //   768: istore 6
    //   770: aload 14
    //   772: iload 6
    //   774: invokevirtual 5616	com/tencent/mobileqq/data/Card:setPhotoShowFlag	(Z)V
    //   777: aload_3
    //   778: getfield 5619	SummaryCard/RespSummaryCard:lCacheControl	J
    //   781: lconst_0
    //   782: lcmp
    //   783: ifne +539 -> 1322
    //   786: iconst_0
    //   787: istore 6
    //   789: aload 14
    //   791: iload 6
    //   793: invokevirtual 5622	com/tencent/mobileqq/data/Card:setPhotoUseCacheFlag	(Z)V
    //   796: aload_3
    //   797: getfield 5608	SummaryCard/RespSummaryCard:ulShowControl	J
    //   800: ldc2_w 1495
    //   803: land
    //   804: lconst_0
    //   805: lcmp
    //   806: ifne +522 -> 1328
    //   809: iconst_0
    //   810: istore 6
    //   812: aload 14
    //   814: iload 6
    //   816: invokevirtual 5625	com/tencent/mobileqq/data/Card:setXManFlag	(Z)V
    //   819: aload_0
    //   820: aload_3
    //   821: aload 14
    //   823: invokespecial 5627	anri:j	(LSummaryCard/RespSummaryCard;Lcom/tencent/mobileqq/data/Card;)V
    //   826: aload 14
    //   828: aload_3
    //   829: getfield 1519	SummaryCard/RespSummaryCard:stVipInfo	LQQService/VipBaseInfo;
    //   832: invokevirtual 5631	com/tencent/mobileqq/data/Card:setVipInfo	(LQQService/VipBaseInfo;)V
    //   835: aload_1
    //   836: getfield 600	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   839: ldc_w 5633
    //   842: invokevirtual 2619	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   845: lstore 11
    //   847: ldc_w 2221
    //   850: iconst_1
    //   851: new 20	java/lang/StringBuilder
    //   854: dup
    //   855: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   858: ldc_w 5635
    //   861: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   864: lload 11
    //   866: invokevirtual 840	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   869: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   872: invokestatic 115	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   875: aload_0
    //   876: aload_3
    //   877: aload 13
    //   879: aload 14
    //   881: lload 11
    //   883: invokespecial 5637	anri:b	(LSummaryCard/RespSummaryCard;Ljava/lang/String;Lcom/tencent/mobileqq/data/Card;J)V
    //   886: aload_0
    //   887: aload_3
    //   888: aload 14
    //   890: lload 11
    //   892: invokespecial 5639	anri:d	(LSummaryCard/RespSummaryCard;Lcom/tencent/mobileqq/data/Card;J)V
    //   895: aload_0
    //   896: aload_3
    //   897: aload 14
    //   899: lload 11
    //   901: invokespecial 5641	anri:c	(LSummaryCard/RespSummaryCard;Lcom/tencent/mobileqq/data/Card;J)V
    //   904: aload_0
    //   905: aload_3
    //   906: aload 13
    //   908: aload 14
    //   910: lload 11
    //   912: invokespecial 5643	anri:a	(LSummaryCard/RespSummaryCard;Ljava/lang/String;Lcom/tencent/mobileqq/data/Card;J)V
    //   915: aload_0
    //   916: aload_3
    //   917: aload 14
    //   919: lload 11
    //   921: invokespecial 5645	anri:b	(LSummaryCard/RespSummaryCard;Lcom/tencent/mobileqq/data/Card;J)V
    //   924: aload_0
    //   925: aload_3
    //   926: aload 14
    //   928: lload 11
    //   930: invokespecial 5647	anri:a	(LSummaryCard/RespSummaryCard;Lcom/tencent/mobileqq/data/Card;J)V
    //   933: aload_0
    //   934: aload_3
    //   935: aload 14
    //   937: invokespecial 5649	anri:i	(LSummaryCard/RespSummaryCard;Lcom/tencent/mobileqq/data/Card;)V
    //   940: aload_0
    //   941: aload_3
    //   942: aload 14
    //   944: invokespecial 5651	anri:h	(LSummaryCard/RespSummaryCard;Lcom/tencent/mobileqq/data/Card;)V
    //   947: aload_0
    //   948: aload_3
    //   949: aload 14
    //   951: invokespecial 5653	anri:g	(LSummaryCard/RespSummaryCard;Lcom/tencent/mobileqq/data/Card;)V
    //   954: aload_0
    //   955: aload_3
    //   956: aload 15
    //   958: aload 14
    //   960: invokespecial 5655	anri:a	(LSummaryCard/RespSummaryCard;Landroid/util/SparseArray;Lcom/tencent/mobileqq/data/Card;)V
    //   963: aload_0
    //   964: aload 14
    //   966: aload 15
    //   968: lload 7
    //   970: lload 9
    //   972: invokespecial 5657	anri:a	(Lcom/tencent/mobileqq/data/Card;Landroid/util/SparseArray;JJ)Z
    //   975: pop
    //   976: aload_0
    //   977: aload 14
    //   979: aload 15
    //   981: invokespecial 5659	anri:a	(Lcom/tencent/mobileqq/data/Card;Landroid/util/SparseArray;)V
    //   984: aload_0
    //   985: aload 14
    //   987: aload 15
    //   989: invokespecial 5661	anri:b	(Lcom/tencent/mobileqq/data/Card;Landroid/util/SparseArray;)V
    //   992: aload_0
    //   993: aload_3
    //   994: aload 14
    //   996: invokespecial 5663	anri:f	(LSummaryCard/RespSummaryCard;Lcom/tencent/mobileqq/data/Card;)V
    //   999: aload_0
    //   1000: aload_2
    //   1001: aload_3
    //   1002: aload 13
    //   1004: aload 14
    //   1006: invokespecial 5665	anri:a	(Lanvk;LSummaryCard/RespSummaryCard;Ljava/lang/String;Lcom/tencent/mobileqq/data/Card;)V
    //   1009: aload_0
    //   1010: aload 14
    //   1012: invokespecial 5666	anri:a	(Lcom/tencent/mobileqq/data/Card;)V
    //   1015: aload_0
    //   1016: aload 13
    //   1018: aload 14
    //   1020: invokespecial 5668	anri:a	(Ljava/lang/String;Lcom/tencent/mobileqq/data/Card;)V
    //   1023: aload_0
    //   1024: aload_3
    //   1025: aload 14
    //   1027: invokespecial 5670	anri:e	(LSummaryCard/RespSummaryCard;Lcom/tencent/mobileqq/data/Card;)V
    //   1030: aload_0
    //   1031: aload_3
    //   1032: aload 14
    //   1034: invokespecial 5672	anri:d	(LSummaryCard/RespSummaryCard;Lcom/tencent/mobileqq/data/Card;)V
    //   1037: aload_2
    //   1038: aload 14
    //   1040: invokevirtual 762	anvk:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   1043: pop
    //   1044: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1047: ifeq +97 -> 1144
    //   1050: new 20	java/lang/StringBuilder
    //   1053: dup
    //   1054: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   1057: astore 4
    //   1059: aload 4
    //   1061: ldc_w 1512
    //   1064: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1067: aload 14
    //   1069: getfield 1502	com/tencent/mobileqq/data/Card:lLoginDays	J
    //   1072: invokevirtual 840	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1075: ldc_w 5674
    //   1078: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1081: aload 14
    //   1083: getfield 1508	com/tencent/mobileqq/data/Card:strLoginDaysDesc	Ljava/lang/String;
    //   1086: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1089: ldc_w 5676
    //   1092: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1095: aload 14
    //   1097: getfield 2039	com/tencent/mobileqq/data/Card:allowClick	Z
    //   1100: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1103: ldc_w 5678
    //   1106: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1109: aload 14
    //   1111: getfield 747	com/tencent/mobileqq/data/Card:allowPeopleSee	Z
    //   1114: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1117: ldc_w 5680
    //   1120: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1123: aload 14
    //   1125: getfield 5610	com/tencent/mobileqq/data/Card:ulShowControl	I
    //   1128: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1131: pop
    //   1132: ldc_w 1510
    //   1135: iconst_2
    //   1136: aload 4
    //   1138: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1141: invokestatic 886	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1144: aload_0
    //   1145: aload_2
    //   1146: aload 13
    //   1148: invokespecial 5682	anri:a	(Lanvk;Ljava/lang/String;)Lcom/tencent/mobileqq/data/ExtensionInfo;
    //   1151: astore 4
    //   1153: aload 4
    //   1155: aload_3
    //   1156: getfield 5685	SummaryCard/RespSummaryCard:ulFaceAddonId	J
    //   1159: putfield 5688	com/tencent/mobileqq/data/ExtensionInfo:pendantId	J
    //   1162: aload 4
    //   1164: invokestatic 283	java/lang/System:currentTimeMillis	()J
    //   1167: putfield 5691	com/tencent/mobileqq/data/ExtensionInfo:timestamp	J
    //   1170: aload_0
    //   1171: aload_3
    //   1172: aload 13
    //   1174: lload 11
    //   1176: aload 4
    //   1178: invokespecial 5693	anri:a	(LSummaryCard/RespSummaryCard;Ljava/lang/String;JLcom/tencent/mobileqq/data/ExtensionInfo;)V
    //   1181: aload_2
    //   1182: aload 4
    //   1184: invokevirtual 5696	anvk:a	(Lcom/tencent/mobileqq/data/ExtensionInfo;)V
    //   1187: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1190: ifeq +44 -> 1234
    //   1193: ldc 195
    //   1195: iconst_2
    //   1196: new 20	java/lang/StringBuilder
    //   1199: dup
    //   1200: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   1203: ldc_w 5698
    //   1206: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1209: aload 13
    //   1211: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1214: ldc_w 5700
    //   1217: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1220: aload 4
    //   1222: getfield 5688	com/tencent/mobileqq/data/ExtensionInfo:pendantId	J
    //   1225: invokevirtual 840	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1228: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1231: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1234: aload_0
    //   1235: aload_3
    //   1236: aload 13
    //   1238: invokespecial 5702	anri:a	(LSummaryCard/RespSummaryCard;Ljava/lang/String;)V
    //   1241: aload_0
    //   1242: aload_2
    //   1243: aload_3
    //   1244: aload 13
    //   1246: aload 14
    //   1248: lload 11
    //   1250: invokespecial 5704	anri:a	(Lanvk;LSummaryCard/RespSummaryCard;Ljava/lang/String;Lcom/tencent/mobileqq/data/Card;J)V
    //   1253: aload_0
    //   1254: aload_1
    //   1255: getfield 600	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   1258: ldc_w 5706
    //   1261: lconst_0
    //   1262: invokevirtual 4645	android/os/Bundle:getLong	(Ljava/lang/String;J)J
    //   1265: iload 5
    //   1267: aload_3
    //   1268: aload 13
    //   1270: invokespecial 5708	anri:a	(JILSummaryCard/RespSummaryCard;Ljava/lang/String;)V
    //   1273: aload_0
    //   1274: aload_3
    //   1275: aload 14
    //   1277: invokespecial 5710	anri:c	(LSummaryCard/RespSummaryCard;Lcom/tencent/mobileqq/data/Card;)V
    //   1280: aload_0
    //   1281: aload_3
    //   1282: aload 14
    //   1284: invokespecial 5712	anri:a	(LSummaryCard/RespSummaryCard;Lcom/tencent/mobileqq/data/Card;)V
    //   1287: aload_0
    //   1288: aload_3
    //   1289: aload 14
    //   1291: invokespecial 5714	anri:b	(LSummaryCard/RespSummaryCard;Lcom/tencent/mobileqq/data/Card;)V
    //   1294: aload_2
    //   1295: aload 14
    //   1297: invokevirtual 762	anvk:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   1300: pop
    //   1301: aload_0
    //   1302: iconst_1
    //   1303: iconst_1
    //   1304: aload 14
    //   1306: invokevirtual 184	anri:notifyUI	(IZLjava/lang/Object;)V
    //   1309: return
    //   1310: iconst_1
    //   1311: istore 6
    //   1313: goto -566 -> 747
    //   1316: iconst_1
    //   1317: istore 6
    //   1319: goto -549 -> 770
    //   1322: iconst_1
    //   1323: istore 6
    //   1325: goto -536 -> 789
    //   1328: iconst_1
    //   1329: istore 6
    //   1331: goto -519 -> 812
    //   1334: aload_0
    //   1335: getfield 229	anri:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1338: ldc_w 5716
    //   1341: ldc_w 5718
    //   1344: new 20	java/lang/StringBuilder
    //   1347: dup
    //   1348: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   1351: ldc_w 5720
    //   1354: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1357: aload_2
    //   1358: invokevirtual 107	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   1361: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1364: ldc_w 5722
    //   1367: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1370: aload_2
    //   1371: invokevirtual 5725	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailMsg	()Ljava/lang/String;
    //   1374: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1377: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1380: aconst_null
    //   1381: fconst_0
    //   1382: invokestatic 5730	bhpe:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;F)V
    //   1385: ldc_w 5716
    //   1388: new 20	java/lang/StringBuilder
    //   1391: dup
    //   1392: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   1395: ldc_w 5732
    //   1398: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1401: aload_2
    //   1402: invokevirtual 107	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   1405: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1408: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1411: invokestatic 5736	bhpd:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1414: lload 7
    //   1416: lconst_0
    //   1417: lcmp
    //   1418: ifgt +14 -> 1432
    //   1421: aload 13
    //   1423: astore_1
    //   1424: aload_0
    //   1425: iconst_1
    //   1426: iconst_0
    //   1427: aload_1
    //   1428: invokevirtual 184	anri:notifyUI	(IZLjava/lang/Object;)V
    //   1431: return
    //   1432: lload 7
    //   1434: invokestatic 680	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1437: astore_1
    //   1438: goto -14 -> 1424
    //   1441: astore 13
    //   1443: goto -1083 -> 360
    //   1446: aconst_null
    //   1447: astore 4
    //   1449: goto -1384 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1452	0	this	anri
    //   0	1452	1	paramToServiceMsg	ToServiceMsg
    //   0	1452	2	paramFromServiceMsg	FromServiceMsg
    //   0	1452	3	paramObject	Object
    //   0	1452	4	paramBundle	Bundle
    //   55	1211	5	i	int
    //   15	1315	6	bool	boolean
    //   115	1318	7	l1	long
    //   151	820	9	l2	long
    //   845	404	11	l3	long
    //   127	104	13	str1	String
    //   355	12	13	localException1	Exception
    //   398	1024	13	str2	String
    //   1441	1	13	localException2	Exception
    //   185	1120	14	localObject	Object
    //   199	789	15	localSparseArray	SparseArray
    // Exception table:
    //   from	to	target	type
    //   22	45	355	java/lang/Exception
    //   50	57	1441	java/lang/Exception
  }
  
  private void q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    anrr localanrr;
    anvk localanvk;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      bool1 = true;
      localanrr = null;
      localanvk = null;
      if (bool1) {
        paramFromServiceMsg = localanrr;
      }
    }
    for (;;)
    {
      try
      {
        paramObject = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        paramFromServiceMsg = localanrr;
        Object localObject1 = ByteBuffer.wrap(paramObject.bytes_bodybuffer.get().toByteArray());
        paramFromServiceMsg = localanrr;
        if (!paramObject.uint32_result.has()) {
          continue;
        }
        paramFromServiceMsg = localanrr;
        if (paramObject.uint32_result.get() != 0) {
          continue;
        }
        paramFromServiceMsg = localanrr;
        Long localLong = Long.valueOf(bhbx.a(((ByteBuffer)localObject1).getInt()));
        paramFromServiceMsg = localanrr;
        ((ByteBuffer)localObject1).get();
        paramFromServiceMsg = localanrr;
        int m = ((ByteBuffer)localObject1).getShort();
        paramFromServiceMsg = localanrr;
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = localanrr;
          QLog.i("CardHandler", 2, "handleGetDetailInfo request success. TLVCount=" + m);
        }
        j = 0;
        paramFromServiceMsg = localanrr;
        localanvk = (anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
        paramFromServiceMsg = localanrr;
        paramObject = localanvk.c(this.app.getCurrentAccountUin());
        paramFromServiceMsg = paramObject;
        localanrr = new anrr(null);
        paramFromServiceMsg = paramObject;
        Object localObject2 = new anrp(null);
        paramFromServiceMsg = paramObject;
        anrq localanrq = new anrq(null);
        paramFromServiceMsg = paramObject;
        amme localamme = (amme)this.app.getManager(QQManagerFactory.APOLLO_MANAGER);
        paramFromServiceMsg = paramObject;
        ((anrp)localObject2).jdField_a_of_type_Amme = localamme;
        paramFromServiceMsg = paramObject;
        ((anrp)localObject2).jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo = localamme.b(this.app.getCurrentAccountUin());
        paramFromServiceMsg = paramObject;
        int k = ((ByteBuffer)localObject1).position();
        paramFromServiceMsg = paramObject;
        bdvo localbdvo = new bdvo();
        paramFromServiceMsg = paramObject;
        if ((((ByteBuffer)localObject1).hasRemaining()) && (j < m))
        {
          paramFromServiceMsg = paramObject;
          ((ByteBuffer)localObject1).position(k);
          paramFromServiceMsg = paramObject;
          short s = ((ByteBuffer)localObject1).getShort();
          paramFromServiceMsg = paramObject;
          int i = ((ByteBuffer)localObject1).getShort();
          paramFromServiceMsg = paramObject;
          k = ((ByteBuffer)localObject1).position() + i;
          paramFromServiceMsg = paramObject;
          if (QLog.isColorLevel())
          {
            paramFromServiceMsg = paramObject;
            QLog.d("CardHandler", 2, String.format("handleGetDetailInfo K=%s, L=%s, nextTLVPosition=%s", new Object[] { Short.valueOf(s), Short.valueOf(i), Integer.valueOf(k) }));
          }
          paramFromServiceMsg = paramObject;
          a((ByteBuffer)localObject1, s, i, localLong, paramObject, localanrr);
          paramFromServiceMsg = paramObject;
          a((ByteBuffer)localObject1, s, i, localLong, paramObject);
          paramFromServiceMsg = paramObject;
          b((ByteBuffer)localObject1, s, i, localLong, paramObject);
          paramFromServiceMsg = paramObject;
          c((ByteBuffer)localObject1, s, i, localLong, paramObject);
          paramFromServiceMsg = paramObject;
          a((ByteBuffer)localObject1, s, i, localLong, paramObject, (anrp)localObject2);
          paramFromServiceMsg = paramObject;
          a((ByteBuffer)localObject1, s, i, localLong, paramObject, localanrq);
          paramFromServiceMsg = paramObject;
          d((ByteBuffer)localObject1, s, i, localLong, paramObject);
          paramFromServiceMsg = paramObject;
          a((ByteBuffer)localObject1, s, i, localLong, paramObject, localbdvo);
          j += 1;
          continue;
        }
        paramFromServiceMsg = paramObject;
        localObject1 = (aozr)this.app.getManager(QQManagerFactory.CLASSIC_HEAD_ACIVITY_MANAGER);
        if (localObject1 != null)
        {
          paramFromServiceMsg = paramObject;
          if (((aozr)localObject1).a())
          {
            paramFromServiceMsg = paramObject;
            ((aozr)localObject1).a(localanrq.jdField_a_of_type_Short, localanrq.jdField_b_of_type_Short, localanrq.jdField_c_of_type_Short);
          }
        }
        paramFromServiceMsg = paramObject;
        if (((anrp)localObject2).jdField_a_of_type_Boolean)
        {
          paramFromServiceMsg = paramObject;
          localamme.a(((anrp)localObject2).jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo);
        }
        paramFromServiceMsg = paramObject;
        if (localbdvo.jdField_a_of_type_Boolean)
        {
          paramFromServiceMsg = paramObject;
          if (localbdvo.c) {
            break label1104;
          }
          paramFromServiceMsg = paramObject;
          if (!localbdvo.jdField_b_of_type_Boolean) {
            continue;
          }
          break label1104;
          paramFromServiceMsg = paramObject;
          QLog.d("CardHandler", 1, new Object[] { "[KidMode]studyModeFlag:", Boolean.valueOf(localbdvo.c), " kidModeFlag:", Boolean.valueOf(localbdvo.jdField_b_of_type_Boolean), " simpleUi:", Boolean.valueOf(localbdvo.d) });
          paramFromServiceMsg = paramObject;
          bdvn.a(bool2, this.app);
          paramFromServiceMsg = paramObject;
          ((bdve)this.app.getManager(QQManagerFactory.STUDY_MODE_SWITCHER_MANAGER)).b(bool2);
          paramFromServiceMsg = paramObject;
          bdvn.a(this.app, bool2, localbdvo.d);
        }
        paramFromServiceMsg = paramObject;
        if (amme.a(this.app.getApp()))
        {
          paramFromServiceMsg = paramObject;
          if (((anrp)localObject2).jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo.isApolloStatusOpen())
          {
            paramFromServiceMsg = paramObject;
            if (((anrp)localObject2).jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo.apolloLocalTS != ((anrp)localObject2).jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo.apolloServerTS) {
              continue;
            }
          }
        }
        paramFromServiceMsg = paramObject;
        if (amme.a(this.app) == 2)
        {
          paramFromServiceMsg = paramObject;
          if (((anrp)localObject2).jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo.getApolloDress3D() == null)
          {
            paramFromServiceMsg = paramObject;
            localObject1 = new ArrayList(1);
            paramFromServiceMsg = paramObject;
            ((ArrayList)localObject1).add(Long.valueOf(((anrp)localObject2).jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo.uin));
            paramFromServiceMsg = paramObject;
            localObject2 = (VasExtensionHandler)this.app.getBusinessHandler(BusinessHandlerFactory.VAS_EXTENSION_HANDLER);
            if (localObject2 != null)
            {
              paramFromServiceMsg = paramObject;
              ((VasExtensionHandler)localObject2).a((ArrayList)localObject1, "card");
            }
          }
        }
        paramFromServiceMsg = paramObject;
        localanrr.a(paramObject);
        paramFromServiceMsg = paramObject;
        localanvk.a(paramObject);
        paramFromServiceMsg = paramObject;
        if (!localanrr.jdField_a_of_type_Boolean)
        {
          paramFromServiceMsg = paramObject;
          if (!localanrr.jdField_b_of_type_Boolean) {}
        }
        else
        {
          paramFromServiceMsg = paramObject;
          if (paramToServiceMsg.extraData.getBoolean("reqFromDetailActivity"))
          {
            paramFromServiceMsg = paramObject;
            ((anrz)this.app.getManager(QQManagerFactory.CONDITION_SEARCH_MANAGER)).a(paramObject);
          }
        }
        paramFromServiceMsg = paramObject;
      }
      catch (Exception paramToServiceMsg)
      {
        bool1 = false;
        QLog.e("CardHandler", 1, "handleGetDetailInfo fail.", paramToServiceMsg);
        continue;
        int j = -1111;
        continue;
      }
      notifyUI(20, bool1, paramFromServiceMsg);
      return;
      boolean bool2 = false;
      continue;
      paramFromServiceMsg = localanrr;
      if (paramObject.uint32_result.has())
      {
        paramFromServiceMsg = localanrr;
        j = paramObject.uint32_result.get();
        paramFromServiceMsg = localanrr;
        QLog.d("CardHandler", 1, String.format("handleGetDetailInfo request fail. ret=%s", new Object[] { Integer.valueOf(j) }));
        bool1 = false;
        paramFromServiceMsg = localanvk;
      }
      else
      {
        paramFromServiceMsg = localanvk;
        continue;
        bool1 = false;
        break;
        label1104:
        bool2 = true;
      }
    }
  }
  
  private void q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    boolean bool2;
    boolean bool1;
    if ((paramFromServiceMsg.isSuccess()) && ((paramObject instanceof RespSummaryCard)))
    {
      bool2 = true;
      bool1 = bool2;
      if (!bool2) {}
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = (SummaryCard.RespHead)decodePacket(paramFromServiceMsg.getWupBuffer(), "RespHead", new SummaryCard.RespHead());
        if (paramFromServiceMsg == null) {
          continue;
        }
        i = paramFromServiceMsg.iResult;
        if (i != 0) {
          continue;
        }
        bool1 = true;
      }
      catch (Exception paramFromServiceMsg)
      {
        int i;
        long l;
        QLog.e("Q.profilecard.SummaryCard", 1, "handleGetSimpleSummaryCard decode packet fail.", paramFromServiceMsg);
        bool1 = false;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, String.format("handleGetSimpleSummaryCard success=%s", new Object[] { Boolean.valueOf(bool1) }));
      }
      l = paramToServiceMsg.extraData.getLong("targetUin");
      if (bool1)
      {
        paramToServiceMsg = (RespSummaryCard)paramObject;
        paramFromServiceMsg = new oidb_0x5eb.UdcUinData();
        if (paramToServiceMsg.vResp0x5ebInfo == null) {}
      }
      try
      {
        paramFromServiceMsg.mergeFrom(paramToServiceMsg.vResp0x5ebInfo);
        if ((String.valueOf(l).equals(this.app.getCurrentAccountUin())) && (paramFromServiceMsg.int32_history_num_flag.has()))
        {
          i = paramFromServiceMsg.int32_history_num_flag.get();
          bhhr.F(this.mApp.getApplication(), getCurrentAccountUin(), i);
          if (QLog.isColorLevel()) {
            QLog.i("Q.profilecard.SummaryCard", 2, "handleGetSimpleSummaryCard, history_num_flag= " + i);
          }
        }
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        QLog.e("Q.profilecard.SummaryCard", 1, "handleGetSimpleSummaryCard fail.", paramToServiceMsg);
      }
      bool2 = false;
      break;
      bool1 = false;
    }
  }
  
  private void r(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = (String)paramToServiceMsg.getAttribute("uin");
    EntityManager localEntityManager;
    boolean bool;
    if ((paramFromServiceMsg.isSuccess()) && ((paramObject instanceof mobile_sub_get_cover_rsp)))
    {
      paramFromServiceMsg = (mobile_sub_get_cover_rsp)paramObject;
      localEntityManager = this.app.getEntityManagerFactory().createEntityManager();
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
  
  private void r(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject, Bundle paramBundle)
  {
    byte[] arrayOfByte = paramToServiceMsg.extraData.getByteArray("filekey");
    paramBundle.putByteArray("fileKey", arrayOfByte);
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      RespDelFace localRespDelFace = (RespDelFace)paramObject;
      anvk localanvk = (anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      paramObject = localanvk.b(paramToServiceMsg.getUin());
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
        localanvk.a(paramFromServiceMsg);
        return;
        if (localRespDelFace.uFaceTimeStamp > paramFromServiceMsg.uFaceTimeStamp) {
          paramFromServiceMsg.uFaceTimeStamp = localRespDelFace.uFaceTimeStamp;
        }
        paramFromServiceMsg.removePortrait(arrayOfByte);
        notifyUI(12, true, new Object[] { paramBundle, paramFromServiceMsg });
        continue;
        notifyUI(12, false, new Object[] { paramBundle, paramFromServiceMsg });
      }
    }
    paramBundle.putInt("result", -1);
    notifyUI(12, false, new Object[] { paramBundle, ((anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).c(paramToServiceMsg.getUin()) });
  }
  
  private void s(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str1 = (String)paramToServiceMsg.getAttribute("uin");
    String str2 = (String)paramToServiceMsg.getAttribute("attachInfo");
    EntityManager localEntityManager;
    boolean bool;
    if ((paramFromServiceMsg.isSuccess()) && ((paramObject instanceof mobile_sub_get_photo_wall_rsp)))
    {
      paramFromServiceMsg = (mobile_sub_get_photo_wall_rsp)paramObject;
      localEntityManager = this.app.getEntityManagerFactory().createEntityManager();
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
  
  private void t(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = paramFromServiceMsg.isSuccess();
    paramFromServiceMsg = (String)paramToServiceMsg.getAttribute("uin");
    paramToServiceMsg = (String)paramToServiceMsg.getAttribute("photo_id");
    if (QLog.isColorLevel()) {
      QLog.d("Q.qzonephotowall", 2, "handleDelPhotoWall isSuc:" + bool + " photoid:" + paramToServiceMsg);
    }
    notifyUI(70, bool, new Object[] { paramFromServiceMsg });
  }
  
  /* Error */
  private void u(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
    //   13: invokevirtual 100	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   16: ifeq +472 -> 488
    //   19: aload_3
    //   20: ifnull +468 -> 488
    //   23: iconst_1
    //   24: istore 5
    //   26: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   29: ifeq +31 -> 60
    //   32: ldc_w 726
    //   35: iconst_2
    //   36: new 20	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   43: ldc_w 5870
    //   46: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: iload 5
    //   51: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   54: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   60: iload 5
    //   62: istore 6
    //   64: iload 12
    //   66: istore 8
    //   68: iload 5
    //   70: ifeq +343 -> 413
    //   73: iload 5
    //   75: istore 10
    //   77: iload 5
    //   79: istore 7
    //   81: iload 14
    //   83: istore 9
    //   85: new 117	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   88: dup
    //   89: invokespecial 118	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   92: aload_3
    //   93: checkcast 120	[B
    //   96: checkcast 120	[B
    //   99: invokevirtual 124	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   102: checkcast 117	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   105: astore_2
    //   106: aload_2
    //   107: ifnull +387 -> 494
    //   110: iload 5
    //   112: istore 10
    //   114: iload 5
    //   116: istore 7
    //   118: iload 14
    //   120: istore 9
    //   122: aload_2
    //   123: getfield 128	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   126: invokevirtual 133	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   129: ifne +365 -> 494
    //   132: iconst_1
    //   133: istore 5
    //   135: iload 5
    //   137: istore 10
    //   139: iload 5
    //   141: istore 7
    //   143: iload 14
    //   145: istore 9
    //   147: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   150: ifeq +43 -> 193
    //   153: iload 5
    //   155: istore 10
    //   157: iload 5
    //   159: istore 7
    //   161: iload 14
    //   163: istore 9
    //   165: ldc_w 726
    //   168: iconst_2
    //   169: new 20	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   176: ldc_w 5872
    //   179: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: iload 5
    //   184: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   187: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   193: iload 5
    //   195: istore 6
    //   197: iload 12
    //   199: istore 8
    //   201: iload 5
    //   203: ifeq +210 -> 413
    //   206: iload 5
    //   208: istore 6
    //   210: iload 12
    //   212: istore 8
    //   214: iload 5
    //   216: istore 10
    //   218: iload 5
    //   220: istore 7
    //   222: iload 14
    //   224: istore 9
    //   226: aload_2
    //   227: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   230: invokevirtual 147	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   233: ifeq +180 -> 413
    //   236: iload 5
    //   238: istore 6
    //   240: iload 12
    //   242: istore 8
    //   244: iload 5
    //   246: istore 10
    //   248: iload 5
    //   250: istore 7
    //   252: iload 14
    //   254: istore 9
    //   256: aload_2
    //   257: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   260: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   263: ifnull +150 -> 413
    //   266: iload 5
    //   268: istore 10
    //   270: iload 5
    //   272: istore 7
    //   274: iload 14
    //   276: istore 9
    //   278: aload_2
    //   279: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   282: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   285: invokevirtual 159	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   288: invokestatic 614	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   291: astore_2
    //   292: iload 5
    //   294: istore 10
    //   296: iload 5
    //   298: istore 7
    //   300: iload 14
    //   302: istore 9
    //   304: aload_2
    //   305: invokevirtual 617	java/nio/ByteBuffer:getInt	()I
    //   308: istore 4
    //   310: iload 4
    //   312: i2l
    //   313: lstore 15
    //   315: iload 4
    //   317: ifge +12 -> 329
    //   320: iload 4
    //   322: ldc_w 1063
    //   325: iand
    //   326: i2l
    //   327: lstore 15
    //   329: iload 5
    //   331: istore 10
    //   333: iload 5
    //   335: istore 7
    //   337: iload 14
    //   339: istore 9
    //   341: aload_2
    //   342: invokevirtual 620	java/nio/ByteBuffer:get	()B
    //   345: pop
    //   346: iload 5
    //   348: istore 6
    //   350: iload 12
    //   352: istore 8
    //   354: iload 5
    //   356: istore 10
    //   358: iload 5
    //   360: istore 7
    //   362: iload 14
    //   364: istore 9
    //   366: aload_2
    //   367: invokevirtual 624	java/nio/ByteBuffer:getShort	()S
    //   370: invokestatic 635	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   373: invokevirtual 740	java/lang/Short:shortValue	()S
    //   376: iconst_1
    //   377: if_icmpne +36 -> 413
    //   380: iload 5
    //   382: istore 10
    //   384: iload 5
    //   386: istore 7
    //   388: iload 14
    //   390: istore 9
    //   392: aload_2
    //   393: invokevirtual 624	java/nio/ByteBuffer:getShort	()S
    //   396: istore 4
    //   398: iload 4
    //   400: sipush -25042
    //   403: if_icmpeq +97 -> 500
    //   406: iconst_0
    //   407: istore 6
    //   409: iload 12
    //   411: istore 8
    //   413: iload 6
    //   415: istore 7
    //   417: iload 8
    //   419: istore 9
    //   421: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   424: ifeq +50 -> 474
    //   427: ldc_w 726
    //   430: iconst_2
    //   431: new 20	java/lang/StringBuilder
    //   434: dup
    //   435: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   438: ldc_w 5872
    //   441: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: iload 6
    //   446: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   449: ldc_w 742
    //   452: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: iload 8
    //   457: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   460: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   463: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   466: iload 8
    //   468: istore 9
    //   470: iload 6
    //   472: istore 7
    //   474: aload_0
    //   475: bipush 54
    //   477: iload 7
    //   479: iload 9
    //   481: invokestatic 180	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   484: invokevirtual 184	anri:notifyUI	(IZLjava/lang/Object;)V
    //   487: return
    //   488: iconst_0
    //   489: istore 5
    //   491: goto -465 -> 26
    //   494: iconst_0
    //   495: istore 5
    //   497: goto -362 -> 135
    //   500: iload 5
    //   502: istore 10
    //   504: iload 5
    //   506: istore 7
    //   508: iload 14
    //   510: istore 9
    //   512: aload_2
    //   513: invokevirtual 624	java/nio/ByteBuffer:getShort	()S
    //   516: istore 4
    //   518: iload 4
    //   520: iconst_2
    //   521: if_icmpne +123 -> 644
    //   524: iload 5
    //   526: istore 10
    //   528: iload 5
    //   530: istore 7
    //   532: iload 14
    //   534: istore 9
    //   536: iload 4
    //   538: newarray byte
    //   540: astore_3
    //   541: iload 5
    //   543: istore 10
    //   545: iload 5
    //   547: istore 7
    //   549: iload 14
    //   551: istore 9
    //   553: aload_2
    //   554: aload_3
    //   555: invokevirtual 754	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   558: pop
    //   559: iload 5
    //   561: istore 10
    //   563: iload 5
    //   565: istore 7
    //   567: iload 14
    //   569: istore 9
    //   571: aload_3
    //   572: iconst_0
    //   573: invokestatic 759	bhbx:a	([BI)S
    //   576: istore 4
    //   578: iload 4
    //   580: ifne +32 -> 612
    //   583: iconst_0
    //   584: istore 6
    //   586: aload_2
    //   587: invokevirtual 624	java/nio/ByteBuffer:getShort	()S
    //   590: istore 4
    //   592: iload 4
    //   594: ifeq +24 -> 618
    //   597: iload 11
    //   599: istore 5
    //   601: iload 6
    //   603: istore 8
    //   605: iload 5
    //   607: istore 6
    //   609: goto -196 -> 413
    //   612: iconst_1
    //   613: istore 6
    //   615: goto -29 -> 586
    //   618: aload_0
    //   619: getfield 229	anri:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   622: invokevirtual 1056	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   625: aload_1
    //   626: invokevirtual 2519	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   629: aconst_null
    //   630: ldc_w 4184
    //   633: iload 6
    //   635: invokestatic 3412	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:writeValue	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   638: iconst_1
    //   639: istore 5
    //   641: goto -40 -> 601
    //   644: iconst_0
    //   645: istore 6
    //   647: iload 12
    //   649: istore 8
    //   651: goto -238 -> 413
    //   654: astore_1
    //   655: iload 13
    //   657: istore 6
    //   659: iload 10
    //   661: istore 5
    //   663: iload 5
    //   665: istore 7
    //   667: iload 6
    //   669: istore 9
    //   671: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   674: ifeq +22 -> 696
    //   677: iload 5
    //   679: istore 7
    //   681: iload 6
    //   683: istore 9
    //   685: ldc_w 726
    //   688: iconst_2
    //   689: ldc_w 5874
    //   692: aload_1
    //   693: invokestatic 208	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   696: iload 5
    //   698: istore 7
    //   700: iload 6
    //   702: istore 9
    //   704: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   707: ifeq -233 -> 474
    //   710: ldc_w 726
    //   713: iconst_2
    //   714: new 20	java/lang/StringBuilder
    //   717: dup
    //   718: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   721: ldc_w 5872
    //   724: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   727: iload 5
    //   729: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   732: ldc_w 742
    //   735: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   738: iload 6
    //   740: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   743: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   746: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   749: iload 5
    //   751: istore 7
    //   753: iload 6
    //   755: istore 9
    //   757: goto -283 -> 474
    //   760: astore_1
    //   761: iload 7
    //   763: istore 5
    //   765: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   768: ifeq +42 -> 810
    //   771: ldc_w 726
    //   774: iconst_2
    //   775: new 20	java/lang/StringBuilder
    //   778: dup
    //   779: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   782: ldc_w 5872
    //   785: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   788: iload 5
    //   790: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   793: ldc_w 742
    //   796: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   799: iload 9
    //   801: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   804: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   807: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   810: aload_1
    //   811: athrow
    //   812: astore_1
    //   813: iload 6
    //   815: istore 9
    //   817: goto -52 -> 765
    //   820: astore_1
    //   821: iconst_1
    //   822: istore 5
    //   824: iload 6
    //   826: istore 9
    //   828: goto -63 -> 765
    //   831: astore_1
    //   832: goto -169 -> 663
    //   835: astore_1
    //   836: iconst_1
    //   837: istore 5
    //   839: goto -176 -> 663
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	842	0	this	anri
    //   0	842	1	paramToServiceMsg	ToServiceMsg
    //   0	842	2	paramFromServiceMsg	FromServiceMsg
    //   0	842	3	paramObject	Object
    //   308	285	4	i	int
    //   24	814	5	bool1	boolean
    //   62	763	6	bool2	boolean
    //   79	683	7	bool3	boolean
    //   66	584	8	bool4	boolean
    //   83	744	9	bool5	boolean
    //   75	585	10	bool6	boolean
    //   1	597	11	bool7	boolean
    //   10	638	12	bool8	boolean
    //   4	652	13	bool9	boolean
    //   7	561	14	bool10	boolean
    //   313	15	15	l	long
    // Exception table:
    //   from	to	target	type
    //   85	106	654	java/lang/Exception
    //   122	132	654	java/lang/Exception
    //   147	153	654	java/lang/Exception
    //   165	193	654	java/lang/Exception
    //   226	236	654	java/lang/Exception
    //   256	266	654	java/lang/Exception
    //   278	292	654	java/lang/Exception
    //   304	310	654	java/lang/Exception
    //   341	346	654	java/lang/Exception
    //   366	380	654	java/lang/Exception
    //   392	398	654	java/lang/Exception
    //   512	518	654	java/lang/Exception
    //   536	541	654	java/lang/Exception
    //   553	559	654	java/lang/Exception
    //   571	578	654	java/lang/Exception
    //   85	106	760	finally
    //   122	132	760	finally
    //   147	153	760	finally
    //   165	193	760	finally
    //   226	236	760	finally
    //   256	266	760	finally
    //   278	292	760	finally
    //   304	310	760	finally
    //   341	346	760	finally
    //   366	380	760	finally
    //   392	398	760	finally
    //   512	518	760	finally
    //   536	541	760	finally
    //   553	559	760	finally
    //   571	578	760	finally
    //   671	677	760	finally
    //   685	696	760	finally
    //   586	592	812	finally
    //   618	638	820	finally
    //   586	592	831	java/lang/Exception
    //   618	638	835	java/lang/Exception
  }
  
  private void v(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
      paramFromServiceMsg = this.app.getApplication().getString(2131694515);
      str = this.app.getCurrentAccountUin();
      bool3 = bool1;
      if (!bool1) {
        break label610;
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
          break label610;
        }
        bool2 = bool1;
        bool4 = bool1;
        bool3 = bool1;
        if (!paramObject.bytes_bodybuffer.has()) {
          break label610;
        }
        bool2 = bool1;
        bool4 = bool1;
        bool3 = bool1;
        if (paramObject.bytes_bodybuffer.get() == null) {
          break label610;
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
        if (!this.app.getCurrentAccountUin().equals(String.valueOf(l))) {
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
          break label600;
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
      label600:
      bool3 = false;
      bool4 = bool2;
      continue;
      label610:
      bool1 = false;
      bool2 = bool3;
    }
  }
  
  private void w(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
      paramFromServiceMsg = this.app.getApplication().getString(2131694515);
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
              bool1 = this.app.getCurrentAccountUin().equals(String.valueOf(l));
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
      ((awtq)this.app.getManager(QQManagerFactory.TEMP_MSG_SETTTING_MANAGER)).a(s, bool2, paramFromServiceMsg, bool5);
      return;
      bool2 = false;
      break;
      bool2 = false;
      continue;
      bool1 = false;
    }
  }
  
  private void x(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
      paramFromServiceMsg = this.app.getApplication().getString(2131694515);
      str = this.app.getCurrentAccountUin();
      bool3 = bool1;
      if (!bool1) {
        break label610;
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
          break label610;
        }
        bool2 = bool1;
        bool4 = bool1;
        bool3 = bool1;
        if (!paramObject.bytes_bodybuffer.has()) {
          break label610;
        }
        bool2 = bool1;
        bool4 = bool1;
        bool3 = bool1;
        if (paramObject.bytes_bodybuffer.get() == null) {
          break label610;
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
        if (!this.app.getCurrentAccountUin().equals(String.valueOf(l))) {
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
          break label600;
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
      label600:
      bool3 = false;
      bool4 = bool2;
      continue;
      label610:
      bool1 = false;
      bool2 = bool3;
    }
  }
  
  /* Error */
  private void y(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
    //   13: invokevirtual 100	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   16: ifeq +404 -> 420
    //   19: aload_3
    //   20: ifnull +400 -> 420
    //   23: iconst_1
    //   24: istore 5
    //   26: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   29: ifeq +31 -> 60
    //   32: ldc_w 726
    //   35: iconst_2
    //   36: new 20	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   43: ldc_w 5895
    //   46: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: iload 5
    //   51: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   54: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   57: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   60: iload 5
    //   62: istore 8
    //   64: iload 5
    //   66: ifeq +706 -> 772
    //   69: iload 5
    //   71: istore 7
    //   73: iload 5
    //   75: istore 6
    //   77: new 117	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   80: dup
    //   81: invokespecial 118	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   84: aload_3
    //   85: checkcast 120	[B
    //   88: checkcast 120	[B
    //   91: invokevirtual 124	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   94: checkcast 117	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   97: astore_2
    //   98: aload_2
    //   99: ifnull +327 -> 426
    //   102: iload 5
    //   104: istore 7
    //   106: iload 5
    //   108: istore 6
    //   110: aload_2
    //   111: getfield 128	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   114: invokevirtual 133	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   117: ifne +309 -> 426
    //   120: iconst_1
    //   121: istore 5
    //   123: iload 5
    //   125: istore 7
    //   127: iload 5
    //   129: istore 6
    //   131: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   134: ifeq +39 -> 173
    //   137: iload 5
    //   139: istore 7
    //   141: iload 5
    //   143: istore 6
    //   145: ldc_w 726
    //   148: iconst_2
    //   149: new 20	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   156: ldc_w 5897
    //   159: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: iload 5
    //   164: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   167: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   170: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   173: iload 5
    //   175: istore 8
    //   177: iload 5
    //   179: ifeq +593 -> 772
    //   182: iload 5
    //   184: istore 7
    //   186: iload 5
    //   188: istore 6
    //   190: iload 5
    //   192: istore 8
    //   194: aload_2
    //   195: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   198: invokevirtual 147	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   201: ifeq +571 -> 772
    //   204: iload 5
    //   206: istore 7
    //   208: iload 5
    //   210: istore 6
    //   212: iload 5
    //   214: istore 8
    //   216: aload_2
    //   217: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   220: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   223: ifnull +549 -> 772
    //   226: iload 5
    //   228: istore 7
    //   230: iload 5
    //   232: istore 6
    //   234: aload_2
    //   235: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   238: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   241: invokevirtual 159	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   244: invokestatic 614	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   247: astore_2
    //   248: iload 5
    //   250: istore 7
    //   252: iload 5
    //   254: istore 6
    //   256: aload_2
    //   257: invokevirtual 617	java/nio/ByteBuffer:getInt	()I
    //   260: istore 4
    //   262: iload 4
    //   264: i2l
    //   265: lstore 13
    //   267: iload 4
    //   269: ifge +12 -> 281
    //   272: iload 4
    //   274: ldc_w 1063
    //   277: iand
    //   278: i2l
    //   279: lstore 13
    //   281: iload 5
    //   283: istore 7
    //   285: iload 5
    //   287: istore 6
    //   289: aload_2
    //   290: invokevirtual 620	java/nio/ByteBuffer:get	()B
    //   293: pop
    //   294: iload 5
    //   296: istore 7
    //   298: iload 5
    //   300: istore 6
    //   302: aload_2
    //   303: invokevirtual 624	java/nio/ByteBuffer:getShort	()S
    //   306: invokestatic 635	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   309: invokevirtual 740	java/lang/Short:shortValue	()S
    //   312: iconst_1
    //   313: if_icmpne +249 -> 562
    //   316: iload 5
    //   318: istore 7
    //   320: iload 5
    //   322: istore 6
    //   324: aload_2
    //   325: invokevirtual 624	java/nio/ByteBuffer:getShort	()S
    //   328: istore 4
    //   330: iload 4
    //   332: sipush -25181
    //   335: if_icmpeq +97 -> 432
    //   338: iconst_0
    //   339: istore 5
    //   341: iload 9
    //   343: istore 6
    //   345: iload 5
    //   347: istore 7
    //   349: iload 6
    //   351: istore 8
    //   353: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   356: ifeq +50 -> 406
    //   359: ldc_w 726
    //   362: iconst_2
    //   363: new 20	java/lang/StringBuilder
    //   366: dup
    //   367: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   370: ldc_w 5897
    //   373: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: iload 5
    //   378: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   381: ldc_w 742
    //   384: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: iload 6
    //   389: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   392: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   395: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   398: iload 6
    //   400: istore 8
    //   402: iload 5
    //   404: istore 7
    //   406: aload_0
    //   407: bipush 88
    //   409: iload 7
    //   411: iload 8
    //   413: invokestatic 180	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   416: invokevirtual 184	anri:notifyUI	(IZLjava/lang/Object;)V
    //   419: return
    //   420: iconst_0
    //   421: istore 5
    //   423: goto -397 -> 26
    //   426: iconst_0
    //   427: istore 5
    //   429: goto -306 -> 123
    //   432: iload 5
    //   434: istore 7
    //   436: iload 5
    //   438: istore 6
    //   440: aload_2
    //   441: invokevirtual 624	java/nio/ByteBuffer:getShort	()S
    //   444: istore 4
    //   446: iload 4
    //   448: iconst_2
    //   449: if_icmpne +103 -> 552
    //   452: iload 5
    //   454: istore 7
    //   456: iload 5
    //   458: istore 6
    //   460: iload 4
    //   462: newarray byte
    //   464: astore_3
    //   465: iload 5
    //   467: istore 7
    //   469: iload 5
    //   471: istore 6
    //   473: aload_2
    //   474: aload_3
    //   475: invokevirtual 754	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   478: pop
    //   479: iload 5
    //   481: istore 7
    //   483: iload 5
    //   485: istore 6
    //   487: aload_3
    //   488: iconst_0
    //   489: invokestatic 759	bhbx:a	([BI)S
    //   492: istore 4
    //   494: iload 4
    //   496: ifne +24 -> 520
    //   499: iconst_1
    //   500: istore 6
    //   502: aload_2
    //   503: invokevirtual 624	java/nio/ByteBuffer:getShort	()S
    //   506: istore 4
    //   508: iload 4
    //   510: ifeq +16 -> 526
    //   513: iload 10
    //   515: istore 5
    //   517: goto -172 -> 345
    //   520: iconst_0
    //   521: istore 6
    //   523: goto -21 -> 502
    //   526: aload_0
    //   527: getfield 229	anri:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   530: invokevirtual 1056	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   533: aload_1
    //   534: invokevirtual 2519	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   537: aconst_null
    //   538: ldc_w 4208
    //   541: iload 6
    //   543: invokestatic 3412	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:writeValue	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   546: iconst_1
    //   547: istore 5
    //   549: goto -32 -> 517
    //   552: iconst_0
    //   553: istore 5
    //   555: iload 9
    //   557: istore 6
    //   559: goto -214 -> 345
    //   562: iconst_0
    //   563: istore 5
    //   565: iload 9
    //   567: istore 6
    //   569: goto -224 -> 345
    //   572: astore_1
    //   573: iload 7
    //   575: istore 6
    //   577: iload 11
    //   579: istore 5
    //   581: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   584: ifeq +14 -> 598
    //   587: ldc_w 726
    //   590: iconst_2
    //   591: ldc_w 5899
    //   594: aload_1
    //   595: invokestatic 208	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   598: iload 6
    //   600: istore 7
    //   602: iload 5
    //   604: istore 8
    //   606: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   609: ifeq -203 -> 406
    //   612: ldc_w 726
    //   615: iconst_2
    //   616: new 20	java/lang/StringBuilder
    //   619: dup
    //   620: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   623: ldc_w 5897
    //   626: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   629: iload 6
    //   631: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   634: ldc_w 742
    //   637: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   640: iload 5
    //   642: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   645: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   648: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   651: iload 6
    //   653: istore 7
    //   655: iload 5
    //   657: istore 8
    //   659: goto -253 -> 406
    //   662: astore_1
    //   663: iload 12
    //   665: istore 5
    //   667: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   670: ifeq +42 -> 712
    //   673: ldc_w 726
    //   676: iconst_2
    //   677: new 20	java/lang/StringBuilder
    //   680: dup
    //   681: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   684: ldc_w 5897
    //   687: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   690: iload 6
    //   692: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   695: ldc_w 742
    //   698: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   701: iload 5
    //   703: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   706: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   709: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   712: aload_1
    //   713: athrow
    //   714: astore_1
    //   715: iload 6
    //   717: istore 7
    //   719: iload 5
    //   721: istore 6
    //   723: iload 7
    //   725: istore 5
    //   727: goto -60 -> 667
    //   730: astore_1
    //   731: iload 6
    //   733: istore 5
    //   735: iconst_1
    //   736: istore 6
    //   738: goto -71 -> 667
    //   741: astore_1
    //   742: goto -75 -> 667
    //   745: astore_1
    //   746: iload 6
    //   748: istore 7
    //   750: iload 5
    //   752: istore 6
    //   754: iload 7
    //   756: istore 5
    //   758: goto -177 -> 581
    //   761: astore_1
    //   762: iload 6
    //   764: istore 5
    //   766: iconst_1
    //   767: istore 6
    //   769: goto -188 -> 581
    //   772: iload 8
    //   774: istore 5
    //   776: iload 9
    //   778: istore 6
    //   780: goto -435 -> 345
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	783	0	this	anri
    //   0	783	1	paramToServiceMsg	ToServiceMsg
    //   0	783	2	paramFromServiceMsg	FromServiceMsg
    //   0	783	3	paramObject	Object
    //   260	249	4	i	int
    //   24	751	5	bool1	boolean
    //   75	704	6	bool2	boolean
    //   71	684	7	bool3	boolean
    //   62	711	8	bool4	boolean
    //   10	767	9	bool5	boolean
    //   1	513	10	bool6	boolean
    //   4	574	11	bool7	boolean
    //   7	657	12	bool8	boolean
    //   265	15	13	l	long
    // Exception table:
    //   from	to	target	type
    //   77	98	572	java/lang/Exception
    //   110	120	572	java/lang/Exception
    //   131	137	572	java/lang/Exception
    //   145	173	572	java/lang/Exception
    //   194	204	572	java/lang/Exception
    //   216	226	572	java/lang/Exception
    //   234	248	572	java/lang/Exception
    //   256	262	572	java/lang/Exception
    //   289	294	572	java/lang/Exception
    //   302	316	572	java/lang/Exception
    //   324	330	572	java/lang/Exception
    //   440	446	572	java/lang/Exception
    //   460	465	572	java/lang/Exception
    //   473	479	572	java/lang/Exception
    //   487	494	572	java/lang/Exception
    //   77	98	662	finally
    //   110	120	662	finally
    //   131	137	662	finally
    //   145	173	662	finally
    //   194	204	662	finally
    //   216	226	662	finally
    //   234	248	662	finally
    //   256	262	662	finally
    //   289	294	662	finally
    //   302	316	662	finally
    //   324	330	662	finally
    //   440	446	662	finally
    //   460	465	662	finally
    //   473	479	662	finally
    //   487	494	662	finally
    //   502	508	714	finally
    //   526	546	730	finally
    //   581	598	741	finally
    //   502	508	745	java/lang/Exception
    //   526	546	761	java/lang/Exception
  }
  
  private void z(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
        break label464;
      }
      bool3 = bool1;
    }
    label464:
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
            break label464;
          }
          bool3 = bool1;
          bool2 = bool1;
          if (!paramFromServiceMsg.bytes_bodybuffer.has()) {
            break label464;
          }
          bool3 = bool1;
          bool2 = bool1;
          if (paramFromServiceMsg.bytes_bodybuffer.get() == null) {
            break label464;
          }
          bool3 = bool1;
          i = ByteBuffer.wrap(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray()).getInt();
          if (i >= 0) {
            continue;
          }
          l = i + 4294967296L;
          bool2 = bool6;
          bool3 = bool1;
          if (this.app.getCurrentAccountUin().equals(String.valueOf(l)))
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
  
  public void A()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, String.format(Locale.getDefault(), "getBindPhoneCardExtInfo uin:" + this.app.getCurrentUin(), new Object[0]));
    }
    sendPbReq(makeOIDBPkg("OidbSvc.0xc33_42220", 3123, 0, new oidb_0xc33.ReqBody().toByteArray()));
  }
  
  public void B()
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
  
  public void C()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "getSelfTroopHonorSetting");
    }
    try
    {
      Object localObject = new oidb_0x5eb.ReqBody();
      long l = Long.parseLong(this.app.getCurrentAccountUin());
      ((oidb_0x5eb.ReqBody)localObject).rpt_uint64_uins.add(Long.valueOf(l));
      ((oidb_0x5eb.ReqBody)localObject).uint32_troophonor_switch.set(1);
      localObject = makeOIDBPkg("OidbSvc.0x5eb_22", 1515, 22, ((oidb_0x5eb.ReqBody)localObject).toByteArray());
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("uint32_troophonor_switch", true);
      localBundle.putString("reqUin", this.app.getCurrentAccountUin());
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
  
  public int a()
  {
    int i = BaseApplicationImpl.getApplication().getSharedPreferences(this.app.getCurrentAccountUin(), 0).getInt("e_add_friend_setting", 101);
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "getSelfAddFriendSettingValue  settingValue:" + i);
    }
    return i;
  }
  
  public anrl a(QQAppInterface paramQQAppInterface, anrm paramanrm)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, String.format("addCoverTransCallback app=%s callBack=%s", new Object[] { paramQQAppInterface, paramanrm }));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController == null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController = paramQQAppInterface.getTransFileController();
    }
    paramQQAppInterface = new anrl(paramanrm);
    paramQQAppInterface.addFilter(new Class[] { NearbyPeoplePhotoUploadProcessor.class });
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.addHandle(paramQQAppInterface);
    return paramQQAppInterface;
  }
  
  public ArrayList<CardProfile> a(int paramInt1, int paramInt2)
  {
    for (Object localObject1 = this.app.getEntityManagerFactory().createEntityManager();; localObject1 = null)
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
    EntityManager localEntityManager = this.app.getEntityManagerFactory().createEntityManager();
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
      ((ByteBuffer)localObject).putInt(bhbx.a(Long.parseLong(this.app.getCurrentAccountUin()))).put((byte)0).putShort((short)1).putShort((short)27240).putShort((short)4).putInt(paramInt);
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
  
  public void a(long paramLong, anro paramanro)
  {
    NowLiveGallary.ReqBody localReqBody = new NowLiveGallary.ReqBody();
    localReqBody.req_uin.set(paramLong);
    ntb.a(this.app, paramanro, localReqBody.toByteArray(), "ilive.photo_wall");
  }
  
  public void a(PushVoteIncreaseInfo paramPushVoteIncreaseInfo, String paramString1, String paramString2)
  {
    Visitor localVisitor = (Visitor)paramPushVoteIncreaseInfo.vVoterList.get(0);
    MessageRecord localMessageRecord = bcsa.a(-1000);
    localMessageRecord.frienduin = AppConstants.VOTE_MSG_UIN;
    localMessageRecord.istroop = 0;
    localMessageRecord.senderuin = String.valueOf(localVisitor.lUIN);
    localMessageRecord.extraflag = paramPushVoteIncreaseInfo.iIncrement;
    localMessageRecord.time = (System.currentTimeMillis() / 1000L);
    ThreadManager.post(new CardHandler.1(this, paramPushVoteIncreaseInfo.iIncrement, paramPushVoteIncreaseInfo.vVoterList), 8, null, false);
    try
    {
      Object localObject1 = new String(localVisitor.vecNick, "UTF8");
      localObject2 = localObject1;
      if (((String)localObject1).trim().length() == 0) {
        localObject2 = String.valueOf(localVisitor.lUIN);
      }
      if (1 == paramPushVoteIncreaseInfo.iIncrement)
      {
        localMessageRecord.msg = String.format(this.app.getApp().getApplicationContext().getString(2131692532), new Object[] { localObject2 });
        this.app.getMessageFacade().addMessage(localMessageRecord, paramString1);
        this.app.handleReceivedMessage(1, true, true);
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("newVoteCount", paramPushVoteIncreaseInfo.iIncrement);
        ((Bundle)localObject1).putString("sender", paramString2);
        ((Bundle)localObject1).putString("voteeUin", paramString1);
        ((Bundle)localObject1).putString("uin", paramString1);
        notifyUI(28, true, new Object[] { ((anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).c(this.app.getCurrentAccountUin()), localObject1 });
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
        localMessageRecord.msg = String.format(this.app.getApp().getApplicationContext().getString(2131692531), new Object[] { localObject2, Integer.valueOf(paramPushVoteIncreaseInfo.iIncrement) });
      }
    }
  }
  
  public void a(Bundle paramBundle)
  {
    QLog.i("CardHandler", 1, "setDetailUserInfo");
    this.app.execute(new CardHandler.2(this, paramBundle));
  }
  
  public void a(anrl paramanrl)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, String.format("removeCoverTransCallback transHandler=%s", new Object[] { paramanrl }));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController != null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.removeHandle(paramanrl);
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
        ((HotChatManager)this.app.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).a(i);
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
    localTransferRequest.mPeerUin = this.mApp.getCurrentAccountUin();
    localTransferRequest.mUniseq = 0L;
    localTransferRequest.mFileType = 35;
    localTransferRequest.mRichTag = "actProfileCoverPicUpload";
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController != null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.transferAsync(localTransferRequest);
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
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "MCardSvc.ReqDelFace");
    localToServiceMsg.extraData.putLong("selfuin", Long.parseLong(this.app.getCurrentAccountUin()));
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
  
  public void a(String paramString1, String paramString2, byte paramByte, int paramInt)
  {
    paramString1 = new ToServiceMsg("mobileqq.service", paramString1, "MCardSvc.ReqHYMakeFriendsCard");
    paramString1.extraData.putString("friendUin", paramString2);
    paramString1.extraData.putByte("bReqType", paramByte);
    paramString1.extraData.putInt("uFaceTimeStamp", paramInt);
    send(paramString1);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, long paramLong1, byte paramByte1, long paramLong2, long paramLong3, byte[] paramArrayOfByte1, String paramString3, long paramLong4, int paramInt2, byte[] paramArrayOfByte2, byte paramByte2)
  {
    try
    {
      long l1 = Long.parseLong(paramString1);
      long l2 = Long.parseLong(paramString2);
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getSummaryCard()").append(",selfUin = ").append(paramString1).append(",comeFromType = ").append(paramInt1).append(",destUin = ").append(paramString2).append(",qzoneFeedTimeStamp = ").append(paramLong1).append(",isFriend = ").append(paramByte1).append(",troopCode = ").append(paramLong2).append(",troopUin = ").append(paramLong3).append(",vseed = ").append(paramArrayOfByte1).append(",strSearchName = ").append(paramString3).append(",lGetControl = ").append(paramLong4).append(",nAddFriendSource = ").append(paramInt2).append(", vSecureSig = ").append(paramArrayOfByte2);
        QLog.i("Q.profilecard.SummaryCard", 2, ((StringBuilder)localObject1).toString());
      }
      paramString1 = new ToServiceMsg("mobileqq.service", paramString1, "SummaryCard.ReqSummaryCard");
      paramString1.extraData.putLong("selfUin", l1);
      paramString1.extraData.putLong("targetUin", l2);
      paramString1.extraData.putInt("comeFromType", paramInt1);
      paramString1.extraData.putLong("qzoneFeedTimeStamp", paramLong1);
      paramString1.extraData.putByte("isFriend", paramByte1);
      paramString1.extraData.putLong("troopCode", paramLong2);
      paramString1.extraData.putLong("troopUin", paramLong3);
      paramString1.extraData.putByteArray("vSeed", paramArrayOfByte1);
      paramString1.extraData.putString("strSearchName", paramString3);
      paramString1.extraData.putLong("lGetControl", paramLong4);
      paramString1.extraData.putInt("EAddFriendSource", paramInt2);
      paramString1.extraData.putByteArray("vSecureSig", paramArrayOfByte2);
      paramString1.extraData.putByte("bReqMedalWallInfo", paramByte2);
      paramString1.extraData.putByte("bReqExtendCard", (byte)1);
      if (this.app != null)
      {
        paramArrayOfByte1 = (TicketManager)this.app.getManager(2);
        if (paramArrayOfByte1 != null)
        {
          paramArrayOfByte1 = paramArrayOfByte1.getA2(String.valueOf(l1));
          paramString1.extraData.putString("msg_login_sig", paramArrayOfByte1);
        }
      }
      paramString3 = arkw.a();
      paramArrayOfByte1 = new ArrayList();
      if ((paramString3 != null) && (paramString3.a()))
      {
        paramString3 = new SummaryCardBusiEntry.CommonReq();
        paramArrayOfByte2 = new SummaryCardBusiEntry.VisitorCountReq();
        paramArrayOfByte2.operuin.set((int)l1);
        paramArrayOfByte2.requireuin.set((int)l2);
        paramArrayOfByte2.mod.set(0);
        paramArrayOfByte2.reportFlag.set(1);
        paramString3.vcReq.set(paramArrayOfByte2);
        paramString3.serviceCmd.set("profileVisitor.getVisitorCnt");
        paramArrayOfByte1.add(new BusinessBuff(15, paramString3.toByteArray()));
      }
      paramArrayOfByte2 = new VaProfileGate.OidbFlagInfo();
      paramString3 = new ArrayList();
      paramArrayOfByte2.uint32_fieled.set(42334);
      paramString3.add(paramArrayOfByte2);
      paramArrayOfByte2 = new VaProfileGate.OidbFlagInfo();
      paramArrayOfByte2.uint32_fieled.set(42340);
      paramString3.add(paramArrayOfByte2);
      paramArrayOfByte2 = new VaProfileGate.OidbFlagInfo();
      paramArrayOfByte2.uint32_fieled.set(42344);
      paramString3.add(paramArrayOfByte2);
      paramArrayOfByte2 = new VaProfileGate.OidbFlagInfo();
      paramArrayOfByte2.uint32_fieled.set(42354);
      paramString3.add(paramArrayOfByte2);
      paramArrayOfByte2 = new VaProfileGate.GetVipCareReq();
      paramArrayOfByte2.uint64_uin.set(l2);
      Object localObject1 = new VaProfileGate.CommTaskInfo();
      Object localObject2 = new VipMusicBox.GetProfileMusicBoxInfoReq();
      ((VipMusicBox.GetProfileMusicBoxInfoReq)localObject2).uin.set(l2);
      ((VaProfileGate.CommTaskInfo)localObject1).uint32_appid.set(4);
      ((VaProfileGate.CommTaskInfo)localObject1).bytes_task_data.set(ByteStringMicro.copyFrom(((VipMusicBox.GetProfileMusicBoxInfoReq)localObject2).toByteArray()));
      localObject2 = new VaProfileGate.VaProfileGateReq();
      VaProfileGate.PrivilegeBaseInfoReq localPrivilegeBaseInfoReq = new VaProfileGate.PrivilegeBaseInfoReq();
      VaProfileGate.GetGiftListReq localGetGiftListReq = new VaProfileGate.GetGiftListReq();
      ((VaProfileGate.VaProfileGateReq)localObject2).uCmd.set(3);
      localPrivilegeBaseInfoReq.uReqUin.set(l2);
      localGetGiftListReq.uin.set((int)l2);
      ((VaProfileGate.VaProfileGateReq)localObject2).stPrivilegeReq.set(localPrivilegeBaseInfoReq);
      ((VaProfileGate.VaProfileGateReq)localObject2).stGiftReq.set(localGetGiftListReq);
      ((VaProfileGate.VaProfileGateReq)localObject2).rpt_oidb_flag.set(paramString3);
      ((VaProfileGate.VaProfileGateReq)localObject2).st_vip_care.set(paramArrayOfByte2);
      ((VaProfileGate.VaProfileGateReq)localObject2).rpt_task_item.add((MessageMicro)localObject1);
      paramArrayOfByte1.add(new BusinessBuff(16, ((VaProfileGate.VaProfileGateReq)localObject2).toByteArray()));
      if (QLog.isColorLevel()) {
        QLog.d("DIYProfileTemplate.CardHandler", 1, "profile card request VASPROFILEGATE_SERVICE");
      }
      if (l2 > 0L)
      {
        if (QLog.isColorLevel()) {
          QLog.i("CardHandler", 1, "profile card request LIFE_ACHIEVEMENT_SERVICE and uin " + l2);
        }
        paramString3 = new oidb_0xe5b.ReqBody();
        paramString3.uint64_uin.set(l2);
        paramString3.uint32_max_count.set(10);
        paramString3.bool_req_achievement_content.set(false);
        paramArrayOfByte1.add(new BusinessBuff(18, paramString3.toByteArray()));
      }
      paramString3 = new oidb_0xec4.ReqBody();
      paramString3.uint64_uin.set(l2);
      paramString3.uint64_quest_num.set(10L);
      paramString3.uint32_fetch_type.set(1);
      paramArrayOfByte1.add(new BusinessBuff(19, paramString3.toByteArray()));
      if (paramArrayOfByte1.size() > 0) {
        paramString1.extraData.putParcelableArrayList("busiList", paramArrayOfByte1);
      }
      a(paramString1, this.app, paramString2);
      send(paramString1);
      return;
    }
    catch (NumberFormatException paramString1)
    {
      QLog.e("Q.profilecard.SummaryCard", 1, "getSummayCard fail.", paramString1);
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt, ArrayList<Integer> paramArrayList)
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
      send(paramString1);
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
    this.app.execute(new CardHandler.4(this));
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
        localObject3 = bcrx.a(((AutoReplyText)localObject3).getRawText(), null);
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
  
  public void a(List<Short> paramList, Bundle paramBundle)
  {
    a(paramList, paramBundle, this.app.getCurrentAccountUin());
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
      ((ByteBuffer)localObject).putInt(bhbx.a(Long.parseLong(this.app.getCurrentAccountUin()))).put((byte)0).putShort((short)1).putShort(paramShort1).putShort((short)2).putShort(paramShort2);
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
      long l = Long.parseLong(this.app.getCurrentAccountUin());
      short s = a(paramShort, paramBoolean);
      ((ByteBuffer)localObject).putInt(bhbx.a(l)).put((byte)0).putShort((short)1).putShort(paramShort).putShort((short)2).putShort(s);
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
        long l = Long.parseLong(this.app.getCurrentAccountUin());
        if (paramBoolean)
        {
          ((ByteBuffer)localObject).putInt(bhbx.a(l)).put((byte)0).putShort((short)1).putShort((short)paramInt).putShort((short)2).putShort(s);
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
    String str = aoks.b();
    aoks.a(null);
    Object localObject2;
    Object localObject1;
    if (paramBoolean)
    {
      localObject2 = this.app.getEntityManagerFactory().createEntityManager();
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
      this.app.updateSettingTableCache((Setting)localObject1);
      localObject1 = (anvk)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      localObject2 = ((bhou)this.app.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).a;
      Object localObject3 = this.app.getExtensionInfo(paramString, true);
      ((ExtensionInfo)localObject3).faceId = 0;
      ((ExtensionInfo)localObject3).faceIdUpdateTime = NetConnInfoCenter.getServerTime();
      ((ExtensionInfo)localObject3).setStatus(1000);
      ((anvk)localObject1).a((ExtensionInfo)localObject3);
      ((VasFaceManager)localObject2).a((ExtensionInfo)localObject3);
      localObject1 = this.app.getCustomFaceFilePath(false, this.app.getCurrentAccountUin());
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        FileUtils.deleteFile((String)localObject1);
      }
      localObject2 = aoks.a(paramString);
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        FileUtils.deleteFile((String)localObject2);
      }
      localObject3 = aoks.b(paramString);
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        FileUtils.deleteFile((String)localObject3);
      }
      aoks.a(this.app, paramString);
      this.app.removeFaceIconCache(1, paramString, 0);
      if (!TextUtils.isEmpty(str))
      {
        bheg.a(null, str, (String)localObject1, 140, 140);
        FileUtils.copyFile(str, (String)localObject2);
        this.app.sendSelfQQHeadBroadcast(1, paramString, 0, (String)localObject1);
      }
      if (!TextUtils.isEmpty(str)) {
        FileUtils.deleteFile(str);
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
    Object localObject = this.app.getPreferences();
    long l1 = ((SharedPreferences)localObject).getLong("sign_in_time_stamp", 0L);
    localObject = ((SharedPreferences)localObject).getString(this.app.getCurrentUin() + "sign_in_info", "");
    try
    {
      localObject = new JSONObject((String)localObject);
      int i = ((JSONObject)localObject).optInt("type");
      int j = ((JSONObject)localObject).optInt("redpoint");
      if (((JSONObject)localObject).optInt("openfunc") != 0)
      {
        long l2 = bcrg.a();
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
  
  public boolean a(Card paramCard, SparseArray<bcra> paramSparseArray)
  {
    Object localObject = arkw.a();
    if ((localObject != null) && (((arkv)localObject).a()) && (!((arkv)localObject).b()))
    {
      localObject = (bcra)paramSparseArray.get(15);
      if ((localObject != null) && (((bcra)localObject).a != null))
      {
        paramSparseArray = new SummaryCardBusiEntry.VisitorCountRsp();
        try
        {
          paramSparseArray.mergeFrom(((bcra)localObject).a);
          if (paramSparseArray.hotValue.get() > 0)
          {
            paramCard.lVoteCount = paramSparseArray.hotValue.get();
            paramCard.iVoteIncrement = paramSparseArray.redValue.get();
            return true;
          }
        }
        catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
        {
          for (;;)
          {
            localInvalidProtocolBufferMicroException.printStackTrace();
          }
        }
      }
    }
    return false;
  }
  
  public void b()
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1168);
    localOIDBSSOPkg.uint32_service_type.set(100);
    Object localObject = ByteBuffer.allocate(4);
    ((ByteBuffer)localObject).putInt((int)Long.parseLong(this.app.getCurrentAccountUin()));
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
      l();
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
    //   10: invokevirtual 100	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   13: ifeq +415 -> 428
    //   16: aload_3
    //   17: ifnull +411 -> 428
    //   20: iconst_1
    //   21: istore 5
    //   23: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +30 -> 56
    //   29: ldc 195
    //   31: iconst_2
    //   32: new 20	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   39: ldc_w 6727
    //   42: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: iload 5
    //   47: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   50: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: aload_0
    //   57: getfield 229	anri:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   60: invokevirtual 294	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   63: pop
    //   64: iload 5
    //   66: istore 8
    //   68: iload 5
    //   70: ifeq +534 -> 604
    //   73: iload 5
    //   75: istore 6
    //   77: iload 5
    //   79: istore 7
    //   81: new 117	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   84: dup
    //   85: invokespecial 118	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   88: aload_3
    //   89: checkcast 120	[B
    //   92: checkcast 120	[B
    //   95: invokevirtual 124	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   98: checkcast 117	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   101: astore_2
    //   102: iload 5
    //   104: istore 6
    //   106: iload 5
    //   108: istore 7
    //   110: aload_2
    //   111: getfield 128	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   114: invokevirtual 133	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   117: ifne +317 -> 434
    //   120: iconst_1
    //   121: istore 5
    //   123: iload 5
    //   125: istore 6
    //   127: iload 5
    //   129: istore 7
    //   131: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   134: ifeq +55 -> 189
    //   137: iload 5
    //   139: istore 6
    //   141: iload 5
    //   143: istore 7
    //   145: ldc_w 726
    //   148: iconst_2
    //   149: new 20	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   156: ldc_w 6729
    //   159: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: iload 5
    //   164: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   167: ldc_w 6731
    //   170: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: aload_2
    //   174: getfield 128	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   177: invokevirtual 133	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   180: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   183: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   186: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   189: iload 5
    //   191: istore 8
    //   193: iload 5
    //   195: ifeq +409 -> 604
    //   198: iload 5
    //   200: istore 6
    //   202: iload 5
    //   204: istore 7
    //   206: iload 5
    //   208: istore 8
    //   210: aload_2
    //   211: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   214: invokevirtual 147	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   217: ifeq +387 -> 604
    //   220: iload 5
    //   222: istore 6
    //   224: iload 5
    //   226: istore 7
    //   228: iload 5
    //   230: istore 8
    //   232: aload_2
    //   233: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   236: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   239: ifnull +365 -> 604
    //   242: iload 5
    //   244: istore 6
    //   246: iload 5
    //   248: istore 7
    //   250: aload_2
    //   251: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   254: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   257: invokevirtual 159	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   260: invokestatic 614	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   263: invokevirtual 617	java/nio/ByteBuffer:getInt	()I
    //   266: istore 4
    //   268: iload 4
    //   270: i2l
    //   271: lstore 12
    //   273: iload 4
    //   275: ifge +16 -> 291
    //   278: iload 4
    //   280: ldc_w 1063
    //   283: iand
    //   284: i2l
    //   285: ldc2_w 1064
    //   288: lor
    //   289: lstore 12
    //   291: iload 5
    //   293: istore 6
    //   295: iload 5
    //   297: istore 7
    //   299: aload_0
    //   300: getfield 229	anri:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   303: invokevirtual 294	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   306: lload 12
    //   308: invokestatic 680	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   311: invokevirtual 683	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   314: ifeq +126 -> 440
    //   317: iload 5
    //   319: istore 6
    //   321: iload 5
    //   323: istore 7
    //   325: aload_1
    //   326: getfield 600	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   329: ldc_w 799
    //   332: invokevirtual 803	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   335: istore 5
    //   337: iload 5
    //   339: istore 6
    //   341: iload 10
    //   343: istore 5
    //   345: iload 5
    //   347: istore 7
    //   349: iload 6
    //   351: istore 8
    //   353: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   356: ifeq +58 -> 414
    //   359: ldc_w 726
    //   362: iconst_2
    //   363: new 20	java/lang/StringBuilder
    //   366: dup
    //   367: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   370: ldc_w 6729
    //   373: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: iload 5
    //   378: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   381: ldc_w 742
    //   384: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: aload_1
    //   388: getfield 600	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   391: ldc_w 799
    //   394: invokevirtual 803	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   397: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   400: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   403: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   406: iload 6
    //   408: istore 8
    //   410: iload 5
    //   412: istore 7
    //   414: aload_0
    //   415: bipush 82
    //   417: iload 7
    //   419: iload 8
    //   421: invokestatic 180	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   424: invokevirtual 184	anri:notifyUI	(IZLjava/lang/Object;)V
    //   427: return
    //   428: iconst_0
    //   429: istore 5
    //   431: goto -408 -> 23
    //   434: iconst_0
    //   435: istore 5
    //   437: goto -314 -> 123
    //   440: iconst_0
    //   441: istore 5
    //   443: iload 11
    //   445: istore 6
    //   447: goto -102 -> 345
    //   450: astore_2
    //   451: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   454: ifeq +14 -> 468
    //   457: ldc_w 726
    //   460: iconst_2
    //   461: ldc_w 6733
    //   464: aload_2
    //   465: invokestatic 208	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   468: iload 6
    //   470: istore 7
    //   472: iload 9
    //   474: istore 8
    //   476: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   479: ifeq -65 -> 414
    //   482: ldc_w 726
    //   485: iconst_2
    //   486: new 20	java/lang/StringBuilder
    //   489: dup
    //   490: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   493: ldc_w 6729
    //   496: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: iload 6
    //   501: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   504: ldc_w 742
    //   507: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: aload_1
    //   511: getfield 600	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   514: ldc_w 799
    //   517: invokevirtual 803	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   520: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   523: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   526: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   529: iload 6
    //   531: istore 7
    //   533: iload 9
    //   535: istore 8
    //   537: goto -123 -> 414
    //   540: astore_2
    //   541: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   544: ifeq +50 -> 594
    //   547: ldc_w 726
    //   550: iconst_2
    //   551: new 20	java/lang/StringBuilder
    //   554: dup
    //   555: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   558: ldc_w 6729
    //   561: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: iload 7
    //   566: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   569: ldc_w 742
    //   572: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   575: aload_1
    //   576: getfield 600	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   579: ldc_w 799
    //   582: invokevirtual 803	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   585: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   588: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   591: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   594: aload_2
    //   595: athrow
    //   596: astore_2
    //   597: iload 6
    //   599: istore 7
    //   601: goto -60 -> 541
    //   604: iload 8
    //   606: istore 5
    //   608: iload 11
    //   610: istore 6
    //   612: goto -267 -> 345
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	615	0	this	anri
    //   0	615	1	paramToServiceMsg	ToServiceMsg
    //   0	615	2	paramFromServiceMsg	FromServiceMsg
    //   0	615	3	paramObject	Object
    //   266	18	4	i	int
    //   21	586	5	bool1	boolean
    //   75	536	6	bool2	boolean
    //   79	521	7	bool3	boolean
    //   66	539	8	bool4	boolean
    //   4	530	9	bool5	boolean
    //   1	341	10	bool6	boolean
    //   7	602	11	bool7	boolean
    //   271	36	12	l	long
    // Exception table:
    //   from	to	target	type
    //   81	102	450	java/lang/Exception
    //   110	120	450	java/lang/Exception
    //   131	137	450	java/lang/Exception
    //   145	189	450	java/lang/Exception
    //   210	220	450	java/lang/Exception
    //   232	242	450	java/lang/Exception
    //   250	268	450	java/lang/Exception
    //   299	317	450	java/lang/Exception
    //   325	337	450	java/lang/Exception
    //   81	102	540	finally
    //   110	120	540	finally
    //   131	137	540	finally
    //   145	189	540	finally
    //   210	220	540	finally
    //   232	242	540	finally
    //   250	268	540	finally
    //   299	317	540	finally
    //   325	337	540	finally
    //   451	468	596	finally
  }
  
  public void b(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
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
  
  /* Error */
  protected void b(String paramString, List<CardProfile> paramList)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnull +82 -> 83
    //   4: aload_2
    //   5: invokeinterface 404 1 0
    //   10: ifle +73 -> 83
    //   13: aload_0
    //   14: getfield 229	anri:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   17: invokevirtual 1361	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   20: invokevirtual 1367	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   23: astore_1
    //   24: aload_1
    //   25: ifnull +58 -> 83
    //   28: aload_1
    //   29: invokevirtual 6011	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   32: invokevirtual 6016	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   35: aload_2
    //   36: invokeinterface 1563 1 0
    //   41: astore_2
    //   42: aload_2
    //   43: invokeinterface 1568 1 0
    //   48: ifeq +36 -> 84
    //   51: aload_1
    //   52: aload_2
    //   53: invokeinterface 1572 1 0
    //   58: checkcast 4632	com/tencent/mobileqq/data/CardProfile
    //   61: invokevirtual 1395	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   64: goto -22 -> 42
    //   67: astore_2
    //   68: aload_2
    //   69: invokevirtual 1131	java/lang/Exception:printStackTrace	()V
    //   72: aload_1
    //   73: invokevirtual 6011	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   76: invokevirtual 6036	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   79: aload_1
    //   80: invokevirtual 1398	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   83: return
    //   84: aload_1
    //   85: invokevirtual 6011	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   88: invokevirtual 6033	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   91: aload_1
    //   92: invokevirtual 6011	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   95: invokevirtual 6036	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   98: aload_1
    //   99: invokevirtual 1398	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   102: return
    //   103: astore_2
    //   104: aload_1
    //   105: invokevirtual 6011	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   108: invokevirtual 6036	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   111: aload_1
    //   112: invokevirtual 1398	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   115: aload_2
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	anri
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
    FileUtils.writeObject(this.app.getCurrentUin() + "_todayVoters", paramList);
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
        long l = Long.parseLong(this.app.getCurrentAccountUin());
        if (paramBoolean == true)
        {
          ((ByteBuffer)localObject).putInt(bhbx.a(l)).put((byte)0).putShort((short)1).putShort((short)-25042).putShort((short)2).putShort(s);
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
        Object localObject1 = this.app.getNowLiveManager().a();
        int j = Integer.valueOf("" + ((String)localObject1).charAt(2)).intValue();
        localObject1 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1279);
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(9);
        Object localObject2 = ByteBuffer.allocate(19);
        long l = Long.parseLong(this.app.getCurrentAccountUin());
        if (paramBoolean1 == true)
        {
          s = 0;
          ByteBuffer localByteBuffer = ((ByteBuffer)localObject2).putInt(bhbx.a(l)).put((byte)0).putShort((short)2).putShort((short)-25217).putShort((short)2).putShort(s).putShort((short)-23476).putShort((short)2);
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
    return this.app.getApp().getSharedPreferences("task_entry_config" + this.app.getCurrentAccountUin(), 0).getBoolean("open", false);
  }
  
  public void c(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("DailySignIn", 2, "getSigninRedTouch svrType=" + paramInt);
    }
    cmd0x922.ReqBody localReqBody = new cmd0x922.ReqBody();
    SharedPreferences localSharedPreferences = this.app.getPreferences();
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
      this.app.getCurrentAccountUin();
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
              if (!this.app.getCurrentAccountUin().equals(String.valueOf(l))) {
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
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "getLoginDaysSwitch " + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("Q.profilecard.", 2, "getLoginDaysSwitch with uin but uin is empty");
    }
    do
    {
      return;
      try
      {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(Short.valueOf(this.jdField_b_of_type_Short));
        Bundle localBundle = new Bundle();
        localBundle.putBoolean("isGetLoginDays", true);
        localBundle.putString("switchUin", paramString);
        a(localArrayList, localBundle, paramString);
        return;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.d("Q.profilecard.", 2, "getLoginDaysSwitch ex", paramString);
  }
  
  public void c(List<Long> paramList)
  {
    Object localObject = FileUtils.readObject(this.app.getCurrentUin() + "_todayVoters");
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
        long l = Long.parseLong(this.app.getCurrentAccountUin());
        if (paramBoolean == true)
        {
          ((ByteBuffer)localObject).putInt(bhbx.a(l)).put((byte)0).putShort((short)1).putShort((short)-23234).putShort((short)2).putShort(s);
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
  
  @Deprecated
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.i("CardHandler", 2, "getSimpleCardInfoForLogin");
    }
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
    localArrayList.add(Short.valueOf((short)-23306));
    localArrayList.add(Short.valueOf((short)27206));
    localArrayList.add(Short.valueOf((short)27210));
    localArrayList.add(Short.valueOf((short)-23543));
    if (this.app.getPreferences().getInt("nearby_people_profile_ok_new", -1) != 1) {
      localArrayList.add(Short.valueOf((short)-25040));
    }
    if (((Integer)axqc.a(this.app.getAccount(), "nearby_people_avatar_upload_ok", Integer.valueOf(-1))).intValue() != 1) {
      localArrayList.add(Short.valueOf((short)-23549));
    }
    localArrayList.add(Short.valueOf((short)-23538));
    localArrayList.add(Short.valueOf((short)-25042));
    localArrayList.add(Short.valueOf((short)-25181));
    localArrayList.add(Short.valueOf((short)-23502));
    localArrayList.add(Short.valueOf((short)-23461));
    localArrayList.add(Short.valueOf((short)-25188));
    localArrayList.add(Short.valueOf((short)-23282));
    localArrayList.add(Short.valueOf((short)-25155));
    localArrayList.add(Short.valueOf((short)-23456));
    localArrayList.add(Short.valueOf((short)-23366));
    localArrayList.add(Short.valueOf((short)-23365));
    localArrayList.add(Short.valueOf((short)-23364));
    localArrayList.add(Short.valueOf((short)-23322));
    localArrayList.add(Short.valueOf((short)-23326));
    localArrayList.add(Short.valueOf((short)-23325));
    aozr localaozr = (aozr)this.app.getManager(QQManagerFactory.CLASSIC_HEAD_ACIVITY_MANAGER);
    if ((localaozr != null) && (localaozr.a()))
    {
      localArrayList.add(Short.valueOf((short)-23437));
      localArrayList.add(Short.valueOf((short)20015));
    }
    localArrayList.add(Short.valueOf((short)27245));
    localArrayList.add(Short.valueOf((short)-23332));
    localArrayList.add(Short.valueOf((short)-23308));
    localArrayList.add(Short.valueOf((short)-23309));
    localArrayList.add(Short.valueOf((short)-23310));
    localArrayList.add(Short.valueOf((short)-23166));
    localArrayList.add(Short.valueOf((short)-23312));
    localArrayList.add(Short.valueOf((short)-23168));
    localArrayList.add(Short.valueOf((short)-23158));
    localArrayList.add(Short.valueOf((short)-23161));
    localArrayList.add(Short.valueOf((short)-23249));
    localArrayList.add(Short.valueOf((short)-23221));
    localArrayList.add(Short.valueOf((short)-23172));
    localArrayList.add(Short.valueOf((short)-23046));
    localArrayList.add(Short.valueOf((short)-23106));
    localArrayList.add(Short.valueOf((short)-23108));
    localArrayList.add(Short.valueOf((short)-23107));
    localArrayList.add(Short.valueOf((short)-23143));
    localArrayList.add(Short.valueOf((short)-23103));
    localArrayList.add(Short.valueOf((short)-23102));
    localArrayList.add(Short.valueOf((short)27390));
    a(localArrayList, null);
  }
  
  public void d(int paramInt)
  {
    Object localObject = BaseApplicationImpl.getApplication().getSharedPreferences(this.app.getCurrentAccountUin(), 0);
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
    //   10: invokevirtual 100	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   13: ifeq +403 -> 416
    //   16: aload_3
    //   17: ifnull +399 -> 416
    //   20: iconst_1
    //   21: istore 5
    //   23: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +30 -> 56
    //   29: ldc 195
    //   31: iconst_2
    //   32: new 20	java/lang/StringBuilder
    //   35: dup
    //   36: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   39: ldc_w 6834
    //   42: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: iload 5
    //   47: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   50: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: aload_0
    //   57: getfield 229	anri:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   60: invokevirtual 294	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   63: pop
    //   64: iload 5
    //   66: istore 8
    //   68: iload 5
    //   70: ifeq +522 -> 592
    //   73: iload 5
    //   75: istore 6
    //   77: iload 5
    //   79: istore 7
    //   81: new 117	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   84: dup
    //   85: invokespecial 118	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   88: aload_3
    //   89: checkcast 120	[B
    //   92: checkcast 120	[B
    //   95: invokevirtual 124	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   98: checkcast 117	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   101: astore_2
    //   102: aload_2
    //   103: ifnull +319 -> 422
    //   106: iload 5
    //   108: istore 6
    //   110: iload 5
    //   112: istore 7
    //   114: aload_2
    //   115: getfield 128	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   118: invokevirtual 133	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   121: ifne +301 -> 422
    //   124: iconst_1
    //   125: istore 5
    //   127: iload 5
    //   129: istore 6
    //   131: iload 5
    //   133: istore 7
    //   135: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   138: ifeq +39 -> 177
    //   141: iload 5
    //   143: istore 6
    //   145: iload 5
    //   147: istore 7
    //   149: ldc_w 726
    //   152: iconst_2
    //   153: new 20	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   160: ldc_w 6836
    //   163: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   166: iload 5
    //   168: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   171: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   174: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   177: iload 5
    //   179: istore 8
    //   181: iload 5
    //   183: ifeq +409 -> 592
    //   186: iload 5
    //   188: istore 6
    //   190: iload 5
    //   192: istore 7
    //   194: iload 5
    //   196: istore 8
    //   198: aload_2
    //   199: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   202: invokevirtual 147	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   205: ifeq +387 -> 592
    //   208: iload 5
    //   210: istore 6
    //   212: iload 5
    //   214: istore 7
    //   216: iload 5
    //   218: istore 8
    //   220: aload_2
    //   221: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   224: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   227: ifnull +365 -> 592
    //   230: iload 5
    //   232: istore 6
    //   234: iload 5
    //   236: istore 7
    //   238: aload_2
    //   239: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   242: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   245: invokevirtual 159	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   248: invokestatic 614	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   251: invokevirtual 617	java/nio/ByteBuffer:getInt	()I
    //   254: istore 4
    //   256: iload 4
    //   258: i2l
    //   259: lstore 12
    //   261: iload 4
    //   263: ifge +16 -> 279
    //   266: iload 4
    //   268: ldc_w 1063
    //   271: iand
    //   272: i2l
    //   273: ldc2_w 1064
    //   276: lor
    //   277: lstore 12
    //   279: iload 5
    //   281: istore 6
    //   283: iload 5
    //   285: istore 7
    //   287: aload_0
    //   288: getfield 229	anri:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   291: invokevirtual 294	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   294: lload 12
    //   296: invokestatic 680	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   299: invokevirtual 683	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   302: ifeq +126 -> 428
    //   305: iload 5
    //   307: istore 6
    //   309: iload 5
    //   311: istore 7
    //   313: aload_1
    //   314: getfield 600	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   317: ldc_w 799
    //   320: invokevirtual 803	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   323: istore 5
    //   325: iload 5
    //   327: istore 6
    //   329: iload 10
    //   331: istore 5
    //   333: iload 5
    //   335: istore 7
    //   337: iload 6
    //   339: istore 8
    //   341: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   344: ifeq +58 -> 402
    //   347: ldc_w 726
    //   350: iconst_2
    //   351: new 20	java/lang/StringBuilder
    //   354: dup
    //   355: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   358: ldc_w 6836
    //   361: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: iload 5
    //   366: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   369: ldc_w 742
    //   372: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: aload_1
    //   376: getfield 600	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   379: ldc_w 799
    //   382: invokevirtual 803	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   385: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   388: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   391: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   394: iload 6
    //   396: istore 8
    //   398: iload 5
    //   400: istore 7
    //   402: aload_0
    //   403: bipush 80
    //   405: iload 7
    //   407: iload 8
    //   409: invokestatic 180	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   412: invokevirtual 184	anri:notifyUI	(IZLjava/lang/Object;)V
    //   415: return
    //   416: iconst_0
    //   417: istore 5
    //   419: goto -396 -> 23
    //   422: iconst_0
    //   423: istore 5
    //   425: goto -298 -> 127
    //   428: iconst_0
    //   429: istore 5
    //   431: iload 11
    //   433: istore 6
    //   435: goto -102 -> 333
    //   438: astore_2
    //   439: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   442: ifeq +14 -> 456
    //   445: ldc_w 726
    //   448: iconst_2
    //   449: ldc_w 6838
    //   452: aload_2
    //   453: invokestatic 208	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   456: iload 6
    //   458: istore 7
    //   460: iload 9
    //   462: istore 8
    //   464: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   467: ifeq -65 -> 402
    //   470: ldc_w 726
    //   473: iconst_2
    //   474: new 20	java/lang/StringBuilder
    //   477: dup
    //   478: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   481: ldc_w 6836
    //   484: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: iload 6
    //   489: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   492: ldc_w 742
    //   495: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   498: aload_1
    //   499: getfield 600	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   502: ldc_w 799
    //   505: invokevirtual 803	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   508: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   511: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   514: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   517: iload 6
    //   519: istore 7
    //   521: iload 9
    //   523: istore 8
    //   525: goto -123 -> 402
    //   528: astore_2
    //   529: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   532: ifeq +50 -> 582
    //   535: ldc_w 726
    //   538: iconst_2
    //   539: new 20	java/lang/StringBuilder
    //   542: dup
    //   543: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   546: ldc_w 6836
    //   549: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: iload 7
    //   554: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   557: ldc_w 742
    //   560: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: aload_1
    //   564: getfield 600	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   567: ldc_w 799
    //   570: invokevirtual 803	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   573: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   576: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   579: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   582: aload_2
    //   583: athrow
    //   584: astore_2
    //   585: iload 6
    //   587: istore 7
    //   589: goto -60 -> 529
    //   592: iload 8
    //   594: istore 5
    //   596: iload 11
    //   598: istore 6
    //   600: goto -267 -> 333
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	603	0	this	anri
    //   0	603	1	paramToServiceMsg	ToServiceMsg
    //   0	603	2	paramFromServiceMsg	FromServiceMsg
    //   0	603	3	paramObject	Object
    //   254	18	4	i	int
    //   21	574	5	bool1	boolean
    //   75	524	6	bool2	boolean
    //   79	509	7	bool3	boolean
    //   66	527	8	bool4	boolean
    //   4	518	9	bool5	boolean
    //   1	329	10	bool6	boolean
    //   7	590	11	bool7	boolean
    //   259	36	12	l	long
    // Exception table:
    //   from	to	target	type
    //   81	102	438	java/lang/Exception
    //   114	124	438	java/lang/Exception
    //   135	141	438	java/lang/Exception
    //   149	177	438	java/lang/Exception
    //   198	208	438	java/lang/Exception
    //   220	230	438	java/lang/Exception
    //   238	256	438	java/lang/Exception
    //   287	305	438	java/lang/Exception
    //   313	325	438	java/lang/Exception
    //   81	102	528	finally
    //   114	124	528	finally
    //   135	141	528	finally
    //   149	177	528	finally
    //   198	208	528	finally
    //   220	230	528	finally
    //   238	256	528	finally
    //   287	305	528	finally
    //   313	325	528	finally
    //   439	456	584	finally
  }
  
  public void d(String paramString)
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
        long l = Long.parseLong(this.app.getCurrentAccountUin());
        if (paramBoolean == true)
        {
          ((ByteBuffer)localObject).putInt(bhbx.a(l)).put((byte)0).putShort((short)1).putShort((short)-25181).putShort((short)2).putShort(s);
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
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Short.valueOf((short)-24980));
    localArrayList.add(Short.valueOf((short)-23437));
    localArrayList.add(Short.valueOf((short)20015));
    a(localArrayList, null);
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
        break label817;
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
              break label817;
            }
            bool3 = bool1;
            bool4 = bool1;
            bool2 = bool1;
            if (!paramToServiceMsg.bytes_bodybuffer.has()) {
              break label817;
            }
            bool3 = bool1;
            bool4 = bool1;
            bool2 = bool1;
            if (paramToServiceMsg.bytes_bodybuffer.get() == null) {
              break label817;
            }
            bool3 = bool1;
            bool4 = bool1;
            l = bhbx.a(ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray()).getInt());
            bool3 = bool1;
            bool4 = bool1;
            if (!this.app.getCurrentAccountUin().equals(String.valueOf(l))) {
              continue;
            }
            bool2 = bool1;
            if (i < 0) {
              break label817;
            }
            if (j != 42318) {
              continue;
            }
            bool3 = bool1;
            bool4 = bool1;
            paramToServiceMsg = this.app.getCurrentUin();
            bool3 = bool1;
            bool4 = bool1;
            paramFromServiceMsg = this.app.getApp().getApplicationContext();
            if (i == 1) {
              continue;
            }
            bool2 = bool6;
            bool3 = bool1;
            bool4 = bool1;
            aomh.a(paramToServiceMsg, paramFromServiceMsg, bool2);
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
          paramToServiceMsg = this.app.getCurrentUin();
          bool3 = bool1;
          bool4 = bool1;
          paramFromServiceMsg = this.app.getApp().getApplicationContext();
          if (i != 1)
          {
            bool2 = bool7;
            bool3 = bool1;
            bool4 = bool1;
            aomh.b(paramToServiceMsg, paramFromServiceMsg, bool2);
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
            QLog.d("Q.profilecard.", 2, "handleHiddenSessionRes cur:" + this.app.getCurrentAccountUin() + " dwUin:" + l);
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
      label817:
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
      long l = Long.parseLong(this.app.getCurrentAccountUin());
      if (paramBoolean) {
        s = 0;
      }
      ((ByteBuffer)localObject).putInt(bhbx.a(l)).put((byte)0).putShort((short)1).putShort((short)-23332).putShort((short)2).putShort(s);
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
    localArrayList.add(Short.valueOf((short)-23408));
    localArrayList.add(Short.valueOf((short)-23213));
    localArrayList.add(Short.valueOf((short)-23196));
    localArrayList.add(Short.valueOf((short)-23180));
    localArrayList.add(Short.valueOf((short)-23175));
    localArrayList.add(Short.valueOf((short)-23169));
    localArrayList.add(Short.valueOf((short)-23159));
    localArrayList.add(Short.valueOf((short)-23364));
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("reqFromDetailActivity", true);
    a(localArrayList, localBundle);
  }
  
  /* Error */
  public void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 100	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: ifeq +435 -> 439
    //   7: aload_3
    //   8: ifnull +431 -> 439
    //   11: iconst_1
    //   12: istore 5
    //   14: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   17: ifeq +31 -> 48
    //   20: ldc_w 726
    //   23: iconst_2
    //   24: new 20	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   31: ldc_w 6867
    //   34: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: iload 5
    //   39: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   42: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: aload_1
    //   49: getfield 600	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   52: ldc_w 6055
    //   55: ldc_w 256
    //   58: invokevirtual 957	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   61: astore_2
    //   62: aload_1
    //   63: getfield 600	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   66: ldc_w 956
    //   69: ldc_w 256
    //   72: invokevirtual 957	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   75: astore 11
    //   77: iload 5
    //   79: istore 6
    //   81: iload 5
    //   83: ifeq +281 -> 364
    //   86: iload 5
    //   88: istore 7
    //   90: iload 5
    //   92: istore 8
    //   94: new 117	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   97: dup
    //   98: invokespecial 118	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   101: aload_3
    //   102: checkcast 120	[B
    //   105: checkcast 120	[B
    //   108: invokevirtual 124	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   111: checkcast 117	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   114: astore_3
    //   115: aload_3
    //   116: ifnull +329 -> 445
    //   119: iload 5
    //   121: istore 7
    //   123: iload 5
    //   125: istore 8
    //   127: aload_3
    //   128: getfield 128	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   131: invokevirtual 133	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   134: ifne +311 -> 445
    //   137: iconst_1
    //   138: istore 5
    //   140: iload 5
    //   142: istore 7
    //   144: iload 5
    //   146: istore 8
    //   148: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   151: ifeq +39 -> 190
    //   154: iload 5
    //   156: istore 7
    //   158: iload 5
    //   160: istore 8
    //   162: ldc_w 726
    //   165: iconst_2
    //   166: new 20	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   173: ldc_w 6869
    //   176: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: iload 5
    //   181: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   184: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   190: iload 5
    //   192: istore 6
    //   194: iload 5
    //   196: ifeq +168 -> 364
    //   199: iload 5
    //   201: istore 6
    //   203: iload 5
    //   205: istore 7
    //   207: iload 5
    //   209: istore 8
    //   211: aload_3
    //   212: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   215: invokevirtual 147	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   218: ifeq +146 -> 364
    //   221: iload 5
    //   223: istore 6
    //   225: iload 5
    //   227: istore 7
    //   229: iload 5
    //   231: istore 8
    //   233: aload_3
    //   234: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   237: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   240: ifnull +124 -> 364
    //   243: iload 5
    //   245: istore 7
    //   247: iload 5
    //   249: istore 8
    //   251: aload_3
    //   252: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   255: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   258: invokevirtual 159	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   261: invokestatic 614	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   264: invokevirtual 617	java/nio/ByteBuffer:getInt	()I
    //   267: invokestatic 1024	bhbx:a	(I)J
    //   270: lstore 9
    //   272: iload 5
    //   274: istore 7
    //   276: iload 5
    //   278: istore 8
    //   280: aload_0
    //   281: getfield 229	anri:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   284: invokevirtual 294	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   287: lload 9
    //   289: invokestatic 680	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   292: invokevirtual 683	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   295: ifeq +156 -> 451
    //   298: iload 5
    //   300: istore 7
    //   302: iload 5
    //   304: istore 8
    //   306: aload_1
    //   307: getfield 600	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   310: ldc_w 6053
    //   313: ldc_w 1063
    //   316: invokevirtual 6845	android/os/Bundle:getInt	(Ljava/lang/String;I)I
    //   319: istore 4
    //   321: iload 5
    //   323: istore 6
    //   325: iload 4
    //   327: iflt +37 -> 364
    //   330: iload 5
    //   332: istore 7
    //   334: iload 5
    //   336: istore 8
    //   338: aload_0
    //   339: getfield 689	anri:mApp	Lcom/tencent/common/app/AppInterface;
    //   342: invokevirtual 939	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   345: invokevirtual 942	mqq/app/MobileQQ:getApplicationContext	()Landroid/content/Context;
    //   348: aconst_null
    //   349: ldc_w 966
    //   352: ldc_w 968
    //   355: iload 4
    //   357: invokestatic 974	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:writeValueForInt	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   360: iload 5
    //   362: istore 6
    //   364: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   367: ifeq +50 -> 417
    //   370: ldc_w 726
    //   373: iconst_2
    //   374: new 20	java/lang/StringBuilder
    //   377: dup
    //   378: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   381: ldc_w 6869
    //   384: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: iload 6
    //   389: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   392: ldc_w 742
    //   395: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   398: aload_1
    //   399: getfield 600	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   402: ldc_w 799
    //   405: invokevirtual 803	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   408: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   411: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   414: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   417: aload_0
    //   418: bipush 96
    //   420: iload 6
    //   422: iconst_2
    //   423: anewarray 262	java/lang/String
    //   426: dup
    //   427: iconst_0
    //   428: aload_2
    //   429: aastore
    //   430: dup
    //   431: iconst_1
    //   432: aload 11
    //   434: aastore
    //   435: invokevirtual 184	anri:notifyUI	(IZLjava/lang/Object;)V
    //   438: return
    //   439: iconst_0
    //   440: istore 5
    //   442: goto -428 -> 14
    //   445: iconst_0
    //   446: istore 5
    //   448: goto -308 -> 140
    //   451: iload 5
    //   453: istore 7
    //   455: iload 5
    //   457: istore 8
    //   459: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   462: ifeq +55 -> 517
    //   465: iload 5
    //   467: istore 7
    //   469: iload 5
    //   471: istore 8
    //   473: ldc_w 726
    //   476: iconst_2
    //   477: new 20	java/lang/StringBuilder
    //   480: dup
    //   481: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   484: ldc_w 6871
    //   487: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   490: aload_0
    //   491: getfield 229	anri:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   494: invokevirtual 294	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   497: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   500: ldc_w 1028
    //   503: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: lload 9
    //   508: invokevirtual 840	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   511: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   514: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   517: iconst_0
    //   518: istore 6
    //   520: goto -156 -> 364
    //   523: astore_3
    //   524: iload 7
    //   526: istore 8
    //   528: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   531: ifeq +18 -> 549
    //   534: iload 7
    //   536: istore 8
    //   538: ldc_w 726
    //   541: iconst_2
    //   542: ldc_w 6873
    //   545: aload_3
    //   546: invokestatic 208	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   549: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   552: ifeq +49 -> 601
    //   555: ldc_w 726
    //   558: iconst_2
    //   559: new 20	java/lang/StringBuilder
    //   562: dup
    //   563: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   566: ldc_w 6869
    //   569: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: iconst_0
    //   573: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   576: ldc_w 742
    //   579: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   582: aload_1
    //   583: getfield 600	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   586: ldc_w 799
    //   589: invokevirtual 803	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   592: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   595: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   598: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   601: aload_0
    //   602: bipush 96
    //   604: iconst_0
    //   605: iconst_2
    //   606: anewarray 262	java/lang/String
    //   609: dup
    //   610: iconst_0
    //   611: aload_2
    //   612: aastore
    //   613: dup
    //   614: iconst_1
    //   615: aload 11
    //   617: aastore
    //   618: invokevirtual 184	anri:notifyUI	(IZLjava/lang/Object;)V
    //   621: return
    //   622: astore_3
    //   623: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   626: ifeq +50 -> 676
    //   629: ldc_w 726
    //   632: iconst_2
    //   633: new 20	java/lang/StringBuilder
    //   636: dup
    //   637: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   640: ldc_w 6869
    //   643: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   646: iload 8
    //   648: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   651: ldc_w 742
    //   654: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   657: aload_1
    //   658: getfield 600	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   661: ldc_w 799
    //   664: invokevirtual 803	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   667: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   670: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   673: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   676: aload_0
    //   677: bipush 96
    //   679: iload 8
    //   681: iconst_2
    //   682: anewarray 262	java/lang/String
    //   685: dup
    //   686: iconst_0
    //   687: aload_2
    //   688: aastore
    //   689: dup
    //   690: iconst_1
    //   691: aload 11
    //   693: aastore
    //   694: invokevirtual 184	anri:notifyUI	(IZLjava/lang/Object;)V
    //   697: aload_3
    //   698: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	699	0	this	anri
    //   0	699	1	paramToServiceMsg	ToServiceMsg
    //   0	699	2	paramFromServiceMsg	FromServiceMsg
    //   0	699	3	paramObject	Object
    //   319	37	4	i	int
    //   12	458	5	bool1	boolean
    //   79	440	6	bool2	boolean
    //   88	447	7	bool3	boolean
    //   92	588	8	bool4	boolean
    //   270	237	9	l	long
    //   75	617	11	str	String
    // Exception table:
    //   from	to	target	type
    //   94	115	523	java/lang/Exception
    //   127	137	523	java/lang/Exception
    //   148	154	523	java/lang/Exception
    //   162	190	523	java/lang/Exception
    //   211	221	523	java/lang/Exception
    //   233	243	523	java/lang/Exception
    //   251	272	523	java/lang/Exception
    //   280	298	523	java/lang/Exception
    //   306	321	523	java/lang/Exception
    //   338	360	523	java/lang/Exception
    //   459	465	523	java/lang/Exception
    //   473	517	523	java/lang/Exception
    //   94	115	622	finally
    //   127	137	622	finally
    //   148	154	622	finally
    //   162	190	622	finally
    //   211	221	622	finally
    //   233	243	622	finally
    //   251	272	622	finally
    //   280	298	622	finally
    //   306	321	622	finally
    //   338	360	622	finally
    //   459	465	622	finally
    //   473	517	622	finally
    //   528	534	622	finally
    //   538	549	622	finally
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
        long l = Long.parseLong(this.app.getCurrentAccountUin());
        if (paramBoolean)
        {
          ((ByteBuffer)localObject).putInt(bhbx.a(l)).put((byte)0).putShort((short)1).putShort((short)-25186).putShort((short)2).putShort(s);
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
        break label546;
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
          break label546;
        }
        bool2 = bool1;
        bool3 = bool1;
        bool4 = bool1;
        if (!paramFromServiceMsg.bytes_bodybuffer.has()) {
          break label546;
        }
        bool2 = bool1;
        bool3 = bool1;
        bool4 = bool1;
        if (paramFromServiceMsg.bytes_bodybuffer.get() == null) {
          break label546;
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
        bool1 = this.app.getCurrentAccountUin().equals(String.valueOf(l));
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
      label546:
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
        long l = Long.parseLong(this.app.getCurrentAccountUin());
        if (paramBoolean)
        {
          ((ByteBuffer)localObject).putInt(bhbx.a(l)).put((byte)0).putShort((short)1).putShort((short)-23211).putShort((short)2).putShort(s);
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
  
  public void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "getCareBarEnable");
    }
    try
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Short.valueOf((short)-23234));
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("setCareBarEnable", true);
      a(localArrayList, localBundle);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("CardHandler", 2, "getCareBarEnable: failed. ", localException);
    }
  }
  
  /* Error */
  public void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 10
    //   3: aload_2
    //   4: ifnull +413 -> 417
    //   7: aload_2
    //   8: invokevirtual 107	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   11: sipush 1000
    //   14: if_icmpne +403 -> 417
    //   17: iconst_1
    //   18: istore 7
    //   20: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   23: ifeq +27 -> 50
    //   26: ldc 195
    //   28: iconst_2
    //   29: iconst_2
    //   30: anewarray 254	java/lang/Object
    //   33: dup
    //   34: iconst_0
    //   35: ldc_w 6906
    //   38: aastore
    //   39: dup
    //   40: iconst_1
    //   41: iload 7
    //   43: invokestatic 180	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   46: aastore
    //   47: invokestatic 912	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   50: iconst_m1
    //   51: istore 4
    //   53: iload 7
    //   55: istore 8
    //   57: iload 7
    //   59: ifeq +526 -> 585
    //   62: iload 7
    //   64: istore 9
    //   66: iload 7
    //   68: istore 8
    //   70: iload 4
    //   72: istore 5
    //   74: new 117	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   77: dup
    //   78: invokespecial 118	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   81: aload_3
    //   82: checkcast 120	[B
    //   85: checkcast 120	[B
    //   88: invokevirtual 124	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   91: checkcast 117	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   94: astore_1
    //   95: aload_1
    //   96: ifnull +327 -> 423
    //   99: iload 7
    //   101: istore 9
    //   103: iload 7
    //   105: istore 8
    //   107: iload 4
    //   109: istore 5
    //   111: aload_1
    //   112: getfield 128	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   115: invokevirtual 133	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   118: ifne +305 -> 423
    //   121: iconst_1
    //   122: istore 7
    //   124: iload 7
    //   126: istore 9
    //   128: iload 7
    //   130: istore 8
    //   132: iload 4
    //   134: istore 5
    //   136: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   139: ifeq +39 -> 178
    //   142: iload 7
    //   144: istore 9
    //   146: iload 7
    //   148: istore 8
    //   150: iload 4
    //   152: istore 5
    //   154: ldc 195
    //   156: iconst_2
    //   157: iconst_2
    //   158: anewarray 254	java/lang/Object
    //   161: dup
    //   162: iconst_0
    //   163: ldc_w 6908
    //   166: aastore
    //   167: dup
    //   168: iconst_1
    //   169: iload 7
    //   171: invokestatic 180	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   174: aastore
    //   175: invokestatic 912	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   178: iload 7
    //   180: ifeq +380 -> 560
    //   183: iload 7
    //   185: istore 9
    //   187: iload 7
    //   189: istore 8
    //   191: iload 4
    //   193: istore 5
    //   195: aload_1
    //   196: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   199: invokevirtual 147	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   202: ifeq +358 -> 560
    //   205: iload 7
    //   207: istore 9
    //   209: iload 7
    //   211: istore 8
    //   213: iload 4
    //   215: istore 5
    //   217: aload_1
    //   218: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   221: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   224: ifnull +336 -> 560
    //   227: iload 7
    //   229: istore 9
    //   231: iload 7
    //   233: istore 8
    //   235: iload 4
    //   237: istore 5
    //   239: aload_1
    //   240: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   243: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   246: invokevirtual 159	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   249: invokestatic 614	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   252: astore_1
    //   253: iload 7
    //   255: istore 9
    //   257: iload 7
    //   259: istore 8
    //   261: iload 4
    //   263: istore 5
    //   265: aload_1
    //   266: invokevirtual 617	java/nio/ByteBuffer:getInt	()I
    //   269: pop
    //   270: iload 7
    //   272: istore 9
    //   274: iload 7
    //   276: istore 8
    //   278: iload 4
    //   280: istore 5
    //   282: aload_1
    //   283: invokevirtual 620	java/nio/ByteBuffer:get	()B
    //   286: pop
    //   287: iload 7
    //   289: istore 9
    //   291: iload 7
    //   293: istore 8
    //   295: iload 4
    //   297: istore 5
    //   299: aload_1
    //   300: invokevirtual 624	java/nio/ByteBuffer:getShort	()S
    //   303: invokestatic 635	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   306: invokevirtual 740	java/lang/Short:shortValue	()S
    //   309: iconst_1
    //   310: if_icmpne +240 -> 550
    //   313: iload 7
    //   315: istore 9
    //   317: iload 7
    //   319: istore 8
    //   321: iload 4
    //   323: istore 5
    //   325: aload_1
    //   326: invokevirtual 624	java/nio/ByteBuffer:getShort	()S
    //   329: istore 6
    //   331: iload 6
    //   333: sipush -23449
    //   336: if_icmpeq +93 -> 429
    //   339: iconst_m1
    //   340: istore 4
    //   342: iload 10
    //   344: istore 7
    //   346: iload 4
    //   348: istore 5
    //   350: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   353: ifeq +45 -> 398
    //   356: ldc 195
    //   358: iconst_2
    //   359: new 20	java/lang/StringBuilder
    //   362: dup
    //   363: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   366: ldc_w 6908
    //   369: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: iload 7
    //   374: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   377: ldc_w 6910
    //   380: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: iload 4
    //   385: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   388: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   391: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   394: iload 4
    //   396: istore 5
    //   398: aload_0
    //   399: getfield 229	anri:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   402: getstatic 6913	com/tencent/mobileqq/app/QQManagerFactory:APP_GUIDE_TIPS_MANAGER	I
    //   405: invokevirtual 241	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   408: checkcast 6915	afpn
    //   411: iload 5
    //   413: invokevirtual 6916	afpn:a	(I)V
    //   416: return
    //   417: iconst_0
    //   418: istore 7
    //   420: goto -400 -> 20
    //   423: iconst_0
    //   424: istore 7
    //   426: goto -302 -> 124
    //   429: iload 7
    //   431: istore 9
    //   433: iload 7
    //   435: istore 8
    //   437: iload 4
    //   439: istore 5
    //   441: aload_1
    //   442: invokevirtual 624	java/nio/ByteBuffer:getShort	()S
    //   445: istore 6
    //   447: iload 6
    //   449: iconst_2
    //   450: if_icmpne +90 -> 540
    //   453: iload 7
    //   455: istore 9
    //   457: iload 7
    //   459: istore 8
    //   461: iload 4
    //   463: istore 5
    //   465: iload 6
    //   467: newarray byte
    //   469: astore_2
    //   470: iload 7
    //   472: istore 9
    //   474: iload 7
    //   476: istore 8
    //   478: iload 4
    //   480: istore 5
    //   482: aload_1
    //   483: aload_2
    //   484: invokevirtual 754	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   487: pop
    //   488: iload 7
    //   490: istore 9
    //   492: iload 7
    //   494: istore 8
    //   496: iload 4
    //   498: istore 5
    //   500: aload_2
    //   501: iconst_0
    //   502: invokestatic 759	bhbx:a	([BI)S
    //   505: istore 6
    //   507: iload 6
    //   509: istore 5
    //   511: aload_1
    //   512: invokevirtual 624	java/nio/ByteBuffer:getShort	()S
    //   515: istore 6
    //   517: iload 5
    //   519: istore 4
    //   521: iload 10
    //   523: istore 7
    //   525: iload 6
    //   527: ifne -181 -> 346
    //   530: iconst_1
    //   531: istore 7
    //   533: iload 5
    //   535: istore 4
    //   537: goto -191 -> 346
    //   540: iconst_m1
    //   541: istore 4
    //   543: iload 10
    //   545: istore 7
    //   547: goto -201 -> 346
    //   550: iconst_m1
    //   551: istore 4
    //   553: iload 10
    //   555: istore 7
    //   557: goto -211 -> 346
    //   560: iload 7
    //   562: istore 9
    //   564: iload 7
    //   566: istore 8
    //   568: iload 4
    //   570: istore 5
    //   572: ldc 195
    //   574: iconst_1
    //   575: ldc_w 6918
    //   578: invokestatic 115	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   581: iload 7
    //   583: istore 8
    //   585: iload 8
    //   587: istore 7
    //   589: goto -243 -> 346
    //   592: astore_1
    //   593: iload 9
    //   595: istore 7
    //   597: iload 7
    //   599: istore 8
    //   601: iload 4
    //   603: istore 5
    //   605: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   608: ifeq +34 -> 642
    //   611: iload 7
    //   613: istore 8
    //   615: iload 4
    //   617: istore 5
    //   619: ldc 195
    //   621: iconst_2
    //   622: iconst_2
    //   623: anewarray 254	java/lang/Object
    //   626: dup
    //   627: iconst_0
    //   628: ldc_w 6920
    //   631: aastore
    //   632: dup
    //   633: iconst_1
    //   634: aload_1
    //   635: invokevirtual 1136	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   638: aastore
    //   639: invokestatic 912	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   642: iload 4
    //   644: istore 5
    //   646: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   649: ifeq -251 -> 398
    //   652: ldc 195
    //   654: iconst_2
    //   655: new 20	java/lang/StringBuilder
    //   658: dup
    //   659: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   662: ldc_w 6908
    //   665: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: iload 7
    //   670: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   673: ldc_w 6910
    //   676: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   679: iload 4
    //   681: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   684: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   687: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   690: iload 4
    //   692: istore 5
    //   694: goto -296 -> 398
    //   697: astore_1
    //   698: iload 8
    //   700: istore 7
    //   702: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   705: ifeq +41 -> 746
    //   708: ldc 195
    //   710: iconst_2
    //   711: new 20	java/lang/StringBuilder
    //   714: dup
    //   715: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   718: ldc_w 6908
    //   721: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   724: iload 7
    //   726: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   729: ldc_w 6910
    //   732: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   735: iload 5
    //   737: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   740: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   743: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   746: aload_1
    //   747: athrow
    //   748: astore_1
    //   749: goto -47 -> 702
    //   752: astore_1
    //   753: iload 5
    //   755: istore 4
    //   757: goto -160 -> 597
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	760	0	this	anri
    //   0	760	1	paramToServiceMsg	ToServiceMsg
    //   0	760	2	paramFromServiceMsg	FromServiceMsg
    //   0	760	3	paramObject	Object
    //   51	705	4	i	int
    //   72	682	5	j	int
    //   329	197	6	k	int
    //   18	707	7	bool1	boolean
    //   55	644	8	bool2	boolean
    //   64	530	9	bool3	boolean
    //   1	553	10	bool4	boolean
    // Exception table:
    //   from	to	target	type
    //   74	95	592	java/lang/Exception
    //   111	121	592	java/lang/Exception
    //   136	142	592	java/lang/Exception
    //   154	178	592	java/lang/Exception
    //   195	205	592	java/lang/Exception
    //   217	227	592	java/lang/Exception
    //   239	253	592	java/lang/Exception
    //   265	270	592	java/lang/Exception
    //   282	287	592	java/lang/Exception
    //   299	313	592	java/lang/Exception
    //   325	331	592	java/lang/Exception
    //   441	447	592	java/lang/Exception
    //   465	470	592	java/lang/Exception
    //   482	488	592	java/lang/Exception
    //   500	507	592	java/lang/Exception
    //   572	581	592	java/lang/Exception
    //   74	95	697	finally
    //   111	121	697	finally
    //   136	142	697	finally
    //   154	178	697	finally
    //   195	205	697	finally
    //   217	227	697	finally
    //   239	253	697	finally
    //   265	270	697	finally
    //   282	287	697	finally
    //   299	313	697	finally
    //   325	331	697	finally
    //   441	447	697	finally
    //   465	470	697	finally
    //   482	488	697	finally
    //   500	507	697	finally
    //   572	581	697	finally
    //   605	611	697	finally
    //   619	642	697	finally
    //   511	517	748	finally
    //   511	517	752	java/lang/Exception
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
        long l = Long.parseLong(this.app.getCurrentAccountUin());
        if (paramBoolean)
        {
          ((ByteBuffer)localObject).putInt(bhbx.a(l)).put((byte)0).putShort((short)1).putShort((short)-23444).putShort((short)2).putShort(s);
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
        long l = Long.parseLong(this.app.getCurrentAccountUin());
        if (paramBoolean == true)
        {
          ((ByteBuffer)localObject).putInt(bhbx.a(l)).put((byte)0).putShort((short)1).putShort(this.jdField_b_of_type_Short).putShort((short)2).putShort(s);
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
    oidb_0x5eb.ReqBody localReqBody = new oidb_0x5eb.ReqBody();
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.add(Long.valueOf(Long.parseLong(this.app.getAccount())));
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
  
  public void j(boolean paramBoolean)
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
        long l = Long.parseLong(this.app.getCurrentAccountUin());
        if (paramBoolean == true)
        {
          ((ByteBuffer)localObject).putInt(bhbx.a(l)).put((byte)0).putShort((short)1).putShort(this.jdField_c_of_type_Short).putShort((short)2).putShort(s);
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
      QLog.d("CardHandler", 2, "getPartekeLikeRankingList");
    }
    oidb_0x5eb.ReqBody localReqBody = new oidb_0x5eb.ReqBody();
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.add(Long.valueOf(Long.parseLong(this.app.getAccount())));
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
        long l = Long.parseLong(this.app.getCurrentAccountUin());
        if (paramBoolean)
        {
          ((ByteBuffer)localObject).putInt(bhbx.a(l)).put((byte)0).putShort((short)1).putShort(this.jdField_d_of_type_Short).putShort((short)2).putShort(s);
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
      QLog.i("DailySignIn", 2, "getSigniOperat ");
    }
    sendPbReq(makeOIDBPkg("OidbSvc.0xe26", 3622, 0, new oidb_0xe26.ReqBody().toByteArray()));
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
        long l = Long.parseLong(this.app.getCurrentAccountUin());
        if (paramBoolean == true)
        {
          ((ByteBuffer)localObject).putInt(bhbx.a(l)).put((byte)0).putShort((short)1).putShort((short)-25031).putShort((short)2).putShort(s);
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
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "getNotifyOnLikeRankingList");
    }
    oidb_0x5eb.ReqBody localReqBody = new oidb_0x5eb.ReqBody();
    ArrayList localArrayList = new ArrayList();
    try
    {
      localArrayList.add(Long.valueOf(Long.parseLong(this.app.getAccount())));
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
        long l = Long.parseLong(this.app.getCurrentAccountUin());
        if (paramBoolean == true)
        {
          ((ByteBuffer)localObject).putInt(bhbx.a(l)).put((byte)0).putShort((short)1).putShort(this.e).putShort((short)2).putShort(s);
          localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
          localObject = createToServiceMsg("OidbSvc.0x4ff_9");
          ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
          ((ToServiceMsg)localObject).setTimeout(30000L);
          ((ToServiceMsg)localObject).extraData.putBoolean("switch", paramBoolean);
          ((ToServiceMsg)localObject).extraData.putBoolean("isSetBabyQSwitch", true);
          ((ToServiceMsg)localObject).extraData.putBoolean("reqFromCardHandler", true);
          sendPbReq((ToServiceMsg)localObject);
          if (paramBoolean) {
            this.app.getApp().getSharedPreferences(this.app.getCurrentAccountUin(), 0).edit().putInt("babyQ_drag_count", 0).commit();
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
  
  public boolean msgCmdFilter(String paramString)
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("SummaryCard.ReqSummaryCard");
      this.allowCmdSet.add("MCardSvc.ReqHYMakeFriendsCard");
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
      this.allowCmdSet.add("OidbSvc.0x480_9");
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
    return !this.allowCmdSet.contains(paramString);
  }
  
  public void n()
  {
    c(this.app.getCurrentUin());
  }
  
  public void n(boolean paramBoolean)
  {
    short s = 1;
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, "setDisplayThirdQQSwitch OPEN=" + paramBoolean);
    }
    try
    {
      long l = Long.parseLong(this.app.getCurrentAccountUin());
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
        long l = Long.parseLong(this.app.getCurrentAccountUin());
        if (paramBoolean)
        {
          ((ByteBuffer)localObject).putInt(bhbx.a(l)).put((byte)0).putShort((short)1).putShort((short)-23282).putShort((short)2).putShort(s);
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
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return CardObserver.class;
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
  
  public void p()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "getConnectionsSwitch");
    }
    try
    {
      oidb_0x5eb.ReqBody localReqBody = new oidb_0x5eb.ReqBody();
      localReqBody.rpt_uint64_uins.add(Long.valueOf(this.app.getLongAccountUin()));
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
  
  public void p(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("vip_ptt.CardHandler", 2, "setPttAuToTextOffLineSwitch:" + UIUtils.getStackTrace(30));
    }
    for (;;)
    {
      try
      {
        long l = Long.parseLong(this.app.getCurrentAccountUin());
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
  
  public void q()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "getHiddenSwitch");
    }
    try
    {
      oidb_0x5eb.ReqBody localReqBody = new oidb_0x5eb.ReqBody();
      long l = Long.parseLong(this.app.getCurrentAccountUin());
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
        long l = Long.parseLong(this.app.getCurrentAccountUin());
        if (paramBoolean)
        {
          ((ByteBuffer)localObject).putInt(bhbx.a(l)).put((byte)0).putShort((short)1).putShort((short)-23221).putShort((short)2).putShort(s);
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
  
  public void r()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "AfterSyncMsg doAfterLogin&doOnReconnect::sendGlobalRingIdRequest");
    }
    try
    {
      Object localObject = new oidb_0x5eb.ReqBody();
      long l = Long.parseLong(this.app.getCurrentAccountUin());
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
  
  public void s()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "getNotDisturb");
    }
    try
    {
      Object localObject = new oidb_0x5eb.ReqBody();
      long l = Long.parseLong(this.app.getCurrentAccountUin());
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
  
  public void t()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CardHandler", 2, "getSelfAddFriendSetting");
    }
    try
    {
      Object localObject = new oidb_0x5eb.ReqBody();
      long l = Long.parseLong(this.app.getCurrentAccountUin());
      ((oidb_0x5eb.ReqBody)localObject).rpt_uint64_uins.add(Long.valueOf(l));
      ((oidb_0x5eb.ReqBody)localObject).uint32_req_allow.set(1);
      localObject = makeOIDBPkg("OidbSvc.0x5eb_22", 1515, 22, ((oidb_0x5eb.ReqBody)localObject).toByteArray());
      Bundle localBundle = new Bundle();
      localBundle.putBoolean("uint32_req_allow", true);
      localBundle.putString("reqUin", this.app.getCurrentAccountUin());
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
  
  public void u()
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
  
  public void v()
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
  
  public void w()
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
  
  public void x()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("MedalWallMng", 4, "getSelfNewObtainedMedalWall");
    }
    try
    {
      l = Long.parseLong(this.app.getCurrentAccountUin());
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
  
  public void y()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Short.valueOf((short)-23370));
    a(localArrayList, null);
  }
  
  public void z()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Short.valueOf((short)-23221));
    a(localArrayList, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anri
 * JD-Core Version:    0.7.0.1
 */
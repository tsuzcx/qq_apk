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
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.CardHandler.1;
import com.tencent.mobileqq.app.CardHandler.2;
import com.tencent.mobileqq.app.CardHandler.4;
import com.tencent.mobileqq.app.CardObserver;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
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

public class amov
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
  
  public amov(QQAppInterface paramQQAppInterface)
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
        ((amsw)this.app.getManager(51)).a(paramToServiceMsg);
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
    ((PhotoWallUploadTask)???).vLoginData = ayqc.a(this.app);
    ((PhotoWallUploadTask)???).op = 1;
    ((PhotoWallUploadTask)???).source = 1;
    ((PhotoWallUploadTask)???).uploadTaskCallback = new amow(this);
    ((PhotoWallUploadTask)???).uploadFilePath = str2;
    ((PhotoWallUploadTask)???).md5 = ayqc.a(str2);
    ((PhotoWallUploadTask)???).autoRotate = true;
    amox localamox = new amox(this, Long.parseLong(this.app.getCurrentAccountUin()));
    UploadEnv localUploadEnv = new UploadEnv();
    if (!UploadServiceBuilder.getInstance().isInitialized()) {
      UploadServiceBuilder.getInstance().init(this.app.getApp().getApplicationContext(), localamox, null, null, localUploadEnv, localUploadEnv);
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
          break label960;
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
      label960:
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
          break label1402;
        }
        bool2 = bool1;
        bool3 = bool1;
        if (!paramToServiceMsg.bytes_bodybuffer.has()) {
          break label1402;
        }
        bool2 = bool1;
        bool3 = bool1;
        if (paramToServiceMsg.bytes_bodybuffer.get() == null) {
          break label1402;
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
          label1402:
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
        ((airj)this.mApp.getManager(295)).b(s2);
        ((amvo)this.app.getManager(159)).b();
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
    //   20: ldc_w 715
    //   23: iconst_2
    //   24: new 20	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   31: ldc_w 717
    //   34: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: iload 6
    //   39: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   42: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: aload_1
    //   49: getfield 595	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   52: ldc 68
    //   54: invokevirtual 719	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   57: astore_2
    //   58: aload_2
    //   59: invokestatic 262	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   62: ifeq +20 -> 82
    //   65: ldc_w 715
    //   68: iconst_2
    //   69: ldc_w 721
    //   72: invokestatic 115	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   75: return
    //   76: iconst_0
    //   77: istore 6
    //   79: goto -65 -> 14
    //   82: aload_0
    //   83: getfield 229	amov:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   86: bipush 51
    //   88: invokevirtual 235	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   91: checkcast 237	amsw
    //   94: astore_1
    //   95: aload_1
    //   96: aload_2
    //   97: invokevirtual 724	amsw:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   100: astore 10
    //   102: iload 6
    //   104: istore 9
    //   106: iload 6
    //   108: ifeq +684 -> 792
    //   111: iload 6
    //   113: istore 7
    //   115: iload 6
    //   117: istore 8
    //   119: new 117	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   122: dup
    //   123: invokespecial 118	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   126: aload_3
    //   127: checkcast 120	[B
    //   130: checkcast 120	[B
    //   133: invokevirtual 124	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   136: checkcast 117	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   139: astore_3
    //   140: aload_3
    //   141: ifnull +337 -> 478
    //   144: iload 6
    //   146: istore 7
    //   148: iload 6
    //   150: istore 8
    //   152: aload_3
    //   153: getfield 128	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   156: invokevirtual 133	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   159: ifne +319 -> 478
    //   162: iconst_1
    //   163: istore 6
    //   165: iload 6
    //   167: istore 7
    //   169: iload 6
    //   171: istore 8
    //   173: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   176: ifeq +39 -> 215
    //   179: iload 6
    //   181: istore 7
    //   183: iload 6
    //   185: istore 8
    //   187: ldc_w 715
    //   190: iconst_2
    //   191: new 20	java/lang/StringBuilder
    //   194: dup
    //   195: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   198: ldc_w 726
    //   201: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: iload 6
    //   206: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   209: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   212: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   215: iload 6
    //   217: istore 9
    //   219: iload 6
    //   221: ifeq +571 -> 792
    //   224: iload 6
    //   226: istore 7
    //   228: iload 6
    //   230: istore 8
    //   232: iload 6
    //   234: istore 9
    //   236: aload_3
    //   237: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   240: invokevirtual 147	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   243: ifeq +549 -> 792
    //   246: iload 6
    //   248: istore 7
    //   250: iload 6
    //   252: istore 8
    //   254: iload 6
    //   256: istore 9
    //   258: aload_3
    //   259: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   262: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   265: ifnull +527 -> 792
    //   268: iload 6
    //   270: istore 7
    //   272: iload 6
    //   274: istore 8
    //   276: aload_3
    //   277: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   280: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   283: invokevirtual 159	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   286: invokestatic 609	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   289: astore_3
    //   290: iload 6
    //   292: istore 7
    //   294: iload 6
    //   296: istore 8
    //   298: aload_3
    //   299: invokevirtual 612	java/nio/ByteBuffer:getInt	()I
    //   302: pop
    //   303: iload 6
    //   305: istore 7
    //   307: iload 6
    //   309: istore 8
    //   311: aload_3
    //   312: invokevirtual 615	java/nio/ByteBuffer:get	()B
    //   315: pop
    //   316: iload 6
    //   318: istore 7
    //   320: iload 6
    //   322: istore 8
    //   324: iload 6
    //   326: istore 9
    //   328: aload_3
    //   329: invokevirtual 619	java/nio/ByteBuffer:getShort	()S
    //   332: invokestatic 630	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   335: invokevirtual 729	java/lang/Short:shortValue	()S
    //   338: iconst_1
    //   339: if_icmpne +453 -> 792
    //   342: iload 6
    //   344: istore 7
    //   346: iload 6
    //   348: istore 8
    //   350: aload_3
    //   351: invokevirtual 619	java/nio/ByteBuffer:getShort	()S
    //   354: istore 4
    //   356: iload 6
    //   358: istore 7
    //   360: iload 6
    //   362: istore 8
    //   364: aload_0
    //   365: getfield 66	amov:jdField_b_of_type_Short	S
    //   368: istore 5
    //   370: iload 4
    //   372: iload 5
    //   374: if_icmpeq +110 -> 484
    //   377: iconst_0
    //   378: istore 6
    //   380: iload 6
    //   382: istore 7
    //   384: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   387: ifeq +59 -> 446
    //   390: ldc_w 715
    //   393: iconst_2
    //   394: new 20	java/lang/StringBuilder
    //   397: dup
    //   398: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   401: ldc_w 726
    //   404: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: iload 6
    //   409: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   412: ldc_w 731
    //   415: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: aload 10
    //   420: getfield 736	com/tencent/mobileqq/data/Card:allowPeopleSee	Z
    //   423: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   426: ldc_w 738
    //   429: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: aload_2
    //   433: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   439: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   442: iload 6
    //   444: istore 7
    //   446: aload_0
    //   447: bipush 44
    //   449: iload 7
    //   451: iconst_2
    //   452: anewarray 248	java/lang/Object
    //   455: dup
    //   456: iconst_0
    //   457: aload 10
    //   459: getfield 736	com/tencent/mobileqq/data/Card:allowPeopleSee	Z
    //   462: invokestatic 180	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   465: aastore
    //   466: dup
    //   467: iconst_1
    //   468: aload 10
    //   470: getfield 741	com/tencent/mobileqq/data/Card:uin	Ljava/lang/String;
    //   473: aastore
    //   474: invokevirtual 184	amov:notifyUI	(IZLjava/lang/Object;)V
    //   477: return
    //   478: iconst_0
    //   479: istore 6
    //   481: goto -316 -> 165
    //   484: iload 6
    //   486: istore 7
    //   488: iload 6
    //   490: istore 8
    //   492: aload_3
    //   493: invokevirtual 619	java/nio/ByteBuffer:getShort	()S
    //   496: istore 4
    //   498: iload 4
    //   500: iconst_2
    //   501: if_icmpne +111 -> 612
    //   504: iload 6
    //   506: istore 7
    //   508: iload 6
    //   510: istore 8
    //   512: iload 4
    //   514: newarray byte
    //   516: astore 11
    //   518: iload 6
    //   520: istore 7
    //   522: iload 6
    //   524: istore 8
    //   526: aload_3
    //   527: aload 11
    //   529: invokevirtual 743	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   532: pop
    //   533: iload 6
    //   535: istore 7
    //   537: iload 6
    //   539: istore 8
    //   541: aload 11
    //   543: iconst_0
    //   544: invokestatic 748	bftf:a	([BI)S
    //   547: ifne +46 -> 593
    //   550: iconst_0
    //   551: istore 9
    //   553: iload 6
    //   555: istore 7
    //   557: iload 6
    //   559: istore 8
    //   561: aload 10
    //   563: iload 9
    //   565: putfield 736	com/tencent/mobileqq/data/Card:allowPeopleSee	Z
    //   568: iload 6
    //   570: istore 7
    //   572: iload 6
    //   574: istore 8
    //   576: aload_3
    //   577: invokevirtual 619	java/nio/ByteBuffer:getShort	()S
    //   580: istore 4
    //   582: iload 4
    //   584: ifeq +15 -> 599
    //   587: iconst_0
    //   588: istore 6
    //   590: goto -210 -> 380
    //   593: iconst_1
    //   594: istore 9
    //   596: goto -43 -> 553
    //   599: aload_1
    //   600: aload 10
    //   602: invokevirtual 751	amsw:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   605: pop
    //   606: iconst_1
    //   607: istore 6
    //   609: goto -229 -> 380
    //   612: iconst_0
    //   613: istore 6
    //   615: goto -235 -> 380
    //   618: astore_1
    //   619: iload 7
    //   621: istore 6
    //   623: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   626: ifeq +14 -> 640
    //   629: ldc_w 715
    //   632: iconst_2
    //   633: ldc_w 753
    //   636: aload_1
    //   637: invokestatic 208	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   640: iload 6
    //   642: istore 7
    //   644: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   647: ifeq -201 -> 446
    //   650: ldc_w 715
    //   653: iconst_2
    //   654: new 20	java/lang/StringBuilder
    //   657: dup
    //   658: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   661: ldc_w 726
    //   664: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   667: iload 6
    //   669: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   672: ldc_w 731
    //   675: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   678: aload 10
    //   680: getfield 736	com/tencent/mobileqq/data/Card:allowPeopleSee	Z
    //   683: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   686: ldc_w 738
    //   689: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: aload_2
    //   693: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   696: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   699: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   702: iload 6
    //   704: istore 7
    //   706: goto -260 -> 446
    //   709: astore_1
    //   710: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   713: ifeq +55 -> 768
    //   716: ldc_w 715
    //   719: iconst_2
    //   720: new 20	java/lang/StringBuilder
    //   723: dup
    //   724: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   727: ldc_w 726
    //   730: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   733: iload 8
    //   735: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   738: ldc_w 731
    //   741: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   744: aload 10
    //   746: getfield 736	com/tencent/mobileqq/data/Card:allowPeopleSee	Z
    //   749: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   752: ldc_w 738
    //   755: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   758: aload_2
    //   759: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   762: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   765: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   768: aload_1
    //   769: athrow
    //   770: astore_1
    //   771: iconst_1
    //   772: istore 8
    //   774: goto -64 -> 710
    //   777: astore_1
    //   778: iload 6
    //   780: istore 8
    //   782: goto -72 -> 710
    //   785: astore_1
    //   786: iconst_1
    //   787: istore 6
    //   789: goto -166 -> 623
    //   792: iload 9
    //   794: istore 6
    //   796: goto -416 -> 380
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	799	0	this	amov
    //   0	799	1	paramToServiceMsg	ToServiceMsg
    //   0	799	2	paramFromServiceMsg	FromServiceMsg
    //   0	799	3	paramObject	Object
    //   354	229	4	i	int
    //   368	7	5	j	int
    //   12	783	6	bool1	boolean
    //   113	592	7	bool2	boolean
    //   117	664	8	bool3	boolean
    //   104	689	9	bool4	boolean
    //   100	645	10	localCard	Card
    //   516	26	11	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   119	140	618	java/lang/Exception
    //   152	162	618	java/lang/Exception
    //   173	179	618	java/lang/Exception
    //   187	215	618	java/lang/Exception
    //   236	246	618	java/lang/Exception
    //   258	268	618	java/lang/Exception
    //   276	290	618	java/lang/Exception
    //   298	303	618	java/lang/Exception
    //   311	316	618	java/lang/Exception
    //   328	342	618	java/lang/Exception
    //   350	356	618	java/lang/Exception
    //   364	370	618	java/lang/Exception
    //   492	498	618	java/lang/Exception
    //   512	518	618	java/lang/Exception
    //   526	533	618	java/lang/Exception
    //   541	550	618	java/lang/Exception
    //   561	568	618	java/lang/Exception
    //   576	582	618	java/lang/Exception
    //   119	140	709	finally
    //   152	162	709	finally
    //   173	179	709	finally
    //   187	215	709	finally
    //   236	246	709	finally
    //   258	268	709	finally
    //   276	290	709	finally
    //   298	303	709	finally
    //   311	316	709	finally
    //   328	342	709	finally
    //   350	356	709	finally
    //   364	370	709	finally
    //   492	498	709	finally
    //   512	518	709	finally
    //   526	533	709	finally
    //   541	550	709	finally
    //   561	568	709	finally
    //   576	582	709	finally
    //   599	606	770	finally
    //   623	640	777	finally
    //   599	606	785	java/lang/Exception
  }
  
  /* Error */
  private void J(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_2
    //   1: invokevirtual 100	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   4: ifeq +524 -> 528
    //   7: aload_3
    //   8: ifnull +520 -> 528
    //   11: iconst_1
    //   12: istore 6
    //   14: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   17: ifeq +31 -> 48
    //   20: ldc_w 715
    //   23: iconst_2
    //   24: new 20	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   31: ldc_w 755
    //   34: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: iload 6
    //   39: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   42: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: aload_0
    //   49: getfield 229	amov:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   52: invokevirtual 289	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   55: astore_1
    //   56: aload_0
    //   57: getfield 229	amov:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   60: bipush 51
    //   62: invokevirtual 235	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   65: checkcast 237	amsw
    //   68: astore 10
    //   70: aload 10
    //   72: aload_1
    //   73: invokevirtual 724	amsw:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   76: astore_2
    //   77: iload 6
    //   79: istore 9
    //   81: iload 6
    //   83: ifeq +800 -> 883
    //   86: iload 6
    //   88: istore 7
    //   90: iload 6
    //   92: istore 8
    //   94: new 117	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   97: dup
    //   98: invokespecial 118	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   101: aload_3
    //   102: checkcast 120	[B
    //   105: checkcast 120	[B
    //   108: invokevirtual 124	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   111: checkcast 117	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   114: astore_1
    //   115: aload_1
    //   116: ifnull +418 -> 534
    //   119: iload 6
    //   121: istore 7
    //   123: iload 6
    //   125: istore 8
    //   127: aload_1
    //   128: getfield 128	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   131: invokevirtual 133	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   134: ifne +400 -> 534
    //   137: iconst_1
    //   138: istore 6
    //   140: iload 6
    //   142: istore 7
    //   144: iload 6
    //   146: istore 8
    //   148: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   151: ifeq +39 -> 190
    //   154: iload 6
    //   156: istore 7
    //   158: iload 6
    //   160: istore 8
    //   162: ldc_w 715
    //   165: iconst_2
    //   166: new 20	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   173: ldc_w 757
    //   176: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: iload 6
    //   181: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   184: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   190: iload 6
    //   192: istore 9
    //   194: iload 6
    //   196: ifeq +687 -> 883
    //   199: iload 6
    //   201: istore 7
    //   203: iload 6
    //   205: istore 8
    //   207: iload 6
    //   209: istore 9
    //   211: aload_1
    //   212: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   215: invokevirtual 147	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   218: ifeq +665 -> 883
    //   221: iload 6
    //   223: istore 7
    //   225: iload 6
    //   227: istore 8
    //   229: iload 6
    //   231: istore 9
    //   233: aload_1
    //   234: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   237: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   240: ifnull +643 -> 883
    //   243: iload 6
    //   245: istore 7
    //   247: iload 6
    //   249: istore 8
    //   251: aload_1
    //   252: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   255: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   258: invokevirtual 159	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   261: invokestatic 609	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   264: astore_1
    //   265: iload 6
    //   267: istore 7
    //   269: iload 6
    //   271: istore 8
    //   273: aload_1
    //   274: invokevirtual 612	java/nio/ByteBuffer:getInt	()I
    //   277: pop
    //   278: iload 6
    //   280: istore 7
    //   282: iload 6
    //   284: istore 8
    //   286: aload_1
    //   287: invokevirtual 615	java/nio/ByteBuffer:get	()B
    //   290: pop
    //   291: iload 6
    //   293: istore 7
    //   295: iload 6
    //   297: istore 8
    //   299: iload 6
    //   301: istore 9
    //   303: aload_1
    //   304: invokevirtual 619	java/nio/ByteBuffer:getShort	()S
    //   307: invokestatic 630	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   310: invokevirtual 729	java/lang/Short:shortValue	()S
    //   313: iconst_1
    //   314: if_icmpne +569 -> 883
    //   317: iload 6
    //   319: istore 7
    //   321: iload 6
    //   323: istore 8
    //   325: aload_1
    //   326: invokevirtual 619	java/nio/ByteBuffer:getShort	()S
    //   329: istore 4
    //   331: iload 6
    //   333: istore 7
    //   335: iload 6
    //   337: istore 8
    //   339: aload_0
    //   340: getfield 72	amov:jdField_c_of_type_Short	S
    //   343: istore 5
    //   345: iload 4
    //   347: iload 5
    //   349: if_icmpeq +191 -> 540
    //   352: iconst_0
    //   353: istore 6
    //   355: iload 6
    //   357: istore 7
    //   359: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   362: ifeq +48 -> 410
    //   365: ldc_w 715
    //   368: iconst_2
    //   369: new 20	java/lang/StringBuilder
    //   372: dup
    //   373: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   376: ldc_w 757
    //   379: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: iload 6
    //   384: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   387: ldc_w 731
    //   390: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: aload_2
    //   394: getfield 760	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   397: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   400: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   403: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   406: iload 6
    //   408: istore 7
    //   410: aload_2
    //   411: getfield 760	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   414: ifeq +438 -> 852
    //   417: aload 10
    //   419: iconst_1
    //   420: putfield 763	amsw:q	I
    //   423: aload_0
    //   424: getfield 229	amov:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   427: invokevirtual 357	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   430: aload_0
    //   431: getfield 229	amov:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   434: invokevirtual 289	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   437: iconst_0
    //   438: invokevirtual 767	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   441: invokeinterface 463 1 0
    //   446: ldc_w 769
    //   449: aload 10
    //   451: getfield 763	amsw:q	I
    //   454: invokeinterface 773 3 0
    //   459: invokeinterface 486 1 0
    //   464: pop
    //   465: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   468: ifeq +44 -> 512
    //   471: ldc_w 775
    //   474: iconst_2
    //   475: new 20	java/lang/StringBuilder
    //   478: dup
    //   479: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   482: ldc_w 757
    //   485: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: iload 7
    //   490: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   493: ldc_w 777
    //   496: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: aload_2
    //   500: getfield 760	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   503: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   506: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   509: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   512: aload_0
    //   513: bipush 72
    //   515: iload 7
    //   517: aload_2
    //   518: getfield 760	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   521: invokestatic 180	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   524: invokevirtual 184	amov:notifyUI	(IZLjava/lang/Object;)V
    //   527: return
    //   528: iconst_0
    //   529: istore 6
    //   531: goto -517 -> 14
    //   534: iconst_0
    //   535: istore 6
    //   537: goto -397 -> 140
    //   540: iload 6
    //   542: istore 7
    //   544: iload 6
    //   546: istore 8
    //   548: aload_1
    //   549: invokevirtual 619	java/nio/ByteBuffer:getShort	()S
    //   552: istore 4
    //   554: iload 4
    //   556: iconst_2
    //   557: if_icmpne +159 -> 716
    //   560: iload 6
    //   562: istore 7
    //   564: iload 6
    //   566: istore 8
    //   568: iload 4
    //   570: newarray byte
    //   572: astore_3
    //   573: iload 6
    //   575: istore 7
    //   577: iload 6
    //   579: istore 8
    //   581: aload_1
    //   582: aload_3
    //   583: invokevirtual 743	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   586: pop
    //   587: iload 6
    //   589: istore 7
    //   591: iload 6
    //   593: istore 8
    //   595: aload_3
    //   596: iconst_0
    //   597: invokestatic 748	bftf:a	([BI)S
    //   600: ifne +97 -> 697
    //   603: iconst_0
    //   604: istore 9
    //   606: iload 6
    //   608: istore 7
    //   610: iload 6
    //   612: istore 8
    //   614: aload_2
    //   615: iload 9
    //   617: putfield 760	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   620: iload 6
    //   622: istore 7
    //   624: iload 6
    //   626: istore 8
    //   628: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   631: ifeq +41 -> 672
    //   634: iload 6
    //   636: istore 7
    //   638: iload 6
    //   640: istore 8
    //   642: ldc_w 775
    //   645: iconst_2
    //   646: new 20	java/lang/StringBuilder
    //   649: dup
    //   650: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   653: ldc_w 779
    //   656: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   659: aload_2
    //   660: getfield 760	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   663: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   666: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   669: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   672: iload 6
    //   674: istore 7
    //   676: iload 6
    //   678: istore 8
    //   680: aload_1
    //   681: invokevirtual 619	java/nio/ByteBuffer:getShort	()S
    //   684: istore 4
    //   686: iload 4
    //   688: ifeq +15 -> 703
    //   691: iconst_0
    //   692: istore 6
    //   694: goto -339 -> 355
    //   697: iconst_1
    //   698: istore 9
    //   700: goto -94 -> 606
    //   703: aload 10
    //   705: aload_2
    //   706: invokevirtual 751	amsw:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   709: pop
    //   710: iconst_1
    //   711: istore 6
    //   713: goto -358 -> 355
    //   716: iconst_0
    //   717: istore 6
    //   719: goto -364 -> 355
    //   722: astore_1
    //   723: iload 7
    //   725: istore 6
    //   727: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   730: ifeq +14 -> 744
    //   733: ldc_w 715
    //   736: iconst_2
    //   737: ldc_w 781
    //   740: aload_1
    //   741: invokestatic 208	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   744: iload 6
    //   746: istore 7
    //   748: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   751: ifeq -341 -> 410
    //   754: ldc_w 715
    //   757: iconst_2
    //   758: new 20	java/lang/StringBuilder
    //   761: dup
    //   762: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   765: ldc_w 757
    //   768: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   771: iload 6
    //   773: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   776: ldc_w 731
    //   779: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   782: aload_2
    //   783: getfield 760	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   786: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   789: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   792: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   795: iload 6
    //   797: istore 7
    //   799: goto -389 -> 410
    //   802: astore_1
    //   803: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   806: ifeq +44 -> 850
    //   809: ldc_w 715
    //   812: iconst_2
    //   813: new 20	java/lang/StringBuilder
    //   816: dup
    //   817: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   820: ldc_w 757
    //   823: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   826: iload 8
    //   828: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   831: ldc_w 731
    //   834: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   837: aload_2
    //   838: getfield 760	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   841: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   844: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   847: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   850: aload_1
    //   851: athrow
    //   852: aload 10
    //   854: iconst_0
    //   855: putfield 763	amsw:q	I
    //   858: goto -435 -> 423
    //   861: astore_1
    //   862: iconst_1
    //   863: istore 8
    //   865: goto -62 -> 803
    //   868: astore_1
    //   869: iload 6
    //   871: istore 8
    //   873: goto -70 -> 803
    //   876: astore_1
    //   877: iconst_1
    //   878: istore 6
    //   880: goto -153 -> 727
    //   883: iload 9
    //   885: istore 6
    //   887: goto -532 -> 355
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	890	0	this	amov
    //   0	890	1	paramToServiceMsg	ToServiceMsg
    //   0	890	2	paramFromServiceMsg	FromServiceMsg
    //   0	890	3	paramObject	Object
    //   329	358	4	i	int
    //   343	7	5	j	int
    //   12	874	6	bool1	boolean
    //   88	710	7	bool2	boolean
    //   92	780	8	bool3	boolean
    //   79	805	9	bool4	boolean
    //   68	785	10	localamsw	amsw
    // Exception table:
    //   from	to	target	type
    //   94	115	722	java/lang/Exception
    //   127	137	722	java/lang/Exception
    //   148	154	722	java/lang/Exception
    //   162	190	722	java/lang/Exception
    //   211	221	722	java/lang/Exception
    //   233	243	722	java/lang/Exception
    //   251	265	722	java/lang/Exception
    //   273	278	722	java/lang/Exception
    //   286	291	722	java/lang/Exception
    //   303	317	722	java/lang/Exception
    //   325	331	722	java/lang/Exception
    //   339	345	722	java/lang/Exception
    //   548	554	722	java/lang/Exception
    //   568	573	722	java/lang/Exception
    //   581	587	722	java/lang/Exception
    //   595	603	722	java/lang/Exception
    //   614	620	722	java/lang/Exception
    //   628	634	722	java/lang/Exception
    //   642	672	722	java/lang/Exception
    //   680	686	722	java/lang/Exception
    //   94	115	802	finally
    //   127	137	802	finally
    //   148	154	802	finally
    //   162	190	802	finally
    //   211	221	802	finally
    //   233	243	802	finally
    //   251	265	802	finally
    //   273	278	802	finally
    //   286	291	802	finally
    //   303	317	802	finally
    //   325	331	802	finally
    //   339	345	802	finally
    //   548	554	802	finally
    //   568	573	802	finally
    //   581	587	802	finally
    //   595	603	802	finally
    //   614	620	802	finally
    //   628	634	802	finally
    //   642	672	802	finally
    //   680	686	802	finally
    //   703	710	861	finally
    //   727	744	868	finally
    //   703	710	876	java/lang/Exception
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
        break label607;
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
          break label607;
        }
        bool2 = bool1;
        bool3 = bool1;
        bool4 = bool1;
        if (!paramFromServiceMsg.bytes_bodybuffer.has()) {
          break label607;
        }
        bool2 = bool1;
        bool3 = bool1;
        bool4 = bool1;
        if (paramFromServiceMsg.bytes_bodybuffer.get() == null) {
          break label607;
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
        paramFromServiceMsg = (amsw)this.app.getManager(51);
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
      label607:
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
    //   13: ifeq +607 -> 620
    //   16: aload_3
    //   17: ifnull +603 -> 620
    //   20: iconst_1
    //   21: istore 5
    //   23: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +31 -> 57
    //   29: ldc_w 715
    //   32: iconst_2
    //   33: new 20	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   40: ldc_w 797
    //   43: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: iload 5
    //   48: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   51: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: iload 5
    //   59: istore 8
    //   61: iload 5
    //   63: ifeq +757 -> 820
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
    //   96: ifnull +530 -> 626
    //   99: iload 5
    //   101: istore 6
    //   103: iload 5
    //   105: istore 7
    //   107: aload_2
    //   108: getfield 128	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   111: invokevirtual 133	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   114: ifne +512 -> 626
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
    //   142: ldc_w 715
    //   145: iconst_2
    //   146: new 20	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   153: ldc_w 799
    //   156: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: iload 5
    //   161: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   164: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   170: iload 5
    //   172: istore 8
    //   174: iload 5
    //   176: ifeq +644 -> 820
    //   179: iload 5
    //   181: istore 6
    //   183: iload 5
    //   185: istore 7
    //   187: iload 5
    //   189: istore 8
    //   191: aload_2
    //   192: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   195: invokevirtual 147	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   198: ifeq +622 -> 820
    //   201: iload 5
    //   203: istore 6
    //   205: iload 5
    //   207: istore 7
    //   209: iload 5
    //   211: istore 8
    //   213: aload_2
    //   214: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   217: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   220: ifnull +600 -> 820
    //   223: iload 5
    //   225: istore 6
    //   227: iload 5
    //   229: istore 7
    //   231: aload_2
    //   232: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   235: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   238: invokevirtual 159	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   241: invokestatic 609	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   244: invokevirtual 612	java/nio/ByteBuffer:getInt	()I
    //   247: istore 4
    //   249: iload 4
    //   251: ifge +381 -> 632
    //   254: iload 4
    //   256: i2l
    //   257: ldc2_w 671
    //   260: ladd
    //   261: lstore 12
    //   263: iload 5
    //   265: istore 6
    //   267: iload 5
    //   269: istore 7
    //   271: aload_0
    //   272: getfield 229	amov:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   275: invokevirtual 289	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   278: lload 12
    //   280: invokestatic 675	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   283: invokevirtual 678	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   286: ifeq +460 -> 746
    //   289: iload 5
    //   291: istore 6
    //   293: iload 5
    //   295: istore 7
    //   297: aload_0
    //   298: getfield 229	amov:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   301: bipush 51
    //   303: invokevirtual 235	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   306: checkcast 237	amsw
    //   309: astore_2
    //   310: iload 5
    //   312: istore 6
    //   314: iload 5
    //   316: istore 7
    //   318: aload_2
    //   319: aload_0
    //   320: getfield 229	amov:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   323: invokevirtual 289	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   326: invokevirtual 724	amsw:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   329: astore_3
    //   330: iload 5
    //   332: istore 6
    //   334: iload 5
    //   336: istore 7
    //   338: aload_3
    //   339: aload_1
    //   340: getfield 595	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   343: ldc_w 788
    //   346: invokevirtual 792	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   349: putfield 760	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   352: iload 5
    //   354: istore 6
    //   356: iload 5
    //   358: istore 7
    //   360: aload_2
    //   361: aload_3
    //   362: invokevirtual 751	amsw:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   365: pop
    //   366: iload 11
    //   368: istore 6
    //   370: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   373: ifeq +37 -> 410
    //   376: iload 11
    //   378: istore 6
    //   380: ldc_w 775
    //   383: iconst_2
    //   384: new 20	java/lang/StringBuilder
    //   387: dup
    //   388: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   391: ldc_w 801
    //   394: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: aload_3
    //   398: getfield 760	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   401: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   404: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   407: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   410: iload 11
    //   412: istore 6
    //   414: aload_3
    //   415: getfield 760	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   418: ifeq +222 -> 640
    //   421: iload 11
    //   423: istore 6
    //   425: aload_2
    //   426: iconst_1
    //   427: putfield 763	amsw:q	I
    //   430: iload 11
    //   432: istore 6
    //   434: aload_0
    //   435: getfield 229	amov:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   438: invokevirtual 357	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   441: aload_0
    //   442: getfield 229	amov:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   445: invokevirtual 289	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   448: iconst_0
    //   449: invokevirtual 767	com/tencent/qphone/base/util/BaseApplication:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   452: invokeinterface 463 1 0
    //   457: ldc_w 769
    //   460: aload_2
    //   461: getfield 763	amsw:q	I
    //   464: invokeinterface 773 3 0
    //   469: invokeinterface 486 1 0
    //   474: pop
    //   475: iload 9
    //   477: istore 5
    //   479: iload 5
    //   481: istore 6
    //   483: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   486: ifeq +54 -> 540
    //   489: ldc_w 715
    //   492: iconst_2
    //   493: new 20	java/lang/StringBuilder
    //   496: dup
    //   497: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   500: ldc_w 799
    //   503: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   506: iload 5
    //   508: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   511: ldc_w 731
    //   514: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: aload_1
    //   518: getfield 595	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   521: ldc_w 788
    //   524: invokevirtual 792	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   527: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   530: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   533: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   536: iload 5
    //   538: istore 6
    //   540: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   543: ifeq +67 -> 610
    //   546: aload_0
    //   547: getfield 229	amov:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   550: bipush 51
    //   552: invokevirtual 235	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   555: checkcast 237	amsw
    //   558: aload_0
    //   559: getfield 229	amov:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   562: invokevirtual 289	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   565: invokevirtual 724	amsw:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   568: astore_1
    //   569: ldc_w 775
    //   572: iconst_2
    //   573: new 20	java/lang/StringBuilder
    //   576: dup
    //   577: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   580: ldc_w 801
    //   583: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   586: aload_1
    //   587: getfield 760	com/tencent/mobileqq/data/Card:allowCalInteractive	Z
    //   590: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   593: ldc_w 803
    //   596: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: iload 6
    //   601: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   604: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   607: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   610: aload_0
    //   611: bipush 73
    //   613: iload 6
    //   615: aconst_null
    //   616: invokevirtual 184	amov:notifyUI	(IZLjava/lang/Object;)V
    //   619: return
    //   620: iconst_0
    //   621: istore 5
    //   623: goto -600 -> 23
    //   626: iconst_0
    //   627: istore 5
    //   629: goto -509 -> 120
    //   632: iload 4
    //   634: i2l
    //   635: lstore 12
    //   637: goto -374 -> 263
    //   640: iload 11
    //   642: istore 6
    //   644: aload_2
    //   645: iconst_0
    //   646: putfield 763	amsw:q	I
    //   649: goto -219 -> 430
    //   652: astore_2
    //   653: iload 10
    //   655: istore 5
    //   657: iload 5
    //   659: istore 6
    //   661: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   664: ifeq +18 -> 682
    //   667: iload 5
    //   669: istore 6
    //   671: ldc_w 715
    //   674: iconst_2
    //   675: ldc_w 805
    //   678: aload_2
    //   679: invokestatic 208	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   682: iload 5
    //   684: istore 6
    //   686: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   689: ifeq -149 -> 540
    //   692: ldc_w 715
    //   695: iconst_2
    //   696: new 20	java/lang/StringBuilder
    //   699: dup
    //   700: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   703: ldc_w 799
    //   706: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   709: iload 5
    //   711: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   714: ldc_w 731
    //   717: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   720: aload_1
    //   721: getfield 595	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   724: ldc_w 788
    //   727: invokevirtual 792	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   730: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   733: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   736: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   739: iload 5
    //   741: istore 6
    //   743: goto -203 -> 540
    //   746: iconst_0
    //   747: istore 5
    //   749: goto -270 -> 479
    //   752: astore_2
    //   753: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   756: ifeq +50 -> 806
    //   759: ldc_w 715
    //   762: iconst_2
    //   763: new 20	java/lang/StringBuilder
    //   766: dup
    //   767: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   770: ldc_w 799
    //   773: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   776: iload 6
    //   778: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   781: ldc_w 731
    //   784: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   787: aload_1
    //   788: getfield 595	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   791: ldc_w 788
    //   794: invokevirtual 792	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   797: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   800: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   803: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   806: aload_2
    //   807: athrow
    //   808: astore_2
    //   809: goto -56 -> 753
    //   812: astore_2
    //   813: iload 7
    //   815: istore 5
    //   817: goto -160 -> 657
    //   820: iload 8
    //   822: istore 5
    //   824: goto -345 -> 479
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	827	0	this	amov
    //   0	827	1	paramToServiceMsg	ToServiceMsg
    //   0	827	2	paramFromServiceMsg	FromServiceMsg
    //   0	827	3	paramObject	Object
    //   247	386	4	i	int
    //   21	802	5	bool1	boolean
    //   68	709	6	bool2	boolean
    //   72	742	7	bool3	boolean
    //   59	762	8	bool4	boolean
    //   7	469	9	bool5	boolean
    //   1	653	10	bool6	boolean
    //   4	637	11	bool7	boolean
    //   261	375	12	l	long
    // Exception table:
    //   from	to	target	type
    //   370	376	652	java/lang/Exception
    //   380	410	652	java/lang/Exception
    //   414	421	652	java/lang/Exception
    //   425	430	652	java/lang/Exception
    //   434	475	652	java/lang/Exception
    //   644	649	652	java/lang/Exception
    //   74	95	752	finally
    //   107	117	752	finally
    //   128	134	752	finally
    //   142	170	752	finally
    //   191	201	752	finally
    //   213	223	752	finally
    //   231	249	752	finally
    //   271	289	752	finally
    //   297	310	752	finally
    //   318	330	752	finally
    //   338	352	752	finally
    //   360	366	752	finally
    //   370	376	808	finally
    //   380	410	808	finally
    //   414	421	808	finally
    //   425	430	808	finally
    //   434	475	808	finally
    //   644	649	808	finally
    //   661	667	808	finally
    //   671	682	808	finally
    //   74	95	812	java/lang/Exception
    //   107	117	812	java/lang/Exception
    //   128	134	812	java/lang/Exception
    //   142	170	812	java/lang/Exception
    //   191	201	812	java/lang/Exception
    //   213	223	812	java/lang/Exception
    //   231	249	812	java/lang/Exception
    //   271	289	812	java/lang/Exception
    //   297	310	812	java/lang/Exception
    //   318	330	812	java/lang/Exception
    //   338	352	812	java/lang/Exception
    //   360	366	812	java/lang/Exception
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
    //   13: ifeq +679 -> 692
    //   16: aload_3
    //   17: ifnull +675 -> 692
    //   20: iconst_1
    //   21: istore 5
    //   23: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +31 -> 57
    //   29: ldc_w 715
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
    //   63: ifeq +821 -> 884
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
    //   110: ifne +588 -> 698
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
    //   138: ldc_w 715
    //   141: iconst_2
    //   142: new 20	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   149: ldc_w 810
    //   152: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: iload 5
    //   157: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   160: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   166: iload 5
    //   168: istore 8
    //   170: iload 5
    //   172: ifeq +712 -> 884
    //   175: iload 5
    //   177: istore 6
    //   179: iload 5
    //   181: istore 7
    //   183: iload 5
    //   185: istore 8
    //   187: aload_2
    //   188: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   191: invokevirtual 147	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   194: ifeq +690 -> 884
    //   197: iload 5
    //   199: istore 6
    //   201: iload 5
    //   203: istore 7
    //   205: iload 5
    //   207: istore 8
    //   209: aload_2
    //   210: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   213: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   216: ifnull +668 -> 884
    //   219: iload 5
    //   221: istore 6
    //   223: iload 5
    //   225: istore 7
    //   227: aload_2
    //   228: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   231: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   234: invokevirtual 159	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   237: invokestatic 609	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   240: invokevirtual 612	java/nio/ByteBuffer:getInt	()I
    //   243: istore 4
    //   245: iload 4
    //   247: ifge +457 -> 704
    //   250: iload 4
    //   252: i2l
    //   253: ldc2_w 671
    //   256: ladd
    //   257: lstore 13
    //   259: iload 5
    //   261: istore 6
    //   263: iload 5
    //   265: istore 7
    //   267: aload_0
    //   268: getfield 229	amov:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   271: invokevirtual 289	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   274: lload 13
    //   276: invokestatic 675	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   279: invokevirtual 678	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   282: ifeq +430 -> 712
    //   285: iload 5
    //   287: istore 6
    //   289: iload 5
    //   291: istore 7
    //   293: aload_0
    //   294: getfield 229	amov:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   297: invokestatic 815	axgj:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   300: istore 8
    //   302: iload 5
    //   304: istore 6
    //   306: iload 5
    //   308: istore 7
    //   310: aload_0
    //   311: getfield 229	amov:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   314: bipush 51
    //   316: invokevirtual 235	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   319: checkcast 237	amsw
    //   322: astore_3
    //   323: iload 5
    //   325: istore 6
    //   327: iload 5
    //   329: istore 7
    //   331: aload_3
    //   332: aload_0
    //   333: getfield 229	amov:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   336: invokevirtual 289	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   339: invokevirtual 724	amsw:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   342: astore_2
    //   343: iload 5
    //   345: istore 6
    //   347: iload 5
    //   349: istore 7
    //   351: aload_2
    //   352: aload_1
    //   353: getfield 595	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   356: ldc_w 788
    //   359: invokevirtual 792	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   362: putfield 818	com/tencent/mobileqq/data/Card:medalSwitchDisable	Z
    //   365: iload 5
    //   367: istore 6
    //   369: iload 5
    //   371: istore 7
    //   373: aload_3
    //   374: aload_2
    //   375: invokevirtual 751	amsw:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   378: pop
    //   379: iload 5
    //   381: istore 6
    //   383: iload 5
    //   385: istore 7
    //   387: invokestatic 824	com/tencent/common/app/BaseApplicationImpl:getApplication	()Lcom/tencent/common/app/BaseApplicationImpl;
    //   390: new 20	java/lang/StringBuilder
    //   393: dup
    //   394: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   397: ldc_w 826
    //   400: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: lload 13
    //   405: invokevirtual 829	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   408: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   411: iconst_4
    //   412: invokevirtual 830	com/tencent/common/app/BaseApplicationImpl:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   415: invokeinterface 463 1 0
    //   420: astore_3
    //   421: iload 5
    //   423: istore 6
    //   425: iload 5
    //   427: istore 7
    //   429: aload_3
    //   430: ldc_w 832
    //   433: aload_2
    //   434: getfield 818	com/tencent/mobileqq/data/Card:medalSwitchDisable	Z
    //   437: invokeinterface 836 3 0
    //   442: pop
    //   443: iload 5
    //   445: istore 6
    //   447: iload 5
    //   449: istore 7
    //   451: aload_3
    //   452: invokeinterface 486 1 0
    //   457: pop
    //   458: iload 5
    //   460: istore 6
    //   462: iload 5
    //   464: istore 7
    //   466: aload_0
    //   467: getfield 229	amov:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   470: invokestatic 815	axgj:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Z
    //   473: istore 12
    //   475: iload 8
    //   477: iload 12
    //   479: if_icmpeq +20 -> 499
    //   482: iload 5
    //   484: istore 6
    //   486: iload 5
    //   488: istore 7
    //   490: aload_0
    //   491: getfield 229	amov:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   494: iload 12
    //   496: invokestatic 839	axgj:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Z)V
    //   499: iload 9
    //   501: istore 5
    //   503: iload 11
    //   505: istore 6
    //   507: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   510: ifeq +41 -> 551
    //   513: iload 11
    //   515: istore 6
    //   517: ldc_w 715
    //   520: iconst_2
    //   521: new 20	java/lang/StringBuilder
    //   524: dup
    //   525: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   528: ldc_w 841
    //   531: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: aload_2
    //   535: getfield 818	com/tencent/mobileqq/data/Card:medalSwitchDisable	Z
    //   538: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   541: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   544: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   547: iload 9
    //   549: istore 5
    //   551: iload 5
    //   553: istore 6
    //   555: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   558: ifeq +54 -> 612
    //   561: ldc_w 715
    //   564: iconst_2
    //   565: new 20	java/lang/StringBuilder
    //   568: dup
    //   569: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   572: ldc_w 810
    //   575: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: iload 5
    //   580: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   583: ldc_w 843
    //   586: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   589: aload_1
    //   590: getfield 595	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   593: ldc_w 788
    //   596: invokevirtual 792	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   599: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   602: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   605: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   608: iload 5
    //   610: istore 6
    //   612: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   615: ifeq +67 -> 682
    //   618: aload_0
    //   619: getfield 229	amov:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   622: bipush 51
    //   624: invokevirtual 235	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   627: checkcast 237	amsw
    //   630: aload_0
    //   631: getfield 229	amov:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   634: invokevirtual 289	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   637: invokevirtual 724	amsw:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   640: astore_1
    //   641: ldc_w 715
    //   644: iconst_2
    //   645: new 20	java/lang/StringBuilder
    //   648: dup
    //   649: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   652: ldc_w 845
    //   655: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   658: aload_1
    //   659: getfield 818	com/tencent/mobileqq/data/Card:medalSwitchDisable	Z
    //   662: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   665: ldc_w 803
    //   668: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   671: iload 6
    //   673: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   676: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   679: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   682: aload_0
    //   683: bipush 76
    //   685: iload 6
    //   687: aconst_null
    //   688: invokevirtual 184	amov:notifyUI	(IZLjava/lang/Object;)V
    //   691: return
    //   692: iconst_0
    //   693: istore 5
    //   695: goto -672 -> 23
    //   698: iconst_0
    //   699: istore 5
    //   701: goto -585 -> 116
    //   704: iload 4
    //   706: i2l
    //   707: lstore 13
    //   709: goto -450 -> 259
    //   712: iconst_0
    //   713: istore 5
    //   715: goto -164 -> 551
    //   718: astore_2
    //   719: iload 6
    //   721: istore 5
    //   723: iload 5
    //   725: istore 6
    //   727: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   730: ifeq +18 -> 748
    //   733: iload 5
    //   735: istore 6
    //   737: ldc_w 715
    //   740: iconst_2
    //   741: ldc_w 847
    //   744: aload_2
    //   745: invokestatic 208	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   748: iload 5
    //   750: istore 6
    //   752: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   755: ifeq -143 -> 612
    //   758: ldc_w 715
    //   761: iconst_2
    //   762: new 20	java/lang/StringBuilder
    //   765: dup
    //   766: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   769: ldc_w 810
    //   772: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   775: iload 5
    //   777: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   780: ldc_w 843
    //   783: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   786: aload_1
    //   787: getfield 595	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   790: ldc_w 788
    //   793: invokevirtual 792	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   796: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   799: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   802: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   805: iload 5
    //   807: istore 6
    //   809: goto -197 -> 612
    //   812: astore_2
    //   813: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   816: ifeq +50 -> 866
    //   819: ldc_w 715
    //   822: iconst_2
    //   823: new 20	java/lang/StringBuilder
    //   826: dup
    //   827: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   830: ldc_w 810
    //   833: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   836: iload 7
    //   838: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   841: ldc_w 843
    //   844: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   847: aload_1
    //   848: getfield 595	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   851: ldc_w 788
    //   854: invokevirtual 792	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   857: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   860: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   863: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   866: aload_2
    //   867: athrow
    //   868: astore_2
    //   869: iload 6
    //   871: istore 7
    //   873: goto -60 -> 813
    //   876: astore_2
    //   877: iload 10
    //   879: istore 5
    //   881: goto -158 -> 723
    //   884: iload 8
    //   886: istore 5
    //   888: goto -337 -> 551
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	891	0	this	amov
    //   0	891	1	paramToServiceMsg	ToServiceMsg
    //   0	891	2	paramFromServiceMsg	FromServiceMsg
    //   0	891	3	paramObject	Object
    //   243	462	4	i	int
    //   21	866	5	bool1	boolean
    //   68	802	6	bool2	boolean
    //   72	800	7	bool3	boolean
    //   59	826	8	bool4	boolean
    //   7	541	9	bool5	boolean
    //   1	877	10	bool6	boolean
    //   4	510	11	bool7	boolean
    //   473	22	12	bool8	boolean
    //   257	451	13	l	long
    // Exception table:
    //   from	to	target	type
    //   74	95	718	java/lang/Exception
    //   103	113	718	java/lang/Exception
    //   124	130	718	java/lang/Exception
    //   138	166	718	java/lang/Exception
    //   187	197	718	java/lang/Exception
    //   209	219	718	java/lang/Exception
    //   227	245	718	java/lang/Exception
    //   267	285	718	java/lang/Exception
    //   293	302	718	java/lang/Exception
    //   310	323	718	java/lang/Exception
    //   331	343	718	java/lang/Exception
    //   351	365	718	java/lang/Exception
    //   373	379	718	java/lang/Exception
    //   387	421	718	java/lang/Exception
    //   429	443	718	java/lang/Exception
    //   451	458	718	java/lang/Exception
    //   466	475	718	java/lang/Exception
    //   490	499	718	java/lang/Exception
    //   74	95	812	finally
    //   103	113	812	finally
    //   124	130	812	finally
    //   138	166	812	finally
    //   187	197	812	finally
    //   209	219	812	finally
    //   227	245	812	finally
    //   267	285	812	finally
    //   293	302	812	finally
    //   310	323	812	finally
    //   331	343	812	finally
    //   351	365	812	finally
    //   373	379	812	finally
    //   387	421	812	finally
    //   429	443	812	finally
    //   451	458	812	finally
    //   466	475	812	finally
    //   490	499	812	finally
    //   507	513	868	finally
    //   517	547	868	finally
    //   727	733	868	finally
    //   737	748	868	finally
    //   507	513	876	java/lang/Exception
    //   517	547	876	java/lang/Exception
  }
  
  private void N(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool5 = true;
    amsw localamsw;
    boolean bool3;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("Q.profilecard.", 2, "handleGetMedalSwitch success=" + bool1);
      }
      paramFromServiceMsg = this.app.getCurrentUin();
      localamsw = (amsw)this.app.getManager(51);
      paramToServiceMsg = localamsw.c(paramFromServiceMsg);
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
                  boolean bool6 = axgj.a(this.app);
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
                  localamsw.a(paramToServiceMsg);
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
                  bool5 = axgj.a(this.app);
                  bool3 = bool1;
                  if (bool6 != bool5)
                  {
                    bool2 = bool1;
                    bool4 = bool1;
                    axgj.a(this.app, bool5);
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
            ((airj)this.mApp.getManager(295)).b(i);
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
              apka.a(this.app).b(i);
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
    //   23: ldc_w 715
    //   26: iconst_2
    //   27: new 20	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   34: ldc_w 912
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
    //   119: getfield 882	tencent/im/oidb/oidb_sso$OIDBSSOPkg:str_error_msg	Lcom/tencent/mobileqq/pb/PBStringField;
    //   122: invokevirtual 886	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
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
    //   148: ldc_w 715
    //   151: iconst_2
    //   152: new 20	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   159: ldc_w 914
    //   162: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: iload 6
    //   167: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   170: ldc_w 890
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
    //   294: invokevirtual 853	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   297: ifeq +329 -> 626
    //   300: iload 6
    //   302: istore 9
    //   304: iload 6
    //   306: istore 7
    //   308: iload 6
    //   310: istore 8
    //   312: aload_2
    //   313: getfield 164	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   316: invokevirtual 396	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   319: invokeinterface 399 1 0
    //   324: ifle +302 -> 626
    //   327: iload 6
    //   329: istore 9
    //   331: iload 6
    //   333: istore 7
    //   335: iload 6
    //   337: istore 8
    //   339: aload_2
    //   340: getfield 164	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   343: invokevirtual 396	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   346: iconst_0
    //   347: invokeinterface 401 2 0
    //   352: checkcast 172	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData
    //   355: getfield 917	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_hidden_session_switch	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   358: invokevirtual 894	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   361: ifeq +265 -> 626
    //   364: iload 6
    //   366: istore 7
    //   368: iload 6
    //   370: istore 8
    //   372: aload_2
    //   373: getfield 164	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   376: invokevirtual 396	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   379: iconst_0
    //   380: invokeinterface 401 2 0
    //   385: checkcast 172	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData
    //   388: getfield 917	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_hidden_session_switch	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   391: invokevirtual 133	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   394: istore 4
    //   396: iload 6
    //   398: istore 7
    //   400: iload 6
    //   402: istore 8
    //   404: aload_2
    //   405: getfield 164	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   408: invokevirtual 396	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   411: iconst_0
    //   412: invokeinterface 401 2 0
    //   417: checkcast 172	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData
    //   420: getfield 920	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_hidden_session_video_switch	Lcom/tencent/mobileqq/pb/PBUInt32Field;
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
    //   450: ldc_w 715
    //   453: iconst_2
    //   454: new 20	java/lang/StringBuilder
    //   457: dup
    //   458: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   461: ldc_w 922
    //   464: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: iload 4
    //   469: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   472: ldc_w 924
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
    //   503: getfield 684	amov:mApp	Lcom/tencent/common/app/AppInterface;
    //   506: invokevirtual 925	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   509: astore_1
    //   510: iload 6
    //   512: istore 7
    //   514: iload 6
    //   516: istore 8
    //   518: aload_0
    //   519: getfield 684	amov:mApp	Lcom/tencent/common/app/AppInterface;
    //   522: invokevirtual 928	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   525: invokevirtual 931	mqq/app/MobileQQ:getApplicationContext	()Landroid/content/Context;
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
    //   550: invokestatic 936	anjo:a	(Ljava/lang/String;Landroid/content/Context;Z)V
    //   553: iload 6
    //   555: istore 9
    //   557: iload 5
    //   559: iflt +67 -> 626
    //   562: iload 6
    //   564: istore 7
    //   566: iload 6
    //   568: istore 8
    //   570: aload_0
    //   571: getfield 684	amov:mApp	Lcom/tencent/common/app/AppInterface;
    //   574: invokevirtual 925	com/tencent/common/app/AppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   577: astore_1
    //   578: iload 6
    //   580: istore 7
    //   582: iload 6
    //   584: istore 8
    //   586: aload_0
    //   587: getfield 684	amov:mApp	Lcom/tencent/common/app/AppInterface;
    //   590: invokevirtual 928	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   593: invokevirtual 931	mqq/app/MobileQQ:getApplicationContext	()Landroid/content/Context;
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
    //   619: invokestatic 938	anjo:b	(Ljava/lang/String;Landroid/content/Context;Z)V
    //   622: iload 6
    //   624: istore 9
    //   626: aload_0
    //   627: bipush 107
    //   629: iload 9
    //   631: aconst_null
    //   632: invokevirtual 184	amov:notifyUI	(IZLjava/lang/Object;)V
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
    //   675: ldc_w 715
    //   678: iconst_2
    //   679: ldc_w 940
    //   682: aload_1
    //   683: invokestatic 208	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   686: aload_0
    //   687: bipush 107
    //   689: iload 7
    //   691: aconst_null
    //   692: invokevirtual 184	amov:notifyUI	(IZLjava/lang/Object;)V
    //   695: return
    //   696: astore_1
    //   697: aload_0
    //   698: bipush 107
    //   700: iload 8
    //   702: aconst_null
    //   703: invokevirtual 184	amov:notifyUI	(IZLjava/lang/Object;)V
    //   706: aload_1
    //   707: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	708	0	this	amov
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
    //   4: ifeq +491 -> 495
    //   7: aload_3
    //   8: ifnull +487 -> 495
    //   11: iconst_1
    //   12: istore 5
    //   14: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   17: ifeq +31 -> 48
    //   20: ldc_w 715
    //   23: iconst_2
    //   24: new 20	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   31: ldc_w 943
    //   34: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: iload 5
    //   39: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   42: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: aload_1
    //   49: getfield 595	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   52: ldc_w 945
    //   55: ldc 250
    //   57: invokevirtual 946	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   60: astore_1
    //   61: iload 5
    //   63: istore 8
    //   65: iload 5
    //   67: ifeq +406 -> 473
    //   70: iload 5
    //   72: istore 6
    //   74: iload 5
    //   76: istore 7
    //   78: new 117	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   81: dup
    //   82: invokespecial 118	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   85: aload_3
    //   86: checkcast 120	[B
    //   89: checkcast 120	[B
    //   92: invokevirtual 124	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   95: checkcast 117	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   98: astore_2
    //   99: iload 5
    //   101: istore 6
    //   103: iload 5
    //   105: istore 7
    //   107: aload_2
    //   108: getfield 128	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   111: invokevirtual 133	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   114: ifne +387 -> 501
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
    //   142: ldc_w 715
    //   145: iconst_2
    //   146: new 20	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   153: ldc_w 948
    //   156: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: iload 5
    //   161: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   164: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   167: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   170: iload 5
    //   172: istore 8
    //   174: iload 5
    //   176: ifeq +297 -> 473
    //   179: iload 5
    //   181: istore 8
    //   183: iload 5
    //   185: istore 6
    //   187: iload 5
    //   189: istore 7
    //   191: aload_2
    //   192: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   195: invokevirtual 147	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   198: ifeq +275 -> 473
    //   201: iload 5
    //   203: istore 8
    //   205: iload 5
    //   207: istore 6
    //   209: iload 5
    //   211: istore 7
    //   213: aload_2
    //   214: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   217: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   220: ifnull +253 -> 473
    //   223: iload 5
    //   225: istore 6
    //   227: iload 5
    //   229: istore 7
    //   231: new 152	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody
    //   234: dup
    //   235: invokespecial 153	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:<init>	()V
    //   238: astore_3
    //   239: iload 5
    //   241: istore 6
    //   243: iload 5
    //   245: istore 7
    //   247: aload_3
    //   248: aload_2
    //   249: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   252: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   255: invokevirtual 159	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   258: invokevirtual 160	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   261: pop
    //   262: iload 5
    //   264: istore 8
    //   266: iload 5
    //   268: istore 6
    //   270: iload 5
    //   272: istore 7
    //   274: aload_3
    //   275: getfield 164	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   278: invokevirtual 853	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   281: ifeq +192 -> 473
    //   284: iload 5
    //   286: istore 8
    //   288: iload 5
    //   290: istore 6
    //   292: iload 5
    //   294: istore 7
    //   296: aload_3
    //   297: getfield 164	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   300: invokevirtual 396	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   303: invokeinterface 399 1 0
    //   308: ifle +165 -> 473
    //   311: iload 5
    //   313: istore 8
    //   315: iload 5
    //   317: istore 6
    //   319: iload 5
    //   321: istore 7
    //   323: aload_3
    //   324: getfield 164	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   327: invokevirtual 396	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   330: iconst_0
    //   331: invokeinterface 401 2 0
    //   336: checkcast 172	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData
    //   339: getfield 951	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_do_not_disturb_mode_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   342: invokevirtual 894	com/tencent/mobileqq/pb/PBUInt32Field:has	()Z
    //   345: ifeq +128 -> 473
    //   348: iload 5
    //   350: istore 6
    //   352: iload 5
    //   354: istore 7
    //   356: aload_3
    //   357: getfield 164	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$RspBody:rpt_msg_uin_data	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   360: invokevirtual 396	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   363: iconst_0
    //   364: invokeinterface 401 2 0
    //   369: checkcast 172	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData
    //   372: getfield 951	tencent/im/oidb/cmd0x5eb/oidb_0x5eb$UdcUinData:uint32_do_not_disturb_mode_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   375: invokevirtual 133	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   378: istore 4
    //   380: iload 5
    //   382: istore 6
    //   384: iload 5
    //   386: istore 7
    //   388: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   391: ifeq +39 -> 430
    //   394: iload 5
    //   396: istore 6
    //   398: iload 5
    //   400: istore 7
    //   402: ldc_w 715
    //   405: iconst_2
    //   406: new 20	java/lang/StringBuilder
    //   409: dup
    //   410: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   413: ldc_w 953
    //   416: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: iload 4
    //   421: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   424: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   427: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   430: iload 5
    //   432: istore 8
    //   434: iload 4
    //   436: iflt +37 -> 473
    //   439: iload 5
    //   441: istore 6
    //   443: iload 5
    //   445: istore 7
    //   447: aload_0
    //   448: getfield 684	amov:mApp	Lcom/tencent/common/app/AppInterface;
    //   451: invokevirtual 928	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   454: invokevirtual 931	mqq/app/MobileQQ:getApplicationContext	()Landroid/content/Context;
    //   457: aconst_null
    //   458: ldc_w 955
    //   461: ldc_w 957
    //   464: iload 4
    //   466: invokestatic 963	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:writeValueForInt	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   469: iload 5
    //   471: istore 8
    //   473: aload_0
    //   474: bipush 98
    //   476: iload 8
    //   478: iconst_2
    //   479: anewarray 256	java/lang/String
    //   482: dup
    //   483: iconst_0
    //   484: ldc 250
    //   486: aastore
    //   487: dup
    //   488: iconst_1
    //   489: aload_1
    //   490: aastore
    //   491: invokevirtual 184	amov:notifyUI	(IZLjava/lang/Object;)V
    //   494: return
    //   495: iconst_0
    //   496: istore 5
    //   498: goto -484 -> 14
    //   501: iconst_0
    //   502: istore 5
    //   504: goto -384 -> 120
    //   507: astore_2
    //   508: iload 6
    //   510: istore 7
    //   512: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   515: ifeq +18 -> 533
    //   518: iload 6
    //   520: istore 7
    //   522: ldc_w 715
    //   525: iconst_2
    //   526: ldc_w 965
    //   529: aload_2
    //   530: invokestatic 208	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   533: aload_0
    //   534: bipush 98
    //   536: iload 6
    //   538: iconst_2
    //   539: anewarray 256	java/lang/String
    //   542: dup
    //   543: iconst_0
    //   544: ldc 250
    //   546: aastore
    //   547: dup
    //   548: iconst_1
    //   549: aload_1
    //   550: aastore
    //   551: invokevirtual 184	amov:notifyUI	(IZLjava/lang/Object;)V
    //   554: return
    //   555: astore_2
    //   556: aload_0
    //   557: bipush 98
    //   559: iload 7
    //   561: iconst_2
    //   562: anewarray 256	java/lang/String
    //   565: dup
    //   566: iconst_0
    //   567: ldc 250
    //   569: aastore
    //   570: dup
    //   571: iconst_1
    //   572: aload_1
    //   573: aastore
    //   574: invokevirtual 184	amov:notifyUI	(IZLjava/lang/Object;)V
    //   577: aload_2
    //   578: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	579	0	this	amov
    //   0	579	1	paramToServiceMsg	ToServiceMsg
    //   0	579	2	paramFromServiceMsg	FromServiceMsg
    //   0	579	3	paramObject	Object
    //   378	87	4	i	int
    //   12	491	5	bool1	boolean
    //   72	465	6	bool2	boolean
    //   76	484	7	bool3	boolean
    //   63	414	8	bool4	boolean
    // Exception table:
    //   from	to	target	type
    //   78	99	507	java/lang/Exception
    //   107	117	507	java/lang/Exception
    //   128	134	507	java/lang/Exception
    //   142	170	507	java/lang/Exception
    //   191	201	507	java/lang/Exception
    //   213	223	507	java/lang/Exception
    //   231	239	507	java/lang/Exception
    //   247	262	507	java/lang/Exception
    //   274	284	507	java/lang/Exception
    //   296	311	507	java/lang/Exception
    //   323	348	507	java/lang/Exception
    //   356	380	507	java/lang/Exception
    //   388	394	507	java/lang/Exception
    //   402	430	507	java/lang/Exception
    //   447	469	507	java/lang/Exception
    //   78	99	555	finally
    //   107	117	555	finally
    //   128	134	555	finally
    //   142	170	555	finally
    //   191	201	555	finally
    //   213	223	555	finally
    //   231	239	555	finally
    //   247	262	555	finally
    //   274	284	555	finally
    //   296	311	555	finally
    //   323	348	555	finally
    //   356	380	555	finally
    //   388	394	555	finally
    //   402	430	555	finally
    //   447	469	555	finally
    //   512	518	555	finally
    //   522	533	555	finally
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
            break label411;
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
      label411:
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
    //   13: ifeq +409 -> 422
    //   16: aload_3
    //   17: ifnull +405 -> 422
    //   20: iconst_1
    //   21: istore 5
    //   23: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +31 -> 57
    //   29: ldc_w 715
    //   32: iconst_2
    //   33: new 20	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   40: ldc_w 990
    //   43: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: iload 5
    //   48: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   51: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   54: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   57: aload_0
    //   58: getfield 229	amov:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   61: bipush 85
    //   63: invokevirtual 235	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   66: checkcast 992	aneo
    //   69: astore_1
    //   70: aload_1
    //   71: iconst_0
    //   72: invokevirtual 995	aneo:a	(Z)Z
    //   75: istore 6
    //   77: iload 5
    //   79: istore 9
    //   81: iload 5
    //   83: ifeq +608 -> 691
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
    //   114: astore_2
    //   115: aload_2
    //   116: ifnull +312 -> 428
    //   119: iload 5
    //   121: istore 7
    //   123: iload 5
    //   125: istore 8
    //   127: aload_2
    //   128: getfield 128	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   131: invokevirtual 133	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   134: ifne +294 -> 428
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
    //   162: ldc_w 715
    //   165: iconst_2
    //   166: new 20	java/lang/StringBuilder
    //   169: dup
    //   170: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   173: ldc_w 997
    //   176: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   179: iload 5
    //   181: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   184: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   187: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   190: iload 5
    //   192: istore 9
    //   194: iload 5
    //   196: ifeq +495 -> 691
    //   199: iload 5
    //   201: istore 7
    //   203: iload 5
    //   205: istore 8
    //   207: iload 5
    //   209: istore 9
    //   211: aload_2
    //   212: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   215: invokevirtual 147	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   218: ifeq +473 -> 691
    //   221: iload 5
    //   223: istore 7
    //   225: iload 5
    //   227: istore 8
    //   229: iload 5
    //   231: istore 9
    //   233: aload_2
    //   234: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   237: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   240: ifnull +451 -> 691
    //   243: iload 5
    //   245: istore 7
    //   247: iload 5
    //   249: istore 8
    //   251: aload_2
    //   252: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   255: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   258: invokevirtual 159	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   261: invokestatic 609	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   264: astore_2
    //   265: iload 5
    //   267: istore 7
    //   269: iload 5
    //   271: istore 8
    //   273: aload_2
    //   274: invokevirtual 612	java/nio/ByteBuffer:getInt	()I
    //   277: pop
    //   278: iload 5
    //   280: istore 7
    //   282: iload 5
    //   284: istore 8
    //   286: aload_2
    //   287: invokevirtual 615	java/nio/ByteBuffer:get	()B
    //   290: pop
    //   291: iload 5
    //   293: istore 7
    //   295: iload 5
    //   297: istore 8
    //   299: iload 5
    //   301: istore 9
    //   303: aload_2
    //   304: invokevirtual 619	java/nio/ByteBuffer:getShort	()S
    //   307: invokestatic 630	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   310: invokevirtual 729	java/lang/Short:shortValue	()S
    //   313: iconst_1
    //   314: if_icmpne +377 -> 691
    //   317: iload 5
    //   319: istore 7
    //   321: iload 5
    //   323: istore 8
    //   325: aload_2
    //   326: invokevirtual 619	java/nio/ByteBuffer:getShort	()S
    //   329: istore 4
    //   331: iload 4
    //   333: sipush -25031
    //   336: if_icmpeq +98 -> 434
    //   339: iload 6
    //   341: istore 5
    //   343: iload 11
    //   345: istore 6
    //   347: iload 5
    //   349: istore 7
    //   351: iload 6
    //   353: istore 8
    //   355: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   358: ifeq +50 -> 408
    //   361: ldc_w 715
    //   364: iconst_2
    //   365: new 20	java/lang/StringBuilder
    //   368: dup
    //   369: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   372: ldc_w 997
    //   375: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: iload 6
    //   380: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   383: ldc_w 731
    //   386: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: iload 5
    //   391: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   394: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   397: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   400: iload 6
    //   402: istore 8
    //   404: iload 5
    //   406: istore 7
    //   408: aload_0
    //   409: bipush 58
    //   411: iload 8
    //   413: iload 7
    //   415: invokestatic 180	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   418: invokevirtual 184	amov:notifyUI	(IZLjava/lang/Object;)V
    //   421: return
    //   422: iconst_0
    //   423: istore 5
    //   425: goto -402 -> 23
    //   428: iconst_0
    //   429: istore 5
    //   431: goto -291 -> 140
    //   434: iload 5
    //   436: istore 7
    //   438: iload 5
    //   440: istore 8
    //   442: aload_2
    //   443: invokevirtual 619	java/nio/ByteBuffer:getShort	()S
    //   446: istore 4
    //   448: iload 4
    //   450: iconst_2
    //   451: if_icmpne +80 -> 531
    //   454: iload 5
    //   456: istore 7
    //   458: iload 5
    //   460: istore 8
    //   462: iload 4
    //   464: newarray byte
    //   466: astore_3
    //   467: iload 5
    //   469: istore 7
    //   471: iload 5
    //   473: istore 8
    //   475: aload_2
    //   476: aload_3
    //   477: invokevirtual 743	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   480: pop
    //   481: iload 5
    //   483: istore 7
    //   485: iload 5
    //   487: istore 8
    //   489: aload_3
    //   490: iconst_0
    //   491: invokestatic 748	bftf:a	([BI)S
    //   494: istore 4
    //   496: iload 4
    //   498: ifne +215 -> 713
    //   501: iconst_1
    //   502: istore 6
    //   504: aload_2
    //   505: invokevirtual 619	java/nio/ByteBuffer:getShort	()S
    //   508: ifeq +10 -> 518
    //   511: iload 12
    //   513: istore 7
    //   515: goto +187 -> 702
    //   518: aload_1
    //   519: iload 6
    //   521: iconst_0
    //   522: invokevirtual 1000	aneo:a	(ZZ)V
    //   525: iconst_1
    //   526: istore 7
    //   528: goto +174 -> 702
    //   531: iload 6
    //   533: istore 5
    //   535: iload 11
    //   537: istore 6
    //   539: goto -192 -> 347
    //   542: astore_1
    //   543: iload 7
    //   545: istore 5
    //   547: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   550: ifeq +14 -> 564
    //   553: ldc_w 715
    //   556: iconst_2
    //   557: ldc_w 1002
    //   560: aload_1
    //   561: invokestatic 208	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   564: iload 6
    //   566: istore 7
    //   568: iload 10
    //   570: istore 8
    //   572: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   575: ifeq -167 -> 408
    //   578: ldc_w 715
    //   581: iconst_2
    //   582: new 20	java/lang/StringBuilder
    //   585: dup
    //   586: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   589: ldc_w 997
    //   592: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: iconst_0
    //   596: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   599: ldc_w 731
    //   602: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: iload 6
    //   607: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   610: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   613: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   616: iload 6
    //   618: istore 7
    //   620: iload 10
    //   622: istore 8
    //   624: goto -216 -> 408
    //   627: astore_1
    //   628: iload 8
    //   630: istore 5
    //   632: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   635: ifeq +42 -> 677
    //   638: ldc_w 715
    //   641: iconst_2
    //   642: new 20	java/lang/StringBuilder
    //   645: dup
    //   646: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   649: ldc_w 997
    //   652: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   655: iload 5
    //   657: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   660: ldc_w 731
    //   663: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: iload 6
    //   668: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   671: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   674: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   677: aload_1
    //   678: athrow
    //   679: astore_1
    //   680: goto -48 -> 632
    //   683: astore_1
    //   684: goto -52 -> 632
    //   687: astore_1
    //   688: goto -141 -> 547
    //   691: iload 6
    //   693: istore 5
    //   695: iload 9
    //   697: istore 6
    //   699: goto -352 -> 347
    //   702: iload 6
    //   704: istore 5
    //   706: iload 7
    //   708: istore 6
    //   710: goto -363 -> 347
    //   713: iconst_0
    //   714: istore 6
    //   716: goto -212 -> 504
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	719	0	this	amov
    //   0	719	1	paramToServiceMsg	ToServiceMsg
    //   0	719	2	paramFromServiceMsg	FromServiceMsg
    //   0	719	3	paramObject	Object
    //   329	168	4	i	int
    //   21	684	5	bool1	boolean
    //   75	640	6	bool2	boolean
    //   88	619	7	bool3	boolean
    //   92	537	8	bool4	boolean
    //   79	617	9	bool5	boolean
    //   1	620	10	bool6	boolean
    //   7	529	11	bool7	boolean
    //   4	508	12	bool8	boolean
    // Exception table:
    //   from	to	target	type
    //   94	115	542	java/lang/Exception
    //   127	137	542	java/lang/Exception
    //   148	154	542	java/lang/Exception
    //   162	190	542	java/lang/Exception
    //   211	221	542	java/lang/Exception
    //   233	243	542	java/lang/Exception
    //   251	265	542	java/lang/Exception
    //   273	278	542	java/lang/Exception
    //   286	291	542	java/lang/Exception
    //   303	317	542	java/lang/Exception
    //   325	331	542	java/lang/Exception
    //   442	448	542	java/lang/Exception
    //   462	467	542	java/lang/Exception
    //   475	481	542	java/lang/Exception
    //   489	496	542	java/lang/Exception
    //   94	115	627	finally
    //   127	137	627	finally
    //   148	154	627	finally
    //   162	190	627	finally
    //   211	221	627	finally
    //   233	243	627	finally
    //   251	265	627	finally
    //   273	278	627	finally
    //   286	291	627	finally
    //   303	317	627	finally
    //   325	331	627	finally
    //   442	448	627	finally
    //   462	467	627	finally
    //   475	481	627	finally
    //   489	496	627	finally
    //   504	511	679	finally
    //   518	525	679	finally
    //   547	564	683	finally
    //   504	511	687	java/lang/Exception
    //   518	525	687	java/lang/Exception
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
      paramFromServiceMsg = (aneo)this.app.getManager(85);
      bool2 = paramFromServiceMsg.a(false);
      bool5 = bool1;
      if (!bool1) {
        break label661;
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
              break label661;
            }
            bool4 = bool1;
            bool3 = bool1;
            bool5 = bool1;
            if (!paramObject.bytes_bodybuffer.has()) {
              break label661;
            }
            bool4 = bool1;
            bool3 = bool1;
            bool5 = bool1;
            if (paramObject.bytes_bodybuffer.get() == null) {
              break label661;
            }
            bool4 = bool1;
            bool3 = bool1;
            l = bftf.a(ByteBuffer.wrap(paramObject.bytes_bodybuffer.get().toByteArray()).getInt());
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
          break label654;
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
      label654:
      label661:
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
    //   7: ifeq +415 -> 422
    //   10: aload_3
    //   11: ifnull +411 -> 422
    //   14: iconst_1
    //   15: istore 6
    //   17: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +31 -> 51
    //   23: ldc_w 715
    //   26: iconst_2
    //   27: new 20	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   34: ldc_w 1019
    //   37: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: iload 6
    //   42: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   45: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   51: aload_0
    //   52: getfield 229	amov:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   55: bipush 51
    //   57: invokevirtual 235	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   60: checkcast 237	amsw
    //   63: astore_1
    //   64: aload_1
    //   65: getstatic 1022	com/tencent/mobileqq/app/AppConstants:BABY_Q_UIN	Ljava/lang/String;
    //   68: invokevirtual 724	amsw:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   71: astore_2
    //   72: iload 6
    //   74: istore 9
    //   76: iload 6
    //   78: ifeq +636 -> 714
    //   81: iload 6
    //   83: istore 7
    //   85: iload 6
    //   87: istore 8
    //   89: new 117	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   92: dup
    //   93: invokespecial 118	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   96: aload_3
    //   97: checkcast 120	[B
    //   100: checkcast 120	[B
    //   103: invokevirtual 124	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   106: checkcast 117	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   109: astore_3
    //   110: aload_3
    //   111: ifnull +317 -> 428
    //   114: iload 6
    //   116: istore 7
    //   118: iload 6
    //   120: istore 8
    //   122: aload_3
    //   123: getfield 128	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   126: invokevirtual 133	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   129: ifne +299 -> 428
    //   132: iconst_1
    //   133: istore 6
    //   135: iload 6
    //   137: istore 7
    //   139: iload 6
    //   141: istore 8
    //   143: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   146: ifeq +39 -> 185
    //   149: iload 6
    //   151: istore 7
    //   153: iload 6
    //   155: istore 8
    //   157: ldc_w 715
    //   160: iconst_2
    //   161: new 20	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   168: ldc_w 1024
    //   171: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: iload 6
    //   176: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   179: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   185: iload 6
    //   187: istore 9
    //   189: iload 6
    //   191: ifeq +523 -> 714
    //   194: iload 6
    //   196: istore 7
    //   198: iload 6
    //   200: istore 8
    //   202: iload 6
    //   204: istore 9
    //   206: aload_3
    //   207: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   210: invokevirtual 147	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   213: ifeq +501 -> 714
    //   216: iload 6
    //   218: istore 7
    //   220: iload 6
    //   222: istore 8
    //   224: iload 6
    //   226: istore 9
    //   228: aload_3
    //   229: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   232: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   235: ifnull +479 -> 714
    //   238: iload 6
    //   240: istore 7
    //   242: iload 6
    //   244: istore 8
    //   246: aload_3
    //   247: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   250: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   253: invokevirtual 159	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   256: invokestatic 609	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   259: astore_3
    //   260: iload 6
    //   262: istore 7
    //   264: iload 6
    //   266: istore 8
    //   268: aload_3
    //   269: invokevirtual 612	java/nio/ByteBuffer:getInt	()I
    //   272: pop
    //   273: iload 6
    //   275: istore 7
    //   277: iload 6
    //   279: istore 8
    //   281: aload_3
    //   282: invokevirtual 615	java/nio/ByteBuffer:get	()B
    //   285: pop
    //   286: iload 6
    //   288: istore 7
    //   290: iload 6
    //   292: istore 8
    //   294: iload 6
    //   296: istore 9
    //   298: aload_3
    //   299: invokevirtual 619	java/nio/ByteBuffer:getShort	()S
    //   302: invokestatic 630	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   305: invokevirtual 729	java/lang/Short:shortValue	()S
    //   308: iconst_1
    //   309: if_icmpne +405 -> 714
    //   312: iload 6
    //   314: istore 7
    //   316: iload 6
    //   318: istore 8
    //   320: aload_3
    //   321: invokevirtual 619	java/nio/ByteBuffer:getShort	()S
    //   324: istore 4
    //   326: iload 6
    //   328: istore 7
    //   330: iload 6
    //   332: istore 8
    //   334: aload_0
    //   335: getfield 76	amov:e	S
    //   338: istore 5
    //   340: iload 4
    //   342: iload 5
    //   344: if_icmpeq +90 -> 434
    //   347: iload 10
    //   349: istore 7
    //   351: iload 7
    //   353: istore 8
    //   355: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   358: ifeq +48 -> 406
    //   361: ldc_w 715
    //   364: iconst_2
    //   365: new 20	java/lang/StringBuilder
    //   368: dup
    //   369: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   372: ldc_w 1024
    //   375: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: iload 7
    //   380: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   383: ldc_w 1026
    //   386: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   389: aload_2
    //   390: getfield 1029	com/tencent/mobileqq/data/Card:babyQSwitch	Z
    //   393: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   396: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   399: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   402: iload 7
    //   404: istore 8
    //   406: aload_0
    //   407: bipush 75
    //   409: iload 8
    //   411: aload_2
    //   412: getfield 1029	com/tencent/mobileqq/data/Card:babyQSwitch	Z
    //   415: invokestatic 180	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   418: invokevirtual 184	amov:notifyUI	(IZLjava/lang/Object;)V
    //   421: return
    //   422: iconst_0
    //   423: istore 6
    //   425: goto -408 -> 17
    //   428: iconst_0
    //   429: istore 6
    //   431: goto -296 -> 135
    //   434: iload 6
    //   436: istore 7
    //   438: iload 6
    //   440: istore 8
    //   442: aload_3
    //   443: invokevirtual 619	java/nio/ByteBuffer:getShort	()S
    //   446: istore 4
    //   448: iload 10
    //   450: istore 7
    //   452: iload 4
    //   454: iconst_2
    //   455: if_icmpne -104 -> 351
    //   458: iload 6
    //   460: istore 7
    //   462: iload 6
    //   464: istore 8
    //   466: iload 4
    //   468: newarray byte
    //   470: astore 11
    //   472: iload 6
    //   474: istore 7
    //   476: iload 6
    //   478: istore 8
    //   480: aload_3
    //   481: aload 11
    //   483: invokevirtual 743	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   486: pop
    //   487: iload 6
    //   489: istore 7
    //   491: iload 6
    //   493: istore 8
    //   495: aload 11
    //   497: iconst_0
    //   498: invokestatic 748	bftf:a	([BI)S
    //   501: ifne +55 -> 556
    //   504: iconst_1
    //   505: istore 9
    //   507: iload 6
    //   509: istore 7
    //   511: iload 6
    //   513: istore 8
    //   515: aload_2
    //   516: iload 9
    //   518: putfield 1029	com/tencent/mobileqq/data/Card:babyQSwitch	Z
    //   521: iload 6
    //   523: istore 7
    //   525: iload 6
    //   527: istore 8
    //   529: aload_3
    //   530: invokevirtual 619	java/nio/ByteBuffer:getShort	()S
    //   533: istore 4
    //   535: iload 10
    //   537: istore 7
    //   539: iload 4
    //   541: ifne -190 -> 351
    //   544: aload_1
    //   545: aload_2
    //   546: invokevirtual 751	amsw:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   549: pop
    //   550: iconst_1
    //   551: istore 7
    //   553: goto -202 -> 351
    //   556: iconst_0
    //   557: istore 9
    //   559: goto -52 -> 507
    //   562: astore_1
    //   563: iload 7
    //   565: istore 6
    //   567: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   570: ifeq +14 -> 584
    //   573: ldc_w 715
    //   576: iconst_2
    //   577: ldc_w 1031
    //   580: aload_1
    //   581: invokestatic 208	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   584: iload 6
    //   586: istore 8
    //   588: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   591: ifeq -185 -> 406
    //   594: ldc_w 715
    //   597: iconst_2
    //   598: new 20	java/lang/StringBuilder
    //   601: dup
    //   602: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   605: ldc_w 1024
    //   608: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: iload 6
    //   613: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   616: ldc_w 1026
    //   619: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   622: aload_2
    //   623: getfield 1029	com/tencent/mobileqq/data/Card:babyQSwitch	Z
    //   626: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   629: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   632: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   635: iload 6
    //   637: istore 8
    //   639: goto -233 -> 406
    //   642: astore_1
    //   643: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   646: ifeq +44 -> 690
    //   649: ldc_w 715
    //   652: iconst_2
    //   653: new 20	java/lang/StringBuilder
    //   656: dup
    //   657: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   660: ldc_w 1024
    //   663: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   666: iload 8
    //   668: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   671: ldc_w 1026
    //   674: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   677: aload_2
    //   678: getfield 1029	com/tencent/mobileqq/data/Card:babyQSwitch	Z
    //   681: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   684: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   687: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   690: aload_1
    //   691: athrow
    //   692: astore_1
    //   693: iconst_1
    //   694: istore 8
    //   696: goto -53 -> 643
    //   699: astore_1
    //   700: iload 6
    //   702: istore 8
    //   704: goto -61 -> 643
    //   707: astore_1
    //   708: iconst_1
    //   709: istore 6
    //   711: goto -144 -> 567
    //   714: iload 9
    //   716: istore 7
    //   718: goto -367 -> 351
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	721	0	this	amov
    //   0	721	1	paramToServiceMsg	ToServiceMsg
    //   0	721	2	paramFromServiceMsg	FromServiceMsg
    //   0	721	3	paramObject	Object
    //   324	216	4	i	int
    //   338	7	5	j	int
    //   15	695	6	bool1	boolean
    //   83	634	7	bool2	boolean
    //   87	616	8	bool3	boolean
    //   74	641	9	bool4	boolean
    //   1	535	10	bool5	boolean
    //   470	26	11	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   89	110	562	java/lang/Exception
    //   122	132	562	java/lang/Exception
    //   143	149	562	java/lang/Exception
    //   157	185	562	java/lang/Exception
    //   206	216	562	java/lang/Exception
    //   228	238	562	java/lang/Exception
    //   246	260	562	java/lang/Exception
    //   268	273	562	java/lang/Exception
    //   281	286	562	java/lang/Exception
    //   298	312	562	java/lang/Exception
    //   320	326	562	java/lang/Exception
    //   334	340	562	java/lang/Exception
    //   442	448	562	java/lang/Exception
    //   466	472	562	java/lang/Exception
    //   480	487	562	java/lang/Exception
    //   495	504	562	java/lang/Exception
    //   515	521	562	java/lang/Exception
    //   529	535	562	java/lang/Exception
    //   89	110	642	finally
    //   122	132	642	finally
    //   143	149	642	finally
    //   157	185	642	finally
    //   206	216	642	finally
    //   228	238	642	finally
    //   246	260	642	finally
    //   268	273	642	finally
    //   281	286	642	finally
    //   298	312	642	finally
    //   320	326	642	finally
    //   334	340	642	finally
    //   442	448	642	finally
    //   466	472	642	finally
    //   480	487	642	finally
    //   495	504	642	finally
    //   515	521	642	finally
    //   529	535	642	finally
    //   544	550	692	finally
    //   567	584	699	finally
    //   544	550	707	java/lang/Exception
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
        break label615;
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
          break label615;
        }
        bool2 = bool1;
        bool3 = bool1;
        bool4 = bool1;
        if (!paramFromServiceMsg.bytes_bodybuffer.has()) {
          break label615;
        }
        bool2 = bool1;
        bool3 = bool1;
        bool4 = bool1;
        if (paramFromServiceMsg.bytes_bodybuffer.get() == null) {
          break label615;
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
        paramFromServiceMsg = (amsw)this.app.getManager(51);
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
      label615:
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
    //   7: ifeq +397 -> 404
    //   10: aload_3
    //   11: ifnull +393 -> 404
    //   14: iconst_1
    //   15: istore 5
    //   17: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   20: ifeq +31 -> 51
    //   23: ldc_w 715
    //   26: iconst_2
    //   27: new 20	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   34: ldc_w 1041
    //   37: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: iload 5
    //   42: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   45: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   51: aload_0
    //   52: getfield 229	amov:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   55: invokevirtual 1042	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   58: ldc_w 1043
    //   61: invokevirtual 1046	mqq/app/MobileQQ:getString	(I)Ljava/lang/String;
    //   64: pop
    //   65: aload_0
    //   66: getfield 229	amov:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   69: invokevirtual 289	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   72: pop
    //   73: iload 5
    //   75: istore 8
    //   77: iload 5
    //   79: ifeq +566 -> 645
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
    //   112: ifnull +298 -> 410
    //   115: iload 5
    //   117: istore 6
    //   119: iload 5
    //   121: istore 7
    //   123: aload_2
    //   124: getfield 128	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   127: invokevirtual 133	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   130: ifne +280 -> 410
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
    //   158: ldc_w 715
    //   161: iconst_2
    //   162: new 20	java/lang/StringBuilder
    //   165: dup
    //   166: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   169: ldc_w 1048
    //   172: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: iload 5
    //   177: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   180: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   183: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   186: iload 5
    //   188: istore 8
    //   190: iload 5
    //   192: ifeq +453 -> 645
    //   195: iload 5
    //   197: istore 6
    //   199: iload 5
    //   201: istore 7
    //   203: iload 5
    //   205: istore 8
    //   207: aload_2
    //   208: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   211: invokevirtual 147	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   214: ifeq +431 -> 645
    //   217: iload 5
    //   219: istore 6
    //   221: iload 5
    //   223: istore 7
    //   225: iload 5
    //   227: istore 8
    //   229: aload_2
    //   230: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   233: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   236: ifnull +409 -> 645
    //   239: iload 5
    //   241: istore 6
    //   243: iload 5
    //   245: istore 7
    //   247: aload_2
    //   248: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   251: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   254: invokevirtual 159	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   257: invokestatic 609	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   260: invokevirtual 612	java/nio/ByteBuffer:getInt	()I
    //   263: istore 4
    //   265: iload 4
    //   267: i2l
    //   268: lstore 10
    //   270: iload 4
    //   272: ifge +16 -> 288
    //   275: iload 4
    //   277: ldc_w 1049
    //   280: iand
    //   281: i2l
    //   282: ldc2_w 1050
    //   285: lor
    //   286: lstore 10
    //   288: iload 5
    //   290: istore 6
    //   292: iload 5
    //   294: istore 7
    //   296: aload_0
    //   297: getfield 229	amov:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   300: invokevirtual 289	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   303: lload 10
    //   305: invokestatic 675	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   308: invokevirtual 678	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   311: istore 5
    //   313: iload 5
    //   315: ifeq +101 -> 416
    //   318: aload_1
    //   319: getfield 595	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   322: ldc_w 1053
    //   325: invokevirtual 668	android/os/Bundle:getShort	(Ljava/lang/String;)S
    //   328: istore 4
    //   330: aload_0
    //   331: getfield 229	amov:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   334: bipush 51
    //   336: invokevirtual 1057	com/tencent/mobileqq/app/QQAppInterface:getBusinessHandler	(I)Lcom/tencent/mobileqq/app/BusinessHandler;
    //   339: checkcast 1059	aara
    //   342: iload 4
    //   344: invokevirtual 1060	aara:b	(I)V
    //   347: iconst_1
    //   348: istore 5
    //   350: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   353: ifeq +50 -> 403
    //   356: ldc_w 715
    //   359: iconst_2
    //   360: new 20	java/lang/StringBuilder
    //   363: dup
    //   364: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   367: ldc_w 1048
    //   370: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: iload 5
    //   375: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   378: ldc_w 731
    //   381: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: aload_1
    //   385: getfield 595	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   388: ldc_w 1053
    //   391: invokevirtual 668	android/os/Bundle:getShort	(Ljava/lang/String;)S
    //   394: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   397: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   400: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   403: return
    //   404: iconst_0
    //   405: istore 5
    //   407: goto -390 -> 17
    //   410: iconst_0
    //   411: istore 5
    //   413: goto -277 -> 136
    //   416: iload 9
    //   418: istore 5
    //   420: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   423: ifeq -73 -> 350
    //   426: ldc_w 715
    //   429: iconst_2
    //   430: new 20	java/lang/StringBuilder
    //   433: dup
    //   434: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   437: ldc_w 1062
    //   440: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   443: lload 10
    //   445: invokevirtual 829	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   448: ldc_w 1064
    //   451: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   454: aload_0
    //   455: getfield 229	amov:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   458: invokevirtual 289	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   461: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   464: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   467: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   470: iload 9
    //   472: istore 5
    //   474: goto -124 -> 350
    //   477: astore_2
    //   478: iconst_0
    //   479: istore 5
    //   481: iload 5
    //   483: istore 6
    //   485: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   488: ifeq +18 -> 506
    //   491: iload 5
    //   493: istore 6
    //   495: ldc_w 715
    //   498: iconst_2
    //   499: ldc_w 1066
    //   502: aload_2
    //   503: invokestatic 208	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   506: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   509: ifeq -106 -> 403
    //   512: ldc_w 715
    //   515: iconst_2
    //   516: new 20	java/lang/StringBuilder
    //   519: dup
    //   520: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   523: ldc_w 1048
    //   526: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: iload 5
    //   531: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   534: ldc_w 731
    //   537: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   540: aload_1
    //   541: getfield 595	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   544: ldc_w 1053
    //   547: invokevirtual 668	android/os/Bundle:getShort	(Ljava/lang/String;)S
    //   550: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   553: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   556: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   559: return
    //   560: astore_2
    //   561: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   564: ifeq +50 -> 614
    //   567: ldc_w 715
    //   570: iconst_2
    //   571: new 20	java/lang/StringBuilder
    //   574: dup
    //   575: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   578: ldc_w 1048
    //   581: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   584: iload 6
    //   586: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   589: ldc_w 731
    //   592: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   595: aload_1
    //   596: getfield 595	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   599: ldc_w 1053
    //   602: invokevirtual 668	android/os/Bundle:getShort	(Ljava/lang/String;)S
    //   605: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   608: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   611: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   614: aload_2
    //   615: athrow
    //   616: astore_2
    //   617: iconst_1
    //   618: istore 6
    //   620: goto -59 -> 561
    //   623: astore_2
    //   624: iconst_0
    //   625: istore 6
    //   627: goto -66 -> 561
    //   630: astore_2
    //   631: iload 7
    //   633: istore 5
    //   635: goto -154 -> 481
    //   638: astore_2
    //   639: iconst_1
    //   640: istore 5
    //   642: goto -161 -> 481
    //   645: iload 8
    //   647: istore 5
    //   649: goto -299 -> 350
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	652	0	this	amov
    //   0	652	1	paramToServiceMsg	ToServiceMsg
    //   0	652	2	paramFromServiceMsg	FromServiceMsg
    //   0	652	3	paramObject	Object
    //   263	80	4	i	int
    //   15	633	5	bool1	boolean
    //   84	542	6	bool2	boolean
    //   88	544	7	bool3	boolean
    //   75	571	8	bool4	boolean
    //   1	470	9	bool5	boolean
    //   268	176	10	l	long
    // Exception table:
    //   from	to	target	type
    //   420	470	477	java/lang/Exception
    //   90	111	560	finally
    //   123	133	560	finally
    //   144	150	560	finally
    //   158	186	560	finally
    //   207	217	560	finally
    //   229	239	560	finally
    //   247	265	560	finally
    //   296	313	560	finally
    //   485	491	560	finally
    //   495	506	560	finally
    //   318	347	616	finally
    //   420	470	623	finally
    //   90	111	630	java/lang/Exception
    //   123	133	630	java/lang/Exception
    //   144	150	630	java/lang/Exception
    //   158	186	630	java/lang/Exception
    //   207	217	630	java/lang/Exception
    //   229	239	630	java/lang/Exception
    //   247	265	630	java/lang/Exception
    //   296	313	630	java/lang/Exception
    //   318	347	638	java/lang/Exception
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
    //   23: ldc_w 715
    //   26: iconst_2
    //   27: new 20	java/lang/StringBuilder
    //   30: dup
    //   31: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   34: ldc_w 1069
    //   37: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   40: iload 5
    //   42: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   45: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   48: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   51: aload_0
    //   52: getfield 229	amov:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   55: invokevirtual 1042	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   58: ldc_w 1043
    //   61: invokevirtual 1046	mqq/app/MobileQQ:getString	(I)Ljava/lang/String;
    //   64: pop
    //   65: aload_0
    //   66: getfield 229	amov:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   69: invokevirtual 289	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
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
    //   154: ldc_w 715
    //   157: iconst_2
    //   158: new 20	java/lang/StringBuilder
    //   161: dup
    //   162: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   165: ldc_w 1071
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
    //   241: invokestatic 609	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   244: invokevirtual 612	java/nio/ByteBuffer:getInt	()I
    //   247: istore 4
    //   249: iload 4
    //   251: i2l
    //   252: lstore 10
    //   254: iload 4
    //   256: ifge +16 -> 272
    //   259: iload 4
    //   261: ldc_w 1049
    //   264: iand
    //   265: i2l
    //   266: ldc2_w 1050
    //   269: lor
    //   270: lstore 10
    //   272: iload 5
    //   274: istore 6
    //   276: iload 5
    //   278: istore 7
    //   280: aload_1
    //   281: getfield 595	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   284: ldc_w 788
    //   287: invokevirtual 792	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   290: istore 9
    //   292: iload 5
    //   294: istore 6
    //   296: iload 5
    //   298: istore 7
    //   300: aload_0
    //   301: getfield 229	amov:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   304: invokevirtual 289	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   307: lload 10
    //   309: invokestatic 675	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   312: invokevirtual 678	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   315: istore 5
    //   317: iload 5
    //   319: ifeq +72 -> 391
    //   322: iconst_1
    //   323: istore 5
    //   325: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   328: ifeq +50 -> 378
    //   331: ldc_w 715
    //   334: iconst_2
    //   335: new 20	java/lang/StringBuilder
    //   338: dup
    //   339: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   342: ldc_w 1071
    //   345: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: iload 5
    //   350: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   353: ldc_w 731
    //   356: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   359: aload_1
    //   360: getfield 595	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   363: ldc_w 788
    //   366: invokevirtual 792	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
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
    //   406: ldc_w 715
    //   409: iconst_2
    //   410: new 20	java/lang/StringBuilder
    //   413: dup
    //   414: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   417: ldc_w 1073
    //   420: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: lload 10
    //   425: invokevirtual 829	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   428: ldc_w 1064
    //   431: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   434: aload_0
    //   435: getfield 229	amov:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   438: invokevirtual 289	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
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
    //   475: ldc_w 715
    //   478: iconst_2
    //   479: ldc_w 1075
    //   482: aload_2
    //   483: invokestatic 208	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   486: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   489: ifeq -111 -> 378
    //   492: ldc_w 715
    //   495: iconst_2
    //   496: new 20	java/lang/StringBuilder
    //   499: dup
    //   500: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   503: ldc_w 1071
    //   506: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: iload 7
    //   511: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   514: ldc_w 731
    //   517: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   520: aload_1
    //   521: getfield 595	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   524: ldc_w 788
    //   527: invokevirtual 792	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   530: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   533: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   536: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   539: return
    //   540: goto -215 -> 325
    //   543: astore_2
    //   544: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   547: ifeq +50 -> 597
    //   550: ldc_w 715
    //   553: iconst_2
    //   554: new 20	java/lang/StringBuilder
    //   557: dup
    //   558: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   561: ldc_w 1071
    //   564: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   567: iload 6
    //   569: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   572: ldc_w 731
    //   575: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: aload_1
    //   579: getfield 595	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   582: ldc_w 788
    //   585: invokevirtual 792	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
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
    //   0	613	0	this	amov
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
          l = bftf.a(paramObject.getInt());
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
            j = bftf.a(paramFromServiceMsg, 0);
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
        paramFromServiceMsg = (bily)this.mApp.getManager(165);
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
  private ExtensionInfo a(amsw paramamsw, String paramString)
  {
    ExtensionInfo localExtensionInfo = paramamsw.a(paramString);
    paramamsw = localExtensionInfo;
    if (localExtensionInfo == null)
    {
      paramamsw = new ExtensionInfo();
      paramamsw.uin = paramString;
    }
    return paramamsw;
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
    if (((avnl)this.app.getManager(303)).b(paramShort))
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
      localTroopManager = (TroopManager)this.app.getManager(52);
      if ((paramInt != 2) && (paramInt != 5) && (paramInt != 7)) {
        break label191;
      }
      paramString = localTroopManager.b(String.valueOf(paramLong));
      if (paramString != null)
      {
        if (paramString.troopname == null) {
          break label163;
        }
        if (!paramString.troopname.equals(paramRespSummaryCard.strGroupName))
        {
          paramString.troopname = paramRespSummaryCard.strGroupName;
          localTroopManager.b(paramString);
        }
      }
    }
    Object localObject;
    label163:
    label191:
    do
    {
      do
      {
        for (;;)
        {
          localObject = bgdk.a(paramRespSummaryCard.strGroupNick.getBytes());
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
      localObject = (amrb)this.app.getManager(53);
      paramString = ((amrb)localObject).a(String.valueOf(paramLong), paramString);
    } while (paramString == null);
    paramString.memberName = paramRespSummaryCard.strNick;
    if ((paramRespSummaryCard.strAutoRemark != null) && (paramRespSummaryCard.strAutoRemark.length() > 0) && (!paramRespSummaryCard.strAutoRemark.equals(paramString.inteRemark)))
    {
      paramString.inteRemark = paramRespSummaryCard.strAutoRemark;
      if (!paramRespSummaryCard.strAutoRemark.equals(paramRespSummaryCard.strNick)) {
        break label315;
      }
    }
    label315:
    for (paramString.inteRemarkSource = 129L;; paramString.inteRemarkSource = 128L)
    {
      ((amrb)localObject).a(paramString);
      return;
    }
  }
  
  private void a(SummaryCard.RespHead paramRespHead, RespSummaryCard paramRespSummaryCard, SparseArray<bbki> paramSparseArray, String paramString, Card paramCard)
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
          awka.a(this.app.getAccount(), paramCard.lVoteCount, paramCard.iVoteIncrement);
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
  
  private void a(RespSummaryCard paramRespSummaryCard, SparseArray<bbki> paramSparseArray, Card paramCard)
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
      String str1 = ampm.a(paramRespSummaryCard.stDateCard.uHomeCountry);
      String str2 = ampm.a(paramRespSummaryCard.stDateCard.uHomeProvince);
      String str3 = ampm.a(paramRespSummaryCard.stDateCard.uHomeCity);
      paramRespSummaryCard = ampm.a(paramRespSummaryCard.stDateCard.uHomeZone);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str1).append("-");
      localStringBuilder.append(str2).append("-");
      localStringBuilder.append(str3).append("-");
      localStringBuilder.append(paramRespSummaryCard);
      paramCard.strHometownCodes = localStringBuilder.toString();
      if (!TextUtils.isEmpty(paramCard.strHometownCodes)) {
        ((ampm)this.app.getManager(59)).a(paramCard);
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
      paramFriends.qqVipInfo = anii.a(paramRespSummaryCard.stVipInfo, EVIPSPEC.E_SP_QQVIP.value(), paramFriends.qqVipInfo);
      paramFriends.superQqInfo = anii.a(paramRespSummaryCard.stVipInfo, EVIPSPEC.E_SP_SUPERQQ.value(), paramFriends.superQqInfo);
      paramFriends.superVipInfo = anii.a(paramRespSummaryCard.stVipInfo, EVIPSPEC.E_SP_SUPERVIP.value(), paramFriends.superVipInfo);
      paramFriends.bigClubInfo = anii.a(paramRespSummaryCard.stVipInfo, EVIPSPEC.E_SP_BIGCLUB.value(), paramFriends.bigClubInfo);
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
      paramFriends.hollywoodVipInfo = anii.a(paramRespSummaryCard.stVipInfo, EVIPSPEC.E_SP_QQVIDEO_HOLLYWOOD.value(), paramFriends.hollywoodVipInfo);
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
    Object localObject = (alnr)this.app.getManager(153);
    if (paramRespSummaryCard.stApollo != null)
    {
      localApolloBaseInfo = ((alnr)localObject).b(paramString);
      localApolloBaseInfo.apolloVipFlag = ((int)paramRespSummaryCard.stApollo.uVipFlag);
      localApolloBaseInfo.apolloVipLevel = ((int)paramRespSummaryCard.stApollo.uVipLevel);
      localApolloBaseInfo.apolloStatus = ((int)paramRespSummaryCard.stApollo.uUserFlag);
      localApolloBaseInfo.apolloServerTS = paramRespSummaryCard.stApollo.uTimestamp;
      ((alnr)localObject).a(localApolloBaseInfo);
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "summaryCard upadte apolloBaseInfo uin: " + paramString + ", apollo vipFlag: " + localApolloBaseInfo.apolloVipFlag + ", apollo vipLevel: " + localApolloBaseInfo.apolloVipLevel + ", apollo status: " + localApolloBaseInfo.apolloStatus + ", apollo svr TS: " + localApolloBaseInfo.apolloServerTS + ", apollo local TS: " + localApolloBaseInfo.apolloLocalTS);
      }
      if (localApolloBaseInfo.apolloServerTS != localApolloBaseInfo.apolloLocalTS)
      {
        paramRespSummaryCard = (VasExtensionHandler)this.app.getBusinessHandler(71);
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
      ((FriendListHandler)this.app.getBusinessHandler(1)).getRichStatus(new String[] { paramString });
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
        aymh.jdField_a_of_type_JavaLangString = paramRespSummaryCard.urlprefix;
      }
      if ((paramRespSummaryCard != null) && (paramRespSummaryCard.stRecom != null))
      {
        paramLong = paramRespSummaryCard.stRecom.iRecomCard;
        paramString = aymh.jdField_a_of_type_JavaLangString + paramRespSummaryCard.stRecom.strRecomUrl;
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
  
  private void a(ampa paramampa, Bundle paramBundle)
  {
    int i;
    if (paramBundle.containsKey("nick"))
    {
      paramampa.jdField_a_of_type_Long |= 1L;
      paramampa.jdField_a_of_type_Int += 1;
      i = paramBundle.getString("nick").getBytes().length;
      paramampa.jdField_b_of_type_Int += i + 4;
      paramampa.jdField_a_of_type_JavaNioByteBuffer.putShort((short)20002);
      paramampa.jdField_a_of_type_JavaNioByteBuffer.putShort((short)paramBundle.getString("nick").getBytes().length);
      paramampa.jdField_a_of_type_JavaNioByteBuffer.put(paramBundle.getString("nick").getBytes());
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "set nick | length = " + i + " | nick = " + paramBundle.getString("nick"));
      }
    }
    if (paramBundle.containsKey("sex"))
    {
      paramampa.jdField_a_of_type_Long |= 0x2;
      paramampa.jdField_a_of_type_Int += 1;
      paramampa.jdField_b_of_type_Int += 5;
      paramampa.jdField_a_of_type_JavaNioByteBuffer.putShort((short)20009);
      paramampa.jdField_a_of_type_JavaNioByteBuffer.putShort((short)1);
      paramampa.jdField_a_of_type_JavaNioByteBuffer.put((byte)(paramBundle.getByte("sex") + 1));
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "set sex | sex = " + paramBundle.getByte("sex"));
      }
    }
    if (paramBundle.containsKey("birthday"))
    {
      paramampa.jdField_a_of_type_Long |= 0x4;
      paramampa.jdField_a_of_type_Int += 1;
      paramampa.jdField_b_of_type_Int += 8;
      paramampa.jdField_a_of_type_JavaNioByteBuffer.putShort((short)26003);
      paramampa.jdField_a_of_type_JavaNioByteBuffer.putShort((short)4);
      paramampa.jdField_a_of_type_JavaNioByteBuffer.putInt(paramBundle.getInt("birthday"));
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "set birthday | birthday = " + paramBundle.getInt("birthday") + " | age = " + paramBundle.getInt("age"));
      }
    }
    if (paramBundle.containsKey("profession"))
    {
      paramampa.jdField_a_of_type_Long |= 0x20;
      i = paramBundle.getInt("profession");
      if (bfre.a(i))
      {
        paramampa.jdField_a_of_type_Int += 1;
        paramampa.jdField_b_of_type_Int += 8;
        paramampa.jdField_a_of_type_JavaNioByteBuffer.putShort((short)27037);
        paramampa.jdField_a_of_type_JavaNioByteBuffer.putShort((short)4);
        paramampa.jdField_a_of_type_JavaNioByteBuffer.putInt(i);
      }
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "set profession | profession = " + paramBundle.getInt("profession"));
      }
    }
  }
  
  private void a(amsw paramamsw, RespSummaryCard paramRespSummaryCard, String paramString, Card paramCard)
  {
    oidb_0x5eb.UdcUinData localUdcUinData = new oidb_0x5eb.UdcUinData();
    if (paramRespSummaryCard.vResp0x5ebInfo != null) {}
    try
    {
      localUdcUinData.mergeFrom(paramRespSummaryCard.vResp0x5ebInfo);
      a(paramamsw, paramString, paramCard, localUdcUinData);
      a(paramString, paramCard, localUdcUinData);
      a(localUdcUinData, paramCard, this.app);
      a(this.app, paramCard, localUdcUinData);
      return;
    }
    catch (Exception paramamsw)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.profilecard.SummaryCard", 2, paramamsw.toString());
    }
  }
  
  private void a(amsw paramamsw, RespSummaryCard paramRespSummaryCard, String paramString, Card paramCard, long paramLong)
  {
    Friends localFriends = paramamsw.d(paramString);
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
      paramamsw.a(localFriends);
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
  
  private void a(amsw paramamsw, String paramString, Card paramCard, oidb_0x5eb.UdcUinData paramUdcUinData)
  {
    boolean bool2 = true;
    paramamsw = paramamsw.d(paramString);
    int i;
    if ((paramString.equals(this.app.getCurrentAccountUin())) && (paramUdcUinData.int32_history_num_flag.has()))
    {
      i = paramUdcUinData.int32_history_num_flag.get();
      bfyz.F(this.mApp.getApplication(), getCurrentAccountUin(), i);
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.SummaryCard", 2, "history_num_flag= " + i);
      }
    }
    long l;
    if (paramUdcUinData.uint64_game_appid.has())
    {
      l = paramUdcUinData.uint64_game_appid.get();
      paramCard.namePlateOfKingGameId = l;
      paramamsw.namePlateOfKingGameId = l;
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.SummaryCard", 2, "namePlateOfKingGameId= " + l);
      }
    }
    if (paramUdcUinData.uint64_game_last_login_time.has())
    {
      l = paramUdcUinData.uint64_game_last_login_time.get();
      paramCard.namePlateOfKingLoginTime = l;
      paramamsw.namePlateOfKingLoginTime = l;
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.SummaryCard", 2, "namePlateOfKingLoginTime= " + l);
      }
    }
    if (paramUdcUinData.uint32_plate_of_king_dan.has())
    {
      i = paramUdcUinData.uint32_plate_of_king_dan.get();
      paramCard.namePlateOfKingDan = i;
      paramamsw.namePlateOfKingDan = i;
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.SummaryCard", 2, "namePlateOfKingDan= " + i);
      }
    }
    if (paramUdcUinData.uint32_plate_of_king_dan_display_switch.has())
    {
      i = paramUdcUinData.uint32_plate_of_king_dan_display_switch.get();
      if (i != 1) {
        break label593;
      }
      bool1 = true;
      paramCard.namePlateOfKingDanDisplatSwitch = bool1;
      if (i != 1) {
        break label599;
      }
    }
    label593:
    label599:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      paramamsw.namePlateOfKingDanDisplatSwitch = bool1;
      if ((!TextUtils.isEmpty(paramString)) && (this.app.getCurrentUin().equals(paramString))) {
        this.app.getApp().getSharedPreferences("sp_plate_of_king", 0).edit().putBoolean("plate_of_king_display_switch_" + this.app.getCurrentUin(), paramamsw.namePlateOfKingDanDisplatSwitch).apply();
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.profilecard.SummaryCard", 2, "namePlateOfKingDanDisplatSwitch= " + i);
      }
      if (paramUdcUinData.uint32_suspend_effect_id.has())
      {
        i = paramUdcUinData.uint32_suspend_effect_id.get();
        if (i >= 0) {
          ((anaj)this.app.getBusinessHandler(13)).a(paramString, i);
        }
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.SummaryCard", 2, "uin " + paramString + " colorScreenid= " + i);
        }
      }
      if (paramUdcUinData.uint32_vas_face_id.has())
      {
        i = paramUdcUinData.uint32_vas_face_id.get();
        ((bgga)this.app.getManager(235)).a.b(paramString, i);
      }
      return;
      bool1 = false;
      break;
    }
  }
  
  private void a(QQAppInterface paramQQAppInterface, Card paramCard, oidb_0x5eb.UdcUinData paramUdcUinData)
  {
    if (paramUdcUinData.uint32_profile_anonymous_answer_switch.has()) {
      azbc.a.a(42425, paramUdcUinData.uint32_profile_anonymous_answer_switch.get(), paramCard, paramQQAppInterface);
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
  
  private void a(Card paramCard, SparseArray<bbki> paramSparseArray)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.i("Q.profilecard.SummaryCard", 2, "handleGetLifeAchievementInfo vvRespList=" + paramSparseArray);
    }
    Object localObject = (bbki)paramSparseArray.get(18);
    if ((localObject != null) && (((bbki)localObject).a != null))
    {
      paramSparseArray = new oidb_0xe5b.RspBody();
      try
      {
        paramSparseArray.mergeFrom(((bbki)localObject).a);
        paramCard.lifeAchievementTotalCount = paramSparseArray.uint32_achievement_totalcount.get();
        paramCard.lifeAchievementOpenId = paramSparseArray.str_achievement_openid.get();
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.SummaryCard", 2, String.format(Locale.getDefault(), "handleGetLifeAchievementInfo totalCount=%s openId=%s", new Object[] { Integer.valueOf(paramCard.lifeAchievementTotalCount), paramCard.lifeAchievementOpenId }));
        }
        paramCard.lifeAchivementList = new ArrayList();
        if (paramSparseArray.rpt_life_ach_item != null) {
          while (i < paramSparseArray.rpt_life_ach_item.size())
          {
            localObject = new ayoc();
            ((ayoc)localObject).jdField_b_of_type_Int = ((oidb_0xe5b.LifeAchievementItem)paramSparseArray.rpt_life_ach_item.get(i)).uint32_achievement_id.get();
            ((ayoc)localObject).jdField_a_of_type_JavaLangString = ((oidb_0xe5b.LifeAchievementItem)paramSparseArray.rpt_life_ach_item.get(i)).str_achievement_title.get();
            ((ayoc)localObject).jdField_b_of_type_JavaLangString = ((oidb_0xe5b.LifeAchievementItem)paramSparseArray.rpt_life_ach_item.get(i)).str_achievement_icon.get();
            ((ayoc)localObject).jdField_a_of_type_Boolean = ((oidb_0xe5b.LifeAchievementItem)paramSparseArray.rpt_life_ach_item.get(i)).bool_has_praised.get();
            ((ayoc)localObject).jdField_c_of_type_Int = ((oidb_0xe5b.LifeAchievementItem)paramSparseArray.rpt_life_ach_item.get(i)).uint32_praise_num.get();
            if (QLog.isColorLevel()) {
              QLog.i("Q.profilecard.SummaryCard", 2, String.format(Locale.getDefault(), "handleGetLifeAchievementInfo id=%s title=%s iconUrl=%s hasPraised=%s praiseNum=%s", new Object[] { Integer.valueOf(((ayoc)localObject).jdField_b_of_type_Int), ((ayoc)localObject).jdField_a_of_type_JavaLangString, ((ayoc)localObject).jdField_b_of_type_JavaLangString, Boolean.valueOf(((ayoc)localObject).jdField_a_of_type_Boolean), Integer.valueOf(((ayoc)localObject).jdField_c_of_type_Int) }));
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
    avsy localavsy = (avsy)this.app.getManager(11);
    if ((localavsy != null) && (localavsy.a(paramFriends.uin) != null)) {
      localavsy.f();
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
    MedalWallMng localMedalWallMng = (MedalWallMng)this.app.getManager(250);
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
              for (paramFromServiceMsg = ((amsw)this.mApp.getManager(51)).a(this.mApp.getCurrentAccountUin(), true);; paramFromServiceMsg = null)
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
      label1044:
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
      paramToServiceMsg.extraData.putIntegerArrayList("req0x5ebFieldIdList", paramQQAppInterface);
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, Card paramCard)
  {
    if (paramToServiceMsg.extraData.getInt("comeFromType") == 37) {
      paramCard.encId = paramToServiceMsg.extraData.getString("strSearchName");
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, Card paramCard, amsw paramamsw)
  {
    StringBuilder localStringBuilder;
    if (paramToServiceMsg.extraData.containsKey("nick"))
    {
      paramCard.strNick = paramToServiceMsg.extraData.getString("nick");
      paramamsw.a(this.app.getCurrentAccountUin(), paramCard.strNick);
      if ((this.app.getCurrentAccountUin() != null) && (this.app.getCurrentAccountUin().equals(paramToServiceMsg.getUin())))
      {
        paramamsw = Constants.PropertiesKey.nickName.toString() + paramToServiceMsg.getUin();
        this.app.getApplication().setProperty(paramamsw, paramCard.strNick);
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder("handleSetDetailInfo set properties");
          localStringBuilder.append("uin = ").append(paramamsw);
          localStringBuilder.append("nickname = ").append(paramCard.strNick);
          localStringBuilder.append("\n");
          QLog.d("CardHandler", 2, localStringBuilder.toString());
        }
      }
      this.app.getBusinessHandler(1).notifyUI(3, true, this.app.getCurrentAccountUin());
    }
    if (paramToServiceMsg.extraData.containsKey("sex"))
    {
      paramCard.shGender = ((short)paramToServiceMsg.extraData.getByte("sex"));
      paramamsw = (awhw)this.app.getManager(106);
      if (paramamsw != null) {
        paramamsw.b(paramCard.shGender);
      }
    }
    if (paramToServiceMsg.extraData.containsKey("birthday"))
    {
      paramCard.lBirthday = paramToServiceMsg.extraData.getInt("birthday");
      paramCard.age = ((byte)paramToServiceMsg.extraData.getInt("age"));
      paramCard.constellation = paramToServiceMsg.extraData.getInt("key_constellation");
      paramamsw = (awhw)this.app.getManager(106);
      if (paramamsw != null) {
        paramamsw.a(paramCard.age);
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
      awka.a(this.app.getAccount(), "self_school_name", paramCard.strSchool);
      if (paramToServiceMsg.extraData.containsKey("location"))
      {
        paramamsw = paramToServiceMsg.extraData.getStringArray("location");
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramamsw[0]).append("-").append(paramamsw[1]).append("-").append(paramamsw[2]).append("-").append(paramamsw[3]);
        paramCard.strLocationCodes = localStringBuilder.toString();
        paramCard.strLocationDesc = paramToServiceMsg.extraData.getString("locationo_desc");
        paramamsw = paramToServiceMsg.extraData.getStringArray("location_name");
        if ((paramamsw != null) && (paramamsw.length == 4)) {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder("nameArray: ");
            int i = 0;
            while (i < 4)
            {
              localStringBuilder.append(paramamsw[i]).append(" ");
              i += 1;
            }
          }
        }
      }
    }
    catch (Exception paramamsw)
    {
      for (;;)
      {
        paramamsw.printStackTrace();
      }
      QLog.d("CardHandler", 2, localStringBuilder.toString());
      paramCard.strCountry = paramamsw[0];
      paramCard.strProvince = paramamsw[1];
      paramCard.strCity = paramamsw[2];
      if (paramToServiceMsg.extraData.containsKey("hometown"))
      {
        paramamsw = paramToServiceMsg.extraData.getStringArray("hometown");
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramamsw[0]).append("-").append(paramamsw[1]).append("-").append(paramamsw[2]).append("-").append(paramamsw[3]);
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
        break label837;
      }
    }
    if (paramToServiceMsg.extraData.getShort("key_extend_friend_switch") == 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramCard.isShowCard = bool;
      label837:
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
      bfyz.a(this.app.getCurrentAccountUin(), "extend_friend_config_785").edit().putInt("sp_extend_friend_flag", i).apply();
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
          ((awhr)this.app.getManager(161)).b(paramCard.strangerVoteOpen);
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
  
  private void a(ByteBuffer paramByteBuffer, short paramShort1, short paramShort2, Long paramLong, Card paramCard, ampc paramampc)
  {
    long l1;
    switch (paramShort1)
    {
    default: 
      return;
    case -23533: 
      paramShort1 = paramByteBuffer.getShort();
      if (paramShort1 != paramampc.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo.apolloVipFlag)
      {
        paramampc.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo.apolloVipFlag = paramShort1;
        paramampc.jdField_a_of_type_Boolean = true;
      }
      QLog.i("ApolloManager", 1, "handleGetDetalInfo apollo vip flag: " + paramShort1);
      return;
    case -23537: 
      paramShort1 = paramByteBuffer.getShort();
      if (paramShort1 != paramampc.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo.apolloVipLevel)
      {
        paramampc.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo.apolloVipLevel = paramShort1;
        paramampc.jdField_a_of_type_Boolean = true;
      }
      QLog.i("ApolloManager", 1, "handleGetDetalInfo apollo vip level: " + paramShort1);
      return;
    case -22556: 
      paramShort1 = paramByteBuffer.getShort();
      if (paramShort1 != paramampc.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo.apolloStatus)
      {
        paramampc.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo.apolloStatus = paramShort1;
        paramampc.jdField_a_of_type_Boolean = true;
        paramByteBuffer = (VasExtensionHandler)this.app.getBusinessHandler(71);
        if (paramByteBuffer != null) {
          paramByteBuffer.notifyUI(3, true, new com.tencent.util.Pair(paramampc.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo.uin, Integer.valueOf(paramShort1)));
        }
      }
      QLog.i("ApolloManager", 1, "handleGetDetalInfo apollo status flag: " + paramShort1);
      return;
    case 27059: 
      l1 = paramByteBuffer.getInt();
      if (l1 != paramampc.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo.apolloServerTS)
      {
        paramampc.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo.apolloServerTS = l1;
        paramampc.jdField_a_of_type_Boolean = true;
      }
      QLog.i("ApolloManager", 1, "handleGetDetalInfo apollo svr TS: " + l1 + ",local TS: " + paramampc.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo.apolloServerTS);
      return;
    case -23306: 
      int i = paramByteBuffer.getShort();
      if (i != paramampc.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo.cmshow3dFlag)
      {
        paramampc.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo.cmshow3dFlag = i;
        paramampc.jdField_a_of_type_Boolean = true;
      }
      QLog.d("ApolloManager", 1, new Object[] { "handleGetDetalInfo apollo svr cmshow3dFlag: ", Short.valueOf(i), ", local cmshow3dFlag: ", Integer.valueOf(paramampc.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo.cmshow3dFlag) });
      return;
    case 27206: 
      l1 = paramByteBuffer.getInt();
      long l2 = NetConnInfoCenter.getServerTime();
      if ((l1 < l2) && (paramampc.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo.apolloSignValidTS != l1))
      {
        paramampc.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo.apolloLocalSignTs = paramampc.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo.apolloSignValidTS;
        paramampc.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo.apolloSignValidTS = l1;
        paramampc.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo.apolloSignStr = "";
        paramampc.jdField_a_of_type_Boolean = true;
      }
      QLog.i("ApolloManager", 1, "handleGetDetalInfo apollo Sign TS: " + l1 + ", currTS: " + l2);
      return;
    case -25019: 
      paramShort1 = paramByteBuffer.getShort();
      if (paramShort1 != alnr.a(this.app)) {
        paramampc.jdField_a_of_type_Alnr.b(paramShort1);
      }
      QLog.i("ApolloManager", 1, "handleGetDetalInfo apollo white list: " + paramShort1);
      return;
    }
    paramShort1 = paramByteBuffer.getInt();
    if ((this.app != null) && (String.valueOf(paramLong).equals(this.app.getCurrentUin()))) {
      paramampc.jdField_a_of_type_Alnr.a(paramShort1, 1);
    }
    if ((paramampc.jdField_a_of_type_Alnr != null) && (paramampc.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo.apolloAISwitch != paramShort1))
    {
      paramampc.jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo.apolloAISwitch = paramShort1;
      paramampc.jdField_a_of_type_Boolean = true;
    }
    if (paramampc.jdField_a_of_type_Alnr != null) {
      paramampc.jdField_a_of_type_Alnr.n = true;
    }
    QLog.i("ApolloManager", 1, "handleGetDetalInfo apollo AIFlag: " + paramShort1);
  }
  
  private void a(ByteBuffer paramByteBuffer, short paramShort1, short paramShort2, Long paramLong, Card paramCard, ampd paramampd)
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
        paramByteBuffer = new bhau(this.app);
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
      bbta.a().a(paramShort1, String.valueOf(paramLong));
      return;
      short s = paramByteBuffer.getShort();
      paramCard.extendFriendEntryAddFriend = s;
      bfyz.a(this.mApp.getCurrentAccountUin(), "extend_friend_config_785").edit().putInt("sp_extend_friend_entry_add_friend", s).apply();
      return;
      s = paramByteBuffer.getShort();
      paramCard.extendFriendQuestion = s;
      paramByteBuffer = this.app.getCurrentAccountUin();
      if (s == 1) {}
      for (;;)
      {
        arhi.a(paramByteBuffer, bool1);
        return;
        bool1 = false;
      }
      paramampd.jdField_b_of_type_Short = paramByteBuffer.getShort();
      if (((Integer)awka.a(this.app.getAccount(), "qq_avatar_type", Integer.valueOf(-1))).intValue() == paramampd.jdField_b_of_type_Short) {
        break;
      }
      awka.a(this.app.getAccount(), "qq_avatar_type", Integer.valueOf(paramampd.jdField_b_of_type_Short));
      return;
      paramampd.jdField_c_of_type_Short = paramByteBuffer.getShort();
      return;
      paramampd.jdField_a_of_type_Short = paramByteBuffer.getShort();
      return;
    }
  }
  
  private void a(ByteBuffer paramByteBuffer, short paramShort1, short paramShort2, Long paramLong, Card paramCard, ampe paramampe)
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
      if (bfre.a(paramShort1))
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
      paramCard.constellation = bftf.a((int)((paramCard.lBirthday & 0xFF00) >> 8), (int)(paramCard.lBirthday & 0xFF));
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
      paramampe.jdField_b_of_type_Boolean = true;
      paramampe.e = ampm.a(paramShort1);
      paramampe.f = ampm.a(paramShort2);
      paramampe.g = ampm.a(i);
      return;
    case 20043: 
      paramShort1 = paramByteBuffer.getInt();
      paramampe.jdField_b_of_type_Boolean = true;
      paramampe.h = ampm.a(paramShort1);
      return;
    case 20032: 
      paramShort1 = paramByteBuffer.getInt();
      paramShort2 = paramByteBuffer.getInt();
      i = paramByteBuffer.getInt();
      paramampe.jdField_a_of_type_Boolean = true;
      paramampe.jdField_a_of_type_JavaLangString = ampm.a(paramShort1);
      paramampe.jdField_b_of_type_JavaLangString = ampm.a(paramShort2);
      paramampe.jdField_c_of_type_JavaLangString = ampm.a(i);
      return;
    case 20041: 
      paramShort1 = paramByteBuffer.getInt();
      paramampe.jdField_a_of_type_Boolean = true;
      paramampe.jdField_d_of_type_JavaLangString = ampm.a(paramShort1);
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
      awka.a(this.app.getAccount(), "self_school_name", paramCard.strSchool);
      return;
    case 20037: 
      paramCard.age = paramByteBuffer.get();
      paramCard.shAge = ((short)paramCard.age);
      return;
    }
    paramCard.constellation = paramByteBuffer.get();
  }
  
  private void a(ByteBuffer paramByteBuffer, short paramShort1, short paramShort2, Long paramLong, Card paramCard, bcop parambcop)
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
        ahns.a(this.app).a(bool1);
        notifyUI(104, true, Boolean.valueOf(bool1));
      } while (!QLog.isColorLevel());
      QLog.i("CardHandler", 2, "handleGetDetailInfo emotionRec onLine:" + bool1);
      return;
    case -23172: 
      if (paramByteBuffer.getShort() == 1) {}
      for (bool1 = bool2;; bool1 = false)
      {
        bcoo.b(bool1);
        ((bcof)this.app.getManager(361)).c(bool1);
        return;
      }
    case -23251: 
      paramShort1 = paramByteBuffer.getShort();
      parambcop.jdField_a_of_type_Boolean = true;
      if (paramShort1 == 1) {}
      for (bool1 = bool3;; bool1 = false)
      {
        parambcop.d = bool1;
        return;
      }
    case -23174: 
      paramShort1 = paramByteBuffer.getShort();
      parambcop.jdField_a_of_type_Boolean = true;
      if (paramShort1 == 1) {}
      for (bool1 = bool4;; bool1 = false)
      {
        parambcop.c = bool1;
        return;
      }
    case -23104: 
      paramShort1 = paramByteBuffer.getShort();
      parambcop.jdField_a_of_type_Boolean = true;
      if (paramShort1 == 1) {}
      for (bool1 = bool5;; bool1 = false)
      {
        parambcop.jdField_b_of_type_Boolean = bool1;
        return;
      }
    case -23046: 
      bcoo.a(paramByteBuffer.getShort());
      return;
    case -23143: 
      paramShort1 = paramByteBuffer.getShort();
      ((aubv)this.app.getManager(379)).a(paramShort1);
      return;
    case -23103: 
      ((afhv)this.app.getManager(388)).a(paramByteBuffer.getShort());
      return;
    case -23102: 
      ((afhv)this.app.getManager(388)).b(paramByteBuffer.getShort());
      return;
    case 27390: 
      ((afhv)this.app.getManager(388)).c(paramByteBuffer.getShort());
      return;
    case -23108: 
      if (paramByteBuffer.getShort() == 0) {}
      for (bool1 = bool6;; bool1 = false)
      {
        bcoo.a(16, bool1);
        return;
      }
    case -23107: 
      if (paramByteBuffer.getShort() == 0) {}
      for (bool1 = bool7;; bool1 = false)
      {
        bcoo.a(32, bool1);
        return;
      }
    }
    if (paramByteBuffer.getShort() == 0) {}
    for (bool1 = bool8;; bool1 = false)
    {
      bcoo.a(8, bool1);
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
      azbc.a.a(41611, paramUdcUinData.uint32_profile_sex_visible.get(), paramCard, paramQQAppInterface);
    }
    if (paramUdcUinData.uint32_profile_age_visible.has()) {
      azbc.a.a(41610, paramUdcUinData.uint32_profile_age_visible.get(), paramCard, paramQQAppInterface);
    }
    if (paramUdcUinData.uint32_profile_birthday_visible.has()) {
      azbc.a.a(41607, paramUdcUinData.uint32_profile_birthday_visible.get(), paramCard, paramQQAppInterface);
    }
    if (paramUdcUinData.uint32_profile_constellation_visible.has()) {
      azbc.a.a(41609, paramUdcUinData.uint32_profile_constellation_visible.get(), paramCard, paramQQAppInterface);
    }
    if (paramUdcUinData.uint32_profile_profession_visible.has()) {
      azbc.a.a(41618, paramUdcUinData.uint32_profile_profession_visible.get(), paramCard, paramQQAppInterface);
    }
    if (paramUdcUinData.uint32_profile_college_visible.has()) {
      azbc.a.a(41619, paramUdcUinData.uint32_profile_college_visible.get(), paramCard, paramQQAppInterface);
    }
    if (paramUdcUinData.uint32_profile_location_visible.has()) {
      azbc.a.a(41614, paramUdcUinData.uint32_profile_location_visible.get(), paramCard, paramQQAppInterface);
    }
    if (paramUdcUinData.uint32_profile_hometown_visible.has()) {
      azbc.a.a(41613, paramUdcUinData.uint32_profile_hometown_visible.get(), paramCard, paramQQAppInterface);
    }
    if (paramUdcUinData.uint32_profile_email_visible.has()) {
      azbc.a.a(41622, paramUdcUinData.uint32_profile_email_visible.get(), paramCard, paramQQAppInterface);
    }
    if (paramUdcUinData.uint32_profile_personal_note_visible.has()) {
      azbc.a.a(41623, paramUdcUinData.uint32_profile_personal_note_visible.get(), paramCard, paramQQAppInterface);
    }
    if (paramUdcUinData.uint32_profile_company_visible.has()) {
      azbc.a.a(40272, paramUdcUinData.uint32_profile_company_visible.get(), paramCard, paramQQAppInterface);
    }
  }
  
  private boolean a(Card paramCard, SparseArray<bbki> paramSparseArray, long paramLong1, long paramLong2)
  {
    int i = 0;
    Object localObject1 = (bbki)paramSparseArray.get(17);
    if ((localObject1 != null) && (((bbki)localObject1).a != null))
    {
      if (paramLong1 == paramLong2)
      {
        paramSparseArray = new INTERFACE.StGetUserAppListRsp();
        try
        {
          paramSparseArray.mergeFrom(((bbki)localObject1).a);
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
            paramSparseArray.mergeFrom(((bbki)localObject1).a);
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
        paramFromServiceMsg = Long.valueOf(bftf.a(paramToServiceMsg.getInt()));
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
        j = bftf.a(paramObject, 0);
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
        paramObject = (bily)this.mApp.getManager(165);
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
        paramToServiceMsg = ((MedalWallMng)this.app.getManager(250)).a(paramFromServiceMsg, false);
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
          ((airj)this.app.getManager(295)).a(bool1, i, bool2);
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
          paramObject = new bblb().a(paramObject);
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
    paramFromServiceMsg.add(new AutoReplyText(amtj.a(2131700598), 2147483647));
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
        ((axuo)this.app.getManager(319)).a(paramFromServiceMsg, j);
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
        ((axuo)this.app.getManager(319)).a(paramFromServiceMsg, j);
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
              break label428;
            }
            i = ByteBuffer.wrap(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray()).getInt();
            if (i >= 0) {
              break label402;
            }
          }
          label402:
          for (long l = i + 4294967296L;; l = i)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.profilecard.", 2, "handleSetStrangerInviteToGroupSwitch uin=" + this.app.getCurrentAccountUin() + "  lUin:" + String.valueOf(l));
            }
            if (!this.app.getCurrentAccountUin().equals(String.valueOf(l))) {
              break label428;
            }
            paramFromServiceMsg = (amsw)this.app.getManager(51);
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
    label428:
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
    //   29: ldc_w 3237
    //   32: iconst_2
    //   33: new 20	java/lang/StringBuilder
    //   36: dup
    //   37: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   40: ldc_w 3239
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
    //   69: ldc_w 3237
    //   72: iconst_2
    //   73: new 20	java/lang/StringBuilder
    //   76: dup
    //   77: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   80: ldc_w 3241
    //   83: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: aload_2
    //   87: invokevirtual 107	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   90: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   93: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   99: aload_1
    //   100: getfield 595	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   103: ldc_w 3243
    //   106: invokevirtual 792	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   109: ifne +26 -> 135
    //   112: iload 11
    //   114: istore 7
    //   116: aload_0
    //   117: bipush 105
    //   119: iconst_0
    //   120: iload 7
    //   122: invokestatic 180	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   125: invokevirtual 184	amov:notifyUI	(IZLjava/lang/Object;)V
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
    //   218: ldc_w 3237
    //   221: iconst_2
    //   222: new 20	java/lang/StringBuilder
    //   225: dup
    //   226: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   229: ldc_w 3245
    //   232: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   235: aload_2
    //   236: getfield 128	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   239: invokevirtual 133	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   242: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   245: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: invokestatic 115	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   251: aload_1
    //   252: getfield 595	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   255: ldc_w 3243
    //   258: invokevirtual 792	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   261: ifne +26 -> 287
    //   264: iload 12
    //   266: istore 7
    //   268: aload_0
    //   269: bipush 105
    //   271: iconst_0
    //   272: iload 7
    //   274: invokestatic 180	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   277: invokevirtual 184	amov:notifyUI	(IZLjava/lang/Object;)V
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
    //   301: new 3247	tencent/im/oidb/cmd0xd8a$RspBody
    //   304: dup
    //   305: invokespecial 3248	tencent/im/oidb/cmd0xd8a$RspBody:<init>	()V
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
    //   328: invokevirtual 3249	tencent/im/oidb/cmd0xd8a$RspBody:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   331: pop
    //   332: iload 4
    //   334: istore 5
    //   336: iload 4
    //   338: istore 6
    //   340: aload_3
    //   341: getfield 3252	tencent/im/oidb/cmd0xd8a$RspBody:uint32_retcode	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   344: invokevirtual 133	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   347: istore 4
    //   349: iload 4
    //   351: istore 5
    //   353: iload 4
    //   355: istore 6
    //   357: aload_3
    //   358: getfield 3255	tencent/im/oidb/cmd0xd8a$RspBody:str_res	Lcom/tencent/mobileqq/pb/PBStringField;
    //   361: invokevirtual 886	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   364: astore_2
    //   365: iload 4
    //   367: istore 5
    //   369: iload 4
    //   371: istore 6
    //   373: ldc_w 3237
    //   376: iconst_1
    //   377: new 20	java/lang/StringBuilder
    //   380: dup
    //   381: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   384: ldc_w 3257
    //   387: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: iload 4
    //   392: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   395: ldc_w 3259
    //   398: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   401: aload_2
    //   402: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   405: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   408: invokestatic 115	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   411: aload_1
    //   412: getfield 595	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   415: ldc_w 3243
    //   418: invokevirtual 792	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   421: istore 7
    //   423: iload 4
    //   425: ifne +12 -> 437
    //   428: aload_0
    //   429: bipush 105
    //   431: iconst_1
    //   432: aconst_null
    //   433: invokevirtual 184	amov:notifyUI	(IZLjava/lang/Object;)V
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
    //   455: invokevirtual 184	amov:notifyUI	(IZLjava/lang/Object;)V
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
    //   478: ldc_w 3237
    //   481: iconst_1
    //   482: new 20	java/lang/StringBuilder
    //   485: dup
    //   486: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   489: ldc_w 3261
    //   492: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   495: aload_2
    //   496: invokevirtual 1996	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   499: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   502: invokestatic 115	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   505: aload_1
    //   506: getfield 595	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   509: ldc_w 3243
    //   512: invokevirtual 792	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   515: istore 7
    //   517: iload 4
    //   519: ifne +74 -> 593
    //   522: aload_0
    //   523: bipush 105
    //   525: iconst_1
    //   526: aconst_null
    //   527: invokevirtual 184	amov:notifyUI	(IZLjava/lang/Object;)V
    //   530: return
    //   531: iload 4
    //   533: istore 5
    //   535: ldc_w 3237
    //   538: iconst_1
    //   539: new 20	java/lang/StringBuilder
    //   542: dup
    //   543: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   546: ldc_w 3263
    //   549: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: aload_2
    //   553: invokevirtual 1996	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   556: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   559: invokestatic 115	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   562: goto -57 -> 505
    //   565: astore_2
    //   566: aload_1
    //   567: getfield 595	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   570: ldc_w 3243
    //   573: invokevirtual 792	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   576: istore 7
    //   578: iload 5
    //   580: ifne +41 -> 621
    //   583: aload_0
    //   584: bipush 105
    //   586: iconst_1
    //   587: aconst_null
    //   588: invokevirtual 184	amov:notifyUI	(IZLjava/lang/Object;)V
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
    //   611: invokevirtual 184	amov:notifyUI	(IZLjava/lang/Object;)V
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
    //   639: invokevirtual 184	amov:notifyUI	(IZLjava/lang/Object;)V
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
    //   0	662	0	this	amov
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
    //   36: ldc_w 3266
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
    //   148: ldc_w 3268
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
    //   248: invokestatic 609	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   251: invokevirtual 612	java/nio/ByteBuffer:getInt	()I
    //   254: invokestatic 1010	bftf:a	(I)J
    //   257: lstore 11
    //   259: iload 4
    //   261: istore 7
    //   263: iload 4
    //   265: istore 5
    //   267: aload_0
    //   268: getfield 229	amov:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   271: invokevirtual 289	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   274: lload 11
    //   276: invokestatic 675	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   279: invokevirtual 678	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   282: ifeq +124 -> 406
    //   285: iload 4
    //   287: istore 7
    //   289: iload 4
    //   291: istore 5
    //   293: aload_1
    //   294: getfield 595	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   297: ldc_w 3270
    //   300: invokevirtual 792	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   303: istore 6
    //   305: iload 6
    //   307: istore 5
    //   309: aload_0
    //   310: getfield 229	amov:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   313: invokestatic 2832	ahns:a	(Lcom/tencent/mobileqq/app/QQAppInterface;)Lahns;
    //   316: iload 5
    //   318: invokevirtual 2834	ahns:a	(Z)V
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
    //   349: ldc_w 3268
    //   352: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: iload 8
    //   357: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   360: ldc_w 3272
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
    //   390: invokevirtual 184	amov:notifyUI	(IZLjava/lang/Object;)V
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
    //   446: ldc_w 3274
    //   449: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: aload_0
    //   453: getfield 229	amov:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   456: invokevirtual 289	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   459: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: ldc_w 1014
    //   465: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   468: lload 11
    //   470: invokevirtual 829	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
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
    //   507: ldc_w 3276
    //   510: aload_1
    //   511: invokestatic 189	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   514: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   517: ifeq +134 -> 651
    //   520: ldc 195
    //   522: iconst_2
    //   523: new 20	java/lang/StringBuilder
    //   526: dup
    //   527: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   530: ldc_w 3268
    //   533: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: iconst_0
    //   537: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   540: ldc_w 3272
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
    //   585: ldc_w 3268
    //   588: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: iload 4
    //   593: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   596: ldc_w 3272
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
    //   0	654	0	this	amov
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
    //   32: ldc_w 715
    //   35: iconst_2
    //   36: new 20	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   43: ldc_w 3279
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
    //   230: invokestatic 609	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   233: astore_2
    //   234: iload 5
    //   236: istore 10
    //   238: iload 5
    //   240: istore 7
    //   242: iload 14
    //   244: istore 9
    //   246: aload_2
    //   247: invokevirtual 612	java/nio/ByteBuffer:getInt	()I
    //   250: istore 4
    //   252: iload 4
    //   254: i2l
    //   255: lstore 15
    //   257: iload 4
    //   259: ifge +12 -> 271
    //   262: iload 4
    //   264: ldc_w 1049
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
    //   284: invokevirtual 615	java/nio/ByteBuffer:get	()B
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
    //   309: invokevirtual 619	java/nio/ByteBuffer:getShort	()S
    //   312: invokestatic 630	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   315: invokevirtual 729	java/lang/Short:shortValue	()S
    //   318: iconst_1
    //   319: if_icmpne +36 -> 355
    //   322: iload 5
    //   324: istore 10
    //   326: iload 5
    //   328: istore 7
    //   330: iload 14
    //   332: istore 9
    //   334: aload_2
    //   335: invokevirtual 619	java/nio/ByteBuffer:getShort	()S
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
    //   369: ldc_w 715
    //   372: iconst_2
    //   373: new 20	java/lang/StringBuilder
    //   376: dup
    //   377: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   380: ldc_w 3281
    //   383: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   386: iload 6
    //   388: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   391: ldc_w 3283
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
    //   426: invokevirtual 184	amov:notifyUI	(IZLjava/lang/Object;)V
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
    //   455: invokevirtual 619	java/nio/ByteBuffer:getShort	()S
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
    //   497: invokevirtual 743	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   500: pop
    //   501: iload 5
    //   503: istore 10
    //   505: iload 5
    //   507: istore 7
    //   509: iload 14
    //   511: istore 9
    //   513: aload_3
    //   514: iconst_0
    //   515: invokestatic 748	bftf:a	([BI)S
    //   518: istore 4
    //   520: iload 4
    //   522: ifne +32 -> 554
    //   525: iconst_1
    //   526: istore 6
    //   528: aload_2
    //   529: invokevirtual 619	java/nio/ByteBuffer:getShort	()S
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
    //   560: getstatic 3287	com/tencent/common/app/BaseApplicationImpl:context	Lcom/tencent/qphone/base/util/BaseApplication;
    //   563: aload_0
    //   564: getfield 229	amov:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   567: invokevirtual 289	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   570: aconst_null
    //   571: ldc_w 3289
    //   574: invokestatic 3293	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:isContainValue	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    //   577: istore 5
    //   579: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   582: ifeq +30 -> 612
    //   585: ldc 195
    //   587: iconst_2
    //   588: new 20	java/lang/StringBuilder
    //   591: dup
    //   592: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   595: ldc_w 3295
    //   598: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: iload 5
    //   603: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   606: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   609: invokestatic 875	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   612: aload_0
    //   613: getfield 229	amov:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   616: invokevirtual 1042	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   619: aload_1
    //   620: invokevirtual 2422	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   623: aconst_null
    //   624: ldc_w 3289
    //   627: iload 6
    //   629: invokestatic 3299	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:writeValue	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
    //   632: iload 6
    //   634: invokestatic 3302	bjnm:a	(Z)V
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
    //   684: ldc_w 715
    //   687: iconst_2
    //   688: ldc_w 3304
    //   691: aload_1
    //   692: invokestatic 208	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   695: iload 5
    //   697: istore 7
    //   699: iload 6
    //   701: istore 9
    //   703: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   706: ifeq -290 -> 416
    //   709: ldc_w 715
    //   712: iconst_2
    //   713: new 20	java/lang/StringBuilder
    //   716: dup
    //   717: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   720: ldc_w 3281
    //   723: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   726: iload 5
    //   728: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   731: ldc_w 3283
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
    //   770: ldc_w 715
    //   773: iconst_2
    //   774: new 20	java/lang/StringBuilder
    //   777: dup
    //   778: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   781: ldc_w 3281
    //   784: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   787: iload 5
    //   789: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   792: ldc_w 3283
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
    //   0	841	0	this	amov
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
            localObject = new aymx();
            ((aymx)localObject).jdField_a_of_type_Int = paramObject.uint32_idx.get();
            ((aymx)localObject).jdField_c_of_type_JavaLangString = paramObject.str_department_id.get();
            ((aymx)localObject).jdField_d_of_type_JavaLangString = paramObject.str_department_name.get();
            ((aymx)localObject).jdField_a_of_type_JavaLangString = paramObject.str_school_id.get();
            ((aymx)localObject).jdField_b_of_type_JavaLangString = paramObject.str_school_name.get();
            ((aymx)localObject).jdField_b_of_type_Int = paramObject.uint32_category.get();
            ((aymx)localObject).jdField_c_of_type_Int = paramObject.uint32_degree.get();
            ((aymx)localObject).jdField_d_of_type_Int = paramObject.uint32_enrollment_year.get();
            ((aymx)localObject).e = paramObject.uint32_graduation_year.get();
            ((aymx)localObject).f = paramObject.uint32_allow_recommend.get();
            if (paramObject.uint32_hidden_flag.get() == 1)
            {
              bool = true;
              label292:
              ((aymx)localObject).jdField_a_of_type_Boolean = bool;
              if (paramObject.uint32_verify_status.get() != 2) {
                break label336;
              }
            }
            label336:
            for (boolean bool = true;; bool = false)
            {
              ((aymx)localObject).jdField_b_of_type_Boolean = bool;
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
      ((apgi)this.app.getManager(112)).a(paramToServiceMsg);
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
            break label455;
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
                  break label461;
                }
                bool2 = bool3;
              }
              paramFromServiceMsg = (amsw)this.app.getManager(51);
              paramToServiceMsg = paramFromServiceMsg.c(paramToServiceMsg);
              if (paramToServiceMsg.troopHonorSwitch != bool2)
              {
                paramToServiceMsg.troopHonorSwitch = bool2;
                paramFromServiceMsg.a(paramToServiceMsg);
                notifyUI(113, bool1, Boolean.valueOf(paramToServiceMsg.troopHonorSwitch));
                ((anca)this.app.getBusinessHandler(20)).notifyUI(80, true, null);
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
      label455:
      bool1 = false;
      continue;
      label461:
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
      paramString = (awhw)this.app.getManager(106);
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
        QLog.i("Q.profilecard.SummaryCard", 2, "strShowName = " + bftf.b(paramRespSummaryCard.strShowName));
      }
    }
  }
  
  private void b(ampa paramampa, Bundle paramBundle)
  {
    int i;
    if (paramBundle.containsKey("company"))
    {
      paramampa.jdField_a_of_type_Long |= 0x40;
      paramampa.jdField_a_of_type_Int += 1;
      i = paramBundle.getString("company").getBytes().length;
      paramampa.jdField_b_of_type_Int += i + 4;
      paramampa.jdField_a_of_type_JavaNioByteBuffer.putShort((short)24008);
      paramampa.jdField_a_of_type_JavaNioByteBuffer.putShort((short)i);
      paramampa.jdField_a_of_type_JavaNioByteBuffer.put(paramBundle.getString("company").getBytes());
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "set company | length = " + i + " | company = " + paramBundle.getString("company"));
      }
    }
    if (paramBundle.containsKey("college"))
    {
      paramampa.jdField_a_of_type_Long |= 0x80;
      paramampa.jdField_a_of_type_Int += 1;
      i = paramBundle.getString("college").getBytes().length;
      paramampa.jdField_b_of_type_Int += i + 4;
      paramampa.jdField_a_of_type_JavaNioByteBuffer.putShort((short)20021);
      paramampa.jdField_a_of_type_JavaNioByteBuffer.putShort((short)i);
      paramampa.jdField_a_of_type_JavaNioByteBuffer.put(paramBundle.getString("college").getBytes());
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "set college | length = " + i + " | college = " + paramBundle.getString("college"));
      }
    }
    String[] arrayOfString;
    if (paramBundle.containsKey("location"))
    {
      paramampa.jdField_a_of_type_Long |= 0x100;
      paramampa.jdField_a_of_type_Int += 2;
      paramampa.jdField_b_of_type_Int += 24;
      arrayOfString = paramBundle.getStringArray("location");
      paramampa.jdField_a_of_type_JavaNioByteBuffer.putShort((short)20032).putShort((short)12).putInt(ampm.a(arrayOfString[0])).putInt(ampm.a(arrayOfString[1])).putInt(ampm.a(arrayOfString[2]));
      paramampa.jdField_a_of_type_JavaNioByteBuffer.putShort((short)20041).putShort((short)4).putInt(ampm.a(arrayOfString[3]));
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "set location | location = " + arrayOfString.toString() + ", code one = " + arrayOfString[0]);
      }
    }
    if (paramBundle.containsKey("hometown"))
    {
      paramampa.jdField_a_of_type_Long |= 0x800;
      paramampa.jdField_a_of_type_Int += 2;
      paramampa.jdField_b_of_type_Int += 24;
      arrayOfString = paramBundle.getStringArray("hometown");
      paramampa.jdField_a_of_type_JavaNioByteBuffer.putShort((short)24002).putShort((short)12).putInt(ampm.a(arrayOfString[0])).putInt(ampm.a(arrayOfString[1])).putInt(ampm.a(arrayOfString[2]));
      paramampa.jdField_a_of_type_JavaNioByteBuffer.putShort((short)20043).putShort((short)4).putInt(ampm.a(arrayOfString[3]));
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "set hometown | hometown = " + arrayOfString.toString());
      }
    }
    if (paramBundle.containsKey("email"))
    {
      paramampa.jdField_a_of_type_Long |= 0x2000;
      paramampa.jdField_a_of_type_Int += 1;
      i = paramBundle.getString("email").getBytes().length;
      paramampa.jdField_b_of_type_Int += i + 4;
      paramampa.jdField_a_of_type_JavaNioByteBuffer.putShort((short)20011).putShort((short)i).put(paramBundle.getString("email").getBytes());
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "set email | length = " + i + " | email = " + paramBundle.getString("email"));
      }
    }
    if (paramBundle.containsKey("personalNote"))
    {
      paramampa.jdField_a_of_type_Long |= 0x4000;
      paramampa.jdField_a_of_type_Int += 1;
      i = paramBundle.getString("personalNote").getBytes().length;
      paramampa.jdField_b_of_type_Int += i + 4;
      paramampa.jdField_a_of_type_JavaNioByteBuffer.putShort((short)20019).putShort((short)i).put(paramBundle.getString("personalNote").getBytes());
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "set note | length = " + i + " | note = " + paramBundle.getString("personalNote"));
      }
    }
  }
  
  private void b(Card paramCard, SparseArray<bbki> paramSparseArray)
  {
    boolean bool = false;
    paramSparseArray = (bbki)paramSparseArray.get(19);
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
        paramSparseArray = new ayuo();
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
        ayup localayup;
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
          localayup = ayup.a((oidb_0xec4.Quest)((Iterator)localObject).next(), l);
          if ((localayup == null) || (TextUtils.isEmpty(localayup.jdField_b_of_type_JavaLangString)) || (TextUtils.isEmpty(localayup.jdField_c_of_type_JavaLangString))) {
            continue;
          }
          localArrayList.add(localayup);
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
              paramShort2 = ((Integer)awka.a(this.app.getAccount(), "nearby_people_avatar_upload_ok", Integer.valueOf(-1))).intValue();
            } while ((paramShort2 == paramShort1) || (paramShort2 == 1));
            awka.a(this.app.getAccount(), "nearby_people_avatar_upload_ok", Integer.valueOf(paramShort1));
            return;
            paramShort1 = paramByteBuffer.getShort();
            paramByteBuffer = this.app.getAccount();
            if (paramShort1 == 1) {
              bool1 = true;
            }
            awka.a(paramByteBuffer, "nearby_need_show_guide", Boolean.valueOf(bool1));
            return;
            paramShort1 = paramByteBuffer.getShort();
            paramByteBuffer = this.app.getAccount();
            if (paramShort1 == 1) {}
            for (bool1 = bool2;; bool1 = false)
            {
              awka.a(paramByteBuffer, "is_nearby_novice", Boolean.valueOf(bool1));
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
        ((aara)this.app.getBusinessHandler(51)).a(paramShort1);
        return;
        paramShort1 = paramByteBuffer.getShort();
        ((aara)this.app.getBusinessHandler(51)).b(paramShort1);
        return;
        paramShort1 = paramByteBuffer.getShort();
        paramByteBuffer = (amwo)this.app.getManager(92);
      } while (paramByteBuffer == null);
      paramByteBuffer.d(paramShort1);
      return;
      s = paramByteBuffer.getShort();
      paramByteBuffer = (axfy)this.app.getManager(160);
    } while (paramByteBuffer == null);
    paramByteBuffer.a(s);
  }
  
  /* Error */
  private boolean b(Card paramCard, SparseArray<bbki> paramSparseArray)
  {
    // Byte code:
    //   0: aload_2
    //   1: bipush 16
    //   3: invokevirtual 1999	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   6: checkcast 2001	bbki
    //   9: astore 5
    //   11: aload 5
    //   13: ifnull +809 -> 822
    //   16: aload 5
    //   18: getfield 2003	bbki:a	[B
    //   21: ifnull +801 -> 822
    //   24: new 2068	com/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp
    //   27: dup
    //   28: invokespecial 3750	com/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp:<init>	()V
    //   31: astore_2
    //   32: aload_2
    //   33: aload 5
    //   35: getfield 2003	bbki:a	[B
    //   38: invokevirtual 3751	com/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   41: pop
    //   42: aload_2
    //   43: getfield 3754	com/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp:iRetCode	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   46: invokevirtual 390	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   49: ifne +717 -> 766
    //   52: aload_2
    //   53: getfield 3757	com/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp:lhLogoLv	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   56: invokevirtual 3758	com/tencent/mobileqq/pb/PBInt32Field:has	()Z
    //   59: ifeq +14 -> 73
    //   62: aload_1
    //   63: aload_2
    //   64: getfield 3757	com/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp:lhLogoLv	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   67: invokevirtual 390	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   70: putfield 3761	com/tencent/mobileqq/data/Card:lhLevel	I
    //   73: aload_2
    //   74: getfield 2072	com/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp:stPrivilegeRsp	Lcom/tencent/pb/profilecard/VaProfileGate$PrivilegeBaseInfoRsp;
    //   77: astore 5
    //   79: aload_2
    //   80: getfield 3765	com/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp:stGiftRsp	Lcom/tencent/pb/profilecard/VaProfileGate$GetGiftListRsp;
    //   83: astore 6
    //   85: iconst_0
    //   86: istore_3
    //   87: iload_3
    //   88: aload_2
    //   89: getfield 3768	com/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp:rpt_task_item	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   92: invokevirtual 167	com/tencent/mobileqq/pb/PBRepeatMessageField:size	()I
    //   95: if_icmpge +37 -> 132
    //   98: aload_2
    //   99: getfield 3768	com/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp:rpt_task_item	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   102: iload_3
    //   103: invokevirtual 170	com/tencent/mobileqq/pb/PBRepeatMessageField:get	(I)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   106: checkcast 3770	com/tencent/pb/profilecard/VaProfileGate$CommTaskInfo
    //   109: astore 7
    //   111: iconst_4
    //   112: aload 7
    //   114: getfield 3773	com/tencent/pb/profilecard/VaProfileGate$CommTaskInfo:uint32_appid	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   117: invokevirtual 133	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   120: if_icmpne +714 -> 834
    //   123: aload 7
    //   125: aload_1
    //   126: invokestatic 3778	ayor:a	(Lcom/tencent/pb/profilecard/VaProfileGate$CommTaskInfo;Lcom/tencent/mobileqq/data/Card;)V
    //   129: goto +705 -> 834
    //   132: aload_1
    //   133: aload 6
    //   135: getfield 3783	com/tencent/pb/profilecard/VaProfileGate$GetGiftListRsp:desc	Lcom/tencent/mobileqq/pb/PBStringField;
    //   138: invokevirtual 886	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   141: putfield 3786	com/tencent/mobileqq/data/Card:presentDesc	Ljava/lang/String;
    //   144: aload_1
    //   145: aload 6
    //   147: getfield 3789	com/tencent/pb/profilecard/VaProfileGate$GetGiftListRsp:custom_url	Lcom/tencent/mobileqq/pb/PBStringField;
    //   150: invokevirtual 886	com/tencent/mobileqq/pb/PBStringField:get	()Ljava/lang/String;
    //   153: putfield 3792	com/tencent/mobileqq/data/Card:presentCustourl	Ljava/lang/String;
    //   156: aload_1
    //   157: aload 6
    //   159: getfield 3795	com/tencent/pb/profilecard/VaProfileGate$GetGiftListRsp:is_on	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   162: invokevirtual 2053	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   165: putfield 3798	com/tencent/mobileqq/data/Card:presentSwitch	Z
    //   168: aload_1
    //   169: aload 6
    //   171: getfield 3802	com/tencent/pb/profilecard/VaProfileGate$GetGiftListRsp:gift_url	Lcom/tencent/mobileqq/pb/PBRepeatField;
    //   174: invokevirtual 3805	com/tencent/mobileqq/pb/PBRepeatField:get	()Ljava/util/List;
    //   177: putfield 3808	com/tencent/mobileqq/data/Card:presentUrl	Ljava/util/List;
    //   180: aload 6
    //   182: getfield 3795	com/tencent/pb/profilecard/VaProfileGate$GetGiftListRsp:is_on	Lcom/tencent/mobileqq/pb/PBBoolField;
    //   185: invokevirtual 2053	com/tencent/mobileqq/pb/PBBoolField:get	()Z
    //   188: ifeq +145 -> 333
    //   191: aload_0
    //   192: getfield 229	amov:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   195: ldc 250
    //   197: ldc 250
    //   199: ldc 250
    //   201: ldc_w 3810
    //   204: ldc_w 3810
    //   207: iconst_0
    //   208: iconst_0
    //   209: ldc 250
    //   211: ldc 250
    //   213: ldc 250
    //   215: ldc 250
    //   217: invokestatic 3815	bcef:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   220: aload_1
    //   221: getfield 3808	com/tencent/mobileqq/data/Card:presentUrl	Ljava/util/List;
    //   224: invokeinterface 399 1 0
    //   229: ifle +166 -> 395
    //   232: aload_1
    //   233: iconst_1
    //   234: putfield 3818	com/tencent/mobileqq/data/Card:showPresent	Z
    //   237: aload_0
    //   238: aload_1
    //   239: aload_2
    //   240: aload 5
    //   242: invokespecial 3820	amov:a	(Lcom/tencent/mobileqq/data/Card;Lcom/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp;Lcom/tencent/pb/profilecard/VaProfileGate$PrivilegeBaseInfoRsp;)V
    //   245: aload_2
    //   246: getfield 3823	com/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp:rpt_oidb_flag	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   249: invokevirtual 853	com/tencent/mobileqq/pb/PBRepeatMessageField:has	()Z
    //   252: ifeq +400 -> 652
    //   255: aload_2
    //   256: getfield 3823	com/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp:rpt_oidb_flag	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   259: invokevirtual 396	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   262: astore 6
    //   264: iconst_0
    //   265: istore_3
    //   266: iload_3
    //   267: aload 6
    //   269: invokeinterface 399 1 0
    //   274: if_icmpge +378 -> 652
    //   277: aload 6
    //   279: iload_3
    //   280: invokeinterface 401 2 0
    //   285: checkcast 3825	com/tencent/pb/profilecard/VaProfileGate$OidbFlagInfo
    //   288: astore 7
    //   290: aload 7
    //   292: getfield 3828	com/tencent/pb/profilecard/VaProfileGate$OidbFlagInfo:uint32_fieled	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   295: invokevirtual 133	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   298: ldc_w 3829
    //   301: if_icmpne +135 -> 436
    //   304: aload 7
    //   306: getfield 3832	com/tencent/pb/profilecard/VaProfileGate$OidbFlagInfo:byets_value	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   309: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   312: invokevirtual 2083	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   315: astore 7
    //   317: aload_1
    //   318: aload 7
    //   320: invokestatic 3835	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   323: putfield 3838	com/tencent/mobileqq/data/Card:mQQLevelType	I
    //   326: iload_3
    //   327: iconst_1
    //   328: iadd
    //   329: istore_3
    //   330: goto -64 -> 266
    //   333: aload_0
    //   334: getfield 229	amov:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   337: ldc 250
    //   339: ldc 250
    //   341: ldc 250
    //   343: ldc_w 3840
    //   346: ldc_w 3840
    //   349: iconst_0
    //   350: iconst_0
    //   351: ldc 250
    //   353: ldc 250
    //   355: ldc 250
    //   357: ldc 250
    //   359: invokestatic 3815	bcef:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    //   362: goto -142 -> 220
    //   365: astore_1
    //   366: ldc_w 2130
    //   369: iconst_1
    //   370: new 20	java/lang/StringBuilder
    //   373: dup
    //   374: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   377: ldc_w 3842
    //   380: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: aload_1
    //   384: invokevirtual 1996	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   387: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   390: invokestatic 115	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   393: iconst_0
    //   394: ireturn
    //   395: aload_1
    //   396: iconst_0
    //   397: putfield 3818	com/tencent/mobileqq/data/Card:showPresent	Z
    //   400: goto -163 -> 237
    //   403: astore 8
    //   405: ldc_w 2130
    //   408: iconst_2
    //   409: new 20	java/lang/StringBuilder
    //   412: dup
    //   413: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   416: ldc_w 3844
    //   419: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: aload 7
    //   424: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   427: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   430: invokestatic 115	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   433: goto -107 -> 326
    //   436: aload 7
    //   438: getfield 3828	com/tencent/pb/profilecard/VaProfileGate$OidbFlagInfo:uint32_fieled	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   441: invokevirtual 133	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   444: ldc_w 3845
    //   447: if_icmpne +61 -> 508
    //   450: aload 7
    //   452: getfield 3832	com/tencent/pb/profilecard/VaProfileGate$OidbFlagInfo:byets_value	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   455: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   458: invokevirtual 2083	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   461: astore 7
    //   463: aload_1
    //   464: aload 7
    //   466: invokestatic 3848	java/lang/Short:parseShort	(Ljava/lang/String;)S
    //   469: putfield 2680	com/tencent/mobileqq/data/Card:switch_musicbox	S
    //   472: goto -146 -> 326
    //   475: astore 8
    //   477: ldc_w 2130
    //   480: iconst_2
    //   481: new 20	java/lang/StringBuilder
    //   484: dup
    //   485: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   488: ldc_w 3850
    //   491: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   494: aload 7
    //   496: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   502: invokestatic 115	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   505: goto -179 -> 326
    //   508: aload 7
    //   510: getfield 3828	com/tencent/pb/profilecard/VaProfileGate$OidbFlagInfo:uint32_fieled	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   513: invokevirtual 133	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   516: ldc_w 3851
    //   519: if_icmpne +61 -> 580
    //   522: aload 7
    //   524: getfield 3832	com/tencent/pb/profilecard/VaProfileGate$OidbFlagInfo:byets_value	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   527: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   530: invokevirtual 2083	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   533: astore 7
    //   535: aload_1
    //   536: aload 7
    //   538: invokestatic 3848	java/lang/Short:parseShort	(Ljava/lang/String;)S
    //   541: putfield 1578	com/tencent/mobileqq/data/Card:nameplateVipType	I
    //   544: goto -218 -> 326
    //   547: astore 8
    //   549: ldc_w 2130
    //   552: iconst_2
    //   553: new 20	java/lang/StringBuilder
    //   556: dup
    //   557: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   560: ldc_w 3853
    //   563: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   566: aload 7
    //   568: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   574: invokestatic 115	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   577: goto -251 -> 326
    //   580: aload 7
    //   582: getfield 3828	com/tencent/pb/profilecard/VaProfileGate$OidbFlagInfo:uint32_fieled	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   585: invokevirtual 133	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   588: ldc_w 3854
    //   591: if_icmpne -265 -> 326
    //   594: aload 7
    //   596: getfield 3832	com/tencent/pb/profilecard/VaProfileGate$OidbFlagInfo:byets_value	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   599: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   602: invokevirtual 2083	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   605: astore 7
    //   607: aload_1
    //   608: aload 7
    //   610: invokestatic 3848	java/lang/Short:parseShort	(Ljava/lang/String;)S
    //   613: putfield 1582	com/tencent/mobileqq/data/Card:grayNameplateFlag	I
    //   616: goto -290 -> 326
    //   619: astore 8
    //   621: ldc_w 2130
    //   624: iconst_2
    //   625: new 20	java/lang/StringBuilder
    //   628: dup
    //   629: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   632: ldc_w 3856
    //   635: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   638: aload 7
    //   640: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   643: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   646: invokestatic 115	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   649: goto -323 -> 326
    //   652: aload_2
    //   653: getfield 3860	com/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp:st_vip_care	Lcom/tencent/pb/profilecard/VaProfileGate$GetVipCareRsp;
    //   656: invokevirtual 3863	com/tencent/pb/profilecard/VaProfileGate$GetVipCareRsp:has	()Z
    //   659: ifeq +62 -> 721
    //   662: aload_2
    //   663: getfield 3860	com/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp:st_vip_care	Lcom/tencent/pb/profilecard/VaProfileGate$GetVipCareRsp;
    //   666: invokevirtual 3864	com/tencent/pb/profilecard/VaProfileGate$GetVipCareRsp:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   669: checkcast 3862	com/tencent/pb/profilecard/VaProfileGate$GetVipCareRsp
    //   672: astore_1
    //   673: aload_1
    //   674: getfield 3867	com/tencent/pb/profilecard/VaProfileGate$GetVipCareRsp:uint32_buss	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   677: invokevirtual 133	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   680: istore_3
    //   681: aload_1
    //   682: getfield 3870	com/tencent/pb/profilecard/VaProfileGate$GetVipCareRsp:uint32_notice	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   685: invokevirtual 133	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   688: istore 4
    //   690: iload_3
    //   691: ifeq +30 -> 721
    //   694: iload 4
    //   696: ifeq +25 -> 721
    //   699: aload_0
    //   700: getfield 229	amov:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   703: sipush 235
    //   706: invokevirtual 235	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   709: checkcast 1953	bgga
    //   712: iload_3
    //   713: iconst_4
    //   714: ishl
    //   715: iload 4
    //   717: ior
    //   718: invokevirtual 3871	bgga:a	(I)V
    //   721: aload_2
    //   722: getfield 2072	com/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp:stPrivilegeRsp	Lcom/tencent/pb/profilecard/VaProfileGate$PrivilegeBaseInfoRsp;
    //   725: invokevirtual 2075	com/tencent/pb/profilecard/VaProfileGate$PrivilegeBaseInfoRsp:has	()Z
    //   728: ifne +15 -> 743
    //   731: ldc_w 2130
    //   734: iconst_1
    //   735: ldc_w 3873
    //   738: invokestatic 115	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   741: iconst_0
    //   742: ireturn
    //   743: aload 5
    //   745: getfield 2078	com/tencent/pb/profilecard/VaProfileGate$PrivilegeBaseInfoRsp:uIsGrayUsr	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   748: invokevirtual 133	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   751: ifne +69 -> 820
    //   754: ldc_w 2130
    //   757: iconst_1
    //   758: ldc_w 3875
    //   761: invokestatic 115	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   764: iconst_0
    //   765: ireturn
    //   766: ldc_w 2130
    //   769: iconst_1
    //   770: new 20	java/lang/StringBuilder
    //   773: dup
    //   774: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   777: ldc_w 3877
    //   780: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   783: aload_2
    //   784: getfield 3754	com/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp:iRetCode	Lcom/tencent/mobileqq/pb/PBInt32Field;
    //   787: invokevirtual 390	com/tencent/mobileqq/pb/PBInt32Field:get	()I
    //   790: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   793: ldc_w 3879
    //   796: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   799: aload_2
    //   800: getfield 3882	com/tencent/pb/profilecard/VaProfileGate$VaProfileGateRsp:sRetMsg	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   803: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   806: invokevirtual 2083	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   809: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   812: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   815: invokestatic 115	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   818: iconst_0
    //   819: ireturn
    //   820: iconst_1
    //   821: ireturn
    //   822: ldc_w 2130
    //   825: iconst_1
    //   826: ldc_w 3884
    //   829: invokestatic 115	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   832: iconst_0
    //   833: ireturn
    //   834: iload_3
    //   835: iconst_1
    //   836: iadd
    //   837: istore_3
    //   838: goto -751 -> 87
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	841	0	this	amov
    //   0	841	1	paramCard	Card
    //   0	841	2	paramSparseArray	SparseArray<bbki>
    //   86	752	3	i	int
    //   688	30	4	j	int
    //   9	735	5	localObject1	Object
    //   83	195	6	localObject2	Object
    //   109	530	7	localObject3	Object
    //   403	1	8	localNumberFormatException1	NumberFormatException
    //   475	1	8	localNumberFormatException2	NumberFormatException
    //   547	1	8	localNumberFormatException3	NumberFormatException
    //   619	1	8	localNumberFormatException4	NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   32	73	365	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   73	85	365	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   87	129	365	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   132	220	365	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   220	237	365	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   237	264	365	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   266	317	365	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   317	326	365	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   333	362	365	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   395	400	365	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   405	433	365	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   436	463	365	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   463	472	365	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   477	505	365	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   508	535	365	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   535	544	365	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   549	577	365	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   580	607	365	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   607	616	365	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   621	649	365	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   652	690	365	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   699	721	365	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   721	741	365	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   743	764	365	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   766	818	365	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   317	326	403	java/lang/NumberFormatException
    //   463	472	475	java/lang/NumberFormatException
    //   535	544	547	java/lang/NumberFormatException
    //   607	616	619	java/lang/NumberFormatException
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
                ((anaj)this.app.getBusinessHandler(13)).a(paramShort1, false);
                return;
              } while (2 != paramShort2);
              paramCard = new byte[paramShort2];
              paramByteBuffer.get(paramCard);
              bool1 = bool3;
              if (bftf.a(paramCard, 0) == 0) {
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
          if (bftf.a(paramCard, 0) == 0) {
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
      ((amsw)this.app.getManager(51)).a(this.app.getCurrentAccountUin(), paramByteBuffer, (byte)-1);
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
      bool2 = axgj.a(this.app);
      if (paramByteBuffer.getShort() != 0) {}
      for (;;)
      {
        paramCard.medalSwitchDisable = bool1;
        paramByteBuffer = BaseApplicationImpl.getApplication().getSharedPreferences("medal_wall_" + paramLong, 4).edit();
        paramByteBuffer.putBoolean("medal_switch_disable", paramCard.medalSwitchDisable);
        paramByteBuffer.commit();
        bool1 = axgj.a(this.app);
        if (bool2 == bool1) {
          break;
        }
        axgj.a(this.app, bool1);
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
    for (bool1 = awgt.a(this.app.getCurrentUin());; bool1 = false)
    {
      if (paramByteBuffer.getShort() == 1) {}
      while ((bool1 != bool2) && (this.app != null))
      {
        awgt.a(this.app.getCurrentUin(), bool2);
        return;
        bool2 = false;
      }
      if (paramByteBuffer.getShort() == 0) {}
      for (bool1 = bool6;; bool1 = false)
      {
        bcqk.a(this.app, bool1);
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
        if (((n <= 0) && (i1 <= 0)) || (TextUtils.isEmpty(paramRespSummaryCard)) || (!bftf.a(paramCard.uin, this.app.getCurrentAccountUin()))) {
          break label418;
        }
        localObject = ((MedalWallMng)this.app.getManager(250)).a(paramRespSummaryCard);
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
      bfyz.a(this.mApp.getCurrentAccountUin(), "extend_friend_config_785").edit().putInt("sp_extend_friend_entry_contact", paramShort1).apply();
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
        aqvs.b(paramByteBuffer, paramLong, bool1);
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
        paramByteBuffer = (avnl)this.app.getManager(303);
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
        ((avnl)this.app.getManager(303)).a(paramShort1, bool1, false);
        return;
      }
    }
    boolean bool2;
    if (paramByteBuffer.getShort() == 1)
    {
      bool1 = true;
      bfxf.a(this.app);
      paramByteBuffer = aqgp.c();
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
        paramLong = (aqai)apub.a().a(442);
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
        bool2 = agkq.d;
        long l2 = agkq.jdField_a_of_type_Long;
        if (bool1)
        {
          if (!bool2)
          {
            localEditor.putLong(paramCard, l1);
            agkq.jdField_a_of_type_Long = l1;
          }
          localEditor.putBoolean(str, true);
          agkq.e = true;
        }
        for (;;)
        {
          localEditor.putBoolean(paramLong, bool1);
          localEditor.apply();
          agkq.d = bool1;
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
            ((amsw)this.app.getManager(51)).a(paramToServiceMsg);
          }
          bftg.a(this.app, l1, j);
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
        label556:
        QLog.i("Q.profilecard.", 2, paramToServiceMsg);
      }
    }
    else
    {
      if (paramObject == null) {
        break label631;
      }
    }
    label631:
    for (paramToServiceMsg = "-201";; paramToServiceMsg = "-202")
    {
      paramFromServiceMsg.put("param_FailCode", paramToServiceMsg);
      StatisticCollector.getInstance(this.app.getApp()).collectPerformance(String.valueOf(l2), "profileCardSendFavorite", false, 0L, 0L, paramFromServiceMsg, "", false);
      bool1 = bool2;
      break;
      paramToServiceMsg = "null";
      break label556;
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
      aymv localaymv;
      ArrayList localArrayList3;
      try
      {
        ((SummaryCardBusiEntry.comm)localObject1).mergeFrom((byte[])localObject2);
        j = ((SummaryCardBusiEntry.comm)localObject1).result.get();
        localObject2 = new aymu();
        if (j != 0) {
          break label752;
        }
        ((aymu)localObject2).jdField_a_of_type_JavaLangString = ((SummaryCardBusiEntry.comm)localObject1).msg_rich_display.strName.get();
        ((aymu)localObject2).jdField_b_of_type_JavaLangString = ((SummaryCardBusiEntry.comm)localObject1).msg_rich_display.strServiceUrl.get();
        ((aymu)localObject2).jdField_a_of_type_Int = ((SummaryCardBusiEntry.comm)localObject1).service.get();
        localArrayList2 = new ArrayList();
        j = 0;
        if (j >= ((SummaryCardBusiEntry.comm)localObject1).msg_rich_display.rptUiList.size()) {
          break label745;
        }
        SummaryCardBusiEntry.ui_info localui_info = (SummaryCardBusiEntry.ui_info)((SummaryCardBusiEntry.comm)localObject1).msg_rich_display.rptUiList.get(j);
        localaymv = new aymv();
        localaymv.jdField_a_of_type_JavaLangString = localui_info.strTitle.get();
        localaymv.jdField_b_of_type_JavaLangString = localui_info.strCoverUrl.get();
        localaymv.jdField_c_of_type_JavaLangString = localui_info.strJmpUrl.get();
        localaymv.jdField_d_of_type_JavaLangString = localui_info.strSubInfo.get();
        localaymv.e = localui_info.strDesc.get();
        localaymv.f = localui_info.strTitleIconUrl.get();
        localaymv.jdField_a_of_type_Long = localui_info.uint64_group_code.get();
        localaymv.jdField_a_of_type_Int = ((aymu)localObject2).jdField_a_of_type_Int;
        if (i == 0)
        {
          if (j == 0) {
            localaymv.jdField_b_of_type_Int = 0;
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
          aymt localaymt = new aymt();
          localaymt.jdField_a_of_type_JavaLangString = localLabel.bytes_name.get().toStringUtf8();
          localaymt.jdField_a_of_type_Long = localLabel.uint32_label_type.get();
          localaymt.jdField_b_of_type_Long = localLabel.uint32_label_attr.get();
          ayms localayms = new ayms();
          localayms.jdField_a_of_type_Long = localLabel.edging_color.uint32_r.get();
          localayms.jdField_b_of_type_Long = localLabel.edging_color.uint32_g.get();
          localayms.c = localLabel.edging_color.uint32_b.get();
          localaymt.jdField_b_of_type_Ayms = localayms;
          localayms = new ayms();
          localayms.jdField_a_of_type_Long = localLabel.text_color.uint32_r.get();
          localayms.jdField_b_of_type_Long = localLabel.text_color.uint32_g.get();
          localayms.c = localLabel.text_color.uint32_b.get();
          localaymt.jdField_a_of_type_Ayms = localayms;
          localArrayList3.add(localaymt);
          k += 1;
          continue;
        }
        localaymv.jdField_b_of_type_Int = 1;
        continue;
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      catch (Exception localException) {}
      QLog.i("Q.profilecard.SummaryCard", 2, localException.toString());
      break;
      label677:
      localaymv.jdField_a_of_type_JavaUtilArrayList = localArrayList3;
      label684:
      localArrayList2.add(localaymv);
      if (QLog.isColorLevel())
      {
        QLog.d("Q.profilecard.SummaryCard", 2, String.format("HobbiesEntry Item strTitle=%s serviceType=%s strJmpUrl=%s", new Object[] { localaymv.jdField_a_of_type_JavaLangString, Integer.valueOf(localaymv.jdField_a_of_type_Int), localaymv.jdField_c_of_type_JavaLangString }));
        break label819;
        label745:
        ((aymu)localObject2).jdField_a_of_type_JavaUtilArrayList = localArrayList2;
        label752:
        localArrayList1.add(localObject2);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("Q.profilecard.SummaryCard", 2, String.format("HobbiesEntry strName=%s strServiceType=%s strServiceUrl=%s", new Object[] { ((aymu)localObject2).jdField_a_of_type_JavaLangString, ((aymu)localObject2).jdField_c_of_type_JavaLangString, ((aymu)localObject2).jdField_b_of_type_JavaLangString }));
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
      paramObject = ((amsw)this.app.getManager(51)).c(paramToServiceMsg.getUin());
      localRespGetFavoriteList = (RespGetFavoriteList)paramFromServiceMsg.getAttribute("result");
      if (!QLog.isColorLevel()) {
        break label529;
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
      label232:
      if (localIterator.hasNext())
      {
        UserProfile localUserProfile = (UserProfile)localIterator.next();
        CardProfile localCardProfile = new CardProfile();
        localCardProfile.readFrom(localUserProfile);
        localCardProfile.type = 3;
        localArrayList.add(localCardProfile);
        if ((!QLog.isColorLevel()) || (paramFromServiceMsg == null)) {
          break label526;
        }
        paramFromServiceMsg.append("\n");
        paramFromServiceMsg.append("i=").append(i).append(",");
        paramFromServiceMsg.append(localCardProfile.getSimpleZanInfo());
        i += 1;
      }
      label526:
      for (;;)
      {
        break label232;
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
        paramToServiceMsg = ((amsw)this.app.getManager(51)).c(paramToServiceMsg.getUin());
        paramBundle.putLong("startMid", -1L);
        notifyUI(42, false, new Object[] { paramToServiceMsg, paramBundle, a(3, 7) });
        return;
      }
      label529:
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
      paramObject = ((amsw)this.app.getManager(51)).c(paramToServiceMsg.getUin());
      localRespGetVoterList = (RespGetVoterList)paramFromServiceMsg.getAttribute("result");
      if (QLog.isColorLevel()) {
        QLog.d("CardHandler", 2, "[handleReqVoterList] replyCode = " + localRespGetVoterList.stHeader.iReplyCode);
      }
      if (!QLog.isColorLevel()) {
        break label745;
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
          break label742;
        }
        paramFromServiceMsg.append("\n");
        paramFromServiceMsg.append("i=").append(i).append(",");
        paramFromServiceMsg.append(localCardProfile.getSimpleZanInfo());
        i += 1;
      }
      label742:
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
        paramToServiceMsg = ((amsw)this.app.getManager(51)).c(paramToServiceMsg.getUin());
        paramBundle.putLong("startMid", -1L);
        notifyUI(6, false, new Object[] { paramToServiceMsg, paramBundle, a(2, 7) });
        return;
      }
      label745:
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
        bcef.b(this.app, "dc00899", "NOW", "", "qq_zlk", "logo_exp", 0, 0, paramCard.uin, "", "", "");
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
        paramObject = (awhr)this.app.getManager(161);
        if (l1 != 0L) {
          break label241;
        }
        bool2 = true;
        label61:
        paramObject.b(bool2);
        paramObject = PreferenceManager.getDefaultSharedPreferences(this.app.getApp()).edit();
        String str = this.app.getApplication().getString(2131694544) + this.app.getCurrentAccountUin();
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
          ((awhr)this.app.getManager(161)).b(bool1);
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
        localSharedPreferences.edit().putBoolean(this.app.getApplication().getString(2131694544) + this.app.getCurrentAccountUin(), bool1).commit();
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
      for (bool1 = ((awhr)this.app.getManager(161)).b();; bool1 = localSharedPreferences.getBoolean(this.app.getApplication().getString(2131694544) + this.app.getCurrentAccountUin(), false))
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
    paramBundle = (amsw)this.app.getManager(51);
    if (paramFromServiceMsg.isSuccess())
    {
      if (!(paramObject instanceof RespSetCard)) {
        break label669;
      }
      paramToServiceMsg = (RespSetCard)paramObject;
      if ((paramToServiceMsg.stHeader == null) || (paramToServiceMsg.stHeader.iReplyCode != 0) || (paramToServiceMsg.vRespSetTemplate == null)) {
        break label669;
      }
      paramObject = (SSummaryCardRsp)decodePacket(paramToServiceMsg.vRespSetTemplate, "rsp", new SSummaryCardRsp());
      if (paramObject == null) {
        break label669;
      }
      if (paramObject.res == 0)
      {
        paramToServiceMsg = paramBundle.b(this.app.getCurrentAccountUin());
        if (paramToServiceMsg == null) {
          break label664;
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
          break label606;
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
      label606:
      paramToServiceMsg = paramFromServiceMsg;
      continue;
      notifyUI(41, false, paramBundle.c(this.app.getCurrentAccountUin()));
      bhvw.a().a(paramFromServiceMsg.getServiceCmd(), 100, paramFromServiceMsg.getBusinessFailCode(), this.app.getCurrentAccountUin(), 1000277, amtj.a(2131700597), true);
      return;
      label664:
      paramFromServiceMsg = null;
      continue;
      label669:
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
        break label210;
      }
      paramToServiceMsg = (SSummaryCardLableRsp)paramObject;
      if (paramToServiceMsg.ret != 0) {
        break;
      }
      if (paramToServiceMsg.likes != null)
      {
        paramFromServiceMsg = (amsw)this.app.getManager(51);
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
    label210:
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetProfileLabel fail from msf retCode : " + paramFromServiceMsg.getResultCode());
    }
    notifyUI(52, false, paramObject);
    if (QLog.isColorLevel()) {
      QLog.e("CardHandler", 2, "-->report MM:cmd=" + paramFromServiceMsg.getServiceCmd() + ",error code=" + paramFromServiceMsg.getBusinessFailCode() + ",uin=" + this.app.getCurrentAccountUin());
    }
    bhvw.a().a(paramFromServiceMsg.getServiceCmd(), 100, paramFromServiceMsg.getBusinessFailCode(), this.app.getCurrentAccountUin(), 1000277, amtj.a(2131700600), true);
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
      paramBundle = (amsw)this.app.getManager(51);
      localCard = paramBundle.c(String.valueOf(paramToServiceMsg.extraData.getLong("destUin")));
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
      notifyUI(53, true, new Object[] { localCard, Long.valueOf(Long.valueOf(l).longValue()) });
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetLabelLike retCode : " + paramToServiceMsg.ret + ", msg : " + paramToServiceMsg.msg);
    }
    notifyUI(53, false, localCard);
    return;
    label254:
    if (QLog.isColorLevel()) {
      QLog.d("ProfileCard.setcard", 2, "CardHandler->handleSetLabelLike fail from msf retCode : " + paramFromServiceMsg.getResultCode());
    }
    notifyUI(53, false, localCard);
    if (QLog.isColorLevel()) {
      QLog.e("CardHandler", 2, "-->report MM:cmd=" + paramFromServiceMsg.getServiceCmd() + ",error code=" + paramFromServiceMsg.getBusinessFailCode() + ",uin=" + this.app.getCurrentAccountUin());
    }
    bhvw.a().a(paramFromServiceMsg.getServiceCmd(), 100, paramFromServiceMsg.getBusinessFailCode(), this.app.getCurrentAccountUin(), 1000277, amtj.a(2131700599), true);
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
        paramToServiceMsg = (amsw)this.app.getManager(51);
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
    amsw localamsw;
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
      localamsw = null;
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
        label263:
        paramFromServiceMsg = localamsw;
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
        break label528;
      }
      paramFromServiceMsg = localObject1;
      k = i;
      localamsw = (amsw)this.app.getManager(51);
      paramFromServiceMsg = localObject1;
      k = i;
      paramObject = localamsw.c(this.app.getCurrentAccountUin());
      paramFromServiceMsg = paramObject;
      k = i;
      a(paramToServiceMsg, paramObject, localamsw);
      paramFromServiceMsg = paramObject;
      k = i;
      localamsw.a(paramObject);
      paramToServiceMsg = paramObject;
    }
    catch (Exception paramObject)
    {
      label409:
      label511:
      break label409;
      label517:
      paramToServiceMsg = null;
      break label263;
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
        break label517;
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
        break label263;
      }
      QLog.d("CardHandler", 2, "handleGetDetailInfo", paramObject);
      paramToServiceMsg = paramFromServiceMsg;
      i = k;
      bool2 = bool1;
      break label263;
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder().append("setDetailInfo fail : ");
        if (paramFromServiceMsg == null) {
          break label511;
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
    //   4: ifeq +337 -> 341
    //   7: aload_3
    //   8: instanceof 1208
    //   11: ifeq +330 -> 341
    //   14: iconst_1
    //   15: istore 6
    //   17: iload 6
    //   19: ifeq +1424 -> 1443
    //   22: aload_0
    //   23: aload_2
    //   24: invokevirtual 5360	com/tencent/qphone/base/remote/FromServiceMsg:getWupBuffer	()[B
    //   27: ldc_w 5362
    //   30: new 1267	SummaryCard/RespHead
    //   33: dup
    //   34: invokespecial 5363	SummaryCard/RespHead:<init>	()V
    //   37: invokevirtual 1701	amov:decodePacket	([BLjava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   40: checkcast 1267	SummaryCard/RespHead
    //   43: astore 4
    //   45: aload 4
    //   47: ifnull +300 -> 347
    //   50: aload 4
    //   52: getfield 5366	SummaryCard/RespHead:iResult	I
    //   55: istore 5
    //   57: iload 5
    //   59: ifne +288 -> 347
    //   62: iconst_1
    //   63: istore 6
    //   65: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   68: ifeq +37 -> 105
    //   71: ldc 195
    //   73: iconst_2
    //   74: ldc_w 5368
    //   77: iconst_2
    //   78: anewarray 248	java/lang/Object
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
    //   99: invokestatic 1279	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   102: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   105: aload_1
    //   106: getfield 595	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   109: ldc_w 4255
    //   112: invokevirtual 2519	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   115: lstore 7
    //   117: aload_1
    //   118: getfield 595	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   121: ldc_w 2412
    //   124: invokevirtual 719	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   127: astore 13
    //   129: aload_1
    //   130: getfield 595	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   133: ldc_w 2410
    //   136: invokevirtual 1807	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   139: istore 5
    //   141: aload_1
    //   142: getfield 595	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   145: ldc_w 4257
    //   148: invokevirtual 2519	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   151: lstore 9
    //   153: iload 6
    //   155: ifeq +1176 -> 1331
    //   158: aload_0
    //   159: getfield 229	amov:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   162: bipush 51
    //   164: invokevirtual 235	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   167: checkcast 237	amsw
    //   170: astore_2
    //   171: aload_0
    //   172: getfield 229	amov:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   175: bipush 52
    //   177: invokevirtual 235	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   180: checkcast 1198	com/tencent/mobileqq/app/TroopManager
    //   183: astore 14
    //   185: aload_3
    //   186: checkcast 1208	SummaryCard/RespSummaryCard
    //   189: astore_3
    //   190: aload_3
    //   191: getfield 5371	SummaryCard/RespSummaryCard:vvRespServices	Ljava/util/ArrayList;
    //   194: invokestatic 5376	com/tencent/mobileqq/service/lbs/BusinessBuff:a	(Ljava/util/ArrayList;)Landroid/util/SparseArray;
    //   197: astore 15
    //   199: lload 7
    //   201: lconst_0
    //   202: lcmp
    //   203: ifgt +187 -> 390
    //   206: iload 5
    //   208: bipush 41
    //   210: if_icmpeq +180 -> 390
    //   213: iload 5
    //   215: bipush 6
    //   217: if_icmpeq +173 -> 390
    //   220: iload 5
    //   222: bipush 45
    //   224: if_icmpeq +166 -> 390
    //   227: aload_2
    //   228: aload 13
    //   230: invokevirtual 5379	amsw:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/ContactCard;
    //   233: astore_1
    //   234: aload_1
    //   235: aload_3
    //   236: getfield 3554	SummaryCard/RespSummaryCard:bAge	B
    //   239: putfield 5382	com/tencent/mobileqq/data/ContactCard:bAge	B
    //   242: aload_1
    //   243: aload_3
    //   244: getfield 3551	SummaryCard/RespSummaryCard:bSex	B
    //   247: putfield 5383	com/tencent/mobileqq/data/ContactCard:bSex	B
    //   250: aload_1
    //   251: aload_3
    //   252: getfield 1230	SummaryCard/RespSummaryCard:strNick	Ljava/lang/String;
    //   255: putfield 5385	com/tencent/mobileqq/data/ContactCard:nickName	Ljava/lang/String;
    //   258: aload_1
    //   259: aload_3
    //   260: getfield 5386	SummaryCard/RespSummaryCard:strProvince	Ljava/lang/String;
    //   263: putfield 5387	com/tencent/mobileqq/data/ContactCard:strProvince	Ljava/lang/String;
    //   266: aload_1
    //   267: aload_3
    //   268: getfield 5388	SummaryCard/RespSummaryCard:strCountry	Ljava/lang/String;
    //   271: putfield 5389	com/tencent/mobileqq/data/ContactCard:strCountry	Ljava/lang/String;
    //   274: aload_1
    //   275: aload_3
    //   276: getfield 5390	SummaryCard/RespSummaryCard:strCity	Ljava/lang/String;
    //   279: putfield 5391	com/tencent/mobileqq/data/ContactCard:strCity	Ljava/lang/String;
    //   282: aload_1
    //   283: aload_3
    //   284: getfield 5394	SummaryCard/RespSummaryCard:strContactName	Ljava/lang/String;
    //   287: putfield 5395	com/tencent/mobileqq/data/ContactCard:strContactName	Ljava/lang/String;
    //   290: aload_3
    //   291: getfield 5398	SummaryCard/RespSummaryCard:iContactNotBindQQ	I
    //   294: iconst_1
    //   295: if_icmpeq +80 -> 375
    //   298: iconst_1
    //   299: istore 6
    //   301: aload_1
    //   302: iload 6
    //   304: putfield 5401	com/tencent/mobileqq/data/ContactCard:bindQQ	Z
    //   307: aload_3
    //   308: getfield 1227	SummaryCard/RespSummaryCard:lUIN	J
    //   311: lconst_0
    //   312: lcmp
    //   313: ifle +68 -> 381
    //   316: aload_1
    //   317: aload_3
    //   318: getfield 1227	SummaryCard/RespSummaryCard:lUIN	J
    //   321: invokestatic 675	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   324: putfield 5402	com/tencent/mobileqq/data/ContactCard:uin	Ljava/lang/String;
    //   327: aload_2
    //   328: aload_1
    //   329: invokevirtual 5405	amsw:a	(Lcom/tencent/mobileqq/data/ContactCard;)Z
    //   332: pop
    //   333: aload_0
    //   334: iconst_1
    //   335: iconst_1
    //   336: aload_1
    //   337: invokevirtual 184	amov:notifyUI	(IZLjava/lang/Object;)V
    //   340: return
    //   341: iconst_0
    //   342: istore 6
    //   344: goto -327 -> 17
    //   347: iconst_0
    //   348: istore 6
    //   350: goto -285 -> 65
    //   353: astore 13
    //   355: aconst_null
    //   356: astore 4
    //   358: ldc 195
    //   360: iconst_1
    //   361: ldc_w 5407
    //   364: aload 13
    //   366: invokestatic 189	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   369: iconst_0
    //   370: istore 6
    //   372: goto -307 -> 65
    //   375: iconst_0
    //   376: istore 6
    //   378: goto -77 -> 301
    //   381: aload_1
    //   382: ldc 250
    //   384: putfield 5402	com/tencent/mobileqq/data/ContactCard:uin	Ljava/lang/String;
    //   387: goto -60 -> 327
    //   390: lload 7
    //   392: invokestatic 675	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   395: astore 13
    //   397: aload_2
    //   398: aload 13
    //   400: invokevirtual 724	amsw:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   403: astore 14
    //   405: aload 14
    //   407: aload_3
    //   408: getfield 5408	SummaryCard/RespSummaryCard:iLevel	I
    //   411: putfield 5333	com/tencent/mobileqq/data/Card:iQQLevel	I
    //   414: aload 14
    //   416: aload_3
    //   417: getfield 1230	SummaryCard/RespSummaryCard:strNick	Ljava/lang/String;
    //   420: putfield 1849	com/tencent/mobileqq/data/Card:strNick	Ljava/lang/String;
    //   423: aload 14
    //   425: aload_3
    //   426: getfield 3551	SummaryCard/RespSummaryCard:bSex	B
    //   429: i2s
    //   430: putfield 1866	com/tencent/mobileqq/data/Card:shGender	S
    //   433: aload 14
    //   435: aload_3
    //   436: getfield 5411	SummaryCard/RespSummaryCard:uCurMulType	J
    //   439: putfield 5412	com/tencent/mobileqq/data/Card:uCurMulType	J
    //   442: aload 14
    //   444: aload_3
    //   445: getfield 3554	SummaryCard/RespSummaryCard:bAge	B
    //   448: i2s
    //   449: putfield 2826	com/tencent/mobileqq/data/Card:shAge	S
    //   452: aload 14
    //   454: aload_3
    //   455: getfield 3554	SummaryCard/RespSummaryCard:bAge	B
    //   458: putfield 1871	com/tencent/mobileqq/data/Card:age	B
    //   461: aload 14
    //   463: aload_3
    //   464: getfield 5415	SummaryCard/RespSummaryCard:iBirthday	I
    //   467: i2l
    //   468: putfield 2449	com/tencent/mobileqq/data/Card:lBirthday	J
    //   471: aload 14
    //   473: aload_3
    //   474: getfield 5416	SummaryCard/RespSummaryCard:strEmail	Ljava/lang/String;
    //   477: putfield 2502	com/tencent/mobileqq/data/Card:strEmail	Ljava/lang/String;
    //   480: aload 14
    //   482: aload_3
    //   483: getfield 5419	SummaryCard/RespSummaryCard:iFace	I
    //   486: putfield 5251	com/tencent/mobileqq/data/Card:nFaceID	I
    //   489: aload 14
    //   491: aload_3
    //   492: getfield 5422	SummaryCard/RespSummaryCard:strSign	Ljava/lang/String;
    //   495: putfield 5423	com/tencent/mobileqq/data/Card:strSign	Ljava/lang/String;
    //   498: aload 14
    //   500: aload_3
    //   501: getfield 5390	SummaryCard/RespSummaryCard:strCity	Ljava/lang/String;
    //   504: putfield 2490	com/tencent/mobileqq/data/Card:strCity	Ljava/lang/String;
    //   507: aload 14
    //   509: aload_3
    //   510: getfield 5386	SummaryCard/RespSummaryCard:strProvince	Ljava/lang/String;
    //   513: putfield 2487	com/tencent/mobileqq/data/Card:strProvince	Ljava/lang/String;
    //   516: aload 14
    //   518: aload_3
    //   519: getfield 5388	SummaryCard/RespSummaryCard:strCountry	Ljava/lang/String;
    //   522: putfield 2484	com/tencent/mobileqq/data/Card:strCountry	Ljava/lang/String;
    //   525: aload 14
    //   527: aload_3
    //   528: getfield 4719	SummaryCard/RespSummaryCard:strRemark	Ljava/lang/String;
    //   531: putfield 1854	com/tencent/mobileqq/data/Card:strReMark	Ljava/lang/String;
    //   534: aload 14
    //   536: aload_3
    //   537: getfield 5426	SummaryCard/RespSummaryCard:iPhotoCount	I
    //   540: putfield 5325	com/tencent/mobileqq/data/Card:iFaceNum	I
    //   543: aload 14
    //   545: aload_3
    //   546: getfield 1211	SummaryCard/RespSummaryCard:strGroupName	Ljava/lang/String;
    //   549: putfield 5429	com/tencent/mobileqq/data/Card:strTroopName	Ljava/lang/String;
    //   552: aload 14
    //   554: aload_3
    //   555: getfield 1217	SummaryCard/RespSummaryCard:strGroupNick	Ljava/lang/String;
    //   558: putfield 5432	com/tencent/mobileqq/data/Card:strTroopNick	Ljava/lang/String;
    //   561: aload 14
    //   563: aload_3
    //   564: getfield 5435	SummaryCard/RespSummaryCard:strMobile	Ljava/lang/String;
    //   567: putfield 5436	com/tencent/mobileqq/data/Card:strMobile	Ljava/lang/String;
    //   570: aload 14
    //   572: aload_3
    //   573: getfield 5394	SummaryCard/RespSummaryCard:strContactName	Ljava/lang/String;
    //   576: putfield 5437	com/tencent/mobileqq/data/Card:strContactName	Ljava/lang/String;
    //   579: aload 14
    //   581: aload_3
    //   582: getfield 5440	SummaryCard/RespSummaryCard:strStatus	Ljava/lang/String;
    //   585: putfield 5441	com/tencent/mobileqq/data/Card:strStatus	Ljava/lang/String;
    //   588: aload 14
    //   590: aload_3
    //   591: getfield 1248	SummaryCard/RespSummaryCard:strAutoRemark	Ljava/lang/String;
    //   594: putfield 5442	com/tencent/mobileqq/data/Card:strAutoRemark	Ljava/lang/String;
    //   597: aload 14
    //   599: aload_3
    //   600: getfield 5445	SummaryCard/RespSummaryCard:vSeed	[B
    //   603: putfield 5446	com/tencent/mobileqq/data/Card:vSeed	[B
    //   606: aload 14
    //   608: aload_3
    //   609: getfield 1285	SummaryCard/RespSummaryCard:iVoteCount	I
    //   612: i2l
    //   613: putfield 5301	com/tencent/mobileqq/data/Card:lVisitCount	J
    //   616: aload 14
    //   618: aload_3
    //   619: getfield 5449	SummaryCard/RespSummaryCard:uQQMasterLoginDays	J
    //   622: putfield 5452	com/tencent/mobileqq/data/Card:lQQMasterLogindays	J
    //   625: aload 14
    //   627: iload 5
    //   629: putfield 5454	com/tencent/mobileqq/data/Card:favoriteSource	I
    //   632: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   635: ifeq +58 -> 693
    //   638: ldc 195
    //   640: iconst_2
    //   641: new 20	java/lang/StringBuilder
    //   644: dup
    //   645: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   648: ldc_w 5456
    //   651: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   654: aload_3
    //   655: getfield 1299	SummaryCard/RespSummaryCard:strVoteLimitedNotice	Ljava/lang/String;
    //   658: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   661: ldc_w 5458
    //   664: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   667: aload_3
    //   668: getfield 1303	SummaryCard/RespSummaryCard:bHaveVotedCnt	S
    //   671: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   674: ldc_w 5460
    //   677: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   680: aload_3
    //   681: getfield 1307	SummaryCard/RespSummaryCard:bAvailVoteCnt	S
    //   684: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   687: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   690: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   693: aload_0
    //   694: aload_3
    //   695: aload 13
    //   697: invokespecial 5462	amov:b	(LSummaryCard/RespSummaryCard;Ljava/lang/String;)V
    //   700: aload_0
    //   701: aload_1
    //   702: aload 14
    //   704: invokespecial 5464	amov:a	(Lcom/tencent/qphone/base/remote/ToServiceMsg;Lcom/tencent/mobileqq/data/Card;)V
    //   707: aload_0
    //   708: aload 4
    //   710: aload_3
    //   711: aload 15
    //   713: aload 13
    //   715: aload 14
    //   717: invokespecial 5466	amov:a	(LSummaryCard/RespHead;LSummaryCard/RespSummaryCard;Landroid/util/SparseArray;Ljava/lang/String;Lcom/tencent/mobileqq/data/Card;)V
    //   720: aload 14
    //   722: aload_3
    //   723: getfield 5469	SummaryCard/RespSummaryCard:ulShowControl	J
    //   726: l2i
    //   727: putfield 5471	com/tencent/mobileqq/data/Card:ulShowControl	I
    //   730: aload_3
    //   731: getfield 5469	SummaryCard/RespSummaryCard:ulShowControl	J
    //   734: lconst_1
    //   735: land
    //   736: lconst_0
    //   737: lcmp
    //   738: ifne +569 -> 1307
    //   741: iconst_0
    //   742: istore 6
    //   744: aload 14
    //   746: iload 6
    //   748: invokevirtual 5474	com/tencent/mobileqq/data/Card:setFeedsShowFlag	(Z)V
    //   751: aload_3
    //   752: getfield 5469	SummaryCard/RespSummaryCard:ulShowControl	J
    //   755: ldc2_w 1792
    //   758: land
    //   759: lconst_0
    //   760: lcmp
    //   761: ifne +552 -> 1313
    //   764: iconst_0
    //   765: istore 6
    //   767: aload 14
    //   769: iload 6
    //   771: invokevirtual 5477	com/tencent/mobileqq/data/Card:setPhotoShowFlag	(Z)V
    //   774: aload_3
    //   775: getfield 5480	SummaryCard/RespSummaryCard:lCacheControl	J
    //   778: lconst_0
    //   779: lcmp
    //   780: ifne +539 -> 1319
    //   783: iconst_0
    //   784: istore 6
    //   786: aload 14
    //   788: iload 6
    //   790: invokevirtual 5483	com/tencent/mobileqq/data/Card:setPhotoUseCacheFlag	(Z)V
    //   793: aload_3
    //   794: getfield 5469	SummaryCard/RespSummaryCard:ulShowControl	J
    //   797: ldc2_w 1461
    //   800: land
    //   801: lconst_0
    //   802: lcmp
    //   803: ifne +522 -> 1325
    //   806: iconst_0
    //   807: istore 6
    //   809: aload 14
    //   811: iload 6
    //   813: invokevirtual 5486	com/tencent/mobileqq/data/Card:setXManFlag	(Z)V
    //   816: aload_0
    //   817: aload_3
    //   818: aload 14
    //   820: invokespecial 5488	amov:j	(LSummaryCard/RespSummaryCard;Lcom/tencent/mobileqq/data/Card;)V
    //   823: aload 14
    //   825: aload_3
    //   826: getfield 1485	SummaryCard/RespSummaryCard:stVipInfo	LQQService/VipBaseInfo;
    //   829: invokevirtual 5492	com/tencent/mobileqq/data/Card:setVipInfo	(LQQService/VipBaseInfo;)V
    //   832: aload_1
    //   833: getfield 595	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   836: ldc_w 5494
    //   839: invokevirtual 2519	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   842: lstore 11
    //   844: ldc_w 2130
    //   847: iconst_1
    //   848: new 20	java/lang/StringBuilder
    //   851: dup
    //   852: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   855: ldc_w 5496
    //   858: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   861: lload 11
    //   863: invokevirtual 829	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   866: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   869: invokestatic 115	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   872: aload_0
    //   873: aload_3
    //   874: aload 13
    //   876: aload 14
    //   878: lload 11
    //   880: invokespecial 5498	amov:b	(LSummaryCard/RespSummaryCard;Ljava/lang/String;Lcom/tencent/mobileqq/data/Card;J)V
    //   883: aload_0
    //   884: aload_3
    //   885: aload 14
    //   887: lload 11
    //   889: invokespecial 5500	amov:d	(LSummaryCard/RespSummaryCard;Lcom/tencent/mobileqq/data/Card;J)V
    //   892: aload_0
    //   893: aload_3
    //   894: aload 14
    //   896: lload 11
    //   898: invokespecial 5502	amov:c	(LSummaryCard/RespSummaryCard;Lcom/tencent/mobileqq/data/Card;J)V
    //   901: aload_0
    //   902: aload_3
    //   903: aload 13
    //   905: aload 14
    //   907: lload 11
    //   909: invokespecial 5504	amov:a	(LSummaryCard/RespSummaryCard;Ljava/lang/String;Lcom/tencent/mobileqq/data/Card;J)V
    //   912: aload_0
    //   913: aload_3
    //   914: aload 14
    //   916: lload 11
    //   918: invokespecial 5506	amov:b	(LSummaryCard/RespSummaryCard;Lcom/tencent/mobileqq/data/Card;J)V
    //   921: aload_0
    //   922: aload_3
    //   923: aload 14
    //   925: lload 11
    //   927: invokespecial 5508	amov:a	(LSummaryCard/RespSummaryCard;Lcom/tencent/mobileqq/data/Card;J)V
    //   930: aload_0
    //   931: aload_3
    //   932: aload 14
    //   934: invokespecial 5510	amov:i	(LSummaryCard/RespSummaryCard;Lcom/tencent/mobileqq/data/Card;)V
    //   937: aload_0
    //   938: aload_3
    //   939: aload 14
    //   941: invokespecial 5512	amov:h	(LSummaryCard/RespSummaryCard;Lcom/tencent/mobileqq/data/Card;)V
    //   944: aload_0
    //   945: aload_3
    //   946: aload 14
    //   948: invokespecial 5514	amov:g	(LSummaryCard/RespSummaryCard;Lcom/tencent/mobileqq/data/Card;)V
    //   951: aload_0
    //   952: aload_3
    //   953: aload 15
    //   955: aload 14
    //   957: invokespecial 5516	amov:a	(LSummaryCard/RespSummaryCard;Landroid/util/SparseArray;Lcom/tencent/mobileqq/data/Card;)V
    //   960: aload_0
    //   961: aload 14
    //   963: aload 15
    //   965: lload 7
    //   967: lload 9
    //   969: invokespecial 5518	amov:a	(Lcom/tencent/mobileqq/data/Card;Landroid/util/SparseArray;JJ)Z
    //   972: pop
    //   973: aload_0
    //   974: aload 14
    //   976: aload 15
    //   978: invokespecial 5520	amov:a	(Lcom/tencent/mobileqq/data/Card;Landroid/util/SparseArray;)V
    //   981: aload_0
    //   982: aload 14
    //   984: aload 15
    //   986: invokespecial 5522	amov:b	(Lcom/tencent/mobileqq/data/Card;Landroid/util/SparseArray;)V
    //   989: aload_0
    //   990: aload_3
    //   991: aload 14
    //   993: invokespecial 5524	amov:f	(LSummaryCard/RespSummaryCard;Lcom/tencent/mobileqq/data/Card;)V
    //   996: aload_0
    //   997: aload_2
    //   998: aload_3
    //   999: aload 13
    //   1001: aload 14
    //   1003: invokespecial 5526	amov:a	(Lamsw;LSummaryCard/RespSummaryCard;Ljava/lang/String;Lcom/tencent/mobileqq/data/Card;)V
    //   1006: aload_0
    //   1007: aload 14
    //   1009: invokespecial 5527	amov:a	(Lcom/tencent/mobileqq/data/Card;)V
    //   1012: aload_0
    //   1013: aload 13
    //   1015: aload 14
    //   1017: invokespecial 5529	amov:a	(Ljava/lang/String;Lcom/tencent/mobileqq/data/Card;)V
    //   1020: aload_0
    //   1021: aload_3
    //   1022: aload 14
    //   1024: invokespecial 5531	amov:e	(LSummaryCard/RespSummaryCard;Lcom/tencent/mobileqq/data/Card;)V
    //   1027: aload_0
    //   1028: aload_3
    //   1029: aload 14
    //   1031: invokespecial 5533	amov:d	(LSummaryCard/RespSummaryCard;Lcom/tencent/mobileqq/data/Card;)V
    //   1034: aload_2
    //   1035: aload 14
    //   1037: invokevirtual 751	amsw:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   1040: pop
    //   1041: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1044: ifeq +97 -> 1141
    //   1047: new 20	java/lang/StringBuilder
    //   1050: dup
    //   1051: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   1054: astore 4
    //   1056: aload 4
    //   1058: ldc_w 1478
    //   1061: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1064: aload 14
    //   1066: getfield 1468	com/tencent/mobileqq/data/Card:lLoginDays	J
    //   1069: invokevirtual 829	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1072: ldc_w 5535
    //   1075: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1078: aload 14
    //   1080: getfield 1474	com/tencent/mobileqq/data/Card:strLoginDaysDesc	Ljava/lang/String;
    //   1083: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1086: ldc_w 5537
    //   1089: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1092: aload 14
    //   1094: getfield 1982	com/tencent/mobileqq/data/Card:allowClick	Z
    //   1097: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1100: ldc_w 5539
    //   1103: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1106: aload 14
    //   1108: getfield 736	com/tencent/mobileqq/data/Card:allowPeopleSee	Z
    //   1111: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1114: ldc_w 5541
    //   1117: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1120: aload 14
    //   1122: getfield 5471	com/tencent/mobileqq/data/Card:ulShowControl	I
    //   1125: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1128: pop
    //   1129: ldc_w 1476
    //   1132: iconst_2
    //   1133: aload 4
    //   1135: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1138: invokestatic 875	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   1141: aload_0
    //   1142: aload_2
    //   1143: aload 13
    //   1145: invokespecial 5543	amov:a	(Lamsw;Ljava/lang/String;)Lcom/tencent/mobileqq/data/ExtensionInfo;
    //   1148: astore 4
    //   1150: aload 4
    //   1152: aload_3
    //   1153: getfield 5546	SummaryCard/RespSummaryCard:ulFaceAddonId	J
    //   1156: putfield 5549	com/tencent/mobileqq/data/ExtensionInfo:pendantId	J
    //   1159: aload 4
    //   1161: invokestatic 277	java/lang/System:currentTimeMillis	()J
    //   1164: putfield 5552	com/tencent/mobileqq/data/ExtensionInfo:timestamp	J
    //   1167: aload_0
    //   1168: aload_3
    //   1169: aload 13
    //   1171: lload 11
    //   1173: aload 4
    //   1175: invokespecial 5554	amov:a	(LSummaryCard/RespSummaryCard;Ljava/lang/String;JLcom/tencent/mobileqq/data/ExtensionInfo;)V
    //   1178: aload_2
    //   1179: aload 4
    //   1181: invokevirtual 5557	amsw:a	(Lcom/tencent/mobileqq/data/ExtensionInfo;)V
    //   1184: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1187: ifeq +44 -> 1231
    //   1190: ldc 195
    //   1192: iconst_2
    //   1193: new 20	java/lang/StringBuilder
    //   1196: dup
    //   1197: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   1200: ldc_w 5559
    //   1203: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1206: aload 13
    //   1208: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1211: ldc_w 5561
    //   1214: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1217: aload 4
    //   1219: getfield 5549	com/tencent/mobileqq/data/ExtensionInfo:pendantId	J
    //   1222: invokevirtual 829	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1225: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1228: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1231: aload_0
    //   1232: aload_3
    //   1233: aload 13
    //   1235: invokespecial 5563	amov:a	(LSummaryCard/RespSummaryCard;Ljava/lang/String;)V
    //   1238: aload_0
    //   1239: aload_2
    //   1240: aload_3
    //   1241: aload 13
    //   1243: aload 14
    //   1245: lload 11
    //   1247: invokespecial 5565	amov:a	(Lamsw;LSummaryCard/RespSummaryCard;Ljava/lang/String;Lcom/tencent/mobileqq/data/Card;J)V
    //   1250: aload_0
    //   1251: aload_1
    //   1252: getfield 595	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   1255: ldc_w 5567
    //   1258: lconst_0
    //   1259: invokevirtual 4505	android/os/Bundle:getLong	(Ljava/lang/String;J)J
    //   1262: iload 5
    //   1264: aload_3
    //   1265: aload 13
    //   1267: invokespecial 5569	amov:a	(JILSummaryCard/RespSummaryCard;Ljava/lang/String;)V
    //   1270: aload_0
    //   1271: aload_3
    //   1272: aload 14
    //   1274: invokespecial 5571	amov:c	(LSummaryCard/RespSummaryCard;Lcom/tencent/mobileqq/data/Card;)V
    //   1277: aload_0
    //   1278: aload_3
    //   1279: aload 14
    //   1281: invokespecial 5573	amov:a	(LSummaryCard/RespSummaryCard;Lcom/tencent/mobileqq/data/Card;)V
    //   1284: aload_0
    //   1285: aload_3
    //   1286: aload 14
    //   1288: invokespecial 5575	amov:b	(LSummaryCard/RespSummaryCard;Lcom/tencent/mobileqq/data/Card;)V
    //   1291: aload_2
    //   1292: aload 14
    //   1294: invokevirtual 751	amsw:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   1297: pop
    //   1298: aload_0
    //   1299: iconst_1
    //   1300: iconst_1
    //   1301: aload 14
    //   1303: invokevirtual 184	amov:notifyUI	(IZLjava/lang/Object;)V
    //   1306: return
    //   1307: iconst_1
    //   1308: istore 6
    //   1310: goto -566 -> 744
    //   1313: iconst_1
    //   1314: istore 6
    //   1316: goto -549 -> 767
    //   1319: iconst_1
    //   1320: istore 6
    //   1322: goto -536 -> 786
    //   1325: iconst_1
    //   1326: istore 6
    //   1328: goto -519 -> 809
    //   1331: aload_0
    //   1332: getfield 229	amov:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   1335: ldc_w 5577
    //   1338: ldc_w 5579
    //   1341: new 20	java/lang/StringBuilder
    //   1344: dup
    //   1345: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   1348: ldc_w 5581
    //   1351: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1354: aload_2
    //   1355: invokevirtual 107	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   1358: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1361: ldc_w 5583
    //   1364: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1367: aload_2
    //   1368: invokevirtual 5586	com/tencent/qphone/base/remote/FromServiceMsg:getBusinessFailMsg	()Ljava/lang/String;
    //   1371: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1374: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1377: aconst_null
    //   1378: fconst_0
    //   1379: invokestatic 5591	bggk:a	(Lmqq/app/AppRuntime;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;F)V
    //   1382: ldc_w 5577
    //   1385: new 20	java/lang/StringBuilder
    //   1388: dup
    //   1389: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   1392: ldc_w 5593
    //   1395: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1398: aload_2
    //   1399: invokevirtual 107	com/tencent/qphone/base/remote/FromServiceMsg:getResultCode	()I
    //   1402: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1405: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1408: invokestatic 5597	bggj:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   1411: lload 7
    //   1413: lconst_0
    //   1414: lcmp
    //   1415: ifgt +14 -> 1429
    //   1418: aload 13
    //   1420: astore_1
    //   1421: aload_0
    //   1422: iconst_1
    //   1423: iconst_0
    //   1424: aload_1
    //   1425: invokevirtual 184	amov:notifyUI	(IZLjava/lang/Object;)V
    //   1428: return
    //   1429: lload 7
    //   1431: invokestatic 675	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   1434: astore_1
    //   1435: goto -14 -> 1421
    //   1438: astore 13
    //   1440: goto -1082 -> 358
    //   1443: aconst_null
    //   1444: astore 4
    //   1446: goto -1381 -> 65
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1449	0	this	amov
    //   0	1449	1	paramToServiceMsg	ToServiceMsg
    //   0	1449	2	paramFromServiceMsg	FromServiceMsg
    //   0	1449	3	paramObject	Object
    //   0	1449	4	paramBundle	Bundle
    //   55	1208	5	i	int
    //   15	1312	6	bool	boolean
    //   115	1315	7	l1	long
    //   151	817	9	l2	long
    //   842	404	11	l3	long
    //   127	102	13	str1	String
    //   353	12	13	localException1	Exception
    //   395	1024	13	str2	String
    //   1438	1	13	localException2	Exception
    //   183	1119	14	localObject	Object
    //   197	788	15	localSparseArray	SparseArray
    // Exception table:
    //   from	to	target	type
    //   22	45	353	java/lang/Exception
    //   50	57	1438	java/lang/Exception
  }
  
  private void q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    ampe localampe;
    amsw localamsw;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      bool1 = true;
      localampe = null;
      localamsw = null;
      if (bool1) {
        paramFromServiceMsg = localampe;
      }
    }
    for (;;)
    {
      try
      {
        paramObject = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        paramFromServiceMsg = localampe;
        Object localObject1 = ByteBuffer.wrap(paramObject.bytes_bodybuffer.get().toByteArray());
        paramFromServiceMsg = localampe;
        if (!paramObject.uint32_result.has()) {
          continue;
        }
        paramFromServiceMsg = localampe;
        if (paramObject.uint32_result.get() != 0) {
          continue;
        }
        paramFromServiceMsg = localampe;
        Long localLong = Long.valueOf(bftf.a(((ByteBuffer)localObject1).getInt()));
        paramFromServiceMsg = localampe;
        ((ByteBuffer)localObject1).get();
        paramFromServiceMsg = localampe;
        int m = ((ByteBuffer)localObject1).getShort();
        paramFromServiceMsg = localampe;
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = localampe;
          QLog.i("CardHandler", 2, "handleGetDetailInfo request success. TLVCount=" + m);
        }
        j = 0;
        paramFromServiceMsg = localampe;
        localamsw = (amsw)this.app.getManager(51);
        paramFromServiceMsg = localampe;
        paramObject = localamsw.c(this.app.getCurrentAccountUin());
        paramFromServiceMsg = paramObject;
        localampe = new ampe(null);
        paramFromServiceMsg = paramObject;
        Object localObject2 = new ampc(null);
        paramFromServiceMsg = paramObject;
        ampd localampd = new ampd(null);
        paramFromServiceMsg = paramObject;
        alnr localalnr = (alnr)this.app.getManager(153);
        paramFromServiceMsg = paramObject;
        ((ampc)localObject2).jdField_a_of_type_Alnr = localalnr;
        paramFromServiceMsg = paramObject;
        ((ampc)localObject2).jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo = localalnr.b(this.app.getCurrentAccountUin());
        paramFromServiceMsg = paramObject;
        int k = ((ByteBuffer)localObject1).position();
        paramFromServiceMsg = paramObject;
        bcop localbcop = new bcop();
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
          a((ByteBuffer)localObject1, s, i, localLong, paramObject, localampe);
          paramFromServiceMsg = paramObject;
          a((ByteBuffer)localObject1, s, i, localLong, paramObject);
          paramFromServiceMsg = paramObject;
          b((ByteBuffer)localObject1, s, i, localLong, paramObject);
          paramFromServiceMsg = paramObject;
          c((ByteBuffer)localObject1, s, i, localLong, paramObject);
          paramFromServiceMsg = paramObject;
          a((ByteBuffer)localObject1, s, i, localLong, paramObject, (ampc)localObject2);
          paramFromServiceMsg = paramObject;
          a((ByteBuffer)localObject1, s, i, localLong, paramObject, localampd);
          paramFromServiceMsg = paramObject;
          d((ByteBuffer)localObject1, s, i, localLong, paramObject);
          paramFromServiceMsg = paramObject;
          a((ByteBuffer)localObject1, s, i, localLong, paramObject, localbcop);
          j += 1;
          continue;
        }
        paramFromServiceMsg = paramObject;
        localObject1 = (anwp)this.app.getManager(199);
        if (localObject1 != null)
        {
          paramFromServiceMsg = paramObject;
          if (((anwp)localObject1).a())
          {
            paramFromServiceMsg = paramObject;
            ((anwp)localObject1).a(localampd.jdField_a_of_type_Short, localampd.jdField_b_of_type_Short, localampd.jdField_c_of_type_Short);
          }
        }
        paramFromServiceMsg = paramObject;
        if (((ampc)localObject2).jdField_a_of_type_Boolean)
        {
          paramFromServiceMsg = paramObject;
          localalnr.a(((ampc)localObject2).jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo);
        }
        paramFromServiceMsg = paramObject;
        if (localbcop.jdField_a_of_type_Boolean)
        {
          paramFromServiceMsg = paramObject;
          if (localbcop.c) {
            break label1101;
          }
          paramFromServiceMsg = paramObject;
          if (!localbcop.jdField_b_of_type_Boolean) {
            continue;
          }
          break label1101;
          paramFromServiceMsg = paramObject;
          QLog.d("CardHandler", 1, new Object[] { "[KidMode]studyModeFlag:", Boolean.valueOf(localbcop.c), " kidModeFlag:", Boolean.valueOf(localbcop.jdField_b_of_type_Boolean), " simpleUi:", Boolean.valueOf(localbcop.d) });
          paramFromServiceMsg = paramObject;
          bcoo.a(bool2, this.app);
          paramFromServiceMsg = paramObject;
          ((bcof)this.app.getManager(361)).b(bool2);
          paramFromServiceMsg = paramObject;
          bcoo.a(this.app, bool2, localbcop.d);
        }
        paramFromServiceMsg = paramObject;
        if (alnr.a(this.app.getApp()))
        {
          paramFromServiceMsg = paramObject;
          if (((ampc)localObject2).jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo.isApolloStatusOpen())
          {
            paramFromServiceMsg = paramObject;
            if (((ampc)localObject2).jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo.apolloLocalTS != ((ampc)localObject2).jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo.apolloServerTS) {
              continue;
            }
          }
        }
        paramFromServiceMsg = paramObject;
        if (alnr.a(this.app) == 2)
        {
          paramFromServiceMsg = paramObject;
          if (((ampc)localObject2).jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo.getApolloDress3D() == null)
          {
            paramFromServiceMsg = paramObject;
            localObject1 = new ArrayList(1);
            paramFromServiceMsg = paramObject;
            ((ArrayList)localObject1).add(Long.valueOf(((ampc)localObject2).jdField_a_of_type_ComTencentMobileqqDataApolloBaseInfo.uin));
            paramFromServiceMsg = paramObject;
            localObject2 = (VasExtensionHandler)this.app.getBusinessHandler(71);
            if (localObject2 != null)
            {
              paramFromServiceMsg = paramObject;
              ((VasExtensionHandler)localObject2).a((ArrayList)localObject1, "card");
            }
          }
        }
        paramFromServiceMsg = paramObject;
        localampe.a(paramObject);
        paramFromServiceMsg = paramObject;
        localamsw.a(paramObject);
        paramFromServiceMsg = paramObject;
        if (!localampe.jdField_a_of_type_Boolean)
        {
          paramFromServiceMsg = paramObject;
          if (!localampe.jdField_b_of_type_Boolean) {}
        }
        else
        {
          paramFromServiceMsg = paramObject;
          if (paramToServiceMsg.extraData.getBoolean("reqFromDetailActivity"))
          {
            paramFromServiceMsg = paramObject;
            ((ampm)this.app.getManager(59)).a(paramObject);
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
      paramFromServiceMsg = localampe;
      if (paramObject.uint32_result.has())
      {
        paramFromServiceMsg = localampe;
        j = paramObject.uint32_result.get();
        paramFromServiceMsg = localampe;
        QLog.d("CardHandler", 1, String.format("handleGetDetailInfo request fail. ret=%s", new Object[] { Integer.valueOf(j) }));
        bool1 = false;
        paramFromServiceMsg = localamsw;
      }
      else
      {
        paramFromServiceMsg = localamsw;
        continue;
        bool1 = false;
        break;
        label1101:
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
          bfyz.F(this.mApp.getApplication(), getCurrentAccountUin(), i);
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
      amsw localamsw = (amsw)this.app.getManager(51);
      paramObject = localamsw.b(paramToServiceMsg.getUin());
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
        localamsw.a(paramFromServiceMsg);
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
    notifyUI(12, false, new Object[] { paramBundle, ((amsw)this.app.getManager(51)).c(paramToServiceMsg.getUin()) });
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
    //   32: ldc_w 715
    //   35: iconst_2
    //   36: new 20	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   43: ldc_w 5728
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
    //   165: ldc_w 715
    //   168: iconst_2
    //   169: new 20	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   176: ldc_w 5730
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
    //   288: invokestatic 609	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   291: astore_2
    //   292: iload 5
    //   294: istore 10
    //   296: iload 5
    //   298: istore 7
    //   300: iload 14
    //   302: istore 9
    //   304: aload_2
    //   305: invokevirtual 612	java/nio/ByteBuffer:getInt	()I
    //   308: istore 4
    //   310: iload 4
    //   312: i2l
    //   313: lstore 15
    //   315: iload 4
    //   317: ifge +12 -> 329
    //   320: iload 4
    //   322: ldc_w 1049
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
    //   342: invokevirtual 615	java/nio/ByteBuffer:get	()B
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
    //   367: invokevirtual 619	java/nio/ByteBuffer:getShort	()S
    //   370: invokestatic 630	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   373: invokevirtual 729	java/lang/Short:shortValue	()S
    //   376: iconst_1
    //   377: if_icmpne +36 -> 413
    //   380: iload 5
    //   382: istore 10
    //   384: iload 5
    //   386: istore 7
    //   388: iload 14
    //   390: istore 9
    //   392: aload_2
    //   393: invokevirtual 619	java/nio/ByteBuffer:getShort	()S
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
    //   427: ldc_w 715
    //   430: iconst_2
    //   431: new 20	java/lang/StringBuilder
    //   434: dup
    //   435: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   438: ldc_w 5730
    //   441: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: iload 6
    //   446: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   449: ldc_w 731
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
    //   484: invokevirtual 184	amov:notifyUI	(IZLjava/lang/Object;)V
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
    //   513: invokevirtual 619	java/nio/ByteBuffer:getShort	()S
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
    //   555: invokevirtual 743	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   558: pop
    //   559: iload 5
    //   561: istore 10
    //   563: iload 5
    //   565: istore 7
    //   567: iload 14
    //   569: istore 9
    //   571: aload_3
    //   572: iconst_0
    //   573: invokestatic 748	bftf:a	([BI)S
    //   576: istore 4
    //   578: iload 4
    //   580: ifne +32 -> 612
    //   583: iconst_0
    //   584: istore 6
    //   586: aload_2
    //   587: invokevirtual 619	java/nio/ByteBuffer:getShort	()S
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
    //   619: getfield 229	amov:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   622: invokevirtual 1042	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   625: aload_1
    //   626: invokevirtual 2422	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   629: aconst_null
    //   630: ldc_w 4044
    //   633: iload 6
    //   635: invokestatic 3299	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:writeValue	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
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
    //   685: ldc_w 715
    //   688: iconst_2
    //   689: ldc_w 5732
    //   692: aload_1
    //   693: invokestatic 208	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   696: iload 5
    //   698: istore 7
    //   700: iload 6
    //   702: istore 9
    //   704: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   707: ifeq -233 -> 474
    //   710: ldc_w 715
    //   713: iconst_2
    //   714: new 20	java/lang/StringBuilder
    //   717: dup
    //   718: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   721: ldc_w 5730
    //   724: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   727: iload 5
    //   729: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   732: ldc_w 731
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
    //   771: ldc_w 715
    //   774: iconst_2
    //   775: new 20	java/lang/StringBuilder
    //   778: dup
    //   779: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   782: ldc_w 5730
    //   785: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   788: iload 5
    //   790: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   793: ldc_w 731
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
    //   0	842	0	this	amov
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
      paramFromServiceMsg = this.app.getApplication().getString(2131694314);
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
      paramFromServiceMsg = this.app.getApplication().getString(2131694314);
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
      ((avnl)this.app.getManager(303)).a(s, bool2, paramFromServiceMsg, bool5);
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
      paramFromServiceMsg = this.app.getApplication().getString(2131694314);
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
    //   32: ldc_w 715
    //   35: iconst_2
    //   36: new 20	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   43: ldc_w 5753
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
    //   145: ldc_w 715
    //   148: iconst_2
    //   149: new 20	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   156: ldc_w 5755
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
    //   244: invokestatic 609	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   247: astore_2
    //   248: iload 5
    //   250: istore 7
    //   252: iload 5
    //   254: istore 6
    //   256: aload_2
    //   257: invokevirtual 612	java/nio/ByteBuffer:getInt	()I
    //   260: istore 4
    //   262: iload 4
    //   264: i2l
    //   265: lstore 13
    //   267: iload 4
    //   269: ifge +12 -> 281
    //   272: iload 4
    //   274: ldc_w 1049
    //   277: iand
    //   278: i2l
    //   279: lstore 13
    //   281: iload 5
    //   283: istore 7
    //   285: iload 5
    //   287: istore 6
    //   289: aload_2
    //   290: invokevirtual 615	java/nio/ByteBuffer:get	()B
    //   293: pop
    //   294: iload 5
    //   296: istore 7
    //   298: iload 5
    //   300: istore 6
    //   302: aload_2
    //   303: invokevirtual 619	java/nio/ByteBuffer:getShort	()S
    //   306: invokestatic 630	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   309: invokevirtual 729	java/lang/Short:shortValue	()S
    //   312: iconst_1
    //   313: if_icmpne +249 -> 562
    //   316: iload 5
    //   318: istore 7
    //   320: iload 5
    //   322: istore 6
    //   324: aload_2
    //   325: invokevirtual 619	java/nio/ByteBuffer:getShort	()S
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
    //   359: ldc_w 715
    //   362: iconst_2
    //   363: new 20	java/lang/StringBuilder
    //   366: dup
    //   367: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   370: ldc_w 5755
    //   373: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: iload 5
    //   378: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   381: ldc_w 731
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
    //   416: invokevirtual 184	amov:notifyUI	(IZLjava/lang/Object;)V
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
    //   441: invokevirtual 619	java/nio/ByteBuffer:getShort	()S
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
    //   475: invokevirtual 743	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   478: pop
    //   479: iload 5
    //   481: istore 7
    //   483: iload 5
    //   485: istore 6
    //   487: aload_3
    //   488: iconst_0
    //   489: invokestatic 748	bftf:a	([BI)S
    //   492: istore 4
    //   494: iload 4
    //   496: ifne +24 -> 520
    //   499: iconst_1
    //   500: istore 6
    //   502: aload_2
    //   503: invokevirtual 619	java/nio/ByteBuffer:getShort	()S
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
    //   527: getfield 229	amov:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   530: invokevirtual 1042	com/tencent/mobileqq/app/QQAppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   533: aload_1
    //   534: invokevirtual 2422	com/tencent/qphone/base/remote/ToServiceMsg:getUin	()Ljava/lang/String;
    //   537: aconst_null
    //   538: ldc_w 4068
    //   541: iload 6
    //   543: invokestatic 3299	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:writeValue	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V
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
    //   587: ldc_w 715
    //   590: iconst_2
    //   591: ldc_w 5757
    //   594: aload_1
    //   595: invokestatic 208	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   598: iload 6
    //   600: istore 7
    //   602: iload 5
    //   604: istore 8
    //   606: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   609: ifeq -203 -> 406
    //   612: ldc_w 715
    //   615: iconst_2
    //   616: new 20	java/lang/StringBuilder
    //   619: dup
    //   620: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   623: ldc_w 5755
    //   626: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   629: iload 6
    //   631: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   634: ldc_w 731
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
    //   673: ldc_w 715
    //   676: iconst_2
    //   677: new 20	java/lang/StringBuilder
    //   680: dup
    //   681: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   684: ldc_w 5755
    //   687: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   690: iload 6
    //   692: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   695: ldc_w 731
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
    //   0	783	0	this	amov
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
  
  public amoy a(QQAppInterface paramQQAppInterface, amoz paramamoz)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, String.format("addCoverTransCallback app=%s callBack=%s", new Object[] { paramQQAppInterface, paramamoz }));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController == null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController = paramQQAppInterface.getTransFileController();
    }
    paramQQAppInterface = new amoy(paramamoz);
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
      ((ByteBuffer)localObject).putInt(bftf.a(Long.parseLong(this.app.getCurrentAccountUin()))).put((byte)0).putShort((short)1).putShort((short)27240).putShort((short)4).putInt(paramInt);
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
  
  public void a(long paramLong, ampb paramampb)
  {
    NowLiveGallary.ReqBody localReqBody = new NowLiveGallary.ReqBody();
    localReqBody.req_uin.set(paramLong);
    nmb.a(this.app, paramampb, localReqBody.toByteArray(), "ilive.photo_wall");
  }
  
  public void a(PushVoteIncreaseInfo paramPushVoteIncreaseInfo, String paramString1, String paramString2)
  {
    Visitor localVisitor = (Visitor)paramPushVoteIncreaseInfo.vVoterList.get(0);
    MessageRecord localMessageRecord = bbli.a(-1000);
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
        localMessageRecord.msg = String.format(this.app.getApp().getApplicationContext().getString(2131692430), new Object[] { localObject2 });
        this.app.getMessageFacade().addMessage(localMessageRecord, paramString1);
        this.app.handleReceivedMessage(1, true, true);
        localObject1 = new Bundle();
        ((Bundle)localObject1).putInt("newVoteCount", paramPushVoteIncreaseInfo.iIncrement);
        ((Bundle)localObject1).putString("sender", paramString2);
        ((Bundle)localObject1).putString("voteeUin", paramString1);
        ((Bundle)localObject1).putString("uin", paramString1);
        notifyUI(28, true, new Object[] { ((amsw)this.app.getManager(51)).c(this.app.getCurrentAccountUin()), localObject1 });
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
        localMessageRecord.msg = String.format(this.app.getApp().getApplicationContext().getString(2131692429), new Object[] { localObject2, Integer.valueOf(paramPushVoteIncreaseInfo.iIncrement) });
      }
    }
  }
  
  public void a(amoy paramamoy)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.", 2, String.format("removeCoverTransCallback transHandler=%s", new Object[] { paramamoy }));
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController != null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransFileController.removeHandle(paramamoy);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    QLog.i("CardHandler", 1, "setDetailUserInfo");
    this.app.execute(new CardHandler.2(this, paramBundle));
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
        ((HotChatManager)this.app.getManager(60)).a(i);
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
      paramString3 = aqho.a();
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
        localObject3 = bblf.a(((AutoReplyText)localObject3).getRawText(), null);
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
      ((ByteBuffer)localObject).putInt(bftf.a(Long.parseLong(this.app.getCurrentAccountUin()))).put((byte)0).putShort((short)1).putShort(paramShort1).putShort((short)2).putShort(paramShort2);
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
      ((ByteBuffer)localObject).putInt(bftf.a(l)).put((byte)0).putShort((short)1).putShort(paramShort).putShort((short)2).putShort(s);
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
          ((ByteBuffer)localObject).putInt(bftf.a(l)).put((byte)0).putShort((short)1).putShort((short)paramInt).putShort((short)2).putShort(s);
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
    String str = bfrj.b();
    bfrj.a(null);
    Object localObject2;
    Object localObject1;
    if (paramBoolean)
    {
      localObject2 = this.app.getEntityManagerFactory().createEntityManager();
      localObject1 = (Setting)((EntityManager)localObject2).find(Setting.class, paramString);
      if (localObject1 != null) {
        break label408;
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
      localObject1 = (amsw)this.app.getManager(51);
      localObject2 = ((bgga)this.app.getManager(235)).a;
      Object localObject3 = this.app.getExtensionInfo(paramString, true);
      ((ExtensionInfo)localObject3).faceId = 0;
      ((ExtensionInfo)localObject3).faceIdUpdateTime = NetConnInfoCenter.getServerTime();
      ((ExtensionInfo)localObject3).setStatus(1000);
      ((amsw)localObject1).a((ExtensionInfo)localObject3);
      ((VasFaceManager)localObject2).a((ExtensionInfo)localObject3);
      localObject1 = this.app.getCustomFaceFilePath(false, this.app.getCurrentAccountUin());
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        FileUtils.deleteFile((String)localObject1);
      }
      localObject2 = bfrj.a(paramString);
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        FileUtils.deleteFile((String)localObject2);
      }
      localObject3 = bfrj.b(paramString);
      if (!TextUtils.isEmpty((CharSequence)localObject3)) {
        FileUtils.deleteFile((String)localObject3);
      }
      bfrj.a(this.app, paramString);
      this.app.removeFaceIconCache(1, paramString, 0);
      if (!TextUtils.isEmpty(str))
      {
        bfvo.a(null, str, (String)localObject1, 140, 140);
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
      label408:
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
        long l2 = bbko.a();
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
  
  public boolean a(Card paramCard, SparseArray<bbki> paramSparseArray)
  {
    Object localObject = aqho.a();
    if ((localObject != null) && (((aqhn)localObject).a()) && (!((aqhn)localObject).b()))
    {
      localObject = (bbki)paramSparseArray.get(15);
      if ((localObject != null) && (((bbki)localObject).a != null))
      {
        paramSparseArray = new SummaryCardBusiEntry.VisitorCountRsp();
        try
        {
          paramSparseArray.mergeFrom(((bbki)localObject).a);
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
    //   39: ldc_w 6582
    //   42: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: iload 5
    //   47: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   50: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: aload_0
    //   57: getfield 229	amov:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   60: invokevirtual 289	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
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
    //   145: ldc_w 715
    //   148: iconst_2
    //   149: new 20	java/lang/StringBuilder
    //   152: dup
    //   153: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   156: ldc_w 6584
    //   159: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: iload 5
    //   164: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   167: ldc_w 6586
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
    //   260: invokestatic 609	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   263: invokevirtual 612	java/nio/ByteBuffer:getInt	()I
    //   266: istore 4
    //   268: iload 4
    //   270: i2l
    //   271: lstore 12
    //   273: iload 4
    //   275: ifge +16 -> 291
    //   278: iload 4
    //   280: ldc_w 1049
    //   283: iand
    //   284: i2l
    //   285: ldc2_w 1050
    //   288: lor
    //   289: lstore 12
    //   291: iload 5
    //   293: istore 6
    //   295: iload 5
    //   297: istore 7
    //   299: aload_0
    //   300: getfield 229	amov:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   303: invokevirtual 289	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   306: lload 12
    //   308: invokestatic 675	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   311: invokevirtual 678	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   314: ifeq +126 -> 440
    //   317: iload 5
    //   319: istore 6
    //   321: iload 5
    //   323: istore 7
    //   325: aload_1
    //   326: getfield 595	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   329: ldc_w 788
    //   332: invokevirtual 792	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
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
    //   359: ldc_w 715
    //   362: iconst_2
    //   363: new 20	java/lang/StringBuilder
    //   366: dup
    //   367: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   370: ldc_w 6584
    //   373: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   376: iload 5
    //   378: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   381: ldc_w 731
    //   384: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: aload_1
    //   388: getfield 595	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   391: ldc_w 788
    //   394: invokevirtual 792	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
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
    //   424: invokevirtual 184	amov:notifyUI	(IZLjava/lang/Object;)V
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
    //   457: ldc_w 715
    //   460: iconst_2
    //   461: ldc_w 6588
    //   464: aload_2
    //   465: invokestatic 208	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   468: iload 6
    //   470: istore 7
    //   472: iload 9
    //   474: istore 8
    //   476: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   479: ifeq -65 -> 414
    //   482: ldc_w 715
    //   485: iconst_2
    //   486: new 20	java/lang/StringBuilder
    //   489: dup
    //   490: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   493: ldc_w 6584
    //   496: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   499: iload 6
    //   501: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   504: ldc_w 731
    //   507: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: aload_1
    //   511: getfield 595	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   514: ldc_w 788
    //   517: invokevirtual 792	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
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
    //   547: ldc_w 715
    //   550: iconst_2
    //   551: new 20	java/lang/StringBuilder
    //   554: dup
    //   555: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   558: ldc_w 6584
    //   561: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: iload 7
    //   566: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   569: ldc_w 731
    //   572: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   575: aload_1
    //   576: getfield 595	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   579: ldc_w 788
    //   582: invokevirtual 792	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
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
    //   0	615	0	this	amov
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
    //   5: invokeinterface 399 1 0
    //   10: ifle +73 -> 83
    //   13: aload_0
    //   14: getfield 229	amov:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   17: invokevirtual 1330	com/tencent/mobileqq/app/QQAppInterface:getEntityManagerFactory	()Lcom/tencent/mobileqq/data/QQEntityManagerFactory;
    //   20: invokevirtual 1336	com/tencent/mobileqq/data/QQEntityManagerFactory:createEntityManager	()Lcom/tencent/mobileqq/persistence/EntityManager;
    //   23: astore_1
    //   24: aload_1
    //   25: ifnull +58 -> 83
    //   28: aload_1
    //   29: invokevirtual 5869	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   32: invokevirtual 5874	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   35: aload_2
    //   36: invokeinterface 1529 1 0
    //   41: astore_2
    //   42: aload_2
    //   43: invokeinterface 1534 1 0
    //   48: ifeq +36 -> 84
    //   51: aload_1
    //   52: aload_2
    //   53: invokeinterface 1538 1 0
    //   58: checkcast 4492	com/tencent/mobileqq/data/CardProfile
    //   61: invokevirtual 1364	com/tencent/mobileqq/persistence/EntityManager:persistOrReplace	(Lcom/tencent/mobileqq/persistence/Entity;)V
    //   64: goto -22 -> 42
    //   67: astore_2
    //   68: aload_2
    //   69: invokevirtual 1109	java/lang/Exception:printStackTrace	()V
    //   72: aload_1
    //   73: invokevirtual 5869	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   76: invokevirtual 5894	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   79: aload_1
    //   80: invokevirtual 1367	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   83: return
    //   84: aload_1
    //   85: invokevirtual 5869	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   88: invokevirtual 5891	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   91: aload_1
    //   92: invokevirtual 5869	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   95: invokevirtual 5894	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   98: aload_1
    //   99: invokevirtual 1367	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   102: return
    //   103: astore_2
    //   104: aload_1
    //   105: invokevirtual 5869	com/tencent/mobileqq/persistence/EntityManager:getTransaction	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   108: invokevirtual 5894	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   111: aload_1
    //   112: invokevirtual 1367	com/tencent/mobileqq/persistence/EntityManager:close	()V
    //   115: aload_2
    //   116: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	117	0	this	amov
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
          ((ByteBuffer)localObject).putInt(bftf.a(l)).put((byte)0).putShort((short)1).putShort((short)-25042).putShort((short)2).putShort(s);
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
          ByteBuffer localByteBuffer = ((ByteBuffer)localObject2).putInt(bftf.a(l)).put((byte)0).putShort((short)2).putShort((short)-25217).putShort((short)2).putShort(s).putShort((short)-23476).putShort((short)2);
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
          ((ByteBuffer)localObject).putInt(bftf.a(l)).put((byte)0).putShort((short)1).putShort((short)-23234).putShort((short)2).putShort(s);
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
    if (((Integer)awka.a(this.app.getAccount(), "nearby_people_avatar_upload_ok", Integer.valueOf(-1))).intValue() != 1) {
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
    anwp localanwp = (anwp)this.app.getManager(199);
    if ((localanwp != null) && (localanwp.a()))
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
    //   39: ldc_w 6689
    //   42: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: iload 5
    //   47: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   50: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   53: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   56: aload_0
    //   57: getfield 229	amov:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   60: invokevirtual 289	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
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
    //   149: ldc_w 715
    //   152: iconst_2
    //   153: new 20	java/lang/StringBuilder
    //   156: dup
    //   157: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   160: ldc_w 6691
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
    //   248: invokestatic 609	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   251: invokevirtual 612	java/nio/ByteBuffer:getInt	()I
    //   254: istore 4
    //   256: iload 4
    //   258: i2l
    //   259: lstore 12
    //   261: iload 4
    //   263: ifge +16 -> 279
    //   266: iload 4
    //   268: ldc_w 1049
    //   271: iand
    //   272: i2l
    //   273: ldc2_w 1050
    //   276: lor
    //   277: lstore 12
    //   279: iload 5
    //   281: istore 6
    //   283: iload 5
    //   285: istore 7
    //   287: aload_0
    //   288: getfield 229	amov:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   291: invokevirtual 289	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   294: lload 12
    //   296: invokestatic 675	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   299: invokevirtual 678	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   302: ifeq +126 -> 428
    //   305: iload 5
    //   307: istore 6
    //   309: iload 5
    //   311: istore 7
    //   313: aload_1
    //   314: getfield 595	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   317: ldc_w 788
    //   320: invokevirtual 792	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
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
    //   347: ldc_w 715
    //   350: iconst_2
    //   351: new 20	java/lang/StringBuilder
    //   354: dup
    //   355: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   358: ldc_w 6691
    //   361: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: iload 5
    //   366: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   369: ldc_w 731
    //   372: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: aload_1
    //   376: getfield 595	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   379: ldc_w 788
    //   382: invokevirtual 792	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
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
    //   412: invokevirtual 184	amov:notifyUI	(IZLjava/lang/Object;)V
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
    //   445: ldc_w 715
    //   448: iconst_2
    //   449: ldc_w 6693
    //   452: aload_2
    //   453: invokestatic 208	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   456: iload 6
    //   458: istore 7
    //   460: iload 9
    //   462: istore 8
    //   464: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   467: ifeq -65 -> 402
    //   470: ldc_w 715
    //   473: iconst_2
    //   474: new 20	java/lang/StringBuilder
    //   477: dup
    //   478: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   481: ldc_w 6691
    //   484: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: iload 6
    //   489: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   492: ldc_w 731
    //   495: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   498: aload_1
    //   499: getfield 595	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   502: ldc_w 788
    //   505: invokevirtual 792	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
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
    //   535: ldc_w 715
    //   538: iconst_2
    //   539: new 20	java/lang/StringBuilder
    //   542: dup
    //   543: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   546: ldc_w 6691
    //   549: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   552: iload 7
    //   554: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   557: ldc_w 731
    //   560: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   563: aload_1
    //   564: getfield 595	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   567: ldc_w 788
    //   570: invokevirtual 792	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
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
    //   0	603	0	this	amov
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
          ((ByteBuffer)localObject).putInt(bftf.a(l)).put((byte)0).putShort((short)1).putShort((short)-25181).putShort((short)2).putShort(s);
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
            l = bftf.a(ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray()).getInt());
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
            anjo.a(paramToServiceMsg, paramFromServiceMsg, bool2);
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
            anjo.b(paramToServiceMsg, paramFromServiceMsg, bool2);
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
      ((ByteBuffer)localObject).putInt(bftf.a(l)).put((byte)0).putShort((short)1).putShort((short)-23332).putShort((short)2).putShort(s);
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
    //   4: ifeq +433 -> 437
    //   7: aload_3
    //   8: ifnull +429 -> 437
    //   11: iconst_1
    //   12: istore 5
    //   14: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   17: ifeq +31 -> 48
    //   20: ldc_w 715
    //   23: iconst_2
    //   24: new 20	java/lang/StringBuilder
    //   27: dup
    //   28: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   31: ldc_w 6722
    //   34: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: iload 5
    //   39: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   42: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   45: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   48: aload_1
    //   49: getfield 595	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   52: ldc_w 5913
    //   55: ldc 250
    //   57: invokevirtual 946	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   60: astore_2
    //   61: aload_1
    //   62: getfield 595	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   65: ldc_w 945
    //   68: ldc 250
    //   70: invokevirtual 946	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   73: astore 11
    //   75: iload 5
    //   77: istore 6
    //   79: iload 5
    //   81: ifeq +281 -> 362
    //   84: iload 5
    //   86: istore 7
    //   88: iload 5
    //   90: istore 8
    //   92: new 117	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   95: dup
    //   96: invokespecial 118	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   99: aload_3
    //   100: checkcast 120	[B
    //   103: checkcast 120	[B
    //   106: invokevirtual 124	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   109: checkcast 117	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   112: astore_3
    //   113: aload_3
    //   114: ifnull +329 -> 443
    //   117: iload 5
    //   119: istore 7
    //   121: iload 5
    //   123: istore 8
    //   125: aload_3
    //   126: getfield 128	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   129: invokevirtual 133	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   132: ifne +311 -> 443
    //   135: iconst_1
    //   136: istore 5
    //   138: iload 5
    //   140: istore 7
    //   142: iload 5
    //   144: istore 8
    //   146: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   149: ifeq +39 -> 188
    //   152: iload 5
    //   154: istore 7
    //   156: iload 5
    //   158: istore 8
    //   160: ldc_w 715
    //   163: iconst_2
    //   164: new 20	java/lang/StringBuilder
    //   167: dup
    //   168: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   171: ldc_w 6724
    //   174: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   177: iload 5
    //   179: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   182: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   185: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
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
    //   210: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   213: invokevirtual 147	com/tencent/mobileqq/pb/PBBytesField:has	()Z
    //   216: ifeq +146 -> 362
    //   219: iload 5
    //   221: istore 6
    //   223: iload 5
    //   225: istore 7
    //   227: iload 5
    //   229: istore 8
    //   231: aload_3
    //   232: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   235: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   238: ifnull +124 -> 362
    //   241: iload 5
    //   243: istore 7
    //   245: iload 5
    //   247: istore 8
    //   249: aload_3
    //   250: getfield 142	tencent/im/oidb/oidb_sso$OIDBSSOPkg:bytes_bodybuffer	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   253: invokevirtual 150	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   256: invokevirtual 159	com/tencent/mobileqq/pb/ByteStringMicro:toByteArray	()[B
    //   259: invokestatic 609	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   262: invokevirtual 612	java/nio/ByteBuffer:getInt	()I
    //   265: invokestatic 1010	bftf:a	(I)J
    //   268: lstore 9
    //   270: iload 5
    //   272: istore 7
    //   274: iload 5
    //   276: istore 8
    //   278: aload_0
    //   279: getfield 229	amov:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   282: invokevirtual 289	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   285: lload 9
    //   287: invokestatic 675	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   290: invokevirtual 678	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   293: ifeq +156 -> 449
    //   296: iload 5
    //   298: istore 7
    //   300: iload 5
    //   302: istore 8
    //   304: aload_1
    //   305: getfield 595	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   308: ldc_w 5911
    //   311: ldc_w 1049
    //   314: invokevirtual 6700	android/os/Bundle:getInt	(Ljava/lang/String;I)I
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
    //   337: getfield 684	amov:mApp	Lcom/tencent/common/app/AppInterface;
    //   340: invokevirtual 928	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   343: invokevirtual 931	mqq/app/MobileQQ:getApplicationContext	()Landroid/content/Context;
    //   346: aconst_null
    //   347: ldc_w 955
    //   350: ldc_w 957
    //   353: iload 4
    //   355: invokestatic 963	com/tencent/mobileqq/msf/sdk/SettingCloneUtil:writeValueForInt	(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    //   358: iload 5
    //   360: istore 6
    //   362: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   365: ifeq +50 -> 415
    //   368: ldc_w 715
    //   371: iconst_2
    //   372: new 20	java/lang/StringBuilder
    //   375: dup
    //   376: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   379: ldc_w 6724
    //   382: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   385: iload 6
    //   387: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   390: ldc_w 731
    //   393: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   396: aload_1
    //   397: getfield 595	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   400: ldc_w 788
    //   403: invokevirtual 792	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   406: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   409: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   412: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   415: aload_0
    //   416: bipush 96
    //   418: iload 6
    //   420: iconst_2
    //   421: anewarray 256	java/lang/String
    //   424: dup
    //   425: iconst_0
    //   426: aload_2
    //   427: aastore
    //   428: dup
    //   429: iconst_1
    //   430: aload 11
    //   432: aastore
    //   433: invokevirtual 184	amov:notifyUI	(IZLjava/lang/Object;)V
    //   436: return
    //   437: iconst_0
    //   438: istore 5
    //   440: goto -426 -> 14
    //   443: iconst_0
    //   444: istore 5
    //   446: goto -308 -> 138
    //   449: iload 5
    //   451: istore 7
    //   453: iload 5
    //   455: istore 8
    //   457: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   460: ifeq +55 -> 515
    //   463: iload 5
    //   465: istore 7
    //   467: iload 5
    //   469: istore 8
    //   471: ldc_w 715
    //   474: iconst_2
    //   475: new 20	java/lang/StringBuilder
    //   478: dup
    //   479: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   482: ldc_w 6726
    //   485: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   488: aload_0
    //   489: getfield 229	amov:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   492: invokevirtual 289	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   495: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   498: ldc_w 1014
    //   501: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   504: lload 9
    //   506: invokevirtual 829	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   509: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   512: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   515: iconst_0
    //   516: istore 6
    //   518: goto -156 -> 362
    //   521: astore_3
    //   522: iload 7
    //   524: istore 8
    //   526: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   529: ifeq +18 -> 547
    //   532: iload 7
    //   534: istore 8
    //   536: ldc_w 715
    //   539: iconst_2
    //   540: ldc_w 6728
    //   543: aload_3
    //   544: invokestatic 208	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   547: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   550: ifeq +49 -> 599
    //   553: ldc_w 715
    //   556: iconst_2
    //   557: new 20	java/lang/StringBuilder
    //   560: dup
    //   561: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   564: ldc_w 6724
    //   567: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: iconst_0
    //   571: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   574: ldc_w 731
    //   577: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   580: aload_1
    //   581: getfield 595	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   584: ldc_w 788
    //   587: invokevirtual 792	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   590: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   593: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   596: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   599: aload_0
    //   600: bipush 96
    //   602: iconst_0
    //   603: iconst_2
    //   604: anewarray 256	java/lang/String
    //   607: dup
    //   608: iconst_0
    //   609: aload_2
    //   610: aastore
    //   611: dup
    //   612: iconst_1
    //   613: aload 11
    //   615: aastore
    //   616: invokevirtual 184	amov:notifyUI	(IZLjava/lang/Object;)V
    //   619: return
    //   620: astore_3
    //   621: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   624: ifeq +50 -> 674
    //   627: ldc_w 715
    //   630: iconst_2
    //   631: new 20	java/lang/StringBuilder
    //   634: dup
    //   635: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   638: ldc_w 6724
    //   641: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   644: iload 8
    //   646: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   649: ldc_w 731
    //   652: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   655: aload_1
    //   656: getfield 595	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   659: ldc_w 788
    //   662: invokevirtual 792	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   665: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   668: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   671: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   674: aload_0
    //   675: bipush 96
    //   677: iload 8
    //   679: iconst_2
    //   680: anewarray 256	java/lang/String
    //   683: dup
    //   684: iconst_0
    //   685: aload_2
    //   686: aastore
    //   687: dup
    //   688: iconst_1
    //   689: aload 11
    //   691: aastore
    //   692: invokevirtual 184	amov:notifyUI	(IZLjava/lang/Object;)V
    //   695: aload_3
    //   696: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	697	0	this	amov
    //   0	697	1	paramToServiceMsg	ToServiceMsg
    //   0	697	2	paramFromServiceMsg	FromServiceMsg
    //   0	697	3	paramObject	Object
    //   317	37	4	i	int
    //   12	456	5	bool1	boolean
    //   77	440	6	bool2	boolean
    //   86	447	7	bool3	boolean
    //   90	588	8	bool4	boolean
    //   268	237	9	l	long
    //   73	617	11	str	String
    // Exception table:
    //   from	to	target	type
    //   92	113	521	java/lang/Exception
    //   125	135	521	java/lang/Exception
    //   146	152	521	java/lang/Exception
    //   160	188	521	java/lang/Exception
    //   209	219	521	java/lang/Exception
    //   231	241	521	java/lang/Exception
    //   249	270	521	java/lang/Exception
    //   278	296	521	java/lang/Exception
    //   304	319	521	java/lang/Exception
    //   336	358	521	java/lang/Exception
    //   457	463	521	java/lang/Exception
    //   471	515	521	java/lang/Exception
    //   92	113	620	finally
    //   125	135	620	finally
    //   146	152	620	finally
    //   160	188	620	finally
    //   209	219	620	finally
    //   231	241	620	finally
    //   249	270	620	finally
    //   278	296	620	finally
    //   304	319	620	finally
    //   336	358	620	finally
    //   457	463	620	finally
    //   471	515	620	finally
    //   526	532	620	finally
    //   536	547	620	finally
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
          ((ByteBuffer)localObject).putInt(bftf.a(l)).put((byte)0).putShort((short)1).putShort((short)-25186).putShort((short)2).putShort(s);
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
        break label550;
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
          break label550;
        }
        bool2 = bool1;
        bool3 = bool1;
        bool4 = bool1;
        if (!paramFromServiceMsg.bytes_bodybuffer.has()) {
          break label550;
        }
        bool2 = bool1;
        bool3 = bool1;
        bool4 = bool1;
        if (paramFromServiceMsg.bytes_bodybuffer.get() == null) {
          break label550;
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
      label550:
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
          ((ByteBuffer)localObject).putInt(bftf.a(l)).put((byte)0).putShort((short)1).putShort((short)-23211).putShort((short)2).putShort(s);
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
    //   30: anewarray 248	java/lang/Object
    //   33: dup
    //   34: iconst_0
    //   35: ldc_w 6761
    //   38: aastore
    //   39: dup
    //   40: iconst_1
    //   41: iload 7
    //   43: invokestatic 180	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   46: aastore
    //   47: invokestatic 901	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
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
    //   158: anewarray 248	java/lang/Object
    //   161: dup
    //   162: iconst_0
    //   163: ldc_w 6763
    //   166: aastore
    //   167: dup
    //   168: iconst_1
    //   169: iload 7
    //   171: invokestatic 180	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   174: aastore
    //   175: invokestatic 901	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
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
    //   249: invokestatic 609	java/nio/ByteBuffer:wrap	([B)Ljava/nio/ByteBuffer;
    //   252: astore_1
    //   253: iload 7
    //   255: istore 9
    //   257: iload 7
    //   259: istore 8
    //   261: iload 4
    //   263: istore 5
    //   265: aload_1
    //   266: invokevirtual 612	java/nio/ByteBuffer:getInt	()I
    //   269: pop
    //   270: iload 7
    //   272: istore 9
    //   274: iload 7
    //   276: istore 8
    //   278: iload 4
    //   280: istore 5
    //   282: aload_1
    //   283: invokevirtual 615	java/nio/ByteBuffer:get	()B
    //   286: pop
    //   287: iload 7
    //   289: istore 9
    //   291: iload 7
    //   293: istore 8
    //   295: iload 4
    //   297: istore 5
    //   299: aload_1
    //   300: invokevirtual 619	java/nio/ByteBuffer:getShort	()S
    //   303: invokestatic 630	java/lang/Short:valueOf	(S)Ljava/lang/Short;
    //   306: invokevirtual 729	java/lang/Short:shortValue	()S
    //   309: iconst_1
    //   310: if_icmpne +240 -> 550
    //   313: iload 7
    //   315: istore 9
    //   317: iload 7
    //   319: istore 8
    //   321: iload 4
    //   323: istore 5
    //   325: aload_1
    //   326: invokevirtual 619	java/nio/ByteBuffer:getShort	()S
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
    //   366: ldc_w 6763
    //   369: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: iload 7
    //   374: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   377: ldc_w 6765
    //   380: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: iload 4
    //   385: invokevirtual 110	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   388: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   391: invokestatic 199	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   394: iload 4
    //   396: istore 5
    //   398: aload_0
    //   399: getfield 229	amov:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   402: sipush 218
    //   405: invokevirtual 235	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   408: checkcast 6767	aeyb
    //   411: iload 5
    //   413: invokevirtual 6768	aeyb:a	(I)V
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
    //   442: invokevirtual 619	java/nio/ByteBuffer:getShort	()S
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
    //   484: invokevirtual 743	java/nio/ByteBuffer:get	([B)Ljava/nio/ByteBuffer;
    //   487: pop
    //   488: iload 7
    //   490: istore 9
    //   492: iload 7
    //   494: istore 8
    //   496: iload 4
    //   498: istore 5
    //   500: aload_2
    //   501: iconst_0
    //   502: invokestatic 748	bftf:a	([BI)S
    //   505: istore 6
    //   507: iload 6
    //   509: istore 5
    //   511: aload_1
    //   512: invokevirtual 619	java/nio/ByteBuffer:getShort	()S
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
    //   575: ldc_w 6770
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
    //   623: anewarray 248	java/lang/Object
    //   626: dup
    //   627: iconst_0
    //   628: ldc_w 6772
    //   631: aastore
    //   632: dup
    //   633: iconst_1
    //   634: aload_1
    //   635: invokevirtual 1114	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   638: aastore
    //   639: invokestatic 901	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   642: iload 4
    //   644: istore 5
    //   646: invokestatic 193	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   649: ifeq -251 -> 398
    //   652: ldc 195
    //   654: iconst_2
    //   655: new 20	java/lang/StringBuilder
    //   658: dup
    //   659: invokespecial 23	java/lang/StringBuilder:<init>	()V
    //   662: ldc_w 6763
    //   665: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   668: iload 7
    //   670: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   673: ldc_w 6765
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
    //   718: ldc_w 6763
    //   721: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   724: iload 7
    //   726: invokevirtual 138	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   729: ldc_w 6765
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
    //   0	760	0	this	amov
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
          ((ByteBuffer)localObject).putInt(bftf.a(l)).put((byte)0).putShort((short)1).putShort((short)-23444).putShort((short)2).putShort(s);
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
          ((ByteBuffer)localObject).putInt(bftf.a(l)).put((byte)0).putShort((short)1).putShort(this.jdField_b_of_type_Short).putShort((short)2).putShort(s);
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
          ((ByteBuffer)localObject).putInt(bftf.a(l)).put((byte)0).putShort((short)1).putShort(this.jdField_c_of_type_Short).putShort((short)2).putShort(s);
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
          ((ByteBuffer)localObject).putInt(bftf.a(l)).put((byte)0).putShort((short)1).putShort(this.jdField_d_of_type_Short).putShort((short)2).putShort(s);
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
          ((ByteBuffer)localObject).putInt(bftf.a(l)).put((byte)0).putShort((short)1).putShort((short)-25031).putShort((short)2).putShort(s);
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
          ((ByteBuffer)localObject).putInt(bftf.a(l)).put((byte)0).putShort((short)1).putShort(this.e).putShort((short)2).putShort(s);
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
          ((ByteBuffer)localObject).putInt(bftf.a(l)).put((byte)0).putShort((short)1).putShort((short)-23282).putShort((short)2).putShort(s);
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
          ((ByteBuffer)localObject).putInt(bftf.a(l)).put((byte)0).putShort((short)1).putShort((short)-23221).putShort((short)2).putShort(s);
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
 * Qualified Name:     amov
 * JD-Core Version:    0.7.0.1
 */
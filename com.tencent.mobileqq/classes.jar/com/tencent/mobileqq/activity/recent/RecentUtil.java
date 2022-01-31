package com.tencent.mobileqq.activity.recent;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import com.dataline.activities.LiteActivity;
import com.tencent.biz.TroopRedpoint.TroopRedTouchHandler;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity;
import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementRecentUserManager;
import com.tencent.biz.pubaccount.Advertisement.util.PublicAccountAdUtil;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcShopData;
import com.tencent.biz.pubaccount.ecshopassit.EcshopWebActivity;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyActivityHelper;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.common.WeishiReportUtil;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.struct.KandianOx210MsgInfo;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderActivity;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.subscript.SubscriptRecommendController;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarData;
import com.tencent.biz.pubaccount.util.PublicAccountUtil;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBroadcastActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.XMLMessageUtils;
import com.tencent.mobileqq.activity.bless.BlessActivity;
import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendActivity;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import com.tencent.mobileqq.activity.recent.data.RecentItemNoticeData;
import com.tencent.mobileqq.apollo.activity.HotChatCenterFragment;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HotChatCenterManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RecommendTroopManagerImp;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendServlet;
import com.tencent.mobileqq.app.message.BaseMessageProcessor;
import com.tencent.mobileqq.app.message.ConversationFacade;
import com.tencent.mobileqq.app.message.MsgProxyUtils;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.message.QQMessageFacade.Message;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.confess.ConfessMsgListFragment;
import com.tencent.mobileqq.confess.ConfessMsgUtil;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.data.HotChatItemData;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.MsgBoxInterFollowManager;
import com.tencent.mobileqq.data.PAMessage;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopAssistantData;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import com.tencent.mobileqq.dating.MsgBoxProtocol;
import com.tencent.mobileqq.imaxad.ImaxAdRecentUserManager;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.nearby.HotChatUtil;
import com.tencent.mobileqq.nearby.profilecard.NearbyPeopleProfileActivity;
import com.tencent.mobileqq.nearpeople.NearbyRecommender.NearbyRecommenderUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.statistics.QZoneReport;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.subaccount.SubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.SubAccountControll;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.troop.utils.ChangeMachineManager;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.dingdong.DingdongPluginHelper;
import cooperation.dingdong.DingdongPluginManager;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;
import msf.msgsvc.msg_svc.PbC2CReadedReportReq;
import msf.msgsvc.msg_svc.PbC2CReadedReportReq.UinPairReadInfo;
import msf.msgsvc.msg_svc.PbDiscussReadedReportReq;
import msf.msgsvc.msg_svc.PbGroupReadedReportReq;
import msf.msgsvc.msg_svc.PbMsgReadedReportReq;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;
import xhy;
import xhz;
import xia;
import xib;
import xic;
import xid;
import xie;

public final class RecentUtil
{
  public static long a;
  public static MessageRecord a;
  public static boolean a;
  public static boolean b;
  public static boolean c = true;
  
  public static int a(Activity paramActivity, QQAppInterface paramQQAppInterface, RecentUser paramRecentUser, String paramString, boolean paramBoolean, int paramInt, RecentBaseData paramRecentBaseData)
  {
    int i = 0;
    int j = 0;
    int k = 0;
    int m = 0;
    if ((paramRecentUser == null) || (paramActivity == null) || (paramQQAppInterface == null))
    {
      i = m;
      if (QLog.isDevelopLevel())
      {
        QLog.i("Q.recent", 4, "onRecentUserClick|[" + paramRecentUser + "," + paramActivity + "," + paramQQAppInterface + "]");
        i = m;
      }
    }
    boolean bool1;
    for (;;)
    {
      return i;
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.recent", 4, "onRecentUserClick|[" + paramRecentUser.uin + "," + paramRecentUser.type + "]");
      }
      boolean bool3 = false;
      boolean bool2;
      if (paramInt == 0)
      {
        bool1 = true;
        if (((paramRecentUser.uin == null) || (paramRecentUser.uin.length() != 4)) && (!AppConstants.H.equals(paramRecentUser.uin)) && (!TextUtils.equals(paramRecentUser.uin, AppConstants.ar)))
        {
          bool2 = bool3;
          if (!TextUtils.equals(paramRecentUser.uin, AppConstants.aH)) {
            break label224;
          }
        }
      }
      try
      {
        bool2 = a(paramQQAppInterface, paramActivity, paramRecentUser, paramInt, paramRecentBaseData);
        label224:
        paramInt = i;
        if (!bool2)
        {
          if (paramRecentUser.type == 8999) {
            paramInt = i;
          }
        }
        else
        {
          if (paramRecentUser.msgType != 14) {
            break label1593;
          }
          paramActivity = (TroopInfoManager)paramQQAppInterface.getManager(36);
          long l = 0L;
          if (paramRecentUser.uin != null) {
            l = paramActivity.b(paramRecentUser.uin);
          }
          paramActivity = null;
          if (l != 0L) {
            paramActivity = paramQQAppInterface.a().d(paramRecentUser.uin, paramRecentUser.type, l);
          }
          if (!MessageForQQWalletMsg.isRedPacketMsg(paramActivity)) {
            break label1564;
          }
          ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Clk_hongbaoSign", 0, 0, paramRecentUser.uin, "", "", "");
          label346:
          ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Clk_sfsign", 0, 0, paramRecentUser.uin, "", "", "");
          paramActivity = ".troop.special_msg.special_attention";
          label375:
          i = paramInt;
          if (TextUtils.isEmpty(paramActivity)) {
            continue;
          }
          i = paramInt;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d(RecentUtil.class.getSimpleName() + paramActivity, 2, "onRecentUserClick, r.uin:" + paramRecentUser.uin);
          return paramInt;
          bool1 = false;
        }
      }
      catch (JSONException paramRecentBaseData)
      {
        for (;;)
        {
          paramRecentBaseData.printStackTrace();
          bool2 = bool3;
        }
        if (paramRecentUser.type == 7000)
        {
          if (QLog.isColorLevel()) {
            QLog.d("SUB_ACCOUNT", 2, "RecentUtil.onRecentUserClick. r.uin=" + paramRecentUser.uin + " r.type=" + paramRecentUser.type);
          }
          SubAccountAssistantForward.a(paramQQAppInterface, paramActivity, paramRecentUser.uin);
          paramQQAppInterface.a().c(paramRecentUser.uin, paramRecentUser.type);
          if (AppConstants.w.equals(paramRecentUser.uin)) {}
          for (paramActivity = null;; paramActivity = paramRecentUser.uin)
          {
            ReportController.b(paramQQAppInterface, "CliOper", "", paramActivity, "Bind_account", "Clk_bind_account", 0, 0, "", "", "", "");
            ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800713E", "0X800713E", 0, 0, "", "", "", "");
            paramInt = i;
            break;
          }
        }
        if (paramRecentUser.type == 1000) {
          break label654;
        }
      }
    }
    if ((paramRecentUser.type == 1020) || (paramRecentUser.type == 1004)) {
      label654:
      if (a(paramQQAppInterface, paramRecentUser.uin))
      {
        paramRecentUser.type = 0;
        if (!paramBoolean) {
          break label1726;
        }
      }
    }
    label1564:
    label1593:
    label1726:
    for (paramInt = 2;; paramInt = 0)
    {
      i = paramInt | a(paramActivity, paramQQAppInterface, String.valueOf(paramRecentUser.uin), paramRecentUser.type, paramString, bool1);
      paramInt = i;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("Q.recent", 2, "from_enterchat");
      paramInt = i;
      break;
      if ((paramRecentUser.troopUin == null) || (paramRecentUser.troopUin.trim().length() == 0))
      {
        paramRecentBaseData = paramQQAppInterface.a().a().b(paramRecentUser.uin, 1);
        if (paramRecentBaseData != null) {
          paramRecentUser.troopUin = paramRecentBaseData.troopUin;
        }
      }
      a(paramActivity, paramRecentUser.uin, paramRecentUser.troopUin, paramRecentUser.type, paramString, bool1);
      paramInt = i;
      break;
      if ((paramRecentUser.type == 1005) || (paramRecentUser.type == 1023))
      {
        paramInt = j;
        if (a(paramQQAppInterface, paramRecentUser.uin))
        {
          paramRecentUser.type = 0;
          paramInt = j;
          if (paramBoolean) {
            paramInt = 2;
          }
        }
        paramInt |= a(paramActivity, paramQQAppInterface, paramRecentUser.uin, paramRecentUser.type, paramString, bool1);
        break;
      }
      if (paramRecentUser.type == 1024)
      {
        paramInt = 0x0 | a(paramActivity, paramQQAppInterface, paramRecentUser.uin, paramRecentUser.type, paramString, bool1);
        break;
      }
      if (paramRecentUser.type == 6002)
      {
        paramString = (SmartDeviceProxyMgr)paramQQAppInterface.a(51);
        paramString.a(paramActivity, paramString.a(Long.parseLong(paramRecentUser.uin)), false);
        paramInt = i;
        break;
      }
      if (paramRecentUser.type == 10005)
      {
        b(paramQQAppInterface, paramRecentUser.uin, 10005);
        paramQQAppInterface.a().a(paramRecentUser.uin, 10005, true, true);
        ImaxAdRecentUserManager.a().a(paramActivity, paramQQAppInterface, paramRecentUser.uin, paramRecentUser.type);
        paramInt = i;
        break;
      }
      if (paramRecentUser.lFlag == 16L)
      {
        b(paramQQAppInterface, paramRecentUser.uin, 1008);
        paramQQAppInterface.a().a(paramRecentUser.uin, 1008, true, true);
        a(paramActivity, paramQQAppInterface, paramRecentUser.uin, paramRecentUser.type);
        paramInt = i;
        break;
      }
      if (paramRecentUser.type == 6004)
      {
        paramString = ((TroopRedTouchManager)paramQQAppInterface.getManager(69)).a(46, false);
        if ((paramString != null) && (paramString.uint32_number.has()))
        {
          paramInt = paramString.uint32_number.get();
          label1125:
          paramString = null;
          if (paramInt > 0)
          {
            a(paramQQAppInterface, paramRecentUser, true, true);
            paramInt = paramQQAppInterface.a().b();
            paramString = "消息";
            if (paramInt > 0) {
              break label1278;
            }
          }
        }
        for (;;)
        {
          paramRecentBaseData = new Intent(paramActivity, QQBrowserActivity.class);
          if (!TextUtils.isEmpty(paramString)) {
            paramRecentBaseData.putExtra("selfSet_leftViewText", paramString);
          }
          paramRecentBaseData.putExtra("url", "https://docs.qq.com/components/Notifications.html?_wv=3");
          paramRecentBaseData.putExtra("hide_more_button", true);
          paramRecentBaseData.putExtra("webStyle", "noBottomBar");
          paramRecentBaseData.putExtra("isScreenOrientationPortrait", true);
          paramRecentBaseData.putExtra("title", paramQQAppInterface.getApp().getString(2131439167));
          paramRecentBaseData.addFlags(603979776);
          paramActivity.startActivity(paramRecentBaseData);
          paramInt = i;
          break;
          paramInt = 0;
          break label1125;
          label1278:
          if (paramInt > 99) {
            paramString = "消息" + "(99+)";
          } else {
            paramString = "消息" + "(" + paramInt + ")";
          }
        }
      }
      if ((paramRecentUser.type == 1) && ((paramRecentUser.lFlag & 1L) != 0L))
      {
        paramRecentBaseData = paramQQAppInterface.a(true);
        if (paramRecentBaseData != null)
        {
          HotChatInfo localHotChatInfo = paramRecentBaseData.a(paramRecentUser.uin);
          if ((localHotChatInfo != null) && (localHotChatInfo.apolloGameId > 0)) {
            VipUtils.a(null, "cmshow", "Apollo", "clk_reliao_msgtab", 0, 0, new String[] { String.valueOf(localHotChatInfo.apolloGameId) });
          }
        }
        if ((paramRecentBaseData != null) && (!paramRecentBaseData.b(paramRecentUser.uin))) {
          return 4;
        }
      }
      if (a(paramQQAppInterface, paramRecentUser.uin))
      {
        paramInt = k;
        if (1 != paramRecentUser.type)
        {
          paramInt = k;
          if (3000 != paramRecentUser.type)
          {
            paramInt = k;
            if (paramRecentUser.type != 0)
            {
              paramRecentUser.type = 0;
              paramInt = k;
              if (paramBoolean) {
                paramInt = 2;
              }
            }
          }
        }
        paramInt |= a(paramActivity, paramQQAppInterface, paramRecentUser.uin, paramRecentUser.type, paramString, bool1);
        break;
      }
      paramInt = 0x0 | a(paramActivity, paramQQAppInterface, paramRecentUser.uin, paramRecentUser.type, paramString, bool1);
      break;
      ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Clk_sfsign", 0, 0, paramRecentUser.uin, "", "", "");
      break label346;
      if (paramRecentUser.msgType == 20)
      {
        ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Clk_atsign", 0, 0, paramRecentUser.uin, "", "", "");
        paramActivity = ".troop.special_msg.at_msg";
        break label375;
      }
      if (paramRecentUser.msgType == 19)
      {
        i = paramQQAppInterface.b(paramRecentUser.uin);
        if (paramRecentUser.type != 3000) {
          break label1719;
        }
      }
      for (paramActivity = "Grp_Dis_replyMsg";; paramActivity = "Grp_replyMsg")
      {
        ReportController.b(paramQQAppInterface, "P_CliOper", paramActivity, "", "Msglist", "Clk_replySign", 0, 0, paramRecentUser.uin, "" + i, "", "");
        paramActivity = "";
        break;
      }
    }
  }
  
  public static int a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    return a(paramContext, paramQQAppInterface, paramString1, paramInt, paramString2, paramBoolean, null);
  }
  
  public static int a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2, boolean paramBoolean, Bundle paramBundle)
  {
    StartupTracker.a(null, "Recent_clk_enterchat");
    Intent localIntent;
    long l1;
    if (jdField_a_of_type_Boolean)
    {
      localIntent = new Intent(paramContext, ChatActivity.class);
      if (jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) {
        if ((jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop == 1) || (jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop == 3000))
        {
          l1 = jdField_a_of_type_ComTencentMobileqqDataMessageRecord.shmsgseq;
          localIntent.putExtra("searched_timeorseq", l1);
        }
      }
    }
    label73:
    label987:
    label1009:
    for (;;)
    {
      if (paramBundle != null) {
        localIntent.putExtras(paramBundle);
      }
      int i;
      if (paramInt == 3000) {
        i = 0;
      }
      boolean bool;
      for (;;)
      {
        localIntent.putExtra("uin", paramString1);
        localIntent.putExtra("uintype", paramInt);
        localIntent.putExtra("uinname", paramString2);
        localIntent.putExtra("entrance", 1);
        a(localIntent);
        if (!paramBoolean) {
          break label987;
        }
        if ((paramContext instanceof SplashActivity)) {
          a(paramContext, localIntent);
        }
        StartupTracker.a("Recent_clk_enterchat", null);
        return i;
        l1 = jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time;
        break;
        if (jdField_a_of_type_Long == 0L) {
          break label1009;
        }
        localIntent.putExtra("searched_timeorseq", jdField_a_of_type_Long);
        break label73;
        localIntent = AIOUtils.a(new Intent(paramContext, SplashActivity.class), new int[] { 1 });
        break label73;
        if ((paramInt == 0) || (paramInt == 1024))
        {
          if (paramInt != 1024)
          {
            bool = paramBoolean;
            if (!CrmUtils.c(paramQQAppInterface, paramString1)) {
              break label967;
            }
          }
          StartupTracker.a(null, "Recent_clk_enterchat_cmr");
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "Biz_card", "Biz_card_talk", 0, 0, paramString1, "0", "", "");
          StartupTracker.a("Recent_clk_enterchat_cmr", null);
          i = 0;
        }
        else
        {
          if (paramInt == 1)
          {
            StartupTracker.a(null, "Recent_clk_enterchat_troop");
            paramBundle = ((HotChatManager)paramQQAppInterface.getManager(59)).a(paramString1);
            if (paramBundle != null) {
              localIntent.putExtra("troop_uin", paramBundle.troopCode);
            }
            for (;;)
            {
              i = 1;
              StartupTracker.a("Recent_clk_enterchat_troop", null);
              break;
              paramBundle = (TroopManager)paramQQAppInterface.getManager(51);
              if (paramBundle != null)
              {
                paramBundle = paramBundle.a(paramString1 + "");
                if ((paramBundle != null) && (paramBundle.troopcode != null)) {
                  localIntent.putExtra("troop_uin", paramBundle.troopcode);
                }
              }
              ReportController.b(paramQQAppInterface, "CliOper", "", "", "Update_tips", "Upd_tips_appear", 0, -1, "", "", "", "");
            }
          }
          if (paramInt != 1008) {
            break label831;
          }
          StartupTracker.a(null, "Recent_clk_enterchat_cmr");
          paramBundle = ((PublicAccountDataManager)paramQQAppInterface.getManager(55)).c(String.valueOf(paramString1));
          if ((paramBundle == null) || (paramBundle.extendType != 2)) {
            break label571;
          }
          ReportController.b(paramQQAppInterface, "CliOper", "", "", "Biz_card", "Biz_card_talk", 0, 0, paramString1, "0", "", "");
          localIntent.putExtra("chat_subType", 1);
          localIntent.setClass(paramContext, ChatActivity.class);
          paramBoolean = false;
          StartupTracker.a("Recent_clk_enterchat_pub", null);
          i = 0;
        }
      }
      QQMessageFacade.Message localMessage = paramQQAppInterface.a().a(paramString1, 1008);
      paramBundle = "";
      Object localObject = paramBundle;
      if (localMessage != null)
      {
        localObject = XMLMessageUtils.a(localMessage);
        if (localObject != null) {
          paramBundle = Long.toString(((PAMessage)localObject).mMsgId);
        }
        localObject = paramBundle;
        if (!TextUtils.isEmpty(paramBundle)) {}
      }
      for (paramBundle = localMessage.getExtInfoFromExtStr("pa_msgId");; paramBundle = (Bundle)localObject)
      {
        if (localMessage != null) {}
        for (i = paramQQAppInterface.a().a(paramString1, localMessage.istroop);; i = 0)
        {
          PublicAccountReportUtils.a(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_sys_3", "msg_aio", 0, 0, paramString1, paramBundle, String.valueOf(i), "", false);
          int j;
          if ("2909288299".equals(paramString1))
          {
            if (i > 0)
            {
              j = 2;
              ReportController.b(paramQQAppInterface, "dc00899", "Pb_account_lifeservice", "", "0X8007055", "0X8007055", 0, 0, "", "", "", ServiceAccountFolderManager.a(j));
            }
          }
          else
          {
            localIntent.putExtra("shouldreport", true);
            if ((paramContext instanceof SplashActivity))
            {
              localIntent.putExtra("start_time", System.currentTimeMillis());
              localIntent.putExtra("red_hot_count", i);
            }
            if (i <= 0) {
              break label825;
            }
          }
          for (paramBoolean = true;; paramBoolean = false)
          {
            localIntent.putExtra("has_unread_msg", paramBoolean);
            localIntent.putExtra("jump_from", 1);
            PublicTracker.a(null, "SUBSCRIPT_AIO_COST");
            break;
            j = 1;
            break label709;
          }
          bool = paramBoolean;
          if (paramInt == 9501)
          {
            SmartDeviceReport.a(paramQQAppInterface, "Usr_AIO_Open", 2, 0, 0);
            paramQQAppInterface = (SmartDeviceProxyMgr)paramQQAppInterface.a(51);
            l1 = 0L;
          }
          try
          {
            long l2 = Long.parseLong(paramString1);
            l1 = l2;
          }
          catch (Exception paramBundle)
          {
            for (;;)
            {
              paramBundle.printStackTrace();
            }
          }
          localIntent.setClass(paramContext, ChatActivity.class);
          paramBoolean = false;
          bool = paramBoolean;
          if (paramQQAppInterface != null)
          {
            bool = paramBoolean;
            if (paramQQAppInterface.a(l1, 9))
            {
              paramQQAppInterface = new Bundle();
              paramQQAppInterface.putString("din", String.valueOf(l1));
              paramQQAppInterface.putString("devName", paramString2);
              paramQQAppInterface.putBoolean("bFromLightApp", false);
              paramQQAppInterface.putInt("operType", 5);
              localIntent.putExtras(paramQQAppInterface);
              bool = paramBoolean;
            }
          }
          i = 0;
          paramBoolean = bool;
          break;
          paramContext.startActivity(localIntent);
          break label160;
        }
      }
    }
  }
  
  public static void a(Context paramContext, Intent paramIntent)
  {
    if ((paramContext instanceof SplashActivity))
    {
      paramContext = (SplashActivity)paramContext;
      paramIntent.putExtra("isFromMainTab", true);
      paramIntent.putExtra("isBack2Root", true);
      paramContext.setIntent(paramIntent);
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.SpalshActivity", 2, "mainTabToAio-->openAioFragment");
      }
      paramContext.a(false, 1);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.aio.SpalshActivity", 2, "start->SpalshActivity-->AIO");
    }
    paramContext.startActivity(paramIntent);
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (paramContext == null) {}
    AdvertisementRecentUserManager localAdvertisementRecentUserManager;
    AdvertisementItem localAdvertisementItem;
    do
    {
      return;
      Object localObject;
      while (!((Iterator)localObject).hasNext())
      {
        while (TextUtils.isEmpty(paramString)) {
          if (QLog.isColorLevel())
          {
            QLog.d("RecentUtil", 2, "openAdvertisement empty uin!");
            return;
          }
        }
        localAdvertisementRecentUserManager = AdvertisementRecentUserManager.a();
        localObject = localAdvertisementRecentUserManager.a(paramString);
        if (localObject != null)
        {
          a(paramContext, paramQQAppInterface, paramString, paramInt, (AdvertisementItem)localObject);
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.d("RecentUtil", 2, "openAdvertisement item recreate, uin:" + paramString);
        }
        localObject = paramQQAppInterface.a().b(paramString, paramInt).iterator();
      }
      localAdvertisementItem = PublicAccountAdUtil.a(paramQQAppInterface, (MessageRecord)((Iterator)localObject).next(), true);
    } while (localAdvertisementItem == null);
    localAdvertisementRecentUserManager.a(localAdvertisementItem);
    a(paramContext, paramQQAppInterface, paramString, paramInt, localAdvertisementItem);
  }
  
  private static void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, int paramInt, AdvertisementItem paramAdvertisementItem)
  {
    Intent localIntent = new Intent(paramContext, PublicAccountAdvertisementActivity.class);
    localIntent.putExtra("arg_ad_json", paramAdvertisementItem.a());
    localIntent.putExtra("USR_CLICK_TIME", SystemClock.uptimeMillis());
    localIntent.putExtra("is_first_open_imax_ad", c);
    c = false;
    paramContext.startActivity(localIntent);
    ThreadManager.post(new xie(paramQQAppInterface, paramString, paramInt, paramAdvertisementItem), 5, null, false);
    AdvertisementRecentUserManager.a().a(paramQQAppInterface, 2, paramAdvertisementItem);
    if (QLog.isColorLevel()) {
      QLog.d("RecentUtil", 2, "openAdvertisement start, uin:" + paramString);
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3, boolean paramBoolean)
  {
    Intent localIntent;
    long l;
    if (paramContext != null)
    {
      if (!jdField_a_of_type_Boolean) {
        break label146;
      }
      localIntent = new Intent(paramContext, ChatActivity.class);
      if (jdField_a_of_type_ComTencentMobileqqDataMessageRecord == null) {
        break label179;
      }
      if ((jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop != 1) && (jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop != 3000)) {
        break label135;
      }
      l = jdField_a_of_type_ComTencentMobileqqDataMessageRecord.shmsgseq;
      localIntent.putExtra("searched_timeorseq", l);
    }
    label135:
    label146:
    label179:
    for (;;)
    {
      localIntent.putExtra("uin", paramString1);
      localIntent.putExtra("troop_uin", paramString2);
      localIntent.putExtra("uintype", paramInt);
      localIntent.putExtra("uinname", paramString3);
      a(localIntent);
      if (paramBoolean)
      {
        if ((paramContext instanceof SplashActivity)) {
          a(paramContext, localIntent);
        }
        return;
        l = jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time;
        break;
        localIntent = AIOUtils.a(new Intent(paramContext, SplashActivity.class), new int[] { 1 });
        continue;
      }
      paramContext.startActivity(localIntent);
      return;
    }
  }
  
  public static void a(Intent paramIntent)
  {
    if (jdField_a_of_type_Boolean)
    {
      paramIntent.putExtra("aio_msg_source", 1);
      paramIntent.putExtra("entrance", 7);
      jdField_a_of_type_Boolean = false;
      jdField_a_of_type_ComTencentMobileqqDataMessageRecord = null;
      jdField_a_of_type_Long = 0L;
      return;
    }
    paramIntent.putExtra("aio_msg_source", 0);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    if (paramRecentUser.type == 5000) {}
    for (;;)
    {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800419C", "0X800419C", 0, 0, "", "", "", "");
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80041A0", "0X80041A0", 0, 0, "", "", "", "");
      return;
      if ((paramRecentUser.type == 7200) || (paramRecentUser.type == 1008))
      {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80041A1", "0X80041A1", 0, 0, "", "", "", "");
        if (paramRecentUser.type == 1008) {
          a(paramQQAppInterface, paramRecentUser.uin, 1);
        }
      }
      else if (String.valueOf(9992L).equals(paramRecentUser.uin))
      {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800419F", "0X800419F", 0, 0, "", "", "", "");
      }
      else if (((paramRecentUser.type == 1001) || (paramRecentUser.type == 10002)) && (AppConstants.G.equals(paramRecentUser.uin)))
      {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80041A2", "0X80041A2", 0, 0, "", "", "", "");
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80050FD", "0X80050FD", 0, 0, "", "", "", "");
        ReportController.b(paramQQAppInterface, "dc00899", "grp_lbs", "", "msg_box", "drag_msg", 0, 0, "", "", "", "");
      }
      else if ((paramRecentUser.type == 1010) && (AppConstants.X.equals(paramRecentUser.uin)))
      {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80050FF", "0X80050FF", 0, 0, "", "", "", "");
      }
      else if ((paramRecentUser.type == 1009) && (AppConstants.v.equals(paramRecentUser.uin)))
      {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80041A4", "0X80041A4", 0, 0, "", "", "", "");
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser, int paramInt)
  {
    if ((paramQQAppInterface == null) || (paramRecentUser == null)) {}
    label135:
    label502:
    do
    {
      do
      {
        Object localObject1;
        do
        {
          do
          {
            int i;
            do
            {
              do
              {
                return;
                paramQQAppInterface.a().a().a(paramRecentUser, false);
                if (!MsgProxyUtils.a(paramRecentUser.uin, paramRecentUser.type)) {
                  break label773;
                }
                if ((!AppConstants.X.equals(paramRecentUser.uin)) && (!AppConstants.G.equals(paramRecentUser.uin))) {
                  break;
                }
                localObject1 = paramQQAppInterface.a().a(paramRecentUser.uin, paramRecentUser.type);
                if (localObject1 != null) {
                  paramQQAppInterface.a().a(paramRecentUser.type, ((QQMessageFacade.Message)localObject1).time);
                }
                localObject1 = paramRecentUser.uin;
                i = paramRecentUser.type;
                ThreadManager.post(new xib((MessageHandler)paramQQAppInterface.a(0), (String)localObject1, i), 8, null, false);
                paramQQAppInterface.a().a(paramRecentUser.uin, paramRecentUser.type, true, true);
                if (paramRecentUser.type == 1) {
                  HotChatUtil.a(paramQQAppInterface, paramRecentUser.uin);
                }
                if ((paramRecentUser.type == 9000) && (AppConstants.S.equals(paramRecentUser.uin)))
                {
                  paramQQAppInterface.a().a().c();
                  GroupSystemMsgController.a().a(paramQQAppInterface, 0);
                  ((RecommendTroopManagerImp)paramQQAppInterface.getManager(21)).a();
                }
                if ((paramRecentUser.type == 7210) && (AppConstants.Y.equals(paramRecentUser.uin)))
                {
                  TroopBarAssistantManager.a().e(paramQQAppInterface);
                  TroopBarAssistantManager.a().d(paramQQAppInterface);
                  paramQQAppInterface.a(true, 0);
                }
                if ((paramRecentUser.type == 7230) && (AppConstants.at.equals(paramRecentUser.uin)))
                {
                  localObject1 = ServiceAccountFolderManager.a();
                  i = ((ServiceAccountFolderManager)localObject1).b();
                  int j = ((ServiceAccountFolderManager)localObject1).a(paramQQAppInterface);
                  long l = ((ServiceAccountFolderManager)localObject1).a();
                  if (paramInt != -1) {
                    ReportController.b(paramQQAppInterface, "dc01160", "Pb_account_lifeservice", "", "0X80067EB", "0X80067EB", 0, 0, "" + j, "" + i, String.valueOf(paramInt + 1), "" + l);
                  }
                  ((ServiceAccountFolderManager)localObject1).d(paramQQAppInterface);
                  paramQQAppInterface.a(true, 0);
                  if (QLog.isColorLevel()) {
                    QLog.d("RecentUtil", 2, "deleteServiceAccountFolderFromMsgTab");
                  }
                }
                if (!AppConstants.Y.equals(paramRecentUser.uin)) {
                  break label788;
                }
                ReportController.b(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X800572D", "0X800572D", 0, 0, "", "", "", "");
                ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800623F", "0X800623F", 0, 0, "", "", "", "");
                SubscriptRecommendController.c(paramQQAppInterface, false);
                paramInt = 0;
                switch (paramRecentUser.type)
                {
                default: 
                  ReportController.b(paramQQAppInterface, "CliOper", "", "", "Msg_tab", "Delete_msg", 0, 0, paramInt + "", "", "", "");
                  if (paramRecentUser.type != 5000) {
                    break label982;
                  }
                  TroopAssistantManager.a().a(paramQQAppInterface, true);
                  paramRecentUser = TroopAssistantManager.a().b(paramQQAppInterface);
                  if (paramRecentUser != null) {
                    break label937;
                  }
                  paramInt = 0;
                  i = 0;
                }
              } while (i >= paramInt);
              localObject1 = (TroopAssistantData)paramRecentUser.get(i);
              if (localObject1 == null) {}
              for (;;)
              {
                i += 1;
                break label701;
                if ((1032 != paramRecentUser.type) || (!AppConstants.aE.equals(paramRecentUser.uin))) {
                  break;
                }
                paramQQAppInterface.a().b();
                ConfessMsgUtil.b(paramQQAppInterface, false);
                ConfessMsgUtil.a(paramQQAppInterface, false);
                break;
                b(paramQQAppInterface, paramRecentUser.uin, paramRecentUser.type);
                break label135;
                if (!AppConstants.aa.equals(paramRecentUser.uin)) {
                  break label502;
                }
                if (((EcShopAssistantManager)paramQQAppInterface.getManager(87)).a(paramQQAppInterface) > 0) {}
                for (localObject1 = "havereddot";; localObject1 = "noreddot")
                {
                  ReportController.b(paramQQAppInterface, "P_CliOper", "Shop_lifeservice", "", "Shop_DelMsglist", "Del_shopHelper", 0, 0, "", "", (String)localObject1, "");
                  break;
                }
                if (!paramRecentUser.uin.equals(AppConstants.F)) {
                  break label624;
                }
                paramInt = 7;
                break label624;
                paramInt = 1;
                break label624;
                paramInt = 2;
                break label624;
                paramInt = 3;
                a(paramQQAppInterface, paramRecentUser.uin, 2);
                break label624;
                paramInt = 4;
                break label624;
                paramInt = 5;
                break label624;
                paramInt = 6;
                break label624;
                paramInt = 8;
                break label624;
                paramInt = 9;
                break label624;
                paramInt = 11;
                break label624;
                paramInt = paramRecentUser.size();
                break label699;
                localObject1 = paramQQAppInterface.a().a(((TroopAssistantData)localObject1).troopUin, 1);
                if (localObject1 != null) {
                  TroopAssistantManager.a().a(paramQQAppInterface, ((QQMessageFacade.Message)localObject1).time);
                }
              }
              if (paramRecentUser.type == 7210)
              {
                TroopBarAssistantManager.a().a(paramQQAppInterface, true);
                ThreadManager.post(new xic(paramQQAppInterface), 8, null, false);
                TroopBarAssistantManager.a().h(paramQQAppInterface);
                return;
              }
              if (paramRecentUser.type != 7120) {
                break;
              }
              paramRecentUser = (EcShopAssistantManager)paramQQAppInterface.getManager(87);
            } while (paramRecentUser == null);
            paramRecentUser.a(true);
            localObject1 = paramRecentUser.a();
            Object localObject2;
            if (localObject1 == null)
            {
              paramInt = 0;
              i = 0;
              if (i < paramInt)
              {
                localObject2 = (EcShopData)((List)localObject1).get(i);
                if (localObject2 != null) {
                  break label1108;
                }
              }
            }
            for (;;)
            {
              i += 1;
              break label1067;
              break;
              paramInt = ((List)localObject1).size();
              break label1065;
              localObject2 = paramQQAppInterface.a().a(((EcShopData)localObject2).mUin, 1008);
              if (localObject2 != null) {
                paramRecentUser.a(((QQMessageFacade.Message)localObject2).time);
              }
            }
            if (paramRecentUser.type != 9002) {
              break;
            }
            ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8004E99", "0X8004E99", 0, 0, "", "", "", "");
            localObject1 = paramQQAppInterface.a().b(AppConstants.Z, 0);
            paramRecentUser = new ArrayList(((List)localObject1).size());
            localObject1 = ((List)localObject1).iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject2 = (MessageRecord)((Iterator)localObject1).next();
              if ((!((MessageRecord)localObject2).isread) && ((((MessageRecord)localObject2).extLong & 0x1) == 1) && (!TextUtils.isEmpty(((MessageRecord)localObject2).extStr))) {
                paramRecentUser.add(((MessageRecord)localObject2).extStr);
              }
              paramQQAppInterface.a().b(AppConstants.Z, 0, ((MessageRecord)localObject2).uniseq);
            }
          } while (paramRecentUser.size() <= 0);
          ActivateFriendServlet.a(paramQQAppInterface, (ArrayList)paramRecentUser);
          return;
          if (paramRecentUser.type == 9003)
          {
            ((BlessManager)paramQQAppInterface.getManager(137)).c();
            return;
          }
          if ((paramRecentUser.type == 7000) && (AppConstants.w.equals(paramRecentUser.uin)))
          {
            SubAccountControll.c(paramQQAppInterface);
            SubAccountControll.a(paramQQAppInterface, true, null);
            return;
          }
          if (paramRecentUser.type != 10005) {
            break;
          }
          localObject1 = ImaxAdRecentUserManager.a().a(paramRecentUser.uin);
        } while (localObject1 == null);
        ImaxAdRecentUserManager.a().a(paramQQAppInterface, paramRecentUser, (AdvertisementItem)localObject1, true);
        return;
      } while (paramRecentUser.type != 6004);
      paramQQAppInterface = (TroopRedTouchHandler)paramQQAppInterface.a(43);
    } while (paramQQAppInterface == null);
    label624:
    paramQQAppInterface.a(46);
    label699:
    label701:
    label982:
    return;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser, boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 0;
    if ((paramQQAppInterface == null) || (paramRecentUser == null)) {}
    label90:
    label376:
    do
    {
      do
      {
        Object localObject1;
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
                        for (;;)
                        {
                          return;
                          int i;
                          if (MsgProxyUtils.a(paramRecentUser.uin, paramRecentUser.type)) {
                            if ((AppConstants.X.equals(paramRecentUser.uin)) || (AppConstants.G.equals(paramRecentUser.uin)))
                            {
                              localObject1 = paramQQAppInterface.a().a(paramRecentUser.uin, paramRecentUser.type);
                              if (localObject1 != null) {
                                paramQQAppInterface.a().a(paramRecentUser.type, ((QQMessageFacade.Message)localObject1).time);
                              }
                              localObject1 = paramRecentUser.uin;
                              i = paramRecentUser.type;
                              paramQQAppInterface.a().d((String)localObject1, i);
                              ThreadManager.post(new xia((MessageHandler)paramQQAppInterface.a(0), (String)localObject1, i), 8, null, false);
                              if (paramRecentUser.type != 5000) {
                                break label422;
                              }
                              paramRecentUser = TroopAssistantManager.a().b(paramQQAppInterface);
                              if (paramRecentUser != null) {
                                break label376;
                              }
                              i = 0;
                              if (j >= i) {
                                break label385;
                              }
                              localObject1 = (TroopAssistantData)paramRecentUser.get(j);
                              if (localObject1 != null) {
                                break label387;
                              }
                            }
                          }
                          for (;;)
                          {
                            j += 1;
                            break label164;
                            if ((1032 != paramRecentUser.type) || (!AppConstants.aE.equals(paramRecentUser.uin))) {
                              break label90;
                            }
                            paramQQAppInterface.a().b();
                            ConfessMsgUtil.b(paramQQAppInterface, false);
                            ConfessMsgUtil.a(paramQQAppInterface, false);
                            break label90;
                            if (paramBoolean1)
                            {
                              localObject1 = new SessionInfo();
                              ((SessionInfo)localObject1).jdField_a_of_type_JavaLangString = paramRecentUser.uin;
                              ((SessionInfo)localObject1).b = paramRecentUser.uin;
                              ((SessionInfo)localObject1).jdField_a_of_type_Int = paramRecentUser.type;
                              if (((SessionInfo)localObject1).jdField_a_of_type_Int == 1006) {
                                ((SessionInfo)localObject1).f = ContactUtils.g(paramQQAppInterface, ((SessionInfo)localObject1).jdField_a_of_type_JavaLangString);
                              }
                              ChatActivityFacade.a(paramQQAppInterface, (SessionInfo)localObject1);
                            }
                            if ((7000 == paramRecentUser.type) && (AppConstants.w.equals(paramRecentUser.uin))) {
                              SubAccountControll.c(paramQQAppInterface);
                            }
                            paramQQAppInterface.a().a(paramRecentUser.uin, paramRecentUser.type, true, paramBoolean2);
                            if (paramRecentUser.type != 1) {
                              break label139;
                            }
                            HotChatUtil.a(paramQQAppInterface, paramRecentUser.uin);
                            break label139;
                            i = paramRecentUser.size();
                            break label164;
                            break;
                            localObject1 = paramQQAppInterface.a().a(((TroopAssistantData)localObject1).troopUin, 1);
                            if (localObject1 != null) {
                              TroopAssistantManager.a().a(paramQQAppInterface, ((QQMessageFacade.Message)localObject1).time);
                            }
                          }
                          if (5001 != paramRecentUser.type) {
                            break;
                          }
                          paramRecentUser = (HotChatCenterManager)paramQQAppInterface.getManager(254);
                          localObject1 = paramRecentUser.a();
                          if ((localObject1 != null) && (((List)localObject1).size() > 0))
                          {
                            localObject1 = ((List)localObject1).iterator();
                            while (((Iterator)localObject1).hasNext())
                            {
                              Object localObject2 = (HotChatItemData)((Iterator)localObject1).next();
                              localObject2 = paramQQAppInterface.a().a(((HotChatItemData)localObject2).mTroopUin, 1);
                              if (localObject2 != null) {
                                paramRecentUser.a(((QQMessageFacade.Message)localObject2).time);
                              }
                            }
                          }
                        }
                        if (7000 != paramRecentUser.type) {
                          break;
                        }
                      } while (!AppConstants.w.equals(paramRecentUser.uin));
                      SubAccountControll.a(paramQQAppInterface, true, null);
                      return;
                      if (AppConstants.C.equals(paramRecentUser.uin))
                      {
                        ((NewFriendManager)paramQQAppInterface.getManager(33)).d();
                        return;
                      }
                      if (String.valueOf(9980L).equals(paramRecentUser.uin))
                      {
                        paramQQAppInterface.a().a().c();
                        GroupSystemMsgController.a().a(paramQQAppInterface, 0);
                        ((RecommendTroopManagerImp)paramQQAppInterface.getManager(21)).a();
                        return;
                      }
                      if (paramRecentUser.type != 7210) {
                        break;
                      }
                      paramRecentUser = TroopBarAssistantManager.a().a(paramQQAppInterface);
                    } while ((paramRecentUser == null) || (paramRecentUser.size() <= 0));
                    paramRecentUser = (TroopBarData)paramRecentUser.get(0);
                  } while (paramRecentUser == null);
                  paramRecentUser = paramQQAppInterface.a().a(paramRecentUser.mUin, 1008);
                } while (paramRecentUser == null);
                TroopBarAssistantManager.a().a(paramQQAppInterface, paramRecentUser.time);
                return;
                if (paramRecentUser.type != 7120) {
                  break;
                }
                paramRecentUser = (EcShopAssistantManager)paramQQAppInterface.getManager(87);
              } while (paramRecentUser == null);
              localObject1 = paramRecentUser.a();
            } while ((localObject1 == null) || (((List)localObject1).size() <= 0));
            localObject1 = (EcShopData)((List)localObject1).get(0);
          } while (localObject1 == null);
          paramQQAppInterface = paramQQAppInterface.a().a(((EcShopData)localObject1).mUin, 1008);
        } while (paramQQAppInterface == null);
        paramRecentUser.a(paramQQAppInterface.time);
        return;
        if (AppConstants.al.equals(paramRecentUser.uin))
        {
          ((DingdongPluginManager)paramQQAppInterface.getManager(114)).a(true, paramBoolean2, false);
          return;
        }
        if (paramRecentUser.type == 7220)
        {
          ((KandianMergeManager)paramQQAppInterface.getManager(161)).a();
          return;
        }
        if (1001 == paramRecentUser.type)
        {
          paramQQAppInterface.a().clearMsgBoxUnreadCount();
          return;
        }
        if (paramRecentUser.lFlag == 16L)
        {
          localObject1 = new SessionInfo();
          ((SessionInfo)localObject1).jdField_a_of_type_Int = 1008;
          paramRecentUser = paramRecentUser.uin;
          ((SessionInfo)localObject1).b = paramRecentUser;
          ((SessionInfo)localObject1).jdField_a_of_type_JavaLangString = paramRecentUser;
          ChatActivityFacade.a(paramQQAppInterface, (SessionInfo)localObject1);
          paramQQAppInterface.a().a(((SessionInfo)localObject1).jdField_a_of_type_JavaLangString, 1008, true, paramBoolean2);
          return;
        }
        if (paramRecentUser.type == 10005)
        {
          localObject1 = new SessionInfo();
          ((SessionInfo)localObject1).jdField_a_of_type_Int = 10005;
          paramRecentUser = paramRecentUser.uin;
          ((SessionInfo)localObject1).b = paramRecentUser;
          ((SessionInfo)localObject1).jdField_a_of_type_JavaLangString = paramRecentUser;
          ChatActivityFacade.a(paramQQAppInterface, (SessionInfo)localObject1);
          paramQQAppInterface.a().a(((SessionInfo)localObject1).jdField_a_of_type_JavaLangString, 1008, true, paramBoolean2);
          return;
        }
      } while (paramRecentUser.type != 6004);
      paramQQAppInterface = (TroopRedTouchHandler)paramQQAppInterface.a(43);
    } while (paramQQAppInterface == null);
    label139:
    label164:
    label422:
    paramQQAppInterface.a(46);
    label385:
    label387:
    return;
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    ThreadManager.post(new xid(paramQQAppInterface, paramString, paramInt), 2, null, false);
    if ("2290230341".equals(paramString))
    {
      if (paramInt != 1) {
        break label58;
      }
      paramString = "0X80090E4";
    }
    for (;;)
    {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", paramString, paramString, 0, 0, "", "", "", "");
      return;
      label58:
      paramString = "0X80090E5";
      QZoneReport.a(3);
    }
  }
  
  public static void a(RecentUser paramRecentUser, QQMessageFacade paramQQMessageFacade)
  {
    long l1 = System.currentTimeMillis();
    if ((paramRecentUser == null) || (paramQQMessageFacade == null)) {}
    long l2;
    do
    {
      return;
      if ((paramRecentUser.getStatus() == 1000) && (paramRecentUser.lastmsgdrafttime == 0L))
      {
        paramQQMessageFacade = paramQQMessageFacade.a(paramRecentUser.uin, paramRecentUser.type);
        if (paramQQMessageFacade != null) {
          paramRecentUser.lastmsgdrafttime = paramQQMessageFacade.getTime();
        }
      }
      l2 = System.currentTimeMillis();
    } while (!QLog.isDevelopLevel());
    QLog.i("Q.recent", 4, "updateLastDraftTimeForNewRU| cost = " + (l2 - l1));
  }
  
  public static void a(List paramList)
  {
    if ((paramList != null) && (paramList.size() == 0)) {}
  }
  
  public static boolean a(RecentBaseData paramRecentBaseData)
  {
    if (paramRecentBaseData == null) {}
    return false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Activity paramActivity, RecentUser paramRecentUser, int paramInt, RecentBaseData paramRecentBaseData)
  {
    if (AppConstants.G.equals(paramRecentUser.uin))
    {
      MsgBoxListActivity.a(paramActivity, 1001, paramRecentUser.uin);
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80050F5", "0X80050F5", 0, 0, "", "", "", "");
      ReportController.b(paramQQAppInterface, "dc00899", "grp_lbs", "", "msg_box", "clk_friend", 0, 0, "", "", "", "");
      paramActivity = paramQQAppInterface.a().a(paramRecentUser.uin, 1001);
      if ((paramActivity != null) && (paramActivity.msgtype == -4011))
      {
        paramActivity = NearbyRecommenderUtils.a(paramQQAppInterface);
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80055FB", "0X80055FB", 0, 0, paramActivity[0], "", paramActivity[1], "");
      }
      return true;
    }
    if (AppConstants.X.equals(paramRecentUser.uin))
    {
      MsgBoxListActivity.a(paramActivity, 1010, paramRecentUser.uin);
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8004947", "0X8004947", 0, 0, "", "", "", "");
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80050F6", "0X80050F6", 0, 0, "", "", "", "");
      return true;
    }
    if (AppConstants.ac.equals(paramRecentUser.uin))
    {
      MsgBoxListActivity.a(paramActivity, 1001, AppConstants.G);
      ReportController.b(paramQQAppInterface, "dc00899", "grp_lbs", "", "msg_box", "tip_single", 0, 0, "", "", "", "");
      return true;
    }
    if (AppConstants.ad.equals(paramRecentUser.uin))
    {
      MsgBoxListActivity.a(paramActivity, 1010, AppConstants.X);
      return true;
    }
    if (String.valueOf(AppConstants.v).equals(paramRecentUser.uin))
    {
      MsgBoxListActivity.a(paramActivity, 1009, paramRecentUser.uin);
      return true;
    }
    if (AppConstants.D.equals(paramRecentUser.uin))
    {
      paramQQAppInterface.a().c(AppConstants.D, 0);
      paramRecentUser = new Intent(paramActivity, VisitorsActivity.class);
      paramRecentUser.putExtra("votersOnly", true);
      paramRecentUser.putExtra("toUin", Long.valueOf(paramQQAppInterface.getCurrentAccountUin()));
      paramActivity.startActivity(paramRecentUser);
      return true;
    }
    if (AppConstants.C.equals(paramRecentUser.uin))
    {
      paramRecentUser = new Intent(paramActivity, NewFriendActivity.class);
      paramRecentUser.putExtra("EntranceId", 1);
      paramRecentUser.setFlags(67108864);
      paramActivity.startActivity(paramRecentUser);
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Add_frd", "Clk_Frd_offer", 22, 0, "", "", "", "");
      return true;
    }
    if (AppConstants.B.equals(paramRecentUser.uin))
    {
      paramRecentUser = new Intent(paramActivity, TroopAssistantActivity.class);
      paramRecentUser.setFlags(67108864);
      paramActivity.startActivity(paramRecentUser);
      ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Clk_help", 0, 0, "", "", "", "");
      return true;
    }
    Object localObject1;
    Object localObject2;
    if (AppConstants.aC.equals(paramRecentUser.uin))
    {
      paramRecentUser = new Intent(paramActivity, HotChatCenterFragment.class);
      paramRecentBaseData = (HotChatCenterManager)paramQQAppInterface.getManager(254);
      localObject1 = paramRecentBaseData.a();
      ApolloGameUtil.a(paramQQAppInterface.getEntityManagerFactory().createEntityManager(), true);
      if (localObject1 != null)
      {
        paramRecentBaseData.a(((HotChatItemData)localObject1).mTroopUin, 1);
        localObject2 = paramQQAppInterface.getHandler(Conversation.class);
        if (localObject2 != null) {
          ((MqqHandler)localObject2).sendEmptyMessage(1009);
        }
        if (((HotChatItemData)localObject1).mIsRead4Folder) {
          break label677;
        }
      }
      label677:
      for (paramInt = 99;; paramInt = paramRecentBaseData.a())
      {
        VipUtils.a(paramQQAppInterface, "cmshow", "Apollo", "clk_reliao_folder", paramInt, 0, new String[0]);
        paramRecentUser.setFlags(67108864);
        PublicFragmentActivity.a(paramActivity, paramRecentUser, HotChatCenterFragment.class);
        return true;
      }
    }
    if (AppConstants.H.equals(paramRecentUser.uin))
    {
      paramQQAppInterface = new Intent(paramActivity, QQBroadcastActivity.class);
      paramQQAppInterface.setFlags(67108864);
      paramActivity.startActivity(paramQQAppInterface);
      return true;
    }
    if (AppConstants.Y.equals(paramRecentUser.uin))
    {
      SubscriptRecommendController.c(paramQQAppInterface, false);
      paramRecentUser = TroopBarAssistantManager.a();
      if (paramRecentUser.c(paramQQAppInterface)) {
        ReportController.b(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X8005B70", "0X8005B70", 0, 0, paramQQAppInterface.getCurrentAccountUin(), "", "", "");
      }
      paramRecentUser.e(paramQQAppInterface, false);
      paramRecentUser.d(paramQQAppInterface, false);
      paramInt = TroopBarAssistantManager.a().a(paramQQAppInterface);
      if (paramInt > 0)
      {
        ReportController.b(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X800572B", "0X800572B", 0, 0, "", "", "", "");
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8006573", "0X8006573", 0, 0, "", "", "", "");
        if (paramInt <= 0) {
          break label4280;
        }
      }
    }
    label950:
    label2359:
    label4280:
    for (paramInt = 1;; paramInt = 0)
    {
      ThreadManager.post(new xhy(paramQQAppInterface, paramInt), 8, null, false);
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800623E", "0X800623E", 0, 0, "", "", "", "");
      ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_tribe", "", "Msglist", "Clk_tribeHelper", 0, 0, "", "", "", "");
      if (ReadInJoyHelper.a(paramQQAppInterface))
      {
        paramQQAppInterface = ReadInJoyActivityHelper.a(paramActivity, 0, 1);
        paramQQAppInterface.putExtra("start_time", System.currentTimeMillis());
        if (paramInt == 0) {
          break label1068;
        }
      }
      for (boolean bool1 = true;; bool1 = false)
      {
        paramQQAppInterface.putExtra("has_red_hot", bool1);
        paramQQAppInterface.putExtra("come_from", 1);
        paramQQAppInterface.setFlags(67108864);
        paramActivity.startActivity(paramQQAppInterface);
        return true;
        ReportController.b(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X800572C", "0X800572C", 0, 0, "", "", "", "");
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8006574", "0X8006574", 0, 0, "", "", "", "");
        break;
        paramQQAppInterface = ReadInJoyActivityHelper.a(paramActivity, -1, 1);
        break label950;
      }
      int j;
      int i;
      if (TextUtils.equals(AppConstants.ar, paramRecentUser.uin))
      {
        if (paramRecentBaseData != null) {
          paramInt = paramRecentBaseData.i;
        }
        for (;;)
        {
          localObject1 = new ArrayList();
          paramRecentBaseData = paramQQAppInterface.a();
          if (paramRecentBaseData == null) {
            break label1496;
          }
          paramRecentBaseData = paramRecentBaseData.b(paramRecentUser.uin, paramRecentUser.type);
          if ((paramRecentBaseData == null) || (!(paramRecentBaseData instanceof MessageForStructing)) || (paramRecentBaseData.extInt != 1)) {
            break label1535;
          }
          paramRecentUser = (MessageForStructing)paramRecentBaseData;
          if (paramRecentUser.structingMsg == null) {
            paramRecentUser.parse();
          }
          if (paramRecentUser.structingMsg == null) {
            break label1358;
          }
          if (!TextUtils.isEmpty(paramRecentUser.structingMsg.mArticleIds))
          {
            localObject2 = paramRecentUser.structingMsg.mArticleIds.split("\\|");
            j = localObject2.length;
            i = 0;
            label1215:
            if (i < j)
            {
              String str2 = localObject2[i];
              try
              {
                ((ArrayList)localObject1).add(Long.valueOf(Long.parseLong(str2)));
                i += 1;
                break label1215;
                paramInt = -1;
              }
              catch (Exception localException4)
              {
                for (;;)
                {
                  localException4.printStackTrace();
                }
              }
            }
          }
        }
        if (!TextUtils.isEmpty(paramRecentUser.structingMsg.mMsgActionData))
        {
          localObject2 = PublicAccountUtil.a(paramRecentUser.structingMsg.mMsgActionData);
          if (localObject2 == null) {}
        }
      }
      for (;;)
      {
        long l;
        try
        {
          l = Long.parseLong(((JSONObject)localObject2).getString("id"));
          if (l != -1L) {
            ReportController.b(null, "CliOper", "", "", "0X80066F5", "0X80066F5", 0, 0, String.valueOf(paramInt + 1), "", String.valueOf(l), "");
          }
          PublicAccountUtil.a(paramQQAppInterface, paramRecentUser, 1);
          label1358:
          paramQQAppInterface = "";
          paramRecentUser = paramQQAppInterface;
          if (paramRecentBaseData == null) {
            break label4268;
          }
          paramRecentUser = paramQQAppInterface;
        }
        catch (Exception localException1)
        {
          label1496:
          localException1.printStackTrace();
        }
        try
        {
          if (!(paramRecentBaseData instanceof MessageForStructing)) {
            break label4268;
          }
          paramRecentBaseData = (MessageForStructing)paramRecentBaseData;
          if (paramRecentBaseData.structingMsg.mStrategyIds != null) {
            paramQQAppInterface = paramRecentBaseData.structingMsg.mStrategyIds.split("\\|")[0];
          }
          paramRecentUser = paramQQAppInterface;
          if (paramRecentBaseData.structingMsg.mAlgorithmIds == null) {
            break label4268;
          }
          paramRecentUser = paramRecentBaseData.structingMsg.mAlgorithmIds.split("\\|")[0];
          PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80066F4", "0X80066F4", 0, 0, String.valueOf(paramInt + 1), "", paramQQAppInterface, ReadInJoyUtils.b(paramRecentUser), false);
          PublicAccountReportUtils.a("0X80066F4", "", String.valueOf(paramInt + 1), "", paramQQAppInterface, ReadInJoyUtils.b(paramRecentUser));
        }
        catch (Exception paramQQAppInterface)
        {
          label1535:
          QLog.d("KandianMergeManager", 1, "failed to report new kandian click " + paramQQAppInterface.toString());
          continue;
          l = ((Long)((ArrayList)localObject1).get(0)).longValue();
          continue;
        }
        if (((ArrayList)localObject1).isEmpty())
        {
          l = -1L;
          ReadInJoyActivityHelper.a(paramActivity, (List)localObject1, l, 5);
          return true;
          l = -1L;
          continue;
          ReportController.b(null, "CliOper", "", "", "0X80066F6", "0X80066F6", 0, 0, String.valueOf(paramInt + 1), "", "", "");
        }
        else
        {
          if (AppConstants.am.equals(paramRecentUser.uin))
          {
            paramRecentUser = (BlessManager)paramQQAppInterface.getManager(137);
            if (paramRecentUser != null)
            {
              paramRecentBaseData = new Intent();
              paramRecentBaseData.setClass(paramActivity, BlessActivity.class);
              paramActivity.startActivity(paramRecentBaseData);
              ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800618B", "0X800618B", 0, 0, "", "", "", "");
              if (paramRecentUser.h()) {
                ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800632C", "0X800632C", 0, 0, "", "", "", "");
              }
            }
            return true;
          }
          if (AppConstants.Q.equals(paramRecentUser.uin)) {
            return true;
          }
          Object localObject3;
          if (AppConstants.S.equals(paramRecentUser.uin))
          {
            paramRecentBaseData = "1";
            localObject3 = new Intent();
            ((Intent)localObject3).putExtra("key_tab_mode", 2);
            ((Intent)localObject3).setClass(paramActivity, TroopActivity.class);
            paramInt = GroupSystemMsgController.a().a(paramQQAppInterface);
            if (paramInt > 0)
            {
              localObject1 = "0";
              paramRecentBaseData = "0";
            }
            for (;;)
            {
              paramQQAppInterface.a().c(AppConstants.S, 9000, -paramInt);
              ((Intent)localObject3).putExtra("_key_mode", paramRecentUser.jumpTabMode);
              paramActivity.startActivity((Intent)localObject3);
              ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_contacts", "", "notice", "Clk_notice", 0, 0, "", paramRecentBaseData, (String)localObject1, "");
              return true;
              paramInt = RecommendTroopManagerImp.b(paramQQAppInterface);
              if (paramInt > 0)
              {
                paramRecentBaseData = "0";
                localObject1 = "1";
              }
              else
              {
                localObject1 = "0";
              }
            }
          }
          if (AppConstants.y.equals(paramRecentUser.uin))
          {
            paramRecentUser = new Intent(paramActivity, LiteActivity.class);
            paramRecentUser.putExtra("targetUin", AppConstants.y);
            paramActivity.startActivity(paramRecentUser);
            ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800603B", "0X800603B", 0, 0, "", "", "", "");
            return true;
          }
          if (AppConstants.z.equals(paramRecentUser.uin))
          {
            paramRecentUser = new Intent(paramActivity, LiteActivity.class);
            paramRecentUser.putExtra("targetUin", AppConstants.z);
            paramActivity.startActivity(paramRecentUser);
            ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8006040", "0X8006040", 0, 0, "", "", "", "");
            return true;
          }
          if (AppConstants.Z.equals(paramRecentUser.uin))
          {
            paramQQAppInterface = new Intent(paramActivity, ActivateFriendActivity.class);
            paramQQAppInterface.setFlags(67108864);
            if (paramInt == 0) {}
            for (paramInt = 1;; paramInt = 3)
            {
              paramQQAppInterface.putExtra("af_key_from", paramInt);
              paramActivity.startActivity(paramQQAppInterface);
              return true;
            }
          }
          if (AppConstants.aa.equals(paramRecentUser.uin))
          {
            paramRecentUser = new Intent(paramActivity, EcshopWebActivity.class);
            paramRecentUser.putExtra("start_time", System.currentTimeMillis());
            paramRecentUser.setFlags(67108864);
            ReportController.b(paramQQAppInterface, "P_CliOper", "Shop_lifeservice", "", "Msglist", "Clk_ShopHelper", 0, 0, "", "", "", "");
            localObject1 = (EcShopAssistantManager)paramQQAppInterface.getManager(87);
            if (localObject1 != null)
            {
              localObject3 = ((EcShopAssistantManager)localObject1).a();
              if (localObject3 != null) {
                break label2359;
              }
              paramInt = 0;
              if (paramInt == 0) {
                ReportController.b(paramQQAppInterface, "P_CliOper", "Shop_lifeservice", "", "Shop_noMsglist", "Clk_ShopHelper", 0, 0, "", "", "", "");
              }
              i = ((EcShopAssistantManager)localObject1).a(paramQQAppInterface);
              if (i <= 0) {
                break label4265;
              }
              i = 1;
            }
          }
          for (;;)
          {
            ReportController.b(paramQQAppInterface, "dc00899", "Pb_account_lifeservice", "1", "0X80064CB", "0X80064CB", 0, 0, "" + i, "" + paramInt, "", "");
            if (i != 0)
            {
              bool1 = true;
              paramRecentUser.putExtra("has_red_hot", bool1);
              if (paramRecentBaseData != null) {
                break label2376;
              }
            }
            label2376:
            for (paramInt = -1;; paramInt = paramRecentBaseData.jdField_c_of_type_Int)
            {
              ((EcShopAssistantManager)localObject1).a(paramRecentUser, paramActivity, paramInt);
              paramActivity.startActivity(paramRecentUser);
              return true;
              paramInt = ((List)localObject3).size();
              break;
              bool1 = false;
              break label2327;
            }
            if (1012 == paramRecentUser.msgType)
            {
              paramQQAppInterface = new ProfileActivity.AllInOne(paramQQAppInterface.getCurrentAccountUin(), 0);
              paramRecentUser = new Intent(paramActivity, NearbyPeopleProfileActivity.class);
              paramRecentUser.putExtra("param_mode", 2);
              paramRecentUser.putExtra("AllInOne", paramQQAppInterface);
              paramRecentUser.putExtra("frome_where", -1);
              paramRecentUser.putExtra("abp_flag", true);
              paramRecentUser.addFlags(67108864);
              paramActivity.startActivity(paramRecentUser);
              return true;
            }
            if (1030 == paramRecentUser.msgType)
            {
              if ((paramRecentBaseData instanceof RecentItemNoticeData))
              {
                paramQQAppInterface = ((RecentItemNoticeData)paramRecentBaseData).a;
                if (paramQQAppInterface != null) {
                  paramActivity.startActivity(paramQQAppInterface);
                }
                return true;
              }
            }
            else
            {
              if (AppConstants.al.equals(paramRecentUser.uin))
              {
                ((DingdongPluginManager)paramQQAppInterface.getManager(114)).a(false, false, true);
                paramRecentUser = new Intent();
                paramRecentUser.putExtra("_current_unread_num", paramQQAppInterface.a().a(AppConstants.al, 9999));
                paramRecentUser.putExtra("_from_", 2);
                DingdongPluginHelper.a(paramActivity, "com.dingdong.business.base.activity.DingdongUinListActivity", paramRecentUser, -1);
                DingdongPluginHelper.a("0x8005EBA");
                return true;
              }
              Object localObject9;
              MessageRecord localMessageRecord;
              if (TextUtils.equals(AppConstants.as, paramRecentUser.uin))
              {
                localObject1 = paramQQAppInterface.a();
                localObject9 = new ArrayList();
                if (localObject1 != null)
                {
                  localMessageRecord = ((QQMessageFacade)localObject1).b(paramRecentUser.uin, paramRecentUser.type);
                  if ((localMessageRecord != null) && ((localMessageRecord instanceof MessageForStructing)) && (localMessageRecord.extInt == 1))
                  {
                    paramRecentUser = (MessageForStructing)localMessageRecord;
                    if (paramRecentUser.structingMsg == null) {
                      paramRecentUser.parse();
                    }
                    if (paramRecentUser.structingMsg != null)
                    {
                      if (!TextUtils.isEmpty(paramRecentUser.structingMsg.mArticleIds))
                      {
                        localObject1 = paramRecentUser.structingMsg.mArticleIds.split("\\|");
                        j = localObject1.length;
                        i = 0;
                        for (;;)
                        {
                          if (i < j)
                          {
                            localObject3 = localObject1[i];
                            try
                            {
                              ((ArrayList)localObject9).add(Long.valueOf(Long.parseLong((String)localObject3)));
                              i += 1;
                            }
                            catch (Exception localException2)
                            {
                              for (;;)
                              {
                                localException2.printStackTrace();
                              }
                            }
                          }
                        }
                      }
                      if (!TextUtils.isEmpty(paramRecentUser.structingMsg.mMsgActionData))
                      {
                        paramRecentUser = PublicAccountUtil.a(paramRecentUser.structingMsg.mMsgActionData);
                        if (paramRecentUser == null) {}
                      }
                    }
                  }
                }
              }
              for (;;)
              {
                int k;
                Object localObject4;
                Object localObject10;
                Object localObject8;
                try
                {
                  l = Long.parseLong(paramRecentUser.getString("id"));
                  paramRecentUser = (KandianMergeManager)paramQQAppInterface.getManager(161);
                  if (paramRecentBaseData != null)
                  {
                    j = paramRecentBaseData.i;
                    if ((localMessageRecord == null) || (localMessageRecord.uniseq != paramRecentUser.b())) {
                      break label3475;
                    }
                    k = 1;
                    if (localMessageRecord == null) {
                      break label4257;
                    }
                    if ((localMessageRecord.extInt != 1) && (localMessageRecord.extInt != 3)) {
                      break label3481;
                    }
                    i = 0;
                    if ((localMessageRecord == null) || (!localMessageRecord.isread)) {
                      break label3536;
                    }
                    ReadInJoyUtils.a(1);
                    ReadInJoyUtils.e = -1;
                    ReadInJoyUtils.b(String.valueOf(System.currentTimeMillis()));
                    paramRecentUser = "";
                    localObject1 = "";
                    localObject5 = "";
                    localObject4 = "";
                    if ((localMessageRecord == null) || (!(localMessageRecord instanceof MessageForStructing))) {
                      break label3754;
                    }
                    localObject10 = (MessageForStructing)localMessageRecord;
                    localObject6 = localObject5;
                    localObject8 = localObject4;
                    if (((MessageForStructing)localObject10).structingMsg != null)
                    {
                      if (((MessageForStructing)localObject10).structingMsg.mStrategyIds != null) {
                        localObject5 = localObject10.structingMsg.mStrategyIds.split("\\|")[0];
                      }
                      if (((MessageForStructing)localObject10).structingMsg.mAlgorithmIds != null) {
                        localObject4 = localObject10.structingMsg.mAlgorithmIds.split("\\|")[0];
                      }
                      localObject6 = localObject5;
                      localObject8 = localObject4;
                      if (((MessageForStructing)localObject10).structingMsg.reportEventFolderStatusValue != null)
                      {
                        localObject6 = localObject5;
                        localObject8 = localObject4;
                        if (TextUtils.isEmpty(((MessageForStructing)localObject10).structingMsg.reportEventFolderStatusValue)) {}
                      }
                    }
                  }
                }
                catch (Exception paramRecentUser)
                {
                  Object localObject6;
                  paramRecentUser.printStackTrace();
                }
                try
                {
                  ReadInJoyUtils.a(Integer.parseInt(((MessageForStructing)localObject10).structingMsg.reportEventFolderStatusValue));
                  localObject8 = localObject4;
                  localObject6 = localObject5;
                }
                catch (Exception localException5)
                {
                  localException5.printStackTrace();
                  localObject7 = localObject5;
                  localObject8 = localObject4;
                  continue;
                }
                Object localObject5 = localObject6;
                localObject6 = localObject8;
                bool1 = false;
                boolean bool2 = false;
                boolean bool3;
                if (localMessageRecord != null)
                {
                  localObject4 = localMessageRecord.senderuin;
                  localObject8 = localObject4;
                  if (localMessageRecord != null) {
                    bool3 = bool1;
                  }
                }
                try
                {
                  localObject10 = new JSONObject(localMessageRecord.extStr);
                  bool3 = bool1;
                  if (!((JSONObject)localObject10).has("kdShouldShowMergedAvatar")) {
                    break label3892;
                  }
                  bool3 = bool1;
                  if (!((JSONObject)localObject10).getBoolean("kdShouldShowMergedAvatar")) {
                    break label3892;
                  }
                  bool3 = bool1;
                  if (localMessageRecord.isread) {
                    break label3892;
                  }
                  bool1 = true;
                  localObject8 = localObject4;
                  bool2 = bool1;
                  bool3 = bool1;
                  if (((JSONObject)localObject10).has("kdUin"))
                  {
                    bool3 = bool1;
                    localObject8 = ((JSONObject)localObject10).getString("kdUin");
                    bool2 = bool1;
                  }
                  localObject4 = localObject8;
                }
                catch (Exception localException6)
                {
                  label3536:
                  int m;
                  Object localObject7;
                  String str1;
                  localException6.printStackTrace();
                  bool2 = bool3;
                  continue;
                  String str3 = "";
                  continue;
                  localObject9 = "";
                  continue;
                }
                if (((ArrayList)localObject9).size() > 0)
                {
                  localObject8 = String.valueOf(((ArrayList)localObject9).get(0));
                  if (k == 0) {
                    break label3919;
                  }
                  localObject9 = "1";
                  PublicAccountReportUtils.a(null, "CliOper", "", (String)localObject4, "0X80066F4", "0X80066F4", 0, 0, String.valueOf(j + 1), (String)localObject8, (String)localObject5, ReadInJoyUtils.a(localObject6, (String)localObject1, (String)localObject9, paramRecentUser, bool2), false);
                  PublicAccountReportUtils.a("0X80066F4", (String)localObject4, String.valueOf(j + 1), "", (String)localObject5, ReadInJoyUtils.a(localObject6, (String)localObject1));
                  ReadInJoyUtils.a(21, (String)localObject8, (String)localObject5, localObject6, (String)localObject4, -1);
                  if (paramRecentBaseData == null) {
                    break label4021;
                  }
                  if (paramRecentBaseData.jdField_c_of_type_JavaLangCharSequence == null) {
                    break label4015;
                  }
                  paramRecentUser = paramRecentBaseData.jdField_c_of_type_JavaLangCharSequence.toString();
                  paramRecentUser = new StringBuilder().append("enter kandianMergeBox, brief : ").append(ReadInJoyUtils.c(paramRecentUser)).append(",isUnRead : ");
                  if ((paramRecentBaseData == null) || (paramRecentBaseData.jdField_c_of_type_Int == 0)) {
                    break label4027;
                  }
                  bool1 = true;
                  QLog.d("KandianMergeManager", 1, bool1);
                  if (paramInt != 1) {
                    break label4033;
                  }
                  paramInt = 9;
                  ReadInJoyActivityHelper.a(paramQQAppInterface, paramActivity, paramInt, 0);
                  PublicTracker.a(null, "KANDIAN_FEEDS_STAGE_1_COST");
                  PublicTracker.a(null, "KANDIAN_FEEDS_COST");
                  PublicTracker.a(null, "KANDIAN_NEW_FEEDS_ACTIVITY_MANAGER");
                  return true;
                  l = -1L;
                  continue;
                  j = -1;
                  continue;
                  k = 0;
                  continue;
                  if ((localMessageRecord.extInt == 2) || (localMessageRecord.extInt == 4))
                  {
                    i = 1;
                    continue;
                  }
                  if (localMessageRecord.extInt == 5)
                  {
                    i = 2;
                    continue;
                  }
                  if (localMessageRecord.extInt != 6) {
                    break label4257;
                  }
                  i = 3;
                  continue;
                  if (i == 0)
                  {
                    if ((paramRecentUser != null) && (paramRecentUser.a(localMessageRecord) == 1)) {
                      ReadInJoyUtils.a(5);
                    }
                    for (;;)
                    {
                      ReportController.b(null, "CliOper", "", "", "0X80066F5", "0X80066F5", 0, 0, String.valueOf(j + 1), "", Long.toString(l), "");
                      paramRecentUser = "";
                      localObject1 = "";
                      break;
                      ReadInJoyUtils.a(3);
                    }
                  }
                  if (i == 1)
                  {
                    if ((!TextUtils.isEmpty(localMessageRecord.senderuin)) && (PublicAccountUtil.b(paramQQAppInterface, localMessageRecord.senderuin))) {
                      ReadInJoyUtils.a(4);
                    }
                    for (;;)
                    {
                      ReportController.b(null, "CliOper", "", "", "0X80066F5", "0X80066F5", 0, 0, String.valueOf(j + 1), "", "0", "");
                      paramRecentUser = "";
                      localObject1 = "";
                      break;
                      ReadInJoyUtils.a(2);
                    }
                  }
                  if (i != 2) {
                    break label4247;
                  }
                  ReadInJoyUtils.a(6);
                  paramRecentUser = paramRecentUser.a();
                  if (paramRecentUser == null) {
                    break label4247;
                  }
                  m = paramRecentUser.b;
                  paramRecentUser = String.valueOf(paramRecentUser.e);
                  localObject1 = String.valueOf(m);
                  continue;
                  localObject7 = localObject5;
                  localObject8 = localObject4;
                  if (localMessageRecord != null)
                  {
                    localObject7 = localObject5;
                    localObject8 = localObject4;
                    if (i == 3)
                    {
                      localObject7 = localObject5;
                      localObject8 = localObject4;
                      try
                      {
                        localObject10 = new JSONObject(localMessageRecord.extStr);
                        localObject7 = localObject5;
                        localObject8 = localObject4;
                        localObject5 = ((JSONObject)localObject10).getString("strategy_id");
                        localObject7 = localObject5;
                        localObject8 = localObject4;
                        localObject4 = ((JSONObject)localObject10).getString("algorithm_id");
                        localObject7 = localObject5;
                        localObject8 = localObject4;
                        ReadInJoyUtils.a(((JSONObject)localObject10).optInt("folder_status", 10));
                        localObject7 = localObject4;
                      }
                      catch (Exception localException3)
                      {
                        localException3.printStackTrace();
                      }
                    }
                  }
                  localObject5 = localObject7;
                  localObject7 = localObject8;
                  continue;
                  str1 = "";
                  continue;
                  bool1 = false;
                  continue;
                }
                label3919:
                ReadInJoyUtils.b(String.valueOf(System.currentTimeMillis()));
                if (paramRecentBaseData != null) {}
                for (i = paramRecentBaseData.i;; i = -1)
                {
                  PublicAccountReportUtils.a(null, "CliOper", "", "", "0X80066F4", "0X80066F4", 0, 0, String.valueOf(i + 1), "", "", ReadInJoyUtils.b(""), false);
                  PublicAccountReportUtils.a("0X80066F4", "", String.valueOf(i + 1), "", "", ReadInJoyUtils.b(""));
                  break;
                }
                paramRecentUser = "";
                continue;
                paramRecentUser = "";
                continue;
                label4027:
                bool1 = false;
                continue;
                label4033:
                paramInt = 5;
                continue;
                if (AppConstants.at.equals(paramRecentUser.uin))
                {
                  paramRecentUser = new Intent(paramActivity, ServiceAccountFolderActivity.class);
                  paramRecentUser.putExtra("from_source", "from_msg_tab");
                  paramRecentUser.setFlags(67108864);
                  paramActivity.startActivity(paramRecentUser);
                  if (QLog.isColorLevel()) {
                    QLog.d("RecentUtil", 2, "enterServiceAccountFolderActivityFromMsgTab");
                  }
                  if (paramRecentBaseData == null) {}
                  for (paramInt = -1;; paramInt = paramRecentBaseData.i)
                  {
                    ThreadManager.executeOnSubThread(new xhz(paramQQAppInterface, paramInt));
                    PublicTracker.a(null, "SERVICE_FOLDER_COST");
                    return true;
                  }
                }
                if (AppConstants.av.equals(paramRecentUser.uin))
                {
                  ((ChangeMachineManager)paramQQAppInterface.getManager(182)).a(paramActivity);
                  return true;
                }
                if (AppConstants.aE.equals(paramRecentUser.uin))
                {
                  ConfessMsgListFragment.a(paramActivity, 1);
                  ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X8008F4C", "0X8008F4C", 0, 0, "", "", "", "");
                  return true;
                }
                if (AppConstants.aH.equals(paramRecentUser.uin))
                {
                  WeishiReportUtil.a(paramRecentBaseData, 9);
                  ReadInJoyActivityHelper.a(paramActivity, 9, null);
                  return true;
                }
                return false;
                paramRecentUser = "";
                localObject1 = "";
                continue;
                i = 0;
              }
            }
            return true;
          }
          paramRecentBaseData = "";
          paramQQAppInterface = paramRecentUser;
          paramRecentUser = paramRecentBaseData;
        }
      }
    }
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramQQAppInterface != null)
    {
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString))
      {
        paramQQAppInterface = (FriendsManager)paramQQAppInterface.getManager(50);
        if (paramQQAppInterface != null) {
          break label35;
        }
      }
    }
    label35:
    for (bool1 = false;; bool1 = paramQQAppInterface.b(paramString)) {
      return bool1;
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if ((paramQQAppInterface == null) || (paramString == null))
    {
      break label8;
      break label8;
      break label8;
    }
    label8:
    label610:
    for (;;)
    {
      return;
      if (paramQQAppInterface.a().a(paramString, paramInt) > 0)
      {
        long l2 = paramQQAppInterface.a().a(paramString, paramInt);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.sendReadConfirm_PB", 2, String.format("RecentUtil,uin: %s, uinType: %d, id: %d", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(l2) }));
        }
        if (l2 == -1L) {
          break;
        }
        msg_svc.PbMsgReadedReportReq localPbMsgReadedReportReq = new msg_svc.PbMsgReadedReportReq();
        Object localObject1;
        Object localObject2;
        if (paramInt == 1)
        {
          localObject1 = "troop_processor";
          if (!paramString.matches("^\\d+$")) {
            break;
          }
          localObject2 = new msg_svc.PbGroupReadedReportReq();
          ((msg_svc.PbGroupReadedReportReq)localObject2).group_code.set(Long.valueOf(paramString).longValue());
          ((msg_svc.PbGroupReadedReportReq)localObject2).last_read_seq.set(l2);
          localPbMsgReadedReportReq.grp_read_report.add((MessageMicro)localObject2);
          paramString = (String)localObject1;
        }
        for (;;)
        {
          paramQQAppInterface.a().a(paramString).a(localPbMsgReadedReportReq);
          return;
          if (paramInt == 1026)
          {
            localObject1 = "hctopic_processor";
            localObject2 = new msg_svc.PbGroupReadedReportReq();
            ((msg_svc.PbGroupReadedReportReq)localObject2).group_code.set(Long.valueOf(paramString).longValue());
            ((msg_svc.PbGroupReadedReportReq)localObject2).last_read_seq.set(l2);
            localPbMsgReadedReportReq.grp_read_report.add((MessageMicro)localObject2);
            paramString = (String)localObject1;
          }
          else
          {
            if (paramInt != 3000) {
              break;
            }
            localObject1 = "disc_processor";
            localObject2 = new msg_svc.PbDiscussReadedReportReq();
            ((msg_svc.PbDiscussReadedReportReq)localObject2).conf_uin.set(Long.valueOf(paramString).longValue());
            ((msg_svc.PbDiscussReadedReportReq)localObject2).last_read_seq.set(l2);
            localPbMsgReadedReportReq.dis_read_report.add((MessageMicro)localObject2);
            paramString = (String)localObject1;
          }
        }
        if ((!MsgProxyUtils.c(paramInt)) || (l2 == 0L)) {
          break;
        }
        if (AppConstants.F.equals(paramString))
        {
          paramQQAppInterface.a().a().a();
          return;
        }
        if ((paramInt == 1001) && (Long.valueOf(paramString).longValue() > AppConstants.l)) {
          break;
        }
        if ((paramInt == 1001) && (MsgProxyUtils.d(paramString)))
        {
          if (MsgProxyUtils.e(paramString))
          {
            MsgBoxProtocol.a(paramQQAppInterface, 1, null);
            return;
          }
          MsgBoxProtocol.a(paramQQAppInterface, 2, null);
          return;
        }
        long l1 = -1L;
        if (paramInt == 1006)
        {
          localObject1 = ContactUtils.g(paramQQAppInterface, paramString);
          if (TextUtils.isEmpty((CharSequence)localObject1)) {}
        }
        for (l1 = Long.valueOf((String)localObject1).longValue();; l1 = Long.valueOf(paramString).longValue())
        {
          if (l1 == -1L) {
            break label610;
          }
          localObject1 = new msg_svc.PbC2CReadedReportReq.UinPairReadInfo();
          ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject1).peer_uin.set(l1);
          ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject1).last_read_time.set((int)l2);
          if (paramInt == 1024)
          {
            paramString = paramQQAppInterface.a().d(paramString);
            if (paramString != null)
            {
              if (QLog.isDevelopLevel()) {
                QLog.d("Q.msg.sendReadConfirm_PB", 4, "Readcomfirmed------->Sig:" + HexUtil.a(paramString) + ",length:" + paramString.length);
              }
              ((msg_svc.PbC2CReadedReportReq.UinPairReadInfo)localObject1).crm_sig.set(ByteStringMicro.copyFrom(paramString));
            }
          }
          paramString = new msg_svc.PbC2CReadedReportReq();
          paramString.pair_info.add((MessageMicro)localObject1);
          localObject1 = paramQQAppInterface.a().a().a();
          if (localObject1 != null) {
            paramString.sync_cookie.set(ByteStringMicro.copyFrom((byte[])localObject1));
          }
          localPbMsgReadedReportReq.c2c_read_report.set(paramString);
          paramString = "c2c_processor";
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentUtil
 * JD-Core Version:    0.7.0.1
 */
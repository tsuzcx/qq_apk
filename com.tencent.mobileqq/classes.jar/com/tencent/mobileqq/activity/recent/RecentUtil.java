package com.tencent.mobileqq.activity.recent;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseIntArray;
import com.dataline.activities.LiteActivity;
import com.tencent.biz.TroopRedpoint.TroopRedTouchHandler;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity;
import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementRecentUserManager;
import com.tencent.biz.pubaccount.Advertisement.util.PublicAccountAdUtil;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.pubaccount.ecshopassit.EcShopData;
import com.tencent.biz.pubaccount.ecshopassit.EcshopWebActivity;
import com.tencent.biz.pubaccount.qqnews.QQNewsUtilKt;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderFeed;
import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager;
import com.tencent.biz.pubaccount.subscript.SubscriptRecommendController;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarAssistantManager;
import com.tencent.biz.pubaccount.troopbarassit.TroopBarData;
import com.tencent.biz.pubaccount.util.PublicTracker;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.biz.pubaccount.weishi_new.api.IWSManager;
import com.tencent.comic.api.IQQComicConfigApi;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.devicemgr.SmartDeviceProxyMgr;
import com.tencent.device.utils.SmartDeviceReport;
import com.tencent.imcore.message.BaseMessageProcessor;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.Message;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.imcore.message.UinTypeUtil;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.QQBroadcastActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.QQLSActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TroopAssistantActivity;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.activity.activateFriend.ActivateFriendActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.BaseSessionInfo;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.XMLMessageUtils;
import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentItemDiscussionMsgData;
import com.tencent.mobileqq.activity.recent.data.RecentItemNoticeData;
import com.tencent.mobileqq.activity.recent.data.RecentItemSubAccount;
import com.tencent.mobileqq.activity.recent.data.RecentItemTroopMsgData;
import com.tencent.mobileqq.activity.recent.msgbox.FilterMsgBoxFragment;
import com.tencent.mobileqq.activity.recent.msgbox.TempMsgBoxFragment;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxManager;
import com.tencent.mobileqq.activity.recent.msgbox.api.ITempMsgBoxService;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.HotChatCenterManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendServlet;
import com.tencent.mobileqq.app.message.ProcessorDispatcher;
import com.tencent.mobileqq.app.message.SystemMessageProcessor;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.app.utils.RouteUtils;
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
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.dating.MsgBoxListActivity;
import com.tencent.mobileqq.ecshop.api.IEcshopUtilApi;
import com.tencent.mobileqq.ecshop.report.api.IEcshopReportApi;
import com.tencent.mobileqq.ecshop.temp.api.IEcshopMessageApi;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.gamecenter.api.IGameMsgManagerService;
import com.tencent.mobileqq.gamecenter.message.RoleIdUtil;
import com.tencent.mobileqq.gamecenter.msgInfo.GameCenterSessionInfo;
import com.tencent.mobileqq.imaxad.ImaxAdRecentUserManager;
import com.tencent.mobileqq.kandian.biz.common.api.IPublicAccountReportUtils;
import com.tencent.mobileqq.kandian.biz.common.baseui.api.IReadInJoyLockScreenJumpDelegate;
import com.tencent.mobileqq.kandian.biz.daily.api.IKanDianDailyReportUtils;
import com.tencent.mobileqq.kandian.biz.daily.api.IKandianDailyManager;
import com.tencent.mobileqq.kandian.biz.daily.api.IKandianDailyManagerService;
import com.tencent.mobileqq.kandian.biz.feeds.api.IRIJKanDianFolderStatus;
import com.tencent.mobileqq.kandian.biz.feeds.entity.RedPntInfoForReport;
import com.tencent.mobileqq.kandian.biz.framework.api.IRIJTransMergeKanDianReport;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyActivityHelper;
import com.tencent.mobileqq.kandian.biz.framework.api.IReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.push.api.IKanDianMergeManager;
import com.tencent.mobileqq.kandian.biz.reddot.api.IKanDianSubscribeReportUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.api.IKandianSubscribeManager;
import com.tencent.mobileqq.kandian.glue.report.api.IReadInJoyReportUtils;
import com.tencent.mobileqq.kandian.repo.reddot.KandianMsgBoxRedPntInfo;
import com.tencent.mobileqq.loginwelcome.LoginUserGuideHelper;
import com.tencent.mobileqq.managers.TroopAssistantManager;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.nearby.api.IHotChatUtil;
import com.tencent.mobileqq.nearpeople.api.INearbyRecommenderUtils;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.now.NowQQLiveConstant;
import com.tencent.mobileqq.now.NowQQLiveHelper;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.profilecard.data.AllInOne;
import com.tencent.mobileqq.qqgamepub.api.IQQGameConfigUtil;
import com.tencent.mobileqq.qqgamepub.api.IQQGameHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.FightMsgReporter;
import com.tencent.mobileqq.statistics.QZoneReport;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.subaccount.api.ISubAccountAssistantForward;
import com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil;
import com.tencent.mobileqq.systemmsg.GroupSystemMsgController;
import com.tencent.mobileqq.troop.api.ILaunchTroopSysMsgUIUtilApi;
import com.tencent.mobileqq.troop.api.IRecommendTroopService;
import com.tencent.mobileqq.troop.navigatebar.TroopAioNavigateBarManager;
import com.tencent.mobileqq.troop.utils.RecommendTroopUtils;
import com.tencent.mobileqq.troop.utils.TroopNotifyHelper;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.utils.abtest.ABTestController;
import com.tencent.mobileqq.utils.abtest.ExpEntityInfo;
import com.tencent.mobileqq.vas.qvip.util.QQVipHelper;
import com.tencent.mobileqq.vashealth.api.IQQHealthApi;
import com.tencent.mobileqq.vashealth.api.IQQHealthService;
import com.tencent.mobileqq.weather.api.IWeatherCommApi;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.opt.suspendthread.SuspendThreadManager;
import com.tencent.qzonehub.api.contentbox.IQzoneMsgApi;
import common.config.service.QzoneConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x791.oidb_0x791.RedDotInfo;

public final class RecentUtil
{
  public static long a = 0L;
  public static MessageRecord a;
  public static boolean a = false;
  public static boolean b = false;
  public static boolean c = true;
  
  public static int a(Activity paramActivity, QQAppInterface paramQQAppInterface, RecentUser paramRecentUser, String paramString, boolean paramBoolean, int paramInt, RecentBaseData paramRecentBaseData)
  {
    return a(paramActivity, paramQQAppInterface, paramRecentUser, paramString, paramBoolean, paramInt, paramRecentBaseData, null, null);
  }
  
  public static int a(Activity paramActivity, QQAppInterface paramQQAppInterface, RecentUser paramRecentUser, String paramString, boolean paramBoolean, int paramInt, RecentBaseData paramRecentBaseData, Bundle paramBundle, Intent[] paramArrayOfIntent)
  {
    int k = 0;
    int j = 0;
    if ((paramRecentUser != null) && (paramActivity != null) && (paramQQAppInterface != null))
    {
      if (QLog.isDevelopLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onRecentUserClick|[");
        localStringBuilder.append(paramRecentUser.uin);
        localStringBuilder.append(",");
        localStringBuilder.append(paramRecentUser.getType());
        localStringBuilder.append("]");
        QLog.i("Q.recent", 4, localStringBuilder.toString());
      }
      boolean bool;
      if ((paramInt != 0) && (paramInt != 2)) {
        bool = false;
      } else {
        bool = true;
      }
      a(paramQQAppInterface, paramRecentUser, paramString, paramInt, paramRecentBaseData);
      int i = k;
      if (!a(paramActivity, paramQQAppInterface, paramRecentUser, paramInt, paramRecentBaseData)) {
        if (paramRecentUser.getType() == 8999)
        {
          i = k;
        }
        else if (paramRecentUser.getType() == 7000)
        {
          a(paramActivity, paramQQAppInterface, paramRecentUser, paramRecentBaseData);
          i = k;
        }
        else if ((paramRecentUser.getType() != 1000) && (paramRecentUser.getType() != 1020) && (paramRecentUser.getType() != 1004) && (paramRecentUser.getType() != 10010))
        {
          if ((paramRecentUser.getType() != 1005) && (paramRecentUser.getType() != 1023))
          {
            if (paramRecentUser.getType() == 1024)
            {
              paramBundle = a(paramBundle);
              i = 0x0 | a(paramActivity, paramQQAppInterface, paramRecentUser.uin, paramRecentUser.getType(), paramString, bool, paramBundle, paramArrayOfIntent);
            }
            else if (paramRecentUser.getType() == 6002)
            {
              paramString = (SmartDeviceProxyMgr)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
              paramString.a(paramActivity, paramString.a(Long.parseLong(paramRecentUser.uin)), false);
              i = k;
            }
            else if (paramRecentUser.getType() == 10005)
            {
              b(paramQQAppInterface, paramRecentUser.uin, 10005);
              paramQQAppInterface.getMessageFacade().a(paramRecentUser.uin, 10005, true, true);
              ImaxAdRecentUserManager.a().a(paramActivity, paramQQAppInterface, paramRecentUser.uin, paramRecentUser.getType());
              i = k;
            }
            else if (paramRecentUser.lFlag == 16L)
            {
              b(paramQQAppInterface, paramRecentUser.uin, 1008);
              paramQQAppInterface.getMessageFacade().a(paramRecentUser.uin, 1008, true, true);
              a(paramActivity, paramQQAppInterface, paramRecentUser.uin, paramRecentUser.getType());
              i = k;
            }
            else if (paramRecentUser.getType() == 6004)
            {
              a(paramActivity, paramQQAppInterface, paramRecentUser);
              i = k;
            }
            else if (paramRecentUser.getType() == 8114)
            {
              LoginUserGuideHelper.a(paramActivity, paramQQAppInterface);
              ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X8009F4C", "0X8009F4C", 0, 0, "", "", "", "");
              i = k;
            }
            else if ((paramRecentBaseData != null) && (paramRecentBaseData.getRecentUserType() == 10007))
            {
              paramString = ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).getLastGameMsg(paramQQAppInterface, paramRecentBaseData.getRecentUserUin());
              i = k;
              if (paramString != null)
              {
                ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).enterGameMsgChatPie(paramActivity, paramRecentBaseData.getRecentUserUin(), RoleIdUtil.b(paramString), RoleIdUtil.a(paramString));
                ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportClickItemInMsgBox(paramQQAppInterface, paramString, paramRecentBaseData.getRecentUserUin());
                i = k;
              }
            }
            else
            {
              if (a(paramQQAppInterface, paramRecentUser)) {
                return 4;
              }
              i = a(paramQQAppInterface, paramRecentUser, paramBoolean, 0) | a(paramActivity, paramQQAppInterface, paramRecentUser.uin, paramRecentUser.getType(), paramString, bool, paramBundle, paramArrayOfIntent);
            }
          }
          else
          {
            paramInt = j;
            if (a(paramQQAppInterface, paramRecentUser.uin))
            {
              paramRecentUser.setType(0);
              paramInt = j;
              if (paramBoolean) {
                paramInt = 2;
              }
            }
            paramBundle = a(paramBundle);
            i = paramInt | a(paramActivity, paramQQAppInterface, paramRecentUser.uin, paramRecentUser.getType(), paramString, bool, paramBundle, paramArrayOfIntent);
          }
        }
        else
        {
          i = a(paramActivity, paramQQAppInterface, paramRecentUser, paramString, paramBoolean, 0, bool, paramBundle, paramArrayOfIntent);
        }
      }
      a(paramQQAppInterface, paramRecentUser, paramRecentBaseData);
      return i;
    }
    if (QLog.isDevelopLevel())
    {
      paramString = new StringBuilder();
      paramString.append("onRecentUserClick|[");
      paramString.append(paramRecentUser);
      paramString.append(",");
      paramString.append(paramActivity);
      paramString.append(",");
      paramString.append(paramQQAppInterface);
      paramString.append("]");
      QLog.i("Q.recent", 4, paramString.toString());
    }
    return 0;
  }
  
  private static int a(Activity paramActivity, QQAppInterface paramQQAppInterface, RecentUser paramRecentUser, String paramString, boolean paramBoolean1, int paramInt, boolean paramBoolean2, Bundle paramBundle, Intent[] paramArrayOfIntent)
  {
    if (a(paramQQAppInterface, paramRecentUser.uin))
    {
      paramRecentUser.setType(0);
      if (paramBoolean1) {
        paramInt = 2;
      }
      if ((paramBundle == null) || (!paramBundle.getBoolean("enter_from_temp_msg_box", false))) {
        paramBundle = null;
      }
      int i = a(paramActivity, paramQQAppInterface, String.valueOf(paramRecentUser.uin), paramRecentUser.getType(), paramString, paramBoolean2, paramBundle, paramArrayOfIntent) | paramInt;
      paramInt = i;
      if (QLog.isColorLevel())
      {
        QLog.i("Q.recent", 2, "from_enterchat");
        return i;
      }
    }
    else
    {
      if ((paramRecentUser.troopUin == null) || (paramRecentUser.troopUin.trim().length() == 0))
      {
        paramQQAppInterface = paramQQAppInterface.getProxyManager().a().b(paramRecentUser.uin, 1);
        if (paramQQAppInterface != null) {
          paramRecentUser.troopUin = paramQQAppInterface.troopUin;
        }
      }
      a(paramActivity, paramRecentUser.uin, paramRecentUser.troopUin, paramRecentUser.getType(), paramString, paramBoolean2, paramBundle, paramArrayOfIntent);
    }
    return paramInt;
  }
  
  public static int a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    return a(paramContext, paramQQAppInterface, paramString1, paramInt, paramString2, paramBoolean, null, null);
  }
  
  public static int a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2, boolean paramBoolean, Bundle paramBundle)
  {
    return a(paramContext, paramQQAppInterface, paramString1, paramInt, paramString2, paramBoolean, paramBundle, null);
  }
  
  public static int a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2, boolean paramBoolean, Bundle paramBundle, Intent[] paramArrayOfIntent)
  {
    StartupTracker.a(null, "Recent_clk_enterchat");
    SuspendThreadManager.a().c();
    Intent localIntent = new Intent();
    boolean bool = false;
    if ((paramArrayOfIntent != null) && (paramArrayOfIntent.length != 0)) {
      paramArrayOfIntent[0] = localIntent;
    }
    paramBundle = a(paramContext, paramBundle, localIntent);
    int i = 1;
    if ((paramInt != 0) && (paramInt != 1024))
    {
      if (paramInt == 1)
      {
        StartupTracker.a(null, "Recent_clk_enterchat_troop");
        if (a(paramQQAppInterface, paramString1, 0, paramBundle)) {
          return 0;
        }
        StartupTracker.a("Recent_clk_enterchat_troop", null);
        break label233;
      }
      if (paramInt == 1008)
      {
        StartupTracker.a(null, "Recent_clk_enterchat_pub");
        if (a(paramContext, paramQQAppInterface, paramString1, 0, paramBundle)) {
          return 0;
        }
        StartupTracker.a("Recent_clk_enterchat_pub", null);
        paramBoolean = bool;
      }
      else
      {
        if (paramInt != 9501) {
          break label186;
        }
        paramBoolean = a(paramContext, paramQQAppInterface, paramString1, paramString2, paramBundle);
      }
      break label230;
    }
    else
    {
      if ((paramInt == 1024) || (CrmUtils.a(paramQQAppInterface, paramString1))) {
        break label189;
      }
    }
    label186:
    break label230;
    label189:
    StartupTracker.a(null, "Recent_clk_enterchat_cmr");
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "Biz_card", "Biz_card_talk", 0, 0, paramString1, "0", "", "");
    StartupTracker.a("Recent_clk_enterchat_cmr", null);
    label230:
    i = 0;
    label233:
    paramBundle.putExtra("uin", paramString1);
    paramBundle.putExtra("uintype", paramInt);
    paramBundle.putExtra("uinname", paramString2);
    paramBundle.putExtra("entrance", 1);
    a(paramBundle);
    if (paramBoolean) {
      a(paramContext, paramBundle);
    } else {
      paramContext.startActivity(paramBundle);
    }
    StartupTracker.a("Recent_clk_enterchat", null);
    return i;
  }
  
  private static int a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser, boolean paramBoolean, int paramInt)
  {
    int i = paramInt;
    if (a(paramQQAppInterface, paramRecentUser.uin))
    {
      i = paramInt;
      if (1 != paramRecentUser.getType())
      {
        i = paramInt;
        if (3000 != paramRecentUser.getType())
        {
          i = paramInt;
          if (paramRecentUser.getType() != 0)
          {
            paramRecentUser.setType(0);
            i = paramInt;
            if (paramBoolean) {
              i = 2;
            }
          }
        }
      }
    }
    return i;
  }
  
  @NotNull
  private static Intent a(Context paramContext)
  {
    if ((paramContext instanceof PublicFragmentActivity))
    {
      PublicBaseFragment localPublicBaseFragment = ((PublicFragmentActivity)paramContext).a();
      if ((!(localPublicBaseFragment instanceof TempMsgBoxFragment)) && (!(localPublicBaseFragment instanceof FilterMsgBoxFragment))) {
        return new Intent(paramContext, SplashActivity.class);
      }
      return new Intent(paramContext, ChatActivity.class);
    }
    return new Intent(paramContext, SplashActivity.class);
  }
  
  @NotNull
  private static Intent a(Context paramContext, Bundle paramBundle, Intent paramIntent)
  {
    if (jdField_a_of_type_Boolean)
    {
      paramIntent.setClassName(paramContext, ChatActivity.class.getName());
      paramContext = jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
      long l;
      if (paramContext != null)
      {
        if ((paramContext.istroop != 1) && (jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop != 3000)) {
          l = jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time;
        } else {
          l = jdField_a_of_type_ComTencentMobileqqDataMessageRecord.shmsgseq;
        }
        paramIntent.putExtra("searched_timeorseq", l);
        paramContext = paramIntent;
      }
      else
      {
        l = jdField_a_of_type_Long;
        paramContext = paramIntent;
        if (l != 0L)
        {
          paramIntent.putExtra("searched_timeorseq", l);
          paramContext = paramIntent;
        }
      }
    }
    else
    {
      Object localObject2 = null;
      if (paramBundle != null) {
        localObject2 = paramBundle.getString("KEY_OPEN_AIO_INTENT_CLASS_NAME");
      }
      Object localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2)) {
        localObject1 = SplashActivity.class.getName();
      }
      localObject2 = localObject1;
      if ((paramContext instanceof PublicFragmentActivity))
      {
        PublicBaseFragment localPublicBaseFragment = ((PublicFragmentActivity)paramContext).a();
        if (!(localPublicBaseFragment instanceof TempMsgBoxFragment))
        {
          localObject2 = localObject1;
          if (!(localPublicBaseFragment instanceof FilterMsgBoxFragment)) {}
        }
        else
        {
          localObject2 = ChatActivity.class.getName();
        }
      }
      paramIntent.setClassName(paramContext, (String)localObject2);
      paramContext = AIOUtils.a(paramIntent, new int[] { 1 });
    }
    if (paramBundle != null) {
      paramContext.putExtras(paramBundle);
    }
    return paramContext;
  }
  
  @Nullable
  private static Bundle a(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      localBundle = paramBundle;
      if (paramBundle.getBoolean("enter_from_temp_msg_box", false)) {
        return localBundle;
      }
      if (paramBundle.getBoolean("KEY_MULTI_WINDOW_AIO_BLOCK_JUMP_BOTTOM", false)) {
        return paramBundle;
      }
    }
    Bundle localBundle = null;
    return localBundle;
  }
  
  private static void a(Activity paramActivity, int paramInt)
  {
    Intent localIntent = new Intent(paramActivity, ActivateFriendActivity.class);
    localIntent.setFlags(67108864);
    if (paramInt == 0) {
      paramInt = 1;
    } else {
      paramInt = 3;
    }
    localIntent.putExtra("af_key_from", paramInt);
    paramActivity.startActivity(localIntent);
  }
  
  private static void a(Activity paramActivity, RecentBaseData paramRecentBaseData)
  {
    if ((paramRecentBaseData instanceof RecentItemNoticeData))
    {
      paramRecentBaseData = ((RecentItemNoticeData)paramRecentBaseData).intent;
      if (paramRecentBaseData != null) {
        paramActivity.startActivity(paramRecentBaseData);
      }
    }
  }
  
  private static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    oidb_0x791.RedDotInfo localRedDotInfo = ((TroopRedTouchManager)paramQQAppInterface.getManager(QQManagerFactory.MGR_RED_TOUCH_EX)).a(46, false);
    int i;
    if ((localRedDotInfo != null) && (localRedDotInfo.uint32_number.has())) {
      i = localRedDotInfo.uint32_number.get();
    } else {
      i = 0;
    }
    Object localObject3 = null;
    if ((localRedDotInfo != null) && (!localRedDotInfo.bool_display_reddot.get())) {}
    for (;;)
    {
      try
      {
        if (!localRedDotInfo.str_custom_buffer.has()) {
          break label438;
        }
        Object localObject1 = localRedDotInfo.str_custom_buffer.get().toStringUtf8();
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          localObject1 = new JSONObject((String)localObject1);
        } else {
          localObject1 = new JSONObject();
        }
        if (localRedDotInfo.uint32_last_time.has()) {
          ((JSONObject)localObject1).put("lastTime", localRedDotInfo.uint32_last_time.get());
        }
        ((JSONObject)localObject1).put("lastMsg", ((JSONObject)localObject1).get("msg"));
        localObject1 = ((JSONObject)localObject1).toString();
        localRedDotInfo.str_custom_buffer.set(ByteStringMicro.copyFromUtf8((String)localObject1));
        TroopRedTouchHandler.a(paramQQAppInterface, localRedDotInfo, 0, true);
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      Object localObject2 = localObject3;
      if (i > 0)
      {
        a(paramQQAppInterface, paramRecentUser, true, true);
        i = paramQQAppInterface.getMessageFacade().b();
        localObject2 = HardCodeUtil.a(2131713148);
        if (i > 0) {
          if (i > 99)
          {
            paramRecentUser = new StringBuilder();
            paramRecentUser.append((String)localObject2);
            paramRecentUser.append("(99+)");
            localObject2 = paramRecentUser.toString();
          }
          else
          {
            paramRecentUser = new StringBuilder();
            paramRecentUser.append((String)localObject2);
            paramRecentUser.append("(");
            paramRecentUser.append(i);
            paramRecentUser.append(")");
            localObject2 = paramRecentUser.toString();
          }
        }
      }
      paramRecentUser = new Intent(paramActivity, QQBrowserActivity.class);
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        paramRecentUser.putExtra("selfSet_leftViewText", (String)localObject2);
      }
      paramRecentUser.putExtra("is_wrap_content", true);
      paramRecentUser.putExtra("url", "https://docs.qq.com/components/Notifications.html?_wv=3");
      paramRecentUser.putExtra("hide_more_button", true);
      paramRecentUser.putExtra("webStyle", "noBottomBar");
      paramRecentUser.putExtra("isScreenOrientationPortrait", true);
      paramRecentUser.putExtra("title", paramQQAppInterface.getApp().getString(2131719599));
      paramRecentUser.addFlags(603979776);
      paramActivity.startActivity(paramRecentUser);
      return;
      label438:
      localObject2 = null;
    }
  }
  
  private static void a(Activity paramActivity, QQAppInterface paramQQAppInterface, RecentUser paramRecentUser, RecentBaseData paramRecentBaseData)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("RecentUtil.onRecentUserClick. r.uin=");
      ((StringBuilder)localObject).append(paramRecentUser.uin);
      ((StringBuilder)localObject).append(" r.type=");
      ((StringBuilder)localObject).append(paramRecentUser.getType());
      QLog.d("SUB_ACCOUNT", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = paramRecentUser.uin;
    if ((paramRecentBaseData instanceof RecentItemSubAccount)) {
      localObject = ((RecentItemSubAccount)paramRecentBaseData).showSubUin;
    }
    ISubAccountAssistantForward localISubAccountAssistantForward = (ISubAccountAssistantForward)QRoute.api(ISubAccountAssistantForward.class);
    paramRecentBaseData = (RecentBaseData)localObject;
    if (localObject == null) {
      paramRecentBaseData = "";
    }
    localISubAccountAssistantForward.forwardTo(paramQQAppInterface, paramActivity, paramRecentBaseData);
    paramQQAppInterface.getMessageFacade().a(paramRecentUser.uin, paramRecentUser.getType());
    if (AppConstants.SUBACCOUNT_ASSISTANT_UIN.equals(paramRecentUser.uin)) {
      paramActivity = null;
    } else {
      paramActivity = paramRecentUser.uin;
    }
    ReportController.b(paramQQAppInterface, "CliOper", "", paramActivity, "Bind_account", "Clk_bind_account", 0, 0, "", "", "", "");
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800713E", "0X800713E", 0, 0, "", "", "", "");
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
      paramContext.openAIO(false, 1);
      return;
    }
    if (paramIntent.getBooleanExtra("KEY_MULTI_WINDOW_AIO_BLOCK_JUMP_BOTTOM", false)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.aio.SpalshActivity", 2, "start->SpalshActivity-->AIO");
    }
    paramContext.startActivity(paramIntent);
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (paramContext == null) {
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      if (QLog.isColorLevel()) {
        QLog.d("RecentUtil", 2, "openAdvertisement empty uin!");
      }
      return;
    }
    AdvertisementRecentUserManager localAdvertisementRecentUserManager = AdvertisementRecentUserManager.a();
    Object localObject = localAdvertisementRecentUserManager.a(paramString);
    if (localObject != null)
    {
      a(paramContext, paramQQAppInterface, paramString, paramInt, (AdvertisementItem)localObject);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("openAdvertisement item recreate, uin:");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("RecentUtil", 2, ((StringBuilder)localObject).toString());
    }
    localObject = paramQQAppInterface.getMessageFacade().a(paramString, paramInt).iterator();
    while (((Iterator)localObject).hasNext())
    {
      AdvertisementItem localAdvertisementItem = PublicAccountAdUtil.a(paramQQAppInterface, (MessageRecord)((Iterator)localObject).next(), true);
      if (localAdvertisementItem != null)
      {
        localAdvertisementRecentUserManager.a(localAdvertisementItem);
        a(paramContext, paramQQAppInterface, paramString, paramInt, localAdvertisementItem);
      }
    }
  }
  
  private static void a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, int paramInt, AdvertisementItem paramAdvertisementItem)
  {
    Intent localIntent = new Intent(paramContext, PublicAccountAdvertisementActivity.class);
    localIntent.putExtra("arg_ad_json", paramAdvertisementItem.a());
    localIntent.putExtra("USR_CLICK_TIME", SystemClock.uptimeMillis());
    localIntent.putExtra("is_first_open_imax_ad", c);
    c = false;
    paramContext.startActivity(localIntent);
    ThreadManager.post(new RecentUtil.7(paramQQAppInterface, paramString, paramInt, paramAdvertisementItem), 5, null, false);
    AdvertisementRecentUserManager.a().a(paramQQAppInterface, 2, paramAdvertisementItem);
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("openAdvertisement start, uin:");
      paramContext.append(paramString);
      QLog.d("RecentUtil", 2, paramContext.toString());
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, int paramInt, String paramString3, boolean paramBoolean, Bundle paramBundle, Intent[] paramArrayOfIntent)
  {
    if (paramContext != null)
    {
      Intent localIntent1;
      if (jdField_a_of_type_Boolean)
      {
        Intent localIntent2 = new Intent(paramContext, ChatActivity.class);
        MessageRecord localMessageRecord = jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
        localIntent1 = localIntent2;
        if (localMessageRecord != null)
        {
          long l;
          if ((localMessageRecord.istroop != 1) && (jdField_a_of_type_ComTencentMobileqqDataMessageRecord.istroop != 3000)) {
            l = jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time;
          } else {
            l = jdField_a_of_type_ComTencentMobileqqDataMessageRecord.shmsgseq;
          }
          localIntent2.putExtra("searched_timeorseq", l);
          localIntent1 = localIntent2;
        }
      }
      else
      {
        localIntent1 = AIOUtils.a(a(paramContext), new int[] { 1 });
      }
      if ((paramArrayOfIntent != null) && (paramArrayOfIntent.length != 0)) {
        paramArrayOfIntent[0] = localIntent1;
      }
      if ((paramBundle != null) && (paramBundle.getBoolean("enter_from_temp_msg_box", false))) {
        localIntent1.putExtras(paramBundle);
      }
      localIntent1.putExtra("uin", paramString1);
      localIntent1.putExtra("troop_uin", paramString2);
      localIntent1.putExtra("uintype", paramInt);
      localIntent1.putExtra("uinname", paramString3);
      a(localIntent1);
      if (paramBoolean)
      {
        if ((paramContext instanceof SplashActivity)) {
          a(paramContext, localIntent1);
        }
      }
      else {
        paramContext.startActivity(localIntent1);
      }
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
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    Iterator localIterator = ((ITempMsgBoxManager)paramQQAppInterface.getRuntimeService(ITempMsgBoxManager.class, "")).getMsgBoxRecentUsers().iterator();
    while (localIterator.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)localIterator.next();
      if (localRecentUser.getType() == 10012)
      {
        b(paramQQAppInterface);
      }
      else
      {
        b(paramQQAppInterface, localRecentUser.uin, localRecentUser.type);
        paramQQAppInterface.getMessageFacade().a(localRecentUser.uin, localRecentUser.type);
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    Intent localIntent = new Intent();
    localIntent.setFlags(67108864);
    PublicFragmentActivity.a(paramActivity, localIntent, FilterMsgBoxFragment.class);
    ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800B1C0", "0X800B1C0", 10000, 0, "", "", "", "");
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, RecentBaseData paramRecentBaseData)
  {
    Intent localIntent = new Intent(paramActivity, EcshopWebActivity.class);
    localIntent.putExtra("start_time", System.currentTimeMillis());
    localIntent.setFlags(67108864);
    ReportController.b(paramQQAppInterface, "P_CliOper", "Shop_lifeservice", "", "Msglist", "Clk_ShopHelper", 0, 0, "", "", "", "");
    EcShopAssistantManager localEcShopAssistantManager = (EcShopAssistantManager)paramQQAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
    String str = QzoneConfig.getInstance().getConfig("qqminiapp", "miniappecshopurl", "");
    if (localEcShopAssistantManager != null)
    {
      Object localObject = localEcShopAssistantManager.a();
      int i;
      if (localObject == null) {
        i = 0;
      } else {
        i = ((List)localObject).size();
      }
      if (i == 0) {
        ReportController.b(paramQQAppInterface, "P_CliOper", "Shop_lifeservice", "", "Shop_noMsglist", "Clk_ShopHelper", 0, 0, "", "", "", "");
      }
      int j = localEcShopAssistantManager.a(paramQQAppInterface);
      if (j > 0) {
        j = 1;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("");
      ((StringBuilder)localObject).append(j);
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(i);
      ReportController.b(paramQQAppInterface, "dc00899", "Pb_account_lifeservice", "1", "0X80064CB", "0X80064CB", 0, 0, (String)localObject, localStringBuilder.toString(), "", "");
      boolean bool;
      if (j != 0) {
        bool = true;
      } else {
        bool = false;
      }
      localIntent.putExtra("has_red_hot", bool);
      if (paramRecentBaseData == null) {
        i = -1;
      } else {
        i = paramRecentBaseData.mUnreadNum;
      }
      localEcShopAssistantManager.a(localIntent, paramActivity, i);
      if (!TextUtils.isEmpty(str)) {
        localEcShopAssistantManager.b(paramQQAppInterface);
      }
    }
    if (TextUtils.isEmpty(str))
    {
      paramActivity.startActivity(localIntent);
      return;
    }
    if (((IMiniAppService)QRoute.api(IMiniAppService.class)).isMiniAppUrl(str))
    {
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(paramActivity, str, 4003, null);
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).report4239Async("shopping_folder", "click", "message", String.valueOf(paramRecentBaseData.mUnreadNum), null, null);
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, RecentUser paramRecentUser)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("key_tab_mode", 2);
    int i = GroupSystemMsgController.a().a(paramQQAppInterface);
    Object localObject;
    if (i > 0)
    {
      paramActivity = "0";
      localObject = paramActivity;
    }
    else
    {
      i = RecommendTroopUtils.b(paramQQAppInterface);
      if (i > 0)
      {
        localObject = "1";
        paramActivity = "0";
      }
      else
      {
        paramActivity = "1";
        localObject = "0";
      }
    }
    paramQQAppInterface.getConversationFacade().d(AppConstants.TROOP_NOTIFICATION_UIN, 9000, -i);
    ReportController.b(null, "dc00898", "", "", "0X800B527", "0X800B527", 0, 0, "", "", null, null);
    if (i > 0) {
      ReportController.b(null, "dc00898", "", "", "0X800B529", "0X800B529", 0, 0, "", "", null, null);
    }
    boolean bool2 = TroopNotifyHelper.a();
    boolean bool1 = true;
    if (bool2)
    {
      TroopNotifyHelper.a(false);
      TroopNotifyHelper.a();
      localIntent.putExtra("show_type", true);
      ReportController.b(null, "dc00898", "", "", "0X800B52D", "0X800B52D", 0, 0, "", "", null, null);
    }
    localIntent.putExtra("_key_mode", paramRecentUser.jumpTabMode);
    localIntent.putExtra("key_from", 2);
    if (i <= 0) {
      bool1 = false;
    }
    localIntent.putExtra("has_red", bool1);
    ((ILaunchTroopSysMsgUIUtilApi)QRoute.api(ILaunchTroopSysMsgUIUtilApi.class)).launchTroopNotificationFragment(localIntent);
    ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_contacts", "", "notice", "Clk_notice", 0, 0, "", paramActivity, (String)localObject, "");
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, RecentUser paramRecentUser, int paramInt)
  {
    paramRecentUser = paramQQAppInterface.getMessageFacade().b(paramRecentUser.uin, paramRecentUser.getType());
    if (paramInt == 1)
    {
      paramQQAppInterface = (IKandianDailyManagerService)paramQQAppInterface.getRuntimeService(IKandianDailyManagerService.class);
      ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).reportForLockScreenEnter(paramQQAppInterface.getRedPntInfoFromMsg());
      paramActivity.startActivity(((IReadInJoyLockScreenJumpDelegate)QRoute.api(IReadInJoyLockScreenJumpDelegate.class)).getJumpDailyFragmentIntent(paramActivity, 9, paramQQAppInterface.getAndRemoveLockScreenRedDodInfo()));
      return;
    }
    if (paramRecentUser != null)
    {
      ((IKanDianDailyReportUtils)QRoute.api(IKanDianDailyReportUtils.class)).reportForClick(paramRecentUser);
      ((IKandianDailyManager)QRoute.api(IKandianDailyManager.class)).launchKandianDaily(paramActivity);
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, RecentUser paramRecentUser, int paramInt, RecentBaseData paramRecentBaseData)
  {
    ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).onRecentConversationPublicAccountFolderClick(paramQQAppInterface, paramActivity, paramRecentUser, paramInt, paramRecentBaseData);
    PublicTracker.a(null, "SERVICE_FOLDER_COST");
  }
  
  private static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, RecentUser paramRecentUser, RecentBaseData paramRecentBaseData)
  {
    paramRecentUser = paramQQAppInterface.getMessageFacade().b(paramRecentUser.uin, paramRecentUser.getType());
    if (paramRecentUser != null) {
      ((IKanDianSubscribeReportUtils)QRoute.api(IKanDianSubscribeReportUtils.class)).reportKanDianSubscribeClick(paramRecentUser);
    }
    paramQQAppInterface = (IKandianSubscribeManager)paramQQAppInterface.getRuntimeService(IKandianSubscribeManager.class);
    int i;
    if (paramRecentBaseData.mUnreadNum > 0) {
      i = 1;
    } else {
      i = 3;
    }
    paramQQAppInterface.lanuchKandianSubscribeActivity(paramActivity, i);
  }
  
  private static void a(QQAppInterface paramQQAppInterface, RecentBaseData paramRecentBaseData)
  {
    int i;
    if ((paramRecentBaseData instanceof RecentItemChatMsgData)) {
      i = RecentReportHelper.a.get(0);
    }
    for (;;)
    {
      break;
      if ((paramRecentBaseData instanceof RecentItemTroopMsgData))
      {
        i = RecentReportHelper.a.get(1);
      }
      else
      {
        if (!(paramRecentBaseData instanceof RecentItemDiscussionMsgData)) {
          return;
        }
        i = RecentReportHelper.a.get(3000);
      }
    }
    int j = paramRecentBaseData.mUnreadFlag;
    if (j != 0) {
      if (j != 1) {
        if (j != 2) {
          if (j != 3) {
            paramRecentBaseData = "6";
          }
        }
      }
    }
    for (;;)
    {
      break;
      if (ABTestController.a().a("exp_qq_message_reminder_dnd").a())
      {
        paramRecentBaseData = "4";
      }
      else
      {
        paramRecentBaseData = "3";
        continue;
        paramRecentBaseData = "2";
        continue;
        paramRecentBaseData = "1";
        continue;
        paramRecentBaseData = "5";
      }
    }
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800BB64", "0X800BB64", 0, i, paramRecentBaseData, "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    if (paramRecentUser.getType() != 5000)
    {
      do
      {
        while ((paramRecentUser.getType() != 7200) && (paramRecentUser.getType() != 1008)) {
          if (String.valueOf(9992L).equals(paramRecentUser.uin))
          {
            ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800419F", "0X800419F", 0, 0, "", "", "", "");
          }
          else if (((paramRecentUser.getType() == 1001) || (paramRecentUser.getType() == 10002)) && (AppConstants.LBS_HELLO_UIN.equals(paramRecentUser.uin)))
          {
            ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80041A2", "0X80041A2", 0, 0, "", "", "", "");
            ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80050FD", "0X80050FD", 0, 0, "", "", "", "");
            ReportController.b(paramQQAppInterface, "dc00899", "grp_lbs", "", "msg_box", "drag_msg", 0, 0, "", "", "", "");
          }
          else
          {
            if ((paramRecentUser.getType() == 1010) && (AppConstants.DATE_UIN.equals(paramRecentUser.uin)))
            {
              ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80050FF", "0X80050FF", 0, 0, "", "", "", "");
              continue;
            }
            if ((paramRecentUser.getType() != 1009) || (!AppConstants.SAME_STATE_BOX_UIN.equals(paramRecentUser.uin))) {
              continue;
            }
            ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80041A4", "0X80041A4", 0, 0, "", "", "", "");
          }
        }
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80041A1", "0X80041A1", 0, 0, "", "", "", "");
      } while (paramRecentUser.getType() != 1008);
      a(paramQQAppInterface, paramRecentUser.uin, 1);
    }
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800419C", "0X800419C", 0, 0, "", "", "", "");
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80041A0", "0X80041A0", 0, 0, "", "", "", "");
  }
  
  public static void a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser, int paramInt)
  {
    if (paramQQAppInterface != null)
    {
      if (paramRecentUser == null) {
        return;
      }
      paramQQAppInterface.getProxyManager().a().a(paramRecentUser, false);
      if (UinTypeUtil.a(paramRecentUser.uin, paramRecentUser.getType()))
      {
        if ((!AppConstants.DATE_UIN.equals(paramRecentUser.uin)) && (!AppConstants.LBS_HELLO_UIN.equals(paramRecentUser.uin)))
        {
          if ((1032 == paramRecentUser.getType()) && (AppConstants.CONFESS_UIN.equals(paramRecentUser.uin)))
          {
            paramQQAppInterface.getConversationFacade().b();
            ConfessMsgUtil.b(paramQQAppInterface, false);
            ConfessMsgUtil.a(paramQQAppInterface, false);
          }
        }
        else
        {
          localObject = paramQQAppInterface.getMessageFacade().getLastMessage(paramRecentUser.uin, paramRecentUser.getType());
          if (localObject != null) {
            paramQQAppInterface.getConversationFacade().a(paramRecentUser.getType(), ((Message)localObject).time);
          }
        }
        Object localObject = paramRecentUser.uin;
        int i = paramRecentUser.getType();
        ThreadManager.post(new RecentUtil.3((MessageHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER), (String)localObject, i), 8, null, false);
      }
      else
      {
        b(paramQQAppInterface, paramRecentUser.uin, paramRecentUser.getType());
      }
      paramQQAppInterface.getMessageFacade().a(paramRecentUser.uin, paramRecentUser.getType(), true, true);
      b(paramQQAppInterface, paramRecentUser, paramInt);
      d(paramQQAppInterface, paramRecentUser);
      c(paramQQAppInterface, paramRecentUser);
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser, RecentBaseData paramRecentBaseData)
  {
    int i = paramRecentUser.msgType;
    String str1 = "";
    Object localObject;
    if (i == 17)
    {
      localObject = (TroopAioNavigateBarManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_AIO_NAVIGATE_BAR);
      long l;
      if (paramRecentUser.uin != null) {
        l = ((TroopAioNavigateBarManager)localObject).a(paramRecentUser.uin);
      } else {
        l = 0L;
      }
      localObject = null;
      if (l != 0L) {
        localObject = paramQQAppInterface.getMessageFacade().d(paramRecentUser.uin, paramRecentUser.getType(), l);
      }
      if (MessageForQQWalletMsg.isRedPacketMsg((MessageRecord)localObject)) {
        ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Clk_hongbaoSign", 0, 0, paramRecentUser.uin, "", "", "");
      } else {
        ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Clk_sfsign", 0, 0, paramRecentUser.uin, "", "", "");
      }
      ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Clk_sfsign", 0, 0, paramRecentUser.uin, "", "", "");
      localObject = ".troop.special_msg.special_attention";
    }
    else
    {
      if (paramRecentUser.msgType != 24) {
        break label236;
      }
      ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Clk_atsign", 0, 0, paramRecentUser.uin, "", "", "");
      localObject = ".troop.special_msg.at_msg";
    }
    for (;;)
    {
      break;
      label236:
      if (paramRecentUser.msgType == 22)
      {
        i = paramQQAppInterface.getTroopMask(paramRecentUser.uin);
        if (paramRecentUser.getType() == 3000) {
          localObject = "Grp_Dis_replyMsg";
        } else {
          localObject = "Grp_replyMsg";
        }
        String str2 = paramRecentUser.uin;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(i);
        ReportController.b(paramQQAppInterface, "P_CliOper", (String)localObject, "", "Msglist", "Clk_replySign", 0, 0, str2, localStringBuilder.toString(), "", "");
        localObject = str1;
      }
      else
      {
        localObject = str1;
        if (paramRecentUser.msgType == 16)
        {
          ReportController.b(null, "dc00898", "", paramRecentUser.uin, "qq_vip", "0X800A907", 0, 1, 0, "", "", "", "");
          localObject = str1;
        }
      }
    }
    a(paramQQAppInterface, paramRecentBaseData);
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (QLog.isColorLevel()))
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append(RecentUtil.class.getSimpleName());
      paramQQAppInterface.append((String)localObject);
      paramQQAppInterface = paramQQAppInterface.toString();
      paramRecentBaseData = new StringBuilder();
      paramRecentBaseData.append("onRecentUserClick, r.uin:");
      paramRecentBaseData.append(paramRecentUser.uin);
      QLog.d(paramQQAppInterface, 2, paramRecentBaseData.toString());
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser, String paramString, int paramInt, RecentBaseData paramRecentBaseData)
  {
    if ((paramRecentBaseData != null) && (paramInt == 0) && (paramRecentUser.uin != null) && ((paramRecentUser.getType() == 1008) || (paramRecentUser.getType() == 7220)))
    {
      RecentPubAccHelper.a(paramQQAppInterface, paramRecentUser.uin, paramRecentBaseData.mUnreadFlag, paramRecentBaseData.getUnreadNum(), 1, paramString);
      if ((paramRecentUser.getType() == 7220) || (AppConstants.KANDIAN_MERGE_UIN.equalsIgnoreCase(paramRecentBaseData.getRecentUserUin())) || (AppConstants.WEISHI_UIN.equalsIgnoreCase(paramRecentBaseData.getRecentUserUin())) || ("2290230341".equalsIgnoreCase(paramRecentBaseData.getRecentUserUin()))) {
        RecentPubAccHelper.a.add(new RecentPubAccHelper.PublicAccEnterDetail(paramRecentUser.uin, paramString, System.currentTimeMillis()));
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser, boolean paramBoolean)
  {
    if (paramRecentUser.getType() == 5000)
    {
      h(paramQQAppInterface);
      return;
    }
    if (5001 == paramRecentUser.getType())
    {
      g(paramQQAppInterface);
      return;
    }
    if (AppConstants.RECOMMEND_CONTACT_UIN.equals(paramRecentUser.uin))
    {
      ((INewFriendService)paramQQAppInterface.getRuntimeService(INewFriendService.class)).markAllDataReaded();
      return;
    }
    if (String.valueOf(9980L).equals(paramRecentUser.uin))
    {
      paramQQAppInterface.getMsgHandler().a().c();
      GroupSystemMsgController.a().a(paramQQAppInterface, 0);
      paramQQAppInterface = (IRecommendTroopService)paramQQAppInterface.getRuntimeService(IRecommendTroopService.class, "");
      if (paramQQAppInterface != null) {
        paramQQAppInterface.sendReadConfirm();
      }
    }
    else
    {
      if (paramRecentUser.getType() == 7210)
      {
        e(paramQQAppInterface);
        return;
      }
      if (paramRecentUser.getType() == 7120)
      {
        f(paramQQAppInterface);
        return;
      }
      if (paramRecentUser.getType() == 7220)
      {
        ((IKanDianMergeManager)paramQQAppInterface.getRuntimeService(IKanDianMergeManager.class)).cleanKanDianMergeSummary();
        return;
      }
      if (1001 == paramRecentUser.getType())
      {
        paramQQAppInterface.getInterFollowMgr().clearMsgBoxUnreadCount();
        return;
      }
      if (paramRecentUser.lFlag == 16L)
      {
        a(paramQQAppInterface, paramRecentUser, paramBoolean, 1008);
        return;
      }
      if (paramRecentUser.getType() == 10005)
      {
        a(paramQQAppInterface, paramRecentUser, paramBoolean, 10005);
        return;
      }
      if (paramRecentUser.getType() == 6004)
      {
        c(paramQQAppInterface);
        return;
      }
      if ("2747277822".equals(paramRecentUser.uin))
      {
        d(paramQQAppInterface);
        return;
      }
      if (QFileAssistantUtils.a(paramRecentUser.uin))
      {
        ((DataLineHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER)).g();
        return;
      }
      if (TextUtils.equals(AppConstants.TEMP_MSG_BOX_UIN, paramRecentUser.uin)) {
        a(paramQQAppInterface, paramBoolean);
      }
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser, boolean paramBoolean, int paramInt)
  {
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.jdField_a_of_type_Int = paramInt;
    paramRecentUser = paramRecentUser.uin;
    localSessionInfo.b = paramRecentUser;
    localSessionInfo.jdField_a_of_type_JavaLangString = paramRecentUser;
    ChatActivityFacade.a(paramQQAppInterface, localSessionInfo);
    paramQQAppInterface.getMessageFacade().a(localSessionInfo.jdField_a_of_type_JavaLangString, 1008, true, paramBoolean);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramQQAppInterface != null)
    {
      if (paramRecentUser == null) {
        return;
      }
      b(paramQQAppInterface, paramRecentUser);
      Object localObject;
      if (UinTypeUtil.a(paramRecentUser.uin, paramRecentUser.getType()))
      {
        if ((!AppConstants.DATE_UIN.equals(paramRecentUser.uin)) && (!AppConstants.LBS_HELLO_UIN.equals(paramRecentUser.uin)))
        {
          if ((1032 == paramRecentUser.getType()) && (AppConstants.CONFESS_UIN.equals(paramRecentUser.uin)))
          {
            paramQQAppInterface.getConversationFacade().b();
            ConfessMsgUtil.b(paramQQAppInterface, false);
            ConfessMsgUtil.a(paramQQAppInterface, false);
          }
        }
        else
        {
          localObject = paramQQAppInterface.getMessageFacade().getLastMessage(paramRecentUser.uin, paramRecentUser.getType());
          if (localObject != null) {
            paramQQAppInterface.getConversationFacade().a(paramRecentUser.getType(), ((Message)localObject).time);
          }
        }
        localObject = paramRecentUser.uin;
        int i = paramRecentUser.getType();
        paramQQAppInterface.getMessageFacade().b((String)localObject, i);
        ThreadManager.post(new RecentUtil.2((MessageHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER), (String)localObject, i), 8, null, false);
      }
      else
      {
        if (paramBoolean1)
        {
          localObject = new SessionInfo();
          ((SessionInfo)localObject).jdField_a_of_type_JavaLangString = paramRecentUser.uin;
          ((SessionInfo)localObject).b = paramRecentUser.uin;
          ((SessionInfo)localObject).jdField_a_of_type_Int = paramRecentUser.getType();
          if (((SessionInfo)localObject).jdField_a_of_type_Int == 1006) {
            ((SessionInfo)localObject).f = ContactUtils.b(paramQQAppInterface, ((SessionInfo)localObject).jdField_a_of_type_JavaLangString);
          }
          ChatActivityFacade.a(paramQQAppInterface, (BaseSessionInfo)localObject);
        }
        if ((7000 == paramRecentUser.getType()) && (AppConstants.SUBACCOUNT_ASSISTANT_UIN.equals(paramRecentUser.uin))) {
          ((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).cleanAllThirdQQUnreadMsgNum(paramQQAppInterface);
        }
        paramQQAppInterface.getMessageFacade().a(paramRecentUser.uin, paramRecentUser.getType(), true, paramBoolean2);
        if (paramRecentUser.getType() == 1) {
          ((IHotChatUtil)QRoute.api(IHotChatUtil.class)).setReadedForHCTopic(paramQQAppInterface, paramRecentUser.uin);
        }
      }
      a(paramQQAppInterface, paramRecentUser, paramBoolean2);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    ThreadManager.post(new RecentUtil.6(paramQQAppInterface, paramString, paramInt), 2, null, false);
    if ("2290230341".equals(paramString))
    {
      if (paramInt == 1)
      {
        paramString = "0X80090E4";
      }
      else
      {
        QZoneReport.a(3);
        paramString = "0X80090E5";
      }
      ReportController.b(paramQQAppInterface, "CliOper", "", "", paramString, paramString, 0, 0, "", "", "", "");
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString, MessageRecord paramMessageRecord, int paramInt)
  {
    if (paramMessageRecord != null)
    {
      PAMessage localPAMessage = XMLMessageUtils.a(paramMessageRecord);
      if (localPAMessage != null) {
        paramMessageRecord = Long.toString(localPAMessage.mMsgId);
      } else {
        paramMessageRecord = paramMessageRecord.getExtInfoFromExtStr("pa_msgId");
      }
    }
    else
    {
      paramMessageRecord = "";
    }
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "mp_msg_sys_3", "msg_aio", 0, 0, paramString, paramMessageRecord, String.valueOf(paramInt), "", false);
    if ("2909288299".equals(paramString))
    {
      if (paramInt > 0) {
        paramInt = 2;
      } else {
        paramInt = 1;
      }
      ReportController.b(paramQQAppInterface, "dc00899", "Pb_account_lifeservice", "", "0X8007055", "0X8007055", 0, 0, "", "", "", ServiceAccountFolderManager.a(paramInt));
    }
  }
  
  private static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    Iterator localIterator = ((ITempMsgBoxManager)paramQQAppInterface.getRuntimeService(ITempMsgBoxManager.class, "")).getMsgBoxRecentUsers().iterator();
    while (localIterator.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)localIterator.next();
      if (TextUtils.equals(AppConstants.FILTER_MSG_UIN, localRecentUser.uin))
      {
        b(paramQQAppInterface, paramBoolean);
      }
      else
      {
        SessionInfo localSessionInfo = new SessionInfo();
        localSessionInfo.jdField_a_of_type_Int = localRecentUser.getType();
        localSessionInfo.jdField_a_of_type_JavaLangString = localRecentUser.uin;
        ChatActivityFacade.a(paramQQAppInterface, localSessionInfo);
        paramQQAppInterface.getMessageFacade().a(localSessionInfo.jdField_a_of_type_JavaLangString, localSessionInfo.jdField_a_of_type_Int, true, paramBoolean);
      }
    }
  }
  
  public static void a(RecentUser paramRecentUser, QQMessageFacade paramQQMessageFacade)
  {
    long l1 = System.currentTimeMillis();
    if (paramRecentUser != null)
    {
      if (paramQQMessageFacade == null) {
        return;
      }
      if ((paramRecentUser.getStatus() == 1000) && (paramRecentUser.lastmsgdrafttime == 0L))
      {
        paramQQMessageFacade = paramQQMessageFacade.getDraftSummaryInfo(paramRecentUser.uin, paramRecentUser.getType());
        if (paramQQMessageFacade != null) {
          paramRecentUser.lastmsgdrafttime = paramQQMessageFacade.getTime();
        }
      }
      long l2 = System.currentTimeMillis();
      if (QLog.isDevelopLevel())
      {
        paramRecentUser = new StringBuilder();
        paramRecentUser.append("updateLastDraftTimeForNewRU| cost = ");
        paramRecentUser.append(l2 - l1);
        QLog.i("Q.recent", 4, paramRecentUser.toString());
      }
    }
  }
  
  public static void a(List<ServiceAccountFolderFeed> paramList)
  {
    if ((paramList != null) && (paramList.size() == 0)) {}
  }
  
  private static boolean a(Activity paramActivity, QQAppInterface paramQQAppInterface, RecentUser paramRecentUser, int paramInt, RecentBaseData paramRecentBaseData)
  {
    if (((paramRecentUser.uin != null) && (paramRecentUser.uin.length() == 4)) || (AppConstants.QQBROADCAST_MSG_UIN.equals(paramRecentUser.uin)) || (TextUtils.equals(paramRecentUser.uin, AppConstants.NEW_KANDIAN_UIN)) || (TextUtils.equals(paramRecentUser.uin, AppConstants.WEISHI_UIN)) || (TextUtils.equals(paramRecentUser.uin, AppConstants.TIM_TEAM_UIN)) || (TextUtils.equals(paramRecentUser.uin, AppConstants.KANDIAN_SUBSCRIBE_UIN)) || (TextUtils.equals(paramRecentUser.uin, AppConstants.KANDIAN_DAILY_UIN)) || (TextUtils.equals(paramRecentUser.uin, "2290230341")) || (TextUtils.equals(paramRecentUser.uin, "2747277822")) || (TextUtils.equals(paramRecentUser.uin, "3046055438")) || (TextUtils.equals(paramRecentUser.uin, AppConstants.MINI_GAME_PUBLIC_ACCOUNT_UIN)) || (TextUtils.equals(paramRecentUser.uin, AppConstants.QQ_VIP_UIN)) || (TextUtils.equals(paramRecentUser.uin, NowQQLiveConstant.jdField_a_of_type_JavaLangString)) || (((IQQComicConfigApi)QRoute.api(IQQComicConfigApi.class)).isMatched(paramRecentUser.uin)) || (TextUtils.equals(paramRecentUser.uin, "2711679534"))) {
      try
      {
        boolean bool = a(paramQQAppInterface, paramActivity, paramRecentUser, paramInt, paramRecentBaseData);
        return bool;
      }
      catch (JSONException paramActivity)
      {
        paramActivity.printStackTrace();
      }
    }
    return false;
  }
  
  private static boolean a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString, int paramInt, Intent paramIntent)
  {
    Object localObject = (PublicAccountInfo)((IPublicAccountDataManager)paramQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all")).findPublicAccountInfoCache(String.valueOf(paramString));
    String str;
    if (localObject != null)
    {
      str = ((PublicAccountInfo)localObject).name;
      paramInt = ((PublicAccountInfo)localObject).extendType;
    }
    else
    {
      str = null;
      paramInt = 0;
    }
    if (paramInt == 2)
    {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Biz_card", "Biz_card_talk", 0, 0, paramString, "0", "", "");
      paramIntent.putExtra("chat_subType", 1);
    }
    else
    {
      localObject = paramQQAppInterface.getMessageFacade().getLastMessage(paramString, 1008);
      if (localObject != null) {
        paramInt = paramQQAppInterface.getConversationFacade().a(paramString, ((MessageRecord)localObject).istroop);
      } else {
        paramInt = 0;
      }
      a(paramQQAppInterface, paramString, (MessageRecord)localObject, paramInt);
      if ((QQNewsUtilKt.a(paramString)) && (QQNewsUtilKt.a(paramContext, (MessageRecord)localObject))) {
        return true;
      }
      localObject = (IWeatherCommApi)QRoute.api(IWeatherCommApi.class);
      if ((((IWeatherCommApi)localObject).isWeatherPA(paramString)) && (((IWeatherCommApi)localObject).startNewWeatherWebPageActivity(paramContext, paramQQAppInterface))) {
        return true;
      }
      if (((IQQHealthApi)QRoute.api(IQQHealthApi.class)).isNeedRedirectAIOToMainPage(paramString))
      {
        paramQQAppInterface = (IQQHealthService)paramQQAppInterface.getRuntimeService(IQQHealthService.class);
        if ((paramQQAppInterface != null) && (paramQQAppInterface.redirectAIOToMainPage(paramContext, str, 161))) {
          return true;
        }
      }
      paramIntent.putExtra("shouldreport", true);
      if ((paramContext instanceof SplashActivity))
      {
        paramIntent.putExtra("start_time", System.currentTimeMillis());
        paramIntent.putExtra("red_hot_count", paramInt);
      }
      boolean bool;
      if (paramInt > 0) {
        bool = true;
      } else {
        bool = false;
      }
      paramIntent.putExtra("has_unread_msg", bool);
      paramIntent.putExtra("jump_from", 1);
      PublicTracker.a(null, "SUBSCRIPT_AIO_COST");
    }
    paramIntent.setClass(paramContext, ChatActivity.class);
    return false;
  }
  
  private static boolean a(Context paramContext, QQAppInterface paramQQAppInterface, String paramString1, String paramString2, Intent paramIntent)
  {
    SmartDeviceReport.a(paramQQAppInterface, "Usr_AIO_Open", 2, 0, 0);
    paramQQAppInterface = (SmartDeviceProxyMgr)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DEVICEPROXYMGR_HANDLER);
    long l;
    try
    {
      l = Long.parseLong(paramString1);
    }
    catch (Exception paramString1)
    {
      paramString1.printStackTrace();
      l = 0L;
    }
    paramIntent.setClass(paramContext, ChatActivity.class);
    if ((paramQQAppInterface != null) && (paramQQAppInterface.a(l, 9)))
    {
      paramContext = new Bundle();
      paramContext.putString("din", String.valueOf(l));
      paramContext.putString("devName", paramString2);
      paramContext.putBoolean("bFromLightApp", false);
      paramContext.putInt("operType", 5);
      paramIntent.putExtras(paramContext);
    }
    return false;
  }
  
  public static boolean a(RecentBaseData paramRecentBaseData)
  {
    if (paramRecentBaseData == null) {}
    return false;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, Activity paramActivity, RecentUser paramRecentUser)
  {
    return ((IQQComicConfigApi)QRoute.api(IQQComicConfigApi.class)).launchIfMatched(paramRecentUser.uin, paramActivity, 1043, paramQQAppInterface);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, Activity paramActivity, RecentUser paramRecentUser, int paramInt, RecentBaseData paramRecentBaseData)
  {
    if (AppConstants.LBS_HELLO_UIN.equals(paramRecentUser.uin))
    {
      c(paramQQAppInterface, paramActivity, paramRecentUser);
    }
    else if (AppConstants.DATE_UIN.equals(paramRecentUser.uin))
    {
      b(paramQQAppInterface, paramActivity, paramRecentUser);
    }
    else if (AppConstants.LOCK_SCREEN_LBS_HELLO_UIN.equals(paramRecentUser.uin))
    {
      l(paramQQAppInterface, paramActivity);
    }
    else if (AppConstants.LOCK_SCREEN_DATE_UIN.equals(paramRecentUser.uin))
    {
      MsgBoxListActivity.startMsgBoxListActivity(paramActivity, 1010, AppConstants.DATE_UIN);
    }
    else if (AppConstants.SAME_STATE_BOX_UIN.equals(paramRecentUser.uin))
    {
      MsgBoxListActivity.startMsgBoxListActivity(paramActivity, 1009, paramRecentUser.uin);
    }
    else if (AppConstants.VOTE_MSG_UIN.equals(paramRecentUser.uin))
    {
      k(paramQQAppInterface, paramActivity);
    }
    else if (AppConstants.RECOMMEND_CONTACT_UIN.equals(paramRecentUser.uin))
    {
      j(paramQQAppInterface, paramActivity);
    }
    else if (AppConstants.TROOP_ASSISTANT_UIN.equals(paramRecentUser.uin))
    {
      i(paramQQAppInterface, paramActivity);
    }
    else if (AppConstants.QQBROADCAST_MSG_UIN.equals(paramRecentUser.uin))
    {
      paramQQAppInterface = new Intent(paramActivity, QQBroadcastActivity.class);
      paramQQAppInterface.setFlags(67108864);
      paramActivity.startActivity(paramQQAppInterface);
    }
    else if (AppConstants.TROOP_BAR_ASSISTANT_UIN.equals(paramRecentUser.uin))
    {
      h(paramQQAppInterface, paramActivity);
    }
    else if (TextUtils.equals(AppConstants.NEW_KANDIAN_UIN, paramRecentUser.uin))
    {
      b(paramQQAppInterface, paramActivity, paramRecentUser, paramRecentBaseData);
    }
    else if (AppConstants.SEND_BLESS_UIN.equals(paramRecentUser.uin))
    {
      g(paramQQAppInterface, paramActivity);
    }
    else if (!AppConstants.PUBLIC_ACCOUNT_WPA_ASSISTANT_UIN.equals(paramRecentUser.uin))
    {
      if (AppConstants.TROOP_NOTIFICATION_UIN.equals(paramRecentUser.uin))
      {
        a(paramQQAppInterface, paramActivity, paramRecentUser);
      }
      else if (AppConstants.DATALINE_PC_UIN.equals(paramRecentUser.uin))
      {
        f(paramQQAppInterface, paramActivity);
      }
      else if (AppConstants.DATALINE_IPAD_UIN.equals(paramRecentUser.uin))
      {
        e(paramQQAppInterface, paramActivity);
      }
      else if (AppConstants.ACTIVATE_FRIENDS_UIN.equals(paramRecentUser.uin))
      {
        a(paramActivity, paramInt);
      }
      else if (AppConstants.EC_SHOP_ASSISTANT_UIN.equals(paramRecentUser.uin))
      {
        a(paramQQAppInterface, paramActivity, paramRecentBaseData);
      }
      else if (1012 == paramRecentUser.msgType)
      {
        d(paramQQAppInterface, paramActivity);
      }
      else
      {
        if ((1030 != paramRecentUser.msgType) && (1035 != paramRecentUser.msgType) && (1041 != paramRecentUser.msgType) && (1042 != paramRecentUser.msgType)) {
          return b(paramQQAppInterface, paramActivity, paramRecentUser, paramInt, paramRecentBaseData);
        }
        a(paramActivity, paramRecentBaseData);
      }
    }
    return true;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    int i = paramRecentUser.getType();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i == 1)
    {
      bool1 = bool2;
      if ((paramRecentUser.lFlag & 1L) != 0L)
      {
        paramQQAppInterface = paramQQAppInterface.getHotChatMng(true);
        if (paramQQAppInterface != null)
        {
          HotChatInfo localHotChatInfo = paramQQAppInterface.a(paramRecentUser.uin);
          if ((localHotChatInfo != null) && (localHotChatInfo.apolloGameId > 0)) {
            VipUtils.a(null, "cmshow", "Apollo", "clk_reliao_msgtab", 0, 0, new String[] { String.valueOf(localHotChatInfo.apolloGameId) });
          }
        }
        bool1 = bool2;
        if (paramQQAppInterface != null)
        {
          bool1 = bool2;
          if (!paramQQAppInterface.b(paramRecentUser.uin)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
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
        paramQQAppInterface = (FriendsManager)paramQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
        bool1 = bool2;
        if (paramQQAppInterface != null)
        {
          bool1 = bool2;
          if (paramQQAppInterface.b(paramString)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private static boolean a(QQAppInterface paramQQAppInterface, String paramString, int paramInt, Intent paramIntent)
  {
    Object localObject = ((HotChatManager)paramQQAppInterface.getManager(QQManagerFactory.HOT_CHAT_MANAGER)).a(paramString);
    if (localObject != null)
    {
      paramIntent.putExtra("troop_uin", ((HotChatInfo)localObject).troopCode);
      return false;
    }
    localObject = (TroopManager)paramQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localObject != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append("");
      paramString = ((TroopManager)localObject).a(localStringBuilder.toString(), true);
      if ((paramString != null) && (paramString.troopuin != null))
      {
        paramIntent.putExtra("troop_uin", paramString.troopuin);
      }
      else
      {
        if (QLog.isColorLevel()) {
          QLog.e("RecentUtil", 2, "when enter troop AIO, troop is not exist!!");
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
          QQToast.a(BaseApplicationImpl.getContext(), 1, HardCodeUtil.a(2131713153), 0).a();
        }
        return true;
      }
    }
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "Update_tips", "Upd_tips_appear", 0, -1, "", "", "", "");
    return false;
  }
  
  public static void b(QQAppInterface paramQQAppInterface)
  {
    Iterator localIterator = ((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).getFilterBoxRecentUsers(paramQQAppInterface).iterator();
    while (localIterator.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)localIterator.next();
      b(paramQQAppInterface, localRecentUser.uin, localRecentUser.type);
      paramQQAppInterface.getMessageFacade().a(localRecentUser.uin, localRecentUser.type);
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    Intent localIntent = new Intent();
    localIntent.setFlags(67108864);
    PublicFragmentActivity.a(paramActivity, localIntent, TempMsgBoxFragment.class);
    ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X800B1BF", "0X800B1BF", 0, 0, "", "", "", "");
    ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).reportClickMsgBox(paramQQAppInterface);
  }
  
  private static void b(QQAppInterface paramQQAppInterface, Activity paramActivity, RecentUser paramRecentUser)
  {
    MsgBoxListActivity.startMsgBoxListActivity(paramActivity, 1010, paramRecentUser.uin);
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8004947", "0X8004947", 0, 0, "", "", "", "");
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80050F6", "0X80050F6", 0, 0, "", "", "", "");
  }
  
  private static void b(QQAppInterface paramQQAppInterface, Activity paramActivity, RecentUser paramRecentUser, int paramInt, RecentBaseData paramRecentBaseData)
  {
    Object localObject1 = paramQQAppInterface.getMessageFacade();
    String str1 = "";
    boolean bool1;
    if (localObject1 != null)
    {
      Object localObject2 = ((QQMessageFacade)localObject1).b(paramRecentUser.uin, paramRecentUser.getType());
      ((IRIJKanDianFolderStatus)QRoute.api(IRIJKanDianFolderStatus.class)).updateKandianFolderStatus(paramQQAppInterface, (MessageRecord)localObject2);
      paramRecentUser = ((IRIJKanDianFolderStatus)QRoute.api(IRIJKanDianFolderStatus.class)).getRedPntInfoForReport();
      String str2 = paramRecentUser.b;
      String str3 = paramRecentUser.jdField_a_of_type_JavaLangString;
      String str4 = paramRecentUser.c;
      paramRecentUser = ((IKanDianMergeManager)paramQQAppInterface.getRuntimeService(IKanDianMergeManager.class)).getUnreadMsgBoxRedPntInfo();
      if (paramRecentUser != null)
      {
        long l = paramRecentUser.mUin;
        paramRecentUser = String.valueOf(paramRecentUser.mMsgType);
        localObject1 = String.valueOf(l);
      }
      else
      {
        paramRecentUser = "";
        localObject1 = paramRecentUser;
      }
      int i;
      if (paramRecentBaseData != null) {
        i = paramRecentBaseData.mPosition;
      } else {
        i = -1;
      }
      int j;
      if ((localObject2 != null) && (((MessageRecord)localObject2).uniseq == ((IKanDianMergeManager)paramQQAppInterface.getRuntimeService(IKanDianMergeManager.class)).getLastSetTopMsgUniSeq())) {
        j = 1;
      } else {
        j = 0;
      }
      if (localObject2 != null) {
        paramQQAppInterface = ((MessageRecord)localObject2).senderuin;
      } else {
        paramQQAppInterface = "";
      }
      Object localObject3;
      label265:
      boolean bool2;
      QQAppInterface localQQAppInterface;
      if (localObject2 != null)
      {
        try
        {
          localObject3 = new JSONObject(((MessageRecord)localObject2).extStr);
          if ((((JSONObject)localObject3).has("kdShouldShowMergedAvatar")) && (((JSONObject)localObject3).getBoolean("kdShouldShowMergedAvatar")))
          {
            bool1 = ((MessageRecord)localObject2).isread;
            if (!bool1)
            {
              bool1 = true;
              break label265;
            }
          }
          bool1 = false;
          bool2 = bool1;
          localObject2 = paramQQAppInterface;
          try
          {
            if (!((JSONObject)localObject3).has("kdUin")) {
              break label331;
            }
            localObject2 = ((JSONObject)localObject3).getString("kdUin");
            bool2 = bool1;
          }
          catch (Exception localException1) {}
          localException2.printStackTrace();
        }
        catch (Exception localException2)
        {
          bool1 = false;
        }
        bool2 = bool1;
        localQQAppInterface = paramQQAppInterface;
      }
      else
      {
        bool2 = false;
        localQQAppInterface = paramQQAppInterface;
      }
      label331:
      if (paramInt != 1)
      {
        localObject3 = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        i += 1;
        IRIJTransMergeKanDianReport localIRIJTransMergeKanDianReport = (IRIJTransMergeKanDianReport)QRoute.api(IRIJTransMergeKanDianReport.class);
        if (j != 0) {
          paramQQAppInterface = "1";
        } else {
          paramQQAppInterface = "";
        }
        ((IPublicAccountReportUtils)localObject3).publicAccountReportClickEventForMigrate(null, "CliOper", "", localQQAppInterface, "0X80066F4", "0X80066F4", 0, 0, String.valueOf(i), str4, str2, localIRIJTransMergeKanDianReport.transMergeKandianReportR5WithTime(str3, paramRecentUser, paramQQAppInterface, (String)localObject1, bool2), false);
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X80066F4", localQQAppInterface, String.valueOf(i), "", str2, ((IRIJTransMergeKanDianReport)QRoute.api(IRIJTransMergeKanDianReport.class)).transMergeKandianReportR5WithTime(str3, paramRecentUser));
        ((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).reportRealTimeKanDianAction(21, str4, str2, str3, localQQAppInterface, -1);
      }
    }
    paramQQAppInterface = str1;
    if (paramRecentBaseData != null)
    {
      paramQQAppInterface = str1;
      if (paramRecentBaseData.mLastMsg != null) {
        paramQQAppInterface = paramRecentBaseData.mLastMsg.toString();
      }
    }
    paramRecentUser = new StringBuilder();
    paramRecentUser.append("enter kandianMergeBox, brief : ");
    paramRecentUser.append(((IReadInJoyUtils)QRoute.api(IReadInJoyUtils.class)).getUnSecrecyInfo(paramQQAppInterface));
    paramRecentUser.append(",isUnRead : ");
    if ((paramRecentBaseData != null) && (paramRecentBaseData.mUnreadNum != 0)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramRecentUser.append(bool1);
    QLog.d("KandianMergeManager", 1, paramRecentUser.toString());
    if (paramInt == 1) {
      paramInt = 9;
    } else {
      paramInt = 5;
    }
    ((IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class)).launchFeedsActivity(paramActivity, paramInt, 0);
    PublicTracker.a(null, "KANDIAN_FEEDS_STAGE_1_COST");
    PublicTracker.a(null, "KANDIAN_FEEDS_COST");
    PublicTracker.a(null, "KANDIAN_NEW_FEEDS_ACTIVITY_MANAGER");
  }
  
  private static void b(QQAppInterface paramQQAppInterface, Activity paramActivity, RecentUser paramRecentUser, RecentBaseData paramRecentBaseData)
  {
    int i;
    if (paramRecentBaseData != null) {
      i = paramRecentBaseData.mPosition;
    } else {
      i = -1;
    }
    ArrayList localArrayList = new ArrayList();
    paramQQAppInterface = paramQQAppInterface.getMessageFacade();
    long l;
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.b(paramRecentUser.uin, paramRecentUser.getType());
      if ((paramQQAppInterface != null) && ((paramQQAppInterface instanceof MessageForStructing)) && (paramQQAppInterface.extInt == 1))
      {
        paramRecentUser = (MessageForStructing)paramQQAppInterface;
        if (paramRecentUser.structingMsg == null) {
          paramRecentUser.parse();
        }
        if (paramRecentUser.structingMsg != null)
        {
          if (!TextUtils.isEmpty(paramRecentUser.structingMsg.mArticleIds))
          {
            paramRecentBaseData = paramRecentUser.structingMsg.mArticleIds.split("\\|");
            int k = paramRecentBaseData.length;
            int j = 0;
            while (j < k)
            {
              String str = paramRecentBaseData[j];
              try
              {
                localArrayList.add(Long.valueOf(Long.parseLong(str)));
              }
              catch (Exception localException)
              {
                localException.printStackTrace();
              }
              j += 1;
            }
          }
          if (!TextUtils.isEmpty(paramRecentUser.structingMsg.mMsgActionData))
          {
            paramRecentBaseData = ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).parseString2Json(paramRecentUser.structingMsg.mMsgActionData);
            if (paramRecentBaseData != null) {
              try
              {
                l = Long.parseLong(paramRecentBaseData.getString("id"));
              }
              catch (Exception paramRecentBaseData)
              {
                paramRecentBaseData.printStackTrace();
              }
            }
          }
          l = -1L;
          if (l != -1L) {
            ReportController.b(null, "CliOper", "", "", "0X80066F5", "0X80066F5", 0, 0, String.valueOf(i + 1), "", String.valueOf(l), "");
          }
          ((IReadInJoyReportUtils)QRoute.api(IReadInJoyReportUtils.class)).newKanDianOidbReport(paramRecentUser, 1);
        }
      }
      else
      {
        ReportController.b(null, "CliOper", "", "", "0X80066F6", "0X80066F6", 0, 0, String.valueOf(i + 1), "", "", "");
      }
      paramRecentUser = "";
      if (paramQQAppInterface == null) {
        break label617;
      }
    }
    for (;;)
    {
      try
      {
        if (!(paramQQAppInterface instanceof MessageForStructing)) {
          break label617;
        }
        MessageForStructing localMessageForStructing = (MessageForStructing)paramQQAppInterface;
        if (localMessageForStructing.structingMsg.mStrategyIds == null) {
          break label611;
        }
        paramQQAppInterface = localMessageForStructing.structingMsg.mStrategyIds.split("\\|")[0];
        paramRecentBaseData = paramQQAppInterface;
        if (localMessageForStructing.structingMsg.mAlgorithmIds != null)
        {
          paramRecentUser = localMessageForStructing.structingMsg.mAlgorithmIds.split("\\|")[0];
          paramRecentBaseData = paramQQAppInterface;
        }
        paramQQAppInterface = (IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class);
        i += 1;
        paramQQAppInterface.publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80066F4", "0X80066F4", 0, 0, String.valueOf(i), "", paramRecentBaseData, ((IRIJTransMergeKanDianReport)QRoute.api(IRIJTransMergeKanDianReport.class)).transMergeKandianReportR5WithTime(paramRecentUser), false);
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X80066F4", "", String.valueOf(i), "", paramRecentBaseData, ((IRIJTransMergeKanDianReport)QRoute.api(IRIJTransMergeKanDianReport.class)).transMergeKandianReportR5WithTime(paramRecentUser));
      }
      catch (Exception paramQQAppInterface)
      {
        paramRecentUser = new StringBuilder();
        paramRecentUser.append("failed to report new kandian click ");
        paramRecentUser.append(paramQQAppInterface.toString());
        QLog.d("KandianMergeManager", 1, paramRecentUser.toString());
      }
      paramQQAppInterface = (IReadInJoyActivityHelper)QRoute.api(IReadInJoyActivityHelper.class);
      if (localArrayList.isEmpty()) {
        l = -1L;
      } else {
        l = ((Long)localArrayList.get(0)).longValue();
      }
      paramQQAppInterface.launchFeedsActivity(paramActivity, localArrayList, l, 5);
      return;
      label611:
      paramQQAppInterface = "";
      continue;
      label617:
      paramRecentBaseData = "";
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    int i = paramRecentUser.getType();
    paramRecentUser = paramRecentUser.uin;
    if ((i != 1033) && (i != 1034)) {
      FightMsgReporter.a(1, 1, i, paramQQAppInterface.getConversationFacade().a(paramRecentUser, i));
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser, int paramInt)
  {
    if (paramRecentUser.getType() == 1) {
      ((IHotChatUtil)QRoute.api(IHotChatUtil.class)).setReadedForHCTopic(paramQQAppInterface, paramRecentUser.uin);
    }
    Object localObject1;
    if ((paramRecentUser.getType() == 9000) && (AppConstants.TROOP_NOTIFICATION_UIN.equals(paramRecentUser.uin)))
    {
      paramQQAppInterface.getMsgHandler().a().c();
      GroupSystemMsgController.a().a(paramQQAppInterface, 0);
      localObject1 = (IRecommendTroopService)paramQQAppInterface.getRuntimeService(IRecommendTroopService.class, "");
      if (localObject1 != null) {
        ((IRecommendTroopService)localObject1).sendReadConfirm();
      }
    }
    if ((paramRecentUser.getType() == 7210) && (AppConstants.TROOP_BAR_ASSISTANT_UIN.equals(paramRecentUser.uin)))
    {
      TroopBarAssistantManager.a().e(paramQQAppInterface);
      TroopBarAssistantManager.a().d(paramQQAppInterface);
      paramQQAppInterface.refreshMsgTabUnreadNum(true, 0);
    }
    if ((paramRecentUser.getType() == 7230) && (AppConstants.SERVICE_ACCOUNT_FOLDER_UIN.equals(paramRecentUser.uin)))
    {
      localObject1 = ServiceAccountFolderManager.a();
      int i = ((ServiceAccountFolderManager)localObject1).b();
      int j = ((ServiceAccountFolderManager)localObject1).a(paramQQAppInterface);
      long l = ((ServiceAccountFolderManager)localObject1).a();
      if (paramInt != -1)
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(j);
        localObject2 = ((StringBuilder)localObject2).toString();
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("");
        ((StringBuilder)localObject3).append(i);
        localObject3 = ((StringBuilder)localObject3).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(l);
        ReportController.b(paramQQAppInterface, "dc01160", "Pb_account_lifeservice", "", "0X80067EB", "0X80067EB", 0, 0, (String)localObject2, (String)localObject3, String.valueOf(paramInt + 1), localStringBuilder.toString());
      }
      ((ServiceAccountFolderManager)localObject1).d(paramQQAppInterface);
      paramQQAppInterface.refreshMsgTabUnreadNum(true, 0);
      if (QLog.isColorLevel()) {
        QLog.d("RecentUtil", 2, "deleteServiceAccountFolderFromMsgTab");
      }
    }
    if (AppConstants.TROOP_BAR_ASSISTANT_UIN.equals(paramRecentUser.uin))
    {
      ReportController.b(paramQQAppInterface, "P_CliOper", "Pb_account_lifeservice", "", "0X800572D", "0X800572D", 0, 0, "", "", "", "");
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800623F", "0X800623F", 0, 0, "", "", "", "");
      SubscriptRecommendController.c(paramQQAppInterface, false);
      return;
    }
    if (AppConstants.EC_SHOP_ASSISTANT_UIN.equals(paramRecentUser.uin))
    {
      if (((EcShopAssistantManager)paramQQAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER)).a(paramQQAppInterface) > 0) {
        paramRecentUser = "havereddot";
      } else {
        paramRecentUser = "noreddot";
      }
      ReportController.b(paramQQAppInterface, "P_CliOper", "Shop_lifeservice", "", "Shop_DelMsglist", "Del_shopHelper", 0, 0, "", "", paramRecentUser, "");
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (paramQQAppInterface != null)
    {
      if (paramString == null) {
        return;
      }
      if (paramQQAppInterface.getConversationFacade().a(paramString, paramInt) > 0)
      {
        long l = paramQQAppInterface.getMessageFacade().a(paramString, paramInt);
        if (QLog.isColorLevel()) {
          QLog.d("Q.msg.sendReadConfirm_PB", 2, String.format("RecentUtil,uin: %s, uinType: %d, id: %d", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(l) }));
        }
        if (l == -1L) {
          return;
        }
        String str = ProcessorDispatcher.a(paramInt);
        paramQQAppInterface.getMsgHandler().a(str).a(paramString, paramInt, l);
        if (paramString.equals("2747277822")) {
          d(paramQQAppInterface);
        }
      }
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    Iterator localIterator = ((ITempMsgBoxService)QRoute.api(ITempMsgBoxService.class)).getFilterBoxRecentUsers(paramQQAppInterface).iterator();
    while (localIterator.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)localIterator.next();
      SessionInfo localSessionInfo = new SessionInfo();
      localSessionInfo.jdField_a_of_type_Int = localRecentUser.getType();
      localSessionInfo.jdField_a_of_type_JavaLangString = localRecentUser.uin;
      ChatActivityFacade.a(paramQQAppInterface, localSessionInfo);
      paramQQAppInterface.getMessageFacade().a(localSessionInfo.jdField_a_of_type_JavaLangString, localSessionInfo.jdField_a_of_type_Int, true, paramBoolean);
    }
  }
  
  private static boolean b(QQAppInterface paramQQAppInterface, Activity paramActivity, RecentUser paramRecentUser, int paramInt, RecentBaseData paramRecentBaseData)
  {
    boolean bool2 = TextUtils.equals(AppConstants.KANDIAN_MERGE_UIN, paramRecentUser.uin);
    boolean bool1 = false;
    if (bool2)
    {
      b(paramQQAppInterface, paramActivity, paramRecentUser, paramInt, paramRecentBaseData);
    }
    else if (AppConstants.SERVICE_ACCOUNT_FOLDER_UIN.equals(paramRecentUser.uin))
    {
      a(paramQQAppInterface, paramActivity, paramRecentUser, paramInt, paramRecentBaseData);
    }
    else if (AppConstants.CONFESS_UIN.equals(paramRecentUser.uin))
    {
      ConfessMsgListFragment.a(paramActivity, 1);
      ReportController.b(paramQQAppInterface, "dc00898", "", "", "0X8008F4C", "0X8008F4C", 0, 0, "", "", "", "");
    }
    else if (AppConstants.WEISHI_UIN.equals(paramRecentUser.uin))
    {
      ((IWSManager)QRoute.api(IWSManager.class)).enterWSPublicAccount(paramActivity, "from_home_page", true);
    }
    else if (AppConstants.TIM_TEAM_UIN.equals(paramRecentUser.uin))
    {
      ((IPublicAccountUtil)QRoute.api(IPublicAccountUtil.class)).enterTimTeam(paramActivity, paramQQAppInterface);
    }
    else if (AppConstants.KANDIAN_SUBSCRIBE_UIN.equals(paramRecentUser.uin))
    {
      a(paramQQAppInterface, paramActivity, paramRecentUser, paramRecentBaseData);
    }
    else if ((!TextUtils.equals(paramRecentUser.uin, "2290230341")) || (!((IQzoneMsgApi)QRoute.api(IQzoneMsgApi.class)).openContentBox(paramActivity)))
    {
      if (AppConstants.KANDIAN_DAILY_UIN.equals(paramRecentUser.uin))
      {
        a(paramQQAppInterface, paramActivity, paramRecentUser, paramInt);
      }
      else if ((AppConstants.QQ_VIP_UIN.equals(paramRecentUser.uin)) && (((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).isPubAccountSwitch()) && (QQVipHelper.b(paramActivity)))
      {
        QQVipHelper.a(paramActivity);
        paramQQAppInterface.getConversationFacade().a(AppConstants.QQ_VIP_UIN, 1008, false);
      }
      else if (("2747277822".equals(paramRecentUser.uin)) && (((IQQGameConfigUtil)QRoute.api(IQQGameConfigUtil.class)).checkGamePubAccountConfig()))
      {
        c(paramQQAppInterface, paramActivity);
      }
      else if (((IMiniAppService)QRoute.api(IMiniAppService.class)).shouldOpenWebFragment(paramRecentUser.uin))
      {
        ((IMiniAppService)QRoute.api(IMiniAppService.class)).launchMiniGamePublicAccount(paramActivity, "aio");
        paramQQAppInterface.getConversationFacade().a(AppConstants.MINI_GAME_PUBLIC_ACCOUNT_UIN, 1008, false);
      }
      else if (TextUtils.equals("3046055438", paramRecentUser.uin))
      {
        ((IEcshopUtilApi)QRoute.api(IEcshopUtilApi.class)).jump(paramActivity);
        ((IEcshopReportApi)QRoute.api(IEcshopReportApi.class)).report("qgg.push.click");
        ((IEcshopMessageApi)QRoute.api(IEcshopMessageApi.class)).preloadEcshopAd(paramQQAppInterface, "3046055438");
      }
      else
      {
        if (TextUtils.equals("2711679534", paramRecentUser.uin))
        {
          ((IEcshopMessageApi)QRoute.api(IEcshopMessageApi.class)).preloadEcshopAd(paramQQAppInterface, "2711679534");
          return false;
        }
        if (NowQQLiveConstant.jdField_a_of_type_JavaLangString.equals(paramRecentUser.uin)) {
          return NowQQLiveHelper.a(paramActivity, paramRecentUser.uin, 1);
        }
        if (((IQQComicConfigApi)QRoute.api(IQQComicConfigApi.class)).isMatched(paramRecentUser.uin)) {
          return a(paramQQAppInterface, paramActivity, paramRecentUser);
        }
        if (AppConstants.TEMP_MSG_BOX_UIN.equals(paramRecentUser.uin))
        {
          b(paramQQAppInterface, paramActivity);
        }
        else
        {
          if (!AppConstants.FILTER_MSG_UIN.equals(paramRecentUser.uin)) {
            break label596;
          }
          a(paramQQAppInterface, paramActivity);
        }
      }
    }
    bool1 = true;
    label596:
    return bool1;
  }
  
  private static void c(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (TroopRedTouchHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.GET_RED_POINT_EX_HANDLER);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.b(46);
    }
  }
  
  private static void c(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    ((IQQGameHelper)QRoute.api(IQQGameHelper.class)).startQQGamePubAccount(paramActivity, 2);
    paramQQAppInterface.getConversationFacade().a("2747277822", 1008, false);
    b(paramQQAppInterface, "2747277822", 1008);
    paramActivity = (IGameMsgManagerService)paramQQAppInterface.getRuntimeService(IGameMsgManagerService.class, "");
    if ((paramActivity.isInited()) && (paramActivity.getMsgShowOnList()))
    {
      Object localObject = paramActivity.getLastSessionInfo();
      int i;
      if (localObject != null)
      {
        paramQQAppInterface = ((GameCenterSessionInfo)localObject).e();
        i = ((GameCenterSessionInfo)localObject).a();
      }
      else
      {
        paramQQAppInterface = "";
        i = -1;
      }
      if (paramActivity.getUnshowedUnreadCnt() > 0) {
        paramActivity = "0";
      } else {
        paramActivity = "1";
      }
      localObject = (IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(i);
      localStringBuilder.append("");
      ((IGameMsgHelperApi)localObject).reportForGameMsg(paramQQAppInterface, "1", "145", "920", "92003", "206346", paramActivity, localStringBuilder.toString(), "0", "20", "0", "", "");
    }
  }
  
  private static void c(QQAppInterface paramQQAppInterface, Activity paramActivity, RecentUser paramRecentUser)
  {
    MsgBoxListActivity.startMsgBoxListActivity(paramActivity, 1001, paramRecentUser.uin);
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80050F5", "0X80050F5", 0, 0, "", "", "", "");
    ReportController.b(paramQQAppInterface, "dc00899", "grp_lbs", "", "msg_box", "clk_friend", 0, 0, "", "", "", "");
    paramActivity = paramQQAppInterface.getMessageFacade().getLastMessage(paramRecentUser.uin, 1001);
    if ((paramActivity != null) && (paramActivity.msgtype == -4011))
    {
      paramActivity = ((INearbyRecommenderUtils)QRoute.api(INearbyRecommenderUtils.class)).getReasonTypeAndUins(paramQQAppInterface);
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X80055FB", "0X80055FB", 0, 0, paramActivity[0], "", paramActivity[1], "");
    }
  }
  
  private static void c(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    if (paramRecentUser.getType() == 5000)
    {
      TroopAssistantManager.a().a(paramQQAppInterface, true);
      h(paramQQAppInterface);
      return;
    }
    if (paramRecentUser.getType() == 7210)
    {
      TroopBarAssistantManager.a().a(paramQQAppInterface, true);
      ThreadManager.post(new RecentUtil.4(paramQQAppInterface), 8, null, false);
      TroopBarAssistantManager.a().h(paramQQAppInterface);
      return;
    }
    if (paramRecentUser.getType() == 7120)
    {
      i(paramQQAppInterface);
      return;
    }
    Object localObject;
    if (paramRecentUser.getType() == 9002)
    {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8004E99", "0X8004E99", 0, 0, "", "", "", "");
      localObject = paramQQAppInterface.getMessageFacade().a(AppConstants.ACTIVATE_FRIENDS_UIN, 0);
      paramRecentUser = new ArrayList(((List)localObject).size());
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)((Iterator)localObject).next();
        if ((!localMessageRecord.isread) && ((localMessageRecord.extLong & 0x1) == 1) && (!TextUtils.isEmpty(localMessageRecord.extStr))) {
          paramRecentUser.add(localMessageRecord.extStr);
        }
        paramQQAppInterface.getMessageFacade().b(AppConstants.ACTIVATE_FRIENDS_UIN, 0, localMessageRecord.uniseq);
      }
      if (paramRecentUser.size() > 0) {
        ActivateFriendServlet.a(paramQQAppInterface, (ArrayList)paramRecentUser);
      }
    }
    else
    {
      if (paramRecentUser.getType() == 9003)
      {
        ((BlessManager)paramQQAppInterface.getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).d();
        return;
      }
      if ((paramRecentUser.getType() == 7000) && (AppConstants.SUBACCOUNT_ASSISTANT_UIN.equals(paramRecentUser.uin)))
      {
        ThreadManager.postImmediately(new RecentUtil.5(paramQQAppInterface), null, true);
        return;
      }
      if (paramRecentUser.getType() == 10005)
      {
        localObject = ImaxAdRecentUserManager.a().b(paramRecentUser.uin);
        if (localObject != null) {
          ImaxAdRecentUserManager.a().a(paramQQAppInterface, paramRecentUser, (AdvertisementItem)localObject, true);
        }
      }
      else
      {
        if (paramRecentUser.getType() == 6004)
        {
          c(paramQQAppInterface);
          return;
        }
        if (paramRecentUser.getType() == 10011)
        {
          a(paramQQAppInterface);
          return;
        }
        if (paramRecentUser.getType() == 10012) {
          b(paramQQAppInterface);
        }
      }
    }
  }
  
  private static void d(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (IGameMsgManagerService)paramQQAppInterface.getRuntimeService(IGameMsgManagerService.class, "");
    if (paramQQAppInterface.isInited()) {
      paramQQAppInterface.setUnshowedUnreadCnt(0);
    }
  }
  
  private static void d(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    paramQQAppInterface = new AllInOne(paramQQAppInterface.getCurrentAccountUin(), 0);
    Intent localIntent = new Intent();
    localIntent.putExtra("param_mode", 2);
    localIntent.putExtra("AllInOne", paramQQAppInterface);
    localIntent.putExtra("frome_where", -1);
    localIntent.putExtra("abp_flag", true);
    localIntent.addFlags(67108864);
    paramActivity.startActivity(localIntent);
    RouteUtils.a(BaseApplicationImpl.getContext(), localIntent, "/nearby/people/profile");
  }
  
  private static void d(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    int j = paramRecentUser.getType();
    int i = 2;
    if (j != 0)
    {
      if (j != 1)
      {
        if ((j != 1000) && (j != 1003) && (j != 1006)) {
          if (j != 1008)
          {
            if (j != 1025)
            {
              if (j == 3000) {
                break label196;
              }
              if (j != 4000)
              {
                if (j != 6000)
                {
                  if (j != 7000)
                  {
                    if (j != 5000)
                    {
                      if (j != 5001)
                      {
                        if (j != 10008)
                        {
                          if (j != 10009) {
                            break label194;
                          }
                          i = 13;
                          break label196;
                        }
                        i = 12;
                        break label196;
                      }
                      i = 11;
                      break label196;
                    }
                    i = 4;
                    break label196;
                  }
                  i = 5;
                  break label196;
                }
                i = 8;
                break label196;
              }
              i = 6;
              break label196;
            }
          }
          else
          {
            a(paramQQAppInterface, paramRecentUser.uin, 2);
            i = 3;
            break label196;
          }
        }
        i = 9;
        break label196;
      }
      else
      {
        i = 1;
        break label196;
      }
    }
    else if (paramRecentUser.uin.equals(AppConstants.SYSTEM_MSG_UIN))
    {
      i = 7;
      break label196;
    }
    label194:
    i = 0;
    label196:
    paramRecentUser = new StringBuilder();
    paramRecentUser.append(i);
    paramRecentUser.append("");
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "Msg_tab", "Delete_msg", 0, 0, paramRecentUser.toString(), "", "", "");
  }
  
  private static void e(QQAppInterface paramQQAppInterface)
  {
    Object localObject = TroopBarAssistantManager.a().a(paramQQAppInterface);
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (TroopBarData)((List)localObject).get(0);
      if (localObject != null)
      {
        localObject = paramQQAppInterface.getMessageFacade().getLastMessage(((TroopBarData)localObject).mUin, 1008);
        if (localObject != null) {
          TroopBarAssistantManager.a().a(paramQQAppInterface, ((Message)localObject).time);
        }
      }
    }
  }
  
  private static void e(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    Intent localIntent = new Intent(paramActivity, LiteActivity.class);
    localIntent.putExtra("targetUin", AppConstants.DATALINE_IPAD_UIN);
    paramActivity.startActivity(localIntent);
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X8006040", "0X8006040", 0, 0, "", "", "", "");
  }
  
  private static void f(QQAppInterface paramQQAppInterface)
  {
    EcShopAssistantManager localEcShopAssistantManager = (EcShopAssistantManager)paramQQAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
    if (localEcShopAssistantManager != null)
    {
      Object localObject = localEcShopAssistantManager.a();
      if ((localObject != null) && (((List)localObject).size() > 0))
      {
        localObject = (EcShopData)((List)localObject).get(0);
        if (localObject != null)
        {
          paramQQAppInterface = paramQQAppInterface.getMessageFacade().getLastMessage(((EcShopData)localObject).mUin, 1008);
          if (paramQQAppInterface != null) {
            localEcShopAssistantManager.a(paramQQAppInterface.time);
          }
        }
      }
    }
  }
  
  private static void f(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    Intent localIntent = new Intent(paramActivity, LiteActivity.class);
    localIntent.putExtra("targetUin", AppConstants.DATALINE_PC_UIN);
    paramActivity.startActivity(localIntent);
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800603B", "0X800603B", 0, 0, "", "", "", "");
  }
  
  private static void g(QQAppInterface paramQQAppInterface)
  {
    HotChatCenterManager localHotChatCenterManager = (HotChatCenterManager)paramQQAppInterface.getManager(QQManagerFactory.HOTCHAT_CENTER_MANAGER);
    Object localObject1 = localHotChatCenterManager.a();
    if ((localObject1 != null) && (((List)localObject1).size() > 0))
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (HotChatItemData)((Iterator)localObject1).next();
        localObject2 = paramQQAppInterface.getMessageFacade().getLastMessage(((HotChatItemData)localObject2).mTroopUin, 1);
        if (localObject2 != null) {
          localHotChatCenterManager.a(((Message)localObject2).time);
        }
      }
    }
  }
  
  private static void g(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    BlessManager localBlessManager = (BlessManager)paramQQAppInterface.getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER);
    if (localBlessManager != null)
    {
      localBlessManager.a(paramActivity);
      localBlessManager.b(false);
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800618B", "0X800618B", 0, 0, "", "", "", "");
    }
  }
  
  private static void h(QQAppInterface paramQQAppInterface)
  {
    List localList = TroopAssistantManager.a().b(paramQQAppInterface);
    int j = 0;
    int i;
    if (localList == null) {
      i = 0;
    } else {
      i = localList.size();
    }
    while (j < i)
    {
      Object localObject = (TroopAssistantData)localList.get(j);
      if (localObject != null)
      {
        localObject = paramQQAppInterface.getMessageFacade().getLastMessage(((TroopAssistantData)localObject).troopUin, 1);
        if (localObject != null) {
          TroopAssistantManager.a().a(paramQQAppInterface, ((Message)localObject).time);
        }
      }
      j += 1;
    }
  }
  
  private static void h(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private static void i(QQAppInterface paramQQAppInterface)
  {
    EcShopAssistantManager localEcShopAssistantManager = (EcShopAssistantManager)paramQQAppInterface.getManager(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER);
    if (localEcShopAssistantManager != null)
    {
      localEcShopAssistantManager.a(true);
      List localList = localEcShopAssistantManager.a();
      int j = 0;
      int i;
      if (localList == null) {
        i = 0;
      } else {
        i = localList.size();
      }
      while (j < i)
      {
        Object localObject = (EcShopData)localList.get(j);
        if (localObject != null)
        {
          localObject = paramQQAppInterface.getMessageFacade().getLastMessage(((EcShopData)localObject).mUin, 1008);
          if (localObject != null) {
            localEcShopAssistantManager.a(((Message)localObject).time);
          }
        }
        j += 1;
      }
    }
  }
  
  private static void i(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    Intent localIntent = new Intent(paramActivity, TroopAssistantActivity.class);
    localIntent.setFlags(67108864);
    paramActivity.startActivity(localIntent);
    ReportController.b(paramQQAppInterface, "P_CliOper", "Grp_msg", "", "Msglist", "Clk_help", 0, 0, "", "", "", "");
  }
  
  private static void j(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    Intent localIntent = new Intent();
    if ((paramActivity instanceof QQLSActivity)) {
      localIntent.putExtra("from", "from_lsa");
    }
    ((INewFriendApi)QRoute.api(INewFriendApi.class)).startActivity(paramActivity, localIntent, 1);
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "Add_frd", "Clk_Frd_offer", 22, 0, "", "", "", "");
  }
  
  private static void k(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    paramQQAppInterface.getMessageFacade().a(AppConstants.VOTE_MSG_UIN, 0);
    Intent localIntent = new Intent(paramActivity, VisitorsActivity.class);
    localIntent.putExtra("votersOnly", true);
    localIntent.putExtra("toUin", Long.valueOf(paramQQAppInterface.getCurrentAccountUin()));
    paramActivity.startActivity(localIntent);
  }
  
  private static void l(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    MsgBoxListActivity.startMsgBoxListActivity(paramActivity, 1001, AppConstants.LBS_HELLO_UIN);
    ReportController.b(paramQQAppInterface, "dc00899", "grp_lbs", "", "msg_box", "tip_single", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentUtil
 * JD-Core Version:    0.7.0.1
 */
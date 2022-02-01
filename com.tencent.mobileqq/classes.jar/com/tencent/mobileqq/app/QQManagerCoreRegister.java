package com.tencent.mobileqq.app;

import android.util.SparseArray;
import com.tencent.biz.TroopRedpoint.TroopRedTouchManager;
import com.tencent.biz.now.NowLiveManager;
import com.tencent.biz.pubaccount.ecshopassit.EcShopAssistantManager;
import com.tencent.biz.qqstory.base.QQStoryManager;
import com.tencent.biz.qqstory.base.StoryHaloManager;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryNodeConfigManager;
import com.tencent.biz.qrcode.logindev.LoginDevicesManager;
import com.tencent.imcore.message.ConversationFacade;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.AppGuideTipsManager;
import com.tencent.mobileqq.activity.aio.BeancurdManager;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng;
import com.tencent.mobileqq.activity.recent.AppletsFolderManager;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.asyncdb.CacheManager;
import com.tencent.mobileqq.app.hiddenchat.HiddenChatManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.qqdaily.FrontBackReportManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarManager;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.chat.MessageNotificationSettingManager;
import com.tencent.mobileqq.confess.ConfessManager;
import com.tencent.mobileqq.data.FeedsManager;
import com.tencent.mobileqq.database.corrupt.DBFixManager;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.kandian.biz.common.api.KanDianClassProvider;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager;
import com.tencent.mobileqq.managers.PushNoticeManager;
import com.tencent.mobileqq.managers.TimUpgradeHongdianManager;
import com.tencent.mobileqq.mini.api.QQMiniManager;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.nearby.QQNearbyManager;
import com.tencent.mobileqq.qcall.QCallFacade;
import com.tencent.mobileqq.qqexpand.ExpandClassManager;
import com.tencent.mobileqq.servlet.GameCenterManagerImp;
import com.tencent.mobileqq.servlet.QZoneManagerImp;
import com.tencent.mobileqq.shortvideo.ShortVideoPreDownloaderWithSdkSupport;
import com.tencent.mobileqq.studymode.ModeSwitchManager;
import com.tencent.mobileqq.together.TogetherControlManager;
import com.tencent.mobileqq.transfile.NetEngineFactory;
import com.tencent.mobileqq.troop.navigatebar.TroopAioNavigateBarManager;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import com.tencent.mobileqq.troop.utils.TroopGagMgr;
import com.tencent.mobileqq.troop.utils.TroopRobotManager;
import com.tencent.mobileqq.troop.utils.TroopTipsMsgMgr;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vipgift.VipGiftManager;
import com.tencent.qidian.QidianManager;
import com.tencent.util.notification.NotifyIdManager;
import mqq.app.TicketManagerImpl;
import mqq.app.WtloginManagerImpl;
import mqq.manager.Manager;

public class QQManagerCoreRegister
{
  static void a(SparseArray<Class<? extends Manager>> paramSparseArray)
  {
    paramSparseArray.put(QQManagerFactory.QZONE_MANAGER, QZoneManagerImp.class);
    paramSparseArray.put(QQManagerFactory.GAMECENTER_MANAGER, GameCenterManagerImp.class);
    paramSparseArray.put(QQManagerFactory.PROXY_MANAGER, ProxyManager.class);
    paramSparseArray.put(QQManagerFactory.CACHE_MANAGER, CacheManager.class);
    paramSparseArray.put(QQManagerFactory.MGR_MSG_FACADE, QQMessageFacade.class);
    paramSparseArray.put(QQManagerFactory.MGR_NET_ENGINE, NetEngineFactory.class);
    paramSparseArray.put(QQManagerFactory.CONVS_FACADE, ConversationFacade.class);
    paramSparseArray.put(QQManagerFactory.RECENT_CALL_FACADE, QCallFacade.class);
    paramSparseArray.put(QQManagerFactory.CHAT_BUBBLE_MANAGER, BubbleManager.class);
    paramSparseArray.put(QQManagerFactory.TROOP_MANAGER, TroopManager.class);
    paramSparseArray.put(QQManagerFactory.HOT_CHAT_MANAGER, HotChatManager.class);
    paramSparseArray.put(QQManagerFactory.MGR_RED_TOUCH_EX, TroopRedTouchManager.class);
    paramSparseArray.put(QQManagerFactory.MGR_ACTVATE_FRIENDS, ActivateFriendsManager.class);
    paramSparseArray.put(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER, EcShopAssistantManager.class);
    paramSparseArray.put(QQManagerFactory.READINJOY_MANAGER, KanDianClassProvider.j());
    paramSparseArray.put(QQManagerFactory.LOGIN_WELCOME_MANAGER, LoginWelcomeManager.class);
    paramSparseArray.put(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER, MayknowRecommendManager.class);
    paramSparseArray.put(QQManagerFactory.LOCAL_REDTOUCH_MANAGER, QQNearbyManager.k());
    paramSparseArray.put(QQManagerFactory.WEISHI_MANAGER, WeishiManager.class);
    paramSparseArray.put(QQManagerFactory.KANDIAN_MERGE_MANAGER, KanDianClassProvider.i());
    paramSparseArray.put(QQManagerFactory.QIDIAN_MANAGER, QidianManager.class);
    paramSparseArray.put(QQManagerFactory.NOW_LIVE_MANAGER, NowLiveManager.class);
    paramSparseArray.put(QQManagerFactory.DYNAMIC_AVATAR_MANAGER, DynamicAvatarManager.class);
    paramSparseArray.put(QQManagerFactory.QQSTORY_MANAGER, QQStoryManager.class);
    paramSparseArray.put(QQManagerFactory.TROOP_ROBOT_MANAGER, TroopRobotManager.class);
    paramSparseArray.put(QQManagerFactory.FLASH_CHAT_MANAGER, FlashChatManager.class);
    paramSparseArray.put(QQManagerFactory.NOTIFY_ID_MANAGER, NotifyIdManager.class);
    paramSparseArray.put(QQManagerFactory.APP_GUIDE_TIPS_MANAGER, AppGuideTipsManager.class);
    paramSparseArray.put(QQManagerFactory.TIM_UPGRADE_HONGDIAN_MANAGER, TimUpgradeHongdianManager.class);
    paramSparseArray.put(QQManagerFactory.MSG_TAB_STORY_CONFIG_MANAGER, MsgTabStoryNodeConfigManager.class);
    paramSparseArray.put(QQManagerFactory.HOTCHAT_CENTER_MANAGER, HotChatCenterManager.class);
    paramSparseArray.put(QQManagerFactory.STORY_HALO_MANAGER, StoryHaloManager.class);
    paramSparseArray.put(QQManagerFactory.QIM_NEW_FRIEND_MANAGER, QIMNewFriendManager.class);
    paramSparseArray.put(QQManagerFactory.CONFESS_MANAGER, ConfessManager.class);
    paramSparseArray.put(QQManagerFactory.CTENTRY_MNG, CTEntryMng.class);
    paramSparseArray.put(QQManagerFactory.EXTEND_FRIEND_MANAGER, ExpandClassManager.a());
    paramSparseArray.put(QQManagerFactory.KANDIAN_SUBSCRIBE_MANAGER, KanDianClassProvider.g());
    paramSparseArray.put(QQManagerFactory.PUSH_NOTICE_MANAGER, PushNoticeManager.class);
    paramSparseArray.put(QQManagerFactory.KANDIAN_DAILY_MANAGER, KanDianClassProvider.h());
    paramSparseArray.put(QQManagerFactory.LISTEN_TOGETHER_MANAGER, ListenTogetherManager.class);
    paramSparseArray.put(QQManagerFactory.DB_FIX_MANAGER, DBFixManager.class);
    paramSparseArray.put(1, WtloginManagerImpl.class);
    paramSparseArray.put(2, TicketManagerImpl.class);
    paramSparseArray.put(QQManagerFactory.DOWNLOADER_FACTORY, DownloaderFactory.class);
    paramSparseArray.put(QQManagerFactory.TROOP_GAG_MANAGER, TroopGagMgr.class);
    paramSparseArray.put(QQManagerFactory.DISCUSSION_MANAGER, DiscussionManager.class);
    paramSparseArray.put(QQManagerFactory.CHAT_BACKGROUND_MANAGER, ChatBackgroundManager.class);
    paramSparseArray.put(QQManagerFactory.VIP_GIF_MANAGER, VipGiftManager.class);
    paramSparseArray.put(QQManagerFactory.TROOP_TIPS_MSG_MANAGER, TroopTipsMsgMgr.class);
    paramSparseArray.put(QQManagerFactory.SHORT_VIDEO_PREDOWNLOAD_MANAGER, ShortVideoPreDownloaderWithSdkSupport.class);
    paramSparseArray.put(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER, TroopBindPublicAccountMgr.class);
    paramSparseArray.put(QQManagerFactory.MESSAGE_NOTIFICATION_SETTING_MANAGER, MessageNotificationSettingManager.class);
    paramSparseArray.put(QQManagerFactory.GROUP_VIDEO_PLUGIN_MANAGER, QQNearbyManager.o());
    paramSparseArray.put(QQManagerFactory.HIDDENCHAT_MANAGER, HiddenChatManager.class);
    paramSparseArray.put(QQManagerFactory.QZONE_NEW_STATUS_MANAGER, FeedsManager.class);
    paramSparseArray.put(QQManagerFactory.BEANCURD_MANAGER, BeancurdManager.class);
    paramSparseArray.put(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER, ExpandClassManager.b());
    paramSparseArray.put(QQManagerFactory.APPLETS_ACCOUNT_MANAGER, AppletsFolderManager.class);
    paramSparseArray.put(QQManagerFactory.MINI_APP_EXPOSURE_MANAGER, QQMiniManager.getMiniAppExposureManagerClass());
    paramSparseArray.put(QQManagerFactory.LOGIN_DEVICES_MANAGER, LoginDevicesManager.class);
    paramSparseArray.put(QQManagerFactory.MINI_APP_DESKTOP_MANAGER, QQMiniManager.getDesktopDataManagerClass());
    paramSparseArray.put(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER, TogetherControlManager.class);
    paramSparseArray.put(QQManagerFactory.FRONT_BACK_REPORT_MANAGER, FrontBackReportManager.class);
    paramSparseArray.put(QQManagerFactory.TROOP_AIO_NAVIGATE_BAR, TroopAioNavigateBarManager.class);
    paramSparseArray.put(QQManagerFactory.VAS_QUICKUPDATE_MANAGER, VasQuickUpdateManager.class);
    paramSparseArray.put(QQManagerFactory.STUDY_MODE_SWITCHER_MANAGER, ModeSwitchManager.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.QQManagerCoreRegister
 * JD-Core Version:    0.7.0.1
 */
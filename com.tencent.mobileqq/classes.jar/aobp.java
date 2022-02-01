import android.util.SparseArray;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianDailyManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianSubscribeManager;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.DeviceProfileManager.AccountDpcManager;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.readinjoy.ReadInJoyManager;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.contactsync.ContactSyncManager;
import com.tencent.mobileqq.data.FeedsManager;
import com.tencent.mobileqq.database.corrupt.DBFixManager;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager;
import com.tencent.mobileqq.mini.entry.MiniAppExposureManager;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.pic.PicPreDownloader;
import com.tencent.mobileqq.transfile.NetEngineFactory;
import com.tencent.mobileqq.transfile.predownload.PreDownloadController;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadScheduler;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import cooperation.qqcircle.redpoint.QCircleRedPointManager;
import mqq.app.TicketManagerImpl;
import mqq.app.WtloginManagerImpl;
import mqq.manager.Manager;

public class aobp
{
  public static void a(SparseArray<Class<? extends Manager>> paramSparseArray)
  {
    paramSparseArray.put(QQManagerFactory.QZONE_MANAGER, bcvr.class);
    paramSparseArray.put(QQManagerFactory.CONTACT_MANAGER, PhoneContactManagerImp.class);
    paramSparseArray.put(QQManagerFactory.GAMECENTER_MANAGER, bcvc.class);
    paramSparseArray.put(QQManagerFactory.PROXY_MANAGER, ProxyManager.class);
    paramSparseArray.put(QQManagerFactory.CACHE_MANAGER, aohg.class);
    paramSparseArray.put(QQManagerFactory.MGR_MSG_FACADE, QQMessageFacade.class);
    paramSparseArray.put(QQManagerFactory.MGR_NET_ENGINE, NetEngineFactory.class);
    paramSparseArray.put(QQManagerFactory.CONVS_FACADE, acmw.class);
    paramSparseArray.put(QQManagerFactory.MGR_TROOP_FILTER, bhhi.class);
    paramSparseArray.put(QQManagerFactory.NEW_FRIEND_MANAGER, aizi.class);
    paramSparseArray.put(QQManagerFactory.MGR_RED_TOUCH, bbbq.class);
    paramSparseArray.put(QQManagerFactory.QCIRCLE_MGR_RED_TOUCH, QCircleRedPointManager.class);
    paramSparseArray.put(QQManagerFactory.RECENT_CALL_FACADE, bapk.class);
    paramSparseArray.put(QQManagerFactory.ROAM_SETTING_MANAGER, aocx.class);
    paramSparseArray.put(QQManagerFactory.MGR_SYNC_CONTACT, ContactSyncManager.class);
    paramSparseArray.put(QQManagerFactory.CHAT_BUBBLE_MANAGER, BubbleManager.class);
    paramSparseArray.put(QQManagerFactory.TROOP_MANAGER, TroopManager.class);
    paramSparseArray.put(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER, aoan.class);
    paramSparseArray.put(QQManagerFactory.HOT_CHAT_MANAGER, HotChatManager.class);
    paramSparseArray.put(QQManagerFactory.SUB_ACCOUNT_MANAGER, bdxs.class);
    paramSparseArray.put(QQManagerFactory.MGR_RED_TOUCH_EX, ntq.class);
    paramSparseArray.put(QQManagerFactory.MGR_ACTVATE_FRIENDS, aohe.class);
    paramSparseArray.put(QQManagerFactory.EC_SHOP_ASSISTANT_MANAGER, onq.class);
    paramSparseArray.put(QQManagerFactory.READINJOY_MANAGER, ReadInJoyManager.class);
    paramSparseArray.put(QQManagerFactory.LOGIN_WELCOME_MANAGER, LoginWelcomeManager.class);
    paramSparseArray.put(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER, anyb.class);
    paramSparseArray.put(QQManagerFactory.LOCAL_REDTOUCH_MANAGER, aymd.class);
    paramSparseArray.put(QQManagerFactory.WEISHI_MANAGER, pws.class);
    paramSparseArray.put(QQManagerFactory.KANDIAN_MERGE_MANAGER, KandianMergeManager.class);
    paramSparseArray.put(QQManagerFactory.QIDIAN_MANAGER, bjxa.class);
    paramSparseArray.put(QQManagerFactory.NOW_LIVE_MANAGER, nyv.class);
    paramSparseArray.put(QQManagerFactory.DYNAMIC_AVATAR_MANAGER, aqeq.class);
    paramSparseArray.put(QQManagerFactory.QQSTORY_MANAGER, vzv.class);
    paramSparseArray.put(QQManagerFactory.PRE_DOWNLOAD_CONTROLLER_2, PreDownloadController.class);
    paramSparseArray.put(QQManagerFactory.TROOP_ROBOT_MANAGER, bgls.class);
    paramSparseArray.put(QQManagerFactory.FLASH_CHAT_MANAGER, FlashChatManager.class);
    paramSparseArray.put(QQManagerFactory.NOTIFY_ID_MANAGER, bkyy.class);
    paramSparseArray.put(QQManagerFactory.APP_GUIDE_TIPS_MANAGER, afpn.class);
    paramSparseArray.put(QQManagerFactory.PRE_DOWNLOAD_SCHEDULER_MANAGER, PreDownloadScheduler.class);
    paramSparseArray.put(QQManagerFactory.TIM_UPGRADE_HONGDIAN_MANAGER, awty.class);
    paramSparseArray.put(QQManagerFactory.MSG_TAB_STORY_CONFIG_MANAGER, wms.class);
    paramSparseArray.put(QQManagerFactory.HOTCHAT_CENTER_MANAGER, anwa.class);
    paramSparseArray.put(QQManagerFactory.STORY_HALO_MANAGER, wae.class);
    paramSparseArray.put(QQManagerFactory.QIM_NEW_FRIEND_MANAGER, aoay.class);
    paramSparseArray.put(QQManagerFactory.CONFESS_MANAGER, aqvd.class);
    paramSparseArray.put(QQManagerFactory.CTENTRY_MNG, ajmy.class);
    paramSparseArray.put(QQManagerFactory.EXTEND_FRIEND_MANAGER, aslo.class);
    paramSparseArray.put(QQManagerFactory.KANDIAN_SUBSCRIBE_MANAGER, KandianSubscribeManager.class);
    paramSparseArray.put(QQManagerFactory.BANNER_LISTENER_MANAGER, aldg.class);
    paramSparseArray.put(QQManagerFactory.PUSH_NOTICE_MANAGER, awtm.class);
    paramSparseArray.put(QQManagerFactory.KANDIAN_DAILY_MANAGER, KandianDailyManager.class);
    paramSparseArray.put(QQManagerFactory.QQ_REMINDER_ALARM_MANAGER, afnl.class);
    paramSparseArray.put(QQManagerFactory.LISTEN_TOGETHER_MANAGER, ListenTogetherManager.class);
    paramSparseArray.put(QQManagerFactory.NEW_FRIEND_VERIFICATION_MANAGER, aixk.class);
    paramSparseArray.put(QQManagerFactory.DB_FIX_MANAGER, DBFixManager.class);
    paramSparseArray.put(QQManagerFactory.ACCOUNTDPC_MANAGER, DeviceProfileManager.AccountDpcManager.class);
    paramSparseArray.put(1, WtloginManagerImpl.class);
    paramSparseArray.put(2, TicketManagerImpl.class);
    paramSparseArray.put(QQManagerFactory.MGR_SUB_ACNT, bdxp.class);
    paramSparseArray.put(QQManagerFactory.MGR_PIC_PREDOWNLOAD, PicPreDownloader.class);
    paramSparseArray.put(QQManagerFactory.DOWNLOADER_FACTORY, bhyq.class);
    paramSparseArray.put(QQManagerFactory.TROOP_GAG_MANAGER, bgkf.class);
    paramSparseArray.put(QQManagerFactory.DISCUSSION_MANAGER, antp.class);
    paramSparseArray.put(QQManagerFactory.SUB_ACCOUNT_CONTROLL, bdxj.class);
    paramSparseArray.put(QQManagerFactory.CHAT_BACKGROUND_MANAGER, ChatBackgroundManager.class);
    paramSparseArray.put(QQManagerFactory.PICTURE_STATISTICS_MANAGER, azkk.class);
    paramSparseArray.put(QQManagerFactory.VIP_GIF_MANAGER, bibu.class);
    paramSparseArray.put(QQManagerFactory.EARLY_DOWNLOAD_MANAGER, asbm.class);
    paramSparseArray.put(QQManagerFactory.TROOP_TIPS_MSG_MANAGER, bgmf.class);
    paramSparseArray.put(QQManagerFactory.SHORT_VIDEO_PREDOWNLOAD_MANAGER, bcxl.class);
    paramSparseArray.put(QQManagerFactory.SCRIBBLE_DOWNLOAD_MANAGER, bbxu.class);
    paramSparseArray.put(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER, bgiy.class);
    paramSparseArray.put(QQManagerFactory.APOLLO_MANAGER, amme.class);
    paramSparseArray.put(QQManagerFactory.VACD_REPORT_MANAGER, albe.class);
    paramSparseArray.put(QQManagerFactory.ONLINE_STATUS_MANAGER, azbv.class);
    paramSparseArray.put(QQManagerFactory.MESSAGE_NOTIFICATION_SETTING_MANAGER, aqne.class);
    paramSparseArray.put(QQManagerFactory.GROUP_VIDEO_PLUGIN_MANAGER, avsv.class);
    paramSparseArray.put(QQManagerFactory.HIDDENCHAT_MANAGER, aome.class);
    paramSparseArray.put(QQManagerFactory.QZONE_NEW_STATUS_MANAGER, FeedsManager.class);
    paramSparseArray.put(QQManagerFactory.BEANCURD_MANAGER, afqy.class);
    paramSparseArray.put(QQManagerFactory.EXTEND_FRIEND_LIMIT_CHAT_MANAGER, asqt.class);
    paramSparseArray.put(QQManagerFactory.APPLETS_ACCOUNT_MANAGER, alcz.class);
    paramSparseArray.put(QQManagerFactory.MINI_APP_EXPOSURE_MANAGER, MiniAppExposureManager.class);
    paramSparseArray.put(QQManagerFactory.LOGIN_DEVICES_MANAGER, zng.class);
    paramSparseArray.put(QQManagerFactory.MINI_APP_DESKTOP_MANAGER, DesktopDataManager.class);
    paramSparseArray.put(QQManagerFactory.TOGETHER_CONTROLLER_MANAGER, bejv.class);
    paramSparseArray.put(QQManagerFactory.TROOP_HONOR_MANAGER, bfwu.class);
    paramSparseArray.put(QQManagerFactory.FRONT_BACK_REPORT_MANAGER, aoys.class);
    paramSparseArray.put(QQManagerFactory.TROOP_AIO_NAVIGATE_BAR, bfzk.class);
    paramSparseArray.put(QQManagerFactory.AV_GAME_MANAGER, ncz.class);
    paramSparseArray.put(QQManagerFactory.TEMP_MSG_BOX, almg.class);
    paramSparseArray.put(QQManagerFactory.VAS_QUICKUPDATE_MANAGER, VasQuickUpdateManager.class);
    paramSparseArray.put(QQManagerFactory.QQ_VAS_UPDATE_MANAGER, bhuk.class);
    paramSparseArray.put(QQManagerFactory.TROOP_NOTIFICATION_MANAGER, ajfn.class);
    paramSparseArray.put(QQManagerFactory.STUDY_MODE_SWITCHER_MANAGER, bdve.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aobp
 * JD-Core Version:    0.7.0.1
 */
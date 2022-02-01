package com.tencent.mobileqq.app.automator.step;

import MQQ.PayRuleCfg;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.view.accessibility.AccessibilityManager;
import com.tencent.biz.TroopRedpoint.TroopRedTouchHandler;
import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementRecentUserManager;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager;
import com.tencent.biz.pubaccount.Advertisement.util.PublicAccountAdUtil;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.api.IPublicAccountReportManager;
import com.tencent.biz.pubaccount.api.IPublicAccountSearchRecommendManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.biz.pubaccount.weishi_new.api.IWSManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.NotificationReportUtil;
import com.tencent.gdtad.qqproxy.GdtAppPreOrderUtil;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.hippy.qq.api.IHippyUpdate;
import com.tencent.hotpatch.Reporter;
import com.tencent.hotpatch.config.PatchConfigServlet;
import com.tencent.imcore.message.MsgProxyContainer;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.AIOConfigManager;
import com.tencent.mobileqq.activity.aio.panel.miniapp.AioPanelMiniAppManager;
import com.tencent.mobileqq.activity.aio.stickerrecommended.IStickerRecManager;
import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneUnityManager;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideBannerManager;
import com.tencent.mobileqq.activity.recent.msgbox.RecentUserCacheHelper;
import com.tencent.mobileqq.activity.springfestival.config.SpringFestivalRedpacketConfigManager;
import com.tencent.mobileqq.addfriend.api.IAddFriendApi;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.EqqDetailDataManager;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.asyncdb.CacheManager;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.handler.RegisterProxyHandler;
import com.tencent.mobileqq.app.msgnotify.MsgNotifyPushDialog.PopOpenMsgNotifationTask;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.app.qqdaily.FrontBackReportManager;
import com.tencent.mobileqq.app.utils.ClassicHeadActivityManager;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionUtil;
import com.tencent.mobileqq.ar.ArResourceManager;
import com.tencent.mobileqq.ar.online_video.AROnlineVideoUtil;
import com.tencent.mobileqq.ark.api.IArkService;
import com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService;
import com.tencent.mobileqq.colornote.api.IColorNoteUtil;
import com.tencent.mobileqq.colornote.data.ColorNoteHandler;
import com.tencent.mobileqq.data.FeedsManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.dt.QQDtReportHelper;
import com.tencent.mobileqq.filemanager.fileassistant.util.DatalineMsgDbTransformer;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.fts.api.IFTSDBRuntimeService;
import com.tencent.mobileqq.fts.interfaces.IFTSTroopInterface;
import com.tencent.mobileqq.gamecenter.api.IGameMsgUnissoHandlerApi;
import com.tencent.mobileqq.imaxad.ImaxAdVideoPreloadManager;
import com.tencent.mobileqq.kandian.base.utils.api.IRIJRuntimeUtils;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoySPEventReport;
import com.tencent.mobileqq.kandian.biz.common.api.IReadInJoySpEventReportUtil;
import com.tencent.mobileqq.kandian.biz.pts.api.IOfflineUtils;
import com.tencent.mobileqq.kandian.biz.push.api.IKanDianMergeManager;
import com.tencent.mobileqq.kandian.repo.account.api.IUserOperationModule;
import com.tencent.mobileqq.managers.TimJumpLoginManager;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.profilecard.processor.TempGetProfileDetailProcessor;
import com.tencent.mobileqq.profilecard.utils.ProfileServiceUtils;
import com.tencent.mobileqq.pushnotice.PushNoticeUtil;
import com.tencent.mobileqq.qassistant.api.IVoiceAssistantMain;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.IPasswdRedBagService;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.search.base.util.SearchConfigManager;
import com.tencent.mobileqq.service.qzone.QZoneUnreadServletLogic;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.startup.step.DtSdkInitStep;
import com.tencent.mobileqq.startup.step.RecordTracer;
import com.tencent.mobileqq.statistics.FDStats;
import com.tencent.mobileqq.statistics.FightReporter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.studymode.AlphabeticFontHandler;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.teamwork.api.ITeamWorkUtilsTemp;
import com.tencent.mobileqq.transfile.predownload.IPreDownloadController;
import com.tencent.mobileqq.troop.api.handler.ITroopListHandler;
import com.tencent.mobileqq.troop.blocktroop.TroopBlockUtils;
import com.tencent.mobileqq.troop.navigatebar.TroopAioNavigateBarManager;
import com.tencent.mobileqq.troop.troopapps.api.ITroopAioAppService;
import com.tencent.mobileqq.troop.utils.TroopTipsMsgMgr;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.fts.SQLiteFTSUtils;
import com.tencent.mobileqq.utils.quic.QuicResDownload;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vfs.ReportCallback;
import com.tencent.mobileqq.vfs.VFSRegisterProxy;
import com.tencent.mobileqq.wifi.FreeWifiHelper;
import com.tencent.mqp.app.bps.d;
import com.tencent.mqpsdk.util.NetUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.UnifiedMonitor;
import com.tencent.qqperf.monitor.crash.tools.TombLogRecordHelper;
import com.tencent.qqperf.monitor.dropframe.DropFrameMonitor;
import com.tencent.qqperf.opt.suspendthread.DeviceOptSwitch;
import com.tencent.qqperf.repoter.ReporterMachine;
import com.tencent.qqprotect.common.QCC;
import com.tencent.trackrecordlib.core.RecordManager;
import com.tencent.util.notification.NotifyIdManager;
import cooperation.photoplus.PhotoPlusManager;
import cooperation.qwallet.plugin.IQWalletHelper;
import cooperation.qwallet.plugin.PatternLockUtils;
import cooperation.qzone.QZoneHelper;
import cooperation.vip.manager.CheckLoveStateRequestManager;
import dov.com.qq.im.ae.download.old.AEOldShortVideoResManager;
import java.io.File;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;

public class AfterSyncMsg
  extends AsyncStep
{
  private void A()
  {
    if (NetUtil.a(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()) != 2) {
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).preloadMiniProcess();
    }
  }
  
  private void B()
  {
    if (this.mAutomator.jdField_a_of_type_Boolean) {
      ((ITroopListHandler)this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_LIST_HANDLER)).a();
    }
  }
  
  private void C()
  {
    PayRuleCfg localPayRuleCfg = VipInfoHandler.a(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    if (VipInfoHandler.a(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localPayRuleCfg, true)) {
      ThreadManagerV2.getUIHandlerV2().post(new AfterSyncMsg.6(this));
    }
  }
  
  private void D()
  {
    if (SystemUtil.a())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(AppConstants.PATH_CUSTOM_HEAD_ROOT_SDCARD);
      ((StringBuilder)localObject1).append(".nomedia");
      com.tencent.mobileqq.utils.FileUtils.createFileIfNotExits(((StringBuilder)localObject1).toString());
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(AppConstants.PATH_HEAD_HD);
      ((StringBuilder)localObject1).append(".nomedia");
      com.tencent.mobileqq.utils.FileUtils.createFileIfNotExits(((StringBuilder)localObject1).toString());
    }
    Object localObject1 = this.mAutomator.jdField_a_of_type_AndroidContentSharedPreferences;
    int i = 0;
    if (((SharedPreferences)localObject1).getBoolean("isConvertOldQQHeadOK", false)) {
      return;
    }
    Hashtable localHashtable = new Hashtable();
    EntityManager localEntityManager = this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    List localList = localEntityManager.query(Setting.class, new Setting().getTableName(), false, "bHeadType=? or (bHeadType<>? and bUsrType=?)", new String[] { "0", "0", "4" }, null, null, null, null);
    if ((localList != null) && (localList.size() > 0)) {
      while (i < localList.size())
      {
        Object localObject2 = (Setting)localList.get(i);
        if ((((Setting)localObject2).uin != null) && (((Setting)localObject2).uin.length() > 0))
        {
          int j;
          if (((Setting)localObject2).bUsrType == 4)
          {
            if ((((Setting)localObject2).bHeadType == 0) && (((Setting)localObject2).systemHeadID == 0)) {
              break label442;
            }
            if (((Setting)localObject2).uin.startsWith("troop_")) {
              localObject1 = ((Setting)localObject2).uin.substring(6);
            } else {
              localObject1 = ((Setting)localObject2).uin;
            }
            j = 4;
          }
          else
          {
            localObject1 = ((Setting)localObject2).uin;
            j = 1;
          }
          String str1 = this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOldCustomFaceFilePath(j, (String)localObject1);
          String str2 = this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCustomFaceFilePath((Setting)localObject2, j, (String)localObject1, 0, 0);
          if (((Setting)localObject2).bHeadType == 0)
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append("sys_");
            ((StringBuilder)localObject1).append(String.valueOf(((Setting)localObject2).systemHeadID));
            localObject1 = ((StringBuilder)localObject1).toString();
          }
          else
          {
            localObject1 = ((Setting)localObject2).uin;
          }
          localObject2 = new File(str1);
          if (localHashtable.containsKey(localObject1))
          {
            if (((File)localObject2).exists()) {
              ((File)localObject2).delete();
            }
          }
          else if (((File)localObject2).exists())
          {
            com.tencent.mobileqq.transfile.filebrowser.FileUtils.copyFile(str1, str2);
            ((File)localObject2).delete();
            localHashtable.put(localObject1, Boolean.valueOf(true));
          }
        }
        label442:
        i += 1;
      }
    }
    localEntityManager.close();
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(AppConstants.PATH_CUSTOM_HEAD_ROOT_SDCARD);
    ((StringBuilder)localObject1).append("_thd/");
    localObject1 = new File(((StringBuilder)localObject1).toString());
    if (((File)localObject1).exists()) {
      com.tencent.open.base.FileUtils.a((File)localObject1);
    }
    localObject1 = new File("/data/data/com.tencent.mobileqq/files/head/_thd/");
    if (((File)localObject1).exists()) {
      com.tencent.open.base.FileUtils.a((File)localObject1);
    }
    this.mAutomator.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("isConvertOldQQHeadOK", true).commit();
  }
  
  private void E()
  {
    if ((this.mAutomator != null) && (this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      new CheckLoveStateRequestManager().a(Long.parseLong(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
      return;
    }
    QLog.i("QQInitHandler", 1, "ChkeckLoveStateRequest diden`t send");
  }
  
  private void a()
  {
    B();
    ((FriendListHandler)this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getSelfXManInfo();
    b(23);
    d();
    PromotionUtil.a(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    AROnlineVideoUtil.a(BaseApplicationImpl.getContext(), this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().l();
    ((IPublicAccountReportManager)this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPublicAccountReportManager.class, "all")).scheduleReport();
    Object localObject = (IPasswdRedBagService)this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPasswdRedBagService.class);
    ((IPasswdRedBagService)localObject).requestPasswdRedBagByDisgroups();
    ((IPasswdRedBagService)localObject).requestPasswdRedBagByGroups();
    PatternLockUtils.syncQWalletPatternLock(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    a("checkDelAbnormalLocalTroopMsg onReconnect");
    int i = NetworkUtil.getSystemNetwork(BaseApplicationImpl.getApplication());
    if ((i == 1) || (i == 3) || (i == 4)) {
      ((BlessManager)this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).g();
    }
    if (i == 1) {
      ((PhotoPlusManager)this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PHOTO_PLUS_MANAGER)).a(false);
    }
    PatchConfigServlet.a(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), -1, "doOnReconnect");
    if ((this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isCreateManager(QQManagerFactory.MGR_PLUGIN))) {
      ((IQWalletHelper)QRoute.api(IQWalletHelper.class)).getPayCode(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if (Math.abs(System.currentTimeMillis() - AEOldShortVideoResManager.a) > 3600000L) {
      AEOldShortVideoResManager.a(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2);
    }
    if (Math.abs(System.currentTimeMillis() - ShortVideoResourceManager.a) > 3600000L) {
      ShortVideoResourceManager.a(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2);
    } else {
      QLog.d("ShortVideoResourceManager", 1, "[network]not need get config...");
    }
    localObject = (ClassicHeadActivityManager)this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CLASSIC_HEAD_ACIVITY_MANAGER);
    if ((localObject != null) && (((ClassicHeadActivityManager)localObject).a()))
    {
      localObject = (TempGetProfileDetailProcessor)ProfileServiceUtils.getBusinessProcessor(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, TempGetProfileDetailProcessor.class);
      if (localObject != null) {
        ((TempGetProfileDetailProcessor)localObject).getClassicHeadActivityParams();
      }
    }
    a(2);
    ((SpringFestivalRedpacketConfigManager)this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SPRING_FESTIVAL_RED_PACKET_MANAGER)).b(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
    QQAppInterface.initHeadCfg();
    c();
    b();
    ((IStickerRecManager)this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IStickerRecManager.class)).pullWords();
    ((IReadInJoySpEventReportUtil)QRoute.api(IReadInJoySpEventReportUtil.class)).init();
    t();
    StudyModeManager.a();
  }
  
  private void a(int paramInt)
  {
    IQWalletConfigService localIQWalletConfigService = (IQWalletConfigService)this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQWalletConfigService.class, "");
    if (localIQWalletConfigService != null) {
      localIQWalletConfigService.tryGetConfig(paramInt);
    }
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.del_abnormal_troop_local_msg", 2, paramString);
    }
    this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().r();
  }
  
  private void b()
  {
    CardHandler localCardHandler = (CardHandler)this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
    if (localCardHandler != null)
    {
      localCardHandler.k();
      localCardHandler.i();
      localCardHandler.j();
    }
  }
  
  private void b(int paramInt)
  {
    Object localObject = (FriendListHandler)this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().o();
    this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().c();
    D();
    ((DiscussionHandler)this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).b();
    ((FriendsManager)this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b();
    ((IQQAvatarHandlerService)this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQQAvatarHandlerService.class, "")).notifySyncQQHead();
    ((FriendListHandler)localObject).notifySyncSignature();
    this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a(this.mAutomator.b ^ true, this.mAutomator.c ^ true);
    this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a.b();
    this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().l();
    if (QZoneHelper.hideQzoneStatusInConverstation()) {
      QLog.i("QQInitHandler", 2, "updateQzoneFeeds 下发配置隐藏新动态");
    } else {
      ((FeedsManager)this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QZONE_NEW_STATUS_MANAGER)).updateQzoneFeeds();
    }
    ((IReadInJoySPEventReport)QRoute.api(IReadInJoySPEventReport.class)).reportAfterSyncMsg(this.mStepId);
    localObject = (IPhoneContactService)this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPhoneContactService.class, "");
    boolean bool1;
    if (paramInt == 22) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((IPhoneContactService)localObject).onStepAction(bool1);
    try
    {
      localObject = (AccessibilityManager)this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSystemService("accessibility");
      bool1 = ((AccessibilityManager)localObject).isEnabled();
      boolean bool2 = ((AccessibilityManager)localObject).isTouchExplorationEnabled();
      if ((bool1) && (bool2))
      {
        localObject = BaseApplicationImpl.getApplication();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Talkback");
        localStringBuilder.append(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
        localObject = ((BaseApplicationImpl)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
        long l = ((SharedPreferences)localObject).getLong("ReportTime", 0L);
        if (System.currentTimeMillis() - l > 86400000L)
        {
          ReportController.b(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A4C7", "0X800A4C7", 0, 0, "", "0", "", "");
          ((SharedPreferences)localObject).edit().putLong("ReportTime", System.currentTimeMillis()).commit();
        }
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQInitHandler", 1, localThrowable, new Object[0]);
    }
    ThreadManager.getSubThreadHandler().postDelayed(new AfterSyncMsg.7(this), 30000L);
  }
  
  private void c()
  {
    ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).getSelfAddFriendSetting(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  private void d()
  {
    ArResourceManager localArResourceManager = (ArResourceManager)this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.AR_RESOURCE_MANAGER);
    if (localArResourceManager != null) {
      localArResourceManager.a(true, false);
    }
  }
  
  private void e()
  {
    if (DeviceOptSwitch.jdField_d_of_type_Boolean) {
      try
      {
        Thread.sleep(1500L);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
  
  private void f()
  {
    QLog.d("QQInitHandler", 1, "call doAfterLogin");
    new RecentUserCacheHelper().a(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    PushNoticeUtil.a();
    Object localObject1 = VFSRegisterProxy.a();
    Object localObject2 = BaseApplicationImpl.sApplication;
    ReportCallback localReportCallback = ReportCallback.a();
    boolean bool;
    if (BaseApplicationImpl.sProcessId == 1) {
      bool = true;
    } else {
      bool = false;
    }
    ((VFSRegisterProxy)localObject1).b((Context)localObject2, localReportCallback, bool, false);
    VFSRegisterProxy.a().a(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    ThreadManager.getSubThreadHandler().post(new AfterSyncMsg.1(this));
    UnifiedMonitor.a(SQLiteOpenHelper.WAL_ENABLE);
    DropFrameMonitor.a();
    this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().a();
    this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().init_lazy();
    this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCacheManager().initLazy();
    this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.initSecureFileFramework();
    this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(0, false);
    ((FlashChatManager)this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).a();
    s();
    C();
    e();
    this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getDatalineMsgDBTransformer().a();
    ((ISVIPHandler)this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a();
    this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isStartSyncOnlineFriend = true;
    this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.syncOnlineFriend();
    this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addManager(false);
    B();
    r();
    A();
    b(22);
    ((EqqDetailDataManager)this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EQQ_DETAIL_DATA_MANAGER)).a();
    p();
    ((IPublicAccountDataManager)this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPublicAccountDataManager.class, "all")).initPublicAccountDataManager();
    ((IPublicAccountSearchRecommendManager)QRoute.api(IPublicAccountSearchRecommendManager.class)).initFromLocalData(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLIC_ACCOUNT_ENTITY_HELPER);
    q();
    o();
    e();
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getServiceAccountFolderConfigData(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).loadPublicAccountCenterUrlConfig(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getPublicAccountCenterUrlConfigData(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
    this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().q();
    this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().l();
    SQLiteFTSUtils.b();
    SQLiteFTSUtils.a(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    ((IPublicAccountReportManager)this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPublicAccountReportManager.class, "all")).scheduleReport();
    localObject1 = (PhoneUnityManager)this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PHONE_UNITY_MANAGER);
    ((PhoneUnityManager)localObject1).b();
    localObject2 = (IPasswdRedBagService)this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPasswdRedBagService.class);
    ((IPasswdRedBagService)localObject2).loadRedBagInfoToCache(false);
    ((IPasswdRedBagService)localObject2).loadRedBagRelationToCache();
    ((IPasswdRedBagService)localObject2).requestPasswdRedBagByDisgroups();
    ((IPasswdRedBagService)localObject2).requestPasswdRedBagByGroups();
    ((TroopTipsMsgMgr)this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_TIPS_MSG_MANAGER)).a(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    a("checkDelAbnormalLocalTroopMsg afterLogin");
    this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBrowserFontSetting();
    AIOConfigManager.a(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    FightReporter.a();
    FightReporter.b();
    FightReporter.e();
    k();
    j();
    FDStats.a().a();
    TombLogRecordHelper.a();
    PatternLockUtils.syncQWalletPatternLock(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if ((this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isCreateManager(QQManagerFactory.MGR_PLUGIN))) {
      ((IQWalletHelper)QRoute.api(IQWalletHelper.class)).getPayCode(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    ((IHippyAccessHelper)QRoute.api(IHippyAccessHelper.class)).doAfterLogin();
    n();
    m();
    e();
    ((FriendsManager)this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(true);
    ((INewFriendService)this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(INewFriendService.class)).initNewFriendList();
    localObject2 = (QQAppInterface)((IRIJRuntimeUtils)QRoute.api(IRIJRuntimeUtils.class)).getAppRuntime();
    if (localObject2 != null) {
      ((IKanDianMergeManager)((QQAppInterface)localObject2).getRuntimeService(IKanDianMergeManager.class)).doSomeInitJobAfterLogin();
    }
    ((ConfigHandler)this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)).f();
    l();
    w();
    this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRecentUserProxy().c();
    this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.GAME_CENTER_MSG_MANAGER);
    ((FlashChatManager)this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).c();
    ((ITroopAioAppService)this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(ITroopAioAppService.class, "")).afterUserLogin();
    NotifyIdManager.a(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b();
    a(1);
    VACDReportUtil.a();
    ((IPreDownloadController)this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IPreDownloadController.class)).startPreDownload();
    QuicResDownload.a(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    ((TimJumpLoginManager)this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TIM_JUMP_LOGIN_MANAGER)).a();
    localObject2 = (TempGetProfileDetailProcessor)ProfileServiceUtils.getBusinessProcessor(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, TempGetProfileDetailProcessor.class);
    if (localObject2 != null) {
      ((TempGetProfileDetailProcessor)localObject2).getOfficeUserFlag();
    }
    ((IOfflineUtils)QRoute.api(IOfflineUtils.class)).preCache(false);
    v();
    ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startOfficialLocation();
    FreeWifiHelper.a(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    d.a();
    QCC.a();
    QQAppInterface.initHeadCfg();
    u();
    AioPanelMiniAppManager.a(((PhoneUnityManager)localObject1).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
    c();
    b();
    x();
    ((IStickerRecManager)this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IStickerRecManager.class)).pullWords();
    ((IStickerRecManager)this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IStickerRecManager.class)).clearOverdueStickerCache();
    NotificationReportUtil.reportAll();
    e();
    y();
    z();
    ((ITeamWorkUtilsTemp)QRoute.api(ITeamWorkUtilsTemp.class)).scheduleAddTDFileMessageRecord(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    t();
    ThreadManager.getFileThreadHandler().post(new AfterSyncMsg.2(this));
    E();
    ((IOnlineStatusService)this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IOnlineStatusService.class)).registerBatteryBroadcastReceiver();
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).setAfterSyncMsg(true);
    ((ColorNoteHandler)this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.COLOR_NOTE_HANDLER)).a();
    CTEntryMng.a(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Reporter.a(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    FrontBackReportManager.a(true);
    DtSdkInitStep.a();
    TroopRedTouchHandler.a(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
    TroopBlockUtils.a(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    ((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).initAndStartRecord("firstInit");
    h();
    g();
    i();
    ((IWSManager)QRoute.api(IWSManager.class)).doAfterSyncMsg();
    GdtAppPreOrderUtil.a();
    ((IHippyUpdate)QRoute.api(IHippyUpdate.class)).preDownloadHippyByController(1);
    ((IGameMsgUnissoHandlerApi)QRoute.api(IGameMsgUnissoHandlerApi.class)).getGameMsgTabConfig();
  }
  
  private void g()
  {
    if (QQDtReportHelper.jdField_a_of_type_Boolean)
    {
      if (GuardManager.a != null) {
        GuardManager.a.b(BaseApplicationImpl.processName);
      }
      QQDtReportHelper.a();
      QQDtReportHelper.jdField_a_of_type_Boolean = false;
      QLog.d("QQInitHandler", 1, "848QQDT [doAfterLogin] report");
    }
  }
  
  private void h()
  {
    if (this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      ((AlphabeticFontHandler)this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TEENS_MODE_ALPHABETIC_FONT_HANDLER)).a();
    }
  }
  
  private void i()
  {
    if (this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      ((NewerGuideBannerManager)this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEWER_GUIDE_BANNER_MANAGER)).a();
    }
  }
  
  private void j()
  {
    if (!DeviceOptSwitch.b)
    {
      ((IFTSTroopInterface)((IFTSDBRuntimeService)this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IFTSDBRuntimeService.class, "")).getOperator(2)).a();
      return;
    }
    DeviceOptSwitch.jdField_d_of_type_Long = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("Perf", 2, "delay checkTroopTimeStamp");
    }
  }
  
  private void k()
  {
    SearchConfigManager.a(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("troopMemberUpdateConfigStr=");
      localStringBuilder.append(SearchConfigManager.troopMemberUpdateConfigStr);
      QLog.d("Q.fts", 2, localStringBuilder.toString());
    }
  }
  
  private void l()
  {
    IUserOperationModule localIUserOperationModule = (IUserOperationModule)QRoute.api(IUserOperationModule.class);
    if (localIUserOperationModule != null) {
      localIUserOperationModule.getKandianTopFromServer(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    }
  }
  
  private void m()
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler_PushOpenNotify", 2, "doafterlogin");
      }
      new MsgNotifyPushDialog.PopOpenMsgNotifationTask(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).execute(new Void[0]);
    }
  }
  
  private void n()
  {
    ClassicHeadActivityManager localClassicHeadActivityManager = (ClassicHeadActivityManager)this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CLASSIC_HEAD_ACIVITY_MANAGER);
    if ((localClassicHeadActivityManager != null) && (localClassicHeadActivityManager.a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 4, " QQ 18 handle actionB cached stranger head update in AfterSyncMsg doAfterLogin");
      }
      localClassicHeadActivityManager.b();
    }
  }
  
  private void o()
  {
    ActivateFriendsManager localActivateFriendsManager = (ActivateFriendsManager)this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS);
    if (localActivateFriendsManager != null) {
      localActivateFriendsManager.a();
    }
  }
  
  private void p()
  {
    ThreadManager.getSubThreadHandler().post(new AfterSyncMsg.3(this));
  }
  
  private void q()
  {
    AdvertisementVideoPreloadManager localAdvertisementVideoPreloadManager = (AdvertisementVideoPreloadManager)this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLIC_ACCOUNT_VIDEO_PRELOAD_MANAGER);
    if (localAdvertisementVideoPreloadManager != null)
    {
      if (!"5.0.2".equals(Build.VERSION.RELEASE)) {
        localAdvertisementVideoPreloadManager.a();
      }
      localAdvertisementVideoPreloadManager.a(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    }
    ImaxAdVideoPreloadManager localImaxAdVideoPreloadManager = (ImaxAdVideoPreloadManager)this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.IMAX_AD_VIDEO_PRELOAD_MANAGER);
    if (localAdvertisementVideoPreloadManager != null) {
      localImaxAdVideoPreloadManager.a(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    }
  }
  
  private void r()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, new Object[] { "AfterSyncMsg sendEmptyMessageDelayedToHandler MSG_INIT_MSGTAG_STORY process, send, ", Boolean.valueOf(this.mAutomator.b()) });
    }
    MqqHandler localMqqHandler = this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
    localMqqHandler.sendEmptyMessage(1055);
    localMqqHandler.sendEmptyMessage(1059);
    localMqqHandler.sendEmptyMessage(1061);
  }
  
  private void s()
  {
    Object localObject = this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getSharedPreferences(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
    long l = ((SharedPreferences)localObject).getLong("sp_vip_info_request_time", 0L);
    int i = ((SharedPreferences)localObject).getInt("sp_vip_info_update_freq", 10);
    if (NetConnInfoCenter.getServerTime() - l > i * 60)
    {
      localObject = this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      String str = ((TicketManager)this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2)).getSkey((String)localObject);
      ((VipInfoHandler)this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.VIPINFO_HANDLER)).a(str, (String)localObject);
    }
  }
  
  private void t()
  {
    ThreadManager.executeOnSubThread(new AfterSyncMsg.4(this));
  }
  
  private void u()
  {
    RecentDataListManager.a().a(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.sApplication, true, false);
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "doAfterLogin call MayknowRecommendManager.getMayKnowRecommendRemote ");
    }
    ((MayknowRecommendManager)this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).a(1);
  }
  
  private void v()
  {
    ThreadManager.executeOnSubThread(new AfterSyncMsg.5(this));
  }
  
  private void w()
  {
    List localList = ((ProxyManager)this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PROXY_MANAGER)).a().a(true);
    int i = 0;
    while (i < localList.size())
    {
      if (((RecentUser)localList.get(i)).lFlag == 16L)
      {
        Iterator localIterator = this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(((RecentUser)localList.get(i)).uin, ((RecentUser)localList.get(i)).getType()).iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (MessageRecord)localIterator.next();
          localObject = PublicAccountAdUtil.a(this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject, true);
          if (localObject != null) {
            AdvertisementRecentUserManager.a().a((AdvertisementItem)localObject);
          }
        }
      }
      i += 1;
    }
  }
  
  private void x()
  {
    ((IArkService)this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IArkService.class, "")).startPreloadApp();
  }
  
  private void y()
  {
    ((TroopAioNavigateBarManager)this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_AIO_NAVIGATE_BAR)).a();
    MqqHandler localMqqHandler = this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(1134064).sendToTarget();
    }
  }
  
  private void z()
  {
    if (QZoneUnreadServletLogic.a(1, BaseApplicationImpl.processName)) {
      try
      {
        long l1 = System.currentTimeMillis();
        Object localObject = BaseActivity.sTopActivity;
        RecordManager.getInstance().setRecentActivityName((Activity)localObject);
        RecordTracer.a().step();
        long l2 = System.currentTimeMillis();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("conversation time ");
        ((StringBuilder)localObject).append(l2 - l1);
        QLog.d("RecordTracer", 2, ((StringBuilder)localObject).toString());
        return;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("EventCon setUserId failed:");
          localStringBuilder.append(localException.getMessage());
          QLog.d("RecordTracer", 2, localStringBuilder.toString());
        }
      }
    }
  }
  
  protected int doStep()
  {
    switch (this.mStepId)
    {
    default: 
      this.mAutomator.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().c(false);
      this.mAutomator.notifyUI(6008, false, null, true);
      break;
    case 24: 
      b(this.mStepId);
      break;
    case 23: 
      a();
      break;
    case 22: 
      f();
      ReporterMachine.a().a();
      UnifiedMonitor.a().c();
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.AfterSyncMsg
 * JD-Core Version:    0.7.0.1
 */
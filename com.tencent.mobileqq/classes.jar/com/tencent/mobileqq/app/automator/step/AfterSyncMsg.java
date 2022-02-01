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
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager;
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
import com.tencent.mobileqq.app.PrivacyPolicyHelper;
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
import com.tencent.mobileqq.guild.api.IGuildHandlerNameApi;
import com.tencent.mobileqq.guild.message.api.IGuildPushMessageHandler;
import com.tencent.mobileqq.guild.message.api.IGuildSendMessageHandler;
import com.tencent.mobileqq.guild.message.eventflow.IGuildEventFlowHandler;
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
import com.tencent.mobileqq.persistence.backup.IDBBackupService;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.profilecard.processor.TempGetProfileDetailProcessor;
import com.tencent.mobileqq.profilecard.utils.ProfileServiceUtils;
import com.tencent.mobileqq.pushnotice.ThirdPushManager;
import com.tencent.mobileqq.qassistant.api.IVoiceAssistantMain;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.config.IQWalletConfigService;
import com.tencent.mobileqq.qwallet.hb.aio.passwd.IPasswdRedBagService;
import com.tencent.mobileqq.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.search.base.util.SearchConfigManager;
import com.tencent.mobileqq.service.qzone.QZoneUnreadServletLogic;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.startup.director.StartupDirector;
import com.tencent.mobileqq.startup.step.DtSdkInitStep;
import com.tencent.mobileqq.startup.step.RecordTracer;
import com.tencent.mobileqq.statistics.FDStats;
import com.tencent.mobileqq.statistics.FightReporter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector;
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
import com.tencent.mobileqq.util.TuringSdkManager;
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
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;

public class AfterSyncMsg
  extends AsyncStep
{
  private void A()
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
  
  private void B()
  {
    if (NetUtil.a(this.mAutomator.k.getApp()) != 2) {
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).preloadMiniProcess();
    }
  }
  
  private void C()
  {
    if (this.mAutomator.e) {
      ((ITroopListHandler)this.mAutomator.k.getBusinessHandler(BusinessHandlerFactory.TROOP_LIST_HANDLER)).b();
    }
  }
  
  private void D()
  {
    PayRuleCfg localPayRuleCfg = VipInfoHandler.a(this.mAutomator.k.getCurrentUin());
    if (VipInfoHandler.a(this.mAutomator.k, localPayRuleCfg, true)) {
      ThreadManagerV2.getUIHandlerV2().post(new AfterSyncMsg.6(this));
    }
  }
  
  private void E()
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
    Object localObject1 = this.mAutomator.d;
    int i = 0;
    if (((SharedPreferences)localObject1).getBoolean("isConvertOldQQHeadOK", false)) {
      return;
    }
    Hashtable localHashtable = new Hashtable();
    EntityManager localEntityManager = this.mAutomator.k.getEntityManagerFactory().createEntityManager();
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
              break label444;
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
          String str1 = this.mAutomator.k.getOldCustomFaceFilePath(j, (String)localObject1);
          String str2 = this.mAutomator.k.getCustomFaceFilePath((Setting)localObject2, j, (String)localObject1, 0, 0);
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
        label444:
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
    this.mAutomator.d.edit().putBoolean("isConvertOldQQHeadOK", true).commit();
  }
  
  private void F()
  {
    if ((this.mAutomator != null) && (this.mAutomator.k != null))
    {
      new CheckLoveStateRequestManager().a(Long.parseLong(this.mAutomator.k.getCurrentAccountUin()));
      return;
    }
    QLog.i("QQInitHandler", 1, "ChkeckLoveStateRequest diden`t send");
  }
  
  private void a()
  {
    C();
    ((FriendListHandler)this.mAutomator.k.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getSelfXManInfo();
    b(23);
    d();
    PromotionUtil.c(this.mAutomator.k);
    AROnlineVideoUtil.a(BaseApplicationImpl.getContext(), this.mAutomator.k);
    this.mAutomator.k.getMessageFacade().D();
    ((IPublicAccountReportManager)this.mAutomator.k.getRuntimeService(IPublicAccountReportManager.class, "all")).scheduleReport();
    PatternLockUtils.syncQWalletPatternLock(this.mAutomator.k);
    a("checkDelAbnormalLocalTroopMsg onReconnect");
    int i = NetworkUtil.getSystemNetwork(BaseApplicationImpl.getApplication());
    if ((i == 1) || (i == 3) || (i == 4)) {
      ((BlessManager)this.mAutomator.k.getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).E();
    }
    if (i == 1) {
      ((PhotoPlusManager)this.mAutomator.k.getManager(QQManagerFactory.PHOTO_PLUS_MANAGER)).a(false);
    }
    PatchConfigServlet.a(this.mAutomator.k, this.mAutomator.k.getCurrentAccountUin(), -1, "doOnReconnect");
    if ((this.mAutomator.k != null) && (this.mAutomator.k.isCreateManager(QQManagerFactory.MGR_PLUGIN))) {
      ((IQWalletHelper)QRoute.api(IQWalletHelper.class)).getPayCode(this.mAutomator.k);
    }
    if (Math.abs(System.currentTimeMillis() - AEOldShortVideoResManager.a) > 3600000L) {
      AEOldShortVideoResManager.a(this.mAutomator.k, 2);
    }
    if (Math.abs(System.currentTimeMillis() - ShortVideoResourceManager.a) > 3600000L) {
      ShortVideoResourceManager.a(this.mAutomator.k, 2);
    } else {
      QLog.d("ShortVideoResourceManager", 1, "[network]not need get config...");
    }
    Object localObject = (ClassicHeadActivityManager)this.mAutomator.k.getManager(QQManagerFactory.CLASSIC_HEAD_ACIVITY_MANAGER);
    if ((localObject != null) && (((ClassicHeadActivityManager)localObject).a()))
    {
      localObject = (TempGetProfileDetailProcessor)ProfileServiceUtils.getBusinessProcessor(this.mAutomator.k, TempGetProfileDetailProcessor.class);
      if (localObject != null) {
        ((TempGetProfileDetailProcessor)localObject).getClassicHeadActivityParams();
      }
    }
    a(2);
    ((SpringFestivalRedpacketConfigManager)this.mAutomator.k.getManager(QQManagerFactory.SPRING_FESTIVAL_RED_PACKET_MANAGER)).b(this.mAutomator.k, 1);
    QQAppInterface.initHeadCfg();
    c();
    b();
    ((IStickerRecManager)this.mAutomator.k.getRuntimeService(IStickerRecManager.class)).pullWords();
    ((IReadInJoySpEventReportUtil)QRoute.api(IReadInJoySpEventReportUtil.class)).init();
    u();
    StudyModeManager.a();
  }
  
  private void a(int paramInt)
  {
    IQWalletConfigService localIQWalletConfigService = (IQWalletConfigService)this.mAutomator.k.getRuntimeService(IQWalletConfigService.class, "");
    if (localIQWalletConfigService != null) {
      localIQWalletConfigService.tryGetConfig(paramInt);
    }
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.del_abnormal_troop_local_msg", 2, paramString);
    }
    this.mAutomator.k.getMsgHandler().G();
  }
  
  private void b()
  {
    CardHandler localCardHandler = (CardHandler)this.mAutomator.k.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
    if (localCardHandler != null)
    {
      localCardHandler.m();
      localCardHandler.k();
      localCardHandler.l();
    }
  }
  
  private void b(int paramInt)
  {
    Object localObject = (FriendListHandler)this.mAutomator.k.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    this.mAutomator.k.getMsgHandler().u();
    this.mAutomator.k.getMsgHandler().f();
    E();
    c(paramInt);
    ((DiscussionHandler)this.mAutomator.k.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).c();
    ((FriendsManager)this.mAutomator.k.getManager(QQManagerFactory.FRIENDS_MANAGER)).c();
    ((IQQAvatarHandlerService)this.mAutomator.k.getRuntimeService(IQQAvatarHandlerService.class, "")).notifySyncQQHead();
    ((FriendListHandler)localObject).notifySyncSignature();
    this.mAutomator.k.getMsgHandler().a(this.mAutomator.f ^ true, this.mAutomator.g ^ true);
    this.mAutomator.k.getMsgHandler().e.b();
    this.mAutomator.k.getMessageFacade().D();
    if (QZoneHelper.hideQzoneStatusInConverstation()) {
      QLog.i("QQInitHandler", 2, "updateQzoneFeeds 下发配置隐藏新动态");
    } else {
      ((FeedsManager)this.mAutomator.k.getManager(QQManagerFactory.QZONE_NEW_STATUS_MANAGER)).updateQzoneFeeds();
    }
    ((IReadInJoySPEventReport)QRoute.api(IReadInJoySPEventReport.class)).reportAfterSyncMsg(this.mStepId);
    localObject = (IPhoneContactService)this.mAutomator.k.getRuntimeService(IPhoneContactService.class, "");
    boolean bool1;
    if (paramInt == 22) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    ((IPhoneContactService)localObject).onStepAction(bool1);
    try
    {
      localObject = (AccessibilityManager)this.mAutomator.k.getApp().getSystemService("accessibility");
      bool1 = ((AccessibilityManager)localObject).isEnabled();
      boolean bool2 = ((AccessibilityManager)localObject).isTouchExplorationEnabled();
      if ((bool1) && (bool2))
      {
        localObject = BaseApplicationImpl.getApplication();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Talkback");
        localStringBuilder.append(this.mAutomator.k.getCurrentAccountUin());
        localObject = ((BaseApplicationImpl)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
        long l = ((SharedPreferences)localObject).getLong("ReportTime", 0L);
        if (System.currentTimeMillis() - l > 86400000L)
        {
          ReportController.b(this.mAutomator.k, "dc00898", "", "", "0X800A4C7", "0X800A4C7", 0, 0, "", "0", "", "");
          ((SharedPreferences)localObject).edit().putLong("ReportTime", System.currentTimeMillis()).commit();
          return;
        }
      }
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QQInitHandler", 1, localThrowable, new Object[0]);
    }
  }
  
  private void c()
  {
    ((IAddFriendApi)QRoute.api(IAddFriendApi.class)).getSelfAddFriendSetting(this.mAutomator.k);
  }
  
  private void c(int paramInt)
  {
    ((IGuildPushMessageHandler)this.mAutomator.k.getBusinessHandler(((IGuildHandlerNameApi)QRoute.api(IGuildHandlerNameApi.class)).getGuildPushMsgHandlerName())).a();
    IGuildEventFlowHandler localIGuildEventFlowHandler = (IGuildEventFlowHandler)this.mAutomator.k.getBusinessHandler(((IGuildHandlerNameApi)QRoute.api(IGuildHandlerNameApi.class)).getGuildMessageEventHandlerName());
    boolean bool;
    if (paramInt == 23) {
      bool = true;
    } else {
      bool = false;
    }
    localIGuildEventFlowHandler.a(bool);
    ((IGuildSendMessageHandler)this.mAutomator.k.getBusinessHandler(((IGuildHandlerNameApi)QRoute.api(IGuildHandlerNameApi.class)).getGuildSendMsgHandlerName())).b();
  }
  
  private void d()
  {
    ArResourceManager localArResourceManager = (ArResourceManager)this.mAutomator.k.getManager(QQManagerFactory.AR_RESOURCE_MANAGER);
    if (localArResourceManager != null) {
      localArResourceManager.a(true, false);
    }
  }
  
  private void e()
  {
    if (DeviceOptSwitch.e) {
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
    new RecentUserCacheHelper().a(this.mAutomator.k);
    ThirdPushManager.a().c();
    Object localObject1 = VFSRegisterProxy.a();
    Object localObject2 = BaseApplicationImpl.sApplication;
    ReportCallback localReportCallback = ReportCallback.b();
    boolean bool;
    if (BaseApplicationImpl.sProcessId == 1) {
      bool = true;
    } else {
      bool = false;
    }
    ((VFSRegisterProxy)localObject1).b((Context)localObject2, localReportCallback, bool, false);
    VFSRegisterProxy.a().a(this.mAutomator.k.getCurrentAccountUin());
    ThreadManager.getSubThreadHandler().post(new AfterSyncMsg.1(this));
    UnifiedMonitor.a(SQLiteOpenHelper.WAL_ENABLE);
    DropFrameMonitor.a();
    this.mAutomator.k.getProxyManager().a().a();
    this.mAutomator.k.getProxyManager().init_lazy();
    this.mAutomator.k.getCacheManager().initLazy();
    this.mAutomator.k.initSecureFileFramework();
    this.mAutomator.k.getMessageFacade().a(0, false);
    ((FlashChatManager)this.mAutomator.k.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).c();
    t();
    D();
    e();
    this.mAutomator.k.getDatalineMsgDBTransformer().a();
    ((ISVIPHandler)this.mAutomator.k.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a();
    this.mAutomator.k.isStartSyncOnlineFriend = true;
    this.mAutomator.k.syncOnlineFriend();
    this.mAutomator.k.addManager(false);
    C();
    s();
    B();
    b(22);
    ((EqqDetailDataManager)this.mAutomator.k.getManager(QQManagerFactory.EQQ_DETAIL_DATA_MANAGER)).a();
    q();
    ((IPublicAccountDataManager)this.mAutomator.k.getRuntimeService(IPublicAccountDataManager.class, "all")).initPublicAccountDataManager();
    ((IPublicAccountSearchRecommendManager)QRoute.api(IPublicAccountSearchRecommendManager.class)).initFromLocalData(this.mAutomator.k);
    this.mAutomator.k.getManager(QQManagerFactory.PUBLIC_ACCOUNT_ENTITY_HELPER);
    r();
    p();
    e();
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getServiceAccountFolderConfigData(this.mAutomator.k);
    ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).loadPublicAccountCenterUrlConfig(this.mAutomator.k, ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getPublicAccountCenterUrlConfigData(this.mAutomator.k));
    this.mAutomator.k.getMsgHandler().F();
    this.mAutomator.k.getMessageFacade().D();
    SQLiteFTSUtils.b();
    SQLiteFTSUtils.a(this.mAutomator.k);
    ((IPublicAccountReportManager)this.mAutomator.k.getRuntimeService(IPublicAccountReportManager.class, "all")).scheduleReport();
    localObject1 = (PhoneUnityManager)this.mAutomator.k.getManager(QQManagerFactory.PHONE_UNITY_MANAGER);
    ((PhoneUnityManager)localObject1).d();
    localObject2 = (IPasswdRedBagService)this.mAutomator.k.getRuntimeService(IPasswdRedBagService.class);
    ((IPasswdRedBagService)localObject2).loadRedBagInfoToCache(false);
    ((IPasswdRedBagService)localObject2).loadRedBagRelationToCache();
    ((TroopTipsMsgMgr)this.mAutomator.k.getManager(QQManagerFactory.TROOP_TIPS_MSG_MANAGER)).a(this.mAutomator.k);
    a("checkDelAbnormalLocalTroopMsg afterLogin");
    this.mAutomator.k.getBrowserFontSetting();
    AIOConfigManager.a(this.mAutomator.k);
    FightReporter.a();
    FightReporter.b();
    FightReporter.e();
    l();
    k();
    FDStats.a().b();
    TombLogRecordHelper.a();
    PatternLockUtils.syncQWalletPatternLock(this.mAutomator.k);
    if ((this.mAutomator.k != null) && (this.mAutomator.k.isCreateManager(QQManagerFactory.MGR_PLUGIN))) {
      ((IQWalletHelper)QRoute.api(IQWalletHelper.class)).getPayCode(this.mAutomator.k);
    }
    ((IHippyAccessHelper)QRoute.api(IHippyAccessHelper.class)).doAfterLogin();
    o();
    n();
    e();
    ((FriendsManager)this.mAutomator.k.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(true);
    ((INewFriendService)this.mAutomator.k.getRuntimeService(INewFriendService.class)).initNewFriendList();
    localObject2 = (QQAppInterface)((IRIJRuntimeUtils)QRoute.api(IRIJRuntimeUtils.class)).getAppRuntime();
    if (localObject2 != null) {
      ((IKanDianMergeManager)((QQAppInterface)localObject2).getRuntimeService(IKanDianMergeManager.class)).doSomeInitJobAfterLogin();
    }
    ((ConfigHandler)this.mAutomator.k.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)).n();
    m();
    x();
    this.mAutomator.k.getRecentUserProxy().d();
    this.mAutomator.k.getManager(QQManagerFactory.GAME_CENTER_MSG_MANAGER);
    ((FlashChatManager)this.mAutomator.k.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).f();
    ((ITroopAioAppService)this.mAutomator.k.getRuntimeService(ITroopAioAppService.class, "")).afterUserLogin();
    NotifyIdManager.a(this.mAutomator.k).d();
    a(1);
    VACDReportUtil.a();
    ((IPreDownloadController)this.mAutomator.k.getRuntimeService(IPreDownloadController.class)).startPreDownload();
    QuicResDownload.a(this.mAutomator.k);
    ((TimJumpLoginManager)this.mAutomator.k.getManager(QQManagerFactory.TIM_JUMP_LOGIN_MANAGER)).a();
    localObject2 = (TempGetProfileDetailProcessor)ProfileServiceUtils.getBusinessProcessor(this.mAutomator.k, TempGetProfileDetailProcessor.class);
    if (localObject2 != null) {
      ((TempGetProfileDetailProcessor)localObject2).getOfficeUserFlag();
    }
    ((IOfflineUtils)QRoute.api(IOfflineUtils.class)).preCache(false);
    w();
    FreeWifiHelper.a(this.mAutomator.k);
    d.a();
    QCC.a();
    QQAppInterface.initHeadCfg();
    v();
    AioPanelMiniAppManager.a(((PhoneUnityManager)localObject1).d).a();
    c();
    b();
    y();
    ((IStickerRecManager)this.mAutomator.k.getRuntimeService(IStickerRecManager.class)).pullWords();
    ((IStickerRecManager)this.mAutomator.k.getRuntimeService(IStickerRecManager.class)).clearOverdueStickerCache();
    NotificationReportUtil.reportAll();
    e();
    z();
    A();
    ((ITeamWorkUtilsTemp)QRoute.api(ITeamWorkUtilsTemp.class)).scheduleAddTDFileMessageRecord(this.mAutomator.k);
    u();
    ThreadManager.getFileThreadHandler().post(new AfterSyncMsg.2(this));
    F();
    ((IOnlineStatusService)this.mAutomator.k.getRuntimeService(IOnlineStatusService.class)).registerBatteryBroadcastReceiver();
    ((IColorNoteUtil)QRoute.api(IColorNoteUtil.class)).setAfterSyncMsg(true);
    ((ColorNoteHandler)this.mAutomator.k.getBusinessHandler(BusinessHandlerFactory.COLOR_NOTE_HANDLER)).a();
    CTEntryMng.a(this.mAutomator.k);
    Reporter.a(this.mAutomator.k);
    DtSdkInitStep.c();
    TroopRedTouchHandler.a(this.mAutomator.k, true);
    TroopBlockUtils.a(this.mAutomator.k);
    ((IVoiceAssistantMain)QRoute.api(IVoiceAssistantMain.class)).initAndStartRecord("firstInit");
    i();
    h();
    j();
    ((IWSManager)QRoute.api(IWSManager.class)).doAfterSyncMsg();
    GdtAppPreOrderUtil.b();
    ((IHippyUpdate)QRoute.api(IHippyUpdate.class)).preDownloadHippyByController(1, 10097);
    ((IGameMsgUnissoHandlerApi)QRoute.api(IGameMsgUnissoHandlerApi.class)).getGameMsgTabConfig();
    ((IGameMsgBoxManager)this.mAutomator.k.getRuntimeService(IGameMsgBoxManager.class)).fetchRecentGameContacts(true, null);
    g();
    ((IDBBackupService)QRoute.api(IDBBackupService.class)).backupDBMaster();
    ((TuringSdkManager)this.mAutomator.k.getManager(QQManagerFactory.TURINGSDK_MANAGER)).a(PrivacyPolicyHelper.d(), true);
  }
  
  private void g()
  {
    if (StartupDirector.d)
    {
      AppRuntime localAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
      if (localAppRuntime == null) {
        return;
      }
      StartupDirector.d = false;
      StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(localAppRuntime.getCurrentUin(), "StartupMainApplicationCreate", true, 0L, 0L, new HashMap(), "");
    }
  }
  
  private void h()
  {
    if (QQDtReportHelper.a)
    {
      if (GuardManager.sInstance != null) {
        GuardManager.sInstance.reportForegroundEvent(BaseApplicationImpl.processName);
      }
      QQDtReportHelper.a();
      QQDtReportHelper.a = false;
      QLog.d("QQInitHandler", 1, "848QQDT [doAfterLogin] report");
    }
  }
  
  private void i()
  {
    if (this.mAutomator.k != null) {
      ((AlphabeticFontHandler)this.mAutomator.k.getBusinessHandler(BusinessHandlerFactory.TEENS_MODE_ALPHABETIC_FONT_HANDLER)).a();
    }
  }
  
  private void j()
  {
    if (this.mAutomator.k != null) {
      ((NewerGuideBannerManager)this.mAutomator.k.getManager(QQManagerFactory.NEWER_GUIDE_BANNER_MANAGER)).a();
    }
  }
  
  private void k()
  {
    if (!DeviceOptSwitch.c)
    {
      ((IFTSTroopInterface)((IFTSDBRuntimeService)this.mAutomator.k.getRuntimeService(IFTSDBRuntimeService.class, "")).getOperator(2)).a();
      return;
    }
    DeviceOptSwitch.o = System.currentTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("Perf", 2, "delay checkTroopTimeStamp");
    }
  }
  
  private void l()
  {
    SearchConfigManager.a(this.mAutomator.k);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("troopMemberUpdateConfigStr=");
      localStringBuilder.append(SearchConfigManager.troopMemberUpdateConfigStr);
      QLog.d("Q.fts", 2, localStringBuilder.toString());
    }
  }
  
  private void m()
  {
    IUserOperationModule localIUserOperationModule = (IUserOperationModule)QRoute.api(IUserOperationModule.class);
    if (localIUserOperationModule != null) {
      localIUserOperationModule.getKandianTopFromServer(this.mAutomator.k.getCurrentUin());
    }
  }
  
  private void n()
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler_PushOpenNotify", 2, "doafterlogin");
      }
      new MsgNotifyPushDialog.PopOpenMsgNotifationTask(this.mAutomator.k).execute(new Void[0]);
    }
  }
  
  private void o()
  {
    ClassicHeadActivityManager localClassicHeadActivityManager = (ClassicHeadActivityManager)this.mAutomator.k.getManager(QQManagerFactory.CLASSIC_HEAD_ACIVITY_MANAGER);
    if ((localClassicHeadActivityManager != null) && (localClassicHeadActivityManager.a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 4, " QQ 18 handle actionB cached stranger head update in AfterSyncMsg doAfterLogin");
      }
      localClassicHeadActivityManager.e();
    }
  }
  
  private void p()
  {
    ActivateFriendsManager localActivateFriendsManager = (ActivateFriendsManager)this.mAutomator.k.getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS);
    if (localActivateFriendsManager != null) {
      localActivateFriendsManager.a();
    }
  }
  
  private void q()
  {
    ThreadManager.getSubThreadHandler().post(new AfterSyncMsg.3(this));
  }
  
  private void r()
  {
    AdvertisementVideoPreloadManager localAdvertisementVideoPreloadManager = (AdvertisementVideoPreloadManager)this.mAutomator.k.getManager(QQManagerFactory.PUBLIC_ACCOUNT_VIDEO_PRELOAD_MANAGER);
    if (localAdvertisementVideoPreloadManager != null)
    {
      if (!"5.0.2".equals(Build.VERSION.RELEASE)) {
        localAdvertisementVideoPreloadManager.a();
      }
      localAdvertisementVideoPreloadManager.a(this.mAutomator.k.getCurrentUin());
    }
    ImaxAdVideoPreloadManager localImaxAdVideoPreloadManager = (ImaxAdVideoPreloadManager)this.mAutomator.k.getManager(QQManagerFactory.IMAX_AD_VIDEO_PRELOAD_MANAGER);
    if (localAdvertisementVideoPreloadManager != null) {
      localImaxAdVideoPreloadManager.a(this.mAutomator.k, this.mAutomator.k.getCurrentUin());
    }
  }
  
  private void s()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, new Object[] { "AfterSyncMsg sendEmptyMessageDelayedToHandler MSG_INIT_MSGTAG_STORY process, send, ", Boolean.valueOf(this.mAutomator.g()) });
    }
    MqqHandler localMqqHandler = this.mAutomator.k.getHandler(Conversation.class);
    localMqqHandler.sendEmptyMessage(1055);
    localMqqHandler.sendEmptyMessage(1059);
    localMqqHandler.sendEmptyMessage(1061);
  }
  
  private void t()
  {
    Object localObject = this.mAutomator.k.getApplication().getApplicationContext().getSharedPreferences(this.mAutomator.k.getAccount(), 0);
    long l = ((SharedPreferences)localObject).getLong("sp_vip_info_request_time", 0L);
    int i = ((SharedPreferences)localObject).getInt("sp_vip_info_update_freq", 10);
    if (NetConnInfoCenter.getServerTime() - l > i * 60)
    {
      localObject = this.mAutomator.k.getCurrentAccountUin();
      String str = ((TicketManager)this.mAutomator.k.getManager(2)).getSkey((String)localObject);
      ((VipInfoHandler)this.mAutomator.k.getBusinessHandler(BusinessHandlerFactory.VIPINFO_HANDLER)).a(str, (String)localObject);
    }
  }
  
  private void u()
  {
    ThreadManager.executeOnSubThread(new AfterSyncMsg.4(this));
  }
  
  private void v()
  {
    RecentDataListManager.a().a(this.mAutomator.k, BaseApplicationImpl.sApplication, true, false);
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "doAfterLogin call MayknowRecommendManager.getMayKnowRecommendRemote ");
    }
    ((MayknowRecommendManager)this.mAutomator.k.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).e(1);
  }
  
  private void w()
  {
    ThreadManager.executeOnSubThread(new AfterSyncMsg.5(this));
  }
  
  private void x()
  {
    List localList = ((ProxyManager)this.mAutomator.k.getManager(QQManagerFactory.PROXY_MANAGER)).g().a(true);
    int i = 0;
    while (i < localList.size())
    {
      if (((RecentUser)localList.get(i)).lFlag == 16L)
      {
        Iterator localIterator = this.mAutomator.k.getMessageFacade().h(((RecentUser)localList.get(i)).uin, ((RecentUser)localList.get(i)).getType()).iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (MessageRecord)localIterator.next();
          localObject = PublicAccountAdUtil.a(this.mAutomator.k, (MessageRecord)localObject, true);
          if (localObject != null) {
            AdvertisementRecentUserManager.a().a((AdvertisementItem)localObject);
          }
        }
      }
      i += 1;
    }
  }
  
  private void y()
  {
    ((IArkService)this.mAutomator.k.getRuntimeService(IArkService.class, "")).startPreloadApp();
  }
  
  private void z()
  {
    ((TroopAioNavigateBarManager)this.mAutomator.k.getManager(QQManagerFactory.TROOP_AIO_NAVIGATE_BAR)).b();
    MqqHandler localMqqHandler = this.mAutomator.k.getHandler(Conversation.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(1134064).sendToTarget();
    }
  }
  
  protected int doStep()
  {
    switch (this.mStepId)
    {
    default: 
      this.mAutomator.k.getMsgHandler().d(false);
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
      ReporterMachine.b().c();
      UnifiedMonitor.a().e();
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.AfterSyncMsg
 * JD-Core Version:    0.7.0.1
 */
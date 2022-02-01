package com.tencent.mobileqq.app.automator.step;

import MQQ.PayRuleCfg;
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
import com.tencent.biz.pubaccount.PublicAccountSearchRecommendManager;
import com.tencent.biz.pubaccount.readinjoy.ark.ReadInJoyArkUtil;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoySpEventReportUtil;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.utils.OfflineUtils;
import com.tencent.biz.pubaccount.util.PAReportManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountConfigUtil;
import com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpPolicyManager;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.NotificationReportUtil;
import com.tencent.gdtad.qqproxy.GdtAppPreOrderUtil;
import com.tencent.hippy.qq.update.HippyUpdateManager;
import com.tencent.hippy.qq.utils.HippyAccessHelper;
import com.tencent.hotpatch.Reporter;
import com.tencent.hotpatch.config.PatchConfigServlet;
import com.tencent.imcore.message.MsgProxyContainer;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.AIOConfigManager;
import com.tencent.mobileqq.activity.aio.panel.miniapp.AioPanelMiniAppManager;
import com.tencent.mobileqq.activity.aio.stickerrecommended.StickerRecManager;
import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.activity.contact.newfriend.NewFriendManager;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneUnityManager;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntryMng;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager;
import com.tencent.mobileqq.activity.qwallet.QWalletCommonManager;
import com.tencent.mobileqq.activity.qwallet.config.QWalletConfigManager;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportUtil;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.activity.recent.guidebanner.NewerGuideBannerManager;
import com.tencent.mobileqq.activity.recent.msgbox.RecentUserCacheHelper;
import com.tencent.mobileqq.activity.springfestival.config.SpringFestivalRedpacketConfigManager;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.EqqDetailDataManager;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.MayknowRecommendManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.asyncdb.CacheManager;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.msgnotify.MsgNotifyPushDialog.PopOpenMsgNotifationTask;
import com.tencent.mobileqq.app.proxy.FTSDBManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.app.proxy.fts.FTSTroopOperator;
import com.tencent.mobileqq.app.qqdaily.FrontBackReportManager;
import com.tencent.mobileqq.app.utils.ClassicHeadActivityManager;
import com.tencent.mobileqq.ar.ARPromotionMgr.PromotionUtil;
import com.tencent.mobileqq.ar.ArResourceManager;
import com.tencent.mobileqq.ar.online_video.AROnlineVideoUtil;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppPreDownloadMgr;
import com.tencent.mobileqq.avatar.api.IQQAvatarHandlerService;
import com.tencent.mobileqq.colornote.data.ColorNoteHandler;
import com.tencent.mobileqq.colornote.smallscreen.ColorNoteSmallScreenUtil;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.data.FeedsManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dt.QQDtReportHelper;
import com.tencent.mobileqq.filemanager.fileassistant.util.DatalineMsgDbTransformer;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.imaxad.ImaxAdVideoPreloadManager;
import com.tencent.mobileqq.managers.TimJumpLoginManager;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.precover.PrecoverManager;
import com.tencent.mobileqq.profilecard.processor.TempGetProfileDetailProcessor;
import com.tencent.mobileqq.profilecard.utils.ProfileServiceUtils;
import com.tencent.mobileqq.pushnotice.PushNoticeUtil;
import com.tencent.mobileqq.qassistant.wake.WakeManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import com.tencent.mobileqq.service.qzone.QZoneUnreadServletLogic;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.startup.step.DtSdkInitStep;
import com.tencent.mobileqq.startup.step.RecordTracer;
import com.tencent.mobileqq.statistics.CrashUtils;
import com.tencent.mobileqq.statistics.FDStats;
import com.tencent.mobileqq.statistics.FightReporter;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.natmem.NatMemAPI;
import com.tencent.mobileqq.studymode.AlphabeticFontHandler;
import com.tencent.mobileqq.studymode.StudyModeManager;
import com.tencent.mobileqq.teamwork.TeamWorkUtils.ProcessTDFileScheduler;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadScheduler;
import com.tencent.mobileqq.troop.aioapp.AioGroupAppsManager;
import com.tencent.mobileqq.troop.blocktroop.TroopBlockUtils;
import com.tencent.mobileqq.troop.navigatebar.TroopAioNavigateBarManager;
import com.tencent.mobileqq.troop.utils.TroopTipsMsgMgr;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.fts.SQLiteFTSUtils;
import com.tencent.mobileqq.utils.quic.QuicResDownload;
import com.tencent.mobileqq.vfs.ReportCallback;
import com.tencent.mobileqq.vfs.VFSRegisterProxy;
import com.tencent.mobileqq.wifi.FreeWifiHelper;
import com.tencent.mqp.app.bps.d;
import com.tencent.mqpsdk.util.NetUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.UnifiedMonitor;
import com.tencent.qqperf.monitor.dropframe.DropFrameMonitor;
import com.tencent.qqperf.opt.suspendthread.DeviceOptSwitch;
import com.tencent.qqperf.repoter.ReporterMachine;
import com.tencent.trackrecordlib.core.RecordManager;
import com.tencent.util.notification.NotifyIdManager;
import cooperation.photoplus.PhotoPlusManager;
import cooperation.qwallet.plugin.impl.QWalletHelperImpl;
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
    ((TroopAioNavigateBarManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_AIO_NAVIGATE_BAR)).a();
    MqqHandler localMqqHandler = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(1134064).sendToTarget();
    }
  }
  
  private void B()
  {
    if (QZoneUnreadServletLogic.a(1, BaseApplicationImpl.processName)) {}
    try
    {
      long l1 = System.currentTimeMillis();
      BaseActivity localBaseActivity = BaseActivity.sTopActivity;
      RecordManager.getInstance().setRecentActivityName(localBaseActivity);
      RecordTracer.a().step();
      long l2 = System.currentTimeMillis();
      QLog.d("RecordTracer", 2, "conversation time " + (l2 - l1));
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("RecordTracer", 2, "EventCon setUserId failed:" + localException.getMessage());
    }
  }
  
  private void C()
  {
    if (NetUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp()) != 2) {
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).preloadMiniProcess();
    }
  }
  
  private void D()
  {
    if (this.a.jdField_a_of_type_Boolean) {
      ((TroopHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).b();
    }
  }
  
  private void E()
  {
    PayRuleCfg localPayRuleCfg = VipInfoHandler.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    if (VipInfoHandler.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localPayRuleCfg, true)) {
      ThreadManagerV2.getUIHandlerV2().post(new AfterSyncMsg.6(this));
    }
  }
  
  private void F()
  {
    if (SystemUtil.a())
    {
      com.tencent.mobileqq.utils.FileUtils.c(AppConstants.PATH_CUSTOM_HEAD_ROOT_SDCARD + ".nomedia");
      com.tencent.mobileqq.utils.FileUtils.c(AppConstants.PATH_HEAD_HD + ".nomedia");
    }
    if (this.a.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("isConvertOldQQHeadOK", false)) {
      return;
    }
    Hashtable localHashtable = new Hashtable();
    EntityManager localEntityManager = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    List localList = localEntityManager.query(Setting.class, new Setting().getTableName(), false, "bHeadType=? or (bHeadType<>? and bUsrType=?)", new String[] { "0", "0", "4" }, null, null, null, null);
    if ((localList != null) && (localList.size() > 0))
    {
      int i = 0;
      if (i < localList.size())
      {
        Object localObject2 = (Setting)localList.get(i);
        if ((((Setting)localObject2).uin != null) && (((Setting)localObject2).uin.length() > 0))
        {
          if (((Setting)localObject2).bUsrType != 4) {
            break label376;
          }
          if ((((Setting)localObject2).bHeadType != 0) || (((Setting)localObject2).systemHeadID != 0)) {
            break label235;
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label235:
          int j;
          label260:
          label262:
          String str1;
          String str2;
          if (((Setting)localObject2).uin.startsWith("troop_"))
          {
            localObject1 = ((Setting)localObject2).uin.substring(6);
            j = 4;
            str1 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getOldCustomFaceFilePath(j, (String)localObject1);
            str2 = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCustomFaceFilePath((Setting)localObject2, j, (String)localObject1, 0, 0);
            if (((Setting)localObject2).bHeadType != 0) {
              break label387;
            }
          }
          label387:
          for (localObject1 = "sys_" + String.valueOf(((Setting)localObject2).systemHeadID);; localObject1 = ((Setting)localObject2).uin)
          {
            localObject2 = new File(str1);
            if (!localHashtable.containsKey(localObject1)) {
              break label396;
            }
            if (!((File)localObject2).exists()) {
              break;
            }
            ((File)localObject2).delete();
            break;
            localObject1 = ((Setting)localObject2).uin;
            break label260;
            label376:
            localObject1 = ((Setting)localObject2).uin;
            j = 1;
            break label262;
          }
          label396:
          if (((File)localObject2).exists())
          {
            com.tencent.mobileqq.transfile.filebrowser.FileUtils.copyFile(str1, str2);
            ((File)localObject2).delete();
            localHashtable.put(localObject1, Boolean.valueOf(true));
          }
        }
      }
    }
    localEntityManager.close();
    Object localObject1 = new File(AppConstants.PATH_CUSTOM_HEAD_ROOT_SDCARD + "_thd/");
    if (((File)localObject1).exists()) {
      com.tencent.open.base.FileUtils.a((File)localObject1);
    }
    localObject1 = new File("/data/data/com.tencent.mobileqq/files/head/_thd/");
    if (((File)localObject1).exists()) {
      com.tencent.open.base.FileUtils.a((File)localObject1);
    }
    this.a.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("isConvertOldQQHeadOK", true).commit();
  }
  
  private void G()
  {
    if ((this.a != null) && (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null))
    {
      new CheckLoveStateRequestManager().a(Long.parseLong(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
      return;
    }
    QLog.i("QQInitHandler", 1, "ChkeckLoveStateRequest diden`t send");
  }
  
  private void a()
  {
    D();
    ((FriendListHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getSelfXManInfo();
    c(23);
    f();
    e();
    PromotionUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    AROnlineVideoUtil.a(BaseApplicationImpl.getContext(), this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().m();
    ((PAReportManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PA_REPORT_MANAGER)).a();
    Object localObject = (PasswdRedBagManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PASSWD_RED_BAG_MANAGER);
    ((PasswdRedBagManager)localObject).b();
    ((PasswdRedBagManager)localObject).a();
    QWalletCommonManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    a("checkDelAbnormalLocalTroopMsg onReconnect");
    int i = NetworkUtil.a(BaseApplicationImpl.getApplication());
    switch (i)
    {
    case 2: 
    default: 
      if (i == 1) {
        ((PhotoPlusManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PHOTO_PLUS_MANAGER)).a(false);
      }
      PatchConfigServlet.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), -1, "doOnReconnect");
      QWalletHelperImpl.getPayCode(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      if (Math.abs(System.currentTimeMillis() - AEOldShortVideoResManager.a) > 3600000L) {
        AEOldShortVideoResManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2);
      }
      if (Math.abs(System.currentTimeMillis() - ShortVideoResourceManager.a) > 3600000L) {
        ShortVideoResourceManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 2);
      }
      break;
    }
    for (;;)
    {
      localObject = (ClassicHeadActivityManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CLASSIC_HEAD_ACIVITY_MANAGER);
      if ((localObject != null) && (((ClassicHeadActivityManager)localObject).a()))
      {
        localObject = (TempGetProfileDetailProcessor)ProfileServiceUtils.getBusinessProcessor(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, TempGetProfileDetailProcessor.class);
        if (localObject != null) {
          ((TempGetProfileDetailProcessor)localObject).getClassicHeadActivityParams();
        }
      }
      b(2);
      ((SpringFestivalRedpacketConfigManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SPRING_FESTIVAL_RED_PACKET_MANAGER)).b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 1);
      QQAppInterface.initHeadCfg();
      d();
      StickerRecManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).c();
      ReadInJoySpEventReportUtil.a();
      v();
      StudyModeManager.a();
      return;
      ((BlessManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).g();
      break;
      QLog.d("ShortVideoResourceManager", 1, "[network]not need get config...");
    }
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.del_abnormal_troop_local_msg", 2, paramString);
    }
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().q();
  }
  
  private void b(int paramInt)
  {
    QWalletConfigManager localQWalletConfigManager = (QWalletConfigManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QWALLET_CONFIG_MANAGER);
    if (localQWalletConfigManager != null) {
      localQWalletConfigManager.a(paramInt);
    }
  }
  
  private void c(int paramInt)
  {
    Object localObject = (FriendListHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().i();
    this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().j();
    F();
    ((DiscussionHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).b();
    ((FriendsManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).b();
    ((IQQAvatarHandlerService)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IQQAvatarHandlerService.class, "")).notifySyncQQHead();
    ((FriendListHandler)localObject).notifySyncSignature();
    localObject = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler();
    boolean bool2;
    if (!this.a.b)
    {
      bool1 = true;
      if (this.a.c) {
        break label418;
      }
      bool2 = true;
      label151:
      ((MessageHandler)localObject).a(bool1, bool2);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().m();
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().m();
      if (!QZoneHelper.hideQzoneStatusInConverstation()) {
        break label423;
      }
      QLog.i("QQInitHandler", 2, "updateQzoneFeeds 下发配置隐藏新动态");
      label200:
      ReadinjoySPEventReport.d(this.b);
      localObject = (PhoneContactManagerImp)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CONTACT_MANAGER);
      if (paramInt != 22) {
        break label445;
      }
    }
    label418:
    label423:
    label445:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((PhoneContactManagerImp)localObject).a(bool1);
      try
      {
        localObject = (AccessibilityManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSystemService("accessibility");
        bool1 = ((AccessibilityManager)localObject).isEnabled();
        bool2 = ((AccessibilityManager)localObject).isTouchExplorationEnabled();
        if ((bool1) && (bool2))
        {
          localObject = BaseApplicationImpl.getApplication().getSharedPreferences("Talkback" + this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), 0);
          long l = ((SharedPreferences)localObject).getLong("ReportTime", 0L);
          if (System.currentTimeMillis() - l > 86400000L)
          {
            ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800A4C7", "0X800A4C7", 0, 0, "", "0", "", "");
            ((SharedPreferences)localObject).edit().putLong("ReportTime", System.currentTimeMillis()).commit();
          }
        }
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QLog.e("QQInitHandler", 1, localThrowable, new Object[0]);
        }
      }
      NatMemAPI.a(BaseApplicationImpl.getApplication());
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label151;
      ((FeedsManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.QZONE_NEW_STATUS_MANAGER)).updateQzoneFeeds();
      break label200;
    }
  }
  
  private void d()
  {
    CardHandler localCardHandler = (CardHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
    if (localCardHandler != null)
    {
      localCardHandler.l();
      localCardHandler.k();
      localCardHandler.i();
      localCardHandler.j();
    }
  }
  
  private void e()
  {
    ArResourceManager localArResourceManager = (ArResourceManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.AR_RESOURCE_MANAGER);
    if (localArResourceManager != null) {
      localArResourceManager.a(true, false);
    }
  }
  
  private void f()
  {
    PrecoverManager localPrecoverManager = (PrecoverManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PRECOVER_MANAGER);
    if (localPrecoverManager != null)
    {
      if (localPrecoverManager.a()) {
        ConfigServlet.f(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      }
    }
    else {
      return;
    }
    localPrecoverManager.a();
  }
  
  private void g()
  {
    if (DeviceOptSwitch.jdField_d_of_type_Boolean) {}
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
  
  private void h()
  {
    QLog.d("QQInitHandler", 1, "call doAfterLogin");
    new RecentUserCacheHelper().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    PushNoticeUtil.a();
    Object localObject1 = VFSRegisterProxy.a();
    Object localObject2 = BaseApplicationImpl.sApplication;
    ReportCallback localReportCallback = ReportCallback.a();
    if (BaseApplicationImpl.sProcessId == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ((VFSRegisterProxy)localObject1).b((Context)localObject2, localReportCallback, bool, false);
      VFSRegisterProxy.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      ThreadManager.getSubThreadHandler().post(new AfterSyncMsg.1(this));
      UnifiedMonitor.a(SQLiteOpenHelper.WAL_ENABLE);
      DropFrameMonitor.a();
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().a();
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().init_lazy();
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCacheManager().initLazy();
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.initSecureFileFramework();
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(0, false);
      ((QQStoryHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER)).a();
      ((QQStoryHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER)).b();
      ((FlashChatManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).a();
      ((QQStoryHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER)).c();
      u();
      E();
      g();
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getDatalineMsgDBTransformer().a();
      ((SVIPHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a();
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.isStartSyncOnlineFriend = true;
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.syncOnlineFriend();
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addManager(false);
      D();
      t();
      C();
      c(22);
      ((EqqDetailDataManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.EQQ_DETAIL_DATA_MANAGER)).a();
      r();
      ((PublicAccountDataManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER)).a();
      PublicAccountSearchRecommendManager.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLIC_ACCOUNT_ENTITY_HELPER);
      s();
      q();
      g();
      ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getServiceAccountFolderConfigData(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).loadPublicAccountCenterUrlConfig(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, ((IPublicAccountConfigUtil)QRoute.api(IPublicAccountConfigUtil.class)).getPublicAccountCenterUrlConfigData(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface));
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().o();
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().m();
      SQLiteFTSUtils.b();
      ((PAReportManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PA_REPORT_MANAGER)).a();
      localObject1 = (PhoneUnityManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PHONE_UNITY_MANAGER);
      ((PhoneUnityManager)localObject1).b();
      localObject2 = (PasswdRedBagManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PASSWD_RED_BAG_MANAGER);
      ((PasswdRedBagManager)localObject2).a(false);
      ((PasswdRedBagManager)localObject2).d();
      ((PasswdRedBagManager)localObject2).b();
      ((PasswdRedBagManager)localObject2).a();
      ((TroopTipsMsgMgr)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_TIPS_MSG_MANAGER)).a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      a("checkDelAbnormalLocalTroopMsg afterLogin");
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBrowserFontSetting();
      AIOConfigManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      FightReporter.a();
      FightReporter.b();
      FightReporter.e();
      m();
      l();
      FDStats.a().a();
      CrashUtils.a();
      QWalletCommonManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      QWalletHelperImpl.getPayCode(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      HippyAccessHelper.clearPreloadHippy();
      p();
      o();
      g();
      ((FriendsManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(true);
      ((NewFriendManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEW_FRIEND_MANAGER)).i();
      ((KandianMergeManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a();
      ((ConfigHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)).f();
      n();
      y();
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRecentUserProxy().c();
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.GAME_CENTER_MSG_MANAGER);
      ((FlashChatManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).c();
      ((IDPCApi)QRoute.api(IDPCApi.class)).addObserver(new AfterSyncMsg.InnerDPCObservers());
      AioGroupAppsManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
      NotifyIdManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).b();
      b(1);
      VACDReportUtil.a();
      ((PreDownloadScheduler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PRE_DOWNLOAD_SCHEDULER_MANAGER)).startPreDownload();
      QuicResDownload.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      ((TimJumpLoginManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TIM_JUMP_LOGIN_MANAGER)).a();
      localObject2 = (TempGetProfileDetailProcessor)ProfileServiceUtils.getBusinessProcessor(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, TempGetProfileDetailProcessor.class);
      if (localObject2 != null) {
        ((TempGetProfileDetailProcessor)localObject2).getOfficeUserFlag();
      }
      ReadInJoyArkUtil.a();
      OfflineUtils.a(false);
      x();
      ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startOfficialLocation();
      FreeWifiHelper.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      d.a();
      QQAppInterface.initHeadCfg();
      w();
      AioPanelMiniAppManager.a(((PhoneUnityManager)localObject1).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
      d();
      z();
      StickerRecManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).c();
      StickerRecManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).e();
      ((IMiniAppService)QRoute.api(IMiniAppService.class)).registerMiniArkShareMessageProcessorAfterProcessRestart();
      NotificationReportUtil.reportAll();
      g();
      A();
      B();
      TeamWorkUtils.ProcessTDFileScheduler.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a();
      v();
      ThreadManager.getFileThreadHandler().post(new AfterSyncMsg.2(this));
      G();
      ColorNoteSmallScreenUtil.b(true);
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.registerBatteryBroadcastReceiver();
      ((ColorNoteHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.COLOR_NOTE_HANDLER)).a();
      CTEntryMng.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      Reporter.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      FrontBackReportManager.a(true);
      DtSdkInitStep.a();
      TroopRedTouchHandler.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, true);
      TroopBlockUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      WakeManager.a().b().a("firstInit");
      j();
      i();
      k();
      WSExpPolicyManager.a().a();
      GdtAppPreOrderUtil.a();
      HippyUpdateManager.getInstance().preDownloadHippyByController(1);
      return;
    }
  }
  
  private void i()
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
  
  private void j()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      ((AlphabeticFontHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TEENS_MODE_ALPHABETIC_FONT_HANDLER)).a();
    }
  }
  
  private void k()
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      ((NewerGuideBannerManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.NEWER_GUIDE_BANNER_MANAGER)).a();
    }
  }
  
  private void l()
  {
    if (!DeviceOptSwitch.b) {
      ((FTSTroopOperator)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFTSDBManager().a(2)).g();
    }
    do
    {
      return;
      DeviceOptSwitch.jdField_d_of_type_Long = System.currentTimeMillis();
    } while (!QLog.isColorLevel());
    QLog.d("Perf", 2, "delay checkTroopTimeStamp");
  }
  
  private void m()
  {
    SearchConfigManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts", 2, "troopMemberUpdateConfigStr=" + SearchConfigManager.troopMemberUpdateConfigStr);
    }
  }
  
  private void n()
  {
    UserOperationModule localUserOperationModule = ReadInJoyLogicEngine.a().a();
    if (localUserOperationModule != null) {
      localUserOperationModule.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    }
  }
  
  private void o()
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler_PushOpenNotify", 2, "doafterlogin");
      }
      new MsgNotifyPushDialog.PopOpenMsgNotifationTask(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).execute(new Void[0]);
    }
  }
  
  private void p()
  {
    ClassicHeadActivityManager localClassicHeadActivityManager = (ClassicHeadActivityManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.CLASSIC_HEAD_ACIVITY_MANAGER);
    if ((localClassicHeadActivityManager != null) && (localClassicHeadActivityManager.a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 4, " QQ 18 handle actionB cached stranger head update in AfterSyncMsg doAfterLogin");
      }
      localClassicHeadActivityManager.b();
    }
  }
  
  private void q()
  {
    ActivateFriendsManager localActivateFriendsManager = (ActivateFriendsManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS);
    if (localActivateFriendsManager != null) {
      localActivateFriendsManager.a();
    }
  }
  
  private void r()
  {
    ThreadManager.getSubThreadHandler().post(new AfterSyncMsg.3(this));
  }
  
  private void s()
  {
    AdvertisementVideoPreloadManager localAdvertisementVideoPreloadManager = (AdvertisementVideoPreloadManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PUBLIC_ACCOUNT_VIDEO_PRELOAD_MANAGER);
    if (localAdvertisementVideoPreloadManager != null)
    {
      if (!"5.0.2".equals(Build.VERSION.RELEASE)) {
        localAdvertisementVideoPreloadManager.a();
      }
      localAdvertisementVideoPreloadManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    }
    ImaxAdVideoPreloadManager localImaxAdVideoPreloadManager = (ImaxAdVideoPreloadManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.IMAX_AD_VIDEO_PRELOAD_MANAGER);
    if (localAdvertisementVideoPreloadManager != null) {
      localImaxAdVideoPreloadManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentUin());
    }
  }
  
  private void t()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, new Object[] { "AfterSyncMsg sendEmptyMessageDelayedToHandler MSG_INIT_MSGTAG_STORY process, send, ", Boolean.valueOf(this.a.b()) });
    }
    MqqHandler localMqqHandler = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
    localMqqHandler.sendEmptyMessage(1055);
    localMqqHandler.sendEmptyMessage(1059);
    localMqqHandler.sendEmptyMessage(1061);
  }
  
  private void u()
  {
    Object localObject = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getSharedPreferences(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
    long l = ((SharedPreferences)localObject).getLong("sp_vip_info_request_time", 0L);
    int i = ((SharedPreferences)localObject).getInt("sp_vip_info_update_freq", 10);
    if (NetConnInfoCenter.getServerTime() - l > i * 60)
    {
      localObject = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      String str = ((TicketManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2)).getSkey((String)localObject);
      ((VipInfoHandler)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.VIPINFO_HANDLER)).a(str, (String)localObject);
    }
  }
  
  private void v()
  {
    ThreadManager.executeOnSubThread(new AfterSyncMsg.4(this));
  }
  
  private void w()
  {
    RecentDataListManager.a().a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplicationImpl.sApplication, true, false);
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "doAfterLogin call MayknowRecommendManager.getMayKnowRecommendRemote ");
    }
    ((MayknowRecommendManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).a(1);
  }
  
  private void x()
  {
    ThreadManager.executeOnSubThread(new AfterSyncMsg.5(this));
  }
  
  private void y()
  {
    List localList = ((ProxyManager)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.PROXY_MANAGER)).a().a(true);
    int i = 0;
    while (i < localList.size())
    {
      if (((RecentUser)localList.get(i)).lFlag == 16L)
      {
        Iterator localIterator = this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().b(((RecentUser)localList.get(i)).uin, ((RecentUser)localList.get(i)).getType()).iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (MessageRecord)localIterator.next();
          localObject = PublicAccountAdUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject, true);
          if (localObject != null) {
            AdvertisementRecentUserManager.a().a((AdvertisementItem)localObject);
          }
        }
      }
      i += 1;
    }
  }
  
  private void z()
  {
    Object localObject = (ArkAppCenter)this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.ARK_APP_CENTER_MANAGER);
    if (localObject != null)
    {
      localObject = ((ArkAppCenter)localObject).a();
      if (localObject != null) {
        ((ArkAppPreDownloadMgr)localObject).b();
      }
    }
  }
  
  public int a()
  {
    switch (this.b)
    {
    default: 
      this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgHandler().a(false);
      this.a.notifyUI(6008, false, null, true);
    }
    for (;;)
    {
      return 7;
      h();
      ReporterMachine.a().a();
      UnifiedMonitor.a().c();
      continue;
      a();
      continue;
      c(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.AfterSyncMsg
 * JD-Core Version:    0.7.0.1
 */
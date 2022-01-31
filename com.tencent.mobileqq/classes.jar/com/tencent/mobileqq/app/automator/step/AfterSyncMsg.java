package com.tencent.mobileqq.app.automator.step;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.biz.pubaccount.AccountDetail.model.AccountDetailDynamicDataManager;
import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementRecentUserManager;
import com.tencent.biz.pubaccount.Advertisement.manager.AdvertisementVideoPreloadManager;
import com.tencent.biz.pubaccount.Advertisement.util.PublicAccountAdUtil;
import com.tencent.biz.pubaccount.PublicAccountSearchRecommendManager;
import com.tencent.biz.pubaccount.readinjoy.ark.ReadInJoyArkUtil;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport;
import com.tencent.biz.pubaccount.readinjoy.logic.SMRM;
import com.tencent.biz.pubaccount.readinjoy.model.UserOperationModule;
import com.tencent.biz.pubaccount.util.PAReportManager;
import com.tencent.biz.pubaccount.util.PublicAccountConfigUtil;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hotpatch.config.PatchConfigServlet;
import com.tencent.mfsdk.collector.DropFrameMonitor;
import com.tencent.mfsdk.reporter.ReporterMachine;
import com.tencent.mobileqq.activity.aio.AIOConfigManager;
import com.tencent.mobileqq.activity.bless.BlessManager;
import com.tencent.mobileqq.activity.qwallet.PasswdRedBagManager;
import com.tencent.mobileqq.activity.qwallet.QWalletCommonManager;
import com.tencent.mobileqq.activity.qwallet.config.QWalletConfigManager;
import com.tencent.mobileqq.activity.qwallet.report.VACDReportMgr;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DiscussionHandler;
import com.tencent.mobileqq.app.EqqDetailDataManager;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.NewFriendManager;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.PhoneUnityManager;
import com.tencent.mobileqq.app.PublicAccountDataManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.app.VipInfoHandler;
import com.tencent.mobileqq.app.activateFriends.ActivateFriendsManager;
import com.tencent.mobileqq.app.asyncdb.CacheManager;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.memory.MemoryReporter;
import com.tencent.mobileqq.app.message.MsgProxyContainer;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.msgnotify.MsgNotifyPushDialog.PopOpenMsgNotifationTask;
import com.tencent.mobileqq.app.proxy.FTSDBManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.app.proxy.fts.FTSTroopOperator;
import com.tencent.mobileqq.app.utils.ClassicHeadActivityManager;
import com.tencent.mobileqq.ar.ArResourceManager;
import com.tencent.mobileqq.ar.online_video.AROnlineVideoUtil;
import com.tencent.mobileqq.armap.config.ARMapConfigManager;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.imaxad.ImaxAdVideoPreloadManager;
import com.tencent.mobileqq.managers.TimJumpLoginManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.precover.PrecoverManager;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.statistics.FDStats;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadScheduler;
import com.tencent.mobileqq.troop.utils.TroopTipsMsgMgr;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.fts.SQLiteFTSUtils;
import com.tencent.mobileqq.utils.quic.QuicResDownload;
import com.tencent.qphone.base.util.QLog;
import cooperation.dingdong.DingdongPluginManager;
import cooperation.photoplus.PhotoPlusManager;
import cooperation.qwallet.plugin.QWalletHelper;
import java.io.File;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import zmq;
import zmr;

public class AfterSyncMsg
  extends AsyncStep
{
  private void b()
  {
    if (this.a.jdField_a_of_type_Boolean) {
      ((TroopHandler)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).b();
    }
    ((FriendListHandler)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(1)).c();
    e();
    Object localObject = (PrecoverManager)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(178);
    if (localObject != null)
    {
      if (((PrecoverManager)localObject).a()) {
        ConfigServlet.f(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      }
    }
    else
    {
      localObject = (ArResourceManager)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(167);
      if (localObject != null) {
        ((ArResourceManager)localObject).a(true, false);
      }
      AROnlineVideoUtil.a(BaseApplicationImpl.getContext(), this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
      ((PhoneContactManagerImp)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).a(true, true);
      ((DingdongPluginManager)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(114)).b();
      this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().m();
      ((PAReportManager)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(100)).a();
      localObject = (PasswdRedBagManager)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(124);
      ((PasswdRedBagManager)localObject).b();
      ((PasswdRedBagManager)localObject).a();
      QWalletCommonManager.a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d(".troop.del_abnormal_troop_local_msg", 2, "checkDelAbnormalLocalTroopMsg onReconnect");
      }
      this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().r();
      int i = NetworkUtil.a(BaseApplicationImpl.getApplication());
      switch (i)
      {
      case 2: 
      default: 
        label316:
        if (i == 1) {
          ((PhotoPlusManager)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(168)).a(false);
        }
        PatchConfigServlet.a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), -1, "doOnReconnect");
        QWalletHelper.getPayCode(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
        long l = System.currentTimeMillis();
        if (Math.abs(l - ARMapConfigManager.a) > 3600000L)
        {
          ARMapConfigManager.a = l;
          ConfigServlet.a(1, this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          label418:
          if (Math.abs(System.currentTimeMillis() - ShortVideoResourceManager.a) <= 3600000L) {
            break label587;
          }
          ShortVideoResourceManager.a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, 2);
        }
        break;
      }
    }
    for (;;)
    {
      localObject = (CardHandler)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(2);
      ClassicHeadActivityManager localClassicHeadActivityManager = (ClassicHeadActivityManager)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(198);
      if ((localObject != null) && (localClassicHeadActivityManager != null) && (localClassicHeadActivityManager.a())) {
        ((CardHandler)localObject).f();
      }
      SMRM.a().a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
      localObject = (QWalletConfigManager)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(244);
      if (localObject != null) {
        ((QWalletConfigManager)localObject).a(2);
      }
      return;
      ((PrecoverManager)localObject).a();
      break;
      ((BlessManager)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(137)).f();
      break label316;
      QLog.d("ARMap reconect config", 1, "not need get config");
      break label418;
      label587:
      QLog.d("ShortVideoResourceManager", 1, "[network]not need get config...");
    }
  }
  
  private void d()
  {
    UnifiedMonitor.a(SQLiteOpenHelper.jdField_a_of_type_Boolean);
    DropFrameMonitor.a();
    this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a().c();
    this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
    this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().b();
    this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(0, false);
    ((QQStoryHandler)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(98)).b();
    ((QQStoryHandler)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(98)).c();
    ((FlashChatManager)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(216)).b();
    Object localObject1 = this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getApplicationContext().getSharedPreferences(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
    long l = ((SharedPreferences)localObject1).getLong("sp_vip_info_request_time", 0L);
    int i = ((SharedPreferences)localObject1).getInt("sp_vip_info_update_freq", 10);
    if (NetConnInfoCenter.getServerTime() - l > i * 60)
    {
      localObject1 = this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
      localObject2 = ((TicketManager)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2)).getSkey((String)localObject1);
      ((VipInfoHandler)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(27)).a((String)localObject2, (String)localObject1);
    }
    ((SVIPHandler)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).b();
    this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.m = true;
    this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.z();
    this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(false);
    if (this.a.jdField_a_of_type_Boolean) {
      ((TroopHandler)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(20)).b();
    }
    e();
    ((EqqDetailDataManager)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(68)).a();
    ThreadManager.getSubThreadHandler().post(new zmq(this));
    ((PublicAccountDataManager)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(55)).a();
    PublicAccountSearchRecommendManager.a().a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(236);
    localObject1 = (AdvertisementVideoPreloadManager)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(237);
    if (localObject1 != null)
    {
      if (!"5.0.2".equals(Build.VERSION.RELEASE)) {
        ((AdvertisementVideoPreloadManager)localObject1).a();
      }
      ((AdvertisementVideoPreloadManager)localObject1).a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c());
    }
    Object localObject2 = (ImaxAdVideoPreloadManager)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(267);
    if (localObject1 != null) {
      ((ImaxAdVideoPreloadManager)localObject2).a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c());
    }
    localObject1 = (AccountDetailDynamicDataManager)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(172);
    localObject1 = (PhoneContactManagerImp)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    ((PhoneContactManagerImp)localObject1).c();
    ConfigServlet.b(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    ((PhoneContactManagerImp)localObject1).a(true, true);
    localObject1 = (ActivateFriendsManager)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(84);
    if (localObject1 != null) {
      ((ActivateFriendsManager)localObject1).a();
    }
    PublicAccountConfigUtil.b(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    PublicAccountConfigUtil.a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, PublicAccountConfigUtil.a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface));
    PublicAccountConfigUtil.a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    ((DingdongPluginManager)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(114)).b();
    this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().p();
    this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().m();
    SQLiteFTSUtils.b();
    ((PAReportManager)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(100)).a();
    localObject1 = (PhoneUnityManager)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(101);
    ((PhoneUnityManager)localObject1).b();
    ((PhoneUnityManager)localObject1).c();
    localObject1 = (PasswdRedBagManager)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(124);
    ((PasswdRedBagManager)localObject1).a(false);
    ((PasswdRedBagManager)localObject1).d();
    ((PasswdRedBagManager)localObject1).b();
    ((PasswdRedBagManager)localObject1).a();
    ((TroopTipsMsgMgr)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(80)).a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d(".troop.del_abnormal_troop_local_msg", 2, "checkDelAbnormalLocalTroopMsg afterLogin");
    }
    this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().r();
    this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.G();
    SearchConfigManager.a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    AIOConfigManager.a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts", 2, "troopMemberUpdateConfigStr=" + SearchConfigManager.troopMemberUpdateConfigStr);
    }
    ((FTSTroopOperator)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(2)).f();
    MemoryReporter.a().a();
    MemoryManager.a().b();
    FDStats.a().a();
    QWalletCommonManager.a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    QWalletHelper.getPayCode(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    localObject1 = (ClassicHeadActivityManager)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(198);
    if ((localObject1 != null) && (((ClassicHeadActivityManager)localObject1).a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 4, " QQ 18 handle actionB cached stranger head update in AfterSyncMsg doAfterLogin");
      }
      ((ClassicHeadActivityManager)localObject1).b();
    }
    if (Build.VERSION.SDK_INT >= 19)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler_PushOpenNotify", 2, "doafterlogin");
      }
      new MsgNotifyPushDialog.PopOpenMsgNotifationTask(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface).execute(new Void[0]);
    }
    ((FriendsManager)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).d();
    ((NewFriendManager)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(33)).g();
    ((ConfigHandler)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(4)).f();
    localObject1 = ReadInJoyLogicEngine.a().a();
    if (localObject1 != null) {
      ((UserOperationModule)localObject1).a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c());
    }
    localObject1 = ((ProxyManager)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(17)).a().a(true);
    i = 0;
    while (i < ((List)localObject1).size())
    {
      if (((RecentUser)((List)localObject1).get(i)).lFlag == 16L)
      {
        localObject2 = this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().b(((RecentUser)((List)localObject1).get(i)).uin, ((RecentUser)((List)localObject1).get(i)).type).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          Object localObject3 = (MessageRecord)((Iterator)localObject2).next();
          localObject3 = PublicAccountAdUtil.a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, (MessageRecord)localObject3, true);
          if (localObject3 != null) {
            AdvertisementRecentUserManager.a().a((AdvertisementItem)localObject3);
          }
        }
      }
      i += 1;
    }
    ((FlashChatManager)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(216)).d();
    DeviceProfileManager.a(new zmr());
    ReadinjoySPEventReport.i();
    localObject1 = (QWalletConfigManager)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(244);
    if (localObject1 != null) {
      ((QWalletConfigManager)localObject1).a(1);
    }
    VACDReportMgr.a();
    ((PreDownloadScheduler)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(232)).a();
    QuicResDownload.a(this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    ((TimJumpLoginManager)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(241)).a();
    ((CardHandler)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(2)).t();
    ReadInJoyArkUtil.a();
  }
  
  private void e()
  {
    boolean bool2 = true;
    Object localObject = (FriendListHandler)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(1);
    this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().j();
    this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().k();
    f();
    ((DiscussionHandler)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(6)).c();
    ((FriendsManager)this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).b();
    ((FriendListHandler)localObject).e();
    ((FriendListHandler)localObject).b();
    localObject = this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
    boolean bool1;
    if (!this.a.jdField_b_of_type_Boolean)
    {
      bool1 = true;
      if (this.a.c) {
        break label162;
      }
    }
    for (;;)
    {
      ((MessageHandler)localObject).a(bool1, bool2);
      this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().n();
      this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().m();
      return;
      bool1 = false;
      break;
      label162:
      bool2 = false;
    }
  }
  
  private void f()
  {
    if (SystemUtil.a())
    {
      com.tencent.mobileqq.utils.FileUtils.c(AppConstants.aJ + "head/" + ".nomedia");
      com.tencent.mobileqq.utils.FileUtils.c(AppConstants.bm + ".nomedia");
    }
    if (this.a.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("isConvertOldQQHeadOK", false)) {
      return;
    }
    Hashtable localHashtable = new Hashtable();
    EntityManager localEntityManager = this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
    List localList = localEntityManager.a(Setting.class, new Setting().getTableName(), false, "bHeadType=? or (bHeadType<>? and bUsrType=?)", new String[] { "0", "0", "4" }, null, null, null, null);
    if ((localList != null) && (localList.size() > 0))
    {
      int i = 0;
      if (i < localList.size())
      {
        Object localObject2 = (Setting)localList.get(i);
        if ((((Setting)localObject2).uin != null) && (((Setting)localObject2).uin.length() > 0))
        {
          if (((Setting)localObject2).bUsrType != 4) {
            break label389;
          }
          if ((((Setting)localObject2).bHeadType != 0) || (((Setting)localObject2).systemHeadID != 0)) {
            break label248;
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label248:
          int j;
          label273:
          label275:
          String str1;
          String str2;
          if (((Setting)localObject2).uin.startsWith("troop_"))
          {
            localObject1 = ((Setting)localObject2).uin.substring(6);
            j = 4;
            str1 = this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(j, (String)localObject1);
            str2 = this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a((Setting)localObject2, j, (String)localObject1, 0, true);
            if (((Setting)localObject2).bHeadType != 0) {
              break label400;
            }
          }
          label389:
          label400:
          for (localObject1 = "sys_" + String.valueOf(((Setting)localObject2).systemHeadID);; localObject1 = ((Setting)localObject2).uin)
          {
            localObject2 = new File(str1);
            if (!localHashtable.containsKey(localObject1)) {
              break label409;
            }
            if (!((File)localObject2).exists()) {
              break;
            }
            ((File)localObject2).delete();
            break;
            localObject1 = ((Setting)localObject2).uin;
            break label273;
            localObject1 = ((Setting)localObject2).uin;
            j = 1;
            break label275;
          }
          label409:
          if (((File)localObject2).exists())
          {
            com.tencent.mobileqq.transfile.filebrowser.FileUtils.a(str1, str2);
            ((File)localObject2).delete();
            localHashtable.put(localObject1, Boolean.valueOf(true));
          }
        }
      }
    }
    localEntityManager.a();
    Object localObject1 = new File(AppConstants.aJ + "head/" + "_thd/");
    if (((File)localObject1).exists()) {
      com.tencent.open.base.FileUtils.a((File)localObject1);
    }
    localObject1 = new File("/data/data/com.tencent.mobileqq/files/head/_thd/");
    if (((File)localObject1).exists()) {
      com.tencent.open.base.FileUtils.a((File)localObject1);
    }
    this.a.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("isConvertOldQQHeadOK", true).commit();
  }
  
  protected int a()
  {
    switch (this.b)
    {
    default: 
      this.a.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(false);
      this.a.a(6008, false, null, true);
    }
    for (;;)
    {
      return 7;
      d();
      ReporterMachine.a().a();
      UnifiedMonitor.a().c();
      continue;
      b();
      continue;
      e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.AfterSyncMsg
 * JD-Core Version:    0.7.0.1
 */
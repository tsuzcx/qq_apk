package com.tencent.mobileqq.app.automator.step;

import MQQ.PayRuleCfg;
import aclr;
import acma;
import acng;
import afoc;
import ahqp;
import aiin;
import aipw;
import aizi;
import ajco;
import ajmy;
import akqe;
import akqz;
import aktz;
import albe;
import algs;
import alkd;
import ally;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.view.accessibility.AccessibilityManager;
import anri;
import ansg;
import antl;
import anty;
import anvk;
import anyb;
import aoan;
import aocy;
import aoep;
import aogw;
import aohe;
import aohg;
import aohq;
import aorf;
import aoxx;
import aoxz;
import aoyg;
import aoys;
import aozr;
import apcx;
import apgi;
import appb;
import apyu;
import aqoj;
import aqrl;
import arph;
import asbi;
import avqv;
import awnk;
import awtu;
import azod;
import baiw;
import banp;
import bcur;
import bdgy;
import bdjx;
import bdkc;
import bdki;
import bdla;
import bdms;
import bdud;
import bdvn;
import becs;
import bfbz;
import bfcs;
import bfzk;
import bgmf;
import bhkf;
import bhxq;
import bixr;
import biyr;
import bizo;
import bjkl;
import bkyy;
import bmnf;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.NotificationReportUtil;
import com.tencent.hippy.qq.utils.HippyAccessHelper;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mfsdk.collector.DropFrameMonitor;
import com.tencent.mfsdk.reporter.ReporterMachine;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.SQLiteOpenHelper;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.data.FeedsManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.share.MiniArkShareAsyncManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.startup.step.DtSdkInitStep;
import com.tencent.mobileqq.startup.step.RecordTracer;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadScheduler;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.quic.QuicResDownload;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trackrecordlib.core.RecordManager;
import cooperation.photoplus.PhotoPlusManager;
import cooperation.qwallet.plugin.QWalletHelper;
import cooperation.qzone.QZoneHelper;
import java.io.File;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import ntj;
import oay;
import oeq;
import oez;
import ofd;
import ofj;
import oli;
import ovr;
import pvj;
import pvr;
import pwb;
import qia;
import tmz;
import use;
import usu;
import vzu;

public class AfterSyncMsg
  extends AsyncStep
{
  private void A()
  {
    if (bcur.a(1, BaseApplicationImpl.processName)) {}
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
  
  private void B()
  {
    if (bizo.a(this.a.app.getApp()) != 2) {
      MiniAppController.preloadMiniProcess();
    }
  }
  
  private void C()
  {
    if (this.a.jdField_a_of_type_Boolean) {
      ((aoep)this.a.app.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER)).b();
    }
  }
  
  private void D()
  {
    PayRuleCfg localPayRuleCfg = aogw.a(this.a.app.getCurrentUin());
    if (aogw.a(this.a.app, localPayRuleCfg, true)) {
      ThreadManagerV2.getUIHandlerV2().post(new AfterSyncMsg.6(this));
    }
  }
  
  private void E()
  {
    if (SystemUtil.isExistSDCard())
    {
      com.tencent.mobileqq.utils.FileUtils.createFileIfNotExits(AppConstants.PATH_CUSTOM_HEAD_ROOT_SDCARD + ".nomedia");
      com.tencent.mobileqq.utils.FileUtils.createFileIfNotExits(AppConstants.PATH_HEAD_HD + ".nomedia");
    }
    if (this.a.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("isConvertOldQQHeadOK", false)) {
      return;
    }
    Hashtable localHashtable = new Hashtable();
    EntityManager localEntityManager = this.a.app.getEntityManagerFactory().createEntityManager();
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
            break label374;
          }
          if ((((Setting)localObject2).bHeadType != 0) || (((Setting)localObject2).systemHeadID != 0)) {
            break label234;
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label234:
          int j;
          label258:
          label260:
          String str1;
          String str2;
          if (((Setting)localObject2).uin.startsWith("troop_"))
          {
            localObject1 = ((Setting)localObject2).uin.substring(6);
            j = 4;
            str1 = this.a.app.getOldCustomFaceFilePath(j, (String)localObject1);
            str2 = this.a.app.getCustomFaceFilePath((Setting)localObject2, j, (String)localObject1, 0, 0);
            if (((Setting)localObject2).bHeadType != 0) {
              break label385;
            }
          }
          label385:
          for (localObject1 = "sys_" + String.valueOf(((Setting)localObject2).systemHeadID);; localObject1 = ((Setting)localObject2).uin)
          {
            localObject2 = new File(str1);
            if (!localHashtable.containsKey(localObject1)) {
              break label394;
            }
            if (!((File)localObject2).exists()) {
              break;
            }
            ((File)localObject2).delete();
            break;
            localObject1 = ((Setting)localObject2).uin;
            break label258;
            label374:
            localObject1 = ((Setting)localObject2).uin;
            j = 1;
            break label260;
          }
          label394:
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
      bjkl.a((File)localObject1);
    }
    localObject1 = new File("/data/data/com.tencent.mobileqq/files/head/_thd/");
    if (((File)localObject1).exists()) {
      bjkl.a((File)localObject1);
    }
    this.a.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("isConvertOldQQHeadOK", true).commit();
  }
  
  private void F()
  {
    if ((this.a != null) && (this.a.app != null))
    {
      new bmnf().a(Long.parseLong(this.a.app.getCurrentAccountUin()));
      return;
    }
    QLog.i("QQInitHandler", 1, "ChkeckLoveStateRequest diden`t send");
  }
  
  private void a()
  {
    C();
    ((FriendListHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getSelfXManInfo();
    c(23);
    e();
    d();
    apcx.a(this.a.app);
    appb.a(BaseApplicationImpl.getContext(), this.a.app);
    this.a.app.getMessageFacade().handleRevokeNotifyAfterSyncMsg();
    ((use)this.a.app.getManager(QQManagerFactory.PA_REPORT_MANAGER)).a();
    Object localObject = (akqe)this.a.app.getManager(QQManagerFactory.PASSWD_RED_BAG_MANAGER);
    ((akqe)localObject).b();
    ((akqe)localObject).a();
    akqz.a(this.a.app);
    a("checkDelAbnormalLocalTroopMsg onReconnect");
    int i = NetworkUtil.getSystemNetwork(BaseApplicationImpl.getApplication());
    switch (i)
    {
    case 2: 
    default: 
      if (i == 1) {
        ((PhotoPlusManager)this.a.app.getManager(QQManagerFactory.PHOTO_PLUS_MANAGER)).a(false);
      }
      acma.a(this.a.app, this.a.app.getCurrentAccountUin(), -1, "doOnReconnect");
      QWalletHelper.getPayCode(this.a.app);
      if (Math.abs(System.currentTimeMillis() - ShortVideoResourceManager.a) > 3600000L) {
        ShortVideoResourceManager.a(this.a.app, 2);
      }
      break;
    }
    for (;;)
    {
      localObject = (anri)this.a.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
      aozr localaozr = (aozr)this.a.app.getManager(QQManagerFactory.CLASSIC_HEAD_ACIVITY_MANAGER);
      if ((localObject != null) && (localaozr != null) && (localaozr.a())) {
        ((anri)localObject).e();
      }
      b(2);
      QQAppInterface.initHeadCfg();
      a((anri)localObject);
      aiin.a(this.a.app).c();
      pvr.a();
      u();
      bdvn.a();
      return;
      ((aipw)this.a.app.getManager(QQManagerFactory.SEND_BLESS_CONFIG_MANAGER)).g();
      break;
      QLog.d("ShortVideoResourceManager", 1, "[network]not need get config...");
    }
  }
  
  private void a(anri paramanri)
  {
    if (paramanri != null)
    {
      paramanri.t();
      paramanri.s();
      paramanri.q();
      paramanri.r();
      paramanri.C();
    }
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.del_abnormal_troop_local_msg", 2, paramString);
    }
    this.a.app.getMsgHandler().q();
  }
  
  private void b(int paramInt)
  {
    aktz localaktz = (aktz)this.a.app.getManager(QQManagerFactory.QWALLET_CONFIG_MANAGER);
    if (localaktz != null) {
      localaktz.a(paramInt);
    }
  }
  
  private void c(int paramInt)
  {
    Object localObject = (FriendListHandler)this.a.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
    this.a.app.getMsgHandler().i();
    this.a.app.getMsgHandler().j();
    E();
    ((antl)this.a.app.getBusinessHandler(BusinessHandlerFactory.DISCUSSION_HANDLER)).b();
    ((anvk)this.a.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).c();
    ((FriendListHandler)localObject).notifySyncQQHead();
    ((FriendListHandler)localObject).notifySyncSignature();
    localObject = this.a.app.getMsgHandler();
    boolean bool2;
    if (!this.a.b)
    {
      bool1 = true;
      if (this.a.c) {
        break label399;
      }
      bool2 = true;
      label132:
      ((MessageHandler)localObject).a(bool1, bool2);
      this.a.app.getMsgHandler().m();
      this.a.app.getMessageFacade().handleRevokeNotifyAfterSyncMsg();
      if (!QZoneHelper.hideQzoneStatusInConverstation()) {
        break label404;
      }
      QLog.i("QQInitHandler", 2, "updateQzoneFeeds 下发配置隐藏新动态");
      label181:
      pwb.d(this.b);
      localObject = (PhoneContactManagerImp)this.a.app.getManager(QQManagerFactory.CONTACT_MANAGER);
      if (paramInt != 22) {
        break label426;
      }
    }
    label399:
    label404:
    label426:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((PhoneContactManagerImp)localObject).a(bool1);
      try
      {
        localObject = (AccessibilityManager)this.a.app.getApp().getSystemService("accessibility");
        bool1 = ((AccessibilityManager)localObject).isEnabled();
        bool2 = ((AccessibilityManager)localObject).isTouchExplorationEnabled();
        if ((bool1) && (bool2))
        {
          localObject = BaseApplicationImpl.getApplication().getSharedPreferences("Talkback" + this.a.app.getCurrentAccountUin(), 0);
          long l = ((SharedPreferences)localObject).getLong("ReportTime", 0L);
          if (System.currentTimeMillis() - l > 86400000L)
          {
            bdla.b(this.a.app, "dc00898", "", "", "0X800A4C7", "0X800A4C7", 0, 0, "", "0", "", "");
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
      bdms.a(BaseApplicationImpl.getApplication());
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label132;
      ((FeedsManager)this.a.app.getManager(QQManagerFactory.QZONE_NEW_STATUS_MANAGER)).updateQzoneFeeds();
      break label181;
    }
  }
  
  private void d()
  {
    apgi localapgi = (apgi)this.a.app.getManager(QQManagerFactory.AR_RESOURCE_MANAGER);
    if (localapgi != null) {
      localapgi.a(true, false);
    }
  }
  
  private void e()
  {
    azod localazod = (azod)this.a.app.getManager(QQManagerFactory.PRECOVER_MANAGER);
    if (localazod != null)
    {
      if (localazod.a()) {
        arph.f(this.a.app, this.a.app.getCurrentAccountUin());
      }
    }
    else {
      return;
    }
    localazod.a();
  }
  
  private void f()
  {
    if (bdgy.f) {}
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
  
  private void g()
  {
    QLog.d("QQInitHandler", 1, "call doAfterLogin");
    new ally().a(this.a.app);
    baiw.a();
    bhxq.a().b(BaseApplicationImpl.sApplication);
    bhxq.a().a(this.a.app);
    ThreadManager.getSubThreadHandler().post(new AfterSyncMsg.1(this));
    UnifiedMonitor.a(SQLiteOpenHelper.WAL_ENABLE);
    DropFrameMonitor.notifyMsgSyncedForLogin();
    this.a.app.getProxyManager().a().c();
    this.a.app.getProxyManager().a();
    this.a.app.getCacheManager().initLazy();
    this.a.app.initSecureFileFramework();
    this.a.app.getMessageFacade().refreshRecentCache_Lazy(0, false);
    ((vzu)this.a.app.getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER)).a();
    ((vzu)this.a.app.getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER)).b();
    ((FlashChatManager)this.a.app.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).a();
    ((vzu)this.a.app.getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER)).c();
    t();
    D();
    f();
    ((aocy)this.a.app.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER)).a();
    this.a.app.isStartSyncOnlineFriend = true;
    this.a.app.syncOnlineFriend();
    this.a.app.addManager(false);
    C();
    s();
    B();
    c(22);
    ((anty)this.a.app.getManager(QQManagerFactory.EQQ_DETAIL_DATA_MANAGER)).a();
    q();
    ((aoan)this.a.app.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER)).a();
    oli.a().a(this.a.app);
    this.a.app.getManager(QQManagerFactory.PUBLIC_ACCOUNT_ENTITY_HELPER);
    r();
    Object localObject1 = (oay)this.a.app.getManager(QQManagerFactory.ACCOUNT_DETAIL_DYNAMIC_DATA_MANAGER);
    p();
    f();
    usu.a(this.a.app);
    usu.a(this.a.app, usu.a(this.a.app));
    this.a.app.getMsgHandler().o();
    this.a.app.getMessageFacade().handleRevokeNotifyAfterSyncMsg();
    bhkf.b();
    ((use)this.a.app.getManager(QQManagerFactory.PA_REPORT_MANAGER)).a();
    localObject1 = (ajco)this.a.app.getManager(QQManagerFactory.PHONE_UNITY_MANAGER);
    ((ajco)localObject1).b();
    Object localObject2 = (akqe)this.a.app.getManager(QQManagerFactory.PASSWD_RED_BAG_MANAGER);
    ((akqe)localObject2).a(false);
    ((akqe)localObject2).d();
    ((akqe)localObject2).b();
    ((akqe)localObject2).a();
    ((bgmf)this.a.app.getManager(QQManagerFactory.TROOP_TIPS_MSG_MANAGER)).a(this.a.app);
    a("checkDelAbnormalLocalTroopMsg afterLogin");
    this.a.app.getBrowserFontSetting();
    afoc.a(this.a.app);
    bdki.a();
    bdki.b();
    bdki.e();
    l();
    k();
    bdkc.a().a();
    bdjx.a();
    akqz.a(this.a.app);
    QWalletHelper.getPayCode(this.a.app);
    HippyAccessHelper.clearPreloadHippy();
    o();
    n();
    f();
    ((anvk)this.a.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(true);
    ((aizi)this.a.app.getManager(QQManagerFactory.NEW_FRIEND_MANAGER)).i();
    ((KandianMergeManager)this.a.app.getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER)).a();
    ((ansg)this.a.app.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)).f();
    m();
    x();
    this.a.app.getRecentUserProxy().a();
    this.a.app.getManager(QQManagerFactory.GAME_CENTER_MSG_MANAGER);
    ((FlashChatManager)this.a.app.getManager(QQManagerFactory.FLASH_CHAT_MANAGER)).c();
    DeviceProfileManager.a(new aohq());
    bfbz.a(this.a.app).a();
    bkyy.a(this.a.app).b();
    b(1);
    albe.a();
    ((PreDownloadScheduler)this.a.app.getManager(QQManagerFactory.PRE_DOWNLOAD_SCHEDULER_MANAGER)).startPreDownload();
    QuicResDownload.a(this.a.app);
    ((awtu)this.a.app.getManager(QQManagerFactory.TIM_JUMP_LOGIN_MANAGER)).a();
    localObject2 = (anri)this.a.app.getBusinessHandler(BusinessHandlerFactory.CARD_HANLDER);
    ((anri)localObject2).w();
    ovr.a();
    tmz.a(false);
    w();
    SosoInterface.startOfficialLocation();
    bixr.a(this.a.app);
    biyr.a();
    QQAppInterface.initHeadCfg();
    v();
    ahqp.a(((ajco)localObject1).a).a();
    a((anri)localObject2);
    y();
    aiin.a(this.a.app).c();
    aiin.a(this.a.app).e();
    MiniArkShareAsyncManager.registerMiniArkShareMessageProcessorAfterProcessRestart();
    NotificationReportUtil.reportAll();
    f();
    awnk.b();
    z();
    A();
    becs.a(this.a.app).a();
    u();
    ThreadManager.getFileThreadHandler().post(new AfterSyncMsg.2(this));
    F();
    aqrl.b(true);
    this.a.app.registerBatteryBroadcastReceiver();
    ((aqoj)this.a.app.getBusinessHandler(BusinessHandlerFactory.COLOR_NOTE_HANDLER)).a();
    ajmy.a(this.a.app);
    aclr.a(this.a.app);
    aoys.a(true);
    DtSdkInitStep.a();
    ntj.a(this.a.app, true);
    bfcs.a(this.a.app);
    banp.a().b().a("firstInit");
    i();
    h();
    j();
  }
  
  private void h()
  {
    if (asbi.jdField_a_of_type_Boolean)
    {
      if (GuardManager.a != null) {
        GuardManager.a.a(BaseApplicationImpl.processName);
      }
      asbi.a();
      asbi.jdField_a_of_type_Boolean = false;
      QLog.d("QQInitHandler", 1, "848QQDT [doAfterLogin] report");
    }
  }
  
  private void i()
  {
    if (this.a.app != null) {
      ((bdud)this.a.app.getBusinessHandler(BusinessHandlerFactory.TEENS_MODE_ALPHABETIC_FONT_HANDLER)).a();
    }
  }
  
  private void j()
  {
    if (this.a.app != null) {
      ((alkd)this.a.app.getManager(QQManagerFactory.NEWER_GUIDE_BANNER_MANAGER)).a();
    }
  }
  
  private void k()
  {
    if (!bdgy.c) {
      ((aoyg)this.a.app.getFTSDBManager().a(2)).g();
    }
    do
    {
      return;
      bdgy.g = System.currentTimeMillis();
    } while (!QLog.isColorLevel());
    QLog.d("Perf", 2, "delay checkTroopTimeStamp");
  }
  
  private void l()
  {
    SearchConfigManager.a(this.a.app);
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts", 2, "troopMemberUpdateConfigStr=" + SearchConfigManager.troopMemberUpdateConfigStr);
    }
  }
  
  private void m()
  {
    qia localqia = pvj.a().a();
    if (localqia != null) {
      localqia.a(this.a.app.getCurrentUin());
    }
  }
  
  private void n()
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler_PushOpenNotify", 2, "doafterlogin");
      }
      new aorf(this.a.app).execute(new Void[0]);
    }
  }
  
  private void o()
  {
    aozr localaozr = (aozr)this.a.app.getManager(QQManagerFactory.CLASSIC_HEAD_ACIVITY_MANAGER);
    if ((localaozr != null) && (localaozr.a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 4, " QQ 18 handle actionB cached stranger head update in AfterSyncMsg doAfterLogin");
      }
      localaozr.b();
    }
  }
  
  private void p()
  {
    aohe localaohe = (aohe)this.a.app.getManager(QQManagerFactory.MGR_ACTVATE_FRIENDS);
    if (localaohe != null) {
      localaohe.a();
    }
  }
  
  private void q()
  {
    ThreadManager.getSubThreadHandler().post(new AfterSyncMsg.3(this));
  }
  
  private void r()
  {
    ofd localofd = (ofd)this.a.app.getManager(QQManagerFactory.PUBLIC_ACCOUNT_VIDEO_PRELOAD_MANAGER);
    if (localofd != null)
    {
      if (!"5.0.2".equals(Build.VERSION.RELEASE)) {
        localofd.a();
      }
      localofd.a(this.a.app.getCurrentUin());
    }
    avqv localavqv = (avqv)this.a.app.getManager(QQManagerFactory.IMAX_AD_VIDEO_PRELOAD_MANAGER);
    if (localofd != null) {
      localavqv.a(this.a.app, this.a.app.getCurrentUin());
    }
  }
  
  private void s()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, new Object[] { "AfterSyncMsg sendEmptyMessageDelayedToHandler MSG_INIT_MSGTAG_STORY process, send, ", Boolean.valueOf(this.a.b()) });
    }
    MqqHandler localMqqHandler = this.a.app.getHandler(Conversation.class);
    localMqqHandler.sendEmptyMessage(1055);
    localMqqHandler.sendEmptyMessage(1059);
    localMqqHandler.sendEmptyMessage(1061);
  }
  
  private void t()
  {
    Object localObject = this.a.app.getApplication().getApplicationContext().getSharedPreferences(this.a.app.getAccount(), 0);
    long l = ((SharedPreferences)localObject).getLong("sp_vip_info_request_time", 0L);
    int i = ((SharedPreferences)localObject).getInt("sp_vip_info_update_freq", 10);
    if (NetConnInfoCenter.getServerTime() - l > i * 60)
    {
      localObject = this.a.app.getCurrentAccountUin();
      String str = ((TicketManager)this.a.app.getManager(2)).getSkey((String)localObject);
      ((aogw)this.a.app.getBusinessHandler(BusinessHandlerFactory.VIPINFO_HANDLER)).a(str, (String)localObject);
    }
  }
  
  private void u()
  {
    ThreadManager.executeOnSubThread(new AfterSyncMsg.4(this));
  }
  
  private void v()
  {
    algs.a().a(this.a.app, BaseApplicationImpl.sApplication, true, false);
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "doAfterLogin call MayknowRecommendManager.getMayKnowRecommendRemote ");
    }
    ((anyb)this.a.app.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).a(1);
  }
  
  private void w()
  {
    ThreadManager.executeOnSubThread(new AfterSyncMsg.5(this));
  }
  
  private void x()
  {
    List localList = ((ProxyManager)this.a.app.getManager(QQManagerFactory.PROXY_MANAGER)).a().getRecentList(true);
    int i = 0;
    while (i < localList.size())
    {
      if (((RecentUser)localList.get(i)).lFlag == 16L)
      {
        Iterator localIterator = this.a.app.getMessageFacade().getMsgList(((RecentUser)localList.get(i)).uin, ((RecentUser)localList.get(i)).getType()).iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (MessageRecord)localIterator.next();
          localObject = ofj.a(this.a.app, (MessageRecord)localObject, true);
          if (localObject != null) {
            oez.a().a((oeq)localObject);
          }
        }
      }
      i += 1;
    }
  }
  
  private void y()
  {
    Object localObject = (ArkAppCenter)this.a.app.getManager(QQManagerFactory.ARK_APP_CENTER_MANAGER);
    if (localObject != null)
    {
      localObject = ((ArkAppCenter)localObject).a();
      if (localObject != null) {
        ((apyu)localObject).b();
      }
    }
  }
  
  private void z()
  {
    ((bfzk)this.a.app.getManager(QQManagerFactory.TROOP_AIO_NAVIGATE_BAR)).a();
    MqqHandler localMqqHandler = this.a.app.getHandler(Conversation.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(1134064).sendToTarget();
    }
  }
  
  public int a()
  {
    switch (this.b)
    {
    default: 
      this.a.app.getMsgHandler().a(false);
      this.a.notifyUI(6008, false, null, true);
    }
    for (;;)
    {
      return 7;
      g();
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
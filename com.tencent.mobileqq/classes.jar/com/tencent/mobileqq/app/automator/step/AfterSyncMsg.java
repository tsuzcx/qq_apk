package com.tencent.mobileqq.app.automator.step;

import MQQ.PayRuleCfg;
import abvk;
import abvt;
import abwy;
import aewr;
import agxo;
import ahns;
import ahux;
import aiej;
import aihp;
import airj;
import ajul;
import ajvg;
import ajyg;
import akfl;
import akla;
import amov;
import ampt;
import amqx;
import amrk;
import amsw;
import amvo;
import amxz;
import anaj;
import anca;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.view.accessibility.AccessibilityManager;
import aneg;
import aneo;
import aneq;
import anfa;
import anom;
import anux;
import anuz;
import anvg;
import anvs;
import anwp;
import anzv;
import aodg;
import aoma;
import aovq;
import aplf;
import apoh;
import aqlw;
import aqwy;
import aula;
import avhh;
import avnp;
import ayji;
import azhh;
import bbnx;
import bcad;
import bcdc;
import bcdh;
import bcdn;
import bcef;
import bcfu;
import bcnd;
import bcoo;
import bcvt;
import bduw;
import bdvp;
import bese;
import bfdz;
import bgbo;
import bgng;
import bhnb;
import bhny;
import bhov;
import bhzj;
import bjnm;
import blau;
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
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.GuardManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
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
import nmj;
import ntx;
import nxq;
import nxz;
import nyd;
import nyj;
import odr;
import onu;
import pkm;
import pku;
import ple;
import pwu;
import szr;
import ueh;
import uex;
import vkz;

public class AfterSyncMsg
  extends AsyncStep
{
  private void A()
  {
    if (bhov.a(this.a.app.getApp()) != 2) {
      MiniAppController.preloadMiniProcess();
    }
  }
  
  private void B()
  {
    if (this.a.jdField_a_of_type_Boolean) {
      ((anca)this.a.app.getBusinessHandler(20)).b();
    }
  }
  
  private void C()
  {
    PayRuleCfg localPayRuleCfg = aneg.a(this.a.app.getCurrentUin());
    if (aneg.a(this.a.app, localPayRuleCfg, true)) {
      ThreadManagerV2.getUIHandlerV2().post(new AfterSyncMsg.6(this));
    }
  }
  
  private void D()
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
            break label373;
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
              break label384;
            }
          }
          label384:
          for (localObject1 = "sys_" + String.valueOf(((Setting)localObject2).systemHeadID);; localObject1 = ((Setting)localObject2).uin)
          {
            localObject2 = new File(str1);
            if (!localHashtable.containsKey(localObject1)) {
              break label393;
            }
            if (!((File)localObject2).exists()) {
              break;
            }
            ((File)localObject2).delete();
            break;
            localObject1 = ((Setting)localObject2).uin;
            break label258;
            label373:
            localObject1 = ((Setting)localObject2).uin;
            j = 1;
            break label260;
          }
          label393:
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
      bhzj.a((File)localObject1);
    }
    localObject1 = new File("/data/data/com.tencent.mobileqq/files/head/_thd/");
    if (((File)localObject1).exists()) {
      bhzj.a((File)localObject1);
    }
    this.a.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("isConvertOldQQHeadOK", true).commit();
  }
  
  private void E()
  {
    if ((this.a != null) && (this.a.app != null))
    {
      new blau().a(Long.parseLong(this.a.app.getCurrentAccountUin()));
      return;
    }
    QLog.i("QQInitHandler", 1, "ChkeckLoveStateRequest diden`t send");
  }
  
  private void a()
  {
    B();
    ((FriendListHandler)this.a.app.getBusinessHandler(1)).getSelfXManInfo();
    c(23);
    e();
    d();
    anzv.a(this.a.app);
    aoma.a(BaseApplicationImpl.getContext(), this.a.app);
    this.a.app.getMessageFacade().handleRevokeNotifyAfterSyncMsg();
    ((ueh)this.a.app.getManager(101)).a();
    Object localObject = (ajul)this.a.app.getManager(125);
    ((ajul)localObject).b();
    ((ajul)localObject).a();
    ajvg.a(this.a.app);
    a("checkDelAbnormalLocalTroopMsg onReconnect");
    int i = NetworkUtil.getSystemNetwork(BaseApplicationImpl.getApplication());
    switch (i)
    {
    case 2: 
    default: 
      if (i == 1) {
        ((PhotoPlusManager)this.a.app.getManager(169)).a(false);
      }
      abvt.a(this.a.app, this.a.app.getCurrentAccountUin(), -1, "doOnReconnect");
      QWalletHelper.getPayCode(this.a.app);
      if (Math.abs(System.currentTimeMillis() - ShortVideoResourceManager.a) > 3600000L) {
        ShortVideoResourceManager.a(this.a.app, 2);
      }
      break;
    }
    for (;;)
    {
      localObject = (amov)this.a.app.getBusinessHandler(2);
      anwp localanwp = (anwp)this.a.app.getManager(199);
      if ((localObject != null) && (localanwp != null) && (localanwp.a())) {
        ((amov)localObject).e();
      }
      b(2);
      QQAppInterface.initHeadCfg();
      a((amov)localObject);
      ahns.a(this.a.app).c();
      pku.a();
      t();
      bcoo.a();
      return;
      ((ahux)this.a.app.getManager(138)).g();
      break;
      QLog.d("ShortVideoResourceManager", 1, "[network]not need get config...");
    }
  }
  
  private void a(amov paramamov)
  {
    if (paramamov != null)
    {
      paramamov.t();
      paramamov.s();
      paramamov.q();
      paramamov.r();
      paramamov.C();
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
    ajyg localajyg = (ajyg)this.a.app.getManager(245);
    if (localajyg != null) {
      localajyg.a(paramInt);
    }
  }
  
  private void c(int paramInt)
  {
    Object localObject = (FriendListHandler)this.a.app.getBusinessHandler(1);
    this.a.app.getMsgHandler().i();
    this.a.app.getMsgHandler().j();
    D();
    ((amqx)this.a.app.getBusinessHandler(6)).b();
    ((amsw)this.a.app.getManager(51)).c();
    ((FriendListHandler)localObject).notifySyncQQHead();
    ((FriendListHandler)localObject).notifySyncSignature();
    localObject = this.a.app.getMsgHandler();
    boolean bool2;
    if (!this.a.b)
    {
      bool1 = true;
      if (this.a.c) {
        break label394;
      }
      bool2 = true;
      label128:
      ((MessageHandler)localObject).a(bool1, bool2);
      this.a.app.getMsgHandler().m();
      this.a.app.getMessageFacade().handleRevokeNotifyAfterSyncMsg();
      if (!QZoneHelper.hideQzoneStatusInConverstation()) {
        break label399;
      }
      QLog.i("QQInitHandler", 2, "updateQzoneFeeds 下发配置隐藏新动态");
      label177:
      ple.d(this.b);
      localObject = (PhoneContactManagerImp)this.a.app.getManager(11);
      if (paramInt != 22) {
        break label421;
      }
    }
    label394:
    label399:
    label421:
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
            bcef.b(this.a.app, "dc00898", "", "", "0X800A4C7", "0X800A4C7", 0, 0, "", "0", "", "");
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
      bcfu.a(BaseApplicationImpl.getApplication());
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label128;
      ((FeedsManager)this.a.app.getManager(275)).updateQzoneFeeds();
      break label177;
    }
  }
  
  private void d()
  {
    aodg localaodg = (aodg)this.a.app.getManager(168);
    if (localaodg != null) {
      localaodg.a(true, false);
    }
  }
  
  private void e()
  {
    ayji localayji = (ayji)this.a.app.getManager(179);
    if (localayji != null)
    {
      if (localayji.a()) {
        aqlw.f(this.a.app, this.a.app.getCurrentAccountUin());
      }
    }
    else {
      return;
    }
    localayji.a();
  }
  
  private void f()
  {
    if (bcad.f) {}
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
    bgng.a().b(BaseApplicationImpl.sApplication);
    bgng.a().a(this.a.app);
    ThreadManager.getSubThreadHandler().post(new AfterSyncMsg.1(this));
    UnifiedMonitor.a(SQLiteOpenHelper.WAL_ENABLE);
    DropFrameMonitor.notifyMsgSyncedForLogin();
    this.a.app.getProxyManager().a().c();
    this.a.app.getProxyManager().a();
    this.a.app.getCacheManager().initLazy();
    this.a.app.initSecureFileFramework();
    this.a.app.getMessageFacade().refreshRecentCache_Lazy(0, false);
    ((vkz)this.a.app.getBusinessHandler(98)).a();
    ((vkz)this.a.app.getBusinessHandler(98)).b();
    ((FlashChatManager)this.a.app.getManager(217)).a();
    ((vkz)this.a.app.getBusinessHandler(98)).c();
    s();
    C();
    f();
    ((anaj)this.a.app.getBusinessHandler(13)).a();
    this.a.app.isStartSyncOnlineFriend = true;
    this.a.app.syncOnlineFriend();
    this.a.app.addManager(false);
    B();
    r();
    A();
    c(22);
    ((amrk)this.a.app.getManager(69)).a();
    p();
    ((amxz)this.a.app.getManager(56)).a();
    odr.a().a(this.a.app);
    this.a.app.getManager(237);
    q();
    Object localObject1 = (ntx)this.a.app.getManager(173);
    o();
    f();
    uex.a(this.a.app);
    uex.a(this.a.app, uex.a(this.a.app));
    this.a.app.getMsgHandler().o();
    this.a.app.getMessageFacade().handleRevokeNotifyAfterSyncMsg();
    bgbo.b();
    ((ueh)this.a.app.getManager(101)).a();
    localObject1 = (aihp)this.a.app.getManager(102);
    ((aihp)localObject1).b();
    Object localObject2 = (ajul)this.a.app.getManager(125);
    ((ajul)localObject2).a(false);
    ((ajul)localObject2).d();
    ((ajul)localObject2).b();
    ((ajul)localObject2).a();
    ((bfdz)this.a.app.getManager(81)).a(this.a.app);
    a("checkDelAbnormalLocalTroopMsg afterLogin");
    this.a.app.getBrowserFontSetting();
    aewr.a(this.a.app);
    bcdn.a();
    bcdn.b();
    bcdn.e();
    k();
    j();
    bcdh.a().a();
    bcdc.a();
    ajvg.a(this.a.app);
    QWalletHelper.getPayCode(this.a.app);
    HippyAccessHelper.clearPreloadHippy();
    n();
    m();
    f();
    ((amsw)this.a.app.getManager(51)).a(true);
    ((aiej)this.a.app.getManager(34)).i();
    ((KandianMergeManager)this.a.app.getManager(162)).a();
    ((ampt)this.a.app.getBusinessHandler(4)).f();
    l();
    w();
    this.a.app.getRecentUserProxy().a();
    this.a.app.getManager(358);
    ((FlashChatManager)this.a.app.getManager(217)).c();
    DeviceProfileManager.a(new anfa());
    bduw.a(this.a.app).a();
    bjnm.a(this.a.app).b();
    b(1);
    akfl.a();
    ((PreDownloadScheduler)this.a.app.getManager(233)).startPreDownload();
    QuicResDownload.a(this.a.app);
    ((avnp)this.a.app.getManager(242)).a();
    localObject2 = (amov)this.a.app.getBusinessHandler(2);
    ((amov)localObject2).w();
    onu.a();
    szr.a(false);
    v();
    SosoInterface.startOfficialLocation();
    bhnb.a(this.a.app);
    bhny.a();
    QQAppInterface.initHeadCfg();
    u();
    agxo.a(((aihp)localObject1).a).a();
    a((amov)localObject2);
    x();
    ahns.a(this.a.app).c();
    ahns.a(this.a.app).e();
    MiniArkShareAsyncManager.registerMiniArkShareMessageProcessorAfterProcessRestart();
    NotificationReportUtil.reportAll();
    f();
    avhh.b();
    y();
    z();
    bcvt.a(this.a.app).a();
    t();
    ThreadManager.getFileThreadHandler().post(new AfterSyncMsg.2(this));
    E();
    apoh.b(true);
    this.a.app.registerBatteryBroadcastReceiver();
    ((aplf)this.a.app.getBusinessHandler(168)).a();
    airj.a(this.a.app);
    abvk.a(this.a.app);
    anvs.a(true);
    DtSdkInitStep.a();
    nmj.a(this.a.app, true);
    bdvp.a(this.a.app);
    azhh.a().b().a("firstInit");
    i();
    h();
  }
  
  private void h()
  {
    if (aqwy.jdField_a_of_type_Boolean)
    {
      if (GuardManager.a != null) {
        GuardManager.a.a(BaseApplicationImpl.processName);
      }
      aqwy.a();
      aqwy.jdField_a_of_type_Boolean = false;
      QLog.d("QQInitHandler", 1, "848QQDT [doAfterLogin] report");
    }
  }
  
  private void i()
  {
    if (this.a.app != null) {
      ((bcnd)this.a.app.getBusinessHandler(190)).a();
    }
  }
  
  private void j()
  {
    if (!bcad.c) {
      ((anvg)this.a.app.getFTSDBManager().a(2)).g();
    }
    do
    {
      return;
      bcad.g = System.currentTimeMillis();
    } while (!QLog.isColorLevel());
    QLog.d("Perf", 2, "delay checkTroopTimeStamp");
  }
  
  private void k()
  {
    SearchConfigManager.a(this.a.app);
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts", 2, "troopMemberUpdateConfigStr=" + SearchConfigManager.troopMemberUpdateConfigStr);
    }
  }
  
  private void l()
  {
    pwu localpwu = pkm.a().a();
    if (localpwu != null) {
      localpwu.a(this.a.app.getCurrentUin());
    }
  }
  
  private void m()
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler_PushOpenNotify", 2, "doafterlogin");
      }
      new anom(this.a.app).execute(new Void[0]);
    }
  }
  
  private void n()
  {
    anwp localanwp = (anwp)this.a.app.getManager(199);
    if ((localanwp != null) && (localanwp.a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 4, " QQ 18 handle actionB cached stranger head update in AfterSyncMsg doAfterLogin");
      }
      localanwp.b();
    }
  }
  
  private void o()
  {
    aneo localaneo = (aneo)this.a.app.getManager(85);
    if (localaneo != null) {
      localaneo.a();
    }
  }
  
  private void p()
  {
    ThreadManager.getSubThreadHandler().post(new AfterSyncMsg.3(this));
  }
  
  private void q()
  {
    nyd localnyd = (nyd)this.a.app.getManager(238);
    if (localnyd != null)
    {
      if (!"5.0.2".equals(Build.VERSION.RELEASE)) {
        localnyd.a();
      }
      localnyd.a(this.a.app.getCurrentUin());
    }
    aula localaula = (aula)this.a.app.getManager(268);
    if (localnyd != null) {
      localaula.a(this.a.app, this.a.app.getCurrentUin());
    }
  }
  
  private void r()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, new Object[] { "AfterSyncMsg sendEmptyMessageDelayedToHandler MSG_INIT_MSGTAG_STORY process, send, ", Boolean.valueOf(this.a.b()) });
    }
    MqqHandler localMqqHandler = this.a.app.getHandler(Conversation.class);
    localMqqHandler.sendEmptyMessage(1055);
    localMqqHandler.sendEmptyMessage(1059);
    localMqqHandler.sendEmptyMessage(1061);
  }
  
  private void s()
  {
    Object localObject = this.a.app.getApplication().getApplicationContext().getSharedPreferences(this.a.app.getAccount(), 0);
    long l = ((SharedPreferences)localObject).getLong("sp_vip_info_request_time", 0L);
    int i = ((SharedPreferences)localObject).getInt("sp_vip_info_update_freq", 10);
    if (NetConnInfoCenter.getServerTime() - l > i * 60)
    {
      localObject = this.a.app.getCurrentAccountUin();
      String str = ((TicketManager)this.a.app.getManager(2)).getSkey((String)localObject);
      ((aneg)this.a.app.getBusinessHandler(27)).a(str, (String)localObject);
    }
  }
  
  private void t()
  {
    ThreadManager.executeOnSubThread(new AfterSyncMsg.4(this));
  }
  
  private void u()
  {
    akla.a().a(this.a.app, BaseApplicationImpl.sApplication, true, false);
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "doAfterLogin call MayknowRecommendManager.getMayKnowRecommendRemote ");
    }
    ((amvo)this.a.app.getManager(159)).a(1);
  }
  
  private void v()
  {
    ThreadManager.executeOnSubThread(new AfterSyncMsg.5(this));
  }
  
  private void w()
  {
    List localList = ((ProxyManager)this.a.app.getManager(18)).a().getRecentList(true);
    int i = 0;
    while (i < localList.size())
    {
      if (((RecentUser)localList.get(i)).lFlag == 16L)
      {
        Iterator localIterator = this.a.app.getMessageFacade().getMsgList(((RecentUser)localList.get(i)).uin, ((RecentUser)localList.get(i)).getType()).iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (MessageRecord)localIterator.next();
          localObject = nyj.a(this.a.app, (MessageRecord)localObject, true);
          if (localObject != null) {
            nxz.a().a((nxq)localObject);
          }
        }
      }
      i += 1;
    }
  }
  
  private void x()
  {
    Object localObject = (ArkAppCenter)this.a.app.getManager(121);
    if (localObject != null)
    {
      localObject = ((ArkAppCenter)localObject).a();
      if (localObject != null) {
        ((aovq)localObject).b();
      }
    }
  }
  
  private void y()
  {
    ((bese)this.a.app.getManager(363)).a();
    MqqHandler localMqqHandler = this.a.app.getHandler(Conversation.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(1134064).sendToTarget();
    }
  }
  
  private void z()
  {
    if (bbnx.a(1, BaseApplicationImpl.processName)) {}
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
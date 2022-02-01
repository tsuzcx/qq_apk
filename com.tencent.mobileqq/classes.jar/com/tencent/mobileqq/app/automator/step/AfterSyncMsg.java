package com.tencent.mobileqq.app.automator.step;

import MQQ.PayRuleCfg;
import aczb;
import aczk;
import adaj;
import adlb;
import agdx;
import aiay;
import aiti;
import ajan;
import ajka;
import ajng;
import ajwm;
import akwu;
import akxp;
import alao;
import alhs;
import alni;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.view.accessibility.AccessibilityManager;
import antf;
import anum;
import anvl;
import anwo;
import anxb;
import anyw;
import aobl;
import aody;
import aogu;
import aoip;
import aokv;
import aold;
import aolf;
import aolp;
import aovm;
import apau;
import apaw;
import apbd;
import apbp;
import apdc;
import apgj;
import apjt;
import apsn;
import aqcf;
import aqrw;
import aquy;
import arry;
import avya;
import awub;
import axai;
import azut;
import bcun;
import bdho;
import bdki;
import bdkn;
import bdkt;
import bdll;
import bdnj;
import bduy;
import becc;
import bezi;
import bezz;
import bflw;
import bfmf;
import bgiw;
import bgul;
import bhjr;
import bhmi;
import bhnv;
import bhut;
import bigw;
import bjhk;
import bjik;
import bjjh;
import bjtu;
import blhw;
import bmtd;
import bnvp;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.NotificationReportUtil;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mfsdk.reporter.ReporterMachine;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.FriendListHandler;
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
import com.tencent.mobileqq.utils.quic.QuicResDownload;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trackrecordlib.core.RecordManager;
import cooperation.photoplus.PhotoPlusManager;
import cooperation.qwallet.plugin.QWalletHelper;
import java.io.File;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import mqq.os.MqqHandler;
import nso;
import nwf;
import nwo;
import nws;
import nwy;
import oce;
import omj;
import pfa;
import pfi;
import pfs;
import pra;
import svr;
import txs;
import tyi;
import vvw;
import wja;

public class AfterSyncMsg
  extends AsyncStep
{
  private void A()
  {
    PayRuleCfg localPayRuleCfg = aokv.a(this.a.app.c());
    if (aokv.a(this.a.app, localPayRuleCfg, true)) {
      ThreadManagerV2.getUIHandlerV2().post(new AfterSyncMsg.6(this));
    }
  }
  
  private void B()
  {
    if (bhjr.a())
    {
      bhmi.c(antf.bL + ".nomedia");
      bhmi.c(antf.bM + ".nomedia");
    }
    if (this.a.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("isConvertOldQQHeadOK", false)) {
      return;
    }
    Hashtable localHashtable = new Hashtable();
    EntityManager localEntityManager = this.a.app.a().createEntityManager();
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
            break label372;
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
            str1 = this.a.app.a(j, (String)localObject1);
            str2 = this.a.app.a((Setting)localObject2, j, (String)localObject1, 0);
            if (((Setting)localObject2).bHeadType != 0) {
              break label383;
            }
          }
          label372:
          label383:
          for (localObject1 = "sys_" + String.valueOf(((Setting)localObject2).systemHeadID);; localObject1 = ((Setting)localObject2).uin)
          {
            localObject2 = new File(str1);
            if (!localHashtable.containsKey(localObject1)) {
              break label392;
            }
            if (!((File)localObject2).exists()) {
              break;
            }
            ((File)localObject2).delete();
            break;
            localObject1 = ((Setting)localObject2).uin;
            break label258;
            localObject1 = ((Setting)localObject2).uin;
            j = 1;
            break label260;
          }
          label392:
          if (((File)localObject2).exists())
          {
            bezi.a(str1, str2);
            ((File)localObject2).delete();
            localHashtable.put(localObject1, Boolean.valueOf(true));
          }
        }
      }
    }
    localEntityManager.close();
    Object localObject1 = new File(antf.bL + "_thd/");
    if (((File)localObject1).exists()) {
      bjtu.a((File)localObject1);
    }
    localObject1 = new File("/data/data/com.tencent.mobileqq/files/head/_thd/");
    if (((File)localObject1).exists()) {
      bjtu.a((File)localObject1);
    }
    this.a.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("isConvertOldQQHeadOK", true).commit();
  }
  
  private void C()
  {
    if ((this.a != null) && (this.a.app != null))
    {
      new bnvp().a(Long.parseLong(this.a.app.getCurrentAccountUin()));
      return;
    }
    QLog.i("QQInitHandler", 1, "ChkeckLoveStateRequest diden`t send");
  }
  
  private void a()
  {
    z();
    ((FriendListHandler)this.a.app.a(1)).d();
    c(23);
    e();
    d();
    apgj.a(this.a.app);
    apsn.a(BaseApplicationImpl.getContext(), this.a.app);
    this.a.app.a().m();
    ((txs)this.a.app.getManager(101)).a();
    Object localObject = (akwu)this.a.app.getManager(125);
    ((akwu)localObject).b();
    ((akwu)localObject).a();
    akxp.a(this.a.app);
    a("checkDelAbnormalLocalTroopMsg onReconnect");
    int i = bhnv.a(BaseApplicationImpl.getApplication());
    switch (i)
    {
    case 2: 
    default: 
      if (i == 1) {
        ((PhotoPlusManager)this.a.app.getManager(169)).a(false);
      }
      aczk.a(this.a.app, this.a.app.getCurrentAccountUin(), -1, "doOnReconnect");
      QWalletHelper.getPayCode(this.a.app);
      if (Math.abs(System.currentTimeMillis() - ShortVideoResourceManager.a) > 3600000L) {
        ShortVideoResourceManager.a(this.a.app, 2);
      }
      break;
    }
    for (;;)
    {
      localObject = (anum)this.a.app.a(2);
      apdc localapdc = (apdc)this.a.app.getManager(199);
      if ((localObject != null) && (localapdc != null) && (localapdc.a())) {
        ((anum)localObject).e();
      }
      b(2);
      QQAppInterface.J();
      a((anum)localObject);
      aiti.a(this.a.app).c();
      pfi.a();
      r();
      bduy.a();
      return;
      ((ajan)this.a.app.getManager(138)).g();
      break;
      QLog.d("ShortVideoResourceManager", 1, "[network]not need get config...");
    }
  }
  
  private void a(anum paramanum)
  {
    if (paramanum != null)
    {
      paramanum.t();
      paramanum.s();
      paramanum.q();
      paramanum.r();
      paramanum.C();
    }
  }
  
  private void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(".troop.del_abnormal_troop_local_msg", 2, paramString);
    }
    this.a.app.a().q();
  }
  
  private void b(int paramInt)
  {
    alao localalao = (alao)this.a.app.getManager(245);
    if (localalao != null) {
      localalao.a(paramInt);
    }
  }
  
  private void c(int paramInt)
  {
    Object localObject = (FriendListHandler)this.a.app.a(1);
    this.a.app.a().i();
    this.a.app.a().j();
    B();
    ((anwo)this.a.app.a(6)).b();
    ((anyw)this.a.app.getManager(51)).c();
    ((FriendListHandler)localObject).f();
    ((FriendListHandler)localObject).c();
    localObject = this.a.app.a();
    boolean bool2;
    if (!this.a.b)
    {
      bool1 = true;
      if (this.a.c) {
        break label393;
      }
      bool2 = true;
      label128:
      ((MessageHandler)localObject).a(bool1, bool2);
      this.a.app.a().m();
      this.a.app.a().m();
      if (!bmtd.p()) {
        break label398;
      }
      QLog.i("QQInitHandler", 2, "updateQzoneFeeds 下发配置隐藏新动态");
      label176:
      pfs.d(this.b);
      localObject = (PhoneContactManagerImp)this.a.app.getManager(11);
      if (paramInt != 22) {
        break label420;
      }
    }
    label393:
    label398:
    label420:
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
            bdll.b(this.a.app, "dc00898", "", "", "0X800A4C7", "0X800A4C7", 0, 0, "", "0", "", "");
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
      bdnj.a(BaseApplicationImpl.getApplication());
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label128;
      ((FeedsManager)this.a.app.getManager(275)).updateQzoneFeeds();
      break label176;
    }
  }
  
  private void d()
  {
    apjt localapjt = (apjt)this.a.app.getManager(168);
    if (localapjt != null) {
      localapjt.a(true, false);
    }
  }
  
  private void e()
  {
    azut localazut = (azut)this.a.app.getManager(179);
    if (localazut != null)
    {
      if (localazut.a()) {
        arry.f(this.a.app, this.a.app.getCurrentAccountUin());
      }
    }
    else {
      return;
    }
    localazut.a();
  }
  
  private void f()
  {
    if (bdho.f) {}
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
    bigw.a().b(BaseApplicationImpl.sApplication);
    bigw.a().a(this.a.app);
    ThreadManager.getSubThreadHandler().post(new AfterSyncMsg.1(this));
    UnifiedMonitor.a(SQLiteOpenHelper.WAL_ENABLE);
    adlb.a();
    this.a.app.a().a().c();
    this.a.app.a().a();
    this.a.app.a().initLazy();
    this.a.app.K();
    this.a.app.a().a(0, false);
    ((wja)this.a.app.a(98)).a();
    ((wja)this.a.app.a(98)).b();
    ((FlashChatManager)this.a.app.getManager(217)).a();
    ((wja)this.a.app.a(98)).c();
    q();
    A();
    f();
    ((aogu)this.a.app.a(13)).a();
    this.a.app.m = true;
    this.a.app.B();
    this.a.app.a(false);
    z();
    p();
    y();
    c(22);
    ((anxb)this.a.app.getManager(69)).a();
    n();
    ((aody)this.a.app.getManager(56)).a();
    oce.a().a(this.a.app);
    this.a.app.getManager(237);
    o();
    Object localObject1 = (nso)this.a.app.getManager(173);
    m();
    f();
    tyi.a(this.a.app);
    tyi.a(this.a.app, tyi.a(this.a.app));
    this.a.app.a().o();
    this.a.app.a().m();
    bhut.b();
    ((txs)this.a.app.getManager(101)).a();
    localObject1 = (ajng)this.a.app.getManager(102);
    ((ajng)localObject1).b();
    Object localObject2 = (akwu)this.a.app.getManager(125);
    ((akwu)localObject2).a(false);
    ((akwu)localObject2).d();
    ((akwu)localObject2).b();
    ((akwu)localObject2).a();
    ((bgul)this.a.app.getManager(81)).a(this.a.app);
    a("checkDelAbnormalLocalTroopMsg afterLogin");
    this.a.app.I();
    agdx.a(this.a.app);
    bdkt.a();
    bdkt.b();
    bdkt.e();
    i();
    h();
    bdkn.a().a();
    bdki.a();
    akxp.a(this.a.app);
    QWalletHelper.getPayCode(this.a.app);
    l();
    k();
    f();
    ((anyw)this.a.app.getManager(51)).a(true);
    ((ajka)this.a.app.getManager(34)).i();
    ((KandianMergeManager)this.a.app.getManager(162)).a();
    ((anvl)this.a.app.a(4)).f();
    j();
    u();
    this.a.app.a().a();
    this.a.app.getManager(358);
    ((FlashChatManager)this.a.app.getManager(217)).c();
    DeviceProfileManager.a(new aolp());
    bflw.a(this.a.app).a();
    blhw.a(this.a.app).b();
    b(1);
    alhs.a();
    ((bezz)this.a.app.getManager(233)).a();
    QuicResDownload.a(this.a.app);
    ((axai)this.a.app.getManager(242)).a();
    localObject2 = (anum)this.a.app.a(2);
    ((anum)localObject2).w();
    omj.a();
    svr.a(false);
    t();
    SosoInterface.b();
    bjhk.a(this.a.app);
    bjik.a();
    QQAppInterface.J();
    s();
    aiay.a(((ajng)localObject1).a).a();
    a((anum)localObject2);
    v();
    aiti.a(this.a.app).c();
    aiti.a(this.a.app).e();
    MiniArkShareAsyncManager.registerMiniArkShareMessageProcessorAfterProcessRestart();
    NotificationReportUtil.reportAll();
    f();
    awub.b();
    w();
    x();
    becc.a(this.a.app).a();
    r();
    ThreadManager.getFileThreadHandler().post(new AfterSyncMsg.2(this));
    C();
    aquy.b(true);
    this.a.app.L();
    ((aqrw)this.a.app.a(168)).a();
    ajwm.a(this.a.app);
    aczb.a(this.a.app);
    apbp.a(true);
    vvw.a();
    DtSdkInitStep.a();
    vvw.a();
    bfmf.a(this.a.app);
  }
  
  private void h()
  {
    if (!bdho.c) {
      ((apbd)this.a.app.a().a(2)).g();
    }
    do
    {
      return;
      bdho.g = System.currentTimeMillis();
    } while (!QLog.isColorLevel());
    QLog.d("Perf", 2, "delay checkTroopTimeStamp");
  }
  
  private void i()
  {
    SearchConfigManager.a(this.a.app);
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts", 2, "troopMemberUpdateConfigStr=" + SearchConfigManager.troopMemberUpdateConfigStr);
    }
  }
  
  private void j()
  {
    pra localpra = pfa.a().a();
    if (localpra != null) {
      localpra.a(this.a.app.c());
    }
  }
  
  private void k()
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler_PushOpenNotify", 2, "doafterlogin");
      }
      new aovm(this.a.app).execute(new Void[0]);
    }
  }
  
  private void l()
  {
    apdc localapdc = (apdc)this.a.app.getManager(199);
    if ((localapdc != null) && (localapdc.a()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQInitHandler", 4, " QQ 18 handle actionB cached stranger head update in AfterSyncMsg doAfterLogin");
      }
      localapdc.b();
    }
  }
  
  private void m()
  {
    aold localaold = (aold)this.a.app.getManager(85);
    if (localaold != null) {
      localaold.a();
    }
  }
  
  private void n()
  {
    ThreadManager.getSubThreadHandler().post(new AfterSyncMsg.3(this));
  }
  
  private void o()
  {
    nws localnws = (nws)this.a.app.getManager(238);
    if (localnws != null)
    {
      if (!"5.0.2".equals(Build.VERSION.RELEASE)) {
        localnws.a();
      }
      localnws.a(this.a.app.c());
    }
    avya localavya = (avya)this.a.app.getManager(268);
    if (localnws != null) {
      localavya.a(this.a.app, this.a.app.c());
    }
  }
  
  private void p()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, new Object[] { "AfterSyncMsg sendEmptyMessageDelayedToHandler MSG_INIT_MSGTAG_STORY process, send, ", Boolean.valueOf(this.a.b()) });
    }
    MqqHandler localMqqHandler = this.a.app.getHandler(Conversation.class);
    localMqqHandler.sendEmptyMessage(1055);
    localMqqHandler.sendEmptyMessage(1059);
    localMqqHandler.sendEmptyMessage(1061);
  }
  
  private void q()
  {
    Object localObject = this.a.app.getApplication().getApplicationContext().getSharedPreferences(this.a.app.getAccount(), 0);
    long l = ((SharedPreferences)localObject).getLong("sp_vip_info_request_time", 0L);
    int i = ((SharedPreferences)localObject).getInt("sp_vip_info_update_freq", 10);
    if (NetConnInfoCenter.getServerTime() - l > i * 60)
    {
      localObject = this.a.app.getCurrentAccountUin();
      String str = ((TicketManager)this.a.app.getManager(2)).getSkey((String)localObject);
      ((aokv)this.a.app.a(27)).a(str, (String)localObject);
    }
  }
  
  private void r()
  {
    ThreadManager.executeOnSubThread(new AfterSyncMsg.4(this));
  }
  
  private void s()
  {
    alni.a().a(this.a.app, BaseApplicationImpl.sApplication, true, false);
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "doAfterLogin call MayknowRecommendManager.getMayKnowRecommendRemote ");
    }
    ((aobl)this.a.app.getManager(159)).a(1);
  }
  
  private void t()
  {
    ThreadManager.executeOnSubThread(new AfterSyncMsg.5(this));
  }
  
  private void u()
  {
    List localList = ((ProxyManager)this.a.app.getManager(18)).a().getRecentList(true);
    int i = 0;
    while (i < localList.size())
    {
      if (((RecentUser)localList.get(i)).lFlag == 16L)
      {
        Iterator localIterator = this.a.app.a().b(((RecentUser)localList.get(i)).uin, ((RecentUser)localList.get(i)).getType()).iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (MessageRecord)localIterator.next();
          localObject = nwy.a(this.a.app, (MessageRecord)localObject, true);
          if (localObject != null) {
            nwo.a().a((nwf)localObject);
          }
        }
      }
      i += 1;
    }
  }
  
  private void v()
  {
    Object localObject = (ArkAppCenter)this.a.app.getManager(121);
    if (localObject != null)
    {
      localObject = ((ArkAppCenter)localObject).a();
      if (localObject != null) {
        ((aqcf)localObject).b();
      }
    }
  }
  
  private void w()
  {
    ((bgiw)this.a.app.getManager(363)).a();
    MqqHandler localMqqHandler = this.a.app.getHandler(Conversation.class);
    if (localMqqHandler != null) {
      localMqqHandler.obtainMessage(1134064).sendToTarget();
    }
  }
  
  private void x()
  {
    if (bcun.a(1, BaseApplicationImpl.processName)) {}
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
  
  private void y()
  {
    if (bjjh.a(this.a.app.getApp()) != 2) {
      MiniAppController.preloadMiniProcess();
    }
  }
  
  private void z()
  {
    if (this.a.jdField_a_of_type_Boolean) {
      ((aoip)this.a.app.a(20)).b();
    }
  }
  
  public int a()
  {
    switch (this.b)
    {
    default: 
      this.a.app.a().a(false);
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
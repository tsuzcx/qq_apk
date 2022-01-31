package com.tencent.mobileqq.app.automator.step;

import MQQ.PayRuleCfg;
import aars;
import abos;
import abqw;
import aekh;
import agcq;
import agug;
import agyc;
import aipw;
import aiqr;
import aitd;
import aizt;
import ajeu;
import aljq;
import alkv;
import allq;
import almt;
import alne;
import aloz;
import alro;
import altc;
import alud;
import aluw;
import alxk;
import alxl;
import alzf;
import ambd;
import ambl;
import amce;
import amcs;
import amfn;
import amio;
import amjf;
import amjk;
import amjr;
import ammg;
import ampn;
import amsx;
import anby;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.view.accessibility.AccessibilityManager;
import anka;
import anyd;
import aobd;
import aova;
import astw;
import atpw;
import atvy;
import aubr;
import awbw;
import awbx;
import awjh;
import aywn;
import azjg;
import azlg;
import azll;
import azlr;
import azmj;
import azpa;
import azwu;
import badu;
import bavk;
import bavv;
import bbib;
import bclk;
import bdag;
import bdcs;
import bdee;
import bdli;
import bdux;
import bevd;
import bewy;
import bfhd;
import bhpd;
import bizm;
import bkbm;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.NotificationReportUtil;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mfsdk.reporter.ReporterMachine;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MemoryManager;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.data.FeedsManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.mini.sdk.MiniAppController;
import com.tencent.mobileqq.mini.share.MiniArkShareAsyncManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.search.util.SearchConfigManager;
import com.tencent.mobileqq.shortvideo.ShortVideoResourceManager;
import com.tencent.mobileqq.startup.step.RecordTracer;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import com.tencent.mobileqq.utils.quic.QuicResDownload;
import com.tencent.mqp.app.bps.d;
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
import nhz;
import nlo;
import nlx;
import nmb;
import nmh;
import nru;
import ohf;
import owy;
import oxf;
import oxp;
import phg;
import sgi;
import swi;
import swy;
import uhk;

public class AfterSyncMsg
  extends AsyncStep
{
  private void b()
  {
    if (this.a.jdField_a_of_type_Boolean) {
      ((alzf)this.a.app.a(20)).b();
    }
    ((FriendListHandler)this.a.app.a(1)).c();
    f();
    Object localObject1 = (awjh)this.a.app.getManager(179);
    if (localObject1 != null)
    {
      if (((awjh)localObject1).a()) {
        aova.f(this.a.app, this.a.app.getCurrentAccountUin());
      }
    }
    else
    {
      localObject1 = (amsx)this.a.app.getManager(168);
      if (localObject1 != null) {
        ((amsx)localObject1).a(true, false);
      }
      ampn.a(this.a.app);
      anby.a(BaseApplicationImpl.getContext(), this.a.app);
      ((PhoneContactManagerImp)this.a.app.getManager(11)).a(true, true, 3);
      this.a.app.a().m();
      ((swi)this.a.app.getManager(101)).a();
      localObject1 = (aipw)this.a.app.getManager(125);
      ((aipw)localObject1).b();
      ((aipw)localObject1).a();
      aiqr.a(this.a.app);
      if (QLog.isColorLevel()) {
        QLog.d(".troop.del_abnormal_troop_local_msg", 2, "checkDelAbnormalLocalTroopMsg onReconnect");
      }
      this.a.app.a().q();
      int i = bdee.a(BaseApplicationImpl.getApplication());
      switch (i)
      {
      case 2: 
      default: 
        label300:
        if (i == 1) {
          ((PhotoPlusManager)this.a.app.getManager(169)).a(false);
        }
        aars.a(this.a.app, this.a.app.getCurrentAccountUin(), -1, "doOnReconnect");
        QWalletHelper.getPayCode(this.a.app);
        if (Math.abs(System.currentTimeMillis() - ShortVideoResourceManager.a) > 3600000L) {
          ShortVideoResourceManager.a(this.a.app, 2);
        }
        break;
      }
    }
    for (;;)
    {
      localObject1 = (alkv)this.a.app.a(2);
      Object localObject2 = (ammg)this.a.app.getManager(199);
      if ((localObject1 != null) && (localObject2 != null) && (((ammg)localObject2).a())) {
        ((alkv)localObject1).e();
      }
      localObject2 = (aitd)this.a.app.getManager(245);
      if (localObject2 != null) {
        ((aitd)localObject2).a(2);
      }
      QQAppInterface.I();
      if (localObject1 != null)
      {
        ((alkv)localObject1).v();
        ((alkv)localObject1).u();
        ((alkv)localObject1).s();
        ((alkv)localObject1).t();
        ((alkv)localObject1).E();
      }
      agug.a(this.a.app).c();
      oxf.a();
      ThreadManager.executeOnSubThread(new AfterSyncMsg.1(this));
      azwu.a();
      return;
      ((awjh)localObject1).a();
      break;
      ((agyc)this.a.app.getManager(138)).g();
      break label300;
      QLog.d("ShortVideoResourceManager", 1, "[network]not need get config...");
    }
  }
  
  private void c()
  {
    if (azjg.f) {}
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
  
  private void e()
  {
    bdux.a().b(BaseApplicationImpl.sApplication);
    bdux.a().a(this.a.app);
    ThreadManager.getSubThreadHandler().post(new AfterSyncMsg.2(this));
    UnifiedMonitor.a(alxk.jdField_a_of_type_Boolean);
    abqw.a();
    this.a.app.a().a().c();
    this.a.app.a().a();
    this.a.app.a().b();
    this.a.app.J();
    this.a.app.a().a(0, false);
    ((uhk)this.a.app.a(98)).a();
    ((uhk)this.a.app.a(98)).b();
    ((FlashChatManager)this.a.app.getManager(217)).a();
    ((uhk)this.a.app.a(98)).c();
    Object localObject1 = this.a.app.getApplication().getApplicationContext().getSharedPreferences(this.a.app.getAccount(), 0);
    long l1 = ((SharedPreferences)localObject1).getLong("sp_vip_info_request_time", 0L);
    int i = ((SharedPreferences)localObject1).getInt("sp_vip_info_update_freq", 10);
    if (NetConnInfoCenter.getServerTime() - l1 > i * 60)
    {
      localObject1 = this.a.app.getCurrentAccountUin();
      localObject2 = ((TicketManager)this.a.app.getManager(2)).getSkey((String)localObject1);
      ((ambd)this.a.app.a(27)).a((String)localObject2, (String)localObject1);
    }
    localObject1 = ambd.a(this.a.app.c());
    if (ambd.a(this.a.app, (PayRuleCfg)localObject1, true)) {
      ThreadManagerV2.getUIHandlerV2().post(new AfterSyncMsg.3(this));
    }
    c();
    ((alxl)this.a.app.a(13)).a();
    this.a.app.m = true;
    this.a.app.A();
    this.a.app.a(false);
    if (this.a.jdField_a_of_type_Boolean) {
      ((alzf)this.a.app.a(20)).b();
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, new Object[] { "AfterSyncMsg sendEmptyMessageDelayedToHandler MSG_INIT_MSGTAG_STORY process, send, ", Boolean.valueOf(this.a.b()) });
    }
    localObject1 = this.a.app.getHandler(Conversation.class);
    ((MqqHandler)localObject1).sendEmptyMessage(1055);
    ((MqqHandler)localObject1).sendEmptyMessage(1059);
    ((MqqHandler)localObject1).sendEmptyMessage(1061);
    if (bewy.a(this.a.app.getApp()) != 2) {
      MiniAppController.preloadMiniProcess();
    }
    f();
    ((alne)this.a.app.getManager(69)).a();
    ThreadManager.getSubThreadHandler().post(new AfterSyncMsg.4(this));
    ((aluw)this.a.app.getManager(56)).a();
    nru.a().a(this.a.app);
    this.a.app.getManager(237);
    localObject1 = (nmb)this.a.app.getManager(238);
    if (localObject1 != null)
    {
      if (!"5.0.2".equals(Build.VERSION.RELEASE)) {
        ((nmb)localObject1).a();
      }
      ((nmb)localObject1).a(this.a.app.c());
    }
    Object localObject2 = (astw)this.a.app.getManager(268);
    if (localObject1 != null) {
      ((astw)localObject2).a(this.a.app, this.a.app.c());
    }
    localObject1 = (nhz)this.a.app.getManager(173);
    localObject1 = (PhoneContactManagerImp)this.a.app.getManager(11);
    ((PhoneContactManagerImp)localObject1).c();
    aova.b(this.a.app, this.a.app.getCurrentAccountUin());
    ((PhoneContactManagerImp)localObject1).a(true, true, 2);
    localObject1 = (ambl)this.a.app.getManager(85);
    if (localObject1 != null) {
      ((ambl)localObject1).a();
    }
    c();
    swy.a(this.a.app);
    swy.a(this.a.app, swy.a(this.a.app));
    this.a.app.a().o();
    this.a.app.a().m();
    bdli.b();
    ((swi)this.a.app.getManager(101)).a();
    localObject1 = (alud)this.a.app.getManager(102);
    ((alud)localObject1).b();
    ((alud)localObject1).c();
    localObject2 = (aipw)this.a.app.getManager(125);
    ((aipw)localObject2).a(false);
    ((aipw)localObject2).d();
    ((aipw)localObject2).b();
    ((aipw)localObject2).a();
    ((bclk)this.a.app.getManager(81)).a(this.a.app);
    if (QLog.isColorLevel()) {
      QLog.d(".troop.del_abnormal_troop_local_msg", 2, "checkDelAbnormalLocalTroopMsg afterLogin");
    }
    this.a.app.a().q();
    this.a.app.H();
    SearchConfigManager.a(this.a.app);
    aekh.a(this.a.app);
    azlr.a();
    azlr.b();
    azlr.e();
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts", 2, "troopMemberUpdateConfigStr=" + SearchConfigManager.troopMemberUpdateConfigStr);
    }
    if (!azjg.c)
    {
      ((amjr)this.a.app.a().a(2)).f();
      amfn.a().b();
      MemoryManager.a().b();
      azll.a().a();
      azlg.a();
      aiqr.a(this.a.app);
      QWalletHelper.getPayCode(this.a.app);
      localObject2 = (ammg)this.a.app.getManager(199);
      if ((localObject2 != null) && (((ammg)localObject2).a()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQInitHandler", 4, " QQ 18 handle actionB cached stranger head update in AfterSyncMsg doAfterLogin");
        }
        ((ammg)localObject2).b();
      }
      if (Build.VERSION.SDK_INT >= 19)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQInitHandler_PushOpenNotify", 2, "doafterlogin");
        }
        new amio(this.a.app).execute(new Void[0]);
      }
      c();
      ((aloz)this.a.app.getManager(51)).a(true);
      ((altc)this.a.app.getManager(34)).i();
      ((KandianMergeManager)this.a.app.getManager(162)).k();
      ((allq)this.a.app.a(4)).e();
      localObject2 = owy.a().a();
      if (localObject2 != null) {
        ((phg)localObject2).a(this.a.app.c());
      }
      localObject2 = ((ProxyManager)this.a.app.getManager(18)).a().a(true);
      i = 0;
    }
    for (;;)
    {
      if (i >= ((List)localObject2).size()) {
        break label1550;
      }
      if (((RecentUser)((List)localObject2).get(i)).lFlag == 16L)
      {
        Iterator localIterator = this.a.app.a().b(((RecentUser)((List)localObject2).get(i)).uin, ((RecentUser)((List)localObject2).get(i)).getType()).iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            Object localObject3 = (MessageRecord)localIterator.next();
            localObject3 = nmh.a(this.a.app, (MessageRecord)localObject3, true);
            if (localObject3 != null)
            {
              nlx.a().a((nlo)localObject3);
              continue;
              azjg.g = System.currentTimeMillis();
              if (!QLog.isColorLevel()) {
                break;
              }
              QLog.d("Perf", 2, "delay checkTroopTimeStamp");
              break;
            }
          }
        }
      }
      i += 1;
    }
    label1550:
    this.a.app.a().e();
    this.a.app.getManager(358);
    ((FlashChatManager)this.a.app.getManager(217)).c();
    DeviceProfileManager.a(new amcs());
    bbib.a(this.a.app).a();
    bhpd.a(this.a.app).b();
    localObject2 = (aitd)this.a.app.getManager(245);
    if (localObject2 != null) {
      ((aitd)localObject2).a(1);
    }
    aizt.a();
    ((bavv)this.a.app.getManager(233)).a();
    QuicResDownload.a(this.a.app);
    ((atvy)this.a.app.getManager(242)).a();
    localObject2 = (alkv)this.a.app.a(2);
    ((alkv)localObject2).y();
    ohf.a();
    sgi.a(false);
    ThreadManager.executeOnSubThread(new AfterSyncMsg.5(this));
    SosoInterface.b();
    bevd.a(this.a.app);
    new Handler(ThreadManager.getFileThreadLooper()).postDelayed(new d(), 210000L);
    QQAppInterface.I();
    ajeu.a().a(this.a.app, BaseApplicationImpl.sApplication, true, false);
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "doAfterLogin call MayknowRecommendManager.getMayKnowRecommendRemote ");
    }
    ((alro)this.a.app.getManager(159)).a(1);
    agcq.a(((alud)localObject1).a).a();
    if (localObject2 != null)
    {
      ((alkv)localObject2).v();
      ((alkv)localObject2).u();
      ((alkv)localObject2).s();
      ((alkv)localObject2).t();
      ((alkv)localObject2).E();
    }
    localObject1 = (ArkAppCenter)this.a.app.getManager(121);
    if (localObject1 != null)
    {
      localObject1 = ((ArkAppCenter)localObject1).a();
      if (localObject1 != null) {
        ((anka)localObject1).b();
      }
    }
    agug.a(this.a.app).c();
    agug.a(this.a.app).e();
    MiniArkShareAsyncManager.registerMiniArkShareMessageProcessorAfterProcessRestart();
    NotificationReportUtil.reportAll();
    c();
    atpw.c();
    ((aubr)this.a.app.getManager(37)).a();
    localObject1 = this.a.app.getHandler(Conversation.class);
    if (localObject1 != null) {
      ((MqqHandler)localObject1).obtainMessage(1134064).sendToTarget();
    }
    if (aywn.a(1, BaseApplicationImpl.processName)) {}
    try
    {
      l1 = System.currentTimeMillis();
      localObject1 = BaseActivity.sTopActivity;
      RecordManager.getInstance().setRecentActivityName((Activity)localObject1);
      RecordTracer.a().step();
      long l2 = System.currentTimeMillis();
      QLog.d("RecordTracer", 2, "conversation time " + (l2 - l1));
      badu.a(this.a.app).a();
      ThreadManager.executeOnSubThread(new AfterSyncMsg.6(this));
      ThreadManager.getFileThreadHandler().post(new AfterSyncMsg.7(this));
      h();
      aobd.b(true);
      this.a.app.K();
      ((anyd)this.a.app.a(168)).a();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RecordTracer", 2, "EventCon setUserId failed:" + localException.getMessage());
        }
      }
    }
  }
  
  private void f()
  {
    Object localObject = (FriendListHandler)this.a.app.a(1);
    this.a.app.a().i();
    this.a.app.a().j();
    g();
    ((almt)this.a.app.a(6)).b();
    ((aloz)this.a.app.getManager(51)).b();
    ((FriendListHandler)localObject).e();
    ((FriendListHandler)localObject).b();
    localObject = this.a.app.a();
    boolean bool1;
    boolean bool2;
    if (!this.a.b)
    {
      bool1 = true;
      if (this.a.c) {
        break label382;
      }
      bool2 = true;
      label128:
      ((MessageHandler)localObject).a(bool1, bool2);
      this.a.app.a().m();
      this.a.app.a().m();
      if (!bizm.o()) {
        break label387;
      }
      QLog.i("QQInitHandler", 2, "updateQzoneFeeds 下发配置隐藏新动态");
    }
    for (;;)
    {
      oxp.d(this.b);
      ((PhoneContactManagerImp)this.a.app.getManager(11)).a(false);
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
            azmj.b(this.a.app, "dc00898", "", "", "0X800A4C7", "0X800A4C7", 0, 0, "", "0", "", "");
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
      azpa.a(BaseApplicationImpl.getApplication());
      return;
      bool1 = false;
      break;
      label382:
      bool2 = false;
      break label128;
      label387:
      ((FeedsManager)this.a.app.getManager(275)).updateQzoneFeeds();
    }
  }
  
  private void g()
  {
    if (bdag.a())
    {
      bdcs.c(aljq.bI + ".nomedia");
      bdcs.c(aljq.bJ + ".nomedia");
    }
    if (this.a.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("isConvertOldQQHeadOK", false)) {
      return;
    }
    Hashtable localHashtable = new Hashtable();
    awbw localawbw = this.a.app.getEntityManagerFactory().createEntityManager();
    List localList = localawbw.a(Setting.class, new Setting().getTableName(), false, "bHeadType=? or (bHeadType<>? and bUsrType=?)", new String[] { "0", "0", "4" }, null, null, null, null);
    if ((localList != null) && (localList.size() > 0))
    {
      int i = 0;
      if (i < localList.size())
      {
        Object localObject2 = (Setting)localList.get(i);
        if ((((Setting)localObject2).uin != null) && (((Setting)localObject2).uin.length() > 0))
        {
          if (((Setting)localObject2).bUsrType != 4) {
            break label382;
          }
          if ((((Setting)localObject2).bHeadType != 0) || (((Setting)localObject2).systemHeadID != 0)) {
            break label242;
          }
        }
        for (;;)
        {
          i += 1;
          break;
          label242:
          int j;
          label267:
          label269:
          String str1;
          String str2;
          if (((Setting)localObject2).uin.startsWith("troop_"))
          {
            localObject1 = ((Setting)localObject2).uin.substring(6);
            j = 4;
            str1 = this.a.app.a(j, (String)localObject1);
            str2 = this.a.app.a((Setting)localObject2, j, (String)localObject1, 0);
            if (((Setting)localObject2).bHeadType != 0) {
              break label393;
            }
          }
          label393:
          for (localObject1 = "sys_" + String.valueOf(((Setting)localObject2).systemHeadID);; localObject1 = ((Setting)localObject2).uin)
          {
            localObject2 = new File(str1);
            if (!localHashtable.containsKey(localObject1)) {
              break label402;
            }
            if (!((File)localObject2).exists()) {
              break;
            }
            ((File)localObject2).delete();
            break;
            localObject1 = ((Setting)localObject2).uin;
            break label267;
            label382:
            localObject1 = ((Setting)localObject2).uin;
            j = 1;
            break label269;
          }
          label402:
          if (((File)localObject2).exists())
          {
            bavk.a(str1, str2);
            ((File)localObject2).delete();
            localHashtable.put(localObject1, Boolean.valueOf(true));
          }
        }
      }
    }
    localawbw.a();
    Object localObject1 = new File(aljq.bI + "_thd/");
    if (((File)localObject1).exists()) {
      bfhd.a((File)localObject1);
    }
    localObject1 = new File("/data/data/com.tencent.mobileqq/files/head/_thd/");
    if (((File)localObject1).exists()) {
      bfhd.a((File)localObject1);
    }
    this.a.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("isConvertOldQQHeadOK", true).commit();
  }
  
  private void h()
  {
    if ((this.a != null) && (this.a.app != null))
    {
      new bkbm().a(Long.parseLong(this.a.app.getCurrentAccountUin()));
      return;
    }
    QLog.i("QQInitHandler", 1, "ChkeckLoveStateRequest diden`t send");
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
      e();
      ReporterMachine.a().a();
      UnifiedMonitor.a().c();
      continue;
      b();
      continue;
      f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.AfterSyncMsg
 * JD-Core Version:    0.7.0.1
 */
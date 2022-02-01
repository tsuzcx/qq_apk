package com.tencent.mobileqq.app.automator.step;

import MQQ.PayRuleCfg;
import acux;
import acvg;
import acwg;
import adcd;
import afuf;
import ahrk;
import aijp;
import aipe;
import aiyr;
import ajby;
import aklj;
import akme;
import akpd;
import akwd;
import albs;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.view.accessibility.AccessibilityManager;
import anhk;
import anip;
import anjo;
import anks;
import anlf;
import anmw;
import anpk;
import anrs;
import anuk;
import anwd;
import anyj;
import anyr;
import anyv;
import anzf;
import aohy;
import aone;
import aong;
import aonn;
import aopm;
import aost;
import aowd;
import apex;
import apop;
import aqct;
import aqfv;
import arcj;
import avfx;
import awbj;
import awhq;
import azcg;
import bcbv;
import bcow;
import bcrq;
import bcrv;
import bcsb;
import bcst;
import bcuq;
import bdch;
import bdjh;
import beap;
import beba;
import bemy;
import bfiv;
import bfuk;
import bgjq;
import bgmg;
import bgnt;
import bguq;
import bhgh;
import bigl;
import bihl;
import biii;
import bisv;
import bkgt;
import blsb;
import bmuh;
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
import nqq;
import nuk;
import nuu;
import nuy;
import nve;
import oau;
import otw;
import pmh;
import pmo;
import pmy;
import pyq;
import tez;
import txq;
import tyg;
import wff;

public class AfterSyncMsg
  extends AsyncStep
{
  private void a()
  {
    if (this.a.jdField_a_of_type_Boolean) {
      ((anwd)this.a.app.a(20)).b();
    }
    ((FriendListHandler)this.a.app.a(1)).d();
    b(23);
    Object localObject1 = (azcg)this.a.app.getManager(179);
    if (localObject1 != null)
    {
      if (((azcg)localObject1).a()) {
        arcj.f(this.a.app, this.a.app.getCurrentAccountUin());
      }
    }
    else
    {
      localObject1 = (aowd)this.a.app.getManager(168);
      if (localObject1 != null) {
        ((aowd)localObject1).a(true, false);
      }
      aost.a(this.a.app);
      apex.a(BaseApplicationImpl.getContext(), this.a.app);
      this.a.app.a().m();
      ((txq)this.a.app.getManager(101)).a();
      localObject1 = (aklj)this.a.app.getManager(125);
      ((aklj)localObject1).b();
      ((aklj)localObject1).a();
      akme.a(this.a.app);
      if (QLog.isColorLevel()) {
        QLog.d(".troop.del_abnormal_troop_local_msg", 2, "checkDelAbnormalLocalTroopMsg onReconnect");
      }
      this.a.app.a().q();
      int i = bgnt.a(BaseApplicationImpl.getApplication());
      switch (i)
      {
      case 2: 
      default: 
        label280:
        if (i == 1) {
          ((PhotoPlusManager)this.a.app.getManager(169)).a(false);
        }
        acvg.a(this.a.app, this.a.app.getCurrentAccountUin(), -1, "doOnReconnect");
        QWalletHelper.getPayCode(this.a.app);
        if (Math.abs(System.currentTimeMillis() - ShortVideoResourceManager.a) > 3600000L) {
          ShortVideoResourceManager.a(this.a.app, 2);
        }
        break;
      }
    }
    for (;;)
    {
      localObject1 = (anip)this.a.app.a(2);
      Object localObject2 = (aopm)this.a.app.getManager(199);
      if ((localObject1 != null) && (localObject2 != null) && (((aopm)localObject2).a())) {
        ((anip)localObject1).e();
      }
      localObject2 = (akpd)this.a.app.getManager(245);
      if (localObject2 != null) {
        ((akpd)localObject2).a(2);
      }
      QQAppInterface.J();
      if (localObject1 != null)
      {
        ((anip)localObject1).t();
        ((anip)localObject1).s();
        ((anip)localObject1).q();
        ((anip)localObject1).r();
        ((anip)localObject1).C();
      }
      aijp.a(this.a.app).c();
      pmo.a();
      ThreadManager.executeOnSubThread(new AfterSyncMsg.1(this));
      bdch.a();
      return;
      ((azcg)localObject1).a();
      break;
      ((aipe)this.a.app.getManager(138)).g();
      break label280;
      QLog.d("ShortVideoResourceManager", 1, "[network]not need get config...");
    }
  }
  
  private void b()
  {
    if (bcow.f) {}
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
  
  private void b(int paramInt)
  {
    Object localObject = (FriendListHandler)this.a.app.a(1);
    this.a.app.a().i();
    this.a.app.a().j();
    f();
    ((anks)this.a.app.a(6)).b();
    ((anmw)this.a.app.getManager(51)).c();
    ((FriendListHandler)localObject).f();
    ((FriendListHandler)localObject).c();
    localObject = this.a.app.a();
    boolean bool2;
    if (!this.a.b)
    {
      bool1 = true;
      if (this.a.c) {
        break label395;
      }
      bool2 = true;
      label128:
      ((MessageHandler)localObject).a(bool1, bool2);
      this.a.app.a().m();
      this.a.app.a().m();
      if (!blsb.p()) {
        break label400;
      }
      QLog.i("QQInitHandler", 2, "updateQzoneFeeds 下发配置隐藏新动态");
      label177:
      pmy.d(this.b);
      localObject = (PhoneContactManagerImp)this.a.app.getManager(11);
      if (paramInt != 22) {
        break label422;
      }
    }
    label395:
    label400:
    label422:
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
            bcst.b(this.a.app, "dc00898", "", "", "0X800A4C7", "0X800A4C7", 0, 0, "", "0", "", "");
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
      bcuq.a(BaseApplicationImpl.getApplication());
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label128;
      ((FeedsManager)this.a.app.getManager(275)).updateQzoneFeeds();
      break label177;
    }
  }
  
  private void e()
  {
    bhgh.a().b(BaseApplicationImpl.sApplication);
    bhgh.a().a(this.a.app);
    ThreadManager.getSubThreadHandler().post(new AfterSyncMsg.2(this));
    UnifiedMonitor.a(SQLiteOpenHelper.WAL_ENABLE);
    adcd.a();
    this.a.app.a().a().c();
    this.a.app.a().a();
    this.a.app.a().initLazy();
    this.a.app.K();
    this.a.app.a().a(0, false);
    ((wff)this.a.app.a(98)).a();
    ((wff)this.a.app.a(98)).b();
    ((FlashChatManager)this.a.app.getManager(217)).a();
    ((wff)this.a.app.a(98)).c();
    Object localObject1 = this.a.app.getApplication().getApplicationContext().getSharedPreferences(this.a.app.getAccount(), 0);
    long l1 = ((SharedPreferences)localObject1).getLong("sp_vip_info_request_time", 0L);
    int i = ((SharedPreferences)localObject1).getInt("sp_vip_info_update_freq", 10);
    if (NetConnInfoCenter.getServerTime() - l1 > i * 60)
    {
      localObject1 = this.a.app.getCurrentAccountUin();
      localObject2 = ((TicketManager)this.a.app.getManager(2)).getSkey((String)localObject1);
      ((anyj)this.a.app.a(27)).a((String)localObject2, (String)localObject1);
    }
    localObject1 = anyj.a(this.a.app.c());
    if (anyj.a(this.a.app, (PayRuleCfg)localObject1, true)) {
      ThreadManagerV2.getUIHandlerV2().post(new AfterSyncMsg.3(this));
    }
    b();
    ((anuk)this.a.app.a(13)).a();
    this.a.app.m = true;
    this.a.app.B();
    this.a.app.a(false);
    if (this.a.jdField_a_of_type_Boolean) {
      ((anwd)this.a.app.a(20)).b();
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, new Object[] { "AfterSyncMsg sendEmptyMessageDelayedToHandler MSG_INIT_MSGTAG_STORY process, send, ", Boolean.valueOf(this.a.b()) });
    }
    localObject1 = this.a.app.getHandler(Conversation.class);
    ((MqqHandler)localObject1).sendEmptyMessage(1055);
    ((MqqHandler)localObject1).sendEmptyMessage(1059);
    ((MqqHandler)localObject1).sendEmptyMessage(1061);
    if (biii.a(this.a.app.getApp()) != 2) {
      MiniAppController.preloadMiniProcess();
    }
    b(22);
    ((anlf)this.a.app.getManager(69)).a();
    ThreadManager.getSubThreadHandler().post(new AfterSyncMsg.4(this));
    ((anrs)this.a.app.getManager(56)).a();
    oau.a().a(this.a.app);
    this.a.app.getManager(237);
    localObject1 = (nuy)this.a.app.getManager(238);
    if (localObject1 != null)
    {
      if (!"5.0.2".equals(Build.VERSION.RELEASE)) {
        ((nuy)localObject1).a();
      }
      ((nuy)localObject1).a(this.a.app.c());
    }
    Object localObject2 = (avfx)this.a.app.getManager(268);
    if (localObject1 != null) {
      ((avfx)localObject2).a(this.a.app, this.a.app.c());
    }
    localObject1 = (nqq)this.a.app.getManager(173);
    localObject1 = (anyr)this.a.app.getManager(85);
    if (localObject1 != null) {
      ((anyr)localObject1).a();
    }
    b();
    tyg.a(this.a.app);
    tyg.a(this.a.app, tyg.a(this.a.app));
    this.a.app.a().o();
    this.a.app.a().m();
    bguq.b();
    ((txq)this.a.app.getManager(101)).a();
    localObject1 = (ajby)this.a.app.getManager(102);
    ((ajby)localObject1).b();
    ((ajby)localObject1).c();
    localObject2 = (aklj)this.a.app.getManager(125);
    ((aklj)localObject2).a(false);
    ((aklj)localObject2).d();
    ((aklj)localObject2).b();
    ((aklj)localObject2).a();
    ((bfuk)this.a.app.getManager(81)).a(this.a.app);
    if (QLog.isColorLevel()) {
      QLog.d(".troop.del_abnormal_troop_local_msg", 2, "checkDelAbnormalLocalTroopMsg afterLogin");
    }
    this.a.app.a().q();
    this.a.app.I();
    SearchConfigManager.a(this.a.app);
    afuf.a(this.a.app);
    bcsb.a();
    bcsb.b();
    bcsb.e();
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts", 2, "troopMemberUpdateConfigStr=" + SearchConfigManager.troopMemberUpdateConfigStr);
    }
    if (!bcow.c)
    {
      ((aonn)this.a.app.a().a(2)).f();
      bcrv.a().a();
      bcrq.a();
      akme.a(this.a.app);
      QWalletHelper.getPayCode(this.a.app);
      localObject2 = (aopm)this.a.app.getManager(199);
      if ((localObject2 != null) && (((aopm)localObject2).a()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQInitHandler", 4, " QQ 18 handle actionB cached stranger head update in AfterSyncMsg doAfterLogin");
        }
        ((aopm)localObject2).b();
      }
      if (Build.VERSION.SDK_INT >= 19)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQInitHandler_PushOpenNotify", 2, "doafterlogin");
        }
        new aohy(this.a.app).execute(new Void[0]);
      }
      b();
      ((anmw)this.a.app.getManager(51)).a(true);
      ((aiyr)this.a.app.getManager(34)).i();
      ((KandianMergeManager)this.a.app.getManager(162)).a();
      ((anjo)this.a.app.a(4)).f();
      localObject2 = pmh.a().a();
      if (localObject2 != null) {
        ((pyq)localObject2).a(this.a.app.c());
      }
      localObject2 = ((ProxyManager)this.a.app.getManager(18)).a().getRecentList(true);
      i = 0;
    }
    for (;;)
    {
      if (i >= ((List)localObject2).size()) {
        break label1490;
      }
      if (((RecentUser)((List)localObject2).get(i)).lFlag == 16L)
      {
        Iterator localIterator = this.a.app.a().b(((RecentUser)((List)localObject2).get(i)).uin, ((RecentUser)((List)localObject2).get(i)).getType()).iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            Object localObject3 = (MessageRecord)localIterator.next();
            localObject3 = nve.a(this.a.app, (MessageRecord)localObject3, true);
            if (localObject3 != null)
            {
              nuu.a().a((nuk)localObject3);
              continue;
              bcow.g = System.currentTimeMillis();
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
    label1490:
    this.a.app.a().a();
    this.a.app.getManager(358);
    ((FlashChatManager)this.a.app.getManager(217)).c();
    DeviceProfileManager.a(new anzf());
    bemy.a(this.a.app).a();
    bkgt.a(this.a.app).b();
    localObject2 = (akpd)this.a.app.getManager(245);
    if (localObject2 != null) {
      ((akpd)localObject2).a(1);
    }
    akwd.a();
    ((beba)this.a.app.getManager(233)).a();
    QuicResDownload.a(this.a.app);
    ((awhq)this.a.app.getManager(242)).a();
    localObject2 = (anip)this.a.app.a(2);
    ((anip)localObject2).w();
    otw.a();
    tez.a(false);
    ThreadManager.executeOnSubThread(new AfterSyncMsg.5(this));
    SosoInterface.b();
    bigl.a(this.a.app);
    bihl.a();
    QQAppInterface.J();
    albs.a().a(this.a.app, BaseApplicationImpl.sApplication, true, false);
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "doAfterLogin call MayknowRecommendManager.getMayKnowRecommendRemote ");
    }
    ((anpk)this.a.app.getManager(159)).a(1);
    ahrk.a(((ajby)localObject1).a).a();
    if (localObject2 != null)
    {
      ((anip)localObject2).t();
      ((anip)localObject2).s();
      ((anip)localObject2).q();
      ((anip)localObject2).r();
      ((anip)localObject2).C();
    }
    localObject1 = (ArkAppCenter)this.a.app.getManager(121);
    if (localObject1 != null)
    {
      localObject1 = ((ArkAppCenter)localObject1).a();
      if (localObject1 != null) {
        ((apop)localObject1).b();
      }
    }
    aijp.a(this.a.app).c();
    aijp.a(this.a.app).e();
    MiniArkShareAsyncManager.registerMiniArkShareMessageProcessorAfterProcessRestart();
    NotificationReportUtil.reportAll();
    b();
    awbj.c();
    ((bfiv)this.a.app.getManager(363)).a();
    localObject1 = this.a.app.getHandler(Conversation.class);
    if (localObject1 != null) {
      ((MqqHandler)localObject1).obtainMessage(1134064).sendToTarget();
    }
    if (bcbv.a(1, BaseApplicationImpl.processName)) {}
    try
    {
      l1 = System.currentTimeMillis();
      localObject1 = BaseActivity.sTopActivity;
      RecordManager.getInstance().setRecentActivityName((Activity)localObject1);
      RecordTracer.a().step();
      long l2 = System.currentTimeMillis();
      QLog.d("RecordTracer", 2, "conversation time " + (l2 - l1));
      bdjh.a(this.a.app).a();
      ThreadManager.executeOnSubThread(new AfterSyncMsg.6(this));
      ThreadManager.getFileThreadHandler().post(new AfterSyncMsg.7(this));
      g();
      aqfv.b(true);
      this.a.app.L();
      ((aqct)this.a.app.a(168)).a();
      acux.a(this.a.app);
      DtSdkInitStep.a();
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
    if (bgjq.a())
    {
      bgmg.c(anhk.bL + ".nomedia");
      bgmg.c(anhk.bM + ".nomedia");
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
            beap.a(str1, str2);
            ((File)localObject2).delete();
            localHashtable.put(localObject1, Boolean.valueOf(true));
          }
        }
      }
    }
    localEntityManager.close();
    Object localObject1 = new File(anhk.bL + "_thd/");
    if (((File)localObject1).exists()) {
      bisv.a((File)localObject1);
    }
    localObject1 = new File("/data/data/com.tencent.mobileqq/files/head/_thd/");
    if (((File)localObject1).exists()) {
      bisv.a((File)localObject1);
    }
    this.a.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("isConvertOldQQHeadOK", true).commit();
  }
  
  private void g()
  {
    if ((this.a != null) && (this.a.app != null))
    {
      new bmuh().a(Long.parseLong(this.a.app.getCurrentAccountUin()));
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
      a();
      continue;
      b(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.AfterSyncMsg
 * JD-Core Version:    0.7.0.1
 */
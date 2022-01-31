package com.tencent.mobileqq.app.automator.step;

import MQQ.PayRuleCfg;
import acim;
import advd;
import aemi;
import aeqd;
import agjk;
import agkf;
import agmq;
import agtb;
import agvx;
import ahay;
import ajed;
import ajfi;
import ajgd;
import ajhf;
import ajhq;
import ajjj;
import ajls;
import ajnf;
import ajof;
import ajoy;
import ajrl;
import ajrm;
import ajtg;
import ajve;
import ajvm;
import ajwf;
import ajwt;
import ajzo;
import akbl;
import akdy;
import akep;
import akeu;
import akfb;
import akhf;
import akkm;
import aknw;
import akwx;
import aleu;
import alsm;
import aluq;
import amda;
import amnh;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.view.accessibility.AccessibilityManager;
import aqjb;
import ardg;
import ariu;
import arom;
import atlb;
import atmp;
import atmq;
import attv;
import awbz;
import awoa;
import awpv;
import awpz;
import awqf;
import awqx;
import awtl;
import axft;
import axxc;
import axxn;
import ayja;
import azlf;
import azzu;
import bace;
import badq;
import bakq;
import bbrm;
import bbth;
import bcdp;
import befx;
import bfpr;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.util.notification.NotificationReportUtil;
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
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.data.FeedsManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.flashchat.FlashChatManager;
import com.tencent.mobileqq.mini.entry.MiniAppUserAppInfoListManager;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopDataManager;
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
import muf;
import mxu;
import myd;
import myh;
import myn;
import ndo;
import nsd;
import ogy;
import ohf;
import ohp;
import oqv;
import rdz;
import rrz;
import rsp;
import sfz;
import yte;
import zqk;

public class AfterSyncMsg
  extends AsyncStep
{
  private void b()
  {
    if (this.a.jdField_a_of_type_Boolean) {
      ((ajtg)this.a.app.a(20)).b();
    }
    ((FriendListHandler)this.a.app.a(1)).b();
    f();
    Object localObject1 = (attv)this.a.app.getManager(179);
    if (localObject1 != null)
    {
      if (((attv)localObject1).a()) {
        amnh.f(this.a.app, this.a.app.getCurrentAccountUin());
      }
    }
    else
    {
      localObject1 = (aknw)this.a.app.getManager(168);
      if (localObject1 != null) {
        ((aknw)localObject1).a(true, false);
      }
      akkm.a(this.a.app);
      akwx.a(BaseApplicationImpl.getContext(), this.a.app);
      ((PhoneContactManagerImp)this.a.app.getManager(11)).a(true, true, 3);
      this.a.app.a().m();
      ((rrz)this.a.app.getManager(101)).a();
      localObject1 = (agjk)this.a.app.getManager(125);
      ((agjk)localObject1).b();
      ((agjk)localObject1).a();
      agkf.a(this.a.app);
      if (QLog.isColorLevel()) {
        QLog.d(".troop.del_abnormal_troop_local_msg", 2, "checkDelAbnormalLocalTroopMsg onReconnect");
      }
      this.a.app.a().q();
      int i = badq.a(BaseApplicationImpl.getApplication());
      switch (i)
      {
      case 2: 
      default: 
        label300:
        if (i == 1) {
          ((PhotoPlusManager)this.a.app.getManager(169)).a(false);
        }
        yte.a(this.a.app, this.a.app.getCurrentAccountUin(), -1, "doOnReconnect");
        QWalletHelper.getPayCode(this.a.app);
        if (Math.abs(System.currentTimeMillis() - ShortVideoResourceManager.a) > 3600000L) {
          ShortVideoResourceManager.a(this.a.app, 2);
        }
        break;
      }
    }
    for (;;)
    {
      localObject1 = (ajfi)this.a.app.a(2);
      Object localObject2 = (akhf)this.a.app.getManager(199);
      if ((localObject1 != null) && (localObject2 != null) && (((akhf)localObject2).a())) {
        ((ajfi)localObject1).e();
      }
      localObject2 = (agmq)this.a.app.getManager(245);
      if (localObject2 != null) {
        ((agmq)localObject2).a(2);
      }
      ((agtb)this.a.app.getManager(341)).b(this.a.app, 1);
      QQAppInterface.H();
      if (localObject1 != null)
      {
        ((ajfi)localObject1).u();
        ((ajfi)localObject1).t();
        ((ajfi)localObject1).r();
        ((ajfi)localObject1).s();
      }
      aemi.a(this.a.app).c();
      ohf.a();
      ThreadManager.executeOnSubThread(new AfterSyncMsg.1(this));
      return;
      ((attv)localObject1).a();
      break;
      ((aeqd)this.a.app.getManager(138)).g();
      break label300;
      QLog.d("ShortVideoResourceManager", 1, "[network]not need get config...");
    }
  }
  
  private void c()
  {
    if (awoa.f) {}
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
    ThreadManager.getSubThreadHandler().post(new AfterSyncMsg.2(this));
    UnifiedMonitor.a(ajrl.jdField_a_of_type_Boolean);
    zqk.a();
    this.a.app.a().a().c();
    this.a.app.a().a();
    this.a.app.a().b();
    this.a.app.I();
    this.a.app.a().a(0, false);
    ((sfz)this.a.app.a(98)).a();
    ((sfz)this.a.app.a(98)).b();
    ((FlashChatManager)this.a.app.getManager(217)).a();
    ((sfz)this.a.app.a(98)).c();
    Object localObject1 = this.a.app.getApplication().getApplicationContext().getSharedPreferences(this.a.app.getAccount(), 0);
    long l1 = ((SharedPreferences)localObject1).getLong("sp_vip_info_request_time", 0L);
    int i = ((SharedPreferences)localObject1).getInt("sp_vip_info_update_freq", 10);
    if (NetConnInfoCenter.getServerTime() - l1 > i * 60)
    {
      localObject1 = this.a.app.getCurrentAccountUin();
      localObject2 = ((TicketManager)this.a.app.getManager(2)).getSkey((String)localObject1);
      ((ajve)this.a.app.a(27)).a((String)localObject2, (String)localObject1);
    }
    localObject1 = ajve.a(this.a.app.c());
    if (ajve.a(this.a.app, (PayRuleCfg)localObject1, true)) {
      ThreadManagerV2.getUIHandlerV2().post(new AfterSyncMsg.3(this));
    }
    c();
    ((ajrm)this.a.app.a(13)).a();
    this.a.app.m = true;
    this.a.app.z();
    this.a.app.a(false);
    if (this.a.jdField_a_of_type_Boolean) {
      ((ajtg)this.a.app.a(20)).b();
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, new Object[] { "AfterSyncMsg sendEmptyMessageDelayedToHandler MSG_INIT_MSGTAG_STORY process, send, ", Boolean.valueOf(this.a.b()) });
    }
    localObject1 = this.a.app.getHandler(Conversation.class);
    ((MqqHandler)localObject1).sendEmptyMessage(1055);
    ((MqqHandler)localObject1).sendEmptyMessage(1059);
    ((MqqHandler)localObject1).sendEmptyMessage(1061);
    if (bbth.a(this.a.app.getApp()) != 2) {
      MiniAppController.preloadMiniProcess();
    }
    f();
    ((ajhq)this.a.app.getManager(69)).a();
    ThreadManager.getSubThreadHandler().post(new AfterSyncMsg.4(this));
    ((ajoy)this.a.app.getManager(56)).a();
    ndo.a().a(this.a.app);
    this.a.app.getManager(237);
    localObject1 = (myh)this.a.app.getManager(238);
    if (localObject1 != null)
    {
      if (!"5.0.2".equals(Build.VERSION.RELEASE)) {
        ((myh)localObject1).a();
      }
      ((myh)localObject1).a(this.a.app.c());
    }
    Object localObject2 = (aqjb)this.a.app.getManager(268);
    if (localObject1 != null) {
      ((aqjb)localObject2).a(this.a.app, this.a.app.c());
    }
    localObject1 = (muf)this.a.app.getManager(173);
    localObject1 = (PhoneContactManagerImp)this.a.app.getManager(11);
    ((PhoneContactManagerImp)localObject1).c();
    amnh.b(this.a.app, this.a.app.getCurrentAccountUin());
    ((PhoneContactManagerImp)localObject1).a(true, true, 2);
    localObject1 = (ajvm)this.a.app.getManager(85);
    if (localObject1 != null) {
      ((ajvm)localObject1).a();
    }
    c();
    rsp.a(this.a.app);
    rsp.a(this.a.app, rsp.a(this.a.app));
    this.a.app.a().o();
    this.a.app.a().m();
    bakq.b();
    ((rrz)this.a.app.getManager(101)).a();
    localObject1 = (ajof)this.a.app.getManager(102);
    ((ajof)localObject1).b();
    ((ajof)localObject1).c();
    localObject2 = (agjk)this.a.app.getManager(125);
    ((agjk)localObject2).a(false);
    ((agjk)localObject2).d();
    ((agjk)localObject2).b();
    ((agjk)localObject2).a();
    ((azlf)this.a.app.getManager(81)).a(this.a.app);
    if (QLog.isColorLevel()) {
      QLog.d(".troop.del_abnormal_troop_local_msg", 2, "checkDelAbnormalLocalTroopMsg afterLogin");
    }
    this.a.app.a().q();
    this.a.app.G();
    SearchConfigManager.a(this.a.app);
    acim.a(this.a.app);
    awqf.a();
    awqf.b();
    awqf.e();
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts", 2, "troopMemberUpdateConfigStr=" + SearchConfigManager.troopMemberUpdateConfigStr);
    }
    if (!awoa.c)
    {
      ((akfb)this.a.app.a().a(2)).f();
      ajzo.a().b();
      MemoryManager.a().b();
      awpz.a().a();
      awpv.a();
      agkf.a(this.a.app);
      QWalletHelper.getPayCode(this.a.app);
      localObject2 = (akhf)this.a.app.getManager(199);
      if ((localObject2 != null) && (((akhf)localObject2).a()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQInitHandler", 4, " QQ 18 handle actionB cached stranger head update in AfterSyncMsg doAfterLogin");
        }
        ((akhf)localObject2).b();
      }
      if (Build.VERSION.SDK_INT >= 19)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQInitHandler_PushOpenNotify", 2, "doafterlogin");
        }
        new akdy(this.a.app).execute(new Void[0]);
      }
      c();
      ((ajjj)this.a.app.getManager(51)).a(true);
      ((ajnf)this.a.app.getManager(34)).i();
      ((KandianMergeManager)this.a.app.getManager(162)).k();
      ((ajgd)this.a.app.a(4)).e();
      localObject2 = ogy.a().a();
      if (localObject2 != null) {
        ((oqv)localObject2).a(this.a.app.c());
      }
      localObject2 = ((ProxyManager)this.a.app.getManager(18)).a().a(true);
      i = 0;
    }
    for (;;)
    {
      if (i >= ((List)localObject2).size()) {
        break label1528;
      }
      if (((RecentUser)((List)localObject2).get(i)).lFlag == 16L)
      {
        Iterator localIterator = this.a.app.a().b(((RecentUser)((List)localObject2).get(i)).uin, ((RecentUser)((List)localObject2).get(i)).getType()).iterator();
        for (;;)
        {
          if (localIterator.hasNext())
          {
            Object localObject3 = (MessageRecord)localIterator.next();
            localObject3 = myn.a(this.a.app, (MessageRecord)localObject3, true);
            if (localObject3 != null)
            {
              myd.a().a((mxu)localObject3);
              continue;
              awoa.g = System.currentTimeMillis();
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
    label1528:
    ((FlashChatManager)this.a.app.getManager(217)).c();
    DeviceProfileManager.a(new ajwt());
    ayja.a(this.a.app).a();
    befx.a(this.a.app).b();
    localObject2 = (agmq)this.a.app.getManager(245);
    if (localObject2 != null) {
      ((agmq)localObject2).a(1);
    }
    agvx.a();
    ((axxn)this.a.app.getManager(233)).a();
    QuicResDownload.a(this.a.app);
    ((ariu)this.a.app.getManager(242)).a();
    localObject2 = (ajfi)this.a.app.a(2);
    ((ajfi)localObject2).x();
    nsd.a();
    rdz.a(false);
    ThreadManager.executeOnSubThread(new AfterSyncMsg.5(this));
    SosoInterface.b();
    bbrm.a(this.a.app);
    new Handler(ThreadManager.getFileThreadLooper()).postDelayed(new d(), 210000L);
    QQAppInterface.H();
    ahay.a().a(this.a.app, BaseApplicationImpl.sApplication, true, false);
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "doAfterLogin call MayknowRecommendManager.getMayKnowRecommendRemote ");
    }
    ((ajls)this.a.app.getManager(159)).a(1);
    advd.a(((ajof)localObject1).a).a();
    if (localObject2 != null)
    {
      ((ajfi)localObject2).u();
      ((ajfi)localObject2).t();
      ((ajfi)localObject2).r();
      ((ajfi)localObject2).s();
    }
    localObject1 = (ArkAppCenter)this.a.app.getManager(121);
    if (localObject1 != null)
    {
      localObject1 = ((ArkAppCenter)localObject1).a();
      if (localObject1 != null) {
        ((aleu)localObject1).b();
      }
    }
    aemi.a(this.a.app).c();
    aemi.a(this.a.app).e();
    MiniArkShareAsyncManager.registerMiniArkShareMessageProcessorAfterProcessRestart();
    NotificationReportUtil.reportAll();
    c();
    ardg.c();
    ((arom)this.a.app.getManager(37)).a();
    localObject1 = this.a.app.getHandler(Conversation.class);
    if (localObject1 != null) {
      ((MqqHandler)localObject1).obtainMessage(1134064).sendToTarget();
    }
    if (awbz.a(1, BaseApplicationImpl.processName)) {}
    try
    {
      l1 = System.currentTimeMillis();
      localObject1 = BaseActivity.sTopActivity;
      RecordManager.getInstance().setRecentActivityName((Activity)localObject1);
      RecordTracer.a().step();
      long l2 = System.currentTimeMillis();
      QLog.d("RecordTracer", 2, "conversation time " + (l2 - l1));
      axft.a(this.a.app).a();
      ThreadManager.executeOnSubThread(new AfterSyncMsg.6(this));
      ThreadManager.getFileThreadHandler().post(new AfterSyncMsg.7(this));
      if (amda.g())
      {
        localObject1 = (DesktopDataManager)this.a.app.getManager(336);
        ((DesktopDataManager)localObject1).sendUserAppListRequestV2(null, ((DesktopDataManager)localObject1).getRecommendExposureList());
        ((agtb)this.a.app.getManager(341)).a();
        aluq.b(true);
        atlb.a().a(this.a.app);
        ((alsm)this.a.app.a(168)).a();
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel())
        {
          QLog.d("RecordTracer", 2, "EventCon setUserId failed:" + localException.getMessage());
          continue;
          ((MiniAppUserAppInfoListManager)this.a.app.getManager(309)).sendUserAppListRequest(Long.valueOf(this.a.app.getCurrentAccountUin()).longValue(), 20L);
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
    ((ajhf)this.a.app.a(6)).b();
    ((ajjj)this.a.app.getManager(51)).b();
    ((FriendListHandler)localObject).d();
    ((FriendListHandler)localObject).a();
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
      if (!bfpr.o()) {
        break label387;
      }
      QLog.i("QQInitHandler", 2, "updateQzoneFeeds 下发配置隐藏新动态");
    }
    for (;;)
    {
      ohp.d(this.b);
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
            awqx.b(this.a.app, "dc00898", "", "", "0X800A4C7", "0X800A4C7", 0, 0, "", "0", "", "");
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
      awtl.a(BaseApplicationImpl.getApplication());
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
    if (azzu.a())
    {
      bace.c(ajed.aU + "head/" + ".nomedia");
      bace.c(ajed.bA + ".nomedia");
    }
    if (this.a.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("isConvertOldQQHeadOK", false)) {
      return;
    }
    Hashtable localHashtable = new Hashtable();
    atmp localatmp = this.a.app.getEntityManagerFactory().createEntityManager();
    List localList = localatmp.a(Setting.class, new Setting().getTableName(), false, "bHeadType=? or (bHeadType<>? and bUsrType=?)", new String[] { "0", "0", "4" }, null, null, null, null);
    if ((localList != null) && (localList.size() > 0))
    {
      int i = 0;
      if (i < localList.size())
      {
        Object localObject2 = (Setting)localList.get(i);
        if ((((Setting)localObject2).uin != null) && (((Setting)localObject2).uin.length() > 0))
        {
          if (((Setting)localObject2).bUsrType != 4) {
            break label388;
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
            str1 = this.a.app.a(j, (String)localObject1);
            str2 = this.a.app.a((Setting)localObject2, j, (String)localObject1, 0);
            if (((Setting)localObject2).bHeadType != 0) {
              break label399;
            }
          }
          label388:
          label399:
          for (localObject1 = "sys_" + String.valueOf(((Setting)localObject2).systemHeadID);; localObject1 = ((Setting)localObject2).uin)
          {
            localObject2 = new File(str1);
            if (!localHashtable.containsKey(localObject1)) {
              break label408;
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
          label408:
          if (((File)localObject2).exists())
          {
            axxc.a(str1, str2);
            ((File)localObject2).delete();
            localHashtable.put(localObject1, Boolean.valueOf(true));
          }
        }
      }
    }
    localatmp.a();
    Object localObject1 = new File(ajed.aU + "head/" + "_thd/");
    if (((File)localObject1).exists()) {
      bcdp.a((File)localObject1);
    }
    localObject1 = new File("/data/data/com.tencent.mobileqq/files/head/_thd/");
    if (((File)localObject1).exists()) {
      bcdp.a((File)localObject1);
    }
    this.a.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("isConvertOldQQHeadOK", true).commit();
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
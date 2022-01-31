package com.tencent.mobileqq.app.automator.step;

import MQQ.PayRuleCfg;
import acsx;
import aega;
import aexb;
import afax;
import agvx;
import agws;
import agzd;
import ahfo;
import ahik;
import ahnl;
import ajsd;
import ajti;
import ajud;
import ajvg;
import ajvr;
import ajxl;
import akaa;
import akbn;
import akco;
import akdh;
import akfu;
import akfv;
import akhp;
import akjn;
import akjv;
import akko;
import aklc;
import aknz;
import akpw;
import aksj;
import akta;
import aktf;
import aktm;
import akvq;
import akyx;
import alch;
import alli;
import alth;
import amhc;
import amkf;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Message;
import android.view.accessibility.AccessibilityManager;
import andt;
import ardi;
import arza;
import asey;
import asks;
import aukp;
import aukq;
import aurv;
import axbj;
import axnx;
import axpv;
import axqa;
import axqg;
import axqy;
import axto;
import ayfy;
import ayxl;
import ayxw;
import azjs;
import bamx;
import bbbm;
import bbdx;
import bbfj;
import bbmo;
import bbvk;
import bcwb;
import bcxw;
import bdif;
import bfoi;
import bgyp;
import bhzq;
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
import nfd;
import nis;
import njb;
import njf;
import njl;
import nom;
import odk;
import osg;
import osn;
import osx;
import pbu;
import rqj;
import seo;
import sfe;
import sss;
import zct;
import zzz;

public class AfterSyncMsg
  extends AsyncStep
{
  private void b()
  {
    if (this.a.jdField_a_of_type_Boolean) {
      ((akhp)this.a.app.a(20)).b();
    }
    ((FriendListHandler)this.a.app.a(1)).b();
    f();
    Object localObject1 = (aurv)this.a.app.getManager(179);
    if (localObject1 != null)
    {
      if (((aurv)localObject1).a()) {
        andt.f(this.a.app, this.a.app.getCurrentAccountUin());
      }
    }
    else
    {
      localObject1 = (alch)this.a.app.getManager(168);
      if (localObject1 != null) {
        ((alch)localObject1).a(true, false);
      }
      akyx.a(this.a.app);
      alli.a(BaseApplicationImpl.getContext(), this.a.app);
      ((PhoneContactManagerImp)this.a.app.getManager(11)).a(true, true, 3);
      this.a.app.a().m();
      ((seo)this.a.app.getManager(101)).a();
      localObject1 = (agvx)this.a.app.getManager(125);
      ((agvx)localObject1).b();
      ((agvx)localObject1).a();
      agws.a(this.a.app);
      if (QLog.isColorLevel()) {
        QLog.d(".troop.del_abnormal_troop_local_msg", 2, "checkDelAbnormalLocalTroopMsg onReconnect");
      }
      this.a.app.a().q();
      int i = bbfj.a(BaseApplicationImpl.getApplication());
      switch (i)
      {
      case 2: 
      default: 
        label300:
        if (i == 1) {
          ((PhotoPlusManager)this.a.app.getManager(169)).a(false);
        }
        zct.a(this.a.app, this.a.app.getCurrentAccountUin(), -1, "doOnReconnect");
        QWalletHelper.getPayCode(this.a.app);
        if (Math.abs(System.currentTimeMillis() - ShortVideoResourceManager.a) > 3600000L) {
          ShortVideoResourceManager.a(this.a.app, 2);
        }
        break;
      }
    }
    for (;;)
    {
      localObject1 = (ajti)this.a.app.a(2);
      Object localObject2 = (akvq)this.a.app.getManager(199);
      if ((localObject1 != null) && (localObject2 != null) && (((akvq)localObject2).a())) {
        ((ajti)localObject1).e();
      }
      localObject2 = (agzd)this.a.app.getManager(245);
      if (localObject2 != null) {
        ((agzd)localObject2).a(2);
      }
      ((ahfo)this.a.app.getManager(341)).b(this.a.app, 1);
      QQAppInterface.I();
      if (localObject1 != null)
      {
        ((ajti)localObject1).u();
        ((ajti)localObject1).t();
        ((ajti)localObject1).r();
        ((ajti)localObject1).s();
      }
      aexb.a(this.a.app).c();
      osn.a();
      ThreadManager.executeOnSubThread(new AfterSyncMsg.1(this));
      return;
      ((aurv)localObject1).a();
      break;
      ((afax)this.a.app.getManager(138)).g();
      break label300;
      QLog.d("ShortVideoResourceManager", 1, "[network]not need get config...");
    }
  }
  
  private void c()
  {
    if (axnx.f) {}
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
    bbvk.a().b(BaseApplicationImpl.sApplication);
    bbvk.a().a(this.a.app);
    ThreadManager.getSubThreadHandler().post(new AfterSyncMsg.2(this));
    UnifiedMonitor.a(akfu.jdField_a_of_type_Boolean);
    zzz.a();
    this.a.app.a().a().c();
    this.a.app.a().a();
    this.a.app.a().b();
    this.a.app.J();
    this.a.app.a().a(0, false);
    ((sss)this.a.app.a(98)).a();
    ((sss)this.a.app.a(98)).b();
    ((FlashChatManager)this.a.app.getManager(217)).a();
    ((sss)this.a.app.a(98)).c();
    Object localObject1 = this.a.app.getApplication().getApplicationContext().getSharedPreferences(this.a.app.getAccount(), 0);
    long l1 = ((SharedPreferences)localObject1).getLong("sp_vip_info_request_time", 0L);
    int i = ((SharedPreferences)localObject1).getInt("sp_vip_info_update_freq", 10);
    if (NetConnInfoCenter.getServerTime() - l1 > i * 60)
    {
      localObject1 = this.a.app.getCurrentAccountUin();
      localObject2 = ((TicketManager)this.a.app.getManager(2)).getSkey((String)localObject1);
      ((akjn)this.a.app.a(27)).a((String)localObject2, (String)localObject1);
    }
    localObject1 = akjn.a(this.a.app.c());
    if (akjn.a(this.a.app, (PayRuleCfg)localObject1, true)) {
      ThreadManagerV2.getUIHandlerV2().post(new AfterSyncMsg.3(this));
    }
    c();
    ((akfv)this.a.app.a(13)).a();
    this.a.app.m = true;
    this.a.app.A();
    this.a.app.a(false);
    if (this.a.jdField_a_of_type_Boolean) {
      ((akhp)this.a.app.a(20)).b();
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, new Object[] { "AfterSyncMsg sendEmptyMessageDelayedToHandler MSG_INIT_MSGTAG_STORY process, send, ", Boolean.valueOf(this.a.b()) });
    }
    localObject1 = this.a.app.getHandler(Conversation.class);
    ((MqqHandler)localObject1).sendEmptyMessage(1055);
    ((MqqHandler)localObject1).sendEmptyMessage(1059);
    ((MqqHandler)localObject1).sendEmptyMessage(1061);
    if (bcxw.a(this.a.app.getApp()) != 2) {
      MiniAppController.preloadMiniProcess();
    }
    f();
    ((ajvr)this.a.app.getManager(69)).a();
    ThreadManager.getSubThreadHandler().post(new AfterSyncMsg.4(this));
    ((akdh)this.a.app.getManager(56)).a();
    nom.a().a(this.a.app);
    this.a.app.getManager(237);
    localObject1 = (njf)this.a.app.getManager(238);
    if (localObject1 != null)
    {
      if (!"5.0.2".equals(Build.VERSION.RELEASE)) {
        ((njf)localObject1).a();
      }
      ((njf)localObject1).a(this.a.app.c());
    }
    Object localObject2 = (ardi)this.a.app.getManager(268);
    if (localObject1 != null) {
      ((ardi)localObject2).a(this.a.app, this.a.app.c());
    }
    localObject1 = (nfd)this.a.app.getManager(173);
    localObject1 = (PhoneContactManagerImp)this.a.app.getManager(11);
    ((PhoneContactManagerImp)localObject1).c();
    andt.b(this.a.app, this.a.app.getCurrentAccountUin());
    ((PhoneContactManagerImp)localObject1).a(true, true, 2);
    localObject1 = (akjv)this.a.app.getManager(85);
    if (localObject1 != null) {
      ((akjv)localObject1).a();
    }
    c();
    sfe.a(this.a.app);
    sfe.a(this.a.app, sfe.a(this.a.app));
    this.a.app.a().o();
    this.a.app.a().m();
    bbmo.b();
    ((seo)this.a.app.getManager(101)).a();
    localObject1 = (akco)this.a.app.getManager(102);
    ((akco)localObject1).b();
    ((akco)localObject1).c();
    localObject2 = (agvx)this.a.app.getManager(125);
    ((agvx)localObject2).a(false);
    ((agvx)localObject2).d();
    ((agvx)localObject2).b();
    ((agvx)localObject2).a();
    ((bamx)this.a.app.getManager(81)).a(this.a.app);
    if (QLog.isColorLevel()) {
      QLog.d(".troop.del_abnormal_troop_local_msg", 2, "checkDelAbnormalLocalTroopMsg afterLogin");
    }
    this.a.app.a().q();
    this.a.app.H();
    SearchConfigManager.a(this.a.app);
    acsx.a(this.a.app);
    axqg.a();
    axqg.b();
    axqg.e();
    if (QLog.isColorLevel()) {
      QLog.d("Q.fts", 2, "troopMemberUpdateConfigStr=" + SearchConfigManager.troopMemberUpdateConfigStr);
    }
    if (!axnx.c)
    {
      ((aktm)this.a.app.a().a(2)).f();
      aknz.a().b();
      MemoryManager.a().b();
      axqa.a().a();
      axpv.a();
      agws.a(this.a.app);
      QWalletHelper.getPayCode(this.a.app);
      localObject2 = (akvq)this.a.app.getManager(199);
      if ((localObject2 != null) && (((akvq)localObject2).a()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQInitHandler", 4, " QQ 18 handle actionB cached stranger head update in AfterSyncMsg doAfterLogin");
        }
        ((akvq)localObject2).b();
      }
      if (Build.VERSION.SDK_INT >= 19)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QQInitHandler_PushOpenNotify", 2, "doafterlogin");
        }
        new aksj(this.a.app).execute(new Void[0]);
      }
      c();
      ((ajxl)this.a.app.getManager(51)).a(true);
      ((akbn)this.a.app.getManager(34)).i();
      ((KandianMergeManager)this.a.app.getManager(162)).k();
      ((ajud)this.a.app.a(4)).e();
      localObject2 = osg.a().a();
      if (localObject2 != null) {
        ((pbu)localObject2).a(this.a.app.c());
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
            localObject3 = njl.a(this.a.app, (MessageRecord)localObject3, true);
            if (localObject3 != null)
            {
              njb.a().a((nis)localObject3);
              continue;
              axnx.g = System.currentTimeMillis();
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
    ((FlashChatManager)this.a.app.getManager(217)).c();
    DeviceProfileManager.a(new aklc());
    azjs.a(this.a.app).a();
    bfoi.a(this.a.app).b();
    localObject2 = (agzd)this.a.app.getManager(245);
    if (localObject2 != null) {
      ((agzd)localObject2).a(1);
    }
    ahik.a();
    ((ayxw)this.a.app.getManager(233)).a();
    QuicResDownload.a(this.a.app);
    ((asey)this.a.app.getManager(242)).a();
    localObject2 = (ajti)this.a.app.a(2);
    ((ajti)localObject2).x();
    odk.a();
    rqj.a(false);
    ThreadManager.executeOnSubThread(new AfterSyncMsg.5(this));
    SosoInterface.b();
    bcwb.a(this.a.app);
    new Handler(ThreadManager.getFileThreadLooper()).postDelayed(new d(), 210000L);
    QQAppInterface.I();
    ahnl.a().a(this.a.app, BaseApplicationImpl.sApplication, true, false);
    if (QLog.isColorLevel()) {
      QLog.d("QQInitHandler", 2, "doAfterLogin call MayknowRecommendManager.getMayKnowRecommendRemote ");
    }
    ((akaa)this.a.app.getManager(159)).a(1);
    aega.a(((akco)localObject1).a).a();
    if (localObject2 != null)
    {
      ((ajti)localObject2).u();
      ((ajti)localObject2).t();
      ((ajti)localObject2).r();
      ((ajti)localObject2).s();
    }
    localObject1 = (ArkAppCenter)this.a.app.getManager(121);
    if (localObject1 != null)
    {
      localObject1 = ((ArkAppCenter)localObject1).a();
      if (localObject1 != null) {
        ((alth)localObject1).b();
      }
    }
    aexb.a(this.a.app).c();
    aexb.a(this.a.app).e();
    MiniArkShareAsyncManager.registerMiniArkShareMessageProcessorAfterProcessRestart();
    NotificationReportUtil.reportAll();
    c();
    arza.c();
    ((asks)this.a.app.getManager(37)).a();
    localObject1 = this.a.app.getHandler(Conversation.class);
    if (localObject1 != null) {
      ((MqqHandler)localObject1).obtainMessage(1134064).sendToTarget();
    }
    if (axbj.a(1, BaseApplicationImpl.processName)) {}
    try
    {
      l1 = System.currentTimeMillis();
      localObject1 = BaseActivity.sTopActivity;
      RecordManager.getInstance().setRecentActivityName((Activity)localObject1);
      RecordTracer.a().step();
      long l2 = System.currentTimeMillis();
      QLog.d("RecordTracer", 2, "conversation time " + (l2 - l1));
      ayfy.a(this.a.app).a();
      ThreadManager.executeOnSubThread(new AfterSyncMsg.6(this));
      ThreadManager.getFileThreadHandler().post(new AfterSyncMsg.7(this));
      h();
      ((ahfo)this.a.app.getManager(341)).a();
      amkf.b(true);
      this.a.app.K();
      ((amhc)this.a.app.a(168)).a();
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
    ((ajvg)this.a.app.a(6)).b();
    ((ajxl)this.a.app.getManager(51)).b();
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
      if (!bgyp.o()) {
        break label387;
      }
      QLog.i("QQInitHandler", 2, "updateQzoneFeeds 下发配置隐藏新动态");
    }
    for (;;)
    {
      osx.d(this.b);
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
            axqy.b(this.a.app, "dc00898", "", "", "0X800A4C7", "0X800A4C7", 0, 0, "", "0", "", "");
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
      axto.a(BaseApplicationImpl.getApplication());
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
    if (bbbm.a())
    {
      bbdx.c(ajsd.bH + ".nomedia");
      bbdx.c(ajsd.bI + ".nomedia");
    }
    if (this.a.jdField_a_of_type_AndroidContentSharedPreferences.getBoolean("isConvertOldQQHeadOK", false)) {
      return;
    }
    Hashtable localHashtable = new Hashtable();
    aukp localaukp = this.a.app.getEntityManagerFactory().createEntityManager();
    List localList = localaukp.a(Setting.class, new Setting().getTableName(), false, "bHeadType=? or (bHeadType<>? and bUsrType=?)", new String[] { "0", "0", "4" }, null, null, null, null);
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
            ayxl.a(str1, str2);
            ((File)localObject2).delete();
            localHashtable.put(localObject1, Boolean.valueOf(true));
          }
        }
      }
    }
    localaukp.a();
    Object localObject1 = new File(ajsd.bH + "_thd/");
    if (((File)localObject1).exists()) {
      bdif.a((File)localObject1);
    }
    localObject1 = new File("/data/data/com.tencent.mobileqq/files/head/_thd/");
    if (((File)localObject1).exists()) {
      bdif.a((File)localObject1);
    }
    this.a.jdField_a_of_type_AndroidContentSharedPreferences.edit().putBoolean("isConvertOldQQHeadOK", true).commit();
  }
  
  private void h()
  {
    if ((this.a != null) && (this.a.app != null))
    {
      new bhzq().a(Long.parseLong(this.a.app.getCurrentAccountUin()));
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
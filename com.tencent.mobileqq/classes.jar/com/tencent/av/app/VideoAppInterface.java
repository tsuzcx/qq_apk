package com.tencent.av.app;

import android.app.Notification;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.ResultReceiver;
import android.text.TextUtils;
import azvm;
import bbpk;
import bcef;
import com.tencent.av.HardWareCodecSSO.ConfigReq;
import com.tencent.av.VideoController;
import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.av.video.call.ClientLogReport;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mfsdk.reporter.ReporterMachine;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.redtouch.RedAppInfo;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.startup.step.AVSoUtils;
import com.tencent.mobileqq.statistics.StatisticCollector.StatisticCallback;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.NetEngineFactory;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observer;
import java.util.Vector;
import lba;
import lcu;
import lcv;
import lcx;
import lda;
import ldt;
import ldv;
import ldx;
import lea;
import lec;
import lee;
import leg;
import lei;
import lel;
import lep;
import leq;
import ler;
import leu;
import lez;
import lfd;
import lfe;
import lfh;
import lfi;
import lfx;
import lgd;
import lge;
import lgf;
import lhu;
import lhw;
import lhy;
import ljt;
import lld;
import loi;
import lvl;
import lvz;
import lzb;
import mbr;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import msw;

public class VideoAppInterface
  extends AppInterface
  implements StatisticCollector.StatisticCallback, leq
{
  private static String jdField_a_of_type_JavaLangString = "VideoAppInterface";
  protected int a;
  protected Handler a;
  public VideoController a;
  protected DeviceCapabilityExamination a;
  private EntityManagerFactory jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  private NetEngineFactory jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  protected List<BusinessObserver> a;
  private lcu jdField_a_of_type_Lcu;
  private lcv jdField_a_of_type_Lcv;
  lda jdField_a_of_type_Lda;
  ldt jdField_a_of_type_Ldt;
  ldv jdField_a_of_type_Ldv;
  ldx jdField_a_of_type_Ldx;
  lea jdField_a_of_type_Lea;
  lec jdField_a_of_type_Lec;
  lee jdField_a_of_type_Lee;
  leg jdField_a_of_type_Leg;
  lei jdField_a_of_type_Lei;
  lel jdField_a_of_type_Lel;
  lep jdField_a_of_type_Lep;
  private ler jdField_a_of_type_Ler;
  leu jdField_a_of_type_Leu;
  lfe jdField_a_of_type_Lfe = null;
  private lfh jdField_a_of_type_Lfh;
  private lfx jdField_a_of_type_Lfx;
  public lge a;
  protected lgf a;
  ljt jdField_a_of_type_Ljt;
  private final loi jdField_a_of_type_Loi = new loi();
  protected boolean a;
  private Runnable b;
  public boolean b;
  public boolean c;
  public boolean d;
  public boolean e;
  public boolean f;
  public boolean g;
  private boolean h;
  
  public VideoAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_JavaLangRunnable = new VideoAppInterface.2(this);
  }
  
  private void f()
  {
    AudioManager localAudioManager = (AudioManager)getApplication().getApplicationContext().getSystemService("audio");
    if (localAudioManager != null)
    {
      this.jdField_a_of_type_Boolean = localAudioManager.isSpeakerphoneOn();
      this.jdField_a_of_type_Int = localAudioManager.getMode();
    }
  }
  
  private void g()
  {
    this.jdField_a_of_type_Ldt.b();
    this.jdField_a_of_type_Ldx.b();
    this.jdField_a_of_type_Lee.a();
    this.jdField_a_of_type_Lel.a();
    this.jdField_a_of_type_Ldv.a();
    this.jdField_a_of_type_Lea.a();
    this.jdField_a_of_type_Lei.a();
    this.jdField_a_of_type_Leg.b();
    this.jdField_a_of_type_Lec.a();
    this.jdField_a_of_type_Ler.a();
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null) {
      a();
    }
    for (;;)
    {
      AudioHelper.b("VideoAppInterface.onCreate.end");
      return;
      this.jdField_a_of_type_ComTencentAvVideoController.a(this);
    }
  }
  
  private void i()
  {
    try
    {
      PowerManager localPowerManager = (PowerManager)getApp().getSystemService("power");
      if (!localPowerManager.isScreenOn()) {
        localPowerManager.newWakeLock(1, "mobileqq:videoapp").acquire(10000L);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void j()
  {
    ThreadManager.post(this.jdField_b_of_type_JavaLangRunnable, 10, null, true);
  }
  
  private void k()
  {
    if ((AudioHelper.e()) && (AudioHelper.a(13) == 1))
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "onCreate, 音视频进程在等待调试器连接(界面会无响应)");
      Debug.waitForDebugger();
    }
  }
  
  private void l()
  {
    QLog.d(jdField_a_of_type_JavaLangString, 2, "registerExitProcessReceiver");
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.av.exit_process");
    getApp().registerReceiver(new lfd(this), localIntentFilter);
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_JavaLangRunnable == null) {
      this.jdField_a_of_type_JavaLangRunnable = new VideoAppInterface.5(this);
    }
    for (;;)
    {
      a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
      return;
      a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
  }
  
  public int a()
  {
    return a().countObservers();
  }
  
  public int a(int paramInt, String paramString)
  {
    return this.jdField_a_of_type_Leu.a(paramInt, paramString);
  }
  
  public int a(String paramString)
  {
    return this.jdField_a_of_type_Leu.a(paramString);
  }
  
  public long a(String paramString)
  {
    return this.jdField_a_of_type_Leu.a(paramString);
  }
  
  public Bitmap a(int paramInt, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    return this.jdField_a_of_type_Leu.a(paramInt, paramString1, paramString2, paramBoolean1, paramBoolean2);
  }
  
  public Bundle a(int paramInt1, int paramInt2, int paramInt3, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    return this.jdField_a_of_type_Leu.a(paramInt1, paramInt2, paramInt3, paramBundle, paramResultReceiver);
  }
  
  public Handler a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public VideoController a()
  {
    if (this.jdField_a_of_type_ComTencentAvVideoController == null)
    {
      this.jdField_a_of_type_ComTencentAvVideoController = VideoController.a();
      this.jdField_a_of_type_ComTencentAvVideoController.a(this);
    }
    return this.jdField_a_of_type_ComTencentAvVideoController;
  }
  
  public BusinessHandler a(int paramInt)
  {
    return this.jdField_a_of_type_Lfx.a(this, paramInt);
  }
  
  public BusinessInfoCheckUpdate.AppInfo a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("red_touch_app_id", paramString);
    paramString = a(7, 0, 0, localBundle, null);
    if (paramString == null) {
      return null;
    }
    paramString.setClassLoader(RedAppInfo.class.getClassLoader());
    return azvm.a((RedAppInfo)paramString.getParcelable("red_touch_red_app_info"));
  }
  
  public String a()
  {
    String str2 = getApp().getString(2131719523);
    Object localObject = a();
    String str1 = str2;
    if (localObject != null)
    {
      String str3 = ((VideoController)localObject).a().d;
      int i = ((VideoController)localObject).a().j;
      localObject = ((VideoController)localObject).a().f;
      str1 = str2;
      if (i == 9500) {
        str1 = getDisplayName(i, str3, (String)localObject) + getApp().getString(2131719525);
      }
    }
    return str1;
  }
  
  public String a(String paramString)
  {
    return this.jdField_a_of_type_Leu.b(paramString);
  }
  
  public Map<String, Integer> a()
  {
    try
    {
      Map localMap = this.jdField_a_of_type_Lec.a();
      return localMap;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public lcu a()
  {
    return this.jdField_a_of_type_Lcu;
  }
  
  public lcv a()
  {
    return this.jdField_a_of_type_Lcv;
  }
  
  public lfe a()
  {
    if (this.jdField_a_of_type_Lfe == null) {
      this.jdField_a_of_type_Lfe = new lfe(this);
    }
    return this.jdField_a_of_type_Lfe;
  }
  
  public lgd a(int paramInt)
  {
    return this.jdField_a_of_type_Lge.a(paramInt);
  }
  
  public ljt a()
  {
    return this.jdField_a_of_type_Ljt;
  }
  
  public loi a()
  {
    if (this.h) {
      return this.jdField_a_of_type_Loi;
    }
    synchronized (this.jdField_a_of_type_Loi)
    {
      String str;
      if (!this.h)
      {
        str = mbr.a(getCurrentAccountUin());
        if (!TextUtils.isEmpty(str)) {
          break label133;
        }
        int j = mbr.a(getCurrentAccountUin());
        i = j;
        if (j != -1)
        {
          this.jdField_a_of_type_Loi.a("BEAUTY_SKIN", j);
          i = j;
        }
        this.h = true;
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "getBeautyConfig config[" + str + "], level[" + i + "]");
        }
      }
      return this.jdField_a_of_type_Loi;
      label133:
      this.jdField_a_of_type_Loi.a(str);
      int i = -1;
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getVideoConfigUpdate");
    }
    NewIntent localNewIntent = new NewIntent(this.app, bbpk.class);
    localNewIntent.putExtra("reqType", 11);
    startServlet(localNewIntent);
  }
  
  public void a(int paramInt)
  {
    VideoController localVideoController = a();
    if (localVideoController != null) {
      localVideoController.a(paramInt);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Lge.a(paramInt, paramString);
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Leu.a(paramInt, paramString1, paramString2);
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Leu.a(paramLong);
  }
  
  public void a(long paramLong, int paramInt)
  {
    if (paramInt < 200) {}
    for (int i = paramInt + 200;; i = paramInt)
    {
      boolean bool;
      if (i == 261) {
        bool = true;
      }
      for (;;)
      {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "video exit, mIsExit[" + this.e + "], reason[" + i + "], _reason[" + paramInt + "], mManagerFactory[" + this.jdField_a_of_type_Lge + "], seq[" + paramLong + "]", new Throwable("打印调用栈"));
        this.e = true;
        Object localObject;
        if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a() != null))
        {
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().H) {
            bcef.b(null, "CliOper", "", "", "0X8008AAD", "0X8008AAD", 0, 0, "", "", "", "");
          }
        }
        else
        {
          if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvVideoController != null)) {
            this.jdField_a_of_type_ComTencentAvVideoController.B();
          }
          this.jdField_b_of_type_Boolean = false;
          lzb.a(paramLong, 1, getApplication());
          lba.g(jdField_a_of_type_JavaLangString, "exit video process clearNotification");
          QQNotificationManager.getInstance().cancel(jdField_a_of_type_JavaLangString, 235);
          localObject = (AudioManager)getApplication().getApplicationContext().getSystemService("audio");
          if (localObject == null) {}
        }
        try
        {
          ((AudioManager)localObject).setSpeakerphoneOn(this.jdField_a_of_type_Boolean);
          ((AudioManager)localObject).setMode(this.jdField_a_of_type_Int);
          localObject = msw.a(this);
          if (localObject != null) {
            ((msw)localObject).a();
          }
          lba.g(jdField_a_of_type_JavaLangString, "force exit video process ...");
          QLog.flushLog();
          if (this.jdField_a_of_type_Lcu != null)
          {
            if (this.jdField_a_of_type_Lcu.a()) {
              this.jdField_a_of_type_Lcu.a(bool);
            }
            if (this.jdField_a_of_type_Lcu.c()) {
              this.jdField_a_of_type_ComTencentAvVideoController.p(false);
            }
            if (this.jdField_a_of_type_Lcu.b()) {
              this.jdField_a_of_type_ComTencentAvVideoController.n(false);
            }
          }
          return;
          bool = false;
          continue;
          bcef.b(null, "CliOper", "", "", "0X8008AAC", "0X8008AAC", 0, 0, "", "", "", "");
        }
        catch (NullPointerException localNullPointerException)
        {
          for (;;)
          {
            lba.g(jdField_a_of_type_JavaLangString, "VideoAppInterface.exit() -> am.setSpeakerphoneOn() catch NullPointerException !");
          }
        }
      }
    }
  }
  
  public void a(long paramLong1, String paramString, long paramLong2)
  {
    this.jdField_a_of_type_Leu.a(paramLong1, paramString, paramLong2);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 2, "receiveToService");
    this.jdField_a_of_type_Lfh.a(paramFromServiceMsg.isSuccess(), paramToServiceMsg, paramFromServiceMsg, null);
  }
  
  public void a(String paramString)
  {
    Object localObject = getApplication().refreAccountList();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        SimpleAccount localSimpleAccount = (SimpleAccount)((Iterator)localObject).next();
        if (paramString.equals(localSimpleAccount.getUin()))
        {
          if (QLog.isColorLevel()) {
            QLog.d(jdField_a_of_type_JavaLangString, 2, "Switch Account: " + paramString);
          }
          switchAccount(localSimpleAccount, null);
          if (this.jdField_a_of_type_ComTencentAvVideoController != null) {
            this.jdField_a_of_type_ComTencentAvVideoController.a(paramString);
          }
          this.jdField_a_of_type_ComTencentAvVideoController = null;
        }
      }
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    try
    {
      this.jdField_a_of_type_Lec.a(paramString, paramInt);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    a().a(paramString, paramInt);
    if (paramBoolean)
    {
      m();
      if (QLog.isDevelopLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 4, "setBeautyValue name[" + paramString + "], value[" + paramInt + "]");
      }
    }
  }
  
  public void a(Observer paramObserver)
  {
    if (paramObserver != null)
    {
      a().addObserver(paramObserver);
      if ((this.jdField_a_of_type_Leu != null) && (this.jdField_a_of_type_Leu.a != null)) {
        paramObserver.update(a(), new Object[] { Integer.valueOf(10) });
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Leu != null) {
      this.jdField_a_of_type_Leu.a(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, Notification paramNotification)
  {
    this.jdField_a_of_type_Lda.a(paramBoolean, paramNotification);
  }
  
  public void a(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length > 0)) {
      a().a(paramArrayOfObject);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Lda.a();
  }
  
  public boolean a(int paramInt)
  {
    return this.jdField_a_of_type_Lge.a(paramInt);
  }
  
  public boolean a(int paramInt, long paramLong)
  {
    return this.jdField_a_of_type_Leu.a(paramInt, paramLong);
  }
  
  public boolean a(long paramLong)
  {
    return this.jdField_a_of_type_Leu.a(paramLong);
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_Leu.a(paramString);
  }
  
  public boolean a(String paramString, int paramInt)
  {
    return this.jdField_a_of_type_Leu.a(paramString, paramInt);
  }
  
  public boolean a(lvz paramlvz)
  {
    return this.jdField_a_of_type_Leu.a(paramlvz);
  }
  
  public long[] a(String paramString)
  {
    return this.jdField_a_of_type_Leu.a(paramString);
  }
  
  public void addObserver(BusinessObserver paramBusinessObserver)
  {
    addObserver(paramBusinessObserver, false);
  }
  
  public void addObserver(BusinessObserver paramBusinessObserver, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramBusinessObserver)) {
      this.jdField_a_of_type_JavaUtilList.add(paramBusinessObserver);
    }
  }
  
  public int b(String paramString)
  {
    return a().a(paramString);
  }
  
  public String b()
  {
    return this.jdField_a_of_type_Leu.a();
  }
  
  public String b(String paramString)
  {
    return this.jdField_a_of_type_Leu.c(paramString);
  }
  
  public void b()
  {
    HardWareCodecSSO.ConfigReq localConfigReq = new HardWareCodecSSO.ConfigReq();
    localConfigReq.app_id.set(0);
    localConfigReq.app_ver.set("8.4.8");
    localConfigReq.mobile.set(Build.MODEL);
    localConfigReq.chip.set(Build.HARDWARE + "_" + lld.a());
    localConfigReq.os_version.set(Build.VERSION.SDK_INT);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder(50);
      ((StringBuilder)localObject).append("app_id:=").append(localConfigReq.app_id.get()).append("\n");
      ((StringBuilder)localObject).append("app_ver:=").append(localConfigReq.app_ver.get()).append("\n");
      ((StringBuilder)localObject).append("mobile:=").append(localConfigReq.mobile.get()).append("\n");
      ((StringBuilder)localObject).append("chip:=").append(localConfigReq.chip.get()).append("\n");
      ((StringBuilder)localObject).append("os_version:=").append(localConfigReq.os_version.get()).append("\n");
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getMediaCodecChipConfigUpdate + " + ((StringBuilder)localObject).toString());
    }
    Object localObject = new NewIntent(this.app, lcx.class);
    ((NewIntent)localObject).putExtra("reqType", 23);
    ((NewIntent)localObject).putExtra("vMsg", localConfigReq.toByteArray());
    startServlet((NewIntent)localObject);
  }
  
  public void b(int paramInt)
  {
    long l = AudioHelper.b();
    QLog.w(jdField_a_of_type_JavaLangString, 1, "exitVideoProcess, reason[" + paramInt + "], videoController[" + this.jdField_a_of_type_ComTencentAvVideoController + "], reason[" + paramInt + "], seq[" + l + "]");
    int i;
    switch (paramInt)
    {
    default: 
      i = 260;
    }
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_ComTencentAvVideoController != null)
        {
          int j = this.jdField_a_of_type_ComTencentAvVideoController.a().g;
          if ((j > 0) && (j <= 4))
          {
            String str = this.jdField_a_of_type_ComTencentAvVideoController.a().d;
            this.jdField_a_of_type_ComTencentAvVideoController.a(str, i);
            this.jdField_a_of_type_ComTencentAvVideoController.b(i);
            this.jdField_a_of_type_ComTencentAvVideoController.b(str, 0);
            this.jdField_a_of_type_ComTencentAvVideoController.n = false;
            a(l, paramInt);
            return;
          }
          if (!this.jdField_a_of_type_ComTencentAvVideoController.e) {
            continue;
          }
          this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.b, this.jdField_a_of_type_ComTencentAvVideoController.a, 72);
          continue;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 1, "exitVideoProcess System.exit ");
      }
      catch (Exception localException)
      {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "exitVideoProcess Exception System.exit ");
        QLog.flushLog();
        return;
      }
      QLog.flushLog();
      return;
      i = 254;
      continue;
      i = 255;
      continue;
      i = 256;
      continue;
      i = 257;
      continue;
      i = 258;
      continue;
      i = 259;
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Leu.a(paramInt, paramString);
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_Leu.a(paramString);
  }
  
  public void b(Observer paramObserver)
  {
    a().deleteObserver(paramObserver);
  }
  
  public void b(boolean paramBoolean)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 1, "reportQuaProcessWakeUp() isBroadcastCreated = " + paramBoolean);
    if (paramBoolean) {
      this.f = true;
    }
    for (;;)
    {
      if (this.f)
      {
        if (!this.g) {
          break;
        }
        lhu.a(this.f, this.g);
      }
      return;
      this.g = true;
    }
    a().postDelayed(new VideoAppInterface.3(this), 3000L);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Leu.b();
  }
  
  public boolean b(String paramString)
  {
    return this.jdField_a_of_type_Leu.b(paramString);
  }
  
  public boolean b(lvz paramlvz)
  {
    return this.jdField_a_of_type_Leu.b(paramlvz);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Leu.c();
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_Lge.a(paramInt);
  }
  
  public void c(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Leu.b(paramInt, paramString);
  }
  
  public void c(String paramString)
  {
    this.jdField_a_of_type_Leu.b(paramString);
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Leu.c();
  }
  
  public boolean c(String paramString)
  {
    return this.jdField_a_of_type_Leu.c(paramString);
  }
  
  public void d()
  {
    this.jdField_a_of_type_Leu.d();
  }
  
  public void d(String paramString)
  {
    this.jdField_a_of_type_Leu.c(paramString);
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_Leu.d();
  }
  
  public void e()
  {
    a().b();
    m();
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_Leu.e();
  }
  
  public boolean f()
  {
    return this.jdField_a_of_type_Leu.f();
  }
  
  public boolean g()
  {
    return this.jdField_a_of_type_Leu.g();
  }
  
  public BaseApplication getApp()
  {
    return this.app;
  }
  
  public int getAppid()
  {
    return AppSetting.a();
  }
  
  public List<BusinessObserver> getBusinessObserver(int paramInt)
  {
    if (paramInt == 0) {
      return this.jdField_a_of_type_JavaUtilList;
    }
    return null;
  }
  
  public String getCurrentAccountUin()
  {
    return getAccount();
  }
  
  public String getDisplayName(int paramInt, String paramString1, String paramString2)
  {
    return this.jdField_a_of_type_Leu.b(paramInt, paramString1, paramString2);
  }
  
  public EntityManagerFactory getEntityManagerFactory(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory == null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory = new QQEntityManagerFactory(getAccount());
    }
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  }
  
  public Class<? extends MSFServlet>[] getMessagePushServlets()
  {
    return new Class[] { lcx.class };
  }
  
  public INetEngine getNetEngine(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory == null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory = new NetEngineFactory();
    }
    return this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory.getEngineInstance(this, paramInt);
  }
  
  public boolean h()
  {
    return this.jdField_a_of_type_Leu.h();
  }
  
  public boolean i()
  {
    return this.jdField_a_of_type_Leu.i();
  }
  
  public boolean j()
  {
    return this.jdField_a_of_type_Leu.a();
  }
  
  public boolean k()
  {
    loi localloi = a();
    if (localloi.a("BEAUTY_SKIN") != 0) {
      return true;
    }
    return localloi.b();
  }
  
  public void onCallback(String paramString)
  {
    lhy locallhy = (lhy)a(4);
    if (locallhy != null)
    {
      locallhy.a(paramString);
      locallhy.a(36, 1L);
      locallhy.a(29, 1L);
      locallhy.b();
      lhw.a(16, 1L);
      lhw.c();
    }
    onDestroy();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (AudioHelper.e()) {
      QLog.setUIN_REPORTLOG_LEVEL(4);
    }
    AudioHelper.b("VideoAppInterface.onCreate.begin");
    AVSoUtils.a(-1045L);
    this.c = true;
    lhw.a(this);
    lhw.a();
    lhw.a(27);
    long l1 = System.currentTimeMillis();
    super.onCreate(paramBundle);
    k();
    AudioHelper.a(this.app, getLongAccountUin());
    AudioHelper.a(BaseApplication.getContext());
    AudioHelper.b("VideoAppInterface.onCreate.begin1");
    i();
    getEntityManagerFactory(null);
    this.jdField_a_of_type_Lep = new lep(this);
    AppNetConnInfo.registerConnectionChangeReceiver(getApplication(), this.jdField_a_of_type_Lep);
    this.jdField_a_of_type_Lfh = new lfh(this);
    this.jdField_a_of_type_Lfx = new lfx();
    this.jdField_a_of_type_Lfx.a(this.jdField_a_of_type_Lfh);
    this.jdField_a_of_type_Lge = new lge(this);
    this.jdField_a_of_type_Lgf = new lgf(this);
    h();
    this.jdField_a_of_type_ComTencentAvAppDeviceCapabilityExamination = new DeviceCapabilityExamination(this);
    this.jdField_a_of_type_Ldx = new ldx(this);
    this.jdField_a_of_type_Ldt = new ldt(this);
    this.jdField_a_of_type_Lee = new lee(this);
    this.jdField_a_of_type_Lel = new lel(this);
    this.jdField_a_of_type_Ldv = new ldv(this);
    this.jdField_a_of_type_Lea = new lea(this);
    this.jdField_a_of_type_Lei = new lei(this);
    this.jdField_a_of_type_Leg = new leg(this);
    this.jdField_a_of_type_Lec = new lec(this);
    this.jdField_a_of_type_Lcu = new lcu(this);
    this.jdField_a_of_type_Lcv = new lcv(this);
    this.jdField_a_of_type_Ler = new ler(this);
    this.jdField_a_of_type_Leu = new leu(this);
    this.jdField_a_of_type_Leu.a();
    this.jdField_a_of_type_Leu.c();
    this.jdField_a_of_type_Lda = new lda(this);
    this.jdField_a_of_type_Lda.a();
    this.jdField_a_of_type_Ljt = new ljt(this);
    lvl.a().a();
    f();
    ThreadManager.post(new VideoAppInterface.CameraUsageRunnable(this), 5, null, true);
    ThreadManager.excute(new VideoAppInterface.1(this), 16, null, true);
    this.jdField_a_of_type_JavaUtilList = new Vector();
    j();
    g();
    try
    {
      MagnifierSDK.a(Long.parseLong(getAccount()));
    }
    catch (Exception paramBundle)
    {
      try
      {
        for (;;)
        {
          ReporterMachine.a();
          if (QLog.isDevelopLevel())
          {
            long l2 = System.currentTimeMillis();
            QLog.d("IVR_TS_" + jdField_a_of_type_JavaLangString, 4, String.format("VideoAppInterface onCreate(), cost=%dms", new Object[] { Long.valueOf(l2 - l1) }));
          }
          AudioHelper.b("VideoAppInterface.onCreate.end");
          l();
          ClientLogReport.instance().checkLocalReportRecord();
          if (AudioHelper.a(25) == 1)
          {
            AudioHelper.a("使用了index_disable_immersive");
            com.tencent.widget.immersive.ImmersiveUtils.jdField_a_of_type_Int = 0;
          }
          return;
          paramBundle = paramBundle;
          QLog.e(jdField_a_of_type_JavaLangString, 4, paramBundle.toString());
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          QLog.e(jdField_a_of_type_JavaLangString, 1, "[Magnifier startMachine error]" + paramBundle);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
    m();
    this.jdField_b_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_Lda.b();
    this.jdField_a_of_type_Leu.b();
    this.jdField_a_of_type_Leu.d();
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory.onDestroy();
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory = null;
      PtvTemplateManager.a();
      AVRedPacketManager.b();
      this.jdField_a_of_type_Lei.b();
      this.jdField_a_of_type_Leg.a();
      this.jdField_a_of_type_Ldx.a();
      this.jdField_a_of_type_Ldt.a();
      this.jdField_a_of_type_Lee.b();
      this.jdField_a_of_type_Lel.b();
      this.jdField_a_of_type_Ldv.b();
      this.jdField_a_of_type_Lea.b();
      this.jdField_a_of_type_Lec.b();
      this.jdField_a_of_type_Ler.b();
      lfi.a(getApp());
      lhw.b();
      super.onDestroy();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory.onDestroy();
      }
    }
  }
  
  public void removeObserver(BusinessObserver paramBusinessObserver)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramBusinessObserver);
  }
  
  public void sendToService(ToServiceMsg paramToServiceMsg)
  {
    lba.f(jdField_a_of_type_JavaLangString, "sendToService");
    this.jdField_a_of_type_Lfh.a(paramToServiceMsg, null, lcx.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.app.VideoAppInterface
 * JD-Core Version:    0.7.0.1
 */
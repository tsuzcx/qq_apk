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
import bapt;
import bbbt;
import bcwe;
import bdla;
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
import com.tencent.mobileqq.videoplatform.SDKInitListener;
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
import lbd;
import lcz;
import lda;
import ldc;
import ldf;
import ldy;
import lea;
import lec;
import lef;
import leh;
import lej;
import lel;
import len;
import leq;
import leu;
import lev;
import lew;
import lez;
import lfe;
import lfi;
import lfj;
import lft;
import lfu;
import lgj;
import lgp;
import lgq;
import lgr;
import lig;
import lii;
import lik;
import lkf;
import llq;
import lov;
import lvy;
import lwm;
import lzr;
import mcm;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mtt;
import mxk;

public class VideoAppInterface
  extends AppInterface
  implements StatisticCollector.StatisticCallback, SDKInitListener, lev
{
  public static Boolean a;
  private static String jdField_a_of_type_JavaLangString = "VideoAppInterface";
  protected int a;
  protected Handler a;
  public VideoController a;
  protected DeviceCapabilityExamination a;
  private EntityManagerFactory jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  private NetEngineFactory jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  protected List<BusinessObserver> a;
  private lcz jdField_a_of_type_Lcz;
  private lda jdField_a_of_type_Lda;
  ldf jdField_a_of_type_Ldf;
  ldy jdField_a_of_type_Ldy;
  lea jdField_a_of_type_Lea;
  lec jdField_a_of_type_Lec;
  lef jdField_a_of_type_Lef;
  leh jdField_a_of_type_Leh;
  lej jdField_a_of_type_Lej;
  lel jdField_a_of_type_Lel;
  len jdField_a_of_type_Len;
  leq jdField_a_of_type_Leq;
  leu jdField_a_of_type_Leu;
  private lew jdField_a_of_type_Lew;
  lez jdField_a_of_type_Lez;
  lfj jdField_a_of_type_Lfj = null;
  private lft jdField_a_of_type_Lft;
  private lgj jdField_a_of_type_Lgj;
  public lgq a;
  protected lgr a;
  lkf jdField_a_of_type_Lkf;
  private final lov jdField_a_of_type_Lov = new lov();
  mxk jdField_a_of_type_Mxk;
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
    this.jdField_a_of_type_Ldy.b();
    this.jdField_a_of_type_Lec.b();
    this.jdField_a_of_type_Lej.a();
    this.jdField_a_of_type_Leq.a();
    this.jdField_a_of_type_Lea.a();
    this.jdField_a_of_type_Lef.a();
    this.jdField_a_of_type_Len.a();
    this.jdField_a_of_type_Lel.b();
    this.jdField_a_of_type_Leh.a();
    this.jdField_a_of_type_Lew.a();
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
    getApp().registerReceiver(new lfi(this), localIntentFilter);
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
    return this.jdField_a_of_type_Lez.a(paramInt, paramString);
  }
  
  public int a(String paramString)
  {
    return this.jdField_a_of_type_Lez.a(paramString);
  }
  
  public long a(String paramString)
  {
    return this.jdField_a_of_type_Lez.a(paramString);
  }
  
  public Bitmap a(int paramInt, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    return this.jdField_a_of_type_Lez.a(paramInt, paramString1, paramString2, paramBoolean1, paramBoolean2);
  }
  
  public Bundle a(int paramInt1, int paramInt2, int paramInt3, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    return this.jdField_a_of_type_Lez.a(paramInt1, paramInt2, paramInt3, paramBundle, paramResultReceiver);
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
    return this.jdField_a_of_type_Lgj.a(this, paramInt);
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
    return bbbt.a((RedAppInfo)paramString.getParcelable("red_touch_red_app_info"));
  }
  
  public String a()
  {
    String str2 = getApp().getString(2131719975);
    Object localObject = a();
    String str1 = str2;
    if (localObject != null)
    {
      String str3 = ((VideoController)localObject).a().d;
      int i = ((VideoController)localObject).a().j;
      localObject = ((VideoController)localObject).a().f;
      str1 = str2;
      if (i == 9500) {
        str1 = getDisplayName(i, str3, (String)localObject) + getApp().getString(2131719977);
      }
    }
    return str1;
  }
  
  public String a(String paramString)
  {
    return this.jdField_a_of_type_Lez.b(paramString);
  }
  
  public Map<String, Integer> a()
  {
    try
    {
      Map localMap = this.jdField_a_of_type_Leh.a();
      return localMap;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public lcz a()
  {
    return this.jdField_a_of_type_Lcz;
  }
  
  public lda a()
  {
    return this.jdField_a_of_type_Lda;
  }
  
  public lfj a()
  {
    if (this.jdField_a_of_type_Lfj == null) {
      this.jdField_a_of_type_Lfj = new lfj(this);
    }
    return this.jdField_a_of_type_Lfj;
  }
  
  public lgp a(int paramInt)
  {
    return this.jdField_a_of_type_Lgq.a(paramInt);
  }
  
  public lkf a()
  {
    return this.jdField_a_of_type_Lkf;
  }
  
  public lov a()
  {
    if (this.h) {
      return this.jdField_a_of_type_Lov;
    }
    synchronized (this.jdField_a_of_type_Lov)
    {
      String str;
      if (!this.h)
      {
        str = mcm.a(getCurrentAccountUin());
        if (!TextUtils.isEmpty(str)) {
          break label133;
        }
        int j = mcm.a(getCurrentAccountUin());
        i = j;
        if (j != -1)
        {
          this.jdField_a_of_type_Lov.a("BEAUTY_SKIN", j);
          i = j;
        }
        this.h = true;
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "getBeautyConfig config[" + str + "], level[" + i + "]");
        }
      }
      return this.jdField_a_of_type_Lov;
      label133:
      this.jdField_a_of_type_Lov.a(str);
      int i = -1;
    }
  }
  
  public mxk a()
  {
    return this.jdField_a_of_type_Mxk;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getVideoConfigUpdate");
    }
    NewIntent localNewIntent = new NewIntent(this.app, bcwe.class);
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
    this.jdField_a_of_type_Lgq.a(paramInt, paramString);
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Lez.a(paramInt, paramString1, paramString2);
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Lez.a(paramLong);
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
        QLog.w(jdField_a_of_type_JavaLangString, 1, "video exit, mIsExit[" + this.e + "], reason[" + i + "], _reason[" + paramInt + "], mManagerFactory[" + this.jdField_a_of_type_Lgq + "], seq[" + paramLong + "]", new Throwable("打印调用栈"));
        this.e = true;
        Object localObject;
        if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a() != null))
        {
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().H) {
            bdla.b(null, "CliOper", "", "", "0X8008AAD", "0X8008AAD", 0, 0, "", "", "", "");
          }
        }
        else
        {
          if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvVideoController != null)) {
            this.jdField_a_of_type_ComTencentAvVideoController.B();
          }
          this.jdField_b_of_type_Boolean = false;
          lzr.a(paramLong, 1, getApplication());
          lbd.g(jdField_a_of_type_JavaLangString, "exit video process clearNotification");
          QQNotificationManager.getInstance().cancel(jdField_a_of_type_JavaLangString, 235);
          localObject = (AudioManager)getApplication().getApplicationContext().getSystemService("audio");
          if (localObject == null) {}
        }
        try
        {
          ((AudioManager)localObject).setSpeakerphoneOn(this.jdField_a_of_type_Boolean);
          ((AudioManager)localObject).setMode(this.jdField_a_of_type_Int);
          localObject = mtt.a(this);
          if (localObject != null) {
            ((mtt)localObject).a();
          }
          lbd.g(jdField_a_of_type_JavaLangString, "force exit video process ...");
          QLog.flushLog();
          if (this.jdField_a_of_type_Lcz != null)
          {
            if (this.jdField_a_of_type_Lcz.a()) {
              this.jdField_a_of_type_Lcz.a(bool);
            }
            if (this.jdField_a_of_type_Lcz.c()) {
              this.jdField_a_of_type_ComTencentAvVideoController.p(false);
            }
            if (this.jdField_a_of_type_Lcz.b()) {
              this.jdField_a_of_type_ComTencentAvVideoController.n(false);
            }
          }
          return;
          bool = false;
          continue;
          bdla.b(null, "CliOper", "", "", "0X8008AAC", "0X8008AAC", 0, 0, "", "", "", "");
        }
        catch (NullPointerException localNullPointerException)
        {
          for (;;)
          {
            lbd.g(jdField_a_of_type_JavaLangString, "VideoAppInterface.exit() -> am.setSpeakerphoneOn() catch NullPointerException !");
          }
        }
      }
    }
  }
  
  public void a(long paramLong1, String paramString, long paramLong2)
  {
    this.jdField_a_of_type_Lez.a(paramLong1, paramString, paramLong2);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 2, "receiveToService");
    this.jdField_a_of_type_Lft.a(paramFromServiceMsg.isSuccess(), paramToServiceMsg, paramFromServiceMsg, null);
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
      this.jdField_a_of_type_Leh.a(paramString, paramInt);
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
      if ((this.jdField_a_of_type_Lez != null) && (this.jdField_a_of_type_Lez.a != null)) {
        paramObserver.update(a(), new Object[] { Integer.valueOf(10) });
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Lez != null) {
      this.jdField_a_of_type_Lez.a(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, Notification paramNotification)
  {
    this.jdField_a_of_type_Ldf.a(paramBoolean, paramNotification);
  }
  
  public void a(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length > 0)) {
      a().a(paramArrayOfObject);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Ldf.a();
  }
  
  public boolean a(int paramInt)
  {
    return this.jdField_a_of_type_Lgq.a(paramInt);
  }
  
  public boolean a(int paramInt, long paramLong)
  {
    return this.jdField_a_of_type_Lez.a(paramInt, paramLong);
  }
  
  public boolean a(long paramLong)
  {
    return this.jdField_a_of_type_Lez.a(paramLong);
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_Lez.a(paramString);
  }
  
  public boolean a(String paramString, int paramInt)
  {
    return this.jdField_a_of_type_Lez.a(paramString, paramInt);
  }
  
  public boolean a(lwm paramlwm)
  {
    return this.jdField_a_of_type_Lez.a(paramlwm);
  }
  
  public long[] a(String paramString)
  {
    return this.jdField_a_of_type_Lez.a(paramString);
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
    return this.jdField_a_of_type_Lez.a();
  }
  
  public String b(String paramString)
  {
    return this.jdField_a_of_type_Lez.c(paramString);
  }
  
  public void b()
  {
    HardWareCodecSSO.ConfigReq localConfigReq = new HardWareCodecSSO.ConfigReq();
    localConfigReq.app_id.set(0);
    localConfigReq.app_ver.set("8.4.10");
    localConfigReq.mobile.set(Build.MODEL);
    localConfigReq.chip.set(Build.HARDWARE + "_" + llq.a());
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
    Object localObject = new NewIntent(this.app, ldc.class);
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
    this.jdField_a_of_type_Lez.a(paramInt, paramString);
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_Lez.a(paramString);
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
        lig.a(this.f, this.g);
      }
      return;
      this.g = true;
    }
    a().postDelayed(new VideoAppInterface.3(this), 3000L);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Lez.b();
  }
  
  public boolean b(String paramString)
  {
    return this.jdField_a_of_type_Lez.b(paramString);
  }
  
  public boolean b(lwm paramlwm)
  {
    return this.jdField_a_of_type_Lez.b(paramlwm);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Lez.c();
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_Lgq.a(paramInt);
  }
  
  public void c(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Lez.b(paramInt, paramString);
  }
  
  public void c(String paramString)
  {
    this.jdField_a_of_type_Lez.b(paramString);
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Lez.c();
  }
  
  public boolean c(String paramString)
  {
    return this.jdField_a_of_type_Lez.c(paramString);
  }
  
  public void d()
  {
    this.jdField_a_of_type_Lez.d();
  }
  
  public void d(String paramString)
  {
    this.jdField_a_of_type_Lez.c(paramString);
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_Lez.d();
  }
  
  public void e()
  {
    a().b();
    m();
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_Lez.e();
  }
  
  public boolean f()
  {
    return this.jdField_a_of_type_Lez.f();
  }
  
  public boolean g()
  {
    return this.jdField_a_of_type_Lez.g();
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
    return this.jdField_a_of_type_Lez.b(paramInt, paramString1, paramString2);
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
    return new Class[] { ldc.class };
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
    return this.jdField_a_of_type_Lez.h();
  }
  
  public boolean i()
  {
    return this.jdField_a_of_type_Lez.i();
  }
  
  public boolean j()
  {
    return this.jdField_a_of_type_Lez.j();
  }
  
  public boolean k()
  {
    return this.jdField_a_of_type_Lez.k();
  }
  
  public boolean l()
  {
    return this.jdField_a_of_type_Lez.a();
  }
  
  public boolean m()
  {
    lov locallov = a();
    if (locallov.a("BEAUTY_SKIN") != 0) {
      return true;
    }
    return locallov.b();
  }
  
  public void onCallback(String paramString)
  {
    lik locallik = (lik)a(4);
    if (locallik != null)
    {
      locallik.a(paramString);
      locallik.a(36, 1L);
      locallik.a(29, 1L);
      locallik.b();
      lii.a(16, 1L);
      lii.c();
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
    lii.a(this);
    lii.a();
    lii.a(27);
    if (!bapt.a()) {
      bapt.a(BaseApplicationImpl.getContext(), this);
    }
    long l1 = System.currentTimeMillis();
    super.onCreate(paramBundle);
    k();
    AudioHelper.a(this.app, getLongAccountUin());
    AudioHelper.a(BaseApplication.getContext());
    AudioHelper.b("VideoAppInterface.onCreate.begin1");
    i();
    getEntityManagerFactory(null);
    this.jdField_a_of_type_Leu = new leu(this);
    AppNetConnInfo.registerConnectionChangeReceiver(getApplication(), this.jdField_a_of_type_Leu);
    this.jdField_a_of_type_Lft = new lft(this);
    this.jdField_a_of_type_Lgj = new lgj();
    this.jdField_a_of_type_Lgj.a(this.jdField_a_of_type_Lft);
    this.jdField_a_of_type_Lgq = new lgq(this);
    this.jdField_a_of_type_Lgr = new lgr(this);
    h();
    this.jdField_a_of_type_ComTencentAvAppDeviceCapabilityExamination = new DeviceCapabilityExamination(this);
    this.jdField_a_of_type_Lec = new lec(this);
    this.jdField_a_of_type_Ldy = new ldy(this);
    this.jdField_a_of_type_Lej = new lej(this);
    this.jdField_a_of_type_Leq = new leq(this);
    this.jdField_a_of_type_Lea = new lea(this);
    this.jdField_a_of_type_Lef = new lef(this);
    this.jdField_a_of_type_Len = new len(this);
    this.jdField_a_of_type_Lel = new lel(this);
    this.jdField_a_of_type_Leh = new leh(this);
    this.jdField_a_of_type_Lcz = new lcz(this);
    this.jdField_a_of_type_Lda = new lda(this);
    this.jdField_a_of_type_Lew = new lew(this);
    this.jdField_a_of_type_Lez = new lez(this);
    this.jdField_a_of_type_Lez.a();
    this.jdField_a_of_type_Lez.c();
    this.jdField_a_of_type_Ldf = new ldf(this);
    this.jdField_a_of_type_Ldf.a();
    this.jdField_a_of_type_Lkf = new lkf(this);
    this.jdField_a_of_type_Mxk = new mxk(this);
    lvy.a().a();
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
    this.jdField_a_of_type_Ldf.b();
    this.jdField_a_of_type_Lez.b();
    this.jdField_a_of_type_Lez.d();
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory.onDestroy();
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory = null;
      PtvTemplateManager.a();
      AVRedPacketManager.b();
      this.jdField_a_of_type_Len.b();
      this.jdField_a_of_type_Lel.a();
      this.jdField_a_of_type_Lec.a();
      this.jdField_a_of_type_Ldy.a();
      this.jdField_a_of_type_Lej.b();
      this.jdField_a_of_type_Leq.b();
      this.jdField_a_of_type_Lea.b();
      this.jdField_a_of_type_Lef.b();
      this.jdField_a_of_type_Leh.b();
      this.jdField_a_of_type_Lew.b();
      lfu.a(getApp());
      lii.b();
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
  
  public void onSDKInited(boolean paramBoolean)
  {
    jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(paramBoolean);
    QLog.w(jdField_a_of_type_JavaLangString, 1, "onSDKInited result:=" + paramBoolean);
  }
  
  public void removeObserver(BusinessObserver paramBusinessObserver)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramBusinessObserver);
  }
  
  public void sendToService(ToServiceMsg paramToServiceMsg)
  {
    lbd.f(jdField_a_of_type_JavaLangString, "sendToService");
    this.jdField_a_of_type_Lft.a(paramToServiceMsg, null, ldc.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.app.VideoAppInterface
 * JD-Core Version:    0.7.0.1
 */
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
import anud;
import anui;
import bbaz;
import bcwa;
import bdll;
import bdmk;
import beuo;
import bevk;
import com.tencent.av.HardWareCodecSSO.ConfigReq;
import com.tencent.av.VideoController;
import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.av.report.AVReport;
import com.tencent.av.video.call.ClientLogReport;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mfsdk.reporter.ReporterMachine;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.redtouch.RedAppInfo;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.startup.step.AVSoUtils;
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
import lbj;
import lda;
import ldb;
import ldd;
import ldg;
import ldz;
import leb;
import led;
import leg;
import lei;
import lek;
import lem;
import leo;
import ler;
import lev;
import lew;
import lex;
import lfa;
import lff;
import lfj;
import lfk;
import lfn;
import lfo;
import lgd;
import lgj;
import lgk;
import lgl;
import lia;
import lic;
import lie;
import ljz;
import llk;
import lpa;
import lwo;
import lzq;
import mci;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mtn;

public class VideoAppInterface
  extends AppInterface
  implements bdmk, lew
{
  private static String jdField_a_of_type_JavaLangString = "VideoAppInterface";
  protected int a;
  protected Handler a;
  private bevk jdField_a_of_type_Bevk;
  public VideoController a;
  protected DeviceCapabilityExamination a;
  private EntityManagerFactory jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  protected List<anui> a;
  private lda jdField_a_of_type_Lda;
  private ldb jdField_a_of_type_Ldb;
  ldg jdField_a_of_type_Ldg;
  ldz jdField_a_of_type_Ldz;
  leb jdField_a_of_type_Leb;
  led jdField_a_of_type_Led;
  leg jdField_a_of_type_Leg;
  lei jdField_a_of_type_Lei;
  lek jdField_a_of_type_Lek;
  lem jdField_a_of_type_Lem;
  leo jdField_a_of_type_Leo;
  ler jdField_a_of_type_Ler;
  lev jdField_a_of_type_Lev;
  private lex jdField_a_of_type_Lex;
  lfa jdField_a_of_type_Lfa;
  lfk jdField_a_of_type_Lfk = null;
  private lfn jdField_a_of_type_Lfn;
  private lgd jdField_a_of_type_Lgd;
  public lgk a;
  protected lgl a;
  ljz jdField_a_of_type_Ljz;
  private final lpa jdField_a_of_type_Lpa = new lpa();
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
    this.jdField_a_of_type_Ldz.b();
    this.jdField_a_of_type_Led.b();
    this.jdField_a_of_type_Lek.a();
    this.jdField_a_of_type_Ler.a();
    this.jdField_a_of_type_Leb.a();
    this.jdField_a_of_type_Leg.a();
    this.jdField_a_of_type_Leo.a();
    this.jdField_a_of_type_Lem.b();
    this.jdField_a_of_type_Lei.a();
    this.jdField_a_of_type_Lex.a();
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
    getApp().registerReceiver(new lfj(this), localIntentFilter);
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
    return this.jdField_a_of_type_Lfa.a(paramInt, paramString);
  }
  
  public int a(String paramString)
  {
    return this.jdField_a_of_type_Lfa.a(paramString);
  }
  
  public long a(String paramString)
  {
    return this.jdField_a_of_type_Lfa.a(paramString);
  }
  
  public Bitmap a(int paramInt, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    return this.jdField_a_of_type_Lfa.a(paramInt, paramString1, paramString2, paramBoolean1, paramBoolean2);
  }
  
  public Bundle a(int paramInt1, int paramInt2, int paramInt3, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    return this.jdField_a_of_type_Lfa.a(paramInt1, paramInt2, paramInt3, paramBundle, paramResultReceiver);
  }
  
  public Handler a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    }
    return this.jdField_a_of_type_AndroidOsHandler;
  }
  
  public anud a(int paramInt)
  {
    return this.jdField_a_of_type_Lgd.a(this, paramInt);
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
  
  public BusinessInfoCheckUpdate.AppInfo a(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("red_touch_app_id", paramString);
    paramString = a(7, 0, 0, localBundle, null);
    if (paramString == null) {
      return null;
    }
    paramString.setClassLoader(RedAppInfo.class.getClassLoader());
    return bbaz.a((RedAppInfo)paramString.getParcelable("red_touch_red_app_info"));
  }
  
  public String a()
  {
    String str2 = getApp().getString(2131719237);
    Object localObject = a();
    String str1 = str2;
    if (localObject != null)
    {
      String str3 = ((VideoController)localObject).a().d;
      int i = ((VideoController)localObject).a().j;
      localObject = ((VideoController)localObject).a().f;
      str1 = str2;
      if (i == 9500) {
        str1 = getDisplayName(i, str3, (String)localObject) + getApp().getString(2131719239);
      }
    }
    return str1;
  }
  
  public String a(String paramString)
  {
    return this.jdField_a_of_type_Lfa.b(paramString);
  }
  
  public Map<String, Integer> a()
  {
    try
    {
      Map localMap = this.jdField_a_of_type_Lei.a();
      return localMap;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public lda a()
  {
    return this.jdField_a_of_type_Lda;
  }
  
  public ldb a()
  {
    return this.jdField_a_of_type_Ldb;
  }
  
  public lfk a()
  {
    if (this.jdField_a_of_type_Lfk == null) {
      this.jdField_a_of_type_Lfk = new lfk(this);
    }
    return this.jdField_a_of_type_Lfk;
  }
  
  public lgj a(int paramInt)
  {
    return this.jdField_a_of_type_Lgk.a(paramInt);
  }
  
  public ljz a()
  {
    return this.jdField_a_of_type_Ljz;
  }
  
  public lpa a()
  {
    if (this.h) {
      return this.jdField_a_of_type_Lpa;
    }
    synchronized (this.jdField_a_of_type_Lpa)
    {
      String str;
      if (!this.h)
      {
        str = mci.a(getCurrentAccountUin());
        if (!TextUtils.isEmpty(str)) {
          break label133;
        }
        int j = mci.a(getCurrentAccountUin());
        i = j;
        if (j != -1)
        {
          this.jdField_a_of_type_Lpa.a("BEAUTY_SKIN", j);
          i = j;
        }
        this.h = true;
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "getBeautyConfig config[" + str + "], level[" + i + "]");
        }
      }
      return this.jdField_a_of_type_Lpa;
      label133:
      this.jdField_a_of_type_Lpa.a(str);
      int i = -1;
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getVideoConfigUpdate");
    }
    NewIntent localNewIntent = new NewIntent(this.app, bcwa.class);
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
    this.jdField_a_of_type_Lgk.a(paramInt, paramString);
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Lfa.a(paramInt, paramString1, paramString2);
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Lfa.a(paramLong);
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
        QLog.w(jdField_a_of_type_JavaLangString, 1, "video exit, mIsExit[" + this.e + "], reason[" + i + "], _reason[" + paramInt + "], mManagerFactory[" + this.jdField_a_of_type_Lgk + "], seq[" + paramLong + "]", new Throwable("打印调用栈"));
        this.e = true;
        Object localObject;
        if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a() != null))
        {
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().H) {
            bdll.b(null, "CliOper", "", "", "0X8008AAD", "0X8008AAD", 0, 0, "", "", "", "");
          }
        }
        else
        {
          if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvVideoController != null)) {
            this.jdField_a_of_type_ComTencentAvVideoController.C();
          }
          this.jdField_b_of_type_Boolean = false;
          lzq.a(paramLong, 1, getApplication());
          lbj.d(jdField_a_of_type_JavaLangString, "exit video process clearNotification");
          QQNotificationManager.getInstance().cancel(jdField_a_of_type_JavaLangString, 235);
          localObject = (AudioManager)getApplication().getApplicationContext().getSystemService("audio");
          if (localObject == null) {}
        }
        try
        {
          ((AudioManager)localObject).setSpeakerphoneOn(this.jdField_a_of_type_Boolean);
          ((AudioManager)localObject).setMode(this.jdField_a_of_type_Int);
          localObject = mtn.a(this);
          if (localObject != null) {
            ((mtn)localObject).a();
          }
          lbj.d(jdField_a_of_type_JavaLangString, "force exit video process ...");
          QLog.flushLog();
          if (this.jdField_a_of_type_Lda != null)
          {
            if (this.jdField_a_of_type_Lda.a()) {
              this.jdField_a_of_type_Lda.a(bool);
            }
            if (this.jdField_a_of_type_Lda.c()) {
              this.jdField_a_of_type_ComTencentAvVideoController.p(false);
            }
            if (this.jdField_a_of_type_Lda.b()) {
              this.jdField_a_of_type_ComTencentAvVideoController.n(false);
            }
          }
          return;
          bool = false;
          continue;
          bdll.b(null, "CliOper", "", "", "0X8008AAC", "0X8008AAC", 0, 0, "", "", "", "");
        }
        catch (NullPointerException localNullPointerException)
        {
          for (;;)
          {
            lbj.d(jdField_a_of_type_JavaLangString, "VideoAppInterface.exit() -> am.setSpeakerphoneOn() catch NullPointerException !");
          }
        }
      }
    }
  }
  
  public void a(long paramLong1, String paramString, long paramLong2)
  {
    this.jdField_a_of_type_Lfa.a(paramLong1, paramString, paramLong2);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 2, "receiveToService");
    this.jdField_a_of_type_Lfn.a(paramFromServiceMsg.isSuccess(), paramToServiceMsg, paramFromServiceMsg, null);
  }
  
  public void a(String paramString)
  {
    lie locallie = (lie)a(4);
    if (locallie != null)
    {
      locallie.a(paramString);
      locallie.a(36, 1L);
      locallie.a(29, 1L);
      locallie.b();
      lic.a(16, 1L);
      lic.c();
    }
    onDestroy();
  }
  
  public void a(String paramString, int paramInt)
  {
    try
    {
      this.jdField_a_of_type_Lei.a(paramString, paramInt);
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
      if ((this.jdField_a_of_type_Lfa != null) && (this.jdField_a_of_type_Lfa.a != null)) {
        paramObserver.update(a(), new Object[] { Integer.valueOf(10) });
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Lfa != null) {
      this.jdField_a_of_type_Lfa.a(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, Notification paramNotification)
  {
    this.jdField_a_of_type_Ldg.a(paramBoolean, paramNotification);
  }
  
  public void a(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length > 0)) {
      a().a(paramArrayOfObject);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Ldg.a();
  }
  
  public boolean a(int paramInt)
  {
    return this.jdField_a_of_type_Lgk.a(paramInt);
  }
  
  public boolean a(int paramInt, long paramLong)
  {
    return this.jdField_a_of_type_Lfa.a(paramInt, paramLong);
  }
  
  public boolean a(long paramLong)
  {
    return this.jdField_a_of_type_Lfa.a(paramLong);
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_Lfa.a(paramString);
  }
  
  public boolean a(String paramString, int paramInt)
  {
    return this.jdField_a_of_type_Lfa.a(paramString, paramInt);
  }
  
  public boolean a(lwo paramlwo)
  {
    return this.jdField_a_of_type_Lfa.a(paramlwo);
  }
  
  public long[] a(String paramString)
  {
    return this.jdField_a_of_type_Lfa.a(paramString);
  }
  
  public void addObserver(anui paramanui)
  {
    addObserver(paramanui, false);
  }
  
  public void addObserver(anui paramanui, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_JavaUtilList.contains(paramanui)) {
      this.jdField_a_of_type_JavaUtilList.add(paramanui);
    }
  }
  
  public int b(String paramString)
  {
    return a().a(paramString);
  }
  
  public String b()
  {
    return this.jdField_a_of_type_Lfa.a();
  }
  
  public String b(String paramString)
  {
    return this.jdField_a_of_type_Lfa.c(paramString);
  }
  
  public void b()
  {
    HardWareCodecSSO.ConfigReq localConfigReq = new HardWareCodecSSO.ConfigReq();
    localConfigReq.app_id.set(0);
    localConfigReq.app_ver.set("8.4.5");
    localConfigReq.mobile.set(Build.MODEL);
    localConfigReq.chip.set(Build.HARDWARE + "_" + llk.a());
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
    Object localObject = new NewIntent(this.app, ldd.class);
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
          this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.c, this.jdField_a_of_type_ComTencentAvVideoController.a, 72);
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
    this.jdField_a_of_type_Lfa.a(paramInt, paramString);
  }
  
  public void b(String paramString)
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
        lia.a(this.f, this.g);
      }
      return;
      this.g = true;
    }
    a().postDelayed(new VideoAppInterface.3(this), 3000L);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Lfa.b();
  }
  
  public boolean b(String paramString)
  {
    return this.jdField_a_of_type_Lfa.b(paramString);
  }
  
  public boolean b(lwo paramlwo)
  {
    return this.jdField_a_of_type_Lfa.b(paramlwo);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Lfa.c();
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_Lgk.a(paramInt);
  }
  
  public void c(int paramInt, String paramString)
  {
    this.jdField_a_of_type_Lfa.b(paramInt, paramString);
  }
  
  public void c(String paramString)
  {
    this.jdField_a_of_type_Lfa.a(paramString);
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_Lfa.c();
  }
  
  public boolean c(String paramString)
  {
    return this.jdField_a_of_type_Lfa.c(paramString);
  }
  
  public void d()
  {
    this.jdField_a_of_type_Lfa.d();
  }
  
  public void d(String paramString)
  {
    this.jdField_a_of_type_Lfa.b(paramString);
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_Lfa.d();
  }
  
  public void e()
  {
    a().b();
    m();
  }
  
  public void e(String paramString)
  {
    this.jdField_a_of_type_Lfa.c(paramString);
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_Lfa.e();
  }
  
  public boolean f()
  {
    return this.jdField_a_of_type_Lfa.f();
  }
  
  public boolean g()
  {
    return this.jdField_a_of_type_Lfa.g();
  }
  
  public BaseApplication getApp()
  {
    return this.app;
  }
  
  public int getAppid()
  {
    return AppSetting.a();
  }
  
  public List<anui> getBusinessObserver(int paramInt)
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
    return this.jdField_a_of_type_Lfa.b(paramInt, paramString1, paramString2);
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
    return new Class[] { ldd.class };
  }
  
  public beuo getNetEngine(int paramInt)
  {
    if (this.jdField_a_of_type_Bevk == null) {
      this.jdField_a_of_type_Bevk = new bevk();
    }
    return this.jdField_a_of_type_Bevk.a(this, paramInt);
  }
  
  public boolean h()
  {
    return this.jdField_a_of_type_Lfa.h();
  }
  
  public boolean i()
  {
    return this.jdField_a_of_type_Lfa.i();
  }
  
  public boolean j()
  {
    return this.jdField_a_of_type_Lfa.a();
  }
  
  public boolean k()
  {
    lpa locallpa = a();
    if (locallpa.a("BEAUTY_SKIN") != 0) {
      return true;
    }
    return locallpa.b();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (AudioHelper.e()) {
      QLog.setUIN_REPORTLOG_LEVEL(4);
    }
    AudioHelper.b("VideoAppInterface.onCreate.begin");
    AVSoUtils.a(-1045L);
    this.c = true;
    lic.a(this);
    lic.a();
    lic.a(27);
    long l1 = System.currentTimeMillis();
    super.onCreate(paramBundle);
    k();
    AudioHelper.a(this.app, getLongAccountUin());
    AudioHelper.a(BaseApplication.getContext());
    AudioHelper.b("VideoAppInterface.onCreate.begin1");
    i();
    getEntityManagerFactory(null);
    this.jdField_a_of_type_Lev = new lev(this);
    AppNetConnInfo.registerConnectionChangeReceiver(getApplication(), this.jdField_a_of_type_Lev);
    this.jdField_a_of_type_Lfn = new lfn(this);
    this.jdField_a_of_type_Lgd = new lgd();
    this.jdField_a_of_type_Lgd.a(this.jdField_a_of_type_Lfn);
    this.jdField_a_of_type_Lgk = new lgk(this);
    this.jdField_a_of_type_Lgl = new lgl(this);
    h();
    this.jdField_a_of_type_ComTencentAvAppDeviceCapabilityExamination = new DeviceCapabilityExamination(this);
    this.jdField_a_of_type_Led = new led(this);
    this.jdField_a_of_type_Ldz = new ldz(this);
    this.jdField_a_of_type_Lek = new lek(this);
    this.jdField_a_of_type_Ler = new ler(this);
    this.jdField_a_of_type_Leb = new leb(this);
    this.jdField_a_of_type_Leg = new leg(this);
    this.jdField_a_of_type_Leo = new leo(this);
    this.jdField_a_of_type_Lem = new lem(this);
    this.jdField_a_of_type_Lei = new lei(this);
    this.jdField_a_of_type_Lda = new lda(this);
    this.jdField_a_of_type_Ldb = new ldb(this);
    this.jdField_a_of_type_Lex = new lex(this);
    this.jdField_a_of_type_Lfa = new lfa(this);
    this.jdField_a_of_type_Lfa.a();
    this.jdField_a_of_type_Lfa.c();
    this.jdField_a_of_type_Ldg = new ldg(this);
    this.jdField_a_of_type_Ldg.a();
    this.jdField_a_of_type_Ljz = new ljz(this);
    AVReport.a().a();
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
    this.jdField_a_of_type_Ldg.b();
    this.jdField_a_of_type_Lfa.b();
    this.jdField_a_of_type_Lfa.d();
    if (this.jdField_a_of_type_Bevk != null) {}
    try
    {
      this.jdField_a_of_type_Bevk.onDestroy();
      this.jdField_a_of_type_Bevk = null;
      PtvTemplateManager.a();
      AVRedPacketManager.b();
      this.jdField_a_of_type_Leo.b();
      this.jdField_a_of_type_Lem.a();
      this.jdField_a_of_type_Led.a();
      this.jdField_a_of_type_Ldz.a();
      this.jdField_a_of_type_Lek.b();
      this.jdField_a_of_type_Ler.b();
      this.jdField_a_of_type_Leb.b();
      this.jdField_a_of_type_Leg.b();
      this.jdField_a_of_type_Lei.b();
      this.jdField_a_of_type_Lex.b();
      lfo.a(getApp());
      lic.b();
      super.onDestroy();
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.jdField_a_of_type_Bevk.onDestroy();
      }
    }
  }
  
  public void removeObserver(anui paramanui)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramanui);
  }
  
  public void sendToService(ToServiceMsg paramToServiceMsg)
  {
    lbj.c(jdField_a_of_type_JavaLangString, "sendToService");
    this.jdField_a_of_type_Lfn.a(paramToServiceMsg, null, ldd.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.app.VideoAppInterface
 * JD-Core Version:    0.7.0.1
 */
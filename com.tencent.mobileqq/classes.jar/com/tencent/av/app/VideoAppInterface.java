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
import com.tencent.av.AVLog;
import com.tencent.av.HardWareCodecSSO.ConfigReq;
import com.tencent.av.QavEngineAssistant;
import com.tencent.av.VideoController;
import com.tencent.av.VideoProcessExitMonitor;
import com.tencent.av.VideoRecoveryMonitor;
import com.tencent.av.VideoServlet;
import com.tencent.av.business.MsfServletProxy;
import com.tencent.av.business.config.ConfigManager;
import com.tencent.av.business.handler.BusinessHandlerFactory;
import com.tencent.av.business.manager.BusinessManager;
import com.tencent.av.business.manager.BusinessManagerFactory;
import com.tencent.av.business.manager.BusinessMessageCenter;
import com.tencent.av.business.manager.report.VideoBeaconReporter;
import com.tencent.av.business.manager.report.VideoNodeManager;
import com.tencent.av.business.manager.report.VideoNodeReporter;
import com.tencent.av.chatroom.ChatRoomMng;
import com.tencent.av.core.VcSystemInfo;
import com.tencent.av.opengl.effects.BeautyConfig;
import com.tencent.av.report.AVReport;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.ui.BeautyConfigUtil;
import com.tencent.av.ui.avatar.AvatarParam;
import com.tencent.av.utils.AVSoUtils;
import com.tencent.av.utils.AudioHelper;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.video.call.ClientLogReport;
import com.tencent.av.wtogether.WTogetherRealNameVideoProcessHelper;
import com.tencent.common.app.business.BaseVideoAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.redtouch.RedAppInfo;
import com.tencent.mobileqq.redtouch.RedTouchUtils;
import com.tencent.mobileqq.servlet.VideoConfigServlet;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.MagnifierSDK;
import com.tencent.qqperf.monitor.crash.QQCrashCallback;
import com.tencent.qqperf.repoter.ReporterMachine;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observer;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

public class VideoAppInterface
  extends BaseVideoAppInterface
  implements MSFNetInfoMonitor.IApnChangeListener, SDKInitListener, QQCrashCallback
{
  private static String D = "VideoAppInterface";
  public static Boolean a;
  VideoNotifyCenter A = null;
  public boolean B = false;
  public boolean C = false;
  private EntityManagerFactory E = null;
  private MsfServletProxy F;
  private BusinessHandlerFactory G;
  private VideoProcessExitMonitor H;
  private VideoRecoveryMonitor I;
  private QAVNotifyActionMonitor J;
  private boolean K = false;
  private final BeautyConfig L = new BeautyConfig();
  private Runnable M = null;
  private Runnable N = new VideoAppInterface.2(this);
  protected Handler b = null;
  protected VideoController c;
  protected DeviceCapabilityExamination d;
  protected BusinessManagerFactory e;
  protected BusinessMessageCenter f;
  protected boolean g = false;
  protected int h = 1;
  public boolean i = false;
  public boolean j = false;
  GMemoryMonitor k;
  GScreenActionMonitor l;
  GAudioMessageMonitor m;
  GAccountMonitor n;
  GKillProcessMonitor o;
  GVipFunCallMonitor p;
  GAudioExitMonitor q;
  GBatteryMonitor r;
  GCameraAvailabilityMonitor s;
  MSFNetInfoMonitor t;
  ChatRoomMng u;
  WTogetherRealNameVideoProcessHelper v;
  QQServiceProxy w;
  AVServiceProxy x;
  public long y = 0L;
  public boolean z = false;
  
  public VideoAppInterface(MobileQQ paramMobileQQ, String paramString)
  {
    super(paramMobileQQ, paramString);
  }
  
  private void D()
  {
    AudioManager localAudioManager = (AudioManager)getApplication().getApplicationContext().getSystemService("audio");
    if (localAudioManager != null)
    {
      this.g = localAudioManager.isSpeakerphoneOn();
      this.h = localAudioManager.getMode();
    }
  }
  
  private void E()
  {
    this.n.b();
    this.m.b();
    this.o.a();
    this.p.a();
    this.q.a();
    this.r.a();
    this.l.a();
    this.k.b();
    this.s.b();
    this.J.a();
  }
  
  private void F()
  {
    VideoController localVideoController = this.c;
    if (localVideoController == null) {
      b();
    } else {
      localVideoController.a(this);
    }
    AudioHelper.b("VideoAppInterface.onCreate.end");
  }
  
  private void G()
  {
    try
    {
      PowerManager localPowerManager = (PowerManager)getApp().getSystemService("power");
      if (!localPowerManager.isScreenOn())
      {
        localPowerManager.newWakeLock(1, "mobileqq:videoapp").acquire(10000L);
        return;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void H()
  {
    ThreadManager.post(this.N, 10, null, true);
  }
  
  private void I()
  {
    if ((AudioHelper.a()) && (AudioHelper.a(13) == 1))
    {
      QLog.d(D, 1, "onCreate, 音视频进程在等待调试器连接(界面会无响应)");
      Debug.waitForDebugger();
    }
  }
  
  private void J()
  {
    QLog.d(D, 2, "registerExitProcessReceiver");
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.av.exit_process");
    getApp().registerReceiver(new VideoAppInterface.4(this), localIntentFilter);
  }
  
  private void K()
  {
    if (this.M == null) {
      this.M = new VideoAppInterface.5(this);
    } else {
      a().removeCallbacks(this.M);
    }
    a().postDelayed(this.M, 5000L);
  }
  
  public ChatRoomMng A()
  {
    return this.u;
  }
  
  public WTogetherRealNameVideoProcessHelper B()
  {
    return this.v;
  }
  
  public Bitmap a(int paramInt, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    return this.w.a(paramInt, paramString1, paramString2, paramBoolean1, paramBoolean2);
  }
  
  public Bundle a(int paramInt1, int paramInt2, int paramInt3, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    return this.w.a(paramInt1, paramInt2, paramInt3, paramBundle, paramResultReceiver);
  }
  
  public Handler a()
  {
    if (this.b == null) {
      this.b = new Handler(Looper.getMainLooper());
    }
    return this.b;
  }
  
  public String a(int paramInt, String paramString1, String paramString2)
  {
    return this.w.b(paramInt, paramString1, paramString2);
  }
  
  public String a(AvatarParam paramAvatarParam, int paramInt)
  {
    return this.w.a(paramAvatarParam, paramInt);
  }
  
  public void a(int paramInt)
  {
    VideoController localVideoController = b();
    if (localVideoController != null) {
      localVideoController.a(paramInt);
    }
  }
  
  public void a(int paramInt, String paramString)
  {
    this.e.a(paramInt, paramString);
  }
  
  public void a(long paramLong, int paramInt)
  {
    int i1;
    if (paramInt < 200) {
      i1 = paramInt + 200;
    } else {
      i1 = paramInt;
    }
    boolean bool;
    if (i1 == 261) {
      bool = true;
    } else {
      bool = false;
    }
    Object localObject = D;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("video exit, mIsExit[");
    localStringBuilder.append(this.z);
    localStringBuilder.append("], reason[");
    localStringBuilder.append(i1);
    localStringBuilder.append("], _reason[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], mManagerFactory[");
    localStringBuilder.append(this.e);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString(), new Throwable("打印调用栈"));
    this.z = true;
    localObject = this.c;
    if ((localObject != null) && (((VideoController)localObject).k() != null)) {
      if (this.c.k().cJ) {
        ReportController.b(null, "CliOper", "", "", "0X8008AAD", "0X8008AAD", 0, 0, "", "", "", "");
      } else {
        ReportController.b(null, "CliOper", "", "", "0X8008AAC", "0X8008AAC", 0, 0, "", "", "", "");
      }
    }
    SmallScreenUtils.a(paramLong, 1, getApplication());
    AVLog.printAllUserLog(D, "exit video process clearNotification");
    QQNotificationManager.getInstance().cancel(D, 235);
    localObject = (AudioManager)getApplication().getApplicationContext().getSystemService("audio");
    if (localObject != null) {}
    try
    {
      ((AudioManager)localObject).setSpeakerphoneOn(this.g);
    }
    catch (NullPointerException localNullPointerException)
    {
      label338:
      break label338;
    }
    AVLog.printAllUserLog(D, "VideoAppInterface.exit() -> am.setSpeakerphoneOn() catch NullPointerException !");
    ((AudioManager)localObject).setMode(this.h);
    localObject = QAVNotification.a(this);
    if (localObject != null) {
      ((QAVNotification)localObject).b();
    }
    AVLog.printAllUserLog(D, "force exit video process ...");
    QLog.flushLog();
    localObject = this.H;
    if (localObject != null)
    {
      if (((VideoProcessExitMonitor)localObject).b()) {
        this.H.a(bool);
      }
      if (this.H.d()) {
        this.c.t(false);
      }
      if (this.H.c()) {
        this.c.r(false);
      }
    }
  }
  
  public void a(long paramLong1, String paramString, long paramLong2)
  {
    this.w.a(paramLong1, paramString, paramLong2);
  }
  
  public void a(String paramString)
  {
    VideoNodeReporter localVideoNodeReporter = (VideoNodeReporter)c(4);
    if (localVideoNodeReporter != null)
    {
      localVideoNodeReporter.b(paramString);
      localVideoNodeReporter.a(36, 1L);
      localVideoNodeReporter.a(29, 1L);
      localVideoNodeReporter.b();
      VideoNodeManager.a(16, 1L);
      VideoNodeManager.e();
    }
    onDestroy();
  }
  
  public void a(String paramString, int paramInt)
  {
    try
    {
      this.s.a(paramString, paramInt);
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
    x().a(paramString, paramInt);
    if (paramBoolean)
    {
      K();
      if (QLog.isDevelopLevel())
      {
        String str = D;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("setBeautyValue name[");
        localStringBuilder.append(paramString);
        localStringBuilder.append("], value[");
        localStringBuilder.append(paramInt);
        localStringBuilder.append("]");
        QLog.i(str, 4, localStringBuilder.toString());
      }
    }
  }
  
  public void a(Observer paramObserver)
  {
    if (paramObserver != null)
    {
      e().addObserver(paramObserver);
      QQServiceProxy localQQServiceProxy = this.w;
      if ((localQQServiceProxy != null) && (localQQServiceProxy.c != null)) {
        paramObserver.update(e(), new Object[] { Integer.valueOf(10) });
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    QQServiceProxy localQQServiceProxy = this.w;
    if (localQQServiceProxy != null) {
      localQQServiceProxy.a(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, Notification paramNotification)
  {
    this.x.a(paramBoolean, paramNotification);
  }
  
  public void a(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length > 0)) {
      e().a(paramArrayOfObject);
    }
  }
  
  public boolean a(int paramInt, long paramLong)
  {
    return this.w.a(paramInt, paramLong);
  }
  
  public boolean a(long paramLong)
  {
    return this.w.a(paramLong);
  }
  
  public VideoController b()
  {
    if (this.c == null)
    {
      this.c = VideoController.f();
      this.c.a(this);
    }
    return this.c;
  }
  
  public void b(int paramInt)
  {
    long l1 = AudioHelper.c();
    String str = D;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("exitVideoProcess, reason[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], videoController[");
    localStringBuilder.append(this.c);
    localStringBuilder.append("], reason[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l1);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    int i1;
    switch (paramInt)
    {
    default: 
      i1 = 260;
      break;
    case 1005: 
      i1 = 258;
      break;
    case 1004: 
      i1 = 259;
      break;
    case 1003: 
      i1 = 256;
      break;
    case 1002: 
      i1 = 257;
      break;
    case 1001: 
      i1 = 255;
      break;
    case 1000: 
      i1 = 254;
    }
    try
    {
      if (this.c != null)
      {
        int i2 = this.c.k().i;
        if ((i2 > 0) && (i2 <= 4))
        {
          str = this.c.k().s;
          this.c.a(str, i1);
          this.c.b(i1);
          this.c.b(str, 0);
        }
        else if (this.c.j)
        {
          this.c.a(this.c.l, this.c.k, 72);
        }
        this.c.aa = false;
        a(l1, paramInt);
        return;
      }
      QLog.d(D, 1, "exitVideoProcess System.exit ");
      QLog.flushLog();
      return;
    }
    catch (Exception localException)
    {
      label327:
      break label327;
    }
    QLog.d(D, 1, "exitVideoProcess Exception System.exit ");
    QLog.flushLog();
  }
  
  public void b(int paramInt, String paramString)
  {
    this.w.a(paramInt, paramString);
  }
  
  public void b(int paramInt, String paramString1, String paramString2)
  {
    this.w.c(paramInt, paramString1, paramString2);
  }
  
  public void b(long paramLong)
  {
    this.w.b(paramLong);
  }
  
  public void b(String paramString)
  {
    Object localObject1 = getApplication().refreAccountList();
    if (localObject1 != null)
    {
      Object localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject1 = (SimpleAccount)((Iterator)localObject2).next();
        if (paramString.equals(((SimpleAccount)localObject1).getUin()))
        {
          if (QLog.isColorLevel())
          {
            localObject2 = D;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Switch Account: ");
            localStringBuilder.append(paramString);
            QLog.d((String)localObject2, 2, localStringBuilder.toString());
          }
          switchAccount((SimpleAccount)localObject1, null);
          localObject1 = this.c;
          if (localObject1 != null) {
            ((VideoController)localObject1).e(paramString);
          }
          this.c = null;
        }
      }
    }
  }
  
  public void b(Observer paramObserver)
  {
    e().deleteObserver(paramObserver);
  }
  
  public void b(boolean paramBoolean)
  {
    String str = D;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reportQuaProcessWakeUp() isBroadcastCreated = ");
    localStringBuilder.append(paramBoolean);
    QLog.d(str, 1, localStringBuilder.toString());
    if (paramBoolean) {
      this.B = true;
    } else {
      this.C = true;
    }
    paramBoolean = this.B;
    if (paramBoolean)
    {
      boolean bool = this.C;
      if (bool)
      {
        VideoBeaconReporter.a(paramBoolean, bool);
        return;
      }
      a().postDelayed(new VideoAppInterface.3(this), 3000L);
    }
  }
  
  public VideoProcessExitMonitor c()
  {
    return this.H;
  }
  
  public BusinessManager c(int paramInt)
  {
    return this.e.a(paramInt);
  }
  
  public void c(int paramInt, String paramString)
  {
    this.w.b(paramInt, paramString);
  }
  
  public boolean c(String paramString)
  {
    return this.w.a(paramString);
  }
  
  public int d(int paramInt, String paramString)
  {
    return this.w.c(paramInt, paramString);
  }
  
  public VideoRecoveryMonitor d()
  {
    return this.I;
  }
  
  public String d(String paramString)
  {
    return this.w.d(paramString);
  }
  
  public boolean d(int paramInt)
  {
    return this.e.b(paramInt);
  }
  
  VideoNotifyCenter e()
  {
    if (this.A == null) {
      this.A = new VideoNotifyCenter(this);
    }
    return this.A;
  }
  
  public void e(int paramInt)
  {
    this.e.c(paramInt);
  }
  
  public void e(String paramString)
  {
    this.w.e(paramString);
  }
  
  public int f()
  {
    return e().countObservers();
  }
  
  public long f(String paramString)
  {
    return this.w.f(paramString);
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d(D, 2, "getVideoConfigUpdate");
    }
    NewIntent localNewIntent = new NewIntent(this.app, VideoConfigServlet.class);
    localNewIntent.putExtra("reqType", 11);
    startServlet(localNewIntent);
  }
  
  public long[] g(String paramString)
  {
    return this.w.g(paramString);
  }
  
  public BaseApplication getApp()
  {
    return this.app;
  }
  
  public int getAppid()
  {
    return AppSetting.d();
  }
  
  public String getCurrentAccountUin()
  {
    return getAccount();
  }
  
  public EntityManagerFactory getEntityManagerFactory(String paramString)
  {
    if (this.E == null) {
      this.E = QQEntityManagerFactoryProxy.a(getAccount(), super.getEntityManagerFactory());
    }
    return this.E;
  }
  
  protected Class<? extends MSFServlet>[] getMessagePushServlets()
  {
    return new Class[] { VideoServlet.class };
  }
  
  public String h(String paramString)
  {
    return this.w.h(paramString);
  }
  
  public void h()
  {
    HardWareCodecSSO.ConfigReq localConfigReq = new HardWareCodecSSO.ConfigReq();
    localConfigReq.app_id.set(0);
    localConfigReq.app_ver.set("8.8.17");
    localConfigReq.mobile.set(Build.MODEL);
    Object localObject1 = localConfigReq.chip;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(Build.HARDWARE);
    ((StringBuilder)localObject2).append("_");
    ((StringBuilder)localObject2).append(VcSystemInfo.getCpuModel());
    ((PBStringField)localObject1).set(((StringBuilder)localObject2).toString());
    localConfigReq.os_version.set(Build.VERSION.SDK_INT);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder(50);
      ((StringBuilder)localObject1).append("app_id:=");
      ((StringBuilder)localObject1).append(localConfigReq.app_id.get());
      ((StringBuilder)localObject1).append("\n");
      ((StringBuilder)localObject1).append("app_ver:=");
      ((StringBuilder)localObject1).append(localConfigReq.app_ver.get());
      ((StringBuilder)localObject1).append("\n");
      ((StringBuilder)localObject1).append("mobile:=");
      ((StringBuilder)localObject1).append(localConfigReq.mobile.get());
      ((StringBuilder)localObject1).append("\n");
      ((StringBuilder)localObject1).append("chip:=");
      ((StringBuilder)localObject1).append(localConfigReq.chip.get());
      ((StringBuilder)localObject1).append("\n");
      ((StringBuilder)localObject1).append("os_version:=");
      ((StringBuilder)localObject1).append(localConfigReq.os_version.get());
      ((StringBuilder)localObject1).append("\n");
      localObject2 = D;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getMediaCodecChipConfigUpdate + ");
      localStringBuilder.append(((StringBuilder)localObject1).toString());
      QLog.d((String)localObject2, 2, localStringBuilder.toString());
    }
    localObject1 = new NewIntent(this.app, VideoServlet.class);
    ((NewIntent)localObject1).putExtra("reqType", 23);
    ((NewIntent)localObject1).putExtra("vMsg", localConfigReq.toByteArray());
    startServlet((NewIntent)localObject1);
  }
  
  public Map<String, Integer> i()
  {
    try
    {
      Map localMap = this.s.a();
      return localMap;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public boolean i(String paramString)
  {
    return this.w.i(paramString);
  }
  
  public BusinessInfoCheckUpdate.AppInfo j(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("red_touch_app_id", paramString);
    paramString = a(7, 0, 0, localBundle, null);
    if (paramString == null) {
      return null;
    }
    paramString.setClassLoader(RedAppInfo.class.getClassLoader());
    return RedTouchUtils.a((RedAppInfo)paramString.getParcelable("red_touch_red_app_info"));
  }
  
  public String j()
  {
    Object localObject = b();
    if (localObject != null)
    {
      String str = ((VideoController)localObject).k().s;
      int i1 = ((VideoController)localObject).k().p;
      localObject = ((VideoController)localObject).k().u;
      if (i1 == 9500)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(a(i1, str, (String)localObject));
        localStringBuilder.append("尚未配置摄像头，你将无法看到对方画面。");
        return localStringBuilder.toString();
      }
    }
    return "对方未打开摄像头";
  }
  
  public String k()
  {
    return this.w.g();
  }
  
  public void k(String paramString)
  {
    this.w.k(paramString);
  }
  
  public void l(String paramString)
  {
    this.w.l(paramString);
  }
  
  public boolean l()
  {
    return this.w.h();
  }
  
  public int m(String paramString)
  {
    return this.w.j(paramString);
  }
  
  public boolean m()
  {
    return this.w.i();
  }
  
  public int n(String paramString)
  {
    return x().b(paramString);
  }
  
  public boolean n()
  {
    return this.w.j();
  }
  
  public boolean o()
  {
    return this.w.l();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (AudioHelper.a()) {
      QLog.setUIN_REPORTLOG_LEVEL(4);
    }
    QavEngineAssistant.a();
    AudioHelper.b("VideoAppInterface.onCreate.begin");
    AVSoUtils.a(-1045L);
    this.i = true;
    VideoNodeManager.a(this);
    VideoNodeManager.a();
    VideoNodeManager.a(27);
    if (!QQVideoPlaySDKManager.isSDKReady()) {
      QQVideoPlaySDKManager.initSDKAsync(BaseApplication.getContext(), this);
    }
    long l1 = System.currentTimeMillis();
    super.onCreate(paramBundle);
    I();
    AudioHelper.a(this.app, getLongAccountUin());
    AudioHelper.a(BaseApplication.getContext());
    AudioHelper.b("VideoAppInterface.onCreate.begin1");
    G();
    getEntityManagerFactory(null);
    this.t = new MSFNetInfoMonitor(this);
    AppNetConnInfo.registerConnectionChangeReceiver(getApplication(), this.t);
    this.F = new MsfServletProxy(this);
    this.G = new BusinessHandlerFactory();
    this.G.a(this.F);
    this.e = new BusinessManagerFactory(this);
    this.f = new BusinessMessageCenter(this);
    F();
    this.d = new DeviceCapabilityExamination(this);
    this.m = new GAudioMessageMonitor(this);
    this.n = new GAccountMonitor(this);
    this.o = new GKillProcessMonitor(this);
    this.p = new GVipFunCallMonitor(this);
    this.q = new GAudioExitMonitor(this);
    this.r = new GBatteryMonitor(this);
    this.l = new GScreenActionMonitor(this);
    this.k = new GMemoryMonitor(this);
    this.s = new GCameraAvailabilityMonitor(this);
    this.H = new VideoProcessExitMonitor(this);
    this.I = new VideoRecoveryMonitor(this);
    this.J = new QAVNotifyActionMonitor(this);
    this.w = new QQServiceProxy(this);
    this.w.a();
    this.w.d();
    this.x = new AVServiceProxy(this);
    this.x.a();
    this.u = new ChatRoomMng(this);
    this.v = new WTogetherRealNameVideoProcessHelper(this);
    AVReport.a().b();
    D();
    ThreadManager.post(new VideoAppInterface.CameraUsageRunnable(this), 5, null, true);
    ThreadManager.excute(new VideoAppInterface.1(this), 16, null, true);
    H();
    E();
    try
    {
      MagnifierSDK.a(Long.parseLong(getAccount()));
    }
    catch (Exception paramBundle)
    {
      QLog.e(D, 4, paramBundle.toString());
    }
    try
    {
      ReporterMachine.b();
    }
    catch (Exception paramBundle)
    {
      String str = D;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[Magnifier startMachine error]");
      localStringBuilder.append(paramBundle);
      QLog.e(str, 1, localStringBuilder.toString());
    }
    if (QLog.isDevelopLevel())
    {
      long l2 = System.currentTimeMillis();
      paramBundle = new StringBuilder();
      paramBundle.append("IVR_TS_");
      paramBundle.append(D);
      QLog.d(paramBundle.toString(), 4, String.format("VideoAppInterface onCreate(), cost=%dms", new Object[] { Long.valueOf(l2 - l1) }));
    }
    AudioHelper.b("VideoAppInterface.onCreate.end");
    J();
    ClientLogReport.instance().checkLocalReportRecord();
    if (AudioHelper.a(25) == 1)
    {
      AudioHelper.a("使用了index_disable_immersive");
      com.tencent.widget.immersive.ImmersiveUtils.i_support_immersive = 0;
    }
  }
  
  protected void onDestroy()
  {
    if (this.M != null)
    {
      a().removeCallbacks(this.M);
      this.M = null;
    }
    K();
    this.N = null;
    this.x.b();
    this.w.b();
    this.w.e();
    PtvTemplateManager.c();
    this.l.b();
    this.k.a();
    this.m.a();
    this.n.a();
    this.o.b();
    this.p.b();
    this.q.b();
    this.r.b();
    this.s.c();
    this.J.b();
    ConfigManager.b(getApp());
    VideoNodeManager.b();
    super.onDestroy();
  }
  
  public void onSDKInited(boolean paramBoolean)
  {
    a = Boolean.valueOf(paramBoolean);
    String str = D;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSDKInited result:=");
    localStringBuilder.append(paramBoolean);
    QLog.w(str, 1, localStringBuilder.toString());
  }
  
  public boolean p()
  {
    return this.w.m();
  }
  
  public boolean q()
  {
    return this.w.n();
  }
  
  public boolean r()
  {
    return this.w.o();
  }
  
  public void receiveToService(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    QLog.d(D, 2, "receiveToService");
    this.F.a(paramFromServiceMsg.isSuccess(), paramToServiceMsg, paramFromServiceMsg, null);
  }
  
  public boolean s()
  {
    return this.w.p();
  }
  
  public void sendToService(ToServiceMsg paramToServiceMsg)
  {
    AVLog.printColorLog(D, "sendToService");
    this.F.a(paramToServiceMsg, VideoServlet.class);
  }
  
  public boolean t()
  {
    return this.w.q();
  }
  
  public boolean u()
  {
    return this.w.c();
  }
  
  public void v()
  {
    this.w.d();
  }
  
  public void w()
  {
    this.w.e();
  }
  
  public BeautyConfig x()
  {
    if (this.K) {
      return this.L;
    }
    synchronized (this.L)
    {
      if (!this.K)
      {
        String str1 = BeautyConfigUtil.b(getCurrentAccountUin());
        int i1;
        if (TextUtils.isEmpty(str1))
        {
          int i2 = BeautyConfigUtil.c(getCurrentAccountUin());
          i1 = i2;
          if (i2 != -1)
          {
            this.L.a("BEAUTY_SKIN", i2);
            i1 = i2;
          }
        }
        else
        {
          this.L.a(str1);
          i1 = -1;
        }
        this.K = true;
        if (QLog.isColorLevel())
        {
          String str2 = D;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getBeautyConfig config[");
          localStringBuilder.append(str1);
          localStringBuilder.append("], level[");
          localStringBuilder.append(i1);
          localStringBuilder.append("]");
          QLog.i(str2, 2, localStringBuilder.toString());
        }
      }
      return this.L;
    }
  }
  
  public void y()
  {
    x().d();
    K();
  }
  
  public boolean z()
  {
    BeautyConfig localBeautyConfig = x();
    if (localBeautyConfig.b("BEAUTY_SKIN") != 0) {
      return true;
    }
    return localBeautyConfig.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.VideoAppInterface
 * JD-Core Version:    0.7.0.1
 */
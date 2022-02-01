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
  public static Boolean a;
  private static String jdField_a_of_type_JavaLangString = "VideoAppInterface";
  protected int a;
  public long a;
  protected Handler a;
  protected VideoController a;
  private VideoProcessExitMonitor jdField_a_of_type_ComTencentAvVideoProcessExitMonitor;
  private VideoRecoveryMonitor jdField_a_of_type_ComTencentAvVideoRecoveryMonitor;
  AVServiceProxy jdField_a_of_type_ComTencentAvAppAVServiceProxy;
  protected DeviceCapabilityExamination a;
  GAccountMonitor jdField_a_of_type_ComTencentAvAppGAccountMonitor;
  GAudioExitMonitor jdField_a_of_type_ComTencentAvAppGAudioExitMonitor;
  GAudioMessageMonitor jdField_a_of_type_ComTencentAvAppGAudioMessageMonitor;
  GBatteryMonitor jdField_a_of_type_ComTencentAvAppGBatteryMonitor;
  GCameraAvailabilityMonitor jdField_a_of_type_ComTencentAvAppGCameraAvailabilityMonitor;
  GKillProcessMonitor jdField_a_of_type_ComTencentAvAppGKillProcessMonitor;
  GMemoryMonitor jdField_a_of_type_ComTencentAvAppGMemoryMonitor;
  GScreenActionMonitor jdField_a_of_type_ComTencentAvAppGScreenActionMonitor;
  GVipFunCallMonitor jdField_a_of_type_ComTencentAvAppGVipFunCallMonitor;
  MSFNetInfoMonitor jdField_a_of_type_ComTencentAvAppMSFNetInfoMonitor;
  private QAVNotifyActionMonitor jdField_a_of_type_ComTencentAvAppQAVNotifyActionMonitor;
  QQServiceProxy jdField_a_of_type_ComTencentAvAppQQServiceProxy;
  VideoNotifyCenter jdField_a_of_type_ComTencentAvAppVideoNotifyCenter = null;
  private MsfServletProxy jdField_a_of_type_ComTencentAvBusinessMsfServletProxy;
  private BusinessHandlerFactory jdField_a_of_type_ComTencentAvBusinessHandlerBusinessHandlerFactory;
  protected BusinessManagerFactory a;
  protected BusinessMessageCenter a;
  ChatRoomMng jdField_a_of_type_ComTencentAvChatroomChatRoomMng;
  private final BeautyConfig jdField_a_of_type_ComTencentAvOpenglEffectsBeautyConfig = new BeautyConfig();
  WTogetherRealNameVideoProcessHelper jdField_a_of_type_ComTencentAvWtogetherWTogetherRealNameVideoProcessHelper;
  private EntityManagerFactory jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory = null;
  private Runnable jdField_a_of_type_JavaLangRunnable = null;
  protected boolean a;
  private Runnable b;
  public boolean b;
  public boolean c = false;
  public boolean d = false;
  public boolean e = false;
  public boolean f = false;
  private boolean g = false;
  
  public VideoAppInterface(MobileQQ paramMobileQQ, String paramString)
  {
    super(paramMobileQQ, paramString);
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Long = 0L;
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
    this.jdField_a_of_type_ComTencentAvAppGAccountMonitor.b();
    this.jdField_a_of_type_ComTencentAvAppGAudioMessageMonitor.b();
    this.jdField_a_of_type_ComTencentAvAppGKillProcessMonitor.a();
    this.jdField_a_of_type_ComTencentAvAppGVipFunCallMonitor.a();
    this.jdField_a_of_type_ComTencentAvAppGAudioExitMonitor.a();
    this.jdField_a_of_type_ComTencentAvAppGBatteryMonitor.a();
    this.jdField_a_of_type_ComTencentAvAppGScreenActionMonitor.a();
    this.jdField_a_of_type_ComTencentAvAppGMemoryMonitor.b();
    this.jdField_a_of_type_ComTencentAvAppGCameraAvailabilityMonitor.a();
    this.jdField_a_of_type_ComTencentAvAppQAVNotifyActionMonitor.a();
  }
  
  private void h()
  {
    VideoController localVideoController = this.jdField_a_of_type_ComTencentAvVideoController;
    if (localVideoController == null) {
      a();
    } else {
      localVideoController.a(this);
    }
    AudioHelper.b("VideoAppInterface.onCreate.end");
  }
  
  private void i()
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
  
  private void j()
  {
    ThreadManager.post(this.jdField_b_of_type_JavaLangRunnable, 10, null, true);
  }
  
  private void k()
  {
    if ((AudioHelper.a()) && (AudioHelper.a(13) == 1))
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
    getApp().registerReceiver(new VideoAppInterface.4(this), localIntentFilter);
  }
  
  private void m()
  {
    if (this.jdField_a_of_type_JavaLangRunnable == null) {
      this.jdField_a_of_type_JavaLangRunnable = new VideoAppInterface.5(this);
    } else {
      a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    a().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 5000L);
  }
  
  public int a()
  {
    return a().countObservers();
  }
  
  public int a(int paramInt, String paramString)
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.a(paramInt, paramString);
  }
  
  public int a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.a(paramString);
  }
  
  public long a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.a(paramString);
  }
  
  public Bitmap a(int paramInt, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.a(paramInt, paramString1, paramString2, paramBoolean1, paramBoolean2);
  }
  
  public Bundle a(int paramInt1, int paramInt2, int paramInt3, Bundle paramBundle, ResultReceiver paramResultReceiver)
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.a(paramInt1, paramInt2, paramInt3, paramBundle, paramResultReceiver);
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
  
  public VideoProcessExitMonitor a()
  {
    return this.jdField_a_of_type_ComTencentAvVideoProcessExitMonitor;
  }
  
  public VideoRecoveryMonitor a()
  {
    return this.jdField_a_of_type_ComTencentAvVideoRecoveryMonitor;
  }
  
  VideoNotifyCenter a()
  {
    if (this.jdField_a_of_type_ComTencentAvAppVideoNotifyCenter == null) {
      this.jdField_a_of_type_ComTencentAvAppVideoNotifyCenter = new VideoNotifyCenter(this);
    }
    return this.jdField_a_of_type_ComTencentAvAppVideoNotifyCenter;
  }
  
  public BusinessManager a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentAvBusinessManagerBusinessManagerFactory.a(paramInt);
  }
  
  public ChatRoomMng a()
  {
    return this.jdField_a_of_type_ComTencentAvChatroomChatRoomMng;
  }
  
  public BeautyConfig a()
  {
    if (this.g) {
      return this.jdField_a_of_type_ComTencentAvOpenglEffectsBeautyConfig;
    }
    synchronized (this.jdField_a_of_type_ComTencentAvOpenglEffectsBeautyConfig)
    {
      if (!this.g)
      {
        String str1 = BeautyConfigUtil.a(getCurrentAccountUin());
        int i;
        if (TextUtils.isEmpty(str1))
        {
          int j = BeautyConfigUtil.a(getCurrentAccountUin());
          i = j;
          if (j != -1)
          {
            this.jdField_a_of_type_ComTencentAvOpenglEffectsBeautyConfig.a("BEAUTY_SKIN", j);
            i = j;
          }
        }
        else
        {
          this.jdField_a_of_type_ComTencentAvOpenglEffectsBeautyConfig.a(str1);
          i = -1;
        }
        this.g = true;
        if (QLog.isColorLevel())
        {
          String str2 = jdField_a_of_type_JavaLangString;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getBeautyConfig config[");
          localStringBuilder.append(str1);
          localStringBuilder.append("], level[");
          localStringBuilder.append(i);
          localStringBuilder.append("]");
          QLog.i(str2, 2, localStringBuilder.toString());
        }
      }
      return this.jdField_a_of_type_ComTencentAvOpenglEffectsBeautyConfig;
    }
  }
  
  public WTogetherRealNameVideoProcessHelper a()
  {
    return this.jdField_a_of_type_ComTencentAvWtogetherWTogetherRealNameVideoProcessHelper;
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
    return RedTouchUtils.a((RedAppInfo)paramString.getParcelable("red_touch_red_app_info"));
  }
  
  public String a()
  {
    Object localObject = a();
    if (localObject != null)
    {
      String str = ((VideoController)localObject).a().c;
      int i = ((VideoController)localObject).a().k;
      localObject = ((VideoController)localObject).a().e;
      if (i == 9500)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(a(i, str, (String)localObject));
        localStringBuilder.append("尚未配置摄像头，你将无法看到对方画面。");
        return localStringBuilder.toString();
      }
    }
    return "对方未打开摄像头";
  }
  
  public String a(int paramInt, String paramString1, String paramString2)
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.b(paramInt, paramString1, paramString2);
  }
  
  public String a(AvatarParam paramAvatarParam, int paramInt)
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.a(paramAvatarParam, paramInt);
  }
  
  public String a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.b(paramString);
  }
  
  public Map<String, Integer> a()
  {
    try
    {
      Map localMap = this.jdField_a_of_type_ComTencentAvAppGCameraAvailabilityMonitor.a();
      return localMap;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 2, "getVideoConfigUpdate");
    }
    NewIntent localNewIntent = new NewIntent(this.app, VideoConfigServlet.class);
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
    this.jdField_a_of_type_ComTencentAvBusinessManagerBusinessManagerFactory.a(paramInt, paramString);
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.a(paramInt, paramString1, paramString2);
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.a(paramLong);
  }
  
  public void a(long paramLong, int paramInt)
  {
    int i;
    if (paramInt < 200) {
      i = paramInt + 200;
    } else {
      i = paramInt;
    }
    boolean bool;
    if (i == 261) {
      bool = true;
    } else {
      bool = false;
    }
    Object localObject = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("video exit, mIsExit[");
    localStringBuilder.append(this.d);
    localStringBuilder.append("], reason[");
    localStringBuilder.append(i);
    localStringBuilder.append("], _reason[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], mManagerFactory[");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAvBusinessManagerBusinessManagerFactory);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(paramLong);
    localStringBuilder.append("]");
    QLog.w((String)localObject, 1, localStringBuilder.toString(), new Throwable("打印调用栈"));
    this.d = true;
    localObject = this.jdField_a_of_type_ComTencentAvVideoController;
    if ((localObject != null) && (((VideoController)localObject).a() != null)) {
      if (this.jdField_a_of_type_ComTencentAvVideoController.a().aF) {
        ReportController.b(null, "CliOper", "", "", "0X8008AAD", "0X8008AAD", 0, 0, "", "", "", "");
      } else {
        ReportController.b(null, "CliOper", "", "", "0X8008AAC", "0X8008AAC", 0, 0, "", "", "", "");
      }
    }
    SmallScreenUtils.a(paramLong, 1, getApplication());
    AVLog.printAllUserLog(jdField_a_of_type_JavaLangString, "exit video process clearNotification");
    QQNotificationManager.getInstance().cancel(jdField_a_of_type_JavaLangString, 235);
    localObject = (AudioManager)getApplication().getApplicationContext().getSystemService("audio");
    if (localObject != null) {}
    try
    {
      ((AudioManager)localObject).setSpeakerphoneOn(this.jdField_a_of_type_Boolean);
    }
    catch (NullPointerException localNullPointerException)
    {
      label338:
      break label338;
    }
    AVLog.printAllUserLog(jdField_a_of_type_JavaLangString, "VideoAppInterface.exit() -> am.setSpeakerphoneOn() catch NullPointerException !");
    ((AudioManager)localObject).setMode(this.jdField_a_of_type_Int);
    localObject = QAVNotification.a(this);
    if (localObject != null) {
      ((QAVNotification)localObject).a();
    }
    AVLog.printAllUserLog(jdField_a_of_type_JavaLangString, "force exit video process ...");
    QLog.flushLog();
    localObject = this.jdField_a_of_type_ComTencentAvVideoProcessExitMonitor;
    if (localObject != null)
    {
      if (((VideoProcessExitMonitor)localObject).a()) {
        this.jdField_a_of_type_ComTencentAvVideoProcessExitMonitor.a(bool);
      }
      if (this.jdField_a_of_type_ComTencentAvVideoProcessExitMonitor.c()) {
        this.jdField_a_of_type_ComTencentAvVideoController.m(false);
      }
      if (this.jdField_a_of_type_ComTencentAvVideoProcessExitMonitor.b()) {
        this.jdField_a_of_type_ComTencentAvVideoController.k(false);
      }
    }
  }
  
  public void a(long paramLong1, String paramString, long paramLong2)
  {
    this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.a(paramLong1, paramString, paramLong2);
  }
  
  public void a(String paramString)
  {
    VideoNodeReporter localVideoNodeReporter = (VideoNodeReporter)a(4);
    if (localVideoNodeReporter != null)
    {
      localVideoNodeReporter.a(paramString);
      localVideoNodeReporter.a(36, 1L);
      localVideoNodeReporter.a(29, 1L);
      localVideoNodeReporter.b();
      VideoNodeManager.a(16, 1L);
      VideoNodeManager.c();
    }
    onDestroy();
  }
  
  public void a(String paramString, int paramInt)
  {
    try
    {
      this.jdField_a_of_type_ComTencentAvAppGCameraAvailabilityMonitor.a(paramString, paramInt);
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
      if (QLog.isDevelopLevel())
      {
        String str = jdField_a_of_type_JavaLangString;
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
      a().addObserver(paramObserver);
      QQServiceProxy localQQServiceProxy = this.jdField_a_of_type_ComTencentAvAppQQServiceProxy;
      if ((localQQServiceProxy != null) && (localQQServiceProxy.a != null)) {
        paramObserver.update(a(), new Object[] { Integer.valueOf(10) });
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    QQServiceProxy localQQServiceProxy = this.jdField_a_of_type_ComTencentAvAppQQServiceProxy;
    if (localQQServiceProxy != null) {
      localQQServiceProxy.a(paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean, Notification paramNotification)
  {
    this.jdField_a_of_type_ComTencentAvAppAVServiceProxy.a(paramBoolean, paramNotification);
  }
  
  public void a(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject != null) && (paramArrayOfObject.length > 0)) {
      a().a(paramArrayOfObject);
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.b();
  }
  
  public boolean a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentAvBusinessManagerBusinessManagerFactory.a(paramInt);
  }
  
  public boolean a(int paramInt, long paramLong)
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.a(paramInt, paramLong);
  }
  
  public boolean a(long paramLong)
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.a(paramLong);
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.a(paramString);
  }
  
  public long[] a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.a(paramString);
  }
  
  public int b(String paramString)
  {
    return a().a(paramString);
  }
  
  public String b()
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.a();
  }
  
  public String b(String paramString)
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.c(paramString);
  }
  
  public void b()
  {
    HardWareCodecSSO.ConfigReq localConfigReq = new HardWareCodecSSO.ConfigReq();
    localConfigReq.app_id.set(0);
    localConfigReq.app_ver.set("8.7.0");
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
      localObject2 = jdField_a_of_type_JavaLangString;
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
  
  public void b(int paramInt)
  {
    long l = AudioHelper.b();
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("exitVideoProcess, reason[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], videoController[");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentAvVideoController);
    localStringBuilder.append("], reason[");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("], seq[");
    localStringBuilder.append(l);
    localStringBuilder.append("]");
    QLog.w(str, 1, localStringBuilder.toString());
    int i;
    switch (paramInt)
    {
    default: 
      i = 260;
      break;
    case 1005: 
      i = 258;
      break;
    case 1004: 
      i = 259;
      break;
    case 1003: 
      i = 256;
      break;
    case 1002: 
      i = 257;
      break;
    case 1001: 
      i = 255;
      break;
    case 1000: 
      i = 254;
    }
    try
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController != null)
      {
        int j = this.jdField_a_of_type_ComTencentAvVideoController.a().f;
        if ((j > 0) && (j <= 4))
        {
          str = this.jdField_a_of_type_ComTencentAvVideoController.a().c;
          this.jdField_a_of_type_ComTencentAvVideoController.a(str, i);
          this.jdField_a_of_type_ComTencentAvVideoController.b(i);
          this.jdField_a_of_type_ComTencentAvVideoController.b(str, 0);
        }
        else if (this.jdField_a_of_type_ComTencentAvVideoController.d)
        {
          this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.b, this.jdField_a_of_type_ComTencentAvVideoController.jdField_a_of_type_Long, 72);
        }
        this.jdField_a_of_type_ComTencentAvVideoController.m = false;
        a(l, paramInt);
        return;
      }
      QLog.d(jdField_a_of_type_JavaLangString, 1, "exitVideoProcess System.exit ");
      QLog.flushLog();
      return;
    }
    catch (Exception localException)
    {
      label327:
      break label327;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 1, "exitVideoProcess Exception System.exit ");
    QLog.flushLog();
  }
  
  public void b(int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.a(paramInt, paramString);
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
            localObject2 = jdField_a_of_type_JavaLangString;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Switch Account: ");
            localStringBuilder.append(paramString);
            QLog.d((String)localObject2, 2, localStringBuilder.toString());
          }
          switchAccount((SimpleAccount)localObject1, null);
          localObject1 = this.jdField_a_of_type_ComTencentAvVideoController;
          if (localObject1 != null) {
            ((VideoController)localObject1).a(paramString);
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
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("reportQuaProcessWakeUp() isBroadcastCreated = ");
    localStringBuilder.append(paramBoolean);
    QLog.d(str, 1, localStringBuilder.toString());
    if (paramBoolean) {
      this.e = true;
    } else {
      this.f = true;
    }
    paramBoolean = this.e;
    if (paramBoolean)
    {
      boolean bool = this.f;
      if (bool)
      {
        VideoBeaconReporter.a(paramBoolean, bool);
        return;
      }
      a().postDelayed(new VideoAppInterface.3(this), 3000L);
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.c();
  }
  
  public boolean b(String paramString)
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.b(paramString);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.c();
  }
  
  public void c(int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvBusinessManagerBusinessManagerFactory.a(paramInt);
  }
  
  public void c(int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.b(paramInt, paramString);
  }
  
  public void c(String paramString)
  {
    this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.a(paramString);
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.d();
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.d();
  }
  
  public void d(String paramString)
  {
    this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.b(paramString);
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.e();
  }
  
  public void e()
  {
    a().b();
    m();
  }
  
  public void e(String paramString)
  {
    this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.c(paramString);
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.f();
  }
  
  public boolean f()
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.g();
  }
  
  public boolean g()
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.h();
  }
  
  public BaseApplication getApp()
  {
    return this.app;
  }
  
  public int getAppid()
  {
    return AppSetting.a();
  }
  
  public String getCurrentAccountUin()
  {
    return getAccount();
  }
  
  public EntityManagerFactory getEntityManagerFactory(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory == null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory = QQEntityManagerFactoryProxy.a(getAccount(), super.getEntityManagerFactory());
    }
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  }
  
  protected Class<? extends MSFServlet>[] getMessagePushServlets()
  {
    return new Class[] { VideoServlet.class };
  }
  
  public boolean h()
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.i();
  }
  
  public boolean i()
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.j();
  }
  
  public boolean j()
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.a();
  }
  
  public boolean k()
  {
    BeautyConfig localBeautyConfig = a();
    if (localBeautyConfig.a("BEAUTY_SKIN") != 0) {
      return true;
    }
    return localBeautyConfig.b();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    if (AudioHelper.a()) {
      QLog.setUIN_REPORTLOG_LEVEL(4);
    }
    QavEngineAssistant.a();
    AudioHelper.b("VideoAppInterface.onCreate.begin");
    AVSoUtils.a(-1045L);
    this.jdField_b_of_type_Boolean = true;
    VideoNodeManager.a(this);
    VideoNodeManager.a();
    VideoNodeManager.a(27);
    if (!QQVideoPlaySDKManager.a()) {
      QQVideoPlaySDKManager.a(BaseApplication.getContext(), this);
    }
    long l1 = System.currentTimeMillis();
    super.onCreate(paramBundle);
    k();
    AudioHelper.a(this.app, getLongAccountUin());
    AudioHelper.a(BaseApplication.getContext());
    AudioHelper.b("VideoAppInterface.onCreate.begin1");
    i();
    getEntityManagerFactory(null);
    this.jdField_a_of_type_ComTencentAvAppMSFNetInfoMonitor = new MSFNetInfoMonitor(this);
    AppNetConnInfo.registerConnectionChangeReceiver(getApplication(), this.jdField_a_of_type_ComTencentAvAppMSFNetInfoMonitor);
    this.jdField_a_of_type_ComTencentAvBusinessMsfServletProxy = new MsfServletProxy(this);
    this.jdField_a_of_type_ComTencentAvBusinessHandlerBusinessHandlerFactory = new BusinessHandlerFactory();
    this.jdField_a_of_type_ComTencentAvBusinessHandlerBusinessHandlerFactory.a(this.jdField_a_of_type_ComTencentAvBusinessMsfServletProxy);
    this.jdField_a_of_type_ComTencentAvBusinessManagerBusinessManagerFactory = new BusinessManagerFactory(this);
    this.jdField_a_of_type_ComTencentAvBusinessManagerBusinessMessageCenter = new BusinessMessageCenter(this);
    h();
    this.jdField_a_of_type_ComTencentAvAppDeviceCapabilityExamination = new DeviceCapabilityExamination(this);
    this.jdField_a_of_type_ComTencentAvAppGAudioMessageMonitor = new GAudioMessageMonitor(this);
    this.jdField_a_of_type_ComTencentAvAppGAccountMonitor = new GAccountMonitor(this);
    this.jdField_a_of_type_ComTencentAvAppGKillProcessMonitor = new GKillProcessMonitor(this);
    this.jdField_a_of_type_ComTencentAvAppGVipFunCallMonitor = new GVipFunCallMonitor(this);
    this.jdField_a_of_type_ComTencentAvAppGAudioExitMonitor = new GAudioExitMonitor(this);
    this.jdField_a_of_type_ComTencentAvAppGBatteryMonitor = new GBatteryMonitor(this);
    this.jdField_a_of_type_ComTencentAvAppGScreenActionMonitor = new GScreenActionMonitor(this);
    this.jdField_a_of_type_ComTencentAvAppGMemoryMonitor = new GMemoryMonitor(this);
    this.jdField_a_of_type_ComTencentAvAppGCameraAvailabilityMonitor = new GCameraAvailabilityMonitor(this);
    this.jdField_a_of_type_ComTencentAvVideoProcessExitMonitor = new VideoProcessExitMonitor(this);
    this.jdField_a_of_type_ComTencentAvVideoRecoveryMonitor = new VideoRecoveryMonitor(this);
    this.jdField_a_of_type_ComTencentAvAppQAVNotifyActionMonitor = new QAVNotifyActionMonitor(this);
    this.jdField_a_of_type_ComTencentAvAppQQServiceProxy = new QQServiceProxy(this);
    this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.a();
    this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.c();
    this.jdField_a_of_type_ComTencentAvAppAVServiceProxy = new AVServiceProxy(this);
    this.jdField_a_of_type_ComTencentAvAppAVServiceProxy.a();
    this.jdField_a_of_type_ComTencentAvChatroomChatRoomMng = new ChatRoomMng(this);
    this.jdField_a_of_type_ComTencentAvWtogetherWTogetherRealNameVideoProcessHelper = new WTogetherRealNameVideoProcessHelper(this);
    AVReport.a().a();
    f();
    ThreadManager.post(new VideoAppInterface.CameraUsageRunnable(this), 5, null, true);
    ThreadManager.excute(new VideoAppInterface.1(this), 16, null, true);
    j();
    g();
    try
    {
      MagnifierSDK.a(Long.parseLong(getAccount()));
    }
    catch (Exception paramBundle)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 4, paramBundle.toString());
    }
    try
    {
      ReporterMachine.a();
    }
    catch (Exception paramBundle)
    {
      String str = jdField_a_of_type_JavaLangString;
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
      paramBundle.append(jdField_a_of_type_JavaLangString);
      QLog.d(paramBundle.toString(), 4, String.format("VideoAppInterface onCreate(), cost=%dms", new Object[] { Long.valueOf(l2 - l1) }));
    }
    AudioHelper.b("VideoAppInterface.onCreate.end");
    l();
    ClientLogReport.instance().checkLocalReportRecord();
    if (AudioHelper.a(25) == 1)
    {
      AudioHelper.a("使用了index_disable_immersive");
      com.tencent.widget.immersive.ImmersiveUtils.i_support_immersive = 0;
    }
  }
  
  protected void onDestroy()
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      a().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
      this.jdField_a_of_type_JavaLangRunnable = null;
    }
    m();
    this.jdField_b_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_ComTencentAvAppAVServiceProxy.b();
    this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.b();
    this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.d();
    PtvTemplateManager.a();
    this.jdField_a_of_type_ComTencentAvAppGScreenActionMonitor.b();
    this.jdField_a_of_type_ComTencentAvAppGMemoryMonitor.a();
    this.jdField_a_of_type_ComTencentAvAppGAudioMessageMonitor.a();
    this.jdField_a_of_type_ComTencentAvAppGAccountMonitor.a();
    this.jdField_a_of_type_ComTencentAvAppGKillProcessMonitor.b();
    this.jdField_a_of_type_ComTencentAvAppGVipFunCallMonitor.b();
    this.jdField_a_of_type_ComTencentAvAppGAudioExitMonitor.b();
    this.jdField_a_of_type_ComTencentAvAppGBatteryMonitor.b();
    this.jdField_a_of_type_ComTencentAvAppGCameraAvailabilityMonitor.b();
    this.jdField_a_of_type_ComTencentAvAppQAVNotifyActionMonitor.b();
    ConfigManager.a(getApp());
    VideoNodeManager.b();
    super.onDestroy();
  }
  
  public void onSDKInited(boolean paramBoolean)
  {
    jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(paramBoolean);
    String str = jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSDKInited result:=");
    localStringBuilder.append(paramBoolean);
    QLog.w(str, 1, localStringBuilder.toString());
  }
  
  public void receiveToService(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 2, "receiveToService");
    this.jdField_a_of_type_ComTencentAvBusinessMsfServletProxy.a(paramFromServiceMsg.isSuccess(), paramToServiceMsg, paramFromServiceMsg, null);
  }
  
  public void sendToService(ToServiceMsg paramToServiceMsg)
  {
    AVLog.printColorLog(jdField_a_of_type_JavaLangString, "sendToService");
    this.jdField_a_of_type_ComTencentAvBusinessMsfServletProxy.a(paramToServiceMsg, VideoServlet.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.app.VideoAppInterface
 * JD-Core Version:    0.7.0.1
 */
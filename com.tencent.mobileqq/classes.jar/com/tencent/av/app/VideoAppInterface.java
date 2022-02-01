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
import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.av.report.AVReport;
import com.tencent.av.service.IAVRedPacketCallback;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.ui.BeautyConfigUtil;
import com.tencent.av.utils.QAVNotification;
import com.tencent.av.video.call.ClientLogReport;
import com.tencent.av.wtogether.WTogetherRealNameVideoProcessHelper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseVideoAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.util.notification.QQNotificationManager;
import com.tencent.mobileqq.abtest.ABTestController;
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
import com.tencent.mobileqq.startup.step.AVSoUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.statistics.StatisticCollector.StatisticCallback;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mobileqq.transfile.NetEngineFactory;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.SimpleAccount;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.MagnifierSDK;
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
  implements MSFNetInfoMonitor.IApnChangeListener, StatisticCollector.StatisticCallback, SDKInitListener
{
  public static Boolean a;
  private static String jdField_a_of_type_JavaLangString = "VideoAppInterface";
  protected int a;
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
  private NetEngineFactory jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory = null;
  private Runnable jdField_a_of_type_JavaLangRunnable = null;
  protected boolean a;
  private Runnable b;
  public boolean b;
  public boolean c = false;
  public boolean d = false;
  public boolean e = false;
  public boolean f = false;
  public boolean g = false;
  private boolean h = false;
  
  static
  {
    jdField_a_of_type_JavaLangBoolean = null;
  }
  
  public VideoAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
    this.jdField_a_of_type_AndroidOsHandler = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Boolean = false;
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
    if ((AudioHelper.d()) && (AudioHelper.a(13) == 1))
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
    if (this.h) {
      return this.jdField_a_of_type_ComTencentAvOpenglEffectsBeautyConfig;
    }
    synchronized (this.jdField_a_of_type_ComTencentAvOpenglEffectsBeautyConfig)
    {
      String str;
      if (!this.h)
      {
        str = BeautyConfigUtil.a(getCurrentAccountUin());
        if (!TextUtils.isEmpty(str)) {
          break label133;
        }
        int j = BeautyConfigUtil.a(getCurrentAccountUin());
        i = j;
        if (j != -1)
        {
          this.jdField_a_of_type_ComTencentAvOpenglEffectsBeautyConfig.a("BEAUTY_SKIN", j);
          i = j;
        }
        this.h = true;
        if (QLog.isColorLevel()) {
          QLog.i(jdField_a_of_type_JavaLangString, 2, "getBeautyConfig config[" + str + "], level[" + i + "]");
        }
      }
      return this.jdField_a_of_type_ComTencentAvOpenglEffectsBeautyConfig;
      label133:
      this.jdField_a_of_type_ComTencentAvOpenglEffectsBeautyConfig.a(str);
      int i = -1;
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
    String str2 = getApp().getString(2131720548);
    Object localObject = a();
    String str1 = str2;
    if (localObject != null)
    {
      String str3 = ((VideoController)localObject).a().d;
      int i = ((VideoController)localObject).a().j;
      localObject = ((VideoController)localObject).a().f;
      str1 = str2;
      if (i == 9500) {
        str1 = a(i, str3, (String)localObject) + getApp().getString(2131720550);
      }
    }
    return str1;
  }
  
  public String a(int paramInt, String paramString1, String paramString2)
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.b(paramInt, paramString1, paramString2);
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
    if (paramInt < 200) {}
    for (int i = paramInt + 200;; i = paramInt)
    {
      boolean bool;
      if (i == 261) {
        bool = true;
      }
      for (;;)
      {
        QLog.w(jdField_a_of_type_JavaLangString, 1, "video exit, mIsExit[" + this.e + "], reason[" + i + "], _reason[" + paramInt + "], mManagerFactory[" + this.jdField_a_of_type_ComTencentAvBusinessManagerBusinessManagerFactory + "], seq[" + paramLong + "]", new Throwable("打印调用栈"));
        this.e = true;
        Object localObject;
        if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a() != null))
        {
          if (this.jdField_a_of_type_ComTencentAvVideoController.a().H) {
            ReportController.b(null, "CliOper", "", "", "0X8008AAD", "0X8008AAD", 0, 0, "", "", "", "");
          }
        }
        else
        {
          if ((this.jdField_b_of_type_Boolean) && (this.jdField_a_of_type_ComTencentAvVideoController != null)) {
            this.jdField_a_of_type_ComTencentAvVideoController.A();
          }
          this.jdField_b_of_type_Boolean = false;
          SmallScreenUtils.a(paramLong, 1, getApplication());
          AVLog.printAllUserLog(jdField_a_of_type_JavaLangString, "exit video process clearNotification");
          QQNotificationManager.getInstance().cancel(jdField_a_of_type_JavaLangString, 235);
          localObject = (AudioManager)getApplication().getApplicationContext().getSystemService("audio");
          if (localObject == null) {}
        }
        try
        {
          ((AudioManager)localObject).setSpeakerphoneOn(this.jdField_a_of_type_Boolean);
          ((AudioManager)localObject).setMode(this.jdField_a_of_type_Int);
          localObject = QAVNotification.a(this);
          if (localObject != null) {
            ((QAVNotification)localObject).a();
          }
          AVLog.printAllUserLog(jdField_a_of_type_JavaLangString, "force exit video process ...");
          QLog.flushLog();
          if (this.jdField_a_of_type_ComTencentAvVideoProcessExitMonitor != null)
          {
            if (this.jdField_a_of_type_ComTencentAvVideoProcessExitMonitor.a()) {
              this.jdField_a_of_type_ComTencentAvVideoProcessExitMonitor.a(bool);
            }
            if (this.jdField_a_of_type_ComTencentAvVideoProcessExitMonitor.c()) {
              this.jdField_a_of_type_ComTencentAvVideoController.n(false);
            }
            if (this.jdField_a_of_type_ComTencentAvVideoProcessExitMonitor.b()) {
              this.jdField_a_of_type_ComTencentAvVideoController.l(false);
            }
          }
          return;
          bool = false;
          continue;
          ReportController.b(null, "CliOper", "", "", "0X8008AAC", "0X8008AAC", 0, 0, "", "", "", "");
        }
        catch (NullPointerException localNullPointerException)
        {
          for (;;)
          {
            AVLog.printAllUserLog(jdField_a_of_type_JavaLangString, "VideoAppInterface.exit() -> am.setSpeakerphoneOn() catch NullPointerException !");
          }
        }
      }
    }
  }
  
  public void a(long paramLong1, String paramString, long paramLong2)
  {
    this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.a(paramLong1, paramString, paramLong2);
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
      if ((this.jdField_a_of_type_ComTencentAvAppQQServiceProxy != null) && (this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.a != null)) {
        paramObserver.update(a(), new Object[] { Integer.valueOf(10) });
      }
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentAvAppQQServiceProxy != null) {
      this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.a(paramBoolean);
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
    return this.jdField_a_of_type_ComTencentAvAppAVServiceProxy.a();
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
  
  public boolean a(IAVRedPacketCallback paramIAVRedPacketCallback)
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.a(paramIAVRedPacketCallback);
  }
  
  public boolean a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.a(paramString);
  }
  
  public boolean a(String paramString, int paramInt)
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.a(paramString, paramInt);
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
    localConfigReq.app_ver.set("8.5.5");
    localConfigReq.mobile.set(Build.MODEL);
    localConfigReq.chip.set(Build.HARDWARE + "_" + VcSystemInfo.getCpuModel());
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
    Object localObject = new NewIntent(this.app, VideoServlet.class);
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
          if (!this.jdField_a_of_type_ComTencentAvVideoController.d) {
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
    this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.a(paramInt, paramString);
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.a(paramString);
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
        VideoBeaconReporter.a(this.f, this.g);
      }
      return;
      this.g = true;
    }
    a().postDelayed(new VideoAppInterface.3(this), 3000L);
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.b();
  }
  
  public boolean b(IAVRedPacketCallback paramIAVRedPacketCallback)
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.b(paramIAVRedPacketCallback);
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
    this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.b(paramString);
  }
  
  public boolean c()
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.c();
  }
  
  public boolean c(String paramString)
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.c(paramString);
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.d();
  }
  
  public void d(String paramString)
  {
    this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.c(paramString);
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.d();
  }
  
  public void e()
  {
    a().b();
    m();
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.e();
  }
  
  public boolean f()
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.f();
  }
  
  public boolean g()
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.g();
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
  
  public Class<? extends MSFServlet>[] getMessagePushServlets()
  {
    return new Class[] { VideoServlet.class };
  }
  
  public boolean h()
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.h();
  }
  
  public boolean i()
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.i();
  }
  
  public boolean j()
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.j();
  }
  
  public boolean k()
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.a();
  }
  
  public boolean l()
  {
    BeautyConfig localBeautyConfig = a();
    if (localBeautyConfig.a("BEAUTY_SKIN") != 0) {
      return true;
    }
    return localBeautyConfig.b();
  }
  
  public void onCallback(String paramString)
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
  
  public void onCreate(Bundle paramBundle)
  {
    if (AudioHelper.d()) {
      QLog.setUIN_REPORTLOG_LEVEL(4);
    }
    QavEngineAssistant.a();
    ABTestController.a((BaseApplicationImpl)this.app, getAccount());
    AudioHelper.b("VideoAppInterface.onCreate.begin");
    AVSoUtils.a(-1045L);
    this.c = true;
    VideoNodeManager.a(this);
    VideoNodeManager.a();
    VideoNodeManager.a(27);
    if (!QQVideoPlaySDKManager.a()) {
      QQVideoPlaySDKManager.a(BaseApplicationImpl.getContext(), this);
    }
    long l1 = System.currentTimeMillis();
    super.onCreate(paramBundle);
    k();
    AudioHelper.a((BaseApplicationImpl)this.app, getLongAccountUin());
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
            com.tencent.widget.immersive.ImmersiveUtils.i_support_immersive = 0;
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
    this.jdField_a_of_type_ComTencentAvAppAVServiceProxy.b();
    this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.b();
    this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.d();
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory.onDestroy();
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory = null;
      PtvTemplateManager.a();
      AVRedPacketManager.b();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.app.VideoAppInterface
 * JD-Core Version:    0.7.0.1
 */
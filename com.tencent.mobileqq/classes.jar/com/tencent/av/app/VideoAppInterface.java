package com.tencent.av.app;

import android.app.Notification;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.os.ResultReceiver;
import com.tencent.av.AVLog;
import com.tencent.av.VideoController;
import com.tencent.av.VideoServlet;
import com.tencent.av.business.MsfServletProxy;
import com.tencent.av.business.handler.BusinessHandlerFactory;
import com.tencent.av.business.manager.BusinessManager;
import com.tencent.av.business.manager.BusinessManagerFactory;
import com.tencent.av.business.manager.BusinessMessageCenter;
import com.tencent.av.business.manager.report.VideoNodeManager;
import com.tencent.av.business.manager.report.VideoNodeReporter;
import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.av.report.AVReport;
import com.tencent.av.service.IAVRedPacketCallback;
import com.tencent.av.smallscreen.SmallScreenUtils;
import com.tencent.av.utils.QAVNotification;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.QNotificationManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.servlet.VideoConfigServlet;
import com.tencent.mobileqq.shortvideo.PtvTemplateManager;
import com.tencent.mobileqq.startup.step.InitMemoryCache;
import com.tencent.mobileqq.startup.step.InitUrlDrawable;
import com.tencent.mobileqq.startup.step.UpdateAvSo;
import com.tencent.mobileqq.statistics.ReportController;
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
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Observer;
import java.util.Vector;
import jgl;
import jgo;
import jhb;
import jhc;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;

public class VideoAppInterface
  extends AppInterface
  implements StatisticCollector.StatisticCallback
{
  private static String jdField_a_of_type_JavaLangString = "VideoAppInterface";
  protected int a;
  protected Handler a;
  protected VideoController a;
  AVServiceProxy jdField_a_of_type_ComTencentAvAppAVServiceProxy;
  protected DeviceCapabilityExamination a;
  GAudioExitMonitor jdField_a_of_type_ComTencentAvAppGAudioExitMonitor;
  GBatteryMonitor jdField_a_of_type_ComTencentAvAppGBatteryMonitor;
  GCameraAvailabilityMonitor jdField_a_of_type_ComTencentAvAppGCameraAvailabilityMonitor;
  GKillProcessMonitor jdField_a_of_type_ComTencentAvAppGKillProcessMonitor;
  GMemoryMonitor jdField_a_of_type_ComTencentAvAppGMemoryMonitor;
  GScreenActionMonitor jdField_a_of_type_ComTencentAvAppGScreenActionMonitor;
  GVipFunCallMonitor jdField_a_of_type_ComTencentAvAppGVipFunCallMonitor;
  MSFNetInfoMonitor jdField_a_of_type_ComTencentAvAppMSFNetInfoMonitor;
  QQServiceProxy jdField_a_of_type_ComTencentAvAppQQServiceProxy;
  VideoNotifyCenter jdField_a_of_type_ComTencentAvAppVideoNotifyCenter = null;
  private MsfServletProxy jdField_a_of_type_ComTencentAvBusinessMsfServletProxy;
  private BusinessHandlerFactory jdField_a_of_type_ComTencentAvBusinessHandlerBusinessHandlerFactory;
  public BusinessManagerFactory a;
  protected BusinessMessageCenter a;
  private EntityManagerFactory jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  private NetEngineFactory jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory;
  private Runnable jdField_a_of_type_JavaLangRunnable = new jhb(this);
  protected List a;
  jgl jdField_a_of_type_Jgl;
  jgo jdField_a_of_type_Jgo;
  protected boolean a;
  public boolean b;
  public boolean c;
  public boolean d;
  public boolean e;
  
  public VideoAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
    this.jdField_a_of_type_Int = 1;
  }
  
  private void c()
  {
    AudioManager localAudioManager = (AudioManager)getApplication().getApplicationContext().getSystemService("audio");
    if (localAudioManager != null)
    {
      this.jdField_a_of_type_Boolean = localAudioManager.isSpeakerphoneOn();
      this.jdField_a_of_type_Int = localAudioManager.getMode();
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_Jgl.b();
    this.jdField_a_of_type_Jgo.b();
    this.jdField_a_of_type_ComTencentAvAppGKillProcessMonitor.a();
    this.jdField_a_of_type_ComTencentAvAppGVipFunCallMonitor.a();
    this.jdField_a_of_type_ComTencentAvAppGAudioExitMonitor.a();
    this.jdField_a_of_type_ComTencentAvAppGBatteryMonitor.a();
    this.jdField_a_of_type_ComTencentAvAppGScreenActionMonitor.a();
    this.jdField_a_of_type_ComTencentAvAppGMemoryMonitor.b();
    this.jdField_a_of_type_ComTencentAvAppGCameraAvailabilityMonitor.a();
  }
  
  private void e()
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
  
  private void f()
  {
    try
    {
      PowerManager localPowerManager = (PowerManager)getApp().getSystemService("power");
      if (!localPowerManager.isScreenOn()) {
        localPowerManager.newWakeLock(1, "VideoAppInterfaceOnCreateTag").acquire(10000L);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void g()
  {
    ThreadManager.post(this.jdField_a_of_type_JavaLangRunnable, 10, null, true);
  }
  
  private void h()
  {
    if ((AudioHelper.d()) && (BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 0).getBoolean("debug_qav", false)))
    {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "onCreate, 音视频进程在等待调试器连接(界面会无响应)");
      Debug.waitForDebugger();
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
  
  public VideoNotifyCenter a()
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
  
  public BusinessHandler a(int paramInt)
  {
    return this.jdField_a_of_type_ComTencentAvBusinessHandlerBusinessHandlerFactory.a(this, paramInt);
  }
  
  public BusinessInfoCheckUpdate.AppInfo a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.a(paramString);
  }
  
  public String a()
  {
    String str2 = getApp().getString(2131428698);
    Object localObject = a();
    String str1 = str2;
    if (localObject != null)
    {
      String str3 = ((VideoController)localObject).a().c;
      int i = ((VideoController)localObject).a().i;
      localObject = ((VideoController)localObject).a().e;
      str1 = str2;
      if (i == 9500) {
        str1 = getDisplayName(i, str3, (String)localObject) + getApp().getString(2131428699);
      }
    }
    return str1;
  }
  
  public String a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.b(paramString);
  }
  
  public Map a()
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
    QLog.d(jdField_a_of_type_JavaLangString, 1, "exitVideoProcess reason = " + paramInt + ",videoController = " + this.jdField_a_of_type_ComTencentAvVideoController);
    try
    {
      if (this.jdField_a_of_type_ComTencentAvVideoController != null)
      {
        int i = this.jdField_a_of_type_ComTencentAvVideoController.a().g;
        if ((i > 0) && (i <= 4))
        {
          String str = this.jdField_a_of_type_ComTencentAvVideoController.a().c;
          this.jdField_a_of_type_ComTencentAvVideoController.a(str, 0);
          this.jdField_a_of_type_ComTencentAvVideoController.b(220);
          this.jdField_a_of_type_ComTencentAvVideoController.c(str, 0);
        }
        for (;;)
        {
          this.jdField_a_of_type_ComTencentAvVideoController.r = false;
          b(paramInt);
          return;
          if (this.jdField_a_of_type_ComTencentAvVideoController.e) {
            this.jdField_a_of_type_ComTencentAvVideoController.a(this.jdField_a_of_type_ComTencentAvVideoController.c, this.jdField_a_of_type_ComTencentAvVideoController.a, 72);
          }
        }
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
  
  public void a(long paramLong1, String paramString, long paramLong2)
  {
    this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.a(paramLong1, paramString, paramLong2);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    QLog.d(jdField_a_of_type_JavaLangString, 2, "receiveToService");
    this.jdField_a_of_type_ComTencentAvBusinessMsfServletProxy.a(paramFromServiceMsg.isSuccess(), paramToServiceMsg, paramFromServiceMsg, null);
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
  
  public int[] a()
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.a();
  }
  
  public long[] a(String paramString)
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.a(paramString);
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
  
  public int b()
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.a();
  }
  
  public int b(String paramString)
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.b(paramString);
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
    this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.c();
  }
  
  public void b(int paramInt)
  {
    int i = paramInt;
    if (paramInt < 200) {
      i = paramInt + 200;
    }
    QLog.d(jdField_a_of_type_JavaLangString, 1, "video exit mIsExit " + this.e + ", reason = " + i + "|" + this.jdField_a_of_type_ComTencentAvBusinessManagerBusinessManagerFactory, new Throwable());
    if (this.e) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentAvBusinessManagerBusinessManagerFactory != null) {}
    this.e = true;
    if ((this.jdField_a_of_type_ComTencentAvVideoController != null) && (this.jdField_a_of_type_ComTencentAvVideoController.a() != null))
    {
      if (!this.jdField_a_of_type_ComTencentAvVideoController.a().E) {
        break label285;
      }
      ReportController.b(null, "CliOper", "", "", "0X8008AAD", "0X8008AAD", 0, 0, "", "", "", "");
    }
    for (;;)
    {
      if ((this.b) && (this.jdField_a_of_type_ComTencentAvVideoController != null)) {
        this.jdField_a_of_type_ComTencentAvVideoController.M();
      }
      this.b = false;
      SmallScreenUtils.a(getApplication());
      AVLog.d(jdField_a_of_type_JavaLangString, "exit video process clearNotification");
      new QNotificationManager(getApplication().getApplicationContext()).cancel(jdField_a_of_type_JavaLangString, 2130840368);
      Object localObject = (AudioManager)getApplication().getApplicationContext().getSystemService("audio");
      if (localObject != null)
      {
        ((AudioManager)localObject).setSpeakerphoneOn(this.jdField_a_of_type_Boolean);
        ((AudioManager)localObject).setMode(this.jdField_a_of_type_Int);
      }
      localObject = QAVNotification.a(this);
      if (localObject != null) {
        ((QAVNotification)localObject).a();
      }
      AVLog.d(jdField_a_of_type_JavaLangString, "force exit video process ...");
      QLog.flushLog();
      return;
      label285:
      ReportController.b(null, "CliOper", "", "", "0X8008AAC", "0X8008AAC", 0, 0, "", "", "", "");
    }
  }
  
  public void b(int paramInt, String paramString)
  {
    this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.a(paramInt, paramString);
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
  
  public boolean b()
  {
    if (this.jdField_a_of_type_JavaLangRunnable != null)
    {
      QLog.w(jdField_a_of_type_JavaLangString, 1, "supportStatusBarDarkMode, 正在获取中");
      return false;
    }
    return ImmersiveUtils.a();
  }
  
  public boolean b(IAVRedPacketCallback paramIAVRedPacketCallback)
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.b(paramIAVRedPacketCallback);
  }
  
  public boolean b(String paramString)
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.b(paramString);
  }
  
  public boolean b(String paramString, int paramInt)
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.b(paramString, paramInt);
  }
  
  public int c()
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.b();
  }
  
  public String c(String paramString)
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.d(paramString);
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
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.b();
  }
  
  public boolean c(String paramString)
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.c(paramString);
  }
  
  public int d()
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.d();
  }
  
  public void d(int paramInt)
  {
    this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.a(paramInt);
  }
  
  public void d(String paramString)
  {
    this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.b(paramString);
  }
  
  public boolean d()
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.c();
  }
  
  public int e()
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.c();
  }
  
  public void e(String paramString)
  {
    this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.c(paramString);
  }
  
  public boolean e()
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.d();
  }
  
  public void f(String paramString)
  {
    this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.d(paramString);
  }
  
  public boolean f()
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.e();
  }
  
  public boolean g()
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.f();
  }
  
  public BaseApplication getApp()
  {
    return this.app;
  }
  
  public int getAppid()
  {
    return AppSetting.jdField_a_of_type_Int;
  }
  
  public List getBusinessObserver(int paramInt)
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
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.b(paramInt, paramString1, paramString2);
  }
  
  public EntityManagerFactory getEntityManagerFactory(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory == null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory = new QQEntityManagerFactory(getAccount());
    }
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  }
  
  protected Class[] getMessagePushServlets()
  {
    return new Class[] { VideoServlet.class };
  }
  
  public INetEngine getNetEngine(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory == null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory = new NetEngineFactory();
    }
    return this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory.a(this, paramInt);
  }
  
  public boolean h()
  {
    return this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.a();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AudioHelper.b("VideoAppInterface.onCreate.begin");
    UpdateAvSo.a();
    this.c = true;
    VideoNodeManager.a(this);
    VideoNodeManager.a();
    VideoNodeManager.a(27);
    long l1 = System.currentTimeMillis();
    super.onCreate(paramBundle);
    h();
    AudioHelper.b("VideoAppInterface.onCreate.begin1");
    AudioHelper.a(this);
    f();
    new InitMemoryCache().c();
    new InitUrlDrawable().c();
    getEntityManagerFactory(null);
    this.jdField_a_of_type_ComTencentAvAppMSFNetInfoMonitor = new MSFNetInfoMonitor(this);
    AppNetConnInfo.registerConnectionChangeReceiver(getApplication(), this.jdField_a_of_type_ComTencentAvAppMSFNetInfoMonitor);
    e();
    AudioHelper.a(this.app, getLongAccountUin());
    AudioHelper.a(this.app.getApplicationContext());
    this.jdField_a_of_type_ComTencentAvAppDeviceCapabilityExamination = new DeviceCapabilityExamination(this);
    this.jdField_a_of_type_Jgo = new jgo(this);
    this.jdField_a_of_type_Jgl = new jgl(this);
    this.jdField_a_of_type_ComTencentAvAppGKillProcessMonitor = new GKillProcessMonitor(this);
    this.jdField_a_of_type_ComTencentAvAppGVipFunCallMonitor = new GVipFunCallMonitor(this);
    this.jdField_a_of_type_ComTencentAvAppGAudioExitMonitor = new GAudioExitMonitor(this);
    this.jdField_a_of_type_ComTencentAvAppGBatteryMonitor = new GBatteryMonitor(this);
    this.jdField_a_of_type_ComTencentAvAppGScreenActionMonitor = new GScreenActionMonitor(this);
    this.jdField_a_of_type_ComTencentAvAppGMemoryMonitor = new GMemoryMonitor(this);
    this.jdField_a_of_type_ComTencentAvAppGCameraAvailabilityMonitor = new GCameraAvailabilityMonitor(this);
    this.jdField_a_of_type_ComTencentAvAppQQServiceProxy = new QQServiceProxy(this);
    this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.a();
    this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.c();
    this.jdField_a_of_type_ComTencentAvAppAVServiceProxy = new AVServiceProxy(this);
    this.jdField_a_of_type_ComTencentAvAppAVServiceProxy.a();
    AVReport.a().a();
    c();
    ThreadManager.post(new jhc(this), 5, null, true);
    this.jdField_a_of_type_JavaUtilList = new Vector();
    g();
    this.jdField_a_of_type_ComTencentAvBusinessMsfServletProxy = new MsfServletProxy(this);
    this.jdField_a_of_type_ComTencentAvBusinessHandlerBusinessHandlerFactory = new BusinessHandlerFactory();
    this.jdField_a_of_type_ComTencentAvBusinessManagerBusinessManagerFactory = new BusinessManagerFactory(this);
    this.jdField_a_of_type_ComTencentAvBusinessManagerBusinessMessageCenter = new BusinessMessageCenter(this);
    this.jdField_a_of_type_ComTencentAvBusinessHandlerBusinessHandlerFactory.a(this.jdField_a_of_type_ComTencentAvBusinessMsfServletProxy);
    d();
    if (QLog.isDevelopLevel())
    {
      long l2 = System.currentTimeMillis();
      QLog.d("IVR_TS_" + jdField_a_of_type_JavaLangString, 4, String.format("VideoAppInterface onCreate(), cost=%dms", new Object[] { Long.valueOf(l2 - l1) }));
    }
    AudioHelper.b("VideoAppInterface.onCreate.end");
  }
  
  protected void onDestroy()
  {
    this.jdField_a_of_type_JavaLangRunnable = null;
    this.jdField_a_of_type_ComTencentAvAppAVServiceProxy.b();
    this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.b();
    this.jdField_a_of_type_ComTencentAvAppQQServiceProxy.d();
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory.onDestroy();
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory = null;
      PtvTemplateManager.b();
      AVRedPacketManager.b();
      this.jdField_a_of_type_ComTencentAvAppGScreenActionMonitor.b();
      this.jdField_a_of_type_ComTencentAvAppGMemoryMonitor.a();
      this.jdField_a_of_type_Jgo.a();
      this.jdField_a_of_type_Jgl.a();
      this.jdField_a_of_type_ComTencentAvAppGKillProcessMonitor.b();
      this.jdField_a_of_type_ComTencentAvAppGVipFunCallMonitor.b();
      this.jdField_a_of_type_ComTencentAvAppGAudioExitMonitor.b();
      this.jdField_a_of_type_ComTencentAvAppGBatteryMonitor.b();
      this.jdField_a_of_type_ComTencentAvAppGCameraAvailabilityMonitor.b();
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
  
  public void removeObserver(BusinessObserver paramBusinessObserver)
  {
    this.jdField_a_of_type_JavaUtilList.remove(paramBusinessObserver);
  }
  
  public void sendToService(ToServiceMsg paramToServiceMsg)
  {
    AVLog.c(jdField_a_of_type_JavaLangString, "sendToService");
    this.jdField_a_of_type_ComTencentAvBusinessMsfServletProxy.a(paramToServiceMsg, null, VideoServlet.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.av.app.VideoAppInterface
 * JD-Core Version:    0.7.0.1
 */
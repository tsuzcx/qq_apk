package com.tencent.avgame.app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.os.SystemClock;
import android.support.v4.util.MQLruCache;
import com.tencent.av.app.MSFNetInfoMonitor;
import com.tencent.av.app.MSFNetInfoMonitor.IApnChangeListener;
import com.tencent.avgame.business.handler.HandlerFactory;
import com.tencent.avgame.business.observer.NetObserver;
import com.tencent.avgame.business.observer.ObserverCenter;
import com.tencent.avgame.floatwindow.FloatWindowController;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.globalmanage.GlobalExitRoomDialog;
import com.tencent.avgame.ipc.AVGameClientQIPCModule;
import com.tencent.avgame.ipc.AccountReceiver.AccountListener;
import com.tencent.avgame.ipc.BroadcastCenter;
import com.tencent.avgame.ipc.ProcessMonitor;
import com.tencent.avgame.qav.AVGameBusinessCtrl;
import com.tencent.avgame.qav.IAVGameBusinessCtrl;
import com.tencent.avgame.report.AVGamePerfReporter;
import com.tencent.avgame.util.CostTraceUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseAVGameAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.pic.URLDrawableDepWrapInit;
import com.tencent.mobileqq.qqvideoplatform.api.QQVideoPlaySDKManager;
import com.tencent.mobileqq.service.MobileQQServiceBase;
import com.tencent.mobileqq.transfile.DiskCache;
import com.tencent.mobileqq.transfile.NetEngineFactory;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qav.channel.VideoChannelServlet;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.memory.MemoryManager;
import java.io.File;
import java.util.List;
import mqq.app.MSFServlet;
import mqq.app.MobileQQ;

public class AVGameAppInterface
  extends BaseAVGameAppInterface
  implements MSFNetInfoMonitor.IApnChangeListener, IAVGameAppInterface, AccountReceiver.AccountListener, SDKInitListener
{
  private static boolean g = false;
  private QQEntityManagerFactory a = null;
  private NetEngineFactory b = null;
  private AVGameService c = null;
  private HandlerFactory d = null;
  private AVGameClientQIPCModule e = null;
  private BroadcastCenter f = null;
  private MSFNetInfoMonitor h = null;
  private int i = -2147483648;
  
  public AVGameAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
    ProcessMonitor.a().b();
    AVGamePerfReporter.a().a("param_AVGameInit");
    CostTraceUtil.a().a("AVGameCostTrace");
    if (QLog.isColorLevel())
    {
      paramBaseApplicationImpl = new StringBuilder();
      paramBaseApplicationImpl.append("init av game app interface [");
      paramBaseApplicationImpl.append(paramString);
      paramBaseApplicationImpl.append("]");
      QLog.i("AVGameAppInterface", 2, paramBaseApplicationImpl.toString());
    }
  }
  
  private void d()
  {
    if (!g)
    {
      BaseApplication localBaseApplication = BaseApplicationImpl.getContext();
      if ("mounted".equals(Environment.getExternalStorageState())) {
        localFile = new File(VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH));
      } else {
        localFile = localBaseApplication.getCacheDir();
      }
      URLDrawable.init(URLDrawableDepWrapInit.a(), new AVGameAppInterface.3(this, localBaseApplication));
      File localFile = new File(localFile, "diskcache");
      com.tencent.mobileqq.startup.step.InitUrlDrawable.b = new DiskCache(localFile);
      com.tencent.mobileqq.transfile.URLDrawableHelper.diskCachePath = localFile;
      g = true;
    }
  }
  
  public AVGameClientQIPCModule a()
  {
    return this.e;
  }
  
  public void a(int paramInt)
  {
    int j = this.i;
    int k = MSFNetInfoMonitor.b();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onApnChanged, [");
      localStringBuilder.append(j);
      localStringBuilder.append("] --> [");
      localStringBuilder.append(k);
      localStringBuilder.append("], from[");
      localStringBuilder.append(paramInt);
      localStringBuilder.append("]");
      QLog.i("AVGameAppInterface", 2, localStringBuilder.toString());
    }
    if (j != k)
    {
      this.i = k;
      ObserverCenter.a().a(NetObserver.class, 1, true, new Object[] { Integer.valueOf(j), Integer.valueOf(paramInt) });
    }
  }
  
  public void addObserver(BusinessObserver paramBusinessObserver)
  {
    ObserverCenter.a().a(paramBusinessObserver);
  }
  
  public void addObserver(BusinessObserver paramBusinessObserver, boolean paramBoolean)
  {
    ObserverCenter.a().a(paramBusinessObserver, paramBoolean);
  }
  
  public void b()
  {
    if (GlobalImageCache.a == null)
    {
      int j = (int)(MemoryManager.d() / 10L);
      GlobalImageCache.a = new MQLruCache(j);
      GlobalImageCache.c = j;
    }
  }
  
  public void b(int paramInt)
  {
    long l = SystemClock.elapsedRealtime();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("exitVideoProcess, reason[");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append("]");
    QLog.i("AVGameAppInterface", 1, ((StringBuilder)localObject).toString());
    GameEngine.a().a(2, null, GameEngine.a().s());
    localObject = new Intent("tencent.avgame.g2q.exit");
    ((Intent)localObject).putExtra("key_exit_code", paramInt);
    getApp().sendBroadcast((Intent)localObject);
    QLog.flushLog(true);
    getApplication().otherProcessExit(false);
    localObject = this.e;
    if (localObject != null) {
      ((AVGameClientQIPCModule)localObject).a();
    }
    ProcessMonitor.a().c();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("exitVideoProcess, cost[");
    ((StringBuilder)localObject).append(SystemClock.elapsedRealtime() - l);
    ((StringBuilder)localObject).append("]");
    QLog.i("AVGameAppInterface", 1, ((StringBuilder)localObject).toString());
    try
    {
      Thread.sleep(300L);
      label182:
      if (paramInt == 1006) {
        System.exit(0);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      break label182;
    }
  }
  
  public IAVGameBusinessCtrl c()
  {
    return AVGameBusinessCtrl.a();
  }
  
  public BaseApplication getApp()
  {
    return this.app;
  }
  
  public int getAppid()
  {
    return AppSetting.d();
  }
  
  public List<BusinessObserver> getBusinessObserver(int paramInt)
  {
    return ObserverCenter.a().a(paramInt);
  }
  
  public String getCurrentAccountUin()
  {
    return getAccount();
  }
  
  public EntityManagerFactory getEntityManagerFactory(String paramString)
  {
    if (this.a == null) {
      this.a = QQEntityManagerFactoryProxy.a(getAccount(), super.getEntityManagerFactory());
    }
    return this.a;
  }
  
  protected String[] getMessagePushSSOCommands()
  {
    return new String[] { "OnlinePush.ReqPush" };
  }
  
  protected Class<? extends MSFServlet>[] getMessagePushServlets()
  {
    return new Class[] { AVGameServlet.class, VideoChannelServlet.class };
  }
  
  public MobileQQServiceBase getMobileQQService()
  {
    return this.c;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    ProcessMonitor.a().a("AVGameAppInterface_onCreate");
    CostTraceUtil.a().b("AppInterfaceCreate");
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("AVGameAppInterface", 2, "onCreate");
    }
    QQAudioHelper.a((BaseApplicationImpl)this.app, getLongAccountUin());
    getEntityManagerFactory(null);
    this.c = new AVGameService(this);
    this.d = new HandlerFactory();
    b();
    this.e = new AVGameClientQIPCModule(this);
    this.f = new BroadcastCenter(this);
    ThreadManager.excute(new AVGameAppInterface.1(this), 16, null, true);
    GameEngine.a().a(this);
    d();
    FloatWindowController.c().a(this);
    GlobalExitRoomDialog.a().b();
    ThreadManager.excute(new AVGameAppInterface.2(this), 16, null, false);
    this.h = new MSFNetInfoMonitor(this);
    AppNetConnInfo.registerConnectionChangeReceiver(getApplication(), this.h);
    if (!QQVideoPlaySDKManager.isSDKReady()) {
      QQVideoPlaySDKManager.initSDKAsync(BaseApplicationImpl.getContext(), this);
    }
    CostTraceUtil.a().c("AppInterfaceCreate");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.e;
    if (localObject != null) {
      ((AVGameClientQIPCModule)localObject).a();
    }
    localObject = this.f;
    if (localObject != null)
    {
      ((BroadcastCenter)localObject).b();
      this.f = null;
    }
    ObserverCenter.a().b();
    GameEngine.a().c();
    AVGameBusinessCtrl.c();
    FloatWindowController.c().g();
    GlobalExitRoomDialog.a().c();
    if (QLog.isColorLevel()) {
      QLog.i("AVGameAppInterface", 2, "onDestroy");
    }
  }
  
  public void onSDKInited(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSDKInited ");
    localStringBuilder.append(paramBoolean);
    QLog.d("AVGameAppInterface", 1, localStringBuilder.toString());
  }
  
  public void removeObserver(BusinessObserver paramBusinessObserver)
  {
    ObserverCenter.a().b(paramBusinessObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.app.AVGameAppInterface
 * JD-Core Version:    0.7.0.1
 */
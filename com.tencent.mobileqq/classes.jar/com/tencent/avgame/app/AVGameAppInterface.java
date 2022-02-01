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
import com.tencent.avgame.util.AVGamePerfReporter;
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
import com.tencent.mobileqq.utils.AudioHelper;
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
  implements MSFNetInfoMonitor.IApnChangeListener, AccountReceiver.AccountListener, SDKInitListener
{
  private static boolean jdField_a_of_type_Boolean = false;
  private int jdField_a_of_type_Int = -2147483648;
  private MSFNetInfoMonitor jdField_a_of_type_ComTencentAvAppMSFNetInfoMonitor = null;
  private AVGameService jdField_a_of_type_ComTencentAvgameAppAVGameService = null;
  private HandlerFactory jdField_a_of_type_ComTencentAvgameBusinessHandlerHandlerFactory = null;
  private AVGameClientQIPCModule jdField_a_of_type_ComTencentAvgameIpcAVGameClientQIPCModule = null;
  private BroadcastCenter jdField_a_of_type_ComTencentAvgameIpcBroadcastCenter = null;
  private QQEntityManagerFactory jdField_a_of_type_ComTencentMobileqqDataQQEntityManagerFactory = null;
  private NetEngineFactory jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory = null;
  
  public AVGameAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
    ProcessMonitor.a().a();
    AVGamePerfReporter.a().a("param_AVGameInit");
    CostTraceUtil.a().a("AVGameCostTrace");
    if (QLog.isColorLevel()) {
      QLog.i("AVGameAppInterface", 2, "init av game app interface [" + paramString + "]");
    }
  }
  
  private void b()
  {
    BaseApplication localBaseApplication;
    if (!jdField_a_of_type_Boolean)
    {
      localBaseApplication = BaseApplicationImpl.getContext();
      if (!"mounted".equals(Environment.getExternalStorageState())) {
        break label81;
      }
    }
    label81:
    for (File localFile = new File(VFSAssistantUtils.getSDKPrivatePath(AppConstants.SDCARD_PATH));; localFile = localBaseApplication.getCacheDir())
    {
      URLDrawable.init(URLDrawableDepWrapInit.a(), new AVGameAppInterface.3(this, localBaseApplication));
      localFile = new File(localFile, "diskcache");
      com.tencent.mobileqq.startup.step.InitUrlDrawable.a = new DiskCache(localFile);
      com.tencent.mobileqq.transfile.URLDrawableHelper.diskCachePath = localFile;
      jdField_a_of_type_Boolean = true;
      return;
    }
  }
  
  public AVGameClientQIPCModule a()
  {
    return this.jdField_a_of_type_ComTencentAvgameIpcAVGameClientQIPCModule;
  }
  
  public void a()
  {
    if (GlobalImageCache.jdField_a_of_type_AndroidSupportV4UtilMQLruCache == null)
    {
      long l = MemoryManager.a() / 10L;
      GlobalImageCache.jdField_a_of_type_AndroidSupportV4UtilMQLruCache = new MQLruCache((int)l);
      GlobalImageCache.jdField_a_of_type_Int = (int)l;
    }
  }
  
  public void a(int paramInt)
  {
    int i = this.jdField_a_of_type_Int;
    int j = MSFNetInfoMonitor.b();
    if (QLog.isColorLevel()) {
      QLog.i("AVGameAppInterface", 2, "onApnChanged, [" + i + "] --> [" + j + "], from[" + paramInt + "]");
    }
    if (i != j)
    {
      this.jdField_a_of_type_Int = j;
      ObserverCenter.a().a(NetObserver.class, 1, true, new Object[] { Integer.valueOf(i), Integer.valueOf(paramInt) });
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
  
  public void b(int paramInt)
  {
    long l = SystemClock.elapsedRealtime();
    QLog.i("AVGameAppInterface", 1, "exitVideoProcess, reason[" + paramInt + "]");
    GameEngine.a().a(2, null, GameEngine.a().a());
    Intent localIntent = new Intent("tencent.avgame.g2q.exit");
    localIntent.putExtra("key_exit_code", paramInt);
    getApp().sendBroadcast(localIntent);
    QLog.flushLog(true);
    getApplication().otherProcessExit(false);
    if (this.jdField_a_of_type_ComTencentAvgameIpcAVGameClientQIPCModule != null) {
      this.jdField_a_of_type_ComTencentAvgameIpcAVGameClientQIPCModule.a();
    }
    ProcessMonitor.a().b();
    QLog.i("AVGameAppInterface", 1, "exitVideoProcess, cost[" + (SystemClock.elapsedRealtime() - l) + "]");
    try
    {
      Thread.sleep(300L);
      label153:
      if (paramInt == 1006) {
        System.exit(0);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      break label153;
    }
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
    return ObserverCenter.a().a(paramInt);
  }
  
  public String getCurrentAccountUin()
  {
    return getAccount();
  }
  
  public EntityManagerFactory getEntityManagerFactory(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataQQEntityManagerFactory == null) {
      this.jdField_a_of_type_ComTencentMobileqqDataQQEntityManagerFactory = QQEntityManagerFactoryProxy.a(getAccount(), super.getEntityManagerFactory());
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataQQEntityManagerFactory;
  }
  
  public String[] getMessagePushSSOCommands()
  {
    return new String[] { "OnlinePush.ReqPush" };
  }
  
  public Class<? extends MSFServlet>[] getMessagePushServlets()
  {
    return new Class[] { AVGameServlet.class, VideoChannelServlet.class };
  }
  
  public MobileQQServiceBase getMobileQQService()
  {
    return this.jdField_a_of_type_ComTencentAvgameAppAVGameService;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    ProcessMonitor.a().a("AVGameAppInterface_onCreate");
    CostTraceUtil.a().b("AppInterfaceCreate");
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.i("AVGameAppInterface", 2, "onCreate");
    }
    AudioHelper.a((BaseApplicationImpl)this.app, getLongAccountUin());
    getEntityManagerFactory(null);
    this.jdField_a_of_type_ComTencentAvgameAppAVGameService = new AVGameService(this);
    this.jdField_a_of_type_ComTencentAvgameBusinessHandlerHandlerFactory = new HandlerFactory();
    a();
    this.jdField_a_of_type_ComTencentAvgameIpcAVGameClientQIPCModule = new AVGameClientQIPCModule(this);
    this.jdField_a_of_type_ComTencentAvgameIpcBroadcastCenter = new BroadcastCenter(this);
    ThreadManager.excute(new AVGameAppInterface.1(this), 16, null, true);
    GameEngine.a().a(this);
    b();
    FloatWindowController.a().a(this);
    GlobalExitRoomDialog.a().a();
    ThreadManager.excute(new AVGameAppInterface.2(this), 16, null, false);
    this.jdField_a_of_type_ComTencentAvAppMSFNetInfoMonitor = new MSFNetInfoMonitor(this);
    AppNetConnInfo.registerConnectionChangeReceiver(getApplication(), this.jdField_a_of_type_ComTencentAvAppMSFNetInfoMonitor);
    if (!QQVideoPlaySDKManager.a()) {
      QQVideoPlaySDKManager.a(BaseApplicationImpl.getContext(), this);
    }
    CostTraceUtil.a().c("AppInterfaceCreate");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.jdField_a_of_type_ComTencentAvgameIpcAVGameClientQIPCModule != null) {
      this.jdField_a_of_type_ComTencentAvgameIpcAVGameClientQIPCModule.a();
    }
    if (this.jdField_a_of_type_ComTencentAvgameIpcBroadcastCenter != null)
    {
      this.jdField_a_of_type_ComTencentAvgameIpcBroadcastCenter.b();
      this.jdField_a_of_type_ComTencentAvgameIpcBroadcastCenter = null;
    }
    ObserverCenter.a().a();
    GameEngine.a().b();
    AVGameBusinessCtrl.a();
    FloatWindowController.a().f();
    GlobalExitRoomDialog.a().b();
    if (QLog.isColorLevel()) {
      QLog.i("AVGameAppInterface", 2, "onDestroy");
    }
  }
  
  public void onSDKInited(boolean paramBoolean)
  {
    QLog.d("AVGameAppInterface", 1, "onSDKInited " + paramBoolean);
  }
  
  public void removeObserver(BusinessObserver paramBusinessObserver)
  {
    ObserverCenter.a().b(paramBusinessObserver);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.app.AVGameAppInterface
 * JD-Core Version:    0.7.0.1
 */
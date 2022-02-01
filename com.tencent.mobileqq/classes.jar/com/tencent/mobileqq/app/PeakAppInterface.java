package com.tencent.mobileqq.app;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.accessibility.AccessibilityManager;
import com.tencent.aelight.camera.api.IAEClassManager;
import com.tencent.aelight.camera.api.IAEEditorProcess;
import com.tencent.aelight.camera.api.IPeakJceService;
import com.tencent.aelight.camera.log.AEQLog;
import com.tencent.aelight.camera.qqstory.api.IAsyncControl;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.takevideo.slideshow.TransitionHandler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseToolAppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.message.messageclean.MessageCleanManager;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.MessageRecordEntityManager;
import com.tencent.mobileqq.persistence.QQEntityManagerFactoryProxy;
import com.tencent.mobileqq.persistence.qslowtable.QSlowTableEntityManagerFactory;
import com.tencent.mobileqq.pic.PresendPicMgr;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.RichmediaClient;
import com.tencent.mobileqq.richmedia.server.PeakAudioTransHandler;
import com.tencent.mobileqq.richmedia.server.PeakMsfServletProxy;
import com.tencent.mobileqq.servlet.AudioTransServlet;
import com.tencent.mobileqq.startup.step.DtSdkInitStep;
import com.tencent.mobileqq.startup.step.InitMemoryCache;
import com.tencent.mobileqq.startup.step.InitUrlDrawable;
import com.tencent.mobileqq.transfile.NetEngineFactory;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.util.QZLog;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.IToolProcEventListener;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

public class PeakAppInterface
  extends BaseToolAppInterface
  implements IToolProcEventListener
{
  public static final String a;
  public static final String b;
  public static final String c = MiniCodePeakHandler.class.getName();
  public static final String d = ((IAEClassManager)QRoute.api(IAEClassManager.class)).getCameraPeakServiceHandlerClass().getName();
  public static final String e = ((IAEClassManager)QRoute.api(IAEClassManager.class)).getAEEditorDataServiceHandlerClass().getName();
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new PeakAppInterface.1(this);
  private IPeakJceService jdField_a_of_type_ComTencentAelightCameraApiIPeakJceService;
  private QQStoryContext jdField_a_of_type_ComTencentBizQqstoryAppQQStoryContext;
  private PeakAppCrashReporter jdField_a_of_type_ComTencentMobileqqAppPeakAppCrashReporter;
  private EntityManagerFactory jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  private MessageRecordEntityManager jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager;
  private PeakMsfServletProxy jdField_a_of_type_ComTencentMobileqqRichmediaServerPeakMsfServletProxy;
  private NetEngineFactory jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory = null;
  private ConcurrentHashMap<Integer, Manager> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(5);
  public boolean a;
  private boolean b;
  private String f = "";
  
  static
  {
    jdField_a_of_type_JavaLangString = PeakAudioTransHandler.class.getName();
    jdField_b_of_type_JavaLangString = TransitionHandler.class.getName();
  }
  
  public PeakAppInterface(BaseApplicationImpl paramBaseApplicationImpl, String paramString)
  {
    super(paramBaseApplicationImpl, paramString);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
  }
  
  private boolean a()
  {
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("tencent.peak.q2v.AudioTransPush");
    this.app.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
    return this.app.registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter) != null;
  }
  
  private boolean a(BaseApplication paramBaseApplication, Intent paramIntent)
  {
    AEQLog.d("PeakAppInterface", "exitPeakRunTime");
    paramBaseApplication = paramIntent.getAction();
    if (paramBaseApplication == null) {
      return false;
    }
    if (paramBaseApplication.equals("com.tencent.process.exit"))
    {
      boolean bool = ((IAEEditorProcess)QRoute.api(IAEEditorProcess.class)).isGenerateWorking();
      paramBaseApplication = new StringBuilder();
      paramBaseApplication.append("isGenerateWorking");
      paramBaseApplication.append(bool);
      AEQLog.d("PeakAppInterface", paramBaseApplication.toString());
      return bool;
    }
    return false;
  }
  
  public QQStoryContext a()
  {
    return this.jdField_a_of_type_ComTencentBizQqstoryAppQQStoryContext;
  }
  
  public SQLiteDatabase a()
  {
    Object localObject = getCurrentAccountUin();
    localObject = new QSlowTableEntityManagerFactory((String)localObject).build((String)localObject);
    if (localObject != null) {
      return ((SQLiteOpenHelper)localObject).getReadableDatabase();
    }
    return null;
  }
  
  public MessageRecordEntityManager a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager == null)
    {
      String str = getCurrentAccountUin();
      this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager = new MessageRecordEntityManager(((QQEntityManagerFactory)getEntityManagerFactory(str)).build(str), str);
    }
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryAppQQStoryContext = new QQStoryContext();
    this.jdField_a_of_type_ComTencentBizQqstoryAppQQStoryContext.a();
  }
  
  public void a(String paramString)
  {
    this.f = paramString;
  }
  
  public void b()
  {
    for (;;)
    {
      try
      {
        AccessibilityManager localAccessibilityManager = (AccessibilityManager)this.app.getSystemService("accessibility");
        bool1 = localAccessibilityManager.isEnabled();
        boolean bool2 = localAccessibilityManager.isTouchExplorationEnabled();
        if ((bool1) && (bool2))
        {
          bool1 = true;
          AppSetting.d = bool1;
          return;
        }
      }
      catch (Throwable localThrowable)
      {
        return;
      }
      boolean bool1 = false;
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
  
  public String getCurrentAccountUin()
  {
    return getAccount();
  }
  
  public String getCurrentNickname()
  {
    return this.f;
  }
  
  public EntityManagerFactory getEntityManagerFactory(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory == null) {
      this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory = QQEntityManagerFactoryProxy.a(getAccount(), super.getEntityManagerFactory());
    }
    return this.jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  }
  
  public Manager getManager(int paramInt)
  {
    Object localObject2 = (Manager)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      if (paramInt == 4) {
        localObject2 = new MessageCleanManager();
      }
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt)) != null)
      {
        localObject1 = (Manager)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
      }
      else
      {
        localObject1 = localObject2;
        if (localObject2 != null)
        {
          this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localObject2);
          localObject1 = localObject2;
        }
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = super.getManager(paramInt);
    }
    return localObject2;
  }
  
  public String getModuleId()
  {
    return "peak";
  }
  
  public SQLiteDatabase getReadableDatabase()
  {
    Object localObject = getCurrentAccountUin();
    localObject = ((QQEntityManagerFactory)getEntityManagerFactory((String)localObject)).build((String)localObject);
    if (localObject != null) {
      return ((SQLiteOpenHelper)localObject).getReadableDatabase();
    }
    return null;
  }
  
  public void onBeforeExitProc()
  {
    AEQLog.d("PeakAppInterface", "onBeforeExitProc");
    ((IAEEditorProcess)QRoute.api(IAEEditorProcess.class)).clean();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    long l = System.currentTimeMillis();
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("PeakAppInterface", 2, "onCreate");
    }
    new InitMemoryCache().step();
    new InitUrlDrawable().step();
    a();
    this.jdField_b_of_type_Boolean = a();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaServerPeakMsfServletProxy = new PeakMsfServletProxy(this);
    this.jdField_a_of_type_ComTencentAelightCameraApiIPeakJceService = ((IPeakJceService)getRuntimeService(IPeakJceService.class, "all"));
    ((IAsyncControl)QRoute.api(IAsyncControl.class)).startPeakPreLoadAsyncStep();
    DtSdkInitStep.initDTSDK(0);
    this.jdField_a_of_type_ComTencentMobileqqAppPeakAppCrashReporter = new PeakAppCrashReporter();
    this.jdField_a_of_type_ComTencentMobileqqAppPeakAppCrashReporter.a();
    paramBundle = new StringBuilder();
    paramBundle.append("[onCreate...] + END, time cost:");
    paramBundle.append(System.currentTimeMillis() - l);
    QLog.d("[Performance2]PeakAppInterface", 1, paramBundle.toString());
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    RichmediaClient.a().b(BaseApplicationImpl.sApplication);
    Object localObject = PresendPicMgr.a(null);
    if (localObject != null) {
      ((PresendPicMgr)localObject).b();
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory;
    if (localObject != null) {}
    try
    {
      ((NetEngineFactory)localObject).onDestroy();
    }
    catch (Exception localException)
    {
      label42:
      break label42;
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory.onDestroy();
    this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory = null;
    if (this.jdField_b_of_type_Boolean)
    {
      this.app.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
      this.jdField_b_of_type_Boolean = false;
    }
    ((IAsyncControl)QRoute.api(IAsyncControl.class)).destory();
    this.jdField_a_of_type_ComTencentMobileqqAppPeakAppCrashReporter.b();
    if (QLog.isColorLevel()) {
      QLog.d("PeakAppInterface", 2, "onDestroy");
    }
  }
  
  public boolean onReceiveAccountAction(String paramString, Intent paramIntent)
  {
    AEQLog.b("PeakAppInterface", "onReceiveAccountAction");
    return false;
  }
  
  public boolean onReceiveLegalExitProcAction(Intent paramIntent)
  {
    AEQLog.d("PeakAppInterface", "onReceiveAccountAction");
    return a(BaseApplicationImpl.getContext(), paramIntent);
  }
  
  protected void onRunningBackground()
  {
    if (QZLog.isColorLevel()) {
      QZLog.i("PeakAppInterface", 2, "onRunningBackground");
    }
    super.onRunningBackground();
    this.jdField_a_of_type_ComTencentMobileqqAppPeakAppCrashReporter.c();
    LpReportManager.getInstance().startReportImediately(2);
  }
  
  protected void onRunningForeground()
  {
    super.onRunningForeground();
    ThreadManager.executeOnFileThread(new PeakAppInterface.2(this));
    this.jdField_a_of_type_ComTencentMobileqqAppPeakAppCrashReporter.d();
  }
  
  public void receiveToService(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ((!paramToServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetRecommandTextByEmotion")) && (!paramToServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetTextValidStatus")) && (!paramToServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetCameraConfig")) && (!paramToServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetCategoryMaterial")) && (!paramToServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetPlayShowCatMatTree")) && (!paramToServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetOnlineUserNum")) && (!paramToServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetFontData")) && (!paramToServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetImgValidStatus")) && (!paramToServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetBulkImageClassify")) && (!paramToServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetBigShowRecommend")) && (!paramToServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetCircleCatMatTree")))
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaServerPeakMsfServletProxy.a(paramFromServiceMsg.isSuccess(), paramToServiceMsg, paramFromServiceMsg, null);
      return;
    }
    IPeakJceService localIPeakJceService = this.jdField_a_of_type_ComTencentAelightCameraApiIPeakJceService;
    if (localIPeakJceService != null) {
      localIPeakJceService.handleResponse(paramFromServiceMsg.isSuccess(), paramToServiceMsg, paramFromServiceMsg);
    }
  }
  
  public void sendToService(ToServiceMsg paramToServiceMsg)
  {
    if ((!paramToServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetRecommandTextByEmotion")) && (!paramToServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetTextValidStatus")) && (!paramToServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetCameraConfig")) && (!paramToServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetCategoryMaterial")) && (!paramToServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetPlayShowCatMatTree")) && (!paramToServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetOnlineUserNum")) && (!paramToServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetFontData")) && (!paramToServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetImgValidStatus")) && (!paramToServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetBulkImageClassify")) && (!paramToServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetBigShowRecommend")) && (!paramToServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetCircleCatMatTree")))
    {
      this.jdField_a_of_type_ComTencentMobileqqRichmediaServerPeakMsfServletProxy.a(paramToServiceMsg, AudioTransServlet.class);
      return;
    }
    this.jdField_a_of_type_ComTencentAelightCameraApiIPeakJceService.handleRequest(paramToServiceMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.PeakAppInterface
 * JD-Core Version:    0.7.0.1
 */
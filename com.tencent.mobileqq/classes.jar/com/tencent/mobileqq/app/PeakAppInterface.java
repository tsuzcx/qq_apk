package com.tencent.mobileqq.app;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.accessibility.AccessibilityManager;
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
import com.tencent.mobileqq.richmedia.RichmediaClient;
import com.tencent.mobileqq.richmedia.server.PeakAudioTransHandler;
import com.tencent.mobileqq.richmedia.server.PeakMsfServletProxy;
import com.tencent.mobileqq.service.PeakJceService;
import com.tencent.mobileqq.servlet.AudioTransServlet;
import com.tencent.mobileqq.shortvideo.redbag.RedBagVideoManager;
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
import dov.com.qq.im.ae.config.CameraPeakServiceHandler;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.AEEditorProcessManager;
import dov.com.qq.im.aeeditor.manage.AEEditorDataServiceHandler;
import dov.com.qq.im.capture.control.CaptureAsyncControl;
import java.util.concurrent.ConcurrentHashMap;
import mqq.app.IToolProcEventListener;
import mqq.app.MobileQQ;
import mqq.manager.Manager;

public class PeakAppInterface
  extends BaseToolAppInterface
  implements IToolProcEventListener
{
  public static CaptureAsyncControl a;
  public static final String a;
  public static final String b;
  public static final String c = MiniCodePeakHandler.class.getName();
  public static final String d = CameraPeakServiceHandler.class.getName();
  public static final String e = AEEditorDataServiceHandler.class.getName();
  private BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver = new PeakAppInterface.1(this);
  private QQStoryContext jdField_a_of_type_ComTencentBizQqstoryAppQQStoryContext;
  private EntityManagerFactory jdField_a_of_type_ComTencentMobileqqPersistenceEntityManagerFactory;
  private MessageRecordEntityManager jdField_a_of_type_ComTencentMobileqqPersistenceMessageRecordEntityManager;
  private PeakMsfServletProxy jdField_a_of_type_ComTencentMobileqqRichmediaServerPeakMsfServletProxy;
  private PeakJceService jdField_a_of_type_ComTencentMobileqqServicePeakJceService;
  private NetEngineFactory jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory = null;
  private ConcurrentHashMap<Integer, Manager> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap(5);
  public boolean a;
  private boolean b;
  private String f = "";
  
  static
  {
    jdField_a_of_type_DovComQqImCaptureControlCaptureAsyncControl = new CaptureAsyncControl();
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
    if (paramBaseApplication == null) {}
    while (!paramBaseApplication.equals("com.tencent.process.exit")) {
      return false;
    }
    boolean bool = AEEditorProcessManager.a().a();
    AEQLog.d("PeakAppInterface", "isGenerateWorking" + bool);
    return bool;
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
    try
    {
      AccessibilityManager localAccessibilityManager = (AccessibilityManager)this.app.getSystemService("accessibility");
      boolean bool1 = localAccessibilityManager.isEnabled();
      boolean bool2 = localAccessibilityManager.isTouchExplorationEnabled();
      if ((bool1) && (bool2)) {}
      for (bool1 = true;; bool1 = false)
      {
        AppSetting.d = bool1;
        return;
      }
      return;
    }
    catch (Throwable localThrowable) {}
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
    if (localObject2 == null) {
      switch (paramInt)
      {
      default: 
        if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt)) != null) {
          localObject1 = (Manager)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
        }
        break;
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = super.getManager(paramInt);
      }
      return localObject2;
      localObject2 = new MessageCleanManager();
      break;
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt), localObject2);
        localObject1 = localObject2;
      }
    }
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
    AEEditorProcessManager.a().b();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("PeakAppInterface", 2, "onCreate");
    }
    new InitMemoryCache().step();
    new InitUrlDrawable().step();
    a();
    this.jdField_b_of_type_Boolean = a();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaServerPeakMsfServletProxy = new PeakMsfServletProxy(this);
    this.jdField_a_of_type_ComTencentMobileqqServicePeakJceService = new PeakJceService(this);
    jdField_a_of_type_DovComQqImCaptureControlCaptureAsyncControl.a("{1000,1002}");
    DtSdkInitStep.initDTSDK(0);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    RichmediaClient.a().b(BaseApplicationImpl.sApplication);
    PresendPicMgr localPresendPicMgr = PresendPicMgr.a(null);
    if (localPresendPicMgr != null) {
      localPresendPicMgr.b();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory != null) {}
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory.onDestroy();
      this.jdField_a_of_type_ComTencentMobileqqTransfileNetEngineFactory = null;
      if (this.jdField_b_of_type_Boolean)
      {
        this.app.unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
        this.jdField_b_of_type_Boolean = false;
      }
      if (this.jdField_a_of_type_Boolean) {
        RedBagVideoManager.a(this).a(this);
      }
      jdField_a_of_type_DovComQqImCaptureControlCaptureAsyncControl.a();
      if (QLog.isColorLevel()) {
        QLog.d("PeakAppInterface", 2, "onDestroy");
      }
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
  
  public void onRunningBackground()
  {
    if (QZLog.isColorLevel()) {
      QZLog.i("PeakAppInterface", 2, "onRunningBackground");
    }
    super.onRunningBackground();
    LpReportManager.getInstance().startReportImediately(2);
  }
  
  public void onRunningForeground()
  {
    super.onRunningForeground();
    ThreadManager.executeOnFileThread(new PeakAppInterface.2(this));
  }
  
  public void receiveToService(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if ((paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetRecommandTextByEmotion")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetTextValidStatus")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetCameraConfig")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetCompressedCategoryMaterialV2")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetPlayShowCatMatTree")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetOnlineUserNum")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetFontData")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetImgValidStatus")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetBulkImageClassify")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetBigShowRecommend")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetCircleCatMatTree")))
    {
      this.jdField_a_of_type_ComTencentMobileqqServicePeakJceService.a(paramFromServiceMsg.isSuccess(), paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaServerPeakMsfServletProxy.a(paramFromServiceMsg.isSuccess(), paramToServiceMsg, paramFromServiceMsg, null);
  }
  
  public void sendToService(ToServiceMsg paramToServiceMsg)
  {
    if ((paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetRecommandTextByEmotion")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetTextValidStatus")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetCameraConfig")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetCompressedCategoryMaterialV2")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetPlayShowCatMatTree")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetOnlineUserNum")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetFontData")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetImgValidStatus")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("CameraModuleSvc.GetBulkImageClassify")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetBigShowRecommend")) || (paramToServiceMsg.getServiceCmd().equalsIgnoreCase("ShadowBackendSvc.GetCircleCatMatTree")))
    {
      this.jdField_a_of_type_ComTencentMobileqqServicePeakJceService.a(paramToServiceMsg);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqRichmediaServerPeakMsfServletProxy.a(paramToServiceMsg, AudioTransServlet.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.PeakAppInterface
 * JD-Core Version:    0.7.0.1
 */
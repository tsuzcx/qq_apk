package com.tencent.mobileqq.ark.base;

import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.ark.ArkViewModel;
import com.tencent.ark.open.ArkAppConfigMgr;
import com.tencent.ark.open.ArkAppMgr;
import com.tencent.ark.open.ArkUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.ark.ArkAiAppCenter;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.ark.config.bean.ArkPlatformConfigBean;
import com.tencent.mobileqq.ark.config.config.ArkPlatformConfig;
import com.tencent.mobileqq.ark.config.processor.ArkConfProcessor;
import com.tencent.mobileqq.ark.core.ArkAppCGI;
import com.tencent.mobileqq.ark.core.ArkAppCGI.ArkAppCGICallback;
import com.tencent.mobileqq.ark.core.ArkAppPreDownloadMgr;
import com.tencent.mobileqq.ark.core.ArkAppSSO;
import com.tencent.mobileqq.ark.dict.api.IArkDictManager;
import com.tencent.mobileqq.ark.module.ArkAppNotifyCenter;
import com.tencent.mobileqq.ark.multiproc.ArkMultiProcUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class ArkAppCenter
{
  private static boolean jdField_a_of_type_Boolean = false;
  private final int jdField_a_of_type_Int = 0;
  private final IGuardInterface jdField_a_of_type_ComTencentMobileqqAppGuardGuardinterfaceIGuardInterface = new ArkAppCenter.1(this);
  private final ArkAiAppCenter jdField_a_of_type_ComTencentMobileqqArkArkAiAppCenter;
  private final ArkAppCenter.ProxyChangeNotifier jdField_a_of_type_ComTencentMobileqqArkBaseArkAppCenter$ProxyChangeNotifier = new ArkAppCenter.ProxyChangeNotifier(null);
  private final ArkAppCGI jdField_a_of_type_ComTencentMobileqqArkCoreArkAppCGI;
  private final ArkAppPreDownloadMgr jdField_a_of_type_ComTencentMobileqqArkCoreArkAppPreDownloadMgr;
  private final ArkAppSSO jdField_a_of_type_ComTencentMobileqqArkCoreArkAppSSO;
  private final INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new ArkAppCenter.5(this);
  private final AppRuntime jdField_a_of_type_MqqAppAppRuntime;
  private final int b = 1;
  private final int c = 2;
  
  public ArkAppCenter(AppRuntime paramAppRuntime)
  {
    QLog.i("ArkApp.AppCenter", 1, "ArkAppCenter.onCreate");
    this.jdField_a_of_type_MqqAppAppRuntime = paramAppRuntime;
    this.jdField_a_of_type_ComTencentMobileqqArkCoreArkAppCGI = new ArkAppCGI(this);
    this.jdField_a_of_type_ComTencentMobileqqArkCoreArkAppSSO = new ArkAppSSO(this);
    this.jdField_a_of_type_ComTencentMobileqqArkArkAiAppCenter = new ArkAiAppCenter();
    this.jdField_a_of_type_ComTencentMobileqqArkCoreArkAppPreDownloadMgr = new ArkAppPreDownloadMgr(this.jdField_a_of_type_MqqAppAppRuntime);
    a();
    b();
    c();
    e();
    f();
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    if (paramInt2 == 2)
    {
      ArkViewModel.setArkHttpProxy();
      return;
    }
    ArkViewModel.clearArkHttpProxy();
  }
  
  public static void a(String paramString)
  {
    if (paramString != null) {}
    try
    {
      jdField_a_of_type_Boolean = "1".equalsIgnoreCase(paramString);
      break label20;
      jdField_a_of_type_Boolean = false;
      label20:
      BaseApplication.getContext().getSharedPreferences("arkappmsg_entry", 4).edit().putBoolean("arkapp_pa_nshow", jdField_a_of_type_Boolean).apply();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    if (paramString != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("updatePANShowSwitch, value = ");
      localStringBuilder.append(paramString);
      QLog.i("ArkApp.AppCenter", 1, localStringBuilder.toString());
      return;
    }
    QLog.i("ArkApp.AppCenter", 1, "updatePANShowSwitch, value = null");
  }
  
  public static void a(boolean paramBoolean) {}
  
  public static boolean a()
  {
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("isPANonShow,  bRet = ");
      localStringBuilder.append(jdField_a_of_type_Boolean);
      QLog.i("ArkApp.AppCenter", 4, localStringBuilder.toString());
    }
    return (jdField_a_of_type_Boolean) || (!ArkUtil.isDeviceSupportArkMsg());
  }
  
  private void h()
  {
    Object localObject = (ArkPlatformConfigBean)ArkConfProcessor.a(ArkPlatformConfigBean.class);
    if ((localObject != null) && (((ArkPlatformConfigBean)localObject).a() != null))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ArkSafe.initGlobalWhiteListAndUrlCheckStatus.loadConfig content = ");
      localStringBuilder.append(((ArkPlatformConfigBean)localObject).a());
      QLog.d("ArkApp.AppCenter", 1, localStringBuilder.toString());
      localObject = ((ArkPlatformConfigBean)localObject).a();
      ArkAppConfigMgr.getInstance().initGlobalWhiteListAndUrlCheckStatus(((ArkPlatformConfig)localObject).jdField_a_of_type_Boolean, ((ArkPlatformConfig)localObject).jdField_b_of_type_JavaUtilArrayList, ((ArkPlatformConfig)localObject).jdField_b_of_type_JavaUtilConcurrentConcurrentHashMap);
    }
  }
  
  public ArkAppCGI a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArkCoreArkAppCGI;
  }
  
  public ArkAppPreDownloadMgr a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArkCoreArkAppPreDownloadMgr;
  }
  
  public ArkAppSSO a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqArkCoreArkAppSSO;
  }
  
  public AppRuntime a()
  {
    return this.jdField_a_of_type_MqqAppAppRuntime;
  }
  
  void a()
  {
    ArkMultiProcUtil.a();
    ArkAppNotifyCenter.init();
  }
  
  public boolean a(String paramString, Object paramObject, ArkAppCGI.ArkAppCGICallback paramArkAppCGICallback)
  {
    if ((paramString != null) && (paramString.length() > 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqArkCoreArkAppCGI.a(paramString, paramObject, paramArkAppCGICallback);
      return true;
    }
    return false;
  }
  
  void b()
  {
    jdField_a_of_type_Boolean = BaseApplication.getContext().getSharedPreferences("arkappmsg_entry", 4).getBoolean("arkapp_pa_nshow", jdField_a_of_type_Boolean);
    h();
  }
  
  void c()
  {
    AppNetConnInfo.registerConnectionChangeReceiver(this.jdField_a_of_type_MqqAppAppRuntime.getApp(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    Object localObject = new IntentFilter("android.intent.action.PROXY_CHANGE");
    this.jdField_a_of_type_MqqAppAppRuntime.getApp().registerReceiver(this.jdField_a_of_type_ComTencentMobileqqArkBaseArkAppCenter$ProxyChangeNotifier, (IntentFilter)localObject);
    localObject = GuardManager.a;
    if (localObject != null)
    {
      ((GuardManager)localObject).a(this.jdField_a_of_type_ComTencentMobileqqAppGuardGuardinterfaceIGuardInterface);
      return;
    }
    QLog.i("ArkApp.AppCenter", 1, "guard manager is null");
  }
  
  public void d()
  {
    QLog.i("ArkApp.AppCenter", 1, "ArkAppCenter.onDestroy");
    ArkAppMgr.getInstance().onDestroy();
    AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    this.jdField_a_of_type_MqqAppAppRuntime.getApp().unregisterReceiver(this.jdField_a_of_type_ComTencentMobileqqArkBaseArkAppCenter$ProxyChangeNotifier);
    if (GuardManager.a != null)
    {
      GuardManager.a.b(this.jdField_a_of_type_ComTencentMobileqqAppGuardGuardinterfaceIGuardInterface);
      return;
    }
    QLog.i("ArkApp.AppCenter", 1, "guard manager is null");
  }
  
  void e()
  {
    ThreadManagerV2.executeOnSubThread(new ArkAppCenter.2(this));
  }
  
  void f()
  {
    ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToMainThreadDelay(new ArkAppCenter.3(this), 10000);
  }
  
  public void g()
  {
    if (!TextUtils.isEmpty(this.jdField_a_of_type_MqqAppAppRuntime.getAccount())) {
      ArkAppMgr.getInstance().updateInstalledApps();
    }
    ((IArkDictManager)this.jdField_a_of_type_MqqAppAppRuntime.getRuntimeService(IArkDictManager.class, "")).reloadWordData();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.base.ArkAppCenter
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.ark.core;

import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.ark.ApplicationCallback;
import com.tencent.ark.open.delegate.ArkDelegateManager;
import com.tencent.ark.open.delegate.ArkDelegateManager.Config;
import com.tencent.ark.open.delegate.IArkDelegateNet;
import com.tencent.ark.open.delegate.IArkDelegateSSO;
import com.tencent.ark.open.delegate.IArkDelegateSetup;
import com.tencent.mobileqq.ark.api.IArkEnvDelegate;
import com.tencent.mobileqq.ark.api.IArkEnvironment;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soload.api.SoLoadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class ArkMultiProc
{
  protected static final ark.ApplicationCallback a;
  static final IArkDelegateNet jdField_a_of_type_ComTencentArkOpenDelegateIArkDelegateNet;
  static final IArkDelegateSSO jdField_a_of_type_ComTencentArkOpenDelegateIArkDelegateSSO;
  static final IArkDelegateSetup jdField_a_of_type_ComTencentArkOpenDelegateIArkDelegateSetup = new ArkMultiProc.2();
  static boolean jdField_a_of_type_Boolean = false;
  
  static
  {
    jdField_a_of_type_ComTencentArkOpenDelegateIArkDelegateNet = new ArkMultiProc.3();
    jdField_a_of_type_ComTencentArkOpenDelegateIArkDelegateSSO = new ArkMultiProc.4();
    jdField_a_of_type_ComTencentArkArk$ApplicationCallback = new ArkMultiProc.5();
  }
  
  public static void a(IArkEnvDelegate paramIArkEnvDelegate)
  {
    try
    {
      if (jdField_a_of_type_Boolean)
      {
        QLog.i("ArkApp.MultiProc", 1, "initArkEnv, ignore");
        return;
      }
      jdField_a_of_type_Boolean = true;
      QLog.i("ArkApp.MultiProc", 1, "initArkEnv, begin");
      long l = System.currentTimeMillis();
      ArkEnvironment.a = paramIArkEnvDelegate;
      IArkEnvironment localIArkEnvironment = (IArkEnvironment)QRoute.api(IArkEnvironment.class);
      ArkEnvironment.a(true);
      SoLoadManager.getInstance().download("jsc", new ArkMultiProc.1());
      Object localObject3 = localIArkEnvironment.getRootDirectory();
      Object localObject1 = "";
      Object localObject2 = localObject3;
      paramIArkEnvDelegate = (IArkEnvDelegate)localObject1;
      if (MobileQQ.sProcessId != 1)
      {
        localObject2 = MobileQQ.getMobileQQ().getQQProcessName();
        paramIArkEnvDelegate = (IArkEnvDelegate)localObject1;
        if (localObject2 != null)
        {
          int i = ((String)localObject2).lastIndexOf(':');
          paramIArkEnvDelegate = (IArkEnvDelegate)localObject1;
          if (i > -1)
          {
            paramIArkEnvDelegate = new StringBuilder();
            paramIArkEnvDelegate.append("_");
            paramIArkEnvDelegate.append(((String)localObject2).substring(i + 1));
            paramIArkEnvDelegate = paramIArkEnvDelegate.toString();
          }
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append((String)localObject3);
        ((StringBuilder)localObject1).append(paramIArkEnvDelegate);
        localObject2 = ((StringBuilder)localObject1).toString();
      }
      localObject1 = MobileQQ.sMobileQQ.waitAppRuntime(null);
      localObject3 = new ArkDelegateManager.Config();
      ((ArkDelegateManager.Config)localObject3).rootDir = ((String)localObject2);
      ((ArkDelegateManager.Config)localObject3).processName = paramIArkEnvDelegate;
      ((ArkDelegateManager.Config)localObject3).qqVersion = "8.7.0";
      ((ArkDelegateManager.Config)localObject3).context = ((AppRuntime)localObject1).getApplicationContext();
      ((ArkDelegateManager.Config)localObject3).setupDelegate = jdField_a_of_type_ComTencentArkOpenDelegateIArkDelegateSetup;
      ((ArkDelegateManager.Config)localObject3).netDelegate = jdField_a_of_type_ComTencentArkOpenDelegateIArkDelegateNet;
      ((ArkDelegateManager.Config)localObject3).ssoDelegate = jdField_a_of_type_ComTencentArkOpenDelegateIArkDelegateSSO;
      ((ArkDelegateManager.Config)localObject3).inputCallback = new ArkMultiProc.ArkViewInputCallback(null);
      ((ArkDelegateManager.Config)localObject3).applicationCallback = jdField_a_of_type_ComTencentArkArk$ApplicationCallback;
      ArkEnvironmentManager.getInstance().setCurrentUin(((AppRuntime)localObject1).getAccount());
      boolean bool = localIArkEnvironment.isTestEnv();
      ArkEnvironmentManager.getInstance().setEnv(bool);
      ArkDelegateManager.getInstance().init((ArkDelegateManager.Config)localObject3);
      paramIArkEnvDelegate = new StringBuilder();
      paramIArkEnvDelegate.append("initArkEnv, end, use-time=");
      paramIArkEnvDelegate.append(System.currentTimeMillis() - l);
      QLog.i("ArkApp.MultiProc", 1, paramIArkEnvDelegate.toString());
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.core.ArkMultiProc
 * JD-Core Version:    0.7.0.1
 */
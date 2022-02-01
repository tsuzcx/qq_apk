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
  static boolean a = false;
  static final IArkDelegateSetup b = new ArkMultiProc.2();
  static final IArkDelegateNet c = new ArkMultiProc.3();
  static final IArkDelegateSSO d = new ArkMultiProc.4();
  protected static final ark.ApplicationCallback e = new ArkMultiProc.5();
  
  public static void a(IArkEnvDelegate paramIArkEnvDelegate)
  {
    try
    {
      if (a)
      {
        QLog.i("ArkApp.MultiProc", 1, "initArkEnv, ignore");
        return;
      }
      a = true;
      QLog.i("ArkApp.MultiProc", 1, "initArkEnv, begin");
      long l = System.currentTimeMillis();
      ArkEnvironment.c = paramIArkEnvDelegate;
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
      ((ArkDelegateManager.Config)localObject3).qqVersion = "8.8.17";
      ((ArkDelegateManager.Config)localObject3).context = ((AppRuntime)localObject1).getApplicationContext();
      ((ArkDelegateManager.Config)localObject3).setupDelegate = b;
      ((ArkDelegateManager.Config)localObject3).netDelegate = c;
      ((ArkDelegateManager.Config)localObject3).ssoDelegate = d;
      ((ArkDelegateManager.Config)localObject3).inputCallback = new ArkMultiProc.ArkViewInputCallback(null);
      ((ArkDelegateManager.Config)localObject3).applicationCallback = e;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.core.ArkMultiProc
 * JD-Core Version:    0.7.0.1
 */
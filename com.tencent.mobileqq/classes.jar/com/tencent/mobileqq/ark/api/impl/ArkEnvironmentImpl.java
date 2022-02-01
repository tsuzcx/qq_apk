package com.tencent.mobileqq.ark.api.impl;

import com.tencent.mobileqq.ark.api.IArkEnvDelegate;
import com.tencent.mobileqq.ark.api.IArkEnvironment;
import com.tencent.mobileqq.ark.base.ArkAppCenter;
import com.tencent.mobileqq.ark.core.ArkEnvironment;
import com.tencent.mobileqq.ark.core.ArkMultiProc;
import com.tencent.mobileqq.ark.env.ArkAppEnvConfig;
import com.tencent.mobileqq.ark.test.DebugSwitch;

public class ArkEnvironmentImpl
  implements IArkEnvironment
{
  public String getAppDebugInstallDirectory()
  {
    return ArkAppEnvConfig.a().e();
  }
  
  public String getRootDirectory()
  {
    return ArkAppEnvConfig.a().c();
  }
  
  public void initJSCLibPath()
  {
    ArkEnvironment.b();
  }
  
  public void initMultiProcEnv(IArkEnvDelegate paramIArkEnvDelegate)
  {
    ArkMultiProc.a(paramIArkEnvDelegate);
  }
  
  public boolean isDebugMode()
  {
    return DebugSwitch.a();
  }
  
  public boolean isJSCLibExist()
  {
    return ArkEnvironment.d();
  }
  
  public boolean isTestEnv()
  {
    return ArkAppEnvConfig.a().b() == 1;
  }
  
  public void setDebugMode(boolean paramBoolean)
  {
    DebugSwitch.a(paramBoolean);
  }
  
  public void setScriptLeakCheckEnabled(boolean paramBoolean)
  {
    ArkAppCenter.a(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.impl.ArkEnvironmentImpl
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.ark.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IArkEnvironment
  extends QRouteApi
{
  public abstract String getAppDebugInstallDirectory();
  
  public abstract String getRootDirectory();
  
  public abstract void initJSCLibPath();
  
  public abstract void initMultiProcEnv(IArkEnvDelegate paramIArkEnvDelegate);
  
  public abstract boolean isDebugMode();
  
  public abstract boolean isJSCLibExist();
  
  public abstract boolean isTestEnv();
  
  public abstract void setDebugMode(boolean paramBoolean);
  
  public abstract void setScriptLeakCheckEnabled(boolean paramBoolean);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.IArkEnvironment
 * JD-Core Version:    0.7.0.1
 */
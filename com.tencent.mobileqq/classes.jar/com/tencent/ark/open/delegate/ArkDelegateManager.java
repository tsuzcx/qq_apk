package com.tencent.ark.open.delegate;

import android.content.Context;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.ArkViewImplement.InputCallback;
import com.tencent.ark.Logger;
import com.tencent.ark.ark.ApplicationCallback;
import com.tencent.ark.open.ArkUtil;

public class ArkDelegateManager
{
  private static final ArkEnvironmentManager ENV = ;
  private static final String TAG = "ArkApp.ArkDelegateManager";
  ArkDelegateManager.Config mConfig;
  
  public static ArkDelegateManager getInstance()
  {
    return ArkDelegateManager.Holder.gInstance;
  }
  
  public static boolean setupArkEnvironment(boolean paramBoolean)
  {
    IArkDelegateSetup localIArkDelegateSetup = getInstance().getSetupDelegate();
    if (localIArkDelegateSetup != null)
    {
      localIArkDelegateSetup.setupArkEnvironment(paramBoolean);
      return true;
    }
    return false;
  }
  
  public ark.ApplicationCallback getApplicationCallback()
  {
    ArkDelegateManager.Config localConfig = this.mConfig;
    if (localConfig == null) {
      return null;
    }
    return localConfig.applicationCallback;
  }
  
  public Context getApplicationContext()
  {
    ArkDelegateManager.Config localConfig = this.mConfig;
    if (localConfig == null) {
      return null;
    }
    return localConfig.context.getApplicationContext();
  }
  
  public ArkViewImplement.InputCallback getInputCallback()
  {
    ArkDelegateManager.Config localConfig = this.mConfig;
    if (localConfig == null) {
      return null;
    }
    return localConfig.inputCallback;
  }
  
  public IArkDelegateNet getNetDelegate()
  {
    ArkDelegateManager.Config localConfig = this.mConfig;
    if (localConfig == null) {
      return null;
    }
    return localConfig.netDelegate;
  }
  
  public String getProcessName()
  {
    return this.mConfig.processName;
  }
  
  public IArkDelegateSSO getSSODelegate()
  {
    ArkDelegateManager.Config localConfig = this.mConfig;
    if (localConfig == null) {
      return null;
    }
    return localConfig.ssoDelegate;
  }
  
  public IArkDelegateSetup getSetupDelegate()
  {
    ArkDelegateManager.Config localConfig = this.mConfig;
    if (localConfig == null) {
      return null;
    }
    return localConfig.setupDelegate;
  }
  
  public boolean init(ArkDelegateManager.Config paramConfig)
  {
    if (!paramConfig.isValid()) {
      return false;
    }
    this.mConfig = paramConfig;
    setupArkEnvironment(true);
    ArkUtil.createDir(paramConfig.rootDir);
    ArkEnvironmentManager.getInstance().setRootDirecotry(paramConfig.rootDir);
    ArkEnvironmentManager.getInstance().setQQVersion(paramConfig.qqVersion);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ark init with dir:");
    localStringBuilder.append(paramConfig.rootDir);
    localStringBuilder.append(", process=");
    localStringBuilder.append(paramConfig.processName);
    localStringBuilder.append(", qqVersion=");
    localStringBuilder.append(paramConfig.qqVersion);
    Logger.logI("ArkApp.ArkDelegateManager", localStringBuilder.toString());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.delegate.ArkDelegateManager
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.ark.open.delegate;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ark.ArkEnvironmentManager;
import com.tencent.ark.ArkViewImplement.InputCallback;
import com.tencent.ark.ark.ApplicationCallback;
import com.tencent.ark.open.ArkAppCacheMgr;
import com.tencent.ark.open.ArkUtil;

public class ArkDelegateManager
{
  private static final ArkEnvironmentManager ENV = ;
  private static final String TAG = "ArkApp.ArkDelegateManager";
  private Context mAppContext = null;
  private ark.ApplicationCallback mApplicationCallback = null;
  private IArkDelegateNet mArkDelegateNet = null;
  ArkViewImplement.InputCallback mInputCallback = null;
  private String mPorccessSufix = "";
  private IArkDelegateSetup mSetupDelegate = null;
  
  public static ArkDelegateManager getInstance()
  {
    return ArkDelegateManager.Holder.gInstance;
  }
  
  public ark.ApplicationCallback getApplicationCallback()
  {
    if (this.mApplicationCallback != null) {
      return this.mApplicationCallback;
    }
    return null;
  }
  
  public Context getApplicationContext()
  {
    return this.mAppContext;
  }
  
  public ArkViewImplement.InputCallback getInputCallback()
  {
    return this.mInputCallback;
  }
  
  public IArkDelegateNet getNetDelegate()
  {
    return this.mArkDelegateNet;
  }
  
  public String getPorcessName()
  {
    return this.mPorccessSufix;
  }
  
  public IArkDelegateSetup getSetupDelegate()
  {
    return this.mSetupDelegate;
  }
  
  public boolean init(String paramString1, String paramString2, String paramString3, Context paramContext)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (paramContext != null))
    {
      ArkAppCacheMgr.setupArkEnvironment(true);
      this.mAppContext = paramContext.getApplicationContext();
      this.mPorccessSufix = paramString2;
      ArkUtil.createDir(paramString1);
      ArkEnvironmentManager.getInstance().setRootDirecotry(paramString1);
      ArkEnvironmentManager.getInstance().setQQVersion(paramString3);
      ENV.logI("ArkApp.ArkDelegateManager", "ark init with dir:" + paramString1 + ",proSufix=" + paramString2 + ", qqVersion=" + paramString3);
      return true;
    }
    return false;
  }
  
  public void setApplicationCallback(ark.ApplicationCallback paramApplicationCallback)
  {
    this.mApplicationCallback = paramApplicationCallback;
  }
  
  public void setInputCallback(ArkViewImplement.InputCallback paramInputCallback)
  {
    this.mInputCallback = paramInputCallback;
  }
  
  public void setNetDelegate(IArkDelegateNet paramIArkDelegateNet)
  {
    this.mArkDelegateNet = paramIArkDelegateNet;
  }
  
  public void setSetupDelegate(IArkDelegateSetup paramIArkDelegateSetup)
  {
    this.mSetupDelegate = paramIArkDelegateSetup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ark.open.delegate.ArkDelegateManager
 * JD-Core Version:    0.7.0.1
 */
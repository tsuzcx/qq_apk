package com.tencent.ark.open.delegate;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ark.ArkViewImplement.InputCallback;
import com.tencent.ark.ark.ApplicationCallback;

public class ArkDelegateManager$Config
{
  public ark.ApplicationCallback applicationCallback;
  public Context context;
  public ArkViewImplement.InputCallback inputCallback;
  public IArkDelegateNet netDelegate;
  public String processName;
  public String qqVersion;
  public String rootDir;
  public IArkDelegateSetup setupDelegate;
  public IArkDelegateSSO ssoDelegate;
  
  public boolean isValid()
  {
    return (!TextUtils.isEmpty(this.rootDir)) && (this.processName != null) && (this.context != null) && (this.setupDelegate != null) && (this.inputCallback != null) && (this.applicationCallback != null) && (this.netDelegate != null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ark.open.delegate.ArkDelegateManager.Config
 * JD-Core Version:    0.7.0.1
 */
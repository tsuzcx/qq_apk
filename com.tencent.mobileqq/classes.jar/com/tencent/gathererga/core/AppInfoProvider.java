package com.tencent.gathererga.core;

import com.tencent.gathererga.core.internal.IBase;

public abstract interface AppInfoProvider
  extends IBase
{
  public abstract ProviderResult getAppVersionName(ProviderMethodPriority paramProviderMethodPriority);
  
  public abstract ProviderResult getPackageName(ProviderMethodPriority paramProviderMethodPriority);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gathererga.core.AppInfoProvider
 * JD-Core Version:    0.7.0.1
 */
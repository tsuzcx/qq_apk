package com.tencent.gathererga.core;

import com.tencent.gathererga.core.internal.IBase;

public abstract interface AndroidInfoProvider
  extends IBase
{
  public abstract ProviderResult getKernelVersion(ProviderMethodPriority paramProviderMethodPriority);
  
  public abstract ProviderResult getOsVersion(ProviderMethodPriority paramProviderMethodPriority);
  
  public abstract ProviderResult getProcVersion(ProviderMethodPriority paramProviderMethodPriority);
  
  public abstract ProviderResult getUUID(ProviderMethodPriority paramProviderMethodPriority, String paramString);
  
  public abstract ProviderResult sdCardFreeSpace(ProviderMethodPriority paramProviderMethodPriority);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gathererga.core.AndroidInfoProvider
 * JD-Core Version:    0.7.0.1
 */
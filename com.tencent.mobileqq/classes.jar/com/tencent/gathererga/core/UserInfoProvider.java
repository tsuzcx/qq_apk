package com.tencent.gathererga.core;

import com.tencent.gathererga.core.internal.IBase;

public abstract interface UserInfoProvider
  extends IBase
{
  public abstract ProviderResult getBootTime(ProviderMethodPriority paramProviderMethodPriority);
  
  public abstract ProviderResult getBssid(ProviderMethodPriority paramProviderMethodPriority);
  
  public abstract ProviderResult getCarrier(ProviderMethodPriority paramProviderMethodPriority, boolean paramBoolean);
  
  public abstract ProviderResult getCountry(ProviderMethodPriority paramProviderMethodPriority);
  
  public abstract ProviderResult getIpAddress(ProviderMethodPriority paramProviderMethodPriority);
  
  public abstract ProviderResult getLanguage(ProviderMethodPriority paramProviderMethodPriority);
  
  public abstract ProviderResult getLatitude(ProviderMethodPriority paramProviderMethodPriority);
  
  public abstract ProviderResult getLongitude(ProviderMethodPriority paramProviderMethodPriority);
  
  public abstract ProviderResult getMobileNetworkType(ProviderMethodPriority paramProviderMethodPriority);
  
  public abstract ProviderResult getNetworkType(ProviderMethodPriority paramProviderMethodPriority);
  
  public abstract ProviderResult getScreenOrientation(ProviderMethodPriority paramProviderMethodPriority);
  
  public abstract ProviderResult getTimeZone(ProviderMethodPriority paramProviderMethodPriority);
  
  public abstract ProviderResult getUserAgent(ProviderMethodPriority paramProviderMethodPriority);
  
  public abstract ProviderResult isRooted(ProviderMethodPriority paramProviderMethodPriority);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gathererga.core.UserInfoProvider
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.gathererga.core;

import com.tencent.gathererga.core.internal.IBase;

public abstract interface HardwareInfoProvider
  extends IBase
{
  public static final String HARMONY_OS = "harmony";
  public static final int HARMONY_PURE_MODE_UNKNOWN = -1;
  
  public abstract ProviderResult getAndroidId(ProviderMethodPriority paramProviderMethodPriority);
  
  public abstract ProviderResult getBrand(ProviderMethodPriority paramProviderMethodPriority);
  
  public abstract ProviderResult getDeviceHeightAndWidth(ProviderMethodPriority paramProviderMethodPriority);
  
  public abstract ProviderResult getDeviceId(ProviderMethodPriority paramProviderMethodPriority);
  
  public abstract ProviderResult getDeviceId0(ProviderMethodPriority paramProviderMethodPriority);
  
  public abstract ProviderResult getDeviceId1(ProviderMethodPriority paramProviderMethodPriority);
  
  public abstract ProviderResult getDpi(ProviderMethodPriority paramProviderMethodPriority);
  
  public abstract ProviderResult getHarmonyOsVersion(ProviderMethodPriority paramProviderMethodPriority);
  
  public abstract ProviderResult getHarmonyPureMode(ProviderMethodPriority paramProviderMethodPriority);
  
  public abstract ProviderResult getImei(ProviderMethodPriority paramProviderMethodPriority);
  
  public abstract ProviderResult getImei0(ProviderMethodPriority paramProviderMethodPriority);
  
  public abstract ProviderResult getImei1(ProviderMethodPriority paramProviderMethodPriority);
  
  public abstract ProviderResult getImsi(ProviderMethodPriority paramProviderMethodPriority);
  
  public abstract ProviderResult getImsi0(ProviderMethodPriority paramProviderMethodPriority);
  
  public abstract ProviderResult getImsi1(ProviderMethodPriority paramProviderMethodPriority);
  
  public abstract ProviderResult getIsHarmonyOs(ProviderMethodPriority paramProviderMethodPriority);
  
  public abstract ProviderResult getManufacturer(ProviderMethodPriority paramProviderMethodPriority);
  
  public abstract ProviderResult getMeid(ProviderMethodPriority paramProviderMethodPriority);
  
  public abstract ProviderResult getMeid0(ProviderMethodPriority paramProviderMethodPriority);
  
  public abstract ProviderResult getMeid1(ProviderMethodPriority paramProviderMethodPriority);
  
  public abstract ProviderResult getModel(ProviderMethodPriority paramProviderMethodPriority);
  
  public abstract ProviderResult getRamSize(ProviderMethodPriority paramProviderMethodPriority);
  
  public abstract ProviderResult getRomSize(ProviderMethodPriority paramProviderMethodPriority);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gathererga.core.HardwareInfoProvider
 * JD-Core Version:    0.7.0.1
 */
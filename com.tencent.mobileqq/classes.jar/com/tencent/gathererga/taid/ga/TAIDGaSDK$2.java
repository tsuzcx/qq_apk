package com.tencent.gathererga.taid.ga;

import com.tencent.gathererga.core.AndroidInfoProvider;
import com.tencent.gathererga.core.GathererCoreContext;
import com.tencent.gathererga.core.HardwareInfoProvider;
import com.tencent.turingfd.sdk.ams.ga.ITuringDeviceInfoProvider;

final class TAIDGaSDK$2
  implements ITuringDeviceInfoProvider
{
  public String getAndroidId()
  {
    HardwareInfoProvider localHardwareInfoProvider = (HardwareInfoProvider)GathererCoreContext.a(HardwareInfoProvider.class);
    if (localHardwareInfoProvider == null) {
      return "";
    }
    return TAIDGaSDK.a(localHardwareInfoProvider.getAndroidId(TAIDGaSDK.b()));
  }
  
  public String getBrand()
  {
    HardwareInfoProvider localHardwareInfoProvider = (HardwareInfoProvider)GathererCoreContext.a(HardwareInfoProvider.class);
    if (localHardwareInfoProvider == null) {
      return "";
    }
    return TAIDGaSDK.a(localHardwareInfoProvider.getBrand(TAIDGaSDK.b()));
  }
  
  public String getImei()
  {
    HardwareInfoProvider localHardwareInfoProvider = (HardwareInfoProvider)GathererCoreContext.a(HardwareInfoProvider.class);
    if (localHardwareInfoProvider == null) {
      return "";
    }
    return TAIDGaSDK.a(localHardwareInfoProvider.getImei(TAIDGaSDK.b()));
  }
  
  public String getImsi()
  {
    HardwareInfoProvider localHardwareInfoProvider = (HardwareInfoProvider)GathererCoreContext.a(HardwareInfoProvider.class);
    if (localHardwareInfoProvider == null) {
      return "";
    }
    return TAIDGaSDK.a(localHardwareInfoProvider.getImsi(TAIDGaSDK.b()));
  }
  
  public String getKernelVersion()
  {
    AndroidInfoProvider localAndroidInfoProvider = (AndroidInfoProvider)GathererCoreContext.a(AndroidInfoProvider.class);
    if (localAndroidInfoProvider == null) {
      return "";
    }
    return TAIDGaSDK.a(localAndroidInfoProvider.getProcVersion(TAIDGaSDK.b()));
  }
  
  public String getModel()
  {
    HardwareInfoProvider localHardwareInfoProvider = (HardwareInfoProvider)GathererCoreContext.a(HardwareInfoProvider.class);
    if (localHardwareInfoProvider == null) {
      return "";
    }
    return TAIDGaSDK.a(localHardwareInfoProvider.getModel(TAIDGaSDK.b()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gathererga.taid.ga.TAIDGaSDK.2
 * JD-Core Version:    0.7.0.1
 */
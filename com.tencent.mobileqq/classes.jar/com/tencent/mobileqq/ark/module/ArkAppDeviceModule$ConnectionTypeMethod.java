package com.tencent.mobileqq.ark.module;

import com.tencent.ark.ark.VariantWrapper;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;

class ArkAppDeviceModule$ConnectionTypeMethod
  implements ArkAppDeviceModule.DeviceMethodWrap
{
  private ArkAppDeviceModule$ConnectionTypeMethod(ArkAppDeviceModule paramArkAppDeviceModule) {}
  
  public boolean a(String paramString, ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    if (!ArkAPIPermission.a(this.a.f, this.a.e, this.a.i, "permission.CONNECTION_TYPE")) {
      return false;
    }
    if (!AppNetConnInfo.isNetSupport())
    {
      paramVariantWrapper.SetString("none");
    }
    else if (AppNetConnInfo.isWifiConn())
    {
      paramVariantWrapper.SetString("wifi");
    }
    else if (AppNetConnInfo.isMobileConn())
    {
      int i = AppNetConnInfo.getMobileInfo();
      if (i == 0) {
        paramVariantWrapper.SetString("none");
      } else if (-1 == i) {
        paramVariantWrapper.SetString("other");
      } else {
        paramVariantWrapper.SetString("cellular");
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.module.ArkAppDeviceModule.ConnectionTypeMethod
 * JD-Core Version:    0.7.0.1
 */
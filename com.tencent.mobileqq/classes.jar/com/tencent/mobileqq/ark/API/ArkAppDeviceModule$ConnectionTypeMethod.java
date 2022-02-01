package com.tencent.mobileqq.ark.API;

import com.tencent.ark.ark.VariantWrapper;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;

class ArkAppDeviceModule$ConnectionTypeMethod
  implements ArkAppDeviceModule.DeviceMethodWrap
{
  private ArkAppDeviceModule$ConnectionTypeMethod(ArkAppDeviceModule paramArkAppDeviceModule) {}
  
  public boolean a(String paramString, ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    if (!ArkAPIPermission.a(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_Long, this.a.jdField_a_of_type_ComTencentArkArk$Application, "permission.CONNECTION_TYPE")) {
      return false;
    }
    if (!AppNetConnInfo.isNetSupport()) {
      paramVariantWrapper.SetString("none");
    }
    for (;;)
    {
      return true;
      if (AppNetConnInfo.isWifiConn())
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
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppDeviceModule.ConnectionTypeMethod
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.ark.module;

import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.commonsdk.util.MD5Coding;
import com.tencent.mobileqq.ark.temp.api.IDisplayConfig;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQDeviceInfo;

class ArkAppDeviceModule$SystemInfoMethod
  implements ArkAppDeviceModule.DeviceMethodWrap
{
  private ArkAppDeviceModule$SystemInfoMethod(ArkAppDeviceModule paramArkAppDeviceModule) {}
  
  public boolean a(String paramString, ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    if (!ArkAPIPermission.a(this.a.b, this.a.jdField_a_of_type_Int, this.a.jdField_a_of_type_ComTencentArkArk$Application, "permission.DEVICE_INFORMATION")) {
      return false;
    }
    paramArrayOfVariantWrapper = ((IDisplayConfig)QRoute.api(IDisplayConfig.class)).getDisplayMetrics();
    if ("GetModelName".equals(paramString))
    {
      paramVariantWrapper.SetString(Build.MODEL);
      return true;
    }
    if ("GetScreenWidth".equals(paramString))
    {
      paramVariantWrapper.SetInt((int)(paramArrayOfVariantWrapper.widthPixels / paramArrayOfVariantWrapper.density));
      return true;
    }
    if ("GetScreenHeight".equals(paramString))
    {
      paramVariantWrapper.SetInt((int)(paramArrayOfVariantWrapper.heightPixels / paramArrayOfVariantWrapper.density));
      return true;
    }
    if ("GetPixelRatio".equals(paramString))
    {
      paramVariantWrapper.SetDouble(((IDisplayConfig)QRoute.api(IDisplayConfig.class)).getDisplayDensity());
      return true;
    }
    if ("GetIdentifier".equals(paramString))
    {
      paramArrayOfVariantWrapper = DeviceInfoUtil.a();
      paramString = paramArrayOfVariantWrapper;
      if (!TextUtils.isEmpty(paramArrayOfVariantWrapper)) {}
    }
    try
    {
      paramString = QQDeviceInfo.getIMEI("6973c4");
    }
    catch (Exception paramString)
    {
      label180:
      break label180;
    }
    QLog.e("ArkAppDeviceModule", 1, "get identifer: exception, catch it");
    paramString = paramArrayOfVariantWrapper;
    paramArrayOfVariantWrapper = paramString;
    if (paramString == null)
    {
      QLog.e("ArkAppDeviceModule", 1, "get identifer: null, fix it with empty string");
      paramArrayOfVariantWrapper = "";
    }
    paramString = paramArrayOfVariantWrapper;
    if (this.a.jdField_a_of_type_Int != 0) {
      paramString = MD5Coding.encodeHexStr(paramArrayOfVariantWrapper);
    }
    paramVariantWrapper.SetString(paramString);
    return true;
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.module.ArkAppDeviceModule.SystemInfoMethod
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.ark.API;

import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.commonsdk.util.MD5Coding;
import com.tencent.mobileqq.ark.ArkAppCenterUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.QQDeviceInfo;

class ArkAppDeviceModule$SystemInfoMethod
  implements ArkAppDeviceModule.DeviceMethodWrap
{
  private ArkAppDeviceModule$SystemInfoMethod(ArkAppDeviceModule paramArkAppDeviceModule) {}
  
  public boolean a(String paramString, ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    if (!ArkAPIPermission.a(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_Long, this.a.jdField_a_of_type_ComTencentArkArk$Application, "permission.DEVICE_INFORMATION")) {}
    do
    {
      return false;
      if ("GetModelName".equals(paramString))
      {
        paramVariantWrapper.SetString(Build.MODEL);
        return true;
      }
      if ("GetScreenWidth".equals(paramString))
      {
        paramString = ArkAppCenterUtil.a;
        paramVariantWrapper.SetInt((int)(paramString.widthPixels / paramString.density));
        return true;
      }
      if ("GetScreenHeight".equals(paramString))
      {
        paramString = ArkAppCenterUtil.a;
        paramVariantWrapper.SetInt((int)(paramString.heightPixels / paramString.density));
        return true;
      }
      if ("GetPixelRatio".equals(paramString))
      {
        paramVariantWrapper.SetDouble(ArkAppCenterUtil.a());
        return true;
      }
    } while (!"GetIdentifier".equals(paramString));
    paramArrayOfVariantWrapper = DeviceInfoUtil.a();
    paramString = paramArrayOfVariantWrapper;
    if (TextUtils.isEmpty(paramArrayOfVariantWrapper)) {}
    try
    {
      paramString = QQDeviceInfo.getIMEI("6973c4");
      paramArrayOfVariantWrapper = paramString;
      if (paramString == null)
      {
        paramArrayOfVariantWrapper = "";
        QLog.e("ArkAppDeviceModule", 1, "get identifer: null, fix it with empty string");
      }
      paramString = paramArrayOfVariantWrapper;
      if (this.a.jdField_a_of_type_Long != 0L) {
        paramString = MD5Coding.encodeHexStr(paramArrayOfVariantWrapper);
      }
      paramVariantWrapper.SetString(paramString);
      return true;
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        QLog.e("ArkAppDeviceModule", 1, "get identifer: exception, catch it");
        paramString = paramArrayOfVariantWrapper;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppDeviceModule.SystemInfoMethod
 * JD-Core Version:    0.7.0.1
 */
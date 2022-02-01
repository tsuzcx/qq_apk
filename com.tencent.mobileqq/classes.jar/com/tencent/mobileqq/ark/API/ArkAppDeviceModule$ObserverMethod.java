package com.tencent.mobileqq.ark.API;

import android.text.TextUtils;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class ArkAppDeviceModule$ObserverMethod
  implements ArkAppDeviceModule.DeviceMethodWrap
{
  private ArkAppDeviceModule$ObserverMethod(ArkAppDeviceModule paramArkAppDeviceModule) {}
  
  public boolean a(String paramString, ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    paramVariantWrapper = null;
    String str = null;
    Object localObject = null;
    long l;
    if ("AttachEvent".equals(paramString))
    {
      if ((paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.length < 2) || (!paramArrayOfVariantWrapper[0].IsString()) || (!paramArrayOfVariantWrapper[1].IsFunction())) {
        return false;
      }
      str = paramArrayOfVariantWrapper[0].GetString();
      l = this.a.a(paramArrayOfVariantWrapper[1].Copy());
      if ("Motion".equals(str))
      {
        if (!ArkAPIPermission.a(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_Long, this.a.jdField_a_of_type_ComTencentArkArk$Application, "permission.SENSORS")) {
          return false;
        }
        paramString = new ArkAppDeviceModule.ObserverMethod.1(this, l);
      }
      while ((paramString != null) && (!"Position".equals(str)))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppEventObserverManager.a(paramString, l);
        return true;
        if ("Orientation".equals(str))
        {
          if (!ArkAPIPermission.a(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_Long, this.a.jdField_a_of_type_ComTencentArkArk$Application, "permission.SENSORS")) {
            return false;
          }
          paramString = new ArkAppDeviceModule.ObserverMethod.2(this, l);
        }
        else
        {
          if ("Position".equals(str))
          {
            if (!ArkAPIPermission.a(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_Long, this.a.jdField_a_of_type_ComTencentArkArk$Application, "permission.POSITION")) {
              return false;
            }
            if (QLog.isColorLevel()) {
              QLog.i("ArkAppDeviceModule", 2, String.format("Position.app.%s", new Object[] { this.a.jdField_a_of_type_JavaLangString }));
            }
            paramArrayOfVariantWrapper = ArkCommonUtil.a();
            paramString = paramVariantWrapper;
            if (paramArrayOfVariantWrapper != null) {
              paramString = paramArrayOfVariantWrapper.getCurrentAccountUin();
            }
            ArkAppModuleBase.APIAuthority.a(paramString, this.a.jdField_a_of_type_JavaLangString, "ark_authority_api_location", BaseApplicationImpl.getContext().getString(2131690210), new ArkAppDeviceModule.ObserverMethod.3(this, l));
            return true;
          }
          paramString = localObject;
          if ("ConnectionTypeChange".equals(str))
          {
            if (!ArkAPIPermission.a(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_Long, this.a.jdField_a_of_type_ComTencentArkArk$Application, "permission.CONNECTION_TYPE")) {
              return false;
            }
            paramString = new ArkAppDeviceModule.ObserverMethod.4(this, l);
          }
        }
      }
      return false;
    }
    if ("DetachEvent".equals(paramString))
    {
      if ((paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.length < 1) || (!paramArrayOfVariantWrapper[0].IsString()) || (TextUtils.isEmpty(paramArrayOfVariantWrapper[0].GetString()))) {
        return false;
      }
      this.a.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppEventObserverManager.a(paramArrayOfVariantWrapper[0].GetString());
      return true;
    }
    if ("GetCurrentPosition".equals(paramString))
    {
      if (!ArkAPIPermission.a(this.a.jdField_a_of_type_JavaLangString, this.a.jdField_a_of_type_Long, this.a.jdField_a_of_type_ComTencentArkArk$Application, "permission.POSITION")) {
        return false;
      }
      if ((paramArrayOfVariantWrapper == null) || (paramArrayOfVariantWrapper.length < 1) || (!paramArrayOfVariantWrapper[0].IsFunction())) {
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.i("ArkAppDeviceModule", 2, String.format("GetCurrentPosition.app.%s", new Object[] { this.a.jdField_a_of_type_JavaLangString }));
      }
      l = this.a.a(paramArrayOfVariantWrapper[0].Copy());
      paramArrayOfVariantWrapper = ArkCommonUtil.a();
      paramString = str;
      if (paramArrayOfVariantWrapper != null) {
        paramString = paramArrayOfVariantWrapper.getCurrentAccountUin();
      }
      ArkAppModuleBase.APIAuthority.a(paramString, this.a.jdField_a_of_type_JavaLangString, "ark_authority_api_location", BaseApplicationImpl.getContext().getString(2131690210), new ArkAppDeviceModule.ObserverMethod.5(this, l));
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppDeviceModule.ObserverMethod
 * JD-Core Version:    0.7.0.1
 */
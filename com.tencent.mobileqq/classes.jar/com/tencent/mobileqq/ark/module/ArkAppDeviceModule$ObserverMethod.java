package com.tencent.mobileqq.ark.module;

import android.text.TextUtils;
import com.tencent.ark.ark.VariantWrapper;
import com.tencent.mobileqq.ark.component.ArkAppEventObserverManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class ArkAppDeviceModule$ObserverMethod
  implements ArkAppDeviceModule.DeviceMethodWrap
{
  private ArkAppDeviceModule$ObserverMethod(ArkAppDeviceModule paramArkAppDeviceModule) {}
  
  public boolean a(String paramString, ark.VariantWrapper[] paramArrayOfVariantWrapper, ark.VariantWrapper paramVariantWrapper)
  {
    long l;
    if ("AttachEvent".equals(paramString))
    {
      if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 2) && (paramArrayOfVariantWrapper[0].IsString()))
      {
        if (!paramArrayOfVariantWrapper[1].IsFunction()) {
          return false;
        }
        paramVariantWrapper = paramArrayOfVariantWrapper[0].GetString();
        l = this.a.a(paramArrayOfVariantWrapper[1].Copy());
        paramString = null;
        if ("Motion".equals(paramVariantWrapper))
        {
          if (!ArkAPIPermission.a(this.a.b, this.a.jdField_a_of_type_Int, this.a.jdField_a_of_type_ComTencentArkArk$Application, "permission.SENSORS")) {
            return false;
          }
          paramString = new ArkAppDeviceModule.ObserverMethod.1(this, l);
        }
        else if ("Orientation".equals(paramVariantWrapper))
        {
          if (!ArkAPIPermission.a(this.a.b, this.a.jdField_a_of_type_Int, this.a.jdField_a_of_type_ComTencentArkArk$Application, "permission.SENSORS")) {
            return false;
          }
          paramString = new ArkAppDeviceModule.ObserverMethod.2(this, l);
        }
        else
        {
          if ("Position".equals(paramVariantWrapper))
          {
            if (!ArkAPIPermission.a(this.a.b, this.a.jdField_a_of_type_Int, this.a.jdField_a_of_type_ComTencentArkArk$Application, "permission.POSITION")) {
              return false;
            }
            if (QLog.isColorLevel()) {
              QLog.i("ArkAppDeviceModule", 2, String.format("Position.app.%s", new Object[] { this.a.b }));
            }
            ArkModuleAPIAuthority.a(ArkAppDeviceModule.a(), this.a.b, "ark_authority_api_location", BaseApplication.getContext().getString(2131690126), new ArkAppDeviceModule.ObserverMethod.3(this, l));
            return true;
          }
          if ("ConnectionTypeChange".equals(paramVariantWrapper))
          {
            if (!ArkAPIPermission.a(this.a.b, this.a.jdField_a_of_type_Int, this.a.jdField_a_of_type_ComTencentArkArk$Application, "permission.CONNECTION_TYPE")) {
              return false;
            }
            paramString = new ArkAppDeviceModule.ObserverMethod.4(this, l);
          }
        }
        if ((paramString != null) && (!"Position".equals(paramVariantWrapper)))
        {
          this.a.jdField_a_of_type_ComTencentMobileqqArkComponentArkAppEventObserverManager.a(paramString, l);
          return true;
        }
      }
      return false;
    }
    if ("DetachEvent".equals(paramString))
    {
      if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1) && (paramArrayOfVariantWrapper[0].IsString()))
      {
        if (TextUtils.isEmpty(paramArrayOfVariantWrapper[0].GetString())) {
          return false;
        }
        this.a.jdField_a_of_type_ComTencentMobileqqArkComponentArkAppEventObserverManager.a(paramArrayOfVariantWrapper[0].GetString());
        return true;
      }
      return false;
    }
    if ("GetCurrentPosition".equals(paramString))
    {
      if (!ArkAPIPermission.a(this.a.b, this.a.jdField_a_of_type_Int, this.a.jdField_a_of_type_ComTencentArkArk$Application, "permission.POSITION")) {
        return false;
      }
      if ((paramArrayOfVariantWrapper != null) && (paramArrayOfVariantWrapper.length >= 1))
      {
        if (!paramArrayOfVariantWrapper[0].IsFunction()) {
          return false;
        }
        if (QLog.isColorLevel()) {
          QLog.i("ArkAppDeviceModule", 2, String.format("GetCurrentPosition.app.%s", new Object[] { this.a.b }));
        }
        l = this.a.a(paramArrayOfVariantWrapper[0].Copy());
        ArkModuleAPIAuthority.a(ArkAppDeviceModule.a(), this.a.b, "ark_authority_api_location", BaseApplication.getContext().getString(2131690126), new ArkAppDeviceModule.ObserverMethod.5(this, l));
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.module.ArkAppDeviceModule.ObserverMethod
 * JD-Core Version:    0.7.0.1
 */
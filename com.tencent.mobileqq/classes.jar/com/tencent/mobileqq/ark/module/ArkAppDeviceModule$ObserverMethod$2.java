package com.tencent.mobileqq.ark.module;

import com.tencent.ark.ark.VariantWrapper;
import com.tencent.mobileqq.ark.component.ArkAppEventObserverManager.OrientationCallback;

class ArkAppDeviceModule$ObserverMethod$2
  implements ArkAppEventObserverManager.OrientationCallback
{
  ArkAppDeviceModule$ObserverMethod$2(ArkAppDeviceModule.ObserverMethod paramObserverMethod, long paramLong) {}
  
  public void a(long paramLong)
  {
    ark.VariantWrapper localVariantWrapper = this.jdField_a_of_type_ComTencentMobileqqArkModuleArkAppDeviceModule$ObserverMethod.a.a(paramLong);
    if (localVariantWrapper != null) {
      localVariantWrapper.Reset();
    }
  }
  
  public void a(boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    ArkAppDeviceModule.a(this.jdField_a_of_type_ComTencentMobileqqArkModuleArkAppDeviceModule$ObserverMethod.a, this.jdField_a_of_type_Long, paramBoolean, "Orientation", paramFloat1, paramFloat2, paramFloat3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.module.ArkAppDeviceModule.ObserverMethod.2
 * JD-Core Version:    0.7.0.1
 */
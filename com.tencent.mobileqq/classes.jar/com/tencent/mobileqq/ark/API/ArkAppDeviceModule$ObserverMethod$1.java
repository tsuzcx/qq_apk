package com.tencent.mobileqq.ark.API;

import com.tencent.ark.ark.VariantWrapper;

class ArkAppDeviceModule$ObserverMethod$1
  implements ArkAppEventObserverManager.MotionCallback
{
  ArkAppDeviceModule$ObserverMethod$1(ArkAppDeviceModule.ObserverMethod paramObserverMethod, long paramLong) {}
  
  public void a(long paramLong)
  {
    ark.VariantWrapper localVariantWrapper = this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppDeviceModule$ObserverMethod.a.a(paramLong);
    if (localVariantWrapper != null) {
      localVariantWrapper.Reset();
    }
  }
  
  public void a(boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    ArkAppDeviceModule.a(this.jdField_a_of_type_ComTencentMobileqqArkAPIArkAppDeviceModule$ObserverMethod.a, this.jdField_a_of_type_Long, paramBoolean, "Motion", paramFloat1, paramFloat2, paramFloat3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppDeviceModule.ObserverMethod.1
 * JD-Core Version:    0.7.0.1
 */
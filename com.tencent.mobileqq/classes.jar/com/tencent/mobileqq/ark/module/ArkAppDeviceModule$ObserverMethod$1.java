package com.tencent.mobileqq.ark.module;

import com.tencent.ark.ark.VariantWrapper;
import com.tencent.mobileqq.ark.component.ArkAppEventObserverManager.MotionCallback;

class ArkAppDeviceModule$ObserverMethod$1
  implements ArkAppEventObserverManager.MotionCallback
{
  ArkAppDeviceModule$ObserverMethod$1(ArkAppDeviceModule.ObserverMethod paramObserverMethod, long paramLong) {}
  
  public void a(long paramLong)
  {
    ark.VariantWrapper localVariantWrapper = this.b.a.a(paramLong);
    if (localVariantWrapper != null) {
      localVariantWrapper.Reset();
    }
  }
  
  public void a(boolean paramBoolean, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    ArkAppDeviceModule.a(this.b.a, this.a, paramBoolean, "Motion", paramFloat1, paramFloat2, paramFloat3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.module.ArkAppDeviceModule.ObserverMethod.1
 * JD-Core Version:    0.7.0.1
 */
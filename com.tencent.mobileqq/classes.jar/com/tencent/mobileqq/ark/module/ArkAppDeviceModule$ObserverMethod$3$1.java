package com.tencent.mobileqq.ark.module;

import com.tencent.ark.ark.VariantWrapper;
import com.tencent.mobileqq.ark.component.ArkAppEventObserverManager.PositionCallback;

class ArkAppDeviceModule$ObserverMethod$3$1
  implements ArkAppEventObserverManager.PositionCallback
{
  ArkAppDeviceModule$ObserverMethod$3$1(ArkAppDeviceModule.ObserverMethod.3 param3) {}
  
  public void a(long paramLong)
  {
    ark.VariantWrapper localVariantWrapper = this.a.b.a.a(paramLong);
    if (localVariantWrapper != null) {
      localVariantWrapper.Reset();
    }
  }
  
  public void a(boolean paramBoolean, double paramDouble1, double paramDouble2)
  {
    ArkAppDeviceModule.a(this.a.b.a, this.a.a, paramBoolean, paramDouble1, paramDouble2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.module.ArkAppDeviceModule.ObserverMethod.3.1
 * JD-Core Version:    0.7.0.1
 */
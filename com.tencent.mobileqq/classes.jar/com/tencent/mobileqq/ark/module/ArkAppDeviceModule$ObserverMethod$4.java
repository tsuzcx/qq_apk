package com.tencent.mobileqq.ark.module;

import com.tencent.ark.ark.VariantWrapper;
import com.tencent.mobileqq.ark.component.ArkAppEventObserverManager.ConnectionCallback;

class ArkAppDeviceModule$ObserverMethod$4
  implements ArkAppEventObserverManager.ConnectionCallback
{
  ArkAppDeviceModule$ObserverMethod$4(ArkAppDeviceModule.ObserverMethod paramObserverMethod, long paramLong) {}
  
  public void a(long paramLong)
  {
    ark.VariantWrapper localVariantWrapper = this.b.a.a(paramLong);
    if (localVariantWrapper != null) {
      localVariantWrapper.Reset();
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    ArkAppDeviceModule.a(this.b.a, this.a, paramBoolean, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.module.ArkAppDeviceModule.ObserverMethod.4
 * JD-Core Version:    0.7.0.1
 */
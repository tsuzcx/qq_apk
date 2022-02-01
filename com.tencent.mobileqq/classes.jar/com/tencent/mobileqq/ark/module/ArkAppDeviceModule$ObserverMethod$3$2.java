package com.tencent.mobileqq.ark.module;

import com.tencent.ark.ark.VariantWrapper;

class ArkAppDeviceModule$ObserverMethod$3$2
  implements Runnable
{
  ArkAppDeviceModule$ObserverMethod$3$2(ArkAppDeviceModule.ObserverMethod.3 param3) {}
  
  public void run()
  {
    ArkAppDeviceModule.a(this.a.b.a, this.a.a, false, 0.0D, 0.0D);
    ark.VariantWrapper localVariantWrapper = this.a.b.a.a(this.a.a);
    if (localVariantWrapper != null) {
      localVariantWrapper.Reset();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.module.ArkAppDeviceModule.ObserverMethod.3.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.ark.api.module;

import com.tencent.ark.ark.VariantWrapper;
import com.tencent.mobileqq.ark.component.ArkAppLocationManager.LocationCallback;

class ArkAppQQModule$2
  implements ArkAppLocationManager.LocationCallback
{
  ArkAppQQModule$2(ArkAppQQModule paramArkAppQQModule, long paramLong) {}
  
  public void a()
  {
    ark.VariantWrapper localVariantWrapper = ArkAppQQModule.b(this.b, this.a);
    if (localVariantWrapper != null) {
      localVariantWrapper.Reset();
    }
  }
  
  public void a(boolean paramBoolean, double paramDouble1, double paramDouble2)
  {
    this.b.a(this.a, paramBoolean, paramDouble1, paramDouble2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.module.ArkAppQQModule.2
 * JD-Core Version:    0.7.0.1
 */
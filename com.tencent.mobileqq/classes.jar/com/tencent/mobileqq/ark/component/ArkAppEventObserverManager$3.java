package com.tencent.mobileqq.ark.component;

import android.hardware.SensorEvent;
import com.tencent.qphone.base.util.QLog;

class ArkAppEventObserverManager$3
  implements Runnable
{
  ArkAppEventObserverManager$3(ArkAppEventObserverManager paramArkAppEventObserverManager, long paramLong, SensorEvent paramSensorEvent) {}
  
  public void run()
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder("onOrientationSensorChange curTime=");
      localStringBuilder.append(this.a);
      localStringBuilder.append(", event[0]=");
      localStringBuilder.append(this.b.values[0]);
      localStringBuilder.append(", event[1]=");
      localStringBuilder.append(this.b.values[1]);
      localStringBuilder.append(", event[2]=");
      localStringBuilder.append(this.b.values[2]);
      QLog.d("ArkAppEventObserverManager", 2, localStringBuilder.toString());
    }
    ArkAppEventObserverManager.a(this.this$0, 360.0F - this.b.values[0]);
    ArkAppEventObserverManager.b(this.this$0, -this.b.values[1]);
    ArkAppEventObserverManager.c(this.this$0, -this.b.values[2]);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder("onOrientationSensorChange update alpha=");
      localStringBuilder.append(ArkAppEventObserverManager.n(this.this$0));
      localStringBuilder.append(", update beta=");
      localStringBuilder.append(ArkAppEventObserverManager.m(this.this$0));
      localStringBuilder.append(", update gamma=");
      localStringBuilder.append(ArkAppEventObserverManager.l(this.this$0));
      QLog.d("ArkAppEventObserverManager", 2, localStringBuilder.toString());
    }
    if (ArkAppEventObserverManager.o(this.this$0) != null) {
      ArkAppEventObserverManager.o(this.this$0).a(true, ArkAppEventObserverManager.n(this.this$0), ArkAppEventObserverManager.m(this.this$0), ArkAppEventObserverManager.l(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.component.ArkAppEventObserverManager.3
 * JD-Core Version:    0.7.0.1
 */
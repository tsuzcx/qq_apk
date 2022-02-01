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
      localStringBuilder.append(this.jdField_a_of_type_Long);
      localStringBuilder.append(", event[0]=");
      localStringBuilder.append(this.jdField_a_of_type_AndroidHardwareSensorEvent.values[0]);
      localStringBuilder.append(", event[1]=");
      localStringBuilder.append(this.jdField_a_of_type_AndroidHardwareSensorEvent.values[1]);
      localStringBuilder.append(", event[2]=");
      localStringBuilder.append(this.jdField_a_of_type_AndroidHardwareSensorEvent.values[2]);
      QLog.d("ArkAppEventObserverManager", 2, localStringBuilder.toString());
    }
    ArkAppEventObserverManager.a(this.this$0, 360.0F - this.jdField_a_of_type_AndroidHardwareSensorEvent.values[0]);
    ArkAppEventObserverManager.b(this.this$0, -this.jdField_a_of_type_AndroidHardwareSensorEvent.values[1]);
    ArkAppEventObserverManager.c(this.this$0, -this.jdField_a_of_type_AndroidHardwareSensorEvent.values[2]);
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder("onOrientationSensorChange update alpha=");
      localStringBuilder.append(ArkAppEventObserverManager.c(this.this$0));
      localStringBuilder.append(", update beta=");
      localStringBuilder.append(ArkAppEventObserverManager.b(this.this$0));
      localStringBuilder.append(", update gamma=");
      localStringBuilder.append(ArkAppEventObserverManager.a(this.this$0));
      QLog.d("ArkAppEventObserverManager", 2, localStringBuilder.toString());
    }
    if (ArkAppEventObserverManager.a(this.this$0) != null) {
      ArkAppEventObserverManager.a(this.this$0).a(true, ArkAppEventObserverManager.c(this.this$0), ArkAppEventObserverManager.b(this.this$0), ArkAppEventObserverManager.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.component.ArkAppEventObserverManager.3
 * JD-Core Version:    0.7.0.1
 */
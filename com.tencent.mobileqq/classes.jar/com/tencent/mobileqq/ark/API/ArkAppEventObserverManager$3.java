package com.tencent.mobileqq.ark.API;

import aloo;
import alow;
import android.hardware.SensorEvent;
import com.tencent.qphone.base.util.QLog;

public class ArkAppEventObserverManager$3
  implements Runnable
{
  public ArkAppEventObserverManager$3(aloo paramaloo, long paramLong, SensorEvent paramSensorEvent) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppEventObserverManager", 2, "onOrientationSensorChange curTime=" + this.jdField_a_of_type_Long + ", event[0]=" + this.jdField_a_of_type_AndroidHardwareSensorEvent.values[0] + ", event[1]=" + this.jdField_a_of_type_AndroidHardwareSensorEvent.values[1] + ", event[2]=" + this.jdField_a_of_type_AndroidHardwareSensorEvent.values[2]);
    }
    aloo.a(this.this$0, 360.0F - this.jdField_a_of_type_AndroidHardwareSensorEvent.values[0]);
    aloo.b(this.this$0, -this.jdField_a_of_type_AndroidHardwareSensorEvent.values[1]);
    aloo.c(this.this$0, -this.jdField_a_of_type_AndroidHardwareSensorEvent.values[2]);
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppEventObserverManager", 2, "onOrientationSensorChange update alpha=" + aloo.c(this.this$0) + ", update beta=" + aloo.b(this.this$0) + ", update gamma=" + aloo.a(this.this$0));
    }
    if (aloo.a(this.this$0) != null) {
      aloo.a(this.this$0).a(true, aloo.c(this.this$0), aloo.b(this.this$0), aloo.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.3
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.ark.API;

import android.hardware.SensorEvent;
import anff;
import anfn;
import com.tencent.qphone.base.util.QLog;

public class ArkAppEventObserverManager$3
  implements Runnable
{
  public ArkAppEventObserverManager$3(anff paramanff, long paramLong, SensorEvent paramSensorEvent) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppEventObserverManager", 2, "onOrientationSensorChange curTime=" + this.jdField_a_of_type_Long + ", event[0]=" + this.jdField_a_of_type_AndroidHardwareSensorEvent.values[0] + ", event[1]=" + this.jdField_a_of_type_AndroidHardwareSensorEvent.values[1] + ", event[2]=" + this.jdField_a_of_type_AndroidHardwareSensorEvent.values[2]);
    }
    anff.a(this.this$0, 360.0F - this.jdField_a_of_type_AndroidHardwareSensorEvent.values[0]);
    anff.b(this.this$0, -this.jdField_a_of_type_AndroidHardwareSensorEvent.values[1]);
    anff.c(this.this$0, -this.jdField_a_of_type_AndroidHardwareSensorEvent.values[2]);
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppEventObserverManager", 2, "onOrientationSensorChange update alpha=" + anff.c(this.this$0) + ", update beta=" + anff.b(this.this$0) + ", update gamma=" + anff.a(this.this$0));
    }
    if (anff.a(this.this$0) != null) {
      anff.a(this.this$0).a(true, anff.c(this.this$0), anff.b(this.this$0), anff.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.3
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.ark.API;

import android.hardware.SensorEvent;
import apsb;
import apsh;
import com.tencent.qphone.base.util.QLog;

public class ArkAppEventObserverManager$2
  implements Runnable
{
  public ArkAppEventObserverManager$2(apsb paramapsb, SensorEvent paramSensorEvent, long paramLong) {}
  
  public void run()
  {
    int i = 0;
    while (i < 3)
    {
      apsb.a(this.this$0)[i] = ((float)(0.1D * this.jdField_a_of_type_AndroidHardwareSensorEvent.values[i] + 0.9D * apsb.a(this.this$0)[i]));
      apsb.b(this.this$0)[i] = (this.jdField_a_of_type_AndroidHardwareSensorEvent.values[i] - apsb.a(this.this$0)[i]);
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppEventObserverManager", 2, "onMotionSensorChange curTime=" + this.jdField_a_of_type_Long + ", mMotionX=" + apsb.b(this.this$0)[0] + ", mMotionY=" + apsb.b(this.this$0)[1] + ", mMotionZ=" + apsb.b(this.this$0)[2]);
    }
    if (apsb.a(this.this$0) != null) {
      apsb.a(this.this$0).a(true, apsb.b(this.this$0)[0], apsb.b(this.this$0)[1], apsb.b(this.this$0)[2]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.2
 * JD-Core Version:    0.7.0.1
 */
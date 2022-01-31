package com.tencent.mobileqq.ark.API;

import alop;
import alov;
import android.hardware.SensorEvent;
import com.tencent.qphone.base.util.QLog;

public class ArkAppEventObserverManager$2
  implements Runnable
{
  public ArkAppEventObserverManager$2(alop paramalop, SensorEvent paramSensorEvent, long paramLong) {}
  
  public void run()
  {
    int i = 0;
    while (i < 3)
    {
      alop.a(this.this$0)[i] = ((float)(0.1D * this.jdField_a_of_type_AndroidHardwareSensorEvent.values[i] + 0.9D * alop.a(this.this$0)[i]));
      alop.b(this.this$0)[i] = (this.jdField_a_of_type_AndroidHardwareSensorEvent.values[i] - alop.a(this.this$0)[i]);
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppEventObserverManager", 2, "onMotionSensorChange curTime=" + this.jdField_a_of_type_Long + ", mMotionX=" + alop.b(this.this$0)[0] + ", mMotionY=" + alop.b(this.this$0)[1] + ", mMotionZ=" + alop.b(this.this$0)[2]);
    }
    if (alop.a(this.this$0) != null) {
      alop.a(this.this$0).a(true, alop.b(this.this$0)[0], alop.b(this.this$0)[1], alop.b(this.this$0)[2]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.2
 * JD-Core Version:    0.7.0.1
 */
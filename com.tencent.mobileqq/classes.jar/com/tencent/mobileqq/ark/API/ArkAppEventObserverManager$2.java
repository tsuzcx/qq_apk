package com.tencent.mobileqq.ark.API;

import android.hardware.SensorEvent;
import aopa;
import aopg;
import com.tencent.qphone.base.util.QLog;

public class ArkAppEventObserverManager$2
  implements Runnable
{
  public ArkAppEventObserverManager$2(aopa paramaopa, SensorEvent paramSensorEvent, long paramLong) {}
  
  public void run()
  {
    int i = 0;
    while (i < 3)
    {
      aopa.a(this.this$0)[i] = ((float)(0.1D * this.jdField_a_of_type_AndroidHardwareSensorEvent.values[i] + 0.9D * aopa.a(this.this$0)[i]));
      aopa.b(this.this$0)[i] = (this.jdField_a_of_type_AndroidHardwareSensorEvent.values[i] - aopa.a(this.this$0)[i]);
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppEventObserverManager", 2, "onMotionSensorChange curTime=" + this.jdField_a_of_type_Long + ", mMotionX=" + aopa.b(this.this$0)[0] + ", mMotionY=" + aopa.b(this.this$0)[1] + ", mMotionZ=" + aopa.b(this.this$0)[2]);
    }
    if (aopa.a(this.this$0) != null) {
      aopa.a(this.this$0).a(true, aopa.b(this.this$0)[0], aopa.b(this.this$0)[1], aopa.b(this.this$0)[2]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.2
 * JD-Core Version:    0.7.0.1
 */
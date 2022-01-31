package com.tencent.mobileqq.ark.API;

import android.hardware.SensorEvent;
import anjo;
import anju;
import com.tencent.qphone.base.util.QLog;

public class ArkAppEventObserverManager$2
  implements Runnable
{
  public ArkAppEventObserverManager$2(anjo paramanjo, SensorEvent paramSensorEvent, long paramLong) {}
  
  public void run()
  {
    int i = 0;
    while (i < 3)
    {
      anjo.a(this.this$0)[i] = ((float)(0.1D * this.jdField_a_of_type_AndroidHardwareSensorEvent.values[i] + 0.9D * anjo.a(this.this$0)[i]));
      anjo.b(this.this$0)[i] = (this.jdField_a_of_type_AndroidHardwareSensorEvent.values[i] - anjo.a(this.this$0)[i]);
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppEventObserverManager", 2, "onMotionSensorChange curTime=" + this.jdField_a_of_type_Long + ", mMotionX=" + anjo.b(this.this$0)[0] + ", mMotionY=" + anjo.b(this.this$0)[1] + ", mMotionZ=" + anjo.b(this.this$0)[2]);
    }
    if (anjo.a(this.this$0) != null) {
      anjo.a(this.this$0).a(true, anjo.b(this.this$0)[0], anjo.b(this.this$0)[1], anjo.b(this.this$0)[2]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.2
 * JD-Core Version:    0.7.0.1
 */
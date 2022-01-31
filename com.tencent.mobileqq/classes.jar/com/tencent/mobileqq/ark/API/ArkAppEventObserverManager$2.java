package com.tencent.mobileqq.ark.API;

import android.hardware.SensorEvent;
import anff;
import anfl;
import com.tencent.qphone.base.util.QLog;

public class ArkAppEventObserverManager$2
  implements Runnable
{
  public ArkAppEventObserverManager$2(anff paramanff, SensorEvent paramSensorEvent, long paramLong) {}
  
  public void run()
  {
    int i = 0;
    while (i < 3)
    {
      anff.a(this.this$0)[i] = ((float)(0.1D * this.jdField_a_of_type_AndroidHardwareSensorEvent.values[i] + 0.9D * anff.a(this.this$0)[i]));
      anff.b(this.this$0)[i] = (this.jdField_a_of_type_AndroidHardwareSensorEvent.values[i] - anff.a(this.this$0)[i]);
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppEventObserverManager", 2, "onMotionSensorChange curTime=" + this.jdField_a_of_type_Long + ", mMotionX=" + anff.b(this.this$0)[0] + ", mMotionY=" + anff.b(this.this$0)[1] + ", mMotionZ=" + anff.b(this.this$0)[2]);
    }
    if (anff.a(this.this$0) != null) {
      anff.a(this.this$0).a(true, anff.b(this.this$0)[0], anff.b(this.this$0)[1], anff.b(this.this$0)[2]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.2
 * JD-Core Version:    0.7.0.1
 */
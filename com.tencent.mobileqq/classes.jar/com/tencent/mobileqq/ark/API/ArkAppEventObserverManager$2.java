package com.tencent.mobileqq.ark.API;

import android.hardware.SensorEvent;
import apvn;
import apvt;
import com.tencent.qphone.base.util.QLog;

public class ArkAppEventObserverManager$2
  implements Runnable
{
  public ArkAppEventObserverManager$2(apvn paramapvn, SensorEvent paramSensorEvent, long paramLong) {}
  
  public void run()
  {
    int i = 0;
    while (i < 3)
    {
      apvn.a(this.this$0)[i] = ((float)(0.1D * this.jdField_a_of_type_AndroidHardwareSensorEvent.values[i] + 0.9D * apvn.a(this.this$0)[i]));
      apvn.b(this.this$0)[i] = (this.jdField_a_of_type_AndroidHardwareSensorEvent.values[i] - apvn.a(this.this$0)[i]);
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppEventObserverManager", 2, "onMotionSensorChange curTime=" + this.jdField_a_of_type_Long + ", mMotionX=" + apvn.b(this.this$0)[0] + ", mMotionY=" + apvn.b(this.this$0)[1] + ", mMotionZ=" + apvn.b(this.this$0)[2]);
    }
    if (apvn.a(this.this$0) != null) {
      apvn.a(this.this$0).a(true, apvn.b(this.this$0)[0], apvn.b(this.this$0)[1], apvn.b(this.this$0)[2]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.2
 * JD-Core Version:    0.7.0.1
 */
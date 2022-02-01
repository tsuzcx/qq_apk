package com.tencent.mobileqq.ark.API;

import android.hardware.SensorEvent;
import com.tencent.qphone.base.util.QLog;

class ArkAppEventObserverManager$2
  implements Runnable
{
  ArkAppEventObserverManager$2(ArkAppEventObserverManager paramArkAppEventObserverManager, SensorEvent paramSensorEvent, long paramLong) {}
  
  public void run()
  {
    int i = 0;
    while (i < 3)
    {
      ArkAppEventObserverManager.a(this.this$0)[i] = ((float)(0.1D * this.jdField_a_of_type_AndroidHardwareSensorEvent.values[i] + 0.9D * ArkAppEventObserverManager.a(this.this$0)[i]));
      ArkAppEventObserverManager.b(this.this$0)[i] = (this.jdField_a_of_type_AndroidHardwareSensorEvent.values[i] - ArkAppEventObserverManager.a(this.this$0)[i]);
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ArkAppEventObserverManager", 2, "onMotionSensorChange curTime=" + this.jdField_a_of_type_Long + ", mMotionX=" + ArkAppEventObserverManager.b(this.this$0)[0] + ", mMotionY=" + ArkAppEventObserverManager.b(this.this$0)[1] + ", mMotionZ=" + ArkAppEventObserverManager.b(this.this$0)[2]);
    }
    if (ArkAppEventObserverManager.a(this.this$0) != null) {
      ArkAppEventObserverManager.a(this.this$0).a(true, ArkAppEventObserverManager.b(this.this$0)[0], ArkAppEventObserverManager.b(this.this$0)[1], ArkAppEventObserverManager.b(this.this$0)[2]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.API.ArkAppEventObserverManager.2
 * JD-Core Version:    0.7.0.1
 */
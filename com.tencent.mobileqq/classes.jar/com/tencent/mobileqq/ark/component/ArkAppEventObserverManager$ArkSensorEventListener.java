package com.tencent.mobileqq.ark.component;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

class ArkAppEventObserverManager$ArkSensorEventListener
  implements SensorEventListener
{
  ArkAppEventObserverManager$ArkSensorEventListener(ArkAppEventObserverManager paramArkAppEventObserverManager) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent.sensor.getType() == 1)
    {
      ArkAppEventObserverManager.a(this.a, paramSensorEvent);
      return;
    }
    if (paramSensorEvent.sensor.getType() == 3) {
      ArkAppEventObserverManager.b(this.a, paramSensorEvent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.component.ArkAppEventObserverManager.ArkSensorEventListener
 * JD-Core Version:    0.7.0.1
 */
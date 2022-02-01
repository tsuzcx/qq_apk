package com.tencent.mobileqq.ar.arengine;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

class ARCamera$2
  implements SensorEventListener
{
  ARCamera$2(ARCamera paramARCamera) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (1 != paramSensorEvent.sensor.getType()) {
      return;
    }
    paramSensorEvent = paramSensorEvent.values;
    float f1 = paramSensorEvent[0];
    float f2 = paramSensorEvent[1];
    double d1 = Math.sqrt(f1 * f1 + f2 * f2);
    double d2 = f2;
    Double.isNaN(d2);
    d1 = d2 / d1;
    d2 = -1.0D;
    if (d1 > 1.0D) {
      d1 = 1.0D;
    } else if (d1 < -1.0D) {
      d1 = d2;
    }
    d2 = Math.acos(d1);
    d1 = d2;
    if (f1 < 0.0F) {
      d1 = 6.283185307179586D - d2;
    }
    int i = (int)(d1 * 57.295779513082323D);
    ARCamera.a(this.a, (i + 45) / 90 * 90);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARCamera.2
 * JD-Core Version:    0.7.0.1
 */
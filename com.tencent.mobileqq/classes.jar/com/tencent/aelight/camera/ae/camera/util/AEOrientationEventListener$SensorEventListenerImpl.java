package com.tencent.aelight.camera.ae.camera.util;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.view.OrientationListener;

class AEOrientationEventListener$SensorEventListenerImpl
  implements SensorEventListener
{
  AEOrientationEventListener$SensorEventListenerImpl(AEOrientationEventListener paramAEOrientationEventListener) {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    float[] arrayOfFloat = paramSensorEvent.values;
    float f1 = -arrayOfFloat[0];
    float f2 = -arrayOfFloat[1];
    float f3 = -arrayOfFloat[2];
    if ((f1 * f1 + f2 * f2) * 35.0F >= f3 * f3)
    {
      j = 90 - Math.round((float)Math.atan2(-f2, f1) * 57.29578F);
      int i;
      for (;;)
      {
        i = j;
        if (j < 360) {
          break;
        }
        j -= 360;
      }
      for (;;)
      {
        j = i;
        if (i >= 0) {
          break;
        }
        i += 360;
      }
    }
    int j = -1;
    if (AEOrientationEventListener.access$000(this.a) != null) {
      AEOrientationEventListener.access$000(this.a).onSensorChanged(1, paramSensorEvent.values);
    }
    if (j != AEOrientationEventListener.access$100(this.a))
    {
      AEOrientationEventListener.access$102(this.a, j);
      this.a.onOrientationChanged(j);
    }
    this.a.onPoseChanged((f1 + 9.8F) * 180.0F / 19.6F, (f2 + 9.8F) * 180.0F / 19.6F, (f3 + 9.8F) * 180.0F / 19.6F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.camera.util.AEOrientationEventListener.SensorEventListenerImpl
 * JD-Core Version:    0.7.0.1
 */
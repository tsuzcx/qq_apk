package com.tencent.biz.widgets;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.lang.ref.WeakReference;

public class SelfLocationOverlay$SensorListener
  implements SensorEventListener
{
  public WeakReference a;
  public WeakReference b;
  
  public SelfLocationOverlay$SensorListener(SelfLocationOverlay paramSelfLocationOverlay, SensorManager paramSensorManager)
  {
    this.a = new WeakReference(paramSelfLocationOverlay);
    this.b = new WeakReference(paramSensorManager);
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent.sensor.getType() == 3)
    {
      float f = paramSensorEvent.values[0];
      paramSensorEvent = (SelfLocationOverlay)this.a.get();
      if (paramSensorEvent == null) {
        break label39;
      }
      paramSensorEvent.a(f);
    }
    label39:
    do
    {
      return;
      paramSensorEvent = (SensorManager)this.b.get();
    } while (paramSensorEvent == null);
    try
    {
      paramSensorEvent.unregisterListener(this);
      return;
    }
    catch (Exception paramSensorEvent)
    {
      paramSensorEvent.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.widgets.SelfLocationOverlay.SensorListener
 * JD-Core Version:    0.7.0.1
 */
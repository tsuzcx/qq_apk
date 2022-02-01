package com.tencent.biz.game;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

public class SensorAPIJavaScript$QQSensorEventListener
  implements SensorEventListener
{
  protected byte a;
  protected String b;
  
  public SensorAPIJavaScript$QQSensorEventListener(SensorAPIJavaScript paramSensorAPIJavaScript, byte paramByte, String paramString)
  {
    this.a = paramByte;
    this.b = paramString;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    int i = this.a;
    if (i != 0)
    {
      if (i != 1)
      {
        if (i != 2) {
          return;
        }
        f1 = paramSensorEvent.values[0];
        this.c.callJs(this.b, new String[] { String.valueOf(true), String.valueOf(f1) });
        return;
      }
      f1 = paramSensorEvent.values[0];
      this.c.callJs(this.b, new String[] { String.valueOf(true), String.valueOf(f1) });
      return;
    }
    float f1 = paramSensorEvent.values[0];
    float f2 = paramSensorEvent.values[1];
    float f3 = paramSensorEvent.values[2];
    this.c.callJs(this.b, new String[] { String.valueOf(true), String.valueOf(f1), String.valueOf(f2), String.valueOf(f3) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.game.SensorAPIJavaScript.QQSensorEventListener
 * JD-Core Version:    0.7.0.1
 */
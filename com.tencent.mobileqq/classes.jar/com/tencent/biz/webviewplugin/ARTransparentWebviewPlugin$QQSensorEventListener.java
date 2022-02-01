package com.tencent.biz.webviewplugin;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build.VERSION;

public class ARTransparentWebviewPlugin$QQSensorEventListener
  implements SensorEventListener
{
  protected byte a;
  protected String b;
  
  public ARTransparentWebviewPlugin$QQSensorEventListener(ARTransparentWebviewPlugin paramARTransparentWebviewPlugin, byte paramByte, String paramString)
  {
    this.a = paramByte;
    this.b = paramString;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (this.a != 3) {
      return;
    }
    float[] arrayOfFloat = new float[4];
    if (Build.VERSION.SDK_INT >= 9)
    {
      SensorManager localSensorManager = this.c.b;
      SensorManager.getQuaternionFromVector(arrayOfFloat, paramSensorEvent.values);
      ARTransparentWebviewPlugin.a(this.c)[0] = arrayOfFloat[1];
      ARTransparentWebviewPlugin.a(this.c)[1] = arrayOfFloat[2];
      ARTransparentWebviewPlugin.a(this.c)[2] = arrayOfFloat[3];
      ARTransparentWebviewPlugin.a(this.c)[3] = arrayOfFloat[0];
    }
    if ((ARTransparentWebviewPlugin.c()) && (ARTransparentWebviewPlugin.d())) {
      this.c.callJs(this.b, new String[] { String.valueOf(true), String.valueOf(ARTransparentWebviewPlugin.a(this.c)[0]), String.valueOf(ARTransparentWebviewPlugin.a(this.c)[1]), String.valueOf(ARTransparentWebviewPlugin.a(this.c)[2]), String.valueOf(ARTransparentWebviewPlugin.a(this.c)[3]) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.ARTransparentWebviewPlugin.QQSensorEventListener
 * JD-Core Version:    0.7.0.1
 */
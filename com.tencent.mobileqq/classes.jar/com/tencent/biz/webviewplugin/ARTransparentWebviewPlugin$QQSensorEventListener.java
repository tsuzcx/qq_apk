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
  protected String a;
  
  public ARTransparentWebviewPlugin$QQSensorEventListener(ARTransparentWebviewPlugin paramARTransparentWebviewPlugin, byte paramByte, String paramString)
  {
    this.jdField_a_of_type_Byte = paramByte;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    switch (this.jdField_a_of_type_Byte)
    {
    }
    do
    {
      return;
      float[] arrayOfFloat = new float[4];
      if (Build.VERSION.SDK_INT >= 9)
      {
        SensorManager localSensorManager = this.jdField_a_of_type_ComTencentBizWebviewpluginARTransparentWebviewPlugin.a;
        SensorManager.getQuaternionFromVector(arrayOfFloat, paramSensorEvent.values);
        ARTransparentWebviewPlugin.a(this.jdField_a_of_type_ComTencentBizWebviewpluginARTransparentWebviewPlugin)[0] = arrayOfFloat[1];
        ARTransparentWebviewPlugin.a(this.jdField_a_of_type_ComTencentBizWebviewpluginARTransparentWebviewPlugin)[1] = arrayOfFloat[2];
        ARTransparentWebviewPlugin.a(this.jdField_a_of_type_ComTencentBizWebviewpluginARTransparentWebviewPlugin)[2] = arrayOfFloat[3];
        ARTransparentWebviewPlugin.a(this.jdField_a_of_type_ComTencentBizWebviewpluginARTransparentWebviewPlugin)[3] = arrayOfFloat[0];
      }
    } while ((!ARTransparentWebviewPlugin.a()) || (!ARTransparentWebviewPlugin.b()));
    this.jdField_a_of_type_ComTencentBizWebviewpluginARTransparentWebviewPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { String.valueOf(true), String.valueOf(ARTransparentWebviewPlugin.a(this.jdField_a_of_type_ComTencentBizWebviewpluginARTransparentWebviewPlugin)[0]), String.valueOf(ARTransparentWebviewPlugin.a(this.jdField_a_of_type_ComTencentBizWebviewpluginARTransparentWebviewPlugin)[1]), String.valueOf(ARTransparentWebviewPlugin.a(this.jdField_a_of_type_ComTencentBizWebviewpluginARTransparentWebviewPlugin)[2]), String.valueOf(ARTransparentWebviewPlugin.a(this.jdField_a_of_type_ComTencentBizWebviewpluginARTransparentWebviewPlugin)[3]) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.ARTransparentWebviewPlugin.QQSensorEventListener
 * JD-Core Version:    0.7.0.1
 */
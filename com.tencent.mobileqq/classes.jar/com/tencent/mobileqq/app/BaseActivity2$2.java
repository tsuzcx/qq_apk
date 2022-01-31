package com.tencent.mobileqq.app;

import alox;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import azsd;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;

class BaseActivity2$2
  implements Runnable
{
  BaseActivity2$2(BaseActivity2 paramBaseActivity2) {}
  
  public void run()
  {
    int i = 0;
    boolean bool = SettingCloneUtil.readValue(this.this$0, null, this.this$0.getString(2131695444), "qqsetting_screenshot_key", false);
    if ((bool) && (BaseActivity2.access$300() == null))
    {
      localalox = new alox(null);
      localSensorManager = (SensorManager)this.this$0.getSystemService("sensor");
      localSensor = localSensorManager.getDefaultSensor(1);
      if (azsd.a().a()) {
        i = 2;
      }
      localSensorManager.registerListener(localalox, localSensor, i);
      BaseActivity2.access$302(localalox);
    }
    while ((bool) || (BaseActivity2.access$300() == null))
    {
      alox localalox;
      SensorManager localSensorManager;
      Sensor localSensor;
      return;
    }
    ((SensorManager)this.this$0.getSystemService("sensor")).unregisterListener(BaseActivity2.access$300());
    BaseActivity2.access$302(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.BaseActivity2.2
 * JD-Core Version:    0.7.0.1
 */
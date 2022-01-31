package com.tencent.mobileqq.app;

import alki;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import aznu;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;

class BaseActivity2$2
  implements Runnable
{
  BaseActivity2$2(BaseActivity2 paramBaseActivity2) {}
  
  public void run()
  {
    int i = 0;
    boolean bool = SettingCloneUtil.readValue(this.this$0, null, this.this$0.getString(2131695442), "qqsetting_screenshot_key", false);
    if ((bool) && (BaseActivity2.access$300() == null))
    {
      localalki = new alki(null);
      localSensorManager = (SensorManager)this.this$0.getSystemService("sensor");
      localSensor = localSensorManager.getDefaultSensor(1);
      if (aznu.a().a()) {
        i = 2;
      }
      localSensorManager.registerListener(localalki, localSensor, i);
      BaseActivity2.access$302(localalki);
    }
    while ((bool) || (BaseActivity2.access$300() == null))
    {
      alki localalki;
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
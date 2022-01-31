package com.tencent.mobileqq.app;

import ajev;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import awsh;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;

class BaseActivity2$2
  implements Runnable
{
  BaseActivity2$2(BaseActivity2 paramBaseActivity2) {}
  
  public void run()
  {
    int i = 0;
    boolean bool = SettingCloneUtil.readValue(this.this$0, null, this.this$0.getString(2131629602), "qqsetting_screenshot_key", false);
    if ((bool) && (BaseActivity2.a() == null))
    {
      localajev = new ajev(null);
      localSensorManager = (SensorManager)this.this$0.getSystemService("sensor");
      localSensor = localSensorManager.getDefaultSensor(1);
      if (awsh.a().a()) {
        i = 2;
      }
      localSensorManager.registerListener(localajev, localSensor, i);
      BaseActivity2.a(localajev);
    }
    while ((bool) || (BaseActivity2.a() == null))
    {
      ajev localajev;
      SensorManager localSensorManager;
      Sensor localSensor;
      return;
    }
    ((SensorManager)this.this$0.getSystemService("sensor")).unregisterListener(BaseActivity2.a());
    BaseActivity2.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.BaseActivity2.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.app;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.qqperf.monitor.backgroundcpu.BackgroundCpuMonitor;

class BaseActivity2$2
  implements Runnable
{
  BaseActivity2$2(BaseActivity2 paramBaseActivity2) {}
  
  public void run()
  {
    Object localObject1 = this.this$0;
    Object localObject2 = ((BaseActivity2)localObject1).getString(2131694975);
    int i = 0;
    boolean bool = SettingCloneUtil.readValue((Context)localObject1, null, (String)localObject2, "qqsetting_screenshot_key", false);
    if ((bool) && (BaseActivity2.a() == null))
    {
      localObject1 = new BaseActivity2.MyShakeListener(null);
      localObject2 = (SensorManager)this.this$0.getSystemService("sensor");
      Sensor localSensor = ((SensorManager)localObject2).getDefaultSensor(1);
      if (BackgroundCpuMonitor.a().a()) {
        i = 2;
      }
      ((SensorManager)localObject2).registerListener((SensorEventListener)localObject1, localSensor, i);
      BaseActivity2.a((ShakeListener)localObject1);
      return;
    }
    if ((!bool) && (BaseActivity2.a() != null))
    {
      ((SensorManager)this.this$0.getSystemService("sensor")).unregisterListener(BaseActivity2.a());
      BaseActivity2.a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.BaseActivity2.2
 * JD-Core Version:    0.7.0.1
 */
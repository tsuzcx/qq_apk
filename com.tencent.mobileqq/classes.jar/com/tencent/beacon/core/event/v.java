package com.tencent.beacon.core.event;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import java.util.HashMap;
import java.util.Map;

public class v
  implements SensorEventListener, Runnable
{
  public static Map<Integer, String> a = new HashMap();
  private long b = 0L;
  private u c;
  private int d = 0;
  private long e = 0L;
  protected Context f;
  private SensorManager g;
  
  static
  {
    a.put(Integer.valueOf(1), "A126");
    a.put(Integer.valueOf(4), "A127");
    a.put(Integer.valueOf(2), "A128");
  }
  
  private void a()
  {
    SensorManager localSensorManager = this.g;
    if (localSensorManager != null) {
      localSensorManager.unregisterListener(this);
    }
  }
  
  public void a(Context paramContext)
  {
    this.g = ((SensorManager)paramContext.getSystemService("sensor"));
    if (this.g == null) {}
    int i;
    do
    {
      return;
      paramContext = EventStrategyBean.getInstance();
      i = 1000000 / paramContext.getHertzCount();
      SensorManager localSensorManager;
      if (paramContext.isAcceleEnable())
      {
        com.tencent.beacon.core.e.d.d("[sensor] AcceleEnable", new Object[0]);
        localSensorManager = this.g;
        localSensorManager.registerListener(this, localSensorManager.getDefaultSensor(1), i);
      }
      if (paramContext.isGyroEnable())
      {
        com.tencent.beacon.core.e.d.d("[sensor] GyroEnable", new Object[0]);
        localSensorManager = this.g;
        localSensorManager.registerListener(this, localSensorManager.getDefaultSensor(4), i);
      }
    } while (!paramContext.isMagneticEnable());
    com.tencent.beacon.core.e.d.d("[sensor] MagneticEnable", new Object[0]);
    paramContext = this.g;
    paramContext.registerListener(this, paramContext.getDefaultSensor(2), i);
  }
  
  public void b(Context paramContext)
  {
    if (!EventStrategyBean.getInstance().isSensorEnable()) {
      return;
    }
    this.f = paramContext;
    int i = EventStrategyBean.getInstance().getConsuming();
    com.tencent.beacon.core.e.d.d("[sensor] startEvent consuming : %d", new Object[] { Integer.valueOf(i) });
    this.e = EventStrategyBean.getInstance().getGatherDur();
    com.tencent.beacon.core.a.d.a().a(111, this, 10000L, i * 1000);
  }
  
  public void c(Context paramContext)
  {
    com.tencent.beacon.core.a.d.a().a(111, true);
    com.tencent.beacon.core.e.d.d("[sensor] cancel next record", new Object[0]);
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (this.d <= 0)
    {
      this.c = null;
      com.tencent.beacon.core.e.d.d("[sensor] unregisterSensorListener", new Object[0]);
      a();
      return;
    }
    if (System.currentTimeMillis() - this.b >= this.e)
    {
      u localu = this.c;
      if (localu != null)
      {
        localu.a();
        this.b = System.currentTimeMillis();
        this.c = null;
        this.d -= 1;
        com.tencent.beacon.core.e.d.d("[sensor] report sensor event and %d times left ", new Object[] { Integer.valueOf(this.d) });
      }
    }
    if (this.c == null) {
      this.c = new u();
    }
    this.c.a((String)a.get(Integer.valueOf(paramSensorEvent.sensor.getType())), paramSensorEvent.values);
  }
  
  public void run()
  {
    a(this.f);
    this.b = System.currentTimeMillis();
    this.d = EventStrategyBean.getInstance().getGatherCount();
    com.tencent.beacon.core.e.d.d("[sensor] start a record", new Object[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.core.event.v
 * JD-Core Version:    0.7.0.1
 */
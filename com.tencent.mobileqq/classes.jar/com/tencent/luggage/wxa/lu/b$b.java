package com.tencent.luggage.wxa.lu;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.pd.h;
import com.tencent.luggage.wxa.qz.o;

abstract class b$b
  extends j.a
  implements SensorEventListener
{
  private h a;
  b.a d = new b.a();
  
  b$b(c paramc)
  {
    super(paramc);
    this.d.b(paramc);
    this.a = new h(i.b(), new b.b.1(this, paramc));
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent.sensor.getType() != 1) {
      return;
    }
    paramSensorEvent = paramSensorEvent.values;
    if ((paramSensorEvent != null) && (paramSensorEvent.length >= 3))
    {
      o.f("MicroMsg.JsApiEnableAccelerometer", "try to do frequency limit action(%s).", new Object[] { Boolean.valueOf(this.a.a(new Object[] { paramSensorEvent })) });
      return;
    }
    o.c("MicroMsg.JsApiEnableAccelerometer", "ACCELEROMETER sensor callback data invalidate.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lu.b.b
 * JD-Core Version:    0.7.0.1
 */
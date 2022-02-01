package com.tencent.luggage.wxa.lu;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.pd.h;
import com.tencent.luggage.wxa.qz.o;

abstract class d$b
  extends j.a
  implements SensorEventListener
{
  private boolean a;
  private h b;
  d.a d = new d.a();
  
  d$b(c paramc)
  {
    super(paramc);
    this.d.b(paramc);
    this.b = new h(i.b(), new d.b.1(this, paramc));
  }
  
  public void a(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (this.a) {
      return;
    }
    if (paramSensorEvent.sensor.getType() != 3) {
      return;
    }
    paramSensorEvent = paramSensorEvent.values;
    if ((paramSensorEvent != null) && (paramSensorEvent.length >= 3))
    {
      o.f("MicroMsg.JsApiEnableDeviceMotion", "try to do frequency limit action(%s).", new Object[] { Boolean.valueOf(this.b.a(new Object[] { paramSensorEvent })) });
      return;
    }
    o.c("MicroMsg.JsApiEnableDeviceMotion", "deviceMotion sensor callback data invalidate.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lu.d.b
 * JD-Core Version:    0.7.0.1
 */
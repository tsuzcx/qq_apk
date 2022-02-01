package com.tencent.luggage.wxa.lu;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.luggage.wxa.jx.c;
import com.tencent.luggage.wxa.pd.h;
import com.tencent.luggage.wxa.qz.o;

abstract class c$b
  extends j.a
  implements SensorEventListener
{
  private boolean a;
  private float[] b = new float[3];
  private float[] c = new float[3];
  c.a d = new c.a();
  private h e;
  private String f = "unknow";
  private int g = 0;
  
  c$b(c paramc)
  {
    super(paramc);
    this.d.b(paramc);
    this.e = new h(i.b(), new c.b.1(this, paramc));
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
    if ((paramSensorEvent.values != null) && (paramSensorEvent.values.length >= 3))
    {
      if (paramSensorEvent.sensor.getType() == 2)
      {
        this.c = paramSensorEvent.values;
        int i = paramSensorEvent.accuracy;
        if (i != -1)
        {
          if (i != 0)
          {
            if (i != 1)
            {
              if (i != 2)
              {
                if (i != 3)
                {
                  this.f = "unknow";
                  this.g = paramSensorEvent.accuracy;
                }
                else
                {
                  this.f = "high";
                }
              }
              else {
                this.f = "medium";
              }
            }
            else {
              this.f = "low";
            }
          }
          else {
            this.f = "unreliable";
          }
        }
        else {
          this.f = "no-contact";
        }
      }
      else
      {
        if (paramSensorEvent.sensor.getType() != 1) {
          break label184;
        }
        this.b = paramSensorEvent.values;
      }
      o.f("MicroMsg.JsApiEnableCompass", "try to do frequency limit action(%s).", new Object[] { Boolean.valueOf(this.e.a(new Object[0])) });
      label184:
      return;
    }
    o.c("MicroMsg.JsApiEnableCompass", "compass sensor callback data invalidate.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lu.c.b
 * JD-Core Version:    0.7.0.1
 */
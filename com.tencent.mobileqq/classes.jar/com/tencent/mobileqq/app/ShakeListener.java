package com.tencent.mobileqq.app;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.tencent.qphone.base.util.QLog;

public class ShakeListener
  implements SensorEventListener
{
  private long a;
  private float b;
  private float c;
  private float d;
  private float e;
  private int f = 0;
  
  private void a(long paramLong)
  {
    this.a = paramLong;
    this.b = 0.0F;
    this.c = 0.0F;
    this.d = 0.0F;
    this.e = 0.0F;
    this.f = 0;
  }
  
  protected void a() {}
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    if (paramSensorEvent.sensor.getType() == 1)
    {
      float f2 = paramSensorEvent.values[0];
      float f3 = paramSensorEvent.values[1];
      float f4 = paramSensorEvent.values[2];
      long l1 = System.currentTimeMillis();
      long l2 = l1 - this.a;
      if (l2 > 5000L)
      {
        a(l1);
        return;
      }
      if (l2 > 80L)
      {
        float f5 = this.b;
        float f1 = 0.0F;
        if ((f5 != 0.0F) || (this.c != 0.0F) || (this.d != 0.0F))
        {
          f1 = Math.abs(f2 - this.b);
          f5 = Math.abs(f3 - this.c);
          f1 = Math.abs(f4 - this.d) + (f1 + f5);
        }
        this.e += f1;
        if ((this.e > 180.0F) && (this.f >= 3))
        {
          if (QLog.isColorLevel())
          {
            paramSensorEvent = new StringBuilder();
            paramSensorEvent.append("now[");
            paramSensorEvent.append(f2);
            paramSensorEvent.append(",");
            paramSensorEvent.append(f3);
            paramSensorEvent.append(",");
            paramSensorEvent.append(f4);
            paramSensorEvent.append("]duration:");
            paramSensorEvent.append(l2);
            paramSensorEvent.append(" shake:");
            paramSensorEvent.append(f1);
            QLog.d("CIO_test", 2, paramSensorEvent.toString());
            paramSensorEvent = new StringBuilder();
            paramSensorEvent.append("last[");
            paramSensorEvent.append(this.b);
            paramSensorEvent.append(",");
            paramSensorEvent.append(this.c);
            paramSensorEvent.append(",");
            paramSensorEvent.append(this.d);
            paramSensorEvent.append("]total_shake:");
            paramSensorEvent.append(f1);
            QLog.d("CIO_test", 2, paramSensorEvent.toString());
          }
          a();
          a(l1);
          return;
        }
        int i = this.f;
        if (i < 10)
        {
          this.f = (i + 1);
          this.b = f2;
          this.c = f3;
          this.d = f4;
          this.a = l1;
          return;
        }
        a(l1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.ShakeListener
 * JD-Core Version:    0.7.0.1
 */
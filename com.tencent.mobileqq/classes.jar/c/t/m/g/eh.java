package c.t.m.g;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import android.os.Handler;
import com.tencent.map.geolocation.TencentDirectionListener;

public final class eh
  implements SensorEventListener
{
  private static volatile eh h;
  public volatile boolean a;
  private SensorManager b;
  private final boolean c;
  private boolean d;
  private double e;
  private int f;
  private TencentDirectionListener g;
  
  private eh(Context paramContext)
  {
    boolean bool = false;
    this.a = false;
    try
    {
      if (Build.VERSION.SDK_INT != 23) {
        this.b = ((SensorManager)paramContext.getSystemService("sensor"));
      }
      label32:
      if (this.b != null) {
        bool = true;
      }
      this.c = bool;
      return;
    }
    catch (Throwable paramContext)
    {
      break label32;
    }
  }
  
  public static eh a(Context paramContext)
  {
    if (h == null) {
      h = new eh(paramContext);
    }
    return h;
  }
  
  public final int a(Handler paramHandler, TencentDirectionListener paramTencentDirectionListener)
  {
    if (!this.c) {
      return 2;
    }
    Object localObject1;
    if (!this.d) {
      localObject1 = null;
    }
    try
    {
      localObject2 = this.b.getDefaultSensor(11);
      localObject1 = localObject2;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        try
        {
          Object localObject2 = this.b.getDefaultSensor(3);
          if (localObject2 != null)
          {
            this.b.registerListener(this, (Sensor)localObject2, 3, paramHandler);
            this.g = paramTencentDirectionListener;
            this.d = true;
          }
          else
          {
            return 3;
          }
          return 0;
        }
        catch (Throwable paramHandler) {}
        localThrowable = localThrowable;
      }
    }
    localObject2 = localObject1;
    if (localObject1 == null) {}
    return 3;
  }
  
  public final void a()
  {
    try
    {
      if (!this.c) {
        return;
      }
      if (this.d)
      {
        this.d = false;
        this.e = (0.0D / 0.0D);
        this.b.unregisterListener(this);
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public final double b()
  {
    if (this.d) {
      try
      {
        double d1 = this.e;
        return d1;
      }
      finally {}
    }
    return (0.0D / 0.0D);
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt)
  {
    try
    {
      if ((paramSensor.getType() == 11) || (paramSensor.getType() == 3)) {
        this.f = paramInt;
      }
      return;
    }
    catch (Throwable paramSensor) {}
  }
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    try
    {
      double d1;
      if (paramSensorEvent.sensor.getType() == 11)
      {
        float[] arrayOfFloat1 = new float[16];
        float[] arrayOfFloat2 = new float[3];
        SensorManager.getRotationMatrixFromVector(arrayOfFloat1, paramSensorEvent.values);
        SensorManager.getOrientation(arrayOfFloat1, arrayOfFloat2);
        d1 = arrayOfFloat2[0];
        Double.isNaN(d1);
        d1 = d1 * 180.0D / 3.1415926D;
        try
        {
          this.e = d1;
          if (this.g != null) {
            this.g.onDirectionChanged(this.e, this.f);
          }
          return;
        }
        finally {}
      }
      if (paramSensorEvent.sensor.getType() == 3)
      {
        float f2 = paramSensorEvent.values[0] - 360.0F;
        float f1 = f2;
        if (f2 <= -180.0F) {
          f1 = f2 + 360.0F;
        }
        d1 = f1;
        try
        {
          this.e = d1;
          if (this.g != null) {
            this.g.onDirectionChanged(this.e, this.f);
          }
          return;
        }
        finally {}
      }
      return;
    }
    catch (Throwable paramSensorEvent) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.eh
 * JD-Core Version:    0.7.0.1
 */
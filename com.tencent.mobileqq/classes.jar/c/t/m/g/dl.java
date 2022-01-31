package c.t.m.g;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;
import com.tencent.map.geolocation.TencentDirectionListener;

final class dl
  implements SensorEventListener
{
  private static volatile dl h;
  private SensorManager a;
  private final boolean b;
  private boolean c;
  private double d;
  private int e;
  private volatile boolean f = false;
  private TencentDirectionListener g;
  
  private dl(Context paramContext)
  {
    try
    {
      this.a = ((SensorManager)paramContext.getSystemService("sensor"));
      label22:
      if (this.a != null) {}
      for (boolean bool = true;; bool = false)
      {
        this.b = bool;
        return;
      }
    }
    catch (Throwable paramContext)
    {
      break label22;
    }
  }
  
  public static dl a(Context paramContext)
  {
    if (h == null) {
      h = new dl(paramContext);
    }
    return h;
  }
  
  public final int a(Handler paramHandler, TencentDirectionListener paramTencentDirectionListener)
  {
    int i = 3;
    if (!this.b) {
      i = 2;
    }
    for (;;)
    {
      return i;
      Object localObject1;
      if (!this.c) {
        localObject1 = null;
      }
      try
      {
        localObject2 = this.a.getDefaultSensor(11);
        localObject1 = localObject2;
      }
      catch (Throwable localThrowable)
      {
        Object localObject2;
        label38:
        break label38;
      }
      localObject2 = localObject1;
      if (localObject1 == null) {}
      try
      {
        localObject2 = this.a.getDefaultSensor(3);
        if (localObject2 == null) {
          continue;
        }
        this.a.registerListener(this, (Sensor)localObject2, 3, paramHandler);
        this.g = paramTencentDirectionListener;
        this.c = true;
        return 0;
      }
      catch (Throwable paramHandler)
      {
        return 3;
      }
    }
  }
  
  public final boolean a()
  {
    return this.f;
  }
  
  public final void b()
  {
    this.f = true;
  }
  
  public final void c()
  {
    try
    {
      if (!this.b) {
        return;
      }
      if (this.c)
      {
        this.c = false;
        this.d = (0.0D / 0.0D);
        this.a.unregisterListener(this);
        return;
      }
    }
    catch (Exception localException) {}
  }
  
  public final double d()
  {
    if (this.c) {
      try
      {
        double d1 = this.d;
        return d1;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    return (0.0D / 0.0D);
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt)
  {
    try
    {
      if ((paramSensor.getType() == 11) || (paramSensor.getType() == 3)) {
        this.e = paramInt;
      }
      return;
    }
    catch (Throwable paramSensor) {}
  }
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    try
    {
      if (paramSensorEvent.sensor.getType() == 11)
      {
        arrayOfFloat1 = new float[16];
        arrayOfFloat2 = new float[3];
        SensorManager.getRotationMatrixFromVector(arrayOfFloat1, paramSensorEvent.values);
        SensorManager.getOrientation(arrayOfFloat1, arrayOfFloat2);
        d1 = arrayOfFloat2[0];
        d1 = d1 * 180.0D / 3.1415926D;
      }
      while (paramSensorEvent.sensor.getType() != 3) {
        try
        {
          float[] arrayOfFloat1;
          float[] arrayOfFloat2;
          this.d = d1;
          if (this.g != null) {
            this.g.onDirectionChanged(this.d, this.e);
          }
          return;
        }
        finally {}
      }
      float f2 = paramSensorEvent.values[0] - 360.0F;
      float f1 = f2;
      if (f2 <= -180.0F) {
        f1 = f2 + 360.0F;
      }
      double d1 = f1;
      try
      {
        this.d = d1;
        if (this.g != null) {
          this.g.onDirectionChanged(this.d, this.e);
        }
        return;
      }
      finally {}
      return;
    }
    catch (Throwable paramSensorEvent) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.dl
 * JD-Core Version:    0.7.0.1
 */
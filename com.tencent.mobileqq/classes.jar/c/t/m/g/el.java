package c.t.m.g;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import java.util.LinkedList;

public final class el
  implements SensorEventListener, ee
{
  static Context f;
  static SharedPreferences i;
  private static volatile el j;
  dv a = new dv();
  SensorManager b;
  Sensor c;
  Sensor d;
  Sensor e;
  HandlerThread g;
  public int h = 0;
  private long k = 0L;
  private long l = 0L;
  private double m = 0.0D;
  private boolean n = false;
  private String o = "unknown";
  private int p = 0;
  private int q = 0;
  
  private void a(boolean paramBoolean)
  {
    SensorManager localSensorManager;
    if (this.n)
    {
      localSensorManager = this.b;
      if (localSensorManager == null) {}
    }
    try
    {
      localSensorManager.unregisterListener(this, this.c);
      this.b.unregisterListener(this, this.d);
      try
      {
        label37:
        if ((Build.VERSION.SDK_INT >= 19) && (this.e != null)) {
          this.b.unregisterListener(this, this.e);
        }
      }
      catch (Throwable localThrowable2)
      {
        label67:
        break label67;
      }
      this.k = 0L;
      this.l = 0L;
      if (paramBoolean) {
        this.o = "vehicle";
      } else {
        this.o = "unknown";
      }
      this.n = false;
      return;
    }
    catch (Throwable localThrowable1)
    {
      break label37;
    }
  }
  
  public static el b()
  {
    if (j == null) {
      j = new el();
    }
    return j;
  }
  
  public final void a()
  {
    this.l = System.currentTimeMillis();
    this.h += 1;
    this.p += 1;
  }
  
  public final void a(int paramInt, double paramDouble1, double paramDouble2, long paramLong)
  {
    StringBuilder localStringBuilder = new StringBuilder("speedType:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("speed:");
    localStringBuilder.append(paramDouble1);
    localStringBuilder.append(",");
    localStringBuilder.append(paramDouble2);
    localStringBuilder.append(",");
    localStringBuilder.append(paramLong);
    double d1 = paramLong;
    if (d1 > this.m)
    {
      this.m = d1;
      if (paramInt == 2) {
        if ((paramDouble2 > 4.0D) && (paramDouble1 > 4.0D)) {
          this.o = "vehicle";
        } else {
          this.o = "unknown";
        }
      }
      if (paramInt == 1) {
        if ((paramDouble2 > 8.0D) && (paramDouble1 > 8.0D)) {
          this.o = "vehicle";
        } else {
          this.o = "unknown";
        }
      }
      if (this.o.equalsIgnoreCase("vehicle")) {
        a(true);
      }
      if (!this.o.equalsIgnoreCase("vehicle")) {
        d();
      }
    }
  }
  
  public final void c()
  {
    HandlerThread localHandlerThread = this.g;
    if (localHandlerThread != null)
    {
      localHandlerThread.quit();
      this.g = null;
    }
    a(false);
    this.h = 0;
  }
  
  @TargetApi(19)
  final void d()
  {
    if (!this.n) {
      this.k = System.currentTimeMillis();
    }
    try
    {
      if (this.b == null)
      {
        this.h = -1;
        return;
      }
      Handler localHandler = new Handler(this.g.getLooper());
      if (!this.b.registerListener(this, this.c, 1, localHandler)) {
        this.h = -1;
      }
      this.b.registerListener(this, this.d, 3, localHandler);
      if ((Build.VERSION.SDK_INT >= 19) && (this.e != null)) {
        this.b.registerListener(this, this.e, 3, localHandler);
      }
      this.n = true;
      return;
    }
    catch (Throwable localThrowable)
    {
      label115:
      break label115;
    }
    this.n = false;
  }
  
  public final String e()
  {
    if ((this.o.equals("vehicle")) && (this.m > 0.0D))
    {
      double d1 = System.currentTimeMillis();
      double d2 = this.m;
      Double.isNaN(d1);
      if (d1 - d2 > 30000.0D)
      {
        this.o = "unknown";
        this.m = 0.0D;
      }
    }
    if (this.o.equals("vehicle"))
    {
      this.p = 0;
      return "vehicle";
    }
    if (this.o.equals("static"))
    {
      this.p = 0;
      return "static";
    }
    if ((this.l > 0L) && (System.currentTimeMillis() - this.l > 20000L))
    {
      this.p = 0;
      return "static";
    }
    if ((this.k > 0L) && (this.l == 0L) && (System.currentTimeMillis() - this.k > 20000L))
    {
      this.p = 0;
      return "static";
    }
    if ((this.l > 0L) && (System.currentTimeMillis() - this.l < 10000L) && (this.p >= 2)) {
      return "pedestrian";
    }
    this.p = 0;
    return "unknown";
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    int i1 = paramSensorEvent.sensor.getType();
    int i5 = 0;
    Object localObject;
    float f1;
    float f2;
    if (i1 != 1)
    {
      if (i1 != 10)
      {
        if (i1 != 19) {
          return;
        }
        if (paramSensorEvent.values[0] > 2.147484E+009F)
        {
          new StringBuilder("Sensor: probably not a real value: ").append(paramSensorEvent.values[0]);
          return;
        }
        if ((int)paramSensorEvent.values[0] > 0)
        {
          localObject = (String)dy.b(i, "stepStr", "");
          if (TextUtils.isEmpty((CharSequence)localObject))
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramSensorEvent.values[0]);
            ((StringBuilder)localObject).append(",");
            ((StringBuilder)localObject).append(System.currentTimeMillis());
            ((StringBuilder)localObject).append(",0");
            paramSensorEvent = ((StringBuilder)localObject).toString();
            dy.a(i, "stepStr", paramSensorEvent);
            return;
          }
          localObject = ((String)localObject).split(",");
          f1 = Float.valueOf(localObject[0]).floatValue();
          f2 = Float.valueOf(localObject[2]).floatValue();
          if (f1 > paramSensorEvent.values[0]) {
            f1 = paramSensorEvent.values[0];
          } else {
            f1 = paramSensorEvent.values[0] - f1;
          }
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(paramSensorEvent.values[0]);
          ((StringBuilder)localObject).append(",");
          ((StringBuilder)localObject).append(System.currentTimeMillis());
          ((StringBuilder)localObject).append(",");
          ((StringBuilder)localObject).append(f2 + f1);
          paramSensorEvent = ((StringBuilder)localObject).toString();
          dy.a(i, "stepStr", paramSensorEvent);
        }
      }
      else if ((paramSensorEvent != null) && (paramSensorEvent.values.length == 3))
      {
        double d1 = paramSensorEvent.values[0] * paramSensorEvent.values[0] + paramSensorEvent.values[1] * paramSensorEvent.values[1] + paramSensorEvent.values[2] * paramSensorEvent.values[2];
        if (d1 < 0.1D)
        {
          this.q += 1;
          if (this.q > 5) {
            this.o = "static";
          }
        }
        else if ((d1 > 0.1D) && (d1 < 1.0D))
        {
          this.q -= 1;
          if (this.q <= 1) {
            this.o = "unknown";
          }
        }
        else if (d1 > 3.0D)
        {
          this.q = -5;
          this.o = "unknown";
        }
      }
    }
    else if ((paramSensorEvent != null) && (paramSensorEvent.values.length == 3))
    {
      localObject = this.a;
      float[] arrayOfFloat = paramSensorEvent.values;
      long l1 = paramSensorEvent.timestamp;
      f1 = arrayOfFloat[0];
      f2 = arrayOfFloat[1];
      float f3 = arrayOfFloat[2];
      long l2 = System.currentTimeMillis();
      if (((dv)localObject).b == null)
      {
        ((dv)localObject).b = new fp(l2, l1, f1, f2, f3);
        ((dv)localObject).d = ((dv)localObject).b.a();
      }
      else
      {
        ((dv)localObject).b = new fp(l2, l1, f1 * 0.1F + ((dv)localObject).b.a * 0.9F, f2 * 0.1F + ((dv)localObject).b.b * 0.9F, f3 * 0.1F + ((dv)localObject).b.c * 0.9F);
        if (((dv)localObject).c != null) {
          ((dv)localObject).d = (((dv)localObject).b.a() - ((dv)localObject).c.a());
        }
      }
      if ((((dv)localObject).d != 0.0F) && (((dv)localObject).e != 0.0F))
      {
        paramSensorEvent = new fn(((dv)localObject).d, ((dv)localObject).e, ((dv)localObject).b.a(), l1);
        ((dv)localObject).a.add(paramSensorEvent);
      }
      if (((dv)localObject).f == 0L) {
        ((dv)localObject).f = l1;
      }
      if ((float)(l1 - ((dv)localObject).f) >= 6.0E+008F)
      {
        int i2;
        int i4;
        int i3;
        if (((dv)localObject).g)
        {
          i1 = 0;
          for (i2 = 0; i1 < ((dv)localObject).a.size(); i2 = i3)
          {
            paramSensorEvent = (fn)((dv)localObject).a.get(i1);
            if ((paramSensorEvent.a >= 0.0F) && (paramSensorEvent.b <= 0.0F)) {
              i4 = 1;
            } else {
              i4 = 0;
            }
            i3 = i2;
            if (i4 != 0)
            {
              i3 = i2;
              if (((dv)localObject).h < Math.abs(((fn)((dv)localObject).a.get(i1)).c - ((fn)((dv)localObject).a.get(0)).c))
              {
                ((dv)localObject).h = Math.abs(((fn)((dv)localObject).a.get(i1)).c - ((fn)((dv)localObject).a.get(0)).c);
                i3 = i1;
              }
            }
            i1 += 1;
          }
          if ((i2 > 0) && (i2 < ((dv)localObject).a.size()))
          {
            ((dv)localObject).f = ((fn)((dv)localObject).a.get(i2)).d;
            i1 = 0;
            while (i1 < i2)
            {
              ((dv)localObject).a.removeFirst();
              i1 += 1;
            }
            if (((dv)localObject).h > 1.0F) {
              ((dv)localObject).i.a();
            }
            ((dv)localObject).h = 0.0F;
            ((dv)localObject).g = false;
          }
          else
          {
            ((dv)localObject).f = 0L;
          }
        }
        else
        {
          i1 = 0;
          for (i2 = 0; i1 < ((dv)localObject).a.size(); i2 = i3)
          {
            paramSensorEvent = (fn)((dv)localObject).a.get(i1);
            if ((paramSensorEvent.a <= 0.0F) && (paramSensorEvent.b >= 0.0F)) {
              i4 = 1;
            } else {
              i4 = 0;
            }
            i3 = i2;
            if (i4 != 0)
            {
              i3 = i2;
              if (((dv)localObject).h < Math.abs(((fn)((dv)localObject).a.get(i1)).c - ((fn)((dv)localObject).a.get(0)).c))
              {
                ((dv)localObject).h = Math.abs(((fn)((dv)localObject).a.get(i1)).c - ((fn)((dv)localObject).a.get(0)).c);
                i3 = i1;
              }
            }
            i1 += 1;
          }
          if ((i2 > 0) && (i2 < ((dv)localObject).a.size()))
          {
            ((dv)localObject).f = ((fn)((dv)localObject).a.get(i2)).d;
            i1 = i5;
            while (i1 < i2)
            {
              ((dv)localObject).a.removeFirst();
              i1 += 1;
            }
            ((dv)localObject).h = 0.0F;
            ((dv)localObject).g = true;
          }
          else
          {
            ((dv)localObject).f = 0L;
          }
        }
      }
      ((dv)localObject).c = ((dv)localObject).b;
      ((dv)localObject).e = ((dv)localObject).d;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     c.t.m.g.el
 * JD-Core Version:    0.7.0.1
 */
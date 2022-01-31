package c.t.m.g;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import java.util.LinkedList;

public final class dt
  implements SensorEventListener, dl
{
  static Context f;
  static SharedPreferences i;
  private static volatile dt j;
  dk a = new dk();
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
    if ((!this.n) || (this.b != null)) {}
    try
    {
      this.b.unregisterListener(this, this.c);
      this.b.unregisterListener(this, this.d);
      try
      {
        label38:
        if ((Build.VERSION.SDK_INT >= 19) && (this.e != null)) {
          this.b.unregisterListener(this, this.e);
        }
        this.k = 0L;
        this.l = 0L;
        if (paramBoolean)
        {
          this.o = "vehicle";
          this.n = false;
          return;
        }
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          ev.a("TxMotionProvider", 4, localThrowable1.toString());
          continue;
          this.o = "unknown";
        }
      }
    }
    catch (Throwable localThrowable2)
    {
      break label38;
    }
  }
  
  public static dt b()
  {
    if (j == null) {
      j = new dt();
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
    ev.b("Speed", "speedType:" + paramInt + "speed:" + paramDouble1 + "," + paramDouble2 + "," + paramLong);
    if (paramLong > this.m)
    {
      this.m = paramLong;
      if (paramInt == 2)
      {
        if ((paramDouble2 <= 4.0D) || (paramDouble1 <= 4.0D)) {
          break label158;
        }
        this.o = "vehicle";
      }
      if (paramInt == 1) {
        if ((paramDouble2 <= 8.0D) || (paramDouble1 <= 8.0D)) {
          break label167;
        }
      }
    }
    label158:
    label167:
    for (this.o = "vehicle";; this.o = "unknown")
    {
      if (this.o.equalsIgnoreCase("vehicle")) {
        a(true);
      }
      if (!this.o.equalsIgnoreCase("vehicle")) {
        d();
      }
      return;
      this.o = "unknown";
      break;
    }
  }
  
  public final void c()
  {
    ev.a("TxMotionProvider", 4, "shutdown");
    if (this.g != null)
    {
      this.g.quit();
      this.g = null;
    }
    a(false);
    this.h = 0;
  }
  
  @TargetApi(19)
  final void d()
  {
    if (!this.n)
    {
      this.k = System.currentTimeMillis();
      try
      {
        Handler localHandler = new Handler(this.g.getLooper());
        if (!this.b.registerListener(this, this.c, 1, localHandler)) {
          this.h = -1;
        }
        this.b.registerListener(this, this.d, 3, localHandler);
        if ((Build.VERSION.SDK_INT >= 19) && (this.e != null))
        {
          this.b.registerListener(this, this.e, 3, localHandler);
          ev.a("TxMotionProvider", "Support STEP_COUNTER sensor!");
        }
        for (;;)
        {
          this.n = true;
          return;
          ev.b("TxMotionProvider", "Don't support STEP_COUNTER sensor!");
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        this.n = false;
      }
    }
  }
  
  public final String e()
  {
    if ((this.o.equals("vehicle")) && (this.m > 0.0D) && (System.currentTimeMillis() - this.m > 30000.0D))
    {
      this.o = "unknown";
      this.m = 0.0D;
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
    Object localObject;
    long l1;
    float f1;
    float f2;
    float f3;
    long l2;
    label138:
    int i2;
    int i1;
    label243:
    int i3;
    switch (paramSensorEvent.sensor.getType())
    {
    default: 
    case 1: 
      do
      {
        return;
      } while ((paramSensorEvent == null) || (paramSensorEvent.values.length != 3));
      localObject = this.a;
      float[] arrayOfFloat = paramSensorEvent.values;
      l1 = paramSensorEvent.timestamp;
      f1 = arrayOfFloat[0];
      f2 = arrayOfFloat[1];
      f3 = arrayOfFloat[2];
      l2 = System.currentTimeMillis();
      if (((dk)localObject).b == null)
      {
        ((dk)localObject).b = new ed(l2, l1, f1, f2, f3);
        ((dk)localObject).d = ((dk)localObject).b.a();
        if ((((dk)localObject).d != 0.0F) && (((dk)localObject).e != 0.0F))
        {
          paramSensorEvent = new ec(((dk)localObject).d, ((dk)localObject).e, ((dk)localObject).b.a(), l1);
          ((dk)localObject).a.add(paramSensorEvent);
        }
        if (((dk)localObject).f == 0L) {
          ((dk)localObject).f = l1;
        }
        if ((float)(l1 - ((dk)localObject).f) < 6.0E+008F) {
          break label604;
        }
        if (!((dk)localObject).g) {
          break label634;
        }
        i2 = 0;
        i1 = 0;
        if (i1 >= ((dk)localObject).a.size()) {
          break label505;
        }
        paramSensorEvent = (ec)((dk)localObject).a.get(i1);
        if ((paramSensorEvent.a < 0.0F) || (paramSensorEvent.b > 0.0F)) {
          break label499;
        }
        i3 = 1;
        label291:
        if ((i3 == 0) || (((dk)localObject).h >= Math.abs(((ec)((dk)localObject).a.get(i1)).c - ((ec)((dk)localObject).a.get(0)).c))) {
          break label1311;
        }
        ((dk)localObject).h = Math.abs(((ec)((dk)localObject).a.get(i1)).c - ((ec)((dk)localObject).a.get(0)).c);
        i2 = i1;
      }
      break;
    }
    label640:
    label1308:
    label1311:
    for (;;)
    {
      i1 += 1;
      break label243;
      ((dk)localObject).b = new ed(l2, l1, ((dk)localObject).b.a * 0.9F + 0.1F * f1, ((dk)localObject).b.b * 0.9F + 0.1F * f2, ((dk)localObject).b.c * 0.9F + 0.1F * f3);
      if (((dk)localObject).c == null) {
        break label138;
      }
      ((dk)localObject).d = (((dk)localObject).b.a() - ((dk)localObject).c.a());
      break label138;
      label499:
      i3 = 0;
      break label291;
      label505:
      if ((i2 > 0) && (i2 < ((dk)localObject).a.size()))
      {
        ((dk)localObject).f = ((ec)((dk)localObject).a.get(i2)).d;
        i1 = 0;
        while (i1 < i2)
        {
          ((dk)localObject).a.removeFirst();
          i1 += 1;
        }
        if (((dk)localObject).h > 1.0F) {
          ((dk)localObject).i.a();
        }
        ((dk)localObject).h = 0.0F;
        ((dk)localObject).g = false;
      }
      for (;;)
      {
        label604:
        ((dk)localObject).c = ((dk)localObject).b;
        ((dk)localObject).e = ((dk)localObject).d;
        return;
        ((dk)localObject).f = 0L;
      }
      label634:
      i2 = 0;
      i1 = 0;
      if (i1 < ((dk)localObject).a.size())
      {
        paramSensorEvent = (ec)((dk)localObject).a.get(i1);
        if ((paramSensorEvent.a <= 0.0F) && (paramSensorEvent.b >= 0.0F))
        {
          i3 = 1;
          label688:
          if ((i3 == 0) || (((dk)localObject).h >= Math.abs(((ec)((dk)localObject).a.get(i1)).c - ((ec)((dk)localObject).a.get(0)).c))) {
            break label1308;
          }
          ((dk)localObject).h = Math.abs(((ec)((dk)localObject).a.get(i1)).c - ((ec)((dk)localObject).a.get(0)).c);
          i2 = i1;
        }
      }
      for (;;)
      {
        i1 += 1;
        break label640;
        i3 = 0;
        break label688;
        if ((i2 > 0) && (i2 < ((dk)localObject).a.size()))
        {
          ((dk)localObject).f = ((ec)((dk)localObject).a.get(i2)).d;
          i1 = 0;
          while (i1 < i2)
          {
            ((dk)localObject).a.removeFirst();
            i1 += 1;
          }
          ((dk)localObject).h = 0.0F;
          ((dk)localObject).g = true;
          break label604;
        }
        ((dk)localObject).f = 0L;
        break label604;
        if ((paramSensorEvent == null) || (paramSensorEvent.values.length != 3)) {
          break;
        }
        double d1 = paramSensorEvent.values[0] * paramSensorEvent.values[0] + paramSensorEvent.values[1] * paramSensorEvent.values[1] + paramSensorEvent.values[2] * paramSensorEvent.values[2];
        if (d1 < 0.1D)
        {
          this.q += 1;
          if (this.q <= 5) {
            break;
          }
          this.o = "static";
          return;
        }
        if ((d1 > 0.1D) && (d1 < 1.0D))
        {
          this.q -= 1;
          if (this.q > 1) {
            break;
          }
          this.o = "unknown";
          return;
        }
        if (d1 <= 3.0D) {
          break;
        }
        this.q = -5;
        this.o = "unknown";
        return;
        if (paramSensorEvent.values[0] > 2.147484E+009F)
        {
          ev.a("TxMotionProvider", "Sensor: probably not a real value: " + paramSensorEvent.values[0]);
          return;
        }
        if ((int)paramSensorEvent.values[0] <= 0) {
          break;
        }
        localObject = i.getString("stepStr", "");
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          paramSensorEvent = paramSensorEvent.values[0] + "," + System.currentTimeMillis() + ",0";
          i.edit().putString("stepStr", paramSensorEvent).apply();
          return;
        }
        localObject = ((String)localObject).split(",");
        f1 = Float.valueOf(localObject[0]).floatValue();
        f2 = Float.valueOf(localObject[2]).floatValue();
        if (f1 > paramSensorEvent.values[0]) {}
        for (f1 = f2 + paramSensorEvent.values[0];; f1 = f2 + (paramSensorEvent.values[0] - f1))
        {
          paramSensorEvent = paramSensorEvent.values[0] + "," + System.currentTimeMillis() + "," + f1;
          i.edit().putString("stepStr", paramSensorEvent).apply();
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.dt
 * JD-Core Version:    0.7.0.1
 */
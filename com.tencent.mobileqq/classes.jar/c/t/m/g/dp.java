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

public final class dp
  implements SensorEventListener, di
{
  private static Context f;
  private static volatile dp g;
  private static SharedPreferences p;
  private dh a = new dh();
  private SensorManager b;
  private Sensor c;
  private Sensor d;
  private Sensor e;
  private long h = 0L;
  private long i = 0L;
  private double j = 0.0D;
  private boolean k = false;
  private String l = "unknown";
  private HandlerThread m;
  private int n = 0;
  private int o = 0;
  private int q = 0;
  
  private void a(boolean paramBoolean)
  {
    if ((!this.k) || (this.b != null)) {}
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
        this.h = 0L;
        this.i = 0L;
        if (paramBoolean)
        {
          this.l = "vehicle";
          this.k = false;
          return;
        }
      }
      catch (Throwable localThrowable1)
      {
        for (;;)
        {
          f.a.a("TxMotionProvider", localThrowable1.toString());
          continue;
          this.l = "unknown";
        }
      }
    }
    catch (Throwable localThrowable2)
    {
      break label38;
    }
  }
  
  public static dp b()
  {
    if (g == null) {
      g = new dp();
    }
    return g;
  }
  
  @TargetApi(19)
  private void f()
  {
    if (!this.k)
    {
      this.h = System.currentTimeMillis();
      try
      {
        Handler localHandler = new Handler(this.m.getLooper());
        if (!this.b.registerListener(this, this.c, 1, localHandler)) {
          this.n = -1;
        }
        this.b.registerListener(this, this.d, 3, localHandler);
        if ((Build.VERSION.SDK_INT >= 19) && (this.e != null))
        {
          this.b.registerListener(this, this.e, 3, localHandler);
          f.a.a("TxMotionProvider", "Support STEP_COUNTER sensor!");
        }
        for (;;)
        {
          this.k = true;
          return;
          f.a.b("TxMotionProvider", "Don't support STEP_COUNTER sensor!");
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        this.k = false;
      }
    }
  }
  
  public final void a()
  {
    this.i = System.currentTimeMillis();
    this.n += 1;
    this.o += 1;
  }
  
  public final void a(int paramInt, double paramDouble1, double paramDouble2, long paramLong)
  {
    f.a.b("Speed", "speedType:" + paramInt + "speed:" + paramDouble1 + "," + paramDouble2 + "," + paramLong);
    if (paramLong > this.j)
    {
      this.j = paramLong;
      if (paramInt == 2)
      {
        if ((paramDouble2 <= 4.0D) || (paramDouble1 <= 4.0D)) {
          break label158;
        }
        this.l = "vehicle";
      }
      if (paramInt == 1) {
        if ((paramDouble2 <= 8.0D) || (paramDouble1 <= 8.0D)) {
          break label167;
        }
      }
    }
    label158:
    label167:
    for (this.l = "vehicle";; this.l = "unknown")
    {
      if (this.l.equalsIgnoreCase("vehicle")) {
        a(true);
      }
      if (!this.l.equalsIgnoreCase("vehicle")) {
        f();
      }
      return;
      this.l = "unknown";
      break;
    }
  }
  
  public final void a(Context paramContext)
  {
    f = paramContext;
    p = paramContext.getSharedPreferences("LocationSDK", 0);
    this.m = new HandlerThread("Sensor");
    this.m.start();
    this.a.i = this;
    this.b = ((SensorManager)f.getSystemService("sensor"));
    if (this.b != null)
    {
      this.c = this.b.getDefaultSensor(1);
      this.d = this.b.getDefaultSensor(10);
      if (Build.VERSION.SDK_INT >= 19) {
        this.e = this.b.getDefaultSensor(19);
      }
    }
    f();
  }
  
  public final void c()
  {
    f.a.a("TxMotionProvider", "shutdown");
    if (this.m != null)
    {
      this.m.quit();
      this.m = null;
    }
    a(false);
    this.n = 0;
  }
  
  public final int d()
  {
    return this.n;
  }
  
  public final String e()
  {
    if ((this.l.equals("vehicle")) && (this.j > 0.0D) && (System.currentTimeMillis() - this.j > 30000.0D))
    {
      this.l = "unknown";
      this.j = 0.0D;
    }
    if (this.l.equals("vehicle"))
    {
      this.o = 0;
      return "vehicle";
    }
    if (this.l.equals("static"))
    {
      this.o = 0;
      return "static";
    }
    if ((this.i > 0L) && (System.currentTimeMillis() - this.i > 20000L))
    {
      this.o = 0;
      return "static";
    }
    if ((this.h > 0L) && (this.i == 0L) && (System.currentTimeMillis() - this.h > 20000L))
    {
      this.o = 0;
      return "static";
    }
    if ((this.i > 0L) && (System.currentTimeMillis() - this.i < 10000L) && (this.o >= 2)) {
      return "pedestrian";
    }
    this.o = 0;
    return "unknown";
  }
  
  public final void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public final void onSensorChanged(SensorEvent paramSensorEvent)
  {
    int i4 = 0;
    Object localObject;
    float f1;
    float f2;
    float f3;
    label137:
    int i1;
    int i2;
    label242:
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
      long l1 = paramSensorEvent.timestamp;
      f1 = arrayOfFloat[0];
      f2 = arrayOfFloat[1];
      f3 = arrayOfFloat[2];
      System.currentTimeMillis();
      if (((dh)localObject).b == null)
      {
        ((dh)localObject).b = new dz(f1, f2, f3);
        ((dh)localObject).d = ((dh)localObject).b.a();
        if ((((dh)localObject).d != 0.0F) && (((dh)localObject).e != 0.0F))
        {
          paramSensorEvent = new dy(((dh)localObject).d, ((dh)localObject).e, ((dh)localObject).b.a(), l1);
          ((dh)localObject).a.add(paramSensorEvent);
        }
        if (((dh)localObject).f == 0L) {
          ((dh)localObject).f = l1;
        }
        if ((float)(l1 - ((dh)localObject).f) < 6.0E+008F) {
          break label599;
        }
        if (!((dh)localObject).g) {
          break label629;
        }
        i1 = 0;
        i2 = 0;
        if (i1 >= ((dh)localObject).a.size()) {
          break label500;
        }
        paramSensorEvent = (dy)((dh)localObject).a.get(i1);
        if ((paramSensorEvent.a < 0.0F) || (paramSensorEvent.b > 0.0F)) {
          break label494;
        }
        i3 = 1;
        label290:
        if ((i3 == 0) || (((dh)localObject).h >= Math.abs(((dy)((dh)localObject).a.get(i1)).c - ((dy)((dh)localObject).a.get(0)).c))) {
          break label1307;
        }
        ((dh)localObject).h = Math.abs(((dy)((dh)localObject).a.get(i1)).c - ((dy)((dh)localObject).a.get(0)).c);
        i2 = i1;
      }
      break;
    }
    label1304:
    label1307:
    for (;;)
    {
      i1 += 1;
      break label242;
      ((dh)localObject).b = new dz(f1 * 0.1F + ((dh)localObject).b.a * 0.9F, f2 * 0.1F + ((dh)localObject).b.b * 0.9F, f3 * 0.1F + ((dh)localObject).b.c * 0.9F);
      if (((dh)localObject).c == null) {
        break label137;
      }
      ((dh)localObject).d = (((dh)localObject).b.a() - ((dh)localObject).c.a());
      break label137;
      label494:
      i3 = 0;
      break label290;
      label500:
      if ((i2 > 0) && (i2 < ((dh)localObject).a.size()))
      {
        ((dh)localObject).f = ((dy)((dh)localObject).a.get(i2)).d;
        i1 = 0;
        while (i1 < i2)
        {
          ((dh)localObject).a.removeFirst();
          i1 += 1;
        }
        if (((dh)localObject).h > 1.0F) {
          ((dh)localObject).i.a();
        }
        ((dh)localObject).h = 0.0F;
        ((dh)localObject).g = false;
      }
      for (;;)
      {
        label599:
        ((dh)localObject).c = ((dh)localObject).b;
        ((dh)localObject).e = ((dh)localObject).d;
        return;
        ((dh)localObject).f = 0L;
      }
      label629:
      i1 = 0;
      i2 = 0;
      label635:
      if (i1 < ((dh)localObject).a.size())
      {
        paramSensorEvent = (dy)((dh)localObject).a.get(i1);
        if ((paramSensorEvent.a <= 0.0F) && (paramSensorEvent.b >= 0.0F))
        {
          i3 = 1;
          if ((i3 == 0) || (((dh)localObject).h >= Math.abs(((dy)((dh)localObject).a.get(i1)).c - ((dy)((dh)localObject).a.get(0)).c))) {
            break label1304;
          }
          ((dh)localObject).h = Math.abs(((dy)((dh)localObject).a.get(i1)).c - ((dy)((dh)localObject).a.get(0)).c);
          i2 = i1;
        }
      }
      for (;;)
      {
        label683:
        i1 += 1;
        break label635;
        i3 = 0;
        break label683;
        if ((i2 > 0) && (i2 < ((dh)localObject).a.size()))
        {
          ((dh)localObject).f = ((dy)((dh)localObject).a.get(i2)).d;
          i1 = i4;
          while (i1 < i2)
          {
            ((dh)localObject).a.removeFirst();
            i1 += 1;
          }
          ((dh)localObject).h = 0.0F;
          ((dh)localObject).g = true;
          break label599;
        }
        ((dh)localObject).f = 0L;
        break label599;
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
          this.l = "static";
          return;
        }
        if ((d1 > 0.1D) && (d1 < 1.0D))
        {
          this.q -= 1;
          if (this.q > 1) {
            break;
          }
          this.l = "unknown";
          return;
        }
        if (d1 <= 3.0D) {
          break;
        }
        this.q = -5;
        this.l = "unknown";
        return;
        if (paramSensorEvent.values[0] > 2.147484E+009F)
        {
          f.a.a("TxMotionProvider", "Sensor: probably not a real value: " + paramSensorEvent.values[0]);
          return;
        }
        if ((int)paramSensorEvent.values[0] <= 0) {
          break;
        }
        localObject = p.getString("stepStr", "");
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          paramSensorEvent = paramSensorEvent.values[0] + "," + System.currentTimeMillis() + ",0";
          p.edit().putString("stepStr", paramSensorEvent).apply();
          return;
        }
        localObject = ((String)localObject).split(",");
        f1 = Float.valueOf(localObject[0]).floatValue();
        f2 = Float.valueOf(localObject[2]).floatValue();
        if (f1 > paramSensorEvent.values[0]) {}
        for (f1 = f2 + paramSensorEvent.values[0];; f1 = f2 + (paramSensorEvent.values[0] - f1))
        {
          paramSensorEvent = paramSensorEvent.values[0] + "," + System.currentTimeMillis() + "," + f1;
          p.edit().putString("stepStr", paramSensorEvent).apply();
          return;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.dp
 * JD-Core Version:    0.7.0.1
 */
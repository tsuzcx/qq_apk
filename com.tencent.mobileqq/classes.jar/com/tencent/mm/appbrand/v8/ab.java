package com.tencent.mm.appbrand.v8;

import android.content.ComponentCallbacks2;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import com.eclipsesource.mmv8.MultiContextV8;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;

public final class ab
{
  private static final String a;
  private final int b = 1000;
  @NonNull
  private final MultiContextV8 c;
  private Integer d = null;
  private boolean e;
  private int f = 0;
  private final Runnable g = new ab.1(this);
  @NonNull
  private final ComponentCallbacks2 h;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MicroMsg.V8MemoryPressureMonitor");
    localStringBuilder.append(r.c().replace("com.tencent.mm", ""));
    a = localStringBuilder.toString();
  }
  
  @RequiresApi(api=14)
  public ab(MultiContextV8 paramMultiContextV8)
  {
    this.c = paramMultiContextV8;
    this.h = new ab.2(this);
  }
  
  private void c(int paramInt)
  {
    e();
    this.f = paramInt;
    String str;
    if (paramInt == 2) {
      str = "CRITICAL";
    } else if (paramInt == 1) {
      str = "MODERATE";
    } else {
      str = "NONE";
    }
    o.d(a, "reportPressure [%s]", new Object[] { str });
    this.c.memoryPressureNotification(paramInt);
  }
  
  private static Integer d(int paramInt)
  {
    if ((paramInt < 80) && (paramInt != 15))
    {
      if (paramInt >= 40) {
        return Integer.valueOf(1);
      }
      return null;
    }
    return Integer.valueOf(2);
  }
  
  private void d()
  {
    o.d(a, "onThrottlingIntervalFinished");
    this.e = false;
    Integer localInteger = this.d;
    if ((localInteger != null) && (this.f != localInteger.intValue()))
    {
      int i = this.d.intValue();
      this.d = null;
      c(i);
    }
  }
  
  private void e()
  {
    o.d(a, "startThrottlingInterval");
  }
  
  public void a() {}
  
  public void a(int paramInt)
  {
    if (this.e)
    {
      o.d(a, "notifyPressure but throttle");
      this.d = Integer.valueOf(paramInt);
      return;
    }
    c(paramInt);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.ab
 * JD-Core Version:    0.7.0.1
 */
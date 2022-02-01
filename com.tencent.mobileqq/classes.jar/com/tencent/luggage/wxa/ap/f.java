package com.tencent.luggage.wxa.ap;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.Display;
import android.view.WindowManager;

@TargetApi(16)
public final class f
{
  private final f.a a;
  private final boolean b;
  private final long c;
  private final long d;
  private long e;
  private long f;
  private long g;
  private boolean h;
  private long i;
  private long j;
  private long k;
  
  public f()
  {
    this(-1.0D);
  }
  
  private f(double paramDouble)
  {
    boolean bool;
    if (paramDouble != -1.0D) {
      bool = true;
    } else {
      bool = false;
    }
    this.b = bool;
    if (this.b)
    {
      this.a = f.a.a();
      this.c = ((1000000000.0D / paramDouble));
      this.d = (this.c * 80L / 100L);
      return;
    }
    this.a = null;
    this.c = -1L;
    this.d = -1L;
  }
  
  public f(Context paramContext)
  {
    this(a(paramContext));
  }
  
  private static double a(Context paramContext)
  {
    paramContext = (WindowManager)paramContext.getSystemService("window");
    if (paramContext.getDefaultDisplay() != null) {
      return paramContext.getDefaultDisplay().getRefreshRate();
    }
    return -1.0D;
  }
  
  private static long a(long paramLong1, long paramLong2, long paramLong3)
  {
    paramLong2 += (paramLong1 - paramLong2) / paramLong3 * paramLong3;
    if (paramLong1 <= paramLong2)
    {
      paramLong3 = paramLong2 - paramLong3;
    }
    else
    {
      long l = paramLong3 + paramLong2;
      paramLong3 = paramLong2;
      paramLong2 = l;
    }
    if (paramLong2 - paramLong1 < paramLong1 - paramLong3) {
      return paramLong2;
    }
    return paramLong3;
  }
  
  private boolean b(long paramLong1, long paramLong2)
  {
    long l = this.j;
    return Math.abs(paramLong2 - this.i - (paramLong1 - l)) > 20000000L;
  }
  
  public long a(long paramLong1, long paramLong2)
  {
    long l3 = 1000L * paramLong1;
    if (this.h)
    {
      if (paramLong1 != this.e)
      {
        this.k += 1L;
        this.f = this.g;
      }
      l1 = this.k;
      if (l1 >= 6L)
      {
        l1 = (l3 - this.j) / l1;
        l1 = this.f + l1;
        if (b(l1, paramLong2))
        {
          this.h = false;
        }
        else
        {
          l2 = this.i + l1 - this.j;
          break label134;
        }
      }
      else if (b(l3, paramLong2))
      {
        this.h = false;
      }
    }
    long l2 = paramLong2;
    long l1 = l3;
    label134:
    if (!this.h)
    {
      this.j = l3;
      this.i = paramLong2;
      this.k = 0L;
      this.h = true;
      c();
    }
    this.e = paramLong1;
    this.g = l1;
    f.a locala = this.a;
    if (locala != null)
    {
      if (locala.a == 0L) {
        return l2;
      }
      return a(l2, this.a.a, this.c) - this.d;
    }
    return l2;
  }
  
  public void a()
  {
    this.h = false;
    if (this.b) {
      this.a.b();
    }
  }
  
  public void b()
  {
    if (this.b) {
      this.a.c();
    }
  }
  
  protected void c() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ap.f
 * JD-Core Version:    0.7.0.1
 */
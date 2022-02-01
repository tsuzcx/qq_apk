package com.tencent.mm.appbrand.v8;

import android.os.SystemClock;
import com.eclipsesource.mmv8.V8Array;
import com.eclipsesource.mmv8.V8Function;
import com.tencent.luggage.wxa.qz.v;
import java.util.concurrent.TimeUnit;

class u$a
  extends u.c
  implements Runnable
{
  private final v j;
  private long k;
  private long l;
  
  u$a(u paramu, n paramn, int paramInt, V8Function paramV8Function, V8Array paramV8Array, boolean paramBoolean, long paramLong)
  {
    super(paramu, paramn, paramInt, paramV8Function, paramV8Array, paramBoolean, paramLong);
    this.j = new v(u.b(paramu), new u.a.1(this, paramu, paramn), false);
  }
  
  private void e()
  {
    long l1 = SystemClock.elapsedRealtimeNanos();
    long l2 = this.k;
    if (0L == l2) {
      this.k = (l1 - this.l);
    } else {
      this.k = ((l2 + l1 - this.l) / 2L);
    }
    l2 = this.f - TimeUnit.NANOSECONDS.toMillis(this.k);
    l1 = l2;
    if (l2 <= 0L) {
      l1 = this.f;
    }
    this.j.a(l1, l1);
  }
  
  void a()
  {
    this.j.a(this.f, this.f);
  }
  
  void b()
  {
    this.j.c();
    super.b();
  }
  
  public void run()
  {
    if (!c()) {
      return;
    }
    a(this.h);
    if (!c()) {
      return;
    }
    if (!this.g)
    {
      d();
      return;
    }
    e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.appbrand.v8.u.a
 * JD-Core Version:    0.7.0.1
 */
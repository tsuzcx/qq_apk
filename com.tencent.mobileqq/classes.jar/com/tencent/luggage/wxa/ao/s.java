package com.tencent.luggage.wxa.ao;

import android.os.SystemClock;
import com.tencent.luggage.wxa.h.b;
import com.tencent.luggage.wxa.h.q;

public final class s
  implements i
{
  private boolean a;
  private long b;
  private long c;
  private q d = q.a;
  
  public q a(q paramq)
  {
    if (this.a) {
      a(w());
    }
    this.d = paramq;
    return paramq;
  }
  
  public void a()
  {
    if (!this.a)
    {
      this.c = SystemClock.elapsedRealtime();
      this.a = true;
    }
  }
  
  public void a(long paramLong)
  {
    this.b = paramLong;
    if (this.a) {
      this.c = SystemClock.elapsedRealtime();
    }
  }
  
  public void a(i parami)
  {
    a(parami.w());
    this.d = parami.x();
  }
  
  public void b()
  {
    if (this.a)
    {
      a(w());
      this.a = false;
    }
  }
  
  public long w()
  {
    long l2 = this.b;
    long l1 = l2;
    if (this.a)
    {
      l1 = SystemClock.elapsedRealtime() - this.c;
      if (this.d.b == 1.0F) {
        l1 = b.b(l1);
      } else {
        l1 = this.d.a(l1);
      }
      l1 = l2 + l1;
    }
    return l1;
  }
  
  public q x()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ao.s
 * JD-Core Version:    0.7.0.1
 */
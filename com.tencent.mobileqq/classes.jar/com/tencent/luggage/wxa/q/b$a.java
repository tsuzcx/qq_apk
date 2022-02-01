package com.tencent.luggage.wxa.q;

import com.tencent.luggage.wxa.ao.g;
import com.tencent.luggage.wxa.ao.m;
import com.tencent.luggage.wxa.ao.x;
import com.tencent.luggage.wxa.l.e;
import com.tencent.luggage.wxa.l.k;

class b$a
  implements k, f
{
  private long[] b;
  private long[] c;
  private long d = -1L;
  private long e = -1L;
  
  public b$a(b paramb) {}
  
  public long a(long paramLong)
  {
    paramLong = this.a.b(paramLong);
    int i = x.a(this.b, paramLong, true, true);
    this.e = this.b[i];
    return paramLong;
  }
  
  public long a(e parame)
  {
    long l = this.e;
    if (l >= 0L)
    {
      l = -(l + 2L);
      this.e = -1L;
      return l;
    }
    return -1L;
  }
  
  public void a(m paramm)
  {
    paramm.d(1);
    int j = paramm.k() / 18;
    this.b = new long[j];
    this.c = new long[j];
    int i = 0;
    while (i < j)
    {
      this.b[i] = paramm.p();
      this.c[i] = paramm.p();
      paramm.d(2);
      i += 1;
    }
  }
  
  public boolean a()
  {
    return true;
  }
  
  public long b()
  {
    return b.a(this.a).b();
  }
  
  public long b(long paramLong)
  {
    paramLong = this.a.b(paramLong);
    int i = x.a(this.b, paramLong, true, true);
    return this.d + this.c[i];
  }
  
  public k c()
  {
    return this;
  }
  
  public void c(long paramLong)
  {
    this.d = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.q.b.a
 * JD-Core Version:    0.7.0.1
 */
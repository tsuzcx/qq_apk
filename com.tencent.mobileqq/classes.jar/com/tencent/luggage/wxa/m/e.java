package com.tencent.luggage.wxa.m;

import com.tencent.luggage.wxa.ao.m;
import com.tencent.luggage.wxa.ap.a;
import com.tencent.luggage.wxa.l.l;

final class e
  extends d
{
  private final m b = new m(com.tencent.luggage.wxa.ao.k.a);
  private final m c = new m(4);
  private int d;
  private boolean e;
  private int f;
  
  public e(l paraml)
  {
    super(paraml);
  }
  
  protected void a(m paramm, long paramLong)
  {
    int i = paramm.g();
    long l = paramm.k();
    Object localObject;
    if ((i == 0) && (!this.e))
    {
      localObject = new m(new byte[paramm.b()]);
      paramm.a(((m)localObject).a, 0, paramm.b());
      paramm = a.a((m)localObject);
      this.d = paramm.b;
      paramm = com.tencent.luggage.wxa.h.k.a(null, "video/avc", null, -1, -1, paramm.c, paramm.d, -1.0F, paramm.a, -1, paramm.e, null);
      this.a.a(paramm);
      this.e = true;
      return;
    }
    if ((i == 1) && (this.e))
    {
      localObject = this.c.a;
      localObject[0] = 0;
      localObject[1] = 0;
      localObject[2] = 0;
      int j = this.d;
      int k;
      for (i = 0; paramm.b() > 0; i = i + 4 + k)
      {
        paramm.a(this.c.a, 4 - j, this.d);
        this.c.c(0);
        k = this.c.t();
        this.b.c(0);
        this.a.a(this.b, 4);
        this.a.a(paramm, k);
      }
      paramm = this.a;
      if (this.f == 1) {
        j = 1;
      } else {
        j = 0;
      }
      paramm.a(paramLong + l * 1000L, j, i, 0, null);
    }
  }
  
  protected boolean a(m paramm)
  {
    int j = paramm.g();
    int i = j >> 4 & 0xF;
    j &= 0xF;
    if (j == 7)
    {
      this.f = i;
      return i != 5;
    }
    paramm = new StringBuilder();
    paramm.append("Video format not supported: ");
    paramm.append(j);
    throw new d.a(paramm.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.m.e
 * JD-Core Version:    0.7.0.1
 */
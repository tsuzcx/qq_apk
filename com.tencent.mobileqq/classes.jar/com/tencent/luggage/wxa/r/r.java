package com.tencent.luggage.wxa.r;

import com.tencent.luggage.wxa.ao.m;
import com.tencent.luggage.wxa.ao.u;
import com.tencent.luggage.wxa.ao.x;
import com.tencent.luggage.wxa.l.f;

public final class r
  implements v
{
  private final q a;
  private final m b;
  private int c;
  private int d;
  private boolean e;
  private boolean f;
  
  public r(q paramq)
  {
    this.a = paramq;
    this.b = new m(32);
  }
  
  public void a()
  {
    this.f = true;
  }
  
  public void a(m paramm, boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = paramm.g() + paramm.d();
    } else {
      i = -1;
    }
    if (this.f)
    {
      if (!paramBoolean) {
        return;
      }
      this.f = false;
      paramm.c(i);
      this.d = 0;
    }
    while (paramm.b() > 0)
    {
      i = this.d;
      paramBoolean = true;
      int j;
      if (i < 3)
      {
        if (i == 0)
        {
          i = paramm.g();
          paramm.c(paramm.d() - 1);
          if (i == 255)
          {
            this.f = true;
            return;
          }
        }
        i = Math.min(paramm.b(), 3 - this.d);
        paramm.a(this.b.a, this.d, i);
        this.d += i;
        if (this.d == 3)
        {
          this.b.a(3);
          this.b.d(1);
          i = this.b.g();
          j = this.b.g();
          if ((i & 0x80) == 0) {
            paramBoolean = false;
          }
          this.e = paramBoolean;
          this.c = (((i & 0xF) << 8 | j) + 3);
          if (this.b.e() < this.c)
          {
            byte[] arrayOfByte = this.b.a;
            this.b.a(Math.min(4098, Math.max(this.c, arrayOfByte.length * 2)));
            System.arraycopy(arrayOfByte, 0, this.b.a, 0, 3);
          }
        }
      }
      else
      {
        i = Math.min(paramm.b(), this.c - this.d);
        paramm.a(this.b.a, this.d, i);
        this.d += i;
        i = this.d;
        j = this.c;
        if (i == j)
        {
          if (this.e)
          {
            if (x.a(this.b.a, 0, this.c, -1) != 0)
            {
              this.f = true;
              return;
            }
            this.b.a(this.c - 4);
          }
          else
          {
            this.b.a(j);
          }
          this.a.a(this.b);
          this.d = 0;
        }
      }
    }
  }
  
  public void a(u paramu, f paramf, v.d paramd)
  {
    this.a.a(paramu, paramf, paramd);
    this.f = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.r.r
 * JD-Core Version:    0.7.0.1
 */
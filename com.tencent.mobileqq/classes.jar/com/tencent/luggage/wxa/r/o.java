package com.tencent.luggage.wxa.r;

import android.util.Log;
import com.tencent.luggage.wxa.ao.l;
import com.tencent.luggage.wxa.ao.m;
import com.tencent.luggage.wxa.ao.u;
import com.tencent.luggage.wxa.l.f;

public final class o
  implements v
{
  private final h a;
  private final l b;
  private int c;
  private int d;
  private u e;
  private boolean f;
  private boolean g;
  private boolean h;
  private int i;
  private int j;
  private boolean k;
  private long l;
  
  public o(h paramh)
  {
    this.a = paramh;
    this.b = new l(new byte[10]);
    this.c = 0;
  }
  
  private void a(int paramInt)
  {
    this.c = paramInt;
    this.d = 0;
  }
  
  private boolean a(m paramm, byte[] paramArrayOfByte, int paramInt)
  {
    int m = Math.min(paramm.b(), paramInt - this.d);
    if (m <= 0) {
      return true;
    }
    if (paramArrayOfByte == null) {
      paramm.d(m);
    } else {
      paramm.a(paramArrayOfByte, this.d, m);
    }
    this.d += m;
    return this.d == paramInt;
  }
  
  private boolean b()
  {
    this.b.a(0);
    int m = this.b.c(24);
    if (m != 1)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unexpected start code prefix: ");
      localStringBuilder.append(m);
      Log.w("PesReader", localStringBuilder.toString());
      this.j = -1;
      return false;
    }
    this.b.b(8);
    m = this.b.c(16);
    this.b.b(5);
    this.k = this.b.e();
    this.b.b(2);
    this.f = this.b.e();
    this.g = this.b.e();
    this.b.b(6);
    this.i = this.b.c(8);
    if (m == 0)
    {
      this.j = -1;
      return true;
    }
    this.j = (m + 6 - 9 - this.i);
    return true;
  }
  
  private void c()
  {
    this.b.a(0);
    this.l = -9223372036854775807L;
    if (this.f)
    {
      this.b.b(4);
      long l1 = this.b.c(3);
      this.b.b(1);
      long l2 = this.b.c(15) << 15;
      this.b.b(1);
      long l3 = this.b.c(15);
      this.b.b(1);
      if ((!this.h) && (this.g))
      {
        this.b.b(4);
        long l4 = this.b.c(3);
        this.b.b(1);
        long l5 = this.b.c(15) << 15;
        this.b.b(1);
        long l6 = this.b.c(15);
        this.b.b(1);
        this.e.b(l4 << 30 | l5 | l6);
        this.h = true;
      }
      this.l = this.e.b(l1 << 30 | l2 | l3);
    }
  }
  
  public final void a()
  {
    this.c = 0;
    this.d = 0;
    this.h = false;
    this.a.a();
  }
  
  public final void a(m paramm, boolean paramBoolean)
  {
    int m;
    if (paramBoolean)
    {
      m = this.c;
      if ((m != 0) && (m != 1)) {
        if (m != 2)
        {
          if (m == 3)
          {
            if (this.j != -1)
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("Unexpected start indicator: expected ");
              localStringBuilder.append(this.j);
              localStringBuilder.append(" more bytes");
              Log.w("PesReader", localStringBuilder.toString());
            }
            this.a.b();
          }
        }
        else {
          Log.w("PesReader", "Unexpected start indicator reading extended header");
        }
      }
      a(1);
    }
    while (paramm.b() > 0)
    {
      int i1 = this.c;
      if (i1 != 0)
      {
        m = 0;
        int n = 0;
        if (i1 != 1)
        {
          if (i1 != 2)
          {
            if (i1 == 3)
            {
              i1 = paramm.b();
              m = this.j;
              if (m != -1) {
                n = i1 - m;
              }
              m = i1;
              if (n > 0)
              {
                m = i1 - n;
                paramm.b(paramm.d() + m);
              }
              this.a.a(paramm);
              n = this.j;
              if (n != -1)
              {
                this.j = (n - m);
                if (this.j == 0)
                {
                  this.a.b();
                  a(1);
                }
              }
            }
          }
          else
          {
            m = Math.min(10, this.i);
            if ((a(paramm, this.b.a, m)) && (a(paramm, null, this.i)))
            {
              c();
              this.a.a(this.l, this.k);
              a(3);
            }
          }
        }
        else if (a(paramm, this.b.a, 9))
        {
          if (b()) {
            m = 2;
          }
          a(m);
        }
      }
      else
      {
        paramm.d(paramm.b());
      }
    }
  }
  
  public void a(u paramu, f paramf, v.d paramd)
  {
    this.e = paramu;
    this.a.a(paramf, paramd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.r.o
 * JD-Core Version:    0.7.0.1
 */
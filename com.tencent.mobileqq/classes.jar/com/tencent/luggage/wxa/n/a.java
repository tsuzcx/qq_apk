package com.tencent.luggage.wxa.n;

import com.tencent.luggage.wxa.h.p;
import com.tencent.luggage.wxa.l.e;
import java.util.Stack;

final class a
  implements b
{
  private final byte[] a = new byte[8];
  private final Stack<a.a> b = new Stack();
  private final f c = new f();
  private c d;
  private int e;
  private int f;
  private long g;
  
  private long a(e parame, int paramInt)
  {
    byte[] arrayOfByte = this.a;
    int i = 0;
    parame.b(arrayOfByte, 0, paramInt);
    long l = 0L;
    while (i < paramInt)
    {
      l = l << 8 | this.a[i] & 0xFF;
      i += 1;
    }
    return l;
  }
  
  private double b(e parame, int paramInt)
  {
    long l = a(parame, paramInt);
    if (paramInt == 4) {
      return Float.intBitsToFloat((int)l);
    }
    return Double.longBitsToDouble(l);
  }
  
  private long b(e parame)
  {
    parame.a();
    for (;;)
    {
      parame.c(this.a, 0, 4);
      int i = f.a(this.a[0]);
      if ((i != -1) && (i <= 4))
      {
        int j = (int)f.a(this.a, i, false);
        if (this.d.b(j))
        {
          parame.b(i);
          return j;
        }
      }
      parame.b(1);
    }
  }
  
  private String c(e parame, int paramInt)
  {
    if (paramInt == 0) {
      return "";
    }
    byte[] arrayOfByte = new byte[paramInt];
    parame.b(arrayOfByte, 0, paramInt);
    return new String(arrayOfByte);
  }
  
  public void a()
  {
    this.e = 0;
    this.b.clear();
    this.c.a();
  }
  
  public void a(c paramc)
  {
    this.d = paramc;
  }
  
  public boolean a(e parame)
  {
    boolean bool;
    if (this.d != null) {
      bool = true;
    } else {
      bool = false;
    }
    com.tencent.luggage.wxa.ao.a.b(bool);
    for (;;)
    {
      if ((!this.b.isEmpty()) && (parame.c() >= a.a.a((a.a)this.b.peek())))
      {
        this.d.c(a.a.b((a.a)this.b.pop()));
        return true;
      }
      long l2;
      long l1;
      if (this.e == 0)
      {
        l2 = this.c.a(parame, true, false, 4);
        l1 = l2;
        if (l2 == -2L) {
          l1 = b(parame);
        }
        if (l1 == -1L) {
          return false;
        }
        this.f = ((int)l1);
        this.e = 1;
      }
      if (this.e == 1)
      {
        this.g = this.c.a(parame, false, true, 8);
        this.e = 2;
      }
      int i = this.d.a(this.f);
      if (i != 0)
      {
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i != 4)
              {
                if (i == 5)
                {
                  l1 = this.g;
                  if ((l1 != 4L) && (l1 != 8L))
                  {
                    parame = new StringBuilder();
                    parame.append("Invalid float size: ");
                    parame.append(this.g);
                    throw new p(parame.toString());
                  }
                  this.d.a(this.f, b(parame, (int)this.g));
                  this.e = 0;
                  return true;
                }
                parame = new StringBuilder();
                parame.append("Invalid element type ");
                parame.append(i);
                throw new p(parame.toString());
              }
              this.d.a(this.f, (int)this.g, parame);
              this.e = 0;
              return true;
            }
            l1 = this.g;
            if (l1 <= 2147483647L)
            {
              this.d.a(this.f, c(parame, (int)l1));
              this.e = 0;
              return true;
            }
            parame = new StringBuilder();
            parame.append("String element size: ");
            parame.append(this.g);
            throw new p(parame.toString());
          }
          l1 = this.g;
          if (l1 <= 8L)
          {
            this.d.a(this.f, a(parame, (int)l1));
            this.e = 0;
            return true;
          }
          parame = new StringBuilder();
          parame.append("Invalid integer size: ");
          parame.append(this.g);
          throw new p(parame.toString());
        }
        l1 = parame.c();
        l2 = this.g;
        this.b.add(new a.a(this.f, l2 + l1, null));
        this.d.a(this.f, l1, this.g);
        this.e = 0;
        return true;
      }
      parame.b((int)this.g);
      this.e = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.n.a
 * JD-Core Version:    0.7.0.1
 */
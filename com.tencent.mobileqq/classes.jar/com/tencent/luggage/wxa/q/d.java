package com.tencent.luggage.wxa.q;

import com.tencent.luggage.wxa.ao.a;
import com.tencent.luggage.wxa.ao.m;
import java.util.Arrays;

final class d
{
  private final e a = new e();
  private final m b = new m(new byte[65025], 0);
  private int c = -1;
  private int d;
  private boolean e;
  
  private int a(int paramInt)
  {
    int i = 0;
    this.d = 0;
    int j;
    int k;
    do
    {
      j = i;
      if (this.d + paramInt >= this.a.g) {
        break;
      }
      int[] arrayOfInt = this.a.j;
      j = this.d;
      this.d = (j + 1);
      k = arrayOfInt[(j + paramInt)];
      j = i + k;
      i = j;
    } while (k == 255);
    return j;
  }
  
  public void a()
  {
    this.a.a();
    this.b.a();
    this.c = -1;
    this.e = false;
  }
  
  public boolean a(com.tencent.luggage.wxa.l.e parame)
  {
    boolean bool;
    if (parame != null) {
      bool = true;
    } else {
      bool = false;
    }
    a.b(bool);
    if (this.e)
    {
      this.e = false;
      this.b.a();
    }
    while (!this.e)
    {
      if (this.c < 0)
      {
        if (!this.a.a(parame, true)) {
          return false;
        }
        i = this.a.h;
        if (((this.a.b & 0x1) == 1) && (this.b.c() == 0))
        {
          i += a(0);
          j = this.d + 0;
        }
        else
        {
          j = 0;
        }
        parame.b(i);
        this.c = j;
      }
      int i = a(this.c);
      int j = this.c + this.d;
      if (i > 0)
      {
        if (this.b.e() < this.b.c() + i)
        {
          localm = this.b;
          localm.a = Arrays.copyOf(localm.a, this.b.c() + i);
        }
        parame.b(this.b.a, this.b.c(), i);
        m localm = this.b;
        localm.b(localm.c() + i);
        if (this.a.j[(j - 1)] != 255) {
          bool = true;
        } else {
          bool = false;
        }
        this.e = bool;
      }
      i = j;
      if (j == this.a.g) {
        i = -1;
      }
      this.c = i;
    }
    return true;
  }
  
  public e b()
  {
    return this.a;
  }
  
  public m c()
  {
    return this.b;
  }
  
  public void d()
  {
    if (this.b.a.length == 65025) {
      return;
    }
    m localm = this.b;
    localm.a = Arrays.copyOf(localm.a, Math.max(65025, this.b.c()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.q.d
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.luggage.wxa.z;

import com.tencent.luggage.wxa.al.e;
import com.tencent.luggage.wxa.ao.a;
import com.tencent.luggage.wxa.ao.j;

public final class c
  implements g, g.a
{
  public final g a;
  private g.a b;
  private long c;
  private long d;
  private c.a[] e;
  private boolean f;
  
  public c(g paramg, boolean paramBoolean)
  {
    this.a = paramg;
    this.c = -9223372036854775807L;
    this.d = -9223372036854775807L;
    this.e = new c.a[0];
    this.f = paramBoolean;
  }
  
  private static boolean a(e[] paramArrayOfe)
  {
    int j = paramArrayOfe.length;
    int i = 0;
    while (i < j)
    {
      e locale = paramArrayOfe[i];
      if ((locale != null) && (!j.a(locale.f().f))) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public long a(e[] paramArrayOfe, boolean[] paramArrayOfBoolean1, k[] paramArrayOfk, boolean[] paramArrayOfBoolean2, long paramLong)
  {
    this.e = new c.a[paramArrayOfk.length];
    k[] arrayOfk = new k[paramArrayOfk.length];
    int i = 0;
    for (;;)
    {
      int j = paramArrayOfk.length;
      k localk = null;
      if (i >= j) {
        break;
      }
      c.a[] arrayOfa = this.e;
      arrayOfa[i] = ((c.a)paramArrayOfk[i]);
      if (arrayOfa[i] != null) {
        localk = c.a.a(arrayOfa[i]);
      }
      arrayOfk[i] = localk;
      i += 1;
    }
    long l1 = this.a.a(paramArrayOfe, paramArrayOfBoolean1, arrayOfk, paramArrayOfBoolean2, paramLong + this.c);
    boolean bool1 = this.f;
    boolean bool2 = true;
    if (bool1)
    {
      if ((this.c != 0L) && (a(paramArrayOfe))) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.f = bool1;
    }
    long l2 = this.c;
    bool1 = bool2;
    if (l1 != paramLong + l2)
    {
      if (l1 >= l2)
      {
        paramLong = this.d;
        bool1 = bool2;
        if (paramLong == -9223372036854775808L) {
          break label220;
        }
        if (l1 <= paramLong)
        {
          bool1 = bool2;
          break label220;
        }
      }
      bool1 = false;
    }
    label220:
    a.b(bool1);
    i = 0;
    while (i < paramArrayOfk.length)
    {
      if (arrayOfk[i] == null) {
        this.e[i] = null;
      } else if ((paramArrayOfk[i] == null) || (c.a.a(this.e[i]) != arrayOfk[i])) {
        this.e[i] = new c.a(this, arrayOfk[i], this.c, this.d, this.f);
      }
      paramArrayOfk[i] = this.e[i];
      i += 1;
    }
    return l1 - this.c;
  }
  
  public void a(long paramLong)
  {
    this.a.a(paramLong + this.c);
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    this.c = paramLong1;
    this.d = paramLong2;
  }
  
  public void a(g.a parama, long paramLong)
  {
    this.b = parama;
    this.a.a(this, this.c + paramLong);
  }
  
  public void a(g paramg)
  {
    boolean bool;
    if ((this.c != -9223372036854775807L) && (this.d != -9223372036854775807L)) {
      bool = true;
    } else {
      bool = false;
    }
    a.b(bool);
    this.b.a(this);
  }
  
  public long b(long paramLong)
  {
    c.a[] arrayOfa = this.e;
    int j = arrayOfa.length;
    boolean bool2 = false;
    int i = 0;
    while (i < j)
    {
      c.a locala = arrayOfa[i];
      if (locala != null) {
        locala.b();
      }
      i += 1;
    }
    long l1 = this.a.b(this.c + paramLong);
    long l2 = this.c;
    if (l1 != paramLong + l2)
    {
      bool1 = bool2;
      if (l1 < l2) {
        break label117;
      }
      paramLong = this.d;
      if (paramLong != -9223372036854775808L)
      {
        bool1 = bool2;
        if (l1 > paramLong) {
          break label117;
        }
      }
    }
    boolean bool1 = true;
    label117:
    a.b(bool1);
    return l1 - this.c;
  }
  
  public o b()
  {
    return this.a.b();
  }
  
  public void b(g paramg)
  {
    this.b.a(this);
  }
  
  public long c()
  {
    if (this.f)
    {
      c.a[] arrayOfa = this.e;
      int j = arrayOfa.length;
      int i = 0;
      while (i < j)
      {
        c.a locala = arrayOfa[i];
        if (locala != null) {
          locala.a();
        }
        i += 1;
      }
      this.f = false;
      l1 = c();
      if (l1 != -9223372036854775807L) {
        return l1;
      }
      return 0L;
    }
    long l1 = this.a.c();
    if (l1 == -9223372036854775807L) {
      return -9223372036854775807L;
    }
    long l2 = this.c;
    boolean bool2 = true;
    if (l1 >= l2) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    a.b(bool1);
    l2 = this.d;
    boolean bool1 = bool2;
    if (l2 != -9223372036854775808L) {
      if (l1 <= l2) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
    }
    a.b(bool1);
    return l1 - this.c;
  }
  
  public boolean c(long paramLong)
  {
    return this.a.c(paramLong + this.c);
  }
  
  public long d()
  {
    long l1 = this.a.d();
    if (l1 != -9223372036854775808L)
    {
      long l2 = this.d;
      if ((l2 != -9223372036854775808L) && (l1 >= l2)) {
        return -9223372036854775808L;
      }
      return Math.max(0L, l1 - this.c);
    }
    return -9223372036854775808L;
  }
  
  public void d_()
  {
    this.a.d_();
  }
  
  public long e()
  {
    long l1 = this.a.e();
    if (l1 != -9223372036854775808L)
    {
      long l2 = this.d;
      if ((l2 != -9223372036854775808L) && (l1 >= l2)) {
        return -9223372036854775808L;
      }
      return l1 - this.c;
    }
    return -9223372036854775808L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.z.c
 * JD-Core Version:    0.7.0.1
 */
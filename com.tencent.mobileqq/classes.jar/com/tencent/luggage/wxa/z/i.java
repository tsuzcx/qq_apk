package com.tencent.luggage.wxa.z;

import com.tencent.luggage.wxa.ao.a;
import com.tencent.luggage.wxa.ao.x;
import com.tencent.luggage.wxa.h.k;
import com.tencent.luggage.wxa.h.l;
import com.tencent.luggage.wxa.j.e;
import com.tencent.luggage.wxa.l.l.a;

final class i
{
  private int a = 1000;
  private int[] b;
  private long[] c;
  private int[] d;
  private int[] e;
  private long[] f;
  private l.a[] g;
  private k[] h;
  private int i;
  private int j;
  private int k;
  private int l;
  private long m;
  private long n;
  private boolean o;
  private boolean p;
  private k q;
  private int r;
  
  public i()
  {
    int i1 = this.a;
    this.b = new int[i1];
    this.c = new long[i1];
    this.f = new long[i1];
    this.e = new int[i1];
    this.d = new int[i1];
    this.g = new l.a[i1];
    this.h = new k[i1];
    this.m = -9223372036854775808L;
    this.n = -9223372036854775808L;
    this.p = true;
    this.o = true;
  }
  
  private int a(int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    int i1 = paramInt1;
    paramInt1 = 0;
    int i2 = -1;
    while ((paramInt1 < paramInt2) && (this.f[i1] <= paramLong))
    {
      if ((!paramBoolean) || ((this.e[i1] & 0x1) != 0)) {
        i2 = paramInt1;
      }
      int i3 = i1 + 1;
      i1 = i3;
      if (i3 == this.a) {
        i1 = 0;
      }
      paramInt1 += 1;
    }
    return i2;
  }
  
  private long c(int paramInt)
  {
    this.m = Math.max(this.m, d(paramInt));
    this.i -= paramInt;
    this.j += paramInt;
    this.k += paramInt;
    int i1 = this.k;
    int i2 = this.a;
    if (i1 >= i2) {
      this.k = (i1 - i2);
    }
    this.l -= paramInt;
    if (this.l < 0) {
      this.l = 0;
    }
    if (this.i == 0)
    {
      i1 = this.k;
      paramInt = i1;
      if (i1 == 0) {
        paramInt = this.a;
      }
      paramInt -= 1;
      return this.c[paramInt] + this.d[paramInt];
    }
    return this.c[this.k];
  }
  
  private long d(int paramInt)
  {
    long l1 = -9223372036854775808L;
    if (paramInt == 0) {
      return -9223372036854775808L;
    }
    int i1 = e(paramInt - 1);
    int i2 = 0;
    while (i2 < paramInt)
    {
      l1 = Math.max(l1, this.f[i1]);
      if ((this.e[i1] & 0x1) != 0) {
        return l1;
      }
      int i3 = i1 - 1;
      i1 = i3;
      if (i3 == -1) {
        i1 = this.a - 1;
      }
      i2 += 1;
    }
    return l1;
  }
  
  private int e(int paramInt)
  {
    paramInt = this.k + paramInt;
    int i1 = this.a;
    if (paramInt < i1) {
      return paramInt;
    }
    return paramInt - i1;
  }
  
  public int a()
  {
    return this.j + this.i;
  }
  
  public int a(l paraml, e parame, boolean paramBoolean1, boolean paramBoolean2, k paramk, i.a parama)
  {
    try
    {
      if (!d())
      {
        if (paramBoolean2)
        {
          parame.a_(4);
          return -4;
        }
        if ((this.q != null) && ((paramBoolean1) || (this.q != paramk)))
        {
          paraml.a = this.q;
          return -5;
        }
        return -3;
      }
      int i1 = e(this.l);
      if ((!paramBoolean1) && (this.h[i1] == paramk))
      {
        paramBoolean1 = parame.f();
        if (paramBoolean1) {
          return -3;
        }
        parame.c = this.f[i1];
        parame.a_(this.e[i1]);
        parama.a = this.d[i1];
        parama.b = this.c[i1];
        parama.c = this.g[i1];
        this.l += 1;
        return -4;
      }
      paraml.a = this.h[i1];
      return -5;
    }
    finally {}
  }
  
  public long a(int paramInt)
  {
    paramInt = a() - paramInt;
    boolean bool;
    if ((paramInt >= 0) && (paramInt <= this.i - this.l)) {
      bool = true;
    } else {
      bool = false;
    }
    a.a(bool);
    this.i -= paramInt;
    this.n = Math.max(this.m, d(this.i));
    paramInt = this.i;
    if (paramInt == 0) {
      return 0L;
    }
    paramInt = e(paramInt - 1);
    return this.c[paramInt] + this.d[paramInt];
  }
  
  public void a(long paramLong)
  {
    try
    {
      this.n = Math.max(this.n, paramLong);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(long paramLong1, int paramInt1, long paramLong2, int paramInt2, l.a parama)
  {
    for (;;)
    {
      try
      {
        bool = this.o;
        if (bool)
        {
          if ((paramInt1 & 0x1) == 0) {
            return;
          }
          this.o = false;
        }
        if (!this.p)
        {
          bool = true;
          a.b(bool);
          a(paramLong1);
          int i1 = e(this.i);
          this.f[i1] = paramLong1;
          this.c[i1] = paramLong2;
          this.d[i1] = paramInt2;
          this.e[i1] = paramInt1;
          this.g[i1] = parama;
          this.h[i1] = this.q;
          this.b[i1] = this.r;
          this.i += 1;
          if (this.i == this.a)
          {
            paramInt1 = this.a + 1000;
            parama = new int[paramInt1];
            long[] arrayOfLong1 = new long[paramInt1];
            long[] arrayOfLong2 = new long[paramInt1];
            int[] arrayOfInt1 = new int[paramInt1];
            int[] arrayOfInt2 = new int[paramInt1];
            l.a[] arrayOfa = new l.a[paramInt1];
            k[] arrayOfk = new k[paramInt1];
            paramInt2 = this.a - this.k;
            System.arraycopy(this.c, this.k, arrayOfLong1, 0, paramInt2);
            System.arraycopy(this.f, this.k, arrayOfLong2, 0, paramInt2);
            System.arraycopy(this.e, this.k, arrayOfInt1, 0, paramInt2);
            System.arraycopy(this.d, this.k, arrayOfInt2, 0, paramInt2);
            System.arraycopy(this.g, this.k, arrayOfa, 0, paramInt2);
            System.arraycopy(this.h, this.k, arrayOfk, 0, paramInt2);
            System.arraycopy(this.b, this.k, parama, 0, paramInt2);
            i1 = this.k;
            System.arraycopy(this.c, 0, arrayOfLong1, paramInt2, i1);
            System.arraycopy(this.f, 0, arrayOfLong2, paramInt2, i1);
            System.arraycopy(this.e, 0, arrayOfInt1, paramInt2, i1);
            System.arraycopy(this.d, 0, arrayOfInt2, paramInt2, i1);
            System.arraycopy(this.g, 0, arrayOfa, paramInt2, i1);
            System.arraycopy(this.h, 0, arrayOfk, paramInt2, i1);
            System.arraycopy(this.b, 0, parama, paramInt2, i1);
            this.c = arrayOfLong1;
            this.f = arrayOfLong2;
            this.e = arrayOfInt1;
            this.d = arrayOfInt2;
            this.g = arrayOfa;
            this.h = arrayOfk;
            this.b = parama;
            this.k = 0;
            this.i = this.a;
            this.a = paramInt1;
          }
          return;
        }
      }
      finally {}
      boolean bool = false;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.i = 0;
    this.j = 0;
    this.k = 0;
    this.l = 0;
    this.o = true;
    this.m = -9223372036854775808L;
    this.n = -9223372036854775808L;
    if (paramBoolean)
    {
      this.q = null;
      this.p = true;
    }
  }
  
  public boolean a(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      int i1 = e(this.l);
      if ((d()) && (paramLong >= this.f[i1]) && ((paramLong <= this.n) || (paramBoolean2)))
      {
        i1 = a(i1, this.i - this.l, paramLong, paramBoolean1);
        if (i1 == -1) {
          return false;
        }
        this.l += i1;
        return true;
      }
      return false;
    }
    finally {}
  }
  
  public boolean a(k paramk)
  {
    if (paramk == null) {}
    try
    {
      this.p = true;
      return false;
    }
    finally {}
    this.p = false;
    boolean bool = x.a(paramk, this.q);
    if (bool) {
      return false;
    }
    this.q = paramk;
    return true;
  }
  
  public int b()
  {
    return this.j + this.l;
  }
  
  public long b(long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      if ((this.i != 0) && (paramLong >= this.f[this.k]))
      {
        if ((paramBoolean2) && (this.l != this.i)) {
          i1 = this.l + 1;
        } else {
          i1 = this.i;
        }
        int i1 = a(this.k, i1, paramLong, paramBoolean1);
        if (i1 == -1) {
          return -1L;
        }
        paramLong = c(i1);
        return paramLong;
      }
      return -1L;
    }
    finally {}
  }
  
  public void b(int paramInt)
  {
    this.r = paramInt;
  }
  
  public boolean b(long paramLong)
  {
    try
    {
      int i1 = this.i;
      boolean bool = false;
      if (i1 == 0)
      {
        l1 = this.m;
        if (paramLong > l1) {
          bool = true;
        }
        return bool;
      }
      long l1 = Math.max(this.m, d(this.l));
      if (l1 >= paramLong) {
        return false;
      }
      int i2 = this.i;
      i1 = e(this.i - 1);
      while ((i2 > this.l) && (this.f[i1] >= paramLong))
      {
        int i3 = i2 - 1;
        int i4 = i1 - 1;
        i2 = i3;
        i1 = i4;
        if (i4 == -1)
        {
          i1 = this.a - 1;
          i2 = i3;
        }
      }
      a(this.j + i2);
      return true;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public int c()
  {
    int i1 = e(this.l);
    if (d()) {
      return this.b[i1];
    }
    return this.r;
  }
  
  public boolean d()
  {
    try
    {
      int i1 = this.l;
      int i2 = this.i;
      boolean bool;
      if (i1 != i2) {
        bool = true;
      } else {
        bool = false;
      }
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public k e()
  {
    try
    {
      k localk;
      if (this.p) {
        localk = null;
      } else {
        localk = this.q;
      }
      return localk;
    }
    finally {}
  }
  
  public long f()
  {
    try
    {
      long l1 = this.n;
      return l1;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void g()
  {
    try
    {
      this.l = 0;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void h()
  {
    try
    {
      boolean bool = d();
      if (!bool) {
        return;
      }
      this.l = this.i;
      return;
    }
    finally {}
  }
  
  public long i()
  {
    try
    {
      int i1 = this.l;
      if (i1 == 0) {
        return -1L;
      }
      long l1 = c(this.l);
      return l1;
    }
    finally {}
  }
  
  public long j()
  {
    try
    {
      int i1 = this.i;
      if (i1 == 0) {
        return -1L;
      }
      long l1 = c(this.i);
      return l1;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.z.i
 * JD-Core Version:    0.7.0.1
 */
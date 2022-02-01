package com.tencent.luggage.wxa.am;

import com.tencent.luggage.wxa.ao.x;
import java.util.Arrays;

public final class k
  implements b
{
  private final boolean a;
  private final int b;
  private final byte[] c;
  private final a[] d;
  private int e;
  private int f;
  private int g;
  private a[] h;
  
  public k(boolean paramBoolean, int paramInt)
  {
    this(paramBoolean, paramInt, 0);
  }
  
  public k(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    int i = 0;
    boolean bool;
    if (paramInt1 > 0) {
      bool = true;
    } else {
      bool = false;
    }
    com.tencent.luggage.wxa.ao.a.a(bool);
    if (paramInt2 >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    com.tencent.luggage.wxa.ao.a.a(bool);
    this.a = paramBoolean;
    this.b = paramInt1;
    this.g = paramInt2;
    this.h = new a[paramInt2 + 100];
    if (paramInt2 > 0)
    {
      this.c = new byte[paramInt2 * paramInt1];
      while (i < paramInt2)
      {
        this.h[i] = new a(this.c, i * paramInt1);
        i += 1;
      }
    }
    this.c = null;
    this.d = new a[1];
  }
  
  public a a()
  {
    try
    {
      this.f += 1;
      Object localObject1;
      if (this.g > 0)
      {
        localObject1 = this.h;
        int i = this.g - 1;
        this.g = i;
        localObject1 = localObject1[i];
        this.h[this.g] = null;
      }
      else
      {
        localObject1 = new a(new byte[this.b], 0);
      }
      return localObject1;
    }
    finally {}
  }
  
  public void a(int paramInt)
  {
    for (;;)
    {
      try
      {
        if (paramInt < this.e)
        {
          i = 1;
          this.e = paramInt;
          if (i != 0) {
            b();
          }
          return;
        }
      }
      finally {}
      int i = 0;
    }
  }
  
  public void a(a parama)
  {
    try
    {
      this.d[0] = parama;
      a(this.d);
      return;
    }
    finally
    {
      parama = finally;
      throw parama;
    }
  }
  
  public void a(a[] paramArrayOfa)
  {
    for (;;)
    {
      try
      {
        if (this.g + paramArrayOfa.length >= this.h.length) {
          this.h = ((a[])Arrays.copyOf(this.h, Math.max(this.h.length * 2, this.g + paramArrayOfa.length)));
        }
        int j = paramArrayOfa.length;
        i = 0;
        if (i >= j) {
          continue;
        }
        locala = paramArrayOfa[i];
        if (locala.a == this.c) {
          continue;
        }
        if (locala.a.length != this.b) {
          continue;
        }
      }
      finally
      {
        int i;
        a locala;
        a[] arrayOfa;
        int k;
        continue;
        throw paramArrayOfa;
        continue;
        boolean bool = false;
        continue;
        bool = true;
        continue;
      }
      com.tencent.luggage.wxa.ao.a.a(bool);
      arrayOfa = this.h;
      k = this.g;
      this.g = (k + 1);
      arrayOfa[k] = locala;
      i += 1;
    }
    this.f -= paramArrayOfa.length;
    notifyAll();
  }
  
  public void b()
  {
    try
    {
      int i = x.a(this.e, this.b);
      int j = this.f;
      int m = 0;
      int k = Math.max(0, i - j);
      i = this.g;
      if (k >= i) {
        return;
      }
      i = k;
      if (this.c != null)
      {
        j = this.g - 1;
        i = m;
        while (i <= j)
        {
          a locala1 = this.h[i];
          if (locala1.a == this.c)
          {
            i += 1;
          }
          else
          {
            a locala2 = this.h[j];
            if (locala2.a != this.c)
            {
              j -= 1;
            }
            else
            {
              this.h[i] = locala2;
              this.h[j] = locala1;
              j -= 1;
              i += 1;
            }
          }
        }
        j = Math.max(k, i);
        k = this.g;
        i = j;
        if (j >= k) {
          return;
        }
      }
      Arrays.fill(this.h, i, this.g, null);
      this.g = i;
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public int c()
  {
    return this.b;
  }
  
  public void d()
  {
    try
    {
      if (this.a) {
        a(0);
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int e()
  {
    try
    {
      int i = this.f;
      int j = this.b;
      return i * j;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.am.k
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.luggage.wxa.al;

import android.os.SystemClock;
import com.tencent.luggage.wxa.h.k;
import com.tencent.luggage.wxa.z.n;
import java.util.Arrays;

public abstract class a
  implements e
{
  protected final n a;
  protected final int b;
  protected final int[] c;
  private final k[] d;
  private final long[] e;
  private int f;
  
  public a(n paramn, int... paramVarArgs)
  {
    int i = paramVarArgs.length;
    int j = 0;
    boolean bool;
    if (i > 0) {
      bool = true;
    } else {
      bool = false;
    }
    com.tencent.luggage.wxa.ao.a.b(bool);
    this.a = ((n)com.tencent.luggage.wxa.ao.a.a(paramn));
    this.b = paramVarArgs.length;
    this.d = new k[this.b];
    i = 0;
    while (i < paramVarArgs.length)
    {
      this.d[i] = paramn.a(paramVarArgs[i]);
      i += 1;
    }
    Arrays.sort(this.d, new a.a(null));
    this.c = new int[this.b];
    i = j;
    for (;;)
    {
      j = this.b;
      if (i >= j) {
        break;
      }
      this.c[i] = paramn.a(this.d[i]);
      i += 1;
    }
    this.e = new long[j];
  }
  
  public final int a(k paramk)
  {
    int i = 0;
    while (i < this.b)
    {
      if (this.d[i] == paramk) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public final k a(int paramInt)
  {
    return this.d[paramInt];
  }
  
  public final boolean a(int paramInt, long paramLong)
  {
    long l = SystemClock.elapsedRealtime();
    boolean bool = b(paramInt, l);
    int i = 0;
    while ((i < this.b) && (!bool))
    {
      if ((i != paramInt) && (!b(i, l))) {
        bool = true;
      } else {
        bool = false;
      }
      i += 1;
    }
    if (!bool) {
      return false;
    }
    long[] arrayOfLong = this.e;
    arrayOfLong[paramInt] = Math.max(arrayOfLong[paramInt], l + paramLong);
    return true;
  }
  
  public final int b(int paramInt)
  {
    return this.c[paramInt];
  }
  
  protected final boolean b(int paramInt, long paramLong)
  {
    return this.e[paramInt] > paramLong;
  }
  
  public final int c(int paramInt)
  {
    int i = 0;
    while (i < this.b)
    {
      if (this.c[i] == paramInt) {
        return i;
      }
      i += 1;
    }
    return -1;
  }
  
  public final n d()
  {
    return this.a;
  }
  
  public final int e()
  {
    return this.c.length;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (a)paramObject;
      return (this.a == paramObject.a) && (Arrays.equals(this.c, paramObject.c));
    }
    return false;
  }
  
  public final k f()
  {
    return this.d[a()];
  }
  
  public final int g()
  {
    return this.c[a()];
  }
  
  public int hashCode()
  {
    if (this.f == 0) {
      this.f = (System.identityHashCode(this.a) * 31 + Arrays.hashCode(this.c));
    }
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.al.a
 * JD-Core Version:    0.7.0.1
 */
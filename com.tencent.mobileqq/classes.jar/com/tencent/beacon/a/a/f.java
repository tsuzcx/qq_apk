package com.tencent.beacon.a.a;

import com.tencent.beacon.d.a;
import java.io.Serializable;
import java.util.Locale;

public class f
  implements Serializable
{
  public int a;
  public long b;
  public long c;
  public long d;
  public long e;
  public long f;
  public long g;
  public long h;
  public long i;
  private long j = -1L;
  
  public f(int paramInt, long paramLong1, long paramLong2, long paramLong3, long paramLong4, long paramLong5, long paramLong6)
  {
    this.a = paramInt;
    this.b = paramLong1;
    this.c = paramLong2;
    this.d = paramLong3;
    this.e = paramLong4;
    this.f = paramLong5;
    this.g = paramLong6;
  }
  
  public final long a()
  {
    try
    {
      long l = this.j;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(long paramLong)
  {
    try
    {
      this.j = paramLong;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public String toString()
  {
    try
    {
      String str = String.format(Locale.US, "[tp:%d , st:%d ,counts:%d, wifi:%d , notWifi:%d , up:%d , dn:%d]", new Object[] { Integer.valueOf(this.a), Long.valueOf(this.b), Long.valueOf(this.c), Long.valueOf(this.d), Long.valueOf(this.e), Long.valueOf(this.f), Long.valueOf(this.g) });
      return str;
    }
    catch (Throwable localThrowable)
    {
      a.a(localThrowable);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.a.a.f
 * JD-Core Version:    0.7.0.1
 */
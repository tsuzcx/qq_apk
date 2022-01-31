package com.tencent.beacon.core.c;

import com.tencent.beacon.core.d.b;

public final class d
  implements e
{
  private long a = 0L;
  private long b = 0L;
  private int c = 0;
  private long d = 0L;
  private String e = "";
  
  private void a(int paramInt)
  {
    try
    {
      this.c = paramInt;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a()
  {
    b.h("[net] request time out!!!", new Object[0]);
  }
  
  public final void a(long paramLong1, long paramLong2)
  {
    try
    {
      b.h("[net] received: %d", new Object[] { Long.valueOf(paramLong1) });
      this.b += paramLong1;
      this.d = paramLong2;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void a(String paramString1, long paramLong, String paramString2, int paramInt)
  {
    try
    {
      b.h("[net] send: %s sz: %d apn: %s", new Object[] { paramString1, Long.valueOf(paramLong), paramString2 });
      this.e = paramString2;
      this.c += 1;
      this.a += paramLong;
      a(paramInt);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public final long b()
  {
    try
    {
      long l = this.a;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final long c()
  {
    try
    {
      long l = this.b;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int d()
  {
    try
    {
      int i = this.c;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final long e()
  {
    try
    {
      long l = this.d;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final String f()
  {
    try
    {
      String str = this.e;
      return str;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.beacon.core.c.d
 * JD-Core Version:    0.7.0.1
 */
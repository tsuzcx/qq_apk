package com.tencent.beacon.a.f;

import com.tencent.beacon.a.g.a;

public final class d
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
  
  public final long a()
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
  
  public final void a(long paramLong1, long paramLong2)
  {
    try
    {
      a.h("[net] received: %d", new Object[] { Long.valueOf(paramLong1) });
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
      a.h("[net] send: %s sz: %d apn: %s", new Object[] { paramString1, Long.valueOf(paramLong), paramString2 });
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
      long l = this.b;
      return l;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final int c()
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
  
  public final long d()
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
  
  public final String e()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.a.f.d
 * JD-Core Version:    0.7.0.1
 */
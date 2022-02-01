package com.tencent.gathererga.core.internal.provider;

import com.tencent.gathererga.core.ProviderResult;

public class ProviderResultImpl
  implements ProviderResult
{
  public static final String[] a = new String[0];
  private long b;
  private Object c;
  private int d;
  private String[] e;
  private Throwable f;
  private long g;
  
  public ProviderResultImpl(long paramLong, Object paramObject)
  {
    this.b = paramLong;
    this.c = paramObject;
  }
  
  public ProviderResultImpl(long paramLong, Object paramObject, int paramInt, String[] paramArrayOfString, Throwable paramThrowable)
  {
    this.b = paramLong;
    this.c = paramObject;
    this.d = paramInt;
    this.f = paramThrowable;
    this.e = paramArrayOfString;
  }
  
  public static ProviderResult a(long paramLong, Throwable paramThrowable)
  {
    return new ProviderResultImpl(paramLong, null, 0, a, paramThrowable);
  }
  
  public static ProviderResult a(long paramLong, String[] paramArrayOfString)
  {
    return new ProviderResultImpl(paramLong, null, -1, paramArrayOfString, null);
  }
  
  public static ProviderResult a(Object paramObject, int paramInt)
  {
    return new ProviderResultImpl(0L, paramObject, paramInt, a, null);
  }
  
  public static ProviderResult b(long paramLong)
  {
    return new ProviderResultImpl(paramLong, null, 0, a, null);
  }
  
  public long a()
  {
    return this.b;
  }
  
  public void a(long paramLong)
  {
    this.g = paramLong;
  }
  
  public Object b()
  {
    return this.c;
  }
  
  public boolean c()
  {
    return this.b == 0L;
  }
  
  public int d()
  {
    return this.d;
  }
  
  public long e()
  {
    return this.g;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gathererga.core.internal.provider.ProviderResultImpl
 * JD-Core Version:    0.7.0.1
 */
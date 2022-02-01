package com.tencent.liteav.network.a;

public final class e
{
  public final String a;
  public final int b;
  public final int c;
  public final long d;
  
  public e(String paramString, int paramInt1, int paramInt2, long paramLong)
  {
    this.a = paramString;
    this.b = paramInt1;
    paramInt1 = 600;
    if (paramInt2 < 600) {
      paramInt2 = paramInt1;
    }
    this.c = paramInt2;
    this.d = paramLong;
  }
  
  public boolean a()
  {
    return this.b == 5;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (!(paramObject instanceof e)) {
        return false;
      }
      paramObject = (e)paramObject;
      return (this.a.equals(paramObject.a)) && (this.b == paramObject.b) && (this.c == paramObject.c) && (this.d == paramObject.d);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.liteav.network.a.e
 * JD-Core Version:    0.7.0.1
 */
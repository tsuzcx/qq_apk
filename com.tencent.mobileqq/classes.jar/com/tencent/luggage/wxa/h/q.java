package com.tencent.luggage.wxa.h;

public final class q
{
  public static final q a = new q(1.0F, 1.0F);
  public final float b;
  public final float c;
  private final int d;
  
  public q(float paramFloat1, float paramFloat2)
  {
    this.b = paramFloat1;
    this.c = paramFloat2;
    this.d = Math.round(paramFloat1 * 1000.0F);
  }
  
  public long a(long paramLong)
  {
    return paramLong * this.d;
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
      paramObject = (q)paramObject;
      return (this.b == paramObject.b) && (this.c == paramObject.c);
    }
    return false;
  }
  
  public int hashCode()
  {
    return (527 + Float.floatToRawIntBits(this.b)) * 31 + Float.floatToRawIntBits(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.h.q
 * JD-Core Version:    0.7.0.1
 */
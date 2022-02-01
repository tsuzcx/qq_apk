package com.tencent.map.sdk.a;

public final class kc$a
  implements Cloneable
{
  public float a = 3.051758E-005F;
  public float b = 4.0F;
  public int c = 3;
  public int d = 20;
  public float e;
  public int f;
  
  static float a(int paramInt)
  {
    return (1 << paramInt - 1) * 1.907349E-006F;
  }
  
  public final float a()
  {
    return this.e / a(this.f);
  }
  
  public final void a(int paramInt, float paramFloat)
  {
    this.e = paramFloat;
    this.f = paramInt;
  }
  
  public final Object clone()
  {
    return super.clone();
  }
  
  public final boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof a)) {
      return false;
    }
    paramObject = (a)paramObject;
    return (this.e == paramObject.e) && (this.f == paramObject.f);
  }
  
  public final int hashCode()
  {
    return toString().hashCode();
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("scale:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", scaleLevel:");
    localStringBuilder.append(this.f);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.kc.a
 * JD-Core Version:    0.7.0.1
 */
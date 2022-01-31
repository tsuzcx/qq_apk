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
    return 1.907349E-006F * (1 << paramInt - 1);
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
    if (!(paramObject instanceof a)) {}
    do
    {
      return false;
      paramObject = (a)paramObject;
    } while ((this.e != paramObject.e) || (this.f != paramObject.f));
    return true;
  }
  
  public final int hashCode()
  {
    return toString().hashCode();
  }
  
  public final String toString()
  {
    return "scale:" + this.e + ", scaleLevel:" + this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.map.sdk.a.kc.a
 * JD-Core Version:    0.7.0.1
 */
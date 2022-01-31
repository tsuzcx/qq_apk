package com.tencent.mapsdk.rastercore.b;

public final class f
{
  private double a = 4.9E-324D;
  private double b = 4.9E-324D;
  
  public f(double paramDouble1, double paramDouble2)
  {
    b(paramDouble1);
    a(paramDouble2);
  }
  
  public final double a()
  {
    return this.a;
  }
  
  public final void a(double paramDouble)
  {
    this.a = Math.max(-20037508.34D, Math.min(20037508.34D, paramDouble));
  }
  
  public final double b()
  {
    return this.b;
  }
  
  public final void b(double paramDouble)
  {
    this.b = Math.max(-20037508.34D, Math.min(20037508.34D, paramDouble));
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {}
    do
    {
      return true;
      if (paramObject.hashCode() != hashCode()) {
        return false;
      }
      if (!(paramObject instanceof f)) {
        return false;
      }
      paramObject = (f)paramObject;
    } while ((Double.doubleToLongBits(paramObject.b) == Double.doubleToLongBits(this.b)) && (Double.doubleToLongBits(paramObject.a) == Double.doubleToLongBits(this.a)));
    return false;
  }
  
  public final int hashCode()
  {
    long l1 = Double.doubleToLongBits(this.b);
    long l2 = Double.doubleToLongBits(this.a);
    int i = (int)(l2 ^ l2 >>> 32);
    return (int)(l1 ^ l1 >>> 32) + (i + 31) * 31;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.b.f
 * JD-Core Version:    0.7.0.1
 */
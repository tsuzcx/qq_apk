package com.tencent.mapsdk.rastercore.b;

public final class c
{
  private double a = 4.9E-324D;
  private double b = 4.9E-324D;
  
  public c(double paramDouble1, double paramDouble2)
  {
    this.b = paramDouble1;
    this.a = paramDouble2;
  }
  
  public final double a()
  {
    return this.a;
  }
  
  public final void a(double paramDouble)
  {
    this.a = paramDouble;
  }
  
  public final double b()
  {
    return this.b;
  }
  
  public final void b(double paramDouble)
  {
    this.b = paramDouble;
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
      if (!(paramObject instanceof c)) {
        return false;
      }
      paramObject = (c)paramObject;
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
 * Qualified Name:     com.tencent.mapsdk.rastercore.b.c
 * JD-Core Version:    0.7.0.1
 */
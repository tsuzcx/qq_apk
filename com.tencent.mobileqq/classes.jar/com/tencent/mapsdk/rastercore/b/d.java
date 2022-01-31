package com.tencent.mapsdk.rastercore.b;

public final class d
{
  public static int a = 5;
  private static double b = Math.log(2.0D);
  private int c;
  private double d;
  private double e;
  
  public d(double paramDouble)
  {
    this.e = paramDouble;
    f();
  }
  
  public d(int paramInt, double paramDouble)
  {
    this.c = paramInt;
    this.d = paramDouble;
    e();
  }
  
  public static double c(double paramDouble)
  {
    return 156543.03390000001D / Math.pow(2.0D, paramDouble);
  }
  
  private void e()
  {
    this.e = (Math.log(this.d) / b + this.c);
    new StringBuilder("refreshZoom--zoom=").append(this.e).append(";level=").append(this.c).append(";scale=").append(this.d);
  }
  
  private void f()
  {
    this.c = ((int)this.e);
    this.d = Math.pow(2.0D, this.e - this.c);
    new StringBuilder("refreshLevel--zoom=").append(this.e).append(";level=").append(this.c).append(";scale=").append(this.d);
  }
  
  public final int a()
  {
    return this.c;
  }
  
  public final void a(double paramDouble)
  {
    this.d = paramDouble;
    e();
    f();
  }
  
  public final void a(int paramInt)
  {
    this.c = 19;
    e();
  }
  
  public final double b()
  {
    return this.d;
  }
  
  public final void b(double paramDouble)
  {
    this.e = paramDouble;
    f();
  }
  
  public final double c()
  {
    return this.e;
  }
  
  public final double d()
  {
    return c(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mapsdk.rastercore.b.d
 * JD-Core Version:    0.7.0.1
 */
package c.t.m.g;

import com.tencent.map.geolocation.TencentDistanceAnalysis;

public final class eh
  implements TencentDistanceAnalysis
{
  private double a;
  private int b;
  private int c;
  
  public final void a(double paramDouble)
  {
    this.a = paramDouble;
  }
  
  public final void a(int paramInt)
  {
    this.b = paramInt;
  }
  
  public final void b(int paramInt)
  {
    this.c = paramInt;
  }
  
  public final double getConfidence()
  {
    return this.a;
  }
  
  public final int getGpsCount()
  {
    return this.b;
  }
  
  public final int getNetworkCount()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     c.t.m.g.eh
 * JD-Core Version:    0.7.0.1
 */
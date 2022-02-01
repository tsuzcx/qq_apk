package com.tencent.map.lib.basemap.data;

public class DoublePoint
{
  public double x;
  public double y;
  
  public DoublePoint() {}
  
  public DoublePoint(double paramDouble1, double paramDouble2)
  {
    this.x = paramDouble1;
    this.y = paramDouble2;
  }
  
  public boolean IsInUnitRange()
  {
    double d = this.x;
    if ((d >= 0.0D) && (d <= 1.0D))
    {
      d = this.y;
      if ((d >= 0.0D) && (d <= 1.0D)) {
        return true;
      }
    }
    return false;
  }
  
  public float distanceTo(DoublePoint paramDoublePoint)
  {
    return paramDoublePoint.minus(this).length();
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof DoublePoint))
    {
      paramObject = (DoublePoint)paramObject;
      if ((this.x == paramObject.x) && (this.y == paramObject.y)) {
        return true;
      }
    }
    return false;
  }
  
  public float length()
  {
    return (float)Math.hypot(this.x, this.y);
  }
  
  public DoublePoint minus(double paramDouble1, double paramDouble2)
  {
    return new DoublePoint(this.x - paramDouble1, this.y - paramDouble2);
  }
  
  public DoublePoint minus(DoublePoint paramDoublePoint)
  {
    return minus(paramDoublePoint.x, paramDoublePoint.y);
  }
  
  public DoublePoint mult(double paramDouble1, double paramDouble2)
  {
    return new DoublePoint(this.x * paramDouble1, this.y * paramDouble2);
  }
  
  public DoublePoint normalize()
  {
    return scaledTo(1.0D);
  }
  
  public DoublePoint plus(double paramDouble1, double paramDouble2)
  {
    return new DoublePoint(this.x + paramDouble1, this.y + paramDouble2);
  }
  
  public DoublePoint plus(DoublePoint paramDoublePoint)
  {
    return plus(paramDoublePoint.x, paramDoublePoint.y);
  }
  
  public DoublePoint rotated(float paramFloat)
  {
    double d = paramFloat;
    return new DoublePoint((float)(Math.cos(d) * this.x - Math.sin(d) * this.y), (float)(Math.sin(d) * this.x + Math.cos(d) * this.y));
  }
  
  public DoublePoint rotated90(int paramInt)
  {
    double d2 = this.x;
    double d1 = this.y;
    int i = 0;
    while (i < paramInt)
    {
      double d3 = -d2;
      i += 1;
      d2 = d1;
      d1 = d3;
    }
    return new DoublePoint(d2, d1);
  }
  
  public DoublePoint rotatedAround(DoublePoint paramDoublePoint, float paramFloat)
  {
    return minus(paramDoublePoint).rotated(paramFloat).plus(paramDoublePoint);
  }
  
  public DoublePoint scaledTo(double paramDouble)
  {
    double d = length();
    Double.isNaN(d);
    return times(paramDouble / d);
  }
  
  public void set(double paramDouble1, double paramDouble2)
  {
    this.x = paramDouble1;
    this.y = paramDouble2;
  }
  
  public DoublePoint times(double paramDouble)
  {
    return new DoublePoint(this.x * paramDouble, this.y * paramDouble);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.x);
    localStringBuilder.append(",");
    localStringBuilder.append(this.y);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.lib.basemap.data.DoublePoint
 * JD-Core Version:    0.7.0.1
 */
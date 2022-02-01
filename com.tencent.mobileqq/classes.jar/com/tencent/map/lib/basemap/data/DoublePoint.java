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
    return (this.x >= 0.0D) && (this.x <= 1.0D) && (this.y >= 0.0D) && (this.y <= 1.0D);
  }
  
  public float distanceTo(DoublePoint paramDoublePoint)
  {
    return paramDoublePoint.minus(this).length();
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof DoublePoint))
    {
      paramObject = (DoublePoint)paramObject;
      bool1 = bool2;
      if (this.x == paramObject.x)
      {
        bool1 = bool2;
        if (this.y == paramObject.y) {
          bool1 = true;
        }
      }
    }
    return bool1;
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
    return new DoublePoint((float)(Math.cos(paramFloat) * this.x - Math.sin(paramFloat) * this.y), (float)(Math.sin(paramFloat) * this.x + Math.cos(paramFloat) * this.y));
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
    return times(paramDouble / length());
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
    return this.x + "," + this.y;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.lib.basemap.data.DoublePoint
 * JD-Core Version:    0.7.0.1
 */
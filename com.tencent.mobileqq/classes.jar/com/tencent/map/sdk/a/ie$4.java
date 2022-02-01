package com.tencent.map.sdk.a;

import android.graphics.PointF;

final class ie$4
  extends nv
{
  ie$4(ie paramie, double[] paramArrayOfDouble, long paramLong1, long paramLong2, PointF paramPointF)
  {
    super(3, paramArrayOfDouble);
  }
  
  public final void a()
  {
    this.d.a = false;
  }
  
  public final boolean b()
  {
    long l = System.currentTimeMillis() - this.a;
    if (l > this.b)
    {
      this.d.a = false;
      return true;
    }
    double d1;
    if (this.c.x != 0.0F)
    {
      d1 = ns.a(l, this.c.x, -this.c.x, this.b);
      this.j[0] = d1;
    }
    if (this.c.y != 0.0F)
    {
      d1 = ns.a(l, this.c.y, -this.c.y, this.b);
      this.j[1] = d1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.map.sdk.a.ie.4
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.map.sdk.a;

public final class kl$2
  extends nv
{
  public kl$2(kl paramkl, double[] paramArrayOfDouble, long paramLong, float paramFloat1, float paramFloat2, double paramDouble1, double paramDouble2)
  {
    super(102, paramArrayOfDouble, false);
  }
  
  public final boolean b()
  {
    long l = System.currentTimeMillis() - this.a;
    double d2 = ns.a(l, this.b);
    double d1 = ns.a(l, this.c);
    double[] arrayOfDouble = this.j;
    arrayOfDouble[2] += Math.abs(d2);
    arrayOfDouble = this.j;
    arrayOfDouble[3] += Math.abs(d1);
    int i;
    if (this.j[2] >= Math.abs(this.d)) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (this.j[3] >= Math.abs(this.e)) {
      j = 1;
    } else {
      j = 0;
    }
    if (i != 0)
    {
      arrayOfDouble = this.j;
      d2 = this.f;
      double d3 = this.h.h();
      Double.isNaN(d3);
      arrayOfDouble[0] = (d2 - d3);
    }
    else
    {
      this.j[0] = d2;
    }
    if (j != 0)
    {
      arrayOfDouble = this.j;
      d1 = this.g;
      d2 = this.h.i();
      Double.isNaN(d2);
      arrayOfDouble[1] = (d1 - d2);
    }
    else
    {
      this.j[1] = d1;
    }
    return (i != 0) && (j != 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.map.sdk.a.kl.2
 * JD-Core Version:    0.7.0.1
 */
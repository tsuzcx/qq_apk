package com.tencent.mobileqq.activity.aio.anim;

public class PathDemo
  implements AnimationPath
{
  double b;
  private int c;
  private int d;
  private float e;
  private int f;
  private int g;
  private int h;
  private int i;
  
  public int a(long paramLong, AnimationPath.Values paramValues)
  {
    float f1 = this.c;
    float f2 = this.e;
    float f3 = (float)paramLong;
    paramValues.a = ((int)(f1 + f2 * f3));
    double d1 = this.d;
    double d2 = paramLong;
    Double.isNaN(d2);
    Double.isNaN(d1);
    paramValues.b = ((int)(d1 + d2 * 0.8D));
    paramValues.i = ((float)((Math.sin(f3 / 500.0F) + 1.0D) / 2.0D));
    d1 = f3 / 2.0F;
    d2 = Math.sin(this.b);
    Double.isNaN(d1);
    paramValues.d = ((float)(d2 * d1));
    d2 = Math.cos(this.b);
    Double.isNaN(d1);
    paramValues.e = ((float)(d1 * d2));
    if ((paramValues.a >= -this.f) && (paramValues.b >= -this.g) && (paramValues.a <= this.h + this.f) && (paramValues.b <= this.i + this.g)) {
      return 16;
    }
    return -1;
  }
  
  public int a(AnimationPath.Values paramValues, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.c = (paramInt3 / 2);
    this.d = 0;
    this.e = ((float)(Math.random() - 0.5D));
    this.f = (paramInt1 / 2);
    this.g = (paramInt2 / 2);
    this.h = paramInt3;
    this.i = paramInt4;
    paramValues.a = this.c;
    paramValues.b = this.d;
    this.b = (Math.random() * 2.0D * 3.141592653589793D);
    return 1;
  }
  
  public PathDemo b()
  {
    return new PathDemo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.anim.PathDemo
 * JD-Core Version:    0.7.0.1
 */
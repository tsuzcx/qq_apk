package com.tencent.mobileqq.ar.arengine;

import android.graphics.PointF;

public class ARLocalGestureCircleRecogResult$ARCircleResult
{
  public int a = -2;
  public int b = -2;
  public ARLocalGestureCircleRecogResult.ARCircle c = new ARLocalGestureCircleRecogResult.ARCircle();
  public PointF[] d = new PointF[1000];
  public int e = 0;
  public int f = 0;
  public PointF[] g = new PointF[1000];
  public int[] h = new int[1000];
  public int i = 80;
  public int j = 8;
  public int k = 0;
  public int l = 0;
  public int m = 0;
  public int n = 0;
  
  public void a()
  {
    this.a = -2;
    this.b = -2;
    ARLocalGestureCircleRecogResult.ARCircle localARCircle = this.c;
    localARCircle.b = 0.0F;
    localARCircle.c = 0.0F;
    localARCircle.a = 0.0F;
    this.e = 0;
    this.f = 0;
    this.j = 10;
    this.k = 0;
    this.l = 0;
    this.m = 0;
    this.n = 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ARCircleResult{, state = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", lastState = ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", pointCnt = ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", lastPointCnt = ");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", genIdx = ");
    localStringBuilder.append(this.k);
    localStringBuilder.append(", gesturePointCnt = ");
    localStringBuilder.append(this.l);
    localStringBuilder.append(", stillPointCnt = ");
    localStringBuilder.append(this.m);
    localStringBuilder.append(", goodPointCnt = ");
    localStringBuilder.append(this.n);
    localStringBuilder.append(", circle(r,x,y,c) = (");
    localStringBuilder.append((int)this.c.a);
    localStringBuilder.append(",");
    localStringBuilder.append((int)this.c.b);
    localStringBuilder.append(",");
    localStringBuilder.append((int)this.c.c);
    localStringBuilder.append(",");
    localStringBuilder.append(this.c.d);
    localStringBuilder.append(")");
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARLocalGestureCircleRecogResult.ARCircleResult
 * JD-Core Version:    0.7.0.1
 */
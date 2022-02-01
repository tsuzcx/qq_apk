package com.tencent.mobileqq.ar.arengine;

import android.graphics.PointF;

public class ARLocalGestureCircleRecogResult$ARGestureResult
{
  public boolean a = false;
  public int b = -1;
  public String c = "";
  public PointF[] d = null;
  public int e = 0;
  public int f = 0;
  public int g = -1;
  
  public ARLocalGestureCircleRecogResult$ARGestureResult()
  {
    this.d = new PointF[1000];
    a();
  }
  
  public ARLocalGestureCircleRecogResult$ARGestureResult(int paramInt)
  {
    this.d = new PointF[paramInt];
    a();
  }
  
  public void a()
  {
    this.a = false;
    this.b = -1;
    this.c = "";
    this.e = 0;
    this.f = 0;
    this.g = -1;
  }
  
  public String toString()
  {
    Object localObject;
    if (this.e > 0)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("(");
      ((StringBuilder)localObject).append((int)this.d[(this.e - 1)].x);
      ((StringBuilder)localObject).append(",");
      ((StringBuilder)localObject).append((int)this.d[(this.e - 1)].y);
      ((StringBuilder)localObject).append(")");
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = "(-1,-1)";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ARGestureResult{, state = ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", type = ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", pointCnt = ");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", newPoint(x,y) = ");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(", mode = ");
    localStringBuilder.append(this.g);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.arengine.ARLocalGestureCircleRecogResult.ARGestureResult
 * JD-Core Version:    0.7.0.1
 */
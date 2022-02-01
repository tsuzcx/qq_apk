package com.tencent.common.danmaku.tool;

import android.graphics.Point;

public final class TouchPoint
{
  public final long a;
  public final Point b;
  public final int c;
  public float d = 0.0F;
  public float e = 0.0F;
  
  public TouchPoint(long paramLong, Point paramPoint, int paramInt)
  {
    this.a = paramLong;
    this.b = paramPoint;
    this.c = paramInt;
  }
  
  public float a()
  {
    return this.b.x - this.d;
  }
  
  public void a(float paramFloat1, float paramFloat2)
  {
    this.d = paramFloat1;
    this.e = paramFloat2;
  }
  
  public float b()
  {
    return this.b.y - this.e;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TouchPoint{mTime=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mPoint=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", mDistanceOfError=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.danmaku.tool.TouchPoint
 * JD-Core Version:    0.7.0.1
 */
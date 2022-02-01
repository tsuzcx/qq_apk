package com.tencent.biz.qqcircle.bizparts.danmaku.core;

import android.graphics.Point;

public final class PhotoDanmakuManager$TouchPoint
{
  public final long a;
  public final Point b;
  public final int c;
  
  public PhotoDanmakuManager$TouchPoint(long paramLong, Point paramPoint, int paramInt)
  {
    this.a = paramLong;
    this.b = paramPoint;
    this.c = paramInt;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("TouchPoint{mTime=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mPoint=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", distanceOfError=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.danmaku.core.PhotoDanmakuManager.TouchPoint
 * JD-Core Version:    0.7.0.1
 */
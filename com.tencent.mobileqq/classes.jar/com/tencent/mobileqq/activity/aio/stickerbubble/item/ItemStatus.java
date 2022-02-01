package com.tencent.mobileqq.activity.aio.stickerbubble.item;

import android.graphics.Point;
import android.graphics.RectF;

public class ItemStatus
{
  public RectF a = new RectF();
  public ItemStatus.Velocity b = new ItemStatus.Velocity(0.0D, 0.0D);
  public ItemStatus.Acceleration c = new ItemStatus.Acceleration(0.0D, 0.0D);
  public int d = 0;
  public double e = 0.0D;
  public long f = 0L;
  
  public void a(Point paramPoint, double paramDouble1, double paramDouble2, int paramInt)
  {
    if (paramInt == 85)
    {
      localRectF = this.a;
      d1 = paramPoint.x;
      Double.isNaN(d1);
      f1 = (float)(d1 - paramDouble1);
      paramDouble1 = paramPoint.y;
      Double.isNaN(paramDouble1);
      localRectF.set(f1, (float)(paramDouble1 - paramDouble2), paramPoint.x, paramPoint.y);
      return;
    }
    if (paramInt == 81)
    {
      localRectF = this.a;
      d1 = paramPoint.x;
      paramDouble1 /= 2.0D;
      Double.isNaN(d1);
      f1 = (float)(d1 - paramDouble1);
      d1 = paramPoint.y;
      Double.isNaN(d1);
      f2 = (float)(d1 - paramDouble2);
      paramDouble2 = paramPoint.x;
      Double.isNaN(paramDouble2);
      localRectF.set(f1, f2, (float)(paramDouble2 + paramDouble1), paramPoint.y);
      return;
    }
    RectF localRectF = this.a;
    double d1 = paramPoint.x;
    paramDouble1 /= 2.0D;
    Double.isNaN(d1);
    float f1 = (float)(d1 - paramDouble1);
    float f2 = paramPoint.y;
    d1 = paramPoint.x;
    Double.isNaN(d1);
    float f3 = (float)(d1 + paramDouble1);
    paramDouble1 = paramPoint.y;
    Double.isNaN(paramDouble1);
    localRectF.set(f1, f2, f3, (float)(paramDouble1 + paramDouble2));
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ItemStatus{hashCode=");
    localStringBuilder.append(hashCode());
    localStringBuilder.append(", rect=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", velocity=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", acceleration=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.item.ItemStatus
 * JD-Core Version:    0.7.0.1
 */
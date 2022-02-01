package com.tencent.mobileqq.activity.aio.stickerbubble.item;

import android.graphics.Point;
import android.graphics.RectF;

public class ItemStatus
{
  public double a;
  public int a;
  public long a;
  public RectF a;
  public ItemStatus.Acceleration a;
  public ItemStatus.Velocity a;
  
  public ItemStatus()
  {
    this.jdField_a_of_type_Double = 0.0D;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus$Velocity = new ItemStatus.Velocity(0.0D, 0.0D);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus$Acceleration = new ItemStatus.Acceleration(0.0D, 0.0D);
    this.jdField_a_of_type_Int = 0;
  }
  
  public void a(Point paramPoint, double paramDouble1, double paramDouble2, int paramInt)
  {
    if (paramInt == 85)
    {
      localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
      d = paramPoint.x;
      Double.isNaN(d);
      f1 = (float)(d - paramDouble1);
      paramDouble1 = paramPoint.y;
      Double.isNaN(paramDouble1);
      localRectF.set(f1, (float)(paramDouble1 - paramDouble2), paramPoint.x, paramPoint.y);
      return;
    }
    if (paramInt == 81)
    {
      localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
      d = paramPoint.x;
      paramDouble1 /= 2.0D;
      Double.isNaN(d);
      f1 = (float)(d - paramDouble1);
      d = paramPoint.y;
      Double.isNaN(d);
      f2 = (float)(d - paramDouble2);
      paramDouble2 = paramPoint.x;
      Double.isNaN(paramDouble2);
      localRectF.set(f1, f2, (float)(paramDouble2 + paramDouble1), paramPoint.y);
      return;
    }
    RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
    double d = paramPoint.x;
    paramDouble1 /= 2.0D;
    Double.isNaN(d);
    float f1 = (float)(d - paramDouble1);
    float f2 = paramPoint.y;
    d = paramPoint.x;
    Double.isNaN(d);
    float f3 = (float)(d + paramDouble1);
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
    localStringBuilder.append(this.jdField_a_of_type_AndroidGraphicsRectF);
    localStringBuilder.append(", velocity=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus$Velocity);
    localStringBuilder.append(", acceleration=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus$Acceleration);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.item.ItemStatus
 * JD-Core Version:    0.7.0.1
 */
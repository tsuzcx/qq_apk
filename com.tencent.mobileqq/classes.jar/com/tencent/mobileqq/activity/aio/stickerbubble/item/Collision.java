package com.tencent.mobileqq.activity.aio.stickerbubble.item;

import android.graphics.Rect;
import android.graphics.RectF;

public class Collision
{
  private double jdField_a_of_type_Double = -0.8D;
  private int jdField_a_of_type_Int = 0;
  private ItemStatus jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus;
  private int b = 0;
  
  public Collision(ItemStatus paramItemStatus)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus = paramItemStatus;
  }
  
  private void a(int paramInt, Rect paramRect, RectF paramRectF)
  {
    double d3 = 0.0D;
    if ((paramInt & 0x1) > 0)
    {
      d1 = paramRectF.left - paramRect.left;
      Double.isNaN(d1);
      d1 *= -1.8D;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus$Velocity.jdField_a_of_type_Double *= -0.8D;
    }
    else
    {
      d1 = 0.0D;
    }
    double d2 = d1;
    if ((paramInt & 0x2) > 0)
    {
      d1 = paramRectF.right - paramRect.right;
      Double.isNaN(d1);
      d2 = d1 * -1.8D;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus$Velocity.jdField_a_of_type_Double *= -0.8D;
    }
    double d1 = d3;
    if ((paramInt & 0x4) > 0)
    {
      d1 = paramRectF.top - paramRect.top;
      Double.isNaN(d1);
      d1 *= -1.8D;
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus$Velocity.b *= -0.8D;
    }
    if ((paramInt & 0x8) > 0)
    {
      d1 = paramRectF.bottom - paramRect.bottom;
      d3 = this.jdField_a_of_type_Double;
      Double.isNaN(d1);
      d1 *= (d3 - 1.0D);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus$Velocity.b *= this.jdField_a_of_type_Double;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_AndroidGraphicsRectF.offset((float)d2, (float)d1);
  }
  
  protected int a(Rect paramRect, RectF paramRectF)
  {
    if (paramRect.left > paramRectF.left) {
      j = 1;
    } else {
      j = 0;
    }
    int i = j;
    if (paramRect.right < paramRectF.right) {
      i = j ^ 0x2;
    }
    int j = i;
    if (paramRect.top > paramRectF.top) {
      j = i ^ 0x4;
    }
    i = j;
    if (paramRect.bottom < paramRectF.bottom) {
      i = j ^ 0x8;
    }
    return i;
  }
  
  protected void a(Rect paramRect, long paramLong)
  {
    int i = a(paramRect, this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_AndroidGraphicsRectF);
    if (i != 0)
    {
      Object localObject;
      if ((i & 0x8) > 0)
      {
        this.jdField_a_of_type_Int += 1;
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus$Velocity;
        ((ItemStatus.Velocity)localObject).jdField_a_of_type_Double *= 0.95D;
        if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_Int != 2) && (this.jdField_a_of_type_Int >= 3))
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus;
          ((ItemStatus)localObject).jdField_a_of_type_Int = 2;
          ((ItemStatus)localObject).jdField_a_of_type_Long = paramLong;
        }
      }
      this.b += 1;
      if (this.b == 3)
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus;
        ((ItemStatus)localObject).jdField_a_of_type_Double = ((ItemStatus)localObject).jdField_a_of_type_AndroidGraphicsRectF.left;
        this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus$Acceleration.b = 2000.0D;
        this.jdField_a_of_type_Double = -0.5D;
      }
      a(i, paramRect, this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_AndroidGraphicsRectF);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.item.Collision
 * JD-Core Version:    0.7.0.1
 */
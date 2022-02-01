package com.tencent.mobileqq.activity.aio.stickerbubble.item;

import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class Stretch
{
  private double jdField_a_of_type_Double = 1.0D;
  private long jdField_a_of_type_Long;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private ItemStatus jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus;
  private double b = 1.0D;
  private double c = 1.0D;
  private double d = 1.0D;
  private double e;
  
  public Stretch(ItemStatus paramItemStatus, Drawable paramDrawable, double paramDouble)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus = paramItemStatus;
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.e = paramDouble;
  }
  
  private double a(long paramLong1, long paramLong2)
  {
    if (Math.abs(this.d - this.b) < 0.01D) {
      return this.b;
    }
    paramLong1 -= paramLong2;
    double d1 = this.d;
    double d2 = this.b;
    double d3;
    if (d1 < d2)
    {
      d3 = paramLong1 * 2L;
      Double.isNaN(d3);
      this.d = (d1 + d3 / 1000.0D);
      this.d = Math.min(d2, this.d);
    }
    else
    {
      d3 = paramLong1 * 2L;
      Double.isNaN(d3);
      this.d = (d1 - d3 / 1000.0D);
      this.d = Math.max(d2, this.d);
    }
    return this.d;
  }
  
  private void a()
  {
    this.jdField_a_of_type_Double = 1.0D;
    this.b = 1.0D;
  }
  
  private double b(long paramLong1, long paramLong2)
  {
    if (Math.abs(this.c - this.jdField_a_of_type_Double) < 0.01D) {
      return this.jdField_a_of_type_Double;
    }
    paramLong1 -= paramLong2;
    double d1 = this.c;
    double d2 = this.jdField_a_of_type_Double;
    double d3;
    if (d1 < d2)
    {
      d3 = paramLong1 * 2L;
      Double.isNaN(d3);
      this.c = (d1 + d3 / 1000.0D);
      this.c = Math.min(d2, this.c);
    }
    else
    {
      d3 = paramLong1 * 2L;
      Double.isNaN(d3);
      this.c = (d1 - d3 / 1000.0D);
      this.c = Math.max(d2, this.c);
    }
    return this.c;
  }
  
  protected int a(int paramInt)
  {
    if (((paramInt & 0x1) > 0) && (Math.abs(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus$Velocity.jdField_a_of_type_Double) > 100.0D)) {
      j = 1;
    } else {
      j = 0;
    }
    int i = j;
    if ((paramInt & 0x2) > 0)
    {
      i = j;
      if (Math.abs(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus$Velocity.jdField_a_of_type_Double) > 100.0D) {
        i = j | 0x2;
      }
    }
    int j = i;
    if ((paramInt & 0x4) > 0)
    {
      j = i;
      if (Math.abs(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus$Velocity.b) > 100.0D) {
        j = i | 0x4;
      }
    }
    i = j;
    if ((paramInt & 0x8) > 0)
    {
      i = j;
      if (Math.abs(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus$Velocity.b) > 100.0D) {
        i = j | 0x8;
      }
    }
    return i;
  }
  
  protected void a(double paramDouble1, double paramDouble2)
  {
    double d2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_AndroidGraphicsRectF.centerX();
    double d1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_AndroidGraphicsRectF.centerY();
    double d5 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
    double d6 = this.e;
    Double.isNaN(d5);
    double d3 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
    double d4 = this.e;
    Double.isNaN(d3);
    RectF localRectF = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_AndroidGraphicsRectF;
    paramDouble1 = d5 * d6 * paramDouble1 / 2.0D;
    Double.isNaN(d2);
    localRectF.left = ((float)(d2 - paramDouble1));
    localRectF = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_AndroidGraphicsRectF;
    Double.isNaN(d2);
    localRectF.right = ((float)(d2 + paramDouble1));
    localRectF = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_AndroidGraphicsRectF;
    paramDouble1 = d3 * d4 * paramDouble2 / 2.0D;
    Double.isNaN(d1);
    localRectF.top = ((float)(d1 - paramDouble1));
    localRectF = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_AndroidGraphicsRectF;
    Double.isNaN(d1);
    localRectF.bottom = ((float)(d1 + paramDouble1));
  }
  
  protected void a(int paramInt, long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Double = 1.0D;
    this.b = 1.0D;
    if (((paramInt & 0x1) > 0) || ((paramInt & 0x2) > 0)) {
      this.jdField_a_of_type_Double = Math.max(0.8D, 1.0D - Math.abs(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus$Velocity.jdField_a_of_type_Double) * 0.0003D);
    }
    if (((paramInt & 0x4) > 0) || ((paramInt & 0x8) > 0)) {
      this.b = Math.max(0.8D, 1.0D - Math.abs(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus$Velocity.b) * 0.0003D);
    }
  }
  
  protected void a(long paramLong1, long paramLong2)
  {
    if (paramLong1 - this.jdField_a_of_type_Long > 170L) {
      a();
    }
    this.c = b(paramLong1, paramLong2);
    this.d = a(paramLong1, paramLong2);
    a(this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.item.Stretch
 * JD-Core Version:    0.7.0.1
 */
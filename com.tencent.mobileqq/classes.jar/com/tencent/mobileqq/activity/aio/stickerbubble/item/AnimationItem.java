package com.tencent.mobileqq.activity.aio.stickerbubble.item;

import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

public class AnimationItem
{
  private double jdField_a_of_type_Double;
  private long jdField_a_of_type_Long;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private Drawable jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  private AnimationItem.ItemAnimationCallback jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemAnimationItem$ItemAnimationCallback;
  private Collision jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemCollision;
  private ItemStatus jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus;
  private Stretch jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemStretch;
  private String jdField_a_of_type_JavaLangString;
  private long jdField_b_of_type_Long = 0L;
  private Rect jdField_b_of_type_AndroidGraphicsRect;
  
  public AnimationItem(Drawable paramDrawable, Point paramPoint, ItemStatus.Velocity paramVelocity, ItemStatus.Acceleration paramAcceleration, long paramLong, double paramDouble, boolean paramBoolean, String paramString, int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Double = paramDouble;
    this.jdField_a_of_type_Long = paramLong;
    paramDouble = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
    double d1 = this.jdField_a_of_type_Double;
    Double.isNaN(paramDouble);
    double d2 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
    double d3 = this.jdField_a_of_type_Double;
    Double.isNaN(d2);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus = new ItemStatus();
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.a(paramPoint, paramDouble * d1, d2 * d3, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus$Velocity.a(paramVelocity);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus$Acceleration.a(paramAcceleration);
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_Int = 3;
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemCollision = new Collision(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemStretch = new Stretch(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus, this.jdField_a_of_type_AndroidGraphicsDrawableDrawable, this.jdField_a_of_type_Double);
  }
  
  private double a(double paramDouble1, double paramDouble2, double paramDouble3)
  {
    return (paramDouble1 * 2.0D + paramDouble2 * paramDouble3) / 2.0D * paramDouble3;
  }
  
  private int a(long paramLong)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_Int == 2)
    {
      paramLong = paramLong - this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_Long - 2000L;
      if (paramLong > 0L)
      {
        if (paramLong > 700L)
        {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_Int = 1;
          return 0;
        }
        return (int)(255L - paramLong * 255L / 700L);
      }
    }
    return 255;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_AndroidGraphicsRectF.left < this.jdField_a_of_type_AndroidGraphicsRect.left) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_AndroidGraphicsRectF.offset(this.jdField_a_of_type_AndroidGraphicsRect.left - this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_AndroidGraphicsRectF.left, 0.0F);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_AndroidGraphicsRectF.right > this.jdField_a_of_type_AndroidGraphicsRect.right) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_AndroidGraphicsRectF.offset(this.jdField_a_of_type_AndroidGraphicsRect.right - this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_AndroidGraphicsRectF.right, 0.0F);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_AndroidGraphicsRectF.top < this.jdField_a_of_type_AndroidGraphicsRect.top) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_AndroidGraphicsRectF.offset(0.0F, this.jdField_a_of_type_AndroidGraphicsRect.top - this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_AndroidGraphicsRectF.top);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_AndroidGraphicsRectF.bottom > this.jdField_a_of_type_AndroidGraphicsRect.bottom) {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_AndroidGraphicsRectF.offset(0.0F, this.jdField_a_of_type_AndroidGraphicsRect.bottom - this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_AndroidGraphicsRectF.bottom);
    }
  }
  
  private void a(long paramLong)
  {
    long l = this.jdField_b_of_type_Long;
    if (l > 0L)
    {
      paramLong -= l;
      double d1 = 1.0D;
      double d2;
      if (paramLong > 500L)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_Int = 0;
        d2 = 1.0D;
      }
      else if (paramLong < 100L)
      {
        d2 = paramLong;
        Double.isNaN(d2);
        d1 = d2 * 1.0D / 100.0D;
        Double.isNaN(d2);
        d2 = 1.0D + d2 * 0.4D / 100.0D;
        d1 += 1.0D;
      }
      else
      {
        double d3;
        if (paramLong < 200L)
        {
          d2 = paramLong - 100L;
          Double.isNaN(d2);
          d1 = 2.0D + -0.4D * d2 / 100.0D;
          Double.isNaN(d2);
          d3 = d2 * -0.6D / 100.0D;
          d2 = 1.4D;
        }
        for (;;)
        {
          d2 = d3 + d2;
          break label321;
          if (paramLong < 300L)
          {
            d2 = paramLong - 200L;
            Double.isNaN(d2);
            d1 = -0.6D * d2 / 100.0D + 1.6D;
            Double.isNaN(d2);
            d3 = d2 * 0.5D / 100.0D;
            d2 = 0.8D;
          }
          else
          {
            if (paramLong >= 400L) {
              break;
            }
            d2 = paramLong - 300L;
            Double.isNaN(d2);
            d1 = 1.0D + 0.2D * d2 / 100.0D;
            Double.isNaN(d2);
            d3 = d2 * -0.3D / 100.0D;
            d2 = 1.3D;
          }
        }
        d1 = paramLong - 400L;
        Double.isNaN(d1);
        d1 = d1 * -0.2D / 100.0D;
        d2 = 1.0D;
        d1 += 1.2D;
      }
      label321:
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemStretch.a(d1, d2);
      a();
    }
  }
  
  private void b(long paramLong)
  {
    double d1 = paramLong - this.jdField_a_of_type_Long;
    Double.isNaN(d1);
    double d3 = d1 / 1000.0D;
    d1 = a(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus$Velocity.jdField_a_of_type_Double, this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus$Acceleration.jdField_a_of_type_Double, d3);
    double d2 = a(this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus$Velocity.b, this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus$Acceleration.b, d3);
    ItemStatus.Velocity localVelocity = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus$Velocity;
    localVelocity.jdField_a_of_type_Double += this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus$Acceleration.jdField_a_of_type_Double * d3;
    localVelocity = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus$Velocity;
    localVelocity.b += this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus$Acceleration.b * d3;
    d3 *= 0.0D;
    double d4 = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus$Velocity.jdField_a_of_type_Double;
    double d5 = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus$Velocity.b;
    localVelocity = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus$Velocity;
    localVelocity.jdField_a_of_type_Double += d4 * d3;
    localVelocity = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus$Velocity;
    localVelocity.b += d3 * d5;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_AndroidGraphicsRectF.offset((float)d1, (float)d2);
  }
  
  private void b(Canvas paramCanvas)
  {
    float f;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_Double > 0.0D)
    {
      double d1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_AndroidGraphicsRectF.left;
      double d2 = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_Double;
      Double.isNaN(d1);
      double d3 = this.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight();
      Double.isNaN(d3);
      f = (float)((d1 - d2) * 360.0D / (d3 * 3.141592653589793D * this.jdField_a_of_type_Double));
    }
    else
    {
      f = 0.0F;
    }
    paramCanvas.rotate(f, this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_AndroidGraphicsRectF.centerX(), this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_AndroidGraphicsRectF.centerY());
  }
  
  public long a()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_AndroidGraphicsRect == null)
    {
      this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
      this.jdField_a_of_type_AndroidGraphicsRect.set(0, 0, paramCanvas.getWidth(), paramCanvas.getHeight());
    }
    if (this.jdField_b_of_type_AndroidGraphicsRect == null) {
      this.jdField_b_of_type_AndroidGraphicsRect = new Rect();
    }
  }
  
  public void a(Canvas paramCanvas, long paramLong, Drawable paramDrawable)
  {
    a(paramCanvas);
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_Int == 3) {
      a(paramLong);
    } else {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemStretch.a(paramLong, this.jdField_a_of_type_Long);
    }
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_Int != 1)
    {
      b(paramLong);
      i = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemCollision.a(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_AndroidGraphicsRectF);
      if (i != 0)
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemCollision.a(this.jdField_a_of_type_AndroidGraphicsRect, paramLong);
        i = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemStretch.a(i);
        if ((i != 0) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_Int != 2) && (this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_Int != 3)) {
          this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemStretch.a(i, paramLong);
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_Int != 1)
    {
      i = paramCanvas.save();
      b(paramCanvas);
      int j = a(paramLong);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemItemStatus.jdField_a_of_type_AndroidGraphicsRectF.round(this.jdField_b_of_type_AndroidGraphicsRect);
      paramDrawable.setAlpha(j);
      paramDrawable.setBounds(this.jdField_b_of_type_AndroidGraphicsRect);
      paramDrawable.draw(paramCanvas);
      paramCanvas.restoreToCount(i);
    }
    else
    {
      paramCanvas = this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemAnimationItem$ItemAnimationCallback;
      if (paramCanvas != null) {
        paramCanvas.a(this);
      }
    }
    this.jdField_a_of_type_Long = paramLong;
    if (this.jdField_b_of_type_Long == 0L) {
      this.jdField_b_of_type_Long = paramLong;
    }
  }
  
  public void a(AnimationItem.ItemAnimationCallback paramItemAnimationCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityAioStickerbubbleItemAnimationItem$ItemAnimationCallback = paramItemAnimationCallback;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.item.AnimationItem
 * JD-Core Version:    0.7.0.1
 */
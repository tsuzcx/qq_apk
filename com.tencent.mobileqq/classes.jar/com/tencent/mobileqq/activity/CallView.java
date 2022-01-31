package com.tencent.mobileqq.activity;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.SystemClock;
import android.view.View;

public class CallView
  extends View
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long = 0L;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private volatile boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int = 4;
  private long jdField_b_of_type_Long = 150L;
  
  public CallView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_Int = -65536;
  }
  
  private void a(Canvas paramCanvas)
  {
    float f1 = getMeasuredWidth() - this.jdField_b_of_type_Int;
    float f2 = getMeasuredHeight() - this.jdField_b_of_type_Int;
    this.jdField_a_of_type_AndroidGraphicsRectF.left = (-f1 / 3.0F);
    this.jdField_a_of_type_AndroidGraphicsRectF.top = (2.0F * f2 / 3.0F);
    this.jdField_a_of_type_AndroidGraphicsRectF.right = (f1 / 3.0F);
    this.jdField_a_of_type_AndroidGraphicsRectF.bottom = (f2 * 4.0F / 3.0F);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
    paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, -100.0F, 100.0F, false, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  private void b(Canvas paramCanvas)
  {
    float f1 = getMeasuredWidth() - this.jdField_b_of_type_Int;
    float f2 = getMeasuredHeight() - this.jdField_b_of_type_Int;
    this.jdField_a_of_type_AndroidGraphicsRectF.left = (-f1 * 2.0F / 3.0F);
    this.jdField_a_of_type_AndroidGraphicsRectF.top = (f2 / 3.0F);
    this.jdField_a_of_type_AndroidGraphicsRectF.right = (f1 * 2.0F / 3.0F);
    this.jdField_a_of_type_AndroidGraphicsRectF.bottom = (f2 * 5.0F / 3.0F);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
    paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, -100.0F, 100.0F, false, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  private void c(Canvas paramCanvas)
  {
    float f1 = getMeasuredWidth() - this.jdField_b_of_type_Int;
    float f2 = getMeasuredHeight();
    float f3 = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_AndroidGraphicsRectF.left = (-f1);
    this.jdField_a_of_type_AndroidGraphicsRectF.top = this.jdField_b_of_type_Int;
    this.jdField_a_of_type_AndroidGraphicsRectF.right = f1;
    this.jdField_a_of_type_AndroidGraphicsRectF.bottom = ((f2 - f3) * 2.0F);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
    paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, -100.0F, 100.0F, false, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_Boolean)
    {
      if (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long <= this.jdField_b_of_type_Long * 6L) {
        break label47;
      }
      this.jdField_a_of_type_Long = SystemClock.uptimeMillis();
    }
    for (;;)
    {
      postInvalidateDelayed(150L);
      return;
      label47:
      if (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long > this.jdField_b_of_type_Long * 5L)
      {
        a(paramCanvas);
      }
      else if (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long > this.jdField_b_of_type_Long * 4L)
      {
        a(paramCanvas);
        b(paramCanvas);
      }
      else if (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long > this.jdField_b_of_type_Long * 3L)
      {
        a(paramCanvas);
        b(paramCanvas);
        c(paramCanvas);
      }
      else if (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long > this.jdField_b_of_type_Long * 2L)
      {
        a(paramCanvas);
        b(paramCanvas);
      }
      else if (SystemClock.uptimeMillis() - this.jdField_a_of_type_Long > this.jdField_b_of_type_Long)
      {
        a(paramCanvas);
      }
    }
  }
  
  public void setColor(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.CallView
 * JD-Core Version:    0.7.0.1
 */
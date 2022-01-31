package com.tencent.biz.pubaccount.readinjoy.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class RoundAngleFrameLayout
  extends FrameLayout
{
  private float jdField_a_of_type_Float;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private float jdField_b_of_type_Float;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private float c;
  private float d;
  
  public RoundAngleFrameLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RoundAngleFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RoundAngleFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setXfermode(null);
  }
  
  private void a(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Float > 0.0F)
    {
      Path localPath = new Path();
      localPath.moveTo(0.0F, this.jdField_a_of_type_Float);
      localPath.lineTo(0.0F, 0.0F);
      localPath.lineTo(this.jdField_a_of_type_Float, 0.0F);
      localPath.arcTo(new RectF(0.0F, 0.0F, this.jdField_a_of_type_Float * 2.0F, this.jdField_a_of_type_Float * 2.0F), -90.0F, -90.0F);
      localPath.close();
      paramCanvas.drawPath(localPath, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  private void b(Canvas paramCanvas)
  {
    if (this.jdField_b_of_type_Float > 0.0F)
    {
      int i = getWidth();
      Path localPath = new Path();
      localPath.moveTo(i - this.jdField_b_of_type_Float, 0.0F);
      localPath.lineTo(i, 0.0F);
      localPath.lineTo(i, this.jdField_b_of_type_Float);
      localPath.arcTo(new RectF(i - this.jdField_b_of_type_Float * 2.0F, 0.0F, i, this.jdField_b_of_type_Float * 2.0F), 0.0F, -90.0F);
      localPath.close();
      paramCanvas.drawPath(localPath, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  private void c(Canvas paramCanvas)
  {
    if (this.c > 0.0F)
    {
      int i = getHeight();
      Path localPath = new Path();
      localPath.moveTo(0.0F, i - this.c);
      localPath.lineTo(0.0F, i);
      localPath.lineTo(this.c, i);
      localPath.arcTo(new RectF(0.0F, i - this.c * 2.0F, this.c * 2.0F, i), 90.0F, 90.0F);
      localPath.close();
      paramCanvas.drawPath(localPath, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  private void d(Canvas paramCanvas)
  {
    if (this.d > 0.0F)
    {
      int i = getHeight();
      int j = getWidth();
      Path localPath = new Path();
      localPath.moveTo(j - this.d, i);
      localPath.lineTo(j, i);
      localPath.lineTo(j, i - this.d);
      localPath.arcTo(new RectF(j - this.d * 2.0F, i - this.d * 2.0F, j, i), 0.0F, 90.0F);
      localPath.close();
      paramCanvas.drawPath(localPath, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  protected void dispatchDraw(Canvas paramCanvas)
  {
    paramCanvas.saveLayer(new RectF(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight()), this.jdField_b_of_type_AndroidGraphicsPaint, 31);
    super.dispatchDraw(paramCanvas);
    a(paramCanvas);
    b(paramCanvas);
    c(paramCanvas);
    d(paramCanvas);
    paramCanvas.restore();
  }
  
  public void setRaduis(int paramInt)
  {
    this.jdField_a_of_type_Float = paramInt;
    this.jdField_b_of_type_Float = paramInt;
    this.c = paramInt;
    this.d = paramInt;
  }
  
  public void setRaduis(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_Float = paramInt1;
    this.jdField_b_of_type_Float = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.RoundAngleFrameLayout
 * JD-Core Version:    0.7.0.1
 */
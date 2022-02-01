package com.tencent.biz.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class TriangleView
  extends View
{
  Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  Path jdField_a_of_type_AndroidGraphicsPath;
  Paint b;
  
  public TriangleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.b = new Paint();
    this.b.setColor(-2170912);
    this.b.setStrokeWidth(2.0F);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = getMeasuredHeight();
    Path localPath = this.jdField_a_of_type_AndroidGraphicsPath;
    float f1 = i + 150;
    localPath.moveTo(f1, 0.0F);
    localPath = this.jdField_a_of_type_AndroidGraphicsPath;
    float f2 = '';
    float f3 = i;
    localPath.lineTo(f2, f3);
    localPath = this.jdField_a_of_type_AndroidGraphicsPath;
    float f4 = i * 2 + 150;
    localPath.lineTo(f4, f3);
    this.jdField_a_of_type_AndroidGraphicsPath.close();
    paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.b.setStrokeWidth(1.0F);
    paramCanvas.drawLine(f1, 0.0F, f2, f3, this.b);
    paramCanvas.drawLine(f1, 0.0F, f4, f3, this.b);
    this.b.setStrokeWidth(2.0F);
    paramCanvas.drawLine(0.0F, f3, f2, f3, this.b);
    paramCanvas.drawLine(f4, f3, getMeasuredWidth(), f3, this.b);
  }
  
  public void setColor(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.widgets.TriangleView
 * JD-Core Version:    0.7.0.1
 */
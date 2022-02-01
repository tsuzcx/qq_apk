package com.tencent.aelight.camera.aioeditor.takevideo.speedpicker;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

public class PickerBack
{
  private float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int = 0;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private float b = 0.0F;
  private float c = 1.0F;
  
  public void a() {}
  
  public void a(int paramInt, float paramFloat1, float paramFloat2)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Float = paramFloat1;
    this.b = paramFloat2;
    if (this.jdField_a_of_type_AndroidGraphicsPaint == null)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
  }
  
  public void a(Canvas paramCanvas, int paramInt)
  {
    if (paramCanvas == null) {
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt);
    float f2 = this.jdField_a_of_type_AndroidGraphicsRectF.width() - this.jdField_a_of_type_Float - this.b;
    float f1 = this.c * f2;
    paramCanvas.save();
    RectF localRectF = new RectF(this.jdField_a_of_type_AndroidGraphicsRectF.left + this.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidGraphicsRectF.top, this.jdField_a_of_type_AndroidGraphicsRectF.left + this.jdField_a_of_type_Float + f2, this.jdField_a_of_type_AndroidGraphicsRectF.top + f1);
    f2 = localRectF.left;
    float f3 = localRectF.top;
    float f4 = localRectF.right;
    float f5 = localRectF.top;
    float f6 = f1 / 2.0F;
    paramCanvas.clipRect(f2, f3, f4, f5 + f6);
    paramCanvas.drawOval(localRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.restore();
    paramCanvas.save();
    localRectF.top = (this.jdField_a_of_type_AndroidGraphicsRectF.bottom - f1);
    localRectF.bottom = this.jdField_a_of_type_AndroidGraphicsRectF.bottom;
    paramCanvas.clipRect(localRectF.left, localRectF.top + f6, localRectF.right, localRectF.bottom);
    paramCanvas.drawOval(localRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.restore();
    localRectF.top = Math.round(this.jdField_a_of_type_AndroidGraphicsRectF.top + f6);
    localRectF.bottom = Math.round(this.jdField_a_of_type_AndroidGraphicsRectF.bottom - f6);
    paramCanvas.drawRect(localRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  public void a(RectF paramRectF)
  {
    this.jdField_a_of_type_AndroidGraphicsRectF.set(paramRectF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.PickerBack
 * JD-Core Version:    0.7.0.1
 */
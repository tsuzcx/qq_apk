package com.tencent.aelight.camera.aioeditor.takevideo.speedpicker;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

public class PickerFore
{
  private float jdField_a_of_type_Float = 0.0F;
  private int jdField_a_of_type_Int = -1;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  private float jdField_b_of_type_Float = 0.0F;
  private int jdField_b_of_type_Int = 6;
  private float c = 0.0F;
  
  public int a(float paramFloat)
  {
    if (!this.jdField_a_of_type_AndroidGraphicsRectF.isEmpty())
    {
      float f4 = this.jdField_a_of_type_AndroidGraphicsRectF.height() / (this.jdField_b_of_type_Int + 1);
      int i = 0;
      float f2 = 0.0F;
      float f1 = 0.0F;
      float f3;
      for (;;)
      {
        f3 = f1;
        if (i >= this.jdField_b_of_type_Int) {
          break;
        }
        f1 = i * f4 + f4 + this.jdField_a_of_type_AndroidGraphicsRectF.top;
        f3 = f1;
        if (paramFloat <= f1) {
          break;
        }
        i += 1;
        f2 = f1;
      }
      int j = this.jdField_b_of_type_Int;
      if (i == j) {
        return j - 1;
      }
      if (i == 0) {
        return 0;
      }
      if (paramFloat - f2 > f3 - paramFloat) {
        return i;
      }
      return i - 1;
    }
    return 0;
  }
  
  public RectF a(int paramInt)
  {
    if (paramInt >= 0)
    {
      if (paramInt >= this.jdField_b_of_type_Int) {
        return null;
      }
      if (this.jdField_a_of_type_AndroidGraphicsRectF.isEmpty()) {
        return null;
      }
      float f2 = this.jdField_a_of_type_AndroidGraphicsRectF.height() / (this.jdField_b_of_type_Int + 1);
      float f1 = this.jdField_a_of_type_AndroidGraphicsRectF.width() / 2.0F;
      f2 = f2 + paramInt * f2 + this.jdField_a_of_type_AndroidGraphicsRectF.top;
      float f3 = this.c;
      return new RectF(f1 - f3, f2 - f3, f1 + f3, f2 + f3);
    }
    return null;
  }
  
  public void a() {}
  
  public void a(Canvas paramCanvas, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramCanvas == null) {
      return;
    }
    float f2 = this.jdField_a_of_type_AndroidGraphicsRectF.width();
    float f3 = this.jdField_b_of_type_Float;
    float f4 = this.jdField_a_of_type_Float;
    float f1 = this.jdField_a_of_type_AndroidGraphicsRectF.height() / (this.jdField_b_of_type_Int + 1);
    f2 = (f2 - f3 - f4) / 2.0F + this.jdField_a_of_type_Float;
    int i = 0;
    while (i < this.jdField_b_of_type_Int)
    {
      f3 = i * f1 + f1 + this.jdField_a_of_type_AndroidGraphicsRectF.top;
      if ((i != this.jdField_b_of_type_Int - 1) || (i != paramInt2))
      {
        int j;
        if (i == this.jdField_b_of_type_Int - 1)
        {
          j = this.jdField_a_of_type_AndroidGraphicsPaint.getAlpha();
          this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt1);
          paramCanvas.drawCircle(f2, f3, this.c, this.jdField_a_of_type_AndroidGraphicsPaint);
          this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(j);
        }
        else if (i == paramInt2)
        {
          j = this.jdField_a_of_type_AndroidGraphicsPaint.getAlpha();
          this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt3);
          paramCanvas.drawCircle(f2, f3, this.c, this.jdField_a_of_type_AndroidGraphicsPaint);
          this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(j);
        }
        else
        {
          j = this.jdField_a_of_type_AndroidGraphicsPaint.getAlpha();
          this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(paramInt4);
          paramCanvas.drawCircle(f2, f3, this.c, this.jdField_a_of_type_AndroidGraphicsPaint);
          this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(j);
        }
      }
      i += 1;
    }
  }
  
  public void a(RectF paramRectF)
  {
    if (paramRectF != null) {
      this.jdField_a_of_type_AndroidGraphicsRectF.set(paramRectF);
    }
  }
  
  public boolean a(int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_a_of_type_Float = paramFloat2;
    this.jdField_b_of_type_Float = paramFloat3;
    this.jdField_a_of_type_Int = paramInt1;
    if (this.jdField_a_of_type_AndroidGraphicsPaint == null)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
    this.c = paramFloat1;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.speedpicker.PickerFore
 * JD-Core Version:    0.7.0.1
 */
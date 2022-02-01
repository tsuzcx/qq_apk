package com.tencent.aelight.camera.aioeditor.capture.text;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.text.TextPaint;

public class PerLineModel
  extends BaseTextModel
{
  protected float a;
  protected String a;
  
  public PerLineModel(int paramInt1, int paramInt2, TextPaint paramTextPaint, String paramString, RectF paramRectF, float paramFloat)
  {
    super(paramInt1, paramInt2, paramTextPaint, paramRectF);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(Canvas paramCanvas, int paramInt1, int paramInt2)
  {
    if (paramCanvas == null) {
      return;
    }
    String str = this.jdField_a_of_type_JavaLangString;
    paramCanvas.drawText(str, 0, str.length(), paramInt1 + this.jdField_a_of_type_AndroidGraphicsRectF.left, paramInt2 + this.jdField_a_of_type_Float + this.jdField_a_of_type_AndroidGraphicsRectF.top, this.jdField_a_of_type_AndroidTextTextPaint);
  }
  
  public void a(Canvas paramCanvas, BaseBackgroundDrawer paramBaseBackgroundDrawer, int paramInt1, int paramInt2)
  {
    paramBaseBackgroundDrawer.a(paramCanvas, this.jdField_a_of_type_AndroidGraphicsRectF, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.PerLineModel
 * JD-Core Version:    0.7.0.1
 */
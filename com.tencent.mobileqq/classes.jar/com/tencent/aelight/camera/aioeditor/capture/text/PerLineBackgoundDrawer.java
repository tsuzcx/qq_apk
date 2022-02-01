package com.tencent.aelight.camera.aioeditor.capture.text;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import java.util.ArrayList;

public class PerLineBackgoundDrawer
  extends BaseBackgroundDrawer
{
  private final int a;
  
  public PerLineBackgoundDrawer(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt1);
    this.jdField_a_of_type_Int = paramInt2;
  }
  
  public void a(Canvas paramCanvas, RectF paramRectF, int paramInt1, int paramInt2)
  {
    if (paramCanvas != null)
    {
      if (paramRectF == null) {
        return;
      }
      float f1 = paramRectF.left;
      float f2 = this.jdField_a_of_type_Int;
      float f3 = paramInt1;
      float f4 = paramRectF.top;
      float f5 = this.jdField_a_of_type_Int;
      float f6 = paramInt2;
      paramCanvas.drawRect(f1 - f2 + f3, f4 - f5 + f6, paramRectF.right + this.jdField_a_of_type_Int + f3, paramRectF.bottom + this.jdField_a_of_type_Int + f6, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  public void a(Canvas paramCanvas, ArrayList<PerLineModel> paramArrayList, int paramInt1, int paramInt2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.text.PerLineBackgoundDrawer
 * JD-Core Version:    0.7.0.1
 */
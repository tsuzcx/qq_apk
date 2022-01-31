package com.tencent.mobileqq.arcard;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class ARCardPageProcess$Circle
  extends View
{
  private float jdField_a_of_type_Float = ARCardPageProcess.a(ARCardPageProcess.a(this.jdField_a_of_type_ComTencentMobileqqArcardARCardPageProcess), 4.0F);
  private int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean;
  private float b = 1.0F;
  
  public ARCardPageProcess$Circle(ARCardPageProcess paramARCardPageProcess, Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  private void a()
  {
    setLayoutParams(new ViewGroup.LayoutParams(ARCardPageProcess.a(), ARCardPageProcess.a()));
    setClickable(false);
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt <= ARCardPageProcess.jdField_a_of_type_Int) || (paramInt >= ARCardPageProcess.jdField_a_of_type_Int * -1);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int j = getHeight() / 2;
    int k = getWidth() / 2;
    Paint localPaint = new Paint();
    localPaint.setAntiAlias(true);
    localPaint.setDither(true);
    localPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    int i;
    float f1;
    label88:
    float f2;
    if (this.jdField_a_of_type_Int != 0)
    {
      i = Math.abs(this.jdField_a_of_type_Int) - 1;
      if ((i < 0) || (i >= ARCardPageProcess.jdField_a_of_type_Int)) {
        break label138;
      }
      f1 = ARCardPageProcess.jdField_a_of_type_ArrayOfFloat[i];
      this.b = f1;
      f1 = this.jdField_a_of_type_Float;
      f2 = this.b;
      if (!this.jdField_a_of_type_Boolean) {
        break label143;
      }
      localPaint.setColor(-1);
    }
    for (;;)
    {
      paramCanvas.drawCircle(j, k, f1 * f2, localPaint);
      return;
      i = -1;
      break;
      label138:
      f1 = 1.0F;
      break label88;
      label143:
      localPaint.setColor(Color.argb(127, 255, 255, 255));
    }
  }
  
  public void setChecked(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    invalidate();
  }
  
  public void setCircleRadius(float paramFloat)
  {
    this.jdField_a_of_type_Float = ARCardPageProcess.a(ARCardPageProcess.a(this.jdField_a_of_type_ComTencentMobileqqArcardARCardPageProcess), paramFloat);
    invalidate();
  }
  
  public void setScarleType(int paramInt)
  {
    if (a(paramInt)) {
      this.jdField_a_of_type_Int = paramInt;
    }
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.arcard.ARCardPageProcess.Circle
 * JD-Core Version:    0.7.0.1
 */
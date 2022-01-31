package com.tencent.mobileqq.apollo.lightGame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import mww;

public class DotPollingView
  extends View
{
  float jdField_a_of_type_Float = this.e;
  int jdField_a_of_type_Int = 0;
  private Context jdField_a_of_type_AndroidContentContext;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private final String jdField_a_of_type_JavaLangString = "DotPollingView";
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private Paint jdField_b_of_type_AndroidGraphicsPaint = new Paint();
  private int c;
  private int d = 3;
  private int e;
  private int f;
  private int g;
  private int h;
  
  public DotPollingView(Context paramContext)
  {
    this(paramContext, null);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  public DotPollingView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  public DotPollingView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    a();
  }
  
  private void a()
  {
    this.jdField_b_of_type_Int = -16777216;
    this.c = -16777216;
    this.e = ((int)mww.a(this.jdField_a_of_type_AndroidContentContext, 2.5F));
    this.f = ((int)mww.a(this.jdField_a_of_type_AndroidContentContext, 4.5F));
    this.g = ((int)mww.a(this.jdField_a_of_type_AndroidContentContext, 10.0F));
    this.d = 3;
    this.jdField_b_of_type_Float = 0.3F;
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.c);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.jdField_b_of_type_Int);
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.jdField_a_of_type_Float += this.jdField_b_of_type_Float;
    if (this.jdField_a_of_type_Float >= this.f)
    {
      i = this.jdField_a_of_type_Int + 1;
      this.jdField_a_of_type_Int = i;
      this.h = (i % 3);
      this.jdField_a_of_type_Float = this.e;
    }
    this.jdField_b_of_type_AndroidGraphicsPaint.setAlpha(76);
    int i = (int)(76.5D + 178.5D * ((this.jdField_a_of_type_Float - this.e) / (this.f - this.e)));
    this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha(i);
    i = getWidth() / 2;
    int j = (this.d * this.e * 2 + (this.d - 1) * this.g) / 2;
    j = this.e + (i - j);
    int k = getHeight() / 2;
    i = 0;
    if (i < this.d)
    {
      if (this.h == i) {
        paramCanvas.drawCircle(this.h * (this.e * 2 + this.g) + j, k, this.jdField_a_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      for (;;)
      {
        i += 1;
        break;
        paramCanvas.drawCircle((this.e * 2 + this.g) * i + j, k, this.e, this.jdField_b_of_type_AndroidGraphicsPaint);
      }
    }
    invalidate();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int m = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt1);
    int k = View.MeasureSpec.getMode(paramInt2);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    if (m == 1073741824)
    {
      paramInt1 = i;
      if (k != 1073741824) {
        break label102;
      }
    }
    for (;;)
    {
      setMeasuredDimension(paramInt1, paramInt2);
      return;
      int j = this.d * this.e * 2 + (this.d - 1) * this.g + (this.f - this.e) * 2;
      paramInt1 = j;
      if (m != -2147483648) {
        break;
      }
      paramInt1 = Math.min(j, i);
      break;
      label102:
      i = this.f * 2;
      if (k == -2147483648) {
        paramInt2 = Math.min(i, paramInt2);
      } else {
        paramInt2 = i;
      }
    }
  }
  
  public void setColor(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.lightGame.DotPollingView
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.qqui.R.styleable;

public class VolumeChangeView
  extends View
{
  private int jdField_a_of_type_Int = 0;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private boolean jdField_a_of_type_Boolean = true;
  public int[] a;
  private int b = 0;
  private int c = 0;
  private int d = 0;
  private int e = 0;
  private int f = 0;
  private int g = 0;
  private int h = 0;
  private int i = 0;
  
  public VolumeChangeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.bU);
    a(paramContext);
    paramContext.recycle();
  }
  
  private void a(TypedArray paramTypedArray)
  {
    int j = R.styleable.cn;
    boolean bool = false;
    if (paramTypedArray.getInt(j, 0) == 0) {
      bool = true;
    }
    this.jdField_a_of_type_Boolean = bool;
    this.jdField_a_of_type_Int = paramTypedArray.getInt(R.styleable.co, 5);
    this.b = ((int)paramTypedArray.getDimension(R.styleable.cq, 8.0F));
    this.c = ((int)paramTypedArray.getDimension(R.styleable.cp, 48.0F));
    this.d = getResources().getColor(2131167048);
    this.h = getResources().getColor(2131167047);
    this.i = getResources().getDimensionPixelOffset(2131299276);
    this.jdField_a_of_type_ArrayOfInt = new int[this.jdField_a_of_type_Int];
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ArrayOfInt != null)
    {
      int j = 0;
      for (;;)
      {
        int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
        if (j >= arrayOfInt.length) {
          break;
        }
        arrayOfInt[j] = 0;
        j += 1;
      }
      this.e = 0;
    }
    invalidate();
  }
  
  public void a(int paramInt)
  {
    this.g = paramInt;
    if (this.g < 1) {
      this.g = 1;
    }
    if (this.g > 10) {
      this.g = 10;
    }
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int j = 0;
    while (j < this.jdField_a_of_type_Int)
    {
      boolean bool = this.jdField_a_of_type_Boolean;
      float f1 = 0.0F;
      if (bool)
      {
        if (j < this.g) {
          this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.h);
        } else {
          this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.d);
        }
        if (j == 0) {
          break label156;
        }
        k = (this.i + this.b) * j;
      }
      else
      {
        if (j < this.g) {
          this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.h);
        } else {
          this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.d);
        }
        k = this.jdField_a_of_type_Int;
        if (j == k - 1) {
          break label156;
        }
        k = (k - 1 - j) * (this.i + this.b);
      }
      f1 = k;
      label156:
      int k = this.f;
      int m = this.c;
      paramCanvas.drawRect(f1, k - m / 2, f1 + this.b, k + m / 2, this.jdField_a_of_type_AndroidGraphicsPaint);
      j += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt1 = this.jdField_a_of_type_Int;
    paramInt2 = this.b;
    int j = this.i;
    int k = this.c;
    setMeasuredDimension(paramInt1 * (paramInt2 + j) + getPaddingLeft() + getPaddingRight(), k + getPaddingTop() + getPaddingBottom());
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.f = (paramInt2 / 2);
    if (this.jdField_a_of_type_AndroidGraphicsPaint == null)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.d);
    }
    invalidate();
  }
  
  public void setColor(int paramInt)
  {
    this.h = paramInt;
    Paint localPaint = this.jdField_a_of_type_AndroidGraphicsPaint;
    if (localPaint != null) {
      localPaint.setColor(this.h);
    }
  }
  
  public void setCount(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_ArrayOfInt = new int[this.jdField_a_of_type_Int];
    requestLayout();
  }
  
  public void setSquareWidth(int paramInt)
  {
    this.b = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.VolumeChangeView
 * JD-Core Version:    0.7.0.1
 */
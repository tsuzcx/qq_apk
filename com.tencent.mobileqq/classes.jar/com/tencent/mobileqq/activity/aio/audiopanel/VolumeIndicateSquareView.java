package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.qqui.R.styleable;

public class VolumeIndicateSquareView
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
  
  public VolumeIndicateSquareView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.bU);
    a(paramContext);
    paramContext.recycle();
  }
  
  private void a(TypedArray paramTypedArray)
  {
    int i = R.styleable.cn;
    boolean bool = false;
    if (paramTypedArray.getInt(i, 0) == 0) {
      bool = true;
    }
    this.jdField_a_of_type_Boolean = bool;
    this.jdField_a_of_type_Int = paramTypedArray.getInt(R.styleable.co, 5);
    this.b = ((int)paramTypedArray.getDimension(R.styleable.cq, 8.0F));
    this.c = paramTypedArray.getColor(R.styleable.cm, -16776961);
    this.jdField_a_of_type_ArrayOfInt = new int[this.jdField_a_of_type_Int];
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ArrayOfInt != null)
    {
      int i = 0;
      for (;;)
      {
        int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
        if (i >= arrayOfInt.length) {
          break;
        }
        arrayOfInt[i] = 0;
        i += 1;
      }
      this.d = 0;
    }
    invalidate();
  }
  
  public void a(int paramInt)
  {
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    int i = this.d;
    arrayOfInt[i] = paramInt;
    this.d = (i + 1);
    if (this.d >= this.jdField_a_of_type_Int) {
      this.d = 0;
    }
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = this.d - 1;
    int j = 0;
    for (;;)
    {
      int m = this.jdField_a_of_type_Int;
      if (j >= m) {
        break;
      }
      int k = i;
      if (i < 0) {
        k = m - 1;
      }
      float f2 = this.jdField_a_of_type_ArrayOfInt[k];
      float f1 = f2;
      if (f2 < 1.0F) {
        f1 = 1.0F;
      }
      f2 = f1;
      if (f1 > 8.0F) {
        f2 = 8.0F;
      }
      f1 = f2 / 2.0F;
      i = this.b;
      f2 = f1 * i;
      if (this.jdField_a_of_type_Boolean) {
        f1 = j * 2.0F * i;
      } else {
        f1 = (this.jdField_a_of_type_Int - 1 - j) * 2.0F * i + i;
      }
      i = this.e;
      paramCanvas.drawRect(f1, i - f2, f1 + this.b, i + f2, this.jdField_a_of_type_AndroidGraphicsPaint);
      i = k - 1;
      j += 1;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt1 = this.jdField_a_of_type_Int;
    paramInt2 = this.b;
    setMeasuredDimension(paramInt1 * 2 * paramInt2 + getPaddingLeft() + getPaddingRight(), paramInt2 * 8 + getPaddingTop() + getPaddingBottom());
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.e = (paramInt2 / 2);
    if (this.jdField_a_of_type_AndroidGraphicsPaint == null)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.c);
    }
    invalidate();
  }
  
  public void setColor(int paramInt)
  {
    this.c = paramInt;
    Paint localPaint = this.jdField_a_of_type_AndroidGraphicsPaint;
    if (localPaint != null) {
      localPaint.setColor(this.c);
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
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.VolumeIndicateSquareView
 * JD-Core Version:    0.7.0.1
 */
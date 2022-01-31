package com.tencent.mobileqq.activity.contacts.view;

import afsz;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mobileqq.R.styleable;

public class IndexBar
  extends View
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = -1;
  private afsz jdField_a_of_type_Afsz;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private boolean jdField_a_of_type_Boolean;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private float jdField_d_of_type_Float;
  private int jdField_d_of_type_Int;
  private int e;
  
  public IndexBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public IndexBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public IndexBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private int a(int paramInt1, int paramInt2)
  {
    int j = View.MeasureSpec.getMode(paramInt1);
    int i = View.MeasureSpec.getSize(paramInt1);
    if (j == 1073741824) {
      paramInt1 = i;
    }
    do
    {
      return paramInt1;
      paramInt1 = paramInt2;
    } while (j != -2147483648);
    return Math.min(paramInt2, i);
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_a_of_type_Float);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_b_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTypeface(Typeface.DEFAULT);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextAlign(Paint.Align.CENTER);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_a_of_type_Float);
    this.jdField_b_of_type_AndroidGraphicsPaint.setTypeface(Typeface.DEFAULT);
    this.jdField_b_of_type_AndroidGraphicsPaint.setTextAlign(Paint.Align.CENTER);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.jdField_c_of_type_Int);
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this.jdField_b_of_type_Int = paramContext.getResources().getColor(17170444);
    this.jdField_c_of_type_Int = paramContext.getResources().getColor(17170444);
    this.jdField_a_of_type_Float = paramContext.getResources().getDimensionPixelSize(2131297062);
    this.jdField_b_of_type_Float = paramContext.getResources().getDimensionPixelSize(2131297063);
    this.jdField_c_of_type_Float = paramContext.getResources().getDimension(2131297059);
    this.jdField_d_of_type_Float = paramContext.getResources().getDimension(2131297061);
    if (paramAttributeSet != null)
    {
      paramContext = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.IndexBar);
      this.jdField_b_of_type_Int = paramContext.getColor(2, this.jdField_b_of_type_Int);
      this.jdField_c_of_type_Int = paramContext.getColor(3, this.jdField_c_of_type_Int);
      this.jdField_a_of_type_Float = paramContext.getDimension(5, this.jdField_a_of_type_Float);
      this.jdField_b_of_type_Float = paramContext.getDimension(6, this.jdField_b_of_type_Float);
      this.jdField_c_of_type_Float = paramContext.getDimension(1, this.jdField_c_of_type_Float);
      this.jdField_d_of_type_Float = paramContext.getDimension(4, this.jdField_d_of_type_Float);
      paramContext.recycle();
    }
    a();
  }
  
  private void a(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_ArrayOfJavaLangString == null) {}
    int j;
    do
    {
      return;
      j = this.jdField_a_of_type_ArrayOfJavaLangString.length;
    } while (j <= 0);
    int k = this.e / j;
    int i = 0;
    label32:
    if (i < j) {
      if (i != this.jdField_a_of_type_Int) {
        break label114;
      }
    }
    label114:
    for (Paint localPaint = this.jdField_b_of_type_AndroidGraphicsPaint;; localPaint = this.jdField_a_of_type_AndroidGraphicsPaint)
    {
      float f1 = this.jdField_d_of_type_Int / 2;
      float f2 = (i + 1) * k;
      float f3 = localPaint.measureText(this.jdField_a_of_type_ArrayOfJavaLangString[i]) / 2.0F;
      paramCanvas.drawText(this.jdField_a_of_type_ArrayOfJavaLangString[i], f1, f2 - f3, localPaint);
      i += 1;
      break label32;
      break;
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    a(paramCanvas);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_d_of_type_Int = getWidth();
    this.e = getHeight();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 0;
    super.onMeasure(paramInt1, paramInt2);
    Rect localRect = new Rect();
    this.jdField_a_of_type_AndroidGraphicsPaint.getTextBounds("W", 0, 1, localRect);
    int j = localRect.width();
    int k = (int)this.jdField_d_of_type_Float;
    int i1 = localRect.height();
    int i2 = (int)this.jdField_d_of_type_Float;
    int m = getPaddingLeft();
    int n = getPaddingRight();
    if (this.jdField_a_of_type_ArrayOfJavaLangString == null) {}
    for (;;)
    {
      i1 = getPaddingTop();
      i2 = getPaddingBottom();
      setMeasuredDimension(a(paramInt1, j + k + m + n), a(paramInt2, i + i1 + i2));
      return;
      i = this.jdField_a_of_type_ArrayOfJavaLangString.length * (i1 + i2);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    int j = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getY();
    int k = this.jdField_a_of_type_Int;
    int i = -1;
    if (this.jdField_a_of_type_ArrayOfJavaLangString != null) {
      i = (int)(f1 / this.e * this.jdField_a_of_type_ArrayOfJavaLangString.length);
    }
    switch (j)
    {
    default: 
      bool = false;
    }
    do
    {
      return bool;
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_Afsz != null) {
        this.jdField_a_of_type_Afsz.c(false);
      }
      invalidate();
      return true;
      if (k != i)
      {
        if ((this.jdField_a_of_type_ArrayOfJavaLangString != null) && (i >= 0) && (i < this.jdField_a_of_type_ArrayOfJavaLangString.length))
        {
          this.jdField_a_of_type_Int = i;
          if (this.jdField_a_of_type_Afsz != null)
          {
            Rect localRect = new Rect();
            this.jdField_a_of_type_AndroidGraphicsPaint.getTextBounds(this.jdField_a_of_type_ArrayOfJavaLangString[this.jdField_a_of_type_Int], 0, this.jdField_a_of_type_ArrayOfJavaLangString[this.jdField_a_of_type_Int].length(), localRect);
            k = this.jdField_a_of_type_ArrayOfJavaLangString.length;
            f1 = this.e / k * (this.jdField_a_of_type_Int + 1);
            float f2 = this.jdField_a_of_type_AndroidGraphicsPaint.measureText(this.jdField_a_of_type_ArrayOfJavaLangString[this.jdField_a_of_type_Int]) / 2.0F;
            this.jdField_a_of_type_Afsz.a(this.jdField_a_of_type_ArrayOfJavaLangString[i], j, f1 - f2);
          }
        }
        invalidate();
      }
    } while (paramMotionEvent.getAction() != 0);
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Afsz != null) {
      this.jdField_a_of_type_Afsz.c(true);
    }
    invalidate();
    return true;
  }
  
  public void setChooseIndex(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    invalidate();
  }
  
  public void setLetters(String[] paramArrayOfString)
  {
    this.jdField_a_of_type_ArrayOfJavaLangString = paramArrayOfString;
    requestLayout();
    invalidate();
  }
  
  public void setOnIndexBarTouchListener(afsz paramafsz)
  {
    this.jdField_a_of_type_Afsz = paramafsz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.view.IndexBar
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.contacts.alphabet;

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
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private IndexBar.OnIndexBarTouchListener jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBar$OnIndexBarTouchListener;
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
    int i = View.MeasureSpec.getMode(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt1);
    if (i == 1073741824) {
      return j;
    }
    paramInt1 = paramInt2;
    if (i == -2147483648) {
      paramInt1 = Math.min(paramInt2, j);
    }
    return paramInt1;
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
    this.jdField_a_of_type_Float = paramContext.getResources().getDimensionPixelSize(2131297214);
    this.jdField_b_of_type_Float = paramContext.getResources().getDimensionPixelSize(2131297215);
    this.jdField_c_of_type_Float = paramContext.getResources().getDimension(2131297211);
    this.jdField_d_of_type_Float = paramContext.getResources().getDimension(2131297213);
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
    Object localObject = this.jdField_a_of_type_ArrayOfJavaLangString;
    if (localObject == null) {
      return;
    }
    int k = localObject.length;
    if (k <= 0) {
      return;
    }
    int m = this.e / k;
    int j;
    for (int i = 0; i < k; i = j)
    {
      if (i == this.jdField_a_of_type_Int) {
        localObject = this.jdField_b_of_type_AndroidGraphicsPaint;
      } else {
        localObject = this.jdField_a_of_type_AndroidGraphicsPaint;
      }
      float f1 = this.jdField_d_of_type_Int / 2;
      j = i + 1;
      float f2 = m * j;
      float f3 = ((Paint)localObject).measureText(this.jdField_a_of_type_ArrayOfJavaLangString[i]) / 2.0F;
      paramCanvas.drawText(this.jdField_a_of_type_ArrayOfJavaLangString[i], f1, f2 - f3, (Paint)localObject);
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
    super.onMeasure(paramInt1, paramInt2);
    Object localObject = new Rect();
    Paint localPaint = this.jdField_a_of_type_AndroidGraphicsPaint;
    int i = 0;
    localPaint.getTextBounds("W", 0, 1, (Rect)localObject);
    int j = ((Rect)localObject).width();
    int k = (int)this.jdField_d_of_type_Float;
    int i1 = ((Rect)localObject).height();
    int i2 = (int)this.jdField_d_of_type_Float;
    int m = getPaddingLeft();
    int n = getPaddingRight();
    localObject = this.jdField_a_of_type_ArrayOfJavaLangString;
    if (localObject != null) {
      i = (i1 + i2) * localObject.length;
    }
    i1 = getPaddingTop();
    i2 = getPaddingBottom();
    setMeasuredDimension(a(paramInt1, m + (j + k) + n), a(paramInt2, i1 + i + i2));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int j = paramMotionEvent.getAction();
    float f1 = paramMotionEvent.getY();
    int k = this.jdField_a_of_type_Int;
    Object localObject = this.jdField_a_of_type_ArrayOfJavaLangString;
    int i;
    if (localObject != null) {
      i = (int)(f1 / this.e * localObject.length);
    } else {
      i = -1;
    }
    if (j != 0)
    {
      if (j != 1)
      {
        if (j == 2) {
          break label101;
        }
        if (j != 3) {
          return false;
        }
      }
      this.jdField_a_of_type_Boolean = false;
      paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBar$OnIndexBarTouchListener;
      if (paramMotionEvent != null) {
        paramMotionEvent.c(false);
      }
      invalidate();
      return true;
    }
    label101:
    if (k != i)
    {
      localObject = this.jdField_a_of_type_ArrayOfJavaLangString;
      if ((localObject != null) && (i >= 0) && (i < localObject.length))
      {
        this.jdField_a_of_type_Int = i;
        if (this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBar$OnIndexBarTouchListener != null)
        {
          localObject = new Rect();
          Paint localPaint = this.jdField_a_of_type_AndroidGraphicsPaint;
          String[] arrayOfString = this.jdField_a_of_type_ArrayOfJavaLangString;
          k = this.jdField_a_of_type_Int;
          localPaint.getTextBounds(arrayOfString[k], 0, arrayOfString[k].length(), (Rect)localObject);
          localObject = this.jdField_a_of_type_ArrayOfJavaLangString;
          k = localObject.length;
          k = this.e / k;
          int m = this.jdField_a_of_type_Int;
          f1 = k * (m + 1);
          float f2 = this.jdField_a_of_type_AndroidGraphicsPaint.measureText(localObject[m]) / 2.0F;
          this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBar$OnIndexBarTouchListener.a(this.jdField_a_of_type_ArrayOfJavaLangString[i], j, f1 - f2);
        }
      }
      invalidate();
    }
    if (paramMotionEvent.getAction() == 0)
    {
      this.jdField_a_of_type_Boolean = true;
      paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBar$OnIndexBarTouchListener;
      if (paramMotionEvent != null) {
        paramMotionEvent.c(true);
      }
      invalidate();
    }
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
  
  public void setOnIndexBarTouchListener(IndexBar.OnIndexBarTouchListener paramOnIndexBarTouchListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetIndexBar$OnIndexBarTouchListener = paramOnIndexBarTouchListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.alphabet.IndexBar
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.qwallet.voice;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.R.styleable;

public class KSongVolumeView
  extends View
{
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private boolean jdField_a_of_type_Boolean = true;
  public int[] a;
  private int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  
  public KSongVolumeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.change_voice_volume);
    a(paramContext);
    paramContext.recycle();
  }
  
  private void a(TypedArray paramTypedArray)
  {
    if (paramTypedArray.getInt(2, 0) == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_Int = paramTypedArray.getInt(3, 5);
      this.b = ((int)paramTypedArray.getDimension(5, 8.0F));
      this.c = paramTypedArray.getColor(0, -16776961);
      this.jdField_a_of_type_ArrayOfInt = new int[this.jdField_a_of_type_Int];
      this.g = ((int)paramTypedArray.getDimension(4, this.b));
      return;
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_ArrayOfInt[this.d] = paramInt;
    this.d += 1;
    if (this.d >= this.jdField_a_of_type_Int) {
      this.d = 0;
    }
    invalidate();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = this.d;
    int j = 0;
    i -= 1;
    if (j < this.jdField_a_of_type_Int)
    {
      if (i >= 0) {
        break label184;
      }
      i = this.jdField_a_of_type_Int - 1;
    }
    label184:
    for (;;)
    {
      float f2 = this.jdField_a_of_type_ArrayOfInt[i];
      float f1 = f2;
      if (f2 < 1.0F) {
        f1 = 1.0F;
      }
      f2 = f1;
      if (f1 > 8.0F) {
        f2 = 8.0F;
      }
      f2 = f2 / 2.0F * this.g + this.f / 2;
      if (this.jdField_a_of_type_Boolean) {}
      for (f1 = j * 2.0F * this.b;; f1 = (this.jdField_a_of_type_Int - 1 - j) * 2.0F * this.b + this.b)
      {
        paramCanvas.drawRect(f1, this.e - f2, this.b + f1, this.e + f2, this.jdField_a_of_type_AndroidGraphicsPaint);
        j += 1;
        i -= 1;
        break;
      }
      return;
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    paramInt1 = this.jdField_a_of_type_Int;
    paramInt2 = this.b;
    int i = this.g;
    int j = this.f;
    setMeasuredDimension(paramInt1 * 2 * paramInt2 + getPaddingLeft() + getPaddingRight(), i * 8 + j + getPaddingTop() + getPaddingBottom());
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
    if (this.jdField_a_of_type_AndroidGraphicsPaint != null) {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.c);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.voice.KSongVolumeView
 * JD-Core Version:    0.7.0.1
 */
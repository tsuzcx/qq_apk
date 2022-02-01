package com.tencent.biz.subscribe.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;

public class AlphaLoadingView
  extends View
{
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private Handler jdField_a_of_type_AndroidOsHandler;
  private String jdField_a_of_type_JavaLangString = "#00CAFC";
  private boolean jdField_a_of_type_Boolean;
  private int b;
  private int c = -1;
  private int d = 5;
  private int e = this.f;
  private int f = 100;
  private int g = 16;
  
  public AlphaLoadingView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AlphaLoadingView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AlphaLoadingView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidOsHandler = new AlphaLoadingView.1(this);
  }
  
  private int a(int paramInt, boolean paramBoolean)
  {
    int j = View.MeasureSpec.getMode(paramInt);
    int i = View.MeasureSpec.getSize(paramInt);
    switch (j)
    {
    default: 
      if (paramBoolean) {
        return this.c;
      }
      break;
    case 1073741824: 
      return i;
    case -2147483648: 
      if (paramBoolean) {}
      for (paramInt = this.c;; paramInt = this.d) {
        return Math.min(paramInt, i);
      }
    case 0: 
      if (paramBoolean) {
        return this.c;
      }
      return this.d;
    }
    return this.d;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
      setVisibility(0);
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null)
    {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Boolean = true;
      setVisibility(8);
    }
  }
  
  public void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    a();
  }
  
  public void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    b();
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void onDraw(Canvas paramCanvas)
  {
    int i = 255;
    int j = 30;
    super.onDraw(paramCanvas);
    int k;
    if (this.e < this.jdField_a_of_type_Int)
    {
      this.e += 30;
      k = 255 - this.e * 255 / this.jdField_a_of_type_Int;
      if (k <= 255) {
        break label190;
      }
    }
    for (;;)
    {
      if (i < 30) {
        i = j;
      }
      for (;;)
      {
        String str = Integer.toHexString(i);
        i = Color.parseColor("#" + str + this.jdField_a_of_type_JavaLangString.substring(1, this.jdField_a_of_type_JavaLangString.length()));
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(i);
        paramCanvas.drawLine(this.jdField_a_of_type_Int / 2 - this.e / 2, this.d / 2, this.jdField_a_of_type_Int / 2 + this.e / 2, this.d / 2, this.jdField_a_of_type_AndroidGraphicsPaint);
        return;
        this.e = this.f;
        break;
      }
      label190:
      i = k;
    }
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension(a(paramInt1, true), a(paramInt2, false));
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    if (this.jdField_a_of_type_Int < this.e) {
      this.jdField_a_of_type_Int = this.e;
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.b);
  }
  
  public void setTimePeriod(int paramInt)
  {
    if (this.g > 0) {
      this.g = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.AlphaLoadingView
 * JD-Core Version:    0.7.0.1
 */
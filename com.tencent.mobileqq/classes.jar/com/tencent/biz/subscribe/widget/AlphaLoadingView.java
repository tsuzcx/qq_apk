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
    if (j != -2147483648)
    {
      if (j != 0)
      {
        paramInt = i;
        if (j != 1073741824)
        {
          if (paramBoolean) {
            return this.c;
          }
          paramInt = this.d;
        }
        return paramInt;
      }
      if (paramBoolean) {
        return this.c;
      }
      return this.d;
    }
    if (paramBoolean) {
      paramInt = this.c;
    } else {
      paramInt = this.d;
    }
    return Math.min(paramInt, i);
  }
  
  public void a()
  {
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null)
    {
      this.jdField_a_of_type_Boolean = false;
      localHandler.sendEmptyMessage(1);
      setVisibility(0);
    }
  }
  
  public void b()
  {
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null)
    {
      localHandler.removeCallbacksAndMessages(null);
      this.jdField_a_of_type_Boolean = true;
      setVisibility(8);
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    a();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    b();
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = this.e;
    if (i < this.jdField_a_of_type_Int) {
      this.e = (i + 30);
    } else {
      this.e = this.f;
    }
    int j = 255 - this.e * 255 / this.jdField_a_of_type_Int;
    i = j;
    if (j > 255) {
      i = 255;
    }
    j = i;
    if (i < 30) {
      j = 30;
    }
    String str = Integer.toHexString(j);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("#");
    localStringBuilder.append(str);
    str = this.jdField_a_of_type_JavaLangString;
    localStringBuilder.append(str.substring(1, str.length()));
    i = Color.parseColor(localStringBuilder.toString());
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(i);
    i = this.jdField_a_of_type_Int;
    int k = i / 2;
    j = this.e;
    float f1 = k - j / 2;
    k = this.d;
    paramCanvas.drawLine(f1, k / 2, i / 2 + j / 2, k / 2, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    setMeasuredDimension(a(paramInt1, true), a(paramInt2, false));
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    paramInt1 = this.jdField_a_of_type_Int;
    paramInt2 = this.e;
    if (paramInt1 < paramInt2) {
      this.jdField_a_of_type_Int = paramInt2;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.AlphaLoadingView
 * JD-Core Version:    0.7.0.1
 */
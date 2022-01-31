package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import orb;

public class QQStoryLoadingProgressView
  extends View
{
  public static int a;
  public static int b = -1;
  private float jdField_a_of_type_Float = 6.0F;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  public boolean a;
  private int c = Color.parseColor("#7f000000");
  private int d = Color.parseColor("#ffffff");
  private int e = 100;
  private int f = 0;
  private int g = 28;
  private int h = 28;
  
  static
  {
    jdField_a_of_type_Int = 50;
  }
  
  public QQStoryLoadingProgressView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public QQStoryLoadingProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public QQStoryLoadingProgressView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (getVisibility() == 0) {
      a();
    }
  }
  
  private double a(int paramInt)
  {
    if (paramInt == b) {
      return Math.pow(10.0D - (1.0D - this.f * 1.0D / this.e) * 100.0D, 2.5D);
    }
    return 0.0D;
  }
  
  protected void a()
  {
    this.f = 0;
    this.jdField_a_of_type_Boolean = false;
    new orb(this, null).start();
  }
  
  protected void b()
  {
    this.jdField_a_of_type_Boolean = true;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (getVisibility() != 0) {
      super.setVisibility(0);
    }
    super.onDraw(paramCanvas);
    int i = getWidth() / 2;
    int j = (int)(i - this.jdField_a_of_type_Float / 2.0F);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.c);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    paramCanvas.drawCircle(i, i, j, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_a_of_type_Float);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.d);
    this.jdField_a_of_type_AndroidGraphicsRectF.set(i - j, i - j, i + j, j + i);
    paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, -90.0F, this.f * 360 / this.e, false, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(0.0F);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(this.g);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTypeface(Typeface.DEFAULT_BOLD);
    j = this.f * 100 / this.e;
    float f1 = this.jdField_a_of_type_AndroidGraphicsPaint.measureText(j + "");
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(this.h);
    float f2 = this.jdField_a_of_type_AndroidGraphicsPaint.measureText("%");
    if (j != 0)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(this.g);
      paramCanvas.drawText(j + "", i - (f1 + f2) / 2.0F, this.g / 2 + i, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(this.h);
      paramCanvas.drawText("%", f1 + (i - (f2 + f1) / 2.0F), this.g / 2 + i, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    if ((this.f >= this.e) && (getVisibility() == 0)) {
      super.setVisibility(8);
    }
  }
  
  public void setCircleColor(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setCircleProgressColor(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setMax(int paramInt)
  {
    if (paramInt < 0) {
      try
      {
        throw new IllegalArgumentException("max not less than 0");
      }
      finally {}
    }
    this.e = paramInt;
  }
  
  public void setProgress(int paramInt)
  {
    if (paramInt < 0) {
      try
      {
        throw new IllegalArgumentException("progress not less than 0");
      }
      finally {}
    }
    int i = paramInt;
    if (paramInt > this.e) {
      i = this.e;
    }
    if (i <= this.e)
    {
      this.f = i;
      postInvalidate();
    }
  }
  
  public void setRoundWidth(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void setVisibility(int paramInt)
  {
    if (getVisibility() != paramInt)
    {
      if (paramInt == 0)
      {
        super.setVisibility(0);
        a();
      }
    }
    else {
      return;
    }
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.QQStoryLoadingProgressView
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.pubaccount.readinjoy.ad.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class ReadInjoyHeaderAdDownloadView$SimpleRoundProgress
  extends View
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  RectF jdField_a_of_type_AndroidGraphicsRectF;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private int d;
  private int e;
  private int f;
  
  public ReadInjoyHeaderAdDownloadView$SimpleRoundProgress(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ReadInjoyHeaderAdDownloadView$SimpleRoundProgress(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ReadInjoyHeaderAdDownloadView$SimpleRoundProgress(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = getWidth() / 2;
    int j = (int)(i - this.jdField_a_of_type_Float / 2.0F);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_a_of_type_Float);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
    RectF localRectF;
    switch (this.d)
    {
    default: 
      paramCanvas.drawCircle(i, i, j, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_b_of_type_Float);
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_b_of_type_Int);
      localRectF = new RectF(i - j, i - j, i + j, j + i);
      j = this.f * 360 / this.jdField_c_of_type_Int;
      switch (this.d)
      {
      }
      break;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
        float f1 = this.jdField_c_of_type_Float / 2.0F;
        if (this.jdField_a_of_type_AndroidGraphicsRectF == null) {
          this.jdField_a_of_type_AndroidGraphicsRectF = new RectF(i - f1, i - f1, i + f1, f1 + i);
        }
        paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      return;
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      break;
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL_AND_STROKE);
      break;
      paramCanvas.drawArc(localRectF, this.e, j, false, this.jdField_a_of_type_AndroidGraphicsPaint);
      continue;
      paramCanvas.drawArc(localRectF, this.e, j, true, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
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
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void setPaused(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
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
    if (paramInt > this.jdField_c_of_type_Int) {
      i = this.jdField_c_of_type_Int;
    }
    this.f = i;
    postInvalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ad.view.ReadInjoyHeaderAdDownloadView.SimpleRoundProgress
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.pubaccount.readinjoyAd.ad.view;

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
  public float a;
  public int a;
  public Paint a;
  RectF jdField_a_of_type_AndroidGraphicsRectF;
  private volatile boolean jdField_a_of_type_Boolean;
  public float b;
  public int b;
  public float c;
  public int c;
  public int d;
  public int e;
  public int f;
  
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
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = getWidth() / 2;
    float f1 = i;
    float f2 = this.jdField_a_of_type_Float;
    int j = (int)(f1 - f2 / 2.0F);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(f2);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
    int k = this.d;
    if (k != 0)
    {
      if (k == 1) {
        this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL_AND_STROKE);
      }
    }
    else {
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    }
    paramCanvas.drawCircle(f1, f1, j, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_b_of_type_Float);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_b_of_type_Int);
    f2 = i - j;
    float f3 = i + j;
    RectF localRectF = new RectF(f2, f2, f3, f3);
    i = this.f * 360 / this.jdField_c_of_type_Int;
    j = this.d;
    if (j != 0)
    {
      if (j == 1) {
        paramCanvas.drawArc(localRectF, this.e, i, true, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
    }
    else {
      paramCanvas.drawArc(localRectF, this.e, i, false, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      f3 = this.jdField_c_of_type_Float / 2.0F;
      if (this.jdField_a_of_type_AndroidGraphicsRectF == null)
      {
        f2 = f1 - f3;
        f1 += f3;
        this.jdField_a_of_type_AndroidGraphicsRectF = new RectF(f2, f2, f1, f1);
      }
      paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  public void setMax(int paramInt)
  {
    if (paramInt >= 0) {
      try
      {
        this.jdField_c_of_type_Int = paramInt;
        return;
      }
      finally
      {
        break label28;
      }
    }
    throw new IllegalArgumentException("max not less than 0");
    label28:
    throw localObject;
  }
  
  public void setPauseWithoutInvalidate(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setPaused(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    postInvalidate();
  }
  
  public void setProgress(int paramInt)
  {
    if (paramInt >= 0)
    {
      int i = paramInt;
      try
      {
        if (paramInt > this.jdField_c_of_type_Int) {
          i = this.jdField_c_of_type_Int;
        }
        this.f = i;
        postInvalidate();
        return;
      }
      finally
      {
        break label47;
      }
    }
    throw new IllegalArgumentException("progress not less than 0");
    label47:
    throw localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInjoyHeaderAdDownloadView.SimpleRoundProgress
 * JD-Core Version:    0.7.0.1
 */
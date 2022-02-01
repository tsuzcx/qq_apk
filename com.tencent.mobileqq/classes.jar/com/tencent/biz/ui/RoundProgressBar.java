package com.tencent.biz.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class RoundProgressBar
  extends View
{
  private float jdField_a_of_type_Float = 20.0F;
  private int jdField_a_of_type_Int = -252645121;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  private RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  Runnable jdField_a_of_type_JavaLangRunnable = new RoundProgressBar.1(this);
  private boolean jdField_a_of_type_Boolean = true;
  private float jdField_b_of_type_Float = 18.0F;
  private int jdField_b_of_type_Int = -1529614848;
  private float jdField_c_of_type_Float = 5.0F;
  private int jdField_c_of_type_Int = -16777216;
  private int d = 100;
  private int e = 0;
  private int f;
  
  public RoundProgressBar(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public RoundProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public RoundProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(int paramInt)
  {
    this.f = paramInt;
    ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 30L);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    int i = getWidth() / 2;
    float f1 = i;
    int j = (int)(f1 - this.jdField_c_of_type_Float / 2.0F);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_c_of_type_Float);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    paramCanvas.drawCircle(f1, f1, j, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_c_of_type_Float);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_b_of_type_Int);
    Object localObject = this.jdField_a_of_type_AndroidGraphicsRectF;
    float f2 = i - j;
    float f3 = i + j;
    ((RectF)localObject).set(f2, f2, f3, f3);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, -90.0F, this.e * 360 / this.d, false, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(0.0F);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_c_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_a_of_type_Float);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setTypeface(Typeface.DEFAULT_BOLD);
    i = this.e * 100 / this.d;
    localObject = this.jdField_a_of_type_AndroidGraphicsPaint;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(i);
    localStringBuilder.append("");
    f2 = ((Paint)localObject).measureText(localStringBuilder.toString());
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_b_of_type_Float);
    f3 = this.jdField_a_of_type_AndroidGraphicsPaint.measureText("%");
    if ((i != 0) && (this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_a_of_type_Float);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(i);
      ((StringBuilder)localObject).append("");
      localObject = ((StringBuilder)localObject).toString();
      f3 = f1 - (f3 + f2) / 2.0F;
      paramCanvas.drawText((String)localObject, f3, this.jdField_a_of_type_Float / 2.0F + f1, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(this.jdField_b_of_type_Float);
      paramCanvas.drawText("%", f3 + f2, f1 + this.jdField_a_of_type_Float / 2.0F, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  public void setCircleColor(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setCircleProgressColor(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void setMax(int paramInt)
  {
    if (paramInt >= 0) {
      try
      {
        this.d = paramInt;
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
  
  public void setNeedShowProgreeText(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setPercentMarkTextSize(float paramFloat)
  {
    this.jdField_b_of_type_Float = paramFloat;
  }
  
  public void setProgress(int paramInt)
  {
    if (paramInt >= 0)
    {
      int i = paramInt;
      try
      {
        if (paramInt > this.d) {
          i = this.d;
        }
        if ((i <= this.d) && (this.e != i)) {
          a(i);
        }
        return;
      }
      finally
      {
        break label59;
      }
    }
    throw new IllegalArgumentException("progress not less than 0");
    label59:
    throw localObject;
  }
  
  public void setRoundWidth(float paramFloat)
  {
    this.jdField_c_of_type_Float = paramFloat;
  }
  
  public void setTextColor(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void setTextSize(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.ui.RoundProgressBar
 * JD-Core Version:    0.7.0.1
 */
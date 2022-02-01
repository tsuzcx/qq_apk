package com.tencent.aelight.camera.ae.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

public class AEDownLoadingView
  extends View
{
  private static float jdField_d_of_type_Float;
  protected float a;
  protected int a;
  protected long a;
  protected Paint a;
  protected Path a;
  protected RectF a;
  boolean a;
  protected float b;
  protected int b;
  protected long b;
  protected Paint b;
  protected RectF b;
  boolean b;
  protected float c;
  private int c;
  private int jdField_d_of_type_Int;
  
  public AEDownLoadingView(Context paramContext)
  {
    super(paramContext);
    int i = this.jdField_a_of_type_Int;
    float f = i - 16843176;
    int j = this.jdField_b_of_type_Int;
    this.jdField_b_of_type_AndroidGraphicsRectF = new RectF(f, j - 16843176, i + 16843176, j + 16843176);
    this.jdField_a_of_type_Long = 100L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_Float = a(2.0F, getContext());
    this.jdField_b_of_type_Float = a(17.5F, getContext());
    this.jdField_c_of_type_Float = a(2.5F, getContext());
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    a();
  }
  
  public AEDownLoadingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    int i = this.jdField_a_of_type_Int;
    float f = i - 16843176;
    int j = this.jdField_b_of_type_Int;
    this.jdField_b_of_type_AndroidGraphicsRectF = new RectF(f, j - 16843176, i + 16843176, j + 16843176);
    this.jdField_a_of_type_Long = 100L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_Float = a(2.0F, getContext());
    this.jdField_b_of_type_Float = a(17.5F, getContext());
    this.jdField_c_of_type_Float = a(2.5F, getContext());
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    a();
  }
  
  public AEDownLoadingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramInt = this.jdField_a_of_type_Int;
    float f = paramInt - 16843176;
    int i = this.jdField_b_of_type_Int;
    this.jdField_b_of_type_AndroidGraphicsRectF = new RectF(f, i - 16843176, paramInt + 16843176, i + 16843176);
    this.jdField_a_of_type_Long = 100L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_a_of_type_Float = a(2.0F, getContext());
    this.jdField_b_of_type_Float = a(17.5F, getContext());
    this.jdField_c_of_type_Float = a(2.5F, getContext());
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = true;
    a();
  }
  
  private static int a(float paramFloat, Context paramContext)
  {
    if (jdField_d_of_type_Float == 0.0F) {
      jdField_d_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    }
    return (int)(paramFloat * jdField_d_of_type_Float);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(2130706432);
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint(1);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(0);
    this.jdField_b_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    if (Build.VERSION.SDK_INT >= 11) {
      setLayerType(1, null);
    }
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.jdField_a_of_type_Boolean)
    {
      localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
      f = this.jdField_a_of_type_Float;
      paramCanvas.drawRoundRect(localRectF, f, f, this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
    }
    RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
    float f = this.jdField_a_of_type_Float;
    paramCanvas.drawRoundRect(localRectF, f, f, this.jdField_a_of_type_AndroidGraphicsPaint);
    long l1 = this.jdField_b_of_type_Long;
    if (l1 >= 0L)
    {
      long l2 = this.jdField_a_of_type_Long;
      if (l1 <= l2)
      {
        f = (float)l1 * 360.0F / (float)l2;
        if (this.jdField_b_of_type_Boolean)
        {
          paramCanvas.drawCircle(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_b_of_type_Float, this.jdField_b_of_type_AndroidGraphicsPaint);
          paramCanvas.drawCircle(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_b_of_type_Float - this.jdField_c_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPaint);
          this.jdField_a_of_type_AndroidGraphicsPath.reset();
          this.jdField_a_of_type_AndroidGraphicsPath.moveTo(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
          this.jdField_a_of_type_AndroidGraphicsPath.arcTo(this.jdField_b_of_type_AndroidGraphicsRectF, 270.0F, f);
          paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_b_of_type_AndroidGraphicsPaint);
          return;
        }
        paramCanvas.drawArc(this.jdField_b_of_type_AndroidGraphicsRectF, 270.0F, f, false, this.jdField_b_of_type_AndroidGraphicsPaint);
      }
    }
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_c_of_type_Int = paramInt1;
    this.jdField_d_of_type_Int = paramInt2;
    paramInt1 = this.jdField_c_of_type_Int;
    this.jdField_a_of_type_Int = (paramInt1 / 2);
    paramInt2 = this.jdField_d_of_type_Int;
    this.jdField_b_of_type_Int = (paramInt2 / 2);
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF(0.0F, 0.0F, paramInt1, paramInt2);
    float f1 = this.jdField_b_of_type_Float - this.jdField_c_of_type_Float;
    paramInt1 = this.jdField_a_of_type_Int;
    float f2 = paramInt1;
    paramInt2 = this.jdField_b_of_type_Int;
    this.jdField_b_of_type_AndroidGraphicsRectF = new RectF(f2 - f1, paramInt2 - f1, paramInt1 + f1, paramInt2 + f1);
  }
  
  public void setBgColor(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(paramInt);
  }
  
  public void setBgCorner(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void setMax(int paramInt)
  {
    this.jdField_a_of_type_Long = paramInt;
  }
  
  public void setProgress(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
    if (this.jdField_b_of_type_Long == this.jdField_a_of_type_Long) {
      setVisibility(4);
    }
    invalidate();
  }
  
  public void setProgressColor(int paramInt)
  {
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(paramInt);
  }
  
  public void setProgressSizeAndMode(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    this.jdField_b_of_type_Float = paramFloat1;
    this.jdField_c_of_type_Float = paramFloat2;
    paramFloat1 = this.jdField_b_of_type_Float - this.jdField_c_of_type_Float;
    int i = this.jdField_a_of_type_Int;
    float f = i;
    int j = this.jdField_b_of_type_Int;
    this.jdField_b_of_type_AndroidGraphicsRectF = new RectF(f - paramFloat1, j - paramFloat1, i + paramFloat1, j + paramFloat1);
    this.jdField_b_of_type_Boolean = paramBoolean;
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
      this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      return;
    }
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(paramFloat2);
    this.jdField_b_of_type_AndroidGraphicsPaint.setXfermode(null);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeCap(Paint.Cap.ROUND);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.view.AEDownLoadingView
 * JD-Core Version:    0.7.0.1
 */
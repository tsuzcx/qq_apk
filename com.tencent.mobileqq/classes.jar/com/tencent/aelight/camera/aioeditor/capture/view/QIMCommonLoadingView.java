package com.tencent.aelight.camera.aioeditor.capture.view;

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

public class QIMCommonLoadingView
  extends View
  implements QIMCommonLoadingProgress.Observer
{
  private static float jdField_d_of_type_Float;
  protected float a;
  protected int a;
  protected long a;
  protected Paint a;
  protected Path a;
  protected RectF a;
  QIMCommonLoadingProgress jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMCommonLoadingProgress;
  boolean jdField_a_of_type_Boolean;
  protected float b;
  protected int b;
  protected long b;
  protected Paint b;
  protected RectF b;
  boolean b;
  protected float c;
  private int jdField_c_of_type_Int;
  boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  
  public QIMCommonLoadingView(Context paramContext)
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
    this.jdField_c_of_type_Boolean = false;
    b();
  }
  
  public QIMCommonLoadingView(Context paramContext, AttributeSet paramAttributeSet)
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
    this.jdField_c_of_type_Boolean = false;
    b();
  }
  
  public QIMCommonLoadingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
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
    this.jdField_c_of_type_Boolean = false;
    b();
  }
  
  public static int a(float paramFloat, Context paramContext)
  {
    if (jdField_d_of_type_Float == 0.0F) {
      jdField_d_of_type_Float = paramContext.getResources().getDisplayMetrics().density;
    }
    return (int)(paramFloat * jdField_d_of_type_Float);
  }
  
  public void a()
  {
    QIMCommonLoadingProgress localQIMCommonLoadingProgress = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMCommonLoadingProgress;
    if (localQIMCommonLoadingProgress != null) {
      setProgress(Math.round(localQIMCommonLoadingProgress.a() * (float)this.jdField_a_of_type_Long));
    }
  }
  
  public void a(QIMCommonLoadingProgress paramQIMCommonLoadingProgress)
  {
    QIMCommonLoadingProgress localQIMCommonLoadingProgress = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMCommonLoadingProgress;
    if (localQIMCommonLoadingProgress != null) {
      localQIMCommonLoadingProgress.a(this);
    }
    this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMCommonLoadingProgress = paramQIMCommonLoadingProgress;
    if (paramQIMCommonLoadingProgress != null)
    {
      paramQIMCommonLoadingProgress.b(this);
      setProgress(Math.round(paramQIMCommonLoadingProgress.a() * (float)this.jdField_a_of_type_Long));
    }
  }
  
  protected void b()
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
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    RectF localRectF;
    float f;
    if (this.jdField_a_of_type_Boolean)
    {
      localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
      f = this.jdField_a_of_type_Float;
      paramCanvas.drawRoundRect(localRectF, f, f, this.jdField_a_of_type_AndroidGraphicsPaint);
      return;
    }
    long l = this.jdField_b_of_type_Long;
    if ((l != 0L) && (l != this.jdField_a_of_type_Long))
    {
      localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
      f = this.jdField_a_of_type_Float;
      paramCanvas.drawRoundRect(localRectF, f, f, this.jdField_a_of_type_AndroidGraphicsPaint);
      f = (float)this.jdField_b_of_type_Long * 360.0F / (float)this.jdField_a_of_type_Long;
      if (this.jdField_b_of_type_Boolean)
      {
        paramCanvas.drawCircle(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_b_of_type_Float, this.jdField_b_of_type_AndroidGraphicsPaint);
        paramCanvas.drawCircle(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_b_of_type_Float - this.jdField_c_of_type_Float, this.jdField_a_of_type_AndroidGraphicsPaint);
        this.jdField_a_of_type_AndroidGraphicsPath.reset();
        this.jdField_a_of_type_AndroidGraphicsPath.moveTo(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int);
        this.jdField_a_of_type_AndroidGraphicsPath.arcTo(this.jdField_b_of_type_AndroidGraphicsRectF, 270.0F, f);
        paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_b_of_type_AndroidGraphicsPaint);
      }
      else
      {
        paramCanvas.drawArc(this.jdField_b_of_type_AndroidGraphicsRectF, 270.0F, f, false, this.jdField_b_of_type_AndroidGraphicsPaint);
      }
      if (this.jdField_c_of_type_Boolean)
      {
        if (this.jdField_b_of_type_Long != this.jdField_a_of_type_Long)
        {
          paramCanvas = this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMCommonLoadingProgress;
          if (paramCanvas != null)
          {
            setProgress(Math.round(paramCanvas.a() * (float)this.jdField_a_of_type_Long));
            return;
          }
        }
        this.jdField_c_of_type_Boolean = false;
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
    if (paramLong == 0L) {
      this.jdField_b_of_type_Long = paramLong;
    }
    this.jdField_b_of_type_Long = paramLong;
    if ((this.jdField_b_of_type_Long != this.jdField_a_of_type_Long) && (this.jdField_a_of_type_ComTencentAelightCameraAioeditorCaptureViewQIMCommonLoadingProgress != null)) {
      this.jdField_c_of_type_Boolean = true;
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
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.view.QIMCommonLoadingView
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.contact.addcontact.face2face;

import agej;
import ajfz;
import ajga;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.mobileqq.R.styleable;

public class LoadingAvatarProgressView
  extends View
{
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int;
  private ajga jdField_a_of_type_Ajga;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Path jdField_a_of_type_AndroidGraphicsPath;
  private PathMeasure jdField_a_of_type_AndroidGraphicsPathMeasure;
  private RectF jdField_a_of_type_AndroidGraphicsRectF;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  private int jdField_b_of_type_Int;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private Path jdField_b_of_type_AndroidGraphicsPath;
  private RectF jdField_b_of_type_AndroidGraphicsRectF;
  private float jdField_c_of_type_Float;
  private int jdField_c_of_type_Int;
  private Paint jdField_c_of_type_AndroidGraphicsPaint;
  private RectF jdField_c_of_type_AndroidGraphicsRectF;
  private int d;
  private int e = 1500;
  private int f;
  private int g;
  private int h = 30;
  private int i;
  
  public LoadingAvatarProgressView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public LoadingAvatarProgressView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public LoadingAvatarProgressView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }
  
  private void a()
  {
    this.jdField_b_of_type_AndroidGraphicsPath = new Path();
    int j = this.jdField_a_of_type_Int * 2;
    int k = this.jdField_b_of_type_Int * 2;
    this.jdField_b_of_type_AndroidGraphicsRectF = new RectF(0.0F, 0.0F, j, k);
    Object localObject = new Path();
    ((Path)localObject).moveTo(this.jdField_a_of_type_Int, 0.0F);
    ((Path)localObject).lineTo(j, 0.0F);
    ((Path)localObject).lineTo(j, k);
    ((Path)localObject).lineTo(0.0F, k);
    ((Path)localObject).lineTo(0.0F, 0.0F);
    ((Path)localObject).lineTo(this.jdField_a_of_type_Int, 0.0F);
    ((Path)localObject).close();
    this.jdField_a_of_type_AndroidGraphicsPathMeasure = new PathMeasure((Path)localObject, false);
    this.jdField_c_of_type_Float = this.jdField_a_of_type_AndroidGraphicsPathMeasure.getLength();
    localObject = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    ((ValueAnimator)localObject).setDuration(this.e);
    ((ValueAnimator)localObject).addUpdateListener(new ajfz(this));
    ((ValueAnimator)localObject).start();
  }
  
  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CircleLoadingView);
    this.jdField_a_of_type_Float = paramContext.getInteger(2, 5);
    this.jdField_a_of_type_Float = agej.a(this.jdField_a_of_type_Float, getResources());
    this.i = paramContext.getInteger(1, 5);
    this.i = agej.a(this.i, getResources());
    this.d = paramContext.getInteger(0, -16776961);
    paramContext.recycle();
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_a_of_type_Float);
    this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.d);
    this.jdField_c_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_c_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_c_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_a_of_type_Float);
    this.jdField_c_of_type_AndroidGraphicsPaint.setColor(this.d);
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.jdField_a_of_type_Float);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.d);
  }
  
  private void a(Canvas paramCanvas)
  {
    if (this.g < 100)
    {
      this.jdField_c_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
      this.jdField_c_of_type_AndroidGraphicsPaint.setColor(Color.parseColor("#8E8E93"));
      paramCanvas.drawArc(this.jdField_c_of_type_AndroidGraphicsRectF, -90.0F, this.g * 360 / 100, false, this.jdField_c_of_type_AndroidGraphicsPaint);
      this.g += 2;
      postInvalidateDelayed(this.h);
      return;
    }
    this.g = 0;
    postInvalidateDelayed(this.h);
  }
  
  private void b()
  {
    int j = agej.a(12.0F, getResources());
    int k = agej.a(4.0F, getResources());
    float f1 = this.jdField_a_of_type_Int - j + k;
    float f2 = this.jdField_b_of_type_Int;
    float f3 = this.jdField_a_of_type_Int - j / 2 + k;
    float f4 = this.jdField_b_of_type_Int + j / 2;
    float f5 = k + (this.jdField_a_of_type_Int + j * 2 / 4);
    float f6 = this.jdField_b_of_type_Int - j * 2 / 4;
    this.jdField_a_of_type_AndroidGraphicsPath = new Path();
    this.jdField_a_of_type_AndroidGraphicsPath.reset();
    this.jdField_a_of_type_AndroidGraphicsPath.moveTo(f1, f2);
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(f3, f4);
    this.jdField_a_of_type_AndroidGraphicsPath.lineTo(f5, f6);
  }
  
  private void b(Canvas paramCanvas)
  {
    if (this.jdField_b_of_type_Float < this.jdField_c_of_type_Float)
    {
      this.jdField_b_of_type_AndroidGraphicsPath.reset();
      this.jdField_b_of_type_AndroidGraphicsPath.lineTo(0.0F, 0.0F);
      this.jdField_a_of_type_AndroidGraphicsPathMeasure.getSegment(0.0F, this.jdField_b_of_type_Float, this.jdField_b_of_type_AndroidGraphicsPath, false);
      paramCanvas.drawPath(this.jdField_b_of_type_AndroidGraphicsPath, this.jdField_b_of_type_AndroidGraphicsPaint);
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
        paramCanvas.drawRoundRect(this.jdField_b_of_type_AndroidGraphicsRectF, this.i, this.i, this.jdField_b_of_type_AndroidGraphicsPaint);
        paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
    } while (this.jdField_a_of_type_Ajga == null);
    this.jdField_a_of_type_Ajga.a(this.f);
  }
  
  private void c(Canvas paramCanvas)
  {
    if (this.f < 100)
    {
      paramCanvas.drawArc(this.jdField_a_of_type_AndroidGraphicsRectF, -90.0F, this.f * 360 / 100, false, this.jdField_b_of_type_AndroidGraphicsPaint);
      this.f += 2;
      postInvalidateDelayed(this.h);
    }
    do
    {
      return;
      if (this.jdField_a_of_type_Boolean)
      {
        this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
        paramCanvas.drawCircle(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, Math.min(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int), this.jdField_b_of_type_AndroidGraphicsPaint);
        paramCanvas.drawPath(this.jdField_a_of_type_AndroidGraphicsPath, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
    } while (this.jdField_a_of_type_Ajga == null);
    this.jdField_a_of_type_Ajga.a(this.f);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_c_of_type_Int == 0) {
      c(paramCanvas);
    }
    do
    {
      return;
      if (this.jdField_c_of_type_Int == 1)
      {
        b(paramCanvas);
        return;
      }
    } while (this.jdField_c_of_type_Int != 2);
    a(paramCanvas);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    paramInt1 = getWidth();
    paramInt2 = getHeight();
    this.jdField_a_of_type_Int = (paramInt1 / 2);
    this.jdField_b_of_type_Int = (paramInt2 / 2);
    this.jdField_a_of_type_AndroidGraphicsRectF = new RectF(this.jdField_a_of_type_Float / 2.0F, this.jdField_a_of_type_Float / 2.0F, paramInt1 - this.jdField_a_of_type_Float / 2.0F, paramInt2 - this.jdField_a_of_type_Float / 2.0F);
    this.jdField_c_of_type_AndroidGraphicsRectF = new RectF(this.jdField_a_of_type_Float / 2.0F, this.jdField_a_of_type_Float / 2.0F, paramInt1 - this.jdField_a_of_type_Float / 2.0F, paramInt2 - this.jdField_a_of_type_Float / 2.0F);
    a();
    if (this.jdField_a_of_type_Boolean) {
      b();
    }
  }
  
  public void setAnimDuration(int paramInt)
  {
    this.e = paramInt;
    this.h = (paramInt / 50);
  }
  
  public void setLoadType(int paramInt)
  {
    this.f = 0;
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void setNeedCover(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void setProgressListener(ajga paramajga)
  {
    this.jdField_a_of_type_Ajga = paramajga;
  }
  
  public void setRoundSize(int paramInt)
  {
    this.i = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.face2face.LoadingAvatarProgressView
 * JD-Core Version:    0.7.0.1
 */
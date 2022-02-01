package com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.widget;

import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.animation.AnimatorFactory;
import com.tencent.biz.qqstory.support.logging.SLog;

@TargetApi(14)
public class ElasticImageView
  extends ImageView
{
  public float a;
  public int a;
  public final long a;
  public ValueAnimator a;
  private Matrix a;
  public boolean a;
  public float b;
  public int b;
  public ValueAnimator b;
  private Matrix b;
  public boolean b;
  public float c;
  public int c;
  public boolean c;
  public float d;
  public int d;
  public float e;
  public int e;
  public float f;
  public int f;
  public int g;
  public int h;
  public int i;
  
  public ElasticImageView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_b_of_type_Float = 1.0F;
    this.jdField_c_of_type_Float = 1.0F;
    this.jdField_a_of_type_Long = 100L;
    this.jdField_d_of_type_Float = this.jdField_b_of_type_Float;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_e_of_type_Float = 1.0F;
    this.jdField_f_of_type_Float = 1.0F;
    this.jdField_c_of_type_Boolean = true;
    a();
  }
  
  public ElasticImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_b_of_type_Float = 1.0F;
    this.jdField_c_of_type_Float = 1.0F;
    this.jdField_a_of_type_Long = 100L;
    this.jdField_d_of_type_Float = this.jdField_b_of_type_Float;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_e_of_type_Float = 1.0F;
    this.jdField_f_of_type_Float = 1.0F;
    this.jdField_c_of_type_Boolean = true;
    a();
  }
  
  private ValueAnimator a(float paramFloat1, float paramFloat2, long paramLong)
  {
    return AnimatorFactory.a(paramLong, paramFloat1, paramFloat2, new ElasticImageView.1(this));
  }
  
  private void a()
  {
    setScaleType(ImageView.ScaleType.MATRIX);
    this.jdField_b_of_type_AndroidGraphicsMatrix = new Matrix(getImageMatrix());
    this.jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  }
  
  private void a(float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateMatrix:");
    localStringBuilder.append(paramFloat);
    SLog.b("ElasticImageView", localStringBuilder.toString());
    this.jdField_a_of_type_AndroidGraphicsMatrix.set(this.jdField_b_of_type_AndroidGraphicsMatrix);
    this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(this.g, this.h);
    this.jdField_a_of_type_AndroidGraphicsMatrix.postScale(this.jdField_e_of_type_Float, this.jdField_f_of_type_Float, this.jdField_e_of_type_Int, this.jdField_f_of_type_Int);
    this.jdField_a_of_type_AndroidGraphicsMatrix.postScale(paramFloat, paramFloat, this.jdField_e_of_type_Int, this.jdField_f_of_type_Int);
    super.setImageMatrix(this.jdField_a_of_type_AndroidGraphicsMatrix);
  }
  
  private void b()
  {
    ValueAnimator localValueAnimator = this.jdField_b_of_type_AndroidAnimationValueAnimator;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
      this.jdField_b_of_type_AndroidAnimationValueAnimator.cancel();
    }
    localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if ((localValueAnimator == null) || (!localValueAnimator.isRunning()))
    {
      this.jdField_a_of_type_AndroidAnimationValueAnimator = a(this.jdField_d_of_type_Float, this.jdField_c_of_type_Float, 100L);
      this.jdField_a_of_type_AndroidAnimationValueAnimator.start();
    }
  }
  
  private void c()
  {
    ValueAnimator localValueAnimator = this.jdField_a_of_type_AndroidAnimationValueAnimator;
    if ((localValueAnimator != null) && (localValueAnimator.isRunning())) {
      this.jdField_a_of_type_AndroidAnimationValueAnimator.cancel();
    }
    localValueAnimator = this.jdField_b_of_type_AndroidAnimationValueAnimator;
    if ((localValueAnimator == null) || (!localValueAnimator.isRunning()))
    {
      this.jdField_b_of_type_AndroidAnimationValueAnimator = a(this.jdField_d_of_type_Float, this.jdField_a_of_type_Float, 100L);
      this.jdField_b_of_type_AndroidAnimationValueAnimator.start();
    }
  }
  
  private void d()
  {
    boolean bool;
    if (getDrawable() != null) {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_a_of_type_Boolean = bool;
    if (!bool) {
      return;
    }
    int m = getDrawable().getIntrinsicWidth();
    int n = getDrawable().getIntrinsicHeight();
    int j = m;
    int k = n;
    if (this.jdField_b_of_type_Boolean) {
      if (m < n)
      {
        this.jdField_f_of_type_Float = (m / n);
        this.jdField_e_of_type_Float = 1.0F;
        k = m;
        j = m;
      }
      else if (m > n)
      {
        this.jdField_e_of_type_Float = (n / m);
        this.jdField_f_of_type_Float = 1.0F;
        j = n;
        k = n;
      }
      else
      {
        this.jdField_e_of_type_Float = 1.0F;
        this.jdField_f_of_type_Float = 1.0F;
        k = n;
        j = m;
      }
    }
    m = this.jdField_c_of_type_Int;
    float f2;
    float f3;
    if (j <= m)
    {
      n = this.jdField_d_of_type_Int;
      if (k <= n)
      {
        f2 = m / j;
        f3 = n / k;
        f1 = f3;
        if (f2 < f3)
        {
          f1 = f2;
          break label315;
        }
      }
    }
    for (;;)
    {
      break;
      m = this.jdField_c_of_type_Int;
      n = j - m;
      int i1 = this.jdField_d_of_type_Int;
      int i2 = k - i1;
      if ((n > 0) && (i2 > 0))
      {
        f2 = m / j;
        f3 = i1 / k;
        f1 = f3;
        if (f2 < f3) {
          f1 = f2;
        }
      }
      else
      {
        if (n > 0) {
          f1 = this.jdField_c_of_type_Int;
        }
        for (f2 = j;; f2 = k)
        {
          f1 /= f2;
          break;
          if (i2 <= 0) {
            break label313;
          }
          f1 = this.jdField_d_of_type_Int;
        }
        label313:
        f1 = 1.0F;
      }
    }
    label315:
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("drawableWidth:");
    localStringBuilder.append(j);
    localStringBuilder.append(",drawableHeight:");
    localStringBuilder.append(k);
    localStringBuilder.append(",AvaliableWidth:");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append(",AvaliableHeight:");
    localStringBuilder.append(this.jdField_d_of_type_Int);
    localStringBuilder.append(",scaleValue:");
    localStringBuilder.append(f1);
    SLog.b("ElasticImageView", localStringBuilder.toString());
    this.jdField_a_of_type_Float = f1;
    float f1 = this.jdField_a_of_type_Float;
    this.jdField_b_of_type_Float = (0.9F * f1);
    this.jdField_c_of_type_Float = (f1 * 0.5F);
    this.g = ((int)(this.jdField_e_of_type_Int - j / this.jdField_e_of_type_Float / 2.0F));
    this.h = ((int)(this.jdField_f_of_type_Int - k / this.jdField_f_of_type_Float / 2.0F));
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_e_of_type_Int = ((paramInt1 - getPaddingLeft() - getPaddingRight()) / 2);
    this.jdField_f_of_type_Int = ((paramInt2 - getPaddingTop() - getPaddingBottom()) / 2);
    paramInt1 = this.jdField_f_of_type_Int;
    this.i = (paramInt1 * 2);
    this.jdField_c_of_type_Int = (this.jdField_e_of_type_Int * 2);
    this.jdField_d_of_type_Int = (paramInt1 * 2);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ImageViewWidth:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(",ImageViewHeight:");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(",centerX:");
    localStringBuilder.append(this.jdField_e_of_type_Int);
    localStringBuilder.append(",centerY:");
    localStringBuilder.append(this.jdField_f_of_type_Int);
    localStringBuilder.append(",AvaliableWidth:");
    localStringBuilder.append(this.jdField_c_of_type_Int);
    localStringBuilder.append(",AvaliableHeight:");
    localStringBuilder.append(this.jdField_d_of_type_Int);
    SLog.b("ElasticImageView", localStringBuilder.toString());
    d();
    this.jdField_d_of_type_Float = this.jdField_a_of_type_Float;
    a(this.jdField_d_of_type_Float);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_c_of_type_Boolean))
    {
      float f1 = paramMotionEvent.getX();
      float f2 = paramMotionEvent.getY();
      int j = paramMotionEvent.getAction();
      if (j != 0)
      {
        if (j != 1) {
          if (j != 2)
          {
            if (j != 3) {
              break label128;
            }
          }
          else
          {
            if ((f1 >= 0.0F) && (f1 <= getWidth()) && (f2 >= 0.0F) && (f2 <= getHeight()))
            {
              b();
              break label128;
            }
            c();
            break label128;
          }
        }
        c();
      }
      else
      {
        d();
        this.jdField_d_of_type_Float = this.jdField_b_of_type_Float;
        b();
      }
    }
    label128:
    super.onTouchEvent(paramMotionEvent);
    return true;
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    d();
    this.jdField_d_of_type_Float = this.jdField_a_of_type_Float;
    a(this.jdField_d_of_type_Float);
  }
  
  public void setIsNeedAdjustDrawableToSquare(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.ui.widget.ElasticImageView
 * JD-Core Version:    0.7.0.1
 */
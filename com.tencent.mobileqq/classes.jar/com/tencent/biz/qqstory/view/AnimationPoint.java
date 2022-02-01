package com.tencent.biz.qqstory.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation.AnimationListener;

public class AnimationPoint
  extends View
{
  protected int a;
  protected long a;
  protected Paint a;
  protected Handler a;
  AccelerateDecelerateInterpolator jdField_a_of_type_AndroidViewAnimationAccelerateDecelerateInterpolator;
  protected Animation.AnimationListener a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new AnimationPoint.1(this);
  protected boolean a;
  protected int b;
  protected long b;
  protected boolean b;
  protected int c;
  protected long c;
  protected int d;
  protected long d;
  
  public AnimationPoint(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AnimationPoint(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AnimationPoint(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-1);
    this.jdField_d_of_type_Long = 1000L;
    this.jdField_a_of_type_Long = (this.jdField_d_of_type_Long * 2L);
    this.jdField_b_of_type_Long = 2000L;
    this.jdField_a_of_type_AndroidViewAnimationAccelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
  }
  
  protected float a(long paramLong)
  {
    long l = this.jdField_d_of_type_Long;
    paramLong %= l;
    float f;
    if (paramLong < l * 16L / 100L) {
      f = (float)paramLong * 1.0F;
    }
    for (paramLong = l * 16L / 100L;; paramLong = l * 40L / 100L)
    {
      return f / (float)paramLong;
      if (paramLong < 60L * l / 100L) {
        return 1.0F;
      }
      f = (float)(l - paramLong) * 1.0F;
    }
  }
  
  protected int a(long paramLong)
  {
    AccelerateDecelerateInterpolator localAccelerateDecelerateInterpolator = this.jdField_a_of_type_AndroidViewAnimationAccelerateDecelerateInterpolator;
    long l = this.jdField_d_of_type_Long;
    float f = localAccelerateDecelerateInterpolator.getInterpolation((float)(paramLong % l) / (float)l);
    int i;
    if (this.jdField_a_of_type_Boolean) {
      i = this.jdField_c_of_type_Int;
    } else {
      i = this.jdField_b_of_type_Int;
    }
    i -= this.jdField_a_of_type_Int * 2;
    if (paramLong > this.jdField_d_of_type_Long) {
      this.jdField_d_of_type_Int = (this.jdField_a_of_type_Int + (int)(i * f));
    } else {
      this.jdField_d_of_type_Int = (this.jdField_a_of_type_Int + i - (int)(i * f));
    }
    return this.jdField_d_of_type_Int;
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Long = SystemClock.uptimeMillis();
    this.jdField_b_of_type_Int = super.getWidth();
    this.jdField_c_of_type_Int = super.getHeight();
    Animation.AnimationListener localAnimationListener = this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener;
    if (localAnimationListener != null) {
      localAnimationListener.onAnimationStart(null);
    }
    this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  protected float b(long paramLong)
  {
    long l = this.jdField_d_of_type_Long;
    paramLong %= l;
    if (paramLong < l * 16L / 100L) {
      return 0.0F;
    }
    float f;
    if (paramLong < 24L * l / 100L) {
      f = (float)(paramLong - 16L * l / 100L) * 0.4F;
    }
    for (paramLong = l * 8L / 100L;; paramLong = l * 36L / 100L)
    {
      return f / (float)paramLong;
      if (paramLong >= l * 60L / 100L) {
        break;
      }
      f = (float)(60L * l / 100L - paramLong) * 0.4F;
    }
    return 0.0F;
  }
  
  protected int b(long paramLong)
  {
    if (paramLong < this.jdField_d_of_type_Long) {
      return this.jdField_d_of_type_Int + this.jdField_a_of_type_Int / 2;
    }
    return this.jdField_d_of_type_Int - this.jdField_a_of_type_Int / 2;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_b_of_type_Boolean = true;
  }
  
  protected float c(long paramLong)
  {
    long l = this.jdField_d_of_type_Long;
    paramLong %= l;
    if (paramLong < l * 24L / 100L) {
      return 0.0F;
    }
    float f;
    if (paramLong < 36L * l / 100L) {
      f = (float)(paramLong - 24L * l / 100L) * 0.2F;
    }
    for (paramLong = l * 12L / 100L;; paramLong = l * 24L / 100L)
    {
      return f / (float)paramLong;
      if (paramLong >= l * 60L / 100L) {
        break;
      }
      f = (float)(60L * l / 100L - paramLong) * 0.2F;
    }
    return 0.0F;
  }
  
  protected int c(long paramLong)
  {
    if (paramLong < this.jdField_d_of_type_Long) {
      return this.jdField_d_of_type_Int + this.jdField_a_of_type_Int;
    }
    return this.jdField_d_of_type_Int - this.jdField_a_of_type_Int;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.jdField_b_of_type_Int = super.getWidth();
    this.jdField_c_of_type_Int = super.getHeight();
    int j = this.jdField_b_of_type_Int / 2;
    int k = this.jdField_c_of_type_Int / 2;
    long l = (SystemClock.uptimeMillis() - this.jdField_c_of_type_Long) % this.jdField_a_of_type_Long;
    int m = a(l);
    int n = b(l);
    int i1 = c(l);
    float f1 = a(l);
    float f2 = b(l);
    float f3 = c(l);
    if (this.jdField_a_of_type_Int == 0)
    {
      int i;
      if (this.jdField_a_of_type_Boolean) {
        i = this.jdField_b_of_type_Int;
      } else {
        i = this.jdField_c_of_type_Int;
      }
      this.jdField_a_of_type_Int = (i / 2);
    }
    if (f3 != 0.0F)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha((int)(f3 * 255.0F));
      if (this.jdField_a_of_type_Boolean) {
        paramCanvas.drawCircle(j, i1, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidGraphicsPaint);
      } else {
        paramCanvas.drawCircle(i1, k, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
    }
    if (f2 != 0.0F)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha((int)(f2 * 255.0F));
      if (this.jdField_a_of_type_Boolean) {
        paramCanvas.drawCircle(j, n, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidGraphicsPaint);
      } else {
        paramCanvas.drawCircle(n, k, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
    }
    if (f1 != 0.0F)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha((int)(f1 * 255.0F));
      if (this.jdField_a_of_type_Boolean)
      {
        paramCanvas.drawCircle(j, m, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidGraphicsPaint);
        return;
      }
      paramCanvas.drawCircle(m, k, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  public void setDuration(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public void setIsVertical(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    if (localLayoutParams != null)
    {
      int i = localLayoutParams.width;
      localLayoutParams.width = localLayoutParams.height;
      localLayoutParams.height = i;
      setLayoutParams(localLayoutParams);
    }
  }
  
  public void setLoopTime(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_d_of_type_Long = (paramLong / 2L);
  }
  
  public void setOnAnimationListener(Animation.AnimationListener paramAnimationListener)
  {
    this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = paramAnimationListener;
  }
  
  public void setRadius(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.AnimationPoint
 * JD-Core Version:    0.7.0.1
 */
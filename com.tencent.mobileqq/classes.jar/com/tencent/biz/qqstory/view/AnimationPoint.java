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
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
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
    float f = 1.0F;
    paramLong %= this.jdField_d_of_type_Long;
    if (paramLong < this.jdField_d_of_type_Long * 16L / 100L) {
      f = 1.0F * (float)paramLong / (float)(this.jdField_d_of_type_Long * 16L / 100L);
    }
    while (paramLong < 60L * this.jdField_d_of_type_Long / 100L) {
      return f;
    }
    return 1.0F * (float)(this.jdField_d_of_type_Long - paramLong) / (float)(40L * this.jdField_d_of_type_Long / 100L);
  }
  
  protected int a(long paramLong)
  {
    float f = this.jdField_a_of_type_AndroidViewAnimationAccelerateDecelerateInterpolator.getInterpolation((float)(paramLong % this.jdField_d_of_type_Long) / (float)this.jdField_d_of_type_Long);
    int i;
    int j;
    if (this.jdField_a_of_type_Boolean)
    {
      i = this.jdField_c_of_type_Int - this.jdField_a_of_type_Int * 2;
      if (paramLong <= this.jdField_d_of_type_Long) {
        break label90;
      }
      j = this.jdField_a_of_type_Int;
    }
    label90:
    for (this.jdField_d_of_type_Int = ((int)(i * f) + j);; this.jdField_d_of_type_Int = (this.jdField_a_of_type_Int + i - (int)(i * f)))
    {
      return this.jdField_d_of_type_Int;
      i = this.jdField_b_of_type_Int - this.jdField_a_of_type_Int * 2;
      break;
    }
  }
  
  public void a()
  {
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Long = SystemClock.uptimeMillis();
    this.jdField_b_of_type_Int = super.getWidth();
    this.jdField_c_of_type_Int = super.getHeight();
    if (this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener != null) {
      this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener.onAnimationStart(null);
    }
    this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  protected float b(long paramLong)
  {
    paramLong %= this.jdField_d_of_type_Long;
    if (paramLong < 16L * this.jdField_d_of_type_Long / 100L) {
      return 0.0F;
    }
    if (paramLong < 24L * this.jdField_d_of_type_Long / 100L) {
      return (float)(paramLong - 16L * this.jdField_d_of_type_Long / 100L) * 0.4F / (float)(8L * this.jdField_d_of_type_Long / 100L);
    }
    if (paramLong < 60L * this.jdField_d_of_type_Long / 100L) {
      return (float)(60L * this.jdField_d_of_type_Long / 100L - paramLong) * 0.4F / (float)(36L * this.jdField_d_of_type_Long / 100L);
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
    paramLong %= this.jdField_d_of_type_Long;
    if (paramLong < 24L * this.jdField_d_of_type_Long / 100L) {
      return 0.0F;
    }
    if (paramLong < 36L * this.jdField_d_of_type_Long / 100L) {
      return (float)(paramLong - 24L * this.jdField_d_of_type_Long / 100L) * 0.2F / (float)(12L * this.jdField_d_of_type_Long / 100L);
    }
    if (paramLong < 60L * this.jdField_d_of_type_Long / 100L) {
      return (float)(60L * this.jdField_d_of_type_Long / 100L - paramLong) * 0.2F / (float)(24L * this.jdField_d_of_type_Long / 100L);
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
    int i;
    if (this.jdField_a_of_type_Int == 0)
    {
      if (this.jdField_a_of_type_Boolean)
      {
        i = this.jdField_b_of_type_Int / 2;
        this.jdField_a_of_type_Int = i;
      }
    }
    else
    {
      if (f3 != 0.0F)
      {
        this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha((int)(f3 * 255.0F));
        if (!this.jdField_a_of_type_Boolean) {
          break label272;
        }
        paramCanvas.drawCircle(j, i1, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      label172:
      if (f2 != 0.0F)
      {
        this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha((int)(f2 * 255.0F));
        if (!this.jdField_a_of_type_Boolean) {
          break label294;
        }
        paramCanvas.drawCircle(j, n, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
    }
    for (;;)
    {
      if (f1 != 0.0F)
      {
        this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha((int)(f1 * 255.0F));
        if (!this.jdField_a_of_type_Boolean) {
          break label316;
        }
        paramCanvas.drawCircle(j, m, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidGraphicsPaint);
      }
      return;
      i = this.jdField_c_of_type_Int / 2;
      break;
      label272:
      paramCanvas.drawCircle(i1, k, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidGraphicsPaint);
      break label172;
      label294:
      paramCanvas.drawCircle(n, k, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    label316:
    paramCanvas.drawCircle(m, k, this.jdField_a_of_type_Int, this.jdField_a_of_type_AndroidGraphicsPaint);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.AnimationPoint
 * JD-Core Version:    0.7.0.1
 */
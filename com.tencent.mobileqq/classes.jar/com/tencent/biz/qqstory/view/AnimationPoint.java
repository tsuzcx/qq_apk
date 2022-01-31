package com.tencent.biz.qqstory.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation.AnimationListener;
import ouj;

public class AnimationPoint
  extends View
{
  protected int a;
  protected long a;
  protected Paint a;
  public Handler a;
  AccelerateDecelerateInterpolator jdField_a_of_type_AndroidViewAnimationAccelerateDecelerateInterpolator;
  public Animation.AnimationListener a;
  private Runnable jdField_a_of_type_JavaLangRunnable = new ouj(this);
  public boolean a;
  protected int b;
  public long b;
  protected int c;
  public long c;
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
    this.d = 1000L;
    this.jdField_a_of_type_Long = (this.d * 2L);
    this.jdField_b_of_type_Long = 2000L;
    this.jdField_a_of_type_AndroidViewAnimationAccelerateDecelerateInterpolator = new AccelerateDecelerateInterpolator();
  }
  
  protected float a(long paramLong)
  {
    float f = 1.0F;
    paramLong %= this.d;
    if (paramLong < this.d * 16L / 100L) {
      f = 1.0F * (float)paramLong / (float)(this.d * 16L / 100L);
    }
    while (paramLong < 60L * this.d / 100L) {
      return f;
    }
    return 1.0F * (float)(this.d - paramLong) / (float)(40L * this.d / 100L);
  }
  
  protected int a(long paramLong)
  {
    float f = this.jdField_a_of_type_AndroidViewAnimationAccelerateDecelerateInterpolator.getInterpolation((float)(paramLong % this.d) / (float)this.d);
    int i = this.jdField_a_of_type_Int - this.jdField_b_of_type_Int;
    int j;
    if (paramLong > this.d) {
      j = this.jdField_b_of_type_Int / 2;
    }
    for (this.jdField_c_of_type_Int = ((int)(f * i) + j);; this.jdField_c_of_type_Int = (this.jdField_b_of_type_Int / 2 + i - (int)(f * i))) {
      return this.jdField_c_of_type_Int;
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_Int = super.getWidth();
    this.jdField_b_of_type_Int = super.getHeight();
    if (this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener != null) {
      this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener.onAnimationStart(null);
    }
    this.jdField_a_of_type_AndroidOsHandler.post(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  protected float b(long paramLong)
  {
    paramLong %= this.d;
    if (paramLong < 16L * this.d / 100L) {
      return 0.0F;
    }
    if (paramLong < 24L * this.d / 100L) {
      return (float)(paramLong - 16L * this.d / 100L) * 0.4F / (float)(8L * this.d / 100L);
    }
    if (paramLong < 60L * this.d / 100L) {
      return (float)(60L * this.d / 100L - paramLong) * 0.4F / (float)(36L * this.d / 100L);
    }
    return 0.0F;
  }
  
  protected int b(long paramLong)
  {
    if (paramLong < this.d) {
      return this.jdField_c_of_type_Int + this.jdField_b_of_type_Int / 4;
    }
    return this.jdField_c_of_type_Int - this.jdField_b_of_type_Int / 4;
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_Boolean = true;
  }
  
  protected float c(long paramLong)
  {
    paramLong %= this.d;
    if (paramLong < 24L * this.d / 100L) {
      return 0.0F;
    }
    if (paramLong < 36L * this.d / 100L) {
      return (float)(paramLong - 24L * this.d / 100L) * 0.2F / (float)(12L * this.d / 100L);
    }
    if (paramLong < 60L * this.d / 100L) {
      return (float)(60L * this.d / 100L - paramLong) * 0.2F / (float)(24L * this.d / 100L);
    }
    return 0.0F;
  }
  
  protected int c(long paramLong)
  {
    if (paramLong < this.d) {
      return this.jdField_c_of_type_Int + this.jdField_b_of_type_Int / 2;
    }
    return this.jdField_c_of_type_Int - this.jdField_b_of_type_Int / 2;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.jdField_a_of_type_Int = super.getWidth();
    this.jdField_b_of_type_Int = super.getHeight();
    int i = this.jdField_b_of_type_Int / 2;
    long l = (System.currentTimeMillis() - this.jdField_c_of_type_Long) % this.jdField_a_of_type_Long;
    int j = a(l);
    int k = b(l);
    int m = c(l);
    float f1 = a(l);
    float f2 = b(l);
    float f3 = c(l);
    if (f3 != 0.0F)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha((int)(f3 * 255.0F));
      paramCanvas.drawCircle(m, i, this.jdField_b_of_type_Int / 2, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    if (f2 != 0.0F)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha((int)(f2 * 255.0F));
      paramCanvas.drawCircle(k, i, this.jdField_b_of_type_Int / 2, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    if (f1 != 0.0F)
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setAlpha((int)(f1 * 255.0F));
      paramCanvas.drawCircle(j, i, this.jdField_b_of_type_Int / 2, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  public void setDuration(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
  }
  
  public void setLoopTime(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.d = (paramLong / 2L);
  }
  
  public void setOnAnimationListener(Animation.AnimationListener paramAnimationListener)
  {
    this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = paramAnimationListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.AnimationPoint
 * JD-Core Version:    0.7.0.1
 */
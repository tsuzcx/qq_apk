package com.tencent.biz.pubaccount.readinjoy.video;

import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.Shader.TileMode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.AccelerateDecelerateInterpolator;
import bdaq;
import rdj;
import rdk;
import rdl;

public class VideoFeedsGuideView
  extends View
{
  public static final int[] a;
  public int a;
  private AnimatorSet jdField_a_of_type_AndroidAnimationAnimatorSet;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private Rect jdField_a_of_type_AndroidGraphicsRect;
  private rdj jdField_a_of_type_Rdj;
  private rdk jdField_a_of_type_Rdk;
  private rdl jdField_a_of_type_Rdl;
  public int b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i = 0;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { -1, 16777215 };
  }
  
  public VideoFeedsGuideView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VideoFeedsGuideView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VideoFeedsGuideView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private int a(int paramInt, boolean paramBoolean)
  {
    int j = View.MeasureSpec.getSize(paramInt);
    if (paramBoolean) {}
    for (paramInt = this.jdField_a_of_type_Int; j < paramInt; paramInt = this.b) {
      return paramInt;
    }
    return j;
  }
  
  private void a()
  {
    this.b = bdaq.a(getContext(), 150.0F);
    this.jdField_a_of_type_Int = bdaq.a(getContext(), 180.0F);
    this.c = bdaq.a(getContext(), 8.0F);
    this.e = bdaq.a(getContext(), 70.0F);
    this.g = bdaq.a(getContext(), 70.0F);
    this.d = this.e;
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsRect = new Rect();
    this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(getResources(), 2130842721);
    this.jdField_a_of_type_Rdj = new rdj(this, null);
    this.jdField_a_of_type_Rdk = new rdk(this, null);
    this.jdField_a_of_type_Rdl = new rdl(this, null);
  }
  
  private void a(Canvas paramCanvas)
  {
    b(paramCanvas);
    c(paramCanvas);
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.i == 1)
    {
      this.f = 0;
      this.e = this.d;
    }
    for (;;)
    {
      invalidate();
      if (paramBoolean) {
        this.jdField_a_of_type_Rdj.sendEmptyMessageDelayed(0, 300L);
      }
      return;
      this.h = 0;
      this.g = this.d;
    }
  }
  
  private void b()
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this, "alpha", new float[] { 0.0F, 1.0F });
    localObjectAnimator.setDuration(200L);
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 0, this.d });
    localValueAnimator.addUpdateListener(this.jdField_a_of_type_Rdl);
    localValueAnimator.setDuration(500L);
    localValueAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
    AnimatorSet localAnimatorSet = new AnimatorSet();
    localAnimatorSet.play(localValueAnimator).after(localObjectAnimator);
    localObjectAnimator = ObjectAnimator.ofFloat(this, "alpha", new float[] { 1.0F, 0.0F });
    localObjectAnimator.setDuration(200L);
    localObjectAnimator.setStartDelay(400L);
    this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.play(localObjectAnimator).after(localAnimatorSet);
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.addListener(this.jdField_a_of_type_Rdk);
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.start();
  }
  
  private void b(Canvas paramCanvas)
  {
    int j = getWidth() / 3;
    int k = getHeight() - this.e + 10;
    int m = this.c;
    int n = getHeight();
    LinearGradient localLinearGradient = new LinearGradient(0.0F, k, 0.0F, n, jdField_a_of_type_ArrayOfInt, null, Shader.TileMode.CLAMP);
    this.jdField_a_of_type_AndroidGraphicsPaint.setShader(localLinearGradient);
    this.jdField_a_of_type_AndroidGraphicsRect.set(j, k, j + m, n);
    paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  private void c(Canvas paramCanvas)
  {
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, getWidth() / 3, getHeight() - this.f - this.d, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  private void d(Canvas paramCanvas)
  {
    e(paramCanvas);
    f(paramCanvas);
  }
  
  private void e(Canvas paramCanvas)
  {
    int j = getWidth() * 5 / 6 - this.g + 10;
    int k = getHeight() - this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight();
    int m = getWidth();
    int n = this.c;
    LinearGradient localLinearGradient = new LinearGradient(j, 0.0F, m, 0.0F, jdField_a_of_type_ArrayOfInt, null, Shader.TileMode.CLAMP);
    this.jdField_a_of_type_AndroidGraphicsPaint.setShader(localLinearGradient);
    this.jdField_a_of_type_AndroidGraphicsRect.set(j, k, m, k + n);
    paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  private void f(Canvas paramCanvas)
  {
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, getWidth() * 5 / 6 - this.h - this.d, getHeight() - this.jdField_a_of_type_AndroidGraphicsBitmap.getHeight(), this.jdField_a_of_type_AndroidGraphicsPaint);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.i == 0) {
      return;
    }
    if (this.i == 1)
    {
      a(paramCanvas);
      return;
    }
    d(paramCanvas);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(a(paramInt1, true), a(paramInt2, false));
  }
  
  public void setCurrentMode(int paramInt)
  {
    this.i = paramInt;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsGuideView
 * JD-Core Version:    0.7.0.1
 */
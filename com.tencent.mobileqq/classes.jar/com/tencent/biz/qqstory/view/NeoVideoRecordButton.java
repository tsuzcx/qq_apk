package com.tencent.biz.qqstory.view;

import android.animation.AnimatorSet;
import android.animation.AnimatorSet.Builder;
import android.animation.ArgbEvaluator;
import android.animation.IntEvaluator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint.Style;
import android.os.Looper;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.animation.DecelerateInterpolator;
import zfv;
import zfw;
import zfx;
import zga;

@TargetApi(11)
public class NeoVideoRecordButton
  extends RingView
{
  public float a;
  final int a;
  public AnimatorSet a;
  public ValueAnimator a;
  public zga a;
  final int b;
  public ValueAnimator b;
  public zga b;
  final int c;
  public ValueAnimator c;
  public zga c;
  final int d;
  final int e;
  final int f;
  
  public NeoVideoRecordButton(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public NeoVideoRecordButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Float = 0.0F;
    this.jdField_a_of_type_Int = a(paramContext, 37.5F);
    this.jdField_b_of_type_Int = a(paramContext, 6.0F);
    this.jdField_c_of_type_Int = a(paramContext, 1.0F);
    this.f = a(paramContext, 45.5F);
    this.e = a(paramContext, 6.0F);
    this.d = a(paramContext, 31.799999F);
    paramContext = new zga(-90, 270, this.jdField_a_of_type_Int, 0.0F, this.jdField_b_of_type_Int, 0.0F, -15550475, -1, Paint.Style.STROKE);
    this.jdField_a_of_type_Zga = paramContext;
    super.a(paramContext);
    paramContext = new zga(-90, 270, 1, 0.0F, 1, 0.0F, 1090519039, 0, Paint.Style.FILL);
    this.jdField_c_of_type_Zga = paramContext;
    super.a(paramContext);
    paramContext = new zga(-90, 270, this.jdField_c_of_type_Int, 0.0F, 1, 0.0F, -1, 0, Paint.Style.FILL);
    this.jdField_b_of_type_Zga = paramContext;
    super.a(paramContext);
    this.jdField_a_of_type_AndroidAnimationValueAnimator = new ValueAnimator();
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setValues(new PropertyValuesHolder[] { PropertyValuesHolder.ofObject("border", new IntEvaluator(), new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(this.f) }), PropertyValuesHolder.ofObject("ring", new IntEvaluator(), new Object[] { Integer.valueOf(this.jdField_b_of_type_Int), Integer.valueOf(this.e) }), PropertyValuesHolder.ofObject("center", new IntEvaluator(), new Object[] { Integer.valueOf(this.jdField_c_of_type_Int), Integer.valueOf(this.d) }), PropertyValuesHolder.ofObject("color", new ArgbEvaluator(), new Object[] { Integer.valueOf(-1), Integer.valueOf(-15550475) }) });
    this.jdField_a_of_type_AndroidAnimationValueAnimator.setDuration(400L);
    this.jdField_a_of_type_AndroidAnimationValueAnimator.addUpdateListener(new zfv(this));
    this.jdField_b_of_type_AndroidAnimationValueAnimator = new ValueAnimator();
    this.jdField_b_of_type_AndroidAnimationValueAnimator.setValues(new PropertyValuesHolder[] { PropertyValuesHolder.ofObject("radius", new IntEvaluator(), new Object[] { Integer.valueOf(1), Integer.valueOf(this.f - this.jdField_b_of_type_Int) }), PropertyValuesHolder.ofObject("color", new ArgbEvaluator(), new Object[] { Integer.valueOf(16777215), Integer.valueOf(16777215), Integer.valueOf(16777215), Integer.valueOf(2147483647), Integer.valueOf(16777215) }) });
    this.jdField_b_of_type_AndroidAnimationValueAnimator.setInterpolator(new DecelerateInterpolator());
    this.jdField_b_of_type_AndroidAnimationValueAnimator.setDuration(1500L);
    this.jdField_b_of_type_AndroidAnimationValueAnimator.setRepeatCount(-1);
    this.jdField_b_of_type_AndroidAnimationValueAnimator.setRepeatMode(1);
    this.jdField_b_of_type_AndroidAnimationValueAnimator.addUpdateListener(new zfw(this));
    this.jdField_a_of_type_AndroidAnimationAnimatorSet = new AnimatorSet();
    this.jdField_a_of_type_AndroidAnimationAnimatorSet.play(this.jdField_a_of_type_AndroidAnimationValueAnimator).before(this.jdField_b_of_type_AndroidAnimationValueAnimator);
    this.jdField_c_of_type_AndroidAnimationValueAnimator = new ValueAnimator();
    this.jdField_c_of_type_AndroidAnimationValueAnimator.setDuration(400L);
    this.jdField_c_of_type_AndroidAnimationValueAnimator.addUpdateListener(new zfx(this));
    setProgress(this.jdField_a_of_type_Float);
    this.jdField_b_of_type_Zga.a();
    this.jdField_c_of_type_Zga.a();
  }
  
  public static float a(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().density;
  }
  
  private int a(float paramFloat)
  {
    if (paramFloat <= 0.0F) {
      return -90;
    }
    float f1 = paramFloat;
    if (paramFloat > 1.0F) {
      f1 = paramFloat - 1.0F;
    }
    return (int)(360.0F * f1) - 90;
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(a(paramContext) * paramFloat + 0.5F);
  }
  
  private void b()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      super.invalidate();
      return;
    }
    super.postInvalidate();
  }
  
  public void setProgress(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    this.jdField_a_of_type_Zga.d = a(this.jdField_a_of_type_Float);
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.NeoVideoRecordButton
 * JD-Core Version:    0.7.0.1
 */
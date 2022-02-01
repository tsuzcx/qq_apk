package com.google.android.material.progressindicator;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.Property;
import android.view.animation.Interpolator;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback;
import androidx.vectordrawable.graphics.drawable.AnimationUtilsCompat;
import com.google.android.material.R.animator;
import com.google.android.material.color.MaterialColors;
import java.util.Arrays;

final class LinearIndeterminateDisjointAnimatorDelegate
  extends IndeterminateAnimatorDelegate<ObjectAnimator>
{
  private static final Property<LinearIndeterminateDisjointAnimatorDelegate, Float> jdField_a_of_type_AndroidUtilProperty = new LinearIndeterminateDisjointAnimatorDelegate.2(Float.class, "animationFraction");
  private static final int[] jdField_b_of_type_ArrayOfInt = { 533, 567, 850, 750 };
  private static final int[] c = { 1267, 1000, 333, 0 };
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 0;
  private ObjectAnimator jdField_a_of_type_AndroidAnimationObjectAnimator;
  Animatable2Compat.AnimationCallback jdField_a_of_type_AndroidxVectordrawableGraphicsDrawableAnimatable2Compat$AnimationCallback = null;
  private final BaseProgressIndicatorSpec jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec;
  private boolean jdField_a_of_type_Boolean;
  private final Interpolator[] jdField_a_of_type_ArrayOfAndroidViewAnimationInterpolator;
  private boolean jdField_b_of_type_Boolean;
  
  public LinearIndeterminateDisjointAnimatorDelegate(@NonNull Context paramContext, @NonNull LinearProgressIndicatorSpec paramLinearProgressIndicatorSpec)
  {
    super(2);
    this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec = paramLinearProgressIndicatorSpec;
    this.jdField_a_of_type_ArrayOfAndroidViewAnimationInterpolator = new Interpolator[] { AnimationUtilsCompat.loadInterpolator(paramContext, R.animator.c), AnimationUtilsCompat.loadInterpolator(paramContext, R.animator.d), AnimationUtilsCompat.loadInterpolator(paramContext, R.animator.e), AnimationUtilsCompat.loadInterpolator(paramContext, R.animator.f) };
  }
  
  private float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  private void a(int paramInt)
  {
    int i = 0;
    while (i < 4)
    {
      float f = a(paramInt, c[i], jdField_b_of_type_ArrayOfInt[i]);
      f = this.jdField_a_of_type_ArrayOfAndroidViewAnimationInterpolator[i].getInterpolation(f);
      this.jdField_a_of_type_ArrayOfFloat[i] = Math.max(0.0F, Math.min(1.0F, f));
      i += 1;
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidAnimationObjectAnimator == null)
    {
      this.jdField_a_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this, jdField_a_of_type_AndroidUtilProperty, new float[] { 0.0F, 1.0F });
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.setDuration(1800L);
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.setInterpolator(null);
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.setRepeatCount(-1);
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.addListener(new LinearIndeterminateDisjointAnimatorDelegate.1(this));
    }
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_Boolean)
    {
      Arrays.fill(this.jdField_a_of_type_ArrayOfInt, MaterialColors.b(this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec.jdField_a_of_type_ArrayOfInt[this.jdField_a_of_type_Int], this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorIndeterminateDrawable.getAlpha()));
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  public void a()
  {
    g();
    f();
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
  }
  
  @VisibleForTesting
  void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    a((int)(this.jdField_a_of_type_Float * 1800.0F));
    h();
    this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorIndeterminateDrawable.invalidateSelf();
  }
  
  public void a(@NonNull Animatable2Compat.AnimationCallback paramAnimationCallback)
  {
    this.jdField_a_of_type_AndroidxVectordrawableGraphicsDrawableAnimatable2Compat$AnimationCallback = paramAnimationCallback;
  }
  
  public void b()
  {
    ObjectAnimator localObjectAnimator = this.jdField_a_of_type_AndroidAnimationObjectAnimator;
    if (localObjectAnimator != null) {
      localObjectAnimator.cancel();
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorIndeterminateDrawable.isVisible())
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.setRepeatCount(0);
      return;
    }
    b();
  }
  
  public void d()
  {
    f();
  }
  
  public void e()
  {
    this.jdField_a_of_type_AndroidxVectordrawableGraphicsDrawableAnimatable2Compat$AnimationCallback = null;
  }
  
  @VisibleForTesting
  void f()
  {
    this.jdField_a_of_type_Int = 0;
    int i = MaterialColors.b(this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec.jdField_a_of_type_ArrayOfInt[0], this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorIndeterminateDrawable.getAlpha());
    this.jdField_a_of_type_ArrayOfInt[0] = i;
    this.jdField_a_of_type_ArrayOfInt[1] = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.progressindicator.LinearIndeterminateDisjointAnimatorDelegate
 * JD-Core Version:    0.7.0.1
 */
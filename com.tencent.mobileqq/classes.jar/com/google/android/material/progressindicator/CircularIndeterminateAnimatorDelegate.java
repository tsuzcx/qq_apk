package com.google.android.material.progressindicator;

import android.animation.ObjectAnimator;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback;
import com.google.android.material.animation.ArgbEvaluatorCompat;
import com.google.android.material.color.MaterialColors;

final class CircularIndeterminateAnimatorDelegate
  extends IndeterminateAnimatorDelegate<ObjectAnimator>
{
  private static final Property<CircularIndeterminateAnimatorDelegate, Float> jdField_a_of_type_AndroidUtilProperty = new CircularIndeterminateAnimatorDelegate.3(Float.class, "animationFraction");
  private static final Property<CircularIndeterminateAnimatorDelegate, Float> jdField_b_of_type_AndroidUtilProperty = new CircularIndeterminateAnimatorDelegate.4(Float.class, "completeEndFraction");
  private static final int[] jdField_b_of_type_ArrayOfInt = { 0, 1350, 2700, 4050 };
  private static final int[] c = { 667, 2017, 3367, 4717 };
  private static final int[] d = { 1000, 2350, 3700, 5050 };
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 0;
  private ObjectAnimator jdField_a_of_type_AndroidAnimationObjectAnimator;
  private final FastOutSlowInInterpolator jdField_a_of_type_AndroidxInterpolatorViewAnimationFastOutSlowInInterpolator;
  Animatable2Compat.AnimationCallback jdField_a_of_type_AndroidxVectordrawableGraphicsDrawableAnimatable2Compat$AnimationCallback = null;
  private final BaseProgressIndicatorSpec jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec;
  private float jdField_b_of_type_Float;
  private ObjectAnimator jdField_b_of_type_AndroidAnimationObjectAnimator;
  
  public CircularIndeterminateAnimatorDelegate(@NonNull CircularProgressIndicatorSpec paramCircularProgressIndicatorSpec)
  {
    super(1);
    this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec = paramCircularProgressIndicatorSpec;
    this.jdField_a_of_type_AndroidxInterpolatorViewAnimationFastOutSlowInInterpolator = new FastOutSlowInInterpolator();
  }
  
  private float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_ArrayOfFloat[0] = (this.jdField_a_of_type_Float * 1520.0F - 20.0F);
    this.jdField_a_of_type_ArrayOfFloat[1] = (this.jdField_a_of_type_Float * 1520.0F);
    int i = 0;
    while (i < 4)
    {
      float f = a(paramInt, jdField_b_of_type_ArrayOfInt[i], 667);
      arrayOfFloat = this.jdField_a_of_type_ArrayOfFloat;
      arrayOfFloat[1] += this.jdField_a_of_type_AndroidxInterpolatorViewAnimationFastOutSlowInInterpolator.getInterpolation(f) * 250.0F;
      f = a(paramInt, c[i], 667);
      arrayOfFloat = this.jdField_a_of_type_ArrayOfFloat;
      arrayOfFloat[0] += this.jdField_a_of_type_AndroidxInterpolatorViewAnimationFastOutSlowInInterpolator.getInterpolation(f) * 250.0F;
      i += 1;
    }
    float[] arrayOfFloat = this.jdField_a_of_type_ArrayOfFloat;
    arrayOfFloat[0] += (this.jdField_a_of_type_ArrayOfFloat[1] - this.jdField_a_of_type_ArrayOfFloat[0]) * this.jdField_b_of_type_Float;
    arrayOfFloat = this.jdField_a_of_type_ArrayOfFloat;
    arrayOfFloat[0] /= 360.0F;
    arrayOfFloat = this.jdField_a_of_type_ArrayOfFloat;
    arrayOfFloat[1] /= 360.0F;
  }
  
  private float b()
  {
    return this.jdField_b_of_type_Float;
  }
  
  private void b(float paramFloat)
  {
    this.jdField_b_of_type_Float = paramFloat;
  }
  
  private void b(int paramInt)
  {
    int i = 0;
    while (i < 4)
    {
      float f = a(paramInt, d[i], 333);
      if ((f >= 0.0F) && (f <= 1.0F))
      {
        i = (i + this.jdField_a_of_type_Int) % this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec.jdField_a_of_type_ArrayOfInt.length;
        int j = this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec.jdField_a_of_type_ArrayOfInt.length;
        paramInt = MaterialColors.b(this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec.jdField_a_of_type_ArrayOfInt[i], this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorIndeterminateDrawable.getAlpha());
        i = MaterialColors.b(this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec.jdField_a_of_type_ArrayOfInt[((i + 1) % j)], this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorIndeterminateDrawable.getAlpha());
        f = this.jdField_a_of_type_AndroidxInterpolatorViewAnimationFastOutSlowInInterpolator.getInterpolation(f);
        this.jdField_a_of_type_ArrayOfInt[0] = ArgbEvaluatorCompat.a().a(f, Integer.valueOf(paramInt), Integer.valueOf(i)).intValue();
        return;
      }
      i += 1;
    }
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidAnimationObjectAnimator == null)
    {
      this.jdField_a_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this, jdField_a_of_type_AndroidUtilProperty, new float[] { 0.0F, 1.0F });
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.setDuration(5400L);
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.setInterpolator(null);
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.setRepeatCount(-1);
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.addListener(new CircularIndeterminateAnimatorDelegate.1(this));
    }
    if (this.jdField_b_of_type_AndroidAnimationObjectAnimator == null)
    {
      this.jdField_b_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this, jdField_b_of_type_AndroidUtilProperty, new float[] { 0.0F, 1.0F });
      this.jdField_b_of_type_AndroidAnimationObjectAnimator.setDuration(333L);
      this.jdField_b_of_type_AndroidAnimationObjectAnimator.setInterpolator(this.jdField_a_of_type_AndroidxInterpolatorViewAnimationFastOutSlowInInterpolator);
      this.jdField_b_of_type_AndroidAnimationObjectAnimator.addListener(new CircularIndeterminateAnimatorDelegate.2(this));
    }
  }
  
  void a()
  {
    g();
    f();
    this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
  }
  
  @VisibleForTesting
  void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
    int i = (int)(this.jdField_a_of_type_Float * 5400.0F);
    a(i);
    b(i);
    this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorIndeterminateDrawable.invalidateSelf();
  }
  
  public void a(@NonNull Animatable2Compat.AnimationCallback paramAnimationCallback)
  {
    this.jdField_a_of_type_AndroidxVectordrawableGraphicsDrawableAnimatable2Compat$AnimationCallback = paramAnimationCallback;
  }
  
  void b()
  {
    ObjectAnimator localObjectAnimator = this.jdField_a_of_type_AndroidAnimationObjectAnimator;
    if (localObjectAnimator != null) {
      localObjectAnimator.cancel();
    }
  }
  
  void c()
  {
    if (this.jdField_b_of_type_AndroidAnimationObjectAnimator.isRunning()) {
      return;
    }
    if (this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorIndeterminateDrawable.isVisible())
    {
      this.jdField_b_of_type_AndroidAnimationObjectAnimator.start();
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
    this.jdField_a_of_type_ArrayOfInt[0] = MaterialColors.b(this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec.jdField_a_of_type_ArrayOfInt[0], this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorIndeterminateDrawable.getAlpha());
    this.jdField_b_of_type_Float = 0.0F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.progressindicator.CircularIndeterminateAnimatorDelegate
 * JD-Core Version:    0.7.0.1
 */
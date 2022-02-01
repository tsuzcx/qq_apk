package com.google.android.material.progressindicator;

import android.animation.ObjectAnimator;
import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback;
import com.google.android.material.color.MaterialColors;
import java.util.Arrays;

final class LinearIndeterminateContiguousAnimatorDelegate
  extends IndeterminateAnimatorDelegate<ObjectAnimator>
{
  private static final Property<LinearIndeterminateContiguousAnimatorDelegate, Float> jdField_a_of_type_AndroidUtilProperty = new LinearIndeterminateContiguousAnimatorDelegate.2(Float.class, "animationFraction");
  private float jdField_a_of_type_Float;
  private int jdField_a_of_type_Int = 1;
  private ObjectAnimator jdField_a_of_type_AndroidAnimationObjectAnimator;
  private FastOutSlowInInterpolator jdField_a_of_type_AndroidxInterpolatorViewAnimationFastOutSlowInInterpolator;
  private final BaseProgressIndicatorSpec jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec;
  private boolean jdField_a_of_type_Boolean;
  
  public LinearIndeterminateContiguousAnimatorDelegate(@NonNull LinearProgressIndicatorSpec paramLinearProgressIndicatorSpec)
  {
    super(3);
    this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec = paramLinearProgressIndicatorSpec;
    this.jdField_a_of_type_AndroidxInterpolatorViewAnimationFastOutSlowInInterpolator = new FastOutSlowInInterpolator();
  }
  
  private float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_ArrayOfFloat[0] = 0.0F;
    float f1 = a(paramInt, 0, 667);
    float[] arrayOfFloat1 = this.jdField_a_of_type_ArrayOfFloat;
    float[] arrayOfFloat2 = this.jdField_a_of_type_ArrayOfFloat;
    float f2 = this.jdField_a_of_type_AndroidxInterpolatorViewAnimationFastOutSlowInInterpolator.getInterpolation(f1);
    arrayOfFloat2[2] = f2;
    arrayOfFloat1[1] = f2;
    arrayOfFloat1 = this.jdField_a_of_type_ArrayOfFloat;
    arrayOfFloat2 = this.jdField_a_of_type_ArrayOfFloat;
    f1 = this.jdField_a_of_type_AndroidxInterpolatorViewAnimationFastOutSlowInInterpolator.getInterpolation(f1 + 0.4992504F);
    arrayOfFloat2[4] = f1;
    arrayOfFloat1[3] = f1;
    this.jdField_a_of_type_ArrayOfFloat[5] = 1.0F;
  }
  
  private void g()
  {
    if (this.jdField_a_of_type_AndroidAnimationObjectAnimator == null)
    {
      this.jdField_a_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this, jdField_a_of_type_AndroidUtilProperty, new float[] { 0.0F, 1.0F });
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.setDuration(333L);
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.setInterpolator(null);
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.setRepeatCount(-1);
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.addListener(new LinearIndeterminateContiguousAnimatorDelegate.1(this));
    }
  }
  
  private void h()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ArrayOfFloat[3] < 1.0F))
    {
      this.jdField_a_of_type_ArrayOfInt[2] = this.jdField_a_of_type_ArrayOfInt[1];
      this.jdField_a_of_type_ArrayOfInt[1] = this.jdField_a_of_type_ArrayOfInt[0];
      this.jdField_a_of_type_ArrayOfInt[0] = MaterialColors.b(this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec.jdField_a_of_type_ArrayOfInt[this.jdField_a_of_type_Int], this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorIndeterminateDrawable.getAlpha());
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
    a((int)(this.jdField_a_of_type_Float * 333.0F));
    h();
    this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorIndeterminateDrawable.invalidateSelf();
  }
  
  public void a(@Nullable Animatable2Compat.AnimationCallback paramAnimationCallback) {}
  
  public void b()
  {
    ObjectAnimator localObjectAnimator = this.jdField_a_of_type_AndroidAnimationObjectAnimator;
    if (localObjectAnimator != null) {
      localObjectAnimator.cancel();
    }
  }
  
  public void c() {}
  
  public void d()
  {
    f();
  }
  
  public void e() {}
  
  @VisibleForTesting
  void f()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 1;
    Arrays.fill(this.jdField_a_of_type_ArrayOfInt, MaterialColors.b(this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorBaseProgressIndicatorSpec.jdField_a_of_type_ArrayOfInt[0], this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorIndeterminateDrawable.getAlpha()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.progressindicator.LinearIndeterminateContiguousAnimatorDelegate
 * JD-Core Version:    0.7.0.1
 */
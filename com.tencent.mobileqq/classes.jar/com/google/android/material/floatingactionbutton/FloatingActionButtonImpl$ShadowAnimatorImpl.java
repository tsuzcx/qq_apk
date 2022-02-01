package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import androidx.annotation.NonNull;
import com.google.android.material.shape.MaterialShapeDrawable;

abstract class FloatingActionButtonImpl$ShadowAnimatorImpl
  extends AnimatorListenerAdapter
  implements ValueAnimator.AnimatorUpdateListener
{
  private float jdField_a_of_type_Float;
  private boolean jdField_a_of_type_Boolean;
  private float jdField_b_of_type_Float;
  
  private FloatingActionButtonImpl$ShadowAnimatorImpl(FloatingActionButtonImpl paramFloatingActionButtonImpl) {}
  
  protected abstract float a();
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.jdField_b_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButtonImpl.e((int)this.jdField_b_of_type_Float);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void onAnimationUpdate(@NonNull ValueAnimator paramValueAnimator)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      if (this.jdField_b_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButtonImpl.a == null) {
        f = 0.0F;
      } else {
        f = this.jdField_b_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButtonImpl.a.k();
      }
      this.jdField_a_of_type_Float = f;
      this.jdField_b_of_type_Float = a();
      this.jdField_a_of_type_Boolean = true;
    }
    FloatingActionButtonImpl localFloatingActionButtonImpl = this.jdField_b_of_type_ComGoogleAndroidMaterialFloatingactionbuttonFloatingActionButtonImpl;
    float f = this.jdField_a_of_type_Float;
    localFloatingActionButtonImpl.e((int)(f + (this.jdField_b_of_type_Float - f) * paramValueAnimator.getAnimatedFraction()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
 * JD-Core Version:    0.7.0.1
 */
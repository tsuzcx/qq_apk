package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import androidx.annotation.Nullable;
import com.google.android.material.R.animator;

class ExtendedFloatingActionButton$HideStrategy
  extends BaseMotionStrategy
{
  private boolean jdField_a_of_type_Boolean;
  
  public ExtendedFloatingActionButton$HideStrategy(ExtendedFloatingActionButton paramExtendedFloatingActionButton, AnimatorTracker paramAnimatorTracker)
  {
    super(paramExtendedFloatingActionButton, paramAnimatorTracker);
  }
  
  public int a()
  {
    return R.animator.i;
  }
  
  public void a()
  {
    super.a();
    ExtendedFloatingActionButton.a(this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonExtendedFloatingActionButton, 0);
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonExtendedFloatingActionButton.setVisibility(8);
    }
  }
  
  public void a(Animator paramAnimator)
  {
    super.a(paramAnimator);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonExtendedFloatingActionButton.setVisibility(0);
    ExtendedFloatingActionButton.a(this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonExtendedFloatingActionButton, 1);
  }
  
  public void a(@Nullable ExtendedFloatingActionButton.OnChangedCallback paramOnChangedCallback)
  {
    if (paramOnChangedCallback != null) {
      paramOnChangedCallback.b(this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonExtendedFloatingActionButton);
    }
  }
  
  public boolean a()
  {
    return ExtendedFloatingActionButton.c(this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonExtendedFloatingActionButton);
  }
  
  public void b()
  {
    super.b();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialFloatingactionbuttonExtendedFloatingActionButton.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.HideStrategy
 * JD-Core Version:    0.7.0.1
 */
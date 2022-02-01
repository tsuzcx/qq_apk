package com.google.android.material.snackbar;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;

class BaseTransientBottomBar$18
  implements ValueAnimator.AnimatorUpdateListener
{
  private int jdField_a_of_type_Int = 0;
  
  BaseTransientBottomBar$18(BaseTransientBottomBar paramBaseTransientBottomBar) {}
  
  public void onAnimationUpdate(@NonNull ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (BaseTransientBottomBar.c()) {
      ViewCompat.offsetTopAndBottom(this.jdField_a_of_type_ComGoogleAndroidMaterialSnackbarBaseTransientBottomBar.a, i - this.jdField_a_of_type_Int);
    } else {
      this.jdField_a_of_type_ComGoogleAndroidMaterialSnackbarBaseTransientBottomBar.a.setTranslationY(i);
    }
    this.jdField_a_of_type_Int = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.snackbar.BaseTransientBottomBar.18
 * JD-Core Version:    0.7.0.1
 */
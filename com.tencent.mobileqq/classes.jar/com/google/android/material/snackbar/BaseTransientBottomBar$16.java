package com.google.android.material.snackbar;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;

class BaseTransientBottomBar$16
  implements ValueAnimator.AnimatorUpdateListener
{
  private int b = this.jdField_a_of_type_Int;
  
  BaseTransientBottomBar$16(BaseTransientBottomBar paramBaseTransientBottomBar, int paramInt) {}
  
  public void onAnimationUpdate(@NonNull ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (BaseTransientBottomBar.c()) {
      ViewCompat.offsetTopAndBottom(this.jdField_a_of_type_ComGoogleAndroidMaterialSnackbarBaseTransientBottomBar.a, i - this.b);
    } else {
      this.jdField_a_of_type_ComGoogleAndroidMaterialSnackbarBaseTransientBottomBar.a.setTranslationY(i);
    }
    this.b = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.snackbar.BaseTransientBottomBar.16
 * JD-Core Version:    0.7.0.1
 */
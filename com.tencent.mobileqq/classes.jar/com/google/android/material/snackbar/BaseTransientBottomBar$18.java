package com.google.android.material.snackbar;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;

class BaseTransientBottomBar$18
  implements ValueAnimator.AnimatorUpdateListener
{
  private int b = 0;
  
  BaseTransientBottomBar$18(BaseTransientBottomBar paramBaseTransientBottomBar) {}
  
  public void onAnimationUpdate(@NonNull ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (BaseTransientBottomBar.i()) {
      ViewCompat.offsetTopAndBottom(this.a.b, i - this.b);
    } else {
      this.a.b.setTranslationY(i);
    }
    this.b = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.snackbar.BaseTransientBottomBar.18
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.material.snackbar;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;

class BaseTransientBottomBar$16
  implements ValueAnimator.AnimatorUpdateListener
{
  private int c = this.a;
  
  BaseTransientBottomBar$16(BaseTransientBottomBar paramBaseTransientBottomBar, int paramInt) {}
  
  public void onAnimationUpdate(@NonNull ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (BaseTransientBottomBar.i()) {
      ViewCompat.offsetTopAndBottom(this.b.b, i - this.c);
    } else {
      this.b.b.setTranslationY(i);
    }
    this.c = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.snackbar.BaseTransientBottomBar.16
 * JD-Core Version:    0.7.0.1
 */
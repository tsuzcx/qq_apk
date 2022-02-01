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
  private boolean a;
  private float c;
  private float d;
  
  private FloatingActionButtonImpl$ShadowAnimatorImpl(FloatingActionButtonImpl paramFloatingActionButtonImpl) {}
  
  protected abstract float a();
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    this.b.e((int)this.d);
    this.a = false;
  }
  
  public void onAnimationUpdate(@NonNull ValueAnimator paramValueAnimator)
  {
    if (!this.a)
    {
      if (this.b.c == null) {
        f = 0.0F;
      } else {
        f = this.b.c.U();
      }
      this.c = f;
      this.d = a();
      this.a = true;
    }
    FloatingActionButtonImpl localFloatingActionButtonImpl = this.b;
    float f = this.c;
    localFloatingActionButtonImpl.e((int)(f + (this.d - f) * paramValueAnimator.getAnimatedFraction()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.floatingactionbutton.FloatingActionButtonImpl.ShadowAnimatorImpl
 * JD-Core Version:    0.7.0.1
 */
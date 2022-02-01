package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import androidx.annotation.Nullable;
import com.google.android.material.R.animator;

class ExtendedFloatingActionButton$ShowStrategy
  extends BaseMotionStrategy
{
  public ExtendedFloatingActionButton$ShowStrategy(ExtendedFloatingActionButton paramExtendedFloatingActionButton, AnimatorTracker paramAnimatorTracker)
  {
    super(paramExtendedFloatingActionButton, paramAnimatorTracker);
  }
  
  public void a(Animator paramAnimator)
  {
    super.a(paramAnimator);
    this.a.setVisibility(0);
    ExtendedFloatingActionButton.a(this.a, 2);
  }
  
  public void a(@Nullable ExtendedFloatingActionButton.OnChangedCallback paramOnChangedCallback)
  {
    if (paramOnChangedCallback != null) {
      paramOnChangedCallback.a(this.a);
    }
  }
  
  public void d()
  {
    super.d();
    ExtendedFloatingActionButton.a(this.a, 0);
  }
  
  public void g()
  {
    this.a.setVisibility(0);
    this.a.setAlpha(1.0F);
    this.a.setScaleY(1.0F);
    this.a.setScaleX(1.0F);
  }
  
  public int h()
  {
    return R.animator.j;
  }
  
  public boolean i()
  {
    return ExtendedFloatingActionButton.h(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.ShowStrategy
 * JD-Core Version:    0.7.0.1
 */
package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import androidx.annotation.Nullable;
import com.google.android.material.R.animator;

class ExtendedFloatingActionButton$HideStrategy
  extends BaseMotionStrategy
{
  private boolean b;
  
  public ExtendedFloatingActionButton$HideStrategy(ExtendedFloatingActionButton paramExtendedFloatingActionButton, AnimatorTracker paramAnimatorTracker)
  {
    super(paramExtendedFloatingActionButton, paramAnimatorTracker);
  }
  
  public void a(Animator paramAnimator)
  {
    super.a(paramAnimator);
    this.b = false;
    this.a.setVisibility(0);
    ExtendedFloatingActionButton.a(this.a, 1);
  }
  
  public void a(@Nullable ExtendedFloatingActionButton.OnChangedCallback paramOnChangedCallback)
  {
    if (paramOnChangedCallback != null) {
      paramOnChangedCallback.b(this.a);
    }
  }
  
  public void d()
  {
    super.d();
    ExtendedFloatingActionButton.a(this.a, 0);
    if (!this.b) {
      this.a.setVisibility(8);
    }
  }
  
  public void e()
  {
    super.e();
    this.b = true;
  }
  
  public void g()
  {
    this.a.setVisibility(8);
  }
  
  public int h()
  {
    return R.animator.i;
  }
  
  public boolean i()
  {
    return ExtendedFloatingActionButton.i(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.HideStrategy
 * JD-Core Version:    0.7.0.1
 */
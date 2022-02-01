package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import androidx.annotation.Nullable;

class AnimatorTracker
{
  @Nullable
  private Animator a;
  
  public void a()
  {
    Animator localAnimator = this.a;
    if (localAnimator != null) {
      localAnimator.cancel();
    }
  }
  
  public void a(Animator paramAnimator)
  {
    a();
    this.a = paramAnimator;
  }
  
  public void b()
  {
    this.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.floatingactionbutton.AnimatorTracker
 * JD-Core Version:    0.7.0.1
 */
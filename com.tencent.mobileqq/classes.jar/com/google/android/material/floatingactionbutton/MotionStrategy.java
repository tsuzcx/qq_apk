package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import androidx.annotation.AnimatorRes;
import androidx.annotation.Nullable;
import com.google.android.material.animation.MotionSpec;
import java.util.List;

abstract interface MotionStrategy
{
  public abstract void a(Animator paramAnimator);
  
  public abstract void a(@Nullable MotionSpec paramMotionSpec);
  
  public abstract void a(@Nullable ExtendedFloatingActionButton.OnChangedCallback paramOnChangedCallback);
  
  public abstract List<Animator.AnimatorListener> b();
  
  @Nullable
  public abstract MotionSpec c();
  
  public abstract void d();
  
  public abstract void e();
  
  public abstract AnimatorSet f();
  
  public abstract void g();
  
  @AnimatorRes
  public abstract int h();
  
  public abstract boolean i();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.floatingactionbutton.MotionStrategy
 * JD-Core Version:    0.7.0.1
 */
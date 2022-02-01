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
  @AnimatorRes
  public abstract int a();
  
  public abstract AnimatorSet a();
  
  public abstract List<Animator.AnimatorListener> a();
  
  public abstract void a();
  
  public abstract void a(Animator paramAnimator);
  
  public abstract void a(@Nullable MotionSpec paramMotionSpec);
  
  public abstract void a(@Nullable ExtendedFloatingActionButton.OnChangedCallback paramOnChangedCallback);
  
  public abstract boolean a();
  
  public abstract void b();
  
  public abstract void c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.floatingactionbutton.MotionStrategy
 * JD-Core Version:    0.7.0.1
 */
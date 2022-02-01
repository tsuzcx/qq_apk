package com.google.android.material.progressindicator;

import android.animation.Animator;
import androidx.annotation.NonNull;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback;

abstract class IndeterminateAnimatorDelegate<T extends Animator>
{
  protected IndeterminateDrawable b;
  protected final float[] c;
  protected final int[] d;
  
  protected IndeterminateAnimatorDelegate(int paramInt)
  {
    this.c = new float[paramInt * 2];
    this.d = new int[paramInt];
  }
  
  protected float a(int paramInt1, int paramInt2, int paramInt3)
  {
    return (paramInt1 - paramInt2) / paramInt3;
  }
  
  abstract void a();
  
  public abstract void a(@NonNull Animatable2Compat.AnimationCallback paramAnimationCallback);
  
  protected void a(@NonNull IndeterminateDrawable paramIndeterminateDrawable)
  {
    this.b = paramIndeterminateDrawable;
  }
  
  abstract void b();
  
  abstract void c();
  
  public abstract void d();
  
  public abstract void e();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
 * JD-Core Version:    0.7.0.1
 */
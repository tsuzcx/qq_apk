package com.google.android.material.progressindicator;

import android.animation.Animator;
import androidx.annotation.NonNull;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback;

abstract class IndeterminateAnimatorDelegate<T extends Animator>
{
  protected IndeterminateDrawable a;
  protected final float[] a;
  protected final int[] a;
  
  protected IndeterminateAnimatorDelegate(int paramInt)
  {
    this.jdField_a_of_type_ArrayOfFloat = new float[paramInt * 2];
    this.jdField_a_of_type_ArrayOfInt = new int[paramInt];
  }
  
  protected float a(int paramInt1, int paramInt2, int paramInt3)
  {
    return (paramInt1 - paramInt2) / paramInt3;
  }
  
  abstract void a();
  
  public abstract void a(@NonNull Animatable2Compat.AnimationCallback paramAnimationCallback);
  
  protected void a(@NonNull IndeterminateDrawable paramIndeterminateDrawable)
  {
    this.jdField_a_of_type_ComGoogleAndroidMaterialProgressindicatorIndeterminateDrawable = paramIndeterminateDrawable;
  }
  
  abstract void b();
  
  abstract void c();
  
  public abstract void d();
  
  public abstract void e();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
 * JD-Core Version:    0.7.0.1
 */
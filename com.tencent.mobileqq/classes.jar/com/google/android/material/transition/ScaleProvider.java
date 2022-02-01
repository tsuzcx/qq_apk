package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class ScaleProvider
  implements VisibilityAnimatorProvider
{
  private float a = 1.0F;
  private float b = 1.1F;
  private float c = 0.8F;
  private float d = 1.0F;
  private boolean e;
  private boolean f = true;
  
  public ScaleProvider()
  {
    this(true);
  }
  
  public ScaleProvider(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  private static Animator a(View paramView, float paramFloat1, float paramFloat2)
  {
    float f1 = paramView.getScaleX();
    float f2 = paramView.getScaleY();
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofPropertyValuesHolder(paramView, new PropertyValuesHolder[] { PropertyValuesHolder.ofFloat(View.SCALE_X, new float[] { f1 * paramFloat1, f1 * paramFloat2 }), PropertyValuesHolder.ofFloat(View.SCALE_Y, new float[] { paramFloat1 * f2, paramFloat2 * f2 }) });
    localObjectAnimator.addListener(new ScaleProvider.1(paramView, f1, f2));
    return localObjectAnimator;
  }
  
  @Nullable
  public Animator a(@NonNull ViewGroup paramViewGroup, @NonNull View paramView)
  {
    if (this.e) {
      return a(paramView, this.c, this.d);
    }
    return a(paramView, this.b, this.a);
  }
  
  public void a(float paramFloat)
  {
    this.c = paramFloat;
  }
  
  public void a(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }
  
  @Nullable
  public Animator b(@NonNull ViewGroup paramViewGroup, @NonNull View paramView)
  {
    if (!this.f) {
      return null;
    }
    if (this.e) {
      return a(paramView, this.a, this.b);
    }
    return a(paramView, this.d, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.transition.ScaleProvider
 * JD-Core Version:    0.7.0.1
 */
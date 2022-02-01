package com.google.android.material.transition;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class FadeProvider
  implements VisibilityAnimatorProvider
{
  private float a = 1.0F;
  
  private static Animator a(View paramView, float paramFloat1, float paramFloat2, @FloatRange(from=0.0D, to=1.0D) float paramFloat3, @FloatRange(from=0.0D, to=1.0D) float paramFloat4, float paramFloat5)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.addUpdateListener(new FadeProvider.1(paramView, paramFloat1, paramFloat2, paramFloat3, paramFloat4));
    localValueAnimator.addListener(new FadeProvider.2(paramView, paramFloat5));
    return localValueAnimator;
  }
  
  @Nullable
  public Animator a(@NonNull ViewGroup paramViewGroup, @NonNull View paramView)
  {
    float f;
    if (paramView.getAlpha() == 0.0F) {
      f = 1.0F;
    } else {
      f = paramView.getAlpha();
    }
    return a(paramView, 0.0F, f, 0.0F, this.a, f);
  }
  
  public void a(float paramFloat)
  {
    this.a = paramFloat;
  }
  
  @Nullable
  public Animator b(@NonNull ViewGroup paramViewGroup, @NonNull View paramView)
  {
    float f;
    if (paramView.getAlpha() == 0.0F) {
      f = 1.0F;
    } else {
      f = paramView.getAlpha();
    }
    return a(paramView, f, 0.0F, 0.0F, 1.0F, f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.transition.FadeProvider
 * JD-Core Version:    0.7.0.1
 */
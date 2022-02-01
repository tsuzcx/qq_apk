package com.google.android.material.transition.platform;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.transition.TransitionValues;
import android.transition.Visibility;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
public final class Hold
  extends Visibility
{
  @NonNull
  public Animator onAppear(@NonNull ViewGroup paramViewGroup, @NonNull View paramView, @Nullable TransitionValues paramTransitionValues1, @Nullable TransitionValues paramTransitionValues2)
  {
    return ValueAnimator.ofFloat(new float[] { 0.0F });
  }
  
  @NonNull
  public Animator onDisappear(@NonNull ViewGroup paramViewGroup, @NonNull View paramView, @Nullable TransitionValues paramTransitionValues1, @Nullable TransitionValues paramTransitionValues2)
  {
    return ValueAnimator.ofFloat(new float[] { 0.0F });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.transition.platform.Hold
 * JD-Core Version:    0.7.0.1
 */
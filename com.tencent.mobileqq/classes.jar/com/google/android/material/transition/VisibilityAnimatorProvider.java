package com.google.android.material.transition;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public abstract interface VisibilityAnimatorProvider
{
  @Nullable
  public abstract Animator a(@NonNull ViewGroup paramViewGroup, @NonNull View paramView);
  
  @Nullable
  public abstract Animator b(@NonNull ViewGroup paramViewGroup, @NonNull View paramView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.transition.VisibilityAnimatorProvider
 * JD-Core Version:    0.7.0.1
 */
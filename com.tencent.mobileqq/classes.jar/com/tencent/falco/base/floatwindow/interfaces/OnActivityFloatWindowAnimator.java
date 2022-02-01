package com.tencent.falco.base.floatwindow.interfaces;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract interface OnActivityFloatWindowAnimator
{
  @Nullable
  public abstract Animator enterAnim(@NotNull View paramView, @NotNull ViewGroup paramViewGroup, int paramInt);
  
  @Nullable
  public abstract Animator exitAnim(@NotNull View paramView, @NotNull ViewGroup paramViewGroup, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.base.floatwindow.interfaces.OnActivityFloatWindowAnimator
 * JD-Core Version:    0.7.0.1
 */
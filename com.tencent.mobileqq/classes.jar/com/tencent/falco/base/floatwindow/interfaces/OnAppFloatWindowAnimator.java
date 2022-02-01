package com.tencent.falco.base.floatwindow.interfaces;

import android.animation.Animator;
import android.view.View;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import org.jetbrains.annotations.NotNull;

public abstract interface OnAppFloatWindowAnimator
{
  public abstract Animator enterAnim(@NotNull View paramView, @NotNull WindowManager.LayoutParams paramLayoutParams, @NotNull WindowManager paramWindowManager, int paramInt);
  
  public abstract Animator exitAnim(@NotNull View paramView, @NotNull WindowManager.LayoutParams paramLayoutParams, @NotNull WindowManager paramWindowManager, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.falco.base.floatwindow.interfaces.OnAppFloatWindowAnimator
 * JD-Core Version:    0.7.0.1
 */
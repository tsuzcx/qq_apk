package com.google.android.material.circularreveal;

import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;

public abstract interface CircularRevealWidget
  extends CircularRevealHelper.Delegate
{
  @ColorInt
  public abstract int a();
  
  @Nullable
  public abstract CircularRevealWidget.RevealInfo a();
  
  public abstract void a();
  
  public abstract void b();
  
  public abstract void setCircularRevealOverlayDrawable(@Nullable Drawable paramDrawable);
  
  public abstract void setCircularRevealScrimColor(@ColorInt int paramInt);
  
  public abstract void setRevealInfo(@Nullable CircularRevealWidget.RevealInfo paramRevealInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.circularreveal.CircularRevealWidget
 * JD-Core Version:    0.7.0.1
 */
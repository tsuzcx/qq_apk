package com.google.android.material.circularreveal;

import android.graphics.drawable.Drawable;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;

public abstract interface CircularRevealWidget
  extends CircularRevealHelper.Delegate
{
  public abstract void a();
  
  public abstract void b();
  
  @ColorInt
  public abstract int getCircularRevealScrimColor();
  
  @Nullable
  public abstract CircularRevealWidget.RevealInfo getRevealInfo();
  
  public abstract void setCircularRevealOverlayDrawable(@Nullable Drawable paramDrawable);
  
  public abstract void setCircularRevealScrimColor(@ColorInt int paramInt);
  
  public abstract void setRevealInfo(@Nullable CircularRevealWidget.RevealInfo paramRevealInfo);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.circularreveal.CircularRevealWidget
 * JD-Core Version:    0.7.0.1
 */
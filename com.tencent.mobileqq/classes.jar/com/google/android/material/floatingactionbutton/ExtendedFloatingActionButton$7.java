package com.google.android.material.floatingactionbutton;

import android.util.Property;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;

final class ExtendedFloatingActionButton$7
  extends Property<View, Float>
{
  ExtendedFloatingActionButton$7(Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  @NonNull
  public Float a(@NonNull View paramView)
  {
    return Float.valueOf(ViewCompat.getPaddingEnd(paramView));
  }
  
  public void a(@NonNull View paramView, @NonNull Float paramFloat)
  {
    ViewCompat.setPaddingRelative(paramView, ViewCompat.getPaddingStart(paramView), paramView.getPaddingTop(), paramFloat.intValue(), paramView.getPaddingBottom());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.7
 * JD-Core Version:    0.7.0.1
 */
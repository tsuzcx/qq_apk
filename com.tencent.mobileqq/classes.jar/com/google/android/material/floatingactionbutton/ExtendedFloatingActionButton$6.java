package com.google.android.material.floatingactionbutton;

import android.util.Property;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;

final class ExtendedFloatingActionButton$6
  extends Property<View, Float>
{
  ExtendedFloatingActionButton$6(Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  @NonNull
  public Float a(@NonNull View paramView)
  {
    return Float.valueOf(ViewCompat.getPaddingStart(paramView));
  }
  
  public void a(@NonNull View paramView, @NonNull Float paramFloat)
  {
    ViewCompat.setPaddingRelative(paramView, paramFloat.intValue(), paramView.getPaddingTop(), ViewCompat.getPaddingEnd(paramView), paramView.getPaddingBottom());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.6
 * JD-Core Version:    0.7.0.1
 */
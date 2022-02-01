package com.google.android.material.floatingactionbutton;

import android.util.Property;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import androidx.annotation.NonNull;

final class ExtendedFloatingActionButton$5
  extends Property<View, Float>
{
  ExtendedFloatingActionButton$5(Class paramClass, String paramString)
  {
    super(paramClass, paramString);
  }
  
  @NonNull
  public Float a(@NonNull View paramView)
  {
    return Float.valueOf(paramView.getLayoutParams().height);
  }
  
  public void a(@NonNull View paramView, @NonNull Float paramFloat)
  {
    paramView.getLayoutParams().height = paramFloat.intValue();
    paramView.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.5
 * JD-Core Version:    0.7.0.1
 */
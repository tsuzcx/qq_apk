package com.google.android.material.circularreveal;

import android.util.Property;
import androidx.annotation.NonNull;

public class CircularRevealWidget$CircularRevealScrimColorProperty
  extends Property<CircularRevealWidget, Integer>
{
  public static final Property<CircularRevealWidget, Integer> a = new CircularRevealScrimColorProperty("circularRevealScrimColor");
  
  private CircularRevealWidget$CircularRevealScrimColorProperty(String paramString)
  {
    super(Integer.class, paramString);
  }
  
  @NonNull
  public Integer a(@NonNull CircularRevealWidget paramCircularRevealWidget)
  {
    return Integer.valueOf(paramCircularRevealWidget.a());
  }
  
  public void a(@NonNull CircularRevealWidget paramCircularRevealWidget, @NonNull Integer paramInteger)
  {
    paramCircularRevealWidget.setCircularRevealScrimColor(paramInteger.intValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.circularreveal.CircularRevealWidget.CircularRevealScrimColorProperty
 * JD-Core Version:    0.7.0.1
 */
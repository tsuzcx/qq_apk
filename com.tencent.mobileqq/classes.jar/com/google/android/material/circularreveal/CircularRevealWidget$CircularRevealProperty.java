package com.google.android.material.circularreveal;

import android.util.Property;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CircularRevealWidget$CircularRevealProperty
  extends Property<CircularRevealWidget, CircularRevealWidget.RevealInfo>
{
  public static final Property<CircularRevealWidget, CircularRevealWidget.RevealInfo> a = new CircularRevealProperty("circularReveal");
  
  private CircularRevealWidget$CircularRevealProperty(String paramString)
  {
    super(CircularRevealWidget.RevealInfo.class, paramString);
  }
  
  @Nullable
  public CircularRevealWidget.RevealInfo a(@NonNull CircularRevealWidget paramCircularRevealWidget)
  {
    return paramCircularRevealWidget.a();
  }
  
  public void a(@NonNull CircularRevealWidget paramCircularRevealWidget, @Nullable CircularRevealWidget.RevealInfo paramRevealInfo)
  {
    paramCircularRevealWidget.setRevealInfo(paramRevealInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.circularreveal.CircularRevealWidget.CircularRevealProperty
 * JD-Core Version:    0.7.0.1
 */
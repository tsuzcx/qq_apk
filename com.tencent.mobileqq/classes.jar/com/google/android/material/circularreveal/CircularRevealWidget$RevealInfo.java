package com.google.android.material.circularreveal;

import androidx.annotation.NonNull;

public class CircularRevealWidget$RevealInfo
{
  public float a;
  public float b;
  public float c;
  
  private CircularRevealWidget$RevealInfo() {}
  
  public CircularRevealWidget$RevealInfo(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
  }
  
  public CircularRevealWidget$RevealInfo(@NonNull RevealInfo paramRevealInfo)
  {
    this(paramRevealInfo.a, paramRevealInfo.b, paramRevealInfo.c);
  }
  
  public void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.a = paramFloat1;
    this.b = paramFloat2;
    this.c = paramFloat3;
  }
  
  public void a(@NonNull RevealInfo paramRevealInfo)
  {
    a(paramRevealInfo.a, paramRevealInfo.b, paramRevealInfo.c);
  }
  
  public boolean a()
  {
    return this.c == 3.4028235E+38F;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.circularreveal.CircularRevealWidget.RevealInfo
 * JD-Core Version:    0.7.0.1
 */
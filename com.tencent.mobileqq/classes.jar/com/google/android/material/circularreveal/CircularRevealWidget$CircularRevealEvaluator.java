package com.google.android.material.circularreveal;

import android.animation.TypeEvaluator;
import androidx.annotation.NonNull;
import com.google.android.material.math.MathUtils;

public class CircularRevealWidget$CircularRevealEvaluator
  implements TypeEvaluator<CircularRevealWidget.RevealInfo>
{
  public static final TypeEvaluator<CircularRevealWidget.RevealInfo> a = new CircularRevealEvaluator();
  private final CircularRevealWidget.RevealInfo b = new CircularRevealWidget.RevealInfo(null);
  
  @NonNull
  public CircularRevealWidget.RevealInfo a(float paramFloat, @NonNull CircularRevealWidget.RevealInfo paramRevealInfo1, @NonNull CircularRevealWidget.RevealInfo paramRevealInfo2)
  {
    this.b.a(MathUtils.a(paramRevealInfo1.a, paramRevealInfo2.a, paramFloat), MathUtils.a(paramRevealInfo1.b, paramRevealInfo2.b, paramFloat), MathUtils.a(paramRevealInfo1.c, paramRevealInfo2.c, paramFloat));
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.circularreveal.CircularRevealWidget.CircularRevealEvaluator
 * JD-Core Version:    0.7.0.1
 */
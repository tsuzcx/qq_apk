package com.google.android.material.animation;

import android.animation.TimeInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.RestrictTo;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public class AnimationUtils
{
  public static final TimeInterpolator a = new LinearInterpolator();
  public static final TimeInterpolator b = new FastOutSlowInInterpolator();
  public static final TimeInterpolator c = new FastOutLinearInInterpolator();
  public static final TimeInterpolator d = new LinearOutSlowInInterpolator();
  public static final TimeInterpolator e = new DecelerateInterpolator();
  
  public static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return paramFloat1 + paramFloat3 * (paramFloat2 - paramFloat1);
  }
  
  public static float a(float paramFloat1, float paramFloat2, @FloatRange(from=0.0D, to=1.0D) float paramFloat3, @FloatRange(from=0.0D, to=1.0D) float paramFloat4, @FloatRange(from=0.0D, to=1.0D) float paramFloat5)
  {
    if (paramFloat5 < paramFloat3) {
      return paramFloat1;
    }
    if (paramFloat5 > paramFloat4) {
      return paramFloat2;
    }
    return a(paramFloat1, paramFloat2, (paramFloat5 - paramFloat3) / (paramFloat4 - paramFloat3));
  }
  
  public static int a(int paramInt1, int paramInt2, float paramFloat)
  {
    return paramInt1 + Math.round(paramFloat * (paramInt2 - paramInt1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.google.android.material.animation.AnimationUtils
 * JD-Core Version:    0.7.0.1
 */
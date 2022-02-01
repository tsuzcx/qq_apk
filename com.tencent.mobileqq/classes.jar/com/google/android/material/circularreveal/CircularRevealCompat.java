package com.google.android.material.circularreveal;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewAnimationUtils;
import androidx.annotation.NonNull;

public final class CircularRevealCompat
{
  @NonNull
  public static Animator.AnimatorListener a(@NonNull CircularRevealWidget paramCircularRevealWidget)
  {
    return new CircularRevealCompat.1(paramCircularRevealWidget);
  }
  
  @NonNull
  public static Animator a(@NonNull CircularRevealWidget paramCircularRevealWidget, float paramFloat1, float paramFloat2, float paramFloat3)
  {
    ObjectAnimator localObjectAnimator = ObjectAnimator.ofObject(paramCircularRevealWidget, CircularRevealWidget.CircularRevealProperty.a, CircularRevealWidget.CircularRevealEvaluator.a, new CircularRevealWidget.RevealInfo[] { new CircularRevealWidget.RevealInfo(paramFloat1, paramFloat2, paramFloat3) });
    if (Build.VERSION.SDK_INT >= 21)
    {
      Object localObject = paramCircularRevealWidget.getRevealInfo();
      if (localObject != null)
      {
        float f = ((CircularRevealWidget.RevealInfo)localObject).c;
        paramCircularRevealWidget = ViewAnimationUtils.createCircularReveal((View)paramCircularRevealWidget, (int)paramFloat1, (int)paramFloat2, f, paramFloat3);
        localObject = new AnimatorSet();
        ((AnimatorSet)localObject).playTogether(new Animator[] { localObjectAnimator, paramCircularRevealWidget });
        return localObject;
      }
      throw new IllegalStateException("Caller must set a non-null RevealInfo before calling this.");
    }
    return localObjectAnimator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.google.android.material.circularreveal.CircularRevealCompat
 * JD-Core Version:    0.7.0.1
 */
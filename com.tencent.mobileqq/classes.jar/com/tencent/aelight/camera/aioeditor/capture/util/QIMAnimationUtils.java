package com.tencent.aelight.camera.aioeditor.capture.util;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.Animation;
import com.tencent.mobileqq.utils.ValueAnimation;

public class QIMAnimationUtils
{
  public static Animator a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { paramInt2, paramInt3 });
    localValueAnimator.addUpdateListener(new QIMAnimationUtils.2(paramInt1, paramView));
    return localValueAnimator;
  }
  
  public static Animation a(View paramView, float paramFloat1, float paramFloat2)
  {
    return new ValueAnimation(Float.valueOf(paramFloat1), Float.valueOf(paramFloat2), new QIMAnimationUtils.3(paramView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.capture.util.QIMAnimationUtils
 * JD-Core Version:    0.7.0.1
 */
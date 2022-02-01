package com.tencent.biz.qqstory.widget.circularreveal;

import android.animation.Animator;
import android.view.View;

public final class ViewAnimationCompatUtils
{
  public static Animator a(View paramView, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    return a(paramView, paramInt1, paramInt2, paramFloat1, paramFloat2, 2);
  }
  
  public static Animator a(View paramView, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3)
  {
    CircularRevealAnimator localCircularRevealAnimator = CircularRevealAnimator.a(paramView, paramInt1, paramInt2, paramFloat1, paramFloat2);
    if (paramInt3 != paramView.getLayerType()) {
      localCircularRevealAnimator.addListener(new CircularRevealAnimator.ChangeViewLayerTypeListener(paramView, paramInt3));
    }
    return localCircularRevealAnimator;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.widget.circularreveal.ViewAnimationCompatUtils
 * JD-Core Version:    0.7.0.1
 */
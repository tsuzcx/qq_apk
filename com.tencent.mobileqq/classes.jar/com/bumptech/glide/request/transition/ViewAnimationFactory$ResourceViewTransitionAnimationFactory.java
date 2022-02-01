package com.bumptech.glide.request.transition;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

class ViewAnimationFactory$ResourceViewTransitionAnimationFactory
  implements ViewTransition.ViewTransitionAnimationFactory
{
  private final int a;
  
  public Animation a(Context paramContext)
  {
    return AnimationUtils.loadAnimation(paramContext, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.request.transition.ViewAnimationFactory.ResourceViewTransitionAnimationFactory
 * JD-Core Version:    0.7.0.1
 */
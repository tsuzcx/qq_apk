package com.bumptech.glide.request.transition;

import android.view.View;

public class ViewTransition<R>
  implements Transition<R>
{
  private final ViewTransition.ViewTransitionAnimationFactory a;
  
  ViewTransition(ViewTransition.ViewTransitionAnimationFactory paramViewTransitionAnimationFactory)
  {
    this.a = paramViewTransitionAnimationFactory;
  }
  
  public boolean a(R paramR, Transition.ViewAdapter paramViewAdapter)
  {
    paramR = paramViewAdapter.h();
    if (paramR != null)
    {
      paramR.clearAnimation();
      paramR.startAnimation(this.a.a(paramR.getContext()));
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.request.transition.ViewTransition
 * JD-Core Version:    0.7.0.1
 */
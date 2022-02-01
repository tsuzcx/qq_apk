package com.bumptech.glide.request.transition;

public class ViewPropertyTransition<R>
  implements Transition<R>
{
  private final ViewPropertyTransition.Animator a;
  
  public ViewPropertyTransition(ViewPropertyTransition.Animator paramAnimator)
  {
    this.a = paramAnimator;
  }
  
  public boolean a(R paramR, Transition.ViewAdapter paramViewAdapter)
  {
    if (paramViewAdapter.h() != null) {
      this.a.a(paramViewAdapter.h());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.request.transition.ViewPropertyTransition
 * JD-Core Version:    0.7.0.1
 */
package com.bumptech.glide.request.transition;

import com.bumptech.glide.load.DataSource;

public class ViewAnimationFactory<R>
  implements TransitionFactory<R>
{
  private final ViewTransition.ViewTransitionAnimationFactory a;
  private Transition<R> b;
  
  public Transition<R> a(DataSource paramDataSource, boolean paramBoolean)
  {
    if ((paramDataSource != DataSource.MEMORY_CACHE) && (paramBoolean))
    {
      if (this.b == null) {
        this.b = new ViewTransition(this.a);
      }
      return this.b;
    }
    return NoTransition.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.request.transition.ViewAnimationFactory
 * JD-Core Version:    0.7.0.1
 */
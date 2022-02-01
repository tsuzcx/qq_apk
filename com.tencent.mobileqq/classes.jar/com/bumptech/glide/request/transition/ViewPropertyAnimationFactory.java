package com.bumptech.glide.request.transition;

import com.bumptech.glide.load.DataSource;

public class ViewPropertyAnimationFactory<R>
  implements TransitionFactory<R>
{
  private final ViewPropertyTransition.Animator a;
  private ViewPropertyTransition<R> b;
  
  public Transition<R> a(DataSource paramDataSource, boolean paramBoolean)
  {
    if ((paramDataSource != DataSource.MEMORY_CACHE) && (paramBoolean))
    {
      if (this.b == null) {
        this.b = new ViewPropertyTransition(this.a);
      }
      return this.b;
    }
    return NoTransition.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.request.transition.ViewPropertyAnimationFactory
 * JD-Core Version:    0.7.0.1
 */
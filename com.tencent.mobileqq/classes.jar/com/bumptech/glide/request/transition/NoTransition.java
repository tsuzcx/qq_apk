package com.bumptech.glide.request.transition;

public class NoTransition<R>
  implements Transition<R>
{
  static final NoTransition<?> a = new NoTransition();
  private static final TransitionFactory<?> b = new NoTransition.NoAnimationFactory();
  
  public static <R> TransitionFactory<R> a()
  {
    return b;
  }
  
  public static <R> Transition<R> b()
  {
    return a;
  }
  
  public boolean a(Object paramObject, Transition.ViewAdapter paramViewAdapter)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.bumptech.glide.request.transition.NoTransition
 * JD-Core Version:    0.7.0.1
 */
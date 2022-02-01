package androidx.transition;

import androidx.annotation.NonNull;

public abstract interface Transition$TransitionListener
{
  public abstract void onTransitionCancel(@NonNull Transition paramTransition);
  
  public abstract void onTransitionEnd(@NonNull Transition paramTransition);
  
  public abstract void onTransitionPause(@NonNull Transition paramTransition);
  
  public abstract void onTransitionResume(@NonNull Transition paramTransition);
  
  public abstract void onTransitionStart(@NonNull Transition paramTransition);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.transition.Transition.TransitionListener
 * JD-Core Version:    0.7.0.1
 */
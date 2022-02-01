package androidx.transition;

import androidx.annotation.NonNull;

class TransitionSet$1
  extends TransitionListenerAdapter
{
  TransitionSet$1(TransitionSet paramTransitionSet, Transition paramTransition) {}
  
  public void onTransitionEnd(@NonNull Transition paramTransition)
  {
    this.val$nextTransition.runAnimators();
    paramTransition.removeListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.transition.TransitionSet.1
 * JD-Core Version:    0.7.0.1
 */
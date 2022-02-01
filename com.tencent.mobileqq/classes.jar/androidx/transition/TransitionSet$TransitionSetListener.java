package androidx.transition;

import androidx.annotation.NonNull;

class TransitionSet$TransitionSetListener
  extends TransitionListenerAdapter
{
  TransitionSet mTransitionSet;
  
  TransitionSet$TransitionSetListener(TransitionSet paramTransitionSet)
  {
    this.mTransitionSet = paramTransitionSet;
  }
  
  public void onTransitionEnd(@NonNull Transition paramTransition)
  {
    TransitionSet localTransitionSet = this.mTransitionSet;
    localTransitionSet.mCurrentListeners -= 1;
    if (this.mTransitionSet.mCurrentListeners == 0)
    {
      localTransitionSet = this.mTransitionSet;
      localTransitionSet.mStarted = false;
      localTransitionSet.end();
    }
    paramTransition.removeListener(this);
  }
  
  public void onTransitionStart(@NonNull Transition paramTransition)
  {
    if (!this.mTransitionSet.mStarted)
    {
      this.mTransitionSet.start();
      this.mTransitionSet.mStarted = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.transition.TransitionSet.TransitionSetListener
 * JD-Core Version:    0.7.0.1
 */
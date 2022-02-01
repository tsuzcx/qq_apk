package androidx.transition;

import android.view.ViewGroup;

public abstract class TransitionPropagation
{
  public abstract void captureValues(TransitionValues paramTransitionValues);
  
  public abstract String[] getPropagationProperties();
  
  public abstract long getStartDelay(ViewGroup paramViewGroup, Transition paramTransition, TransitionValues paramTransitionValues1, TransitionValues paramTransitionValues2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.transition.TransitionPropagation
 * JD-Core Version:    0.7.0.1
 */
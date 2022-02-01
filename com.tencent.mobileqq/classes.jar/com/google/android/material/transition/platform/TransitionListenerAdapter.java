package com.google.android.material.transition.platform;

import android.transition.Transition;
import android.transition.Transition.TransitionListener;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
abstract class TransitionListenerAdapter
  implements Transition.TransitionListener
{
  public void onTransitionCancel(Transition paramTransition) {}
  
  public void onTransitionEnd(Transition paramTransition) {}
  
  public void onTransitionPause(Transition paramTransition) {}
  
  public void onTransitionResume(Transition paramTransition) {}
  
  public void onTransitionStart(Transition paramTransition) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.google.android.material.transition.platform.TransitionListenerAdapter
 * JD-Core Version:    0.7.0.1
 */
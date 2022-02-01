package androidx.fragment.app;

import android.transition.Transition;
import android.transition.Transition.TransitionListener;

class FragmentTransitionCompat21$4
  implements Transition.TransitionListener
{
  FragmentTransitionCompat21$4(FragmentTransitionCompat21 paramFragmentTransitionCompat21, Runnable paramRunnable) {}
  
  public void onTransitionCancel(Transition paramTransition) {}
  
  public void onTransitionEnd(Transition paramTransition)
  {
    this.val$transitionCompleteRunnable.run();
  }
  
  public void onTransitionPause(Transition paramTransition) {}
  
  public void onTransitionResume(Transition paramTransition) {}
  
  public void onTransitionStart(Transition paramTransition) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.fragment.app.FragmentTransitionCompat21.4
 * JD-Core Version:    0.7.0.1
 */
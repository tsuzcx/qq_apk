package androidx.fragment.app;

import android.transition.Transition;
import android.transition.Transition.TransitionListener;
import java.util.ArrayList;

class FragmentTransitionCompat21$3
  implements Transition.TransitionListener
{
  FragmentTransitionCompat21$3(FragmentTransitionCompat21 paramFragmentTransitionCompat21, Object paramObject1, ArrayList paramArrayList1, Object paramObject2, ArrayList paramArrayList2, Object paramObject3, ArrayList paramArrayList3) {}
  
  public void onTransitionCancel(Transition paramTransition) {}
  
  public void onTransitionEnd(Transition paramTransition)
  {
    paramTransition.removeListener(this);
  }
  
  public void onTransitionPause(Transition paramTransition) {}
  
  public void onTransitionResume(Transition paramTransition) {}
  
  public void onTransitionStart(Transition paramTransition)
  {
    paramTransition = this.val$enterTransition;
    if (paramTransition != null) {
      this.this$0.replaceTargets(paramTransition, this.val$enteringViews, null);
    }
    paramTransition = this.val$exitTransition;
    if (paramTransition != null) {
      this.this$0.replaceTargets(paramTransition, this.val$exitingViews, null);
    }
    paramTransition = this.val$sharedElementTransition;
    if (paramTransition != null) {
      this.this$0.replaceTargets(paramTransition, this.val$sharedElementsIn, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.fragment.app.FragmentTransitionCompat21.3
 * JD-Core Version:    0.7.0.1
 */
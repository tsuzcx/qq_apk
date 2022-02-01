package androidx.transition;

import androidx.annotation.NonNull;
import java.util.ArrayList;

class FragmentTransitionSupport$3
  extends TransitionListenerAdapter
{
  FragmentTransitionSupport$3(FragmentTransitionSupport paramFragmentTransitionSupport, Object paramObject1, ArrayList paramArrayList1, Object paramObject2, ArrayList paramArrayList2, Object paramObject3, ArrayList paramArrayList3) {}
  
  public void onTransitionEnd(@NonNull Transition paramTransition)
  {
    paramTransition.removeListener(this);
  }
  
  public void onTransitionStart(@NonNull Transition paramTransition)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.transition.FragmentTransitionSupport.3
 * JD-Core Version:    0.7.0.1
 */
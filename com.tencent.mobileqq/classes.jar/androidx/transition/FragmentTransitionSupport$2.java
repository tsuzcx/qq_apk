package androidx.transition;

import android.view.View;
import androidx.annotation.NonNull;
import java.util.ArrayList;

class FragmentTransitionSupport$2
  implements Transition.TransitionListener
{
  FragmentTransitionSupport$2(FragmentTransitionSupport paramFragmentTransitionSupport, View paramView, ArrayList paramArrayList) {}
  
  public void onTransitionCancel(@NonNull Transition paramTransition) {}
  
  public void onTransitionEnd(@NonNull Transition paramTransition)
  {
    paramTransition.removeListener(this);
    this.val$fragmentView.setVisibility(8);
    int j = this.val$exitingViews.size();
    int i = 0;
    while (i < j)
    {
      ((View)this.val$exitingViews.get(i)).setVisibility(0);
      i += 1;
    }
  }
  
  public void onTransitionPause(@NonNull Transition paramTransition) {}
  
  public void onTransitionResume(@NonNull Transition paramTransition) {}
  
  public void onTransitionStart(@NonNull Transition paramTransition) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.transition.FragmentTransitionSupport.2
 * JD-Core Version:    0.7.0.1
 */
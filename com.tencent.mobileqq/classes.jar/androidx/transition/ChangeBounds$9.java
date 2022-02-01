package androidx.transition;

import android.view.ViewGroup;
import androidx.annotation.NonNull;

class ChangeBounds$9
  extends TransitionListenerAdapter
{
  boolean mCanceled = false;
  
  ChangeBounds$9(ChangeBounds paramChangeBounds, ViewGroup paramViewGroup) {}
  
  public void onTransitionCancel(@NonNull Transition paramTransition)
  {
    ViewGroupUtils.suppressLayout(this.val$parent, false);
    this.mCanceled = true;
  }
  
  public void onTransitionEnd(@NonNull Transition paramTransition)
  {
    if (!this.mCanceled) {
      ViewGroupUtils.suppressLayout(this.val$parent, false);
    }
    paramTransition.removeListener(this);
  }
  
  public void onTransitionPause(@NonNull Transition paramTransition)
  {
    ViewGroupUtils.suppressLayout(this.val$parent, false);
  }
  
  public void onTransitionResume(@NonNull Transition paramTransition)
  {
    ViewGroupUtils.suppressLayout(this.val$parent, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.transition.ChangeBounds.9
 * JD-Core Version:    0.7.0.1
 */
package androidx.transition;

import android.graphics.Rect;
import androidx.annotation.NonNull;

class FragmentTransitionSupport$4
  extends Transition.EpicenterCallback
{
  FragmentTransitionSupport$4(FragmentTransitionSupport paramFragmentTransitionSupport, Rect paramRect) {}
  
  public Rect onGetEpicenter(@NonNull Transition paramTransition)
  {
    paramTransition = this.val$epicenter;
    if ((paramTransition != null) && (!paramTransition.isEmpty())) {
      return this.val$epicenter;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.transition.FragmentTransitionSupport.4
 * JD-Core Version:    0.7.0.1
 */
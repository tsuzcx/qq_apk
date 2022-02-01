package androidx.fragment.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;

class FragmentTransitionCompat21$5
  extends Transition.EpicenterCallback
{
  FragmentTransitionCompat21$5(FragmentTransitionCompat21 paramFragmentTransitionCompat21, Rect paramRect) {}
  
  public Rect onGetEpicenter(Transition paramTransition)
  {
    paramTransition = this.val$epicenter;
    if ((paramTransition != null) && (!paramTransition.isEmpty())) {
      return this.val$epicenter;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.fragment.app.FragmentTransitionCompat21.5
 * JD-Core Version:    0.7.0.1
 */
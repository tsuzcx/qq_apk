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
    if ((this.val$epicenter == null) || (this.val$epicenter.isEmpty())) {
      return null;
    }
    return this.val$epicenter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.fragment.app.FragmentTransitionCompat21.5
 * JD-Core Version:    0.7.0.1
 */
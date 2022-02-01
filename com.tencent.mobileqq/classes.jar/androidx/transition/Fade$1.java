package androidx.transition;

import android.view.View;
import androidx.annotation.NonNull;

class Fade$1
  extends TransitionListenerAdapter
{
  Fade$1(Fade paramFade, View paramView) {}
  
  public void onTransitionEnd(@NonNull Transition paramTransition)
  {
    ViewUtils.setTransitionAlpha(this.val$view, 1.0F);
    ViewUtils.clearNonTransitionAlpha(this.val$view);
    paramTransition.removeListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.transition.Fade.1
 * JD-Core Version:    0.7.0.1
 */
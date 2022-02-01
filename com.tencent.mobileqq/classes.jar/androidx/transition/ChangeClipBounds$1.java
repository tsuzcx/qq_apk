package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import androidx.core.view.ViewCompat;

class ChangeClipBounds$1
  extends AnimatorListenerAdapter
{
  ChangeClipBounds$1(ChangeClipBounds paramChangeClipBounds, View paramView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ViewCompat.setClipBounds(this.val$endView, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.transition.ChangeClipBounds.1
 * JD-Core Version:    0.7.0.1
 */
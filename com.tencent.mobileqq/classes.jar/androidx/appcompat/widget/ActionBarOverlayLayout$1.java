package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;

class ActionBarOverlayLayout$1
  extends AnimatorListenerAdapter
{
  ActionBarOverlayLayout$1(ActionBarOverlayLayout paramActionBarOverlayLayout) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    paramAnimator = this.this$0;
    paramAnimator.mCurrentActionBarTopAnimator = null;
    paramAnimator.mAnimatingForFling = false;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    paramAnimator = this.this$0;
    paramAnimator.mCurrentActionBarTopAnimator = null;
    paramAnimator.mAnimatingForFling = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.ActionBarOverlayLayout.1
 * JD-Core Version:    0.7.0.1
 */
package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.ViewGroup;

class ChangeBounds$10
  extends AnimatorListenerAdapter
{
  ChangeBounds$10(ChangeBounds paramChangeBounds, ViewGroup paramViewGroup, BitmapDrawable paramBitmapDrawable, View paramView, float paramFloat) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ViewUtils.getOverlay(this.val$sceneRoot).remove(this.val$drawable);
    ViewUtils.setTransitionAlpha(this.val$view, this.val$transitionAlpha);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.transition.ChangeBounds.10
 * JD-Core Version:    0.7.0.1
 */
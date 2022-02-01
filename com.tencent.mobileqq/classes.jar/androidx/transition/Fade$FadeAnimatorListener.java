package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import androidx.core.view.ViewCompat;

class Fade$FadeAnimatorListener
  extends AnimatorListenerAdapter
{
  private boolean mLayerTypeChanged = false;
  private final View mView;
  
  Fade$FadeAnimatorListener(View paramView)
  {
    this.mView = paramView;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    ViewUtils.setTransitionAlpha(this.mView, 1.0F);
    if (this.mLayerTypeChanged) {
      this.mView.setLayerType(0, null);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if ((ViewCompat.hasOverlappingRendering(this.mView)) && (this.mView.getLayerType() == 0))
    {
      this.mLayerTypeChanged = true;
      this.mView.setLayerType(2, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.transition.Fade.FadeAnimatorListener
 * JD-Core Version:    0.7.0.1
 */
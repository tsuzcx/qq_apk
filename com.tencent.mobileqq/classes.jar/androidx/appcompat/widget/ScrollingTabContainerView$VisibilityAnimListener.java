package androidx.appcompat.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewPropertyAnimator;

public class ScrollingTabContainerView$VisibilityAnimListener
  extends AnimatorListenerAdapter
{
  private boolean mCanceled = false;
  private int mFinalVisibility;
  
  protected ScrollingTabContainerView$VisibilityAnimListener(ScrollingTabContainerView paramScrollingTabContainerView) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.mCanceled = true;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.mCanceled) {
      return;
    }
    paramAnimator = this.this$0;
    paramAnimator.mVisibilityAnim = null;
    paramAnimator.setVisibility(this.mFinalVisibility);
  }
  
  public void onAnimationStart(Animator paramAnimator)
  {
    this.this$0.setVisibility(0);
    this.mCanceled = false;
  }
  
  public VisibilityAnimListener withFinalVisibility(ViewPropertyAnimator paramViewPropertyAnimator, int paramInt)
  {
    this.mFinalVisibility = paramInt;
    this.this$0.mVisibilityAnim = paramViewPropertyAnimator;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.appcompat.widget.ScrollingTabContainerView.VisibilityAnimListener
 * JD-Core Version:    0.7.0.1
 */
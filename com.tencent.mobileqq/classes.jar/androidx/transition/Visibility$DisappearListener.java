package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;

class Visibility$DisappearListener
  extends AnimatorListenerAdapter
  implements AnimatorUtils.AnimatorPauseListenerCompat, Transition.TransitionListener
{
  boolean mCanceled = false;
  private final int mFinalVisibility;
  private boolean mLayoutSuppressed;
  private final ViewGroup mParent;
  private final boolean mSuppressLayout;
  private final View mView;
  
  Visibility$DisappearListener(View paramView, int paramInt, boolean paramBoolean)
  {
    this.mView = paramView;
    this.mFinalVisibility = paramInt;
    this.mParent = ((ViewGroup)paramView.getParent());
    this.mSuppressLayout = paramBoolean;
    suppressLayout(true);
  }
  
  private void hideViewWhenNotCanceled()
  {
    if (!this.mCanceled)
    {
      ViewUtils.setTransitionVisibility(this.mView, this.mFinalVisibility);
      ViewGroup localViewGroup = this.mParent;
      if (localViewGroup != null) {
        localViewGroup.invalidate();
      }
    }
    suppressLayout(false);
  }
  
  private void suppressLayout(boolean paramBoolean)
  {
    if ((this.mSuppressLayout) && (this.mLayoutSuppressed != paramBoolean))
    {
      ViewGroup localViewGroup = this.mParent;
      if (localViewGroup != null)
      {
        this.mLayoutSuppressed = paramBoolean;
        ViewGroupUtils.suppressLayout(localViewGroup, paramBoolean);
      }
    }
  }
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.mCanceled = true;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    hideViewWhenNotCanceled();
  }
  
  public void onAnimationPause(Animator paramAnimator)
  {
    if (!this.mCanceled) {
      ViewUtils.setTransitionVisibility(this.mView, this.mFinalVisibility);
    }
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationResume(Animator paramAnimator)
  {
    if (!this.mCanceled) {
      ViewUtils.setTransitionVisibility(this.mView, 0);
    }
  }
  
  public void onAnimationStart(Animator paramAnimator) {}
  
  public void onTransitionCancel(@NonNull Transition paramTransition) {}
  
  public void onTransitionEnd(@NonNull Transition paramTransition)
  {
    hideViewWhenNotCanceled();
    paramTransition.removeListener(this);
  }
  
  public void onTransitionPause(@NonNull Transition paramTransition)
  {
    suppressLayout(false);
  }
  
  public void onTransitionResume(@NonNull Transition paramTransition)
  {
    suppressLayout(true);
  }
  
  public void onTransitionStart(@NonNull Transition paramTransition) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.transition.Visibility.DisappearListener
 * JD-Core Version:    0.7.0.1
 */
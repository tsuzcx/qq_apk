package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import androidx.annotation.NonNull;

class TranslationAnimationCreator$TransitionPositionListener
  extends AnimatorListenerAdapter
  implements Transition.TransitionListener
{
  private final View mMovingView;
  private float mPausedX;
  private float mPausedY;
  private final int mStartX;
  private final int mStartY;
  private final float mTerminalX;
  private final float mTerminalY;
  private int[] mTransitionPosition;
  private final View mViewInHierarchy;
  
  TranslationAnimationCreator$TransitionPositionListener(View paramView1, View paramView2, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2)
  {
    this.mMovingView = paramView1;
    this.mViewInHierarchy = paramView2;
    this.mStartX = (paramInt1 - Math.round(this.mMovingView.getTranslationX()));
    this.mStartY = (paramInt2 - Math.round(this.mMovingView.getTranslationY()));
    this.mTerminalX = paramFloat1;
    this.mTerminalY = paramFloat2;
    this.mTransitionPosition = ((int[])this.mViewInHierarchy.getTag(R.id.transition_position));
    if (this.mTransitionPosition != null) {
      this.mViewInHierarchy.setTag(R.id.transition_position, null);
    }
  }
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    if (this.mTransitionPosition == null) {
      this.mTransitionPosition = new int[2];
    }
    this.mTransitionPosition[0] = Math.round(this.mStartX + this.mMovingView.getTranslationX());
    this.mTransitionPosition[1] = Math.round(this.mStartY + this.mMovingView.getTranslationY());
    this.mViewInHierarchy.setTag(R.id.transition_position, this.mTransitionPosition);
  }
  
  public void onAnimationPause(Animator paramAnimator)
  {
    this.mPausedX = this.mMovingView.getTranslationX();
    this.mPausedY = this.mMovingView.getTranslationY();
    this.mMovingView.setTranslationX(this.mTerminalX);
    this.mMovingView.setTranslationY(this.mTerminalY);
  }
  
  public void onAnimationResume(Animator paramAnimator)
  {
    this.mMovingView.setTranslationX(this.mPausedX);
    this.mMovingView.setTranslationY(this.mPausedY);
  }
  
  public void onTransitionCancel(@NonNull Transition paramTransition) {}
  
  public void onTransitionEnd(@NonNull Transition paramTransition)
  {
    this.mMovingView.setTranslationX(this.mTerminalX);
    this.mMovingView.setTranslationY(this.mTerminalY);
    paramTransition.removeListener(this);
  }
  
  public void onTransitionPause(@NonNull Transition paramTransition) {}
  
  public void onTransitionResume(@NonNull Transition paramTransition) {}
  
  public void onTransitionStart(@NonNull Transition paramTransition) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     androidx.transition.TranslationAnimationCreator.TransitionPositionListener
 * JD-Core Version:    0.7.0.1
 */
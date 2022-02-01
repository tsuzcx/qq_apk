package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;

class FastScroller$AnimatorListener
  extends AnimatorListenerAdapter
{
  private boolean mCanceled = false;
  
  FastScroller$AnimatorListener(FastScroller paramFastScroller) {}
  
  public void onAnimationCancel(Animator paramAnimator)
  {
    this.mCanceled = true;
  }
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (this.mCanceled)
    {
      this.mCanceled = false;
      return;
    }
    if (((Float)this.this$0.mShowHideAnimator.getAnimatedValue()).floatValue() == 0.0F)
    {
      paramAnimator = this.this$0;
      paramAnimator.mAnimationState = 0;
      paramAnimator.setState(0);
      return;
    }
    paramAnimator = this.this$0;
    paramAnimator.mAnimationState = 2;
    paramAnimator.requestRedraw();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.recyclerview.widget.FastScroller.AnimatorListener
 * JD-Core Version:    0.7.0.1
 */
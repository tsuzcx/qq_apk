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
      this.this$0.mAnimationState = 0;
      this.this$0.setState(0);
      return;
    }
    this.this$0.mAnimationState = 2;
    this.this$0.requestRedraw();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     androidx.recyclerview.widget.FastScroller.AnimatorListener
 * JD-Core Version:    0.7.0.1
 */
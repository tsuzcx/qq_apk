package androidx.core.widget;

import androidx.core.view.ViewCompat;

class AutoScrollHelper$ScrollAnimationRunnable
  implements Runnable
{
  AutoScrollHelper$ScrollAnimationRunnable(AutoScrollHelper paramAutoScrollHelper) {}
  
  public void run()
  {
    if (!this.this$0.mAnimating) {
      return;
    }
    if (this.this$0.mNeedsReset)
    {
      localObject = this.this$0;
      ((AutoScrollHelper)localObject).mNeedsReset = false;
      ((AutoScrollHelper)localObject).mScroller.start();
    }
    Object localObject = this.this$0.mScroller;
    if ((!((AutoScrollHelper.ClampedScroller)localObject).isFinished()) && (this.this$0.shouldAnimate()))
    {
      if (this.this$0.mNeedsCancel)
      {
        AutoScrollHelper localAutoScrollHelper = this.this$0;
        localAutoScrollHelper.mNeedsCancel = false;
        localAutoScrollHelper.cancelTargetTouch();
      }
      ((AutoScrollHelper.ClampedScroller)localObject).computeScrollDelta();
      int i = ((AutoScrollHelper.ClampedScroller)localObject).getDeltaX();
      int j = ((AutoScrollHelper.ClampedScroller)localObject).getDeltaY();
      this.this$0.scrollTargetBy(i, j);
      ViewCompat.postOnAnimation(this.this$0.mTarget, this);
      return;
    }
    this.this$0.mAnimating = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.core.widget.AutoScrollHelper.ScrollAnimationRunnable
 * JD-Core Version:    0.7.0.1
 */
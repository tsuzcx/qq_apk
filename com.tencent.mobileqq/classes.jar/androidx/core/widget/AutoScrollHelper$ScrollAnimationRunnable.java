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
      this.this$0.mNeedsReset = false;
      this.this$0.mScroller.start();
    }
    AutoScrollHelper.ClampedScroller localClampedScroller = this.this$0.mScroller;
    if ((localClampedScroller.isFinished()) || (!this.this$0.shouldAnimate()))
    {
      this.this$0.mAnimating = false;
      return;
    }
    if (this.this$0.mNeedsCancel)
    {
      this.this$0.mNeedsCancel = false;
      this.this$0.cancelTargetTouch();
    }
    localClampedScroller.computeScrollDelta();
    int i = localClampedScroller.getDeltaX();
    int j = localClampedScroller.getDeltaY();
    this.this$0.scrollTargetBy(i, j);
    ViewCompat.postOnAnimation(this.this$0.mTarget, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     androidx.core.widget.AutoScrollHelper.ScrollAnimationRunnable
 * JD-Core Version:    0.7.0.1
 */
package android.support.v4.widget;

import android.support.v4.view.ViewCompat;

class AutoScrollHelper$ScrollAnimationRunnable
  implements Runnable
{
  private AutoScrollHelper$ScrollAnimationRunnable(AutoScrollHelper paramAutoScrollHelper) {}
  
  public void run()
  {
    if (!AutoScrollHelper.access$100(this.this$0)) {
      return;
    }
    if (AutoScrollHelper.access$200(this.this$0))
    {
      AutoScrollHelper.access$202(this.this$0, false);
      AutoScrollHelper.access$300(this.this$0).start();
    }
    AutoScrollHelper.ClampedScroller localClampedScroller = AutoScrollHelper.access$300(this.this$0);
    if ((localClampedScroller.isFinished()) || (!AutoScrollHelper.access$400(this.this$0)))
    {
      AutoScrollHelper.access$102(this.this$0, false);
      return;
    }
    if (AutoScrollHelper.access$500(this.this$0))
    {
      AutoScrollHelper.access$502(this.this$0, false);
      AutoScrollHelper.access$600(this.this$0);
    }
    localClampedScroller.computeScrollDelta();
    int i = localClampedScroller.getDeltaX();
    int j = localClampedScroller.getDeltaY();
    this.this$0.scrollTargetBy(i, j);
    ViewCompat.postOnAnimation(AutoScrollHelper.access$700(this.this$0), this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.widget.AutoScrollHelper.ScrollAnimationRunnable
 * JD-Core Version:    0.7.0.1
 */
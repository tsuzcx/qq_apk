package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class SwipeRefreshLayout$6
  extends Animation
{
  SwipeRefreshLayout$6(SwipeRefreshLayout paramSwipeRefreshLayout) {}
  
  public void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    float f;
    if (!SwipeRefreshLayout.access$1100(this.this$0)) {
      f = SwipeRefreshLayout.access$1200(this.this$0) - Math.abs(this.this$0.mOriginalOffsetTop);
    } else {
      f = SwipeRefreshLayout.access$1200(this.this$0);
    }
    int j = (int)f;
    int i = this.this$0.mFrom;
    j = (int)((j - this.this$0.mFrom) * paramFloat);
    int k = SwipeRefreshLayout.access$400(this.this$0).getTop();
    SwipeRefreshLayout.access$900(this.this$0, i + j - k, false);
    SwipeRefreshLayout.access$100(this.this$0).setArrowScale(1.0F - paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.widget.SwipeRefreshLayout.6
 * JD-Core Version:    0.7.0.1
 */
package android.support.v4.widget;

import android.view.animation.Animation;
import android.view.animation.Transformation;

class SwipeRefreshLayout$4
  extends Animation
{
  SwipeRefreshLayout$4(SwipeRefreshLayout paramSwipeRefreshLayout, int paramInt1, int paramInt2) {}
  
  public void applyTransformation(float paramFloat, Transformation paramTransformation)
  {
    paramTransformation = SwipeRefreshLayout.access$100(this.this$0);
    int i = this.val$startingAlpha;
    paramTransformation.setAlpha((int)(i + (this.val$endingAlpha - i) * paramFloat));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     android.support.v4.widget.SwipeRefreshLayout.4
 * JD-Core Version:    0.7.0.1
 */
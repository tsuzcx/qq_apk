package androidx.recyclerview.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;

class FastScroller$AnimatorUpdater
  implements ValueAnimator.AnimatorUpdateListener
{
  FastScroller$AnimatorUpdater(FastScroller paramFastScroller) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = (int)(((Float)paramValueAnimator.getAnimatedValue()).floatValue() * 255.0F);
    this.this$0.mVerticalThumbDrawable.setAlpha(i);
    this.this$0.mVerticalTrackDrawable.setAlpha(i);
    this.this$0.requestRedraw();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.recyclerview.widget.FastScroller.AnimatorUpdater
 * JD-Core Version:    0.7.0.1
 */
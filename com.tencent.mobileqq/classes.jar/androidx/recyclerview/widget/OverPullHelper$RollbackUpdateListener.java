package androidx.recyclerview.widget;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class OverPullHelper$RollbackUpdateListener
  implements ValueAnimator.AnimatorUpdateListener
{
  int a;
  int b;
  
  OverPullHelper$RollbackUpdateListener(OverPullHelper paramOverPullHelper, int paramInt)
  {
    this.a = paramInt;
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (OverPullHelper.a(this.c).isDataChangedWithoutNotify()) {
      return;
    }
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    paramValueAnimator = new int[2];
    int j = i - this.a;
    OverPullHelper.a(this.c).scrollStep(0, j, paramValueAnimator);
    int k = paramValueAnimator[1];
    this.b += k;
    j = k - j;
    if (j != 0) {
      OverPullHelper.a(this.c).offsetChildrenVertical(j);
    }
    this.c.a(4);
    this.a = i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     androidx.recyclerview.widget.OverPullHelper.RollbackUpdateListener
 * JD-Core Version:    0.7.0.1
 */
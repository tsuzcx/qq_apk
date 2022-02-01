package com.tencent.mobileqq.activity.aio.item;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;

class UnlimitedBladeWorks$3
  implements ValueAnimator.AnimatorUpdateListener
{
  UnlimitedBladeWorks$3(UnlimitedBladeWorks paramUnlimitedBladeWorks) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    int i = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    paramValueAnimator = (ViewGroup.MarginLayoutParams)UnlimitedBladeWorks.b(this.a).getLayoutParams();
    if (UnlimitedBladeWorks.c(this.a))
    {
      paramValueAnimator.leftMargin = 0;
      paramValueAnimator.rightMargin = i;
    }
    else
    {
      paramValueAnimator.leftMargin = i;
      paramValueAnimator.rightMargin = 0;
    }
    UnlimitedBladeWorks.b(this.a).setLayoutParams(paramValueAnimator);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.UnlimitedBladeWorks.3
 * JD-Core Version:    0.7.0.1
 */
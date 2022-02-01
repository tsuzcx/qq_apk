package com.tencent.mobileqq.apollo.aio.panel;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.ViewGroup;
import android.view.ViewParent;

class ApolloPanelExtendHelper$1
  implements ValueAnimator.AnimatorUpdateListener
{
  ApolloPanelExtendHelper$1(ApolloPanelExtendHelper paramApolloPanelExtendHelper) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    com.tencent.widget.XPanelContainer.a = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
    if (ApolloPanelExtendHelper.a(this.a).getParent() != null) {
      ApolloPanelExtendHelper.a(this.a).getParent().requestLayout();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanelExtendHelper.1
 * JD-Core Version:    0.7.0.1
 */
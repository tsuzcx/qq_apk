package com.tencent.mm.ui.widget.listview;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;

class PullDownListView$5
  implements ValueAnimator.AnimatorUpdateListener
{
  PullDownListView$5(PullDownListView paramPullDownListView) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = (Integer)paramValueAnimator.getAnimatedValue();
    ViewGroup.MarginLayoutParams localMarginLayoutParams = (ViewGroup.MarginLayoutParams)PullDownListView.i(this.a).getLayoutParams();
    localMarginLayoutParams.topMargin = paramValueAnimator.intValue();
    PullDownListView.i(this.a).setLayoutParams(localMarginLayoutParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.ui.widget.listview.PullDownListView.5
 * JD-Core Version:    0.7.0.1
 */
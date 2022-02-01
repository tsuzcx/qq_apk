package com.tencent.biz.qqcircle.widgets.childviewpresenter;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;

class QCircleFeedBottomInputPresenter$2
  implements ValueAnimator.AnimatorUpdateListener
{
  QCircleFeedBottomInputPresenter$2(QCircleFeedBottomInputPresenter paramQCircleFeedBottomInputPresenter) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if ((paramValueAnimator instanceof Integer)) {
      QCircleFeedBottomInputPresenter.access$100(this.a, ((Integer)paramValueAnimator).intValue());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleFeedBottomInputPresenter.2
 * JD-Core Version:    0.7.0.1
 */
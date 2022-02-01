package com.tencent.biz.qqcircle.bizparts;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.qqcircle.widgets.QCircleTitleFollowView;

class QCirclePersonalTitleBarPart$5
  implements ValueAnimator.AnimatorUpdateListener
{
  QCirclePersonalTitleBarPart$5(QCirclePersonalTitleBarPart paramQCirclePersonalTitleBarPart) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (QCirclePersonalTitleBarPart.h(this.a) == null) {
      return;
    }
    QCirclePersonalTitleBarPart.h(this.a).getLayoutParams().width = (((Integer)paramValueAnimator.getAnimatedValue()).intValue() + ViewUtils.a(50.0F));
    QCirclePersonalTitleBarPart.h(this.a).requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePersonalTitleBarPart.5
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.qqcircle.immersive.personal.part;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.qqcircle.widgets.QCircleTitleFollowView;

class QFSPersonalTitleBarPart$6
  implements ValueAnimator.AnimatorUpdateListener
{
  QFSPersonalTitleBarPart$6(QFSPersonalTitleBarPart paramQFSPersonalTitleBarPart) {}
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    QFSPersonalTitleBarPart.d(this.a).getLayoutParams().width = (((Integer)paramValueAnimator.getAnimatedValue()).intValue() + ViewUtils.a(50.0F));
    QFSPersonalTitleBarPart.d(this.a).requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.part.QFSPersonalTitleBarPart.6
 * JD-Core Version:    0.7.0.1
 */
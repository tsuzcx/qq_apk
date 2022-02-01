package com.tencent.biz.qqcircle.bizparts;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.qqcircle.widgets.QCircleTitleFollowView;

class QCirclePersonalTitleBarPart$9
  extends AnimatorListenerAdapter
{
  QCirclePersonalTitleBarPart$9(QCirclePersonalTitleBarPart paramQCirclePersonalTitleBarPart) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    QCirclePersonalTitleBarPart.a(this.a, false);
    QCirclePersonalTitleBarPart.h(this.a).setVisibility(8);
    QCirclePersonalTitleBarPart.h(this.a).getLayoutParams().width = ViewUtils.a(80.0F);
    QCirclePersonalTitleBarPart.h(this.a).setAlpha(1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePersonalTitleBarPart.9
 * JD-Core Version:    0.7.0.1
 */
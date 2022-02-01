package com.tencent.biz.qqcircle.immersive.personal.part;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.biz.qqcircle.utils.ViewUtils;
import com.tencent.biz.qqcircle.widgets.QCircleTitleFollowView;

class QFSPersonalTitleBarPart$10
  extends AnimatorListenerAdapter
{
  QFSPersonalTitleBarPart$10(QFSPersonalTitleBarPart paramQFSPersonalTitleBarPart) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    QFSPersonalTitleBarPart.a(this.a, false);
    QFSPersonalTitleBarPart.d(this.a).setVisibility(8);
    QFSPersonalTitleBarPart.d(this.a).getLayoutParams().width = ViewUtils.a(80.0F);
    QFSPersonalTitleBarPart.d(this.a).setAlpha(1.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.part.QFSPersonalTitleBarPart.10
 * JD-Core Version:    0.7.0.1
 */
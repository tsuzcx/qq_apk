package com.tencent.biz.qqcircle.bizparts;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.widget.ImageView;
import androidx.annotation.RequiresApi;

class QCirclePersonalTitleBarPart$7
  extends AnimatorListenerAdapter
{
  QCirclePersonalTitleBarPart$7(QCirclePersonalTitleBarPart paramQCirclePersonalTitleBarPart) {}
  
  @RequiresApi(api=16)
  public void onAnimationEnd(Animator paramAnimator)
  {
    super.onAnimationEnd(paramAnimator);
    if (QCirclePersonalTitleBarPart.i(this.a) == null) {
      return;
    }
    QCirclePersonalTitleBarPart.i(this.a).setAlpha(1.0F);
    QCirclePersonalTitleBarPart.i(this.a).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePersonalTitleBarPart.7
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.qqcircle.bizparts;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.viewmodels.QCirclePublishButtonViewModel;
import com.tencent.biz.qqcircle.viewmodels.QCirclePublishButtonViewModel.PublishButtonEventInfo;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.widget.QCircleD8SafeAnimatorListener;

class QCirclePublishFeedPart$5
  extends QCircleD8SafeAnimatorListener
{
  QCirclePublishFeedPart$5(QCirclePublishFeedPart paramQCirclePublishFeedPart, QCirclePublishButtonViewModel.PublishButtonEventInfo paramPublishButtonEventInfo) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if ((this.a.a() == 1) && (QCirclePublishFeedPart.c(this.b) != null)) {
      QCirclePublishFeedPart.c(this.b).setClipToPadding(false);
    }
    paramAnimator = new QCirclePublishFeedPart.5.1(this);
    QCirclePublishFeedPart.e(this.b).setOnClickListener(paramAnimator);
    if ((this.a.a() == 1) && (QCirclePublishFeedPart.f(this.b) != null)) {
      QCirclePublishFeedPart.f(this.b).setOnClickListener(paramAnimator);
    }
    QCirclePublishFeedPart.d(this.b).g();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePublishFeedPart.5
 * JD-Core Version:    0.7.0.1
 */
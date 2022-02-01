package com.tencent.biz.qqcircle.bizparts;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.qqcircle.viewmodels.QCirclePublishButtonViewModel;
import com.tencent.biz.qqcircle.viewmodels.QCirclePublishButtonViewModel.PublishButtonEventInfo;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.widget.QCircleD8SafeAnimatorListener;

class QCirclePublishFeedPart$6
  extends QCircleD8SafeAnimatorListener
{
  QCirclePublishFeedPart$6(QCirclePublishFeedPart paramQCirclePublishFeedPart, QCirclePublishButtonViewModel.PublishButtonEventInfo paramPublishButtonEventInfo) {}
  
  public void onAnimationCancel(Animator paramAnimator) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if (QCirclePublishFeedPart.e(this.b) != null) {
      QCirclePublishFeedPart.e(this.b).setVisibility(4);
    }
    if ((this.a.a() == 1) && (QCirclePublishFeedPart.f(this.b) != null)) {
      QCirclePublishFeedPart.f(this.b).setVisibility(4);
    }
    QCirclePublishFeedPart.d(this.b).a(this.b.f(), QCirclePublishFeedPart.g(this.b));
    QCirclePublishFeedPart.d(this.b).h();
  }
  
  public void onAnimationRepeat(Animator paramAnimator) {}
  
  public void onAnimationStart(Animator paramAnimator)
  {
    if ((this.a.a() == 1) && (QCirclePublishFeedPart.c(this.b) != null)) {
      QCirclePublishFeedPart.c(this.b).setClipToPadding(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.bizparts.QCirclePublishFeedPart.6
 * JD-Core Version:    0.7.0.1
 */
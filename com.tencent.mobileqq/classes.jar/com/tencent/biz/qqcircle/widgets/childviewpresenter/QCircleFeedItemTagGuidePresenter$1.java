package com.tencent.biz.qqcircle.widgets.childviewpresenter;

import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import feedcloud.FeedCloudMeta.StFeed;

class QCircleFeedItemTagGuidePresenter$1
  implements View.OnAttachStateChangeListener
{
  QCircleFeedItemTagGuidePresenter$1(QCircleFeedItemTagGuidePresenter paramQCircleFeedItemTagGuidePresenter, FeedCloudMeta.StFeed paramStFeed) {}
  
  public void onViewAttachedToWindow(View paramView)
  {
    if ((this.b.mContainer != null) && (this.b.mContainer.getVisibility() == 0)) {
      QCircleFeedItemTagGuidePresenter.access$000(this.b, this.a, 119, 1);
    }
  }
  
  public void onViewDetachedFromWindow(View paramView)
  {
    if (this.b.mContainer != null) {
      this.b.mContainer.removeOnAttachStateChangeListener(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleFeedItemTagGuidePresenter.1
 * JD-Core Version:    0.7.0.1
 */
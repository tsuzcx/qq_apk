package com.tencent.biz.qqcircle.widgets.childviewpresenter;

import feedcloud.FeedCloudMeta.StFeed;
import java.lang.ref.WeakReference;

class QCircleFeedBottomInputPresenter$QCircleFeedBottomInputRunnable
  implements Runnable
{
  private WeakReference<QCircleFeedBottomInputPresenter> a;
  private FeedCloudMeta.StFeed b;
  
  public QCircleFeedBottomInputPresenter$QCircleFeedBottomInputRunnable(QCircleFeedBottomInputPresenter paramQCircleFeedBottomInputPresenter, FeedCloudMeta.StFeed paramStFeed)
  {
    this.a = new WeakReference(paramQCircleFeedBottomInputPresenter);
    this.b = paramStFeed;
  }
  
  public void run()
  {
    WeakReference localWeakReference = this.a;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      QCircleFeedBottomInputPresenter.access$200((QCircleFeedBottomInputPresenter)this.a.get(), this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleFeedBottomInputPresenter.QCircleFeedBottomInputRunnable
 * JD-Core Version:    0.7.0.1
 */
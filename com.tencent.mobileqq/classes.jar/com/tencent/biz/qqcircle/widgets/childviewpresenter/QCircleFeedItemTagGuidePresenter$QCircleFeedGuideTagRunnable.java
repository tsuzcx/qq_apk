package com.tencent.biz.qqcircle.widgets.childviewpresenter;

import feedcloud.FeedCloudMeta.StFeed;
import java.lang.ref.WeakReference;

class QCircleFeedItemTagGuidePresenter$QCircleFeedGuideTagRunnable
  implements Runnable
{
  private WeakReference<QCircleFeedItemTagGuidePresenter> a;
  private FeedCloudMeta.StFeed b;
  
  public QCircleFeedItemTagGuidePresenter$QCircleFeedGuideTagRunnable(QCircleFeedItemTagGuidePresenter paramQCircleFeedItemTagGuidePresenter, FeedCloudMeta.StFeed paramStFeed)
  {
    this.a = new WeakReference(paramQCircleFeedItemTagGuidePresenter);
    this.b = paramStFeed;
  }
  
  public void run()
  {
    WeakReference localWeakReference = this.a;
    if ((localWeakReference != null) && (localWeakReference.get() != null)) {
      QCircleFeedItemTagGuidePresenter.access$100((QCircleFeedItemTagGuidePresenter)this.a.get(), this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleFeedItemTagGuidePresenter.QCircleFeedGuideTagRunnable
 * JD-Core Version:    0.7.0.1
 */
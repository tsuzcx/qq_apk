package com.tencent.biz.qqcircle.widgets.childviewpresenter;

import androidx.lifecycle.Observer;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.qqcircle.extendpb.FeedStateData;
import java.lang.ref.WeakReference;

class QCircleFeedItemPicPresenter$FeedStateObserver
  implements Observer<FeedStateData>
{
  private final WeakReference<QCircleFeedItemPicPresenter> a;
  
  QCircleFeedItemPicPresenter$FeedStateObserver(QCircleFeedItemPicPresenter paramQCircleFeedItemPicPresenter)
  {
    this.a = new WeakReference(paramQCircleFeedItemPicPresenter);
  }
  
  public void a(FeedStateData paramFeedStateData)
  {
    QCircleFeedItemPicPresenter localQCircleFeedItemPicPresenter = (QCircleFeedItemPicPresenter)this.a.get();
    if (localQCircleFeedItemPicPresenter != null)
    {
      if (QCircleFeedItemPicPresenter.access$300(localQCircleFeedItemPicPresenter) == null) {
        return;
      }
      int i = paramFeedStateData.a();
      QCircleFeedItemPicPresenter.access$300(localQCircleFeedItemPicPresenter).setCurrentItem(i);
      QCircleFeedItemPicPresenter.access$000(localQCircleFeedItemPicPresenter, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.widgets.childviewpresenter.QCircleFeedItemPicPresenter.FeedStateObserver
 * JD-Core Version:    0.7.0.1
 */
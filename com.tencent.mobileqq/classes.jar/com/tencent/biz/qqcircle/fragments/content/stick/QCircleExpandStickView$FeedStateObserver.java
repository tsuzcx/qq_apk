package com.tencent.biz.qqcircle.fragments.content.stick;

import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.extendpb.FeedStateData;
import java.lang.ref.WeakReference;

class QCircleExpandStickView$FeedStateObserver
  implements Observer<FeedStateData>
{
  private final WeakReference<QCircleExpandStickView> a;
  
  QCircleExpandStickView$FeedStateObserver(QCircleExpandStickView paramQCircleExpandStickView)
  {
    this.a = new WeakReference(paramQCircleExpandStickView);
  }
  
  public void a(FeedStateData paramFeedStateData)
  {
    QCircleExpandStickView localQCircleExpandStickView = (QCircleExpandStickView)this.a.get();
    if (localQCircleExpandStickView == null) {
      return;
    }
    localQCircleExpandStickView.a(paramFeedStateData.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.stick.QCircleExpandStickView.FeedStateObserver
 * JD-Core Version:    0.7.0.1
 */
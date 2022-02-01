package com.tencent.biz.qqcircle.fragments.content;

import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.extendpb.FeedStateData;
import java.lang.ref.WeakReference;

class QCircleContentOperationView$FeedStateObserver
  implements Observer<FeedStateData>
{
  private final WeakReference<QCircleContentOperationView> a;
  
  QCircleContentOperationView$FeedStateObserver(QCircleContentOperationView paramQCircleContentOperationView)
  {
    this.a = new WeakReference(paramQCircleContentOperationView);
  }
  
  public void a(FeedStateData paramFeedStateData)
  {
    QCircleContentOperationView localQCircleContentOperationView = (QCircleContentOperationView)this.a.get();
    if (localQCircleContentOperationView == null) {
      return;
    }
    localQCircleContentOperationView.setCurPicPos(paramFeedStateData.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.fragments.content.QCircleContentOperationView.FeedStateObserver
 * JD-Core Version:    0.7.0.1
 */
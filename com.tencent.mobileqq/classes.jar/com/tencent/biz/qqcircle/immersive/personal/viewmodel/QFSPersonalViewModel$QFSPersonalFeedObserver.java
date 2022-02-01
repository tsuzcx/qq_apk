package com.tencent.biz.qqcircle.immersive.personal.viewmodel;

import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.datacenter.QCircleFeedDataCenter;
import com.tencent.biz.qqcircle.extendpb.FeedBlockData;
import java.lang.ref.WeakReference;

class QFSPersonalViewModel$QFSPersonalFeedObserver
  implements Observer<FeedBlockData>
{
  private final WeakReference<QFSPersonalViewModel> a;
  
  public QFSPersonalViewModel$QFSPersonalFeedObserver(QFSPersonalViewModel paramQFSPersonalViewModel)
  {
    this.a = new WeakReference(paramQFSPersonalViewModel);
  }
  
  public void a(FeedBlockData paramFeedBlockData)
  {
    if (this.a.get() != null) {
      ((QFSPersonalViewModel)this.a.get()).a(paramFeedBlockData);
    }
  }
  
  public void b(FeedBlockData paramFeedBlockData)
  {
    QCircleFeedDataCenter.a().a(paramFeedBlockData, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.viewmodel.QFSPersonalViewModel.QFSPersonalFeedObserver
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.qqcircle.immersive.personal.viewmodel;

import androidx.lifecycle.Observer;
import com.tencent.biz.qqcircle.datacenter.QCircleFeedDataCenter;
import com.tencent.biz.qqcircle.datacenter.data.QFSUserFollowData;
import java.lang.ref.WeakReference;

class QFSPersonalViewModel$QFSUserFollowDataObserver
  implements Observer<QFSUserFollowData>
{
  private final WeakReference<QFSPersonalViewModel> a;
  
  public QFSPersonalViewModel$QFSUserFollowDataObserver(QFSPersonalViewModel paramQFSPersonalViewModel)
  {
    this.a = new WeakReference(paramQFSPersonalViewModel);
  }
  
  public void a(QFSUserFollowData paramQFSUserFollowData)
  {
    if (this.a.get() != null) {
      ((QFSPersonalViewModel)this.a.get()).a(paramQFSUserFollowData);
    }
  }
  
  public void b(QFSUserFollowData paramQFSUserFollowData)
  {
    QCircleFeedDataCenter.a().a(paramQFSUserFollowData, this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.viewmodel.QFSPersonalViewModel.QFSUserFollowDataObserver
 * JD-Core Version:    0.7.0.1
 */
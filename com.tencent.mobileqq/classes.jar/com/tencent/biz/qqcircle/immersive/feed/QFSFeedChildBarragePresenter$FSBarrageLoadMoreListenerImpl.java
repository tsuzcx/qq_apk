package com.tencent.biz.qqcircle.immersive.feed;

import com.tencent.biz.qqcircle.immersive.viewmodel.barrage.IQFSBarrageViewModel.OnBarrageLoadMoreListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class QFSFeedChildBarragePresenter$FSBarrageLoadMoreListenerImpl
  implements IQFSBarrageViewModel.OnBarrageLoadMoreListener
{
  private WeakReference<QFSFeedChildBarragePresenter> a;
  
  public QFSFeedChildBarragePresenter$FSBarrageLoadMoreListenerImpl(QFSFeedChildBarragePresenter paramQFSFeedChildBarragePresenter)
  {
    this.a = new WeakReference(paramQFSFeedChildBarragePresenter);
  }
  
  public void a()
  {
    Object localObject = this.a;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (QFSFeedChildBarragePresenter)((WeakReference)localObject).get();
    }
    if (localObject == null)
    {
      QLog.d("FSBarrageLoadMoreListenerImpl", 1, "[onBarrageLoadMore] presenter should not be null.");
      return;
    }
    QFSFeedChildBarragePresenter.a((QFSFeedChildBarragePresenter)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildBarragePresenter.FSBarrageLoadMoreListenerImpl
 * JD-Core Version:    0.7.0.1
 */
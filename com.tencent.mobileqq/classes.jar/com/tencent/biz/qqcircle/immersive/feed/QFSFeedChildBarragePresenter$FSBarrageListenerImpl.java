package com.tencent.biz.qqcircle.immersive.feed;

import com.tencent.biz.qqcircle.immersive.viewmodel.barrage.IQFSBarrageViewModel.OnMeasureBarrageListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class QFSFeedChildBarragePresenter$FSBarrageListenerImpl
  implements IQFSBarrageViewModel.OnMeasureBarrageListener
{
  private WeakReference<QFSFeedChildBarragePresenter> a;
  
  public QFSFeedChildBarragePresenter$FSBarrageListenerImpl(QFSFeedChildBarragePresenter paramQFSFeedChildBarragePresenter)
  {
    this.a = new WeakReference(paramQFSFeedChildBarragePresenter);
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject = this.a;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (QFSFeedChildBarragePresenter)((WeakReference)localObject).get();
    }
    if (localObject == null)
    {
      QLog.d("QDM-QFSFeedChildBarragePresenter", 1, "[loadMeasureFinish] presenter should not be null.");
      return;
    }
    QFSFeedChildBarragePresenter.a((QFSFeedChildBarragePresenter)localObject, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.feed.QFSFeedChildBarragePresenter.FSBarrageListenerImpl
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.qqcircle.immersive.viewmodel.barrage;

import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class QFSBarrageViewModel$FSBarrageLoadMoreRunnableImpl
  implements Runnable
{
  private WeakReference<QFSBarrageViewModel> a;
  
  public QFSBarrageViewModel$FSBarrageLoadMoreRunnableImpl(QFSBarrageViewModel paramQFSBarrageViewModel)
  {
    this.a = new WeakReference(paramQFSBarrageViewModel);
  }
  
  public void run()
  {
    Object localObject = this.a;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (QFSBarrageViewModel)((WeakReference)localObject).get();
    }
    if (localObject == null)
    {
      QLog.d("QDM-FSBarrageViewModel", 1, "[run] model should not be null.");
      return;
    }
    QFSBarrageViewModel.b((QFSBarrageViewModel)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.viewmodel.barrage.QFSBarrageViewModel.FSBarrageLoadMoreRunnableImpl
 * JD-Core Version:    0.7.0.1
 */
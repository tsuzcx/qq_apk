package com.tencent.biz.qqcircle.immersive.viewmodel.barrage;

import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class QFSBarrageViewModel$FSBarrageMeasureImpl
  implements Runnable
{
  private WeakReference<QFSBarrageViewModel> a;
  private volatile boolean b = false;
  
  public QFSBarrageViewModel$FSBarrageMeasureImpl(QFSBarrageViewModel paramQFSBarrageViewModel, boolean paramBoolean)
  {
    this.a = new WeakReference(paramQFSBarrageViewModel);
    this.b = paramBoolean;
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
    QFSBarrageViewModel.a((QFSBarrageViewModel)localObject, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.viewmodel.barrage.QFSBarrageViewModel.FSBarrageMeasureImpl
 * JD-Core Version:    0.7.0.1
 */
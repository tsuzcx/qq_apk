package com.tencent.biz.qqcircle.immersive.viewmodel.barrage;

import com.tencent.qphone.base.util.QLog;
import com.tencent.rfw.barrage.data.RFWBaseBarrage;
import java.lang.ref.WeakReference;

class QFSBarrageViewModel$FSBarrageClickRunnableImpl
  implements Runnable
{
  private WeakReference<QFSBarrageViewModel> a;
  private RFWBaseBarrage b;
  
  public QFSBarrageViewModel$FSBarrageClickRunnableImpl(QFSBarrageViewModel paramQFSBarrageViewModel, RFWBaseBarrage paramRFWBaseBarrage)
  {
    this.a = new WeakReference(paramQFSBarrageViewModel);
    this.b = paramRFWBaseBarrage;
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
    QFSBarrageViewModel.b((QFSBarrageViewModel)localObject, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.viewmodel.barrage.QFSBarrageViewModel.FSBarrageClickRunnableImpl
 * JD-Core Version:    0.7.0.1
 */
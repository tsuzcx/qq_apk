package com.tencent.biz.qqcircle.immersive.viewmodel.barrage;

import com.tencent.qphone.base.util.QLog;
import com.tencent.rfw.barrage.data.RFWBaseBarrage;
import com.tencent.rfw.barrage.inject.IRFWBarrageExposureCallback;
import java.lang.ref.WeakReference;

class QFSBarrageViewModel$FSBarrageExportImpl
  implements IRFWBarrageExposureCallback
{
  private WeakReference<QFSBarrageViewModel> a;
  
  public QFSBarrageViewModel$FSBarrageExportImpl(QFSBarrageViewModel paramQFSBarrageViewModel)
  {
    this.a = new WeakReference(paramQFSBarrageViewModel);
  }
  
  public void a(RFWBaseBarrage paramRFWBaseBarrage)
  {
    Object localObject = this.a;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (QFSBarrageViewModel)((WeakReference)localObject).get();
    }
    if (localObject == null)
    {
      QLog.d("FSBarrageExportImpl", 1, "[onFirstExposure] model should not be null.");
      return;
    }
    QFSBarrageViewModel.a((QFSBarrageViewModel)localObject, paramRFWBaseBarrage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.viewmodel.barrage.QFSBarrageViewModel.FSBarrageExportImpl
 * JD-Core Version:    0.7.0.1
 */
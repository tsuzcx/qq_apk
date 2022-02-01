package com.tencent.biz.qqcircle.immersive.viewmodel.barrage;

import com.tencent.rfw.barrage.inject.IRFWBarragePlayTimeSupplier;
import java.lang.ref.WeakReference;

class QFSBarrageViewModel$BarragePlayTimeSupplier
  implements IRFWBarragePlayTimeSupplier
{
  private final WeakReference<QFSBarrageViewModel> a;
  
  public QFSBarrageViewModel$BarragePlayTimeSupplier(QFSBarrageViewModel paramQFSBarrageViewModel)
  {
    this.a = new WeakReference(paramQFSBarrageViewModel);
  }
  
  public long a()
  {
    QFSBarrageViewModel localQFSBarrageViewModel = (QFSBarrageViewModel)this.a.get();
    if (localQFSBarrageViewModel == null) {
      return 0L;
    }
    return QFSBarrageViewModel.a(localQFSBarrageViewModel);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.viewmodel.barrage.QFSBarrageViewModel.BarragePlayTimeSupplier
 * JD-Core Version:    0.7.0.1
 */
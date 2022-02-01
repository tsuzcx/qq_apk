package com.tencent.biz.qqcircle.immersive.viewmodel.barrage;

import com.tencent.biz.qqcircle.immersive.utils.QFSThreadUtils;
import com.tencent.rfw.barrage.core.RFWBarrageManager.IBarrageListener;
import com.tencent.rfw.barrage.data.RFWBaseBarrage;
import com.tencent.rfw.barrage.tool.RFWClickResult;
import com.tencent.rfw.barrage.tool.RFWTouchPoint;
import java.lang.ref.WeakReference;
import java.util.List;

class QFSBarrageViewModel$BarragePlayListener
  implements RFWBarrageManager.IBarrageListener
{
  private WeakReference<QFSBarrageViewModel> a;
  
  public QFSBarrageViewModel$BarragePlayListener(QFSBarrageViewModel paramQFSBarrageViewModel)
  {
    this.a = new WeakReference(paramQFSBarrageViewModel);
  }
  
  public void a()
  {
    Object localObject = this.a;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (QFSBarrageViewModel)((WeakReference)localObject).get();
    }
    if (localObject == null) {
      return;
    }
    QFSThreadUtils.b(new QFSBarrageViewModel.FSSourceDrawFinishRunnableImpl((QFSBarrageViewModel)localObject));
  }
  
  public void a(RFWBaseBarrage paramRFWBaseBarrage, RFWTouchPoint paramRFWTouchPoint, RFWClickResult paramRFWClickResult)
  {
    paramRFWTouchPoint = this.a;
    if (paramRFWTouchPoint == null) {
      paramRFWTouchPoint = null;
    } else {
      paramRFWTouchPoint = (QFSBarrageViewModel)paramRFWTouchPoint.get();
    }
    if (paramRFWTouchPoint == null) {
      return;
    }
    QFSThreadUtils.b(new QFSBarrageViewModel.FSBarrageClickRunnableImpl(paramRFWTouchPoint, paramRFWBaseBarrage));
  }
  
  public void a(List<RFWBaseBarrage> paramList) {}
  
  public void a(boolean paramBoolean) {}
  
  public void b()
  {
    Object localObject = this.a;
    if (localObject == null) {
      localObject = null;
    } else {
      localObject = (QFSBarrageViewModel)((WeakReference)localObject).get();
    }
    if (localObject == null) {
      return;
    }
    QFSThreadUtils.b(new QFSBarrageViewModel.FSBarrageLoadMoreRunnableImpl((QFSBarrageViewModel)localObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.viewmodel.barrage.QFSBarrageViewModel.BarragePlayListener
 * JD-Core Version:    0.7.0.1
 */
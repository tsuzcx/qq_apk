package com.tencent.biz.qqcircle.immersive.viewmodel.barrage;

import com.tencent.qphone.base.util.QLog;
import com.tencent.rfw.barrage.data.RFWBaseBarrage;
import java.lang.ref.WeakReference;
import java.util.List;

class QFSBarrageViewModel$AsyncUpdateDataSource
  implements Runnable
{
  private WeakReference<QFSBarrageViewModel> a;
  private List<RFWBaseBarrage> b;
  private int c;
  private long d;
  private boolean e;
  private int f;
  
  public QFSBarrageViewModel$AsyncUpdateDataSource(QFSBarrageViewModel paramQFSBarrageViewModel)
  {
    this.a = new WeakReference(paramQFSBarrageViewModel);
  }
  
  public void a(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.d = paramLong;
  }
  
  public void a(List<RFWBaseBarrage> paramList)
  {
    this.b = paramList;
  }
  
  public void a(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public void b(int paramInt)
  {
    this.f = paramInt;
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
    if (this.e)
    {
      QFSBarrageViewModel.a((QFSBarrageViewModel)localObject, this.b, this.c, this.d, this.f);
      return;
    }
    QFSBarrageViewModel.a((QFSBarrageViewModel)localObject, this.b, this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.viewmodel.barrage.QFSBarrageViewModel.AsyncUpdateDataSource
 * JD-Core Version:    0.7.0.1
 */
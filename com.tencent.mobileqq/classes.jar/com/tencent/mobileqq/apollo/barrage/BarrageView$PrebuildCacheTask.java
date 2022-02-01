package com.tencent.mobileqq.apollo.barrage;

import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.lang.ref.WeakReference;
import java.util.List;

class BarrageView$PrebuildCacheTask
  implements Runnable
{
  private WeakReference<BarrageView> a;
  private List<Barrage> b;
  
  BarrageView$PrebuildCacheTask(List<Barrage> paramList, BarrageView paramBarrageView)
  {
    this.a = new WeakReference(paramBarrageView);
    this.b = paramList;
  }
  
  public void run()
  {
    long l = System.currentTimeMillis();
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    localObject = (BarrageView)((WeakReference)localObject).get();
    if (localObject != null)
    {
      if (BarrageView.a((BarrageView)localObject) == null) {
        return;
      }
      List localList = this.b;
      if ((localList != null) && (!localList.isEmpty()))
      {
        int i = localList.size() - 1;
        while (i >= 0)
        {
          ((Barrage)localList.get(i)).b();
          i -= 1;
        }
        BarrageView.a((BarrageView)localObject).obtainMessage(256, 1, 0, localList).sendToTarget();
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("BarrageView PreBuild use->");
        ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
        QLog.d("[cmshow]BarrageView", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.barrage.BarrageView.PrebuildCacheTask
 * JD-Core Version:    0.7.0.1
 */
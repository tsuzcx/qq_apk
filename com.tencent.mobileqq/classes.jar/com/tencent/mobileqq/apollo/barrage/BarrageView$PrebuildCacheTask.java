package com.tencent.mobileqq.apollo.barrage;

import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.lang.ref.WeakReference;
import java.util.List;

class BarrageView$PrebuildCacheTask
  implements Runnable
{
  private WeakReference<BarrageView> jdField_a_of_type_JavaLangRefWeakReference;
  private List<Barrage> jdField_a_of_type_JavaUtilList;
  
  BarrageView$PrebuildCacheTask(List<Barrage> paramList, BarrageView paramBarrageView)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramBarrageView);
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void run()
  {
    long l = System.currentTimeMillis();
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    do
    {
      BarrageView localBarrageView;
      do
      {
        return;
        localBarrageView = (BarrageView)this.jdField_a_of_type_JavaLangRefWeakReference.get();
      } while ((localBarrageView == null) || (BarrageView.a(localBarrageView) == null));
      List localList = this.jdField_a_of_type_JavaUtilList;
      if ((localList != null) && (!localList.isEmpty()))
      {
        int i = localList.size() - 1;
        while (i >= 0)
        {
          ((Barrage)localList.get(i)).a();
          i -= 1;
        }
        BarrageView.a(localBarrageView).obtainMessage(256, 1, 0, localList).sendToTarget();
      }
    } while (!QLog.isColorLevel());
    QLog.d("BarrageView", 2, "BarrageView PreBuild use->" + (System.currentTimeMillis() - l));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.barrage.BarrageView.PrebuildCacheTask
 * JD-Core Version:    0.7.0.1
 */
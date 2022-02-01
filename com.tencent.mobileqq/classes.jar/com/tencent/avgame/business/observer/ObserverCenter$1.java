package com.tencent.avgame.business.observer;

import android.os.SystemClock;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import ndq;
import nds;

public class ObserverCenter$1
  implements Runnable
{
  public ObserverCenter$1(ndq paramndq, BusinessObserver paramBusinessObserver, int paramInt, nds paramnds, boolean paramBoolean, Object paramObject) {}
  
  public void run()
  {
    long l2 = 0L;
    long l1 = l2;
    if (UnifiedMonitor.a().whetherReportDuringThisStartup(1))
    {
      l1 = l2;
      if (this.jdField_a_of_type_Nds == ndq.a(this.this$0)) {
        l1 = SystemClock.uptimeMillis();
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver.onUpdate(this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangObject);
    if ((UnifiedMonitor.a().whetherReportDuringThisStartup(1)) && (this.jdField_a_of_type_Nds == ndq.a(this.this$0)))
    {
      l1 = SystemClock.uptimeMillis() - l1;
      if (ndq.a() == -1) {
        ndq.a(UnifiedMonitor.a().getThreshold(1));
      }
      if (l1 > ndq.a())
      {
        if (UnifiedMonitor.a().whetherReportThisTime(1)) {
          UnifiedMonitor.a().addEvent(1, this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver.getClass().getName(), (int)l1, ndq.b(), null);
        }
        ndq.b(0);
      }
    }
    else
    {
      return;
    }
    ndq.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.business.observer.ObserverCenter.1
 * JD-Core Version:    0.7.0.1
 */
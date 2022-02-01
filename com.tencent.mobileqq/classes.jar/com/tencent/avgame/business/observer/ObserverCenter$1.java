package com.tencent.avgame.business.observer;

import android.os.SystemClock;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qqperf.UnifiedMonitor;

class ObserverCenter$1
  implements Runnable
{
  ObserverCenter$1(ObserverCenter paramObserverCenter, BusinessObserver paramBusinessObserver, int paramInt, WrapperHandler paramWrapperHandler, boolean paramBoolean, Object paramObject) {}
  
  public void run()
  {
    long l;
    if ((UnifiedMonitor.a().whetherReportDuringThisStartup(1)) && (this.jdField_a_of_type_ComTencentAvgameBusinessObserverWrapperHandler == ObserverCenter.a(this.this$0))) {
      l = SystemClock.uptimeMillis();
    } else {
      l = 0L;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver.onUpdate(this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangObject);
    if ((UnifiedMonitor.a().whetherReportDuringThisStartup(1)) && (this.jdField_a_of_type_ComTencentAvgameBusinessObserverWrapperHandler == ObserverCenter.a(this.this$0)))
    {
      l = SystemClock.uptimeMillis() - l;
      if (ObserverCenter.a() == -1) {
        ObserverCenter.a(UnifiedMonitor.a().getThreshold(1));
      }
      if (l > ObserverCenter.a())
      {
        if (UnifiedMonitor.a().whetherReportThisTime(1)) {
          UnifiedMonitor.a().addEvent(1, this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver.getClass().getName(), (int)l, ObserverCenter.b(), null);
        }
        ObserverCenter.b(0);
        return;
      }
      ObserverCenter.c();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.business.observer.ObserverCenter.1
 * JD-Core Version:    0.7.0.1
 */
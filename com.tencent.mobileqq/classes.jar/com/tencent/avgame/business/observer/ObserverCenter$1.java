package com.tencent.avgame.business.observer;

import android.os.SystemClock;
import anil;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import mwu;
import mww;

public class ObserverCenter$1
  implements Runnable
{
  public ObserverCenter$1(mwu parammwu, anil paramanil, int paramInt, mww parammww, boolean paramBoolean, Object paramObject) {}
  
  public void run()
  {
    long l2 = 0L;
    long l1 = l2;
    if (UnifiedMonitor.a().whetherReportDuringThisStartup(1))
    {
      l1 = l2;
      if (this.jdField_a_of_type_Mww == mwu.a(this.this$0)) {
        l1 = SystemClock.uptimeMillis();
      }
    }
    this.jdField_a_of_type_Anil.onUpdate(this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangObject);
    if ((UnifiedMonitor.a().whetherReportDuringThisStartup(1)) && (this.jdField_a_of_type_Mww == mwu.a(this.this$0)))
    {
      l1 = SystemClock.uptimeMillis() - l1;
      if (mwu.a() == -1) {
        mwu.a(UnifiedMonitor.a().getThreshold(1));
      }
      if (l1 > mwu.a())
      {
        if (UnifiedMonitor.a().whetherReportThisTime(1)) {
          UnifiedMonitor.a().addEvent(1, this.jdField_a_of_type_Anil.getClass().getName(), (int)l1, mwu.b(), null);
        }
        mwu.b(0);
      }
    }
    else
    {
      return;
    }
    mwu.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.business.observer.ObserverCenter.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.avgame.business.observer;

import android.os.SystemClock;
import anui;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import mxt;
import mxv;

public class ObserverCenter$1
  implements Runnable
{
  public ObserverCenter$1(mxt parammxt, anui paramanui, int paramInt, mxv parammxv, boolean paramBoolean, Object paramObject) {}
  
  public void run()
  {
    long l2 = 0L;
    long l1 = l2;
    if (UnifiedMonitor.a().whetherReportDuringThisStartup(1))
    {
      l1 = l2;
      if (this.jdField_a_of_type_Mxv == mxt.a(this.this$0)) {
        l1 = SystemClock.uptimeMillis();
      }
    }
    this.jdField_a_of_type_Anui.onUpdate(this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangObject);
    if ((UnifiedMonitor.a().whetherReportDuringThisStartup(1)) && (this.jdField_a_of_type_Mxv == mxt.a(this.this$0)))
    {
      l1 = SystemClock.uptimeMillis() - l1;
      if (mxt.a() == -1) {
        mxt.a(UnifiedMonitor.a().getThreshold(1));
      }
      if (l1 > mxt.a())
      {
        if (UnifiedMonitor.a().whetherReportThisTime(1)) {
          UnifiedMonitor.a().addEvent(1, this.jdField_a_of_type_Anui.getClass().getName(), (int)l1, mxt.b(), null);
        }
        mxt.b(0);
      }
    }
    else
    {
      return;
    }
    mxt.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.business.observer.ObserverCenter.1
 * JD-Core Version:    0.7.0.1
 */
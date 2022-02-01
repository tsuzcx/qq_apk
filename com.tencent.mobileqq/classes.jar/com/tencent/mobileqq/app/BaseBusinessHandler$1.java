package com.tencent.mobileqq.app;

import android.os.SystemClock;
import anty;
import anui;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import mqq.os.MqqHandler;

public class BaseBusinessHandler$1
  implements Runnable
{
  public BaseBusinessHandler$1(anty paramanty, anui paramanui, int paramInt, MqqHandler paramMqqHandler, boolean paramBoolean, Object paramObject) {}
  
  public void run()
  {
    long l2 = 0L;
    long l1 = l2;
    if (UnifiedMonitor.a().whetherReportDuringThisStartup(1))
    {
      l1 = l2;
      if (this.jdField_a_of_type_MqqOsMqqHandler == anty.access$000()) {
        l1 = SystemClock.uptimeMillis();
      }
    }
    this.jdField_a_of_type_Anui.onUpdate(this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangObject);
    if ((UnifiedMonitor.a().whetherReportDuringThisStartup(1)) && (this.jdField_a_of_type_MqqOsMqqHandler == anty.access$000()))
    {
      l1 = SystemClock.uptimeMillis() - l1;
      if (anty.access$100() == -1) {
        anty.access$102(UnifiedMonitor.a().getThreshold(1));
      }
      if (l1 > anty.access$100())
      {
        if (UnifiedMonitor.a().whetherReportThisTime(1)) {
          UnifiedMonitor.a().addEvent(1, this.jdField_a_of_type_Anui.getClass().getName(), (int)l1, anty.access$200(), null);
        }
        anty.access$202(0);
      }
    }
    else
    {
      return;
    }
    anty.access$208();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.BaseBusinessHandler.1
 * JD-Core Version:    0.7.0.1
 */
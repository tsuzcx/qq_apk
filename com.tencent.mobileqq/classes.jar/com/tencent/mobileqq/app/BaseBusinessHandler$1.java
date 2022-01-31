package com.tencent.mobileqq.app;

import ajew;
import ajfe;
import android.os.SystemClock;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import mqq.os.MqqHandler;

public class BaseBusinessHandler$1
  implements Runnable
{
  public BaseBusinessHandler$1(ajew paramajew, ajfe paramajfe, int paramInt, MqqHandler paramMqqHandler, boolean paramBoolean, Object paramObject) {}
  
  public void run()
  {
    long l2 = 0L;
    long l1 = l2;
    if (UnifiedMonitor.a().whetherReportDuringThisStartup(1))
    {
      l1 = l2;
      if (this.jdField_a_of_type_MqqOsMqqHandler == ajew.access$000()) {
        l1 = SystemClock.uptimeMillis();
      }
    }
    this.jdField_a_of_type_Ajfe.onUpdate(this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, this.jdField_a_of_type_JavaLangObject);
    if ((UnifiedMonitor.a().whetherReportDuringThisStartup(1)) && (this.jdField_a_of_type_MqqOsMqqHandler == ajew.access$000()))
    {
      l1 = SystemClock.uptimeMillis() - l1;
      if (ajew.access$100() == -1) {
        ajew.access$102(UnifiedMonitor.a().getThreshold(1));
      }
      if (l1 > ajew.access$100())
      {
        if (UnifiedMonitor.a().whetherReportThisTime(1)) {
          UnifiedMonitor.a().addEvent(1, this.jdField_a_of_type_Ajfe.getClass().getName(), (int)l1, ajew.access$200(), null);
        }
        ajew.access$202(0);
      }
    }
    else
    {
      return;
    }
    ajew.access$208();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.BaseBusinessHandler.1
 * JD-Core Version:    0.7.0.1
 */
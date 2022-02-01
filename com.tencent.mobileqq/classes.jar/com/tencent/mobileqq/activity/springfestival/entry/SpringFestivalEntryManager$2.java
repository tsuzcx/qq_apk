package com.tencent.mobileqq.activity.springfestival.entry;

import com.tencent.mobileqq.activity.springfestival.report.SpringHbMonitorReporter;
import com.tencent.qphone.base.util.QLog;

class SpringFestivalEntryManager$2
  implements Runnable
{
  SpringFestivalEntryManager$2(SpringFestivalEntryManager paramSpringFestivalEntryManager) {}
  
  public void run()
  {
    try
    {
      if ((SpringFestivalEntryManager.a(this.this$0) != 0) && (SpringFestivalEntryManager.a(this.this$0) != 3) && (SpringFestivalEntryManager.a(this.this$0) != 4)) {
        SpringFestivalEntryManager.a(this.this$0, this.this$0.a());
      }
      SpringFestivalEntryManager.b(this.this$0);
      SpringFestivalEntryManager.c(this.this$0);
      SpringFestivalEntryManager.d(this.this$0);
      SpringFestivalEntryManager.e(this.this$0);
      return;
    }
    catch (Throwable localThrowable)
    {
      SpringHbMonitorReporter.a(202, localThrowable, new String[0]);
      QLog.d("shua2021_SpringFestivalEntryManager", 1, "generateTasksAndLaunch ex. " + localThrowable.getMessage(), localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.SpringFestivalEntryManager.2
 * JD-Core Version:    0.7.0.1
 */
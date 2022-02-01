package com.tencent.mobileqq.activity.springfestival.entry;

import com.tencent.mobileqq.activity.springfestival.report.SpringHbMonitorReporter;

class PreloadResHandler$1
  implements Runnable
{
  PreloadResHandler$1(PreloadResHandler paramPreloadResHandler) {}
  
  public void run()
  {
    try
    {
      PreloadResHandler.a(this.this$0);
      return;
    }
    catch (Throwable localThrowable)
    {
      SpringHbMonitorReporter.a(101, localThrowable, new String[0]);
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.entry.PreloadResHandler.1
 * JD-Core Version:    0.7.0.1
 */
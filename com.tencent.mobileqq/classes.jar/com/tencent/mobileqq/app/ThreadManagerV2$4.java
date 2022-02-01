package com.tencent.mobileqq.app;

import java.util.Timer;
import java.util.TimerTask;

final class ThreadManagerV2$4
  extends Timer
{
  ThreadManagerV2$4(String paramString)
  {
    super(paramString);
  }
  
  public void cancel()
  {
    ThreadLog.printQLog("ThreadManager", "Can't cancel Global Timer");
    if (ThreadSetting.isPublicVersion) {
      return;
    }
    throw new RuntimeException("Can't cancel Global Timer");
  }
  
  public void schedule(TimerTask paramTimerTask, long paramLong)
  {
    try
    {
      super.schedule(paramTimerTask, paramLong);
      return;
    }
    catch (Exception paramTimerTask)
    {
      ThreadLog.printQLog("ThreadManager", "timer schedule err", paramTimerTask);
    }
  }
  
  public void schedule(TimerTask paramTimerTask, long paramLong1, long paramLong2)
  {
    try
    {
      super.schedule(paramTimerTask, paramLong1, paramLong2);
      return;
    }
    catch (Exception paramTimerTask)
    {
      ThreadLog.printQLog("ThreadManager", "timer schedule2 err", paramTimerTask);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.ThreadManagerV2.4
 * JD-Core Version:    0.7.0.1
 */
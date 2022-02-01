package com.tencent.component.network.utils.thread;

import android.util.Log;
import com.tencent.component.network.module.base.Config;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

class SmartThreadExecutor$TempTask
  implements Runnable
{
  private static final String TAG = "TempTask";
  private volatile Thread currentThread;
  
  private SmartThreadExecutor$TempTask(SmartThreadExecutor paramSmartThreadExecutor) {}
  
  public void run()
  {
    Log.i("TempTask", "run: start");
    this.currentThread = Thread.currentThread();
    int i = 1;
    Integer localInteger = Integer.valueOf(1);
    while ((SmartThreadExecutor.access$500(this.this$0)) && (SmartThreadExecutor.access$600(this.this$0).get()))
    {
      StringBuilder localStringBuilder;
      try
      {
        Runnable localRunnable = (Runnable)SmartThreadExecutor.access$700(this.this$0).take();
      }
      catch (InterruptedException localInterruptedException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("run: interrupted ");
        localStringBuilder.append(localInterruptedException.getMessage());
        Log.i("TempTask", localStringBuilder.toString());
        ??? = null;
      }
      if (??? != null)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("run: execute task ");
        localStringBuilder.append(???.getClass().getSimpleName());
        Log.i("TempTask", localStringBuilder.toString());
        long l = System.nanoTime();
        ((Runnable)???).run();
        l = TimeUnit.NANOSECONDS.toSeconds(System.nanoTime() - l);
        ??? = new StringBuilder();
        ((StringBuilder)???).append("run: execute task pass time ");
        ((StringBuilder)???).append(l);
        Log.i("TempTask", ((StringBuilder)???).toString());
        if (l <= 2L)
        {
          ??? = new Properties();
          ((Properties)???).put("total", localInteger);
          if (i != 0) {
            ((Properties)???).put("valid", localInteger);
          }
          Config.reportToMta("qzone_downloader_smart_thread_event_temp_thread", (Properties)???);
        }
        i = 0;
      }
    }
    synchronized (SmartThreadExecutor.access$800(this.this$0))
    {
      SmartThreadExecutor.access$800(this.this$0).remove(this);
      this.currentThread = null;
      Log.i("TempTask", "run: end");
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.network.utils.thread.SmartThreadExecutor.TempTask
 * JD-Core Version:    0.7.0.1
 */
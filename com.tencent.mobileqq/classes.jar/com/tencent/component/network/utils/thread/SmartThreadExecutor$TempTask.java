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
    if ((SmartThreadExecutor.access$500(this.this$0)) && (SmartThreadExecutor.access$600(this.this$0).get())) {}
    label285:
    for (;;)
    {
      try
      {
        Object localObject1 = (Runnable)SmartThreadExecutor.access$700(this.this$0).take();
        if (localObject1 == null) {
          break label285;
        }
        Log.i("TempTask", "run: execute task " + localObject1.getClass().getSimpleName());
        long l = System.nanoTime();
        ((Runnable)localObject1).run();
        l = TimeUnit.NANOSECONDS.toSeconds(System.nanoTime() - l);
        Log.i("TempTask", "run: execute task pass time " + l);
        if (l <= 2L)
        {
          localObject1 = new Properties();
          ((Properties)localObject1).put("total", Integer.valueOf(1));
          if (i != 0) {
            ((Properties)localObject1).put("valid", Integer.valueOf(1));
          }
          Config.reportToMta("qzone_downloader_smart_thread_event_temp_thread", (Properties)localObject1);
        }
        i = 0;
      }
      catch (InterruptedException localInterruptedException)
      {
        Log.i("TempTask", "run: interrupted " + localInterruptedException.getMessage());
        ??? = null;
        continue;
      }
      synchronized (SmartThreadExecutor.access$800(this.this$0))
      {
        SmartThreadExecutor.access$800(this.this$0).remove(this);
        this.currentThread = null;
        Log.i("TempTask", "run: end");
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.utils.thread.SmartThreadExecutor.TempTask
 * JD-Core Version:    0.7.0.1
 */
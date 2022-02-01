package com.mojitox.mxflutter.framework.executor;

import androidx.annotation.NonNull;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

public class JobExecutor
  implements ThreadExecutor
{
  private static final AtomicInteger a = new AtomicInteger(1);
  private boolean b;
  private final ScheduledExecutorService c = Executors.newSingleThreadScheduledExecutor();
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public void execute(@NonNull Runnable paramRunnable)
  {
    if (this.b)
    {
      UiThread.a(paramRunnable);
      return;
    }
    this.c.execute(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.executor.JobExecutor
 * JD-Core Version:    0.7.0.1
 */
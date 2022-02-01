package com.mojitox.mxflutter.framework.executor;

import androidx.annotation.NonNull;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

public class JobExecutor
  implements ThreadExecutor
{
  private static final AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(1);
  private final ScheduledExecutorService jdField_a_of_type_JavaUtilConcurrentScheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
  private boolean jdField_a_of_type_Boolean;
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public void execute(@NonNull Runnable paramRunnable)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      UiThread.a(paramRunnable);
      return;
    }
    this.jdField_a_of_type_JavaUtilConcurrentScheduledExecutorService.execute(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.mojitox.mxflutter.framework.executor.JobExecutor
 * JD-Core Version:    0.7.0.1
 */
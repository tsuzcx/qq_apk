package com.tencent.gathererga.core.internal.util;

import com.tencent.gathererga.core.IExecutor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class GathererExecutor$DefaultExecutor
  implements IExecutor
{
  private ExecutorService a = new ThreadPoolExecutor(0, 2147483647, 10L, TimeUnit.SECONDS, new SynchronousQueue(), new GathererExecutor.DefaultThreadFactory());
  
  public void execute(Runnable paramRunnable)
  {
    this.a.execute(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gathererga.core.internal.util.GathererExecutor.DefaultExecutor
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.component.network.utils.thread;

import com.tencent.component.network.utils.thread.internel.ArrayDeque;
import java.util.concurrent.Executor;

class AsyncTask$SerialExecutor
  implements Executor
{
  Runnable mActive;
  final ArrayDeque<Runnable> mTasks = new ArrayDeque();
  
  public void execute(Runnable paramRunnable)
  {
    try
    {
      this.mTasks.offer(new AsyncTask.SerialExecutor.1(this, paramRunnable));
      if (this.mActive == null) {
        scheduleNext();
      }
      return;
    }
    finally
    {
      paramRunnable = finally;
      throw paramRunnable;
    }
  }
  
  protected void scheduleNext()
  {
    try
    {
      Runnable localRunnable = (Runnable)this.mTasks.poll();
      this.mActive = localRunnable;
      if (localRunnable != null) {
        AsyncTask.THREAD_POOL_EXECUTOR.execute(this.mActive);
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.network.utils.thread.AsyncTask.SerialExecutor
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.map.lib.thread;

import java.util.LinkedList;
import java.util.concurrent.Executor;

final class AsyncTask$c
  implements Executor
{
  final LinkedList<Runnable> a = new LinkedList();
  Runnable b;
  
  protected final void a()
  {
    try
    {
      Runnable localRunnable = (Runnable)this.a.poll();
      this.b = localRunnable;
      if (localRunnable != null) {
        AsyncTask.sHighThreadExecutor.execute(this.b);
      }
      return;
    }
    finally {}
  }
  
  public final void execute(Runnable paramRunnable)
  {
    try
    {
      this.a.offer(new AsyncTask.c.1(this, paramRunnable));
      if (this.b == null) {
        a();
      }
      return;
    }
    finally
    {
      paramRunnable = finally;
      throw paramRunnable;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.map.lib.thread.AsyncTask.c
 * JD-Core Version:    0.7.0.1
 */
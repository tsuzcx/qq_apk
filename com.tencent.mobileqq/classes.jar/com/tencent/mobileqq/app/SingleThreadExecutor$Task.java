package com.tencent.mobileqq.app;

import java.util.Queue;

class SingleThreadExecutor$Task
  implements Runnable
{
  final Runnable a;
  
  private SingleThreadExecutor$Task(SingleThreadExecutor paramSingleThreadExecutor, Runnable paramRunnable)
  {
    this.a = paramRunnable;
  }
  
  public void run()
  {
    this.a.run();
    synchronized (SingleThreadExecutor.a(this.this$0))
    {
      Runnable localRunnable = (Runnable)SingleThreadExecutor.b(this.this$0).poll();
      if (localRunnable == null) {
        SingleThreadExecutor.a(this.this$0, false);
      }
      if (localRunnable != null) {
        SingleThreadExecutor.a(this.this$0, localRunnable);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.SingleThreadExecutor.Task
 * JD-Core Version:    0.7.0.1
 */
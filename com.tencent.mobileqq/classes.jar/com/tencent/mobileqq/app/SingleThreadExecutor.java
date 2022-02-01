package com.tencent.mobileqq.app;

import android.support.annotation.NonNull;
import java.util.LinkedList;
import java.util.Queue;
import javax.annotation.concurrent.GuardedBy;

class SingleThreadExecutor
  extends ThreadManagerExecutor
{
  @GuardedBy("lock")
  private final Queue<Runnable> a = new LinkedList();
  @GuardedBy("lock")
  private boolean b = false;
  private final Object c = new Object();
  
  SingleThreadExecutor(int paramInt)
  {
    super(paramInt);
  }
  
  public void execute(@NonNull Runnable arg1)
  {
    SingleThreadExecutor.Task localTask = new SingleThreadExecutor.Task(this, ???, null);
    synchronized (this.c)
    {
      if (!this.b)
      {
        this.b = true;
        super.execute(localTask);
      }
      else
      {
        this.a.offer(localTask);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.SingleThreadExecutor
 * JD-Core Version:    0.7.0.1
 */
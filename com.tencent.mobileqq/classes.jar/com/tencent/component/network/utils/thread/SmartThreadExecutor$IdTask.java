package com.tencent.component.network.utils.thread;

import java.util.UUID;

class SmartThreadExecutor$IdTask
  implements Comparable<IdTask>, Runnable
{
  private final String id = UUID.randomUUID().toString();
  private final Runnable task;
  
  private SmartThreadExecutor$IdTask(Runnable paramRunnable)
  {
    this.task = paramRunnable;
  }
  
  public int compareTo(IdTask paramIdTask)
  {
    Runnable localRunnable = this.task;
    if (localRunnable == null) {
      return -1;
    }
    if (paramIdTask.task == null) {
      return 1;
    }
    if (localRunnable.getClass() == paramIdTask.task.getClass())
    {
      localRunnable = this.task;
      if ((localRunnable instanceof Comparable)) {
        return ((Comparable)localRunnable).compareTo(paramIdTask.task);
      }
    }
    return this.id.compareTo(paramIdTask.id);
  }
  
  public void run()
  {
    Runnable localRunnable = this.task;
    if (localRunnable != null) {
      localRunnable.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.utils.thread.SmartThreadExecutor.IdTask
 * JD-Core Version:    0.7.0.1
 */
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
    if (this.task == null) {
      return -1;
    }
    if (paramIdTask.task == null) {
      return 1;
    }
    if ((this.task.getClass() == paramIdTask.task.getClass()) && ((this.task instanceof Comparable))) {
      return ((Comparable)this.task).compareTo(paramIdTask.task);
    }
    return this.id.compareTo(paramIdTask.id);
  }
  
  public void run()
  {
    if (this.task != null) {
      this.task.run();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.component.network.utils.thread.SmartThreadExecutor.IdTask
 * JD-Core Version:    0.7.0.1
 */
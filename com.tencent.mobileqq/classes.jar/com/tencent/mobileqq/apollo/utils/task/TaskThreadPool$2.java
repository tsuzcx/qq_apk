package com.tencent.mobileqq.apollo.utils.task;

import anmu;
import com.tencent.qphone.base.util.QLog;
import java.util.Queue;
import java.util.concurrent.ThreadPoolExecutor;

public class TaskThreadPool$2
  implements Runnable
{
  public TaskThreadPool$2(anmu paramanmu) {}
  
  public void run()
  {
    try
    {
      if (anmu.a(this.this$0)) {
        anmu.a(this.this$0).execute((Runnable)anmu.a(this.this$0).poll());
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ThreadPool", 1, "", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.task.TaskThreadPool.2
 * JD-Core Version:    0.7.0.1
 */
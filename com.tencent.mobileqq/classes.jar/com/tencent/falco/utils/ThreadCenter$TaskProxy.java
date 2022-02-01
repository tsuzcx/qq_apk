package com.tencent.falco.utils;

import android.util.Log;

public class ThreadCenter$TaskProxy
  implements Comparable<TaskProxy>, Runnable
{
  static final int MAX_TIME = 5000;
  static final String TAG = "taskproxy_log";
  int priority;
  StackTraceElement[] stackElements;
  Runnable task;
  
  public ThreadCenter$TaskProxy(int paramInt, Runnable paramRunnable)
  {
    this.priority = paramInt;
    this.task = paramRunnable;
    if (ThreadCenter.debugEnv) {
      this.stackElements = new Throwable().getStackTrace();
    }
  }
  
  public int compareTo(TaskProxy paramTaskProxy)
  {
    return this.priority - paramTaskProxy.priority;
  }
  
  public void run()
  {
    long l = System.currentTimeMillis();
    this.task.run();
    if (System.currentTimeMillis() - l > 5000L) {
      showTaskSrc();
    }
  }
  
  void showTaskSrc()
  {
    if (this.stackElements != null)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.stackElements[3].getClassName());
      ((StringBuilder)localObject).append("(line ");
      ((StringBuilder)localObject).append(this.stackElements[3].getLineNumber());
      ((StringBuilder)localObject).append("):");
      ((StringBuilder)localObject).append(this.stackElements[3].getMethodName());
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("one task has consumed too long time:\n");
      localStringBuilder.append((String)localObject);
      Log.e("taskproxy_log", localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.falco.utils.ThreadCenter.TaskProxy
 * JD-Core Version:    0.7.0.1
 */
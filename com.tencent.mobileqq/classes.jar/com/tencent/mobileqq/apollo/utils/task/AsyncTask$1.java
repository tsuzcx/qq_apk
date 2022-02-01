package com.tencent.mobileqq.apollo.utils.task;

import anmo;
import com.tencent.qphone.base.util.QLog;

public class AsyncTask$1
  implements Runnable
{
  public AsyncTask$1(anmo paramanmo) {}
  
  public void run()
  {
    QLog.i("TaskFlow", 1, "Task executeAsync : " + this.this$0.b());
    this.this$0.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.task.AsyncTask.1
 * JD-Core Version:    0.7.0.1
 */
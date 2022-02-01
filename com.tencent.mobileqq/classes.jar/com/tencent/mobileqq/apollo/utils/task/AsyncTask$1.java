package com.tencent.mobileqq.apollo.utils.task;

import com.tencent.qphone.base.util.QLog;

class AsyncTask$1
  implements Runnable
{
  AsyncTask$1(AsyncTask paramAsyncTask) {}
  
  public void run()
  {
    QLog.i("TaskFlow", 1, "Task executeAsync : " + this.this$0.b());
    this.this$0.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.task.AsyncTask.1
 * JD-Core Version:    0.7.0.1
 */
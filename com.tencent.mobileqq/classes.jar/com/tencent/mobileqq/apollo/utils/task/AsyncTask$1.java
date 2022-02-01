package com.tencent.mobileqq.apollo.utils.task;

import com.tencent.qphone.base.util.QLog;

class AsyncTask$1
  implements Runnable
{
  AsyncTask$1(AsyncTask paramAsyncTask) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Task executeAsync : ");
    localStringBuilder.append(this.this$0.f());
    QLog.i("[cmshow]TaskFlow", 1, localStringBuilder.toString());
    this.this$0.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.task.AsyncTask.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.apollo.utils.task;

import com.tencent.qphone.base.util.QLog;

class MainThreadTask$1
  implements Runnable
{
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Task executeAsync : ");
    localStringBuilder.append(this.this$0.f());
    QLog.i("MainThreadTask", 1, localStringBuilder.toString());
    this.this$0.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.task.MainThreadTask.1
 * JD-Core Version:    0.7.0.1
 */
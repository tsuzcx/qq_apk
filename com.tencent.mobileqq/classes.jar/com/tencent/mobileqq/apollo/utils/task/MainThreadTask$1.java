package com.tencent.mobileqq.apollo.utils.task;

import com.tencent.qphone.base.util.QLog;

class MainThreadTask$1
  implements Runnable
{
  public void run()
  {
    QLog.i("MainThreadTask", 1, "Task executeAsync : " + this.this$0.b());
    this.this$0.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.task.MainThreadTask.1
 * JD-Core Version:    0.7.0.1
 */
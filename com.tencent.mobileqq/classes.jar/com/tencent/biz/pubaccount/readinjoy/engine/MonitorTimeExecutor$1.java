package com.tencent.biz.pubaccount.readinjoy.engine;

import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

class MonitorTimeExecutor$1
  implements RejectedExecutionHandler
{
  public void rejectedExecution(Runnable paramRunnable, ThreadPoolExecutor paramThreadPoolExecutor)
  {
    QLog.e("MonitorTimeExecutor", 1, "[rejectedExecution] r: " + paramRunnable + " executor: " + paramThreadPoolExecutor);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.MonitorTimeExecutor.1
 * JD-Core Version:    0.7.0.1
 */
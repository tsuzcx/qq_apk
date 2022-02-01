package com.tencent.biz.pubaccount.readinjoy.engine;

import android.os.Handler;
import android.support.annotation.NonNull;
import com.tencent.qphone.base.util.QLog;

class MonitorTimeExecutor$WatchDogRunnable
  implements Runnable
{
  private final MonitorTimeExecutor a;
  
  private MonitorTimeExecutor$WatchDogRunnable(@NonNull MonitorTimeExecutor paramMonitorTimeExecutor)
  {
    this.a = paramMonitorTimeExecutor;
  }
  
  public void run()
  {
    if (MonitorTimeExecutor.a()) {
      QLog.d("WatchDog", 2, "[run] checking " + this.a);
    }
    if ((!this.a.isTerminating()) && (!this.a.isTerminated()) && (!this.a.isShutdown()))
    {
      MonitorTimeExecutor.a(this.a);
      if (MonitorTimeExecutor.a() != null) {
        MonitorTimeExecutor.a().postDelayed(this, MonitorTimeExecutor.a());
      }
      return;
    }
    QLog.d("WatchDog", 2, "[run] skip since executor terminated: " + this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.MonitorTimeExecutor.WatchDogRunnable
 * JD-Core Version:    0.7.0.1
 */
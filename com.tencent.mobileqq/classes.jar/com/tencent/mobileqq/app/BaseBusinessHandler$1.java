package com.tencent.mobileqq.app;

import android.os.SystemClock;
import com.tencent.mobileqq.statistics.UnifiedMonitor;
import mqq.os.MqqHandler;

class BaseBusinessHandler$1
  implements Runnable
{
  BaseBusinessHandler$1(BaseBusinessHandler paramBaseBusinessHandler, BusinessObserver paramBusinessObserver, int paramInt, MqqHandler paramMqqHandler, boolean paramBoolean, Object paramObject) {}
  
  public void run()
  {
    long l2 = 0L;
    long l1 = l2;
    if (UnifiedMonitor.a().whetherReportDuringThisStartup(1))
    {
      l1 = l2;
      if (this.val$handler == BaseBusinessHandler.access$000()) {
        l1 = SystemClock.uptimeMillis();
      }
    }
    this.val$destObserver.onUpdate(this.val$type, this.val$isSuccess, this.val$data);
    if ((UnifiedMonitor.a().whetherReportDuringThisStartup(1)) && (this.val$handler == BaseBusinessHandler.access$000()))
    {
      l1 = SystemClock.uptimeMillis() - l1;
      if (BaseBusinessHandler.access$100() == -1) {
        BaseBusinessHandler.access$102(UnifiedMonitor.a().getThreshold(1));
      }
      if (l1 > BaseBusinessHandler.access$100())
      {
        if (UnifiedMonitor.a().whetherReportThisTime(1)) {
          UnifiedMonitor.a().addEvent(1, this.val$destObserver.getClass().getName(), (int)l1, BaseBusinessHandler.access$200(), null);
        }
        BaseBusinessHandler.access$202(0);
      }
    }
    else
    {
      return;
    }
    BaseBusinessHandler.access$208();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.BaseBusinessHandler.1
 * JD-Core Version:    0.7.0.1
 */
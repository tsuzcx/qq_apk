package com.tencent.avgame.business.observer;

import android.os.SystemClock;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.qqperf.UnifiedMonitor;

class ObserverCenter$1
  implements Runnable
{
  ObserverCenter$1(ObserverCenter paramObserverCenter, BusinessObserver paramBusinessObserver, int paramInt, WrapperHandler paramWrapperHandler, boolean paramBoolean, Object paramObject) {}
  
  public void run()
  {
    long l;
    if ((UnifiedMonitor.a().whetherReportDuringThisStartup(1)) && (this.c == ObserverCenter.a(this.this$0))) {
      l = SystemClock.uptimeMillis();
    } else {
      l = 0L;
    }
    this.a.onUpdate(this.b, this.d, this.e);
    if ((UnifiedMonitor.a().whetherReportDuringThisStartup(1)) && (this.c == ObserverCenter.a(this.this$0)))
    {
      l = SystemClock.uptimeMillis() - l;
      if (ObserverCenter.c() == -1) {
        ObserverCenter.b(UnifiedMonitor.a().getThreshold(1));
      }
      if (l > ObserverCenter.c())
      {
        if (UnifiedMonitor.a().whetherReportThisTime(1)) {
          UnifiedMonitor.a().addEvent(1, this.a.getClass().getName(), (int)l, ObserverCenter.d(), null);
        }
        ObserverCenter.c(0);
        return;
      }
      ObserverCenter.e();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.business.observer.ObserverCenter.1
 * JD-Core Version:    0.7.0.1
 */
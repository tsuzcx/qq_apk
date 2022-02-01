package com.tencent.mobileqq.app;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.safemode.SafeModeUtil;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ForeBackgroundSwitch
{
  private List<WeakReference<ForeBackgroundSwitch.Callback>> a = new ArrayList();
  private final Object b = new Object();
  
  public static ForeBackgroundSwitch a()
  {
    return ForeBackgroundSwitch.SingletonHolder.a();
  }
  
  public final void a(String arg1)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("onAppForeground: invoked. ");
      ((StringBuilder)localObject1).append(???);
      QLog.d("ForeBackgroundSwitch", 2, ((StringBuilder)localObject1).toString());
    }
    if (SafeModeUtil.b <= 0L)
    {
      SafeModeUtil.b = System.currentTimeMillis();
      QLog.d("ForeBackgroundSwitch", 1, new Object[] { "onAppForeground: invoked. ", " sFirstForegroundTimestamp: ", Long.valueOf(SafeModeUtil.b) });
    }
    QLog.i("QzoneVerticalVideoPluginApk", 1, "============== onAppForeground ==============");
    synchronized (this.b)
    {
      localObject1 = this.a.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        ForeBackgroundSwitch.Callback localCallback = (ForeBackgroundSwitch.Callback)((WeakReference)((Iterator)localObject1).next()).get();
        if (localCallback != null) {
          localCallback.a();
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  public final void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ForeBackgroundSwitch", 2, "onAppBackground: invoked. ");
    }
    QLog.i("QzoneVerticalVideoPluginApk", 1, "============== onAppBackground ==============");
    synchronized (this.b)
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        ForeBackgroundSwitch.Callback localCallback = (ForeBackgroundSwitch.Callback)((WeakReference)localIterator.next()).get();
        if (localCallback != null) {
          localCallback.b();
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.ForeBackgroundSwitch
 * JD-Core Version:    0.7.0.1
 */
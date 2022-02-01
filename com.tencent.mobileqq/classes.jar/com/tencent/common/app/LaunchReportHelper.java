package com.tencent.common.app;

import android.os.SystemClock;
import com.tencent.mobileqq.startup.director.StartupDirector;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;

public class LaunchReportHelper
{
  private static final AtomicBoolean a = new AtomicBoolean(false);
  private static boolean b = false;
  
  public static void a()
  {
    QLog.d("LaunchReportHelper", 1, "launchFromIconClickToUnreadRefresh onRegisterProxyAllEnd");
    b = true;
  }
  
  public static void a(AppRuntime paramAppRuntime)
  {
    if (a.get()) {
      return;
    }
    if (!b) {
      return;
    }
    if (a.compareAndSet(false, true))
    {
      QLog.d("LaunchReportHelper", 1, new Object[] { "launchFromIconClickToUnreadRefresh onFetchUnReadCount called StartupDirector.sShowCostTime:", Long.valueOf(StartupDirector.k) });
      if (StartupDirector.k > 0L)
      {
        if (StartupDirector.k >= 30000L) {
          return;
        }
        long l1 = SystemClock.uptimeMillis() - StartupDirector.l;
        long l2 = StartupDirector.k + l1;
        HashMap localHashMap = new HashMap();
        localHashMap.put("loginSCost", String.valueOf(StartupDirector.k));
        localHashMap.put("loginSToUnreadCost", String.valueOf(l1));
        localHashMap.put("totalCost", String.valueOf(l2));
        paramAppRuntime = paramAppRuntime.getCurrentAccountUin();
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(paramAppRuntime, "launchFromIconClickToUnreadRefresh", true, l2, 0L, localHashMap, "");
        QLog.d("LaunchReportHelper", 1, new Object[] { "launchFromIconClickToUnreadRefresh report info -> ", localHashMap });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.common.app.LaunchReportHelper
 * JD-Core Version:    0.7.0.1
 */
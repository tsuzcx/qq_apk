package com.tencent.common.app;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;

public final class SafeModeUtil$6
  implements Runnable
{
  public SafeModeUtil$6(SharedPreferences paramSharedPreferences) {}
  
  public void run()
  {
    QLog.e("SafeModeUtil", 1, "restart for background and crash many times, kill self !!!!");
    this.a.edit().putBoolean("allowAutoRestart", true);
    this.a.edit().putInt("crashcount", 0);
    this.a.edit().commit();
    StatisticCollector.getInstance(BaseApplicationImpl.sApplication).collectPerformance(null, "suicideCount", true, System.currentTimeMillis(), 0L, null, null);
    QLog.flushLog();
    System.exit(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.common.app.SafeModeUtil.6
 * JD-Core Version:    0.7.0.1
 */
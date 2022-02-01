package com.tencent.aelight.camera.aebase;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.aelight.camera.api.IAEClassManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakUtils;
import mqq.app.AppRuntime;

final class QIMShortVideoUtils$1
  implements Runnable
{
  QIMShortVideoUtils$1(Context paramContext, String paramString, Runnable paramRunnable) {}
  
  public void run()
  {
    if (QIMShortVideoUtils.a(this.jdField_a_of_type_AndroidContentContext)) {
      return;
    }
    int m = 1;
    int k = 1;
    int i = k;
    int j;
    try
    {
      Object localObject1 = BaseApplicationImpl.getApplication().getSharedPreferences("CrashControl_com.tencent.mobileqq:peak", 4);
      j = m;
      if (localObject1 != null)
      {
        i = k;
        j = m;
        if (!((SharedPreferences)localObject1).getBoolean("allowpreload", true))
        {
          i = k;
          long l1 = ((SharedPreferences)localObject1).getLong("starttime", 0L);
          i = k;
          j = ((SharedPreferences)localObject1).getInt("controlwindow", 86400);
          i = k;
          long l2 = System.currentTimeMillis();
          if ((l1 > 0L) && (j > 0) && (l2 > l1) && (l2 - l1 > j * 1000))
          {
            i = k;
            ((SharedPreferences)localObject1).edit().putBoolean("allowpreload", true).commit();
            j = m;
          }
          else
          {
            i = k;
            QLog.d("QIMShortVideoUtils", 1, "preloadPeakProcess is not allowed as crash frequently.");
            k = 0;
            j = 0;
            i = j;
            localObject1 = BaseApplicationImpl.getApplication();
            i = j;
            StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(((BaseApplicationImpl)localObject1).getRuntime().getAccount(), "actNoPreloadPeak", true, 0L, 0L, null, "");
            j = k;
          }
        }
      }
    }
    catch (Exception localException)
    {
      j = i;
      if (QLog.isColorLevel())
      {
        QLog.d("QIMShortVideoUtils", 2, "preLoadPeakProcess, ", localException);
        j = i;
      }
    }
    if (j != 0)
    {
      if (PeakUtils.a == null)
      {
        String str = this.jdField_a_of_type_JavaLangString;
        localObject2 = str;
        if (str == null) {
          localObject2 = "peak_preload";
        }
        PeakUtils.a = new PreloadProcHitSession((String)localObject2, "com.tencent.mobileqq:peak");
        PeakUtils.a.a();
      }
      Object localObject2 = new Intent(this.jdField_a_of_type_AndroidContentContext, ((IAEClassManager)QRoute.api(IAEClassManager.class)).getPeakServiceClass());
      ((Intent)localObject2).putExtra("ServiceAction", 2);
      try
      {
        this.jdField_a_of_type_AndroidContentContext.startService((Intent)localObject2);
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.d("QIMShortVideoUtils", 2, "preLoadPeakProcess, ", localThrowable);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("QIMShortVideoUtils", 2, "preLoadPeakProcess");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aebase.QIMShortVideoUtils.1
 * JD-Core Version:    0.7.0.1
 */
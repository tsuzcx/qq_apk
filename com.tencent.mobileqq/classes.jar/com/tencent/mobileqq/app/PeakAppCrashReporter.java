package com.tencent.mobileqq.app;

import android.app.Application.ActivityLifecycleCallbacks;
import android.text.TextUtils;
import com.tencent.aelight.camera.entry.api.AECameraEntry;
import com.tencent.aelight.camera.util.api.IAECameraPrefsUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import mqq.os.MqqHandler;

public class PeakAppCrashReporter
{
  private static final long[] a = { AECameraEntry.y.a(), AECameraEntry.x.a(), AECameraEntry.z.a(), AECameraEntry.A.a() };
  private long b = -1L;
  private StringBuilder c = new StringBuilder();
  private Application.ActivityLifecycleCallbacks d = new PeakAppCrashReporter.2(this);
  
  public void a()
  {
    String str = e();
    long l = f();
    if ((!TextUtils.isEmpty(str)) && (Arrays.binarySearch(a, l) >= 0))
    {
      b(str, l);
      a("", -1L);
    }
    if (BaseApplicationImpl.getApplication() != null)
    {
      BaseApplicationImpl.getApplication().registerActivityLifecycleCallbacks(this.d);
      QLog.d("PeakAppCrashReporter", 2, "onPeakAppCreated, registerActivityLifecycleCallBacks");
    }
  }
  
  public void a(String paramString, long paramLong)
  {
    if (QRoute.api(IAECameraPrefsUtil.class) != null)
    {
      ((IAECameraPrefsUtil)QRoute.api(IAECameraPrefsUtil.class)).putLong("key_peak_activity_crash_entryinfo", paramLong, 4);
      ((IAECameraPrefsUtil)QRoute.api(IAECameraPrefsUtil.class)).putString("key_peak_activity_crash_pathinfo", paramString, 4);
    }
  }
  
  public void b()
  {
    if (BaseApplicationImpl.getApplication() != null)
    {
      BaseApplicationImpl.getApplication().unregisterActivityLifecycleCallbacks(this.d);
      QLog.d("PeakAppCrashReporter", 2, "onPeakAppDestroyed, unregisterActivityLifecycleCallBacks");
    }
    a("", -1L);
  }
  
  public void b(String paramString, long paramLong)
  {
    ThreadManager.getSubThreadHandler().post(new PeakAppCrashReporter.1(this, paramLong, paramString));
  }
  
  public void c()
  {
    a("", -1L);
    this.b = -1L;
    StringBuilder localStringBuilder = this.c;
    localStringBuilder.delete(0, localStringBuilder.length());
  }
  
  public void d()
  {
    a(this.c.toString(), this.b);
  }
  
  public String e()
  {
    QRouteApi localQRouteApi = QRoute.api(IAECameraPrefsUtil.class);
    String str = "";
    if (localQRouteApi != null) {
      str = ((IAECameraPrefsUtil)QRoute.api(IAECameraPrefsUtil.class)).getString("key_peak_activity_crash_pathinfo", "", 4);
    }
    return str;
  }
  
  public long f()
  {
    QRouteApi localQRouteApi = QRoute.api(IAECameraPrefsUtil.class);
    long l = -1L;
    if (localQRouteApi != null) {
      l = ((IAECameraPrefsUtil)QRoute.api(IAECameraPrefsUtil.class)).getLong("key_peak_activity_crash_entryinfo", -1L, 4);
    }
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.PeakAppCrashReporter
 * JD-Core Version:    0.7.0.1
 */
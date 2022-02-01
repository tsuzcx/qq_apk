package com.tencent.mobileqq.bgprobe;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.troop.troopapps.GroupUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.monitor.crash.catchedexception.CaughtExceptionReport;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BackgroundProbeManager
{
  private static final long a = TimeUnit.DAYS.toMillis(1L);
  private static boolean c;
  private static boolean d;
  private static boolean e = false;
  private long b = PreferenceManager.getDefaultSharedPreferences(this.f).getLong("KEY_LAST_PROBE_SERVICE_START_TIME_MS", 0L);
  private Context f = BaseApplicationImpl.context;
  
  private BackgroundProbeManager()
  {
    boolean bool;
    if (new Random(System.currentTimeMillis()).nextInt(100000) == 0) {
      bool = true;
    } else {
      bool = false;
    }
    e = bool;
  }
  
  public static BackgroundProbeManager a()
  {
    return BackgroundProbeManager.SingletonHolder.a();
  }
  
  public static void a(Intent paramIntent)
  {
    int i;
    if (new Random(System.currentTimeMillis()).nextInt(400) == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if ((e) && (d()) && (!d) && (i != 0) && (paramIntent.getComponent() == null))
    {
      BackgroundException localBackgroundException = new BackgroundException("Implicit Broadcast");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("intent: ");
      localStringBuilder.append(paramIntent.toString());
      CaughtExceptionReport.a(localBackgroundException, localStringBuilder.toString());
      d = true;
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("reportImplicitBroadcast: invoked.  exception: ");
        paramIntent.append(localBackgroundException);
        QLog.i("BackgroundProbeManager", 2, paramIntent.toString());
      }
    }
  }
  
  public static void b()
  {
    Object localObject = a();
    BackgroundProbeManager.1 local1 = new BackgroundProbeManager.1((BackgroundProbeManager)localObject);
    BackgroundProbeManager.2 local2 = new BackgroundProbeManager.2((BackgroundProbeManager)localObject);
    boolean bool = ((BackgroundProbeManager)localObject).c();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onRunningBackground: invoked.  probeEnabled: ");
      ((StringBuilder)localObject).append(bool);
      QLog.i("BackgroundProbeManager", 2, ((StringBuilder)localObject).toString());
    }
    if (bool) {
      GroupUtil.a(local1, 180000L);
    }
    GroupUtil.a(local2, 181000L);
  }
  
  private boolean c()
  {
    int i;
    if (System.currentTimeMillis() - this.b > a) {
      i = 1;
    } else {
      i = 0;
    }
    return (d()) && (i != 0);
  }
  
  private static boolean d()
  {
    int i;
    if (g() >= 26) {
      i = 1;
    } else {
      i = 0;
    }
    int j;
    if (Build.VERSION.SDK_INT >= 24) {
      j = 1;
    } else {
      j = 0;
    }
    return (i != 0) && (j != 0);
  }
  
  private void e()
  {
    try
    {
      if (c) {
        break label81;
      }
      Intent localIntent = new Intent(this.f, BackgroundService.class);
      this.f.startService(localIntent);
      this.b = System.currentTimeMillis();
      c = true;
      PreferenceManager.getDefaultSharedPreferences(this.f).edit().putLong("KEY_LAST_PROBE_SERVICE_START_TIME_MS", this.b).apply();
      return;
    }
    catch (Throwable localThrowable)
    {
      label69:
      label81:
      break label69;
    }
    CaughtExceptionReport.a(new BackgroundException("startProbeService failed"));
  }
  
  private void f()
  {
    try
    {
      if (c)
      {
        Intent localIntent = new Intent(this.f, BackgroundService.class);
        this.f.stopService(localIntent);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel()) {
        QLog.e("BackgroundProbeManager", 2, "stopProbeService: failed. ", localThrowable);
      }
    }
  }
  
  private static int g()
  {
    Object localObject = BaseApplicationImpl.getApplication().getPackageManager();
    try
    {
      localObject = ((PackageManager)localObject).getApplicationInfo("com.tencent.mobileqq", 128);
      if (localObject != null)
      {
        int i = ((ApplicationInfo)localObject).targetSdkVersion;
        return i;
      }
    }
    catch (Throwable localThrowable)
    {
      label28:
      break label28;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.bgprobe.BackgroundProbeManager
 * JD-Core Version:    0.7.0.1
 */
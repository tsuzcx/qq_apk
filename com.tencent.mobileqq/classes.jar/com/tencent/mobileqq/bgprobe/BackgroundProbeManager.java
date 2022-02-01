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
  private static final long jdField_a_of_type_Long = TimeUnit.DAYS.toMillis(1L);
  private static boolean jdField_a_of_type_Boolean;
  private static boolean jdField_b_of_type_Boolean;
  private static boolean c = false;
  private Context jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.context;
  private long jdField_b_of_type_Long = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_AndroidContentContext).getLong("KEY_LAST_PROBE_SERVICE_START_TIME_MS", 0L);
  
  private BackgroundProbeManager()
  {
    boolean bool;
    if (new Random(System.currentTimeMillis()).nextInt(100000) == 0) {
      bool = true;
    } else {
      bool = false;
    }
    c = bool;
  }
  
  private static int a()
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
  
  public static BackgroundProbeManager a()
  {
    return BackgroundProbeManager.SingletonHolder.a();
  }
  
  public static void a()
  {
    Object localObject = a();
    BackgroundProbeManager.1 local1 = new BackgroundProbeManager.1((BackgroundProbeManager)localObject);
    BackgroundProbeManager.2 local2 = new BackgroundProbeManager.2((BackgroundProbeManager)localObject);
    boolean bool = ((BackgroundProbeManager)localObject).a();
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
  
  public static void a(Intent paramIntent)
  {
    int i;
    if (new Random(System.currentTimeMillis()).nextInt(400) == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if ((c) && (b()) && (!jdField_b_of_type_Boolean) && (i != 0) && (paramIntent.getComponent() == null))
    {
      BackgroundException localBackgroundException = new BackgroundException("Implicit Broadcast");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("intent: ");
      localStringBuilder.append(paramIntent.toString());
      CaughtExceptionReport.a(localBackgroundException, localStringBuilder.toString());
      jdField_b_of_type_Boolean = true;
      if (QLog.isColorLevel())
      {
        paramIntent = new StringBuilder();
        paramIntent.append("reportImplicitBroadcast: invoked.  exception: ");
        paramIntent.append(localBackgroundException);
        QLog.i("BackgroundProbeManager", 2, paramIntent.toString());
      }
    }
  }
  
  private boolean a()
  {
    int i;
    if (System.currentTimeMillis() - this.jdField_b_of_type_Long > jdField_a_of_type_Long) {
      i = 1;
    } else {
      i = 0;
    }
    return (b()) && (i != 0);
  }
  
  private void b()
  {
    try
    {
      if (jdField_a_of_type_Boolean) {
        break label81;
      }
      Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, BackgroundService.class);
      this.jdField_a_of_type_AndroidContentContext.startService(localIntent);
      this.jdField_b_of_type_Long = System.currentTimeMillis();
      jdField_a_of_type_Boolean = true;
      PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_AndroidContentContext).edit().putLong("KEY_LAST_PROBE_SERVICE_START_TIME_MS", this.jdField_b_of_type_Long).apply();
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
  
  private static boolean b()
  {
    int i;
    if (a() >= 26) {
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
  
  private void c()
  {
    try
    {
      if (jdField_a_of_type_Boolean)
      {
        Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, BackgroundService.class);
        this.jdField_a_of_type_AndroidContentContext.stopService(localIntent);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.bgprobe.BackgroundProbeManager
 * JD-Core Version:    0.7.0.1
 */
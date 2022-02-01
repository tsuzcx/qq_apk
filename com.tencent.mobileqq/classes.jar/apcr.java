import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.preference.PreferenceManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.bgprobe.BackgroundException;
import com.tencent.mobileqq.bgprobe.BackgroundProbeManager.1;
import com.tencent.mobileqq.bgprobe.BackgroundProbeManager.2;
import com.tencent.mobileqq.bgprobe.BackgroundService;
import com.tencent.qphone.base.util.QLog;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class apcr
{
  private static final long jdField_a_of_type_Long = TimeUnit.DAYS.toMillis(1L);
  private static boolean jdField_a_of_type_Boolean;
  private static boolean jdField_b_of_type_Boolean;
  private static boolean c;
  private Context jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.context;
  private long jdField_b_of_type_Long = PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_AndroidContentContext).getLong("KEY_LAST_PROBE_SERVICE_START_TIME_MS", 0L);
  
  private apcr()
  {
    if (new Random(System.currentTimeMillis()).nextInt(100000) == 0) {}
    for (boolean bool = true;; bool = false)
    {
      c = bool;
      return;
    }
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
    catch (Throwable localThrowable) {}
    return 0;
  }
  
  public static apcr a()
  {
    return apcs.a();
  }
  
  public static void a()
  {
    apcr localapcr = a();
    BackgroundProbeManager.1 local1 = new BackgroundProbeManager.1(localapcr);
    BackgroundProbeManager.2 local2 = new BackgroundProbeManager.2(localapcr);
    boolean bool = localapcr.a();
    if (QLog.isColorLevel()) {
      QLog.i("BackgroundProbeManager", 2, "onRunningBackground: invoked.  probeEnabled: " + bool);
    }
    if (bool) {
      bdvb.a(local1, 180000L);
    }
    bdvb.a(local2, 181000L);
  }
  
  public static void a(Intent paramIntent)
  {
    if (new Random(System.currentTimeMillis()).nextInt(400) == 0) {}
    for (int i = 1;; i = 0)
    {
      if ((c) && (b()) && (!jdField_b_of_type_Boolean) && (i != 0) && (paramIntent.getComponent() == null))
      {
        BackgroundException localBackgroundException = new BackgroundException("Implicit Broadcast");
        bcdb.a(localBackgroundException, "intent: " + paramIntent.toString());
        jdField_b_of_type_Boolean = true;
        if (QLog.isColorLevel()) {
          QLog.i("BackgroundProbeManager", 2, "reportImplicitBroadcast: invoked.  exception: " + localBackgroundException);
        }
      }
      return;
    }
  }
  
  private boolean a()
  {
    if (System.currentTimeMillis() - this.jdField_b_of_type_Long > jdField_a_of_type_Long) {}
    for (int i = 1; (b()) && (i != 0); i = 0) {
      return true;
    }
    return false;
  }
  
  private void b()
  {
    try
    {
      if (!jdField_a_of_type_Boolean)
      {
        Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, BackgroundService.class);
        this.jdField_a_of_type_AndroidContentContext.startService(localIntent);
        this.jdField_b_of_type_Long = System.currentTimeMillis();
        jdField_a_of_type_Boolean = true;
        PreferenceManager.getDefaultSharedPreferences(this.jdField_a_of_type_AndroidContentContext).edit().putLong("KEY_LAST_PROBE_SERVICE_START_TIME_MS", this.jdField_b_of_type_Long).apply();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      bcdb.a(new BackgroundException("startProbeService failed"));
    }
  }
  
  private static boolean b()
  {
    int i;
    if (a() >= 26)
    {
      i = 1;
      if (Build.VERSION.SDK_INT < 24) {
        break label35;
      }
    }
    label35:
    for (int j = 1;; j = 0)
    {
      if ((i == 0) || (j == 0)) {
        break label40;
      }
      return true;
      i = 0;
      break;
    }
    label40:
    return false;
  }
  
  private void c()
  {
    try
    {
      if (jdField_a_of_type_Boolean)
      {
        Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, BackgroundService.class);
        this.jdField_a_of_type_AndroidContentContext.stopService(localIntent);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("BackgroundProbeManager", 2, "stopProbeService: failed. ", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     apcr
 * JD-Core Version:    0.7.0.1
 */
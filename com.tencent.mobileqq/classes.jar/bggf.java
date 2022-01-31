import android.app.Activity;
import android.content.Intent;
import com.tencent.mobileqq.pluginsdk.ActivityLifecycle.ActivityLifecycleCallback;
import com.tencent.qphone.base.util.QLog;
import cooperation.buscard.BuscardHelper;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class bggf
  implements ActivityLifecycle.ActivityLifecycleCallback
{
  public void onNewIntent(Activity paramActivity, Intent paramIntent)
  {
    if ((paramIntent != null) && ("android.nfc.action.TECH_DISCOVERED".equals(paramIntent.getAction()))) {
      BuscardHelper.a("", paramActivity, paramIntent);
    }
    if (QLog.isColorLevel()) {
      QLog.d("", 2, "NFCActivityLifecycleCallback onNewIntent " + MobileQQ.processName);
    }
  }
  
  public void onPause(Activity paramActivity)
  {
    try
    {
      BuscardHelper.a(paramActivity, true, "", "");
      if (QLog.isColorLevel()) {
        QLog.d("", 2, "NFCActivityLifecycleCallback onPause " + MobileQQ.processName);
      }
      return;
    }
    catch (Throwable paramActivity)
    {
      for (;;)
      {
        paramActivity.printStackTrace();
      }
    }
  }
  
  public void onResume(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("", 2, "NFCActivityLifecycleCallback onResume " + MobileQQ.processName);
    }
    try
    {
      if ((paramActivity instanceof AppActivity))
      {
        AppRuntime localAppRuntime = ((AppActivity)paramActivity).getAppRuntime();
        if ((localAppRuntime != null) && (localAppRuntime.isLogin()))
        {
          BuscardHelper.a(paramActivity, true, "", "", null);
          return;
        }
        BuscardHelper.a(paramActivity, true, "", "");
        return;
      }
    }
    catch (Throwable paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bggf
 * JD-Core Version:    0.7.0.1
 */
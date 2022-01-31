import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pluginsdk.exception.ExceptionTracker;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public class axpx
{
  private static String a(QQAppInterface paramQQAppInterface, axti paramaxti, int paramInt)
  {
    if (paramaxti == null) {
      return null;
    }
    return paramaxti.a(paramInt);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, axth paramaxth)
  {
    a("dc03309", paramQQAppInterface, paramaxth);
  }
  
  private static void a(String paramString, QQAppInterface paramQQAppInterface, axti paramaxti)
  {
    if (paramaxti == null)
    {
      ExceptionTracker.trackException("EXReportController", "[EXReport runtime] Tag(" + paramString + ") report item is null");
      if (!QLog.isColorLevel()) {}
    }
    do
    {
      return;
      if ((!TextUtils.isEmpty(paramaxti.i)) && (!TextUtils.isEmpty(paramaxti.k)) && (!TextUtils.isEmpty(paramaxti.j))) {
        break;
      }
    } while (!QLog.isColorLevel());
    return;
    paramaxti.b = NetConnInfoCenter.getServerTime();
    if (QLog.isColorLevel()) {}
    Object localObject = paramQQAppInterface;
    if (paramQQAppInterface == null)
    {
      localObject = paramQQAppInterface;
      if (BaseApplicationImpl.sProcessId == 1)
      {
        AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
        localObject = paramQQAppInterface;
        if (localAppRuntime != null)
        {
          localObject = paramQQAppInterface;
          if ((localAppRuntime instanceof QQAppInterface)) {
            localObject = (QQAppInterface)localAppRuntime;
          }
        }
      }
    }
    if (localObject == null)
    {
      paramQQAppInterface = a((QQAppInterface)localObject, paramaxti, 1);
      localObject = new Intent();
      ((Intent)localObject).setClassName(BaseApplicationImpl.sApplication, "com.tencent.mobileqq.statistics.ReportReceiver");
      ((Intent)localObject).putExtra("reporting_tag", paramString);
      ((Intent)localObject).putExtra("reporting_detail", paramQQAppInterface);
      ((Intent)localObject).putExtra("reporting_count", paramaxti.c);
      ((Intent)localObject).putExtra("is_runtime", 1);
      BaseApplicationImpl.getApplication().sendBroadcast((Intent)localObject);
      return;
    }
    a(paramString, (QQAppInterface)localObject, a((QQAppInterface)localObject, paramaxti, 1));
  }
  
  public static void a(String paramString1, QQAppInterface paramQQAppInterface, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      String str = paramString2;
      if (paramString2.contains("${count_unknown}")) {
        str = paramString2.replace("${count_unknown}", "1");
      }
      paramString2 = new NewIntent(paramQQAppInterface.getApplication(), axct.class);
      paramString2.putExtra("sendType", 2);
      paramString2.putExtra("tag", paramString1);
      paramString2.putExtra("content", str);
      paramString2.setWithouLogin(true);
      paramQQAppInterface.startServlet(paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axpx
 * JD-Core Version:    0.7.0.1
 */
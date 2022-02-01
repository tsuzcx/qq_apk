import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pluginsdk.exception.ExceptionTracker;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public class bdkb
{
  private static String a(QQAppInterface paramQQAppInterface, bdmo parambdmo, int paramInt)
  {
    if (parambdmo == null) {
      return null;
    }
    return parambdmo.a(paramInt);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, bdmn parambdmn)
  {
    a("dc03309", paramQQAppInterface, parambdmn);
  }
  
  private static void a(String paramString, QQAppInterface paramQQAppInterface, bdmo parambdmo)
  {
    if (parambdmo == null)
    {
      ExceptionTracker.trackException("EXReportController", "[EXReport runtime] Tag(" + paramString + ") report item is null");
      if (QLog.isColorLevel()) {}
    }
    do
    {
      return;
      QLog.d("EXReportController", 2, "[EXReport runtime] tag = " + paramString + "  report item is null");
      return;
      if ((!TextUtils.isEmpty(parambdmo.i)) && (!TextUtils.isEmpty(parambdmo.k)) && (!TextUtils.isEmpty(parambdmo.j))) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("EXReportController", 2, "[EXReport runtime] tag = " + paramString + " item.sopType must not empty");
    return;
    parambdmo.b = NetConnInfoCenter.getServerTime();
    if (!QLog.isColorLevel()) {}
    Object localObject;
    for (;;)
    {
      localObject = paramQQAppInterface;
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
      if (localObject != null) {
        break;
      }
      paramQQAppInterface = a((QQAppInterface)localObject, parambdmo, 1);
      localObject = new Intent();
      ((Intent)localObject).setClassName(BaseApplicationImpl.sApplication, "com.tencent.mobileqq.statistics.ReportReceiver");
      ((Intent)localObject).putExtra("reporting_tag", paramString);
      ((Intent)localObject).putExtra("reporting_detail", paramQQAppInterface);
      ((Intent)localObject).putExtra("reporting_count", parambdmo.c);
      ((Intent)localObject).putExtra("is_runtime", 1);
      BaseApplicationImpl.getApplication().sendBroadcast((Intent)localObject);
      return;
      QLog.d("EXReportController", 2, "[EXReport runtime] tag = " + paramString + ", content = " + parambdmo.toString());
    }
    a(paramString, (QQAppInterface)localObject, a((QQAppInterface)localObject, parambdmo, 1));
  }
  
  public static void a(String paramString1, QQAppInterface paramQQAppInterface, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      String str = paramString2;
      if (paramString2.contains("${count_unknown}")) {
        str = paramString2.replace("${count_unknown}", "1");
      }
      paramString2 = new NewIntent(paramQQAppInterface.getApplication(), bcwd.class);
      paramString2.putExtra("sendType", 2);
      paramString2.putExtra("tag", paramString1);
      paramString2.putExtra("content", str);
      paramString2.setWithouLogin(true);
      paramQQAppInterface.startServlet(paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdkb
 * JD-Core Version:    0.7.0.1
 */
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.pluginsdk.exception.ExceptionTracker;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.NewIntent;

public class axqs
{
  private static String a(QQAppInterface paramQQAppInterface)
  {
    switch (bbev.b(paramQQAppInterface.getApp()))
    {
    default: 
      return "unknown";
    case 0: 
      return "none";
    case 1: 
      return "Wi-Fi";
    case 2: 
      return "2G";
    case 3: 
      return "3G";
    case 4: 
      return "4G";
    }
    return "5G";
  }
  
  private static String a(QQAppInterface paramQQAppInterface, axtt paramaxtt, int paramInt)
  {
    if (paramaxtt == null) {
      return null;
    }
    paramaxtt.a = bbct.d();
    SosoInterface.SosoLbsInfo localSosoLbsInfo = SosoInterface.b();
    if ((localSosoLbsInfo != null) && (localSosoLbsInfo.a != null)) {
      paramaxtt.c = localSosoLbsInfo.a.e;
    }
    if (paramQQAppInterface == null) {}
    for (paramaxtt.b = "${network_unknown}";; paramaxtt.b = a(paramQQAppInterface)) {
      return paramaxtt.a(paramInt);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, axtu paramaxtu)
  {
    a("dc01982", paramQQAppInterface, paramaxtu);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, axtw paramaxtw)
  {
    b("dc01983", paramQQAppInterface, paramaxtw);
  }
  
  private static void a(String paramString, QQAppInterface paramQQAppInterface, axtt paramaxtt)
  {
    if (paramaxtt == null)
    {
      ExceptionTracker.trackException("QIMReportController", "[QIM Report runtime] Tag(" + paramString + ") report item is null");
      if (!QLog.isColorLevel()) {}
    }
    do
    {
      return;
      if (!TextUtils.isEmpty(paramaxtt.d)) {
        break;
      }
    } while (!QLog.isColorLevel());
    return;
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
      paramQQAppInterface = a((QQAppInterface)localObject, paramaxtt, 1);
      localObject = new Intent();
      ((Intent)localObject).setClassName(BaseApplicationImpl.sApplication, "com.tencent.mobileqq.statistics.ReportReceiver");
      ((Intent)localObject).putExtra("reporting_tag", paramString);
      ((Intent)localObject).putExtra("reporting_detail", paramQQAppInterface);
      if ((paramaxtt instanceof axtv)) {
        ((Intent)localObject).putExtra("reporting_count", 0);
      }
      for (;;)
      {
        ((Intent)localObject).putExtra("is_runtime", 1);
        BaseApplicationImpl.getApplication().sendBroadcast((Intent)localObject);
        return;
        if ((paramaxtt instanceof axtu)) {
          ((Intent)localObject).putExtra("reporting_count", ((axtu)paramaxtt).a);
        } else if ((paramaxtt instanceof axtw)) {
          ((Intent)localObject).putExtra("reporting_count", ((axtw)paramaxtt).a);
        }
      }
    }
    a(paramString, (QQAppInterface)localObject, a((QQAppInterface)localObject, paramaxtt, 1));
  }
  
  public static void a(String paramString1, QQAppInterface paramQQAppInterface, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      Object localObject = paramString2;
      if (paramQQAppInterface != null)
      {
        localObject = paramString2;
        if (paramString2.contains("${network_unknown}")) {
          localObject = paramString2.replace("${network_unknown}", a(paramQQAppInterface));
        }
      }
      paramString2 = (String)localObject;
      if (((String)localObject).contains("${count_unknown}")) {
        paramString2 = ((String)localObject).replace("${count_unknown}", "1");
      }
      localObject = new NewIntent(paramQQAppInterface.getApplication(), axct.class);
      ((NewIntent)localObject).putExtra("sendType", 2);
      ((NewIntent)localObject).putExtra("tag", paramString1);
      ((NewIntent)localObject).putExtra("content", paramString2);
      ((NewIntent)localObject).setWithouLogin(true);
      paramQQAppInterface.startServlet((NewIntent)localObject);
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, axtu paramaxtu)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMReportController", 2, "1982:" + paramaxtu);
    }
    a(paramQQAppInterface, paramaxtu);
  }
  
  private static void b(String paramString, QQAppInterface paramQQAppInterface, axtt paramaxtt)
  {
    if (paramaxtt == null)
    {
      ExceptionTracker.trackException("QIMReportController", "QIM Report not runtime Tag(" + paramString + ") report item is null");
      if (!QLog.isColorLevel()) {}
    }
    do
    {
      return;
      if (!TextUtils.isEmpty(paramaxtt.d)) {
        break;
      }
    } while (!QLog.isColorLevel());
    return;
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
      paramQQAppInterface = a((QQAppInterface)localObject, paramaxtt, 0);
      localObject = new Intent();
      ((Intent)localObject).setClassName(BaseApplicationImpl.sApplication, "com.tencent.mobileqq.statistics.ReportReceiver");
      ((Intent)localObject).putExtra("reporting_tag", paramString);
      ((Intent)localObject).putExtra("reporting_detail", paramQQAppInterface);
      if ((paramaxtt instanceof axtv)) {
        ((Intent)localObject).putExtra("reporting_count", 0);
      }
      for (;;)
      {
        ((Intent)localObject).putExtra("is_runtime", 0);
        BaseApplicationImpl.getApplication().sendBroadcast((Intent)localObject);
        return;
        if ((paramaxtt instanceof axtu)) {
          ((Intent)localObject).putExtra("reporting_count", ((axtu)paramaxtt).a);
        } else if ((paramaxtt instanceof axtw)) {
          ((Intent)localObject).putExtra("reporting_count", ((axtw)paramaxtt).a);
        }
      }
    }
    b(paramString, (QQAppInterface)localObject, a((QQAppInterface)localObject, paramaxtt, 0));
  }
  
  public static void b(String paramString1, QQAppInterface paramQQAppInterface, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString2)) && (paramQQAppInterface != null))
    {
      String str = paramString2;
      if (paramString2.contains("${network_unknown}")) {
        str = paramString2.replace("${network_unknown}", a(paramQQAppInterface));
      }
      paramQQAppInterface = paramQQAppInterface.a();
      if (paramQQAppInterface != null) {
        paramQQAppInterface.a(paramString1, str, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axqs
 * JD-Core Version:    0.7.0.1
 */
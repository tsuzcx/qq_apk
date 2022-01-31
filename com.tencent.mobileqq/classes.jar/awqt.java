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

public class awqt
{
  private static String a(QQAppInterface paramQQAppInterface)
  {
    switch (badq.b(paramQQAppInterface.getApp()))
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
  
  private static String a(QQAppInterface paramQQAppInterface, awts paramawts, int paramInt)
  {
    if (paramawts == null) {
      return null;
    }
    paramawts.a = babp.d();
    SosoInterface.SosoLbsInfo localSosoLbsInfo = SosoInterface.b();
    if ((localSosoLbsInfo != null) && (localSosoLbsInfo.a != null)) {
      paramawts.c = localSosoLbsInfo.a.e;
    }
    if (paramQQAppInterface == null) {}
    for (paramawts.b = "${network_unknown}";; paramawts.b = a(paramQQAppInterface)) {
      return paramawts.a(paramInt);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, awtt paramawtt)
  {
    a("dc01982", paramQQAppInterface, paramawtt);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, awtv paramawtv)
  {
    b("dc01983", paramQQAppInterface, paramawtv);
  }
  
  private static void a(String paramString, QQAppInterface paramQQAppInterface, awts paramawts)
  {
    if (paramawts == null)
    {
      ExceptionTracker.trackException("QIMReportController", "[QIM Report runtime] Tag(" + paramString + ") report item is null");
      if (!QLog.isColorLevel()) {}
    }
    do
    {
      return;
      if (!TextUtils.isEmpty(paramawts.d)) {
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
      paramQQAppInterface = a((QQAppInterface)localObject, paramawts, 1);
      localObject = new Intent();
      ((Intent)localObject).setClassName(BaseApplicationImpl.sApplication, "com.tencent.mobileqq.statistics.ReportReceiver");
      ((Intent)localObject).putExtra("reporting_tag", paramString);
      ((Intent)localObject).putExtra("reporting_detail", paramQQAppInterface);
      if ((paramawts instanceof awtu)) {
        ((Intent)localObject).putExtra("reporting_count", 0);
      }
      for (;;)
      {
        ((Intent)localObject).putExtra("is_runtime", 1);
        BaseApplicationImpl.getApplication().sendBroadcast((Intent)localObject);
        return;
        if ((paramawts instanceof awtt)) {
          ((Intent)localObject).putExtra("reporting_count", ((awtt)paramawts).a);
        } else if ((paramawts instanceof awtv)) {
          ((Intent)localObject).putExtra("reporting_count", ((awtv)paramawts).a);
        }
      }
    }
    a(paramString, (QQAppInterface)localObject, a((QQAppInterface)localObject, paramawts, 1));
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
      localObject = new NewIntent(paramQQAppInterface.getApplication(), awdl.class);
      ((NewIntent)localObject).putExtra("sendType", 2);
      ((NewIntent)localObject).putExtra("tag", paramString1);
      ((NewIntent)localObject).putExtra("content", paramString2);
      ((NewIntent)localObject).setWithouLogin(true);
      paramQQAppInterface.startServlet((NewIntent)localObject);
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, awtt paramawtt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMReportController", 2, "1982:" + paramawtt);
    }
    a(paramQQAppInterface, paramawtt);
  }
  
  private static void b(String paramString, QQAppInterface paramQQAppInterface, awts paramawts)
  {
    if (paramawts == null)
    {
      ExceptionTracker.trackException("QIMReportController", "QIM Report not runtime Tag(" + paramString + ") report item is null");
      if (!QLog.isColorLevel()) {}
    }
    do
    {
      return;
      if (!TextUtils.isEmpty(paramawts.d)) {
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
      paramQQAppInterface = a((QQAppInterface)localObject, paramawts, 0);
      localObject = new Intent();
      ((Intent)localObject).setClassName(BaseApplicationImpl.sApplication, "com.tencent.mobileqq.statistics.ReportReceiver");
      ((Intent)localObject).putExtra("reporting_tag", paramString);
      ((Intent)localObject).putExtra("reporting_detail", paramQQAppInterface);
      if ((paramawts instanceof awtu)) {
        ((Intent)localObject).putExtra("reporting_count", 0);
      }
      for (;;)
      {
        ((Intent)localObject).putExtra("is_runtime", 0);
        BaseApplicationImpl.getApplication().sendBroadcast((Intent)localObject);
        return;
        if ((paramawts instanceof awtt)) {
          ((Intent)localObject).putExtra("reporting_count", ((awtt)paramawts).a);
        } else if ((paramawts instanceof awtv)) {
          ((Intent)localObject).putExtra("reporting_count", ((awtv)paramawts).a);
        }
      }
    }
    b(paramString, (QQAppInterface)localObject, a((QQAppInterface)localObject, paramawts, 0));
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
 * Qualified Name:     awqt
 * JD-Core Version:    0.7.0.1
 */
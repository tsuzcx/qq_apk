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

public class azqo
{
  private static String a(QQAppInterface paramQQAppInterface)
  {
    switch (bdin.b(paramQQAppInterface.getApp()))
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
  
  private static String a(QQAppInterface paramQQAppInterface, aztx paramaztx, int paramInt)
  {
    if (paramaztx == null) {
      return null;
    }
    paramaztx.a = bdgk.d();
    SosoInterface.SosoLbsInfo localSosoLbsInfo = SosoInterface.b();
    if ((localSosoLbsInfo != null) && (localSosoLbsInfo.a != null)) {
      paramaztx.c = localSosoLbsInfo.a.e;
    }
    if (paramQQAppInterface == null) {}
    for (paramaztx.b = "${network_unknown}";; paramaztx.b = a(paramQQAppInterface)) {
      return paramaztx.a(paramInt);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, azty paramazty)
  {
    a("dc01982", paramQQAppInterface, paramazty);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, azua paramazua)
  {
    b("dc01983", paramQQAppInterface, paramazua);
  }
  
  private static void a(String paramString, QQAppInterface paramQQAppInterface, aztx paramaztx)
  {
    if (paramaztx == null)
    {
      ExceptionTracker.trackException("QIMReportController", "[QIM Report runtime] Tag(" + paramString + ") report item is null");
      if (!QLog.isColorLevel()) {}
    }
    do
    {
      return;
      if (!TextUtils.isEmpty(paramaztx.d)) {
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
      paramQQAppInterface = a((QQAppInterface)localObject, paramaztx, 1);
      localObject = new Intent();
      ((Intent)localObject).setClassName(BaseApplicationImpl.sApplication, "com.tencent.mobileqq.statistics.ReportReceiver");
      ((Intent)localObject).putExtra("reporting_tag", paramString);
      ((Intent)localObject).putExtra("reporting_detail", paramQQAppInterface);
      if ((paramaztx instanceof aztz)) {
        ((Intent)localObject).putExtra("reporting_count", 0);
      }
      for (;;)
      {
        ((Intent)localObject).putExtra("is_runtime", 1);
        BaseApplicationImpl.getApplication().sendBroadcast((Intent)localObject);
        return;
        if ((paramaztx instanceof azty)) {
          ((Intent)localObject).putExtra("reporting_count", ((azty)paramaztx).a);
        } else if ((paramaztx instanceof azua)) {
          ((Intent)localObject).putExtra("reporting_count", ((azua)paramaztx).a);
        }
      }
    }
    a(paramString, (QQAppInterface)localObject, a((QQAppInterface)localObject, paramaztx, 1));
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
      localObject = new NewIntent(paramQQAppInterface.getApplication(), azci.class);
      ((NewIntent)localObject).putExtra("sendType", 2);
      ((NewIntent)localObject).putExtra("tag", paramString1);
      ((NewIntent)localObject).putExtra("content", paramString2);
      ((NewIntent)localObject).setWithouLogin(true);
      paramQQAppInterface.startServlet((NewIntent)localObject);
    }
  }
  
  public static void b(QQAppInterface paramQQAppInterface, azty paramazty)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QIMReportController", 2, "1982:" + paramazty);
    }
    a(paramQQAppInterface, paramazty);
  }
  
  private static void b(String paramString, QQAppInterface paramQQAppInterface, aztx paramaztx)
  {
    if (paramaztx == null)
    {
      ExceptionTracker.trackException("QIMReportController", "QIM Report not runtime Tag(" + paramString + ") report item is null");
      if (!QLog.isColorLevel()) {}
    }
    do
    {
      return;
      if (!TextUtils.isEmpty(paramaztx.d)) {
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
      paramQQAppInterface = a((QQAppInterface)localObject, paramaztx, 0);
      localObject = new Intent();
      ((Intent)localObject).setClassName(BaseApplicationImpl.sApplication, "com.tencent.mobileqq.statistics.ReportReceiver");
      ((Intent)localObject).putExtra("reporting_tag", paramString);
      ((Intent)localObject).putExtra("reporting_detail", paramQQAppInterface);
      if ((paramaztx instanceof aztz)) {
        ((Intent)localObject).putExtra("reporting_count", 0);
      }
      for (;;)
      {
        ((Intent)localObject).putExtra("is_runtime", 0);
        BaseApplicationImpl.getApplication().sendBroadcast((Intent)localObject);
        return;
        if ((paramaztx instanceof azty)) {
          ((Intent)localObject).putExtra("reporting_count", ((azty)paramaztx).a);
        } else if ((paramaztx instanceof azua)) {
          ((Intent)localObject).putExtra("reporting_count", ((azua)paramaztx).a);
        }
      }
    }
    b(paramString, (QQAppInterface)localObject, a((QQAppInterface)localObject, paramaztx, 0));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azqo
 * JD-Core Version:    0.7.0.1
 */
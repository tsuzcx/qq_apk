import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;

public class awqr
{
  public static boolean a;
  
  private static String a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return "unknown";
    }
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
  
  private static String a(QQAppInterface paramQQAppInterface, awqs paramawqs)
  {
    paramawqs.a = babp.d();
    SosoInterface.SosoLbsInfo localSosoLbsInfo = SosoInterface.b();
    if ((localSosoLbsInfo != null) && (localSosoLbsInfo.a != null)) {
      paramawqs.c = localSosoLbsInfo.a.e;
    }
    paramawqs.b = a(paramQQAppInterface);
    return paramawqs.toString();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, awqs paramawqs)
  {
    paramawqs = a(paramQQAppInterface, paramawqs);
    if (QLog.isColorLevel()) {
      QLog.i("PushReportController", 1, "reportPushEvent detail=" + paramawqs);
    }
    if (paramQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PushReportController", 1, "not Rumtime");
      }
      paramQQAppInterface = new Intent();
      paramQQAppInterface.setClassName(BaseApplicationImpl.sApplication, "com.tencent.mobileqq.statistics.ReportReceiver");
      paramQQAppInterface.putExtra("reporting_tag", "dc03266");
      paramQQAppInterface.putExtra("reporting_detail", paramawqs);
      paramQQAppInterface.putExtra("reporting_count", 1);
      paramQQAppInterface.putExtra("is_runtime", 0);
      BaseApplicationImpl.getApplication().sendBroadcast(paramQQAppInterface);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("PushReportController", 1, " Rumtime");
    }
    awqx.b(paramQQAppInterface, "dc03266", paramawqs, 1);
  }
  
  public static void a(String paramString, awqs paramawqs)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.contains("&")))
    {
      paramString = paramString.split("&");
      int i = 0;
      while (i < paramString.length)
      {
        if (paramString[i].contains("pushfrom"))
        {
          String[] arrayOfString = paramString[i].split("=");
          if ((arrayOfString != null) && (arrayOfString.length >= 2)) {
            paramawqs.g = arrayOfString[1];
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     awqr
 * JD-Core Version:    0.7.0.1
 */
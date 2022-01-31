import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;

public class azqm
{
  public static boolean a;
  
  private static String a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return "unknown";
    }
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
  
  private static String a(QQAppInterface paramQQAppInterface, azqn paramazqn)
  {
    paramazqn.a = bdgk.d();
    SosoInterface.SosoLbsInfo localSosoLbsInfo = SosoInterface.b();
    if ((localSosoLbsInfo != null) && (localSosoLbsInfo.a != null)) {
      paramazqn.c = localSosoLbsInfo.a.e;
    }
    paramazqn.b = a(paramQQAppInterface);
    return paramazqn.toString();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, azqn paramazqn)
  {
    paramazqn = a(paramQQAppInterface, paramazqn);
    if (QLog.isColorLevel()) {
      QLog.i("PushReportController", 1, "reportPushEvent detail=" + paramazqn);
    }
    if (paramQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("PushReportController", 1, "not Rumtime");
      }
      paramQQAppInterface = new Intent();
      paramQQAppInterface.setClassName(BaseApplicationImpl.sApplication, "com.tencent.mobileqq.statistics.ReportReceiver");
      paramQQAppInterface.putExtra("reporting_tag", "dc03266");
      paramQQAppInterface.putExtra("reporting_detail", paramazqn);
      paramQQAppInterface.putExtra("reporting_count", 1);
      paramQQAppInterface.putExtra("is_runtime", 0);
      BaseApplicationImpl.getApplication().sendBroadcast(paramQQAppInterface);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("PushReportController", 1, " Rumtime");
    }
    azqs.b(paramQQAppInterface, "dc03266", paramazqn, 1);
  }
  
  public static void a(String paramString, azqn paramazqn)
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
            paramazqn.g = arrayOfString[1];
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azqm
 * JD-Core Version:    0.7.0.1
 */
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.mobileqq.pluginsdk.exception.ExceptionTracker;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class bdkw
{
  private static String a(QQAppInterface paramQQAppInterface)
  {
    switch (NetworkUtil.getNetworkType(paramQQAppInterface.getApp()))
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
  
  private static String a(QQAppInterface paramQQAppInterface, bdmz parambdmz, int paramInt)
  {
    if (parambdmz == null) {
      return null;
    }
    parambdmz.a = DeviceInfoUtil.getDeviceModel();
    SosoInterface.SosoLbsInfo localSosoLbsInfo = SosoInterface.getSosoInfo();
    if ((localSosoLbsInfo != null) && (localSosoLbsInfo.mLocation != null)) {
      parambdmz.c = localSosoLbsInfo.mLocation.city;
    }
    if (paramQQAppInterface == null) {}
    for (parambdmz.b = "${network_unknown}";; parambdmz.b = a(paramQQAppInterface)) {
      return parambdmz.a(paramInt);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, bdnc parambdnc)
  {
    a("dc01983", paramQQAppInterface, parambdnc);
  }
  
  private static void a(String paramString, QQAppInterface paramQQAppInterface, bdmz parambdmz)
  {
    if (parambdmz == null)
    {
      ExceptionTracker.trackException("QIMReportController", "QIM Report not runtime Tag(" + paramString + ") report item is null");
      if (!QLog.isColorLevel()) {}
    }
    do
    {
      return;
      if (!TextUtils.isEmpty(parambdmz.d)) {
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
      paramQQAppInterface = a((QQAppInterface)localObject, parambdmz, 0);
      localObject = new Intent();
      ((Intent)localObject).setClassName(BaseApplicationImpl.sApplication, "com.tencent.mobileqq.statistics.ReportReceiver");
      ((Intent)localObject).putExtra("reporting_tag", paramString);
      ((Intent)localObject).putExtra("reporting_detail", paramQQAppInterface);
      if ((parambdmz instanceof bdnb)) {
        ((Intent)localObject).putExtra("reporting_count", 0);
      }
      for (;;)
      {
        ((Intent)localObject).putExtra("is_runtime", 0);
        BaseApplicationImpl.getApplication().sendBroadcast((Intent)localObject);
        return;
        if ((parambdmz instanceof bdna)) {
          ((Intent)localObject).putExtra("reporting_count", ((bdna)parambdmz).a);
        } else if ((parambdmz instanceof bdnc)) {
          ((Intent)localObject).putExtra("reporting_count", ((bdnc)parambdmz).a);
        }
      }
    }
    a(paramString, (QQAppInterface)localObject, a((QQAppInterface)localObject, parambdmz, 0));
  }
  
  public static void a(String paramString1, QQAppInterface paramQQAppInterface, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString2)) && (paramQQAppInterface != null))
    {
      String str = paramString2;
      if (paramString2.contains("${network_unknown}")) {
        str = paramString2.replace("${network_unknown}", a(paramQQAppInterface));
      }
      paramQQAppInterface = paramQQAppInterface.getReportController();
      if (paramQQAppInterface != null) {
        paramQQAppInterface.a(paramString1, str, 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdkw
 * JD-Core Version:    0.7.0.1
 */
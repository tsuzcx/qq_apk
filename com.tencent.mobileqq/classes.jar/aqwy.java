import android.os.Process;
import android.os.SystemClock;
import com.tencent.mobileqq.startup.step.DtSdkInitStep;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import java.util.Map;
import java.util.TreeMap;

public class aqwy
{
  private static long a;
  public static boolean a;
  private static boolean b;
  
  private static long a()
  {
    return SystemClock.uptimeMillis() - a;
  }
  
  public static void a()
  {
    if (!DtSdkInitStep.b())
    {
      QLog.d("QQDtReportHelper", 1, "848QQDT [onQQLogin] dt sdk has not init");
      return;
    }
    QLog.d("QQDtReportHelper", 1, "848QQDT [onQQLogin]");
    c();
    a("dt_appin");
  }
  
  public static void a(int paramInt)
  {
    b = true;
    QLog.d("QQDtReportHelper", 1, "848QQDT [setIsMainProcess] process: " + Process.myPid() + ", from: " + paramInt);
  }
  
  private static void a(Long paramLong, String paramString)
  {
    if ("dt_appin".equals(paramString))
    {
      VideoReport.reportEvent("qqin", null);
      QLog.d("QQDtReportHelper", 1, "848QQDT [doSupplementReport] qqin");
      c();
    }
    while (!"dt_appout".equals(paramString)) {
      return;
    }
    if (a == 0L)
    {
      QLog.d("QQDtReportHelper", 1, "848QQDT [doSupplementReport] startTimestamp is 0");
      return;
    }
    paramString = new TreeMap();
    paramString.put("qq_lvtm", paramLong);
    VideoReport.reportEvent("qqout", paramString);
    QLog.d("QQDtReportHelper", 1, "848QQDT [doSupplementReport] qqout, timeInterval: " + paramLong);
  }
  
  public static void a(String paramString)
  {
    if ((b) && (a == 0L))
    {
      QLog.d("QQDtReportHelper", 1, "848QQDT [supplementReportForSwitchAccount] startTimestamp is 0");
      return;
    }
    a(Long.valueOf(a()), paramString);
  }
  
  public static void b()
  {
    if (!DtSdkInitStep.b())
    {
      QLog.d("QQDtReportHelper", 1, "848QQDT [onQQLogin] dt sdk has not init");
      return;
    }
    QLog.d("QQDtReportHelper", 1, "848QQDT [onQQLogout]");
    a("dt_appout");
    a = 0L;
  }
  
  public static void c()
  {
    a = SystemClock.uptimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d("QQDtReportHelper", 2, "848QQDT [updateStartTime] timeStamp: " + a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqwy
 * JD-Core Version:    0.7.0.1
 */
import android.os.Bundle;
import com.tencent.mobileqq.msf.sdk.utils.MonitorHttpInfo;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class awtp
  extends QIPCModule
{
  private static awtp a;
  
  private awtp(String paramString)
  {
    super(paramString);
  }
  
  public static awtp a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new awtp("NetworkMonitorIPCModule");
      }
      return a;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("NetworkMonitorIPCModule", 2, new Object[] { "NetworkMonitorIPCModule : " + paramString + ", " + paramBundle.toString(), ", " + paramInt });
    }
    if ("ACTION_REPORT_DOWNLOAD_URL".equalsIgnoreCase(paramString))
    {
      paramString = paramBundle.getString("BUNDLE_KEY_REPORT_DOWNLOAD_URL_URL", "");
      awtm.a().a(paramString);
    }
    for (;;)
    {
      return new EIPCResult();
      if ("ACTION_REPORT_HTTPINFO".equalsIgnoreCase(paramString))
      {
        try
        {
          paramString = (MonitorHttpInfo)paramBundle.getSerializable("BUNDLE_KEY_REPORT_HTTP_INFO_INFO");
          String str = paramBundle.getString("BUNDLE_KEY_REPORT_DOWNLOAD_URL_PROCESS_NAME", "");
          paramBundle = paramBundle.getString("BUNDLE_KEY_REPORT_DOWNLOAD_URL_TOP_ACTIVITY", "");
          if (paramString != null)
          {
            try
            {
              awtm.a().a(paramString, str, paramBundle);
            }
            catch (Throwable paramString) {}
            continue;
          }
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("NetworkMonitorIPCModule", 2, "MonitorHttpInfo == null");
        }
        catch (Exception paramString) {}
        if (QLog.isColorLevel()) {
          QLog.d("NetworkMonitorIPCModule", 2, new Object[] { "ClassCastException", paramString.toString() });
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     awtp
 * JD-Core Version:    0.7.0.1
 */
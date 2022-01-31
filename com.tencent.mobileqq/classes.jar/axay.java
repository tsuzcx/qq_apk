import android.app.Application;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.mobileqq.videoplatform.VideoPlaySDKManager;
import com.tencent.mobileqq.videoplatform.util.LoadSoUtil;
import com.tencent.mobileqq.videoplatform.util.LogUtil;
import com.tencent.mobileqq.videoplatform.util.ReportUtil;
import com.tencent.mobileqq.videoplatform.util.ThreadUtil;

public class axay
{
  private static volatile boolean a;
  
  static {}
  
  public static void a()
  {
    try
    {
      if (!a)
      {
        LogUtil.setLogImp(new axbd());
        ThreadUtil.setThreadImp(new axbf());
        LoadSoUtil.setLoadSoImp(new axbb());
        ReportUtil.setReportImp(new axbe());
        a = true;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void a(Application paramApplication, SDKInitListener paramSDKInitListener)
  {
    VideoPlaySDKManager.getInstance().initSDKAsync(paramApplication, paramSDKInitListener);
  }
  
  public static boolean a()
  {
    return VideoPlaySDKManager.getInstance().isSDKReady();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axay
 * JD-Core Version:    0.7.0.1
 */
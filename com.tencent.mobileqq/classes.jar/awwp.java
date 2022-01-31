import android.app.Application;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.mobileqq.videoplatform.VideoPlaySDKManager;
import com.tencent.mobileqq.videoplatform.util.LoadSoUtil;
import com.tencent.mobileqq.videoplatform.util.LogUtil;
import com.tencent.mobileqq.videoplatform.util.ReportUtil;
import com.tencent.mobileqq.videoplatform.util.ThreadUtil;

public class awwp
{
  private static volatile boolean a;
  
  static {}
  
  public static void a()
  {
    try
    {
      if (!a)
      {
        LogUtil.setLogImp(new awwu());
        ThreadUtil.setThreadImp(new awww());
        LoadSoUtil.setLoadSoImp(new awws());
        ReportUtil.setReportImp(new awwv());
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
 * Qualified Name:     awwp
 * JD-Core Version:    0.7.0.1
 */
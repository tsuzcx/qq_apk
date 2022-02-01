import android.app.Application;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.mobileqq.videoplatform.VideoPlaySDKManager;
import com.tencent.mobileqq.videoplatform.util.LoadSoUtil;
import com.tencent.mobileqq.videoplatform.util.LogUtil;
import com.tencent.mobileqq.videoplatform.util.RegisterTVideoUtil;
import com.tencent.mobileqq.videoplatform.util.ReportUtil;
import com.tencent.mobileqq.videoplatform.util.ThreadUtil;

public class azwq
{
  private static volatile boolean a;
  
  static {}
  
  public static void a()
  {
    try
    {
      if (!a)
      {
        LogUtil.setLogImp(new azww());
        ThreadUtil.setThreadImp(new azwz());
        LoadSoUtil.setLoadSoImp(new azwu());
        ReportUtil.setReportImp(new azwy());
        RegisterTVideoUtil.setRegisterTVideoImp(new azwx());
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
  
  public static boolean b()
  {
    return VideoPlaySDKManager.getInstance().isSoLoadSuc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azwq
 * JD-Core Version:    0.7.0.1
 */
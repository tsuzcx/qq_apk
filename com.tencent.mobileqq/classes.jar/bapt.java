import android.content.Context;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.mobileqq.videoplatform.VideoPlaySDKManager;
import com.tencent.mobileqq.videoplatform.util.LoadSoUtil;
import com.tencent.mobileqq.videoplatform.util.LogUtil;
import com.tencent.mobileqq.videoplatform.util.RegisterTVideoUtil;
import com.tencent.mobileqq.videoplatform.util.ReportUtil;
import com.tencent.mobileqq.videoplatform.util.ThreadUtil;

public class bapt
{
  private static volatile boolean a;
  
  static {}
  
  public static void a()
  {
    try
    {
      if (!a)
      {
        LogUtil.setLogImp(new bapz());
        ThreadUtil.setThreadImp(new baqc());
        LoadSoUtil.setLoadSoImp(new bapx());
        ReportUtil.setReportImp(new baqb());
        RegisterTVideoUtil.setRegisterTVideoImp(new baqa());
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
  
  public static void a(Context paramContext, SDKInitListener paramSDKInitListener)
  {
    VideoPlaySDKManager.getInstance().initSDKAsync(paramContext, paramSDKInitListener);
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
 * Qualified Name:     bapt
 * JD-Core Version:    0.7.0.1
 */
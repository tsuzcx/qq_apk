import com.tencent.mobileqq.shortvideo.util.ShortVideoGuideUtil.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;

public class axlk
  implements TVK_SDKMgr.InstallListener
{
  public axlk(ShortVideoGuideUtil.1 param1) {}
  
  public void onInstallProgress(float paramFloat) {}
  
  public void onInstalledFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(axlj.a, 2, "installSDK onInstalledFailed arg0=" + paramInt);
    }
  }
  
  public void onInstalledSuccessed()
  {
    if (QLog.isColorLevel()) {
      QLog.d(axlj.a, 2, "installSDK onInstalledSuccessed=");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     axlk
 * JD-Core Version:    0.7.0.1
 */
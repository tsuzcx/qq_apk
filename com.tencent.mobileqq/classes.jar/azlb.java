import com.tencent.mobileqq.shortvideo.util.ShortVideoGuideUtil.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;

public class azlb
  implements TVK_SDKMgr.InstallListener
{
  public azlb(ShortVideoGuideUtil.1 param1) {}
  
  public void onInstallProgress(float paramFloat) {}
  
  public void onInstalledFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(azla.a, 2, "installSDK onInstalledFailed arg0=" + paramInt);
    }
  }
  
  public void onInstalledSuccessed()
  {
    if (QLog.isColorLevel()) {
      QLog.d(azla.a, 2, "installSDK onInstalledSuccessed=");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azlb
 * JD-Core Version:    0.7.0.1
 */
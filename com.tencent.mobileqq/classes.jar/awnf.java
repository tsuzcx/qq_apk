import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;

class awnf
  implements TVK_SDKMgr.InstallListener
{
  public void onInstallProgress(float paramFloat)
  {
    if (QLog.isDevelopLevel()) {
      QLog.d("TencentVideoSDKManager", 4, "[SDKInstallListener] onInstallProgress(): v= " + paramFloat);
    }
  }
  
  public void onInstalledFailed(int paramInt)
  {
    awnd.a().set(false);
    if (QLog.isColorLevel()) {
      QLog.e("TencentVideoSDKManager", 2, "[SDKInstallListener] onInstalledFailed():");
    }
  }
  
  public void onInstalledSuccessed()
  {
    if (QLog.isColorLevel()) {
      QLog.d("TencentVideoSDKManager", 2, "[SDKInstallListener] onInstalledSuccessed():");
    }
    awnd.a().set(false);
    if (awnd.a() != null)
    {
      Iterator localIterator = awnd.a().iterator();
      while (localIterator.hasNext()) {
        ((awng)localIterator.next()).c();
      }
      awnd.a().clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awnf
 * JD-Core Version:    0.7.0.1
 */
import android.os.Handler;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.qphone.base.util.QLog;
import cooperation.groupvideo.GVideoPluginInstallerActivity;

public class blts
  extends OnPluginInstallListener.Stub
{
  public blts(GVideoPluginInstallerActivity paramGVideoPluginInstallerActivity) {}
  
  public void onInstallBegin(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.a, 2, "Group video plugin onInstallBegin...");
    }
  }
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.a, 2, "Group video plugin onInstallDownloadProgress...");
    }
  }
  
  public void onInstallError(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.a, 2, "Group video plugin onInstallError...");
    }
    this.a.b.sendEmptyMessageDelayed(3, 200L);
  }
  
  public void onInstallFinish(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.a, 2, "Group video plugin onInstallFinish...");
    }
    this.a.b.sendEmptyMessageDelayed(1, 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blts
 * JD-Core Version:    0.7.0.1
 */
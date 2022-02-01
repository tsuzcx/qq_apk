import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpic.PresenceInterfaceImpl.9.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;
import mqq.os.MqqHandler;

public class avol
  implements TVK_SDKMgr.InstallListener
{
  avol(avod paramavod) {}
  
  public void onInstallProgress(float paramFloat) {}
  
  public void onInstalledFailed(int paramInt)
  {
    avod.a = false;
    this.a.a(anvx.a(2131707858));
    if (QLog.isColorLevel()) {
      QLog.d("PresenceInterfaceImpl", 2, "tencent sdk onInstalledFail");
    }
  }
  
  public void onInstalledSuccessed()
  {
    avod.a = false;
    if (!this.a.c)
    {
      ThreadManager.getSubThreadHandler().post(new PresenceInterfaceImpl.9.1(this));
      QLog.d("PresenceInterfaceImpl", 2, "run installSDK here");
    }
    QLog.d("PresenceInterfaceImpl", 2, "tencent sdk onInstall sucess");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avol
 * JD-Core Version:    0.7.0.1
 */
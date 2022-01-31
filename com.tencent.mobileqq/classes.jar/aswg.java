import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hotpic.PresenceInterfaceImpl.9.1;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;
import mqq.os.MqqHandler;

public class aswg
  implements TVK_SDKMgr.InstallListener
{
  aswg(asvy paramasvy) {}
  
  public void onInstallProgress(float paramFloat) {}
  
  public void onInstalledFailed(int paramInt)
  {
    asvy.a = false;
    this.a.a(alud.a(2131708794));
    if (QLog.isColorLevel()) {
      QLog.d("PresenceInterfaceImpl", 2, "tencent sdk onInstalledFail");
    }
  }
  
  public void onInstalledSuccessed()
  {
    asvy.a = false;
    if (!this.a.c)
    {
      ThreadManager.getSubThreadHandler().post(new PresenceInterfaceImpl.9.1(this));
      QLog.d("PresenceInterfaceImpl", 2, "run installSDK here");
    }
    QLog.d("PresenceInterfaceImpl", 2, "tencent sdk onInstall sucess");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aswg
 * JD-Core Version:    0.7.0.1
 */
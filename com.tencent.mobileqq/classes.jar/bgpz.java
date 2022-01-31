import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pluginsdk.OnPluginInstallListener.Stub;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

class bgpz
  extends OnPluginInstallListener.Stub
{
  bgpz(bgpy parambgpy) {}
  
  public void onInstallBegin(String paramString) {}
  
  public void onInstallDownloadProgress(String paramString, int paramInt1, int paramInt2) {}
  
  public void onInstallError(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("qqfav", 2, "install plugin " + paramString + " error! " + paramInt);
    }
    try
    {
      ThreadManager.post(this.a.a, 5, null, false);
      return;
    }
    catch (Exception paramString) {}
  }
  
  public void onInstallFinish(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("qqfav", 2, "install plugin " + paramString + " OK.");
    }
    bgpw.a().set(true);
    try
    {
      ThreadManager.post(this.a.a, 5, null, false);
      return;
    }
    catch (Exception paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bgpz
 * JD-Core Version:    0.7.0.1
 */
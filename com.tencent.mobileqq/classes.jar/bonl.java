import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.camera.ui.dashboard.AEVideoStoryDashboardPart.6.1;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import mqq.os.MqqHandler;

public class bonl
  implements EIPCResultCallback
{
  bonl(bonf parambonf) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    ThreadManager.getUIHandler().post(new AEVideoStoryDashboardPart.6.1(this, paramEIPCResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bonl
 * JD-Core Version:    0.7.0.1
 */
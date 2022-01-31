import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.camera.ui.dashboard.AEVideoStoryDashboardPart.6.1;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import mqq.os.MqqHandler;

public class binw
  implements EIPCResultCallback
{
  binw(binq parambinq) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    ThreadManager.getUIHandler().post(new AEVideoStoryDashboardPart.6.1(this, paramEIPCResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     binw
 * JD-Core Version:    0.7.0.1
 */
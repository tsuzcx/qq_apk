import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.sdk.handler.INetEventHandler;
import dov.com.qq.im.ae.camera.ui.bottom.AEBottomListAdapter.1.1;
import mqq.os.MqqHandler;

public class bkus
  implements INetEventHandler
{
  bkus(bkur parambkur) {}
  
  public void onNetChangeEvent(boolean paramBoolean)
  {
    ThreadManager.getUIHandler().post(new AEBottomListAdapter.1.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkus
 * JD-Core Version:    0.7.0.1
 */
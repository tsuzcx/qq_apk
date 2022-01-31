import android.os.Handler;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment;
import com.tencent.mobileqq.gamecenter.web.QQGameFeedWebFragment.1.1;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

public class aqtr
  implements EIPCResultCallback
{
  public aqtr(QQGameFeedWebFragment paramQQGameFeedWebFragment) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if (paramEIPCResult.code == 0)
    {
      paramEIPCResult = paramEIPCResult.data;
      if (paramEIPCResult != null) {
        ThreadManagerV2.getUIHandlerV2().post(new QQGameFeedWebFragment.1.1(this, paramEIPCResult));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqtr
 * JD-Core Version:    0.7.0.1
 */
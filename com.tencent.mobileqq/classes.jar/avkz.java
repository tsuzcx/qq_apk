import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;

public class avkz
  implements SDKInitListener
{
  public avkz(GameCenterVideoViewController paramGameCenterVideoViewController) {}
  
  public void onSDKInited(boolean paramBoolean)
  {
    QLog.d("GameCenterVideoViewController", 4, "onSDKInited result:" + paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avkz
 * JD-Core Version:    0.7.0.1
 */
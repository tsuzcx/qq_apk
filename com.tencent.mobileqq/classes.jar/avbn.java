import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gamecenter.adapter.QQGamePubFeedsAdapter.FeedsItemVH.2.1;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class avbn
  implements avdp
{
  avbn(avbk paramavbk) {}
  
  public void onAudioMute(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGamePubFeedsAdapter", 4, "onAudioMute id=" + paramInt + " mute=" + paramBoolean);
    }
  }
  
  public void onSrceenModeChanged(boolean paramBoolean, int paramInt) {}
  
  public void onVideoStatusChanged(int paramInt1, int paramInt2)
  {
    ThreadManager.getUIHandler().post(new QQGamePubFeedsAdapter.FeedsItemVH.2.1(this, paramInt1));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avbn
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gamecenter.adapter.QQGamePubFeedsAdapter.FeedsItemVH.2.1;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class avjg
  implements avla
{
  avjg(avjd paramavjd) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    ThreadManager.getUIHandler().post(new QQGamePubFeedsAdapter.FeedsItemVH.2.1(this, paramInt1));
  }
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void b(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QQGamePubFeedsAdapter", 4, "onAudioMute id=" + paramInt + " mute=" + paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avjg
 * JD-Core Version:    0.7.0.1
 */
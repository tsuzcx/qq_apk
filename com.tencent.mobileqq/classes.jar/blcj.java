import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.play.AETakeFacePhotoPreviewFragment;
import dov.com.qq.im.ae.play.AETakeFacePhotoPreviewFragment.2.1;
import mqq.os.MqqHandler;

public class blcj
  extends bkvo
{
  public blcj(AETakeFacePhotoPreviewFragment paramAETakeFacePhotoPreviewFragment) {}
  
  public void b(boolean paramBoolean, int paramInt)
  {
    AETakeFacePhotoPreviewFragment.a(this.a).removeObserver(this);
    ThreadManager.getUIHandler().post(new AETakeFacePhotoPreviewFragment.2.1(this, paramBoolean, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blcj
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.AECamera.qudong.AETakeFacePhotoPreviewFragment;
import dov.com.qq.im.AECamera.qudong.AETakeFacePhotoPreviewFragment.2.1;
import mqq.os.MqqHandler;

public class bhao
  extends avzo
{
  public bhao(AETakeFacePhotoPreviewFragment paramAETakeFacePhotoPreviewFragment) {}
  
  public void b(boolean paramBoolean, int paramInt)
  {
    AETakeFacePhotoPreviewFragment.a(this.a).removeObserver(this);
    ThreadManager.getUIHandler().post(new AETakeFacePhotoPreviewFragment.2.1(this, paramBoolean, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bhao
 * JD-Core Version:    0.7.0.1
 */
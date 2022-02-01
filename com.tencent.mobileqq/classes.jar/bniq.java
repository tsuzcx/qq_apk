import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.cmshow.AECMShowPhotoPreviewFragment;
import dov.com.qq.im.ae.cmshow.AECMShowPhotoPreviewFragment.1.1;
import dov.com.qq.im.ae.cmshow.AECMShowPhotoPreviewFragment.1.2;
import dov.com.qq.im.ae.cmshow.AECMShowRequestController.CmShowDataWrapper;
import mqq.os.MqqHandler;

public class bniq
  implements bnjc
{
  public bniq(AECMShowPhotoPreviewFragment paramAECMShowPhotoPreviewFragment) {}
  
  public void a(int paramInt, @Nullable AECMShowRequestController.CmShowDataWrapper paramCmShowDataWrapper)
  {
    bnrh.a("AECMShowPhotoPreviewFragment", "[AECMShowRequestController.onComplete], resultCode=" + paramInt + ", dataWrapper=" + paramCmShowDataWrapper);
    ThreadManager.getUIHandler().post(new AECMShowPhotoPreviewFragment.1.2(this, paramInt, paramCmShowDataWrapper));
  }
  
  public void c(int paramInt)
  {
    ThreadManager.getUIHandler().post(new AECMShowPhotoPreviewFragment.1.1(this, paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bniq
 * JD-Core Version:    0.7.0.1
 */
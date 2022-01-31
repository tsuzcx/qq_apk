import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.mobileqq.gamecenter.data.PadFaceAd;
import com.tencent.mobileqq.gamecenter.fragment.QQGamePadFaceFragment;
import com.tencent.qphone.base.util.QLog;

public class aqsb
  implements ArkViewImplement.LoadCallback
{
  public aqsb(QQGamePadFaceFragment paramQQGamePadFaceFragment) {}
  
  public void onLoadFailed(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    onLoadState(paramInt1);
  }
  
  public void onLoadState(int paramInt)
  {
    if ((QLog.isColorLevel()) || (paramInt == -1)) {
      QLog.d("QQGamePadFaceFragment", 2, new Object[] { "onLoadFinish, ret=", Integer.valueOf(paramInt), ", ", QQGamePadFaceFragment.a(this.a) });
    }
    if (paramInt == 1) {
      QQGamePadFaceFragment.a(this.a).a(QQGamePadFaceFragment.a(this.a).padFaceId);
    }
    while (paramInt != -1) {
      return;
    }
    QQGamePadFaceFragment.a(this.a).a(QQGamePadFaceFragment.a(this.a).padFaceId);
    QQGamePadFaceFragment.b(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aqsb
 * JD-Core Version:    0.7.0.1
 */
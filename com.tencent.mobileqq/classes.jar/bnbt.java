import com.tencent.ttpic.openapi.filter.CosFunHelper.CountDownListener;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;

public class bnbt
  implements CosFunHelper.CountDownListener
{
  public bnbt(QIMEffectCameraCaptureUnit paramQIMEffectCameraCaptureUnit) {}
  
  public void onCountDownEnd()
  {
    QIMEffectCameraCaptureUnit.a(this.a);
  }
  
  public void onCountDownStart(VideoMaterial paramVideoMaterial)
  {
    QIMEffectCameraCaptureUnit.a(this.a, paramVideoMaterial.getTipsDrawable());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnbt
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.ttpic.openapi.filter.CosFunHelper.CountDownListener;
import com.tencent.ttpic.openapi.model.VideoMaterial;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;

public class bkiz
  implements CosFunHelper.CountDownListener
{
  public bkiz(QIMEffectCameraCaptureUnit paramQIMEffectCameraCaptureUnit) {}
  
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
 * Qualified Name:     bkiz
 * JD-Core Version:    0.7.0.1
 */
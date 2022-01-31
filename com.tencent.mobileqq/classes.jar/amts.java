import com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;
import dov.com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager;

public class amts
  implements Runnable
{
  public amts(QIMEffectCameraCaptureUnit paramQIMEffectCameraCaptureUnit) {}
  
  public void run()
  {
    CapturePtvTemplateManager.a().a();
    CaptureReportUtil.h();
    this.a.A();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     amts
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.music.CaptureConfigUpdateObserver;
import dov.com.qq.im.capture.view.QIMPtvTemplateProviderView;

public class amzt
  extends CaptureConfigUpdateObserver
{
  public amzt(QIMPtvTemplateProviderView paramQIMPtvTemplateProviderView) {}
  
  public void d()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PtvTemplateProviderView", 2, "onFaceUUpdate!");
    }
    this.a.d();
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PtvTemplateProviderView", 2, "onSegmentModeUpdate!");
    }
    this.a.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     amzt
 * JD-Core Version:    0.7.0.1
 */
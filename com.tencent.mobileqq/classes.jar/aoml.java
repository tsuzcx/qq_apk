import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.richmedia.capture.view.CaptureVideoFilterViewPager;

public class aoml
  implements Runnable
{
  public aoml(CaptureVideoFilterViewPager paramCaptureVideoFilterViewPager) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFilterViewPager", 2, "onCaptureVideoFilterRefresh");
    }
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aoml
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.richmedia.capture.view.CaptureVideoFilterViewPager;

public class anwg
  implements Runnable
{
  public anwg(CaptureVideoFilterViewPager paramCaptureVideoFilterViewPager) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoFilterViewPager", 2, "onCaptureVideoFilterRefresh");
    }
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anwg
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.richmedia.capture.data.CaptureVideoFilterManager;

public class aoln
  implements Runnable
{
  public aoln(CaptureVideoFilterManager paramCaptureVideoFilterManager) {}
  
  public void run()
  {
    this.a.a(true);
    if (QLog.isColorLevel()) {
      QLog.d("QIMRedDotConfig", 2, "saved to red dot config file");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aoln
 * JD-Core Version:    0.7.0.1
 */
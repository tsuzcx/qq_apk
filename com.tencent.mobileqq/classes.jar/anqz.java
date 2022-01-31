import android.app.Activity;
import dov.com.qq.im.QIMCameraCaptureUnit;
import dov.com.qq.im.setting.IQIMCameraContainer;

public class anqz
  implements Runnable
{
  public anqz(QIMCameraCaptureUnit paramQIMCameraCaptureUnit) {}
  
  public void run()
  {
    QIMCameraCaptureUnit.a(this.a, false);
    this.a.a.a().runOnUiThread(new anra(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anqz
 * JD-Core Version:    0.7.0.1
 */
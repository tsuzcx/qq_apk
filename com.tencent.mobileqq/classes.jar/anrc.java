import android.app.Activity;
import android.graphics.Bitmap;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import dov.com.qq.im.QIMCameraCaptureUnit;
import dov.com.qq.im.QIMCameraUtil;
import dov.com.qq.im.setting.IQIMCameraContainer;

public class anrc
  implements Runnable
{
  public anrc(QIMCameraCaptureUnit paramQIMCameraCaptureUnit) {}
  
  public void run()
  {
    try
    {
      QIMCameraCaptureUnit.a(this.a, QIMCameraUtil.a(this.a.a.a(), true));
      if ((QIMCameraCaptureUnit.a(this.a) != null) && (!QIMCameraCaptureUnit.a(this.a).isRecycled())) {
        QIMCameraCaptureUnit.a(this.a, ImageUtil.b(QIMCameraCaptureUnit.a(this.a), ViewUtils.a(3.0F), QIMCameraCaptureUnit.a(this.a).getWidth(), QIMCameraCaptureUnit.a(this.a).getHeight()));
      }
      this.a.a.a().runOnUiThread(new anrd(this));
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anrc
 * JD-Core Version:    0.7.0.1
 */
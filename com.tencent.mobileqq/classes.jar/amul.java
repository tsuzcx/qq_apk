import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.QIMCaptureController;

public class amul
  implements View.OnClickListener
{
  public amul(QIMCaptureController paramQIMCaptureController) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CaptureController", 2, "banner tip clicked");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     amul
 * JD-Core Version:    0.7.0.1
 */
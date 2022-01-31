import android.widget.Toast;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.PhotoCaptureResult;
import dov.com.qq.im.QIMCameraCaptureUnit;

public class amsu
  implements Runnable
{
  public amsu(QIMCameraCaptureUnit paramQIMCameraCaptureUnit, CameraCaptureView.PhotoCaptureResult paramPhotoCaptureResult) {}
  
  public void run()
  {
    Toast.makeText(BaseApplicationImpl.getContext(), "onPhotoCaptured : " + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$PhotoCaptureResult.a, 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     amsu
 * JD-Core Version:    0.7.0.1
 */
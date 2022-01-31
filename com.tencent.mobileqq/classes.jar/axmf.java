import android.graphics.Rect;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class axmf
  implements azdk
{
  public axmf(CameraCaptureView paramCameraCaptureView, File paramFile, int paramInt, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "onAutoFocusCallback requestFocus when capture : " + paramBoolean1 + ", [Camera2]camera2:" + paramBoolean2);
    }
    CameraCaptureView.a.a(this.jdField_a_of_type_JavaIoFile, new Rect(0, 0, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.b, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.c), this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView, this.jdField_a_of_type_Int, this.jdField_a_of_type_Boolean, 1, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView.v);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axmf
 * JD-Core Version:    0.7.0.1
 */
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import com.tencent.qphone.base.util.QLog;

public class axme
  implements azdk
{
  public axme(CameraCaptureView paramCameraCaptureView) {}
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CameraCaptureView", 2, "onAutoFocusCallback single tap focus " + paramBoolean1 + ", camera2:" + paramBoolean2);
    }
    if (paramBoolean1)
    {
      CameraCaptureView.a(this.a, true);
      return;
    }
    CameraCaptureView.a.g();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axme
 * JD-Core Version:    0.7.0.1
 */
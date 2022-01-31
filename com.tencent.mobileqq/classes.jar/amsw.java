import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView.VideoCaptureResult;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.QIMCameraCaptureUnit;

public class amsw
  implements Runnable
{
  public amsw(QIMCameraCaptureUnit paramQIMCameraCaptureUnit, CameraCaptureView.VideoCaptureResult paramVideoCaptureResult) {}
  
  public void run()
  {
    QLog.d("VERSION_CODES", 2, "onVideoCaptured. videoFrameCount = " + this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCameraCaptureView$VideoCaptureResult.videoFrameCount + " ; minFrameCount = " + QIMCameraCaptureUnit.a(this.jdField_a_of_type_DovComQqImQIMCameraCaptureUnit));
    QQToast.a(BaseApplicationImpl.getContext(), "拍摄时间过短，请重新拍摄。", 0).a();
    if (this.jdField_a_of_type_DovComQqImQIMCameraCaptureUnit.a) {
      this.jdField_a_of_type_DovComQqImQIMCameraCaptureUnit.w();
    }
    this.jdField_a_of_type_DovComQqImQIMCameraCaptureUnit.e();
    this.jdField_a_of_type_DovComQqImQIMCameraCaptureUnit.y();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     amsw
 * JD-Core Version:    0.7.0.1
 */
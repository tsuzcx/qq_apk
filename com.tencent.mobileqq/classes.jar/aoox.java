import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.activity.richmedia.FlowCameraActivity2;
import dov.com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;

public class aoox
  implements Runnable
{
  private SVHwEncoder jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder;
  
  public aoox(FlowCameraActivity2 paramFlowCameraActivity2, SVHwEncoder paramSVHwEncoder)
  {
    this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder = paramSVHwEncoder;
  }
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FlowCameraActivity", 2, "handleQQVideo(): onSendVideoClick mEncoderCache=" + this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder);
    }
    if (this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder != null) {
      this.jdField_a_of_type_DovComTencentMobileqqShortvideoHwcodecSVHwEncoder.b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aoox
 * JD-Core Version:    0.7.0.1
 */
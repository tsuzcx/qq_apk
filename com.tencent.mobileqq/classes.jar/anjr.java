import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;
import dov.com.qq.im.capture.QIMCaptureController;
import dov.com.qq.im.capture.QIMManager;
import dov.com.qq.im.capture.adapter.QIMPtvTemplateAdapter;
import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager;

public class anjr
  implements Runnable
{
  public anjr(QIMEffectCameraCaptureUnit paramQIMEffectCameraCaptureUnit, boolean paramBoolean) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Boolean) && (QIMEffectCameraCaptureUnit.e(this.jdField_a_of_type_DovComQqImQIMEffectCameraCaptureUnit)))
    {
      this.jdField_a_of_type_DovComQqImQIMEffectCameraCaptureUnit.d = true;
      QIMEffectCameraCaptureUnit.d(this.jdField_a_of_type_DovComQqImQIMEffectCameraCaptureUnit);
    }
    ((QIMPtvTemplateManager)QIMManager.a(3)).a("0", QIMPtvTemplateAdapter.b, "");
    this.jdField_a_of_type_DovComQqImQIMEffectCameraCaptureUnit.jdField_a_of_type_DovComQqImCaptureQIMCaptureController.t();
    this.jdField_a_of_type_DovComQqImQIMEffectCameraCaptureUnit.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.setFaceEffect("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anjr
 * JD-Core Version:    0.7.0.1
 */
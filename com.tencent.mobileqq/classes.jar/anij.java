import android.app.Activity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import dov.com.qq.im.QIMCameraCaptureUnit;
import dov.com.qq.im.setting.ICameraEntrance;
import dov.com.qq.im.setting.IQIMCameraContainer;

public class anij
  implements Runnable
{
  public anij(QIMCameraCaptureUnit paramQIMCameraCaptureUnit, int paramInt) {}
  
  public void run()
  {
    switch (this.jdField_a_of_type_Int)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          QQToast.a(BaseApplicationImpl.getApplication(), "录制出现异常，请重试", 1).a();
          Activity localActivity = this.jdField_a_of_type_DovComQqImQIMCameraCaptureUnit.jdField_a_of_type_DovComQqImSettingIQIMCameraContainer.a();
          if ((localActivity != null) && (!localActivity.isFinishing())) {
            this.jdField_a_of_type_DovComQqImQIMCameraCaptureUnit.jdField_a_of_type_DovComQqImSettingICameraEntrance.a(2);
          }
        } while (!this.jdField_a_of_type_DovComQqImQIMCameraCaptureUnit.jdField_a_of_type_Boolean);
        this.jdField_a_of_type_DovComQqImQIMCameraCaptureUnit.x();
        return;
        QQToast.a(BaseApplicationImpl.getContext(), "拍摄时间过短，请重新拍摄。", 0).a();
        this.jdField_a_of_type_DovComQqImQIMCameraCaptureUnit.e();
      } while (!this.jdField_a_of_type_DovComQqImQIMCameraCaptureUnit.jdField_a_of_type_Boolean);
      this.jdField_a_of_type_DovComQqImQIMCameraCaptureUnit.w();
      return;
      QQToast.a(BaseApplicationImpl.getContext(), "拍照出现异常，请重试", 0).a();
    } while (!this.jdField_a_of_type_DovComQqImQIMCameraCaptureUnit.jdField_a_of_type_Boolean);
    this.jdField_a_of_type_DovComQqImQIMCameraCaptureUnit.w();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anij
 * JD-Core Version:    0.7.0.1
 */
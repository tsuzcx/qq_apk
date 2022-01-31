import android.widget.Button;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureView;
import dov.com.qq.im.QIMCameraCaptureUnit;

public class amsj
  implements Runnable
{
  public amsj(QIMCameraCaptureUnit paramQIMCameraCaptureUnit, boolean paramBoolean) {}
  
  public void run()
  {
    if (!QIMCameraCaptureUnit.c(this.jdField_a_of_type_DovComQqImQIMCameraCaptureUnit))
    {
      if (!this.jdField_a_of_type_Boolean) {
        break label73;
      }
      if (!QIMCameraCaptureUnit.d(this.jdField_a_of_type_DovComQqImQIMCameraCaptureUnit))
      {
        this.jdField_a_of_type_DovComQqImQIMCameraCaptureUnit.c.setVisibility(0);
        this.jdField_a_of_type_DovComQqImQIMCameraCaptureUnit.c.setSelected(true);
        this.jdField_a_of_type_DovComQqImQIMCameraCaptureUnit.a.c(this.jdField_a_of_type_Boolean);
        QIMCameraCaptureUnit.c(this.jdField_a_of_type_DovComQqImQIMCameraCaptureUnit, false);
      }
    }
    return;
    label73:
    this.jdField_a_of_type_DovComQqImQIMCameraCaptureUnit.c.setVisibility(8);
    this.jdField_a_of_type_DovComQqImQIMCameraCaptureUnit.c.setSelected(false);
    this.jdField_a_of_type_DovComQqImQIMCameraCaptureUnit.a.c(this.jdField_a_of_type_Boolean);
    QIMCameraCaptureUnit.c(this.jdField_a_of_type_DovComQqImQIMCameraCaptureUnit, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     amsj
 * JD-Core Version:    0.7.0.1
 */
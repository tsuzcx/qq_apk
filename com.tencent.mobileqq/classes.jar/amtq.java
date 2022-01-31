import android.view.ViewGroup;
import android.widget.ImageView;
import com.tencent.mobileqq.richmedia.capture.view.EffectsCameraCaptureView;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;

public class amtq
  implements Runnable
{
  public amtq(QIMEffectCameraCaptureUnit paramQIMEffectCameraCaptureUnit) {}
  
  public void run()
  {
    QIMEffectCameraCaptureUnit.g(this.a, false);
    if (QIMEffectCameraCaptureUnit.a(this.a) == null) {
      return;
    }
    ((ViewGroup)this.a.jdField_a_of_type_AndroidViewView).removeView(QIMEffectCameraCaptureUnit.a(this.a));
    QIMEffectCameraCaptureUnit.b(this.a).setVisibility(0);
    QIMEffectCameraCaptureUnit.b(this.a).setEnabled(true);
    this.a.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewEffectsCameraCaptureView.a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     amtq
 * JD-Core Version:    0.7.0.1
 */
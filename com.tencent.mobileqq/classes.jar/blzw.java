import android.annotation.TargetApi;
import android.view.View;
import android.view.animation.Transformation;
import dov.com.qq.im.capture.view.AdvancedProviderView;
import dov.com.qq.im.capture.view.QIMProviderContainerView;

public class blzw
  implements bdoh<Float>
{
  public blzw(AdvancedProviderView paramAdvancedProviderView, QIMProviderContainerView paramQIMProviderContainerView, View paramView) {}
  
  @TargetApi(11)
  public void a(bdob<Float> parambdob, float paramFloat, Float paramFloat1, Transformation paramTransformation)
  {
    paramFloat = paramFloat1.floatValue();
    if (this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView != null) {
      this.jdField_a_of_type_DovComQqImCaptureViewQIMProviderContainerView.setBackGroundAlpha(paramFloat);
    }
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setAlpha(paramFloat);
    }
    AdvancedProviderView.a(this.jdField_a_of_type_DovComQqImCaptureViewAdvancedProviderView, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blzw
 * JD-Core Version:    0.7.0.1
 */
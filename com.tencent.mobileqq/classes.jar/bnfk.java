import android.annotation.TargetApi;
import android.view.View;
import android.view.animation.Transformation;
import dov.com.qq.im.ae.camera.ui.panel.AEBeautyProviderView;
import dov.com.qq.im.ae.camera.ui.panel.AEProviderContainerView;

public class bnfk
  implements bhir<Float>
{
  public bnfk(AEBeautyProviderView paramAEBeautyProviderView, AEProviderContainerView paramAEProviderContainerView, View paramView) {}
  
  @TargetApi(11)
  public void a(bhil<Float> parambhil, float paramFloat, Float paramFloat1, Transformation paramTransformation)
  {
    paramFloat = paramFloat1.floatValue();
    if (this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEProviderContainerView != null) {
      this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEProviderContainerView.setBackGroundAlpha(paramFloat);
    }
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setAlpha(paramFloat);
    }
    AEBeautyProviderView.a(this.jdField_a_of_type_DovComQqImAeCameraUiPanelAEBeautyProviderView, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnfk
 * JD-Core Version:    0.7.0.1
 */
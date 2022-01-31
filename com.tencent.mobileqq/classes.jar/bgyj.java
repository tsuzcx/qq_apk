import android.annotation.TargetApi;
import android.view.View;
import android.view.animation.Transformation;
import dov.com.qq.im.AECamera.View.AEBeautyProviderView;
import dov.com.qq.im.AECamera.View.AEProviderContainerView;

public class bgyj
  implements bajj<Float>
{
  public bgyj(AEBeautyProviderView paramAEBeautyProviderView, AEProviderContainerView paramAEProviderContainerView, View paramView) {}
  
  @TargetApi(11)
  public void a(bajd<Float> parambajd, float paramFloat, Float paramFloat1, Transformation paramTransformation)
  {
    paramFloat = paramFloat1.floatValue();
    if (this.jdField_a_of_type_DovComQqImAECameraViewAEProviderContainerView != null) {
      this.jdField_a_of_type_DovComQqImAECameraViewAEProviderContainerView.setBackGroundAlpha(paramFloat);
    }
    if (this.jdField_a_of_type_AndroidViewView != null) {
      this.jdField_a_of_type_AndroidViewView.setAlpha(paramFloat);
    }
    AEBeautyProviderView.a(this.jdField_a_of_type_DovComQqImAECameraViewAEBeautyProviderView, paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bgyj
 * JD-Core Version:    0.7.0.1
 */
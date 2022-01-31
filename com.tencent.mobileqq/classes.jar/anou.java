import android.annotation.TargetApi;
import android.view.View;
import android.view.animation.Transformation;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.mobileqq.utils.ValueAnimation.AnimationUpdateListener;
import dov.com.qq.im.capture.view.AdvancedProviderView;
import dov.com.qq.im.capture.view.QIMProviderContainerView;

public class anou
  implements ValueAnimation.AnimationUpdateListener
{
  public anou(AdvancedProviderView paramAdvancedProviderView, QIMProviderContainerView paramQIMProviderContainerView, View paramView) {}
  
  @TargetApi(11)
  public void a(ValueAnimation paramValueAnimation, float paramFloat, Float paramFloat1, Transformation paramTransformation)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anou
 * JD-Core Version:    0.7.0.1
 */
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.richmedia.capture.view.CameraCaptureButtonLayout;
import com.tencent.mobileqq.richmedia.capture.view.ProviderContainerView;
import com.tencent.mobileqq.richmedia.capture.view.ProviderView;

public class axsa
  implements Animation.AnimationListener
{
  public axsa(ProviderContainerView paramProviderContainerView, boolean paramBoolean) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (ProviderContainerView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView) != null)
    {
      ProviderContainerView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView).setAlpha(1.0F);
      ProviderContainerView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView).setVisibility(8);
    }
    if ((!this.jdField_a_of_type_Boolean) && (ProviderContainerView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView) != null)) {
      ProviderContainerView.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewProviderContainerView).a(false, 150);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axsa
 * JD-Core Version:    0.7.0.1
 */
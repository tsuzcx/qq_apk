import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.richmedia.capture.view.CaptureVideoFilterViewPager;

public class axqx
  implements Animation.AnimationListener
{
  public axqx(CaptureVideoFilterViewPager paramCaptureVideoFilterViewPager, View paramView, int paramInt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    if (this.jdField_a_of_type_Int == CaptureVideoFilterViewPager.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager)) {
      CaptureVideoFilterViewPager.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager, false);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     axqx
 * JD-Core Version:    0.7.0.1
 */
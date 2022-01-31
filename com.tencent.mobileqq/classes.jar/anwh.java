import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import dov.com.tencent.mobileqq.richmedia.capture.view.CaptureVideoFilterViewPager;

public class anwh
  implements Animation.AnimationListener
{
  public anwh(CaptureVideoFilterViewPager paramCaptureVideoFilterViewPager, View paramView, int paramInt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    if (this.jdField_a_of_type_Int == CaptureVideoFilterViewPager.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager)) {
      CaptureVideoFilterViewPager.a(this.jdField_a_of_type_DovComTencentMobileqqRichmediaCaptureViewCaptureVideoFilterViewPager, false);
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anwh
 * JD-Core Version:    0.7.0.1
 */
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import dov.com.tencent.mobileqq.richmedia.capture.view.CaptureVideoFilterViewPager;

public class brei
  implements Animation.AnimationListener
{
  public brei(CaptureVideoFilterViewPager paramCaptureVideoFilterViewPager, View paramView, int paramInt) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     brei
 * JD-Core Version:    0.7.0.1
 */
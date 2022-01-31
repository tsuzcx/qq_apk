import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.profile.view.VipProfileSimpleView;

public class avaq
  implements Animation.AnimationListener
{
  public avaq(VipProfileSimpleView paramVipProfileSimpleView, auuw paramauuw) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    VipProfileSimpleView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipProfileSimpleView, true);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewVipProfileSimpleView.g(this.jdField_a_of_type_Auuw);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avaq
 * JD-Core Version:    0.7.0.1
 */
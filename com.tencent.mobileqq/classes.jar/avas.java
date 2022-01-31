import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.profile.view.VipProfileSimpleView;

public class avas
  implements Animation.AnimationListener
{
  public avas(VipProfileSimpleView paramVipProfileSimpleView, auuy paramauuy) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    VipProfileSimpleView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipProfileSimpleView, true);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewVipProfileSimpleView.g(this.jdField_a_of_type_Auuy);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avas
 * JD-Core Version:    0.7.0.1
 */
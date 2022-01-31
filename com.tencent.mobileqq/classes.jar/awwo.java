import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.profile.view.VipProfileSimpleView;

public class awwo
  implements Animation.AnimationListener
{
  public awwo(VipProfileSimpleView paramVipProfileSimpleView, awqt paramawqt) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    VipProfileSimpleView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipProfileSimpleView, true);
    this.jdField_a_of_type_ComTencentMobileqqProfileViewVipProfileSimpleView.g(this.jdField_a_of_type_Awqt);
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awwo
 * JD-Core Version:    0.7.0.1
 */
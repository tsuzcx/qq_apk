import android.content.res.Resources;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.profile.view.ProfileTagView;
import com.tencent.mobileqq.profile.view.VipTagView;

public class auzz
  implements Animation.AnimationListener
{
  public auzz(ProfileTagView paramProfileTagView, VipTagView paramVipTagView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipTagView, true);
  }
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.a.a.a != 0) {
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipTagView.setTagColor(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.getResources().getColor(2131166439), this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.getResources().getColor(2131166437));
    }
  }
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auzz
 * JD-Core Version:    0.7.0.1
 */
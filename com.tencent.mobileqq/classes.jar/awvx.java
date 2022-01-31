import android.content.res.Resources;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.profile.view.ProfileTagView;
import com.tencent.mobileqq.profile.view.VipTagView;

public class awvx
  implements Animation.AnimationListener
{
  public awvx(ProfileTagView paramProfileTagView, VipTagView paramVipTagView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipTagView, true);
  }
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.a.a.a != 0) {
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipTagView.setTagColor(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.getResources().getColor(2131166488), this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileTagView.getResources().getColor(2131166486));
    }
  }
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awvx
 * JD-Core Version:    0.7.0.1
 */
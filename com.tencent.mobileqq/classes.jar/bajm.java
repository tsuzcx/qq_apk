import android.content.res.Resources;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.profile.view.VipTagView;
import com.tencent.mobileqq.profilecard.vas.view.VasProfileTagView;

public class bajm
  implements Animation.AnimationListener
{
  public bajm(VasProfileTagView paramVasProfileTagView, VipTagView paramVipTagView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileTagView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipTagView, true);
  }
  
  public void onAnimationRepeat(Animation paramAnimation)
  {
    if (VasProfileTagView.a(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileTagView).a.a != 0) {
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipTagView.setTagColor(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileTagView.getResources().getColor(2131166566), this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileTagView.getResources().getColor(2131166564));
    }
  }
  
  public void onAnimationStart(Animation paramAnimation) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bajm
 * JD-Core Version:    0.7.0.1
 */
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.profile.view.VipTagView;
import com.tencent.mobileqq.profilecard.vas.view.VasProfileTagView;

public class ayzg
  extends AnimatorListenerAdapter
{
  public ayzg(VasProfileTagView paramVasProfileTagView, boolean paramBoolean, VipTagView paramVipTagView) {}
  
  public void onAnimationEnd(Animator paramAnimator)
  {
    if ((this.jdField_a_of_type_Boolean) && (VasProfileTagView.b(this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileTagView).a.a != 0) && (this.jdField_a_of_type_ComTencentMobileqqProfileViewVipTagView.getTag(2131374801) != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileViewVipTagView.getTag(2131374801).equals(Boolean.valueOf(true))))
    {
      this.jdField_a_of_type_ComTencentMobileqqProfileViewVipTagView.setTag(2131374801, Boolean.valueOf(false));
      this.jdField_a_of_type_ComTencentMobileqqProfilecardVasViewVasProfileTagView.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewVipTagView, ((Long)this.jdField_a_of_type_ComTencentMobileqqProfileViewVipTagView.getTag(2131374803)).longValue());
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqProfileViewVipTagView.setShakingState(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayzg
 * JD-Core Version:    0.7.0.1
 */
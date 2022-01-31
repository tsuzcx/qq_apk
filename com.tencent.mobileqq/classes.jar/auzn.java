import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.qphone.base.util.QLog;

public class auzn
  extends bfmx
{
  public auzn(ProfileHeaderView paramProfileHeaderView, LinearLayout paramLinearLayout, View paramView) {}
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    if (QLog.isColorLevel()) {
      QLog.d(ProfileHeaderView.jdField_a_of_type_JavaLangString, 2, "ProfileHeaderView updateTips sideOutAnim onAnimationEnd");
    }
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidViewView);
    paramAnimation = AnimationUtils.loadAnimation(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, 2130772246);
    paramAnimation.setFillAfter(true);
    this.jdField_a_of_type_AndroidViewView.startAnimation(paramAnimation);
    if (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_Int < 4)
    {
      paramAnimation = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView;
      paramAnimation.jdField_a_of_type_Int += 1;
      paramAnimation = this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_Bfnk.obtainMessage(ProfileHeaderView.b);
      this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_Bfnk.sendMessageDelayed(paramAnimation, 4000L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auzn
 * JD-Core Version:    0.7.0.1
 */
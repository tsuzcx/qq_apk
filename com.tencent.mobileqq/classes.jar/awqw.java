import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.mobileqq.richstatus.SignTextEditFragment;

public class awqw
  implements View.OnClickListener
{
  public awqw(ProfileHeaderView paramProfileHeaderView, String paramString, int paramInt, View paramView) {}
  
  public void onClick(View paramView)
  {
    if ((aybd.a(this.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Int >= 0))
    {
      paramView = new Bundle();
      paramView.putString("key_sign_topic_name", this.jdField_a_of_type_JavaLangString);
      paramView.putInt("key_sign_topic_id", this.jdField_a_of_type_Int);
      paramView.putInt("from_type", 2);
      if ((this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && (this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)) {
        SignTextEditFragment.a(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, null, null, paramView, -1);
      }
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      awne.a().c(this.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      azmj.b(null, "dc00898", "", "", "0X800A4D5", "0X800A4D5", 0, 0, "2", "0", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awqw
 * JD-Core Version:    0.7.0.1
 */
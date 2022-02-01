import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profilesetting.ProfileCardMoreActivity;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.os.MqqHandler;

public class bakt
  implements bliz
{
  public bakt(ProfileCardMoreActivity paramProfileCardMoreActivity, String paramString, blir paramblir) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_Blir.e();
      return;
      bdll.b(this.jdField_a_of_type_ComTencentMobileqqProfilesettingProfileCardMoreActivity.app, "CliOper", "", "", "P_prof", "Pp_more_delete", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfilesettingProfileCardMoreActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.h), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqProfilesettingProfileCardMoreActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne)), "", "", "");
      if (bhnv.d(BaseApplication.getContext()))
      {
        ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqProfilesettingProfileCardMoreActivity.app.a(1)).c(this.jdField_a_of_type_JavaLangString, (byte)2);
        paramView = this.jdField_a_of_type_ComTencentMobileqqProfilesettingProfileCardMoreActivity.app.getHandler(ChatActivity.class);
        if (paramView != null) {
          paramView.sendMessage(paramView.obtainMessage(16711681, this.jdField_a_of_type_JavaLangString));
        }
        paramView = this.jdField_a_of_type_ComTencentMobileqqProfilesettingProfileCardMoreActivity.app.getHandler(ChatSettingActivity.class);
        if (paramView != null) {
          paramView.sendMessage(paramView.obtainMessage(16711681, this.jdField_a_of_type_JavaLangString));
        }
        if (this.jdField_a_of_type_ComTencentMobileqqProfilesettingProfileCardMoreActivity.jdField_a_of_type_AndroidContentIntent == null) {
          this.jdField_a_of_type_ComTencentMobileqqProfilesettingProfileCardMoreActivity.jdField_a_of_type_AndroidContentIntent = new Intent();
        }
        this.jdField_a_of_type_ComTencentMobileqqProfilesettingProfileCardMoreActivity.jdField_a_of_type_AndroidContentIntent.putExtra("finchat", true);
        this.jdField_a_of_type_ComTencentMobileqqProfilesettingProfileCardMoreActivity.setResult(-1, this.jdField_a_of_type_ComTencentMobileqqProfilesettingProfileCardMoreActivity.jdField_a_of_type_AndroidContentIntent);
        if (bhjx.b(this.jdField_a_of_type_JavaLangString)) {
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqProfilesettingProfileCardMoreActivity.app, "dc00898", "", "", "0X8007FDF", "0X8007FDF", 0, 0, "", "", "", "");
        }
        this.jdField_a_of_type_ComTencentMobileqqProfilesettingProfileCardMoreActivity.finish();
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqProfilesettingProfileCardMoreActivity.a(2131691310, 1);
        continue;
        if (bhjx.b(this.jdField_a_of_type_JavaLangString)) {
          bdll.b(this.jdField_a_of_type_ComTencentMobileqqProfilesettingProfileCardMoreActivity.app, "dc00898", "", "", "0X8007FE0", "0X8007FE0", 0, 0, "", "", "", "");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bakt
 * JD-Core Version:    0.7.0.1
 */
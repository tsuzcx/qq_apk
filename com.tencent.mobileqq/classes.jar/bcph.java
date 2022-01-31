import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendEditFragment;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendProfileEditFragment.ExtendFriendInfo;
import com.tencent.mobileqq.widget.ProfileCardMoreInfoView;

public class bcph
  implements View.OnClickListener
{
  public bcph(ProfileCardMoreInfoView paramProfileCardMoreInfoView, Card paramCard) {}
  
  public void onClick(View paramView)
  {
    if (aoeu.a(this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
    {
      paramView = aokw.a(this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_ComTencentMobileqqAppBaseActivity);
      int j = 1;
      int i = j;
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_ComTencentMobileqqAppBaseActivity instanceof FriendProfileCardActivity))
      {
        i = j;
        if (((FriendProfileCardActivity)this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_ComTencentMobileqqAppBaseActivity).k) {
          i = 2;
        }
      }
      axqy.b(null, "dc00898", "", "", "kuolie", "0X80097DB", i, 0, "", "", "", "");
      if ((this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && (!this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.isFinishing())) {
        paramView.show();
      }
      return;
    }
    paramView = new Intent();
    if (this.jdField_a_of_type_ComTencentMobileqqDataCard != null) {
      paramView.putExtra("key_extend_friend_info", new ExtendFriendProfileEditFragment.ExtendFriendInfo(this.jdField_a_of_type_ComTencentMobileqqDataCard));
    }
    axqy.b(this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "kuolie", "0X80092DB", 0, 0, "", "", "", "");
    PublicFragmentActivity.a(this.jdField_a_of_type_ComTencentMobileqqWidgetProfileCardMoreInfoView.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, paramView, ExtendFriendEditFragment.class, 4097);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bcph
 * JD-Core Version:    0.7.0.1
 */
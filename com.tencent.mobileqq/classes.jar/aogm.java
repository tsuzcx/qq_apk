import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.InterestSwitchEditActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendBaseFragment;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendEditFragment;

public class aogm
  implements View.OnClickListener
{
  public aogm(ExtendFriendBaseFragment paramExtendFriendBaseFragment) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131363535: 
      if ((this.a.jdField_a_of_type_AndroidAppDialog != null) && (this.a.jdField_a_of_type_AndroidAppDialog.isShowing())) {
        this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      if (!this.a.jdField_a_of_type_Boolean)
      {
        axqw.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092EC", "0X80092EC", 0, 0, "", "", "", "");
        return;
      }
      axqw.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092E9", "0X80092E9", 0, 0, "", "", "", "");
      return;
    }
    if (!this.a.jdField_a_of_type_Boolean) {
      PublicFragmentActivity.a(this.a.getActivity(), ExtendFriendEditFragment.class, 1033);
    }
    for (;;)
    {
      if ((this.a.jdField_a_of_type_AndroidAppDialog != null) && (this.a.jdField_a_of_type_AndroidAppDialog.isShowing())) {
        this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
      }
      if (this.a.jdField_a_of_type_Boolean) {
        break;
      }
      axqw.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092EB", "0X80092EB", 0, 0, "", "", "", "");
      return;
      paramView = InterestSwitchEditActivity.a(this.a.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      this.a.startActivityForResult(paramView, 2);
    }
    axqw.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X80092E8", "0X80092E8", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     aogm
 * JD-Core Version:    0.7.0.1
 */
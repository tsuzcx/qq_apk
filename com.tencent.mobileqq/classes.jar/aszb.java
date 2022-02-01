import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendProfileEditFragment;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendProfileEditFragment.ExtendFriendInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aszb
  implements View.OnClickListener
{
  public aszb(ExtendFriendProfileEditFragment paramExtendFriendProfileEditFragment, ExtendFriendProfileEditFragment.ExtendFriendInfo paramExtendFriendInfo) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.getActivity() != null) {
      atcb.a(this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment.getActivity(), this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo.g, this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo.h, this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo.d, this.jdField_a_of_type_ComTencentMobileqqExtendfriendFragmentExtendFriendProfileEditFragment$ExtendFriendInfo.c);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aszb
 * JD-Core Version:    0.7.0.1
 */
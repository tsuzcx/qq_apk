package com.tencent.mobileqq.activity.contacts.alphabet;

import android.view.View;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class AlphabetFriendAdapter$6
  implements ActionSheet.OnButtonClickListener
{
  AlphabetFriendAdapter$6(AlphabetFriendAdapter paramAlphabetFriendAdapter, boolean paramBoolean, Friends paramFriends, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (!NetworkUtil.g(AlphabetFriendAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendAdapter))) {
      QQToast.a(AlphabetFriendAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendAdapter), 1, 2131692257, 0).a();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.superDismiss();
      return;
      paramView = (FriendListHandler)AlphabetFriendAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsAlphabetAlphabetFriendAdapter).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
      if (this.jdField_a_of_type_Boolean) {
        paramView.setSpecialCareSwitch(1, new String[] { this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin }, new boolean[] { false });
      } else {
        paramView.setSpecialCareSwitch(1, new String[] { this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin }, new boolean[] { true });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.alphabet.AlphabetFriendAdapter.6
 * JD-Core Version:    0.7.0.1
 */
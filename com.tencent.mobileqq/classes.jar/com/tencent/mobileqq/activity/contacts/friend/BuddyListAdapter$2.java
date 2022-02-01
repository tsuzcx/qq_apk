package com.tencent.mobileqq.activity.contacts.friend;

import android.view.View;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class BuddyListAdapter$2
  implements ActionSheet.OnButtonClickListener
{
  BuddyListAdapter$2(BuddyListAdapter paramBuddyListAdapter, boolean paramBoolean, Friends paramFriends, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (!NetworkUtil.g(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListAdapter.a)) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListAdapter.a, 1, 2131692257, 0).a();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.superDismiss();
      return;
      paramView = (FriendListHandler)BuddyListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListAdapter).getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
      if (this.jdField_a_of_type_Boolean)
      {
        paramView.setSpecialCareSwitch(1, new String[] { this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin }, new boolean[] { false });
        ReportController.b(BuddyListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListAdapter), "dc00898", "", "", "0X800808B", "0X800808B", 0, 0, "", "", "", "");
      }
      else
      {
        paramView.setSpecialCareSwitch(1, new String[] { this.jdField_a_of_type_ComTencentMobileqqDataFriends.uin }, new boolean[] { true });
        ReportController.b(BuddyListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqActivityContactsFriendBuddyListAdapter), "dc00898", "", "", "0X800808A", "0X800808A", 0, 0, "", "", "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.friend.BuddyListAdapter.2
 * JD-Core Version:    0.7.0.1
 */
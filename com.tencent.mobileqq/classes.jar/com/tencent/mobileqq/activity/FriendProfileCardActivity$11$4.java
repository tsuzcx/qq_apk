package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.av.utils.VideoActionSheet;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.rebuild.PlusPanelUtils;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.Arrays;

class FriendProfileCardActivity$11$4
  implements ActionSheet.OnButtonClickListener
{
  FriendProfileCardActivity$11$4(FriendProfileCardActivity.11 param11, int[] paramArrayOfInt, VideoActionSheet paramVideoActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    int i = this.jdField_a_of_type_ArrayOfInt[paramInt];
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "videoActionSheet onClick,showItems =  " + Arrays.toString(this.jdField_a_of_type_ArrayOfInt) + ",which = " + paramInt + ",item = " + i);
    }
    this.jdField_a_of_type_ComTencentAvUtilsVideoActionSheet.dismiss();
    switch (i)
    {
    default: 
      return;
    case 1: 
      FriendProfileCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity$11.a.app, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity$11.a, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity$11.a.a);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity$11.a.app, "CliOper", "", "", "0X8008405", "0X8008405", 0, 0, "", "", "", "");
      return;
    }
    paramView = new SessionInfo();
    paramView.jdField_a_of_type_Int = ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity$11.a.a.a);
    paramView.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity$11.a.a.a.jdField_a_of_type_JavaLangString;
    paramView.d = FriendProfileCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity$11.a.a, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity$11.a.app);
    paramView.b = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity$11.a.a.a.d;
    PlusPanelUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity$11.a.app, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity$11.a, paramView, false, null, null);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity$11.a.app, "CliOper", "", "", "0X80085D6", "0X80085D6", 9, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.11.4
 * JD-Core Version:    0.7.0.1
 */
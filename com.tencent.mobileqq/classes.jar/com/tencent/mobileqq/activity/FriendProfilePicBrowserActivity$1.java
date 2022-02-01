package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class FriendProfilePicBrowserActivity$1
  implements ActionSheet.OnButtonClickListener
{
  FriendProfilePicBrowserActivity$1(FriendProfilePicBrowserActivity paramFriendProfilePicBrowserActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if (paramInt != 4) {
              return;
            }
            FriendProfilePicBrowserActivity.e(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePicBrowserActivity);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePicBrowserActivity.app, "dc00898", "", "", "0X8007C15", "0X8007C15", 0, 0, "", "", "", "");
            return;
          }
          FriendProfilePicBrowserActivity.d(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePicBrowserActivity);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePicBrowserActivity.app, "dc00898", "", "", "0X800A8CD", "0X800A8CD", 0, 0, "1", "", "", "");
          return;
        }
        FriendProfilePicBrowserActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePicBrowserActivity);
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePicBrowserActivity.app, "dc00898", "", "", "0X8007C14", "0X8007C14", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePicBrowserActivity.a, 0, "", "", "", "");
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePicBrowserActivity.app, "dc00898", "", "", "0X800A8CC", "0X800A8CC", 0, 0, "1", "", "", "");
        return;
      }
      FriendProfilePicBrowserActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePicBrowserActivity);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePicBrowserActivity.app, "dc00898", "", "", "0X800A8CB", "0X800A8CB", 0, 0, "1", "", "", "");
      return;
    }
    FriendProfilePicBrowserActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePicBrowserActivity);
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePicBrowserActivity.app, "dc00898", "", "", "0X800A8CA", "0X800A8CA", 0, 0, "1", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfilePicBrowserActivity.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity;

import android.view.View;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class FriendProfileImageActivity$7
  implements ActionSheet.OnButtonClickListener
{
  FriendProfileImageActivity$7(FriendProfileImageActivity paramFriendProfileImageActivity, FriendProfileImageModel.ProfileImageInfo paramProfileImageInfo, boolean paramBoolean, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    QQAppInterface localQQAppInterface;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2)
        {
          if (paramInt != 3)
          {
            if ((paramInt == 4) && (!this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageActivity.b) && (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageActivity.jdField_a_of_type_Boolean)) {
              this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo);
            }
          }
          else
          {
            ProfileCardUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo.c, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageActivity);
            localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageActivity.app;
            if (this.jdField_a_of_type_Boolean) {
              paramView = "1";
            } else {
              paramView = "2";
            }
            ReportController.b(localQQAppInterface, "dc00898", "", "", "0X800A8CD", "0X800A8CD", 0, 0, paramView, "", "", "");
          }
        }
        else
        {
          FriendProfileImageActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageActivity, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo.c);
          localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageActivity.app;
          if (this.jdField_a_of_type_Boolean) {
            paramView = "1";
          } else {
            paramView = "2";
          }
          ReportController.b(localQQAppInterface, "dc00898", "", "", "0X800A8CC", "0X800A8CC", 0, 0, paramView, "", "", "");
        }
      }
      else
      {
        ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo.c, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageActivity);
        localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageActivity.app;
        if (this.jdField_a_of_type_Boolean) {
          paramView = "1";
        } else {
          paramView = "2";
        }
        ReportController.b(localQQAppInterface, "dc00898", "", "", "0X800A8CB", "0X800A8CB", 0, 0, paramView, "", "", "");
      }
    }
    else
    {
      ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageModel$ProfileImageInfo.c, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageActivity);
      localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageActivity.app;
      if (this.jdField_a_of_type_Boolean) {
        paramView = "1";
      } else {
        paramView = "2";
      }
      ReportController.b(localQQAppInterface, "dc00898", "", "", "0X800A8CA", "0X800A8CA", 0, 0, paramView, "", "", "");
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileImageActivity.7
 * JD-Core Version:    0.7.0.1
 */
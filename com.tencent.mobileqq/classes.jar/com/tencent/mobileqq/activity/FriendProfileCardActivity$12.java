package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.ProfileCardInfo;

final class FriendProfileCardActivity$12
  implements DialogInterface.OnClickListener
{
  FriendProfileCardActivity$12(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, ProfileCardInfo paramProfileCardInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    FriendProfileCardActivity.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.12
 * JD-Core Version:    0.7.0.1
 */
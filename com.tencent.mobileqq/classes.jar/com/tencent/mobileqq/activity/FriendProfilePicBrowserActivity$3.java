package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.utils.QQCustomDialog;

class FriendProfilePicBrowserActivity$3
  implements DialogInterface.OnClickListener
{
  FriendProfilePicBrowserActivity$3(FriendProfilePicBrowserActivity paramFriendProfilePicBrowserActivity, QQCustomDialog paramQQCustomDialog) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.dismiss();
    paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePicBrowserActivity.getIntent();
    paramDialogInterface.putExtra("delHead_fileid", FriendProfilePicBrowserActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePicBrowserActivity));
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePicBrowserActivity.setResult(-1, paramDialogInterface);
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfilePicBrowserActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfilePicBrowserActivity.3
 * JD-Core Version:    0.7.0.1
 */
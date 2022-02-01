package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.utils.DialogUtil;
import mqq.app.QQPermissionCallback;

class FriendProfileImageActivity$8
  implements QQPermissionCallback
{
  FriendProfileImageActivity$8(FriendProfileImageActivity paramFriendProfileImageActivity, String paramString) {}
  
  public void deny(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    DialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageActivity, paramArrayOfString, paramArrayOfInt);
  }
  
  public void grant(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    FriendProfileImageActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageActivity, this.jdField_a_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileImageActivity.8
 * JD-Core Version:    0.7.0.1
 */
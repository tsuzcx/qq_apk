package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profilecard.base.view.AbsProfileHeaderView;
import com.tencent.qphone.base.util.QLog;

class FriendProfileCardActivity$8
  extends AvatarObserver
{
  FriendProfileCardActivity$8(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void onUpdateCustomHead(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (paramString.equals(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.a)) && (this.a.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView != null)) {
      this.a.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.updateAvatar(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a);
    }
  }
  
  public void onUpdateMobileQQHead(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard", 2, "onUpdateMobileQQHead() mobileNumber = " + paramString);
    }
    if ((!paramBoolean) || (this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a == null)) {}
    String str;
    do
    {
      return;
      str = FriendProfileCardActivity.a(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a);
    } while ((str == null) || (!str.equals(paramString)) || (this.a.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView == null));
    this.a.jdField_a_of_type_ComTencentMobileqqProfilecardBaseViewAbsProfileHeaderView.updateAvatar(this.a.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a, 1, str, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.8
 * JD-Core Version:    0.7.0.1
 */
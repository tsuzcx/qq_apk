package com.tencent.mobileqq.activity;

import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.vas.PendantInfo;

class FriendProfileImageActivity$2$1
  implements Runnable
{
  FriendProfileImageActivity$2$1(FriendProfileImageActivity.2 param2, ExtensionInfo paramExtensionInfo) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageActivity$2.this$0.b.setVisibility(0);
    ((AvatarPendantManager)this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageActivity$2.this$0.app.getManager(QQManagerFactory.CHAT_AVATAR_PENDANT_MANAGER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageActivity$2.this$0.a).a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileImageActivity$2.this$0.b, 1, PendantInfo.d, this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.uin, this.jdField_a_of_type_ComTencentMobileqqDataExtensionInfo.pendantDiyId);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileImageActivity.2.1
 * JD-Core Version:    0.7.0.1
 */
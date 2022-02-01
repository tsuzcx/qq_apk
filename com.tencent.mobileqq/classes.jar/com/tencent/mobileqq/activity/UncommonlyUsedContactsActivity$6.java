package com.tencent.mobileqq.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.os.MqqHandler;

class UncommonlyUsedContactsActivity$6
  implements DialogInterface.OnClickListener
{
  UncommonlyUsedContactsActivity$6(UncommonlyUsedContactsActivity paramUncommonlyUsedContactsActivity, String paramString) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      ((FriendListHandler)this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).delFriend(this.jdField_a_of_type_JavaLangString, (byte)2);
      paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.app.getHandler(ChatActivity.class);
      if (paramDialogInterface != null) {
        paramDialogInterface.sendMessage(paramDialogInterface.obtainMessage(16711681, this.jdField_a_of_type_JavaLangString));
      }
      paramDialogInterface = this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.app.getHandler(ChatSettingActivity.class);
      if (paramDialogInterface != null) {
        paramDialogInterface.sendMessage(paramDialogInterface.obtainMessage(16711681, this.jdField_a_of_type_JavaLangString));
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityUncommonlyUsedContactsActivity.a(2131694476, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.UncommonlyUsedContactsActivity.6
 * JD-Core Version:    0.7.0.1
 */
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
      ((FriendListHandler)this.b.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).delFriend(this.a, (byte)2);
      paramDialogInterface = this.b.app.getHandler(ChatActivity.class);
      if (paramDialogInterface != null) {
        paramDialogInterface.sendMessage(paramDialogInterface.obtainMessage(16711681, this.a));
      }
      paramDialogInterface = this.b.app.getHandler(ChatSettingActivity.class);
      if (paramDialogInterface != null) {
        paramDialogInterface.sendMessage(paramDialogInterface.obtainMessage(16711681, this.a));
      }
    }
    else
    {
      this.b.a(2131892158, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.UncommonlyUsedContactsActivity.6
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity.contact.newfriend;

import android.app.Activity;
import com.tencent.mobileqq.activity.contact.addfriendverifi.NewFriendVerificationObserver;
import com.tencent.qphone.base.util.QLog;

class SystemMsgListView$6
  extends NewFriendVerificationObserver
{
  SystemMsgListView$6(SystemMsgListView paramSystemMsgListView) {}
  
  public void a(boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("NewFriendVerification.manager", 2, "ui.onRefreshBlockedEntrance");
    }
    if (((Activity)SystemMsgListView.a(this.a)).isFinishing()) {}
    while ((!paramBoolean) || (SystemMsgListView.a(this.a) == null)) {
      return;
    }
    SystemMsgListView.a(this.a).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.newfriend.SystemMsgListView.6
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

class AutoRemarkActivity$4
  implements Runnable
{
  AutoRemarkActivity$4(AutoRemarkActivity paramAutoRemarkActivity) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(this.this$0.b)) {
      return;
    }
    if (((FriendsManager)this.this$0.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).f(this.this$0.b) == null) {
      ((FriendListHandler)this.this$0.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendInfo(this.this$0.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AutoRemarkActivity.4
 * JD-Core Version:    0.7.0.1
 */
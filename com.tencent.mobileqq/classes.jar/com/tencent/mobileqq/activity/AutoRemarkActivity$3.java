package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;

class AutoRemarkActivity$3
  implements Runnable
{
  AutoRemarkActivity$3(AutoRemarkActivity paramAutoRemarkActivity) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(this.this$0.a)) {}
    while (((FriendsManager)this.this$0.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).a(this.this$0.a) != null) {
      return;
    }
    ((FriendListHandler)this.this$0.app.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER)).getFriendInfo(this.this$0.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AutoRemarkActivity.3
 * JD-Core Version:    0.7.0.1
 */
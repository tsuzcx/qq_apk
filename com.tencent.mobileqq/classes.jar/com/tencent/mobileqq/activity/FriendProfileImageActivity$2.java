package com.tencent.mobileqq.activity;

import aeqx;
import anyw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ExtensionInfo;
import mqq.os.MqqHandler;

class FriendProfileImageActivity$2
  implements Runnable
{
  FriendProfileImageActivity$2(FriendProfileImageActivity paramFriendProfileImageActivity) {}
  
  public void run()
  {
    ExtensionInfo localExtensionInfo = ((anyw)this.this$0.app.getManager(51)).a(this.this$0.a.b);
    if (localExtensionInfo != null) {
      ThreadManager.getUIHandler().post(new FriendProfileImageActivity.2.1(this, localExtensionInfo));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileImageActivity.2
 * JD-Core Version:    0.7.0.1
 */
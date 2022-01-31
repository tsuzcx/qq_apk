package com.tencent.mobileqq.activity;

import com.tencent.qphone.base.util.QLog;

class FriendProfileCardActivity$36
  implements Runnable
{
  FriendProfileCardActivity$36(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendProfileCardActivity", 2, "checkUpdateExtendInfo, requeset time out, start add friend :" + FriendProfileCardActivity.d(this.this$0));
    }
    if (!FriendProfileCardActivity.d(this.this$0))
    {
      FriendProfileCardActivity.a(this.this$0, true);
      FriendProfileCardActivity.b(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.36
 * JD-Core Version:    0.7.0.1
 */
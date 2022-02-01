package com.tencent.mobileqq.activity;

import azxr;
import com.tencent.qphone.base.util.QLog;

class FriendProfileCardActivity$3
  implements Runnable
{
  FriendProfileCardActivity$3(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void run()
  {
    try
    {
      FriendProfileCardActivity.a(this.this$0.app, this.this$0.a);
      FriendProfileCardActivity.a(this.this$0.a);
      if ((!ProfileActivity.AllInOne.b(this.this$0.a.a)) && (!ProfileActivity.AllInOne.i(this.this$0.a.a))) {
        this.this$0.a(false, true, null);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("FriendProfileCardActivity", 1, "doOnCreate inner init fail.", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.3
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity;

import awmk;

class FriendProfileCardActivity$6
  implements Runnable
{
  FriendProfileCardActivity$6(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void run()
  {
    try
    {
      FriendProfileCardActivity.a(this.this$0.app, this.this$0.a);
      FriendProfileCardActivity.b(this.this$0.a);
      if ((!ProfileActivity.AllInOne.b(this.this$0.a.a)) && (!ProfileActivity.AllInOne.i(this.this$0.a.a))) {
        this.this$0.a(false, true, null);
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.6
 * JD-Core Version:    0.7.0.1
 */
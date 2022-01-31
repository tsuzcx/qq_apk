package com.tencent.mobileqq.activity;

import auuw;

class FriendProfileCardActivity$5
  implements Runnable
{
  FriendProfileCardActivity$5(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileCardActivity.5
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.activity;

import alpk;
import alto;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;

class FriendProfileMoreInfoActivity$6
  implements Runnable
{
  FriendProfileMoreInfoActivity$6(FriendProfileMoreInfoActivity paramFriendProfileMoreInfoActivity) {}
  
  public void run()
  {
    Card localCard = ((alto)this.this$0.app.getManager(51)).c(this.this$0.app.getCurrentAccountUin());
    this.this$0.app.runOnUiThread(new FriendProfileMoreInfoActivity.6.1(this, localCard));
    this.this$0.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileMoreInfoActivity.6
 * JD-Core Version:    0.7.0.1
 */
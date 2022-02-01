package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.subaccount.SubAccountControll;

class Conversation$58
  implements Runnable
{
  Conversation$58(Conversation paramConversation) {}
  
  public void run()
  {
    if ((Conversation.b(this.this$0)) && (this.this$0.a.a != null) && (!this.this$0.a.a.b()) && (SubAccountControll.a(this.this$0.a(), "sub.uin.all"))) {
      this.this$0.b(new Conversation.58.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.58
 * JD-Core Version:    0.7.0.1
 */
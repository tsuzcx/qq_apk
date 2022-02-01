package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil;

class Conversation$59
  implements Runnable
{
  Conversation$59(Conversation paramConversation) {}
  
  public void run()
  {
    if ((Conversation.b(this.this$0)) && (this.this$0.a.a != null) && (!this.this$0.a.a.b()) && (((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).needShowHintDialog(this.this$0.a(), "sub.uin.all"))) {
      this.this$0.b(new Conversation.59.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.59
 * JD-Core Version:    0.7.0.1
 */
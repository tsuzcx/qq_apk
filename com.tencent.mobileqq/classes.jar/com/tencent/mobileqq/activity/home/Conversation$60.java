package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.activity.recent.DrawerFrame;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil;

class Conversation$60
  implements Runnable
{
  Conversation$60(Conversation paramConversation) {}
  
  public void run()
  {
    if ((Conversation.w(this.this$0)) && (this.this$0.Y.ah != null) && (!this.this$0.Y.ah.j()) && (((ISubAccountControllUtil)QRoute.api(ISubAccountControllUtil.class)).needShowHintDialog(this.this$0.s(), "sub.uin.all"))) {
      this.this$0.b(new Conversation.60.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.60
 * JD-Core Version:    0.7.0.1
 */
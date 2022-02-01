package com.tencent.mobileqq.activity.home;

import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;

class Conversation$3
  implements Runnable
{
  Conversation$3(Conversation paramConversation) {}
  
  public void run()
  {
    if (Conversation.a(this.this$0) != null) {
      Conversation.a(this.this$0).scrollTo(0, -ScreenUtil.dip2px(50.0F));
    }
    if (this.this$0.a != null)
    {
      this.this$0.a.a(0L);
      Conversation localConversation = this.this$0;
      localConversation.onViewCompleteVisableAndReleased(0, localConversation.a, Conversation.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.3
 * JD-Core Version:    0.7.0.1
 */
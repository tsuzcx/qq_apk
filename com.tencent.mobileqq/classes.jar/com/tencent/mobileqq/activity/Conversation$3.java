package com.tencent.mobileqq.activity;

import bdep;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.widget.PullRefreshHeader;

class Conversation$3
  implements Runnable
{
  Conversation$3(Conversation paramConversation) {}
  
  public void run()
  {
    if (Conversation.a(this.this$0) != null) {
      Conversation.a(this.this$0).scrollTo(0, -bdep.a(50.0F));
    }
    if (this.this$0.a != null)
    {
      this.this$0.a.a(0L);
      this.this$0.a(0, this.this$0.a, Conversation.a(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.3
 * JD-Core Version:    0.7.0.1
 */
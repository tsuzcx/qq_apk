package com.tencent.mobileqq.activity.home;

import android.view.View;
import com.tencent.mobileqq.fpsreport.FPSSwipListView;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.widget.IPullRefreshHeaderControl;

class Conversation$4
  implements Runnable
{
  Conversation$4(Conversation paramConversation) {}
  
  public void run()
  {
    if (Conversation.i(this.this$0) != null) {
      Conversation.i(this.this$0).scrollTo(0, -ScreenUtil.dip2px(50.0F));
    }
    if (this.this$0.x != null)
    {
      this.this$0.x.a(0L);
      Conversation localConversation = this.this$0;
      localConversation.onViewCompleteVisableAndReleased(0, (View)localConversation.x, Conversation.i(this.this$0));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.home.Conversation.4
 * JD-Core Version:    0.7.0.1
 */
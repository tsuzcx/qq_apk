package com.tencent.mobileqq.activity;

import android.view.View;
import android.widget.TextView;
import com.tencent.widget.RedWidgetUtil;

class ConversationQbossBannerTitleEntranceCtrl$2$1
  implements Runnable
{
  ConversationQbossBannerTitleEntranceCtrl$2$1(ConversationQbossBannerTitleEntranceCtrl.2 param2, int paramInt, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.a > 0)
    {
      if (ConversationQbossBannerTitleEntranceCtrl.a(this.c.this$0) != null)
      {
        if (this.a > 99)
        {
          ConversationQbossBannerTitleEntranceCtrl.a(this.c.this$0).setText("99+");
        }
        else
        {
          TextView localTextView = ConversationQbossBannerTitleEntranceCtrl.a(this.c.this$0);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(this.a);
          localTextView.setText(localStringBuilder.toString());
        }
        RedWidgetUtil.fixTextViewLayout(ConversationQbossBannerTitleEntranceCtrl.a(this.c.this$0), this.a, 99, 2130852592);
        ConversationQbossBannerTitleEntranceCtrl.a(this.c.this$0).setVisibility(0);
      }
      if (ConversationQbossBannerTitleEntranceCtrl.b(this.c.this$0) != null) {
        ConversationQbossBannerTitleEntranceCtrl.b(this.c.this$0).setVisibility(8);
      }
    }
    else if (this.b)
    {
      if (ConversationQbossBannerTitleEntranceCtrl.b(this.c.this$0) != null) {
        ConversationQbossBannerTitleEntranceCtrl.b(this.c.this$0).setVisibility(0);
      }
      if (ConversationQbossBannerTitleEntranceCtrl.a(this.c.this$0) != null) {
        ConversationQbossBannerTitleEntranceCtrl.a(this.c.this$0).setVisibility(8);
      }
    }
    else
    {
      if (ConversationQbossBannerTitleEntranceCtrl.b(this.c.this$0) != null) {
        ConversationQbossBannerTitleEntranceCtrl.b(this.c.this$0).setVisibility(8);
      }
      if (ConversationQbossBannerTitleEntranceCtrl.a(this.c.this$0) != null) {
        ConversationQbossBannerTitleEntranceCtrl.a(this.c.this$0).setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ConversationQbossBannerTitleEntranceCtrl.2.1
 * JD-Core Version:    0.7.0.1
 */
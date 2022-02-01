package com.tencent.mobileqq.apollo.aio.panel;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import java.util.concurrent.atomic.AtomicInteger;

class ApolloPanel$25
  implements Runnable
{
  ApolloPanel$25(ApolloPanel paramApolloPanel) {}
  
  public void run()
  {
    if (ApolloPanel.a(this.this$0) != null)
    {
      if (ApolloPanel.a(this.this$0).a == null) {
        return;
      }
      ApolloPanel.b(this.this$0).setVisibility(8);
      int i;
      if (ApolloPanel.a(this.this$0) != null) {
        i = ApolloPanel.a(this.this$0).a.get();
      } else {
        i = 0;
      }
      if (i > 0) {
        ApolloPanel.b(this.this$0).setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanel.25
 * JD-Core Version:    0.7.0.1
 */
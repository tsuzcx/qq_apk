package com.tencent.mobileqq.apollo.aio.panel;

import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import java.util.concurrent.atomic.AtomicInteger;

class ApolloPanel$20
  implements Runnable
{
  ApolloPanel$20(ApolloPanel paramApolloPanel) {}
  
  public void run()
  {
    if (ApolloPanel.g(this.this$0) != null)
    {
      if (ApolloPanel.g(this.this$0).d == null) {
        return;
      }
      ApolloPanel.C(this.this$0).setVisibility(8);
      int i;
      if (ApolloPanel.F(this.this$0) != null) {
        i = ApolloPanel.F(this.this$0).c.get();
      } else {
        i = 0;
      }
      if (i > 0) {
        ApolloPanel.B(this.this$0).setVisibility(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanel.20
 * JD-Core Version:    0.7.0.1
 */
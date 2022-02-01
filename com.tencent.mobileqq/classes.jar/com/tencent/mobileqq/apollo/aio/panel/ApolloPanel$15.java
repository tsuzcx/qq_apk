package com.tencent.mobileqq.apollo.aio.panel;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.widget.QQToast;

class ApolloPanel$15
  implements Runnable
{
  ApolloPanel$15(ApolloPanel paramApolloPanel, String paramString, int paramInt) {}
  
  public void run()
  {
    if ((ApolloPanel.g(this.this$0) != null) && (ApolloPanel.g(this.this$0).e != null)) {
      QQToast.makeText(ApolloPanel.g(this.this$0).e, 2, this.a, 1).show(this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanel.15
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.apollo.aio.panel;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;

class ApolloPanel$25$1
  implements Runnable
{
  ApolloPanel$25$1(ApolloPanel.25 param25) {}
  
  public void run()
  {
    if ((ApolloPanel.g(this.a.a) != null) && (ApolloPanel.g(this.a.a).d != null))
    {
      ApolloPanel.b(this.a.a, true);
      this.a.a.b(ApolloPanel.g(this.a.a).d.getCurrentUin());
      ApolloPanel.b(this.a.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanel.25.1
 * JD-Core Version:    0.7.0.1
 */
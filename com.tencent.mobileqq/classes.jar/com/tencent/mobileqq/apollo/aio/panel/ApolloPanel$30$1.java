package com.tencent.mobileqq.apollo.aio.panel;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;

class ApolloPanel$30$1
  implements Runnable
{
  ApolloPanel$30$1(ApolloPanel.30 param30) {}
  
  public void run()
  {
    if ((ApolloPanel.a(this.a.a) != null) && (ApolloPanel.a(this.a.a).a != null))
    {
      ApolloPanel.b(this.a.a, true);
      this.a.a.b(ApolloPanel.a(this.a.a).a.getCurrentUin());
      ApolloPanel.b(this.a.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanel.30.1
 * JD-Core Version:    0.7.0.1
 */
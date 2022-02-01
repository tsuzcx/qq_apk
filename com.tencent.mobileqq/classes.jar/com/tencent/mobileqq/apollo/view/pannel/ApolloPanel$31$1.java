package com.tencent.mobileqq.apollo.view.pannel;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;

class ApolloPanel$31$1
  implements Runnable
{
  ApolloPanel$31$1(ApolloPanel.31 param31) {}
  
  public void run()
  {
    if ((this.a.a.a != null) && (this.a.a.a.a != null))
    {
      ApolloPanel.b(this.a.a, true);
      this.a.a.b(this.a.a.a.a.getCurrentUin());
      ApolloPanel.b(this.a.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloPanel.31.1
 * JD-Core Version:    0.7.0.1
 */
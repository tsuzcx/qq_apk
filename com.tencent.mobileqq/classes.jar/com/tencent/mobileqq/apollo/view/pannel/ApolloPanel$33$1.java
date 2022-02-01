package com.tencent.mobileqq.apollo.view.pannel;

import anov;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;

public class ApolloPanel$33$1
  implements Runnable
{
  public ApolloPanel$33$1(anov paramanov) {}
  
  public void run()
  {
    if ((this.a.a.a != null) && (this.a.a.a.app != null))
    {
      ApolloPanel.b(this.a.a, true);
      this.a.a.b(this.a.a.a.app.getCurrentUin());
      ApolloPanel.b(this.a.a, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloPanel.33.1
 * JD-Core Version:    0.7.0.1
 */
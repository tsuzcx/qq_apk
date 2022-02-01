package com.tencent.mobileqq.apollo.view.pannel;

import amme;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ApolloActionData;

class ApolloLinearLayout$1
  implements Runnable
{
  ApolloLinearLayout$1(ApolloLinearLayout paramApolloLinearLayout, ApolloActionData paramApolloActionData) {}
  
  public void run()
  {
    if ((this.this$0.a == null) || (this.this$0.a.app == null)) {
      return;
    }
    ((amme)this.this$0.a.app.getManager(QQManagerFactory.APOLLO_MANAGER)).a(this.a, 4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloLinearLayout.1
 * JD-Core Version:    0.7.0.1
 */
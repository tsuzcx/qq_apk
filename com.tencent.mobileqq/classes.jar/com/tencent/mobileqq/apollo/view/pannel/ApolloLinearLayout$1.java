package com.tencent.mobileqq.apollo.view.pannel;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.model.ApolloActionData;
import com.tencent.mobileqq.app.QQAppInterface;

class ApolloLinearLayout$1
  implements Runnable
{
  ApolloLinearLayout$1(ApolloLinearLayout paramApolloLinearLayout, ApolloActionData paramApolloActionData) {}
  
  public void run()
  {
    if ((this.this$0.a == null) || (this.this$0.a.a == null)) {
      return;
    }
    ((ApolloManagerServiceImpl)this.this$0.a.a().getRuntimeService(IApolloManagerService.class, "all")).downloadApolloRes(this.a, 4, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloLinearLayout.1
 * JD-Core Version:    0.7.0.1
 */
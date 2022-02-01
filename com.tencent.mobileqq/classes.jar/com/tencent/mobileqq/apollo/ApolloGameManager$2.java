package com.tencent.mobileqq.apollo;

import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.app.QQAppInterface;

class ApolloGameManager$2
  implements Runnable
{
  public void run()
  {
    if (ApolloGameManager.a(this.this$0) != null) {
      ((ApolloManagerServiceImpl)ApolloGameManager.a(this.this$0).getRuntimeService(IApolloManagerService.class, "all")).onAddOrDelGame();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloGameManager.2
 * JD-Core Version:    0.7.0.1
 */
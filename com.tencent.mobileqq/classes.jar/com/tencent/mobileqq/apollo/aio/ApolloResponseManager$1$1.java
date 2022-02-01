package com.tencent.mobileqq.apollo.aio;

import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;

class ApolloResponseManager$1$1
  implements Runnable
{
  ApolloResponseManager$1$1(ApolloResponseManager.1 param1, IApolloResManager paramIApolloResManager, ApolloActionData paramApolloActionData) {}
  
  public void run()
  {
    if (ApolloResponseManager.a(this.c.a) == null) {
      return;
    }
    this.a.a(this.b, 4, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.ApolloResponseManager.1.1
 * JD-Core Version:    0.7.0.1
 */
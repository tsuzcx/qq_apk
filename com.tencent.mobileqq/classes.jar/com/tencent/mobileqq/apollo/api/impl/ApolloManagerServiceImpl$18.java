package com.tencent.mobileqq.apollo.api.impl;

import com.tencent.mobileqq.DrawerPushItem;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.List;

class ApolloManagerServiceImpl$18
  implements Runnable
{
  ApolloManagerServiceImpl$18(ApolloManagerServiceImpl paramApolloManagerServiceImpl, DrawerPushItem paramDrawerPushItem) {}
  
  public void run()
  {
    if (this.a == null) {
      return;
    }
    synchronized (ApolloManagerServiceImpl.access$1200(this.this$0))
    {
      if ((ApolloManagerServiceImpl.access$1300(this.this$0) != null) && (this.a != null) && (ApolloManagerServiceImpl.access$1300(this.this$0).contains(this.a))) {
        ApolloManagerServiceImpl.access$1300(this.this$0).remove(this.a);
      }
      EntityManager localEntityManager = ApolloManagerServiceImpl.access$1400(this.this$0);
      if (localEntityManager != null)
      {
        localEntityManager.remove(this.a);
        localEntityManager.close();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl.18
 * JD-Core Version:    0.7.0.1
 */
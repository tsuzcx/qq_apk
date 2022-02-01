package com.tencent.mobileqq.apollo.aio.panel;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.model.ApolloActionPackage;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import java.util.Iterator;
import java.util.List;

class ApolloPanel$8
  implements Runnable
{
  ApolloPanel$8(ApolloPanel paramApolloPanel, List paramList) {}
  
  public void run()
  {
    if ((ApolloPanel.g(this.this$0) != null) && (ApolloPanel.g(this.this$0).d != null))
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        ApolloActionPackage localApolloActionPackage = (ApolloActionPackage)localIterator.next();
        ApolloPanel.q(this.this$0).updatePackage(localApolloActionPackage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanel.8
 * JD-Core Version:    0.7.0.1
 */
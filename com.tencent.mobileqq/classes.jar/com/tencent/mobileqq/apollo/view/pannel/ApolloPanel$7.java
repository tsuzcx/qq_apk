package com.tencent.mobileqq.apollo.view.pannel;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.api.data.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.model.ApolloActionPackage;
import java.util.Iterator;
import java.util.List;

class ApolloPanel$7
  implements Runnable
{
  ApolloPanel$7(ApolloPanel paramApolloPanel, List paramList) {}
  
  public void run()
  {
    if ((this.this$0.a != null) && (this.this$0.a.a != null))
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        ApolloActionPackage localApolloActionPackage = (ApolloActionPackage)localIterator.next();
        ApolloPanel.a(this.this$0).updatePackage(localApolloActionPackage);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloPanel.7
 * JD-Core Version:    0.7.0.1
 */
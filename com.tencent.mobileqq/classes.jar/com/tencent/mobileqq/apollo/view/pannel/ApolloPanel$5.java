package com.tencent.mobileqq.apollo.view.pannel;

import ankc;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ApolloActionPackage;
import java.util.Iterator;
import java.util.List;

class ApolloPanel$5
  implements Runnable
{
  ApolloPanel$5(ApolloPanel paramApolloPanel, List paramList) {}
  
  public void run()
  {
    if ((this.this$0.a != null) && (this.this$0.a.app != null))
    {
      ankc localankc = (ankc)this.this$0.a.app.getManager(QQManagerFactory.APOOLO_DAO_MANAGER);
      if (localankc != null)
      {
        Iterator localIterator = this.a.iterator();
        while (localIterator.hasNext()) {
          localankc.a((ApolloActionPackage)localIterator.next());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloPanel.5
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.apollo.view;

import annx;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionPackage;
import java.util.Iterator;
import java.util.List;

class ApolloPanel$4
  implements Runnable
{
  ApolloPanel$4(ApolloPanel paramApolloPanel, List paramList) {}
  
  public void run()
  {
    if ((this.this$0.a != null) && (this.this$0.a.a != null))
    {
      annx localannx = (annx)this.this$0.a.a.getManager(155);
      if (localannx != null)
      {
        Iterator localIterator = this.a.iterator();
        while (localIterator.hasNext()) {
          localannx.a((ApolloActionPackage)localIterator.next());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloPanel.4
 * JD-Core Version:    0.7.0.1
 */
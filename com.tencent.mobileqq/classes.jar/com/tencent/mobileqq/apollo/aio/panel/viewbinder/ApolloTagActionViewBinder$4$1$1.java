package com.tencent.mobileqq.apollo.aio.panel.viewbinder;

import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class ApolloTagActionViewBinder$4$1$1
  implements Runnable
{
  ApolloTagActionViewBinder$4$1$1(ApolloTagActionViewBinder.4.1 param1, List paramList) {}
  
  public void run()
  {
    try
    {
      ApolloTagActionViewBinder.c(this.b.a.this$0, this.a);
      ArrayList localArrayList = new ArrayList();
      if ((ApolloTagActionViewBinder.f(this.b.a.this$0) != null) && (ApolloTagActionViewBinder.e(this.b.a.this$0) != null) && (ApolloTagActionViewBinder.e(this.b.a.this$0).size() > 0))
      {
        Iterator localIterator = ApolloTagActionViewBinder.e(this.b.a.this$0).iterator();
        while (localIterator.hasNext())
        {
          ApolloInfo localApolloInfo = (ApolloInfo)localIterator.next();
          if ((localApolloInfo != null) && (ApolloTagActionViewBinder.f(this.b.a.this$0).contains(Integer.valueOf(localApolloInfo.mAction.actionId)))) {
            localArrayList.add(localApolloInfo);
          }
        }
      }
      if (ApolloTagActionViewBinder.g(this.b.a.this$0) != null) {
        ApolloTagActionViewBinder.g(this.b.a.this$0).put(this.b.a.a, localArrayList);
      }
      ApolloTagActionViewBinder.b(this.b.a.this$0, localArrayList);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("[cmshow]ApolloActionWithTagsViewBinder", 1, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloTagActionViewBinder.4.1.1
 * JD-Core Version:    0.7.0.1
 */
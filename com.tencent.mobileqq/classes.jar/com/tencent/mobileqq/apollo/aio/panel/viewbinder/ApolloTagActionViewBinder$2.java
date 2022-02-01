package com.tencent.mobileqq.apollo.aio.panel.viewbinder;

import com.tencent.mobileqq.apollo.model.ApolloTagButtonData;
import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

class ApolloTagActionViewBinder$2
  implements Runnable
{
  ApolloTagActionViewBinder$2(ApolloTagActionViewBinder paramApolloTagActionViewBinder) {}
  
  public void run()
  {
    try
    {
      Iterator localIterator = ApolloTagActionViewBinder.b(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        ApolloTagButtonData localApolloTagButtonData = (ApolloTagButtonData)localIterator.next();
        if (localApolloTagButtonData != null) {
          localApolloTagButtonData.isSelected = false;
        }
      }
      ApolloDtReportUtil.a.remove(Integer.valueOf(this.this$0.n));
      if (ApolloTagActionViewBinder.c(this.this$0) != null) {
        ApolloTagActionViewBinder.c(this.this$0).notifyDataSetChanged();
      }
      ApolloTagActionViewBinder.b(this.this$0, ApolloTagActionViewBinder.e(this.this$0));
      return;
    }
    catch (Exception localException)
    {
      QLog.e("[cmshow]ApolloActionWithTagsViewBinder", 1, localException, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloTagActionViewBinder.2
 * JD-Core Version:    0.7.0.1
 */
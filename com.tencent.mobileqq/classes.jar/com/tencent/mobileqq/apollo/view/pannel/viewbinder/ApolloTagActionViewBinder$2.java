package com.tencent.mobileqq.apollo.view.pannel.viewbinder;

import com.tencent.mobileqq.apollo.statistics.product.ApolloDtReportUtil;
import com.tencent.mobileqq.data.ApolloTagButtonData;
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
    do
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
        ApolloDtReportUtil.a.remove(Integer.valueOf(this.this$0.d));
      }
      catch (Exception localException)
      {
        QLog.e("ApolloActionWithTagsViewBinder", 1, localException, new Object[0]);
        return;
      }
    } while (ApolloTagActionViewBinder.a(this.this$0) == null);
    ApolloTagActionViewBinder.a(this.this$0).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.viewbinder.ApolloTagActionViewBinder.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.apollo.aio.panel;

import com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloViewBinder;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

class ApolloPanel$FrameCallback$1
  implements Runnable
{
  ApolloPanel$FrameCallback$1(ApolloPanel.FrameCallback paramFrameCallback) {}
  
  public void run()
  {
    if (ApolloPanel.FrameCallback.a(this.this$0) != null)
    {
      if (ApolloPanel.FrameCallback.a(this.this$0).size() == 0) {
        return;
      }
      Iterator localIterator = ApolloPanel.FrameCallback.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        ApolloViewBinder localApolloViewBinder = (ApolloViewBinder)localIterator.next();
        if ((localApolloViewBinder != null) && ((localApolloViewBinder.d == 9) || (localApolloViewBinder.d == 8)) && (localApolloViewBinder.a() != null))
        {
          QLog.d("[cmshow]ApolloPanel", 1, "ApolloPanel handleCMSPlayerGetFrame notifyDataSetChanged");
          localApolloViewBinder.a().notifyDataSetChanged();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanel.FrameCallback.1
 * JD-Core Version:    0.7.0.1
 */
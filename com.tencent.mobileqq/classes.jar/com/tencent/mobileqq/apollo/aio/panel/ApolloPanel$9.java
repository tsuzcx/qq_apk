package com.tencent.mobileqq.apollo.aio.panel;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloRecentViewBinder;
import com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloViewBinder;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class ApolloPanel$9
  implements Runnable
{
  ApolloPanel$9(ApolloPanel paramApolloPanel) {}
  
  public void run()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("func updateLastApolloPanel begins. Thread id = ");
      ((StringBuilder)localObject).append(Thread.currentThread().getId());
      QLog.d("[cmshow]ApolloPanel", 2, ((StringBuilder)localObject).toString());
    }
    if (ApolloPanel.r(this.this$0).size() == 0) {
      return;
    }
    Object localObject = (ApolloViewBinder)ApolloPanel.r(this.this$0).get(0);
    if ((ApolloPanel.g(this.this$0) != null) && ((localObject instanceof ApolloRecentViewBinder)))
    {
      if (((ApolloViewBinder)localObject).k == 2) {
        ((ApolloViewBinder)localObject).k = 0;
      }
      ((ApolloRecentViewBinder)localObject).a(ApolloPanel.g(this.this$0).d, ApolloPanel.o(this.this$0));
      this.this$0.h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanel.9
 * JD-Core Version:    0.7.0.1
 */
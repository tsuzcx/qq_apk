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
    if (ApolloPanel.b(this.this$0).size() == 0) {
      return;
    }
    Object localObject = (ApolloViewBinder)ApolloPanel.b(this.this$0).get(0);
    if ((ApolloPanel.a(this.this$0) != null) && ((localObject instanceof ApolloRecentViewBinder)))
    {
      if (((ApolloViewBinder)localObject).b == 2) {
        ((ApolloViewBinder)localObject).b = 0;
      }
      ((ApolloRecentViewBinder)localObject).a(ApolloPanel.a(this.this$0).a, ApolloPanel.a(this.this$0));
      this.this$0.h();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanel.9
 * JD-Core Version:    0.7.0.1
 */
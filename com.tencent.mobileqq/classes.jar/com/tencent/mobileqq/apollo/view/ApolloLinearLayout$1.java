package com.tencent.mobileqq.apollo.view;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.cmshow.engine.resource.IApolloResManager;
import com.tencent.qphone.base.util.QLog;

class ApolloLinearLayout$1
  implements Runnable
{
  ApolloLinearLayout$1(ApolloLinearLayout paramApolloLinearLayout, ApolloActionData paramApolloActionData) {}
  
  public void run()
  {
    if (ApolloLinearLayout.d(this.this$0) != null)
    {
      if (ApolloLinearLayout.d(this.this$0).d == null) {
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("downloadApolloRes : ");
      localStringBuilder.append(this.a.actionId);
      QLog.e("cm_res", 1, localStringBuilder.toString());
      this.this$0.b.a(this.a, 4, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloLinearLayout.1
 * JD-Core Version:    0.7.0.1
 */
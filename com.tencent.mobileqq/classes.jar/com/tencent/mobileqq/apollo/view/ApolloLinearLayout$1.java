package com.tencent.mobileqq.apollo.view;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.res.api.IApolloResManager;
import com.tencent.mobileqq.apollo.res.api.impl.ApolloResManagerImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

class ApolloLinearLayout$1
  implements Runnable
{
  ApolloLinearLayout$1(ApolloLinearLayout paramApolloLinearLayout, ApolloActionData paramApolloActionData) {}
  
  public void run()
  {
    if (ApolloLinearLayout.a(this.this$0) != null)
    {
      if (ApolloLinearLayout.a(this.this$0).a == null) {
        return;
      }
      ApolloResManagerImpl localApolloResManagerImpl = (ApolloResManagerImpl)ApolloLinearLayout.a(this.this$0).a.getRuntimeService(IApolloResManager.class, "all");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("downloadApolloRes : ");
      localStringBuilder.append(this.a.actionId);
      QLog.e("cm_res", 1, localStringBuilder.toString());
      localApolloResManagerImpl.downloadApolloRes(this.a, 4, null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloLinearLayout.1
 * JD-Core Version:    0.7.0.1
 */
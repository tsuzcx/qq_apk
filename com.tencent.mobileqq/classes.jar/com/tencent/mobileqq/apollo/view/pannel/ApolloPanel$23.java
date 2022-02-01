package com.tencent.mobileqq.apollo.view.pannel;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.api.data.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.model.ApolloActionPackage;
import com.tencent.qphone.base.util.QLog;

class ApolloPanel$23
  implements Runnable
{
  ApolloPanel$23(ApolloPanel paramApolloPanel, ApolloActionPackage paramApolloActionPackage) {}
  
  public void run()
  {
    QLog.d("ApolloPanel", 2, "[checkRedTab] clear new action info");
    if ((this.this$0.a != null) && (this.this$0.a.a != null)) {
      ApolloPanel.a(this.this$0).updatePackage(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloPanel.23
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.apollo.aio.panel;

import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.model.ApolloActionPackage;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.qphone.base.util.QLog;

class ApolloPanel$17
  implements Runnable
{
  ApolloPanel$17(ApolloPanel paramApolloPanel, ApolloActionPackage paramApolloActionPackage) {}
  
  public void run()
  {
    QLog.d("[cmshow]ApolloPanel", 2, "[checkRedTab] clear new action info");
    if ((ApolloPanel.g(this.this$0) != null) && (ApolloPanel.g(this.this$0).d != null)) {
      ApolloPanel.q(this.this$0).updatePackage(this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanel.17
 * JD-Core Version:    0.7.0.1
 */
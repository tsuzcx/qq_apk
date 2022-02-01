package com.tencent.mobileqq.apollo.view.pannel;

import ankc;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.ApolloActionPackage;
import com.tencent.qphone.base.util.QLog;

class ApolloPanel$23
  implements Runnable
{
  ApolloPanel$23(ApolloPanel paramApolloPanel, ApolloActionPackage paramApolloActionPackage) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "[checkRedTab] clear new action info");
    }
    if ((this.this$0.a != null) && (this.this$0.a.app != null))
    {
      ankc localankc = (ankc)this.this$0.a.app.getManager(QQManagerFactory.APOOLO_DAO_MANAGER);
      if (localankc != null) {
        localankc.a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloPanel.23
 * JD-Core Version:    0.7.0.1
 */
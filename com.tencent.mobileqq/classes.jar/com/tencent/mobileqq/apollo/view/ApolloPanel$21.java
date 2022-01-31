package com.tencent.mobileqq.apollo.view;

import aliw;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloActionPackage;
import com.tencent.qphone.base.util.QLog;

class ApolloPanel$21
  implements Runnable
{
  ApolloPanel$21(ApolloPanel paramApolloPanel, ApolloActionPackage paramApolloActionPackage) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ApolloPanel", 2, "[checkRedTab] clear new action info");
    }
    if ((this.this$0.a != null) && (this.this$0.a.a != null))
    {
      aliw localaliw = (aliw)this.this$0.a.a.getManager(155);
      if (localaliw != null) {
        localaliw.a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.ApolloPanel.21
 * JD-Core Version:    0.7.0.1
 */
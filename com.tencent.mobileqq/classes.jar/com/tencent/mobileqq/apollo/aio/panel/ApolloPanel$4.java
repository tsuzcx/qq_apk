package com.tencent.mobileqq.apollo.aio.panel;

import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloSecondaryViewBinder;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.utils.IResDownloadListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.os.MqqHandler;

class ApolloPanel$4
  extends IResDownloadListener
{
  ApolloPanel$4(ApolloPanel paramApolloPanel) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]ApolloPanel", 2, "tab download Done");
    }
    ApolloPanel.j(this.a);
  }
  
  public void a(ApolloActionData paramApolloActionData)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("action res done. action=");
    localStringBuilder.append(paramApolloActionData.actionId);
    QLog.e("[cmshow]ApolloPanel", 1, localStringBuilder.toString());
    this.a.b(paramApolloActionData);
    if (ApolloPanel.k(this.a) != null) {
      ApolloPanel.k(this.a).a(paramApolloActionData);
    }
  }
  
  public void a(Boolean paramBoolean)
  {
    if (ApolloPanel.g(this.a) != null)
    {
      if (ApolloPanel.g(this.a).d == null) {
        return;
      }
      MqqHandler localMqqHandler = ApolloPanel.g(this.a).d.getHandler(ChatActivity.class);
      if (localMqqHandler == null) {
        return;
      }
      localMqqHandler.post(new ApolloPanel.4.1(this));
      if (paramBoolean.booleanValue())
      {
        paramBoolean = this.a;
        paramBoolean.a(ApolloPanel.g(paramBoolean).d.getCurrentAccountUin());
        ApolloPanel.m(this.a).clear();
        paramBoolean = this.a;
        paramBoolean.b(paramBoolean.c(ApolloPanel.a));
        return;
      }
      if ((ApolloPanel.n(this.a) != null) && (ApolloPanel.n(this.a).k == 3))
      {
        if (QLog.isColorLevel()) {
          QLog.d("[cmshow]ApolloPanel", 2, "onJsonDone in panel fail refresh panel");
        }
        localMqqHandler.post(new ApolloPanel.4.2(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanel.4
 * JD-Core Version:    0.7.0.1
 */
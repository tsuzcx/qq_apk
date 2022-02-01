package com.tencent.mobileqq.apollo.aio.panel;

import com.tencent.mobileqq.apollo.listener.ApolloRspCallback;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.Nullable;

class ApolloPanel$10
  implements ApolloRspCallback
{
  ApolloPanel$10(ApolloPanel paramApolloPanel, int paramInt) {}
  
  public void a(boolean paramBoolean, long paramLong, @Nullable String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onOpen cmshow apolloStatus ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(" succ ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" retCode ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" errMsg ");
    localStringBuilder.append(paramString);
    QLog.i("[cmshow]ApolloPanel", 1, localStringBuilder.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanel.10
 * JD-Core Version:    0.7.0.1
 */
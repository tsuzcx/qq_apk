package com.tencent.mobileqq.apollo.api.impl;

import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.utils.SendMessageHandler;
import com.tencent.qphone.base.util.QLog;

class ApolloManagerServiceImpl$1
  extends MessageObserver
{
  ApolloManagerServiceImpl$1(ApolloManagerServiceImpl paramApolloManagerServiceImpl) {}
  
  protected void onSendResult(boolean paramBoolean, String paramString, long paramLong)
  {
    ApolloManagerServiceImpl.access$100(this.a, paramBoolean, paramString, paramLong);
    super.onSendResult(paramBoolean, paramString, paramLong);
  }
  
  protected void onUpdateSendMsgError(String paramString1, int paramInt1, int paramInt2, SendMessageHandler paramSendMessageHandler, long paramLong1, long paramLong2, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onUpdateSendMsgError: ");
    localStringBuilder.append(paramString2);
    QLog.d("[cmshow]ApolloManager", 1, localStringBuilder.toString());
    ApolloManagerServiceImpl.access$100(this.a, false, paramString1, paramLong2);
    super.onUpdateSendMsgError(paramString1, paramInt1, paramInt2, paramSendMessageHandler, paramLong1, paramLong2, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */
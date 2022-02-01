package com.tencent.mobileqq.apollo.aio.panel;

import com.tencent.mobileqq.apollo.listener.ApolloStatusUpdateListener;
import com.tencent.qphone.base.util.QLog;

class ApolloPanel$30
  implements ApolloStatusUpdateListener
{
  ApolloPanel$30(ApolloPanel paramApolloPanel) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onStatusUpdate, currentStatus=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("， is3dAvailable=");
    localStringBuilder.append(paramBoolean);
    QLog.d("[cmshow]ApolloPanel", 2, localStringBuilder.toString());
    this.a.post(new ApolloPanel.30.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanel.30
 * JD-Core Version:    0.7.0.1
 */
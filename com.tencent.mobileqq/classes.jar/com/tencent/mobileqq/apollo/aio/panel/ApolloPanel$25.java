package com.tencent.mobileqq.apollo.aio.panel;

import com.tencent.mobileqq.apollo.listener.ApolloStatusUpdateListener;
import com.tencent.qphone.base.util.QLog;

class ApolloPanel$25
  implements ApolloStatusUpdateListener
{
  ApolloPanel$25(ApolloPanel paramApolloPanel) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onStatusUpdate, currentStatus=");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("， is3dAvailable=");
    localStringBuilder.append(paramBoolean);
    QLog.d("[cmshow]ApolloPanel", 2, localStringBuilder.toString());
    this.a.post(new ApolloPanel.25.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloPanel.25
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.apollo.view.pannel;

import com.tencent.mobileqq.apollo.api.impl.listener.ApolloStatusUpdateListener;
import com.tencent.qphone.base.util.QLog;

class ApolloPanel$31
  implements ApolloStatusUpdateListener
{
  ApolloPanel$31(ApolloPanel paramApolloPanel) {}
  
  public void a(int paramInt, boolean paramBoolean)
  {
    QLog.d("ApolloPanel", 2, "onStatusUpdate, currentStatus=" + paramInt + "， is3dAvailable=" + paramBoolean);
    this.a.post(new ApolloPanel.31.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloPanel.31
 * JD-Core Version:    0.7.0.1
 */
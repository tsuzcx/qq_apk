package com.tencent.mobileqq.apollo.handler.api.impl;

import com.tencent.mobileqq.apollo.handler.api.IApolloWebDataHandler;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class ApolloWebDataHandlerImpl$1
  implements Runnable
{
  ApolloWebDataHandlerImpl$1(ApolloWebDataHandlerImpl paramApolloWebDataHandlerImpl) {}
  
  public void run()
  {
    long l = System.currentTimeMillis();
    QRoute.api(IApolloWebDataHandler.class);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("apollo_client initInAsyncThread use:");
      localStringBuilder.append(System.currentTimeMillis() - l);
      QLog.d("[cmshow]apollo_client_ApolloWebDataHandler", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.handler.api.impl.ApolloWebDataHandlerImpl.1
 * JD-Core Version:    0.7.0.1
 */
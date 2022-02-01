package com.tencent.mobileqq.apollo.api.handler.impl;

import com.tencent.mobileqq.apollo.api.handler.IApolloWebDataHandler;
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
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloWebDataHandler", 2, "apollo_client initInAsyncThread use:" + (System.currentTimeMillis() - l));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.handler.impl.ApolloWebDataHandlerImpl.1
 * JD-Core Version:    0.7.0.1
 */
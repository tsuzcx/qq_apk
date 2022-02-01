package com.tencent.mobileqq.apollo.api.impl;

import com.tencent.qphone.base.util.QLog;

class ApolloManagerServiceImpl$17
  implements Runnable
{
  ApolloManagerServiceImpl$17(ApolloManagerServiceImpl paramApolloManagerServiceImpl, String paramString) {}
  
  public void run()
  {
    QLog.d("ApolloManager", 1, "getApolloBaseInfoFromCache failed, to call getApolloBaseInfo");
    this.this$0.getApolloBaseInfo(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl.17
 * JD-Core Version:    0.7.0.1
 */
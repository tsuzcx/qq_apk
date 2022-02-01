package com.tencent.mobileqq.apollo.persistence.api.impl;

import com.tencent.qphone.base.util.QLog;

class ApolloDaoManagerServiceImpl$11
  implements Runnable
{
  ApolloDaoManagerServiceImpl$11(ApolloDaoManagerServiceImpl paramApolloDaoManagerServiceImpl, String paramString) {}
  
  public void run()
  {
    QLog.d("[cmshow]ApolloDaoManager", 1, "getApolloBaseInfoFromCache failed, to call getApolloBaseInfo");
    this.this$0.getApolloBaseInfo(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl.11
 * JD-Core Version:    0.7.0.1
 */
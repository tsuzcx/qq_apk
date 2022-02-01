package com.tencent.mobileqq.apollo.api.impl;

import com.tencent.mobileqq.apollo.api.model.ApolloPandora;
import com.tencent.qphone.base.util.QLog;

class ApolloManagerServiceImpl$20
  implements Runnable
{
  ApolloManagerServiceImpl$20(ApolloManagerServiceImpl paramApolloManagerServiceImpl, String paramString) {}
  
  public void run()
  {
    ApolloPandora localApolloPandora = this.this$0.getApolloPandora(this.a, true);
    if (localApolloPandora != null)
    {
      localApolloPandora.hadStolen = 1;
      this.this$0.saveOrUpdateApolloPandora(localApolloPandora);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, "setCapsuleHadStolenAsync uin had Stolen");
      }
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("ApolloManager", 2, "setCapsuleHadStolenAsync local not save apolloPandora");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl.20
 * JD-Core Version:    0.7.0.1
 */
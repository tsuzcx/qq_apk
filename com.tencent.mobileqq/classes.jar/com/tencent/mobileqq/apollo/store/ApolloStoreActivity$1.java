package com.tencent.mobileqq.apollo.store;

import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloEngine;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

class ApolloStoreActivity$1
  implements Runnable
{
  ApolloStoreActivity$1(ApolloStoreActivity paramApolloStoreActivity) {}
  
  public void run()
  {
    if (!ApolloEngine.isEngineReady())
    {
      QLog.e("[cmshow]ApolloStoreActivity", 1, "error engine not ready");
      return;
    }
    this.this$0.a.sendEmptyMessage(258);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloStoreActivity.1
 * JD-Core Version:    0.7.0.1
 */
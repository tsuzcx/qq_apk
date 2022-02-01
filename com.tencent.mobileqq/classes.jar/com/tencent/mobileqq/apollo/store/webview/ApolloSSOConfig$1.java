package com.tencent.mobileqq.apollo.store.webview;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.observer.BusinessObserver;

class ApolloSSOConfig$1
  implements BusinessObserver
{
  ApolloSSOConfig$1(ApolloSSOConfig paramApolloSSOConfig, AppInterface paramAppInterface) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    long l = System.currentTimeMillis();
    ApolloSSOConfig.a(this.b, this.a, paramBoolean, paramBundle);
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("checkRequestSendSSO, type:");
      paramBundle.append(paramInt);
      paramBundle.append("isSuccess:");
      paramBundle.append(paramBoolean);
      paramBundle.append("onReceive use:");
      paramBundle.append(System.currentTimeMillis() - l);
      QLog.d("[cmshow]apollo_client_ApolloSSOConfig", 2, paramBundle.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloSSOConfig.1
 * JD-Core Version:    0.7.0.1
 */
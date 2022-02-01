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
    ApolloSSOConfig.a(this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig, this.jdField_a_of_type_ComTencentCommonAppAppInterface, paramBoolean, paramBundle);
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloSSOConfig", 2, "checkRequestSendSSO, type:" + paramInt + "isSuccess:" + paramBoolean + "onReceive use:" + (System.currentTimeMillis() - l));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloSSOConfig.1
 * JD-Core Version:    0.7.0.1
 */
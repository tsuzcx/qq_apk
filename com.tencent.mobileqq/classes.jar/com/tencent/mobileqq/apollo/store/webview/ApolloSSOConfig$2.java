package com.tencent.mobileqq.apollo.store.webview;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;

final class ApolloSSOConfig$2
  extends DownloadListener
{
  ApolloSSOConfig$2(SharedPreferences paramSharedPreferences, int paramInt, ApolloSSOConfig paramApolloSSOConfig) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("checkUpdateApolloWebViewConfig download file task.getStatus()->");
    localStringBuilder.append(paramDownloadTask.a());
    localStringBuilder.append(", httpCode: ");
    localStringBuilder.append(paramDownloadTask.f);
    QLog.i("[cmshow]apollo_client_ApolloSSOConfig", 1, localStringBuilder.toString());
    if (3 == paramDownloadTask.a())
    {
      this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putInt("sp_key_apollo_webView_config_version", this.jdField_a_of_type_Int).commit();
      if (QLog.isColorLevel())
      {
        paramDownloadTask = new StringBuilder();
        paramDownloadTask.append("checkUpdateApolloWebViewConfig download version:");
        paramDownloadTask.append(this.jdField_a_of_type_Int);
        QLog.d("[cmshow]apollo_client_ApolloSSOConfig", 2, paramDownloadTask.toString());
      }
      paramDownloadTask = this.jdField_a_of_type_ComTencentMobileqqApolloStoreWebviewApolloSSOConfig;
      if (paramDownloadTask != null) {
        ApolloSSOConfig.a(paramDownloadTask);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloSSOConfig.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.apollo.store.webview;

import com.tencent.qphone.base.util.QLog;
import java.net.HttpURLConnection;

class ApolloUrlConnection$1
  implements Runnable
{
  ApolloUrlConnection$1(ApolloUrlConnection paramApolloUrlConnection) {}
  
  public void run()
  {
    try
    {
      ApolloUrlConnection.a(this.this$0).disconnect();
      return;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("disconnect error:");
      localStringBuilder.append(localThrowable.getMessage());
      QLog.e("[cmshow]apollo_client_ApolloUrlConnection", 2, localStringBuilder.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloUrlConnection.1
 * JD-Core Version:    0.7.0.1
 */
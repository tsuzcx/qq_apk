package com.tencent.mobileqq.apollo.store.webview;

import alfz;
import com.tencent.qphone.base.util.QLog;
import java.net.HttpURLConnection;

public class ApolloUrlConnection$1
  implements Runnable
{
  public ApolloUrlConnection$1(alfz paramalfz) {}
  
  public void run()
  {
    try
    {
      alfz.a(this.this$0).disconnect();
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("apollo_client_ApolloUrlConnection", 2, "disconnect error:" + localThrowable.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloUrlConnection.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.apollo.store.webview;

import com.tencent.qphone.base.util.QLog;

class ApolloUrlInterceptor$2
  implements Runnable
{
  ApolloUrlInterceptor$2(ApolloUrlInterceptor paramApolloUrlInterceptor) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloUrlInterceptor", 2, "runDataTask in AsyncThread start!");
    }
    ApolloWebStatistics localApolloWebStatistics = ApolloUrlInterceptor.a(this.this$0);
    long l = System.currentTimeMillis();
    localApolloWebStatistics.g = l;
    ApolloUrlInterceptor.a(this.this$0);
    ApolloUrlInterceptor.b(this.this$0);
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloUrlInterceptor", 2, "runDataTask use:" + (System.currentTimeMillis() - l));
    }
    ApolloUrlInterceptor.a(this.this$0).h = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloUrlInterceptor.2
 * JD-Core Version:    0.7.0.1
 */
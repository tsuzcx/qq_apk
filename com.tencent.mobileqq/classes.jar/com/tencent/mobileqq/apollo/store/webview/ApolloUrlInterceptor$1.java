package com.tencent.mobileqq.apollo.store.webview;

import com.tencent.qphone.base.util.QLog;

class ApolloUrlInterceptor$1
  implements Runnable
{
  ApolloUrlInterceptor$1(ApolloUrlInterceptor paramApolloUrlInterceptor) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, "runDataTask in AsyncThread start!");
    }
    Object localObject = ApolloUrlInterceptor.a(this.this$0);
    long l = System.currentTimeMillis();
    ((ApolloWebStatistics)localObject).g = l;
    ApolloUrlInterceptor.b(this.this$0);
    ApolloUrlInterceptor.c(this.this$0);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("runDataTask use:");
      ((StringBuilder)localObject).append(System.currentTimeMillis() - l);
      QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 2, ((StringBuilder)localObject).toString());
    }
    ApolloUrlInterceptor.a(this.this$0).h = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloUrlInterceptor.1
 * JD-Core Version:    0.7.0.1
 */
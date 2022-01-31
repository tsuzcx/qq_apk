package com.tencent.mobileqq.apollo.store.webview;

import albm;
import albr;
import com.tencent.qphone.base.util.QLog;

public class ApolloUrlInterceptor$2
  implements Runnable
{
  public ApolloUrlInterceptor$2(albm paramalbm) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloUrlInterceptor", 2, "runDataTask in AsyncThread start!");
    }
    albr localalbr = albm.a(this.this$0);
    long l = System.currentTimeMillis();
    localalbr.g = l;
    albm.a(this.this$0);
    albm.b(this.this$0);
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloUrlInterceptor", 2, "runDataTask use:" + (System.currentTimeMillis() - l));
    }
    albm.a(this.this$0).h = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloUrlInterceptor.2
 * JD-Core Version:    0.7.0.1
 */
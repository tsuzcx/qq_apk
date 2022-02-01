package com.tencent.mobileqq.apollo.store.webview;

import amfw;
import amgb;
import com.tencent.qphone.base.util.QLog;

public class ApolloUrlInterceptor$2
  implements Runnable
{
  public ApolloUrlInterceptor$2(amfw paramamfw) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloUrlInterceptor", 2, "runDataTask in AsyncThread start!");
    }
    amgb localamgb = amfw.a(this.this$0);
    long l = System.currentTimeMillis();
    localamgb.g = l;
    amfw.a(this.this$0);
    amfw.b(this.this$0);
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloUrlInterceptor", 2, "runDataTask use:" + (System.currentTimeMillis() - l));
    }
    amfw.a(this.this$0).h = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloUrlInterceptor.2
 * JD-Core Version:    0.7.0.1
 */
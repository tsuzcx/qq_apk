package com.tencent.mobileqq.apollo.store.webview;

import anhe;
import anhj;
import com.tencent.qphone.base.util.QLog;

public class ApolloUrlInterceptor$2
  implements Runnable
{
  public ApolloUrlInterceptor$2(anhe paramanhe) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloUrlInterceptor", 2, "runDataTask in AsyncThread start!");
    }
    anhj localanhj = anhe.a(this.this$0);
    long l = System.currentTimeMillis();
    localanhj.g = l;
    anhe.a(this.this$0);
    anhe.b(this.this$0);
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloUrlInterceptor", 2, "runDataTask use:" + (System.currentTimeMillis() - l));
    }
    anhe.a(this.this$0).h = System.currentTimeMillis();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloUrlInterceptor.2
 * JD-Core Version:    0.7.0.1
 */
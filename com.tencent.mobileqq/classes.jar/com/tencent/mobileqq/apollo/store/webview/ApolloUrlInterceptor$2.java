package com.tencent.mobileqq.apollo.store.webview;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.handler.api.IApolloWebDataHandler;
import com.tencent.mobileqq.apollo.handler.api.impl.ApolloWebDataHandlerImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.util.concurrent.atomic.AtomicBoolean;

class ApolloUrlInterceptor$2
  implements Runnable
{
  ApolloUrlInterceptor$2(ApolloUrlInterceptor paramApolloUrlInterceptor, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public void run()
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("task(");
      ((StringBuilder)localObject1).append(this.this$0.b);
      ((StringBuilder)localObject1).append(") onClose:cachedStream size:");
      ((StringBuilder)localObject1).append(this.a.size());
      QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 1, ((StringBuilder)localObject1).toString());
    }
    Object localObject2;
    if (!ApolloUrlInterceptor.d(this.this$0))
    {
      StringBuilder localStringBuilder;
      try
      {
        localObject1 = this.a.toString("UTF-8");
        this.a.close();
      }
      catch (Throwable localThrowable)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("task(");
        localStringBuilder.append(this.this$0.b);
        localStringBuilder.append(") onClose error:");
        localStringBuilder.append(localThrowable.getMessage());
        QLog.e("[cmshow]apollo_client_ApolloUrlInterceptor", 1, localStringBuilder.toString());
        localObject2 = null;
      }
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        long l = System.currentTimeMillis();
        ((ApolloWebDataHandlerImpl)QRoute.api(IApolloWebDataHandler.class)).saveHtml(ApolloUrlInterceptor.e(this.this$0), (String)localObject2);
        ApolloUrlInterceptor.a(this.this$0, true);
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("task(");
          localStringBuilder.append(this.this$0.b);
          localStringBuilder.append(") onClose:save bridgeStream ");
          localStringBuilder.append(System.currentTimeMillis() - l);
          localStringBuilder.append(" ms. htmlString.length:");
          localStringBuilder.append(((String)localObject2).length());
          QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 4, localStringBuilder.toString());
        }
      }
    }
    ApolloUrlInterceptor.f(this.this$0).set(false);
    if ((ApolloUrlInterceptor.g(this.this$0)) && (QLog.isColorLevel()))
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("task(");
      ((StringBuilder)localObject2).append(this.this$0.b);
      ((StringBuilder)localObject2).append(") onClose: postForceDestroyIfNeed send destroy message.");
      QLog.d("[cmshow]apollo_client_ApolloUrlInterceptor", 4, ((StringBuilder)localObject2).toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloUrlInterceptor.2
 * JD-Core Version:    0.7.0.1
 */
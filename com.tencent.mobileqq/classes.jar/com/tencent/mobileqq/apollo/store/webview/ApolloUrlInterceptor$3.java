package com.tencent.mobileqq.apollo.store.webview;

import android.text.TextUtils;
import com.tencent.mobileqq.apollo.api.handler.IApolloWebDataHandler;
import com.tencent.mobileqq.apollo.api.handler.impl.ApolloWebDataHandlerImpl;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.util.concurrent.atomic.AtomicBoolean;

class ApolloUrlInterceptor$3
  implements Runnable
{
  ApolloUrlInterceptor$3(ApolloUrlInterceptor paramApolloUrlInterceptor, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloUrlInterceptor", 1, "task(" + this.this$0.b + ") onClose:cachedStream size:" + this.a.size());
    }
    if (!ApolloUrlInterceptor.a(this.this$0)) {}
    try
    {
      String str = this.a.toString("UTF-8");
      this.a.close();
      if (!TextUtils.isEmpty(str))
      {
        long l = System.currentTimeMillis();
        ((ApolloWebDataHandlerImpl)QRoute.api(IApolloWebDataHandler.class)).saveHtml(ApolloUrlInterceptor.a(this.this$0), str);
        ApolloUrlInterceptor.a(this.this$0, true);
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloUrlInterceptor", 4, "task(" + this.this$0.b + ") onClose:save bridgeStream " + (System.currentTimeMillis() - l) + " ms. htmlString.length:" + str.length());
        }
      }
      ApolloUrlInterceptor.a(this.this$0).set(false);
      if ((ApolloUrlInterceptor.b(this.this$0)) && (QLog.isColorLevel())) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 4, "task(" + this.this$0.b + ") onClose: postForceDestroyIfNeed send destroy message.");
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("apollo_client_ApolloUrlInterceptor", 1, "task(" + this.this$0.b + ") onClose error:" + localThrowable.getMessage());
        Object localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloUrlInterceptor.3
 * JD-Core Version:    0.7.0.1
 */
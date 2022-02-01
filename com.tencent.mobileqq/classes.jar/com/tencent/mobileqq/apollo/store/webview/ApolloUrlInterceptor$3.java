package com.tencent.mobileqq.apollo.store.webview;

import amzi;
import amzk;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.util.concurrent.atomic.AtomicBoolean;

public class ApolloUrlInterceptor$3
  implements Runnable
{
  public ApolloUrlInterceptor$3(amzi paramamzi, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloUrlInterceptor", 1, "task(" + this.this$0.b + ") onClose:cachedStream size:" + this.a.size());
    }
    if (!amzi.a(this.this$0)) {}
    try
    {
      str = this.a.toString("UTF-8");
      this.a.close();
      if (!TextUtils.isEmpty(str))
      {
        long l = System.currentTimeMillis();
        amzk.a().b(amzi.a(this.this$0), str);
        amzi.a(this.this$0, true);
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloUrlInterceptor", 4, "task(" + this.this$0.b + ") onClose:save bridgeStream " + (System.currentTimeMillis() - l) + " ms. htmlString.length:" + str.length());
        }
      }
      amzi.a(this.this$0).set(false);
      if ((amzi.b(this.this$0)) && (QLog.isColorLevel())) {
        QLog.d("apollo_client_ApolloUrlInterceptor", 4, "task(" + this.this$0.b + ") onClose: postForceDestroyIfNeed send destroy message.");
      }
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        String str = null;
        QLog.e("apollo_client_ApolloUrlInterceptor", 1, "task(" + this.this$0.b + ") onClose error:" + localThrowable.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.webview.ApolloUrlInterceptor.3
 * JD-Core Version:    0.7.0.1
 */
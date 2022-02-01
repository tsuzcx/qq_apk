package com.tencent.mobileqq.apollo.store.webview;

import android.text.TextUtils;
import anhe;
import anhg;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.util.concurrent.atomic.AtomicBoolean;

public class ApolloUrlInterceptor$3
  implements Runnable
{
  public ApolloUrlInterceptor$3(anhe paramanhe, ByteArrayOutputStream paramByteArrayOutputStream) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("apollo_client_ApolloUrlInterceptor", 1, "task(" + this.this$0.b + ") onClose:cachedStream size:" + this.a.size());
    }
    if (!anhe.a(this.this$0)) {}
    try
    {
      str = this.a.toString("UTF-8");
      this.a.close();
      if (!TextUtils.isEmpty(str))
      {
        long l = System.currentTimeMillis();
        anhg.a().b(anhe.a(this.this$0), str);
        anhe.a(this.this$0, true);
        if (QLog.isColorLevel()) {
          QLog.d("apollo_client_ApolloUrlInterceptor", 4, "task(" + this.this$0.b + ") onClose:save bridgeStream " + (System.currentTimeMillis() - l) + " ms. htmlString.length:" + str.length());
        }
      }
      anhe.a(this.this$0).set(false);
      if ((anhe.b(this.this$0)) && (QLog.isColorLevel())) {
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
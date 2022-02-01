package com.huawei.secure.android.common.ssl;

import android.content.Context;
import android.webkit.SslErrorHandler;
import com.huawei.secure.android.common.ssl.util.g;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

final class WebViewSSLCheckThread$a
  implements Callback
{
  WebViewSSLCheckThread$a(WebViewSSLCheckThread.Callback paramCallback, Context paramContext, String paramString, SslErrorHandler paramSslErrorHandler) {}
  
  public void onFailure(Call paramCall, IOException paramIOException)
  {
    paramCall = WebViewSSLCheckThread.a();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onFailure , IO Exception : ");
    localStringBuilder.append(paramIOException.getMessage());
    g.b(paramCall, localStringBuilder.toString());
    paramCall = this.a;
    if (paramCall != null)
    {
      paramCall.onCancel(this.b, this.c);
      return;
    }
    this.d.cancel();
  }
  
  public void onResponse(Call paramCall, Response paramResponse)
  {
    g.b(WebViewSSLCheckThread.a(), "onResponse . proceed");
    paramCall = this.a;
    if (paramCall != null)
    {
      paramCall.onProceed(this.b, this.c);
      return;
    }
    this.d.proceed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.secure.android.common.ssl.WebViewSSLCheckThread.a
 * JD-Core Version:    0.7.0.1
 */
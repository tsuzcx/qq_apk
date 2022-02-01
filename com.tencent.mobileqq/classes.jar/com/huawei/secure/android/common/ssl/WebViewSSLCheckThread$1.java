package com.huawei.secure.android.common.ssl;

import android.content.Context;
import android.webkit.SslErrorHandler;
import com.huawei.secure.android.common.ssl.util.g;
import java.io.IOException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

final class WebViewSSLCheckThread$1
  implements Callback
{
  WebViewSSLCheckThread$1(WebViewSSLCheckThread.Callback paramCallback, Context paramContext, String paramString, SslErrorHandler paramSslErrorHandler) {}
  
  public void onFailure(Call paramCall, IOException paramIOException)
  {
    g.e(WebViewSSLCheckThread.d(), "onFailure , IO Exception : " + paramIOException.getMessage());
    if (this.R != null)
    {
      this.R.onCancel(this.S, this.T);
      return;
    }
    this.U.cancel();
  }
  
  public void onResponse(Call paramCall, Response paramResponse)
  {
    g.e(WebViewSSLCheckThread.d(), "onResponse . proceed");
    if (this.R != null)
    {
      this.R.onProceed(this.S, this.T);
      return;
    }
    this.U.proceed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.huawei.secure.android.common.ssl.WebViewSSLCheckThread.1
 * JD-Core Version:    0.7.0.1
 */
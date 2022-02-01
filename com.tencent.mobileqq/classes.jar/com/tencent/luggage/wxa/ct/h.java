package com.tencent.luggage.wxa.ct;

import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.xweb.JsResult;
import com.tencent.xweb.WebView;
import com.tencent.xweb.u;
import java.util.concurrent.ConcurrentSkipListSet;

public class h
  extends u
{
  private final ConcurrentSkipListSet<JsResult> a = new ConcurrentSkipListSet(new h.1(this));
  
  @NonNull
  private JsResult a(@NonNull JsResult paramJsResult)
  {
    return new h.2(this, paramJsResult);
  }
  
  public boolean a(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return false;
  }
  
  public void b()
  {
    o.d("Luggage.STANDALONE.MMWebChromeClient", "cleanup hash[%d] waitingSize[%d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(this.a.size()) });
    while (!this.a.isEmpty()) {
      ((JsResult)this.a.pollFirst()).cancel();
    }
    a();
  }
  
  public boolean b(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    return false;
  }
  
  public final boolean c(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    o.d("Luggage.STANDALONE.MMWebChromeClient", "onJsAlert hash[%d] message[%s]", new Object[] { Integer.valueOf(hashCode()), paramString2 });
    return a(paramWebView, paramString1, paramString2, a(paramJsResult));
  }
  
  public final boolean d(WebView paramWebView, String paramString1, String paramString2, JsResult paramJsResult)
  {
    o.d("Luggage.STANDALONE.MMWebChromeClient", "onJsConfirm hash[%d] message[%s]", new Object[] { Integer.valueOf(hashCode()), paramString2 });
    return b(paramWebView, paramString1, paramString2, a(paramJsResult));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ct.h
 * JD-Core Version:    0.7.0.1
 */
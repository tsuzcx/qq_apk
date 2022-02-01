package com.tencent.luggage.wxa.ct;

import android.content.Context;
import android.os.Looper;
import android.webkit.ValueCallback;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.rz.f;
import com.tencent.luggage.wxa.rz.g;

class a$3
  extends i
{
  private boolean k = false;
  
  a$3(a parama, Context paramContext)
  {
    super(paramContext);
  }
  
  public void destroy()
  {
    if (this.k) {
      return;
    }
    if ((getCurWebChromeClient() instanceof h)) {
      ((h)getCurWebChromeClient()).b();
    }
    o.d("Luggage.STANDALONE.AppBrandHTMLWebView", "webview destroy hash[%d]", new Object[] { Integer.valueOf(this.a.hashCode()) });
    super.destroy();
    this.k = true;
  }
  
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      super.evaluateJavascript(paramString, paramValueCallback);
      return;
    }
    f.a.a(new a.3.1(this, paramString, paramValueCallback));
  }
  
  public void loadUrl(String paramString)
  {
    if (!a.a(this.a, paramString)) {
      super.loadUrl(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ct.a.3
 * JD-Core Version:    0.7.0.1
 */
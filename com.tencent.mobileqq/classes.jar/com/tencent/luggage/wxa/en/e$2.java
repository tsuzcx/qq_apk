package com.tencent.luggage.wxa.en;

import com.tencent.luggage.wxa.qz.r;
import com.tencent.luggage.wxa.qz.s;
import com.tencent.luggage.wxa.qz.t;
import com.tencent.xweb.WebView;
import com.tencent.xweb.WebView.c;

final class e$2
  implements Runnable
{
  e$2(Runnable paramRunnable, s params) {}
  
  public void run()
  {
    t.a(-2);
    if (WebView.hasInited())
    {
      this.a.run();
      return;
    }
    s locals = this.b;
    WebView.initWebviewCore(r.a(), WebView.c.b, "appbrand", new e.2.1(this, locals));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.en.e.2
 * JD-Core Version:    0.7.0.1
 */
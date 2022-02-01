package com.tencent.mm.plugin.appbrand.page;

import android.webkit.WebChromeClient.CustomViewCallback;
import com.tencent.luggage.wxa.qz.o;

class bm$9$1
  implements WebChromeClient.CustomViewCallback
{
  bm$9$1(bm.9 param9, WebChromeClient.CustomViewCallback paramCustomViewCallback) {}
  
  public void onCustomViewHidden()
  {
    if (this.b.a.hasEnteredFullscreen())
    {
      o.d("Luggage.XWebViewImpl", "WebChromeClient leaveFullscreen");
      this.b.a.leaveFullscreen();
    }
    WebChromeClient.CustomViewCallback localCustomViewCallback = this.a;
    if (localCustomViewCallback != null) {
      localCustomViewCallback.onCustomViewHidden();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bm.9.1
 * JD-Core Version:    0.7.0.1
 */
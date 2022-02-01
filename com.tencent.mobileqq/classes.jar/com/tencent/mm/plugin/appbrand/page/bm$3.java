package com.tencent.mm.plugin.appbrand.page;

import android.webkit.DownloadListener;
import com.tencent.luggage.wxa.qz.o;

class bm$3
  implements DownloadListener
{
  bm$3(bm parambm) {}
  
  public void onDownloadStart(String paramString1, String paramString2, String paramString3, String paramString4, long paramLong)
  {
    o.d("Luggage.XWebViewImpl", "onDownloadStart called, url = %s, mimeType = %s, userAgent = %s", new Object[] { paramString1, paramString4, paramString2 });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.bm.3
 * JD-Core Version:    0.7.0.1
 */
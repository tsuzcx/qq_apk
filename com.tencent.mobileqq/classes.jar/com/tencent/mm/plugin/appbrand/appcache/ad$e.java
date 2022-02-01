package com.tencent.mm.plugin.appbrand.appcache;

import android.webkit.WebResourceResponse;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.rc.d;
import java.io.InputStream;

final class ad$e
  implements ad.b<WebResourceResponse>
{
  public WebResourceResponse a(@NonNull String paramString, @NonNull InputStream paramInputStream)
  {
    return new WebResourceResponse(d.b(paramString), "UTF-8", paramInputStream);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ad.e
 * JD-Core Version:    0.7.0.1
 */
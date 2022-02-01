package com.tencent.ad.tangram.statistics;

import android.content.Context;
import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.ad.tangram.net.AdHttp.Params;
import java.lang.ref.WeakReference;

final class b$1
  implements Runnable
{
  b$1(String paramString, b.a parama) {}
  
  public void run()
  {
    AdHttp.Params localParams = new AdHttp.Params();
    localParams.setUrl(this.val$finalUrl);
    localParams.method = "GET";
    AdHttp.send(localParams);
    Context localContext;
    if (this.val$params.context != null) {
      localContext = (Context)this.val$params.context.get();
    } else {
      localContext = null;
    }
    a.reportForActionStatisticsEnd(localContext, this.val$params.ad, localParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.statistics.b.1
 * JD-Core Version:    0.7.0.1
 */
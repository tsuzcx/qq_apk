package com.tencent.ad.tangram.statistics;

import android.content.Context;
import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.ad.tangram.net.AdHttp.Params;
import java.lang.ref.WeakReference;

final class a$1
  implements Runnable
{
  a$1(String paramString, a.a parama) {}
  
  public void run()
  {
    AdHttp.Params localParams = new AdHttp.Params();
    localParams.setUrl(this.val$finalUrl);
    localParams.method = "GET";
    AdHttp.send(localParams);
    if (this.val$params.context != null) {}
    for (Context localContext = (Context)this.val$params.context.get();; localContext = null)
    {
      AdReporterForAnalysis.reportForActionStatisticsEnd(localContext, this.val$params.ad, localParams);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.statistics.a.1
 * JD-Core Version:    0.7.0.1
 */
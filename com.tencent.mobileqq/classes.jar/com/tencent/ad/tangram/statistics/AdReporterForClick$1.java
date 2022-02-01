package com.tencent.ad.tangram.statistics;

import android.content.Context;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.net.AdHttp;
import com.tencent.ad.tangram.net.AdHttp.Params;
import java.lang.ref.WeakReference;

final class AdReporterForClick$1
  implements Runnable
{
  AdReporterForClick$1(String paramString, WeakReference paramWeakReference, Ad paramAd) {}
  
  public void run()
  {
    AdHttp.Params localParams = new AdHttp.Params();
    localParams.setUrl(this.val$url);
    localParams.method = "GET";
    AdHttp.send(localParams);
    Object localObject = this.val$context;
    if (localObject != null) {
      localObject = (Context)((WeakReference)localObject).get();
    } else {
      localObject = null;
    }
    a.reportForClickStatisticsEnd((Context)localObject, this.val$ad, localParams);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.statistics.AdReporterForClick.1
 * JD-Core Version:    0.7.0.1
 */
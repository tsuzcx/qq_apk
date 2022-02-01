package com.tencent.gdtad.adapter;

import android.content.Context;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.mini.AdQQMINIProgramAdapter;
import com.tencent.ad.tangram.mini.AdQQMINIProgramAdapter.Params;
import com.tencent.ad.tangram.statistics.AdReporterForAnalysis;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.qroute.QRoute;
import java.lang.ref.WeakReference;

public class GdtQQMINIProgramAdapter
  implements AdQQMINIProgramAdapter
{
  public AdError show(AdQQMINIProgramAdapter.Params paramParams)
  {
    if ((paramParams == null) || (!paramParams.isValid()) || (!(paramParams.ad instanceof GdtAd)))
    {
      GdtLog.d("GdtQQMINIProgramAdapter", "show error");
      return new AdError(4);
    }
    GdtAd localGdtAd = (GdtAd)GdtAd.class.cast(paramParams.ad);
    GdtLog.b("GdtQQMINIProgramAdapter", String.format("show %s", new Object[] { localGdtAd.getUrlForLandingPage() }));
    AdReporterForAnalysis.reportForLaunchQQMINIProgramStart((Context)paramParams.context.get(), localGdtAd);
    ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp((Context)paramParams.context.get(), localGdtAd.getUrlForLandingPage(), 2054, new GdtQQMINIProgramAdapter.1(this, paramParams, localGdtAd));
    return new AdError(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.adapter.GdtQQMINIProgramAdapter
 * JD-Core Version:    0.7.0.1
 */
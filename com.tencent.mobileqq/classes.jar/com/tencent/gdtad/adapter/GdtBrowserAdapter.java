package com.tencent.gdtad.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.protocol.link_report.LinkReport.ReportBiz;
import com.tencent.ad.tangram.statistics.AdReporterForLinkEvent;
import com.tencent.ad.tangram.util.AdUriUtil;
import com.tencent.ad.tangram.web.AdBrowserAdapter;
import com.tencent.ad.tangram.web.AdBrowserAdapter.Params;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.params.InitGdtContextParams;
import com.tencent.gdtad.web.GdtWebReportQQ;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.qroute.QRoute;
import java.lang.ref.WeakReference;

public final class GdtBrowserAdapter
  implements AdBrowserAdapter
{
  private void a(AdBrowserAdapter.Params paramParams)
  {
    ((IGdtAdAPI)QRoute.api(IGdtAdAPI.class)).initGdtContext((Context)paramParams.activity.get(), new InitGdtContextParams());
    link_report.LinkReport.ReportBiz localReportBiz = new link_report.LinkReport.ReportBiz();
    localReportBiz.wv_progress = 2;
    localReportBiz.lp_type = 1;
    if (GdtWebReportQQ.a(paramParams.ad.getUrlForClick())) {
      localReportBiz.click_req_type = 1;
    } else {
      localReportBiz.click_req_type = 3;
    }
    AdReporterForLinkEvent.reportAsync((Context)paramParams.activity.get(), 4003001, paramParams.ad, localReportBiz, null);
  }
  
  public AdError show(AdBrowserAdapter.Params paramParams)
  {
    if ((paramParams != null) && (paramParams.isValid()) && (paramParams.ad != null) && ((paramParams.ad instanceof GdtAd)))
    {
      GdtLog.b("GdtBrowserAdapter", String.format("show %s", new Object[] { paramParams.url }));
      Object localObject = (GdtAd)GdtAd.class.cast(paramParams.ad);
      Intent localIntent = new Intent((Context)paramParams.activity.get(), QQBrowserActivity.class);
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      localIntent.putExtra("url", paramParams.url);
      if ((paramParams.extrasForIntent != null) && (!paramParams.extrasForIntent.isEmpty())) {
        localIntent.putExtras(paramParams.extrasForIntent);
      }
      if ((paramParams.ad != null) && (paramParams.ad.isValid()))
      {
        if (((GdtAd)localObject).getNocoId() != 0L) {
          localIntent.putExtra("GdtNocoId", ((GdtAd)localObject).getNocoId());
        }
        localIntent.putExtra("GdtWebReportQQ_TRACE_ID", paramParams.ad.getTraceId());
        localIntent.putExtra("GdtNocoId", ((GdtAd)localObject).getNocoId());
        localIntent.putExtra("GdtWebReportQQ_ACTION_URL", ((GdtAd)localObject).getUrlForAction());
        localIntent.putExtra("GdtWebReportQQ_CLICK_TIME", System.currentTimeMillis());
        localIntent.putExtra("GdtWebReportQQ_IS_H5", true);
        localIntent.putExtra("GdtWebReportQQ_CLICK_URL", ((GdtAd)localObject).getUrlForClick());
        localIntent.putExtra("GdtWebReportQQ_AD_ID", String.valueOf(((GdtAd)localObject).getAId()));
        localIntent.putExtra("GdtWebReportQQ_POS_ID", ((GdtAd)localObject).getPosId());
      }
      if ((localObject != null) && (((GdtAd)localObject).isValid()) && ((paramParams.ad.isAppXiJingOffline()) || (paramParams.ad.isWebXiJingOffline())) && (!TextUtils.isEmpty(paramParams.ad.getCanvasForXiJingOffline())))
      {
        Bundle localBundle = new Bundle();
        localBundle.putParcelable("gdt_ad", (Parcelable)localObject);
        localIntent.putExtras(localBundle);
      }
      if ((paramParams.ad != null) && (paramParams.ad.getProductType() == 25))
      {
        localObject = paramParams.ad.getUrlForClick();
        if ((!TextUtils.isEmpty((CharSequence)localObject)) && ("1".equals(AdUriUtil.getQueryParameter(AdUriUtil.parse((String)localObject), "autoclose")))) {
          localIntent.putExtra("keyForForceCloseAfterJump", true);
        }
      }
      try
      {
        a(paramParams);
        ((Activity)paramParams.activity.get()).startActivity(localIntent);
        paramParams = new AdError(0);
        return paramParams;
      }
      catch (Throwable paramParams)
      {
        GdtLog.d("GdtBrowserAdapter", "show", paramParams);
        return new AdError(202, paramParams);
      }
    }
    GdtLog.d("GdtBrowserAdapter", "show error");
    return new AdError(4);
  }
  
  public AdError showWithoutAd(AdBrowserAdapter.Params paramParams)
  {
    if ((paramParams != null) && (paramParams.isValid()))
    {
      Intent localIntent = new Intent((Context)paramParams.activity.get(), QQBrowserActivity.class);
      localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
      localIntent.putExtra("url", paramParams.url);
      if ((paramParams.extrasForIntent != null) && (!paramParams.extrasForIntent.isEmpty())) {
        localIntent.putExtras(paramParams.extrasForIntent);
      }
      try
      {
        ((Activity)paramParams.activity.get()).startActivity(localIntent);
        paramParams = new AdError(0);
        return paramParams;
      }
      catch (Throwable paramParams)
      {
        GdtLog.d("GdtBrowserAdapter", "showWithoutAd", paramParams);
        return new AdError(202, paramParams);
      }
    }
    GdtLog.d("GdtBrowserAdapter", "showWithoutAd error");
    return new AdError(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.adapter.GdtBrowserAdapter
 * JD-Core Version:    0.7.0.1
 */
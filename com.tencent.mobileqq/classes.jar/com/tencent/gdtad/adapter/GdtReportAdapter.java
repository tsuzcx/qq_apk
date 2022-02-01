package com.tencent.gdtad.adapter;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.statistics.canvas.AdRefreshCallback;
import com.tencent.ad.tangram.statistics.canvas.AdReportAdapter;
import com.tencent.ad.tangram.views.canvas.components.appbutton.AdAppBtnData;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.canvas.components.appbutton.GdtDownloadReportManager;

public class GdtReportAdapter
  implements AdReportAdapter
{
  public void downloadReport(Ad paramAd, String paramString, int paramInt, boolean paramBoolean, AdAppBtnData paramAdAppBtnData)
  {
    if ((paramAd instanceof GdtAd))
    {
      if (TextUtils.isEmpty(paramString)) {
        return;
      }
      GdtDownloadReportManager localGdtDownloadReportManager = GdtDownloadReportManager.a();
      paramAd = (GdtAd)paramAd;
      localGdtDownloadReportManager.a(paramString, paramAd, paramAdAppBtnData);
      GdtDownloadReportManager.a().a(paramAd, paramInt, paramBoolean);
    }
  }
  
  public AdRefreshCallback getAdReportAdapter()
  {
    return GdtDownloadReportManager.a();
  }
  
  public void reportForCanvasDataBuildEnd(Context paramContext, Ad paramAd, long paramLong) {}
  
  public void reportForCanvasDataBuildError(Context paramContext, int paramInt, Ad paramAd, String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.adapter.GdtReportAdapter
 * JD-Core Version:    0.7.0.1
 */
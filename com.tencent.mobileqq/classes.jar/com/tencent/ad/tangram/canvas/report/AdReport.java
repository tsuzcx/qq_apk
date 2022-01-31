package com.tencent.ad.tangram.canvas.report;

import android.support.annotation.Keep;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.AdAppBtnData;
import java.lang.ref.WeakReference;

@Keep
public enum AdReport
{
  INSTANCE;
  
  private static final String TAG = "AdReport";
  private WeakReference<AdReportAdapter> adapter;
  
  private AdReport() {}
  
  public static void downloadReport(Ad paramAd, String paramString, int paramInt, boolean paramBoolean, AdAppBtnData paramAdAppBtnData)
  {
    AdReportAdapter localAdReportAdapter = getAdapter();
    if (localAdReportAdapter != null) {
      localAdReportAdapter.downloadReport(paramAd, paramString, paramInt, paramBoolean, paramAdAppBtnData);
    }
  }
  
  public static AdRefreshCallback getAdReportAdapter()
  {
    AdReportAdapter localAdReportAdapter = getAdapter();
    if (localAdReportAdapter != null) {
      return localAdReportAdapter.getAdReportAdapter();
    }
    return null;
  }
  
  private static AdReportAdapter getAdapter()
  {
    if (INSTANCE.adapter != null) {
      return (AdReportAdapter)INSTANCE.adapter.get();
    }
    return null;
  }
  
  public static void setAdapter(WeakReference<AdReportAdapter> paramWeakReference)
  {
    INSTANCE.adapter = paramWeakReference;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.report.AdReport
 * JD-Core Version:    0.7.0.1
 */
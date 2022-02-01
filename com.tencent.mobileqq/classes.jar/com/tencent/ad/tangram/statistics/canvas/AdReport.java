package com.tencent.ad.tangram.statistics.canvas;

import android.content.Context;
import android.support.annotation.Keep;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.views.canvas.components.appbutton.AdAppBtnData;
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
    WeakReference localWeakReference = INSTANCE.adapter;
    if (localWeakReference != null) {
      return (AdReportAdapter)localWeakReference.get();
    }
    return null;
  }
  
  public static void reportForCanvasDataBuildEnd(Context paramContext, Ad paramAd, long paramLong)
  {
    AdReportAdapter localAdReportAdapter = getAdapter();
    if (localAdReportAdapter != null) {
      localAdReportAdapter.reportForCanvasDataBuildEnd(paramContext, paramAd, paramLong);
    }
  }
  
  public static void reportForCanvasDataBuildError(Context paramContext, int paramInt, Ad paramAd, String paramString)
  {
    AdReportAdapter localAdReportAdapter = getAdapter();
    if (localAdReportAdapter != null) {
      localAdReportAdapter.reportForCanvasDataBuildError(paramContext, paramInt, paramAd, paramString);
    }
  }
  
  public static void setAdapter(WeakReference<AdReportAdapter> paramWeakReference)
  {
    INSTANCE.adapter = paramWeakReference;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.statistics.canvas.AdReport
 * JD-Core Version:    0.7.0.1
 */
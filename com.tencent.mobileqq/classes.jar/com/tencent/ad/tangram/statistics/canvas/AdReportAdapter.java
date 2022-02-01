package com.tencent.ad.tangram.statistics.canvas;

import android.content.Context;
import android.support.annotation.Keep;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.views.canvas.components.appbutton.AdAppBtnData;

@Keep
public abstract interface AdReportAdapter
{
  public abstract void downloadReport(Ad paramAd, String paramString, int paramInt, boolean paramBoolean, AdAppBtnData paramAdAppBtnData);
  
  public abstract AdRefreshCallback getAdReportAdapter();
  
  public abstract void reportForCanvasDataBuildEnd(Context paramContext, Ad paramAd, long paramLong);
  
  public abstract void reportForCanvasDataBuildError(Context paramContext, int paramInt, Ad paramAd, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.statistics.canvas.AdReportAdapter
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.ad.tangram.canvas.report;

import android.support.annotation.Keep;
import com.tencent.ad.tangram.Ad;
import com.tencent.ad.tangram.canvas.views.canvas.components.appbutton.AdAppBtnData;

@Keep
public abstract interface AdReportAdapter
{
  public abstract void downloadReport(Ad paramAd, String paramString, int paramInt, boolean paramBoolean, AdAppBtnData paramAdAppBtnData);
  
  public abstract AdRefreshCallback getAdReportAdapter();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.report.AdReportAdapter
 * JD-Core Version:    0.7.0.1
 */
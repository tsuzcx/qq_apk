package com.tencent.gdtad.web;

import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.gdtad.log.GdtLog;

class GdtLandingPageReport$3
  implements GdtLandingPageReport.WebviewEvaluateListener
{
  GdtLandingPageReport$3(GdtLandingPageReport paramGdtLandingPageReport) {}
  
  public void a(String paramString)
  {
    GdtLog.d("GdtLandingPageReport", " webviewGetPerformanceResult onResponse ==" + paramString);
    if ((paramString != null) && (!paramString.equals("null")))
    {
      AdThreadManager.INSTANCE.post(new GdtLandingPageReport.3.1(this, paramString), 4);
      GdtLog.d("GdtLandingPageReport", " webviewGetPerformanceResult report response ==" + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.web.GdtLandingPageReport.3
 * JD-Core Version:    0.7.0.1
 */
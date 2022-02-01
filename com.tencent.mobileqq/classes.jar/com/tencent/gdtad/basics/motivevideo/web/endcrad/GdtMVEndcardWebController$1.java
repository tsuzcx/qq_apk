package com.tencent.gdtad.basics.motivevideo.web.endcrad;

import com.tencent.gdtad.basics.motivevideo.report.GdtADFlyingStreamingReportHelper;
import com.tencent.gdtad.inject.IGdtWebViewListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import org.json.JSONException;
import org.json.JSONObject;

class GdtMVEndcardWebController$1
  extends IGdtWebViewListener
{
  GdtMVEndcardWebController$1(GdtMVEndcardWebController paramGdtMVEndcardWebController) {}
  
  public void a(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    this.a.e();
    paramWebView = new StringBuilder();
    paramWebView.append("onReceivedError url = ");
    paramWebView.append(paramInt);
    paramWebView.append(",description = ");
    paramWebView.append(paramString1);
    paramWebView.append(",failingUrl = ");
    paramWebView.append(paramString2);
    QLog.i("EndCardWebGdtMVEndcardWebController", 1, paramWebView.toString());
    this.a.a();
    if ((!GdtMVEndcardWebController.a(this.a)) && (this.a.a))
    {
      GdtADFlyingStreamingReportHelper.a().a(1020017L);
      GdtMVEndcardWebController.a(this.a, true);
    }
  }
  
  public void a(WebView paramWebView, String paramString)
  {
    if ((!this.a.b) && (!GdtMVEndcardWebController.a(this.a)) && (this.a.a))
    {
      long l1 = System.currentTimeMillis();
      long l2 = GdtMVEndcardWebController.a(this.a);
      try
      {
        paramWebView = new JSONObject();
        paramWebView.put("cost_time", l1 - l2);
        GdtADFlyingStreamingReportHelper.a().a(1020031L, paramWebView);
        GdtMVEndcardWebController.a(this.a, true);
        return;
      }
      catch (JSONException paramWebView)
      {
        paramString = new StringBuilder();
        paramString.append("reportWebEndCardLoadingEvent fail :");
        paramString.append(paramWebView);
        QLog.e("EndCardWebGdtMVEndcardWebController", 1, paramString.toString());
      }
    }
  }
  
  public boolean a(WebView paramWebView, String paramString)
  {
    return GdtMVEndcardWebController.a(this.a, paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.web.endcrad.GdtMVEndcardWebController.1
 * JD-Core Version:    0.7.0.1
 */
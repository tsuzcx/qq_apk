package com.tencent.gdtad.api.motivevideo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.common.app.AppInterface;
import com.tencent.gdtad.views.videoceiling.GdtWebViewBuilder;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebView;
import org.json.JSONException;
import org.json.JSONObject;

class GdtMVEndcardWebController$1
  extends GdtWebViewBuilder
{
  GdtMVEndcardWebController$1(GdtMVEndcardWebController paramGdtMVEndcardWebController, Context paramContext, Activity paramActivity, Intent paramIntent, AppInterface paramAppInterface)
  {
    super(paramContext, paramActivity, paramIntent, paramAppInterface);
  }
  
  public void onPageFinished(WebView paramWebView, String paramString)
  {
    super.onPageFinished(paramWebView, paramString);
    long l1;
    long l2;
    if ((!this.a.b) && (!GdtMVEndcardWebController.a(this.a)) && (this.a.a))
    {
      l1 = System.currentTimeMillis();
      l2 = GdtMVEndcardWebController.a(this.a);
    }
    try
    {
      paramWebView = new JSONObject();
      paramWebView.put("cost_time", l1 - l2);
      GdtADFlyingStreamingReportHelper.a().a(1020031L, paramWebView);
      GdtMVEndcardWebController.a(this.a, true);
      GdtADFlyingStreamingReportHelper.a().a(2);
      return;
    }
    catch (JSONException paramWebView)
    {
      QLog.e("AbsWebView", 1, "reportWebEndCardLoadingEvent fail :" + paramWebView);
    }
  }
  
  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    this.a.e();
    QLog.i("AbsWebView", 1, "onReceivedError url = " + paramInt + ",description = " + paramString1 + ",failingUrl = " + paramString2);
    this.a.a();
    if ((!GdtMVEndcardWebController.a(this.a)) && (this.a.a))
    {
      GdtADFlyingStreamingReportHelper.a().a(1020017L);
      GdtMVEndcardWebController.a(this.a, true);
    }
  }
  
  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (GdtMVEndcardWebController.a(this.a, paramWebView, paramString)) {
      return true;
    }
    return a(paramWebView, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtMVEndcardWebController.1
 * JD-Core Version:    0.7.0.1
 */
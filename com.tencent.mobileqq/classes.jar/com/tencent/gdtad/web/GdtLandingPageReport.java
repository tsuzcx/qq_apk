package com.tencent.gdtad.web;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.ad.tangram.analysis.AdAnalysis;
import com.tencent.ad.tangram.analysis.AdAnalysisEvent;
import com.tencent.ad.tangram.analysis.AdAnalysisUtil;
import com.tencent.ad.tangram.protocol.gdt_analysis_event;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.open.base.http.HttpBaseUtil;
import java.lang.ref.WeakReference;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public final class GdtLandingPageReport
  implements GdtWebReportInterface
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private GdtWebReportPlugin jdField_a_of_type_ComTencentGdtadWebGdtWebReportPlugin;
  private WeakReference<Context> jdField_a_of_type_JavaLangRefWeakReference;
  private boolean jdField_a_of_type_Boolean;
  
  public GdtLandingPageReport(GdtWebReportPlugin paramGdtWebReportPlugin)
  {
    if (paramGdtWebReportPlugin == null) {
      return;
    }
    GdtLog.a("GdtLandingPageReport", " GdtLandingPageReport");
    this.jdField_a_of_type_ComTencentGdtadWebGdtWebReportPlugin = paramGdtWebReportPlugin;
  }
  
  private String a(long paramLong, String paramString1, String paramString2)
  {
    GdtLog.a("GdtLandingPageReport", " getScript== start ");
    Object localObject2 = "";
    if (this.jdField_a_of_type_ComTencentGdtadWebGdtWebReportPlugin != null) {
      localObject2 = GdtLandingPageConfig.a().a(this.jdField_a_of_type_ComTencentGdtadWebGdtWebReportPlugin.a());
    }
    GdtLog.a("GdtLandingPageReport", " getScript==" + (String)localObject2);
    if (TextUtils.isEmpty((CharSequence)localObject2))
    {
      GdtLog.a("GdtLandingPageReport", " getScript pagePerformance is close");
      paramString1 = "";
    }
    do
    {
      return paramString1;
      Object localObject1 = localObject2;
      if (!TextUtils.isEmpty(String.valueOf(paramLong))) {
        localObject1 = ((String)localObject2).replaceAll("__CLICK_TIME__", String.valueOf(paramLong));
      }
      localObject2 = localObject1;
      if (!TextUtils.isEmpty(paramString1)) {
        localObject2 = ((String)localObject1).replaceAll("__TRACE_ID__", paramString1);
      }
      paramString1 = (String)localObject2;
    } while (TextUtils.isEmpty(paramString2));
    return ((String)localObject2).replaceAll("__NET_LOG_REQ_ID__", paramString2);
  }
  
  private String a(String paramString)
  {
    String str2 = "";
    if (this.jdField_a_of_type_ComTencentGdtadWebGdtWebReportPlugin != null) {}
    for (Activity localActivity = this.jdField_a_of_type_ComTencentGdtadWebGdtWebReportPlugin.a();; localActivity = null)
    {
      String str1 = str2;
      if (localActivity != null)
      {
        str1 = str2;
        if (localActivity.getIntent() != null) {
          str1 = localActivity.getIntent().getStringExtra(paramString);
        }
      }
      Log.i("GdtLandingPageReport", "name = " + paramString + ", s = " + str1);
      return str1;
    }
  }
  
  private void a(CustomWebView paramCustomWebView, GdtLandingPageReport.WebviewEvaluateListener paramWebviewEvaluateListener)
  {
    if (paramCustomWebView == null)
    {
      GdtLog.d("GdtLandingPageReport", " webviewCheckPerformanceFuncExist webview is null");
      return;
    }
    a(paramCustomWebView, "typeof __TG_GET_PAGE_PERFORMANCE__ === \"function\"", 3, new GdtLandingPageReport.4(this, paramWebviewEvaluateListener));
  }
  
  private void a(CustomWebView paramCustomWebView, String paramString)
  {
    if (!GdtLandingPageConfig.a().a(this.jdField_a_of_type_JavaLangRefWeakReference)) {
      return;
    }
    if (paramCustomWebView == null)
    {
      GdtLog.d("GdtLandingPageReport", " webviewInjectScript webview is null");
      return;
    }
    AdThreadManager.INSTANCE.post(new GdtLandingPageReport.1(this, paramString, paramCustomWebView), 3);
  }
  
  private void a(CustomWebView paramCustomWebView, String paramString, int paramInt, GdtLandingPageReport.WebviewEvaluateListener paramWebviewEvaluateListener)
  {
    if ((paramCustomWebView == null) || (TextUtils.isEmpty(paramString))) {
      GdtLog.a("GdtLandingPageReport", " injectScript webview or script is null");
    }
    while ((!GdtLandingPageConfig.a().a(this.jdField_a_of_type_JavaLangRefWeakReference)) || (!a())) {
      return;
    }
    long l = System.currentTimeMillis();
    GdtLog.a("GdtLandingPageReport", " injectScript scene: " + paramInt + " 注入JS.");
    a(new GdtLandingPageReport.2(this, paramString, paramCustomWebView, paramInt, l, paramWebviewEvaluateListener));
  }
  
  private void a(CustomWebView paramCustomWebView, String paramString1, String paramString2)
  {
    if (paramCustomWebView == null) {
      GdtLog.d("GdtLandingPageReport", " webviewSupplyInject webview is null");
    }
    while ((!a()) || (!GdtLandingPageConfig.a().a(this.jdField_a_of_type_JavaLangRefWeakReference))) {
      return;
    }
    a(paramCustomWebView, new GdtLandingPageReport.5(this, paramCustomWebView, paramString2));
  }
  
  static void a(Runnable paramRunnable)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      paramRunnable.run();
      return;
    }
    AdThreadManager.INSTANCE.post(paramRunnable, 0);
  }
  
  private void a(String paramString)
  {
    GdtLog.a("GdtLandingPageReport", " report");
    try
    {
      paramString = new JSONObject(paramString);
      GdtLog.a("GdtLandingPageReport", " performanceJson: " + paramString);
      b(paramString.getJSONArray("event_report"));
      a(paramString.getJSONArray("rpt_report"));
      return;
    }
    catch (Exception paramString)
    {
      GdtLog.d("GdtLandingPageReport", " report.", paramString);
    }
  }
  
  private void a(JSONArray paramJSONArray)
  {
    GdtLog.a("GdtLandingPageReport", " rptBatchReport: " + paramJSONArray);
    if (JSONObject.NULL.equals(paramJSONArray)) {
      GdtLog.d("GdtLandingPageReport", " rptBatchReport data is null");
    }
    for (;;)
    {
      return;
      try
      {
        Object localObject1 = new JSONArray();
        int j = paramJSONArray.length();
        int i = 0;
        while (i < j)
        {
          ((JSONArray)localObject1).put(paramJSONArray.get(i));
          Object localObject2;
          if (((JSONArray)localObject1).length() < 20)
          {
            localObject2 = localObject1;
            if (i != j - 1) {}
          }
          else
          {
            localObject2 = new Bundle();
            JSONObject localJSONObject = new JSONObject();
            localJSONObject.putOpt("data", localObject1);
            ((Bundle)localObject2).putString("Postbody", localJSONObject.toString());
            ((Bundle)localObject2).putString("Referer", "h5.gdt.qq.com");
            HttpBaseUtil.a("https://rpt.gdt.qq.com/batch_landing_page", "POST", (Bundle)localObject2, null);
            localObject2 = new JSONArray();
          }
          i += 1;
          localObject1 = localObject2;
        }
        return;
      }
      catch (Exception paramJSONArray)
      {
        GdtLog.d("GdtLandingPageReport", " rptBatchReport exception.", paramJSONArray);
      }
    }
  }
  
  private boolean a()
  {
    String str1 = a("GdtWebReportQQ_ACTION_URL");
    String str2 = a("GdtWebReportQQ_TRACE_ID");
    return (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2));
  }
  
  private void b(JSONArray paramJSONArray)
  {
    GdtLog.a("GdtLandingPageReport", " eventReport: " + paramJSONArray);
    if (JSONObject.NULL.equals(paramJSONArray))
    {
      GdtLog.d("GdtLandingPageReport", " eventReport data is null");
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        int j = paramJSONArray.length();
        i = 0;
        if (i >= j) {
          break;
        }
        JSONObject localJSONObject = (JSONObject)paramJSONArray.get(i);
        int k = localJSONObject.getInt("eventId");
        long l = localJSONObject.optLong("duration");
        if (k != -2147483648) {
          a(k, l);
        }
      }
      catch (Exception paramJSONArray)
      {
        GdtLog.d("GdtLandingPageReport", " eventReport exception.", paramJSONArray);
        return;
      }
      i += 1;
    }
  }
  
  public void a()
  {
    c();
    a(1500000);
  }
  
  public void a(int paramInt)
  {
    a(paramInt, System.currentTimeMillis() - this.jdField_a_of_type_Long);
  }
  
  public void a(int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_JavaLangRefWeakReference == null) {}
    while ((!GdtLandingPageConfig.a().a(this.jdField_a_of_type_JavaLangRefWeakReference)) || (!a())) {
      return;
    }
    gdt_analysis_event localgdt_analysis_event = new gdt_analysis_event();
    AdAnalysisUtil.initEvent((Context)this.jdField_a_of_type_JavaLangRefWeakReference.get(), paramInt, localgdt_analysis_event);
    localgdt_analysis_event.duration = paramLong;
    AdAnalysisEvent localAdAnalysisEvent = new AdAnalysisEvent(localgdt_analysis_event, 102);
    GdtLog.a("GdtLandingPageReport", "reportEvent eventId =" + paramInt + "duration =" + localgdt_analysis_event.duration);
    AdAnalysis.INSTANCE.handleAsync(this.jdField_a_of_type_JavaLangRefWeakReference, localAdAnalysisEvent);
  }
  
  public void a(CustomWebView paramCustomWebView)
  {
    a(1500001);
    a(paramCustomWebView, "");
  }
  
  public boolean a(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (!a()) {}
    do
    {
      return false;
      if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentGdtadWebGdtWebReportPlugin != null) && (this.jdField_a_of_type_ComTencentGdtadWebGdtWebReportPlugin.a() != null) && ((paramLong == 8589934593L) || (paramLong == 8589934594L))) {
        a((CustomWebView)this.jdField_a_of_type_ComTencentGdtadWebGdtWebReportPlugin.a().get(), a("GdtWebReportQQ_TRACE_ID"), "");
      }
      GdtLog.a("GdtLandingPageReport", " handleEvent url = " + paramString + "==type ==" + paramLong);
      if ((GdtWebReportQQ.a(paramString)) && (this.jdField_a_of_type_Int == 0))
      {
        this.jdField_a_of_type_Int = 1;
        a(1500009);
      }
    } while ((this.jdField_a_of_type_Int != 1) || (paramLong != 8589934593L) || (GdtWebReportQQ.a(paramString)));
    a(1500010);
    this.jdField_a_of_type_Int = 2;
    return false;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentGdtadWebGdtWebReportPlugin != null) && (this.jdField_a_of_type_ComTencentGdtadWebGdtWebReportPlugin.a() != null) && (a())) {
      b((CustomWebView)this.jdField_a_of_type_ComTencentGdtadWebGdtWebReportPlugin.a().get());
    }
  }
  
  public void b(CustomWebView paramCustomWebView)
  {
    if (paramCustomWebView == null)
    {
      GdtLog.d("GdtLandingPageReport", " webviewGetPerformanceResult webview is null");
      return;
    }
    GdtLog.a("GdtLandingPageReport", " webviewGetPerformanceResult");
    a(paramCustomWebView, "__TG_GET_PAGE_PERFORMANCE__()", 2, new GdtLandingPageReport.3(this));
  }
  
  public void c()
  {
    GdtLog.a("GdtLandingPageReport", " init");
    if ((this.jdField_a_of_type_ComTencentGdtadWebGdtWebReportPlugin != null) && (this.jdField_a_of_type_ComTencentGdtadWebGdtWebReportPlugin.a() != null))
    {
      GdtLog.a("GdtLandingPageReport", " init success");
      this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(this.jdField_a_of_type_ComTencentGdtadWebGdtWebReportPlugin.a());
      this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentGdtadWebGdtWebReportPlugin.a().getIntent().getLongExtra("GdtWebReportQQ_CLICK_TIME", System.currentTimeMillis());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.web.GdtLandingPageReport
 * JD-Core Version:    0.7.0.1
 */
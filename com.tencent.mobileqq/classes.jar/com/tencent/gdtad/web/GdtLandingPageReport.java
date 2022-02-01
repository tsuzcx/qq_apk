package com.tencent.gdtad.web;

import android.app.Activity;
import android.content.Intent;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.ad.tangram.protocol.link_report.LinkReport.ReportBiz;
import com.tencent.ad.tangram.statistics.AdReporterForLinkEvent;
import com.tencent.ad.tangram.thread.AdThreadManager;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.gdtad.params.InitGdtContextParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Map;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONObject;

public final class GdtLandingPageReport
  implements GdtWebReportInterface
{
  private long a;
  private boolean b = false;
  private boolean c;
  private GdtWebReportPlugin d;
  private boolean e;
  private String f;
  
  public GdtLandingPageReport(GdtWebReportPlugin paramGdtWebReportPlugin)
  {
    if (paramGdtWebReportPlugin == null) {
      return;
    }
    GdtLog.a("GdtLandingPageReport", " GdtLandingPageReport");
    this.d = paramGdtWebReportPlugin;
  }
  
  private String a(long paramLong, String paramString1, String paramString2)
  {
    GdtLog.a("GdtLandingPageReport", " getScript== start ");
    if (this.d != null) {
      localObject1 = GdtLandingPageConfig.a().b(this.d.b());
    } else {
      localObject1 = "";
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(" getScript==");
    ((StringBuilder)localObject2).append((String)localObject1);
    GdtLog.a("GdtLandingPageReport", ((StringBuilder)localObject2).toString());
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      GdtLog.a("GdtLandingPageReport", " getScript pagePerformance is close");
      return "";
    }
    localObject2 = localObject1;
    if (!TextUtils.isEmpty(String.valueOf(paramLong))) {
      localObject2 = ((String)localObject1).replaceAll("__CLICK_TIME__", String.valueOf(paramLong));
    }
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(paramString1)) {
      localObject1 = ((String)localObject2).replaceAll("__TRACE_ID__", paramString1);
    }
    paramString1 = (String)localObject1;
    if (!TextUtils.isEmpty(paramString2)) {
      paramString1 = ((String)localObject1).replaceAll("__NET_LOG_REQ_ID__", paramString2);
    }
    return paramString1;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isDebugVersion())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("report eventId is ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append("costTime is");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append("isCgi ");
      ((StringBuilder)localObject).append(this.b);
      QLog.d("GdtLandingPageReport", 2, ((StringBuilder)localObject).toString());
    }
    ((IGdtAdAPI)QRoute.api(IGdtAdAPI.class)).initGdtContext(MobileQQ.sMobileQQ, new InitGdtContextParams());
    Object localObject = new link_report.LinkReport.ReportBiz();
    ((link_report.LinkReport.ReportBiz)localObject).cost_time = paramInt2;
    ((link_report.LinkReport.ReportBiz)localObject).bp = paramInt3;
    ((link_report.LinkReport.ReportBiz)localObject).wv_progress = 2;
    ((link_report.LinkReport.ReportBiz)localObject).click_req_type = 0;
    if (this.c) {
      ((link_report.LinkReport.ReportBiz)localObject).lp_type = 1;
    } else {
      ((link_report.LinkReport.ReportBiz)localObject).lp_type = 4;
    }
    ((link_report.LinkReport.ReportBiz)localObject).aid = c("GdtWebReportQQ_AD_ID");
    ((link_report.LinkReport.ReportBiz)localObject).pid = c("GdtWebReportQQ_POS_ID");
    ((link_report.LinkReport.ReportBiz)localObject).traceid = c("GdtWebReportQQ_TRACE_ID");
    AdReporterForLinkEvent.reportAsync(MobileQQ.sMobileQQ, paramInt1, null, (link_report.LinkReport.ReportBiz)localObject, null);
  }
  
  private void a(CustomWebView paramCustomWebView, String paramString, int paramInt, GdtLandingPageReport.WebviewEvaluateListener paramWebviewEvaluateListener)
  {
    if ((paramCustomWebView != null) && (!TextUtils.isEmpty(paramString)))
    {
      long l = System.currentTimeMillis();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" injectScript scene: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" 注入JS.");
      GdtLog.a("GdtLandingPageReport", localStringBuilder.toString());
      a(new -..Lambda.GdtLandingPageReport.swYlMymhIxQoDGerA7dGgnFpkLw(paramString, paramCustomWebView, paramInt, l, paramWebviewEvaluateListener));
      return;
    }
    GdtLog.a("GdtLandingPageReport", " injectScript webview or script is null");
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(" performanceJson: ");
      localStringBuilder.append(paramString);
      GdtLog.a("GdtLandingPageReport", localStringBuilder.toString());
      a(paramString.getJSONArray("event_report"));
      return;
    }
    catch (Exception paramString)
    {
      GdtLog.d("GdtLandingPageReport", " report.", paramString);
    }
  }
  
  private void a(JSONArray paramJSONArray)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" eventReport: ");
    ((StringBuilder)localObject).append(paramJSONArray);
    GdtLog.a("GdtLandingPageReport", ((StringBuilder)localObject).toString());
    if (JSONObject.NULL.equals(paramJSONArray))
    {
      GdtLog.d("GdtLandingPageReport", " eventReport data is null");
      return;
    }
    int i = 0;
    try
    {
      int j = paramJSONArray.length();
      while (i < j)
      {
        localObject = (JSONObject)paramJSONArray.get(i);
        int k = ((JSONObject)localObject).getInt("eventId");
        localObject = ((JSONObject)localObject).getJSONObject("biz");
        if (k != -2147483648) {
          a(k, (int)((JSONObject)localObject).optLong("cost_time"), (int)((JSONObject)localObject).optLong("bp", 0L));
        }
        i += 1;
      }
      return;
    }
    catch (Exception paramJSONArray)
    {
      GdtLog.d("GdtLandingPageReport", " eventReport exception.", paramJSONArray);
    }
  }
  
  private void b(String paramString)
  {
    AdThreadManager.INSTANCE.post(new -..Lambda.GdtLandingPageReport.GXZ1ubSp8vYt0PdsMwp6O747FKc(this, paramString), 3);
  }
  
  private String c(String paramString)
  {
    Object localObject = this.d;
    if (localObject != null) {
      localObject = ((GdtWebReportPlugin)localObject).b();
    } else {
      localObject = null;
    }
    if ((localObject != null) && (((Activity)localObject).getIntent() != null)) {
      localObject = ((Activity)localObject).getIntent().getStringExtra(paramString);
    } else {
      localObject = "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("name = ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(", s = ");
    localStringBuilder.append((String)localObject);
    Log.i("GdtLandingPageReport", localStringBuilder.toString());
    return localObject;
  }
  
  private boolean d()
  {
    return TextUtils.isEmpty(c("GdtWebReportQQ_TRACE_ID")) ^ true;
  }
  
  private boolean e()
  {
    GdtWebReportPlugin localGdtWebReportPlugin = this.d;
    return (localGdtWebReportPlugin != null) && (localGdtWebReportPlugin.a() != null);
  }
  
  public void a()
  {
    GdtLog.a("GdtLandingPageReport", " init");
    GdtWebReportPlugin localGdtWebReportPlugin = this.d;
    if ((localGdtWebReportPlugin != null) && (localGdtWebReportPlugin.b() != null))
    {
      GdtLog.a("GdtLandingPageReport", " init success");
      this.a = this.d.b().getIntent().getLongExtra("GdtWebReportQQ_CLICK_TIME", System.currentTimeMillis());
      this.c = this.d.b().getIntent().getBooleanExtra("GdtWebReportQQ_IS_H5", true);
      this.b = GdtWebReportQQ.a(this.d.b().getIntent().getStringExtra("GdtWebReportQQ_CLICK_URL"));
    }
  }
  
  public void a(CustomWebView paramCustomWebView)
  {
    if (paramCustomWebView == null)
    {
      GdtLog.d("GdtLandingPageReport", " webviewGetPerformanceResult webview is null");
      return;
    }
    GdtLog.a("GdtLandingPageReport", " webviewGetPerformanceResult");
    a(paramCustomWebView, "__TG_GET_PAGE_PERFORMANCE__()", 2, new -..Lambda.GdtLandingPageReport.ageohy0r3_eTvD9i1wK0izhBJbA(this));
  }
  
  public boolean a(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (!d()) {
      return false;
    }
    paramMap = new StringBuilder();
    paramMap.append(" handleEvent url = ");
    paramMap.append(paramString);
    paramMap.append("==type ==");
    paramMap.append(paramLong);
    GdtLog.a("GdtLandingPageReport", paramMap.toString());
    if ((e()) && ((paramLong == 8589934593L) || (paramLong == 8589934594L)) && (!GdtWebReportQQ.a(paramString)))
    {
      a((CustomWebView)this.d.a().get(), this.f, 1, null);
      paramMap = new StringBuilder();
      paramMap.append(" start inject url = ");
      paramMap.append(paramString);
      paramMap.append("  type ==");
      paramMap.append(paramLong);
      GdtLog.a("GdtLandingPageReport", paramMap.toString());
    }
    if ((paramLong == 8589934598L) && (!GdtWebReportQQ.a(paramString))) {
      c();
    }
    return false;
  }
  
  public void b()
  {
    if (!d()) {
      return;
    }
    a();
    a(4003005, (int)(System.currentTimeMillis() - this.a), 0);
    b("");
  }
  
  public void b(CustomWebView paramCustomWebView)
  {
    if (!d()) {
      return;
    }
    a(4003007, (int)(System.currentTimeMillis() - this.a), 0);
  }
  
  public void c()
  {
    if ((e()) && (d()) && (!this.e))
    {
      this.e = true;
      a((CustomWebView)this.d.a().get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.web.GdtLandingPageReport
 * JD-Core Version:    0.7.0.1
 */
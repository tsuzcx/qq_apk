package com.tencent.biz.pubaccount.weishi_new.operationh5.report;

import android.os.SystemClock;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportUtils;
import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter;
import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter.Builder;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

public class WSOperationH5BeaconReporter
{
  private static final Map<String, Long> a = new HashMap();
  private WSOperationH5ReportParams b;
  
  public WSOperationH5BeaconReporter(WSOperationH5ReportParams paramWSOperationH5ReportParams)
  {
    this.b = paramWSOperationH5ReportParams;
  }
  
  private static WSStatisticsReporter.Builder a(WSOperationH5ReportParams paramWSOperationH5ReportParams)
  {
    return g().addParams("feed_id", "").addParams("owner_id", "").addParams("action_id", "1000001").addExtParams(b(paramWSOperationH5ReportParams));
  }
  
  private static void a(WSStatisticsReporter.Builder paramBuilder, String paramString)
  {
    paramBuilder.build(paramString).report();
  }
  
  private static Map<String, String> b(WSOperationH5ReportParams paramWSOperationH5ReportParams)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("spid", paramWSOperationH5ReportParams.a());
    localHashMap.put("web_test_id ", paramWSOperationH5ReportParams.b());
    localHashMap.put("web_url", paramWSOperationH5ReportParams.c());
    localHashMap.put("share_scenes_from", paramWSOperationH5ReportParams.d());
    return localHashMap;
  }
  
  @NotNull
  private Long f()
  {
    Long localLong2 = (Long)a.get("web_active");
    Long localLong1 = Long.valueOf(0L);
    if (localLong2 != null) {
      localLong1 = Long.valueOf(SystemClock.elapsedRealtime() - localLong2.longValue());
    }
    return localLong1;
  }
  
  private static WSStatisticsReporter.Builder g()
  {
    return new WSStatisticsReporter.Builder().setSopName("web_active").setFlush(true);
  }
  
  public void a()
  {
    WSReportUtils.a("QQ_official_account");
    a.put("web_active", Long.valueOf(SystemClock.elapsedRealtime()));
    a(g().addParams("event_type", "1").addExtParams(b(this.b)), "gzh_pageview");
  }
  
  public void b()
  {
    Long localLong = f();
    a(g().addParams("event_type", "2").addParams("page_live_time", localLong.toString()).addExtParams(b(this.b)), "gzh_pageview");
  }
  
  public void c()
  {
    a(g().addParams("position", "web_active_exp").addExtParams(b(this.b)), "gzh_exposure");
  }
  
  public void d()
  {
    Long localLong = f();
    Map localMap = b(this.b);
    localMap.put("exp_duration", String.valueOf(localLong));
    a(a(this.b).addParams("position", "back").addExtParams(localMap), "gzh_click");
  }
  
  public void e()
  {
    Long localLong = f();
    Map localMap = b(this.b);
    localMap.put("exp_duration", String.valueOf(localLong));
    a(a(this.b).addParams("position", "back_homepage").addExtParams(localMap), "gzh_click");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.operationh5.report.WSOperationH5BeaconReporter
 * JD-Core Version:    0.7.0.1
 */
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
  private static final Map<String, Long> jdField_a_of_type_JavaUtilMap = new HashMap();
  private WSOperationH5ReportParams jdField_a_of_type_ComTencentBizPubaccountWeishi_newOperationh5ReportWSOperationH5ReportParams;
  
  public WSOperationH5BeaconReporter(WSOperationH5ReportParams paramWSOperationH5ReportParams)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newOperationh5ReportWSOperationH5ReportParams = paramWSOperationH5ReportParams;
  }
  
  private static WSStatisticsReporter.Builder a()
  {
    return new WSStatisticsReporter.Builder().setSopName("web_active").setFlush(true);
  }
  
  private static WSStatisticsReporter.Builder a(WSOperationH5ReportParams paramWSOperationH5ReportParams)
  {
    return a().addParams("feed_id", "").addParams("owner_id", "").addParams("action_id", "1000001").addExtParams(a(paramWSOperationH5ReportParams));
  }
  
  @NotNull
  private Long a()
  {
    Long localLong2 = (Long)jdField_a_of_type_JavaUtilMap.get("web_active");
    Long localLong1 = Long.valueOf(0L);
    if (localLong2 != null) {
      localLong1 = Long.valueOf(SystemClock.elapsedRealtime() - localLong2.longValue());
    }
    return localLong1;
  }
  
  private static Map<String, String> a(WSOperationH5ReportParams paramWSOperationH5ReportParams)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("spid", paramWSOperationH5ReportParams.a());
    localHashMap.put("web_test_id ", paramWSOperationH5ReportParams.b());
    localHashMap.put("web_url", paramWSOperationH5ReportParams.c());
    localHashMap.put("share_scenes_from", paramWSOperationH5ReportParams.d());
    return localHashMap;
  }
  
  private static void a(WSStatisticsReporter.Builder paramBuilder, String paramString)
  {
    paramBuilder.build(paramString).report();
  }
  
  public void a()
  {
    WSReportUtils.a("QQ_official_account");
    jdField_a_of_type_JavaUtilMap.put("web_active", Long.valueOf(SystemClock.elapsedRealtime()));
    a(a().addParams("event_type", "1").addExtParams(a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newOperationh5ReportWSOperationH5ReportParams)), "gzh_pagevisit");
  }
  
  public void b()
  {
    Long localLong = a();
    a(a().addParams("event_type", "2").addParams("page_live_time", localLong.toString()).addExtParams(a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newOperationh5ReportWSOperationH5ReportParams)), "gzh_pagevisit");
  }
  
  public void c()
  {
    a(a().addParams("position", "web_active_exp").addExtParams(a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newOperationh5ReportWSOperationH5ReportParams)), "gzh_exposure");
  }
  
  public void d()
  {
    Long localLong = a();
    Map localMap = a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newOperationh5ReportWSOperationH5ReportParams);
    localMap.put("exp_duration", String.valueOf(localLong));
    a(a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newOperationh5ReportWSOperationH5ReportParams).addParams("position", "back").addExtParams(localMap), "gzh_click");
  }
  
  public void e()
  {
    Long localLong = a();
    Map localMap = a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newOperationh5ReportWSOperationH5ReportParams);
    localMap.put("exp_duration", String.valueOf(localLong));
    a(a(this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newOperationh5ReportWSOperationH5ReportParams).addParams("position", "back_homepage").addExtParams(localMap), "gzh_click");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.operationh5.report.WSOperationH5BeaconReporter
 * JD-Core Version:    0.7.0.1
 */
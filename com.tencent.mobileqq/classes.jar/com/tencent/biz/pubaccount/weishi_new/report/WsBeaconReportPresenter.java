package com.tencent.biz.pubaccount.weishi_new.report;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiRequest;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSGzipCompressInfo;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSRequest;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSServiceTimeRecord;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.qphone.base.BaseConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class WsBeaconReportPresenter
{
  private static volatile WsBeaconReportPresenter jdField_a_of_type_ComTencentBizPubaccountWeishi_newReportWsBeaconReportPresenter;
  private HashMap<String, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  private long a(long paramLong1, long paramLong2)
  {
    long l = paramLong1;
    if (paramLong1 > paramLong2)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("request is more than ");
      localStringBuilder.append(paramLong2);
      Log.w("weishi-beacon", localStringBuilder.toString());
      l = paramLong2;
    }
    return l;
  }
  
  private WSStatisticsReporter.Builder a()
  {
    return new WSStatisticsReporter.Builder().setSendWeSeeServer(false).setFlush(true);
  }
  
  public static WsBeaconReportPresenter a()
  {
    try
    {
      if (jdField_a_of_type_ComTencentBizPubaccountWeishi_newReportWsBeaconReportPresenter == null) {
        try
        {
          if (jdField_a_of_type_ComTencentBizPubaccountWeishi_newReportWsBeaconReportPresenter == null) {
            jdField_a_of_type_ComTencentBizPubaccountWeishi_newReportWsBeaconReportPresenter = new WsBeaconReportPresenter();
          }
        }
        finally {}
      }
      WsBeaconReportPresenter localWsBeaconReportPresenter = jdField_a_of_type_ComTencentBizPubaccountWeishi_newReportWsBeaconReportPresenter;
      return localWsBeaconReportPresenter;
    }
    finally {}
  }
  
  private void a(WSStatisticsReporter.Builder paramBuilder, String paramString)
  {
    paramBuilder.build(paramString).report();
  }
  
  private void b(boolean paramBoolean, long paramLong, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("actWsAllDuration", String.valueOf(paramLong));
    localHashMap.put("sopName", String.valueOf(paramString1));
    if ("fullscreen_videoplay".equals(paramString1))
    {
      paramString1 = new StringBuilder();
      paramString1.append("");
      paramString1.append(paramString2);
      localHashMap.put("actWsPageFrom", paramString1.toString());
      WSLog.c("WsBeaconReportPresenter", "只在播放页上报actWsPageFrom");
    }
    localHashMap.put("type", "4");
    a(a().addParams(localHashMap), "actWsGzhPerformance");
    paramString1 = new StringBuilder();
    paramString1.append("event report: actWsGzhPerformance, position: ");
    paramString1.append((String)localHashMap.get("position"));
    paramString1.append(",params:");
    paramString1.append(localHashMap.toString());
    WSLog.d("WsBeaconReportPresenter", paramString1.toString());
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    Object localObject = new HashMap();
    ((HashMap)localObject).put("actWsFeedUserUsageDuration", String.valueOf(paramLong1));
    ((HashMap)localObject).put("actWsFeedListFirstReqDuration", String.valueOf(paramLong2));
    ((HashMap)localObject).put("actWsFeedCoverExposureNum", String.valueOf(paramInt1));
    if (paramBoolean1) {
      ((HashMap)localObject).put("actWsFeedIsJumpToPlayPage", "true");
    } else {
      ((HashMap)localObject).put("actWsFeedIsJumpToPlayPage", "false");
    }
    if (paramBoolean2) {
      ((HashMap)localObject).put("actWsFeedIsJumpToWeiShi", "true");
    } else {
      ((HashMap)localObject).put("actWsFeedIsJumpToWeiShi", "false");
    }
    if (paramInt2 == 2) {
      ((HashMap)localObject).put("actWsRecommendPageType", "1");
    }
    a(a().addParams((Map)localObject), "actWsGzhFeedUserConsumption");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reportFallListExit{ stayTime:");
    ((StringBuilder)localObject).append(paramLong1);
    ((StringBuilder)localObject).append(",loadTime:");
    ((StringBuilder)localObject).append(paramLong2);
    ((StringBuilder)localObject).append(",exposeCount:");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(",hasClickFuceng:");
    ((StringBuilder)localObject).append(paramBoolean1);
    ((StringBuilder)localObject).append(",hasClickWeishi:");
    ((StringBuilder)localObject).append(paramBoolean2);
    WSLog.c("WsBeaconReportPresenter", ((StringBuilder)localObject).toString());
    com.tencent.biz.pubaccount.weishi_new.util.WeishiScehmeUtil.a = false;
  }
  
  public void a(long paramLong, WeishiRequest paramWeishiRequest, int paramInt, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("actWSReqDuration", String.valueOf(paramLong));
    String str2 = "";
    if (paramWeishiRequest != null) {
      str1 = paramWeishiRequest.e();
    } else {
      str1 = "";
    }
    localHashMap.put("actWsReqName", str1);
    if (paramWeishiRequest != null) {
      str1 = String.valueOf(paramWeishiRequest.b());
    } else {
      str1 = "";
    }
    localHashMap.put("actWsReqScene", str1);
    if (paramWeishiRequest != null) {
      str1 = String.valueOf(paramWeishiRequest.d);
    } else {
      str1 = "";
    }
    localHashMap.put("actWsReqRspSize", str1);
    if (paramWeishiRequest != null) {
      str1 = String.valueOf(paramWeishiRequest.e);
    } else {
      str1 = "";
    }
    localHashMap.put("actWsReqSize", str1);
    String str1 = str2;
    if (paramWeishiRequest != null) {
      str1 = String.valueOf(paramWeishiRequest.c);
    }
    localHashMap.put("actWsReqNetDuration", str1);
    localHashMap.put("actWsReqErrorCode", String.valueOf(paramInt));
    localHashMap.put("actWsReqErrorMsg", paramString);
    paramString = "0";
    localHashMap.put("actWSAndNetFrameWorkType", "0");
    localHashMap.put("type", "5");
    if (paramWeishiRequest.e()) {
      paramString = "1";
    }
    localHashMap.put("actWSReqRemoveWns", paramString);
    a(a().addParams(localHashMap), "actWsGzhPerformance");
    paramWeishiRequest = new StringBuilder();
    paramWeishiRequest.append("event report: actWsGzhPerformance, position: ");
    paramWeishiRequest.append((String)localHashMap.get("position"));
    paramWeishiRequest.append(",params:");
    paramWeishiRequest.append(localHashMap.toString());
    WSLog.c("WsBeaconReportPresenter", paramWeishiRequest.toString());
  }
  
  public void a(long paramLong, WeishiRequest paramWeishiRequest, String paramString, boolean paramBoolean)
  {
    if (paramWeishiRequest == null) {
      return;
    }
    paramLong = a(paramLong, 20000L);
    HashMap localHashMap = new HashMap();
    localHashMap.put("actWSReqDuration", String.valueOf(paramLong));
    boolean bool = paramWeishiRequest.d();
    String str = "1";
    if (bool) {
      localObject = "1";
    } else {
      localObject = "0";
    }
    localHashMap.put("actWSRspIsCompress", localObject);
    if (paramWeishiRequest.e()) {
      localObject = "1";
    } else {
      localObject = "0";
    }
    localHashMap.put("actWSReqRemoveWns", localObject);
    localHashMap.put("actWsReqName", paramWeishiRequest.e());
    localHashMap.put("actWsReqScene", String.valueOf(paramWeishiRequest.b()));
    localHashMap.put("actWsReqRspSize", String.valueOf(paramWeishiRequest.d));
    localHashMap.put("actWsReqSize", String.valueOf(paramWeishiRequest.e));
    localHashMap.put("actWsReqNetDuration", String.valueOf(paramWeishiRequest.c));
    if (paramBoolean) {
      localObject = str;
    } else {
      localObject = "0";
    }
    localHashMap.put("actWSIsFirstRequest", localObject);
    localHashMap.put("actWSAndNetFrameWorkType", "0");
    Object localObject = paramWeishiRequest.a();
    localHashMap.put("actWSCompressSize", String.valueOf(((WSGzipCompressInfo)localObject).a()));
    localHashMap.put("actWSDecompressSize", String.valueOf(((WSGzipCompressInfo)localObject).b()));
    localHashMap.put("actWSDecompressRadio", String.valueOf(((WSGzipCompressInfo)localObject).a()));
    localHashMap.put("type", "2");
    if (paramBoolean)
    {
      localObject = (Long)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
      if (localObject != null) {
        paramLong += ((Long)localObject).longValue();
      }
      localHashMap.put("actWsAllDuration", String.valueOf(paramLong));
      b(true, paramLong, paramString, paramWeishiRequest.e());
    }
    a(a().addParams(localHashMap), "actWsGzhPerformance");
    paramWeishiRequest = new StringBuilder();
    paramWeishiRequest.append("event report: actWsGzhPerformance, position: ");
    paramWeishiRequest.append((String)localHashMap.get("position"));
    paramWeishiRequest.append(",params:");
    paramWeishiRequest.append(localHashMap.toString());
    WSLog.c("WsBeaconReportPresenter", paramWeishiRequest.toString());
  }
  
  public void a(WSRequest paramWSRequest)
  {
    if (paramWSRequest == null) {
      return;
    }
    Object localObject = paramWSRequest.getTimeRecord();
    long l = a(((WSServiceTimeRecord)localObject).m(), 20000L);
    HashMap localHashMap = new HashMap();
    localHashMap.put("actWSReqDuration", String.valueOf(l));
    localHashMap.put("actWSReqDurationIncludeCodec", String.valueOf(((WSServiceTimeRecord)localObject).d()));
    localHashMap.put("actReqEncodeDuration", String.valueOf(((WSServiceTimeRecord)localObject).a()));
    localHashMap.put("actDecodeWupDuration", String.valueOf(((WSServiceTimeRecord)localObject).e()));
    localHashMap.put("actDecodeExpDuration", String.valueOf(((WSServiceTimeRecord)localObject).f()));
    localHashMap.put("actDecodeHeaderDuration", String.valueOf(((WSServiceTimeRecord)localObject).g()));
    localHashMap.put("actDecodeRspDuration", String.valueOf(((WSServiceTimeRecord)localObject).j()));
    localHashMap.put("actDecompressDataDuration", String.valueOf(((WSServiceTimeRecord)localObject).i()));
    localHashMap.put("actDecompressRspDuration", String.valueOf(((WSServiceTimeRecord)localObject).h()));
    localHashMap.put("actWorkThreadDuration", String.valueOf(((WSServiceTimeRecord)localObject).k()));
    localHashMap.put("actSwitchUIThreadDuration", String.valueOf(((WSServiceTimeRecord)localObject).l()));
    localHashMap.put("actWsReqNetDuration", String.valueOf(((WSServiceTimeRecord)localObject).c()));
    String str = "1";
    localHashMap.put("actWSAndNetFrameWorkType", "1");
    if (paramWSRequest.isGzipCompress()) {
      localObject = "1";
    } else {
      localObject = "0";
    }
    localHashMap.put("actWSRspIsCompress", localObject);
    if (paramWSRequest.isRemoveWns()) {
      localObject = "1";
    } else {
      localObject = "0";
    }
    localHashMap.put("actWSReqRemoveWns", localObject);
    if (paramWSRequest.isFirst()) {
      localObject = "1";
    } else {
      localObject = "0";
    }
    localHashMap.put("actWSIsFirstRequest", localObject);
    if (paramWSRequest.isRefresh()) {
      localObject = str;
    } else {
      localObject = "0";
    }
    localHashMap.put("actWSIsRefreshRequest", localObject);
    localObject = paramWSRequest.getCompressInfo();
    localHashMap.put("actWSCompressSize", String.valueOf(((WSGzipCompressInfo)localObject).a()));
    localHashMap.put("actWSDecompressSize", String.valueOf(((WSGzipCompressInfo)localObject).b()));
    localHashMap.put("actWSDecompressRadio", String.valueOf(((WSGzipCompressInfo)localObject).a()));
    localHashMap.put("actWsReqSubId", paramWSRequest.getRequestSubId());
    localHashMap.put("actWsReqName", paramWSRequest.getOnlyCmd());
    localHashMap.put("actWsReqScene", String.valueOf(paramWSRequest.getRequestScene()));
    localHashMap.put("actWsReqRspSize", String.valueOf(paramWSRequest.respSize));
    localHashMap.put("actWsReqSize", String.valueOf(paramWSRequest.reqSize));
    localHashMap.put("type", "2");
    a(a().addParams(localHashMap), "actWsGzhPerformance");
    paramWSRequest = new StringBuilder();
    paramWSRequest.append("event report: actWsGzhPerformance, position: ");
    paramWSRequest.append((String)localHashMap.get("position"));
    paramWSRequest.append(",params:");
    paramWSRequest.append(localHashMap.toString());
    WSLog.c("WsBeaconReportPresenter", paramWSRequest.toString());
  }
  
  public void a(WSRequest paramWSRequest, int paramInt, String paramString)
  {
    if (paramWSRequest == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("actWSReqDuration", String.valueOf(paramWSRequest.getTimeRecord().m()));
    localHashMap.put("actWsReqName", paramWSRequest.getOnlyCmd());
    localHashMap.put("actWsReqScene", String.valueOf(paramWSRequest.getRequestScene()));
    localHashMap.put("actWsReqRspSize", String.valueOf(paramWSRequest.respSize));
    localHashMap.put("actWsReqSize", String.valueOf(paramWSRequest.reqSize));
    localHashMap.put("actWsReqNetDuration", String.valueOf(paramWSRequest.getTimeRecord().c()));
    localHashMap.put("actWsReqErrorCode", String.valueOf(paramInt));
    localHashMap.put("actWsReqErrorMsg", paramString);
    paramString = "1";
    localHashMap.put("actWSAndNetFrameWorkType", "1");
    localHashMap.put("type", "5");
    if (!paramWSRequest.isRemoveWns()) {
      paramString = "0";
    }
    localHashMap.put("actWSReqRemoveWns", paramString);
    localHashMap.put("actWsReqSubId", paramWSRequest.getRequestSubId());
    a(a().addParams(localHashMap), "actWsGzhPerformance");
    paramWSRequest = new StringBuilder();
    paramWSRequest.append("event report: actWsGzhPerformance, position: ");
    paramWSRequest.append((String)localHashMap.get("position"));
    paramWSRequest.append(",params:");
    paramWSRequest.append(localHashMap.toString());
    WSLog.c("WsBeaconReportPresenter", paramWSRequest.toString());
  }
  
  public void a(WSLaunchDeltaTimeCalculator paramWSLaunchDeltaTimeCalculator)
  {
    HashMap localHashMap2 = new HashMap();
    localHashMap2.put("type", "10");
    HashMap localHashMap1 = new HashMap();
    localHashMap1.put("click2ReqSendTime", String.valueOf(paramWSLaunchDeltaTimeCalculator.a()));
    localHashMap1.put("reqSend2RspReceiveTime", String.valueOf(paramWSLaunchDeltaTimeCalculator.b()));
    localHashMap1.put("handleRspDataTime", String.valueOf(paramWSLaunchDeltaTimeCalculator.c()));
    localHashMap1.put("handleFinish2CoverLoadStartTime", String.valueOf(paramWSLaunchDeltaTimeCalculator.d()));
    localHashMap1.put("firstPageCoverLoadTime", String.valueOf(paramWSLaunchDeltaTimeCalculator.e()));
    localHashMap1.put("launchTotalTime", String.valueOf(paramWSLaunchDeltaTimeCalculator.f()));
    a(a().addParams(localHashMap2).addExtParams(localHashMap1), "actWsGzhPerformance");
    paramWSLaunchDeltaTimeCalculator = new StringBuilder();
    paramWSLaunchDeltaTimeCalculator.append("reportLaunchTime event report: actWsGzhPerformance,params:");
    paramWSLaunchDeltaTimeCalculator.append(localHashMap1.toString());
    WSLog.c("WsBeaconReportPresenter", paramWSLaunchDeltaTimeCalculator.toString());
  }
  
  public void a(@Nullable String paramString1, @Nullable String paramString2)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      WSLog.d("WsBeaconReportPresenter", "reportLoadMoreViewExposed() failed. sopName is empty.");
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", "7");
    localHashMap.put("sopName", paramString1);
    if (paramString2 == null) {
      localObject = "";
    } else {
      localObject = paramString2;
    }
    localHashMap.put("actWsPageFrom", localObject);
    a(a().addParams(localHashMap), "actWsGzhPerformance");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reportLoadMoreViewExposed() sopName = ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", playScene = ");
    ((StringBuilder)localObject).append(paramString2);
    WSLog.b("WsBeaconReportPresenter", ((StringBuilder)localObject).toString());
  }
  
  public void a(@Nullable String paramString1, @Nullable String paramString2, int paramInt)
  {
    if (TextUtils.isEmpty(paramString1))
    {
      WSLog.d("WsBeaconReportPresenter", "reportLoadMore() failed. sopName is empty.");
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", "6");
    localHashMap.put("sopName", paramString1);
    if (paramString2 == null) {
      localObject = "";
    } else {
      localObject = paramString2;
    }
    localHashMap.put("actWsPageFrom", localObject);
    localHashMap.put("loadMoreTriggerCnt", Integer.toString(paramInt));
    a(a().addParams(localHashMap), "actWsGzhPerformance");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reportLoadMore() sopName = ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", playScene = ");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(", loadMoreTriggerCnt = ");
    ((StringBuilder)localObject).append(paramInt);
    WSLog.b("WsBeaconReportPresenter", ((StringBuilder)localObject).toString());
  }
  
  public void a(HashMap<String, String> paramHashMap)
  {
    Object localObject = new HashMap();
    ((HashMap)localObject).put("recommend_report_fail", new JSONObject(paramHashMap).toString());
    a(a().addParams((Map)localObject), "actWsGzhFeedPerformance");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reportRecommendReportFail：");
    ((StringBuilder)localObject).append(paramHashMap.toString());
    WSLog.a("WsBeaconReportPresenter", ((StringBuilder)localObject).toString());
  }
  
  public void a(boolean paramBoolean, long paramLong)
  {
    paramLong = a(paramLong, 5000L);
    Object localObject = new HashMap();
    ((HashMap)localObject).put(BaseConstants.RDM_NoChangeFailCode, "");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramLong);
    ((HashMap)localObject).put("actWsFeedPageLoadDuration", localStringBuilder.toString());
    a(a().addParams((Map)localObject), "actWsGzhFeedPerformance");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" actWsFeedPageLoadDuration=");
    ((StringBuilder)localObject).append(paramLong);
    Log.w("WsBeaconReportPresenter", ((StringBuilder)localObject).toString());
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString1, String paramString2)
  {
    paramLong = a(paramLong, 5000L);
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, Long.valueOf(paramLong));
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    localHashMap.put("actWsPageLoadDuration", String.valueOf(paramLong));
    localHashMap.put("sopName", String.valueOf(paramString1));
    localHashMap.put("actWsPageFrom", String.valueOf(paramString2));
    localHashMap.put("type", "1");
    a(a().addParams(localHashMap), "actWsGzhPerformance");
    paramString1 = new StringBuilder();
    paramString1.append("event report: actWsGzhPerformance, position: ");
    paramString1.append((String)localHashMap.get("position"));
    paramString1.append(",params:");
    paramString1.append(localHashMap.toString());
    WSLog.d("WsBeaconReportPresenter", paramString1.toString());
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, long paramLong1, long paramLong2, long paramLong3, String paramString1, String paramString2, int paramInt)
  {
    paramLong1 = a(paramLong1, 20000L);
    HashMap localHashMap = new HashMap();
    localHashMap.put("actWsPicReqDuration", String.valueOf(paramLong1));
    localHashMap.put("actWsPicBytes", String.valueOf(paramLong3));
    localHashMap.put("actWsPicDecodeDuration", String.valueOf(paramLong2));
    localHashMap.put("sopName", paramString2);
    localHashMap.put("actWsPicUrl", paramString1);
    localHashMap.put("feeds_index", String.valueOf(paramInt + 1));
    if (paramBoolean1) {
      paramString1 = "0";
    } else {
      paramString1 = "-1";
    }
    localHashMap.put("isPicLoadSuccess", paramString1);
    paramString2 = "1";
    if (paramBoolean2) {
      paramString1 = "1";
    } else {
      paramString1 = "0";
    }
    localHashMap.put("isPreload", paramString1);
    if (paramBoolean3) {
      paramString1 = paramString2;
    } else {
      paramString1 = "0";
    }
    localHashMap.put("isHitPicCache", paramString1);
    localHashMap.put("type", "3");
    a(a().addParams(localHashMap), "actWsGzhPerformance");
    paramString1 = new StringBuilder();
    paramString1.append("picLoad event report: actWsGzhPerformance, position: ");
    paramString1.append((String)localHashMap.get("position"));
    paramString1.append(",params:");
    paramString1.append(localHashMap.toString());
    WSLog.b("WsBeaconReportPresenter", paramString1.toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.report.WsBeaconReportPresenter
 * JD-Core Version:    0.7.0.1
 */
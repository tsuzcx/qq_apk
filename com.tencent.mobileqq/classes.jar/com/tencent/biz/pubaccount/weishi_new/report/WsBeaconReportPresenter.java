package com.tencent.biz.pubaccount.weishi_new.report;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.biz.pubaccount.weishi_new.image.WSPicLoader;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiRequest;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSGzipCompressInfo;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSRequest;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSServiceTimeRecord;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.mobileqq.kandian.base.image.ImageRequest;
import com.tencent.qphone.base.BaseConstants;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public class WsBeaconReportPresenter
{
  private static volatile WsBeaconReportPresenter b;
  private HashMap<String, Long> a = new HashMap();
  
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
  
  public static WsBeaconReportPresenter a()
  {
    try
    {
      if (b == null) {
        try
        {
          if (b == null) {
            b = new WsBeaconReportPresenter();
          }
        }
        finally {}
      }
      WsBeaconReportPresenter localWsBeaconReportPresenter = b;
      return localWsBeaconReportPresenter;
    }
    finally {}
  }
  
  private void a(WSStatisticsReporter.Builder paramBuilder, String paramString)
  {
    paramBuilder.build(paramString).report();
  }
  
  private WSStatisticsReporter.Builder b()
  {
    return new WSStatisticsReporter.Builder().setSendWeSeeServer(false).setFlush(true);
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
    a(b().addParams(localHashMap), "actWsGzhPerformance");
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
    a(b().addParams((Map)localObject), "actWsGzhFeedUserConsumption");
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
    com.tencent.biz.pubaccount.weishi_new.util.WeishiScehmeUtil.b = false;
  }
  
  public void a(long paramLong, WeishiRequest paramWeishiRequest, int paramInt, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("actWSReqDuration", String.valueOf(paramLong));
    String str2 = "";
    if (paramWeishiRequest != null) {
      str1 = paramWeishiRequest.j();
    } else {
      str1 = "";
    }
    localHashMap.put("actWsReqName", str1);
    if (paramWeishiRequest != null) {
      str1 = String.valueOf(paramWeishiRequest.k());
    } else {
      str1 = "";
    }
    localHashMap.put("actWsReqScene", str1);
    if (paramWeishiRequest != null) {
      str1 = String.valueOf(paramWeishiRequest.j);
    } else {
      str1 = "";
    }
    localHashMap.put("actWsReqRspSize", str1);
    if (paramWeishiRequest != null) {
      str1 = String.valueOf(paramWeishiRequest.k);
    } else {
      str1 = "";
    }
    localHashMap.put("actWsReqSize", str1);
    String str1 = str2;
    if (paramWeishiRequest != null) {
      str1 = String.valueOf(paramWeishiRequest.i);
    }
    localHashMap.put("actWsReqNetDuration", str1);
    localHashMap.put("actWsReqErrorCode", String.valueOf(paramInt));
    localHashMap.put("actWsReqErrorMsg", paramString);
    paramString = "0";
    localHashMap.put("actWSAndNetFrameWorkType", "0");
    localHashMap.put("type", "5");
    if (paramWeishiRequest.m()) {
      paramString = "1";
    }
    localHashMap.put("actWSReqRemoveWns", paramString);
    a(b().addParams(localHashMap), "actWsGzhPerformance");
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
    boolean bool = paramWeishiRequest.l();
    String str = "1";
    if (bool) {
      localObject = "1";
    } else {
      localObject = "0";
    }
    localHashMap.put("actWSRspIsCompress", localObject);
    if (paramWeishiRequest.m()) {
      localObject = "1";
    } else {
      localObject = "0";
    }
    localHashMap.put("actWSReqRemoveWns", localObject);
    localHashMap.put("actWsReqName", paramWeishiRequest.j());
    localHashMap.put("actWsReqScene", String.valueOf(paramWeishiRequest.k()));
    localHashMap.put("actWsReqRspSize", String.valueOf(paramWeishiRequest.j));
    localHashMap.put("actWsReqSize", String.valueOf(paramWeishiRequest.k));
    localHashMap.put("actWsReqNetDuration", String.valueOf(paramWeishiRequest.i));
    if (paramBoolean) {
      localObject = str;
    } else {
      localObject = "0";
    }
    localHashMap.put("actWSIsFirstRequest", localObject);
    localHashMap.put("actWSAndNetFrameWorkType", "0");
    Object localObject = paramWeishiRequest.n();
    localHashMap.put("actWSCompressSize", String.valueOf(((WSGzipCompressInfo)localObject).a()));
    localHashMap.put("actWSDecompressSize", String.valueOf(((WSGzipCompressInfo)localObject).b()));
    localHashMap.put("actWSDecompressRadio", String.valueOf(((WSGzipCompressInfo)localObject).c()));
    localHashMap.put("type", "2");
    if (paramBoolean)
    {
      localObject = (Long)this.a.get(paramString);
      if (localObject != null) {
        paramLong += ((Long)localObject).longValue();
      }
      localHashMap.put("actWsAllDuration", String.valueOf(paramLong));
      b(true, paramLong, paramString, paramWeishiRequest.j());
    }
    a(b().addParams(localHashMap), "actWsGzhPerformance");
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
    long l = a(((WSServiceTimeRecord)localObject).z(), 20000L);
    HashMap localHashMap = new HashMap();
    localHashMap.put("actWSReqDuration", String.valueOf(l));
    localHashMap.put("actWSReqDurationIncludeCodec", String.valueOf(((WSServiceTimeRecord)localObject).q()));
    localHashMap.put("actReqEncodeDuration", String.valueOf(((WSServiceTimeRecord)localObject).n()));
    localHashMap.put("actDecodeWupDuration", String.valueOf(((WSServiceTimeRecord)localObject).r()));
    localHashMap.put("actDecodeExpDuration", String.valueOf(((WSServiceTimeRecord)localObject).s()));
    localHashMap.put("actDecodeHeaderDuration", String.valueOf(((WSServiceTimeRecord)localObject).t()));
    localHashMap.put("actDecodeRspDuration", String.valueOf(((WSServiceTimeRecord)localObject).w()));
    localHashMap.put("actDecompressDataDuration", String.valueOf(((WSServiceTimeRecord)localObject).v()));
    localHashMap.put("actDecompressRspDuration", String.valueOf(((WSServiceTimeRecord)localObject).u()));
    localHashMap.put("actWorkThreadDuration", String.valueOf(((WSServiceTimeRecord)localObject).x()));
    localHashMap.put("actSwitchUIThreadDuration", String.valueOf(((WSServiceTimeRecord)localObject).y()));
    localHashMap.put("actWsReqNetDuration", String.valueOf(((WSServiceTimeRecord)localObject).p()));
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
    localHashMap.put("actWSDecompressRadio", String.valueOf(((WSGzipCompressInfo)localObject).c()));
    localHashMap.put("actWsReqSubId", paramWSRequest.getRequestSubId());
    localHashMap.put("actWsReqName", paramWSRequest.getOnlyCmd());
    localHashMap.put("actWsReqScene", String.valueOf(paramWSRequest.getRequestScene()));
    localHashMap.put("actWsReqRspSize", String.valueOf(paramWSRequest.respSize));
    localHashMap.put("actWsReqSize", String.valueOf(paramWSRequest.reqSize));
    localHashMap.put("type", "2");
    a(b().addParams(localHashMap), "actWsGzhPerformance");
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
    localHashMap.put("actWSReqDuration", String.valueOf(paramWSRequest.getTimeRecord().z()));
    localHashMap.put("actWsReqName", paramWSRequest.getOnlyCmd());
    localHashMap.put("actWsReqScene", String.valueOf(paramWSRequest.getRequestScene()));
    localHashMap.put("actWsReqRspSize", String.valueOf(paramWSRequest.respSize));
    localHashMap.put("actWsReqSize", String.valueOf(paramWSRequest.reqSize));
    localHashMap.put("actWsReqNetDuration", String.valueOf(paramWSRequest.getTimeRecord().p()));
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
    a(b().addParams(localHashMap), "actWsGzhPerformance");
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
    localHashMap1.put("click2ReqSendTime", String.valueOf(paramWSLaunchDeltaTimeCalculator.g()));
    localHashMap1.put("reqSend2RspReceiveTime", String.valueOf(paramWSLaunchDeltaTimeCalculator.h()));
    localHashMap1.put("handleRspDataTime", String.valueOf(paramWSLaunchDeltaTimeCalculator.i()));
    localHashMap1.put("handleFinish2CoverLoadStartTime", String.valueOf(paramWSLaunchDeltaTimeCalculator.j()));
    localHashMap1.put("firstPageCoverLoadTime", String.valueOf(paramWSLaunchDeltaTimeCalculator.k()));
    localHashMap1.put("launchTotalTime", String.valueOf(paramWSLaunchDeltaTimeCalculator.l()));
    a(b().addParams(localHashMap2).addExtParams(localHashMap1), "actWsGzhPerformance");
    paramWSLaunchDeltaTimeCalculator = new StringBuilder();
    paramWSLaunchDeltaTimeCalculator.append("reportLaunchTime event report: actWsGzhPerformance,params:");
    paramWSLaunchDeltaTimeCalculator.append(localHashMap1.toString());
    WSLog.c("WsBeaconReportPresenter", paramWSLaunchDeltaTimeCalculator.toString());
  }
  
  public void a(ImageRequest paramImageRequest, boolean paramBoolean1, boolean paramBoolean2, long paramLong, String paramString1, String paramString2, int paramInt)
  {
    long l4 = 0L;
    long l7;
    long l2;
    long l3;
    long l5;
    long l1;
    long l6;
    boolean bool;
    if (paramImageRequest != null)
    {
      l7 = paramImageRequest.j;
      long l8 = paramImageRequest.i;
      l2 = paramImageRequest.k - paramImageRequest.j;
      l3 = paramImageRequest.l;
      l5 = paramImageRequest.m;
      l1 = l4;
      if (paramImageRequest.n > 0L) {
        l1 = paramImageRequest.o - paramImageRequest.n;
      }
      l6 = paramImageRequest.o - paramImageRequest.h;
      localObject = paramImageRequest.s;
      bool = WSPicLoader.a().a(paramImageRequest.p);
      l4 = l7 - l8;
      paramImageRequest = (ImageRequest)localObject;
    }
    else
    {
      bool = false;
      paramImageRequest = "";
      l7 = 0L;
      l1 = l7;
      l2 = l1;
      l3 = l2;
      l6 = l3;
      l5 = l3;
      l3 = l2;
      l2 = l1;
      l1 = l7;
    }
    Object localObject = new HashMap();
    ((HashMap)localObject).put("actWsPicReqDuration", String.valueOf(a(l6, 20000L)));
    ((HashMap)localObject).put("actWsPicBytes", String.valueOf(paramLong));
    ((HashMap)localObject).put("actWsPicDecodeDuration", String.valueOf(l5));
    ((HashMap)localObject).put("sopName", paramString2);
    ((HashMap)localObject).put("actWsPicUrl", paramString1);
    ((HashMap)localObject).put("feeds_index", String.valueOf(paramInt + 1));
    paramString2 = "0";
    if (paramBoolean1) {
      paramString1 = "0";
    } else {
      paramString1 = "-1";
    }
    ((HashMap)localObject).put("isPicLoadSuccess", paramString1);
    if (paramBoolean2) {
      paramString1 = "1";
    } else {
      paramString1 = "0";
    }
    ((HashMap)localObject).put("isPreload", paramString1);
    paramString1 = paramString2;
    if (bool) {
      paramString1 = "1";
    }
    ((HashMap)localObject).put("isHitPicCache", paramString1);
    ((HashMap)localObject).put("type", "3");
    ((HashMap)localObject).put("subThreadWaitTime", String.valueOf(l4));
    ((HashMap)localObject).put("threadPoolWaitTime", String.valueOf(l2));
    ((HashMap)localObject).put("threadWaitTime", String.valueOf(l2 + l4));
    ((HashMap)localObject).put("downloadAndWriteFileTime", String.valueOf(l3));
    ((HashMap)localObject).put("mainThreadWaitTime", String.valueOf(l1));
    ((HashMap)localObject).put("contentType", paramImageRequest);
    a(b().addParams((Map)localObject), "actWsGzhPerformance");
    paramImageRequest = new StringBuilder();
    paramImageRequest.append("picLoad event report: actWsGzhPerformance, position: ");
    paramImageRequest.append((String)((HashMap)localObject).get("position"));
    paramImageRequest.append(",params:");
    paramImageRequest.append(((HashMap)localObject).toString());
    WSLog.e("WsBeaconReportPresenter", paramImageRequest.toString());
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
    a(b().addParams(localHashMap), "actWsGzhPerformance");
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
    a(b().addParams((Map)localObject), "actWsGzhFeedPerformance");
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
    a(b().addParams((Map)localObject), "actWsGzhFeedPerformance");
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" actWsFeedPageLoadDuration=");
    ((StringBuilder)localObject).append(paramLong);
    Log.w("WsBeaconReportPresenter", ((StringBuilder)localObject).toString());
  }
  
  public void a(boolean paramBoolean, long paramLong, String paramString1, String paramString2)
  {
    paramLong = a(paramLong, 5000L);
    this.a.put(paramString1, Long.valueOf(paramLong));
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    localHashMap.put("actWsPageLoadDuration", String.valueOf(paramLong));
    localHashMap.put("sopName", String.valueOf(paramString1));
    localHashMap.put("actWsPageFrom", String.valueOf(paramString2));
    localHashMap.put("type", "1");
    a(b().addParams(localHashMap), "actWsGzhPerformance");
    paramString1 = new StringBuilder();
    paramString1.append("event report: actWsGzhPerformance, position: ");
    paramString1.append((String)localHashMap.get("position"));
    paramString1.append(",params:");
    paramString1.append(localHashMap.toString());
    WSLog.d("WsBeaconReportPresenter", paramString1.toString());
  }
  
  public void b(@Nullable String paramString1, @Nullable String paramString2, int paramInt)
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
    localHashMap.put("actWsLoadMoreIndex", Integer.toString(paramInt));
    a(b().addParams(localHashMap), "actWsGzhPerformance");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("reportLoadMoreViewExposed() sopName = ");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(", playScene = ");
    ((StringBuilder)localObject).append(paramString2);
    ((StringBuilder)localObject).append(", lastFeedIndex = ");
    ((StringBuilder)localObject).append(paramInt);
    WSLog.b("WsBeaconReportPresenter", ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.report.WsBeaconReportPresenter
 * JD-Core Version:    0.7.0.1
 */
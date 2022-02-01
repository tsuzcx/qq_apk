package com.tencent.biz.pubaccount.weishi_new.report;

import android.util.Log;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiRequest;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSGzipCompressInfo;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSRequest;
import com.tencent.biz.pubaccount.weishi_new.net.common.WSServiceTimeRecord;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.qphone.base.BaseConstants;
import java.util.HashMap;
import org.json.JSONObject;

public class WsBeaconReportPresenter
{
  private static volatile WsBeaconReportPresenter jdField_a_of_type_ComTencentBizPubaccountWeishi_newReportWsBeaconReportPresenter;
  private HashMap<String, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  private long a(long paramLong1, long paramLong2)
  {
    if (paramLong1 > paramLong2)
    {
      Log.w("weishi-beacon", "request is more than " + paramLong2);
      return paramLong2;
    }
    return paramLong1;
  }
  
  private WSStatisticsReporter.Builder a()
  {
    return new WSStatisticsReporter.Builder().setSendWeSeeServer(false).setFlush(true);
  }
  
  /* Error */
  public static WsBeaconReportPresenter a()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 57	com/tencent/biz/pubaccount/weishi_new/report/WsBeaconReportPresenter:jdField_a_of_type_ComTencentBizPubaccountWeishi_newReportWsBeaconReportPresenter	Lcom/tencent/biz/pubaccount/weishi_new/report/WsBeaconReportPresenter;
    //   6: ifnonnull +25 -> 31
    //   9: ldc 2
    //   11: monitorenter
    //   12: getstatic 57	com/tencent/biz/pubaccount/weishi_new/report/WsBeaconReportPresenter:jdField_a_of_type_ComTencentBizPubaccountWeishi_newReportWsBeaconReportPresenter	Lcom/tencent/biz/pubaccount/weishi_new/report/WsBeaconReportPresenter;
    //   15: ifnonnull +13 -> 28
    //   18: new 2	com/tencent/biz/pubaccount/weishi_new/report/WsBeaconReportPresenter
    //   21: dup
    //   22: invokespecial 58	com/tencent/biz/pubaccount/weishi_new/report/WsBeaconReportPresenter:<init>	()V
    //   25: putstatic 57	com/tencent/biz/pubaccount/weishi_new/report/WsBeaconReportPresenter:jdField_a_of_type_ComTencentBizPubaccountWeishi_newReportWsBeaconReportPresenter	Lcom/tencent/biz/pubaccount/weishi_new/report/WsBeaconReportPresenter;
    //   28: ldc 2
    //   30: monitorexit
    //   31: getstatic 57	com/tencent/biz/pubaccount/weishi_new/report/WsBeaconReportPresenter:jdField_a_of_type_ComTencentBizPubaccountWeishi_newReportWsBeaconReportPresenter	Lcom/tencent/biz/pubaccount/weishi_new/report/WsBeaconReportPresenter;
    //   34: astore_0
    //   35: ldc 2
    //   37: monitorexit
    //   38: aload_0
    //   39: areturn
    //   40: astore_0
    //   41: ldc 2
    //   43: monitorexit
    //   44: aload_0
    //   45: athrow
    //   46: astore_0
    //   47: ldc 2
    //   49: monitorexit
    //   50: aload_0
    //   51: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   34	5	0	localWsBeaconReportPresenter	WsBeaconReportPresenter
    //   40	5	0	localObject1	Object
    //   46	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	28	40	finally
    //   28	31	40	finally
    //   41	44	40	finally
    //   3	12	46	finally
    //   31	35	46	finally
    //   44	46	46	finally
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
      localHashMap.put("actWsPageFrom", "" + paramString2);
      WSLog.c("WsBeaconReportPresenter", "只在播放页上报actWsPageFrom");
    }
    localHashMap.put("type", "4");
    a(a().addParams(localHashMap), "actWsGzhPerformance");
    WSLog.d("WsBeaconReportPresenter", "event report: actWsGzhPerformance, position: " + (String)localHashMap.get("position") + ",params:" + localHashMap.toString());
  }
  
  public void a(long paramLong1, long paramLong2, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("actWsFeedUserUsageDuration", String.valueOf(paramLong1));
    localHashMap.put("actWsFeedListFirstReqDuration", String.valueOf(paramLong2));
    localHashMap.put("actWsFeedCoverExposureNum", String.valueOf(paramInt1));
    if (paramBoolean1)
    {
      localHashMap.put("actWsFeedIsJumpToPlayPage", "true");
      if (!paramBoolean2) {
        break label188;
      }
      localHashMap.put("actWsFeedIsJumpToWeiShi", "true");
    }
    for (;;)
    {
      if (paramInt2 == 2) {
        localHashMap.put("actWsRecommendPageType", "1");
      }
      a(a().addParams(localHashMap), "actWsGzhFeedUserConsumption");
      WSLog.c("WsBeaconReportPresenter", "reportFallListExit{ stayTime:" + paramLong1 + ",loadTime:" + paramLong2 + ",exposeCount:" + paramInt1 + ",hasClickFuceng:" + paramBoolean1 + ",hasClickWeishi:" + paramBoolean2);
      com.tencent.biz.pubaccount.weishi_new.util.WeishiScehmeUtil.a = false;
      return;
      localHashMap.put("actWsFeedIsJumpToPlayPage", "false");
      break;
      label188:
      localHashMap.put("actWsFeedIsJumpToWeiShi", "false");
    }
  }
  
  public void a(long paramLong, WeishiRequest paramWeishiRequest, int paramInt, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("actWSReqDuration", String.valueOf(paramLong));
    String str;
    if (paramWeishiRequest != null)
    {
      str = paramWeishiRequest.e();
      localHashMap.put("actWsReqName", str);
      if (paramWeishiRequest == null) {
        break label243;
      }
      str = String.valueOf(paramWeishiRequest.b());
      label54:
      localHashMap.put("actWsReqScene", str);
      if (paramWeishiRequest == null) {
        break label250;
      }
      str = String.valueOf(paramWeishiRequest.d);
      label77:
      localHashMap.put("actWsReqRspSize", str);
      if (paramWeishiRequest == null) {
        break label257;
      }
      str = String.valueOf(paramWeishiRequest.e);
      label100:
      localHashMap.put("actWsReqSize", str);
      if (paramWeishiRequest == null) {
        break label264;
      }
    }
    label257:
    label264:
    for (paramWeishiRequest = String.valueOf(paramWeishiRequest.c);; paramWeishiRequest = "")
    {
      localHashMap.put("actWsReqNetDuration", paramWeishiRequest);
      localHashMap.put("actWsReqErrorCode", String.valueOf(paramInt));
      localHashMap.put("actWsReqErrorMsg", paramString);
      localHashMap.put("actWSAndNetFrameWorkType", "0");
      localHashMap.put("type", "5");
      a(a().addParams(localHashMap), "actWsGzhPerformance");
      WSLog.c("WsBeaconReportPresenter", "event report: actWsGzhPerformance, position: " + (String)localHashMap.get("position") + ",params:" + localHashMap.toString());
      return;
      str = "";
      break;
      label243:
      str = "";
      break label54;
      label250:
      str = "";
      break label77;
      str = "";
      break label100;
    }
  }
  
  public void a(long paramLong, WeishiRequest paramWeishiRequest, String paramString, boolean paramBoolean)
  {
    if (paramWeishiRequest == null) {
      return;
    }
    paramLong = a(paramLong, 20000L);
    HashMap localHashMap = new HashMap();
    localHashMap.put("actWSReqDuration", String.valueOf(paramLong));
    Object localObject;
    if (paramWeishiRequest.d())
    {
      localObject = "1";
      localHashMap.put("actWSRspIsCompress", localObject);
      if (!paramWeishiRequest.e()) {
        break label360;
      }
      localObject = "1";
      label67:
      localHashMap.put("actWSReqRemoveWns", localObject);
      localHashMap.put("actWsReqName", paramWeishiRequest.e());
      localHashMap.put("actWsReqScene", String.valueOf(paramWeishiRequest.b()));
      localHashMap.put("actWsReqRspSize", String.valueOf(paramWeishiRequest.d));
      localHashMap.put("actWsReqSize", String.valueOf(paramWeishiRequest.e));
      localHashMap.put("actWsReqNetDuration", String.valueOf(paramWeishiRequest.c));
      if (!paramBoolean) {
        break label367;
      }
      localObject = "1";
      label158:
      localHashMap.put("actWSIsFirstRequest", localObject);
      localHashMap.put("actWSAndNetFrameWorkType", "0");
      localObject = paramWeishiRequest.a();
      localHashMap.put("actWSCompressSize", String.valueOf(((WSGzipCompressInfo)localObject).a()));
      localHashMap.put("actWSDecompressSize", String.valueOf(((WSGzipCompressInfo)localObject).b()));
      localHashMap.put("actWSDecompressRadio", String.valueOf(((WSGzipCompressInfo)localObject).a()));
      localHashMap.put("type", "2");
      if (paramBoolean)
      {
        localObject = (Long)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
        if (localObject != null) {
          break label374;
        }
      }
    }
    for (;;)
    {
      localHashMap.put("actWsAllDuration", String.valueOf(paramLong));
      b(true, paramLong, paramString, paramWeishiRequest.e());
      a(a().addParams(localHashMap), "actWsGzhPerformance");
      WSLog.c("WsBeaconReportPresenter", "event report: actWsGzhPerformance, position: " + (String)localHashMap.get("position") + ",params:" + localHashMap.toString());
      return;
      localObject = "0";
      break;
      label360:
      localObject = "0";
      break label67;
      label367:
      localObject = "0";
      break label158;
      label374:
      paramLong += ((Long)localObject).longValue();
    }
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
    localHashMap.put("actWSAndNetFrameWorkType", "1");
    if (paramWSRequest.isGzipCompress())
    {
      localObject = "1";
      localHashMap.put("actWSRspIsCompress", localObject);
      if (!paramWSRequest.isRemoveWns()) {
        break label530;
      }
      localObject = "1";
      label273:
      localHashMap.put("actWSReqRemoveWns", localObject);
      if (!paramWSRequest.isFirst()) {
        break label537;
      }
      localObject = "1";
      label294:
      localHashMap.put("actWSIsFirstRequest", localObject);
      if (!paramWSRequest.isRefresh()) {
        break label544;
      }
    }
    label530:
    label537:
    label544:
    for (localObject = "1";; localObject = "0")
    {
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
      WSLog.c("WsBeaconReportPresenter", "event report: actWsGzhPerformance, position: " + (String)localHashMap.get("position") + ",params:" + localHashMap.toString());
      return;
      localObject = "0";
      break;
      localObject = "0";
      break label273;
      localObject = "0";
      break label294;
    }
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
    localHashMap.put("actWSAndNetFrameWorkType", "1");
    localHashMap.put("type", "5");
    a(a().addParams(localHashMap), "actWsGzhPerformance");
    WSLog.c("WsBeaconReportPresenter", "event report: actWsGzhPerformance, position: " + (String)localHashMap.get("position") + ",params:" + localHashMap.toString());
  }
  
  public void a(HashMap<String, String> paramHashMap)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("recommend_report_fail", new JSONObject(paramHashMap).toString());
    a(a().addParams(localHashMap), "actWsGzhFeedPerformance");
    WSLog.a("WsBeaconReportPresenter", "reportRecommendReportFail：" + paramHashMap.toString());
  }
  
  public void a(boolean paramBoolean, long paramLong)
  {
    paramLong = a(paramLong, 5000L);
    HashMap localHashMap = new HashMap();
    localHashMap.put(BaseConstants.RDM_NoChangeFailCode, "");
    localHashMap.put("actWsFeedPageLoadDuration", "" + paramLong);
    a(a().addParams(localHashMap), "actWsGzhFeedPerformance");
    Log.w("WsBeaconReportPresenter", " actWsFeedPageLoadDuration=" + paramLong);
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
    WSLog.d("WsBeaconReportPresenter", "event report: actWsGzhPerformance, position: " + (String)localHashMap.get("position") + ",params:" + localHashMap.toString());
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
    if (paramBoolean1)
    {
      paramString1 = "0";
      localHashMap.put("isPicLoadSuccess", paramString1);
      if (!paramBoolean2) {
        break label237;
      }
      paramString1 = "1";
      label126:
      localHashMap.put("isPreload", paramString1);
      if (!paramBoolean3) {
        break label244;
      }
    }
    label237:
    label244:
    for (paramString1 = "1";; paramString1 = "0")
    {
      localHashMap.put("isHitPicCache", paramString1);
      localHashMap.put("type", "3");
      a(a().addParams(localHashMap), "actWsGzhPerformance");
      WSLog.b("WsBeaconReportPresenter", "event report: actWsGzhPerformance, position: " + (String)localHashMap.get("position") + ",params:" + localHashMap.toString());
      return;
      paramString1 = "-1";
      break;
      paramString1 = "0";
      break label126;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.report.WsBeaconReportPresenter
 * JD-Core Version:    0.7.0.1
 */
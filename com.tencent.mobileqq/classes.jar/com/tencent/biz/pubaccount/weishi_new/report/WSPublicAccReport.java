package com.tencent.biz.pubaccount.weishi_new.report;

import UserGrowth.stOpVideo;
import UserGrowth.stReportItem;
import UserGrowth.stSimpleMetaFeed;
import com.tencent.biz.pubaccount.weishi_new.push.IWSPushBaseStrategy;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushPreloadModel;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushStrategyInfo;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import smn;
import snb;
import snf;

public class WSPublicAccReport
{
  private static final String SCENE_FROM_PUBLIC_ACC = "QQ_official_account";
  private static final String SCENE_FROM_TRENDS_TAB = "weishi_share_trendstab";
  private static final String SOP_NAME_FEEDS = "feeds";
  private static final String SOP_NAME_VIDEO_PLAY = "fullscreen_videoplay";
  private static volatile WSPublicAccReport instance;
  private static long sPublicAccEnterTime;
  private static long sToForegroundTime;
  private static long sTrendsTabEnterTime;
  private String mPushId;
  private String mTestId;
  
  private void baseActionReport(String paramString1, String paramString2, Map<String, String> paramMap, String paramString3)
  {
    baseActionReport(paramString1, paramString2, paramMap, null, paramString3);
  }
  
  private void baseActionReport(String paramString1, String paramString2, Map<String, String> paramMap1, Map<String, String> paramMap2, String paramString3)
  {
    new WSStatisticsReporter.Builder().addParams(paramMap1).addExtParams(paramMap2).setSceneFrom("QQ_official_account").setSopName(paramString2).setTestId(this.mTestId).setPushId(this.mPushId).setOperationId(paramString3).setFlush(true).build(paramString1).report();
  }
  
  private Map<String, String> getFeedsBaseParams(String paramString, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    if (paramInt != 0) {
      localHashMap.put("action_id", String.valueOf(paramInt));
    }
    localHashMap.put("position", paramString);
    localHashMap.put("feed_id", "");
    localHashMap.put("owner_id", "");
    return localHashMap;
  }
  
  private Map<String, String> getFeedsItemReportExtMap(stSimpleMetaFeed paramstSimpleMetaFeed, stReportItem paramstReportItem)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("cardtype", String.valueOf(paramstReportItem.card_type));
    localHashMap.put("poolType", String.valueOf(paramstReportItem.pool_type));
    localHashMap.put("ratioW", String.valueOf(paramstReportItem.ratioW));
    localHashMap.put("ratioH", String.valueOf(paramstReportItem.ratioH));
    localHashMap.put("isFullSpan", String.valueOf(paramstReportItem.isFullSpan));
    localHashMap.put("type", String.valueOf(paramstReportItem.video_type));
    String str = "";
    paramstReportItem = str;
    if (paramstSimpleMetaFeed != null)
    {
      paramstReportItem = str;
      if (paramstSimpleMetaFeed.opVideo != null) {
        paramstReportItem = String.valueOf(paramstSimpleMetaFeed.opVideo.videoType);
      }
    }
    localHashMap.put("opvideo_type", paramstReportItem);
    localHashMap.put("cover_type", snf.a(paramstSimpleMetaFeed));
    return localHashMap;
  }
  
  public static WSPublicAccReport getInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new WSPublicAccReport();
      }
      return instance;
    }
    finally {}
  }
  
  private void publicAccActionReport(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, long paramLong, int paramInt3, Map<String, String> paramMap)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("event_type", paramString1);
    localHashMap.put("push_count", String.valueOf(paramInt1));
    localHashMap.put("row_key", snf.b());
    localHashMap.put("push_extra", paramString2);
    localHashMap.put("app_extra", "");
    localHashMap.put("push_entry", paramString3);
    localHashMap.put("click_to", String.valueOf(paramInt2));
    localHashMap.put("app_live_time", String.valueOf(paramLong));
    localHashMap.put("operation_or_not", String.valueOf(paramInt3));
    baseActionReport("gzh_action", "", localHashMap, paramMap, "");
  }
  
  private void trendsTabActionReport(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, long paramLong, int paramInt3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("event_type", paramString1);
    localHashMap.put("push_count", String.valueOf(paramInt1));
    localHashMap.put("row_key", snf.b());
    localHashMap.put("push_extra", paramString2);
    localHashMap.put("app_extra", "");
    localHashMap.put("push_entry", paramString3);
    localHashMap.put("click_to", String.valueOf(paramInt2));
    localHashMap.put("app_live_time", String.valueOf(paramLong));
    localHashMap.put("operation_or_not", String.valueOf(paramInt3));
    new WSStatisticsReporter.Builder().addParams(localHashMap).setSceneFrom("weishi_share_trendstab").setSopName("").setTestId(this.mTestId).setPushId(this.mPushId).setOperationId("").setFlush(true).build("gzh_action").report();
  }
  
  public void backgroundPublicAccReport()
  {
    long l = 0L;
    this.mTestId = snf.a(1);
    if (sToForegroundTime < 1L) {
      sToForegroundTime = sPublicAccEnterTime;
    }
    if (sToForegroundTime > 0L) {
      l = System.currentTimeMillis() - sToForegroundTime;
    }
    publicAccActionReport("3", 0, "", "", 0, l, 0, null);
  }
  
  public void closePublicAccReport(int paramInt)
  {
    long l = 0L;
    this.mTestId = snf.a(1);
    if (sToForegroundTime > 0L) {
      l = System.currentTimeMillis() - sToForegroundTime;
    }
    for (;;)
    {
      publicAccActionReport("2", 0, "", "", 0, l, paramInt, null);
      this.mPushId = "";
      return;
      if (sPublicAccEnterTime > 0L) {
        l = System.currentTimeMillis() - sPublicAccEnterTime;
      }
    }
  }
  
  public void enterPublicAccReport(WSRedDotPushMsg paramWSRedDotPushMsg, int paramInt)
  {
    int i = 1;
    sPublicAccEnterTime = System.currentTimeMillis();
    sToForegroundTime = sPublicAccEnterTime;
    WSStatisticsBaseCollector.setSessionId(String.valueOf(sPublicAccEnterTime));
    WSStatisticsBaseCollector.setSessionStamp(String.valueOf(sPublicAccEnterTime));
    this.mTestId = snf.a(1);
    Object localObject = "";
    String str1 = "2";
    HashMap localHashMap = new HashMap();
    this.mPushId = "";
    if (paramWSRedDotPushMsg != null)
    {
      this.mPushId = paramWSRedDotPushMsg.mPushId;
      String str2 = paramWSRedDotPushMsg.mMsgData;
      localObject = str2;
      if ((paramWSRedDotPushMsg.mStrategyInfo instanceof WSPushStrategyInfo))
      {
        paramWSRedDotPushMsg = ((WSPushStrategyInfo)paramWSRedDotPushMsg.mStrategyInfo).mWSPushPreloadModel;
        localObject = str2;
        if (paramWSRedDotPushMsg != null)
        {
          if (!paramWSRedDotPushMsg.a) {
            break label182;
          }
          paramWSRedDotPushMsg = String.valueOf(1);
          localHashMap.put("preload_status", paramWSRedDotPushMsg);
          localObject = str2;
        }
      }
    }
    paramWSRedDotPushMsg = str1;
    if (snf.a(snf.a())) {
      paramWSRedDotPushMsg = "1";
    }
    if (paramInt == 3) {
      paramInt = i;
    }
    for (;;)
    {
      publicAccActionReport("1", snf.a(), (String)localObject, paramWSRedDotPushMsg, paramInt, 0L, 0, localHashMap);
      return;
      label182:
      paramWSRedDotPushMsg = String.valueOf(0);
      break;
    }
  }
  
  public void enterTrendsTabReport(WSRedDotPushMsg paramWSRedDotPushMsg, boolean paramBoolean)
  {
    sTrendsTabEnterTime = System.currentTimeMillis();
    WSStatisticsBaseCollector.setSessionId(String.valueOf(sTrendsTabEnterTime));
    WSStatisticsBaseCollector.setSessionStamp(String.valueOf(sTrendsTabEnterTime));
    this.mTestId = snf.a(6);
    String str = "";
    this.mPushId = "";
    int i;
    if ((paramWSRedDotPushMsg != null) && (paramWSRedDotPushMsg.mStrategyInfo != null))
    {
      this.mPushId = paramWSRedDotPushMsg.mPushId;
      str = paramWSRedDotPushMsg.mMsgData;
      i = paramWSRedDotPushMsg.mStrategyInfo.getType();
      paramWSRedDotPushMsg = str;
      if (!paramBoolean) {
        break label113;
      }
    }
    label113:
    for (str = "1";; str = "2")
    {
      trendsTabActionReport("1", 0, paramWSRedDotPushMsg, str, i, 0L, 0);
      return;
      i = 2;
      paramWSRedDotPushMsg = str;
      break;
    }
  }
  
  public void feedsItemForPushReport(String paramString, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("position", "");
    localHashMap.put("feed_id", "");
    localHashMap.put("owner_id", "");
    if (paramInt != 0) {
      localHashMap.put("action_id", String.valueOf(paramInt));
    }
    baseActionReport(paramString, "feeds", localHashMap, new HashMap(), "");
  }
  
  public void feedsItemReport(String paramString1, String paramString2, stSimpleMetaFeed paramstSimpleMetaFeed, stReportItem paramstReportItem, int paramInt)
  {
    this.mTestId = paramString2;
    paramString2 = new HashMap();
    paramString2.put("position", "feeds_video" + paramstReportItem.upos);
    paramString2.put("feed_id", paramstReportItem.feedid);
    paramString2.put("owner_id", paramstReportItem.authorid);
    if (paramInt != 0) {
      paramString2.put("action_id", String.valueOf(paramInt));
    }
    baseActionReport(paramString1, "feeds", paramString2, getFeedsItemReportExtMap(paramstSimpleMetaFeed, paramstReportItem), "");
  }
  
  public void foregroundPublicAccReport()
  {
    this.mTestId = snf.a(1);
    sToForegroundTime = System.currentTimeMillis();
    WSStatisticsBaseCollector.setSessionStamp(String.valueOf(sToForegroundTime));
    publicAccActionReport("4", 0, "", "", 0, 0L, 0, null);
  }
  
  public void reportClickRichBlockPop(int paramInt1, int paramInt2)
  {
    this.mTestId = snf.a(1);
    baseActionReport("gzh_click", "feeds", getFeedsBaseParams("popup", paramInt1), String.valueOf(paramInt2));
  }
  
  public void reportDownload(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.mTestId = snf.a(1);
    HashMap localHashMap = new HashMap();
    localHashMap.put("position", String.valueOf(paramInt1));
    localHashMap.put("event_type", String.valueOf(paramInt2));
    localHashMap.put("dl_status", String.valueOf(paramInt3));
    localHashMap.put("dl_method", String.valueOf(paramInt4));
    localHashMap.put("install_status", String.valueOf(paramInt5));
    snb.c("beacon-download", paramInt1 + " - " + paramInt2 + " - " + paramInt3 + " - " + paramInt4 + " - " + paramInt5);
    baseActionReport("gzh_download", "", localHashMap, "");
  }
  
  public void reportExposeRichBlockPop(int paramInt)
  {
    this.mTestId = snf.a(1);
    baseActionReport("gzh_exposure", "feeds", getFeedsBaseParams("popup", 0), String.valueOf(paramInt));
  }
  
  public void reportFallList(HashMap<Integer, stSimpleMetaFeed> paramHashMap)
  {
    if (paramHashMap.size() > 0)
    {
      paramHashMap = paramHashMap.entrySet().iterator();
      while (paramHashMap.hasNext())
      {
        Object localObject2 = (Map.Entry)paramHashMap.next();
        Object localObject1 = (Integer)((Map.Entry)localObject2).getKey();
        localObject2 = (stSimpleMetaFeed)((Map.Entry)localObject2).getValue();
        localObject1 = smn.a((stSimpleMetaFeed)localObject2, ((Integer)localObject1).intValue());
        if ((((stReportItem)localObject1).video_type != 1) && (((stReportItem)localObject1).video_type != 6)) {
          feedsItemReport("gzh_exposure", snf.a(1), (stSimpleMetaFeed)localObject2, (stReportItem)localObject1, 0);
        }
      }
    }
  }
  
  public void reportMsgEntry(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    this.mTestId = snf.a(4);
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", String.valueOf(paramInt1));
    baseActionReport(paramString, "feeds", getFeedsBaseParams("msg_extry", paramInt2), localHashMap, String.valueOf(paramInt3));
  }
  
  public void reportOperationCard(String paramString, int paramInt1, int paramInt2)
  {
    this.mTestId = snf.a(1);
    baseActionReport(paramString, "feeds", getFeedsBaseParams("opcard", paramInt1), String.valueOf(paramInt2));
  }
  
  public void reportPublicAccDataExposure(String paramString1, String paramString2, int paramInt1, int paramInt2, int paramInt3)
  {
    HashMap localHashMap1 = new HashMap();
    localHashMap1.put("preload_status", String.valueOf(paramInt1));
    localHashMap1.put("feeds_list_type", String.valueOf(paramInt2));
    localHashMap1.put("preload_count", String.valueOf(paramInt3));
    HashMap localHashMap2 = new HashMap();
    localHashMap2.put("position", "feeds_data");
    localHashMap2.put("feed_id", paramString1);
    localHashMap2.put("owner_id", paramString2);
    baseActionReport("gzh_exposure", "feeds", localHashMap2, localHashMap1, "");
  }
  
  public void reportPublicAccDetailClick()
  {
    this.mTestId = snf.a(1);
    baseActionReport("gzh_click", "feeds", getFeedsBaseParams("wesee_info", 1000001), "");
  }
  
  public void reportVideoPlayUpdateExp(int paramInt)
  {
    String str = "";
    if (paramInt == 2) {
      str = "QQ_official_account";
    }
    for (;;)
    {
      new WSStatisticsReporter.Builder().addParams(getFeedsBaseParams("videoplay_update", 0)).setSceneFrom(str).setSopName("fullscreen_videoplay").setTestId(this.mTestId).setPushId(this.mPushId).setFlush(true).build("gzh_exposure").report();
      return;
      if (paramInt == 6) {
        str = "weishi_share_trendstab";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport
 * JD-Core Version:    0.7.0.1
 */
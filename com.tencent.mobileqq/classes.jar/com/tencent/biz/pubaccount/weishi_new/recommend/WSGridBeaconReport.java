package com.tencent.biz.pubaccount.weishi_new.recommend;

import UserGrowth.stCollection;
import UserGrowth.stH5OpInfo;
import UserGrowth.stOpVideo;
import UserGrowth.stReportItem;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stVideoTag;
import UserGrowth.stWaterFallItemStrategy;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.report.WSRecommendReportManager;
import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter;
import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter.Builder;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import java.util.HashMap;
import java.util.Map;

public class WSGridBeaconReport
{
  private static WSStatisticsReporter.Builder a(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    return new WSStatisticsReporter.Builder().setSopName(paramString1).setTabId(paramString3).setTestId(WeishiUtils.a(paramInt)).setPushId(WSPublicAccReport.getInstance().getPushId()).setOperationId(paramString2).setFlush(true).setImmediatelyUpload(WeishiUtils.d());
  }
  
  private static String a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if ((paramstSimpleMetaFeed != null) && (paramstSimpleMetaFeed.waterFallItemStrategy != null) && (paramstSimpleMetaFeed.waterFallItemStrategy.isCallWeishi)) {
      return "1";
    }
    return "0";
  }
  
  private static Map<String, String> a(stSimpleMetaFeed paramstSimpleMetaFeed, stReportItem paramstReportItem)
  {
    HashMap localHashMap = new HashMap();
    String str2 = "";
    String str1 = str2;
    if (paramstSimpleMetaFeed != null)
    {
      str1 = str2;
      if (paramstSimpleMetaFeed.collection != null) {
        str1 = paramstSimpleMetaFeed.collection.cid;
      }
    }
    localHashMap.put("collection_id", str1);
    localHashMap.put("cardtype", String.valueOf(paramstReportItem.card_type));
    localHashMap.put("poolType", String.valueOf(paramstReportItem.pool_type));
    localHashMap.put("ratioW", String.valueOf(paramstReportItem.ratioW));
    localHashMap.put("ratioH", String.valueOf(paramstReportItem.ratioH));
    localHashMap.put("isFullSpan", String.valueOf(paramstReportItem.isFullSpan));
    localHashMap.put("type", String.valueOf(paramstReportItem.video_type));
    localHashMap.put("opvideo_type", c(paramstSimpleMetaFeed));
    localHashMap.put("material_type", c(paramstSimpleMetaFeed));
    localHashMap.put("cover_type", WeishiUtils.a(paramstSimpleMetaFeed));
    localHashMap.put("isCallWeishi", a(paramstSimpleMetaFeed));
    localHashMap.put("isDownloadWeishi", b(paramstSimpleMetaFeed));
    if ((paramstSimpleMetaFeed != null) && (paramstSimpleMetaFeed.videoTag != null)) {}
    for (paramstSimpleMetaFeed = String.valueOf(paramstSimpleMetaFeed.videoTag.tagId);; paramstSimpleMetaFeed = "")
    {
      localHashMap.put("tag_id", paramstSimpleMetaFeed);
      return localHashMap;
    }
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, stCollection paramstCollection, stSimpleMetaFeed paramstSimpleMetaFeed, String paramString)
  {
    Object localObject = "feeds_item_card" + (paramInt1 + 1);
    paramstSimpleMetaFeed = WSPublicAccReport.getInstance().getFeedsBaseParams((String)localObject, paramInt3, paramstSimpleMetaFeed);
    localObject = new HashMap();
    ((HashMap)localObject).put("index", String.valueOf(paramInt2 + 1));
    ((HashMap)localObject).put("collection_id", paramstCollection.cid);
    a(a("feeds", "", 1, paramString).addParams(paramstSimpleMetaFeed).addExtParams((Map)localObject), "gzh_click");
  }
  
  public static void a(int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed, String paramString1, String paramString2)
  {
    Object localObject = "feeds_item_card" + (paramInt + 1);
    paramstSimpleMetaFeed = WSPublicAccReport.getInstance().getFeedsBaseParams((String)localObject, 0, paramstSimpleMetaFeed);
    localObject = new HashMap();
    ((HashMap)localObject).put("feeds_item_list", paramString1);
    a(a("feeds", "", 1, paramString2).addParams(paramstSimpleMetaFeed).addExtParams((Map)localObject), "gzh_exposure");
  }
  
  public static void a(stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    paramstSimpleMetaFeed = WSPublicAccReport.getInstance().getFeedsBaseParams("feeds_data", 0, paramstSimpleMetaFeed);
    HashMap localHashMap = new HashMap();
    localHashMap.put("preload_status", String.valueOf(paramInt1));
    localHashMap.put("feeds_list_type", String.valueOf(paramInt2));
    localHashMap.put("preload_count", String.valueOf(paramInt3));
    a(a("feeds", "", 1, paramString).addParams(paramstSimpleMetaFeed).addExtParams(localHashMap), "gzh_exposure");
  }
  
  private static void a(WSStatisticsReporter.Builder paramBuilder, String paramString)
  {
    paramBuilder.build(paramString).report();
  }
  
  public static void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2, String paramString3)
  {
    Map localMap = WSPublicAccReport.getInstance().getFeedsBaseParamsWithoutFeed("msg_extry", paramInt2);
    localMap.put("global_key", WSRecommendReportManager.a().a(paramString2));
    paramString2 = new HashMap();
    paramString2.put("type", String.valueOf(paramInt1));
    a(a("feeds", String.valueOf(paramInt3), 4, paramString3).addParams(localMap).addExtParams(paramString2), paramString1);
  }
  
  public static void a(String paramString1, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed, String paramString2)
  {
    Object localObject = null;
    Map localMap = WSPublicAccReport.getInstance().getFeedsBaseParams("opcard", paramInt, paramstSimpleMetaFeed);
    if ((paramstSimpleMetaFeed != null) && (paramstSimpleMetaFeed.h5_op_info != null)) {
      localObject = paramstSimpleMetaFeed.h5_op_info;
    }
    for (paramstSimpleMetaFeed = ((stH5OpInfo)localObject).exp;; paramstSimpleMetaFeed = null)
    {
      if (localObject != null) {}
      for (localObject = String.valueOf(((stH5OpInfo)localObject).id);; localObject = "")
      {
        a(a("feeds", (String)localObject, 1, paramString2).addParams(localMap).addExtParams(paramstSimpleMetaFeed), paramString1);
        return;
      }
    }
  }
  
  public static void a(String paramString1, stSimpleMetaFeed paramstSimpleMetaFeed, stReportItem paramstReportItem, int paramInt, String paramString2)
  {
    Map localMap = WSPublicAccReport.getInstance().getFeedsBaseParams("feeds_video" + paramstReportItem.upos, paramInt, paramstSimpleMetaFeed);
    paramstSimpleMetaFeed = a(paramstSimpleMetaFeed, paramstReportItem);
    a(a("feeds", "", 1, paramString2).addParams(localMap).addExtParams(paramstSimpleMetaFeed), paramString1);
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap1 = new HashMap();
    localHashMap1.put("feed_id", "");
    localHashMap1.put("owner_id", "");
    HashMap localHashMap2 = new HashMap();
    localHashMap2.put("failure_type", String.valueOf(paramInt));
    localHashMap2.put("feedid_list", paramString1);
    localHashMap2.put("traceid_list", paramString2);
    if ((paramBoolean1) || (paramBoolean2)) {
      if (!paramBoolean1) {
        break label138;
      }
    }
    label138:
    for (paramString1 = "1";; paramString1 = "0")
    {
      localHashMap2.put("is_auto_refresh", paramString1);
      a(a("feeds_refresh_request", "", 1, paramString3).addParams(localHashMap1).addExtParams(localHashMap2), "gzh_exposure");
      return;
    }
  }
  
  private static String b(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if ((paramstSimpleMetaFeed != null) && (paramstSimpleMetaFeed.waterFallItemStrategy != null) && (paramstSimpleMetaFeed.waterFallItemStrategy.isDonwloadWeish)) {
      return "1";
    }
    return "0";
  }
  
  private static String c(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if ((paramstSimpleMetaFeed != null) && (paramstSimpleMetaFeed.opVideo != null)) {
      return String.valueOf(paramstSimpleMetaFeed.opVideo.videoType);
    }
    return String.valueOf(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.WSGridBeaconReport
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.pubaccount.weishi_new.recommend;

import UserGrowth.stCollection;
import UserGrowth.stH5OpInfo;
import UserGrowth.stOpVideo;
import UserGrowth.stReportItem;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stVideoTag;
import UserGrowth.stWaterFallItemStrategy;
import android.support.annotation.Nullable;
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
    return new WSStatisticsReporter.Builder().setSopName(paramString1).setTabId(paramString3).setTestId(WeishiUtils.a(paramInt)).setPushId(WSPublicAccReport.getInstance().getPushId()).setOperationId(paramString2).setFlush(true);
  }
  
  private static String a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if ((paramstSimpleMetaFeed != null) && (paramstSimpleMetaFeed.waterFallItemStrategy != null) && (paramstSimpleMetaFeed.waterFallItemStrategy.isCallWeishi)) {
      return "1";
    }
    return "0";
  }
  
  private static Map<String, String> a(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("history_drama_card");
    localStringBuilder.append(paramInt + 1);
    localHashMap.put("position", localStringBuilder.toString());
    localHashMap.put("feed_id", "");
    localHashMap.put("owner_id", "");
    return localHashMap;
  }
  
  private static Map<String, String> a(stSimpleMetaFeed paramstSimpleMetaFeed, stReportItem paramstReportItem)
  {
    HashMap localHashMap = new HashMap();
    String str2 = "";
    String str1;
    if ((paramstSimpleMetaFeed != null) && (paramstSimpleMetaFeed.collection != null)) {
      str1 = paramstSimpleMetaFeed.collection.cid;
    } else {
      str1 = "";
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
    if ((paramstSimpleMetaFeed != null) && (paramstSimpleMetaFeed.videoTag != null)) {
      paramstReportItem = String.valueOf(paramstSimpleMetaFeed.videoTag.tagId);
    } else {
      paramstReportItem = "";
    }
    localHashMap.put("tag_id", paramstReportItem);
    paramstReportItem = str2;
    if (paramstSimpleMetaFeed != null)
    {
      paramstReportItem = str2;
      if (paramstSimpleMetaFeed.bottomTag != null) {
        paramstReportItem = String.valueOf(paramstSimpleMetaFeed.bottomTag.tagId);
      }
    }
    localHashMap.put("label_type", paramstReportItem);
    return localHashMap;
  }
  
  private static Map<String, String> a(@Nullable String paramString, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    String str = paramString;
    if (paramString == null) {
      str = "";
    }
    localHashMap.put("micro_drama_id", str);
    if (paramBoolean) {
      paramString = "1";
    } else {
      paramString = "0";
    }
    localHashMap.put("is_update", paramString);
    return localHashMap;
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3, stCollection paramstCollection, stSimpleMetaFeed paramstSimpleMetaFeed, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("feeds_item_card");
    ((StringBuilder)localObject).append(paramInt1 + 1);
    localObject = ((StringBuilder)localObject).toString();
    paramstSimpleMetaFeed = WSPublicAccReport.getInstance().getFeedsBaseParams((String)localObject, paramInt3, paramstSimpleMetaFeed);
    localObject = new HashMap();
    ((HashMap)localObject).put("index", String.valueOf(paramInt2 + 1));
    ((HashMap)localObject).put("collection_id", paramstCollection.cid);
    a(a("feeds", "", 1, paramString).addParams(paramstSimpleMetaFeed).addExtParams((Map)localObject), "gzh_click");
  }
  
  public static void a(int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed, String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("feeds_item_card");
    ((StringBuilder)localObject).append(paramInt + 1);
    localObject = ((StringBuilder)localObject).toString();
    paramstSimpleMetaFeed = WSPublicAccReport.getInstance().getFeedsBaseParams((String)localObject, 0, paramstSimpleMetaFeed);
    localObject = new HashMap();
    ((HashMap)localObject).put("feeds_item_list", paramString1);
    a(a("feeds", "", 1, paramString2).addParams(paramstSimpleMetaFeed).addExtParams((Map)localObject), "gzh_exposure");
  }
  
  public static void a(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    HashMap localHashMap1 = new HashMap();
    localHashMap1.put("position", "feeds_loadmore_request");
    localHashMap1.put("feed_id", "");
    localHashMap1.put("owner_id", "");
    HashMap localHashMap2 = new HashMap();
    localHashMap2.put("failure_type", String.valueOf(paramInt));
    localHashMap2.put("feedid_list", paramString1);
    localHashMap2.put("traceid_list", paramString2);
    a(a("feeds", "", 1, paramString3).addParams(localHashMap1).addExtParams(localHashMap2), "gzh_exposure");
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
    Map localMap = WSPublicAccReport.getInstance().getFeedsBaseParams("opcard", paramInt, paramstSimpleMetaFeed);
    Object localObject = null;
    if ((paramstSimpleMetaFeed != null) && (paramstSimpleMetaFeed.h5_op_info != null))
    {
      localObject = paramstSimpleMetaFeed.h5_op_info;
      paramstSimpleMetaFeed = ((stH5OpInfo)localObject).exp;
    }
    else
    {
      paramstSimpleMetaFeed = null;
    }
    if (localObject != null) {
      localObject = String.valueOf(((stH5OpInfo)localObject).id);
    } else {
      localObject = "";
    }
    a(a("feeds", (String)localObject, 1, paramString2).addParams(localMap).addExtParams(paramstSimpleMetaFeed), paramString1);
  }
  
  public static void a(@Nullable String paramString1, int paramInt, @Nullable String paramString2, boolean paramBoolean)
  {
    Map localMap = a(paramInt);
    paramString2 = a(paramString2, paramBoolean);
    a(a("feeds", "", 1, paramString1).addParams(localMap).addExtParams(paramString2), "gzh_exposure");
  }
  
  public static void a(String paramString1, stSimpleMetaFeed paramstSimpleMetaFeed, stReportItem paramstReportItem, int paramInt, String paramString2)
  {
    Object localObject = WSPublicAccReport.getInstance();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("feeds_video");
    localStringBuilder.append(paramstReportItem.upos);
    localObject = ((WSPublicAccReport)localObject).getFeedsBaseParams(localStringBuilder.toString(), paramInt, paramstSimpleMetaFeed);
    paramstSimpleMetaFeed = a(paramstSimpleMetaFeed, paramstReportItem);
    a(a("feeds", "", 1, paramString2).addParams((Map)localObject).addExtParams(paramstSimpleMetaFeed), paramString1);
  }
  
  public static void a(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString)
  {
    HashMap localHashMap1 = new HashMap();
    localHashMap1.put("position", "feeds_refresh_request");
    localHashMap1.put("feed_id", "");
    localHashMap1.put("owner_id", "");
    HashMap localHashMap2 = new HashMap();
    localHashMap2.put("failure_type", String.valueOf(paramInt));
    if ((paramBoolean1) || (paramBoolean2))
    {
      String str;
      if (paramBoolean1) {
        str = "1";
      } else {
        str = "0";
      }
      localHashMap2.put("is_auto_refresh", str);
    }
    a(a("feeds", "", 1, paramString).addParams(localHashMap1).addExtParams(localHashMap2), "gzh_exposure");
  }
  
  private static String b(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if ((paramstSimpleMetaFeed != null) && (paramstSimpleMetaFeed.waterFallItemStrategy != null) && (paramstSimpleMetaFeed.waterFallItemStrategy.isDonwloadWeish)) {
      return "1";
    }
    return "0";
  }
  
  public static void b(@Nullable String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    Map localMap = a(paramInt);
    localMap.put("action_id", "1000001");
    paramString2 = a(paramString2, paramBoolean);
    a(a("feeds", "", 1, paramString1).addParams(localMap).addExtParams(paramString2), "gzh_click");
  }
  
  private static String c(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    int i;
    if ((paramstSimpleMetaFeed != null) && (paramstSimpleMetaFeed.opVideo != null)) {
      i = paramstSimpleMetaFeed.opVideo.videoType;
    } else {
      i = 0;
    }
    return String.valueOf(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.WSGridBeaconReport
 * JD-Core Version:    0.7.0.1
 */
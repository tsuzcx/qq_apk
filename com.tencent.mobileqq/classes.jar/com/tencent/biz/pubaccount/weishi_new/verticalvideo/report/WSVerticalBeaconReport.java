package com.tencent.biz.pubaccount.weishi_new.verticalvideo.report;

import UserGrowth.stFeedOpInfo;
import UserGrowth.stJumpInfo;
import UserGrowth.stNewIconStyle;
import UserGrowth.stOpVideo;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stVideoTag;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.commercial.AbsWSRichWidgetData;
import com.tencent.biz.pubaccount.weishi_new.commercial.WSCommercialInfo;
import com.tencent.biz.pubaccount.weishi_new.commercial.WSPublisherInfo;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerParam;
import com.tencent.biz.pubaccount.weishi_new.player.WSPlayerWrapper;
import com.tencent.biz.pubaccount.weishi_new.player.WSVideoInfo;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport.RecommendFullScreenInfo;
import com.tencent.biz.pubaccount.weishi_new.report.WSRecommendReportManager;
import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter;
import com.tencent.biz.pubaccount.weishi_new.report.WSStatisticsReporter.Builder;
import com.tencent.biz.pubaccount.weishi_new.report.dc898.WSReportDC898Vertical;
import com.tencent.biz.pubaccount.weishi_new.util.WSFeedUtils;
import com.tencent.biz.pubaccount.weishi_new.util.WSInitializeHelper;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.deltatime.WSVerticalDeltaTimeReportParams;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.utils.WSVerticalUtils;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.common.app.BaseApplicationImpl;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalItemData;>;
import java.util.Map;
import java.util.Set;

public class WSVerticalBeaconReport
{
  private static final Set<String> a = new HashSet();
  private static int b;
  private static String c;
  private static String d;
  
  public static String a()
  {
    return d;
  }
  
  private static String a(stOpVideo paramstOpVideo)
  {
    int i;
    if (paramstOpVideo != null) {
      i = paramstOpVideo.videoType;
    } else {
      i = 0;
    }
    return String.valueOf(i);
  }
  
  @NonNull
  private static Map<String, String> a(String paramString, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed, Map<String, String> paramMap)
  {
    HashMap localHashMap = new HashMap();
    if (paramMap != null) {
      localHashMap.putAll(paramMap);
    }
    localHashMap.put("poolType", String.valueOf(paramstSimpleMetaFeed.videoPoolType));
    localHashMap.put("type", String.valueOf(paramstSimpleMetaFeed.video_type));
    paramMap = paramstSimpleMetaFeed.opVideo;
    localHashMap.put("opvideo_type", a(paramMap));
    localHashMap.put("material_type", a(paramMap));
    localHashMap.put("cover_type", WeishiUtils.c(paramstSimpleMetaFeed, false));
    paramMap = paramstSimpleMetaFeed.videoTag;
    String str = "0";
    if (paramMap != null) {
      paramMap = String.valueOf(paramstSimpleMetaFeed.videoTag.tagId);
    } else {
      paramMap = "0";
    }
    localHashMap.put("tag_id", paramMap);
    if (paramstSimpleMetaFeed.bottomTag != null) {
      paramMap = String.valueOf(paramstSimpleMetaFeed.bottomTag.tagId);
    } else {
      paramMap = "0";
    }
    localHashMap.put("feeds_label_type", paramMap);
    paramMap = str;
    if (WSFeedUtils.a(paramstSimpleMetaFeed.poster)) {
      paramMap = "1";
    }
    localHashMap.put("is_livenow", paramMap);
    localHashMap.put("feeds_index", String.valueOf(d(paramString)));
    localHashMap.put("feeds_feedid", e(paramString));
    paramString = WSPublicAccReport.getInstance().getRecommendFullScreenInfo();
    if ((paramInt == 0) && (paramString.d()))
    {
      localHashMap.put("is_cache_info", String.valueOf(paramString.c()));
      localHashMap.put("is_cache_file", String.valueOf(paramString.b()));
      localHashMap.put("exp_duration", String.valueOf(paramString.a()));
    }
    return localHashMap;
  }
  
  public static void a(int paramInt)
  {
    b = paramInt;
  }
  
  public static void a(int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed, String paramString1, String paramString2)
  {
    a(paramString1, paramString2, "gamevideo.save", paramstSimpleMetaFeed, paramInt, "", null);
  }
  
  public static void a(stSimpleMetaFeed paramstSimpleMetaFeed, String paramString1, String paramString2)
  {
    a(paramString1, paramString2, "gamevideo.save", paramstSimpleMetaFeed, "", null);
  }
  
  private static void a(WSStatisticsReporter.Builder paramBuilder, String paramString)
  {
    paramBuilder.build(paramString).report();
  }
  
  public static void a(WSVerticalDeltaTimeReportParams paramWSVerticalDeltaTimeReportParams)
  {
    if (paramWSVerticalDeltaTimeReportParams == null) {
      return;
    }
    HashMap localHashMap1 = new HashMap();
    localHashMap1.put("event_type", paramWSVerticalDeltaTimeReportParams.a);
    localHashMap1.put("feed_id", paramWSVerticalDeltaTimeReportParams.d);
    localHashMap1.put("owner_id", paramWSVerticalDeltaTimeReportParams.e);
    localHashMap1.put("video_length", String.valueOf(paramWSVerticalDeltaTimeReportParams.f));
    HashMap localHashMap2 = new HashMap();
    localHashMap2.put("play_scene", paramWSVerticalDeltaTimeReportParams.c);
    localHashMap2.put("oncreate_time", String.valueOf(paramWSVerticalDeltaTimeReportParams.g));
    localHashMap2.put("onviewcreated_time", String.valueOf(paramWSVerticalDeltaTimeReportParams.h));
    localHashMap2.put("onbindholder_time", String.valueOf(paramWSVerticalDeltaTimeReportParams.i));
    localHashMap2.put("onplayvideo_time", String.valueOf(paramWSVerticalDeltaTimeReportParams.j));
    localHashMap2.put("onvideostarted_time", String.valueOf(paramWSVerticalDeltaTimeReportParams.k));
    localHashMap2.put("onoverall_time", String.valueOf(paramWSVerticalDeltaTimeReportParams.l));
    localHashMap2.put("error_code", paramWSVerticalDeltaTimeReportParams.m);
    localHashMap2.put("error_msg", paramWSVerticalDeltaTimeReportParams.n);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[WSVerticalBeaconReport.java][reportVerticalPlayAction] map:");
    localStringBuilder.append(localHashMap1.toString());
    localStringBuilder.append(", extMap:");
    localStringBuilder.append(localHashMap2.toString());
    WSLog.e("WSVerticalDeltaTimeLog", localStringBuilder.toString());
    a(f(paramWSVerticalDeltaTimeReportParams.b).addParams(localHashMap1).addExtParams(localHashMap2).setOperationId(""), "gzh_play_action");
  }
  
  public static void a(String paramString)
  {
    c = paramString;
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, stJumpInfo paramstJumpInfo)
  {
    if (paramstJumpInfo == null) {
      return;
    }
    Map localMap = WSPublicAccReport.getInstance().getFeedsBaseParamsWithoutFeed("blockpage", paramInt);
    localMap.put("global_key", WSRecommendReportManager.a().a(paramstJumpInfo.trace_id));
    HashMap localHashMap = new HashMap();
    localHashMap.put("play_scene", paramString2);
    if (paramstJumpInfo.mapExt != null) {
      localHashMap.putAll(paramstJumpInfo.mapExt);
    }
    a(f(paramString1).addParams(localMap).addExtParams(localHashMap).setOperationId(String.valueOf(paramstJumpInfo.id)), "gzh_click");
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    stNewIconStyle localstNewIconStyle;
    if (paramstSimpleMetaFeed != null) {
      localstNewIconStyle = paramstSimpleMetaFeed.new_icon;
    } else {
      localstNewIconStyle = null;
    }
    if (localstNewIconStyle == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(localstNewIconStyle.tag_type);
    localStringBuilder.append("");
    localHashMap.put("type", localStringBuilder.toString());
    a(paramString1, paramString2, "videoplay_tag", paramstSimpleMetaFeed, paramInt, String.valueOf(localstNewIconStyle.id), localHashMap);
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed, Map<String, String> paramMap)
  {
    if (paramstSimpleMetaFeed == null) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fullscreen_videoplay_video");
    localStringBuilder.append(paramInt + 1);
    a(paramString1, paramString2, localStringBuilder.toString(), paramstSimpleMetaFeed, "", a(paramString1, paramInt, paramstSimpleMetaFeed, paramMap));
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed, boolean paramBoolean, Map<String, String> paramMap)
  {
    if (paramstSimpleMetaFeed == null) {
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("fullscreen_videoplay_video");
    ((StringBuilder)localObject).append(paramInt + 1);
    localObject = ((StringBuilder)localObject).toString();
    paramMap = a(paramString1, paramInt, paramstSimpleMetaFeed, paramMap);
    if (paramBoolean) {
      paramInt = 1007001;
    } else {
      paramInt = 1007002;
    }
    a(paramString1, paramString2, (String)localObject, paramstSimpleMetaFeed, paramInt, "", paramMap);
  }
  
  private static void a(String paramString1, String paramString2, int paramInt1, WSPlayerParam paramWSPlayerParam, boolean paramBoolean, int paramInt2, Map<String, String> paramMap)
  {
    if (paramWSPlayerParam != null)
    {
      if (paramWSPlayerParam.c == null) {
        return;
      }
      WSVideoInfo localWSVideoInfo = paramWSPlayerParam.c;
      if (WSVerticalUtils.a(a, paramInt1, localWSVideoInfo)) {
        return;
      }
      Object localObject = paramWSPlayerParam.d;
      long l2 = 0L;
      long l1;
      if (localObject != null) {
        l1 = ((WSPlayerWrapper)localObject).m();
      } else {
        l1 = 0L;
      }
      HashMap localHashMap = new HashMap();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("");
      localHashMap.put("event_type", localStringBuilder.toString());
      localHashMap.put("feed_id", localWSVideoInfo.a);
      localHashMap.put("owner_id", localWSVideoInfo.j);
      if (paramInt1 == 2)
      {
        if (localObject != null) {
          l2 = ((WSPlayerWrapper)localObject).c(paramBoolean);
        }
        localHashMap.put("duration", String.valueOf(l2));
        localHashMap.put("last_location", String.valueOf(l1));
      }
      localHashMap.put("video_length", String.valueOf(localWSVideoInfo.d));
      localHashMap.put("recommend_id", "");
      localHashMap.put("poolType", String.valueOf(localWSVideoInfo.h));
      localHashMap.put("global_key", WSRecommendReportManager.a().a(localWSVideoInfo.k));
      localHashMap.put("feed_pass_key", localWSVideoInfo.l);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[WSVerticalBeaconReport.java][reportVerticalVideoPlay] title:");
      ((StringBuilder)localObject).append(localWSVideoInfo.g);
      ((StringBuilder)localObject).append(", map:");
      ((StringBuilder)localObject).append(localHashMap.toString());
      WSLog.e("WS_VIDEO_PLAY_TIME", ((StringBuilder)localObject).toString());
      if (paramMap == null) {
        paramMap = new HashMap();
      }
      paramMap.put("type", String.valueOf(localWSVideoInfo.i));
      paramMap.put("cover_type", WeishiUtils.g(localWSVideoInfo.f));
      paramMap.put("material_type", String.valueOf(localWSVideoInfo.m));
      paramMap.put("play_scene", paramString2);
      paramMap.put("tag_id", String.valueOf(paramWSPlayerParam.c.n));
      paramMap.put("feeds_label_type", String.valueOf(paramWSPlayerParam.c.o));
      paramMap.put("videoplay_index", String.valueOf(paramInt2 + 1));
      paramMap.put("feeds_index", String.valueOf(d(paramString1)));
      paramMap.put("feeds_feedid", e(paramString1));
      a(f(paramString1).addParams(localHashMap).addExtParams(paramMap).setOperationId(""), "gzh_video_play");
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, WSVerticalItemData paramWSVerticalItemData, String paramString3, boolean paramBoolean)
  {
    if (paramWSVerticalItemData != null)
    {
      Object localObject = paramWSVerticalItemData.f();
      if (localObject == null) {
        return;
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("rich_type", String.valueOf(((AbsWSRichWidgetData)localObject).d()));
      if ((localObject instanceof WSCommercialInfo))
      {
        localObject = (WSCommercialInfo)localObject;
        boolean bool;
        if (((WSCommercialInfo)localObject).k() == 5) {
          bool = true;
        } else {
          bool = false;
        }
        a(localHashMap, bool, ((WSCommercialInfo)localObject).k(), paramBoolean);
        if (bool) {
          a(localHashMap, paramString3);
        }
      }
      else if ((localObject instanceof WSPublisherInfo))
      {
        localHashMap.put("upload_from", "0040");
      }
      a("gzh_click", paramString1, paramString2, paramWSVerticalItemData, localHashMap, paramInt);
    }
  }
  
  public static void a(String paramString1, String paramString2, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    HashMap localHashMap = new HashMap();
    String str;
    if (paramstSimpleMetaFeed != null) {
      str = a(paramstSimpleMetaFeed.opVideo);
    } else {
      str = "0";
    }
    localHashMap.put("material_type", str);
    a(paramString1, paramString2, "more_operations", paramstSimpleMetaFeed, 1000001, "", localHashMap);
  }
  
  public static void a(String paramString1, String paramString2, stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt, Map<String, String> paramMap)
  {
    a(paramString1, paramString2, "bottom_bar", paramstSimpleMetaFeed, paramInt, "", paramMap);
  }
  
  public static void a(String paramString1, String paramString2, stSimpleMetaFeed paramstSimpleMetaFeed, Map<String, String> paramMap)
  {
    a(paramString1, paramString2, "bottom_bar", paramstSimpleMetaFeed, "", paramMap);
  }
  
  public static void a(String paramString1, String paramString2, WSPlayerParam paramWSPlayerParam, int paramInt, Map<String, String> paramMap)
  {
    a(paramString1, paramString2, 1, paramWSPlayerParam, false, paramInt, paramMap);
  }
  
  public static void a(String paramString1, String paramString2, WSPlayerParam paramWSPlayerParam, boolean paramBoolean, int paramInt, Map<String, String> paramMap)
  {
    a(paramString1, paramString2, 2, paramWSPlayerParam, paramBoolean, paramInt, paramMap);
    WSReportDC898Vertical.a(paramWSPlayerParam, paramBoolean);
  }
  
  public static void a(String paramString1, String paramString2, WSVerticalItemData paramWSVerticalItemData)
  {
    a(paramString1, paramString2, paramWSVerticalItemData, false);
  }
  
  public static void a(String paramString1, String paramString2, WSVerticalItemData paramWSVerticalItemData, boolean paramBoolean)
  {
    if (paramWSVerticalItemData != null)
    {
      Object localObject = paramWSVerticalItemData.f();
      if (localObject == null) {
        return;
      }
      HashMap localHashMap = new HashMap();
      localHashMap.put("rich_type", String.valueOf(((AbsWSRichWidgetData)localObject).d()));
      if ((localObject instanceof WSCommercialInfo))
      {
        localObject = (WSCommercialInfo)localObject;
        boolean bool;
        if (((WSCommercialInfo)localObject).k() == 5) {
          bool = true;
        } else {
          bool = false;
        }
        a(localHashMap, bool, ((WSCommercialInfo)localObject).k(), paramBoolean);
      }
      else if ((localObject instanceof WSPublisherInfo))
      {
        localHashMap.put("upload_from", "0040");
      }
      a("gzh_exposure", paramString1, paramString2, paramWSVerticalItemData, localHashMap, 0);
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed, Map<String, String> paramMap)
  {
    String str;
    if (paramstSimpleMetaFeed != null) {
      str = paramstSimpleMetaFeed.poster_id;
    } else {
      str = "";
    }
    if (TextUtils.equals(str, WeishiUtils.n())) {
      WeishiUtils.m("homepage_main");
    } else {
      WeishiUtils.m("homepage_guest");
    }
    a(paramString1, paramString2, paramString3, paramstSimpleMetaFeed, paramInt, "", paramMap);
  }
  
  static void a(String paramString1, String paramString2, String paramString3, stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt, String paramString4, Map<String, String> paramMap)
  {
    paramString3 = f(paramString1).addParams(WSPublicAccReport.getInstance().getFeedsBaseParams(paramString3, paramInt, paramstSimpleMetaFeed)).setOperationId(paramString4);
    paramString1 = paramMap;
    if (paramMap == null) {
      paramString1 = new HashMap();
    }
    paramString1.put("play_scene", paramString2);
    paramString3.addExtParams(paramString1);
    a(paramString3, "gzh_click");
  }
  
  static void a(String paramString1, String paramString2, String paramString3, stSimpleMetaFeed paramstSimpleMetaFeed, String paramString4, Map<String, String> paramMap)
  {
    paramString3 = f(paramString1).addParams(WSPublicAccReport.getInstance().getFeedsBaseParams(paramString3, 0, paramstSimpleMetaFeed)).setOperationId(paramString4);
    paramString1 = paramMap;
    if (paramMap == null) {
      paramString1 = new HashMap();
    }
    paramString1.put("play_scene", paramString2);
    paramString3.addExtParams(paramString1);
    a(paramString3, "gzh_exposure");
  }
  
  private static void a(String paramString1, String paramString2, String paramString3, WSVerticalItemData paramWSVerticalItemData, Map<String, String> paramMap, int paramInt)
  {
    stSimpleMetaFeed localstSimpleMetaFeed = paramWSVerticalItemData.b();
    if ((localstSimpleMetaFeed != null) && (localstSimpleMetaFeed.opInfo != null)) {
      paramWSVerticalItemData = localstSimpleMetaFeed.opInfo.traceId;
    } else {
      paramWSVerticalItemData = "";
    }
    paramMap.put("play_scene", paramString3);
    paramString3 = WSPublicAccReport.getInstance().getFeedsBaseParams("videotag_rich", paramInt, localstSimpleMetaFeed, paramWSVerticalItemData, "");
    a(f(paramString2).addParams(paramString3).addExtParams(paramMap), paramString1);
  }
  
  public static void a(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    if (!TextUtils.isEmpty(paramString2)) {
      paramMap.put("play_scene", paramString2);
    }
    WSPublicAccReport.getInstance().reportPageVisitEnter(paramString1, paramMap);
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean, stSimpleMetaFeed paramstSimpleMetaFeed, Map<String, String> paramMap)
  {
    if (paramBoolean)
    {
      a(paramString1, paramString2, "like", paramstSimpleMetaFeed, 1001001, "", paramMap);
      return;
    }
    a(paramString1, paramString2, "like", paramstSimpleMetaFeed, 1001002, "", paramMap);
  }
  
  public static void a(List<WSVerticalItemData> paramList, boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    if (paramBoolean1) {
      localObject = "1";
    } else {
      localObject = "2";
    }
    localHashMap.put("trigger_type", localObject);
    if (paramBoolean2) {
      localObject = "true";
    } else {
      localObject = "false";
    }
    localHashMap.put("request_result", localObject);
    Object localObject = null;
    if (!paramBoolean2)
    {
      localHashMap.put("failure_type", String.valueOf(paramInt));
      a(paramString1, paramString2, "floating_layer_request", null, "", localHashMap);
      return;
    }
    if ((paramList != null) && (paramList.size() > 0) && ((((WSVerticalItemData)paramList.get(0)).b() instanceof stSimpleMetaFeed)))
    {
      localObject = ((WSVerticalItemData)paramList.get(0)).b();
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)localIterator.next();
        if (!TextUtils.isEmpty(localWSVerticalItemData.b().id))
        {
          localStringBuilder.append(localWSVerticalItemData.b().id);
          localStringBuilder.append("_");
        }
      }
      if (paramList.size() > 1) {
        localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      }
      localHashMap.put("feedid_list", localStringBuilder.toString());
      paramList = (List<WSVerticalItemData>)localObject;
    }
    else
    {
      localHashMap.put("feedid_list", "");
      paramList = (List<WSVerticalItemData>)localObject;
    }
    a(paramString1, paramString2, "floating_layer_request", paramList, "", localHashMap);
  }
  
  private static void a(Map<String, String> paramMap, String paramString)
  {
    try
    {
      Object localObject = Uri.parse(paramString);
      paramString = ((Uri)localObject).getQueryParameter("roomid");
      localObject = ((Uri)localObject).getQueryParameter("source");
      paramMap.put("room_id", paramString);
      paramMap.put("source", localObject);
      return;
    }
    catch (Exception paramMap)
    {
      WSLog.b(paramMap.getLocalizedMessage());
    }
  }
  
  private static void a(Map<String, String> paramMap, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    String str;
    if (paramBoolean1) {
      str = "2";
    } else {
      str = "4";
    }
    paramMap.put("commerce_type", str);
    paramMap.put("businesstag_type", String.valueOf(paramInt));
    if (paramBoolean2) {
      str = "1";
    } else {
      str = "0";
    }
    paramMap.put("card_type", str);
  }
  
  public static void b(String paramString)
  {
    d = paramString;
  }
  
  public static void b(String paramString1, String paramString2, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (paramstSimpleMetaFeed != null) {
      localObject = paramstSimpleMetaFeed.weishiButton;
    } else {
      localObject = null;
    }
    if (localObject == null) {
      return;
    }
    Object localObject = new HashMap();
    paramstSimpleMetaFeed = f(paramString1).addParams(WSPublicAccReport.getInstance().getFeedsBaseParams("jump_weishi", paramInt, paramstSimpleMetaFeed));
    ((Map)localObject).put("play_scene", paramString2);
    if (TextUtils.equals(paramString1, "share")) {
      paramString1 = "1";
    } else {
      paramString1 = "0";
    }
    ((Map)localObject).put("is_schema", paramString1);
    paramstSimpleMetaFeed.addExtParams((Map)localObject);
    a(paramstSimpleMetaFeed, "gzh_click");
  }
  
  public static void b(String paramString1, String paramString2, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed, Map<String, String> paramMap)
  {
    a(paramString1, paramString2, "forward", paramstSimpleMetaFeed, paramInt, "", paramMap);
  }
  
  public static void b(String paramString1, String paramString2, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    a(paramString1, paramString2, "home_icon", paramstSimpleMetaFeed, 1000001, "", null);
  }
  
  public static void b(String paramString1, String paramString2, stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt, Map<String, String> paramMap)
  {
    a(paramString1, paramString2, "drama_follow", paramstSimpleMetaFeed, paramInt, "", paramMap);
  }
  
  public static void b(String paramString1, String paramString2, stSimpleMetaFeed paramstSimpleMetaFeed, Map<String, String> paramMap)
  {
    a(paramString1, paramString2, "comment_at_pop", paramstSimpleMetaFeed, "", paramMap);
  }
  
  public static void b(String paramString1, String paramString2, Map<String, String> paramMap)
  {
    if (!TextUtils.isEmpty(paramString2)) {
      paramMap.put("play_scene", paramString2);
    }
    WSPublicAccReport.getInstance().reportPageVisitExit(paramString1, paramMap);
  }
  
  public static String c(String paramString)
  {
    if (TextUtils.equals(paramString, "aio_home_page")) {
      return "feeds_fullscreen";
    }
    if ((!TextUtils.equals(paramString, "vertical_layer_collection")) && (!TextUtils.equals(paramString, "vertical_layer_collection_of_card")))
    {
      if ((!TextUtils.equals(paramString, "drama_preview")) && (!TextUtils.equals(paramString, "drama_history")) && (!TextUtils.equals(paramString, "drama_collection")))
      {
        if (TextUtils.equals(paramString, "essence_tab")) {
          return "monofeed";
        }
        return "fullscreen_videoplay";
      }
      return "drama_fullscreen_videoplay";
    }
    return "collection_videoplay";
  }
  
  public static void c(String paramString1, String paramString2, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed, Map<String, String> paramMap)
  {
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    String str = "0";
    paramMap = str;
    if (paramstSimpleMetaFeed != null)
    {
      paramMap = str;
      if (WSFeedUtils.a(paramstSimpleMetaFeed.poster)) {
        paramMap = "1";
      }
    }
    ((Map)localObject).put("is_livenow", paramMap);
    a(paramString1, paramString2, "profile", paramstSimpleMetaFeed, paramInt, "", (Map)localObject);
  }
  
  public static void c(String paramString1, String paramString2, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    a(paramString1, paramString2, "back_homepage", paramstSimpleMetaFeed, 1000001, "", null);
  }
  
  public static void c(String paramString1, String paramString2, stSimpleMetaFeed paramstSimpleMetaFeed, Map<String, String> paramMap)
  {
    a(paramString1, paramString2, "like", paramstSimpleMetaFeed, 1001003, "", paramMap);
  }
  
  private static int d(String paramString)
  {
    if (TextUtils.equals(paramString, "recommend_tab")) {
      return b + 1;
    }
    return 0;
  }
  
  public static void d(String paramString1, String paramString2, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    g(paramString1, paramString2, paramstSimpleMetaFeed, null);
  }
  
  public static void d(String paramString1, String paramString2, stSimpleMetaFeed paramstSimpleMetaFeed, Map<String, String> paramMap)
  {
    a(paramString1, paramString2, "follow", paramstSimpleMetaFeed, 1004001, "", paramMap);
  }
  
  private static String e(String paramString)
  {
    if (TextUtils.equals(paramString, "recommend_tab")) {
      return c;
    }
    return "";
  }
  
  public static void e(String paramString1, String paramString2, stSimpleMetaFeed paramstSimpleMetaFeed, Map<String, String> paramMap)
  {
    int i;
    if (!WeishiGuideUtils.a(BaseApplicationImpl.getApplication())) {
      i = 1000002;
    } else {
      i = 1000003;
    }
    a(paramString1, paramString2, "video_title", paramstSimpleMetaFeed, i, "", paramMap);
  }
  
  private static WSStatisticsReporter.Builder f(String paramString)
  {
    String str1;
    if (TextUtils.equals(paramString, "follow_tab"))
    {
      String str2 = WeishiUtils.a(10);
      str1 = str2;
      if (TextUtils.isEmpty(str2)) {
        str1 = WeishiUtils.a(9);
      }
    }
    else
    {
      str1 = WeishiUtils.a(WSVerticalUtils.a(paramString));
    }
    return new WSStatisticsReporter.Builder().setTabId(d).setSopName(c(paramString)).setTestId(str1).setPushId(WSInitializeHelper.a().f()).setFlush(true);
  }
  
  public static void f(String paramString1, String paramString2, stSimpleMetaFeed paramstSimpleMetaFeed, Map<String, String> paramMap)
  {
    a(paramString1, paramString2, "comment_entry", paramstSimpleMetaFeed, 1000001, "", paramMap);
  }
  
  public static void g(String paramString1, String paramString2, stSimpleMetaFeed paramstSimpleMetaFeed, Map<String, String> paramMap)
  {
    a(paramString1, paramString2, "back", paramstSimpleMetaFeed, 1000001, "", paramMap);
  }
  
  public static void h(String paramString1, String paramString2, stSimpleMetaFeed paramstSimpleMetaFeed, Map<String, String> paramMap)
  {
    a(paramString1, paramString2, "drama_clear", paramstSimpleMetaFeed, 1000001, "", paramMap);
  }
  
  public static void i(String paramString1, String paramString2, stSimpleMetaFeed paramstSimpleMetaFeed, Map<String, String> paramMap)
  {
    a(paramString1, paramString2, "drama_updated", paramstSimpleMetaFeed, "", paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport
 * JD-Core Version:    0.7.0.1
 */
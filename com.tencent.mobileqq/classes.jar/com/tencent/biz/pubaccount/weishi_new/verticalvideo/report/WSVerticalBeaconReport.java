package com.tencent.biz.pubaccount.weishi_new.verticalvideo.report;

import UserGrowth.stCollection;
import UserGrowth.stFeedOpInfo;
import UserGrowth.stJumpInfo;
import UserGrowth.stNewIconStyle;
import UserGrowth.stOpVideo;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stVideoTag;
import android.net.Uri;
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
  private static int jdField_a_of_type_Int;
  private static String jdField_a_of_type_JavaLangString;
  private static final Set<String> jdField_a_of_type_JavaUtilSet = new HashSet();
  private static String b;
  
  private static int a(String paramString)
  {
    int i = 0;
    if (TextUtils.equals(paramString, "recommend_tab")) {
      i = jdField_a_of_type_Int + 1;
    }
    return i;
  }
  
  private static WSStatisticsReporter.Builder a(String paramString)
  {
    if (TextUtils.equals(paramString, "follow_tab"))
    {
      String str2 = WeishiUtils.a(10);
      str1 = str2;
      if (!TextUtils.isEmpty(str2)) {}
    }
    for (String str1 = WeishiUtils.a(9);; str1 = WeishiUtils.a(WSVerticalUtils.a(paramString))) {
      return new WSStatisticsReporter.Builder().setTabId(jdField_b_of_type_JavaLangString).setSopName(a(paramString)).setTestId(str1).setPushId(WSInitializeHelper.a().a()).setFlush(true).setImmediatelyUpload(WeishiUtils.d());
    }
  }
  
  public static String a()
  {
    return jdField_b_of_type_JavaLangString;
  }
  
  private static String a(stOpVideo paramstOpVideo)
  {
    if (paramstOpVideo != null) {
      return String.valueOf(paramstOpVideo.videoType);
    }
    return String.valueOf(0);
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.equals(paramString, "aio_home_page")) {
      return "feeds_fullscreen";
    }
    if (TextUtils.equals(paramString, "vertical_layer_collection")) {
      return "second_fullscreen_videoplay";
    }
    return "fullscreen_videoplay";
  }
  
  public static void a(int paramInt)
  {
    jdField_a_of_type_Int = paramInt;
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
    localHashMap1.put("event_type", paramWSVerticalDeltaTimeReportParams.jdField_a_of_type_JavaLangString);
    localHashMap1.put("feed_id", paramWSVerticalDeltaTimeReportParams.jdField_d_of_type_JavaLangString);
    localHashMap1.put("owner_id", paramWSVerticalDeltaTimeReportParams.jdField_e_of_type_JavaLangString);
    localHashMap1.put("video_length", String.valueOf(paramWSVerticalDeltaTimeReportParams.jdField_a_of_type_Long));
    HashMap localHashMap2 = new HashMap();
    localHashMap2.put("play_scene", paramWSVerticalDeltaTimeReportParams.jdField_c_of_type_JavaLangString);
    localHashMap2.put("oncreate_time", String.valueOf(paramWSVerticalDeltaTimeReportParams.jdField_b_of_type_Long));
    localHashMap2.put("onviewcreated_time", String.valueOf(paramWSVerticalDeltaTimeReportParams.jdField_c_of_type_Long));
    localHashMap2.put("onbindholder_time", String.valueOf(paramWSVerticalDeltaTimeReportParams.jdField_d_of_type_Long));
    localHashMap2.put("onplayvideo_time", String.valueOf(paramWSVerticalDeltaTimeReportParams.jdField_e_of_type_Long));
    localHashMap2.put("onvideostarted_time", String.valueOf(paramWSVerticalDeltaTimeReportParams.jdField_f_of_type_Long));
    localHashMap2.put("onoverall_time", String.valueOf(paramWSVerticalDeltaTimeReportParams.jdField_g_of_type_Long));
    localHashMap2.put("error_code", paramWSVerticalDeltaTimeReportParams.jdField_f_of_type_JavaLangString);
    localHashMap2.put("error_msg", paramWSVerticalDeltaTimeReportParams.jdField_g_of_type_JavaLangString);
    WSLog.e("WSVerticalDeltaTimeLog", "[WSVerticalBeaconReport.java][reportVerticalPlayAction] map:" + localHashMap1.toString() + ", extMap:" + localHashMap2.toString());
    a(a(paramWSVerticalDeltaTimeReportParams.jdField_b_of_type_JavaLangString).addParams(localHashMap1).addExtParams(localHashMap2).setOperationId(""), "gzh_play_action");
  }
  
  public static void a(String paramString)
  {
    jdField_a_of_type_JavaLangString = paramString;
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
    a(a(paramString1).addParams(localMap).addExtParams(localHashMap).setOperationId(String.valueOf(paramstJumpInfo.id)), "gzh_click");
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (paramstSimpleMetaFeed == null) {
      return;
    }
    Object localObject = paramstSimpleMetaFeed.opVideo;
    String str = "fullscreen_videoplay_video" + (paramInt + 1);
    HashMap localHashMap = new HashMap();
    localHashMap.put("poolType", String.valueOf(paramstSimpleMetaFeed.videoPoolType));
    localHashMap.put("type", String.valueOf(paramstSimpleMetaFeed.video_type));
    localHashMap.put("opvideo_type", a((stOpVideo)localObject));
    localHashMap.put("material_type", a((stOpVideo)localObject));
    localHashMap.put("cover_type", WeishiUtils.b(paramstSimpleMetaFeed, false));
    if (paramstSimpleMetaFeed.videoTag != null)
    {
      localObject = String.valueOf(paramstSimpleMetaFeed.videoTag.tagId);
      localHashMap.put("tag_id", localObject);
      if (!WSFeedUtils.a(paramstSimpleMetaFeed.poster)) {
        break label319;
      }
    }
    label319:
    for (localObject = "1";; localObject = "0")
    {
      localHashMap.put("is_livenow", localObject);
      localHashMap.put("feeds_index", String.valueOf(a(paramString1)));
      localHashMap.put("feeds_feedid", b(paramString1));
      localObject = WSPublicAccReport.getInstance().getRecommendFullScreenInfo();
      if ((paramInt == 0) && (((WSPublicAccReport.RecommendFullScreenInfo)localObject).a()))
      {
        localHashMap.put("is_cache_info", String.valueOf(((WSPublicAccReport.RecommendFullScreenInfo)localObject).b()));
        localHashMap.put("is_cache_file", String.valueOf(((WSPublicAccReport.RecommendFullScreenInfo)localObject).a()));
        localHashMap.put("exp_duration", String.valueOf(((WSPublicAccReport.RecommendFullScreenInfo)localObject).a()));
      }
      a(paramString1, paramString2, str, paramstSimpleMetaFeed, "", localHashMap);
      return;
      localObject = "0";
      break;
    }
  }
  
  private static void a(String paramString1, String paramString2, int paramInt1, WSPlayerParam paramWSPlayerParam, boolean paramBoolean, int paramInt2)
  {
    long l2 = 0L;
    if ((paramWSPlayerParam == null) || (paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo == null)) {}
    WSVideoInfo localWSVideoInfo;
    do
    {
      return;
      localWSVideoInfo = paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo;
    } while (WSVerticalUtils.a(jdField_a_of_type_JavaUtilSet, paramInt1, localWSVideoInfo));
    Object localObject = paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSPlayerWrapper;
    long l1;
    HashMap localHashMap;
    if (localObject != null)
    {
      l1 = ((WSPlayerWrapper)localObject).a();
      localHashMap = new HashMap();
      localHashMap.put("event_type", paramInt1 + "");
      localHashMap.put("feed_id", localWSVideoInfo.jdField_a_of_type_JavaLangString);
      localHashMap.put("owner_id", localWSVideoInfo.jdField_e_of_type_JavaLangString);
      if (paramInt1 == 2) {
        if (localObject != null) {
          break label474;
        }
      }
    }
    for (;;)
    {
      localHashMap.put("duration", String.valueOf(l2));
      localHashMap.put("last_location", String.valueOf(l1));
      localHashMap.put("video_length", String.valueOf(localWSVideoInfo.jdField_c_of_type_Int));
      localHashMap.put("recommend_id", "");
      localHashMap.put("poolType", String.valueOf(localWSVideoInfo.jdField_d_of_type_Int));
      localHashMap.put("global_key", WSRecommendReportManager.a().a(localWSVideoInfo.jdField_f_of_type_JavaLangString));
      localHashMap.put("feed_pass_key", localWSVideoInfo.jdField_g_of_type_JavaLangString);
      WSLog.e("WS_VIDEO_PLAY_TIME", "[WSVerticalBeaconReport.java][reportVerticalVideoPlay] title:" + localWSVideoInfo.jdField_d_of_type_JavaLangString + ", map:" + localHashMap.toString());
      localObject = new HashMap();
      ((Map)localObject).put("type", String.valueOf(localWSVideoInfo.jdField_e_of_type_Int));
      ((Map)localObject).put("cover_type", WeishiUtils.c(localWSVideoInfo.jdField_c_of_type_JavaLangString));
      ((Map)localObject).put("material_type", String.valueOf(localWSVideoInfo.jdField_f_of_type_Int));
      ((Map)localObject).put("play_scene", paramString2);
      ((Map)localObject).put("tag_id", String.valueOf(paramWSPlayerParam.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoInfo.jdField_g_of_type_Int));
      ((Map)localObject).put("videoplay_index", String.valueOf(paramInt2 + 1));
      ((Map)localObject).put("feeds_index", String.valueOf(a(paramString1)));
      ((Map)localObject).put("feeds_feedid", b(paramString1));
      a(a(paramString1).addParams(localHashMap).addExtParams((Map)localObject).setOperationId(""), "gzh_video_play");
      return;
      l1 = 0L;
      break;
      label474:
      l2 = ((WSPlayerWrapper)localObject).a(paramBoolean);
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, WSVerticalItemData paramWSVerticalItemData, String paramString3)
  {
    Object localObject;
    if (paramWSVerticalItemData != null)
    {
      localObject = paramWSVerticalItemData.a();
      if (localObject != null) {}
    }
    else
    {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("rich_type", String.valueOf(((AbsWSRichWidgetData)localObject).a()));
    boolean bool;
    if ((localObject instanceof WSCommercialInfo))
    {
      localObject = (WSCommercialInfo)localObject;
      if (((WSCommercialInfo)localObject).b() == 5)
      {
        bool = true;
        a(localHashMap, bool, ((WSCommercialInfo)localObject).b());
        if (bool) {
          a(localHashMap, paramString3);
        }
      }
    }
    for (;;)
    {
      a("gzh_click", paramString1, paramString2, paramWSVerticalItemData, localHashMap, paramInt);
      return;
      bool = false;
      break;
      if ((localObject instanceof WSPublisherInfo)) {
        localHashMap.put("upload_from", "0040");
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if ((TextUtils.equals(paramString1, "vertical_layer_collection")) || (TextUtils.equals(paramString1, "vertical_layer_collection_of_card"))) {}
    for (;;)
    {
      return;
      if (paramstSimpleMetaFeed != null) {}
      for (stCollection localstCollection = paramstSimpleMetaFeed.collection; (localstCollection != null) && (!TextUtils.isEmpty(localstCollection.cid)); localstCollection = null)
      {
        a(paramString1, paramString2, "function_entrance", paramstSimpleMetaFeed, "", null);
        return;
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt)
  {
    if (paramstSimpleMetaFeed != null) {}
    for (stCollection localstCollection = paramstSimpleMetaFeed.collection; (localstCollection == null) || (TextUtils.isEmpty(localstCollection.cid)); localstCollection = null) {
      return;
    }
    a(paramString1, paramString2, "function_entrance", paramstSimpleMetaFeed, paramInt, "", null);
  }
  
  public static void a(String paramString1, String paramString2, WSPlayerParam paramWSPlayerParam, int paramInt)
  {
    a(paramString1, paramString2, 1, paramWSPlayerParam, false, paramInt);
  }
  
  public static void a(String paramString1, String paramString2, WSPlayerParam paramWSPlayerParam, boolean paramBoolean, int paramInt)
  {
    a(paramString1, paramString2, 2, paramWSPlayerParam, paramBoolean, paramInt);
    WSReportDC898Vertical.a(paramWSPlayerParam, paramBoolean);
  }
  
  public static void a(String paramString1, String paramString2, WSVerticalItemData paramWSVerticalItemData)
  {
    Object localObject;
    if (paramWSVerticalItemData != null)
    {
      localObject = paramWSVerticalItemData.a();
      if (localObject != null) {}
    }
    else
    {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("rich_type", String.valueOf(((AbsWSRichWidgetData)localObject).a()));
    boolean bool;
    if ((localObject instanceof WSCommercialInfo))
    {
      localObject = (WSCommercialInfo)localObject;
      if (((WSCommercialInfo)localObject).b() == 5)
      {
        bool = true;
        a(localHashMap, bool, ((WSCommercialInfo)localObject).b());
      }
    }
    for (;;)
    {
      a("gzh_exposure", paramString1, paramString2, paramWSVerticalItemData, localHashMap, 0);
      return;
      bool = false;
      break;
      if ((localObject instanceof WSPublisherInfo)) {
        localHashMap.put("upload_from", "0040");
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    String str;
    if (paramstSimpleMetaFeed != null)
    {
      str = paramstSimpleMetaFeed.poster_id;
      if (!TextUtils.equals(str, WeishiUtils.d())) {
        break label49;
      }
      WeishiUtils.c("homepage_main");
    }
    for (;;)
    {
      a(paramString1, paramString2, paramString3, paramstSimpleMetaFeed, paramInt, "", null);
      return;
      str = "";
      break;
      label49:
      WeishiUtils.c("homepage_guest");
    }
  }
  
  private static void a(String paramString1, String paramString2, String paramString3, stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt, String paramString4, Map<String, String> paramMap)
  {
    paramString4 = a(paramString1).addParams(WSPublicAccReport.getInstance().getFeedsBaseParams(paramString3, paramInt, paramstSimpleMetaFeed)).setOperationId(paramString4);
    paramString3 = paramMap;
    if (paramMap == null) {
      paramString3 = new HashMap();
    }
    paramString3.put("play_scene", paramString2);
    paramString1 = "0";
    if (paramstSimpleMetaFeed != null) {
      if (!WSFeedUtils.a(paramstSimpleMetaFeed.poster)) {
        break label99;
      }
    }
    label99:
    for (paramString1 = "1";; paramString1 = "0")
    {
      paramString3.put("is_livenow", paramString1);
      paramString4.addExtParams(paramString3);
      a(paramString4, "gzh_click");
      return;
    }
  }
  
  private static void a(String paramString1, String paramString2, String paramString3, stSimpleMetaFeed paramstSimpleMetaFeed, String paramString4, Map<String, String> paramMap)
  {
    paramString3 = a(paramString1).addParams(WSPublicAccReport.getInstance().getFeedsBaseParams(paramString3, 0, paramstSimpleMetaFeed)).setOperationId(paramString4);
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
    stSimpleMetaFeed localstSimpleMetaFeed = paramWSVerticalItemData.a();
    String str = "";
    paramWSVerticalItemData = str;
    if (localstSimpleMetaFeed != null)
    {
      paramWSVerticalItemData = str;
      if (localstSimpleMetaFeed.opInfo != null) {
        paramWSVerticalItemData = localstSimpleMetaFeed.opInfo.traceId;
      }
    }
    paramMap.put("play_scene", paramString3);
    paramString3 = WSPublicAccReport.getInstance().getFeedsBaseParams("videotag_rich", paramInt, localstSimpleMetaFeed, paramWSVerticalItemData, "");
    a(a(paramString2).addParams(paramString3).addExtParams(paramMap), paramString1);
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (paramBoolean)
    {
      a(paramString1, paramString2, "like", paramstSimpleMetaFeed, 1001001, "", null);
      return;
    }
    a(paramString1, paramString2, "like", paramstSimpleMetaFeed, 1001002, "", null);
  }
  
  public static void a(List<WSVerticalItemData> paramList, boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = null;
    HashMap localHashMap = new HashMap();
    if (paramBoolean1)
    {
      localObject = "1";
      localHashMap.put("trigger_type", localObject);
      if (!paramBoolean2) {
        break label99;
      }
    }
    label99:
    for (Object localObject = "true";; localObject = "false")
    {
      localHashMap.put("request_result", localObject);
      if (paramBoolean2) {
        break label107;
      }
      localHashMap.put("failure_type", String.valueOf(paramInt));
      a(paramString1, paramString2, "floating_layer_request", null, "", localHashMap);
      return;
      localObject = "2";
      break;
    }
    label107:
    if ((paramList != null) && (paramList.size() > 0) && ((((WSVerticalItemData)paramList.get(0)).a() instanceof stSimpleMetaFeed)))
    {
      localObject = ((WSVerticalItemData)paramList.get(0)).a();
      localStringBuilder = new StringBuilder();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        WSVerticalItemData localWSVerticalItemData = (WSVerticalItemData)localIterator.next();
        if (!TextUtils.isEmpty(localWSVerticalItemData.a().id))
        {
          localStringBuilder.append(localWSVerticalItemData.a().id);
          localStringBuilder.append("_");
        }
      }
      if (paramList.size() > 1) {
        localStringBuilder.deleteCharAt(localStringBuilder.length() - 1);
      }
      localHashMap.put("feedid_list", localStringBuilder.toString());
    }
    for (paramList = (List<WSVerticalItemData>)localObject;; paramList = localStringBuilder)
    {
      a(paramString1, paramString2, "floating_layer_request", paramList, "", localHashMap);
      return;
      localHashMap.put("feedid_list", "");
    }
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
  
  private static void a(Map<String, String> paramMap, boolean paramBoolean, int paramInt)
  {
    if (paramBoolean) {}
    for (String str = "2";; str = "4")
    {
      paramMap.put("commerce_type", str);
      paramMap.put("businesstag_type", String.valueOf(paramInt));
      return;
    }
  }
  
  private static String b(String paramString)
  {
    if (TextUtils.equals(paramString, "recommend_tab")) {
      return jdField_a_of_type_JavaLangString;
    }
    return "";
  }
  
  public static void b(String paramString)
  {
    jdField_b_of_type_JavaLangString = paramString;
  }
  
  public static void b(String paramString1, String paramString2, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    a(paramString1, paramString2, "forward", paramstSimpleMetaFeed, paramInt, "", null);
  }
  
  public static void b(String paramString1, String paramString2, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    a(paramString1, paramString2, "like", paramstSimpleMetaFeed, 1001003, "", null);
  }
  
  public static void c(String paramString1, String paramString2, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    a(paramString1, paramString2, "profile", paramstSimpleMetaFeed, paramInt, "", null);
  }
  
  public static void c(String paramString1, String paramString2, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    HashMap localHashMap = new HashMap();
    if (paramstSimpleMetaFeed != null) {}
    for (String str = a(paramstSimpleMetaFeed.opVideo);; str = "0")
    {
      localHashMap.put("material_type", str);
      a(paramString1, paramString2, "more_operations", paramstSimpleMetaFeed, 1000001, "", localHashMap);
      return;
    }
  }
  
  public static void d(String paramString1, String paramString2, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (paramstSimpleMetaFeed != null) {}
    for (stNewIconStyle localstNewIconStyle = paramstSimpleMetaFeed.new_icon; localstNewIconStyle == null; localstNewIconStyle = null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("type", localstNewIconStyle.tag_type + "");
    a(paramString1, paramString2, "videoplay_tag", paramstSimpleMetaFeed, paramInt, String.valueOf(localstNewIconStyle.id), localHashMap);
  }
  
  public static void d(String paramString1, String paramString2, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    a(paramString1, paramString2, "home_icon", paramstSimpleMetaFeed, 1000001, "", null);
  }
  
  public static void e(String paramString1, String paramString2, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    a(paramString1, paramString2, "follow", paramstSimpleMetaFeed, 1004001, "", null);
  }
  
  public static void f(String paramString1, String paramString2, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if (!WeishiGuideUtils.a(BaseApplicationImpl.getApplication())) {}
    for (int i = 1000002;; i = 1000003)
    {
      a(paramString1, paramString2, "video_title", paramstSimpleMetaFeed, i, "", null);
      return;
    }
  }
  
  public static void g(String paramString1, String paramString2, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    a(paramString1, paramString2, "comment_entry", paramstSimpleMetaFeed, 1000001, "", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport
 * JD-Core Version:    0.7.0.1
 */
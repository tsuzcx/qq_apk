package com.tencent.biz.pubaccount.weishi_new.report;

import UserGrowth.stH5OpInfo;
import UserGrowth.stOpVideo;
import UserGrowth.stReportItem;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stVideoTag;
import android.text.TextUtils;
import bdjw;
import com.google.gson.Gson;
import com.tencent.biz.pubaccount.weishi_new.push.IWSPushBaseStrategy;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushGloryKingModel;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushPreloadModel;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushStrategyInfo;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import pws;
import vjx;
import vkb;
import vkc;
import vmp;
import vnd;

public class WSPublicAccReport
{
  private static final String KEY_SESSION_ID = "key_session_id";
  private static final String KEY_SESSION_STAMP = "key_session_stamp";
  private static final String SCENE_FROM_PUBLIC_ACC = "QQ_official_account";
  private static final String SCENE_FROM_TRENDS_TAB = "weishi_share_trendstab";
  public static final String SOP_NAME_FEEDS = "feeds";
  public static final String SOP_NAME_FOCUS = "focus";
  public static final String SOP_NAME_FOCUS_FALLBACK = "focus_fallback";
  public static final String SOP_NAME_VIDEO_PLAY = "fullscreen_videoplay";
  private static volatile WSPublicAccReport instance;
  private String mEnterPublicAccFrom;
  private String mLocalTestId;
  private String mPushId;
  private vkb mRecommendFullScreenInfo;
  private String mSessionId;
  private String mSessionStamp;
  private Map<String, Long> pageVisitTimeMap = new HashMap();
  private long publicAccEnterTime;
  private long toForegroundTime;
  
  private void baseActionReport(String paramString1, String paramString2, Map<String, String> paramMap1, Map<String, String> paramMap2, String paramString3, int paramInt)
  {
    String str = vnd.a(paramInt);
    new WSStatisticsReporter.Builder().addParams(paramMap1).addExtParams(paramMap2).setSceneFrom("QQ_official_account").setSopName(paramString2).setTestId(str).setPushId(this.mPushId).setOperationId(paramString3).setFlush(true).setImmediatelyUpload(vnd.c()).build(paramString1).report();
  }
  
  private String getFeedOpVideoType(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    if ((paramstSimpleMetaFeed != null) && (paramstSimpleMetaFeed.opVideo != null)) {
      return String.valueOf(paramstSimpleMetaFeed.opVideo.videoType);
    }
    return String.valueOf(0);
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
    localHashMap.put("opvideo_type", getFeedOpVideoType(paramstSimpleMetaFeed));
    localHashMap.put("material_type", getFeedOpVideoType(paramstSimpleMetaFeed));
    localHashMap.put("cover_type", vnd.a(paramstSimpleMetaFeed));
    if ((paramstSimpleMetaFeed != null) && (paramstSimpleMetaFeed.videoTag != null)) {}
    for (paramstSimpleMetaFeed = String.valueOf(paramstSimpleMetaFeed.videoTag.tagId);; paramstSimpleMetaFeed = "")
    {
      localHashMap.put("tag_id", paramstSimpleMetaFeed);
      return localHashMap;
    }
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
    localHashMap.put("row_key", vnd.b());
    localHashMap.put("push_extra", paramString2);
    localHashMap.put("app_extra", "");
    localHashMap.put("push_entry", paramString3);
    localHashMap.put("click_to", String.valueOf(paramInt2));
    localHashMap.put("app_live_time", String.valueOf(paramLong));
    localHashMap.put("operation_or_not", String.valueOf(paramInt3));
    baseActionReport("gzh_action", "", localHashMap, paramMap, "", 1);
  }
  
  private void reportPageVisited(String paramString, int paramInt, long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("event_type", String.valueOf(paramInt));
    localHashMap.put("page_live_time", String.valueOf(paramLong));
    baseActionReport("gzh_pagevisit", paramString, localHashMap, null, "", 1);
  }
  
  private void reset()
  {
    this.mRecommendFullScreenInfo = null;
    this.mPushId = "";
    this.pageVisitTimeMap.clear();
    vnd.d("");
    vki.a = false;
  }
  
  private void resetLocalTestId()
  {
    this.mLocalTestId = LocalMultiProcConfig.getString4Uin("key_default_test_id", "", vnd.a());
  }
  
  private void setSessionId(String paramString)
  {
    this.mSessionId = paramString;
    LocalMultiProcConfig.putString("weishi_usergrowth", "key_session_id", paramString);
  }
  
  private void setSessionStamp(String paramString)
  {
    this.mSessionStamp = paramString;
    LocalMultiProcConfig.putString("weishi_usergrowth", "key_session_stamp", paramString);
  }
  
  private String switchTabSopName(int paramInt, boolean paramBoolean)
  {
    if (paramInt == 0) {
      return "focus";
    }
    if (paramBoolean) {
      return "feeds_fullscreen";
    }
    return "feeds";
  }
  
  private void trendsTabActionReport(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, long paramLong, int paramInt3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("event_type", paramString1);
    localHashMap.put("push_count", String.valueOf(paramInt1));
    localHashMap.put("row_key", vnd.b());
    localHashMap.put("push_extra", paramString2);
    localHashMap.put("app_extra", "");
    localHashMap.put("push_entry", paramString3);
    localHashMap.put("click_to", String.valueOf(paramInt2));
    localHashMap.put("app_live_time", String.valueOf(paramLong));
    localHashMap.put("operation_or_not", String.valueOf(paramInt3));
    new WSStatisticsReporter.Builder().addParams(localHashMap).setSceneFrom("weishi_share_trendstab").setSopName("").setTestId(vnd.a(6)).setPushId(this.mPushId).setOperationId("").setFlush(true).setImmediatelyUpload(vnd.c()).build("gzh_action").report();
  }
  
  public void backgroundPublicAccReport()
  {
    long l = 0L;
    if (this.toForegroundTime == 0L) {
      this.toForegroundTime = this.publicAccEnterTime;
    }
    if (this.toForegroundTime > 0L) {
      l = System.currentTimeMillis() - this.toForegroundTime;
    }
    publicAccActionReport("3", 0, "", "", 0, l, 0, null);
  }
  
  public void closePublicAccReport(int paramInt)
  {
    long l = 0L;
    if (this.toForegroundTime > 0L) {
      l = System.currentTimeMillis() - this.toForegroundTime;
    }
    for (;;)
    {
      publicAccActionReport("2", 0, "", "", 0, l, paramInt, null);
      reset();
      return;
      if (this.publicAccEnterTime > 0L) {
        l = System.currentTimeMillis() - this.publicAccEnterTime;
      }
    }
  }
  
  public void enterPublicAccReport(WSRedDotPushMsg paramWSRedDotPushMsg, int paramInt, String paramString)
  {
    int i = 1;
    resetLocalTestId();
    this.publicAccEnterTime = System.currentTimeMillis();
    this.toForegroundTime = this.publicAccEnterTime;
    setSessionId(String.valueOf(this.publicAccEnterTime));
    setSessionStamp(String.valueOf(this.publicAccEnterTime));
    setEnterPublicAccFrom(paramString);
    paramString = "";
    String str = "2";
    HashMap localHashMap = new HashMap();
    this.mPushId = "";
    if (paramWSRedDotPushMsg != null)
    {
      this.mPushId = paramWSRedDotPushMsg.mPushId;
      localObject = paramWSRedDotPushMsg.mMsgData;
      paramString = (String)localObject;
      if ((paramWSRedDotPushMsg.mStrategyInfo instanceof WSPushStrategyInfo))
      {
        paramString = ((WSPushStrategyInfo)paramWSRedDotPushMsg.mStrategyInfo).mWSPushPreloadModel;
        WSPushGloryKingModel localWSPushGloryKingModel = ((WSPushStrategyInfo)paramWSRedDotPushMsg.mStrategyInfo).mWSPushGloryKingModel;
        if (paramString != null)
        {
          if (!paramString.a) {
            break label263;
          }
          paramWSRedDotPushMsg = String.valueOf(1);
          localHashMap.put("preload_status", paramWSRedDotPushMsg);
        }
        paramString = (String)localObject;
        if (localWSPushGloryKingModel != null)
        {
          localHashMap.put("material_type", String.valueOf(localWSPushGloryKingModel.a));
          paramString = (String)localObject;
        }
      }
    }
    Object localObject = vnd.a();
    paramWSRedDotPushMsg = str;
    if (vnd.a((pws)localObject)) {
      paramWSRedDotPushMsg = "1";
    }
    if (TextUtils.equals(paramWSRedDotPushMsg, "2"))
    {
      str = "0";
      if (localObject != null) {
        str = ((pws)localObject).e();
      }
      localHashMap.put("is_yunying_content", str);
    }
    if (paramInt == 3) {
      paramInt = i;
    }
    for (;;)
    {
      publicAccActionReport("1", vnd.a(), paramString, paramWSRedDotPushMsg, paramInt, 0L, 0, localHashMap);
      return;
      label263:
      paramWSRedDotPushMsg = String.valueOf(0);
      break;
    }
  }
  
  public void enterTrendsTabReport(WSRedDotPushMsg paramWSRedDotPushMsg, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    setSessionId(String.valueOf(l));
    setSessionStamp(String.valueOf(l));
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
        break label103;
      }
    }
    label103:
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
    baseActionReport(paramString, "feeds", localHashMap, new HashMap(), "", 1);
  }
  
  public void feedsItemReport(String paramString, stSimpleMetaFeed paramstSimpleMetaFeed, stReportItem paramstReportItem, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("position", "feeds_video" + paramstReportItem.upos);
    localHashMap.put("feed_id", paramstReportItem.feedid);
    localHashMap.put("owner_id", paramstReportItem.authorid);
    if (paramInt != 0) {
      localHashMap.put("action_id", String.valueOf(paramInt));
    }
    localHashMap.put("global_key", vkc.a().a(paramstSimpleMetaFeed.traceId));
    for (;;)
    {
      try
      {
        if (paramstSimpleMetaFeed.map_ext == null) {
          continue;
        }
        str = new Gson().toJson(paramstSimpleMetaFeed.map_ext);
        localHashMap.put("feed_pass_key", str);
      }
      catch (Exception localException)
      {
        String str;
        bdjw.a(localException);
        continue;
      }
      baseActionReport(paramString, "feeds", localHashMap, getFeedsItemReportExtMap(paramstSimpleMetaFeed, paramstReportItem), "", 1);
      return;
      str = "";
    }
  }
  
  public void foregroundPublicAccReport()
  {
    this.toForegroundTime = System.currentTimeMillis();
    setSessionStamp(String.valueOf(this.toForegroundTime));
    publicAccActionReport("4", 0, "", "", 0, 0L, 0, null);
  }
  
  public String getEnterPublicAccFrom()
  {
    return this.mEnterPublicAccFrom;
  }
  
  public Map<String, String> getFeedsBaseParams(String paramString, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    HashMap localHashMap = new HashMap();
    if (paramInt != 0) {
      localHashMap.put("action_id", String.valueOf(paramInt));
    }
    String str = "";
    Object localObject = "";
    if (paramstSimpleMetaFeed != null)
    {
      str = paramstSimpleMetaFeed.id;
      localObject = paramstSimpleMetaFeed.poster_id;
      localHashMap.put("global_key", vkc.a().a(paramstSimpleMetaFeed.traceId));
      if (paramstSimpleMetaFeed.map_ext == null) {
        break label154;
      }
    }
    label154:
    for (paramstSimpleMetaFeed = new Gson().toJson(paramstSimpleMetaFeed.map_ext);; paramstSimpleMetaFeed = "")
    {
      localHashMap.put("feed_pass_key", paramstSimpleMetaFeed);
      paramstSimpleMetaFeed = (stSimpleMetaFeed)localObject;
      localObject = paramstSimpleMetaFeed;
      localHashMap.put("position", paramString);
      localHashMap.put("feed_id", str);
      localHashMap.put("owner_id", localObject);
      return localHashMap;
    }
  }
  
  public Map<String, String> getFeedsBaseParamsWithoutFeed(String paramString, int paramInt)
  {
    return getFeedsBaseParams(paramString, paramInt, null);
  }
  
  public String getLocalTestId()
  {
    return this.mLocalTestId;
  }
  
  public vkb getRecommendFullScreenInfo()
  {
    if (this.mRecommendFullScreenInfo == null) {
      this.mRecommendFullScreenInfo = new vkb(this);
    }
    return this.mRecommendFullScreenInfo;
  }
  
  public String getSessionId()
  {
    if (TextUtils.isEmpty(this.mSessionId)) {
      return LocalMultiProcConfig.getString("weishi_usergrowth", "key_session_id", "");
    }
    return this.mSessionId;
  }
  
  public String getSessionStamp()
  {
    if (TextUtils.isEmpty(this.mSessionStamp)) {
      return LocalMultiProcConfig.getString("weishi_usergrowth", "key_session_stamp", "");
    }
    return this.mSessionStamp;
  }
  
  public void reportAttentionClick(int paramInt, String paramString, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("red_dot_quantity", String.valueOf(paramInt));
    if (paramBoolean) {}
    for (String str = "0";; str = "1")
    {
      localHashMap.put("is_click", str);
      baseActionReport("gzh_click", paramString, getFeedsBaseParamsWithoutFeed("follow_tab", 1000001), localHashMap, "", 10001);
      return;
    }
  }
  
  public void reportAttentionRedDotExposure(int paramInt, String paramString)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("red_dot_quantity", String.valueOf(paramInt));
    baseActionReport("gzh_exposure", paramString, getFeedsBaseParamsWithoutFeed("follow_tab", 1000001), localHashMap, "", 10001);
  }
  
  public void reportAvatarViewClick(int paramInt, boolean paramBoolean)
  {
    baseActionReport("gzh_click", switchTabSopName(paramInt, paramBoolean), getFeedsBaseParamsWithoutFeed("profile_tab", 1000001), null, "", 10001);
  }
  
  public void reportCallDialog(String paramString1, String paramString2, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("location", paramString2);
    baseActionReport(paramString1, "focus", getFeedsBaseParamsWithoutFeed("jump_window", paramInt), localHashMap, "", 1);
  }
  
  public void reportCallDialog(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    baseActionReport(paramString1, paramString2, getFeedsBaseParamsWithoutFeed(paramString3, paramInt), null, "", 1);
  }
  
  public void reportClickRichBlockPop(int paramInt1, int paramInt2, String paramString1, String paramString2)
  {
    if (TextUtils.equals(paramString2, "feeds")) {}
    for (int i = 1;; i = 2)
    {
      Map localMap = getFeedsBaseParamsWithoutFeed("popup", paramInt1);
      localMap.put("global_key", vkc.a().a(paramString1));
      baseActionReport("gzh_click", paramString2, localMap, null, String.valueOf(paramInt2), i);
      return;
    }
  }
  
  public void reportDownload(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    reportDownload(paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, 1);
  }
  
  public void reportDownload(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("position", String.valueOf(paramInt1));
    localHashMap.put("event_type", String.valueOf(paramInt2));
    localHashMap.put("dl_status", String.valueOf(paramInt3));
    localHashMap.put("dl_method", String.valueOf(paramInt4));
    localHashMap.put("install_status", String.valueOf(paramInt5));
    vmp.c("beacon-download", paramInt1 + " - " + paramInt2 + " - " + paramInt3 + " - " + paramInt4 + " - " + paramInt5);
    baseActionReport("gzh_download", "", localHashMap, null, "", paramInt6);
  }
  
  public void reportExposeRichBlockPop(int paramInt, String paramString1, String paramString2)
  {
    if (TextUtils.equals(paramString2, "feeds")) {}
    for (int i = 1;; i = 2)
    {
      Map localMap = getFeedsBaseParamsWithoutFeed("popup", 0);
      localMap.put("global_key", vkc.a().a(paramString1));
      baseActionReport("gzh_exposure", paramString2, localMap, null, String.valueOf(paramInt), i);
      return;
    }
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
        localObject1 = vjx.a((stSimpleMetaFeed)localObject2, ((Integer)localObject1).intValue());
        if ((((stReportItem)localObject1).video_type != 1) && (((stReportItem)localObject1).video_type != 6)) {
          feedsItemReport("gzh_exposure", (stSimpleMetaFeed)localObject2, (stReportItem)localObject1, 0);
        }
      }
    }
  }
  
  public void reportFallListRequest(boolean paramBoolean1, boolean paramBoolean2, int paramInt, String paramString1, String paramString2)
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
        break label133;
      }
    }
    label133:
    for (paramString1 = "1";; paramString1 = "0")
    {
      localHashMap2.put("is_auto_refresh", paramString1);
      baseActionReport("gzh_exposure", "feeds_refresh_request", localHashMap1, localHashMap2, "", 1);
      return;
    }
  }
  
  public void reportMessageBubblePopupClick(int paramInt, boolean paramBoolean)
  {
    baseActionReport("gzh_click", switchTabSopName(paramInt, paramBoolean), getFeedsBaseParamsWithoutFeed("news_popup", 1000001), null, "", 10001);
  }
  
  public void reportMessageBubblePopupExposure(int paramInt, boolean paramBoolean)
  {
    baseActionReport("gzh_exposure", switchTabSopName(paramInt, paramBoolean), getFeedsBaseParamsWithoutFeed("news_popup", 0), null, "", 10001);
  }
  
  public void reportMsgEntry(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    Map localMap = getFeedsBaseParamsWithoutFeed("msg_extry", paramInt2);
    localMap.put("global_key", vkc.a().a(paramString2));
    paramString2 = new HashMap();
    paramString2.put("type", String.valueOf(paramInt1));
    baseActionReport(paramString1, "feeds", localMap, paramString2, String.valueOf(paramInt3), 4);
  }
  
  public void reportNotificationClick(int paramInt, boolean paramBoolean)
  {
    baseActionReport("gzh_click", switchTabSopName(paramInt, paramBoolean), getFeedsBaseParamsWithoutFeed("message_notification", 1000001), null, "", 10001);
  }
  
  public void reportOperationCard(String paramString, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    Map localMap = getFeedsBaseParams("opcard", paramInt, paramstSimpleMetaFeed);
    Object localObject;
    if ((paramstSimpleMetaFeed != null) && (paramstSimpleMetaFeed.h5_op_info != null))
    {
      localObject = paramstSimpleMetaFeed.h5_op_info;
      paramstSimpleMetaFeed = ((stH5OpInfo)localObject).exp;
    }
    for (;;)
    {
      if ((paramstSimpleMetaFeed != null) && (paramstSimpleMetaFeed.size() > 0))
      {
        if (localObject != null) {}
        for (localObject = String.valueOf(((stH5OpInfo)localObject).id);; localObject = "")
        {
          baseActionReport(paramString, "feeds", localMap, paramstSimpleMetaFeed, (String)localObject, 1);
          return;
        }
      }
      if (localObject != null) {}
      for (paramstSimpleMetaFeed = String.valueOf(((stH5OpInfo)localObject).id);; paramstSimpleMetaFeed = "")
      {
        baseActionReport(paramString, "feeds", localMap, null, paramstSimpleMetaFeed, 1);
        return;
      }
      paramstSimpleMetaFeed = null;
      localObject = null;
    }
  }
  
  public void reportPageVisitEnter(String paramString)
  {
    this.pageVisitTimeMap.put(paramString, Long.valueOf(System.currentTimeMillis()));
    reportPageVisited(paramString, 1, 0L);
  }
  
  public void reportPageVisitExit(String paramString)
  {
    Long localLong = Long.valueOf(0L);
    if (this.pageVisitTimeMap != null) {
      localLong = (Long)this.pageVisitTimeMap.get(paramString);
    }
    if ((localLong != null) && (localLong.longValue() > 0L)) {}
    for (long l = System.currentTimeMillis() - localLong.longValue();; l = 0L)
    {
      reportPageVisited(paramString, 2, l);
      return;
    }
  }
  
  public void reportPersonHomeClick(int paramInt, boolean paramBoolean)
  {
    baseActionReport("gzh_click", switchTabSopName(paramInt, paramBoolean), getFeedsBaseParamsWithoutFeed("my_homepage", 1000001), null, "", 10001);
  }
  
  public void reportPublicAccDataExposure(stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt1, int paramInt2, int paramInt3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("preload_status", String.valueOf(paramInt1));
    localHashMap.put("feeds_list_type", String.valueOf(paramInt2));
    localHashMap.put("preload_count", String.valueOf(paramInt3));
    baseActionReport("gzh_exposure", "feeds", getFeedsBaseParams("feeds_data", 0, paramstSimpleMetaFeed), localHashMap, "", 1);
  }
  
  public void reportPublicAccDetailClick()
  {
    baseActionReport("gzh_click", "feeds", getFeedsBaseParamsWithoutFeed("wesee_info", 1000001), null, "", 1);
  }
  
  public void reportPublisher(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    baseActionReport(paramString1, paramString2, getFeedsBaseParamsWithoutFeed(paramString3, paramInt), null, "", 10004);
  }
  
  public void reportRecommendClick(boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    if (paramBoolean) {}
    for (String str = "0";; str = "1")
    {
      localHashMap.put("is_click", str);
      baseActionReport("gzh_click", "focus", getFeedsBaseParamsWithoutFeed("recommend_tab", 1000001), localHashMap, "", 10001);
      return;
    }
  }
  
  public void reportShareClick(String paramString1, int paramInt, String paramString2, String paramString3, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("material_type", getFeedOpVideoType(paramstSimpleMetaFeed));
    if (!TextUtils.isEmpty(paramString3)) {
      localHashMap.put("play_scene", paramString3);
    }
    baseActionReport("gzh_click", paramString2, getFeedsBaseParams(paramString1, paramInt, paramstSimpleMetaFeed), localHashMap, "", 1);
  }
  
  public void reportVideoPlayUpdateExp(int paramInt)
  {
    String str = "";
    if (paramInt == 2) {
      str = "QQ_official_account";
    }
    for (;;)
    {
      new WSStatisticsReporter.Builder().addParams(getFeedsBaseParamsWithoutFeed("videoplay_update", 0)).setSceneFrom(str).setSopName("fullscreen_videoplay").setTestId(vnd.a(1)).setPushId(this.mPushId).setFlush(true).setImmediatelyUpload(vnd.c()).build("gzh_exposure").report();
      return;
      if (paramInt == 6) {
        str = "weishi_share_trendstab";
      }
    }
  }
  
  public void setEnterPublicAccFrom(String paramString)
  {
    this.mEnterPublicAccFrom = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport
 * JD-Core Version:    0.7.0.1
 */
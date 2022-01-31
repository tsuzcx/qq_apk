package com.tencent.biz.pubaccount.weishi_new.report;

import UserGrowth.stH5OpInfo;
import UserGrowth.stOpVideo;
import UserGrowth.stReportItem;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stVideoTag;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.biz.pubaccount.weishi_new.push.IWSPushBaseStrategy;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushPreloadModel;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushStrategyInfo;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import tee;
import tjr;
import tlo;
import tlv;
import tmv;

public class WSPublicAccReport
{
  private static final String KEY_SESSION_ID = "key_session_id";
  private static final String KEY_SESSION_STAMP = "key_session_stamp";
  private static final String SCENE_FROM_PUBLIC_ACC = "QQ_official_account";
  private static final String SCENE_FROM_TRENDS_TAB = "weishi_share_trendstab";
  private static final String SOP_NAME_FEEDS = "feeds";
  public static final String SOP_NAME_FOCUS = "focus";
  public static final String SOP_NAME_FOCUS_FALLBACK = "focus_fallback";
  public static final String SOP_NAME_VIDEO_PLAY = "fullscreen_videoplay";
  private static volatile WSPublicAccReport instance;
  private String mPushId;
  private String mSessionId;
  private String mSessionStamp;
  private String mTestId;
  private Map<String, Long> pageVisitTimeMap = new HashMap();
  private long publicAccEnterTime;
  private long toForegroundTime;
  
  private void baseActionReport(String paramString1, String paramString2, Map<String, String> paramMap, String paramString3)
  {
    baseActionReport(paramString1, paramString2, paramMap, null, paramString3);
  }
  
  private void baseActionReport(String paramString1, String paramString2, Map<String, String> paramMap1, Map<String, String> paramMap2, String paramString3)
  {
    new WSStatisticsReporter.Builder().addParams(paramMap1).addExtParams(paramMap2).setSceneFrom("QQ_official_account").setSopName(paramString2).setTestId(this.mTestId).setPushId(this.mPushId).setOperationId(paramString3).setFlush(true).build(paramString1).report();
  }
  
  public static String getEntryPositionId(String paramString)
  {
    if ("fullscreen_videoplay".equals(paramString)) {
      return "comment_entry";
    }
    if ("focus".equals(paramString)) {
      return "dynamics_comment_entry";
    }
    if ("focus_fallback".equals(paramString)) {
      return "dynamics_comment_entry";
    }
    return "dynamics_comment_entry";
  }
  
  private Map<String, String> getFeedsBaseParamsWithoutFeed(String paramString, int paramInt)
  {
    return getFeedsBaseParams(paramString, paramInt, null);
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
    if ((paramstSimpleMetaFeed != null) && (paramstSimpleMetaFeed.opVideo != null))
    {
      paramstReportItem = String.valueOf(paramstSimpleMetaFeed.opVideo.videoType);
      localHashMap.put("opvideo_type", paramstReportItem);
      localHashMap.put("cover_type", tlv.a(paramstSimpleMetaFeed));
      if ((paramstSimpleMetaFeed == null) || (paramstSimpleMetaFeed.videoTag == null)) {
        break label189;
      }
    }
    label189:
    for (paramstSimpleMetaFeed = String.valueOf(paramstSimpleMetaFeed.videoTag.tagId);; paramstSimpleMetaFeed = "")
    {
      localHashMap.put("tag_id", paramstSimpleMetaFeed);
      return localHashMap;
      paramstReportItem = "";
      break;
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
  
  public static String getPagePositionId(String paramString)
  {
    if ("fullscreen_videoplay".equals(paramString)) {
      return "comment_page";
    }
    if ("focus".equals(paramString)) {
      return "dynamics_comment_page";
    }
    if ("focus_fallback".equals(paramString)) {
      return "dynamics_comment_page";
    }
    return "dynamics_comment_page";
  }
  
  public static String getTagPositionId(String paramString)
  {
    if ("fullscreen_videoplay".equals(paramString)) {
      return "comment_tag";
    }
    if ("focus".equals(paramString)) {
      return "dynamics_comment_tag";
    }
    if ("focus_fallback".equals(paramString)) {
      return "dynamics_comment_tag";
    }
    return "dynamics_comment_tag";
  }
  
  private void publicAccActionReport(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, long paramLong, int paramInt3, Map<String, String> paramMap)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("event_type", paramString1);
    localHashMap.put("push_count", String.valueOf(paramInt1));
    localHashMap.put("row_key", tlv.b());
    localHashMap.put("push_extra", paramString2);
    localHashMap.put("app_extra", "");
    localHashMap.put("push_entry", paramString3);
    localHashMap.put("click_to", String.valueOf(paramInt2));
    localHashMap.put("app_live_time", String.valueOf(paramLong));
    localHashMap.put("operation_or_not", String.valueOf(paramInt3));
    baseActionReport("gzh_action", "", localHashMap, paramMap, "");
  }
  
  private void reportPageVisited(String paramString, int paramInt, long paramLong)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("event_type", String.valueOf(paramInt));
    localHashMap.put("page_live_time", String.valueOf(paramLong));
    baseActionReport("gzh_pagevisit", paramString, localHashMap, null, "");
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
  
  private void trendsTabActionReport(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, long paramLong, int paramInt3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("event_type", paramString1);
    localHashMap.put("push_count", String.valueOf(paramInt1));
    localHashMap.put("row_key", tlv.b());
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
    this.mTestId = tlv.a(1);
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
    this.mTestId = tlv.a(1);
    if (this.toForegroundTime > 0L) {
      l = System.currentTimeMillis() - this.toForegroundTime;
    }
    for (;;)
    {
      publicAccActionReport("2", 0, "", "", 0, l, paramInt, null);
      this.mPushId = "";
      this.pageVisitTimeMap.clear();
      tlv.c("");
      return;
      if (this.publicAccEnterTime > 0L) {
        l = System.currentTimeMillis() - this.publicAccEnterTime;
      }
    }
  }
  
  public void enterPublicAccReport(WSRedDotPushMsg paramWSRedDotPushMsg, int paramInt)
  {
    int i = 1;
    this.publicAccEnterTime = System.currentTimeMillis();
    this.toForegroundTime = this.publicAccEnterTime;
    setSessionId(String.valueOf(this.publicAccEnterTime));
    setSessionStamp(String.valueOf(this.publicAccEnterTime));
    this.mTestId = tlv.a(1);
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
            break label190;
          }
          paramWSRedDotPushMsg = String.valueOf(1);
          localHashMap.put("preload_status", paramWSRedDotPushMsg);
          localObject = str2;
        }
      }
    }
    paramWSRedDotPushMsg = str1;
    if (tlv.a(tlv.a())) {
      paramWSRedDotPushMsg = "1";
    }
    if (paramInt == 3) {
      paramInt = i;
    }
    for (;;)
    {
      publicAccActionReport("1", tlv.a(), (String)localObject, paramWSRedDotPushMsg, paramInt, 0L, 0, localHashMap);
      return;
      label190:
      paramWSRedDotPushMsg = String.valueOf(0);
      break;
    }
  }
  
  public void enterTrendsTabReport(WSRedDotPushMsg paramWSRedDotPushMsg, boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    setSessionId(String.valueOf(l));
    setSessionStamp(String.valueOf(l));
    this.mTestId = tlv.a(6);
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
        break label112;
      }
    }
    label112:
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
    HashMap localHashMap = new HashMap();
    localHashMap.put("position", "feeds_video" + paramstReportItem.upos);
    localHashMap.put("feed_id", paramstReportItem.feedid);
    localHashMap.put("owner_id", paramstReportItem.authorid);
    if (paramInt != 0) {
      localHashMap.put("action_id", String.valueOf(paramInt));
    }
    localHashMap.put("global_key", tee.a().a(paramstSimpleMetaFeed.traceId));
    if (paramstSimpleMetaFeed.map_ext != null) {}
    for (paramString2 = new Gson().toJson(paramstSimpleMetaFeed.map_ext);; paramString2 = "")
    {
      localHashMap.put("feed_pass_key", paramString2);
      baseActionReport(paramString1, "feeds", localHashMap, getFeedsItemReportExtMap(paramstSimpleMetaFeed, paramstReportItem), "");
      return;
    }
  }
  
  public void foregroundPublicAccReport()
  {
    this.mTestId = tlv.a(1);
    this.toForegroundTime = System.currentTimeMillis();
    setSessionStamp(String.valueOf(this.toForegroundTime));
    publicAccActionReport("4", 0, "", "", 0, 0L, 0, null);
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
      localHashMap.put("global_key", tee.a().a(paramstSimpleMetaFeed.traceId));
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
  
  public void reportAttentionClick(int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("red_dot_quantity", String.valueOf(paramInt));
    baseActionReport("gzh_click", "focus", getFeedsBaseParamsWithoutFeed("follow_tab", 1000001), localHashMap, "");
  }
  
  public void reportAvatarViewClick()
  {
    baseActionReport("gzh_click", "focus", getFeedsBaseParamsWithoutFeed("profile_tab", 1000001), null, "");
  }
  
  public void reportCallDialog(String paramString1, String paramString2, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("location", paramString2);
    baseActionReport(paramString1, "focus", getFeedsBaseParamsWithoutFeed("jump_window", paramInt), localHashMap, "");
  }
  
  public void reportClickRichBlockPop(int paramInt1, int paramInt2, String paramString)
  {
    this.mTestId = tlv.a(1);
    Map localMap = getFeedsBaseParamsWithoutFeed("popup", paramInt1);
    localMap.put("global_key", tee.a().a(paramString));
    baseActionReport("gzh_click", "feeds", localMap, String.valueOf(paramInt2));
  }
  
  public void reportCommentDing(String paramString, int paramInt1, int paramInt2, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    Map localMap = getFeedsBaseParams("dynamics_comment_like" + paramInt1, paramInt2, paramstSimpleMetaFeed);
    HashMap localHashMap = new HashMap();
    if (TextUtils.equals(paramString, "focus")) {}
    for (paramstSimpleMetaFeed = "focus";; paramstSimpleMetaFeed = "feeds")
    {
      localHashMap.put("play_scene", paramstSimpleMetaFeed);
      baseActionReport("gzh_click", paramString, localMap, localHashMap, "");
      return;
    }
  }
  
  public void reportCommentEntryClick(String paramString1, String paramString2, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    paramstSimpleMetaFeed = getFeedsBaseParams(paramString2, paramInt, paramstSimpleMetaFeed);
    HashMap localHashMap = new HashMap();
    if (TextUtils.equals(paramString1, "focus")) {}
    for (paramString2 = "focus";; paramString2 = "feeds")
    {
      localHashMap.put("play_scene", paramString2);
      baseActionReport("gzh_click", paramString1, paramstSimpleMetaFeed, localHashMap, "");
      return;
    }
  }
  
  public void reportCommentEntryTextClick(String paramString, int paramInt1, int paramInt2, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    Map localMap = getFeedsBaseParams("dynamics_comment_entry_text" + paramInt1, paramInt2, paramstSimpleMetaFeed);
    HashMap localHashMap = new HashMap();
    if (TextUtils.equals(paramString, "focus")) {}
    for (paramstSimpleMetaFeed = "focus";; paramstSimpleMetaFeed = "feeds")
    {
      localHashMap.put("play_scene", paramstSimpleMetaFeed);
      baseActionReport("gzh_click", paramString, localMap, localHashMap, "");
      return;
    }
  }
  
  public void reportCommentPageClick(String paramString1, String paramString2, int paramInt1, int paramInt2, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    paramstSimpleMetaFeed = getFeedsBaseParams(paramString2, paramInt1, paramstSimpleMetaFeed);
    HashMap localHashMap = new HashMap();
    localHashMap.put("object", String.valueOf(paramInt2));
    if (TextUtils.equals(paramString1, "focus")) {}
    for (paramString2 = "focus";; paramString2 = "feeds")
    {
      localHashMap.put("play_scene", paramString2);
      baseActionReport("gzh_click", paramString1, paramstSimpleMetaFeed, localHashMap, "");
      return;
    }
  }
  
  public void reportCommentPageExposure(String paramString1, String paramString2, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    paramstSimpleMetaFeed = getFeedsBaseParams(paramString2, 0, paramstSimpleMetaFeed);
    HashMap localHashMap = new HashMap();
    if (TextUtils.equals(paramString1, "focus")) {}
    for (paramString2 = "focus";; paramString2 = "feeds")
    {
      localHashMap.put("play_scene", paramString2);
      baseActionReport("gzh_exposure", paramString1, paramstSimpleMetaFeed, localHashMap, "");
      return;
    }
  }
  
  public void reportCommentReply(String paramString, int paramInt1, int paramInt2, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    Map localMap = getFeedsBaseParams("dynamics_comment_page_reply" + paramInt1, paramInt2, paramstSimpleMetaFeed);
    HashMap localHashMap = new HashMap();
    if (TextUtils.equals(paramString, "focus")) {}
    for (paramstSimpleMetaFeed = "focus";; paramstSimpleMetaFeed = "feeds")
    {
      localHashMap.put("play_scene", paramstSimpleMetaFeed);
      baseActionReport("gzh_click", paramString, localMap, localHashMap, "");
      return;
    }
  }
  
  public void reportCommentTagClick(String paramString1, String paramString2, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    paramstSimpleMetaFeed = getFeedsBaseParams(paramString2, paramInt, paramstSimpleMetaFeed);
    HashMap localHashMap = new HashMap();
    if (TextUtils.equals(paramString1, "focus")) {}
    for (paramString2 = "focus";; paramString2 = "feeds")
    {
      localHashMap.put("play_scene", paramString2);
      baseActionReport("gzh_click", paramString1, paramstSimpleMetaFeed, localHashMap, "");
      return;
    }
  }
  
  public void reportCommentTagExposure(String paramString1, String paramString2, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    paramstSimpleMetaFeed = getFeedsBaseParams(paramString2, 0, paramstSimpleMetaFeed);
    HashMap localHashMap = new HashMap();
    if (TextUtils.equals(paramString1, "focus")) {}
    for (paramString2 = "focus";; paramString2 = "feeds")
    {
      localHashMap.put("play_scene", paramString2);
      baseActionReport("gzh_exposure", paramString1, paramstSimpleMetaFeed, localHashMap, "");
      return;
    }
  }
  
  public void reportDownload(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.mTestId = tlv.a(1);
    HashMap localHashMap = new HashMap();
    localHashMap.put("position", String.valueOf(paramInt1));
    localHashMap.put("event_type", String.valueOf(paramInt2));
    localHashMap.put("dl_status", String.valueOf(paramInt3));
    localHashMap.put("dl_method", String.valueOf(paramInt4));
    localHashMap.put("install_status", String.valueOf(paramInt5));
    tlo.c("beacon-download", paramInt1 + " - " + paramInt2 + " - " + paramInt3 + " - " + paramInt4 + " - " + paramInt5);
    baseActionReport("gzh_download", "", localHashMap, "");
  }
  
  public void reportEnterVerticalVideo(List<tmv> paramList, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("trigger_type", String.valueOf(paramInt1));
    if (paramBoolean) {}
    for (Object localObject = "true";; localObject = "false")
    {
      localHashMap.put("request_result", localObject);
      if (!paramBoolean) {
        break label223;
      }
      if (!(((tmv)paramList.get(0)).a() instanceof stSimpleMetaFeed)) {
        break label201;
      }
      localObject = new StringBuilder();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        tmv localtmv = (tmv)localIterator.next();
        if (!TextUtils.isEmpty(((stSimpleMetaFeed)localtmv.a()).id))
        {
          ((StringBuilder)localObject).append(((stSimpleMetaFeed)localtmv.a()).id);
          ((StringBuilder)localObject).append("_");
        }
      }
    }
    if (paramList.size() > 1) {
      ((StringBuilder)localObject).deleteCharAt(((StringBuilder)localObject).length() - 1);
    }
    localHashMap.put("feedid_list", ((StringBuilder)localObject).toString());
    for (;;)
    {
      label201:
      baseActionReport("gzh_exposure", "fullscreen_videoplay", getFeedsBaseParamsWithoutFeed("floating_layer_request", 0), localHashMap, "");
      return;
      label223:
      localHashMap.put("failure_type", String.valueOf(paramInt2));
    }
  }
  
  public void reportExposeRichBlockPop(int paramInt, String paramString)
  {
    this.mTestId = tlv.a(1);
    Map localMap = getFeedsBaseParamsWithoutFeed("popup", 0);
    localMap.put("global_key", tee.a().a(paramString));
    baseActionReport("gzh_exposure", "feeds", localMap, String.valueOf(paramInt));
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
        localObject1 = tjr.a((stSimpleMetaFeed)localObject2, ((Integer)localObject1).intValue());
        if ((((stReportItem)localObject1).video_type != 1) && (((stReportItem)localObject1).video_type != 6)) {
          feedsItemReport("gzh_exposure", tlv.a(1), (stSimpleMetaFeed)localObject2, (stReportItem)localObject1, 0);
        }
      }
    }
  }
  
  public void reportMessageBubblePopupClick()
  {
    baseActionReport("gzh_click", "focus", getFeedsBaseParamsWithoutFeed("news_popup", 1000001), null, "");
  }
  
  public void reportMessageBubblePopupExposure()
  {
    baseActionReport("gzh_exposure", "focus", getFeedsBaseParamsWithoutFeed("news_popup", 0), null, "");
  }
  
  public void reportMsgEntry(String paramString1, int paramInt1, int paramInt2, int paramInt3, String paramString2)
  {
    this.mTestId = tlv.a(4);
    Map localMap = getFeedsBaseParamsWithoutFeed("msg_extry", paramInt2);
    localMap.put("global_key", tee.a().a(paramString2));
    paramString2 = new HashMap();
    paramString2.put("type", String.valueOf(paramInt1));
    baseActionReport(paramString1, "feeds", localMap, paramString2, String.valueOf(paramInt3));
  }
  
  public void reportNotificationClick()
  {
    baseActionReport("gzh_click", "focus", getFeedsBaseParamsWithoutFeed("message_notification", 1000001), null, "");
  }
  
  public void reportOperationCard(String paramString, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    Object localObject2 = null;
    this.mTestId = tlv.a(1);
    Map localMap = getFeedsBaseParams("opcard", paramInt, paramstSimpleMetaFeed);
    Object localObject1;
    if ((paramstSimpleMetaFeed != null) && (paramstSimpleMetaFeed.h5_op_info != null)) {
      localObject1 = paramstSimpleMetaFeed.h5_op_info;
    }
    for (paramstSimpleMetaFeed = ((stH5OpInfo)localObject1).exp;; paramstSimpleMetaFeed = localObject2)
    {
      if ((paramstSimpleMetaFeed != null) && (paramstSimpleMetaFeed.size() > 0))
      {
        if (localObject1 != null) {}
        for (localObject1 = String.valueOf(((stH5OpInfo)localObject1).id);; localObject1 = "")
        {
          baseActionReport(paramString, "feeds", localMap, paramstSimpleMetaFeed, (String)localObject1);
          return;
        }
      }
      if (localObject1 != null) {}
      for (paramstSimpleMetaFeed = String.valueOf(((stH5OpInfo)localObject1).id);; paramstSimpleMetaFeed = "")
      {
        baseActionReport(paramString, "feeds", localMap, paramstSimpleMetaFeed);
        return;
      }
      localObject1 = null;
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
  
  public void reportPersonHomeClick()
  {
    baseActionReport("gzh_click", "focus", getFeedsBaseParamsWithoutFeed("my_homepage", 1000001), null, "");
  }
  
  public void reportPublicAccDataExposure(stSimpleMetaFeed paramstSimpleMetaFeed, int paramInt1, int paramInt2, int paramInt3)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("preload_status", String.valueOf(paramInt1));
    localHashMap.put("feeds_list_type", String.valueOf(paramInt2));
    localHashMap.put("preload_count", String.valueOf(paramInt3));
    baseActionReport("gzh_exposure", "feeds", getFeedsBaseParams("feeds_data", 0, paramstSimpleMetaFeed), localHashMap, "");
  }
  
  public void reportPublicAccDetailClick()
  {
    this.mTestId = tlv.a(1);
    baseActionReport("gzh_click", "feeds", getFeedsBaseParamsWithoutFeed("wesee_info", 1000001), "");
  }
  
  public void reportPublisher(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    baseActionReport(paramString1, paramString2, getFeedsBaseParamsWithoutFeed(paramString3, paramInt), "");
  }
  
  public void reportRecommendClick()
  {
    baseActionReport("gzh_click", "focus", getFeedsBaseParamsWithoutFeed("recommend_tab", 1000001), null, "");
  }
  
  public void reportShareClick(String paramString1, int paramInt, String paramString2, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    baseActionReport("gzh_click", paramString2, getFeedsBaseParams(paramString1, paramInt, paramstSimpleMetaFeed), null, "");
  }
  
  public void reportVideoPlayUpdateExp(int paramInt)
  {
    String str = "";
    if (paramInt == 2) {
      str = "QQ_official_account";
    }
    for (;;)
    {
      new WSStatisticsReporter.Builder().addParams(getFeedsBaseParamsWithoutFeed("videoplay_update", 0)).setSceneFrom(str).setSopName("fullscreen_videoplay").setTestId(this.mTestId).setPushId(this.mPushId).setFlush(true).build("gzh_exposure").report();
      return;
      if (paramInt == 6) {
        str = "weishi_share_trendstab";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport
 * JD-Core Version:    0.7.0.1
 */
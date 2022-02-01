package com.tencent.biz.pubaccount.weishi_new.report;

import UserGrowth.stOpVideo;
import UserGrowth.stSimpleMetaFeed;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.biz.pubaccount.weishi_new.aiolist.WSAioListHelper;
import com.tencent.biz.pubaccount.weishi_new.cache.WSRedDotPreloadManager;
import com.tencent.biz.pubaccount.weishi_new.config.experiment.WSExpABTestManager;
import com.tencent.biz.pubaccount.weishi_new.push.IWSPushBaseStrategy;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushGloryKingModel;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushPreloadModel;
import com.tencent.biz.pubaccount.weishi_new.push.WSPushStrategyInfo;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WSSharePreferencesUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.report.WSVerticalBeaconReport;
import com.tencent.mobileqq.app.WeishiManager;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.HashMap;
import java.util.Map;

public class WSPublicAccReport
{
  private static final String KEY_ENTER_PUBLIC_FROM = "key_enter_public_from";
  private static final String KEY_PLAY_SCENE = "play_scene";
  private static final String KEY_SCENES_CHANNEL_FROM = "key_scenes_channel_from";
  private static final String KEY_SESSION_ID = "key_session_id";
  private static final String KEY_SESSION_STAMP = "key_session_stamp";
  public static final String SOP_NAME_FEEDS = "feeds";
  public static final String SOP_NAME_FOCUS = "focus";
  public static final String SOP_NAME_FOCUS_FALLBACK = "focus_fallback";
  public static final String SOP_NAME_VIDEO_PLAY = "fullscreen_videoplay";
  private static volatile WSPublicAccReport instance;
  private String mEnterPublicAccFrom;
  private boolean mIsReportedEnter;
  private String mLocalTestId;
  private String mPushId;
  private WSPublicAccReport.RecommendFullScreenInfo mRecommendFullScreenInfo;
  private String mScenesChannelFrom;
  private String mSessionId;
  private String mSessionStamp;
  private Map<String, Long> pageVisitTimeMap = new HashMap();
  private long publicAccEnterTime;
  private long toBackgroundTime;
  private long toForegroundTime;
  private long toTrendsWSBackgroundTime;
  private long toTrendsWSForegroundTime;
  private long trendsWSEnterTime;
  
  private void baseActionReport(String paramString1, String paramString2, Map<String, String> paramMap1, Map<String, String> paramMap2, String paramString3, int paramInt)
  {
    String str = WeishiUtils.a(paramInt);
    new WSStatisticsReporter.Builder().addParams(paramMap1).addExtParams(paramMap2).setSopName(paramString2).setTestId(str).setPushId(this.mPushId).setOperationId(paramString3).setFlush(true).build(paramString1).report();
  }
  
  private String getFeedOpVideoType(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    int i;
    if ((paramstSimpleMetaFeed != null) && (paramstSimpleMetaFeed.opVideo != null)) {
      i = paramstSimpleMetaFeed.opVideo.videoType;
    } else {
      i = 0;
    }
    return String.valueOf(i);
  }
  
  public static WSPublicAccReport getInstance()
  {
    if (instance == null) {
      try
      {
        if (instance == null) {
          instance = new WSPublicAccReport();
        }
      }
      finally {}
    }
    return instance;
  }
  
  private void handleAddActionScene(HashMap<String, String> paramHashMap)
  {
    String str2 = WSExpABTestManager.a().h();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "-1";
    }
    paramHashMap.put("action_scene", str1);
  }
  
  private void handleIntentBundle(Bundle paramBundle, HashMap<String, String> paramHashMap)
  {
    if (paramBundle == null) {
      return;
    }
    if (!TextUtils.isEmpty(paramBundle.getString("spid"))) {
      paramHashMap.put("spid", paramBundle.getString("spid"));
    }
    if (!TextUtils.isEmpty(paramBundle.getString("share_feed_id"))) {
      paramHashMap.put("share_feedid", paramBundle.getString("share_feed_id"));
    }
    if (!TextUtils.isEmpty(paramBundle.getString("share_collection_id"))) {
      paramHashMap.put("share_collection_id", paramBundle.getString("share_collection_id"));
    }
    if (!TextUtils.isEmpty(paramBundle.getString("share_active_id"))) {
      paramHashMap.put("share_active_id", paramBundle.getString("share_active_id"));
    }
    if (!TextUtils.isEmpty(paramBundle.getString("web_url"))) {
      paramHashMap.put("web_url", paramBundle.getString("web_url"));
    }
    String str = paramBundle.getString("scenes_channel_from");
    if (!TextUtils.isEmpty(str))
    {
      setScenesChannelFrom(str);
      paramHashMap.put("share_scenes_from", str);
    }
    if (!TextUtils.isEmpty(paramBundle.getString("web_test_id"))) {
      paramHashMap.put("web_test_id", paramBundle.getString("web_test_id"));
    }
  }
  
  private void publicAccActionReport(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, long paramLong, int paramInt3, Map<String, String> paramMap)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("event_type", paramString1);
    localHashMap.put("push_count", String.valueOf(paramInt1));
    localHashMap.put("row_key", WeishiUtils.j());
    localHashMap.put("push_extra", paramString2);
    localHashMap.put("app_extra", "");
    localHashMap.put("push_entry", paramString3);
    localHashMap.put("click_to", String.valueOf(paramInt2));
    localHashMap.put("app_live_time", String.valueOf(paramLong));
    localHashMap.put("operation_or_not", String.valueOf(paramInt3));
    baseActionReport("gzh_action", "", localHashMap, paramMap, "", 1);
  }
  
  private void reportPageVisited(String paramString, int paramInt, long paramLong, Map<String, String> paramMap)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("event_type", String.valueOf(paramInt));
    localHashMap.put("page_live_time", String.valueOf(paramLong));
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    baseActionReport("gzh_pageview", paramString, localHashMap, (Map)localObject, "", 1);
  }
  
  private void reset()
  {
    this.mIsReportedEnter = false;
    this.mRecommendFullScreenInfo = null;
    this.mPushId = "";
    this.pageVisitTimeMap.clear();
    WeishiUtils.m("");
    WSReportEventConstants.c = false;
    WSRedDotPreloadManager.a().c();
  }
  
  private void resetLocalTestId()
  {
    this.mLocalTestId = LocalMultiProcConfig.getString4Uin("key_default_test_id", "", WeishiUtils.b());
  }
  
  private void setSessionId(String paramString)
  {
    this.mSessionId = paramString;
    WSSharePreferencesUtil.a("key_session_id", paramString);
  }
  
  private void setSessionStamp(String paramString)
  {
    this.mSessionStamp = paramString;
    WSSharePreferencesUtil.a("key_session_stamp", paramString);
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
    localHashMap.put("row_key", WeishiUtils.j());
    localHashMap.put("push_extra", paramString2);
    localHashMap.put("app_extra", "");
    localHashMap.put("push_entry", paramString3);
    localHashMap.put("click_to", String.valueOf(paramInt2));
    localHashMap.put("app_live_time", String.valueOf(paramLong));
    localHashMap.put("operation_or_not", String.valueOf(paramInt3));
    new WSStatisticsReporter.Builder().addParams(localHashMap).setSopName("").setTestId(WeishiUtils.a(6)).setPushId(this.mPushId).setOperationId("").setFlush(true).build("gzh_action").report();
  }
  
  public void backgroundPublicAccReport()
  {
    this.toBackgroundTime = System.currentTimeMillis();
    long l2 = this.toForegroundTime;
    long l1 = 0L;
    if (l2 == 0L) {
      this.toForegroundTime = this.publicAccEnterTime;
    }
    if (this.toForegroundTime > 0L) {
      l1 = System.currentTimeMillis() - this.toForegroundTime;
    }
    publicAccActionReport("3", 0, "", "", 0, l1, 0, null);
  }
  
  public void closePublicAccReport(int paramInt)
  {
    long l2 = this.toForegroundTime;
    long l1 = 0L;
    if (l2 > 0L)
    {
      if (this.toBackgroundTime >= l2) {
        break label62;
      }
      l1 = System.currentTimeMillis();
      l2 = this.toForegroundTime;
    }
    else
    {
      if (this.publicAccEnterTime <= 0L) {
        break label62;
      }
      l1 = System.currentTimeMillis();
      l2 = this.publicAccEnterTime;
    }
    l1 -= l2;
    label62:
    publicAccActionReport("2", 0, "", "", 0, l1, paramInt, null);
    reset();
  }
  
  public void enterPublicAccReport(WSRedDotPushMsg paramWSRedDotPushMsg, int paramInt, String paramString, Bundle paramBundle)
  {
    if (this.mIsReportedEnter) {
      return;
    }
    resetLocalTestId();
    this.publicAccEnterTime = System.currentTimeMillis();
    long l = this.publicAccEnterTime;
    this.toForegroundTime = l;
    this.mIsReportedEnter = true;
    setSessionId(String.valueOf(l));
    setSessionStamp(String.valueOf(this.publicAccEnterTime));
    setEnterPublicAccFrom(paramString);
    HashMap localHashMap = new HashMap();
    paramString = "";
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
          if (paramString.a) {
            paramWSRedDotPushMsg = String.valueOf(1);
          } else {
            paramWSRedDotPushMsg = String.valueOf(0);
          }
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
    Object localObject = WeishiUtils.d();
    if (WeishiUtils.a((WeishiManager)localObject)) {
      paramWSRedDotPushMsg = "1";
    } else {
      paramWSRedDotPushMsg = "2";
    }
    if (TextUtils.equals(paramWSRedDotPushMsg, "2"))
    {
      if (localObject != null) {
        localObject = WeishiUtils.q();
      } else {
        localObject = "0";
      }
      localHashMap.put("is_yunying_content", localObject);
    }
    localHashMap.put("aio_index", Integer.toString(WSAioListHelper.d() + 1));
    if (paramInt == 3) {
      paramInt = 1;
    }
    handleIntentBundle(paramBundle, localHashMap);
    handleAddActionScene(localHashMap);
    publicAccActionReport("1", WeishiUtils.m(), paramString, paramWSRedDotPushMsg, paramInt, 0L, 0, localHashMap);
  }
  
  public void enterTrendsTabReport(WSRedDotPushMsg paramWSRedDotPushMsg, boolean paramBoolean)
  {
    this.trendsWSEnterTime = System.currentTimeMillis();
    long l = this.trendsWSEnterTime;
    this.toTrendsWSForegroundTime = l;
    setSessionId(String.valueOf(l));
    setSessionStamp(String.valueOf(this.trendsWSEnterTime));
    this.mPushId = "";
    String str;
    int i;
    if ((paramWSRedDotPushMsg != null) && (paramWSRedDotPushMsg.mStrategyInfo != null))
    {
      this.mPushId = paramWSRedDotPushMsg.mPushId;
      str = paramWSRedDotPushMsg.mMsgData;
      i = paramWSRedDotPushMsg.mStrategyInfo.getType();
      paramWSRedDotPushMsg = str;
    }
    else
    {
      paramWSRedDotPushMsg = "";
      i = 2;
    }
    if (paramBoolean) {
      str = "1";
    } else {
      str = "2";
    }
    trendsTabActionReport("1", 0, paramWSRedDotPushMsg, str, i, 0L, 0);
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
  
  public void foregroundPublicAccReport()
  {
    this.toForegroundTime = System.currentTimeMillis();
    setSessionStamp(String.valueOf(this.toForegroundTime));
    publicAccActionReport("4", 0, "", "", 0, 0L, 0, null);
  }
  
  public String getEnterPublicAccFrom()
  {
    if (TextUtils.isEmpty(this.mEnterPublicAccFrom)) {
      this.mEnterPublicAccFrom = WSSharePreferencesUtil.b("key_enter_public_from", "");
    }
    return this.mEnterPublicAccFrom;
  }
  
  public Map<String, String> getFeedsBaseParams(String paramString, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    String str1 = "";
    String str2;
    String str3;
    if (paramstSimpleMetaFeed != null)
    {
      if (paramstSimpleMetaFeed.map_ext != null) {
        str1 = new Gson().toJson(paramstSimpleMetaFeed.map_ext);
      }
      str2 = paramstSimpleMetaFeed.traceId;
      str3 = str1;
    }
    else
    {
      str1 = "";
      str3 = str1;
      str2 = str1;
    }
    return getFeedsBaseParams(paramString, paramInt, paramstSimpleMetaFeed, str2, str3);
  }
  
  public Map<String, String> getFeedsBaseParams(String paramString1, int paramInt, stSimpleMetaFeed paramstSimpleMetaFeed, String paramString2, String paramString3)
  {
    HashMap localHashMap = new HashMap();
    if (paramInt != 0) {
      localHashMap.put("action_id", String.valueOf(paramInt));
    }
    String str2 = "";
    String str1;
    if (paramstSimpleMetaFeed != null)
    {
      str1 = paramstSimpleMetaFeed.id;
      str2 = paramstSimpleMetaFeed.poster_id;
      paramstSimpleMetaFeed = str1;
      str1 = str2;
    }
    else
    {
      str1 = "";
      paramstSimpleMetaFeed = str2;
    }
    if (!TextUtils.isEmpty(paramString2)) {
      localHashMap.put("global_key", WSRecommendReportManager.a().a(paramString2));
    }
    if (!TextUtils.isEmpty(paramString3)) {
      localHashMap.put("feed_pass_key", paramString3);
    }
    localHashMap.put("position", paramString1);
    localHashMap.put("feed_id", paramstSimpleMetaFeed);
    localHashMap.put("owner_id", str1);
    return localHashMap;
  }
  
  public Map<String, String> getFeedsBaseParamsWithoutFeed(String paramString, int paramInt)
  {
    return getFeedsBaseParams(paramString, paramInt, null);
  }
  
  public String getLocalTestId()
  {
    return this.mLocalTestId;
  }
  
  public String getPushId()
  {
    return this.mPushId;
  }
  
  public WSPublicAccReport.RecommendFullScreenInfo getRecommendFullScreenInfo()
  {
    if (this.mRecommendFullScreenInfo == null) {
      this.mRecommendFullScreenInfo = new WSPublicAccReport.RecommendFullScreenInfo(this);
    }
    return this.mRecommendFullScreenInfo;
  }
  
  public String getScenesChannelFrom()
  {
    if (TextUtils.isEmpty(this.mScenesChannelFrom)) {
      this.mScenesChannelFrom = WSSharePreferencesUtil.b("key_scenes_channel_from", "");
    }
    return this.mScenesChannelFrom;
  }
  
  public String getSessionId()
  {
    if (TextUtils.isEmpty(this.mSessionId)) {
      return WSSharePreferencesUtil.b("key_session_id", "");
    }
    return this.mSessionId;
  }
  
  public String getSessionStamp()
  {
    if (TextUtils.isEmpty(this.mSessionStamp)) {
      return WSSharePreferencesUtil.b("key_session_stamp", "");
    }
    return this.mSessionStamp;
  }
  
  public void reportAttentionClick(int paramInt, String paramString, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("red_dot_quantity", String.valueOf(paramInt));
    String str;
    if (paramBoolean) {
      str = "0";
    } else {
      str = "1";
    }
    localHashMap.put("is_click", str);
    baseActionReport("gzh_click", paramString, getFeedsBaseParamsWithoutFeed("follow_tab", 1000001), localHashMap, "", 10001);
  }
  
  public void reportAttentionRedDotExposure(int paramInt, String paramString)
  {
    if (paramInt <= 0) {
      return;
    }
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
  
  public void reportClickRichBlockPop(int paramInt1, int paramInt2, String paramString1, String paramString2, int paramInt3)
  {
    Map localMap = getFeedsBaseParamsWithoutFeed("popup", paramInt1);
    localMap.put("global_key", WSRecommendReportManager.a().a(paramString1));
    baseActionReport("gzh_click", paramString2, localMap, null, String.valueOf(paramInt2), paramInt3);
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt1);
    localStringBuilder.append(" - ");
    localStringBuilder.append(paramInt2);
    localStringBuilder.append(" - ");
    localStringBuilder.append(paramInt3);
    localStringBuilder.append(" - ");
    localStringBuilder.append(paramInt4);
    localStringBuilder.append(" - ");
    localStringBuilder.append(paramInt5);
    WSLog.c("beacon-download", localStringBuilder.toString());
    baseActionReport("gzh_download", "", localHashMap, null, "", paramInt6);
  }
  
  public void reportExposeRichBlockPop(int paramInt1, String paramString1, String paramString2, int paramInt2)
  {
    Map localMap = getFeedsBaseParamsWithoutFeed("popup", 0);
    localMap.put("global_key", WSRecommendReportManager.a().a(paramString1));
    baseActionReport("gzh_exposure", paramString2, localMap, null, String.valueOf(paramInt1), paramInt2);
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
    localMap.put("global_key", WSRecommendReportManager.a().a(paramString2));
    paramString2 = new HashMap();
    paramString2.put("type", String.valueOf(paramInt1));
    baseActionReport(paramString1, "feeds", localMap, paramString2, String.valueOf(paramInt3), 4);
  }
  
  public void reportNotificationClick(int paramInt, boolean paramBoolean)
  {
    baseActionReport("gzh_click", switchTabSopName(paramInt, paramBoolean), getFeedsBaseParamsWithoutFeed("message_notification", 1000001), null, "", 10001);
  }
  
  public void reportPageVisitEnter(String paramString)
  {
    reportPageVisitEnter(paramString, null);
  }
  
  public void reportPageVisitEnter(String paramString, Map<String, String> paramMap)
  {
    this.pageVisitTimeMap.put(paramString, Long.valueOf(System.currentTimeMillis()));
    reportPageVisited(paramString, 1, 0L, paramMap);
  }
  
  public void reportPageVisitExit(String paramString)
  {
    reportPageVisitExit(paramString, null);
  }
  
  public void reportPageVisitExit(String paramString, Map<String, String> paramMap)
  {
    long l2 = 0L;
    Long localLong = Long.valueOf(0L);
    Map localMap = this.pageVisitTimeMap;
    if (localMap != null) {
      localLong = (Long)localMap.get(paramString);
    }
    long l1 = l2;
    if (localLong != null)
    {
      l1 = l2;
      if (localLong.longValue() > 0L) {
        l1 = System.currentTimeMillis() - localLong.longValue();
      }
    }
    reportPageVisited(paramString, 2, l1, paramMap);
  }
  
  public void reportPersonHomeClick(int paramInt, boolean paramBoolean)
  {
    baseActionReport("gzh_click", switchTabSopName(paramInt, paramBoolean), getFeedsBaseParamsWithoutFeed("my_homepage", 1000001), null, "", 10001);
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
    String str;
    if (paramBoolean) {
      str = "0";
    } else {
      str = "1";
    }
    localHashMap.put("is_click", str);
    baseActionReport("gzh_click", "focus", getFeedsBaseParamsWithoutFeed("recommend_tab", 1000001), localHashMap, "", 10001);
  }
  
  public void reportShareClick(String paramString1, int paramInt, String paramString2, String paramString3, stSimpleMetaFeed paramstSimpleMetaFeed, Map<String, String> paramMap)
  {
    Object localObject = paramMap;
    if (paramMap == null) {
      localObject = new HashMap();
    }
    ((Map)localObject).put("material_type", getFeedOpVideoType(paramstSimpleMetaFeed));
    if (!TextUtils.isEmpty(paramString3)) {
      ((Map)localObject).put("play_scene", paramString3);
    }
    if (WSReportUtils.d(paramString2)) {
      paramString3 = WSVerticalBeaconReport.a();
    } else {
      paramString3 = "";
    }
    ((Map)localObject).put("tab_id", paramString3);
    baseActionReport("gzh_click", paramString2, getFeedsBaseParams(paramString1, paramInt, paramstSimpleMetaFeed), (Map)localObject, "", 1);
  }
  
  public void reportTabLiveBtnClick(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("btn_status", "1");
    localHashMap.put("source", "31");
    baseActionReport("gzh_click", switchTabSopName(paramInt1, paramBoolean), getFeedsBaseParamsWithoutFeed("live_jump", paramInt2), localHashMap, "", 10010);
  }
  
  public void reportTabLiveBtnExposure(int paramInt, boolean paramBoolean)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("btn_status", "1");
    baseActionReport("gzh_exposure", switchTabSopName(paramInt, paramBoolean), getFeedsBaseParamsWithoutFeed("live_jump", 0), localHashMap, "", 10010);
  }
  
  public void reportVideoPlayUpdateExp(int paramInt)
  {
    new WSStatisticsReporter.Builder().addParams(getFeedsBaseParamsWithoutFeed("videoplay_update", 0)).setSopName("fullscreen_videoplay").setTestId(WeishiUtils.a(1)).setPushId(this.mPushId).setFlush(true).build("gzh_exposure").report();
  }
  
  public void setEnterPublicAccFrom(String paramString)
  {
    this.mEnterPublicAccFrom = paramString;
    WSSharePreferencesUtil.a("key_enter_public_from", this.mEnterPublicAccFrom);
  }
  
  public void setScenesChannelFrom(String paramString)
  {
    this.mScenesChannelFrom = paramString;
    WSSharePreferencesUtil.a("key_scenes_channel_from", this.mScenesChannelFrom);
  }
  
  public void trendsCloseReport(int paramInt)
  {
    long l2 = this.toTrendsWSForegroundTime;
    long l1 = 0L;
    if (l2 > 0L)
    {
      if (this.toTrendsWSBackgroundTime >= l2) {
        break label62;
      }
      l1 = System.currentTimeMillis();
      l2 = this.toTrendsWSForegroundTime;
    }
    else
    {
      if (this.trendsWSEnterTime <= 0L) {
        break label62;
      }
      l1 = System.currentTimeMillis();
      l2 = this.trendsWSEnterTime;
    }
    l1 -= l2;
    label62:
    publicAccActionReport("2", 0, "", "", 0, l1, paramInt, null);
    reset();
  }
  
  public void trendsWSBackgroundReport()
  {
    this.toTrendsWSBackgroundTime = System.currentTimeMillis();
    long l2 = this.toTrendsWSForegroundTime;
    long l1 = 0L;
    if (l2 == 0L) {
      this.toTrendsWSForegroundTime = this.trendsWSEnterTime;
    }
    if (this.toTrendsWSForegroundTime > 0L) {
      l1 = System.currentTimeMillis() - this.toTrendsWSForegroundTime;
    }
    publicAccActionReport("3", 0, "", "", 0, l1, 0, null);
  }
  
  public void trendsWSForegroundReport()
  {
    this.toTrendsWSForegroundTime = System.currentTimeMillis();
    setSessionStamp(String.valueOf(this.toTrendsWSForegroundTime));
    publicAccActionReport("4", 0, "", "", 0, 0L, 0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport
 * JD-Core Version:    0.7.0.1
 */
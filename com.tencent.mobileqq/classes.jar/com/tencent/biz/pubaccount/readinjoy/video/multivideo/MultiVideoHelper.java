package com.tencent.biz.pubaccount.readinjoy.video.multivideo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoPlayRecommendHandler;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.common.RIJXTabFrameUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.MultiVideoConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.VDynamicConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.ViolaVideoFeedsConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJStudyModeUtils;
import com.tencent.biz.pubaccount.readinjoy.model.RIJUserLevelModule;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.VideoColumnInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.video.VideoResumeManager;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageManager;
import com.tencent.biz.pubaccount.readinjoy.view.imageloader.ImageRequest;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaAccessHelper;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class MultiVideoHelper
{
  public static final String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = MultiVideoHelper.class.getSimpleName();
  }
  
  public static Bundle a()
  {
    Bundle localBundle = new Bundle();
    JSONObject localJSONObject1 = new JSONObject();
    JSONObject localJSONObject2 = new JSONObject();
    try
    {
      a(localJSONObject2);
      localJSONObject2.put("cardStyleConfig", a(297));
      localJSONObject2.put("interactAreaConfig", a(154));
      localJSONObject1.put("aladingConfig", localJSONObject2);
      localBundle.putString("param", localJSONObject1.toString());
      return localBundle;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "generateParamsForSeriesViola error: " + localJSONException.getMessage());
      }
    }
  }
  
  public static Bundle a(Intent paramIntent)
  {
    Bundle localBundle = new Bundle();
    JSONObject localJSONObject1 = new JSONObject();
    try
    {
      JSONObject localJSONObject2 = a(paramIntent);
      JSONObject localJSONObject3 = new JSONObject();
      localJSONObject3.put("stickySpeed", MultiVideoConfigHandler.a());
      localJSONObject3.put("maskLighteness", MultiVideoConfigHandler.a());
      localJSONObject3.put("topBarTitle", MultiVideoConfigHandler.a());
      localJSONObject3.put("autoPlayForLockScreen", Aladdin.getConfig(271).getIntegerFromString("auto_play", 1));
      JSONObject localJSONObject4 = a(372);
      localJSONObject4.put("rewardPrivilegeConfig", RIJUserLevelModule.a().a(5));
      localJSONObject3.put("videoRewardConfig", localJSONObject4);
      localJSONObject3.put("barrageConfig", ReadInJoyHelper.c());
      localJSONObject3.put("resumeEnable", VideoResumeManager.a.a());
      localJSONObject3.put("interactAreaConfig", a(154));
      a(localJSONObject3);
      localJSONObject4 = new JSONObject();
      localJSONObject4.put("from", paramIntent.getIntExtra("VIDEO_FROM_TYPE", -1));
      localJSONObject4.put("kandian_mode_new", VideoReporter.a());
      localJSONObject4.put("kandian_mode", RIJAppSetting.a());
      localJSONObject4.put("source", paramIntent.getIntExtra("key_source", -1));
      localJSONObject4.put("senceType", paramIntent.getIntExtra("RETURN_SCENE", 0));
      paramIntent = a();
      localJSONObject1.put("configModel", localJSONObject2);
      localJSONObject1.put("aladingConfig", localJSONObject3);
      localJSONObject1.put("reportConfig", localJSONObject4);
      localJSONObject1.put("dynamicAladdinConfig", VDynamicConfigHandler.b());
      localJSONObject1.put("xgAladdinConfig", VDynamicConfigHandler.a());
      localJSONObject1.put("protocolExtralParam", paramIntent);
      localJSONObject1.put("autoPlayDisable", ReadInJoyHelper.i());
      localJSONObject1.put("userHeadUrl", a());
      localBundle.putString("param", localJSONObject1.toString());
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "generateParamsForViola: " + localJSONObject1.toString());
      }
      return localBundle;
    }
    catch (JSONException paramIntent)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "generateParamsForViola: json error ", paramIntent);
        }
      }
    }
  }
  
  public static Fragment a(Context paramContext, Bundle paramBundle, TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    Object localObject1 = paramBundle;
    if (paramBundle == null) {
      localObject1 = new Bundle();
    }
    if (!((Bundle)localObject1).containsKey("VIDEO_FROM_TYPE")) {
      ((Bundle)localObject1).putInt("VIDEO_FROM_TYPE", 129);
    }
    ((Bundle)localObject1).putInt("is_channel", 1);
    paramBundle = new Intent();
    paramBundle.putExtras((Bundle)localObject1);
    localObject1 = ViolaAccessHelper.a(paramTabChannelCoverInfo.mChannelCoverId) + "&" + "channelId" + "=" + paramTabChannelCoverInfo.mChannelCoverId;
    if (paramTabChannelCoverInfo.mChannelCoverId == 41725)
    {
      paramBundle = a();
      paramBundle.putBoolean("disable_color_note", true);
      paramBundle.putBoolean("disable_fps_ball", true);
      paramBundle.putBoolean("should_finish_activity", false);
      paramBundle.putBoolean("is_channel", true);
      paramBundle.putInt("channel_id", paramTabChannelCoverInfo.mChannelCoverId);
      Object localObject2 = RIJXTabFrameUtils.a();
      if ((localObject2 == null) || (((List)localObject2).size() <= 0)) {
        break label265;
      }
      localObject2 = ((List)localObject2).iterator();
      TabChannelCoverInfo localTabChannelCoverInfo;
      do
      {
        if (!((Iterator)localObject2).hasNext()) {
          break;
        }
        localTabChannelCoverInfo = (TabChannelCoverInfo)((Iterator)localObject2).next();
      } while ((localTabChannelCoverInfo == null) || (localTabChannelCoverInfo.mChannelCoverId != paramTabChannelCoverInfo.mChannelCoverId));
    }
    label265:
    for (paramTabChannelCoverInfo = (String)localObject1 + "&" + "is_last_index" + "=1";; paramTabChannelCoverInfo = (TabChannelCoverInfo)localObject1)
    {
      return ViolaAccessHelper.a(paramContext, paramTabChannelCoverInfo, paramBundle);
      paramBundle = a(paramBundle);
      break;
    }
  }
  
  public static Fragment a(Context paramContext, TabChannelCoverInfo paramTabChannelCoverInfo)
  {
    return a(paramContext, null, paramTabChannelCoverInfo);
  }
  
  public static VideoInfo a(Bundle paramBundle)
  {
    VideoInfo localVideoInfo;
    if (paramBundle.getParcelable("VIDEO_OBJ") != null)
    {
      localVideoInfo = (VideoInfo)paramBundle.getParcelable("VIDEO_OBJ");
      VideoFeedsHelper.a(localVideoInfo);
      if (QLog.isColorLevel()) {
        QLog.d(jdField_a_of_type_JavaLangString, 2, "generateRequestVideoInfo: 外部传进来的VideoInfo=" + localVideoInfo.b());
      }
      paramBundle.putString("VIDEO_ARTICLE_ID", localVideoInfo.g);
      paramBundle = localVideoInfo;
    }
    do
    {
      return paramBundle;
      localVideoInfo = VideoFeedsHelper.a(paramBundle);
      VideoFeedsHelper.a(localVideoInfo);
      paramBundle = localVideoInfo;
    } while (!QLog.isColorLevel());
    QLog.d(jdField_a_of_type_JavaLangString, 2, "innerGenerateRequestVideoInfo: 外部传进来的VideoInfo=" + localVideoInfo.b());
    return localVideoInfo;
  }
  
  private static String a()
  {
    try
    {
      String str = ReadInJoyUserInfoModule.a(ReadInJoyUserInfoModule.a(ReadInJoyUtils.a(), null));
      return str;
    }
    catch (Throwable localThrowable)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[getUserHeadUrl]: " + localThrowable.getMessage());
    }
    return null;
  }
  
  private static String a(Intent paramIntent)
  {
    String str2 = b(paramIntent);
    String str1 = str2;
    if (paramIntent.getExtras() != null)
    {
      str1 = str2;
      if (paramIntent.getExtras().containsKey("VIDEO_ARTICLE_ID")) {
        str1 = str2 + "&rowkey=" + paramIntent.getExtras().getString("VIDEO_ARTICLE_ID");
      }
    }
    return str1;
  }
  
  private static String a(Intent paramIntent, VideoInfo paramVideoInfo)
  {
    Object localObject = null;
    paramVideoInfo = paramVideoInfo.a();
    if (paramIntent == null)
    {
      paramIntent = localObject;
      if (paramVideoInfo != null) {
        paramIntent = paramVideoInfo.toString();
      }
    }
    do
    {
      return paramIntent;
      String str = a(paramIntent.getStringExtra("VIDEO_COVER"));
      int i = paramIntent.getIntExtra("item_image_width", 0);
      int j = paramIntent.getIntExtra("item_image_height", 0);
      if ((!TextUtils.isEmpty(str)) && (i != 0) && (j != 0)) {
        return a(str, i, j);
      }
      paramIntent = localObject;
    } while (paramVideoInfo == null);
    return paramVideoInfo.toString();
  }
  
  public static String a(String paramString)
  {
    String str;
    if (paramString == null) {
      str = null;
    }
    for (;;)
    {
      return str;
      str = paramString;
      try
      {
        if (paramString.startsWith("pubaccountimage:"))
        {
          str = paramString.substring(paramString.indexOf(":") + 1);
          return str;
        }
      }
      catch (Exception localException)
      {
        QLog.e(jdField_a_of_type_JavaLangString, 1, "[tryCutPubAccountImageProtocol]: " + localException.getMessage());
      }
    }
    return paramString;
  }
  
  public static String a(String paramString, int paramInt1, int paramInt2)
  {
    String str = "?";
    if (!paramString.contains("?")) {}
    for (;;)
    {
      return paramString + str + "item_image_width" + "=" + paramInt1 + "&" + "item_image_height" + "=" + paramInt2;
      str = "&";
    }
  }
  
  private static JSONObject a()
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("uint32_youngster_status", ReadInJoyHelper.a("key_sp_is_readinjoy_youngster", Integer.valueOf(0)));
    localJSONObject.put("uint32_req_recommend_flag", VideoPlayRecommendHandler.a());
    localJSONObject.put("bytes_req_recommend_json", RIJStudyModeUtils.a());
    return localJSONObject;
  }
  
  private static JSONObject a(int paramInt)
  {
    Object localObject = Aladdin.getConfig(paramInt).getAll();
    JSONObject localJSONObject = new JSONObject();
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      try
      {
        localJSONObject.put((String)localEntry.getKey(), localEntry.getValue());
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
      }
    }
    return localJSONObject;
  }
  
  private static JSONObject a(Intent paramIntent)
  {
    VideoInfo localVideoInfo = a(paramIntent.getExtras());
    boolean bool = paramIntent.getBooleanExtra("VIDEO_SHOW_COMMENT", false);
    int k = paramIntent.getIntExtra("VIDEO_FROM_TYPE", -1);
    Object localObject1;
    label123:
    JSONObject localJSONObject1;
    int j;
    if (k == 11)
    {
      i = 1;
      int m = paramIntent.getIntExtra("REPORT_VIDEO_FEEDS_CHANNEL_ID", -1);
      int n = paramIntent.getIntExtra("VIDEO_FEEDS_TYPE_FOR_REPORT", 0);
      int i1 = paramIntent.getIntExtra("REPORT_VIDEO_FEEDS_JUMP_FROM", -1);
      Object localObject2 = paramIntent.getStringExtra("ARGS_SESSION_ID");
      String str = paramIntent.getStringExtra("ARGS_VIDEO_CHANNEL_SESSION_ID");
      long l = paramIntent.getLongExtra("VIDEO_PLAY_POSITION", 0L);
      localObject1 = paramIntent.getStringExtra("VIDEO_H5_URL");
      if (TextUtils.isEmpty((CharSequence)localObject1)) {
        break label396;
      }
      localObject1 = Uri.parse((String)localObject1).getQueryParameter("redpackid");
      localJSONObject1 = new JSONObject();
      if (!bool) {
        break label404;
      }
      j = 1;
      label139:
      JSONObject localJSONObject2 = localJSONObject1.put("autoShowComment", j);
      if (i == 0) {
        break label409;
      }
      i = 1;
      label156:
      localObject2 = localJSONObject2.put("circleEntrance", i).put("entranceChannel", m).put("feedsType", n).put("reportSource", i1).put("sessionID", localObject2).put("sourceType", k).put("videoFromType", k).put("videoSessionID", str);
      if (k < 100) {
        break label414;
      }
      i = k;
      label229:
      localObject1 = ((JSONObject)localObject2).put("webVideoFromType", i).put("startPlayTime", l / 1000L).put("redPackedId", localObject1);
      if (paramIntent.getIntExtra("is_channel", 0) != 0) {
        break label419;
      }
      i = 1;
      label272:
      ((JSONObject)localObject1).put("isVideoAccountPage", i);
      if (localVideoInfo != null)
      {
        localJSONObject1.put("videoType", MultiVideoConfigHandler.a(localVideoInfo.jdField_b_of_type_Int, localVideoInfo.jdField_c_of_type_Int, localVideoInfo.jdField_d_of_type_Int));
        if ((TextUtils.isEmpty(localVideoInfo.jdField_a_of_type_JavaLangString)) || (localVideoInfo.c() == 0) || (localVideoInfo.b() == 0)) {
          break label424;
        }
      }
    }
    label396:
    label404:
    label409:
    label414:
    label419:
    label424:
    for (int i = 1;; i = 0)
    {
      if (!TextUtils.isEmpty(localVideoInfo.jdField_r_of_type_JavaLangString)) {
        i = 1;
      }
      if (i != 0) {
        localJSONObject1.put("videoArticleModel", a(localVideoInfo, paramIntent));
      }
      paramIntent.putExtra("video_rowkey", localVideoInfo.g);
      return localJSONObject1;
      i = 0;
      break;
      localObject1 = "";
      break label123;
      j = 0;
      break label139;
      i = 0;
      break label156;
      i = 0;
      break label229;
      i = 0;
      break label272;
    }
  }
  
  public static JSONObject a(VideoInfo paramVideoInfo, Intent paramIntent)
  {
    int j = 0;
    JSONObject localJSONObject1 = new JSONObject();
    Object localObject = localJSONObject1.put("article_title", paramVideoInfo.jdField_c_of_type_JavaLangString).put("busiType", paramVideoInfo.jdField_a_of_type_Int).put("first_page_url", a(paramIntent, paramVideoInfo)).put("innerUniqueID", paramVideoInfo.g);
    int i;
    if (paramVideoInfo.jdField_b_of_type_Boolean)
    {
      i = 1;
      localObject = ((JSONObject)localObject).put("is_ugc", i).put("like_count", paramVideoInfo.v);
      if (!paramVideoInfo.jdField_r_of_type_Boolean) {
        break label490;
      }
      i = 1;
      label95:
      JSONObject localJSONObject2 = ((JSONObject)localObject).put("myself_like_status", i);
      if (paramIntent == null) {
        break label495;
      }
      localObject = paramIntent.getStringExtra("VIDEO_ACCOUNT_AVATAR_URL");
      label119:
      localJSONObject2 = localJSONObject2.put("thirdIcon", localObject).put("thirdName", paramVideoInfo.q).put("third_uin", paramVideoInfo.j).put("third_uin_name", paramVideoInfo.k);
      if (paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo == null) {
        break label503;
      }
      localObject = Integer.valueOf(paramVideoInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructVideoColumnInfo.jdField_a_of_type_Int);
      label180:
      localJSONObject2 = localJSONObject2.put("topic_id", localObject).put("videoInfo_duration", paramVideoInfo.a()).put("videoInfo_fileSize", paramVideoInfo.jdField_b_of_type_Long).put("videoInfo_height", paramVideoInfo.c()).put("videoInfo_vid", paramVideoInfo.jdField_a_of_type_JavaLangString).put("videoInfo_width", paramVideoInfo.b()).put("video_comment_count", paramVideoInfo.e).put("video_json", paramVideoInfo.l).put("video_logo_url", paramVideoInfo.u).put("video_play_count", paramVideoInfo.t).put("algorithm_id", paramVideoInfo.jdField_f_of_type_Long).put("strategy_id", paramVideoInfo.s).put("video_report_info", paramVideoInfo.w).put("video_url", paramVideoInfo.jdField_r_of_type_JavaLangString);
      if (paramVideoInfo.jdField_d_of_type_Long == 0L) {
        break label509;
      }
      localObject = String.valueOf(paramVideoInfo.jdField_d_of_type_Long);
      label340:
      localObject = localJSONObject2.put("feedsID", localObject).put("feedsType", paramVideoInfo.h);
      if (paramIntent == null) {
        break label517;
      }
    }
    label517:
    for (paramIntent = paramIntent.getStringExtra("VIDEO_COMMON_DATA");; paramIntent = "")
    {
      ((JSONObject)localObject).put("commonData", paramIntent).put("biu_count", paramVideoInfo.jdField_f_of_type_Int).put("biu_count_str", VideoFeedsHelper.a(paramVideoInfo.jdField_f_of_type_Int, "Biu")).put("like_count_str", VideoFeedsHelper.a(paramVideoInfo.v, "赞")).put("video_comment_count_str", VideoFeedsHelper.a(paramVideoInfo.e, "评论"));
      if (!TextUtils.isEmpty(paramVideoInfo.j)) {
        i = j;
      }
      try
      {
        if (VideoFeedsHelper.a(RIJQQAppInterfaceUtil.a(), Long.parseLong(paramVideoInfo.j))) {
          i = 1;
        }
        localJSONObject1.put("isAttentionThirdUin", i);
        return localJSONObject1;
      }
      catch (Exception paramVideoInfo)
      {
        label490:
        QLog.e(jdField_a_of_type_JavaLangString, 1, paramVideoInfo.getMessage());
      }
      i = 0;
      break;
      i = 0;
      break label95;
      label495:
      localObject = "";
      break label119;
      label503:
      localObject = null;
      break label180;
      label509:
      localObject = "";
      break label340;
    }
    return localJSONObject1;
  }
  
  public static JSONObject a(JSONObject paramJSONObject)
  {
    try
    {
      Object localObject = Aladdin.getConfig(434).getAll();
      if (localObject != null)
      {
        JSONObject localJSONObject = new JSONObject();
        localObject = ((Map)localObject).entrySet().iterator();
        while (((Iterator)localObject).hasNext())
        {
          Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
          localJSONObject.put((String)localEntry.getKey(), localEntry.getValue().toString());
        }
      }
      return paramJSONObject;
    }
    catch (Exception localException)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "addVideoFeedsConfigToJson error: " + localException.getMessage());
    }
    paramJSONObject.put("videoAccountFeedsConfig", localException);
    return paramJSONObject;
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, int paramInt)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    paramIntent = a(localIntent);
    paramIntent.putInt("requestCode", paramInt);
    ViolaAccessHelper.a(paramActivity, null, a(localIntent), paramIntent, true);
  }
  
  public static void a(Context paramContext, Intent paramIntent)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    Bundle localBundle = a(localIntent);
    String str = b(localIntent);
    paramIntent = str;
    if (localIntent.getExtras() != null)
    {
      paramIntent = str;
      if (localIntent.getExtras().containsKey("VIDEO_ARTICLE_ID")) {
        paramIntent = str + "&rowkey=" + localIntent.getExtras().getString("VIDEO_ARTICLE_ID");
      }
    }
    ViolaAccessHelper.a(paramContext, null, paramIntent, localBundle, true);
  }
  
  public static void a(Context paramContext, Intent paramIntent, String paramString)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    Bundle localBundle = a(localIntent);
    paramIntent = paramString;
    if (localIntent.getExtras() != null)
    {
      paramIntent = paramString;
      if (localIntent.getExtras().containsKey("VIDEO_ARTICLE_ID")) {
        paramIntent = paramString + "&rowkey=" + localIntent.getExtras().getString("VIDEO_ARTICLE_ID");
      }
    }
    ViolaAccessHelper.a(paramContext, null, paramIntent, localBundle, true);
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, Context paramContext)
  {
    if ((a(paramBaseArticleInfo)) && ((paramContext instanceof Activity))) {}
    try
    {
      paramContext = VideoFeedsHelper.a((Activity)paramContext, paramBaseArticleInfo.mVideoJsonWidth, paramBaseArticleInfo.mVideoJsonHeight);
      paramBaseArticleInfo.setFirstFrameWidth(((Integer)paramContext.first).intValue());
      paramBaseArticleInfo.setFirstFrameHeight(((Integer)paramContext.second).intValue());
      paramContext = new URL(a(paramBaseArticleInfo.getFirstFrameUrl().toString()));
      ImageRequest localImageRequest = new ImageRequest();
      localImageRequest.jdField_a_of_type_JavaNetURL = paramContext;
      localImageRequest.jdField_b_of_type_Int = paramBaseArticleInfo.getFirstFrameHeight();
      localImageRequest.jdField_a_of_type_Int = paramBaseArticleInfo.getFirstFrameWidth();
      localImageRequest.jdField_b_of_type_Boolean = true;
      ImageManager.a().a(localImageRequest, new MultiVideoHelper.1(paramBaseArticleInfo, paramContext));
      return;
    }
    catch (Exception paramBaseArticleInfo)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 2, paramBaseArticleInfo.getMessage());
    }
  }
  
  public static boolean a(int paramInt1, int paramInt2, int paramInt3)
  {
    return (paramInt2 >= paramInt3) && ("1".equals(Aladdin.getConfig(434).getString("is_enter_video_account", "0"))) && (("" + paramInt1).equals(Aladdin.getConfig(434).getString("video_from_type", "-100")));
  }
  
  private static boolean a(BaseArticleInfo paramBaseArticleInfo)
  {
    boolean bool = true;
    if (paramBaseArticleInfo == null) {
      return false;
    }
    int i;
    if (Aladdin.getConfig(312).getIntegerFromString("first_frame_preload_disable", 0) == 0)
    {
      i = 1;
      if ((paramBaseArticleInfo.getFirstFrameUrl() == null) || (paramBaseArticleInfo.mChannelID != 0L) || (i == 0)) {
        break label53;
      }
    }
    for (;;)
    {
      return bool;
      i = 0;
      break;
      label53:
      bool = false;
    }
  }
  
  private static String b(Intent paramIntent)
  {
    int i = -1;
    String str = paramIntent.getStringExtra("video_rowkey");
    int k = paramIntent.getIntExtra("VIDEO_FROM_TYPE", -1);
    Object localObject = paramIntent.getStringExtra("VIDEO_WIDTH");
    paramIntent = paramIntent.getStringExtra("VIDEO_HEIGHT");
    int j;
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      if (!TextUtils.isEmpty(paramIntent)) {
        break label119;
      }
      j = 0;
      label53:
      if (!a(k, i, j)) {
        break label130;
      }
      paramIntent = "https://viola.qq.com/js/VideoAccountFeeds.js?_rij_violaUrl=1&v_tid=15&v_bundleName=VideoAccountFeeds&hideNav=1&statusColor=1&v_bid=3811&_cache_bunle=1&v_nav_immer=1";
    }
    for (;;)
    {
      localObject = paramIntent;
      if (!TextUtils.isEmpty(str)) {
        localObject = paramIntent + "&video_rowkey=" + str;
      }
      return localObject;
      i = Integer.valueOf((String)localObject).intValue();
      break;
      label119:
      j = Integer.valueOf(paramIntent).intValue();
      break label53;
      label130:
      if (ViolaVideoFeedsConfigHandler.a(k)) {
        paramIntent = ViolaAccessHelper.a();
      } else {
        paramIntent = "https://viola.qq.com/js/VideoFeeds.js?_rij_violaUrl=1&v_tid=15&v_bundleName=VideoFeeds&hideNav=1&v_nav_immer=1&statusColor=1&v_bid=3811&statusBarStyle=1&v_bg_color=000000&v_present_titleHeight=44&v_old_modal=1&_ckey=rij_video_feeds_cache_key";
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoHelper
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.biz.pubaccount.readinjoy.video.playfeedback;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.CodecReuseHelper;
import com.tencent.biz.pubaccount.readinjoy.video.CodecReuseHelper.Companion;
import com.tencent.biz.pubaccount.readinjoy.video.VideoPlayerWrapper;
import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.PlayerHelper;
import com.tencent.biz.pubaccount.readinjoy.video.player.wrapper.PlayerHelper.Companion;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaAccessHelper;
import com.tencent.biz.qqstory.takevideo.doodle.util.DisplayUtil;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PlayFeedbackHelper
{
  private static SparseArray<PlayFeedbackHelper.FeedbackCallback> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private static ScreenCaptureHelper jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedbackScreenCaptureHelper = new ScreenCaptureHelper();
  
  private static HashMap<String, String> a(JSONObject paramJSONObject)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str1 = String.valueOf(localIterator.next());
      String str2 = String.valueOf(paramJSONObject.opt(str1));
      if (!TextUtils.isEmpty(str1)) {
        localHashMap.put(str1, str2);
      }
    }
    return localHashMap;
  }
  
  public static Map<String, String> a(VideoPlayerWrapper paramVideoPlayerWrapper)
  {
    HashMap localHashMap = new HashMap();
    if (paramVideoPlayerWrapper != null)
    {
      localHashMap.put("param_url", paramVideoPlayerWrapper.b());
      localHashMap.put("param_bitrate", String.valueOf(paramVideoPlayerWrapper.a));
      localHashMap.put("param_duration", String.valueOf(paramVideoPlayerWrapper.b()));
      localHashMap.put("param_file_size", String.valueOf(paramVideoPlayerWrapper.d()));
      localHashMap.put("param_is265", String.valueOf(paramVideoPlayerWrapper.b));
    }
    return localHashMap;
  }
  
  public static void a(int paramInt)
  {
    jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
  }
  
  private static void a(Activity paramActivity, int paramInt)
  {
    Bundle localBundle = new Bundle();
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("callAddress", paramInt);
      localBundle.putString("param", localJSONObject.toString());
      ViolaAccessHelper.a(paramActivity, null, "https://viola.qq.com/js/RIJVideoFeedback.js?_rij_violaUrl=1&v_tid=15&v_bundleName=RIJVideoFeedback&_rij_violaUrl=1&v_present=2&hideNav=1&v_bid=3811&v_nav_immer=1&statusColor=1&v_present_bar=0&v_present_radius=6&v_present_top=" + (DisplayUtil.a(BaseApplicationImpl.context, DisplayUtil.b(BaseApplicationImpl.context)) - 385) + "&v_present_auto_top=0", localBundle, true);
      return;
    }
    catch (JSONException paramActivity)
    {
      QLog.e("PlayFeedbackHelper", 2, "PlayFeedbackHelper start failed", paramActivity);
    }
  }
  
  public static void a(Activity paramActivity, BaseArticleInfo paramBaseArticleInfo, VideoPlayerWrapper paramVideoPlayerWrapper, int paramInt1, int paramInt2)
  {
    paramBaseArticleInfo = new PlayFeedbackHelper.1(paramBaseArticleInfo, paramInt1, paramInt2, a(paramVideoPlayerWrapper), paramActivity);
    paramInt1 = paramBaseArticleInfo.hashCode();
    a(paramBaseArticleInfo);
    a(paramActivity, paramInt1);
  }
  
  private static void a(Activity paramActivity, HashMap<String, String> paramHashMap)
  {
    jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoPlayfeedbackScreenCaptureHelper.a(paramActivity, true, 0.5F, new PlayFeedbackHelper.2(paramHashMap));
  }
  
  public static void a(Activity paramActivity, HashMap<String, String> paramHashMap, int paramInt)
  {
    paramHashMap.put("agree_capture", String.valueOf(paramInt));
    if (paramInt != 0) {}
    for (paramInt = 1; paramInt != 0; paramInt = 0)
    {
      a(paramActivity, paramHashMap);
      return;
    }
    b(paramHashMap);
  }
  
  public static void a(Activity paramActivity, JSONObject paramJSONObject)
  {
    for (;;)
    {
      try
      {
        int j = new JSONObject(paramJSONObject.optString("extral")).optInt("callAddress", -1);
        if (j == -1)
        {
          i = 1;
          if (i != 0)
          {
            b(paramActivity, paramJSONObject);
            return;
          }
          a(paramJSONObject, j);
          return;
        }
      }
      catch (Exception paramActivity)
      {
        paramActivity.printStackTrace();
        return;
      }
      int i = 0;
    }
  }
  
  public static void a(PlayFeedbackHelper.FeedbackCallback paramFeedbackCallback)
  {
    jdField_a_of_type_AndroidUtilSparseArray.put(paramFeedbackCallback.hashCode(), paramFeedbackCallback);
  }
  
  public static void a(String paramString, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("video_scene", paramInt);
      String str = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentUin();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800AA74", "0X800AA74", 0, 0, str, paramString, "", localJSONObject.toString(), false);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("PlayFeedbackHelper", 2, "reportPlayFeedbackBtnExpose error", localJSONException);
      }
    }
  }
  
  public static void a(String paramString, int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("video_scene", paramInt1);
      localJSONObject.put("feedback_entry", paramInt2);
      String str = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentUin();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800AA75", "0X800AA75", 0, 0, str, paramString, "", localJSONObject.toString(), false);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("PlayFeedbackHelper", 2, "reportPlayFeedbackBtnExpose error", localJSONException);
      }
    }
  }
  
  public static void a(Map<String, String> paramMap)
  {
    paramMap.put("param_uin", ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentUin());
    paramMap.put("param_platform", String.valueOf(1));
    paramMap.put("param_sdk_version", TVK_SDKMgr.SDK_Ver);
    paramMap.put("param_version", "8.5.5.5105");
    paramMap.put("param_subversion", "8.5.5");
    paramMap.put("param_videoCodecEnable", String.valueOf(CodecReuseHelper.a.c()));
    paramMap.put("param_isSuperPlayer", String.valueOf(PlayerHelper.a.a()));
    paramMap.put("param_app_package", "com.tencent.mobileqq");
  }
  
  public static void a(Map<String, String> paramMap, int paramInt1, int paramInt2, JSONObject paramJSONObject)
  {
    JSONArray localJSONArray = paramJSONObject.optJSONArray("feedback_type_list");
    String str = "";
    if (localJSONArray != null) {
      str = localJSONArray.toString();
    }
    paramJSONObject = paramJSONObject.optString("feedback_text");
    paramMap.put("param_video_scene", String.valueOf(paramInt1));
    paramMap.put("param_feedback_entry", String.valueOf(paramInt2));
    paramMap.put("param_feedback_type_list", str);
    paramMap.put("param_feedbackText", paramJSONObject);
  }
  
  private static void a(JSONObject paramJSONObject, int paramInt)
  {
    PlayFeedbackHelper.FeedbackCallback localFeedbackCallback = (PlayFeedbackHelper.FeedbackCallback)jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    if (localFeedbackCallback != null) {
      localFeedbackCallback.a(paramJSONObject);
    }
    a(paramInt);
  }
  
  private static void b(Activity paramActivity, PlayFeedbackHelper.FeedbackCallback paramFeedbackCallback, JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PlayFeedbackHelper", 2, "feedbackCallback jsonObject:" + paramJSONObject);
    }
    HashMap localHashMap = paramFeedbackCallback.jdField_a_of_type_JavaUtilHashMap;
    a(localHashMap);
    a(localHashMap, paramFeedbackCallback.jdField_a_of_type_Int, paramFeedbackCallback.b, paramJSONObject);
    localHashMap.put("param_busiType", String.valueOf(paramFeedbackCallback.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.busiType));
    localHashMap.put("param_rowkey", String.valueOf(paramFeedbackCallback.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getInnerUniqueID()));
    localHashMap.put("param_title", paramFeedbackCallback.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.mTitle);
    localHashMap.put("param_vid", paramFeedbackCallback.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getVideoVid());
    if (paramJSONObject.optInt("close_type") > 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      a(paramActivity, localHashMap, paramJSONObject.optInt("agree_capture"));
      b(paramFeedbackCallback.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getInnerUniqueID(), paramFeedbackCallback.jdField_a_of_type_Int, paramFeedbackCallback.b);
      return;
    }
    c(paramFeedbackCallback.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructBaseArticleInfo.getInnerUniqueID(), paramFeedbackCallback.jdField_a_of_type_Int, paramFeedbackCallback.b);
  }
  
  private static void b(Activity paramActivity, JSONObject paramJSONObject)
  {
    if (paramJSONObject.optInt("close_type") > 0) {}
    for (int i = 1; i == 0; i = 0) {
      return;
    }
    HashMap localHashMap = new HashMap();
    JSONObject localJSONObject = paramJSONObject.optJSONObject("extral");
    a(localHashMap);
    if (localJSONObject != null) {
      localHashMap.putAll(a(localJSONObject));
    }
    if (paramActivity != null)
    {
      a(paramActivity, localHashMap, paramJSONObject.optInt("agree_capture"));
      return;
    }
    QLog.w("PlayFeedbackHelper", 1, "feedbackOnViolaScene but shareEntryActivity is null, don't captureView");
    b(localHashMap);
  }
  
  public static void b(String paramString, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("video_scene", paramInt);
      String str = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentUin();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800AA76", "0X800AA76", 0, 0, str, paramString, "", localJSONObject.toString(), false);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("PlayFeedbackHelper", 2, "reportPlayFeedbackBtnExpose error", localJSONException);
      }
    }
  }
  
  public static void b(String paramString, int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("video_scene", paramInt1);
      localJSONObject.put("feedback_entry", paramInt2);
      String str = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentUin();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800AA77", "0X800AA77", 0, 0, str, paramString, "", localJSONObject.toString(), false);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("PlayFeedbackHelper", 2, "reportPlayFeedbackBtnExpose error", localJSONException);
      }
    }
  }
  
  private static void b(HashMap<String, String> paramHashMap)
  {
    ThreadManager.post(new PlayFeedbackHelper.3(paramHashMap), 5, null, true);
  }
  
  public static void c(String paramString, int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("video_scene", paramInt1);
      localJSONObject.put("feedback_entry", paramInt2);
      String str = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getCurrentUin();
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, "", "0X800AA78", "0X800AA78", 0, 0, str, paramString, "", localJSONObject.toString(), false);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("PlayFeedbackHelper", 2, "reportPlayFeedbackBtnExpose error", localJSONException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.playfeedback.PlayFeedbackHelper
 * JD-Core Version:    0.7.0.1
 */
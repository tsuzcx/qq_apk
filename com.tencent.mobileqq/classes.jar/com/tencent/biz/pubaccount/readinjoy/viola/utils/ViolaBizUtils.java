package com.tencent.biz.pubaccount.readinjoy.viola.utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.Window;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.offline.OfflineEnvHelper;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.readinjoy.comment.data.AnchorData;
import com.tencent.biz.pubaccount.readinjoy.comment.data.CommonCommentData;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.preparse.RIJPreParseData;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyAtlasCommentFragment;
import com.tencent.biz.pubaccount.readinjoy.logic.ReadInJoyAtlasManager;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UgcVideo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.ugc.RIJUgcUtils;
import com.tencent.biz.pubaccount.readinjoy.ugc.editvideo.PublishVideoHelper;
import com.tencent.biz.pubaccount.readinjoy.ugc.publishvideotask.RIJUgcVideoPublishManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.vip.CUKingCardHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.dom.style.FlexConvertUtils;
import com.tencent.viola.utils.ViolaLogUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.readinjoy.ReadInJoyHelper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ViolaBizUtils
{
  public static String a;
  private static String b = "8.0.6";
  
  static
  {
    jdField_a_of_type_JavaLangString = "ViolaBizUtils";
  }
  
  public static AnchorData a(JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("commentID");
    String str2 = paramJSONObject.optString("subCommentID");
    boolean bool = paramJSONObject.optBoolean("isAwesome");
    paramJSONObject = new AnchorData();
    paramJSONObject.jdField_a_of_type_JavaLangString = str1;
    paramJSONObject.b = str2;
    paramJSONObject.jdField_a_of_type_Boolean = bool;
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "openTopicVideoComment anchorData commentId:" + str1 + " ,subCommentId :" + str2);
    }
    return paramJSONObject;
  }
  
  public static ArticleInfo a(JSONObject paramJSONObject)
  {
    String str1 = paramJSONObject.optString("rowkey");
    String str2 = paramJSONObject.optString("title", "");
    String str3 = paramJSONObject.optString("cover", "");
    long l1 = paramJSONObject.optLong("articleId", 0L);
    long l2 = paramJSONObject.optLong("feedsID", 0L);
    int i = paramJSONObject.optInt("feedsType", 0);
    ArticleInfo localArticleInfo = new ArticleInfo();
    localArticleInfo.innerUniqueID = str1;
    localArticleInfo.mTitle = str2;
    localArticleInfo.mSummary = null;
    localArticleInfo.mFirstPagePicUrl = str3;
    localArticleInfo.mArticleID = l1;
    localArticleInfo.mFeedId = l2;
    localArticleInfo.mFeedType = i;
    if (!TextUtils.isEmpty(paramJSONObject.optString("vid", ""))) {
      localArticleInfo.mVideoVid = paramJSONObject.optString("vid");
    }
    if (!TextUtils.isEmpty(paramJSONObject.optString("picUrl", ""))) {
      localArticleInfo.mVideoCoverUrl = RIJPreParseData.a(paramJSONObject.optString("picUrl"));
    }
    if (QLog.isColorLevel()) {
      QLog.d(jdField_a_of_type_JavaLangString, 1, "openTopicVideoComment  uniqueKey = " + str1 + "feedsId = " + l2 + " feedsType=" + i + "title = " + str2 + "picUrl =" + str3 + "articleId =" + l1);
    }
    return localArticleInfo;
  }
  
  public static String a()
  {
    int j = 1;
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("platform", "Android");
        localJSONObject.put("osVersion", DeviceInfoUtil.e());
        localJSONObject.put("appName", DeviceInfoUtil.c());
        localJSONObject.put("appVersion", "8.5.5.5105");
        localJSONObject.put("appVersionCode", c());
        DisplayMetrics localDisplayMetrics = BaseApplication.getContext().getResources().getDisplayMetrics();
        float f1 = FlexConvertUtils.getScreenHeight(BaseApplication.getContext()) / localDisplayMetrics.density;
        float f2 = FlexConvertUtils.getScreenWidth(BaseApplication.getContext()) / localDisplayMetrics.density;
        float f3 = localDisplayMetrics.density;
        localJSONObject.put("deviceWidth", Math.min(f2, f1));
        localJSONObject.put("deviceHeight", Math.max(f2, f1));
        localJSONObject.put("dpToPxRatio", f3);
        localJSONObject.put("deviceModel", Build.MODEL);
        localJSONObject.put("violaVersion", b);
        localJSONObject.put("statusBarHeight", ImmersiveUtils.getStatusBarHeight(BaseApplication.getContext()) / localDisplayMetrics.density);
        localJSONObject.put("appID", "1");
        localJSONObject.put("isDebug", 0);
        localJSONObject.put("navBarHeight", DisplayUtil.getNavigationBarHeight(BaseApplication.getContext()) / localDisplayMetrics.density);
        localJSONObject.put("deviceBrand", Build.BRAND);
        localJSONObject.put("appVersionId", "8.5.5");
        LiuHaiUtils.a(BaseActivity.sTopActivity);
        if (!LiuHaiUtils.b()) {
          continue;
        }
        i = 1;
        localJSONObject.put("isLiuHai", i);
        if (CUKingCardHelper.a() != 1) {
          continue;
        }
        i = j;
        localJSONObject.put("isKindCard", i);
        localJSONObject.put("netType", HttpUtil.getNetWorkType());
        localJSONObject.put("build", 102);
        if (BaseActivity.sTopActivity != null) {
          localJSONObject.put("nowNavBarHeight", CommonSuspensionGestureLayout.a(BaseActivity.sTopActivity) / localDisplayMetrics.density);
        }
        localJSONObject.put("androidVersion", Build.VERSION.SDK_INT);
      }
      catch (JSONException localJSONException)
      {
        int i;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, "env JSONException");
        continue;
      }
      return localJSONObject.toString();
      i = 0;
      continue;
      i = 0;
    }
  }
  
  public static String a(String paramString)
  {
    String str = Uri.parse(paramString).getQueryParameter("v_bid");
    paramString = str;
    if (TextUtils.isEmpty(str)) {
      paramString = "-1";
    }
    return paramString;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    String str = OfflineEnvHelper.a(paramString1);
    if (TextUtils.isEmpty(str)) {}
    do
    {
      return null;
      paramString1 = str + paramString1;
      paramString2 = HtmlOffline.d(paramString2);
    } while (TextUtils.isEmpty(paramString2));
    return paramString1 + "/" + paramString2;
  }
  
  public static JSONObject a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("viewDidAppear", 1);
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return new JSONObject();
  }
  
  public static JSONObject a(int paramInt)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("receiveNewMessage", paramInt);
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return new JSONObject();
  }
  
  public static JSONObject a(JSONObject paramJSONObject)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("switchPagerRefresh", paramJSONObject);
      return localJSONObject;
    }
    catch (JSONException paramJSONObject)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "switchPagerRefresh error:" + paramJSONObject.getMessage());
    }
    return new JSONObject();
  }
  
  public static void a(BridgeModule paramBridgeModule, long paramLong, @NotNull List<UgcVideo> paramList, String paramString1, int paramInt, String paramString2)
  {
    a(paramBridgeModule, paramLong, paramList, paramString1, paramInt, paramString2, false);
  }
  
  public static void a(BridgeModule paramBridgeModule, long paramLong, @NotNull List<UgcVideo> paramList, String paramString1, int paramInt, String paramString2, boolean paramBoolean)
  {
    ThreadManagerV2.excute(new ViolaBizUtils.3(paramList, paramInt, paramString2, paramBoolean, paramBridgeModule, paramString1), 16, null, false);
  }
  
  public static void a(BridgeModule paramBridgeModule, @NotNull QQAppInterface paramQQAppInterface, long paramLong, String paramString)
  {
    RIJUgcVideoPublishManager.a(paramQQAppInterface).a(paramLong, new ViolaBizUtils.6(paramBridgeModule, paramLong, paramString));
  }
  
  public static void a(BridgeModule paramBridgeModule, String paramString)
  {
    try
    {
      ReadInJoyUserInfoModule.a(ReadInJoyUtils.a(), new ViolaBizUtils.1(paramBridgeModule, paramString), true);
      return;
    }
    catch (Exception paramBridgeModule)
    {
      ViolaLogUtils.e(jdField_a_of_type_JavaLangString, paramBridgeModule.getMessage());
    }
  }
  
  public static void a(BridgeModule paramBridgeModule, String paramString1, String paramString2)
  {
    try
    {
      ReadInJoyUserInfo localReadInJoyUserInfo = ReadInJoyUserInfoModule.a(Long.parseLong(paramString1), null);
      if ((localReadInJoyUserInfo != null) && (localReadInJoyUserInfo.isLiving())) {}
      for (boolean bool = true;; bool = false)
      {
        paramString1 = "";
        if (localReadInJoyUserInfo != null) {
          paramString1 = localReadInJoyUserInfo.getLiveUrl();
        }
        paramBridgeModule.invokeCallJS(paramString2, new JSONObject().put("isLiving", bool).put("liveUrl", paramString1));
        return;
      }
      return;
    }
    catch (Exception paramBridgeModule)
    {
      ViolaLogUtils.e(jdField_a_of_type_JavaLangString, paramBridgeModule.getMessage());
    }
  }
  
  public static void a(BridgeModule paramBridgeModule, JSONObject paramJSONObject)
  {
    if ((paramBridgeModule.getViolaInstance() != null) && (paramBridgeModule.getViolaInstance().getActivity() != null))
    {
      UrlJumpInfo localUrlJumpInfo = new UrlJumpInfo();
      localUrlJumpInfo.jdField_a_of_type_Int = paramJSONObject.optInt("jumpType", 1);
      localUrlJumpInfo.jdField_a_of_type_JavaLangString = paramJSONObject.optString("jumpUrl", "");
      localUrlJumpInfo.b = paramJSONObject.optString("jumpBundle", "");
      localUrlJumpInfo.c = paramJSONObject.optString("jumpSchema", "");
      localUrlJumpInfo.d = paramJSONObject.optString("clipboardInfo", "");
      localUrlJumpInfo.e = paramJSONObject.optString("commonData", "");
      VideoFeedsHelper.a(paramBridgeModule.getViolaInstance().getActivity(), localUrlJumpInfo);
    }
  }
  
  public static void a(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    Object localObject;
    float f;
    if (paramJSONObject != null)
    {
      localObject = paramBridgeModule.getViolaInstance().getActivity();
      paramJSONObject = VideoFeedsHelper.a((Activity)localObject, paramJSONObject.optInt("width"), paramJSONObject.optInt("height"));
      f = 750.0F / VideoFeedsHelper.b(localObject)[0];
      localObject = new JSONObject();
    }
    try
    {
      ((JSONObject)localObject).put("x", paramJSONObject.left * f);
      ((JSONObject)localObject).put("y", paramJSONObject.top * f);
      ((JSONObject)localObject).put("width", paramJSONObject.width() * f);
      ((JSONObject)localObject).put("height", f * paramJSONObject.height());
      paramBridgeModule.invokeJS(paramString, (JSONObject)localObject);
      return;
    }
    catch (JSONException paramBridgeModule)
    {
      paramBridgeModule.printStackTrace();
    }
  }
  
  public static void a(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString, int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    QQAppInterface localQQAppInterface = (QQAppInterface)ReadInJoyUtils.a();
    if (localQQAppInterface != null) {}
    for (;;)
    {
      boolean bool;
      try
      {
        long l = paramJSONObject.optLong("uin", 0L);
        if ((l == 0L) || (l != localQQAppInterface.getLongAccountUin()))
        {
          localJSONObject.put("hasPermission", 0);
          paramBridgeModule.invokeJS(paramString, localJSONObject);
          return;
        }
        if (paramInt != 1) {
          break label138;
        }
        bool = RIJUgcUtils.h();
      }
      catch (JSONException paramJSONObject)
      {
        paramBridgeModule.invokeJS(paramString, localJSONObject);
        QLog.e(jdField_a_of_type_JavaLangString, 1, "BridgeModule: getReadInJoyUgcPermission type =" + paramInt + paramJSONObject.toString());
        return;
      }
      localJSONObject.put("hasPermission", i);
      continue;
      label138:
      if (paramInt == 2) {
        bool = RIJUgcUtils.i();
      }
      while (!bool)
      {
        i = 0;
        break;
        QLog.e(jdField_a_of_type_JavaLangString, 1, "BridgeModule: getReadInJoyUgcPermission app is null!");
        return;
        bool = false;
      }
      int i = 1;
    }
  }
  
  public static void a(JSONObject paramJSONObject)
  {
    long l = paramJSONObject.optLong("uin");
    int i = paramJSONObject.optInt("columnId");
    int j = paramJSONObject.optInt("action");
    int k = paramJSONObject.optInt("currentFollowCount");
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "onColumnAttentionStatusChange, uin=" + l + " columnId=" + i + " action=" + j + " subscribeCount=" + k);
    }
    if (l == ReadInJoyUtils.a())
    {
      ReadInJoyLogicEngineEventDispatcher.a().a(i, j, k);
      return;
    }
    QLog.e(jdField_a_of_type_JavaLangString, 1, "onColumnAttentionStatusChange current uin not equals to " + l);
  }
  
  public static void a(JSONObject paramJSONObject, int paramInt)
  {
    for (;;)
    {
      try
      {
        String str1 = paramJSONObject.optString("uniqueKey");
        int i = paramJSONObject.optInt("source", 3);
        Object localObject2 = paramJSONObject.optString("feedsID", "");
        int j = paramJSONObject.optInt("feedsType", -1);
        int k = paramJSONObject.optInt("adTag", -1);
        String str3 = paramJSONObject.optString("title", "");
        String str4 = paramJSONObject.optString("sourceName", "");
        String str5 = paramJSONObject.optString("picUrl", "");
        long l1 = paramJSONObject.optLong("duration", -1L);
        String str6 = paramJSONObject.optString("articleID", "");
        Object localObject1 = paramJSONObject.optString("commentID");
        String str2 = paramJSONObject.optString("subCommentID");
        bool = paramJSONObject.optBoolean("isAwesome");
        int m = paramJSONObject.optInt("jumpType");
        int n = paramJSONObject.optInt("showType", 0);
        long l2 = paramJSONObject.optLong("recommendSeq", 0L);
        QLog.d(jdField_a_of_type_JavaLangString, 1, "startShowComment  uniqueKey = " + str1 + "source = " + i + "feedsId = " + (String)localObject2 + " feedsType=" + j + "adTag = " + k + "title = " + str3 + "sourceName = " + str4 + "picUrl =" + str5 + "duration = " + l1 + "articleId =" + str6);
        paramJSONObject = new Bundle();
        paramJSONObject.putSerializable("commonCommentData", new CommonCommentData(str6, j, (String)localObject2, k, str3, str4, str5, l1));
        paramJSONObject.putInt("source", i);
        paramJSONObject.putString("commentId", (String)localObject1);
        paramJSONObject.putString("subCommentId", str2);
        paramJSONObject.putBoolean("isAwesome", bool);
        paramJSONObject.putInt("jumpType", m);
        paramJSONObject.putInt("seq", paramInt);
        paramJSONObject.putLong("recommendSeq", l2);
        localObject2 = new AnchorData();
        ((AnchorData)localObject2).jdField_a_of_type_JavaLangString = ((String)localObject1);
        ((AnchorData)localObject2).b = str2;
        ((AnchorData)localObject2).jdField_a_of_type_Boolean = bool;
        QLog.d(jdField_a_of_type_JavaLangString, 1, "anchorData commentId:" + (String)localObject1 + " ,subCommentId :" + str2);
        localObject1 = BaseActivity.sTopActivity;
        if (n == 1)
        {
          bool = true;
          ReadInJoyAtlasCommentFragment.a((Context)localObject1, str1, null, null, null, (AnchorData)localObject2, false, bool, paramJSONObject);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        boolean bool;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d(jdField_a_of_type_JavaLangString, 2, QLog.getStackTraceString(paramJSONObject));
      }
      bool = false;
    }
  }
  
  public static boolean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      String str;
      do
      {
        return false;
        str = Uri.parse(paramString).getQueryParameter("v_bid");
      } while (TextUtils.isEmpty(str));
      paramString = a(str, paramString);
    } while ((TextUtils.isEmpty(paramString)) || (!new File(paramString).exists()));
    return true;
  }
  
  public static float[] a()
  {
    float[] arrayOfFloat = new float[2];
    try
    {
      Object localObject = BaseActivity.sTopActivity;
      if (localObject == null) {
        return arrayOfFloat;
      }
      localObject = ((Activity)localObject).getWindow().getDecorView();
      DisplayMetrics localDisplayMetrics = BaseApplication.getContext().getResources().getDisplayMetrics();
      float f2 = ((View)localObject).getWidth() / localDisplayMetrics.density;
      float f1 = ((View)localObject).getHeight() / localDisplayMetrics.density;
      f2 = Math.min(f2, f1);
      f1 = Math.max(f2, f1);
      arrayOfFloat[0] = f2;
      arrayOfFloat[1] = f1;
      return arrayOfFloat;
    }
    catch (Throwable localThrowable)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[getTopActivitySize]: " + localThrowable.getMessage());
    }
    return arrayOfFloat;
  }
  
  public static String b()
  {
    long l = System.currentTimeMillis();
    return "&time=" + String.valueOf(l).substring(0, 7);
  }
  
  public static String b(String paramString)
  {
    String str = Uri.parse(paramString).getQueryParameter("v_bid");
    if (TextUtils.isEmpty(str)) {
      return null;
    }
    return a(str, paramString);
  }
  
  public static JSONObject b()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("viewDidDisappear", 1);
      return localJSONObject;
    }
    catch (JSONException localJSONException) {}
    return new JSONObject();
  }
  
  public static JSONObject b(int paramInt)
  {
    try
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("type", paramInt);
      localJSONObject1.put("pageRefresh", localJSONObject2);
      return localJSONObject1;
    }
    catch (JSONException localJSONException) {}
    return new JSONObject();
  }
  
  private static void b(BridgeModule paramBridgeModule, ReadInJoyUserInfo paramReadInJoyUserInfo, String paramString)
  {
    if (paramReadInJoyUserInfo == null)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "[onLoadUserInfoSucceed]: userInfo is null");
      return;
    }
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uin", Long.parseLong(paramReadInJoyUserInfo.uin)).put("nickName", paramReadInJoyUserInfo.nick).put("headUrl", ReadInJoyUserInfoModule.a(paramReadInJoyUserInfo));
      paramBridgeModule.invokeJS(paramString, localJSONObject);
      return;
    }
    catch (JSONException paramBridgeModule)
    {
      ViolaLogUtils.e(jdField_a_of_type_JavaLangString, paramBridgeModule.getMessage());
    }
  }
  
  public static void b(BridgeModule paramBridgeModule, JSONObject paramJSONObject)
  {
    Object localObject = (QQAppInterface)ReadInJoyUtils.a();
    String str1;
    String str2;
    String str3;
    String str4;
    String str5;
    Bundle localBundle;
    if (localObject != null)
    {
      str1 = paramJSONObject.optString("rowkey", "");
      str2 = paramJSONObject.optString("article_title", "");
      str3 = paramJSONObject.optString("article_summary", "");
      str4 = paramJSONObject.optString("first_page_url", "");
      i = paramJSONObject.optInt("duration", 0);
      str5 = paramJSONObject.optString("article_url", "") + "&sourcefrom=6";
      int j = paramJSONObject.optInt("publishAccountUin", 0);
      String str6 = paramJSONObject.optString("publishAccountName", "");
      localObject = ((QQAppInterface)localObject).getAccount();
      localBundle = new Bundle();
      localBundle.putInt("videoDuration", i);
      localBundle.putLong("publishAccountUin", j);
      localBundle.putString("publishAccountName", str6);
      if (paramJSONObject.optInt("busiType", 6) != 6) {
        break label215;
      }
    }
    label215:
    for (int i = 1;; i = 2)
    {
      localBundle.putInt("videoType", i);
      ReadInJoyAtlasManager.a().a(paramBridgeModule.getViolaInstance().getActivity(), (String)localObject, 2, str1, str2, str3, str4, str5, localBundle, true);
      return;
    }
  }
  
  public static void b(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    String str = paramJSONObject.optString("vid");
    int i = paramJSONObject.optInt("pageType");
    int j = paramJSONObject.optInt("topicId");
    QLog.i(jdField_a_of_type_JavaLangString, 1, "cancelUploadingVideo, content=" + paramJSONObject.toString() + ",callbackId=" + paramString);
    paramJSONObject = RIJQQAppInterfaceUtil.a();
    if (paramJSONObject != null) {
      RIJUgcVideoPublishManager.a(paramJSONObject).a(j, new ViolaBizUtils.2(str, paramJSONObject, i, paramBridgeModule, j, paramString));
    }
  }
  
  public static boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    try
    {
      boolean bool = "1".equals(Uri.parse(paramString).getQueryParameter("supportColorBall"));
      return bool;
    }
    catch (Exception paramString)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, paramString.getMessage());
    }
    return false;
  }
  
  private static String c()
  {
    return DeviceInfoUtil.a(BaseApplication.getContext());
  }
  
  public static String c(String paramString)
  {
    SharedPreferences localSharedPreferences;
    if (!TextUtils.isEmpty(paramString))
    {
      localSharedPreferences = ReadInJoyHelper.a(BaseApplicationImpl.getApplication().getRuntime(), true, true);
      if (localSharedPreferences == null) {
        QLog.d(jdField_a_of_type_JavaLangString, 1, "failed to getItem");
      }
    }
    else
    {
      return null;
    }
    return localSharedPreferences.getString(paramString, null);
  }
  
  public static JSONObject c()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("switchPagerScroll", 1);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      QLog.e(jdField_a_of_type_JavaLangString, 1, "switchPagerScroll error:" + localJSONException.getMessage());
    }
    return new JSONObject();
  }
  
  public static void c(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    String str = paramJSONObject.optString("vid");
    int i = paramJSONObject.optInt("pageType");
    int j = paramJSONObject.optInt("topicId");
    QLog.i(jdField_a_of_type_JavaLangString, 1, "resumeUploadingVideo, vid=" + str + "pageType=" + i);
    paramJSONObject = RIJQQAppInterfaceUtil.a();
    if (paramJSONObject != null) {
      RIJUgcVideoPublishManager.a(paramJSONObject).a(j, new ViolaBizUtils.4(str, paramJSONObject, i, paramBridgeModule, j, paramString));
    }
  }
  
  public static String d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    String str;
    do
    {
      do
      {
        return paramString;
      } while (!paramString.contains("v_url_base64"));
      str = Uri.parse(paramString).getQueryParameter("v_url_base64");
    } while (TextUtils.isEmpty(str));
    return new String(Base64.decode(str, 0));
  }
  
  public static void d(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    String str = paramJSONObject.optString("vid");
    int i = paramJSONObject.optInt("pageType");
    int j = paramJSONObject.optInt("topicId");
    QLog.i(jdField_a_of_type_JavaLangString, 1, "pauseUploadingVideo, content=" + paramJSONObject.toString() + ",callbackId=" + paramString);
    paramJSONObject = RIJQQAppInterfaceUtil.a();
    if (paramJSONObject != null) {
      RIJUgcVideoPublishManager.a(paramJSONObject).a(j, new ViolaBizUtils.5(str, paramJSONObject, i, paramBridgeModule, j, paramString));
    }
  }
  
  public static void e(BridgeModule paramBridgeModule, JSONObject paramJSONObject, String paramString)
  {
    QLog.i(jdField_a_of_type_JavaLangString, 1, "chooseVideoAddToTopic, callback = " + paramString + ", jsonObject = " + paramJSONObject.toString());
    JSONArray localJSONArray = paramJSONObject.optJSONArray("videoList");
    ArrayList localArrayList = new ArrayList();
    JSONObject localJSONObject = new JSONObject();
    int i = 0;
    for (;;)
    {
      try
      {
        if (i < localJSONArray.length())
        {
          String str = localJSONArray.getString(i);
          if (!TextUtils.isEmpty(str)) {
            localArrayList.add(str);
          } else {
            QLog.i(jdField_a_of_type_JavaLangString, 1, "chooseVideoAddToTopic index = " + i + "rowkey is empty.");
          }
        }
      }
      catch (JSONException paramJSONObject)
      {
        paramBridgeModule.invokeJS(paramString, localJSONObject);
        QLog.e(jdField_a_of_type_JavaLangString, 1, "chooseVideoAddToTopic error! e = " + paramJSONObject.toString());
        return;
      }
      i = paramJSONObject.optInt("topicId");
      if ((!localArrayList.isEmpty()) && (i != 0))
      {
        PublishVideoHelper.a(localArrayList, i, new ViolaBizUtils.7(localJSONObject, paramBridgeModule, paramString));
        return;
      }
      localJSONObject.put("errCode", -1);
      localJSONObject.put("errMsg", "rowkeys.isEmpty() || columnId == 0");
      paramBridgeModule.invokeJS(paramString, localJSONObject);
      return;
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.utils.ViolaBizUtils
 * JD-Core Version:    0.7.0.1
 */
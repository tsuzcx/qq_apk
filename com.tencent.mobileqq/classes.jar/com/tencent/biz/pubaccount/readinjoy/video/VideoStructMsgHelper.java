package com.tencent.biz.pubaccount.readinjoy.video;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.util.PAVideoStructMsgUtil;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/biz/pubaccount/readinjoy/video/VideoStructMsgHelper;", "", "()V", "ARK_APP_VER", "", "ARK_BASE_VIEW", "ARK_PACKAGE_NAME", "IS_JUMP_NATIVE", "", "TAG", "URL_TO_KD_FEEDS", "convertVideoShareStructMsgJsonToBundle", "Landroid/os/Bundle;", "jsonObject", "Lorg/json/JSONObject;", "getAvatarJumpUrlByBaseArticleInfo", "videoInfo", "Lcom/tencent/biz/pubaccount/readinjoy/struct/BaseArticleInfo;", "getAvatarUrlByVideo", "getMediaJsonByVideo", "Lorg/json/JSONArray;", "getShareUrl", "getShareUrlByBaseArticleInfo", "getVideoMeta", "fromPts", "", "getVideoShareStructMsgForArk", "getVideoShareStructMsgForArkToJson", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class VideoStructMsgHelper
{
  public static final VideoStructMsgHelper a = new VideoStructMsgHelper();
  
  private final String a(BaseArticleInfo paramBaseArticleInfo)
  {
    String str = (String)null;
    if (!TextUtils.isEmpty((CharSequence)paramBaseArticleInfo.thirdIcon)) {
      str = paramBaseArticleInfo.thirdIcon;
    }
    while (TextUtils.isEmpty((CharSequence)paramBaseArticleInfo.mSubscribeID)) {
      return str;
    }
    paramBaseArticleInfo = paramBaseArticleInfo.mSubscribeID;
    Intrinsics.checkExpressionValueIsNotNull(paramBaseArticleInfo, "videoInfo.mSubscribeID");
    return ReadInJoyUserInfoModule.a(ReadInJoyUserInfoModule.a(Long.parseLong(paramBaseArticleInfo), null));
  }
  
  private final String a(BaseArticleInfo paramBaseArticleInfo, boolean paramBoolean)
  {
    JSONObject localJSONObject1 = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject2 = new JSONObject();
        localJSONObject1.put("data", localJSONObject2);
        localJSONObject2.put("id", "none");
        localJSONObject2.put("rowkey", paramBaseArticleInfo.rawkey);
        localJSONObject2.put("uin", ReadInJoyUtils.a());
        localJSONObject2.put("puin", paramBaseArticleInfo.mSubscribeID);
        if (!paramBoolean) {
          continue;
        }
        localJSONObject2.put("nick", "@{uin:" + paramBaseArticleInfo.mSubscribeID + ",nick:" + paramBaseArticleInfo.thirdName + '}');
        if (!RIJItemViewType.o(paramBaseArticleInfo)) {
          continue;
        }
        localJSONObject2.put("contentJumpUrl", paramBaseArticleInfo.mOriginalUrl);
      }
      catch (JSONException paramBaseArticleInfo)
      {
        JSONObject localJSONObject2;
        QLog.e("VideoStructMsgHelper", 1, "getVideoMeta error", (Throwable)paramBaseArticleInfo);
        continue;
        String str = "";
        continue;
        localJSONObject2.put("nick", "@{uin:" + paramBaseArticleInfo.mSubscribeID + ",nick:" + paramBaseArticleInfo.mSubscribeName + '}');
        localJSONObject2.put("contentJumpUrl", c(paramBaseArticleInfo));
        continue;
      }
      localJSONObject2.put("avatar", a(paramBaseArticleInfo));
      localJSONObject2.put("avatarJumpUrl", b(paramBaseArticleInfo));
      localJSONObject2.put("iconJumpUrl", "mqqapi://readinjoy/open?src_type=internal&target=1&version=1");
      localJSONObject2.put("media", a(paramBaseArticleInfo));
      localJSONObject2.put("title", paramBaseArticleInfo.mTitle);
      localJSONObject2.put("type", 2);
      localJSONObject2.put("isAIO", 1);
      localJSONObject2.put("appName", "kandian");
      if (QLog.isColorLevel()) {
        QLog.d("VideoStructMsgHelper", 2, "getVideoMeta JSON:" + localJSONObject1);
      }
      return localJSONObject1.toString();
      str = paramBaseArticleInfo.getShareUrl();
      if (str == null) {
        continue;
      }
      localJSONObject2.put("contentJumpUrl", str);
    }
  }
  
  private final JSONArray a(BaseArticleInfo paramBaseArticleInfo)
  {
    JSONArray localJSONArray = new JSONArray();
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("isVideo", true);
      localJSONObject.put("videoDuration", paramBaseArticleInfo.getVideoDuration());
      localJSONObject.put("width", paramBaseArticleInfo.getVideoWidth());
      localJSONObject.put("height", paramBaseArticleInfo.getVideoHeight());
      localJSONObject.put("url", FeedsChannelDataHelper.a(paramBaseArticleInfo.getVideoCoverURL()));
      localJSONArray.put(localJSONObject);
      return localJSONArray;
    }
    catch (JSONException paramBaseArticleInfo)
    {
      QLog.e("VideoStructMsgHelper", 1, "getMediaJsonByVideo error", (Throwable)paramBaseArticleInfo);
    }
    return localJSONArray;
  }
  
  private final String b(BaseArticleInfo paramBaseArticleInfo)
  {
    String str1 = paramBaseArticleInfo.mSubscribeID;
    String str2 = PAVideoStructMsgUtil.a(str1, true);
    if ((paramBaseArticleInfo.busiType > 1) && ((TextUtils.isEmpty((CharSequence)str1)) || (Intrinsics.areEqual(str1, "16888")))) {
      return paramBaseArticleInfo.thirdAction;
    }
    return str2;
  }
  
  private final String c(BaseArticleInfo paramBaseArticleInfo)
  {
    return d(paramBaseArticleInfo);
  }
  
  private final String d(BaseArticleInfo paramBaseArticleInfo)
  {
    String str;
    if (paramBaseArticleInfo.aioShareUrl != null)
    {
      str = paramBaseArticleInfo.aioShareUrl;
      Intrinsics.checkExpressionValueIsNotNull(str, "videoInfo.aioShareUrl");
      if (StringsKt.contains$default((CharSequence)str, (CharSequence)"kandianshare.html5.qq.com", false, 2, null))
      {
        paramBaseArticleInfo = paramBaseArticleInfo.aioShareUrl;
        Intrinsics.checkExpressionValueIsNotNull(paramBaseArticleInfo, "videoInfo.aioShareUrl");
        return paramBaseArticleInfo;
      }
    }
    if (paramBaseArticleInfo.mArticleContentUrl != null)
    {
      str = paramBaseArticleInfo.mArticleContentUrl;
      Intrinsics.checkExpressionValueIsNotNull(str, "videoInfo.mArticleContentUrl");
      if (!StringsKt.contains$default((CharSequence)str, (CharSequence)"&sourcefrom=0", false, 2, null)) {
        paramBaseArticleInfo.mArticleContentUrl += "&sourcefrom=0";
      }
    }
    paramBaseArticleInfo = paramBaseArticleInfo.mArticleContentUrl;
    Intrinsics.checkExpressionValueIsNotNull(paramBaseArticleInfo, "videoInfo.mArticleContentUrl");
    return paramBaseArticleInfo;
  }
  
  @NotNull
  public final Bundle a(@Nullable BaseArticleInfo paramBaseArticleInfo)
  {
    Bundle localBundle = new Bundle();
    if (paramBaseArticleInfo != null)
    {
      localBundle.putInt("forward_type", 27);
      localBundle.putString("forward_ark_app_name", "com.tencent.biz.pubaccount.readinjoy");
      localBundle.putString("forward_ark_app_view", "baseView");
      localBundle.putString("forward_ark_app_ver", Aladdin.getConfig(415).getString("ark_app_ver", "1.0.0.66"));
      localBundle.putString("forward_ark_app_prompt", "[视频]" + paramBaseArticleInfo.mTitle);
      localBundle.putString("forward_ark_app_meta", a.a(paramBaseArticleInfo, false));
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoStructMsgHelper", 2, "FORWARD_ARK_APP_VER: " + localBundle.getString("forward_ark_app_ver"));
    }
    return localBundle;
  }
  
  @NotNull
  public final Bundle a(@Nullable JSONObject paramJSONObject)
  {
    Bundle localBundle = new Bundle();
    if (paramJSONObject != null)
    {
      localBundle.putInt("forward_type", paramJSONObject.optInt("forward_type"));
      localBundle.putString("forward_ark_app_name", paramJSONObject.optString("forward_ark_app_name"));
      localBundle.putString("forward_ark_app_view", paramJSONObject.optString("forward_ark_app_view"));
      localBundle.putString("forward_ark_app_ver", paramJSONObject.optString("forward_ark_app_ver"));
      localBundle.putString("forward_ark_app_prompt", paramJSONObject.optString("forward_ark_app_prompt"));
      localBundle.putString("forward_ark_app_meta", paramJSONObject.optString("forward_ark_app_meta"));
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoStructMsgHelper", 2, "FORWARD_ARK_APP_VER: " + localBundle.getString("forward_ark_app_ver", ""));
    }
    return localBundle;
  }
  
  @NotNull
  public final JSONObject a(@Nullable BaseArticleInfo paramBaseArticleInfo)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramBaseArticleInfo != null)
    {
      localJSONObject.put("forward_type", 27);
      localJSONObject.put("forward_ark_app_name", "com.tencent.biz.pubaccount.readinjoy");
      localJSONObject.put("forward_ark_app_view", "baseView");
      localJSONObject.put("forward_ark_app_ver", Aladdin.getConfig(415).getString("ark_app_ver", "1.0.0.66"));
      localJSONObject.put("forward_ark_app_prompt", "[视频]" + paramBaseArticleInfo.mTitle);
      localJSONObject.put("forward_ark_app_meta", a.a(paramBaseArticleInfo, true));
    }
    if (QLog.isColorLevel()) {
      QLog.d("VideoStructMsgHelper", 2, "FORWARD_ARK_APP_VER: " + localJSONObject.optString("forward_ark_app_ver"));
    }
    return localJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.video.VideoStructMsgHelper
 * JD-Core Version:    0.7.0.1
 */
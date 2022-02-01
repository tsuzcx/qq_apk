package com.tencent.biz.pubaccount.readinjoy.viola;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import androidx.annotation.VisibleForTesting;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.common.offline.HtmlOffline;
import com.tencent.biz.common.offline.OfflineEnvHelper;
import com.tencent.biz.pubaccount.readinjoy.comment.data.AnchorData;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.MultiVideoConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.ViolaVideoFeedsConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyWebRenderEngine;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyViolaChannelFragment;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsPlayActivity;
import com.tencent.biz.pubaccount.readinjoy.video.multivideo.MultiVideoHelper;
import com.tencent.biz.pubaccount.readinjoy.viola.delegate.ViolaUiDelegate;
import com.tencent.biz.pubaccount.readinjoy.viola.so.ViolaSoLoaderManager;
import com.tencent.biz.pubaccount.readinjoy.viola.so.ViolaSoLoaderManager.Companion;
import com.tencent.biz.pubaccount.readinjoy.viola.utils.ViolaBizUtils;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.LoadAsyBack;
import com.tencent.biz.pubaccount.readinjoy.viola.wormhole.NativeVueLoaderManager;
import com.tencent.common.config.AppSetting;
import com.tencent.hippy.qq.update.HippyQQLibraryManager;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webview.swift.utils.SwiftOfflineDataUtils;
import com.tencent.mobileqq.webview.swift.utils.SwiftOfflineDataUtils.OfflineData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import com.tencent.viola.core.ViolaSDKEngine;
import com.tencent.viola.ui.dom.style.FlexConvertUtils;
import com.tencent.viola.utils.ViolaUtils;
import cooperation.readinjoy.ReadInJoyHelper;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Iterator;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.manager.TicketManager;
import org.json.JSONException;
import org.json.JSONObject;

public class ViolaAccessHelper
{
  public static int a;
  public static long a;
  public static String a;
  public static Map<String, String> a;
  public static boolean a;
  private static int jdField_b_of_type_Int = 1;
  private static final String jdField_b_of_type_JavaLangString;
  
  static
  {
    jdField_a_of_type_Int = 0;
    jdField_a_of_type_Long = 0L;
    jdField_a_of_type_Boolean = false;
    jdField_b_of_type_JavaLangString = "QQ/8.5.5 Android/0.17 Android/" + Build.VERSION.RELEASE;
  }
  
  public static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 2: 
    default: 
      return -1;
    case 1: 
    case 5: 
      return 24;
    case 3: 
      return 27;
    }
    return 33;
  }
  
  private static Intent a(Context paramContext, String paramString1, Bundle paramBundle, boolean paramBoolean, String paramString2)
  {
    Intent localIntent = new Intent();
    if (a(paramBundle))
    {
      localIntent.putExtra("url", paramString2);
      localIntent.addFlags(268435456);
      localIntent.putExtra(ViolaUiDelegate.jdField_a_of_type_JavaLangString, paramString1);
      localIntent.putExtra("useTransParentFragment", paramBoolean);
      if (paramBundle != null)
      {
        localIntent.putExtras(paramBundle);
        if (paramBundle.containsKey(ViolaFragment.BUNDLE_PAGE_CONFIG_DATA)) {
          localIntent.putExtra(ViolaFragment.BUNDLE_PAGE_CONFIG_DATA, paramBundle.getString(ViolaFragment.BUNDLE_PAGE_CONFIG_DATA));
        }
        if (paramBundle.containsKey("param")) {
          localIntent.putExtra("param", paramBundle.getString("param"));
        }
      }
      return localIntent;
    }
    paramString2 = new StringBuilder().append(paramString2);
    if ((paramContext instanceof SplashActivity)) {}
    for (paramContext = "&from_splash_activity=1";; paramContext = "&from_splash_activity=0")
    {
      localIntent.putExtra("url", paramContext);
      break;
    }
  }
  
  private static Intent a(Context paramContext, JSONObject paramJSONObject)
  {
    JSONObject localJSONObject = paramJSONObject.optJSONObject("video_card");
    if (localJSONObject == null) {
      paramContext = null;
    }
    Intent localIntent;
    String str;
    do
    {
      do
      {
        return paramContext;
        localIntent = new Intent(paramContext, VideoFeedsPlayActivity.class);
        localIntent.putExtra("is_from_viola", paramJSONObject.optString("from_viola"));
        paramContext = paramJSONObject.optString("isFromWeishiDiscover");
        str = paramJSONObject.optString("isWeishiSource");
        if (!"1".equals(paramContext)) {
          break;
        }
        localIntent.putExtra("VIDEO_FROM_TYPE", 20);
        localIntent.putExtra("key_source", 5);
        localIntent.putExtra("VIDEO_COMMON_DATA", localJSONObject.optString("common_data_24"));
        if (!TextUtils.isEmpty(localJSONObject.optString("topic_id_18"))) {
          localIntent.putExtra("VIDEO_FROM_POLYMERIC_TOPIC_ID", Long.valueOf(localJSONObject.optString("topic_id_18")));
        }
        localIntent.putExtra("VIDEO_VID", localJSONObject.optString("vid_19"));
        localIntent.putExtra("VIDEO_ARTICLE_ID", localJSONObject.optString("article_id_8"));
        localIntent.putExtra("VIDEO_PUB_ACCOUNT_UIN", localJSONObject.optString("subscribe_id_6"));
        localIntent.putExtra("VIDEO_PUB_ACCOUNT_NAME", localJSONObject.optString("subscribe_name_7"));
        localIntent.putExtra("VIDEO_THIRD_ACTION", localJSONObject.optString("third_action_20"));
        localIntent.putExtra("VIDEO_THIRD_ICON", localJSONObject.optString("third_icon_url_21"));
        localIntent.putExtra("VIDEO_THIRD_NAME", localJSONObject.optString("third_uin_name_22"));
        localIntent.putExtra("VIDEO_TITLE", localJSONObject.optString("article_title_9"));
        localIntent.putExtra("VIDEO_SUMMARY", localJSONObject.optString("article_summary_10"));
        localIntent.putExtra("VIDEO_COVER", localJSONObject.optString("cover_url_2"));
        localIntent.putExtra("VIDEO_URL", localJSONObject.optString("video_url_23"));
        localIntent.putExtra("VIDEO_WIDTH", localJSONObject.optString("width_25"));
        localIntent.putExtra("VIDEO_HEIGHT", localJSONObject.optString("height_26"));
        localIntent.putExtra("VIDEO_TIME", localJSONObject.optString("duration_27"));
        if (!TextUtils.isEmpty(localJSONObject.optString("busiType_28"))) {
          localIntent.putExtra("VIDEO_ARTICLE_BUSITYPE", Integer.valueOf(localJSONObject.optString("busiType_28")));
        }
        if (!TextUtils.isEmpty(localJSONObject.optString("feeds_type_4"))) {
          localIntent.putExtra("VIDEO_FEED_TYPE", Integer.valueOf(localJSONObject.optString("feeds_type_4")));
        }
        if (!TextUtils.isEmpty(localJSONObject.optString("feeds_id_3"))) {
          localIntent.putExtra("VIDEO_FEED_ID", Long.valueOf(localJSONObject.optString("feeds_id_3")));
        }
        if (!TextUtils.isEmpty(localJSONObject.optString("xg_file_size_29"))) {
          localIntent.putExtra("VIDEO_XG_FILE_SIZE", Long.valueOf(localJSONObject.optString("xg_file_size_29")));
        }
        paramJSONObject = paramJSONObject.optJSONObject("from_frame");
        paramContext = localIntent;
      } while (paramJSONObject == null);
      if (!TextUtils.isEmpty(paramJSONObject.optString("x"))) {
        localIntent.putExtra("item_x", Integer.valueOf(paramJSONObject.optString("x")));
      }
      if (!TextUtils.isEmpty(paramJSONObject.optString("y"))) {
        localIntent.putExtra("item_y", Integer.valueOf(paramJSONObject.optString("y")));
      }
      if (!TextUtils.isEmpty(paramJSONObject.optString("height"))) {
        localIntent.putExtra("item_height", Integer.valueOf(paramJSONObject.optString("height")));
      }
      paramContext = localIntent;
    } while (TextUtils.isEmpty(paramJSONObject.optString("width")));
    localIntent.putExtra("item_width", Integer.valueOf(paramJSONObject.optString("width")));
    return localIntent;
    if ("1".equals(str)) {
      localIntent.putExtra("VIDEO_FROM_TYPE", 23);
    }
    for (;;)
    {
      localIntent.putExtra("key_source", 4);
      break;
      localIntent.putExtra("VIDEO_FROM_TYPE", 18);
    }
  }
  
  private static Bundle a(Context paramContext, JSONObject paramJSONObject)
  {
    if ((paramContext == null) || (paramJSONObject == null)) {
      return null;
    }
    Bundle localBundle = new Bundle();
    paramContext = paramJSONObject.optString("innerUniqueID");
    String str1 = paramJSONObject.optString("busitype");
    String str2 = paramJSONObject.optString("video_vid");
    Object localObject = paramJSONObject.optString("video_width");
    String str3 = paramJSONObject.optString("video_height");
    String str4 = paramJSONObject.optString("video_duration");
    String str5 = paramJSONObject.optString("video_from_type");
    String str6 = paramJSONObject.optString("title");
    String str7 = paramJSONObject.optString("video_cover");
    String str8 = paramJSONObject.optString("share_url");
    String str9 = paramJSONObject.optString("account_name");
    String str10 = paramJSONObject.optString("account_uin");
    String str11 = paramJSONObject.optString("video_create_time");
    String str12 = paramJSONObject.optString("third_icon_url");
    String str13 = paramJSONObject.optString("third_name");
    String str14 = paramJSONObject.optString("third_jump_url");
    String str15 = paramJSONObject.optString("biudata");
    String str16 = paramJSONObject.optString("commondata");
    int i = paramJSONObject.optInt("from_viola", 0);
    String str17 = paramJSONObject.optString("video_url");
    int j = paramJSONObject.optInt("channel_id", -1);
    JSONObject localJSONObject = paramJSONObject.optJSONObject("from_frame");
    localBundle.putString("VIDEO_ARTICLE_ID", paramContext);
    if (!TextUtils.isEmpty(str1)) {
      localBundle.putInt("VIDEO_ARTICLE_BUSITYPE", Integer.valueOf(str1).intValue());
    }
    localBundle.putString("VIDEO_VID", str2);
    if (!TextUtils.isEmpty(str5)) {
      localBundle.putInt("VIDEO_FROM_TYPE", Integer.valueOf(str5).intValue());
    }
    localBundle.putString("VIDEO_WIDTH", (String)localObject);
    localBundle.putString("VIDEO_HEIGHT", str3);
    localBundle.putString("VIDEO_TIME", str4);
    localBundle.putString("VIDEO_TITLE", str6);
    localBundle.putString("VIDEO_COVER", str7);
    localBundle.putString("VIDEO_H5_URL", str8);
    localBundle.putString("VIDEO_PUB_ACCOUNT_NAME", str9);
    localBundle.putString("VIDEO_PUB_ACCOUNT_UIN", str10);
    localBundle.putString("VIDEO_CREATE_TIME", str11);
    localBundle.putString("VIDEO_THIRD_ICON", str12);
    localBundle.putString("VIDEO_THIRD_NAME", str13);
    localBundle.putString("VIDEO_THIRD_ACTION", str14);
    localBundle.putString("VIDEO_COMMON_DATA", str16);
    localBundle.putString("VIDEO_ARTICLE_INFO_FOR_BIU", str15);
    localBundle.putString("is_from_viola", String.valueOf(i));
    localBundle.putString("VIDEO_URL", str17);
    if (localJSONObject != null)
    {
      if (!TextUtils.isEmpty(localJSONObject.optString("x"))) {
        localBundle.putInt("item_x", (int)FlexConvertUtils.getFloatByViewport(localJSONObject.optString("x"), 750));
      }
      if (!TextUtils.isEmpty(localJSONObject.optString("y"))) {
        localBundle.putInt("item_y", (int)FlexConvertUtils.getFloatByViewport(localJSONObject.optString("y"), 750));
      }
      if (!TextUtils.isEmpty(localJSONObject.optString("height"))) {
        localBundle.putInt("item_height", (int)FlexConvertUtils.getFloatByViewport(localJSONObject.optString("height"), 750));
      }
      if (!TextUtils.isEmpty(localJSONObject.optString("width"))) {
        localBundle.putInt("item_width", (int)FlexConvertUtils.getFloatByViewport(localJSONObject.optString("width"), 750));
      }
    }
    if (!TextUtils.isEmpty(paramJSONObject.optString("commentId", null)))
    {
      paramContext = paramJSONObject.optString("commentId", null);
      if (!TextUtils.isEmpty(paramContext))
      {
        if (TextUtils.isEmpty(paramJSONObject.optString("subCommentId", null))) {
          break label761;
        }
        str1 = paramJSONObject.optString("subCommentId", null);
        label625:
        if (TextUtils.isEmpty(paramJSONObject.optString("jumpCommentType", null))) {
          break label774;
        }
        str2 = paramJSONObject.optString("jumpCommentType", null);
        label649:
        if (TextUtils.isEmpty(paramJSONObject.optString("isAwesome", null))) {
          break label787;
        }
      }
    }
    label774:
    label787:
    for (paramJSONObject = paramJSONObject.optString("isAwesome", null);; paramJSONObject = paramJSONObject.optString("isawesome", null))
    {
      localObject = new AnchorData();
      ((AnchorData)localObject).jdField_a_of_type_JavaLangString = paramContext;
      ((AnchorData)localObject).jdField_b_of_type_JavaLangString = str1;
      ((AnchorData)localObject).jdField_b_of_type_Boolean = "0".equals(str2);
      ((AnchorData)localObject).jdField_a_of_type_Boolean = "1".equals(paramJSONObject);
      localBundle.putBoolean("VIDEO_SHOW_COMMENT", true);
      localBundle.putParcelable("VIDEO_COMMENT_ANCHOR", (Parcelable)localObject);
      localBundle.putInt("REPORT_VIDEO_FEEDS_CHANNEL_ID", j);
      return localBundle;
      paramContext = paramJSONObject.optString("commentid", null);
      break;
      label761:
      str1 = paramJSONObject.optString("subcommentid", null);
      break label625;
      str2 = paramJSONObject.optString("jumpcommenttype", null);
      break label649;
    }
  }
  
  private static Bundle a(String paramString)
  {
    int i = 0;
    Bundle localBundle = new Bundle();
    if (paramString == null) {
      return localBundle;
    }
    int j = paramString.indexOf('?');
    if ((j < 0) || (j + 1 >= paramString.length())) {
      return localBundle;
    }
    paramString = paramString.substring(j + 1);
    if (TextUtils.isEmpty(paramString)) {
      return localBundle;
    }
    paramString = paramString.split("&");
    for (;;)
    {
      if ((paramString != null) && (i < paramString.length))
      {
        String[] arrayOfString = paramString[i].split("=");
        if ((arrayOfString != null) && (arrayOfString.length == 2)) {}
        try
        {
          localBundle.putString(arrayOfString[0], URLDecoder.decode(arrayOfString[1], "UTF-8"));
          i += 1;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          for (;;)
          {
            localUnsupportedEncodingException.printStackTrace();
          }
        }
      }
    }
    return localBundle;
  }
  
  public static Fragment a(Context paramContext, String paramString, Bundle paramBundle)
  {
    paramContext = a(paramContext, "", paramBundle, false, a(paramString));
    paramBundle = new ReadInJoyViolaChannelFragment();
    paramBundle.setArguments(paramContext.getExtras());
    paramBundle.a(paramString);
    return paramBundle;
  }
  
  public static String a()
  {
    return ViolaVideoFeedsConfigHandler.a();
  }
  
  public static String a(int paramInt)
  {
    if (paramInt == 41725) {
      return "https://viola.qq.com/js/VideoAccountFeeds.js?_rij_violaUrl=1&v_tid=15&v_bundleName=VideoAccountFeeds&hideNav=1&statusColor=1&v_bid=3811&_cache_bunle=1&v_nav_immer=1";
    }
    return "https://viola.qq.com/js/VShortVideo.js?_rij_violaUrl=1&v_tid=15&v_bundleName=VShortVideo&hideNav=1&v_nav_immer=1&statusColor=1&v_bid=3811&statusBarStyle=1&_cache_bunle=1&v_bg_color=000000&v_content_full=1&statusColor=1&supportNV=1&supportColorBall=1&v_present_title_alpha=1&v_present_gray_float=1&v_present_top=123";
  }
  
  @VisibleForTesting
  protected static String a(Bundle paramBundle, String paramString)
  {
    Object localObject1 = paramString;
    if (paramBundle.containsKey("floating_window_rowkey")) {
      localObject1 = paramString + "&rowkey=" + paramBundle.getString("floating_window_rowkey");
    }
    paramString = (String)localObject1;
    if (paramBundle.containsKey("float_layer_topic_id")) {
      paramString = (String)localObject1 + "&topicId=" + paramBundle.getString("float_layer_topic_id");
    }
    localObject1 = paramString;
    boolean bool;
    label188:
    Object localObject2;
    if (paramBundle.containsKey("scroll_to_top"))
    {
      bool = paramBundle.getBoolean("scroll_to_top", false);
      localObject1 = new StringBuilder().append(paramString);
      if (bool)
      {
        paramString = "&v_present_auto_top=1";
        localObject1 = paramString;
      }
    }
    else
    {
      paramString = (String)localObject1;
      if (paramBundle.containsKey("up_animation"))
      {
        bool = paramBundle.getBoolean("up_animation", false);
        localObject1 = new StringBuilder().append((String)localObject1);
        if (!bool) {
          break label585;
        }
        paramString = "&v_present_pop=1";
        paramString = paramString;
      }
      localObject2 = paramString;
      if (paramBundle.containsKey("margin_top"))
      {
        localObject1 = paramBundle.getString("margin_top", null);
        localObject2 = paramString;
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          localObject2 = paramString;
          if (!"null".equals(localObject1)) {
            localObject2 = paramString + "&v_present_top=" + paramBundle.getString("margin_top");
          }
        }
      }
      localObject1 = localObject2;
      if (paramBundle.containsKey("gray_bar"))
      {
        bool = paramBundle.getBoolean("gray_bar", false);
        localObject1 = new StringBuilder().append((String)localObject2);
        if (!bool) {
          break label592;
        }
      }
    }
    label585:
    label592:
    for (paramString = "&v_present_back_bar=1";; paramString = "&v_present_back_bar=0")
    {
      localObject1 = paramString;
      paramString = (String)localObject1;
      if (paramBundle.containsKey("floating_bundle_extra_data"))
      {
        localObject2 = paramBundle.getBundle("floating_bundle_extra_data");
        paramString = (String)localObject1;
        if (localObject2 != null)
        {
          paramString = (String)localObject1;
          if (((Bundle)localObject2).containsKey("VIDEO_H5_URL"))
          {
            localObject2 = ((Bundle)localObject2).getString("VIDEO_H5_URL", "");
            paramString = (String)localObject1;
            if (!TextUtils.isEmpty((CharSequence)localObject2))
            {
              paramString = (String)localObject1;
              if (((String)localObject2).contains("redpackid")) {
                paramString = (String)localObject1 + "&redpackid=" + Uri.parse((String)localObject2).getQueryParameter("redpackid");
              }
            }
          }
        }
      }
      localObject1 = paramString;
      if (paramBundle.containsKey("floating_window_scene"))
      {
        int i = paramBundle.getInt("floating_window_scene", 0);
        localObject1 = paramString;
        if (i == 4) {
          localObject1 = paramString + "&v_present_interrupt_back=1";
        }
        localObject1 = (String)localObject1 + "&presentFrom=" + i;
      }
      paramString = (String)localObject1;
      if (paramBundle.containsKey("REPORT_VIDEO_FEEDS_CHANNEL_ID")) {
        paramString = (String)localObject1 + "&channelId=" + paramBundle.getInt("REPORT_VIDEO_FEEDS_CHANNEL_ID");
      }
      return paramString;
      paramString = "&v_present_auto_top=0";
      break;
      paramString = "&v_present_pop=0";
      break label188;
    }
  }
  
  public static String a(String paramString)
  {
    String str1 = paramString;
    try
    {
      if (paramString.contains("v_bid_min_version"))
      {
        String str3 = Uri.parse(paramString).getQueryParameter("v_bid");
        String str2 = Uri.parse(paramString).getQueryParameter("v_bid_min_version");
        str1 = paramString;
        if (!TextUtils.isEmpty(str3))
        {
          str1 = paramString;
          if (!TextUtils.isEmpty(str2))
          {
            str3 = HtmlOffline.a(str3);
            str1 = paramString;
            if (!TextUtils.isEmpty(str3))
            {
              str1 = paramString;
              if (Integer.valueOf(str3).intValue() < Integer.valueOf(str2).intValue()) {
                str1 = paramString + "&v_bid_apply_anywhere=0";
              }
            }
          }
        }
      }
      return str1;
    }
    catch (Exception localException)
    {
      QLog.e("ViolaAccessHelper", 2, "startViolaPage error " + localException.getMessage());
    }
    return paramString;
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString1 = a(paramString1);
      if (paramString1.containsKey(paramString2))
      {
        paramString1 = paramString1.getString(paramString2);
        if (!TextUtils.isEmpty(paramString1)) {
          return paramString1;
        }
        return null;
      }
    }
    return null;
  }
  
  private static String a(String paramString1, String paramString2, boolean paramBoolean)
  {
    localObject1 = paramString1;
    if (!TextUtils.isEmpty(paramString1)) {}
    try
    {
      localObject1 = new StringBuilder(paramString1);
      if (URLUtil.a(paramString1).size() <= 0) {
        break label215;
      }
      i = 1;
    }
    catch (JSONException paramString2)
    {
      for (;;)
      {
        JSONObject localJSONObject;
        Iterator localIterator;
        QLog.d("ViolaAccessHelper", 1, paramString2.getMessage());
        localObject1 = paramString1;
        continue;
        int i = 0;
        continue;
        paramString2 = "?";
        continue;
        int j = i;
        if (paramBoolean) {
          if (j != 0) {
            paramString2 = "&";
          }
        }
      }
    }
    j = i;
    if (!TextUtils.isEmpty(paramString2))
    {
      localJSONObject = new JSONObject(paramString2);
      localIterator = localJSONObject.keys();
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label227;
        }
        String str = (String)localIterator.next();
        Object localObject2 = localJSONObject.opt(str);
        if (i == 0) {
          break;
        }
        paramString2 = "&";
        ((StringBuilder)localObject1).append(paramString2).append(str).append("=").append(localObject2);
        i = 1;
      }
      for (;;)
      {
        ((StringBuilder)localObject1).append(paramString2).append("refreshForUGCUpload").append("=").append("1");
        localObject1 = ((StringBuilder)localObject1).toString();
        QLog.d("ViolaAccessHelper", 1, "addParams viola url: " + (String)localObject1);
        return localObject1;
        paramString2 = "?";
      }
    }
  }
  
  public static String a(AppRuntime paramAppRuntime)
  {
    if (ReadInJoyHelper.m(paramAppRuntime)) {
      return "https://viola.qq.com/js/messageBox.js?_rij_violaUrl=1&v_tid=2&v_bundleName=messageBox&statusColor=1&support_night=1&hideNav=1&v_nav_immer=1";
    }
    return "https://viola.qq.com/js/messageBox.js?_rij_violaUrl=1&v_tid=6&v_bundleName=messageBox&v_bid=3740&statusColor=1&support_night=1&hideNav=1&v_nav_immer=1";
  }
  
  public static JSONObject a()
  {
    Object localObject = (QQAppInterface)ReadInJoyUtils.a();
    if (localObject == null) {
      return null;
    }
    try
    {
      JSONObject localJSONObject = new JSONObject();
      TicketManager localTicketManager = (TicketManager)((QQAppInterface)localObject).getManager(2);
      String str = ((QQAppInterface)localObject).getAccount();
      localObject = localTicketManager.getSkey(((QQAppInterface)localObject).getCurrentAccountUin());
      localJSONObject.put("Cookie", "uin=o" + str + "; skey=" + (String)localObject);
      localJSONObject.put("User-Agent", jdField_b_of_type_JavaLangString);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ViolaAccessHelper", 2, "getBaseInitData JSONException e" + localJSONException.getMessage());
      }
    }
    return null;
  }
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ViolaAccessHelper", 2, "preInit");
    }
    if (TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) {
      jdField_a_of_type_JavaLangString = ReadInJoyUtils.a();
    }
    HippyQQLibraryManager.getInstance().preDownload();
    NativeVueLoaderManager.a().b();
    c();
    if (ViolaSDKEngine.isInitialized()) {
      return;
    }
    ThreadManager.post(new ViolaAccessHelper.1(), 8, null, true);
  }
  
  public static void a(Context paramContext, int paramInt, Bundle paramBundle)
  {
    String str;
    int i;
    Object localObject;
    int j;
    switch (paramInt)
    {
    default: 
      str = "";
      i = 0;
      str = a(paramBundle, str + "&v_present=2");
      if (paramBundle.containsKey("floating_window_scene")) {
        i = paramBundle.getInt("floating_window_scene", 0);
      }
      if (paramInt == 2)
      {
        localObject = new Intent();
        ((Intent)localObject).putExtra("VIDEO_FROM_TYPE", a(i));
        ((Intent)localObject).putExtras(paramBundle);
        MultiVideoHelper.a(paramContext, (Intent)localObject, str);
        return;
      }
      break;
    case 2: 
      str = "https://viola.qq.com/js/VShortVideo.js?_rij_violaUrl=1&v_tid=15&v_bundleName=VShortVideo&hideNav=1&v_nav_immer=1&statusColor=1&v_bid=3811&statusBarStyle=1&_cache_bunle=1&v_bg_color=000000&v_content_full=1&statusColor=1&supportNV=1&supportColorBall=1&v_present_title_alpha=1&v_present_gray_float=1&v_present_top=123";
      localObject = new JSONObject();
      if (paramBundle.containsKey("floating_window_scene"))
      {
        j = paramBundle.getInt("floating_window_scene", 0);
        i = j;
        if (j != 3) {
          break;
        }
      }
      break;
    }
    for (;;)
    {
      try
      {
        ((JSONObject)localObject).put("autoPlayDisable", ReadInJoyHelper.i());
        i = j;
      }
      catch (JSONException localJSONException)
      {
        localJSONException.printStackTrace();
        i = j;
        continue;
      }
      paramBundle.putString("param", ((JSONObject)localObject).toString());
      break;
      str = "https://viola.qq.com/js/shortPGC.js?_rij_violaUrl=1&v_tid=15&v_bundleName=shortPGC&hideNav=1&v_nav_immer=1&v_bid=3811&v_present_titleHeight=44";
      i = 0;
      break;
      str = "https://viola.qq.com/js/columnDetail.js?_rij_violaUrl=1&v_tid=6&v_bundleName=columnDetail&v_bid=3740&hideNav=1&statusColor=1&v_present_titleHeight=44&v_nav_immer=1";
      i = 0;
      break;
      a(paramContext, "", str, paramBundle, false);
      return;
      i = 0;
    }
  }
  
  private static void a(Context paramContext, String paramString) {}
  
  public static void a(Context paramContext, String paramString, ViolaAccessHelper.ViolaSdkPermitlistener paramViolaSdkPermitlistener) {}
  
  public static void a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
  {
    a(paramContext, paramString1, paramString2, paramBundle, false);
  }
  
  @Deprecated
  public static void a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle, ViolaAccessHelper.ViolaSdkPermitlistener paramViolaSdkPermitlistener)
  {
    if (!a(paramContext)) {
      if (paramViolaSdkPermitlistener != null) {
        paramViolaSdkPermitlistener.a();
      }
    }
    do
    {
      String str;
      do
      {
        do
        {
          return;
          if ((paramString2.contains("v_tid")) && (paramString2.contains("v_bundleName")))
          {
            b(paramContext, paramString1, paramString2, paramBundle);
            return;
          }
          if (!TextUtils.isEmpty(Uri.parse(paramString2).getQueryParameter("v_bid"))) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ViolaAccessHelper", 4, "openViolaPageWithOffline businessId is empty,url = " + paramString2);
          }
        } while (paramViolaSdkPermitlistener == null);
        paramViolaSdkPermitlistener.a();
        return;
        str = ViolaBizUtils.b(paramString2);
        if (!TextUtils.isEmpty(str)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ViolaAccessHelper", 4, "openViolaPageWithOffline filePath is empty,url = " + paramString2);
        }
      } while (paramViolaSdkPermitlistener == null);
      paramViolaSdkPermitlistener.a();
      return;
      if (new File(str).exists()) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ViolaAccessHelper", 4, "getResponse local file not exists :" + str);
      }
    } while (paramViolaSdkPermitlistener == null);
    paramViolaSdkPermitlistener.a();
    return;
    b(paramContext, paramString1, paramString2, paramBundle);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, Bundle paramBundle, boolean paramBoolean)
  {
    paramString2 = a(paramString2);
    paramString1 = a(paramContext, paramString1, paramBundle, paramBoolean, paramString2);
    if ((paramString2.contains("v_present=2")) || (paramString2.contains("v_present=1")) || (paramString2.contains("v_push_animated_disable=1")))
    {
      paramString1.putExtra("public_fragment_window_feature", 1);
      if ((paramBundle != null) && (paramBundle.containsKey("requestCode")) && ((paramContext instanceof Activity)))
      {
        PublicFragmentActivity.Launcher.a((Activity)paramContext, paramString1, PublicTransFragmentActivity.class, ViolaFragment.class, paramBundle.getInt("requestCode", -1));
        if ((paramContext instanceof Activity)) {
          ((Activity)paramContext).overridePendingTransition(0, 0);
        }
      }
    }
    do
    {
      return;
      PublicFragmentActivity.Launcher.a(paramContext, paramString1, PublicTransFragmentActivity.class, ViolaFragment.class);
      break;
      if ((paramBundle != null) && (paramBundle.containsKey("requestCode")) && ((paramContext instanceof Activity)))
      {
        if ((paramBoolean) || (paramString2.contains("v_usetrans=1")))
        {
          paramString1.putExtra("public_fragment_window_feature", 1);
          PublicFragmentActivity.Launcher.a((Activity)paramContext, paramString1, PublicTransFragmentActivity.class, ViolaFragment.class, paramBundle.getInt("requestCode", -1));
          ((Activity)paramContext).overridePendingTransition(2130772014, 0);
          return;
        }
        PublicFragmentActivity.a((Activity)paramContext, paramString1, ViolaFragment.class, paramBundle.getInt("requestCode", -1));
        return;
      }
      if ((!paramBoolean) && (!paramString2.contains("v_usetrans=1"))) {
        break label276;
      }
      paramString1.putExtra("public_fragment_window_feature", 1);
      PublicFragmentActivity.Launcher.a(paramContext, paramString1, PublicTransFragmentActivity.class, ViolaFragment.class);
    } while (!(paramContext instanceof Activity));
    ((Activity)paramContext).overridePendingTransition(2130772014, 0);
    return;
    label276:
    PublicFragmentActivity.a(paramContext, paramString1, ViolaFragment.class);
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString2))
    {
      Bundle localBundle = new Bundle();
      a(paramContext, "", a(paramString2, paramString1, paramBoolean), localBundle, false);
    }
  }
  
  public static void a(Context paramContext, JSONObject paramJSONObject)
  {
    if ((paramJSONObject == null) || (paramContext == null)) {}
    do
    {
      return;
      try
      {
        String str = paramJSONObject.optString("from_type");
        if (TextUtils.isEmpty(str)) {
          break;
        }
        a(str, paramJSONObject, paramContext);
        return;
      }
      catch (Exception paramContext) {}
    } while (!QLog.isColorLevel());
    QLog.d("ViolaAccessHelper", 2, "openVideo jsonobject is: " + paramJSONObject.toString() + "  error :" + paramContext.getMessage());
    return;
    b(paramContext, paramJSONObject);
  }
  
  /* Error */
  public static void a(com.tencent.common.app.AppInterface paramAppInterface, String paramString, com.tencent.biz.pubaccount.readinjoy.viola.adapter.ViolaReportDelegate paramViolaReportDelegate, ViolaAccessHelper.SDKInitCallback paramSDKInitCallback)
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: invokestatic 667	com/tencent/viola/core/ViolaSDKEngine:isInitialized	()Z
    //   6: ifne +98 -> 104
    //   9: new 795	com/tencent/viola/core/InitConfig$Builder
    //   12: dup
    //   13: invokespecial 796	com/tencent/viola/core/InitConfig$Builder:<init>	()V
    //   16: iconst_1
    //   17: invokevirtual 800	com/tencent/viola/core/InitConfig$Builder:setBusinessId	(I)Lcom/tencent/viola/core/InitConfig$Builder;
    //   20: aload_1
    //   21: invokevirtual 804	com/tencent/viola/core/InitConfig$Builder:setFramework	(Ljava/lang/String;)Lcom/tencent/viola/core/InitConfig$Builder;
    //   24: new 806	com/tencent/biz/pubaccount/readinjoy/viola/adapter/BaseHttpAdapter
    //   27: dup
    //   28: invokespecial 807	com/tencent/biz/pubaccount/readinjoy/viola/adapter/BaseHttpAdapter:<init>	()V
    //   31: invokevirtual 811	com/tencent/viola/core/InitConfig$Builder:setHttpAdapter	(Lcom/tencent/viola/adapter/IHttpAdapter;)Lcom/tencent/viola/core/InitConfig$Builder;
    //   34: new 813	com/tencent/biz/pubaccount/readinjoy/viola/adapter/ui/ComponentAdapter
    //   37: dup
    //   38: invokespecial 814	com/tencent/biz/pubaccount/readinjoy/viola/adapter/ui/ComponentAdapter:<init>	()V
    //   41: invokevirtual 818	com/tencent/viola/core/InitConfig$Builder:setComponentAdapter	(Lcom/tencent/viola/adapter/VComponentAdapter;)Lcom/tencent/viola/core/InitConfig$Builder;
    //   44: aload_2
    //   45: invokevirtual 822	com/tencent/viola/core/InitConfig$Builder:setReportDelegate	(Lcom/tencent/viola/commons/IReportDelegate;)Lcom/tencent/viola/core/InitConfig$Builder;
    //   48: new 824	com/tencent/biz/pubaccount/readinjoy/viola/adapter/ViolaLogAdapter
    //   51: dup
    //   52: invokespecial 825	com/tencent/biz/pubaccount/readinjoy/viola/adapter/ViolaLogAdapter:<init>	()V
    //   55: invokevirtual 829	com/tencent/viola/core/InitConfig$Builder:setLogAdapter	(Lcom/tencent/viola/adapter/ILogAdapter;)Lcom/tencent/viola/core/InitConfig$Builder;
    //   58: astore 5
    //   60: aload_0
    //   61: ifnull +37 -> 98
    //   64: aload_0
    //   65: invokevirtual 835	com/tencent/common/app/AppInterface:getApplication	()Lmqq/app/MobileQQ;
    //   68: astore 4
    //   70: aload 4
    //   72: aload 5
    //   74: invokevirtual 839	com/tencent/viola/core/InitConfig$Builder:build	()Lcom/tencent/viola/core/InitConfig;
    //   77: new 841	com/tencent/biz/pubaccount/readinjoy/viola/ViolaAccessHelper$5
    //   80: dup
    //   81: aload_0
    //   82: aload_3
    //   83: aload_2
    //   84: aload_1
    //   85: invokespecial 844	com/tencent/biz/pubaccount/readinjoy/viola/ViolaAccessHelper$5:<init>	(Lcom/tencent/common/app/AppInterface;Lcom/tencent/biz/pubaccount/readinjoy/viola/ViolaAccessHelper$SDKInitCallback;Lcom/tencent/biz/pubaccount/readinjoy/viola/adapter/ViolaReportDelegate;Ljava/lang/String;)V
    //   88: invokestatic 845	com/tencent/biz/pubaccount/readinjoy/viola/utils/ViolaBizUtils:a	()Ljava/lang/String;
    //   91: invokestatic 849	com/tencent/viola/core/ViolaSDKEngine:initialize	(Landroid/app/Application;Lcom/tencent/viola/core/InitConfig;Lcom/tencent/viola/core/ViolaSDKEngine$InitCallback;Ljava/lang/String;)V
    //   94: ldc 2
    //   96: monitorexit
    //   97: return
    //   98: aconst_null
    //   99: astore 4
    //   101: goto -31 -> 70
    //   104: ldc_w 851
    //   107: ldc_w 853
    //   110: iconst_0
    //   111: invokestatic 857	com/tencent/viola/core/ViolaSDKEngine:registerModule	(Ljava/lang/String;Ljava/lang/Class;Z)Z
    //   114: pop
    //   115: aload_3
    //   116: ifnull -22 -> 94
    //   119: new 859	android/os/Handler
    //   122: dup
    //   123: invokestatic 865	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   126: invokespecial 868	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   129: new 870	com/tencent/biz/pubaccount/readinjoy/viola/ViolaAccessHelper$6
    //   132: dup
    //   133: aload_3
    //   134: invokespecial 873	com/tencent/biz/pubaccount/readinjoy/viola/ViolaAccessHelper$6:<init>	(Lcom/tencent/biz/pubaccount/readinjoy/viola/ViolaAccessHelper$SDKInitCallback;)V
    //   137: invokevirtual 876	android/os/Handler:post	(Ljava/lang/Runnable;)Z
    //   140: pop
    //   141: goto -47 -> 94
    //   144: astore_0
    //   145: invokestatic 637	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   148: ifeq -54 -> 94
    //   151: ldc_w 527
    //   154: iconst_2
    //   155: new 22	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   162: ldc_w 878
    //   165: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   168: aload_0
    //   169: invokevirtual 532	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   172: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   175: invokevirtual 40	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   178: invokestatic 538	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   181: goto -87 -> 94
    //   184: astore_0
    //   185: ldc 2
    //   187: monitorexit
    //   188: aload_0
    //   189: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	190	0	paramAppInterface	com.tencent.common.app.AppInterface
    //   0	190	1	paramString	String
    //   0	190	2	paramViolaReportDelegate	com.tencent.biz.pubaccount.readinjoy.viola.adapter.ViolaReportDelegate
    //   0	190	3	paramSDKInitCallback	ViolaAccessHelper.SDKInitCallback
    //   68	32	4	localMobileQQ	mqq.app.MobileQQ
    //   58	15	5	localBuilder	com.tencent.viola.core.InitConfig.Builder
    // Exception table:
    //   from	to	target	type
    //   104	115	144	java/lang/Exception
    //   119	141	144	java/lang/Exception
    //   3	60	184	finally
    //   64	70	184	finally
    //   70	94	184	finally
    //   104	115	184	finally
    //   119	141	184	finally
    //   145	181	184	finally
  }
  
  public static void a(String paramString)
  {
    ReadInJoyHelper.a("KEY_SP_CHANNEL_FOLLOW_URL", paramString);
  }
  
  @Deprecated
  public static void a(String paramString, ViolaAccessHelper.SDKInitCallback paramSDKInitCallback)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)ReadInJoyUtils.a();
    if ((localQQAppInterface == null) && (paramSDKInitCallback != null))
    {
      paramSDKInitCallback.a();
      return;
    }
    a(localQQAppInterface, paramString, null, paramSDKInitCallback);
  }
  
  public static void a(String paramString, ViolaAccessHelper.ViolaOfflineDownloadListener paramViolaOfflineDownloadListener)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)ReadInJoyUtils.a();
    if ((localQQAppInterface == null) || (TextUtils.isEmpty(paramString)))
    {
      if (paramViolaOfflineDownloadListener != null) {
        paramViolaOfflineDownloadListener.b();
      }
      return;
    }
    ThreadManager.post(new ViolaAccessHelper.4(paramString, localQQAppInterface, paramViolaOfflineDownloadListener, System.currentTimeMillis()), 8, null, true);
  }
  
  public static void a(String paramString, ViolaBaseView.LoadAsyBack paramLoadAsyBack)
  {
    ThreadManager.post(new ViolaAccessHelper.7(paramString, paramLoadAsyBack), 8, null, false);
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (b())
    {
      if (jdField_a_of_type_JavaUtilMap == null) {
        jdField_a_of_type_JavaUtilMap = new ArrayMap();
      }
      jdField_a_of_type_JavaUtilMap.put(e(paramString1), paramString2);
    }
  }
  
  private static void a(String paramString, JSONObject paramJSONObject, Context paramContext)
  {
    if ((!"2".equals(paramString)) || (paramJSONObject == null) || (paramContext == null)) {}
    do
    {
      return;
      paramJSONObject = a(paramContext, paramJSONObject);
    } while (paramJSONObject == null);
    paramString = paramJSONObject.getExtras();
    try
    {
      bool = MultiVideoConfigHandler.a(paramString.getInt("VIDEO_FROM_TYPE", -1), Integer.valueOf(paramString.getString("VIDEO_WIDTH")).intValue(), Integer.valueOf(paramString.getString("VIDEO_HEIGHT")).intValue(), Integer.valueOf(paramString.getString("VIDEO_TIME")).intValue());
      if (bool)
      {
        paramJSONObject = new Intent();
        paramJSONObject.putExtras(paramString);
        MultiVideoHelper.a(paramContext, paramJSONObject);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("ViolaAccessHelper", 1, "[openVideoForDiscover]: " + localException.getMessage());
        boolean bool = false;
      }
      paramContext.startActivity(paramJSONObject);
    }
  }
  
  public static boolean a()
  {
    return ReadInJoyHelper.t(ReadInJoyUtils.a());
  }
  
  public static boolean a(int paramInt)
  {
    return paramInt == 41726;
  }
  
  public static boolean a(int paramInt, Activity paramActivity, String paramString, boolean paramBoolean)
  {
    QLog.d("ViolaAccessHelper", 1, "handleLockScreenJumpViola: " + paramInt + " pushJson: " + paramString + " refresh: " + paramBoolean);
    String str = b(paramInt);
    if (!TextUtils.isEmpty(str))
    {
      QLog.d("ViolaAccessHelper", 1, "has violaUrl: " + str);
      a(paramActivity, paramString, str, paramBoolean);
      QLog.d("ViolaAccessHelper", 1, "jump viola follow channel success");
      return true;
    }
    QLog.d("ViolaAccessHelper", 1, "has no violaUrl");
    return false;
  }
  
  private static boolean a(Context paramContext)
  {
    if (!ReadInJoyWebRenderEngine.a().a()) {
      ReadInJoyWebRenderEngine.a().a();
    }
    if (!Build.CPU_ABI.contains("armeabi"))
    {
      a(paramContext, "cpu架构不支持");
      if (QLog.isColorLevel()) {
        QLog.d("ViolaAccessHelper", 2, "isViolaPermit check cpu config is false");
      }
    }
    do
    {
      String str;
      do
      {
        do
        {
          do
          {
            return false;
            if (a()) {
              break;
            }
            a(paramContext, HardCodeUtil.a(2131716293));
          } while (!QLog.isColorLevel());
          QLog.d("ViolaAccessHelper", 2, "isViolaPermit checkWhiteConfig is false");
          return false;
          if (c()) {
            break;
          }
          a(paramContext, HardCodeUtil.a(2131716295));
        } while (!QLog.isColorLevel());
        QLog.d("ViolaAccessHelper", 2, "isViolaPermit checkSO is false");
        return false;
        str = ViolaBizUtils.b("https://kd.qpic.cn/viola/lib/viola.js?v_bid=3547");
        if (!TextUtils.isEmpty(str)) {
          break;
        }
        a(paramContext, "mainJsPath is empty");
      } while (!QLog.isColorLevel());
      QLog.d("ViolaAccessHelper", 2, "isViolaPermit mainJsPath is empty");
      return false;
      if (new File(str).exists()) {
        break;
      }
      a(paramContext, HardCodeUtil.a(2131716294));
      if (QLog.isColorLevel()) {
        QLog.d("ViolaAccessHelper", 2, "isViolaPermit viola.js is false");
      }
      paramContext = Uri.parse("https://kd.qpic.cn/viola/lib/viola.js?v_bid=3547").getQueryParameter("v_bid");
    } while (TextUtils.isEmpty(paramContext));
    c(paramContext);
    return false;
    return true;
  }
  
  private static boolean a(Bundle paramBundle)
  {
    return (paramBundle != null) && (paramBundle.getBoolean("from_color_note"));
  }
  
  public static boolean a(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && ("1".equals(a(paramString, "_rij_violaUrl")));
  }
  
  public static String b(int paramInt)
  {
    Object localObject1 = Aladdin.get(379).getString("viola_follow_tabs_jump_urls", "");
    if (!TextUtils.isEmpty((CharSequence)localObject1))
    {
      localObject1 = ((String)localObject1).split("\\|");
      if (localObject1.length > 0)
      {
        int j = localObject1.length;
        int i = 0;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            try
            {
              localObject2 = ((String)localObject2).split(",");
              int k = Integer.parseInt(localObject2[0]);
              localObject2 = URLDecoder.decode(localObject2[1]);
              if (k == paramInt) {
                return localObject2;
              }
            }
            catch (Exception localException)
            {
              QLog.d("ViolaAccessHelper", 1, localException.getMessage());
            }
          }
          i += 1;
        }
      }
    }
    return null;
  }
  
  public static String b(String paramString)
  {
    if (AppSetting.g) {}
    Object localObject1;
    for (;;)
    {
      return null;
      if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("http")))
      {
        localObject1 = Uri.parse(paramString).getQueryParameter("v_bid");
        if (!TextUtils.isEmpty((CharSequence)localObject1))
        {
          Object localObject2 = SwiftOfflineDataUtils.a(paramString);
          if ((localObject2 != null) && (!TextUtils.isEmpty(((SwiftOfflineDataUtils.OfflineData)localObject2).jdField_b_of_type_JavaLangString)))
          {
            if (QLog.isColorLevel()) {
              QLog.d("ViolaAccessHelper", 2, "load offline想 data cache on loadRes");
            }
            return ((SwiftOfflineDataUtils.OfflineData)localObject2).jdField_b_of_type_JavaLangString;
          }
          try
          {
            if (!TextUtils.isEmpty((CharSequence)localObject1))
            {
              localObject2 = OfflineEnvHelper.a((String)localObject1);
              if (!TextUtils.isEmpty((CharSequence)localObject2))
              {
                localObject1 = (String)localObject2 + (String)localObject1 + File.separator;
                paramString = HtmlOffline.d(paramString);
                localObject1 = new File((String)localObject1 + paramString);
                if (!((File)localObject1).exists())
                {
                  if (!QLog.isColorLevel()) {
                    continue;
                  }
                  QLog.d("ViolaAccessHelper", 4, "getResponse local file not exists :" + paramString);
                  return null;
                }
              }
            }
          }
          catch (Exception paramString)
          {
            QLog.e("ViolaAccessHelper", 1, "OfflinePlugin shouldInterceptRequest got Exception", paramString);
            return null;
          }
        }
      }
    }
    paramString = ViolaUtils.readFile((File)localObject1);
    return paramString;
  }
  
  public static void b()
  {
    a("https://sqimg.qq.com/qq_product_operations/kan/viola_config/viola_config.json?v_bid=3192", new ViolaAccessHelper.8());
  }
  
  @Deprecated
  private static void b(Context paramContext, String paramString1, String paramString2, Bundle paramBundle)
  {
    a(paramContext, paramString1, paramString2, paramBundle);
  }
  
  private static void b(Context paramContext, JSONObject paramJSONObject)
  {
    Bundle localBundle = a(paramContext, paramJSONObject);
    if (localBundle == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ViolaAccessHelper", 2, "openVideo jsonobject is: " + paramJSONObject.toString() + "  bundle is :" + localBundle.toString());
    }
    paramJSONObject = new Intent(paramContext, VideoFeedsPlayActivity.class);
    try
    {
      bool = MultiVideoConfigHandler.a(localBundle.getInt("VIDEO_FROM_TYPE", -1), Integer.valueOf(localBundle.getString("VIDEO_WIDTH")).intValue(), Integer.valueOf(localBundle.getString("VIDEO_HEIGHT")).intValue(), Integer.valueOf(localBundle.getString("VIDEO_TIME")).intValue());
      if (bool)
      {
        paramJSONObject = new Intent();
        paramJSONObject.putExtras(localBundle);
        MultiVideoHelper.a(paramContext, paramJSONObject);
        return;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("ViolaAccessHelper", 1, "[internalOpenVideo]: " + localException.getMessage());
        boolean bool = false;
      }
      paramJSONObject.putExtras(localBundle);
      paramContext.startActivity(paramJSONObject);
    }
  }
  
  public static boolean b()
  {
    return false;
  }
  
  public static boolean b(int paramInt)
  {
    return paramInt == 41725;
  }
  
  public static boolean b(String paramString)
  {
    boolean bool = true;
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return false;
      }
      if (paramString.contains("viola_share_url"))
      {
        Object localObject = Uri.parse(paramString).getQueryParameter("viola_share_url");
        if (!TextUtils.isEmpty((CharSequence)localObject))
        {
          localObject = URLDecoder.decode((String)localObject);
          if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).contains("_rij_violaUrl=1")))
          {
            localObject = Uri.parse((String)localObject).getQueryParameter("v_minVersion");
            if (TextUtils.isEmpty((CharSequence)localObject)) {
              return true;
            }
            localObject = ((String)localObject).split("\\.");
            String[] arrayOfString = "8.5.5".split("\\.");
            if (Integer.valueOf(localObject[0]).intValue() < Integer.valueOf(arrayOfString[0]).intValue()) {
              return true;
            }
            if ((Integer.valueOf(localObject[0]) == Integer.valueOf(arrayOfString[0])) && (Integer.valueOf(localObject[1]).intValue() < Integer.valueOf(arrayOfString[1]).intValue())) {
              return true;
            }
            if ((Integer.valueOf(localObject[0]) != Integer.valueOf(arrayOfString[0])) || (Integer.valueOf(localObject[1]) != Integer.valueOf(arrayOfString[1])) || (Integer.valueOf(localObject[2]).intValue() > Integer.valueOf(arrayOfString[2]).intValue())) {
              break label275;
            }
            break label273;
          }
        }
      }
      else
      {
        bool = paramString.contains("_rij_violaUrl=1");
        return bool;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ViolaAccessHelper", 2, "isViolaUrlFromWeb error:" + localException.getMessage() + ",webUrl=" + paramString);
      }
    }
    return false;
    for (;;)
    {
      label273:
      return bool;
      label275:
      bool = false;
    }
  }
  
  public static String c(String paramString)
  {
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return null;
      }
      if (paramString.contains("viola_share_url"))
      {
        String str = Uri.parse(paramString).getQueryParameter("viola_share_url");
        if (TextUtils.isEmpty(str)) {
          return null;
        }
        str = URLDecoder.decode(str);
        if (TextUtils.isEmpty(str)) {
          return null;
        }
        if (str.contains("_rij_violaUrl=1")) {
          return ???;
        }
        return null;
      }
      boolean bool = paramString.contains("_rij_violaUrl=1");
      if (!bool) {
        return null;
      }
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ViolaAccessHelper", 2, "getViolaUrlFromWeb error:" + localException.getMessage() + ",webUrl=" + paramString);
      }
      paramString = null;
    }
    return paramString;
    return localException;
  }
  
  private static void c()
  {
    if ((System.currentTimeMillis() - jdField_a_of_type_Long >= 18000000L) || ((!TextUtils.isEmpty(jdField_a_of_type_JavaLangString)) && (!jdField_a_of_type_JavaLangString.equals(ReadInJoyUtils.a()))))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ViolaAccessHelper", 2, "pre load all offline from offline is start");
      }
      a("3192", new ViolaAccessHelper.3());
    }
  }
  
  private static void c(String paramString)
  {
    a(paramString, null);
  }
  
  private static void c(String paramString1, String paramString2)
  {
    if ((a()) && (c()) && (((!TextUtils.isEmpty(paramString1)) && (new File(paramString1).exists())) || (!TextUtils.isEmpty(paramString2)))) {
      try
      {
        if (!TextUtils.isEmpty(paramString2)) {}
        for (;;)
        {
          a(paramString2, new ViolaAccessHelper.2());
          return;
          paramString2 = ViolaUtils.readFile(new File(paramString1));
        }
        return;
      }
      catch (Exception paramString1)
      {
        paramString1.printStackTrace();
      }
    }
  }
  
  private static boolean c()
  {
    return ViolaSoLoaderManager.a.a().a();
  }
  
  public static String d(String paramString)
  {
    if (jdField_a_of_type_JavaUtilMap != null) {
      return (String)jdField_a_of_type_JavaUtilMap.get(e(paramString));
    }
    return null;
  }
  
  public static String e(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.contains("?")) {
        str = paramString.substring(0, paramString.indexOf("?"));
      }
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.ViolaAccessHelper
 * JD-Core Version:    0.7.0.1
 */
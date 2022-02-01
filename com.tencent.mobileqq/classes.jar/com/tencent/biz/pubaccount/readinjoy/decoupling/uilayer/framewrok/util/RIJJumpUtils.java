package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyArticleDetailActivity;
import com.tencent.biz.pubaccount.readinjoy.biuAndCommentMix.RIJBiuAndCommentAladdinUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ProteusSupportUtil;
import com.tencent.biz.pubaccount.readinjoy.common.RIJTabFrameBase;
import com.tencent.biz.pubaccount.readinjoy.common.RIJXTabFrameUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyConstants;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoySrtUtils;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.common.WxShareHelperFromReadInjoy;
import com.tencent.biz.pubaccount.readinjoy.config.handlers.DailyModeConfigHandler;
import com.tencent.biz.pubaccount.readinjoy.decoupling.accesslayer.util.RIJQQAppInterfaceUtil;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.RIJItemViewType;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJKanDianFolderStatus;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertController;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.RIJFeedsDynamicInsertRecordAction.ActionType;
import com.tencent.biz.pubaccount.readinjoy.feedsdynamicinsert.data.RIJFeedsInsertAction;
import com.tencent.biz.pubaccount.readinjoy.feedsinsert.RIJFeedsInsertUtil;
import com.tencent.biz.pubaccount.readinjoy.guidingchannel.ReadInJoyChannelGuidingJumpUtils;
import com.tencent.biz.pubaccount.readinjoy.proteus.utils.PGCShortContentUtils;
import com.tencent.biz.pubaccount.readinjoy.srtUtils.UGRuleManager;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.NewPolymericInfo.PackArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReportInfo.FeedsReportData;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.BiuInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.FeedsInfoUser;
import com.tencent.biz.pubaccount.readinjoy.struct.SocializeFeedsInfo.UGCFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.TopicRecommendFeedsInfo.TopicRecommendInfo;
import com.tencent.biz.pubaccount.readinjoy.video.ReadInJoyWebDataManager;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsHelper;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyBaseAdapter;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.TimeUtil;
import com.tencent.biz.pubaccount.readinjoy.view.widget.RIJUserLevelDialog.DialogClick;
import com.tencent.biz.pubaccount.readinjoy.view.widget.RIJUserLevelDialog.DialogSettingInfo;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaAccessHelper;
import com.tencent.biz.pubaccount.readinjoy.webarticle.RIJWebArticleOptimizeUtil;
import com.tencent.biz.pubaccount.util.PreloadManager;
import com.tencent.biz.pubaccount.util.PreloadManager.ImgStruct;
import com.tencent.biz.pubaccount.util.ReadinjoyReportUtils;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountConfigUtilImpl;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionMainActivity;
import com.tencent.biz.publicAccountImageCollection.PublicAccountImageCollectionUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.JumpActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.FrameHelperActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.api.IMiniAppService;
import com.tencent.mobileqq.mini.api.MiniAppLaunchListener;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pluginsdk.BasePluginActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.utils.Base64Util;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import cooperation.liveroom.LiveRoomProxyActivity;
import cooperation.qzone.util.NetworkState;
import cooperation.readinjoy.ReadInJoyHelper;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0x64e.oidb_cmd0x64e.SRTClickInfo;
import tencent.im.oidb.gallery.galleryFeeds.GalleryFeedsInfo;

public class RIJJumpUtils
{
  public static ArticleInfo a;
  
  private static long a(ArticleInfo paramArticleInfo, int paramInt)
  {
    if ((paramInt == 3) || (paramInt == 5) || (paramInt == 2) || (paramInt == 7))
    {
      if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo != null)) {
        return paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.a.longValue();
      }
    }
    else {
      return paramArticleInfo.mFeedId;
    }
    return 0L;
  }
  
  public static RIJTabFrameBase a(Context paramContext)
  {
    try
    {
      if ((paramContext instanceof SplashActivity))
      {
        paramContext = FrameHelperActivity.a((BaseActivity)paramContext);
        if (paramContext == null) {
          return null;
        }
        paramContext = (RIJTabFrameBase)paramContext.a(RIJXTabFrameUtils.a.a());
        return paramContext;
      }
    }
    catch (RuntimeException paramContext)
    {
      QLog.e("RIJJumpUtils", 1, paramContext, new Object[0]);
    }
    return null;
  }
  
  public static Integer a(Context paramContext, String paramString)
  {
    return a(paramContext, paramString, null, null);
  }
  
  public static Integer a(Context paramContext, String paramString, Bundle paramBundle)
  {
    QLog.d("RIJJumpUtils", 1, "jumpTo: " + paramString + " extraData: " + paramBundle);
    if ((paramContext == null) || (paramString == null)) {
      return Integer.valueOf(-1);
    }
    if ((paramContext instanceof BasePluginActivity))
    {
      localObject = ((BasePluginActivity)paramContext).getOutActivity();
      paramContext = (Context)localObject;
      if (localObject == null) {
        return Integer.valueOf(-1);
      }
    }
    Object localObject = ViolaAccessHelper.c(paramString);
    if ((ViolaAccessHelper.b(paramString)) && (!TextUtils.isEmpty((CharSequence)localObject)))
    {
      ViolaAccessHelper.a(paramContext, null, (String)localObject, paramBundle);
      return Integer.valueOf(12);
    }
    if ((paramString.startsWith("http://clientui.3g.qq.com/mqqapi/")) || (paramString.startsWith("http://clientui.3g.qq.com/mqq/")) || (paramString.startsWith("http://qm.qq.com/cgi-bin/")) || (paramString.startsWith("https://buluo.qq.com/cgi-bin/bar/jump?jump_type=xqquncard"))) {}
    for (int i = 1;; i = 0)
    {
      if (paramString.startsWith("https://m.gamefeeds.qq.com/live.html?"))
      {
        LiveRoomProxyActivity.open((Activity)paramContext, paramString, "kandian feed click");
        return Integer.valueOf(0);
      }
      if ((i == 0) && ((paramString.startsWith("http://")) || (paramString.startsWith("https://"))))
      {
        localObject = new Bundle();
        ((Bundle)localObject).putString("url", paramString);
        ((Bundle)localObject).putBoolean("hide_operation_bar", true);
        paramString = new Intent(paramContext, QQBrowserActivity.class);
        paramString.putExtra("big_brother_source_key", a(0));
        paramString.putExtras((Bundle)localObject);
        paramString.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
        if (paramBundle != null)
        {
          paramString.putExtras(paramBundle);
          if ((paramBundle.containsKey("requestCode")) && ((paramContext instanceof Activity)))
          {
            ((Activity)paramContext).startActivityForResult(paramString, paramBundle.getInt("requestCode", -1));
            return Integer.valueOf(11);
          }
        }
        paramContext.startActivity(paramString);
        return Integer.valueOf(11);
      }
      paramBundle = new Intent(paramContext, JumpActivity.class);
      paramString = Uri.parse(paramString);
      paramBundle.putExtra("PARAM_PLUGIN_INTERNAL_ACTIVITIES_ONLY", false);
      paramBundle.putExtra("big_brother_source_key", a(0));
      paramBundle.setData(paramString);
      paramContext.startActivity(paramBundle);
      return Integer.valueOf(0);
    }
  }
  
  public static Integer a(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    int i = 1;
    QLog.d("RIJJumpUtils", 1, "jumToUrl: " + paramString1);
    if (TextUtils.isEmpty(paramString1)) {
      return Integer.valueOf(-1);
    }
    if (paramString1.startsWith("mqqapi:")) {
      try
      {
        JumpAction localJumpAction = JumpParser.a(RIJQQAppInterfaceUtil.b(), paramContext, paramString1);
        if ((localJumpAction != null) && (localJumpAction.a())) {}
        while (i != 0)
        {
          return Integer.valueOf(9);
          i = 0;
        }
        if (TextUtils.isEmpty(paramString2)) {
          break label207;
        }
      }
      catch (Throwable localThrowable)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RIJJumpUtils", 2, "jumpToUrl failed for appInterface is null, url:" + paramString1 + ",error:" + localThrowable.getMessage());
        }
      }
    } else {
      try
      {
        if (WxShareHelperFromReadInjoy.a().a(paramString2, paramString3, 0)) {
          return Integer.valueOf(8);
        }
      }
      catch (Throwable paramString3)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RIJJumpUtils", 2, "jumpToUrl failed for wxMiniApp, appId:" + paramString2 + ",error:" + paramString3.getMessage());
        }
      }
    }
    label207:
    return b(paramContext, paramString1);
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      if (DailyModeConfigHandler.c(paramInt)) {
        return "biz_src_gzh_kandiandaily";
      }
      break;
    case 0: 
      return "biz_src_feeds_kandian";
    case 40677: 
      return "biz_src_gzh_weishi";
    }
    return "biz_src_feeds_kandian";
  }
  
  public static String a(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {
      return "";
    }
    Object localObject2 = ReadInJoyConstants.e;
    Object localObject1 = "";
    if (((String)localObject2).contains("uin")) {
      if ((paramArticleInfo.mSocialFeedInfo != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser != null) && (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long > 0L)) {
        localObject1 = String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long);
      }
    }
    for (localObject1 = ((String)localObject2).replace("uin=", "uin=" + Base64Util.encodeToString(((String)localObject1).getBytes(), 0).replace('\n', ' ').trim());; localObject1 = localObject2)
    {
      localObject2 = localObject1;
      if (((String)localObject1).contains("&feedstype=")) {
        localObject2 = ((String)localObject1).replace("&feedstype=", "&feedstype=" + paramArticleInfo.mFeedType);
      }
      paramArticleInfo = (String)localObject2 + paramArticleInfo.mFeedId;
      QLog.d("RIJJumpUtils", 2, new Object[] { "getNewSocialSecondUrl = ", paramArticleInfo });
      return paramArticleInfo;
      if (TextUtils.isEmpty(paramArticleInfo.mSubscribeID)) {
        break;
      }
      localObject1 = paramArticleInfo.mSubscribeID;
      break;
    }
  }
  
  @NotNull
  private static String a(ArticleInfo paramArticleInfo, int paramInt)
  {
    Object localObject2 = ReadInJoyConstants.e;
    Object localObject1 = localObject2;
    if (((String)localObject2).contains("uin="))
    {
      localObject1 = b(paramArticleInfo, paramInt);
      localObject1 = ((String)localObject2).replace("uin=", "uin=" + Base64Util.encodeToString(((String)localObject1).getBytes(), 0).replace('\n', ' ').trim());
    }
    localObject2 = localObject1;
    if (((String)localObject1).contains("&feedstype="))
    {
      if (((!RIJItemViewType.i(paramArticleInfo)) && (!RIJItemViewType.k(paramArticleInfo))) || ((paramInt == 2) || (paramInt == 3) || (paramInt == 5) || (paramInt == 7))) {
        localObject2 = ((String)localObject1).replace("&feedstype=", "&feedstype=" + paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$BiuInfo.b);
      }
    }
    else {
      return localObject2;
    }
    return ((String)localObject1).replace("&feedstype=", "&feedstype=" + paramArticleInfo.mFeedType);
  }
  
  public static String a(BaseArticleInfo paramBaseArticleInfo, String paramString)
  {
    String str;
    if (a(paramString)) {
      str = a(paramString, paramBaseArticleInfo);
    }
    do
    {
      return str;
      str = paramString;
    } while (!b(paramString));
    return b(paramString, paramBaseArticleInfo);
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    return ReadInJoyConstants.g + Base64Util.encodeToString(paramString.getBytes(), 2);
  }
  
  public static String a(@NotNull String paramString, long paramLong, int paramInt)
  {
    if (paramString.isEmpty()) {}
    do
    {
      return paramString;
      localObject = URLUtil.a(paramString);
      if (!"6".equals((String)((Map)localObject).get("target"))) {
        break;
      }
      localObject = (String)((Map)localObject).get("v_url_base64");
    } while ((localObject == null) || (((String)localObject).isEmpty()));
    Object localObject = Base64Util.encodeToString(Uri.parse(new String(Base64Util.decode((String)localObject, 0))).buildUpon().appendQueryParameter("percentage", String.valueOf(paramLong)).appendQueryParameter("mutestate", String.valueOf(paramInt)).build().toString().getBytes("utf-8"), 2);
    return URLUtil.b(URLUtil.a(paramString, "v_url_base64"), "v_url_base64", (String)localObject);
    return Uri.parse(paramString).buildUpon().appendQueryParameter("percentage", String.valueOf(paramLong)).appendQueryParameter("mutestate", String.valueOf(paramInt)).build().toString();
  }
  
  private static String a(String paramString, ArticleInfo paramArticleInfo, int paramInt1, int paramInt2)
  {
    paramArticleInfo = paramString + a(paramArticleInfo, paramInt1);
    paramString = paramArticleInfo;
    if (paramInt2 >= 0) {
      paramString = paramArticleInfo + "&jumptype=" + paramInt2;
    }
    return paramString;
  }
  
  public static String a(String paramString, BaseArticleInfo paramBaseArticleInfo)
  {
    Object localObject = paramString;
    if (paramBaseArticleInfo != null) {}
    try
    {
      localObject = new StringBuilder();
      Map localMap = URLUtil.a(paramString);
      ((StringBuilder)localObject).append("mqqapi://readinjoy/open?src_type=internal&target=3").append(a(localMap, "channelID", paramBaseArticleInfo.mChannelID + "")).append(a(localMap, "strategyId", paramBaseArticleInfo.mStrategyId + "")).append(a(localMap, "algorithmID", paramBaseArticleInfo.mAlgorithmID + "")).append(a(localMap, "title", paramBaseArticleInfo.mTitle)).append(a(localMap, "firstPagePicUrl", URLEncoder.encode(paramBaseArticleInfo.mFirstPagePicUrl, "UTF-8"))).append(a(localMap, "articleID", paramBaseArticleInfo.mArticleID + "")).append(a(localMap, "subscribeName", paramBaseArticleInfo.mSubscribeName)).append(a(localMap, "rowKey", paramBaseArticleInfo.innerUniqueID)).append(a(localMap, "subscribeID", paramBaseArticleInfo.mSubscribeID)).append(a(localMap, "articleContentUrl", URLEncoder.encode(paramString, "UTF-8"))).append("&").append("readinjoyNotDecodeUrl=1");
      localObject = ((StringBuilder)localObject).toString();
      QLog.d("RIJJumpUtils", 1, "getJumpNativeArticleScheme |  articleScheme : " + (String)localObject);
      return localObject;
    }
    catch (UnsupportedEncodingException paramBaseArticleInfo)
    {
      for (;;)
      {
        QLog.e("RIJJumpUtils", 2, paramBaseArticleInfo.getMessage());
        localObject = paramString;
      }
    }
  }
  
  public static String a(String paramString, NewPolymericInfo.PackArticleInfo paramPackArticleInfo, BaseArticleInfo paramBaseArticleInfo)
  {
    Object localObject = paramString;
    if (paramPackArticleInfo != null)
    {
      localObject = paramString;
      if (paramBaseArticleInfo != null)
      {
        localObject = paramString;
        if (TextUtils.isEmpty(paramPackArticleInfo.c)) {}
      }
    }
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("mqqapi://readinjoy/open?src_type=internal&target=3").append("&channelID=").append(paramBaseArticleInfo.mChannelID).append("&strategyId=").append(paramPackArticleInfo.jdField_a_of_type_Int).append("&algorithmID=").append(paramPackArticleInfo.jdField_b_of_type_Long).append("&title=").append(paramPackArticleInfo.jdField_a_of_type_JavaLangString).append("&firstPagePicUrl=").append(URLEncoder.encode(paramPackArticleInfo.c, "UTF-8")).append("&articleID=").append(paramPackArticleInfo.jdField_a_of_type_Long).append("&subscribeName=").append(paramPackArticleInfo.f).append("&rowKey=").append(paramPackArticleInfo.g).append("&subscribeID=").append(paramPackArticleInfo.e).append("&articleContentUrl=").append(URLEncoder.encode(paramString, "UTF-8")).append("&readinjoyNotDecodeUrl=1");
      localObject = ((StringBuilder)localObject).toString();
      QLog.d("RIJJumpUtils", 1, "getJumpNativeArticleScheme | polymeric articleScheme : " + (String)localObject);
      return localObject;
    }
    catch (UnsupportedEncodingException paramPackArticleInfo)
    {
      for (;;)
      {
        QLog.d("RIJJumpUtils", 2, paramPackArticleInfo.getMessage());
        localObject = paramString;
      }
    }
  }
  
  public static String a(String paramString, JSONObject paramJSONObject)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramString);
    if (paramJSONObject != null)
    {
      JSONObject localJSONObject = paramJSONObject.optJSONObject("card_info");
      if (localJSONObject != null)
      {
        Iterator localIterator = localJSONObject.keys();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          try
          {
            if (!str.equalsIgnoreCase("reportInfo"))
            {
              paramJSONObject = localJSONObject.getString(str);
              localStringBuilder.append("&");
              paramString = paramJSONObject;
              if (paramJSONObject.contains("&")) {
                paramString = URLEncoder.encode(paramJSONObject, "utf-8");
              }
              localStringBuilder.append(str + "=" + paramString);
            }
          }
          catch (Exception paramString)
          {
            QLog.e("RIJJumpUtils", 2, paramString.getMessage());
          }
        }
      }
    }
    localStringBuilder.append("&");
    localStringBuilder.append("readinjoyNotDecodeUrl=1");
    return localStringBuilder.toString();
  }
  
  private static String a(Map<String, String> paramMap, String paramString1, String paramString2)
  {
    if ((paramMap != null) && (!paramMap.containsKey(paramString1))) {
      return "&" + paramString1 + "=" + paramString2;
    }
    return "";
  }
  
  public static JSONObject a(int paramInt, String paramString)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("button", paramInt);
      localJSONObject.put("extraParams", paramString);
      return localJSONObject;
    }
    catch (Exception paramString)
    {
      QLog.e("RIJJumpUtils", 1, "getDialogResult error! msg=" + paramString);
    }
    return localJSONObject;
  }
  
  public static void a(Activity paramActivity, ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    do
    {
      return;
      if ((paramArticleInfo.mArticleContentUrl != null) && (paramArticleInfo.mArticleContentUrl.startsWith("mqqapi:")))
      {
        String str = paramArticleInfo.mArticleContentUrl;
        localObject = str;
        if (c(str)) {
          localObject = b(str, paramArticleInfo);
        }
        a(paramActivity, (String)localObject);
        a(paramArticleInfo, paramArticleInfo.mArticleContentUrl);
        return;
      }
      TimeUtil.a("FastWebActivity.show");
      ReadInJoyLogicEngine.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
      Object localObject = new Intent(paramActivity, FastWebActivity.class);
      ((Intent)localObject).putExtra("fast_web_article_info", paramArticleInfo);
      paramActivity.startActivityForResult((Intent)localObject, 10922);
      QLog.d("RIJJumpUtils", 1, "startWebFastActivity, rowkey= " + paramArticleInfo.innerUniqueID);
    } while (paramArticleInfo.mChannelID != 0L);
    RIJFeedsDynamicInsertController.a.a(paramArticleInfo.innerUniqueID, new RIJFeedsInsertAction(RIJFeedsDynamicInsertRecordAction.ActionType.ACTION_ENTER, 0, 0, 0), 5);
  }
  
  public static void a(Activity paramActivity, ArticleInfo paramArticleInfo, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, int paramInt)
  {
    b(paramActivity, paramArticleInfo, paramReadInJoyBaseAdapter, paramInt);
    ReadInJoyLogicEngine.a().a(paramArticleInfo.mArticleID, System.currentTimeMillis());
    paramReadInJoyBaseAdapter.notifyDataSetChanged();
    if (PublicAccountImageCollectionUtils.a(paramArticleInfo))
    {
      paramReadInJoyBaseAdapter = new Intent(paramActivity, PublicAccountImageCollectionMainActivity.class);
      paramReadInJoyBaseAdapter.putExtra("source_for_report", 9);
      PublicAccountImageCollectionUtils.a(paramActivity, paramReadInJoyBaseAdapter, String.valueOf(paramArticleInfo.innerUniqueID));
      return;
    }
    paramInt = paramReadInJoyBaseAdapter.a();
    long l = paramArticleInfo.mRecommendSeq;
    Bundle localBundle = new Bundle();
    localBundle.putString("leftViewText", null);
    Object localObject2 = paramArticleInfo.mArticleContentUrl;
    Object localObject1 = localObject2;
    if (RIJItemViewType.h(paramArticleInfo))
    {
      localObject1 = localObject2;
      if (!RIJItemViewType.l(paramArticleInfo)) {
        localObject1 = ((TopicRecommendFeedsInfo.TopicRecommendInfo)paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructTopicRecommendFeedsInfo.a.get(0)).b;
      }
    }
    localObject2 = localObject1;
    if (!(paramArticleInfo instanceof AdvertisementInfo)) {
      if (!((String)localObject1).contains("?")) {
        break label229;
      }
    }
    label229:
    for (localObject1 = (String)localObject1 + "&";; localObject1 = (String)localObject1 + "?")
    {
      localObject2 = (String)localObject1 + "from=0";
      if (!d((String)localObject2)) {
        break;
      }
      b(paramActivity, (String)localObject2);
      return;
    }
    localBundle.putString("url", (String)localObject2);
    localBundle.putBoolean("hide_operation_bar", true);
    localBundle.putString("from", String.valueOf(53));
    localBundle.putString("subscribename", paramArticleInfo.mSubscribeName);
    localBundle.putString("row_key", paramArticleInfo.innerUniqueID);
    localBundle.putLong("articleid", paramArticleInfo.mArticleID);
    localBundle.putLong("recommendSeq", l);
    localBundle.putInt("channelid", paramInt);
    localBundle.putInt("strategyid", paramArticleInfo.mStrategyId);
    localBundle.putLong("algorithmid", paramArticleInfo.mAlgorithmID);
    localBundle.putInt("articalChannelId", 9);
    localBundle.putStringArray("insertPluginsArray", new String[] { "pubAccountPreload" });
    localBundle.putBoolean("ip_connect", PublicAccountConfigUtilImpl.readInJoyIpConnect);
    l = System.currentTimeMillis();
    localBundle.putLong("startOpenPageTime", l);
    localBundle.putLong("click_time", l);
    localBundle.putLong("available_memory", DeviceInfoUtil.e());
    localBundle.putBoolean("preload_tool_white_list", RIJWebSearchUtils.a());
    Intent localIntent = new Intent(paramActivity, ReadInJoyArticleDetailActivity.class);
    localObject2 = PreloadManager.a((String)localObject2);
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    if ((FileUtils.b(AppConstants.SDCARD_PATH_PUBLIC_ACCOUNT_PRELOAD + (String)localObject1)) && (PreloadManager.a().b((String)localObject1) != null))
    {
      localBundle.putString("read_in_joy_from_cache", (String)localObject1);
      if (!paramReadInJoyBaseAdapter.a(paramInt, paramArticleInfo.mArticleID))
      {
        paramArticleInfo = PreloadManager.a();
        if ((NetworkState.getNetworkType() != 1) && (NetworkState.getNetworkType() != 4) && (NetworkState.getNetworkType() != 5)) {
          break label673;
        }
        paramReadInJoyBaseAdapter = paramArticleInfo.a((String)localObject1);
        if ((paramReadInJoyBaseAdapter != null) && (paramReadInJoyBaseAdapter.size() > 0))
        {
          ThreadManager.post(new RIJJumpUtils.4(paramArticleInfo, (PreloadManager.ImgStruct)paramReadInJoyBaseAdapter.get(0)), 5, null, false);
          if (paramReadInJoyBaseAdapter.size() <= 1) {
            break label661;
          }
          localBundle.putString("preload_iamge_url", ((PreloadManager.ImgStruct)paramReadInJoyBaseAdapter.get(1)).jdField_a_of_type_JavaLangString);
        }
      }
    }
    for (;;)
    {
      localIntent.putExtras(localBundle);
      paramActivity.startActivityForResult(localIntent, 9991);
      RIJWebArticleOptimizeUtil.a.a(paramActivity);
      return;
      label661:
      localBundle.putString("preload_iamge_url", null);
      continue;
      label673:
      paramArticleInfo = paramArticleInfo.a((String)localObject1);
      if ((paramArticleInfo != null) && (paramArticleInfo.size() > 0)) {
        localBundle.putString("preload_iamge_url", ((PreloadManager.ImgStruct)paramArticleInfo.get(0)).jdField_a_of_type_JavaLangString);
      } else {
        localBundle.putString("preload_iamge_url", null);
      }
    }
  }
  
  public static void a(Context paramContext, ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo.mGalleryFeedsInfo != null) && (paramArticleInfo.mGalleryFeedsInfo.bytes_jump_url.has()) && (!TextUtils.isEmpty(paramArticleInfo.mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8())))
    {
      paramArticleInfo = Uri.parse(paramArticleInfo.mGalleryFeedsInfo.bytes_jump_url.get().toStringUtf8()).buildUpon();
      paramArticleInfo.appendQueryParameter("showComment", "1");
      paramArticleInfo = paramArticleInfo.toString();
      a(paramContext, paramArticleInfo);
      if (QLog.isColorLevel()) {
        QLog.e("RIJJumpUtils", 2, "jumpToGallery url=" + paramArticleInfo);
      }
    }
  }
  
  public static void a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt)
  {
    a(paramContext, paramArticleInfo, paramInt, false, 0, false);
  }
  
  public static void a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt1, boolean paramBoolean, int paramInt2, int paramInt3)
  {
    QLog.d("RIJJumpUtils", 1, "jumpNewSocialSecondPage: " + paramArticleInfo + " type: " + paramInt1 + " shallNotReport: " + paramBoolean + " from: " + paramInt2 + " jumpType: " + paramInt3);
    if ((paramContext == null) || (paramArticleInfo == null)) {
      return;
    }
    a = paramArticleInfo;
    String str = a(a(paramArticleInfo, paramInt1), paramArticleInfo, paramInt1, paramInt3);
    Bundle localBundle = new Bundle();
    ReadInJoyWebDataManager localReadInJoyWebDataManager;
    if (ReadInJoyWebDataManager.a(paramArticleInfo))
    {
      localReadInJoyWebDataManager = ReadInJoyWebDataManager.a();
      if ((paramInt1 != 1) && (paramInt1 != 3)) {
        break label187;
      }
    }
    label187:
    for (boolean bool = true;; bool = false)
    {
      localReadInJoyWebDataManager.a(paramArticleInfo, bool, str);
      QLog.d("RIJJumpUtils", 1, "jumpNewSocialSecondPage, url:" + str);
      a(paramContext, str, localBundle);
      if (paramBoolean) {
        break;
      }
      a(paramArticleInfo, paramInt1, paramInt2);
      return;
    }
  }
  
  public static void a(Context paramContext, ArticleInfo paramArticleInfo, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2)
  {
    if (paramBoolean2) {}
    for (int i = 2;; i = 0)
    {
      a(paramContext, paramArticleInfo, paramInt1, paramBoolean1, paramInt2, i);
      return;
    }
  }
  
  @Deprecated
  public static void a(Context paramContext, ArticleInfo paramArticleInfo, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, int paramInt)
  {
    if ((paramArticleInfo == null) || (paramReadInJoyBaseAdapter == null)) {
      return;
    }
    int k = paramReadInJoyBaseAdapter.a();
    int i;
    if (paramArticleInfo.hasChannelInfo())
    {
      i = paramArticleInfo.mChannelInfoId;
      if (!TextUtils.isEmpty(paramArticleInfo.mArticleFriendLikeText)) {
        break label634;
      }
    }
    label634:
    for (int j = 0;; j = 1)
    {
      paramReadInJoyBaseAdapter = RIJFeedsType.b(paramArticleInfo);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80066FA", "0X80066FA", 0, 0, "", Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), RIJTransMergeKanDianReport.b(paramArticleInfo.mAlgorithmID, RIJFeedsType.a(paramArticleInfo), k, i), false);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse("0X80066FA", "", "", Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), RIJTransMergeKanDianReport.b(paramArticleInfo.mAlgorithmID, RIJFeedsType.a(paramArticleInfo), paramInt, i));
      localObject1 = ReadinjoyReportUtils.b(k);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", paramArticleInfo.mSubscribeID, (String)localObject1, (String)localObject1, 0, 0, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), RIJTransMergeKanDianReport.a(paramArticleInfo.mAlgorithmID, RIJFeedsType.a(paramArticleInfo), k, i, j, NetworkUtil.h(paramContext), paramReadInJoyBaseAdapter, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, RIJFeedsType.d(paramArticleInfo), paramArticleInfo), false);
      ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).reportPAinfoToLighthouse((String)localObject1, paramArticleInfo.mSubscribeID, Long.toString(paramArticleInfo.mFeedId), Long.toString(paramArticleInfo.mArticleID), Integer.toString(paramArticleInfo.mStrategyId), RIJTransMergeKanDianReport.a(paramArticleInfo.mAlgorithmID, RIJFeedsType.a(paramArticleInfo), k, i, j, NetworkUtil.h(paramContext), paramReadInJoyBaseAdapter, paramArticleInfo.mStrCircleId, paramArticleInfo.innerUniqueID, RIJFeedsType.d(paramArticleInfo), paramArticleInfo));
      paramContext = new ArrayList();
      paramReadInJoyBaseAdapter = new ReportInfo();
      paramReadInJoyBaseAdapter.mUin = RIJQQAppInterfaceUtil.a();
      paramReadInJoyBaseAdapter.mSource = 0;
      paramReadInJoyBaseAdapter.mSourceArticleId = paramArticleInfo.mArticleID;
      paramReadInJoyBaseAdapter.mChannelId = k;
      paramReadInJoyBaseAdapter.mAlgorithmId = ((int)paramArticleInfo.mAlgorithmID);
      paramReadInJoyBaseAdapter.mStrategyId = paramArticleInfo.mStrategyId;
      paramReadInJoyBaseAdapter.mOperation = 1;
      paramReadInJoyBaseAdapter.mServerContext = paramArticleInfo.mServerContext;
      paramReadInJoyBaseAdapter.mReadTimeLength = -1;
      paramReadInJoyBaseAdapter.mInnerId = paramArticleInfo.innerUniqueID;
      if ((paramArticleInfo != null) && (!UGRuleManager.c(paramArticleInfo)) && (!ReadInJoySrtUtils.a().a()) && (RIJTransMergeKanDianReport.a(BaseApplicationImpl.getApplication().getApplicationContext(), paramArticleInfo))) {
        paramReadInJoyBaseAdapter.noDifferenceJump = 1;
      }
      if (paramArticleInfo.mSocialFeedInfo == null) {
        break label646;
      }
      localObject1 = new ReportInfo.FeedsReportData();
      ((ReportInfo.FeedsReportData)localObject1).jdField_a_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_Long;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser != null) {
        ((ReportInfo.FeedsReportData)localObject1).jdField_b_of_type_Long = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long;
      }
      ((ReportInfo.FeedsReportData)localObject1).jdField_a_of_type_Int = paramArticleInfo.mSocialFeedInfo.jdField_b_of_type_Int;
      ((ReportInfo.FeedsReportData)localObject1).jdField_b_of_type_Int = paramArticleInfo.mSocialFeedInfo.d;
      Object localObject2 = paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_JavaUtilList;
      if ((localObject2 == null) || (((List)localObject2).isEmpty())) {
        break label640;
      }
      ((ReportInfo.FeedsReportData)localObject1).jdField_a_of_type_JavaUtilList = new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        SocializeFeedsInfo.FeedsInfoUser localFeedsInfoUser = (SocializeFeedsInfo.FeedsInfoUser)((Iterator)localObject2).next();
        if (localFeedsInfoUser != null) {
          ((ReportInfo.FeedsReportData)localObject1).jdField_a_of_type_JavaUtilList.add(Long.valueOf(localFeedsInfoUser.jdField_a_of_type_Long));
        }
      }
      i = 0;
      break;
    }
    label640:
    paramReadInJoyBaseAdapter.mFeedsReportData = ((ReportInfo.FeedsReportData)localObject1);
    label646:
    Object localObject1 = ReadInJoySrtUtils.a().a();
    if (localObject1 != null) {
      paramReadInJoyBaseAdapter.srtClickInfo = ((oidb_cmd0x64e.SRTClickInfo)localObject1);
    }
    paramContext.add(paramReadInJoyBaseAdapter);
    ReadInJoyLogicEngine.a().a(paramContext);
    RIJFeedsInsertUtil.a.b(k, paramArticleInfo);
  }
  
  public static void a(Context paramContext, ArticleInfo paramArticleInfo, boolean paramBoolean)
  {
    a(paramContext, paramArticleInfo, 0, false, 0, paramBoolean);
  }
  
  public static void a(Context paramContext, BaseArticleInfo paramBaseArticleInfo, String paramString)
  {
    paramString = a(paramBaseArticleInfo, paramString);
    QLog.d("RIJJumpUtils", 1, "jumpTo |  scheme : " + paramString);
    a(paramBaseArticleInfo, paramString);
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {
      QLog.d("RIJJumpUtils", 1, "context or scehme null");
    }
    while (ReadInJoyChannelGuidingJumpUtils.a(paramContext, paramString)) {
      return;
    }
    a(paramContext, paramString, null);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (paramString == null)) {}
    Object localObject;
    do
    {
      return;
      localObject = paramContext;
      if (!(paramContext instanceof BasePluginActivity)) {
        break;
      }
      localObject = ((BasePluginActivity)paramContext).getOutActivity();
    } while (localObject == null);
    paramContext = new Bundle();
    paramContext.putString("url", paramString);
    paramContext.putBoolean("hide_operation_bar", true);
    paramString = new Intent((Context)localObject, QQBrowserActivity.class);
    paramString.putExtras(paramContext);
    paramString.putExtra("selfSet_leftViewText", HardCodeUtil.a(2131713064));
    ((Context)localObject).startActivity(paramString);
  }
  
  public static void a(Context paramContext, JSONObject paramJSONObject, RIJUserLevelDialog.DialogClick paramDialogClick)
  {
    if ((paramJSONObject == null) || (paramContext == null))
    {
      QLog.d("RIJJumpUtils", 1, "showLevelDialog error! null");
      return;
    }
    RIJUserLevelDialog.DialogSettingInfo localDialogSettingInfo = new RIJUserLevelDialog.DialogSettingInfo();
    localDialogSettingInfo.jdField_a_of_type_JavaLangString = paramJSONObject.optString("title");
    localDialogSettingInfo.b = paramJSONObject.optString("titleColor");
    localDialogSettingInfo.c = paramJSONObject.optString("text");
    localDialogSettingInfo.d = paramJSONObject.optString("textColor");
    localDialogSettingInfo.g = paramJSONObject.optString("rBtnText");
    localDialogSettingInfo.h = paramJSONObject.optString("rBtnTextColor");
    localDialogSettingInfo.e = paramJSONObject.optString("lBtnText");
    localDialogSettingInfo.f = paramJSONObject.optString("lBtnTextColor");
    localDialogSettingInfo.i = paramJSONObject.optString("extraParams");
    localDialogSettingInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewWidgetRIJUserLevelDialog$DialogClick = paramDialogClick;
    ReadInJoyUtils.a(paramContext, localDialogSettingInfo);
    QLog.d("RIJJumpUtils", 1, "openLevelDialog !");
  }
  
  private static void a(ArticleInfo paramArticleInfo, int paramInt1, int paramInt2)
  {
    int i;
    Object localObject1;
    if ((RIJItemViewType.g(paramArticleInfo)) || (RIJItemViewType.i(paramArticleInfo)) || (RIJItemViewType.j(paramArticleInfo)) || (RIJItemViewType.k(paramArticleInfo)))
    {
      i = 1;
      if ((i != 0) || (RIJFeedsType.a(paramArticleInfo)) || (RIJItemViewType.a(paramArticleInfo))) {
        localObject1 = "";
      }
    }
    for (;;)
    {
      try
      {
        localObject2 = new JSONObject();
        ((JSONObject)localObject2).put("folder_status", RIJKanDianFolderStatus.jdField_a_of_type_Int);
        if (paramInt1 != 1) {
          continue;
        }
        ((JSONObject)localObject2).put("feeds_source", paramArticleInfo.mSubscribeID);
        ((JSONObject)localObject2).put("rowkey", paramArticleInfo.innerUniqueID);
        ((JSONObject)localObject2).put("feeds_type", "" + RIJFeedsType.a(paramArticleInfo));
        ((JSONObject)localObject2).put("kandian_mode", "" + RIJAppSetting.a());
        ((JSONObject)localObject2).put("tab_source", "" + RIJTransMergeKanDianReport.a());
        if (paramInt2 > 0) {
          ((JSONObject)localObject2).put("entry_mode", "" + paramInt2);
        }
        ((JSONObject)localObject2).put("channel_id", "" + paramArticleInfo.mChannelID);
        ((JSONObject)localObject2).put("algorithm_id", "" + paramArticleInfo.mAlgorithmID);
        localObject2 = ((JSONObject)localObject2).toString();
        localObject1 = localObject2;
      }
      catch (JSONException localJSONException)
      {
        Object localObject2;
        localJSONException.printStackTrace();
        continue;
        String str = "0X8007B64";
        continue;
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, paramArticleInfo.mSubscribeID, str, str, 0, 0, String.valueOf(paramArticleInfo.mFeedId), String.valueOf(paramArticleInfo.mArticleID), "" + paramArticleInfo.mStrategyId, (String)localObject1, false);
      }
      if (!ReadinjoyReportUtils.a(paramArticleInfo.mChannelID)) {
        continue;
      }
      localObject2 = "0X800935D";
      if (i == 0) {
        continue;
      }
      if (!RIJItemViewType.o(paramArticleInfo)) {
        ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEvent(null, String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Long), (String)localObject2, (String)localObject2, 0, 0, String.valueOf(paramArticleInfo.mFeedId), "0", "" + paramArticleInfo.mStrategyId, (String)localObject1, false);
      }
      return;
      i = 0;
      break;
      ((JSONObject)localObject2).put("feeds_source", paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long);
    }
  }
  
  public static void a(BaseArticleInfo paramBaseArticleInfo, String paramString)
  {
    if ((paramBaseArticleInfo != null) && (!TextUtils.isEmpty(paramString)))
    {
      if ((paramString.contains("mqqapi://readinjoy/open")) && (paramString.contains("target=4"))) {
        paramBaseArticleInfo.mJumpType = 2;
      }
    }
    else {
      return;
    }
    paramBaseArticleInfo.mJumpType = 1;
  }
  
  public static void a(String paramString, ArticleInfo paramArticleInfo)
  {
    Object localObject = ReadInJoyConstants.k + Base64Util.encodeToString(String.valueOf(paramString).getBytes(), 2);
    paramString = (String)localObject;
    if (paramArticleInfo != null) {
      paramString = ReadinjoyReportUtils.a(paramArticleInfo, (String)localObject, ReadinjoyReportUtils.d);
    }
    localObject = QBaseActivity.sTopActivity;
    paramArticleInfo = (ArticleInfo)localObject;
    if (localObject == null) {
      paramArticleInfo = BaseApplicationImpl.getContext();
    }
    ReadInJoyUtils.a(paramArticleInfo, paramString);
    QLog.d("RIJJumpUtils", 1, "jump2SelfPage: " + paramString);
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, String paramString4, RIJJumpUtils.NativeWebVideoCoverGetCallback paramNativeWebVideoCoverGetCallback)
  {
    ThreadManager.executeOnNetWorkThread(new RIJJumpUtils.3(paramString4, paramString3, paramString2, paramString1, paramNativeWebVideoCoverGetCallback));
  }
  
  public static boolean a(@NonNull Context paramContext, String paramString, int paramInt, @Nullable MiniAppLaunchListener paramMiniAppLaunchListener)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return ((IMiniAppService)QRoute.api(IMiniAppService.class)).startMiniApp(paramContext, paramString, paramInt, paramMiniAppLaunchListener);
    }
    return false;
  }
  
  public static boolean a(ArticleInfo paramArticleInfo, Context paramContext)
  {
    String str = ProteusSupportUtil.a(paramArticleInfo);
    if ((!TextUtils.isEmpty(str)) && (paramContext != null))
    {
      if (UGRuleManager.a(str)) {
        a(paramContext, paramArticleInfo, str);
      }
      for (;;)
      {
        QLog.d("RIJJumpUtils", 1, "tryJumpToUgUrl,title=" + paramArticleInfo.mTitle);
        return true;
        VideoFeedsHelper.a(BaseApplicationImpl.getApplication(), str);
      }
    }
    return false;
  }
  
  public static boolean a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = URLUtil.a(paramString);
      return (paramString != null) && ("1".equalsIgnoreCase((String)paramString.get("jump_android_hemera")));
    }
    return false;
  }
  
  public static Integer b(Context paramContext, String paramString)
  {
    QLog.d("RIJJumpUtils", 1, "jumToWeb: " + paramString);
    if ((!TextUtils.isEmpty(paramString)) && (ViolaAccessHelper.b(paramString)))
    {
      ViolaAccessHelper.a(paramContext, null, ViolaAccessHelper.c(paramString), null);
      return Integer.valueOf(12);
    }
    if (SearchUtils.d(paramString))
    {
      SearchUtils.a(paramContext, SearchUtils.a(paramString), paramString);
      return Integer.valueOf(12);
    }
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("big_brother_source_key", a(0));
    if (!TextUtils.isEmpty(paramString))
    {
      localIntent.putExtra("url", paramString);
      paramContext.startActivity(localIntent);
    }
    return Integer.valueOf(11);
  }
  
  private static String b(ArticleInfo paramArticleInfo)
  {
    String str = "";
    if (!RIJItemViewType.o(paramArticleInfo)) {
      str = String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Long);
    }
    return str;
  }
  
  private static String b(ArticleInfo paramArticleInfo, int paramInt)
  {
    String str2 = "";
    String str1;
    if ((paramInt == 0) || (paramInt == 6) || (paramInt == 8)) {
      str1 = c(paramArticleInfo);
    }
    for (;;)
    {
      paramArticleInfo = str1;
      if (str1 == null) {
        paramArticleInfo = "";
      }
      return paramArticleInfo;
      if ((paramInt == 1) || (paramInt == 3))
      {
        str1 = paramArticleInfo.mSubscribeID;
      }
      else if ((paramInt == 2) || (paramInt == 4))
      {
        str1 = b(paramArticleInfo);
      }
      else if (paramInt == 5)
      {
        str1 = String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long);
      }
      else
      {
        str1 = str2;
        if (paramInt == 7) {
          if (!RIJItemViewType.o(paramArticleInfo))
          {
            str1 = String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$UGCFeedsInfo.jdField_a_of_type_Long);
          }
          else
          {
            str1 = str2;
            if (!TextUtils.isEmpty(paramArticleInfo.mSubscribeID)) {
              str1 = paramArticleInfo.mSubscribeID;
            }
          }
        }
      }
    }
  }
  
  public static String b(String paramString)
  {
    Object localObject1 = Aladdin.getConfig(199);
    Object localObject2 = ((AladdinConfig)localObject1).getString("no_difference_jump_app_schema", "");
    String str1 = ((AladdinConfig)localObject1).getString("no_difference_jump_app_h5_android", "");
    String str2 = ((AladdinConfig)localObject1).getString("no_difference_jump_app_package_name", "");
    localObject1 = localObject2;
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {
      localObject1 = ((String)localObject2).replace("${rowkey}", paramString).replace("${uin}", RIJQQAppInterfaceUtil.a());
    }
    localObject2 = str1;
    if (!TextUtils.isEmpty(str1)) {
      localObject2 = str1.replace("${rowkey}", paramString).replace("${uin}", RIJQQAppInterfaceUtil.a());
    }
    paramString = new StringBuilder();
    try
    {
      paramString.append("mqqapi://readinjoy/open?src_type=internal&target=4").append("&defaultURL=").append(URLEncoder.encode((String)localObject2, "utf-8")).append("&appSchema=").append(URLEncoder.encode((String)localObject1, "utf-8")).append("&appPackageName=").append(str2).append("&readinjoyNotDecodeUrl=1").append("&version=1").append("&isCancelJump=0");
      QLog.e("RIJJumpUtils", 1, "getNoDifferenceJumpToAppSchema schema: " + paramString.toString());
      ReadInJoyHelper.g();
      paramString = paramString.toString();
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      QLog.e("RIJJumpUtils", 1, "getNoDifferenceJumpToAppSchema UnsupportedEncodingException: " + paramString);
    }
    return "";
  }
  
  public static String b(String paramString, BaseArticleInfo paramBaseArticleInfo)
  {
    Object localObject = paramString;
    if (paramBaseArticleInfo != null) {}
    try
    {
      localObject = new StringBuilder(paramString);
      String str = paramBaseArticleInfo.mVideoCoverUrl.toExternalForm();
      Map localMap = URLUtil.a(paramString);
      ((StringBuilder)localObject).append(a(localMap, "videoType", paramBaseArticleInfo.busiType + "")).append(a(localMap, "videoVid", paramBaseArticleInfo.mVideoVid)).append(a(localMap, "videoWidth", paramBaseArticleInfo.mVideoJsonWidth + "")).append(a(localMap, "videoHeight", paramBaseArticleInfo.mVideoJsonHeight + "")).append(a(localMap, "videoDuration", paramBaseArticleInfo.mVideoDuration + "")).append(a(localMap, "title", paramBaseArticleInfo.mTitle)).append(a(localMap, "firstPagePicUrl", URLEncoder.encode(str, "UTF-8"))).append(a(localMap, "articleContentUrl", URLEncoder.encode(paramBaseArticleInfo.mArticleContentUrl, "UTF-8"))).append(a(localMap, "subscribeName", paramBaseArticleInfo.mSubscribeName)).append(a(localMap, "subscribeID", paramBaseArticleInfo.mSubscribeID)).append(a(localMap, "readinjoyNotDecodeUrl", "1"));
      localObject = ((StringBuilder)localObject).toString();
      return localObject;
    }
    catch (Exception paramBaseArticleInfo)
    {
      QLog.d("RIJJumpUtils", 2, paramBaseArticleInfo.getMessage());
    }
    return paramString;
  }
  
  public static void b(Activity paramActivity, ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramActivity == null))
    {
      QLog.d("RIJJumpUtils", 1, "clickCommentBiuCardWrapper error!");
      return;
    }
    if ((RIJBiuAndCommentAladdinUtils.f()) && (RIJFeedsType.r(paramArticleInfo))) {}
    for (String str = paramArticleInfo.getCardJumpUrl();; str = "")
    {
      if (!TextUtils.isEmpty(str)) {
        a(paramActivity, str);
      }
      for (;;)
      {
        QLog.d("RIJJumpUtils", 1, "clickCommentBiuCardWrapper,jumpUrl=" + str);
        return;
        if (paramArticleInfo.isPGCShortContent())
        {
          if (a(paramArticleInfo, paramActivity))
          {
            QLog.d("RIJJumpUtils", 1, "tryJumpToUgUrl: true");
          }
          else
          {
            QLog.d("RIJJumpUtils", 1, "short content redirectToOtherPage!");
            PGCShortContentUtils.a(paramActivity, paramArticleInfo);
          }
        }
        else if (RIJFeedsType.z(paramArticleInfo))
        {
          VideoFeedsHelper.a(paramActivity, null, 28, paramArticleInfo);
        }
        else if (RIJFeedsType.s(paramArticleInfo))
        {
          QLog.d("RIJJumpUtils", 1, "startWebFastActivity");
          a(paramActivity, paramArticleInfo);
        }
        else
        {
          QLog.d("RIJJumpUtils", 1, "jumpNewSocialSecondPage");
          a(paramActivity, paramArticleInfo, 7, false, 0, false);
        }
      }
    }
  }
  
  private static void b(Activity paramActivity, ArticleInfo paramArticleInfo, ReadInJoyBaseAdapter paramReadInJoyBaseAdapter, int paramInt)
  {
    ThreadManager.getSubThreadHandler().post(new RIJJumpUtils.5(paramActivity, paramArticleInfo, paramReadInJoyBaseAdapter, paramInt));
  }
  
  public static void b(Context paramContext, ArticleInfo paramArticleInfo, int paramInt)
  {
    if ((paramArticleInfo == null) || (paramContext == null))
    {
      QLog.d("RIJJumpUtils", 1, "clickCommentBiuCard error!");
      return;
    }
    String str;
    if ((paramInt == 6) && (RIJBiuAndCommentAladdinUtils.e()))
    {
      if ((paramArticleInfo.isCardJumpUrlAvailable != 1) || (TextUtils.isEmpty(paramArticleInfo.getCardJumpUrl()))) {
        break label145;
      }
      str = paramArticleInfo.getCardJumpUrl();
    }
    for (;;)
    {
      if (TextUtils.isEmpty(str)) {
        a(paramContext, paramArticleInfo, paramInt, false, 0, false);
      }
      for (;;)
      {
        QLog.d("RIJJumpUtils", 1, "clickCommentBiuCard,clickType=" + paramInt + " ,jumpUrl=" + str);
        return;
        if ((paramInt != 8) || (!RIJBiuAndCommentAladdinUtils.g()) || (TextUtils.isEmpty(paramArticleInfo.commentBtnJumpUrl))) {
          break label145;
        }
        str = paramArticleInfo.commentBtnJumpUrl;
        break;
        a(paramContext, str);
      }
      label145:
      str = "";
    }
  }
  
  public static void b(Context paramContext, String paramString)
  {
    Bundle localBundle = new Bundle();
    Object localObject;
    String str;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject = Uri.parse(paramString);
      if (TextUtils.isEmpty(((Uri)localObject).getPath())) {
        break label222;
      }
      if (((Uri)localObject).getPath().equals("/mqq/vue/wendadetail"))
      {
        localBundle = new Bundle();
        localBundle.putString("url", paramString);
        str = ((Uri)localObject).getQuery();
        localObject = "https://kandian.qq.com/viola/bundle_wendadetail.js?v_bid=3256&hideNav=1&statusColor=1";
        if (!TextUtils.isEmpty(str)) {
          localObject = "https://kandian.qq.com/viola/bundle_wendadetail.js?v_bid=3256&hideNav=1&statusColor=1" + "&" + str;
        }
        ViolaAccessHelper.a(paramContext, HardCodeUtil.a(2131712827), (String)localObject, localBundle, new RIJJumpUtils.1(paramContext, paramString));
      }
    }
    else
    {
      return;
    }
    if (((Uri)localObject).getPath().equals("/mqq/vue/wenda"))
    {
      localBundle = new Bundle();
      localBundle.putString("url", paramString);
      str = ((Uri)localObject).getQuery();
      localObject = "https://kandian.qq.com/viola/bundle_wenda.js?v_bid=3256&hideNav=1&statusColor=1";
      if (!TextUtils.isEmpty(str)) {
        localObject = "https://kandian.qq.com/viola/bundle_wenda.js?v_bid=3256&hideNav=1&statusColor=1" + "&" + str;
      }
      ViolaAccessHelper.a(paramContext, HardCodeUtil.a(2131712803), (String)localObject, localBundle, new RIJJumpUtils.2(paramContext, paramString));
      return;
    }
    label222:
    a(paramContext, paramString, localBundle);
  }
  
  public static boolean b(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = URLUtil.a(paramString);
      return (paramString != null) && ("5".equalsIgnoreCase((String)paramString.get("target")));
    }
    return false;
  }
  
  private static String c(ArticleInfo paramArticleInfo)
  {
    String str2 = "";
    String str1 = str2;
    if (paramArticleInfo.mSocialFeedInfo != null)
    {
      str1 = str2;
      if (paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser != null) {
        str1 = String.valueOf(paramArticleInfo.mSocialFeedInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructSocializeFeedsInfo$FeedsInfoUser.jdField_a_of_type_Long);
      }
    }
    return str1;
  }
  
  public static boolean c(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString))
    {
      bool1 = bool2;
      if (b(paramString))
      {
        bool1 = bool2;
        if (paramString.contains("needsconcat=1")) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean d(String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString))
    {
      paramString = Uri.parse(paramString);
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString.getHost()))
      {
        bool1 = bool2;
        if (paramString.getHost().equals("kandian.qq.com"))
        {
          bool1 = bool2;
          if (!TextUtils.isEmpty(paramString.getPath())) {
            if (!paramString.getPath().equals("/mqq/vue/wendadetail"))
            {
              bool1 = bool2;
              if (!paramString.getPath().equals("/mqq/vue/wenda")) {}
            }
            else
            {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJJumpUtils
 * JD-Core Version:    0.7.0.1
 */
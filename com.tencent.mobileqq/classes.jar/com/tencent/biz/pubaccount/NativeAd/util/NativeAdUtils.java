package com.tencent.biz.pubaccount.NativeAd.util;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.provider.Settings.Secure;
import android.text.TextUtils;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.dataline.util.DatalineMathUtil;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.pubaccount.Advertisement.util.PublicAccountAdUtil;
import com.tencent.biz.pubaccount.NativeAd.data.BannerInfo;
import com.tencent.biz.pubaccount.PublicAccountServlet;
import com.tencent.biz.pubaccount.VideoAdInfo;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AttachedAdData;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.WebSsoBody.WebSsoRequestBody;
import com.tencent.mobileqq.apollo.utils.ApolloGameBasicEventUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.vaswebviewplugin.QQWIFIPlugin;
import com.tencent.open.base.MD5Utils;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.open.downloadnew.DownloadInfo;
import com.tencent.open.downloadnew.DownloadListener;
import com.tencent.open.downloadnew.DownloadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tmassistant.aidl.TMAssistantDownloadTaskInfo;
import java.io.File;
import kzg;
import kzh;
import kzi;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.json.JSONException;
import org.json.JSONObject;

public class NativeAdUtils
{
  public static int a = 1;
  public static int b;
  public static int c;
  public static int d = 4;
  public static int e = 5;
  public static int f = 6;
  public static int g = 7;
  public static int h = 8;
  public static int i = 9;
  public static int j = 1;
  public static int k = 3;
  public static int l = 4;
  public static int m = 5;
  public static int n = 7;
  public static int o = 10;
  public static int p = 11;
  public static int q = 1;
  public static int r = 2;
  public static int s = 2;
  public static int t = 9;
  public static int u = 10;
  
  static
  {
    jdField_b_of_type_Int = 2;
    jdField_c_of_type_Int = 3;
  }
  
  public static int a(Context paramContext, BannerInfo paramBannerInfo)
  {
    if ((paramContext == null) || (paramBannerInfo == null)) {}
    do
    {
      DownloadInfo localDownloadInfo;
      do
      {
        do
        {
          return -1;
          paramContext = paramBannerInfo.f;
          paramBannerInfo = paramBannerInfo.d;
          if ((!TextUtils.isEmpty(paramContext)) && (!TextUtils.isEmpty(paramBannerInfo))) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("NativeAdUtils", 2, "isPkgDownloading pkg:" + paramContext + ", appid:" + paramBannerInfo + " false");
        return -1;
        localDownloadInfo = DownloadManager.a().a(paramBannerInfo);
        if (localDownloadInfo != null) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("NativeAdUtils", 2, "isPkgDownloading pkg:" + paramContext + ", appid:" + paramBannerInfo + " false");
      return -1;
      if (localDownloadInfo.a() == 2)
      {
        if (QLog.isColorLevel()) {
          QLog.d("NativeAdUtils", 2, "isPkgDownloading pkg:" + paramContext + ", appid:" + paramBannerInfo + " true");
        }
        return localDownloadInfo.g;
      }
    } while (!QLog.isColorLevel());
    QLog.d("NativeAdUtils", 2, "isPkgDownloading pkg:" + paramContext + ", appid:" + paramBannerInfo + " false");
    return -1;
  }
  
  public static Dialog a(Context paramContext, String paramString1, String paramString2, View.OnClickListener paramOnClickListener1, String paramString3, View.OnClickListener paramOnClickListener2, String paramString4)
  {
    paramContext = new Dialog(paramContext, 2131624516);
    paramContext.setContentView(2130968846);
    TextView localTextView = (TextView)paramContext.findViewById(2131364059);
    if (localTextView != null)
    {
      if (paramString1 != null) {
        localTextView.setText(paramString1);
      }
    }
    else
    {
      paramString1 = (TextView)paramContext.findViewById(2131362781);
      if (paramString1 != null)
      {
        if (paramString4 == null) {
          break label148;
        }
        paramString1.setText(paramString4);
      }
      label68:
      paramString1 = (TextView)paramContext.findViewById(2131364062);
      if (paramString1 != null)
      {
        if (paramString2 == null) {
          break label157;
        }
        paramString1.setText(paramString2);
        if (paramOnClickListener1 != null) {
          paramString1.setOnClickListener(paramOnClickListener1);
        }
      }
    }
    for (;;)
    {
      paramString1 = (TextView)paramContext.findViewById(2131364063);
      if (paramString1 != null)
      {
        if (paramString3 == null) {
          break label166;
        }
        paramString1.setText(paramString3);
        if (paramOnClickListener2 != null) {
          paramString1.setOnClickListener(paramOnClickListener2);
        }
      }
      return paramContext;
      localTextView.setVisibility(8);
      break;
      label148:
      paramString1.setVisibility(8);
      break label68;
      label157:
      paramString1.setVisibility(8);
    }
    label166:
    paramString1.setVisibility(8);
    return paramContext;
  }
  
  public static AdvertisementInfo a(VideoAdInfo paramVideoAdInfo)
  {
    AdvertisementInfo localAdvertisementInfo = new AdvertisementInfo();
    if (paramVideoAdInfo != null)
    {
      localAdvertisementInfo.mAdTraceId = paramVideoAdInfo.h;
      localAdvertisementInfo.mAdFetchTime = paramVideoAdInfo.a;
      localAdvertisementInfo.mAdViewId = paramVideoAdInfo.m;
      localAdvertisementInfo.mAdPosID = paramVideoAdInfo.jdField_b_of_type_Long;
      localAdvertisementInfo.mAdKdPos = paramVideoAdInfo.jdField_b_of_type_Int;
      localAdvertisementInfo.mAdProductId = paramVideoAdInfo.i;
      localAdvertisementInfo.mAdProductType = paramVideoAdInfo.jdField_c_of_type_Int;
      localAdvertisementInfo.mAdRl = paramVideoAdInfo.f;
    }
    return localAdvertisementInfo;
  }
  
  public static JSONObject a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("bt", paramInt1);
      localJSONObject.put("et", paramInt2);
      localJSONObject.put("bf", paramInt3);
      localJSONObject.put("ef", paramInt4);
      localJSONObject.put("pp", paramInt8);
      localJSONObject.put("pa", paramInt5);
      localJSONObject.put("pb", paramInt6);
      localJSONObject.put("duration", paramInt7);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return null;
  }
  
  private static JSONObject a(QQAppInterface paramQQAppInterface, AdData paramAdData, int paramInt1, int paramInt2)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("uin", paramQQAppInterface.getAccount());
      localJSONObject.put("ts", NetConnInfoCenter.getServerTimeMillis());
      localJSONObject.put("dinfo", b(paramQQAppInterface.getApplication().getApplicationContext()));
      localJSONObject.put("ver", "7.6.8");
      localJSONObject.put("type", paramInt1);
      localJSONObject.put("stype", paramInt2);
      localJSONObject.put("isdpg", 1);
      if (paramAdData != null)
      {
        if (paramInt1 == 1) {}
        for (paramQQAppInterface = paramAdData.e;; paramQQAppInterface = paramAdData.g)
        {
          localJSONObject.put("ext", paramQQAppInterface);
          localJSONObject.put("oudid", paramAdData.k);
          if (!(paramAdData instanceof AttachedAdData)) {
            break;
          }
          localJSONObject.put("aname", paramAdData.b);
          localJSONObject.put("posid", paramAdData.jdField_c_of_type_Int);
          return localJSONObject;
        }
        localJSONObject.put("aname", paramAdData.i);
        localJSONObject.put("posid", paramAdData.a);
        return localJSONObject;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
    return localJSONObject;
  }
  
  public static void a(Activity paramActivity, BannerInfo paramBannerInfo, DownloadListener paramDownloadListener)
  {
    if ((paramActivity == null) || (paramBannerInfo == null)) {}
    String str1;
    String str2;
    String str3;
    do
    {
      return;
      str1 = paramBannerInfo.f;
      str2 = paramBannerInfo.d;
      str3 = paramBannerInfo.j;
      paramBannerInfo = paramBannerInfo.i;
    } while ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str3)) || (TextUtils.isEmpty(paramBannerInfo)));
    Bundle localBundle = new Bundle();
    localBundle.putString(DownloadConstants.e, str1);
    localBundle.putString(DownloadConstants.a, str2);
    localBundle.putString(DownloadConstants.i, str3);
    localBundle.putString(DownloadConstants.k, paramBannerInfo);
    localBundle.putInt(DownloadConstants.j, 2);
    localBundle.putInt(DownloadConstants.D, 0);
    localBundle.putBoolean(DownloadConstants.w, false);
    localBundle.putInt(DownloadConstants.G, 0);
    localBundle.putBoolean(DownloadConstants.x, true);
    if (QLog.isColorLevel()) {
      QLog.d("NativeAdUtils", 2, "downloadApk pkg:" + str1 + ", appid:" + str2 + ", name:" + paramBannerInfo + ", url:" + str3);
    }
    if (paramDownloadListener != null) {
      DownloadManager.a().a(paramDownloadListener);
    }
    DownloadApi.a(paramActivity, localBundle, 0, null, 0);
  }
  
  public static void a(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdUtils", 2, "launchApp pkg:" + paramString);
      }
      paramString = paramContext.getPackageManager().getLaunchIntentForPackage(paramString);
    } while (paramString == null);
    paramContext.startActivity(paramString);
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext, int paramInt1, int paramInt2, AdvertisementInfo paramAdvertisementInfo, VideoAdInfo paramVideoAdInfo, long paramLong)
  {
    a(paramAppInterface, paramContext, paramInt1, paramInt2, paramAdvertisementInfo, paramVideoAdInfo, paramLong, null);
  }
  
  public static void a(AppInterface paramAppInterface, Context paramContext, int paramInt1, int paramInt2, AdvertisementInfo paramAdvertisementInfo, VideoAdInfo paramVideoAdInfo, long paramLong, JSONObject paramJSONObject)
  {
    if ((paramAppInterface == null) && (BaseApplicationImpl.sProcessId == 1))
    {
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().peekAppRuntime();
      if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
        paramAppInterface = (QQAppInterface)localAppRuntime;
      }
    }
    for (;;)
    {
      if (paramAppInterface == null) {
        return;
      }
      ThreadManager.post(new kzi(paramAppInterface.getAccount(), paramInt1, paramInt2, paramContext, paramAdvertisementInfo, paramVideoAdInfo, paramLong, paramJSONObject, paramAppInterface), 5, null, true);
      return;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, AdData paramAdData)
  {
    a(paramQQAppInterface, a(paramQQAppInterface, paramAdData, 5, 1).toString());
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdUtils", 2, "nativeEngineAdReport json:" + paramString);
      }
      if (!TextUtils.isEmpty(paramString))
      {
        WebSsoBody.WebSsoRequestBody localWebSsoRequestBody = new WebSsoBody.WebSsoRequestBody();
        localWebSsoRequestBody.data.set(paramString);
        paramString = new NewIntent(paramQQAppInterface.getApplication(), PublicAccountServlet.class);
        paramString.putExtra("cmd", "MQUpdateSvc_com_qq_mp.web.proxy.kandian_ad_report");
        paramString.putExtra("data", localWebSsoRequestBody.toByteArray());
        paramString.setObserver(new kzh());
        paramQQAppInterface.startServlet(paramString);
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("uin", paramQQAppInterface.c());
      localJSONObject.put("adId", paramString1);
      localJSONObject.put("channelId", paramString2);
      localJSONObject.put("info", paramString3);
      localJSONObject.put("version", "7.6.8");
      localJSONObject.put("actionCode", paramInt1);
      localJSONObject.put("subType", paramInt2);
      if (paramInt1 == 4) {
        localJSONObject.put("extValue", paramInt3);
      }
      paramString2 = localJSONObject.toString();
      if (QLog.isColorLevel()) {
        QLog.d("NativeAdUtils", 2, "doAdReport json:" + paramString2);
      }
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString1 = new WebSsoBody.WebSsoRequestBody();
        paramString1.data.set(paramString2);
        paramString2 = new NewIntent(paramQQAppInterface.getApplication(), PublicAccountServlet.class);
        paramString2.putExtra("cmd", "MQUpdateSvc_com_qq_mp.web.proxy.kandian_ad");
        paramString2.putExtra("data", paramString1.toByteArray());
        paramString2.setObserver(new kzg());
        paramQQAppInterface.startServlet(paramString2);
      }
      return;
    }
    catch (Exception paramQQAppInterface) {}
  }
  
  public static boolean a(Context paramContext, BannerInfo paramBannerInfo)
  {
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo1 = null;
    boolean bool3 = false;
    boolean bool1 = false;
    boolean bool2 = bool1;
    if (paramContext != null)
    {
      if (paramBannerInfo != null) {
        break label22;
      }
      bool2 = bool1;
    }
    label22:
    String str1;
    String str2;
    DownloadInfo localDownloadInfo;
    do
    {
      do
      {
        do
        {
          do
          {
            return bool2;
            str1 = paramBannerInfo.f;
            str2 = paramBannerInfo.d;
            bool2 = bool1;
          } while (TextUtils.isEmpty(str1));
          bool2 = bool1;
        } while (TextUtils.isEmpty(str2));
        localDownloadInfo = DownloadManager.a().a(str2);
        bool2 = bool1;
      } while (localDownloadInfo == null);
      paramBannerInfo = "";
      if (TextUtils.isEmpty(localDownloadInfo.k)) {
        break;
      }
      paramBannerInfo = localDownloadInfo.k;
      bool1 = bool3;
      if (!TextUtils.isEmpty(paramBannerInfo))
      {
        bool1 = bool3;
        if (new File(paramBannerInfo).exists()) {
          bool1 = true;
        }
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("NativeAdUtils", 2, "isPkgExist(" + bool1 + ") pkg:" + str1 + ", appid:" + str2 + ", path:" + paramBannerInfo);
    return bool1;
    TMAssistantDownloadTaskInfo localTMAssistantDownloadTaskInfo2;
    if (localDownloadInfo.jdField_c_of_type_Int == 0)
    {
      localTMAssistantDownloadTaskInfo2 = DownloadManager.a().a(localDownloadInfo.jdField_c_of_type_JavaLangString);
      paramContext = paramBannerInfo;
      if (localTMAssistantDownloadTaskInfo2 != null)
      {
        paramContext = paramBannerInfo;
        if (localTMAssistantDownloadTaskInfo2.mState == 4) {
          paramContext = localTMAssistantDownloadTaskInfo2.mSavePath;
        }
      }
      paramBannerInfo = paramContext;
      if (TextUtils.isEmpty(paramContext))
      {
        localTMAssistantDownloadTaskInfo1 = DownloadManager.a().a(localDownloadInfo);
        paramBannerInfo = paramContext;
      }
    }
    for (;;)
    {
      paramContext = paramBannerInfo;
      if (localTMAssistantDownloadTaskInfo1 != null)
      {
        paramContext = paramBannerInfo;
        if (localTMAssistantDownloadTaskInfo1.mState == 4) {
          paramContext = localTMAssistantDownloadTaskInfo1.mSavePath;
        }
      }
      paramBannerInfo = paramContext;
      if (TextUtils.isEmpty(paramContext)) {
        break;
      }
      localDownloadInfo.k = paramContext;
      localDownloadInfo.a(4);
      DownloadManager.a().e(localDownloadInfo);
      paramBannerInfo = paramContext;
      break;
      localTMAssistantDownloadTaskInfo2 = DownloadManager.a().a(localDownloadInfo);
      paramContext = paramBannerInfo;
      if (localTMAssistantDownloadTaskInfo2 != null)
      {
        paramContext = paramBannerInfo;
        if (localTMAssistantDownloadTaskInfo2.mState == 4) {
          paramContext = localTMAssistantDownloadTaskInfo2.mSavePath;
        }
      }
      paramBannerInfo = paramContext;
      if (TextUtils.isEmpty(paramContext))
      {
        localTMAssistantDownloadTaskInfo1 = DownloadManager.a().a(localDownloadInfo.jdField_c_of_type_JavaLangString);
        paramBannerInfo = paramContext;
      }
    }
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString))) {}
    do
    {
      return false;
      paramContext = paramContext.getPackageManager();
      try
      {
        paramContext.getPackageInfo(paramString, 0);
        if (QLog.isColorLevel()) {
          QLog.d("NativeAdUtils", 2, "isAppInstall pkg:" + paramString + " true");
        }
        return true;
      }
      catch (PackageManager.NameNotFoundException paramContext) {}
    } while (!QLog.isColorLevel());
    QLog.d("NativeAdUtils", 2, "isAppInstall pkg:" + paramString + " false");
    return false;
  }
  
  public static boolean a(BannerInfo paramBannerInfo)
  {
    String str1 = paramBannerInfo.f;
    String str2 = paramBannerInfo.d;
    String str3 = paramBannerInfo.j;
    paramBannerInfo = paramBannerInfo.i;
    Bundle localBundle = new Bundle();
    localBundle.putInt(DownloadConstants.j, 5);
    localBundle.putString(DownloadConstants.e, str1);
    localBundle.putString(DownloadConstants.a, str2);
    localBundle.putString(DownloadConstants.i, str3);
    localBundle.putString(DownloadConstants.k, paramBannerInfo);
    if (QLog.isColorLevel()) {
      QLog.d("NativeAdUtils", 2, "installApk pkg:" + str1 + ", appid:" + str2 + ", name:" + paramBannerInfo + ", url:" + str3);
    }
    return DownloadApi.a(localBundle);
  }
  
  private static JSONObject b(Context paramContext)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        localJSONObject.put("dma", DeviceInfoUtil.c(paramContext));
        localJSONObject.put("hwm", DeviceInfoUtil.j());
        localJSONObject.put("hwma", DeviceInfoUtil.i());
        localJSONObject.put("osver", DeviceInfoUtil.f());
        localJSONObject.put("imei", DeviceInfoUtil.a());
        localJSONObject.put("brd", DeviceInfoUtil.l());
        localJSONObject.put("ns", HttpUtil.a());
        localJSONObject.put("andid", Settings.Secure.getString(paramContext.getContentResolver(), "android_id"));
        localJSONObject.put("mid", "mid");
        localJSONObject.put("pf", "android");
        localJSONObject.put("wn", QQWIFIPlugin.getConnectedSsid(paramContext));
        str = "";
        switch (ApolloGameBasicEventUtil.b())
        {
        case 3: 
          localJSONObject.put("mnc", str);
          localJSONObject.put("rma", ReadInJoyUtils.a(paramContext));
          return localJSONObject;
        }
      }
      catch (JSONException paramContext)
      {
        paramContext.printStackTrace();
        return localJSONObject;
      }
      String str = "移动";
      continue;
      continue;
      str = "电信";
      continue;
      str = "联通";
    }
  }
  
  private static JSONObject b(AdvertisementInfo paramAdvertisementInfo, VideoAdInfo paramVideoAdInfo, long paramLong)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramAdvertisementInfo != null) {}
    try
    {
      localJSONObject.put("traceid", paramAdvertisementInfo.mAdTraceId);
      localJSONObject.put("pull_time", paramAdvertisementInfo.mAdFetchTime);
      localJSONObject.put("apurl", paramAdvertisementInfo.mAdApurl);
      localJSONObject.put("rl", paramAdvertisementInfo.mAdRl);
      localJSONObject.put("viewid", paramAdvertisementInfo.mAdViewId);
      localJSONObject.put("fb_type_id", paramLong);
      localJSONObject.put("posid", paramAdvertisementInfo.mAdPosID);
      localJSONObject.put("channel_id", paramAdvertisementInfo.mChannelID);
      localJSONObject.put("kd_pos", paramAdvertisementInfo.mAdKdPos);
      localJSONObject.put("cl", paramAdvertisementInfo.mAdCl);
      localJSONObject.put("pos_layout", paramAdvertisementInfo.mAdPosLayout);
      localJSONObject.put("product_id", paramAdvertisementInfo.mAdProductId);
      localJSONObject.put("product_type", paramAdvertisementInfo.mAdProductType);
      localJSONObject.put("ad_type", paramAdvertisementInfo.mAdType);
      localJSONObject.put("price", paramAdvertisementInfo.mAdPrice);
      localJSONObject.put("customized_invoke_url", paramAdvertisementInfo.mAdCustomizedInvokeUrl);
      localJSONObject.put("corporation_name", paramAdvertisementInfo.mAdCorporationName);
      localJSONObject.put("corporate_image_name", paramAdvertisementInfo.mAdCorporateImageName);
      localJSONObject.put("corporate_logo", paramAdvertisementInfo.mAdCorporateLogo);
      localJSONObject.put("ad_uin", paramAdvertisementInfo.mAdUin);
      localJSONObject.put("ext", paramAdvertisementInfo.mAdExt);
      localJSONObject.put("video_url", paramAdvertisementInfo.mVideoVid);
      localJSONObject.put("cost_type", paramAdvertisementInfo.mAdCostType);
      localJSONObject.put("aid", paramAdvertisementInfo.mAdAid);
      localJSONObject.put("img", paramAdvertisementInfo.mAdImg);
      localJSONObject.put("img_s", paramAdvertisementInfo.mAdImgs);
      localJSONObject.put("txt", paramAdvertisementInfo.mAdTxt);
      localJSONObject.put("desc", paramAdvertisementInfo.mAdDesc);
      localJSONObject.put("ad_layout", paramAdvertisementInfo.mAdLayout);
      localJSONObject.put("ad_material_id", paramAdvertisementInfo.mAdMaterialId);
      if (paramVideoAdInfo != null)
      {
        if (localJSONObject.isNull("apurl")) {
          localJSONObject.put("apurl", paramVideoAdInfo.g);
        }
        localJSONObject.put("via", paramVideoAdInfo.t);
        localJSONObject.put("dis_channel", paramVideoAdInfo.j);
        localJSONObject.put("button_url", paramVideoAdInfo.u);
      }
      return localJSONObject;
    }
    catch (JSONException paramAdvertisementInfo)
    {
      paramAdvertisementInfo.printStackTrace();
    }
    return localJSONObject;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, AdData paramAdData)
  {
    a(paramQQAppInterface, a(paramQQAppInterface, paramAdData, 1, 3).toString());
  }
  
  private static JSONObject c(Context paramContext)
  {
    JSONObject localJSONObject = new JSONObject();
    for (;;)
    {
      try
      {
        str1 = DeviceInfoUtil.a();
        str2 = DeviceInfoUtil.c(BaseApplication.getContext());
        if (!TextUtils.isEmpty(str1))
        {
          str1 = str1.toLowerCase();
          localJSONObject.put("muid", MD5Utils.d(str1).toLowerCase());
          localJSONObject.put("muid_type", 1);
          localJSONObject.put("conn", PublicAccountAdUtil.a());
          localJSONObject.put("wn", QQWIFIPlugin.getConnectedSsid(paramContext));
          i1 = 0;
        }
      }
      catch (JSONException paramContext)
      {
        String str1;
        String str2;
        int i1;
        int i2;
        paramContext.printStackTrace();
        return null;
      }
      try
      {
        i2 = DeviceInfoUtil.e();
        i1 = i2;
      }
      catch (Exception localException)
      {
        continue;
      }
      localJSONObject.put("carrier", i1);
      localJSONObject.put("os_ver", DeviceInfoUtil.f());
      localJSONObject.put("qq_ver", DeviceInfoUtil.d());
      localJSONObject.put("appid", String.valueOf(AppSetting.a));
      localJSONObject.put("client_ip", DatalineMathUtil.a(DatalineMathUtil.a()));
      localJSONObject.put("rma", ReadInJoyUtils.a(paramContext));
      localJSONObject.put("dma", DeviceInfoUtil.c(paramContext));
      localJSONObject.put("os_type", 2);
      localJSONObject.put("brd", DeviceInfoUtil.l());
      localJSONObject.put("hwm", DeviceInfoUtil.j());
      localJSONObject.put("hwma", DeviceInfoUtil.i());
      localJSONObject.put("imei", str1);
      localJSONObject.put("andid", Settings.Secure.getString(paramContext.getContentResolver(), "android_id"));
      return localJSONObject;
      if (!TextUtils.isEmpty(str2))
      {
        localJSONObject.put("muid", MD5Utils.d(str2.replaceAll(":", "").toUpperCase()).toLowerCase());
        localJSONObject.put("muid_type", 3);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils
 * JD-Core Version:    0.7.0.1
 */
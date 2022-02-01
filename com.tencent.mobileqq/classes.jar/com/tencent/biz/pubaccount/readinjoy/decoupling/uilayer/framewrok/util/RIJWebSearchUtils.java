package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.api.IPublicAccountReportUtils;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.FastWebActivity;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountConfigUtilImpl;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.home.impl.FrameControllerUtil;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.model.HotWordSearchEntryDataModel.HotSearchItem;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class RIJWebSearchUtils
{
  public static int a()
  {
    int i3 = 0;
    boolean bool = false;
    int i1 = 1024;
    int n = 100;
    int m = 2;
    int i = m;
    int k = n;
    int j = i1;
    if (!TextUtils.isEmpty(PublicAccountConfigUtilImpl.readInJoyPreloadToolConfig))
    {
      i = m;
      k = n;
      j = i1;
      i3 = bool;
    }
    long l2;
    for (;;)
    {
      try
      {
        JSONObject localJSONObject = new JSONObject(PublicAccountConfigUtilImpl.readInJoyPreloadToolConfig);
        i = m;
        k = n;
        j = i1;
        i3 = bool;
        bool = localJSONObject.optBoolean("useNewLogic", false);
        i = m;
        k = n;
        j = i1;
        i3 = bool;
        i1 = localJSONObject.optInt("minTotalMem", 1024);
        i = m;
        k = n;
        j = i1;
        i3 = bool;
        n = localJSONObject.optInt("minAvailableMem", 100);
        i = m;
        k = n;
        j = i1;
        i3 = bool;
        m = localJSONObject.optInt("minCpuNum", 2);
        i = m;
        k = n;
        j = i1;
        i3 = bool;
        int i2 = localJSONObject.optInt("minCpuFreq", 1000);
        i3 = bool;
        j = i1;
        k = n;
        i = m;
        m = i2;
        if (i3 == 0) {
          break label284;
        }
        long l1 = DeviceInfoUtil.a();
        l2 = DeviceInfoUtil.e();
        n = DeviceInfoUtil.b();
        long l3 = DeviceInfoUtil.b();
        if ((l1 >>> 20 < j) || (n < i) || (l3 < m)) {
          break;
        }
        return 1;
      }
      catch (Exception localException)
      {
        QLog.e("RIJWebSearchUtils", 2, localException.getMessage());
      }
      m = 1000;
    }
    if (l2 >>> 20 >= k) {
      return 2;
    }
    if (Build.VERSION.SDK_INT >= 19) {
      return 1;
    }
    return 0;
    label284:
    if (Build.VERSION.SDK_INT >= 19) {
      return 1;
    }
    return 0;
  }
  
  public static Intent a(Activity paramActivity, ArticleInfo paramArticleInfo, int paramInt, boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    localIntent.setClass(paramActivity, SplashActivity.class);
    localIntent.setFlags(67108864);
    localIntent.putExtra("tab_index", FrameControllerUtil.a);
    localIntent.putExtra("fragment_id", 1);
    localIntent.putExtra("banner_activityName", FastWebActivity.class.getName());
    localIntent.putExtra("banner_webViewUrl", paramArticleInfo.mArticleContentUrl);
    localIntent.putExtra("banner_wording", String.format(HardCodeUtil.a(2131713080), new Object[] { paramArticleInfo.mTitle }));
    paramActivity = paramArticleInfo.mArticleContentUrl;
    if (!TextUtils.isEmpty(paramActivity))
    {
      paramActivity = Uri.parse(paramActivity);
      if (paramActivity.isHierarchical()) {
        localIntent.putExtra("banner_businessCategory", "WebView_" + paramActivity.getHost());
      }
    }
    paramActivity = new Bundle();
    paramActivity.putParcelable("fast_web_article_info", paramArticleInfo);
    paramActivity.putInt("fast_web_banner_from_channel_id", (int)paramArticleInfo.mChannelID);
    paramActivity.putBoolean("fast_web_from_article_recommend", paramBoolean);
    localIntent.putExtra("banner_webview_extra", paramActivity);
    return localIntent;
  }
  
  public static void a(Activity paramActivity)
  {
    a(paramActivity, null);
  }
  
  public static void a(Activity paramActivity, HotWordSearchEntryDataModel.HotSearchItem paramHotSearchItem)
  {
    UniteSearchActivity.a(paramActivity, "", 25, 0L, paramHotSearchItem, 0);
    ((IPublicAccountReportUtils)QRoute.api(IPublicAccountReportUtils.class)).publicAccountReportClickEventForMigrate(null, "CliOper", "", "", "0X80067D3", "0X80067D3", 0, 0, "", "", "", RIJTransMergeKanDianReport.a(), false);
  }
  
  public static boolean a()
  {
    boolean bool = false;
    if (!TextUtils.isEmpty(PublicAccountConfigUtilImpl.readInJoyPreloadToolConfig)) {}
    try
    {
      bool = new JSONObject(PublicAccountConfigUtilImpl.readInJoyPreloadToolConfig).optBoolean("useNewLogic", false);
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("RIJWebSearchUtils", 2, localException.getMessage());
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJWebSearchUtils
 * JD-Core Version:    0.7.0.1
 */
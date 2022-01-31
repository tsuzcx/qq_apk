package com.tencent.biz.pubaccount.readinjoy.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.biz.pubaccount.PublicAccountReportUtils;
import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.common.WeishiReportUtil;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoVolumeControl;
import com.tencent.biz.pubaccount.subscript.SubscriptFeedsNewActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.readinjoy.ReadInJoyHelper;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;

public class ReadInJoyActivityHelper
{
  public static String a = "https://kandian.qq.com/mqq/html/settingInterest.html?_wv=1027&_bid=2378";
  
  public static Intent a(Context paramContext, int paramInt)
  {
    paramContext = new Intent(paramContext, SplashActivity.class);
    paramContext.putExtra("fragment_id", 1);
    paramContext.putExtra("readinjoy_tab_open_from", paramInt);
    paramContext.putExtra("tab_index", MainFragment.h);
    paramContext.setFlags(335544320);
    return paramContext;
  }
  
  public static Intent a(Context paramContext, int paramInt1, int paramInt2)
  {
    if (paramInt1 != -1) {}
    for (paramContext = new Intent(paramContext, ReadInJoyFeedsActivity.class);; paramContext = new Intent(paramContext, SubscriptFeedsNewActivity.class))
    {
      if (paramInt1 != -1) {
        paramContext.putExtra("readinjoy_show_tab", paramInt1);
      }
      if (paramInt2 != -1) {
        paramContext.putExtra("tab_tab_index", paramInt2);
      }
      return paramContext;
    }
  }
  
  public static void a(Context paramContext)
  {
    Object localObject = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    localObject = new Intent(paramContext, QQBrowserActivity.class);
    ((Intent)localObject).putExtra("url", a);
    ((Intent)localObject).putExtra("hide_operation_bar", true);
    ((Intent)localObject).putExtra("hide_more_button", true);
    paramContext.startActivity((Intent)localObject);
  }
  
  public static void a(Context paramContext, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    a(paramContext, paramInt1, paramString, paramInt2, paramInt3, null);
  }
  
  public static void a(Context paramContext, int paramInt1, String paramString, int paramInt2, int paramInt3, Map paramMap)
  {
    a(paramContext, paramInt1, paramString, paramInt2, paramInt3, paramMap, false);
  }
  
  public static void a(Context paramContext, int paramInt1, String paramString, int paramInt2, int paramInt3, Map paramMap, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramContext, ReadInJoyChannelActivity.class);
    localIntent.putExtra("channel_id", paramInt1);
    localIntent.putExtra("channel_name", paramString);
    localIntent.putExtra("channel_type", paramInt2);
    localIntent.putExtra("channel_from", paramInt3);
    localIntent.putExtra("is_channel_activity", true);
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      paramString = new ReadInJoyChannelActivity.SerializableMap();
      paramString.setMap(paramMap);
      localIntent.putExtra("channel_map_data", paramString);
    }
    if (paramBoolean) {
      localIntent.addFlags(67108864);
    }
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, int paramInt, Map paramMap)
  {
    a(paramContext, paramInt, paramMap, false);
  }
  
  public static void a(Context paramContext, int paramInt, Map paramMap, boolean paramBoolean)
  {
    WeishiReportUtil.b();
    a(paramContext, 40677, "微视", 7, paramInt, paramMap, paramBoolean);
  }
  
  public static void a(Context paramContext, BaseArticleInfo paramBaseArticleInfo1, BaseArticleInfo paramBaseArticleInfo2, boolean paramBoolean)
  {
    Intent localIntent = new Intent(paramContext, ReadInJoyChannelActivity.class);
    localIntent.putExtra("channel_id", 56);
    localIntent.putExtra("channel_name", "视频");
    localIntent.putExtra("channel_type", 3);
    localIntent.putExtra("channel_from", 1);
    localIntent.putExtra("is_channel_activity", true);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_ID", paramBaseArticleInfo2.mArticleID);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_ARTICLE_SEQ", paramBaseArticleInfo1.mRecommendSeq);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_FIRST_CREATED", true);
    localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_HIDE_REFRESH_HEADER", true);
    if (paramBaseArticleInfo1 != paramBaseArticleInfo2) {
      localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_TOW_VIDEO_ITEM_INDEX", 2);
    }
    for (;;)
    {
      localIntent.putExtra("is_need_show_animation_adapter", paramBoolean);
      paramContext.startActivity(localIntent);
      VideoReporter.a.put(ReadInJoyChannelActivity.class, VideoReporter.b());
      VideoVolumeControl.a().a(false, "jumpFromKandianFeed", 1);
      return;
      localIntent.putExtra("READINJOY_VIDEO_FORCE_INSERT_TOW_VIDEO_ITEM_INDEX", 1);
    }
  }
  
  public static void a(Context paramContext, List paramList, long paramLong, int paramInt)
  {
    Intent localIntent = new Intent(paramContext, ReadInJoyNewFeedsActivity.class);
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      localIntent.putExtra("subscription_all_article_id", (Serializable)paramList);
      QLog.i("ReadInJoyActivityHelper", 1, paramList.toString());
    }
    if (paramLong != -1L) {
      localIntent.putExtra("subscription_click_article_id", paramLong);
    }
    if (paramInt == 1) {
      localIntent.putExtra("from_search", true);
    }
    for (;;)
    {
      localIntent.putExtra("launch_from", paramInt);
      if (!(paramContext instanceof Activity)) {
        localIntent.setFlags(268435456);
      }
      paramContext.startActivity(localIntent);
      ((KandianMergeManager)BaseApplicationImpl.getApplication().getRuntime().getManager(161)).f();
      return;
      localIntent.putExtra("from_search", false);
    }
  }
  
  public static void a(Context paramContext, boolean paramBoolean)
  {
    Intent localIntent;
    if (paramBoolean)
    {
      localIntent = new Intent(paramContext, ReadInJoyMessagesActivity.class);
      localIntent.putExtra("shouldBackSelfAct", true);
    }
    for (;;)
    {
      if (!(paramContext instanceof Activity)) {
        localIntent.setFlags(268435456);
      }
      paramContext.startActivity(localIntent);
      return;
      localIntent = new Intent(paramContext, ReadInJoySelfActivity.class);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2)
  {
    Intent localIntent = new Intent(paramContext, ReadInJoyNewFeedsActivity.class);
    localIntent.putExtra("readinjoy_show_tab", 0);
    if (paramInt1 == 2) {
      localIntent.setFlags(131072);
    }
    if (paramInt2 != -1) {
      localIntent.putExtra("tab_tab_index", paramInt2);
    }
    if (ReadInJoyHelper.c(paramQQAppInterface)) {
      paramContext.startActivity(new Intent(paramContext, ReadInJoySettingActivity.class));
    }
    for (;;)
    {
      if ((paramInt2 == 0) && (!ReadInJoyHelper.h())) {
        ((KandianMergeManager)paramQQAppInterface.getManager(161)).f();
      }
      return;
      if (!ReadInJoyHelper.h()) {
        break;
      }
      paramContext.startActivity(a(paramContext, paramInt1));
    }
    if (paramInt1 == 1) {
      localIntent.putExtra("from_search", true);
    }
    for (;;)
    {
      localIntent.putExtra("launch_from", paramInt1);
      VideoVolumeControl.a().a(true, "init", 1);
      paramContext.startActivity(localIntent);
      break;
      if (paramInt1 == 9)
      {
        ReadInJoyUtils.b(true);
        localIntent.putExtra("from_lock_screen", true);
        QLog.d(ReadInJoyActivityHelper.class.getSimpleName(), 2, "start kandian activity, launch from lock screen");
      }
      else
      {
        localIntent.putExtra("from_search", false);
      }
    }
  }
  
  public static void b(Context paramContext)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", "https://kandian.qq.com/mqq/watchspot/sticker.html?_wwv=265&_wv=1027&_wvSb=0&_nav_titleclr=000000&_bid=3002");
    localIntent.putExtra("hide_operation_bar", true);
    localIntent.putExtra("hide_more_button", true);
    paramContext.startActivity(localIntent);
    PublicAccountReportUtils.a(null, "CliOper", "", "", "0X8008C89", "0X8008C89", 0, 0, "", "", "", ReadInJoyBaseDeliverActivity.a(), false);
  }
  
  public static void b(Context paramContext, int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    b(paramContext, paramInt1, paramString, paramInt2, paramInt3, null);
  }
  
  public static void b(Context paramContext, int paramInt1, String paramString, int paramInt2, int paramInt3, Map paramMap)
  {
    Intent localIntent = new Intent(paramContext, ReadInJoyVideoSubChannelActivity.class);
    localIntent.putExtra("channel_id", paramInt1);
    localIntent.putExtra("channel_name", paramString);
    localIntent.putExtra("channel_type", paramInt2);
    localIntent.putExtra("channel_from", paramInt3);
    if ((paramMap != null) && (!paramMap.isEmpty()))
    {
      paramString = new ReadInJoyChannelActivity.SerializableMap();
      paramString.setMap(paramMap);
      localIntent.putExtra("channel_map_data", paramString);
    }
    paramContext.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyActivityHelper
 * JD-Core Version:    0.7.0.1
 */
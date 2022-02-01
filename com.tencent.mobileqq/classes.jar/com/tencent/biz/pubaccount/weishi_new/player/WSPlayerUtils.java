package com.tencent.biz.pubaccount.weishi_new.player;

import NS_KING_SOCIALIZE_META.stMetaUgcVideoSeg;
import UserGrowth.stOpVideo;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import UserGrowth.stVideoTag;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout.LayoutParams;
import com.google.gson.Gson;
import com.tencent.biz.pubaccount.weishi_new.util.WSLog;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUIUtil;
import com.tencent.biz.pubaccount.weishi_new.util.WeishiUtils;
import com.tencent.open.base.MD5;
import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;

public class WSPlayerUtils
{
  public static int a = 20191226;
  public static final String b = String.valueOf(a);
  
  private static int a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      float f = paramInt2 / paramInt1;
      return (int)(WeishiUIUtil.c() * f);
    }
    return -1;
  }
  
  public static int a(Activity paramActivity, WSPlayerUtils.PlayerLayoutParams paramPlayerLayoutParams, WSPlayerUtils.OnCalculateLayoutListener paramOnCalculateLayoutListener)
  {
    return b(paramActivity, paramPlayerLayoutParams, new WSPlayerUtils.1(paramPlayerLayoutParams, paramOnCalculateLayoutListener));
  }
  
  public static int a(WSPlayerUtils.PlayerLayoutParams paramPlayerLayoutParams)
  {
    b(paramPlayerLayoutParams.a, 0);
    b(paramPlayerLayoutParams.b, a(paramPlayerLayoutParams.c, paramPlayerLayoutParams.d), 5);
    return 0;
  }
  
  public static long a(Properties paramProperties, String paramString)
  {
    if (paramProperties == null) {
      return 0L;
    }
    try
    {
      long l = Long.parseLong(paramProperties.getProperty(paramString));
      return l;
    }
    catch (Exception paramProperties)
    {
      paramProperties.printStackTrace();
    }
    return 0L;
  }
  
  public static WSVideoInfo a(stSimpleMetaFeed paramstSimpleMetaFeed)
  {
    WSVideoInfo localWSVideoInfo = new WSVideoInfo();
    Object localObject = paramstSimpleMetaFeed.video;
    localWSVideoInfo.a = paramstSimpleMetaFeed.id;
    localWSVideoInfo.e = paramstSimpleMetaFeed.video_url;
    localWSVideoInfo.g = paramstSimpleMetaFeed.feed_desc;
    int j = 0;
    if (localObject != null) {
      i = ((stMetaUgcVideoSeg)localObject).duration;
    } else {
      i = 0;
    }
    localWSVideoInfo.d = i;
    if (localObject != null) {
      i = paramstSimpleMetaFeed.video.width;
    } else {
      i = 0;
    }
    localWSVideoInfo.b = i;
    if (localObject != null) {
      i = paramstSimpleMetaFeed.video.height;
    } else {
      i = 0;
    }
    localWSVideoInfo.c = i;
    localWSVideoInfo.f = WeishiUtils.c(paramstSimpleMetaFeed, false);
    localWSVideoInfo.i = paramstSimpleMetaFeed.video_type;
    localWSVideoInfo.h = paramstSimpleMetaFeed.videoPoolType;
    if (paramstSimpleMetaFeed.poster != null) {
      localObject = paramstSimpleMetaFeed.poster.id;
    } else {
      localObject = "";
    }
    localWSVideoInfo.j = ((String)localObject);
    localWSVideoInfo.k = paramstSimpleMetaFeed.traceId;
    localWSVideoInfo.l = new Gson().toJson(paramstSimpleMetaFeed.map_ext);
    if (paramstSimpleMetaFeed.opVideo != null) {
      i = paramstSimpleMetaFeed.opVideo.videoType;
    } else {
      i = 0;
    }
    localWSVideoInfo.m = i;
    if (paramstSimpleMetaFeed.videoTag != null) {
      i = paramstSimpleMetaFeed.videoTag.tagId;
    } else {
      i = 0;
    }
    localWSVideoInfo.n = i;
    int i = j;
    if (paramstSimpleMetaFeed.bottomTag != null) {
      i = paramstSimpleMetaFeed.bottomTag.tagId;
    }
    localWSVideoInfo.o = i;
    return localWSVideoInfo;
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return " PLAY_STATE_UNKNOWN ";
    case 7: 
      return " PLAY_STATE_COMPLETE ";
    case 6: 
      return " PLAY_STATE_ERROR ";
    case 5: 
      return " PLAY_STATE_PAUSED ";
    case 4: 
      return " PLAY_STATE_BUFFERING ";
    case 3: 
      return " PLAY_STATE_PLAYING ";
    case 2: 
      return " PLAY_STATE_PREPARED ";
    case 1: 
      return " PLAY_STATE_PREPARING ";
    }
    return " PLAY_STATE_IDLE ";
  }
  
  @NonNull
  public static String a(@Nullable WSPlayerParam paramWSPlayerParam)
  {
    if ((paramWSPlayerParam != null) && (paramWSPlayerParam.c != null) && (paramWSPlayerParam.c.a != null)) {
      return paramWSPlayerParam.c.a;
    }
    return "";
  }
  
  public static Properties a(String paramString)
  {
    Properties localProperties = new Properties();
    try
    {
      localProperties.load(new StringReader(paramString));
      return localProperties;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static boolean a(@Nullable WSPlayerParam paramWSPlayerParam1, @Nullable WSPlayerParam paramWSPlayerParam2)
  {
    String str1 = a(paramWSPlayerParam1);
    paramWSPlayerParam1 = b(paramWSPlayerParam1);
    String str2 = a(paramWSPlayerParam2);
    paramWSPlayerParam2 = b(paramWSPlayerParam2);
    return (!TextUtils.isEmpty(str1)) && (str1.equals(str2)) && (!TextUtils.isEmpty(paramWSPlayerParam1)) && (paramWSPlayerParam1.equals(paramWSPlayerParam2));
  }
  
  private static int b(Activity paramActivity, WSPlayerUtils.PlayerLayoutParams paramPlayerLayoutParams, WSPlayerUtils.OnCalculateLayoutListener paramOnCalculateLayoutListener)
  {
    int i3 = WeishiUIUtil.c(paramActivity);
    int i4 = WeishiUIUtil.c();
    int m = WeishiUIUtil.a(paramActivity) + WeishiUIUtil.c;
    int n = i3 - m - paramPlayerLayoutParams.f;
    int i1 = n - paramPlayerLayoutParams.e;
    float f1;
    if ((paramPlayerLayoutParams.d > 0) && (paramPlayerLayoutParams.c > 0)) {
      f1 = paramPlayerLayoutParams.d / paramPlayerLayoutParams.c;
    } else {
      f1 = 0.0F;
    }
    float f3 = n;
    float f2 = i4;
    f3 /= f2;
    float f4 = i1 / f2;
    float f5 = 0.9F * f4;
    float f6 = 0.95F * f4;
    int i = paramPlayerLayoutParams.f;
    int i2 = 2;
    if (f1 > f3)
    {
      i = 1;
      j = i3 - paramPlayerLayoutParams.f;
    }
    int k;
    for (;;)
    {
      k = 0;
      break;
      if ((f1 > f4) && (f1 <= f3))
      {
        k = m;
        j = n;
        i = 2;
        break;
      }
      if ((f1 > f6) && (f1 <= f4))
      {
        i = 3;
        k = paramPlayerLayoutParams.e + m;
        j = i1;
        break;
      }
      if ((f1 > f5) && (f1 <= f6))
      {
        i = 4;
        j = (int)(f2 * f1);
        k = paramPlayerLayoutParams.e + m;
        break;
      }
      if (f1 <= f5)
      {
        if (f1 > 0.0F) {
          i = (int)(f2 * f1);
        } else {
          i = -1;
        }
        k = m;
        j = i;
        i = 5;
        break;
      }
      j = i3 - i;
      i = 0;
    }
    if (paramOnCalculateLayoutListener != null) {
      paramOnCalculateLayoutListener.a(k, j, i);
    }
    paramActivity = new StringBuilder();
    paramActivity.append("[WSPlayerUtils.java][setPlayerLayout] ratioType:");
    paramActivity.append(i);
    paramActivity.append(", videoRate:");
    paramActivity.append(f1);
    paramActivity.append(", h1Rate90f:");
    paramActivity.append(f5);
    paramActivity.append(", h1Rate95f:");
    paramActivity.append(f6);
    paramActivity.append(", h1Rate:");
    paramActivity.append(f4);
    paramActivity.append(", h2Rate:");
    paramActivity.append(f3);
    paramActivity.append(", videoWidth:");
    paramActivity.append(paramPlayerLayoutParams.c);
    paramActivity.append(", videoHeight:");
    paramActivity.append(paramPlayerLayoutParams.d);
    paramActivity.append(", h1:");
    paramActivity.append(i1);
    paramActivity.append(", h2:");
    paramActivity.append(n);
    paramActivity.append(", statusHeight:");
    paramActivity.append(m);
    paramActivity.append(", bottomBarHeight:");
    paramActivity.append(paramPlayerLayoutParams.f);
    paramActivity.append(", screenWidth:");
    paramActivity.append(i4);
    paramActivity.append(", screenHeight:");
    paramActivity.append(i3);
    paramActivity.append(", playerHeight:");
    paramActivity.append(j);
    WSLog.e("WSPlayerUtils", paramActivity.toString());
    int j = i2;
    if (i == 5) {
      j = 0;
    }
    return j;
  }
  
  public static int b(WSPlayerUtils.PlayerLayoutParams paramPlayerLayoutParams)
  {
    boolean bool = b(paramPlayerLayoutParams.c, paramPlayerLayoutParams.d);
    if (bool) {
      i = 1;
    } else {
      i = 5;
    }
    View localView = paramPlayerLayoutParams.a;
    int j = 0;
    b(localView, 0);
    b(paramPlayerLayoutParams.b, a(paramPlayerLayoutParams.c, paramPlayerLayoutParams.d), i);
    int i = j;
    if (bool) {
      i = 2;
    }
    return i;
  }
  
  @NonNull
  public static String b(@Nullable WSPlayerParam paramWSPlayerParam)
  {
    if ((paramWSPlayerParam != null) && (paramWSPlayerParam.c != null) && (paramWSPlayerParam.c.e != null)) {
      return paramWSPlayerParam.c.e;
    }
    return "";
  }
  
  public static String b(String paramString)
  {
    return MD5.b(paramString);
  }
  
  private static void b(View paramView, int paramInt)
  {
    if (paramView != null)
    {
      if (!(paramView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
        return;
      }
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      localLayoutParams.topMargin = paramInt;
      paramView.setLayoutParams(localLayoutParams);
    }
  }
  
  private static void b(View paramView, int paramInt1, int paramInt2)
  {
    if (paramView != null)
    {
      if (!(paramView.getLayoutParams() instanceof RelativeLayout.LayoutParams)) {
        return;
      }
      RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
      if (paramInt2 != 5) {
        paramInt1 = -1;
      }
      localLayoutParams.height = paramInt1;
      paramView.setLayoutParams(localLayoutParams);
    }
  }
  
  private static boolean b(int paramInt1, int paramInt2)
  {
    return (paramInt1 > 0) && (paramInt2 > 0) && (paramInt2 / paramInt1 > 1.555556F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerUtils
 * JD-Core Version:    0.7.0.1
 */
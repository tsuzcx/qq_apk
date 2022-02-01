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
  public static final String a;
  
  static
  {
    jdField_a_of_type_JavaLangString = String.valueOf(jdField_a_of_type_Int);
  }
  
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
    b(paramPlayerLayoutParams.jdField_a_of_type_AndroidViewView, 0);
    b(paramPlayerLayoutParams.jdField_b_of_type_AndroidViewView, a(paramPlayerLayoutParams.jdField_a_of_type_Int, paramPlayerLayoutParams.jdField_b_of_type_Int), 5);
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
    localWSVideoInfo.jdField_a_of_type_JavaLangString = paramstSimpleMetaFeed.id;
    localWSVideoInfo.jdField_b_of_type_JavaLangString = paramstSimpleMetaFeed.video_url;
    localWSVideoInfo.jdField_d_of_type_JavaLangString = paramstSimpleMetaFeed.feed_desc;
    int j = 0;
    if (localObject != null) {
      i = ((stMetaUgcVideoSeg)localObject).duration;
    } else {
      i = 0;
    }
    localWSVideoInfo.jdField_c_of_type_Int = i;
    if (localObject != null) {
      i = paramstSimpleMetaFeed.video.width;
    } else {
      i = 0;
    }
    localWSVideoInfo.jdField_a_of_type_Int = i;
    if (localObject != null) {
      i = paramstSimpleMetaFeed.video.height;
    } else {
      i = 0;
    }
    localWSVideoInfo.jdField_b_of_type_Int = i;
    localWSVideoInfo.jdField_c_of_type_JavaLangString = WeishiUtils.c(paramstSimpleMetaFeed, false);
    localWSVideoInfo.jdField_e_of_type_Int = paramstSimpleMetaFeed.video_type;
    localWSVideoInfo.jdField_d_of_type_Int = paramstSimpleMetaFeed.videoPoolType;
    if (paramstSimpleMetaFeed.poster != null) {
      localObject = paramstSimpleMetaFeed.poster.id;
    } else {
      localObject = "";
    }
    localWSVideoInfo.jdField_e_of_type_JavaLangString = ((String)localObject);
    localWSVideoInfo.jdField_f_of_type_JavaLangString = paramstSimpleMetaFeed.traceId;
    localWSVideoInfo.jdField_g_of_type_JavaLangString = new Gson().toJson(paramstSimpleMetaFeed.map_ext);
    if (paramstSimpleMetaFeed.opVideo != null) {
      i = paramstSimpleMetaFeed.opVideo.videoType;
    } else {
      i = 0;
    }
    localWSVideoInfo.jdField_f_of_type_Int = i;
    if (paramstSimpleMetaFeed.videoTag != null) {
      i = paramstSimpleMetaFeed.videoTag.tagId;
    } else {
      i = 0;
    }
    localWSVideoInfo.jdField_g_of_type_Int = i;
    int i = j;
    if (paramstSimpleMetaFeed.bottomTag != null) {
      i = paramstSimpleMetaFeed.bottomTag.tagId;
    }
    localWSVideoInfo.h = i;
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
    if ((paramWSPlayerParam != null) && (paramWSPlayerParam.a != null) && (paramWSPlayerParam.a.jdField_a_of_type_JavaLangString != null)) {
      return paramWSPlayerParam.a.jdField_a_of_type_JavaLangString;
    }
    return "";
  }
  
  public static String a(String paramString)
  {
    return MD5.a(paramString);
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
  
  private static boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt1 > 0) && (paramInt2 > 0) && (paramInt2 / paramInt1 > 1.555556F);
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
    int m = WeishiUIUtil.a(paramActivity) + WeishiUIUtil.jdField_c_of_type_Int;
    int n = i3 - m - paramPlayerLayoutParams.jdField_d_of_type_Int;
    int i1 = n - paramPlayerLayoutParams.jdField_c_of_type_Int;
    float f1;
    if ((paramPlayerLayoutParams.jdField_b_of_type_Int > 0) && (paramPlayerLayoutParams.jdField_a_of_type_Int > 0)) {
      f1 = paramPlayerLayoutParams.jdField_b_of_type_Int / paramPlayerLayoutParams.jdField_a_of_type_Int;
    } else {
      f1 = 0.0F;
    }
    float f3 = n;
    float f2 = i4;
    f3 /= f2;
    float f4 = i1 / f2;
    float f5 = 0.9F * f4;
    float f6 = 0.95F * f4;
    int i = paramPlayerLayoutParams.jdField_d_of_type_Int;
    int i2 = 2;
    if (f1 > f3)
    {
      i = 1;
      j = i3 - paramPlayerLayoutParams.jdField_d_of_type_Int;
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
        k = paramPlayerLayoutParams.jdField_c_of_type_Int + m;
        j = i1;
        break;
      }
      if ((f1 > f5) && (f1 <= f6))
      {
        i = 4;
        j = (int)(f2 * f1);
        k = paramPlayerLayoutParams.jdField_c_of_type_Int + m;
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
    paramActivity.append(paramPlayerLayoutParams.jdField_a_of_type_Int);
    paramActivity.append(", videoHeight:");
    paramActivity.append(paramPlayerLayoutParams.jdField_b_of_type_Int);
    paramActivity.append(", h1:");
    paramActivity.append(i1);
    paramActivity.append(", h2:");
    paramActivity.append(n);
    paramActivity.append(", statusHeight:");
    paramActivity.append(m);
    paramActivity.append(", bottomBarHeight:");
    paramActivity.append(paramPlayerLayoutParams.jdField_d_of_type_Int);
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
    boolean bool = a(paramPlayerLayoutParams.jdField_a_of_type_Int, paramPlayerLayoutParams.jdField_b_of_type_Int);
    if (bool) {
      i = 1;
    } else {
      i = 5;
    }
    View localView = paramPlayerLayoutParams.jdField_a_of_type_AndroidViewView;
    int j = 0;
    b(localView, 0);
    b(paramPlayerLayoutParams.jdField_b_of_type_AndroidViewView, a(paramPlayerLayoutParams.jdField_a_of_type_Int, paramPlayerLayoutParams.jdField_b_of_type_Int), i);
    int i = j;
    if (bool) {
      i = 2;
    }
    return i;
  }
  
  @NonNull
  public static String b(@Nullable WSPlayerParam paramWSPlayerParam)
  {
    if ((paramWSPlayerParam != null) && (paramWSPlayerParam.a != null) && (paramWSPlayerParam.a.jdField_b_of_type_JavaLangString != null)) {
      return paramWSPlayerParam.a.jdField_b_of_type_JavaLangString;
    }
    return "";
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerUtils
 * JD-Core Version:    0.7.0.1
 */
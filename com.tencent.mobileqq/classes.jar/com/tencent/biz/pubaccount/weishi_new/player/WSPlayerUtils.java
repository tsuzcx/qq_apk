package com.tencent.biz.pubaccount.weishi_new.player;

import NS_KING_SOCIALIZE_META.stMetaUgcVideoSeg;
import UserGrowth.stOpVideo;
import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stSimpleMetaPerson;
import UserGrowth.stVideoTag;
import android.app.Activity;
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
  public static int a;
  public static final String a;
  
  static
  {
    jdField_a_of_type_Int = 20191226;
    jdField_a_of_type_JavaLangString = String.valueOf(jdField_a_of_type_Int);
  }
  
  private static int a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      return -1;
    }
    return (int)(paramInt2 / paramInt1 * WeishiUIUtil.c());
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
    int j = 0;
    WSVideoInfo localWSVideoInfo = new WSVideoInfo();
    Object localObject = paramstSimpleMetaFeed.video;
    localWSVideoInfo.jdField_a_of_type_JavaLangString = paramstSimpleMetaFeed.id;
    localWSVideoInfo.jdField_b_of_type_JavaLangString = paramstSimpleMetaFeed.video_url;
    localWSVideoInfo.jdField_d_of_type_JavaLangString = paramstSimpleMetaFeed.feed_desc;
    if (localObject != null)
    {
      i = ((stMetaUgcVideoSeg)localObject).duration;
      localWSVideoInfo.jdField_c_of_type_Int = i;
      if (localObject == null) {
        break label223;
      }
      i = paramstSimpleMetaFeed.video.width;
      label70:
      localWSVideoInfo.jdField_a_of_type_Int = i;
      if (localObject == null) {
        break label228;
      }
      i = paramstSimpleMetaFeed.video.height;
      label88:
      localWSVideoInfo.jdField_b_of_type_Int = i;
      localWSVideoInfo.jdField_c_of_type_JavaLangString = WeishiUtils.b(paramstSimpleMetaFeed, false);
      localWSVideoInfo.jdField_e_of_type_Int = paramstSimpleMetaFeed.video_type;
      localWSVideoInfo.jdField_d_of_type_Int = paramstSimpleMetaFeed.videoPoolType;
      if (paramstSimpleMetaFeed.poster == null) {
        break label233;
      }
      localObject = paramstSimpleMetaFeed.poster.id;
      label137:
      localWSVideoInfo.jdField_e_of_type_JavaLangString = ((String)localObject);
      localWSVideoInfo.jdField_f_of_type_JavaLangString = paramstSimpleMetaFeed.traceId;
      localWSVideoInfo.jdField_g_of_type_JavaLangString = new Gson().toJson(paramstSimpleMetaFeed.map_ext);
      if (paramstSimpleMetaFeed.opVideo == null) {
        break label239;
      }
    }
    label223:
    label228:
    label233:
    label239:
    for (int i = paramstSimpleMetaFeed.opVideo.videoType;; i = 0)
    {
      localWSVideoInfo.jdField_f_of_type_Int = i;
      i = j;
      if (paramstSimpleMetaFeed.videoTag != null) {
        i = paramstSimpleMetaFeed.videoTag.tagId;
      }
      localWSVideoInfo.jdField_g_of_type_Int = i;
      return localWSVideoInfo;
      i = 0;
      break;
      i = 0;
      break label70;
      i = 0;
      break label88;
      localObject = "";
      break label137;
    }
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return " PLAY_STATE_UNKNOWN ";
    case 0: 
      return " PLAY_STATE_IDLE ";
    case 1: 
      return " PLAY_STATE_PREPARING ";
    case 2: 
      return " PLAY_STATE_PREPARED ";
    case 3: 
      return " PLAY_STATE_PLAYING ";
    case 5: 
      return " PLAY_STATE_PAUSED ";
    case 4: 
      return " PLAY_STATE_BUFFERING ";
    case 7: 
      return " PLAY_STATE_COMPLETE ";
    }
    return " PLAY_STATE_ERROR ";
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
  
  private static int b(Activity paramActivity, WSPlayerUtils.PlayerLayoutParams paramPlayerLayoutParams, WSPlayerUtils.OnCalculateLayoutListener paramOnCalculateLayoutListener)
  {
    int i2 = WeishiUIUtil.c(paramActivity);
    int i3 = WeishiUIUtil.c();
    int m = WeishiUIUtil.a(paramActivity) + WeishiUIUtil.jdField_c_of_type_Int;
    int n = i2 - m - paramPlayerLayoutParams.jdField_d_of_type_Int;
    int i1 = n - paramPlayerLayoutParams.jdField_c_of_type_Int;
    float f1;
    float f2;
    float f3;
    float f4;
    float f5;
    int k;
    int j;
    if ((paramPlayerLayoutParams.jdField_b_of_type_Int > 0) && (paramPlayerLayoutParams.jdField_a_of_type_Int > 0))
    {
      f1 = paramPlayerLayoutParams.jdField_b_of_type_Int / paramPlayerLayoutParams.jdField_a_of_type_Int;
      f2 = n / i3;
      f3 = i1 / i3;
      f4 = f3 * 0.9F;
      f5 = f3 * 0.95F;
      k = 0;
      j = i2 - paramPlayerLayoutParams.jdField_d_of_type_Int;
      i = 0;
      if (f1 <= f2) {
        break label350;
      }
      k = 1;
      j = i2 - paramPlayerLayoutParams.jdField_d_of_type_Int;
      i = 0;
    }
    label350:
    do
    {
      for (;;)
      {
        if (paramOnCalculateLayoutListener != null) {
          paramOnCalculateLayoutListener.a(i, j, k);
        }
        WSLog.e("WSPlayerUtils", "[WSPlayerUtils.java][setPlayerLayout] ratioType:" + k + ", videoRate:" + f1 + ", h1Rate90f:" + f4 + ", h1Rate95f:" + f5 + ", h1Rate:" + f3 + ", h2Rate:" + f2 + ", videoWidth:" + paramPlayerLayoutParams.jdField_a_of_type_Int + ", videoHeight:" + paramPlayerLayoutParams.jdField_b_of_type_Int + ", h1:" + i1 + ", h2:" + n + ", statusHeight:" + m + ", bottomBarHeight:" + paramPlayerLayoutParams.jdField_d_of_type_Int + ", screenWidth:" + i3 + ", screenHeight:" + i2 + ", playerHeight:" + j);
        if (k != 5) {
          break label489;
        }
        return 0;
        f1 = 0.0F;
        break;
        if ((f1 > f3) && (f1 <= f2))
        {
          j = n;
          k = 2;
          i = m;
        }
        else if ((f1 > f5) && (f1 <= f3))
        {
          i = paramPlayerLayoutParams.jdField_c_of_type_Int + m;
          k = 3;
          j = i1;
        }
        else
        {
          if ((f1 <= f4) || (f1 > f5)) {
            break label448;
          }
          k = 4;
          j = (int)(i3 * f1);
          i = paramPlayerLayoutParams.jdField_c_of_type_Int + m;
        }
      }
    } while (f1 > f4);
    label448:
    if (f1 > 0.0F) {}
    for (int i = (int)(i3 * f1);; i = -1)
    {
      k = 5;
      j = i;
      i = m;
      break;
    }
    label489:
    return 2;
  }
  
  public static int b(WSPlayerUtils.PlayerLayoutParams paramPlayerLayoutParams)
  {
    boolean bool = a(paramPlayerLayoutParams.jdField_a_of_type_Int, paramPlayerLayoutParams.jdField_b_of_type_Int);
    if (bool) {}
    for (int i = 1;; i = 5)
    {
      b(paramPlayerLayoutParams.jdField_a_of_type_AndroidViewView, 0);
      b(paramPlayerLayoutParams.jdField_b_of_type_AndroidViewView, a(paramPlayerLayoutParams.jdField_a_of_type_Int, paramPlayerLayoutParams.jdField_b_of_type_Int), i);
      if (!bool) {
        break;
      }
      return 2;
    }
    return 0;
  }
  
  private static void b(View paramView, int paramInt)
  {
    if ((paramView == null) || (!(paramView.getLayoutParams() instanceof RelativeLayout.LayoutParams))) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    localLayoutParams.topMargin = paramInt;
    paramView.setLayoutParams(localLayoutParams);
  }
  
  private static void b(View paramView, int paramInt1, int paramInt2)
  {
    if ((paramView == null) || (!(paramView.getLayoutParams() instanceof RelativeLayout.LayoutParams))) {
      return;
    }
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
    if (paramInt2 == 5) {}
    for (;;)
    {
      localLayoutParams.height = paramInt1;
      paramView.setLayoutParams(localLayoutParams);
      return;
      paramInt1 = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSPlayerUtils
 * JD-Core Version:    0.7.0.1
 */
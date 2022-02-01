package com.tencent.ad.tangram.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.support.annotation.Keep;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.ad.tangram.log.AdLog;
import java.text.DecimalFormat;

@Keep
public final class AdUIUtils
{
  private static final String TAG = "AdUIUtils";
  
  public static final int dp2px(float paramFloat, Resources paramResources)
  {
    if (paramFloat == 0.0F) {
      return 0;
    }
    return (int)(paramResources.getDisplayMetrics().density * paramFloat + 0.5F);
  }
  
  public static String formatNumberToChineseUnit(long paramLong)
  {
    try
    {
      Object localObject = new DecimalFormat("##0.00");
      if (paramLong == 0L) {
        return "";
      }
      if (paramLong < 10000.0D) {
        return String.valueOf(paramLong) + "次下载";
      }
      if (paramLong < 100000000.0D) {
        return ((DecimalFormat)localObject).format(paramLong / 10000.0D) + "万次下载";
      }
      localObject = ((DecimalFormat)localObject).format(paramLong / 100000000.0D) + "亿次下载";
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return "";
  }
  
  public static int formatStringToGravity(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      throw new Exception(paramString2 + " unknown gravity type");
    }
    paramString1 = paramString1.toUpperCase();
    int i = -1;
    switch (paramString1.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        throw new Exception(paramString2 + " unknown gravity type");
        if (paramString1.equals("CENTER"))
        {
          i = 0;
          continue;
          if (paramString1.equals("LEFT"))
          {
            i = 1;
            continue;
            if (paramString1.equals("RIGHT")) {
              i = 2;
            }
          }
        }
        break;
      }
    }
    return 17;
    return 8388611;
    return 8388613;
  }
  
  public static int formatStringToRelativeLayoutRule(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      throw new Exception(paramString2 + " unknown layout rule type");
    }
    int i = -1;
    switch (paramString1.hashCode())
    {
    }
    for (;;)
    {
      switch (i)
      {
      default: 
        throw new Exception(paramString2 + " unknown layout rule type");
        if (paramString1.equals("center"))
        {
          i = 0;
          continue;
          if (paramString1.equals("flex-start"))
          {
            i = 1;
            continue;
            if (paramString1.equals("flex-end")) {
              i = 2;
            }
          }
        }
        break;
      }
    }
    return 14;
    return 9;
    return 11;
  }
  
  public static Bitmap getBitmapFromString(String paramString)
  {
    try
    {
      if (!TextUtils.isEmpty(paramString))
      {
        paramString = Base64.decode(paramString, 0);
        if ((paramString != null) && (paramString.length > 0))
        {
          paramString = BitmapFactory.decodeByteArray(paramString, 0, paramString.length);
          return paramString;
        }
      }
    }
    catch (Throwable paramString)
    {
      AdLog.e("AdUIUtils", "getBitmapFromString error" + paramString);
    }
    return null;
  }
  
  public static String getFileSizeDesc(long paramLong)
  {
    if (paramLong < 1024L) {}
    try
    {
      return paramLong + "B";
    }
    catch (Exception localException)
    {
      Object localObject;
      double d1;
      double d2;
      localException.printStackTrace();
    }
    localObject = new DecimalFormat("##0.0");
    d1 = 1024.0D * 1024.0D;
    d2 = 1024.0D * d1;
    if (paramLong < d1) {
      return ((DecimalFormat)localObject).format(paramLong / 1024.0D) + "K";
    }
    if (paramLong < d2) {
      return ((DecimalFormat)localObject).format(paramLong / d1) + "M";
    }
    localObject = ((DecimalFormat)localObject).format(paramLong / d2) + "G";
    return localObject;
    return "";
  }
  
  public static int getPercentageFromString(String paramString1, String paramString2)
  {
    try
    {
      int i = Integer.parseInt(paramString1.substring(0, paramString1.length() - 1));
      return i;
    }
    catch (Exception paramString1)
    {
      throw new Exception(paramString2 + " unknown percent string");
    }
  }
  
  public static double getPercentageOfGlobalVisibleRect(View paramView)
  {
    if (paramView == null) {}
    Rect localRect;
    do
    {
      return 0.0D;
      localRect = new Rect();
    } while ((!paramView.getGlobalVisibleRect(localRect)) || (localRect.left >= getScreenWidth(paramView.getContext())) || (localRect.top >= getScreenHeight(paramView.getContext())) || (localRect.right <= 0) || (localRect.bottom <= 0));
    return 1.0D * localRect.width() * localRect.height() / (paramView.getWidth() * paramView.getHeight());
  }
  
  public static int getPhysicalScreenWidth(Context paramContext)
  {
    int i;
    if (paramContext == null)
    {
      AdLog.e("AdUIUtils", "getScreenWidth error");
      i = -2147483648;
    }
    int k;
    int j;
    do
    {
      return i;
      if ((paramContext.getResources() == null) || (paramContext.getResources().getDisplayMetrics() == null)) {
        break;
      }
      k = paramContext.getResources().getDisplayMetrics().widthPixels;
      j = paramContext.getResources().getDisplayMetrics().heightPixels;
      i = j;
    } while (k > j);
    return k;
  }
  
  public static int getPxFromString(String paramString1, String paramString2)
  {
    try
    {
      int i = Integer.parseInt(paramString1.substring(0, paramString1.length() - 2));
      return i;
    }
    catch (Exception paramString1)
    {
      throw new Exception(paramString2 + " unknown px string");
    }
  }
  
  public static int getScreenHeight(Context paramContext)
  {
    if (paramContext == null) {}
    while ((paramContext.getResources() == null) || (paramContext.getResources().getDisplayMetrics() == null))
    {
      AdLog.e("AdUIUtils", "getScreenHeight error");
      return -2147483648;
    }
    return paramContext.getResources().getDisplayMetrics().heightPixels;
  }
  
  public static int getScreenWidth(Context paramContext)
  {
    if (paramContext == null) {}
    while ((paramContext.getResources() == null) || (paramContext.getResources().getDisplayMetrics() == null))
    {
      AdLog.e("AdUIUtils", "getScreenWidth error");
      return -2147483648;
    }
    return paramContext.getResources().getDisplayMetrics().widthPixels;
  }
  
  public static int getValueDependsOnScreenWidth(Context paramContext, int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0) {
      return Double.valueOf(1.0D * paramInt2 * getPhysicalScreenWidth(paramContext) / paramInt1).intValue();
    }
    return 0;
  }
  
  public static int px2dp(Context paramContext, int paramInt)
  {
    if (paramContext == null) {}
    float f;
    do
    {
      do
      {
        return -2147483648;
      } while ((paramContext.getResources() == null) || (paramContext.getResources().getDisplayMetrics() == null));
      f = paramContext.getResources().getDisplayMetrics().density;
    } while (f <= 0.0F);
    return Math.round(paramInt / f);
  }
  
  public static final int px2sp(int paramInt, Context paramContext)
  {
    float f = paramContext.getResources().getDisplayMetrics().scaledDensity;
    return (int)(paramInt / f + 0.5F);
  }
  
  public static int rem2pxForXJNative(float paramFloat, Resources paramResources)
  {
    return (int)(paramResources.getDisplayMetrics().widthPixels / 10.0F * paramFloat);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.ad.tangram.util.AdUIUtils
 * JD-Core Version:    0.7.0.1
 */
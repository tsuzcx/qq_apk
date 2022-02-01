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
    return (int)(paramFloat * paramResources.getDisplayMetrics().density + 0.5F);
  }
  
  public static String formatNumberToChineseUnit(long paramLong)
  {
    try
    {
      Object localObject = new DecimalFormat("##0.00");
      if (paramLong == 0L) {
        return "";
      }
      double d = paramLong;
      if (d < 10000.0D)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(String.valueOf(paramLong));
        ((StringBuilder)localObject).append("次下载");
        localObject = ((StringBuilder)localObject).toString();
      }
      else
      {
        StringBuilder localStringBuilder;
        if (d < 100000000.0D)
        {
          localStringBuilder = new StringBuilder();
          Double.isNaN(d);
          d /= 10000.0D;
          localStringBuilder.append(((DecimalFormat)localObject).format(d));
          localStringBuilder.append("万次下载");
          localObject = localStringBuilder.toString();
        }
        else
        {
          localStringBuilder = new StringBuilder();
          Double.isNaN(d);
          d /= 100000000.0D;
          localStringBuilder.append(((DecimalFormat)localObject).format(d));
          localStringBuilder.append("亿次下载");
          localObject = localStringBuilder.toString();
        }
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      return "";
    }
    return localException;
  }
  
  public static int formatStringToGravity(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      paramString1 = paramString1.toUpperCase();
      int i = -1;
      int j = paramString1.hashCode();
      if (j != 2332679)
      {
        if (j != 77974012)
        {
          if ((j == 1984282709) && (paramString1.equals("CENTER"))) {
            i = 0;
          }
        }
        else if (paramString1.equals("RIGHT")) {
          i = 2;
        }
      }
      else if (paramString1.equals("LEFT")) {
        i = 1;
      }
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 2) {
            return 8388613;
          }
          paramString1 = new StringBuilder();
          paramString1.append(paramString2);
          paramString1.append(" unknown gravity type");
          throw new Exception(paramString1.toString());
        }
        return 8388611;
      }
      return 17;
    }
    paramString1 = new StringBuilder();
    paramString1.append(paramString2);
    paramString1.append(" unknown gravity type");
    throw new Exception(paramString1.toString());
  }
  
  public static int formatStringToRelativeLayoutRule(String paramString1, String paramString2)
  {
    if (!TextUtils.isEmpty(paramString1))
    {
      int i = -1;
      int j = paramString1.hashCode();
      if (j != -1364013995)
      {
        if (j != -46581362)
        {
          if ((j == 1742952711) && (paramString1.equals("flex-end"))) {
            i = 2;
          }
        }
        else if (paramString1.equals("flex-start")) {
          i = 1;
        }
      }
      else if (paramString1.equals("center")) {
        i = 0;
      }
      if (i != 0)
      {
        if (i != 1)
        {
          if (i == 2) {
            return 11;
          }
          paramString1 = new StringBuilder();
          paramString1.append(paramString2);
          paramString1.append(" unknown layout rule type");
          throw new Exception(paramString1.toString());
        }
        return 9;
      }
      return 14;
    }
    paramString1 = new StringBuilder();
    paramString1.append(paramString2);
    paramString1.append(" unknown layout rule type");
    throw new Exception(paramString1.toString());
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getBitmapFromString error");
      localStringBuilder.append(paramString);
      AdLog.e("AdUIUtils", localStringBuilder.toString());
    }
    return null;
  }
  
  public static String getFileSizeDesc(long paramLong)
  {
    if (paramLong < 1024L) {}
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("B");
      return ((StringBuilder)localObject).toString();
    }
    catch (Exception localException)
    {
      Object localObject;
      double d;
      StringBuilder localStringBuilder;
      localException.printStackTrace();
    }
    localObject = new DecimalFormat("##0.0");
    d = paramLong;
    if (d < 1048576.0D)
    {
      localStringBuilder = new StringBuilder();
      Double.isNaN(d);
      d /= 1024.0D;
      localStringBuilder.append(((DecimalFormat)localObject).format(d));
      localStringBuilder.append("K");
      return localStringBuilder.toString();
    }
    if (d < 1073741824.0D)
    {
      localStringBuilder = new StringBuilder();
      Double.isNaN(d);
      d /= 1048576.0D;
      localStringBuilder.append(((DecimalFormat)localObject).format(d));
      localStringBuilder.append("M");
      return localStringBuilder.toString();
    }
    localStringBuilder = new StringBuilder();
    Double.isNaN(d);
    d /= 1073741824.0D;
    localStringBuilder.append(((DecimalFormat)localObject).format(d));
    localStringBuilder.append("G");
    localObject = localStringBuilder.toString();
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
      label17:
      break label17;
    }
    paramString1 = new StringBuilder();
    paramString1.append(paramString2);
    paramString1.append(" unknown percent string");
    throw new Exception(paramString1.toString());
  }
  
  public static double getPercentageOfGlobalVisibleRect(View paramView)
  {
    if (paramView == null) {
      return 0.0D;
    }
    Rect localRect = new Rect();
    if (!paramView.getGlobalVisibleRect(localRect)) {
      return 0.0D;
    }
    if ((localRect.left < getScreenWidth(paramView.getContext())) && (localRect.top < getScreenHeight(paramView.getContext())) && (localRect.right > 0))
    {
      if (localRect.bottom <= 0) {
        return 0.0D;
      }
      double d1 = localRect.width();
      Double.isNaN(d1);
      double d2 = localRect.height();
      Double.isNaN(d2);
      double d3 = paramView.getWidth() * paramView.getHeight();
      Double.isNaN(d3);
      return d1 * 1.0D * d2 / d3;
    }
    return 0.0D;
  }
  
  public static int getPhysicalScreenWidth(Context paramContext)
  {
    if ((paramContext == null) || (paramContext.getResources() == null) || (paramContext.getResources().getDisplayMetrics() == null))
    {
      AdLog.e("AdUIUtils", "getScreenWidth error");
      return -2147483648;
    }
    int i = paramContext.getResources().getDisplayMetrics().widthPixels;
    int j = paramContext.getResources().getDisplayMetrics().heightPixels;
    if (i > j) {
      return j;
    }
    return i;
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
      label17:
      break label17;
    }
    paramString1 = new StringBuilder();
    paramString1.append(paramString2);
    paramString1.append(" unknown px string");
    throw new Exception(paramString1.toString());
  }
  
  public static int getScreenHeight(Context paramContext)
  {
    if ((paramContext == null) || (paramContext.getResources() == null) || (paramContext.getResources().getDisplayMetrics() == null))
    {
      AdLog.e("AdUIUtils", "getScreenHeight error");
      return -2147483648;
    }
    return paramContext.getResources().getDisplayMetrics().heightPixels;
  }
  
  public static int getScreenWidth(Context paramContext)
  {
    if ((paramContext == null) || (paramContext.getResources() == null) || (paramContext.getResources().getDisplayMetrics() == null))
    {
      AdLog.e("AdUIUtils", "getScreenWidth error");
      return -2147483648;
    }
    return paramContext.getResources().getDisplayMetrics().widthPixels;
  }
  
  public static int getValueDependsOnScreenWidth(Context paramContext, int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      double d1 = paramInt2;
      Double.isNaN(d1);
      double d2 = getPhysicalScreenWidth(paramContext);
      Double.isNaN(d2);
      double d3 = paramInt1;
      Double.isNaN(d3);
      return Double.valueOf(d1 * 1.0D * d2 / d3).intValue();
    }
    return 0;
  }
  
  public static int px2dp(Context paramContext, int paramInt)
  {
    float f;
    if ((paramContext != null) && (paramContext.getResources() != null) && (paramContext.getResources().getDisplayMetrics() != null))
    {
      f = paramContext.getResources().getDisplayMetrics().density;
      if (f > 0.0F) {}
    }
    else
    {
      return -2147483648;
    }
    return Math.round(paramInt / f);
  }
  
  public static final int px2sp(int paramInt, Context paramContext)
  {
    float f = paramContext.getResources().getDisplayMetrics().scaledDensity;
    return (int)(paramInt / f + 0.5F);
  }
  
  public static int rem2pxForXJNative(float paramFloat, Resources paramResources)
  {
    return (int)(paramFloat * (paramResources.getDisplayMetrics().widthPixels / 10.0F));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.tangram.util.AdUIUtils
 * JD-Core Version:    0.7.0.1
 */
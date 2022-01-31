package com.tencent.ad.tangram.canvas.views;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.ad.tangram.log.AdLog;
import java.text.DecimalFormat;

public class a
{
  private static final String TAG = "AdUIUtils";
  
  public static final int dp2px(float paramFloat, Resources paramResources)
  {
    if (paramFloat == 0.0F) {
      return 0;
    }
    return (int)(paramResources.getDisplayMetrics().density * paramFloat + 0.5F);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.canvas.views.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.gdtad.views;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Build.VERSION;
import android.support.annotation.ColorInt;
import android.support.annotation.IntRange;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;

public class GdtUIUtils
{
  private static int a;
  private static int b;
  
  public static double a(View paramView)
  {
    if (paramView == null) {
      return 0.0D;
    }
    Rect localRect = new Rect();
    if (!paramView.getGlobalVisibleRect(localRect)) {
      return 0.0D;
    }
    if ((localRect.left < b(paramView.getContext())) && (localRect.top < c(paramView.getContext())) && (localRect.right > 0))
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
  
  public static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return Math.max(paramFloat1, Math.min(paramFloat2, paramFloat3));
  }
  
  public static final int a(float paramFloat, Resources paramResources)
  {
    if (paramFloat == 0.0F) {
      return 0;
    }
    return (int)(paramFloat * paramResources.getDisplayMetrics().density + 0.5F);
  }
  
  public static int a(@ColorInt int paramInt1, @IntRange(from=0L, to=255L) int paramInt2)
  {
    return paramInt1 & 0xFFFFFF | paramInt2 << 24;
  }
  
  public static int a(int paramInt1, int paramInt2, int paramInt3)
  {
    double d1 = paramInt1;
    Double.isNaN(d1);
    double d2 = paramInt3;
    Double.isNaN(d2);
    double d3 = paramInt2;
    Double.isNaN(d3);
    return Double.valueOf(d1 * 1.0D * d2 / d3).intValue();
  }
  
  private static int a(Activity paramActivity)
  {
    return b(paramActivity);
  }
  
  public static int a(Context paramContext)
  {
    if ((paramContext != null) && (paramContext.getResources() != null) && (paramContext.getResources().getConfiguration() != null)) {
      return paramContext.getResources().getConfiguration().orientation;
    }
    return 0;
  }
  
  public static int a(Context paramContext, int paramInt1, int paramInt2)
  {
    int i = a(paramContext);
    int j = 0;
    if (i == 1) {
      i = b(paramContext);
    } else if (a(paramContext) == 2) {
      i = c(paramContext);
    } else {
      i = 0;
    }
    if (paramInt1 != 0)
    {
      double d1 = paramInt2;
      Double.isNaN(d1);
      double d2 = i;
      Double.isNaN(d2);
      double d3 = paramInt1;
      Double.isNaN(d3);
      j = Double.valueOf(d1 * 1.0D * d2 / d3).intValue();
    }
    return j;
  }
  
  public static Drawable a(@ColorInt int paramInt1, int paramInt2, int paramInt3)
  {
    int i = Math.max(paramInt2, 2);
    PaintDrawable localPaintDrawable = new PaintDrawable();
    localPaintDrawable.setShape(new RectShape());
    int[] arrayOfInt = new int[i];
    int j = Color.alpha(paramInt1);
    paramInt2 = 0;
    float f4;
    float f5;
    for (;;)
    {
      f4 = 0.0F;
      f5 = 0.0F;
      if (paramInt2 >= i) {
        break;
      }
      f1 = a(0.0F, 1.0F, (float)Math.pow(paramInt2 * 1.0F / (i - 1), 3.0D));
      arrayOfInt[paramInt2] = a(paramInt1, (int)(j * f1));
      paramInt2 += 1;
    }
    paramInt1 = paramInt3 & 0x7;
    if (paramInt1 != 3) {
      if (paramInt1 == 5) {}
    }
    float f2;
    float f3;
    for (float f1 = 0.0F;; f1 = 1.0F)
    {
      f2 = 0.0F;
      f3 = f1;
      break;
      f3 = 0.0F;
      f2 = 1.0F;
      break;
    }
    paramInt1 = paramInt3 & 0x70;
    if (paramInt1 != 48) {
      if (paramInt1 == 80) {}
    }
    for (f1 = f5;; f1 = 1.0F)
    {
      f4 = 0.0F;
      break;
      f5 = 1.0F;
      f1 = f4;
      f4 = f5;
      break;
    }
    localPaintDrawable.setShaderFactory(new GdtUIUtils.1(f3, f1, f2, f4, arrayOfInt));
    return localPaintDrawable;
  }
  
  public static String a(long paramLong)
  {
    long l2 = paramLong / 1000L;
    paramLong = l2 % 60L;
    long l1 = l2 / 60L % 60L;
    l2 /= 3600L;
    if (l2 > 0L) {
      return String.format("%d:%02d:%02d", new Object[] { Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(paramLong) }).toString();
    }
    return String.format("%02d:%02d", new Object[] { Long.valueOf(l1), Long.valueOf(paramLong) }).toString();
  }
  
  public static void a(Activity paramActivity)
  {
    if (LiuHaiUtils.enableNotch(paramActivity))
    {
      a(paramActivity);
      GdtLog.a("GdtUIUtils", "enableNotch && updateLiuhaiTopHeight 0");
    }
  }
  
  public static void a(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (ThemeUtil.isNowThemeIsNight(null, false, null))
    {
      paramView.setVisibility(0);
      return;
    }
    paramView.setVisibility(8);
  }
  
  public static void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramView == null) {
      return;
    }
    ((View)paramView.getParent()).post(new GdtUIUtils.2(paramView, paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  public static void a(FrameLayout paramFrameLayout)
  {
    if ((paramFrameLayout != null) && (ThemeUtil.isNowThemeIsNight(null, false, null))) {
      paramFrameLayout.setForeground(new ColorDrawable(1996488704));
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt == 185) || (paramInt == 585);
  }
  
  public static boolean a(Activity paramActivity)
  {
    LiuHaiUtils.a(paramActivity);
    paramActivity = new StringBuilder();
    paramActivity.append("hasTopLiuHai  ");
    paramActivity.append(LiuHaiUtils.a);
    GdtLog.a("GdtUIUtils", paramActivity.toString());
    return LiuHaiUtils.a;
  }
  
  @TargetApi(17)
  public static int[] a(Activity paramActivity)
  {
    if (paramActivity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GdtUIUtils", 2, "getPortraitScreenSize ERROR activity == null");
      }
      return new int[] { 0, 0 };
    }
    if ((a == 0) || (b == 0))
    {
      Object localObject = ((WindowManager)paramActivity.getSystemService("window")).getDefaultDisplay();
      Point localPoint = new Point();
      if (Build.VERSION.SDK_INT >= 17)
      {
        ((Display)localObject).getRealSize(localPoint);
        a = localPoint.x;
        b = localPoint.y;
      }
      else if (Build.VERSION.SDK_INT >= 15)
      {
        ((Display)localObject).getSize(localPoint);
        a = localPoint.x;
        b = localPoint.y;
      }
      else
      {
        localObject = new DisplayMetrics();
        paramActivity.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
        a = ((DisplayMetrics)localObject).widthPixels;
        b = ((DisplayMetrics)localObject).heightPixels;
      }
    }
    if (QLog.isColorLevel())
    {
      paramActivity = new StringBuilder();
      paramActivity.append("getPortraitScreenSize screenWidth=");
      paramActivity.append(a);
      paramActivity.append(", screenHeight=");
      paramActivity.append(b);
      QLog.d("GdtUIUtils", 2, paramActivity.toString());
    }
    int i = b;
    int j = a;
    if (i < j) {
      return new int[] { i, j };
    }
    return new int[] { j, i };
  }
  
  private static int b(Activity paramActivity)
  {
    int i = Build.VERSION.SDK_INT;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getNotchInScreenHeight apiVersion: ");
      localStringBuilder.append(i);
      QLog.i("GdtUIUtils", 1, localStringBuilder.toString());
    }
    if (i > 27) {
      return LiuHaiUtils.a(paramActivity);
    }
    return LiuHaiUtils.b(paramActivity);
  }
  
  public static int b(Context paramContext)
  {
    if ((paramContext == null) || (paramContext.getResources() == null) || (paramContext.getResources().getDisplayMetrics() == null))
    {
      GdtLog.d("GdtUIUtils", "getScreenWidth error");
      return -2147483648;
    }
    return paramContext.getResources().getDisplayMetrics().widthPixels;
  }
  
  public static int c(Context paramContext)
  {
    if ((paramContext == null) || (paramContext.getResources() == null) || (paramContext.getResources().getDisplayMetrics() == null))
    {
      GdtLog.d("GdtUIUtils", "getScreenHeight error");
      return -2147483648;
    }
    return paramContext.getResources().getDisplayMetrics().heightPixels;
  }
  
  public static int d(Context paramContext)
  {
    int i;
    if ((paramContext != null) && ((paramContext instanceof Activity)))
    {
      paramContext = a((Activity)paramContext);
      i = Math.max(paramContext[0], paramContext[1]);
    }
    else
    {
      i = 1920;
    }
    int j = i;
    if (i <= 0) {
      j = 1920;
    }
    return j;
  }
  
  public static int e(Context paramContext)
  {
    int i;
    if ((paramContext != null) && ((paramContext instanceof Activity)))
    {
      paramContext = a((Activity)paramContext);
      i = Math.min(paramContext[0], paramContext[1]);
    }
    else
    {
      i = 1080;
    }
    int j = i;
    if (i <= 0) {
      j = 1080;
    }
    return j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.views.GdtUIUtils
 * JD-Core Version:    0.7.0.1
 */
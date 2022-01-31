package com.tencent.gdtad.views;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import qle;

public class GdtUIUtils
{
  private static int a;
  private static int b;
  
  public static double a(View paramView)
  {
    if (paramView == null) {}
    Rect localRect;
    do
    {
      return 0.0D;
      localRect = new Rect();
    } while ((!paramView.getGlobalVisibleRect(localRect)) || (localRect.left >= ViewUtils.a()) || (localRect.top >= ViewUtils.c()) || (localRect.right <= 0) || (localRect.bottom <= 0));
    return 1.0D * localRect.width() * localRect.height() / (paramView.getWidth() * paramView.getHeight());
  }
  
  public static final int a(float paramFloat, Resources paramResources)
  {
    if (paramFloat == 0.0F) {
      return 0;
    }
    return (int)(paramResources.getDisplayMetrics().density * paramFloat + 0.5F);
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
  
  public static void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramView == null) {
      return;
    }
    ((View)paramView.getParent()).post(new qle(paramView, paramInt1, paramInt2, paramInt3, paramInt4));
  }
  
  @TargetApi(17)
  public static int[] a(Activity paramActivity)
  {
    if (paramActivity == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GdtVideoCommonView", 2, "getScreenSize() ERROR activity == null");
      }
      return new int[] { 0, 0 };
    }
    Object localObject;
    Point localPoint;
    if ((a == 0) && (b == 0))
    {
      localObject = ((WindowManager)paramActivity.getSystemService("window")).getDefaultDisplay();
      localPoint = new Point();
      if (Build.VERSION.SDK_INT < 17) {
        break label161;
      }
      ((Display)localObject).getRealSize(localPoint);
      a = localPoint.x;
      b = localPoint.y;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GdtVideoCommonView", 2, "getScreenSize() screenWidth=" + a + ", screenHeight=" + b);
      }
      if (b >= a) {
        break;
      }
      return new int[] { b, a };
      label161:
      if (Build.VERSION.SDK_INT >= 15)
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
    return new int[] { a, b };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.gdtad.views.GdtUIUtils
 * JD-Core Version:    0.7.0.1
 */
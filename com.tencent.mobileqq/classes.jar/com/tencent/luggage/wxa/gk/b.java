package com.tencent.luggage.wxa.gk;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.NonNull;

public class b
{
  private static float a = -1.0F;
  
  public static float a(@NonNull Context paramContext)
  {
    if (a < 0.0F) {
      a = paramContext.getResources().getDisplayMetrics().density;
    }
    return a;
  }
  
  public static int a(@NonNull Context paramContext, int paramInt)
  {
    return (int)Math.ceil(paramInt / a(paramContext));
  }
  
  @NonNull
  public static Point b(@NonNull Context paramContext)
  {
    WindowManager localWindowManager = (WindowManager)paramContext.getSystemService("window");
    Point localPoint = new Point();
    if (localWindowManager != null)
    {
      localWindowManager.getDefaultDisplay().getRealSize(localPoint);
      if ((localPoint.x != 0) && (localPoint.y != 0)) {
        return localPoint;
      }
    }
    localPoint.x = paramContext.getResources().getDisplayMetrics().widthPixels;
    localPoint.y = paramContext.getResources().getDisplayMetrics().heightPixels;
    return localPoint;
  }
  
  @NonNull
  public static Point c(@NonNull Context paramContext)
  {
    Point localPoint = b(paramContext);
    localPoint.x = a(paramContext, localPoint.x);
    localPoint.y = a(paramContext, localPoint.y);
    return localPoint;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.gk.b
 * JD-Core Version:    0.7.0.1
 */
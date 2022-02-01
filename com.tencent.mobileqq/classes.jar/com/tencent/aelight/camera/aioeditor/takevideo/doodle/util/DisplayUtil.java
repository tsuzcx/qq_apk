package com.tencent.aelight.camera.aioeditor.takevideo.doodle.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Point;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.provider.Settings.System;
import android.support.annotation.NonNull;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.common.app.BaseApplicationImpl;
import java.lang.reflect.Method;

@TargetApi(14)
public class DisplayUtil
{
  public static int a;
  public static int b;
  
  public static float a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt2 < paramInt4) {
      return 1.0F;
    }
    return paramInt4 / paramInt2;
  }
  
  public static int a()
  {
    return b(BaseApplicationImpl.getApplication().getBaseContext(), 30.0F);
  }
  
  public static int a(Context paramContext)
  {
    int i = a;
    if (i > 0) {
      return i;
    }
    paramContext = (WindowManager)paramContext.getSystemService("window");
    if (Build.VERSION.SDK_INT >= 13)
    {
      Point localPoint = new Point();
      paramContext.getDefaultDisplay().getSize(localPoint);
      a = localPoint.x;
    }
    else
    {
      a = paramContext.getDefaultDisplay().getWidth();
    }
    return a;
  }
  
  public static int a(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat / paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  public static void a(Canvas paramCanvas, GestureHelper paramGestureHelper, GestureHelper.ZoomItem paramZoomItem, int paramInt1, int paramInt2, int paramInt3)
  {
    float f1 = a() / paramZoomItem.d();
    paramCanvas.concat(paramGestureHelper.c(paramZoomItem));
    int i = (int)(paramZoomItem.G * paramZoomItem.B * paramZoomItem.K) + paramZoomItem.N * 2;
    int j = (int)(paramZoomItem.H * paramZoomItem.B * paramZoomItem.K) + paramZoomItem.N * 2;
    float f3 = -i * 1.0F / 2.0F;
    float f2 = -j;
    paramCanvas.translate(f3, f2 * 1.0F / 2.0F);
    paramGestureHelper = new Paint();
    paramGestureHelper.setStyle(Paint.Style.STROKE);
    paramGestureHelper.setColor(BaseApplicationImpl.getApplication().getResources().getColor(2131168485));
    paramGestureHelper.setStrokeWidth(b(BaseApplicationImpl.getApplication().getBaseContext(), 1.0F));
    int k = b(BaseApplicationImpl.getApplication().getBaseContext(), 3.0F);
    f3 = i;
    float f4 = j;
    paramZoomItem = new RectF(0.0F, 0.0F, f3, f4);
    float f5 = k;
    paramCanvas.drawRoundRect(paramZoomItem, f5, f5, paramGestureHelper);
    f5 = -f1 / 2.0F;
    paramCanvas.translate(f5, f5);
    if (paramInt1 > 0)
    {
      paramGestureHelper = BaseApplicationImpl.getApplication().getResources().getDrawable(paramInt1);
      paramInt1 = (int)f1;
      paramGestureHelper.setBounds(0, 0, paramInt1, paramInt1);
      paramGestureHelper.draw(paramCanvas);
    }
    paramCanvas.translate(f3, f4);
    if (paramInt3 > 0)
    {
      paramGestureHelper = BaseApplicationImpl.getApplication().getResources().getDrawable(paramInt3);
      paramInt1 = (int)f1;
      paramGestureHelper.setBounds(0, 0, paramInt1, paramInt1);
      paramGestureHelper.draw(paramCanvas);
    }
    paramCanvas.translate(0.0F, f2);
    if (paramInt2 > 0)
    {
      paramGestureHelper = BaseApplicationImpl.getApplication().getResources().getDrawable(paramInt2);
      paramInt1 = (int)f1;
      paramGestureHelper.setBounds(0, 0, paramInt1, paramInt1);
      paramGestureHelper.draw(paramCanvas);
    }
  }
  
  public static int b(Context paramContext)
  {
    int i = b;
    if (i > 0) {
      return i;
    }
    paramContext = (WindowManager)paramContext.getSystemService("window");
    if (Build.VERSION.SDK_INT >= 13)
    {
      Point localPoint = new Point();
      paramContext.getDefaultDisplay().getSize(localPoint);
      b = localPoint.y;
    }
    else
    {
      b = paramContext.getDefaultDisplay().getHeight();
    }
    return b;
  }
  
  public static int b(Context paramContext, float paramFloat)
  {
    return (int)(paramFloat * paramContext.getResources().getDisplayMetrics().density + 0.5F);
  }
  
  public static boolean c(@NonNull Context paramContext)
  {
    Object localObject = paramContext.getResources();
    int i = ((Resources)localObject).getIdentifier("config_showNavigationBar", "bool", "android");
    boolean bool1;
    if (i > 0) {
      bool1 = ((Resources)localObject).getBoolean(i);
    } else {
      bool1 = false;
    }
    try
    {
      localObject = Class.forName("android.os.SystemProperties");
      localObject = (String)((Class)localObject).getMethod("get", new Class[] { String.class }).invoke(localObject, new Object[] { "qemu.hw.mainkeys" });
      i = Build.VERSION.SDK_INT;
      if (i < 21) {
        i = Settings.System.getInt(paramContext.getContentResolver(), "navigationbar_is_min", 0);
      } else {
        i = Settings.Global.getInt(paramContext.getContentResolver(), "navigationbar_is_min", 0);
      }
      if ((!"1".equals(localObject)) && (1 != i))
      {
        boolean bool2 = "0".equals(localObject);
        if (bool2) {
          return true;
        }
      }
      else
      {
        bool1 = false;
      }
      return bool1;
    }
    catch (Exception paramContext) {}
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.util.DisplayUtil
 * JD-Core Version:    0.7.0.1
 */
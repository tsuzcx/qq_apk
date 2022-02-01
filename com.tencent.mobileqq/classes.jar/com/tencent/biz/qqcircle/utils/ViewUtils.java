package com.tencent.biz.qqcircle.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.biz.richframework.delegate.impl.RFApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ViewUtils
{
  public static int a = 480;
  private static int b = -1;
  private static int c = -1;
  
  public static int a()
  {
    Resources localResources = RFApplication.getApplication().getResources();
    int i = localResources.getIdentifier("status_bar_height", "dimen", "android");
    if (i > 0) {
      return localResources.getDimensionPixelSize(i);
    }
    return 0;
  }
  
  public static int a(float paramFloat)
  {
    return (int)(paramFloat * RFApplication.getApplication().getResources().getDisplayMetrics().density + 0.5F);
  }
  
  public static int a(Context paramContext)
  {
    Object localObject = new DisplayMetrics();
    paramContext = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    try
    {
      int i;
      if (Build.VERSION.SDK_INT >= 17)
      {
        paramContext.getRealMetrics((DisplayMetrics)localObject);
        i = ((DisplayMetrics)localObject).heightPixels;
      }
      else
      {
        localObject = Display.class.getMethod("getRawHeight", new Class[0]);
        try
        {
          i = ((Integer)((Method)localObject).invoke(paramContext, new Object[0])).intValue();
        }
        catch (InvocationTargetException paramContext)
        {
          QLog.e("ViewUtils", 1, paramContext.getMessage());
          return -1;
        }
        catch (IllegalAccessException paramContext)
        {
          QLog.e("ViewUtils", 1, paramContext.getMessage());
          return -1;
        }
        catch (IllegalArgumentException paramContext)
        {
          QLog.e("ViewUtils", 1, paramContext.getMessage());
          return -1;
        }
      }
      return i;
    }
    catch (NoSuchMethodException paramContext)
    {
      QLog.e("ViewUtils", 1, paramContext.getMessage());
      return -1;
    }
  }
  
  public static int b()
  {
    if (b < 0) {
      if (RFApplication.getApplication().getResources().getConfiguration().orientation == 2) {
        b = RFApplication.getApplication().getResources().getDisplayMetrics().heightPixels;
      } else {
        b = RFApplication.getApplication().getResources().getDisplayMetrics().widthPixels;
      }
    }
    return b;
  }
  
  public static int b(float paramFloat)
  {
    return (int)(paramFloat * RFApplication.getApplication().getResources().getDisplayMetrics().scaledDensity + 0.5F);
  }
  
  public static float c(float paramFloat)
  {
    return paramFloat * DisplayUtil.b() / 160.0F;
  }
  
  public static int c()
  {
    if (c < 0) {
      if (RFApplication.getApplication().getResources().getConfiguration().orientation == 2) {
        c = RFApplication.getApplication().getResources().getDisplayMetrics().widthPixels;
      } else {
        c = RFApplication.getApplication().getResources().getDisplayMetrics().heightPixels;
      }
    }
    return c;
  }
  
  public static float d(float paramFloat)
  {
    if (paramFloat == 0.0F) {
      return 0.0F;
    }
    return (int)(paramFloat * Math.round(DisplayUtil.a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.utils.ViewUtils
 * JD-Core Version:    0.7.0.1
 */
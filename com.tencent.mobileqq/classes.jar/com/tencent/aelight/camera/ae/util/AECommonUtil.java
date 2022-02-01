package com.tencent.aelight.camera.ae.util;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.Display.Mode;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import com.tencent.aelight.camera.aioeditor.SystemUtil;
import com.tencent.aelight.camera.log.AEQLog;
import common.config.service.QzoneConfig;
import java.io.File;
import java.util.Arrays;

public class AECommonUtil
{
  private static int a(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException paramString)
    {
      paramString.printStackTrace();
    }
    return -2147483648;
  }
  
  public static boolean a()
  {
    return (b()) && (Build.VERSION.SDK_INT < 23);
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool3 = b();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      bool1 = bool2;
      if (paramContext != null)
      {
        if (Build.VERSION.SDK_INT <= 28) {
          return false;
        }
        DisplayMetrics localDisplayMetrics = new DisplayMetrics();
        paramContext = (WindowManager)paramContext.getSystemService("window");
        paramContext.getDefaultDisplay().getRealMetrics(localDisplayMetrics);
        bool1 = bool2;
        if (Math.max(localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels) < paramContext.getDefaultDisplay().getMode().getPhysicalHeight()) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(Context paramContext, File paramFile)
  {
    if ((paramFile != null) && (paramFile.getAbsolutePath() != null) && (paramContext != null)) {
      return paramFile.getAbsolutePath().contains(paramContext.getPackageName());
    }
    return false;
  }
  
  public static boolean a(Context paramContext, String paramString)
  {
    boolean bool = false;
    if (paramContext == null) {
      return false;
    }
    int i;
    try
    {
      i = Integer.parseInt(QzoneConfig.getAEAutoTemplateMemoryLimit());
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("parse auto template limit size error ");
      localStringBuilder.append(localException.getMessage());
      AEQLog.d(paramString, localStringBuilder.toString());
      i = 0;
    }
    if (i * 1024L * 1024L <= SystemUtil.a(paramContext)) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean a(View paramView, MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramView != null)
    {
      if (paramMotionEvent == null) {
        return false;
      }
      float f1 = paramMotionEvent.getRawX();
      float f2 = paramMotionEvent.getRawY();
      paramMotionEvent = new int[2];
      paramView.getLocationOnScreen(paramMotionEvent);
      int i = paramMotionEvent[0];
      int j = paramMotionEvent[1];
      int k = paramView.getMeasuredWidth();
      int m = paramView.getMeasuredHeight();
      bool1 = bool2;
      if (f2 >= j)
      {
        bool1 = bool2;
        if (f2 <= m + j)
        {
          bool1 = bool2;
          if (f1 >= i)
          {
            bool1 = bool2;
            if (f1 <= k + i) {
              bool1 = true;
            }
          }
        }
      }
    }
    return bool1;
  }
  
  public static boolean a(String paramString1, String paramString2)
  {
    if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty(paramString2)))
    {
      if (TextUtils.isEmpty("8.7.0")) {
        return false;
      }
      String[] arrayOfString1 = paramString1.split("\\.");
      String[] arrayOfString2 = paramString2.split("\\.");
      paramString1 = "8.7.0".split("\\.");
      int i = Math.min(arrayOfString1.length, Math.min(arrayOfString2.length, paramString1.length));
      paramString2 = a(arrayOfString1, i);
      arrayOfString1 = a(arrayOfString2, i);
      paramString1 = a(paramString1, i);
      i = 0;
      while (i < paramString1.length)
      {
        int j = a(paramString1[i]);
        if (paramString2.length <= i) {
          break;
        }
        if (arrayOfString1.length <= i) {
          return false;
        }
        int k = a(paramString2[i]);
        int m = a(arrayOfString1[i]);
        if (j < 0) {
          return false;
        }
        if (((j >= k) && (j < m)) || ((j < k) && (j >= m))) {
          return true;
        }
        if ((j != k) && (j != m)) {
          break;
        }
        if (i == paramString1.length - 1) {
          return true;
        }
        i += 1;
      }
    }
    return false;
  }
  
  private static String[] a(String[] paramArrayOfString, int paramInt)
  {
    String[] arrayOfString = paramArrayOfString;
    if (paramArrayOfString.length > paramInt) {
      arrayOfString = (String[])Arrays.copyOf(paramArrayOfString, paramInt);
    }
    return arrayOfString;
  }
  
  private static boolean b()
  {
    return (Build.MANUFACTURER != null) && ("oppo".equals(Build.MANUFACTURER.toLowerCase()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.util.AECommonUtil
 * JD-Core Version:    0.7.0.1
 */
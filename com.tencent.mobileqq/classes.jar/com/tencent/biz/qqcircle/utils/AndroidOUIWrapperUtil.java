package com.tencent.biz.qqcircle.utils;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AndroidOUIWrapperUtil
{
  public static boolean a(Activity paramActivity)
  {
    int i = Build.VERSION.SDK_INT;
    boolean bool1 = false;
    if (i != 26) {
      return false;
    }
    try
    {
      Object localObject = paramActivity.obtainStyledAttributes((int[])Class.forName("com.android.internal.R$styleable").getField("Window").get(null));
      paramActivity = ActivityInfo.class.getMethod("isTranslucentOrFloating", new Class[] { TypedArray.class });
      paramActivity.setAccessible(true);
      localObject = paramActivity.invoke(null, new Object[] { localObject });
      if ((localObject instanceof Boolean))
      {
        boolean bool2 = ((Boolean)localObject).booleanValue();
        bool1 = bool2;
      }
      else
      {
        bool1 = false;
      }
      try
      {
        paramActivity.setAccessible(false);
        return bool1;
      }
      catch (Exception paramActivity) {}
      paramActivity.printStackTrace();
    }
    catch (Exception paramActivity) {}
    return bool1;
  }
  
  public static void b(Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT != 26) {
      return;
    }
    try
    {
      Field localField = Activity.class.getDeclaredField("mActivityInfo");
      localField.setAccessible(true);
      ((ActivityInfo)localField.get(paramActivity)).screenOrientation = -1;
      localField.setAccessible(false);
      return;
    }
    catch (Exception paramActivity)
    {
      paramActivity.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.utils.AndroidOUIWrapperUtil
 * JD-Core Version:    0.7.0.1
 */